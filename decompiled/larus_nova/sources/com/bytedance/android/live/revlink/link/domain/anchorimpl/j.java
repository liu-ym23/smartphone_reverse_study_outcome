package com.bytedance.android.live.revlink.link.domain.anchorimpl;

import com.bytedance.android.livesdk.revenue.user.RevLiveFollowScene;
import io.reactivex.disposables.Disposable;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes47.dex */
public interface j {
    void a(boolean r100);

    Disposable b(String r100, String r101, Function0<Unit> r102, Function1<? super Throwable, Unit> r103);

    void d(b r100);

    Disposable e(String r100, RevLiveFollowScene r101, Function0<Unit> r102, Function1<? super Throwable, Unit> r103);

    void g();

    com.bytedance.android.live.revlink.impl.multianchor.widget.h h();

    void j(f31.f r100);
}
