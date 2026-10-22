package com.bytedance.android.live.liveinteract.revenue.guestlink.dialog;

import com.bytedance.android.live.core.log.ALogger;
import com.ss.android.ugc.aweme.compat.nullable.Observer;

/* JADX INFO: loaded from: classes46.dex */
public final class l<T> implements Observer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final l f78482a = null;

    static {
        f78482a = new l();
    }

    public l() {
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(Object r100) {
        ALogger.i("GuestLinkMainPageDialogForAudience", "registerPlayerEvent stopped: " + ((Boolean) r100));
    }
}
