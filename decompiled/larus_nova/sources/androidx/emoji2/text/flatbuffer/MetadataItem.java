package androidx.emoji2.text.flatbuffer;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* JADX INFO: loaded from: classes17.dex */
public final class MetadataItem extends Table {

    public static final class Vector extends BaseVector {
        public Vector() {
        }

        public MetadataItem get(int r100) {
            return get(new MetadataItem(), r100);
        }

        public MetadataItem get(MetadataItem r100, int r101) {
            return r100.__assign(MetadataItem.access$000(__element(r101), this.f15443bb), this.f15443bb);
        }

        public Vector __assign(int r100, int r101, ByteBuffer r102) {
            __reset(r100, r101, r102);
            return this;
        }
    }

    public boolean emojiStyle() {
        int r100 = __offset(6);
        if (r100 != 0) goto L5;
        return false;
    L5:
        if (this.f15451bb.get(r100 + this.bb_pos) == 0) goto L9;
        return true;
    L9:
        return false;
    }

    public int id() {
        int r100 = __offset(4);
        if (r100 != 0) goto L7;
        return 0;
    L7:
        return this.f15451bb.getInt(r100 + this.bb_pos);
    }

    public ByteBuffer codepointsAsByteBuffer() {
        return __vector_as_bytebuffer(16, 4);
    }

    public int codepointsLength() {
        int r100 = __offset(16);
        if (r100 != 0) goto L7;
        return 0;
    L7:
        return __vector_len(r100);
    }

    public IntVector codepointsVector() {
        return codepointsVector(new IntVector());
    }

    public short compatAdded() {
        int r100 = __offset(10);
        if (r100 != 0) goto L7;
        return 0;
    L7:
        return this.f15451bb.getShort(r100 + this.bb_pos);
    }

    public short height() {
        int r100 = __offset(14);
        if (r100 != 0) goto L7;
        return 0;
    L7:
        return this.f15451bb.getShort(r100 + this.bb_pos);
    }

    public short sdkAdded() {
        int r100 = __offset(8);
        if (r100 != 0) goto L7;
        return 0;
    L7:
        return this.f15451bb.getShort(r100 + this.bb_pos);
    }

    public short width() {
        int r100 = __offset(12);
        if (r100 != 0) goto L7;
        return 0;
    L7:
        return this.f15451bb.getShort(r100 + this.bb_pos);
    }

    public MetadataItem() {
    }

    public static void ValidateVersion() {
        Constants.FLATBUFFERS_1_12_0();
    }

    public static int endMetadataItem(FlatBufferBuilder r100) {
        return r100.endTable();
    }

    public static MetadataItem getRootAsMetadataItem(ByteBuffer r100) {
        return getRootAsMetadataItem(r100, new MetadataItem());
    }

    public static void startMetadataItem(FlatBufferBuilder r100) {
        r100.startTable(7);
    }

    public int codepoints(int r100) {
        int r101 = __offset(16);
        if (r101 != 0) goto L7;
        return 0;
    L7:
        return this.f15451bb.getInt(__vector(r101) + (r100 * 4));
    }

    public ByteBuffer codepointsInByteBuffer(ByteBuffer r100) {
        return __vector_in_bytebuffer(r100, 16, 4);
    }

    public IntVector codepointsVector(IntVector r100) {
        int r101 = __offset(16);
        if (r101 != 0) goto L7;
        return null;
    L7:
        return r100.__assign(__vector(r101), this.f15451bb);
    }

    public static /* synthetic */ int access$000(int r100, ByteBuffer r101) {
        return Table.__indirect(r100, r101);
    }

    public static void addCodepoints(FlatBufferBuilder r100, int r101) {
        r100.addOffset(6, r101, 0);
    }

    public static void addCompatAdded(FlatBufferBuilder r100, short r101) {
        r100.addShort(3, r101, 0);
    }

    public static void addEmojiStyle(FlatBufferBuilder r100, boolean r101) {
        r100.addBoolean(1, r101, false);
    }

    public static void addHeight(FlatBufferBuilder r100, short r101) {
        r100.addShort(5, r101, 0);
    }

    public static void addId(FlatBufferBuilder r100, int r101) {
        r100.addInt(0, r101, 0);
    }

    public static void addSdkAdded(FlatBufferBuilder r100, short r101) {
        r100.addShort(2, r101, 0);
    }

    public static void addWidth(FlatBufferBuilder r100, short r101) {
        r100.addShort(4, r101, 0);
    }

    public static int createCodepointsVector(FlatBufferBuilder r100, int[] r101) {
        r100.startVector(4, r101.length, 4);
        int r102 = r101.length - 1;
    L3:
        if (r102 < 0) goto L6;
        r100.addInt(r101[r102]);
        r102 = r102 - 1;
        goto L3
    L6:
        return r100.endVector();
    }

    public static MetadataItem getRootAsMetadataItem(ByteBuffer r100, MetadataItem r101) {
        r100.order(ByteOrder.LITTLE_ENDIAN);
        return r101.__assign(r100.getInt(r100.position()) + r100.position(), r100);
    }

    public static void startCodepointsVector(FlatBufferBuilder r100, int r101) {
        r100.startVector(4, r101, 4);
    }

    public MetadataItem __assign(int r100, ByteBuffer r101) {
        __init(r100, r101);
        return this;
    }

    public void __init(int r100, ByteBuffer r101) {
        __reset(r100, r101);
    }

    public static int createMetadataItem(FlatBufferBuilder r100, int r101, boolean r102, short r103, short r104, short r105, short r106, int r107) {
        r100.startTable(7);
        addCodepoints(r100, r107);
        addId(r100, r101);
        addHeight(r100, r106);
        addWidth(r100, r105);
        addCompatAdded(r100, r104);
        addSdkAdded(r100, r103);
        addEmojiStyle(r100, r102);
        return endMetadataItem(r100);
    }
}
