package com.obric.capability.schedulekit;

import android.os.IInterface;
import android.util.Log;
import com.obric.capabilitykit.common.ICapabilityFeedbackReceiver;
import com.obric.capabilitykit.common.ICapabilitySchedule;
import com.obric.capabilitykit.common.IQueryAppIntentsCallback;
import com.obric.capabilitykit.corecommon.BinderExceptionHandlerProxy;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.h;
import d.h.b.o;
import d.n;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: compiled from: ScheduleProxy.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class g implements d {
    private static final String TAG = "ScheduleProxy";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f31917a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final ICapabilitySchedule f31918b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final ICapabilitySchedule f31919c;

    /* JADX INFO: compiled from: ScheduleProxy.kt */
    public static final class a {
        public /* synthetic */ a(h r1) {
            this();
        }

        private a() {
        }
    }

    static {
        f31917a = new a(null);
    }

    public g(ICapabilitySchedule r7) {
        ICapabilitySchedule r8 = (ICapabilitySchedule) ZeusTransformUtils.wrapperContextForParams(r7, ICapabilitySchedule.class, "com.obric.aiagent.plugin");
        o.e(r8, "api");
        this.f31918b = r8;
        BinderExceptionHandlerProxy.Companion r0 = BinderExceptionHandlerProxy.Companion;
        IInterface r9 = (IInterface) ZeusTransformUtils.preCheckCast(r8, IInterface.class, "com.obric.aiagent.plugin");
        n.a r2 = n.f38560a;     // Catch: Throwable -> L8
        Object r3 = Proxy.newProxyInstance(ICapabilitySchedule.class.getClassLoader(), new Class[]{ICapabilitySchedule.class}, (InvocationHandler) ZeusTransformUtils.preCheckCast(new BinderExceptionHandlerProxy(r9, TAG, ICapabilitySchedule.class), InvocationHandler.class, "com.obric.aiagent.plugin"));     // Catch: Throwable -> L8
        if (r3 == null) goto L7;
        r9 = (IInterface) ZeusTransformUtils.preCheckCast((ICapabilitySchedule) ZeusTransformUtils.preCheckCast(r3, ICapabilitySchedule.class, "com.obric.aiagent.plugin"), IInterface.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L8
    L12:
        this.f31919c = (ICapabilitySchedule) ZeusTransformUtils.preCheckCast(r9, ICapabilitySchedule.class, "com.obric.aiagent.plugin");
        return;
    L7:
        throw new NullPointerException("null cannot be cast to non-null type com.obric.capabilitykit.common.ICapabilitySchedule");     // Catch: Throwable -> L8
    L8:
        th = move-exception;
        n.a r4 = n.f38560a;
        Throwable r5 = n.c(n.f(d.o.a(th)));
        if (r5 == null) goto L12;
        a(TAG, "BinderExceptionHandlerProxy createProxyInstance for " + r9.getClass() + " fail", r5);
        goto L12
    }

    @Override // com.obric.capability.schedulekit.d
    public void a(String r2, boolean r3) {
        o.e(r2, "payload");
        this.f31919c.dispatchServerActions(r2, r3);
    }

    @Override // com.obric.capability.schedulekit.d
    public void a(ICapabilityFeedbackReceiver r3) {
        ICapabilityFeedbackReceiver r4 = (ICapabilityFeedbackReceiver) ZeusTransformUtils.wrapperContextForParams(r3, ICapabilityFeedbackReceiver.class, "com.obric.aiagent.plugin");
        o.e(r4, "receiver");
        this.f31919c.registerActionsResultReceiver(r4);
    }

    @Override // com.obric.capability.schedulekit.d
    public void a(String r3, IQueryAppIntentsCallback r4) {
        IQueryAppIntentsCallback r5 = (IQueryAppIntentsCallback) ZeusTransformUtils.wrapperContextForParams(r4, IQueryAppIntentsCallback.class, "com.obric.aiagent.plugin");
        o.e(r3, "name");
        o.e(r5, "callback");
        this.f31919c.queryAppIntents(r3, r5);
    }

    @Skip({com.obric.aiagent.apm.impl.BuildConfig.LIBRARY_PACKAGE_NAME})
    public static int a(String r0, String r1, Throwable r2) {
        return Log.e(r0, r1, r2);
    }
}
