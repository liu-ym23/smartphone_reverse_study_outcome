package androidx.core.graphics;

import android.graphics.BlendMode;
import androidx.annotation.DoNotInline;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* JADX INFO: loaded from: classes.dex */
public abstract class c {
    @Nullable
    @DoNotInline
    public static Object a(@NonNull BlendModeCompat r10) {
        switch(b.f2542a[r10.ordinal()]) {
            case 1: goto L63;
            case 2: goto L61;
            case 3: goto L59;
            case 4: goto L57;
            case 5: goto L55;
            case 6: goto L53;
            case 7: goto L51;
            case 8: goto L49;
            case 9: goto L47;
            case 10: goto L45;
            case 11: goto L43;
            case 12: goto L41;
            case 13: goto L39;
            case 14: goto L37;
            case 15: goto L35;
            case 16: goto L33;
            case 17: goto L31;
            case 18: goto L29;
            case 19: goto L27;
            case 20: goto L25;
            case 21: goto L23;
            case 22: goto L21;
            case 23: goto L19;
            case 24: goto L17;
            case 25: goto L15;
            case 26: goto L13;
            case 27: goto L11;
            case 28: goto L9;
            case 29: goto L7;
            default: goto L4;
        };
    L4:
        return null;
    L7:
        return BlendMode.LUMINOSITY;
    L9:
        return BlendMode.COLOR;
    L11:
        return BlendMode.SATURATION;
    L13:
        return BlendMode.HUE;
    L15:
        return BlendMode.MULTIPLY;
    L17:
        return BlendMode.EXCLUSION;
    L19:
        return BlendMode.DIFFERENCE;
    L21:
        return BlendMode.SOFT_LIGHT;
    L23:
        return BlendMode.HARD_LIGHT;
    L25:
        return BlendMode.COLOR_BURN;
    L27:
        return BlendMode.COLOR_DODGE;
    L29:
        return BlendMode.LIGHTEN;
    L31:
        return BlendMode.DARKEN;
    L33:
        return BlendMode.OVERLAY;
    L35:
        return BlendMode.SCREEN;
    L37:
        return BlendMode.MODULATE;
    L39:
        return BlendMode.PLUS;
    L41:
        return BlendMode.XOR;
    L43:
        return BlendMode.DST_ATOP;
    L45:
        return BlendMode.SRC_ATOP;
    L47:
        return BlendMode.DST_OUT;
    L49:
        return BlendMode.SRC_OUT;
    L51:
        return BlendMode.DST_IN;
    L53:
        return BlendMode.SRC_IN;
    L55:
        return BlendMode.DST_OVER;
    L57:
        return BlendMode.SRC_OVER;
    L59:
        return BlendMode.DST;
    L61:
        return BlendMode.SRC;
    L63:
        return BlendMode.CLEAR;
    }
}
