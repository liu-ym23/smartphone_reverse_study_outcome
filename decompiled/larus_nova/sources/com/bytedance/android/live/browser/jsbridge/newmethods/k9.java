package com.bytedance.android.live.browser.jsbridge.newmethods;

import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.ies.web.jsbridge2.CallContext;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes45.dex */
public final class k9<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ m9 f63508a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ w20.vc f63509b;

    public k9(m9 r100, w20.vc r101, CallContext r102) {
        this.f63508a = r100;
        this.f63509b = r101;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        IBaseUser r101 = (IBaseUser) r100;
        this.f63508a.j(this.f63509b);
    }
}
