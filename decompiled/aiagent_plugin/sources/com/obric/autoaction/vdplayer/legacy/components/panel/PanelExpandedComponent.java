package com.obric.autoaction.vdplayer.legacy.components.panel;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.obric.aiagent.plugin.R;
import com.obric.autoaction.vdplayer.legacy.components.BaseVDPlayerSlotComponent;
import com.obric.autoaction.vdplayer.legacy.d.h;
import com.obric.autoaction.vdplayer.legacy.d.i;
import com.obric.autoaction.vdplayer.legacy.d.r;
import com.obric.autoaction.vdplayer.legacy.d.s;
import com.obric.autogui.common.api.AOPackagesTools;
import com.obric.autogui.common.api.configs.AutoActionConfigs;
import com.obric.autogui.vdplayer.a.l;
import com.obric.oui.avatar.OCircleImageView;
import com.obric.oui.button.OButton;
import com.obric.oui.common.util.k;
import com.obric.oui.text.OTextView;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.a.p;
import d.h.b.o;
import d.x;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/* JADX INFO: compiled from: PanelExpandedComponent.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class PanelExpandedComponent extends BaseVDPlayerSlotComponent<a> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f25836a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private l f25837b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private com.obric.autoaction.a.c f25838c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f25839d;

    /* JADX INFO: compiled from: PanelExpandedComponent.kt */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final h f25840a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final i f25841b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final List<com.obric.autoaction.vdplayer.legacy.d.a> f25842c;

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, a.class) == true) goto L8;
            return false;
        L8:
            a r6 = (a) ZeusTransformUtils.preCheckCast(r5, a.class, "com.obric.aiagent.plugin");
            if (o.a(this.f25840a, r6.f25840a) == true) goto L12;
            return false;
        L12:
            if (o.a(this.f25841b, r6.f25841b) == true) goto L15;
            return false;
        L15:
            if (o.a(this.f25842c, r6.f25842c) == true) goto L17;
            return false;
        L17:
            return true;
        }

        public int hashCode() {
            return (((this.f25840a.hashCode() * 31) + this.f25841b.hashCode()) * 31) + this.f25842c.hashCode();
        }

        public String toString() {
            return "PanelUiModel(opAppInfo=" + this.f25840a + ", panelData=" + this.f25841b + ", actionButtons=" + this.f25842c + ')';
        }

        public a(h r3, i r4, List<com.obric.autoaction.vdplayer.legacy.d.a> r5) {
            List<com.obric.autoaction.vdplayer.legacy.d.a> r6 = (List) ZeusTransformUtils.wrapperContextForParams(r5, List.class, "com.obric.aiagent.plugin");
            o.e(r3, "opAppInfo");
            o.e(r4, "panelData");
            o.e(r6, "actionButtons");
            this.f25840a = r3;
            this.f25841b = r4;
            this.f25842c = r6;
        }

        public final h a() {
            return this.f25840a;
        }

        public final i b() {
            return this.f25841b;
        }

        public final List<com.obric.autoaction.vdplayer.legacy.d.a> c() {
            return this.f25842c;
        }
    }

    /* JADX INFO: compiled from: PanelExpandedComponent.kt */
    public /* synthetic */ class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f25843a = null;

        static {
            int[] r0 = new int[com.obric.autoaction.vdplayer.legacy.d.b.values().length];
            r0[com.obric.autoaction.vdplayer.legacy.d.b.f.ordinal()] = 1;     // Catch: NoSuchFieldError -> L15
        L27:
            r0[com.obric.autoaction.vdplayer.legacy.d.b.g.ordinal()] = 2;     // Catch: NoSuchFieldError -> L16
        L43:
            r0[com.obric.autoaction.vdplayer.legacy.d.b.f25872b.ordinal()] = 3;     // Catch: NoSuchFieldError -> L17
        L31:
            r0[com.obric.autoaction.vdplayer.legacy.d.b.f25873c.ordinal()] = 4;     // Catch: NoSuchFieldError -> L18
        L35:
            r0[com.obric.autoaction.vdplayer.legacy.d.b.f25871a.ordinal()] = 5;     // Catch: NoSuchFieldError -> L19
        L25:
            r0[com.obric.autoaction.vdplayer.legacy.d.b.f25874d.ordinal()] = 6;     // Catch: NoSuchFieldError -> L20
        L37:
            r0[com.obric.autoaction.vdplayer.legacy.d.b.f25875e.ordinal()] = 7;     // Catch: NoSuchFieldError -> L21
        L39:
            r0[com.obric.autoaction.vdplayer.legacy.d.b.h.ordinal()] = 8;     // Catch: NoSuchFieldError -> L22
        L29:
            r0[com.obric.autoaction.vdplayer.legacy.d.b.i.ordinal()] = 9;     // Catch: NoSuchFieldError -> L23
        L33:
            r0[com.obric.autoaction.vdplayer.legacy.d.b.j.ordinal()] = 10;     // Catch: NoSuchFieldError -> L24
        L13:
            f25843a = r0;
        }
    }

    public static /* synthetic */ void lambda$KmoSDQeWxALATfntQvD7Nt2jLHU(TextView r0) {
        a(r0);
    }

    public static /* synthetic */ x lambda$TwZ4ntn5lkjwtpmyLNA8_VUdPno(PanelExpandedComponent r0, com.obric.autoaction.vdplayer.legacy.d.a r1, View r2) {
        return a(r0, r1, r2);
    }

    public static /* synthetic */ a lambda$ZEF48OkxQFqN140qkajOCrgHVlo(s r0) {
        return a(r0);
    }

    /* JADX INFO: renamed from: lambda$dOUD7lrWK-KipDACn2JoPcK4tXo, reason: not valid java name */
    public static /* synthetic */ void m700lambda$dOUD7lrWKKipDACn2JoPcK4tXo(PanelExpandedComponent r0, View r1) {
        a(r0, r1);
    }

    public static /* synthetic */ x lambda$sj8CqkKEaRgtJXB35RR2DIJAma8(PanelExpandedComponent r0, String r1, View r2) {
        return a(r0, r1, r2);
    }

    public static /* synthetic */ void lambda$xVIy7mmvpbj2BArPiahgfmEZiVY(PanelExpandedComponent r0) {
        a(r0);
    }

    public PanelExpandedComponent() {
        super($$Lambda$PanelExpandedComponent$ZEF48OkxQFqN140qkajOCrgHVlo.INSTANCE);
        this.f25836a = "security_normal";
    }

    @Override // com.obric.autoaction.vdplayer.legacy.components.BaseVDPlayerComponent
    public /* synthetic */ void a(Object r3, Object r4) {
        a((a) ZeusTransformUtils.preCheckCast(r3, a.class, "com.obric.aiagent.plugin"), (a) ZeusTransformUtils.preCheckCast(r4, a.class, "com.obric.aiagent.plugin"));
    }

    private static final a a(s r3) {
        o.e(r3, "it");
        return new a(r3.c(), r3.b().a(), r3.b().b());
    }

    @Override // com.obric.autoaction.vdplayer.legacy.components.BaseVDPlayerComponent, com.obric.autoaction.a.f
    public void a(com.obric.autoaction.a.c r2) {
        o.e(r2, "componentHost");
        super.a(r2);
        this.f25838c = r2;
    }

    @Override // com.obric.autoaction.a.g
    public View a(ViewGroup r3, com.obric.autoaction.a.c r4) {
        o.e(r3, "container");
        o.e(r4, "componentHost");
        l r5 = l.a(LayoutInflater.from((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r3.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")), r3, false);
        o.c(r5, "inflate(...)");
        this.f25837b = r5;
        r5.b().setOnClickListener(null);
        LinearLayout r2 = r5.b();
        o.c(r2, "getRoot(...)");
        return (View) ZeusTransformUtils.preCheckCast(r2, View.class, "com.obric.aiagent.plugin");
    }

    public void a(a r5, a r6) {
        o.e(r6, "new");
        boolean r0 = this.f25839d;
        List<com.obric.autoaction.vdplayer.legacy.d.a> r1 = null;
        if (r5 == null) goto L5;
        h r2 = r5.a();
    L7:
        if (o.a(r2, r6.a()) == true) goto L9;
        a(r6.a());
    L9:
        if (r5 == null) goto L11;
        i r3 = r5.b();
    L13:
        if (o.a(r3, r6.b()) == true) goto L15;
        a(r6.b());
    L15:
        if (r5 == null) goto L18;
        r1 = r5.c();
    L18:
        if (o.a(r1, r6.c()) == true) goto L20;
    L21:
        a(r6.c(), this.f25839d);
        return;
    L20:
        if (r0 != this.f25839d) goto L21;
        return;
    L11:
        r3 = null;
        goto L13
    L5:
        r2 = null;
        goto L7
    }

    private final void a(i r11) {
        l r0 = this.f25837b;
        if (r0 != null) goto L5;
        return;
    L5:
        c r1 = c.f25854a.a(r11.a());
        if (r1 == null) goto L15;
        int r6 = androidx.core.content.a.c((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r0.b().getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), r1.b());
        r0.n.setText((CharSequence) ZeusTransformUtils.preCheckCast(((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r0.b().getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")).getString(r1.a()), CharSequence.class, "com.obric.aiagent.plugin"));
        r0.n.setTextColor(r6);
        LinearLayout r7 = r0.j;
        if (o.a(r11.d(), this.f25836a) == false) goto L10;
        int r8 = 0;
    L11:
        r7.setVisibility(r8);
        r0.f.setImageResource(r1.c());
        r0.f.setImageTintList(ColorStateList.valueOf(r6));
        LinearLayout r2 = r0.h;
        o.c(r2, "panelContentLayout");
        k.a((View) ZeusTransformUtils.preCheckCast(r2, View.class, "com.obric.aiagent.plugin"));
        OTextView r3 = r0.l;
        o.c(r3, "tvContent");
        TextView r4 = (TextView) ZeusTransformUtils.preCheckCast(r3, TextView.class, "com.obric.aiagent.plugin");
        String r5 = r11.b();
        if (r5 != null) goto L14;
        r5 = "";
    L14:
        a(r4, r5);
        this.f25839d = a(r0, r11.c(), r11.e());
        r0.f31634a.setPadding(0, 0, 0, d.i.a.a(TypedValue.applyDimension(1, 4, Resources.getSystem().getDisplayMetrics())));
        return;
    L10:
        r8 = 8;
        goto L11
    L15:
        LinearLayout r12 = r0.h;
        o.c(r12, "panelContentLayout");
        k.b((View) ZeusTransformUtils.preCheckCast(r12, View.class, "com.obric.aiagent.plugin"));
        r0.f31634a.setPadding(0, 0, 0, d.i.a.a(TypedValue.applyDimension(1, 0, Resources.getSystem().getDisplayMetrics())));
        this.f25839d = false;
    }

    private final void a(final TextView r2, String r3) {
        r2.setText((CharSequence) ZeusTransformUtils.preCheckCast(r3, CharSequence.class, "com.obric.aiagent.plugin"));
        r2.post(new $$Lambda$PanelExpandedComponent$KmoSDQeWxALATfntQvD7Nt2jLHU(r2));
    }

    private static final void a(TextView r2) {
        if (r2.getLayout() != null) goto L6;
        return;
    L6:
        if (r2.getLineCount() <= 1) goto L8;
        r2.setGravity(8388627);
        return;
    L8:
        r2.setGravity(17);
    }

    private final boolean a(l r17, List<String> r18, Map<Integer, String> r19) {
        List r1 = (List) ZeusTransformUtils.wrapperContextForParams(r18, List.class, "com.obric.aiagent.plugin");
        Map r3 = (Map) ZeusTransformUtils.wrapperContextForParams(r19, Map.class, "com.obric.aiagent.plugin");
        if (r1 != null) goto L5;
    L76:
        LinearLayout r0 = r17.g;
        o.c(r0, "optionGroup");
        k.b((View) ZeusTransformUtils.preCheckCast(r0, View.class, "com.obric.aiagent.plugin"));
        return false;
    L5:
        if (r1.isEmpty() == true) goto L76;
        if (r1.size() > 3) goto L76;
        Iterable r6 = (Iterable) ZeusTransformUtils.preCheckCast(r1, Iterable.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r6, Collection.class) == true) goto L11;
    L13:
        Iterator r7 = r6.iterator();
    L15:
        if (r7.hasNext() == false) goto L12;
        if (((String) ZeusTransformUtils.preCheckCast(r7.next(), String.class, "com.obric.aiagent.plugin")).length() <= 18) goto L19;
        boolean r8 = true;
    L20:
        if (r8 == false) goto L15;
        boolean r9 = true;
    L22:
        if (r9 == true) goto L76;
        LinearLayout r10 = r17.g;
        o.c(r10, "optionGroup");
        k.a((View) ZeusTransformUtils.preCheckCast(r10, View.class, "com.obric.aiagent.plugin"));
        r17.g.setShowDividers(2);
        if (r1.size() != 2) goto L43;
        Iterable r4 = (Iterable) ZeusTransformUtils.preCheckCast(r1, Iterable.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r4, Collection.class) == true) goto L29;
    L31:
        Iterator r5 = r4.iterator();
    L33:
        if (r5.hasNext() == false) goto L30;
        if (((String) ZeusTransformUtils.preCheckCast(r5.next(), String.class, "com.obric.aiagent.plugin")).length() > 8) goto L37;
        boolean r11 = true;
    L38:
        if (r11 == true) goto L33;
        boolean r12 = false;
    L40:
        if (r12 == false) goto L43;
        r17.g.setOrientation(0);
        r17.g.setDividerDrawable(androidx.core.content.a.a((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r17.b().getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), ZeusTransformUtils.mapRes(R.drawable.vd_component_panel_content_option_divider_h, "drawable", "vd_component_panel_content_option_divider_h")));
    L61:
        r17.g.removeAllViews();
        Iterator r2 = ((Iterable) ZeusTransformUtils.preCheckCast(r1, Iterable.class, "com.obric.aiagent.plugin")).iterator();
        int r13 = 0;
    L63:
        if (r2.hasNext() == false) goto L75;
        Object r14 = r2.next();
        int r15 = r13 + 1;
        if (r13 >= 0) goto L67;
        p.c();
    L67:
        final String r16 = (String) ZeusTransformUtils.preCheckCast(r14, String.class, "com.obric.aiagent.plugin");
        View r20 = ZeusTransformUtils.inflate(LayoutInflater.from((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r17.b().getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")), ZeusTransformUtils.mapRes(R.layout.vd_component_panel_content_option, "layout", "vd_component_panel_content_option"), (ViewGroup) ZeusTransformUtils.preCheckCast(r17.g, ViewGroup.class, "com.obric.aiagent.plugin"), false, "com.obric.aiagent.plugin");
        o.a(r20, "null cannot be cast to non-null type com.obric.oui.button.OButton");
        OButton r21 = (OButton) ZeusTransformUtils.preCheckCast(r20, OButton.class, "com.obric.aiagent.plugin");
        r21.setText((CharSequence) ZeusTransformUtils.preCheckCast(r16, CharSequence.class, "com.obric.aiagent.plugin"));
        if (r3 == null) goto L70;
        String r22 = (String) ZeusTransformUtils.preCheckCast(r3.get(Integer.valueOf(r13)), String.class, "com.obric.aiagent.plugin");
    L72:
        if (o.a(r22, "AlwaysAllowNotice") == false) goto L74;
        r21.setTextColor(((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r17.b().getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")).getColor(ZeusTransformUtils.mapRes(R.color.oui_functional_blue_6, "color", "oui_functional_blue_6")));
    L74:
        com.obric.autoaction.view.a.a((View) ZeusTransformUtils.preCheckCast(r21, View.class, "com.obric.aiagent.plugin"), 0, new $$Lambda$PanelExpandedComponent$sj8CqkKEaRgtJXB35RR2DIJAma8(this, r16), 1, null);
        LinearLayout.LayoutParams r23 = new LinearLayout.LayoutParams(-1, d.i.a.a(TypedValue.applyDimension(1, 40, Resources.getSystem().getDisplayMetrics())));
        r23.weight = 1.0f;
        r21.setLayoutParams((ViewGroup.LayoutParams) ZeusTransformUtils.preCheckCast(r23, ViewGroup.LayoutParams.class, "com.obric.aiagent.plugin"));
        r17.g.addView((View) ZeusTransformUtils.preCheckCast(r21, View.class, "com.obric.aiagent.plugin"));
        r13 = r15;
        goto L63
    L70:
        r22 = null;
        goto L72
    L75:
        return true;
    L37:
        r11 = false;
    L30:
        r12 = true;
        goto L40
    L29:
        if (((Collection) ZeusTransformUtils.preCheckCast(r4, Collection.class, "com.obric.aiagent.plugin")).isEmpty() == false) goto L31;
    L43:
        if (r1.size() != 3) goto L60;
        Iterable r24 = (Iterable) ZeusTransformUtils.preCheckCast(r1, Iterable.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r24, Collection.class) == true) goto L47;
    L49:
        Iterator r25 = r24.iterator();
    L51:
        if (r25.hasNext() == false) goto L48;
        if (((String) ZeusTransformUtils.preCheckCast(r25.next(), String.class, "com.obric.aiagent.plugin")).length() > 4) goto L55;
        boolean r26 = true;
    L56:
        if (r26 == true) goto L51;
        boolean r27 = false;
    L58:
        if (r27 == false) goto L60;
        r17.g.setOrientation(0);
        r17.g.setDividerDrawable(androidx.core.content.a.a((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r17.b().getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), ZeusTransformUtils.mapRes(R.drawable.vd_component_panel_content_option_divider_h, "drawable", "vd_component_panel_content_option_divider_h")));
        goto L61
    L55:
        r26 = false;
    L48:
        r27 = true;
        goto L58
    L47:
        if (((Collection) ZeusTransformUtils.preCheckCast(r24, Collection.class, "com.obric.aiagent.plugin")).isEmpty() == false) goto L49;
    L60:
        r17.g.setOrientation(1);
        r17.g.setDividerDrawable(androidx.core.content.a.a((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r17.b().getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), ZeusTransformUtils.mapRes(R.drawable.vd_component_panel_content_option_divider_v, "drawable", "vd_component_panel_content_option_divider_v")));
        goto L61
    L19:
        r8 = false;
    L12:
        r9 = false;
        goto L22
    L11:
        if (((Collection) ZeusTransformUtils.preCheckCast(r6, Collection.class, "com.obric.aiagent.plugin")).isEmpty() == false) goto L13;
        goto L12
    }

    private static final x a(PanelExpandedComponent r1, String r2, View r3) {
        o.e(r3, "it");
        r1.a((r) ZeusTransformUtils.preCheckCast(new r.k(r2), r.class, "com.obric.aiagent.plugin"));
        return x.f38692a;
    }

    private final void a(h r8) {
        l r0 = this.f25837b;
        if (r0 != null) goto L6;
        return;
    L6:
        if (r8.a() == true) goto L9;
        LinearLayout r7 = r0.i;
        o.c(r7, "prefixContainer");
        k.b((View) ZeusTransformUtils.preCheckCast(r7, View.class, "com.obric.aiagent.plugin"));
        LinearLayout r9 = r0.f31636c;
        o.c(r9, "controlBar");
        View r10 = (View) ZeusTransformUtils.preCheckCast(r9, View.class, "com.obric.aiagent.plugin");
        ViewGroup.LayoutParams r11 = r10.getLayoutParams();
        Objects.requireNonNull(r11, "null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
        r11.width = -1;
        r10.setLayoutParams(r11);
        r0.i.setOnClickListener(null);
        return;
    L9:
        LinearLayout r1 = r0.f31636c;
        o.c(r1, "controlBar");
        View r2 = (View) ZeusTransformUtils.preCheckCast(r1, View.class, "com.obric.aiagent.plugin");
        ViewGroup.LayoutParams r4 = r2.getLayoutParams();
        Objects.requireNonNull(r4, "null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
        r4.width = -2;
        r2.setLayoutParams(r4);
        LinearLayout r3 = r0.i;
        o.c(r3, "prefixContainer");
        k.a((View) ZeusTransformUtils.preCheckCast(r3, View.class, "com.obric.aiagent.plugin"));
        r0.k.setText((CharSequence) ZeusTransformUtils.preCheckCast(r8.b(), CharSequence.class, "com.obric.aiagent.plugin"));
        String r12 = r8.c();
        if (r12 == null) goto L13;
        r0.f31638e.setContentPadding(d.i.a.a(TypedValue.applyDimension(1, 0, Resources.getSystem().getDisplayMetrics())));
        OCircleImageView r5 = r0.f31638e;
        ViewGroup.LayoutParams r6 = r0.f31638e.getLayoutParams();
        float r13 = 32;
        r6.width = d.i.a.a(TypedValue.applyDimension(1, r13, Resources.getSystem().getDisplayMetrics()));
        r6.height = d.i.a.a(TypedValue.applyDimension(1, r13, Resources.getSystem().getDisplayMetrics()));
        r5.setLayoutParams(r6);
        AOPackagesTools r14 = AOPackagesTools.INSTANCE;
        Context r15 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r0.b().getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
        o.c(r15, "getContext(...)");
        Drawable r16 = r14.getAppIconDrawable(r15, r12);
        if (r16 == null) goto L13;
    L14:
        r0.f31638e.setImageDrawable(r16);
        r0.f31638e.setOnClickListener(new $$Lambda$PanelExpandedComponent$dOUD7lrWKKipDACn2JoPcK4tXo(this));
        return;
    L13:
        PanelExpandedComponent r17 = (PanelExpandedComponent) ZeusTransformUtils.preCheckCast(this, PanelExpandedComponent.class, "com.obric.aiagent.plugin");
        r0.f31638e.setContentPadding(d.i.a.a(TypedValue.applyDimension(1, 4, Resources.getSystem().getDisplayMetrics())));
        r16 = androidx.core.content.a.a((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r0.b().getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), ZeusTransformUtils.mapRes(R.drawable.ic_vd_hand_right_gradient, "drawable", "ic_vd_hand_right_gradient"));
        goto L14
    }

    private static final void a(PanelExpandedComponent r2, View r3) {
        r2.a((r) ZeusTransformUtils.preCheckCast(r.m.f25957a, r.class, "com.obric.aiagent.plugin"));
    }

    private final void a(List<com.obric.autoaction.vdplayer.legacy.d.a> r19, boolean r20) {
        List r1 = (List) ZeusTransformUtils.wrapperContextForParams(r19, List.class, "com.obric.aiagent.plugin");
        l r3 = this.f25837b;
        if (r3 == null) goto L50;
        LinearLayout r4 = r3.f31636c;
        if (r4 != null) goto L8;
        return;
    L8:
        if (r4.getChildCount() == r1.size()) goto L13;
        r4.removeAllViews();
        Iterator r5 = ((Iterable) ZeusTransformUtils.preCheckCast(r1, Iterable.class, "com.obric.aiagent.plugin")).iterator();
    L11:
        if (r5.hasNext() == false) goto L13;
        com.obric.autoaction.vdplayer.legacy.d.a r6 = (com.obric.autoaction.vdplayer.legacy.d.a) ZeusTransformUtils.preCheckCast(r5.next(), com.obric.autoaction.vdplayer.legacy.d.a.class, "com.obric.aiagent.plugin");
        Context r7 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r4.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
        o.c(r7, "getContext(...)");
        r4.addView((View) ZeusTransformUtils.preCheckCast(new PanelActionButton(r7, null, 0, 6, null), View.class, "com.obric.aiagent.plugin"));
    L13:
        Iterable r8 = (Iterable) ZeusTransformUtils.preCheckCast(r1, Iterable.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r8, Collection.class) == true) goto L16;
    L18:
        Iterator r9 = r8.iterator();
    L20:
        if (r9.hasNext() == false) goto L17;
        if (((com.obric.autoaction.vdplayer.legacy.d.a) ZeusTransformUtils.preCheckCast(r9.next(), com.obric.autoaction.vdplayer.legacy.d.a.class, "com.obric.aiagent.plugin")).b() == false) goto L20;
        boolean r10 = true;
    L24:
        int r11 = ((Collection) ZeusTransformUtils.preCheckCast(r1, Collection.class, "com.obric.aiagent.plugin")).size();
        int r12 = 0;
    L25:
        if (r12 >= r11) goto L60;
        View r13 = r4.getChildAt(r12);
        if (ZeusTransformUtils.instanceOf(r13, PanelActionButton.class) == false) goto L29;
        PanelActionButton r14 = (PanelActionButton) ZeusTransformUtils.preCheckCast(r13, PanelActionButton.class, "com.obric.aiagent.plugin");
    L30:
        final com.obric.autoaction.vdplayer.legacy.d.a r15 = (com.obric.autoaction.vdplayer.legacy.d.a) ZeusTransformUtils.preCheckCast(r1.get(r12), com.obric.autoaction.vdplayer.legacy.d.a.class, "com.obric.aiagent.plugin");
        if (r14 == null) goto L49;
        if (r15.getType() != com.obric.autoaction.vdplayer.legacy.d.b.f25872b) goto L36;
        if (r20 == false) goto L36;
        r14.bind(com.obric.autoaction.vdplayer.legacy.d.a.a(r15, com.obric.autoaction.vdplayer.legacy.d.b.f25873c, false, false, null, 14, null));
    L37:
        com.obric.autoaction.view.a.a((View) ZeusTransformUtils.preCheckCast(r14, View.class, "com.obric.aiagent.plugin"), 0, new $$Lambda$PanelExpandedComponent$TwZ4ntn5lkjwtpmyLNA8_VUdPno(this, r15), 1, null);
        if (r12 != p.b(r1)) goto L40;
        int r16 = 0;
    L41:
        float r17 = 1.0f;
        if (r10 == false) goto L48;
        View r18 = (View) ZeusTransformUtils.preCheckCast(r14, View.class, "com.obric.aiagent.plugin");
        ViewGroup.LayoutParams r110 = r18.getLayoutParams();
        Objects.requireNonNull(r110, "null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
        ViewGroup.LayoutParams r111 = (ViewGroup.LayoutParams) ZeusTransformUtils.preCheckCast((LinearLayout.LayoutParams) ZeusTransformUtils.preCheckCast(r110, LinearLayout.LayoutParams.class, "com.obric.aiagent.plugin"), ViewGroup.LayoutParams.class, "com.obric.aiagent.plugin");
        LinearLayout.LayoutParams r112 = (LinearLayout.LayoutParams) ZeusTransformUtils.preCheckCast(r111, LinearLayout.LayoutParams.class, "com.obric.aiagent.plugin");
        if (r15.b() == true) goto L47;
        r17 = 0.0f;
    L47:
        r112.weight = r17;
        r112.rightMargin = r16;
        r18.setLayoutParams(r111);
        goto L49
    L48:
        View r21 = (View) ZeusTransformUtils.preCheckCast(r14, View.class, "com.obric.aiagent.plugin");
        ViewGroup.LayoutParams r113 = r21.getLayoutParams();
        Objects.requireNonNull(r113, "null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
        ViewGroup.LayoutParams r114 = (ViewGroup.LayoutParams) ZeusTransformUtils.preCheckCast((LinearLayout.LayoutParams) ZeusTransformUtils.preCheckCast(r113, LinearLayout.LayoutParams.class, "com.obric.aiagent.plugin"), ViewGroup.LayoutParams.class, "com.obric.aiagent.plugin");
        LinearLayout.LayoutParams r115 = (LinearLayout.LayoutParams) ZeusTransformUtils.preCheckCast(r114, LinearLayout.LayoutParams.class, "com.obric.aiagent.plugin");
        r115.weight = 1.0f;
        r115.rightMargin = r16;
        r21.setLayoutParams(r114);
        goto L49
    L40:
        r16 = d.i.a.a(TypedValue.applyDimension(1, 4, Resources.getSystem().getDisplayMetrics()));
    L36:
        r14.bind(r15);
    L49:
        r12 = r12 + 1;
        goto L25
    L29:
        r14 = null;
        goto L30
    L60:
        return;
    L17:
        r10 = false;
        goto L24
    L16:
        if (((Collection) ZeusTransformUtils.preCheckCast(r8, Collection.class, "com.obric.aiagent.plugin")).isEmpty() == false) goto L18;
    }

    private static final x a(PanelExpandedComponent r1, com.obric.autoaction.vdplayer.legacy.d.a r2, View r3) {
        o.e(r3, "it");
        r1.a(r2.getType());
        return x.f38692a;
    }

    private final void a(com.obric.autoaction.vdplayer.legacy.d.b r6) {
        switch(b.f25843a[r6.ordinal()]) {
            case 1: goto L13;
            case 2: goto L12;
            case 3: goto L11;
            case 4: goto L11;
            case 5: goto L10;
            case 6: goto L9;
            case 7: goto L8;
            case 8: goto L7;
            case 9: goto L7;
            case 10: goto L6;
            default: goto L5;
        };
    L6:
        r r0 = (r) ZeusTransformUtils.preCheckCast(new r.e(true), r.class, "com.obric.aiagent.plugin");
    L14:
        a(r0);
        if (r6 == com.obric.autoaction.vdplayer.legacy.d.b.f) goto L17;
        return;
    L17:
        if (AutoActionConfigs.INSTANCE.getBooleanCfg("vlm.common.enable_operate_panel_stop_to_finish", true) == false) goto L25;
        l r7 = this.f25837b;
        if (r7 == null) goto L26;
        LinearLayout r8 = r7.f31636c;
        if (r8 == null) goto L27;
        r8.postDelayed(new $$Lambda$PanelExpandedComponent$xVIy7mmvpbj2BArPiahgfmEZiVY(this), 500);
        return;
    L27:
        return;
    L26:
        return;
    L25:
        return;
    L7:
        r0 = (r) ZeusTransformUtils.preCheckCast(r.l.f25956a, r.class, "com.obric.aiagent.plugin");
        goto L14
    L8:
        r0 = (r) ZeusTransformUtils.preCheckCast(r.b.f25945a, r.class, "com.obric.aiagent.plugin");
        goto L14
    L9:
        r0 = (r) ZeusTransformUtils.preCheckCast(r.a.f25944a, r.class, "com.obric.aiagent.plugin");
        goto L14
    L10:
        r0 = (r) ZeusTransformUtils.preCheckCast(new r.i("Clarify", d()), r.class, "com.obric.aiagent.plugin");
        goto L14
    L11:
        r0 = (r) ZeusTransformUtils.preCheckCast(new r.i("Supplement", d()), r.class, "com.obric.aiagent.plugin");
        goto L14
    L12:
        r0 = (r) ZeusTransformUtils.preCheckCast(r.d.f25947a, r.class, "com.obric.aiagent.plugin");
        goto L14
    L13:
        r0 = (r) ZeusTransformUtils.preCheckCast(r.n.f25958a, r.class, "com.obric.aiagent.plugin");
        goto L14
    L5:
        throw new d.k();
    }

    private static final void a(PanelExpandedComponent r3) {
        r3.a((r) ZeusTransformUtils.preCheckCast(new r.e(true), r.class, "com.obric.aiagent.plugin"));
    }

    private final String d() {
        com.obric.autoaction.a.c r3 = this.f25838c;
        if (r3 == null) goto L5;
        Context r4 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r3.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
    L7:
        if (ZeusTransformUtils.instanceOf(r4, Activity.class) == false) goto L9;
        Activity r5 = (Activity) ZeusTransformUtils.preCheckCast(r4, Activity.class, "com.obric.aiagent.plugin");
    L10:
        if (r5 == null) goto L12;
        Intent r6 = r5.getIntent();
    L13:
        if (r6 != null) goto L15;
        return null;
    L15:
        return r6.getStringExtra("source_from");
    L12:
        r6 = null;
        goto L13
    L9:
        r5 = null;
        goto L10
    L5:
        r4 = null;
        goto L7
    }

    @Override // androidx.lifecycle.d
    public void e(androidx.lifecycle.p r3) {
        androidx.lifecycle.p r4 = (androidx.lifecycle.p) ZeusTransformUtils.wrapperContextForParams(r3, androidx.lifecycle.p.class, "com.obric.aiagent.plugin");
        o.e(r4, "owner");
        super.e(r4);
        this.f25837b = null;
        this.f25838c = null;
    }
}
