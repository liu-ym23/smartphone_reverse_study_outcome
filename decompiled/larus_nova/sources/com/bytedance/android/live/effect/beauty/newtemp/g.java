package com.bytedance.android.live.effect.beauty.newtemp;

import android.view.View;
import com.bytedance.android.live.effect.api.LiveEffectContext;
import com.bytedance.android.live.uikit.recyclerview.LoadingStatusView;
import com.larus.nova.R;
import java.lang.ref.WeakReference;
import java.util.List;

/* JADX INFO: loaded from: classes45.dex */
public final class g implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ LiveOneTapBeautyListFragment f67404a;

    public g(LiveOneTapBeautyListFragment r100) {
        this.f67404a = r100;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        ((LoadingStatusView) this.f67404a.S90(R.id.small_item_beauty_loading_view)).showLoading();
        List<String> r101 = LiveEffectContext.f66734h;
        c.a(LiveEffectContext.a.a(this.f67404a.f67374e).b().c(), this.f67404a.f67374e, new WeakReference(this.f67404a.f67381l));
    }
}
