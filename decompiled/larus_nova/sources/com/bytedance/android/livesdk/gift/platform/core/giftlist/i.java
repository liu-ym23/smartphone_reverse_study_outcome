package com.bytedance.android.livesdk.gift.platform.core.giftlist;

import com.bytedance.android.livesdk.gift.model.h1;
import com.bytedance.android.livesdk.gift.model.w1;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.repo.MostlyUsedGiftOperateAction;
import com.bytedance.android.livesdk.gift.platform.core.model.ReceiverType;
import com.bytedance.android.livesdk.gift.util.GiftListFetchAction;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes9.dex */
public interface i extends dy0.c {
    void F(List<? extends h1> r100);

    String F5(int r100);

    void J2(com.bytedance.android.livesdk.gift.platform.core.model.i r100, int r101, int r102, boolean r103, List<? extends w1> r104, ReceiverType r105, boolean r106, List<Long> r107, Integer r108, long r110, long r111, String r112);

    GiftListFetchAction K3(int r100);

    void N(long r100, int r101, @MostlyUsedGiftOperateAction int r102, ReceiverType r103);

    int N0();

    com.bytedance.android.livesdk.gift.platform.core.model.j N3();

    void R(int r100);

    w1 U(int r100);

    void X(h1 r100);

    long c5();

    h1 d(String r100);

    py.k f3();

    Map<String, String> getExtraParam();

    List<h1> getStickerGifts();

    void h3(Map<Integer, com.bytedance.android.livesdk.gift.platform.core.model.i> r100);

    boolean isGiftListLoaded();

    com.bytedance.android.livesdk.gift.platform.core.model.d j0();

    Map<String, Long> n3();

    com.bytedance.android.livesdk.gift.platform.core.model.l n5();

    h1 o4(long r100, Integer r101);

    List<com.bytedance.android.livesdk.gift.platform.core.model.e> q();

    void s5(List<? extends h1> r100);

    void y(List<? extends h1> r100);

    h1 y3(long r100);

    h1 z1(long r100, Integer r101);
}
