package com.bytedance.android.livesdk.chatroom.viewmodule;

import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import java.util.concurrent.TimeUnit;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
public final class f1 implements x2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f115247a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final CompositeDisposable f115248b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Function1<Long, Unit> f115249c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final long f115250d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final TimeUnit f115251e;

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.x2
    public final void a() {
        if (this.f115247a == false) goto L5;
        return;
    L5:
        this.f115247a = true;
        com.bytedance.android.live.core.utils.rxutils.j.a r100 = com.bytedance.android.live.core.utils.rxutils.j.f66356a;
        RxUtilKt.c(com.bytedance.android.live.core.utils.rxutils.j.a(0, this.f115250d, this.f115251e).filter(new a1(this)).doOnDispose(new b1(this)).doOnComplete(new c1(this)).observeOn(AndroidSchedulers.mainThread()).subscribe(new d1(this), new e1(this)), this.f115248b);
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.x2
    public final void b() {
        this.f115248b.clear();
        this.f115247a = false;
    }

    public f1(Function1 r100, long r101) {
        TimeUnit r102 = TimeUnit.MILLISECONDS;
        Intrinsics.checkNotNullParameter(r100, "task");
        Intrinsics.checkNotNullParameter(r102, "timeUnit");
        this.f115249c = r100;
        this.f115250d = r101;
        this.f115251e = r102;
        this.f115248b = new CompositeDisposable();
    }
}
