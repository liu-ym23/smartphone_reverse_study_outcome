package com.bytedance.lego.init;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.a.a;
import d.h.b.o;
import d.x;

/* JADX INFO: compiled from: InitSchedulerExecutors.kt */
/* JADX INFO: loaded from: classes.dex */
public final class InitSchedulerExecutorsKt {
    public static final void singleAsync(a<x> r3) {
        final a r4 = (a) ZeusTransformUtils.wrapperContextForParams(r3, a.class, "com.obric.aiagent.plugin");
        o.d(r4, "runnable");
        InitSchedulerExecutors.INSTANCE.getThreadPoolExecutor$initscheduler_release().execute((Runnable) ZeusTransformUtils.preCheckCast(new InitSchedulerExecutorsKt$sam$java_lang_Runnable$0(r4), Runnable.class, "com.obric.aiagent.plugin"));
    }
}
