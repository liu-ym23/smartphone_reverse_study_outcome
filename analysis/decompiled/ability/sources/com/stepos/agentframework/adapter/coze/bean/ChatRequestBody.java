package com.stepos.agentframework.adapter.coze.bean;

import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0011\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0007\"\u0004\b\u0012\u0010\tR\u001e\u0010\u0013\u001a\u0004\u0018\u00010\u000bX\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0018\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001e\u0010\u0019\u001a\u0004\u0018\u00010\u000bX\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0018\u001a\u0004\b\u001a\u0010\u0015\"\u0004\b\u001b\u0010\u0017R\"\u0010\u001c\u001a\n\u0012\u0004\u0012\u00020\u001e\u0018\u00010\u001dX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R.\u0010#\u001a\u0016\u0012\u0004\u0012\u00020%\u0018\u00010$j\n\u0012\u0004\u0012\u00020%\u0018\u0001`&X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*R\u001c\u0010+\u001a\u0004\u0018\u00010,X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b-\u0010.\"\u0004\b/\u00100¨\u00061"}, d2 = {"Lcom/stepos/agentframework/adapter/coze/bean/ChatRequestBody;", "", AppAgent.CONSTRUCT, "()V", "bot_id", "", "getBot_id", "()Ljava/lang/String;", "setBot_id", "(Ljava/lang/String;)V", "stream", "", "getStream", "()Z", "setStream", "(Z)V", "user_id", "getUser_id", "setUser_id", "auto_save_history", "getAuto_save_history", "()Ljava/lang/Boolean;", "setAuto_save_history", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "enable_card", "getEnable_card", "setEnable_card", "additional_messages", "", "Lcom/stepos/agentframework/adapter/coze/bean/Message;", "getAdditional_messages", "()Ljava/util/List;", "setAdditional_messages", "(Ljava/util/List;)V", "tool_outputs", "Ljava/util/ArrayList;", "Lcom/stepos/agentframework/adapter/coze/bean/ToolOutput;", "Lkotlin/collections/ArrayList;", "getTool_outputs", "()Ljava/util/ArrayList;", "setTool_outputs", "(Ljava/util/ArrayList;)V", "thinking", "Lcom/stepos/agentframework/adapter/coze/bean/Thinking;", "getThinking", "()Lcom/stepos/agentframework/adapter/coze/bean/Thinking;", "setThinking", "(Lcom/stepos/agentframework/adapter/coze/bean/Thinking;)V", "coze_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class ChatRequestBody {
    private List<Message> additional_messages;
    private Boolean enable_card;
    private Thinking thinking;
    private ArrayList<ToolOutput> tool_outputs;
    private String bot_id = "";
    private boolean stream = true;
    private String user_id = "";
    private Boolean auto_save_history = Boolean.TRUE;

    public final List<Message> getAdditional_messages() {
        return this.additional_messages;
    }

    public final Boolean getAuto_save_history() {
        return this.auto_save_history;
    }

    public final String getBot_id() {
        return this.bot_id;
    }

    public final Boolean getEnable_card() {
        return this.enable_card;
    }

    public final boolean getStream() {
        return this.stream;
    }

    public final Thinking getThinking() {
        return this.thinking;
    }

    public final ArrayList<ToolOutput> getTool_outputs() {
        return this.tool_outputs;
    }

    public final String getUser_id() {
        return this.user_id;
    }

    public final void setAdditional_messages(List<Message> list) {
        this.additional_messages = list;
    }

    public final void setAuto_save_history(Boolean bool) {
        this.auto_save_history = bool;
    }

    public final void setBot_id(String str) {
        this.bot_id = str;
    }

    public final void setEnable_card(Boolean bool) {
        this.enable_card = bool;
    }

    public final void setStream(boolean z10) {
        this.stream = z10;
    }

    public final void setThinking(Thinking thinking) {
        this.thinking = thinking;
    }

    public final void setTool_outputs(ArrayList<ToolOutput> arrayList) {
        this.tool_outputs = arrayList;
    }

    public final void setUser_id(String str) {
        this.user_id = str;
    }
}
