package androidx.compose.ui.unit;

import androidx.compose.runtime.Immutable;
import androidx.compose.runtime.Stable;
import androidx.compose.ui.unit.TextUnitType;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import kotlin.Metadata;
import kotlin.jvm.internal.e;

@Immutable
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u000b\b\u0087@\u0018\u0000 ,2\u00020\u0001:\u0001,B\u0011\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0006\u001a\u00020\u0000H\u0086\n¢\u0006\u0004\b\u0007\u0010\u0005J\u0018\u0010\b\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\nH\u0086\n¢\u0006\u0004\b\u000b\u0010\fJ\u0018\u0010\b\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\rH\u0086\n¢\u0006\u0004\b\u000b\u0010\u000eJ\u0018\u0010\b\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u000fH\u0086\n¢\u0006\u0004\b\u000b\u0010\u0010J\u0018\u0010\u0011\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\nH\u0086\n¢\u0006\u0004\b\u0012\u0010\fJ\u0018\u0010\u0011\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\rH\u0086\n¢\u0006\u0004\b\u0012\u0010\u000eJ\u0018\u0010\u0011\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u000fH\u0086\n¢\u0006\u0004\b\u0012\u0010\u0010J\u0018\u0010\u0013\u001a\u00020\u000f2\u0006\u0010\t\u001a\u00020\u0000H\u0086\n¢\u0006\u0004\b\u0014\u0010\u0015J\u000f\u0010\u0016\u001a\u00020\u0017H\u0016¢\u0006\u0004\b\u0018\u0010\u0019J\u0013\u0010*\u001a\u00020\"2\b\u0010\t\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010+\u001a\u00020\u000fHÖ\u0001R\u000e\u0010\u0002\u001a\u00020\u0003X\u0080\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u001a\u001a\u00020\u00038@X\u0081\u0004¢\u0006\f\u0012\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u0005R\u0011\u0010\u001e\u001a\u00020\u001f8F¢\u0006\u0006\u001a\u0004\b \u0010\u0005R\u0011\u0010!\u001a\u00020\"8F¢\u0006\u0006\u001a\u0004\b#\u0010$R\u0011\u0010%\u001a\u00020\"8F¢\u0006\u0006\u001a\u0004\b&\u0010$R\u0011\u0010'\u001a\u00020\n8F¢\u0006\u0006\u001a\u0004\b(\u0010)\u0088\u0001\u0002\u0092\u0001\u00020\u0003¨\u0006-"}, d2 = {"Landroidx/compose/ui/unit/TextUnit;", "", "packedValue", "", "constructor-impl", "(J)J", "unaryMinus", "unaryMinus-XSAIIZE", "div", "other", "", "div-kPz2Gy4", "(JF)J", "", "(JD)J", "", "(JI)J", "times", "times-kPz2Gy4", "compareTo", "compareTo--R2X_6o", "(JJ)I", "toString", "", "toString-impl", "(J)Ljava/lang/String;", "rawType", "getRawType$annotations", "()V", "getRawType-impl", "type", "Landroidx/compose/ui/unit/TextUnitType;", "getType-UIouoOA", "isSp", "", "isSp-impl", "(J)Z", "isEm", "isEm-impl", "value", "getValue-impl", "(J)F", "equals", "hashCode", "Companion", "ui-unit"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class TextUnit {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final TextUnitType[] TextUnitTypes;
    private static final long Unspecified;
    private final long packedValue;

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u001c\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0080\u0004¢\u0006\n\n\u0002\u0010\t\u001a\u0004\b\u0007\u0010\bR\u001e\u0010\n\u001a\u00020\u000b8\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010\u000f\u0012\u0004\b\f\u0010\u0003\u001a\u0004\b\r\u0010\u000e¨\u0006\u0010"}, d2 = {"Landroidx/compose/ui/unit/TextUnit$Companion;", "", AppAgent.CONSTRUCT, "()V", "TextUnitTypes", "", "Landroidx/compose/ui/unit/TextUnitType;", "getTextUnitTypes$ui_unit", "()[Landroidx/compose/ui/unit/TextUnitType;", "[Landroidx/compose/ui/unit/TextUnitType;", "Unspecified", "Landroidx/compose/ui/unit/TextUnit;", "getUnspecified-XSAIIZE$annotations", "getUnspecified-XSAIIZE", "()J", "J", "ui-unit"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(e eVar) {
            this();
        }

        @Stable
        /* renamed from: getUnspecified-XSAIIZE$annotations, reason: not valid java name */
        public static /* synthetic */ void m7048getUnspecifiedXSAIIZE$annotations() {
        }

        public final TextUnitType[] getTextUnitTypes$ui_unit() {
            return TextUnit.TextUnitTypes;
        }

        /* renamed from: getUnspecified-XSAIIZE, reason: not valid java name */
        public final long m7049getUnspecifiedXSAIIZE() {
            return TextUnit.Unspecified;
        }

        private Companion() {
        }
    }

    static {
        TextUnitType.Companion companion = TextUnitType.INSTANCE;
        TextUnitTypes = new TextUnitType[]{TextUnitType.m7063boximpl(companion.m7072getUnspecifiedUIouoOA()), TextUnitType.m7063boximpl(companion.m7071getSpUIouoOA()), TextUnitType.m7063boximpl(companion.m7070getEmUIouoOA())};
        Unspecified = TextUnitKt.pack(0L, Float.NaN);
    }

    private /* synthetic */ TextUnit(long j5) {
        this.packedValue = j5;
    }

    /* renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ TextUnit m7028boximpl(long j5) {
        return new TextUnit(j5);
    }

    /* renamed from: compareTo--R2X_6o, reason: not valid java name */
    public static final int m7029compareToR2X_6o(long j5, long j6) {
        TextUnitKt.m7052checkArithmeticNB67dxo(j5, j6);
        return Float.compare(m7038getValueimpl(j5), m7038getValueimpl(j6));
    }

    /* renamed from: constructor-impl, reason: not valid java name */
    public static long m7030constructorimpl(long j5) {
        return j5;
    }

    /* renamed from: div-kPz2Gy4, reason: not valid java name */
    public static final long m7032divkPz2Gy4(long j5, float f) {
        TextUnitKt.m7051checkArithmeticR2X_6o(j5);
        return TextUnitKt.pack(m7036getRawTypeimpl(j5), m7038getValueimpl(j5) / f);
    }

    /* renamed from: equals-impl, reason: not valid java name */
    public static boolean m7034equalsimpl(long j5, Object obj) {
        return (obj instanceof TextUnit) && j5 == ((TextUnit) obj).getPackedValue();
    }

    /* renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m7035equalsimpl0(long j5, long j6) {
        return j5 == j6;
    }

    public static /* synthetic */ void getRawType$annotations() {
    }

    /* renamed from: getRawType-impl, reason: not valid java name */
    public static final long m7036getRawTypeimpl(long j5) {
        return j5 & 1095216660480L;
    }

    /* renamed from: getType-UIouoOA, reason: not valid java name */
    public static final long m7037getTypeUIouoOA(long j5) {
        return TextUnitTypes[(int) (m7036getRawTypeimpl(j5) >>> 32)].getType();
    }

    /* renamed from: getValue-impl, reason: not valid java name */
    public static final float m7038getValueimpl(long j5) {
        return Float.intBitsToFloat((int) (j5 & 4294967295L));
    }

    /* renamed from: hashCode-impl, reason: not valid java name */
    public static int m7039hashCodeimpl(long j5) {
        return Long.hashCode(j5);
    }

    /* renamed from: isEm-impl, reason: not valid java name */
    public static final boolean m7040isEmimpl(long j5) {
        return m7036getRawTypeimpl(j5) == 8589934592L;
    }

    /* renamed from: isSp-impl, reason: not valid java name */
    public static final boolean m7041isSpimpl(long j5) {
        return m7036getRawTypeimpl(j5) == 4294967296L;
    }

    /* renamed from: times-kPz2Gy4, reason: not valid java name */
    public static final long m7043timeskPz2Gy4(long j5, float f) {
        TextUnitKt.m7051checkArithmeticR2X_6o(j5);
        return TextUnitKt.pack(m7036getRawTypeimpl(j5), m7038getValueimpl(j5) * f);
    }

    /* renamed from: toString-impl, reason: not valid java name */
    public static String m7045toStringimpl(long j5) {
        long jM7037getTypeUIouoOA = m7037getTypeUIouoOA(j5);
        TextUnitType.Companion companion = TextUnitType.INSTANCE;
        if (TextUnitType.m7066equalsimpl0(jM7037getTypeUIouoOA, companion.m7072getUnspecifiedUIouoOA())) {
            return "Unspecified";
        }
        if (TextUnitType.m7066equalsimpl0(jM7037getTypeUIouoOA, companion.m7071getSpUIouoOA())) {
            return m7038getValueimpl(j5) + ".sp";
        }
        if (!TextUnitType.m7066equalsimpl0(jM7037getTypeUIouoOA, companion.m7070getEmUIouoOA())) {
            return "Invalid";
        }
        return m7038getValueimpl(j5) + ".em";
    }

    /* renamed from: unaryMinus-XSAIIZE, reason: not valid java name */
    public static final long m7046unaryMinusXSAIIZE(long j5) {
        TextUnitKt.m7051checkArithmeticR2X_6o(j5);
        return TextUnitKt.pack(m7036getRawTypeimpl(j5), -m7038getValueimpl(j5));
    }

    public boolean equals(Object other) {
        return m7034equalsimpl(this.packedValue, other);
    }

    public int hashCode() {
        return m7039hashCodeimpl(this.packedValue);
    }

    public String toString() {
        return m7045toStringimpl(this.packedValue);
    }

    /* renamed from: unbox-impl, reason: not valid java name and from getter */
    public final /* synthetic */ long getPackedValue() {
        return this.packedValue;
    }

    /* renamed from: div-kPz2Gy4, reason: not valid java name */
    public static final long m7031divkPz2Gy4(long j5, double d) {
        TextUnitKt.m7051checkArithmeticR2X_6o(j5);
        return TextUnitKt.pack(m7036getRawTypeimpl(j5), (float) (m7038getValueimpl(j5) / d));
    }

    /* renamed from: times-kPz2Gy4, reason: not valid java name */
    public static final long m7042timeskPz2Gy4(long j5, double d) {
        TextUnitKt.m7051checkArithmeticR2X_6o(j5);
        return TextUnitKt.pack(m7036getRawTypeimpl(j5), (float) (m7038getValueimpl(j5) * d));
    }

    /* renamed from: div-kPz2Gy4, reason: not valid java name */
    public static final long m7033divkPz2Gy4(long j5, int i) {
        TextUnitKt.m7051checkArithmeticR2X_6o(j5);
        return TextUnitKt.pack(m7036getRawTypeimpl(j5), m7038getValueimpl(j5) / i);
    }

    /* renamed from: times-kPz2Gy4, reason: not valid java name */
    public static final long m7044timeskPz2Gy4(long j5, int i) {
        TextUnitKt.m7051checkArithmeticR2X_6o(j5);
        return TextUnitKt.pack(m7036getRawTypeimpl(j5), m7038getValueimpl(j5) * i);
    }
}
