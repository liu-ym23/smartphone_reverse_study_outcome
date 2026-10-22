package com.bytedance.android.live.broadcastgame.api.interactgame;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import com.larus.apm.impl.protector.RunnableProtector;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
public final class e implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ d f59304a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Context f59305b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ long f59306c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ View f59307d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ boolean f59308e;

    public e(d r100, Context r101, long r102, View r103, boolean r104) {
        this.f59304a = r100;
        this.f59305b = r101;
        this.f59306c = r102;
        this.f59307d = r103;
        this.f59308e = r104;
    }

    public final void a() {
        c r100 = this.f59304a.f59301a;
        if (r100 == null) goto L11;
        String r101 = r100.b();
        if (r101 == null) goto L12;
        Context r102 = this.f59305b;
        if (r102 == null) goto L10;
        c90.a.C0416a r103 = new c90.a.C0416a((Activity) r102);
        r103.f22797f = true;
        Intrinsics.checkNotNullParameter(r101, "str");
        r103.f22801j = r101;
        r103.f22796e = this.f59306c;
        r103.f22793b = false;
        r103.f22809r = false;
        c90.a r104 = new c90.a(r103);
        r104.f();
        r104.i(this.f59307d, 48, this.f59308e);
        this.f59304a.f59301a = null;
        return;
    L10:
        throw new NullPointerException("null cannot be cast to non-null type android.app.Activity");
    L12:
        return;
    }

    @Override // java.lang.Runnable
    public final void run() {
        a();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
