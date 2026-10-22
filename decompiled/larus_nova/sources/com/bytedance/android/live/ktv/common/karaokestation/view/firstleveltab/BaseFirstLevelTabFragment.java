package com.bytedance.android.live.ktv.common.karaokestation.view.firstleveltab;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.bytedance.android.live.core.utils.i0;
import com.bytedance.android.live.ktv.common.commonui.CustomViewTab;
import com.bytedance.android.live.ktv.common.karaokestation.model.SecondLevelTabViewSelectedType;
import com.bytedance.android.live.ktv.common.karaokestation.model.UpdateTabType;
import com.bytedance.android.live.ktv.common.karaokestation.model.y;
import com.bytedance.android.live.ktv.common.karaokestation.view.BaseTabFragment;
import com.bytedance.android.live.ktv.common.karaokestation.view.KtvCommonPagerAdapter;
import com.bytedance.android.live.ktv.common.karaokestation.view.ScrollControlViewPager;
import com.bytedance.android.live.ktv.common.karaokestation.view.secondleveltab.CommonDefaultSecondLevelTabFragment;
import com.bytedance.android.live.ktv.common.karaokestation.view.secondleveltab.SecondLevelTabView;
import com.bytedance.android.live.ktv.common.model.KtvMode;
import com.bytedance.android.livesdk.ktvimpl.base.karaokestation.ktvcomponent.view.firstleveltab.AudienceSingFirstLevelTabFragment;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.nova.R;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import vm2.h;

/* JADX INFO: loaded from: classes45.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b&\u0018\u00002\u00020\u00012\u00020\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/live/ktv/common/karaokestation/view/firstleveltab/BaseFirstLevelTabFragment;", "Lcom/bytedance/android/live/ktv/common/karaokestation/view/BaseTabFragment;", "Lcom/bytedance/android/live/ktv/common/karaokestation/view/firstleveltab/a;", "livektv-common_saasRelease"}, k = 1, mv = {1, 5, 1})
public abstract class BaseFirstLevelTabFragment extends BaseTabFragment implements com.bytedance.android.live.ktv.common.karaokestation.view.firstleveltab.a {

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final /* synthetic */ int f69614r = 0;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final long f69615e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f69616f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public FrameLayout f69617g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public ScrollControlViewPager f69618h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public SecondLevelTabView f69619i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Lazy f69620j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final Lazy f69621k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final Lazy f69622l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public View f69623m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public View f69624n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public View f69625o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final String f69626p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final com.bytedance.android.live.ktv.common.karaokestation.viewmodel.b f69627q;

    public static final class a<T> implements Observer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ BaseFirstLevelTabFragment f69628a;

        public a(BaseFirstLevelTabFragment r100) {
            this.f69628a = r100;
        }

        @Override // androidx.lifecycle.Observer
        public final void onChanged(Object r100) {
            Pair r101 = (Pair) r100;
            int r102 = ((Number) r101.component1()).intValue();
            if (((UpdateTabType) r101.component2()) == UpdateTabType.DIRECT_CLICK) goto L5;
            return;
        L5:
            if (r102 != this.f69628a.VL().getValue()) goto L11;
            y r103 = this.f69628a.f69627q.getSelectedSecondLevelTabData(r102);
            if (r103 == null) goto L12;
            int r104 = r103.f69589n;
            this.f69628a.ba0(r104, new BaseFirstLevelTabFragment$initData$1$1(this));
            return;
        L12:
            return;
        }
    }

    public static final class b<T> implements Observer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ BaseFirstLevelTabFragment f69629a;

        public b(BaseFirstLevelTabFragment r100) {
            this.f69629a = r100;
        }

        @Override // androidx.lifecycle.Observer
        public final void onChanged(Object r100) {
            Pair r101 = (Pair) r100;
            if (r101 == null) goto L10;
            com.bytedance.android.live.ktv.common.karaokestation.model.d r102 = (com.bytedance.android.live.ktv.common.karaokestation.model.d) r101.component1();
            List<y> r103 = (List) r101.component2();
            if (this.f69629a.VL().getValue() != r102.f69504d) goto L9;
            BaseFirstLevelTabFragment r104 = this.f69629a;
            int r105 = BaseFirstLevelTabFragment.f69614r;
            r104.fa0(r103);
            return;
        L9:
            return;
        }
    }

    public static final class c implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ BaseFirstLevelTabFragment f69630a;

        public c(BaseFirstLevelTabFragment r100) {
            this.f69630a = r100;
        }

        @Override // java.lang.Runnable
        public final void run() {
            BaseFirstLevelTabFragment r100 = this.f69630a;     // Catch: Throwable -> L4
            int r101 = BaseFirstLevelTabFragment.f69614r;     // Catch: Throwable -> L4
            r100.Z90();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final class d<T> implements Observer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ BaseFirstLevelTabFragment f69631a;

        public d(BaseFirstLevelTabFragment r100) {
            this.f69631a = r100;
        }

        @Override // androidx.lifecycle.Observer
        public final void onChanged(Object r100) {
            List<y> r101 = (List) r100;
            List<y> r102 = r101;
            if (r102 != null) goto L5;
        L8:
            boolean r103 = true;
        L9:
            if (r103 == false) goto L12;
            return;
        L12:
            if (this.f69631a.VL().getValue() != ((y) ListProtector.get(r101, 0)).f69586k) goto L17;
            SecondLevelTabView r104 = this.f69631a.f69619i;
            if (r104 == null) goto L18;
            r104.setDataAndNotify(r101);
            return;
        L18:
            return;
        L17:
            return;
        L5:
            if (r102.isEmpty() == true) goto L8;
            r103 = false;
            goto L9
        }
    }

    public static final class e<T> implements Observer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ BaseFirstLevelTabFragment f69632a;

        public e(BaseFirstLevelTabFragment r100) {
            this.f69632a = r100;
        }

        @Override // androidx.lifecycle.Observer
        public final void onChanged(Object r100) {
            y r101 = (y) r100;
            if (r101 != null) goto L6;
            return;
        L6:
            if (this.f69632a.VL().getValue() != r101.f69586k) goto L17;
            int r102 = this.f69632a.Y90().size();
            int r103 = r101.f69589n;
            if (r103 < 0) goto L20;
            if (r102 <= r103) goto L18;
            BaseFirstLevelTabFragment r104 = this.f69632a;
            com.bytedance.android.live.ktv.common.karaokestation.view.secondleveltab.c r105 = r104.Y90().get(r101.f69589n);
            if (r105.yf() == false) goto L14;
            r105.ok(r101, r105.ms(null));
        L15:
            r104.da0(r101);
            return;
        L14:
            r105.W30(new BaseFirstLevelTabFragment$updateSecondLevelTabSongList$1(r105, r101));
            goto L15
        L18:
            return;
        L20:
            return;
        }
    }

    public static final class f<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ BaseFirstLevelTabFragment f69633a;

        public f(BaseFirstLevelTabFragment r100) {
            this.f69633a = r100;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            com.bytedance.android.live.ktv.common.karaokestation.model.c r101 = (com.bytedance.android.live.ktv.common.karaokestation.model.c) r100;
            Map<Integer, com.bytedance.android.live.ktv.common.karaokestation.model.b> r102 = r101.f69500a;
            if (r102 != null) goto L5;
        L8:
            boolean r103 = true;
        L9:
            if (r103 == true) goto L23;
            Map<Integer, com.bytedance.android.live.ktv.common.karaokestation.model.b> r104 = r101.f69500a;
            com.bytedance.android.live.ktv.common.karaokestation.viewmodel.b r105 = this.f69633a.f69627q;
            if (r105 == null) goto L14;
            Integer r106 = Integer.valueOf(r105.getCurTabMode());
        L15:
            com.bytedance.android.live.ktv.common.karaokestation.model.b r107 = r104.get(r106);
            if (r107 != null) goto L18;
            return;
        L18:
            if (r107.f69498b != this.f69633a.VL().getValue()) goto L22;
            BaseFirstLevelTabFragment r108 = this.f69633a;
            r108.Tq(r108.X90(r107.f69499c), SecondLevelTabViewSelectedType.Default);
            return;
        L22:
            return;
        L14:
            r106 = null;
            goto L15
        L23:
            return;
        L5:
            if (r102.isEmpty() == true) goto L8;
            r103 = false;
            goto L9
        }
    }

    @Override // com.bytedance.android.live.ktv.common.karaokestation.view.firstleveltab.a
    public void U50(boolean r100) {
    }

    public boolean U90() {
        return !(this instanceof AudienceSingFirstLevelTabFragment);
    }

    public void V90() {
    }

    public final CopyOnWriteArrayList<com.bytedance.android.live.ktv.common.karaokestation.view.secondleveltab.c> Y90() {
        return (CopyOnWriteArrayList) this.f69620j.getValue();
    }

    public void ca0(y r100) {
    }

    public void da0(y r100) {
        Intrinsics.checkNotNullParameter(r100, "secondLevelTabData");
    }

    @Override // com.bytedance.android.live.ktv.common.karaokestation.view.BaseTabFragment
    public int getLayoutId() {
        return R.layout.ttlive_ktv_common_default_fragment;
    }

    @Override // com.bytedance.android.live.ktv.common.karaokestation.view.BaseTabFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        this.f69623m = null;
        this.f69624n = null;
        this.f69625o = null;
        super.onDestroy();
    }

    public final void Z90() {
        com.bytedance.android.live.ktv.common.karaokestation.viewmodel.b r100 = this.f69627q;
        if (r100 == null) goto L18;
        List<y> r101 = r100.getSecondLevelTabDataList(VL().getValue());
        if (r101 == null) goto L18;
        Iterator<T> r102 = r101.iterator();
    L8:
        if (r102.hasNext() == false) goto L18;
        y r103 = (y) r102.next();
        int r104 = Y90().size();
        int r105 = r103.f69589n;
        if (r105 < 0) goto L8;
        if (r104 <= r105) goto L8;
        com.bytedance.android.live.ktv.common.karaokestation.view.secondleveltab.c r106 = Y90().get(r103.f69589n);
        if (r106.yf() == false) goto L16;
        r106.ok(r103, r106.ms(null));
    L17:
        da0(r103);
        goto L8
    L16:
        r106.W30(new BaseFirstLevelTabFragment$updateSecondLevelTabSongList$1(r106, r103));
    L18:
        com.bytedance.android.live.ktv.common.karaokestation.viewmodel.b r107 = this.f69627q;
        if (r107 == null) goto L29;
        r107.observeSongListDataChange(this, new e(this));
        return;
    }

    public final void aa0() {
        com.bytedance.android.live.ktv.common.karaokestation.viewmodel.b r100 = this.f69627q;
        y r101 = null;
        Object r102 = null;
        r101 = null;
        if (r100 == null) goto L18;
        List<y> r103 = r100.getSecondLevelTabDataList(VL().getValue());
        if (r103 == null) goto L18;
        Iterator<T> r104 = r103.iterator();
    L8:
        if (r104.hasNext() == false) goto L17;
        Object r105 = r104.next();
        int r106 = ((y) r105).f69589n;
        ScrollControlViewPager r107 = this.f69618h;
        if (r107 != null) goto L12;
    L14:
        boolean r108 = false;
    L15:
        if (r108 == false) goto L8;
        r102 = r105;
        goto L17
    L12:
        if (r106 != r107.getCurrentItem()) goto L14;
        r108 = true;
    L17:
        r101 = (y) r102;
    L18:
        Tq(r101, SecondLevelTabViewSelectedType.SLIDE);
    }

    @Override // com.bytedance.android.live.ktv.common.karaokestation.view.BaseTabFragment
    public void initData() {
        com.bytedance.android.live.ktv.common.karaokestation.viewmodel.b r100 = this.f69627q;
        if (r100 == null) goto L5;
        r100.observeSelectedFirstLevelTabValueChange(this, new a(this));
    L5:
        V90();
        SecondLevelTabView r101 = this.f69619i;
        if (r101 == null) goto L8;
        r101.setTabSelectedAction(new BaseFirstLevelTabFragment$initData$$inlined$apply$lambda$1(this));
        r101.setCreateCustomViewTabAction(W90());
        r101.r();
    L8:
        ScrollControlViewPager r102 = this.f69618h;
        if (r102 == null) goto L11;
        r102.f69612a = U90();
        r102.addOnPageChangeListener((BaseFirstLevelTabFragment$tabPageChangeListener$2.AnonymousClass1) this.f69622l.getValue());
        r102.setOffscreenPageLimit(3);
        r102.setAdapter((KtvCommonPagerAdapter) this.f69621k.getValue());
    L11:
        com.bytedance.android.live.ktv.common.karaokestation.viewmodel.b r103 = this.f69627q;
        if (r103 == null) goto L16;
        List<y> r104 = r103.getSecondLevelTabDataList(VL().getValue());
        if (r104 == null) goto L16;
        fa0(r104);
    L16:
        com.bytedance.android.live.ktv.common.karaokestation.viewmodel.b r105 = this.f69627q;
        if (r105 == null) goto L20;
        r105.observeTabListDataChange(this, new b(this));
    L20:
        if (this.f69616f == false) goto L22;
        i0.c().postDelayed(new c(this), this.f69615e);
    L23:
        com.bytedance.android.live.ktv.common.karaokestation.viewmodel.b r106 = this.f69627q;
        if (r106 == null) goto L27;
        r106.observeTabListStateChange(this, new d(this));
        return;
    L27:
        return;
    L22:
        Z90();
        goto L23
    }

    @Override // com.bytedance.android.live.ktv.common.karaokestation.view.firstleveltab.a
    public final void O0() {
        Iterator<T> r100 = Y90().iterator();
    L4:
        if (r100.hasNext() == false) goto L6;
        ((com.bytedance.android.live.ktv.common.karaokestation.view.secondleveltab.c) r100.next()).O0();
        goto L4
    }

    public Function1<Context, CustomViewTab> W90() {
        return BaseFirstLevelTabFragment$getCreateCustomViewTabAction$1.INSTANCE;
    }

    public com.bytedance.android.live.ktv.common.karaokestation.view.secondleveltab.c T90(y r100) {
        Intrinsics.checkNotNullParameter(r100, "secondLevelTabData");
        int r101 = CommonDefaultSecondLevelTabFragment.f69662n;
        com.bytedance.android.live.ktv.common.karaokestation.viewmodel.b r102 = this.f69627q;
        Intrinsics.checkNotNullParameter(r100, "secondLevelTabData");
        return new CommonDefaultSecondLevelTabFragment(r100, r102);
    }

    public y X90(String r100) {
        com.bytedance.android.live.ktv.common.karaokestation.viewmodel.b r101 = this.f69627q;
        if (r101 == null) goto L5;
        final List<y> r102 = r101.getSecondLevelTabDataList(VL().getValue());
    L6:
        List<y> r103 = r102;
        if (r103 != null) goto L9;
    L12:
        boolean r104 = true;
    L13:
        if (r104 == false) goto L15;
        return null;
    L15:
        Function1<String, y> r105 = new BaseFirstLevelTabFragment$getDefaultSecondLevelTabData$1(r102);
        Function0<y> r106 = new BaseFirstLevelTabFragment$getDefaultSecondLevelTabData$2(r102);
        y r107 = r105.invoke2(this.f69626p);
        if (r107 != null) goto L18;
        r107 = r105.invoke2(r100);
    L18:
        if (r107 == null) goto L20;
        return r107;
    L20:
        return r106.invoke();
    L9:
        if (r103.isEmpty() == true) goto L12;
        r104 = false;
        goto L13
    L5:
        r102 = null;
        goto L6
    }

    public final boolean ea0(y r100) {
        com.bytedance.android.live.ktv.common.karaokestation.viewmodel.b r101 = this.f69627q;
        if (r101 == null) goto L9;
        Pair<Integer, UpdateTabType> r102 = r101.getSelectedFirstLevelTabValue();
        if (r102 == null) goto L9;
        if (r102.getFirst().intValue() != VL().getValue()) goto L9;
        boolean r103 = true;
    L10:
        if (r100 != null) goto L12;
    L16:
        return true;
    L12:
        if (r100.f69586k != VL().getValue()) goto L16;
        if (r103 == false) goto L16;
        return false;
    L9:
        r103 = false;
        goto L10
    }

    public final void fa0(List<y> r100) {
        if ((!Y90().isEmpty()) == false) goto L5;
        return;
    L5:
        Y90().clear();
        com.bytedance.android.live.ktv.common.karaokestation.viewmodel.b r101 = this.f69627q;
        if (r101 == null) goto L13;
        List<y> r102 = r101.getSecondLevelTabDataList(VL().getValue());
        if (r102 == null) goto L13;
        Iterator<T> r103 = r102.iterator();
    L11:
        if (r103.hasNext() == false) goto L13;
        Y90().add(T90((y) r103.next()));
    L13:
        KtvCommonPagerAdapter r104 = (KtvCommonPagerAdapter) this.f69621k.getValue();
        if (r104 == null) goto L16;
        ArrayList r105 = new ArrayList();
        r105.addAll(Y90());
        Unit r106 = Unit.INSTANCE;
        r104.f(r105);
    L16:
        Tq(X90(null), SecondLevelTabViewSelectedType.Default);
        Disposable r107 = xs2.b.a().b(com.bytedance.android.live.ktv.common.karaokestation.model.c.class).subscribe(new f(this));
        if (r107 == null) goto L19;
        S90(r107);
    L19:
        SecondLevelTabView r108 = this.f69619i;
        if (r108 == null) goto L24;
        r108.setDataAndNotify(r100);
        return;
    }

    @Override // com.bytedance.android.live.ktv.common.karaokestation.view.BaseTabFragment
    public void initView(View r100) {
        ScrollControlViewPager r101 = null;
        if (r100 == null) goto L5;
        SecondLevelTabView r102 = (SecondLevelTabView) r100.findViewById(R.id.second_level_tab_view);
    L6:
        this.f69619i = r102;
        if (r100 == null) goto L9;
        FrameLayout r103 = (FrameLayout) r100.findViewById(R.id.content_container);
    L10:
        this.f69617g = r103;
        if (r100 == null) goto L13;
        r101 = (ScrollControlViewPager) r100.findViewById(R.id.second_level_tab_fragment_viewpager);
    L13:
        this.f69618h = r101;
        return;
    L9:
        r103 = null;
        goto L10
    L5:
        r102 = null;
        goto L6
    }

    public BaseFirstLevelTabFragment(String r100, com.bytedance.android.live.ktv.common.karaokestation.viewmodel.b r101) {
        this.f69626p = r100;
        this.f69627q = r101;
        this.f69615e = ((Number) h.f556276y1.getValue(null, h.f556082a[127(0x7f, float:1.78E-43)])).longValue();
        if (bb0.b.a() != KtvMode.SOLO_KTV) goto L5;
        boolean r102 = true;
    L6:
        this.f69616f = !r102;
        this.f69620j = LazyKt.lazy(BaseFirstLevelTabFragment$secondLevelTabFragmentList$2.INSTANCE);
        this.f69621k = LazyKt.lazy(new BaseFirstLevelTabFragment$secondLevelTabPagerAdapter$2(this));
        this.f69622l = LazyKt.lazy(new BaseFirstLevelTabFragment$tabPageChangeListener$2(this));
        return;
    L5:
        r102 = false;
        goto L6
    }

    @Override // com.bytedance.android.live.ktv.common.karaokestation.view.firstleveltab.a
    public final void Tq(y r100, SecondLevelTabViewSelectedType r101) {
        Intrinsics.checkNotNullParameter(r101, "secondLevelTabViewSelectedType");
        if (r100 != null) goto L6;
        return;
    L6:
        if (r101 != SecondLevelTabViewSelectedType.CLICK) goto L12;
        int r102 = r100.f69589n;
        ScrollControlViewPager r103 = this.f69618h;
        if (r103 != null) goto L10;
    L17:
        boolean r104 = true;
    L19:
        if (VL().getValue() != r100.f69586k) goto L36;
        if (r104 == false) goto L37;
        com.bytedance.android.live.ktv.common.karaokestation.viewmodel.b r105 = this.f69627q;
        if (r105 == null) goto L24;
        r105.updateSecondLevelTabListState(r100, true);
    L24:
        ScrollControlViewPager r106 = this.f69618h;
        if (r106 == null) goto L27;
        r106.h(r100.f69589n, new BaseFirstLevelTabFragment$onSecondLevelTabViewSelected$1(this));
    L27:
        ca0(r100);
        int r107 = Y90().size();
        int r108 = r100.f69589n;
        if (r108 < 0) goto L39;
        if (r107 <= r108) goto L38;
        SecondLevelTabView r109 = this.f69619i;
        if (r109 == null) goto L34;
        r109.scrollToPosition(r108);
    L34:
        Y90().get(r100.f69589n).rs(r101, r100);
        return;
    L38:
        return;
    L39:
        return;
    L37:
        return;
    L36:
        return;
    L10:
        if (r102 != r103.getCurrentItem()) goto L17;
    L12:
        if (r101 == SecondLevelTabViewSelectedType.Default) goto L17;
        if (r101 == SecondLevelTabViewSelectedType.SLIDE) goto L17;
        r104 = false;
        goto L19
    }

    public final void ba0(int r100, Function1<? super Boolean, Unit> r101) {
        ScrollControlViewPager r102 = this.f69618h;
        if (r102 != null) goto L5;
    L19:
        ScrollControlViewPager r103 = this.f69618h;
        if (r103 == null) goto L22;
        r103.h(r100, new BaseFirstLevelTabFragment$onSecondLevelTabPageSelected$1(this));
    L22:
        SecondLevelTabView r104 = this.f69619i;
        if (r104 == null) goto L25;
        r104.scrollToPosition(r100);
    L25:
        aa0();
        if (r101 == null) goto L33;
        Unit r105 = r101.invoke(Boolean.TRUE);
        return;
    L33:
        return;
    L5:
        if (r100 != r102.getCurrentItem()) goto L19;
        com.bytedance.android.live.ktv.common.karaokestation.viewmodel.b r106 = this.f69627q;
        if (r106 == null) goto L16;
        y r107 = r106.getSelectedSecondLevelTabData(VL().getValue());
        if (r107 == null) goto L16;
        if (r107.f69589n != r100) goto L16;
        if (r101 == null) goto L29;
        Unit r108 = r101.invoke(Boolean.FALSE);
        return;
    L29:
        return;
    L16:
        aa0();
        if (r101 == null) goto L31;
        Unit r109 = r101.invoke(Boolean.TRUE);
        return;
    }

    @Override // com.bytedance.android.live.ktv.common.karaokestation.view.firstleveltab.a
    public final void y40(View r100, View r101, View r102) {
        if ((r100 instanceof ViewGroup) == true) goto L5;
        r100 = null;
    L5:
        this.f69623m = (ViewGroup) r100;
        this.f69624n = r101;
        this.f69625o = r102;
    }
}
