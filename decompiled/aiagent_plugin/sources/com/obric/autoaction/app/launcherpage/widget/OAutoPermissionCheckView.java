package com.obric.autoaction.app.launcherpage.widget;

import android.content.Context;
import android.content.DialogInterface;
import android.text.SpannableString;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.transition.TransitionManager;
import com.bytedance.bdturing.localstorage.DbHelper;
import com.bytedance.common.wschannel.WsChannelMultiProcessSharedProvider;
import com.obric.aiagent.plugin.R;
import com.obric.autoaction.app.launcherpage.utils.p;
import com.obric.oui.button.OButton;
import com.obric.oui.common.util.k;
import com.obric.oui.text.OTextView;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.c.b.a.f;
import d.c.b.a.l;
import d.c.g;
import d.h.a.m;
import d.h.b.h;
import d.o;
import d.x;
import kotlinx.coroutines.am;
import kotlinx.coroutines.an;
import kotlinx.coroutines.ax;
import kotlinx.coroutines.bd;
import kotlinx.coroutines.cx;
import kotlinx.coroutines.i;

/* JADX INFO: compiled from: OAutoPermissionCheckView.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class OAutoPermissionCheckView extends AbstractOAutoTipView implements androidx.lifecycle.d {
    private final OButton btnEnable;
    private OAutoTipContainer container;
    private boolean isDismissing;
    private am scope;
    private final OTextView tvHint;

    /* JADX INFO: compiled from: OAutoPermissionCheckView.kt */
    @f(b = "OAutoPermissionCheckView.kt", c = {165}, d = "invokeSuspend", e = "com.obric.autoaction.app.launcherpage.widget.OAutoPermissionCheckView$checkPermission$1")
    static final class a extends l implements m<am, d.c.d<? super x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f24538a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ OAutoPermissionCheckView f24539b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private /* synthetic */ Object f24540c;

        /* JADX INFO: renamed from: com.obric.autoaction.app.launcherpage.widget.OAutoPermissionCheckView$a$1, reason: invalid class name */
        /* JADX INFO: compiled from: OAutoPermissionCheckView.kt */
        @f(b = "OAutoPermissionCheckView.kt", c = {}, d = "invokeSuspend", e = "com.obric.autoaction.app.launcherpage.widget.OAutoPermissionCheckView$checkPermission$1$1")
        static final class AnonymousClass1 extends l implements m<am, d.c.d<? super x>, Object> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            int f24541a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ OAutoPermissionCheckView f24542b;

            AnonymousClass1(OAutoPermissionCheckView r3, d.c.d<? super AnonymousClass1> r4) {
                d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
                this.f24542b = r3;
                super(2, r5);
            }

            public final Object a(am r3, d.c.d<? super x> r4) {
                return ((AnonymousClass1) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), AnonymousClass1.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
            }

            @Override // d.c.b.a.a
            public final d.c.d<x> create(Object r2, d.c.d<?> r3) {
                d.c.d r4 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin");
                return (d.c.d) ZeusTransformUtils.preCheckCast(new AnonymousClass1(this.f24542b, r4), d.c.d.class, "com.obric.aiagent.plugin");
            }

            @Override // d.h.a.m
            public /* synthetic */ Object invoke(am r3, d.c.d<? super x> r4) {
                return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
            }

            @Override // d.c.b.a.a
            public final Object invokeSuspend(Object r2) {
                d.c.a.b.a();
                if (this.f24541a != 0) goto L7;
                o.a(r2);
                k.a((View) ZeusTransformUtils.preCheckCast(this.f24542b, View.class, "com.obric.aiagent.plugin"));
                return x.f38692a;
            L7:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }

        /* JADX INFO: renamed from: com.obric.autoaction.app.launcherpage.widget.OAutoPermissionCheckView$a$2, reason: invalid class name */
        /* JADX INFO: compiled from: OAutoPermissionCheckView.kt */
        @f(b = "OAutoPermissionCheckView.kt", c = {}, d = "invokeSuspend", e = "com.obric.autoaction.app.launcherpage.widget.OAutoPermissionCheckView$checkPermission$1$2")
        static final class AnonymousClass2 extends l implements m<am, d.c.d<? super x>, Object> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            int f24543a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ OAutoPermissionCheckView f24544b;

            AnonymousClass2(OAutoPermissionCheckView r3, d.c.d<? super AnonymousClass2> r4) {
                d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
                this.f24544b = r3;
                super(2, r5);
            }

            public final Object a(am r3, d.c.d<? super x> r4) {
                return ((AnonymousClass2) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), AnonymousClass2.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
            }

            @Override // d.c.b.a.a
            public final d.c.d<x> create(Object r2, d.c.d<?> r3) {
                d.c.d r4 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin");
                return (d.c.d) ZeusTransformUtils.preCheckCast(new AnonymousClass2(this.f24544b, r4), d.c.d.class, "com.obric.aiagent.plugin");
            }

            @Override // d.h.a.m
            public /* synthetic */ Object invoke(am r3, d.c.d<? super x> r4) {
                return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
            }

            @Override // d.c.b.a.a
            public final Object invokeSuspend(Object r2) {
                d.c.a.b.a();
                if (this.f24543a != 0) goto L7;
                o.a(r2);
                k.b((View) ZeusTransformUtils.preCheckCast(this.f24544b, View.class, "com.obric.aiagent.plugin"));
                return x.f38692a;
            L7:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }

        a(OAutoPermissionCheckView r3, d.c.d<? super a> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f24539b = r3;
            super(2, r5);
        }

        public final Object a(am r3, d.c.d<? super x> r4) {
            return ((a) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), a.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<x> create(Object r3, d.c.d<?> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            a r0 = new a(this.f24539b, r5);
            r0.f24540c = r3;
            return (d.c.d) ZeusTransformUtils.preCheckCast(r0, d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d.c.d<? super x> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r11) {
            Object r0 = d.c.a.b.a();
            int r1 = this.f24538a;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            am r2 = (am) ZeusTransformUtils.preCheckCast(this.f24540c, am.class, "com.obric.aiagent.plugin");
            o.a(r11);
            am r4 = r2;
        L13:
            if (((Boolean) ZeusTransformUtils.preCheckCast(r11, Boolean.class, "com.obric.aiagent.plugin")).booleanValue() == false) goto L15;
            i.a(r4, (g) ZeusTransformUtils.preCheckCast(bd.b(), g.class, "com.obric.aiagent.plugin"), null, (m) ZeusTransformUtils.preCheckCast(new AnonymousClass1(this.f24539b, null), m.class, "com.obric.aiagent.plugin"), 2, null);
        L17:
            return x.f38692a;
        L15:
            i.a(r4, (g) ZeusTransformUtils.preCheckCast(bd.b(), g.class, "com.obric.aiagent.plugin"), null, (m) ZeusTransformUtils.preCheckCast(new AnonymousClass2(this.f24539b, null), m.class, "com.obric.aiagent.plugin"), 2, null);
            goto L17
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            o.a(r11);
            am r12 = (am) ZeusTransformUtils.preCheckCast(this.f24540c, am.class, "com.obric.aiagent.plugin");
            OAutoPermissionCheckView r3 = this.f24539b;
            d.c.d<? super Boolean> r5 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.f24540c = r12;
            this.f24538a = 1;
            Object r6 = r3.shouldShow(r5);
            if (r6 != r0) goto L11;
            return r0;
        L11:
            r4 = r12;
            r11 = r6;
            goto L13
        }
    }

    /* JADX INFO: compiled from: OAutoPermissionCheckView.kt */
    @f(b = "OAutoPermissionCheckView.kt", c = {117, 118}, d = "invokeSuspend", e = "com.obric.autoaction.app.launcherpage.widget.OAutoPermissionCheckView$enablePermission$1")
    static final class b extends l implements m<am, d.c.d<? super x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f24545a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ OAutoPermissionCheckView f24546b;

        /* JADX INFO: renamed from: com.obric.autoaction.app.launcherpage.widget.OAutoPermissionCheckView$b$1, reason: invalid class name */
        /* JADX INFO: compiled from: OAutoPermissionCheckView.kt */
        @f(b = "OAutoPermissionCheckView.kt", c = {}, d = "invokeSuspend", e = "com.obric.autoaction.app.launcherpage.widget.OAutoPermissionCheckView$enablePermission$1$1")
        static final class AnonymousClass1 extends l implements m<am, d.c.d<? super x>, Object> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            int f24547a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ OAutoPermissionCheckView f24548b;

            AnonymousClass1(OAutoPermissionCheckView r3, d.c.d<? super AnonymousClass1> r4) {
                d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
                this.f24548b = r3;
                super(2, r5);
            }

            public final Object a(am r3, d.c.d<? super x> r4) {
                return ((AnonymousClass1) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), AnonymousClass1.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
            }

            @Override // d.c.b.a.a
            public final d.c.d<x> create(Object r2, d.c.d<?> r3) {
                d.c.d r4 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin");
                return (d.c.d) ZeusTransformUtils.preCheckCast(new AnonymousClass1(this.f24548b, r4), d.c.d.class, "com.obric.aiagent.plugin");
            }

            @Override // d.h.a.m
            public /* synthetic */ Object invoke(am r3, d.c.d<? super x> r4) {
                return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
            }

            @Override // d.c.b.a.a
            public final Object invokeSuspend(Object r2) {
                d.c.a.b.a();
                if (this.f24547a != 0) goto L7;
                o.a(r2);
                OAutoPermissionCheckView.access$showEnabledState(this.f24548b);
                return x.f38692a;
            L7:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }

        b(OAutoPermissionCheckView r3, d.c.d<? super b> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f24546b = r3;
            super(2, r5);
        }

        public final Object a(am r3, d.c.d<? super x> r4) {
            return ((b) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), b.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<x> create(Object r2, d.c.d<?> r3) {
            d.c.d r4 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new b(this.f24546b, r4), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d.c.d<? super x> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r7) {
            Object r0 = d.c.a.b.a();
            int r1 = this.f24545a;
            if (r1 == 0) goto L10;
            if (r1 == 1) goto L9;
            if (r1 != 2) goto L8;
            o.a(r7);
        L17:
            return x.f38692a;
        L8:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L9:
            o.a(r7);
        L13:
            g r8 = (g) ZeusTransformUtils.preCheckCast(bd.b(), g.class, "com.obric.aiagent.plugin");
            m r2 = (m) ZeusTransformUtils.preCheckCast(new AnonymousClass1(this.f24546b, null), m.class, "com.obric.aiagent.plugin");
            d.c.d r3 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.f24545a = 2;
            if (i.a(r8, r2, r3) != r0) goto L17;
            return r0;
        L10:
            o.a(r7);
            com.obric.autoaction.app.launcherpage.utils.f r9 = com.obric.autoaction.app.launcherpage.utils.f.f24476a;
            Context r4 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(this.f24546b.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
            d.h.b.o.c(r4, "getContext(...)");
            d.c.d<Object> r5 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.f24545a = 1;
            if (r9.b(r4, r5) != r0) goto L13;
            return r0;
        }
    }

    /* JADX INFO: compiled from: OAutoPermissionCheckView.kt */
    @f(b = "OAutoPermissionCheckView.kt", c = {178, 179}, d = "shouldShow", e = "com.obric.autoaction.app.launcherpage.widget.OAutoPermissionCheckView")
    static final class c extends d.c.b.a.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f24549a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        /* synthetic */ Object f24550b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ OAutoPermissionCheckView f24551c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        int f24552d;

        c(OAutoPermissionCheckView r3, d.c.d<? super c> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f24551c = r3;
            super(r5);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r3) {
            this.f24550b = r3;
            this.f24552d |= Integer.MIN_VALUE;
            return this.f24551c.shouldShow((d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
        }
    }

    /* JADX INFO: compiled from: OAutoPermissionCheckView.kt */
    @f(b = "OAutoPermissionCheckView.kt", c = {}, d = "invokeSuspend", e = "com.obric.autoaction.app.launcherpage.widget.OAutoPermissionCheckView$shouldShow$2")
    static final class d extends l implements m<am, d.c.d<? super Boolean>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f24553a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ boolean f24554b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ OAutoPermissionCheckView f24555c;

        d(boolean r3, OAutoPermissionCheckView r4, d.c.d<? super d> r5) {
            d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
            this.f24554b = r3;
            this.f24555c = r4;
            super(2, r6);
        }

        public final Object a(am r3, d.c.d<? super Boolean> r4) {
            return ((d) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), d.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<x> create(Object r3, d.c.d<?> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new d(this.f24554b, this.f24555c, r5), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d.c.d<? super Boolean> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r6) {
            d.c.a.b.a();
            if (this.f24553a != 0) goto L11;
            o.a(r6);
            if (this.f24554b == true) goto L7;
            OAutoPermissionCheckView.access$getBtnEnable$p(this.f24555c).setMIcon(null);
            OAutoPermissionCheckView.access$getBtnEnable$p(this.f24555c).setText((CharSequence) ZeusTransformUtils.preCheckCast(((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(this.f24555c.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")).getString(ZeusTransformUtils.mapRes(R.string.oauto_permission_enable, WsChannelMultiProcessSharedProvider.STRING_TYPE, "oauto_permission_enable")), CharSequence.class, "com.obric.aiagent.plugin"));
            OAutoPermissionCheckView.access$getTvHint$p(this.f24555c).setText((CharSequence) ZeusTransformUtils.preCheckCast(((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(this.f24555c.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")).getString(ZeusTransformUtils.mapRes(R.string.oauto_permission_require_tips, WsChannelMultiProcessSharedProvider.STRING_TYPE, "oauto_permission_require_tips")), CharSequence.class, "com.obric.aiagent.plugin"));
            return d.c.b.a.b.a(true);
        L7:
            return d.c.b.a.b.a(false);
        L11:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: compiled from: OAutoPermissionCheckView.kt */
    @f(b = "OAutoPermissionCheckView.kt", c = {134}, d = "invokeSuspend", e = "com.obric.autoaction.app.launcherpage.widget.OAutoPermissionCheckView$showEnabledState$1")
    static final class e extends l implements m<am, d.c.d<? super x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f24556a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ OAutoPermissionCheckView f24557b;

        e(OAutoPermissionCheckView r3, d.c.d<? super e> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f24557b = r3;
            super(2, r5);
        }

        public final Object a(am r3, d.c.d<? super x> r4) {
            return ((e) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), e.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<x> create(Object r2, d.c.d<?> r3) {
            d.c.d r4 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new e(this.f24557b, r4), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d.c.d<? super x> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r7) {
            Object r0 = d.c.a.b.a();
            int r1 = this.f24556a;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            o.a(r7);
        L11:
            ViewParent r8 = this.f24557b.getParent();
            if (ZeusTransformUtils.instanceOf(r8, ViewGroup.class) == false) goto L14;
            ViewGroup r9 = (ViewGroup) ZeusTransformUtils.preCheckCast(r8, ViewGroup.class, "com.obric.aiagent.plugin");
        L15:
            if (r9 == null) goto L17;
            TransitionManager.a(r9);
        L17:
            k.b((View) ZeusTransformUtils.preCheckCast(this.f24557b, View.class, "com.obric.aiagent.plugin"));
            OAutoPermissionCheckView.access$setDismissing$p(this.f24557b, false);
            return x.f38692a;
        L14:
            r9 = null;
            goto L15
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            o.a(r7);
            OAutoPermissionCheckView.access$setDismissing$p(this.f24557b, true);
            d.c.d r10 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.f24556a = 1;
            if (ax.a(1000, r10) != r0) goto L11;
            return r0;
        }
    }

    public OAutoPermissionCheckView(Context r7) {
        Context r1 = (Context) ZeusTransformUtils.wrapperContextForParams(r7, Context.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r1, "context");
        this(r1, null, 0, 6, null);
    }

    public OAutoPermissionCheckView(Context r9, AttributeSet r10) {
        Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r9, Context.class, "com.obric.aiagent.plugin");
        AttributeSet r4 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r10, AttributeSet.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r3, "context");
        this(r3, r4, 0, 4, null);
    }

    public static /* synthetic */ void lambda$_y5d3w42DNQWkx87JqiGlQPnzm4(Context r0, OAutoPermissionCheckView r1, View r2) {
        _init_$lambda$1(r0, r1, r2);
    }

    public /* synthetic */ OAutoPermissionCheckView(Context r2, AttributeSet r3, int r4, int r5, h r6) {
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

    public static final /* synthetic */ OButton access$getBtnEnable$p(OAutoPermissionCheckView r0) {
        return r0.btnEnable;
    }

    public static final /* synthetic */ OTextView access$getTvHint$p(OAutoPermissionCheckView r0) {
        return r0.tvHint;
    }

    public static final /* synthetic */ void access$setDismissing$p(OAutoPermissionCheckView r0, boolean r1) {
        r0.isDismissing = r1;
    }

    public static final /* synthetic */ void access$showEnabledState(OAutoPermissionCheckView r0) {
        r0.showEnabledState();
    }

    public OAutoPermissionCheckView(Context r4, AttributeSet r5, int r6) {
        final Context r7 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.aiagent.plugin");
        AttributeSet r8 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r5, AttributeSet.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r7, "context");
        super(r7, r8, r6);
        ZeusTransformUtils.inflate(LayoutInflater.from(r7), ZeusTransformUtils.mapRes(R.layout.layout_oauto_permission_check_view, "layout", "layout_oauto_permission_check_view"), (ViewGroup) ZeusTransformUtils.preCheckCast(this, ViewGroup.class, "com.obric.aiagent.plugin"), true, "com.obric.aiagent.plugin");
        View r9 = findViewById(ZeusTransformUtils.mapRes(R.id.tv_hint_text, DbHelper.COL_ID, "tv_hint_text"));
        d.h.b.o.c(r9, "findViewById(...)");
        this.tvHint = (OTextView) ZeusTransformUtils.preCheckCast(r9, OTextView.class, "com.obric.aiagent.plugin");
        View r10 = findViewById(ZeusTransformUtils.mapRes(R.id.btn_enable, DbHelper.COL_ID, "btn_enable"));
        d.h.b.o.c(r10, "findViewById(...)");
        OButton r11 = (OButton) ZeusTransformUtils.preCheckCast(r10, OButton.class, "com.obric.aiagent.plugin");
        this.btnEnable = r11;
        r11.setOnClickListener(new $$Lambda$OAutoPermissionCheckView$_y5d3w42DNQWkx87JqiGlQPnzm4(r7, this));
    }

    private static final void _init_$lambda$1(Context r8, final OAutoPermissionCheckView r9, View r10) {
        Context r0 = (Context) ZeusTransformUtils.wrapperContextForParams(r8, Context.class, "com.obric.aiagent.plugin");
        String r1 = r0.getString(ZeusTransformUtils.mapRes(R.string.oauto_permission_require_dialog_title, WsChannelMultiProcessSharedProvider.STRING_TYPE, "oauto_permission_require_dialog_title"));
        d.h.b.o.c(r1, "getString(...)");
        p.a(r0, r1, r9.buildPermissionDialogMessage(r0), r0.getString(ZeusTransformUtils.mapRes(R.string.oauto_permission_open, WsChannelMultiProcessSharedProvider.STRING_TYPE, "oauto_permission_open")), r0.getString(ZeusTransformUtils.mapRes(R.string.oauto_permission_cancel, WsChannelMultiProcessSharedProvider.STRING_TYPE, "oauto_permission_cancel")), false, true, new $$Lambda$OAutoPermissionCheckView$Fc7cnrUr_Co1V3q5NhGkFJl3woQ(r9));
    }

    static final void lambda$1$lambda$0(OAutoPermissionCheckView r1, DialogInterface r2, int r3) {
        ((DialogInterface) ZeusTransformUtils.wrapperContextForParams(r2, DialogInterface.class, "com.obric.aiagent.plugin")).dismiss();
        r1.enablePermission();
    }

    private final CharSequence buildPermissionDialogMessage(Context r12) {
        final Context r11 = (Context) ZeusTransformUtils.wrapperContextForParams(r12, Context.class, "com.obric.aiagent.plugin");
        String r13 = r11.getString(ZeusTransformUtils.mapRes(R.string.oauto_permission_require_dialog_tips, WsChannelMultiProcessSharedProvider.STRING_TYPE, "oauto_permission_require_dialog_tips"));
        d.h.b.o.c(r13, "getString(...)");
        final String r3 = r11.getString(ZeusTransformUtils.mapRes(R.string.oauto_permission_require_dialog_privacy_link, WsChannelMultiProcessSharedProvider.STRING_TYPE, "oauto_permission_require_dialog_privacy_link"));
        d.h.b.o.c(r3, "getString(...)");
        String r4 = r11.getString(ZeusTransformUtils.mapRes(R.string.oauto_permission_require_dialog_privacy_suffix, WsChannelMultiProcessSharedProvider.STRING_TYPE, "oauto_permission_require_dialog_privacy_suffix"), new Object[]{r3});
        d.h.b.o.c(r4, "getString(...)");
        final String r1 = r11.getString(ZeusTransformUtils.mapRes(R.string.oauto_permission_require_dialog_privacy_url, WsChannelMultiProcessSharedProvider.STRING_TYPE, "oauto_permission_require_dialog_privacy_url"));
        d.h.b.o.c(r1, "getString(...)");
        String r2 = r13 + r4;
        SpannableString r10 = new SpannableString((CharSequence) ZeusTransformUtils.preCheckCast(r2, CharSequence.class, "com.obric.aiagent.plugin"));
        int r14 = d.o.o.a((CharSequence) ZeusTransformUtils.preCheckCast(r2, CharSequence.class, "com.obric.aiagent.plugin"), r3, r13.length(), false, 4, null);
        if (r14 < 0) goto L6;
        r10.setSpan(new OAutoPermissionCheckView$buildPermissionDialogMessage$clickableSpan$1(r11, r1, r3), r14, r3.length() + r14, 33);
    L6:
        return (CharSequence) ZeusTransformUtils.preCheckCast(r10, CharSequence.class, "com.obric.aiagent.plugin");
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        androidx.lifecycle.p r0 = null;
        this.scope = an.a(cx.a(null, 1, null).plus((g) ZeusTransformUtils.preCheckCast(bd.b().a(), g.class, "com.obric.aiagent.plugin")));
        Context r1 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r1, androidx.lifecycle.p.class) == false) goto L5;
        r0 = (androidx.lifecycle.p) ZeusTransformUtils.preCheckCast(r1, androidx.lifecycle.p.class, "com.obric.aiagent.plugin");
    L5:
        if (r0 == null) goto L9;
        androidx.lifecycle.i r2 = r0.getLifecycle();
        if (r2 == null) goto L9;
        r2.a((androidx.lifecycle.o) ZeusTransformUtils.preCheckCast(this, androidx.lifecycle.o.class, "com.obric.aiagent.plugin"));
    L9:
        checkPermission();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        am r0 = this.scope;
        androidx.lifecycle.p r1 = null;
        if (r0 == null) goto L5;
        an.a(r0, null, 1, null);
    L5:
        this.scope = null;
        Context r2 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r2, androidx.lifecycle.p.class) == false) goto L8;
        r1 = (androidx.lifecycle.p) ZeusTransformUtils.preCheckCast(r2, androidx.lifecycle.p.class, "com.obric.aiagent.plugin");
    L8:
        if (r1 == null) goto L13;
        androidx.lifecycle.i r3 = r1.getLifecycle();
        if (r3 == null) goto L14;
        r3.b((androidx.lifecycle.o) ZeusTransformUtils.preCheckCast(this, androidx.lifecycle.o.class, "com.obric.aiagent.plugin"));
        return;
    L14:
        return;
    }

    private final void enablePermission() {
        am r0 = this.scope;
        if (r0 == null) goto L6;
        i.a(r0, (g) ZeusTransformUtils.preCheckCast(bd.c(), g.class, "com.obric.aiagent.plugin"), null, (m) ZeusTransformUtils.preCheckCast(new b(this, null), m.class, "com.obric.aiagent.plugin"), 2, null);
        return;
    }

    private final void showEnabledState() {
        this.btnEnable.setText((CharSequence) ZeusTransformUtils.preCheckCast("", CharSequence.class, "com.obric.aiagent.plugin"));
        this.btnEnable.setButtonSourceBitmap(ZeusTransformUtils.mapRes(R.drawable.o_ic_confirm, "drawable", "o_ic_confirm"), ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")).getColor(ZeusTransformUtils.mapRes(R.color.oui_accent_7_fg, "color", "oui_accent_7_fg")));
        OAutoTipContainer r5 = this.container;
        if (r5 == null) goto L5;
        OAutoTipContainer.dismissWithAnimation$default(r5, 1000, null, 2, null);
        return;
    L5:
        am r11 = this.scope;
        if (r11 == null) goto L10;
        i.a(r11, null, null, (m) ZeusTransformUtils.preCheckCast(new e(this, null), m.class, "com.obric.aiagent.plugin"), 3, null);
        return;
    }

    public final void setContainer(OAutoTipContainer r2) {
        d.h.b.o.e(r2, "tipContainer");
        this.container = r2;
    }

    @Override // android.view.View
    public void setBackgroundColor(int r4) {
        findViewById(ZeusTransformUtils.mapRes(R.id.permission_check_root_container, DbHelper.COL_ID, "permission_check_root_container")).setBackgroundColor(r4);
    }

    @Override // androidx.lifecycle.d
    public void onResume(androidx.lifecycle.p r3) {
        androidx.lifecycle.p r4 = (androidx.lifecycle.p) ZeusTransformUtils.wrapperContextForParams(r3, androidx.lifecycle.p.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r4, "owner");
        super.onResume(r4);
        checkPermission();
    }

    @Override // android.view.View
    public void onWindowFocusChanged(boolean r1) {
        super.onWindowFocusChanged(r1);
        checkPermission();
    }

    private final void checkPermission() {
        if (this.container == null) goto L5;
        return;
    L5:
        if (this.isDismissing == true) goto L13;
        am r1 = this.scope;
        if (r1 == null) goto L12;
        i.a(r1, (g) ZeusTransformUtils.preCheckCast(bd.c(), g.class, "com.obric.aiagent.plugin"), null, (m) ZeusTransformUtils.preCheckCast(new a(this, null), m.class, "com.obric.aiagent.plugin"), 2, null);
        return;
    L12:
        return;
    }

    public Object shouldShow(d.c.d<? super Boolean> r8) {
        d.c.d r9 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r8, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r9, c.class) == false) goto L7;
        c r0 = (c) ZeusTransformUtils.preCheckCast(r9, c.class, "com.obric.aiagent.plugin");
        if ((r0.f24552d & Integer.MIN_VALUE) == 0) goto L7;
        r0.f24552d -= Integer.MIN_VALUE;
    L8:
        Object r10 = r0.f24550b;
        Object r2 = d.c.a.b.a();
        int r3 = r0.f24552d;
        if (r3 == 0) goto L16;
        if (r3 == 1) goto L15;
        if (r3 != 2) goto L14;
        o.a(r10);
    L22:
        return r10;
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        OAutoPermissionCheckView this = (OAutoPermissionCheckView) ZeusTransformUtils.preCheckCast(r0.f24549a, OAutoPermissionCheckView.class, "com.obric.aiagent.plugin");
        o.a(r10);
    L19:
        boolean r11 = ((Boolean) ZeusTransformUtils.preCheckCast(r10, Boolean.class, "com.obric.aiagent.plugin")).booleanValue();
        g r4 = (g) ZeusTransformUtils.preCheckCast(bd.b(), g.class, "com.obric.aiagent.plugin");
        m r7 = (m) ZeusTransformUtils.preCheckCast(new d(r11, this, null), m.class, "com.obric.aiagent.plugin");
        r0.f24549a = null;
        r0.f24552d = 2;
        r10 = i.a(r4, r7, r0);
        if (r10 != r2) goto L22;
        return r2;
    L16:
        o.a(r10);
        com.obric.autoaction.app.launcherpage.utils.f r12 = com.obric.autoaction.app.launcherpage.utils.f.f24476a;
        Context r5 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
        d.h.b.o.c(r5, "getContext(...)");
        r0.f24549a = this;
        r0.f24552d = 1;
        r10 = r12.a(r5, r0);
        if (r10 != r2) goto L19;
        return r2;
    L7:
        r0 = new c(this, r9);
        goto L8
    }
}
