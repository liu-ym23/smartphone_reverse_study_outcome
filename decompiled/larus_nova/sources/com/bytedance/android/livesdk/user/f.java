package com.bytedance.android.livesdk.user;

import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.base.model.user.IUser;
import com.bytedance.android.live.base.model.user.UserEvent;
import com.bytedance.android.live.base.model.user.UserExtra;
import com.bytedance.android.live.network.response.BaseResponse;
import com.bytedance.android.livesdkapi.depend.model.follow.FollowPair;
import io.reactivex.Flowable;
import io.reactivex.Observable;
import io.reactivex.Single;
import java.util.HashMap;

/* JADX INFO: loaded from: classes11.dex */
public interface f extends e, g {
    Observable<FollowPair> G(n r100);

    Observable<FollowPair> I(b r100);

    @Override // com.bytedance.android.livesdk.user.e
    String a(String r100);

    @Override // com.bytedance.android.livesdk.user.e
    IUser b();

    @Override // com.bytedance.android.livesdk.user.e
    boolean c();

    @Override // com.bytedance.android.livesdk.user.e
    Single<BaseResponse<IBaseUser, UserExtra>> d(HashMap<String, String> r100);

    @Override // com.bytedance.android.livesdk.user.e
    Observable<FollowPair> e(d r100);

    @Override // com.bytedance.android.livesdk.user.e
    Observable<FollowPair> followStateChanged();

    @Override // com.bytedance.android.livesdk.user.e
    boolean g(LiveInteractFunction r100);

    @Override // com.bytedance.android.livesdk.user.e
    Observable<FollowPair> h(b r100);

    @Override // com.bytedance.android.livesdk.user.e
    Observable<FollowPair> i(m r100);

    @Override // com.bytedance.android.livesdk.user.e
    boolean isAdmin();

    @Override // com.bytedance.android.livesdk.user.e
    boolean isLogin();

    @Override // com.bytedance.android.livesdk.user.e
    Single<IUser> j();

    Single<BaseResponse<IBaseUser, UserExtra>> l(String r100, String r101);

    @Override // com.bytedance.android.livesdk.user.e
    Flowable<UserEvent> m();

    @Override // com.bytedance.android.livesdk.user.e
    Observable<IUser> p();

    Single<BaseResponse<IBaseUser, UserExtra>> r(String r100);

    void s();

    void z(FollowPair r100);
}
