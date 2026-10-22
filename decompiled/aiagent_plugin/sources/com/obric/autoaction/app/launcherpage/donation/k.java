package com.obric.autoaction.app.launcherpage.donation;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.Glide;
import com.bytedance.common.wschannel.WsChannelMultiProcessSharedProvider;
import com.google.android.material.imageview.ShapeableImageView;
import com.obric.aiagent.plugin.R;
import com.obric.autoaction.app.launcherpage.a.av;
import com.obric.autoaction.app.launcherpage.utils.p;
import com.obric.autogui.common.api.AOPackagesTools;
import com.obric.autogui.common.api.platform.screen.capture.OScreenEvent;
import com.obric.oui.button.OIconButton;
import com.obric.oui.layout.OUILinearLayout;
import com.obric.oui.sectiontitlebar.OSectionTitleBar;
import com.obric.oui.text.OTextView;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.ad;
import d.h.b.o;
import d.x;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: compiled from: RecordDataAdapter.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class k extends RecyclerView.a<a> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final boolean f23769a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final List<com.obric.autoaction.app.launcherpage.donation.model.c> f23770b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final d.h.a.a<x> f23771c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final List<com.obric.autoaction.app.launcherpage.donation.model.c> f23772d;

    /* JADX INFO: compiled from: RecordDataAdapter.kt */
    public final class a extends RecyclerView.u {
        final /* synthetic */ k r;
        private final av s;

        public static /* synthetic */ void lambda$3rX4uAtLxgSKpAwm1tj95KMPzCs(a r0, k r1, int r2, View r3) {
            b(r0, r1, r2, r3);
        }

        /* JADX INFO: renamed from: lambda$CZO1isKz98C-XQDQMPOO6XdCfg4, reason: not valid java name */
        public static /* synthetic */ x m507lambda$CZO1isKz98CXQDQMPOO6XdCfg4(com.obric.autoaction.app.launcherpage.donation.model.c r0, a r1, int r2, View r3, String r4) {
            return a(r0, r1, r2, r3, r4);
        }

        public static /* synthetic */ void lambda$Lf121jofEcTBI4licgFZaWALQjA(Context r0, com.obric.autoaction.app.launcherpage.donation.model.c r1, a r2, int r3, View r4) {
            a(r0, r1, r2, r3, r4);
        }

        public static /* synthetic */ void lambda$hcPetmGGr0WAjqI4HBzUmcS9cqE(OTextView r0) {
            a(r0);
        }

        public static /* synthetic */ x lambda$jOK8OZnSQ32Y11b9xyz8Bfjhyyc(View r0) {
            return a(r0);
        }

        /* JADX INFO: renamed from: lambda$nyr730rG8qLk-RHXjpV0Cx970lY, reason: not valid java name */
        public static /* synthetic */ void m508lambda$nyr730rG8qLkRHXjpV0Cx970lY(a r0, k r1, int r2, View r3) {
            a(r0, r1, r2, r3);
        }

        /* JADX INFO: renamed from: lambda$rXdzXMeLBOrRkJsLA-dFybZADRA, reason: not valid java name */
        public static /* synthetic */ x m509lambda$rXdzXMeLBOrRkJsLAdFybZADRA(k r0, int r1, a r2) {
            return a(r0, r1, r2);
        }

        public a(k r2, View r3) {
            o.e(r3, "itemView");
            this.r = r2;
            super(r3);
            av r4 = av.a(r3);
            o.c(r4, "bind(...)");
            this.s = r4;
        }

        public final void a(final com.obric.autoaction.app.launcherpage.donation.model.c r13, final int r14) {
            o.e(r13, "operation");
            final Context r0 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(this.f2390a.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
            int r4 = 8;
            if (r14 != 0) goto L5;
            this.s.g.setVisibility(0);
            OSectionTitleBar r6 = this.s.g;
            int r7 = ZeusTransformUtils.mapRes(R.color.oui_basic_text_3, "color", "oui_basic_text_3");
            o.a(r0);
            r6.setTitleTextColor(p.b(r7, r0, null, 2, null));
            this.s.g.setTitleTextSize(12.0f);
        L6:
            ShapeableImageView r8 = this.s.f22788e;
            final k r9 = this.r;
            r8.setImageBitmap(r13.b());
            String r10 = r13.c();
            boolean r11 = true;
            if (r10 != null) goto L9;
        L17:
            r8.setOnClickListener(new $$Lambda$k$a$nyr730rG8qLkRHXjpV0Cx970lY(this, r9, r14));
            CharSequence r12 = (CharSequence) ZeusTransformUtils.preCheckCast(r13.c(), CharSequence.class, "com.obric.aiagent.plugin");
            if (r12 != null) goto L20;
        L23:
            boolean r15 = true;
        L24:
            if (r15 == true) goto L26;
        L29:
            boolean r16 = true;
        L30:
            if (r16 == false) goto L32;
            int r17 = 0;
        L33:
            r8.setVisibility(r17);
            if (r16 == false) goto L36;
            this.s.f.setBackground(null);
        L36:
            ImageView r3 = this.s.f22784a;
            if (ZeusTransformUtils.instanceOf(r13.a(), OScreenEvent.OAppStateEvent.class) == false) goto L39;
            AOPackagesTools r18 = AOPackagesTools.INSTANCE;
            Context r19 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(this.f2390a.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
            o.c(r19, "getContext(...)");
            r3.setImageDrawable(r18.getAppIconDrawable(r19, ((OScreenEvent.OAppStateEvent) ZeusTransformUtils.preCheckCast(r13.a(), OScreenEvent.OAppStateEvent.class, "com.obric.aiagent.plugin")).getPackageName()));
            this.s.f.setBackgroundResource(ZeusTransformUtils.mapRes(R.drawable.surfaceview_bg, "drawable", "surfaceview_bg"));
            r3.setVisibility(0);
        L40:
            OTextView r5 = this.s.h;
            ad r20 = ad.f38485a;
            String r21 = r0.getString(ZeusTransformUtils.mapRes(R.string.donation_step_index, WsChannelMultiProcessSharedProvider.STRING_TYPE, "donation_step_index"));
            o.c(r21, "getString(...)");
            String r22 = String.format(r21, Arrays.copyOf(new Object[]{Integer.valueOf(r14 + 1)}, 1));
            o.c(r22, "format(...)");
            r5.setText((CharSequence) ZeusTransformUtils.preCheckCast(r22, CharSequence.class, "com.obric.aiagent.plugin"));
            OTextView r23 = this.s.i;
            k r24 = this.r;
            String r25 = r13.d();
            if (r25 == null) goto L45;
            Object r26 = ZeusTransformUtils.preCheckCast(r25, CharSequence.class, "com.obric.aiagent.plugin");
        L49:
            r23.setText((CharSequence) r26);
            CharSequence r1 = (CharSequence) ZeusTransformUtils.preCheckCast(r13.d(), CharSequence.class, "com.obric.aiagent.plugin");
            if (r1 != null) goto L52;
        L55:
            if (r11 == false) goto L57;
            int r2 = r0.getColor(ZeusTransformUtils.mapRes(R.color.oui_basic_text_4, "color", "oui_basic_text_4"));
        L58:
            r23.setTextColor(r2);
            E();
            OIconButton r27 = this.s.f22787d;
            if (this.r.g() == false) goto L61;
            int r28 = 0;
        L62:
            r27.setVisibility(r28);
            r27.setOnClickListener(new $$Lambda$k$a$Lf121jofEcTBI4licgFZaWALQjA(r0, r13, this, r14));
            OIconButton r110 = this.s.f22785b;
            final k r29 = this.r;
            if (r29.g() == false) goto L65;
            r4 = 0;
        L65:
            r110.setVisibility(r4);
            r110.setOnClickListener(new $$Lambda$k$a$3rX4uAtLxgSKpAwm1tj95KMPzCs(this, r29, r14));
            return;
        L61:
            r28 = 8;
            goto L62
        L57:
            r2 = r0.getColor(ZeusTransformUtils.mapRes(R.color.oui_basic_text_1, "color", "oui_basic_text_1"));
            goto L58
        L52:
            if (r1.length() == 0) goto L55;
            r11 = false;
            goto L55
        L45:
            if (r24.g() == false) goto L47;
            String r30 = r0.getString(ZeusTransformUtils.mapRes(R.string.add_thought_tips, WsChannelMultiProcessSharedProvider.STRING_TYPE, "add_thought_tips"));
        L48:
            o.a(r30);
            r26 = ZeusTransformUtils.preCheckCast(r30, CharSequence.class, "com.obric.aiagent.plugin");
            goto L49
        L47:
            r30 = "";
            goto L48
        L39:
            r3.setVisibility(8);
            goto L40
        L32:
            r17 = 8;
            goto L33
        L26:
            if (r13.b() != null) goto L29;
            r16 = false;
            goto L30
        L20:
            if (r12.length() == 0) goto L23;
            r15 = false;
            goto L24
        L9:
            if (((CharSequence) ZeusTransformUtils.preCheckCast(r10, CharSequence.class, "com.obric.aiagent.plugin")).length() <= 0) goto L11;
            boolean r111 = true;
        L12:
            if (r111 == true) goto L15;
            r10 = null;
        L15:
            if (r10 == null) goto L17;
            Glide.with((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(this.f2390a.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")).clear((View) ZeusTransformUtils.preCheckCast(r8, View.class, "com.obric.aiagent.plugin"));
            Glide.with((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(this.f2390a.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")).load(r10).a((ImageView) ZeusTransformUtils.preCheckCast(r8, ImageView.class, "com.obric.aiagent.plugin")).b();
            goto L17
        L11:
            r111 = false;
            goto L12
        L5:
            this.s.g.setVisibility(8);
            goto L6
        }

        private static final void a(a r2, k r3, int r4, View r5) {
            RecordedImagePreviewActivity.c r6 = RecordedImagePreviewActivity.Companion;
            Context r7 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r2.f2390a.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
            o.c(r7, "getContext(...)");
            r6.a(r7, r3.h(), r4);
        }

        private static final void a(Context r3, final com.obric.autoaction.app.launcherpage.donation.model.c r4, final a r5, final int r6, View r7) {
            Context r8 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
            o.a(r8);
            String r0 = r8.getString(ZeusTransformUtils.mapRes(R.string.add_something, WsChannelMultiProcessSharedProvider.STRING_TYPE, "add_something"));
            o.c(r0, "getString(...)");
            g r9 = new g(r8, r0);
            r9.a(r8.getString(ZeusTransformUtils.mapRes(R.string.your_reason_for_this_step, WsChannelMultiProcessSharedProvider.STRING_TYPE, "your_reason_for_this_step")));
            r9.b(r4.d());
            r9.a(new $$Lambda$k$a$CZO1isKz98CXQDQMPOO6XdCfg4(r4, r5, r6));
            r9.a($$Lambda$k$a$jOK8OZnSQ32Y11b9xyz8Bfjhyyc.INSTANCE);
            r9.a();
        }

        private static final x a(com.obric.autoaction.app.launcherpage.donation.model.c r1, a r2, int r3, View r4, String r5) {
            o.e(r4, "<unused var>");
            o.e(r5, "text");
            r1.b(r5);
            RecyclerView.a<? extends RecyclerView.u> r6 = r2.h();
            if (r6 == null) goto L6;
            r6.d(r3);
        L6:
            return x.f38692a;
        }

        private static final x a(View r1) {
            o.e(r1, "it");
            return x.f38692a;
        }

        private static final void b(final a r8, final k r9, final int r10, View r11) {
            Context r0 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r8.s.b().getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
            o.c(r0, "getContext(...)");
            String r2 = ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r8.s.b().getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")).getString(ZeusTransformUtils.mapRes(R.string.confirm_remove_current_step, WsChannelMultiProcessSharedProvider.STRING_TYPE, "confirm_remove_current_step"));
            o.c(r2, "getString(...)");
            String r5 = ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r8.s.b().getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")).getString(ZeusTransformUtils.mapRes(R.string.delete, WsChannelMultiProcessSharedProvider.STRING_TYPE, "delete"));
            o.c(r5, "getString(...)");
            com.obric.autoaction.app.launcherpage.donation.a r12 = new com.obric.autoaction.app.launcherpage.donation.a(r0, r2, r5);
            r12.a(((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r8.s.b().getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")).getString(ZeusTransformUtils.mapRes(R.string.confirm_remove_current_step_tips, WsChannelMultiProcessSharedProvider.STRING_TYPE, "confirm_remove_current_step_tips")));
            r12.a(new $$Lambda$k$a$rXdzXMeLBOrRkJsLAdFybZADRA(r9, r10, r8));
            r12.a();
        }

        private static final x a(k r1, int r2, a r3) {
            r1.h().remove(r2);
            RecyclerView.a<? extends RecyclerView.u> r4 = r3.h();
            if (r4 == null) goto L5;
            r4.e(r2);
            r4.a(r2, r4.a() - r2);
        L5:
            r1.i().invoke();
            return x.f38692a;
        }

        private final void E() {
            final OTextView r1 = this.s.i;
            o.c(r1, "thoughtTv");
            r1.setMaxLines(Integer.MAX_VALUE);
            r1.setEllipsize(null);
            r1.post(new $$Lambda$k$a$hcPetmGGr0WAjqI4HBzUmcS9cqE(r1));
        }

        private static final void a(OTextView r2) {
            r2.setMaxLines(Math.max(1, ((r2.getHeight() - r2.getPaddingTop()) - r2.getPaddingBottom()) / r2.getLineHeight()));
            r2.setEllipsize(TextUtils.TruncateAt.END);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.a
    public /* synthetic */ RecyclerView.u a(ViewGroup r1, int r2) {
        return (RecyclerView.u) ZeusTransformUtils.preCheckCast(c(r1, r2), RecyclerView.u.class, "com.obric.aiagent.plugin");
    }

    @Override // androidx.recyclerview.widget.RecyclerView.a
    public /* synthetic */ void a(RecyclerView.u r3, int r4) {
        a((a) ZeusTransformUtils.preCheckCast(r3, a.class, "com.obric.aiagent.plugin"), r4);
    }

    public final boolean g() {
        return this.f23769a;
    }

    public final List<com.obric.autoaction.app.launcherpage.donation.model.c> h() {
        return this.f23770b;
    }

    public final d.h.a.a<x> i() {
        return this.f23771c;
    }

    public k(boolean r3, List<com.obric.autoaction.app.launcherpage.donation.model.c> r4, d.h.a.a<x> r5) {
        List<com.obric.autoaction.app.launcherpage.donation.model.c> r6 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.aiagent.plugin");
        d.h.a.a<x> r7 = (d.h.a.a) ZeusTransformUtils.wrapperContextForParams(r5, d.h.a.a.class, "com.obric.aiagent.plugin");
        o.e(r6, "operations");
        o.e(r7, "onStepRemove");
        this.f23769a = r3;
        this.f23770b = r6;
        this.f23771c = r7;
        this.f23772d = r6;
    }

    public a c(ViewGroup r3, int r4) {
        o.e(r3, "parent");
        av r5 = av.a(LayoutInflater.from((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r3.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")), r3, false);
        o.c(r5, "inflate(...)");
        OUILinearLayout r6 = r5.b();
        o.c(r6, "getRoot(...)");
        return new a(this, (View) ZeusTransformUtils.preCheckCast(r6, View.class, "com.obric.aiagent.plugin"));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.a
    public int a() {
        return this.f23772d.size();
    }

    public void a(a r3, int r4) {
        o.e(r3, "holder");
        r3.a((com.obric.autoaction.app.launcherpage.donation.model.c) ZeusTransformUtils.preCheckCast(this.f23772d.get(r4), com.obric.autoaction.app.launcherpage.donation.model.c.class, "com.obric.aiagent.plugin"), r4);
    }
}
