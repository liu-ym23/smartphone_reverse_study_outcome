package com.bytedance.android.shopping.anchorv4.voavhs.base.design;

import android.view.View;
import com.bytedance.android.ec.core.widget.f;
import com.bytedance.android.shopping.anchorv4.dto.base.Action;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public interface ActionHubAccessor {

    public static final class DefaultImpls {
        public static void b(ActionHubAccessor r100) {
            a r101 = r100.actionHub();
            if (r101 == null) goto L6;
            r101.l0(r100.associatedAction(), r100.descriptionVO());
            return;
        }

        public static String c(Action r100) {
            Intrinsics.checkNotNullParameter(r100, "action");
            String r101 = r100.getId();
            if (Intrinsics.areEqual(r101, "action_enter_shop") == false) goto L5;
            return "bind_key_promotion_detail_bottom";
        L5:
            if (Intrinsics.areEqual(r101, "action_im") == false) goto L7;
            return "bind_key_promotion_detail_bottom";
        L7:
            if (Intrinsics.areEqual(r101, "action_enter_cart") == false) goto L9;
            return "bind_key_promotion_detail_bottom";
        L9:
            if (Intrinsics.areEqual(r101, "action_sku") == false) goto L11;
            return "bind_key_promotion_detail_bottom";
        L11:
            if (Intrinsics.areEqual(r101, "action_buy") == true) goto L20;
            return null;
        L20:
            return "bind_key_promotion_detail_bottom";
        }

        public static void a(final ActionHubAccessor r100, final View r101, final Action r102) {
            Intrinsics.checkNotNullParameter(r101, "theView");
            if (r102 != null) goto L5;
            return;
        L5:
            String r103 = r102.getRefId();
            if (r103 == null) goto L8;
            r101.setTag(r103);
        L8:
            f.c(r101, null, r100.getOnLimitClickBindKey(r102), new ActionHubAccessor$configPossibleAction$2(r100, r102, r101, r102), 1);
        }
    }

    a actionHub();

    Action associatedAction();

    Object descriptionVO();

    void dispatchPossibleShow();

    String getOnLimitClickBindKey(Action r100);

    void setActionHub(a r100);
}
