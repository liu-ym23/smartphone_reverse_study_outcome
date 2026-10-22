package com.stepos.ability.sdk.client;

import com.autonavi.aps.amapapi.config.Const;
import kotlin.Metadata;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u000e\b\u0086\b\u0018\u00002\u00020\u0001BG\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\r\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u0010\u001a\u00020\u000fHÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u001a\u0010\u0014\u001a\u00020\u00132\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0014\u0010\u0015R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u000eR\u0017\u0010\u0004\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0019\u0010\u0017\u001a\u0004\b\u001a\u0010\u000eR\u0019\u0010\u0005\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u001b\u0010\u0017\u001a\u0004\b\u001c\u0010\u000eR\u0019\u0010\u0007\u001a\u0004\u0018\u00010\u00068\u0006¢\u0006\f\n\u0004\b\u0018\u0010\u001d\u001a\u0004\b\u0016\u0010\u001eR\u0019\u0010\b\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u001c\u0010\u0017\u001a\u0004\b\u001b\u0010\u000eR\u0019\u0010\n\u001a\u0004\u0018\u00010\t8\u0006¢\u0006\f\n\u0004\b\u001a\u0010\u001f\u001a\u0004\b\u0019\u0010 ¨\u0006!"}, d2 = {"Lcom/stepos/ability/sdk/client/t;", "", "", "name", "toolcallId", "params", "", "abilityId", "conversionId", "Lcom/stepos/ability/sdk/client/q;", "commonConfig", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/String;Lcom/stepos/ability/sdk/client/q;)V", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", Const.INTENT_KEY_APIKEY, "Ljava/lang/String;", Const.INTENT_KEY_UMID, Const.INTENT_KEY_PKGNAME, "f", "c", "e", "Ljava/lang/Long;", "()Ljava/lang/Long;", "Lcom/stepos/ability/sdk/client/q;", "()Lcom/stepos/ability/sdk/client/q;", "sdk_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes2.dex */
public final /* data */ class t {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final String name;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public final String toolcallId;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    public final String params;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    public final Long abilityId;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    public final String conversionId;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    public final CommonConfig commonConfig;

    public t(String name, String toolcallId, String str, Long l10, String str2, CommonConfig commonConfig) {
        kotlin.jvm.internal.p.i(name, "name");
        kotlin.jvm.internal.p.i(toolcallId, "toolcallId");
        this.name = name;
        this.toolcallId = toolcallId;
        this.params = str;
        this.abilityId = l10;
        this.conversionId = str2;
        this.commonConfig = commonConfig;
    }

    /* renamed from: a, reason: from getter */
    public final Long getAbilityId() {
        return this.abilityId;
    }

    /* renamed from: b, reason: from getter */
    public final CommonConfig getCommonConfig() {
        return this.commonConfig;
    }

    /* renamed from: c, reason: from getter */
    public final String getConversionId() {
        return this.conversionId;
    }

    /* renamed from: d, reason: from getter */
    public final String getName() {
        return this.name;
    }

    /* renamed from: e, reason: from getter */
    public final String getParams() {
        return this.params;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof t)) {
            return false;
        }
        t tVar = (t) other;
        return kotlin.jvm.internal.p.d(this.name, tVar.name) && kotlin.jvm.internal.p.d(this.toolcallId, tVar.toolcallId) && kotlin.jvm.internal.p.d(this.params, tVar.params) && kotlin.jvm.internal.p.d(this.abilityId, tVar.abilityId) && kotlin.jvm.internal.p.d(this.conversionId, tVar.conversionId) && kotlin.jvm.internal.p.d(this.commonConfig, tVar.commonConfig);
    }

    /* renamed from: f, reason: from getter */
    public final String getToolcallId() {
        return this.toolcallId;
    }

    public int hashCode() {
        int iHashCode = ((this.name.hashCode() * 31) + this.toolcallId.hashCode()) * 31;
        String str = this.params;
        int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
        Long l10 = this.abilityId;
        int iHashCode3 = (iHashCode2 + (l10 == null ? 0 : l10.hashCode())) * 31;
        String str2 = this.conversionId;
        int iHashCode4 = (iHashCode3 + (str2 == null ? 0 : str2.hashCode())) * 31;
        CommonConfig commonConfig = this.commonConfig;
        return iHashCode4 + (commonConfig != null ? commonConfig.hashCode() : 0);
    }

    public String toString() {
        String str = this.name;
        String str2 = this.toolcallId;
        boolean z10 = this.abilityId != null;
        String str3 = this.conversionId;
        String str4 = this.params;
        boolean z11 = !(str4 == null || str4.length() == 0);
        CommonConfig commonConfig = this.commonConfig;
        return "ToolTaskConfig(name=" + str + ", toolcallId=" + str2 + ", abilityId=<redacted>, hasAbilityId=" + z10 + ", conversionId=" + str3 + ", params=<redacted>, hasParams=" + z11 + ", hasExtra=" + ((commonConfig != null ? commonConfig.getExtra() : null) != null) + ")";
    }
}
