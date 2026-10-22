package com.baidu.platform.comapi.longlink;

/* loaded from: classes.dex */
public class BNLongLink {

    /* renamed from: a, reason: collision with root package name */
    private static BNLongLinkInitCallBack f8781a;

    public static void initLongLink() {
        BNLongLinkInitCallBack bNLongLinkInitCallBack = f8781a;
        if (bNLongLinkInitCallBack != null) {
            bNLongLinkInitCallBack.onLongLinkInit();
        }
    }

    public static void registerLongLinkInitCallBack(BNLongLinkInitCallBack bNLongLinkInitCallBack) {
        f8781a = bNLongLinkInitCallBack;
    }

    public static void unRegisterLongLinkInitCallBack(BNLongLinkInitCallBack bNLongLinkInitCallBack) {
        f8781a = bNLongLinkInitCallBack;
    }
}
