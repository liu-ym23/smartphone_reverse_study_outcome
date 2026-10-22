package androidx.emoji2.text.flatbuffer;

import androidx.collection.SieveCacheKt;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.math.BigInteger;
import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;

/* JADX INFO: loaded from: classes17.dex */
public class FlexBuffersBuilder {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    public static final int BUILDER_FLAG_NONE = 0;
    public static final int BUILDER_FLAG_SHARE_ALL = 7;
    public static final int BUILDER_FLAG_SHARE_KEYS = 1;
    public static final int BUILDER_FLAG_SHARE_KEYS_AND_STRINGS = 3;
    public static final int BUILDER_FLAG_SHARE_KEY_VECTORS = 4;
    public static final int BUILDER_FLAG_SHARE_STRINGS = 2;
    private static final int WIDTH_16 = 1;
    private static final int WIDTH_32 = 2;
    private static final int WIDTH_64 = 3;
    private static final int WIDTH_8 = 0;

    /* JADX INFO: renamed from: bb, reason: collision with root package name */
    private final ReadWriteBuf f15449bb;
    private boolean finished;
    private final int flags;
    private Comparator<Value> keyComparator;
    private final HashMap<String, Integer> keyPool;
    private final ArrayList<Value> stack;
    private final HashMap<String, Integer> stringPool;

    public static class Value {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        final double dValue;
        long iValue;
        int key;
        final int minBitWidth;
        final int type;

        private static byte packedType(int r100, int r101) {
            return (byte) (r100 | (r101 << 2));
        }

        private static int paddingBytes(int r100, int r101) {
            return ((~r100) + 1) & (r101 - 1);
        }

        private byte storedPackedType() {
            return storedPackedType(0);
        }

        static {
        }

        public static /* synthetic */ byte access$300(Value r100) {
            return r100.storedPackedType();
        }

        private byte storedPackedType(int r100) {
            return packedType(storedWidth(r100), this.type);
        }

        private int storedWidth(int r100) {
            if (FlexBuffers.isTypeInline(this.type) == false) goto L7;
            return Math.max(this.minBitWidth, r100);
        L7:
            return this.minBitWidth;
        }

        public static /* synthetic */ int access$100(int r100, int r101) {
            return paddingBytes(r100, r101);
        }

        public static /* synthetic */ byte access$400(Value r100, int r101) {
            return r100.storedPackedType(r101);
        }

        public static Value bool(int r100, boolean r101) {
            if (r101 == false) goto L5;
            long r102 = 1;
        L7:
            return new Value(r100, 26, 0, r102);
        L5:
            r102 = 0;
            goto L7
        }

        private int elemWidth(int r100, int r101) {
            return elemWidth(this.type, this.minBitWidth, this.iValue, r100, r101);
        }

        public static Value float32(int r100, float r101) {
            return new Value(r100, 3, 2, r101);
        }

        public static Value float64(int r100, double r101) {
            return new Value(r100, 3, 3, r101);
        }

        public static Value int16(int r100, int r101) {
            return new Value(r100, 1, 1, r101);
        }

        public static Value int32(int r100, int r101) {
            return new Value(r100, 1, 2, r101);
        }

        public static Value int64(int r100, long r101) {
            return new Value(r100, 1, 3, r101);
        }

        public static Value int8(int r100, int r101) {
            return new Value(r100, 1, 0, r101);
        }

        public static Value uInt16(int r100, int r101) {
            return new Value(r100, 2, 1, r101);
        }

        public static Value uInt32(int r100, int r101) {
            return new Value(r100, 2, 2, r101);
        }

        public static Value uInt64(int r100, long r101) {
            return new Value(r100, 2, 3, r101);
        }

        public static Value uInt8(int r100, int r101) {
            return new Value(r100, 2, 0, r101);
        }

        public static /* synthetic */ int access$200(Value r100, int r101, int r102) {
            return r100.elemWidth(r101, r102);
        }

        public Value(int r100, int r101, int r102, double r103) {
            this.key = r100;
            this.type = r101;
            this.minBitWidth = r102;
            this.dValue = r103;
            this.iValue = Long.MIN_VALUE;
        }

        public static Value blob(int r100, int r101, int r102, int r110) {
            return new Value(r100, r102, r110, r101);
        }

        public Value(int r100, int r101, int r102, long r103) {
            this.key = r100;
            this.type = r101;
            this.minBitWidth = r102;
            this.iValue = r103;
            this.dValue = Double.MIN_VALUE;
        }

        public static /* synthetic */ int access$500(int r100, int r101, long r102, int r103, int r104) {
            return elemWidth(r100, r101, r102, r103, r104);
        }

        private static int elemWidth(int r100, int r101, long r102, int r103, int r110) {
            if (FlexBuffers.isTypeInline(r100) == false) goto L5;
            return r101;
        L5:
            int r104 = 1;
        L7:
            if (r104 > 32) goto L12;
            int r105 = FlexBuffersBuilder.widthUInBits((int) (((long) ((paddingBytes(r103, r104) + r103) + (r110 * r104))) - r102));
            if ((1 << r105) == r104) goto L10;
            r104 = r104 * 2;
            goto L7
        L10:
            return r105;
        L12:
            return 3;
        }
    }

    public FlexBuffersBuilder() {
        this(256);
    }

    public ByteBuffer finish() {
        int r100 = align(Value.access$200((Value) ListProtector.get(this.stack, 0), this.f15449bb.writePosition(), 0));
        writeAny((Value) ListProtector.get(this.stack, 0), r100);
        this.f15449bb.put(Value.access$300((Value) ListProtector.get(this.stack, 0)));
        this.f15449bb.put((byte) r100);
        this.finished = true;
        return ByteBuffer.wrap(this.f15449bb.data(), 0, this.f15449bb.writePosition());
    }

    public int startMap() {
        return this.stack.size();
    }

    public int startVector() {
        return this.stack.size();
    }

    static {
    }

    public ReadWriteBuf getBuffer() {
        return this.f15449bb;
    }

    public FlexBuffersBuilder(int r100) {
        this(new ArrayReadWriteBuf(r100), 1);
    }

    public static /* synthetic */ ReadWriteBuf access$000(FlexBuffersBuilder r100) {
        return r100.f15449bb;
    }

    private int align(int r100) {
        int r101 = 1 << r100;
        int r102 = Value.access$100(this.f15449bb.writePosition(), r101);
    L3:
        int r103 = r102 - 1;
        if (r102 == 0) goto L6;
        this.f15449bb.put((byte) 0);
        r102 = r103;
        goto L3
    L6:
        return r101;
    }

    private int putKey(String r100) {
        if (r100 != null) goto L5;
        return -1;
    L5:
        int r101 = this.f15449bb.writePosition();
        if ((this.flags & 1) == 0) goto L11;
        Integer r102 = this.keyPool.get(r100);
        if (r102 != null) goto L14;
        byte[] r103 = r100.getBytes(StandardCharsets.UTF_8);
        this.f15449bb.put(r103, 0, r103.length);
        this.f15449bb.put((byte) 0);
        this.keyPool.put(r100, Integer.valueOf(r101));
        return r101;
    L14:
        return r102.intValue();
    L11:
        byte[] r104 = r100.getBytes(StandardCharsets.UTF_8);
        this.f15449bb.put(r104, 0, r104.length);
        this.f15449bb.put((byte) 0);
        this.keyPool.put(r100, Integer.valueOf(r101));
        return r101;
    }

    public static int widthUInBits(long r100) {
        if (r100 > FlexBuffers.Unsigned.byteToUnsignedInt((byte) -1)) goto L7;
        return 0;
    L7:
        if (r100 > FlexBuffers.Unsigned.shortToUnsignedInt(-1)) goto L11;
        return 1;
    L11:
        if (r100 > FlexBuffers.Unsigned.intToUnsignedLong(-1)) goto L14;
        return 2;
    L14:
        return 3;
    }

    public int putBlob(byte[] r100) {
        return putBlob(null, r100);
    }

    public void putBoolean(boolean r100) {
        putBoolean(null, r100);
    }

    public void putFloat(double r100) {
        putFloat(null, r100);
    }

    public void putInt(int r100) {
        putInt(null, r100);
    }

    public int putString(String r100) {
        return putString(null, r100);
    }

    public void putUInt(int r100) {
        putUInt(null, r100);
    }

    public void putUInt64(BigInteger r100) {
        putUInt64(null, r100.longValue());
    }

    public FlexBuffersBuilder(ByteBuffer r100) {
        this(r100, 1);
    }

    public void putFloat(float r100) {
        putFloat(null, r100);
    }

    public void putInt(long r100) {
        putInt(null, r100);
    }

    public void putUInt(long r100) {
        putUInt(null, r100);
    }

    public FlexBuffersBuilder(ReadWriteBuf r100, int r101) {
        this.stack = new ArrayList();
        this.keyPool = new HashMap();
        this.stringPool = new HashMap();
        this.finished = false;
        this.keyComparator = new AnonymousClass1(this);
        this.f15449bb = r100;
        this.flags = r101;
    }

    private Value createKeyVector(int r110, int r111) {
        long r100 = r111;
        int r101 = Math.max(0, widthUInBits(r100));
        int r112 = r110;
    L4:
        if (r112 >= this.stack.size()) goto L6;
        r112 = r112 + 1;
        r101 = Math.max(r101, Value.access$500(4, 0, ((Value) ListProtector.get(this.stack, r112)).key, this.f15449bb.writePosition(), r112));
        goto L4
    L6:
        int r113 = align(r101);
        writeInt(r100, r113);
        int r102 = this.f15449bb.writePosition();
    L8:
        if (r110 >= this.stack.size()) goto L11;
        int r103 = ((Value) ListProtector.get(this.stack, r110)).key;
        writeOffset(((Value) ListProtector.get(this.stack, r110)).key, r113);
        r110 = r110 + 1;
        goto L8
    L11:
        return new Value(-1, FlexBuffers.toTypedVector(4, 0), r101, r102);
    }

    private void putUInt(String r100, long r101) {
        int r102 = putKey(r100);
        int r103 = widthUInBits(r101);
        if (r103 != 0) goto L6;
        Value r104 = Value.uInt8(r102, (int) r101);
    L12:
        this.stack.add(r104);
        return;
    L6:
        if (r103 != 1) goto L9;
        r104 = Value.uInt16(r102, (int) r101);
        goto L12
    L9:
        if (r103 != 2) goto L11;
        r104 = Value.uInt32(r102, (int) r101);
        goto L12
    L11:
        r104 = Value.uInt64(r102, r101);
        goto L12
    }

    private void putUInt64(String r100, long r101) {
        this.stack.add(Value.uInt64(putKey(r100), r101));
    }

    private void writeAny(Value r100, int r101) {
        int r102 = r100.type;
        if (r102 != 0) goto L5;
    L14:
        writeInt(r100.iValue, r101);
        return;
    L5:
        if (r102 == 1) goto L14;
        if (r102 == 2) goto L14;
        if (r102 != 3) goto L11;
        writeDouble(r100.dValue, r101);
        return;
    L11:
        if (r102 == 26) goto L14;
        writeOffset(r100.iValue, r101);
    }

    private void writeDouble(double r100, int r101) {
        if (r101 != 4) goto L6;
        this.f15449bb.putFloat((float) r100);
        return;
    L6:
        if (r101 != 8) goto L10;
        this.f15449bb.putDouble(r100);
        return;
    }

    private void writeInt(long r100, int r101) {
        if (r101 != 1) goto L5;
        this.f15449bb.put((byte) r100);
        return;
    L5:
        if (r101 != 2) goto L7;
        this.f15449bb.putShort((short) r100);
        return;
    L7:
        if (r101 != 4) goto L9;
        this.f15449bb.putInt((int) r100);
        return;
    L9:
        if (r101 != 8) goto L19;
        this.f15449bb.putLong(r100);
        return;
    }

    private void writeOffset(long r100, int r101) {
        writeInt((int) (((long) this.f15449bb.writePosition()) - r100), r101);
    }

    private Value writeString(int r100, String r101) {
        return writeBlob(r100, r101.getBytes(StandardCharsets.UTF_8), 5, true);
    }

    public int endMap(String r100, int r101) {
        int r102 = putKey(r100);
        ArrayList<Value> r103 = this.stack;
        Collections.sort(r103.subList(r101, r103.size()), this.keyComparator);
        Value r104 = createVector(r102, r101, this.stack.size() - r101, false, false, createKeyVector(r101, this.stack.size() - r101));
    L4:
        if (this.stack.size() <= r101) goto L6;
        ArrayList<Value> r105 = this.stack;
        ListProtector.remove(r105, r105.size() - 1);
        goto L4
    L6:
        this.stack.add(r104);
        return (int) r104.iValue;
    }

    public int putBlob(String r100, byte[] r101) {
        Value r102 = writeBlob(putKey(r100), r101, 25, false);
        this.stack.add(r102);
        return (int) r102.iValue;
    }

    public void putBoolean(String r100, boolean r101) {
        this.stack.add(Value.bool(putKey(r100), r101));
    }

    public void putFloat(String r100, double r101) {
        this.stack.add(Value.float64(putKey(r100), r101));
    }

    public void putInt(String r100, long r101) {
        int r102 = putKey(r100);
        if ((-128) > r101) goto L8;
        if (r101 > 127) goto L8;
        this.stack.add(Value.int8(r102, (int) r101));
        return;
    L8:
        if ((-32768) > r101) goto L13;
        if (r101 > 32767) goto L13;
        this.stack.add(Value.int16(r102, (int) r101));
        return;
    L13:
        if (SieveCacheKt.NodeMetaAndPreviousMask <= r101) goto L15;
    L17:
        this.stack.add(Value.int64(r102, r101));
        return;
    L15:
        if (r101 > SieveCacheKt.NodeLinkMask) goto L17;
        this.stack.add(Value.int32(r102, (int) r101));
    }

    public int putString(String r100, String r101) {
        int r102 = putKey(r100);
        if ((this.flags & 2) == 0) goto L11;
        Integer r103 = this.stringPool.get(r101);
        if (r103 != null) goto L9;
        Value r104 = writeString(r102, r101);
        this.stringPool.put(r101, Integer.valueOf((int) r104.iValue));
        this.stack.add(r104);
        long r105 = r104.iValue;
    L8:
        return (int) r105;
    L9:
        this.stack.add(Value.blob(r102, r103.intValue(), 5, widthUInBits(r101.length())));
        return r103.intValue();
    L11:
        Value r106 = writeString(r102, r101);
        this.stack.add(r106);
        r105 = r106.iValue;
        goto L8
    }

    public FlexBuffersBuilder(ByteBuffer r100, int r101) {
        this(new ArrayReadWriteBuf(r100.array()), r101);
    }

    public void putFloat(String r100, float r101) {
        this.stack.add(Value.float32(putKey(r100), r101));
    }

    public void putInt(String r100, int r101) {
        putInt(r100, r101);
    }

    private Value writeBlob(int r100, byte[] r101, int r102, boolean r103) {
        int r104 = widthUInBits(r101.length);
        writeInt(r101.length, align(r104));
        int r105 = this.f15449bb.writePosition();
        this.f15449bb.put(r101, 0, r101.length);
        if (r103 == false) goto L6;
        this.f15449bb.put((byte) 0);
    L6:
        return Value.blob(r100, r105, r102, r104);
    }

    public int endVector(String r100, int r101, boolean r110, boolean r111) {
        Value r102 = createVector(putKey(r100), r101, this.stack.size() - r101, r110, r111, null);
    L4:
        if (this.stack.size() <= r101) goto L6;
        ArrayList<Value> r112 = this.stack;
        ListProtector.remove(r112, r112.size() - 1);
        goto L4
    L6:
        this.stack.add(r102);
        return (int) r102.iValue;
    }

    private Value createVector(int r110, int r111, int r112, boolean r113, boolean r210, Value r211) {
        int r100 = r112;
        long r101 = r100;
        int r102 = Math.max(0, widthUInBits(r101));
        if (r211 == null) goto L5;
        r102 = Math.max(r102, Value.access$200(r211, this.f15449bb.writePosition(), 0));
        int r103 = 3;
    L6:
        int r104 = 4;
        int r114 = r102;
        int r105 = r111;
    L8:
        if (r105 >= this.stack.size()) goto L18;
        r114 = Math.max(r114, Value.access$200((Value) ListProtector.get(this.stack, r105), this.f15449bb.writePosition(), r105 + r103));
        if (r113 == false) goto L17;
        if (r105 != r111) goto L17;
        r104 = ((Value) ListProtector.get(this.stack, r105)).type;
        if (FlexBuffers.isTypedVectorElementType(r104) == true) goto L17;
        throw new FlexBuffers.FlexBufferException("TypedVector does not support this element type");
    L17:
        r105 = r105 + 1;
        goto L8
    L18:
        int r106 = r111;
        int r107 = align(r114);
        if (r211 == null) goto L21;
        writeOffset(r211.iValue, r107);
        writeInt(1 << r211.minBitWidth, r107);
    L21:
        if (r210 == true) goto L23;
        writeInt(r101, r107);
    L23:
        int r108 = this.f15449bb.writePosition();
        int r109 = r106;
    L25:
        if (r109 >= this.stack.size()) goto L27;
        writeAny((Value) ListProtector.get(this.stack, r109), r107);
        r109 = r109 + 1;
        goto L25
    L27:
        if (r113 == true) goto L32;
    L29:
        if (r106 >= this.stack.size()) goto L32;
        this.f15449bb.put(Value.access$400((Value) ListProtector.get(this.stack, r106), r114));
        r106 = r106 + 1;
    L32:
        if (r211 == null) goto L34;
        int r115 = 9;
    L41:
        return new Value(r110, r115, r114, r108);
    L34:
        if (r113 == false) goto L39;
        if (r210 == true) goto L38;
        r100 = 0;
    L38:
        r115 = FlexBuffers.toTypedVector(r104, r100);
        goto L41
    L39:
        r115 = 10;
        goto L41
    L5:
        r103 = 1;
        goto L6
    }
}
