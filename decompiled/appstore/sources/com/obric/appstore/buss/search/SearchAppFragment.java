package com.obric.appstore.buss.search;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewStub;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.RepeatOnLifecycleKt;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.apm.constant.CommonKey;
import com.bytedanceos.common.model.AppInfo;
import com.bytedanceos.common.toolbox.ServerElements;
import com.obric.appstore.R;
import com.obric.appstore.base.BaseListAdapter;
import com.obric.appstore.base.BaseLoadMoreListFragment;
import com.obric.appstore.base.IPageLoadViewModel;
import com.obric.appstore.base.o;
import com.obric.appstore.ui.adapter.AppInfoLoadMoreUIAdapter;
import com.obric.appstore.ui.adapter.ItemAppProvider;
import com.obric.appstore.util.s;
import com.obric.oui.status.OPageStatus;
import com.smt.obric.appstore.ui.app.AppStatusViewModel;
import kotlin.Function;
import kotlin.Lazy;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.q;
import kotlin.jvm.internal.u;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.d0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\t\u0018\u0000 B2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001CB\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0019\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0016¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\f\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\nH\u0014¢\u0006\u0004\b\f\u0010\rJ!\u0010\u000f\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\n2\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u0017\u0010\u0013\u001a\u00020\u00072\u0006\u0010\u0012\u001a\u00020\u0011H\u0016¢\u0006\u0004\b\u0013\u0010\u0014J \u0010\u0018\u001a\u00020\u00072\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0017\u001a\u00020\u0015H\u0082@¢\u0006\u0004\b\u0018\u0010\u0019J\u0011\u0010\u001a\u001a\u0004\u0018\u00010\u0015H\u0002¢\u0006\u0004\b\u001a\u0010\u001bR\u001a\u0010!\u001a\u00020\u001c8\u0014X\u0094D¢\u0006\f\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 R\u001b\u0010'\u001a\u00020\"8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b#\u0010$\u001a\u0004\b%\u0010&R\u001a\u0010-\u001a\u00020(8\u0014X\u0094\u0004¢\u0006\f\n\u0004\b)\u0010*\u001a\u0004\b+\u0010,R\u001b\u00102\u001a\u00020.8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b/\u0010$\u001a\u0004\b0\u00101R\u001a\u00106\u001a\b\u0012\u0004\u0012\u00020\u0002038TX\u0094\u0004¢\u0006\u0006\u001a\u0004\b4\u00105R\u0013\u0010:\u001a\u0004\u0018\u0001078F¢\u0006\u0006\u001a\u0004\b8\u00109R$\u0010A\u001a\u00020;2\u0006\u0010<\u001a\u00020;8B@BX\u0082\u000e¢\u0006\f\u001a\u0004\b=\u0010>\"\u0004\b?\u0010@¨\u0006D"}, d2 = {"Lcom/obric/appstore/buss/search/SearchAppFragment;", "Lcom/obric/appstore/base/BaseLoadMoreListFragment;", "Lcom/bytedanceos/common/model/AppInfo;", "<init>", "()V", "Landroid/os/Bundle;", "savedInstanceState", "", "onCreate", "(Landroid/os/Bundle;)V", "Landroid/view/View;", ServerElements.CONTENT, "B", "(Landroid/view/View;)V", "view", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "Lcom/obric/oui/status/OPageStatus;", "empty", "Q", "(Lcom/obric/oui/status/OPageStatus;)V", "", "downloadIntentSessionId", "appName", "j0", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "n0", "()Ljava/lang/String;", "", "p", "I", "v", "()I", "headerLayoutId", "Lcom/obric/appstore/buss/search/SearchAppVM;", "q", "Lkotlin/Lazy;", "q0", "()Lcom/obric/appstore/buss/search/SearchAppVM;", "searchAppVM", "Lcom/obric/appstore/ui/adapter/AppInfoLoadMoreUIAdapter;", "r", "Lcom/obric/appstore/ui/adapter/AppInfoLoadMoreUIAdapter;", "k0", "()Lcom/obric/appstore/ui/adapter/AppInfoLoadMoreUIAdapter;", "adapter", "Lcom/smt/obric/appstore/ui/app/AppStatusViewModel;", "s", "l0", "()Lcom/smt/obric/appstore/ui/app/AppStatusViewModel;", "appStatusVM", "Lcom/obric/appstore/base/o;", "o0", "()Lcom/obric/appstore/base/o;", "loadMoreVM", "Lcom/obric/appstore/buss/search/SearchContainerFragment;", "p0", "()Lcom/obric/appstore/buss/search/SearchContainerFragment;", "parent", "", CommonKey.KEY_VALUE, "m0", "()Z", "r0", "(Z)V", "downloadIntentHandled", "t", "a", "obriccommon_sysapp_updateRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nSearchAppFragment.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SearchAppFragment.kt\ncom/obric/appstore/buss/search/SearchAppFragment\n+ 2 FragmentViewModelLazy.kt\nandroidx/fragment/app/FragmentViewModelLazyKt\n*L\n1#1,336:1\n106#2,15:337\n106#2,15:352\n*S KotlinDebug\n*F\n+ 1 SearchAppFragment.kt\ncom/obric/appstore/buss/search/SearchAppFragment\n*L\n71#1:337,15\n77#1:352,15\n*E\n"})
public final class SearchAppFragment extends BaseLoadMoreListFragment<AppInfo> {

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static final a f10832t = null;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final int f10833p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final Lazy f10834q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final AppInfoLoadMoreUIAdapter f10835r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final Lazy f10836s;

    public static final class a {
        public /* synthetic */ a(DefaultConstructorMarker r10) {
            this();
        }

        public a() {
        }
    }

    public static final class b extends RecyclerView.OnScrollListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ SearchAppFragment f10842a;

        public b(SearchAppFragment r10) {
            this.f10842a = r10;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView r10, int r11) {
            q.g(r10, "recyclerView");
            if (r11 != 1) goto L6;
            com.obric.appstore.util.j.c(this.f10842a);
            return;
        }
    }

    public static final class c implements Observer, FunctionAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function1 f10843a;

        public c(Function1 r10) {
            q.g(r10, "function");
            this.f10843a = r10;
        }

        public final boolean equals(Object r10) {
            if ((r10 instanceof Observer) == true) goto L5;
            return false;
        L5:
            if ((r10 instanceof FunctionAdapter) == true) goto L7;
            return false;
        L7:
            return q.b(getFunctionDelegate(), ((FunctionAdapter) r10).getFunctionDelegate());
        }

        @Override // kotlin.jvm.internal.FunctionAdapter
        public final Function getFunctionDelegate() {
            return this.f10843a;
        }

        public final int hashCode() {
            return getFunctionDelegate().hashCode();
        }

        @Override // androidx.lifecycle.Observer
        public final /* synthetic */ void onChanged(Object r10) {
            this.f10843a.invoke(r10);
        }
    }

    /* JADX INFO: renamed from: com.obric.appstore.buss.search.SearchAppFragment$onViewCreated$3, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.obric.appstore.buss.search.SearchAppFragment$onViewCreated$3", f = "SearchAppFragment.kt", i = {}, l = {134}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass3 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ SearchAppFragment this$0;

        /* JADX INFO: renamed from: com.obric.appstore.buss.search.SearchAppFragment$onViewCreated$3$1, reason: invalid class name */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
        @DebugMetadata(c = "com.obric.appstore.buss.search.SearchAppFragment$onViewCreated$3$1", f = "SearchAppFragment.kt", i = {}, l = {141}, m = "invokeSuspend", n = {}, s = {})
        public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            int label;
            final /* synthetic */ SearchAppFragment this$0;

            public AnonymousClass1(SearchAppFragment r10, Continuation<? super AnonymousClass1> r11) {
                this.this$0 = r10;
                super(2, r11);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            @NotNull
            public final Continuation<Unit> create(@Nullable Object r10, @NotNull Continuation<?> r11) {
                return new AnonymousClass1(this.this$0, r11);
            }

            @Override // kotlin.jvm.functions.Function2
            /* JADX INFO: renamed from: invoke */
            public /* bridge */ /* synthetic */ Object mo0invoke(CoroutineScope r10, Continuation<? super Unit> r11) {
                return invoke2(r10, r11);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            @Nullable
            public final Object invokeSuspend(@NotNull Object r10) {
                Object r11 = kotlin.coroutines.intrinsics.a.d();
                int r12 = this.label;
                if (r12 == 0) goto L8;
                if (r12 != 1) goto L7;
                kotlin.c.b(r10);
            L20:
                return Unit.f21064a;
            L7:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            L8:
                kotlin.c.b(r10);
                String r13 = SearchAppFragment.g0(this.this$0);
                if (r13 != null) goto L13;
                return Unit.f21064a;
            L13:
                if (SearchAppFragment.f0(this.this$0) == true) goto L15;
                SearchAppFragment.i0(this.this$0, true);
                String r14 = SearchAppFragment.h0(this.this$0).G();
                SearchAppFragment r15 = this.this$0;
                this.label = 1;
                if (SearchAppFragment.d0(r15, r13, r14, this) != r11) goto L20;
                return r11;
            L15:
                return Unit.f21064a;
            }

            @Nullable
            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final Object invoke2(@NotNull CoroutineScope r10, @Nullable Continuation<? super Unit> r11) {
                return ((AnonymousClass1) create(r10, r11)).invokeSuspend(Unit.f21064a);
            }
        }

        public AnonymousClass3(SearchAppFragment r10, Continuation<? super AnonymousClass3> r11) {
            this.this$0 = r10;
            super(2, r11);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final Continuation<Unit> create(@Nullable Object r10, @NotNull Continuation<?> r11) {
            return new AnonymousClass3(this.this$0, r11);
        }

        @Override // kotlin.jvm.functions.Function2
        /* JADX INFO: renamed from: invoke */
        public /* bridge */ /* synthetic */ Object mo0invoke(CoroutineScope r10, Continuation<? super Unit> r11) {
            return invoke2(r10, r11);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object r10) {
            Object r11 = kotlin.coroutines.intrinsics.a.d();
            int r12 = this.label;
            if (r12 == 0) goto L8;
            if (r12 != 1) goto L7;
            kotlin.c.b(r10);
        L12:
            return Unit.f21064a;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            kotlin.c.b(r10);
            LifecycleOwner r13 = this.this$0.getViewLifecycleOwner();
            q.f(r13, "getViewLifecycleOwner(...)");
            Lifecycle.State r14 = Lifecycle.State.STARTED;
            AnonymousClass1 r15 = new AnonymousClass1(this.this$0, null);
            this.label = 1;
            if (RepeatOnLifecycleKt.b(r13, r14, r15, this) != r11) goto L12;
            return r11;
        }

        @Nullable
        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(@NotNull CoroutineScope r10, @Nullable Continuation<? super Unit> r11) {
            return ((AnonymousClass3) create(r10, r11)).invokeSuspend(Unit.f21064a);
        }
    }

    static {
        f10832t = new a(null);
    }

    public SearchAppFragment() {
        final Function0<Fragment> r10 = new SearchAppFragment$special$$inlined$viewModels$default$1(this);
        LazyThreadSafetyMode r11 = LazyThreadSafetyMode.NONE;
        final Lazy r12 = kotlin.b.a(r11, new SearchAppFragment$special$$inlined$viewModels$default$2(r10));
        final Function0 r13 = null;
        this.f10834q = FragmentViewModelLazyKt.c(this, u.b(SearchAppVM.class), new SearchAppFragment$special$$inlined$viewModels$default$3(r12), new SearchAppFragment$special$$inlined$viewModels$default$4(r13, r12), new SearchAppFragment$special$$inlined$viewModels$default$5(this, r12));
        this.f10835r = new AppInfoLoadMoreUIAdapter();
        Function0<ViewModelProvider.Factory> r14 = new SearchAppFragment$appStatusVM$2(this);
        final Function0<Fragment> r15 = new SearchAppFragment$special$$inlined$viewModels$default$6(this);
        final Lazy r16 = kotlin.b.a(r11, new SearchAppFragment$special$$inlined$viewModels$default$7(r15));
        this.f10836s = FragmentViewModelLazyKt.c(this, u.b(AppStatusViewModel.class), new SearchAppFragment$special$$inlined$viewModels$default$8(r16), new SearchAppFragment$special$$inlined$viewModels$default$9(r13, r16), r14);
    }

    public static final /* synthetic */ Object d0(SearchAppFragment r10, String r11, String r12, Continuation r13) {
        return r10.j0(r11, r12, r13);
    }

    public static final /* synthetic */ AppStatusViewModel e0(SearchAppFragment r10) {
        return r10.l0();
    }

    public static final /* synthetic */ boolean f0(SearchAppFragment r10) {
        return r10.m0();
    }

    public static final /* synthetic */ String g0(SearchAppFragment r10) {
        return r10.n0();
    }

    public static final /* synthetic */ SearchAppVM h0(SearchAppFragment r10) {
        return r10.q0();
    }

    public static final /* synthetic */ void i0(SearchAppFragment r10, boolean r11) {
        r10.r0(r11);
    }

    @Override // com.obric.appstore.base.BaseFragment, com.obric.appstore.base.e
    public void B(View r10) {
        q.g(r10, ServerElements.CONTENT);
        super.B(r10);
        SearchContainerFragment r11 = p0();
        if (r11 == null) goto L10;
        SearchVM r12 = r11.T();
        if (r12 == null) goto L11;
        LiveData r13 = r12.j();
        if (r13 == null) goto L12;
        r13.i(getViewLifecycleOwner(), new c(new SearchAppFragment$onCreateContentView$1(this)));
        return;
    L12:
        return;
    L11:
        return;
    }

    @Override // com.obric.appstore.base.BaseFragment
    public void Q(OPageStatus r10) {
        q.g(r10, "empty");
        if (getView() == null) goto L6;
        r10.setType(0);
        r10.setTitle(getString(R.string.obric_empty_search_apps));
        return;
    }

    @Override // com.obric.appstore.base.BaseLoadMoreListFragment, com.obric.appstore.base.BaseListFragment
    public /* bridge */ /* synthetic */ BaseListAdapter U() {
        return k0();
    }

    @Override // com.obric.appstore.base.BaseLoadMoreListFragment
    public /* bridge */ /* synthetic */ IPageLoadViewModel b0() {
        return o0();
    }

    public final Object j0(String r10, String r11, Continuation r12) {
        Object r13 = d0.e(new SearchAppFragment$autoDownloadIfFirstExactMatch$2(r10, r11, this, null), r12);
        if (r13 != kotlin.coroutines.intrinsics.a.d()) goto L6;
        return r13;
    L6:
        return Unit.f21064a;
    }

    public AppInfoLoadMoreUIAdapter k0() {
        return this.f10835r;
    }

    public final AppStatusViewModel l0() {
        return (AppStatusViewModel) this.f10836s.getValue();
    }

    public final boolean m0() {
        Boolean r10 = (Boolean) q0().H().c("KEY_DOWNLOAD_INTENT_HANDLED");
        if (r10 != null) goto L7;
        return false;
    L7:
        return r10.booleanValue();
    }

    public final String n0() {
        Intent r10 = r();
        if (r10 != null) goto L5;
        return null;
    L5:
        if (r10.hasExtra("isid") != true) goto L11;
        Intent r11 = r();
        if (r11 != null) goto L9;
        return null;
    L9:
        return r11.getStringExtra("isid");
    L11:
        return null;
    }

    public o o0() {
        return q0();
    }

    @Override // com.obric.appstore.base.BaseLoadMoreListFragment, com.obric.appstore.base.BaseListFragment, com.obric.appstore.base.BaseFragment, com.obric.appstore.base.e, androidx.fragment.app.Fragment
    public void onCreate(Bundle r13) {
        super.onCreate(r13);
        k0().addItemProvider(new ItemAppProvider(getPageSource(), false, false, null, Integer.valueOf(com.obric.appstore.buss.detail.o.a()), false, false, 0.0f, 168, null));
    }

    @Override // com.obric.appstore.base.BaseListFragment, com.obric.appstore.base.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View r10, Bundle r11) {
        q.g(r10, "view");
        super.onViewCreated(r10, r11);
        s r12 = J();
        if (r12 == null) goto L9;
        sa.c r13 = r12.k();
        if (r13 == null) goto L9;
        ViewStub r14 = r13.f24568b;
        if (r14 == null) goto L9;
        r14.setLayoutResource(R.layout.common_state_empty_view_medium);
    L9:
        RecyclerView r15 = Y();
        if (r15 == null) goto L12;
        r15.addOnScrollListener(new b(this));
    L12:
        LifecycleOwner r16 = getViewLifecycleOwner();
        q.f(r16, "getViewLifecycleOwner(...)");
        kotlinx.coroutines.h.d(androidx.lifecycle.s.a(r16), null, null, new AnonymousClass3(this, null), 3, null);
        final RecyclerView r17 = Y();
        if (r17 == null) goto L16;
        u8.c.c(r17, new SearchAppFragment$onViewCreated$4$1(r17));
        r17.setClipToPadding(false);
        boolean r18 = false;
        int r19 = 0;
        int r20 = 0;
        r17.addItemDecoration(new bb.e(com.obric.appstore.buss.detail.o.c(), com.obric.appstore.buss.detail.o.b(), com.obric.appstore.buss.detail.o.c(), r18, r19, r20, 48, null));
        return;
    }

    public final SearchContainerFragment p0() {
        Fragment r10 = getParentFragment();
        if ((r10 instanceof SearchContainerFragment) == true) goto L7;
        return null;
    L7:
        return (SearchContainerFragment) r10;
    }

    public final SearchAppVM q0() {
        return (SearchAppVM) this.f10834q.getValue();
    }

    public final void r0(boolean r10) {
        q0().H().g("KEY_DOWNLOAD_INTENT_HANDLED", Boolean.valueOf(r10));
    }

    @Override // com.obric.appstore.base.e
    public int v() {
        return this.f10833p;
    }
}
