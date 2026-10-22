package com.bytedance.android.livesdk.interactivity.api.publicscreen.adjuster;

import android.util.Log;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.core.utils.v;
import com.bytedance.android.livesdk.interactivity.api.monitor.InteractivityMonitor;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.utils.TextMessageTracer;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import kotlin.jvm.internal.Intrinsics;
import r52.q3;

/* JADX INFO: loaded from: classes9.dex */
public final class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final boolean f133383a = false;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final int f133384b = 0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final j f133385c = null;

    public j() {
    }

    static {
        f133385c = new j();
        f133383a = v.a();
        f133384b = s1.f(100.0f);
    }

    public final void b() {
        if (f133383a == false) goto L11;
        Integer r100 = q3.f536245a.getValue();
        if (r100 != null) goto L8;
        return;
    L8:
        if (r100.intValue() != 10) goto L12;
        Log.getStackTraceString(new TraceException());
        return;
    L12:
        return;
    }

    public final void a(String r100) {
        Intrinsics.checkNotNullParameter(r100, "msg");
        boolean r101 = TextMessageTracer.f133629a;
        TextMessageTracer.A(r100);
    }

    public final void d(String r100) {
        Intrinsics.checkNotNullParameter(r100, "msg");
    }

    public final void c(d r100, Room r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, "heightInfo");
        Intrinsics.checkNotNullParameter(r101, "room");
        Intrinsics.checkNotNullParameter(r102, "source");
        a("on height change error!! , too low !!!, height is " + r100.f133379a);
        InteractivityMonitor.c(InteractivityMonitor.Event.PublicScreenHeightError, r101, 2, r102, 16);
    }
}
