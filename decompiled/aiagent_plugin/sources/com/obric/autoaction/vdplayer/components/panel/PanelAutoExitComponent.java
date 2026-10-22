package com.obric.autoaction.vdplayer.components.panel;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;
import androidx.lifecycle.p;
import com.bytedance.common.wschannel.WsChannelMultiProcessSharedProvider;
import com.obric.aiagent.plugin.R;
import com.obric.autoaction.vdplayer.components.BaseVDPlayerSlotComponent;
import com.obric.autoaction.vdplayer.d.r;
import com.obric.autoaction.vdplayer.d.s;
import com.obric.autogui.vdplayer.a.f;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.h;
import d.h.b.o;

/* JADX INFO: compiled from: PanelAutoExitComponent.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class PanelAutoExitComponent extends BaseVDPlayerSlotComponent<com.obric.autoaction.vdplayer.components.panel.a> {
    private static final String TAG = "PanelAutoExitComponent";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final a f25396a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private f f25397b;

    /* JADX INFO: compiled from: PanelAutoExitComponent.kt */
    private static final class a {
        public /* synthetic */ a(h r1) {
            this();
        }

        private a() {
        }
    }

    static {
        f25396a = new a(null);
    }

    public static /* synthetic */ void lambda$EqSmm0PzT4yA49RKvWr4NywdGXw(PanelAutoExitComponent r0, View r1) {
        a(r0, r1);
    }

    /* JADX INFO: renamed from: lambda$uCD4lt4XsK4a-k2DZlMXx-iBrIQ, reason: not valid java name */
    public static /* synthetic */ com.obric.autoaction.vdplayer.components.panel.a m667lambda$uCD4lt4XsK4ak2DZlMXxiBrIQ(s r0) {
        return a(r0);
    }

    public PanelAutoExitComponent() {
        super($$Lambda$PanelAutoExitComponent$uCD4lt4XsK4ak2DZlMXxiBrIQ.INSTANCE);
    }

    @Override // com.obric.autoaction.vdplayer.components.BaseVDPlayerComponent
    public /* synthetic */ void a(Object r3, Object r4) {
        a((com.obric.autoaction.vdplayer.components.panel.a) ZeusTransformUtils.preCheckCast(r3, com.obric.autoaction.vdplayer.components.panel.a.class, "com.obric.aiagent.plugin"), (com.obric.autoaction.vdplayer.components.panel.a) ZeusTransformUtils.preCheckCast(r4, com.obric.autoaction.vdplayer.components.panel.a.class, "com.obric.aiagent.plugin"));
    }

    private static final com.obric.autoaction.vdplayer.components.panel.a a(s r1) {
        o.e(r1, "it");
        return new com.obric.autoaction.vdplayer.components.panel.a(r1.b().e());
    }

    @Override // com.obric.autoaction.a.g
    public View a(ViewGroup r3, com.obric.autoaction.a.c r4) {
        o.e(r3, "container");
        o.e(r4, "componentHost");
        f r5 = f.a(LayoutInflater.from((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r3.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")), r3, false);
        o.c(r5, "inflate(...)");
        this.f25397b = r5;
        RelativeLayout r2 = r5.b();
        o.c(r2, "getRoot(...)");
        return (View) ZeusTransformUtils.preCheckCast(r2, View.class, "com.obric.aiagent.plugin");
    }

    @Override // com.obric.autoaction.vdplayer.components.BaseVDPlayerComponent, com.obric.autoaction.a.h
    public void a(View r2, com.obric.autoaction.a.c r3) {
        o.e(r2, "boundView");
        o.e(r3, "componentHost");
        super.a(r2, r3);
        f r4 = this.f25397b;
        if (r4 == null) goto L8;
        Button r5 = r4.f31611c;
        if (r5 == null) goto L9;
        r5.setOnClickListener(new $$Lambda$PanelAutoExitComponent$EqSmm0PzT4yA49RKvWr4NywdGXw(this));
        return;
    L9:
        return;
    }

    private static final void a(PanelAutoExitComponent r2, View r3) {
        r2.a((r) ZeusTransformUtils.preCheckCast(new r.f(false), r.class, "com.obric.aiagent.plugin"));
    }

    private final void a(Long r10) {
        if (r10 == null) goto L20;
        r10.longValue();
        f r0 = this.f25397b;
        if (r0 == null) goto L21;
        RelativeLayout r1 = r0.b();
        if (r1 == null) goto L22;
        Context r2 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r1.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
        if (r2 != null) goto L11;
        return;
    L11:
        if (r10.longValue() < 0) goto L13;
        String r11 = r2.getString(ZeusTransformUtils.mapRes(R.string.obric_vd_auto_exit_button_with_countdown, WsChannelMultiProcessSharedProvider.STRING_TYPE, "obric_vd_auto_exit_button_with_countdown"), new Object[]{Long.valueOf(r10.longValue() / ((long) 1000))});
    L14:
        o.a(r11);
        f r9 = this.f25397b;
        if (r9 == null) goto L23;
        Button r12 = r9.f31611c;
        if (r12 == null) goto L24;
        r12.setText((CharSequence) ZeusTransformUtils.preCheckCast(r11, CharSequence.class, "com.obric.aiagent.plugin"));
        return;
    L24:
        return;
    L23:
        return;
    L13:
        r11 = r2.getString(ZeusTransformUtils.mapRes(R.string.obric_vd_action_quit, WsChannelMultiProcessSharedProvider.STRING_TYPE, "obric_vd_action_quit"));
        goto L14
    L22:
        return;
    L21:
        return;
    }

    public void a(com.obric.autoaction.vdplayer.components.panel.a r2, com.obric.autoaction.vdplayer.components.panel.a r3) {
        o.e(r3, "new");
        super.a(r2, r3);
        if (r2 == null) goto L5;
        Long r4 = r2.a();
    L7:
        if (o.a(r4, r3.a()) == true) goto L10;
        a(r3.a());
        return;
    L10:
        return;
    L5:
        r4 = null;
        goto L7
    }

    @Override // androidx.lifecycle.d
    public void e(p r3) {
        p r4 = (p) ZeusTransformUtils.wrapperContextForParams(r3, p.class, "com.obric.aiagent.plugin");
        o.e(r4, "owner");
        super.e(r4);
        this.f25397b = null;
    }
}
