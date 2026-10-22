package com.stepos.ailauncher.foundation.appui.card.provider.appauther;

import com.autonavi.aps.amapapi.config.Const;
import com.fasterxml.jackson.core.internal.shaded.fdp.v2_19_2.FastDoubleMath;
import com.google.gson.annotations.SerializedName;
import com.stepos.ailauncher.foundation.appui.card.provider.alipay.AlipayXuiLiveClickReceiver;
import java.util.List;
import kotlin.Metadata;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0012\b\u0080\b\u0018\u00002\u00020\u0001B\u0085\u0001\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0002\u0012\u0010\b\u0002\u0010\r\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000b\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0012\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0015\u001a\u00020\u0014HÖ\u0001¢\u0006\u0004\b\u0015\u0010\u0016J\u001a\u0010\u0019\u001a\u00020\u00182\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0019\u0010\u001aR\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u001b\u001a\u0004\b\u001c\u0010\u0013R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0004\u0010\u001b\u001a\u0004\b\u001d\u0010\u0013R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0006\u0010\u001e\u001a\u0004\b\u001f\u0010 R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u001e\u001a\u0004\b!\u0010 R\u001c\u0010\b\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\u001e\u001a\u0004\b\"\u0010 R\u001c\u0010\t\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\u001e\u001a\u0004\b#\u0010 R\u001c\u0010\n\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\n\u0010\u001b\u001a\u0004\b$\u0010\u0013R\"\u0010\r\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000b8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\r\u0010%\u001a\u0004\b&\u0010'R\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000e\u0010\u001b\u001a\u0004\b(\u0010\u0013R\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000f\u0010\u001b\u001a\u0004\b)\u0010\u0013¨\u0006*"}, d2 = {"Lcom/stepos/ailauncher/foundation/appui/card/provider/appauther/m;", "", "", "type", "integrationId", "Lcom/stepos/ailauncher/foundation/appui/card/provider/appauther/c;", "startApi", "pollApi", "completeApi", "statusApi", Const.JSON_KEY_PROVIDER, "", "Lcom/stepos/ailauncher/foundation/appui/card/provider/appauther/r;", "fields", AlipayXuiLiveClickReceiver.EXTRA_APP_LINK, "webLink", "<init>", "(Ljava/lang/String;Ljava/lang/String;Lcom/stepos/ailauncher/foundation/appui/card/provider/appauther/c;Lcom/stepos/ailauncher/foundation/appui/card/provider/appauther/c;Lcom/stepos/ailauncher/foundation/appui/card/provider/appauther/c;Lcom/stepos/ailauncher/foundation/appui/card/provider/appauther/c;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;)V", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, Const.INTENT_KEY_UMID, "Lcom/stepos/ailauncher/foundation/appui/card/provider/appauther/c;", Const.INTENT_KEY_BACKGROUND_COMMAND, "()Lcom/stepos/ailauncher/foundation/appui/card/provider/appauther/c;", "e", Const.INTENT_KEY_PKGNAME, Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "f", "Ljava/util/List;", "c", "()Ljava/util/List;", Const.INTENT_KEY_APIKEY, Const.INTENT_KEY_BACKGROUND_NOTIFICATION_REMOVE, "foundation_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* renamed from: com.stepos.ailauncher.foundation.appui.card.provider.appauther.m, reason: case insensitive filesystem and from toString */
/* loaded from: classes3.dex */
public final /* data */ class AppAutherClientAction {

    @SerializedName(AlipayXuiLiveClickReceiver.EXTRA_APP_LINK)
    private final String appLink;

    @SerializedName("completeApi")
    private final AppAutherApiSpec completeApi;

    @SerializedName("fields")
    private final List<AppAutherField> fields;

    @SerializedName("integrationId")
    private final String integrationId;

    @SerializedName("pollApi")
    private final AppAutherApiSpec pollApi;

    @SerializedName(Const.JSON_KEY_PROVIDER)
    private final String provider;

    @SerializedName("startApi")
    private final AppAutherApiSpec startApi;

    @SerializedName("statusApi")
    private final AppAutherApiSpec statusApi;

    @SerializedName("type")
    private final String type;

    @SerializedName("webLink")
    private final String webLink;

    public AppAutherClientAction() {
        this(null, null, null, null, null, null, null, null, null, null, FastDoubleMath.DOUBLE_EXPONENT_BIAS, null);
    }

    /* renamed from: a, reason: from getter */
    public final String getAppLink() {
        return this.appLink;
    }

    /* renamed from: b, reason: from getter */
    public final AppAutherApiSpec getCompleteApi() {
        return this.completeApi;
    }

    public final List<AppAutherField> c() {
        return this.fields;
    }

    /* renamed from: d, reason: from getter */
    public final String getIntegrationId() {
        return this.integrationId;
    }

    /* renamed from: e, reason: from getter */
    public final AppAutherApiSpec getPollApi() {
        return this.pollApi;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof AppAutherClientAction)) {
            return false;
        }
        AppAutherClientAction appAutherClientAction = (AppAutherClientAction) other;
        return kotlin.jvm.internal.p.d(this.type, appAutherClientAction.type) && kotlin.jvm.internal.p.d(this.integrationId, appAutherClientAction.integrationId) && kotlin.jvm.internal.p.d(this.startApi, appAutherClientAction.startApi) && kotlin.jvm.internal.p.d(this.pollApi, appAutherClientAction.pollApi) && kotlin.jvm.internal.p.d(this.completeApi, appAutherClientAction.completeApi) && kotlin.jvm.internal.p.d(this.statusApi, appAutherClientAction.statusApi) && kotlin.jvm.internal.p.d(this.provider, appAutherClientAction.provider) && kotlin.jvm.internal.p.d(this.fields, appAutherClientAction.fields) && kotlin.jvm.internal.p.d(this.appLink, appAutherClientAction.appLink) && kotlin.jvm.internal.p.d(this.webLink, appAutherClientAction.webLink);
    }

    /* renamed from: f, reason: from getter */
    public final String getProvider() {
        return this.provider;
    }

    /* renamed from: g, reason: from getter */
    public final AppAutherApiSpec getStartApi() {
        return this.startApi;
    }

    /* renamed from: h, reason: from getter */
    public final AppAutherApiSpec getStatusApi() {
        return this.statusApi;
    }

    public int hashCode() {
        String str = this.type;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.integrationId;
        int iHashCode2 = (iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        AppAutherApiSpec appAutherApiSpec = this.startApi;
        int iHashCode3 = (iHashCode2 + (appAutherApiSpec == null ? 0 : appAutherApiSpec.hashCode())) * 31;
        AppAutherApiSpec appAutherApiSpec2 = this.pollApi;
        int iHashCode4 = (iHashCode3 + (appAutherApiSpec2 == null ? 0 : appAutherApiSpec2.hashCode())) * 31;
        AppAutherApiSpec appAutherApiSpec3 = this.completeApi;
        int iHashCode5 = (iHashCode4 + (appAutherApiSpec3 == null ? 0 : appAutherApiSpec3.hashCode())) * 31;
        AppAutherApiSpec appAutherApiSpec4 = this.statusApi;
        int iHashCode6 = (iHashCode5 + (appAutherApiSpec4 == null ? 0 : appAutherApiSpec4.hashCode())) * 31;
        String str3 = this.provider;
        int iHashCode7 = (iHashCode6 + (str3 == null ? 0 : str3.hashCode())) * 31;
        List<AppAutherField> list = this.fields;
        int iHashCode8 = (iHashCode7 + (list == null ? 0 : list.hashCode())) * 31;
        String str4 = this.appLink;
        int iHashCode9 = (iHashCode8 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.webLink;
        return iHashCode9 + (str5 != null ? str5.hashCode() : 0);
    }

    /* renamed from: i, reason: from getter */
    public final String getType() {
        return this.type;
    }

    /* renamed from: j, reason: from getter */
    public final String getWebLink() {
        return this.webLink;
    }

    public String toString() {
        return "AppAutherClientAction(type=" + this.type + ", integrationId=" + this.integrationId + ", startApi=" + this.startApi + ", pollApi=" + this.pollApi + ", completeApi=" + this.completeApi + ", statusApi=" + this.statusApi + ", provider=" + this.provider + ", fields=" + this.fields + ", appLink=" + this.appLink + ", webLink=" + this.webLink + ")";
    }

    public AppAutherClientAction(String str, String str2, AppAutherApiSpec appAutherApiSpec, AppAutherApiSpec appAutherApiSpec2, AppAutherApiSpec appAutherApiSpec3, AppAutherApiSpec appAutherApiSpec4, String str3, List<AppAutherField> list, String str4, String str5) {
        this.type = str;
        this.integrationId = str2;
        this.startApi = appAutherApiSpec;
        this.pollApi = appAutherApiSpec2;
        this.completeApi = appAutherApiSpec3;
        this.statusApi = appAutherApiSpec4;
        this.provider = str3;
        this.fields = list;
        this.appLink = str4;
        this.webLink = str5;
    }

    public /* synthetic */ AppAutherClientAction(String str, String str2, AppAutherApiSpec appAutherApiSpec, AppAutherApiSpec appAutherApiSpec2, AppAutherApiSpec appAutherApiSpec3, AppAutherApiSpec appAutherApiSpec4, String str3, List list, String str4, String str5, int i10, kotlin.jvm.internal.i iVar) {
        this((i10 & 1) != 0 ? null : str, (i10 & 2) != 0 ? null : str2, (i10 & 4) != 0 ? null : appAutherApiSpec, (i10 & 8) != 0 ? null : appAutherApiSpec2, (i10 & 16) != 0 ? null : appAutherApiSpec3, (i10 & 32) != 0 ? null : appAutherApiSpec4, (i10 & 64) != 0 ? null : str3, (i10 & 128) != 0 ? null : list, (i10 & 256) != 0 ? null : str4, (i10 & 512) != 0 ? null : str5);
    }
}
