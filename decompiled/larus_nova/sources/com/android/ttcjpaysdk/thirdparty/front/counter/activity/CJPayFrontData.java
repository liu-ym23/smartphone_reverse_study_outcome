package com.android.ttcjpaysdk.thirdparty.front.counter.activity;

/* JADX INFO: loaded from: classes39.dex */
public class CJPayFrontData {
    public static final String FRONT_NEED_RESULT = "1";
    public static final String FRONT_TYPE_STANDARD = "front_type_standard";
    public static String frontType;
    public static String needResultPage;

    public CJPayFrontData() {
    }

    public static boolean isStandardType() {
        return FRONT_TYPE_STANDARD.equals(frontType);
    }

    public static boolean needResultPage() {
        if (isStandardType() == true) goto L5;
    L7:
        return false;
    L5:
        if ("1".equals(needResultPage) == false) goto L7;
        return true;
    }
}
