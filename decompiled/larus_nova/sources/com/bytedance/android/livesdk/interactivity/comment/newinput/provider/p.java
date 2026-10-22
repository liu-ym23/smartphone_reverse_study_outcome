package com.bytedance.android.livesdk.interactivity.comment.newinput.provider;

import android.view.View;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes9.dex */
public final class p implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final p f135945a = null;

    static {
        f135945a = new p();
    }

    public p() {
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        com.bytedance.android.live.core.utils.f2.b(R.string.ttlive_live_danmaku_disable_hint_due_to_intercom, 0);
    }
}
