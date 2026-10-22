package com.bytedance.android.livesdk.revenue.service.interactivity;

import android.content.Context;
import com.bytedance.android.livesdk.gift.model.p2;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.live.datacontext.m;
import io.reactivex.disposables.Disposable;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import py.k;

/* JADX INFO: loaded from: classes11.dex */
public interface b extends dy0.a {
    Integer B();

    Integer Dh();

    void Jk(RevMockMessageSource r100, p2 r101);

    void W9();

    m<Integer> Wc();

    void Xn();

    Boolean a0();

    void fk(Context r100, String r101);

    m<Integer> getHotMsgTrayPos();

    m<hq2.c> getMatchRoomMsgTrayPos();

    m<Integer> hj(DataCenter r100);

    Integer mj();

    void og();

    Integer t8();

    Disposable xn(Function1<? super e, Unit> r100);

    hq2.d ya();

    void ze(String r100, boolean r101, k r102, String r103, int r104, long r105, String r106, boolean r107, boolean r110, long r111);
}
