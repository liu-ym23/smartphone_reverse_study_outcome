package com.obric.aiagent.skill.ovirt.impl.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.p;
import androidx.lifecycle.q;
import com.bytedance.common.wschannel.WsChannelMultiProcessSharedProvider;
import com.obric.aiagent.platform.depend.IAppContext;
import com.obric.aiagent.platform.depend.ILogDepend;
import com.obric.aiagent.plugin.R;
import com.obric.oui.lisitem.OCardListItem;
import com.obric.oui.titlebar.OFloatingTitleBar;
import com.obric.oui.toast.OToast;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.c.b.a.f;
import d.c.b.a.l;
import d.c.d;
import d.c.g;
import d.h.a.m;
import d.h.b.h;
import d.k;
import d.o;
import d.x;
import java.util.concurrent.CancellationException;
import kotlinx.coroutines.am;
import kotlinx.coroutines.bd;
import kotlinx.coroutines.ca;
import kotlinx.coroutines.i;

/* JADX INFO: compiled from: ShellManagementActivity.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class ShellManagementActivity extends AppCompatActivity {
    private static final a Companion = null;
    private static final String TAG = "SkRt/ShellMgmtActivity";
    private com.obric.aiagent.skill.ovirt.impl.b.b binding;
    private ca clearJob;
    private com.obric.aiagent.skill.ovirt.impl.ui.a repository;
    private ca usageJob;

    /* JADX INFO: compiled from: ShellManagementActivity.kt */
    private static final class a {
        public /* synthetic */ a(h r1) {
            this();
        }

        private a() {
        }
    }

    /* JADX INFO: compiled from: ShellManagementActivity.kt */
    @f(b = "ShellManagementActivity.kt", c = {144}, d = "invokeSuspend", e = "com.obric.aiagent.skill.ovirt.impl.ui.ShellManagementActivity$clearEnvironment$1")
    static final class b extends l implements m<am, d<? super x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f21459a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ ShellManagementActivity f21460b;

        /* JADX INFO: renamed from: com.obric.aiagent.skill.ovirt.impl.ui.ShellManagementActivity$b$1, reason: invalid class name */
        /* JADX INFO: compiled from: ShellManagementActivity.kt */
        @f(b = "ShellManagementActivity.kt", c = {144}, d = "invokeSuspend", e = "com.obric.aiagent.skill.ovirt.impl.ui.ShellManagementActivity$clearEnvironment$1$1")
        static final class AnonymousClass1 extends l implements m<am, d<? super com.obric.aiagent.skill.ovirt.impl.ui.a.AbstractC0451a>, Object> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            int f21461a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ ShellManagementActivity f21462b;

            AnonymousClass1(ShellManagementActivity r3, d<? super AnonymousClass1> r4) {
                ShellManagementActivity r5 = (ShellManagementActivity) ZeusTransformUtils.wrapperContextForParams(r3, ShellManagementActivity.class, "com.obric.aiagent.plugin");
                d r6 = (d) ZeusTransformUtils.wrapperContextForParams(r4, d.class, "com.obric.aiagent.plugin");
                this.f21462b = r5;
                super(2, r6);
            }

            public final Object a(am r3, d<? super com.obric.aiagent.skill.ovirt.impl.ui.a.AbstractC0451a> r4) {
                return ((AnonymousClass1) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d) ZeusTransformUtils.wrapperContextForParams(r4, d.class, "com.obric.aiagent.plugin")), AnonymousClass1.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
            }

            @Override // d.c.b.a.a
            public final d<x> create(Object r2, d<?> r3) {
                d r4 = (d) ZeusTransformUtils.wrapperContextForParams(r3, d.class, "com.obric.aiagent.plugin");
                return (d) ZeusTransformUtils.preCheckCast(new AnonymousClass1(this.f21462b, r4), d.class, "com.obric.aiagent.plugin");
            }

            @Override // d.h.a.m
            public /* synthetic */ Object invoke(am r3, d<? super com.obric.aiagent.skill.ovirt.impl.ui.a.AbstractC0451a> r4) {
                return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d) ZeusTransformUtils.preCheckCast(r4, d.class, "com.obric.aiagent.plugin"));
            }

            @Override // d.c.b.a.a
            public final Object invokeSuspend(Object r5) {
                Object r0 = d.c.a.b.a();
                int r1 = this.f21461a;
                if (r1 == 0) goto L8;
                if (r1 != 1) goto L7;
                o.a(r5);
            L14:
                return r5;
            L7:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            L8:
                o.a(r5);
                com.obric.aiagent.skill.ovirt.impl.ui.a r6 = ShellManagementActivity.access$getRepository$p(this.f21462b);
                if (r6 != null) goto L11;
                d.h.b.o.c("repository");
                r6 = null;
            L11:
                d<? super com.obric.aiagent.skill.ovirt.impl.ui.a.AbstractC0451a> r2 = (d) ZeusTransformUtils.preCheckCast(this, d.class, "com.obric.aiagent.plugin");
                this.f21461a = 1;
                r5 = r6.b(r2);
                if (r5 != r0) goto L14;
                return r0;
            }
        }

        b(ShellManagementActivity r3, d<? super b> r4) {
            ShellManagementActivity r5 = (ShellManagementActivity) ZeusTransformUtils.wrapperContextForParams(r3, ShellManagementActivity.class, "com.obric.aiagent.plugin");
            d r6 = (d) ZeusTransformUtils.wrapperContextForParams(r4, d.class, "com.obric.aiagent.plugin");
            this.f21460b = r5;
            super(2, r6);
        }

        public final Object a(am r3, d<? super x> r4) {
            return ((b) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d) ZeusTransformUtils.wrapperContextForParams(r4, d.class, "com.obric.aiagent.plugin")), b.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d<x> create(Object r2, d<?> r3) {
            d r4 = (d) ZeusTransformUtils.wrapperContextForParams(r3, d.class, "com.obric.aiagent.plugin");
            return (d) ZeusTransformUtils.preCheckCast(new b(this.f21460b, r4), d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d<? super x> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d) ZeusTransformUtils.preCheckCast(r4, d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r11) {
            Object r0 = d.c.a.b.a();
            int r1 = this.f21459a;
            com.obric.aiagent.skill.ovirt.impl.b.b r4 = null;
            if (r1 != 0) goto L49;
            o.a(r11);
            g r12 = (g) ZeusTransformUtils.preCheckCast(bd.c(), g.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L7 CancellationException -> L9
            m r2 = (m) ZeusTransformUtils.preCheckCast(new AnonymousClass1(this.f21460b, null), m.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L7 CancellationException -> L9
            d r9 = (d) ZeusTransformUtils.preCheckCast(this, d.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L7 CancellationException -> L9
            this.f21459a = 1;     // Catch: Throwable -> L7 CancellationException -> L9
            r11 = i.a(r12, r2, r9);     // Catch: Throwable -> L7 CancellationException -> L9
            if (r11 != r0) goto L17;
            return r0;
        L17:
            com.obric.aiagent.skill.ovirt.impl.ui.a.AbstractC0451a r13 = (com.obric.aiagent.skill.ovirt.impl.ui.a.AbstractC0451a) ZeusTransformUtils.preCheckCast(r11, com.obric.aiagent.skill.ovirt.impl.ui.a.AbstractC0451a.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L7 CancellationException -> L9
            if (d.h.b.o.a(r13, com.obric.aiagent.skill.ovirt.impl.ui.a.AbstractC0451a.c.f21526a) == false) goto L21;
            ShellManagementActivity r14 = this.f21460b;     // Catch: Throwable -> L7 CancellationException -> L9
            String r3 = r14.getString(ZeusTransformUtils.mapRes(R.string.obric_skill_shell_clear_success, WsChannelMultiProcessSharedProvider.STRING_TYPE, "obric_skill_shell_clear_success"));     // Catch: Throwable -> L7 CancellationException -> L9
            d.h.b.o.c(r3, "getString(...)");     // Catch: Throwable -> L7 CancellationException -> L9
            ShellManagementActivity.access$showToast(r14, r3);     // Catch: Throwable -> L7 CancellationException -> L9
            ShellManagementActivity r15 = this.f21460b;     // Catch: Throwable -> L7 CancellationException -> L9
            String r5 = r15.getString(ZeusTransformUtils.mapRes(R.string.obric_skill_shell_usage_calculating, WsChannelMultiProcessSharedProvider.STRING_TYPE, "obric_skill_shell_usage_calculating"));     // Catch: Throwable -> L7 CancellationException -> L9
            d.h.b.o.c(r5, "getString(...)");     // Catch: Throwable -> L7 CancellationException -> L9
            ShellManagementActivity.access$renderUsageVisible(r15, r5);     // Catch: Throwable -> L7 CancellationException -> L9
            ShellManagementActivity.access$refreshUsage(this.f21460b);     // Catch: Throwable -> L7 CancellationException -> L9
        L31:
            com.obric.aiagent.skill.ovirt.impl.b.b r10 = ShellManagementActivity.access$getBinding$p(this.f21460b);
            if (r10 == null) goto L37;
        L38:
            r4 = r10;
        L39:
            r4.f21118c.setEnabled(true);
            return x.f38692a;
        L37:
            d.h.b.o.c("binding");
            goto L39
        L21:
            if (d.h.b.o.a(r13, com.obric.aiagent.skill.ovirt.impl.ui.a.AbstractC0451a.C0452a.f21524a) == false) goto L24;
            ShellManagementActivity r16 = this.f21460b;     // Catch: Throwable -> L7 CancellationException -> L9
            String r6 = r16.getString(ZeusTransformUtils.mapRes(R.string.obric_skill_shell_active_shell_toast, WsChannelMultiProcessSharedProvider.STRING_TYPE, "obric_skill_shell_active_shell_toast"));     // Catch: Throwable -> L7 CancellationException -> L9
            d.h.b.o.c(r6, "getString(...)");     // Catch: Throwable -> L7 CancellationException -> L9
            ShellManagementActivity.access$showToast(r16, r6);     // Catch: Throwable -> L7 CancellationException -> L9
            ShellManagementActivity.access$renderUsageHidden(this.f21460b);     // Catch: Throwable -> L7 CancellationException -> L9
            goto L31
        L24:
            if (d.h.b.o.a(r13, com.obric.aiagent.skill.ovirt.impl.ui.a.AbstractC0451a.d.f21527a) == false) goto L26;
        L30:
            ShellManagementActivity r17 = this.f21460b;     // Catch: Throwable -> L7 CancellationException -> L9
            String r7 = r17.getString(ZeusTransformUtils.mapRes(R.string.obric_skill_shell_clear_failed, WsChannelMultiProcessSharedProvider.STRING_TYPE, "obric_skill_shell_clear_failed"));     // Catch: Throwable -> L7 CancellationException -> L9
            d.h.b.o.c(r7, "getString(...)");     // Catch: Throwable -> L7 CancellationException -> L9
            ShellManagementActivity.access$showToast(r17, r7);     // Catch: Throwable -> L7 CancellationException -> L9
            goto L31
        L26:
            if (d.h.b.o.a(r13, com.obric.aiagent.skill.ovirt.impl.ui.a.AbstractC0451a.b.f21525a) == true) goto L30;
            throw new k();     // Catch: Throwable -> L7 CancellationException -> L9
        L49:
            if (r1 != 1) goto L12;
            o.a(r11);     // Catch: Throwable -> L7 CancellationException -> L9
            goto L17
        L12:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L42:
            th = move-exception;
            com.obric.aiagent.skill.ovirt.impl.b.b r18 = ShellManagementActivity.access$getBinding$p(this.f21460b);
            if (r18 != null) goto L46;
            d.h.b.o.c("binding");
        L47:
            r4.f21118c.setEnabled(true);
            throw th;
        L46:
            r4 = r18;
        L9:
            e = move-exception;
            throw e;     // Catch: Throwable -> L42
        L7:
            th = move-exception;
            ShellManagementActivity.access$logFailure(this.f21460b, "clearEnvironment failed", th);     // Catch: Throwable -> L42
            ShellManagementActivity r19 = this.f21460b;     // Catch: Throwable -> L42
            String r8 = r19.getString(ZeusTransformUtils.mapRes(R.string.obric_skill_shell_clear_failed, WsChannelMultiProcessSharedProvider.STRING_TYPE, "obric_skill_shell_clear_failed"));     // Catch: Throwable -> L42
            d.h.b.o.c(r8, "getString(...)");     // Catch: Throwable -> L42
            ShellManagementActivity.access$showToast(r19, r8);     // Catch: Throwable -> L42
            r10 = ShellManagementActivity.access$getBinding$p(this.f21460b);
            if (r10 != null) goto L38;
            goto L37
        }
    }

    /* JADX INFO: compiled from: ShellManagementActivity.kt */
    @f(b = "ShellManagementActivity.kt", c = {102}, d = "invokeSuspend", e = "com.obric.aiagent.skill.ovirt.impl.ui.ShellManagementActivity$refreshUsage$1")
    static final class c extends l implements m<am, d<? super x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f21463a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ ShellManagementActivity f21464b;

        /* JADX INFO: compiled from: ShellManagementActivity.kt */
        @f(b = "ShellManagementActivity.kt", c = {102}, d = "invokeSuspend", e = "com.obric.aiagent.skill.ovirt.impl.ui.ShellManagementActivity$refreshUsage$1$result$1")
        static final class a extends l implements m<am, d<? super com.obric.aiagent.skill.ovirt.impl.ui.a.c>, Object> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            int f21465a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ ShellManagementActivity f21466b;

            a(ShellManagementActivity r3, d<? super a> r4) {
                ShellManagementActivity r5 = (ShellManagementActivity) ZeusTransformUtils.wrapperContextForParams(r3, ShellManagementActivity.class, "com.obric.aiagent.plugin");
                d r6 = (d) ZeusTransformUtils.wrapperContextForParams(r4, d.class, "com.obric.aiagent.plugin");
                this.f21466b = r5;
                super(2, r6);
            }

            public final Object a(am r3, d<? super com.obric.aiagent.skill.ovirt.impl.ui.a.c> r4) {
                return ((a) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d) ZeusTransformUtils.wrapperContextForParams(r4, d.class, "com.obric.aiagent.plugin")), a.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
            }

            @Override // d.c.b.a.a
            public final d<x> create(Object r2, d<?> r3) {
                d r4 = (d) ZeusTransformUtils.wrapperContextForParams(r3, d.class, "com.obric.aiagent.plugin");
                return (d) ZeusTransformUtils.preCheckCast(new a(this.f21466b, r4), d.class, "com.obric.aiagent.plugin");
            }

            @Override // d.h.a.m
            public /* synthetic */ Object invoke(am r3, d<? super com.obric.aiagent.skill.ovirt.impl.ui.a.c> r4) {
                return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d) ZeusTransformUtils.preCheckCast(r4, d.class, "com.obric.aiagent.plugin"));
            }

            @Override // d.c.b.a.a
            public final Object invokeSuspend(Object r5) {
                Object r0 = d.c.a.b.a();
                int r1 = this.f21465a;
                if (r1 == 0) goto L8;
                if (r1 != 1) goto L7;
                o.a(r5);
            L14:
                return r5;
            L7:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            L8:
                o.a(r5);
                com.obric.aiagent.skill.ovirt.impl.ui.a r6 = ShellManagementActivity.access$getRepository$p(this.f21466b);
                if (r6 != null) goto L11;
                d.h.b.o.c("repository");
                r6 = null;
            L11:
                d<? super com.obric.aiagent.skill.ovirt.impl.ui.a.c> r2 = (d) ZeusTransformUtils.preCheckCast(this, d.class, "com.obric.aiagent.plugin");
                this.f21465a = 1;
                r5 = r6.a(r2);
                if (r5 != r0) goto L14;
                return r0;
            }
        }

        c(ShellManagementActivity r3, d<? super c> r4) {
            ShellManagementActivity r5 = (ShellManagementActivity) ZeusTransformUtils.wrapperContextForParams(r3, ShellManagementActivity.class, "com.obric.aiagent.plugin");
            d r6 = (d) ZeusTransformUtils.wrapperContextForParams(r4, d.class, "com.obric.aiagent.plugin");
            this.f21464b = r5;
            super(2, r6);
        }

        public final Object a(am r3, d<? super x> r4) {
            return ((c) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d) ZeusTransformUtils.wrapperContextForParams(r4, d.class, "com.obric.aiagent.plugin")), c.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d<x> create(Object r2, d<?> r3) {
            d r4 = (d) ZeusTransformUtils.wrapperContextForParams(r3, d.class, "com.obric.aiagent.plugin");
            return (d) ZeusTransformUtils.preCheckCast(new c(this.f21464b, r4), d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d<? super x> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d) ZeusTransformUtils.preCheckCast(r4, d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r7) {
            Object r0 = d.c.a.b.a();
            int r1 = this.f21463a;
            if (r1 == 0) goto L13;
            if (r1 != 1) goto L12;
            o.a(r7);     // Catch: Throwable -> L7 CancellationException -> L9
        L17:
            com.obric.aiagent.skill.ovirt.impl.ui.a.c r8 = (com.obric.aiagent.skill.ovirt.impl.ui.a.c) ZeusTransformUtils.preCheckCast(r7, com.obric.aiagent.skill.ovirt.impl.ui.a.c.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L7 CancellationException -> L9
            if (ZeusTransformUtils.instanceOf(r8, com.obric.aiagent.skill.ovirt.impl.ui.a.c.C0454c.class) == false) goto L21;
            ShellManagementActivity.access$renderUsageVisible(this.f21464b, com.obric.aiagent.skill.ovirt.impl.ui.a.f21521a.a(((com.obric.aiagent.skill.ovirt.impl.ui.a.c.C0454c) ZeusTransformUtils.preCheckCast(r8, com.obric.aiagent.skill.ovirt.impl.ui.a.c.C0454c.class, "com.obric.aiagent.plugin")).a()));     // Catch: Throwable -> L7 CancellationException -> L9
        L38:
            return x.f38692a;
        L21:
            if (d.h.b.o.a(r8, com.obric.aiagent.skill.ovirt.impl.ui.a.c.C0453a.f21528a) == false) goto L25;
            ShellManagementActivity.access$renderUsageHidden(this.f21464b);     // Catch: Throwable -> L7 CancellationException -> L9
            goto L38
        L25:
            if (d.h.b.o.a(r8, com.obric.aiagent.skill.ovirt.impl.ui.a.c.d.f21531a) == false) goto L28;
            ILogDepend.Companion.w(ShellManagementActivity.TAG, "refreshUsage: timed out");     // Catch: Throwable -> L7 CancellationException -> L9
            goto L38
        L28:
            if (d.h.b.o.a(r8, com.obric.aiagent.skill.ovirt.impl.ui.a.c.e.f21532a) == false) goto L30;
        L34:
            ILogDepend.Companion.w(ShellManagementActivity.TAG, "refreshUsage: failed");     // Catch: Throwable -> L7 CancellationException -> L9
            goto L38
        L30:
            if (d.h.b.o.a(r8, com.obric.aiagent.skill.ovirt.impl.ui.a.c.b.f21529a) == true) goto L34;
            throw new k();     // Catch: Throwable -> L7 CancellationException -> L9
        L12:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L13:
            o.a(r7);
            g r9 = (g) ZeusTransformUtils.preCheckCast(bd.c(), g.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L7 CancellationException -> L9
            m r2 = (m) ZeusTransformUtils.preCheckCast(new a(this.f21464b, null), m.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L7 CancellationException -> L9
            d r4 = (d) ZeusTransformUtils.preCheckCast(this, d.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L7 CancellationException -> L9
            this.f21463a = 1;     // Catch: Throwable -> L7 CancellationException -> L9
            r7 = i.a(r9, r2, r4);     // Catch: Throwable -> L7 CancellationException -> L9
            if (r7 != r0) goto L17;
            return r0;
        L9:
            e = move-exception;
            throw e;
        L7:
            th = move-exception;
            ShellManagementActivity.access$logFailure(this.f21464b, "refreshUsage failed", th);
            goto L38
        }
    }

    static {
        Companion = new a(null);
    }

    /* JADX INFO: renamed from: lambda$1yIvbDdayla-Barr0CdMUA7FKmQ, reason: not valid java name */
    public static /* synthetic */ x m363lambda$1yIvbDdaylaBarr0CdMUA7FKmQ(ShellManagementActivity r0, DialogInterface r1, int r2) {
        return showClearConfirmDialog$lambda$5(r0, r1, r2);
    }

    /* JADX INFO: renamed from: lambda$BiaYGk_Xkj-26dKCu4QmQ1gpfLg, reason: not valid java name */
    public static /* synthetic */ x m364lambda$BiaYGk_Xkj26dKCu4QmQ1gpfLg(DialogInterface r0, int r1) {
        return showClearConfirmDialog$lambda$6(r0, r1);
    }

    public static /* synthetic */ void lambda$Egy28VZ09ggQKGO68gPLofnlo4g(ShellManagementActivity r0, View r1) {
        setupContent$lambda$4$lambda$3(r0, r1);
    }

    public static /* synthetic */ void lambda$jbMImvM8Lf4poKxEH5GhfRew15E(ShellManagementActivity r0, View r1) {
        setupTitleBar$lambda$1$lambda$0(r0, r1);
    }

    public ShellManagementActivity() {
    }

    public static final /* synthetic */ com.obric.aiagent.skill.ovirt.impl.b.b access$getBinding$p(ShellManagementActivity r2) {
        return ((ShellManagementActivity) ZeusTransformUtils.wrapperContextForParams(r2, ShellManagementActivity.class, "com.obric.aiagent.plugin")).binding;
    }

    public static final /* synthetic */ com.obric.aiagent.skill.ovirt.impl.ui.a access$getRepository$p(ShellManagementActivity r2) {
        return ((ShellManagementActivity) ZeusTransformUtils.wrapperContextForParams(r2, ShellManagementActivity.class, "com.obric.aiagent.plugin")).repository;
    }

    public static final /* synthetic */ void access$logFailure(ShellManagementActivity r2, String r3, Throwable r4) {
        ((ShellManagementActivity) ZeusTransformUtils.wrapperContextForParams(r2, ShellManagementActivity.class, "com.obric.aiagent.plugin")).logFailure(r3, r4);
    }

    public static final /* synthetic */ void access$refreshUsage(ShellManagementActivity r2) {
        ((ShellManagementActivity) ZeusTransformUtils.wrapperContextForParams(r2, ShellManagementActivity.class, "com.obric.aiagent.plugin")).refreshUsage();
    }

    public static final /* synthetic */ void access$renderUsageHidden(ShellManagementActivity r2) {
        ((ShellManagementActivity) ZeusTransformUtils.wrapperContextForParams(r2, ShellManagementActivity.class, "com.obric.aiagent.plugin")).renderUsageHidden();
    }

    public static final /* synthetic */ void access$renderUsageVisible(ShellManagementActivity r2, String r3) {
        ((ShellManagementActivity) ZeusTransformUtils.wrapperContextForParams(r2, ShellManagementActivity.class, "com.obric.aiagent.plugin")).renderUsageVisible(r3);
    }

    public static final /* synthetic */ void access$showToast(ShellManagementActivity r2, String r3) {
        ((ShellManagementActivity) ZeusTransformUtils.wrapperContextForParams(r2, ShellManagementActivity.class, "com.obric.aiagent.plugin")).showToast(r3);
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity
    public void onCreate(Bundle r5) {
        super.onCreate(r5);
        com.obric.aiagent.skill.ovirt.impl.ui.b.a((AppCompatActivity) ZeusTransformUtils.preCheckCast(this, AppCompatActivity.class, "com.obric.aiagent.plugin"));
        com.obric.aiagent.skill.ovirt.impl.b.b r6 = com.obric.aiagent.skill.ovirt.impl.b.b.a(getLayoutInflater());
        d.h.b.o.c(r6, "inflate(...)");
        this.binding = r6;
        this.repository = new com.obric.aiagent.skill.ovirt.impl.ui.a((Context) ZeusTransformUtils.preCheckCast(this, Context.class, "com.obric.aiagent.plugin"));
        com.obric.aiagent.skill.ovirt.impl.b.b r7 = this.binding;
        com.obric.aiagent.skill.ovirt.impl.b.b r1 = null;
        if (r7 != null) goto L5;
        d.h.b.o.c("binding");
        r7 = null;
    L5:
        setContentView((View) ZeusTransformUtils.preCheckCast(r7.b(), View.class, "com.obric.aiagent.plugin"));
        setupTitleBar();
        setupContent();
        com.obric.aiagent.skill.ovirt.impl.b.b r8 = this.binding;
        if (r8 != null) goto L8;
        d.h.b.o.c("binding");
        r8 = null;
    L8:
        LinearLayout r9 = r8.f21116a;
        d.h.b.o.c(r9, "contentContainer");
        View r10 = (View) ZeusTransformUtils.preCheckCast(r9, View.class, "com.obric.aiagent.plugin");
        com.obric.aiagent.skill.ovirt.impl.b.b r0 = this.binding;
        if (r0 != null) goto L11;
        d.h.b.o.c("binding");
    L12:
        OFloatingTitleBar r2 = r1.g;
        d.h.b.o.c(r2, "titleBar");
        com.obric.aiagent.skill.ovirt.impl.ui.b.a(r10, r2);
        refreshUsage();
        return;
    L11:
        r1 = r0;
        goto L12
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity
    public void onDestroy() {
        ca r0 = this.usageJob;
        if (r0 == null) goto L5;
        ca.a.a(r0, null, 1, null);
    L5:
        ca r1 = this.clearJob;
        if (r1 == null) goto L8;
        ca.a.a(r1, null, 1, null);
    L8:
        super.onDestroy();
    }

    private final void setupTitleBar() {
        com.obric.aiagent.skill.ovirt.impl.b.b r0 = this.binding;
        if (r0 != null) goto L5;
        d.h.b.o.c("binding");
        r0 = null;
    L5:
        OFloatingTitleBar r1 = r0.g;
        r1.setFloatingTransitionEnabled(true);
        OFloatingTitleBar.removeAllStartAction$default(r1, false, 1, null);
        OFloatingTitleBar.removeAllEndAction$default(r1, false, 1, null);
        r1.setCenterTitle(ZeusTransformUtils.mapRes(R.string.obric_skill_shell_management_title, WsChannelMultiProcessSharedProvider.STRING_TYPE, "obric_skill_shell_management_title"));
        OFloatingTitleBar.addStartAction$default(r1, ZeusTransformUtils.mapRes(R.drawable.o_floating_title_bar_icon_back, "drawable", "o_floating_title_bar_icon_back"), 0, new $$Lambda$ShellManagementActivity$jbMImvM8Lf4poKxEH5GhfRew15E(this), 2, null);
        r1.removeCenterCustomView();
        r1.showCenterCustomView(false);
    }

    private static final void setupTitleBar$lambda$1$lambda$0(ShellManagementActivity r1, View r2) {
        ((ShellManagementActivity) ZeusTransformUtils.wrapperContextForParams(r1, ShellManagementActivity.class, "com.obric.aiagent.plugin")).finish();
    }

    private final void setupContent() {
        com.obric.aiagent.skill.ovirt.impl.b.b r0 = this.binding;
        if (r0 != null) goto L5;
        d.h.b.o.c("binding");
        r0 = null;
    L5:
        OCardListItem r1 = r0.f;
        r1.setCardType(0);
        OCardListItem.setCardPosition$default(r1, 0, false, 2, null);
        r1.showSubTitle(true);
        r1.showTailIcon(false);
        r1.showCustomEnd(true);
        OCardListItem.setEndDetailText$default(r1, (CharSequence) ZeusTransformUtils.preCheckCast(getString(ZeusTransformUtils.mapRes(R.string.obric_skill_shell_usage_calculating, WsChannelMultiProcessSharedProvider.STRING_TYPE, "obric_skill_shell_usage_calculating")), CharSequence.class, "com.obric.aiagent.plugin"), 0, 2, null);
        com.obric.aiagent.skill.ovirt.impl.b.b r2 = this.binding;
        if (r2 != null) goto L8;
        d.h.b.o.c("binding");
        r2 = null;
    L8:
        OCardListItem r3 = r2.f21118c;
        r3.setCardType(0);
        OCardListItem.setCardPosition$default(r3, 0, false, 2, null);
        r3.showSubTitle(false);
        r3.showTailIcon(false);
        r3.setOnContentClickListener(new $$Lambda$ShellManagementActivity$Egy28VZ09ggQKGO68gPLofnlo4g(this));
    }

    private static final void setupContent$lambda$4$lambda$3(ShellManagementActivity r1, View r2) {
        ((ShellManagementActivity) ZeusTransformUtils.wrapperContextForParams(r1, ShellManagementActivity.class, "com.obric.aiagent.plugin")).showClearConfirmDialog();
    }

    private final void refreshUsage() {
        ca r0 = this.usageJob;
        if (r0 == null) goto L5;
        ca.a.a(r0, null, 1, null);
    L5:
        com.obric.aiagent.skill.ovirt.impl.ui.a r1 = this.repository;
        if (r1 != null) goto L8;
        d.h.b.o.c("repository");
        r1 = null;
    L8:
        Long r2 = com.obric.aiagent.skill.ovirt.impl.ui.a.a(r1, 0, 1, null);
        if (r2 == null) goto L12;
        renderUsageVisible(com.obric.aiagent.skill.ovirt.impl.ui.a.f21521a.a(r2.longValue()));
        return;
    L12:
        String r3 = getString(ZeusTransformUtils.mapRes(R.string.obric_skill_shell_usage_calculating, WsChannelMultiProcessSharedProvider.STRING_TYPE, "obric_skill_shell_usage_calculating"));
        d.h.b.o.c(r3, "getString(...)");
        renderUsageVisible(r3);
        this.usageJob = i.a((am) ZeusTransformUtils.preCheckCast(q.a((p) ZeusTransformUtils.preCheckCast(this, p.class, "com.obric.aiagent.plugin")), am.class, "com.obric.aiagent.plugin"), null, null, (m) ZeusTransformUtils.preCheckCast(new c(this, null), m.class, "com.obric.aiagent.plugin"), 3, null);
    }

    private final void showClearConfirmDialog() {
        com.obric.oui.dialog.v2.alert.a r0 = com.obric.oui.dialog.v2.alert.a.a(com.obric.oui.dialog.v2.alert.a.a(new com.obric.oui.dialog.v2.alert.a((Context) ZeusTransformUtils.preCheckCast(this, Context.class, "com.obric.aiagent.plugin")).b(false), (CharSequence) ZeusTransformUtils.preCheckCast(getString(ZeusTransformUtils.mapRes(R.string.obric_skill_shell_clear_confirm_title, WsChannelMultiProcessSharedProvider.STRING_TYPE, "obric_skill_shell_clear_confirm_title")), CharSequence.class, "com.obric.aiagent.plugin"), false, 2, null).a((CharSequence) ZeusTransformUtils.preCheckCast(getString(ZeusTransformUtils.mapRes(R.string.obric_skill_shell_clear_confirm_message, WsChannelMultiProcessSharedProvider.STRING_TYPE, "obric_skill_shell_clear_confirm_message")), CharSequence.class, "com.obric.aiagent.plugin")), false, 1, null);
        String r1 = getString(ZeusTransformUtils.mapRes(R.string.obric_skill_shell_clear_confirm_clear, WsChannelMultiProcessSharedProvider.STRING_TYPE, "obric_skill_shell_clear_confirm_clear"));
        d.h.b.o.c(r1, "getString(...)");
        com.obric.oui.dialog.v2.alert.a r2 = r0.a((CharSequence) ZeusTransformUtils.preCheckCast(r1, CharSequence.class, "com.obric.aiagent.plugin"), new $$Lambda$ShellManagementActivity$1yIvbDdaylaBarr0CdMUA7FKmQ(this));
        String r7 = getString(ZeusTransformUtils.mapRes(R.string.obric_skill_shell_clear_confirm_cancel, WsChannelMultiProcessSharedProvider.STRING_TYPE, "obric_skill_shell_clear_confirm_cancel"));
        d.h.b.o.c(r7, "getString(...)");
        r2.b((CharSequence) ZeusTransformUtils.preCheckCast(r7, CharSequence.class, "com.obric.aiagent.plugin"), $$Lambda$ShellManagementActivity$BiaYGk_Xkj26dKCu4QmQ1gpfLg.INSTANCE).h();
    }

    private static final x showClearConfirmDialog$lambda$5(ShellManagementActivity r1, DialogInterface r2, int r3) {
        ShellManagementActivity r4 = (ShellManagementActivity) ZeusTransformUtils.wrapperContextForParams(r1, ShellManagementActivity.class, "com.obric.aiagent.plugin");
        DialogInterface r5 = (DialogInterface) ZeusTransformUtils.wrapperContextForParams(r2, DialogInterface.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r5, "dialog");
        r5.dismiss();
        r4.clearEnvironment();
        return x.f38692a;
    }

    private static final x showClearConfirmDialog$lambda$6(DialogInterface r1, int r2) {
        DialogInterface r3 = (DialogInterface) ZeusTransformUtils.wrapperContextForParams(r1, DialogInterface.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r3, "dialog");
        r3.dismiss();
        return x.f38692a;
    }

    private final void clearEnvironment() {
        ca r0 = this.clearJob;
        if (r0 == null) goto L5;
        ca.a.a(r0, null, 1, null);
    L5:
        com.obric.aiagent.skill.ovirt.impl.b.b r1 = this.binding;
        if (r1 != null) goto L8;
        d.h.b.o.c("binding");
        r1 = null;
    L8:
        r1.f21118c.setEnabled(false);
        this.clearJob = i.a((am) ZeusTransformUtils.preCheckCast(q.a((p) ZeusTransformUtils.preCheckCast(this, p.class, "com.obric.aiagent.plugin")), am.class, "com.obric.aiagent.plugin"), null, null, (m) ZeusTransformUtils.preCheckCast(new b(this, null), m.class, "com.obric.aiagent.plugin"), 3, null);
    }

    private final void renderUsageVisible(String r5) {
        com.obric.aiagent.skill.ovirt.impl.b.b r0 = this.binding;
        if (r0 != null) goto L5;
        d.h.b.o.c("binding");
        r0 = null;
    L5:
        r0.f21120e.setVisibility(0);
        com.obric.aiagent.skill.ovirt.impl.b.b r4 = this.binding;
        if (r4 != null) goto L8;
        d.h.b.o.c("binding");
        r4 = null;
    L8:
        OCardListItem.setEndDetailText$default(r4.f, (CharSequence) ZeusTransformUtils.preCheckCast(r5, CharSequence.class, "com.obric.aiagent.plugin"), 0, 2, null);
    }

    private final void renderUsageHidden() {
        com.obric.aiagent.skill.ovirt.impl.b.b r1 = this.binding;
        if (r1 != null) goto L5;
        d.h.b.o.c("binding");
        r1 = null;
    L5:
        r1.f21120e.setVisibility(8);
    }

    private final void showToast(String r7) {
        OToast.a.a(OToast.f36774a, (Context) ZeusTransformUtils.preCheckCast(this, Context.class, "com.obric.aiagent.plugin"), r7, 0, 4, null);
    }

    private final void logFailure(String r2, Throwable r3) {
        if (IAppContext.Companion.isDebug() == false) goto L5;
        ILogDepend.Companion.e(TAG, r2, r3);
        return;
    L5:
        ILogDepend.Companion.w(TAG, r2);
    }
}
