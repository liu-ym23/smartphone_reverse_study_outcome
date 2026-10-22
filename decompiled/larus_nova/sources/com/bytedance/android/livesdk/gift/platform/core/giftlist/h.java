package com.bytedance.android.livesdk.gift.platform.core.giftlist;

import com.bytedance.android.livesdk.gift.model.w1;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.repo.MostlyUsedGiftOperateAction;
import com.bytedance.android.livesdk.gift.platform.core.model.ReceiverType;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes9.dex */
public interface h extends dy0.d {
    void Kg();

    Map<ReceiverType, com.bytedance.android.livesdk.gift.platform.core.model.l> M4();

    com.bytedance.android.livesdk.gift.platform.core.model.j Mn(ReceiverType r100);

    void N(long r100, int r101, @MostlyUsedGiftOperateAction int r102, ReceiverType r103);

    boolean Si();

    void lm(ReceiverType r100, com.bytedance.android.livesdk.gift.platform.core.model.l r101, List<k> r102, List<k> r103, int r104, String r105);

    void t1(ReceiverType r100, Integer r101, Long r102, com.bytedance.android.livesdk.gift.platform.core.model.l r103, List<k> r104, List<k> r105, int r106, String r107);

    List<Long> vb(ReceiverType r100);

    w1 ve(ReceiverType r100, int r101);
}
