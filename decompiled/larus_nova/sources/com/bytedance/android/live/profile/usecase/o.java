package com.bytedance.android.live.profile.usecase;

import com.bytedance.android.live.base.model.user.NewProfileUser;
import com.bytedance.android.live.network.response.Response;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes47.dex */
public final class o<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ n f87039a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ boolean f87040b;

    public o(n r100, boolean r101) {
        this.f87039a = r100;
        this.f87040b = r101;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        Response r101 = (Response) r100;
        NewProfileUser r102 = this.f87039a.f87033c.getTargetUser();
        boolean r103 = this.f87040b;
        r102.isMuted = r103;
        this.f87039a.b(r103);
    }
}
