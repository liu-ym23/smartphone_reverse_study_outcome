package com.bytedance.android.livesdk.livecommerce.intro.utils;

import android.os.SystemClock;
import com.bytedance.android.livesdk.livecommerce.intro.model.resp.LiveIntroResponse;
import com.bytedance.android.livesdk.livecommerce.utils.UtilityKotlinExtentionsKt;
import io.reactivex.functions.Consumer;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes10.dex */
public final class h<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ f f148542a;

    public h(f r100) {
        this.f148542a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        LiveIntroResponse r101 = (LiveIntroResponse) r100;
        dm.a.a("IntroCardLoadOpt").a("v2, preloadIntroCard success");
        this.f148542a.f148533c = Long.valueOf(SystemClock.elapsedRealtime());
        f r102 = this.f148542a;
        r102.f148531a = false;
        if (r101 == null) goto L5;
        f.f148530o.getClass();
        f.a.a(r101);
        Unit r103 = Unit.INSTANCE;
    L6:
        r102.f148534d = r101;
        this.f148542a.f148535e = true;
        Function1<? super LiveIntroResponse, Unit> r104 = this.f148542a.f148537g;
        if (r104 == null) goto L9;
        UtilityKotlinExtentionsKt.f153057b.postAtFrontOfQueue(new g(r104, this));
    L9:
        this.f148542a.f148537g = null;
        return;
    L5:
        r101 = null;
        goto L6
    }
}
