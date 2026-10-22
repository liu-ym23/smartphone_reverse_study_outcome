package com.baidu.platform.comapi.longlink;

/* JADX INFO: loaded from: classes39.dex */
public class BNLongLink {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static BNLongLinkInitCallBack f32920a;

    public static void initLongLink() {
        BNLongLinkInitCallBack r100 = f32920a;
        if (r100 == null) goto L6;
        r100.onLongLinkInit();
        return;
    }

    public BNLongLink() {
    }

    public static void registerLongLinkInitCallBack(BNLongLinkInitCallBack r100) {
        f32920a = r100;
    }

    public static void unRegisterLongLinkInitCallBack(BNLongLinkInitCallBack r100) {
        f32920a = r100;
    }
}
