package com.bytedance.android.livesdk.livecommerce.promotion.card;

import android.view.View;
import java.util.Map;

/* JADX INFO: loaded from: classes10.dex */
public interface b {

    public static final class a {
        public static /* synthetic */ View a(b r100) {
            return r100.F0(PromotionCardModuleName.Parent);
        }

        public static /* synthetic */ void b(b r100, com.bytedance.android.ec.common.api.jump.model.g r101) {
            r100.A1(r101, UpdateType.UPDATE_ALL);
        }
    }

    void A1(com.bytedance.android.ec.common.api.jump.model.g r100, UpdateType r101);

    View F0(PromotionCardModuleName r100);

    com.bytedance.android.ec.common.api.jump.model.g Y0();

    Map<PromotionCardModuleName, IPromotionUIConfig.d> getUIConfig();

    void release();

    void w2(Map<PromotionCardModuleName, IPromotionUIConfig.d> r100);
}
