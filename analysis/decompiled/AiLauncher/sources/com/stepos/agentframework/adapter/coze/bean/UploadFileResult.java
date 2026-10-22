package com.stepos.agentframework.adapter.coze.bean;

import androidx.annotation.Keep;
import com.stepos.aiengine.args.SingleFileBundle;
import com.stepos.ailauncher.chat.trace.ChatTracker;
import com.stepos.ailauncher.taskstore.provider.c;
import kotlin.Metadata;
import kotlin.jvm.internal.p;

@Keep
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u0006\b\u0087\b\u0018\u00002\u00020\u0001:\u0002\u001e\u001fB'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bJ\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0007HÆ\u0003J\t\u0010\u0017\u001a\u00020\tHÆ\u0003J1\u0010\u0018\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\tHÆ\u0001J\u0013\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001c\u001a\u00020\u0003HÖ\u0001J\t\u0010\u001d\u001a\u00020\tHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013¨\u0006 "}, d2 = {"Lcom/stepos/agentframework/adapter/coze/bean/UploadFileResult;", "", "code", "", "data", "Lcom/stepos/agentframework/adapter/coze/bean/UploadFileResult$Data;", "detail", "Lcom/stepos/agentframework/adapter/coze/bean/UploadFileResult$Detail;", "msg", "", "<init>", "(ILcom/stepos/agentframework/adapter/coze/bean/UploadFileResult$Data;Lcom/stepos/agentframework/adapter/coze/bean/UploadFileResult$Detail;Ljava/lang/String;)V", "getCode", "()I", "getData", "()Lcom/stepos/agentframework/adapter/coze/bean/UploadFileResult$Data;", "getDetail", "()Lcom/stepos/agentframework/adapter/coze/bean/UploadFileResult$Detail;", "getMsg", "()Ljava/lang/String;", "component1", "component2", "component3", "component4", ChatTracker.CLICK_COPY, "equals", "", "other", "hashCode", "toString", "Data", "Detail", "protocol_coze_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes2.dex */
public final /* data */ class UploadFileResult {
    private final int code;
    private final Data data;
    private final Detail detail;
    private final String msg;

    @Keep
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0006HÆ\u0003J1\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0019\u001a\u00020\u0006HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0007\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000e¨\u0006\u001a"}, d2 = {"Lcom/stepos/agentframework/adapter/coze/bean/UploadFileResult$Data;", "", SingleFileBundle.KEY_BYTES, "", c.a.COL_CREATED_AT, "file_name", "", "id", "<init>", "(IILjava/lang/String;Ljava/lang/String;)V", "getBytes", "()I", "getCreated_at", "getFile_name", "()Ljava/lang/String;", "getId", "component1", "component2", "component3", "component4", ChatTracker.CLICK_COPY, "equals", "", "other", "hashCode", "toString", "protocol_coze_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class Data {
        private final int bytes;
        private final int created_at;
        private final String file_name;
        private final String id;

        public Data(int i10, int i11, String file_name, String id) {
            p.i(file_name, "file_name");
            p.i(id, "id");
            this.bytes = i10;
            this.created_at = i11;
            this.file_name = file_name;
            this.id = id;
        }

        public static /* synthetic */ Data copy$default(Data data, int i10, int i11, String str, String str2, int i12, Object obj) {
            if ((i12 & 1) != 0) {
                i10 = data.bytes;
            }
            if ((i12 & 2) != 0) {
                i11 = data.created_at;
            }
            if ((i12 & 4) != 0) {
                str = data.file_name;
            }
            if ((i12 & 8) != 0) {
                str2 = data.id;
            }
            return data.copy(i10, i11, str, str2);
        }

        /* renamed from: component1, reason: from getter */
        public final int getBytes() {
            return this.bytes;
        }

        /* renamed from: component2, reason: from getter */
        public final int getCreated_at() {
            return this.created_at;
        }

        /* renamed from: component3, reason: from getter */
        public final String getFile_name() {
            return this.file_name;
        }

        /* renamed from: component4, reason: from getter */
        public final String getId() {
            return this.id;
        }

        public final Data copy(int bytes, int created_at, String file_name, String id) {
            p.i(file_name, "file_name");
            p.i(id, "id");
            return new Data(bytes, created_at, file_name, id);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Data)) {
                return false;
            }
            Data data = (Data) other;
            return this.bytes == data.bytes && this.created_at == data.created_at && p.d(this.file_name, data.file_name) && p.d(this.id, data.id);
        }

        public final int getBytes() {
            return this.bytes;
        }

        public final int getCreated_at() {
            return this.created_at;
        }

        public final String getFile_name() {
            return this.file_name;
        }

        public final String getId() {
            return this.id;
        }

        public int hashCode() {
            return (((((Integer.hashCode(this.bytes) * 31) + Integer.hashCode(this.created_at)) * 31) + this.file_name.hashCode()) * 31) + this.id.hashCode();
        }

        public String toString() {
            return "Data(bytes=" + this.bytes + ", created_at=" + this.created_at + ", file_name=" + this.file_name + ", id=" + this.id + ")";
        }
    }

    @Keep
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0010"}, d2 = {"Lcom/stepos/agentframework/adapter/coze/bean/UploadFileResult$Detail;", "", "logid", "", "<init>", "(Ljava/lang/String;)V", "getLogid", "()Ljava/lang/String;", "component1", ChatTracker.CLICK_COPY, "equals", "", "other", "hashCode", "", "toString", "protocol_coze_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class Detail {
        private final String logid;

        public Detail(String logid) {
            p.i(logid, "logid");
            this.logid = logid;
        }

        public static /* synthetic */ Detail copy$default(Detail detail, String str, int i10, Object obj) {
            if ((i10 & 1) != 0) {
                str = detail.logid;
            }
            return detail.copy(str);
        }

        /* renamed from: component1, reason: from getter */
        public final String getLogid() {
            return this.logid;
        }

        public final Detail copy(String logid) {
            p.i(logid, "logid");
            return new Detail(logid);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof Detail) && p.d(this.logid, ((Detail) other).logid);
        }

        public final String getLogid() {
            return this.logid;
        }

        public int hashCode() {
            return this.logid.hashCode();
        }

        public String toString() {
            return "Detail(logid=" + this.logid + ")";
        }
    }

    public UploadFileResult(int i10, Data data, Detail detail, String msg) {
        p.i(data, "data");
        p.i(detail, "detail");
        p.i(msg, "msg");
        this.code = i10;
        this.data = data;
        this.detail = detail;
        this.msg = msg;
    }

    public static /* synthetic */ UploadFileResult copy$default(UploadFileResult uploadFileResult, int i10, Data data, Detail detail, String str, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            i10 = uploadFileResult.code;
        }
        if ((i11 & 2) != 0) {
            data = uploadFileResult.data;
        }
        if ((i11 & 4) != 0) {
            detail = uploadFileResult.detail;
        }
        if ((i11 & 8) != 0) {
            str = uploadFileResult.msg;
        }
        return uploadFileResult.copy(i10, data, detail, str);
    }

    /* renamed from: component1, reason: from getter */
    public final int getCode() {
        return this.code;
    }

    /* renamed from: component2, reason: from getter */
    public final Data getData() {
        return this.data;
    }

    /* renamed from: component3, reason: from getter */
    public final Detail getDetail() {
        return this.detail;
    }

    /* renamed from: component4, reason: from getter */
    public final String getMsg() {
        return this.msg;
    }

    public final UploadFileResult copy(int code, Data data, Detail detail, String msg) {
        p.i(data, "data");
        p.i(detail, "detail");
        p.i(msg, "msg");
        return new UploadFileResult(code, data, detail, msg);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof UploadFileResult)) {
            return false;
        }
        UploadFileResult uploadFileResult = (UploadFileResult) other;
        return this.code == uploadFileResult.code && p.d(this.data, uploadFileResult.data) && p.d(this.detail, uploadFileResult.detail) && p.d(this.msg, uploadFileResult.msg);
    }

    public final int getCode() {
        return this.code;
    }

    public final Data getData() {
        return this.data;
    }

    public final Detail getDetail() {
        return this.detail;
    }

    public final String getMsg() {
        return this.msg;
    }

    public int hashCode() {
        return (((((Integer.hashCode(this.code) * 31) + this.data.hashCode()) * 31) + this.detail.hashCode()) * 31) + this.msg.hashCode();
    }

    public String toString() {
        return "UploadFileResult(code=" + this.code + ", data=" + this.data + ", detail=" + this.detail + ", msg=" + this.msg + ")";
    }
}
