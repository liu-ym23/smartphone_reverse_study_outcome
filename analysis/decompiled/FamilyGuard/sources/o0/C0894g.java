package o0;

import com.stepos.policy.sdk.bean.PolicyBasicListVO;

/* renamed from: o0.g, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C0894g {
    public static String a(int i5) {
        switch (i5) {
            case 1:
                return "error";
            case 2:
                return "int";
            case 3:
                return "float";
            case 4:
                return "string";
            case 5:
                return "iso8601";
            case 6:
                return "true";
            case 7:
                return "false";
            case 8:
                return "null";
            case PolicyBasicListVO.TYPE_ID_LIST_BASCI_SINGLE_LINE_WITH_BUTTON /* 9 */:
                return "new";
            case PolicyBasicListVO.TYPE_ID_LIST_BASCI_SINGLE_LINE_WITH_LINK /* 10 */:
                return "(";
            case PolicyBasicListVO.TYPE_ID_LIST_BASCI_SINGLE_LINE_NEW_MESSAGE_POINT /* 11 */:
                return ")";
            case PolicyBasicListVO.TYPE_ID_LIST_BASCI_SINGLE_LINE_NEW_MESSAGE_NUMBER /* 12 */:
                return "{";
            case PolicyBasicListVO.TYPE_ID_LIST_BASCI_SINGLE_LINE_NEW_MESSAGE_POINT_WITH_ARROW /* 13 */:
                return "}";
            case PolicyBasicListVO.TYPE_ID_LIST_BASCI_SINGLE_LINE_NEW_MESSAGE_NUMBER_WITH_ARROW /* 14 */:
                return "[";
            case 15:
                return "]";
            case 16:
                return ",";
            case 17:
                return ":";
            case PolicyBasicListVO.TYPE_ID_LIST_BASCI_MULTI_LINE /* 18 */:
                return "ident";
            case PolicyBasicListVO.TYPE_ID_LIST_BASCI_MULTI_LINE_LONG /* 19 */:
                return "fieldName";
            case PolicyBasicListVO.TYPE_ID_LIST_ICON_SMALL /* 20 */:
                return "EOF";
            case PolicyBasicListVO.TYPE_ID_LIST_ICON_SMALL_WITH_SUBTITLE /* 21 */:
                return "Set";
            case PolicyBasicListVO.TYPE_ID_LIST_ICON_MIDDLE /* 22 */:
                return "TreeSet";
            case PolicyBasicListVO.TYPE_ID_LIST_ICON_LARGE /* 23 */:
                return "undefined";
            case 24:
                return ";";
            case PolicyBasicListVO.TYPE_ID_LIST_AVATAR /* 25 */:
                return ".";
            case PolicyBasicListVO.TYPE_ID_LIST_AVATAR_WITH_SUBTITLE /* 26 */:
                return "hex";
            default:
                return "Unknown";
        }
    }
}
