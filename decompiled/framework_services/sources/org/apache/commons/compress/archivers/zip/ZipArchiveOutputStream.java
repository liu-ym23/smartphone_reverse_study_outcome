package org.apache.commons.compress.archivers.zip;

import com.android.server.policy.EventLogTags;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.SeekableByteChannel;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;
import java.nio.file.attribute.FileAttribute;
import java.util.Calendar;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.zip.Deflater;
import java.util.zip.ZipException;
import org.apache.commons.compress.archivers.ArchiveEntry;
import org.apache.commons.compress.archivers.ArchiveOutputStream;
import org.apache.commons.compress.utils.IOUtils;

/* JADX INFO: loaded from: classes3.dex */
public class ZipArchiveOutputStream extends ArchiveOutputStream {
    static final int BUFFER_SIZE = 512;
    private static final int CFH_COMMENT_LENGTH_OFFSET = 32;
    private static final int CFH_COMPRESSED_SIZE_OFFSET = 20;
    private static final int CFH_CRC_OFFSET = 16;
    private static final int CFH_DISK_NUMBER_OFFSET = 34;
    private static final int CFH_EXTERNAL_ATTRIBUTES_OFFSET = 38;
    private static final int CFH_EXTRA_LENGTH_OFFSET = 30;
    private static final int CFH_FILENAME_LENGTH_OFFSET = 28;
    private static final int CFH_FILENAME_OFFSET = 46;
    private static final int CFH_GPB_OFFSET = 8;
    private static final int CFH_INTERNAL_ATTRIBUTES_OFFSET = 36;
    private static final int CFH_LFH_OFFSET = 42;
    private static final int CFH_METHOD_OFFSET = 10;
    private static final int CFH_ORIGINAL_SIZE_OFFSET = 24;
    static final byte[] CFH_SIG = null;
    private static final int CFH_SIG_OFFSET = 0;
    private static final int CFH_TIME_OFFSET = 12;
    private static final int CFH_VERSION_MADE_BY_OFFSET = 4;
    private static final int CFH_VERSION_NEEDED_OFFSET = 6;
    static final byte[] DD_SIG = null;
    public static final int DEFAULT_COMPRESSION = -1;
    static final String DEFAULT_ENCODING = "UTF8";
    public static final int DEFLATED = 8;

    @Deprecated
    public static final int EFS_FLAG = 2048;
    private static final byte[] EMPTY = null;
    static final byte[] EOCD_SIG = null;
    private static final int LFH_COMPRESSED_SIZE_OFFSET = 18;
    private static final int LFH_CRC_OFFSET = 14;
    private static final int LFH_EXTRA_LENGTH_OFFSET = 28;
    private static final int LFH_FILENAME_LENGTH_OFFSET = 26;
    private static final int LFH_FILENAME_OFFSET = 30;
    private static final int LFH_GPB_OFFSET = 6;
    private static final int LFH_METHOD_OFFSET = 8;
    private static final int LFH_ORIGINAL_SIZE_OFFSET = 22;
    static final byte[] LFH_SIG = null;
    private static final int LFH_SIG_OFFSET = 0;
    private static final int LFH_TIME_OFFSET = 10;
    private static final int LFH_VERSION_NEEDED_OFFSET = 4;
    private static final byte[] LZERO = null;
    private static final byte[] ONE = null;
    public static final int STORED = 0;
    private static final byte[] ZERO = null;
    static final byte[] ZIP64_EOCD_LOC_SIG = null;
    static final byte[] ZIP64_EOCD_SIG = null;
    private final Calendar calendarInstance;
    private long cdLength;
    private long cdOffset;
    private final SeekableByteChannel channel;
    private String comment;
    private final byte[] copyBuffer;
    private UnicodeExtraFieldPolicy createUnicodeExtraFields;
    protected final Deflater def;
    private String encoding;
    private final List<ZipArchiveEntry> entries;
    private CurrentEntry entry;
    private boolean fallbackToUTF8;
    protected boolean finished;
    private boolean hasCompressionLevelChanged;
    private boolean hasUsedZip64;
    private int level;
    private final Map<ZipArchiveEntry, EntryMetaData> metaData;
    private int method;
    private final OutputStream out;
    private final StreamCompressor streamCompressor;
    private boolean useUTF8Flag;
    private Zip64Mode zip64Mode;
    private ZipEncoding zipEncoding;

    /* JADX INFO: renamed from: org.apache.commons.compress.archivers.zip.ZipArchiveOutputStream$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    private static final class CurrentEntry {
        private long bytesRead;
        private boolean causedUseOfZip64;
        private long dataStart;
        private final ZipArchiveEntry entry;
        private boolean hasWritten;
        private long localDataStart;

        /* synthetic */ CurrentEntry(ZipArchiveEntry x0, AnonymousClass1 x1) {
            this(x0);
        }

        static /* synthetic */ long access$000(CurrentEntry x0) {
            return x0.dataStart;
        }

        static /* synthetic */ long access$002(CurrentEntry x0, long x1) {
            x0.dataStart = x1;
            return x1;
        }

        static /* synthetic */ long access$100(CurrentEntry x0) {
            return x0.bytesRead;
        }

        static /* synthetic */ long access$102(CurrentEntry x0, long x1) {
            x0.bytesRead = x1;
            return x1;
        }

        static /* synthetic */ ZipArchiveEntry access$200(CurrentEntry x0) {
            return x0.entry;
        }

        static /* synthetic */ boolean access$300(CurrentEntry x0) {
            return x0.hasWritten;
        }

        static /* synthetic */ boolean access$302(CurrentEntry x0, boolean x1) {
            x0.hasWritten = x1;
            return x1;
        }

        static /* synthetic */ long access$400(CurrentEntry x0) {
            return x0.localDataStart;
        }

        static /* synthetic */ long access$402(CurrentEntry x0, long x1) {
            x0.localDataStart = x1;
            return x1;
        }

        static /* synthetic */ boolean access$500(CurrentEntry x0) {
            return x0.causedUseOfZip64;
        }

        static /* synthetic */ boolean access$502(CurrentEntry x0, boolean x1) {
            x0.causedUseOfZip64 = x1;
            return x1;
        }

        private CurrentEntry(ZipArchiveEntry entry) {
            this.localDataStart = 0;
            this.dataStart = 0;
            this.bytesRead = 0;
            this.causedUseOfZip64 = false;
            this.entry = entry;
        }
    }

    private static final class EntryMetaData {
        private final long offset;
        private final boolean usesDataDescriptor;

        /* synthetic */ EntryMetaData(long x0, boolean x1, AnonymousClass1 x2) {
            this(x0, x1);
        }

        static /* synthetic */ long access$800(EntryMetaData x0) {
            return x0.offset;
        }

        static /* synthetic */ boolean access$900(EntryMetaData x0) {
            return x0.usesDataDescriptor;
        }

        private EntryMetaData(long offset, boolean usesDataDescriptor) {
            this.offset = offset;
            this.usesDataDescriptor = usesDataDescriptor;
        }
    }

    public static final class UnicodeExtraFieldPolicy {
        public static final UnicodeExtraFieldPolicy ALWAYS = null;
        public static final UnicodeExtraFieldPolicy NEVER = null;
        public static final UnicodeExtraFieldPolicy NOT_ENCODEABLE = null;
        private final String name;

        static {
            ALWAYS = new UnicodeExtraFieldPolicy("always");
            NEVER = new UnicodeExtraFieldPolicy("never");
            NOT_ENCODEABLE = new UnicodeExtraFieldPolicy("not encodeable");
        }

        private UnicodeExtraFieldPolicy(String n) {
            this.name = n;
        }

        public String toString() {
            return this.name;
        }
    }

    static {
        EMPTY = new byte[0];
        ZERO = new byte[]{0, 0};
        LZERO = new byte[]{0, 0, 0, 0};
        ONE = ZipLong.getBytes(1);
        LFH_SIG = ZipLong.LFH_SIG.getBytes();
        DD_SIG = ZipLong.DD_SIG.getBytes();
        CFH_SIG = ZipLong.CFH_SIG.getBytes();
        EOCD_SIG = ZipLong.getBytes(101010256);
        ZIP64_EOCD_SIG = ZipLong.getBytes(101075792);
        ZIP64_EOCD_LOC_SIG = ZipLong.getBytes(117853008);
    }

    public ZipArchiveOutputStream(OutputStream out) {
        this.finished = false;
        this.comment = "";
        this.level = -1;
        this.hasCompressionLevelChanged = false;
        this.method = 8;
        this.entries = new LinkedList();
        this.cdOffset = 0;
        this.cdLength = 0;
        this.metaData = new HashMap();
        this.encoding = DEFAULT_ENCODING;
        this.zipEncoding = ZipEncodingHelper.getZipEncoding(DEFAULT_ENCODING);
        this.useUTF8Flag = true;
        this.fallbackToUTF8 = false;
        this.createUnicodeExtraFields = UnicodeExtraFieldPolicy.NEVER;
        this.hasUsedZip64 = false;
        this.zip64Mode = Zip64Mode.AsNeeded;
        this.copyBuffer = new byte[32768];
        this.calendarInstance = Calendar.getInstance();
        this.out = out;
        this.channel = null;
        this.def = new Deflater(this.level, true);
        this.streamCompressor = StreamCompressor.create(out, this.def);
    }

    public ZipArchiveOutputStream(File file) throws IOException {
        this.finished = false;
        this.comment = "";
        this.level = -1;
        this.hasCompressionLevelChanged = false;
        this.method = 8;
        this.entries = new LinkedList();
        this.cdOffset = 0;
        this.cdLength = 0;
        this.metaData = new HashMap();
        this.encoding = DEFAULT_ENCODING;
        this.zipEncoding = ZipEncodingHelper.getZipEncoding(DEFAULT_ENCODING);
        this.useUTF8Flag = true;
        this.fallbackToUTF8 = false;
        this.createUnicodeExtraFields = UnicodeExtraFieldPolicy.NEVER;
        this.hasUsedZip64 = false;
        this.zip64Mode = Zip64Mode.AsNeeded;
        this.copyBuffer = new byte[32768];
        this.calendarInstance = Calendar.getInstance();
        this.def = new Deflater(this.level, true);
        OutputStream o = null;
        SeekableByteChannel _channel = null;
        _channel = Files.newByteChannel(file.toPath(), EnumSet.of(StandardOpenOption.CREATE, StandardOpenOption.WRITE, StandardOpenOption.READ, StandardOpenOption.TRUNCATE_EXISTING), new FileAttribute[0]);     // Catch: IOException -> L5
        StreamCompressor _streamCompressor = StreamCompressor.create(_channel, this.def);     // Catch: IOException -> L5
    L7:
        this.out = o;
        this.channel = _channel;
        this.streamCompressor = _streamCompressor;
        return;
    L6:
        IOUtils.closeQuietly(_channel);
        _channel = null;
        o = new FileOutputStream(file);
        StreamCompressor _streamCompressor2 = StreamCompressor.create(o, this.def);
        _streamCompressor = _streamCompressor2;
        goto L7
    }

    public ZipArchiveOutputStream(SeekableByteChannel channel) throws IOException {
        this.finished = false;
        this.comment = "";
        this.level = -1;
        this.hasCompressionLevelChanged = false;
        this.method = 8;
        this.entries = new LinkedList();
        this.cdOffset = 0;
        this.cdLength = 0;
        this.metaData = new HashMap();
        this.encoding = DEFAULT_ENCODING;
        this.zipEncoding = ZipEncodingHelper.getZipEncoding(DEFAULT_ENCODING);
        this.useUTF8Flag = true;
        this.fallbackToUTF8 = false;
        this.createUnicodeExtraFields = UnicodeExtraFieldPolicy.NEVER;
        this.hasUsedZip64 = false;
        this.zip64Mode = Zip64Mode.AsNeeded;
        this.copyBuffer = new byte[32768];
        this.calendarInstance = Calendar.getInstance();
        this.channel = channel;
        this.def = new Deflater(this.level, true);
        this.streamCompressor = StreamCompressor.create(channel, this.def);
        this.out = null;
    }

    public boolean isSeekable() {
        if (this.channel == null) goto L5;
        return true;
    L5:
        return false;
    }

    public void setEncoding(String encoding) {
        this.encoding = encoding;
        this.zipEncoding = ZipEncodingHelper.getZipEncoding(encoding);
        if (this.useUTF8Flag == true) goto L5;
        return;
    L5:
        if (ZipEncodingHelper.isUTF8(encoding) == true) goto L9;
        this.useUTF8Flag = false;
        return;
    }

    public String getEncoding() {
        return this.encoding;
    }

    public void setUseLanguageEncodingFlag(boolean b) {
        if (b == true) goto L4;
    L6:
        boolean r0 = false;
    L7:
        this.useUTF8Flag = r0;
        return;
    L4:
        if (ZipEncodingHelper.isUTF8(this.encoding) == false) goto L6;
        r0 = true;
        goto L7
    }

    public void setCreateUnicodeExtraFields(UnicodeExtraFieldPolicy b) {
        this.createUnicodeExtraFields = b;
    }

    public void setFallbackToUTF8(boolean b) {
        this.fallbackToUTF8 = b;
    }

    public void setUseZip64(Zip64Mode mode) {
        this.zip64Mode = mode;
    }

    @Override // org.apache.commons.compress.archivers.ArchiveOutputStream
    public void finish() throws IOException {
        if (this.finished == true) goto L11;
        if (this.entry != null) goto L9;
        this.cdOffset = this.streamCompressor.getTotalBytesWritten();
        writeCentralDirectoryInChunks();
        this.cdLength = this.streamCompressor.getTotalBytesWritten() - this.cdOffset;
        writeZip64CentralDirectory();
        writeCentralDirectoryEnd();
        this.metaData.clear();
        this.entries.clear();
        this.streamCompressor.close();
        this.finished = true;
        return;
    L9:
        throw new IOException("This archive contains unclosed entries.");
    L11:
        throw new IOException("This archive has already been finished");
    }

    private void writeCentralDirectoryInChunks() throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(EventLogTags.SCREEN_TOGGLED);
        int count = 0;
        Iterator<ZipArchiveEntry> r3 = this.entries.iterator();
    L4:
        if (r3.hasNext() == false) goto L9;
        ZipArchiveEntry ze = r3.next();
        byteArrayOutputStream.write(createCentralFileHeader(ze));
        count = count + 1;
        if (count <= 1000) goto L4;
        writeCounted(byteArrayOutputStream.toByteArray());
        byteArrayOutputStream.reset();
        count = 0;
        goto L4
    L9:
        writeCounted(byteArrayOutputStream.toByteArray());
    }

    @Override // org.apache.commons.compress.archivers.ArchiveOutputStream
    public void closeArchiveEntry() throws IOException {
        preClose();
        flushDeflater();
        long bytesWritten = this.streamCompressor.getTotalBytesWritten() - CurrentEntry.access$000(this.entry);
        long realCrc = this.streamCompressor.getCrc32();
        CurrentEntry.access$102(this.entry, this.streamCompressor.getBytesRead());
        Zip64Mode effectiveMode = getEffectiveZip64Mode(CurrentEntry.access$200(this.entry));
        boolean actuallyNeedsZip64 = handleSizesAndCrc(bytesWritten, realCrc, effectiveMode);
        closeEntry(actuallyNeedsZip64, false);
        this.streamCompressor.reset();
    }

    private void closeCopiedEntry(boolean phased) throws IOException {
        preClose();
        CurrentEntry.access$102(this.entry, CurrentEntry.access$200(this.entry).getSize());
        Zip64Mode effectiveMode = getEffectiveZip64Mode(CurrentEntry.access$200(this.entry));
        boolean actuallyNeedsZip64 = checkIfNeedsZip64(effectiveMode);
        closeEntry(actuallyNeedsZip64, phased);
    }

    private void closeEntry(boolean actuallyNeedsZip64, boolean phased) throws IOException {
        if (phased == false) goto L4;
    L6:
        if (phased == true) goto L8;
        writeDataDescriptor(CurrentEntry.access$200(this.entry));
    L8:
        this.entry = null;
        return;
    L4:
        if (this.channel == null) goto L6;
        rewriteSizesAndCrc(actuallyNeedsZip64);
        goto L6
    }

    private void preClose() throws IOException {
        if (this.finished == true) goto L13;
        if (this.entry == null) goto L11;
        if (CurrentEntry.access$300(this.entry) == true) goto L14;
        write(EMPTY, 0, 0);
        return;
    L14:
        return;
    L11:
        throw new IOException("No current entry to close");
    L13:
        throw new IOException("Stream has already been finished");
    }

    public void addRawArchiveEntry(ZipArchiveEntry entry, InputStream rawStream) throws IOException {
        ZipArchiveEntry ae = new ZipArchiveEntry(entry);
        if (hasZip64Extra(ae) == false) goto L6;
        ae.removeExtraField(Zip64ExtendedInformationExtraField.HEADER_ID);
    L6:
        if (ae.getCrc() != (-1)) goto L8;
    L12:
        boolean is2PhaseSource = false;
    L13:
        putArchiveEntry(ae, is2PhaseSource);
        copyFromZipInputStream(rawStream);
        closeCopiedEntry(is2PhaseSource);
        return;
    L8:
        if (ae.getSize() == (-1)) goto L12;
        if (ae.getCompressedSize() == (-1)) goto L12;
        is2PhaseSource = true;
        goto L13
    }

    private void flushDeflater() throws IOException {
        if (CurrentEntry.access$200(this.entry).getMethod() != 8) goto L6;
        this.streamCompressor.flushDeflater();
        return;
    }

    private boolean handleSizesAndCrc(long bytesWritten, long crc, Zip64Mode effectiveMode) throws ZipException {
        if (CurrentEntry.access$200(this.entry).getMethod() != 8) goto L6;
        CurrentEntry.access$200(this.entry).setSize(CurrentEntry.access$100(this.entry));
        CurrentEntry.access$200(this.entry).setCompressedSize(bytesWritten);
        CurrentEntry.access$200(this.entry).setCrc(crc);
    L18:
        return checkIfNeedsZip64(effectiveMode);
    L6:
        if (this.channel == null) goto L8;
        CurrentEntry.access$200(this.entry).setSize(bytesWritten);
        CurrentEntry.access$200(this.entry).setCompressedSize(bytesWritten);
        CurrentEntry.access$200(this.entry).setCrc(crc);
        goto L18
    L8:
        if (CurrentEntry.access$200(this.entry).getCrc() != crc) goto L15;
        if (CurrentEntry.access$200(this.entry).getSize() == bytesWritten) goto L18;
        throw new ZipException("bad size for entry " + CurrentEntry.access$200(this.entry).getName() + ": " + CurrentEntry.access$200(this.entry).getSize() + " instead of " + bytesWritten);
    L15:
        throw new ZipException("bad CRC checksum for entry " + CurrentEntry.access$200(this.entry).getName() + ": " + Long.toHexString(CurrentEntry.access$200(this.entry).getCrc()) + " instead of " + Long.toHexString(crc));
    }

    private boolean checkIfNeedsZip64(Zip64Mode effectiveMode) throws ZipException {
        boolean actuallyNeedsZip64 = isZip64Required(CurrentEntry.access$200(this.entry), effectiveMode);
        if (actuallyNeedsZip64 == true) goto L5;
    L9:
        return actuallyNeedsZip64;
    L5:
        if (effectiveMode != Zip64Mode.Never) goto L9;
        throw new Zip64RequiredException(Zip64RequiredException.getEntryTooBigMessage(CurrentEntry.access$200(this.entry)));
    }

    private boolean isZip64Required(ZipArchiveEntry entry1, Zip64Mode requestedMode) {
        if (requestedMode != Zip64Mode.Always) goto L5;
    L8:
        return true;
    L5:
        if (isTooLageForZip32(entry1) == true) goto L8;
        return false;
    }

    private boolean isTooLageForZip32(ZipArchiveEntry zipArchiveEntry) {
        if (zipArchiveEntry.getSize() < 4294967295L) goto L5;
    L8:
        return true;
    L5:
        if (zipArchiveEntry.getCompressedSize() >= 4294967295L) goto L8;
        return false;
    }

    private void rewriteSizesAndCrc(boolean actuallyNeedsZip64) throws IOException {
        long save = this.channel.position();
        this.channel.position(CurrentEntry.access$400(this.entry));
        writeOut(ZipLong.getBytes(CurrentEntry.access$200(this.entry).getCrc()));
        if (hasZip64Extra(CurrentEntry.access$200(this.entry)) == false) goto L7;
        if (actuallyNeedsZip64 == false) goto L7;
        writeOut(ZipLong.ZIP64_MAGIC.getBytes());
        writeOut(ZipLong.ZIP64_MAGIC.getBytes());
    L9:
        if (hasZip64Extra(CurrentEntry.access$200(this.entry)) == false) goto L15;
        ByteBuffer name = getName(CurrentEntry.access$200(this.entry));
        int nameLen = name.limit() - name.position();
        this.channel.position((((CurrentEntry.access$400(this.entry) + 12) + 4) + ((long) nameLen)) + 4);
        writeOut(ZipEightByteInteger.getBytes(CurrentEntry.access$200(this.entry).getSize()));
        writeOut(ZipEightByteInteger.getBytes(CurrentEntry.access$200(this.entry).getCompressedSize()));
        if (actuallyNeedsZip64 == true) goto L15;
        this.channel.position(CurrentEntry.access$400(this.entry) - 10);
        writeOut(ZipShort.getBytes(versionNeededToExtract(CurrentEntry.access$200(this.entry).getMethod(), false, false)));
        CurrentEntry.access$200(this.entry).removeExtraField(Zip64ExtendedInformationExtraField.HEADER_ID);
        CurrentEntry.access$200(this.entry).setExtra();
        if (CurrentEntry.access$500(this.entry) == false) goto L15;
        this.hasUsedZip64 = false;
    L15:
        this.channel.position(save);
        return;
    L7:
        writeOut(ZipLong.getBytes(CurrentEntry.access$200(this.entry).getCompressedSize()));
        writeOut(ZipLong.getBytes(CurrentEntry.access$200(this.entry).getSize()));
        goto L9
    }

    @Override // org.apache.commons.compress.archivers.ArchiveOutputStream
    public void putArchiveEntry(ArchiveEntry archiveEntry) throws IOException {
        putArchiveEntry(archiveEntry, false);
    }

    private void putArchiveEntry(ArchiveEntry archiveEntry, boolean phased) throws IOException {
        if (this.finished == true) goto L27;
        if (this.entry == null) goto L7;
        closeArchiveEntry();
    L7:
        this.entry = new CurrentEntry((ZipArchiveEntry) archiveEntry, null);
        this.entries.add(CurrentEntry.access$200(this.entry));
        setDefaults(CurrentEntry.access$200(this.entry));
        Zip64Mode effectiveMode = getEffectiveZip64Mode(CurrentEntry.access$200(this.entry));
        validateSizeInformation(effectiveMode);
        if (shouldAddZip64Extra(CurrentEntry.access$200(this.entry), effectiveMode) == false) goto L20;
        Zip64ExtendedInformationExtraField z64 = getZip64Extra(CurrentEntry.access$200(this.entry));
        if (phased == false) goto L13;
        ZipEightByteInteger size = new ZipEightByteInteger(CurrentEntry.access$200(this.entry).getSize());
        ZipEightByteInteger size2 = new ZipEightByteInteger(CurrentEntry.access$200(this.entry).getCompressedSize());
    L18:
        z64.setSize(size);
        z64.setCompressedSize(size2);
        CurrentEntry.access$200(this.entry).setExtra();
        goto L20
    L13:
        if (CurrentEntry.access$200(this.entry).getMethod() == 0) goto L15;
    L17:
        ZipEightByteInteger compressedSize = ZipEightByteInteger.ZERO;
        size2 = compressedSize;
        size = size2;
        goto L18
    L15:
        if (CurrentEntry.access$200(this.entry).getSize() == (-1)) goto L17;
        size2 = new ZipEightByteInteger(CurrentEntry.access$200(this.entry).getSize());
        size = size2;
    L20:
        if (CurrentEntry.access$200(this.entry).getMethod() == 8) goto L22;
    L24:
        writeLocalFileHeader((ZipArchiveEntry) archiveEntry, phased);
        return;
    L22:
        if (this.hasCompressionLevelChanged == false) goto L24;
        this.def.setLevel(this.level);
        this.hasCompressionLevelChanged = false;
        goto L24
    L27:
        throw new IOException("Stream has already been finished");
    }

    private void setDefaults(ZipArchiveEntry entry) {
        if (entry.getMethod() != (-1)) goto L6;
        entry.setMethod(this.method);
    L6:
        if (entry.getTime() != (-1)) goto L9;
        entry.setTime(System.currentTimeMillis());
        return;
    }

    private void validateSizeInformation(Zip64Mode effectiveMode) throws ZipException {
        if (CurrentEntry.access$200(this.entry).getMethod() != 0) goto L16;
        if (this.channel != null) goto L16;
        if (CurrentEntry.access$200(this.entry).getSize() == (-1)) goto L14;
        if (CurrentEntry.access$200(this.entry).getCrc() == (-1)) goto L12;
        CurrentEntry.access$200(this.entry).setCompressedSize(CurrentEntry.access$200(this.entry).getSize());
        goto L16
    L12:
        throw new ZipException("crc checksum is required for STORED method when not writing to a file");
    L14:
        throw new ZipException("uncompressed size is required for STORED method when not writing to a file");
    L16:
        if (CurrentEntry.access$200(this.entry).getSize() >= 4294967295L) goto L20;
        if (CurrentEntry.access$200(this.entry).getCompressedSize() >= 4294967295L) goto L20;
        return;
    L20:
        if (effectiveMode == Zip64Mode.Never) goto L23;
        return;
    L23:
        throw new Zip64RequiredException(Zip64RequiredException.getEntryTooBigMessage(CurrentEntry.access$200(this.entry)));
    }

    private boolean shouldAddZip64Extra(ZipArchiveEntry entry, Zip64Mode mode) {
        if (mode != Zip64Mode.Always) goto L5;
    L16:
        return true;
    L5:
        if (entry.getSize() >= 4294967295L) goto L16;
        if (entry.getCompressedSize() >= 4294967295L) goto L16;
        if (entry.getSize() == (-1)) goto L11;
    L15:
        return false;
    L11:
        if (this.channel == null) goto L15;
        if (mode == Zip64Mode.Never) goto L15;
        goto L15
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public void setLevel(int level) {
        if (level < (-1)) goto L12;
        if (level > 9) goto L12;
        if (this.level != level) goto L9;
        return;
    L9:
        this.hasCompressionLevelChanged = true;
        this.level = level;
        return;
    L12:
        throw new IllegalArgumentException("Invalid compression level: " + level);
    }

    public void setMethod(int method) {
        this.method = method;
    }

    @Override // org.apache.commons.compress.archivers.ArchiveOutputStream
    public boolean canWriteEntryData(ArchiveEntry ae) {
        if ((ae instanceof ZipArchiveEntry) == false) goto L13;
        ZipArchiveEntry zae = (ZipArchiveEntry) ae;
        if (zae.getMethod() != ZipMethod.IMPLODING.getCode()) goto L7;
        return false;
    L7:
        if (zae.getMethod() != ZipMethod.UNSHRINKING.getCode()) goto L9;
        return false;
    L9:
        if (ZipUtil.canHandleEntryData(zae) == false) goto L16;
        return true;
    L16:
        return false;
    L13:
        return false;
    }

    @Override // java.io.OutputStream
    public void write(byte[] b, int offset, int length) throws IOException {
        if (this.entry == null) goto L7;
        ZipUtil.checkRequestedFeatures(CurrentEntry.access$200(this.entry));
        long writtenThisTime = this.streamCompressor.write(b, offset, length, CurrentEntry.access$200(this.entry).getMethod());
        count(writtenThisTime);
        return;
    L7:
        throw new IllegalStateException("No current entry");
    }

    private void writeCounted(byte[] data) throws IOException {
        this.streamCompressor.writeCounted(data);
    }

    private void copyFromZipInputStream(InputStream src) throws IOException {
        if (this.entry == null) goto L10;
        ZipUtil.checkRequestedFeatures(CurrentEntry.access$200(this.entry));
        CurrentEntry.access$302(this.entry, true);
    L5:
        int length = src.read(this.copyBuffer);
        if (length < 0) goto L8;
        this.streamCompressor.writeCounted(this.copyBuffer, 0, length);
        count(length);
        goto L5
    L8:
        return;
    L10:
        throw new IllegalStateException("No current entry");
    }

    @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
    L6:
        th = move-exception;
        destroy();
        throw th;
    L3:
        if (this.finished == true) goto L8;
        finish();     // Catch: Throwable -> L6
    L8:
        destroy();
    }

    @Override // java.io.OutputStream, java.io.Flushable
    public void flush() throws IOException {
        if (this.out == null) goto L6;
        this.out.flush();
        return;
    }

    protected final void deflate() throws IOException {
        this.streamCompressor.deflate();
    }

    protected void writeLocalFileHeader(ZipArchiveEntry ze) throws IOException {
        writeLocalFileHeader(ze, false);
    }

    private void writeLocalFileHeader(ZipArchiveEntry ze, boolean phased) throws IOException {
        boolean encodable = this.zipEncoding.canEncode(ze.getName());
        ByteBuffer name = getName(ze);
        if (this.createUnicodeExtraFields == UnicodeExtraFieldPolicy.NEVER) goto L5;
        addUnicodeExtraFields(ze, encodable, name);
    L5:
        long localHeaderStart = this.streamCompressor.getTotalBytesWritten();
        byte[] localHeader = createLocalFileHeader(ze, name, encodable, phased, localHeaderStart);
        this.metaData.put(ze, new EntryMetaData(localHeaderStart, usesDataDescriptor(ze.getMethod(), phased), null));
        CurrentEntry.access$402(this.entry, 14 + localHeaderStart);
        writeCounted(localHeader);
        CurrentEntry.access$002(this.entry, this.streamCompressor.getTotalBytesWritten());
    }

    private byte[] createLocalFileHeader(ZipArchiveEntry ze, ByteBuffer name, boolean encodable, boolean phased, long archiveOffset) {
        ResourceAlignmentExtraField oldAlignmentEx = (ResourceAlignmentExtraField) ze.getExtraField(ResourceAlignmentExtraField.ID);
        if (oldAlignmentEx == null) goto L5;
        ze.removeExtraField(ResourceAlignmentExtraField.ID);
    L5:
        int alignment = ze.getAlignment();
        if (alignment > 0) goto L10;
        if (oldAlignmentEx == null) goto L10;
        alignment = oldAlignmentEx.getAlignment();
    L10:
        if (alignment > 1) goto L16;
        if (oldAlignmentEx == null) goto L23;
        if (oldAlignmentEx.allowMethodChange() == false) goto L16;
    L23:
        byte[] extra = ze.getLocalFileDataExtra();
        int nameLen = name.limit() - name.position();
        int len = (nameLen + 30) + extra.length;
        byte[] buf = new byte[len];
        System.arraycopy(LFH_SIG, 0, buf, 0, 4);
        int zipMethod = ze.getMethod();
        boolean dataDescriptor = usesDataDescriptor(zipMethod, phased);
        ZipShort.putShort(versionNeededToExtract(zipMethod, hasZip64Extra(ze), dataDescriptor), buf, 4);
        if (encodable == false) goto L26;
    L28:
        boolean r5 = false;
    L29:
        GeneralPurposeBit generalPurposeBit = getGeneralPurposeBits(r5, dataDescriptor);
        generalPurposeBit.encode(buf, 6);
        ZipShort.putShort(zipMethod, buf, 8);
        ZipUtil.toDosTime(this.calendarInstance, ze.getTime(), buf, 10);
        if (phased == false) goto L33;
        ZipLong.putLong(ze.getCrc(), buf, 14);
    L40:
        if (hasZip64Extra(CurrentEntry.access$200(this.entry)) == false) goto L42;
        ZipLong.ZIP64_MAGIC.putLong(buf, 18);
        ZipLong.ZIP64_MAGIC.putLong(buf, 22);
    L51:
        ZipShort.putShort(nameLen, buf, 26);
        ZipShort.putShort(extra.length, buf, 28);
        System.arraycopy(name.array(), name.arrayOffset(), buf, 30, nameLen);
        System.arraycopy(extra, 0, buf, nameLen + 30, extra.length);
        return buf;
    L42:
        if (phased == false) goto L45;
        ZipLong.putLong(ze.getCompressedSize(), buf, 18);
        ZipLong.putLong(ze.getSize(), buf, 22);
        goto L51
    L45:
        if (zipMethod != 8) goto L47;
    L50:
        System.arraycopy(LZERO, 0, buf, 18, 4);
        System.arraycopy(LZERO, 0, buf, 22, 4);
        goto L51
    L47:
        if (this.channel != null) goto L50;
        ZipLong.putLong(ze.getSize(), buf, 18);
        ZipLong.putLong(ze.getSize(), buf, 22);
        goto L51
    L33:
        if (zipMethod != 8) goto L35;
    L38:
        System.arraycopy(LZERO, 0, buf, 14, 4);
        goto L40
    L35:
        if (this.channel != null) goto L38;
        ZipLong.putLong(ze.getCrc(), buf, 14);
        goto L40
    L26:
        if (this.fallbackToUTF8 == false) goto L28;
        r5 = true;
    L16:
        int oldLength = ((name.limit() + 30) - name.position()) + ze.getLocalFileDataExtra().length;
        int padding = (int) (((((-archiveOffset) - ((long) oldLength)) - 4) - 2) & ((long) (alignment - 1)));
        if (oldAlignmentEx != null) goto L19;
    L21:
        boolean r13 = false;
    L22:
        ze.addExtraField(new ResourceAlignmentExtraField(alignment, r13, padding));
        goto L23
    L19:
        if (oldAlignmentEx.allowMethodChange() == false) goto L21;
        r13 = true;
        goto L22
    }

    private void addUnicodeExtraFields(ZipArchiveEntry ze, boolean encodable, ByteBuffer name) throws IOException {
        if (this.createUnicodeExtraFields == UnicodeExtraFieldPolicy.ALWAYS) goto L5;
        if (encodable == false) goto L5;
    L6:
        String comm = ze.getComment();
        if (comm != null) goto L9;
        return;
    L9:
        if ("".equals(comm) == true) goto L16;
        boolean commentEncodable = this.zipEncoding.canEncode(comm);
        if (this.createUnicodeExtraFields == UnicodeExtraFieldPolicy.ALWAYS) goto L13;
        if (commentEncodable == false) goto L13;
        return;
    L13:
        ByteBuffer commentB = getEntryEncoding(ze).encode(comm);
        ze.addExtraField(new UnicodeCommentExtraField(comm, commentB.array(), commentB.arrayOffset(), commentB.limit() - commentB.position()));
        return;
    L16:
        return;
    L5:
        ze.addExtraField(new UnicodePathExtraField(ze.getName(), name.array(), name.arrayOffset(), name.limit() - name.position()));
        goto L6
    }

    protected void writeDataDescriptor(ZipArchiveEntry ze) throws IOException {
        if (usesDataDescriptor(ze.getMethod(), false) == true) goto L5;
        return;
    L5:
        writeCounted(DD_SIG);
        writeCounted(ZipLong.getBytes(ze.getCrc()));
        if (hasZip64Extra(ze) == true) goto L8;
        writeCounted(ZipLong.getBytes(ze.getCompressedSize()));
        writeCounted(ZipLong.getBytes(ze.getSize()));
        return;
    L8:
        writeCounted(ZipEightByteInteger.getBytes(ze.getCompressedSize()));
        writeCounted(ZipEightByteInteger.getBytes(ze.getSize()));
    }

    protected void writeCentralFileHeader(ZipArchiveEntry ze) throws IOException {
        byte[] centralFileHeader = createCentralFileHeader(ze);
        writeCounted(centralFileHeader);
    }

    private byte[] createCentralFileHeader(ZipArchiveEntry ze) throws IOException {
        EntryMetaData entryMetaData = this.metaData.get(ze);
        if (hasZip64Extra(ze) == false) goto L5;
    L14:
        boolean needsZip64Extra = true;
    L16:
        if (needsZip64Extra == true) goto L18;
    L22:
        handleZip64Extra(ze, EntryMetaData.access$800(entryMetaData), needsZip64Extra);
        return createCentralFileHeader(ze, getName(ze), entryMetaData, needsZip64Extra);
    L18:
        if (this.zip64Mode != Zip64Mode.Never) goto L22;
        throw new Zip64RequiredException("archive's size exceeds the limit of 4GByte.");
    L5:
        if (ze.getCompressedSize() >= 4294967295L) goto L14;
        if (ze.getSize() >= 4294967295L) goto L14;
        if (EntryMetaData.access$800(entryMetaData) >= 4294967295L) goto L14;
        if (this.zip64Mode == Zip64Mode.Always) goto L14;
        needsZip64Extra = false;
        goto L16
    }

    private byte[] createCentralFileHeader(ZipArchiveEntry ze, ByteBuffer name, EntryMetaData entryMetaData, boolean needsZip64Extra) throws IOException {
        byte[] extra = ze.getCentralDirectoryExtra();
        String comm = ze.getComment();
        if (comm != null) goto L5;
        comm = "";
    L5:
        ByteBuffer commentB = getEntryEncoding(ze).encode(comm);
        int nameLen = name.limit() - name.position();
        int commentLen = commentB.limit() - commentB.position();
        int len = ((nameLen + 46) + extra.length) + commentLen;
        byte[] buf = new byte[len];
        System.arraycopy(CFH_SIG, 0, buf, 0, 4);
        int r8 = ze.getPlatform() << 8;
        if (this.hasUsedZip64 == true) goto L8;
        int r12 = 20;
    L9:
        ZipShort.putShort(r8 | r12, buf, 4);
        int zipMethod = ze.getMethod();
        boolean encodable = this.zipEncoding.canEncode(ze.getName());
        ZipShort.putShort(versionNeededToExtract(zipMethod, needsZip64Extra, EntryMetaData.access$900(entryMetaData)), buf, 6);
        if (encodable == false) goto L12;
    L14:
        boolean r13 = false;
    L15:
        getGeneralPurposeBits(r13, EntryMetaData.access$900(entryMetaData)).encode(buf, 8);
        ZipShort.putShort(zipMethod, buf, 10);
        ZipUtil.toDosTime(this.calendarInstance, ze.getTime(), buf, 12);
        ZipLong.putLong(ze.getCrc(), buf, 16);
        if (ze.getCompressedSize() < 4294967295L) goto L18;
    L23:
        ZipLong.ZIP64_MAGIC.putLong(buf, 20);
        ZipLong.ZIP64_MAGIC.putLong(buf, 24);
    L24:
        ZipShort.putShort(nameLen, buf, 28);
        ZipShort.putShort(extra.length, buf, 30);
        ZipShort.putShort(commentLen, buf, 32);
        System.arraycopy(ZERO, 0, buf, 34, 2);
        ZipShort.putShort(ze.getInternalAttributes(), buf, 36);
        ZipLong.putLong(ze.getExternalAttributes(), buf, 38);
        if (EntryMetaData.access$800(entryMetaData) >= 4294967295L) goto L31;
        if (this.zip64Mode == Zip64Mode.Always) goto L31;
        commentB = commentB;
        ZipLong.putLong(Math.min(EntryMetaData.access$800(entryMetaData), 4294967295L), buf, 42);
    L32:
        System.arraycopy(name.array(), name.arrayOffset(), buf, 46, nameLen);
        int extraStart = nameLen + 46;
        System.arraycopy(extra, 0, buf, extraStart, extra.length);
        int commentStart = extra.length + extraStart;
        System.arraycopy(commentB.array(), commentB.arrayOffset(), buf, commentStart, commentLen);
        return buf;
    L31:
        ZipLong.putLong(4294967295L, buf, 42);
        goto L32
    L18:
        if (ze.getSize() >= 4294967295L) goto L23;
        if (this.zip64Mode == Zip64Mode.Always) goto L23;
        ZipLong.putLong(ze.getCompressedSize(), buf, 20);
        ZipLong.putLong(ze.getSize(), buf, 24);
        goto L24
    L12:
        if (this.fallbackToUTF8 == false) goto L14;
        r13 = true;
        goto L15
    L8:
        r12 = 45;
        goto L9
    }

    private void handleZip64Extra(ZipArchiveEntry ze, long lfhOffset, boolean needsZip64Extra) {
        if (needsZip64Extra == false) goto L19;
        Zip64ExtendedInformationExtraField z64 = getZip64Extra(ze);
        if (ze.getCompressedSize() < 4294967295L) goto L6;
    L11:
        z64.setCompressedSize(new ZipEightByteInteger(ze.getCompressedSize()));
        z64.setSize(new ZipEightByteInteger(ze.getSize()));
    L13:
        if (lfhOffset < 4294967295L) goto L15;
    L16:
        z64.setRelativeHeaderOffset(new ZipEightByteInteger(lfhOffset));
    L17:
        ze.setExtra();
        return;
    L15:
        if (this.zip64Mode != Zip64Mode.Always) goto L17;
    L6:
        if (ze.getSize() >= 4294967295L) goto L11;
        if (this.zip64Mode == Zip64Mode.Always) goto L11;
        z64.setCompressedSize(null);
        z64.setSize(null);
        goto L13
    }

    protected void writeCentralDirectoryEnd() throws IOException {
        writeCounted(EOCD_SIG);
        writeCounted(ZERO);
        writeCounted(ZERO);
        int numberOfEntries = this.entries.size();
        if (numberOfEntries <= 65535) goto L10;
        if (this.zip64Mode != Zip64Mode.Never) goto L10;
        throw new Zip64RequiredException("archive contains more than 65535 entries.");
    L10:
        if (this.cdOffset > 4294967295L) goto L12;
    L16:
        byte[] num = ZipShort.getBytes(Math.min(numberOfEntries, 65535));
        writeCounted(num);
        writeCounted(num);
        writeCounted(ZipLong.getBytes(Math.min(this.cdLength, 4294967295L)));
        writeCounted(ZipLong.getBytes(Math.min(this.cdOffset, 4294967295L)));
        ByteBuffer data = this.zipEncoding.encode(this.comment);
        int dataLen = data.limit() - data.position();
        writeCounted(ZipShort.getBytes(dataLen));
        this.streamCompressor.writeCounted(data.array(), data.arrayOffset(), dataLen);
        return;
    L12:
        if (this.zip64Mode != Zip64Mode.Never) goto L16;
        throw new Zip64RequiredException("archive's size exceeds the limit of 4GByte.");
    }

    protected void writeZip64CentralDirectory() throws IOException {
        if (this.zip64Mode != Zip64Mode.Never) goto L6;
        return;
    L6:
        if (this.hasUsedZip64 == true) goto L15;
        if (this.cdOffset < 4294967295L) goto L10;
    L13:
        this.hasUsedZip64 = true;
        goto L15
    L10:
        if (this.cdLength >= 4294967295L) goto L13;
        if (this.entries.size() >= 65535) goto L13;
    L15:
        if (this.hasUsedZip64 == true) goto L17;
        return;
    L17:
        long offset = this.streamCompressor.getTotalBytesWritten();
        writeOut(ZIP64_EOCD_SIG);
        writeOut(ZipEightByteInteger.getBytes(44));
        writeOut(ZipShort.getBytes(45));
        writeOut(ZipShort.getBytes(45));
        writeOut(LZERO);
        writeOut(LZERO);
        byte[] num = ZipEightByteInteger.getBytes(this.entries.size());
        writeOut(num);
        writeOut(num);
        writeOut(ZipEightByteInteger.getBytes(this.cdLength));
        writeOut(ZipEightByteInteger.getBytes(this.cdOffset));
        writeOut(ZIP64_EOCD_LOC_SIG);
        writeOut(LZERO);
        writeOut(ZipEightByteInteger.getBytes(offset));
        writeOut(ONE);
    }

    protected final void writeOut(byte[] data) throws IOException {
        this.streamCompressor.writeOut(data, 0, data.length);
    }

    protected final void writeOut(byte[] data, int offset, int length) throws IOException {
        this.streamCompressor.writeOut(data, offset, length);
    }

    private GeneralPurposeBit getGeneralPurposeBits(boolean utfFallback, boolean usesDataDescriptor) {
        GeneralPurposeBit b = new GeneralPurposeBit();
        if (this.useUTF8Flag == true) goto L7;
        if (utfFallback == true) goto L7;
        boolean r1 = false;
    L8:
        b.useUTF8ForNames(r1);
        if (usesDataDescriptor == false) goto L11;
        b.useDataDescriptor(true);
    L11:
        return b;
    L7:
        r1 = true;
        goto L8
    }

    private int versionNeededToExtract(int zipMethod, boolean zip64, boolean usedDataDescriptor) {
        if (zip64 == false) goto L5;
        return 45;
    L5:
        if (usedDataDescriptor == false) goto L9;
        return 20;
    L9:
        return versionNeededToExtractMethod(zipMethod);
    }

    private boolean usesDataDescriptor(int zipMethod, boolean phased) {
        if (phased == false) goto L4;
    L8:
        return false;
    L4:
        if (zipMethod != 8) goto L8;
        if (this.channel != null) goto L8;
        return true;
    }

    private int versionNeededToExtractMethod(int zipMethod) {
        if (zipMethod != 8) goto L5;
        return 20;
    L5:
        return 10;
    }

    @Override // org.apache.commons.compress.archivers.ArchiveOutputStream
    public ArchiveEntry createArchiveEntry(File inputFile, String entryName) throws IOException {
        if (this.finished == true) goto L7;
        return new ZipArchiveEntry(inputFile, entryName);
    L7:
        throw new IOException("Stream has already been finished");
    }

    private Zip64ExtendedInformationExtraField getZip64Extra(ZipArchiveEntry ze) {
        if (this.entry == null) goto L5;
        CurrentEntry.access$502(this.entry, !this.hasUsedZip64);
    L5:
        this.hasUsedZip64 = true;
        Zip64ExtendedInformationExtraField z64 = (Zip64ExtendedInformationExtraField) ze.getExtraField(Zip64ExtendedInformationExtraField.HEADER_ID);
        if (z64 != null) goto L8;
        z64 = new Zip64ExtendedInformationExtraField();
    L8:
        ze.addAsFirstExtraField(z64);
        return z64;
    }

    private boolean hasZip64Extra(ZipArchiveEntry ze) {
        if (ze.getExtraField(Zip64ExtendedInformationExtraField.HEADER_ID) == null) goto L5;
        return true;
    L5:
        return false;
    }

    private Zip64Mode getEffectiveZip64Mode(ZipArchiveEntry ze) {
        if (this.zip64Mode != Zip64Mode.AsNeeded) goto L14;
        if (this.channel != null) goto L14;
        if (ze.getMethod() != 8) goto L14;
        if (ze.getSize() != (-1)) goto L14;
        return Zip64Mode.Never;
    L14:
        return this.zip64Mode;
    }

    private ZipEncoding getEntryEncoding(ZipArchiveEntry ze) {
        boolean encodable = this.zipEncoding.canEncode(ze.getName());
        if (encodable == true) goto L8;
        if (this.fallbackToUTF8 == false) goto L8;
        return ZipEncodingHelper.UTF8_ZIP_ENCODING;
    L8:
        return this.zipEncoding;
    }

    private ByteBuffer getName(ZipArchiveEntry ze) throws IOException {
        return getEntryEncoding(ze).encode(ze.getName());
    }

    void destroy() throws IOException {
    L6:
        th = move-exception;
        if (this.out == null) goto L15;
        this.out.close();
    L15:
        throw th;
    L3:
        if (this.channel == null) goto L9;
        this.channel.close();     // Catch: Throwable -> L6
    L9:
        if (this.out == null) goto L18;
        this.out.close();
        return;
    }
}
