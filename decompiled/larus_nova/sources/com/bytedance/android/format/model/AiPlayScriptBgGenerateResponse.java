package com.bytedance.android.format.model;

import com.google.gson.annotations.SerializedName;
import com.ss.android.socialbase.downloader.constants.DBDefinition;
import java.io.Serializable;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\"\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\t\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR \u0010\n\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, d2 = {"Lcom/bytedance/android/format/model/AiPlayScriptBgGenerateResponse;", "Ljava/io/Serializable;", "()V", "generateStatus", "", "getGenerateStatus", "()Ljava/lang/Integer;", "setGenerateStatus", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", DBDefinition.TASK_ID, "", "getTaskId", "()Ljava/lang/String;", "setTaskId", "(Ljava/lang/String;)V", "format-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class AiPlayScriptBgGenerateResponse implements Serializable {

    @SerializedName("generate_status")
    private Integer generateStatus;

    @SerializedName(DBDefinition.TASK_ID)
    private String taskId;

    public AiPlayScriptBgGenerateResponse() {
    }

    public final Integer getGenerateStatus() {
        return this.generateStatus;
    }

    public final String getTaskId() {
        return this.taskId;
    }

    public final void setGenerateStatus(Integer r100) {
        this.generateStatus = r100;
    }

    public final void setTaskId(String r100) {
        this.taskId = r100;
    }
}
