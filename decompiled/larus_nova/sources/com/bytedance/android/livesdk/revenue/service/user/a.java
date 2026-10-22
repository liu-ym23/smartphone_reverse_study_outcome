package com.bytedance.android.livesdk.revenue.service.user;

import android.app.Activity;
import android.content.Context;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.base.model.user.UserEvent;
import com.bytedance.android.live.base.model.user.UserExtra;
import com.bytedance.android.live.network.response.BaseResponse;
import com.bytedance.android.livesdk.revenue.user.RevLiveFollowScene;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.follow.IFollowPair;
import com.bytedance.ies.sdk.widgets.DataCenter;
import io.reactivex.Flowable;
import io.reactivex.Observable;
import io.reactivex.Single;
import java.util.Map;

/* JADX INFO: loaded from: classes11.dex */
public interface a extends dy0.a, com.bytedance.live.kmp.core.c {
    void A3(String r100, Map r101);

    ds2.e Je();

    Map<String, String> Kh(RevLiveFollowScene r100);

    void Sc(DataCenter r100);

    c Tk();

    Single<BaseResponse<IBaseUser, UserExtra>> W1(Map<String, String> r100);

    IBaseUser b();

    Observable<Integer> ff(String r100);

    Observable<IFollowPair> followStateChanged();

    Observable<IBaseUser> g2(Context r100, ds2.b r101);

    String getCurrentUserId();

    boolean interceptOperation(String r100);

    boolean isLogin();

    Flowable<UserEvent> m();

    void markAsOutOfDate(boolean r100);

    Observable<IFollowPair> om(Context r100, IRoom r101, ds2.c r102);

    Observable<IBaseUser> p();

    void p8(DataCenter r100);

    Observable<ds2.d> pl();

    Single<BaseResponse<IBaseUser, UserExtra>> r(String r100);

    Observable<IFollowPair> rl(String r100, long r101, Activity r102, Map<String, String> r103);

    Single<IBaseUser> tm(String r100);

    Observable<IFollowPair> u0(String r100);

    void xh(IBaseUser r100);
}
