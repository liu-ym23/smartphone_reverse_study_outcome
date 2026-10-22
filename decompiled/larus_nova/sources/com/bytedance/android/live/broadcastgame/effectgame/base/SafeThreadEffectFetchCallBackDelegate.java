package com.bytedance.android.live.broadcastgame.effectgame.base;

import android.os.Handler;
import android.os.Looper;
import com.bytedance.android.livesdkapi.depend.model.Sticker;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.ugc.effectmanager.common.task.ExceptionResult;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
public final class SafeThreadEffectFetchCallBackDelegate implements com.bytedance.android.live.broadcastgame.effectgame.base.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Lazy f59605a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final com.bytedance.android.live.broadcastgame.effectgame.base.a f59606b;

    public static final class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function0 f59607a;

        public a(Function0 r100) {
            this.f59607a = r100;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.f59607a.invoke();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public SafeThreadEffectFetchCallBackDelegate(com.bytedance.android.live.broadcastgame.effectgame.base.a r100) {
        Intrinsics.checkNotNullParameter(r100, "callBack");
        this.f59606b = r100;
        this.f59605a = LazyKt.lazy(SafeThreadEffectFetchCallBackDelegate$handler$2.INSTANCE);
    }

    public final void e(Function0<Unit> r100) {
        if ((!Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper())) == false) goto L5;
        ((Handler) this.f59605a.getValue()).post(new a(r100));
        return;
    L5:
        r100.invoke();
    }

    @Override // com.bytedance.android.live.broadcastgame.effectgame.base.a
    public final void c(final int r100, final Sticker r101) {
        Intrinsics.checkNotNullParameter(r101, "sticker");
        e(new SafeThreadEffectFetchCallBackDelegate$onStart$1(this, r100, r101));
    }

    @Override // com.bytedance.android.live.broadcastgame.effectgame.base.a
    public final void d(final int r100, final Sticker r101, final ExceptionResult r102) {
        Intrinsics.checkNotNullParameter(r101, "sticker");
        e(new SafeThreadEffectFetchCallBackDelegate$onFail$1(this, r100, r101, r102));
    }

    @Override // com.bytedance.android.live.broadcastgame.effectgame.base.a
    public final void a(final int r100, final boolean r101, final int r110, final Sticker r111) {
        Intrinsics.checkNotNullParameter(r111, "sticker");
        e(new SafeThreadEffectFetchCallBackDelegate$onSuccess$1(this, r100, r101, r110, r111));
    }

    @Override // com.bytedance.android.live.broadcastgame.effectgame.base.a
    public final void b(final int r100, final int r110, final long r111, final Sticker r112) {
        Intrinsics.checkNotNullParameter(r112, "sticker");
        e(new SafeThreadEffectFetchCallBackDelegate$onProgress$1(this, r100, r110, r111, r112));
    }
}
