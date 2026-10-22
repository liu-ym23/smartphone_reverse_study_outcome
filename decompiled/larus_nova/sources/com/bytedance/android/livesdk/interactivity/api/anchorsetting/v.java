package com.bytedance.android.livesdk.interactivity.api.anchorsetting;

import android.view.View;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.live.core.utils.s1;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes9.dex */
public final class v implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final v f132873a = null;

    static {
        f132873a = new v();
    }

    public v() {
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        f2.c(s1.B(R.string.ttlive_privilege_active_desc), 0);
    }
}
