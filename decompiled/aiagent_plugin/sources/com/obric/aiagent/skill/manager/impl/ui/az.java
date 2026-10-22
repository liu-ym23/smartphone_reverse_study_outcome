package com.obric.aiagent.skill.manager.impl.ui;

import android.animation.Animator;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.ColorStateList;
import android.os.Build;
import android.text.InputFilter;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewTreeObserver;
import android.view.animation.PathInterpolator;
import android.view.inputmethod.InputMethodManager;
import android.widget.FrameLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsAnimationCompat;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.bdturing.localstorage.DbHelper;
import com.bytedance.common.wschannel.WsChannelMultiProcessSharedProvider;
import com.facebook.drawee.view.SimpleDraweeView;
import com.obric.aiagent.plugin.R;
import com.obric.aiagent.skill.manager.impl.hd;
import com.obric.oui.dialog.v2.alert.OAlertDialog;
import com.obric.oui.forms.OEditText;
import com.obric.oui.forms.OInputLayout;
import com.obric.oui.lisitem.OCardListItem;
import com.obric.oui.sheet.v2.OSheet;
import com.obric.oui.sheet.v2.OSheetModal;
import com.obric.oui.text.OTextView;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

/* JADX INFO: compiled from: SkillFormSheetController.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class az {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final a f20592a = null;
    private static final PathInterpolator g = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final FragmentActivity f20593b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final hd f20594c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private c f20595d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private Integer f20596e;
    private final bk f;

    /* JADX INFO: compiled from: SkillFormSheetController.kt */
    private static final class a {
        public /* synthetic */ a(d.h.b.h r1) {
            this();
        }

        private a() {
        }
    }

    /* JADX INFO: compiled from: SkillFormSheetController.kt */
    private static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final OEditText f20597a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final View f20598b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final int f20599c;

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, b.class) == true) goto L8;
            return false;
        L8:
            b r6 = (b) ZeusTransformUtils.preCheckCast(r5, b.class, "com.obric.aiagent.plugin");
            if (d.h.b.o.a(this.f20597a, r6.f20597a) == true) goto L12;
            return false;
        L12:
            if (d.h.b.o.a(this.f20598b, r6.f20598b) == true) goto L15;
            return false;
        L15:
            if (this.f20599c == r6.f20599c) goto L17;
            return false;
        L17:
            return true;
        }

        public int hashCode() {
            return (((this.f20597a.hashCode() * 31) + this.f20598b.hashCode()) * 31) + Integer.hashCode(this.f20599c);
        }

        public String toString() {
            return "FocusField(focusTarget=" + this.f20597a + ", visualField=" + this.f20598b + ", centerOffsetDp=" + this.f20599c + ')';
        }

        public b(OEditText r2, View r3, int r4) {
            d.h.b.o.e(r2, "focusTarget");
            d.h.b.o.e(r3, "visualField");
            this.f20597a = r2;
            this.f20598b = r3;
            this.f20599c = r4;
        }

        public /* synthetic */ b(OEditText r1, View r2, int r3, int r4, d.h.b.h r5) {
            if ((r4 & 4) == 0) goto L5;
            r3 = 0;
        L5:
            this(r1, r2, r3);
        }

        public final OEditText a() {
            return this.f20597a;
        }

        public final View b() {
            return this.f20598b;
        }

        public final int c() {
            return this.f20599c;
        }
    }

    /* JADX INFO: compiled from: SkillFormSheetController.kt */
    private final class c implements bc {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ az f20600a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final d f20601b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final OSheetModal f20602c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private ay f20603d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private final bb f20604e;
        private al f;
        private OCardListItem g;
        private at h;
        private boolean i;
        private boolean j;
        private String k;
        private View l;
        private a m;
        private final ArrayList<d.h.a.a<d.x>> n;

        /* JADX INFO: compiled from: SkillFormSheetController.kt */
        private final class a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ c f20605a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            private final ScrollView f20606b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            private final OSheetModal f20607c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            private final View f20608d;

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            private final List<b> f20609e;
            private final int f;
            private int g;
            private final int h;
            private int i;
            private androidx.core.view.al j;
            private boolean k;
            private int l;
            private int m;
            private b n;
            private boolean o;
            private boolean p;
            private boolean q;
            private boolean r;
            private int s;
            private int t;
            private ValueAnimator u;
            private final ViewTreeObserver.OnGlobalFocusChangeListener v;
            private final C0434a w;

            /* JADX INFO: renamed from: com.obric.aiagent.skill.manager.impl.ui.az$c$a$a, reason: collision with other inner class name */
            /* JADX INFO: compiled from: SkillFormSheetController.kt */
            public static final class C0434a extends WindowInsetsAnimationCompat.b {

                /* JADX INFO: renamed from: b, reason: collision with root package name */
                final /* synthetic */ a f20610b;

                /* JADX INFO: renamed from: c, reason: collision with root package name */
                final /* synthetic */ c f20611c;

                /* JADX INFO: renamed from: lambda$QTjVo58xQIHEUotPNucVL-mBpk4, reason: not valid java name */
                public static /* synthetic */ void m337lambda$QTjVo58xQIHEUotPNucVLmBpk4(c r0, a r1) {
                    a(r0, r1);
                }

                C0434a(a r1, c r2) {
                    this.f20610b = r1;
                    this.f20611c = r2;
                    super(1);
                }

                @Override // androidx.core.view.WindowInsetsAnimationCompat.b
                public void a(WindowInsetsAnimationCompat r5) {
                    d.h.b.o.e(r5, "animation");
                    if (a.a(this.f20610b, r5) == true) goto L5;
                    return;
                L5:
                    a.c(this.f20610b);
                    boolean r0 = true;
                    a.a(this.f20610b, true);
                    a r6 = this.f20610b;
                    if (a.d(r6) == true) goto L18;
                    androidx.core.view.al r1 = a.b(this.f20610b);
                    if (r1 != null) goto L10;
                L12:
                    boolean r2 = false;
                L13:
                    if (r2 == true) goto L18;
                    if (a.e(this.f20610b) == true) goto L18;
                    r0 = false;
                    goto L18
                L10:
                    if (a.b(this.f20610b, r1) != true) goto L12;
                    r2 = true;
                L18:
                    a.b(r6, r0);
                    a.c(this.f20610b, false);
                    a.d(this.f20610b, false);
                    a r4 = this.f20610b;
                    a.b(r4, a.f(r4).getScrollY());
                }

                @Override // androidx.core.view.WindowInsetsAnimationCompat.b
                public WindowInsetsAnimationCompat.a a(WindowInsetsAnimationCompat r5, WindowInsetsAnimationCompat.a r6) {
                    d.h.b.o.e(r5, "animation");
                    d.h.b.o.e(r6, "bounds");
                    if (a.a(this.f20610b, r5) == false) goto L23;
                    androidx.core.view.al r7 = a.b(this.f20610b);
                    boolean r0 = true;
                    if (r7 != null) goto L7;
                L9:
                    boolean r8 = false;
                L10:
                    a r2 = this.f20610b;
                    if (a.g(r2) == true) goto L14;
                    if (r8 == false) goto L14;
                    boolean r3 = true;
                L15:
                    a.c(r2, r3);
                    a r4 = this.f20610b;
                    if (a.g(r4) == false) goto L19;
                    if (r8 == true) goto L19;
                L20:
                    a.d(r4, r0);
                    if (a.h(this.f20610b) == false) goto L23;
                    a.i(this.f20610b);
                L19:
                    r0 = false;
                L14:
                    r3 = false;
                    goto L15
                L7:
                    if (a.b(this.f20610b, r7) != true) goto L9;
                    r8 = true;
                L23:
                    return r6;
                }

                @Override // androidx.core.view.WindowInsetsAnimationCompat.b
                public androidx.core.view.al a(androidx.core.view.al r5, List<WindowInsetsAnimationCompat> r6) {
                    List r7 = (List) ZeusTransformUtils.wrapperContextForParams(r6, List.class, "com.obric.aiagent.plugin");
                    d.h.b.o.e(r5, "insets");
                    d.h.b.o.e(r7, "runningAnimations");
                    a.c(this.f20610b, r5);
                    a r0 = this.f20610b;
                    ListIterator r8 = r7.listIterator(r7.size());
                L4:
                    if (r8.hasPrevious() == false) goto L8;
                    Object r2 = r8.previous();
                    if (a.a(r0, (WindowInsetsAnimationCompat) ZeusTransformUtils.preCheckCast(r2, WindowInsetsAnimationCompat.class, "com.obric.aiagent.plugin")) == false) goto L4;
                L9:
                    WindowInsetsAnimationCompat r9 = (WindowInsetsAnimationCompat) ZeusTransformUtils.preCheckCast(r2, WindowInsetsAnimationCompat.class, "com.obric.aiagent.plugin");
                    if (r9 != null) goto L12;
                L21:
                    a.d(this.f20610b, r5);
                    return r5;
                L12:
                    if (a.h(this.f20610b) == true) goto L16;
                    if (a.j(this.f20610b) == false) goto L21;
                L16:
                    if (a.h(this.f20610b) == false) goto L18;
                    a.a(this.f20610b, r9.b());
                L19:
                    a.a(this.f20610b, r5);
                    a.c(this.f20610b, r5.a(androidx.core.view.al.m.c()).f1213e);
                    return r5;
                L18:
                    a.b(this.f20610b, r9.b());
                    goto L19
                L8:
                    r2 = null;
                    goto L9
                }

                @Override // androidx.core.view.WindowInsetsAnimationCompat.b
                public void b(WindowInsetsAnimationCompat r4) {
                    d.h.b.o.e(r4, "animation");
                    if (a.a(this.f20610b, r4) == true) goto L5;
                    return;
                L5:
                    boolean r0 = false;
                    a.a(this.f20610b, false);
                    a.b(this.f20610b, false);
                    a.c(this.f20610b, false);
                    a.d(this.f20610b, false);
                    androidx.core.view.al r5 = a.b(this.f20610b);
                    if (r5 != null) goto L8;
                L10:
                    if (r0 == true) goto L12;
                    ScrollView r6 = a.f(this.f20610b);
                    final c r1 = this.f20611c;
                    final a r3 = this.f20610b;
                    r6.postOnAnimation(new $$Lambda$az$c$a$a$QTjVo58xQIHEUotPNucVLmBpk4(r1, r3));
                    return;
                L12:
                    androidx.core.view.al r7 = a.b(this.f20610b);
                    if (r7 == null) goto L17;
                    a.d(this.f20610b, r7);
                    return;
                L17:
                    return;
                L8:
                    if (a.b(this.f20610b, r5) != true) goto L10;
                    r0 = true;
                    goto L10
                }

                private static final void a(c r2, a r3) {
                    if (c.d(r2) == true) goto L13;
                    androidx.core.view.al r4 = a.b(r3);
                    boolean r0 = true;
                    if (r4 != null) goto L7;
                L9:
                    r0 = false;
                L10:
                    if (r0 == true) goto L14;
                    a.k(r3);
                    a.d(r3, 0);
                    return;
                L14:
                    return;
                L7:
                    if (a.b(r3, r4) != true) goto L9;
                }
            }

            public static /* synthetic */ androidx.core.view.al lambda$CuC3XR5aihp6XDWprJ9UVfts2f4(a r0, View r1, androidx.core.view.al r2) {
                return a(r0, r1, r2);
            }

            /* JADX INFO: renamed from: lambda$Kk2JUTodIxo_JW8uMPn4_0nI-c0, reason: not valid java name */
            public static /* synthetic */ void m335lambda$Kk2JUTodIxo_JW8uMPn4_0nIc0(a r0, View r1, View r2) {
                a(r0, r1, r2);
            }

            public static /* synthetic */ void lambda$UgOsBAmrbbpfjiYLSLdxD2CakMs(a r0) {
                l(r0);
            }

            public static /* synthetic */ void lambda$Z7XoJVb1APnRXTwLDJKhQ92SISg(c r0, a r1) {
                b(r0, r1);
            }

            /* JADX INFO: renamed from: lambda$a029Mr0q-L7sbIVGkj45u-eFpdE, reason: not valid java name */
            public static /* synthetic */ void m336lambda$a029Mr0qL7sbIVGkj45ueFpdE(a r0, ValueAnimator r1) {
                b(r0, r1);
            }

            public static /* synthetic */ void lambda$rjMN5bxhTSOXySQxaJmND3tuBBc(c r0, a r1) {
                a(r0, r1);
            }

            public a(c r3, ScrollView r4, OSheetModal r5, View r6, List<b> r7) {
                List<b> r8 = (List) ZeusTransformUtils.wrapperContextForParams(r7, List.class, "com.obric.aiagent.plugin");
                d.h.b.o.e(r4, "scroll");
                d.h.b.o.e(r5, "sheet");
                d.h.b.o.e(r6, "imeScrollSpacer");
                d.h.b.o.e(r8, "fields");
                this.f20605a = r3;
                this.f20606b = r4;
                this.f20607c = r5;
                this.f20608d = r6;
                this.f20609e = r8;
                this.f = r4.getPaddingBottom();
                this.h = d.i.a.a(40 * ZeusTransformUtils.getResources((FragmentActivity) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(az.a(r3.f20600a), "com.obric.aiagent.plugin"), FragmentActivity.class, "com.obric.aiagent.plugin"), "com.obric.aiagent.plugin").getDisplayMetrics().density);
                this.v = new $$Lambda$az$c$a$Kk2JUTodIxo_JW8uMPn4_0nIc0(this);
                this.w = new C0434a(this, r3);
            }

            public static final /* synthetic */ ValueAnimator a(a r0) {
                return r0.u;
            }

            public static final /* synthetic */ void a(a r0, float r1) {
                r0.a(r1);
            }

            public static final /* synthetic */ void a(a r0, int r1) {
                r0.c(r1);
            }

            public static final /* synthetic */ void a(a r0, ValueAnimator r1) {
                r0.u = r1;
            }

            public static final /* synthetic */ void a(a r0, androidx.core.view.al r1) {
                r0.d(r1);
            }

            public static final /* synthetic */ void a(a r0, boolean r1) {
                r0.o = r1;
            }

            public static final /* synthetic */ boolean a(a r0, WindowInsetsAnimationCompat r1) {
                return r0.a(r1);
            }

            public static final /* synthetic */ androidx.core.view.al b(a r0) {
                return r0.j;
            }

            public static final /* synthetic */ void b(a r0, float r1) {
                r0.b(r1);
            }

            public static final /* synthetic */ void b(a r0, int r1) {
                r0.s = r1;
            }

            public static final /* synthetic */ void b(a r0, boolean r1) {
                r0.p = r1;
            }

            public static final /* synthetic */ boolean b(a r0, androidx.core.view.al r1) {
                return r0.c(r1);
            }

            public static final /* synthetic */ void c(a r0) {
                r0.e();
            }

            public static final /* synthetic */ void c(a r0, int r1) {
                r0.m = r1;
            }

            public static final /* synthetic */ void c(a r0, androidx.core.view.al r1) {
                r0.j = r1;
            }

            public static final /* synthetic */ void c(a r0, boolean r1) {
                r0.q = r1;
            }

            public static final /* synthetic */ void d(a r0, int r1) {
                r0.a(r1);
            }

            public static final /* synthetic */ void d(a r0, androidx.core.view.al r1) {
                r0.a(r1);
            }

            public static final /* synthetic */ void d(a r0, boolean r1) {
                r0.r = r1;
            }

            public static final /* synthetic */ boolean d(a r0) {
                return r0.k;
            }

            public static final /* synthetic */ boolean e(a r0) {
                return r0.f();
            }

            public static final /* synthetic */ ScrollView f(a r0) {
                return r0.f20606b;
            }

            public static final /* synthetic */ boolean g(a r0) {
                return r0.p;
            }

            public static final /* synthetic */ boolean h(a r0) {
                return r0.q;
            }

            public static final /* synthetic */ void i(a r0) {
                r0.c();
            }

            public static final /* synthetic */ boolean j(a r0) {
                return r0.r;
            }

            public static final /* synthetic */ void k(a r0) {
                r0.d();
            }

            private static final void a(final a r0, View r1, View r2) {
                r0.f20606b.post(new $$Lambda$az$c$a$UgOsBAmrbbpfjiYLSLdxD2CakMs(r0));
            }

            private static final void l(a r1) {
                androidx.core.view.al r0 = r1.j;
                if (r0 == null) goto L6;
                r1.a(r0);
                return;
            }

            public final void a() {
                ViewCompat.a((View) ZeusTransformUtils.preCheckCast(this.f20606b, View.class, "com.obric.aiagent.plugin"), new $$Lambda$az$c$a$CuC3XR5aihp6XDWprJ9UVfts2f4(this));
                ViewCompat.a((View) ZeusTransformUtils.preCheckCast(this.f20606b, View.class, "com.obric.aiagent.plugin"), (WindowInsetsAnimationCompat.b) ZeusTransformUtils.preCheckCast(this.w, WindowInsetsAnimationCompat.b.class, "com.obric.aiagent.plugin"));
                this.f20606b.getViewTreeObserver().addOnGlobalFocusChangeListener(this.v);
                ViewCompat.u((View) ZeusTransformUtils.preCheckCast(this.f20606b, View.class, "com.obric.aiagent.plugin"));
            }

            private static final androidx.core.view.al a(a r1, View r2, androidx.core.view.al r3) {
                d.h.b.o.e(r2, "<unused var>");
                d.h.b.o.e(r3, "insets");
                r1.j = r3;
                r1.g = bh.a(r3);
                if (r1.o == true) goto L5;
            L7:
                r1.a(r3);
                return r3;
            L5:
                if (r1.p == r1.c(r3)) goto L7;
                return r3;
            }

            public final void b() {
                e();
                ViewCompat.a((View) ZeusTransformUtils.preCheckCast(this.f20606b, View.class, "com.obric.aiagent.plugin"), null);
                ViewCompat.a((View) ZeusTransformUtils.preCheckCast(this.f20606b, View.class, "com.obric.aiagent.plugin"), null);
                if (this.f20606b.getViewTreeObserver().isAlive() == false) goto L5;
                this.f20606b.getViewTreeObserver().removeOnGlobalFocusChangeListener(this.v);
            L5:
                j();
                a(0);
                this.j = null;
                this.o = false;
                this.p = false;
                this.q = false;
                this.r = false;
            }

            private final void a(androidx.core.view.al r1) {
                b(r1);
                d(r1);
            }

            private final void b(androidx.core.view.al r6) {
                if (this.f20606b.isLaidOut() == true) goto L5;
            L65:
                ScrollView r7 = this.f20606b;
                final c r0 = this.f20605a;
                r7.post(new $$Lambda$az$c$a$rjMN5bxhTSOXySQxaJmND3tuBBc(r0, this));
                return;
            L5:
                if (this.f20606b.getHeight() == 0) goto L65;
                int r1 = r6.a(androidx.core.view.al.m.c()).f1213e;
                boolean r2 = true;
                if (c(r6) == false) goto L11;
                if (r1 <= 0) goto L11;
                boolean r8 = true;
            L12:
                if (r8 == true) goto L24;
                if (this.o == false) goto L16;
                return;
            L16:
                if (this.k == false) goto L18;
            L21:
                d();
                return;
            L18:
                if (f() == true) goto L21;
                g();
                return;
            L24:
                if (this.k == true) goto L26;
                this.k = true;
                this.l = this.f20606b.getScrollY();
                this.m = 0;
            L26:
                b r9 = h();
                if (r9 != null) goto L29;
            L63:
                e();
                j();
                this.m = r1;
                this.n = null;
                return;
            L29:
                if (c.c(this.f20605a).c() != ap.f20549a) goto L63;
                if (this.n == r9) goto L34;
                boolean r3 = true;
            L35:
                this.n = r9;
                Integer r10 = a(r9, r1);
                if (r10 == null) goto L61;
                int r11 = r10.intValue();
                if (r1 < this.m) goto L40;
                boolean r4 = true;
            L41:
                if (r3 == true) goto L45;
                if (r4 == false) goto L45;
                r11 = Math.max(this.f20606b.getScrollY(), r11);
            L45:
                if (r3 == true) goto L47;
            L51:
                r2 = false;
            L52:
                if (r2 == false) goto L55;
                b(r11);
            L59:
                this.m = r1;
                return;
            L55:
                if (this.u != null) goto L57;
            L58:
                e();
                c(r11);
                goto L59
            L57:
                if (r1 == this.m) goto L59;
            L47:
                if (this.m <= 0) goto L51;
                if (this.o == true) goto L51;
            L40:
                r4 = false;
                goto L41
            L61:
                a r5 = (a) ZeusTransformUtils.preCheckCast(this, a.class, "com.obric.aiagent.plugin");
                r5.e();
                r5.j();
                r5.m = r1;
                return;
            L34:
                r3 = false;
            L11:
                r8 = false;
                goto L12
            }

            private static final void a(c r0, a r1) {
                if (c.d(r0) == true) goto L8;
                androidx.core.view.al r2 = r1.j;
                if (r2 == null) goto L9;
                r1.b(r2);
                return;
            L9:
                return;
            }

            private final boolean a(WindowInsetsAnimationCompat r1) {
                if ((r1.a() & androidx.core.view.al.m.c()) == 0) goto L5;
                return true;
            L5:
                return false;
            }

            private final boolean c(androidx.core.view.al r1) {
                return r1.b(androidx.core.view.al.m.c());
            }

            private final void d(androidx.core.view.al r6) {
                if (this.f20606b.isLaidOut() == true) goto L5;
            L24:
                ScrollView r7 = this.f20606b;
                final c r0 = this.f20605a;
                r7.post(new $$Lambda$az$c$a$Z7XoJVb1APnRXTwLDJKhQ92SISg(r0, this));
                return;
            L5:
                if (this.f20606b.getHeight() == 0) goto L24;
                if (c(r6) == true) goto L11;
                a(0);
                return;
            L11:
                int r8 = r6.a(androidx.core.view.al.m.c()).f1213e;
                if (Build.VERSION.SDK_INT < 30) goto L14;
                int r1 = ((FragmentActivity) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(az.a(this.f20605a.f20600a), "com.obric.aiagent.plugin"), FragmentActivity.class, "com.obric.aiagent.plugin")).getWindowManager().getCurrentWindowMetrics().getBounds().height();
            L15:
                int[] r2 = new int[2];
                this.f20606b.getLocationInWindow(r2);
                int r9 = d.l.n.a((r2[1] + this.f20606b.getHeight()) - (r1 - r8), 0, this.f20606b.getHeight());
                ViewParent r3 = this.f20608d.getParent();
                if (ZeusTransformUtils.instanceOf(r3, ViewGroup.class) == false) goto L18;
                ViewGroup r4 = (ViewGroup) ZeusTransformUtils.preCheckCast(r3, ViewGroup.class, "com.obric.aiagent.plugin");
            L19:
                if (r4 == null) goto L21;
                int r5 = r4.getPaddingBottom();
            L22:
                a(d.l.n.c(((r9 - this.f20606b.getPaddingBottom()) - r5) + this.h, 0));
                return;
            L21:
                r5 = 0;
                goto L22
            L18:
                r4 = null;
                goto L19
            L14:
                r1 = ZeusTransformUtils.getResources((FragmentActivity) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(az.a(this.f20605a.f20600a), "com.obric.aiagent.plugin"), FragmentActivity.class, "com.obric.aiagent.plugin"), "com.obric.aiagent.plugin").getDisplayMetrics().heightPixels;
                goto L15
            }

            private static final void b(c r0, a r1) {
                if (c.d(r0) == true) goto L8;
                androidx.core.view.al r2 = r1.j;
                if (r2 == null) goto L9;
                r1.d(r2);
                return;
            L9:
                return;
            }

            private final void a(int r2) {
                if (this.i != r2) goto L5;
                return;
            L5:
                this.i = r2;
                View r1 = this.f20608d;
                ViewGroup.LayoutParams r0 = r1.getLayoutParams();
                r0.height = r2;
                r1.setLayoutParams(r0);
            }

            private final void c() {
                e();
                this.k = true;
                this.l = this.s;
                int r0 = 0;
                this.m = 0;
                b r1 = h();
                this.n = r1;
                androidx.core.view.al r2 = this.j;
                if (r2 == null) goto L7;
                androidx.core.graphics.g r3 = r2.a(androidx.core.view.al.m.c());
                if (r3 == null) goto L7;
                r0 = r3.f1213e;
            L7:
                if (r1 == null) goto L15;
                if (r0 <= 0) goto L15;
                if (c.c(this.f20605a).c() != ap.f20549a) goto L15;
                Integer r4 = a(r1, r0);
                if (r4 == null) goto L14;
                int r5 = r4.intValue();
            L16:
                this.t = r5;
                c(this.l);
                return;
            L14:
                r5 = this.l;
            L15:
                r5 = this.l;
                goto L16
            }

            private final void a(float r4) {
                float r5 = d.l.n.a(r4, 0.0f, 1.0f);
                int r0 = this.l;
                c(d.i.a.a(r0 + ((this.t - r0) * r5)));
            }

            private final void b(float r4) {
                float r5 = d.l.n.a(r4, 0.0f, 1.0f);
                int r0 = this.s;
                c(d.i.a.a(r0 + ((this.l - r0) * r5)));
            }

            private final void d() {
                e();
                j();
                this.k = false;
                this.m = 0;
                this.n = null;
            }

            private final void b(final int r5) {
                e();
                int r0 = this.f20606b.getScrollY();
                if (r0 != r5) goto L8;
                c(r5);
                androidx.core.view.al r6 = this.j;
                if (r6 == null) goto L10;
                d(r6);
                return;
            L10:
                return;
            L8:
                final ValueAnimator r1 = ValueAnimator.ofInt(new int[]{r0, r5});
                r1.setDuration(250);
                r1.setInterpolator((TimeInterpolator) ZeusTransformUtils.preCheckCast(az.b(), TimeInterpolator.class, "com.obric.aiagent.plugin"));
                r1.addUpdateListener(new $$Lambda$az$c$a$a029Mr0qL7sbIVGkj45ueFpdE(this));
                r1.addListener((Animator.AnimatorListener) ZeusTransformUtils.preCheckCast(new SkillFormSheetController$Session$CreateImeCoordinator$animateFieldSwitch$animator$1$2(this, r1, r5), Animator.AnimatorListener.class, "com.obric.aiagent.plugin"));
                this.u = r1;
                r1.start();
            }

            private static final void b(a r2, ValueAnimator r3) {
                d.h.b.o.e(r3, "valueAnimator");
                Object r4 = r3.getAnimatedValue();
                if (ZeusTransformUtils.instanceOf(r4, Integer.class) == false) goto L5;
                Integer r5 = (Integer) ZeusTransformUtils.preCheckCast(r4, Integer.class, "com.obric.aiagent.plugin");
            L6:
                if (r5 == null) goto L11;
                r2.c(r5.intValue());
                androidx.core.view.al r6 = r2.j;
                if (r6 == null) goto L12;
                r2.d(r6);
                return;
            L12:
                return;
            L11:
                return;
            L5:
                r5 = null;
                goto L6
            }

            private final void e() {
                ValueAnimator r0 = this.u;
                if (r0 != null) goto L5;
                return;
            L5:
                this.u = null;
                r0.cancel();
            }

            private final boolean f() {
                if (this.f20606b.getPaddingBottom() == (this.f + this.g)) goto L5;
                return true;
            L5:
                return false;
            }

            private final void g() {
                int r0 = this.f + this.g;
                if (this.f20606b.getPaddingBottom() != r0) goto L5;
                return;
            L5:
                ScrollView r1 = this.f20606b;
                r1.setPadding(r1.getPaddingLeft(), this.f20606b.getPaddingTop(), this.f20606b.getPaddingRight(), r0);
            }

            private final b h() {
                Iterator r3 = ((Iterable) ZeusTransformUtils.preCheckCast(this.f20609e, Iterable.class, "com.obric.aiagent.plugin")).iterator();
            L4:
                if (r3.hasNext() == false) goto L8;
                Object r0 = r3.next();
                if (((b) ZeusTransformUtils.preCheckCast(r0, b.class, "com.obric.aiagent.plugin")).a().hasFocus() == false) goto L4;
            L10:
                return (b) ZeusTransformUtils.preCheckCast(r0, b.class, "com.obric.aiagent.plugin");
            L8:
                r0 = null;
                goto L10
            }

            private final Integer a(b r10, int r11) {
                View r0 = r10.b();
                int[] r2 = new int[2];
                int[] r3 = new int[2];
                int[] r1 = new int[2];
                this.f20606b.getLocationInWindow(r2);
                this.f20607c.getHeaderContainer().getLocationInWindow(r3);
                r0.getLocationInWindow(r1);
                if (Build.VERSION.SDK_INT < 30) goto L5;
                int r4 = ((FragmentActivity) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(az.a(this.f20605a.f20600a), "com.obric.aiagent.plugin"), FragmentActivity.class, "com.obric.aiagent.plugin")).getWindowManager().getCurrentWindowMetrics().getBounds().height();
            L6:
                int r5 = r2[1];
                int r7 = this.f20606b.getHeight() + r5;
                int r6 = r4 - r11;
                int r12 = Math.max(r5, r3[1] + this.f20607c.getHeaderContainer().getHeight());
                int r8 = Math.min(r7, r6);
                int r9 = r8 - r12;
                if (r9 > 0) goto L10;
                return null;
            L10:
                int r13 = (r1[1] - r5) + this.f20606b.getScrollY();
                if (r0.getHeight() <= r9) goto L13;
                int r14 = r13 - (r12 - r5);
            L15:
                return Integer.valueOf(Math.max(this.l, r14));
            L13:
                r14 = d.i.a.a((r13 + (r0.getHeight() / 2.0f)) - (Math.max(r12 + (r0.getHeight() / 2.0f), ((r8 + r12) / 2.0f) - d.i.a.a(r10.c() * ZeusTransformUtils.getResources((FragmentActivity) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(az.a(this.f20605a.f20600a), "com.obric.aiagent.plugin"), FragmentActivity.class, "com.obric.aiagent.plugin"), "com.obric.aiagent.plugin").getDisplayMetrics().density)) - r5));
                goto L15
            L5:
                r4 = ZeusTransformUtils.getResources((FragmentActivity) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(az.a(this.f20605a.f20600a), "com.obric.aiagent.plugin"), FragmentActivity.class, "com.obric.aiagent.plugin"), "com.obric.aiagent.plugin").getDisplayMetrics().heightPixels;
                goto L6
            }

            private final void c(int r4) {
                int r0 = d.l.n.c(r4 - i(), 0);
                int r1 = (this.f + this.g) + r0;
                if (r1 >= this.f20606b.getPaddingBottom()) goto L5;
                f(this, r4);
                e(this, r1);
                return;
            L5:
                e(this, r1);
                f(this, r4);
            }

            private static final void e(a r3, int r4) {
                if (r3.f20606b.getPaddingBottom() != r4) goto L5;
                return;
            L5:
                ScrollView r0 = r3.f20606b;
                r0.setPadding(r0.getPaddingLeft(), r3.f20606b.getPaddingTop(), r3.f20606b.getPaddingRight(), r4);
            }

            private static final void f(a r1, int r2) {
                if (r1.f20606b.getScrollY() != r2) goto L5;
                return;
            L5:
                ScrollView r3 = r1.f20606b;
                r3.scrollTo(r3.getScrollX(), r2);
            }

            private final int i() {
                View r0 = this.f20606b.getChildAt(0);
                if (r0 != null) goto L5;
                return 0;
            L5:
                ViewGroup.LayoutParams r2 = r0.getLayoutParams();
                if (ZeusTransformUtils.instanceOf(r2, ViewGroup.MarginLayoutParams.class) == false) goto L8;
                ViewGroup.MarginLayoutParams r3 = (ViewGroup.MarginLayoutParams) ZeusTransformUtils.preCheckCast(r2, ViewGroup.MarginLayoutParams.class, "com.obric.aiagent.plugin");
            L9:
                if (r3 == null) goto L11;
                int r4 = r3.bottomMargin;
            L13:
                return d.l.n.c(((r0.getBottom() + r4) - this.f20608d.getHeight()) - ((this.f20606b.getHeight() - this.f) - this.g), 0);
            L11:
                r4 = 0;
                goto L13
            L8:
                r3 = null;
                goto L9
            }

            private final void j() {
                c(d.l.n.a(this.l, 0, i()));
            }
        }

        /* JADX INFO: compiled from: SkillFormSheetController.kt */
        public /* synthetic */ class b {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ int[] f20612a = null;

            static {
                int[] r0 = new int[aq.values().length];
                r0[aq.f20553a.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
            L9:
                r0[aq.f20554b.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
            L5:
                f20612a = r0;
            }
        }

        public static /* synthetic */ void lambda$0LTvQwwZhYij_p3gtE7jWzJzX6M(c r0, boolean r1) {
            a(r0, r1);
        }

        public static /* synthetic */ void lambda$3MCcO62BcqdBIKHWIJBLY8JyCTM(c r0, View r1) {
            a(r0, r1);
        }

        /* JADX INFO: renamed from: lambda$PSGgU5mqehGeSSxih06DY-yfr5Q, reason: not valid java name */
        public static /* synthetic */ d.x m331lambda$PSGgU5mqehGeSSxih06DYyfr5Q(az r0, c r1) {
            return a(r0, r1);
        }

        /* JADX INFO: renamed from: lambda$TQrUOS3yT5fMmCLappafP-S6vuc, reason: not valid java name */
        public static /* synthetic */ void m332lambda$TQrUOS3yT5fMmCLappafPS6vuc(d.h.a.a r0, View r1) {
            a(r0, r1);
        }

        public static /* synthetic */ void lambda$Zdc0oyO32FjZ4m6Qfbr1NiUgcnA(c r0, View r1) {
            b(r0, r1);
        }

        public static /* synthetic */ boolean lambda$fLfAMqyfpNoVw3Vx75AQZTIgn_Y(c r0, View r1, MotionEvent r2) {
            return a(r0, r1, r2);
        }

        /* JADX INFO: renamed from: lambda$hYWzLlrO2GT0X49JEh-78yoVywU, reason: not valid java name */
        public static /* synthetic */ d.x m333lambda$hYWzLlrO2GT0X49JEh78yoVywU(az r0, c r1, al r2, com.obric.aiagent.skill.manager.impl.cb r3) {
            return a(r0, r1, r2, r3);
        }

        public static /* synthetic */ void lambda$mnoVMGJtVx6jlt6AiiL_iByBP48(d.h.a.a r0, View r1) {
            b(r0, r1);
        }

        /* JADX INFO: renamed from: lambda$uiRRyHBOB8eyZ35Bv-nMkAt3-I4, reason: not valid java name */
        public static /* synthetic */ d.x m334lambda$uiRRyHBOB8eyZ35BvnMkAt3I4(c r0, as.b r1) {
            return a(r0, r1);
        }

        public c(az r9, ay r10, d r11, OSheetModal r12) {
            d.h.b.o.e(r10, "initialConfig");
            d.h.b.o.e(r11, "views");
            d.h.b.o.e(r12, "sheet");
            this.f20600a = r9;
            this.f20601b = r11;
            this.f20602c = r12;
            this.f20603d = r10;
            bb r2 = r10.c();
            this.f20604e = r2;
            this.f = new al(r2, null, r10.i(), null, 10, null);
            as r13 = r10.h();
            at r14 = null;
            if (ZeusTransformUtils.instanceOf(r13, as.b.class) == false) goto L5;
            as.b r15 = (as.b) ZeusTransformUtils.preCheckCast(r13, as.b.class, "com.obric.aiagent.plugin");
        L6:
            if (r15 == null) goto L8;
            r14 = r15.c();
        L8:
            this.h = r14;
            this.k = r10.f().a();
            this.n = new ArrayList();
            return;
        L5:
            r15 = null;
            goto L6
        }

        public static final /* synthetic */ void a(c r0) {
            r0.s();
        }

        public static final /* synthetic */ void b(c r0) {
            r0.t();
        }

        public static final /* synthetic */ al c(c r0) {
            return r0.f;
        }

        public static final /* synthetic */ boolean d(c r0) {
            return r0.j;
        }

        public final OSheetModal a() {
            return this.f20602c;
        }

        public final void b() {
            v();
            k();
            o();
            j();
        }

        private final void j() {
            if (this.f20603d.a() == ax.f20582a) goto L6;
            bh.a((View) ZeusTransformUtils.preCheckCast(this.f20601b.a(), View.class, "com.obric.aiagent.plugin"));
            return;
        L6:
            int r11 = 4;
            d.h.b.h r12 = null;
            a r6 = new a(this, this.f20601b.a(), this.f20602c, this.f20601b.m(), d.a.p.b(new b[]{new b(this.f20601b.g().getVInput(), (View) ZeusTransformUtils.preCheckCast(this.f20601b.g(), View.class, "com.obric.aiagent.plugin"), 0, r11, r12), new b(this.f20601b.i().getVInput(), (View) ZeusTransformUtils.preCheckCast(this.f20601b.i(), View.class, "com.obric.aiagent.plugin"), 80), new b(this.f20601b.j().getVInput(), (View) ZeusTransformUtils.preCheckCast(this.f20601b.j(), View.class, "com.obric.aiagent.plugin"), 0, r11, r12)}));
            r6.a();
            this.m = r6;
        }

        public final boolean a(ay r9) {
            d.h.b.o.e(r9, "nextConfig");
            as r0 = this.f20603d.h();
            as.b r3 = null;
            if (ZeusTransformUtils.instanceOf(r0, as.b.class) == false) goto L5;
            as.b r1 = (as.b) ZeusTransformUtils.preCheckCast(r0, as.b.class, "com.obric.aiagent.plugin");
        L7:
            if (r1 != null) goto L9;
            return false;
        L9:
            as r4 = r9.h();
            if (ZeusTransformUtils.instanceOf(r4, as.b.class) == false) goto L12;
            r3 = (as.b) ZeusTransformUtils.preCheckCast(r4, as.b.class, "com.obric.aiagent.plugin");
        L12:
            if (r3 != null) goto L15;
            return false;
        L15:
            if (this.j == false) goto L17;
        L27:
            return false;
        L17:
            if (this.f20603d.a() != ax.f20583b) goto L27;
            if (r9.a() != ax.f20583b) goto L27;
            if (r1.b() != av.f20576a) goto L27;
            if (r3.b() != av.f20576a) goto L27;
            this.f20603d = r9;
            this.i = false;
            this.h = r3.c();
            this.f = new al(r9.c(), null, r9.i(), null, 10, null);
            n();
            v();
            d(this.f.a());
            a(this.f.c());
            o();
            i();
            return true;
        L5:
            r1 = null;
            goto L7
        }

        private final void k() {
            az.a(this.f20600a, this.f20601b.g(), this.f20603d.d().a());
            az.a(this.f20600a, this.f20601b.i(), Integer.valueOf(this.f20603d.d().b()));
            az.a(this.f20600a, this.f20601b.j(), null);
            this.f20601b.i().setTip((CharSequence) ZeusTransformUtils.preCheckCast(((FragmentActivity) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(az.a(this.f20600a), "com.obric.aiagent.plugin"), FragmentActivity.class, "com.obric.aiagent.plugin")).getString(ZeusTransformUtils.mapRes(R.string.obric_skill_form_description_limit_tip, WsChannelMultiProcessSharedProvider.STRING_TYPE, "obric_skill_form_description_limit_tip")), CharSequence.class, "com.obric.aiagent.plugin"));
            this.f20601b.i().setLimitStateChangeListener(new $$Lambda$az$c$0LTvQwwZhYij_p3gtE7jWzJzX6M(this));
            this.f20601b.g().setHint((CharSequence) ZeusTransformUtils.preCheckCast(((FragmentActivity) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(az.a(this.f20600a), "com.obric.aiagent.plugin"), FragmentActivity.class, "com.obric.aiagent.plugin")).getString(this.f20603d.g().a()), CharSequence.class, "com.obric.aiagent.plugin"));
            this.f20601b.h().setText(this.f20603d.g().b());
            this.f20601b.i().setHint((CharSequence) ZeusTransformUtils.preCheckCast(((FragmentActivity) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(az.a(this.f20600a), "com.obric.aiagent.plugin"), FragmentActivity.class, "com.obric.aiagent.plugin")).getString(this.f20603d.g().c()), CharSequence.class, "com.obric.aiagent.plugin"));
            this.f20601b.j().setHint((CharSequence) ZeusTransformUtils.preCheckCast(((FragmentActivity) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(az.a(this.f20600a), "com.obric.aiagent.plugin"), FragmentActivity.class, "com.obric.aiagent.plugin")).getString(this.f20603d.g().d()), CharSequence.class, "com.obric.aiagent.plugin"));
            TextWatcher r0 = new SkillFormSheetController$Session$bindInputs$watcher$1(this);
            this.f20601b.g().getVInput().addTextChangedListener((TextWatcher) ZeusTransformUtils.preCheckCast(r0, TextWatcher.class, "com.obric.aiagent.plugin"));
            this.f20601b.i().getVInput().addTextChangedListener((TextWatcher) ZeusTransformUtils.preCheckCast(r0, TextWatcher.class, "com.obric.aiagent.plugin"));
            this.f20601b.j().getVInput().addTextChangedListener((TextWatcher) ZeusTransformUtils.preCheckCast(r0, TextWatcher.class, "com.obric.aiagent.plugin"));
            l();
            d(this.f.a());
            a(this.f.c());
        }

        private static final void a(c r3, boolean r4) {
            OInputLayout r0 = r3.f20601b.i();
            if (r3.f.c() != ap.f20549a) goto L6;
            if (r4 == false) goto L6;
            boolean r5 = true;
        L7:
            r0.showTip(r5);
            r3.t();
            r3.i();
            return;
        L6:
            r5 = false;
            goto L7
        }

        private final void l() {
            if (m() == true) goto L5;
            return;
        L5:
            Iterator r0 = ((Iterable) ZeusTransformUtils.preCheckCast(d.a.p.b(new OEditText[]{this.f20601b.g().getVInput(), this.f20601b.i().getVInput(), this.f20601b.j().getVInput()}), Iterable.class, "com.obric.aiagent.plugin")).iterator();
        L7:
            if (r0.hasNext() == false) goto L9;
            ((OEditText) ZeusTransformUtils.preCheckCast(r0.next(), OEditText.class, "com.obric.aiagent.plugin")).setOnTouchListener(new $$Lambda$az$c$fLfAMqyfpNoVw3Vx75AQZTIgn_Y(this));
            goto L7
        }

        private static final boolean a(c r4, View r5, MotionEvent r6) {
            int r7 = r6.getActionMasked();
            boolean r1 = true;
            if (r7 == 0) goto L16;
            if (r7 != 1) goto L6;
        L15:
            r4.n();
        L34:
            return false;
        L6:
            if (r7 == 2) goto L11;
            if (r7 == 3) goto L15;
        L11:
            if (r4.l != r5) goto L34;
            ViewParent r8 = r5.getParent();
            if (r8 == null) goto L34;
            r8.requestDisallowInterceptTouchEvent(true);
            goto L34
        L16:
            r4.n();
            if (r5 != r4.f20601b.g().getVInput()) goto L24;
            if (((OEditText) ZeusTransformUtils.preCheckCast(r5, OEditText.class, "com.obric.aiagent.plugin")).canScrollHorizontally(-1) == false) goto L21;
        L29:
            if (r1 == false) goto L31;
            r4.l = r5;
        L31:
            ViewParent r9 = r5.getParent();
            if (r9 == null) goto L34;
            r9.requestDisallowInterceptTouchEvent(r1);
            goto L34
        L21:
            if (((OEditText) ZeusTransformUtils.preCheckCast(r5, OEditText.class, "com.obric.aiagent.plugin")).canScrollHorizontally(1) == true) goto L29;
        L28:
            r1 = false;
            goto L29
        L24:
            if (r5.canScrollVertically(-1) == true) goto L29;
            if (r5.canScrollVertically(1) == false) goto L28;
            goto L28
        }

        private final boolean m() {
            if (this.f20603d.a() != ax.f20582a) goto L5;
        L10:
            return true;
        L5:
            if (this.f20603d.a() == ax.f20583b) goto L10;
            if (this.f20603d.a() == ax.f20584c) goto L10;
            return false;
        }

        private final void n() {
            View r0 = this.l;
            if (r0 == null) goto L7;
            ViewParent r1 = r0.getParent();
            if (r1 == null) goto L7;
            r1.requestDisallowInterceptTouchEvent(false);
        L7:
            this.l = null;
        }

        private final void o() {
            ViewGroup r0 = this.f20601b.k();
            r0.removeAllViews();
            r0.setVisibility(8);
            ViewGroup r1 = this.f20601b.l();
            r1.removeAllViews();
            r1.setVisibility(8);
            as r2 = this.f20603d.h();
            ViewGroup.MarginLayoutParams r3 = null;
            if (ZeusTransformUtils.instanceOf(r2, as.b.class) == false) goto L5;
            as.b r4 = (as.b) ZeusTransformUtils.preCheckCast(r2, as.b.class, "com.obric.aiagent.plugin");
        L6:
            if (r4 != null) goto L8;
            return;
        L8:
            int r5 = b.f20612a[r4.a().ordinal()];
            if (r5 != 1) goto L11;
            ViewGroup r6 = this.f20601b.k();
        L16:
            View r7 = ZeusTransformUtils.inflate(LayoutInflater.from((Context) ZeusTransformUtils.preCheckCast((FragmentActivity) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(az.a(this.f20600a), "com.obric.aiagent.plugin"), FragmentActivity.class, "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")), ZeusTransformUtils.mapRes(R.layout.item_skill_form_file, "layout", "item_skill_form_file"), r6, false, "com.obric.aiagent.plugin");
            d.h.b.o.a(r7, "null cannot be cast to non-null type com.obric.oui.lisitem.OCardListItem");
            OCardListItem r8 = (OCardListItem) ZeusTransformUtils.preCheckCast(r7, OCardListItem.class, "com.obric.aiagent.plugin");
            FrameLayout r9 = r8.getCardContainer();
            ViewGroup.LayoutParams r10 = r9.getLayoutParams();
            if (ZeusTransformUtils.instanceOf(r10, ViewGroup.MarginLayoutParams.class) == false) goto L19;
            r3 = (ViewGroup.MarginLayoutParams) ZeusTransformUtils.preCheckCast(r10, ViewGroup.MarginLayoutParams.class, "com.obric.aiagent.plugin");
        L19:
            if (r3 == null) goto L21;
            r3.setMarginStart(0);
            r3.setMarginEnd(0);
            r9.setLayoutParams((ViewGroup.LayoutParams) ZeusTransformUtils.preCheckCast(r3, ViewGroup.LayoutParams.class, "com.obric.aiagent.plugin"));
        L21:
            r6.addView((View) ZeusTransformUtils.preCheckCast(r8, View.class, "com.obric.aiagent.plugin"));
            r6.setVisibility(0);
            this.g = r8;
            p();
            return;
        L11:
            if (r5 != 2) goto L14;
            r6 = this.f20601b.l();
            goto L16
        L14:
            throw new d.k();
        L5:
            r4 = null;
            goto L6
        }

        public final void a(at r2) {
            d.h.b.o.e(r2, "state");
            this.h = r2;
            p();
            i();
        }

        public final void b(at r4) {
            d.h.b.o.e(r4, "state");
            as r0 = this.f20603d.h();
            if (ZeusTransformUtils.instanceOf(r0, as.b.class) == false) goto L5;
            as.b r1 = (as.b) ZeusTransformUtils.preCheckCast(r0, as.b.class, "com.obric.aiagent.plugin");
        L6:
            if (r1 != null) goto L9;
            return;
        L9:
            if (this.f20603d.a() == ax.f20583b) goto L11;
            return;
        L11:
            if (r1.b() != av.f20576a) goto L16;
            a(r4);
            return;
        L16:
            return;
        L5:
            r1 = null;
            goto L6
        }

        private final void p() {
            as r0 = this.f20603d.h();
            d.h.a.a<d.x> r2 = null;
            if (ZeusTransformUtils.instanceOf(r0, as.b.class) == false) goto L5;
            final as.b r1 = (as.b) ZeusTransformUtils.preCheckCast(r0, as.b.class, "com.obric.aiagent.plugin");
        L6:
            if (r1 != null) goto L8;
            return;
        L8:
            at r3 = this.h;
            if (r3 != null) goto L11;
            r3 = r1.c();
        L11:
            as.b r4 = as.b.a(r1, null, null, r3, null, null, 27, null);
            a(r4);
            OCardListItem r5 = this.g;
            if (r5 == null) goto L18;
            d.h.a.a<d.x> r6 = r1.d();
            if (r1.e() == null) goto L16;
            r2 = new $$Lambda$az$c$uiRRyHBOB8eyZ35BvnMkAt3I4(this, r1);
        L16:
            a(r5, r4, r6, r2);
            return;
        L18:
            return;
        L5:
            r1 = null;
            goto L6
        }

        private static final d.x a(c r0, as.b r1) {
            r0.b(r1);
            return d.x.f38692a;
        }

        private final void a(OCardListItem r17, as.b r18, d.h.a.a<d.x> r19, d.h.a.a<d.x> r20) {
            final d.h.a.a r2 = (d.h.a.a) ZeusTransformUtils.wrapperContextForParams(r19, d.h.a.a.class, "com.obric.aiagent.plugin");
            final d.h.a.a r4 = (d.h.a.a) ZeusTransformUtils.wrapperContextForParams(r20, d.h.a.a.class, "com.obric.aiagent.plugin");
            ar r5 = au.a(r18);
            Integer r6 = r5.b();
            if (r6 == null) goto L7;
            String r7 = ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r17.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")).getString(((Number) ZeusTransformUtils.preCheckCast(r6, Number.class, "com.obric.aiagent.plugin")).intValue());
            if (r7 == null) goto L7;
        L8:
            Integer r8 = r5.l();
            if (r8 == null) goto L13;
            int r9 = ((Number) ZeusTransformUtils.preCheckCast(r8, Number.class, "com.obric.aiagent.plugin")).intValue();
            Context r10 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r17.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
            Object[] r11 = ((Collection) ZeusTransformUtils.preCheckCast(r5.m(), Collection.class, "com.obric.aiagent.plugin")).toArray(new Object[0]);
            String r12 = r10.getString(r9, Arrays.copyOf(r11, r11.length));
            if (r12 == null) goto L13;
        L14:
            Integer r13 = r5.f();
            if (r13 == null) goto L19;
            String r14 = ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r17.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")).getString(((Number) ZeusTransformUtils.preCheckCast(r13, Number.class, "com.obric.aiagent.plugin")).intValue());
            if (r14 == null) goto L19;
        L20:
            az r15 = this.f20600a;
            if (ZeusTransformUtils.instanceOf(r18.c(), at.c.class) == false) goto L23;
            int r16 = ZeusTransformUtils.mapRes(R.color.oui_basic_text_3, "color", "oui_basic_text_3");
        L24:
            int r110 = az.a(r15, r16);
            az r111 = this.f20600a;
            if (r5.d() == false) goto L27;
            int r112 = ZeusTransformUtils.mapRes(R.color.oui_functional_red_6, "color", "oui_functional_red_6");
        L28:
            int r113 = az.a(r111, r112);
            az r0 = this.f20600a;
            if (ZeusTransformUtils.instanceOf(r18.c(), at.c.class) == false) goto L31;
            int r114 = ZeusTransformUtils.mapRes(R.color.oui_basic_text_4, "color", "oui_basic_text_4");
        L32:
            int r1 = az.a(r0, r114);
            r17.setTitle((CharSequence) ZeusTransformUtils.preCheckCast(r7, CharSequence.class, "com.obric.aiagent.plugin"));
            r17.showTitle(true);
            r17.setSubTitle((CharSequence) ZeusTransformUtils.preCheckCast(r12, CharSequence.class, "com.obric.aiagent.plugin"));
            if (((CharSequence) ZeusTransformUtils.preCheckCast(r12, CharSequence.class, "com.obric.aiagent.plugin")).length() <= 0) goto L35;
            boolean r21 = true;
        L36:
            r17.showSubTitle(r21);
            r17.setTitleColor(r110, r113);
            View.OnClickListener r115 = null;
            if (r5.i() == false) goto L43;
            OCardListItem.setEndDetailText$default(r17, (CharSequence) ZeusTransformUtils.preCheckCast(r14, CharSequence.class, "com.obric.aiagent.plugin"), 0, 2, null);
            OTextView r3 = r17.getEndDetail();
            if (r3 == null) goto L41;
            r3.setTextColor(r1);
        L41:
            r17.showCustomEnd(true);
        L56:
            if (r5.j() == false) goto L58;
            r17.setDefaultTailIcon(1);
            r17.getTailIconView().setImageTintList(ColorStateList.valueOf(r1));
        L58:
            r17.showTailIcon(r5.j());
            if (r5.h() == false) goto L61;
            r115 = new $$Lambda$az$c$mnoVMGJtVx6jlt6AiiL_iByBP48(r2);
        L61:
            r17.setOnContentClickListener(r115);
            r17.setEnabled(r5.g());
            return;
        L43:
            if (r5.k() == false) goto L54;
            r17.setCustomEndView(ZeusTransformUtils.mapRes(R.layout.item_skill_form_file_delete, "layout", "item_skill_form_file_delete"));
            View r22 = r17.getCustomEndView();
            if (r22 != null) goto L47;
        L53:
            r17.showCustomEnd(true);
            goto L56
        L47:
            if (ZeusTransformUtils.instanceOf(r22, com.obric.oui.common.style.a.class) == false) goto L49;
            com.obric.oui.common.style.a r23 = (com.obric.oui.common.style.a) ZeusTransformUtils.preCheckCast(r22, com.obric.oui.common.style.a.class, "com.obric.aiagent.plugin");
        L50:
            if (r23 == null) goto L52;
            r23.setChangeAlphaWhenPress(false);
        L52:
            r22.setOnClickListener(new $$Lambda$az$c$TQrUOS3yT5fMmCLappafPS6vuc(r4));
            goto L53
        L49:
            r23 = null;
            goto L50
        L54:
            r17.setCustomEndView(null);
            r17.showCustomEnd(false);
            goto L56
        L35:
            r21 = false;
            goto L36
        L31:
            r114 = ZeusTransformUtils.mapRes(R.color.oui_basic_text_3, "color", "oui_basic_text_3");
            goto L32
        L27:
            r112 = ZeusTransformUtils.mapRes(R.color.oui_basic_text_3, "color", "oui_basic_text_3");
            goto L28
        L23:
            r16 = ZeusTransformUtils.mapRes(R.color.oui_basic_text_1, "color", "oui_basic_text_1");
        L19:
            r14 = r5.e();
        L13:
            r12 = r5.c();
        L7:
            r7 = r5.a();
            goto L8
        }

        private static final void a(d.h.a.a r1, View r2) {
            d.h.a.a r3 = (d.h.a.a) ZeusTransformUtils.wrapperContextForParams(r1, d.h.a.a.class, "com.obric.aiagent.plugin");
            if (r3 == null) goto L6;
            r3.invoke();
            return;
        }

        private static final void b(d.h.a.a r1, View r2) {
            ((d.h.a.a) ZeusTransformUtils.wrapperContextForParams(r1, d.h.a.a.class, "com.obric.aiagent.plugin")).invoke();
        }

        private final void a(as.b r5) {
            int r0 = b.f20612a[r5.a().ordinal()];
            if (r0 != 1) goto L5;
            ViewGroup r1 = this.f20601b.k();
        L10:
            int r3 = 16;
            if (r5.a() != aq.f20553a) goto L14;
        L17:
            ViewGroup.LayoutParams r6 = r1.getLayoutParams();
            if (ZeusTransformUtils.instanceOf(r6, ViewGroup.MarginLayoutParams.class) == false) goto L20;
            ViewGroup.MarginLayoutParams r7 = (ViewGroup.MarginLayoutParams) ZeusTransformUtils.preCheckCast(r6, ViewGroup.MarginLayoutParams.class, "com.obric.aiagent.plugin");
        L21:
            if (r7 != null) goto L23;
            return;
        L23:
            int r4 = d.i.a.a(r3 * ZeusTransformUtils.getResources((FragmentActivity) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(az.a(this.f20600a), "com.obric.aiagent.plugin"), FragmentActivity.class, "com.obric.aiagent.plugin"), "com.obric.aiagent.plugin").getDisplayMetrics().density);
            if (r7.topMargin != r4) goto L26;
            return;
        L26:
            r7.topMargin = r4;
            r1.setLayoutParams((ViewGroup.LayoutParams) ZeusTransformUtils.preCheckCast(r7, ViewGroup.LayoutParams.class, "com.obric.aiagent.plugin"));
            return;
        L20:
            r7 = null;
            goto L21
        L14:
            if (ZeusTransformUtils.instanceOf(r5.c(), at.b.class) == true) goto L17;
            r3 = 12;
            goto L17
        L5:
            if (r0 != 2) goto L8;
            r1 = this.f20601b.l();
            goto L10
        L8:
            throw new d.k();
        }

        private final void b(as.b r3) {
            at r0 = this.h;
            if (r0 != null) goto L5;
            r0 = r3.c();
        L5:
            d.h.a.a<d.x> r1 = r3.e();
            if (r1 == null) goto L17;
            r1.invoke();
            if (az.b(this.f20600a) == this) goto L10;
            return;
        L10:
            if (r3.b() == av.f20577b) goto L13;
            return;
        L13:
            if (ZeusTransformUtils.instanceOf(r0, at.d.class) == false) goto L15;
            a(this.f.d());
        L15:
            this.h = (at) ZeusTransformUtils.preCheckCast(at.b.f20570a, at.class, "com.obric.aiagent.plugin");
            p();
            return;
        }

        public final void a(String r2) {
            d.h.b.o.e(r2, "url");
            this.k = r2;
            v();
        }

        public final boolean a(final com.obric.aiagent.skill.manager.impl.cb r6, d.h.a.b<? super Throwable, d.x> r7) {
            d.h.a.b r8 = (d.h.a.b) ZeusTransformUtils.wrapperContextForParams(r7, d.h.a.b.class, "com.obric.aiagent.plugin");
            d.h.b.o.e(r6, "draft");
            d.h.b.o.e(r8, "onFailure");
            as r0 = this.f20603d.h();
            if (ZeusTransformUtils.instanceOf(r0, as.b.class) == false) goto L5;
            as.b r1 = (as.b) ZeusTransformUtils.preCheckCast(r0, as.b.class, "com.obric.aiagent.plugin");
        L7:
            if (r1 != null) goto L10;
            return false;
        L10:
            if (r1.b() == av.f20577b) goto L12;
            return false;
        L12:
            al r2 = this.f.a(r());
            bg<al> r3 = r2.a(r6, this.f20603d.d());
            if (ZeusTransformUtils.instanceOf(r3, bg.a.class) == false) goto L16;
            be r4 = new be(((bg.a) ZeusTransformUtils.preCheckCast(r3, bg.a.class, "com.obric.aiagent.plugin")).a(), this.f20603d.d());
            a((at) ZeusTransformUtils.preCheckCast(new at.a(r6.a(), r4.a()), at.class, "com.obric.aiagent.plugin"));
            r8.invoke(r4);
            return true;
        L16:
            d.h.b.o.a(r3, "null cannot be cast to non-null type com.obric.aiagent.skill.manager.impl.ui.SkillFormValidationResult.Valid<com.obric.aiagent.skill.manager.impl.ui.SkillFormContentState>");
            final al r9 = (al) ZeusTransformUtils.preCheckCast(((bg.b) ZeusTransformUtils.preCheckCast(r3, bg.b.class, "com.obric.aiagent.plugin")).a(), al.class, "com.obric.aiagent.plugin");
            final az r5 = this.f20600a;
            d.h.a.a r10 = new $$Lambda$az$c$hYWzLlrO2GT0X49JEh78yoVywU(r5, this, r9, r6);
            if (r2.a().a(r2.b()) == false) goto L19;
            final az r11 = this.f20600a;
            az.a(r11, r10, new $$Lambda$az$c$PSGgU5mqehGeSSxih06DYyfr5Q(r11, this));
        L20:
            return true;
        L19:
            r10.invoke();
            goto L20
        L5:
            r1 = null;
            goto L7
        }

        private static final d.x a(az r0, c r1, al r2, com.obric.aiagent.skill.manager.impl.cb r3) {
            if (az.b(r0) != r1) goto L6;
            r1.a(r2);
            r1.a((at) ZeusTransformUtils.preCheckCast(new at.d(r3.a()), at.class, "com.obric.aiagent.plugin"));
        L6:
            return d.x.f38692a;
        }

        private static final d.x a(az r2, c r3) {
            if (az.b(r2) != r3) goto L6;
            r3.a((at) ZeusTransformUtils.preCheckCast(at.b.f20570a, at.class, "com.obric.aiagent.plugin"));
        L6:
            return d.x.f38692a;
        }

        public final void c() {
            d.h.a.q<bb, String, bc, d.x> r0 = this.f20603d.m();
            if (r0 != null) goto L6;
            return;
        L6:
            if (this.i == false) goto L8;
            return;
        L8:
            if (q() == false) goto L26;
            bb r1 = r();
            if (b(r1) == false) goto L15;
            cm.f20758a.a((Activity) ZeusTransformUtils.preCheckCast((FragmentActivity) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(az.a(this.f20600a), "com.obric.aiagent.plugin"), FragmentActivity.class, "com.obric.aiagent.plugin"), Activity.class, "com.obric.aiagent.plugin"), cm.a.f20763d);
            return;
        L15:
            if (a(r1) == true) goto L17;
            return;
        L17:
            this.i = true;
            i();
            r0.invoke(c(r1), this.k, this);     // Catch: Throwable -> L20
            return;
        L20:
            th = move-exception;
            f();
            throw th;
        }

        @Override // com.obric.aiagent.skill.manager.impl.ui.bc
        public void d() {
            if (az.b(this.f20600a) != this) goto L6;
            this.f20602c.dismiss();
            return;
        }

        public final void e() {
            if (az.b(this.f20600a) == this) goto L5;
            return;
        L5:
            this.f20603d.k().invoke();
            this.f20602c.dismiss();
        }

        @Override // com.obric.aiagent.skill.manager.impl.ui.bc
        public void f() {
            if (az.b(this.f20600a) == this) goto L5;
            return;
        L5:
            this.i = false;
            i();
        }

        @Override // com.obric.aiagent.skill.manager.impl.ui.bc
        public void a(d.h.a.a<d.x> r3) {
            d.h.a.a r4 = (d.h.a.a) ZeusTransformUtils.wrapperContextForParams(r3, d.h.a.a.class, "com.obric.aiagent.plugin");
            d.h.b.o.e(r4, "action");
            if (this.j == false) goto L5;
            r4.invoke();
            return;
        L5:
            ((Collection) ZeusTransformUtils.preCheckCast(this.n, Collection.class, "com.obric.aiagent.plugin")).add(r4);
        }

        public final void g() {
            if (this.j == false) goto L5;
            return;
        L5:
            this.j = true;
            n();
            a r0 = this.m;
            if (r0 == null) goto L8;
            r0.b();
        L8:
            this.m = null;
            if (az.b(this.f20600a) != this) goto L11;
            az.a(this.f20600a, null);
            az.c(this.f20600a);
            az.d(this.f20600a).b();
        L11:
            this.f20603d.l().invoke();
            List r1 = d.a.p.o((Iterable) ZeusTransformUtils.preCheckCast(this.n, Iterable.class, "com.obric.aiagent.plugin"));
            this.n.clear();
            Iterator r3 = ((Iterable) ZeusTransformUtils.preCheckCast(r1, Iterable.class, "com.obric.aiagent.plugin")).iterator();
        L13:
            if (r3.hasNext() == false) goto L15;
            ((d.h.a.a) ZeusTransformUtils.preCheckCast(r3.next(), d.h.a.a.class, "com.obric.aiagent.plugin")).invoke();
            goto L13
        }

        public final void h() {
            this.n.clear();
            g();
        }

        public final void i() {
            View r0 = this.f20602c.getViewById(ZeusTransformUtils.mapRes(R.id.btn_end_action, DbHelper.COL_ID, "btn_end_action"));
            bb r1 = r();
            if (this.i == false) goto L5;
        L13:
            boolean r4 = false;
        L14:
            if (r0 == null) goto L19;
            r0.setEnabled(r4);
            r0.setClickable(r4);
            r0.setFocusable(r4);
            if (r4 == true) goto L20;
            r0.setPressed(false);
            return;
        L20:
            return;
        L19:
            return;
        L5:
            if (this.f20603d.m() == null) goto L13;
            if (q() == false) goto L13;
            if (a(r1) == false) goto L11;
        L12:
            r4 = true;
            goto L14
        L11:
            if (b(r1) == false) goto L13;
            goto L12
        }

        private final boolean a(bb r2) {
            if (this.f20603d.j() == true) goto L5;
        L8:
            return true;
        L5:
            if (r2.b(this.f20603d.d()) == true) goto L8;
            return false;
        }

        private final boolean q() {
            as r0 = this.f20603d.h();
            if (ZeusTransformUtils.instanceOf(r0, as.b.class) == false) goto L5;
            as.b r1 = (as.b) ZeusTransformUtils.preCheckCast(r0, as.b.class, "com.obric.aiagent.plugin");
        L7:
            if (r1 != null) goto L10;
            return true;
        L10:
            if (r1.b() == av.f20576a) goto L12;
            return true;
        L12:
            if (ZeusTransformUtils.instanceOf(this.h, at.d.class) == true) goto L17;
            return false;
        L17:
            return true;
        L5:
            r1 = null;
            goto L7
        }

        private final boolean b(bb r5) {
            if (this.f20603d.j() == true) goto L5;
        L11:
            boolean r0 = false;
        L12:
            if (r0 == false) goto L19;
            if (r5.e() == false) goto L19;
            if (r5.a(this.f20603d.d()) == false) goto L19;
            return true;
        L19:
            return false;
        L5:
            if (this.f.c() != ap.f20549a) goto L11;
            if (this.f20603d.a() != ax.f20582a) goto L9;
        L10:
            r0 = true;
            goto L12
        L9:
            if (this.f20603d.a() != ax.f20584c) goto L11;
            goto L10
        }

        private final bb c(bb r2) {
            if (this.f.c() == ap.f20549a) goto L5;
            return r2;
        L5:
            return r2.d();
        }

        private final bb r() {
            return new bb(az.a(this.f20600a, this.f20601b.g()), az.a(this.f20600a, this.f20601b.i()), az.a(this.f20600a, this.f20601b.j()));
        }

        private final void d(bb r5) {
            this.f20601b.g().setText((CharSequence) ZeusTransformUtils.preCheckCast(r5.a(), CharSequence.class, "com.obric.aiagent.plugin"));
            this.f20601b.i().setText((CharSequence) ZeusTransformUtils.preCheckCast(r5.b(), CharSequence.class, "com.obric.aiagent.plugin"));
            this.f20601b.j().setText((CharSequence) ZeusTransformUtils.preCheckCast(r5.c(), CharSequence.class, "com.obric.aiagent.plugin"));
        }

        private final void a(al r2) {
            this.f = r2;
            d(r2.a());
            a(r2.c());
            i();
        }

        private final void a(ap r11) {
            boolean r1 = true;
            if (r11 != ap.f20549a) goto L5;
            boolean r12 = true;
        L6:
            az r0 = this.f20600a;
            if (r12 == false) goto L9;
            int r4 = R.color.oui_basic_text_1;
            String r5 = "oui_basic_text_1";
        L10:
            int r2 = az.a(r0, ZeusTransformUtils.mapRes(r4, "color", r5));
            Iterator r3 = ((Iterable) ZeusTransformUtils.preCheckCast(d.a.p.b(new OInputLayout[]{this.f20601b.g(), this.f20601b.i(), this.f20601b.j()}), Iterable.class, "com.obric.aiagent.plugin")).iterator();
        L12:
            if (r3.hasNext() == false) goto L22;
            OInputLayout r6 = (OInputLayout) ZeusTransformUtils.preCheckCast(r3.next(), OInputLayout.class, "com.obric.aiagent.plugin");
            boolean r7 = m();
            r6.setEnabled(true);
            r6.setFocusable(r12);
            r6.setFocusableInTouchMode(r12);
            View r8 = r6.findViewById(ZeusTransformUtils.mapRes(R.id.input_container, DbHelper.COL_ID, "input_container"));
            r8.setEnabled(true);
            r8.setClickable(r12);
            r6.getVInput().setEnabled(true);
            r6.getVInput().setFocusable(r12);
            r6.getVInput().setFocusableInTouchMode(r12);
            OEditText r9 = r6.getVInput();
            if (r12 == true) goto L18;
            if (r7 == true) goto L18;
            boolean r10 = false;
        L19:
            r9.setClickable(r10);
            r6.getVInput().setLongClickable(r12);
            r6.getVInput().setCursorVisible(r12);
            r6.getVInput().setTextColor(r2);
            if (r12 == true) goto L12;
            r6.getVInput().clearFocus();
        L18:
            r10 = true;
            goto L19
        L22:
            this.f20601b.g().showClear(r12);
            this.f20601b.g().showLimit(r12);
            s();
            if (az.a(this.f20600a, this.f20601b.i()).length() <= this.f20603d.d().b()) goto L25;
            boolean r13 = true;
        L26:
            this.f20601b.i().showLimit(r12);
            this.f20601b.i().setAutoChangeWithLimit(r12);
            OInputLayout r14 = this.f20601b.i();
            if (r12 == false) goto L30;
            if (r13 == false) goto L30;
        L31:
            r14.showTip(r1);
            t();
            this.f20601b.j().showLimit(false);
            this.f20601b.j().showTip(false);
            this.f20601b.j().setAutoChangeWithLimit(false);
            if (r12 == true) goto L34;
            a(this.f20601b.i(), this.f20603d.e().a());
            a(this.f20601b.j(), this.f20603d.e().b());
        L34:
            if (r12 == true) goto L42;
            u();
            return;
        L42:
            return;
        L30:
            r1 = false;
            goto L31
        L25:
            r13 = false;
            goto L26
        L9:
            r4 = R.color.oui_basic_text_3;
            r5 = "oui_basic_text_3";
            goto L10
        L5:
            r12 = false;
            goto L6
        }

        private final void a(OInputLayout r9, Integer r10) {
            if (this.f20603d.a() == ax.f20583b) goto L5;
        L8:
            boolean r0 = false;
        L9:
            r9.showLimit(false);
            r9.setAutoChangeWithLimit(false);
            if (r0 == false) goto L12;
            r9.setTip((CharSequence) ZeusTransformUtils.preCheckCast(((FragmentActivity) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(az.a(this.f20600a), "com.obric.aiagent.plugin"), FragmentActivity.class, "com.obric.aiagent.plugin")).getString(ZeusTransformUtils.mapRes(R.string.obric_skill_form_import_preview_limit_tip, WsChannelMultiProcessSharedProvider.STRING_TYPE, "obric_skill_form_import_preview_limit_tip"), new Object[]{r10}), CharSequence.class, "com.obric.aiagent.plugin"));
        L12:
            r9.showTip(r0);
            if (r0 == false) goto L15;
            ((TextView) ZeusTransformUtils.preCheckCast(r9.findViewById(ZeusTransformUtils.mapRes(R.id.tip, DbHelper.COL_ID, "tip")), TextView.class, "com.obric.aiagent.plugin")).setTextColor(az.a(this.f20600a, ZeusTransformUtils.mapRes(R.color.oui_basic_text_3, "color", "oui_basic_text_3")));
        L15:
            a(r9, r0);
            b(r9, r0);
            return;
        L5:
            if (this.f.c() != ap.f20550b) goto L8;
            if (r10 == null) goto L8;
            r0 = true;
            goto L9
        }

        private final void a(OInputLayout r8, boolean r9) {
            TextView r10 = (TextView) ZeusTransformUtils.preCheckCast(r8.findViewById(ZeusTransformUtils.mapRes(R.id.tip, DbHelper.COL_ID, "tip")), TextView.class, "com.obric.aiagent.plugin");
            ViewGroup.LayoutParams r0 = r10.getLayoutParams();
            if (ZeusTransformUtils.instanceOf(r0, FrameLayout.LayoutParams.class) == false) goto L5;
            FrameLayout.LayoutParams r1 = (FrameLayout.LayoutParams) ZeusTransformUtils.preCheckCast(r0, FrameLayout.LayoutParams.class, "com.obric.aiagent.plugin");
        L6:
            if (r1 != null) goto L8;
            return;
        L8:
            if (r9 == false) goto L10;
            int r2 = -1;
        L11:
            r1.width = r2;
            int r3 = 17;
            if (r9 == false) goto L14;
            int r4 = 17;
        L15:
            r1.gravity = r4;
            int r5 = 4;
            if (r9 == false) goto L18;
            int r7 = d.i.a.a(4 * ZeusTransformUtils.getResources((FragmentActivity) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(az.a(this.f20600a), "com.obric.aiagent.plugin"), FragmentActivity.class, "com.obric.aiagent.plugin"), "com.obric.aiagent.plugin").getDisplayMetrics().density);
        L19:
            r1.setMarginEnd(r7);
            r10.setLayoutParams((ViewGroup.LayoutParams) ZeusTransformUtils.preCheckCast(r1, ViewGroup.LayoutParams.class, "com.obric.aiagent.plugin"));
            if (r9 == true) goto L23;
            r3 = 8388611;
        L23:
            r10.setGravity(r3);
            if (r9 == true) goto L27;
            r5 = 1;
        L27:
            r10.setTextAlignment(r5);
            return;
        L18:
            r7 = 0;
            goto L19
        L14:
            r4 = 8388611;
            goto L15
        L10:
            r2 = -2;
            goto L11
        L5:
            r1 = null;
            goto L6
        }

        private final void b(OInputLayout r6, boolean r7) {
            r6.setType(1);
            if (r7 == false) goto L5;
            int r0 = 86;
        L6:
            if (r7 == false) goto L8;
            int r8 = 206;
        L9:
            r6.getVInput().setMinimumHeight(d.i.a.a(r0 * ZeusTransformUtils.getResources((FragmentActivity) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(az.a(this.f20600a), "com.obric.aiagent.plugin"), FragmentActivity.class, "com.obric.aiagent.plugin"), "com.obric.aiagent.plugin").getDisplayMetrics().density));
            r6.getVInput().setMaxHeight(d.i.a.a(r8 * ZeusTransformUtils.getResources((FragmentActivity) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(az.a(this.f20600a), "com.obric.aiagent.plugin"), FragmentActivity.class, "com.obric.aiagent.plugin"), "com.obric.aiagent.plugin").getDisplayMetrics().density));
            return;
        L8:
            r8 = 224;
            goto L9
        L5:
            r0 = 104;
            goto L6
        }

        private final void s() {
            TextView r0 = (TextView) ZeusTransformUtils.preCheckCast(this.f20601b.g().findViewById(ZeusTransformUtils.mapRes(R.id.limit_single, DbHelper.COL_ID, "limit_single")), TextView.class, "com.obric.aiagent.plugin");
            if (r0 != null) goto L6;
            return;
        L6:
            if (this.f.c() == ap.f20549a) goto L8;
        L10:
            boolean r1 = false;
        L11:
            az r4 = this.f20600a;
            if (r1 == false) goto L14;
            int r2 = ZeusTransformUtils.mapRes(R.color.oui_functional_red_6, "color", "oui_functional_red_6");
        L15:
            r0.setTextColor(az.a(r4, r2));
            return;
        L14:
            r2 = ZeusTransformUtils.mapRes(R.color.oui_basic_text_4, "color", "oui_basic_text_4");
            goto L15
        L8:
            if (az.a(this.f20600a, this.f20601b.g()).length() <= this.f20603d.d().a()) goto L10;
            r1 = true;
            goto L11
        }

        private final void t() {
            TextView r0 = (TextView) ZeusTransformUtils.preCheckCast(this.f20601b.i().findViewById(ZeusTransformUtils.mapRes(R.id.limit_multi, DbHelper.COL_ID, "limit_multi")), TextView.class, "com.obric.aiagent.plugin");
            if (r0 != null) goto L6;
            return;
        L6:
            if (this.f.c() == ap.f20549a) goto L8;
        L10:
            boolean r1 = false;
        L11:
            az r4 = this.f20600a;
            if (r1 == false) goto L14;
            int r2 = ZeusTransformUtils.mapRes(R.color.oui_functional_red_6, "color", "oui_functional_red_6");
        L15:
            r0.setTextColor(az.a(r4, r2));
            return;
        L14:
            r2 = ZeusTransformUtils.mapRes(R.color.oui_basic_text_4, "color", "oui_basic_text_4");
            goto L15
        L8:
            if (az.a(this.f20600a, this.f20601b.i()).length() <= this.f20603d.d().b()) goto L10;
            r1 = true;
            goto L11
        }

        private final void u() {
            Object r0 = ((FragmentActivity) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(az.a(this.f20600a), "com.obric.aiagent.plugin"), FragmentActivity.class, "com.obric.aiagent.plugin")).getSystemService("input_method");
            if (ZeusTransformUtils.instanceOf(r0, InputMethodManager.class) == false) goto L5;
            InputMethodManager r1 = (InputMethodManager) ZeusTransformUtils.preCheckCast(r0, InputMethodManager.class, "com.obric.aiagent.plugin");
        L6:
            if (r1 == null) goto L9;
            r1.hideSoftInputFromWindow(((FragmentActivity) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(az.a(this.f20600a), "com.obric.aiagent.plugin"), FragmentActivity.class, "com.obric.aiagent.plugin")).getWindow().getDecorView().getWindowToken(), 0);
            return;
        L9:
            return;
        L5:
            r1 = null;
            goto L6
        }

        private final void v() {
            an r0 = au.a(this.k, this.f20603d.f().b());
            SimpleDraweeView r1 = this.f20601b.c();
            int r3 = 8;
            boolean r4 = false;
            if (r0.a() == false) goto L5;
            int r2 = 8;
        L6:
            r1.setVisibility(r2);
            View r5 = this.f20601b.d();
            if (r0.a() == false) goto L9;
            int r6 = 0;
        L10:
            r5.setVisibility(r6);
            View r7 = this.f20601b.e();
            if (r0.b() == false) goto L13;
            int r8 = 0;
        L14:
            r7.setVisibility(r8);
            View r9 = this.f20601b.f();
            if (r0.c() == false) goto L17;
            r3 = 0;
        L17:
            r9.setVisibility(r3);
            if (r0.a() == true) goto L20;
            s.a(s.f20812a, this.f20601b.c(), this.k, 20.0f, false, null, 24, null);
        L20:
            View.OnClickListener r10 = null;
            if (this.f20603d.f().b() == true) goto L23;
        L25:
            View.OnClickListener r11 = null;
        L26:
            this.f20601b.b().setOnClickListener(r11);
            View r12 = this.f20601b.b();
            if (r11 == null) goto L29;
            boolean r13 = true;
        L30:
            r12.setClickable(r13);
            View r14 = this.f20601b.b();
            if (r11 == null) goto L33;
            boolean r15 = true;
        L34:
            r14.setFocusable(r15);
            View r16 = this.f20601b.b();
            if (r0.a() == true) goto L37;
        L39:
            CharSequence r17 = null;
        L40:
            r16.setContentDescription(r17);
            this.f20601b.e().setOnClickListener(r11);
            View r18 = this.f20601b.e();
            if (r11 == null) goto L43;
            boolean r19 = true;
        L44:
            r18.setClickable(r19);
            View r20 = this.f20601b.e();
            if (r11 == null) goto L47;
            boolean r21 = true;
        L48:
            r20.setFocusable(r21);
            this.f20601b.e().setContentDescription((CharSequence) ZeusTransformUtils.preCheckCast(((FragmentActivity) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(az.a(this.f20600a), "com.obric.aiagent.plugin"), FragmentActivity.class, "com.obric.aiagent.plugin")).getString(ZeusTransformUtils.mapRes(R.string.obric_skill_form_select_icon_description, WsChannelMultiProcessSharedProvider.STRING_TYPE, "obric_skill_form_select_icon_description")), CharSequence.class, "com.obric.aiagent.plugin"));
            if (this.f20603d.f().b() == true) goto L51;
        L53:
            this.f20601b.f().setOnClickListener(r10);
            View r22 = this.f20601b.f();
            if (r10 == null) goto L56;
            boolean r23 = true;
        L57:
            r22.setClickable(r23);
            View r24 = this.f20601b.f();
            if (r10 == null) goto L60;
            r4 = true;
        L60:
            r24.setFocusable(r4);
            this.f20601b.f().setContentDescription((CharSequence) ZeusTransformUtils.preCheckCast(((FragmentActivity) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(az.a(this.f20600a), "com.obric.aiagent.plugin"), FragmentActivity.class, "com.obric.aiagent.plugin")).getString(ZeusTransformUtils.mapRes(R.string.obric_skill_form_change_icon_description, WsChannelMultiProcessSharedProvider.STRING_TYPE, "obric_skill_form_change_icon_description")), CharSequence.class, "com.obric.aiagent.plugin"));
            return;
        L56:
            r23 = false;
            goto L57
        L51:
            if ((!d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast(this.k, CharSequence.class, "com.obric.aiagent.plugin"))) == false) goto L53;
            r10 = new $$Lambda$az$c$Zdc0oyO32FjZ4m6Qfbr1NiUgcnA(this);
            goto L53
        L47:
            r21 = false;
            goto L48
        L43:
            r19 = false;
            goto L44
        L37:
            if (this.f20603d.f().b() == false) goto L39;
            r17 = (CharSequence) ZeusTransformUtils.preCheckCast(((FragmentActivity) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(az.a(this.f20600a), "com.obric.aiagent.plugin"), FragmentActivity.class, "com.obric.aiagent.plugin")).getString(ZeusTransformUtils.mapRes(R.string.obric_skill_form_select_icon_description, WsChannelMultiProcessSharedProvider.STRING_TYPE, "obric_skill_form_select_icon_description")), CharSequence.class, "com.obric.aiagent.plugin");
            goto L40
        L33:
            r15 = false;
            goto L34
        L29:
            r13 = false;
            goto L30
        L23:
            if (r0.a() == false) goto L25;
            r11 = new $$Lambda$az$c$3MCcO62BcqdBIKHWIJBLY8JyCTM(this);
            goto L26
        L13:
            r8 = 8;
            goto L14
        L9:
            r6 = 8;
            goto L10
        L5:
            r2 = 0;
            goto L6
        }

        private static final void a(c r0, View r1) {
            r0.f20603d.f().c().invoke();
        }

        private static final void b(c r0, View r1) {
            r0.f20603d.f().c().invoke();
        }
    }

    /* JADX INFO: compiled from: SkillFormSheetController.kt */
    private static final class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final ScrollView f20613a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final View f20614b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final SimpleDraweeView f20615c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final View f20616d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private final View f20617e;
        private final View f;
        private final OInputLayout g;
        private final TextView h;
        private final OInputLayout i;
        private final OInputLayout j;
        private final ViewGroup k;
        private final ViewGroup l;
        private final View m;

        public d(View r6) {
            d.h.b.o.e(r6, "content");
            View r0 = r6.findViewById(ZeusTransformUtils.mapRes(R.id.skill_form_scroll, DbHelper.COL_ID, "skill_form_scroll"));
            d.h.b.o.c(r0, "findViewById(...)");
            this.f20613a = (ScrollView) ZeusTransformUtils.preCheckCast(r0, ScrollView.class, "com.obric.aiagent.plugin");
            View r1 = r6.findViewById(ZeusTransformUtils.mapRes(R.id.skill_form_icon_box, DbHelper.COL_ID, "skill_form_icon_box"));
            d.h.b.o.c(r1, "findViewById(...)");
            this.f20614b = r1;
            View r2 = r6.findViewById(ZeusTransformUtils.mapRes(R.id.skill_form_cover, DbHelper.COL_ID, "skill_form_cover"));
            d.h.b.o.c(r2, "findViewById(...)");
            this.f20615c = (SimpleDraweeView) ZeusTransformUtils.preCheckCast(r2, SimpleDraweeView.class, "com.obric.aiagent.plugin");
            View r3 = r6.findViewById(ZeusTransformUtils.mapRes(R.id.skill_form_placeholder_icon, DbHelper.COL_ID, "skill_form_placeholder_icon"));
            d.h.b.o.c(r3, "findViewById(...)");
            this.f20616d = r3;
            View r4 = r6.findViewById(ZeusTransformUtils.mapRes(R.id.skill_form_icon_add, DbHelper.COL_ID, "skill_form_icon_add"));
            d.h.b.o.c(r4, "findViewById(...)");
            this.f20617e = r4;
            View r5 = r6.findViewById(ZeusTransformUtils.mapRes(R.id.skill_form_icon_edit_target, DbHelper.COL_ID, "skill_form_icon_edit_target"));
            d.h.b.o.c(r5, "findViewById(...)");
            this.f = r5;
            View r7 = r6.findViewById(ZeusTransformUtils.mapRes(R.id.skill_form_name, DbHelper.COL_ID, "skill_form_name"));
            d.h.b.o.c(r7, "findViewById(...)");
            this.g = (OInputLayout) ZeusTransformUtils.preCheckCast(r7, OInputLayout.class, "com.obric.aiagent.plugin");
            View r8 = r6.findViewById(ZeusTransformUtils.mapRes(R.id.skill_form_description_label, DbHelper.COL_ID, "skill_form_description_label"));
            d.h.b.o.c(r8, "findViewById(...)");
            this.h = (TextView) ZeusTransformUtils.preCheckCast(r8, TextView.class, "com.obric.aiagent.plugin");
            View r9 = r6.findViewById(ZeusTransformUtils.mapRes(R.id.skill_form_description, DbHelper.COL_ID, "skill_form_description"));
            d.h.b.o.c(r9, "findViewById(...)");
            this.i = (OInputLayout) ZeusTransformUtils.preCheckCast(r9, OInputLayout.class, "com.obric.aiagent.plugin");
            View r10 = r6.findViewById(ZeusTransformUtils.mapRes(R.id.skill_form_body, DbHelper.COL_ID, "skill_form_body"));
            d.h.b.o.c(r10, "findViewById(...)");
            this.j = (OInputLayout) ZeusTransformUtils.preCheckCast(r10, OInputLayout.class, "com.obric.aiagent.plugin");
            View r11 = r6.findViewById(ZeusTransformUtils.mapRes(R.id.skill_form_file_after_cover, DbHelper.COL_ID, "skill_form_file_after_cover"));
            d.h.b.o.c(r11, "findViewById(...)");
            this.k = (ViewGroup) ZeusTransformUtils.preCheckCast(r11, ViewGroup.class, "com.obric.aiagent.plugin");
            View r12 = r6.findViewById(ZeusTransformUtils.mapRes(R.id.skill_form_file_after_body, DbHelper.COL_ID, "skill_form_file_after_body"));
            d.h.b.o.c(r12, "findViewById(...)");
            this.l = (ViewGroup) ZeusTransformUtils.preCheckCast(r12, ViewGroup.class, "com.obric.aiagent.plugin");
            View r13 = r6.findViewById(ZeusTransformUtils.mapRes(R.id.skill_form_ime_scroll_spacer, DbHelper.COL_ID, "skill_form_ime_scroll_spacer"));
            d.h.b.o.c(r13, "findViewById(...)");
            this.m = r13;
        }

        public final ScrollView a() {
            return this.f20613a;
        }

        public final View b() {
            return this.f20614b;
        }

        public final SimpleDraweeView c() {
            return this.f20615c;
        }

        public final View d() {
            return this.f20616d;
        }

        public final View e() {
            return this.f20617e;
        }

        public final View f() {
            return this.f;
        }

        public final OInputLayout g() {
            return this.g;
        }

        public final TextView h() {
            return this.h;
        }

        public final OInputLayout i() {
            return this.i;
        }

        public final OInputLayout j() {
            return this.j;
        }

        public final ViewGroup k() {
            return this.k;
        }

        public final ViewGroup l() {
            return this.l;
        }

        public final View m() {
            return this.m;
        }
    }

    /* JADX INFO: compiled from: SkillFormSheetController.kt */
    /* synthetic */ class e extends d.h.b.l implements d.h.a.b<com.obric.aiagent.skill.manager.impl.as, d.x> {
        e(Object r8) {
            super(1, r8, hd.class, "reportCardShow", "reportCardShow(Lcom/obric/aiagent/skill/manager/impl/SkillCardTypeLevel1;)V", 0);
        }

        public final void a(com.obric.aiagent.skill.manager.impl.as r3) {
            d.h.b.o.e(r3, "p0");
            ((hd) ZeusTransformUtils.preCheckCast(this.receiver, hd.class, "com.obric.aiagent.plugin")).a(r3);
        }

        @Override // d.h.a.b
        public /* synthetic */ d.x invoke(com.obric.aiagent.skill.manager.impl.as r3) {
            a((com.obric.aiagent.skill.manager.impl.as) ZeusTransformUtils.preCheckCast(r3, com.obric.aiagent.skill.manager.impl.as.class, "com.obric.aiagent.plugin"));
            return d.x.f38692a;
        }
    }

    /* JADX INFO: compiled from: SkillFormSheetController.kt */
    public static final class f implements OSheetModal.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ d f20618a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ View f20619b;

        @Override // com.obric.oui.sheet.v2.OSheetModal.d
        public void b(OSheetModal r1) {
            d.h.b.o.e(r1, "view");
        }

        f(d r1, View r2) {
            this.f20618a = r1;
            this.f20619b = r2;
        }

        @Override // com.obric.oui.sheet.v2.OSheetModal.d
        public void a(OSheetModal r3) {
            d.h.b.o.e(r3, "view");
            ViewCompat.u((View) ZeusTransformUtils.preCheckCast(this.f20618a.a(), View.class, "com.obric.aiagent.plugin"));
            ViewCompat.u(this.f20619b);
        }
    }

    /* JADX INFO: compiled from: SkillFormSheetController.kt */
    public static final class g implements OSheetModal.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ az f20620a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ d.h.b.z.f<c> f20621b;

        public static /* synthetic */ void lambda$46UnXuentU5BXlVhFpSFxjl5x90(d.h.b.z.f r0) {
            a(r0);
        }

        @Override // com.obric.oui.sheet.v2.OSheetModal.c
        public void a(OSheetModal r1) {
            d.h.b.o.e(r1, "view");
        }

        g(az r1, d.h.b.z.f<c> r2) {
            this.f20620a = r1;
            this.f20621b = r2;
        }

        @Override // com.obric.oui.sheet.v2.OSheetModal.c
        public void b(OSheetModal r3) {
            d.h.b.o.e(r3, "view");
            View r4 = ((FragmentActivity) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(az.a(this.f20620a), "com.obric.aiagent.plugin"), FragmentActivity.class, "com.obric.aiagent.plugin")).getWindow().getDecorView();
            final d.h.b.z.f<c> r2 = this.f20621b;
            r4.post(new $$Lambda$az$g$46UnXuentU5BXlVhFpSFxjl5x90(r2));
        }

        private static final void a(d.h.b.z.f r2) {
            c r3 = (c) ZeusTransformUtils.preCheckCast(r2.f38504a, c.class, "com.obric.aiagent.plugin");
            if (r3 == null) goto L6;
            r3.g();
            return;
        }
    }

    public static /* synthetic */ void lambda$BvfErUbE7sy8zcLiaqNBSFSf0ms(d.h.b.z.f r0, View r1) {
        b(r0, r1);
    }

    public static /* synthetic */ d.x lambda$XuXO2vSnkGYzQEIGsP9sFJPwAZw(az r0, OSheetModal r1) {
        return a(r0, r1);
    }

    /* JADX INFO: renamed from: lambda$ZIkL5l01j_l4RyQC3R-QoFiuKUk, reason: not valid java name */
    public static /* synthetic */ d.x m329lambda$ZIkL5l01j_l4RyQC3RQoFiuKUk(d.h.a.a r0, DialogInterface r1, int r2) {
        return a(r0, r1, r2);
    }

    public static /* synthetic */ void lambda$b6jU_OL0RFsaADnlMZ_dM_7kSD0(d.h.b.z.f r0, View r1) {
        a(r0, r1);
    }

    /* JADX INFO: renamed from: lambda$rGjJYcoCi9J11-tYzDeoo6Gh13c, reason: not valid java name */
    public static /* synthetic */ androidx.core.view.al m330lambda$rGjJYcoCi9J11tYzDeoo6Gh13c(View r0, androidx.core.view.al r1) {
        return a(r0, r1);
    }

    public static /* synthetic */ d.x lambda$w250SOlDXt5dY3fGlIHHFN7qE14(d.h.a.a r0, DialogInterface r1, int r2) {
        return b(r0, r1, r2);
    }

    public az(FragmentActivity r3, hd r4) {
        FragmentActivity r5 = (FragmentActivity) ZeusTransformUtils.wrapperContextForParams(r3, FragmentActivity.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r5, "activity");
        d.h.b.o.e(r4, "trackingReporter");
        this.f20593b = r5;
        this.f20594c = r4;
        this.f = new bk(r5, true);
    }

    public static final /* synthetic */ int a(az r0, int r1) {
        return r0.a(r1);
    }

    public static final /* synthetic */ FragmentActivity a(az r0) {
        return r0.f20593b;
    }

    public static final /* synthetic */ String a(az r0, OInputLayout r1) {
        return r0.a(r1);
    }

    public static final /* synthetic */ void a(az r0, c r1) {
        r0.f20595d = r1;
    }

    public static final /* synthetic */ void a(az r0, OInputLayout r1, int r2) {
        r0.a(r1, r2);
    }

    public static final /* synthetic */ void a(az r0, OInputLayout r1, Integer r2) {
        r0.a(r1, r2);
    }

    public static final /* synthetic */ void a(az r2, d.h.a.a r3, d.h.a.a r4) {
        r2.a((d.h.a.a) ZeusTransformUtils.wrapperContextForParams(r3, d.h.a.a.class, "com.obric.aiagent.plugin"), (d.h.a.a) ZeusTransformUtils.wrapperContextForParams(r4, d.h.a.a.class, "com.obric.aiagent.plugin"));
    }

    public static final /* synthetic */ PathInterpolator b() {
        return g;
    }

    public static final /* synthetic */ c b(az r0) {
        return r0.f20595d;
    }

    public static final /* synthetic */ void c(az r0) {
        r0.c();
    }

    public static final /* synthetic */ bk d(az r0) {
        return r0.f;
    }

    public /* synthetic */ az(FragmentActivity r7, hd r8, int r9, d.h.b.h r10) {
        FragmentActivity r11 = (FragmentActivity) ZeusTransformUtils.wrapperContextForParams(r7, FragmentActivity.class, "com.obric.aiagent.plugin");
        if ((r9 & 2) == 0) goto L5;
        r8 = new hd(null, null, null, 7, null);
    L5:
        this(r11, r8);
    }

    /* JADX WARN: Type inference failed for: r2v16, types: [T, com.obric.aiagent.skill.manager.impl.ui.az$c] */
    public final void a(ay r28) {
        d.h.b.o.e(r28, "config");
        c r2 = this.f20595d;
        if (r2 == null) goto L7;
        OSheetModal r3 = r2.a();
        if (r3 == null) goto L7;
        r3.dismiss();
    L7:
        a(r28.a());
        View r4 = ZeusTransformUtils.inflate(LayoutInflater.from((Context) ZeusTransformUtils.preCheckCast(this.f20593b, Context.class, "com.obric.aiagent.plugin")), ZeusTransformUtils.mapRes(R.layout.sheet_skill_form, "layout", "sheet_skill_form"), null, false, "com.obric.aiagent.plugin");
        d.h.b.o.a(r4);
        d r5 = new d(r4);
        final d.h.b.z.f r6 = new d.h.b.z.f();
        androidx.core.view.al r7 = ViewCompat.w(this.f20593b.getWindow().getDecorView());
        if (r7 == null) goto L10;
        int r8 = bh.a(r7);
    L11:
        View r9 = new View((Context) ZeusTransformUtils.preCheckCast(this.f20593b, Context.class, "com.obric.aiagent.plugin"));
        r9.setBackgroundColor(a(ZeusTransformUtils.mapRes(R.color.oui_basic_bg_base_2, "color", "oui_basic_bg_base_2")));
        r9.setClickable(false);
        r9.setFocusable(false);
        r9.setImportantForAccessibility(2);
        final OSheetModal r10 = new OSheetModal((Context) ZeusTransformUtils.preCheckCast(this.f20593b, Context.class, "com.obric.aiagent.plugin"), null, 0, true, false, 22, null);
        r10.setHeightMode(OSheet.c.f36215a);
        r10.enableIgnoreInsetBottom(true);
        r10.setSheetBgColor(a(ZeusTransformUtils.mapRes(R.color.oui_basic_bg_base_2, "color", "oui_basic_bg_base_2")));
        r10.setCancelable(false);
        com.obric.oui.sheet.v2.a.C0991a.a((com.obric.oui.sheet.v2.a) ZeusTransformUtils.preCheckCast(r10, com.obric.oui.sheet.v2.a.class, "com.obric.aiagent.plugin"), OSheet.b.f36212c, null, null, r28.b(), null, false, new $$Lambda$az$b6jU_OL0RFsaADnlMZ_dM_7kSD0(r6), new $$Lambda$az$BvfErUbE7sy8zcLiaqNBSFSf0ms(r6), Integer.valueOf(ZeusTransformUtils.mapRes(R.string.oui_iv_close_desc, WsChannelMultiProcessSharedProvider.STRING_TYPE, "oui_iv_close_desc")), Integer.valueOf(ZeusTransformUtils.mapRes(R.string.oui_confirm, WsChannelMultiProcessSharedProvider.STRING_TYPE, "oui_confirm")), null, null, Integer.valueOf(ZeusTransformUtils.mapRes(R.drawable.oui_ic_title_bar_close, "drawable", "oui_ic_title_bar_close")), Integer.valueOf(ZeusTransformUtils.mapRes(R.drawable.oui_ic_title_bar_confirm, "drawable", "oui_ic_title_bar_confirm")), 3094, null);
        r10.setBodyView(r4);
        r10.getRootContainer().addView(r9, (ViewGroup.LayoutParams) ZeusTransformUtils.preCheckCast(new FrameLayout.LayoutParams(-1, r8, 80), ViewGroup.LayoutParams.class, "com.obric.aiagent.plugin"));
        ViewCompat.a(r9, $$Lambda$az$rGjJYcoCi9J11tYzDeoo6Gh13c.INSTANCE);
        r10.setOnShowAnimListener((OSheetModal.d) ZeusTransformUtils.preCheckCast(new f(r5, r9), OSheetModal.d.class, "com.obric.aiagent.plugin"));
        r10.setOnDismissAnimListener((OSheetModal.c) ZeusTransformUtils.preCheckCast(new g(this, r6), OSheetModal.c.class, "com.obric.aiagent.plugin"));
        ?? r11 = new c(this, r28, r5, r10);
        r6.f38504a = r11;
        this.f20595d = r11;
        r11.b();
        ba.a(r28.a(), new $$Lambda$az$XuXO2vSnkGYzQEIGsP9sFJPwAZw(this, r10), (d.h.a.b) ZeusTransformUtils.preCheckCast(new e(this.f20594c), d.h.a.b.class, "com.obric.aiagent.plugin"));
        r11.i();
        return;
    L10:
        r8 = 0;
        goto L11
    }

    private static final void a(d.h.b.z.f r1, View r2) {
        c r3 = (c) ZeusTransformUtils.preCheckCast(r1.f38504a, c.class, "com.obric.aiagent.plugin");
        if (r3 == null) goto L6;
        r3.e();
        return;
    }

    private static final void b(d.h.b.z.f r1, View r2) {
        c r3 = (c) ZeusTransformUtils.preCheckCast(r1.f38504a, c.class, "com.obric.aiagent.plugin");
        if (r3 == null) goto L6;
        r3.c();
        return;
    }

    private static final androidx.core.view.al a(View r3, androidx.core.view.al r4) {
        d.h.b.o.e(r3, "view");
        d.h.b.o.e(r4, "insets");
        int r0 = bh.a(r4);
        ViewGroup.LayoutParams r1 = r3.getLayoutParams();
        if (r1.height == r0) goto L5;
        r1.height = r0;
        r3.setLayoutParams(r1);
    L5:
        return r4;
    }

    private static final d.x a(az r0, OSheetModal r1) {
        r0.f.a();
        r1.show();
        return d.x.f38692a;
    }

    public final void a(at r2) {
        d.h.b.o.e(r2, "state");
        c r1 = this.f20595d;
        if (r1 == null) goto L6;
        r1.a(r2);
        return;
    }

    public final void b(at r2) {
        d.h.b.o.e(r2, "state");
        c r1 = this.f20595d;
        if (r1 == null) goto L6;
        r1.b(r2);
        return;
    }

    public final boolean b(ay r4) {
        d.h.b.o.e(r4, "config");
        if (r4.a() == ax.f20583b) goto L5;
        return false;
    L5:
        c r3 = this.f20595d;
        if (r3 != null) goto L9;
        return false;
    L9:
        return r3.a(r4);
    }

    public final void a(String r2) {
        d.h.b.o.e(r2, "url");
        c r1 = this.f20595d;
        if (r1 == null) goto L6;
        r1.a(r2);
        return;
    }

    public final boolean a(com.obric.aiagent.skill.manager.impl.cb r3, d.h.a.b<? super Throwable, d.x> r4) {
        d.h.a.b<? super Throwable, d.x> r5 = (d.h.a.b) ZeusTransformUtils.wrapperContextForParams(r4, d.h.a.b.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r3, "draft");
        d.h.b.o.e(r5, "onFailure");
        c r2 = this.f20595d;
        if (r2 != null) goto L7;
        return false;
    L7:
        return r2.a(r3, r5);
    }

    public final void a() {
        c r0 = this.f20595d;
        if (r0 == null) goto L5;
        r0.h();
    L5:
        if (r0 == null) goto L9;
        OSheetModal r1 = r0.a();
        if (r1 == null) goto L9;
        r1.dismiss();
    L9:
        this.f20595d = null;
        c();
        this.f.b();
    }

    private final void a(ax r3) {
        if (this.f20596e != null) goto L5;
        this.f20596e = Integer.valueOf(this.f20593b.getWindow().getAttributes().softInputMode);
    L5:
        Integer r0 = this.f20596e;
        if (r0 == null) goto L13;
        int r1 = (r0.intValue() & (-241)) & (-16);
        if (r3 != ax.f20582a) goto L10;
        int r4 = 16;
    L11:
        this.f20593b.getWindow().setSoftInputMode((r4 | r1) | 2);
        return;
    L10:
        r4 = 32;
        goto L11
    }

    private final void c() {
        Integer r0 = this.f20596e;
        if (r0 == null) goto L6;
        int r1 = r0.intValue();
        this.f20596e = null;
        this.f20593b.getWindow().setSoftInputMode(r1);
        return;
    }

    private final void a(OInputLayout r2, int r3) {
        r2.setType(0);
        r2.showInputBackground(false);
        r2.showLabel(false);
        r2.showLimit(true);
        r2.showClear(true);
        r2.setLimitCount(r3);
        r2.setMaxLines(1);
        r2.getVInput().setSingleLine(true);
        r2.getVInput().setHorizontallyScrolling(true);
        r2.getVInput().setFilters(new InputFilter[0]);
        r2.getVInput().setGravity(8388627);
    }

    private final void a(OInputLayout r3, Integer r4) {
        r3.setType(1);
        r3.showInputBackground(false);
        r3.showLabel(false);
        if (r4 == null) goto L5;
        int r1 = r4.intValue();
    L6:
        r3.setLimitCount(r1);
        if (r4 == null) goto L9;
        boolean r2 = true;
    L10:
        r3.showLimit(r2);
        if (r4 == null) goto L13;
        boolean r5 = true;
    L14:
        r3.setAutoChangeWithLimit(r5);
        r3.showTip(false);
        r3.getVInput().setFilters(new InputFilter[0]);
        r3.getVInput().setVerticalScrollBarEnabled(true);
        r3.getVInput().setNestedScrollingEnabled(true);
        r3.getVInput().setHorizontallyScrolling(false);
        r3.getVInput().setGravity(8388659);
        r3.setType(1);
        return;
    L13:
        r5 = false;
        goto L14
    L9:
        r2 = false;
        goto L10
    L5:
        r1 = -1;
        goto L6
    }

    private final void a(d.h.a.a<d.x> r6, d.h.a.a<d.x> r7) {
        final d.h.a.a r8 = (d.h.a.a) ZeusTransformUtils.wrapperContextForParams(r6, d.h.a.a.class, "com.obric.aiagent.plugin");
        final d.h.a.a r9 = (d.h.a.a) ZeusTransformUtils.wrapperContextForParams(r7, d.h.a.a.class, "com.obric.aiagent.plugin");
        ((OAlertDialog) ZeusTransformUtils.preCheckCast(new com.obric.oui.dialog.v2.alert.a((Context) ZeusTransformUtils.preCheckCast(this.f20593b, Context.class, "com.obric.aiagent.plugin")).a(ZeusTransformUtils.mapRes(R.string.obric_skill_form_overwrite_title, WsChannelMultiProcessSharedProvider.STRING_TYPE, "obric_skill_form_overwrite_title")).b((CharSequence) ZeusTransformUtils.preCheckCast(this.f20593b.getString(ZeusTransformUtils.mapRes(R.string.obric_skill_form_overwrite_message, WsChannelMultiProcessSharedProvider.STRING_TYPE, "obric_skill_form_overwrite_message")), CharSequence.class, "com.obric.aiagent.plugin")).a(false).b(ZeusTransformUtils.mapRes(R.string.obric_skill_form_overwrite_keep, WsChannelMultiProcessSharedProvider.STRING_TYPE, "obric_skill_form_overwrite_keep"), new $$Lambda$az$ZIkL5l01j_l4RyQC3RQoFiuKUk(r9)).a(ZeusTransformUtils.mapRes(R.string.obric_skill_form_overwrite_replace, WsChannelMultiProcessSharedProvider.STRING_TYPE, "obric_skill_form_overwrite_replace"), new $$Lambda$az$w250SOlDXt5dY3fGlIHHFN7qE14(r8)).g(), OAlertDialog.class, "com.obric.aiagent.plugin")).show();
    }

    private static final d.x a(d.h.a.a r1, DialogInterface r2, int r3) {
        d.h.a.a r4 = (d.h.a.a) ZeusTransformUtils.wrapperContextForParams(r1, d.h.a.a.class, "com.obric.aiagent.plugin");
        d.h.b.o.e((DialogInterface) ZeusTransformUtils.wrapperContextForParams(r2, DialogInterface.class, "com.obric.aiagent.plugin"), "<unused var>");
        r4.invoke();
        return d.x.f38692a;
    }

    private static final d.x b(d.h.a.a r1, DialogInterface r2, int r3) {
        d.h.a.a r4 = (d.h.a.a) ZeusTransformUtils.wrapperContextForParams(r1, d.h.a.a.class, "com.obric.aiagent.plugin");
        d.h.b.o.e((DialogInterface) ZeusTransformUtils.wrapperContextForParams(r2, DialogInterface.class, "com.obric.aiagent.plugin"), "<unused var>");
        r4.invoke();
        return d.x.f38692a;
    }

    private final int a(int r4) {
        if (Build.VERSION.SDK_INT < 23) goto L6;
        return ZeusTransformUtils.getResources(this.f20593b, "com.obric.aiagent.plugin").getColor(r4, this.f20593b.getTheme());
    L6:
        return ZeusTransformUtils.getResources(this.f20593b, "com.obric.aiagent.plugin").getColor(r4);
    }

    private final String a(OInputLayout r1) {
        CharSequence r0 = r1.getText();
        if (r0 == null) goto L5;
        String r2 = r0.toString();
    L6:
        if (r2 != null) goto L9;
        return "";
    L9:
        return r2;
    L5:
        r2 = null;
        goto L6
    }

    static {
        f20592a = new a(null);
        g = new PathInterpolator(0.2f, 0.0f, 0.0f, 1.0f);
    }
}
