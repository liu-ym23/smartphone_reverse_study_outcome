package com.bytedance.android.format.model;

import com.google.gson.annotations.SerializedName;
import com.larus.avlink.aiproactive.AiProactiveTaskViewModel;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R \u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR \u0010\t\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\u001e\u0010\f\u001a\u00020\r8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\u000e\"\u0004\b\u000f\u0010\u0010R \u0010\u0011\u001a\u0004\u0018\u00010\u00128\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001e\u0010\u0017\u001a\u00020\u00188\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR \u0010\u001d\u001a\u0004\u0018\u00010\u001e8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"¨\u0006#"}, d2 = {"Lcom/bytedance/android/format/model/AiPlayGenerateRequest;", "", "()V", "avatarCid", "", "getAvatarCid", "()Ljava/lang/String;", "setAvatarCid", "(Ljava/lang/String;)V", "avatarUid", "getAvatarUid", "setAvatarUid", "isEdit", "", "()Z", "setEdit", "(Z)V", "scriptData", "Lcom/bytedance/android/format/model/PlayGenerateScriptData;", "getScriptData", "()Lcom/bytedance/android/format/model/PlayGenerateScriptData;", "setScriptData", "(Lcom/bytedance/android/format/model/PlayGenerateScriptData;)V", "taskType", "", "getTaskType", "()I", "setTaskType", "(I)V", "topicData", "Lcom/bytedance/android/format/model/PlayGenerateTopicData;", "getTopicData", "()Lcom/bytedance/android/format/model/PlayGenerateTopicData;", "setTopicData", "(Lcom/bytedance/android/format/model/PlayGenerateTopicData;)V", "format-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class AiPlayGenerateRequest {

    @SerializedName("avatar_cid")
    private String avatarCid;

    @SerializedName("avatar_uid")
    private String avatarUid;

    @SerializedName("is_edit")
    private boolean isEdit;

    @SerializedName("script_data")
    private PlayGenerateScriptData scriptData;

    @SerializedName(AiProactiveTaskViewModel.PARAM_TASK_TYPE)
    private int taskType;

    @SerializedName("topic_data")
    private PlayGenerateTopicData topicData;

    public AiPlayGenerateRequest() {
        this.taskType = FormatLivePlayInfo.TaskType.TopicInteract.getType();
    }

    public final String getAvatarCid() {
        return this.avatarCid;
    }

    public final String getAvatarUid() {
        return this.avatarUid;
    }

    public final PlayGenerateScriptData getScriptData() {
        return this.scriptData;
    }

    public final int getTaskType() {
        return this.taskType;
    }

    public final PlayGenerateTopicData getTopicData() {
        return this.topicData;
    }

    public final boolean isEdit() {
        return this.isEdit;
    }

    public final void setAvatarCid(String r100) {
        this.avatarCid = r100;
    }

    public final void setAvatarUid(String r100) {
        this.avatarUid = r100;
    }

    public final void setEdit(boolean r100) {
        this.isEdit = r100;
    }

    public final void setScriptData(PlayGenerateScriptData r100) {
        this.scriptData = r100;
    }

    public final void setTaskType(int r100) {
        this.taskType = r100;
    }

    public final void setTopicData(PlayGenerateTopicData r100) {
        this.topicData = r100;
    }
}
