package com.bytedance.android.livesdk.livecommerce.promotion.cardV2;

import android.view.View;
import com.bytedance.android.btm.api.model.BtmItemBuilder;
import com.bytedance.android.ec.model.response.j0;
import com.bytedance.android.livesdk.livecommerce.actionrecord.node.Action;
import com.bytedance.android.livesdk.livecommerce.promotion.cardV2.component.PromotionCardButtonComponent$addCartListener$1;

/* JADX INFO: loaded from: classes10.dex */
public interface a {

    /* JADX INFO: renamed from: com.bytedance.android.livesdk.livecommerce.promotion.cardV2.a$a, reason: collision with other inner class name */
    public static final class C2321a {
        public static /* synthetic */ Long a(a r100, long r101, long r110) {
            return r100.d(r101, r110, false, false);
        }

        public static /* synthetic */ void c(a r100, String r101, String r102, View r110, int r111) {
            if ((r111 & 2) == 0) goto L5;
            boolean r103 = true;
        L7:
            if ((r111 & 16) == 0) goto L9;
            r110 = null;
        L9:
            r100.a(r101, r103, r102, null, r110);
            return;
        L5:
            r103 = false;
            goto L7
        }

        public static /* synthetic */ void b(a r110, String r111, Integer r112, j0 r113, int r114, PromotionCardButtonComponent$addCartListener$1 r115, com.bytedance.android.btm.api.model.d r116, il2.a r117, int r118) {
            if ((r118 & 8) == 0) goto L5;
            int r100 = 0;
        L7:
            if ((r118 & 32) == 0) goto L9;
            PromotionCardButtonComponent$addCartListener$1 r101 = null;
        L10:
            r110.c(r111, r112, r113, r100, 0, r101, r116, r117);
            return;
        L9:
            r101 = r115;
            goto L10
        L5:
            r100 = r114;
            goto L7
        }
    }

    void a(String r100, boolean r101, String r102, BtmItemBuilder r103, View r104);

    LivePromotionCardV2$containerAbility$1$eventAction$1 b();

    void c(String r100, Integer r101, j0 r102, int r103, int r104, cf.a r105, com.bytedance.android.btm.api.model.d r106, il2.a r107);

    Long d(long r100, long r101, boolean r102, boolean r103);

    void e(Action r100);

    boolean f(View r100);
}
