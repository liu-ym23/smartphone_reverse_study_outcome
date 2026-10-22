package com.bytedance.android.live.liveinteract.revenue.guestlink.dialog;

import com.bytedance.android.live.core.log.ALogger;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
public final class i<T> implements Observer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final i f78479a = null;

    static {
        f78479a = new i();
    }

    public i() {
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(Object r100) {
        if (Intrinsics.areEqual((Boolean) r100, Boolean.TRUE) == false) goto L6;
        ALogger.i("GuestLinkMainPageDialogForAudience", "registerPlayerEvent firstFrame");
        return;
    }
}
