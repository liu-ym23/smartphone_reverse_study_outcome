package com.stepos.taskrobot.dictionary.model;

import B7.a;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.e;
import kotlin.jvm.internal.k;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\r\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u000e\u001a\u0004\u0018\u00010\u0003HÆ\u0003J+\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0003HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\t¨\u0006\u0016"}, d2 = {"Lcom/stepos/taskrobot/dictionary/model/LegacyDictionaryRequest;", "", "appId", "", "type", "key", AppAgent.CONSTRUCT, "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getAppId", "()Ljava/lang/String;", "getType", "getKey", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "dictionary_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class LegacyDictionaryRequest {

    @SerializedName("appId")
    private final String appId;

    @SerializedName("key")
    private final String key;

    @SerializedName("type")
    private final String type;

    public LegacyDictionaryRequest(String appId, String str, String str2) {
        k.f(appId, "appId");
        this.appId = appId;
        this.type = str;
        this.key = str2;
    }

    public static /* synthetic */ LegacyDictionaryRequest copy$default(LegacyDictionaryRequest legacyDictionaryRequest, String str, String str2, String str3, int i, Object obj) {
        if ((i & 1) != 0) {
            str = legacyDictionaryRequest.appId;
        }
        if ((i & 2) != 0) {
            str2 = legacyDictionaryRequest.type;
        }
        if ((i & 4) != 0) {
            str3 = legacyDictionaryRequest.key;
        }
        return legacyDictionaryRequest.copy(str, str2, str3);
    }

    /* renamed from: component1, reason: from getter */
    public final String getAppId() {
        return this.appId;
    }

    /* renamed from: component2, reason: from getter */
    public final String getType() {
        return this.type;
    }

    /* renamed from: component3, reason: from getter */
    public final String getKey() {
        return this.key;
    }

    public final LegacyDictionaryRequest copy(String appId, String type, String key) {
        k.f(appId, "appId");
        return new LegacyDictionaryRequest(appId, type, key);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof LegacyDictionaryRequest)) {
            return false;
        }
        LegacyDictionaryRequest legacyDictionaryRequest = (LegacyDictionaryRequest) other;
        return k.b(this.appId, legacyDictionaryRequest.appId) && k.b(this.type, legacyDictionaryRequest.type) && k.b(this.key, legacyDictionaryRequest.key);
    }

    public final String getAppId() {
        return this.appId;
    }

    public final String getKey() {
        return this.key;
    }

    public final String getType() {
        return this.type;
    }

    public int hashCode() {
        int iHashCode = this.appId.hashCode() * 31;
        String str = this.type;
        int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.key;
        return iHashCode2 + (str2 != null ? str2.hashCode() : 0);
    }

    public String toString() {
        String str = this.appId;
        String str2 = this.type;
        return a.q(a.w("LegacyDictionaryRequest(appId=", str, ", type=", str2, ", key="), this.key, ")");
    }

    public /* synthetic */ LegacyDictionaryRequest(String str, String str2, String str3, int i, e eVar) {
        this(str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : str3);
    }
}
