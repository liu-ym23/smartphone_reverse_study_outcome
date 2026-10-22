package com.bytedance.android.livesdk.gift.banner;

import android.content.Context;
import android.view.View;
import com.bytedance.android.livesdk.gift.model.l2;
import com.bytedance.android.livesdk.gift.platform.business.dialog.ui.panel.AbsPanel;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v2.view.SimpleGiftViewHolder;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes9.dex */
public class PopularCardViewHolder extends SimpleGiftViewHolder {
    @Override // com.bytedance.android.livesdk.gift.platform.business.dialog.v2.view.SimpleGiftViewHolder, com.bytedance.android.livesdk.gift.platform.business.dialog.v2.view.BaseLiveGiftViewHolder
    public final void T3(AbsPanel r100) {
        super.T3(r100);
        Context r101 = this.itemView.getContext();
        if (r101 != null) goto L5;
        return;
    L5:
        T r102 = r100.f126620h;
        if ((r102 instanceof l2) == true) goto L15;
        r101.getResources().getColor(R.color.ttlive_base_gift_panel_diamond);
        T r103 = r100.f126620h;
        if ((r103 instanceof l2) == false) goto L17;
        l2 r104 = (l2) r103;
        if (r104.getCount() > 0) goto L13;
        r101.getString(R.string.ttlive_try_get_prop);
        r101.getResources().getColor(R.color.ttlive_prop_try_to_get_tip_color);
        throw null;
    L13:
        r104.getDescription();
        r101.getResources().getColor(R.color.ttlive_base_gift_panel_diamond);
        throw null;
    L17:
        throw null;
    L15:
        l2 r105 = (l2) r102;
        throw null;
    }

    @Override // com.bytedance.android.livesdk.gift.platform.business.dialog.v2.view.SimpleGiftViewHolder, com.bytedance.android.livesdk.gift.platform.business.dialog.v2.view.BaseLiveGiftViewHolder, android.view.View.OnAttachStateChangeListener
    public final void onViewAttachedToWindow(View r100) {
        super.onViewAttachedToWindow(r100);
        T r101 = this.f126733b.f126620h;
        if ((r101 instanceof l2) == true) goto L5;
        return;
    L5:
        l2 r102 = (l2) r101;
        throw null;
    }

    @Override // com.bytedance.android.livesdk.gift.platform.business.dialog.v2.view.BaseLiveGiftViewHolder, android.view.View.OnAttachStateChangeListener
    public final void onViewDetachedFromWindow(View r100) {
        throw null;
    }
}
