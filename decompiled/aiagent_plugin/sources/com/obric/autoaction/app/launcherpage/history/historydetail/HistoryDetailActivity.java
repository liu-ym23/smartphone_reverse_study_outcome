package com.obric.autoaction.app.launcherpage.history.historydetail;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.activity.ComponentActivity;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.al;
import androidx.lifecycle.ao;
import androidx.lifecycle.q;
import com.obric.aiagent.plugin.R;
import com.obric.autoaction.app.launcherpage.a.w;
import com.obric.autoaction.common.base.BaseActivity;
import com.obric.oui.orecyclerview.widget.LinearLayoutManager;
import com.obric.oui.orecyclerview.widget.RecyclerView;
import com.obric.oui.titlebar.OFloatingTitleBar;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.c.b.a.l;
import d.f;
import d.g;
import d.h.a.m;
import d.h.b.aa;
import d.h.b.h;
import d.h.b.o;
import d.h.b.p;
import d.x;
import kotlinx.coroutines.am;
import kotlinx.coroutines.b.ak;
import kotlinx.coroutines.b.i;

/* JADX INFO: compiled from: HistoryDetailActivity.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class HistoryDetailActivity extends BaseActivity {
    public static final a Companion = null;
    private static final String KEY_RECORD_ID = "record_id";
    private static final String KEY_SESSION_ID = "session_id";
    private static final String TAG = "HistoryDetailActivity";
    private final f adapter$delegate;
    private final f binding$delegate;
    private final f viewModel$delegate;

    /* JADX INFO: compiled from: HistoryDetailActivity.kt */
    public static final class a {
        public /* synthetic */ a(h r1) {
            this();
        }

        private a() {
        }

        public final void a(Context r3, long r4, String r6) {
            Context r2 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
            o.e(r2, "context");
            o.e(r6, "sessionID");
            Intent r5 = new Intent(r2, HistoryDetailActivity.class);
            r5.putExtra(HistoryDetailActivity.KEY_RECORD_ID, r4);
            r5.putExtra(HistoryDetailActivity.KEY_SESSION_ID, r6);
            ZeusTransformUtils.startActivity(r2, r5, "com.obric.aiagent.plugin");
        }
    }

    /* JADX INFO: compiled from: HistoryDetailActivity.kt */
    @d.c.b.a.f(b = "HistoryDetailActivity.kt", c = {85}, d = "invokeSuspend", e = "com.obric.autoaction.app.launcherpage.history.historydetail.HistoryDetailActivity$initObserver$1")
    static final class b extends l implements m<am, d.c.d<? super x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f23841a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ HistoryDetailActivity f23842b;

        b(HistoryDetailActivity r3, d.c.d<? super b> r4) {
            HistoryDetailActivity r5 = (HistoryDetailActivity) ZeusTransformUtils.wrapperContextForParams(r3, HistoryDetailActivity.class, "com.obric.aiagent.plugin");
            d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f23842b = r5;
            super(2, r6);
        }

        public final Object a(am r3, d.c.d<? super x> r4) {
            return ((b) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), b.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<x> create(Object r2, d.c.d<?> r3) {
            d.c.d r4 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new b(this.f23842b, r4), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d.c.d<? super x> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r6) {
            Object r0 = d.c.a.b.a();
            int r1 = this.f23841a;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L6;
            d.o.a(r6);
        L12:
            throw new d.d();
        L6:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            d.o.a(r6);
            ak<com.obric.autoaction.app.launcherpage.history.historydetail.a> r7 = HistoryDetailActivity.access$getViewModel(this.f23842b).b();
            final HistoryDetailActivity r3 = this.f23842b;
            i<? super com.obric.autoaction.app.launcherpage.history.historydetail.a> r2 = (i) ZeusTransformUtils.preCheckCast(new AnonymousClass1(r3), i.class, "com.obric.aiagent.plugin");
            d.c.d<?> r4 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.f23841a = 1;
            if (r7.collect(r2, r4) != r0) goto L12;
            return r0;
        }
    }

    /* JADX INFO: compiled from: ActivityViewModelLazy.kt */
    public static final class c extends p implements d.h.a.a<androidx.lifecycle.am.b> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ ComponentActivity f23844a;

        public c(ComponentActivity r3) {
            this.f23844a = (ComponentActivity) ZeusTransformUtils.wrapperContextForParams(r3, ComponentActivity.class, "com.obric.aiagent.plugin");
            super(0);
        }

        @Override // d.h.a.a
        public /* synthetic */ androidx.lifecycle.am.b invoke() {
            return a();
        }

        public final androidx.lifecycle.am.b a() {
            androidx.lifecycle.am.b r1 = this.f23844a.getDefaultViewModelProviderFactory();
            o.c(r1, "defaultViewModelProviderFactory");
            return r1;
        }
    }

    /* JADX INFO: compiled from: ActivityViewModelLazy.kt */
    public static final class d extends p implements d.h.a.a<ao> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ ComponentActivity f23845a;

        public d(ComponentActivity r3) {
            this.f23845a = (ComponentActivity) ZeusTransformUtils.wrapperContextForParams(r3, ComponentActivity.class, "com.obric.aiagent.plugin");
            super(0);
        }

        public final ao a() {
            ao r1 = this.f23845a.getViewModelStore();
            o.c(r1, "viewModelStore");
            return r1;
        }

        @Override // d.h.a.a
        public /* synthetic */ ao invoke() {
            return a();
        }
    }

    /* JADX INFO: compiled from: ActivityViewModelLazy.kt */
    public static final class e extends p implements d.h.a.a<androidx.lifecycle.a.a> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ d.h.a.a f23846a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ ComponentActivity f23847b;

        public e(d.h.a.a r3, ComponentActivity r4) {
            d.h.a.a r5 = (d.h.a.a) ZeusTransformUtils.wrapperContextForParams(r3, d.h.a.a.class, "com.obric.aiagent.plugin");
            ComponentActivity r6 = (ComponentActivity) ZeusTransformUtils.wrapperContextForParams(r4, ComponentActivity.class, "com.obric.aiagent.plugin");
            this.f23846a = r5;
            this.f23847b = r6;
            super(0);
        }

        public final androidx.lifecycle.a.a a() {
            d.h.a.a r0 = this.f23846a;
            if (r0 == null) goto L6;
            androidx.lifecycle.a.a r1 = (androidx.lifecycle.a.a) ZeusTransformUtils.preCheckCast(r0.invoke(), androidx.lifecycle.a.a.class, "com.obric.aiagent.plugin");
            if (r1 == null) goto L6;
            return r1;
        L6:
            androidx.lifecycle.a.a r2 = this.f23847b.getDefaultViewModelCreationExtras();
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

    /* JADX INFO: renamed from: lambda$GgkTRQdDne7-nfPfy1OYrF37ZOk, reason: not valid java name */
    public static /* synthetic */ com.obric.autoaction.app.launcherpage.ui.d m514lambda$GgkTRQdDne7nfPfy1OYrF37ZOk(HistoryDetailActivity r0) {
        return adapter_delegate$lambda$1(r0);
    }

    public static /* synthetic */ void lambda$IlG8LIJ2Fz8r856oplv_FkRzV7o(HistoryDetailActivity r0, View r1) {
        initView$lambda$4$lambda$3(r0, r1);
    }

    public static /* synthetic */ x lambda$Wfr0BPfS_BQvVKmQHQrPMiK7M38(com.obric.autoaction.common.base.a r0) {
        return configExtension$lambda$2(r0);
    }

    public static /* synthetic */ w lambda$XcnzyzJErckFt0cPD5ls1W9lCNw(HistoryDetailActivity r0) {
        return binding_delegate$lambda$0(r0);
    }

    @Override // com.obric.autoaction.common.base.BaseActivity
    public d.h.a.b<com.obric.autoaction.common.base.a, x> configExtension() {
        return $$Lambda$HistoryDetailActivity$Wfr0BPfS_BQvVKmQHQrPMiK7M38.INSTANCE;
    }

    public HistoryDetailActivity() {
        this.binding$delegate = g.a(new $$Lambda$HistoryDetailActivity$XcnzyzJErckFt0cPD5ls1W9lCNw(this));
        ComponentActivity r0 = (ComponentActivity) ZeusTransformUtils.preCheckCast(this, ComponentActivity.class, "com.obric.aiagent.plugin");
        d.h.a.a r2 = (d.h.a.a) ZeusTransformUtils.preCheckCast(new c(r0), d.h.a.a.class, "com.obric.aiagent.plugin");
        this.viewModel$delegate = (f) ZeusTransformUtils.preCheckCast(new al(aa.b(com.obric.autoaction.app.launcherpage.history.historydetail.b.class), (d.h.a.a) ZeusTransformUtils.preCheckCast(new d(r0), d.h.a.a.class, "com.obric.aiagent.plugin"), r2, (d.h.a.a) ZeusTransformUtils.preCheckCast(new e(null, r0), d.h.a.a.class, "com.obric.aiagent.plugin")), f.class, "com.obric.aiagent.plugin");
        this.adapter$delegate = g.a(new $$Lambda$HistoryDetailActivity$GgkTRQdDne7nfPfy1OYrF37ZOk(this));
    }

    public static final /* synthetic */ com.obric.autoaction.app.launcherpage.ui.d access$getAdapter(HistoryDetailActivity r2) {
        return ((HistoryDetailActivity) ZeusTransformUtils.wrapperContextForParams(r2, HistoryDetailActivity.class, "com.obric.aiagent.plugin")).getAdapter();
    }

    public static final /* synthetic */ com.obric.autoaction.app.launcherpage.history.historydetail.b access$getViewModel(HistoryDetailActivity r2) {
        return ((HistoryDetailActivity) ZeusTransformUtils.wrapperContextForParams(r2, HistoryDetailActivity.class, "com.obric.aiagent.plugin")).getViewModel();
    }

    private final w getBinding() {
        return (w) ZeusTransformUtils.preCheckCast(this.binding$delegate.b(), w.class, "com.obric.aiagent.plugin");
    }

    private static final w binding_delegate$lambda$0(HistoryDetailActivity r2) {
        w r3 = w.a(((HistoryDetailActivity) ZeusTransformUtils.wrapperContextForParams(r2, HistoryDetailActivity.class, "com.obric.aiagent.plugin")).getLayoutInflater(), null, false);
        o.c(r3, "inflate(...)");
        return r3;
    }

    private final com.obric.autoaction.app.launcherpage.history.historydetail.b getViewModel() {
        return (com.obric.autoaction.app.launcherpage.history.historydetail.b) ZeusTransformUtils.preCheckCast(this.viewModel$delegate.b(), com.obric.autoaction.app.launcherpage.history.historydetail.b.class, "com.obric.aiagent.plugin");
    }

    private static final com.obric.autoaction.app.launcherpage.ui.d adapter_delegate$lambda$1(HistoryDetailActivity r4) {
        RecyclerView r5 = ((HistoryDetailActivity) ZeusTransformUtils.wrapperContextForParams(r4, HistoryDetailActivity.class, "com.obric.aiagent.plugin")).getBinding().f22870b;
        o.c(r5, "historyDetailRv");
        return new com.obric.autoaction.app.launcherpage.ui.d(r5, false, 2, null);
    }

    private final com.obric.autoaction.app.launcherpage.ui.d<com.obric.autoaction.app.launcherpage.ui.h> getAdapter() {
        return (com.obric.autoaction.app.launcherpage.ui.d) ZeusTransformUtils.preCheckCast(this.adapter$delegate.b(), com.obric.autoaction.app.launcherpage.ui.d.class, "com.obric.aiagent.plugin");
    }

    @Override // com.obric.autoaction.common.base.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity
    public void onCreate(Bundle r4) {
        super.onCreate(r4);
        setContentView((View) ZeusTransformUtils.preCheckCast(getBinding().b(), View.class, "com.obric.aiagent.plugin"));
        initData();
        initView();
        initObserver();
        BaseActivity.a.a(BaseActivity.Companion, (FragmentActivity) ZeusTransformUtils.preCheckCast(this, FragmentActivity.class, "com.obric.aiagent.plugin"), false, 1, null);
    }

    private static final x configExtension$lambda$2(com.obric.autoaction.common.base.a r5) {
        o.e(r5, "<this>");
        r5.a((com.obric.autoaction.common.base.b) ZeusTransformUtils.preCheckCast(new com.obric.autoaction.common.ext.b("history_detail_page", false, 2, null), com.obric.autoaction.common.base.b.class, "com.obric.aiagent.plugin"));
        return x.f38692a;
    }

    private final void initData() {
        long r0 = getIntent().getLongExtra(KEY_RECORD_ID, 0);
        String r2 = getIntent().getStringExtra(KEY_SESSION_ID);
        if (r2 != null) goto L5;
        r2 = "";
    L5:
        getViewModel().a(r0, r2);
    }

    private final void initView() {
        OFloatingTitleBar r0 = getBinding().f22869a;
        OFloatingTitleBar.addStartAction$default(r0, ZeusTransformUtils.mapRes(R.drawable.o_floating_title_bar_icon_back, "drawable", "o_floating_title_bar_icon_back"), 0, new $$Lambda$HistoryDetailActivity$IlG8LIJ2Fz8r856oplv_FkRzV7o(this), 2, null);
        o.a(r0);
        com.obric.autoaction.app.launcherpage.b.c.a(r0);
        getBinding().f22870b.setLayoutManager((RecyclerView.h) ZeusTransformUtils.preCheckCast(new LinearLayoutManager((Context) ZeusTransformUtils.preCheckCast(this, Context.class, "com.obric.aiagent.plugin")), RecyclerView.h.class, "com.obric.aiagent.plugin"));
        registerCells();
    }

    private static final void initView$lambda$4$lambda$3(HistoryDetailActivity r1, View r2) {
        ((HistoryDetailActivity) ZeusTransformUtils.wrapperContextForParams(r1, HistoryDetailActivity.class, "com.obric.aiagent.plugin")).finish();
    }

    private final void initObserver() {
        q.a((androidx.lifecycle.p) ZeusTransformUtils.preCheckCast(this, androidx.lifecycle.p.class, "com.obric.aiagent.plugin")).b((m) ZeusTransformUtils.preCheckCast(new b(this, null), m.class, "com.obric.aiagent.plugin"));
    }

    private final void registerCells() {
        getAdapter().a(new Class[]{com.obric.autoaction.app.launcherpage.history.historydetail.a.d.class, com.obric.autoaction.app.launcherpage.history.historydetail.a.b.class, com.obric.autoaction.app.launcherpage.history.historydetail.a.i.class, com.obric.autoaction.app.launcherpage.history.historydetail.a.g.class, com.obric.autoaction.app.launcherpage.history.historydetail.a.f.class});
        getBinding().f22870b.setAdapter((RecyclerView.a) ZeusTransformUtils.preCheckCast(getAdapter(), RecyclerView.a.class, "com.obric.aiagent.plugin"));
    }
}
