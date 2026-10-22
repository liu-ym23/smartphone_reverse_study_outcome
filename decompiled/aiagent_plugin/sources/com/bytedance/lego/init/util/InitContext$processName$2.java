package com.bytedance.lego.init.util;

import com.bytedance.lego.init.InitScheduler;
import com.bytedance.lego.init.config.TaskConfig;
import d.h.a.a;
import d.h.b.p;

/* JADX INFO: compiled from: InitContext.kt */
/* JADX INFO: loaded from: classes.dex */
final class InitContext$processName$2 extends p implements a<String> {
    public static final InitContext$processName$2 INSTANCE = null;

    static {
        INSTANCE = new InitContext$processName$2();
    }

    InitContext$processName$2() {
        super(0);
    }

    @Override // d.h.a.a
    public /* bridge */ /* synthetic */ String invoke() {
        return invoke2();
    }

    @Override // d.h.a.a
    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final String invoke2() {
        TaskConfig r0 = InitScheduler.INSTANCE.getConfig$initscheduler_release();
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getProcessName();
    }
}
