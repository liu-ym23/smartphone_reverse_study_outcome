package com.android.ttcjpaysdk.bdpay.security.loading.data;

import com.android.ttcjpaysdk.base.service.ICJPaySecurityLoadingCallback;
import com.android.ttcjpaysdk.base.service.ICJPaySecurityLoadingService;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 \u00192\u00020\u0001:\u0001\u0019B\u0091\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u000f\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0011\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u000f\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0006¢\u0006\u0002\u0010\u0015R\u0014\u0010\b\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\u0004\u0018\u00010\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0014\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u0012\u0010\u0007\u001a\u00020\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0005\u001a\u00020\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0002\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\r\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u000e\u001a\u00020\u000f8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0013\u001a\u00020\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0010\u001a\u0004\u0018\u00010\u00118\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0012\u001a\u00020\u000f8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000¨\u0006\u001a"}, d2 = {"Lcom/android/ttcjpaysdk/bdpay/security/loading/data/CJPaySecurityLoadingBean;", "", "loadingStatus", "", "securityLoadingInfo", "isPwdFreeDegrade", "", "isPayNewCard", "callback", "Lcom/android/ttcjpaysdk/base/service/ICJPaySecurityLoadingService$UpdateCallBack;", "specialCopyWriting", "customScene", "Lcom/android/ttcjpaysdk/base/service/ICJPaySecurityLoadingService$LoadingCustomScene;", "loadingStatusSubText", "localToastIconType", "", "securityLoadingCallback", "Lcom/android/ttcjpaysdk/base/service/ICJPaySecurityLoadingCallback;", "securityLoadingTimeout", "needLayoutCenter", "isFromStd", "(Ljava/lang/String;Ljava/lang/String;ZZLcom/android/ttcjpaysdk/base/service/ICJPaySecurityLoadingService$UpdateCallBack;Ljava/lang/String;Lcom/android/ttcjpaysdk/base/service/ICJPaySecurityLoadingService$LoadingCustomScene;Ljava/lang/String;ILcom/android/ttcjpaysdk/base/service/ICJPaySecurityLoadingCallback;IZZ)V", "()Z", "setFromStd", "(Z)V", "Companion", "bdpay-security-loading_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class CJPaySecurityLoadingBean {
    public static final String CJ_PAY_SECURITY_LOADING_DATA_UPDATE = "security_loading_data_update";
    public static final String CJ_PAY_SECURITY_LOADING_NOPWD_COMBINE = "security_nopwd_combine";
    public static final String CJ_PAY_SECURITY_LOADING_PAY_END = "security_pay_end";
    public static final String CJ_PAY_SECURITY_LOADING_PAY_START_RESTART = "security_pay_start_restart";
    public static final String CJ_PAY_SECURITY_LOADING_PAY_START_REUSE = "security_pay_start_reuse";
    public static final String CJ_PAY_SECURITY_LOADING_PAY_START_REUSE_FOR_TOAST = "security_pay_start_reuse_for_toast";
    public static final String CJ_PAY_SECURITY_LOADING_PAY_START_UPDATE = "security_pay_start_update";
    public static final String CJ_PAY_SECURITY_LOADING_PRE = "security_loading_pre";
    public static final Companion Companion = null;
    public ICJPaySecurityLoadingService.UpdateCallBack callback;
    public ICJPaySecurityLoadingService.LoadingCustomScene customScene;
    private boolean isFromStd;
    public boolean isPayNewCard;
    public boolean isPwdFreeDegrade;
    public String loadingStatus;
    public String loadingStatusSubText;
    public int localToastIconType;
    public boolean needLayoutCenter;
    public ICJPaySecurityLoadingCallback securityLoadingCallback;
    public String securityLoadingInfo;
    public int securityLoadingTimeout;
    public String specialCopyWriting;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/android/ttcjpaysdk/bdpay/security/loading/data/CJPaySecurityLoadingBean$Companion;", "", "()V", "CJ_PAY_SECURITY_LOADING_DATA_UPDATE", "", "CJ_PAY_SECURITY_LOADING_NOPWD_COMBINE", "CJ_PAY_SECURITY_LOADING_PAY_END", "CJ_PAY_SECURITY_LOADING_PAY_START_RESTART", "CJ_PAY_SECURITY_LOADING_PAY_START_REUSE", "CJ_PAY_SECURITY_LOADING_PAY_START_REUSE_FOR_TOAST", "CJ_PAY_SECURITY_LOADING_PAY_START_UPDATE", "CJ_PAY_SECURITY_LOADING_PRE", "bdpay-security-loading_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }
    }

    static {
        Companion = new Companion(null);
    }

    public final boolean isFromStd() {
        return this.isFromStd;
    }

    public final void setFromStd(boolean r100) {
        this.isFromStd = r100;
    }

    public CJPaySecurityLoadingBean(String r100, String r101, boolean r102, boolean r103, ICJPaySecurityLoadingService.UpdateCallBack r104, String r105, ICJPaySecurityLoadingService.LoadingCustomScene r106, String r107, int r110, ICJPaySecurityLoadingCallback r111, int r112, boolean r113, boolean r114) {
        Intrinsics.checkNotNullParameter(r100, "loadingStatus");
        this.loadingStatus = r100;
        this.securityLoadingInfo = r101;
        this.isPwdFreeDegrade = r102;
        this.isPayNewCard = r103;
        this.callback = r104;
        this.specialCopyWriting = r105;
        this.customScene = r106;
        this.loadingStatusSubText = r107;
        this.localToastIconType = r110;
        this.securityLoadingCallback = r111;
        this.securityLoadingTimeout = r112;
        this.needLayoutCenter = r113;
        this.isFromStd = r114;
    }

    public /* synthetic */ CJPaySecurityLoadingBean(String r110, String r111, boolean r112, boolean r113, ICJPaySecurityLoadingService.UpdateCallBack r114, String r115, ICJPaySecurityLoadingService.LoadingCustomScene r210, String r211, int r212, ICJPaySecurityLoadingCallback r213, int r214, boolean r215, boolean r216, int r217, DefaultConstructorMarker r218) {
        ICJPaySecurityLoadingCallback r100 = null;
        if ((r217 & 2) == 0) goto L5;
        String r101 = null;
    L6:
        boolean r102 = false;
        if ((r217 & 4) == 0) goto L9;
        boolean r103 = false;
    L11:
        if ((r217 & 8) == 0) goto L13;
        boolean r104 = false;
    L15:
        if ((r217 & 16) == 0) goto L17;
        ICJPaySecurityLoadingService.UpdateCallBack r105 = null;
    L19:
        if ((r217 & 32) == 0) goto L21;
        String r106 = null;
    L23:
        if ((r217 & 64) == 0) goto L25;
        ICJPaySecurityLoadingService.LoadingCustomScene r107 = null;
    L27:
        if ((r217 & 128) == 0) goto L29;
        String r108 = null;
    L30:
        int r116 = -1;
        if ((r217 & 256) == 0) goto L33;
        int r117 = -1;
    L35:
        if ((r217 & 512) != 0) goto L39;
        r100 = r213;
    L39:
        if ((r217 & 1024) != 0) goto L43;
        r116 = r214;
    L43:
        if ((r217 & 2048) == 0) goto L45;
        boolean r118 = false;
    L47:
        if ((r217 & 4096) != 0) goto L50;
        r102 = r216;
    L50:
        this(r110, r101, r103, r104, r105, r106, r107, r108, r117, r100, r116, r118, r102);
        return;
    L45:
        r118 = r215;
        goto L47
    L33:
        r117 = r212;
        goto L35
    L29:
        r108 = r211;
        goto L30
    L25:
        r107 = r210;
        goto L27
    L21:
        r106 = r115;
        goto L23
    L17:
        r105 = r114;
        goto L19
    L13:
        r104 = r113;
        goto L15
    L9:
        r103 = r112;
        goto L11
    L5:
        r101 = r111;
        goto L6
    }
}
