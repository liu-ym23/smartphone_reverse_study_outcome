package com.obric.autoaction.app.launcherpage.condition.location;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.activity.ComponentActivity;
import androidx.core.view.ViewCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.r;
import androidx.lifecycle.ao;
import androidx.lifecycle.ap;
import androidx.lifecycle.q;
import com.bytedance.common.wschannel.WsChannelMultiProcessSharedProvider;
import com.obric.aiagent.plugin.R;
import com.obric.autoaction.app.launcherpage.a.u;
import com.obric.autoaction.app.launcherpage.detail.base.BaseOSheetDialogFragment;
import com.obric.autoaction.app.launcherpage.detail.base.RightSlideOSheet;
import com.obric.oui.orecyclerview.widget.LinearLayoutManager;
import com.obric.oui.orecyclerview.widget.RecyclerView;
import com.obric.oui.oswitch.OSwitch;
import com.obric.oui.sheet.v2.OSheet;
import com.obric.oui.titlebar.OFloatingTitleBar;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.aa;
import d.h.b.p;
import d.x;
import java.util.List;
import java.util.Map;
import kotlinx.coroutines.am;

/* JADX INFO: compiled from: FrequentLocationManageFragment.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class FrequentLocationManageFragment extends BaseOSheetDialogFragment<x> {
    public static final a Companion = null;
    private static final String TAG = "FrequentLocationManageFragment";
    private u _binding;
    private boolean hasResumedOnce;
    private final d.f viewModel$delegate;

    /* JADX INFO: compiled from: FrequentLocationManageFragment.kt */
    public static final class a {
        public /* synthetic */ a(d.h.b.h r1) {
            this();
        }

        private a() {
        }

        public final FrequentLocationManageFragment a() {
            return new FrequentLocationManageFragment();
        }

        public final void a(FragmentActivity r3) {
            FragmentActivity r4 = (FragmentActivity) ZeusTransformUtils.wrapperContextForParams(r3, FragmentActivity.class, "com.obric.aiagent.plugin");
            d.h.b.o.e(r4, "activity");
            a().show(r4.getSupportFragmentManager(), FrequentLocationManageFragment.TAG);
        }
    }

    /* JADX INFO: compiled from: FrequentLocationManageFragment.kt */
    @d.c.b.a.f(b = "FrequentLocationManageFragment.kt", c = {107}, d = "invokeSuspend", e = "com.obric.autoaction.app.launcherpage.condition.location.FrequentLocationManageFragment$observeData$1")
    static final class b extends d.c.b.a.l implements d.h.a.m<am, d.c.d<? super x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f23095a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ FrequentLocationManageFragment f23096b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ u f23097c;

        /* JADX INFO: renamed from: com.obric.autoaction.app.launcherpage.condition.location.FrequentLocationManageFragment$b$1, reason: invalid class name */
        /* JADX INFO: compiled from: FrequentLocationManageFragment.kt */
        @d.c.b.a.f(b = "FrequentLocationManageFragment.kt", c = {}, d = "invokeSuspend", e = "com.obric.autoaction.app.launcherpage.condition.location.FrequentLocationManageFragment$observeData$1$1")
        static final class AnonymousClass1 extends d.c.b.a.l implements d.h.a.m<List<? extends ConditionLocationItemData>, d.c.d<? super x>, Object> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            int f23098a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            /* synthetic */ Object f23099b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            final /* synthetic */ u f23100c;

            AnonymousClass1(u r3, d.c.d<? super AnonymousClass1> r4) {
                d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
                this.f23100c = r3;
                super(2, r5);
            }

            public final Object a(List<ConditionLocationItemData> r3, d.c.d<? super x> r4) {
                return ((AnonymousClass1) ZeusTransformUtils.preCheckCast(create((List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), AnonymousClass1.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
            }

            @Override // d.c.b.a.a
            public final d.c.d<x> create(Object r3, d.c.d<?> r4) {
                d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
                AnonymousClass1 r0 = new AnonymousClass1(this.f23100c, r5);
                r0.f23099b = r3;
                return (d.c.d) ZeusTransformUtils.preCheckCast(r0, d.c.d.class, "com.obric.aiagent.plugin");
            }

            @Override // d.h.a.m
            public /* synthetic */ Object invoke(List<? extends ConditionLocationItemData> r3, d.c.d<? super x> r4) {
                return a((List) ZeusTransformUtils.preCheckCast(r3, List.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
            }

            @Override // d.c.b.a.a
            public final Object invokeSuspend(Object r3) {
                d.c.a.b.a();
                if (this.f23098a != 0) goto L13;
                d.o.a(r3);
                List<ConditionLocationItemData> r4 = (List) ZeusTransformUtils.preCheckCast(this.f23099b, List.class, "com.obric.aiagent.plugin");
                RecyclerView.a r2 = this.f23100c.f22864c.getAdapter();
                if (ZeusTransformUtils.instanceOf(r2, com.obric.autoaction.app.launcherpage.condition.location.g.class) == false) goto L7;
                com.obric.autoaction.app.launcherpage.condition.location.g r5 = (com.obric.autoaction.app.launcherpage.condition.location.g) ZeusTransformUtils.preCheckCast(r2, com.obric.autoaction.app.launcherpage.condition.location.g.class, "com.obric.aiagent.plugin");
            L8:
                if (r5 == null) goto L11;
                r5.a(r4);
            L11:
                return x.f38692a;
            L7:
                r5 = null;
                goto L8
            L13:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }

        b(FrequentLocationManageFragment r3, u r4, d.c.d<? super b> r5) {
            d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
            this.f23096b = r3;
            this.f23097c = r4;
            super(2, r6);
        }

        public final Object a(am r3, d.c.d<? super x> r4) {
            return ((b) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), b.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<x> create(Object r3, d.c.d<?> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new b(this.f23096b, this.f23097c, r5), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d.c.d<? super x> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r7) {
            Object r0 = d.c.a.b.a();
            int r1 = this.f23095a;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            d.o.a(r7);
        L12:
            return x.f38692a;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            d.o.a(r7);
            kotlinx.coroutines.b.h r8 = (kotlinx.coroutines.b.h) ZeusTransformUtils.preCheckCast(FrequentLocationManageFragment.access$getViewModel(this.f23096b).b(), kotlinx.coroutines.b.h.class, "com.obric.aiagent.plugin");
            d.h.a.m r2 = (d.h.a.m) ZeusTransformUtils.preCheckCast(new AnonymousClass1(this.f23097c, null), d.h.a.m.class, "com.obric.aiagent.plugin");
            d.c.d r3 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.f23095a = 1;
            if (kotlinx.coroutines.b.j.a(r8, r2, r3) != r0) goto L12;
            return r0;
        }
    }

    /* JADX INFO: compiled from: FrequentLocationManageFragment.kt */
    @d.c.b.a.f(b = "FrequentLocationManageFragment.kt", c = {113}, d = "invokeSuspend", e = "com.obric.autoaction.app.launcherpage.condition.location.FrequentLocationManageFragment$observeData$2")
    static final class c extends d.c.b.a.l implements d.h.a.m<am, d.c.d<? super x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f23101a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ FrequentLocationManageFragment f23102b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ u f23103c;

        /* JADX INFO: renamed from: com.obric.autoaction.app.launcherpage.condition.location.FrequentLocationManageFragment$c$1, reason: invalid class name */
        /* JADX INFO: compiled from: FrequentLocationManageFragment.kt */
        @d.c.b.a.f(b = "FrequentLocationManageFragment.kt", c = {}, d = "invokeSuspend", e = "com.obric.autoaction.app.launcherpage.condition.location.FrequentLocationManageFragment$observeData$2$1")
        static final class AnonymousClass1 extends d.c.b.a.l implements d.h.a.m<Boolean, d.c.d<? super x>, Object> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            int f23104a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            /* synthetic */ boolean f23105b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            final /* synthetic */ u f23106c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            final /* synthetic */ FrequentLocationManageFragment f23107d;

            AnonymousClass1(u r3, FrequentLocationManageFragment r4, d.c.d<? super AnonymousClass1> r5) {
                d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
                this.f23106c = r3;
                this.f23107d = r4;
                super(2, r6);
            }

            public final Object a(boolean r3, d.c.d<? super x> r4) {
                d.c.d<?> r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
                return ((AnonymousClass1) ZeusTransformUtils.preCheckCast(create(Boolean.valueOf(r3), r5), AnonymousClass1.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
            }

            @Override // d.c.b.a.a
            public final d.c.d<x> create(Object r4, d.c.d<?> r5) {
                d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
                AnonymousClass1 r0 = new AnonymousClass1(this.f23106c, this.f23107d, r6);
                r0.f23105b = ((Boolean) ZeusTransformUtils.preCheckCast(r4, Boolean.class, "com.obric.aiagent.plugin")).booleanValue();
                return (d.c.d) ZeusTransformUtils.preCheckCast(r0, d.c.d.class, "com.obric.aiagent.plugin");
            }

            @Override // d.h.a.m
            public /* synthetic */ Object invoke(Boolean r3, d.c.d<? super x> r4) {
                return a(((Boolean) ZeusTransformUtils.preCheckCast(r3, Boolean.class, "com.obric.aiagent.plugin")).booleanValue(), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
            }

            @Override // d.c.b.a.a
            public final Object invokeSuspend(Object r3) {
                d.c.a.b.a();
                if (this.f23104a != 0) goto L16;
                d.o.a(r3);
                boolean r4 = this.f23105b;
                OSwitch r0 = this.f23106c.f22863b.getEndSwitch();
                if (r0 == null) goto L7;
                FrequentLocationManageFragment.access$reflectSwitchChecked(this.f23107d, r0, r4);
            L7:
                RecyclerView.a r2 = this.f23106c.f22864c.getAdapter();
                if (ZeusTransformUtils.instanceOf(r2, com.obric.autoaction.app.launcherpage.condition.location.g.class) == false) goto L10;
                com.obric.autoaction.app.launcherpage.condition.location.g r5 = (com.obric.autoaction.app.launcherpage.condition.location.g) ZeusTransformUtils.preCheckCast(r2, com.obric.autoaction.app.launcherpage.condition.location.g.class, "com.obric.aiagent.plugin");
            L11:
                if (r5 == null) goto L14;
                r5.a(r4);
            L14:
                return x.f38692a;
            L10:
                r5 = null;
                goto L11
            L16:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }

        c(FrequentLocationManageFragment r3, u r4, d.c.d<? super c> r5) {
            d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
            this.f23102b = r3;
            this.f23103c = r4;
            super(2, r6);
        }

        public final Object a(am r3, d.c.d<? super x> r4) {
            return ((c) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), c.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<x> create(Object r3, d.c.d<?> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new c(this.f23102b, this.f23103c, r5), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d.c.d<? super x> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r8) {
            Object r0 = d.c.a.b.a();
            int r1 = this.f23101a;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            d.o.a(r8);
        L12:
            return x.f38692a;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            d.o.a(r8);
            kotlinx.coroutines.b.h r9 = (kotlinx.coroutines.b.h) ZeusTransformUtils.preCheckCast(FrequentLocationManageFragment.access$getViewModel(this.f23102b).c(), kotlinx.coroutines.b.h.class, "com.obric.aiagent.plugin");
            d.h.a.m r2 = (d.h.a.m) ZeusTransformUtils.preCheckCast(new AnonymousClass1(this.f23103c, this.f23102b, null), d.h.a.m.class, "com.obric.aiagent.plugin");
            d.c.d r3 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.f23101a = 1;
            if (kotlinx.coroutines.b.j.a(r9, r2, r3) != r0) goto L12;
            return r0;
        }
    }

    /* JADX INFO: compiled from: FrequentLocationManageFragment.kt */
    @d.c.b.a.f(b = "FrequentLocationManageFragment.kt", c = {122}, d = "invokeSuspend", e = "com.obric.autoaction.app.launcherpage.condition.location.FrequentLocationManageFragment$observeData$3")
    static final class d extends d.c.b.a.l implements d.h.a.m<am, d.c.d<? super x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f23108a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ FrequentLocationManageFragment f23109b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ u f23110c;

        /* JADX INFO: renamed from: com.obric.autoaction.app.launcherpage.condition.location.FrequentLocationManageFragment$d$1, reason: invalid class name */
        /* JADX INFO: compiled from: FrequentLocationManageFragment.kt */
        @d.c.b.a.f(b = "FrequentLocationManageFragment.kt", c = {}, d = "invokeSuspend", e = "com.obric.autoaction.app.launcherpage.condition.location.FrequentLocationManageFragment$observeData$3$1")
        static final class AnonymousClass1 extends d.c.b.a.l implements d.h.a.m<Map<Integer, ? extends Integer>, d.c.d<? super x>, Object> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            int f23111a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            /* synthetic */ Object f23112b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            final /* synthetic */ u f23113c;

            AnonymousClass1(u r3, d.c.d<? super AnonymousClass1> r4) {
                d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
                this.f23113c = r3;
                super(2, r5);
            }

            public final Object a(Map<Integer, Integer> r3, d.c.d<? super x> r4) {
                return ((AnonymousClass1) ZeusTransformUtils.preCheckCast(create((Map) ZeusTransformUtils.wrapperContextForParams(r3, Map.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), AnonymousClass1.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
            }

            @Override // d.c.b.a.a
            public final d.c.d<x> create(Object r3, d.c.d<?> r4) {
                d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
                AnonymousClass1 r0 = new AnonymousClass1(this.f23113c, r5);
                r0.f23112b = r3;
                return (d.c.d) ZeusTransformUtils.preCheckCast(r0, d.c.d.class, "com.obric.aiagent.plugin");
            }

            @Override // d.h.a.m
            public /* synthetic */ Object invoke(Map<Integer, ? extends Integer> r3, d.c.d<? super x> r4) {
                return a((Map) ZeusTransformUtils.preCheckCast(r3, Map.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
            }

            @Override // d.c.b.a.a
            public final Object invokeSuspend(Object r3) {
                d.c.a.b.a();
                if (this.f23111a != 0) goto L13;
                d.o.a(r3);
                Map<Integer, Integer> r4 = (Map) ZeusTransformUtils.preCheckCast(this.f23112b, Map.class, "com.obric.aiagent.plugin");
                RecyclerView.a r2 = this.f23113c.f22864c.getAdapter();
                if (ZeusTransformUtils.instanceOf(r2, com.obric.autoaction.app.launcherpage.condition.location.g.class) == false) goto L7;
                com.obric.autoaction.app.launcherpage.condition.location.g r5 = (com.obric.autoaction.app.launcherpage.condition.location.g) ZeusTransformUtils.preCheckCast(r2, com.obric.autoaction.app.launcherpage.condition.location.g.class, "com.obric.aiagent.plugin");
            L8:
                if (r5 == null) goto L11;
                r5.a(r4);
            L11:
                return x.f38692a;
            L7:
                r5 = null;
                goto L8
            L13:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }

        d(FrequentLocationManageFragment r3, u r4, d.c.d<? super d> r5) {
            d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
            this.f23109b = r3;
            this.f23110c = r4;
            super(2, r6);
        }

        public final Object a(am r3, d.c.d<? super x> r4) {
            return ((d) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), d.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<x> create(Object r3, d.c.d<?> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new d(this.f23109b, this.f23110c, r5), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d.c.d<? super x> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r7) {
            Object r0 = d.c.a.b.a();
            int r1 = this.f23108a;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            d.o.a(r7);
        L12:
            return x.f38692a;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            d.o.a(r7);
            kotlinx.coroutines.b.h r8 = (kotlinx.coroutines.b.h) ZeusTransformUtils.preCheckCast(FrequentLocationManageFragment.access$getViewModel(this.f23109b).e(), kotlinx.coroutines.b.h.class, "com.obric.aiagent.plugin");
            d.h.a.m r2 = (d.h.a.m) ZeusTransformUtils.preCheckCast(new AnonymousClass1(this.f23110c, null), d.h.a.m.class, "com.obric.aiagent.plugin");
            d.c.d r3 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.f23108a = 1;
            if (kotlinx.coroutines.b.j.a(r8, r2, r3) != r0) goto L12;
            return r0;
        }
    }

    /* JADX INFO: compiled from: FrequentLocationManageFragment.kt */
    @d.c.b.a.f(b = "FrequentLocationManageFragment.kt", c = {98}, d = "invokeSuspend", e = "com.obric.autoaction.app.launcherpage.condition.location.FrequentLocationManageFragment$onLocationItemClick$1")
    static final class e extends d.c.b.a.l implements d.h.a.m<am, d.c.d<? super x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f23114a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ FragmentActivity f23115b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ ConditionLocationItemData f23116c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ FrequentLocationManageFragment f23117d;

        e(FragmentActivity r3, ConditionLocationItemData r4, FrequentLocationManageFragment r5, d.c.d<? super e> r6) {
            FragmentActivity r7 = (FragmentActivity) ZeusTransformUtils.wrapperContextForParams(r3, FragmentActivity.class, "com.obric.aiagent.plugin");
            d.c.d r8 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r6, d.c.d.class, "com.obric.aiagent.plugin");
            this.f23115b = r7;
            this.f23116c = r4;
            this.f23117d = r5;
            super(2, r8);
        }

        public final Object a(am r3, d.c.d<? super x> r4) {
            return ((e) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), e.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<x> create(Object r4, d.c.d<?> r5) {
            d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new e(this.f23115b, this.f23116c, this.f23117d, r6), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d.c.d<? super x> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r7) {
            Object r0 = d.c.a.b.a();
            int r1 = this.f23114a;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            d.o.a(r7);
        L11:
            ConditionLocationItemData r8 = (ConditionLocationItemData) ZeusTransformUtils.preCheckCast(r7, ConditionLocationItemData.class, "com.obric.aiagent.plugin");
            if (r8 == null) goto L15;
            FrequentLocationManageFragment.access$getViewModel(this.f23117d).a(this.f23116c, r8);
        L15:
            return x.f38692a;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            d.o.a(r7);
            com.obric.autoaction.app.launcherpage.condition.location.e.a r9 = com.obric.autoaction.app.launcherpage.condition.location.e.f23172a;
            ComponentActivity r2 = (ComponentActivity) ZeusTransformUtils.preCheckCast(this.f23115b, ComponentActivity.class, "com.obric.aiagent.plugin");
            ConditionLocationItemData r4 = this.f23116c;
            d.c.d<? super ConditionLocationItemData> r5 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.f23114a = 1;
            r7 = r9.a(r2, r4, r5);
            if (r7 != r0) goto L11;
            return r0;
        }
    }

    /* JADX INFO: compiled from: FrequentLocationManageFragment.kt */
    /* synthetic */ class f extends d.h.b.l implements d.h.a.b<ConditionLocationItemData, x> {
        f(Object r8) {
            super(1, r8, FrequentLocationManageFragment.class, "onLocationItemClick", "onLocationItemClick(Lcom/obric/autoaction/app/launcherpage/condition/location/ConditionLocationItemData;)V", 0);
        }

        public final void a(ConditionLocationItemData r3) {
            d.h.b.o.e(r3, "p0");
            FrequentLocationManageFragment.access$onLocationItemClick((FrequentLocationManageFragment) ZeusTransformUtils.preCheckCast(this.receiver, FrequentLocationManageFragment.class, "com.obric.aiagent.plugin"), r3);
        }

        @Override // d.h.a.b
        public /* synthetic */ x invoke(ConditionLocationItemData r3) {
            a((ConditionLocationItemData) ZeusTransformUtils.preCheckCast(r3, ConditionLocationItemData.class, "com.obric.aiagent.plugin"));
            return x.f38692a;
        }
    }

    /* JADX INFO: compiled from: FragmentViewModelLazy.kt */
    public static final class g extends p implements d.h.a.a<Fragment> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Fragment f23118a;

        public g(Fragment r1) {
            this.f23118a = r1;
            super(0);
        }

        @Override // d.h.a.a
        public /* synthetic */ Fragment invoke() {
            return a();
        }

        public final Fragment a() {
            return this.f23118a;
        }
    }

    /* JADX INFO: compiled from: FragmentViewModelLazy.kt */
    public static final class h extends p implements d.h.a.a<ao> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ d.h.a.a f23119a;

        public h(d.h.a.a r3) {
            this.f23119a = (d.h.a.a) ZeusTransformUtils.wrapperContextForParams(r3, d.h.a.a.class, "com.obric.aiagent.plugin");
            super(0);
        }

        @Override // d.h.a.a
        public /* synthetic */ ao invoke() {
            return a();
        }

        public final ao a() {
            ao r2 = ((ap) ZeusTransformUtils.preCheckCast(this.f23119a.invoke(), ap.class, "com.obric.aiagent.plugin")).getViewModelStore();
            d.h.b.o.b(r2, "ownerProducer().viewModelStore");
            return r2;
        }
    }

    static {
        Companion = new a(null);
    }

    public static /* synthetic */ void lambda$SotNOhbcosUOEPa9cyWfWFUYnLo(OSwitch r0, View r1) {
        setupAutoLearnSwitch$lambda$4(r0, r1);
    }

    /* JADX INFO: renamed from: lambda$a3mMooITR9gV0yaAJvWbP77xH-4, reason: not valid java name */
    public static /* synthetic */ void m458lambda$a3mMooITR9gV0yaAJvWbP77xH4(FrequentLocationManageFragment r0, View r1) {
        setupAutoLearnSwitch$lambda$5(r0, r1);
    }

    public static /* synthetic */ void lambda$ftsgtM8fktxC25bO2116LAJV7CI(FrequentLocationManageFragment r0, View r1) {
        setupViews$lambda$1$lambda$0(r0, r1);
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater r1, ViewGroup r2, Bundle r3) {
        d.h.b.o.e(r1, "inflater");
        return null;
    }

    public FrequentLocationManageFragment() {
        Fragment r0 = (Fragment) ZeusTransformUtils.preCheckCast(this, Fragment.class, "com.obric.aiagent.plugin");
        d.h.a.a r2 = (d.h.a.a) ZeusTransformUtils.preCheckCast(new g(r0), d.h.a.a.class, "com.obric.aiagent.plugin");
        this.viewModel$delegate = r.a(r0, aa.b(i.class), (d.h.a.a) ZeusTransformUtils.preCheckCast(new h(r2), d.h.a.a.class, "com.obric.aiagent.plugin"), null);
    }

    public static final /* synthetic */ i access$getViewModel(FrequentLocationManageFragment r0) {
        return r0.getViewModel();
    }

    public static final /* synthetic */ void access$onLocationItemClick(FrequentLocationManageFragment r0, ConditionLocationItemData r1) {
        r0.onLocationItemClick(r1);
    }

    public static final /* synthetic */ void access$reflectSwitchChecked(FrequentLocationManageFragment r0, OSwitch r1, boolean r2) {
        r0.reflectSwitchChecked(r1, r2);
    }

    private final u getBinding() {
        return this._binding;
    }

    private final i getViewModel() {
        return (i) ZeusTransformUtils.preCheckCast(this.viewModel$delegate.b(), i.class, "com.obric.aiagent.plugin");
    }

    @Override // com.obric.autoaction.app.launcherpage.detail.base.BaseOSheetDialogFragment
    public OSheet createSheet() {
        Context r3 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(requireContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
        d.h.b.o.c(r3, "requireContext(...)");
        return (OSheet) ZeusTransformUtils.preCheckCast(new RightSlideOSheet(r3), OSheet.class, "com.obric.aiagent.plugin");
    }

    @Override // com.obric.autoaction.app.launcherpage.detail.base.BaseOSheetDialogFragment
    public void configureSheet(OSheet r5, Bundle r6) {
        d.h.b.o.e(r5, "sheet");
        u r7 = u.a(getLayoutInflater());
        d.h.b.o.c(r7, "inflate(...)");
        this._binding = r7;
        r5.setBodyView((View) ZeusTransformUtils.preCheckCast(r7.b(), View.class, "com.obric.aiagent.plugin"));
        setupViews(r7);
        observeData(r7);
        i r8 = getViewModel();
        Context r0 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r7.b().getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
        d.h.b.o.c(r0, "getContext(...)");
        r8.a(r0);
        i r9 = getViewModel();
        Context r1 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r7.b().getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
        d.h.b.o.c(r1, "getContext(...)");
        r9.b(r1);
        reportPageEnterSuccessOnPreDraw((View) ZeusTransformUtils.preCheckCast(r7.b(), View.class, "com.obric.aiagent.plugin"));
    }

    private final void setupViews(u r7) {
        OFloatingTitleBar r0 = r7.f22866e;
        r0.setCenterTitle(ZeusTransformUtils.mapRes(R.string.condition_location_manage, WsChannelMultiProcessSharedProvider.STRING_TYPE, "condition_location_manage"));
        OFloatingTitleBar.addStartAction$default(r0, ZeusTransformUtils.mapRes(R.drawable.oui_ic_title_bar_back, "drawable", "oui_ic_title_bar_back"), 0, new $$Lambda$FrequentLocationManageFragment$ftsgtM8fktxC25bO2116LAJV7CI(this), 2, null);
        setupAutoLearnSwitch(r7);
        RecyclerView r1 = r7.f22864c;
        r1.setLayoutManager((RecyclerView.h) ZeusTransformUtils.preCheckCast(new LinearLayoutManager((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r7.b().getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")), RecyclerView.h.class, "com.obric.aiagent.plugin"));
        Context r8 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r7.b().getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
        d.h.b.o.c(r8, "getContext(...)");
        com.obric.autoaction.app.launcherpage.condition.location.g r2 = new com.obric.autoaction.app.launcherpage.condition.location.g(r8);
        r2.a((d.h.a.b) ZeusTransformUtils.preCheckCast(new f(this), d.h.a.b.class, "com.obric.aiagent.plugin"));
        r1.setAdapter((RecyclerView.a) ZeusTransformUtils.preCheckCast(r2, RecyclerView.a.class, "com.obric.aiagent.plugin"));
    }

    private static final void setupViews$lambda$1$lambda$0(FrequentLocationManageFragment r0, View r1) {
        r0.dismissWithAnimation();
    }

    private final void setupAutoLearnSwitch(u r3) {
        final OSwitch r0 = r3.f22863b.getEndSwitch();
        if (r0 != null) goto L5;
        return;
    L5:
        r0.setAutoCheck(false);
        r3.f22863b.setOnContentClickListener(new $$Lambda$FrequentLocationManageFragment$SotNOhbcosUOEPa9cyWfWFUYnLo(r0));
        r0.setOnClickListener(new $$Lambda$FrequentLocationManageFragment$a3mMooITR9gV0yaAJvWbP77xH4(this));
    }

    private static final void setupAutoLearnSwitch$lambda$4(OSwitch r0, View r1) {
        r0.performClick();
    }

    private static final void setupAutoLearnSwitch$lambda$5(FrequentLocationManageFragment r2, View r3) {
        r2.getViewModel().a(!((Boolean) ZeusTransformUtils.preCheckCast(r2.getViewModel().c().c(), Boolean.class, "com.obric.aiagent.plugin")).booleanValue());
    }

    private final void onLocationItemClick(ConditionLocationItemData r10) {
        FragmentActivity r0 = (FragmentActivity) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getActivity(), "com.obric.aiagent.plugin"), FragmentActivity.class, "com.obric.aiagent.plugin");
        if (r0 != null) goto L5;
        return;
    L5:
        kotlinx.coroutines.i.a((am) ZeusTransformUtils.preCheckCast(q.a((androidx.lifecycle.p) ZeusTransformUtils.preCheckCast(this, androidx.lifecycle.p.class, "com.obric.aiagent.plugin")), am.class, "com.obric.aiagent.plugin"), null, null, (d.h.a.m) ZeusTransformUtils.preCheckCast(new e(r0, r10, this, null), d.h.a.m.class, "com.obric.aiagent.plugin"), 3, null);
    }

    private final void observeData(u r10) {
        kotlinx.coroutines.i.a((am) ZeusTransformUtils.preCheckCast(q.a((androidx.lifecycle.p) ZeusTransformUtils.preCheckCast(this, androidx.lifecycle.p.class, "com.obric.aiagent.plugin")), am.class, "com.obric.aiagent.plugin"), null, null, (d.h.a.m) ZeusTransformUtils.preCheckCast(new b(this, r10, null), d.h.a.m.class, "com.obric.aiagent.plugin"), 3, null);
        kotlinx.coroutines.i.a((am) ZeusTransformUtils.preCheckCast(q.a((androidx.lifecycle.p) ZeusTransformUtils.preCheckCast(this, androidx.lifecycle.p.class, "com.obric.aiagent.plugin")), am.class, "com.obric.aiagent.plugin"), null, null, (d.h.a.m) ZeusTransformUtils.preCheckCast(new c(this, r10, null), d.h.a.m.class, "com.obric.aiagent.plugin"), 3, null);
        kotlinx.coroutines.i.a((am) ZeusTransformUtils.preCheckCast(q.a((androidx.lifecycle.p) ZeusTransformUtils.preCheckCast(this, androidx.lifecycle.p.class, "com.obric.aiagent.plugin")), am.class, "com.obric.aiagent.plugin"), null, null, (d.h.a.m) ZeusTransformUtils.preCheckCast(new d(this, r10, null), d.h.a.m.class, "com.obric.aiagent.plugin"), 3, null);
    }

    private final void reflectSwitchChecked(final OSwitch r3, final boolean r4) {
        final View r2 = (View) ZeusTransformUtils.preCheckCast(r3, View.class, "com.obric.aiagent.plugin");
        if (ViewCompat.I(r2) == false) goto L5;
        r3.setChecked(r4);
        r3.jumpDrawablesToCurrentState();
        return;
    L5:
        r2.addOnAttachStateChangeListener((View.OnAttachStateChangeListener) ZeusTransformUtils.preCheckCast(new FrequentLocationManageFragment$reflectSwitchChecked$$inlined$doOnAttach$1(r2, r3, r4), View.OnAttachStateChangeListener.class, "com.obric.aiagent.plugin"));
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        if (this.hasResumedOnce == true) goto L6;
        this.hasResumedOnce = true;
        return;
    L6:
        u r0 = this._binding;
        if (r0 == null) goto L10;
        i r3 = getViewModel();
        Context r1 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r0.b().getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
        d.h.b.o.c(r1, "getContext(...)");
        r3.a(r1);
        return;
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        this._binding = null;
    }
}
