package com.stepos.agentframework.adapter.coze.bean;

import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import kotlin.Metadata;
import stepai.aios.guiagent.config.GuiAgentConfigKt;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\n\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001c\u0010\n\u001a\u0004\u0018\u00010\u0001X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"Lcom/stepos/agentframework/adapter/coze/bean/ToolOutput;", "", AppAgent.CONSTRUCT, "()V", GuiAgentConfigKt.META_KEY_TOOL_CALL_ID, "", "getTool_call_id", "()Ljava/lang/String;", "setTool_call_id", "(Ljava/lang/String;)V", "output", "getOutput", "()Ljava/lang/Object;", "setOutput", "(Ljava/lang/Object;)V", "coze_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class ToolOutput {
    private Object output;
    private String tool_call_id;

    public final Object getOutput() {
        return this.output;
    }

    public final String getTool_call_id() {
        return this.tool_call_id;
    }

    public final void setOutput(Object obj) {
        this.output = obj;
    }

    public final void setTool_call_id(String str) {
        this.tool_call_id = str;
    }
}
