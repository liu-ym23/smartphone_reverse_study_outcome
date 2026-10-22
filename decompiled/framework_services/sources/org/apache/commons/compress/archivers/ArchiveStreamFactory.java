package org.apache.commons.compress.archivers;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.security.AccessController;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.Locale;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;
import org.apache.commons.compress.archivers.ar.ArArchiveInputStream;
import org.apache.commons.compress.archivers.ar.ArArchiveOutputStream;
import org.apache.commons.compress.archivers.arj.ArjArchiveInputStream;
import org.apache.commons.compress.archivers.cpio.CpioArchiveInputStream;
import org.apache.commons.compress.archivers.cpio.CpioArchiveOutputStream;
import org.apache.commons.compress.archivers.dump.DumpArchiveInputStream;
import org.apache.commons.compress.archivers.jar.JarArchiveInputStream;
import org.apache.commons.compress.archivers.jar.JarArchiveOutputStream;
import org.apache.commons.compress.archivers.sevenz.SevenZFile;
import org.apache.commons.compress.archivers.tar.TarArchiveInputStream;
import org.apache.commons.compress.archivers.tar.TarArchiveOutputStream;
import org.apache.commons.compress.archivers.zip.ZipArchiveInputStream;
import org.apache.commons.compress.archivers.zip.ZipArchiveOutputStream;
import org.apache.commons.compress.utils.IOUtils;
import org.apache.commons.compress.utils.Lists;
import org.apache.commons.compress.utils.ServiceLoaderIterator;
import org.apache.commons.compress.utils.Sets;

/* JADX INFO: loaded from: classes3.dex */
public class ArchiveStreamFactory implements ArchiveStreamProvider {
    public static final String AR = "ar";
    public static final String ARJ = "arj";
    public static final String CPIO = "cpio";
    public static final String DUMP = "dump";
    private static final int DUMP_SIGNATURE_SIZE = 32;
    public static final String JAR = "jar";
    public static final String SEVEN_Z = "7z";
    private static final int SIGNATURE_SIZE = 12;
    private static final ArchiveStreamFactory SINGLETON = null;
    public static final String TAR = "tar";
    private static final int TAR_HEADER_SIZE = 512;
    public static final String ZIP = "zip";
    private SortedMap<String, ArchiveStreamProvider> archiveInputStreamProviders;
    private SortedMap<String, ArchiveStreamProvider> archiveOutputStreamProviders;
    private final String encoding;
    private volatile String entryEncoding;

    static /* synthetic */ ArchiveStreamFactory access$000() {
        return SINGLETON;
    }

    static /* synthetic */ ArrayList access$100() {
        return findArchiveStreamProviders();
    }

    static {
        SINGLETON = new ArchiveStreamFactory();
    }

    private static ArrayList<ArchiveStreamProvider> findArchiveStreamProviders() {
        return Lists.newArrayList(serviceLoaderIterator());
    }

    static void putAll(Set<String> names, ArchiveStreamProvider provider, TreeMap<String, ArchiveStreamProvider> map) {
        Iterator<String> r0 = names.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        String name = r0.next();
        map.put(toKey(name), provider);
        goto L4
    }

    private static Iterator<ArchiveStreamProvider> serviceLoaderIterator() {
        return new ServiceLoaderIterator(ArchiveStreamProvider.class);
    }

    private static String toKey(String name) {
        return name.toUpperCase(Locale.ROOT);
    }

    public static SortedMap<String, ArchiveStreamProvider> findAvailableArchiveInputStreamProviders() {
        return (SortedMap) AccessController.doPrivileged(new AnonymousClass1());
    }

    public static SortedMap<String, ArchiveStreamProvider> findAvailableArchiveOutputStreamProviders() {
        return (SortedMap) AccessController.doPrivileged(new AnonymousClass2());
    }

    public ArchiveStreamFactory() {
        this(null);
    }

    public ArchiveStreamFactory(String encoding) {
        this.encoding = encoding;
        this.entryEncoding = encoding;
    }

    public String getEntryEncoding() {
        return this.entryEncoding;
    }

    @Deprecated
    public void setEntryEncoding(String entryEncoding) {
        if (this.encoding != null) goto L7;
        this.entryEncoding = entryEncoding;
        return;
    L7:
        throw new IllegalStateException("Cannot overide encoding set by the constructor");
    }

    public ArchiveInputStream createArchiveInputStream(String archiverName, InputStream in) throws ArchiveException {
        return createArchiveInputStream(archiverName, in, this.entryEncoding);
    }

    @Override // org.apache.commons.compress.archivers.ArchiveStreamProvider
    public ArchiveInputStream createArchiveInputStream(String archiverName, InputStream in, String actualEncoding) throws ArchiveException {
        if (archiverName == null) goto L63;
        if (in == null) goto L61;
        if (AR.equalsIgnoreCase(archiverName) == false) goto L9;
        return new ArArchiveInputStream(in);
    L9:
        if (ARJ.equalsIgnoreCase(archiverName) == false) goto L16;
        if (actualEncoding == null) goto L14;
        return new ArjArchiveInputStream(in, actualEncoding);
    L14:
        return new ArjArchiveInputStream(in);
    L16:
        if (ZIP.equalsIgnoreCase(archiverName) == false) goto L23;
        if (actualEncoding == null) goto L21;
        return new ZipArchiveInputStream(in, actualEncoding);
    L21:
        return new ZipArchiveInputStream(in);
    L23:
        if (TAR.equalsIgnoreCase(archiverName) == false) goto L30;
        if (actualEncoding == null) goto L28;
        return new TarArchiveInputStream(in, actualEncoding);
    L28:
        return new TarArchiveInputStream(in);
    L30:
        if (JAR.equalsIgnoreCase(archiverName) == false) goto L37;
        if (actualEncoding == null) goto L35;
        return new JarArchiveInputStream(in, actualEncoding);
    L35:
        return new JarArchiveInputStream(in);
    L37:
        if (CPIO.equalsIgnoreCase(archiverName) == false) goto L44;
        if (actualEncoding == null) goto L42;
        return new CpioArchiveInputStream(in, actualEncoding);
    L42:
        return new CpioArchiveInputStream(in);
    L44:
        if (DUMP.equalsIgnoreCase(archiverName) == false) goto L51;
        if (actualEncoding == null) goto L49;
        return new DumpArchiveInputStream(in, actualEncoding);
    L49:
        return new DumpArchiveInputStream(in);
    L51:
        if (SEVEN_Z.equalsIgnoreCase(archiverName) == true) goto L59;
        ArchiveStreamProvider archiveStreamProvider = getArchiveInputStreamProviders().get(toKey(archiverName));
        if (archiveStreamProvider == null) goto L57;
        return archiveStreamProvider.createArchiveInputStream(archiverName, in, actualEncoding);
    L57:
        throw new ArchiveException("Archiver: " + archiverName + " not found.");
    L59:
        throw new StreamingNotSupportedException(SEVEN_Z);
    L61:
        throw new IllegalArgumentException("InputStream must not be null.");
    L63:
        throw new IllegalArgumentException("Archivername must not be null.");
    }

    public ArchiveOutputStream createArchiveOutputStream(String archiverName, OutputStream out) throws ArchiveException {
        return createArchiveOutputStream(archiverName, out, this.entryEncoding);
    }

    @Override // org.apache.commons.compress.archivers.ArchiveStreamProvider
    public ArchiveOutputStream createArchiveOutputStream(String archiverName, OutputStream out, String actualEncoding) throws ArchiveException {
        if (archiverName == null) goto L48;
        if (out == null) goto L46;
        if (AR.equalsIgnoreCase(archiverName) == false) goto L9;
        return new ArArchiveOutputStream(out);
    L9:
        if (ZIP.equalsIgnoreCase(archiverName) == false) goto L15;
        ZipArchiveOutputStream zip = new ZipArchiveOutputStream(out);
        if (actualEncoding == null) goto L13;
        zip.setEncoding(actualEncoding);
    L13:
        return zip;
    L15:
        if (TAR.equalsIgnoreCase(archiverName) == false) goto L22;
        if (actualEncoding == null) goto L20;
        return new TarArchiveOutputStream(out, actualEncoding);
    L20:
        return new TarArchiveOutputStream(out);
    L22:
        if (JAR.equalsIgnoreCase(archiverName) == false) goto L29;
        if (actualEncoding == null) goto L27;
        return new JarArchiveOutputStream(out, actualEncoding);
    L27:
        return new JarArchiveOutputStream(out);
    L29:
        if (CPIO.equalsIgnoreCase(archiverName) == false) goto L36;
        if (actualEncoding == null) goto L34;
        return new CpioArchiveOutputStream(out, actualEncoding);
    L34:
        return new CpioArchiveOutputStream(out);
    L36:
        if (SEVEN_Z.equalsIgnoreCase(archiverName) == true) goto L44;
        ArchiveStreamProvider archiveStreamProvider = getArchiveOutputStreamProviders().get(toKey(archiverName));
        if (archiveStreamProvider == null) goto L42;
        return archiveStreamProvider.createArchiveOutputStream(archiverName, out, actualEncoding);
    L42:
        throw new ArchiveException("Archiver: " + archiverName + " not found.");
    L44:
        throw new StreamingNotSupportedException(SEVEN_Z);
    L46:
        throw new IllegalArgumentException("OutputStream must not be null.");
    L48:
        throw new IllegalArgumentException("Archivername must not be null.");
    }

    public ArchiveInputStream createArchiveInputStream(InputStream in) throws ArchiveException {
        return createArchiveInputStream(detect(in), in);
    }

    public static String detect(InputStream in) throws ArchiveException {
        if (in == null) goto L69;
        if (in.markSupported() == false) goto L67;
        byte[] signature = new byte[12];
        in.mark(signature.length);
        int signatureLength = IOUtils.readFully(in, signature);     // Catch: IOException -> L63
        in.reset();     // Catch: IOException -> L63
        if (ZipArchiveInputStream.matches(signature, signatureLength) == false) goto L12;
        return ZIP;
    L12:
        if (JarArchiveInputStream.matches(signature, signatureLength) == false) goto L16;
        return JAR;
    L16:
        if (ArArchiveInputStream.matches(signature, signatureLength) == false) goto L20;
        return AR;
    L20:
        if (CpioArchiveInputStream.matches(signature, signatureLength) == false) goto L24;
        return CPIO;
    L24:
        if (ArjArchiveInputStream.matches(signature, signatureLength) == false) goto L28;
        return ARJ;
    L28:
        if (SevenZFile.matches(signature, signatureLength) == false) goto L31;
        return SEVEN_Z;
    L31:
        byte[] dumpsig = new byte[32];
        in.mark(dumpsig.length);
        int signatureLength2 = IOUtils.readFully(in, dumpsig);     // Catch: IOException -> L60
        in.reset();     // Catch: IOException -> L60
        if (DumpArchiveInputStream.matches(dumpsig, signatureLength2) == false) goto L37;
        return DUMP;
    L37:
        byte[] tarHeader = new byte[512];
        in.mark(tarHeader.length);
        int signatureLength3 = IOUtils.readFully(in, tarHeader);     // Catch: IOException -> L57
        in.reset();     // Catch: IOException -> L57
        if (TarArchiveInputStream.matches(tarHeader, signatureLength3) == false) goto L42;
        return TAR;
    L42:
        if (signatureLength3 < 512) goto L56;
        TarArchiveInputStream tais = null;
        tais = new TarArchiveInputStream(new ByteArrayInputStream(tarHeader));     // Catch: Throwable -> L49 Exception -> L51
        if (tais.getNextTarEntry().isCheckSumOK() == false) goto L48;
        IOUtils.closeQuietly(tais);
        return TAR;
    L49:
        th = move-exception;
        IOUtils.closeQuietly(tais);
        throw th;
    L48:
        IOUtils.closeQuietly(tais);
    L56:
        throw new ArchiveException("No Archiver found for the stream signature");
    L57:
        e = move-exception;
        throw new ArchiveException("IOException while reading tar signature", e);
    L60:
        e = move-exception;
        throw new ArchiveException("IOException while reading dump signature", e);
    L63:
        e = move-exception;
        throw new ArchiveException("IOException while reading signature.", e);
    L67:
        throw new IllegalArgumentException("Mark is not supported.");
    L69:
        throw new IllegalArgumentException("Stream must not be null.");
    }

    public SortedMap<String, ArchiveStreamProvider> getArchiveInputStreamProviders() {
        if (this.archiveInputStreamProviders != null) goto L6;
        this.archiveInputStreamProviders = Collections.unmodifiableSortedMap(findAvailableArchiveInputStreamProviders());
    L6:
        return this.archiveInputStreamProviders;
    }

    public SortedMap<String, ArchiveStreamProvider> getArchiveOutputStreamProviders() {
        if (this.archiveOutputStreamProviders != null) goto L6;
        this.archiveOutputStreamProviders = Collections.unmodifiableSortedMap(findAvailableArchiveOutputStreamProviders());
    L6:
        return this.archiveOutputStreamProviders;
    }

    @Override // org.apache.commons.compress.archivers.ArchiveStreamProvider
    public Set<String> getInputStreamArchiveNames() {
        return Sets.newHashSet(new String[]{AR, ARJ, ZIP, TAR, JAR, CPIO, DUMP, SEVEN_Z});
    }

    @Override // org.apache.commons.compress.archivers.ArchiveStreamProvider
    public Set<String> getOutputStreamArchiveNames() {
        return Sets.newHashSet(new String[]{AR, ZIP, TAR, JAR, CPIO, SEVEN_Z});
    }
}
