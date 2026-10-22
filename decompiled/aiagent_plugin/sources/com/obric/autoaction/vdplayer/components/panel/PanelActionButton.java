package com.obric.autoaction.vdplayer.components.panel;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.bytedance.bdturing.localstorage.DbHelper;
import com.bytedance.common.wschannel.WsChannelMultiProcessSharedProvider;
import com.obric.aiagent.plugin.R;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.h;
import d.h.b.o;
import d.k;

/* JADX INFO: compiled from: PanelActionButton.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class PanelActionButton extends LinearLayout {
    private final ImageView iconView;
    private final TextView textView;

    /* JADX INFO: compiled from: PanelActionButton.kt */
    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f25395a = null;

        static {
            int[] r0 = new int[com.obric.autoaction.vdplayer.d.b.values().length];
            r0[com.obric.autoaction.vdplayer.d.b.f.ordinal()] = 1;     // Catch: NoSuchFieldError -> L15
        L27:
            r0[com.obric.autoaction.vdplayer.d.b.f25465b.ordinal()] = 2;     // Catch: NoSuchFieldError -> L16
        L43:
            r0[com.obric.autoaction.vdplayer.d.b.f25466c.ordinal()] = 3;     // Catch: NoSuchFieldError -> L17
        L31:
            r0[com.obric.autoaction.vdplayer.d.b.f25464a.ordinal()] = 4;     // Catch: NoSuchFieldError -> L18
        L35:
            r0[com.obric.autoaction.vdplayer.d.b.f25467d.ordinal()] = 5;     // Catch: NoSuchFieldError -> L19
        L25:
            r0[com.obric.autoaction.vdplayer.d.b.h.ordinal()] = 6;     // Catch: NoSuchFieldError -> L20
        L37:
            r0[com.obric.autoaction.vdplayer.d.b.j.ordinal()] = 7;     // Catch: NoSuchFieldError -> L21
        L39:
            r0[com.obric.autoaction.vdplayer.d.b.g.ordinal()] = 8;     // Catch: NoSuchFieldError -> L22
        L29:
            r0[com.obric.autoaction.vdplayer.d.b.i.ordinal()] = 9;     // Catch: NoSuchFieldError -> L23
        L33:
            r0[com.obric.autoaction.vdplayer.d.b.f25468e.ordinal()] = 10;     // Catch: NoSuchFieldError -> L24
        L13:
            f25395a = r0;
        }
    }

    public PanelActionButton(Context r7) {
        Context r1 = (Context) ZeusTransformUtils.wrapperContextForParams(r7, Context.class, "com.obric.aiagent.plugin");
        o.e(r1, "context");
        this(r1, null, 0, 6, null);
    }

    public PanelActionButton(Context r9, AttributeSet r10) {
        Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r9, Context.class, "com.obric.aiagent.plugin");
        AttributeSet r4 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r10, AttributeSet.class, "com.obric.aiagent.plugin");
        o.e(r3, "context");
        this(r3, r4, 0, 4, null);
    }

    public /* synthetic */ PanelActionButton(Context r2, AttributeSet r3, int r4, int r5, h r6) {
        Context r7 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin");
        AttributeSet r8 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r3, AttributeSet.class, "com.obric.aiagent.plugin");
        if ((r5 & 2) == 0) goto L6;
        r8 = null;
    L6:
        if ((r5 & 4) == 0) goto L8;
        r4 = 0;
    L8:
        this(r7, r8, r4);
    }

    public PanelActionButton(Context r5, AttributeSet r6, int r7) {
        Context r8 = (Context) ZeusTransformUtils.wrapperContextForParams(r5, Context.class, "com.obric.aiagent.plugin");
        AttributeSet r9 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r6, AttributeSet.class, "com.obric.aiagent.plugin");
        o.e(r8, "context");
        super(r8, r9, r7);
        setOrientation(1);
        setGravity(17);
        ZeusTransformUtils.inflate(LayoutInflater.from(r8), ZeusTransformUtils.mapRes(R.layout.vd_component_panel_action_button, "layout", "vd_component_panel_action_button"), (ViewGroup) ZeusTransformUtils.preCheckCast(this, ViewGroup.class, "com.obric.aiagent.plugin"), true, "com.obric.aiagent.plugin");
        View r10 = findViewById(ZeusTransformUtils.mapRes(R.id.icon_view, DbHelper.COL_ID, "icon_view"));
        o.c(r10, "findViewById(...)");
        this.iconView = (ImageView) ZeusTransformUtils.preCheckCast(r10, ImageView.class, "com.obric.aiagent.plugin");
        View r11 = findViewById(ZeusTransformUtils.mapRes(R.id.text_view, DbHelper.COL_ID, "text_view"));
        o.c(r11, "findViewById(...)");
        this.textView = (TextView) ZeusTransformUtils.preCheckCast(r11, TextView.class, "com.obric.aiagent.plugin");
        setBackground(androidx.core.content.a.a(r8, ZeusTransformUtils.mapRes(R.drawable.vd_component_panel_navbar_action_bg, "drawable", "vd_component_panel_navbar_action_bg")));
        setLayoutParams((ViewGroup.LayoutParams) ZeusTransformUtils.preCheckCast(new LinearLayout.LayoutParams(d.i.a.a(TypedValue.applyDimension(1, 56, Resources.getSystem().getDisplayMetrics())), d.i.a.a(TypedValue.applyDimension(1, 48, Resources.getSystem().getDisplayMetrics()))), ViewGroup.LayoutParams.class, "com.obric.aiagent.plugin"));
    }

    public final void bind(com.obric.autoaction.vdplayer.d.a r5) {
        o.e(r5, "state");
        TextView r0 = this.textView;
        String r1 = r5.c();
        if (r1 != null) goto L6;
        r1 = getDefaultTextByType(r5.getType());
    L6:
        r0.setText((CharSequence) ZeusTransformUtils.preCheckCast(r1, CharSequence.class, "com.obric.aiagent.plugin"));
        this.textView.setTextColor(getTextColorByType(r5.getType(), r5.b()));
        this.iconView.setImageResource(getIconResIdByType(r5.getType()));
        this.iconView.setColorFilter(getTextColorByType(r5.getType(), r5.b()));
        setEnabled(r5.a());
        if (r5.a() == false) goto L9;
        float r2 = 1.0f;
    L10:
        setAlpha(r2);
        if (r5.b() == false) goto L13;
        Drawable r6 = androidx.core.content.a.a((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), ZeusTransformUtils.mapRes(R.drawable.vd_component_panel_navbar_action_bg_primary, "drawable", "vd_component_panel_navbar_action_bg_primary"));
    L14:
        setBackground(r6);
        return;
    L13:
        r6 = androidx.core.content.a.a((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), ZeusTransformUtils.mapRes(R.drawable.vd_component_panel_navbar_action_bg, "drawable", "vd_component_panel_navbar_action_bg"));
        goto L14
    L9:
        r2 = 0.15f;
        goto L10
    }

    private final String getDefaultTextByType(com.obric.autoaction.vdplayer.d.b r4) {
        switch(a.f25395a[r4.ordinal()]) {
            case 1: goto L15;
            case 2: goto L14;
            case 3: goto L13;
            case 4: goto L12;
            case 5: goto L11;
            case 6: goto L10;
            case 7: goto L9;
            case 8: goto L8;
            case 9: goto L7;
            case 10: goto L6;
            default: goto L5;
        };
    L6:
        String r3 = ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")).getString(ZeusTransformUtils.mapRes(R.string.obric_vd_action_manual_op, WsChannelMultiProcessSharedProvider.STRING_TYPE, "obric_vd_action_manual_op"));
        o.c(r3, "getString(...)");
        return r3;
    L7:
        String r5 = ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")).getString(ZeusTransformUtils.mapRes(R.string.obric_vd_action_replay, WsChannelMultiProcessSharedProvider.STRING_TYPE, "obric_vd_action_replay"));
        o.c(r5, "getString(...)");
        return r5;
    L8:
        String r6 = ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")).getString(ZeusTransformUtils.mapRes(R.string.obric_vd_action_feedback, WsChannelMultiProcessSharedProvider.STRING_TYPE, "obric_vd_action_feedback"));
        o.c(r6, "getString(...)");
        return r6;
    L9:
        String r7 = ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")).getString(ZeusTransformUtils.mapRes(R.string.obric_vd_action_quit, WsChannelMultiProcessSharedProvider.STRING_TYPE, "obric_vd_action_quit"));
        o.c(r7, "getString(...)");
        return r7;
    L10:
        String r8 = ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")).getString(ZeusTransformUtils.mapRes(R.string.obric_vd_action_share, WsChannelMultiProcessSharedProvider.STRING_TYPE, "obric_vd_action_share"));
        o.c(r8, "getString(...)");
        return r8;
    L11:
        String r9 = ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")).getString(ZeusTransformUtils.mapRes(R.string.obric_vd_action_takeover, WsChannelMultiProcessSharedProvider.STRING_TYPE, "obric_vd_action_takeover"));
        o.c(r9, "getString(...)");
        return r9;
    L12:
        String r10 = ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")).getString(ZeusTransformUtils.mapRes(R.string.obric_vd_action_clarify, WsChannelMultiProcessSharedProvider.STRING_TYPE, "obric_vd_action_clarify"));
        o.c(r10, "getString(...)");
        return r10;
    L13:
        String r11 = ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")).getString(ZeusTransformUtils.mapRes(R.string.obric_vd_action_supplement_other, WsChannelMultiProcessSharedProvider.STRING_TYPE, "obric_vd_action_supplement_other"));
        o.c(r11, "getString(...)");
        return r11;
    L14:
        String r12 = ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")).getString(ZeusTransformUtils.mapRes(R.string.obric_vd_action_supplement, WsChannelMultiProcessSharedProvider.STRING_TYPE, "obric_vd_action_supplement"));
        o.c(r12, "getString(...)");
        return r12;
    L15:
        String r13 = ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")).getString(ZeusTransformUtils.mapRes(R.string.obric_vd_action_stop, WsChannelMultiProcessSharedProvider.STRING_TYPE, "obric_vd_action_stop"));
        o.c(r13, "getString(...)");
        return r13;
    L5:
        throw new k();
    }

    private final int getTextColorByType(com.obric.autoaction.vdplayer.d.b r3, boolean r4) {
        if (r4 == false) goto L7;
        return ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")).getColor(ZeusTransformUtils.mapRes(R.color.oui_blue_6, "color", "oui_blue_6"));
    L7:
        if (a.f25395a[r3.ordinal()] != 1) goto L10;
        return ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")).getColor(ZeusTransformUtils.mapRes(R.color.oui_functional_red_6, "color", "oui_functional_red_6"));
    L10:
        return ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")).getColor(ZeusTransformUtils.mapRes(R.color.oui_basic_text_1, "color", "oui_basic_text_1"));
    }

    private final int getIconResIdByType(com.obric.autoaction.vdplayer.d.b r2) {
        switch(a.f25395a[r2.ordinal()]) {
            case 1: goto L13;
            case 2: goto L19;
            case 3: goto L19;
            case 4: goto L19;
            case 5: goto L18;
            case 6: goto L17;
            case 7: goto L16;
            case 8: goto L15;
            case 9: goto L14;
            case 10: goto L18;
            default: goto L5;
        };
    L5:
        throw new k();
    L14:
        return ZeusTransformUtils.mapRes(R.drawable.ic_vd_replay, "drawable", "ic_vd_replay");
    L15:
        return ZeusTransformUtils.mapRes(R.drawable.ic_vd_feedback, "drawable", "ic_vd_feedback");
    L16:
        return ZeusTransformUtils.mapRes(R.drawable.ic_vd_exit, "drawable", "ic_vd_exit");
    L17:
        return ZeusTransformUtils.mapRes(R.drawable.ic_vd_share, "drawable", "ic_vd_share");
    L18:
        return ZeusTransformUtils.mapRes(R.drawable.ic_vd_takeover, "drawable", "ic_vd_takeover");
    L19:
        return ZeusTransformUtils.mapRes(R.drawable.ic_vd_supplement, "drawable", "ic_vd_supplement");
    L13:
        return ZeusTransformUtils.mapRes(R.drawable.ic_vd_stop, "drawable", "ic_vd_stop");
    }
}
