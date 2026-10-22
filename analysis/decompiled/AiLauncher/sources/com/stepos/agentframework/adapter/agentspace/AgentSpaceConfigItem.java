package com.stepos.agentframework.adapter.agentspace;

import com.autonavi.aps.amapapi.config.Const;
import com.stepos.statsapp.v3.lib.plugin.constants.UxipConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.i;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u000f\b\u0086\b\u0018\u00002\u00020\u0001B[\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\n¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000e\u001a\u00020\u0004HÖ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0010\u001a\u00020\nHÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u001a\u0010\u0014\u001a\u00020\u00132\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0014\u0010\u0015R\u0019\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R\u0019\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0019\u001a\u0004\b\u001a\u0010\u000fR\u0019\u0010\u0006\u001a\u0004\u0018\u00010\u00048\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0019\u001a\u0004\b\u001b\u0010\u000fR\u0019\u0010\u0007\u001a\u0004\u0018\u00010\u00048\u0006¢\u0006\f\n\u0004\b\u0007\u0010\u0019\u001a\u0004\b\u001c\u0010\u000fR\u0019\u0010\b\u001a\u0004\u0018\u00010\u00048\u0006¢\u0006\f\n\u0004\b\b\u0010\u0019\u001a\u0004\b\u001d\u0010\u000fR\u0019\u0010\t\u001a\u0004\u0018\u00010\u00048\u0006¢\u0006\f\n\u0004\b\t\u0010\u0019\u001a\u0004\b\u001e\u0010\u000fR\u0019\u0010\u000b\u001a\u0004\u0018\u00010\n8\u0006¢\u0006\f\n\u0004\b\u000b\u0010\u001f\u001a\u0004\b \u0010!¨\u0006\""}, d2 = {"Lcom/stepos/agentframework/adapter/agentspace/b;", "", "", "id", "", "appId", "type", "key", "name", UxipConstants.f30680s, "", "sort", "<init>", "(Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;)V", "toString", "()Ljava/lang/String;", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/Long;", "getId", "()Ljava/lang/Long;", "Ljava/lang/String;", "getAppId", "getType", Const.INTENT_KEY_APIKEY, "getName", Const.INTENT_KEY_PKGNAME, "Ljava/lang/Integer;", "getSort", "()Ljava/lang/Integer;", "business_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* renamed from: com.stepos.agentframework.adapter.agentspace.b, reason: from toString */
/* loaded from: classes2.dex */
public final /* data */ class AgentSpaceConfigItem {
    private final String appId;
    private final Long id;
    private final String key;
    private final String name;
    private final Integer sort;
    private final String type;
    private final String value;

    public AgentSpaceConfigItem() {
        this(null, null, null, null, null, null, null, 127, null);
    }

    /* renamed from: a, reason: from getter */
    public final String getKey() {
        return this.key;
    }

    /* renamed from: b, reason: from getter */
    public final String getValue() {
        return this.value;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof AgentSpaceConfigItem)) {
            return false;
        }
        AgentSpaceConfigItem agentSpaceConfigItem = (AgentSpaceConfigItem) other;
        return p.d(this.id, agentSpaceConfigItem.id) && p.d(this.appId, agentSpaceConfigItem.appId) && p.d(this.type, agentSpaceConfigItem.type) && p.d(this.key, agentSpaceConfigItem.key) && p.d(this.name, agentSpaceConfigItem.name) && p.d(this.value, agentSpaceConfigItem.value) && p.d(this.sort, agentSpaceConfigItem.sort);
    }

    public int hashCode() {
        Long l10 = this.id;
        int iHashCode = (l10 == null ? 0 : l10.hashCode()) * 31;
        String str = this.appId;
        int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.type;
        int iHashCode3 = (iHashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.key;
        int iHashCode4 = (iHashCode3 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.name;
        int iHashCode5 = (iHashCode4 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.value;
        int iHashCode6 = (iHashCode5 + (str5 == null ? 0 : str5.hashCode())) * 31;
        Integer num = this.sort;
        return iHashCode6 + (num != null ? num.hashCode() : 0);
    }

    public String toString() {
        return "AgentSpaceConfigItem(id=" + this.id + ", appId=" + this.appId + ", type=" + this.type + ", key=" + this.key + ", name=" + this.name + ", value=" + this.value + ", sort=" + this.sort + ")";
    }

    public AgentSpaceConfigItem(Long l10, String str, String str2, String str3, String str4, String str5, Integer num) {
        this.id = l10;
        this.appId = str;
        this.type = str2;
        this.key = str3;
        this.name = str4;
        this.value = str5;
        this.sort = num;
    }

    public /* synthetic */ AgentSpaceConfigItem(Long l10, String str, String str2, String str3, String str4, String str5, Integer num, int i10, i iVar) {
        this((i10 & 1) != 0 ? null : l10, (i10 & 2) != 0 ? null : str, (i10 & 4) != 0 ? null : str2, (i10 & 8) != 0 ? null : str3, (i10 & 16) != 0 ? null : str4, (i10 & 32) != 0 ? null : str5, (i10 & 64) != 0 ? null : num);
    }
}
