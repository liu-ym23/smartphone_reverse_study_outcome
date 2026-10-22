package com.bytedanceos.appstore.buss.fragment;

import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.apm.constant.TraceStatsConsts;
import com.bytedanceos.appstore.buss.adapter.BinderAdapter;
import com.bytedanceos.appstore.buss.adapter.app.item.adapter.ItemHorizontalAdapter;
import com.bytedanceos.appstore.buss.entity.CommonAppEntity;
import com.bytedanceos.appstore.buss.entity.netwrap.AppsWrap;
import com.bytedanceos.appstore.buss.utilities.CommonUtil;
import com.bytedanceos.appstore.buss.viewmodels.AppSystemViewModel;
import com.bytedanceos.appstore.buss.widget.recyclerview.CommonRecyclerView;
import com.bytedanceos.common.BaseApplication;
import com.bytedanceos.common.eventbus.PackageChangeEvent;
import com.bytedanceos.common.networkv2.params.NetKey;
import com.obric.appstore.R;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;
import kotlin.Lazy;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Ref$IntRef;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.CoroutineScope;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000~\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 72\u00020\u00012\u00020\u0002:\u0001EB\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0005H\u0014¢\u0006\u0004\b\u0006\u0010\u0004J\u000f\u0010\u0007\u001a\u00020\u0005H\u0014¢\u0006\u0004\b\u0007\u0010\u0004J\u000f\u0010\b\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\b\u0010\u0004J\u000f\u0010\t\u001a\u00020\u0005H\u0014¢\u0006\u0004\b\t\u0010\u0004J\u0017\u0010\f\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\nH\u0007¢\u0006\u0004\b\f\u0010\rJ#\u0010\u0012\u001a\u00020\u00052\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010H\u0016¢\u0006\u0004\b\u0012\u0010\u0013J\u000f\u0010\u0014\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0014\u0010\u0004J\u000f\u0010\u0015\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u0015\u0010\u0004R\u001d\u0010\u001b\u001a\u0004\u0018\u00010\u00168BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001aR\u001b\u0010 \u001a\u00020\u001c8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001d\u0010\u0018\u001a\u0004\b\u001e\u0010\u001fR\u0018\u0010$\u001a\u0004\u0018\u00010!8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\"\u0010#R\u0018\u0010(\u001a\u0004\u0018\u00010%8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b&\u0010'R$\u0010.\u001a\u0012\u0012\u0004\u0012\u00020*0)j\b\u0012\u0004\u0012\u00020*`+8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b,\u0010-R$\u00100\u001a\u0012\u0012\u0004\u0012\u00020\u00100)j\b\u0012\u0004\u0012\u00020\u0010`+8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b/\u0010-R\u0016\u00104\u001a\u0002018\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b2\u00103R\u0016\u00106\u001a\u0002018\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b5\u00103R\u0014\u00109\u001a\u0002018TX\u0094\u0004¢\u0006\u0006\u001a\u0004\b7\u00108R\u001c\u0010<\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010:8TX\u0094\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010;R\u0014\u0010@\u001a\u00020=8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b>\u0010?R\u0014\u0010D\u001a\u00020A8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\bB\u0010C¨\u0006F"}, d2 = {"Lcom/bytedanceos/appstore/buss/fragment/AppSystemFragment;", "Lh7/c;", "Ljava/util/Observer;", "<init>", "()V", "", "E", "initData", "F", "t", "Lcom/bytedanceos/common/eventbus/PackageChangeEvent;", "event", "onEvent", "(Lcom/bytedanceos/common/eventbus/PackageChangeEvent;)V", "Ljava/util/Observable;", "o", "", "arg", "update", "(Ljava/util/Observable;Ljava/lang/Object;)V", "onDestroyView", "P", "", "f", "Lkotlin/Lazy;", "getPageSource", "()Ljava/lang/String;", "pageSource", "Lcom/bytedanceos/appstore/buss/viewmodels/AppSystemViewModel;", "g", "O", "()Lcom/bytedanceos/appstore/buss/viewmodels/AppSystemViewModel;", "viewModel", "Lcom/bytedanceos/appstore/buss/adapter/app/item/adapter/ItemHorizontalAdapter;", "h", "Lcom/bytedanceos/appstore/buss/adapter/app/item/adapter/ItemHorizontalAdapter;", "uninstallAdapter", "Lcom/bytedanceos/appstore/buss/adapter/BinderAdapter;", "i", "Lcom/bytedanceos/appstore/buss/adapter/BinderAdapter;", "recommendAdapter", "Ljava/util/ArrayList;", "Lcom/bytedanceos/appstore/buss/entity/CommonAppEntity;", "Lkotlin/collections/ArrayList;", "j", "Ljava/util/ArrayList;", "uninstallSystemAppList", "k", "recommendAppList", "", "l", "I", "defaultSpanCount", "m", "currentSpanCount", "n", "()I", "layoutId", "Lkotlin/Function0;", "()Lkotlin/jvm/functions/Function0;", "onRetryListener", "Lx7/q;", "M", "()Lx7/q;", "fragmentTvAppSystemBinding", "Lx7/o0;", "N", "()Lx7/o0;", "tvItemAppManagerEmptyBinding", "a", "app_sysapp_updateRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nAppSystemFragment.kt\nKotlin\n*S Kotlin\n*F\n+ 1 AppSystemFragment.kt\ncom/bytedanceos/appstore/buss/fragment/AppSystemFragment\n+ 2 FragmentViewModelLazy.kt\nandroidx/fragment/app/FragmentViewModelLazyKt\n+ 3 BaseBinderAdapter.kt\ncom/chad/library/adapter/base/BaseBinderAdapter\n+ 4 NetSource.kt\ncom/bytedanceos/appstore/buss/network/NetSourceKt\n*L\n1#1,225:1\n106#2,15:226\n57#3,3:241\n57#3,3:244\n50#4,9:247\n50#4,9:256\n*S KotlinDebug\n*F\n+ 1 AppSystemFragment.kt\ncom/bytedanceos/appstore/buss/fragment/AppSystemFragment\n*L\n62#1:226,15\n121#1:241,3\n122#1:244,3\n75#1:247,9\n88#1:256,9\n*E\n"})
public final class AppSystemFragment extends h7.c implements Observer {

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final a f8516n = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Lazy f8517f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Lazy f8518g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public ItemHorizontalAdapter f8519h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public BinderAdapter f8520i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final ArrayList f8521j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final ArrayList f8522k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f8523l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f8524m;

    public static final class a {
        public /* synthetic */ a(DefaultConstructorMarker r10) {
            this();
        }

        public final Fragment a(String r10) {
            AppSystemFragment r11 = new AppSystemFragment();
            r11.setArguments(androidx.core.os.c.a(new Pair[]{kotlin.d.a(NetKey.PAGE_SOURCE, r10)}));
            return r11;
        }

        public a() {
        }
    }

    public static final class b extends GridLayoutManager.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AppSystemFragment f8525a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Ref$IntRef f8526b;

        public b(AppSystemFragment r10, Ref$IntRef r11) {
            this.f8525a = r10;
            this.f8526b = r11;
        }

        @Override // androidx.recyclerview.widget.GridLayoutManager.b
        public int getSpanSize(int r10) {
            if ((AppSystemFragment.J(this.f8525a).get(r10) instanceof String) == false) goto L9;
            int r11 = this.f8526b.element;
            if (r11 != 0) goto L8;
            return 1;
        L8:
            return r11;
        L9:
            return 1;
        }
    }

    public static final class c extends GridLayoutManager.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AppSystemFragment f8527a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Ref$IntRef f8528b;

        public c(AppSystemFragment r10, Ref$IntRef r11) {
            this.f8527a = r10;
            this.f8528b = r11;
        }

        @Override // androidx.recyclerview.widget.GridLayoutManager.b
        public int getSpanSize(int r10) {
            if ((AppSystemFragment.J(this.f8527a).get(r10) instanceof String) == false) goto L9;
            int r11 = this.f8528b.element;
            if (r11 != 0) goto L8;
            return 1;
        L8:
            return r11;
        L9:
            return 1;
        }
    }

    /* JADX INFO: renamed from: com.bytedanceos.appstore.buss.fragment.AppSystemFragment$update$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.bytedanceos.appstore.buss.fragment.AppSystemFragment$update$1", f = "AppSystemFragment.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ AppSystemFragment this$0;

        public AnonymousClass1(AppSystemFragment r10, Continuation<? super AnonymousClass1> r11) {
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
            kotlin.coroutines.intrinsics.a.d();
            if (this.label != 0) goto L10;
            kotlin.c.b(r10);
            AppSystemFragment.L(this.this$0);
            BinderAdapter r11 = AppSystemFragment.I(this.this$0);
            if (r11 == null) goto L8;
            r11.notifyDataSetChanged();
        L8:
            return Unit.f21064a;
        L10:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }

        @Nullable
        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(@NotNull CoroutineScope r10, @Nullable Continuation<? super Unit> r11) {
            return ((AnonymousClass1) create(r10, r11)).invokeSuspend(Unit.f21064a);
        }
    }

    static {
        f8516n = new a(null);
    }

    public AppSystemFragment() {
        this.f8517f = kotlin.b.b(new AppSystemFragment$pageSource$2(this));
        final Function0<Fragment> r10 = new AppSystemFragment$special$$inlined$viewModels$default$1(this);
        final Lazy r11 = kotlin.b.a(LazyThreadSafetyMode.NONE, new AppSystemFragment$special$$inlined$viewModels$default$2(r10));
        final Function0 r12 = null;
        this.f8518g = FragmentViewModelLazyKt.c(this, kotlin.jvm.internal.u.b(AppSystemViewModel.class), new AppSystemFragment$special$$inlined$viewModels$default$3(r11), new AppSystemFragment$special$$inlined$viewModels$default$4(r12, r11), new AppSystemFragment$special$$inlined$viewModels$default$5(this, r11));
        this.f8521j = new ArrayList();
        this.f8522k = new ArrayList();
        this.f8523l = 1;
        this.f8524m = 1;
    }

    public static /* synthetic */ void G(AppSystemFragment r10, com.bytedanceos.appstore.buss.network.h r11) {
        R(r10, r11);
    }

    public static /* synthetic */ void H(AppSystemFragment r10, com.bytedanceos.appstore.buss.network.h r11) {
        Q(r10, r11);
    }

    public static final /* synthetic */ BinderAdapter I(AppSystemFragment r10) {
        return r10.f8520i;
    }

    public static final /* synthetic */ ArrayList J(AppSystemFragment r10) {
        return r10.f8522k;
    }

    public static final /* synthetic */ AppSystemViewModel K(AppSystemFragment r10) {
        return r10.O();
    }

    public static final /* synthetic */ void L(AppSystemFragment r10) {
        r10.P();
    }

    public static final void Q(AppSystemFragment r10, com.bytedanceos.appstore.buss.network.h r11) {
        kotlin.jvm.internal.q.g(r10, "this$0");
        kotlin.jvm.internal.q.d(r11);
        if ((r11 instanceof com.bytedanceos.appstore.buss.network.h.b) == false) goto L6;
        r10.B();
        return;
    L6:
        if ((r11 instanceof com.bytedanceos.appstore.buss.network.h.c) == false) goto L14;
        r10.r();
        r10.f8521j.clear();
        AppsWrap r12 = (AppsWrap) ((com.bytedanceos.appstore.buss.network.h.c) r11).a();
        if (r12 == null) goto L12;
        List r13 = r12.getApps();
        if (r13 == null) goto L12;
        r10.f8521j.addAll(r13);
    L12:
        r10.P();
        return;
    L14:
        if ((r11 instanceof com.bytedanceos.appstore.buss.network.h.a) == false) goto L19;
        com.bytedanceos.appstore.buss.network.h.a r14 = (com.bytedanceos.appstore.buss.network.h.a) r11;
        com.bytedanceos.appstore.buss.utilities.j.f8856a.c(r14.c());
        r10.D(r14);
        return;
    }

    public static final void R(AppSystemFragment r10, com.bytedanceos.appstore.buss.network.h r11) {
        kotlin.jvm.internal.q.g(r10, "this$0");
        kotlin.jvm.internal.q.d(r11);
        if ((r11 instanceof com.bytedanceos.appstore.buss.network.h.b) == false) goto L6;
        return;
    L6:
        if ((r11 instanceof com.bytedanceos.appstore.buss.network.h.c) == false) goto L13;
        List r12 = (List) ((com.bytedanceos.appstore.buss.network.h.c) r11).a();
        if (r12 == null) goto L16;
        r10.f8522k.clear();
        r10.f8522k.addAll(r12);
        BinderAdapter r13 = r10.f8520i;
        if (r13 == null) goto L17;
        r13.setList(r10.f8522k);
        return;
    L17:
        return;
    L16:
        return;
    L13:
        if ((r11 instanceof com.bytedanceos.appstore.buss.network.h.a) == false) goto L19;
        com.bytedanceos.appstore.buss.network.h.a r14 = (com.bytedanceos.appstore.buss.network.h.a) r11;
        com.bytedanceos.appstore.buss.utilities.j.f8856a.c(r14.c());
        com.bytedanceos.appstore.buss.utilities.s.e(r10, r14.c());
        return;
    }

    private final String getPageSource() {
        return (String) this.f8517f.getValue();
    }

    @Override // h7.c
    public void E() {
        O().l().i(this, new v(this));
        O().j().i(this, new w(this));
    }

    @Override // h7.c
    public void F() {
        if (getActivity() != null) goto L5;
        return;
    L5:
        if (M().f25732c != null) goto L7;
        return;
    L7:
        if (M().f25731b == null) goto L16;
        Ref$IntRef r10 = new Ref$IntRef();
        com.bytedanceos.appstore.buss.utilities.f r11 = com.bytedanceos.appstore.buss.utilities.f.f8838a;
        int r12 = r11.f(getActivity());
        r10.element = r12;
        if (r12 == this.f8524m) goto L15;
        RecyclerView.LayoutManager r13 = M().f25732c.getLayoutManager();
        kotlin.jvm.internal.q.e(r13, "null cannot be cast to non-null type androidx.recyclerview.widget.GridLayoutManager");
        ((GridLayoutManager) r13).Q(r10.element);
        this.f8524m = r10.element;
        ViewGroup.LayoutParams r14 = M().f25732c.getLayoutParams();
        r14.width = r10.element * r11.a();
        M().f25732c.setLayoutParams(r14);
        RecyclerView.LayoutManager r15 = M().f25731b.getLayoutManager();
        kotlin.jvm.internal.q.e(r15, "null cannot be cast to non-null type androidx.recyclerview.widget.GridLayoutManager");
        GridLayoutManager r16 = (GridLayoutManager) r15;
        r16.Q(r10.element);
        r16.R(new c(this, r10));
        this.f8524m = r10.element;
        ViewGroup.LayoutParams r17 = M().f25731b.getLayoutParams();
        r17.width = r10.element * r11.a();
        M().f25731b.setLayoutParams(r17);
        return;
    L15:
        return;
    }

    public final x7.q M() {
        x7.q r10 = x7.q.a(m());
        kotlin.jvm.internal.q.f(r10, "bind(...)");
        return r10;
    }

    public final x7.o0 N() {
        x7.o0 r10 = x7.o0.a(m().findViewById(R.id.item_empty));
        kotlin.jvm.internal.q.f(r10, "bind(...)");
        return r10;
    }

    public final AppSystemViewModel O() {
        return (AppSystemViewModel) this.f8518g.getValue();
    }

    public final void P() {
        ArrayList r10 = this.f8521j;
        if (r10 != null) goto L5;
    L8:
        ArrayList r11 = this.f8521j;
        if (r11 != null) goto L11;
    L21:
        CommonRecyclerView r12 = M().f25732c;
        if (r12 == null) goto L25;
        r12.setVisibility(8);
    L25:
        ConstraintLayout r13 = N().f25720b;
        if (r13 == null) goto L29;
        r13.setVisibility(0);
    L29:
        ImageView r14 = N().f25721c;
        if (r14 == null) goto L32;
        r14.setImageResource(R.drawable.bytedance_icon);
    L32:
        TextView r15 = N().f25723e;
        if (r15 == null) goto L36;
        r15.setText(getString(R.string.myapp_empty_system_apps_title));
    L36:
        TextView r16 = N().f25722d;
        if (r16 == null) goto L40;
        r16.setText(getString(R.string.myapp_empty_system_apps_des));
    L40:
        ItemHorizontalAdapter r17 = this.f8519h;
        if (r17 == null) goto L44;
        r17.setList(this.f8521j);
        return;
    L44:
        return;
    L11:
        if (r11.isEmpty() == true) goto L21;
        CommonRecyclerView r18 = M().f25732c;
        if (r18 == null) goto L17;
        r18.setVisibility(0);
    L17:
        ConstraintLayout r19 = N().f25720b;
        if (r19 == null) goto L40;
        r19.setVisibility(8);
        goto L40
    L5:
        if (r10.isEmpty() == true) goto L8;
        CommonUtil.f8830a.d(this.f8521j);
        goto L8
    }

    @Override // h7.c
    public void initData() {
        h7.c.w(this, getString(R.string.myapp_system_apps), false, false, 6, null);
        BaseApplication.c().b().addObserver(this);
        EventBus.getDefault().register(this);
        Ref$IntRef r10 = new Ref$IntRef();
        int r11 = com.bytedanceos.appstore.buss.utilities.f.f8838a.f(getActivity());
        r10.element = r11;
        if (r11 != 0) goto L5;
        M().f25732c.setLayoutManager(new GridLayoutManager(l(), this.f8523l));
    L6:
        this.f8519h = new ItemHorizontalAdapter(false, null, getPageSource(), 3, null);
        M().f25732c.setAdapter(this.f8519h);
        M().f25732c.addItemDecoration(new u7.b(0, 1, null));
        if (r10.element != 0) goto L9;
        GridLayoutManager r12 = new GridLayoutManager(l(), this.f8523l);
    L10:
        this.f8524m = r10.element;
        M().f25731b.setLayoutManager(r12);
        BinderAdapter r13 = new BinderAdapter();
        r13.addItemBinder(String.class, new d7.d(), null);
        r13.addItemBinder(CommonAppEntity.class, new d7.c(getPageSource()), null);
        this.f8520i = r13;
        M().f25731b.setAdapter(this.f8520i);
        M().f25731b.addItemDecoration(new u7.b(0, 1, null));
        M().f25731b.setPageSource(getPageSource());
        r12.R(new b(this, r10));
        Bundle r14 = new Bundle();
        r14.putString(TraceStatsConsts.PAGE_STATS_KEY_PAGE_NAME, getPageSource());
        f9.b.b("exposure_pages_main", r14);
        return;
    L9:
        r12 = new GridLayoutManager(l(), r10.element);
        goto L10
    L5:
        M().f25732c.setLayoutManager(new GridLayoutManager(l(), r10.element));
        goto L6
    }

    @Override // h7.c
    public int n() {
        return R.layout.fragment_tv_app_system;
    }

    @Override // h7.c
    public Function0 o() {
        return new AppSystemFragment$onRetryListener$1(this);
    }

    @Override // h7.c, androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        EventBus.getDefault().unregister(this);
        BaseApplication.c().b().deleteObserver(this);
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public final void onEvent(@NotNull PackageChangeEvent r10) {
        kotlin.jvm.internal.q.g(r10, "event");
        int r11 = r10.getEventStatus();
        if (r11 != 1) goto L5;
        P();
        return;
    L5:
        if (r11 != 2) goto L11;
        O().k();
        return;
    }

    @Override // h7.c
    public void t() {
    }

    @Override // java.util.Observer
    public void update(Observable r10, Object r11) {
        if (isAdded() == false) goto L6;
        kotlinx.coroutines.h.d(androidx.lifecycle.s.a(this), null, null, new AnonymousClass1(this, null), 3, null);
        return;
    }
}
