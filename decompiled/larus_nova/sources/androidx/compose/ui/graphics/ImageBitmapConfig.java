package androidx.compose.ui.graphics;

import kotlin.Metadata;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087@\u0018\u0000 \u00102\u00020\u0001:\u0001\u0010B\u0011\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\b\u001a\u00020\tH\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000f\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007\u0088\u0001\u0002¨\u0006\u0011"}, d2 = {"Landroidx/compose/ui/graphics/ImageBitmapConfig;", "", "value", "", "constructor-impl", "(I)I", "getValue", "()I", "toString", "", "toString-impl", "(I)Ljava/lang/String;", "equals", "", "other", "hashCode", "Companion", "ui-graphics_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
@JvmInline
public final class ImageBitmapConfig {
    private static final int Alpha8 = 0;
    private static final int Argb8888 = 0;
    public static final Companion Companion = null;
    private static final int F16 = 0;
    private static final int Gpu = 0;
    private static final int Rgb565 = 0;
    private final int value;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\f\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0013\u0010\u0004\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0006\u0010\u0007R\u0013\u0010\t\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\n\u0010\u0007R\u0013\u0010\u000b\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\f\u0010\u0007R\u0013\u0010\r\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u000e\u0010\u0007R\u0013\u0010\u000f\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0010\u0010\u0007¨\u0006\u0011"}, d2 = {"Landroidx/compose/ui/graphics/ImageBitmapConfig$Companion;", "", "<init>", "()V", "Argb8888", "Landroidx/compose/ui/graphics/ImageBitmapConfig;", "getArgb8888-_sVssgQ", "()I", "I", "Alpha8", "getAlpha8-_sVssgQ", "Rgb565", "getRgb565-_sVssgQ", "F16", "getF16-_sVssgQ", "Gpu", "getGpu-_sVssgQ", "ui-graphics_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }

        /* JADX INFO: renamed from: getAlpha8-_sVssgQ, reason: not valid java name */
        public final int m5066getAlpha8_sVssgQ() {
            return ImageBitmapConfig.access$getAlpha8$cp();
        }

        /* JADX INFO: renamed from: getArgb8888-_sVssgQ, reason: not valid java name */
        public final int m5067getArgb8888_sVssgQ() {
            return ImageBitmapConfig.access$getArgb8888$cp();
        }

        /* JADX INFO: renamed from: getF16-_sVssgQ, reason: not valid java name */
        public final int m5068getF16_sVssgQ() {
            return ImageBitmapConfig.access$getF16$cp();
        }

        /* JADX INFO: renamed from: getGpu-_sVssgQ, reason: not valid java name */
        public final int m5069getGpu_sVssgQ() {
            return ImageBitmapConfig.access$getGpu$cp();
        }

        /* JADX INFO: renamed from: getRgb565-_sVssgQ, reason: not valid java name */
        public final int m5070getRgb565_sVssgQ() {
            return ImageBitmapConfig.access$getRgb565$cp();
        }
    }

    /* JADX INFO: renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ ImageBitmapConfig m5059boximpl(int r100) {
        return new ImageBitmapConfig(r100);
    }

    /* JADX INFO: renamed from: constructor-impl, reason: not valid java name */
    public static int m5060constructorimpl(int r100) {
        return r100;
    }

    /* JADX INFO: renamed from: equals-impl, reason: not valid java name */
    public static boolean m5061equalsimpl(int r100, Object r101) {
        if ((r101 instanceof ImageBitmapConfig) == true) goto L6;
        return false;
    L6:
        if (r100 == ((ImageBitmapConfig) r101).m5065unboximpl()) goto L8;
        return false;
    L8:
        return true;
    }

    /* JADX INFO: renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m5062equalsimpl0(int r100, int r101) {
        if (r100 != r101) goto L4;
        return true;
    L4:
        return false;
    }

    /* JADX INFO: renamed from: hashCode-impl, reason: not valid java name */
    public static int m5063hashCodeimpl(int r100) {
        return r100;
    }

    public boolean equals(Object r100) {
        return m5061equalsimpl(this.value, r100);
    }

    public int hashCode() {
        return m5063hashCodeimpl(this.value);
    }

    /* JADX INFO: renamed from: unbox-impl, reason: not valid java name */
    public final /* synthetic */ int m5065unboximpl() {
        return this.value;
    }

    static {
        Companion = new Companion(null);
        Argb8888 = m5060constructorimpl(0);
        Alpha8 = m5060constructorimpl(1);
        Rgb565 = m5060constructorimpl(2);
        F16 = m5060constructorimpl(3);
        Gpu = m5060constructorimpl(4);
    }

    public String toString() {
        return m5064toStringimpl(this.value);
    }

    public static final /* synthetic */ int access$getAlpha8$cp() {
        return Alpha8;
    }

    public static final /* synthetic */ int access$getArgb8888$cp() {
        return Argb8888;
    }

    public static final /* synthetic */ int access$getF16$cp() {
        return F16;
    }

    public static final /* synthetic */ int access$getGpu$cp() {
        return Gpu;
    }

    public static final /* synthetic */ int access$getRgb565$cp() {
        return Rgb565;
    }

    public final int getValue() {
        return this.value;
    }

    private /* synthetic */ ImageBitmapConfig(int r100) {
        this.value = r100;
    }

    /* JADX INFO: renamed from: toString-impl, reason: not valid java name */
    public static String m5064toStringimpl(int r100) {
        if (m5062equalsimpl0(r100, Argb8888) == false) goto L6;
        return "Argb8888";
    L6:
        if (m5062equalsimpl0(r100, Alpha8) == false) goto L9;
        return "Alpha8";
    L9:
        if (m5062equalsimpl0(r100, Rgb565) == false) goto L12;
        return "Rgb565";
    L12:
        if (m5062equalsimpl0(r100, F16) == false) goto L15;
        return "F16";
    L15:
        if (m5062equalsimpl0(r100, Gpu) == false) goto L17;
        return "Gpu";
    L17:
        return "Unknown";
    }
}
