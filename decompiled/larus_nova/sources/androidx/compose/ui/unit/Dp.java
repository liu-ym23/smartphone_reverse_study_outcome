package androidx.compose.ui.unit;

import com.bytedance.caijing.sdk.infra.base.api.face.FaceService;
import kotlin.Metadata;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u000f\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u000e\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0087@\u0018\u0000 \"2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\"B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0018\u0010\b\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0000H\u0087\n¢\u0006\u0004\b\n\u0010\u000bJ\u0018\u0010\f\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0000H\u0087\n¢\u0006\u0004\b\r\u0010\u000bJ\u0010\u0010\u000e\u001a\u00020\u0000H\u0087\n¢\u0006\u0004\b\u000f\u0010\u0005J\u0018\u0010\u0010\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0003H\u0087\n¢\u0006\u0004\b\u0011\u0010\u000bJ\u0018\u0010\u0010\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0012H\u0087\n¢\u0006\u0004\b\u0011\u0010\u0013J\u0018\u0010\u0010\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\u0000H\u0087\n¢\u0006\u0004\b\u0014\u0010\u000bJ\u0018\u0010\u0015\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0003H\u0087\n¢\u0006\u0004\b\u0016\u0010\u000bJ\u0018\u0010\u0015\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0012H\u0087\n¢\u0006\u0004\b\u0016\u0010\u0013J\u0018\u0010\u0017\u001a\u00020\u00122\u0006\u0010\t\u001a\u00020\u0000H\u0097\u0002¢\u0006\u0004\b\u0018\u0010\u0019J\u000f\u0010\u001a\u001a\u00020\u001bH\u0017¢\u0006\u0004\b\u001c\u0010\u001dJ\u0013\u0010\u001e\u001a\u00020\u001f2\b\u0010\t\u001a\u0004\u0018\u00010 HÖ\u0003J\t\u0010!\u001a\u00020\u0012HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007\u0088\u0001\u0002¨\u0006#"}, d2 = {"Landroidx/compose/ui/unit/Dp;", "", "value", "", "constructor-impl", "(F)F", "getValue", "()F", "plus", "other", "plus-5rwHm24", "(FF)F", "minus", "minus-5rwHm24", "unaryMinus", "unaryMinus-D9Ej5fM", "div", "div-u2uoSUM", "", "(FI)F", "div-0680j_4", "times", "times-u2uoSUM", "compareTo", "compareTo-0680j_4", "(FF)I", "toString", "", "toString-impl", "(F)Ljava/lang/String;", "equals", "", "", "hashCode", "Companion", "ui-unit"}, k = 1, mv = {2, 0, 0}, xi = 48)
@JvmInline
public final class Dp implements Comparable<Dp> {
    public static final Companion Companion = null;
    private static final float Hairline = 0.0f;
    private static final float Infinity = 0.0f;
    private static final float Unspecified = 0.0f;
    private final float value;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u001e\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010\t\u0012\u0004\b\u0006\u0010\u0003\u001a\u0004\b\u0007\u0010\bR\u001e\u0010\n\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010\t\u0012\u0004\b\u000b\u0010\u0003\u001a\u0004\b\f\u0010\bR\u001e\u0010\r\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010\t\u0012\u0004\b\u000e\u0010\u0003\u001a\u0004\b\u000f\u0010\b¨\u0006\u0010"}, d2 = {"Landroidx/compose/ui/unit/Dp$Companion;", "", "<init>", "()V", "Hairline", "Landroidx/compose/ui/unit/Dp;", "getHairline-D9Ej5fM$annotations", "getHairline-D9Ej5fM", "()F", FaceService.girlLabel, "Infinity", "getInfinity-D9Ej5fM$annotations", "getInfinity-D9Ej5fM", "Unspecified", "getUnspecified-D9Ej5fM$annotations", "getUnspecified-D9Ej5fM", "ui-unit"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }

        /* JADX INFO: renamed from: getHairline-D9Ej5fM$annotations, reason: not valid java name */
        public static /* synthetic */ void m7559getHairlineD9Ej5fM$annotations() {
        }

        /* JADX INFO: renamed from: getInfinity-D9Ej5fM$annotations, reason: not valid java name */
        public static /* synthetic */ void m7560getInfinityD9Ej5fM$annotations() {
        }

        /* JADX INFO: renamed from: getUnspecified-D9Ej5fM$annotations, reason: not valid java name */
        public static /* synthetic */ void m7561getUnspecifiedD9Ej5fM$annotations() {
        }

        /* JADX INFO: renamed from: getHairline-D9Ej5fM, reason: not valid java name */
        public final float m7562getHairlineD9Ej5fM() {
            return Dp.access$getHairline$cp();
        }

        /* JADX INFO: renamed from: getInfinity-D9Ej5fM, reason: not valid java name */
        public final float m7563getInfinityD9Ej5fM() {
            return Dp.access$getInfinity$cp();
        }

        /* JADX INFO: renamed from: getUnspecified-D9Ej5fM, reason: not valid java name */
        public final float m7564getUnspecifiedD9Ej5fM() {
            return Dp.access$getUnspecified$cp();
        }
    }

    /* JADX INFO: renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ Dp m7542boximpl(float r100) {
        return new Dp(r100);
    }

    /* JADX INFO: renamed from: constructor-impl, reason: not valid java name */
    public static float m7544constructorimpl(float r100) {
        return r100;
    }

    /* JADX INFO: renamed from: div-0680j_4, reason: not valid java name */
    public static final float m7545div0680j_4(float r100, float r101) {
        return r100 / r101;
    }

    /* JADX INFO: renamed from: equals-impl, reason: not valid java name */
    public static boolean m7548equalsimpl(float r100, Object r101) {
        if ((r101 instanceof Dp) == true) goto L6;
        return false;
    L6:
        if (Float.compare(r100, ((Dp) r101).m7558unboximpl()) == 0) goto L8;
        return false;
    L8:
        return true;
    }

    /* JADX INFO: renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m7549equalsimpl0(float r100, float r101) {
        if (Float.compare(r100, r101) != 0) goto L5;
        return true;
    L5:
        return false;
    }

    /* JADX INFO: renamed from: hashCode-impl, reason: not valid java name */
    public static int m7550hashCodeimpl(float r100) {
        return Float.floatToIntBits(r100);
    }

    public boolean equals(Object r100) {
        return m7548equalsimpl(this.value, r100);
    }

    public int hashCode() {
        return m7550hashCodeimpl(this.value);
    }

    /* JADX INFO: renamed from: unbox-impl, reason: not valid java name */
    public final /* synthetic */ float m7558unboximpl() {
        return this.value;
    }

    static {
        Companion = new Companion(null);
        Hairline = m7544constructorimpl(0.0f);
        Infinity = m7544constructorimpl(Float.POSITIVE_INFINITY);
        Unspecified = m7544constructorimpl(Float.NaN);
    }

    public String toString() {
        return m7555toStringimpl(this.value);
    }

    public static final /* synthetic */ float access$getHairline$cp() {
        return Hairline;
    }

    public static final /* synthetic */ float access$getInfinity$cp() {
        return Infinity;
    }

    public static final /* synthetic */ float access$getUnspecified$cp() {
        return Unspecified;
    }

    public final float getValue() {
        return this.value;
    }

    private /* synthetic */ Dp(float r100) {
        this.value = r100;
    }

    /* JADX INFO: renamed from: toString-impl, reason: not valid java name */
    public static String m7555toStringimpl(float r100) {
        if (Float.isNaN(r100) == false) goto L6;
        return "Dp.Unspecified";
    L6:
        return r100 + ".dp";
    }

    /* JADX INFO: renamed from: unaryMinus-D9Ej5fM, reason: not valid java name */
    public static final float m7556unaryMinusD9Ej5fM(float r100) {
        return m7544constructorimpl(-r100);
    }

    @Override // java.lang.Comparable
    public /* bridge */ /* synthetic */ int compareTo(Dp r100) {
        return m7557compareTo0680j_4(r100.m7558unboximpl());
    }

    /* JADX INFO: renamed from: compareTo-0680j_4, reason: not valid java name */
    public int m7557compareTo0680j_4(float r100) {
        return m7543compareTo0680j_4(this.value, r100);
    }

    /* JADX INFO: renamed from: compareTo-0680j_4, reason: not valid java name */
    public static int m7543compareTo0680j_4(float r100, float r101) {
        return Float.compare(r100, r101);
    }

    /* JADX INFO: renamed from: div-u2uoSUM, reason: not valid java name */
    public static final float m7547divu2uoSUM(float r100, int r101) {
        return m7544constructorimpl(r100 / r101);
    }

    /* JADX INFO: renamed from: minus-5rwHm24, reason: not valid java name */
    public static final float m7551minus5rwHm24(float r100, float r101) {
        return m7544constructorimpl(r100 - r101);
    }

    /* JADX INFO: renamed from: plus-5rwHm24, reason: not valid java name */
    public static final float m7552plus5rwHm24(float r100, float r101) {
        return m7544constructorimpl(r100 + r101);
    }

    /* JADX INFO: renamed from: times-u2uoSUM, reason: not valid java name */
    public static final float m7554timesu2uoSUM(float r100, int r101) {
        return m7544constructorimpl(r100 * r101);
    }

    /* JADX INFO: renamed from: div-u2uoSUM, reason: not valid java name */
    public static final float m7546divu2uoSUM(float r100, float r101) {
        return m7544constructorimpl(r100 / r101);
    }

    /* JADX INFO: renamed from: times-u2uoSUM, reason: not valid java name */
    public static final float m7553timesu2uoSUM(float r100, float r101) {
        return m7544constructorimpl(r100 * r101);
    }
}
