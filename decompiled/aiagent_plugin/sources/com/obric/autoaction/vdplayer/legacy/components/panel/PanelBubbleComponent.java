package com.obric.autoaction.vdplayer.legacy.components.panel;

import android.content.Context;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.lifecycle.p;
import com.bytedance.common.wschannel.WsChannelMultiProcessSharedProvider;
import com.obric.aiagent.plugin.R;
import com.obric.autoaction.vdplayer.legacy.components.BaseVDPlayerSlotComponent;
import com.obric.autoaction.vdplayer.legacy.d.l;
import com.obric.autoaction.vdplayer.legacy.d.r;
import com.obric.autoaction.vdplayer.legacy.d.s;
import com.obric.autoaction.vdplayer.legacy.d.u;
import com.obric.autogui.vdplayer.a.i;
import com.obric.oui.common.util.k;
import com.obric.oui.text.OTextView;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;
import d.x;

/* JADX INFO: compiled from: PanelBubbleComponent.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class PanelBubbleComponent extends BaseVDPlayerSlotComponent<b> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private i f25817a;

    /* JADX INFO: compiled from: PanelBubbleComponent.kt */
    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f25818a = null;

        static {
            int[] r0 = new int[l.values().length];
            r0[l.f25918e.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L9:
            r0[l.f.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L5:
            f25818a = r0;
        }
    }

    public static /* synthetic */ x lambda$MASsJs7bkB6ZLPOBK_BpNMlvJbc(PanelBubbleComponent r0, View r1) {
        return a(r0, r1);
    }

    public static /* synthetic */ b lambda$jIsPPEmcNn4UfgW9Jo0yGzMHjfU(s r0) {
        return a(r0);
    }

    public PanelBubbleComponent() {
        super($$Lambda$PanelBubbleComponent$jIsPPEmcNn4UfgW9Jo0yGzMHjfU.INSTANCE);
    }

    @Override // com.obric.autoaction.vdplayer.legacy.components.BaseVDPlayerComponent
    public /* synthetic */ void a(Object r3) {
        a((b) ZeusTransformUtils.preCheckCast(r3, b.class, "com.obric.aiagent.plugin"));
    }

    private static final b a(s r2) {
        o.e(r2, "it");
        return new b(r2.b().a().a(), r2.b().d());
    }

    @Override // com.obric.autoaction.a.g
    public View a(ViewGroup r3, com.obric.autoaction.a.c r4) {
        o.e(r3, "container");
        o.e(r4, "componentHost");
        i r5 = i.a(LayoutInflater.from((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r3.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")), r3, false);
        o.c(r5, "inflate(...)");
        this.f25817a = r5;
        LinearLayout r2 = r5.b();
        o.c(r2, "getRoot(...)");
        return (View) ZeusTransformUtils.preCheckCast(r2, View.class, "com.obric.aiagent.plugin");
    }

    @Override // com.obric.autoaction.vdplayer.legacy.components.BaseVDPlayerComponent, com.obric.autoaction.a.h
    public void a(View r2, com.obric.autoaction.a.c r3) {
        o.e(r2, "boundView");
        o.e(r3, "componentHost");
        super.a(r2, r3);
        d();
    }

    private final void d() {
        i r0 = this.f25817a;
        if (r0 == null) goto L8;
        LinearLayout r1 = r0.b();
        if (r1 == null) goto L9;
        com.obric.autoaction.view.a.a((View) ZeusTransformUtils.preCheckCast(r1, View.class, "com.obric.aiagent.plugin"), 0, new $$Lambda$PanelBubbleComponent$MASsJs7bkB6ZLPOBK_BpNMlvJbc(this), 1, null);
        return;
    L9:
        return;
    }

    private static final x a(PanelBubbleComponent r1, View r2) {
        o.e(r2, "it");
        r1.e();
        return x.f38692a;
    }

    private final void e() {
        u r3 = b();
        if (r3 == null) goto L6;
        r3.a((com.obric.autoaction.vdplayer.legacy.b.b) ZeusTransformUtils.preCheckCast(r.p.f25960a, com.obric.autoaction.vdplayer.legacy.b.b.class, "com.obric.aiagent.plugin"));
        return;
    }

    public void a(b r10) {
        o.e(r10, "state");
        i r0 = this.f25817a;
        if (r0 != null) goto L5;
        return;
    L5:
        l r1 = r10.a();
        int r2 = a.f25818a[r1.ordinal()];
        if (r2 != 1) goto L8;
    L10:
        r0.f31621a.setImageResource(ZeusTransformUtils.mapRes(R.drawable.ic_vd_hand_left_ai, "drawable", "ic_vd_hand_left_ai"));
    L12:
        if (r10.b() != null) goto L16;
        OTextView r9 = r0.f31622b;
        o.c(r9, "bubbleText");
        k.b((View) ZeusTransformUtils.preCheckCast(r9, View.class, "com.obric.aiagent.plugin"));
        r0.b().setBackground(null);
        return;
    L16:
        if (r10.b().longValue() > 5000) goto L18;
        OTextView r3 = r0.f31622b;
        o.c(r3, "bubbleText");
        k.a((View) ZeusTransformUtils.preCheckCast(r3, View.class, "com.obric.aiagent.plugin"));
        r0.f31622b.setText(a(((int) r10.b().longValue()) / 1000));
    L19:
        r0.f31621a.setImageResource(ZeusTransformUtils.mapRes(R.drawable.ic_vd_takeover_resume, "drawable", "ic_vd_takeover_resume"));
        r0.b().setBackgroundResource(ZeusTransformUtils.mapRes(R.drawable.vd_bubble_stroke, "drawable", "vd_bubble_stroke"));
        return;
    L18:
        OTextView r11 = r0.f31622b;
        o.c(r11, "bubbleText");
        k.b((View) ZeusTransformUtils.preCheckCast(r11, View.class, "com.obric.aiagent.plugin"));
        goto L19
    L8:
        if (r2 == 2) goto L10;
        r0.f31621a.setImageResource(ZeusTransformUtils.mapRes(R.drawable.ic_vd_hand_right_gradient, "drawable", "ic_vd_hand_right_gradient"));
        goto L12
    }

    private final CharSequence a(int r6) {
        i r5 = this.f25817a;
        if (r5 == null) goto L11;
        LinearLayout r7 = r5.b();
        if (r7 == null) goto L13;
        Context r8 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r7.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
        if (r8 == null) goto L14;
        SpannableStringBuilder r1 = new SpannableStringBuilder((CharSequence) ZeusTransformUtils.preCheckCast(new StringBuilder().append('(').append(r6).append(')').toString(), CharSequence.class, "com.obric.aiagent.plugin"));
        r1.setSpan(new ForegroundColorSpan(r8.getColor(ZeusTransformUtils.mapRes(R.color.oui_text_3, "color", "oui_text_3"))), 0, r1.length(), 33);
        return (CharSequence) ZeusTransformUtils.preCheckCast(new SpannableStringBuilder((CharSequence) ZeusTransformUtils.preCheckCast(r8.getString(ZeusTransformUtils.mapRes(R.string.obric_vd_manualop_resume_countdown, WsChannelMultiProcessSharedProvider.STRING_TYPE, "obric_vd_manualop_resume_countdown")), CharSequence.class, "com.obric.aiagent.plugin")).append(' ').append((CharSequence) ZeusTransformUtils.preCheckCast(r1, CharSequence.class, "com.obric.aiagent.plugin")), CharSequence.class, "com.obric.aiagent.plugin");
    L14:
        return null;
    L13:
        return null;
    L11:
        return null;
    }

    @Override // androidx.lifecycle.d
    public void e(p r3) {
        p r4 = (p) ZeusTransformUtils.wrapperContextForParams(r3, p.class, "com.obric.aiagent.plugin");
        o.e(r4, "owner");
        super.e(r4);
        this.f25817a = null;
    }
}
