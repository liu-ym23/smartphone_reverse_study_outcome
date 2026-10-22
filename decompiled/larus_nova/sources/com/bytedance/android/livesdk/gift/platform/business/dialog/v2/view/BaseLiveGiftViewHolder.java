package com.bytedance.android.livesdk.gift.platform.business.dialog.v2.view;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.livesdk.gift.platform.business.dialog.ui.panel.AbsPanel;

/* JADX INFO: loaded from: classes9.dex */
public abstract class BaseLiveGiftViewHolder<T extends AbsPanel<?>> extends RecyclerView.ViewHolder implements View.OnAttachStateChangeListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f126629a;

    public abstract void T3(T r100);

    public void onViewAttachedToWindow(View r100) {
    }

    public void onViewDetachedFromWindow(View r100) {
    }

    public BaseLiveGiftViewHolder(View r100) {
        super(r100);
        r100.addOnAttachStateChangeListener(this);
    }
}
