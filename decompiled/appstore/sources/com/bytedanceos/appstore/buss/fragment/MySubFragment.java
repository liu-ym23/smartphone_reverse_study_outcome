package com.bytedanceos.appstore.buss.fragment;

import android.os.Bundle;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.apm.constant.TraceStatsConsts;
import com.bytedanceos.appstore.buss.adapter.BinderAdapter;
import com.bytedanceos.appstore.buss.entity.AppSubEntity;
import com.bytedanceos.appstore.buss.viewmodels.MySubViewModel;
import com.obric.appstore.R;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Ref$IntRef;
import kotlin.jvm.internal.SourceDebugExtension;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 -2\u00020\u0001:\u0001.B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0005\u001a\u00020\u0004H\u0014¢\u0006\u0004\b\u0005\u0010\u0003J\u000f\u0010\u0006\u001a\u00020\u0004H\u0014¢\u0006\u0004\b\u0006\u0010\u0003J\u000f\u0010\u0007\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\u0003J\u000f\u0010\b\u001a\u00020\u0004H\u0014¢\u0006\u0004\b\b\u0010\u0003J\u000f\u0010\t\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\t\u0010\u0003R\u0018\u0010\r\u001a\u0004\u0018\u00010\n8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0016\u0010\u0011\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0015\u001a\u00020\u00128\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0016\u0010\u0017\u001a\u00020\u00128\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0016\u0010\u0014R\u001b\u0010\u001d\u001a\u00020\u00188BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001cR\u0014\u0010!\u001a\u00020\u001e8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u001f\u0010 R\u0014\u0010$\u001a\u00020\u00128TX\u0094\u0004¢\u0006\u0006\u001a\u0004\b\"\u0010#R\u001c\u0010(\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010%8TX\u0094\u0004¢\u0006\u0006\u001a\u0004\b&\u0010'R\u0014\u0010,\u001a\u00020)8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b*\u0010+¨\u0006/"}, d2 = {"Lcom/bytedanceos/appstore/buss/fragment/MySubFragment;", "Lh7/c;", "<init>", "()V", "", "E", "initData", "F", "t", "onDestroyView", "Lcom/bytedanceos/appstore/buss/adapter/BinderAdapter;", "f", "Lcom/bytedanceos/appstore/buss/adapter/BinderAdapter;", "adapter", "", "g", "Z", "isShowHeader", "", "h", "I", "defaultSpanCount", "i", "currentSpanCount", "Lcom/bytedanceos/appstore/buss/viewmodels/MySubViewModel;", "j", "Lkotlin/Lazy;", "L", "()Lcom/bytedanceos/appstore/buss/viewmodels/MySubViewModel;", "mySubViewModel", "Lx7/d;", "J", "()Lx7/d;", "commonRecyclerViewBinding", "n", "()I", "layoutId", "Lkotlin/Function0;", "o", "()Lkotlin/jvm/functions/Function0;", "onRetryListener", "Lx7/z;", "K", "()Lx7/z;", "fragmentTvSubMyBinding", "k", "a", "app_sysapp_updateRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nMySubFragment.kt\nKotlin\n*S Kotlin\n*F\n+ 1 MySubFragment.kt\ncom/bytedanceos/appstore/buss/fragment/MySubFragment\n+ 2 FragmentViewModelLazy.kt\nandroidx/fragment/app/FragmentViewModelLazyKt\n+ 3 BaseBinderAdapter.kt\ncom/chad/library/adapter/base/BaseBinderAdapter\n+ 4 NetSource.kt\ncom/bytedanceos/appstore/buss/network/NetSourceKt\n+ 5 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,166:1\n106#2,15:167\n57#3,3:182\n57#3,3:185\n50#4,3:188\n53#4,6:193\n1855#5,2:191\n*S KotlinDebug\n*F\n+ 1 MySubFragment.kt\ncom/bytedanceos/appstore/buss/fragment/MySubFragment\n*L\n54#1:167,15\n116#1:182,3\n119#1:185,3\n61#1:188,3\n61#1:193,6\n70#1:191,2\n*E\n"})
public final class MySubFragment extends h7.c {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final a f8605k = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public BinderAdapter f8606f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f8607g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f8608h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f8609i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Lazy f8610j;

    public static final class a {
        public /* synthetic */ a(DefaultConstructorMarker r10) {
            this();
        }

        public final Fragment a() {
            return new MySubFragment();
        }

        public a() {
        }
    }

    public static final class b extends GridLayoutManager.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ MySubFragment f8611a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Ref$IntRef f8612b;

        public b(MySubFragment r10, Ref$IntRef r11) {
            this.f8611a = r10;
            this.f8612b = r11;
        }

        @Override // androidx.recyclerview.widget.GridLayoutManager.b
        public int getSpanSize(int r10) {
            BinderAdapter r11 = MySubFragment.H(this.f8611a);
            if (r11 == null) goto L5;
            Object r12 = r11.getItemOrNull(r10);
        L7:
            if ((r12 instanceof String) == false) goto L13;
            int r13 = this.f8612b.element;
            if (r13 != 0) goto L12;
            return 1;
        L12:
            return r13;
        L13:
            return 1;
        L5:
            r12 = null;
            goto L7
        }
    }

    public static final class c extends GridLayoutManager.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ MySubFragment f8613a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Ref$IntRef f8614b;

        public c(MySubFragment r10, Ref$IntRef r11) {
            this.f8613a = r10;
            this.f8614b = r11;
        }

        @Override // androidx.recyclerview.widget.GridLayoutManager.b
        public int getSpanSize(int r10) {
            BinderAdapter r11 = MySubFragment.H(this.f8613a);
            if (r11 == null) goto L5;
            Object r12 = r11.getItemOrNull(r10);
        L7:
            if ((r12 instanceof String) == false) goto L13;
            int r13 = this.f8614b.element;
            if (r13 != 0) goto L12;
            return 1;
        L12:
            return r13;
        L13:
            return 1;
        L5:
            r12 = null;
            goto L7
        }
    }

    static {
        f8605k = new a(null);
    }

    public MySubFragment() {
        this.f8607g = true;
        this.f8608h = 1;
        this.f8609i = 1;
        final Function0<Fragment> r10 = new MySubFragment$special$$inlined$viewModels$default$1(this);
        final Lazy r11 = kotlin.b.a(LazyThreadSafetyMode.NONE, new MySubFragment$special$$inlined$viewModels$default$2(r10));
        final Function0 r12 = null;
        this.f8610j = FragmentViewModelLazyKt.c(this, kotlin.jvm.internal.u.b(MySubViewModel.class), new MySubFragment$special$$inlined$viewModels$default$3(r11), new MySubFragment$special$$inlined$viewModels$default$4(r12, r11), new MySubFragment$special$$inlined$viewModels$default$5(this, r11));
    }

    public static /* synthetic */ void G(MySubFragment r10, com.bytedanceos.appstore.buss.network.h r11) {
        M(r10, r11);
    }

    public static final /* synthetic */ BinderAdapter H(MySubFragment r10) {
        return r10.f8606f;
    }

    public static final /* synthetic */ MySubViewModel I(MySubFragment r10) {
        return r10.L();
    }

    private final x7.d J() {
        x7.d r10 = x7.d.a(m().findViewById(R.id.recycler_view));
        kotlin.jvm.internal.q.f(r10, "bind(...)");
        return r10;
    }

    public static final void M(MySubFragment r10, com.bytedanceos.appstore.buss.network.h r11) {
        kotlin.jvm.internal.q.g(r10, "this$0");
        kotlin.jvm.internal.q.d(r11);
        if ((r11 instanceof com.bytedanceos.appstore.buss.network.h.b) == false) goto L6;
        return;
    L6:
        if ((r11 instanceof com.bytedanceos.appstore.buss.network.h.c) == false) goto L29;
        List r12 = (List) ((com.bytedanceos.appstore.buss.network.h.c) r11).a();
        if (r12 != null) goto L10;
    L27:
        String r13 = r10.getString(R.string.no_reserved_game);
        kotlin.jvm.internal.q.f(r13, "getString(...)");
        h7.c.A(r10, r13, null, R.drawable.game_reserved_empty, 2, null);
        return;
    L10:
        if (r12.isEmpty() == true) goto L27;
        r10.r();
        r10.f8607g = true;
        Iterator r14 = r12.iterator();
    L14:
        if (r14.hasNext() == false) goto L21;
        Object r15 = r14.next();
        if ((r15 instanceof AppSubEntity) == false) goto L14;
        if (((AppSubEntity) r15).getStatus() != 1) goto L14;
        r10.f8607g = false;
        goto L14
    L21:
        if (r10.f8607g == false) goto L23;
        r10.K().f25818b.setVisibility(0);
    L24:
        BinderAdapter r16 = r10.f8606f;
        if (r16 == null) goto L39;
        r16.setList(r12);
        return;
    L39:
        return;
    L23:
        r10.K().f25818b.setVisibility(8);
        goto L24
    L29:
        if ((r11 instanceof com.bytedanceos.appstore.buss.network.h.a) == false) goto L42;
        com.bytedanceos.appstore.buss.network.h.a r17 = (com.bytedanceos.appstore.buss.network.h.a) r11;
        com.bytedanceos.appstore.buss.utilities.j.f8856a.c(r17.c());
        r10.r();
        com.bytedanceos.appstore.buss.utilities.s.e(r10, r17.c());
        return;
    }

    @Override // h7.c
    public void E() {
        L().g().i(this, new t0(this));
    }

    @Override // h7.c
    public void F() {
        if (getActivity() != null) goto L5;
        return;
    L5:
        L().f();
        Ref$IntRef r10 = new Ref$IntRef();
        com.bytedanceos.appstore.buss.utilities.f r11 = com.bytedanceos.appstore.buss.utilities.f.f8838a;
        int r12 = r11.f(getActivity());
        r10.element = r12;
        if (r12 == this.f8609i) goto L9;
        RecyclerView.LayoutManager r13 = J().f25515b.getLayoutManager();
        kotlin.jvm.internal.q.e(r13, "null cannot be cast to non-null type androidx.recyclerview.widget.GridLayoutManager");
        GridLayoutManager r14 = (GridLayoutManager) r13;
        r14.Q(r10.element);
        r14.R(new c(this, r10));
        this.f8609i = r10.element;
        ViewGroup.LayoutParams r15 = J().f25515b.getLayoutParams();
        r15.width = r10.element * r11.a();
        J().f25515b.setLayoutParams(r15);
        return;
    }

    public final x7.z K() {
        x7.z r10 = x7.z.a(m());
        kotlin.jvm.internal.q.f(r10, "bind(...)");
        return r10;
    }

    public final MySubViewModel L() {
        return (MySubViewModel) this.f8610j.getValue();
    }

    @Override // h7.c
    public void initData() {
        h7.c.w(this, "已预约的游戏", true, false, 4, null);
        Ref$IntRef r10 = new Ref$IntRef();
        int r11 = com.bytedanceos.appstore.buss.utilities.f.f8838a.f(getActivity());
        r10.element = r11;
        if (r11 != 0) goto L5;
        GridLayoutManager r12 = new GridLayoutManager(l(), this.f8608h);
    L6:
        this.f8609i = r10.element;
        r12.R(new b(this, r10));
        J().f25515b.addItemDecoration(new u7.b(0, 1, null));
        BinderAdapter r13 = new BinderAdapter();
        d7.h r14 = new d7.h();
        r14.c("page_my_subscribed");
        r13.addItemBinder(AppSubEntity.class, r14, null);
        r13.addItemBinder(String.class, new d7.j(), null);
        this.f8606f = r13;
        J().f25515b.setLayoutManager(r12);
        J().f25515b.setAdapter(this.f8606f);
        Bundle r15 = new Bundle();
        r15.putString(TraceStatsConsts.PAGE_STATS_KEY_PAGE_NAME, "page_my_subscribed");
        f9.b.b("exposure_pages_main", r15);
        return;
    L5:
        r12 = new GridLayoutManager(l(), r10.element);
        goto L6
    }

    @Override // h7.c
    public int n() {
        return R.layout.fragment_tv_sub_my;
    }

    @Override // h7.c
    public Function0 o() {
        return new MySubFragment$onRetryListener$1(this);
    }

    @Override // h7.c, androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        L().h(this);
        this.f8606f = null;
    }

    @Override // h7.c
    public void t() {
    }
}
