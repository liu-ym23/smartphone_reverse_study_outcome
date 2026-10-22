package com.stepos.ailauncher.agent.aispace.skill.wecom.net;

import androidx.exifinterface.media.ExifInterface;
import com.autonavi.aps.amapapi.config.Const;
import com.google.gson.annotations.SerializedName;
import com.stepos.ailauncher.foundation.appui.card.provider.didi.DidiCardProvider;
import kotlin.Metadata;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0013\b\u0080\b\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002J\r\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0007\u001a\u00020\u0006HÖ\u0001¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\n\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u001a\u0010\r\u001a\u00020\u00032\b\u0010\f\u001a\u0004\u0018\u00010\u0002HÖ\u0003¢\u0006\u0004\b\r\u0010\u000eR\u001c\u0010\u000f\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\bR\u001c\u0010\u0016\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0016\u0010\u0014\u001a\u0004\b\u0017\u0010\bR\u001c\u0010\u0018\u001a\u0004\u0018\u00018\u00008\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001b¨\u0006\u001c"}, d2 = {"Lcom/stepos/ailauncher/agent/aispace/skill/wecom/net/a;", ExifInterface.GPS_DIRECTION_TRUE, "", "", Const.INTENT_KEY_PKGNAME, "()Z", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "equals", "(Ljava/lang/Object;)Z", "code", "Ljava/lang/Integer;", "getCode", "()Ljava/lang/Integer;", "msg", "Ljava/lang/String;", "getMsg", DidiCardProvider.KEY_TRACE_ID, "getTraceId", "data", "Ljava/lang/Object;", Const.INTENT_KEY_APIKEY, "()Ljava/lang/Object;", "agent_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* renamed from: com.stepos.ailauncher.agent.aispace.skill.wecom.net.a, reason: from toString */
/* loaded from: classes3.dex */
public final /* data */ class WecomApiResponse<T> {

    @SerializedName("code")
    private final Integer code;

    @SerializedName("data")
    private final T data;

    @SerializedName("msg")
    private final String msg;

    @SerializedName("trace_id")
    private final String traceId;

    public final T a() {
        return this.data;
    }

    public final boolean b() {
        Integer num = this.code;
        return num != null && num.intValue() == 0;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof WecomApiResponse)) {
            return false;
        }
        WecomApiResponse wecomApiResponse = (WecomApiResponse) other;
        return p.d(this.code, wecomApiResponse.code) && p.d(this.msg, wecomApiResponse.msg) && p.d(this.traceId, wecomApiResponse.traceId) && p.d(this.data, wecomApiResponse.data);
    }

    public int hashCode() {
        Integer num = this.code;
        int iHashCode = (num == null ? 0 : num.hashCode()) * 31;
        String str = this.msg;
        int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.traceId;
        int iHashCode3 = (iHashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        T t10 = this.data;
        return iHashCode3 + (t10 != null ? t10.hashCode() : 0);
    }

    public String toString() {
        return "WecomApiResponse(code=" + this.code + ", msg=" + this.msg + ", traceId=" + this.traceId + ", data=" + this.data + ")";
    }
}
