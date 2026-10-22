package androidx.compose.ui;

import com.bytedance.caijing.sdk.infra.base.api.face.FaceService;
import kotlin.Metadata;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087@\u0018\u0000 \u000f2\u00020\u0001:\u0001\u000fB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0006\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\b\u0010\tJ\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001R\u000e\u0010\u0002\u001a\u00020\u0003X\u0080\u0004¢\u0006\u0002\n\u0000\u0088\u0001\u0002\u0092\u0001\u00020\u0003¨\u0006\u0010"}, d2 = {"Landroidx/compose/ui/FrameRateCategory;", "", "value", "", "constructor-impl", "(F)F", "toString", "", "toString-impl", "(F)Ljava/lang/String;", "equals", "", "other", "hashCode", "", "Companion", "ui_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
@JvmInline
public final class FrameRateCategory {
    public static final Companion Companion = null;
    private static final float Default = 0.0f;
    private static final float High = 0.0f;
    private static final float Normal = 0.0f;
    private final float value;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0013\u0010\u0004\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0006\u0010\u0007R\u0013\u0010\t\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\n\u0010\u0007R\u0013\u0010\u000b\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\f\u0010\u0007¨\u0006\r"}, d2 = {"Landroidx/compose/ui/FrameRateCategory$Companion;", "", "<init>", "()V", "Default", "Landroidx/compose/ui/FrameRateCategory;", "getDefault-NSsRyOo", "()F", FaceService.girlLabel, "Normal", "getNormal-NSsRyOo", "High", "getHigh-NSsRyOo", "ui_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }

        /* JADX INFO: renamed from: getDefault-NSsRyOo, reason: not valid java name */
        public final float m4313getDefaultNSsRyOo() {
            return FrameRateCategory.access$getDefault$cp();
        }

        /* JADX INFO: renamed from: getHigh-NSsRyOo, reason: not valid java name */
        public final float m4314getHighNSsRyOo() {
            return FrameRateCategory.access$getHigh$cp();
        }

        /* JADX INFO: renamed from: getNormal-NSsRyOo, reason: not valid java name */
        public final float m4315getNormalNSsRyOo() {
            return FrameRateCategory.access$getNormal$cp();
        }
    }

    /* JADX INFO: renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ FrameRateCategory m4306boximpl(float r100) {
        return new FrameRateCategory(r100);
    }

    /* JADX INFO: renamed from: constructor-impl, reason: not valid java name */
    private static float m4307constructorimpl(float r100) {
        return r100;
    }

    /* JADX INFO: renamed from: equals-impl, reason: not valid java name */
    public static boolean m4308equalsimpl(float r100, Object r101) {
        if ((r101 instanceof FrameRateCategory) == true) goto L6;
        return false;
    L6:
        if (Float.compare(r100, ((FrameRateCategory) r101).m4312unboximpl()) == 0) goto L8;
        return false;
    L8:
        return true;
    }

    /* JADX INFO: renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m4309equalsimpl0(float r100, float r101) {
        if (Float.compare(r100, r101) != 0) goto L5;
        return true;
    L5:
        return false;
    }

    /* JADX INFO: renamed from: hashCode-impl, reason: not valid java name */
    public static int m4310hashCodeimpl(float r100) {
        return Float.floatToIntBits(r100);
    }

    /* JADX INFO: renamed from: toString-impl, reason: not valid java name */
    public static String m4311toStringimpl(float r100) {
        boolean r101 = true;
        if (r100 != (-3.0f)) goto L5;
        boolean r102 = true;
    L6:
        if (r102 == false) goto L9;
        return "Normal";
    L9:
        if (r100 == (-4.0f)) goto L12;
        r101 = false;
    L12:
        if (r101 == false) goto L14;
        return "High";
    L14:
        return "Default";
    L5:
        r102 = false;
        goto L6
    }

    public boolean equals(Object r100) {
        return m4308equalsimpl(this.value, r100);
    }

    public int hashCode() {
        return m4310hashCodeimpl(this.value);
    }

    /* JADX INFO: renamed from: unbox-impl, reason: not valid java name */
    public final /* synthetic */ float m4312unboximpl() {
        return this.value;
    }

    static {
        Companion = new Companion(null);
        Default = m4307constructorimpl(Float.NaN);
        Normal = m4307constructorimpl(-3.0f);
        High = m4307constructorimpl(-4.0f);
    }

    public String toString() {
        return m4311toStringimpl(this.value);
    }

    public static final /* synthetic */ float access$getDefault$cp() {
        return Default;
    }

    public static final /* synthetic */ float access$getHigh$cp() {
        return High;
    }

    public static final /* synthetic */ float access$getNormal$cp() {
        return Normal;
    }

    private /* synthetic */ FrameRateCategory(float r100) {
        this.value = r100;
    }
}
