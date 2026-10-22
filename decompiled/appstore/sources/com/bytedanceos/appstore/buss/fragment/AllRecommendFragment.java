package com.bytedanceos.appstore.buss.fragment;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.bytedance.apm.constant.TraceStatsConsts;
import com.bytedanceos.appstore.buss.adapter.app.pager.adapter.AllRecommendAdapter;
import com.bytedanceos.appstore.buss.entity.AppEntityWrap;
import com.bytedanceos.appstore.buss.entity.CommonAppEntity;
import com.bytedanceos.appstore.buss.entity.NewRecommendWrap;
import com.bytedanceos.appstore.buss.viewmodels.AllRecommendViewModel;
import com.bytedanceos.common.networkv2.params.NetKey;
import com.obric.appstore.R;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.SourceDebugExtension;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 .2\u00020\u0001:\u0001/B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0005\u001a\u00020\u0004H\u0014¢\u0006\u0004\b\u0005\u0010\u0003J\u000f\u0010\u0006\u001a\u00020\u0004H\u0014¢\u0006\u0004\b\u0006\u0010\u0003J\u000f\u0010\u0007\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\u0003J\u000f\u0010\b\u001a\u00020\u0004H\u0014¢\u0006\u0004\b\b\u0010\u0003J\u000f\u0010\t\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\t\u0010\u0003R\u0014\u0010\r\u001a\u00020\n8\u0002X\u0082D¢\u0006\u0006\n\u0004\b\u000b\u0010\fR\u001d\u0010\u0013\u001a\u0004\u0018\u00010\u000e8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u001b\u0010\u0017\u001a\u00020\n8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0014\u0010\u0010\u001a\u0004\b\u0015\u0010\u0016R\u001d\u0010\u001a\u001a\u0004\u0018\u00010\u000e8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0018\u0010\u0010\u001a\u0004\b\u0019\u0010\u0012R\u001b\u0010\u001f\u001a\u00020\u001b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001c\u0010\u0010\u001a\u0004\b\u001d\u0010\u001eR\u0018\u0010#\u001a\u0004\u0018\u00010 8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b!\u0010\"R\u0014\u0010%\u001a\u00020\n8TX\u0094\u0004¢\u0006\u0006\u001a\u0004\b$\u0010\u0016R\u001c\u0010)\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010&8TX\u0094\u0004¢\u0006\u0006\u001a\u0004\b'\u0010(R\u0014\u0010-\u001a\u00020*8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b+\u0010,¨\u00060"}, d2 = {"Lcom/bytedanceos/appstore/buss/fragment/AllRecommendFragment;", "Lh7/c;", "<init>", "()V", "", "E", "initData", "F", "t", "onDestroyView", "", "f", "I", "cacheSize", "", "g", "Lkotlin/Lazy;", "M", "()Ljava/lang/String;", "title", "h", "L", "()I", "source", "i", "getPageSource", "pageSource", "Lcom/bytedanceos/appstore/buss/viewmodels/AllRecommendViewModel;", "j", "J", "()Lcom/bytedanceos/appstore/buss/viewmodels/AllRecommendViewModel;", "allRecommendViewModel", "Lcom/bytedanceos/appstore/buss/adapter/app/pager/adapter/AllRecommendAdapter;", "k", "Lcom/bytedanceos/appstore/buss/adapter/app/pager/adapter/AllRecommendAdapter;", "adapter", "n", "layoutId", "Lkotlin/Function0;", "o", "()Lkotlin/jvm/functions/Function0;", "onRetryListener", "Lx7/d;", "K", "()Lx7/d;", "commonRecyclerViewBinding", "l", "a", "app_sysapp_updateRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nAllRecommendFragment.kt\nKotlin\n*S Kotlin\n*F\n+ 1 AllRecommendFragment.kt\ncom/bytedanceos/appstore/buss/fragment/AllRecommendFragment\n+ 2 FragmentViewModelLazy.kt\nandroidx/fragment/app/FragmentViewModelLazyKt\n+ 3 NetSource.kt\ncom/bytedanceos/appstore/buss/network/NetSourceKt\n+ 4 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 5 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,124:1\n106#2,15:125\n50#3,3:140\n53#3,6:152\n1#4:143\n1855#5,2:144\n1855#5,2:146\n1855#5,2:148\n1002#5,2:150\n*S KotlinDebug\n*F\n+ 1 AllRecommendFragment.kt\ncom/bytedanceos/appstore/buss/fragment/AllRecommendFragment\n*L\n57#1:125,15\n66#1:140,3\n66#1:152,6\n73#1:144,2\n80#1:146,2\n84#1:148,2\n87#1:150,2\n*E\n"})
public final class AllRecommendFragment extends h7.c {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final a f8437l = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f8438f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Lazy f8439g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Lazy f8440h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Lazy f8441i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Lazy f8442j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public AllRecommendAdapter f8443k;

    public static final class a {
        public /* synthetic */ a(DefaultConstructorMarker r10) {
            this();
        }

        public final Fragment a(String r10, int r11, String r12) {
            AllRecommendFragment r13 = new AllRecommendFragment();
            r13.setArguments(androidx.core.os.c.a(new Pair[]{kotlin.d.a("title", r10), kotlin.d.a("source", Integer.valueOf(r11)), kotlin.d.a(NetKey.PAGE_SOURCE, r12)}));
            return r13;
        }

        public a() {
        }
    }

    public static final class b implements Comparator {
        public b() {
        }

        @Override // java.util.Comparator
        public final int compare(Object r10, Object r11) {
            return sf.a.a(Integer.valueOf(((AppEntityWrap) r10).getPos()), Integer.valueOf(((AppEntityWrap) r11).getPos()));
        }
    }

    static {
        f8437l = new a(null);
    }

    public AllRecommendFragment() {
        this.f8438f = 20;
        this.f8439g = kotlin.b.b(new AllRecommendFragment$title$2(this));
        this.f8440h = kotlin.b.b(new AllRecommendFragment$source$2(this));
        this.f8441i = kotlin.b.b(new AllRecommendFragment$pageSource$2(this));
        Function0<ViewModelProvider.Factory> r10 = new AllRecommendFragment$allRecommendViewModel$2(this);
        final Function0<Fragment> r11 = new AllRecommendFragment$special$$inlined$viewModels$default$1(this);
        final Lazy r12 = kotlin.b.a(LazyThreadSafetyMode.NONE, new AllRecommendFragment$special$$inlined$viewModels$default$2(r11));
        final Function0 r13 = null;
        this.f8442j = FragmentViewModelLazyKt.c(this, kotlin.jvm.internal.u.b(AllRecommendViewModel.class), new AllRecommendFragment$special$$inlined$viewModels$default$3(r12), new AllRecommendFragment$special$$inlined$viewModels$default$4(r13, r12), r10);
    }

    public static /* synthetic */ void G(AllRecommendFragment r10, com.bytedanceos.appstore.buss.network.h r11) {
        N(r10, r11);
    }

    public static final /* synthetic */ AllRecommendViewModel H(AllRecommendFragment r10) {
        return r10.J();
    }

    public static final /* synthetic */ int I(AllRecommendFragment r10) {
        return r10.L();
    }

    private final String M() {
        return (String) this.f8439g.getValue();
    }

    public static final void N(AllRecommendFragment r10, com.bytedanceos.appstore.buss.network.h r11) {
        kotlin.jvm.internal.q.g(r10, "this$0");
        kotlin.jvm.internal.q.d(r11);
        if ((r11 instanceof com.bytedanceos.appstore.buss.network.h.b) == false) goto L6;
        r10.B();
        return;
    L6:
        if ((r11 instanceof com.bytedanceos.appstore.buss.network.h.c) == false) goto L55;
        r10.r();
        List r12 = (List) ((com.bytedanceos.appstore.buss.network.h.c) r11).a();
        if (r12 == null) goto L10;
        NewRecommendWrap r13 = com.bytedanceos.appstore.buss.utilities.k.a(r12);
    L11:
        ArrayList r14 = new ArrayList();
        if (r13 == null) goto L16;
        AppEntityWrap r15 = r13.getTopics();
        if (r15 == null) goto L16;
        r14.add(r15);
    L16:
        if (r13 == null) goto L34;
        List<AppEntityWrap> r16 = r13.getHorizontals();
        if (r16 == null) goto L34;
        Iterator<T> r17 = r16.iterator();
    L21:
        if (r17.hasNext() == false) goto L34;
        AppEntityWrap r18 = (AppEntityWrap) r17.next();
        List<CommonAppEntity> r19 = r18.getApps();
        if (r19 == null) goto L25;
        Integer r20 = Integer.valueOf(r19.size());
    L26:
        kotlin.jvm.internal.q.d(r20);
        if (r20.intValue() <= 15) goto L33;
        List<CommonAppEntity> r21 = r18.getApps();
        if (r21 == null) goto L31;
        List<CommonAppEntity> r22 = r21.subList(0, 15);
    L32:
        r18.setApps(r22);
        goto L33
    L31:
        r22 = null;
    L33:
        com.bytedanceos.common.utils.h.i(r18.getApps());
        r14.add(r18);
        goto L21
    L25:
        r20 = null;
    L34:
        if (r13 == null) goto L41;
        List<AppEntityWrap> r23 = r13.getVerticals();
        if (r23 == null) goto L41;
        Iterator<T> r24 = r23.iterator();
    L39:
        if (r24.hasNext() == false) goto L41;
        AppEntityWrap r25 = (AppEntityWrap) r24.next();
        com.bytedanceos.common.utils.h.i(r25.getApps());
        r14.add(r25);
    L41:
        if (r13 == null) goto L49;
        List<AppEntityWrap> r26 = r13.getBanners();
        if (r26 == null) goto L49;
        Iterator<T> r27 = r26.iterator();
    L46:
        if (r27.hasNext() == false) goto L49;
        r14.add((AppEntityWrap) r27.next());
    L49:
        if (r14.size() <= 1) goto L51;
        kotlin.collections.x.u(r14, new b());
    L51:
        AllRecommendAdapter r28 = r10.f8443k;
        if (r28 == null) goto L64;
        r28.setList(r14);
        return;
    L64:
        return;
    L10:
        r13 = null;
        goto L11
    L55:
        if ((r11 instanceof com.bytedanceos.appstore.buss.network.h.a) == false) goto L66;
        com.bytedanceos.appstore.buss.network.h.a r29 = (com.bytedanceos.appstore.buss.network.h.a) r11;
        com.bytedanceos.appstore.buss.utilities.j.f8856a.c(r29.c());
        r10.D(r29);
        return;
    }

    private final String getPageSource() {
        return (String) this.f8441i.getValue();
    }

    @Override // h7.c
    public void E() {
        J().h().i(this, new com.bytedanceos.appstore.buss.fragment.a(this));
    }

    @Override // h7.c
    public void F() {
    }

    public final AllRecommendViewModel J() {
        return (AllRecommendViewModel) this.f8442j.getValue();
    }

    public final x7.d K() {
        x7.d r10 = x7.d.a(m());
        kotlin.jvm.internal.q.f(r10, "bind(...)");
        return r10;
    }

    public final int L() {
        return ((Number) this.f8440h.getValue()).intValue();
    }

    @Override // h7.c
    public void initData() {
        h7.c.w(this, M(), false, false, 6, null);
        this.f8443k = new AllRecommendAdapter(getPageSource());
        K().f25515b.setLayoutManager(new LinearLayoutManager(l()));
        K().f25515b.setAdapter(this.f8443k);
        K().f25515b.setPageSource(getPageSource());
        K().f25515b.setItemViewCacheSize(this.f8438f);
        Bundle r10 = new Bundle();
        r10.putString(TraceStatsConsts.PAGE_STATS_KEY_PAGE_NAME, getPageSource());
        f9.b.b("exposure_pages_main", r10);
    }

    @Override // h7.c
    public int n() {
        return R.layout.common_recycler_view;
    }

    @Override // h7.c
    public Function0 o() {
        return new AllRecommendFragment$onRetryListener$1(this);
    }

    @Override // h7.c, androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        this.f8443k = null;
    }

    @Override // h7.c
    public void t() {
        r();
    }
}
