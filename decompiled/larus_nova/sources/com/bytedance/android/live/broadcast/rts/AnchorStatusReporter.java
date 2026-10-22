package com.bytedance.android.live.broadcast.rts;

import com.bytedance.rts.foundation.m;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
public final class AnchorStatusReporter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Function2<? super String, ? super Map<String, String>, Unit> f59180a;

    public AnchorStatusReporter(Function2<? super String, ? super Map<String, String>, Unit> r100) {
        Intrinsics.checkNotNullParameter(r100, "trackEvent");
        this.f59180a = r100;
    }

    public final void a(String r100, String r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, "tabKey");
        Intrinsics.checkNotNullParameter(r102, "enterFromType");
        LinkedHashMap r103 = new LinkedHashMap();
        m.e(r103, "tab_key", r100);
        if (r101 != null) goto L5;
        r101 = "";
    L5:
        m.e(r103, "tab_type", r101);
        m.e(r103, "enter_from_type", r102);
        Function2<? super String, ? super Map<String, String>, Unit> r104 = this.f59180a;
        if (r104 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("trackEvent");
    L8:
        r104.invoke("livesdk_anchor_status_panel_tab_show", r103);
    }

    public final void b(long r100, String r101, String r102) {
        Intrinsics.checkNotNullParameter(r101, "curShownTabKey");
        Intrinsics.checkNotNullParameter(r102, "enterFromType");
        LinkedHashMap r103 = new LinkedHashMap();
        int r104 = com.bytedance.rts.foundation.c.f267576a;
        int r105 = com.bytedance.rts.foundation.h.f267580a;
        int r106 = com.bytedance.rts.foundation.b.f267575a;
        m.e(r103, "duration", String.valueOf(((long) Math.floor(System.currentTimeMillis() / ((double) 1000))) - r100));
        m.e(r103, "tab_key", r101);
        m.e(r103, "enter_from_type", r102);
        Function2<? super String, ? super Map<String, String>, Unit> r107 = this.f59180a;
        if (r107 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("trackEvent");
    L5:
        r107.invoke("livesdk_anchor_status_panel_tab_show_duration", r103);
    }

    public final void c(String r100, String r101, Map<String, String> r102) {
        final LinkedHashMap r103 = new LinkedHashMap();
        if (r100 != null) goto L5;
        r100 = "";
    L5:
        m.e(r103, "suggest_id", r100);
        if (r101 != null) goto L8;
        r101 = "";
    L8:
        m.e(r103, "tab_key", r101);
        if (r102 == null) goto L11;
        m.d(r102, new AnchorStatusReporter$reportSuggestLayoutShow$1(r103));
    L11:
        Function2<? super String, ? super Map<String, String>, Unit> r104 = this.f59180a;
        if (r104 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("trackEvent");
    L14:
        r104.invoke("livesdk_anchor_status_panel_suggest_show", r103);
    }
}
