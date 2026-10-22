package com.bytedance.android.livesdk.summer;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import com.bytedance.android.live.core.monitor.NewBroadcastMonitor;
import com.bytedance.android.livesdkapi.service.ILiveLifecycle;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.lang.ref.WeakReference;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
public final class s extends c<View> {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public WeakReference<Context> f158496h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final WeakReference<FrameLayout> f158497i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final View[] f158498j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final int[] f158499k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final int f158500l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final int f158501m;

    public final View i() {
        Context r100 = this.f158496h.get();     // Catch: Exception -> L9
        if (r100 == null) goto L13;
        LayoutInflater r101 = LayoutInflater.from(r100);     // Catch: Exception -> L9
        if (r101 == null) goto L14;
        return r101.inflate(this.f158501m, this.f158497i.get(), false);
    L14:
        return null;
    L13:
        return null;
    L9:
        this.f158445d = -1;
        g();
        this.f158443b = null;
        this.f158444c = null;
        return null;
    }

    @Override // com.bytedance.android.livesdk.summer.c
    public final View d() {
        this.f158447f.incrementAndGet();
        int r100 = this.f158500l;
        int r101 = 0;
        View r102 = null;
        int r103 = 0;
    L4:
        if (r101 >= r100) goto L13;
        if (r102 != null) goto L11;
        int[] r104 = this.f158499k;
        if (r104[r101] != 1) goto L11;
        View[] r105 = this.f158498j;
        View r106 = r105[r101];
        if (r106 == null) goto L11;
        r104[r101] = 2;
        r105[r101] = null;
        r102 = r106;
    L11:
        r103 = r103 + this.f158499k[r101];
        r101 = r101 + 1;
        goto L4
    L13:
        if (r103 <= (((this.f158500l * 2) / 3) * 2)) goto L15;
        d.a(this);
    L15:
        if (r102 == null) goto L17;
        this.f158446e.incrementAndGet();
    L17:
        if (r102 == null) goto L19;
        return r102;
    L19:
        return i();
    }

    @Override // com.bytedance.android.livesdk.summer.c
    public final View e() {
        this.f158447f.incrementAndGet();
        int r100 = this.f158500l;
        int r101 = 0;
        View r102 = null;
        int r103 = 0;
    L4:
        if (r101 >= r100) goto L13;
        if (r102 != null) goto L11;
        int[] r104 = this.f158499k;
        if (r104[r101] != 1) goto L11;
        View[] r105 = this.f158498j;
        View r106 = r105[r101];
        if (r106 == null) goto L11;
        r104[r101] = 2;
        r105[r101] = null;
        r102 = r106;
    L11:
        r103 = r103 + this.f158499k[r101];
        r101 = r101 + 1;
        goto L4
    L13:
        if (r103 <= (((this.f158500l * 2) / 3) * 2)) goto L15;
        d.a(this);
    L15:
        if (r102 == null) goto L17;
        this.f158446e.incrementAndGet();
    L17:
        if (r102 == null) goto L19;
        return r102;
    L19:
        return i();
    }

    @Override // com.bytedance.android.livesdk.summer.c
    public final void g() {
        this.f158496h = new WeakReference(null);
    }

    public final void h() {
        int r100 = this.f158445d;
        if (r100 != (-1)) goto L6;
        return;
    L6:
        if (r100 != 1) goto L8;
        int r101 = 2;
    L9:
        this.f158445d = r101;
        Result.Companion r102 = Result.Companion;     // Catch: Throwable -> L20
        int r103 = this.f158500l;     // Catch: Throwable -> L20
        int r104 = 0;
    L11:
        if (r104 >= r103) goto L18;
        if (this.f158499k[r104] == 1) goto L17;
        if (this.f158445d == (-1)) goto L17;
        this.f158498j[r104] = i();     // Catch: Throwable -> L20
        this.f158499k[r104] = 1;     // Catch: Throwable -> L20
    L17:
        r104 = r104 + 1;     // Catch: Throwable -> L20
        goto L11
    L18:
        Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L20
    L22:
        this.f158445d = 4;
        return;
    L20:
        th = move-exception;
        Result.Companion r105 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L22
    L8:
        r101 = 3;
        goto L9
    }

    @Override // com.bytedance.android.livesdk.summer.c
    public final /* bridge */ /* synthetic */ View f() {
        return i();
    }

    @Override // com.bytedance.android.livesdk.summer.c, java.lang.Runnable
    public final void run() {
        h();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }

    @Override // com.bytedance.android.livesdk.summer.c
    public final void a(ILiveLifecycle r100) {
        Intrinsics.checkNotNullParameter(r100, NewBroadcastMonitor.STAGE.LIFECYCLE);
        super.a(r100);
    }

    @Override // com.bytedance.android.livesdk.summer.c
    public final <T> boolean b(Class<T> r100) {
        Intrinsics.checkNotNullParameter(r100, "clazz");
        if (this.f158500l > 0) goto L5;
        return false;
    L5:
        View[] r101 = this.f158498j;
        int r102 = r101.length;
        int r103 = 0;
    L6:
        if (r103 >= r102) goto L16;
        View r104 = r101[r103];
        if (r104 != null) goto L17;
        r103 = r103 + 1;
        goto L6
    L17:
        Result.Companion r105 = Result.Companion;     // Catch: Throwable -> L11
        Object r106 = Result.m9449constructorimpl(r100.cast(r104));     // Catch: Throwable -> L11
    L14:
        return Result.m9456isSuccessimpl(r106);
    L11:
        th = move-exception;
        Result.Companion r107 = Result.Companion;
        r106 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L14
    L16:
        return false;
    }

    public s(int r100, Context r101, int r102) {
        Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
        this.f158500l = r100;
        this.f158501m = r102;
        this.f158498j = new View[r100];
        int[] r103 = new int[r100];
        int r104 = 0;
    L3:
        if (r104 >= r100) goto L5;
        r103[r104] = 0;
        r104 = r104 + 1;
        goto L3
    L5:
        this.f158499k = r103;
        this.f158496h = new WeakReference(r101);
        this.f158497i = new WeakReference(new FrameLayout(r101));
        String r105 = "view:" + this.f158501m;
        Intrinsics.checkNotNullParameter(r105, "<set-?>");
        this.f158448g = r105;
    }
}
