package com.bytedance.android.live.effect.beauty.smallitem;

import android.view.View;
import com.bytedance.android.livesdkapi.depend.model.Sticker;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes45.dex */
public final class t implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ LiveSmallItemBeautyAdapter f67726a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f67727b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ LiveSmallItemBeautyAdapter.AbsSmallItemViewHolder f67728c;

    public t(LiveSmallItemBeautyAdapter r100, int r101, LiveSmallItemBeautyAdapter.AbsSmallItemViewHolder r102) {
        this.f67726a = r100;
        this.f67727b = r101;
        this.f67728c = r102;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        this.f67726a.f67581d.put(this.f67727b, Boolean.FALSE);
        this.f67728c.itemView.findViewById(R.id.expanded_layout).setVisibility(8);
        this.f67728c.itemView.findViewById(R.id.fold_layout).setVisibility(0);
        LiveSmallItemBeautyAdapter r101 = this.f67726a;
        LiveSmallItemBeautyAdapter.a r102 = r101.f67580c;
        if (r102 == null) goto L6;
        r102.a((Sticker) ListProtector.get(r101.f67578a, this.f67727b));
        return;
    }
}
