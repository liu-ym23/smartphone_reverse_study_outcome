package com.bytedance.android.livesdk.user;

import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.base.model.user.UserEvent;

/* JADX INFO: loaded from: classes11.dex */
public final class i0 implements od1.a.InterfaceC7035a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ j0.a f158672a;

    public final void a() {
        j0 r100 = this.f158672a.f158674a;
        r100.f158657g.onNext(new UserEvent(IBaseUser.Status.Login, r100.f158651a));
    }

    public i0(j0.a r100) {
        this.f158672a = r100;
    }
}
