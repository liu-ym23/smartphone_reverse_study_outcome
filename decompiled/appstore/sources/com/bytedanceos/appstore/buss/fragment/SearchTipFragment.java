package com.bytedanceos.appstore.buss.fragment;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.bytedance.apm.constant.TraceStatsConsts;
import com.bytedanceos.appstore.buss.adapter.BinderAdapter;
import com.bytedanceos.appstore.buss.entity.AppSubEntity;
import com.bytedanceos.appstore.buss.entity.CommonAppEntity;
import com.bytedanceos.appstore.buss.entity.SearchAssociateEntityWrap;
import com.bytedanceos.appstore.buss.viewmodels.MainViewModel;
import com.bytedanceos.appstore.buss.viewmodels.SearchViewModel;
import com.obric.appstore.R;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.SourceDebugExtension;
import org.greenrobot.eventbus.EventBus;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0005\u001a\u00020\u0004H\u0014¢\u0006\u0004\b\u0005\u0010\u0003J\u000f\u0010\u0006\u001a\u00020\u0004H\u0014¢\u0006\u0004\b\u0006\u0010\u0003J\u000f\u0010\u0007\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\u0003J\u000f\u0010\b\u001a\u00020\u0004H\u0014¢\u0006\u0004\b\b\u0010\u0003J\u000f\u0010\t\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\t\u0010\u0003R\u001b\u0010\u000f\u001a\u00020\n8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR\u001b\u0010\u0014\u001a\u00020\u00108BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0011\u0010\f\u001a\u0004\b\u0012\u0010\u0013R\u0018\u0010\u0018\u001a\u0004\u0018\u00010\u00158\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0018\u0010\u001c\u001a\u0004\u0018\u00010\u00198\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0016\u0010 \u001a\u00020\u001d8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0014\u0010$\u001a\u00020!8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\"\u0010#R\u0014\u0010(\u001a\u00020%8TX\u0094\u0004¢\u0006\u0006\u001a\u0004\b&\u0010'R\u0014\u0010,\u001a\u00020)8TX\u0094\u0004¢\u0006\u0006\u001a\u0004\b*\u0010+R\u001c\u00100\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010-8TX\u0094\u0004¢\u0006\u0006\u001a\u0004\b.\u0010/¨\u00061"}, d2 = {"Lcom/bytedanceos/appstore/buss/fragment/SearchTipFragment;", "Lh7/c;", "<init>", "()V", "", "E", "initData", "F", "t", "onDestroyView", "Lcom/bytedanceos/appstore/buss/viewmodels/MainViewModel;", "f", "Lkotlin/Lazy;", "J", "()Lcom/bytedanceos/appstore/buss/viewmodels/MainViewModel;", "mainViewModel", "Lcom/bytedanceos/appstore/buss/viewmodels/SearchViewModel;", "g", "K", "()Lcom/bytedanceos/appstore/buss/viewmodels/SearchViewModel;", "searchViewModel", "", "h", "Ljava/lang/String;", "searchKey", "Lcom/bytedanceos/appstore/buss/adapter/BinderAdapter;", "i", "Lcom/bytedanceos/appstore/buss/adapter/BinderAdapter;", "adapter", "Ld7/c;", "j", "Ld7/c;", "itemHorizontalBinder", "Lx7/d;", "I", "()Lx7/d;", "commonRecyclerViewBinding", "", "q", "()Z", "showHeader", "", "n", "()I", "layoutId", "Lkotlin/Function0;", "o", "()Lkotlin/jvm/functions/Function0;", "onRetryListener", "app_sysapp_updateRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nSearchTipFragment.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SearchTipFragment.kt\ncom/bytedanceos/appstore/buss/fragment/SearchTipFragment\n+ 2 FragmentViewModelLazy.kt\nandroidx/fragment/app/FragmentViewModelLazyKt\n+ 3 BaseBinderAdapter.kt\ncom/chad/library/adapter/base/BaseBinderAdapter\n+ 4 NetSource.kt\ncom/bytedanceos/appstore/buss/network/NetSourceKt\n+ 5 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,163:1\n172#2,9:164\n106#2,15:173\n57#3,3:188\n57#3,3:191\n57#3,3:194\n50#4,3:197\n53#4,6:203\n1864#5,3:200\n*S KotlinDebug\n*F\n+ 1 SearchTipFragment.kt\ncom/bytedanceos/appstore/buss/fragment/SearchTipFragment\n*L\n40#1:164,9\n41#1:173,15\n122#1:188,3\n123#1:191,3\n133#1:194,3\n63#1:197,3\n63#1:203,6\n79#1:200,3\n*E\n"})
public final class SearchTipFragment extends h7.c {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Lazy f8644f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Lazy f8645g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public String f8646h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public BinderAdapter f8647i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public d7.c f8648j;

    public static final class a implements Function2 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ d7.g f8649a;

        public a(d7.g r10) {
            this.f8649a = r10;
        }

        public void a(View r10, String r11) {
            kotlin.jvm.internal.q.g(r10, "view");
            kotlin.jvm.internal.q.g(r11, "str");
            Bundle r12 = new Bundle();
            r12.putString("search_keyword_position", String.valueOf(this.f8649a.getAdapter().getItemPosition(r11) + 1));
            f9.b.b("click_search_keywords", r12);
            EventBus.getDefault().post(new c7.b(r11));
        }

        @Override // kotlin.jvm.functions.Function2
        /* JADX INFO: renamed from: invoke */
        public /* bridge */ /* synthetic */ Object mo0invoke(Object r10, Object r11) {
            a((View) r10, (String) r11);
            return Unit.f21064a;
        }
    }

    public static final class b implements Function2 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ d7.c f8650a;

        public b(d7.c r10) {
            this.f8650a = r10;
        }

        public void a(View r10, CommonAppEntity r11) {
            kotlin.jvm.internal.q.g(r10, "view");
            kotlin.jvm.internal.q.g(r11, "entity");
            Bundle r12 = new Bundle();
            r12.putString("search_keyword_position", String.valueOf(this.f8650a.getAdapter().getItemPosition(r11) + 1));
            f9.b.b("click_search_keywords", r12);
        }

        @Override // kotlin.jvm.functions.Function2
        /* JADX INFO: renamed from: invoke */
        public /* bridge */ /* synthetic */ Object mo0invoke(Object r10, Object r11) {
            a((View) r10, (CommonAppEntity) r11);
            return Unit.f21064a;
        }
    }

    public SearchTipFragment() {
        final Function0 r10 = null;
        this.f8644f = FragmentViewModelLazyKt.c(this, kotlin.jvm.internal.u.b(MainViewModel.class), new SearchTipFragment$special$$inlined$activityViewModels$default$1(this), new SearchTipFragment$special$$inlined$activityViewModels$default$2(r10, this), new SearchTipFragment$special$$inlined$activityViewModels$default$3(this));
        final Function0<Fragment> r11 = new SearchTipFragment$special$$inlined$viewModels$default$1(this);
        final Lazy r12 = kotlin.b.a(LazyThreadSafetyMode.NONE, new SearchTipFragment$special$$inlined$viewModels$default$2(r11));
        this.f8645g = FragmentViewModelLazyKt.c(this, kotlin.jvm.internal.u.b(SearchViewModel.class), new SearchTipFragment$special$$inlined$viewModels$default$3(r12), new SearchTipFragment$special$$inlined$viewModels$default$4(r10, r12), new SearchTipFragment$special$$inlined$viewModels$default$5(this, r12));
        d7.c r13 = new d7.c(null, 1, null);
        r13.c(new b(r13));
        this.f8648j = r13;
    }

    public static /* synthetic */ void G(SearchTipFragment r10, String r11) {
        L(r10, r11);
    }

    public static /* synthetic */ void H(SearchTipFragment r10, com.bytedanceos.appstore.buss.network.h r11) {
        M(r10, r11);
    }

    private final x7.d I() {
        x7.d r10 = x7.d.a(m().findViewById(R.id.recycler_view));
        kotlin.jvm.internal.q.f(r10, "bind(...)");
        return r10;
    }

    private final MainViewModel J() {
        return (MainViewModel) this.f8644f.getValue();
    }

    public static final void L(SearchTipFragment r10, String r11) {
        kotlin.jvm.internal.q.g(r10, "this$0");
        if (r11 != null) goto L5;
        return;
    L5:
        if (kotlin.text.o.r(r11) == true) goto L10;
        r10.f8646h = r11;
        SearchViewModel r12 = r10.K();
        kotlin.jvm.internal.q.d(r11);
        r12.n(r11);
        return;
    }

    public static final void M(SearchTipFragment r19, com.bytedanceos.appstore.buss.network.h r20) {
        kotlin.jvm.internal.q.g(r19, "this$0");
        kotlin.jvm.internal.q.d(r20);
        List<CommonAppEntity> r10 = null;
        if ((r20 instanceof com.bytedanceos.appstore.buss.network.h.b) == false) goto L12;
        BinderAdapter r11 = r19.f8647i;
        if (r11 == null) goto L7;
        r10 = r11.getData();
    L7:
        if (r10 != null) goto L9;
    L10:
        r19.B();
        return;
    L9:
        if (r10.isEmpty() == true) goto L10;
        return;
    L12:
        if ((r20 instanceof com.bytedanceos.appstore.buss.network.h.c) == false) goto L53;
        SearchAssociateEntityWrap r12 = (SearchAssociateEntityWrap) ((com.bytedanceos.appstore.buss.network.h.c) r20).a();
        if (r12 == null) goto L16;
        r10 = r12.getApps();
    L16:
        if (r10 != null) goto L18;
    L51:
        String r13 = r19.getString(R.string.search_not_found_msg);
        kotlin.jvm.internal.q.f(r13, "getString(...)");
        String r14 = r19.getString(R.string.search_not_found, new Object[]{r19.f8646h});
        kotlin.jvm.internal.q.f(r14, "getString(...)");
        r19.z(r13, r14, R.drawable.search_empty);
        return;
    L18:
        if (r10.isEmpty() == true) goto L51;
        r19.r();
        if (r12 == null) goto L61;
        List<String> r15 = r12.getKeywords();
        ArrayList r16 = new ArrayList();
        ArrayList r17 = new ArrayList();
        List<CommonAppEntity> r18 = r12.getApps();
        if (r18 == null) goto L37;
        Iterator<T> r21 = r18.iterator();
        int r22 = 0;
    L26:
        if (r21.hasNext() == false) goto L37;
        Object r23 = r21.next();
        int r24 = r22 + 1;
        if (r22 >= 0) goto L30;
        kotlin.collections.t.q();
    L30:
        CommonAppEntity r25 = (CommonAppEntity) r23;
        if (TextUtils.isEmpty(r25.getOnline_time()) == true) goto L33;
        String r110 = r25.getId();
        kotlin.jvm.internal.q.f(r110, "getId(...)");
        String r111 = r25.getName();
        kotlin.jvm.internal.q.f(r111, "getName(...)");
        String r112 = r25.getLogo();
        String r113 = r25.getOnline_time();
        kotlin.jvm.internal.q.f(r113, "getOnline_time(...)");
        String r114 = r25.getCategory();
        String r26 = r25.getStatus();
        kotlin.jvm.internal.q.f(r26, "getStatus(...)");
        r17.add(new AppSubEntity(r110, r111, "", r112, r113, r114, null, Integer.parseInt(r26), ""));
    L36:
        r22 = r24;
        goto L26
    L33:
        if (r22 != 0) goto L35;
        r19.f8648j.h(true);
    L35:
        r16.add(r25);
    L37:
        ArrayList r27 = new ArrayList();
        if (r17.isEmpty() == true) goto L41;
        r27.addAll(r17);
    L41:
        if (r16.isEmpty() == true) goto L43;
        r27.addAll(r16);
    L43:
        if (r15 != null) goto L45;
    L48:
        BinderAdapter r28 = r19.f8647i;
        if (r28 == null) goto L62;
        r28.setList(r27);
        return;
    L62:
        return;
    L45:
        if (r15.isEmpty() == true) goto L48;
        r27.addAll(r15);
        goto L48
    L61:
        return;
    L53:
        if ((r20 instanceof com.bytedanceos.appstore.buss.network.h.a) == false) goto L65;
        com.bytedanceos.appstore.buss.utilities.j.f8856a.c(((com.bytedanceos.appstore.buss.network.h.a) r20).c());
        r19.r();
        return;
    }

    @Override // h7.c
    public void E() {
        J().j().i(this, new d1(this));
        K().o().i(this, new e1(this));
    }

    @Override // h7.c
    public void F() {
    }

    public final SearchViewModel K() {
        return (SearchViewModel) this.f8645g.getValue();
    }

    @Override // h7.c
    public void initData() {
        h7.c.w(this, getString(R.string.search), false, true, 2, null);
        BinderAdapter r10 = new BinderAdapter();
        r10.addItemBinder(CommonAppEntity.class, this.f8648j, null);
        d7.g r11 = new d7.g();
        r11.b(new a(r11));
        r10.addItemBinder(String.class, r11, null);
        d7.h r12 = new d7.h();
        r12.c("page_search_tip");
        r10.addItemBinder(AppSubEntity.class, r12, null);
        this.f8647i = r10;
        I().f25515b.addItemDecoration(new u7.b(0, 1, null));
        I().f25515b.setLayoutManager(new LinearLayoutManager(l()));
        I().f25515b.setAdapter(this.f8647i);
        Bundle r13 = new Bundle();
        r13.putString(TraceStatsConsts.PAGE_STATS_KEY_PAGE_NAME, "page_search_tip");
        f9.b.b("exposure_pages_main", r13);
    }

    @Override // h7.c
    public int n() {
        return R.layout.fragment_tv_search_tip;
    }

    @Override // h7.c
    public Function0 o() {
        return SearchTipFragment$onRetryListener$1.INSTANCE;
    }

    @Override // h7.c, androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        this.f8647i = null;
        J().n(this);
        K().t(this);
    }

    @Override // h7.c
    public boolean q() {
        return true;
    }

    @Override // h7.c
    public void t() {
    }
}
