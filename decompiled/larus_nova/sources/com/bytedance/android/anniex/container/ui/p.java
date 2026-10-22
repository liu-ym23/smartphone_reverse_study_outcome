package com.bytedance.android.anniex.container.ui;

import android.content.Context;
import android.view.View;
import com.bytedance.android.anniex.base.monitor.MonitorCenter;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;

/* JADX INFO: loaded from: classes43.dex */
public final class p implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ia.c f40608a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ l f40609b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ String f40610c;

    public p(ia.c r100, l r101, String r102) {
        this.f40608a = r100;
        this.f40609b = r101;
        this.f40610c = r102;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        s26.d r101 = s26.d.f540305c;
        if (((com.bytedance.android.anniex.base.service.a) s26.d.f540305c.d(this.f40608a.getBid(), com.bytedance.android.anniex.base.service.a.class)) == null) goto L6;
        Context r102 = r100.getContext();
        la.d r103 = new la.d(0);
        r103.f508159c = "annie_x_title_bar";
        r103.f508160d = "search_amplifier";
        com.bytedance.android.anniex.base.service.a.L0(r102, r103);
    L6:
        if (this.f40609b.f40594a == false) goto L9;
        MonitorCenter.f40289c.a(this.f40610c, MapsKt.mapOf(new Pair[]{TuplesKt.to("event_source", "event_source_title_bar"), TuplesKt.to("event_type", "event_type_click"), TuplesKt.to("button_name", "search_amplifier")}), null);
        return;
    }
}
