package com.obric.autoaction.vdplayer.components.panel;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.text.Layout;
import android.text.StaticLayout;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.obric.aiagent.plugin.R;
import com.obric.autoaction.vdplayer.components.BaseVDPlayerSlotComponent;
import com.obric.autoaction.vdplayer.d.i;
import com.obric.autoaction.vdplayer.d.l;
import com.obric.autoaction.vdplayer.d.r;
import com.obric.autoaction.vdplayer.d.s;
import com.obric.autogui.common.api.AOPackagesTools;
import com.obric.autogui.common.api.configs.AutoActionConfigs;
import com.obric.autogui.vdplayer.a.g;
import com.obric.oui.avatar.OCircleImageView;
import com.obric.oui.button.OButton;
import com.obric.oui.markdown.OMarkdownView;
import com.obric.oui.markdown.e;
import com.obric.oui.text.OTextView;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.a.p;
import d.h.b.h;
import d.h.b.o;
import d.l.n;
import d.o.k;
import d.x;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/* JADX INFO: compiled from: PanelExpandedComponent.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class PanelExpandedComponent extends BaseVDPlayerSlotComponent<b> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final a f25427a = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final int f25428e = 0;
    private static final int f = 0;
    private static final int g = 0;
    private static final int h = 0;
    private static final int i = 0;
    private static final int j = 0;
    private static final int k = 0;
    private static final List<k> l = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private g f25429b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private com.obric.autoaction.a.c f25430c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f25431d;

    /* JADX INFO: compiled from: PanelExpandedComponent.kt */
    private static final class a {
        public /* synthetic */ a(h r1) {
            this();
        }

        private a() {
        }
    }

    /* JADX INFO: compiled from: PanelExpandedComponent.kt */
    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final com.obric.autoaction.vdplayer.d.h f25432a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final i f25433b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final List<com.obric.autoaction.vdplayer.d.a> f25434c;

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, b.class) == true) goto L8;
            return false;
        L8:
            b r6 = (b) ZeusTransformUtils.preCheckCast(r5, b.class, "com.obric.aiagent.plugin");
            if (o.a(this.f25432a, r6.f25432a) == true) goto L12;
            return false;
        L12:
            if (o.a(this.f25433b, r6.f25433b) == true) goto L15;
            return false;
        L15:
            if (o.a(this.f25434c, r6.f25434c) == true) goto L17;
            return false;
        L17:
            return true;
        }

        public int hashCode() {
            return (((this.f25432a.hashCode() * 31) + this.f25433b.hashCode()) * 31) + this.f25434c.hashCode();
        }

        public String toString() {
            return "PanelUiModel(opAppInfo=" + this.f25432a + ", panelData=" + this.f25433b + ", actionButtons=" + this.f25434c + ')';
        }

        public b(com.obric.autoaction.vdplayer.d.h r3, i r4, List<com.obric.autoaction.vdplayer.d.a> r5) {
            List<com.obric.autoaction.vdplayer.d.a> r6 = (List) ZeusTransformUtils.wrapperContextForParams(r5, List.class, "com.obric.aiagent.plugin");
            o.e(r3, "opAppInfo");
            o.e(r4, "panelData");
            o.e(r6, "actionButtons");
            this.f25432a = r3;
            this.f25433b = r4;
            this.f25434c = r6;
        }

        public final com.obric.autoaction.vdplayer.d.h a() {
            return this.f25432a;
        }

        public final i b() {
            return this.f25433b;
        }

        public final List<com.obric.autoaction.vdplayer.d.a> c() {
            return this.f25434c;
        }
    }

    /* JADX INFO: compiled from: PanelExpandedComponent.kt */
    public /* synthetic */ class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f25435a = null;

        static {
            int[] r0 = new int[com.obric.autoaction.vdplayer.d.b.values().length];
            r0[com.obric.autoaction.vdplayer.d.b.f.ordinal()] = 1;     // Catch: NoSuchFieldError -> L15
        L27:
            r0[com.obric.autoaction.vdplayer.d.b.g.ordinal()] = 2;     // Catch: NoSuchFieldError -> L16
        L43:
            r0[com.obric.autoaction.vdplayer.d.b.f25465b.ordinal()] = 3;     // Catch: NoSuchFieldError -> L17
        L31:
            r0[com.obric.autoaction.vdplayer.d.b.f25466c.ordinal()] = 4;     // Catch: NoSuchFieldError -> L18
        L35:
            r0[com.obric.autoaction.vdplayer.d.b.f25464a.ordinal()] = 5;     // Catch: NoSuchFieldError -> L19
        L25:
            r0[com.obric.autoaction.vdplayer.d.b.f25467d.ordinal()] = 6;     // Catch: NoSuchFieldError -> L20
        L37:
            r0[com.obric.autoaction.vdplayer.d.b.f25468e.ordinal()] = 7;     // Catch: NoSuchFieldError -> L21
        L39:
            r0[com.obric.autoaction.vdplayer.d.b.h.ordinal()] = 8;     // Catch: NoSuchFieldError -> L22
        L29:
            r0[com.obric.autoaction.vdplayer.d.b.i.ordinal()] = 9;     // Catch: NoSuchFieldError -> L23
        L33:
            r0[com.obric.autoaction.vdplayer.d.b.j.ordinal()] = 10;     // Catch: NoSuchFieldError -> L24
        L13:
            f25435a = r0;
        }
    }

    /* JADX INFO: compiled from: PanelExpandedComponent.kt */
    public static final class d implements OMarkdownView.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ PanelExpandedComponent f25436a;

        d(PanelExpandedComponent r1) {
            this.f25436a = r1;
        }

        @Override // com.obric.oui.markdown.OMarkdownView.a
        public Drawable a(String r1) {
            return OMarkdownView.a.C0959a.c(this, r1);
        }

        @Override // com.obric.oui.markdown.OMarkdownView.a
        public void a(int r1, int r2, int r3) {
            OMarkdownView.a.C0959a.a(this, r1, r2, r3);
        }

        @Override // com.obric.oui.markdown.OMarkdownView.a
        public boolean a() {
            return OMarkdownView.a.C0959a.c(this);
        }

        @Override // com.obric.oui.markdown.OMarkdownView.a
        public void b() {
            OMarkdownView.a.C0959a.b(this);
        }

        @Override // com.obric.oui.markdown.OMarkdownView.a
        public void c() {
            OMarkdownView.a.C0959a.a(this);
        }

        @Override // com.obric.oui.markdown.OMarkdownView.a
        public void c(String r1) {
            OMarkdownView.a.C0959a.a(this, r1);
        }

        @Override // com.obric.oui.markdown.OMarkdownView.a
        public void b(String r2) {
            o.e(r2, "link");
            OMarkdownView.a.C0959a.b(this, r2);
            PanelExpandedComponent.a(this.f25436a, r2);
        }
    }

    /* JADX INFO: renamed from: lambda$9G-ZNp3_R_ntPhsRKi96XOPBYaY, reason: not valid java name */
    public static /* synthetic */ Drawable m674lambda$9GZNp3_R_ntPhsRKi96XOPBYaY(g r0) {
        return e(r0);
    }

    /* JADX INFO: renamed from: lambda$GudKLd_Z4fY3g8loo6Fcs47-eU8, reason: not valid java name */
    public static /* synthetic */ void m675lambda$GudKLd_Z4fY3g8loo6Fcs47eU8(PanelExpandedComponent r0) {
        a(r0);
    }

    /* JADX INFO: renamed from: lambda$JkJoSM70EUwjg_WuX6aOswN-wvs, reason: not valid java name */
    public static /* synthetic */ void m676lambda$JkJoSM70EUwjg_WuX6aOswNwvs(PanelExpandedComponent r0, View r1) {
        b(r0, r1);
    }

    /* JADX INFO: renamed from: lambda$S4NjKHatA2xcPsbCPK8ud1-r7Zk, reason: not valid java name */
    public static /* synthetic */ x m677lambda$S4NjKHatA2xcPsbCPK8ud1r7Zk(PanelExpandedComponent r0, String r1, View r2) {
        return a(r0, r1, r2);
    }

    public static /* synthetic */ b lambda$WXvCtWiQsKSKSIX20TUl15g3SPU(s r0) {
        return a(r0);
    }

    public static /* synthetic */ x lambda$clEQbA2yYV585qkByi1cen35ips(PanelExpandedComponent r0, com.obric.autoaction.vdplayer.d.a r1, View r2) {
        return a(r0, r1, r2);
    }

    public static /* synthetic */ void lambda$d3krTS7PrNkEssXHU3DUTMj8bHg(PanelExpandedComponent r0, View r1) {
        a(r0, r1);
    }

    /* JADX INFO: renamed from: lambda$tr0zWCN9IXNdNomAGPs-MDQo4tk, reason: not valid java name */
    public static /* synthetic */ void m678lambda$tr0zWCN9IXNdNomAGPsMDQo4tk(TextView r0, PanelExpandedComponent r1) {
        a(r0, r1);
    }

    public PanelExpandedComponent() {
        super($$Lambda$PanelExpandedComponent$WXvCtWiQsKSKSIX20TUl15g3SPU.INSTANCE);
    }

    public static final /* synthetic */ void a(PanelExpandedComponent r0, String r1) {
        r0.d(r1);
    }

    @Override // com.obric.autoaction.vdplayer.components.BaseVDPlayerComponent
    public /* synthetic */ void a(Object r3, Object r4) {
        a((b) ZeusTransformUtils.preCheckCast(r3, b.class, "com.obric.aiagent.plugin"), (b) ZeusTransformUtils.preCheckCast(r4, b.class, "com.obric.aiagent.plugin"));
    }

    private static final b a(s r3) {
        o.e(r3, "it");
        return new b(r3.c(), r3.b().a(), r3.b().b());
    }

    @Override // com.obric.autoaction.vdplayer.components.BaseVDPlayerComponent, com.obric.autoaction.a.f
    public void a(com.obric.autoaction.a.c r2) {
        o.e(r2, "componentHost");
        super.a(r2);
        this.f25430c = r2;
    }

    @Override // com.obric.autoaction.a.g
    public View a(ViewGroup r3, com.obric.autoaction.a.c r4) {
        o.e(r3, "container");
        o.e(r4, "componentHost");
        g r5 = g.a(LayoutInflater.from((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r3.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")), r3, false);
        o.c(r5, "inflate(...)");
        this.f25429b = r5;
        r5.b().setOnClickListener(null);
        a(r5);
        b(r5);
        FrameLayout r2 = r5.b();
        o.c(r2, "getRoot(...)");
        return (View) ZeusTransformUtils.preCheckCast(r2, View.class, "com.obric.aiagent.plugin");
    }

    public void a(b r5, b r6) {
        o.e(r6, "new");
        boolean r0 = this.f25431d;
        l r1 = null;
        if (r5 == null) goto L5;
        com.obric.autoaction.vdplayer.d.h r2 = r5.a();
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
        if (r5 == null) goto L17;
        List<com.obric.autoaction.vdplayer.d.a> r4 = r5.c();
    L19:
        if (o.a(r4, r6.c()) == false) goto L28;
        if (r5 == null) goto L25;
        i r7 = r5.b();
        if (r7 == null) goto L25;
        r1 = r7.a();
    L25:
        if (r1 != r6.b().a()) goto L28;
        if (r0 != this.f25431d) goto L28;
        return;
    L28:
        a(r6.c(), this.f25431d, r6.b().a());
        return;
    L17:
        r4 = null;
        goto L19
    L11:
        r3 = null;
        goto L13
    L5:
        r2 = null;
        goto L7
    }

    private final void a(g r3) {
        View.OnClickListener r0 = new $$Lambda$PanelExpandedComponent$d3krTS7PrNkEssXHU3DUTMj8bHg(this);
        r3.f31615b.setOnClickListener(r0);
        r3.f31616c.setOnClickListener(r0);
        d(r3);
    }

    private static final void a(PanelExpandedComponent r2, View r3) {
        r2.a((r) ZeusTransformUtils.preCheckCast(r.C0625r.f25557a, r.class, "com.obric.aiagent.plugin"));
    }

    private final void a(i r12) {
        g r0 = this.f25429b;
        if (r0 != null) goto L5;
        return;
    L5:
        com.obric.autoaction.vdplayer.components.panel.c r1 = com.obric.autoaction.vdplayer.components.panel.c.f25447a.a(r12.a());
        if (r1 == null) goto L19;
        int r7 = androidx.core.content.a.c((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r0.b().getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), r1.b());
        r0.q.setText((CharSequence) ZeusTransformUtils.preCheckCast(((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r0.b().getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")).getString(r1.a()), CharSequence.class, "com.obric.aiagent.plugin"));
        r0.q.setTextColor(r7);
        r0.j.setImageResource(r1.c());
        r0.j.setImageTintList(ColorStateList.valueOf(r7));
        LinearLayout r2 = r0.m;
        o.c(r2, "panelContentLayout");
        com.obric.oui.common.util.k.a((View) ZeusTransformUtils.preCheckCast(r2, View.class, "com.obric.aiagent.plugin"));
        if (a(r12.a()) == false) goto L10;
        ImageButton r3 = r0.f31615b;
        o.c(r3, "collapseButtonFloating");
        com.obric.oui.common.util.k.b((View) ZeusTransformUtils.preCheckCast(r3, View.class, "com.obric.aiagent.plugin"));
    L11:
        a(r0, r12);
        this.f25431d = a(r0, r12.c(), r12.e());
        if (b(r12.a()) == false) goto L14;
    L17:
        int r13 = d.i.a.a(TypedValue.applyDimension(1, 0, Resources.getSystem().getDisplayMetrics()));
    L18:
        r0.f31614a.setPadding(0, 0, 0, r13);
    L20:
        d(r0);
        return;
    L14:
        if (a(r12.a()) == true) goto L17;
        r13 = d.i.a.a(TypedValue.applyDimension(1, 4, Resources.getSystem().getDisplayMetrics()));
        goto L18
    L10:
        ImageButton r4 = r0.f31615b;
        o.c(r4, "collapseButtonFloating");
        com.obric.oui.common.util.k.a((View) ZeusTransformUtils.preCheckCast(r4, View.class, "com.obric.aiagent.plugin"));
        goto L11
    L19:
        LinearLayout r14 = r0.m;
        o.c(r14, "panelContentLayout");
        com.obric.oui.common.util.k.b((View) ZeusTransformUtils.preCheckCast(r14, View.class, "com.obric.aiagent.plugin"));
        ImageButton r15 = r0.f31615b;
        o.c(r15, "collapseButtonFloating");
        com.obric.oui.common.util.k.b((View) ZeusTransformUtils.preCheckCast(r15, View.class, "com.obric.aiagent.plugin"));
        r0.f31614a.setPadding(0, 0, 0, d.i.a.a(TypedValue.applyDimension(1, 0, Resources.getSystem().getDisplayMetrics())));
        this.f25431d = false;
        goto L20
    }

    private final void b(g r32) {
        Context r1 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r32.b().getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
        o.a(r1);
        String r14 = e.a(r1, ZeusTransformUtils.mapRes(R.color.oui_basic_text_1, "color", "oui_basic_text_1"));
        String r2 = e.a(r1, ZeusTransformUtils.mapRes(R.color.oui_basic_text_3, "color", "oui_basic_text_3"));
        r32.k.setDelegate((OMarkdownView.a) ZeusTransformUtils.preCheckCast(new d(this), OMarkdownView.a.class, "com.obric.aiagent.plugin"));
        VDPlayerMarkdownView r3 = r32.k;
        com.obric.oui.markdown.d r13 = new com.obric.oui.markdown.d(r1, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, 0, false, 0, 0, 0, 8388606, null);
        HashMap<String, Object> r4 = r13.b();
        Float r5 = Float.valueOf(14.0f);
        r4.put("fontSize", r5);
        r4.put("lineHeight", 20);
        r4.put("paragraphSpace", 6);
        r4.put("color", r14);
        HashMap<String, Object> r6 = r13.c();
        r6.put("fontSize", Float.valueOf(18.0f));
        r6.put("lineHeight", 26);
        r6.put("paragraphSpace", 8);
        r6.put("color", r14);
        HashMap<String, Object> r7 = r13.d();
        r7.put("fontSize", Float.valueOf(16.0f));
        r7.put("lineHeight", 24);
        r7.put("paragraphSpace", 8);
        r7.put("color", r14);
        HashMap<String, Object> r8 = r13.e();
        r8.put("fontSize", Float.valueOf(15.0f));
        r8.put("lineHeight", 22);
        r8.put("paragraphSpace", 6);
        r8.put("color", r14);
        HashMap<String, Object> r9 = r13.k();
        r9.put("fontSize", Float.valueOf(13.0f));
        r9.put("lineHeight", 19);
        r9.put("paragraphSpace", 6);
        r9.put("color", r2);
        r13.j().put("fontSize", r5);
        HashMap<String, Object> r10 = r13.m();
        r10.put("paragraphSpace", 4);
        r10.put("marginBottom", 6);
        r10.put("markColor", r14);
        r10.put("markMarginLeft", 8);
        r10.put("markMarginRight", 8);
        HashMap<String, Object> r11 = r13.l();
        r11.put("paragraphSpace", 4);
        r11.put("marginBottom", 6);
        r11.put("indent", 20);
        r3.setStyle(r13);
        r32.k.setMaxMarkdownHeightPx(f25428e);
    }

    private final void a(g r8, i r9) {
        String r0 = r9.b();
        if (r0 != null) goto L5;
        r0 = "";
    L5:
        String r3 = r0;
        if (b(r9.a()) == false) goto L8;
    L11:
        int r1 = d.i.a.a(TypedValue.applyDimension(1, 0, Resources.getSystem().getDisplayMetrics()));
    L12:
        r8.p.setPadding(r1, r8.p.getPaddingTop(), r1, r8.p.getPaddingBottom());
        r8.k.setPadding(r1, r8.k.getPaddingTop(), r1, r8.k.getPaddingBottom());
        ConstraintLayout r2 = r8.f31617d;
        o.c(r2, "contentBodyContainer");
        View r4 = (View) ZeusTransformUtils.preCheckCast(r2, View.class, "com.obric.aiagent.plugin");
        ViewGroup.LayoutParams r5 = r4.getLayoutParams();
        Objects.requireNonNull(r5, "null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
        ViewGroup.LayoutParams r6 = (ViewGroup.LayoutParams) ZeusTransformUtils.preCheckCast((LinearLayout.LayoutParams) ZeusTransformUtils.preCheckCast(r5, LinearLayout.LayoutParams.class, "com.obric.aiagent.plugin"), ViewGroup.LayoutParams.class, "com.obric.aiagent.plugin");
        LinearLayout.LayoutParams r7 = (LinearLayout.LayoutParams) ZeusTransformUtils.preCheckCast(r6, LinearLayout.LayoutParams.class, "com.obric.aiagent.plugin");
        if (a(r9.a()) == false) goto L15;
        float r10 = 8;
        DisplayMetrics r11 = Resources.getSystem().getDisplayMetrics();
    L16:
        r7.topMargin = d.i.a.a(TypedValue.applyDimension(1, r10, r11));
        r4.setLayoutParams(r6);
        if (a(r9.a()) == false) goto L19;
        a(r8, r3);
        return;
    L19:
        a(this, r8, r3, null, 4, null);
        return;
    L15:
        r10 = 12;
        r11 = Resources.getSystem().getDisplayMetrics();
        goto L16
    L8:
        if (a(r9.a()) == true) goto L11;
        r1 = d.i.a.a(TypedValue.applyDimension(1, 4, Resources.getSystem().getDisplayMetrics()));
        goto L12
    }

    private final void a(g r3, String r4) {
        if (a(r4) == false) goto L6;
        b(r3, r4);
        return;
    L6:
        int r0 = c(r3, r4);
        if (r0 <= 1) goto L10;
        b(r3, r4);
        return;
    L10:
        a(r3, r4, Integer.valueOf(r0));
    }

    private final void b(g r3, String r4) {
        ScrollView r2 = r3.f31618e;
        o.c(r2, "contentScrollView");
        com.obric.oui.common.util.k.b((View) ZeusTransformUtils.preCheckCast(r2, View.class, "com.obric.aiagent.plugin"));
        VDPlayerMarkdownView r5 = r3.k;
        o.c(r5, "markdownContentView");
        com.obric.oui.common.util.k.a((View) ZeusTransformUtils.preCheckCast(r5, View.class, "com.obric.aiagent.plugin"));
        r3.k.scrollContentToTop();
        r3.k.setMarkdownContent(r4);
        r3.k.requestLayout();
    }

    static /* synthetic */ void a(PanelExpandedComponent r0, g r1, String r2, Integer r3, int r4, Object r5) {
        if ((r4 & 4) == 0) goto L5;
        r3 = null;
    L5:
        r0.a(r1, r2, r3);
    }

    private final void a(g r4, String r5, Integer r6) {
        VDPlayerMarkdownView r0 = r4.k;
        o.c(r0, "markdownContentView");
        com.obric.oui.common.util.k.b((View) ZeusTransformUtils.preCheckCast(r0, View.class, "com.obric.aiagent.plugin"));
        ScrollView r1 = r4.f31618e;
        o.c(r1, "contentScrollView");
        com.obric.oui.common.util.k.a((View) ZeusTransformUtils.preCheckCast(r1, View.class, "com.obric.aiagent.plugin"));
        OTextView r7 = r4.p;
        o.c(r7, "tvContent");
        a((TextView) ZeusTransformUtils.preCheckCast(r7, TextView.class, "com.obric.aiagent.plugin"), r5, r6);
    }

    private final int c(g r12, String r13) {
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r13, CharSequence.class, "com.obric.aiagent.plugin")).length() != 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L8;
        return 0;
    L8:
        OTextView r1 = r12.p;
        o.c(r1, "tvContent");
        return new StaticLayout((CharSequence) ZeusTransformUtils.preCheckCast(r13, CharSequence.class, "com.obric.aiagent.plugin"), r1.getPaint(), c(r12), Layout.Alignment.ALIGN_NORMAL, r1.getLineSpacingMultiplier(), r1.getLineSpacingExtra(), r1.getIncludeFontPadding()).getLineCount();
    L5:
        r0 = false;
        goto L6
    }

    private final int c(g r8) {
        OTextView r7 = r8.p;
        o.c(r7, "tvContent");
        int r0 = r7.getPaddingLeft() + r7.getPaddingRight();
        Iterator r9 = ((Iterable) ZeusTransformUtils.preCheckCast(p.b(new Integer[]{Integer.valueOf(r7.getWidth()), Integer.valueOf(r7.getMeasuredWidth()), Integer.valueOf(r8.f31618e.getWidth()), Integer.valueOf(r8.f31618e.getMeasuredWidth()), Integer.valueOf(r8.f31617d.getWidth()), Integer.valueOf(r8.f31617d.getMeasuredWidth()), Integer.valueOf(r8.m.getWidth()), Integer.valueOf(r8.m.getMeasuredWidth())}), Iterable.class, "com.obric.aiagent.plugin")).iterator();
    L4:
        if (r9.hasNext() == false) goto L11;
        Object r1 = r9.next();
        if (((Number) ZeusTransformUtils.preCheckCast(r1, Number.class, "com.obric.aiagent.plugin")).intValue() <= r0) goto L8;
        boolean r6 = true;
    L9:
        if (r6 == false) goto L4;
    L12:
        Integer r10 = (Integer) ZeusTransformUtils.preCheckCast(r1, Integer.class, "com.obric.aiagent.plugin");
        int r11 = ZeusTransformUtils.getResources(r8.b(), "com.obric.aiagent.plugin").getDisplayMetrics().widthPixels - (k * 2);
        if (r10 == null) goto L16;
        r11 = r10.intValue();
    L16:
        return n.c(r11 - r0, 1);
    L8:
        r6 = false;
        goto L9
    L11:
        r1 = null;
        goto L12
    }

    private final boolean a(String r4) {
        if (b(r4) == false) goto L5;
    L10:
        return true;
    L5:
        if (d.o.o.a((CharSequence) ZeusTransformUtils.preCheckCast(r4, CharSequence.class, "com.obric.aiagent.plugin")).toString().length() > 48) goto L10;
        if (c(d.o.o.a((CharSequence) ZeusTransformUtils.preCheckCast(r4, CharSequence.class, "com.obric.aiagent.plugin")).toString()) == true) goto L10;
        return false;
    }

    private final boolean b(String r5) {
        CharSequence r4 = (CharSequence) ZeusTransformUtils.preCheckCast(r5, CharSequence.class, "com.obric.aiagent.plugin");
        int r0 = 0;
    L4:
        if (r0 >= r4.length()) goto L18;
        char r1 = r4.charAt(r0);
        if (r1 != '\n') goto L8;
    L11:
        boolean r2 = true;
    L12:
        if (r2 == true) goto L15;
        r0 = r0 + 1;
        goto L4
    L15:
        return true;
    L8:
        if (r1 == '\r') goto L11;
        r2 = false;
        goto L12
    L18:
        return false;
    }

    private final boolean c(String r5) {
        Iterable r4 = (Iterable) ZeusTransformUtils.preCheckCast(l, Iterable.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r4, Collection.class) == true) goto L5;
    L7:
        Iterator r6 = r4.iterator();
    L9:
        if (r6.hasNext() == false) goto L18;
        if (((k) ZeusTransformUtils.preCheckCast(r6.next(), k.class, "com.obric.aiagent.plugin")).b((CharSequence) ZeusTransformUtils.preCheckCast(r5, CharSequence.class, "com.obric.aiagent.plugin")) == false) goto L9;
        return true;
    L18:
        return false;
    L5:
        if (((Collection) ZeusTransformUtils.preCheckCast(r4, Collection.class, "com.obric.aiagent.plugin")).isEmpty() == false) goto L7;
        return false;
    }

    private final void a(final TextView r3, String r4, Integer r5) {
        r3.setText((CharSequence) ZeusTransformUtils.preCheckCast(r4, CharSequence.class, "com.obric.aiagent.plugin"));
        if (r5 == null) goto L6;
        a(r3, r5.intValue());
        return;
    L6:
        r3.post(new $$Lambda$PanelExpandedComponent$tr0zWCN9IXNdNomAGPsMDQo4tk(r3, this));
    }

    private static final void a(TextView r1, PanelExpandedComponent r2) {
        Layout r0 = r1.getLayout();
        if (r0 == null) goto L6;
        r2.a(r1, r0.getLineCount());
        return;
    }

    private final void a(TextView r1, int r2) {
        if (r2 <= 1) goto L5;
        int r0 = 8388627;
    L6:
        r1.setGravity(r0);
        return;
    L5:
        r0 = 17;
        goto L6
    }

    private final boolean a(g r18, List<String> r19, Map<Integer, String> r20) {
        List r1 = (List) ZeusTransformUtils.wrapperContextForParams(r19, List.class, "com.obric.aiagent.plugin");
        Map r3 = (Map) ZeusTransformUtils.wrapperContextForParams(r20, Map.class, "com.obric.aiagent.plugin");
        if (r1 != null) goto L5;
    L81:
        LinearLayout r0 = r18.l;
        o.c(r0, "optionGroup");
        com.obric.oui.common.util.k.b((View) ZeusTransformUtils.preCheckCast(r0, View.class, "com.obric.aiagent.plugin"));
        return false;
    L5:
        if (r1.isEmpty() == true) goto L81;
        if (r1.size() > 3) goto L81;
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
        if (r9 == true) goto L81;
        LinearLayout r10 = r18.l;
        o.c(r10, "optionGroup");
        com.obric.oui.common.util.k.a((View) ZeusTransformUtils.preCheckCast(r10, View.class, "com.obric.aiagent.plugin"));
        r18.l.setShowDividers(2);
        if (r1.size() != 2) goto L44;
        Iterable r4 = (Iterable) ZeusTransformUtils.preCheckCast(r1, Iterable.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r4, Collection.class) == true) goto L29;
    L31:
        Iterator r5 = r4.iterator();
    L33:
        if (r5.hasNext() == false) goto L30;
        if (((String) ZeusTransformUtils.preCheckCast(r5.next(), String.class, "com.obric.aiagent.plugin")).length() > 7) goto L37;
        boolean r11 = true;
    L38:
        if (r11 == true) goto L33;
        boolean r12 = false;
    L40:
        if (r12 == false) goto L44;
        r18.l.setOrientation(0);
        r18.l.setDividerDrawable(androidx.core.content.a.a((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r18.b().getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), ZeusTransformUtils.mapRes(R.drawable.vd_component_panel_content_option_divider_h, "drawable", "vd_component_panel_content_option_divider_h")));
    L42:
        boolean r13 = true;
    L62:
        r18.l.removeAllViews();
        Iterator r2 = ((Iterable) ZeusTransformUtils.preCheckCast(r1, Iterable.class, "com.obric.aiagent.plugin")).iterator();
        int r14 = 0;
    L64:
        if (r2.hasNext() == false) goto L80;
        Object r15 = r2.next();
        int r16 = r14 + 1;
        if (r14 >= 0) goto L68;
        p.c();
    L68:
        final String r17 = (String) ZeusTransformUtils.preCheckCast(r15, String.class, "com.obric.aiagent.plugin");
        View r110 = ZeusTransformUtils.inflate(LayoutInflater.from((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r18.b().getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")), ZeusTransformUtils.mapRes(R.layout.vd_component_panel_content_option, "layout", "vd_component_panel_content_option"), (ViewGroup) ZeusTransformUtils.preCheckCast(r18.l, ViewGroup.class, "com.obric.aiagent.plugin"), false, "com.obric.aiagent.plugin");
        o.a(r110, "null cannot be cast to non-null type com.obric.oui.button.OButton");
        OButton r111 = (OButton) ZeusTransformUtils.preCheckCast(r110, OButton.class, "com.obric.aiagent.plugin");
        r111.setText((CharSequence) ZeusTransformUtils.preCheckCast(r17, CharSequence.class, "com.obric.aiagent.plugin"));
        if (r3 == null) goto L71;
        String r21 = (String) ZeusTransformUtils.preCheckCast(r3.get(Integer.valueOf(r14)), String.class, "com.obric.aiagent.plugin");
    L73:
        if (o.a(r21, "AlwaysAllowNotice") == false) goto L75;
        r111.setTextColor(((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r18.b().getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")).getColor(ZeusTransformUtils.mapRes(R.color.oui_functional_blue_6, "color", "oui_functional_blue_6")));
    L75:
        int r22 = i;
        r111.setPadding(r22, r111.getPaddingTop(), r22, r111.getPaddingBottom());
        com.obric.autoaction.view.a.a((View) ZeusTransformUtils.preCheckCast(r111, View.class, "com.obric.aiagent.plugin"), 0, new $$Lambda$PanelExpandedComponent$S4NjKHatA2xcPsbCPK8ud1r7Zk(this, r17), 1, null);
        r111.setMinimumWidth(j);
        if (r13 == false) goto L78;
        LinearLayout.LayoutParams r23 = new LinearLayout.LayoutParams(0, h);
        r23.weight = 1.0f;
        Object r24 = ZeusTransformUtils.preCheckCast(r23, ViewGroup.LayoutParams.class, "com.obric.aiagent.plugin");
    L79:
        r111.setLayoutParams((ViewGroup.LayoutParams) r24);
        r18.l.addView((View) ZeusTransformUtils.preCheckCast(r111, View.class, "com.obric.aiagent.plugin"));
        r14 = r16;
        goto L64
    L78:
        r24 = ZeusTransformUtils.preCheckCast(new LinearLayout.LayoutParams(-1, h), ViewGroup.LayoutParams.class, "com.obric.aiagent.plugin");
        goto L79
    L71:
        r21 = null;
        goto L73
    L80:
        return true;
    L37:
        r11 = false;
    L30:
        r12 = true;
        goto L40
    L29:
        if (((Collection) ZeusTransformUtils.preCheckCast(r4, Collection.class, "com.obric.aiagent.plugin")).isEmpty() == false) goto L31;
    L44:
        if (r1.size() != 3) goto L61;
        Iterable r25 = (Iterable) ZeusTransformUtils.preCheckCast(r1, Iterable.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r25, Collection.class) == true) goto L48;
    L50:
        Iterator r26 = r25.iterator();
    L52:
        if (r26.hasNext() == false) goto L49;
        if (((String) ZeusTransformUtils.preCheckCast(r26.next(), String.class, "com.obric.aiagent.plugin")).length() > 4) goto L56;
        boolean r27 = true;
    L57:
        if (r27 == true) goto L52;
        boolean r28 = false;
    L59:
        if (r28 == false) goto L61;
        r18.l.setOrientation(0);
        r18.l.setDividerDrawable(androidx.core.content.a.a((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r18.b().getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), ZeusTransformUtils.mapRes(R.drawable.vd_component_panel_content_option_divider_h, "drawable", "vd_component_panel_content_option_divider_h")));
        goto L42
    L56:
        r27 = false;
    L49:
        r28 = true;
        goto L59
    L48:
        if (((Collection) ZeusTransformUtils.preCheckCast(r25, Collection.class, "com.obric.aiagent.plugin")).isEmpty() == false) goto L50;
    L61:
        r18.l.setOrientation(1);
        r18.l.setDividerDrawable(androidx.core.content.a.a((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r18.b().getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), ZeusTransformUtils.mapRes(R.drawable.vd_component_panel_content_option_divider_v, "drawable", "vd_component_panel_content_option_divider_v")));
        r13 = false;
        goto L62
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
        r1.a((r) ZeusTransformUtils.preCheckCast(new r.m(r2), r.class, "com.obric.aiagent.plugin"));
        return x.f38692a;
    }

    private final void a(com.obric.autoaction.vdplayer.d.h r11) {
        final g r0 = this.f25429b;
        if (r0 != null) goto L5;
        return;
    L5:
        Object r5 = null;
        if (r11.a() == true) goto L9;
        LinearLayout r10 = r0.n;
        o.c(r10, "prefixContainer");
        com.obric.oui.common.util.k.b((View) ZeusTransformUtils.preCheckCast(r10, View.class, "com.obric.aiagent.plugin"));
        LinearLayout r12 = r0.f;
        o.c(r12, "controlBar");
        View r13 = (View) ZeusTransformUtils.preCheckCast(r12, View.class, "com.obric.aiagent.plugin");
        ViewGroup.LayoutParams r14 = r13.getLayoutParams();
        Objects.requireNonNull(r14, "null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
        r14.width = -1;
        r13.setLayoutParams(r14);
        r0.n.setOnClickListener(null);
        return;
    L9:
        LinearLayout r1 = r0.f;
        o.c(r1, "controlBar");
        View r2 = (View) ZeusTransformUtils.preCheckCast(r1, View.class, "com.obric.aiagent.plugin");
        ViewGroup.LayoutParams r4 = r2.getLayoutParams();
        Objects.requireNonNull(r4, "null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
        r4.width = -2;
        r2.setLayoutParams(r4);
        LinearLayout r3 = r0.n;
        o.c(r3, "prefixContainer");
        com.obric.oui.common.util.k.a((View) ZeusTransformUtils.preCheckCast(r3, View.class, "com.obric.aiagent.plugin"));
        r0.o.setText((CharSequence) ZeusTransformUtils.preCheckCast(r11.b(), CharSequence.class, "com.obric.aiagent.plugin"));
        d.h.a.a r6 = new $$Lambda$PanelExpandedComponent$9GZNp3_R_ntPhsRKi96XOPBYaY(r0);
        String r15 = r11.c();
        if (r15 == null) goto L30;
        r0.i.setContentPadding(d.i.a.a(TypedValue.applyDimension(1, 0, Resources.getSystem().getDisplayMetrics())));
        OCircleImageView r7 = r0.i;
        ViewGroup.LayoutParams r8 = r0.i.getLayoutParams();
        if (ZeusTransformUtils.instanceOf(r8, ViewGroup.MarginLayoutParams.class) == false) goto L14;
        ViewGroup.MarginLayoutParams r9 = (ViewGroup.MarginLayoutParams) ZeusTransformUtils.preCheckCast(r8, ViewGroup.MarginLayoutParams.class, "com.obric.aiagent.plugin");
    L15:
        if (r9 == null) goto L17;
        ((ViewGroup.MarginLayoutParams) ZeusTransformUtils.preCheckCast(r8, ViewGroup.MarginLayoutParams.class, "com.obric.aiagent.plugin")).setMargins(0, 0, 0, 0);
    L17:
        float r16 = 32;
        r8.width = d.i.a.a(TypedValue.applyDimension(1, r16, Resources.getSystem().getDisplayMetrics()));
        r8.height = d.i.a.a(TypedValue.applyDimension(1, r16, Resources.getSystem().getDisplayMetrics()));
        r7.setLayoutParams(r8);
        r0.i.setPadding(0, 0, 0, 0);
        d.n.a r17 = d.n.f38560a;     // Catch: Throwable -> L20
        PanelExpandedComponent r18 = (PanelExpandedComponent) ZeusTransformUtils.preCheckCast(this, PanelExpandedComponent.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L20
        AOPackagesTools r19 = AOPackagesTools.INSTANCE;     // Catch: Throwable -> L20
        Context r20 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r0.b().getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L20
        o.c(r20, "getContext(...)");     // Catch: Throwable -> L20
        Object r110 = d.n.f(r19.getAppIconDrawable(r20, r15));     // Catch: Throwable -> L20
    L23:
        if (d.n.b(r110) == true) goto L26;
        r5 = r110;
    L26:
        Drawable r111 = (Drawable) ZeusTransformUtils.preCheckCast(r5, Drawable.class, "com.obric.aiagent.plugin");
        if (r111 != null) goto L29;
        r111 = (Drawable) ZeusTransformUtils.preCheckCast(r6.invoke(), Drawable.class, "com.obric.aiagent.plugin");
    L29:
        if (r111 == null) goto L30;
    L31:
        r0.i.setImageDrawable(r111);
        r0.i.setOnClickListener(new $$Lambda$PanelExpandedComponent$JkJoSM70EUwjg_WuX6aOswNwvs(this));
        return;
    L20:
        th = move-exception;
        d.n.a r21 = d.n.f38560a;
        r110 = d.n.f(d.o.a(th));
        goto L23
    L14:
        r9 = null;
    L30:
        r111 = (Drawable) ZeusTransformUtils.preCheckCast(r6.invoke(), Drawable.class, "com.obric.aiagent.plugin");
        goto L31
    }

    private static final Drawable e(g r4) {
        r4.i.setContentPadding(d.i.a.a(TypedValue.applyDimension(1, 4, Resources.getSystem().getDisplayMetrics())));
        return androidx.core.content.a.a((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r4.b().getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), ZeusTransformUtils.mapRes(R.drawable.ic_vd_hand_right_gradient, "drawable", "ic_vd_hand_right_gradient"));
    }

    private static final void b(PanelExpandedComponent r2, View r3) {
        r2.a((r) ZeusTransformUtils.preCheckCast(r.o.f25554a, r.class, "com.obric.aiagent.plugin"));
    }

    private final void a(List<com.obric.autoaction.vdplayer.d.a> r19, boolean r20, l r21) {
        List r2 = (List) ZeusTransformUtils.wrapperContextForParams(r19, List.class, "com.obric.aiagent.plugin");
        g r4 = this.f25429b;
        if (r4 == null) goto L72;
        LinearLayout r5 = r4.f;
        if (r5 == null) goto L80;
        g r6 = this.f25429b;
        if (r6 == null) goto L16;
        ImageButton r7 = r6.f31616c;
        if (r7 == null) goto L16;
        if (r21 != l.f25507a) goto L14;
        int r8 = 0;
    L15:
        r7.setVisibility(r8);
        goto L16
    L14:
        r8 = 8;
    L16:
        g r9 = this.f25429b;
        if (r9 == null) goto L20;
        d(r9);
    L20:
        if (r5.getChildCount() == r2.size()) goto L25;
        r5.removeAllViews();
        Iterator r10 = ((Iterable) ZeusTransformUtils.preCheckCast(r2, Iterable.class, "com.obric.aiagent.plugin")).iterator();
    L23:
        if (r10.hasNext() == false) goto L25;
        com.obric.autoaction.vdplayer.d.a r11 = (com.obric.autoaction.vdplayer.d.a) ZeusTransformUtils.preCheckCast(r10.next(), com.obric.autoaction.vdplayer.d.a.class, "com.obric.aiagent.plugin");
        Context r12 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r5.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
        o.c(r12, "getContext(...)");
        r5.addView((View) ZeusTransformUtils.preCheckCast(new PanelActionButton(r12, null, 0, 6, null), View.class, "com.obric.aiagent.plugin"));
    L25:
        Iterable r13 = (Iterable) ZeusTransformUtils.preCheckCast(r2, Iterable.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r13, Collection.class) == true) goto L28;
    L30:
        Iterator r14 = r13.iterator();
    L32:
        if (r14.hasNext() == false) goto L29;
        if (((com.obric.autoaction.vdplayer.d.a) ZeusTransformUtils.preCheckCast(r14.next(), com.obric.autoaction.vdplayer.d.a.class, "com.obric.aiagent.plugin")).b() == false) goto L32;
        boolean r15 = true;
    L36:
        if (r15 == false) goto L38;
    L40:
        boolean r1 = false;
    L41:
        int r16 = ((Collection) ZeusTransformUtils.preCheckCast(r2, Collection.class, "com.obric.aiagent.plugin")).size();
        int r17 = 0;
    L42:
        if (r17 >= r16) goto L81;
        View r18 = r5.getChildAt(r17);
        if (ZeusTransformUtils.instanceOf(r18, PanelActionButton.class) == false) goto L46;
        PanelActionButton r22 = (PanelActionButton) ZeusTransformUtils.preCheckCast(r18, PanelActionButton.class, "com.obric.aiagent.plugin");
    L47:
        final com.obric.autoaction.vdplayer.d.a r110 = (com.obric.autoaction.vdplayer.d.a) ZeusTransformUtils.preCheckCast(r2.get(r17), com.obric.autoaction.vdplayer.d.a.class, "com.obric.aiagent.plugin");
        if (r22 == null) goto L71;
        if (r110.getType() != com.obric.autoaction.vdplayer.d.b.f25465b) goto L53;
        if (r20 == false) goto L53;
        r22.bind(com.obric.autoaction.vdplayer.d.a.a(r110, com.obric.autoaction.vdplayer.d.b.f25466c, false, false, null, 14, null));
    L54:
        com.obric.autoaction.view.a.a((View) ZeusTransformUtils.preCheckCast(r22, View.class, "com.obric.aiagent.plugin"), 0, new $$Lambda$PanelExpandedComponent$clEQbA2yYV585qkByi1cen35ips(this, r110), 1, null);
        if (r17 != p.b(r2)) goto L57;
        int r111 = 0;
    L58:
        View r23 = (View) ZeusTransformUtils.preCheckCast(r22, View.class, "com.obric.aiagent.plugin");
        ViewGroup.LayoutParams r112 = r23.getLayoutParams();
        Objects.requireNonNull(r112, "null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
        ViewGroup.LayoutParams r113 = (ViewGroup.LayoutParams) ZeusTransformUtils.preCheckCast((LinearLayout.LayoutParams) ZeusTransformUtils.preCheckCast(r112, LinearLayout.LayoutParams.class, "com.obric.aiagent.plugin"), ViewGroup.LayoutParams.class, "com.obric.aiagent.plugin");
        LinearLayout.LayoutParams r114 = (LinearLayout.LayoutParams) ZeusTransformUtils.preCheckCast(r113, LinearLayout.LayoutParams.class, "com.obric.aiagent.plugin");
        if (r110.b() == true) goto L63;
        if (r1 == true) goto L63;
        int r115 = f;
    L64:
        r114.width = r115;
        r114.height = g;
        if (r110.b() == true) goto L69;
        if (r1 == true) goto L69;
        float r116 = 0.0f;
    L70:
        r114.weight = r116;
        r114.rightMargin = r111;
        r23.setLayoutParams(r113);
    L69:
        r116 = 1.0f;
    L63:
        r115 = 0;
        goto L64
    L57:
        r111 = d.i.a.a(TypedValue.applyDimension(1, 4, Resources.getSystem().getDisplayMetrics()));
    L53:
        r22.bind(r110);
    L71:
        r17 = r17 + 1;
        goto L42
    L46:
        r22 = null;
        goto L47
    L81:
        return;
    L38:
        if (a(r21) == false) goto L40;
        r1 = true;
    L29:
        r15 = false;
        goto L36
    L28:
        if (((Collection) ZeusTransformUtils.preCheckCast(r13, Collection.class, "com.obric.aiagent.plugin")).isEmpty() == false) goto L30;
    L80:
        return;
    }

    private static final x a(PanelExpandedComponent r1, com.obric.autoaction.vdplayer.d.a r2, View r3) {
        o.e(r3, "it");
        r1.a(r2.getType());
        return x.f38692a;
    }

    private final void d(g r3) {
        ImageButton r2 = r3.f31615b;
        o.c(r2, "collapseButtonFloating");
        com.obric.autoaction.vdplayer.components.panel.d.a((View) ZeusTransformUtils.preCheckCast(r2, View.class, "com.obric.aiagent.plugin"));
        ImageButton r4 = r3.f31616c;
        o.c(r4, "collapseButtonInline");
        com.obric.autoaction.vdplayer.components.panel.d.a((View) ZeusTransformUtils.preCheckCast(r4, View.class, "com.obric.aiagent.plugin"));
    }

    private final void a(com.obric.autoaction.vdplayer.d.b r6) {
        switch(c.f25435a[r6.ordinal()]) {
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
        r r0 = (r) ZeusTransformUtils.preCheckCast(new r.f(true), r.class, "com.obric.aiagent.plugin");
    L14:
        a(r0);
        if (r6 == com.obric.autoaction.vdplayer.d.b.f) goto L17;
        return;
    L17:
        if (AutoActionConfigs.INSTANCE.getBooleanCfg("vlm.common.enable_operate_panel_stop_to_finish", true) == false) goto L25;
        g r7 = this.f25429b;
        if (r7 == null) goto L26;
        LinearLayout r8 = r7.f;
        if (r8 == null) goto L27;
        r8.postDelayed(new $$Lambda$PanelExpandedComponent$GudKLd_Z4fY3g8loo6Fcs47eU8(this), 500);
        return;
    L27:
        return;
    L26:
        return;
    L25:
        return;
    L7:
        r0 = (r) ZeusTransformUtils.preCheckCast(r.n.f25553a, r.class, "com.obric.aiagent.plugin");
        goto L14
    L8:
        r0 = (r) ZeusTransformUtils.preCheckCast(r.c.f25541a, r.class, "com.obric.aiagent.plugin");
        goto L14
    L9:
        r0 = (r) ZeusTransformUtils.preCheckCast(r.b.f25540a, r.class, "com.obric.aiagent.plugin");
        goto L14
    L10:
        r0 = (r) ZeusTransformUtils.preCheckCast(new r.j("Clarify", d()), r.class, "com.obric.aiagent.plugin");
        goto L14
    L11:
        r0 = (r) ZeusTransformUtils.preCheckCast(new r.j("Supplement", d()), r.class, "com.obric.aiagent.plugin");
        goto L14
    L12:
        r0 = (r) ZeusTransformUtils.preCheckCast(r.e.f25543a, r.class, "com.obric.aiagent.plugin");
        goto L14
    L13:
        r0 = (r) ZeusTransformUtils.preCheckCast(r.p.f25555a, r.class, "com.obric.aiagent.plugin");
        goto L14
    L5:
        throw new d.k();
    }

    private static final void a(PanelExpandedComponent r3) {
        r3.a((r) ZeusTransformUtils.preCheckCast(new r.f(true), r.class, "com.obric.aiagent.plugin"));
    }

    private final String d() {
        com.obric.autoaction.a.c r3 = this.f25430c;
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
        this.f25429b = null;
        this.f25430c = null;
    }

    private final void d(String r6) {
        if (d.o.o.b(r6, "http://", false, 2, null) == false) goto L5;
    L8:
        Intent r1 = new Intent("android.intent.action.VIEW", Uri.parse(r6));
        r1.addCategory("android.intent.category.BROWSABLE");
        com.obric.autoaction.a.c r5 = this.f25430c;     // Catch: Exception -> L15
        if (r5 == null) goto L18;
        Context r7 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r5.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");     // Catch: Exception -> L15
        if (r7 == null) goto L19;
        ZeusTransformUtils.startActivity(r7, r1, "com.obric.aiagent.plugin");     // Catch: Exception -> L15
        return;
    L19:
        return;
    L18:
        return;
    L20:
        return;
    L5:
        if (d.o.o.b(r6, "https://", false, 2, null) == true) goto L8;
        r6 = "https://" + r6;
        goto L8
    }

    private final boolean a(l r1) {
        if (r1 != l.f25508b) goto L5;
    L10:
        return true;
    L5:
        if (r1 == l.f25509c) goto L10;
        if (r1 == l.f25510d) goto L10;
        return false;
    }

    private final boolean b(l r1) {
        if (r1 != l.f25511e) goto L5;
    L8:
        return true;
    L5:
        if (r1 == l.f) goto L8;
        return false;
    }

    static {
        f25427a = new a(null);
        f25428e = d.i.a.a(TypedValue.applyDimension(1, 388, Resources.getSystem().getDisplayMetrics()));
        f = d.i.a.a(TypedValue.applyDimension(1, 56, Resources.getSystem().getDisplayMetrics()));
        g = d.i.a.a(TypedValue.applyDimension(1, 48, Resources.getSystem().getDisplayMetrics()));
        h = d.i.a.a(TypedValue.applyDimension(1, 40, Resources.getSystem().getDisplayMetrics()));
        i = d.i.a.a(TypedValue.applyDimension(1, 16, Resources.getSystem().getDisplayMetrics()));
        j = d.i.a.a(TypedValue.applyDimension(1, 64, Resources.getSystem().getDisplayMetrics()));
        k = d.i.a.a(TypedValue.applyDimension(1, 12, Resources.getSystem().getDisplayMetrics()));
        l = p.b(new k[]{new k("^\\s{0,3}#{1,6}\\s+"), new k("^\\s*([-*+]|\\d+\\.)\\s+"), new k("^\\s{0,3}>\\s+"), new k("`[^`]+`"), new k("\\*\\*[^*]+\\*\\*|__[^_]+__|\\*[^*]+\\*|_[^_]+_"), new k("!?\\[[^\\]]+]\\([^)]+\\)"), new k("^\\s*\\|.+\\|\\s*$")});
    }
}
