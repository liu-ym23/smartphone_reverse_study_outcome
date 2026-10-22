package com.stepos.ailauncher.agent.skill.detail;

import androidx.exifinterface.media.ExifInterface;
import com.autonavi.aps.amapapi.config.Const;
import com.google.gson.annotations.SerializedName;
import com.stepos.ailauncher.foundation.appui.card.provider.didi.DidiCardProvider;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0013\b\u0080\b\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002J\r\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0007\u001a\u00020\u0006HÖ\u0001¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\n\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u001a\u0010\r\u001a\u00020\u00032\b\u0010\f\u001a\u0004\u0018\u00010\u0002HÖ\u0003¢\u0006\u0004\b\r\u0010\u000eR\u001c\u0010\u000f\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\bR\u001c\u0010\u0016\u001a\u0004\u0018\u00018\u00008\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R\u001c\u0010\u001a\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001a\u0010\u0014\u001a\u0004\b\u001b\u0010\b¨\u0006\u001c"}, d2 = {"Lcom/stepos/ailauncher/agent/skill/detail/l0;", ExifInterface.GPS_DIRECTION_TRUE, "", "", "e", "()Z", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "equals", "(Ljava/lang/Object;)Z", "code", "Ljava/lang/Integer;", Const.INTENT_KEY_APIKEY, "()Ljava/lang/Integer;", "msg", "Ljava/lang/String;", "c", "data", "Ljava/lang/Object;", Const.INTENT_KEY_PKGNAME, "()Ljava/lang/Object;", DidiCardProvider.KEY_TRACE_ID, Const.INTENT_KEY_UMID, "agent_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* renamed from: com.stepos.ailauncher.agent.skill.detail.l0, reason: from toString */
/* loaded from: classes3.dex */
public final /* data */ class SkillHubResponse<T> {

    @SerializedName("code")
    private final Integer code;

    @SerializedName("data")
    private final T data;

    @SerializedName("msg")
    private final String msg;

    @SerializedName(DidiCardProvider.KEY_TRACE_ID)
    private final String traceId;

    /* renamed from: a, reason: from getter */
    public final Integer getCode() {
        return this.code;
    }

    public final T b() {
        return this.data;
    }

    /* renamed from: c, reason: from getter */
    public final String getMsg() {
        return this.msg;
    }

    /* renamed from: d, reason: from getter */
    public final String getTraceId() {
        return this.traceId;
    }

    public final boolean e() {
        Integer num = this.code;
        return num != null && num.intValue() == 0;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SkillHubResponse)) {
            return false;
        }
        SkillHubResponse skillHubResponse = (SkillHubResponse) other;
        return kotlin.jvm.internal.p.d(this.code, skillHubResponse.code) && kotlin.jvm.internal.p.d(this.msg, skillHubResponse.msg) && kotlin.jvm.internal.p.d(this.data, skillHubResponse.data) && kotlin.jvm.internal.p.d(this.traceId, skillHubResponse.traceId);
    }

    public int hashCode() {
        Integer num = this.code;
        int iHashCode = (num == null ? 0 : num.hashCode()) * 31;
        String str = this.msg;
        int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
        T t10 = this.data;
        int iHashCode3 = (iHashCode2 + (t10 == null ? 0 : t10.hashCode())) * 31;
        String str2 = this.traceId;
        return iHashCode3 + (str2 != null ? str2.hashCode() : 0);
    }

    public String toString() {
        return "SkillHubResponse(code=" + this.code + ", msg=" + this.msg + ", data=" + this.data + ", traceId=" + this.traceId + ")";
    }
}
