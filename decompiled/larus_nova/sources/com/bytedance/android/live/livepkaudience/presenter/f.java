package com.bytedance.android.live.livepkaudience.presenter;

import com.bytedance.android.live.livepkaudience.dialog.BasePkAudienceApplyListContract$View;
import io.reactivex.functions.Consumer;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes46.dex */
public final class f<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ b f82149a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Function1 f82150b;

    public f(b r100, Function1 r101) {
        this.f82149a = r100;
        this.f82150b = r101;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        BasePkAudienceApplyListContract$View r101 = (BasePkAudienceApplyListContract$View) this.f82149a.f81800b;
        r101.Z90((Throwable) r100);
    }
}
