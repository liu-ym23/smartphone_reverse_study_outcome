package com.ss.android.deviceregister;

import android.content.Context;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: DeprecatedFileCleaner.java */
/* JADX INFO: loaded from: classes4.dex */
class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f37409a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final boolean f37410b;

    static /* synthetic */ boolean a(c r0) {
        return r0.f37410b;
    }

    static /* synthetic */ Context b(c r0) {
        return r0.f37409a;
    }

    c(Context r3, boolean r4) {
        this.f37409a = ZeusTransformUtils.wrapperContext((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin"), "com.obric.aiagent.plugin");
        this.f37410b = r4;
    }

    void a() {
        Runnable r0 = new AnonymousClass1(this);
        com.bytedance.common.utility.a.a.c().submit(r0);
    }
}
