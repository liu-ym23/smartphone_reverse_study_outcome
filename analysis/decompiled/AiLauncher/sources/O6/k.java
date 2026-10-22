package O6;

import android.content.res.Resources;
import com.stepos.statsapp.v3.lib.plugin.constants.UxipConstants;

/* loaded from: classes3.dex */
public class k {
    public static final int RES_TYPE_ARRAY = 8;
    public static final int RES_TYPE_ATTR = 4;
    public static final int RES_TYPE_BOOL = 7;
    public static final int RES_TYPE_COLOR = 10;
    public static final int RES_TYPE_DIMEN = 1;
    public static final int RES_TYPE_DRAWABLE = 11;
    public static final int RES_TYPE_ID = 0;
    public static final int RES_TYPE_INTEGER = 9;
    public static final int RES_TYPE_LAYOUT = 5;
    public static final int RES_TYPE_STRING = 2;
    public static final int RES_TYPE_STYLE = 6;
    public static final int RES_TYPE_STYLEABLE = 3;

    public static int a(int i10, String str) {
        Resources system;
        if (str == null || str.isEmpty() || (system = Resources.getSystem()) == null) {
            return -1;
        }
        switch (i10) {
            case 0:
                return s.b(system, str, "id", UxipConstants.f30662a);
            case 1:
                return s.b(system, str, "dimen", UxipConstants.f30662a);
            case 2:
                return s.b(system, str, "string", UxipConstants.f30662a);
            case 3:
                return s.b(system, str, "styleable", UxipConstants.f30662a);
            case 4:
                return s.b(system, str, "attr", UxipConstants.f30662a);
            case 5:
                return s.b(system, str, "layout", UxipConstants.f30662a);
            case 6:
                return s.b(system, str, "style", UxipConstants.f30662a);
            case 7:
                return s.b(system, str, "bool", UxipConstants.f30662a);
            case 8:
                return s.b(system, str, "array", UxipConstants.f30662a);
            case 9:
                return s.b(system, str, "integer", UxipConstants.f30662a);
            case 10:
                return s.b(system, str, "color", UxipConstants.f30662a);
            case 11:
                return s.b(system, str, "drawable", UxipConstants.f30662a);
            default:
                return -1;
        }
    }
}
