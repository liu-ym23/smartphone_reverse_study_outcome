package com.bytedance.android.livesdk.interactivity.personalized;

import com.bytedance.android.live.core.monitor.LiveMonitor;
import com.bytedance.android.livesdk.interactivity.api.monitor.InteractivityMonitor;
import com.bytedance.android.livesdk.t6;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final boolean f138626a = false;

    static {
        f138626a = t6.f158509a.getValue().booleanValue();
    }

    @JvmStatic
    public static final void a(InteractivityMonitor.Event r100, IRoom r101, Integer r102, String r103) {
        Intrinsics.checkNotNullParameter(r100, "event");
        if (f138626a == true) goto L5;
        return;
    L5:
        LiveMonitor.a r104 = InteractivityMonitor.a(r100, r101, null);
        if (r102 == null) goto L8;
        int r105 = r102.intValue();
    L9:
        r104.l(r105);
        if (r103 != null) goto L12;
        r103 = "";
    L12:
        r104.m(r103);
        r104.a().report();
        return;
    L8:
        r105 = 0;
        goto L9
    }
}
