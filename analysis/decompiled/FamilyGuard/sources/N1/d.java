package N1;

import android.content.res.Resources;
import com.stepos.minor.Minor;
import com.stepos.policy.sdk.bean.PolicyBasicListVO;

/* loaded from: classes.dex */
public class d {
    public static int a(int i5, String str) {
        Resources system;
        if (str == null || str.isEmpty() || (system = Resources.getSystem()) == null) {
            return -1;
        }
        switch (i5) {
            case 0:
                return i.c(system, str, Minor.COLUMN_ID, "android");
            case 1:
                return i.c(system, str, "dimen", "android");
            case 2:
                return i.c(system, str, "string", "android");
            case 3:
                return i.c(system, str, "styleable", "android");
            case 4:
                return i.c(system, str, "attr", "android");
            case 5:
                return i.c(system, str, "layout", "android");
            case 6:
                return i.c(system, str, "style", "android");
            case 7:
                return i.c(system, str, "bool", "android");
            case 8:
                return i.c(system, str, "array", "android");
            case PolicyBasicListVO.TYPE_ID_LIST_BASCI_SINGLE_LINE_WITH_BUTTON /* 9 */:
                return i.c(system, str, "integer", "android");
            case PolicyBasicListVO.TYPE_ID_LIST_BASCI_SINGLE_LINE_WITH_LINK /* 10 */:
                return i.c(system, str, "color", "android");
            case PolicyBasicListVO.TYPE_ID_LIST_BASCI_SINGLE_LINE_NEW_MESSAGE_POINT /* 11 */:
                return i.c(system, str, "drawable", "android");
            default:
                return -1;
        }
    }
}
