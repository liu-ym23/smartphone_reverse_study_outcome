package com.obric.aiagent.skill.manager.impl.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.widget.ViewPager2;
import com.bytedance.bdturing.localstorage.DbHelper;
import com.bytedance.common.wschannel.WsChannelMultiProcessSharedProvider;
import com.obric.aiagent.apm.impl.BuildConfig;
import com.obric.aiagent.plugin.R;
import com.obric.aiagent.skill.manager.api.ISkillManagerService;
import com.obric.aiagent.skill.manager.impl.dr;
import com.obric.aiagent.skill.manager.impl.du;
import com.obric.aiagent.skill.manager.impl.ee;
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
import java.util.concurrent.CancellationException;
import kotlinx.coroutines.cx;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: compiled from: SkillShopActivity.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class SkillShopActivity extends SkillGatedActivity {
    private static final long ACTION_SUCCEED_DURATION_MS = 1000;
    private static final int APP_FUNCTION_TAB_POSITION = 1;
    public static final a Companion = null;
    private com.obric.aiagent.skill.manager.impl.ui.h appFunctionAdapter;
    private View appFunctionEmpty;
    private boolean appFunctionEntryEnabled;
    private com.obric.aiagent.skill.manager.impl.ui.g appFunctionInteractionController;
    private RecyclerView appFunctionList;
    private com.obric.aiagent.skill.manager.impl.ui.c appFunctionNoteAdapter;
    private View appFunctionPanel;
    private x createFlowController;
    private List<? extends bu> discoveryChannels;
    private ce discoveryPagerAdapter;
    private OTabLayout discoveryPrimaryTabs;
    private OTabLayout discoveryTabs;
    private OFloatingTitleBar discoveryTitleBar;
    private View discoveryTopContent;
    private ViewPager2 discoveryViewPager;
    private final d.f enterPageTracker$delegate;
    private final kotlinx.coroutines.am ioScope;
    private final kotlinx.coroutines.am mainScope;
    private final g pageActions;
    private final h pageChangeCallback;
    private String selectedChannelKey;
    private b selectedShopSection;
    private kotlinx.coroutines.ca shopStateJob;
    private ISkillManagerService skillManager;
    private kotlinx.coroutines.ca skillStateJob;
    private boolean suppressDiscoveryTabCallback;
    private final d.f viewModel$delegate;

    /* JADX INFO: compiled from: SkillShopActivity.kt */
    public static final class a {
        public /* synthetic */ a(d.h.b.h r1) {
            this();
        }

        private a() {
        }
    }

    /* JADX INFO: compiled from: SkillShopActivity.kt */
    private static final enum b extends Enum<b> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final b f20437a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final b f20438b = null;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private static final /* synthetic */ b[] f20439c = null;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private static final /* synthetic */ d.d.a f20440d = null;

        private static final /* synthetic */ b[] a() {
            return new b[]{f20437a, f20438b};
        }

        private b(String r1, int r2) {
            super(r1, r2);
        }

        static {
            f20437a = new b("FEATURED", 0);
            f20438b = new b("APP_FUNCTION", 1);
            b[] r0 = a();
            f20439c = r0;
            f20440d = d.d.b.a((Enum[]) ZeusTransformUtils.preCheckCast(r0, Enum[].class, "com.obric.aiagent.plugin"));
        }

        public static b valueOf(String r2) {
            return (b) ZeusTransformUtils.preCheckCast(Enum.valueOf(b.class, r2), b.class, "com.obric.aiagent.plugin");
        }

        public static b[] values() {
            return (b[]) ZeusTransformUtils.preCheckCast(f20439c.clone(), b[].class, "com.obric.aiagent.plugin");
        }
    }

    /* JADX INFO: compiled from: SkillShopActivity.kt */
    @d.c.b.a.f(b = "SkillShopActivity.kt", c = {415}, d = "invokeSuspend", e = "com.obric.aiagent.skill.manager.impl.ui.SkillShopActivity$ensureSkillObserverStarted$1")
    static final class c extends d.c.b.a.l implements d.h.a.m<kotlinx.coroutines.am, d.c.d<? super d.x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f20441a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ kotlinx.coroutines.b.ak<List<com.obric.aiagent.skill.manager.api.e>> f20442b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ SkillShopActivity f20443c;

        c(kotlinx.coroutines.b.ak<? extends List<com.obric.aiagent.skill.manager.api.e>> r3, SkillShopActivity r4, d.c.d<? super c> r5) {
            kotlinx.coroutines.b.ak<List<com.obric.aiagent.skill.manager.api.e>> r6 = (kotlinx.coroutines.b.ak) ZeusTransformUtils.wrapperContextForParams(r3, kotlinx.coroutines.b.ak.class, "com.obric.aiagent.plugin");
            SkillShopActivity r7 = (SkillShopActivity) ZeusTransformUtils.wrapperContextForParams(r4, SkillShopActivity.class, "com.obric.aiagent.plugin");
            d.c.d r8 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
            this.f20442b = r6;
            this.f20443c = r7;
            super(2, r8);
        }

        public final Object a(kotlinx.coroutines.am r3, d.c.d<? super d.x> r4) {
            return ((c) ZeusTransformUtils.preCheckCast(create((kotlinx.coroutines.am) ZeusTransformUtils.wrapperContextForParams(r3, kotlinx.coroutines.am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), c.class, "com.obric.aiagent.plugin")).invokeSuspend(d.x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<d.x> create(Object r3, d.c.d<?> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new c(this.f20442b, this.f20443c, r5), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(kotlinx.coroutines.am r3, d.c.d<? super d.x> r4) {
            return a((kotlinx.coroutines.am) ZeusTransformUtils.preCheckCast(r3, kotlinx.coroutines.am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r6) {
            Object r0 = d.c.a.b.a();
            int r1 = this.f20441a;
            if (r1 == 0) goto L13;
            if (r1 != 1) goto L6;
            d.o.a(r6);     // Catch: Exception -> L9 CancellationException -> L11
        L18:
            throw new d.d();     // Catch: Exception -> L9 CancellationException -> L11
        L6:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L13:
            d.o.a(r6);
            kotlinx.coroutines.b.ak<List<com.obric.aiagent.skill.manager.api.e>> r7 = this.f20442b;     // Catch: Exception -> L9 CancellationException -> L11
            final SkillShopActivity r4 = this.f20443c;     // Catch: Exception -> L9 CancellationException -> L11
            kotlinx.coroutines.b.i<? super List<com.obric.aiagent.skill.manager.api.e>> r2 = (kotlinx.coroutines.b.i) ZeusTransformUtils.preCheckCast(new AnonymousClass1(r4), kotlinx.coroutines.b.i.class, "com.obric.aiagent.plugin");     // Catch: Exception -> L9 CancellationException -> L11
            d.c.d<?> r5 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");     // Catch: Exception -> L9 CancellationException -> L11
            this.f20441a = 1;     // Catch: Exception -> L9 CancellationException -> L11
            if (r7.collect(r2, r5) != r0) goto L18;
            return r0;
        L11:
            e = move-exception;
            throw e;
        L9:
            e = move-exception;
            ee.f19808a.a("SkillManager", "Observe installed skills failed on shop page", "Observe installed skills failed on shop page", (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.aiagent.plugin"));
            return d.x.f38692a;
        }
    }

    /* JADX INFO: compiled from: SkillShopActivity.kt */
    @d.c.b.a.f(b = "SkillShopActivity.kt", c = {}, d = "invokeSuspend", e = "com.obric.aiagent.skill.manager.impl.ui.SkillShopActivity$installDiscoverySkill$1")
    static final class d extends d.c.b.a.l implements d.h.a.m<kotlinx.coroutines.am, d.c.d<? super d.x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f20448a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ ISkillManagerService f20449b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ com.obric.aiagent.skill.manager.api.e f20450c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ SkillShopActivity f20451d;

        /* JADX INFO: renamed from: com.obric.aiagent.skill.manager.impl.ui.SkillShopActivity$d$1, reason: invalid class name */
        /* JADX INFO: compiled from: SkillShopActivity.kt */
        @d.c.b.a.f(b = "SkillShopActivity.kt", c = {}, d = "invokeSuspend", e = "com.obric.aiagent.skill.manager.impl.ui.SkillShopActivity$installDiscoverySkill$1$1")
        static final class AnonymousClass1 extends d.c.b.a.l implements d.h.a.m<kotlinx.coroutines.am, d.c.d<? super d.x>, Object> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            int f20452a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ SkillShopActivity f20453b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            final /* synthetic */ com.obric.aiagent.skill.manager.api.e f20454c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            final /* synthetic */ com.obric.aiagent.skill.manager.api.e f20455d;

            AnonymousClass1(SkillShopActivity r3, com.obric.aiagent.skill.manager.api.e r4, com.obric.aiagent.skill.manager.api.e r5, d.c.d<? super AnonymousClass1> r6) {
                SkillShopActivity r7 = (SkillShopActivity) ZeusTransformUtils.wrapperContextForParams(r3, SkillShopActivity.class, "com.obric.aiagent.plugin");
                d.c.d r8 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r6, d.c.d.class, "com.obric.aiagent.plugin");
                this.f20453b = r7;
                this.f20454c = r4;
                this.f20455d = r5;
                super(2, r8);
            }

            public final Object a(kotlinx.coroutines.am r3, d.c.d<? super d.x> r4) {
                return ((AnonymousClass1) ZeusTransformUtils.preCheckCast(create((kotlinx.coroutines.am) ZeusTransformUtils.wrapperContextForParams(r3, kotlinx.coroutines.am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), AnonymousClass1.class, "com.obric.aiagent.plugin")).invokeSuspend(d.x.f38692a);
            }

            @Override // d.c.b.a.a
            public final d.c.d<d.x> create(Object r4, d.c.d<?> r5) {
                d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
                return (d.c.d) ZeusTransformUtils.preCheckCast(new AnonymousClass1(this.f20453b, this.f20454c, this.f20455d, r6), d.c.d.class, "com.obric.aiagent.plugin");
            }

            @Override // d.h.a.m
            public /* synthetic */ Object invoke(kotlinx.coroutines.am r3, d.c.d<? super d.x> r4) {
                return a((kotlinx.coroutines.am) ZeusTransformUtils.preCheckCast(r3, kotlinx.coroutines.am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
            }

            @Override // d.c.b.a.a
            public final Object invokeSuspend(Object r4) {
                d.c.a.b.a();
                if (this.f20452a != 0) goto L11;
                d.o.a(r4);
                SkillShopActivity.access$getViewModel(this.f20453b).a(this.f20454c);
                cm r5 = cm.f20758a;
                Activity r0 = (Activity) ZeusTransformUtils.preCheckCast(this.f20453b, Activity.class, "com.obric.aiagent.plugin");
                if (this.f20454c.l() == false) goto L7;
                cm.a r1 = cm.a.f20760a;
            L8:
                r5.a(r0, r1);
                SkillShopActivity.access$scheduleDiscoveryCompletionClear(this.f20453b, this.f20455d.a());
                return d.x.f38692a;
            L7:
                r1 = cm.a.g;
                goto L8
            L11:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }

        /* JADX INFO: renamed from: com.obric.aiagent.skill.manager.impl.ui.SkillShopActivity$d$2, reason: invalid class name */
        /* JADX INFO: compiled from: SkillShopActivity.kt */
        @d.c.b.a.f(b = "SkillShopActivity.kt", c = {}, d = "invokeSuspend", e = "com.obric.aiagent.skill.manager.impl.ui.SkillShopActivity$installDiscoverySkill$1$2")
        static final class AnonymousClass2 extends d.c.b.a.l implements d.h.a.m<kotlinx.coroutines.am, d.c.d<? super d.x>, Object> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            int f20456a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ SkillShopActivity f20457b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            final /* synthetic */ com.obric.aiagent.skill.manager.api.e f20458c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            final /* synthetic */ Exception f20459d;

            AnonymousClass2(SkillShopActivity r3, com.obric.aiagent.skill.manager.api.e r4, Exception r5, d.c.d<? super AnonymousClass2> r6) {
                SkillShopActivity r7 = (SkillShopActivity) ZeusTransformUtils.wrapperContextForParams(r3, SkillShopActivity.class, "com.obric.aiagent.plugin");
                d.c.d r8 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r6, d.c.d.class, "com.obric.aiagent.plugin");
                this.f20457b = r7;
                this.f20458c = r4;
                this.f20459d = r5;
                super(2, r8);
            }

            public final Object a(kotlinx.coroutines.am r3, d.c.d<? super d.x> r4) {
                return ((AnonymousClass2) ZeusTransformUtils.preCheckCast(create((kotlinx.coroutines.am) ZeusTransformUtils.wrapperContextForParams(r3, kotlinx.coroutines.am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), AnonymousClass2.class, "com.obric.aiagent.plugin")).invokeSuspend(d.x.f38692a);
            }

            @Override // d.c.b.a.a
            public final d.c.d<d.x> create(Object r4, d.c.d<?> r5) {
                d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
                return (d.c.d) ZeusTransformUtils.preCheckCast(new AnonymousClass2(this.f20457b, this.f20458c, this.f20459d, r6), d.c.d.class, "com.obric.aiagent.plugin");
            }

            @Override // d.h.a.m
            public /* synthetic */ Object invoke(kotlinx.coroutines.am r3, d.c.d<? super d.x> r4) {
                return a((kotlinx.coroutines.am) ZeusTransformUtils.preCheckCast(r3, kotlinx.coroutines.am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
            }

            @Override // d.c.b.a.a
            public final Object invokeSuspend(Object r4) {
                d.c.a.b.a();
                if (this.f20456a != 0) goto L10;
                d.o.a(r4);
                SkillShopActivity.access$getViewModel(this.f20457b).d(this.f20458c.a());
                cl.a("SkillManager", "install skill", (Throwable) ZeusTransformUtils.preCheckCast(this.f20459d, Throwable.class, "com.obric.aiagent.plugin"));
                cm.a r5 = cl.a((Throwable) ZeusTransformUtils.preCheckCast(this.f20459d, Throwable.class, "com.obric.aiagent.plugin"));
                if (r5 == null) goto L8;
                SkillShopActivity r3 = this.f20457b;
                cm.f20758a.a((Activity) ZeusTransformUtils.preCheckCast(r3, Activity.class, "com.obric.aiagent.plugin"), r5);
            L8:
                return d.x.f38692a;
            L10:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }

        /* JADX INFO: compiled from: SkillShopActivity.kt */
        @d.c.b.a.f(b = "SkillShopActivity.kt", c = {}, d = "invokeSuspend", e = "com.obric.aiagent.skill.manager.impl.ui.SkillShopActivity$installDiscoverySkill$1$installed$1")
        static final class a extends d.c.b.a.l implements d.h.a.m<kotlinx.coroutines.am, d.c.d<? super d.x>, Object> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            int f20460a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ SkillShopActivity f20461b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            final /* synthetic */ com.obric.aiagent.skill.manager.api.e f20462c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            final /* synthetic */ com.obric.aiagent.skill.manager.api.u<com.obric.aiagent.skill.manager.api.e> f20463d;

            a(SkillShopActivity r3, com.obric.aiagent.skill.manager.api.e r4, com.obric.aiagent.skill.manager.api.u<com.obric.aiagent.skill.manager.api.e> r5, d.c.d<? super a> r6) {
                SkillShopActivity r7 = (SkillShopActivity) ZeusTransformUtils.wrapperContextForParams(r3, SkillShopActivity.class, "com.obric.aiagent.plugin");
                com.obric.aiagent.skill.manager.api.u<com.obric.aiagent.skill.manager.api.e> r8 = (com.obric.aiagent.skill.manager.api.u) ZeusTransformUtils.wrapperContextForParams(r5, com.obric.aiagent.skill.manager.api.u.class, "com.obric.aiagent.plugin");
                d.c.d r9 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r6, d.c.d.class, "com.obric.aiagent.plugin");
                this.f20461b = r7;
                this.f20462c = r4;
                this.f20463d = r8;
                super(2, r9);
            }

            public final Object a(kotlinx.coroutines.am r3, d.c.d<? super d.x> r4) {
                return ((a) ZeusTransformUtils.preCheckCast(create((kotlinx.coroutines.am) ZeusTransformUtils.wrapperContextForParams(r3, kotlinx.coroutines.am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), a.class, "com.obric.aiagent.plugin")).invokeSuspend(d.x.f38692a);
            }

            @Override // d.c.b.a.a
            public final d.c.d<d.x> create(Object r4, d.c.d<?> r5) {
                d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
                return (d.c.d) ZeusTransformUtils.preCheckCast(new a(this.f20461b, this.f20462c, this.f20463d, r6), d.c.d.class, "com.obric.aiagent.plugin");
            }

            @Override // d.h.a.m
            public /* synthetic */ Object invoke(kotlinx.coroutines.am r3, d.c.d<? super d.x> r4) {
                return a((kotlinx.coroutines.am) ZeusTransformUtils.preCheckCast(r3, kotlinx.coroutines.am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
            }

            @Override // d.c.b.a.a
            public final Object invokeSuspend(Object r4) {
                d.c.a.b.a();
                if (this.f20460a != 0) goto L10;
                d.o.a(r4);
                SkillShopActivity.access$getViewModel(this.f20461b).d(this.f20462c.a());
                a("SkillManager", "install skill failed: code=" + ((com.obric.aiagent.skill.manager.api.u.a) ZeusTransformUtils.preCheckCast(this.f20463d, com.obric.aiagent.skill.manager.api.u.a.class, "com.obric.aiagent.plugin")).a());
                cm.a r5 = cl.a((com.obric.aiagent.skill.manager.api.u.a) ZeusTransformUtils.preCheckCast(this.f20463d, com.obric.aiagent.skill.manager.api.u.a.class, "com.obric.aiagent.plugin"));
                if (r5 == null) goto L8;
                cm.f20758a.a((Activity) ZeusTransformUtils.preCheckCast(this.f20461b, Activity.class, "com.obric.aiagent.plugin"), r5);
            L8:
                return d.x.f38692a;
            L10:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }

            @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
            public static int a(String r1, String r2) {
                if (com.obric.aiagent.apm.impl.a.a() == false) goto L5;
                return 0;
            L5:
                return Log.w(r1, r2);
            }
        }

        d(ISkillManagerService r3, com.obric.aiagent.skill.manager.api.e r4, SkillShopActivity r5, d.c.d<? super d> r6) {
            ISkillManagerService r7 = (ISkillManagerService) ZeusTransformUtils.wrapperContextForParams(r3, ISkillManagerService.class, "com.obric.aiagent.plugin");
            SkillShopActivity r8 = (SkillShopActivity) ZeusTransformUtils.wrapperContextForParams(r5, SkillShopActivity.class, "com.obric.aiagent.plugin");
            d.c.d r9 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r6, d.c.d.class, "com.obric.aiagent.plugin");
            this.f20449b = r7;
            this.f20450c = r4;
            this.f20451d = r8;
            super(2, r9);
        }

        public final Object a(kotlinx.coroutines.am r3, d.c.d<? super d.x> r4) {
            return ((d) ZeusTransformUtils.preCheckCast(create((kotlinx.coroutines.am) ZeusTransformUtils.wrapperContextForParams(r3, kotlinx.coroutines.am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), d.class, "com.obric.aiagent.plugin")).invokeSuspend(d.x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<d.x> create(Object r4, d.c.d<?> r5) {
            d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new d(this.f20449b, this.f20450c, this.f20451d, r6), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(kotlinx.coroutines.am r3, d.c.d<? super d.x> r4) {
            return a((kotlinx.coroutines.am) ZeusTransformUtils.preCheckCast(r3, kotlinx.coroutines.am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r10) {
            d.c.a.b.a();
            if (this.f20448a != 0) goto L21;
            d.o.a(r10);
            com.obric.aiagent.skill.manager.api.u<com.obric.aiagent.skill.manager.api.e> r1 = this.f20449b.installSkill(this.f20450c.a(), this.f20450c.d(), com.obric.aiagent.skill.manager.api.au.f19236c);     // Catch: Exception -> L14 CancellationException -> L18
            if (ZeusTransformUtils.instanceOf(r1, com.obric.aiagent.skill.manager.api.u.b.class) == false) goto L9;
            com.obric.aiagent.skill.manager.api.e r2 = (com.obric.aiagent.skill.manager.api.e) ZeusTransformUtils.preCheckCast(((com.obric.aiagent.skill.manager.api.u.b) ZeusTransformUtils.preCheckCast(r1, com.obric.aiagent.skill.manager.api.u.b.class, "com.obric.aiagent.plugin")).a(), com.obric.aiagent.skill.manager.api.e.class, "com.obric.aiagent.plugin");     // Catch: Exception -> L14 CancellationException -> L18
            kotlinx.coroutines.i.a(SkillShopActivity.access$getMainScope$p(this.f20451d), null, null, (d.h.a.m) ZeusTransformUtils.preCheckCast(new AnonymousClass1(this.f20451d, r2, this.f20450c, null), d.h.a.m.class, "com.obric.aiagent.plugin"), 3, null);     // Catch: Exception -> L14 CancellationException -> L18
        L17:
            return d.x.f38692a;
        L9:
            if (ZeusTransformUtils.instanceOf(r1, com.obric.aiagent.skill.manager.api.u.a.class) == false) goto L13;
            kotlinx.coroutines.i.a(SkillShopActivity.access$getMainScope$p(this.f20451d), null, null, (d.h.a.m) ZeusTransformUtils.preCheckCast(new a(this.f20451d, this.f20450c, r1, null), d.h.a.m.class, "com.obric.aiagent.plugin"), 3, null);     // Catch: Exception -> L14 CancellationException -> L18
            return d.x.f38692a;
        L13:
            throw new d.k();     // Catch: Exception -> L14 CancellationException -> L18
        L18:
            e = move-exception;
            throw e;
        L14:
            e = move-exception;
            kotlinx.coroutines.i.a(SkillShopActivity.access$getMainScope$p(this.f20451d), null, null, (d.h.a.m) ZeusTransformUtils.preCheckCast(new AnonymousClass2(this.f20451d, this.f20450c, e, null), d.h.a.m.class, "com.obric.aiagent.plugin"), 3, null);
            goto L17
        L21:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: compiled from: SkillShopActivity.kt */
    @d.c.b.a.f(b = "SkillShopActivity.kt", c = {278}, d = "invokeSuspend", e = "com.obric.aiagent.skill.manager.impl.ui.SkillShopActivity$observeShopState$1")
    static final class e extends d.c.b.a.l implements d.h.a.m<kotlinx.coroutines.am, d.c.d<? super d.x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f20464a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ SkillShopActivity f20465b;

        e(SkillShopActivity r3, d.c.d<? super e> r4) {
            SkillShopActivity r5 = (SkillShopActivity) ZeusTransformUtils.wrapperContextForParams(r3, SkillShopActivity.class, "com.obric.aiagent.plugin");
            d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f20465b = r5;
            super(2, r6);
        }

        public final Object a(kotlinx.coroutines.am r3, d.c.d<? super d.x> r4) {
            return ((e) ZeusTransformUtils.preCheckCast(create((kotlinx.coroutines.am) ZeusTransformUtils.wrapperContextForParams(r3, kotlinx.coroutines.am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), e.class, "com.obric.aiagent.plugin")).invokeSuspend(d.x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<d.x> create(Object r2, d.c.d<?> r3) {
            d.c.d r4 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new e(this.f20465b, r4), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(kotlinx.coroutines.am r3, d.c.d<? super d.x> r4) {
            return a((kotlinx.coroutines.am) ZeusTransformUtils.preCheckCast(r3, kotlinx.coroutines.am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r6) {
            Object r0 = d.c.a.b.a();
            int r1 = this.f20464a;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L6;
            d.o.a(r6);
        L12:
            throw new d.d();
        L6:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            d.o.a(r6);
            kotlinx.coroutines.b.ak<cf> r7 = SkillShopActivity.access$getViewModel(this.f20465b).b();
            final SkillShopActivity r3 = this.f20465b;
            kotlinx.coroutines.b.i<? super cf> r2 = (kotlinx.coroutines.b.i) ZeusTransformUtils.preCheckCast(new AnonymousClass1(r3), kotlinx.coroutines.b.i.class, "com.obric.aiagent.plugin");
            d.c.d<?> r4 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.f20464a = 1;
            if (r7.collect(r2, r4) != r0) goto L12;
            return r0;
        }
    }

    /* JADX INFO: compiled from: SkillShopActivity.kt */
    /* synthetic */ class f extends d.h.b.l implements d.h.a.b<ISkillManagerService, d.x> {
        f(Object r8) {
            super(1, r8, SkillShopActivity.class, "initializeSkillPage", "initializeSkillPage(Lcom/obric/aiagent/skill/manager/api/ISkillManagerService;)V", 0);
        }

        public final void a(ISkillManagerService r3) {
            ISkillManagerService r4 = (ISkillManagerService) ZeusTransformUtils.wrapperContextForParams(r3, ISkillManagerService.class, "com.obric.aiagent.plugin");
            d.h.b.o.e(r4, "p0");
            SkillShopActivity.access$initializeSkillPage((SkillShopActivity) ZeusTransformUtils.preCheckCast(this.receiver, SkillShopActivity.class, "com.obric.aiagent.plugin"), r4);
        }

        @Override // d.h.a.b
        public /* synthetic */ d.x invoke(ISkillManagerService r3) {
            a((ISkillManagerService) ZeusTransformUtils.preCheckCast(r3, ISkillManagerService.class, "com.obric.aiagent.plugin"));
            return d.x.f38692a;
        }
    }

    /* JADX INFO: compiled from: SkillShopActivity.kt */
    public static final class g implements cb {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ SkillShopActivity f20467a;

        g(SkillShopActivity r3) {
            this.f20467a = (SkillShopActivity) ZeusTransformUtils.wrapperContextForParams(r3, SkillShopActivity.class, "com.obric.aiagent.plugin");
        }

        @Override // com.obric.aiagent.skill.manager.impl.ui.cb
        public void a(com.obric.aiagent.skill.manager.api.e r2) {
            d.h.b.o.e(r2, "skill");
            SkillShopActivity.access$installDiscoverySkill(this.f20467a, r2);
        }

        @Override // com.obric.aiagent.skill.manager.impl.ui.cb
        public void b(com.obric.aiagent.skill.manager.api.e r2) {
            d.h.b.o.e(r2, "skill");
            SkillShopActivity.access$useDiscoverySkill(this.f20467a, r2);
        }

        @Override // com.obric.aiagent.skill.manager.impl.ui.cb
        public void c(com.obric.aiagent.skill.manager.api.e r8) {
            d.h.b.o.e(r8, "skill");
            SkillShopActivity.openSkillDetail$default(this.f20467a, r8.a(), r8.d(), null, 4, null);
        }

        @Override // com.obric.aiagent.skill.manager.impl.ui.cb
        public void a(String r2) {
            d.h.b.o.e(r2, "collectionSlug");
            SkillShopActivity.access$openCollectionDetail(this.f20467a, r2);
        }
    }

    /* JADX INFO: compiled from: SkillShopActivity.kt */
    public static final class h extends ViewPager2.e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ SkillShopActivity f20468a;

        h(SkillShopActivity r3) {
            this.f20468a = (SkillShopActivity) ZeusTransformUtils.wrapperContextForParams(r3, SkillShopActivity.class, "com.obric.aiagent.plugin");
        }

        @Override // androidx.viewpager2.widget.ViewPager2.e
        public void a(int r5, float r6, int r7) {
            boolean r0 = false;
            if (r5 >= 0) goto L5;
        L7:
            if (r0 == false) goto L13;
            OTabLayout r4 = SkillShopActivity.access$getDiscoveryTabs$p(this.f20468a);
            if (r4 != null) goto L11;
            d.h.b.o.c("discoveryTabs");
            r4 = null;
        L11:
            r4.setScrollPosition(r5, r6, true);
            return;
        L13:
            return;
        L5:
            if (r5 >= ((Collection) ZeusTransformUtils.preCheckCast(SkillShopActivity.access$getDiscoveryChannels$p(this.f20468a), Collection.class, "com.obric.aiagent.plugin")).size()) goto L7;
            r0 = true;
            goto L7
        }

        @Override // androidx.viewpager2.widget.ViewPager2.e
        public void b(int r4) {
            bu r0 = (bu) ZeusTransformUtils.preCheckCast(d.a.p.d(SkillShopActivity.access$getDiscoveryChannels$p(this.f20468a), r4), bu.class, "com.obric.aiagent.plugin");
            if (r0 != null) goto L5;
            return;
        L5:
            SkillShopActivity.access$setSelectedChannelKey$p(this.f20468a, r0.a());
            if (SkillShopActivity.access$getSuppressDiscoveryTabCallback$p(this.f20468a) == false) goto L8;
            return;
        L8:
            SkillShopActivity.access$setSuppressDiscoveryTabCallback$p(this.f20468a, true);
            OTabLayout r1 = SkillShopActivity.access$getDiscoveryTabs$p(this.f20468a);
            OTabLayout r2 = null;
            if (r1 != null) goto L12;
            d.h.b.o.c("discoveryTabs");
            r1 = null;
        L12:
            if (r1.getSelectedTabPosition() == r4) goto L18;
            OTabLayout r3 = SkillShopActivity.access$getDiscoveryTabs$p(this.f20468a);
            if (r3 != null) goto L16;
            d.h.b.o.c("discoveryTabs");
        L17:
            r2.selectTab(r4);
            goto L18
        L16:
            r2 = r3;
        L18:
            SkillShopActivity.access$setSuppressDiscoveryTabCallback$p(this.f20468a, false);
        }
    }

    /* JADX INFO: compiled from: SkillShopActivity.kt */
    @d.c.b.a.f(b = "SkillShopActivity.kt", c = {484}, d = "invokeSuspend", e = "com.obric.aiagent.skill.manager.impl.ui.SkillShopActivity$scheduleDiscoveryCompletionClear$1")
    static final class i extends d.c.b.a.l implements d.h.a.m<kotlinx.coroutines.am, d.c.d<? super d.x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f20469a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ SkillShopActivity f20470b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ String f20471c;

        i(SkillShopActivity r3, String r4, d.c.d<? super i> r5) {
            SkillShopActivity r6 = (SkillShopActivity) ZeusTransformUtils.wrapperContextForParams(r3, SkillShopActivity.class, "com.obric.aiagent.plugin");
            d.c.d r7 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
            this.f20470b = r6;
            this.f20471c = r4;
            super(2, r7);
        }

        public final Object a(kotlinx.coroutines.am r3, d.c.d<? super d.x> r4) {
            return ((i) ZeusTransformUtils.preCheckCast(create((kotlinx.coroutines.am) ZeusTransformUtils.wrapperContextForParams(r3, kotlinx.coroutines.am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), i.class, "com.obric.aiagent.plugin")).invokeSuspend(d.x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<d.x> create(Object r3, d.c.d<?> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new i(this.f20470b, this.f20471c, r5), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(kotlinx.coroutines.am r3, d.c.d<? super d.x> r4) {
            return a((kotlinx.coroutines.am) ZeusTransformUtils.preCheckCast(r3, kotlinx.coroutines.am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r6) {
            Object r0 = d.c.a.b.a();
            int r1 = this.f20469a;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            d.o.a(r6);
        L11:
            SkillShopActivity.access$getViewModel(this.f20470b).e(this.f20471c);
            return d.x.f38692a;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            d.o.a(r6);
            d.c.d r7 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.f20469a = 1;
            if (kotlinx.coroutines.ax.a(1000, r7) != r0) goto L11;
            return r0;
        }
    }

    /* JADX INFO: compiled from: SkillShopActivity.kt */
    /* synthetic */ class j extends d.h.b.l implements d.h.a.b<com.obric.aiagent.skill.manager.api.e, d.x> {
        j(Object r8) {
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

    /* JADX INFO: compiled from: SkillShopActivity.kt */
    /* synthetic */ class k extends d.h.b.l implements d.h.a.a<d.x> {
        k(Object r8) {
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

    /* JADX INFO: compiled from: SkillShopActivity.kt */
    public static final class l implements OTabLayoutBase.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ SkillShopActivity f20472a;

        @Override // com.obric.oui.tab.OTabLayoutBase.d
        public void b(OTabLayoutBase.e r1) {
            d.h.b.o.e(r1, "tab");
        }

        @Override // com.obric.oui.tab.OTabLayoutBase.d
        public void c(OTabLayoutBase.e r1) {
            d.h.b.o.e(r1, "tab");
        }

        l(SkillShopActivity r3) {
            this.f20472a = (SkillShopActivity) ZeusTransformUtils.wrapperContextForParams(r3, SkillShopActivity.class, "com.obric.aiagent.plugin");
        }

        @Override // com.obric.oui.tab.OTabLayoutBase.d
        public void a(OTabLayoutBase.e r5) {
            d.h.b.o.e(r5, "tab");
            if (SkillShopActivity.access$getSuppressDiscoveryTabCallback$p(this.f20472a) == false) goto L5;
            return;
        L5:
            bu r0 = (bu) ZeusTransformUtils.preCheckCast(d.a.p.d(SkillShopActivity.access$getDiscoveryChannels$p(this.f20472a), r5.c()), bu.class, "com.obric.aiagent.plugin");
            if (r0 != null) goto L8;
            return;
        L8:
            SkillShopActivity.access$setSelectedChannelKey$p(this.f20472a, r0.a());
            ViewPager2 r1 = SkillShopActivity.access$getDiscoveryViewPager$p(this.f20472a);
            ViewPager2 r2 = null;
            if (r1 != null) goto L12;
            d.h.b.o.c("discoveryViewPager");
            r1 = null;
        L12:
            if (r1.getCurrentItem() == r5.c()) goto L19;
            ViewPager2 r4 = SkillShopActivity.access$getDiscoveryViewPager$p(this.f20472a);
            if (r4 != null) goto L16;
            d.h.b.o.c("discoveryViewPager");
        L17:
            r2.setCurrentItem(r5.c(), false);
            return;
        L16:
            r2 = r4;
            goto L17
        }
    }

    /* JADX INFO: compiled from: SkillShopActivity.kt */
    public static final class m implements OTabLayoutBase.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ SkillShopActivity f20473a;

        @Override // com.obric.oui.tab.OTabLayoutBase.d
        public void b(OTabLayoutBase.e r1) {
            d.h.b.o.e(r1, "tab");
        }

        @Override // com.obric.oui.tab.OTabLayoutBase.d
        public void c(OTabLayoutBase.e r1) {
            d.h.b.o.e(r1, "tab");
        }

        m(SkillShopActivity r3) {
            this.f20473a = (SkillShopActivity) ZeusTransformUtils.wrapperContextForParams(r3, SkillShopActivity.class, "com.obric.aiagent.plugin");
        }

        @Override // com.obric.oui.tab.OTabLayoutBase.d
        public void a(OTabLayoutBase.e r3) {
            d.h.b.o.e(r3, "tab");
            SkillShopActivity r0 = this.f20473a;
            if (r3.c() != 1) goto L5;
            b r4 = b.f20438b;
        L6:
            SkillShopActivity.access$setSelectedShopSection$p(r0, r4);
            SkillShopActivity.access$renderShopSection(this.f20473a);
            return;
        L5:
            r4 = b.f20437a;
            goto L6
        }
    }

    static {
        Companion = new a(null);
    }

    /* JADX INFO: renamed from: lambda$1e-OzwlVKwW_aberUtFS_H0-cjU, reason: not valid java name */
    public static /* synthetic */ d.x m320lambda$1eOzwlVKwW_aberUtFS_H0cjU(SkillShopActivity r0, String r1) {
        return useDiscoverySkill$lambda$19$lambda$18(r0, r1);
    }

    public static /* synthetic */ ISkillManagerService lambda$AUPrXm4CZdDZ8FhoCtrL0jMOtgk(SkillShopActivity r0) {
        return createCreateFlowController$lambda$3(r0);
    }

    public static /* synthetic */ cg lambda$BEAtQOJ4DH4ujFAwT7TX4QLixWs(SkillShopActivity r0) {
        return viewModel_delegate$lambda$0(r0);
    }

    public static /* synthetic */ void lambda$EaRiCO3Flf5mauVm1eQR_MlSvvI(SkillShopActivity r0, View r1) {
        setupDiscoveryPage$lambda$6$lambda$5(r0, r1);
    }

    public static /* synthetic */ void lambda$L80SyfI9THLW_fJNL3Qh4EKuOTE(SkillShopActivity r0, View r1) {
        bindDiscoveryTitleBarActions$lambda$16(r0, r1);
    }

    public static /* synthetic */ void lambda$QMzjT3eE8s7fWnEVcYGWa_b3HT8(SkillShopActivity r0, View r1) {
        bindDiscoveryTitleBarActions$lambda$15(r0, r1);
    }

    public static /* synthetic */ d.x lambda$cWlWsHWbjrvwIGE0Rrfv71xhPQ8(SkillShopActivity r0, String r1) {
        return createCreateFlowController$lambda$4(r0, r1);
    }

    /* JADX INFO: renamed from: lambda$cks3KZuAO1z-1EwrrBcaLkWnZOY, reason: not valid java name */
    public static /* synthetic */ d.x m321lambda$cks3KZuAO1z1EwrrBcaLkWnZOY(SkillShopActivity r0) {
        return setupAppFunctionList$lambda$8(r0);
    }

    /* JADX INFO: renamed from: lambda$dFuA4QJetwxQCwLbpERt2BST0-g, reason: not valid java name */
    public static /* synthetic */ void m322lambda$dFuA4QJetwxQCwLbpERt2BST0g(SkillShopActivity r0, View r1) {
        bindDiscoveryTitleBarActions$lambda$17(r0, r1);
    }

    public static /* synthetic */ ISkillManagerService lambda$eTuN_Kmf2wtP2JeBm9elNRGLesI(SkillShopActivity r0) {
        return setupAppFunctionList$lambda$7(r0);
    }

    public static /* synthetic */ d.x lambda$jCTqFEB6Di3BvkSJlCZT4AO1T3A(SkillShopActivity r0, com.obric.aiagent.skill.manager.api.e r1) {
        return setupAppFunctionList$lambda$10(r0, r1);
    }

    /* JADX INFO: renamed from: lambda$qNr3Hk6FtE9f5-tSoNE75N2TtsE, reason: not valid java name */
    public static /* synthetic */ d.x m323lambda$qNr3Hk6FtE9f5tSoNE75N2TtsE(com.obric.aiagent.skill.manager.api.e r0, SkillShopActivity r1) {
        return useDiscoverySkill$lambda$19(r0, r1);
    }

    /* JADX INFO: renamed from: lambda$rTuuJm-q20tuWu_4Qt9NrSwUtxs, reason: not valid java name */
    public static /* synthetic */ ag m324lambda$rTuuJmq20tuWu_4Qt9NrSwUtxs(SkillShopActivity r0) {
        return enterPageTracker_delegate$lambda$2(r0);
    }

    public static /* synthetic */ d.x lambda$tpDFM3cDR_sIfnhZBgHHoZnSflo(SkillShopActivity r0, com.obric.aiagent.skill.manager.api.e r1, d.h.a.a r2) {
        return setupAppFunctionList$lambda$9(r0, r1, r2);
    }

    public static /* synthetic */ bp lambda$x1HZHJcdsvO6prYF9Ap1U7e8YLU(SkillShopActivity r0) {
        return enterPageTracker_delegate$lambda$2$lambda$1(r0);
    }

    public SkillShopActivity() {
        this.ioScope = kotlinx.coroutines.an.a(kotlinx.coroutines.bd.c().plus((d.c.g) ZeusTransformUtils.preCheckCast(cx.a(null, 1, null), d.c.g.class, "com.obric.aiagent.plugin")));
        this.mainScope = kotlinx.coroutines.an.a();
        this.viewModel$delegate = d.g.a(d.j.f38507c, new $$Lambda$SkillShopActivity$BEAtQOJ4DH4ujFAwT7TX4QLixWs(this));
        this.discoveryChannels = d.a.p.b();
        this.selectedChannelKey = "recommended";
        this.selectedShopSection = b.f20437a;
        this.pageActions = new g(this);
        this.enterPageTracker$delegate = d.g.a(new $$Lambda$SkillShopActivity$rTuuJmq20tuWu_4Qt9NrSwUtxs(this));
        this.pageChangeCallback = new h(this);
    }

    public static final /* synthetic */ void access$bindDiscoveryChannels(SkillShopActivity r2, List r3) {
        ((SkillShopActivity) ZeusTransformUtils.wrapperContextForParams(r2, SkillShopActivity.class, "com.obric.aiagent.plugin")).bindDiscoveryChannels((List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.aiagent.plugin"));
    }

    public static final /* synthetic */ boolean access$getAppFunctionEntryEnabled$p(SkillShopActivity r2) {
        return ((SkillShopActivity) ZeusTransformUtils.wrapperContextForParams(r2, SkillShopActivity.class, "com.obric.aiagent.plugin")).appFunctionEntryEnabled;
    }

    public static final /* synthetic */ List access$getDiscoveryChannels$p(SkillShopActivity r2) {
        return ((SkillShopActivity) ZeusTransformUtils.wrapperContextForParams(r2, SkillShopActivity.class, "com.obric.aiagent.plugin")).discoveryChannels;
    }

    public static final /* synthetic */ OTabLayout access$getDiscoveryTabs$p(SkillShopActivity r2) {
        return ((SkillShopActivity) ZeusTransformUtils.wrapperContextForParams(r2, SkillShopActivity.class, "com.obric.aiagent.plugin")).discoveryTabs;
    }

    public static final /* synthetic */ ViewPager2 access$getDiscoveryViewPager$p(SkillShopActivity r2) {
        return ((SkillShopActivity) ZeusTransformUtils.wrapperContextForParams(r2, SkillShopActivity.class, "com.obric.aiagent.plugin")).discoveryViewPager;
    }

    public static final /* synthetic */ kotlinx.coroutines.am access$getMainScope$p(SkillShopActivity r2) {
        return ((SkillShopActivity) ZeusTransformUtils.wrapperContextForParams(r2, SkillShopActivity.class, "com.obric.aiagent.plugin")).mainScope;
    }

    public static final /* synthetic */ boolean access$getSuppressDiscoveryTabCallback$p(SkillShopActivity r2) {
        return ((SkillShopActivity) ZeusTransformUtils.wrapperContextForParams(r2, SkillShopActivity.class, "com.obric.aiagent.plugin")).suppressDiscoveryTabCallback;
    }

    public static final /* synthetic */ cg access$getViewModel(SkillShopActivity r2) {
        return ((SkillShopActivity) ZeusTransformUtils.wrapperContextForParams(r2, SkillShopActivity.class, "com.obric.aiagent.plugin")).getViewModel();
    }

    public static final /* synthetic */ void access$initializeSkillPage(SkillShopActivity r2, ISkillManagerService r3) {
        ((SkillShopActivity) ZeusTransformUtils.wrapperContextForParams(r2, SkillShopActivity.class, "com.obric.aiagent.plugin")).initializeSkillPage((ISkillManagerService) ZeusTransformUtils.wrapperContextForParams(r3, ISkillManagerService.class, "com.obric.aiagent.plugin"));
    }

    public static final /* synthetic */ void access$installDiscoverySkill(SkillShopActivity r2, com.obric.aiagent.skill.manager.api.e r3) {
        ((SkillShopActivity) ZeusTransformUtils.wrapperContextForParams(r2, SkillShopActivity.class, "com.obric.aiagent.plugin")).installDiscoverySkill(r3);
    }

    public static final /* synthetic */ void access$openCollectionDetail(SkillShopActivity r2, String r3) {
        ((SkillShopActivity) ZeusTransformUtils.wrapperContextForParams(r2, SkillShopActivity.class, "com.obric.aiagent.plugin")).openCollectionDetail(r3);
    }

    public static final /* synthetic */ void access$renderAppFunctionSkills(SkillShopActivity r2, Collection r3) {
        ((SkillShopActivity) ZeusTransformUtils.wrapperContextForParams(r2, SkillShopActivity.class, "com.obric.aiagent.plugin")).renderAppFunctionSkills((Collection) ZeusTransformUtils.wrapperContextForParams(r3, Collection.class, "com.obric.aiagent.plugin"));
    }

    public static final /* synthetic */ void access$renderShopSection(SkillShopActivity r2) {
        ((SkillShopActivity) ZeusTransformUtils.wrapperContextForParams(r2, SkillShopActivity.class, "com.obric.aiagent.plugin")).renderShopSection();
    }

    public static final /* synthetic */ void access$scheduleDiscoveryCompletionClear(SkillShopActivity r2, String r3) {
        ((SkillShopActivity) ZeusTransformUtils.wrapperContextForParams(r2, SkillShopActivity.class, "com.obric.aiagent.plugin")).scheduleDiscoveryCompletionClear(r3);
    }

    public static final /* synthetic */ void access$setSelectedChannelKey$p(SkillShopActivity r2, String r3) {
        ((SkillShopActivity) ZeusTransformUtils.wrapperContextForParams(r2, SkillShopActivity.class, "com.obric.aiagent.plugin")).selectedChannelKey = r3;
    }

    public static final /* synthetic */ void access$setSelectedShopSection$p(SkillShopActivity r2, b r3) {
        ((SkillShopActivity) ZeusTransformUtils.wrapperContextForParams(r2, SkillShopActivity.class, "com.obric.aiagent.plugin")).selectedShopSection = r3;
    }

    public static final /* synthetic */ void access$setSuppressDiscoveryTabCallback$p(SkillShopActivity r2, boolean r3) {
        ((SkillShopActivity) ZeusTransformUtils.wrapperContextForParams(r2, SkillShopActivity.class, "com.obric.aiagent.plugin")).suppressDiscoveryTabCallback = r3;
    }

    public static final /* synthetic */ void access$useDiscoverySkill(SkillShopActivity r2, com.obric.aiagent.skill.manager.api.e r3) {
        ((SkillShopActivity) ZeusTransformUtils.wrapperContextForParams(r2, SkillShopActivity.class, "com.obric.aiagent.plugin")).useDiscoverySkill(r3);
    }

    private final cg getViewModel() {
        return (cg) ZeusTransformUtils.preCheckCast(this.viewModel$delegate.b(), cg.class, "com.obric.aiagent.plugin");
    }

    private static final cg viewModel_delegate$lambda$0(SkillShopActivity r3) {
        return (cg) ZeusTransformUtils.preCheckCast(new androidx.lifecycle.am((androidx.lifecycle.ap) ZeusTransformUtils.preCheckCast((SkillShopActivity) ZeusTransformUtils.wrapperContextForParams(r3, SkillShopActivity.class, "com.obric.aiagent.plugin"), androidx.lifecycle.ap.class, "com.obric.aiagent.plugin")).a(cg.class), cg.class, "com.obric.aiagent.plugin");
    }

    private final ag getEnterPageTracker() {
        return (ag) ZeusTransformUtils.preCheckCast(this.enterPageTracker$delegate.b(), ag.class, "com.obric.aiagent.plugin");
    }

    private static final ag enterPageTracker_delegate$lambda$2(SkillShopActivity r7) {
        final SkillShopActivity r8 = (SkillShopActivity) ZeusTransformUtils.wrapperContextForParams(r7, SkillShopActivity.class, "com.obric.aiagent.plugin");
        return new ag(new $$Lambda$SkillShopActivity$x1HZHJcdsvO6prYF9Ap1U7e8YLU(r8), null, null, 6, null);
    }

    private static final bp enterPageTracker_delegate$lambda$2$lambda$1(SkillShopActivity r2) {
        Intent r3 = ((SkillShopActivity) ZeusTransformUtils.wrapperContextForParams(r2, SkillShopActivity.class, "com.obric.aiagent.plugin")).getIntent();
        d.h.b.o.c(r3, "getIntent(...)");
        return bo.a(r3, dr.f19761b);
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity
    public void onCreate(Bundle r4) {
        super.onCreate(r4);
        configureSystemBars();
        setContentView(ZeusTransformUtils.mapRes(R.layout.activity_skill_shop, "layout", "activity_skill_shop"));
        installSkillPageGuard(ZeusTransformUtils.mapRes(R.id.skill_shop_root, DbHelper.COL_ID, "skill_shop_root"), (d.h.a.b) ZeusTransformUtils.preCheckCast(new f(this), d.h.a.b.class, "com.obric.aiagent.plugin"));
    }

    @Override // com.obric.aiagent.skill.manager.impl.ui.SkillGatedActivity
    public OFloatingTitleBar getFloatingTitleBar() {
        OFloatingTitleBar r1 = this.discoveryTitleBar;
        if (r1 == null) goto L7;
        if (r1 != null) goto L8;
        d.h.b.o.c("discoveryTitleBar");
        goto L7
    L8:
        return r1;
    L7:
        return null;
    }

    private final void initializeSkillPage(ISkillManagerService r4) {
        this.skillManager = (ISkillManagerService) ZeusTransformUtils.wrapperContextForParams(r4, ISkillManagerService.class, "com.obric.aiagent.plugin");
        boolean r5 = com.obric.aiagent.executionengine.capabilitymanager.api.appfunction.a.f16409a.a().b();
        this.appFunctionEntryEnabled = r5;
        if (r5 == true) goto L5;
        this.selectedShopSection = b.f20437a;
    L5:
        bindViews();
        this.createFlowController = createCreateFlowController();
        setupDiscoveryPage();
        cg r6 = getViewModel();
        String r0 = getString(ZeusTransformUtils.mapRes(R.string.obric_skill_shop_recommended_tab, WsChannelMultiProcessSharedProvider.STRING_TYPE, "obric_skill_shop_recommended_tab"));
        d.h.b.o.c(r0, "getString(...)");
        r6.a(r0);
        observeShopState();
        ensureSkillObserverStarted();
    }

    private final void configureSystemBars() {
        bh.a((FragmentActivity) ZeusTransformUtils.preCheckCast(this, FragmentActivity.class, "com.obric.aiagent.plugin"), false, 0, false, 7, null);
    }

    @Override // androidx.fragment.app.FragmentActivity
    public void onDestroy() {
        ViewPager2 r0 = this.discoveryViewPager;
        if (r0 != null) goto L5;
    L11:
        OTabLayout r1 = this.discoveryTabs;
        if (r1 == null) goto L16;
        if (r1 != null) goto L15;
        d.h.b.o.c("discoveryTabs");
        r1 = null;
    L15:
        r1.clearOnTabSelectedListeners();
    L16:
        OTabLayout r2 = this.discoveryPrimaryTabs;
        if (r2 == null) goto L21;
        if (r2 != null) goto L20;
        d.h.b.o.c("discoveryPrimaryTabs");
        r2 = null;
    L20:
        r2.clearOnTabSelectedListeners();
    L21:
        kotlinx.coroutines.ca r3 = this.skillStateJob;
        if (r3 == null) goto L24;
        kotlinx.coroutines.ca.a.a(r3, null, 1, null);
    L24:
        kotlinx.coroutines.ca r4 = this.shopStateJob;
        if (r4 == null) goto L27;
        kotlinx.coroutines.ca.a.a(r4, null, 1, null);
    L27:
        x r5 = this.createFlowController;
        if (r5 == null) goto L30;
        r5.a();
    L30:
        this.createFlowController = null;
        kotlinx.coroutines.an.a(this.ioScope, null, 1, null);
        kotlinx.coroutines.an.a(this.mainScope, null, 1, null);
        super.onDestroy();
        return;
    L5:
        if (r0 != null) goto L7;
        d.h.b.o.c("discoveryViewPager");
        r0 = null;
    L7:
        r0.unregisterOnPageChangeCallback((ViewPager2.e) ZeusTransformUtils.preCheckCast(this.pageChangeCallback, ViewPager2.e.class, "com.obric.aiagent.plugin"));
        ViewPager2 r6 = this.discoveryViewPager;
        if (r6 != null) goto L10;
        d.h.b.o.c("discoveryViewPager");
        r6 = null;
    L10:
        r6.setAdapter(null);
        goto L11
    }

    private final void bindViews() {
        View r0 = findViewById(ZeusTransformUtils.mapRes(R.id.discovery_primary_tabs, DbHelper.COL_ID, "discovery_primary_tabs"));
        d.h.b.o.c(r0, "findViewById(...)");
        OTabLayout r1 = (OTabLayout) ZeusTransformUtils.preCheckCast(r0, OTabLayout.class, "com.obric.aiagent.plugin");
        this.discoveryPrimaryTabs = r1;
        RecyclerView r3 = null;
        if (r1 != null) goto L6;
        d.h.b.o.c("discoveryPrimaryTabs");
        r1 = null;
    L6:
        if (this.appFunctionEntryEnabled == false) goto L8;
        int r5 = 0;
    L9:
        r1.setVisibility(r5);
        View r2 = findViewById(ZeusTransformUtils.mapRes(R.id.discovery_tabs, DbHelper.COL_ID, "discovery_tabs"));
        d.h.b.o.c(r2, "findViewById(...)");
        this.discoveryTabs = (OTabLayout) ZeusTransformUtils.preCheckCast(r2, OTabLayout.class, "com.obric.aiagent.plugin");
        View r4 = findViewById(ZeusTransformUtils.mapRes(R.id.discovery_top_content, DbHelper.COL_ID, "discovery_top_content"));
        d.h.b.o.c(r4, "findViewById(...)");
        this.discoveryTopContent = r4;
        View r6 = findViewById(ZeusTransformUtils.mapRes(R.id.discovery_view_pager, DbHelper.COL_ID, "discovery_view_pager"));
        d.h.b.o.c(r6, "findViewById(...)");
        this.discoveryViewPager = (ViewPager2) ZeusTransformUtils.preCheckCast(r6, ViewPager2.class, "com.obric.aiagent.plugin");
        View r7 = findViewById(ZeusTransformUtils.mapRes(R.id.discovery_floating_title_bar, DbHelper.COL_ID, "discovery_floating_title_bar"));
        d.h.b.o.c(r7, "findViewById(...)");
        OFloatingTitleBar r8 = (OFloatingTitleBar) ZeusTransformUtils.preCheckCast(r7, OFloatingTitleBar.class, "com.obric.aiagent.plugin");
        this.discoveryTitleBar = r8;
        if (r8 != null) goto L12;
        d.h.b.o.c("discoveryTitleBar");
        r8 = null;
    L12:
        r8.setFloatingTransitionEnabled(true);
        View r9 = findViewById(ZeusTransformUtils.mapRes(R.id.app_function_panel, DbHelper.COL_ID, "app_function_panel"));
        d.h.b.o.c(r9, "findViewById(...)");
        this.appFunctionPanel = r9;
        View r10 = findViewById(ZeusTransformUtils.mapRes(R.id.app_function_list, DbHelper.COL_ID, "app_function_list"));
        d.h.b.o.c(r10, "findViewById(...)");
        RecyclerView r11 = (RecyclerView) ZeusTransformUtils.preCheckCast(r10, RecyclerView.class, "com.obric.aiagent.plugin");
        this.appFunctionList = r11;
        if (this.appFunctionEntryEnabled == false) goto L18;
        if (r11 != null) goto L16;
        d.h.b.o.c("appFunctionList");
    L17:
        bh.a(r3, ZeusTransformUtils.getResources(this, "com.obric.aiagent.plugin").getDimensionPixelSize(ZeusTransformUtils.mapRes(R.dimen.skill_navigation_list_extra_bottom, "dimen", "skill_navigation_list_extra_bottom")));
        goto L18
    L16:
        r3 = r11;
    L18:
        View r12 = findViewById(ZeusTransformUtils.mapRes(R.id.app_function_empty, DbHelper.COL_ID, "app_function_empty"));
        d.h.b.o.c(r12, "findViewById(...)");
        this.appFunctionEmpty = r12;
        bindDiscoveryTitleBarActions();
        return;
    L8:
        r5 = 8;
        goto L9
    }

    private final x createCreateFlowController() {
        return new x((FragmentActivity) ZeusTransformUtils.preCheckCast(this, FragmentActivity.class, "com.obric.aiagent.plugin"), new $$Lambda$SkillShopActivity$AUPrXm4CZdDZ8FhoCtrL0jMOtgk(this), this.ioScope, this.mainScope, new $$Lambda$SkillShopActivity$cWlWsHWbjrvwIGE0Rrfv71xhPQ8(this));
    }

    private static final ISkillManagerService createCreateFlowController$lambda$3(SkillShopActivity r2) {
        return ((SkillShopActivity) ZeusTransformUtils.wrapperContextForParams(r2, SkillShopActivity.class, "com.obric.aiagent.plugin")).skillManager;
    }

    private static final d.x createCreateFlowController$lambda$4(SkillShopActivity r6, String r7) {
        SkillShopActivity r0 = (SkillShopActivity) ZeusTransformUtils.wrapperContextForParams(r6, SkillShopActivity.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r7, "slug");
        openSkillDetail$default(r0, r7, null, br.f20662a.a(dr.f19761b), 2, null);
        return d.x.f38692a;
    }

    private final void setupDiscoveryPage() {
        View r0 = findViewById(ZeusTransformUtils.mapRes(R.id.discovery_create, DbHelper.COL_ID, "discovery_create"));
        d.h.b.o.a(r0);
        OTabLayout r3 = null;
        bh.a(r0, 0, 1, null);
        r0.setOnClickListener(new $$Lambda$SkillShopActivity$EaRiCO3Flf5mauVm1eQR_MlSvvI(this));
        updateCreateButtonVisibility();
        this.discoveryPagerAdapter = new ce((FragmentActivity) ZeusTransformUtils.preCheckCast(this, FragmentActivity.class, "com.obric.aiagent.plugin"), this.appFunctionEntryEnabled);
        ViewPager2 r1 = this.discoveryViewPager;
        if (r1 != null) goto L5;
        d.h.b.o.c("discoveryViewPager");
        r1 = null;
    L5:
        ce r5 = this.discoveryPagerAdapter;
        if (r5 != null) goto L8;
        d.h.b.o.c("discoveryPagerAdapter");
        r5 = null;
    L8:
        r1.setAdapter((androidx.recyclerview.widget.RecyclerView.a) ZeusTransformUtils.preCheckCast(r5, androidx.recyclerview.widget.RecyclerView.a.class, "com.obric.aiagent.plugin"));
        ViewPager2 r2 = this.discoveryViewPager;
        if (r2 != null) goto L11;
        d.h.b.o.c("discoveryViewPager");
        r2 = null;
    L11:
        r2.setUserInputEnabled(true);
        ViewPager2 r4 = this.discoveryViewPager;
        if (r4 != null) goto L14;
        d.h.b.o.c("discoveryViewPager");
        r4 = null;
    L14:
        r4.registerOnPageChangeCallback((ViewPager2.e) ZeusTransformUtils.preCheckCast(this.pageChangeCallback, ViewPager2.e.class, "com.obric.aiagent.plugin"));
        if (this.appFunctionEntryEnabled == false) goto L17;
        setupPrimaryTabs();
        setupAppFunctionList();
    L17:
        OTabLayout r6 = this.discoveryTabs;
        if (r6 != null) goto L20;
        d.h.b.o.c("discoveryTabs");
    L21:
        r3.addOnTabSelectedListener((OTabLayoutBase.d) ZeusTransformUtils.preCheckCast(new l(this), OTabLayoutBase.d.class, "com.obric.aiagent.plugin"));
        renderShopSection();
        return;
    L20:
        r3 = r6;
        goto L21
    }

    private static final void setupDiscoveryPage$lambda$6$lambda$5(SkillShopActivity r1, View r2) {
        x r3 = ((SkillShopActivity) ZeusTransformUtils.wrapperContextForParams(r1, SkillShopActivity.class, "com.obric.aiagent.plugin")).createFlowController;
        if (r3 == null) goto L6;
        r3.b();
        return;
    }

    private final void setupPrimaryTabs() {
        OTabLayout r0 = this.discoveryPrimaryTabs;
        if (r0 != null) goto L5;
        d.h.b.o.c("discoveryPrimaryTabs");
        r0 = null;
    L5:
        r0.addOnTabSelectedListener((OTabLayoutBase.d) ZeusTransformUtils.preCheckCast(new m(this), OTabLayoutBase.d.class, "com.obric.aiagent.plugin"));
    }

    private final void setupAppFunctionList() {
        RecyclerView r0 = this.appFunctionList;
        com.obric.aiagent.skill.manager.impl.ui.c r2 = null;
        if (r0 != null) goto L5;
        d.h.b.o.c("appFunctionList");
        r0 = null;
    L5:
        r0.setLayoutManager((RecyclerView.h) ZeusTransformUtils.preCheckCast(new LinearLayoutManager((Context) ZeusTransformUtils.preCheckCast(this, Context.class, "com.obric.aiagent.plugin")), RecyclerView.h.class, "com.obric.aiagent.plugin"));
        RecyclerView r1 = this.appFunctionList;
        if (r1 != null) goto L8;
        d.h.b.o.c("appFunctionList");
        r1 = null;
    L8:
        r1.setItemAnimator(null);
        this.appFunctionInteractionController = new com.obric.aiagent.skill.manager.impl.ui.g((FragmentActivity) ZeusTransformUtils.preCheckCast(this, FragmentActivity.class, "com.obric.aiagent.plugin"), new $$Lambda$SkillShopActivity$eTuN_Kmf2wtP2JeBm9elNRGLesI(this), new $$Lambda$SkillShopActivity$cks3KZuAO1z1EwrrBcaLkWnZOY(this), new $$Lambda$SkillShopActivity$tpDFM3cDR_sIfnhZBgHHoZnSflo(this));
        d.h.a.b r9 = new $$Lambda$SkillShopActivity$jCTqFEB6Di3BvkSJlCZT4AO1T3A(this);
        com.obric.aiagent.skill.manager.impl.ui.g r4 = this.appFunctionInteractionController;
        if (r4 != null) goto L11;
        d.h.b.o.c("appFunctionInteractionController");
        r4 = null;
    L11:
        d.h.a.b r10 = (d.h.a.b) ZeusTransformUtils.preCheckCast(new j(r4), d.h.a.b.class, "com.obric.aiagent.plugin");
        com.obric.aiagent.skill.manager.impl.ui.g r5 = this.appFunctionInteractionController;
        if (r5 != null) goto L14;
        d.h.b.o.c("appFunctionInteractionController");
        r5 = null;
    L14:
        this.appFunctionAdapter = new com.obric.aiagent.skill.manager.impl.ui.h(r9, r10, (d.h.a.a) ZeusTransformUtils.preCheckCast(new k(r5), d.h.a.a.class, "com.obric.aiagent.plugin"), false, com.obric.aiagent.skill.manager.impl.ui.f.f20777b);
        this.appFunctionNoteAdapter = new com.obric.aiagent.skill.manager.impl.ui.c();
        RecyclerView r3 = this.appFunctionList;
        if (r3 != null) goto L17;
        d.h.b.o.c("appFunctionList");
        r3 = null;
    L17:
        RecyclerView.a[] r6 = new RecyclerView.a[2];
        com.obric.aiagent.skill.manager.impl.ui.h r7 = this.appFunctionAdapter;
        if (r7 != null) goto L20;
        d.h.b.o.c("appFunctionAdapter");
        r7 = null;
    L20:
        r6[0] = r7;
        com.obric.aiagent.skill.manager.impl.ui.c r14 = this.appFunctionNoteAdapter;
        if (r14 != null) goto L23;
        d.h.b.o.c("appFunctionNoteAdapter");
    L24:
        r6[1] = r2;
        r3.setAdapter((RecyclerView.a) ZeusTransformUtils.preCheckCast(new com.obric.oui.orecyclerview.widget.g(r6), RecyclerView.a.class, "com.obric.aiagent.plugin"));
        return;
    L23:
        r2 = r14;
        goto L24
    }

    private static final ISkillManagerService setupAppFunctionList$lambda$7(SkillShopActivity r2) {
        return ((SkillShopActivity) ZeusTransformUtils.wrapperContextForParams(r2, SkillShopActivity.class, "com.obric.aiagent.plugin")).skillManager;
    }

    private static final d.x setupAppFunctionList$lambda$8(SkillShopActivity r2) {
        com.obric.aiagent.skill.manager.impl.ui.h r3 = ((SkillShopActivity) ZeusTransformUtils.wrapperContextForParams(r2, SkillShopActivity.class, "com.obric.aiagent.plugin")).appFunctionAdapter;
        if (r3 != null) goto L5;
        d.h.b.o.c("appFunctionAdapter");
        r3 = null;
    L5:
        r3.b();
        return d.x.f38692a;
    }

    private static final d.x setupAppFunctionList$lambda$9(SkillShopActivity r2, com.obric.aiagent.skill.manager.api.e r3, d.h.a.a r4) {
        SkillShopActivity r5 = (SkillShopActivity) ZeusTransformUtils.wrapperContextForParams(r2, SkillShopActivity.class, "com.obric.aiagent.plugin");
        d.h.a.a r6 = (d.h.a.a) ZeusTransformUtils.wrapperContextForParams(r4, d.h.a.a.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r3, "skill");
        d.h.b.o.e(r6, "confirm");
        com.obric.aiagent.skill.manager.impl.ui.d.a((FragmentActivity) ZeusTransformUtils.preCheckCast(r5, FragmentActivity.class, "com.obric.aiagent.plugin"), r3, r6);
        return d.x.f38692a;
    }

    private static final d.x setupAppFunctionList$lambda$10(SkillShopActivity r6, com.obric.aiagent.skill.manager.api.e r7) {
        SkillShopActivity r0 = (SkillShopActivity) ZeusTransformUtils.wrapperContextForParams(r6, SkillShopActivity.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r7, "skill");
        openSkillDetail$default(r0, r7.a(), null, null, 6, null);
        return d.x.f38692a;
    }

    private final void renderShopSection() {
        int r1 = 0;
        if (this.appFunctionEntryEnabled == true) goto L5;
    L7:
        boolean r0 = false;
    L8:
        OTabLayout r2 = this.discoveryPrimaryTabs;
        OTabLayout r3 = null;
        if (r2 != null) goto L11;
        d.h.b.o.c("discoveryPrimaryTabs");
        r2 = null;
    L11:
        int r5 = 8;
        if (this.appFunctionEntryEnabled == false) goto L14;
        int r4 = 0;
    L15:
        r2.setVisibility(r4);
        ViewPager2 r6 = this.discoveryViewPager;
        if (r6 != null) goto L18;
        d.h.b.o.c("discoveryViewPager");
        r6 = null;
    L18:
        if (r0 == false) goto L20;
        int r7 = 8;
    L21:
        r6.setVisibility(r7);
        OTabLayout r8 = this.discoveryTabs;
        if (r8 != null) goto L24;
        d.h.b.o.c("discoveryTabs");
        r8 = null;
    L24:
        if (r0 == false) goto L26;
        int r9 = 8;
    L27:
        r8.setVisibility(r9);
        View r10 = this.appFunctionPanel;
        if (r10 != null) goto L30;
        d.h.b.o.c("appFunctionPanel");
        r10 = null;
    L30:
        if (r0 == false) goto L32;
        r5 = 0;
    L32:
        r10.setVisibility(r5);
        View r11 = this.discoveryTopContent;
        if (r11 != null) goto L36;
        d.h.b.o.c("discoveryTopContent");
        r11 = null;
    L36:
        if (this.appFunctionEntryEnabled == false) goto L43;
        if (r0 == true) goto L43;
        OTabLayout r12 = this.discoveryTabs;
        if (r12 != null) goto L41;
        d.h.b.o.c("discoveryTabs");
    L42:
        r1 = r3.getLayoutParams().height;
        goto L43
    L41:
        r3 = r12;
    L43:
        r11.setPadding(r11.getPaddingLeft(), r11.getPaddingTop(), r11.getPaddingRight(), r1);
        return;
    L26:
        r9 = 0;
        goto L27
    L20:
        r7 = 0;
        goto L21
    L14:
        r4 = 8;
        goto L15
    L5:
        if (this.selectedShopSection != b.f20438b) goto L7;
        r0 = true;
        goto L8
    }

    private final void observeShopState() {
        if (this.shopStateJob == null) goto L5;
        return;
    L5:
        this.shopStateJob = kotlinx.coroutines.i.a(this.mainScope, null, null, (d.h.a.m) ZeusTransformUtils.preCheckCast(new e(this, null), d.h.a.m.class, "com.obric.aiagent.plugin"), 3, null);
    }

    private final void renderAppFunctionSkills(Collection<com.obric.aiagent.skill.manager.api.e> r7) {
        Iterable r8 = (Iterable) ZeusTransformUtils.preCheckCast((Collection) ZeusTransformUtils.wrapperContextForParams(r7, Collection.class, "com.obric.aiagent.plugin"), Iterable.class, "com.obric.aiagent.plugin");
        Collection r0 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.aiagent.plugin");
        Iterator r9 = r8.iterator();
    L4:
        if (r9.hasNext() == false) goto L8;
        Object r2 = r9.next();
        if (d.h.b.o.a(((com.obric.aiagent.skill.manager.api.e) ZeusTransformUtils.preCheckCast(r2, com.obric.aiagent.skill.manager.api.e.class, "com.obric.aiagent.plugin")).g(), com.obric.aiagent.skill.manager.api.aq.a.f19212a) == false) goto L4;
        r0.add(r2);
        goto L4
    L8:
        List<com.obric.aiagent.skill.manager.api.e> r10 = com.obric.aiagent.skill.manager.impl.az.a((Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r0, List.class, "com.obric.aiagent.plugin"), Iterable.class, "com.obric.aiagent.plugin"));
        boolean r1 = !((Collection) ZeusTransformUtils.preCheckCast(r10, Collection.class, "com.obric.aiagent.plugin")).isEmpty();
        RecyclerView r3 = this.appFunctionList;
        com.obric.aiagent.skill.manager.impl.ui.c r4 = null;
        if (r3 != null) goto L11;
        d.h.b.o.c("appFunctionList");
        r3 = null;
    L11:
        int r5 = 0;
        if (r1 == false) goto L14;
        int r6 = 0;
    L15:
        r3.setVisibility(r6);
        View r11 = this.appFunctionEmpty;
        if (r11 != null) goto L18;
        d.h.b.o.c("appFunctionEmpty");
        r11 = null;
    L18:
        if (r1 == false) goto L20;
        r5 = 8;
    L20:
        r11.setVisibility(r5);
        com.obric.aiagent.skill.manager.impl.ui.h r12 = this.appFunctionAdapter;
        if (r12 != null) goto L23;
        d.h.b.o.c("appFunctionAdapter");
        r12 = null;
    L23:
        r12.a(r10);
        com.obric.aiagent.skill.manager.impl.ui.c r13 = this.appFunctionNoteAdapter;
        if (r13 != null) goto L26;
        d.h.b.o.c("appFunctionNoteAdapter");
    L27:
        r4.a_(r1);
        return;
    L26:
        r4 = r13;
        goto L27
    L14:
        r6 = 8;
        goto L15
    }

    private final void bindDiscoveryChannels(List<? extends bu> r13) {
        List r14 = (List) ZeusTransformUtils.wrapperContextForParams(r13, List.class, "com.obric.aiagent.plugin");
        if (r14.isEmpty() == false) goto L5;
        return;
    L5:
        List<? extends bu> r15 = d.a.p.o((Iterable) ZeusTransformUtils.preCheckCast(r14, Iterable.class, "com.obric.aiagent.plugin"));
        this.discoveryChannels = r15;
        Iterator<? extends bu> r16 = r15.iterator();
        int r2 = 0;
    L7:
        if (r16.hasNext() == false) goto L12;
        if (d.h.b.o.a(((bu) ZeusTransformUtils.preCheckCast(r16.next(), bu.class, "com.obric.aiagent.plugin")).a(), this.selectedChannelKey) == true) goto L13;
        r2 = r2 + 1;
    L13:
        Integer r17 = Integer.valueOf(r2);
        if (((Number) ZeusTransformUtils.preCheckCast(r17, Number.class, "com.obric.aiagent.plugin")).intValue() < 0) goto L16;
        boolean r3 = true;
    L17:
        OTabLayout r4 = null;
        if (r3 == true) goto L21;
        r17 = null;
    L21:
        if (r17 == null) goto L23;
        int r18 = r17.intValue();
    L24:
        this.selectedChannelKey = ((bu) ZeusTransformUtils.preCheckCast(this.discoveryChannels.get(r18), bu.class, "com.obric.aiagent.plugin")).a();
        this.suppressDiscoveryTabCallback = true;
        ce r5 = this.discoveryPagerAdapter;
        if (r5 != null) goto L27;
        d.h.b.o.c("discoveryPagerAdapter");
        r5 = null;
    L27:
        r5.a(this.discoveryChannels);
        OTabLayout r6 = this.discoveryTabs;
        if (r6 != null) goto L30;
        d.h.b.o.c("discoveryTabs");
        r6 = null;
    L30:
        r6.removeAllTabs();
        Iterator r7 = ((Iterable) ZeusTransformUtils.preCheckCast(this.discoveryChannels, Iterable.class, "com.obric.aiagent.plugin")).iterator();
        int r8 = 0;
    L32:
        if (r7.hasNext() == false) goto L47;
        Object r9 = r7.next();
        int r10 = r8 + 1;
        if (r8 >= 0) goto L36;
        d.a.p.c();
    L36:
        bu r11 = (bu) ZeusTransformUtils.preCheckCast(r9, bu.class, "com.obric.aiagent.plugin");
        OTabLayout r12 = this.discoveryTabs;
        if (r12 != null) goto L39;
        d.h.b.o.c("discoveryTabs");
        r12 = null;
    L39:
        OTabLayout r19 = this.discoveryTabs;
        if (r19 != null) goto L42;
        d.h.b.o.c("discoveryTabs");
        r19 = null;
    L42:
        OTabLayoutBase.e r20 = r19.newTab(0).a((CharSequence) ZeusTransformUtils.preCheckCast(r11.b(), CharSequence.class, "com.obric.aiagent.plugin"));
        if (r8 != r18) goto L45;
        boolean r21 = true;
    L46:
        r12.addTab(r20, r21);
        r8 = r10;
        goto L32
    L45:
        r21 = false;
        goto L46
    L47:
        ViewPager2 r1 = this.discoveryViewPager;
        if (r1 != null) goto L51;
        d.h.b.o.c("discoveryViewPager");
        r1 = null;
    L51:
        if (r1.getCurrentItem() == r18) goto L56;
        ViewPager2 r22 = this.discoveryViewPager;
        if (r22 != null) goto L55;
        d.h.b.o.c("discoveryViewPager");
        r22 = null;
    L55:
        r22.setCurrentItem(r18, false);
    L56:
        OTabLayout r23 = this.discoveryTabs;
        if (r23 != null) goto L60;
        d.h.b.o.c("discoveryTabs");
        r23 = null;
    L60:
        if (r23.getSelectedTabPosition() == r18) goto L66;
        OTabLayout r24 = this.discoveryTabs;
        if (r24 != null) goto L64;
        d.h.b.o.c("discoveryTabs");
    L65:
        r4.selectTab(r18);
        goto L66
    L64:
        r4 = r24;
    L66:
        this.suppressDiscoveryTabCallback = false;
        return;
    L23:
        r18 = 0;
        goto L24
    L16:
        r3 = false;
        goto L17
    L12:
        r2 = -1;
        goto L13
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

    @Override // androidx.fragment.app.FragmentActivity
    public void onPostResume() {
        super.onPostResume();
        if (isSkillPageAvailable() == true) goto L5;
        return;
    L5:
        getEnterPageTracker().a();
    }

    @Override // com.obric.aiagent.skill.manager.impl.ui.SkillGatedActivity, androidx.fragment.app.FragmentActivity
    public void onResume() {
        super.onResume();
        if (isSkillPageAvailable() == true) goto L5;
        return;
    L5:
        updateCreateButtonVisibility();
    }

    private final void updateCreateButtonVisibility() {
        com.obric.aiagent.skill.manager.api.al r0 = com.obric.aiagent.skill.manager.api.al.f19195a.a();
        int r2 = 0;
        if (com.obric.aiagent.skill.manager.impl.bs.f19588a.a(r0) == false) goto L5;
    L8:
        boolean r1 = true;
    L9:
        View r5 = findViewById(ZeusTransformUtils.mapRes(R.id.discovery_create, DbHelper.COL_ID, "discovery_create"));
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

    private final void bindDiscoveryTitleBarActions() {
        OFloatingTitleBar r0 = this.discoveryTitleBar;
        OFloatingTitleBar r1 = null;
        if (r0 != null) goto L5;
        d.h.b.o.c("discoveryTitleBar");
        r0 = null;
    L5:
        r0.addStartAction(ZeusTransformUtils.mapRes(R.drawable.o_floating_title_bar_icon_back, "drawable", "o_floating_title_bar_icon_back"), 0, new $$Lambda$SkillShopActivity$QMzjT3eE8s7fWnEVcYGWa_b3HT8(this)).setContentDescription((CharSequence) ZeusTransformUtils.preCheckCast(getString(ZeusTransformUtils.mapRes(R.string.obric_skill_common_back, WsChannelMultiProcessSharedProvider.STRING_TYPE, "obric_skill_common_back")), CharSequence.class, "com.obric.aiagent.plugin"));
        OFloatingTitleBar r2 = this.discoveryTitleBar;
        if (r2 != null) goto L8;
        d.h.b.o.c("discoveryTitleBar");
        r2 = null;
    L8:
        r2.addEndAction(ZeusTransformUtils.mapRes(R.drawable.oic_circle_4, "drawable", "oic_circle_4"), 0, new $$Lambda$SkillShopActivity$L80SyfI9THLW_fJNL3Qh4EKuOTE(this)).setContentDescription((CharSequence) ZeusTransformUtils.preCheckCast(getString(ZeusTransformUtils.mapRes(R.string.obric_skill_management_my_skills, WsChannelMultiProcessSharedProvider.STRING_TYPE, "obric_skill_management_my_skills")), CharSequence.class, "com.obric.aiagent.plugin"));
        OFloatingTitleBar r3 = this.discoveryTitleBar;
        if (r3 != null) goto L11;
        d.h.b.o.c("discoveryTitleBar");
    L12:
        r1.addEndAction(ZeusTransformUtils.mapRes(R.drawable.oic_magnifier_search, "drawable", "oic_magnifier_search"), 0, new $$Lambda$SkillShopActivity$dFuA4QJetwxQCwLbpERt2BST0g(this)).setContentDescription((CharSequence) ZeusTransformUtils.preCheckCast(getString(ZeusTransformUtils.mapRes(R.string.obric_skill_common_search, WsChannelMultiProcessSharedProvider.STRING_TYPE, "obric_skill_common_search")), CharSequence.class, "com.obric.aiagent.plugin"));
        return;
    L11:
        r1 = r3;
        goto L12
    }

    private static final void bindDiscoveryTitleBarActions$lambda$15(SkillShopActivity r1, View r2) {
        ((SkillShopActivity) ZeusTransformUtils.wrapperContextForParams(r1, SkillShopActivity.class, "com.obric.aiagent.plugin")).finish();
    }

    private static final void bindDiscoveryTitleBarActions$lambda$16(SkillShopActivity r2, View r3) {
        SkillShopActivity r4 = (SkillShopActivity) ZeusTransformUtils.wrapperContextForParams(r2, SkillShopActivity.class, "com.obric.aiagent.plugin");
        r4.launchFloatingActivity(SkillManagementActivity.Companion.a((Context) ZeusTransformUtils.preCheckCast(r4, Context.class, "com.obric.aiagent.plugin"), br.f20662a.a()));
    }

    private static final void bindDiscoveryTitleBarActions$lambda$17(SkillShopActivity r2, View r3) {
        SkillShopActivity r4 = (SkillShopActivity) ZeusTransformUtils.wrapperContextForParams(r2, SkillShopActivity.class, "com.obric.aiagent.plugin");
        if (r4.selectedShopSection != b.f20438b) goto L5;
        Intent r5 = SkillSearchActivity.Companion.c((Context) ZeusTransformUtils.preCheckCast(r4, Context.class, "com.obric.aiagent.plugin"));
    L6:
        r4.launchFloatingActivity(r5);
        return;
    L5:
        r5 = SkillSearchActivity.Companion.a((Context) ZeusTransformUtils.preCheckCast(r4, Context.class, "com.obric.aiagent.plugin"));
        goto L6
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

    private final void installDiscoverySkill(com.obric.aiagent.skill.manager.api.e r9) {
        ISkillManagerService r0 = this.skillManager;
        if (r0 != null) goto L6;
        return;
    L6:
        if (getViewModel().c(r9.a()) == true) goto L8;
        return;
    L8:
        kotlinx.coroutines.i.a(this.ioScope, null, null, (d.h.a.m) ZeusTransformUtils.preCheckCast(new d(r0, r9, this, null), d.h.a.m.class, "com.obric.aiagent.plugin"), 3, null);
    }

    private final void scheduleDiscoveryCompletionClear(String r7) {
        kotlinx.coroutines.i.a(this.mainScope, null, null, (d.h.a.m) ZeusTransformUtils.preCheckCast(new i(this, r7, null), d.h.a.m.class, "com.obric.aiagent.plugin"), 3, null);
    }

    private final void useDiscoverySkill(com.obric.aiagent.skill.manager.api.e r4) {
        final com.obric.aiagent.skill.manager.api.e r5 = new p(r4, getViewModel().f(r4.a())).a();
        co.a((FragmentActivity) ZeusTransformUtils.preCheckCast(this, FragmentActivity.class, "com.obric.aiagent.plugin"), r5, new $$Lambda$SkillShopActivity$qNr3Hk6FtE9f5tSoNE75N2TtsE(r5, this));
    }

    private static final d.x useDiscoverySkill$lambda$19(com.obric.aiagent.skill.manager.api.e r8, SkillShopActivity r9) {
        final SkillShopActivity r10 = (SkillShopActivity) ZeusTransformUtils.wrapperContextForParams(r9, SkillShopActivity.class, "com.obric.aiagent.plugin");
        if (r8.l() == true) goto L7;
        cm.f20758a.a((Activity) ZeusTransformUtils.preCheckCast(r10, Activity.class, "com.obric.aiagent.plugin"), cm.a.i);
        return d.x.f38692a;
    L7:
        if (r.a(r.f20808a, (Context) ZeusTransformUtils.preCheckCast(r10, Context.class, "com.obric.aiagent.plugin"), r10.skillManager, r8.a(), null, new $$Lambda$SkillShopActivity$1eOzwlVKwW_aberUtFS_H0cjU(r10), 8, null) == false) goto L10;
        r10.finish();
    L10:
        return d.x.f38692a;
    }

    private static final d.x useDiscoverySkill$lambda$19$lambda$18(SkillShopActivity r2, String r3) {
        SkillShopActivity r4 = (SkillShopActivity) ZeusTransformUtils.wrapperContextForParams(r2, SkillShopActivity.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r3, "message");
        r4.showUseError(r3);
        return d.x.f38692a;
    }

    private final void showUseError(String r3) {
        if (d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast(r3, CharSequence.class, "com.obric.aiagent.plugin")) == false) goto L5;
        return;
    L5:
        ee.f19808a.c("SkillManager", "Open discovery skill chat failed", "Open discovery skill chat failed: " + r3);
    }

    static /* synthetic */ void openSkillDetail$default(SkillShopActivity r1, String r2, String r3, du r4, int r5, Object r6) {
        SkillShopActivity r7 = (SkillShopActivity) ZeusTransformUtils.wrapperContextForParams(r1, SkillShopActivity.class, "com.obric.aiagent.plugin");
        if ((r5 & 2) == 0) goto L6;
        r3 = "";
    L6:
        if ((r5 & 4) == 0) goto L8;
        r4 = br.f20662a.b();
    L8:
        r7.openSkillDetail(r2, r3, r4);
    }

    private final void openSkillDetail(String r4, String r5, du r6) {
        launchFloatingActivity(SkillDetailPreviewActivity.Companion.a((Context) ZeusTransformUtils.preCheckCast(this, Context.class, "com.obric.aiagent.plugin"), r4, r5, r6));
    }

    private final void openCollectionDetail(String r4) {
        if (d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast(r4, CharSequence.class, "com.obric.aiagent.plugin")) == false) goto L5;
        return;
    L5:
        launchFloatingActivity(SkillCollectionDetailActivity.Companion.a((Context) ZeusTransformUtils.preCheckCast(this, Context.class, "com.obric.aiagent.plugin"), r4));
    }

    public final cb pageActionHandler$impl_release() {
        return (cb) ZeusTransformUtils.preCheckCast(this.pageActions, cb.class, "com.obric.aiagent.plugin");
    }
}
