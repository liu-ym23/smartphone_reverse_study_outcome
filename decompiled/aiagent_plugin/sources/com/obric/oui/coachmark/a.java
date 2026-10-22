package com.obric.oui.coachmark;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import com.obric.aiagent.plugin.R;
import com.obric.oui.common.util.g;
import com.obric.oui.popover.v2.OPopover;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;
import d.h.b.z;
import d.k;
import d.l.n;
import d.x;

/* JADX INFO: compiled from: OCoachmark.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class a {
    private static final String TAG = "OCoachmark";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f34429a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final OCoachmarkView.a f34430b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final int f34431c = 0;

    /* JADX INFO: renamed from: com.obric.oui.coachmark.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: OCoachmark.kt */
    public static final class C0933a {
        private d.h.a.b<? super View, x> A;
        private d.h.a.b<? super View, x> B;
        private d.h.a.a<x> C;
        private d.h.a.a<x> D;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Activity f34432a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private b f34433b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private int f34434c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private int f34435d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private Integer f34436e;
        private C0934a f;
        private long g;
        private boolean h;
        private CharSequence i;
        private CharSequence j;
        private Integer k;
        private TextUtils.TruncateAt l;
        private CharSequence m;
        private CharSequence n;
        private CharSequence o;
        private Drawable p;
        private Drawable q;
        private View r;
        private boolean s;
        private boolean t;
        private Integer u;
        private OCoachmarkView.a v;
        private boolean w;
        private int x;
        private d.h.a.b<? super View, x> y;
        private d.h.a.b<? super View, x> z;

        /* JADX INFO: renamed from: com.obric.oui.coachmark.a$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: OCoachmark.kt */
        private static final class C0934a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private final int f34437a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            private final int f34438b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            private final int f34439c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            private final int f34440d;

            public boolean equals(Object r5) {
                if (this != r5) goto L6;
                return true;
            L6:
                if (ZeusTransformUtils.instanceOf(r5, C0934a.class) == true) goto L8;
                return false;
            L8:
                C0934a r6 = (C0934a) ZeusTransformUtils.preCheckCast(r5, C0934a.class, "com.obric.aiagent.plugin");
                if (this.f34437a == r6.f34437a) goto L12;
                return false;
            L12:
                if (this.f34438b == r6.f34438b) goto L15;
                return false;
            L15:
                if (this.f34439c == r6.f34439c) goto L18;
                return false;
            L18:
                if (this.f34440d == r6.f34440d) goto L20;
                return false;
            L20:
                return true;
            }

            public int hashCode() {
                return (((((Integer.hashCode(this.f34437a) * 31) + Integer.hashCode(this.f34438b)) * 31) + Integer.hashCode(this.f34439c)) * 31) + Integer.hashCode(this.f34440d);
            }

            public String toString() {
                return "ContentPadding(startPx=" + this.f34437a + ", topPx=" + this.f34438b + ", endPx=" + this.f34439c + ", bottomPx=" + this.f34440d + ')';
            }

            public final int a() {
                return this.f34437a;
            }

            public final int b() {
                return this.f34438b;
            }

            public final int c() {
                return this.f34439c;
            }

            public final int d() {
                return this.f34440d;
            }
        }

        /* JADX INFO: renamed from: com.obric.oui.coachmark.a$a$b */
        /* JADX INFO: compiled from: OCoachmark.kt */
        public /* synthetic */ class b {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ int[] f34441a = null;

            static {
                int[] r0 = new int[b.values().length];
                r0[b.f34449b.ordinal()] = 1;
                r0[b.f34448a.ordinal()] = 2;
                f34441a = r0;
            }
        }

        /* JADX INFO: renamed from: com.obric.oui.coachmark.a$a$c */
        /* JADX INFO: compiled from: OCoachmark.kt */
        public static final class c implements OPopover.d {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ C0933a f34442a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ z.f<OPopover> f34443b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            final /* synthetic */ Runnable f34444c;

            c(C0933a r3, z.f<OPopover> r4, Runnable r5) {
                Runnable r6 = (Runnable) ZeusTransformUtils.wrapperContextForParams(r5, Runnable.class, "com.obric.aiagent.plugin");
                this.f34442a = r3;
                this.f34443b = r4;
                this.f34444c = r6;
            }

            @Override // com.obric.oui.popover.v2.OPopover.d
            public void a() {
                d.h.a.a r0 = C0933a.a(this.f34442a);
                if (r0 == null) goto L7;
                r0.invoke();
            L7:
                if (C0933a.b(this.f34442a) > 0) goto L9;
                return;
            L9:
                OPopover r1 = (OPopover) ZeusTransformUtils.preCheckCast(this.f34443b.f38504a, OPopover.class, "com.obric.aiagent.plugin");
                if (r1 != null) goto L16;
                com.obric.oui.d.a.b r4 = com.obric.oui.d.a.b.f35007a;
                if (r4.a(8) == true) goto L18;
                r4.a().a(a.TAG, 8, "auto dismiss schedule skipped: popover reference missing.", null);
                return;
            L18:
                return;
            L16:
                r1.getContentView().removeCallbacks(this.f34444c);
                r1.getContentView().postDelayed(this.f34444c, C0933a.b(this.f34442a));
            }
        }

        /* JADX INFO: renamed from: com.obric.oui.coachmark.a$a$d */
        /* JADX INFO: compiled from: OCoachmark.kt */
        public static final class d implements OPopover.c {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ z.f<OPopover> f34445a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ Runnable f34446b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            final /* synthetic */ C0933a f34447c;

            d(z.f<OPopover> r3, Runnable r4, C0933a r5) {
                Runnable r6 = (Runnable) ZeusTransformUtils.wrapperContextForParams(r4, Runnable.class, "com.obric.aiagent.plugin");
                this.f34445a = r3;
                this.f34446b = r6;
                this.f34447c = r5;
            }

            @Override // com.obric.oui.popover.v2.OPopover.c
            public void a() {
                OPopover r0 = (OPopover) ZeusTransformUtils.preCheckCast(this.f34445a.f38504a, OPopover.class, "com.obric.aiagent.plugin");
                if (r0 == null) goto L9;
                View r1 = r0.getContentView();
                if (r1 == null) goto L9;
                r1.removeCallbacks(this.f34446b);
            L9:
                d.h.a.a r3 = C0933a.c(this.f34447c);
                if (r3 == null) goto L14;
                r3.invoke();
                return;
            }
        }

        private final int e(int r5) {
            boolean r1 = true;
            if ((r5 & 8388611) != 8388611) goto L5;
            boolean r4 = true;
        L7:
            if ((r5 & 8388613) == 8388613) goto L10;
            r1 = false;
        L10:
            if (r4 == false) goto L12;
            return 3;
        L12:
            if (r1 == false) goto L15;
            return 5;
        L15:
            return r5 & 7;
        L5:
            r4 = false;
            goto L7
        }

        /* JADX INFO: renamed from: lambda$bq5fcpVmC1w79IgrSxxQaNd-IvU, reason: not valid java name */
        public static /* synthetic */ void m993lambda$bq5fcpVmC1w79IgrSxxQaNdIvU(z.f r0) {
            a(r0);
        }

        public static /* synthetic */ void lambda$fJ6D2ZmvEgsewPmff_BG47bjtL8(C0933a r0, z.f r1, View r2) {
            b(r0, r1, r2);
        }

        public static /* synthetic */ void lambda$yeuujQQVdTh4bmZbGRrP8NaAH_o(C0933a r0, z.f r1, View r2) {
            a(r0, r1, r2);
        }

        public static /* synthetic */ void lambda$yrIAmpF1DPdi5p1UBf_S282YuYU(d.h.a.b r0, C0933a r1, z.f r2, View r3) {
            a(r0, r1, r2, r3);
        }

        public C0933a(Activity r3) {
            Activity r4 = (Activity) ZeusTransformUtils.wrapperContextForParams(r3, Activity.class, "com.obric.aiagent.plugin");
            o.e(r4, "activity");
            Activity r5 = ZeusTransformUtils.wrapperContext2Activity(r4, "com.obric.aiagent.plugin");
            this.f34432a = r5;
            this.f34433b = b.f34448a;
            this.f34434c = 80;
            this.f34435d = g.a((Context) ZeusTransformUtils.preCheckCast(r5, Context.class, "com.obric.aiagent.plugin"), 8);
            this.h = true;
            this.t = true;
            this.x = ZeusTransformUtils.mapRes(R.style.OStyleV2_OCoachmarkView_DayNight, "style", "OStyleV2_OCoachmarkView_DayNight");
        }

        public static final /* synthetic */ d.h.a.a a(C0933a r0) {
            return r0.C;
        }

        public static final /* synthetic */ long b(C0933a r2) {
            return r2.g;
        }

        public static final /* synthetic */ d.h.a.a c(C0933a r0) {
            return r0.D;
        }

        public final C0933a a(b r4) {
            o.e(r4, "type");
            ((C0933a) ZeusTransformUtils.preCheckCast(this, C0933a.class, "com.obric.aiagent.plugin")).f34433b = r4;
            return (C0933a) ZeusTransformUtils.preCheckCast(this, C0933a.class, "com.obric.aiagent.plugin");
        }

        public final C0933a a(int r4) {
            ((C0933a) ZeusTransformUtils.preCheckCast(this, C0933a.class, "com.obric.aiagent.plugin")).f34434c = r4;
            return (C0933a) ZeusTransformUtils.preCheckCast(this, C0933a.class, "com.obric.aiagent.plugin");
        }

        public final C0933a a(boolean r4) {
            ((C0933a) ZeusTransformUtils.preCheckCast(this, C0933a.class, "com.obric.aiagent.plugin")).h = r4;
            return (C0933a) ZeusTransformUtils.preCheckCast(this, C0933a.class, "com.obric.aiagent.plugin");
        }

        public final C0933a a(CharSequence r4) {
            ((C0933a) ZeusTransformUtils.preCheckCast(this, C0933a.class, "com.obric.aiagent.plugin")).i = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r4, CharSequence.class, "com.obric.aiagent.plugin");
            return (C0933a) ZeusTransformUtils.preCheckCast(this, C0933a.class, "com.obric.aiagent.plugin");
        }

        public static /* synthetic */ C0933a a(C0933a r1, CharSequence r2, Integer r3, TextUtils.TruncateAt r4, int r5, Object r6) {
            CharSequence r7 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r2, CharSequence.class, "com.obric.aiagent.plugin");
            if ((r5 & 2) == 0) goto L6;
            r3 = null;
        L6:
            if ((r5 & 4) == 0) goto L9;
            r4 = null;
        L9:
            return r1.a(r7, r3, r4);
        }

        public final C0933a a(CharSequence r4, Integer r5, TextUtils.TruncateAt r6) {
            CharSequence r7 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r4, CharSequence.class, "com.obric.aiagent.plugin");
            C0933a r1 = (C0933a) ZeusTransformUtils.preCheckCast(this, C0933a.class, "com.obric.aiagent.plugin");
            r1.j = r7;
            r1.k = r5;
            r1.l = r6;
            return (C0933a) ZeusTransformUtils.preCheckCast(this, C0933a.class, "com.obric.aiagent.plugin");
        }

        public final C0933a b(CharSequence r4) {
            ((C0933a) ZeusTransformUtils.preCheckCast(this, C0933a.class, "com.obric.aiagent.plugin")).m = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r4, CharSequence.class, "com.obric.aiagent.plugin");
            return (C0933a) ZeusTransformUtils.preCheckCast(this, C0933a.class, "com.obric.aiagent.plugin");
        }

        public final C0933a a(Drawable r4) {
            ((C0933a) ZeusTransformUtils.preCheckCast(this, C0933a.class, "com.obric.aiagent.plugin")).p = r4;
            return (C0933a) ZeusTransformUtils.preCheckCast(this, C0933a.class, "com.obric.aiagent.plugin");
        }

        public final C0933a b(int r4) {
            C0933a r2 = (C0933a) ZeusTransformUtils.preCheckCast(this, C0933a.class, "com.obric.aiagent.plugin");
            r2.u = Integer.valueOf(r4);
            return (C0933a) ZeusTransformUtils.preCheckCast(this, C0933a.class, "com.obric.aiagent.plugin");
        }

        /* JADX WARN: Type inference failed for: r1v24, types: [T, com.obric.oui.popover.v2.OPopover] */
        public final OPopover a() {
            final z.f r0 = new z.f();
            final d.h.a.b<? super View, x> r1 = this.z;
            if (r1 != null) goto L5;
            r1 = this.y;
        L5:
            OCoachmarkView r2 = a(new $$Lambda$a$a$yrIAmpF1DPdi5p1UBf_S282YuYU(r1, this, r0), new $$Lambda$a$a$yeuujQQVdTh4bmZbGRrP8NaAH_o(this, r0), new $$Lambda$a$a$fJ6D2ZmvEgsewPmff_BG47bjtL8(this, r0));
            r2.setPopWindowMode(true);
            OPopover.a r3 = (OPopover.a) ZeusTransformUtils.preCheckCast(((OPopover.a) ZeusTransformUtils.preCheckCast(((OPopover.a) ZeusTransformUtils.preCheckCast(((OPopover.a) ZeusTransformUtils.preCheckCast(((OPopover.a) ZeusTransformUtils.preCheckCast(((OPopover.a) ZeusTransformUtils.preCheckCast(new OPopover.a((Context) ZeusTransformUtils.preCheckCast(this.f34432a, Context.class, "com.obric.aiagent.plugin")).a((View) ZeusTransformUtils.preCheckCast(r2, View.class, "com.obric.aiagent.plugin")), OPopover.a.class, "com.obric.aiagent.plugin")).c(false), OPopover.a.class, "com.obric.aiagent.plugin")).a(false), OPopover.a.class, "com.obric.aiagent.plugin")).a(a.a()), OPopover.a.class, "com.obric.aiagent.plugin")).d(true), OPopover.a.class, "com.obric.aiagent.plugin")).e(false), OPopover.a.class, "com.obric.aiagent.plugin");
            long r4 = this.g;
            if (r4 <= 0) goto L8;
            r3.a(r4);
        L8:
            Runnable r5 = new $$Lambda$a$a$bq5fcpVmC1w79IgrSxxQaNdIvU(r0);
            r3.a((OPopover.d) ZeusTransformUtils.preCheckCast(new c(this, r0, r5), OPopover.d.class, "com.obric.aiagent.plugin"));
            r3.a((OPopover.c) ZeusTransformUtils.preCheckCast(new d(r0, r5, this), OPopover.c.class, "com.obric.aiagent.plugin"));
            ?? r6 = r3.G();
            r0.f38504a = r6;
            this.r = null;
            return r6;
        }

        private static final void a(d.h.a.b r2, C0933a r3, z.f r4, View r5) {
            d.h.a.b r6 = (d.h.a.b) ZeusTransformUtils.wrapperContextForParams(r2, d.h.a.b.class, "com.obric.aiagent.plugin");
            o.e(r3, "this$0");
            o.e(r4, "$popoverRef");
            if (r6 == null) goto L6;
            o.c(r5, "clickedView");
            r6.invoke(r5);
        L6:
            r3.a((OPopover) ZeusTransformUtils.preCheckCast(r4.f38504a, OPopover.class, "com.obric.aiagent.plugin"), "primary action");
        }

        private static final void a(C0933a r2, z.f r3, View r4) {
            o.e(r2, "this$0");
            o.e(r3, "$popoverRef");
            d.h.a.b<? super View, x> r0 = r2.A;
            if (r0 == null) goto L6;
            o.c(r4, "clickedView");
            r0.invoke(r4);
        L6:
            r2.a((OPopover) ZeusTransformUtils.preCheckCast(r3.f38504a, OPopover.class, "com.obric.aiagent.plugin"), "secondary action");
        }

        private static final void b(C0933a r2, z.f r3, View r4) {
            o.e(r2, "this$0");
            o.e(r3, "$popoverRef");
            d.h.a.b<? super View, x> r0 = r2.B;
            if (r0 == null) goto L6;
            o.c(r4, "clickedView");
            r0.invoke(r4);
        L6:
            r2.a((OPopover) ZeusTransformUtils.preCheckCast(r3.f38504a, OPopover.class, "com.obric.aiagent.plugin"), "dismiss");
        }

        private static final void a(z.f r2) {
            o.e(r2, "$popoverRef");
            OPopover r3 = (OPopover) ZeusTransformUtils.preCheckCast(r2.f38504a, OPopover.class, "com.obric.aiagent.plugin");
            if (r3 != null) goto L5;
            return;
        L5:
            if (r3.isShowing() == false) goto L10;
            r3.dismiss();
            return;
        }

        public final OPopover a(View r4) {
            o.e(r4, "anchor");
            b(r4);
            OPopover r1 = a();
            a(r4, r1);     // Catch: Exception -> L8
            if (r1.isShowing() == false) goto L6;
            return r1;
        L6:
            String r5 = o.a("show failed: popover is not showing. anchor: ", r4.getClass().getSimpleName());     // Catch: Exception -> L8
            com.obric.oui.d.a.b.e(a.TAG, r5);     // Catch: Exception -> L8
            throw new IllegalStateException(r5);     // Catch: Exception -> L8
        L8:
            e = move-exception;
            com.obric.oui.d.a.b.b(a.TAG, "show failed, type: " + this.f34433b + ", gravity: " + this.f34434c + ", margin: " + this.f34435d, (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.aiagent.plugin"));
            throw new IllegalStateException("Failed to show coachmark.", (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.aiagent.plugin"));
        }

        private final void a(View r14, OPopover r15) {
            Integer r0 = this.f34436e;
            if (r0 != null) goto L5;
            int r1 = g.a(r14, 320);
        L6:
            int r9 = View.MeasureSpec.makeMeasureSpec(r1, Integer.MIN_VALUE);
            if (c(this.f34434c) == false) goto L10;
            a(r14, r15, r9);
            return;
        L10:
            com.obric.oui.popover.v2.d.a(com.obric.oui.popover.v2.d.f36067a, r15, r14, this.f34434c, false, this.f34435d, false, r9, 0, 160, null);
            return;
        L5:
            r1 = r0.intValue();
            goto L6
        }

        private final boolean c(int r4) {
            int r0 = r4 & 112;
            int r3 = e(r4);
            if (r3 != 3) goto L5;
        L8:
            boolean r5 = true;
        L9:
            if (r5 == true) goto L11;
            return false;
        L11:
            if (r0 != 48) goto L13;
            return false;
        L13:
            if (r0 != 80) goto L15;
            return false;
        L15:
            return true;
        L5:
            if (r3 == 5) goto L8;
            r5 = false;
            goto L9
        }

        private final void a(View r20, OPopover r21, int r22) {
            if (r20.getWidth() <= 0) goto L5;
            int r3 = r20.getWidth();
        L7:
            if (r20.getHeight() <= 0) goto L9;
            int r4 = r20.getHeight();
        L10:
            int[] r6 = new int[2];
            r20.getLocationOnScreen(r6);
            int r8 = r6[0];
            int r7 = r6[1];
            int r9 = r8 + r3;
            float r10 = r7 + (r4 / 2.0f);
            r21.getContentView().measure(r22, 0);
            int r11 = r21.getContentView().getMeasuredWidth();
            int r13 = r21.getContentView().getMeasuredHeight();
            if (r11 <= 0) goto L22;
            if (r13 <= 0) goto L22;
            int r15 = e(this.f34434c);
            if (r15 != 3) goto L16;
            int r12 = (r8 - r11) - this.f34435d;
        L20:
            int r5 = d.i.a.a(r10 - (r13 / 2.0f));
            Context r14 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r20.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
            o.c(r14, "anchor.context");
            int r16 = g.c(r14);
            int r17 = r4;
            Context r18 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r20.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
            o.c(r18, "anchor.context");
            int r19 = g.d(r18);
            int r110 = g.a(r20, 8);
            int r23 = r16 - r11;
            int r111 = r23 - g.a(r20, 8);
            int r112 = r3;
            int r24 = com.obric.oui.window.a.a((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r20.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"));
            int r25 = r19 - r13;
            int r113 = r25 - g.a(r20, 48);
            int r26 = a(r12, r110, r111, r23);
            int r27 = a(r5, r24, r113, r25);
            r21.setGravity(r15 | 16);
            com.obric.oui.d.a.b.b(a.TAG, "show side aligned coachmark. gravity=" + r15 + ", anchor=[" + r8 + ',' + r7 + ',' + r112 + ',' + r17 + "], popover=[" + r11 + ',' + r13 + "], position=[" + r26 + ',' + r27 + "], margin=" + this.f34435d);
            r21.showAtLocation(r20, 0, r26, r27);
            return;
        L16:
            if (r15 == 5) goto L18;
            r12 = ((r3 - r11) / 2) + r8;
            goto L20
        L18:
            r12 = r9 + this.f34435d;
        L22:
            String r0 = "side aligned show failed: invalid popover size. width=" + r11 + ", height=" + r13;
            com.obric.oui.d.a.b.e(a.TAG, r0);
            throw new IllegalStateException(r0);
        L9:
            r4 = r20.getMeasuredHeight();
            goto L10
        L5:
            r3 = r20.getMeasuredWidth();
            goto L7
        }

        private final int a(int r1, int r2, int r3, int r4) {
            if (r3 < r2) goto L5;
            return n.a(r1, r2, r3);
        L5:
            return n.a(r1, 0, n.c(r4, 0));
        }

        private final void a(OPopover r4, String r5) {
            if (this.h == true) goto L5;
            return;
        L5:
            if (r4 != null) goto L11;
            com.obric.oui.d.a.b r3 = com.obric.oui.d.a.b.f35007a;
            if (r3.a(8) == true) goto L13;
            r3.a().a(a.TAG, 8, "dismiss skipped after " + r5 + " click: popover reference missing.", null);
            return;
        L13:
            return;
        L11:
            r4.dismiss();
        }

        private final OCoachmarkView a(View.OnClickListener r10, View.OnClickListener r11, View.OnClickListener r12) {
            View.OnClickListener r13 = (View.OnClickListener) ZeusTransformUtils.wrapperContextForParams(r10, View.OnClickListener.class, "com.obric.aiagent.plugin");
            View.OnClickListener r14 = (View.OnClickListener) ZeusTransformUtils.wrapperContextForParams(r11, View.OnClickListener.class, "com.obric.aiagent.plugin");
            View.OnClickListener r15 = (View.OnClickListener) ZeusTransformUtils.wrapperContextForParams(r12, View.OnClickListener.class, "com.obric.aiagent.plugin");
            if (this.f34433b != b.f34449b) goto L11;
            if (this.s == false) goto L11;
            com.obric.oui.d.a.b r0 = com.obric.oui.d.a.b.f35007a;
            if (r0.a(8) == true) goto L11;
            r0.a().a(a.TAG, 8, "CARD style does not render close icon; closable has no visual effect.", null);
        L11:
            if (this.r == null) goto L16;
            com.obric.oui.d.a.b r1 = com.obric.oui.d.a.b.f35007a;
            if (r1.a(8) == true) goto L16;
            r1.a().a(a.TAG, 8, "custom content view is set; title, description, icon, hero, action, and close configs will be ignored.", null);
        L16:
            CharSequence r2 = this.n;
            if (r2 != null) goto L20;
            r2 = this.m;
        L20:
            if (r2 != null) goto L22;
        L25:
            boolean r4 = true;
        L26:
            if (r4 == false) goto L37;
            CharSequence r5 = this.o;
            if (r5 != null) goto L30;
        L33:
            boolean r6 = true;
        L34:
            if (r6 == false) goto L37;
            boolean r7 = false;
        L38:
            OCoachmarkView r8 = new OCoachmarkView((Context) ZeusTransformUtils.preCheckCast(this.f34432a, Context.class, "com.obric.aiagent.plugin"), null, 0, this.x);
            int r3 = b.f34441a[this.f34433b.ordinal()];
            if (r3 != 1) goto L41;
            OCoachmarkView.d r9 = OCoachmarkView.d.f34423c;
        L46:
            r8.setContentStyle(r9);
            r8.setArrowPosition(d(this.f34434c));
            r8.setArrowVisible(this.t);
            Integer r16 = this.u;
            if (r16 == null) goto L50;
            r8.setArrowOffset(((Number) ZeusTransformUtils.preCheckCast(r16, Number.class, "com.obric.aiagent.plugin")).intValue());
        L50:
            Integer r17 = this.f34436e;
            if (r17 == null) goto L54;
            r8.setMaxWidth(((Number) ZeusTransformUtils.preCheckCast(r17, Number.class, "com.obric.aiagent.plugin")).intValue());
        L54:
            C0934a r18 = this.f;
            if (r18 == null) goto L58;
            r8.setContentPadding(r18.a(), r18.b(), r18.c(), r18.d());
        L58:
            View r19 = this.r;
            if (r19 == null) goto L61;
            r8.setCustomContentView$OUI_standardRelease(r19);
        L70:
            return r8;
        L61:
            r8.setTitle(this.i);
            r8.setDescription(this.j, this.k, this.l);
            r8.setPrimaryButtonText(r2);
            r8.setSecondaryButtonText(this.o);
            r8.setIcon(this.p);
            r8.setHeroImage(this.q);
            r8.setCloseVisible(this.s);
            if (this.w == false) goto L66;
            OCoachmarkView.a r20 = this.v;
            if (r20 != null) goto L69;
            r20 = OCoachmarkView.a.f34412b;
        L69:
            r8.setActionStyle(r20);
            r8.setOnPrimaryActionClickListener(r13);
            r8.setOnSecondaryActionClickListener(r14);
            r8.setOnCloseClickListener(r15);
            goto L70
        L66:
            if (r7 == true) goto L68;
            r20 = OCoachmarkView.a.f34412b;
            goto L69
        L68:
            r20 = a.b();
            goto L69
        L41:
            if (r3 != 2) goto L44;
            r9 = OCoachmarkView.d.f34422b;
            goto L46
        L44:
            throw new k();
        L30:
            if (d.o.o.d(r5) == true) goto L33;
            r6 = false;
        L37:
            r7 = true;
            goto L38
        L22:
            if (d.o.o.d(r2) == true) goto L25;
            r4 = false;
            goto L26
        }

        private final void b(View r4) {
            if (r4.isAttachedToWindow() == true) goto L5;
            com.obric.oui.d.a.b.e(a.TAG, "anchor is not attached to window.");
            throw new IllegalStateException("anchor is not attached to window.");
        L5:
            if (r4.getWidth() <= 0) goto L7;
            int r3 = r4.getWidth();
        L9:
            if (r4.getHeight() <= 0) goto L11;
            int r5 = r4.getHeight();
        L12:
            if (r3 <= 0) goto L15;
            if (r5 <= 0) goto L15;
            return;
        L15:
            String r6 = "anchor has invalid size. width=" + r3 + ", height=" + r5;
            com.obric.oui.d.a.b.e(a.TAG, r6);
            throw new IllegalStateException(r6);
        L11:
            r5 = r4.getMeasuredHeight();
            goto L12
        L7:
            r3 = r4.getMeasuredWidth();
            goto L9
        }

        private final OCoachmarkView.b d(int r3) {
            int r0 = r3 & 112;
            if (r0 != 48) goto L7;
            return OCoachmarkView.b.f34418c;
        L7:
            if (r0 == 80) goto L9;
            int r2 = e(r3);
            if (r2 == 3) goto L17;
            if (r2 == 5) goto L19;
            return OCoachmarkView.b.f34417b;
        L19:
            return OCoachmarkView.b.f34419d;
        L17:
            return OCoachmarkView.b.f34420e;
        L9:
            return OCoachmarkView.b.f34417b;
        }
    }

    /* JADX INFO: compiled from: OCoachmark.kt */
    public static final enum b extends Enum<b> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final b f34448a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final b f34449b = null;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private static final /* synthetic */ b[] f34450c = null;

        private static final /* synthetic */ b[] a() {
            return new b[]{f34448a, f34449b};
        }

        public static b valueOf(String r2) {
            return (b) ZeusTransformUtils.preCheckCast(Enum.valueOf(b.class, r2), b.class, "com.obric.aiagent.plugin");
        }

        public static b[] values() {
            return (b[]) ZeusTransformUtils.preCheckCast(f34450c.clone(), b[].class, "com.obric.aiagent.plugin");
        }

        private b(String r1, int r2) {
            super(r1, r2);
        }

        static {
            f34448a = new b("PILL", 0);
            f34449b = new b("CARD", 1);
            f34450c = a();
        }
    }

    private a() {
    }

    public static final /* synthetic */ int a() {
        return f34431c;
    }

    public static final /* synthetic */ OCoachmarkView.a b() {
        return f34430b;
    }

    static {
        f34429a = new a();
        f34430b = OCoachmarkView.a.f34413c;
        f34431c = ZeusTransformUtils.mapRes(R.style.OUIShadow_3, "style", "OUIShadow_3");
    }
}
