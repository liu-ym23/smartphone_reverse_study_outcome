package com.stepos.ailauncher.foundation.appui.card.provider.alipay;

import com.autonavi.aps.amapapi.config.Const;
import kotlin.Metadata;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\u0000\n\u0002\b\u0017\b\u0080\b\u0018\u00002\u00020\u0001:\u0002\u0014\u001fB\u0085\u0001\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\r\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\r\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0010¢\u0006\u0004\b\u0012\u0010\u0013J\u008e\u0001\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u00042\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\r2\b\b\u0002\u0010\u0011\u001a\u00020\u0010HÆ\u0001¢\u0006\u0004\b\u0014\u0010\u0015J\u0010\u0010\u0016\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0016\u0010\u0017J\u0010\u0010\u0018\u001a\u00020\u0004HÖ\u0001¢\u0006\u0004\b\u0018\u0010\u0019J\u001a\u0010\u001c\u001a\u00020\u00102\b\u0010\u001b\u001a\u0004\u0018\u00010\u001aHÖ\u0003¢\u0006\u0004\b\u001c\u0010\u001dR\u001a\u0010\u0003\u001a\u00020\u00028\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u001e\u001a\u0004\b\u001f\u0010\u0017R\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010 \u001a\u0004\b!\u0010\u0019R\u0019\u0010\u0006\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u001e\u001a\u0004\b\"\u0010\u0017R\u0019\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0007\u0010\u001e\u001a\u0004\b#\u0010\u0017R\u0019\u0010\t\u001a\u0004\u0018\u00010\b8\u0006¢\u0006\f\n\u0004\b\t\u0010$\u001a\u0004\b%\u0010&R\u0019\u0010\n\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\n\u0010\u001e\u001a\u0004\b'\u0010\u0017R\u0019\u0010\u000b\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u000b\u0010\u001e\u001a\u0004\b(\u0010\u0017R\u0019\u0010\f\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\f\u0010\u001e\u001a\u0004\b)\u0010\u0017R\u0019\u0010\u000e\u001a\u0004\u0018\u00010\r8\u0006¢\u0006\f\n\u0004\b\u000e\u0010*\u001a\u0004\b+\u0010,R\u0019\u0010\u000f\u001a\u0004\u0018\u00010\r8\u0006¢\u0006\f\n\u0004\b\u000f\u0010*\u001a\u0004\b-\u0010,R\u0017\u0010\u0011\u001a\u00020\u00108\u0006¢\u0006\f\n\u0004\b\u0011\u0010.\u001a\u0004\b/\u00100¨\u00061"}, d2 = {"Lcom/stepos/ailauncher/foundation/appui/card/provider/alipay/w;", "LN5/n;", "", "cardId", "", "status", "storeName", "backendInstallState", "Lcom/stepos/ailauncher/foundation/appui/card/provider/alipay/w$b;", "app", "title", "subtitle", "iconUrl", "Lcom/stepos/ailauncher/foundation/appui/card/provider/alipay/w$a;", "primaryAction", "secondaryAction", "", "dimmed", "<init>", "(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Lcom/stepos/ailauncher/foundation/appui/card/provider/alipay/w$b;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/stepos/ailauncher/foundation/appui/card/provider/alipay/w$a;Lcom/stepos/ailauncher/foundation/appui/card/provider/alipay/w$a;Z)V", Const.INTENT_KEY_PKGNAME, "(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Lcom/stepos/ailauncher/foundation/appui/card/provider/alipay/w$b;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/stepos/ailauncher/foundation/appui/card/provider/alipay/w$a;Lcom/stepos/ailauncher/foundation/appui/card/provider/alipay/w$a;Z)Lcom/stepos/ailauncher/foundation/appui/card/provider/alipay/w;", "toString", "()Ljava/lang/String;", "hashCode", "()I", "", "other", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", Const.INTENT_KEY_APIKEY, "I", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, Const.INTENT_KEY_BACKGROUND_NOTIFICATION_REMOVE, "e", "Lcom/stepos/ailauncher/foundation/appui/card/provider/alipay/w$b;", Const.INTENT_KEY_UMID, "()Lcom/stepos/ailauncher/foundation/appui/card/provider/alipay/w$b;", "l", "k", "getIconUrl", "Lcom/stepos/ailauncher/foundation/appui/card/provider/alipay/w$a;", Const.INTENT_KEY_BACKGROUND_COMMAND, "()Lcom/stepos/ailauncher/foundation/appui/card/provider/alipay/w$a;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "Z", "f", "()Z", "foundation_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* renamed from: com.stepos.ailauncher.foundation.appui.card.provider.alipay.w, reason: from toString */
/* loaded from: classes3.dex */
public final /* data */ class AlipayXuiCardModel extends N5.n {
    private final AppItem app;
    private final String backendInstallState;
    private final String cardId;
    private final boolean dimmed;
    private final String iconUrl;
    private final ActionItem primaryAction;
    private final ActionItem secondaryAction;
    private final int status;
    private final String storeName;
    private final String subtitle;
    private final String title;

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u001e\b\u0086\b\u0018\u00002\u00020\u0001Bq\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0002\u0012\b\b\u0001\u0010\u0007\u001a\u00020\u0006\u0012\b\b\u0001\u0010\b\u001a\u00020\u0006\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0002\u0012\b\b\u0002\u0010\u000b\u001a\u00020\n\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0002\u0012\b\b\u0002\u0010\r\u001a\u00020\n\u0012\b\b\u0002\u0010\u000e\u001a\u00020\n¢\u0006\u0004\b\u000f\u0010\u0010J|\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00022\b\b\u0003\u0010\u0007\u001a\u00020\u00062\b\b\u0003\u0010\b\u001a\u00020\u00062\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00022\b\b\u0002\u0010\u000b\u001a\u00020\n2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00022\b\b\u0002\u0010\r\u001a\u00020\n2\b\b\u0002\u0010\u000e\u001a\u00020\nHÆ\u0001¢\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0013\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0015\u001a\u00020\u0006HÖ\u0001¢\u0006\u0004\b\u0015\u0010\u0016J\u001a\u0010\u0018\u001a\u00020\n2\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0018\u0010\u0019R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u001a\u001a\u0004\b\u001b\u0010\u0014R\u0019\u0010\u0004\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u001a\u001a\u0004\b\u001c\u0010\u0014R\u0019\u0010\u0005\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u001a\u001a\u0004\b\u001d\u0010\u0014R\u0017\u0010\u0007\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b\u0007\u0010\u001e\u001a\u0004\b\u001f\u0010\u0016R\u0017\u0010\b\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b\b\u0010\u001e\u001a\u0004\b \u0010\u0016R\u0019\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\t\u0010\u001a\u001a\u0004\b!\u0010\u0014R\u0017\u0010\u000b\u001a\u00020\n8\u0006¢\u0006\f\n\u0004\b\u000b\u0010\"\u001a\u0004\b#\u0010$R\u0019\u0010\f\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\f\u0010\u001a\u001a\u0004\b%\u0010\u0014R\u0017\u0010\r\u001a\u00020\n8\u0006¢\u0006\f\n\u0004\b\r\u0010\"\u001a\u0004\b&\u0010$R\u0017\u0010\u000e\u001a\u00020\n8\u0006¢\u0006\f\n\u0004\b\u000e\u0010\"\u001a\u0004\b'\u0010$¨\u0006("}, d2 = {"Lcom/stepos/ailauncher/foundation/appui/card/provider/alipay/w$a;", "", "", "label", AlipayXuiLiveClickReceiver.EXTRA_APP_LINK, "webLink", "", "backgroundRes", "textColorRes", "launchPackage", "", "showLoading", "intentPackage", "localDim", "armAuthResume", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;ZLjava/lang/String;ZZ)V", Const.INTENT_KEY_APIKEY, "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;ZLjava/lang/String;ZZ)Lcom/stepos/ailauncher/foundation/appui/card/provider/alipay/w$a;", "toString", "()Ljava/lang/String;", "hashCode", "()I", "other", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", Const.INTENT_KEY_BACKGROUND_COMMAND, "c", "l", "I", "e", "k", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "Z", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_REMOVE, "()Z", "f", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, Const.INTENT_KEY_UMID, "foundation_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.ailauncher.foundation.appui.card.provider.alipay.w$a, reason: from toString */
    public static final /* data */ class ActionItem {
        private final String appLink;
        private final boolean armAuthResume;
        private final int backgroundRes;
        private final String intentPackage;
        private final String label;
        private final String launchPackage;
        private final boolean localDim;
        private final boolean showLoading;
        private final int textColorRes;
        private final String webLink;

        public ActionItem(String label, String str, String str2, int i10, int i11, String str3, boolean z10, String str4, boolean z11, boolean z12) {
            kotlin.jvm.internal.p.i(label, "label");
            this.label = label;
            this.appLink = str;
            this.webLink = str2;
            this.backgroundRes = i10;
            this.textColorRes = i11;
            this.launchPackage = str3;
            this.showLoading = z10;
            this.intentPackage = str4;
            this.localDim = z11;
            this.armAuthResume = z12;
        }

        public static /* synthetic */ ActionItem b(ActionItem actionItem, String str, String str2, String str3, int i10, int i11, String str4, boolean z10, String str5, boolean z11, boolean z12, int i12, Object obj) {
            if ((i12 & 1) != 0) {
                str = actionItem.label;
            }
            if ((i12 & 2) != 0) {
                str2 = actionItem.appLink;
            }
            if ((i12 & 4) != 0) {
                str3 = actionItem.webLink;
            }
            if ((i12 & 8) != 0) {
                i10 = actionItem.backgroundRes;
            }
            if ((i12 & 16) != 0) {
                i11 = actionItem.textColorRes;
            }
            if ((i12 & 32) != 0) {
                str4 = actionItem.launchPackage;
            }
            if ((i12 & 64) != 0) {
                z10 = actionItem.showLoading;
            }
            if ((i12 & 128) != 0) {
                str5 = actionItem.intentPackage;
            }
            if ((i12 & 256) != 0) {
                z11 = actionItem.localDim;
            }
            if ((i12 & 512) != 0) {
                z12 = actionItem.armAuthResume;
            }
            boolean z13 = z11;
            boolean z14 = z12;
            boolean z15 = z10;
            String str6 = str5;
            int i13 = i11;
            String str7 = str4;
            return actionItem.a(str, str2, str3, i10, i13, str7, z15, str6, z13, z14);
        }

        public final ActionItem a(String label, String appLink, String webLink, int backgroundRes, int textColorRes, String launchPackage, boolean showLoading, String intentPackage, boolean localDim, boolean armAuthResume) {
            kotlin.jvm.internal.p.i(label, "label");
            return new ActionItem(label, appLink, webLink, backgroundRes, textColorRes, launchPackage, showLoading, intentPackage, localDim, armAuthResume);
        }

        /* renamed from: c, reason: from getter */
        public final String getAppLink() {
            return this.appLink;
        }

        /* renamed from: d, reason: from getter */
        public final boolean getArmAuthResume() {
            return this.armAuthResume;
        }

        /* renamed from: e, reason: from getter */
        public final int getBackgroundRes() {
            return this.backgroundRes;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ActionItem)) {
                return false;
            }
            ActionItem actionItem = (ActionItem) other;
            return kotlin.jvm.internal.p.d(this.label, actionItem.label) && kotlin.jvm.internal.p.d(this.appLink, actionItem.appLink) && kotlin.jvm.internal.p.d(this.webLink, actionItem.webLink) && this.backgroundRes == actionItem.backgroundRes && this.textColorRes == actionItem.textColorRes && kotlin.jvm.internal.p.d(this.launchPackage, actionItem.launchPackage) && this.showLoading == actionItem.showLoading && kotlin.jvm.internal.p.d(this.intentPackage, actionItem.intentPackage) && this.localDim == actionItem.localDim && this.armAuthResume == actionItem.armAuthResume;
        }

        /* renamed from: f, reason: from getter */
        public final String getIntentPackage() {
            return this.intentPackage;
        }

        /* renamed from: g, reason: from getter */
        public final String getLabel() {
            return this.label;
        }

        /* renamed from: h, reason: from getter */
        public final String getLaunchPackage() {
            return this.launchPackage;
        }

        public int hashCode() {
            int iHashCode = this.label.hashCode() * 31;
            String str = this.appLink;
            int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
            String str2 = this.webLink;
            int iHashCode3 = (((((iHashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31) + Integer.hashCode(this.backgroundRes)) * 31) + Integer.hashCode(this.textColorRes)) * 31;
            String str3 = this.launchPackage;
            int iHashCode4 = (((iHashCode3 + (str3 == null ? 0 : str3.hashCode())) * 31) + Boolean.hashCode(this.showLoading)) * 31;
            String str4 = this.intentPackage;
            return ((((iHashCode4 + (str4 != null ? str4.hashCode() : 0)) * 31) + Boolean.hashCode(this.localDim)) * 31) + Boolean.hashCode(this.armAuthResume);
        }

        /* renamed from: i, reason: from getter */
        public final boolean getLocalDim() {
            return this.localDim;
        }

        /* renamed from: j, reason: from getter */
        public final boolean getShowLoading() {
            return this.showLoading;
        }

        /* renamed from: k, reason: from getter */
        public final int getTextColorRes() {
            return this.textColorRes;
        }

        /* renamed from: l, reason: from getter */
        public final String getWebLink() {
            return this.webLink;
        }

        public String toString() {
            return "ActionItem(label=" + this.label + ", appLink=" + this.appLink + ", webLink=" + this.webLink + ", backgroundRes=" + this.backgroundRes + ", textColorRes=" + this.textColorRes + ", launchPackage=" + this.launchPackage + ", showLoading=" + this.showLoading + ", intentPackage=" + this.intentPackage + ", localDim=" + this.localDim + ", armAuthResume=" + this.armAuthResume + ")";
        }
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\b\b\u0086\b\u0018\u00002\u00020\u0001B7\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\t\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\f\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u0010\u001a\u00020\u000f2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0010\u0010\u0011R\u0019\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0012\u001a\u0004\b\u0013\u0010\nR\u0019\u0010\u0004\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0012\u001a\u0004\b\u0014\u0010\nR\u0019\u0010\u0005\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0012\u001a\u0004\b\u0015\u0010\nR\u0019\u0010\u0006\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0012\u001a\u0004\b\u0016\u0010\n¨\u0006\u0017"}, d2 = {"Lcom/stepos/ailauncher/foundation/appui/card/provider/alipay/w$b;", "", "", "name", "iconUrl", "sizeText", "extraText", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "c", Const.INTENT_KEY_PKGNAME, Const.INTENT_KEY_UMID, Const.INTENT_KEY_APIKEY, "foundation_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.ailauncher.foundation.appui.card.provider.alipay.w$b, reason: from toString */
    public static final /* data */ class AppItem {
        private final String extraText;
        private final String iconUrl;
        private final String name;
        private final String sizeText;

        public AppItem() {
            this(null, null, null, null, 15, null);
        }

        /* renamed from: a, reason: from getter */
        public final String getExtraText() {
            return this.extraText;
        }

        /* renamed from: b, reason: from getter */
        public final String getIconUrl() {
            return this.iconUrl;
        }

        /* renamed from: c, reason: from getter */
        public final String getName() {
            return this.name;
        }

        /* renamed from: d, reason: from getter */
        public final String getSizeText() {
            return this.sizeText;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof AppItem)) {
                return false;
            }
            AppItem appItem = (AppItem) other;
            return kotlin.jvm.internal.p.d(this.name, appItem.name) && kotlin.jvm.internal.p.d(this.iconUrl, appItem.iconUrl) && kotlin.jvm.internal.p.d(this.sizeText, appItem.sizeText) && kotlin.jvm.internal.p.d(this.extraText, appItem.extraText);
        }

        public int hashCode() {
            String str = this.name;
            int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
            String str2 = this.iconUrl;
            int iHashCode2 = (iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
            String str3 = this.sizeText;
            int iHashCode3 = (iHashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
            String str4 = this.extraText;
            return iHashCode3 + (str4 != null ? str4.hashCode() : 0);
        }

        public String toString() {
            return "AppItem(name=" + this.name + ", iconUrl=" + this.iconUrl + ", sizeText=" + this.sizeText + ", extraText=" + this.extraText + ")";
        }

        public AppItem(String str, String str2, String str3, String str4) {
            this.name = str;
            this.iconUrl = str2;
            this.sizeText = str3;
            this.extraText = str4;
        }

        public /* synthetic */ AppItem(String str, String str2, String str3, String str4, int i10, kotlin.jvm.internal.i iVar) {
            this((i10 & 1) != 0 ? null : str, (i10 & 2) != 0 ? null : str2, (i10 & 4) != 0 ? null : str3, (i10 & 8) != 0 ? null : str4);
        }
    }

    public AlipayXuiCardModel() {
        this(null, 0, null, null, null, null, null, null, null, null, false, 2047, null);
    }

    public static /* synthetic */ AlipayXuiCardModel c(AlipayXuiCardModel alipayXuiCardModel, String str, int i10, String str2, String str3, AppItem appItem, String str4, String str5, String str6, ActionItem actionItem, ActionItem actionItem2, boolean z10, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = alipayXuiCardModel.cardId;
        }
        if ((i11 & 2) != 0) {
            i10 = alipayXuiCardModel.status;
        }
        if ((i11 & 4) != 0) {
            str2 = alipayXuiCardModel.storeName;
        }
        if ((i11 & 8) != 0) {
            str3 = alipayXuiCardModel.backendInstallState;
        }
        if ((i11 & 16) != 0) {
            appItem = alipayXuiCardModel.app;
        }
        if ((i11 & 32) != 0) {
            str4 = alipayXuiCardModel.title;
        }
        if ((i11 & 64) != 0) {
            str5 = alipayXuiCardModel.subtitle;
        }
        if ((i11 & 128) != 0) {
            str6 = alipayXuiCardModel.iconUrl;
        }
        if ((i11 & 256) != 0) {
            actionItem = alipayXuiCardModel.primaryAction;
        }
        if ((i11 & 512) != 0) {
            actionItem2 = alipayXuiCardModel.secondaryAction;
        }
        if ((i11 & 1024) != 0) {
            z10 = alipayXuiCardModel.dimmed;
        }
        ActionItem actionItem3 = actionItem2;
        boolean z11 = z10;
        String str7 = str6;
        ActionItem actionItem4 = actionItem;
        String str8 = str4;
        String str9 = str5;
        AppItem appItem2 = appItem;
        String str10 = str2;
        return alipayXuiCardModel.b(str, i10, str10, str3, appItem2, str8, str9, str7, actionItem4, actionItem3, z11);
    }

    @Override // N5.n
    /* renamed from: a, reason: from getter */
    public String getCardId() {
        return this.cardId;
    }

    public final AlipayXuiCardModel b(String cardId, int status, String storeName, String backendInstallState, AppItem app, String title, String subtitle, String iconUrl, ActionItem primaryAction, ActionItem secondaryAction, boolean dimmed) {
        kotlin.jvm.internal.p.i(cardId, "cardId");
        return new AlipayXuiCardModel(cardId, status, storeName, backendInstallState, app, title, subtitle, iconUrl, primaryAction, secondaryAction, dimmed);
    }

    /* renamed from: d, reason: from getter */
    public final AppItem getApp() {
        return this.app;
    }

    /* renamed from: e, reason: from getter */
    public final String getBackendInstallState() {
        return this.backendInstallState;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof AlipayXuiCardModel)) {
            return false;
        }
        AlipayXuiCardModel alipayXuiCardModel = (AlipayXuiCardModel) other;
        return kotlin.jvm.internal.p.d(this.cardId, alipayXuiCardModel.cardId) && this.status == alipayXuiCardModel.status && kotlin.jvm.internal.p.d(this.storeName, alipayXuiCardModel.storeName) && kotlin.jvm.internal.p.d(this.backendInstallState, alipayXuiCardModel.backendInstallState) && kotlin.jvm.internal.p.d(this.app, alipayXuiCardModel.app) && kotlin.jvm.internal.p.d(this.title, alipayXuiCardModel.title) && kotlin.jvm.internal.p.d(this.subtitle, alipayXuiCardModel.subtitle) && kotlin.jvm.internal.p.d(this.iconUrl, alipayXuiCardModel.iconUrl) && kotlin.jvm.internal.p.d(this.primaryAction, alipayXuiCardModel.primaryAction) && kotlin.jvm.internal.p.d(this.secondaryAction, alipayXuiCardModel.secondaryAction) && this.dimmed == alipayXuiCardModel.dimmed;
    }

    /* renamed from: f, reason: from getter */
    public final boolean getDimmed() {
        return this.dimmed;
    }

    /* renamed from: g, reason: from getter */
    public final ActionItem getPrimaryAction() {
        return this.primaryAction;
    }

    /* renamed from: h, reason: from getter */
    public final ActionItem getSecondaryAction() {
        return this.secondaryAction;
    }

    public int hashCode() {
        int iHashCode = ((this.cardId.hashCode() * 31) + Integer.hashCode(this.status)) * 31;
        String str = this.storeName;
        int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.backendInstallState;
        int iHashCode3 = (iHashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        AppItem appItem = this.app;
        int iHashCode4 = (iHashCode3 + (appItem == null ? 0 : appItem.hashCode())) * 31;
        String str3 = this.title;
        int iHashCode5 = (iHashCode4 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.subtitle;
        int iHashCode6 = (iHashCode5 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.iconUrl;
        int iHashCode7 = (iHashCode6 + (str5 == null ? 0 : str5.hashCode())) * 31;
        ActionItem actionItem = this.primaryAction;
        int iHashCode8 = (iHashCode7 + (actionItem == null ? 0 : actionItem.hashCode())) * 31;
        ActionItem actionItem2 = this.secondaryAction;
        return ((iHashCode8 + (actionItem2 != null ? actionItem2.hashCode() : 0)) * 31) + Boolean.hashCode(this.dimmed);
    }

    /* renamed from: i, reason: from getter */
    public final int getStatus() {
        return this.status;
    }

    /* renamed from: j, reason: from getter */
    public final String getStoreName() {
        return this.storeName;
    }

    /* renamed from: k, reason: from getter */
    public final String getSubtitle() {
        return this.subtitle;
    }

    /* renamed from: l, reason: from getter */
    public final String getTitle() {
        return this.title;
    }

    public String toString() {
        return "AlipayXuiCardModel(cardId=" + this.cardId + ", status=" + this.status + ", storeName=" + this.storeName + ", backendInstallState=" + this.backendInstallState + ", app=" + this.app + ", title=" + this.title + ", subtitle=" + this.subtitle + ", iconUrl=" + this.iconUrl + ", primaryAction=" + this.primaryAction + ", secondaryAction=" + this.secondaryAction + ", dimmed=" + this.dimmed + ")";
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AlipayXuiCardModel(String cardId, int i10, String str, String str2, AppItem appItem, String str3, String str4, String str5, ActionItem actionItem, ActionItem actionItem2, boolean z10) {
        super(cardId);
        kotlin.jvm.internal.p.i(cardId, "cardId");
        this.cardId = cardId;
        this.status = i10;
        this.storeName = str;
        this.backendInstallState = str2;
        this.app = appItem;
        this.title = str3;
        this.subtitle = str4;
        this.iconUrl = str5;
        this.primaryAction = actionItem;
        this.secondaryAction = actionItem2;
        this.dimmed = z10;
    }

    public /* synthetic */ AlipayXuiCardModel(String str, int i10, String str2, String str3, AppItem appItem, String str4, String str5, String str6, ActionItem actionItem, ActionItem actionItem2, boolean z10, int i11, kotlin.jvm.internal.i iVar) {
        this((i11 & 1) != 0 ? "" : str, (i11 & 2) != 0 ? 6 : i10, (i11 & 4) != 0 ? null : str2, (i11 & 8) != 0 ? null : str3, (i11 & 16) != 0 ? null : appItem, (i11 & 32) != 0 ? null : str4, (i11 & 64) != 0 ? null : str5, (i11 & 128) != 0 ? null : str6, (i11 & 256) != 0 ? null : actionItem, (i11 & 512) != 0 ? null : actionItem2, (i11 & 1024) != 0 ? false : z10);
    }
}
