package com.obric.memorydata.sdk;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.f;
import d.g;

/* JADX INFO: compiled from: MemorySdkUtils.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f33832a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final f f33833b = null;

    /* JADX INFO: renamed from: lambda$0_-8CKSUfqfiWDsVMwkJYDOuRTQ, reason: not valid java name */
    public static /* synthetic */ Gson m953lambda$0_8CKSUfqfiWDsVMwkJYDOuRTQ() {
        return b();
    }

    private b() {
    }

    static {
        f33832a = new b();
        f33833b = g.a($$Lambda$b$0_8CKSUfqfiWDsVMwkJYDOuRTQ.INSTANCE);
    }

    public final Gson a() {
        return (Gson) ZeusTransformUtils.preCheckCast(f33833b.b(), Gson.class, "com.obric.aiagent.plugin");
    }

    private static final Gson b() {
        return new GsonBuilder().create();
    }
}
