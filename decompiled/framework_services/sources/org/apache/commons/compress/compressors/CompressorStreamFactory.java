package org.apache.commons.compress.compressors;

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
import org.apache.commons.compress.compressors.brotli.BrotliCompressorInputStream;
import org.apache.commons.compress.compressors.brotli.BrotliUtils;
import org.apache.commons.compress.compressors.bzip2.BZip2CompressorInputStream;
import org.apache.commons.compress.compressors.bzip2.BZip2CompressorOutputStream;
import org.apache.commons.compress.compressors.deflate.DeflateCompressorInputStream;
import org.apache.commons.compress.compressors.deflate.DeflateCompressorOutputStream;
import org.apache.commons.compress.compressors.deflate64.Deflate64CompressorInputStream;
import org.apache.commons.compress.compressors.gzip.GzipCompressorInputStream;
import org.apache.commons.compress.compressors.gzip.GzipCompressorOutputStream;
import org.apache.commons.compress.compressors.lz4.BlockLZ4CompressorInputStream;
import org.apache.commons.compress.compressors.lz4.BlockLZ4CompressorOutputStream;
import org.apache.commons.compress.compressors.lz4.FramedLZ4CompressorInputStream;
import org.apache.commons.compress.compressors.lz4.FramedLZ4CompressorOutputStream;
import org.apache.commons.compress.compressors.lzma.LZMACompressorInputStream;
import org.apache.commons.compress.compressors.lzma.LZMACompressorOutputStream;
import org.apache.commons.compress.compressors.lzma.LZMAUtils;
import org.apache.commons.compress.compressors.pack200.Pack200CompressorInputStream;
import org.apache.commons.compress.compressors.pack200.Pack200CompressorOutputStream;
import org.apache.commons.compress.compressors.snappy.FramedSnappyCompressorInputStream;
import org.apache.commons.compress.compressors.snappy.FramedSnappyCompressorOutputStream;
import org.apache.commons.compress.compressors.snappy.SnappyCompressorInputStream;
import org.apache.commons.compress.compressors.xz.XZCompressorInputStream;
import org.apache.commons.compress.compressors.xz.XZCompressorOutputStream;
import org.apache.commons.compress.compressors.xz.XZUtils;
import org.apache.commons.compress.compressors.z.ZCompressorInputStream;
import org.apache.commons.compress.compressors.zstandard.ZstdCompressorInputStream;
import org.apache.commons.compress.compressors.zstandard.ZstdCompressorOutputStream;
import org.apache.commons.compress.compressors.zstandard.ZstdUtils;
import org.apache.commons.compress.utils.IOUtils;
import org.apache.commons.compress.utils.Lists;
import org.apache.commons.compress.utils.ServiceLoaderIterator;
import org.apache.commons.compress.utils.Sets;

/* JADX INFO: loaded from: classes3.dex */
public class CompressorStreamFactory implements CompressorStreamProvider {
    public static final String BROTLI = "br";
    public static final String BZIP2 = "bzip2";
    public static final String DEFLATE = "deflate";
    public static final String DEFLATE64 = "deflate64";
    public static final String GZIP = "gz";
    public static final String LZ4_BLOCK = "lz4-block";
    public static final String LZ4_FRAMED = "lz4-framed";
    public static final String LZMA = "lzma";
    public static final String PACK200 = "pack200";
    private static final CompressorStreamFactory SINGLETON = null;
    public static final String SNAPPY_FRAMED = "snappy-framed";
    public static final String SNAPPY_RAW = "snappy-raw";
    public static final String XZ = "xz";
    private static final String YOU_NEED_BROTLI_DEC = null;
    private static final String YOU_NEED_XZ_JAVA = null;
    private static final String YOU_NEED_ZSTD_JNI = null;
    public static final String Z = "z";
    public static final String ZSTANDARD = "zstd";
    private SortedMap<String, CompressorStreamProvider> compressorInputStreamProviders;
    private SortedMap<String, CompressorStreamProvider> compressorOutputStreamProviders;
    private volatile boolean decompressConcatenated;
    private final Boolean decompressUntilEOF;
    private final int memoryLimitInKb;

    static /* synthetic */ CompressorStreamFactory access$000() {
        return SINGLETON;
    }

    static /* synthetic */ ArrayList access$100() {
        return findCompressorStreamProviders();
    }

    static {
        SINGLETON = new CompressorStreamFactory();
        YOU_NEED_BROTLI_DEC = youNeed("Google Brotli Dec", "https://github.com/google/brotli/");
        YOU_NEED_XZ_JAVA = youNeed("XZ for Java", "https://tukaani.org/xz/java.html");
        YOU_NEED_ZSTD_JNI = youNeed("Zstd JNI", "https://github.com/luben/zstd-jni");
    }

    private static String youNeed(String name, String url) {
        return " In addition to Apache Commons Compress you need the " + name + " library - see " + url;
    }

    public static SortedMap<String, CompressorStreamProvider> findAvailableCompressorInputStreamProviders() {
        return (SortedMap) AccessController.doPrivileged(new AnonymousClass1());
    }

    public static SortedMap<String, CompressorStreamProvider> findAvailableCompressorOutputStreamProviders() {
        return (SortedMap) AccessController.doPrivileged(new AnonymousClass2());
    }

    private static ArrayList<CompressorStreamProvider> findCompressorStreamProviders() {
        return Lists.newArrayList(serviceLoaderIterator());
    }

    public static String getBrotli() {
        return BROTLI;
    }

    public static String getBzip2() {
        return BZIP2;
    }

    public static String getDeflate() {
        return DEFLATE;
    }

    public static String getDeflate64() {
        return DEFLATE64;
    }

    public static String getGzip() {
        return GZIP;
    }

    public static String getLzma() {
        return LZMA;
    }

    public static String getPack200() {
        return PACK200;
    }

    public static CompressorStreamFactory getSingleton() {
        return SINGLETON;
    }

    public static String getSnappyFramed() {
        return SNAPPY_FRAMED;
    }

    public static String getSnappyRaw() {
        return SNAPPY_RAW;
    }

    public static String getXz() {
        return XZ;
    }

    public static String getZ() {
        return Z;
    }

    public static String getLZ4Framed() {
        return LZ4_FRAMED;
    }

    public static String getLZ4Block() {
        return LZ4_BLOCK;
    }

    public static String getZstandard() {
        return ZSTANDARD;
    }

    static void putAll(Set<String> names, CompressorStreamProvider provider, TreeMap<String, CompressorStreamProvider> map) {
        Iterator<String> r0 = names.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        String name = r0.next();
        map.put(toKey(name), provider);
        goto L4
    }

    private static Iterator<CompressorStreamProvider> serviceLoaderIterator() {
        return new ServiceLoaderIterator(CompressorStreamProvider.class);
    }

    private static String toKey(String name) {
        return name.toUpperCase(Locale.ROOT);
    }

    public CompressorStreamFactory() {
        this.decompressConcatenated = false;
        this.decompressUntilEOF = null;
        this.memoryLimitInKb = -1;
    }

    public CompressorStreamFactory(boolean decompressUntilEOF, int memoryLimitInKb) {
        this.decompressConcatenated = false;
        this.decompressUntilEOF = Boolean.valueOf(decompressUntilEOF);
        this.decompressConcatenated = decompressUntilEOF;
        this.memoryLimitInKb = memoryLimitInKb;
    }

    public CompressorStreamFactory(boolean decompressUntilEOF) {
        this(decompressUntilEOF, -1);
    }

    public static String detect(InputStream in) throws CompressorException {
        if (in == null) goto L55;
        if (in.markSupported() == false) goto L53;
        byte[] signature = new byte[12];
        in.mark(signature.length);
        int signatureLength = IOUtils.readFully(in, signature);     // Catch: IOException -> L49
        in.reset();     // Catch: IOException -> L49
        if (BZip2CompressorInputStream.matches(signature, signatureLength) == false) goto L12;
        return BZIP2;
    L12:
        if (GzipCompressorInputStream.matches(signature, signatureLength) == false) goto L16;
        return GZIP;
    L16:
        if (Pack200CompressorInputStream.matches(signature, signatureLength) == false) goto L20;
        return PACK200;
    L20:
        if (FramedSnappyCompressorInputStream.matches(signature, signatureLength) == false) goto L24;
        return SNAPPY_FRAMED;
    L24:
        if (ZCompressorInputStream.matches(signature, signatureLength) == false) goto L28;
        return Z;
    L28:
        if (DeflateCompressorInputStream.matches(signature, signatureLength) == false) goto L32;
        return DEFLATE;
    L32:
        if (XZUtils.matches(signature, signatureLength) == false) goto L36;
        return XZ;
    L36:
        if (LZMAUtils.matches(signature, signatureLength) == false) goto L40;
        return LZMA;
    L40:
        if (FramedLZ4CompressorInputStream.matches(signature, signatureLength) == false) goto L44;
        return LZ4_FRAMED;
    L44:
        if (ZstdUtils.matches(signature, signatureLength) == false) goto L48;
        return ZSTANDARD;
    L48:
        throw new CompressorException("No Compressor found for the stream signature.");
    L49:
        e = move-exception;
        throw new CompressorException("IOException while reading signature.", e);
    L53:
        throw new IllegalArgumentException("Mark is not supported.");
    L55:
        throw new IllegalArgumentException("Stream must not be null.");
    }

    public CompressorInputStream createCompressorInputStream(InputStream in) throws CompressorException {
        return createCompressorInputStream(detect(in), in);
    }

    public CompressorInputStream createCompressorInputStream(String name, InputStream in) throws CompressorException {
        return createCompressorInputStream(name, in, this.decompressConcatenated);
    }

    @Override // org.apache.commons.compress.compressors.CompressorStreamProvider
    public CompressorInputStream createCompressorInputStream(String name, InputStream in, boolean actualDecompressConcatenated) throws CompressorException {
        if (name == null) goto L87;
        if (in == null) goto L87;
    L8:
        e = move-exception;
        throw new CompressorException("Could not create CompressorInputStream.", e);
    L5:
        if (GZIP.equalsIgnoreCase(name) == false) goto L11;
        return new GzipCompressorInputStream(in, actualDecompressConcatenated);
    L11:
        if (BZIP2.equalsIgnoreCase(name) == false) goto L15;
        return new BZip2CompressorInputStream(in, actualDecompressConcatenated);
    L15:
        if (BROTLI.equalsIgnoreCase(name) == false) goto L23;
        if (BrotliUtils.isBrotliCompressionAvailable() == false) goto L21;
        return new BrotliCompressorInputStream(in);
    L21:
        throw new CompressorException("Brotli compression is not available." + YOU_NEED_BROTLI_DEC);     // Catch: IOException -> L8
    L23:
        if (XZ.equalsIgnoreCase(name) == false) goto L31;
        if (XZUtils.isXZCompressionAvailable() == false) goto L29;
        return new XZCompressorInputStream(in, actualDecompressConcatenated, this.memoryLimitInKb);
    L29:
        throw new CompressorException("XZ compression is not available." + YOU_NEED_XZ_JAVA);     // Catch: IOException -> L8
    L31:
        if (ZSTANDARD.equalsIgnoreCase(name) == false) goto L39;
        if (ZstdUtils.isZstdCompressionAvailable() == false) goto L37;
        return new ZstdCompressorInputStream(in);
    L37:
        throw new CompressorException("Zstandard compression is not available." + YOU_NEED_ZSTD_JNI);     // Catch: IOException -> L8
    L39:
        if (LZMA.equalsIgnoreCase(name) == false) goto L47;
        if (LZMAUtils.isLZMACompressionAvailable() == false) goto L45;
        return new LZMACompressorInputStream(in, this.memoryLimitInKb);
    L45:
        throw new CompressorException("LZMA compression is not available" + YOU_NEED_XZ_JAVA);     // Catch: IOException -> L8
    L47:
        if (PACK200.equalsIgnoreCase(name) == false) goto L51;
        return new Pack200CompressorInputStream(in);
    L51:
        if (SNAPPY_RAW.equalsIgnoreCase(name) == false) goto L55;
        return new SnappyCompressorInputStream(in);
    L55:
        if (SNAPPY_FRAMED.equalsIgnoreCase(name) == false) goto L59;
        return new FramedSnappyCompressorInputStream(in);
    L59:
        if (Z.equalsIgnoreCase(name) == false) goto L63;
        return new ZCompressorInputStream(in, this.memoryLimitInKb);
    L63:
        if (DEFLATE.equalsIgnoreCase(name) == false) goto L67;
        return new DeflateCompressorInputStream(in);
    L67:
        if (DEFLATE64.equalsIgnoreCase(name) == false) goto L71;
        return new Deflate64CompressorInputStream(in);
    L71:
        if (LZ4_BLOCK.equalsIgnoreCase(name) == false) goto L75;
        return new BlockLZ4CompressorInputStream(in);
    L75:
        if (LZ4_FRAMED.equalsIgnoreCase(name) == true) goto L77;
        CompressorStreamProvider compressorStreamProvider = getCompressorInputStreamProviders().get(toKey(name));
        if (compressorStreamProvider == null) goto L83;
        return compressorStreamProvider.createCompressorInputStream(name, in, actualDecompressConcatenated);
    L83:
        throw new CompressorException("Compressor: " + name + " not found.");
    L77:
        return new FramedLZ4CompressorInputStream(in, actualDecompressConcatenated);
    L87:
        throw new IllegalArgumentException("Compressor name and stream must not be null.");
    }

    @Override // org.apache.commons.compress.compressors.CompressorStreamProvider
    public CompressorOutputStream createCompressorOutputStream(String name, OutputStream out) throws CompressorException {
        if (name == null) goto L55;
        if (out == null) goto L55;
    L8:
        e = move-exception;
        throw new CompressorException("Could not create CompressorOutputStream", e);
    L5:
        if (GZIP.equalsIgnoreCase(name) == false) goto L11;
        return new GzipCompressorOutputStream(out);
    L11:
        if (BZIP2.equalsIgnoreCase(name) == false) goto L15;
        return new BZip2CompressorOutputStream(out);
    L15:
        if (XZ.equalsIgnoreCase(name) == false) goto L19;
        return new XZCompressorOutputStream(out);
    L19:
        if (PACK200.equalsIgnoreCase(name) == false) goto L23;
        return new Pack200CompressorOutputStream(out);
    L23:
        if (LZMA.equalsIgnoreCase(name) == false) goto L27;
        return new LZMACompressorOutputStream(out);
    L27:
        if (DEFLATE.equalsIgnoreCase(name) == false) goto L31;
        return new DeflateCompressorOutputStream(out);
    L31:
        if (SNAPPY_FRAMED.equalsIgnoreCase(name) == false) goto L35;
        return new FramedSnappyCompressorOutputStream(out);
    L35:
        if (LZ4_BLOCK.equalsIgnoreCase(name) == false) goto L39;
        return new BlockLZ4CompressorOutputStream(out);
    L39:
        if (LZ4_FRAMED.equalsIgnoreCase(name) == false) goto L43;
        return new FramedLZ4CompressorOutputStream(out);
    L43:
        if (ZSTANDARD.equalsIgnoreCase(name) == true) goto L45;
        CompressorStreamProvider compressorStreamProvider = getCompressorOutputStreamProviders().get(toKey(name));
        if (compressorStreamProvider == null) goto L51;
        return compressorStreamProvider.createCompressorOutputStream(name, out);
    L51:
        throw new CompressorException("Compressor: " + name + " not found.");
    L45:
        return new ZstdCompressorOutputStream(out);
    L55:
        throw new IllegalArgumentException("Compressor name and stream must not be null.");
    }

    public SortedMap<String, CompressorStreamProvider> getCompressorInputStreamProviders() {
        if (this.compressorInputStreamProviders != null) goto L6;
        this.compressorInputStreamProviders = Collections.unmodifiableSortedMap(findAvailableCompressorInputStreamProviders());
    L6:
        return this.compressorInputStreamProviders;
    }

    public SortedMap<String, CompressorStreamProvider> getCompressorOutputStreamProviders() {
        if (this.compressorOutputStreamProviders != null) goto L6;
        this.compressorOutputStreamProviders = Collections.unmodifiableSortedMap(findAvailableCompressorOutputStreamProviders());
    L6:
        return this.compressorOutputStreamProviders;
    }

    boolean getDecompressConcatenated() {
        return this.decompressConcatenated;
    }

    public Boolean getDecompressUntilEOF() {
        return this.decompressUntilEOF;
    }

    @Override // org.apache.commons.compress.compressors.CompressorStreamProvider
    public Set<String> getInputStreamCompressorNames() {
        return Sets.newHashSet(new String[]{GZIP, BROTLI, BZIP2, XZ, LZMA, PACK200, DEFLATE, SNAPPY_RAW, SNAPPY_FRAMED, Z, LZ4_BLOCK, LZ4_FRAMED, ZSTANDARD, DEFLATE64});
    }

    @Override // org.apache.commons.compress.compressors.CompressorStreamProvider
    public Set<String> getOutputStreamCompressorNames() {
        return Sets.newHashSet(new String[]{GZIP, BZIP2, XZ, LZMA, PACK200, DEFLATE, SNAPPY_FRAMED, LZ4_BLOCK, LZ4_FRAMED, ZSTANDARD});
    }

    @Deprecated
    public void setDecompressConcatenated(boolean decompressConcatenated) {
        if (this.decompressUntilEOF != null) goto L7;
        this.decompressConcatenated = decompressConcatenated;
        return;
    L7:
        throw new IllegalStateException("Cannot override the setting defined by the constructor");
    }
}
