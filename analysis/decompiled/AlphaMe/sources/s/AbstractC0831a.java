package s;

import android.view.View;
import java.util.HashMap;

/* renamed from: s.a, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract /* synthetic */ class AbstractC0831a {
    public static /* synthetic */ int a(int i4) {
        switch (i4) {
            case 1:
                return 6406;
            case 2:
                return 6410;
            case 3:
            case 4:
            case 5:
                return 6407;
            case 6:
                return 6408;
            default:
                throw null;
        }
    }

    public static /* synthetic */ int b(int i4) {
        switch (i4) {
            case 1:
            case 2:
                return 5121;
            case 3:
                return 33635;
            case 4:
                return 32819;
            case 5:
            case 6:
                return 5121;
            default:
                throw null;
        }
    }

    public static float c(float f4, float f5, float f6, float f7) {
        return ((f4 - f5) * f6) + f7;
    }

    public static String d(StringBuilder sb, int i4, String str) {
        sb.append(i4);
        sb.append(str);
        return sb.toString();
    }

    public static StringBuilder e(String str, long j4, String str2) {
        StringBuilder sb = new StringBuilder(str);
        sb.append(j4);
        sb.append(str2);
        return sb;
    }

    public static void f(int i4, String str, HashMap map, String str2) {
        map.put(str2, new stepos.support.v7.permission.a(i4, str));
    }

    public static /* synthetic */ void g(View view) {
        if (view != null) {
            throw new ClassCastException();
        }
    }

    public static void h(StringBuilder sb, String str, String str2, String str3) {
        sb.append(str);
        sb.append(str2);
        sb.append(str3);
    }

    public static /* synthetic */ String i(int i4) {
        switch (i4) {
            case 1:
                return "NONE";
            case 2:
                return "LEFT";
            case 3:
                return "TOP";
            case 4:
                return "RIGHT";
            case 5:
                return "BOTTOM";
            case 6:
                return "BASELINE";
            case 7:
                return "CENTER";
            case 8:
                return "CENTER_X";
            case 9:
                return "CENTER_Y";
            default:
                throw null;
        }
    }

    public static /* synthetic */ String j(int i4) {
        switch (i4) {
            case 1:
                return "Alpha";
            case 2:
                return "LuminanceAlpha";
            case 3:
                return "RGB565";
            case 4:
                return "RGBA4444";
            case 5:
                return "RGB888";
            case 6:
                return "RGBA8888";
            default:
                return "null";
        }
    }

    public static /* synthetic */ String k(int i4) {
        switch (i4) {
            case 1:
                return "UNKNOWN";
            case 2:
                return "HORIZONTAL_DIMENSION";
            case 3:
                return "VERTICAL_DIMENSION";
            case 4:
                return "LEFT";
            case 5:
                return "RIGHT";
            case 6:
                return "TOP";
            case 7:
                return "BOTTOM";
            case 8:
                return "BASELINE";
            default:
                return "null";
        }
    }
}
