package androidx.compose.ui.graphics;

import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087@\u0018\u0000 \u000e2\u00020\u0001:\u0001\u000eB\u0011\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0006\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\b\u0010\tJ\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\r\u001a\u00020\u0003HÖ\u0001R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000\u0088\u0001\u0002\u0092\u0001\u00020\u0003¨\u0006\u000f"}, d2 = {"Landroidx/compose/ui/graphics/BlendMode;", "", "value", "", "constructor-impl", "(I)I", "toString", "", "toString-impl", "(I)Ljava/lang/String;", "equals", "", "other", "hashCode", "Companion", "ui-graphics_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
@JvmInline
public final class BlendMode {
    private static final int Clear = 0;
    private static final int Color = 0;
    private static final int ColorBurn = 0;
    private static final int ColorDodge = 0;
    public static final Companion Companion = null;
    private static final int Darken = 0;
    private static final int Difference = 0;
    private static final int Dst = 0;
    private static final int DstAtop = 0;
    private static final int DstIn = 0;
    private static final int DstOut = 0;
    private static final int DstOver = 0;
    private static final int Exclusion = 0;
    private static final int Hardlight = 0;
    private static final int Hue = 0;
    private static final int Lighten = 0;
    private static final int Luminosity = 0;
    private static final int Modulate = 0;
    private static final int Multiply = 0;
    private static final int Overlay = 0;
    private static final int Plus = 0;
    private static final int Saturation = 0;
    private static final int Screen = 0;
    private static final int Softlight = 0;
    private static final int Src = 0;
    private static final int SrcAtop = 0;
    private static final int SrcIn = 0;
    private static final int SrcOut = 0;
    private static final int SrcOver = 0;
    private static final int Xor = 0;
    private final int value;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b<\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0013\u0010\u0004\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0006\u0010\u0007R\u0013\u0010\t\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\n\u0010\u0007R\u0013\u0010\u000b\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\f\u0010\u0007R\u0013\u0010\r\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u000e\u0010\u0007R\u0013\u0010\u000f\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0010\u0010\u0007R\u0013\u0010\u0011\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0012\u0010\u0007R\u0013\u0010\u0013\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0014\u0010\u0007R\u0013\u0010\u0015\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0016\u0010\u0007R\u0013\u0010\u0017\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0018\u0010\u0007R\u0013\u0010\u0019\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u001a\u0010\u0007R\u0013\u0010\u001b\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u001c\u0010\u0007R\u0013\u0010\u001d\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u001e\u0010\u0007R\u0013\u0010\u001f\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b \u0010\u0007R\u0013\u0010!\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\"\u0010\u0007R\u0013\u0010#\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b$\u0010\u0007R\u0013\u0010%\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b&\u0010\u0007R\u0013\u0010'\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b(\u0010\u0007R\u0013\u0010)\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b*\u0010\u0007R\u0013\u0010+\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b,\u0010\u0007R\u0013\u0010-\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b.\u0010\u0007R\u0013\u0010/\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b0\u0010\u0007R\u0013\u00101\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b2\u0010\u0007R\u0013\u00103\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b4\u0010\u0007R\u0013\u00105\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b6\u0010\u0007R\u0013\u00107\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b8\u0010\u0007R\u0013\u00109\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b:\u0010\u0007R\u0013\u0010;\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b<\u0010\u0007R\u0013\u0010=\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b>\u0010\u0007R\u0013\u0010?\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b@\u0010\u0007¨\u0006A"}, d2 = {"Landroidx/compose/ui/graphics/BlendMode$Companion;", "", "<init>", "()V", "Clear", "Landroidx/compose/ui/graphics/BlendMode;", "getClear-0nO6VwU", "()I", "I", "Src", "getSrc-0nO6VwU", "Dst", "getDst-0nO6VwU", "SrcOver", "getSrcOver-0nO6VwU", "DstOver", "getDstOver-0nO6VwU", "SrcIn", "getSrcIn-0nO6VwU", "DstIn", "getDstIn-0nO6VwU", "SrcOut", "getSrcOut-0nO6VwU", "DstOut", "getDstOut-0nO6VwU", "SrcAtop", "getSrcAtop-0nO6VwU", "DstAtop", "getDstAtop-0nO6VwU", "Xor", "getXor-0nO6VwU", "Plus", "getPlus-0nO6VwU", "Modulate", "getModulate-0nO6VwU", "Screen", "getScreen-0nO6VwU", "Overlay", "getOverlay-0nO6VwU", "Darken", "getDarken-0nO6VwU", "Lighten", "getLighten-0nO6VwU", "ColorDodge", "getColorDodge-0nO6VwU", "ColorBurn", "getColorBurn-0nO6VwU", "Hardlight", "getHardlight-0nO6VwU", "Softlight", "getSoftlight-0nO6VwU", "Difference", "getDifference-0nO6VwU", "Exclusion", "getExclusion-0nO6VwU", "Multiply", "getMultiply-0nO6VwU", "Hue", "getHue-0nO6VwU", ExifInterface.TAG_SATURATION, "getSaturation-0nO6VwU", "Color", "getColor-0nO6VwU", "Luminosity", "getLuminosity-0nO6VwU", "ui-graphics_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }

        /* JADX INFO: renamed from: getClear-0nO6VwU, reason: not valid java name */
        public final int m4741getClear0nO6VwU() {
            return BlendMode.access$getClear$cp();
        }

        /* JADX INFO: renamed from: getColor-0nO6VwU, reason: not valid java name */
        public final int m4742getColor0nO6VwU() {
            return BlendMode.access$getColor$cp();
        }

        /* JADX INFO: renamed from: getColorBurn-0nO6VwU, reason: not valid java name */
        public final int m4743getColorBurn0nO6VwU() {
            return BlendMode.access$getColorBurn$cp();
        }

        /* JADX INFO: renamed from: getColorDodge-0nO6VwU, reason: not valid java name */
        public final int m4744getColorDodge0nO6VwU() {
            return BlendMode.access$getColorDodge$cp();
        }

        /* JADX INFO: renamed from: getDarken-0nO6VwU, reason: not valid java name */
        public final int m4745getDarken0nO6VwU() {
            return BlendMode.access$getDarken$cp();
        }

        /* JADX INFO: renamed from: getDifference-0nO6VwU, reason: not valid java name */
        public final int m4746getDifference0nO6VwU() {
            return BlendMode.access$getDifference$cp();
        }

        /* JADX INFO: renamed from: getDst-0nO6VwU, reason: not valid java name */
        public final int m4747getDst0nO6VwU() {
            return BlendMode.access$getDst$cp();
        }

        /* JADX INFO: renamed from: getDstAtop-0nO6VwU, reason: not valid java name */
        public final int m4748getDstAtop0nO6VwU() {
            return BlendMode.access$getDstAtop$cp();
        }

        /* JADX INFO: renamed from: getDstIn-0nO6VwU, reason: not valid java name */
        public final int m4749getDstIn0nO6VwU() {
            return BlendMode.access$getDstIn$cp();
        }

        /* JADX INFO: renamed from: getDstOut-0nO6VwU, reason: not valid java name */
        public final int m4750getDstOut0nO6VwU() {
            return BlendMode.access$getDstOut$cp();
        }

        /* JADX INFO: renamed from: getDstOver-0nO6VwU, reason: not valid java name */
        public final int m4751getDstOver0nO6VwU() {
            return BlendMode.access$getDstOver$cp();
        }

        /* JADX INFO: renamed from: getExclusion-0nO6VwU, reason: not valid java name */
        public final int m4752getExclusion0nO6VwU() {
            return BlendMode.access$getExclusion$cp();
        }

        /* JADX INFO: renamed from: getHardlight-0nO6VwU, reason: not valid java name */
        public final int m4753getHardlight0nO6VwU() {
            return BlendMode.access$getHardlight$cp();
        }

        /* JADX INFO: renamed from: getHue-0nO6VwU, reason: not valid java name */
        public final int m4754getHue0nO6VwU() {
            return BlendMode.access$getHue$cp();
        }

        /* JADX INFO: renamed from: getLighten-0nO6VwU, reason: not valid java name */
        public final int m4755getLighten0nO6VwU() {
            return BlendMode.access$getLighten$cp();
        }

        /* JADX INFO: renamed from: getLuminosity-0nO6VwU, reason: not valid java name */
        public final int m4756getLuminosity0nO6VwU() {
            return BlendMode.access$getLuminosity$cp();
        }

        /* JADX INFO: renamed from: getModulate-0nO6VwU, reason: not valid java name */
        public final int m4757getModulate0nO6VwU() {
            return BlendMode.access$getModulate$cp();
        }

        /* JADX INFO: renamed from: getMultiply-0nO6VwU, reason: not valid java name */
        public final int m4758getMultiply0nO6VwU() {
            return BlendMode.access$getMultiply$cp();
        }

        /* JADX INFO: renamed from: getOverlay-0nO6VwU, reason: not valid java name */
        public final int m4759getOverlay0nO6VwU() {
            return BlendMode.access$getOverlay$cp();
        }

        /* JADX INFO: renamed from: getPlus-0nO6VwU, reason: not valid java name */
        public final int m4760getPlus0nO6VwU() {
            return BlendMode.access$getPlus$cp();
        }

        /* JADX INFO: renamed from: getSaturation-0nO6VwU, reason: not valid java name */
        public final int m4761getSaturation0nO6VwU() {
            return BlendMode.access$getSaturation$cp();
        }

        /* JADX INFO: renamed from: getScreen-0nO6VwU, reason: not valid java name */
        public final int m4762getScreen0nO6VwU() {
            return BlendMode.access$getScreen$cp();
        }

        /* JADX INFO: renamed from: getSoftlight-0nO6VwU, reason: not valid java name */
        public final int m4763getSoftlight0nO6VwU() {
            return BlendMode.access$getSoftlight$cp();
        }

        /* JADX INFO: renamed from: getSrc-0nO6VwU, reason: not valid java name */
        public final int m4764getSrc0nO6VwU() {
            return BlendMode.access$getSrc$cp();
        }

        /* JADX INFO: renamed from: getSrcAtop-0nO6VwU, reason: not valid java name */
        public final int m4765getSrcAtop0nO6VwU() {
            return BlendMode.access$getSrcAtop$cp();
        }

        /* JADX INFO: renamed from: getSrcIn-0nO6VwU, reason: not valid java name */
        public final int m4766getSrcIn0nO6VwU() {
            return BlendMode.access$getSrcIn$cp();
        }

        /* JADX INFO: renamed from: getSrcOut-0nO6VwU, reason: not valid java name */
        public final int m4767getSrcOut0nO6VwU() {
            return BlendMode.access$getSrcOut$cp();
        }

        /* JADX INFO: renamed from: getSrcOver-0nO6VwU, reason: not valid java name */
        public final int m4768getSrcOver0nO6VwU() {
            return BlendMode.access$getSrcOver$cp();
        }

        /* JADX INFO: renamed from: getXor-0nO6VwU, reason: not valid java name */
        public final int m4769getXor0nO6VwU() {
            return BlendMode.access$getXor$cp();
        }
    }

    /* JADX INFO: renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ BlendMode m4734boximpl(int r100) {
        return new BlendMode(r100);
    }

    /* JADX INFO: renamed from: constructor-impl, reason: not valid java name */
    public static int m4735constructorimpl(int r100) {
        return r100;
    }

    /* JADX INFO: renamed from: equals-impl, reason: not valid java name */
    public static boolean m4736equalsimpl(int r100, Object r101) {
        if ((r101 instanceof BlendMode) == true) goto L6;
        return false;
    L6:
        if (r100 == ((BlendMode) r101).m4740unboximpl()) goto L8;
        return false;
    L8:
        return true;
    }

    /* JADX INFO: renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m4737equalsimpl0(int r100, int r101) {
        if (r100 != r101) goto L4;
        return true;
    L4:
        return false;
    }

    /* JADX INFO: renamed from: hashCode-impl, reason: not valid java name */
    public static int m4738hashCodeimpl(int r100) {
        return r100;
    }

    public boolean equals(Object r100) {
        return m4736equalsimpl(this.value, r100);
    }

    public int hashCode() {
        return m4738hashCodeimpl(this.value);
    }

    /* JADX INFO: renamed from: unbox-impl, reason: not valid java name */
    public final /* synthetic */ int m4740unboximpl() {
        return this.value;
    }

    static {
        Companion = new Companion(null);
        Clear = m4735constructorimpl(0);
        Src = m4735constructorimpl(1);
        Dst = m4735constructorimpl(2);
        SrcOver = m4735constructorimpl(3);
        DstOver = m4735constructorimpl(4);
        SrcIn = m4735constructorimpl(5);
        DstIn = m4735constructorimpl(6);
        SrcOut = m4735constructorimpl(7);
        DstOut = m4735constructorimpl(8);
        SrcAtop = m4735constructorimpl(9);
        DstAtop = m4735constructorimpl(10);
        Xor = m4735constructorimpl(11);
        Plus = m4735constructorimpl(12);
        Modulate = m4735constructorimpl(13);
        Screen = m4735constructorimpl(14);
        Overlay = m4735constructorimpl(15);
        Darken = m4735constructorimpl(16);
        Lighten = m4735constructorimpl(17);
        ColorDodge = m4735constructorimpl(18);
        ColorBurn = m4735constructorimpl(19);
        Hardlight = m4735constructorimpl(20);
        Softlight = m4735constructorimpl(21);
        Difference = m4735constructorimpl(22);
        Exclusion = m4735constructorimpl(23);
        Multiply = m4735constructorimpl(24);
        Hue = m4735constructorimpl(25);
        Saturation = m4735constructorimpl(26);
        Color = m4735constructorimpl(27);
        Luminosity = m4735constructorimpl(28);
    }

    public String toString() {
        return m4739toStringimpl(this.value);
    }

    public static final /* synthetic */ int access$getClear$cp() {
        return Clear;
    }

    public static final /* synthetic */ int access$getColor$cp() {
        return Color;
    }

    public static final /* synthetic */ int access$getColorBurn$cp() {
        return ColorBurn;
    }

    public static final /* synthetic */ int access$getColorDodge$cp() {
        return ColorDodge;
    }

    public static final /* synthetic */ int access$getDarken$cp() {
        return Darken;
    }

    public static final /* synthetic */ int access$getDifference$cp() {
        return Difference;
    }

    public static final /* synthetic */ int access$getDst$cp() {
        return Dst;
    }

    public static final /* synthetic */ int access$getDstAtop$cp() {
        return DstAtop;
    }

    public static final /* synthetic */ int access$getDstIn$cp() {
        return DstIn;
    }

    public static final /* synthetic */ int access$getDstOut$cp() {
        return DstOut;
    }

    public static final /* synthetic */ int access$getDstOver$cp() {
        return DstOver;
    }

    public static final /* synthetic */ int access$getExclusion$cp() {
        return Exclusion;
    }

    public static final /* synthetic */ int access$getHardlight$cp() {
        return Hardlight;
    }

    public static final /* synthetic */ int access$getHue$cp() {
        return Hue;
    }

    public static final /* synthetic */ int access$getLighten$cp() {
        return Lighten;
    }

    public static final /* synthetic */ int access$getLuminosity$cp() {
        return Luminosity;
    }

    public static final /* synthetic */ int access$getModulate$cp() {
        return Modulate;
    }

    public static final /* synthetic */ int access$getMultiply$cp() {
        return Multiply;
    }

    public static final /* synthetic */ int access$getOverlay$cp() {
        return Overlay;
    }

    public static final /* synthetic */ int access$getPlus$cp() {
        return Plus;
    }

    public static final /* synthetic */ int access$getSaturation$cp() {
        return Saturation;
    }

    public static final /* synthetic */ int access$getScreen$cp() {
        return Screen;
    }

    public static final /* synthetic */ int access$getSoftlight$cp() {
        return Softlight;
    }

    public static final /* synthetic */ int access$getSrc$cp() {
        return Src;
    }

    public static final /* synthetic */ int access$getSrcAtop$cp() {
        return SrcAtop;
    }

    public static final /* synthetic */ int access$getSrcIn$cp() {
        return SrcIn;
    }

    public static final /* synthetic */ int access$getSrcOut$cp() {
        return SrcOut;
    }

    public static final /* synthetic */ int access$getSrcOver$cp() {
        return SrcOver;
    }

    public static final /* synthetic */ int access$getXor$cp() {
        return Xor;
    }

    private /* synthetic */ BlendMode(int r100) {
        this.value = r100;
    }

    /* JADX INFO: renamed from: toString-impl, reason: not valid java name */
    public static String m4739toStringimpl(int r100) {
        if (m4737equalsimpl0(r100, Clear) == false) goto L6;
        return "Clear";
    L6:
        if (m4737equalsimpl0(r100, Src) == false) goto L9;
        return "Src";
    L9:
        if (m4737equalsimpl0(r100, Dst) == false) goto L12;
        return "Dst";
    L12:
        if (m4737equalsimpl0(r100, SrcOver) == false) goto L15;
        return "SrcOver";
    L15:
        if (m4737equalsimpl0(r100, DstOver) == false) goto L18;
        return "DstOver";
    L18:
        if (m4737equalsimpl0(r100, SrcIn) == false) goto L21;
        return "SrcIn";
    L21:
        if (m4737equalsimpl0(r100, DstIn) == false) goto L24;
        return "DstIn";
    L24:
        if (m4737equalsimpl0(r100, SrcOut) == false) goto L27;
        return "SrcOut";
    L27:
        if (m4737equalsimpl0(r100, DstOut) == false) goto L30;
        return "DstOut";
    L30:
        if (m4737equalsimpl0(r100, SrcAtop) == false) goto L33;
        return "SrcAtop";
    L33:
        if (m4737equalsimpl0(r100, DstAtop) == false) goto L36;
        return "DstAtop";
    L36:
        if (m4737equalsimpl0(r100, Xor) == false) goto L39;
        return "Xor";
    L39:
        if (m4737equalsimpl0(r100, Plus) == false) goto L42;
        return "Plus";
    L42:
        if (m4737equalsimpl0(r100, Modulate) == false) goto L45;
        return "Modulate";
    L45:
        if (m4737equalsimpl0(r100, Screen) == false) goto L48;
        return "Screen";
    L48:
        if (m4737equalsimpl0(r100, Overlay) == false) goto L51;
        return "Overlay";
    L51:
        if (m4737equalsimpl0(r100, Darken) == false) goto L54;
        return "Darken";
    L54:
        if (m4737equalsimpl0(r100, Lighten) == false) goto L57;
        return "Lighten";
    L57:
        if (m4737equalsimpl0(r100, ColorDodge) == false) goto L60;
        return "ColorDodge";
    L60:
        if (m4737equalsimpl0(r100, ColorBurn) == false) goto L63;
        return "ColorBurn";
    L63:
        if (m4737equalsimpl0(r100, Hardlight) == false) goto L66;
        return "HardLight";
    L66:
        if (m4737equalsimpl0(r100, Softlight) == false) goto L69;
        return "Softlight";
    L69:
        if (m4737equalsimpl0(r100, Difference) == false) goto L72;
        return "Difference";
    L72:
        if (m4737equalsimpl0(r100, Exclusion) == false) goto L75;
        return "Exclusion";
    L75:
        if (m4737equalsimpl0(r100, Multiply) == false) goto L78;
        return "Multiply";
    L78:
        if (m4737equalsimpl0(r100, Hue) == false) goto L81;
        return "Hue";
    L81:
        if (m4737equalsimpl0(r100, Saturation) == false) goto L84;
        return ExifInterface.TAG_SATURATION;
    L84:
        if (m4737equalsimpl0(r100, Color) == false) goto L87;
        return "Color";
    L87:
        if (m4737equalsimpl0(r100, Luminosity) == false) goto L89;
        return "Luminosity";
    L89:
        return "Unknown";
    }
}
