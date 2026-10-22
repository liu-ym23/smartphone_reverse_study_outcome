package com.bytedance.android.gamecp.live_impl.animation.task;

import com.bytedance.android.gamecp.live_impl.preview.CardAnimationControllerPreView;
import com.bytedance.common.utility.Logger;
import com.ss.android.ugc.aweme.debug.LocalTestManager;
import io.reactivex.disposables.CompositeDisposable;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
public abstract class a implements g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f57809a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final CompositeDisposable f57810b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f57811c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Function0<Unit> f57812d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Function0<Unit> f57813e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final CardAnimationControllerPreView f57814f;

    public final void b() {
        if (this.f57809a == false) goto L6;
        LocalTestManager.a(new Class[]{uv.a.class});
        return;
    L6:
        Logger.i("game-promote", "讲解卡动画 动画任务执行结束 " + getClass().getSimpleName() + ' ' + this.f57814f.f57912t + '-' + this.f57814f.f57913u);
        Function0<Unit> r100 = this.f57813e;
        if (r100 == null) goto L9;
        Unit r101 = r100.invoke();
    L9:
        this.f57814f.m(true);
        this.f57810b.dispose();
        this.f57809a = true;
    }

    public a(Function0<Unit> r100, Function0<Unit> r101, CardAnimationControllerPreView r102) {
        Intrinsics.checkNotNullParameter(r102, "controllerPreView");
        this.f57812d = r100;
        this.f57813e = r101;
        this.f57814f = r102;
        this.f57810b = new CompositeDisposable();
    }
}
