package com.bytedance.android.livesdk.chatroom.vs_host.business;

import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.base.model.user.User;
import com.bytedance.android.livesdk.chatroom.ui.LiveProfileAnonymousFragment;

/* JADX INFO: loaded from: classes8.dex */
public final class q implements wr1.e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LiveProfileAnonymousFragment f118280a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ IBaseUser f118281b;

    @Override // wr1.e
    public final void a(IBaseUser r100) {
        this.f118280a.S90((User) com.bytedance.android.live.base.model.m.b(r100, User.class));
    }

    public q(String r100, String r101, IBaseUser r102, long r103, boolean r104) {
        this.f118281b = r102;
        User r105 = (User) com.bytedance.android.live.base.model.m.b(r102, User.class);
        LiveProfileAnonymousFragment r106 = new LiveProfileAnonymousFragment();
        r106.f112277j = r100;
        r106.f112278k = r101;
        r106.f112279l = r103;
        r106.f112276i = r105;
        r106.f112280m = r104;
        this.f118280a = r106;
    }
}
