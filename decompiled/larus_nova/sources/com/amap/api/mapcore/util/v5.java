package com.amap.api.mapcore.util;

/* JADX INFO: loaded from: classes28.dex */
public class v5 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final u5.e f28191a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f28192b;

    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f28193a = null;

        static {
            u5.e.values();
            int[] r100 = new int[9];
            f28193a = r100;
            r100[1] = 1;     // Catch: NoSuchFieldError -> L13
        L38:
            f28193a[2] = 2;     // Catch: NoSuchFieldError -> L14
        L32:
            f28193a[3] = 3;     // Catch: NoSuchFieldError -> L15
        L26:
            f28193a[4] = 4;     // Catch: NoSuchFieldError -> L16
        L36:
            f28193a[5] = 5;     // Catch: NoSuchFieldError -> L17
        L30:
            f28193a[6] = 6;     // Catch: NoSuchFieldError -> L18
        L24:
            f28193a[7] = 7;     // Catch: NoSuchFieldError -> L19
        L34:
            f28193a[8] = 8;     // Catch: NoSuchFieldError -> L20
        L28:
            f28193a[0] = 9;     // Catch: NoSuchFieldError -> L21
            return;
        }
    }

    public v5(u5.e r100, w5 r101) {
        this.f28191a = r100;
        switch(a.f28193a[r100.ordinal()]) {
            case 1: goto L13;
            case 2: goto L12;
            case 3: goto L11;
            case 4: goto L10;
            case 5: goto L9;
            case 6: goto L8;
            case 7: goto L7;
            case 8: goto L6;
            case 9: goto L5;
            default: goto L4;
        };
    L4:
        String r102 = "";
    L14:
        this.f28192b = r102;
        return;
    L5:
        r102 = String.format("设置隐私政策成功", new Object[0]);
        goto L14
    L6:
        r102 = String.format("***确保调用SDK任何接口前先调用更新隐私合规updatePrivacyShow、updatePrivacyAgree两个接口并且参数值都为true，若未正确设置有崩溃风险***\n参数非法，context 或 sdkInfo为空", new Object[0]);
        goto L14
    L7:
        r102 = String.format("***确保调用SDK任何接口前先调用更新隐私合规updatePrivacyShow、updatePrivacyAgree两个接口并且参数值都为true，若未正确设置有崩溃风险***\n使用%s SDK 功能使用前请确保已经正确设置apiKey，如有疑问请在高德开放平台官网中搜索【INVALID_USER_KEY】相关内容进行解决。", new Object[]{r101.d()});
        goto L14
    L8:
        r102 = String.format("***确保调用SDK任何接口前先调用更新隐私合规updatePrivacyShow、updatePrivacyAgree两个接口并且参数值都为true，若未正确设置有崩溃风险***\n使用%s SDK 功能前请确保隐私权政策已取得用户同意", new Object[]{r101.d()});
        goto L14
    L9:
        r102 = String.format("***确保调用SDK任何接口前先调用更新隐私合规updatePrivacyShow、updatePrivacyAgree两个接口并且参数值都为true，若未正确设置有崩溃风险***\n使用%s SDK 功能前请确保设置隐私权政策是否取得用户同意", new Object[]{r101.d()});
        goto L14
    L10:
        r102 = String.format("***确保调用SDK任何接口前先调用更新隐私合规updatePrivacyShow、updatePrivacyAgree两个接口并且参数值都为true，若未正确设置有崩溃风险***\n使用%s SDK 功能前请确保隐私权政策已经包含高德开平隐私权政策", new Object[]{r101.d()});
        goto L14
    L11:
        r102 = String.format("***确保调用SDK任何接口前先调用更新隐私合规updatePrivacyShow、updatePrivacyAgree两个接口并且参数值都为true，若未正确设置有崩溃风险***\n使用%s SDK 功能前请确保设置隐私权政策是否包含高德开平隐私权政策", new Object[]{r101.d()});
        goto L14
    L12:
        r102 = String.format("***确保调用SDK任何接口前先调用更新隐私合规updatePrivacyShow、updatePrivacyAgree两个接口并且参数值都为true，若未正确设置有崩溃风险***\n使用%s SDK 功能前请确保隐私权政策已弹窗告知用户", new Object[]{r101.d()});
        goto L14
    L13:
        r102 = String.format("***确保调用SDK任何接口前先调用更新隐私合规updatePrivacyShow、updatePrivacyAgree两个接口并且参数值都为true，若未正确设置有崩溃风险***\n使用%s SDK 功能前请设置隐私权政策是否弹窗告知用户", new Object[]{r101.d()});
        goto L14
    }
}
