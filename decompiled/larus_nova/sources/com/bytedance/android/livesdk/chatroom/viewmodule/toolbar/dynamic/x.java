package com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic;

import com.larus.apm.impl.protector.RunnableProtector;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes8.dex */
public final class x implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ y f116213a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ s f116214b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Function0 f116215c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ Function1 f116216d;

    public x(y r100, s r101, Function0 r102, Function1 r103) {
        this.f116213a = r100;
        this.f116214b = r101;
        this.f116215c = r102;
        this.f116216d = r103;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f116213a.a(this.f116214b, this.f116215c, this.f116216d);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
