package androidx.emoji2.text.flatbuffer;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* JADX INFO: loaded from: classes6.dex */
public final class MetadataList extends Table {

    /* JADX INFO: loaded from: classes17.dex */
    public static final class Vector extends BaseVector {
        public Vector() {
        }

        public MetadataList get(int r100) {
            return get(new MetadataList(), r100);
        }

        public MetadataList get(MetadataList r100, int r101) {
            return r100.__assign(MetadataList.access$000(__element(r101), this.f15443bb), this.f15443bb);
        }

        public Vector __assign(int r100, int r101, ByteBuffer r102) {
            __reset(r100, r101, r102);
            return this;
        }
    }

    public int listLength() {
        int r100 = __offset(6);
        if (r100 != 0) goto L7;
        return 0;
    L7:
        return __vector_len(r100);
    }

    public int version() {
        int r100 = __offset(4);
        if (r100 != 0) goto L7;
        return 0;
    L7:
        return this.f15451bb.getInt(r100 + this.bb_pos);
    }

    public MetadataItem.Vector listVector() {
        return listVector(new MetadataItem.Vector());
    }

    public String sourceSha() {
        int r100 = __offset(8);
        if (r100 != 0) goto L7;
        return null;
    L7:
        return __string(r100 + this.bb_pos);
    }

    public ByteBuffer sourceShaAsByteBuffer() {
        return __vector_as_bytebuffer(8, 1);
    }

    public MetadataList() {
    }

    public static void ValidateVersion() {
        Constants.FLATBUFFERS_1_12_0();
    }

    public static int endMetadataList(FlatBufferBuilder r100) {
        return r100.endTable();
    }

    public static MetadataList getRootAsMetadataList(ByteBuffer r100) {
        return getRootAsMetadataList(r100, new MetadataList());
    }

    public static void startMetadataList(FlatBufferBuilder r100) {
        r100.startTable(3);
    }

    public MetadataItem list(int r100) {
        return list(new MetadataItem(), r100);
    }

    public MetadataItem.Vector listVector(MetadataItem.Vector r100) {
        int r101 = __offset(6);
        if (r101 != 0) goto L7;
        return null;
    L7:
        return r100.__assign(__vector(r101), 4, this.f15451bb);
    }

    public ByteBuffer sourceShaInByteBuffer(ByteBuffer r100) {
        return __vector_in_bytebuffer(r100, 8, 1);
    }

    public static /* synthetic */ int access$000(int r100, ByteBuffer r101) {
        return Table.__indirect(r100, r101);
    }

    public static void addList(FlatBufferBuilder r100, int r101) {
        r100.addOffset(1, r101, 0);
    }

    public static void addSourceSha(FlatBufferBuilder r100, int r101) {
        r100.addOffset(2, r101, 0);
    }

    public static void addVersion(FlatBufferBuilder r100, int r101) {
        r100.addInt(0, r101, 0);
    }

    public static int createListVector(FlatBufferBuilder r100, int[] r101) {
        r100.startVector(4, r101.length, 4);
        int r102 = r101.length - 1;
    L3:
        if (r102 < 0) goto L6;
        r100.addOffset(r101[r102]);
        r102 = r102 - 1;
        goto L3
    L6:
        return r100.endVector();
    }

    public static void finishMetadataListBuffer(FlatBufferBuilder r100, int r101) {
        r100.finish(r101);
    }

    public static void finishSizePrefixedMetadataListBuffer(FlatBufferBuilder r100, int r101) {
        r100.finishSizePrefixed(r101);
    }

    public static MetadataList getRootAsMetadataList(ByteBuffer r100, MetadataList r101) {
        r100.order(ByteOrder.LITTLE_ENDIAN);
        return r101.__assign(r100.getInt(r100.position()) + r100.position(), r100);
    }

    public static void startListVector(FlatBufferBuilder r100, int r101) {
        r100.startVector(4, r101, 4);
    }

    public MetadataList __assign(int r100, ByteBuffer r101) {
        __init(r100, r101);
        return this;
    }

    public void __init(int r100, ByteBuffer r101) {
        __reset(r100, r101);
    }

    public MetadataItem list(MetadataItem r100, int r101) {
        int r102 = __offset(6);
        if (r102 != 0) goto L7;
        return null;
    L7:
        return r100.__assign(__indirect(__vector(r102) + (r101 * 4)), this.f15451bb);
    }

    public static int createMetadataList(FlatBufferBuilder r100, int r101, int r102, int r103) {
        r100.startTable(3);
        addSourceSha(r100, r103);
        addList(r100, r102);
        addVersion(r100, r101);
        return endMetadataList(r100);
    }
}
