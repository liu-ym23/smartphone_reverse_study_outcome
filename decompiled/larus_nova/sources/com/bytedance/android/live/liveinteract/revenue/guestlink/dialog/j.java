package com.bytedance.android.live.liveinteract.revenue.guestlink.dialog;

import com.bytedance.android.live.core.log.ALogger;
import com.ss.android.ugc.aweme.compat.nullable.Observer;

/* JADX INFO: loaded from: classes46.dex */
public final class j<T> implements Observer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final j f78480a = null;

    static {
        f78480a = new j();
    }

    public j() {
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(Object r100) {
        ALogger.i("GuestLinkMainPageDialogForAudience", "registerPlayerEvent playing: " + ((Boolean) r100));
    }
}
