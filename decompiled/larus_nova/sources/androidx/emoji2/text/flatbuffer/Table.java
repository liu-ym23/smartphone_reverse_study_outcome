package androidx.emoji2.text.flatbuffer;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Arrays;

/* JADX INFO: loaded from: classes6.dex */
public class Table {

    /* JADX INFO: renamed from: bb, reason: collision with root package name */
    protected ByteBuffer f15451bb;
    protected int bb_pos;
    Utf8 utf8;
    private int vtable_size;
    private int vtable_start;

    public void __reset() {
        __reset(0, null);
    }

    public int keysCompare(Integer r100, Integer r101, ByteBuffer r102) {
        return 0;
    }

    public Table() {
        this.utf8 = Utf8.getDefault();
    }

    public ByteBuffer getByteBuffer() {
        return this.f15451bb;
    }

    public int __indirect(int r100) {
        return r100 + this.f15451bb.getInt(r100);
    }

    public int __offset(int r100) {
        if (r100 < this.vtable_size) goto L7;
        return 0;
    L7:
        return this.f15451bb.getShort(this.vtable_start + r100);
    }

    public String __string(int r100) {
        return __string(r100, this.f15451bb, this.utf8);
    }

    public int __vector(int r100) {
        int r101 = r100 + this.bb_pos;
        return (r101 + this.f15451bb.getInt(r101)) + 4;
    }

    public int __vector_len(int r100) {
        int r101 = r100 + this.bb_pos;
        int r102 = r101 + this.f15451bb.getInt(r101);
        return this.f15451bb.getInt(r102);
    }

    public static boolean __has_identifier(ByteBuffer r100, String r101) {
        if (r101.length() != 4) goto L13;
        int r102 = 0;
    L5:
        if (r102 >= 4) goto L10;
        if (r101.charAt(r102) != ((char) r100.get((r100.position() + 4) + r102))) goto L8;
        r102 = r102 + 1;
        goto L5
    L8:
        return false;
    L10:
        return true;
    L13:
        throw new AssertionError("FlatBuffers: file identifier must be length 4");
    }

    public static int __indirect(int r100, ByteBuffer r101) {
        return r100 + r101.getInt(r100);
    }

    public void __reset(int r100, ByteBuffer r101) {
        this.f15451bb = r101;
        if (r101 == null) goto L5;
        this.bb_pos = r100;
        int r102 = r100 - r101.getInt(r100);
        this.vtable_start = r102;
        this.vtable_size = this.f15451bb.getShort(r102);
        return;
    L5:
        this.bb_pos = 0;
        this.vtable_start = 0;
        this.vtable_size = 0;
    }

    public Table __union(Table r100, int r101) {
        return __union(r100, r101, this.f15451bb);
    }

    public ByteBuffer __vector_as_bytebuffer(int r100, int r101) {
        int r102 = __offset(r100);
        if (r102 != 0) goto L6;
        return null;
    L6:
        ByteBuffer r103 = this.f15451bb.duplicate().order(ByteOrder.LITTLE_ENDIAN);
        int r104 = __vector(r102);
        r103.position(r104);
        r103.limit(r104 + (__vector_len(r102) * r101));
        return r103;
    }

    public void sortTables(int[] r100, final ByteBuffer r101) {
        Integer[] r102 = new Integer[r100.length];
        int r103 = 0;
        int r104 = 0;
    L4:
        if (r104 >= r100.length) goto L6;
        r102[r104] = Integer.valueOf(r100[r104]);
        r104 = r104 + 1;
        goto L4
    L6:
        Arrays.sort(r102, new AnonymousClass1(this, r101));
    L8:
        if (r103 >= r100.length) goto L10;
        r100[r103] = r102[r103].intValue();
        r103 = r103 + 1;
        goto L8
    }

    public static int __offset(int r100, int r101, ByteBuffer r102) {
        int r103 = r102.capacity() - r101;
        return r102.getShort((r100 + r103) - r102.getInt(r103)) + r103;
    }

    public static String __string(int r100, ByteBuffer r101, Utf8 r102) {
        int r103 = r100 + r101.getInt(r100);
        int r104 = r101.getInt(r103);
        return r102.decodeUtf8(r101, r103 + 4, r104);
    }

    public static Table __union(Table r100, int r101, ByteBuffer r102) {
        r100.__reset(__indirect(r101, r102), r102);
        return r100;
    }

    public static int compareStrings(int r100, int r101, ByteBuffer r110) {
        int r102 = r100 + r110.getInt(r100);
        int r103 = r101 + r110.getInt(r101);
        int r104 = r110.getInt(r102);
        int r105 = r110.getInt(r103);
        int r106 = r102 + 4;
        int r107 = r103 + 4;
        int r108 = Math.min(r104, r105);
        int r109 = 0;
    L3:
        if (r109 >= r108) goto L10;
        int r111 = r109 + r106;
        int r112 = r109 + r107;
        if (r110.get(r111) != r110.get(r112)) goto L7;
        r109 = r109 + 1;
        goto L3
    L7:
        return r110.get(r111) - r110.get(r112);
    L10:
        return r104 - r105;
    }

    public ByteBuffer __vector_in_bytebuffer(ByteBuffer r100, int r101, int r102) {
        int r103 = __offset(r101);
        if (r103 != 0) goto L6;
        return null;
    L6:
        int r104 = __vector(r103);
        r100.rewind();
        r100.limit((__vector_len(r103) * r102) + r104);
        r100.position(r104);
        return r100;
    }

    public static int compareStrings(int r100, byte[] r101, ByteBuffer r102) {
        int r103 = r100 + r102.getInt(r100);
        int r104 = r102.getInt(r103);
        int r105 = r101.length;
        int r106 = r103 + 4;
        int r107 = Math.min(r104, r105);
        int r108 = 0;
    L3:
        if (r108 >= r107) goto L10;
        int r109 = r108 + r106;
        if (r102.get(r109) != r101[r108]) goto L7;
        r108 = r108 + 1;
        goto L3
    L7:
        return r102.get(r109) - r101[r108];
    L10:
        return r104 - r105;
    }
}
