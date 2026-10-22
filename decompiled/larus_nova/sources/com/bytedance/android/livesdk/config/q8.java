package com.bytedance.android.livesdk.config;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.bytertc.base.media.screen.RXScreenCaptureService;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b'\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b'\u0010(R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\"\u0010\f\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\f\u0010\u0004\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR\"\u0010\u000f\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010\u0004\u001a\u0004\b\u0010\u0010\u0006\"\u0004\b\u0011\u0010\bR\"\u0010\u0012\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0012\u0010\u0004\u001a\u0004\b\u0013\u0010\u0006\"\u0004\b\u0014\u0010\bR\"\u0010\u0015\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0015\u0010\u0004\u001a\u0004\b\u0016\u0010\u0006\"\u0004\b\u0017\u0010\bR\"\u0010\u0018\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0018\u0010\u0004\u001a\u0004\b\u0019\u0010\u0006\"\u0004\b\u001a\u0010\bR\"\u0010\u001b\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001b\u0010\u0004\u001a\u0004\b\u001c\u0010\u0006\"\u0004\b\u001d\u0010\bR\"\u0010\u001e\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001e\u0010\u0004\u001a\u0004\b\u001f\u0010\u0006\"\u0004\b \u0010\bR\"\u0010!\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b!\u0010\u0004\u001a\u0004\b\"\u0010\u0006\"\u0004\b#\u0010\bR\"\u0010$\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b$\u0010\u0004\u001a\u0004\b%\u0010\u0006\"\u0004\b&\u0010\b¨\u0006)"}, d2 = {"Lcom/bytedance/android/livesdk/config/q8;", "", "", "userAgreementName", "Ljava/lang/String;", com.amap.api.col.s.ce.f26396k, "()Ljava/lang/String;", "setUserAgreementName", "(Ljava/lang/String;)V", "privacyPolicyName", "f", "setPrivacyPolicyName", "confirmButtonText", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "setConfirmButtonText", "linkText", "c", "setLinkText", "dialogContentTemplate", "b", "setDialogContentTemplate", "unicomAgreement", RXScreenCaptureService.KEY_INDEX, "setUnicomAgreement", "mobileAgreement", "d", "setMobileAgreement", "telecomAgreement", com.amap.api.col.s.ce.f26391f, "setTelecomAgreement", "unicomAgreementName", com.amap.api.col.s.ce.f26395j, "setUnicomAgreementName", "mobileAgreementName", "e", "setMobileAgreementName", "telecomAgreementName", "h", "setTelecomAgreementName", "<init>", "()V", "liveutility_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class q8 {

    @SerializedName("confirm_button_text")
    private String confirmButtonText;

    @SerializedName("dialog_content_template")
    private String dialogContentTemplate;

    @SerializedName("link_text")
    private String linkText;

    @SerializedName("mobile_agreement")
    private String mobileAgreement;

    @SerializedName("mobile_agreement_name")
    private String mobileAgreementName;

    @SerializedName("privacy_policy_name")
    private String privacyPolicyName;

    @SerializedName("telecom_agreement")
    private String telecomAgreement;

    @SerializedName("telecom_agreement_name")
    private String telecomAgreementName;

    @SerializedName("unicom_agreement")
    private String unicomAgreement;

    @SerializedName("unicom_agreement_name")
    private String unicomAgreementName;

    @SerializedName("user_agreement_name")
    private String userAgreementName;

    public q8() {
        this.userAgreementName = "用户协议";
        this.privacyPolicyName = "隐私政策";
        this.confirmButtonText = "授权本号码登陆抖音";
        this.linkText = "授权即表示已阅读并同意 用户协议 和 隐私政策，以及{##service_provider_agreement##}";
        this.dialogContentTemplate = "授权说明：\n1、使用本机号码关联抖音账号，或使用本机号码创建抖音账号来使用抖音直播服务。\n2、创建新账号时，将向抖音同步你{##app_name##}账号的头像、昵称";
        this.unicomAgreement = "https://opencloud.wostore.cn/authz/resource/html/disclaimer.html?fromsdk=true";
        this.mobileAgreement = "https://wap.cmpassport.com/resources/html/contract.html";
        this.telecomAgreement = "https://e.189.cn/sdk/agreement/detail.do?hidetop=true";
        this.unicomAgreementName = "《中国联通服务条款》";
        this.mobileAgreementName = "《中国移动服务条款》";
        this.telecomAgreementName = "《中国电信服务条款》";
    }

    public final String a() {
        return this.confirmButtonText;
    }

    public final String b() {
        return this.dialogContentTemplate;
    }

    public final String c() {
        return this.linkText;
    }

    public final String d() {
        return this.mobileAgreement;
    }

    public final String e() {
        return this.mobileAgreementName;
    }

    public final String f() {
        return this.privacyPolicyName;
    }

    public final String g() {
        return this.telecomAgreement;
    }

    public final String h() {
        return this.telecomAgreementName;
    }

    public final String i() {
        return this.unicomAgreement;
    }

    public final String j() {
        return this.unicomAgreementName;
    }

    public final String k() {
        return this.userAgreementName;
    }
}
