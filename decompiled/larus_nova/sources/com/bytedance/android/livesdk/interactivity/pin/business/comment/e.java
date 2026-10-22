package com.bytedance.android.livesdk.interactivity.pin.business.comment;

import android.view.View;
import com.bytedance.android.live.core.utils.f2;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes9.dex */
public final class e implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final e f138672a = null;

    static {
        f138672a = new e();
    }

    public e() {
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        f2.b(R.string.ttlive_pin_cannot_cancel, 0);
    }
}
