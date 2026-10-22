package com.amap.api.col.jmsl;

import com.amap.api.col.jmsl.r5;

/* renamed from: com.amap.api.col.jmsl.b2, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C1537b2 {

    /* renamed from: a, reason: collision with root package name */
    public final r5.e f16534a;

    /* renamed from: b, reason: collision with root package name */
    public final String f16535b;

    /* renamed from: com.amap.api.col.jmsl.b2$a */
    public static /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f16536a;

        static {
            r5.e.values();
            int[] iArr = new int[9];
            f16536a = iArr;
            try {
                iArr[1] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f16536a[2] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f16536a[3] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f16536a[4] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f16536a[5] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f16536a[6] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f16536a[7] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f16536a[8] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f16536a[0] = 9;
            } catch (NoSuchFieldError unused9) {
            }
        }
    }

    public C1537b2(r5.e eVar, C1569j2 c1569j2) {
        String str;
        this.f16534a = eVar;
        switch (a.f16536a[eVar.ordinal()]) {
            case 1:
                str = String.format("***确保调用SDK任何接口前先调用更新隐私合规updatePrivacyShow、updatePrivacyAgree两个接口并且参数值都为true，若未正确设置有崩溃风险***\n使用%s SDK 功能前请设置隐私权政策是否弹窗告知用户", c1569j2.g());
                break;
            case 2:
                str = String.format("***确保调用SDK任何接口前先调用更新隐私合规updatePrivacyShow、updatePrivacyAgree两个接口并且参数值都为true，若未正确设置有崩溃风险***\n使用%s SDK 功能前请确保隐私权政策已弹窗告知用户", c1569j2.g());
                break;
            case 3:
                str = String.format("***确保调用SDK任何接口前先调用更新隐私合规updatePrivacyShow、updatePrivacyAgree两个接口并且参数值都为true，若未正确设置有崩溃风险***\n使用%s SDK 功能前请确保设置隐私权政策是否包含高德开平隐私权政策", c1569j2.g());
                break;
            case 4:
                str = String.format("***确保调用SDK任何接口前先调用更新隐私合规updatePrivacyShow、updatePrivacyAgree两个接口并且参数值都为true，若未正确设置有崩溃风险***\n使用%s SDK 功能前请确保隐私权政策已经包含高德开平隐私权政策", c1569j2.g());
                break;
            case 5:
                str = String.format("***确保调用SDK任何接口前先调用更新隐私合规updatePrivacyShow、updatePrivacyAgree两个接口并且参数值都为true，若未正确设置有崩溃风险***\n使用%s SDK 功能前请确保设置隐私权政策是否取得用户同意", c1569j2.g());
                break;
            case 6:
                str = String.format("***确保调用SDK任何接口前先调用更新隐私合规updatePrivacyShow、updatePrivacyAgree两个接口并且参数值都为true，若未正确设置有崩溃风险***\n使用%s SDK 功能前请确保隐私权政策已取得用户同意", c1569j2.g());
                break;
            case 7:
                str = String.format("***确保调用SDK任何接口前先调用更新隐私合规updatePrivacyShow、updatePrivacyAgree两个接口并且参数值都为true，若未正确设置有崩溃风险***\n使用%s SDK 功能使用前请确保已经正确设置apiKey，如有疑问请在高德开放平台官网中搜索【INVALID_USER_KEY】相关内容进行解决。", c1569j2.g());
                break;
            case 8:
                str = String.format("***确保调用SDK任何接口前先调用更新隐私合规updatePrivacyShow、updatePrivacyAgree两个接口并且参数值都为true，若未正确设置有崩溃风险***\n参数非法，context 或 sdkInfo为空", new Object[0]);
                break;
            case 9:
                str = String.format("设置隐私政策成功", new Object[0]);
                break;
            default:
                str = "";
                break;
        }
        this.f16535b = str;
    }
}
