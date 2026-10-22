package stepai.aios.guiagent.config;

import Z7.t;
import androidx.compose.foundation.b;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import kotlin.Metadata;
import kotlin.jvm.internal.MutablePropertyReference1Impl;
import kotlin.jvm.internal.m;
import kotlin.jvm.internal.n;
import stepai.aios.guiagent.config.ConfigDelegate;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u0007\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R+\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\t8F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR/\u0010\u0011\u001a\u0004\u0018\u00010\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u00058F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b\u0015\u0010\u0010\u001a\u0004\b\u0012\u0010\u0007\"\u0004\b\u0013\u0010\u0014R/\u0010\u0016\u001a\u0004\u0018\u00010\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u00058F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b\u0019\u0010\u0010\u001a\u0004\b\u0017\u0010\u0007\"\u0004\b\u0018\u0010\u0014R+\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\b\u001a\u00020\u001a8F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b \u0010\u0010\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001f¨\u0006!"}, d2 = {"Lstepai/aios/guiagent/config/AgentConfig;", "Lstepai/aios/guiagent/config/ConfigDelegate;", AppAgent.CONSTRUCT, "()V", "ID", "", "getID", "()Ljava/lang/String;", "<set-?>", "", "GUI_ACTION_DURING", "getGUI_ACTION_DURING", "()J", "setGUI_ACTION_DURING", "(J)V", "GUI_ACTION_DURING$delegate", "Lstepai/aios/guiagent/config/ConfigDelegate$MMKVDelegate;", "GUI_LLM_MODEL_ID", "getGUI_LLM_MODEL_ID", "setGUI_LLM_MODEL_ID", "(Ljava/lang/String;)V", "GUI_LLM_MODEL_ID$delegate", "GUI_LLM_PARSE_ID", "getGUI_LLM_PARSE_ID", "setGUI_LLM_PARSE_ID", "GUI_LLM_PARSE_ID$delegate", "", "GUI_LLM_LOCAL_PATH_LIST_ENABLE", "getGUI_LLM_LOCAL_PATH_LIST_ENABLE", "()Z", "setGUI_LLM_LOCAL_PATH_LIST_ENABLE", "(Z)V", "GUI_LLM_LOCAL_PATH_LIST_ENABLE$delegate", "guiagent_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class AgentConfig extends ConfigDelegate {
    static final /* synthetic */ t[] $$delegatedProperties;

    /* renamed from: GUI_ACTION_DURING$delegate, reason: from kotlin metadata */
    private static final ConfigDelegate.MMKVDelegate GUI_ACTION_DURING;

    /* renamed from: GUI_LLM_LOCAL_PATH_LIST_ENABLE$delegate, reason: from kotlin metadata */
    private static final ConfigDelegate.MMKVDelegate GUI_LLM_LOCAL_PATH_LIST_ENABLE;

    /* renamed from: GUI_LLM_MODEL_ID$delegate, reason: from kotlin metadata */
    private static final ConfigDelegate.MMKVDelegate GUI_LLM_MODEL_ID;

    /* renamed from: GUI_LLM_PARSE_ID$delegate, reason: from kotlin metadata */
    private static final ConfigDelegate.MMKVDelegate GUI_LLM_PARSE_ID;
    private static final String ID;
    public static final AgentConfig INSTANCE;

    static {
        MutablePropertyReference1Impl mutablePropertyReference1Impl = new MutablePropertyReference1Impl(AgentConfig.class, "GUI_ACTION_DURING", "getGUI_ACTION_DURING()J", 0);
        n nVar = m.f4928a;
        $$delegatedProperties = new t[]{nVar.e(mutablePropertyReference1Impl), b.i(AgentConfig.class, "GUI_LLM_MODEL_ID", "getGUI_LLM_MODEL_ID()Ljava/lang/String;", 0, nVar), b.i(AgentConfig.class, "GUI_LLM_PARSE_ID", "getGUI_LLM_PARSE_ID()Ljava/lang/String;", 0, nVar), b.i(AgentConfig.class, "GUI_LLM_LOCAL_PATH_LIST_ENABLE", "getGUI_LLM_LOCAL_PATH_LIST_ENABLE()Z", 0, nVar)};
        AgentConfig agentConfig = new AgentConfig();
        INSTANCE = agentConfig;
        ID = "agent_config";
        GUI_ACTION_DURING = ConfigDelegate.long$default(agentConfig, "gui_action_during", 0L, 2, null);
        GUI_LLM_MODEL_ID = agentConfig.string("gui_llm_model_id", null);
        GUI_LLM_PARSE_ID = agentConfig.string("gui_llm_parse_id", null);
        GUI_LLM_LOCAL_PATH_LIST_ENABLE = agentConfig.m7361boolean("gui_llm_local_path_list_enable", true);
    }

    private AgentConfig() {
    }

    public final long getGUI_ACTION_DURING() {
        return ((Number) GUI_ACTION_DURING.getValue(this, $$delegatedProperties[0])).longValue();
    }

    public final boolean getGUI_LLM_LOCAL_PATH_LIST_ENABLE() {
        return ((Boolean) GUI_LLM_LOCAL_PATH_LIST_ENABLE.getValue(this, $$delegatedProperties[3])).booleanValue();
    }

    public final String getGUI_LLM_MODEL_ID() {
        return (String) GUI_LLM_MODEL_ID.getValue(this, $$delegatedProperties[1]);
    }

    public final String getGUI_LLM_PARSE_ID() {
        return (String) GUI_LLM_PARSE_ID.getValue(this, $$delegatedProperties[2]);
    }

    @Override // stepai.aios.guiagent.config.ConfigDelegate
    public String getID() {
        return ID;
    }

    public final void setGUI_ACTION_DURING(long j5) {
        GUI_ACTION_DURING.setValue(this, $$delegatedProperties[0], Long.valueOf(j5));
    }

    public final void setGUI_LLM_LOCAL_PATH_LIST_ENABLE(boolean z10) {
        GUI_LLM_LOCAL_PATH_LIST_ENABLE.setValue(this, $$delegatedProperties[3], Boolean.valueOf(z10));
    }

    public final void setGUI_LLM_MODEL_ID(String str) {
        GUI_LLM_MODEL_ID.setValue(this, $$delegatedProperties[1], str);
    }

    public final void setGUI_LLM_PARSE_ID(String str) {
        GUI_LLM_PARSE_ID.setValue(this, $$delegatedProperties[2], str);
    }
}
