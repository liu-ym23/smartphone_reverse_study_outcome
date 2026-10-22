package com.bytedance.android.livesdk.livecommerce.intro.utils;

import android.os.SystemClock;
import com.bytedance.android.livesdk.livecommerce.intro.model.resp.LiveIntroResponse;
import io.reactivex.functions.Consumer;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes10.dex */
public final class i<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ f f148543a;

    public i(f r100) {
        this.f148543a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        Throwable r101 = (Throwable) r100;
        dm.a.a("IntroCardLoadOpt").a("v2, preloadIntroCard error");
        f r102 = this.f148543a;
        r102.f148533c = Long.valueOf(SystemClock.elapsedRealtime());
        f r103 = this.f148543a;
        r103.f148531a = false;
        r103.f148535e = false;
        Function1<? super LiveIntroResponse, Unit> r104 = this.f148543a.f148537g;
        if (r104 == null) goto L5;
        Unit r105 = r104.invoke(null);
    L5:
        this.f148543a.f148537g = null;
    }
}
