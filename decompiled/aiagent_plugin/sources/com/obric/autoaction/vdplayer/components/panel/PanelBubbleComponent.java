package com.obric.autoaction.vdplayer.components.panel;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.LayerDrawable;
import android.os.Build;
import android.text.SpannableStringBuilder;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.lifecycle.p;
import com.bytedance.common.wschannel.WsChannelMultiProcessSharedProvider;
import com.obric.aiagent.plugin.R;
import com.obric.autoaction.vdplayer.components.BaseVDPlayerSlotComponent;
import com.obric.autoaction.vdplayer.d.l;
import com.obric.autoaction.vdplayer.d.r;
import com.obric.autoaction.vdplayer.d.s;
import com.obric.oui.common.util.k;
import com.obric.oui.text.OTextView;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.h;
import d.h.b.o;
import d.l.n;
import d.x;
import java.util.Collection;
import java.util.Iterator;
import java.util.Objects;

/* JADX INFO: compiled from: PanelBubbleComponent.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class PanelBubbleComponent extends BaseVDPlayerSlotComponent<com.obric.autoaction.vdplayer.components.panel.b> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final a f25398a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private com.obric.autogui.vdplayer.a.d f25399b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private com.obric.autoaction.a.c f25400c;

    /* JADX INFO: compiled from: PanelBubbleComponent.kt */
    private static final class a {
        public /* synthetic */ a(h r1) {
            this();
        }

        private a() {
        }
    }

    /* JADX INFO: compiled from: PanelBubbleComponent.kt */
    private static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final int f25401a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final CharSequence f25402b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final Integer f25403c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final int f25404d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private final int f25405e;
        private final int f;
        private final int g;
        private final int h;
        private final int i;
        private final int j;
        private final boolean k;

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, b.class) == true) goto L8;
            return false;
        L8:
            b r6 = (b) ZeusTransformUtils.preCheckCast(r5, b.class, "com.obric.aiagent.plugin");
            if (this.f25401a == r6.f25401a) goto L12;
            return false;
        L12:
            if (o.a(this.f25402b, r6.f25402b) == true) goto L15;
            return false;
        L15:
            if (o.a(this.f25403c, r6.f25403c) == true) goto L18;
            return false;
        L18:
            if (this.f25404d == r6.f25404d) goto L21;
            return false;
        L21:
            if (this.f25405e == r6.f25405e) goto L24;
            return false;
        L24:
            if (this.f == r6.f) goto L27;
            return false;
        L27:
            if (this.g == r6.g) goto L30;
            return false;
        L30:
            if (this.h == r6.h) goto L33;
            return false;
        L33:
            if (this.i == r6.i) goto L36;
            return false;
        L36:
            if (this.j == r6.j) goto L39;
            return false;
        L39:
            if (this.k == r6.k) goto L41;
            return false;
        L41:
            return true;
        }

        public int hashCode() {
            int r0 = ((Integer.hashCode(this.f25401a) * 31) + this.f25402b.hashCode()) * 31;
            Integer r1 = this.f25403c;
            if (r1 != null) goto L5;
            int r2 = 0;
        L7:
            return ((((((((((((((((r0 + r2) * 31) + Integer.hashCode(this.f25404d)) * 31) + Integer.hashCode(this.f25405e)) * 31) + Integer.hashCode(this.f)) * 31) + Integer.hashCode(this.g)) * 31) + Integer.hashCode(this.h)) * 31) + Integer.hashCode(this.i)) * 31) + Integer.hashCode(this.j)) * 31) + Boolean.hashCode(this.k);
        L5:
            r2 = r1.hashCode();
            goto L7
        }

        public String toString() {
            StringBuilder r0 = new StringBuilder();
            r0.append("RenderState(iconRes=").append(this.f25401a).append(", text=").append(this.f25402b).append(", trailingIconRes=").append(this.f25403c).append(", textColorRes=").append(this.f25404d).append(", iconSizeDp=").append(this.f25405e).append(", paddingStartDp=").append(this.f).append(", paddingEndDp=").append(this.g).append(", iconTextGapDp=").append(this.h).append(", trailingStartGapDp=").append(this.i).append(", trailingButtonSizeDp=").append(this.j).append(", useFluidGradient=").append(this.k).append(')');
            return r0.toString();
        }

        public b(int r3, CharSequence r4, Integer r5, int r6, int r7, int r8, int r9, int r10, int r11, int r12, boolean r13) {
            CharSequence r14 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r4, CharSequence.class, "com.obric.aiagent.plugin");
            o.e(r14, "text");
            this.f25401a = r3;
            this.f25402b = r14;
            this.f25403c = r5;
            this.f25404d = r6;
            this.f25405e = r7;
            this.f = r8;
            this.g = r9;
            this.h = r10;
            this.i = r11;
            this.j = r12;
            this.k = r13;
        }

        public /* synthetic */ b(int r15, CharSequence r16, Integer r17, int r18, int r19, int r20, int r21, int r22, int r23, int r24, boolean r25, int r26, h r27) {
            CharSequence r4 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r16, CharSequence.class, "com.obric.aiagent.plugin");
            if ((r26 & 16) == 0) goto L5;
            int r7 = 28;
        L7:
            if ((r26 & 32) == 0) goto L9;
            int r8 = 10;
        L11:
            if ((r26 & 64) == 0) goto L13;
            int r9 = 16;
        L15:
            if ((r26 & 128) == 0) goto L17;
            int r10 = 6;
        L19:
            if ((r26 & 256) == 0) goto L21;
            int r11 = 6;
        L23:
            if ((r26 & 512) == 0) goto L25;
            int r12 = 16;
        L27:
            if ((r26 & 1024) == 0) goto L29;
            boolean r13 = false;
        L30:
            this(r15, r4, r17, r18, r7, r8, r9, r10, r11, r12, r13);
            return;
        L29:
            r13 = r25;
            goto L30
        L25:
            r12 = r24;
            goto L27
        L21:
            r11 = r23;
            goto L23
        L17:
            r10 = r22;
            goto L19
        L13:
            r9 = r21;
            goto L15
        L9:
            r8 = r20;
            goto L11
        L5:
            r7 = r19;
            goto L7
        }

        public final int a() {
            return this.f25401a;
        }

        public final CharSequence b() {
            return this.f25402b;
        }

        public final Integer c() {
            return this.f25403c;
        }

        public final int d() {
            return this.f25404d;
        }

        public final int e() {
            return this.f25405e;
        }

        public final int f() {
            return this.f;
        }

        public final int g() {
            return this.g;
        }

        public final int h() {
            return this.h;
        }

        public final int i() {
            return this.i;
        }

        public final int j() {
            return this.j;
        }

        public final boolean k() {
            return this.k;
        }
    }

    /* JADX INFO: compiled from: PanelBubbleComponent.kt */
    public /* synthetic */ class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f25406a = null;

        static {
            int[] r0 = new int[l.values().length];
            r0[l.f25511e.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L9:
            r0[l.f.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L5:
            f25406a = r0;
        }
    }

    static {
        f25398a = new a(null);
    }

    public static /* synthetic */ x lambda$E9tjIp8uy2ckjnYkDLUtT9AN4nU(PanelBubbleComponent r0, View r1) {
        return a(r0, r1);
    }

    /* JADX INFO: renamed from: lambda$dNgs7ZXI8w7-12TQGC35GVovI-o, reason: not valid java name */
    public static /* synthetic */ x m668lambda$dNgs7ZXI8w712TQGC35GVovIo(PanelBubbleComponent r0, View r1) {
        return b(r0, r1);
    }

    public static /* synthetic */ com.obric.autoaction.vdplayer.components.panel.b lambda$hJ7RYVIzPuC2Ru1OsJsopqSZ5DE(s r0) {
        return a(r0);
    }

    public PanelBubbleComponent() {
        super($$Lambda$PanelBubbleComponent$hJ7RYVIzPuC2Ru1OsJsopqSZ5DE.INSTANCE);
    }

    @Override // com.obric.autoaction.vdplayer.components.BaseVDPlayerComponent
    public /* synthetic */ void a(Object r3) {
        a((com.obric.autoaction.vdplayer.components.panel.b) ZeusTransformUtils.preCheckCast(r3, com.obric.autoaction.vdplayer.components.panel.b.class, "com.obric.aiagent.plugin"));
    }

    private static final com.obric.autoaction.vdplayer.components.panel.b a(s r2) {
        o.e(r2, "it");
        return new com.obric.autoaction.vdplayer.components.panel.b(r2.b(), r2.e());
    }

    @Override // com.obric.autoaction.vdplayer.components.BaseVDPlayerComponent, com.obric.autoaction.a.f
    public void a(com.obric.autoaction.a.c r2) {
        o.e(r2, "componentHost");
        super.a(r2);
        this.f25400c = r2;
    }

    @Override // com.obric.autoaction.a.g
    public View a(ViewGroup r3, com.obric.autoaction.a.c r4) {
        o.e(r3, "container");
        o.e(r4, "componentHost");
        com.obric.autogui.vdplayer.a.d r5 = com.obric.autogui.vdplayer.a.d.a(LayoutInflater.from((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r3.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")), r3, false);
        o.c(r5, "inflate(...)");
        this.f25399b = r5;
        FrameLayout r2 = r5.b();
        o.c(r2, "getRoot(...)");
        return (View) ZeusTransformUtils.preCheckCast(r2, View.class, "com.obric.aiagent.plugin");
    }

    @Override // com.obric.autoaction.vdplayer.components.BaseVDPlayerComponent, com.obric.autoaction.a.h
    public void a(View r2, com.obric.autoaction.a.c r3) {
        o.e(r2, "boundView");
        o.e(r3, "componentHost");
        super.a(r2, r3);
        d();
    }

    private final void d() {
        com.obric.autogui.vdplayer.a.d r0 = this.f25399b;
        if (r0 == null) goto L7;
        FrameLayout r1 = r0.b();
        if (r1 == null) goto L7;
        com.obric.autoaction.view.a.a((View) ZeusTransformUtils.preCheckCast(r1, View.class, "com.obric.aiagent.plugin"), 0, new $$Lambda$PanelBubbleComponent$E9tjIp8uy2ckjnYkDLUtT9AN4nU(this), 1, null);
    L7:
        com.obric.autogui.vdplayer.a.d r2 = this.f25399b;
        if (r2 == null) goto L13;
        ImageButton r3 = r2.h;
        if (r3 == null) goto L14;
        com.obric.autoaction.view.a.a((View) ZeusTransformUtils.preCheckCast(r3, View.class, "com.obric.aiagent.plugin"), 0, new $$Lambda$PanelBubbleComponent$dNgs7ZXI8w712TQGC35GVovIo(this), 1, null);
        return;
    L14:
        return;
    }

    private static final x a(PanelBubbleComponent r4, View r5) {
        o.e(r5, "it");
        com.obric.autoaction.a.c r6 = r4.f25400c;
        boolean r0 = true;
        if (r6 == null) goto L9;
        com.obric.autoaction.vdplayer.components.a.a r7 = (com.obric.autoaction.vdplayer.components.a.a) ZeusTransformUtils.preCheckCast(r6.a(com.obric.autoaction.vdplayer.components.a.a.class), com.obric.autoaction.vdplayer.components.a.a.class, "com.obric.aiagent.plugin");
        if (r7 == null) goto L9;
        if (r7.h_() != true) goto L9;
    L10:
        if (r0 == true) goto L12;
        r4.a((r) ZeusTransformUtils.preCheckCast(r.a.f25539a, r.class, "com.obric.aiagent.plugin"));
        return x.f38692a;
    L12:
        return x.f38692a;
    L9:
        r0 = false;
        goto L10
    }

    private static final x b(PanelBubbleComponent r4, View r5) {
        o.e(r5, "it");
        com.obric.autoaction.a.c r6 = r4.f25400c;
        boolean r0 = true;
        if (r6 == null) goto L9;
        com.obric.autoaction.vdplayer.components.a.a r7 = (com.obric.autoaction.vdplayer.components.a.a) ZeusTransformUtils.preCheckCast(r6.a(com.obric.autoaction.vdplayer.components.a.a.class), com.obric.autoaction.vdplayer.components.a.a.class, "com.obric.aiagent.plugin");
        if (r7 == null) goto L9;
        if (r7.i_() != true) goto L9;
    L10:
        if (r0 == true) goto L13;
        r4.a((r) ZeusTransformUtils.preCheckCast(r.C0625r.f25557a, r.class, "com.obric.aiagent.plugin"));
    L13:
        return x.f38692a;
    L9:
        r0 = false;
        goto L10
    }

    public void a(com.obric.autoaction.vdplayer.components.panel.b r6) {
        o.e(r6, "state");
        com.obric.autogui.vdplayer.a.d r0 = this.f25399b;
        if (r0 != null) goto L5;
        return;
    L5:
        b r7 = b(r6);
        r0.f31600b.setImageResource(r7.a());
        r0.f31602d.setText(r7.b());
        r0.f31602d.setTextColor(androidx.core.content.a.c((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r0.b().getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), r7.d()));
        a(r0, r7);
        Integer r1 = r7.c();
        if (r1 != null) goto L8;
        ImageButton r2 = r0.h;
        o.c(r2, "bubbleTrailingButton");
        k.b((View) ZeusTransformUtils.preCheckCast(r2, View.class, "com.obric.aiagent.plugin"));
    L9:
        ImageButton r3 = r0.h;
        o.c(r3, "bubbleTrailingButton");
        d.a((View) ZeusTransformUtils.preCheckCast(r3, View.class, "com.obric.aiagent.plugin"));
        if (r7.k() == false) goto L12;
        FrameLayout r8 = r0.b();
        Context r4 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r0.b().getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
        o.c(r4, "getContext(...)");
        r8.setBackground((Drawable) ZeusTransformUtils.preCheckCast(a(r4), Drawable.class, "com.obric.aiagent.plugin"));
        return;
    L12:
        r0.b().setBackgroundResource(ZeusTransformUtils.mapRes(R.drawable.vd_bubble_stroke, "drawable", "vd_bubble_stroke"));
        return;
    L8:
        r0.h.setImageResource(r1.intValue());
        ImageButton r5 = r0.h;
        o.c(r5, "bubbleTrailingButton");
        k.a((View) ZeusTransformUtils.preCheckCast(r5, View.class, "com.obric.aiagent.plugin"));
        goto L9
    }

    private final b b(com.obric.autoaction.vdplayer.components.panel.b r42) {
        com.obric.autoaction.vdplayer.d.k r1 = r42.a();
        Long r2 = r1.d();
        String r4 = null;
        if (r2 != null) goto L5;
    L10:
        r2 = null;
    L12:
        if (r2 != null) goto L14;
        String r12 = "";
        if (r42.b() == com.obric.autoaction.vdplayer.d.o.f25519a) goto L29;
        int r14 = ZeusTransformUtils.mapRes(R.drawable.oic_player_triangle_right_fill_blue, "drawable", "oic_player_triangle_right_fill_blue");
        com.obric.autogui.vdplayer.a.d r0 = this.f25399b;
        if (r0 == null) goto L24;
        FrameLayout r3 = r0.b();
        if (r3 == null) goto L24;
        Context r5 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r3.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
        if (r5 == null) goto L24;
        r4 = r5.getString(ZeusTransformUtils.mapRes(R.string.vd_bubble_resume_doubao, WsChannelMultiProcessSharedProvider.STRING_TYPE, "vd_bubble_resume_doubao"));
    L24:
        if (r4 == null) goto L28;
        r12 = r4;
    L28:
        return new b(r14, (CharSequence) ZeusTransformUtils.preCheckCast(r12, CharSequence.class, "com.obric.aiagent.plugin"), null, ZeusTransformUtils.mapRes(R.color.oui_blue_6, "color", "oui_blue_6"), 22, 13, 0, 0, 0, 0, false, 1984, null);
    L29:
        int r6 = c.f25406a[r1.a().a().ordinal()];
        if (r6 != 1) goto L32;
        b r7 = new b(ZeusTransformUtils.mapRes(R.drawable.oic_right_hand_point_up_fill, "drawable", "oic_right_hand_point_up_fill"), a(r1), Integer.valueOf(ZeusTransformUtils.mapRes(R.drawable.oic_arrow_opposite_45, "drawable", "oic_arrow_opposite_45")), ZeusTransformUtils.mapRes(R.color.oui_blue_6, "color", "oui_blue_6"), 22, 13, 0, 0, 8, 0, false, 1728, null);
    L47:
        return r7;
    L32:
        if (r6 == 2) goto L44;
        int r15 = ZeusTransformUtils.mapRes(R.drawable.ic_vd_hand_right_gradient, "drawable", "ic_vd_hand_right_gradient");
        com.obric.autogui.vdplayer.a.d r8 = this.f25399b;
        if (r8 == null) goto L40;
        FrameLayout r9 = r8.b();
        if (r9 == null) goto L40;
        Context r10 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r9.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
        if (r10 == null) goto L40;
        r4 = r10.getString(ZeusTransformUtils.mapRes(R.string.vd_bubble_operating, WsChannelMultiProcessSharedProvider.STRING_TYPE, "vd_bubble_operating"));
    L40:
        if (r4 == null) goto L48;
        r12 = r4;
    L48:
        return new b(r15, (CharSequence) ZeusTransformUtils.preCheckCast(r12, CharSequence.class, "com.obric.aiagent.plugin"), Integer.valueOf(ZeusTransformUtils.mapRes(R.drawable.oic_arrow_opposite_45, "drawable", "oic_arrow_opposite_45")), ZeusTransformUtils.mapRes(R.color.oui_basic_text_1, "color", "oui_basic_text_1"), 22, 13, 14, 0, 8, 0, true, 640, null);
    L44:
        r7 = new b(ZeusTransformUtils.mapRes(R.drawable.oic_ellipsis_3_message_bubble_fill, "drawable", "oic_ellipsis_3_message_bubble_fill"), a(r1), Integer.valueOf(ZeusTransformUtils.mapRes(R.drawable.oic_arrow_opposite_45, "drawable", "oic_arrow_opposite_45")), ZeusTransformUtils.mapRes(R.color.oui_blue_6, "color", "oui_blue_6"), 22, 13, 0, 0, 8, 0, false, 1728, null);
        goto L47
    L14:
        return new b(ZeusTransformUtils.mapRes(R.drawable.oic_player_triangle_right_fill_blue, "drawable", "oic_player_triangle_right_fill_blue"), a(r2.longValue()), null, ZeusTransformUtils.mapRes(R.color.oui_blue_6, "color", "oui_blue_6"), 22, 13, 0, 0, 0, 0, false, 1984, null);
    L5:
        if (((Number) ZeusTransformUtils.preCheckCast(r2, Number.class, "com.obric.aiagent.plugin")).longValue() > 5000) goto L7;
        boolean r11 = true;
    L8:
        if (r11 == false) goto L10;
    L7:
        r11 = false;
        goto L8
    }

    private final void a(com.obric.autogui.vdplayer.a.d r8, b r9) {
        r8.f31599a.setPadding(d.i.a.a(TypedValue.applyDimension(1, r9.f(), Resources.getSystem().getDisplayMetrics())), 0, d.i.a.a(TypedValue.applyDimension(1, r9.g(), Resources.getSystem().getDisplayMetrics())), 0);
        ImageView r7 = r8.f31600b;
        o.c(r7, "bubbleIcon");
        View r10 = (View) ZeusTransformUtils.preCheckCast(r7, View.class, "com.obric.aiagent.plugin");
        ViewGroup.LayoutParams r0 = r10.getLayoutParams();
        Objects.requireNonNull(r0, "null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
        ViewGroup.LayoutParams r1 = (ViewGroup.LayoutParams) ZeusTransformUtils.preCheckCast((LinearLayout.LayoutParams) ZeusTransformUtils.preCheckCast(r0, LinearLayout.LayoutParams.class, "com.obric.aiagent.plugin"), ViewGroup.LayoutParams.class, "com.obric.aiagent.plugin");
        LinearLayout.LayoutParams r4 = (LinearLayout.LayoutParams) ZeusTransformUtils.preCheckCast(r1, LinearLayout.LayoutParams.class, "com.obric.aiagent.plugin");
        r4.width = d.i.a.a(TypedValue.applyDimension(1, r9.e(), Resources.getSystem().getDisplayMetrics()));
        r4.height = d.i.a.a(TypedValue.applyDimension(1, r9.e(), Resources.getSystem().getDisplayMetrics()));
        r10.setLayoutParams(r1);
        OTextView r11 = r8.f31602d;
        o.c(r11, "bubbleText");
        View r12 = (View) ZeusTransformUtils.preCheckCast(r11, View.class, "com.obric.aiagent.plugin");
        ViewGroup.LayoutParams r2 = r12.getLayoutParams();
        Objects.requireNonNull(r2, "null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
        ViewGroup.LayoutParams r3 = (ViewGroup.LayoutParams) ZeusTransformUtils.preCheckCast((LinearLayout.LayoutParams) ZeusTransformUtils.preCheckCast(r2, LinearLayout.LayoutParams.class, "com.obric.aiagent.plugin"), ViewGroup.LayoutParams.class, "com.obric.aiagent.plugin");
        ((LinearLayout.LayoutParams) ZeusTransformUtils.preCheckCast(r3, LinearLayout.LayoutParams.class, "com.obric.aiagent.plugin")).setMarginStart(d.i.a.a(TypedValue.applyDimension(1, r9.h(), Resources.getSystem().getDisplayMetrics())));
        r12.setLayoutParams(r3);
        ImageButton r13 = r8.h;
        o.c(r13, "bubbleTrailingButton");
        View r14 = (View) ZeusTransformUtils.preCheckCast(r13, View.class, "com.obric.aiagent.plugin");
        ViewGroup.LayoutParams r15 = r14.getLayoutParams();
        Objects.requireNonNull(r15, "null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
        ViewGroup.LayoutParams r16 = (ViewGroup.LayoutParams) ZeusTransformUtils.preCheckCast((LinearLayout.LayoutParams) ZeusTransformUtils.preCheckCast(r15, LinearLayout.LayoutParams.class, "com.obric.aiagent.plugin"), ViewGroup.LayoutParams.class, "com.obric.aiagent.plugin");
        LinearLayout.LayoutParams r5 = (LinearLayout.LayoutParams) ZeusTransformUtils.preCheckCast(r16, LinearLayout.LayoutParams.class, "com.obric.aiagent.plugin");
        r5.width = d.i.a.a(TypedValue.applyDimension(1, r9.j(), Resources.getSystem().getDisplayMetrics()));
        r5.height = d.i.a.a(TypedValue.applyDimension(1, r9.j(), Resources.getSystem().getDisplayMetrics()));
        r5.setMarginStart(d.i.a.a(TypedValue.applyDimension(1, r9.i(), Resources.getSystem().getDisplayMetrics())));
        r14.setLayoutParams(r16);
    }

    private final CharSequence a(com.obric.autoaction.vdplayer.d.k r9) {
        Iterator r0 = ((Iterable) ZeusTransformUtils.preCheckCast(r9.b(), Iterable.class, "com.obric.aiagent.plugin")).iterator();
    L3:
        boolean r3 = true;
        String r5 = null;
        if (r0.hasNext() == false) goto L11;
        Object r1 = r0.next();
        if (((com.obric.autoaction.vdplayer.d.a) ZeusTransformUtils.preCheckCast(r1, com.obric.autoaction.vdplayer.d.a.class, "com.obric.aiagent.plugin")).getType() != com.obric.autoaction.vdplayer.d.b.f25467d) goto L8;
        boolean r6 = true;
    L9:
        if (r6 == false) goto L3;
    L12:
        com.obric.autoaction.vdplayer.d.a r2 = (com.obric.autoaction.vdplayer.d.a) ZeusTransformUtils.preCheckCast(r1, com.obric.autoaction.vdplayer.d.a.class, "com.obric.aiagent.plugin");
        if (r2 == null) goto L19;
        String r4 = r2.c();
        if (r4 == null) goto L19;
        if ((!d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast(r4, CharSequence.class, "com.obric.aiagent.plugin"))) == false) goto L19;
    L20:
        if (r4 != null) goto L22;
        Iterable r10 = (Iterable) ZeusTransformUtils.preCheckCast(r9.b(), Iterable.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r10, Collection.class) == true) goto L26;
    L28:
        Iterator r11 = r10.iterator();
    L30:
        if (r11.hasNext() == false) goto L27;
        if (((com.obric.autoaction.vdplayer.d.a) ZeusTransformUtils.preCheckCast(r11.next(), com.obric.autoaction.vdplayer.d.a.class, "com.obric.aiagent.plugin")).getType() != com.obric.autoaction.vdplayer.d.b.f25464a) goto L34;
        boolean r7 = true;
    L35:
        if (r7 == false) goto L30;
    L37:
        if (r3 == false) goto L39;
        int r12 = ZeusTransformUtils.mapRes(R.string.vd_bubble_reply, WsChannelMultiProcessSharedProvider.STRING_TYPE, "vd_bubble_reply");
    L40:
        com.obric.autogui.vdplayer.a.d r8 = this.f25399b;
        if (r8 == null) goto L47;
        FrameLayout r13 = r8.b();
        if (r13 == null) goto L47;
        Context r14 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r13.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
        if (r14 == null) goto L47;
        r5 = r14.getString(r12);
    L47:
        if (r5 != null) goto L50;
        r5 = "";
    L50:
        return (CharSequence) ZeusTransformUtils.preCheckCast(r5, CharSequence.class, "com.obric.aiagent.plugin");
    L39:
        r12 = ZeusTransformUtils.mapRes(R.string.obric_vd_action_takeover, WsChannelMultiProcessSharedProvider.STRING_TYPE, "obric_vd_action_takeover");
        goto L40
    L34:
        r7 = false;
    L27:
        r3 = false;
        goto L37
    L26:
        if (((Collection) ZeusTransformUtils.preCheckCast(r10, Collection.class, "com.obric.aiagent.plugin")).isEmpty() == false) goto L28;
    L22:
        return (CharSequence) ZeusTransformUtils.preCheckCast(r4, CharSequence.class, "com.obric.aiagent.plugin");
    L19:
        r4 = null;
        goto L20
    L8:
        r6 = false;
        goto L9
    L11:
        r1 = null;
        goto L12
    }

    private final CharSequence a(long r5) {
        com.obric.autogui.vdplayer.a.d r4 = this.f25399b;
        if (r4 == null) goto L12;
        FrameLayout r6 = r4.b();
        if (r6 == null) goto L12;
        Context r7 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r6.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
        if (r7 == null) goto L12;
        long r8 = n.a((r5 + 999) / 1000, 1);
        String r9 = new StringBuilder().append('(').append(r8).append(')').toString();
        SpannableStringBuilder r10 = new SpannableStringBuilder((CharSequence) ZeusTransformUtils.preCheckCast(r7.getString(ZeusTransformUtils.mapRes(R.string.obric_vd_manualop_resume_countdown, WsChannelMultiProcessSharedProvider.STRING_TYPE, "obric_vd_manualop_resume_countdown")), CharSequence.class, "com.obric.aiagent.plugin")).append(' ').append((CharSequence) ZeusTransformUtils.preCheckCast(r9, CharSequence.class, "com.obric.aiagent.plugin"));
        o.c(r10, "append(...)");
        return (CharSequence) ZeusTransformUtils.preCheckCast(r10, CharSequence.class, "com.obric.aiagent.plugin");
    L12:
        return (CharSequence) ZeusTransformUtils.preCheckCast("", CharSequence.class, "com.obric.aiagent.plugin");
    }

    @Override // androidx.lifecycle.d
    public void e(p r3) {
        p r4 = (p) ZeusTransformUtils.wrapperContextForParams(r3, p.class, "com.obric.aiagent.plugin");
        o.e(r4, "owner");
        super.e(r4);
        this.f25399b = null;
        this.f25400c = null;
    }

    private final LayerDrawable a(Context r14) {
        Context r13 = (Context) ZeusTransformUtils.wrapperContextForParams(r14, Context.class, "com.obric.aiagent.plugin");
        float r15 = TypedValue.applyDimension(1, 24, Resources.getSystem().getDisplayMetrics());
        GradientDrawable r1 = new GradientDrawable();
        r1.setShape(0);
        r1.setCornerRadius(r15);
        r1.setColor(514352895);
        GradientDrawable r4 = new GradientDrawable();
        r4.setShape(0);
        r4.setCornerRadius(r15);
        r4.setColor(r13.getColor(ZeusTransformUtils.mapRes(R.color.oui_bg_base_3_high_elevation, "color", "oui_bg_base_3_high_elevation")));
        int[] r5 = {523724543, 531130111, 536834933, 536851045};
        float[] r16 = {0.3f, 0.45f, 0.65f, 0.85f};
        GradientDrawable r6 = new GradientDrawable(GradientDrawable.Orientation.BL_TR, r5);
        r6.setCornerRadius(r15);
        r6.setGradientType(0);
        if (Build.VERSION.SDK_INT < 29) goto L5;
        r6.setColors(r5, r16);
    L5:
        int r17 = d.i.a.a(TypedValue.applyDimension(1, 1, Resources.getSystem().getDisplayMetrics()));
        LayerDrawable r18 = new LayerDrawable((Drawable[]) ZeusTransformUtils.preCheckCast(new GradientDrawable[]{r1, r4, r6}, Drawable[].class, "com.obric.aiagent.plugin"));
        r18.setLayerInset(1, r17, r17, r17, r17);
        r18.setLayerInset(2, r17, r17, r17, r17);
        return r18;
    }
}
