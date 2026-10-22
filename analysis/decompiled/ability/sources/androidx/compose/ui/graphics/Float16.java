package androidx.compose.ui.graphics;

import androidx.exifinterface.media.ExifInterface;
import ca.AbstractC0897f;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import kotlin.Metadata;
import kotlin.jvm.internal.e;
import kotlin.jvm.internal.k;
import kotlin.text.Regex;

@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u000f\n\u0000\n\u0002\u0010\n\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0004\n\u0002\u0010\u0005\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\r\n\u0002\u0010\u000e\n\u0002\b\u001a\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0081@\u0018\u0000 O2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001OB\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005B\u0011\b\u0016\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\u0004\u0010\bB\u0011\b\u0016\u0012\u0006\u0010\u0006\u001a\u00020\t¢\u0006\u0004\b\u0004\u0010\nJ\r\u0010\r\u001a\u00020\u000e¢\u0006\u0004\b\u000f\u0010\u0010J\r\u0010\u0011\u001a\u00020\u0003¢\u0006\u0004\b\u0012\u0010\u0005J\r\u0010\u0013\u001a\u00020\u0014¢\u0006\u0004\b\u0015\u0010\u0016J\r\u0010\u0017\u001a\u00020\u0018¢\u0006\u0004\b\u0019\u0010\u001aJ\r\u0010\u001b\u001a\u00020\u0007¢\u0006\u0004\b\u001c\u0010\u001dJ\r\u0010\u001e\u001a\u00020\t¢\u0006\u0004\b\u001f\u0010 J\r\u0010!\u001a\u00020\u0014¢\u0006\u0004\b\"\u0010\u0016J\r\u0010#\u001a\u00020\u0014¢\u0006\u0004\b$\u0010\u0016J\u000f\u0010%\u001a\u00020&H\u0016¢\u0006\u0004\b'\u0010(J\u0018\u0010)\u001a\u00020\u00142\u0006\u0010*\u001a\u00020\u0000H\u0096\u0002¢\u0006\u0004\b+\u0010,J\u0015\u0010/\u001a\u00020\u00002\u0006\u0010-\u001a\u00020\u0000¢\u0006\u0004\b0\u00101J\r\u00102\u001a\u00020\u0000¢\u0006\u0004\b3\u0010\u0005J\r\u00104\u001a\u00020\u0000¢\u0006\u0004\b5\u0010\u0005J\r\u00106\u001a\u00020\u0000¢\u0006\u0004\b7\u0010\u0005J\r\u00108\u001a\u00020\u0000¢\u0006\u0004\b9\u0010\u0005J\r\u0010:\u001a\u00020\u0000¢\u0006\u0004\b;\u0010\u0005J\r\u0010@\u001a\u00020A¢\u0006\u0004\bB\u0010CJ\r\u0010D\u001a\u00020A¢\u0006\u0004\bE\u0010CJ\r\u0010F\u001a\u00020A¢\u0006\u0004\bG\u0010CJ\r\u0010H\u001a\u00020A¢\u0006\u0004\bI\u0010CJ\r\u0010J\u001a\u00020&¢\u0006\u0004\bK\u0010(J\u0013\u0010L\u001a\u00020A2\b\u0010*\u001a\u0004\u0018\u00010MHÖ\u0003J\t\u0010N\u001a\u00020\u0014HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010-\u001a\u00020\u00008F¢\u0006\u0006\u001a\u0004\b.\u0010\u0005R\u0011\u0010<\u001a\u00020\u00148F¢\u0006\u0006\u001a\u0004\b=\u0010\u0016R\u0011\u0010>\u001a\u00020\u00148F¢\u0006\u0006\u001a\u0004\b?\u0010\u0016\u0088\u0001\u0002¨\u0006P"}, d2 = {"Landroidx/compose/ui/graphics/Float16;", "", "halfValue", "", "constructor-impl", "(S)S", "value", "", "(F)S", "", "(D)S", "getHalfValue", "()S", "toByte", "", "toByte-impl", "(S)B", "toShort", "toShort-impl", "toInt", "", "toInt-impl", "(S)I", "toLong", "", "toLong-impl", "(S)J", "toFloat", "toFloat-impl", "(S)F", "toDouble", "toDouble-impl", "(S)D", "toBits", "toBits-impl", "toRawBits", "toRawBits-impl", "toString", "", "toString-impl", "(S)Ljava/lang/String;", "compareTo", "other", "compareTo-41bOqos", "(SS)I", "sign", "getSign-slo4al4", "withSign", "withSign-qCeQghg", "(SS)S", "absoluteValue", "absoluteValue-slo4al4", "round", "round-slo4al4", "ceil", "ceil-slo4al4", "floor", "floor-slo4al4", "trunc", "trunc-slo4al4", "exponent", "getExponent-impl", "significand", "getSignificand-impl", "isNaN", "", "isNaN-impl", "(S)Z", "isInfinite", "isInfinite-impl", "isFinite", "isFinite-impl", "isNormalized", "isNormalized-impl", "toHexString", "toHexString-impl", "equals", "", "hashCode", "Companion", "ui-graphics_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
public final class Float16 implements Comparable<Float16> {
    public static final int MaxExponent = 15;
    public static final int MinExponent = -14;
    public static final int Size = 16;
    private final short halfValue;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final short Epsilon = m4248constructorimpl((short) 5120);
    private static final short LowestValue = m4248constructorimpl((short) -1025);
    private static final short MaxValue = m4248constructorimpl((short) 31743);
    private static final short MinNormal = m4248constructorimpl((short) 1024);
    private static final short MinValue = m4248constructorimpl((short) 1);
    private static final short NaN = m4248constructorimpl((short) 32256);
    private static final short NegativeInfinity = m4248constructorimpl((short) -1024);
    private static final short NegativeZero = m4248constructorimpl(Short.MIN_VALUE);
    private static final short PositiveInfinity = m4248constructorimpl((short) 31744);
    private static final short PositiveZero = m4248constructorimpl((short) 0);

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0018\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u0013\u0010\u0006\u001a\u00020\u0007¢\u0006\n\n\u0002\u0010\n\u001a\u0004\b\b\u0010\tR\u000e\u0010\u000b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u0013\u0010\r\u001a\u00020\u0007¢\u0006\n\n\u0002\u0010\n\u001a\u0004\b\u000e\u0010\tR\u0013\u0010\u000f\u001a\u00020\u0007¢\u0006\n\n\u0002\u0010\n\u001a\u0004\b\u0010\u0010\tR\u0013\u0010\u0011\u001a\u00020\u0007¢\u0006\n\n\u0002\u0010\n\u001a\u0004\b\u0012\u0010\tR\u0013\u0010\u0013\u001a\u00020\u0007¢\u0006\n\n\u0002\u0010\n\u001a\u0004\b\u0014\u0010\tR\u0013\u0010\u0015\u001a\u00020\u0007¢\u0006\n\n\u0002\u0010\n\u001a\u0004\b\u0016\u0010\tR\u0013\u0010\u0017\u001a\u00020\u0007¢\u0006\n\n\u0002\u0010\n\u001a\u0004\b\u0018\u0010\tR\u0013\u0010\u0019\u001a\u00020\u0007¢\u0006\n\n\u0002\u0010\n\u001a\u0004\b\u001a\u0010\tR\u0013\u0010\u001b\u001a\u00020\u0007¢\u0006\n\n\u0002\u0010\n\u001a\u0004\b\u001c\u0010\tR\u0013\u0010\u001d\u001a\u00020\u0007¢\u0006\n\n\u0002\u0010\n\u001a\u0004\b\u001e\u0010\t¨\u0006\u001f"}, d2 = {"Landroidx/compose/ui/graphics/Float16$Companion;", "", AppAgent.CONSTRUCT, "()V", "Size", "", "Epsilon", "Landroidx/compose/ui/graphics/Float16;", "getEpsilon-slo4al4", "()S", ExifInterface.LATITUDE_SOUTH, "MaxExponent", "MinExponent", "LowestValue", "getLowestValue-slo4al4", "MaxValue", "getMaxValue-slo4al4", "MinNormal", "getMinNormal-slo4al4", "MinValue", "getMinValue-slo4al4", "NaN", "getNaN-slo4al4", "NegativeInfinity", "getNegativeInfinity-slo4al4", "NegativeZero", "getNegativeZero-slo4al4", "PositiveInfinity", "getPositiveInfinity-slo4al4", "PositiveZero", "getPositiveZero-slo4al4", "ui-graphics_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(e eVar) {
            this();
        }

        /* renamed from: getEpsilon-slo4al4, reason: not valid java name */
        public final short m4275getEpsilonslo4al4() {
            return Float16.Epsilon;
        }

        /* renamed from: getLowestValue-slo4al4, reason: not valid java name */
        public final short m4276getLowestValueslo4al4() {
            return Float16.LowestValue;
        }

        /* renamed from: getMaxValue-slo4al4, reason: not valid java name */
        public final short m4277getMaxValueslo4al4() {
            return Float16.MaxValue;
        }

        /* renamed from: getMinNormal-slo4al4, reason: not valid java name */
        public final short m4278getMinNormalslo4al4() {
            return Float16.MinNormal;
        }

        /* renamed from: getMinValue-slo4al4, reason: not valid java name */
        public final short m4279getMinValueslo4al4() {
            return Float16.MinValue;
        }

        /* renamed from: getNaN-slo4al4, reason: not valid java name */
        public final short m4280getNaNslo4al4() {
            return Float16.NaN;
        }

        /* renamed from: getNegativeInfinity-slo4al4, reason: not valid java name */
        public final short m4281getNegativeInfinityslo4al4() {
            return Float16.NegativeInfinity;
        }

        /* renamed from: getNegativeZero-slo4al4, reason: not valid java name */
        public final short m4282getNegativeZeroslo4al4() {
            return Float16.NegativeZero;
        }

        /* renamed from: getPositiveInfinity-slo4al4, reason: not valid java name */
        public final short m4283getPositiveInfinityslo4al4() {
            return Float16.PositiveInfinity;
        }

        /* renamed from: getPositiveZero-slo4al4, reason: not valid java name */
        public final short m4284getPositiveZeroslo4al4() {
            return Float16.PositiveZero;
        }

        private Companion() {
        }
    }

    private /* synthetic */ Float16(short s5) {
        this.halfValue = s5;
    }

    /* renamed from: absoluteValue-slo4al4, reason: not valid java name */
    public static final short m4242absoluteValueslo4al4(short s5) {
        return m4248constructorimpl((short) (s5 & Short.MAX_VALUE));
    }

    /* renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ Float16 m4243boximpl(short s5) {
        return new Float16(s5);
    }

    /* renamed from: ceil-slo4al4, reason: not valid java name */
    public static final short m4244ceilslo4al4(short s5) {
        int i = 65535 & s5;
        int i6 = s5 & Short.MAX_VALUE;
        if (i6 < 15360) {
            i = ((-((~(i >> 15)) & (i6 == 0 ? 0 : 1))) & 15360) | (s5 & Short.MIN_VALUE);
        } else if (i6 < 25600) {
            int i10 = (1 << (25 - (i6 >> 10))) - 1;
            i = (i + (((i >> 15) - 1) & i10)) & (~i10);
        }
        return m4248constructorimpl((short) i);
    }

    /* renamed from: constructor-impl, reason: not valid java name */
    public static short m4248constructorimpl(short s5) {
        return s5;
    }

    /* renamed from: equals-impl, reason: not valid java name */
    public static boolean m4249equalsimpl(short s5, Object obj) {
        return (obj instanceof Float16) && s5 == ((Float16) obj).m4274unboximpl();
    }

    /* renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m4250equalsimpl0(short s5, short s10) {
        return s5 == s10;
    }

    /* renamed from: floor-slo4al4, reason: not valid java name */
    public static final short m4251floorslo4al4(short s5) {
        int i = s5 & 65535;
        int i6 = s5 & Short.MAX_VALUE;
        if (i6 < 15360) {
            i = (s5 & Short.MIN_VALUE) | ((i <= 32768 ? 0 : 65535) & 15360);
        } else if (i6 < 25600) {
            int i10 = (1 << (25 - (i6 >> 10))) - 1;
            i = (i + ((-(i >> 15)) & i10)) & (~i10);
        }
        return m4248constructorimpl((short) i);
    }

    /* renamed from: getExponent-impl, reason: not valid java name */
    public static final int m4252getExponentimpl(short s5) {
        return ((s5 >>> 10) & 31) - 15;
    }

    /* renamed from: getSign-slo4al4, reason: not valid java name */
    public static final short m4253getSignslo4al4(short s5) {
        int i = s5 & Short.MAX_VALUE;
        if (!((i > 31744) | (i == 0))) {
            i = (s5 & Short.MIN_VALUE) | 15360;
        }
        return m4248constructorimpl((short) i);
    }

    /* renamed from: getSignificand-impl, reason: not valid java name */
    public static final int m4254getSignificandimpl(short s5) {
        return s5 & 1023;
    }

    /* renamed from: hashCode-impl, reason: not valid java name */
    public static int m4255hashCodeimpl(short s5) {
        return Short.hashCode(s5);
    }

    /* renamed from: isFinite-impl, reason: not valid java name */
    public static final boolean m4256isFiniteimpl(short s5) {
        return (s5 & Short.MAX_VALUE) != 31744;
    }

    /* renamed from: isInfinite-impl, reason: not valid java name */
    public static final boolean m4257isInfiniteimpl(short s5) {
        return (s5 & Short.MAX_VALUE) == 31744;
    }

    /* renamed from: isNaN-impl, reason: not valid java name */
    public static final boolean m4258isNaNimpl(short s5) {
        return (s5 & Short.MAX_VALUE) > 31744;
    }

    /* renamed from: isNormalized-impl, reason: not valid java name */
    public static final boolean m4259isNormalizedimpl(short s5) {
        int i = s5 & 31744;
        return (i != 0) & (i != 31744);
    }

    /* renamed from: round-slo4al4, reason: not valid java name */
    public static final short m4260roundslo4al4(short s5) {
        int i = s5 & 65535;
        int i6 = s5 & Short.MAX_VALUE;
        if (i6 < 15360) {
            i = (s5 & Short.MIN_VALUE) | ((i6 < 14336 ? 0 : 65535) & 15360);
        } else if (i6 < 25600) {
            int i10 = i6 >> 10;
            i = (i + (1 << (24 - i10))) & (~((1 << (25 - i10)) - 1));
        }
        return m4248constructorimpl((short) i);
    }

    /* renamed from: toBits-impl, reason: not valid java name */
    public static final int m4261toBitsimpl(short s5) {
        if (m4258isNaNimpl(s5)) {
            return 32256;
        }
        return s5 & 65535;
    }

    /* renamed from: toByte-impl, reason: not valid java name */
    public static final byte m4262toByteimpl(short s5) {
        return (byte) m4264toFloatimpl(s5);
    }

    /* renamed from: toDouble-impl, reason: not valid java name */
    public static final double m4263toDoubleimpl(short s5) {
        return m4264toFloatimpl(s5);
    }

    /* renamed from: toFloat-impl, reason: not valid java name */
    public static final float m4264toFloatimpl(short s5) {
        int i;
        int i6;
        int i10;
        int i11 = Short.MIN_VALUE & s5;
        int i12 = ((65535 & s5) >>> 10) & 31;
        int i13 = s5 & 1023;
        if (i12 != 0) {
            int i14 = i13 << 13;
            if (i12 == 31) {
                i = 255;
                if (i14 != 0) {
                    i14 |= 4194304;
                }
            } else {
                i = i12 + 112;
            }
            int i15 = i;
            i6 = i14;
            i10 = i15;
        } else {
            if (i13 != 0) {
                float fIntBitsToFloat = Float.intBitsToFloat(i13 + 1056964608) - Float16Kt.Fp32DenormalFloat;
                return i11 == 0 ? fIntBitsToFloat : -fIntBitsToFloat;
            }
            i10 = 0;
            i6 = 0;
        }
        return Float.intBitsToFloat((i10 << 23) | (i11 << 16) | i6);
    }

    /* renamed from: toHexString-impl, reason: not valid java name */
    public static final String m4265toHexStringimpl(short s5) {
        StringBuilder sb = new StringBuilder();
        int i = 65535 & s5;
        int i6 = i >>> 15;
        int i10 = (i >>> 10) & 31;
        int i11 = s5 & 1023;
        if (i10 != 31) {
            if (i6 == 1) {
                sb.append('-');
            }
            if (i10 != 0) {
                sb.append("0x1.");
                AbstractC0897f.r(16);
                String string = Integer.toString(i11, 16);
                k.e(string, "toString(...)");
                String strReplaceFirst = new Regex("0{2,}$").f5167a.matcher(string).replaceFirst("");
                k.e(strReplaceFirst, "replaceFirst(...)");
                sb.append(strReplaceFirst);
                sb.append('p');
                sb.append(String.valueOf(i10 - 15));
            } else if (i11 == 0) {
                sb.append("0x0.0p0");
            } else {
                sb.append("0x0.");
                AbstractC0897f.r(16);
                String string2 = Integer.toString(i11, 16);
                k.e(string2, "toString(...)");
                String strReplaceFirst2 = new Regex("0{2,}$").f5167a.matcher(string2).replaceFirst("");
                k.e(strReplaceFirst2, "replaceFirst(...)");
                sb.append(strReplaceFirst2);
                sb.append("p-14");
            }
        } else if (i11 == 0) {
            if (i6 != 0) {
                sb.append('-');
            }
            sb.append("Infinity");
        } else {
            sb.append("NaN");
        }
        return sb.toString();
    }

    /* renamed from: toInt-impl, reason: not valid java name */
    public static final int m4266toIntimpl(short s5) {
        return (int) m4264toFloatimpl(s5);
    }

    /* renamed from: toLong-impl, reason: not valid java name */
    public static final long m4267toLongimpl(short s5) {
        return (long) m4264toFloatimpl(s5);
    }

    /* renamed from: toRawBits-impl, reason: not valid java name */
    public static final int m4268toRawBitsimpl(short s5) {
        return s5 & 65535;
    }

    /* renamed from: toShort-impl, reason: not valid java name */
    public static final short m4269toShortimpl(short s5) {
        return (short) m4264toFloatimpl(s5);
    }

    /* renamed from: toString-impl, reason: not valid java name */
    public static String m4270toStringimpl(short s5) {
        return String.valueOf(m4264toFloatimpl(s5));
    }

    /* renamed from: trunc-slo4al4, reason: not valid java name */
    public static final short m4271truncslo4al4(short s5) {
        int i = 65535 & s5;
        int i6 = s5 & Short.MAX_VALUE;
        if (i6 < 15360) {
            i = Short.MIN_VALUE & s5;
        } else if (i6 < 25600) {
            i &= ~((1 << (25 - (i6 >> 10))) - 1);
        }
        return m4248constructorimpl((short) i);
    }

    /* renamed from: withSign-qCeQghg, reason: not valid java name */
    public static final short m4272withSignqCeQghg(short s5, short s10) {
        return m4248constructorimpl((short) ((s5 & Short.MAX_VALUE) | (s10 & Short.MIN_VALUE)));
    }

    @Override // java.lang.Comparable
    public /* bridge */ /* synthetic */ int compareTo(Float16 float16) {
        return m4273compareTo41bOqos(float16.m4274unboximpl());
    }

    /* renamed from: compareTo-41bOqos, reason: not valid java name */
    public int m4273compareTo41bOqos(short s5) {
        return m4245compareTo41bOqos(this.halfValue, s5);
    }

    public boolean equals(Object other) {
        return m4249equalsimpl(this.halfValue, other);
    }

    public final short getHalfValue() {
        return this.halfValue;
    }

    public int hashCode() {
        return m4255hashCodeimpl(this.halfValue);
    }

    public String toString() {
        return m4270toStringimpl(this.halfValue);
    }

    /* renamed from: unbox-impl, reason: not valid java name */
    public final /* synthetic */ short m4274unboximpl() {
        return this.halfValue;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: compareTo-41bOqos, reason: not valid java name */
    public static int m4245compareTo41bOqos(short s5, short s10) {
        if (m4258isNaNimpl(s5)) {
            return !m4258isNaNimpl(s10) ? 1 : 0;
        }
        if (m4258isNaNimpl(s10)) {
            return -1;
        }
        return k.g((s5 & Short.MIN_VALUE) != 0 ? 32768 - (s5 & 65535) : s5 & 65535, (s10 & Short.MIN_VALUE) != 0 ? 32768 - (s10 & 65535) : s10 & 65535);
    }

    /* renamed from: constructor-impl, reason: not valid java name */
    public static short m4246constructorimpl(double d) {
        return m4247constructorimpl((float) d);
    }

    /* renamed from: constructor-impl, reason: not valid java name */
    public static short m4247constructorimpl(float f) {
        int i;
        int iFloatToRawIntBits = Float.floatToRawIntBits(f);
        int i6 = iFloatToRawIntBits >>> 31;
        int i10 = (iFloatToRawIntBits >>> 23) & 255;
        int i11 = 8388607 & iFloatToRawIntBits;
        int i12 = 31;
        int i13 = 0;
        if (i10 != 255) {
            int i14 = i10 - 112;
            if (i14 >= 31) {
                i12 = 49;
            } else if (i14 > 0) {
                i13 = i11 >> 13;
                if ((iFloatToRawIntBits & 4096) != 0) {
                    i = (((i14 << 10) | i13) + 1) | (i6 << 15);
                    return m4248constructorimpl((short) i);
                }
                i12 = i14;
            } else if (i14 >= -10) {
                int i15 = (8388608 | i11) >> (1 - i14);
                if ((i15 & 4096) != 0) {
                    i15 += 8192;
                }
                i12 = 0;
                i13 = i15 >> 13;
            } else {
                i12 = 0;
            }
        } else if (i11 != 0) {
            i13 = 512;
        }
        i = (i6 << 15) | (i12 << 10) | i13;
        return m4248constructorimpl((short) i);
    }
}
