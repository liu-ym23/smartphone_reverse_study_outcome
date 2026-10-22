package com.stepos.ailauncher.chat.api;

import com.stepos.ailauncher.chat.trace.ChatTracker;
import kotlin.Metadata;
import kotlin.jvm.internal.i;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B)\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0005HÆ\u0003J+\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\f¨\u0006\u0017"}, d2 = {"Lcom/stepos/ailauncher/chat/api/UserSwitchResponse;", "", "code", "", "msg", "", "trace_id", "<init>", "(ILjava/lang/String;Ljava/lang/String;)V", "getCode", "()I", "getMsg", "()Ljava/lang/String;", "getTrace_id", "component1", "component2", "component3", ChatTracker.CLICK_COPY, "equals", "", "other", "hashCode", "toString", "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class UserSwitchResponse {
    private final int code;
    private final String msg;
    private final String trace_id;

    public UserSwitchResponse() {
        this(0, null, null, 7, null);
    }

    public static /* synthetic */ UserSwitchResponse copy$default(UserSwitchResponse userSwitchResponse, int i10, String str, String str2, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            i10 = userSwitchResponse.code;
        }
        if ((i11 & 2) != 0) {
            str = userSwitchResponse.msg;
        }
        if ((i11 & 4) != 0) {
            str2 = userSwitchResponse.trace_id;
        }
        return userSwitchResponse.copy(i10, str, str2);
    }

    /* renamed from: component1, reason: from getter */
    public final int getCode() {
        return this.code;
    }

    /* renamed from: component2, reason: from getter */
    public final String getMsg() {
        return this.msg;
    }

    /* renamed from: component3, reason: from getter */
    public final String getTrace_id() {
        return this.trace_id;
    }

    public final UserSwitchResponse copy(int code, String msg, String trace_id) {
        return new UserSwitchResponse(code, msg, trace_id);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof UserSwitchResponse)) {
            return false;
        }
        UserSwitchResponse userSwitchResponse = (UserSwitchResponse) other;
        return this.code == userSwitchResponse.code && p.d(this.msg, userSwitchResponse.msg) && p.d(this.trace_id, userSwitchResponse.trace_id);
    }

    public final int getCode() {
        return this.code;
    }

    public final String getMsg() {
        return this.msg;
    }

    public final String getTrace_id() {
        return this.trace_id;
    }

    public int hashCode() {
        int iHashCode = Integer.hashCode(this.code) * 31;
        String str = this.msg;
        int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.trace_id;
        return iHashCode2 + (str2 != null ? str2.hashCode() : 0);
    }

    public String toString() {
        return "UserSwitchResponse(code=" + this.code + ", msg=" + this.msg + ", trace_id=" + this.trace_id + ")";
    }

    public UserSwitchResponse(int i10, String str, String str2) {
        this.code = i10;
        this.msg = str;
        this.trace_id = str2;
    }

    public /* synthetic */ UserSwitchResponse(int i10, String str, String str2, int i11, i iVar) {
        this((i11 & 1) != 0 ? -1 : i10, (i11 & 2) != 0 ? null : str, (i11 & 4) != 0 ? null : str2);
    }
}
