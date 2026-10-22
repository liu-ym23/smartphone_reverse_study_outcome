package androidx.compose.ui.graphics;

import android.graphics.PorterDuff;
import android.os.Build;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a\u0011\u0010\u0000\u001a\u00020\u0001*\u00020\u0002¢\u0006\u0004\b\u0003\u0010\u0004\u001a\u0013\u0010\u0005\u001a\u00020\u0006*\u00020\u0002H\u0000¢\u0006\u0004\b\u0007\u0010\b\u001a\u0013\u0010\t\u001a\u00020\n*\u00020\u0002H\u0001¢\u0006\u0004\b\u000b\u0010\f\u001a\u0011\u0010\r\u001a\u00020\u0002*\u00020\nH\u0001¢\u0006\u0002\u0010\u000e¨\u0006\u000f"}, d2 = {"isSupported", "", "Landroidx/compose/ui/graphics/BlendMode;", "isSupported-s9anfk8", "(I)Z", "toPorterDuffMode", "Landroid/graphics/PorterDuff$Mode;", "toPorterDuffMode-s9anfk8", "(I)Landroid/graphics/PorterDuff$Mode;", "toAndroidBlendMode", "Landroid/graphics/BlendMode;", "toAndroidBlendMode-s9anfk8", "(I)Landroid/graphics/BlendMode;", "toComposeBlendMode", "(Landroid/graphics/BlendMode;)I", "ui-graphics_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class AndroidBlendMode_androidKt {

    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0 = null;

        static {
            int[] r100 = new int[android.graphics.BlendMode.values().length];
            r100[android.graphics.BlendMode.CLEAR.ordinal()] = 1;     // Catch: NoSuchFieldError -> L34
        L81:
            r100[android.graphics.BlendMode.SRC.ordinal()] = 2;     // Catch: NoSuchFieldError -> L35
        L93:
            r100[android.graphics.BlendMode.DST.ordinal()] = 3;     // Catch: NoSuchFieldError -> L36
        L99:
            r100[android.graphics.BlendMode.SRC_OVER.ordinal()] = 4;     // Catch: NoSuchFieldError -> L37
        L103:
            r100[android.graphics.BlendMode.DST_OVER.ordinal()] = 5;     // Catch: NoSuchFieldError -> L38
        L107:
            r100[android.graphics.BlendMode.SRC_IN.ordinal()] = 6;     // Catch: NoSuchFieldError -> L39
        L117:
            r100[android.graphics.BlendMode.DST_IN.ordinal()] = 7;     // Catch: NoSuchFieldError -> L40
        L71:
            r100[android.graphics.BlendMode.SRC_OUT.ordinal()] = 8;     // Catch: NoSuchFieldError -> L41
        L83:
            r100[android.graphics.BlendMode.DST_OUT.ordinal()] = 9;     // Catch: NoSuchFieldError -> L42
        L85:
            r100[android.graphics.BlendMode.SRC_ATOP.ordinal()] = 10;     // Catch: NoSuchFieldError -> L43
        L95:
            r100[android.graphics.BlendMode.DST_ATOP.ordinal()] = 11;     // Catch: NoSuchFieldError -> L44
        L111:
            r100[android.graphics.BlendMode.XOR.ordinal()] = 12;     // Catch: NoSuchFieldError -> L45
        L119:
            r100[android.graphics.BlendMode.PLUS.ordinal()] = 13;     // Catch: NoSuchFieldError -> L46
        L63:
            r100[android.graphics.BlendMode.MODULATE.ordinal()] = 14;     // Catch: NoSuchFieldError -> L47
        L69:
            r100[android.graphics.BlendMode.SCREEN.ordinal()] = 15;     // Catch: NoSuchFieldError -> L48
        L89:
            r100[android.graphics.BlendMode.OVERLAY.ordinal()] = 16;     // Catch: NoSuchFieldError -> L49
        L97:
            r100[android.graphics.BlendMode.DARKEN.ordinal()] = 17;     // Catch: NoSuchFieldError -> L50
        L101:
            r100[android.graphics.BlendMode.LIGHTEN.ordinal()] = 18;     // Catch: NoSuchFieldError -> L51
        L109:
            r100[android.graphics.BlendMode.COLOR_DODGE.ordinal()] = 19;     // Catch: NoSuchFieldError -> L52
        L67:
            r100[android.graphics.BlendMode.COLOR_BURN.ordinal()] = 20;     // Catch: NoSuchFieldError -> L53
        L75:
            r100[android.graphics.BlendMode.HARD_LIGHT.ordinal()] = 21;     // Catch: NoSuchFieldError -> L54
        L77:
            r100[android.graphics.BlendMode.SOFT_LIGHT.ordinal()] = 22;     // Catch: NoSuchFieldError -> L55
        L87:
            r100[android.graphics.BlendMode.DIFFERENCE.ordinal()] = 23;     // Catch: NoSuchFieldError -> L56
        L105:
            r100[android.graphics.BlendMode.EXCLUSION.ordinal()] = 24;     // Catch: NoSuchFieldError -> L57
        L113:
            r100[android.graphics.BlendMode.MULTIPLY.ordinal()] = 25;     // Catch: NoSuchFieldError -> L58
        L115:
            r100[android.graphics.BlendMode.HUE.ordinal()] = 26;     // Catch: NoSuchFieldError -> L59
        L65:
            r100[android.graphics.BlendMode.SATURATION.ordinal()] = 27;     // Catch: NoSuchFieldError -> L60
        L79:
            r100[android.graphics.BlendMode.COLOR.ordinal()] = 28;     // Catch: NoSuchFieldError -> L61
        L91:
            r100[android.graphics.BlendMode.LUMINOSITY.ordinal()] = 29;     // Catch: NoSuchFieldError -> L62
        L32:
            $EnumSwitchMapping$0 = r100;
        }
    }

    /* JADX INFO: renamed from: isSupported-s9anfk8, reason: not valid java name */
    public static final boolean m4673isSupporteds9anfk8(int r100) {
        if (Build.VERSION.SDK_INT < 29) goto L5;
    L10:
        return true;
    L5:
        if (BlendMode.m4737equalsimpl0(r100, BlendMode.Companion.m4768getSrcOver0nO6VwU()) == true) goto L10;
        if (m4675toPorterDuffModes9anfk8(r100) != PorterDuff.Mode.SRC_OVER) goto L10;
        return false;
    }

    /* JADX INFO: renamed from: toAndroidBlendMode-s9anfk8, reason: not valid java name */
    public static final android.graphics.BlendMode m4674toAndroidBlendModes9anfk8(int r100) {
        BlendMode.Companion r101 = BlendMode.Companion;
        if (BlendMode.m4737equalsimpl0(r100, r101.m4741getClear0nO6VwU()) == false) goto L6;
        return android.graphics.BlendMode.CLEAR;
    L6:
        if (BlendMode.m4737equalsimpl0(r100, r101.m4764getSrc0nO6VwU()) == false) goto L9;
        return android.graphics.BlendMode.SRC;
    L9:
        if (BlendMode.m4737equalsimpl0(r100, r101.m4747getDst0nO6VwU()) == false) goto L12;
        return android.graphics.BlendMode.DST;
    L12:
        if (BlendMode.m4737equalsimpl0(r100, r101.m4768getSrcOver0nO6VwU()) == false) goto L15;
        return android.graphics.BlendMode.SRC_OVER;
    L15:
        if (BlendMode.m4737equalsimpl0(r100, r101.m4751getDstOver0nO6VwU()) == false) goto L18;
        return android.graphics.BlendMode.DST_OVER;
    L18:
        if (BlendMode.m4737equalsimpl0(r100, r101.m4766getSrcIn0nO6VwU()) == false) goto L21;
        return android.graphics.BlendMode.SRC_IN;
    L21:
        if (BlendMode.m4737equalsimpl0(r100, r101.m4749getDstIn0nO6VwU()) == false) goto L24;
        return android.graphics.BlendMode.DST_IN;
    L24:
        if (BlendMode.m4737equalsimpl0(r100, r101.m4767getSrcOut0nO6VwU()) == false) goto L27;
        return android.graphics.BlendMode.SRC_OUT;
    L27:
        if (BlendMode.m4737equalsimpl0(r100, r101.m4750getDstOut0nO6VwU()) == false) goto L30;
        return android.graphics.BlendMode.DST_OUT;
    L30:
        if (BlendMode.m4737equalsimpl0(r100, r101.m4765getSrcAtop0nO6VwU()) == false) goto L33;
        return android.graphics.BlendMode.SRC_ATOP;
    L33:
        if (BlendMode.m4737equalsimpl0(r100, r101.m4748getDstAtop0nO6VwU()) == false) goto L36;
        return android.graphics.BlendMode.DST_ATOP;
    L36:
        if (BlendMode.m4737equalsimpl0(r100, r101.m4769getXor0nO6VwU()) == false) goto L39;
        return android.graphics.BlendMode.XOR;
    L39:
        if (BlendMode.m4737equalsimpl0(r100, r101.m4760getPlus0nO6VwU()) == false) goto L42;
        return android.graphics.BlendMode.PLUS;
    L42:
        if (BlendMode.m4737equalsimpl0(r100, r101.m4757getModulate0nO6VwU()) == false) goto L45;
        return android.graphics.BlendMode.MODULATE;
    L45:
        if (BlendMode.m4737equalsimpl0(r100, r101.m4762getScreen0nO6VwU()) == false) goto L48;
        return android.graphics.BlendMode.SCREEN;
    L48:
        if (BlendMode.m4737equalsimpl0(r100, r101.m4759getOverlay0nO6VwU()) == false) goto L51;
        return android.graphics.BlendMode.OVERLAY;
    L51:
        if (BlendMode.m4737equalsimpl0(r100, r101.m4745getDarken0nO6VwU()) == false) goto L54;
        return android.graphics.BlendMode.DARKEN;
    L54:
        if (BlendMode.m4737equalsimpl0(r100, r101.m4755getLighten0nO6VwU()) == false) goto L57;
        return android.graphics.BlendMode.LIGHTEN;
    L57:
        if (BlendMode.m4737equalsimpl0(r100, r101.m4744getColorDodge0nO6VwU()) == false) goto L60;
        return android.graphics.BlendMode.COLOR_DODGE;
    L60:
        if (BlendMode.m4737equalsimpl0(r100, r101.m4743getColorBurn0nO6VwU()) == false) goto L63;
        return android.graphics.BlendMode.COLOR_BURN;
    L63:
        if (BlendMode.m4737equalsimpl0(r100, r101.m4753getHardlight0nO6VwU()) == false) goto L66;
        return android.graphics.BlendMode.HARD_LIGHT;
    L66:
        if (BlendMode.m4737equalsimpl0(r100, r101.m4763getSoftlight0nO6VwU()) == false) goto L69;
        return android.graphics.BlendMode.SOFT_LIGHT;
    L69:
        if (BlendMode.m4737equalsimpl0(r100, r101.m4746getDifference0nO6VwU()) == false) goto L72;
        return android.graphics.BlendMode.DIFFERENCE;
    L72:
        if (BlendMode.m4737equalsimpl0(r100, r101.m4752getExclusion0nO6VwU()) == false) goto L75;
        return android.graphics.BlendMode.EXCLUSION;
    L75:
        if (BlendMode.m4737equalsimpl0(r100, r101.m4758getMultiply0nO6VwU()) == false) goto L78;
        return android.graphics.BlendMode.MULTIPLY;
    L78:
        if (BlendMode.m4737equalsimpl0(r100, r101.m4754getHue0nO6VwU()) == false) goto L81;
        return android.graphics.BlendMode.HUE;
    L81:
        if (BlendMode.m4737equalsimpl0(r100, r101.m4761getSaturation0nO6VwU()) == false) goto L84;
        return android.graphics.BlendMode.SATURATION;
    L84:
        if (BlendMode.m4737equalsimpl0(r100, r101.m4742getColor0nO6VwU()) == false) goto L87;
        return android.graphics.BlendMode.COLOR;
    L87:
        if (BlendMode.m4737equalsimpl0(r100, r101.m4756getLuminosity0nO6VwU()) == false) goto L90;
        return android.graphics.BlendMode.LUMINOSITY;
    L90:
        return android.graphics.BlendMode.SRC_OVER;
    }

    public static final int toComposeBlendMode(android.graphics.BlendMode r100) {
        switch(WhenMappings.$EnumSwitchMapping$0[r100.ordinal()]) {
            case 1: goto L35;
            case 2: goto L63;
            case 3: goto L62;
            case 4: goto L61;
            case 5: goto L60;
            case 6: goto L59;
            case 7: goto L58;
            case 8: goto L57;
            case 9: goto L56;
            case 10: goto L55;
            case 11: goto L54;
            case 12: goto L53;
            case 13: goto L52;
            case 14: goto L51;
            case 15: goto L50;
            case 16: goto L49;
            case 17: goto L48;
            case 18: goto L47;
            case 19: goto L46;
            case 20: goto L45;
            case 21: goto L44;
            case 22: goto L43;
            case 23: goto L42;
            case 24: goto L41;
            case 25: goto L40;
            case 26: goto L39;
            case 27: goto L38;
            case 28: goto L37;
            case 29: goto L36;
            default: goto L5;
        };
    L5:
        throw new NoWhenBranchMatchedException();
    L36:
        return BlendMode.Companion.m4756getLuminosity0nO6VwU();
    L37:
        return BlendMode.Companion.m4742getColor0nO6VwU();
    L38:
        return BlendMode.Companion.m4761getSaturation0nO6VwU();
    L39:
        return BlendMode.Companion.m4754getHue0nO6VwU();
    L40:
        return BlendMode.Companion.m4758getMultiply0nO6VwU();
    L41:
        return BlendMode.Companion.m4752getExclusion0nO6VwU();
    L42:
        return BlendMode.Companion.m4746getDifference0nO6VwU();
    L43:
        return BlendMode.Companion.m4763getSoftlight0nO6VwU();
    L44:
        return BlendMode.Companion.m4753getHardlight0nO6VwU();
    L45:
        return BlendMode.Companion.m4743getColorBurn0nO6VwU();
    L46:
        return BlendMode.Companion.m4744getColorDodge0nO6VwU();
    L47:
        return BlendMode.Companion.m4755getLighten0nO6VwU();
    L48:
        return BlendMode.Companion.m4745getDarken0nO6VwU();
    L49:
        return BlendMode.Companion.m4759getOverlay0nO6VwU();
    L50:
        return BlendMode.Companion.m4762getScreen0nO6VwU();
    L51:
        return BlendMode.Companion.m4757getModulate0nO6VwU();
    L52:
        return BlendMode.Companion.m4760getPlus0nO6VwU();
    L53:
        return BlendMode.Companion.m4769getXor0nO6VwU();
    L54:
        return BlendMode.Companion.m4748getDstAtop0nO6VwU();
    L55:
        return BlendMode.Companion.m4765getSrcAtop0nO6VwU();
    L56:
        return BlendMode.Companion.m4750getDstOut0nO6VwU();
    L57:
        return BlendMode.Companion.m4767getSrcOut0nO6VwU();
    L58:
        return BlendMode.Companion.m4749getDstIn0nO6VwU();
    L59:
        return BlendMode.Companion.m4766getSrcIn0nO6VwU();
    L60:
        return BlendMode.Companion.m4751getDstOver0nO6VwU();
    L61:
        return BlendMode.Companion.m4768getSrcOver0nO6VwU();
    L62:
        return BlendMode.Companion.m4747getDst0nO6VwU();
    L63:
        return BlendMode.Companion.m4764getSrc0nO6VwU();
    L35:
        return BlendMode.Companion.m4741getClear0nO6VwU();
    }

    /* JADX INFO: renamed from: toPorterDuffMode-s9anfk8, reason: not valid java name */
    public static final PorterDuff.Mode m4675toPorterDuffModes9anfk8(int r100) {
        BlendMode.Companion r101 = BlendMode.Companion;
        if (BlendMode.m4737equalsimpl0(r100, r101.m4741getClear0nO6VwU()) == false) goto L6;
        return PorterDuff.Mode.CLEAR;
    L6:
        if (BlendMode.m4737equalsimpl0(r100, r101.m4764getSrc0nO6VwU()) == false) goto L9;
        return PorterDuff.Mode.SRC;
    L9:
        if (BlendMode.m4737equalsimpl0(r100, r101.m4747getDst0nO6VwU()) == false) goto L12;
        return PorterDuff.Mode.DST;
    L12:
        if (BlendMode.m4737equalsimpl0(r100, r101.m4768getSrcOver0nO6VwU()) == false) goto L15;
        return PorterDuff.Mode.SRC_OVER;
    L15:
        if (BlendMode.m4737equalsimpl0(r100, r101.m4751getDstOver0nO6VwU()) == false) goto L18;
        return PorterDuff.Mode.DST_OVER;
    L18:
        if (BlendMode.m4737equalsimpl0(r100, r101.m4766getSrcIn0nO6VwU()) == false) goto L21;
        return PorterDuff.Mode.SRC_IN;
    L21:
        if (BlendMode.m4737equalsimpl0(r100, r101.m4749getDstIn0nO6VwU()) == false) goto L24;
        return PorterDuff.Mode.DST_IN;
    L24:
        if (BlendMode.m4737equalsimpl0(r100, r101.m4767getSrcOut0nO6VwU()) == false) goto L27;
        return PorterDuff.Mode.SRC_OUT;
    L27:
        if (BlendMode.m4737equalsimpl0(r100, r101.m4750getDstOut0nO6VwU()) == false) goto L30;
        return PorterDuff.Mode.DST_OUT;
    L30:
        if (BlendMode.m4737equalsimpl0(r100, r101.m4765getSrcAtop0nO6VwU()) == false) goto L33;
        return PorterDuff.Mode.SRC_ATOP;
    L33:
        if (BlendMode.m4737equalsimpl0(r100, r101.m4748getDstAtop0nO6VwU()) == false) goto L36;
        return PorterDuff.Mode.DST_ATOP;
    L36:
        if (BlendMode.m4737equalsimpl0(r100, r101.m4769getXor0nO6VwU()) == false) goto L39;
        return PorterDuff.Mode.XOR;
    L39:
        if (BlendMode.m4737equalsimpl0(r100, r101.m4760getPlus0nO6VwU()) == false) goto L42;
        return PorterDuff.Mode.ADD;
    L42:
        if (BlendMode.m4737equalsimpl0(r100, r101.m4762getScreen0nO6VwU()) == false) goto L45;
        return PorterDuff.Mode.SCREEN;
    L45:
        if (BlendMode.m4737equalsimpl0(r100, r101.m4759getOverlay0nO6VwU()) == false) goto L48;
        return PorterDuff.Mode.OVERLAY;
    L48:
        if (BlendMode.m4737equalsimpl0(r100, r101.m4745getDarken0nO6VwU()) == false) goto L51;
        return PorterDuff.Mode.DARKEN;
    L51:
        if (BlendMode.m4737equalsimpl0(r100, r101.m4755getLighten0nO6VwU()) == false) goto L54;
        return PorterDuff.Mode.LIGHTEN;
    L54:
        if (BlendMode.m4737equalsimpl0(r100, r101.m4757getModulate0nO6VwU()) == false) goto L57;
        return PorterDuff.Mode.MULTIPLY;
    L57:
        return PorterDuff.Mode.SRC_OVER;
    }
}
