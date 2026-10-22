package com.bytedance.android.live.effect.beauty.filter;

import android.view.View;
import com.bytedance.android.live.core.utils.f2;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes45.dex */
public final class c implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final c f67275a = null;

    static {
        f67275a = new c();
    }

    public c() {
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        f2.b(R.string.ttlive_effect_filter_sticker_repel_filter_toast, 0);
    }
}
