package com.bytedance.android.live.effect.beauty;

import android.view.View;
import com.bytedance.android.live.core.utils.f2;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes45.dex */
public final class k implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final k f67294a = null;

    static {
        f67294a = new k();
    }

    public k() {
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        f2.b(R.string.ttlive_effect_sticker_repel_beauty_toast_new, 0);
    }
}
