package com.bytedance.android.livesdk.vscore_api.paidlive;

import com.bytedance.android.live.platformplayer.layout.b0;
import com.bytedance.android.livesdk.vscore_api.paid.PaidSceneEnum;
import com.bytedance.android.livesdk.vscore_api.paid.PaidSceneViewEntry;
import com.bytedance.android.livesdk.vscore_api.paidlive.model.PaidSceneContext;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.scope.o;

/* JADX INFO: loaded from: classes11.dex */
public interface e extends o, Comparable<e> {
    void D();

    void I6(Class<? extends com.bytedance.android.livesdk.vscore_api.paidlive.ability.g> r100, com.bytedance.android.livesdk.vscore_api.paidlive.ability.g r101);

    PaidSceneContext Xb();

    void bb(b0 r100);

    <T extends com.bytedance.android.livesdk.vscore_api.paidlive.ability.g> T getAbility(Class<? extends com.bytedance.android.livesdk.vscore_api.paidlive.ability.g> r100);

    PaidSceneEnum i0();

    void j9(Room r100);

    PaidSceneViewEntry k5();

    boolean kh();

    l o2();

    void onDestroy();

    void onInit();

    int pk();

    void v0(long r100);

    Boolean vf();

    void z(IRoom r100);
}
