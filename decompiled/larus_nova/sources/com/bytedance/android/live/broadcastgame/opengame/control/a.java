package com.bytedance.android.live.broadcastgame.opengame.control;

import com.bytedance.android.livesdkapi.eventbus.LiveRealStartEvent;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
public final class a<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ OpenPlatformControlService.e f59863a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Function0 f59864b;

    public a(OpenPlatformControlService.e r100, Function0 r101) {
        this.f59863a = r100;
        this.f59864b = r101;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        LiveRealStartEvent r101 = (LiveRealStartEvent) r100;
        if (Intrinsics.areEqual(r101.mEnterFrom, "toybox") == true) goto L5;
        return;
    L5:
        if (r101.isVerified() == false) goto L12;
        Disposable r102 = this.f59863a.f59857a;
        if (r102 == null) goto L9;
        r102.dispose();
    L9:
        this.f59864b.invoke();
        return;
    }
}
