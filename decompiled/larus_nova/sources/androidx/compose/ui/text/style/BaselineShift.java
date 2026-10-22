package androidx.compose.ui.text.style;

import com.bytedance.caijing.sdk.infra.base.api.face.FaceService;
import kotlin.Metadata;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0087@\u0018\u0000 \u000f2\u00020\u0001:\u0001\u000fB\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0013\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000b\u001a\u00020\fHÖ\u0001J\t\u0010\r\u001a\u00020\u000eHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007\u0088\u0001\u0002¨\u0006\u0010"}, d2 = {"Landroidx/compose/ui/text/style/BaselineShift;", "", "multiplier", "", "constructor-impl", "(F)F", "getMultiplier", "()F", "equals", "", "other", "hashCode", "", "toString", "", "Companion", "ui-text"}, k = 1, mv = {2, 0, 0}, xi = 48)
@JvmInline
public final class BaselineShift {
    public static final Companion Companion = null;
    private static final float None = 0.0f;
    private static final float Subscript = 0.0f;
    private static final float Superscript = 0.0f;
    private final float multiplier;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u001e\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010\t\u0012\u0004\b\u0006\u0010\u0003\u001a\u0004\b\u0007\u0010\bR\u001e\u0010\n\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010\t\u0012\u0004\b\u000b\u0010\u0003\u001a\u0004\b\f\u0010\bR\u001e\u0010\r\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010\t\u0012\u0004\b\u000e\u0010\u0003\u001a\u0004\b\u000f\u0010\b¨\u0006\u0010"}, d2 = {"Landroidx/compose/ui/text/style/BaselineShift$Companion;", "", "<init>", "()V", "Superscript", "Landroidx/compose/ui/text/style/BaselineShift;", "getSuperscript-y9eOQZs$annotations", "getSuperscript-y9eOQZs", "()F", FaceService.girlLabel, "Subscript", "getSubscript-y9eOQZs$annotations", "getSubscript-y9eOQZs", "None", "getNone-y9eOQZs$annotations", "getNone-y9eOQZs", "ui-text"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }

        /* JADX INFO: renamed from: getNone-y9eOQZs$annotations, reason: not valid java name */
        public static /* synthetic */ void m7297getNoney9eOQZs$annotations() {
        }

        /* JADX INFO: renamed from: getSubscript-y9eOQZs$annotations, reason: not valid java name */
        public static /* synthetic */ void m7298getSubscripty9eOQZs$annotations() {
        }

        /* JADX INFO: renamed from: getSuperscript-y9eOQZs$annotations, reason: not valid java name */
        public static /* synthetic */ void m7299getSuperscripty9eOQZs$annotations() {
        }

        /* JADX INFO: renamed from: getNone-y9eOQZs, reason: not valid java name */
        public final float m7300getNoney9eOQZs() {
            return BaselineShift.access$getNone$cp();
        }

        /* JADX INFO: renamed from: getSubscript-y9eOQZs, reason: not valid java name */
        public final float m7301getSubscripty9eOQZs() {
            return BaselineShift.access$getSubscript$cp();
        }

        /* JADX INFO: renamed from: getSuperscript-y9eOQZs, reason: not valid java name */
        public final float m7302getSuperscripty9eOQZs() {
            return BaselineShift.access$getSuperscript$cp();
        }
    }

    /* JADX INFO: renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ BaselineShift m7290boximpl(float r100) {
        return new BaselineShift(r100);
    }

    /* JADX INFO: renamed from: constructor-impl, reason: not valid java name */
    public static float m7291constructorimpl(float r100) {
        return r100;
    }

    /* JADX INFO: renamed from: equals-impl, reason: not valid java name */
    public static boolean m7292equalsimpl(float r100, Object r101) {
        if ((r101 instanceof BaselineShift) == true) goto L6;
        return false;
    L6:
        if (Float.compare(r100, ((BaselineShift) r101).m7296unboximpl()) == 0) goto L8;
        return false;
    L8:
        return true;
    }

    /* JADX INFO: renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m7293equalsimpl0(float r100, float r101) {
        if (Float.compare(r100, r101) != 0) goto L5;
        return true;
    L5:
        return false;
    }

    /* JADX INFO: renamed from: hashCode-impl, reason: not valid java name */
    public static int m7294hashCodeimpl(float r100) {
        return Float.floatToIntBits(r100);
    }

    /* JADX INFO: renamed from: toString-impl, reason: not valid java name */
    public static String m7295toStringimpl(float r100) {
        return "BaselineShift(multiplier=" + r100 + ')';
    }

    public boolean equals(Object r100) {
        return m7292equalsimpl(this.multiplier, r100);
    }

    public int hashCode() {
        return m7294hashCodeimpl(this.multiplier);
    }

    public String toString() {
        return m7295toStringimpl(this.multiplier);
    }

    /* JADX INFO: renamed from: unbox-impl, reason: not valid java name */
    public final /* synthetic */ float m7296unboximpl() {
        return this.multiplier;
    }

    static {
        Companion = new Companion(null);
        Superscript = m7291constructorimpl(0.5f);
        Subscript = m7291constructorimpl(-0.5f);
        None = m7291constructorimpl(0.0f);
    }

    public static final /* synthetic */ float access$getNone$cp() {
        return None;
    }

    public static final /* synthetic */ float access$getSubscript$cp() {
        return Subscript;
    }

    public static final /* synthetic */ float access$getSuperscript$cp() {
        return Superscript;
    }

    public final float getMultiplier() {
        return this.multiplier;
    }

    private /* synthetic */ BaselineShift(float r100) {
        this.multiplier = r100;
    }
}
