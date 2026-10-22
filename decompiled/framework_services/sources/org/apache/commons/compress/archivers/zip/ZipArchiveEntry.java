package org.apache.commons.compress.archivers.zip;

import com.android.server.slice.SliceClientPermissions;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipException;
import org.apache.commons.compress.archivers.ArchiveEntry;
import org.apache.commons.compress.archivers.EntryStreamOffsets;

/* JADX INFO: loaded from: classes3.dex */
public class ZipArchiveEntry extends ZipEntry implements ArchiveEntry, EntryStreamOffsets {
    public static final int CRC_UNKNOWN = -1;
    private static final byte[] EMPTY = null;
    public static final int PLATFORM_FAT = 0;
    public static final int PLATFORM_UNIX = 3;
    private static final int SHORT_MASK = 65535;
    private static final int SHORT_SHIFT = 16;
    private static final ZipExtraField[] noExtraFields = null;
    private int alignment;
    private CommentSource commentSource;
    private long dataOffset;
    private long externalAttributes;
    private ZipExtraField[] extraFields;
    private GeneralPurposeBit gpb;
    private int internalAttributes;
    private boolean isStreamContiguous;
    private long localHeaderOffset;
    private int method;
    private String name;
    private NameSource nameSource;
    private int platform;
    private int rawFlag;
    private byte[] rawName;
    private long size;
    private UnparseableExtraFieldData unparseableExtra;
    private int versionMadeBy;
    private int versionRequired;

    public static final enum CommentSource extends Enum<CommentSource> {
        private static final /* synthetic */ CommentSource[] $VALUES = null;
        public static final CommentSource COMMENT = null;
        public static final CommentSource UNICODE_EXTRA_FIELD = null;

        private static /* synthetic */ CommentSource[] $values() {
            return new CommentSource[]{COMMENT, UNICODE_EXTRA_FIELD};
        }

        private CommentSource(String r1, int r2) {
            super(r1, r2);
        }

        public static CommentSource valueOf(String name) {
            return (CommentSource) Enum.valueOf(CommentSource.class, name);
        }

        public static CommentSource[] values() {
            return (CommentSource[]) $VALUES.clone();
        }

        static {
            COMMENT = new CommentSource("COMMENT", 0);
            UNICODE_EXTRA_FIELD = new CommentSource("UNICODE_EXTRA_FIELD", 1);
            $VALUES = $values();
        }
    }

    public static final enum NameSource extends Enum<NameSource> {
        private static final /* synthetic */ NameSource[] $VALUES = null;
        public static final NameSource NAME = null;
        public static final NameSource NAME_WITH_EFS_FLAG = null;
        public static final NameSource UNICODE_EXTRA_FIELD = null;

        private static /* synthetic */ NameSource[] $values() {
            return new NameSource[]{NAME, NAME_WITH_EFS_FLAG, UNICODE_EXTRA_FIELD};
        }

        private NameSource(String r1, int r2) {
            super(r1, r2);
        }

        public static NameSource valueOf(String name) {
            return (NameSource) Enum.valueOf(NameSource.class, name);
        }

        public static NameSource[] values() {
            return (NameSource[]) $VALUES.clone();
        }

        static {
            NAME = new NameSource("NAME", 0);
            NAME_WITH_EFS_FLAG = new NameSource("NAME_WITH_EFS_FLAG", 1);
            UNICODE_EXTRA_FIELD = new NameSource("UNICODE_EXTRA_FIELD", 2);
            $VALUES = $values();
        }
    }

    static {
        EMPTY = new byte[0];
        noExtraFields = new ZipExtraField[0];
    }

    public ZipArchiveEntry(String name) {
        super(name);
        this.method = -1;
        this.size = -1;
        this.internalAttributes = 0;
        this.platform = 0;
        this.externalAttributes = 0;
        this.alignment = 0;
        this.unparseableExtra = null;
        this.name = null;
        this.rawName = null;
        this.gpb = new GeneralPurposeBit();
        this.localHeaderOffset = -1;
        this.dataOffset = -1;
        this.isStreamContiguous = false;
        this.nameSource = NameSource.NAME;
        this.commentSource = CommentSource.COMMENT;
        setName(name);
    }

    public ZipArchiveEntry(ZipEntry entry) throws ZipException {
        super(entry);
        this.method = -1;
        this.size = -1;
        this.internalAttributes = 0;
        this.platform = 0;
        this.externalAttributes = 0;
        this.alignment = 0;
        this.unparseableExtra = null;
        this.name = null;
        this.rawName = null;
        this.gpb = new GeneralPurposeBit();
        this.localHeaderOffset = -1;
        this.dataOffset = -1;
        this.isStreamContiguous = false;
        this.nameSource = NameSource.NAME;
        this.commentSource = CommentSource.COMMENT;
        setName(entry.getName());
        byte[] extra = entry.getExtra();
        if (extra == null) goto L5;
        setExtraFields(ExtraFieldUtils.parse(extra, true, ExtraFieldUtils.UnparseableExtraField.READ));
    L6:
        setMethod(entry.getMethod());
        this.size = entry.getSize();
        return;
    L5:
        setExtra();
        goto L6
    }

    public ZipArchiveEntry(ZipArchiveEntry entry) throws ZipException {
        this(entry);
        setInternalAttributes(entry.getInternalAttributes());
        setExternalAttributes(entry.getExternalAttributes());
        setExtraFields(getAllExtraFieldsNoCopy());
        setPlatform(entry.getPlatform());
        GeneralPurposeBit other = entry.getGeneralPurposeBit();
        if (other != null) goto L5;
        GeneralPurposeBit r1 = null;
    L6:
        setGeneralPurposeBit(r1);
        return;
    L5:
        r1 = (GeneralPurposeBit) other.clone();
        goto L6
    }

    protected ZipArchiveEntry() {
        this("");
    }

    public ZipArchiveEntry(File inputFile, String entryName) {
        if (inputFile.isDirectory() == true) goto L5;
    L7:
        String r0 = entryName;
    L8:
        this(r0);
        if (inputFile.isFile() == false) goto L11;
        setSize(inputFile.length());
    L11:
        setTime(inputFile.lastModified());
        return;
    L5:
        if (entryName.endsWith(SliceClientPermissions.SliceAuthority.DELIMITER) == true) goto L7;
        r0 = entryName + SliceClientPermissions.SliceAuthority.DELIMITER;
        goto L8
    }

    @Override // java.util.zip.ZipEntry
    public Object clone() {
        ZipArchiveEntry e = (ZipArchiveEntry) super.clone();
        e.setInternalAttributes(getInternalAttributes());
        e.setExternalAttributes(getExternalAttributes());
        e.setExtraFields(getAllExtraFieldsNoCopy());
        return e;
    }

    @Override // java.util.zip.ZipEntry
    public int getMethod() {
        return this.method;
    }

    @Override // java.util.zip.ZipEntry
    public void setMethod(int method) {
        if (method < 0) goto L6;
        this.method = method;
        return;
    L6:
        throw new IllegalArgumentException("ZIP compression method can not be negative: " + method);
    }

    public int getInternalAttributes() {
        return this.internalAttributes;
    }

    public void setInternalAttributes(int value) {
        this.internalAttributes = value;
    }

    public long getExternalAttributes() {
        return this.externalAttributes;
    }

    public void setExternalAttributes(long value) {
        this.externalAttributes = value;
    }

    public void setUnixMode(int mode) {
        int r0 = mode << 16;
        int r2 = 0;
        if ((mode & 128) != 0) goto L5;
        int r1 = 1;
    L6:
        int r3 = r0 | r1;
        if (isDirectory() == false) goto L9;
        r2 = 16;
    L9:
        setExternalAttributes(r3 | r2);
        this.platform = 3;
        return;
    L5:
        r1 = 0;
        goto L6
    }

    public int getUnixMode() {
        if (this.platform == 3) goto L6;
        return 0;
    L6:
        return (int) ((getExternalAttributes() >> 16) & 65535);
    }

    public boolean isUnixSymlink() {
        if ((getUnixMode() & 61440) != 40960) goto L5;
        return true;
    L5:
        return false;
    }

    public int getPlatform() {
        return this.platform;
    }

    protected void setPlatform(int platform) {
        this.platform = platform;
    }

    protected int getAlignment() {
        return this.alignment;
    }

    public void setAlignment(int alignment) {
        if (((alignment - 1) & alignment) != 0) goto L9;
        if (alignment > 65535) goto L9;
        this.alignment = alignment;
        return;
    L9:
        throw new IllegalArgumentException("Invalid value for alignment, must be power of two and no bigger than 65535 but is " + alignment);
    }

    public void setExtraFields(ZipExtraField[] fields) {
        List<ZipExtraField> newFields = new ArrayList();
        int r1 = fields.length;
        int r2 = 0;
    L3:
        if (r2 >= r1) goto L9;
        ZipExtraField field = fields[r2];
        if ((field instanceof UnparseableExtraFieldData) == false) goto L7;
        this.unparseableExtra = (UnparseableExtraFieldData) field;
    L8:
        r2 = r2 + 1;
        goto L3
    L7:
        newFields.add(field);
        goto L8
    L9:
        this.extraFields = (ZipExtraField[]) newFields.toArray(new ZipExtraField[newFields.size()]);
        setExtra();
    }

    public ZipExtraField[] getExtraFields() {
        return getParseableExtraFields();
    }

    public ZipExtraField[] getExtraFields(boolean includeUnparseable) {
        if (includeUnparseable == false) goto L5;
        return getAllExtraFields();
    L5:
        return getParseableExtraFields();
    }

    private ZipExtraField[] getParseableExtraFieldsNoCopy() {
        if (this.extraFields != null) goto L7;
        return noExtraFields;
    L7:
        return this.extraFields;
    }

    private ZipExtraField[] getParseableExtraFields() {
        ZipExtraField[] parseableExtraFields = getParseableExtraFieldsNoCopy();
        if (parseableExtraFields != this.extraFields) goto L6;
        return copyOf(parseableExtraFields);
    L6:
        return parseableExtraFields;
    }

    private ZipExtraField[] getAllExtraFieldsNoCopy() {
        if (this.extraFields != null) goto L7;
        return getUnparseableOnly();
    L7:
        if (this.unparseableExtra == null) goto L10;
        return getMergedFields();
    L10:
        return this.extraFields;
    }

    private ZipExtraField[] copyOf(ZipExtraField[] src) {
        return copyOf(src, src.length);
    }

    private ZipExtraField[] copyOf(ZipExtraField[] src, int length) {
        ZipExtraField[] cpy = new ZipExtraField[length];
        System.arraycopy(src, 0, cpy, 0, Math.min(src.length, length));
        return cpy;
    }

    private ZipExtraField[] getMergedFields() {
        ZipExtraField[] zipExtraFields = copyOf(this.extraFields, this.extraFields.length + 1);
        zipExtraFields[this.extraFields.length] = this.unparseableExtra;
        return zipExtraFields;
    }

    private ZipExtraField[] getUnparseableOnly() {
        if (this.unparseableExtra != null) goto L6;
        return noExtraFields;
    L6:
        return new ZipExtraField[]{this.unparseableExtra};
    }

    private ZipExtraField[] getAllExtraFields() {
        ZipExtraField[] allExtraFieldsNoCopy = getAllExtraFieldsNoCopy();
        if (allExtraFieldsNoCopy != this.extraFields) goto L6;
        return copyOf(allExtraFieldsNoCopy);
    L6:
        return allExtraFieldsNoCopy;
    }

    public void addExtraField(ZipExtraField ze) {
        if ((ze instanceof UnparseableExtraFieldData) == false) goto L6;
        this.unparseableExtra = (UnparseableExtraFieldData) ze;
    L12:
        setExtra();
        return;
    L6:
        if (this.extraFields != null) goto L9;
        this.extraFields = new ZipExtraField[]{ze};
        goto L12
    L9:
        if (getExtraField(ze.getHeaderId()) == null) goto L11;
        removeExtraField(ze.getHeaderId());
    L11:
        ZipExtraField[] zipExtraFields = copyOf(this.extraFields, this.extraFields.length + 1);
        zipExtraFields[zipExtraFields.length - 1] = ze;
        this.extraFields = zipExtraFields;
        goto L12
    }

    public void addAsFirstExtraField(ZipExtraField ze) {
        if ((ze instanceof UnparseableExtraFieldData) == false) goto L6;
        this.unparseableExtra = (UnparseableExtraFieldData) ze;
    L15:
        setExtra();
        return;
    L6:
        if (getExtraField(ze.getHeaderId()) == null) goto L8;
        removeExtraField(ze.getHeaderId());
    L8:
        ZipExtraField[] copy = this.extraFields;
        if (this.extraFields == null) goto L11;
        int newLen = this.extraFields.length + 1;
    L12:
        this.extraFields = new ZipExtraField[newLen];
        this.extraFields[0] = ze;
        if (copy == null) goto L15;
        System.arraycopy(copy, 0, this.extraFields, 1, this.extraFields.length - 1);
        goto L15
    L11:
        newLen = 1;
        goto L12
    }

    public void removeExtraField(ZipShort type) {
        if (this.extraFields == null) goto L17;
        List<ZipExtraField> newResult = new ArrayList();
        ZipExtraField[] r1 = this.extraFields;
        int r2 = r1.length;
        int r3 = 0;
    L5:
        if (r3 >= r2) goto L11;
        ZipExtraField extraField = r1[r3];
        if (type.equals(extraField.getHeaderId()) == true) goto L9;
        newResult.add(extraField);
    L9:
        r3 = r3 + 1;
        goto L5
    L11:
        if (this.extraFields.length == newResult.size()) goto L15;
        this.extraFields = (ZipExtraField[]) newResult.toArray(new ZipExtraField[newResult.size()]);
        setExtra();
        return;
    L15:
        throw new NoSuchElementException();
    L17:
        throw new NoSuchElementException();
    }

    public void removeUnparseableExtraFieldData() {
        if (this.unparseableExtra == null) goto L7;
        this.unparseableExtra = null;
        setExtra();
        return;
    L7:
        throw new NoSuchElementException();
    }

    public ZipExtraField getExtraField(ZipShort type) {
        if (this.extraFields == null) goto L11;
        ZipExtraField[] r0 = this.extraFields;
        int r1 = r0.length;
        int r2 = 0;
    L6:
        if (r2 >= r1) goto L15;
        ZipExtraField extraField = r0[r2];
        if (type.equals(extraField.getHeaderId()) == true) goto L9;
        r2 = r2 + 1;
        goto L6
    L9:
        return extraField;
    L15:
        return null;
    L11:
        return null;
    }

    public UnparseableExtraFieldData getUnparseableExtraFieldData() {
        return this.unparseableExtra;
    }

    @Override // java.util.zip.ZipEntry
    public void setExtra(byte[] extra) throws RuntimeException {
        ZipExtraField[] local = ExtraFieldUtils.parse(extra, true, ExtraFieldUtils.UnparseableExtraField.READ);     // Catch: ZipException -> L4
        mergeExtraFields(local, true);     // Catch: ZipException -> L4
        return;
    L4:
        e = move-exception;
        throw new RuntimeException("Error parsing extra fields for entry: " + getName() + " - " + e.getMessage(), e);
    }

    protected void setExtra() {
        super.setExtra(ExtraFieldUtils.mergeLocalFileDataData(getAllExtraFieldsNoCopy()));
    }

    public void setCentralDirectoryExtra(byte[] b) {
        ZipExtraField[] central = ExtraFieldUtils.parse(b, false, ExtraFieldUtils.UnparseableExtraField.READ);     // Catch: ZipException -> L4
        mergeExtraFields(central, false);     // Catch: ZipException -> L4
        return;
    L4:
        e = move-exception;
        throw new RuntimeException(e.getMessage(), e);
    }

    public byte[] getLocalFileDataExtra() {
        byte[] extra = getExtra();
        if (extra == null) goto L6;
        return extra;
    L6:
        return EMPTY;
    }

    public byte[] getCentralDirectoryExtra() {
        return ExtraFieldUtils.mergeCentralDirectoryData(getAllExtraFieldsNoCopy());
    }

    @Override // java.util.zip.ZipEntry, org.apache.commons.compress.archivers.ArchiveEntry
    public String getName() {
        if (this.name != null) goto L6;
        return super.getName();
    L6:
        return this.name;
    }

    @Override // java.util.zip.ZipEntry, org.apache.commons.compress.archivers.ArchiveEntry
    public boolean isDirectory() {
        return getName().endsWith(SliceClientPermissions.SliceAuthority.DELIMITER);
    }

    protected void setName(String name) {
        if (name != null) goto L4;
    L8:
        this.name = name;
        return;
    L4:
        if (getPlatform() != 0) goto L8;
        if (name.contains(SliceClientPermissions.SliceAuthority.DELIMITER) == true) goto L8;
        name = name.replace('\\', '/');
        goto L8
    }

    @Override // java.util.zip.ZipEntry, org.apache.commons.compress.archivers.ArchiveEntry
    public long getSize() {
        return this.size;
    }

    @Override // java.util.zip.ZipEntry
    public void setSize(long size) {
        if (size < 0) goto L7;
        this.size = size;
        return;
    L7:
        throw new IllegalArgumentException("invalid entry size");
    }

    protected void setName(String name, byte[] rawName) {
        setName(name);
        this.rawName = rawName;
    }

    public byte[] getRawName() {
        if (this.rawName == null) goto L6;
        byte[] b = new byte[this.rawName.length];
        System.arraycopy(this.rawName, 0, b, 0, this.rawName.length);
        return b;
    L6:
        return null;
    }

    protected long getLocalHeaderOffset() {
        return this.localHeaderOffset;
    }

    protected void setLocalHeaderOffset(long localHeaderOffset) {
        this.localHeaderOffset = localHeaderOffset;
    }

    @Override // org.apache.commons.compress.archivers.EntryStreamOffsets
    public long getDataOffset() {
        return this.dataOffset;
    }

    protected void setDataOffset(long dataOffset) {
        this.dataOffset = dataOffset;
    }

    @Override // org.apache.commons.compress.archivers.EntryStreamOffsets
    public boolean isStreamContiguous() {
        return this.isStreamContiguous;
    }

    protected void setStreamContiguous(boolean isStreamContiguous) {
        this.isStreamContiguous = isStreamContiguous;
    }

    @Override // java.util.zip.ZipEntry
    public int hashCode() {
        return getName().hashCode();
    }

    public GeneralPurposeBit getGeneralPurposeBit() {
        return this.gpb;
    }

    public void setGeneralPurposeBit(GeneralPurposeBit b) {
        this.gpb = b;
    }

    private void mergeExtraFields(ZipExtraField[] f, boolean local) throws ZipException {
        if (this.extraFields != null) goto L5;
        setExtraFields(f);
        return;
    L5:
        int r0 = f.length;
        int r2 = 0;
    L6:
        if (r2 >= r0) goto L17;
        ZipExtraField element = f[r2];
        if ((element instanceof UnparseableExtraFieldData) == false) goto L10;
        ZipExtraField existing = this.unparseableExtra;
    L11:
        if (existing != null) goto L13;
        addExtraField(element);
    L16:
        r2 = r2 + 1;
        goto L6
    L13:
        if (local == false) goto L15;
        byte[] b = element.getLocalFileDataData();
        existing.parseFromLocalFileData(b, 0, b.length);
        goto L16
    L15:
        byte[] b2 = element.getCentralDirectoryData();
        existing.parseFromCentralDirectoryData(b2, 0, b2.length);
        goto L16
    L10:
        existing = getExtraField(element.getHeaderId());
        goto L11
    L17:
        setExtra();
    }

    @Override // org.apache.commons.compress.archivers.ArchiveEntry
    public Date getLastModifiedDate() {
        return new Date(getTime());
    }

    public boolean equals(Object obj) {
        if (this != obj) goto L6;
        return true;
    L6:
        if (obj != null) goto L8;
    L53:
        return false;
    L8:
        if (getClass() != obj.getClass()) goto L53;
        ZipArchiveEntry other = (ZipArchiveEntry) obj;
        String myName = getName();
        String otherName = other.getName();
        if (myName != null) goto L15;
        if (otherName == null) goto L17;
        return false;
    L17:
        String myComment = getComment();
        String otherComment = other.getComment();
        if (myComment != null) goto L20;
        myComment = "";
    L20:
        if (otherComment != null) goto L23;
        otherComment = "";
    L23:
        if (getTime() != other.getTime()) goto L52;
        if (myComment.equals(otherComment) == false) goto L52;
        if (getInternalAttributes() != other.getInternalAttributes()) goto L52;
        if (getPlatform() != other.getPlatform()) goto L52;
        if (getExternalAttributes() != other.getExternalAttributes()) goto L52;
        if (getMethod() != other.getMethod()) goto L52;
        if (getSize() != other.getSize()) goto L52;
        if (getCrc() != other.getCrc()) goto L52;
        if (getCompressedSize() != other.getCompressedSize()) goto L52;
        if (Arrays.equals(getCentralDirectoryExtra(), other.getCentralDirectoryExtra()) == false) goto L52;
        if (Arrays.equals(getLocalFileDataExtra(), other.getLocalFileDataExtra()) == false) goto L52;
        if (this.localHeaderOffset != other.localHeaderOffset) goto L52;
        if (this.dataOffset != other.dataOffset) goto L52;
        if (this.gpb.equals(other.gpb) == false) goto L52;
        return true;
    L52:
        return false;
    L15:
        if (myName.equals(otherName) == true) goto L17;
        return false;
    }

    public void setVersionMadeBy(int versionMadeBy) {
        this.versionMadeBy = versionMadeBy;
    }

    public void setVersionRequired(int versionRequired) {
        this.versionRequired = versionRequired;
    }

    public int getVersionRequired() {
        return this.versionRequired;
    }

    public int getVersionMadeBy() {
        return this.versionMadeBy;
    }

    public int getRawFlag() {
        return this.rawFlag;
    }

    public void setRawFlag(int rawFlag) {
        this.rawFlag = rawFlag;
    }

    public NameSource getNameSource() {
        return this.nameSource;
    }

    public void setNameSource(NameSource nameSource) {
        this.nameSource = nameSource;
    }

    public CommentSource getCommentSource() {
        return this.commentSource;
    }

    public void setCommentSource(CommentSource commentSource) {
        this.commentSource = commentSource;
    }
}
