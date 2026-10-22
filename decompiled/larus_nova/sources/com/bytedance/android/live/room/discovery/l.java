package com.bytedance.android.live.room.discovery;

import android.view.View;
import com.bytedance.android.live.core.utils.f2;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes47.dex */
public final class l implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final l f99570a = null;

    static {
        f99570a = new l();
    }

    public l() {
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        f2.b(R.string.live_anchor_go_to_open_accessibility, 0);
    }
}
