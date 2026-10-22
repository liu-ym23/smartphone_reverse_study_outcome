package com.bytedance.android.livesdk.livecommerce.room.widgets.bottom_right;

import android.content.Context;
import com.bytedance.android.ec.model.promotion.ECUIPromotion;
import com.bytedance.android.ec.model.response.s;
import com.bytedance.android.livesdk.livecommerce.room.controller.business.RoomContextController;
import com.bytedance.android.livesdk.livecommerce.room.widgets.promotion_card.refactor.ExplainCardViewModel;
import java.util.Map;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes10.dex */
public interface i {

    public static final class a {
        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ void a(i r100, Function1 r101, boolean r110, s r111, int r112) {
            if ((r112 & 2) == 0) goto L6;
            r101 = null;
        L6:
            if ((r112 & 4) == 0) goto L8;
            boolean r102 = false;
        L10:
            if ((r112 & 16) == 0) goto L12;
            s r103 = null;
        L13:
            r100.p(null, r101, r102, null, r103, null, null);
            return;
        L12:
            r103 = r111;
            goto L13
        L8:
            r102 = r110;
            goto L10
        }
    }

    void b();

    void f(ECUIPromotion r100);

    fk2.a g();

    void h(String r100, long r101);

    RoomContextController i();

    ExplainCardViewModel j();

    void k(String r100, String r101, boolean r102);

    Context n();

    void o(ECUIPromotion r100, boolean r101, String r102, Function1<? super ECUIPromotion, Unit> r103);

    void p(String r100, Function1<? super ECUIPromotion, Unit> r101, boolean r102, Pair<Long, Long> r103, s r104, String r105, Map<String, String> r106);

    void q(String r100, long r101);

    void r();
}
