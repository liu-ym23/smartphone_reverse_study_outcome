package com.bytedance.android.livesdk.interactivity.publicscreen.utils;

import com.bytedance.android.live.core.monitor.LiveMonitor;
import com.bytedance.android.livesdk.e4;
import com.bytedance.android.livesdk.interactivity.api.monitor.InteractivityMonitor;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final boolean f140293a = false;

    static {
        f140293a = e4.f123287a.getValue().booleanValue();
    }

    public static /* synthetic */ void b(InteractivityMonitor.Event r100, IRoom r101) {
        a(r100, r101, 0);
    }

    @JvmStatic
    public static final void a(InteractivityMonitor.Event r100, IRoom r101, Integer r102) {
        Intrinsics.checkNotNullParameter(r100, "event");
        if (f140293a == true) goto L5;
        return;
    L5:
        LiveMonitor.a r103 = InteractivityMonitor.a(r100, r101, null);
        if (r102 == null) goto L8;
        int r104 = r102.intValue();
    L9:
        r103.l(r104);
        r103.a().report();
        return;
    L8:
        r104 = 0;
        goto L9
    }
}
