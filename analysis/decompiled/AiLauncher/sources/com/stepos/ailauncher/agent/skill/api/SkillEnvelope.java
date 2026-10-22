package com.stepos.ailauncher.agent.skill.api;

import androidx.exifinterface.media.ExifInterface;
import com.google.gson.annotations.SerializedName;
import com.stepos.ailauncher.chat.trace.ChatTracker;
import com.stepos.ailauncher.foundation.appui.card.provider.didi.DidiCardProvider;
import com.stepos.ailauncher.network.ApiException;
import kotlin.Metadata;
import kotlin.jvm.internal.i;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\f\b\u0086\b\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B3\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00018\u0000\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\t\u0010\nJ\u0006\u0010\u0013\u001a\u00020\u0014J\u000b\u0010\u0015\u001a\u00028\u0000¢\u0006\u0002\u0010\u0010J\t\u0010\u0016\u001a\u00020\u0004HÆ\u0003J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u0010\u0010\u0018\u001a\u0004\u0018\u00018\u0000HÆ\u0003¢\u0006\u0002\u0010\u0010J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0006HÆ\u0003JB\u0010\u001a\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00018\u00002\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0006HÆ\u0001¢\u0006\u0002\u0010\u001bJ\u0013\u0010\u001c\u001a\u00020\u00142\b\u0010\u001d\u001a\u0004\u0018\u00010\u0002HÖ\u0003J\t\u0010\u001e\u001a\u00020\u0004HÖ\u0001J\t\u0010\u001f\u001a\u00020\u0006HÖ\u0001R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0015\u0010\u0007\u001a\u0004\u0018\u00018\u0000¢\u0006\n\n\u0002\u0010\u0011\u001a\u0004\b\u000f\u0010\u0010R\u0018\u0010\b\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000e¨\u0006 "}, d2 = {"Lcom/stepos/ailauncher/agent/skill/api/SkillEnvelope;", ExifInterface.GPS_DIRECTION_TRUE, "", "code", "", "message", "", "data", DidiCardProvider.KEY_TRACE_ID, "<init>", "(ILjava/lang/String;Ljava/lang/Object;Ljava/lang/String;)V", "getCode", "()I", "getMessage", "()Ljava/lang/String;", "getData", "()Ljava/lang/Object;", "Ljava/lang/Object;", "getTraceId", "isSuccess", "", "getDataOrThrow", "component1", "component2", "component3", "component4", ChatTracker.CLICK_COPY, "(ILjava/lang/String;Ljava/lang/Object;Ljava/lang/String;)Lcom/stepos/ailauncher/agent/skill/api/SkillEnvelope;", "equals", "other", "hashCode", "toString", "agent_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class SkillEnvelope<T> {
    private final int code;
    private final T data;
    private final String message;

    @SerializedName("trace_id")
    private final String traceId;

    public SkillEnvelope(int i10, String str, T t10, String str2) {
        this.code = i10;
        this.message = str;
        this.data = t10;
        this.traceId = str2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ SkillEnvelope copy$default(SkillEnvelope skillEnvelope, int i10, String str, Object obj, String str2, int i11, Object obj2) {
        if ((i11 & 1) != 0) {
            i10 = skillEnvelope.code;
        }
        if ((i11 & 2) != 0) {
            str = skillEnvelope.message;
        }
        if ((i11 & 4) != 0) {
            obj = skillEnvelope.data;
        }
        if ((i11 & 8) != 0) {
            str2 = skillEnvelope.traceId;
        }
        return skillEnvelope.copy(i10, str, obj, str2);
    }

    /* renamed from: component1, reason: from getter */
    public final int getCode() {
        return this.code;
    }

    /* renamed from: component2, reason: from getter */
    public final String getMessage() {
        return this.message;
    }

    public final T component3() {
        return this.data;
    }

    /* renamed from: component4, reason: from getter */
    public final String getTraceId() {
        return this.traceId;
    }

    public final SkillEnvelope<T> copy(int code, String message, T data, String traceId) {
        return new SkillEnvelope<>(code, message, data, traceId);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SkillEnvelope)) {
            return false;
        }
        SkillEnvelope skillEnvelope = (SkillEnvelope) other;
        return this.code == skillEnvelope.code && p.d(this.message, skillEnvelope.message) && p.d(this.data, skillEnvelope.data) && p.d(this.traceId, skillEnvelope.traceId);
    }

    public final int getCode() {
        return this.code;
    }

    public final T getData() {
        return this.data;
    }

    public final T getDataOrThrow() {
        if (isSuccess()) {
            T t10 = this.data;
            if (t10 != null) {
                return t10;
            }
            throw new IllegalStateException("Data is null");
        }
        int i10 = this.code;
        String str = this.message;
        if (str == null) {
            str = "Request failed";
        }
        throw new ApiException(i10, str);
    }

    public final String getMessage() {
        return this.message;
    }

    public final String getTraceId() {
        return this.traceId;
    }

    public int hashCode() {
        int iHashCode = Integer.hashCode(this.code) * 31;
        String str = this.message;
        int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
        T t10 = this.data;
        int iHashCode3 = (iHashCode2 + (t10 == null ? 0 : t10.hashCode())) * 31;
        String str2 = this.traceId;
        return iHashCode3 + (str2 != null ? str2.hashCode() : 0);
    }

    public final boolean isSuccess() {
        int i10 = this.code;
        return i10 == 0 || i10 == 200;
    }

    public String toString() {
        return "SkillEnvelope(code=" + this.code + ", message=" + this.message + ", data=" + this.data + ", traceId=" + this.traceId + ")";
    }

    public /* synthetic */ SkillEnvelope(int i10, String str, Object obj, String str2, int i11, i iVar) {
        this(i10, (i11 & 2) != 0 ? null : str, (i11 & 4) != 0 ? null : obj, (i11 & 8) != 0 ? null : str2);
    }
}
