package androidx.core.graphics;

import android.graphics.BlendMode;
import android.graphics.PorterDuff;

/* JADX INFO: compiled from: BlendModeUtils.java */
/* JADX INFO: loaded from: classes.dex */
class d {

    /* JADX INFO: renamed from: androidx.core.graphics.d$1, reason: invalid class name */
    /* JADX INFO: compiled from: BlendModeUtils.java */
    static /* synthetic */ class AnonymousClass1 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f1198a = null;

        static {
            int[] r0 = new int[c.values().length];
            f1198a = r0;
            r0[c.f1193a.ordinal()] = 1;     // Catch: NoSuchFieldError -> L33
        L82:
            f1198a[c.f1194b.ordinal()] = 2;     // Catch: NoSuchFieldError -> L34
        L98:
            f1198a[c.f1195c.ordinal()] = 3;     // Catch: NoSuchFieldError -> L35
        L104:
            f1198a[c.f1196d.ordinal()] = 4;     // Catch: NoSuchFieldError -> L36
        L108:
            f1198a[c.f1197e.ordinal()] = 5;     // Catch: NoSuchFieldError -> L37
        L66:
            f1198a[c.f.ordinal()] = 6;     // Catch: NoSuchFieldError -> L38
        L70:
            f1198a[c.g.ordinal()] = 7;     // Catch: NoSuchFieldError -> L39
        L90:
            f1198a[c.h.ordinal()] = 8;     // Catch: NoSuchFieldError -> L40
        L94:
            f1198a[c.i.ordinal()] = 9;     // Catch: NoSuchFieldError -> L41
        L112:
            f1198a[c.j.ordinal()] = 10;     // Catch: NoSuchFieldError -> L42
        L116:
            f1198a[c.k.ordinal()] = 11;     // Catch: NoSuchFieldError -> L43
        L74:
            f1198a[c.l.ordinal()] = 12;     // Catch: NoSuchFieldError -> L44
        L80:
            f1198a[c.m.ordinal()] = 13;     // Catch: NoSuchFieldError -> L45
        L96:
            f1198a[c.n.ordinal()] = 14;     // Catch: NoSuchFieldError -> L46
        L100:
            f1198a[c.o.ordinal()] = 15;     // Catch: NoSuchFieldError -> L47
        L118:
            f1198a[c.p.ordinal()] = 16;     // Catch: NoSuchFieldError -> L48
        L62:
            f1198a[c.q.ordinal()] = 17;     // Catch: NoSuchFieldError -> L49
        L84:
            f1198a[c.r.ordinal()] = 18;     // Catch: NoSuchFieldError -> L50
        L86:
            f1198a[c.s.ordinal()] = 19;     // Catch: NoSuchFieldError -> L51
        L102:
            f1198a[c.t.ordinal()] = 20;     // Catch: NoSuchFieldError -> L52
        L106:
            f1198a[c.u.ordinal()] = 21;     // Catch: NoSuchFieldError -> L53
        L64:
            f1198a[c.v.ordinal()] = 22;     // Catch: NoSuchFieldError -> L54
        L68:
            f1198a[c.w.ordinal()] = 23;     // Catch: NoSuchFieldError -> L55
        L88:
            f1198a[c.x.ordinal()] = 24;     // Catch: NoSuchFieldError -> L56
        L92:
            f1198a[c.y.ordinal()] = 25;     // Catch: NoSuchFieldError -> L57
        L110:
            f1198a[c.z.ordinal()] = 26;     // Catch: NoSuchFieldError -> L58
        L114:
            f1198a[c.A.ordinal()] = 27;     // Catch: NoSuchFieldError -> L59
        L72:
            f1198a[c.B.ordinal()] = 28;     // Catch: NoSuchFieldError -> L60
        L78:
            f1198a[c.C.ordinal()] = 29;     // Catch: NoSuchFieldError -> L61
            return;
        }
    }

    /* JADX INFO: compiled from: BlendModeUtils.java */
    static class a {
        static Object a(c r1) {
            switch(AnonymousClass1.f1198a[r1.ordinal()]) {
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

    static PorterDuff.Mode a(c r2) {
        if (r2 != null) goto L6;
        return null;
    L6:
        switch(AnonymousClass1.f1198a[r2.ordinal()]) {
            case 1: goto L43;
            case 2: goto L41;
            case 3: goto L39;
            case 4: goto L37;
            case 5: goto L35;
            case 6: goto L33;
            case 7: goto L31;
            case 8: goto L29;
            case 9: goto L27;
            case 10: goto L25;
            case 11: goto L23;
            case 12: goto L21;
            case 13: goto L19;
            case 14: goto L17;
            case 15: goto L15;
            case 16: goto L13;
            case 17: goto L11;
            case 18: goto L9;
            default: goto L7;
        };
    L7:
        return null;
    L9:
        return PorterDuff.Mode.LIGHTEN;
    L11:
        return PorterDuff.Mode.DARKEN;
    L13:
        return PorterDuff.Mode.OVERLAY;
    L15:
        return PorterDuff.Mode.SCREEN;
    L17:
        return PorterDuff.Mode.MULTIPLY;
    L19:
        return PorterDuff.Mode.ADD;
    L21:
        return PorterDuff.Mode.XOR;
    L23:
        return PorterDuff.Mode.DST_ATOP;
    L25:
        return PorterDuff.Mode.SRC_ATOP;
    L27:
        return PorterDuff.Mode.DST_OUT;
    L29:
        return PorterDuff.Mode.SRC_OUT;
    L31:
        return PorterDuff.Mode.DST_IN;
    L33:
        return PorterDuff.Mode.SRC_IN;
    L35:
        return PorterDuff.Mode.DST_OVER;
    L37:
        return PorterDuff.Mode.SRC_OVER;
    L39:
        return PorterDuff.Mode.DST;
    L41:
        return PorterDuff.Mode.SRC;
    L43:
        return PorterDuff.Mode.CLEAR;
    }
}
