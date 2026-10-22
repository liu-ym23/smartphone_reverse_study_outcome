package com.bytedance.android.livesdk.vscore_api.paidlive;

import com.bytedance.android.live.platformplayer.layout.b0;
import com.bytedance.android.livesdk.vscore_api.paid.PaidInteractEntry;
import com.bytedance.android.livesdk.vscore_api.paid.PaidSceneEnum;
import com.bytedance.android.livesdk.vscore_api.paid.PaidSceneViewEntry;
import com.bytedance.android.livesdk.vscore_api.paidlive.model.PaidSceneContext;
import com.bytedance.android.livesdk.vscore_api.paidlive.model.PaidScopeContext;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.depend.model.live.episode.Episode;
import com.bytedance.android.livesdkapi.room.error.IRoomError;
import java.util.List;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: classes11.dex */
public interface c {

    public static final class a {
        public static /* synthetic */ boolean c(c r100) {
            return r100.e1(PaidSceneEnum.ALL);
        }

        public static /* synthetic */ boolean b(c r100, PaidSceneEnum r101, int r102) {
            if ((r102 & 1) == 0) goto L6;
            r101 = PaidSceneEnum.ALL;
        L6:
            return r100.N0(r101, null);
        }

        public static /* synthetic */ void a(c r100, PaidSceneEnum r101, Map r102, int r103) {
            if ((r103 & 1) == 0) goto L6;
            r101 = PaidSceneEnum.PAID_ROOM;
        L6:
            if ((r103 & 4) == 0) goto L8;
            boolean r104 = true;
        L9:
            r100.k2(r101, r102, r104, null);
            return;
        L8:
            r104 = false;
            goto L9
        }
    }

    Map<PaidSceneEnum, e> A1();

    boolean B1();

    void C1(Function0 r100);

    Map<PaidSceneEnum, e> D2();

    <T extends e> T E1(PaidSceneEnum r100);

    boolean F0(PaidInteractEntry r100);

    b J0();

    void J1(Class<? extends pu2.d> r100, pu2.d r101);

    void K0(IRoom r100, ls2.a r101);

    Map<String, String> K1(PaidSceneEnum r100);

    int L0(PaidSceneEnum r100);

    boolean N0(PaidSceneEnum r100, List<? extends PaidSceneEnum> r101);

    void S0();

    void T0(IRoom r100, IRoomError r101);

    pu2.c V1();

    long X0(long r100, boolean r101);

    boolean Y0(PaidSceneEnum r100);

    void a(String r100, Function0<Unit> r101);

    void adaptLargeFontMode(PaidSceneViewEntry r100, boolean r101);

    void d1(b0 r100, Room r101);

    boolean d2(long r100);

    boolean e1(PaidSceneEnum r100);

    void f1(Map<String, String> r100);

    String f2(PaidSceneEnum r100);

    PaidScopeContext h1();

    boolean isDefault();

    boolean isPaidCamera();

    boolean isPaidLive();

    boolean isPaidReplay();

    void k2(PaidSceneEnum r100, Map<String, String> r101, boolean r102, Episode r103);

    boolean l1(PaidSceneEnum r100);

    void logTempMaskShow();

    com.bytedance.live.datacontext.m<l> m1(PaidSceneEnum r100);

    void m2(boolean r100);

    void p1(boolean r100);

    String r1(PaidSceneEnum r100);

    String s1(PaidSceneEnum r100);

    boolean s2();

    void setOnBuyTicketAction(Function0<Unit> r100);

    void t1(Map<String, String> r100);

    PaidSceneContext u1(PaidSceneEnum r100);

    void v0(long r100);

    PaidSceneViewEntry w0();

    <T extends pu2.d> T w1(Class<? extends pu2.d> r100);

    boolean x1();

    Map<String, String> z1(PaidSceneEnum r100);
}
