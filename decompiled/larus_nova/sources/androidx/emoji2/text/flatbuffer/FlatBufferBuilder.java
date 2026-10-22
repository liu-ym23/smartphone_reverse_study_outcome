package androidx.emoji2.text.flatbuffer;

import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Arrays;
import kotlin.UByte;

/* JADX INFO: loaded from: classes17.dex */
public class FlatBufferBuilder {
    static final /* synthetic */ boolean $assertionsDisabled = false;

    /* JADX INFO: renamed from: bb, reason: collision with root package name */
    ByteBuffer f15444bb;
    ByteBufferFactory bb_factory;
    boolean finished;
    boolean force_defaults;
    int minalign;
    boolean nested;
    int num_vtables;
    int object_start;

    /* JADX INFO: renamed from: space, reason: collision with root package name */
    int f15445space;
    final Utf8 utf8;
    int vector_num_elems;
    int[] vtable;
    int vtable_in_use;
    int[] vtables;

    public static class ByteBufferBackedInputStream extends InputStream {
        ByteBuffer buf;

        @Override // java.io.InputStream
        public int read() throws IOException {
            return this.buf.get() & UByte.MAX_VALUE;
        L5:
            return -1;
        }

        public ByteBufferBackedInputStream(ByteBuffer r100) {
            this.buf = r100;
        }
    }

    public static abstract class ByteBufferFactory {
        public ByteBufferFactory() {
        }

        public abstract ByteBuffer newByteBuffer(int r100);

        public void releaseByteBuffer(ByteBuffer r100) {
        }
    }

    public static final class HeapByteBufferFactory extends ByteBufferFactory {
        public static final HeapByteBufferFactory INSTANCE = null;

        static {
            INSTANCE = new HeapByteBufferFactory();
        }

        public HeapByteBufferFactory() {
        }

        @Override // androidx.emoji2.text.flatbuffer.FlatBufferBuilder.ByteBufferFactory
        public ByteBuffer newByteBuffer(int r100) {
            return ByteBuffer.allocate(r100).order(ByteOrder.LITTLE_ENDIAN);
        }
    }

    public FlatBufferBuilder() {
        this(1024);
    }

    public void clear() {
        this.f15445space = this.f15444bb.capacity();
        this.f15444bb.clear();
        this.minalign = 1;
    L3:
        int r100 = this.vtable_in_use;
        if (r100 <= 0) goto L6;
        int[] r101 = this.vtable;
        int r102 = r100 - 1;
        this.vtable_in_use = r102;
        r101[r102] = 0;
        goto L3
    L6:
        this.vtable_in_use = 0;
        this.nested = false;
        this.finished = false;
        this.object_start = 0;
        this.num_vtables = 0;
        this.vector_num_elems = 0;
    }

    public int endTable() {
        if (this.vtable == null) goto L41;
        if (this.nested == false) goto L41;
        addInt(0);
        int r100 = offset();
        int r101 = this.vtable_in_use - 1;
    L7:
        if (r101 < 0) goto L11;
        if (this.vtable[r101] != 0) goto L11;
        r101 = r101 - 1;
    L11:
        int r102 = r101 + 1;
    L12:
        if (r101 < 0) goto L18;
        int r103 = this.vtable[r101];
        if (r103 == 0) goto L16;
        int r104 = r100 - r103;
    L17:
        addShort((short) r104);
        r101 = r101 - 1;
        goto L12
    L16:
        r104 = 0;
        goto L17
    L18:
        addShort((short) (r100 - this.object_start));
        addShort((short) ((r102 + 2) * 2));
        int r105 = 0;
    L20:
        if (r105 >= this.num_vtables) goto L31;
        int r106 = this.f15444bb.capacity() - this.vtables[r105];
        int r107 = this.f15445space;
        short r108 = this.f15444bb.getShort(r106);
        if (r108 != this.f15444bb.getShort(r107)) goto L30;
        int r109 = 2;
    L24:
        if (r109 >= r108) goto L29;
        if (this.f15444bb.getShort(r106 + r109) != this.f15444bb.getShort(r107 + r109)) goto L30;
        r109 = r109 + 2;
        goto L24
    L29:
        int r110 = this.vtables[r105];
    L32:
        if (r110 == 0) goto L34;
        int r111 = this.f15444bb.capacity() - r100;
        this.f15445space = r111;
        this.f15444bb.putInt(r111, r110 - r100);
    L38:
        this.nested = false;
        return r100;
    L34:
        int r112 = this.num_vtables;
        int[] r113 = this.vtables;
        if (r112 != r113.length) goto L37;
        this.vtables = Arrays.copyOf(r113, r112 * 2);
    L37:
        int[] r114 = this.vtables;
        int r115 = this.num_vtables;
        this.num_vtables = r115 + 1;
        r114[r115] = offset();
        ByteBuffer r116 = this.f15444bb;
        r116.putInt(r116.capacity() - r100, offset() - r100);
    L30:
        r105 = r105 + 1;
        goto L20
    L31:
        r110 = 0;
    L41:
        throw new AssertionError("FlatBuffers: endTable called without startTable");
    }

    public int endVector() {
        if (this.nested == false) goto L7;
        this.nested = false;
        putInt(this.vector_num_elems);
        return offset();
    L7:
        throw new AssertionError("FlatBuffers: endVector called without startVector");
    }

    public void finished() {
        if (this.finished == false) goto L6;
        return;
    L6:
        throw new AssertionError("FlatBuffers: you can only access the serialized buffer after it has been finished by FlatBufferBuilder.finish().");
    }

    public void notNested() {
        if (this.nested == true) goto L6;
        return;
    L6:
        throw new AssertionError("FlatBuffers: object serialization must not be nested.");
    }

    public int offset() {
        return this.f15444bb.capacity() - this.f15445space;
    }

    public byte[] sizedByteArray() {
        return sizedByteArray(this.f15445space, this.f15444bb.capacity() - this.f15445space);
    }

    private int dataStart() {
        finished();
        return this.f15445space;
    }

    public ByteBuffer dataBuffer() {
        finished();
        return this.f15444bb;
    }

    public InputStream sizedInputStream() {
        finished();
        ByteBuffer r100 = this.f15444bb.duplicate();
        r100.position(this.f15445space);
        r100.limit(this.f15444bb.capacity());
        return new ByteBufferBackedInputStream(r100);
    }

    static {
    }

    public FlatBufferBuilder(int r100) {
        this(r100, HeapByteBufferFactory.INSTANCE, null, Utf8.getDefault());
    }

    public void Nested(int r100) {
        if (r100 != offset()) goto L6;
        return;
    L6:
        throw new AssertionError("FlatBuffers: struct must be serialized inline.");
    }

    public void addBoolean(boolean r100) {
        prep(1, 0);
        putBoolean(r100);
    }

    public void addByte(byte r100) {
        prep(1, 0);
        putByte(r100);
    }

    public void addDouble(double r100) {
        prep(8, 0);
        putDouble(r100);
    }

    public void addFloat(float r100) {
        prep(4, 0);
        putFloat(r100);
    }

    public void addInt(int r100) {
        prep(4, 0);
        putInt(r100);
    }

    public void addLong(long r100) {
        prep(8, 0);
        putLong(r100);
    }

    public void addOffset(int r100) {
        prep(4, 0);
        putInt((offset() - r100) + 4);
    }

    public void addShort(short r100) {
        prep(2, 0);
        putShort(r100);
    }

    public int createByteVector(ByteBuffer r100) {
        int r101 = r100.remaining();
        startVector(1, r101, 1);
        ByteBuffer r102 = this.f15444bb;
        int r103 = this.f15445space - r101;
        this.f15445space = r103;
        r102.position(r103);
        this.f15444bb.put(r100);
        return endVector();
    }

    public int createString(CharSequence r100) {
        int r101 = this.utf8.encodedLength(r100);
        addByte((byte) 0);
        startVector(1, r101, 1);
        ByteBuffer r102 = this.f15444bb;
        int r103 = this.f15445space - r101;
        this.f15445space = r103;
        r102.position(r103);
        this.utf8.encodeUtf8(r100, this.f15444bb);
        return endVector();
    }

    public int createVectorOfTables(int[] r100) {
        notNested();
        startVector(4, r100.length, 4);
        int r101 = r100.length - 1;
    L3:
        if (r101 < 0) goto L6;
        addOffset(r100[r101]);
        r101 = r101 - 1;
        goto L3
    L6:
        return endVector();
    }

    public void finish(int r100) {
        finish(r100, false);
    }

    public void finishSizePrefixed(int r100) {
        finish(r100, true);
    }

    public FlatBufferBuilder forceDefaults(boolean r100) {
        this.force_defaults = r100;
        return this;
    }

    public void pad(int r100) {
        int r101 = 0;
    L3:
        if (r101 >= r100) goto L5;
        ByteBuffer r102 = this.f15444bb;
        int r103 = this.f15445space - 1;
        this.f15445space = r103;
        r102.put(r103, (byte) 0);
        r101 = r101 + 1;
        goto L3
    }

    public void putBoolean(boolean r100) {
        ByteBuffer r101 = this.f15444bb;
        int r102 = this.f15445space - 1;
        this.f15445space = r102;
        r101.put(r102, r100 ? 1 : 0);
    }

    public void putByte(byte r100) {
        ByteBuffer r101 = this.f15444bb;
        int r102 = this.f15445space - 1;
        this.f15445space = r102;
        r101.put(r102, r100);
    }

    public void putDouble(double r100) {
        ByteBuffer r101 = this.f15444bb;
        int r102 = this.f15445space - 8;
        this.f15445space = r102;
        r101.putDouble(r102, r100);
    }

    public void putFloat(float r100) {
        ByteBuffer r101 = this.f15444bb;
        int r102 = this.f15445space - 4;
        this.f15445space = r102;
        r101.putFloat(r102, r100);
    }

    public void putInt(int r100) {
        ByteBuffer r101 = this.f15444bb;
        int r102 = this.f15445space - 4;
        this.f15445space = r102;
        r101.putInt(r102, r100);
    }

    public void putLong(long r100) {
        ByteBuffer r101 = this.f15444bb;
        int r102 = this.f15445space - 8;
        this.f15445space = r102;
        r101.putLong(r102, r100);
    }

    public void putShort(short r100) {
        ByteBuffer r101 = this.f15444bb;
        int r102 = this.f15445space - 2;
        this.f15445space = r102;
        r101.putShort(r102, r100);
    }

    public void slot(int r100) {
        this.vtable[r100] = offset();
    }

    public void startTable(int r100) {
        notNested();
        int[] r101 = this.vtable;
        if (r101 != null) goto L5;
    L6:
        this.vtable = new int[r100];
    L7:
        this.vtable_in_use = r100;
        Arrays.fill(this.vtable, 0, r100, 0);
        this.nested = true;
        this.object_start = offset();
        return;
    L5:
        if (r101.length >= r100) goto L7;
        goto L6
    }

    public FlatBufferBuilder(ByteBuffer r100) {
        this(r100, new HeapByteBufferFactory());
    }

    public int createByteVector(byte[] r100) {
        int r101 = r100.length;
        startVector(1, r101, 1);
        ByteBuffer r102 = this.f15444bb;
        int r103 = this.f15445space - r101;
        this.f15445space = r103;
        r102.position(r103);
        this.f15444bb.put(r100);
        return endVector();
    }

    public int createString(ByteBuffer r100) {
        int r101 = r100.remaining();
        addByte((byte) 0);
        startVector(1, r101, 1);
        ByteBuffer r102 = this.f15444bb;
        int r103 = this.f15445space - r101;
        this.f15445space = r103;
        r102.position(r103);
        this.f15444bb.put(r100);
        return endVector();
    }

    public FlatBufferBuilder(ByteBuffer r100, ByteBufferFactory r101) {
        this(r100.capacity(), r101, r100, Utf8.getDefault());
    }

    public static ByteBuffer growByteBuffer(ByteBuffer r100, ByteBufferFactory r101) {
        int r102 = r100.capacity();
        if (((-1073741824) & r102) != 0) goto L10;
        if (r102 != 0) goto L6;
        int r103 = 1;
    L7:
        r100.position(0);
        ByteBuffer r104 = r101.newByteBuffer(r103);
        r104.position(r104.clear().capacity() - r102);
        r104.put(r100);
        return r104;
    L6:
        r103 = r102 << 1;
        goto L7
    L10:
        throw new AssertionError("FlatBuffers: cannot grow buffer beyond 2 gigabytes.");
    }

    public static boolean isFieldPresent(Table r100, int r101) {
        if (r100.__offset(r101) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    public <T extends Table> int createSortedVectorOfTables(T r100, int[] r101) {
        r100.sortTables(r101, this.f15444bb);
        return createVectorOfTables(r101);
    }

    public void finish(int r100, boolean r101) {
        int r102 = this.minalign;
        if (r101 == false) goto L5;
        int r103 = 4;
    L6:
        prep(r102, r103 + 4);
        addOffset(r100);
        if (r101 == false) goto L9;
        addInt(this.f15444bb.capacity() - this.f15445space);
    L9:
        this.f15444bb.position(this.f15445space);
        this.finished = true;
        return;
    L5:
        r103 = 0;
        goto L6
    }

    public void finishSizePrefixed(int r100, String r101) {
        finish(r100, r101, true);
    }

    public FlatBufferBuilder init(ByteBuffer r100, ByteBufferFactory r101) {
        this.bb_factory = r101;
        this.f15444bb = r100;
        r100.clear();
        this.f15444bb.order(ByteOrder.LITTLE_ENDIAN);
        this.minalign = 1;
        this.f15445space = this.f15444bb.capacity();
        this.vtable_in_use = 0;
        this.nested = false;
        this.finished = false;
        this.object_start = 0;
        this.num_vtables = 0;
        this.vector_num_elems = 0;
        return this;
    }

    public void prep(int r100, int r101) {
        if (r100 <= this.minalign) goto L5;
        this.minalign = r100;
    L5:
        int r102 = ((~((this.f15444bb.capacity() - this.f15445space) + r101)) + 1) & (r100 - 1);
    L7:
        if (this.f15445space >= ((r102 + r100) + r101)) goto L12;
        int r103 = this.f15444bb.capacity();
        ByteBuffer r104 = this.f15444bb;
        ByteBuffer r105 = growByteBuffer(r104, this.bb_factory);
        this.f15444bb = r105;
        if (r104 == r105) goto L11;
        this.bb_factory.releaseByteBuffer(r104);
    L11:
        this.f15445space += this.f15444bb.capacity() - r103;
        goto L7
    L12:
        pad(r102);
    }

    public void required(int r100, int r101) {
        int r102 = this.f15444bb.capacity() - r100;
        if (this.f15444bb.getShort((r102 - this.f15444bb.getInt(r102)) + r101) == 0) goto L5;
        boolean r103 = true;
    L6:
        if (r103 == false) goto L9;
        return;
    L9:
        throw new AssertionError("FlatBuffers: field " + r101 + " must be set");
    L5:
        r103 = false;
        goto L6
    }

    public byte[] sizedByteArray(int r100, int r101) {
        finished();
        byte[] r102 = new byte[r101];
        this.f15444bb.position(r100);
        this.f15444bb.get(r102);
        return r102;
    }

    public FlatBufferBuilder(int r100, ByteBufferFactory r101) {
        this(r100, r101, null, Utf8.getDefault());
    }

    public void finish(int r100, String r101) {
        finish(r100, r101, false);
    }

    public void addBoolean(int r100, boolean r101, boolean r102) {
        if (this.force_defaults == true) goto L5;
        if (r101 != r102) goto L5;
        return;
    L5:
        addBoolean(r101);
        slot(r100);
    }

    public void addByte(int r100, byte r101, int r102) {
        if (this.force_defaults == true) goto L5;
        if (r101 != r102) goto L5;
        return;
    L5:
        addByte(r101);
        slot(r100);
    }

    public void addDouble(int r100, double r101, double r102) {
        if (this.force_defaults == false) goto L5;
    L6:
        addDouble(r101);
        slot(r100);
        return;
    L5:
        if (r101 != r102) goto L6;
    }

    public void addFloat(int r100, float r101, double r102) {
        if (this.force_defaults == false) goto L5;
    L6:
        addFloat(r101);
        slot(r100);
        return;
    L5:
        if (r101 != r102) goto L6;
    }

    public void addInt(int r100, int r101, int r102) {
        if (this.force_defaults == true) goto L5;
        if (r101 != r102) goto L5;
        return;
    L5:
        addInt(r101);
        slot(r100);
    }

    public void addLong(int r100, long r101, long r102) {
        if (this.force_defaults == false) goto L5;
    L6:
        addLong(r101);
        slot(r100);
        return;
    L5:
        if (r101 != r102) goto L6;
    }

    public void addOffset(int r100, int r101, int r102) {
        if (this.force_defaults == true) goto L5;
        if (r101 != r102) goto L5;
        return;
    L5:
        addOffset(r101);
        slot(r100);
    }

    public void addShort(int r100, short r101, int r102) {
        if (this.force_defaults == true) goto L5;
        if (r101 != r102) goto L5;
        return;
    L5:
        addShort(r101);
        slot(r100);
    }

    public void addStruct(int r100, int r101, int r102) {
        if (r101 == r102) goto L5;
        Nested(r101);
        slot(r100);
        return;
    }

    public int createByteVector(byte[] r100, int r101, int r102) {
        startVector(1, r102, 1);
        ByteBuffer r103 = this.f15444bb;
        int r104 = this.f15445space - r102;
        this.f15445space = r104;
        r103.position(r104);
        this.f15444bb.put(r100, r101, r102);
        return endVector();
    }

    public ByteBuffer createUnintializedVector(int r100, int r101, int r102) {
        int r103 = r100 * r101;
        startVector(r100, r101, r102);
        ByteBuffer r104 = this.f15444bb;
        int r105 = this.f15445space - r103;
        this.f15445space = r105;
        r104.position(r105);
        ByteBuffer r106 = this.f15444bb.slice().order(ByteOrder.LITTLE_ENDIAN);
        r106.limit(r103);
        return r106;
    }

    public void finish(int r100, String r101, boolean r102) {
        int r103 = this.minalign;
        if (r102 == false) goto L5;
        int r104 = 4;
    L6:
        prep(r103, r104 + 8);
        if (r101.length() != 4) goto L14;
        int r105 = 3;
    L9:
        if (r105 < 0) goto L11;
        addByte((byte) r101.charAt(r105));
        r105 = r105 - 1;
        goto L9
    L11:
        finish(r100, r102);
        return;
    L14:
        throw new AssertionError("FlatBuffers: file identifier must be length 4");
    L5:
        r104 = 0;
        goto L6
    }

    public void startVector(int r100, int r101, int r102) {
        notNested();
        this.vector_num_elems = r101;
        int r103 = r100 * r101;
        prep(4, r103);
        prep(r102, r103);
        this.nested = true;
    }

    public FlatBufferBuilder(int r100, ByteBufferFactory r101, ByteBuffer r102, Utf8 r103) {
        this.minalign = 1;
        this.vtable = null;
        this.vtable_in_use = 0;
        this.nested = false;
        this.finished = false;
        this.vtables = new int[16];
        this.num_vtables = 0;
        this.vector_num_elems = 0;
        this.force_defaults = false;
        if (r100 > 0) goto L5;
        r100 = 1;
    L5:
        this.bb_factory = r101;
        if (r102 == null) goto L8;
        this.f15444bb = r102;
        r102.clear();
        this.f15444bb.order(ByteOrder.LITTLE_ENDIAN);
    L9:
        this.utf8 = r103;
        this.f15445space = this.f15444bb.capacity();
        return;
    L8:
        this.f15444bb = r101.newByteBuffer(r100);
        goto L9
    }
}
