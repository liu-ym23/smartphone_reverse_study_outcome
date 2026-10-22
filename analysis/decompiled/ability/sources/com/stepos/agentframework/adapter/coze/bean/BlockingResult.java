package com.stepos.agentframework.adapter.coze.bean;

import androidx.core.app.NotificationCompat;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import com.google.gson.annotations.SerializedName;
import com.stepos.ability.beaninternal.task.GuiTaskProgressKt;
import com.stepos.ability.commoninternal.Key;
import com.stepos.agentbus.generated.AgentBusWakeContract;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010\u0000\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\n\u0018\u00002\u00020\u0001:\u0001,B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R \u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR \u0010\n\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\tR \u0010\r\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u0007\"\u0004\b\u000f\u0010\tR \u0010\u0010\u001a\u0004\u0018\u00010\u00118\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R \u0010\u0016\u001a\u0004\u0018\u00010\u00118\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0013\"\u0004\b\u0018\u0010\u0015R \u0010\u0019\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u0007\"\u0004\b\u001b\u0010\tR \u0010\u001c\u001a\u0004\u0018\u00010\u001d8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\"\u0010\"\u001a\u0004\u0018\u00010#8\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010(\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R \u0010)\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b*\u0010\u0007\"\u0004\b+\u0010\t¨\u0006-"}, d2 = {"Lcom/stepos/agentframework/adapter/coze/bean/BlockingResult;", "Lcom/stepos/agentframework/adapter/coze/bean/ErrorResult;", AppAgent.CONSTRUCT, "()V", NotificationCompat.CATEGORY_EVENT, "", "getEvent", "()Ljava/lang/String;", "setEvent", "(Ljava/lang/String;)V", GuiTaskProgressKt.GuiTaskProgress_KEY_TASK_ID, "getTaskId", "setTaskId", "id", "getId", "setId", AgentBusWakeContract.EXTRA_TRACE_ID, "", "getTraceId", "()Ljava/lang/Object;", "setTraceId", "(Ljava/lang/Object;)V", "uid", "getUid", "setUid", "answer", "getAnswer", "setAnswer", "metadata", "Lcom/stepos/agentframework/adapter/coze/bean/BlockingResult$MetadataDTO;", "getMetadata", "()Lcom/stepos/agentframework/adapter/coze/bean/BlockingResult$MetadataDTO;", "setMetadata", "(Lcom/stepos/agentframework/adapter/coze/bean/BlockingResult$MetadataDTO;)V", "createdAt", "", "getCreatedAt", "()Ljava/lang/Integer;", "setCreatedAt", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "conversationId", "getConversationId", "setConversationId", "MetadataDTO", "coze_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class BlockingResult extends ErrorResult {

    @SerializedName("answer")
    private String answer;

    @SerializedName("conversation_id")
    private String conversationId;

    @SerializedName("created_at")
    private Integer createdAt;

    @SerializedName(NotificationCompat.CATEGORY_EVENT)
    private String event;

    @SerializedName("id")
    private String id;

    @SerializedName("metadata")
    private MetadataDTO metadata;

    @SerializedName("task_id")
    private String taskId;

    @SerializedName(Key.KEY_TRACE_ID)
    private Object traceId;

    @SerializedName("uid")
    private Object uid;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/stepos/agentframework/adapter/coze/bean/BlockingResult$MetadataDTO;", "", AppAgent.CONSTRUCT, "()V", "coze_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class MetadataDTO {
    }

    public BlockingResult() {
        super(null, null, null, 0, 15, null);
    }

    public final String getAnswer() {
        return this.answer;
    }

    public final String getConversationId() {
        return this.conversationId;
    }

    public final Integer getCreatedAt() {
        return this.createdAt;
    }

    public final String getEvent() {
        return this.event;
    }

    public final String getId() {
        return this.id;
    }

    public final MetadataDTO getMetadata() {
        return this.metadata;
    }

    public final String getTaskId() {
        return this.taskId;
    }

    public final Object getTraceId() {
        return this.traceId;
    }

    public final Object getUid() {
        return this.uid;
    }

    public final void setAnswer(String str) {
        this.answer = str;
    }

    public final void setConversationId(String str) {
        this.conversationId = str;
    }

    public final void setCreatedAt(Integer num) {
        this.createdAt = num;
    }

    public final void setEvent(String str) {
        this.event = str;
    }

    public final void setId(String str) {
        this.id = str;
    }

    public final void setMetadata(MetadataDTO metadataDTO) {
        this.metadata = metadataDTO;
    }

    public final void setTaskId(String str) {
        this.taskId = str;
    }

    public final void setTraceId(Object obj) {
        this.traceId = obj;
    }

    public final void setUid(Object obj) {
        this.uid = obj;
    }
}
