package com.obric.autoaction.vdplayer.components;

import android.content.Context;
import android.content.res.Resources;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowInsets;
import androidx.core.view.al;
import com.obric.aiagent.plugin.R;
import com.obric.autoaction.vdplayer.d.o;
import com.obric.autoaction.vdplayer.d.s;
import com.obric.oui.common.util.k;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: TakeoverStatusBadgeComponent.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class TakeoverStatusBadgeComponent extends BaseVDPlayerSlotComponent<o> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private View f25332a;

    public static /* synthetic */ o lambda$5H4D7Cg3fogdfT8ZIdXNb6pOYaU(s r0) {
        return a(r0);
    }

    /* JADX INFO: renamed from: lambda$vQoGNzR2w3J9__N695p424-G7XI, reason: not valid java name */
    public static /* synthetic */ WindowInsets m660lambda$vQoGNzR2w3J9__N695p424G7XI(View r0, WindowInsets r1) {
        return a(r0, r1);
    }

    public TakeoverStatusBadgeComponent() {
        super($$Lambda$TakeoverStatusBadgeComponent$5H4D7Cg3fogdfT8ZIdXNb6pOYaU.INSTANCE);
    }

    @Override // com.obric.autoaction.vdplayer.components.BaseVDPlayerComponent
    public /* synthetic */ void a(Object r3) {
        a((o) ZeusTransformUtils.preCheckCast(r3, o.class, "com.obric.aiagent.plugin"));
    }

    private static final o a(s r1) {
        d.h.b.o.e(r1, "it");
        return r1.e();
    }

    @Override // com.obric.autoaction.a.g
    public View a(ViewGroup r5, com.obric.autoaction.a.c r6) {
        d.h.b.o.e(r5, "container");
        d.h.b.o.e(r6, "componentHost");
        View r7 = ZeusTransformUtils.inflate(LayoutInflater.from((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r5.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")), ZeusTransformUtils.mapRes(R.layout.vd_component_takeover_status_badge, "layout", "vd_component_takeover_status_badge"), r5, false, "com.obric.aiagent.plugin");
        this.f25332a = r7;
        r7.setOnApplyWindowInsetsListener($$Lambda$TakeoverStatusBadgeComponent$vQoGNzR2w3J9__N695p424G7XI.INSTANCE);
        d.h.b.o.c(r7, "apply(...)");
        return r7;
    }

    private static final WindowInsets a(View r4, WindowInsets r5) {
        d.h.b.o.e(r4, "view");
        d.h.b.o.e(r5, "insets");
        r4.setPadding(0, al.a(r5).a(al.m.a()).f1211c + d.i.a.a(TypedValue.applyDimension(1, 8, Resources.getSystem().getDisplayMetrics())), 0, 0);
        return r5;
    }

    public void a(o r2) {
        d.h.b.o.e(r2, "state");
        if (r2 == o.f25519a) goto L7;
        View r1 = this.f25332a;
        if (r1 == null) goto L11;
        k.a(r1);
        return;
    L11:
        return;
    L7:
        View r3 = this.f25332a;
        if (r3 == null) goto L13;
        k.b(r3);
        return;
    }
}
