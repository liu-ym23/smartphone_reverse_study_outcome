package androidx.compose.ui.unit;

import kotlin.Metadata;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.bouncycastle.asn1.cmc.BodyPartID;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u000b\b\u0087@\u0018\u0000 ,2\u00020\u0001:\u0001,B\u0011\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0006\u001a\u00020\u0000H\u0086\n¢\u0006\u0004\b\u0007\u0010\u0005J\u0018\u0010\b\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\nH\u0086\n¢\u0006\u0004\b\u000b\u0010\fJ\u0018\u0010\b\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\rH\u0086\n¢\u0006\u0004\b\u000b\u0010\u000eJ\u0018\u0010\b\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u000fH\u0086\n¢\u0006\u0004\b\u000b\u0010\u0010J\u0018\u0010\u0011\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\nH\u0086\n¢\u0006\u0004\b\u0012\u0010\fJ\u0018\u0010\u0011\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\rH\u0086\n¢\u0006\u0004\b\u0012\u0010\u000eJ\u0018\u0010\u0011\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u000fH\u0086\n¢\u0006\u0004\b\u0012\u0010\u0010J\u0018\u0010\u0013\u001a\u00020\u000f2\u0006\u0010\t\u001a\u00020\u0000H\u0086\n¢\u0006\u0004\b\u0014\u0010\u0015J\u000f\u0010\u0016\u001a\u00020\u0017H\u0016¢\u0006\u0004\b\u0018\u0010\u0019J\u0013\u0010*\u001a\u00020\"2\b\u0010\t\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010+\u001a\u00020\u000fHÖ\u0001R\u000e\u0010\u0002\u001a\u00020\u0003X\u0080\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u001a\u001a\u00020\u00038@X\u0081\u0004¢\u0006\f\u0012\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u0005R\u0011\u0010\u001e\u001a\u00020\u001f8F¢\u0006\u0006\u001a\u0004\b \u0010\u0005R\u0011\u0010!\u001a\u00020\"8F¢\u0006\u0006\u001a\u0004\b#\u0010$R\u0011\u0010%\u001a\u00020\"8F¢\u0006\u0006\u001a\u0004\b&\u0010$R\u0011\u0010'\u001a\u00020\n8F¢\u0006\u0006\u001a\u0004\b(\u0010)\u0088\u0001\u0002\u0092\u0001\u00020\u0003¨\u0006-"}, d2 = {"Landroidx/compose/ui/unit/TextUnit;", "", "packedValue", "", "constructor-impl", "(J)J", "unaryMinus", "unaryMinus-XSAIIZE", "div", "other", "", "div-kPz2Gy4", "(JF)J", "", "(JD)J", "", "(JI)J", "times", "times-kPz2Gy4", "compareTo", "compareTo--R2X_6o", "(JJ)I", "toString", "", "toString-impl", "(J)Ljava/lang/String;", "rawType", "getRawType$annotations", "()V", "getRawType-impl", "type", "Landroidx/compose/ui/unit/TextUnitType;", "getType-UIouoOA", "isSp", "", "isSp-impl", "(J)Z", "isEm", "isEm-impl", "value", "getValue-impl", "(J)F", "equals", "hashCode", "Companion", "ui-unit"}, k = 1, mv = {2, 0, 0}, xi = 48)
@JvmInline
public final class TextUnit {
    public static final Companion Companion = null;
    private static final TextUnitType[] TextUnitTypes = null;
    private static final long Unspecified = 0;
    private final long packedValue;

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u001c\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0080\u0004¢\u0006\n\n\u0002\u0010\t\u001a\u0004\b\u0007\u0010\bR\u001e\u0010\n\u001a\u00020\u000b8\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010\u000f\u0012\u0004\b\f\u0010\u0003\u001a\u0004\b\r\u0010\u000e¨\u0006\u0010"}, d2 = {"Landroidx/compose/ui/unit/TextUnit$Companion;", "", "<init>", "()V", "TextUnitTypes", "", "Landroidx/compose/ui/unit/TextUnitType;", "getTextUnitTypes$ui_unit", "()[Landroidx/compose/ui/unit/TextUnitType;", "[Landroidx/compose/ui/unit/TextUnitType;", "Unspecified", "Landroidx/compose/ui/unit/TextUnit;", "getUnspecified-XSAIIZE$annotations", "getUnspecified-XSAIIZE", "()J", "J", "ui-unit"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }

        /* JADX INFO: renamed from: getUnspecified-XSAIIZE$annotations, reason: not valid java name */
        public static /* synthetic */ void m7752getUnspecifiedXSAIIZE$annotations() {
        }

        public final TextUnitType[] getTextUnitTypes$ui_unit() {
            return TextUnit.access$getTextUnitTypes$cp();
        }

        /* JADX INFO: renamed from: getUnspecified-XSAIIZE, reason: not valid java name */
        public final long m7753getUnspecifiedXSAIIZE() {
            return TextUnit.access$getUnspecified$cp();
        }
    }

    /* JADX INFO: renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ TextUnit m7732boximpl(long r100) {
        return new TextUnit(r100);
    }

    /* JADX INFO: renamed from: constructor-impl, reason: not valid java name */
    public static long m7734constructorimpl(long r100) {
        return r100;
    }

    /* JADX INFO: renamed from: equals-impl, reason: not valid java name */
    public static boolean m7738equalsimpl(long r100, Object r101) {
        if ((r101 instanceof TextUnit) == true) goto L6;
        return false;
    L6:
        if (r100 == ((TextUnit) r101).m7751unboximpl()) goto L8;
        return false;
    L8:
        return true;
    }

    /* JADX INFO: renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m7739equalsimpl0(long r100, long r101) {
        if (r100 != r101) goto L5;
        return true;
    L5:
        return false;
    }

    public static /* synthetic */ void getRawType$annotations() {
    }

    /* JADX INFO: renamed from: getRawType-impl, reason: not valid java name */
    public static final long m7740getRawTypeimpl(long r100) {
        return r100 & 1095216660480L;
    }

    /* JADX INFO: renamed from: hashCode-impl, reason: not valid java name */
    public static int m7743hashCodeimpl(long r100) {
        return (int) (r100 ^ (r100 >>> 32));
    }

    public boolean equals(Object r100) {
        return m7738equalsimpl(this.packedValue, r100);
    }

    public int hashCode() {
        return m7743hashCodeimpl(this.packedValue);
    }

    /* JADX INFO: renamed from: unbox-impl, reason: not valid java name */
    public final /* synthetic */ long m7751unboximpl() {
        return this.packedValue;
    }

    static {
        Companion = new Companion(null);
        TextUnitType.Companion r100 = TextUnitType.Companion;
        TextUnitTypes = new TextUnitType[]{TextUnitType.m7767boximpl(r100.m7776getUnspecifiedUIouoOA()), TextUnitType.m7767boximpl(r100.m7775getSpUIouoOA()), TextUnitType.m7767boximpl(r100.m7774getEmUIouoOA())};
        Unspecified = TextUnitKt.pack(0, Float.NaN);
    }

    public String toString() {
        return m7749toStringimpl(this.packedValue);
    }

    public static final /* synthetic */ TextUnitType[] access$getTextUnitTypes$cp() {
        return TextUnitTypes;
    }

    public static final /* synthetic */ long access$getUnspecified$cp() {
        return Unspecified;
    }

    private /* synthetic */ TextUnit(long r100) {
        this.packedValue = r100;
    }

    /* JADX INFO: renamed from: getType-UIouoOA, reason: not valid java name */
    public static final long m7741getTypeUIouoOA(long r100) {
        return TextUnitTypes[(int) (m7740getRawTypeimpl(r100) >>> 32)].m7773unboximpl();
    }

    /* JADX INFO: renamed from: getValue-impl, reason: not valid java name */
    public static final float m7742getValueimpl(long r100) {
        return Float.intBitsToFloat((int) (r100 & BodyPartID.bodyIdMax));
    }

    /* JADX INFO: renamed from: isEm-impl, reason: not valid java name */
    public static final boolean m7744isEmimpl(long r100) {
        if (m7740getRawTypeimpl(r100) != 8589934592L) goto L5;
        return true;
    L5:
        return false;
    }

    /* JADX INFO: renamed from: isSp-impl, reason: not valid java name */
    public static final boolean m7745isSpimpl(long r100) {
        if (m7740getRawTypeimpl(r100) != 4294967296L) goto L5;
        return true;
    L5:
        return false;
    }

    /* JADX INFO: renamed from: toString-impl, reason: not valid java name */
    public static String m7749toStringimpl(long r100) {
        long r101 = m7741getTypeUIouoOA(r100);
        TextUnitType.Companion r102 = TextUnitType.Companion;
        if (TextUnitType.m7770equalsimpl0(r101, r102.m7776getUnspecifiedUIouoOA()) == false) goto L6;
        return "Unspecified";
    L6:
        if (TextUnitType.m7770equalsimpl0(r101, r102.m7775getSpUIouoOA()) == false) goto L9;
        return m7742getValueimpl(r100) + ".sp";
    L9:
        if (TextUnitType.m7770equalsimpl0(r101, r102.m7774getEmUIouoOA()) == true) goto L15;
        return "Invalid";
    L15:
        return m7742getValueimpl(r100) + ".em";
    }

    /* JADX INFO: renamed from: unaryMinus-XSAIIZE, reason: not valid java name */
    public static final long m7750unaryMinusXSAIIZE(long r100) {
        TextUnitKt.m7755checkArithmeticR2X_6o(r100);
        return TextUnitKt.pack(m7740getRawTypeimpl(r100), -m7742getValueimpl(r100));
    }

    /* JADX INFO: renamed from: compareTo--R2X_6o, reason: not valid java name */
    public static final int m7733compareToR2X_6o(long r100, long r101) {
        TextUnitKt.m7756checkArithmeticNB67dxo(r100, r101);
        return Float.compare(m7742getValueimpl(r100), m7742getValueimpl(r101));
    }

    /* JADX INFO: renamed from: div-kPz2Gy4, reason: not valid java name */
    public static final long m7735divkPz2Gy4(long r100, double r101) {
        TextUnitKt.m7755checkArithmeticR2X_6o(r100);
        return TextUnitKt.pack(m7740getRawTypeimpl(r100), (float) (((double) m7742getValueimpl(r100)) / r101));
    }

    /* JADX INFO: renamed from: times-kPz2Gy4, reason: not valid java name */
    public static final long m7746timeskPz2Gy4(long r100, double r101) {
        TextUnitKt.m7755checkArithmeticR2X_6o(r100);
        return TextUnitKt.pack(m7740getRawTypeimpl(r100), (float) (((double) m7742getValueimpl(r100)) * r101));
    }

    /* JADX INFO: renamed from: div-kPz2Gy4, reason: not valid java name */
    public static final long m7737divkPz2Gy4(long r100, int r101) {
        TextUnitKt.m7755checkArithmeticR2X_6o(r100);
        return TextUnitKt.pack(m7740getRawTypeimpl(r100), m7742getValueimpl(r100) / r101);
    }

    /* JADX INFO: renamed from: times-kPz2Gy4, reason: not valid java name */
    public static final long m7748timeskPz2Gy4(long r100, int r101) {
        TextUnitKt.m7755checkArithmeticR2X_6o(r100);
        return TextUnitKt.pack(m7740getRawTypeimpl(r100), m7742getValueimpl(r100) * r101);
    }

    /* JADX INFO: renamed from: div-kPz2Gy4, reason: not valid java name */
    public static final long m7736divkPz2Gy4(long r100, float r101) {
        TextUnitKt.m7755checkArithmeticR2X_6o(r100);
        return TextUnitKt.pack(m7740getRawTypeimpl(r100), m7742getValueimpl(r100) / r101);
    }

    /* JADX INFO: renamed from: times-kPz2Gy4, reason: not valid java name */
    public static final long m7747timeskPz2Gy4(long r100, float r101) {
        TextUnitKt.m7755checkArithmeticR2X_6o(r100);
        return TextUnitKt.pack(m7740getRawTypeimpl(r100), m7742getValueimpl(r100) * r101);
    }
}
