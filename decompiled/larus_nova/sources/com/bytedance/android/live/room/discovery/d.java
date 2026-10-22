package com.bytedance.android.live.room.discovery;

import android.view.View;
import com.bytedance.android.live.core.utils.f2;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes47.dex */
public final class d implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final d f99374a = null;

    static {
        f99374a = new d();
    }

    public d() {
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        f2.b(R.string.live_anchor_capture_sound_through_the_system, 0);
    }
}
