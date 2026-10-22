package com.stepos.ailauncher.chat.model;

import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;
import com.stepos.ailauncher.chat.trace.ChatTracker;
import com.stepos.ailauncher.chat.voice.support.C3081a;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.jvm.internal.i;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u000b\b\u0086\b\u0018\u0000 \u00192\u00020\u0001:\u0001\u0019B)\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0005HÆ\u0003J+\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u0015\u001a\u00020\u000f2\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0011\u0010\u000e\u001a\u00020\u000f8F¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u0010¨\u0006\u001a"}, d2 = {"Lcom/stepos/ailauncher/chat/model/ReInstallVMResult;", "", "code", "", "taskId", "", "msg", "<init>", "(ILjava/lang/String;Ljava/lang/String;)V", "getCode", "()I", "getTaskId", "()Ljava/lang/String;", "getMsg", "isSuccess", "", "()Z", "component1", "component2", "component3", ChatTracker.CLICK_COPY, "equals", "other", "hashCode", "toString", "Companion", "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class ReInstallVMResult {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final int code;

    @SerializedName(alternate = {C3081a.ERROR_MSG}, value = "msg")
    private final String msg;
    private final String taskId;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007¨\u0006\b"}, d2 = {"Lcom/stepos/ailauncher/chat/model/ReInstallVMResult$Companion;", "", "<init>", "()V", "fromJson", "Lcom/stepos/ailauncher/chat/model/ReInstallVMResult;", "json", "", "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(i iVar) {
            this();
        }

        public final ReInstallVMResult fromJson(String json) {
            Object objB;
            p.i(json, "json");
            try {
                Result.Companion companion = Result.INSTANCE;
                objB = Result.b((ReInstallVMResult) new Gson().fromJson(json, ReInstallVMResult.class));
            } catch (Throwable th) {
                Result.Companion companion2 = Result.INSTANCE;
                objB = Result.b(C4849c.a(th));
            }
            if (Result.g(objB)) {
                objB = null;
            }
            ReInstallVMResult reInstallVMResult = (ReInstallVMResult) objB;
            if (reInstallVMResult != null) {
                return reInstallVMResult;
            }
            return new ReInstallVMResult(0, null, null, 7, null);
        }

        private Companion() {
        }
    }

    public ReInstallVMResult() {
        this(0, null, null, 7, null);
    }

    public static /* synthetic */ ReInstallVMResult copy$default(ReInstallVMResult reInstallVMResult, int i10, String str, String str2, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            i10 = reInstallVMResult.code;
        }
        if ((i11 & 2) != 0) {
            str = reInstallVMResult.taskId;
        }
        if ((i11 & 4) != 0) {
            str2 = reInstallVMResult.msg;
        }
        return reInstallVMResult.copy(i10, str, str2);
    }

    /* renamed from: component1, reason: from getter */
    public final int getCode() {
        return this.code;
    }

    /* renamed from: component2, reason: from getter */
    public final String getTaskId() {
        return this.taskId;
    }

    /* renamed from: component3, reason: from getter */
    public final String getMsg() {
        return this.msg;
    }

    public final ReInstallVMResult copy(int code, String taskId, String msg) {
        return new ReInstallVMResult(code, taskId, msg);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ReInstallVMResult)) {
            return false;
        }
        ReInstallVMResult reInstallVMResult = (ReInstallVMResult) other;
        return this.code == reInstallVMResult.code && p.d(this.taskId, reInstallVMResult.taskId) && p.d(this.msg, reInstallVMResult.msg);
    }

    public final int getCode() {
        return this.code;
    }

    public final String getMsg() {
        return this.msg;
    }

    public final String getTaskId() {
        return this.taskId;
    }

    public int hashCode() {
        int iHashCode = Integer.hashCode(this.code) * 31;
        String str = this.taskId;
        int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.msg;
        return iHashCode2 + (str2 != null ? str2.hashCode() : 0);
    }

    public final boolean isSuccess() {
        return this.code == 200;
    }

    public String toString() {
        return "ReInstallVMResult(code=" + this.code + ", taskId=" + this.taskId + ", msg=" + this.msg + ")";
    }

    public ReInstallVMResult(int i10, String str, String str2) {
        this.code = i10;
        this.taskId = str;
        this.msg = str2;
    }

    public /* synthetic */ ReInstallVMResult(int i10, String str, String str2, int i11, i iVar) {
        this((i11 & 1) != 0 ? -1 : i10, (i11 & 2) != 0 ? null : str, (i11 & 4) != 0 ? null : str2);
    }
}
