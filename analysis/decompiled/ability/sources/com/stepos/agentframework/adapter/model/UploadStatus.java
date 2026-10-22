package com.stepos.agentframework.adapter.model;

import B7.a;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import kotlin.Metadata;
import kotlin.jvm.internal.e;
import kotlin.jvm.internal.k;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0003\u0004\u0005\u0006B\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0003\u0007\b\t¨\u0006\n"}, d2 = {"Lcom/stepos/agentframework/adapter/model/UploadStatus;", "", AppAgent.CONSTRUCT, "()V", "Progress", "Success", "Failed", "Lcom/stepos/agentframework/adapter/model/UploadStatus$Failed;", "Lcom/stepos/agentframework/adapter/model/UploadStatus$Progress;", "Lcom/stepos/agentframework/adapter/model/UploadStatus$Success;", "adapter_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public abstract class UploadStatus {

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0003\n\u0002\b\r\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0005HÆ\u0003J\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0007HÆ\u0003J)\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0019\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u001a"}, d2 = {"Lcom/stepos/agentframework/adapter/model/UploadStatus$Failed;", "Lcom/stepos/agentframework/adapter/model/UploadStatus;", "code", "", "message", "", "cause", "", AppAgent.CONSTRUCT, "(ILjava/lang/String;Ljava/lang/Throwable;)V", "getCode", "()I", "getMessage", "()Ljava/lang/String;", "getCause", "()Ljava/lang/Throwable;", "component1", "component2", "component3", "copy", "equals", "", "other", "", "hashCode", "toString", "adapter_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class Failed extends UploadStatus {
        private final Throwable cause;
        private final int code;
        private final String message;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Failed(int i, String message, Throwable th) {
            super(null);
            k.f(message, "message");
            this.code = i;
            this.message = message;
            this.cause = th;
        }

        public static /* synthetic */ Failed copy$default(Failed failed, int i, String str, Throwable th, int i6, Object obj) {
            if ((i6 & 1) != 0) {
                i = failed.code;
            }
            if ((i6 & 2) != 0) {
                str = failed.message;
            }
            if ((i6 & 4) != 0) {
                th = failed.cause;
            }
            return failed.copy(i, str, th);
        }

        /* renamed from: component1, reason: from getter */
        public final int getCode() {
            return this.code;
        }

        /* renamed from: component2, reason: from getter */
        public final String getMessage() {
            return this.message;
        }

        /* renamed from: component3, reason: from getter */
        public final Throwable getCause() {
            return this.cause;
        }

        public final Failed copy(int code, String message, Throwable cause) {
            k.f(message, "message");
            return new Failed(code, message, cause);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Failed)) {
                return false;
            }
            Failed failed = (Failed) other;
            return this.code == failed.code && k.b(this.message, failed.message) && k.b(this.cause, failed.cause);
        }

        public final Throwable getCause() {
            return this.cause;
        }

        public final int getCode() {
            return this.code;
        }

        public final String getMessage() {
            return this.message;
        }

        public int hashCode() {
            int iC = a.c(Integer.hashCode(this.code) * 31, 31, this.message);
            Throwable th = this.cause;
            return iC + (th == null ? 0 : th.hashCode());
        }

        public String toString() {
            int i = this.code;
            String str = this.message;
            Throwable th = this.cause;
            StringBuilder sbK = androidx.constraintlayout.core.dsl.a.k(i, "Failed(code=", ", message=", str, ", cause=");
            sbK.append(th);
            sbK.append(")");
            return sbK.toString();
        }

        public /* synthetic */ Failed(int i, String str, Throwable th, int i6, e eVar) {
            this(i, str, (i6 & 4) != 0 ? null : th);
        }
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Lcom/stepos/agentframework/adapter/model/UploadStatus$Progress;", "Lcom/stepos/agentframework/adapter/model/UploadStatus;", "percent", "", AppAgent.CONSTRUCT, "(I)V", "getPercent", "()I", "component1", "copy", "equals", "", "other", "", "hashCode", "toString", "", "adapter_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class Progress extends UploadStatus {
        private final int percent;

        public Progress(int i) {
            super(null);
            this.percent = i;
        }

        public static /* synthetic */ Progress copy$default(Progress progress, int i, int i6, Object obj) {
            if ((i6 & 1) != 0) {
                i = progress.percent;
            }
            return progress.copy(i);
        }

        /* renamed from: component1, reason: from getter */
        public final int getPercent() {
            return this.percent;
        }

        public final Progress copy(int percent) {
            return new Progress(percent);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof Progress) && this.percent == ((Progress) other).percent;
        }

        public final int getPercent() {
            return this.percent;
        }

        public int hashCode() {
            return Integer.hashCode(this.percent);
        }

        public String toString() {
            return androidx.appfunctions.metadata.a.i(this.percent, "Progress(percent=", ")");
        }
    }

    public /* synthetic */ UploadStatus(e eVar) {
        this();
    }

    private UploadStatus() {
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u001b\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u000b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u001f\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\u0014"}, d2 = {"Lcom/stepos/agentframework/adapter/model/UploadStatus$Success;", "Lcom/stepos/agentframework/adapter/model/UploadStatus;", "fileId", "", "fileUrl", AppAgent.CONSTRUCT, "(Ljava/lang/String;Ljava/lang/String;)V", "getFileId", "()Ljava/lang/String;", "getFileUrl", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "adapter_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class Success extends UploadStatus {
        private final String fileId;
        private final String fileUrl;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Success(String fileId, String str) {
            super(null);
            k.f(fileId, "fileId");
            this.fileId = fileId;
            this.fileUrl = str;
        }

        public static /* synthetic */ Success copy$default(Success success, String str, String str2, int i, Object obj) {
            if ((i & 1) != 0) {
                str = success.fileId;
            }
            if ((i & 2) != 0) {
                str2 = success.fileUrl;
            }
            return success.copy(str, str2);
        }

        /* renamed from: component1, reason: from getter */
        public final String getFileId() {
            return this.fileId;
        }

        /* renamed from: component2, reason: from getter */
        public final String getFileUrl() {
            return this.fileUrl;
        }

        public final Success copy(String fileId, String fileUrl) {
            k.f(fileId, "fileId");
            return new Success(fileId, fileUrl);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Success)) {
                return false;
            }
            Success success = (Success) other;
            return k.b(this.fileId, success.fileId) && k.b(this.fileUrl, success.fileUrl);
        }

        public final String getFileId() {
            return this.fileId;
        }

        public final String getFileUrl() {
            return this.fileUrl;
        }

        public int hashCode() {
            int iHashCode = this.fileId.hashCode() * 31;
            String str = this.fileUrl;
            return iHashCode + (str == null ? 0 : str.hashCode());
        }

        public String toString() {
            return androidx.appfunctions.metadata.a.m("Success(fileId=", this.fileId, ", fileUrl=", this.fileUrl, ")");
        }

        public /* synthetic */ Success(String str, String str2, int i, e eVar) {
            this(str, (i & 2) != 0 ? null : str2);
        }
    }
}
