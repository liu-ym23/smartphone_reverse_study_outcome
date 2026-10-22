package com.stepos.ailauncher.oobe.api;

import com.stepos.ailauncher.chat.trace.ChatTracker;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.i;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001B5\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\b\u0010\tJ\u0006\u0010\u0010\u001a\u00020\u0011J\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0005HÆ\u0003J\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0003HÆ\u0003J7\u0010\u0016\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u0017\u001a\u00020\u00112\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019HÖ\u0003J\t\u0010\u001a\u001a\u00020\u0005HÖ\u0001J\t\u0010\u001b\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000bR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000b¨\u0006\u001c"}, d2 = {"Lcom/stepos/ailauncher/oobe/api/RestoreWorkspaceMdResponse;", "Ljava/io/Serializable;", "trace_id", "", "biz_code", "", "status", "message", "<init>", "(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;)V", "getTrace_id", "()Ljava/lang/String;", "getBiz_code", "()I", "getStatus", "getMessage", "isSuccess", "", "component1", "component2", "component3", "component4", ChatTracker.CLICK_COPY, "equals", "other", "", "hashCode", "toString", "oobe_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class RestoreWorkspaceMdResponse implements Serializable {
    private final int biz_code;
    private final String message;
    private final String status;
    private final String trace_id;

    public RestoreWorkspaceMdResponse() {
        this(null, 0, null, null, 15, null);
    }

    public static /* synthetic */ RestoreWorkspaceMdResponse copy$default(RestoreWorkspaceMdResponse restoreWorkspaceMdResponse, String str, int i10, String str2, String str3, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = restoreWorkspaceMdResponse.trace_id;
        }
        if ((i11 & 2) != 0) {
            i10 = restoreWorkspaceMdResponse.biz_code;
        }
        if ((i11 & 4) != 0) {
            str2 = restoreWorkspaceMdResponse.status;
        }
        if ((i11 & 8) != 0) {
            str3 = restoreWorkspaceMdResponse.message;
        }
        return restoreWorkspaceMdResponse.copy(str, i10, str2, str3);
    }

    /* renamed from: component1, reason: from getter */
    public final String getTrace_id() {
        return this.trace_id;
    }

    /* renamed from: component2, reason: from getter */
    public final int getBiz_code() {
        return this.biz_code;
    }

    /* renamed from: component3, reason: from getter */
    public final String getStatus() {
        return this.status;
    }

    /* renamed from: component4, reason: from getter */
    public final String getMessage() {
        return this.message;
    }

    public final RestoreWorkspaceMdResponse copy(String trace_id, int biz_code, String status, String message) {
        return new RestoreWorkspaceMdResponse(trace_id, biz_code, status, message);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof RestoreWorkspaceMdResponse)) {
            return false;
        }
        RestoreWorkspaceMdResponse restoreWorkspaceMdResponse = (RestoreWorkspaceMdResponse) other;
        return p.d(this.trace_id, restoreWorkspaceMdResponse.trace_id) && this.biz_code == restoreWorkspaceMdResponse.biz_code && p.d(this.status, restoreWorkspaceMdResponse.status) && p.d(this.message, restoreWorkspaceMdResponse.message);
    }

    public final int getBiz_code() {
        return this.biz_code;
    }

    public final String getMessage() {
        return this.message;
    }

    public final String getStatus() {
        return this.status;
    }

    public final String getTrace_id() {
        return this.trace_id;
    }

    public int hashCode() {
        String str = this.trace_id;
        int iHashCode = (((str == null ? 0 : str.hashCode()) * 31) + Integer.hashCode(this.biz_code)) * 31;
        String str2 = this.status;
        int iHashCode2 = (iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.message;
        return iHashCode2 + (str3 != null ? str3.hashCode() : 0);
    }

    public final boolean isSuccess() {
        return this.biz_code == 0;
    }

    public String toString() {
        return "RestoreWorkspaceMdResponse(trace_id=" + this.trace_id + ", biz_code=" + this.biz_code + ", status=" + this.status + ", message=" + this.message + ")";
    }

    public RestoreWorkspaceMdResponse(String str, int i10, String str2, String str3) {
        this.trace_id = str;
        this.biz_code = i10;
        this.status = str2;
        this.message = str3;
    }

    public /* synthetic */ RestoreWorkspaceMdResponse(String str, int i10, String str2, String str3, int i11, i iVar) {
        this((i11 & 1) != 0 ? null : str, (i11 & 2) != 0 ? -1 : i10, (i11 & 4) != 0 ? null : str2, (i11 & 8) != 0 ? null : str3);
    }
}
