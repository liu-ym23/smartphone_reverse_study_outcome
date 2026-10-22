package com.bytedance.android.anniex.container.ui;

import android.view.View;
import com.bytedance.android.anniex.base.monitor.MonitorCenter;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;

/* JADX INFO: loaded from: classes43.dex */
public final class m implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ia.c f40599a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ l f40600b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ String f40601c;

    public m(ia.c r100, l r101, String r102) {
        this.f40599a = r100;
        this.f40600b = r101;
        this.f40601c = r102;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        this.f40599a.goBack();
        if (this.f40600b.f40594a == false) goto L6;
        MonitorCenter.f40289c.a(this.f40601c, MapsKt.mapOf(new Pair[]{TuplesKt.to("event_source", "event_source_title_bar"), TuplesKt.to("event_type", "event_type_click"), TuplesKt.to("button_name", "back")}), null);
        return;
    }
}
