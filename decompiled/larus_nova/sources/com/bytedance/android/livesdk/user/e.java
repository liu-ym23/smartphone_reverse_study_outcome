package com.bytedance.android.livesdk.user;

import android.content.Context;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.base.model.user.UserAttr;
import com.bytedance.android.live.base.model.user.UserEvent;
import com.bytedance.android.live.base.model.user.UserExtra;
import com.bytedance.android.live.network.response.BaseResponse;
import com.bytedance.android.livesdk.jsbridge.methods.v4;
import com.bytedance.android.livesdk.jsbridge.methods.w4;
import com.bytedance.android.livesdkapi.depend.model.follow.FollowPair;
import com.bytedance.android.livesdkapi.depend.model.live.follow.IFollowPair;
import io.reactivex.Flowable;
import io.reactivex.Observable;
import io.reactivex.Single;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes11.dex */
public interface e {
    Observable A(m r100);

    Observable B(b r100);

    void C(v4 r100, Context r101, String r102, String r103, w4 r104);

    void D(IBaseUser r100);

    boolean E(Long r100);

    void F(IBaseUser r100, boolean r101);

    boolean H();

    String a(String r100);

    IBaseUser b();

    boolean c();

    Single<BaseResponse<IBaseUser, UserExtra>> d(HashMap<String, String> r100);

    Observable<? extends IFollowPair> e(d r100);

    void f(py.t r100);

    Observable<? extends IFollowPair> followStateChanged();

    boolean g(LiveInteractFunction r100);

    String getSessionKey();

    Observable<? extends IFollowPair> h(b r100);

    Observable<? extends IFollowPair> i(m r100);

    boolean isAdmin();

    boolean isLogin();

    Single<? extends IBaseUser> j();

    Single<BaseResponse<IBaseUser, UserExtra>> k(String r100);

    Observable<IBaseUser> login(Context r100, l r101);

    Flowable<UserEvent> m();

    String n();

    Single<BaseResponse<IBaseUser, UserExtra>> o(HashMap<String, String> r100);

    Observable<? extends IBaseUser> p();

    UserAttr q();

    void setRoomAttrsAdminFlag(int r100);

    boolean t(Long r100);

    Observable<? extends UserAttr> u();

    Observable<FollowPair> u0(String r100);

    Single<BaseResponse<IBaseUser, UserExtra>> v(Map<String, String> r100, Map<String, String> r101);

    Flowable<UserEvent> x();

    IBaseUser y();
}
