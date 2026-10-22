package com.bytedanceos.appstore.buss.fragment;

import android.os.Bundle;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedanceos.appstore.buss.adapter.app.pager.adapter.TopicAdapter;
import com.bytedanceos.appstore.buss.entity.CommonAppEntity;
import com.bytedanceos.appstore.buss.entity.TopicWrap;
import com.bytedanceos.appstore.buss.viewmodels.TopicViewModel;
import com.bytedanceos.common.BaseApplication;
import com.bytedanceos.common.toolbox.ServerElements;
import com.obric.appstore.R;
import com.obric.oui.titlebar.OCTitleBar;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;
import kotlin.Lazy;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Ref$IntRef;
import kotlin.jvm.internal.SourceDebugExtension;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 62\u00020\u00012\u00020\u0002:\u0001<B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0005H\u0014¢\u0006\u0004\b\u0006\u0010\u0004J\u000f\u0010\u0007\u001a\u00020\u0005H\u0014¢\u0006\u0004\b\u0007\u0010\u0004J\u000f\u0010\b\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\b\u0010\u0004J\u000f\u0010\t\u001a\u00020\u0005H\u0014¢\u0006\u0004\b\t\u0010\u0004J#\u0010\u000e\u001a\u00020\u00052\b\u0010\u000b\u001a\u0004\u0018\u00010\n2\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0010\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0010\u0010\u0004R\u001d\u0010\u0016\u001a\u0004\u0018\u00010\u00118BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u001b\u0010\u0019\u001a\u00020\u00118BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0017\u0010\u0013\u001a\u0004\b\u0018\u0010\u0015R\u001b\u0010\u001e\u001a\u00020\u001a8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001b\u0010\u0013\u001a\u0004\b\u001c\u0010\u001dR\u0018\u0010\"\u001a\u0004\u0018\u00010\u001f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b \u0010!R\u0018\u0010&\u001a\u0004\u0018\u00010#8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b$\u0010%R\u0016\u0010*\u001a\u00020'8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b(\u0010)R\u0016\u0010,\u001a\u00020'8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b+\u0010)R\u001b\u00101\u001a\u00020-8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b.\u0010\u0013\u001a\u0004\b/\u00100R\u0014\u00105\u001a\u0002028BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b3\u00104R\u0014\u00108\u001a\u00020'8TX\u0094\u0004¢\u0006\u0006\u001a\u0004\b6\u00107R\u001c\u0010;\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u0001098TX\u0094\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010:¨\u0006="}, d2 = {"Lcom/bytedanceos/appstore/buss/fragment/TopicFragment;", "Lh7/c;", "Ljava/util/Observer;", "<init>", "()V", "", "E", "initData", "F", "t", "Ljava/util/Observable;", "o", "", "arg", "update", "(Ljava/util/Observable;Ljava/lang/Object;)V", "onDestroyView", "", "f", "Lkotlin/Lazy;", "N", "()Ljava/lang/String;", "title", "g", "O", "topicId", "", "h", "M", "()Z", "showHomeAsUp", "Lcom/obric/oui/titlebar/OCTitleBar;", "i", "Lcom/obric/oui/titlebar/OCTitleBar;", "toolbar", "Lcom/bytedanceos/appstore/buss/adapter/app/pager/adapter/TopicAdapter;", "j", "Lcom/bytedanceos/appstore/buss/adapter/app/pager/adapter/TopicAdapter;", "adapter", "", "k", "I", "defaultSpanCount", "l", "currentSpanCount", "Lcom/bytedanceos/appstore/buss/viewmodels/TopicViewModel;", "m", "P", "()Lcom/bytedanceos/appstore/buss/viewmodels/TopicViewModel;", "viewModel", "Lx7/d;", "L", "()Lx7/d;", "commonRecyclerViewBinding", "n", "()I", "layoutId", "Lkotlin/Function0;", "()Lkotlin/jvm/functions/Function0;", "onRetryListener", "a", "app_sysapp_updateRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nTopicFragment.kt\nKotlin\n*S Kotlin\n*F\n+ 1 TopicFragment.kt\ncom/bytedanceos/appstore/buss/fragment/TopicFragment\n+ 2 FragmentViewModelLazy.kt\nandroidx/fragment/app/FragmentViewModelLazyKt\n+ 3 NetSource.kt\ncom/bytedanceos/appstore/buss/network/NetSourceKt\n*L\n1#1,170:1\n106#2,15:171\n50#3,9:186\n*S KotlinDebug\n*F\n+ 1 TopicFragment.kt\ncom/bytedanceos/appstore/buss/fragment/TopicFragment\n*L\n66#1:171,15\n75#1:186,9\n*E\n"})
public final class TopicFragment extends h7.c implements Observer {

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final a f8659n = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Lazy f8660f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Lazy f8661g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Lazy f8662h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public OCTitleBar f8663i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public TopicAdapter f8664j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f8665k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f8666l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final Lazy f8667m;

    public static final class a {
        public /* synthetic */ a(DefaultConstructorMarker r10) {
            this();
        }

        public static /* synthetic */ Fragment b(a r10, String r11, String r12, boolean r13, int r14, Object r15) {
            if ((r14 & 4) == 0) goto L6;
            r13 = true;
        L6:
            return r10.a(r11, r12, r13);
        }

        public final Fragment a(String r10, String r11, boolean r12) {
            kotlin.jvm.internal.q.g(r11, "topicId");
            TopicFragment r13 = new TopicFragment();
            r13.setArguments(androidx.core.os.c.a(new Pair[]{kotlin.d.a("title", r10), kotlin.d.a("topicId", r11), kotlin.d.a("showHomeAsUp", Boolean.valueOf(r12))}));
            return r13;
        }

        public a() {
        }
    }

    public static final class b extends GridLayoutManager.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ TopicFragment f8668a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Ref$IntRef f8669b;

        public b(TopicFragment r10, Ref$IntRef r11) {
            this.f8668a = r10;
            this.f8669b = r11;
        }

        @Override // androidx.recyclerview.widget.GridLayoutManager.b
        public int getSpanSize(int r10) {
            TopicAdapter r11 = TopicFragment.I(this.f8668a);
            String r12 = null;
            if (r11 == null) goto L7;
            List<CommonAppEntity> r13 = r11.getData();
            if (r13 == null) goto L7;
            CommonAppEntity r14 = r13.get(r10);
        L8:
            if (r14 == null) goto L10;
            r12 = r14.getPkg();
        L10:
            if (r12 == null) goto L16;
            if (kotlin.text.o.r(r12) == true) goto L16;
            return 1;
        L16:
            return this.f8669b.element;
        L7:
            r14 = null;
            goto L8
        }
    }

    public static final class c extends GridLayoutManager.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ TopicFragment f8670a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Ref$IntRef f8671b;

        public c(TopicFragment r10, Ref$IntRef r11) {
            this.f8670a = r10;
            this.f8671b = r11;
        }

        @Override // androidx.recyclerview.widget.GridLayoutManager.b
        public int getSpanSize(int r10) {
            TopicAdapter r11 = TopicFragment.I(this.f8670a);
            String r12 = null;
            if (r11 == null) goto L7;
            List<CommonAppEntity> r13 = r11.getData();
            if (r13 == null) goto L7;
            CommonAppEntity r14 = r13.get(r10);
        L8:
            if (r14 == null) goto L10;
            r12 = r14.getPkg();
        L10:
            if (r12 == null) goto L16;
            if (kotlin.text.o.r(r12) == true) goto L16;
            return 1;
        L16:
            return this.f8671b.element;
        L7:
            r14 = null;
            goto L8
        }
    }

    static {
        f8659n = new a(null);
    }

    public TopicFragment() {
        this.f8660f = kotlin.b.b(new TopicFragment$title$2(this));
        this.f8661g = kotlin.b.b(new TopicFragment$topicId$2(this));
        this.f8662h = kotlin.b.b(new TopicFragment$showHomeAsUp$2(this));
        this.f8665k = 2;
        this.f8666l = 1;
        Function0<ViewModelProvider.Factory> r10 = new TopicFragment$viewModel$2(this);
        final Function0<Fragment> r11 = new TopicFragment$special$$inlined$viewModels$default$1(this);
        final Lazy r12 = kotlin.b.a(LazyThreadSafetyMode.NONE, new TopicFragment$special$$inlined$viewModels$default$2(r11));
        final Function0 r13 = null;
        this.f8667m = FragmentViewModelLazyKt.c(this, kotlin.jvm.internal.u.b(TopicViewModel.class), new TopicFragment$special$$inlined$viewModels$default$3(r12), new TopicFragment$special$$inlined$viewModels$default$4(r13, r12), r10);
    }

    public static /* synthetic */ void G(TopicFragment r10, com.bytedanceos.appstore.buss.network.h r11) {
        Q(r10, r11);
    }

    public static /* synthetic */ void H(TopicFragment r10) {
        R(r10);
    }

    public static final /* synthetic */ TopicAdapter I(TopicFragment r10) {
        return r10.f8664j;
    }

    public static final /* synthetic */ String J(TopicFragment r10) {
        return r10.O();
    }

    public static final /* synthetic */ TopicViewModel K(TopicFragment r10) {
        return r10.P();
    }

    private final x7.d L() {
        x7.d r10 = x7.d.a(m().findViewById(R.id.recycler_view));
        kotlin.jvm.internal.q.f(r10, "bind(...)");
        return r10;
    }

    private final boolean M() {
        return ((Boolean) this.f8662h.getValue()).booleanValue();
    }

    private final String N() {
        return (String) this.f8660f.getValue();
    }

    public static final void Q(TopicFragment r10, com.bytedanceos.appstore.buss.network.h r11) {
        kotlin.jvm.internal.q.g(r10, "this$0");
        kotlin.jvm.internal.q.d(r11);
        if ((r11 instanceof com.bytedanceos.appstore.buss.network.h.b) == false) goto L6;
        r10.B();
        return;
    L6:
        if ((r11 instanceof com.bytedanceos.appstore.buss.network.h.c) == false) goto L24;
        TopicWrap r12 = (TopicWrap) ((com.bytedanceos.appstore.buss.network.h.c) r11).a();
        if (r12 == null) goto L10;
        List<CommonAppEntity> r13 = r12.getApps();
    L11:
        if (r12 == null) goto L22;
        if (r13 == null) goto L22;
        if (r13.isEmpty() == true) goto L22;
        r10.r();
        OCTitleBar r14 = r10.f8663i;
        if (r14 == null) goto L19;
        r14.setCenterText(r12.getTopic().getName());
    L19:
        ArrayList r15 = new ArrayList();
        r15.add(r12.getTopic().convertTvAppEntity());
        r15.addAll(r13);
        TopicAdapter r16 = r10.f8664j;
        if (r16 == null) goto L28;
        r16.setList(r15);
        return;
    L28:
        return;
    L22:
        h7.c.A(r10, null, null, 0, 7, null);
        return;
    L10:
        r13 = null;
        goto L11
    L24:
        if ((r11 instanceof com.bytedanceos.appstore.buss.network.h.a) == false) goto L31;
        com.bytedanceos.appstore.buss.network.h.a r17 = (com.bytedanceos.appstore.buss.network.h.a) r11;
        com.bytedanceos.appstore.buss.utilities.j.f8856a.c(r17.c());
        r10.D(r17);
        return;
    }

    public static final void R(TopicFragment r10) {
        kotlin.jvm.internal.q.g(r10, "this$0");
        TopicAdapter r11 = r10.f8664j;
        if (r11 == null) goto L6;
        r11.notifyDataSetChanged();
        return;
    }

    @Override // h7.c
    public void E() {
        P().k().i(this, new l1(this));
    }

    @Override // h7.c
    public void F() {
        if (getActivity() != null) goto L5;
        return;
    L5:
        if (L().f25515b == null) goto L13;
        Ref$IntRef r10 = new Ref$IntRef();
        com.bytedanceos.appstore.buss.utilities.f r11 = com.bytedanceos.appstore.buss.utilities.f.f8838a;
        int r12 = r11.f(getActivity());
        r10.element = r12;
        if (r12 == this.f8666l) goto L12;
        RecyclerView.LayoutManager r13 = L().f25515b.getLayoutManager();
        kotlin.jvm.internal.q.e(r13, "null cannot be cast to non-null type androidx.recyclerview.widget.GridLayoutManager");
        GridLayoutManager r14 = (GridLayoutManager) r13;
        r14.Q(r10.element);
        r14.R(new c(this, r10));
        this.f8666l = r10.element;
        ViewGroup.LayoutParams r15 = L().f25515b.getLayoutParams();
        r15.width = r10.element * r11.a();
        L().f25515b.setLayoutParams(r15);
        return;
    L12:
        return;
    }

    public final String O() {
        return (String) this.f8661g.getValue();
    }

    public final TopicViewModel P() {
        return (TopicViewModel) this.f8667m.getValue();
    }

    @Override // h7.c
    public void initData() {
        BaseApplication.c().b().addObserver(this);
        this.f8663i = h7.c.w(this, N(), M(), false, 4, null);
        Ref$IntRef r10 = new Ref$IntRef();
        int r11 = com.bytedanceos.appstore.buss.utilities.f.f8838a.f(getActivity());
        r10.element = r11;
        if (r11 != 0) goto L5;
        GridLayoutManager r12 = new GridLayoutManager(l(), this.f8665k);
    L6:
        this.f8666l = r10.element;
        r12.R(new b(this, r10));
        this.f8664j = new TopicAdapter();
        L().f25515b.addItemDecoration(new u7.b(0, 1, null));
        L().f25515b.setLayoutManager(r12);
        L().f25515b.setAdapter(this.f8664j);
        Bundle r13 = new Bundle();
        r13.putString("topic_name", N());
        r13.putString(ServerElements.TOPIC_ID, O());
        f9.b.b("exposure_pages_topic", r13);
        return;
    L5:
        r12 = new GridLayoutManager(l(), r10.element);
        goto L6
    }

    @Override // h7.c
    public int n() {
        return R.layout.fragment_tv_topic;
    }

    @Override // h7.c
    public Function0 o() {
        return new TopicFragment$onRetryListener$1(this);
    }

    @Override // h7.c, androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        BaseApplication.c().b().deleteObserver(this);
        this.f8663i = null;
        this.f8664j = null;
    }

    @Override // h7.c
    public void t() {
    }

    @Override // java.util.Observer
    public void update(Observable r10, Object r11) {
        if (isAdded() == false) goto L6;
        l().runOnUiThread(new m1(this));
        return;
    }
}
