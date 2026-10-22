package com.stepos.ailauncher.task.agentbus;

import Z8.Y;
import com.stepos.ailauncher.agent.ability.VoiceAbilityService;
import java.util.Set;
import kotlin.Metadata;
import kotlin.text.Regex;

@Metadata(d1 = {"\u0000&\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\"\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a\u0019\u0010\u0003\u001a\u00020\u00022\b\u0010\u0001\u001a\u0004\u0018\u00010\u0000H\u0002¢\u0006\u0004\b\u0003\u0010\u0004\"\u0014\u0010\u0005\u001a\u00020\u00008\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0005\u0010\u0006\"\u0014\u0010\u0007\u001a\u00020\u00008\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0007\u0010\u0006\"\u0014\u0010\b\u001a\u00020\u00008\u0002X\u0082T¢\u0006\u0006\n\u0004\b\b\u0010\u0006\"\u0014\u0010\t\u001a\u00020\u00008\u0002X\u0082T¢\u0006\u0006\n\u0004\b\t\u0010\u0006\"\u0014\u0010\n\u001a\u00020\u00008\u0002X\u0082T¢\u0006\u0006\n\u0004\b\n\u0010\u0006\"\u0014\u0010\u000b\u001a\u00020\u00008\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u000b\u0010\u0006\"\u001a\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00000\f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000e\"\u0014\u0010\u0010\u001a\u00020\u000f8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011\"\u0014\u0010\u0012\u001a\u00020\u00008\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0012\u0010\u0006\"\u0014\u0010\u0013\u001a\u00020\u00008\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0013\u0010\u0006\"\u0014\u0010\u0014\u001a\u00020\u00008\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0014\u0010\u0006\"\u0014\u0010\u0015\u001a\u00020\u00008\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0015\u0010\u0006\"\u0014\u0010\u0016\u001a\u00020\u00008\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0016\u0010\u0006\"\u0014\u0010\u0017\u001a\u00020\u00008\u0002X\u0082D¢\u0006\u0006\n\u0004\b\u0017\u0010\u0006\"\u0014\u0010\u0018\u001a\u00020\u00008\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0018\u0010\u0006\"\u0014\u0010\u0019\u001a\u00020\u00008\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0019\u0010\u0006\"\u0014\u0010\u001a\u001a\u00020\u00028\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u001a\u0010\u001b\"\u0014\u0010\u001c\u001a\u00020\u000f8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u001c\u0010\u0011\"\u0014\u0010\u001d\u001a\u00020\u000f8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u001d\u0010\u0011\"\u0014\u0010\u001e\u001a\u00020\u000f8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u001e\u0010\u0011\"\u0014\u0010\u001f\u001a\u00020\u00008\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u001f\u0010\u0006\"\u0014\u0010 \u001a\u00020\u00008\u0002X\u0082T¢\u0006\u0006\n\u0004\b \u0010\u0006\"\u0014\u0010\"\u001a\u00020!8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\"\u0010#\"\u0014\u0010$\u001a\u00020!8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b$\u0010#¨\u0006%"}, d2 = {"", "name", "", "f", "(Ljava/lang/String;)Z", "EXEC_WRAPPER_TOOL_NAME", "Ljava/lang/String;", "GUI_AGENT_TOOL_NAME", "EXEC_WRAPPER_DISPLAY_NAME", "TASK_ARTIFACT_TOOL_NAME", "TASK_RESULT_SUBMIT_TOOL_NAME", "TEXT_TO_IMAGE_TOOL_NAME", "", "ARTIFACT_TOOL_NAMES", "Ljava/util/Set;", "", "ARTIFACT_PREVIEW_EXPIRES_SECONDS", "I", "SURFACE_LIVE_ACTIVITY", "SURFACE_NOTIFICATION", "SURFACE_ALL", "ABILITY_WRAPPER_NAME", "ASK_THIRD_PARTY_AGENT_TOOL_NAME", "TRIPARTITE_CARD_TOOL_NAME", "OPENCLAW_INVOKE_MARKER", "OPENCLAW_ABILITY_CALL_MARKER", "ENABLE_TOOL_RAW_DUMP", "Z", "MAX_TOOL_RAW_DUMP_CHARS", "TOOL_LOG_SNIPPET_CHARS", "LOG_BYPASS_RAW_CHUNK_SIZE", "NODES_WRAPPER_NAME", "NODES_ACTION_INVOKE", "Lkotlin/text/Regex;", "EXEC_TOOL_NAME_REGEX", "Lkotlin/text/Regex;", "EXEC_PARAMS_REGEX", "task_release"}, k = 2, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class q {
    private static final String ABILITY_WRAPPER_NAME = "ability";
    private static final int ARTIFACT_PREVIEW_EXPIRES_SECONDS = 600;
    private static final String ASK_THIRD_PARTY_AGENT_TOOL_NAME = "ask_third_party_agent";
    private static final boolean ENABLE_TOOL_RAW_DUMP = false;
    private static final String EXEC_WRAPPER_DISPLAY_NAME = "正在执行终端命令「ability-cli」";
    private static final String EXEC_WRAPPER_TOOL_NAME = "exec";
    private static final String GUI_AGENT_TOOL_NAME = "gui_agent";
    private static final int LOG_BYPASS_RAW_CHUNK_SIZE = 3500;
    private static final int MAX_TOOL_RAW_DUMP_CHARS = 4096;
    private static final String NODES_ACTION_INVOKE = "invoke";
    private static final String NODES_WRAPPER_NAME = "nodes";
    private static final String OPENCLAW_ABILITY_CALL_MARKER = "ability.call";
    private static final String OPENCLAW_INVOKE_MARKER = "openclaw nodes invoke";
    private static final String SURFACE_ALL = "all";
    private static final String SURFACE_LIVE_ACTIVITY = "live_activity";
    private static final String SURFACE_NOTIFICATION = "notification";
    private static final String TASK_ARTIFACT_TOOL_NAME = "task_artifact";
    private static final String TASK_RESULT_SUBMIT_TOOL_NAME = "task_result_submit";
    private static final String TEXT_TO_IMAGE_TOOL_NAME = "text_to_image";
    private static final int TOOL_LOG_SNIPPET_CHARS = 256;
    private static final Set<String> ARTIFACT_TOOL_NAMES = Y.j("task_artifact", "task_result_submit", "text_to_image");
    private static final String TRIPARTITE_CARD_TOOL_NAME = VoiceAbilityService.TOOL_LOAD_TRIPARTITE_COMMON_CARD;
    private static final Regex EXEC_TOOL_NAME_REGEX = new Regex("--tool-name\\s+(\\S+)");
    private static final Regex EXEC_PARAMS_REGEX = new Regex("--params\\s+(?:'([^']*)'|\"((?:[^\"\\\\]|\\\\.)*)\")");

    public static final boolean f(String str) {
        return kotlin.jvm.internal.p.d(str, EXEC_WRAPPER_TOOL_NAME) || kotlin.jvm.internal.p.d(str, EXEC_WRAPPER_DISPLAY_NAME);
    }
}
