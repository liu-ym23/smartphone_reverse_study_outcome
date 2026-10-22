package com.stepos.launcher.assistant.utils;

import android.net.Uri;

/* loaded from: classes.dex */
public final class AiLauncherStateContract {
    public static final String AUTHORITY = "com.stepos.ailauncher.state.provider";
    public static final String PATH_AGENT_ENABLED = "agent_enabled";
    public static final Uri URI_AGENT_ENABLED = Uri.parse("content://com.stepos.ailauncher.state.provider/agent_enabled");

    private AiLauncherStateContract() {
    }
}
