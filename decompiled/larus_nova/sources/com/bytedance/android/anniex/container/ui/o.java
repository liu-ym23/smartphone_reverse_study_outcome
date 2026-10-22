package com.bytedance.android.anniex.container.ui;

import android.content.Context;
import android.view.View;
import com.bytedance.android.anniex.base.monitor.MonitorCenter;
import java.util.List;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public final class o implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ia.c f40605a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f40606b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ l f40607c;

    public o(ia.c r100, String r101, l r102) {
        this.f40605a = r100;
        this.f40606b = r101;
        this.f40607c = r102;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        s26.d r101 = s26.d.f540305c;
        if (((com.bytedance.android.anniex.base.service.d) s26.d.f540305c.d(this.f40605a.getBid(), com.bytedance.android.anniex.base.service.d.class)) == null) goto L5;
        com.bytedance.android.anniex.base.service.d.H0(this.f40605a);
    L5:
        List<Object> r102 = CollectionsKt.emptyList();
        if (((com.bytedance.android.anniex.base.service.a) s26.d.f540305c.d(this.f40605a.getBid(), com.bytedance.android.anniex.base.service.a.class)) == null) goto L9;
        Context r103 = r100.getContext();
        la.b r104 = new la.b(null);
        String r105 = this.f40605a.getCurrentUrl();
        Intrinsics.checkNotNullParameter(r105, "url");
        r104.f508147a = r105;
        Intrinsics.checkNotNullParameter("annie_x_title_bar", "enterFrom");
        r104.f508148b = "annie_x_title_bar";
        String r106 = this.f40606b;
        Intrinsics.checkNotNullParameter(r106, "sessionId");
        r104.f508149c = r106;
        Intrinsics.checkNotNullParameter(r102, "panelButtons");
        r104.f508150d = r102;
        com.bytedance.android.anniex.base.service.a.H0(r103, r104);
    L9:
        if (this.f40607c.f40594a == false) goto L12;
        MonitorCenter.f40289c.a(this.f40606b, MapsKt.mapOf(new Pair[]{TuplesKt.to("event_source", "event_source_title_bar"), TuplesKt.to("event_type", "event_type_click"), TuplesKt.to("button_name", "more")}), null);
        return;
    }
}
