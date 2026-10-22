package androidx.emoji2.text.flatbuffer;

import androidx.camera.video.AudioStats;
import com.bytedance.mt.protector.impl.string2number.CastDoubleProtector;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.bytedance.mt.protector.impl.string2number.CastLongProtector;
import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;
import kotlin.UByte;
import kotlin.text.Typography;
import org.bouncycastle.asn1.cmc.BodyPartID;

/* JADX INFO: loaded from: classes17.dex */
public class FlexBuffers {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final ReadBuf EMPTY_BB = null;
    public static final int FBT_BLOB = 25;
    public static final int FBT_BOOL = 26;
    public static final int FBT_FLOAT = 3;
    public static final int FBT_INDIRECT_FLOAT = 8;
    public static final int FBT_INDIRECT_INT = 6;
    public static final int FBT_INDIRECT_UINT = 7;
    public static final int FBT_INT = 1;
    public static final int FBT_KEY = 4;
    public static final int FBT_MAP = 9;
    public static final int FBT_NULL = 0;
    public static final int FBT_STRING = 5;
    public static final int FBT_UINT = 2;
    public static final int FBT_VECTOR = 10;
    public static final int FBT_VECTOR_BOOL = 36;
    public static final int FBT_VECTOR_FLOAT = 13;
    public static final int FBT_VECTOR_FLOAT2 = 18;
    public static final int FBT_VECTOR_FLOAT3 = 21;
    public static final int FBT_VECTOR_FLOAT4 = 24;
    public static final int FBT_VECTOR_INT = 11;
    public static final int FBT_VECTOR_INT2 = 16;
    public static final int FBT_VECTOR_INT3 = 19;
    public static final int FBT_VECTOR_INT4 = 22;
    public static final int FBT_VECTOR_KEY = 14;
    public static final int FBT_VECTOR_STRING_DEPRECATED = 15;
    public static final int FBT_VECTOR_UINT = 12;
    public static final int FBT_VECTOR_UINT2 = 17;
    public static final int FBT_VECTOR_UINT3 = 20;
    public static final int FBT_VECTOR_UINT4 = 23;

    public static class Blob extends Sized {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        static final Blob EMPTY = null;

        static {
            EMPTY = new Blob(FlexBuffers.access$000(), 1, 1);
        }

        public ByteBuffer data() {
            ByteBuffer r100 = ByteBuffer.wrap(this.f15447bb.data());
            r100.position(this.end);
            r100.limit(this.end + size());
            return r100.asReadOnlyBuffer().slice();
        }

        @Override // androidx.emoji2.text.flatbuffer.FlexBuffers.Object
        public String toString() {
            return this.f15447bb.getString(this.end, size());
        }

        public byte[] getBytes() {
            int r100 = size();
            byte[] r101 = new byte[r100];
            int r102 = 0;
        L3:
            if (r102 >= r100) goto L5;
            r101[r102] = this.f15447bb.get(this.end + r102);
            r102 = r102 + 1;
            goto L3
        L5:
            return r101;
        }

        @Override // androidx.emoji2.text.flatbuffer.FlexBuffers.Sized
        public /* bridge */ /* synthetic */ int size() {
            return super.size();
        }

        public static Blob empty() {
            return EMPTY;
        }

        public byte get(int r100) {
            return this.f15447bb.get(this.end + r100);
        }

        @Override // androidx.emoji2.text.flatbuffer.FlexBuffers.Object
        public StringBuilder toString(StringBuilder r100) {
            r100.append(Typography.quote);
            r100.append(this.f15447bb.getString(this.end, size()));
            r100.append(Typography.quote);
            return r100;
        }

        public Blob(ReadBuf r100, int r101, int r102) {
            super(r100, r101, r102);
        }
    }

    public static class FlexBufferException extends RuntimeException {
        public FlexBufferException(String r100) {
            super(r100);
        }
    }

    public static class Key extends Object {
        private static final Key EMPTY = null;

        static {
            EMPTY = new Key(FlexBuffers.access$000(), 0, 0);
        }

        public int hashCode() {
            return this.end ^ this.byteWidth;
        }

        @Override // androidx.emoji2.text.flatbuffer.FlexBuffers.Object
        public String toString() {
            int r100 = this.end;
        L4:
            if (this.f15447bb.get(r100) == 0) goto L5;
            r100 = r100 + 1;
            goto L4
        L5:
            int r101 = this.end;
            ReadBuf r102 = this.f15447bb;
            return r102.getString(r101, r100 - r101);
        }

        public static /* synthetic */ Key access$700() {
            return EMPTY;
        }

        public static Key empty() {
            return EMPTY;
        }

        public int compareTo(byte[] r100) {
            int r101 = this.end;
            int r102 = 0;
        L3:
            byte r103 = this.f15447bb.get(r101);
            byte r104 = r100[r102];
            if (r103 == 0) goto L6;
            r101 = r101 + 1;
            r102 = r102 + 1;
            if (r102 == r100.length) goto L10;
            if (r103 == r104) goto L3;
            return r103 - r104;
        L10:
            return r103 - r104;
        L6:
            return r103 - r104;
        }

        public boolean equals(java.lang.Object r100) {
            if ((r100 instanceof Key) == true) goto L5;
            return false;
        L5:
            Key r101 = (Key) r100;
            if (r101.end == this.end) goto L8;
            return false;
        L8:
            if (r101.byteWidth != this.byteWidth) goto L12;
            return true;
        L12:
            return false;
        }

        @Override // androidx.emoji2.text.flatbuffer.FlexBuffers.Object
        public StringBuilder toString(StringBuilder r100) {
            r100.append(toString());
            return r100;
        }

        public Key(ReadBuf r100, int r101, int r102) {
            super(r100, r101, r102);
        }
    }

    public static class KeyVector {

        /* JADX INFO: renamed from: vec, reason: collision with root package name */
        private final TypedVector f15446vec;

        public int size() {
            return this.f15446vec.size();
        }

        public String toString() {
            StringBuilder r100 = new StringBuilder();
            r100.append('[');
            int r101 = 0;
        L4:
            if (r101 >= this.f15446vec.size()) goto L9;
            this.f15446vec.get(r101).toString(r100);
            if (r101 == (this.f15446vec.size() - 1)) goto L8;
            r100.append(", ");
        L8:
            r101 = r101 + 1;
            goto L4
        L9:
            r100.append("]");
            return r100.toString();
        }

        public KeyVector(TypedVector r100) {
            this.f15446vec = r100;
        }

        public Key get(int r100) {
            if (r100 >= size()) goto L5;
            TypedVector r101 = this.f15446vec;
            int r102 = r101.end + (r100 * r101.byteWidth);
            TypedVector r103 = this.f15446vec;
            ReadBuf r104 = r103.f15447bb;
            return new Key(r104, FlexBuffers.access$200(r104, r102, r103.byteWidth), 1);
        L5:
            return Key.access$700();
        }
    }

    public static class Map extends Vector {
        private static final Map EMPTY_MAP = null;

        static {
            EMPTY_MAP = new Map(FlexBuffers.access$000(), 1, 1);
        }

        public KeyVector keys() {
            int r100 = this.end - (this.byteWidth * 3);
            ReadBuf r101 = this.f15447bb;
            int r102 = FlexBuffers.access$200(r101, r100, this.byteWidth);
            ReadBuf r103 = this.f15447bb;
            int r104 = this.byteWidth;
            return new KeyVector(new TypedVector(r101, r102, FlexBuffers.access$100(r103, r100 + r104, r104), 4));
        }

        public Vector values() {
            return new Vector(this.f15447bb, this.end, this.byteWidth);
        }

        public static Map empty() {
            return EMPTY_MAP;
        }

        public Reference get(byte[] r100) {
            KeyVector r101 = keys();
            int r102 = r101.size();
            int r103 = binarySearch(r101, r100);
            if (r103 < 0) goto L8;
            if (r103 >= r102) goto L8;
            return get(r103);
        L8:
            return Reference.access$600();
        }

        @Override // androidx.emoji2.text.flatbuffer.FlexBuffers.Vector, androidx.emoji2.text.flatbuffer.FlexBuffers.Object
        public StringBuilder toString(StringBuilder r100) {
            r100.append("{ ");
            KeyVector r101 = keys();
            int r102 = size();
            Vector r103 = values();
            int r104 = 0;
        L3:
            if (r104 >= r102) goto L8;
            r100.append(Typography.quote);
            r100.append(r101.get(r104).toString());
            r100.append("\" : ");
            r100.append(r103.get(r104).toString());
            if (r104 == (r102 - 1)) goto L7;
            r100.append(", ");
        L7:
            r104 = r104 + 1;
            goto L3
        L8:
            r100.append(" }");
            return r100;
        }

        public Reference get(String r100) {
            return get(r100.getBytes(StandardCharsets.UTF_8));
        }

        private int binarySearch(KeyVector r100, byte[] r101) {
            int r102 = r100.size() - 1;
            int r103 = 0;
        L3:
            if (r103 > r102) goto L11;
            int r104 = (r103 + r102) >>> 1;
            int r105 = r100.get(r104).compareTo(r101);
            if (r105 < 0) goto L6;
            if (r105 <= 0) goto L9;
            r102 = r104 - 1;
            goto L3
        L9:
            return r104;
        L6:
            r103 = r104 + 1;
            goto L3
        L11:
            return -(r103 + 1);
        }

        public Map(ReadBuf r100, int r101, int r102) {
            super(r100, r101, r102);
        }
    }

    public static abstract class Object {

        /* JADX INFO: renamed from: bb, reason: collision with root package name */
        ReadBuf f15447bb;
        int byteWidth;
        int end;

        public abstract StringBuilder toString(StringBuilder r100);

        public String toString() {
            return toString(new StringBuilder(128)).toString();
        }

        public Object(ReadBuf r100, int r101, int r102) {
            this.f15447bb = r100;
            this.end = r101;
            this.byteWidth = r102;
        }
    }

    public static class Reference {
        private static final Reference NULL_REFERENCE = null;

        /* JADX INFO: renamed from: bb, reason: collision with root package name */
        private ReadBuf f15448bb;
        private int byteWidth;
        private int end;
        private int parentWidth;
        private int type;

        static {
            NULL_REFERENCE = new Reference(FlexBuffers.access$000(), 0, 1, 0);
        }

        public double asFloat() {
            int r100 = this.type;
            if (r100 != 3) goto L7;
            return FlexBuffers.access$400(this.f15448bb, this.end, this.parentWidth);
        L7:
            if (r100 == 1) goto L37;
            if (r100 == 2) goto L35;
            if (r100 == 5) goto L33;
            if (r100 != 6) goto L15;
            ReadBuf r101 = this.f15448bb;
            return FlexBuffers.access$100(r101, FlexBuffers.access$200(r101, this.end, this.parentWidth), this.byteWidth);
        L15:
            if (r100 != 7) goto L17;
            ReadBuf r102 = this.f15448bb;
            return FlexBuffers.access$300(r102, FlexBuffers.access$200(r102, this.end, this.parentWidth), this.byteWidth);
        L17:
            if (r100 != 8) goto L19;
            ReadBuf r103 = this.f15448bb;
            return FlexBuffers.access$400(r103, FlexBuffers.access$200(r103, this.end, this.parentWidth), this.byteWidth);
        L19:
            if (r100 == 10) goto L25;
            if (r100 == 26) goto L35;
            return AudioStats.AUDIO_AMPLITUDE_NONE;
        L25:
            return asVector().size();
        L33:
            return CastDoubleProtector.parseDouble(asString());
        L35:
            return FlexBuffers.access$300(this.f15448bb, this.end, this.parentWidth);
        L37:
            return FlexBuffers.access$100(this.f15448bb, this.end, this.parentWidth);
        }

        public int asInt() {
            int r100 = this.type;
            if (r100 != 1) goto L7;
            return FlexBuffers.access$100(this.f15448bb, this.end, this.parentWidth);
        L7:
            if (r100 != 2) goto L9;
            long r101 = FlexBuffers.access$300(this.f15448bb, this.end, this.parentWidth);
        L32:
            return (int) r101;
        L9:
            if (r100 == 3) goto L38;
            if (r100 == 5) goto L36;
            if (r100 != 6) goto L15;
            ReadBuf r102 = this.f15448bb;
            return FlexBuffers.access$100(r102, FlexBuffers.access$200(r102, this.end, this.parentWidth), this.byteWidth);
        L15:
            if (r100 != 7) goto L17;
            ReadBuf r103 = this.f15448bb;
            r101 = FlexBuffers.access$300(r103, FlexBuffers.access$200(r103, this.end, this.parentWidth), this.parentWidth);
            goto L32
        L17:
            if (r100 != 8) goto L19;
            ReadBuf r104 = this.f15448bb;
            return (int) FlexBuffers.access$400(r104, FlexBuffers.access$200(r104, this.end, this.parentWidth), this.byteWidth);
        L19:
            if (r100 == 10) goto L27;
            if (r100 == 26) goto L25;
            return 0;
        L25:
            return FlexBuffers.access$100(this.f15448bb, this.end, this.parentWidth);
        L27:
            return asVector().size();
        L36:
            return CastIntegerProtector.parseInt(asString());
        L38:
            return (int) FlexBuffers.access$400(this.f15448bb, this.end, this.parentWidth);
        }

        public long asLong() {
            int r100 = this.type;
            if (r100 != 1) goto L7;
            return FlexBuffers.access$500(this.f15448bb, this.end, this.parentWidth);
        L7:
            if (r100 == 2) goto L39;
            if (r100 == 3) goto L37;
            if (r100 != 5) goto L13;
            return CastLongProtector.parseLong(asString());
        L35:
            return 0;
        L13:
            if (r100 != 6) goto L15;
            ReadBuf r101 = this.f15448bb;
            return FlexBuffers.access$500(r101, FlexBuffers.access$200(r101, this.end, this.parentWidth), this.byteWidth);
        L15:
            if (r100 != 7) goto L17;
            ReadBuf r102 = this.f15448bb;
            return FlexBuffers.access$300(r102, FlexBuffers.access$200(r102, this.end, this.parentWidth), this.parentWidth);
        L17:
            if (r100 != 8) goto L19;
            ReadBuf r103 = this.f15448bb;
            return (long) FlexBuffers.access$400(r103, FlexBuffers.access$200(r103, this.end, this.parentWidth), this.byteWidth);
        L19:
            if (r100 == 10) goto L26;
            if (r100 == 26) goto L24;
            return 0;
        L24:
            return FlexBuffers.access$100(this.f15448bb, this.end, this.parentWidth);
        L26:
            return asVector().size();
        L37:
            return (long) FlexBuffers.access$400(this.f15448bb, this.end, this.parentWidth);
        L39:
            return FlexBuffers.access$300(this.f15448bb, this.end, this.parentWidth);
        }

        public long asUInt() {
            int r100 = this.type;
            if (r100 != 2) goto L7;
            return FlexBuffers.access$300(this.f15448bb, this.end, this.parentWidth);
        L7:
            if (r100 == 1) goto L39;
            if (r100 == 3) goto L37;
            if (r100 == 10) goto L35;
            if (r100 == 26) goto L33;
            if (r100 == 5) goto L31;
            if (r100 != 6) goto L19;
            ReadBuf r101 = this.f15448bb;
            return FlexBuffers.access$500(r101, FlexBuffers.access$200(r101, this.end, this.parentWidth), this.byteWidth);
        L19:
            if (r100 != 7) goto L21;
            ReadBuf r102 = this.f15448bb;
            return FlexBuffers.access$300(r102, FlexBuffers.access$200(r102, this.end, this.parentWidth), this.byteWidth);
        L21:
            if (r100 == 8) goto L24;
            return 0;
        L24:
            ReadBuf r103 = this.f15448bb;
            return (long) FlexBuffers.access$400(r103, FlexBuffers.access$200(r103, this.end, this.parentWidth), this.parentWidth);
        L31:
            return CastLongProtector.parseLong(asString());
        L33:
            return FlexBuffers.access$100(this.f15448bb, this.end, this.parentWidth);
        L35:
            return asVector().size();
        L37:
            return (long) FlexBuffers.access$400(this.f15448bb, this.end, this.parentWidth);
        L39:
            return FlexBuffers.access$500(this.f15448bb, this.end, this.parentWidth);
        }

        public boolean isBlob() {
            if (this.type != 25) goto L5;
            return true;
        L5:
            return false;
        }

        public boolean isBoolean() {
            if (this.type != 26) goto L5;
            return true;
        L5:
            return false;
        }

        public boolean isFloat() {
            int r100 = this.type;
            if (r100 != 3) goto L5;
        L8:
            return true;
        L5:
            if (r100 == 8) goto L8;
            return false;
        }

        public boolean isInt() {
            int r100 = this.type;
            if (r100 != 1) goto L5;
            return true;
        L5:
            if (r100 == 6) goto L10;
            return false;
        L10:
            return true;
        }

        public boolean isKey() {
            if (this.type != 4) goto L5;
            return true;
        L5:
            return false;
        }

        public boolean isMap() {
            if (this.type != 9) goto L5;
            return true;
        L5:
            return false;
        }

        public boolean isNull() {
            if (this.type != 0) goto L5;
            return true;
        L5:
            return false;
        }

        public boolean isString() {
            if (this.type != 5) goto L5;
            return true;
        L5:
            return false;
        }

        public boolean isTypedVector() {
            return FlexBuffers.isTypedVector(this.type);
        }

        public boolean isUInt() {
            int r100 = this.type;
            if (r100 != 2) goto L5;
        L8:
            return true;
        L5:
            if (r100 == 7) goto L8;
            return false;
        }

        public boolean isVector() {
            int r100 = this.type;
            if (r100 != 10) goto L5;
        L8:
            return true;
        L5:
            if (r100 == 9) goto L8;
            return false;
        }

        public String toString() {
            return toString(new StringBuilder(128)).toString();
        }

        public Blob asBlob() {
            if (isBlob() == false) goto L5;
        L9:
            ReadBuf r100 = this.f15448bb;
            return new Blob(r100, FlexBuffers.access$200(r100, this.end, this.parentWidth), this.byteWidth);
        L5:
            if (isString() == true) goto L9;
            return Blob.empty();
        }

        public boolean asBoolean() {
            if (isBoolean() == false) goto L10;
            if (this.f15448bb.get(this.end) != 0) goto L14;
            return false;
        L14:
            return true;
        L10:
            if (asUInt() != 0) goto L15;
            return false;
        L15:
            return true;
        }

        public Key asKey() {
            if (isKey() == false) goto L7;
            ReadBuf r100 = this.f15448bb;
            return new Key(r100, FlexBuffers.access$200(r100, this.end, this.parentWidth), this.byteWidth);
        L7:
            return Key.empty();
        }

        public Map asMap() {
            if (isMap() == false) goto L7;
            ReadBuf r100 = this.f15448bb;
            return new Map(r100, FlexBuffers.access$200(r100, this.end, this.parentWidth), this.byteWidth);
        L7:
            return Map.empty();
        }

        public String asString() {
            if (isString() == false) goto L7;
            int r100 = FlexBuffers.access$200(this.f15448bb, this.end, this.parentWidth);
            ReadBuf r101 = this.f15448bb;
            int r102 = this.byteWidth;
            int r103 = (int) FlexBuffers.access$300(r101, r100 - r102, r102);
            return this.f15448bb.getString(r100, r103);
        L7:
            if (isKey() == false) goto L14;
            int r104 = FlexBuffers.access$200(this.f15448bb, this.end, this.byteWidth);
            int r105 = r104;
        L10:
            if (this.f15448bb.get(r105) == 0) goto L12;
            r105 = r105 + 1;
            goto L10
        L12:
            return this.f15448bb.getString(r104, r105 - r104);
        L14:
            return "";
        }

        public Vector asVector() {
            if (isVector() == false) goto L6;
            ReadBuf r100 = this.f15448bb;
            return new Vector(r100, FlexBuffers.access$200(r100, this.end, this.parentWidth), this.byteWidth);
        L6:
            int r101 = this.type;
            if (r101 != 15) goto L11;
            ReadBuf r102 = this.f15448bb;
            return new TypedVector(r102, FlexBuffers.access$200(r102, this.end, this.parentWidth), this.byteWidth, 4);
        L11:
            if (FlexBuffers.isTypedVector(r101) == false) goto L15;
            ReadBuf r103 = this.f15448bb;
            return new TypedVector(r103, FlexBuffers.access$200(r103, this.end, this.parentWidth), this.byteWidth, FlexBuffers.toTypedVectorElementType(this.type));
        L15:
            return Vector.empty();
        }

        public boolean isIntOrUInt() {
            if (isInt() == false) goto L5;
        L8:
            return true;
        L5:
            if (isUInt() == true) goto L8;
            return false;
        }

        public boolean isNumeric() {
            if (isIntOrUInt() == false) goto L5;
        L8:
            return true;
        L5:
            if (isFloat() == true) goto L8;
            return false;
        }

        public static /* synthetic */ Reference access$600() {
            return NULL_REFERENCE;
        }

        public int getType() {
            return this.type;
        }

        public StringBuilder toString(StringBuilder r100) {
            int r101 = this.type;
            if (r101 != 36) goto L5;
        L29:
            r100.append(asVector());
            return r100;
        L5:
            switch(r101) {
                case 0: goto L27;
                case 1: goto L25;
                case 2: goto L23;
                case 3: goto L21;
                case 4: goto L19;
                case 5: goto L17;
                case 6: goto L25;
                case 7: goto L23;
                case 8: goto L21;
                case 9: goto L16;
                case 10: goto L14;
                case 11: goto L29;
                case 12: goto L29;
                case 13: goto L29;
                case 14: goto L29;
                case 15: goto L29;
                case 16: goto L12;
                case 17: goto L12;
                case 18: goto L12;
                case 19: goto L12;
                case 20: goto L12;
                case 21: goto L12;
                case 22: goto L12;
                case 23: goto L12;
                case 24: goto L12;
                case 25: goto L10;
                case 26: goto L7;
                default: goto L6;
            };
        L6:
            return r100;
        L7:
            r100.append(asBoolean());
            return r100;
        L17:
            r100.append(Typography.quote);
            r100.append(asString());
            r100.append(Typography.quote);
            return r100;
        L19:
            Key r102 = asKey();
            r100.append(Typography.quote);
            StringBuilder r103 = r102.toString(r100);
            r103.append(Typography.quote);
            return r103;
        L21:
            r100.append(asFloat());
            return r100;
        L23:
            r100.append(asUInt());
            return r100;
        L25:
            r100.append(asLong());
            return r100;
        L27:
            r100.append("null");
            return r100;
        L10:
            return asBlob().toString(r100);
        L12:
            throw new FlexBufferException("not_implemented:" + this.type);
        L14:
            return asVector().toString(r100);
        L16:
            return asMap().toString(r100);
        }

        public Reference(ReadBuf r100, int r110, int r111, int r112) {
            this(r100, r110, r111, 1 << (r112 & 3), r112 >> 2);
        }

        public Reference(ReadBuf r100, int r101, int r102, int r103, int r104) {
            this.f15448bb = r100;
            this.end = r101;
            this.parentWidth = r102;
            this.byteWidth = r103;
            this.type = r104;
        }
    }

    public static abstract class Sized extends Object {
        protected final int size;

        public int size() {
            return this.size;
        }

        public Sized(ReadBuf r100, int r101, int r102) {
            super(r100, r101, r102);
            this.size = FlexBuffers.access$100(this.f15447bb, r101 - r102, r102);
        }
    }

    public static class TypedVector extends Vector {
        private static final TypedVector EMPTY_VECTOR = null;
        private final int elemType;

        static {
            EMPTY_VECTOR = new TypedVector(FlexBuffers.access$000(), 1, 1, 1);
        }

        public boolean isEmptyVector() {
            if (this != EMPTY_VECTOR) goto L5;
            return true;
        L5:
            return false;
        }

        public static TypedVector empty() {
            return EMPTY_VECTOR;
        }

        public int getElemType() {
            return this.elemType;
        }

        @Override // androidx.emoji2.text.flatbuffer.FlexBuffers.Vector
        public Reference get(int r100) {
            if (r100 >= size()) goto L5;
            int r101 = this.end + (r100 * this.byteWidth);
            return new Reference(this.f15447bb, r101, this.byteWidth, 1, this.elemType);
        L5:
            return Reference.access$600();
        }

        public TypedVector(ReadBuf r100, int r101, int r102, int r103) {
            super(r100, r101, r102);
            this.elemType = r103;
        }
    }

    public static class Unsigned {
        public Unsigned() {
        }

        public static int byteToUnsignedInt(byte r100) {
            return r100 & UByte.MAX_VALUE;
        }

        public static long intToUnsignedLong(int r100) {
            return ((long) r100) & BodyPartID.bodyIdMax;
        }

        public static int shortToUnsignedInt(short r100) {
            return r100 & 65535;
        }
    }

    public static class Vector extends Sized {
        private static final Vector EMPTY_VECTOR = null;

        static {
            EMPTY_VECTOR = new Vector(FlexBuffers.access$000(), 1, 1);
        }

        public boolean isEmpty() {
            if (this != EMPTY_VECTOR) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // androidx.emoji2.text.flatbuffer.FlexBuffers.Sized
        public /* bridge */ /* synthetic */ int size() {
            return super.size();
        }

        @Override // androidx.emoji2.text.flatbuffer.FlexBuffers.Object
        public /* bridge */ /* synthetic */ String toString() {
            return super.toString();
        }

        public static Vector empty() {
            return EMPTY_VECTOR;
        }

        public Reference get(int r110) {
            long r100 = size();
            long r101 = r110;
            if (r101 >= r100) goto L5;
            int r102 = Unsigned.byteToUnsignedInt(this.f15447bb.get((int) ((((long) this.end) + (r100 * ((long) this.byteWidth))) + r101)));
            return new Reference(this.f15447bb, this.end + (r110 * this.byteWidth), this.byteWidth, r102);
        L5:
            return Reference.access$600();
        }

        @Override // androidx.emoji2.text.flatbuffer.FlexBuffers.Object
        public StringBuilder toString(StringBuilder r100) {
            r100.append("[ ");
            int r101 = size();
            int r102 = 0;
        L3:
            if (r102 >= r101) goto L8;
            get(r102).toString(r100);
            if (r102 == (r101 - 1)) goto L7;
            r100.append(", ");
        L7:
            r102 = r102 + 1;
            goto L3
        L8:
            r100.append(" ]");
            return r100;
        }

        public Vector(ReadBuf r100, int r101, int r102) {
            super(r100, r101, r102);
        }
    }

    public FlexBuffers() {
    }

    public static boolean isTypeInline(int r100) {
        if (r100 > 3) goto L5;
    L8:
        return true;
    L5:
        if (r100 == 26) goto L8;
        return false;
    }

    public static boolean isTypedVector(int r100) {
        if (r100 < 11) goto L7;
        if (r100 > 15) goto L7;
    L8:
        return true;
    L7:
        if (r100 == 36) goto L8;
        return false;
    }

    public static boolean isTypedVectorElementType(int r100) {
        if (r100 < 1) goto L7;
        if (r100 > 4) goto L7;
        return true;
    L7:
        if (r100 == 26) goto L12;
        return false;
    L12:
        return true;
    }

    public static int toTypedVector(int r100, int r101) {
        if (r101 == 0) goto L18;
        if (r101 == 2) goto L16;
        if (r101 == 3) goto L14;
        if (r101 == 4) goto L12;
        return 0;
    L12:
        return (r100 - 1) + 22;
    L14:
        return (r100 - 1) + 19;
    L16:
        return (r100 - 1) + 16;
    L18:
        return (r100 - 1) + 11;
    }

    public static int toTypedVectorElementType(int r100) {
        return (r100 - 11) + 1;
    }

    static {
        EMPTY_BB = new ArrayReadWriteBuf(new byte[]{0}, 1);
    }

    public static /* synthetic */ ReadBuf access$000() {
        return EMPTY_BB;
    }

    public static Reference getRoot(ByteBuffer r100) {
        if (r100.hasArray() == false) goto L5;
        ReadBuf r101 = new ArrayReadWriteBuf(r100.array(), r100.limit());
    L7:
        return getRoot(r101);
    L5:
        r101 = new ByteBufferReadWriteBuf(r100);
        goto L7
    }

    public static Reference getRoot(ReadBuf r100) {
        int r101 = r100.limit() - 1;
        byte r102 = r100.get(r101);
        int r103 = r101 - 1;
        return new Reference(r100, r103 - r102, r102, Unsigned.byteToUnsignedInt(r100.get(r103)));
    }

    public static /* synthetic */ int access$100(ReadBuf r100, int r101, int r102) {
        return readInt(r100, r101, r102);
    }

    public static /* synthetic */ int access$200(ReadBuf r100, int r101, int r102) {
        return indirect(r100, r101, r102);
    }

    public static /* synthetic */ long access$300(ReadBuf r100, int r101, int r102) {
        return readUInt(r100, r101, r102);
    }

    public static /* synthetic */ double access$400(ReadBuf r100, int r101, int r102) {
        return readDouble(r100, r101, r102);
    }

    public static /* synthetic */ long access$500(ReadBuf r100, int r101, int r102) {
        return readLong(r100, r101, r102);
    }

    private static int indirect(ReadBuf r100, int r101, int r102) {
        return (int) (((long) r101) - readUInt(r100, r101, r102));
    }

    private static double readDouble(ReadBuf r100, int r101, int r102) {
        if (r102 == 4) goto L11;
        if (r102 == 8) goto L9;
        return -1.0d;
    L9:
        return r100.getDouble(r101);
    L11:
        return r100.getFloat(r101);
    }

    private static int readInt(ReadBuf r100, int r101, int r102) {
        return (int) readLong(r100, r101, r102);
    }

    private static long readLong(ReadBuf r100, int r101, int r102) {
        if (r102 != 1) goto L5;
        int r103 = r100.get(r101);
    L16:
        return r103;
    L5:
        if (r102 != 2) goto L7;
        r103 = r100.getShort(r101);
        goto L16
    L7:
        if (r102 != 4) goto L9;
        r103 = r100.getInt(r101);
        goto L16
    L9:
        if (r102 == 8) goto L13;
        return -1;
    L13:
        return r100.getLong(r101);
    }

    private static long readUInt(ReadBuf r100, int r101, int r102) {
        if (r102 == 1) goto L19;
        if (r102 == 2) goto L17;
        if (r102 == 4) goto L15;
        if (r102 == 8) goto L13;
        return -1;
    L13:
        return r100.getLong(r101);
    L15:
        return Unsigned.intToUnsignedLong(r100.getInt(r101));
    L17:
        return Unsigned.shortToUnsignedInt(r100.getShort(r101));
    L19:
        return Unsigned.byteToUnsignedInt(r100.get(r101));
    }
}
