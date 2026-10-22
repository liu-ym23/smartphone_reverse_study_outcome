package com.bytedance.android.live.liveinteract.revenue.guestlink.dialog;

import android.text.TextUtils;
import com.bytedance.android.live.core.log.ALogger;
import com.ss.android.ugc.aweme.compat.nullable.Observer;

/* JADX INFO: loaded from: classes46.dex */
public final class o<T> implements Observer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final o f78485a = null;

    static {
        f78485a = new o();
    }

    public o() {
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(Object r100) {
        String r101 = (String) r100;
        if (TextUtils.isEmpty(r101) == true) goto L6;
        ALogger.e("GuestLinkMainPageDialogForAudience", "registerPlayerEvent playerMediaError: " + r101);
        return;
    }
}
