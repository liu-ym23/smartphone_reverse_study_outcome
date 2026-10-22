package com.obric.aiagent.skill.manager.impl.ui;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.bdturing.localstorage.DbHelper;
import com.bytedance.common.wschannel.WsChannelMultiProcessSharedProvider;
import com.obric.aiagent.plugin.R;
import com.obric.aiagent.skill.manager.api.ISkillManagerService;
import com.obric.aiagent.skill.manager.impl.SkillManager;
import com.obric.aiagent.skill.manager.impl.dr;
import com.obric.aiagent.skill.manager.impl.du;
import com.obric.aiagent.skill.manager.impl.ee;
import com.obric.aiagent.skill.manager.impl.gx;
import com.obric.oui.orecyclerview.widget.LinearLayoutManager;
import com.obric.oui.orecyclerview.widget.RecyclerView;
import com.obric.oui.tab.OTabLayout;
import com.obric.oui.tab.OTabLayoutBase;
import com.obric.oui.titlebar.OFloatingTitleBar;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CancellationException;
import kotlinx.coroutines.cx;

/* JADX INFO: compiled from: SkillManagementActivity.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class SkillManagementActivity extends SkillGatedActivity {
    public static final a Companion = null;
    private x createFlowController;
    private kotlinx.coroutines.ca decisionRefreshJob;
    private boolean decisionRefreshRequested;
    private final d.f enterPageTracker$delegate;
    private com.obric.aiagent.skill.manager.impl.ui.g interactionController;
    private final kotlinx.coroutines.am ioScope;
    private final ArrayList<com.obric.aiagent.skill.manager.api.e> latestSkills;
    private final kotlinx.coroutines.am mainScope;
    private boolean managementPageVisible;
    private View myEmpty;
    private com.obric.aiagent.skill.manager.impl.ui.h mySkillAdapter;
    private OTabLayout myTabs;
    private b selectedMyTab;
    private ISkillManagerService skillManager;
    private kotlinx.coroutines.ca skillStateJob;
    private kotlinx.coroutines.ca storeMetadataRefreshJob;
    private OFloatingTitleBar titleBar;

    /* JADX INFO: compiled from: SkillManagementActivity.kt */
    public static final class a {
        public /* synthetic */ a(d.h.b.h r1) {
            this();
        }

        private a() {
        }

        public final Intent a(Context r2, du r3) {
            Context r1 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin");
            d.h.b.o.e(r1, "context");
            d.h.b.o.e(r3, "trackingSource");
            return bo.a(new Intent(r1, SkillManagementActivity.class), r3);
        }
    }

    /* JADX INFO: compiled from: SkillManagementActivity.kt */
    private static final enum b extends Enum<b> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final b f20336a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final b f20337b = null;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private static final /* synthetic */ b[] f20338c = null;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private static final /* synthetic */ d.d.a f20339d = null;

        private static final /* synthetic */ b[] a() {
            return new b[]{f20336a, f20337b};
        }

        private b(String r1, int r2) {
            super(r1, r2);
        }

        static {
            f20336a = new b("CREATED", 0);
            f20337b = new b("ADDED", 1);
            b[] r0 = a();
            f20338c = r0;
            f20339d = d.d.b.a((Enum[]) ZeusTransformUtils.preCheckCast(r0, Enum[].class, "com.obric.aiagent.plugin"));
        }

        public static b valueOf(String r2) {
            return (b) ZeusTransformUtils.preCheckCast(Enum.valueOf(b.class, r2), b.class, "com.obric.aiagent.plugin");
        }

        public static b[] values() {
            return (b[]) ZeusTransformUtils.preCheckCast(f20338c.clone(), b[].class, "com.obric.aiagent.plugin");
        }
    }

    /* JADX INFO: compiled from: SkillManagementActivity.kt */
    @d.c.b.a.f(b = "SkillManagementActivity.kt", c = {}, d = "invokeSuspend", e = "com.obric.aiagent.skill.manager.impl.ui.SkillManagementActivity$ensureSkillObserverStarted$1")
    static final class c extends d.c.b.a.l implements d.h.a.m<kotlinx.coroutines.am, d.c.d<? super d.x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f20340a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ kotlinx.coroutines.b.ak<List<com.obric.aiagent.skill.manager.api.e>> f20341b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ SkillManagementActivity f20342c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private /* synthetic */ Object f20343d;

        /* JADX INFO: renamed from: com.obric.aiagent.skill.manager.impl.ui.SkillManagementActivity$c$1, reason: invalid class name */
        /* JADX INFO: compiled from: SkillManagementActivity.kt */
        @d.c.b.a.f(b = "SkillManagementActivity.kt", c = {299}, d = "invokeSuspend", e = "com.obric.aiagent.skill.manager.impl.ui.SkillManagementActivity$ensureSkillObserverStarted$1$1")
        static final class AnonymousClass1 extends d.c.b.a.l implements d.h.a.m<kotlinx.coroutines.am, d.c.d<? super d.x>, Object> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            int f20344a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ kotlinx.coroutines.b.ak<List<com.obric.aiagent.skill.manager.api.e>> f20345b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            final /* synthetic */ SkillManagementActivity f20346c;

            AnonymousClass1(kotlinx.coroutines.b.ak<? extends List<com.obric.aiagent.skill.manager.api.e>> r3, SkillManagementActivity r4, d.c.d<? super AnonymousClass1> r5) {
                kotlinx.coroutines.b.ak<List<com.obric.aiagent.skill.manager.api.e>> r6 = (kotlinx.coroutines.b.ak) ZeusTransformUtils.wrapperContextForParams(r3, kotlinx.coroutines.b.ak.class, "com.obric.aiagent.plugin");
                SkillManagementActivity r7 = (SkillManagementActivity) ZeusTransformUtils.wrapperContextForParams(r4, SkillManagementActivity.class, "com.obric.aiagent.plugin");
                d.c.d r8 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
                this.f20345b = r6;
                this.f20346c = r7;
                super(2, r8);
            }

            public final Object a(kotlinx.coroutines.am r3, d.c.d<? super d.x> r4) {
                return ((AnonymousClass1) ZeusTransformUtils.preCheckCast(create((kotlinx.coroutines.am) ZeusTransformUtils.wrapperContextForParams(r3, kotlinx.coroutines.am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), AnonymousClass1.class, "com.obric.aiagent.plugin")).invokeSuspend(d.x.f38692a);
            }

            @Override // d.c.b.a.a
            public final d.c.d<d.x> create(Object r3, d.c.d<?> r4) {
                d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
                return (d.c.d) ZeusTransformUtils.preCheckCast(new AnonymousClass1(this.f20345b, this.f20346c, r5), d.c.d.class, "com.obric.aiagent.plugin");
            }

            @Override // d.h.a.m
            public /* synthetic */ Object invoke(kotlinx.coroutines.am r3, d.c.d<? super d.x> r4) {
                return a((kotlinx.coroutines.am) ZeusTransformUtils.preCheckCast(r3, kotlinx.coroutines.am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
            }

            @Override // d.c.b.a.a
            public final Object invokeSuspend(Object r6) {
                Object r0 = d.c.a.b.a();
                int r1 = this.f20344a;
                if (r1 == 0) goto L8;
                if (r1 != 1) goto L6;
                d.o.a(r6);
            L12:
                throw new d.d();
            L6:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            L8:
                d.o.a(r6);
                kotlinx.coroutines.b.ak<List<com.obric.aiagent.skill.manager.api.e>> r7 = this.f20345b;
                final SkillManagementActivity r3 = this.f20346c;
                kotlinx.coroutines.b.i<? super List<com.obric.aiagent.skill.manager.api.e>> r2 = (kotlinx.coroutines.b.i) ZeusTransformUtils.preCheckCast(new C04271(r3), kotlinx.coroutines.b.i.class, "com.obric.aiagent.plugin");
                d.c.d<?> r4 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
                this.f20344a = 1;
                if (r7.collect(r2, r4) != r0) goto L12;
                return r0;
            }
        }

        c(kotlinx.coroutines.b.ak<? extends List<com.obric.aiagent.skill.manager.api.e>> r3, SkillManagementActivity r4, d.c.d<? super c> r5) {
            kotlinx.coroutines.b.ak<List<com.obric.aiagent.skill.manager.api.e>> r6 = (kotlinx.coroutines.b.ak) ZeusTransformUtils.wrapperContextForParams(r3, kotlinx.coroutines.b.ak.class, "com.obric.aiagent.plugin");
            SkillManagementActivity r7 = (SkillManagementActivity) ZeusTransformUtils.wrapperContextForParams(r4, SkillManagementActivity.class, "com.obric.aiagent.plugin");
            d.c.d r8 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
            this.f20341b = r6;
            this.f20342c = r7;
            super(2, r8);
        }

        public final Object a(kotlinx.coroutines.am r3, d.c.d<? super d.x> r4) {
            return ((c) ZeusTransformUtils.preCheckCast(create((kotlinx.coroutines.am) ZeusTransformUtils.wrapperContextForParams(r3, kotlinx.coroutines.am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), c.class, "com.obric.aiagent.plugin")).invokeSuspend(d.x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<d.x> create(Object r4, d.c.d<?> r5) {
            d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
            c r0 = new c(this.f20341b, this.f20342c, r6);
            r0.f20343d = r4;
            return (d.c.d) ZeusTransformUtils.preCheckCast(r0, d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(kotlinx.coroutines.am r3, d.c.d<? super d.x> r4) {
            return a((kotlinx.coroutines.am) ZeusTransformUtils.preCheckCast(r3, kotlinx.coroutines.am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r9) {
            d.c.a.b.a();
            if (this.f20340a != 0) goto L14;
            d.o.a(r9);
            kotlinx.coroutines.am r2 = (kotlinx.coroutines.am) ZeusTransformUtils.preCheckCast(this.f20343d, kotlinx.coroutines.am.class, "com.obric.aiagent.plugin");
            kotlinx.coroutines.i.a(r2, null, null, (d.h.a.m) ZeusTransformUtils.preCheckCast(new AnonymousClass1(this.f20341b, this.f20342c, null), d.h.a.m.class, "com.obric.aiagent.plugin"), 3, null);     // Catch: Exception -> L7 CancellationException -> L11
        L10:
            return d.x.f38692a;
        L11:
            e = move-exception;
            throw e;
        L7:
            e = move-exception;
            ee.f19808a.a("SkillManager", "Observe installed skills failed on management page", "Observe installed skills failed on management page", (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.aiagent.plugin"));
            goto L10
        L14:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: compiled from: SkillManagementActivity.kt */
    /* synthetic */ class d extends d.h.b.l implements d.h.a.b<ISkillManagerService, d.x> {
        d(Object r8) {
            super(1, r8, SkillManagementActivity.class, "initializeSkillPage", "initializeSkillPage(Lcom/obric/aiagent/skill/manager/api/ISkillManagerService;)V", 0);
        }

        public final void a(ISkillManagerService r3) {
            ISkillManagerService r4 = (ISkillManagerService) ZeusTransformUtils.wrapperContextForParams(r3, ISkillManagerService.class, "com.obric.aiagent.plugin");
            d.h.b.o.e(r4, "p0");
            SkillManagementActivity.access$initializeSkillPage((SkillManagementActivity) ZeusTransformUtils.preCheckCast(this.receiver, SkillManagementActivity.class, "com.obric.aiagent.plugin"), r4);
        }

        @Override // d.h.a.b
        public /* synthetic */ d.x invoke(ISkillManagerService r3) {
            a((ISkillManagerService) ZeusTransformUtils.preCheckCast(r3, ISkillManagerService.class, "com.obric.aiagent.plugin"));
            return d.x.f38692a;
        }
    }

    /* JADX INFO: compiled from: SkillManagementActivity.kt */
    @d.c.b.a.f(b = "SkillManagementActivity.kt", c = {366}, d = "invokeSuspend", e = "com.obric.aiagent.skill.manager.impl.ui.SkillManagementActivity$refreshInstalledStoreMetadata$1")
    static final class e extends d.c.b.a.l implements d.h.a.m<kotlinx.coroutines.am, d.c.d<? super d.x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f20351a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ SkillManager f20352b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ Set<String> f20353c;

        e(SkillManager r3, Set<String> r4, d.c.d<? super e> r5) {
            Set<String> r6 = (Set) ZeusTransformUtils.wrapperContextForParams(r4, Set.class, "com.obric.aiagent.plugin");
            d.c.d r7 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
            this.f20352b = r3;
            this.f20353c = r6;
            super(2, r7);
        }

        public final Object a(kotlinx.coroutines.am r3, d.c.d<? super d.x> r4) {
            return ((e) ZeusTransformUtils.preCheckCast(create((kotlinx.coroutines.am) ZeusTransformUtils.wrapperContextForParams(r3, kotlinx.coroutines.am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), e.class, "com.obric.aiagent.plugin")).invokeSuspend(d.x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<d.x> create(Object r3, d.c.d<?> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new e(this.f20352b, this.f20353c, r5), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(kotlinx.coroutines.am r3, d.c.d<? super d.x> r4) {
            return a((kotlinx.coroutines.am) ZeusTransformUtils.preCheckCast(r3, kotlinx.coroutines.am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r6) {
            Object r0 = d.c.a.b.a();
            int r1 = this.f20351a;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            d.o.a(r6);
        L11:
            gx r5 = (gx) ZeusTransformUtils.preCheckCast(r6, gx.class, "com.obric.aiagent.plugin");
            if (r5.b() <= 0) goto L15;
            ee.f19808a.c("SkillManager", "Management Store Skill presentation refresh partially failed", "Management Store Skill presentation refresh partially failed: failures=" + r5.b() + ", total=" + r5.a().size());
        L15:
            return d.x.f38692a;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            d.o.a(r6);
            SkillManager r7 = this.f20352b;
            Set<String> r2 = this.f20353c;
            d.c.d<? super gx> r4 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.f20351a = 1;
            r6 = r7.refreshInstalledStoreMetadata$impl_release(r2, r4);
            if (r6 != r0) goto L11;
            return r0;
        }
    }

    /* JADX INFO: compiled from: SkillManagementActivity.kt */
    /* synthetic */ class g extends d.h.b.l implements d.h.a.b<String, Boolean> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final g f20355a = null;

        static {
            f20355a = new g();
        }

        g() {
            super(1, d.o.o.class, "isNotBlank", "isNotBlank(Ljava/lang/CharSequence;)Z", 1);
        }

        public final Boolean a(String r2) {
            d.h.b.o.e(r2, "p0");
            return Boolean.valueOf(!d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast(r2, CharSequence.class, "com.obric.aiagent.plugin")));
        }

        @Override // d.h.a.b
        public /* synthetic */ Boolean invoke(String r3) {
            return a((String) ZeusTransformUtils.preCheckCast(r3, String.class, "com.obric.aiagent.plugin"));
        }
    }

    /* JADX INFO: compiled from: SkillManagementActivity.kt */
    @d.c.b.a.f(b = "SkillManagementActivity.kt", c = {335, 340}, d = "invokeSuspend", e = "com.obric.aiagent.skill.manager.impl.ui.SkillManagementActivity$requestDecisionRefreshOnce$1")
    static final class h extends d.c.b.a.l implements d.h.a.m<kotlinx.coroutines.am, d.c.d<? super d.x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f20356a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ Set<String> f20357b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ ISkillManagerService f20358c;

        h(Set<String> r3, ISkillManagerService r4, d.c.d<? super h> r5) {
            Set<String> r6 = (Set) ZeusTransformUtils.wrapperContextForParams(r3, Set.class, "com.obric.aiagent.plugin");
            ISkillManagerService r7 = (ISkillManagerService) ZeusTransformUtils.wrapperContextForParams(r4, ISkillManagerService.class, "com.obric.aiagent.plugin");
            d.c.d r8 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
            this.f20357b = r6;
            this.f20358c = r7;
            super(2, r8);
        }

        public final Object a(kotlinx.coroutines.am r3, d.c.d<? super d.x> r4) {
            return ((h) ZeusTransformUtils.preCheckCast(create((kotlinx.coroutines.am) ZeusTransformUtils.wrapperContextForParams(r3, kotlinx.coroutines.am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), h.class, "com.obric.aiagent.plugin")).invokeSuspend(d.x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<d.x> create(Object r3, d.c.d<?> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new h(this.f20357b, this.f20358c, r5), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(kotlinx.coroutines.am r3, d.c.d<? super d.x> r4) {
            return a((kotlinx.coroutines.am) ZeusTransformUtils.preCheckCast(r3, kotlinx.coroutines.am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r7) {
            Object r0 = d.c.a.b.a();
            int r1 = this.f20356a;
            if (r1 == 0) goto L10;
            if (r1 == 1) goto L9;
            if (r1 != 2) goto L8;
            d.o.a(r7);
        L19:
            com.obric.aiagent.skill.manager.api.u r6 = (com.obric.aiagent.skill.manager.api.u) ZeusTransformUtils.preCheckCast(r7, com.obric.aiagent.skill.manager.api.u.class, "com.obric.aiagent.plugin");
        L21:
            if (ZeusTransformUtils.instanceOf(r6, com.obric.aiagent.skill.manager.api.u.a.class) == false) goto L24;
            ee.f19808a.c("SkillManager", "Management Skill security refresh failed", "Management Skill security refresh failed: code=" + ((com.obric.aiagent.skill.manager.api.u.a) ZeusTransformUtils.preCheckCast(r6, com.obric.aiagent.skill.manager.api.u.a.class, "com.obric.aiagent.plugin")).a());
        L24:
            return d.x.f38692a;
        L8:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L9:
            d.o.a(r7);
        L15:
            r6 = (com.obric.aiagent.skill.manager.api.u) ZeusTransformUtils.preCheckCast(r7, com.obric.aiagent.skill.manager.api.u.class, "com.obric.aiagent.plugin");
            goto L21
        L10:
            d.o.a(r7);
            com.obric.aiagent.skill.manager.api.ap.b r8 = new com.obric.aiagent.skill.manager.api.ap.b(this.f20357b);
            if (ZeusTransformUtils.instanceOf(this.f20358c, SkillManager.class) == false) goto L16;
            SkillManager r2 = (SkillManager) ZeusTransformUtils.preCheckCast(this.f20358c, SkillManager.class, "com.obric.aiagent.plugin");
            com.obric.aiagent.skill.manager.api.ap r9 = (com.obric.aiagent.skill.manager.api.ap) ZeusTransformUtils.preCheckCast(r8, com.obric.aiagent.skill.manager.api.ap.class, "com.obric.aiagent.plugin");
            com.obric.aiagent.skill.manager.impl.aw r3 = com.obric.aiagent.skill.manager.impl.aw.f;
            d.c.d<? super com.obric.aiagent.skill.manager.api.u<com.obric.aiagent.skill.manager.api.ao>> r5 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.f20356a = 1;
            r7 = r2.refreshSkillSignatures$impl_release(r9, r3, r5);
            if (r7 != r0) goto L15;
            return r0;
        L16:
            ISkillManagerService r4 = this.f20358c;
            com.obric.aiagent.skill.manager.api.ap r10 = (com.obric.aiagent.skill.manager.api.ap) ZeusTransformUtils.preCheckCast(r8, com.obric.aiagent.skill.manager.api.ap.class, "com.obric.aiagent.plugin");
            d.c.d<? super com.obric.aiagent.skill.manager.api.u<com.obric.aiagent.skill.manager.api.ao>> r11 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.f20356a = 2;
            r7 = r4.refreshSkillSignatures(r10, r11);
            if (r7 != r0) goto L19;
            return r0;
        }
    }

    /* JADX INFO: compiled from: SkillManagementActivity.kt */
    /* synthetic */ class i extends d.h.b.l implements d.h.a.b<com.obric.aiagent.skill.manager.api.e, Boolean> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final i f20359a = null;

        static {
            f20359a = new i();
        }

        i() {
            super(1, com.obric.aiagent.skill.manager.impl.az.class, "requiresLocalSigning", "requiresLocalSigning(Lcom/obric/aiagent/skill/manager/api/Skill;)Z", 1);
        }

        public final Boolean a(com.obric.aiagent.skill.manager.api.e r1) {
            d.h.b.o.e(r1, "p0");
            return Boolean.valueOf(com.obric.aiagent.skill.manager.impl.az.b(r1));
        }

        @Override // d.h.a.b
        public /* synthetic */ Boolean invoke(com.obric.aiagent.skill.manager.api.e r3) {
            return a((com.obric.aiagent.skill.manager.api.e) ZeusTransformUtils.preCheckCast(r3, com.obric.aiagent.skill.manager.api.e.class, "com.obric.aiagent.plugin"));
        }
    }

    /* JADX INFO: compiled from: SkillManagementActivity.kt */
    /* synthetic */ class k extends d.h.b.l implements d.h.a.b<String, Boolean> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final k f20361a = null;

        static {
            f20361a = new k();
        }

        k() {
            super(1, d.o.o.class, "isNotBlank", "isNotBlank(Ljava/lang/CharSequence;)Z", 1);
        }

        public final Boolean a(String r2) {
            d.h.b.o.e(r2, "p0");
            return Boolean.valueOf(!d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast(r2, CharSequence.class, "com.obric.aiagent.plugin")));
        }

        @Override // d.h.a.b
        public /* synthetic */ Boolean invoke(String r3) {
            return a((String) ZeusTransformUtils.preCheckCast(r3, String.class, "com.obric.aiagent.plugin"));
        }
    }

    /* JADX INFO: compiled from: SkillManagementActivity.kt */
    public static final class l implements OTabLayoutBase.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ SkillManagementActivity f20362a;

        @Override // com.obric.oui.tab.OTabLayoutBase.d
        public void b(OTabLayoutBase.e r1) {
            d.h.b.o.e(r1, "tab");
        }

        @Override // com.obric.oui.tab.OTabLayoutBase.d
        public void c(OTabLayoutBase.e r1) {
            d.h.b.o.e(r1, "tab");
        }

        l(SkillManagementActivity r3) {
            this.f20362a = (SkillManagementActivity) ZeusTransformUtils.wrapperContextForParams(r3, SkillManagementActivity.class, "com.obric.aiagent.plugin");
        }

        @Override // com.obric.oui.tab.OTabLayoutBase.d
        public void a(OTabLayoutBase.e r2) {
            d.h.b.o.e(r2, "tab");
            SkillManagementActivity r0 = this.f20362a;
            SkillManagementActivity.access$setSelectedMyTab$p(r0, SkillManagementActivity.access$myTabForPosition(r0, r2.c()));
            SkillManagementActivity.access$renderMySkills(this.f20362a);
        }
    }

    /* JADX INFO: compiled from: SkillManagementActivity.kt */
    /* synthetic */ class m extends d.h.b.l implements d.h.a.b<com.obric.aiagent.skill.manager.api.e, d.x> {
        m(Object r8) {
            super(1, r8, com.obric.aiagent.skill.manager.impl.ui.g.class, "onToggleRequested", "onToggleRequested(Lcom/obric/aiagent/skill/manager/api/Skill;)V", 0);
        }

        public final void a(com.obric.aiagent.skill.manager.api.e r3) {
            d.h.b.o.e(r3, "p0");
            ((com.obric.aiagent.skill.manager.impl.ui.g) ZeusTransformUtils.preCheckCast(this.receiver, com.obric.aiagent.skill.manager.impl.ui.g.class, "com.obric.aiagent.plugin")).a(r3);
        }

        @Override // d.h.a.b
        public /* synthetic */ d.x invoke(com.obric.aiagent.skill.manager.api.e r3) {
            a((com.obric.aiagent.skill.manager.api.e) ZeusTransformUtils.preCheckCast(r3, com.obric.aiagent.skill.manager.api.e.class, "com.obric.aiagent.plugin"));
            return d.x.f38692a;
        }
    }

    /* JADX INFO: compiled from: SkillManagementActivity.kt */
    /* synthetic */ class n extends d.h.b.l implements d.h.a.a<d.x> {
        n(Object r8) {
            super(0, r8, com.obric.aiagent.skill.manager.impl.ui.g.class, "onSecurityBlocked", "onSecurityBlocked()V", 0);
        }

        public final void a() {
            ((com.obric.aiagent.skill.manager.impl.ui.g) ZeusTransformUtils.preCheckCast(this.receiver, com.obric.aiagent.skill.manager.impl.ui.g.class, "com.obric.aiagent.plugin")).a();
        }

        @Override // d.h.a.a
        public /* synthetic */ d.x invoke() {
            a();
            return d.x.f38692a;
        }
    }

    static {
        Companion = new a(null);
    }

    public static /* synthetic */ void lambda$3H1WYpo_nPpjFDCXCNxA1lgKw5U(SkillManagementActivity r0, int r1) {
        updateMyTabs$lambda$11(r0, r1);
    }

    public static /* synthetic */ d.x lambda$8PPRyWucQJVAzLjEXNZ8ujkcCl4(SkillManagementActivity r0, String r1) {
        return createCreateFlowController$lambda$3(r0, r1);
    }

    /* JADX INFO: renamed from: lambda$CuCXeQzESq8WxR4-RGV2LEMMwV0, reason: not valid java name */
    public static /* synthetic */ ISkillManagerService m308lambda$CuCXeQzESq8WxR4RGV2LEMMwV0(SkillManagementActivity r0) {
        return setupMyPage$lambda$6(r0);
    }

    public static /* synthetic */ d.x lambda$Ymrn17_sgj_uWuIWMyMjJaw5Xqo(SkillManagementActivity r0, com.obric.aiagent.skill.manager.api.e r1) {
        return setupMyPage$lambda$8(r0, r1);
    }

    public static /* synthetic */ ISkillManagerService lambda$cy_f1QQ0zzSJphwz1XsCXpFQdQE(SkillManagementActivity r0) {
        return createCreateFlowController$lambda$2(r0);
    }

    public static /* synthetic */ void lambda$kMhwkJX3nM_2qSigXdIhquZAT8c(SkillManagementActivity r0, View r1) {
        setupMyPage$lambda$5(r0, r1);
    }

    /* JADX INFO: renamed from: lambda$mIHyvR3x-Fh373J0SuQ4zIMtQtU, reason: not valid java name */
    public static /* synthetic */ d.x m309lambda$mIHyvR3xFh373J0SuQ4zIMtQtU(SkillManagementActivity r0) {
        return setupMyPage$lambda$7(r0);
    }

    /* JADX INFO: renamed from: lambda$nx7HpfeN-FDFXrBd9L0iXp5hflA, reason: not valid java name */
    public static /* synthetic */ void m310lambda$nx7HpfeNFDFXrBd9L0iXp5hflA(SkillManagementActivity r0, View r1) {
        configureCreateButton$lambda$10$lambda$9(r0, r1);
    }

    /* JADX INFO: renamed from: lambda$uIuUaElCXcm-6vZWVHuNACTDRqc, reason: not valid java name */
    public static /* synthetic */ bp m311lambda$uIuUaElCXcm6vZWVHuNACTDRqc(SkillManagementActivity r0) {
        return enterPageTracker_delegate$lambda$1$lambda$0(r0);
    }

    public static /* synthetic */ boolean lambda$vyKcKKeFSe0h2xYFoNNWiolyQbg(com.obric.aiagent.skill.manager.api.e r0) {
        return refreshInstalledStoreMetadata$lambda$15(r0);
    }

    /* JADX INFO: renamed from: lambda$xQqzcTrkqnHFGztc-rJ1Qq_nM1I, reason: not valid java name */
    public static /* synthetic */ void m312lambda$xQqzcTrkqnHFGztcrJ1Qq_nM1I(SkillManagementActivity r0, View r1) {
        setupMyPage$lambda$4(r0, r1);
    }

    /* JADX INFO: renamed from: lambda$zP-W5yl_XPLRiR2mzVbZ7xK9QD8, reason: not valid java name */
    public static /* synthetic */ ag m313lambda$zPW5yl_XPLRiR2mzVbZ7xK9QD8(SkillManagementActivity r0) {
        return enterPageTracker_delegate$lambda$1(r0);
    }

    public SkillManagementActivity() {
        this.latestSkills = new ArrayList();
        this.ioScope = kotlinx.coroutines.an.a(kotlinx.coroutines.bd.c().plus((d.c.g) ZeusTransformUtils.preCheckCast(cx.a(null, 1, null), d.c.g.class, "com.obric.aiagent.plugin")));
        this.mainScope = kotlinx.coroutines.an.a();
        this.selectedMyTab = b.f20337b;
        this.enterPageTracker$delegate = d.g.a(new $$Lambda$SkillManagementActivity$zPW5yl_XPLRiR2mzVbZ7xK9QD8(this));
    }

    public static final /* synthetic */ ArrayList access$getLatestSkills$p(SkillManagementActivity r2) {
        return ((SkillManagementActivity) ZeusTransformUtils.wrapperContextForParams(r2, SkillManagementActivity.class, "com.obric.aiagent.plugin")).latestSkills;
    }

    public static final /* synthetic */ kotlinx.coroutines.am access$getMainScope$p(SkillManagementActivity r2) {
        return ((SkillManagementActivity) ZeusTransformUtils.wrapperContextForParams(r2, SkillManagementActivity.class, "com.obric.aiagent.plugin")).mainScope;
    }

    public static final /* synthetic */ void access$initializeSkillPage(SkillManagementActivity r2, ISkillManagerService r3) {
        ((SkillManagementActivity) ZeusTransformUtils.wrapperContextForParams(r2, SkillManagementActivity.class, "com.obric.aiagent.plugin")).initializeSkillPage((ISkillManagerService) ZeusTransformUtils.wrapperContextForParams(r3, ISkillManagerService.class, "com.obric.aiagent.plugin"));
    }

    public static final /* synthetic */ b access$myTabForPosition(SkillManagementActivity r2, int r3) {
        return ((SkillManagementActivity) ZeusTransformUtils.wrapperContextForParams(r2, SkillManagementActivity.class, "com.obric.aiagent.plugin")).myTabForPosition(r3);
    }

    public static final /* synthetic */ void access$renderMySkills(SkillManagementActivity r2) {
        ((SkillManagementActivity) ZeusTransformUtils.wrapperContextForParams(r2, SkillManagementActivity.class, "com.obric.aiagent.plugin")).renderMySkills();
    }

    public static final /* synthetic */ void access$requestDecisionRefreshOnce(SkillManagementActivity r2) {
        ((SkillManagementActivity) ZeusTransformUtils.wrapperContextForParams(r2, SkillManagementActivity.class, "com.obric.aiagent.plugin")).requestDecisionRefreshOnce();
    }

    public static final /* synthetic */ void access$setSelectedMyTab$p(SkillManagementActivity r2, b r3) {
        ((SkillManagementActivity) ZeusTransformUtils.wrapperContextForParams(r2, SkillManagementActivity.class, "com.obric.aiagent.plugin")).selectedMyTab = r3;
    }

    private final ag getEnterPageTracker() {
        return (ag) ZeusTransformUtils.preCheckCast(this.enterPageTracker$delegate.b(), ag.class, "com.obric.aiagent.plugin");
    }

    private static final ag enterPageTracker_delegate$lambda$1(SkillManagementActivity r7) {
        final SkillManagementActivity r8 = (SkillManagementActivity) ZeusTransformUtils.wrapperContextForParams(r7, SkillManagementActivity.class, "com.obric.aiagent.plugin");
        return new ag(new $$Lambda$SkillManagementActivity$uIuUaElCXcm6vZWVHuNACTDRqc(r8), null, null, 6, null);
    }

    private static final bp enterPageTracker_delegate$lambda$1$lambda$0(SkillManagementActivity r2) {
        Intent r3 = ((SkillManagementActivity) ZeusTransformUtils.wrapperContextForParams(r2, SkillManagementActivity.class, "com.obric.aiagent.plugin")).getIntent();
        d.h.b.o.c(r3, "getIntent(...)");
        return bo.a(r3, dr.f19760a);
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity
    public void onCreate(Bundle r4) {
        super.onCreate(r4);
        configureSystemBars();
        setContentView(ZeusTransformUtils.mapRes(R.layout.activity_skill_management, "layout", "activity_skill_management"));
        installSkillPageGuard(ZeusTransformUtils.mapRes(R.id.skill_management_root, DbHelper.COL_ID, "skill_management_root"), (d.h.a.b) ZeusTransformUtils.preCheckCast(new d(this), d.h.a.b.class, "com.obric.aiagent.plugin"));
    }

    @Override // com.obric.aiagent.skill.manager.impl.ui.SkillGatedActivity
    public OFloatingTitleBar getFloatingTitleBar() {
        OFloatingTitleBar r1 = this.titleBar;
        if (r1 == null) goto L7;
        if (r1 != null) goto L8;
        d.h.b.o.c("titleBar");
        goto L7
    L8:
        return r1;
    L7:
        return null;
    }

    private final void initializeSkillPage(ISkillManagerService r3) {
        this.skillManager = (ISkillManagerService) ZeusTransformUtils.wrapperContextForParams(r3, ISkillManagerService.class, "com.obric.aiagent.plugin");
        bindViews();
        this.createFlowController = createCreateFlowController();
        setupMyPage();
        ensureSkillObserverStarted();
        updateMyTabs();
        renderMySkills();
        requestDecisionRefreshOnce();
    }

    private final void configureSystemBars() {
        bh.a((FragmentActivity) ZeusTransformUtils.preCheckCast(this, FragmentActivity.class, "com.obric.aiagent.plugin"), false, 0, false, 7, null);
    }

    @Override // androidx.fragment.app.FragmentActivity
    public void onDestroy() {
        kotlinx.coroutines.ca r0 = this.skillStateJob;
        if (r0 == null) goto L5;
        kotlinx.coroutines.ca.a.a(r0, null, 1, null);
    L5:
        kotlinx.coroutines.ca r1 = this.storeMetadataRefreshJob;
        if (r1 == null) goto L8;
        kotlinx.coroutines.ca.a.a(r1, null, 1, null);
    L8:
        kotlinx.coroutines.ca r2 = this.decisionRefreshJob;
        if (r2 == null) goto L11;
        kotlinx.coroutines.ca.a.a(r2, null, 1, null);
    L11:
        x r3 = this.createFlowController;
        if (r3 == null) goto L14;
        r3.a();
    L14:
        this.createFlowController = null;
        kotlinx.coroutines.an.a(this.ioScope, null, 1, null);
        kotlinx.coroutines.an.a(this.mainScope, null, 1, null);
        super.onDestroy();
    }

    @Override // com.obric.aiagent.skill.manager.impl.ui.SkillGatedActivity, androidx.fragment.app.FragmentActivity
    public void onStart() {
        super.onStart();
        this.managementPageVisible = true;
        requestDecisionRefreshOnce();
    }

    @Override // androidx.fragment.app.FragmentActivity
    public void onStop() {
        this.managementPageVisible = false;
        kotlinx.coroutines.ca r1 = this.decisionRefreshJob;
        if (r1 == null) goto L5;
        kotlinx.coroutines.ca.a.a(r1, null, 1, null);
    L5:
        this.decisionRefreshJob = null;
        this.decisionRefreshRequested = false;
        super.onStop();
    }

    private final void bindViews() {
        View r0 = findViewById(ZeusTransformUtils.mapRes(R.id.my_empty, DbHelper.COL_ID, "my_empty"));
        d.h.b.o.c(r0, "findViewById(...)");
        this.myEmpty = r0;
        View r1 = findViewById(ZeusTransformUtils.mapRes(R.id.my_list, DbHelper.COL_ID, "my_list"));
        d.h.b.o.c(r1, "findViewById(...)");
        bh.a((RecyclerView) ZeusTransformUtils.preCheckCast(r1, RecyclerView.class, "com.obric.aiagent.plugin"), ZeusTransformUtils.getResources(this, "com.obric.aiagent.plugin").getDimensionPixelSize(ZeusTransformUtils.mapRes(R.dimen.skill_navigation_list_extra_bottom, "dimen", "skill_navigation_list_extra_bottom")));
    }

    private final x createCreateFlowController() {
        return new x((FragmentActivity) ZeusTransformUtils.preCheckCast(this, FragmentActivity.class, "com.obric.aiagent.plugin"), new $$Lambda$SkillManagementActivity$cy_f1QQ0zzSJphwz1XsCXpFQdQE(this), this.ioScope, this.mainScope, new $$Lambda$SkillManagementActivity$8PPRyWucQJVAzLjEXNZ8ujkcCl4(this));
    }

    private static final ISkillManagerService createCreateFlowController$lambda$2(SkillManagementActivity r2) {
        return ((SkillManagementActivity) ZeusTransformUtils.wrapperContextForParams(r2, SkillManagementActivity.class, "com.obric.aiagent.plugin")).skillManager;
    }

    private static final d.x createCreateFlowController$lambda$3(SkillManagementActivity r2, String r3) {
        SkillManagementActivity r4 = (SkillManagementActivity) ZeusTransformUtils.wrapperContextForParams(r2, SkillManagementActivity.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r3, "slug");
        r4.openSkillDetail(r3, br.f20662a.a(dr.f19760a));
        return d.x.f38692a;
    }

    private final void setupMyPage() {
        View r1 = findViewById(ZeusTransformUtils.mapRes(R.id.my_title_bar, DbHelper.COL_ID, "my_title_bar"));
        d.h.b.o.c(r1, "findViewById(...)");
        OFloatingTitleBar r2 = (OFloatingTitleBar) ZeusTransformUtils.preCheckCast(r1, OFloatingTitleBar.class, "com.obric.aiagent.plugin");
        this.titleBar = r2;
        com.obric.aiagent.skill.manager.impl.ui.h r5 = null;
        if (r2 != null) goto L5;
        d.h.b.o.c("titleBar");
        r2 = null;
    L5:
        r2.setFloatingTransitionEnabled(true);
        View r3 = ZeusTransformUtils.inflate(getLayoutInflater(), ZeusTransformUtils.mapRes(R.layout.layout_skill_management_segmented_tabs, "layout", "layout_skill_management_segmented_tabs"), null, "com.obric.aiagent.plugin");
        d.h.b.o.a(r3, "null cannot be cast to non-null type com.obric.oui.tab.OTabLayout");
        OTabLayout r4 = (OTabLayout) ZeusTransformUtils.preCheckCast(r3, OTabLayout.class, "com.obric.aiagent.plugin");
        this.myTabs = r4;
        if (r4 != null) goto L8;
        d.h.b.o.c("myTabs");
        r4 = null;
    L8:
        r4.setLayoutParams(new ViewGroup.LayoutParams(-2, ZeusTransformUtils.getResources(this, "com.obric.aiagent.plugin").getDimensionPixelSize(ZeusTransformUtils.mapRes(R.dimen.oui_h_m2, "dimen", "oui_h_m2"))));
        OFloatingTitleBar r6 = this.titleBar;
        if (r6 != null) goto L11;
        d.h.b.o.c("titleBar");
        r6 = null;
    L11:
        OTabLayout r7 = this.myTabs;
        if (r7 != null) goto L14;
        d.h.b.o.c("myTabs");
        r7 = null;
    L14:
        r6.setCenterCustomView((View) ZeusTransformUtils.preCheckCast(r7, View.class, "com.obric.aiagent.plugin"));
        OFloatingTitleBar r8 = this.titleBar;
        if (r8 != null) goto L17;
        d.h.b.o.c("titleBar");
        r8 = null;
    L17:
        r8.addStartAction(ZeusTransformUtils.mapRes(R.drawable.o_floating_title_bar_icon_back, "drawable", "o_floating_title_bar_icon_back"), 0, new $$Lambda$SkillManagementActivity$xQqzcTrkqnHFGztcrJ1Qq_nM1I(this)).setContentDescription((CharSequence) ZeusTransformUtils.preCheckCast(getString(ZeusTransformUtils.mapRes(R.string.obric_skill_common_back, WsChannelMultiProcessSharedProvider.STRING_TYPE, "obric_skill_common_back")), CharSequence.class, "com.obric.aiagent.plugin"));
        OFloatingTitleBar r9 = this.titleBar;
        if (r9 != null) goto L20;
        d.h.b.o.c("titleBar");
        r9 = null;
    L20:
        r9.addEndAction(ZeusTransformUtils.mapRes(R.drawable.oic_magnifier_search, "drawable", "oic_magnifier_search"), 0, new $$Lambda$SkillManagementActivity$kMhwkJX3nM_2qSigXdIhquZAT8c(this)).setContentDescription((CharSequence) ZeusTransformUtils.preCheckCast(getString(ZeusTransformUtils.mapRes(R.string.obric_skill_common_search, WsChannelMultiProcessSharedProvider.STRING_TYPE, "obric_skill_common_search")), CharSequence.class, "com.obric.aiagent.plugin"));
        configureCreateButton();
        OTabLayout r10 = this.myTabs;
        if (r10 != null) goto L23;
        d.h.b.o.c("myTabs");
        r10 = null;
    L23:
        r10.addOnTabSelectedListener((OTabLayoutBase.d) ZeusTransformUtils.preCheckCast(new l(this), OTabLayoutBase.d.class, "com.obric.aiagent.plugin"));
        RecyclerView r11 = (RecyclerView) ZeusTransformUtils.preCheckCast(findViewById(ZeusTransformUtils.mapRes(R.id.my_list, DbHelper.COL_ID, "my_list")), RecyclerView.class, "com.obric.aiagent.plugin");
        r11.setLayoutManager((RecyclerView.h) ZeusTransformUtils.preCheckCast(new LinearLayoutManager((Context) ZeusTransformUtils.preCheckCast(this, Context.class, "com.obric.aiagent.plugin")), RecyclerView.h.class, "com.obric.aiagent.plugin"));
        r11.setItemAnimator(null);
        this.interactionController = new com.obric.aiagent.skill.manager.impl.ui.g((FragmentActivity) ZeusTransformUtils.preCheckCast(this, FragmentActivity.class, "com.obric.aiagent.plugin"), new $$Lambda$SkillManagementActivity$CuCXeQzESq8WxR4RGV2LEMMwV0(this), new $$Lambda$SkillManagementActivity$mIHyvR3xFh373J0SuQ4zIMtQtU(this), null, 8, null);
        d.h.a.b r14 = new $$Lambda$SkillManagementActivity$Ymrn17_sgj_uWuIWMyMjJaw5Xqo(this);
        com.obric.aiagent.skill.manager.impl.ui.g r12 = this.interactionController;
        if (r12 != null) goto L26;
        d.h.b.o.c("interactionController");
        r12 = null;
    L26:
        d.h.a.b r15 = (d.h.a.b) ZeusTransformUtils.preCheckCast(new m(r12), d.h.a.b.class, "com.obric.aiagent.plugin");
        com.obric.aiagent.skill.manager.impl.ui.g r13 = this.interactionController;
        if (r13 != null) goto L29;
        d.h.b.o.c("interactionController");
        r13 = null;
    L29:
        com.obric.aiagent.skill.manager.impl.ui.h r16 = new com.obric.aiagent.skill.manager.impl.ui.h(r14, r15, (d.h.a.a) ZeusTransformUtils.preCheckCast(new n(r13), d.h.a.a.class, "com.obric.aiagent.plugin"), false, null, 24, null);
        this.mySkillAdapter = r16;
        if (r16 != null) goto L32;
        d.h.b.o.c("mySkillAdapter");
    L33:
        r11.setAdapter((RecyclerView.a) ZeusTransformUtils.preCheckCast(r5, RecyclerView.a.class, "com.obric.aiagent.plugin"));
        return;
    L32:
        r5 = r16;
        goto L33
    }

    private static final void setupMyPage$lambda$4(SkillManagementActivity r1, View r2) {
        ((SkillManagementActivity) ZeusTransformUtils.wrapperContextForParams(r1, SkillManagementActivity.class, "com.obric.aiagent.plugin")).finish();
    }

    private static final void setupMyPage$lambda$5(SkillManagementActivity r2, View r3) {
        SkillManagementActivity r4 = (SkillManagementActivity) ZeusTransformUtils.wrapperContextForParams(r2, SkillManagementActivity.class, "com.obric.aiagent.plugin");
        r4.launchFloatingActivity(SkillSearchActivity.Companion.b((Context) ZeusTransformUtils.preCheckCast(r4, Context.class, "com.obric.aiagent.plugin")));
    }

    private static final ISkillManagerService setupMyPage$lambda$6(SkillManagementActivity r2) {
        return ((SkillManagementActivity) ZeusTransformUtils.wrapperContextForParams(r2, SkillManagementActivity.class, "com.obric.aiagent.plugin")).skillManager;
    }

    private static final d.x setupMyPage$lambda$7(SkillManagementActivity r2) {
        com.obric.aiagent.skill.manager.impl.ui.h r3 = ((SkillManagementActivity) ZeusTransformUtils.wrapperContextForParams(r2, SkillManagementActivity.class, "com.obric.aiagent.plugin")).mySkillAdapter;
        if (r3 != null) goto L5;
        d.h.b.o.c("mySkillAdapter");
        r3 = null;
    L5:
        r3.b();
        return d.x.f38692a;
    }

    private static final d.x setupMyPage$lambda$8(SkillManagementActivity r2, com.obric.aiagent.skill.manager.api.e r3) {
        SkillManagementActivity r4 = (SkillManagementActivity) ZeusTransformUtils.wrapperContextForParams(r2, SkillManagementActivity.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r3, "skill");
        openSkillDetail$default(r4, r3.a(), null, 2, null);
        return d.x.f38692a;
    }

    private final void configureCreateButton() {
        View r0 = findViewById(ZeusTransformUtils.mapRes(R.id.my_create, DbHelper.COL_ID, "my_create"));
        d.h.b.o.a(r0);
        bh.a(r0, 0, 1, null);
        r0.setOnClickListener(new $$Lambda$SkillManagementActivity$nx7HpfeNFDFXrBd9L0iXp5hflA(this));
        updateCreateButtonVisibility();
    }

    private static final void configureCreateButton$lambda$10$lambda$9(SkillManagementActivity r1, View r2) {
        x r3 = ((SkillManagementActivity) ZeusTransformUtils.wrapperContextForParams(r1, SkillManagementActivity.class, "com.obric.aiagent.plugin")).createFlowController;
        if (r3 == null) goto L6;
        r3.b();
        return;
    }

    private final void updateCreateButtonVisibility() {
        com.obric.aiagent.skill.manager.api.al r0 = com.obric.aiagent.skill.manager.api.al.f19195a.a();
        int r2 = 0;
        if (com.obric.aiagent.skill.manager.impl.bs.f19588a.a(r0) == false) goto L5;
    L8:
        boolean r1 = true;
    L9:
        View r5 = findViewById(ZeusTransformUtils.mapRes(R.id.my_create, DbHelper.COL_ID, "my_create"));
        if (r1 == true) goto L13;
        r2 = 8;
    L13:
        r5.setVisibility(r2);
        return;
    L5:
        if (com.obric.aiagent.skill.manager.impl.bs.f19588a.b(r0) == true) goto L8;
        r1 = false;
        goto L9
    }

    @Override // com.obric.aiagent.skill.manager.impl.ui.SkillGatedActivity, androidx.fragment.app.FragmentActivity
    public void onResume() {
        super.onResume();
        if (isSkillPageAvailable() == true) goto L5;
        return;
    L5:
        updateCreateButtonVisibility();
        renderMySkills();
        com.obric.aiagent.skill.manager.impl.ui.h r1 = null;
        if (com.obric.aiagent.utils.shared_state.b.f22344a.a() == false) goto L8;
        String r0 = com.obric.aiagent.utils.shared_state.b.f22344a.d();
    L9:
        com.obric.aiagent.skill.manager.impl.ui.h r2 = this.mySkillAdapter;
        if (r2 != null) goto L12;
        d.h.b.o.c("mySkillAdapter");
    L13:
        r1.a(r0);
        refreshInstalledStoreMetadata();
        return;
    L12:
        r1 = r2;
        goto L13
    L8:
        r0 = null;
        goto L9
    }

    @Override // androidx.fragment.app.FragmentActivity
    public void onPostResume() {
        super.onPostResume();
        if (isSkillPageAvailable() == true) goto L5;
        return;
    L5:
        getEnterPageTracker().a();
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity
    public void onActivityResult(int r2, int r3, Intent r4) {
        super.onActivityResult(r2, r3, r4);
        if (isSkillPageAvailable() == true) goto L5;
        return;
    L5:
        x r1 = this.createFlowController;
        if (r1 == null) goto L9;
        r1.a(r2, r3, r4);
        return;
    }

    private final void updateMyTabs() {
        if (this.selectedMyTab != b.f20336a) goto L5;
        final int r0 = 0;
    L6:
        OTabLayout r1 = this.myTabs;
        if (r1 != null) goto L9;
        d.h.b.o.c("myTabs");
        r1 = null;
    L9:
        r1.post(new $$Lambda$SkillManagementActivity$3H1WYpo_nPpjFDCXCNxA1lgKw5U(this, r0));
        return;
    L5:
        r0 = 1;
        goto L6
    }

    private static final void updateMyTabs$lambda$11(SkillManagementActivity r3, int r4) {
        SkillManagementActivity r5 = (SkillManagementActivity) ZeusTransformUtils.wrapperContextForParams(r3, SkillManagementActivity.class, "com.obric.aiagent.plugin");
        OTabLayout r0 = r5.myTabs;
        OTabLayout r1 = null;
        if (r0 != null) goto L6;
        d.h.b.o.c("myTabs");
        r0 = null;
    L6:
        if (r0.getSelectedTabPosition() == r4) goto L13;
        OTabLayout r6 = r5.myTabs;
        if (r6 != null) goto L10;
        d.h.b.o.c("myTabs");
    L11:
        r1.selectTab(r4);
        return;
    L10:
        r1 = r6;
        goto L11
    }

    private final void renderMySkills() {
        updateTabsVisibility();
        Iterable r0 = (Iterable) ZeusTransformUtils.preCheckCast(com.obric.aiagent.skill.manager.impl.bs.f19588a.a((List) ZeusTransformUtils.preCheckCast(this.latestSkills, List.class, "com.obric.aiagent.plugin"), com.obric.aiagent.skill.manager.api.al.f19195a.a()), Iterable.class, "com.obric.aiagent.plugin");
        Collection r1 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.aiagent.plugin");
        Iterator r2 = r0.iterator();
    L4:
        if (r2.hasNext() == false) goto L8;
        Object r3 = r2.next();
        if ((true ^ d.h.b.o.a(((com.obric.aiagent.skill.manager.api.e) ZeusTransformUtils.preCheckCast(r3, com.obric.aiagent.skill.manager.api.e.class, "com.obric.aiagent.plugin")).g(), com.obric.aiagent.skill.manager.api.aq.a.f19212a)) == false) goto L4;
        r1.add(r3);
        goto L4
    L8:
        Iterable r4 = (Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r1, List.class, "com.obric.aiagent.plugin"), Iterable.class, "com.obric.aiagent.plugin");
        Collection r5 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.aiagent.plugin");
        Iterator r6 = r4.iterator();
    L9:
        int r7 = 0;
        if (r6.hasNext() == false) goto L20;
        Object r8 = r6.next();
        boolean r9 = com.obric.aiagent.skill.manager.impl.az.c((com.obric.aiagent.skill.manager.api.e) ZeusTransformUtils.preCheckCast(r8, com.obric.aiagent.skill.manager.api.e.class, "com.obric.aiagent.plugin"));
        if (this.selectedMyTab != b.f20336a) goto L15;
        if (r9 == false) goto L15;
    L17:
        r7 = 1;
    L18:
        if (r7 == 0) goto L9;
        r5.add(r8);
    L15:
        if (this.selectedMyTab != b.f20337b) goto L18;
        if (r9 == true) goto L18;
    L20:
        List<com.obric.aiagent.skill.manager.api.e> r10 = com.obric.aiagent.skill.manager.impl.az.a((Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r5, List.class, "com.obric.aiagent.plugin"), Iterable.class, "com.obric.aiagent.plugin"));
        View r11 = this.myEmpty;
        com.obric.aiagent.skill.manager.impl.ui.h r12 = null;
        if (r11 != null) goto L24;
        d.h.b.o.c("myEmpty");
        r11 = null;
    L24:
        if (r10.isEmpty() == true) goto L27;
        r7 = 8;
    L27:
        r11.setVisibility(r7);
        com.obric.aiagent.skill.manager.impl.ui.h r13 = this.mySkillAdapter;
        if (r13 != null) goto L30;
        d.h.b.o.c("mySkillAdapter");
    L31:
        r12.a(r10);
        return;
    L30:
        r12 = r13;
        goto L31
    }

    private final void updateTabsVisibility() {
        OFloatingTitleBar r1 = null;
        if (com.obric.aiagent.skill.manager.impl.bs.a(com.obric.aiagent.skill.manager.impl.bs.f19588a, null, 1, null) == false) goto L5;
    L8:
        boolean r0 = true;
    L10:
        if (r0 == false) goto L19;
        OFloatingTitleBar r2 = this.titleBar;
        if (r2 != null) goto L14;
        d.h.b.o.c("titleBar");
        r2 = null;
    L14:
        r2.setCenterTitle(null);
        OFloatingTitleBar r5 = this.titleBar;
        if (r5 != null) goto L17;
        d.h.b.o.c("titleBar");
    L18:
        r1.showCenterCustomView(true);
        return;
    L17:
        r1 = r5;
        goto L18
    L19:
        this.selectedMyTab = b.f20337b;
        OFloatingTitleBar r3 = this.titleBar;
        if (r3 != null) goto L22;
        d.h.b.o.c("titleBar");
        r3 = null;
    L22:
        r3.showCenterCustomView(false);
        OFloatingTitleBar r4 = this.titleBar;
        if (r4 != null) goto L25;
        d.h.b.o.c("titleBar");
    L26:
        r1.setCenterTitle(getString(ZeusTransformUtils.mapRes(R.string.obric_skill_management_title, WsChannelMultiProcessSharedProvider.STRING_TYPE, "obric_skill_management_title")));
        return;
    L25:
        r1 = r4;
        goto L26
    L5:
        if (hasUserCreatedSkill() == true) goto L8;
        r0 = false;
        goto L10
    }

    private final boolean hasUserCreatedSkill() {
        Iterable r6 = (Iterable) ZeusTransformUtils.preCheckCast(this.latestSkills, Iterable.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r6, Collection.class) == true) goto L5;
    L7:
        Iterator r7 = r6.iterator();
    L9:
        if (r7.hasNext() == false) goto L17;
        com.obric.aiagent.skill.manager.api.e r0 = (com.obric.aiagent.skill.manager.api.e) ZeusTransformUtils.preCheckCast(r7.next(), com.obric.aiagent.skill.manager.api.e.class, "com.obric.aiagent.plugin");
        if (d.h.b.o.a(r0.g(), com.obric.aiagent.skill.manager.api.aq.a.f19212a) == false) goto L13;
    L15:
        boolean r1 = false;
    L16:
        if (r1 == false) goto L9;
        return true;
    L13:
        if (com.obric.aiagent.skill.manager.impl.az.c(r0) == false) goto L15;
        r1 = true;
    L17:
        return false;
    L5:
        if (((Collection) ZeusTransformUtils.preCheckCast(r6, Collection.class, "com.obric.aiagent.plugin")).isEmpty() == false) goto L7;
        goto L7
    }

    private final void ensureSkillObserverStarted() {
        ISkillManagerService r0 = this.skillManager;
        if (r0 != null) goto L6;
        return;
    L6:
        if (this.skillStateJob == null) goto L8;
        return;
    L8:
        kotlinx.coroutines.b.ak r1 = (kotlinx.coroutines.b.ak) ZeusTransformUtils.preCheckCast(com.obric.aiagent.skill.manager.api.v.a(r0.observeInstalledSkills()), kotlinx.coroutines.b.ak.class, "com.obric.aiagent.plugin");
        if (r1 != null) goto L11;
        return;
    L11:
        this.skillStateJob = kotlinx.coroutines.i.a(this.ioScope, null, null, (d.h.a.m) ZeusTransformUtils.preCheckCast(new c(r1, this, null), d.h.a.m.class, "com.obric.aiagent.plugin"), 3, null);
    }

    private final void requestDecisionRefreshOnce() {
        if (this.managementPageVisible == true) goto L5;
        return;
    L5:
        if (this.decisionRefreshRequested == true) goto L19;
        ISkillManagerService r0 = this.skillManager;
        if (r0 != null) goto L10;
        return;
    L10:
        List r1 = (List) ZeusTransformUtils.preCheckCast(com.obric.aiagent.skill.manager.api.v.a(r0.getInstalledSkills()), List.class, "com.obric.aiagent.plugin");
        if (r1 != null) goto L13;
        r1 = d.a.p.b();
    L13:
        Set r2 = d.n.m.i(d.n.m.a(d.n.m.d(d.n.m.a(d.a.p.y((Iterable) ZeusTransformUtils.preCheckCast(r1, Iterable.class, "com.obric.aiagent.plugin")), (d.h.a.b) ZeusTransformUtils.preCheckCast(i.f20359a, d.h.a.b.class, "com.obric.aiagent.plugin")), (d.h.a.b) ZeusTransformUtils.preCheckCast(j.f20360a, d.h.a.b.class, "com.obric.aiagent.plugin")), (d.h.a.b) ZeusTransformUtils.preCheckCast(k.f20361a, d.h.a.b.class, "com.obric.aiagent.plugin")));
        if (r2.isEmpty() == false) goto L16;
        return;
    L16:
        this.decisionRefreshRequested = true;
        this.decisionRefreshJob = kotlinx.coroutines.i.a(this.ioScope, null, null, (d.h.a.m) ZeusTransformUtils.preCheckCast(new h(r2, r0, null), d.h.a.m.class, "com.obric.aiagent.plugin"), 3, null);
        return;
    }

    private final void refreshInstalledStoreMetadata() {
        ISkillManagerService r0 = this.skillManager;
        if (ZeusTransformUtils.instanceOf(r0, SkillManager.class) == false) goto L5;
        SkillManager r1 = (SkillManager) ZeusTransformUtils.preCheckCast(r0, SkillManager.class, "com.obric.aiagent.plugin");
    L6:
        if (r1 != null) goto L8;
        return;
    L8:
        List r2 = (List) ZeusTransformUtils.preCheckCast(com.obric.aiagent.skill.manager.api.v.a(r1.getInstalledSkills()), List.class, "com.obric.aiagent.plugin");
        if (r2 != null) goto L11;
        r2 = d.a.p.b();
    L11:
        Set r3 = d.n.m.i(d.n.m.a(d.n.m.d(d.n.m.a(d.a.p.y((Iterable) ZeusTransformUtils.preCheckCast(r2, Iterable.class, "com.obric.aiagent.plugin")), $$Lambda$SkillManagementActivity$vyKcKKeFSe0h2xYFoNNWiolyQbg.INSTANCE), (d.h.a.b) ZeusTransformUtils.preCheckCast(f.f20354a, d.h.a.b.class, "com.obric.aiagent.plugin")), (d.h.a.b) ZeusTransformUtils.preCheckCast(g.f20355a, d.h.a.b.class, "com.obric.aiagent.plugin")));
        if (r3.isEmpty() == false) goto L14;
        return;
    L14:
        kotlinx.coroutines.ca r4 = this.storeMetadataRefreshJob;
        if (r4 == null) goto L17;
        kotlinx.coroutines.ca.a.a(r4, null, 1, null);
    L17:
        this.storeMetadataRefreshJob = kotlinx.coroutines.i.a(this.ioScope, null, null, (d.h.a.m) ZeusTransformUtils.preCheckCast(new e(r1, r3, null), d.h.a.m.class, "com.obric.aiagent.plugin"), 3, null);
        return;
    L5:
        r1 = null;
        goto L6
    }

    private static final boolean refreshInstalledStoreMetadata$lambda$15(com.obric.aiagent.skill.manager.api.e r1) {
        d.h.b.o.e(r1, "skill");
        return ZeusTransformUtils.instanceOf(r1.g(), com.obric.aiagent.skill.manager.api.aq.e.class);
    }

    static /* synthetic */ void openSkillDetail$default(SkillManagementActivity r1, String r2, du r3, int r4, Object r5) {
        SkillManagementActivity r6 = (SkillManagementActivity) ZeusTransformUtils.wrapperContextForParams(r1, SkillManagementActivity.class, "com.obric.aiagent.plugin");
        if ((r4 & 2) == 0) goto L5;
        r3 = br.f20662a.c();
    L5:
        r6.openSkillDetail(r2, r3);
    }

    private final void openSkillDetail(String r8, du r9) {
        launchFloatingActivity(SkillDetailPreviewActivity.a.a(SkillDetailPreviewActivity.Companion, (Context) ZeusTransformUtils.preCheckCast(this, Context.class, "com.obric.aiagent.plugin"), r8, null, r9, 4, null));
    }

    private final b myTabForPosition(int r1) {
        if (r1 != 0) goto L5;
        return b.f20336a;
    L5:
        return b.f20337b;
    }
}
