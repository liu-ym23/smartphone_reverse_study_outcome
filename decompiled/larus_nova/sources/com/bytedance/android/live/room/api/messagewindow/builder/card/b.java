package com.bytedance.android.live.room.api.messagewindow.builder.card;

import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Function0<Unit> f98965a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f98966b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final CommonCardBuilder.b f98967c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final CommonCardBuilder.a f98968d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final CommonCardBuilder.d f98969e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final CommonCardBuilder.c f98970f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public String f98971g;

    public final void a() {
        Function0<Unit> r100 = this.f98965a;
        if (r100 == null) goto L6;
        Unit r101 = r100.invoke();
        return;
    }

    public final int getType() {
        return this.f98966b;
    }

    public b(int r100, CommonCardBuilder.b r101, CommonCardBuilder.a r102, CommonCardBuilder.d r103, CommonCardBuilder.c r104) {
        Intrinsics.checkNotNullParameter(r101, "failCallback");
        Intrinsics.checkNotNullParameter(r102, "animCallback");
        Intrinsics.checkNotNullParameter(r103, "lifeCycleCallback");
        Intrinsics.checkNotNullParameter(r104, "hideReasonCallback");
        this.f98966b = r100;
        this.f98967c = r101;
        this.f98968d = r102;
        this.f98969e = r103;
        this.f98970f = r104;
        this.f98971g = null;
    }
}
