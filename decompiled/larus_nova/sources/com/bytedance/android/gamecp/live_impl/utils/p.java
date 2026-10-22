package com.bytedance.android.gamecp.live_impl.utils;

import com.larus.apm.impl.protector.RunnableProtector;
import kotlin.Pair;
import kotlin.jvm.functions.Function3;

/* JADX INFO: loaded from: classes44.dex */
public final class p implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Function3 f58095a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ PromoteCardLoadOpt f58096b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ com.bytedance.android.gamecp.host_api.model.introducecard.g f58097c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ boolean f58098d;

    public p(Function3 r100, PromoteCardLoadOpt r101, com.bytedance.android.gamecp.host_api.model.introducecard.g r102, boolean r103) {
        this.f58095a = r100;
        this.f58096b = r101;
        this.f58097c = r102;
        this.f58098d = r103;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f58095a.invoke(this.f58097c, Boolean.valueOf(this.f58098d), new Pair(Long.valueOf(this.f58096b.f58062f), Long.valueOf(this.f58096b.f58063g)));     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
