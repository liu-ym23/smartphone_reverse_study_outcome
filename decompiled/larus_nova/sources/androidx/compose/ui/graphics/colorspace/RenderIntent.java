package androidx.compose.ui.graphics.colorspace;

import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087@\u0018\u0000 \u000e2\u00020\u0001:\u0001\u000eB\u0011\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0006\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\b\u0010\tJ\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\r\u001a\u00020\u0003HÖ\u0001R\u000e\u0010\u0002\u001a\u00020\u0003X\u0080\u0004¢\u0006\u0002\n\u0000\u0088\u0001\u0002\u0092\u0001\u00020\u0003¨\u0006\u000f"}, d2 = {"Landroidx/compose/ui/graphics/colorspace/RenderIntent;", "", "value", "", "constructor-impl", "(I)I", "toString", "", "toString-impl", "(I)Ljava/lang/String;", "equals", "", "other", "hashCode", "Companion", "ui-graphics_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
@JvmInline
public final class RenderIntent {
    private static final int Absolute = 0;
    public static final Companion Companion = null;
    private static final int Perceptual = 0;
    private static final int Relative = 0;
    private static final int Saturation = 0;
    private final int value;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0013\u0010\u0004\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0006\u0010\u0007R\u0013\u0010\t\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\n\u0010\u0007R\u0013\u0010\u000b\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\f\u0010\u0007R\u0013\u0010\r\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u000e\u0010\u0007¨\u0006\u000f"}, d2 = {"Landroidx/compose/ui/graphics/colorspace/RenderIntent$Companion;", "", "<init>", "()V", "Perceptual", "Landroidx/compose/ui/graphics/colorspace/RenderIntent;", "getPerceptual-uksYyKA", "()I", "I", "Relative", "getRelative-uksYyKA", ExifInterface.TAG_SATURATION, "getSaturation-uksYyKA", "Absolute", "getAbsolute-uksYyKA", "ui-graphics_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }

        /* JADX INFO: renamed from: getAbsolute-uksYyKA, reason: not valid java name */
        public final int m5288getAbsoluteuksYyKA() {
            return RenderIntent.access$getAbsolute$cp();
        }

        /* JADX INFO: renamed from: getPerceptual-uksYyKA, reason: not valid java name */
        public final int m5289getPerceptualuksYyKA() {
            return RenderIntent.access$getPerceptual$cp();
        }

        /* JADX INFO: renamed from: getRelative-uksYyKA, reason: not valid java name */
        public final int m5290getRelativeuksYyKA() {
            return RenderIntent.access$getRelative$cp();
        }

        /* JADX INFO: renamed from: getSaturation-uksYyKA, reason: not valid java name */
        public final int m5291getSaturationuksYyKA() {
            return RenderIntent.access$getSaturation$cp();
        }
    }

    /* JADX INFO: renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ RenderIntent m5281boximpl(int r100) {
        return new RenderIntent(r100);
    }

    /* JADX INFO: renamed from: constructor-impl, reason: not valid java name */
    public static int m5282constructorimpl(int r100) {
        return r100;
    }

    /* JADX INFO: renamed from: equals-impl, reason: not valid java name */
    public static boolean m5283equalsimpl(int r100, Object r101) {
        if ((r101 instanceof RenderIntent) == true) goto L6;
        return false;
    L6:
        if (r100 == ((RenderIntent) r101).m5287unboximpl()) goto L8;
        return false;
    L8:
        return true;
    }

    /* JADX INFO: renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m5284equalsimpl0(int r100, int r101) {
        if (r100 != r101) goto L4;
        return true;
    L4:
        return false;
    }

    /* JADX INFO: renamed from: hashCode-impl, reason: not valid java name */
    public static int m5285hashCodeimpl(int r100) {
        return r100;
    }

    public boolean equals(Object r100) {
        return m5283equalsimpl(this.value, r100);
    }

    public int hashCode() {
        return m5285hashCodeimpl(this.value);
    }

    /* JADX INFO: renamed from: unbox-impl, reason: not valid java name */
    public final /* synthetic */ int m5287unboximpl() {
        return this.value;
    }

    static {
        Companion = new Companion(null);
        Perceptual = m5282constructorimpl(0);
        Relative = m5282constructorimpl(1);
        Saturation = m5282constructorimpl(2);
        Absolute = m5282constructorimpl(3);
    }

    public String toString() {
        return m5286toStringimpl(this.value);
    }

    public static final /* synthetic */ int access$getAbsolute$cp() {
        return Absolute;
    }

    public static final /* synthetic */ int access$getPerceptual$cp() {
        return Perceptual;
    }

    public static final /* synthetic */ int access$getRelative$cp() {
        return Relative;
    }

    public static final /* synthetic */ int access$getSaturation$cp() {
        return Saturation;
    }

    private /* synthetic */ RenderIntent(int r100) {
        this.value = r100;
    }

    /* JADX INFO: renamed from: toString-impl, reason: not valid java name */
    public static String m5286toStringimpl(int r100) {
        if (m5284equalsimpl0(r100, Perceptual) == false) goto L6;
        return "Perceptual";
    L6:
        if (m5284equalsimpl0(r100, Relative) == false) goto L9;
        return "Relative";
    L9:
        if (m5284equalsimpl0(r100, Saturation) == false) goto L12;
        return ExifInterface.TAG_SATURATION;
    L12:
        if (m5284equalsimpl0(r100, Absolute) == false) goto L14;
        return "Absolute";
    L14:
        return "Unknown";
    }
}
