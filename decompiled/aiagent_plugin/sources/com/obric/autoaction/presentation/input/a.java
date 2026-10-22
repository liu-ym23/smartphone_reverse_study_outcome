package com.obric.autoaction.presentation.input;

import com.obric.autogui.common.api.logging.Loog;
import com.obric.eventkit.EventsTaskSdk;
import com.obric.eventkit.eventstaskmanager.IAssistantInteractionListener;
import com.obric.eventkit.eventstaskmanager.IEventBinderListener;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.x;

/* JADX INFO: compiled from: AssistInputUIState.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class a {
    private static final String TAG = "AssistInputUIState";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f24956a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static boolean f24957b;

    static {
        f24956a = new a();
    }

    private a() {
    }

    public final void a() {
        monitor-enter(this);
    L13:
        th = move-exception;
        throw th;
    L4:
        if (f24957b == false) goto L9;
        Loog.INSTANCE.d(TAG, "Init: initialized.");     // Catch: Throwable -> L13
        monitor-exit(this);
        return;
    L9:
        f24957b = true;     // Catch: Throwable -> L13
        x r0 = x.f38692a;     // Catch: Throwable -> L13
        monitor-exit(this);
        b();
        EventsTaskSdk.INSTANCE.addEventBinderListener((IEventBinderListener) ZeusTransformUtils.preCheckCast(new AssistInputUIState$maybeInit$2(), IEventBinderListener.class, "com.obric.aiagent.plugin"));
    }

    public final void b() {
        EventsTaskSdk.INSTANCE.setAssistantInteractionListener((IAssistantInteractionListener) ZeusTransformUtils.preCheckCast(new AssistInputUIState$initAssistInputUIState$1(), IAssistantInteractionListener.class, "com.obric.aiagent.plugin"));
    }
}
