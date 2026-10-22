package com.bytedance.android.anniex.container.ui;

import android.view.View;
import com.bytedance.android.anniex.base.monitor.MonitorCenter;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;

/* JADX INFO: loaded from: classes43.dex */
public final class n implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ia.c f40602a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ l f40603b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ String f40604c;

    public n(ia.c r100, l r101, String r102) {
        this.f40602a = r100;
        this.f40603b = r101;
        this.f40604c = r102;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        this.f40602a.close();
        if (this.f40603b.f40594a == false) goto L6;
        MonitorCenter.f40289c.a(this.f40604c, MapsKt.mapOf(new Pair[]{TuplesKt.to("event_source", "event_source_title_bar"), TuplesKt.to("event_type", "event_type_click"), TuplesKt.to("button_name", "close")}), null);
        return;
    }
}
