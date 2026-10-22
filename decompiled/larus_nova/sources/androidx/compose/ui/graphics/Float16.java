package androidx.compose.ui.graphics;

import androidx.exifinterface.media.ExifInterface;
import com.bytedance.ee.bear.drive.biz.upload.filepicker.model.NamedPipe;
import kotlin.Metadata;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.ShortCompanionObject;
import kotlin.text.CharsKt;
import kotlin.text.Regex;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u000f\n\u0000\n\u0002\u0010\n\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0004\n\u0002\u0010\u0005\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\r\n\u0002\u0010\u000e\n\u0002\b\u001a\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0081@\u0018\u0000 O2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001OB\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005B\u0011\b\u0016\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\u0004\u0010\bB\u0011\b\u0016\u0012\u0006\u0010\u0006\u001a\u00020\t¢\u0006\u0004\b\u0004\u0010\nJ\r\u0010\r\u001a\u00020\u000e¢\u0006\u0004\b\u000f\u0010\u0010J\r\u0010\u0011\u001a\u00020\u0003¢\u0006\u0004\b\u0012\u0010\u0005J\r\u0010\u0013\u001a\u00020\u0014¢\u0006\u0004\b\u0015\u0010\u0016J\r\u0010\u0017\u001a\u00020\u0018¢\u0006\u0004\b\u0019\u0010\u001aJ\r\u0010\u001b\u001a\u00020\u0007¢\u0006\u0004\b\u001c\u0010\u001dJ\r\u0010\u001e\u001a\u00020\t¢\u0006\u0004\b\u001f\u0010 J\r\u0010!\u001a\u00020\u0014¢\u0006\u0004\b\"\u0010\u0016J\r\u0010#\u001a\u00020\u0014¢\u0006\u0004\b$\u0010\u0016J\u000f\u0010%\u001a\u00020&H\u0016¢\u0006\u0004\b'\u0010(J\u0018\u0010)\u001a\u00020\u00142\u0006\u0010*\u001a\u00020\u0000H\u0096\u0002¢\u0006\u0004\b+\u0010,J\u0015\u0010/\u001a\u00020\u00002\u0006\u0010-\u001a\u00020\u0000¢\u0006\u0004\b0\u00101J\r\u00102\u001a\u00020\u0000¢\u0006\u0004\b3\u0010\u0005J\r\u00104\u001a\u00020\u0000¢\u0006\u0004\b5\u0010\u0005J\r\u00106\u001a\u00020\u0000¢\u0006\u0004\b7\u0010\u0005J\r\u00108\u001a\u00020\u0000¢\u0006\u0004\b9\u0010\u0005J\r\u0010:\u001a\u00020\u0000¢\u0006\u0004\b;\u0010\u0005J\r\u0010@\u001a\u00020A¢\u0006\u0004\bB\u0010CJ\r\u0010D\u001a\u00020A¢\u0006\u0004\bE\u0010CJ\r\u0010F\u001a\u00020A¢\u0006\u0004\bG\u0010CJ\r\u0010H\u001a\u00020A¢\u0006\u0004\bI\u0010CJ\r\u0010J\u001a\u00020&¢\u0006\u0004\bK\u0010(J\u0013\u0010L\u001a\u00020A2\b\u0010*\u001a\u0004\u0018\u00010MHÖ\u0003J\t\u0010N\u001a\u00020\u0014HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010-\u001a\u00020\u00008F¢\u0006\u0006\u001a\u0004\b.\u0010\u0005R\u0011\u0010<\u001a\u00020\u00148F¢\u0006\u0006\u001a\u0004\b=\u0010\u0016R\u0011\u0010>\u001a\u00020\u00148F¢\u0006\u0006\u001a\u0004\b?\u0010\u0016\u0088\u0001\u0002¨\u0006P"}, d2 = {"Landroidx/compose/ui/graphics/Float16;", "", "halfValue", "", "constructor-impl", "(S)S", "value", "", "(F)S", "", "(D)S", "getHalfValue", "()S", "toByte", "", "toByte-impl", "(S)B", "toShort", "toShort-impl", "toInt", "", "toInt-impl", "(S)I", "toLong", "", "toLong-impl", "(S)J", "toFloat", "toFloat-impl", "(S)F", "toDouble", "toDouble-impl", "(S)D", "toBits", "toBits-impl", "toRawBits", "toRawBits-impl", "toString", "", "toString-impl", "(S)Ljava/lang/String;", "compareTo", "other", "compareTo-41bOqos", "(SS)I", "sign", "getSign-slo4al4", "withSign", "withSign-qCeQghg", "(SS)S", "absoluteValue", "absoluteValue-slo4al4", "round", "round-slo4al4", "ceil", "ceil-slo4al4", "floor", "floor-slo4al4", "trunc", "trunc-slo4al4", "exponent", "getExponent-impl", "significand", "getSignificand-impl", "isNaN", "", "isNaN-impl", "(S)Z", "isInfinite", "isInfinite-impl", "isFinite", "isFinite-impl", "isNormalized", "isNormalized-impl", "toHexString", "toHexString-impl", "equals", "", "hashCode", "Companion", "ui-graphics_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
@JvmInline
public final class Float16 implements Comparable<Float16> {
    public static final Companion Companion = null;
    private static final short Epsilon = 0;
    private static final short LowestValue = 0;
    public static final int MaxExponent = 15;
    private static final short MaxValue = 0;
    public static final int MinExponent = -14;
    private static final short MinNormal = 0;
    private static final short MinValue = 0;
    private static final short NaN = 0;
    private static final short NegativeInfinity = 0;
    private static final short NegativeZero = 0;
    private static final short PositiveInfinity = 0;
    private static final short PositiveZero = 0;
    public static final int Size = 16;
    private final short halfValue;

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0018\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u0013\u0010\u0006\u001a\u00020\u0007¢\u0006\n\n\u0002\u0010\n\u001a\u0004\b\b\u0010\tR\u000e\u0010\u000b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u0013\u0010\r\u001a\u00020\u0007¢\u0006\n\n\u0002\u0010\n\u001a\u0004\b\u000e\u0010\tR\u0013\u0010\u000f\u001a\u00020\u0007¢\u0006\n\n\u0002\u0010\n\u001a\u0004\b\u0010\u0010\tR\u0013\u0010\u0011\u001a\u00020\u0007¢\u0006\n\n\u0002\u0010\n\u001a\u0004\b\u0012\u0010\tR\u0013\u0010\u0013\u001a\u00020\u0007¢\u0006\n\n\u0002\u0010\n\u001a\u0004\b\u0014\u0010\tR\u0013\u0010\u0015\u001a\u00020\u0007¢\u0006\n\n\u0002\u0010\n\u001a\u0004\b\u0016\u0010\tR\u0013\u0010\u0017\u001a\u00020\u0007¢\u0006\n\n\u0002\u0010\n\u001a\u0004\b\u0018\u0010\tR\u0013\u0010\u0019\u001a\u00020\u0007¢\u0006\n\n\u0002\u0010\n\u001a\u0004\b\u001a\u0010\tR\u0013\u0010\u001b\u001a\u00020\u0007¢\u0006\n\n\u0002\u0010\n\u001a\u0004\b\u001c\u0010\tR\u0013\u0010\u001d\u001a\u00020\u0007¢\u0006\n\n\u0002\u0010\n\u001a\u0004\b\u001e\u0010\t¨\u0006\u001f"}, d2 = {"Landroidx/compose/ui/graphics/Float16$Companion;", "", "<init>", "()V", "Size", "", "Epsilon", "Landroidx/compose/ui/graphics/Float16;", "getEpsilon-slo4al4", "()S", ExifInterface.LATITUDE_SOUTH, "MaxExponent", "MinExponent", "LowestValue", "getLowestValue-slo4al4", "MaxValue", "getMaxValue-slo4al4", "MinNormal", "getMinNormal-slo4al4", "MinValue", "getMinValue-slo4al4", "NaN", "getNaN-slo4al4", "NegativeInfinity", "getNegativeInfinity-slo4al4", "NegativeZero", "getNegativeZero-slo4al4", "PositiveInfinity", "getPositiveInfinity-slo4al4", "PositiveZero", "getPositiveZero-slo4al4", "ui-graphics_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }

        /* JADX INFO: renamed from: getEpsilon-slo4al4, reason: not valid java name */
        public final short m4963getEpsilonslo4al4() {
            return Float16.access$getEpsilon$cp();
        }

        /* JADX INFO: renamed from: getLowestValue-slo4al4, reason: not valid java name */
        public final short m4964getLowestValueslo4al4() {
            return Float16.access$getLowestValue$cp();
        }

        /* JADX INFO: renamed from: getMaxValue-slo4al4, reason: not valid java name */
        public final short m4965getMaxValueslo4al4() {
            return Float16.access$getMaxValue$cp();
        }

        /* JADX INFO: renamed from: getMinNormal-slo4al4, reason: not valid java name */
        public final short m4966getMinNormalslo4al4() {
            return Float16.access$getMinNormal$cp();
        }

        /* JADX INFO: renamed from: getMinValue-slo4al4, reason: not valid java name */
        public final short m4967getMinValueslo4al4() {
            return Float16.access$getMinValue$cp();
        }

        /* JADX INFO: renamed from: getNaN-slo4al4, reason: not valid java name */
        public final short m4968getNaNslo4al4() {
            return Float16.access$getNaN$cp();
        }

        /* JADX INFO: renamed from: getNegativeInfinity-slo4al4, reason: not valid java name */
        public final short m4969getNegativeInfinityslo4al4() {
            return Float16.access$getNegativeInfinity$cp();
        }

        /* JADX INFO: renamed from: getNegativeZero-slo4al4, reason: not valid java name */
        public final short m4970getNegativeZeroslo4al4() {
            return Float16.access$getNegativeZero$cp();
        }

        /* JADX INFO: renamed from: getPositiveInfinity-slo4al4, reason: not valid java name */
        public final short m4971getPositiveInfinityslo4al4() {
            return Float16.access$getPositiveInfinity$cp();
        }

        /* JADX INFO: renamed from: getPositiveZero-slo4al4, reason: not valid java name */
        public final short m4972getPositiveZeroslo4al4() {
            return Float16.access$getPositiveZero$cp();
        }
    }

    /* JADX INFO: renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ Float16 m4931boximpl(short r100) {
        return new Float16(r100);
    }

    /* JADX INFO: renamed from: constructor-impl, reason: not valid java name */
    public static short m4936constructorimpl(short r100) {
        return r100;
    }

    /* JADX INFO: renamed from: equals-impl, reason: not valid java name */
    public static boolean m4937equalsimpl(short r100, Object r101) {
        if ((r101 instanceof Float16) == true) goto L6;
        return false;
    L6:
        if (r100 == ((Float16) r101).m4962unboximpl()) goto L8;
        return false;
    L8:
        return true;
    }

    /* JADX INFO: renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m4938equalsimpl0(short r100, short r101) {
        if (r100 != r101) goto L4;
        return true;
    L4:
        return false;
    }

    /* JADX INFO: renamed from: getExponent-impl, reason: not valid java name */
    public static final int m4940getExponentimpl(short r100) {
        return ((r100 >>> 10) & 31) - 15;
    }

    /* JADX INFO: renamed from: getSignificand-impl, reason: not valid java name */
    public static final int m4942getSignificandimpl(short r100) {
        return r100 & 1023;
    }

    /* JADX INFO: renamed from: hashCode-impl, reason: not valid java name */
    public static int m4943hashCodeimpl(short r100) {
        return r100;
    }

    /* JADX INFO: renamed from: isFinite-impl, reason: not valid java name */
    public static final boolean m4944isFiniteimpl(short r100) {
        if ((r100 & ShortCompanionObject.MAX_VALUE) == 31744) goto L5;
        return true;
    L5:
        return false;
    }

    /* JADX INFO: renamed from: isInfinite-impl, reason: not valid java name */
    public static final boolean m4945isInfiniteimpl(short r100) {
        if ((r100 & ShortCompanionObject.MAX_VALUE) != 31744) goto L5;
        return true;
    L5:
        return false;
    }

    /* JADX INFO: renamed from: isNaN-impl, reason: not valid java name */
    public static final boolean m4946isNaNimpl(short r100) {
        if ((r100 & ShortCompanionObject.MAX_VALUE) <= 31744) goto L5;
        return true;
    L5:
        return false;
    }

    /* JADX INFO: renamed from: isNormalized-impl, reason: not valid java name */
    public static final boolean m4947isNormalizedimpl(short r100) {
        int r101 = r100 & 31744;
        boolean r102 = true;
        if (r101 == 0) goto L5;
        boolean r103 = true;
    L6:
        if (r101 != 31744) goto L10;
        r102 = false;
    L10:
        return r103 & r102;
    L5:
        r103 = false;
        goto L6
    }

    /* JADX INFO: renamed from: toRawBits-impl, reason: not valid java name */
    public static final int m4956toRawBitsimpl(short r100) {
        return r100 & 65535;
    }

    public boolean equals(Object r100) {
        return m4937equalsimpl(this.halfValue, r100);
    }

    public int hashCode() {
        return m4943hashCodeimpl(this.halfValue);
    }

    /* JADX INFO: renamed from: unbox-impl, reason: not valid java name */
    public final /* synthetic */ short m4962unboximpl() {
        return this.halfValue;
    }

    static {
        Companion = new Companion(null);
        Epsilon = m4936constructorimpl(5120);
        LowestValue = m4936constructorimpl(-1025);
        MaxValue = m4936constructorimpl(31743);
        MinNormal = m4936constructorimpl(1024);
        MinValue = m4936constructorimpl(1);
        NaN = m4936constructorimpl(32256);
        NegativeInfinity = m4936constructorimpl(-1024);
        NegativeZero = m4936constructorimpl(ShortCompanionObject.MIN_VALUE);
        PositiveInfinity = m4936constructorimpl(31744);
        PositiveZero = m4936constructorimpl(0);
    }

    public String toString() {
        return m4958toStringimpl(this.halfValue);
    }

    public static final /* synthetic */ short access$getEpsilon$cp() {
        return Epsilon;
    }

    public static final /* synthetic */ short access$getLowestValue$cp() {
        return LowestValue;
    }

    public static final /* synthetic */ short access$getMaxValue$cp() {
        return MaxValue;
    }

    public static final /* synthetic */ short access$getMinNormal$cp() {
        return MinNormal;
    }

    public static final /* synthetic */ short access$getMinValue$cp() {
        return MinValue;
    }

    public static final /* synthetic */ short access$getNaN$cp() {
        return NaN;
    }

    public static final /* synthetic */ short access$getNegativeInfinity$cp() {
        return NegativeInfinity;
    }

    public static final /* synthetic */ short access$getNegativeZero$cp() {
        return NegativeZero;
    }

    public static final /* synthetic */ short access$getPositiveInfinity$cp() {
        return PositiveInfinity;
    }

    public static final /* synthetic */ short access$getPositiveZero$cp() {
        return PositiveZero;
    }

    public final short getHalfValue() {
        return this.halfValue;
    }

    private /* synthetic */ Float16(short r100) {
        this.halfValue = r100;
    }

    /* JADX INFO: renamed from: absoluteValue-slo4al4, reason: not valid java name */
    public static final short m4930absoluteValueslo4al4(short r100) {
        return m4936constructorimpl((short) (r100 & ShortCompanionObject.MAX_VALUE));
    }

    /* JADX INFO: renamed from: ceil-slo4al4, reason: not valid java name */
    public static final short m4932ceilslo4al4(short r100) {
        int r101 = r100 & 65535;
        int r102 = r101 & 32767;
        int r103 = 1;
        if (r102 >= 15360) goto L10;
        int r104 = 32768 & r101;
        int r105 = ~(r101 >> 15);
        if (r102 != 0) goto L8;
        r103 = 0;
    L8:
        r101 = ((-(r105 & r103)) & 15360) | r104;
    L13:
        return m4936constructorimpl((short) r101);
    L10:
        if (r102 >= 25600) goto L13;
        int r106 = (1 << (25 - (r102 >> 10))) - 1;
        r101 = (r101 + (r106 & ((r101 >> 15) - 1))) & (~r106);
        goto L13
    }

    /* JADX INFO: renamed from: constructor-impl, reason: not valid java name */
    public static short m4935constructorimpl(float r100) {
        int r101 = Float.floatToRawIntBits(r100);
        int r102 = r101 >>> 31;
        int r103 = (r101 >>> 23) & 255;
        int r104 = r101 & 8388607;
        int r105 = 31;
        int r106 = 0;
        if (r103 != 255) goto L6;
        if (r104 == 0) goto L21;
        r106 = 512;
    L21:
        int r107 = ((r102 << 15) | (r105 << 10)) | r106;
    L23:
        return m4936constructorimpl((short) r107);
    L6:
        int r108 = (r103 - 127) + 15;
        if (r108 < 31) goto L9;
        r105 = 49;
        goto L21
    L9:
        if (r108 <= 0) goto L11;
        r106 = r104 >> 13;
        if ((r104 & 4096) == 0) goto L20;
        r107 = (((r108 << 10) | r106) + 1) | (r102 << 15);
        goto L23
    L20:
        r105 = r108;
        goto L21
    L11:
        if (r108 < (-10)) goto L16;
        int r109 = (r104 | 8388608) >> (1 - r108);
        if ((r109 & 4096) == 0) goto L15;
        r109 = r109 + 8192;
    L15:
        r106 = r109 >> 13;
    L16:
        r105 = 0;
        goto L21
    }

    /* JADX INFO: renamed from: floor-slo4al4, reason: not valid java name */
    public static final short m4939floorslo4al4(short r100) {
        int r101 = 65535;
        int r102 = r100 & 65535;
        int r103 = r102 & 32767;
        if (r103 >= 15360) goto L10;
        int r104 = r102 & 32768;
        if (r102 > 32768) goto L8;
        r101 = 0;
    L8:
        r102 = (r101 & 15360) | r104;
    L13:
        return m4936constructorimpl((short) r102);
    L10:
        if (r103 >= 25600) goto L13;
        int r105 = (1 << (25 - (r103 >> 10))) - 1;
        r102 = (r102 + ((-(r102 >> 15)) & r105)) & (~r105);
        goto L13
    }

    /* JADX INFO: renamed from: getSign-slo4al4, reason: not valid java name */
    public static final short m4941getSignslo4al4(short r100) {
        int r101 = r100 & ShortCompanionObject.MAX_VALUE;
        boolean r102 = true;
        if (r101 <= 31744) goto L5;
        boolean r103 = true;
    L6:
        if (r101 == 0) goto L10;
        r102 = false;
    L10:
        if ((r103 | r102) == true) goto L14;
        r101 = (r100 & ShortCompanionObject.MIN_VALUE) | 15360;
    L14:
        return m4936constructorimpl((short) r101);
    L5:
        r103 = false;
        goto L6
    }

    /* JADX INFO: renamed from: round-slo4al4, reason: not valid java name */
    public static final short m4948roundslo4al4(short r100) {
        int r101 = 65535;
        int r102 = r100 & 65535;
        int r103 = r102 & 32767;
        if (r103 >= 15360) goto L10;
        int r104 = r102 & 32768;
        if (r103 >= 14336) goto L8;
        r101 = 0;
    L8:
        r102 = r104 | (r101 & 15360);
    L13:
        return m4936constructorimpl((short) r102);
    L10:
        if (r103 >= 25600) goto L13;
        int r105 = 25 - (r103 >> 10);
        int r106 = (1 << r105) - 1;
        r102 = (r102 + (1 << (r105 - 1))) & (~r106);
        goto L13
    }

    /* JADX INFO: renamed from: toBits-impl, reason: not valid java name */
    public static final int m4949toBitsimpl(short r100) {
        if (m4946isNaNimpl(r100) == false) goto L6;
        return 32256;
    L6:
        return r100 & 65535;
    }

    /* JADX INFO: renamed from: toByte-impl, reason: not valid java name */
    public static final byte m4950toByteimpl(short r100) {
        return (byte) m4952toFloatimpl(r100);
    }

    /* JADX INFO: renamed from: toDouble-impl, reason: not valid java name */
    public static final double m4951toDoubleimpl(short r100) {
        return m4952toFloatimpl(r100);
    }

    /* JADX INFO: renamed from: toFloat-impl, reason: not valid java name */
    public static final float m4952toFloatimpl(short r100) {
        int r101 = r100 & 65535;
        int r102 = 32768 & r101;
        int r103 = (r101 >>> 10) & 31;
        int r104 = r101 & 1023;
        if (r103 != 0) goto L10;
        if (r104 == 0) goto L9;
        float r105 = Float.intBitsToFloat(r104 + 1056964608) - Float16Kt.access$getFp32DenormalFloat$p();
        if (r102 != 0) goto L19;
        return r105;
    L19:
        return -r105;
    L9:
        int r106 = 0;
        int r107 = 0;
    L18:
        return Float.intBitsToFloat(((r106 << 23) | (r102 << 16)) | r107);
    L10:
        int r108 = r104 << 13;
        if (r103 == 31) goto L13;
        int r109 = (r103 - 15) + 127;
        r107 = r108;
        r106 = r109;
        goto L18
    L13:
        if (r108 == 0) goto L15;
        r108 = r108 | 4194304;
    L15:
        r107 = r108;
        r106 = 255;
        goto L18
    }

    /* JADX INFO: renamed from: toHexString-impl, reason: not valid java name */
    public static final String m4953toHexStringimpl(short r100) {
        StringBuilder r101 = new StringBuilder();
        int r102 = r100 & 65535;
        int r103 = r102 >>> 15;
        int r104 = (r102 >>> 10) & 31;
        int r105 = r102 & 1023;
        if (r104 != 31) goto L10;
        if (r105 != 0) goto L8;
        if (r103 == 0) goto L7;
        r101.append('-');
    L7:
        r101.append("Infinity");
    L19:
        return r101.toString();
    L8:
        r101.append("NaN");
        goto L19
    L10:
        if (r103 != 1) goto L13;
        r101.append('-');
    L13:
        if (r104 != 0) goto L17;
        if (r105 != 0) goto L16;
        r101.append("0x0.0p0");
        goto L19
    L16:
        r101.append("0x0.");
        r101.append(new Regex("0{2,}$").replaceFirst(Integer.toString(r105, CharsKt.checkRadix(16)), ""));
        r101.append("p-14");
        goto L19
    L17:
        r101.append("0x1.");
        r101.append(new Regex("0{2,}$").replaceFirst(Integer.toString(r105, CharsKt.checkRadix(16)), ""));
        r101.append(NamedPipe.UNIX_ID);
        r101.append(String.valueOf(r104 - 15));
        goto L19
    }

    /* JADX INFO: renamed from: toInt-impl, reason: not valid java name */
    public static final int m4954toIntimpl(short r100) {
        return (int) m4952toFloatimpl(r100);
    }

    /* JADX INFO: renamed from: toLong-impl, reason: not valid java name */
    public static final long m4955toLongimpl(short r100) {
        return (long) m4952toFloatimpl(r100);
    }

    /* JADX INFO: renamed from: toShort-impl, reason: not valid java name */
    public static final short m4957toShortimpl(short r100) {
        return (short) m4952toFloatimpl(r100);
    }

    /* JADX INFO: renamed from: toString-impl, reason: not valid java name */
    public static String m4958toStringimpl(short r100) {
        return String.valueOf(m4952toFloatimpl(r100));
    }

    /* JADX INFO: renamed from: trunc-slo4al4, reason: not valid java name */
    public static final short m4959truncslo4al4(short r100) {
        int r101 = r100 & 65535;
        int r102 = r101 & 32767;
        if (r102 >= 15360) goto L7;
        int r103 = 32768;
    L5:
        r101 = r101 & r103;
    L10:
        return m4936constructorimpl((short) r101);
    L7:
        if (r102 >= 25600) goto L10;
        r103 = ~((1 << (25 - (r102 >> 10))) - 1);
        goto L5
    }

    @Override // java.lang.Comparable
    public /* bridge */ /* synthetic */ int compareTo(Float16 r100) {
        return m4961compareTo41bOqos(r100.m4962unboximpl());
    }

    /* JADX INFO: renamed from: compareTo-41bOqos, reason: not valid java name */
    public int m4961compareTo41bOqos(short r100) {
        return m4933compareTo41bOqos(this.halfValue, r100);
    }

    /* JADX INFO: renamed from: constructor-impl, reason: not valid java name */
    public static short m4934constructorimpl(double r100) {
        return m4935constructorimpl((float) r100);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX INFO: renamed from: compareTo-41bOqos, reason: not valid java name */
    public static int m4933compareTo41bOqos(short r100, short r101) {
        if (m4946isNaNimpl(r100) == false) goto L7;
        return !m4946isNaNimpl(r101) ? 1 : 0;
    L7:
        if (m4946isNaNimpl(r101) == false) goto L11;
        return -1;
    L11:
        if ((r100 & ShortCompanionObject.MIN_VALUE) == 0) goto L13;
        int r102 = 32768 - (r100 & 65535);
    L15:
        if ((r101 & ShortCompanionObject.MIN_VALUE) == 0) goto L17;
        int r103 = 32768 - (r101 & 65535);
    L19:
        return Intrinsics.compare(r102, r103);
    L17:
        r103 = r101 & 65535;
        goto L19
    L13:
        r102 = r100 & 65535;
        goto L15
    }

    /* JADX INFO: renamed from: withSign-qCeQghg, reason: not valid java name */
    public static final short m4960withSignqCeQghg(short r100, short r101) {
        int r102 = r101 & ShortCompanionObject.MIN_VALUE;
        return m4936constructorimpl((short) ((r100 & ShortCompanionObject.MAX_VALUE) | r102));
    }
}
