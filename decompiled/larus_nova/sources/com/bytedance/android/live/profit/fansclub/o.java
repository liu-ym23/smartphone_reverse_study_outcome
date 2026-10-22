package com.bytedance.android.live.profit.fansclub;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.ies.sdk.widgets.DataCenter;
import io.reactivex.Observable;
import java.util.Map;

/* JADX INFO: loaded from: classes47.dex */
public interface o extends dy0.d {

    public static final class a {
        public static /* synthetic */ void a(o r100, Context r101, DataCenter r102, ViewGroup r103) {
            r100.p1(r101, r102, r103, true, true);
        }
    }

    ViewGroup D5();

    void E5();

    boolean Ei(DataCenter r100);

    void Gd(int r100);

    g P5(IBaseUser r100);

    int R2();

    p Z8(FansClubEntranceParams r100);

    void ae(Context r100, DataCenter r101, ViewGroup r102, View r103, ViewGroup r104, ViewGroup r105, ViewGroup r106);

    View e1();

    com.bytedance.live.datacontext.m<? extends Map<String, String>> getExtra();

    com.bytedance.live.datacontext.m<? extends l> getFansGroupInfo();

    com.bytedance.live.datacontext.m<e> getParticipateIncentive();

    com.bytedance.live.datacontext.m<? extends g> getProfile();

    com.bytedance.live.datacontext.m<? extends Integer> getScene();

    com.bytedance.live.datacontext.m<? extends r> getShopFansClubData();

    boolean h5(DataCenter r100);

    boolean isMember();

    ViewGroup na();

    void p1(Context r100, DataCenter r101, ViewGroup r102, boolean r103, boolean r104);

    Observable<c> r1();

    ViewGroup yl();
}
