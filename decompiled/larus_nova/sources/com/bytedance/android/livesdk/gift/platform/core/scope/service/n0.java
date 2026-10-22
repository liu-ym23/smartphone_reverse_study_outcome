package com.bytedance.android.livesdk.gift.platform.core.scope.service;

import io.reactivex.SingleEmitter;
import io.reactivex.SingleOnSubscribe;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: classes9.dex */
public final class n0<T> implements SingleOnSubscribe {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ m0 f131648a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ long f131649b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Ref.ObjectRef f131650c;

    public n0(m0 r100, long r101, Ref.ObjectRef r102) {
        this.f131648a = r100;
        this.f131649b = r101;
        this.f131650c = r102;
    }

    @Override // io.reactivex.SingleOnSubscribe
    public final void subscribe(SingleEmitter<Boolean> r100) {
        Intrinsics.checkNotNullParameter(r100, "it");
        m0.a(this.f131648a, this.f131649b, (sz1.a) this.f131650c.element, null);
        r100.onSuccess(Boolean.TRUE);
    }
}
