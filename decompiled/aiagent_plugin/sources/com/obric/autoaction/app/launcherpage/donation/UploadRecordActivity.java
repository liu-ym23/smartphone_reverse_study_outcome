package com.obric.autoaction.app.launcherpage.donation;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Rect;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.View;
import androidx.activity.ComponentActivity;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.al;
import androidx.lifecycle.ao;
import androidx.lifecycle.q;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.common.wschannel.WsChannelMultiProcessSharedProvider;
import com.obric.aiagent.plugin.R;
import com.obric.autoaction.app.launcherpage.a.as;
import com.obric.autoaction.common.base.BaseActivity;
import com.obric.autogui.common.api.logging.Loog;
import com.obric.oui.status.OPageStatus;
import com.obric.oui.titlebar.OFloatingTitleBar;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.aa;
import d.h.b.o;
import d.h.b.p;
import d.x;
import java.util.List;
import kotlinx.coroutines.am;
import kotlinx.coroutines.b.w;

/* JADX INFO: compiled from: UploadRecordActivity.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class UploadRecordActivity extends AppCompatActivity {
    public static final a Companion = null;
    private com.obric.autoaction.app.launcherpage.donation.d adapter;
    private as binding;
    private final d.f viewModel$delegate;

    /* JADX INFO: compiled from: UploadRecordActivity.kt */
    public static final class a {
        public /* synthetic */ a(d.h.b.h r1) {
            this();
        }

        private a() {
        }

        public final void a(Context r3) {
            Context r2 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
            o.e(r2, "context");
            com.obric.autoaction.app.launcherpage.b.b.f22905a.a(r2);
            ZeusTransformUtils.startActivity(r2, new Intent(r2, UploadRecordActivity.class), "com.obric.aiagent.plugin");
        }
    }

    /* JADX INFO: compiled from: UploadRecordActivity.kt */
    public static final class b extends RecyclerView.l {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ UploadRecordActivity f23699a;

        b(UploadRecordActivity r3) {
            this.f23699a = (UploadRecordActivity) ZeusTransformUtils.wrapperContextForParams(r3, UploadRecordActivity.class, "com.obric.aiagent.plugin");
        }

        @Override // androidx.recyclerview.widget.RecyclerView.l
        public void a(RecyclerView r2, int r3, int r4) {
            o.e(r2, "recyclerView");
            super.a(r2, r3, r4);
            RecyclerView.h r5 = r2.getLayoutManager();
            o.a(r5, "null cannot be cast to non-null type androidx.recyclerview.widget.LinearLayoutManager");
            LinearLayoutManager r6 = (LinearLayoutManager) ZeusTransformUtils.preCheckCast(r5, LinearLayoutManager.class, "com.obric.aiagent.plugin");
            int r7 = r6.H();
            if ((r6.p() + 5) < r7) goto L6;
            UploadRecordActivity.access$getViewModel(this.f23699a).f();
            return;
        }
    }

    /* JADX INFO: compiled from: UploadRecordActivity.kt */
    public static final class c extends RecyclerView.g {
        c() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.g
        public void a(Rect r3, View r4, RecyclerView r5, RecyclerView.r r6) {
            o.e(r3, "outRect");
            o.e(r4, "view");
            o.e(r5, "parent");
            o.e(r6, "state");
            int r2 = r5.getChildAdapterPosition(r4);
            if (r2 < 0) goto L32;
            RecyclerView.a r7 = r5.getAdapter();
            if (r7 == null) goto L7;
            int r8 = r7.a();
        L8:
            if (r2 >= r8) goto L35;
            RecyclerView.a r9 = r5.getAdapter();
            if (r9 == null) goto L13;
            Integer r10 = Integer.valueOf(r9.a(r2));
        L14:
            int r0 = com.obric.autoaction.app.launcherpage.donation.d.b.a.C0533a.f23734a.getType();
            if (r10 != null) goto L18;
        L30:
            r3.set(0, 0, 0, 0);
            return;
        L18:
            if (r10.intValue() != r0) goto L30;
            if (r2 <= 0) goto L29;
            RecyclerView.a r11 = r5.getAdapter();
            if (r11 != null) goto L24;
        L26:
            boolean r12 = false;
        L27:
            if (r12 == false) goto L29;
            float r13 = 16;
            r3.set(d.i.a.a(TypedValue.applyDimension(1, r13, Resources.getSystem().getDisplayMetrics())), d.i.a.a(TypedValue.applyDimension(1, r13, Resources.getSystem().getDisplayMetrics())), d.i.a.a(TypedValue.applyDimension(1, r13, Resources.getSystem().getDisplayMetrics())), d.i.a.a(TypedValue.applyDimension(1, 0, Resources.getSystem().getDisplayMetrics())));
            return;
        L24:
            if (r11.a(r2 - 1) != com.obric.autoaction.app.launcherpage.donation.d.b.a.C0534b.f23735a.getType()) goto L26;
            r12 = true;
        L29:
            float r14 = 16;
            r3.set(d.i.a.a(TypedValue.applyDimension(1, r14, Resources.getSystem().getDisplayMetrics())), 0, d.i.a.a(TypedValue.applyDimension(1, r14, Resources.getSystem().getDisplayMetrics())), 0);
            return;
        L13:
            r10 = null;
            goto L14
        L35:
            return;
        L7:
            r8 = 0;
            goto L8
        }
    }

    /* JADX INFO: compiled from: UploadRecordActivity.kt */
    @d.c.b.a.f(b = "UploadRecordActivity.kt", c = {47}, d = "invokeSuspend", e = "com.obric.autoaction.app.launcherpage.donation.UploadRecordActivity$onCreate$1")
    static final class d extends d.c.b.a.l implements d.h.a.m<am, d.c.d<? super x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f23700a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ UploadRecordActivity f23701b;

        d(UploadRecordActivity r3, d.c.d<? super d> r4) {
            UploadRecordActivity r5 = (UploadRecordActivity) ZeusTransformUtils.wrapperContextForParams(r3, UploadRecordActivity.class, "com.obric.aiagent.plugin");
            d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f23701b = r5;
            super(2, r6);
        }

        public final Object a(am r3, d.c.d<? super x> r4) {
            return ((d) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), d.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<x> create(Object r2, d.c.d<?> r3) {
            d.c.d r4 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new d(this.f23701b, r4), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d.c.d<? super x> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r6) {
            Object r0 = d.c.a.b.a();
            int r1 = this.f23700a;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L6;
            d.o.a(r6);
        L12:
            throw new d.d();
        L6:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            d.o.a(r6);
            kotlinx.coroutines.b.x<List<com.obric.autoaction.app.launcherpage.donation.e.a>> r7 = UploadRecordActivity.access$getViewModel(this.f23701b).b();
            final UploadRecordActivity r3 = this.f23701b;
            kotlinx.coroutines.b.i<? super List<com.obric.autoaction.app.launcherpage.donation.e.a>> r2 = (kotlinx.coroutines.b.i) ZeusTransformUtils.preCheckCast(new AnonymousClass1(r3), kotlinx.coroutines.b.i.class, "com.obric.aiagent.plugin");
            d.c.d<?> r4 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.f23700a = 1;
            if (r7.collect(r2, r4) != r0) goto L12;
            return r0;
        }
    }

    /* JADX INFO: compiled from: UploadRecordActivity.kt */
    @d.c.b.a.f(b = "UploadRecordActivity.kt", c = {52}, d = "invokeSuspend", e = "com.obric.autoaction.app.launcherpage.donation.UploadRecordActivity$onCreate$2")
    static final class e extends d.c.b.a.l implements d.h.a.m<am, d.c.d<? super x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f23703a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ UploadRecordActivity f23704b;

        /* JADX INFO: renamed from: com.obric.autoaction.app.launcherpage.donation.UploadRecordActivity$e$1, reason: invalid class name */
        /* JADX INFO: compiled from: UploadRecordActivity.kt */
        @d.c.b.a.f(b = "UploadRecordActivity.kt", c = {}, d = "invokeSuspend", e = "com.obric.autoaction.app.launcherpage.donation.UploadRecordActivity$onCreate$2$1")
        static final class AnonymousClass1 extends d.c.b.a.l implements d.h.a.m<com.obric.autoaction.app.launcherpage.donation.h, d.c.d<? super x>, Object> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            int f23705a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            /* synthetic */ Object f23706b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            final /* synthetic */ UploadRecordActivity f23707c;

            AnonymousClass1(UploadRecordActivity r3, d.c.d<? super AnonymousClass1> r4) {
                UploadRecordActivity r5 = (UploadRecordActivity) ZeusTransformUtils.wrapperContextForParams(r3, UploadRecordActivity.class, "com.obric.aiagent.plugin");
                d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
                this.f23707c = r5;
                super(2, r6);
            }

            public final Object a(com.obric.autoaction.app.launcherpage.donation.h r3, d.c.d<? super x> r4) {
                return ((AnonymousClass1) ZeusTransformUtils.preCheckCast(create(r3, (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), AnonymousClass1.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
            }

            @Override // d.c.b.a.a
            public final d.c.d<x> create(Object r3, d.c.d<?> r4) {
                d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
                AnonymousClass1 r0 = new AnonymousClass1(this.f23707c, r5);
                r0.f23706b = r3;
                return (d.c.d) ZeusTransformUtils.preCheckCast(r0, d.c.d.class, "com.obric.aiagent.plugin");
            }

            @Override // d.h.a.m
            public /* synthetic */ Object invoke(com.obric.autoaction.app.launcherpage.donation.h r3, d.c.d<? super x> r4) {
                return a((com.obric.autoaction.app.launcherpage.donation.h) ZeusTransformUtils.preCheckCast(r3, com.obric.autoaction.app.launcherpage.donation.h.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
            }

            @Override // d.c.b.a.a
            public final Object invokeSuspend(Object r6) {
                d.c.a.b.a();
                if (this.f23705a != 0) goto L21;
                d.o.a(r6);
                com.obric.autoaction.app.launcherpage.donation.h r7 = (com.obric.autoaction.app.launcherpage.donation.h) ZeusTransformUtils.preCheckCast(this.f23706b, com.obric.autoaction.app.launcherpage.donation.h.class, "com.obric.aiagent.plugin");
                as r0 = UploadRecordActivity.access$getBinding$p(this.f23707c);
                if (r0 != null) goto L7;
                o.c("binding");
                r0 = null;
            L7:
                OPageStatus r1 = r0.f22773a;
                UploadRecordActivity r5 = this.f23707c;
                Loog.INSTANCE.d("UploadRecordActivity", "status = " + r7);
                if (ZeusTransformUtils.instanceOf(r7, com.obric.autoaction.app.launcherpage.donation.h.c.class) == false) goto L11;
                r1.removeAllViews();
                r1.showLoading(true);
                r1.setTitle((CharSequence) ZeusTransformUtils.preCheckCast(r5.getString(ZeusTransformUtils.mapRes(R.string.loading, WsChannelMultiProcessSharedProvider.STRING_TYPE, "loading")), CharSequence.class, "com.obric.aiagent.plugin"));
                r1.setVisibility(0);
            L19:
                return x.f38692a;
            L11:
                if (ZeusTransformUtils.instanceOf(r7, com.obric.autoaction.app.launcherpage.donation.h.a.class) == true) goto L15;
                if (ZeusTransformUtils.instanceOf(r7, com.obric.autoaction.app.launcherpage.donation.h.b.class) == true) goto L15;
            L17:
                r1.setVisibility(8);
            L15:
                if (((List) ZeusTransformUtils.preCheckCast(UploadRecordActivity.access$getViewModel(r5).b().c(), List.class, "com.obric.aiagent.plugin")).isEmpty() == false) goto L17;
                r1.removeAllViews();
                r1.setMessage((CharSequence) ZeusTransformUtils.preCheckCast(r5.getString(ZeusTransformUtils.mapRes(R.string.empty_record_tips, WsChannelMultiProcessSharedProvider.STRING_TYPE, "empty_record_tips")), CharSequence.class, "com.obric.aiagent.plugin"));
                r1.setVisibility(0);
                goto L19
            L21:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }

        e(UploadRecordActivity r3, d.c.d<? super e> r4) {
            UploadRecordActivity r5 = (UploadRecordActivity) ZeusTransformUtils.wrapperContextForParams(r3, UploadRecordActivity.class, "com.obric.aiagent.plugin");
            d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f23704b = r5;
            super(2, r6);
        }

        public final Object a(am r3, d.c.d<? super x> r4) {
            return ((e) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), e.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<x> create(Object r2, d.c.d<?> r3) {
            d.c.d r4 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new e(this.f23704b, r4), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d.c.d<? super x> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r7) {
            Object r0 = d.c.a.b.a();
            int r1 = this.f23703a;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            d.o.a(r7);
        L12:
            return x.f38692a;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            d.o.a(r7);
            kotlinx.coroutines.b.h r8 = (kotlinx.coroutines.b.h) ZeusTransformUtils.preCheckCast(UploadRecordActivity.access$getViewModel(this.f23704b).c(), kotlinx.coroutines.b.h.class, "com.obric.aiagent.plugin");
            d.h.a.m r2 = (d.h.a.m) ZeusTransformUtils.preCheckCast(new AnonymousClass1(this.f23704b, null), d.h.a.m.class, "com.obric.aiagent.plugin");
            d.c.d r3 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.f23703a = 1;
            if (kotlinx.coroutines.b.j.a(r8, r2, r3) != r0) goto L12;
            return r0;
        }
    }

    /* JADX INFO: compiled from: UploadRecordActivity.kt */
    @d.c.b.a.f(b = "UploadRecordActivity.kt", c = {77}, d = "invokeSuspend", e = "com.obric.autoaction.app.launcherpage.donation.UploadRecordActivity$onCreate$3")
    static final class f extends d.c.b.a.l implements d.h.a.m<am, d.c.d<? super x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f23708a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ UploadRecordActivity f23709b;

        f(UploadRecordActivity r3, d.c.d<? super f> r4) {
            UploadRecordActivity r5 = (UploadRecordActivity) ZeusTransformUtils.wrapperContextForParams(r3, UploadRecordActivity.class, "com.obric.aiagent.plugin");
            d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f23709b = r5;
            super(2, r6);
        }

        public final Object a(am r3, d.c.d<? super x> r4) {
            return ((f) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), f.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<x> create(Object r2, d.c.d<?> r3) {
            d.c.d r4 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new f(this.f23709b, r4), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d.c.d<? super x> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r6) {
            Object r0 = d.c.a.b.a();
            int r1 = this.f23708a;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L6;
            d.o.a(r6);
        L12:
            throw new d.d();
        L6:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            d.o.a(r6);
            w<com.obric.autoaction.app.launcherpage.donation.model.a> r7 = m.f23777a.a();
            final UploadRecordActivity r3 = this.f23709b;
            kotlinx.coroutines.b.i<? super com.obric.autoaction.app.launcherpage.donation.model.a> r2 = (kotlinx.coroutines.b.i) ZeusTransformUtils.preCheckCast(new AnonymousClass1(r3), kotlinx.coroutines.b.i.class, "com.obric.aiagent.plugin");
            d.c.d<?> r4 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.f23708a = 1;
            if (r7.collect(r2, r4) != r0) goto L12;
            return r0;
        }
    }

    /* JADX INFO: compiled from: ActivityViewModelLazy.kt */
    public static final class g extends p implements d.h.a.a<androidx.lifecycle.am.b> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ ComponentActivity f23714a;

        public g(ComponentActivity r3) {
            this.f23714a = (ComponentActivity) ZeusTransformUtils.wrapperContextForParams(r3, ComponentActivity.class, "com.obric.aiagent.plugin");
            super(0);
        }

        @Override // d.h.a.a
        public /* synthetic */ androidx.lifecycle.am.b invoke() {
            return a();
        }

        public final androidx.lifecycle.am.b a() {
            androidx.lifecycle.am.b r1 = this.f23714a.getDefaultViewModelProviderFactory();
            o.c(r1, "defaultViewModelProviderFactory");
            return r1;
        }
    }

    /* JADX INFO: compiled from: ActivityViewModelLazy.kt */
    public static final class h extends p implements d.h.a.a<ao> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ ComponentActivity f23715a;

        public h(ComponentActivity r3) {
            this.f23715a = (ComponentActivity) ZeusTransformUtils.wrapperContextForParams(r3, ComponentActivity.class, "com.obric.aiagent.plugin");
            super(0);
        }

        public final ao a() {
            ao r1 = this.f23715a.getViewModelStore();
            o.c(r1, "viewModelStore");
            return r1;
        }

        @Override // d.h.a.a
        public /* synthetic */ ao invoke() {
            return a();
        }
    }

    /* JADX INFO: compiled from: ActivityViewModelLazy.kt */
    public static final class i extends p implements d.h.a.a<androidx.lifecycle.a.a> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ d.h.a.a f23716a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ ComponentActivity f23717b;

        public i(d.h.a.a r3, ComponentActivity r4) {
            d.h.a.a r5 = (d.h.a.a) ZeusTransformUtils.wrapperContextForParams(r3, d.h.a.a.class, "com.obric.aiagent.plugin");
            ComponentActivity r6 = (ComponentActivity) ZeusTransformUtils.wrapperContextForParams(r4, ComponentActivity.class, "com.obric.aiagent.plugin");
            this.f23716a = r5;
            this.f23717b = r6;
            super(0);
        }

        public final androidx.lifecycle.a.a a() {
            d.h.a.a r0 = this.f23716a;
            if (r0 == null) goto L6;
            androidx.lifecycle.a.a r1 = (androidx.lifecycle.a.a) ZeusTransformUtils.preCheckCast(r0.invoke(), androidx.lifecycle.a.a.class, "com.obric.aiagent.plugin");
            if (r1 == null) goto L6;
            return r1;
        L6:
            androidx.lifecycle.a.a r2 = this.f23717b.getDefaultViewModelCreationExtras();
            o.c(r2, "this.defaultViewModelCreationExtras");
            return r2;
        }

        @Override // d.h.a.a
        public /* synthetic */ androidx.lifecycle.a.a invoke() {
            return a();
        }
    }

    static {
        Companion = new a(null);
    }

    public static /* synthetic */ void lambda$R4tH7h87GGNSFrzDO52dTfbwAIo(UploadRecordActivity r0, View r1) {
        initView$lambda$1$lambda$0(r0, r1);
    }

    public UploadRecordActivity() {
        ComponentActivity r0 = (ComponentActivity) ZeusTransformUtils.preCheckCast(this, ComponentActivity.class, "com.obric.aiagent.plugin");
        d.h.a.a r2 = (d.h.a.a) ZeusTransformUtils.preCheckCast(new g(r0), d.h.a.a.class, "com.obric.aiagent.plugin");
        this.viewModel$delegate = (d.f) ZeusTransformUtils.preCheckCast(new al(aa.b(n.class), (d.h.a.a) ZeusTransformUtils.preCheckCast(new h(r0), d.h.a.a.class, "com.obric.aiagent.plugin"), r2, (d.h.a.a) ZeusTransformUtils.preCheckCast(new i(null, r0), d.h.a.a.class, "com.obric.aiagent.plugin")), d.f.class, "com.obric.aiagent.plugin");
    }

    public static final /* synthetic */ com.obric.autoaction.app.launcherpage.donation.d access$getAdapter$p(UploadRecordActivity r2) {
        return ((UploadRecordActivity) ZeusTransformUtils.wrapperContextForParams(r2, UploadRecordActivity.class, "com.obric.aiagent.plugin")).adapter;
    }

    public static final /* synthetic */ as access$getBinding$p(UploadRecordActivity r2) {
        return ((UploadRecordActivity) ZeusTransformUtils.wrapperContextForParams(r2, UploadRecordActivity.class, "com.obric.aiagent.plugin")).binding;
    }

    public static final /* synthetic */ n access$getViewModel(UploadRecordActivity r2) {
        return ((UploadRecordActivity) ZeusTransformUtils.wrapperContextForParams(r2, UploadRecordActivity.class, "com.obric.aiagent.plugin")).getViewModel();
    }

    private final n getViewModel() {
        return (n) ZeusTransformUtils.preCheckCast(this.viewModel$delegate.b(), n.class, "com.obric.aiagent.plugin");
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity
    public void onCreate(Bundle r6) {
        super.onCreate(r6);
        as r7 = as.a(getLayoutInflater());
        o.c(r7, "inflate(...)");
        this.binding = r7;
        BaseActivity.a.a(BaseActivity.Companion, (FragmentActivity) ZeusTransformUtils.preCheckCast(this, FragmentActivity.class, "com.obric.aiagent.plugin"), false, 1, null);
        getViewModel().e();
        as r8 = this.binding;
        if (r8 != null) goto L5;
        o.c("binding");
        r8 = null;
    L5:
        setContentView((View) ZeusTransformUtils.preCheckCast(r8.b(), View.class, "com.obric.aiagent.plugin"));
        initView();
        q.a((androidx.lifecycle.p) ZeusTransformUtils.preCheckCast(this, androidx.lifecycle.p.class, "com.obric.aiagent.plugin")).b((d.h.a.m) ZeusTransformUtils.preCheckCast(new d(this, null), d.h.a.m.class, "com.obric.aiagent.plugin"));
        q.a((androidx.lifecycle.p) ZeusTransformUtils.preCheckCast(this, androidx.lifecycle.p.class, "com.obric.aiagent.plugin")).b((d.h.a.m) ZeusTransformUtils.preCheckCast(new e(this, null), d.h.a.m.class, "com.obric.aiagent.plugin"));
        q.a((androidx.lifecycle.p) ZeusTransformUtils.preCheckCast(this, androidx.lifecycle.p.class, "com.obric.aiagent.plugin")).b((d.h.a.m) ZeusTransformUtils.preCheckCast(new f(this, null), d.h.a.m.class, "com.obric.aiagent.plugin"));
    }

    private final void initView() {
        as r0 = this.binding;
        as r1 = null;
        if (r0 != null) goto L5;
        o.c("binding");
        r0 = null;
    L5:
        OFloatingTitleBar r2 = r0.f22775c;
        r2.setStartButtonGroupStyle(ZeusTransformUtils.mapRes(R.style.OStyleV2_OButtonFloating_S_Standard_Icon, "style", "OStyleV2_OButtonFloating_S_Standard_Icon"));
        OFloatingTitleBar.addStartAction$default(r2, ZeusTransformUtils.mapRes(R.drawable.o_floating_title_bar_icon_back, "drawable", "o_floating_title_bar_icon_back"), 0, new $$Lambda$UploadRecordActivity$R4tH7h87GGNSFrzDO52dTfbwAIo(this), 2, null);
        o.a(r2);
        com.obric.autoaction.app.launcherpage.b.c.a(r2);
        as r3 = this.binding;
        if (r3 != null) goto L8;
        o.c("binding");
    L9:
        RecyclerView r4 = r1.f22774b;
        r4.setLayoutManager((RecyclerView.h) ZeusTransformUtils.preCheckCast(new LinearLayoutManager((Context) ZeusTransformUtils.preCheckCast(this, Context.class, "com.obric.aiagent.plugin")), RecyclerView.h.class, "com.obric.aiagent.plugin"));
        com.obric.autoaction.app.launcherpage.donation.d r5 = new com.obric.autoaction.app.launcherpage.donation.d();
        this.adapter = r5;
        r4.setAdapter((RecyclerView.a) ZeusTransformUtils.preCheckCast(r5, RecyclerView.a.class, "com.obric.aiagent.plugin"));
        r4.addOnScrollListener((RecyclerView.l) ZeusTransformUtils.preCheckCast(new b(this), RecyclerView.l.class, "com.obric.aiagent.plugin"));
        r4.addItemDecoration((RecyclerView.g) ZeusTransformUtils.preCheckCast(new c(), RecyclerView.g.class, "com.obric.aiagent.plugin"));
        return;
    L8:
        r1 = r3;
        goto L9
    }

    private static final void initView$lambda$1$lambda$0(UploadRecordActivity r1, View r2) {
        ((UploadRecordActivity) ZeusTransformUtils.wrapperContextForParams(r1, UploadRecordActivity.class, "com.obric.aiagent.plugin")).getOnBackPressedDispatcher().c();
    }
}
