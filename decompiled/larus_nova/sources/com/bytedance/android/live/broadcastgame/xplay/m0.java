package com.bytedance.android.live.broadcastgame.xplay;

import io.reactivex.Observable;
import io.reactivex.functions.Function;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
public final class m0<T, R> implements Function {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ XplayMainService f62275a;

    public m0(XplayMainService r100) {
        this.f62275a = r100;
    }

    @Override // io.reactivex.functions.Function
    public final Object apply(Object r100) {
        IXplayMainService.State r101 = (IXplayMainService.State) r100;
        Intrinsics.checkNotNullParameter(r101, "curState");
        if (r101 != IXplayMainService.State.Starting) goto L6;
        return this.f62275a.f61937d.flatMap(i0.f62176a).doOnNext(new j0(this));
    L6:
        if (r101 != IXplayMainService.State.StartingFailed) goto L9;
        return Observable.just(Unit.INSTANCE).doOnSubscribe(new k0(this));
    L9:
        if (r101.isAtLeast(IXplayMainService.State.Started) == false) goto L12;
        return Observable.just(Unit.INSTANCE).doOnSubscribe(new l0(this));
    L12:
        return Observable.empty();
    }
}
