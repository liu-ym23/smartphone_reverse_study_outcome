package com.obric.capability.schedulekit;

import com.obric.capabilitykit.common.ICapabilityFeedbackReceiver;
import com.obric.capabilitykit.common.IQueryAppIntentsCallback;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;

/* JADX INFO: compiled from: ScheduleProxy.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class b implements d {
    private static final String TAG = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f31875a = null;

    private b() {
    }

    static {
        f31875a = new b();
        TAG = "EmptyScheduleProxy";
    }

    @Override // com.obric.capability.schedulekit.d
    public void a(String r1, boolean r2) {
        o.e(r1, "payload");
        com.obric.capability.schedulekit.c.c.f31906a.i(TAG, "dispatchServerActions");
    }

    @Override // com.obric.capability.schedulekit.d
    public void a(ICapabilityFeedbackReceiver r2) {
        o.e((ICapabilityFeedbackReceiver) ZeusTransformUtils.wrapperContextForParams(r2, ICapabilityFeedbackReceiver.class, "com.obric.aiagent.plugin"), "receiver");
        com.obric.capability.schedulekit.c.c.f31906a.i(TAG, "registerActionsResultReceiver");
    }

    @Override // com.obric.capability.schedulekit.d
    public void a(String r3, IQueryAppIntentsCallback r4) {
        IQueryAppIntentsCallback r2 = (IQueryAppIntentsCallback) ZeusTransformUtils.wrapperContextForParams(r4, IQueryAppIntentsCallback.class, "com.obric.aiagent.plugin");
        o.e(r3, "name");
        o.e(r2, "callback");
        com.obric.capability.schedulekit.c.c.f31906a.i(TAG, "queryAppIntents " + r3);
    }
}
