package com.stepos.agentframework.chatcore.agents;

import kotlin.Metadata;
import kotlin.text.Regex;

@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\u0005\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"EXEC_WRAPPER_TOOL_NAME", "", "GUI_AGENT_TOOL_NAME", "EXEC_TOOL_NAME_REGEX", "Lkotlin/text/Regex;", "EXEC_PARAMS_REGEX", "chatcore_release"}, k = 2, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class l {
    private static final String EXEC_WRAPPER_TOOL_NAME = "exec";
    private static final String GUI_AGENT_TOOL_NAME = "gui_agent";
    private static final Regex EXEC_TOOL_NAME_REGEX = new Regex("--tool-name\\s+(\\S+)");
    private static final Regex EXEC_PARAMS_REGEX = new Regex("--params\\s+(?:'([^']*)'|\"((?:[^\"\\\\]|\\\\.)*)\")");
}
