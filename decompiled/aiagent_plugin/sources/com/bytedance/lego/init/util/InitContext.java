package com.bytedance.lego.init.util;

import android.app.Activity;
import com.bytedance.lego.init.InitScheduler;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.f;
import d.g;
import d.h.a.a;
import d.h.b.aa;
import d.h.b.o;
import d.h.b.p;
import d.h.b.y;
import d.m.h;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: compiled from: InitContext.kt */
/* JADX INFO: loaded from: classes.dex */
public final class InitContext {
    static final /* synthetic */ h[] $$delegatedProperties = null;
    public static final InitContext INSTANCE = null;
    private static final ConcurrentHashMap<Object, Object> commonParams = null;
    private static final f isMainProcess$delegate = null;
    private static final f processName$delegate = null;

    /* JADX INFO: renamed from: com.bytedance.lego.init.util.InitContext$isMainProcess$2, reason: invalid class name */
    /* JADX INFO: compiled from: InitContext.kt */
    static final class AnonymousClass2 extends p implements a<Boolean> {
        public static final AnonymousClass2 INSTANCE = null;

        static {
            INSTANCE = new AnonymousClass2();
        }

        AnonymousClass2() {
            super(0);
        }

        @Override // d.h.a.a
        public /* synthetic */ Boolean invoke() {
            return Boolean.valueOf(invoke2());
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final boolean invoke2() {
            return InitScheduler.INSTANCE.getConfig$initscheduler_release().isMainProcess();
        }
    }

    public static final String getProcessName() {
        f r0 = processName$delegate;
        h r1 = $$delegatedProperties[1];
        return (String) ZeusTransformUtils.preCheckCast(r0.b(), String.class, "com.obric.aiagent.plugin");
    }

    public static final boolean isMainProcess() {
        f r0 = isMainProcess$delegate;
        h r1 = $$delegatedProperties[0];
        return ((Boolean) ZeusTransformUtils.preCheckCast(r0.b(), Boolean.class, "com.obric.aiagent.plugin")).booleanValue();
    }

    public static /* synthetic */ void isMainProcess$annotations() {
    }

    public static /* synthetic */ void mainActivity$annotations() {
    }

    public static /* synthetic */ void processName$annotations() {
    }

    public static /* synthetic */ void splashActivity$annotations() {
    }

    static {
        $$delegatedProperties = new h[]{(h) ZeusTransformUtils.preCheckCast(aa.a(new y(aa.b(InitContext.class), "isMainProcess", "isMainProcess()Z")), h.class, "com.obric.aiagent.plugin"), (h) ZeusTransformUtils.preCheckCast(aa.a(new y(aa.b(InitContext.class), "processName", "getProcessName()Ljava/lang/String;")), h.class, "com.obric.aiagent.plugin")};
        INSTANCE = new InitContext();
        isMainProcess$delegate = g.a((a) ZeusTransformUtils.preCheckCast(AnonymousClass2.INSTANCE, a.class, "com.obric.aiagent.plugin"));
        processName$delegate = g.a((a) ZeusTransformUtils.preCheckCast(InitContext$processName$2.INSTANCE, a.class, "com.obric.aiagent.plugin"));
        commonParams = new ConcurrentHashMap();
    }

    private InitContext() {
    }

    public final ConcurrentHashMap<Object, Object> getCommonParams() {
        return commonParams;
    }

    public static final Activity getMainActivity() {
        return (Activity) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(InitScheduler.getMainActivity$initscheduler_release(), "com.obric.aiagent.plugin"), Activity.class, "com.obric.aiagent.plugin");
    }

    public static final Activity getSplashActivity() {
        return (Activity) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(InitScheduler.getSplashActivity$initscheduler_release(), "com.obric.aiagent.plugin"), Activity.class, "com.obric.aiagent.plugin");
    }

    public static final void setCommonParams(Object r3, Object r4) {
        o.d(r3, "key");
        o.d(r4, "value");
        ((Map) ZeusTransformUtils.preCheckCast(commonParams, Map.class, "com.obric.aiagent.plugin")).put(r3, r4);
    }

    public static final Object getCommonParams(Object r1) {
        o.d(r1, "key");
        return commonParams.get(r1);
    }
}
