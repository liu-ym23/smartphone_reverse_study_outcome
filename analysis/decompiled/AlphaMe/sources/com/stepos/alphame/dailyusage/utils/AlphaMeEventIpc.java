package com.stepos.alphame.dailyusage.utils;

import android.os.Bundle;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import org.jetbrains.annotations.NotNull;
import p2.AbstractC0816a;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0015\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0019\u001a\u00020\u001aH\u0007J\b\u0010\u001b\u001a\u00020\u001aH\u0007J\b\u0010\u001c\u001a\u00020\u001dH\u0007J\u0010\u0010\u001e\u001a\u00020\u001d2\u0006\u0010\u001f\u001a\u00020\u0004H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006 "}, d2 = {"Lcom/stepos/alphame/dailyusage/utils/AlphaMeEventIpc;", "", "()V", "ACCESS_IPC_SERVICE_PERMISSION", "", "ACTION_SCENE_WORKING_STATE_FORWARD", "ACTION_WINDOW_MODE_FORWARD", "AUTHORITY", "CALLBACK_STATE_CHANGED", "CALLBACK_WINDOW_MODE_CHANGED", "EXTRA_CALLBACK", "EXTRA_NEW_TYPE", "EXTRA_NEW_TYPE_STR", "EXTRA_OLD_TYPE", "EXTRA_OLD_TYPE_STR", "EXTRA_TASK_ID", "EXTRA_WINDOWING_MODE", "EXTRA_WINDOW_MODE_STATE", "EXTRA_WINDOW_MODE_STATE_INT", "KEY_DISPLAY_ID", "KEY_UID", "KEY_WINDOW_MODE_FREEFORM", "KEY_WINDOW_MODE_PINNED", AlphaMeEventIpc.RESULT, "SERVICE", "enableSceneMonitor", "", "enableWindowModeMonitor", "getWindowModeConstants", "Landroid/os/Bundle;", "ipc", "method", "dailyusage_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes.dex */
public final class AlphaMeEventIpc {

    @NotNull
    public static final String ACCESS_IPC_SERVICE_PERMISSION = "com.stepos.appplatform.permission.ACCESS_IPC_SERVICE";

    @NotNull
    public static final String ACTION_SCENE_WORKING_STATE_FORWARD = "com.stepos.alphame.ACTION_SCENE_WORKING_STATE_FORWARD";

    @NotNull
    public static final String ACTION_WINDOW_MODE_FORWARD = "com.stepos.alphame.ACTION_WINDOW_MODE_FORWARD";

    @NotNull
    private static final String AUTHORITY = "com.stepos.appplatform";

    @NotNull
    public static final String CALLBACK_STATE_CHANGED = "onStateChanged";

    @NotNull
    public static final String CALLBACK_WINDOW_MODE_CHANGED = "onWindowModeChanged";

    @NotNull
    public static final String EXTRA_CALLBACK = "EXTRA_CALLBACK";

    @NotNull
    public static final String EXTRA_NEW_TYPE = "EXTRA_NEW_TYPE";

    @NotNull
    public static final String EXTRA_NEW_TYPE_STR = "EXTRA_NEW_TYPE_STR";

    @NotNull
    public static final String EXTRA_OLD_TYPE = "EXTRA_OLD_TYPE";

    @NotNull
    public static final String EXTRA_OLD_TYPE_STR = "EXTRA_OLD_TYPE_STR";

    @NotNull
    public static final String EXTRA_TASK_ID = "EXTRA_TASK_ID";

    @NotNull
    public static final String EXTRA_WINDOWING_MODE = "EXTRA_WINDOWING_MODE";

    @NotNull
    public static final String EXTRA_WINDOW_MODE_STATE = "EXTRA_WINDOW_MODE_STATE";

    @NotNull
    public static final String EXTRA_WINDOW_MODE_STATE_INT = "EXTRA_WINDOW_MODE_STATE_INT";

    @NotNull
    public static final AlphaMeEventIpc INSTANCE = new AlphaMeEventIpc();

    @NotNull
    public static final String KEY_DISPLAY_ID = "DISPLAY_ID";

    @NotNull
    public static final String KEY_UID = "UID";

    @NotNull
    public static final String KEY_WINDOW_MODE_FREEFORM = "WINDOW_MODE_FREEFORM";

    @NotNull
    public static final String KEY_WINDOW_MODE_PINNED = "WINDOW_MODE_PINNED";

    @NotNull
    private static final String RESULT = "RESULT";

    @NotNull
    private static final String SERVICE = "com.stepos.appplatform.alphame.AlphaMeSettingsSystem";

    private AlphaMeEventIpc() {
    }

    @JvmStatic
    public static final boolean enableSceneMonitor() {
        return INSTANCE.ipc("enableSceneMonitor").getBoolean(RESULT, false);
    }

    @JvmStatic
    public static final boolean enableWindowModeMonitor() {
        return INSTANCE.ipc("enableWindowModeMonitor").getBoolean(RESULT, false);
    }

    @JvmStatic
    @NotNull
    public static final Bundle getWindowModeConstants() {
        return INSTANCE.ipc("getWindowModeConstants");
    }

    private final Bundle ipc(String method) {
        int i4 = AbstractC0816a.f13930a;
        return AbstractC0816a.a(method, new Bundle());
    }
}
