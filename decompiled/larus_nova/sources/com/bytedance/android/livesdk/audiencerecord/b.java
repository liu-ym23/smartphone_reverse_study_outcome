package com.bytedance.android.livesdk.audiencerecord;

import com.bytedance.android.livesdk.audiencerecord.api.BacktrackState;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes7.dex */
public final class b<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ BacktrackServiceImp f104042a;

    public b(BacktrackServiceImp r100) {
        this.f104042a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        BacktrackServiceImp r101 = (BacktrackServiceImp) r100;
        this.f104042a.f103977a.e(0.0f);
        this.f104042a.f103977a.f(BacktrackState.TIMEOUT);
    }
}
