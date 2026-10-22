package com.bytedance.android.livesdk.log;

import com.larksuite.component.card.plugin.ReportCardMonitorPlugin;
import java.util.HashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f153280a = 0;

    static {
    }

    public static void a(boolean r100, String r101, String r102, String r103) {
        Intrinsics.checkNotNullParameter(r101, "tag");
        Intrinsics.checkNotNullParameter(r102, "event");
        Intrinsics.checkNotNullParameter(r103, "info");
        HashMap r104 = new HashMap();
        r104.put(ReportCardMonitorPlugin.EVENT_NAME, r102);
        r104.put("event_info", r103);
        if (r100 == false) goto L5;
        b0.o().f(r101, r104);
        return;
    L5:
        b0.o().b(r101, r104);
    }
}
