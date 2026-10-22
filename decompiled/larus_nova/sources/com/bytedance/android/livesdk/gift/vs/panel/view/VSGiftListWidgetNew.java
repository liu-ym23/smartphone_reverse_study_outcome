package com.bytedance.android.livesdk.gift.vs.panel.view;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.lifecycle.MutableLiveData;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;
import com.bytedance.android.live.core.tetris.widgets.LiveRecyclableWidget;
import com.bytedance.android.live.core.utils.rxutils.j;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.revenue.common.i;
import com.bytedance.android.livesdk.gift.model.h1;
import com.bytedance.android.livesdk.gift.model.l2;
import com.bytedance.android.livesdk.gift.model.w1;
import com.bytedance.android.livesdk.gift.model.z3;
import com.bytedance.android.livesdk.gift.platform.business.config.GiftConfigKey;
import com.bytedance.android.livesdk.gift.platform.business.config.n;
import com.bytedance.android.livesdk.gift.platform.business.dialog.ui.panel.AbsPanel;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v2.viewmodel.GiftStateMachineConfig;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v2.viewmodel.GiftViewModelManager;
import com.bytedance.android.livesdk.gift.vs.panel.adapter.VSGiftDialogAdapterNew;
import com.bytedance.android.livesdk.gift.vs.panel.adapter.VSGiftDialogViewPagerAdapter;
import com.bytedance.android.livesdk.gift.vs.panel.viewholder.VSGiftDialogViewHolder;
import com.bytedance.android.livesdk.gift.vs.panel.viewmodel.VSGiftDialogViewModel;
import com.bytedance.android.livesdk.padutils.PadConfigUtils;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import pz1.e;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/livesdk/gift/vs/panel/view/VSGiftListWidgetNew;", "Lcom/bytedance/android/live/core/tetris/widgets/LiveRecyclableWidget;", "livegift-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class VSGiftListWidgetNew extends LiveRecyclableWidget {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final CompositeDisposable f132430a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ViewPager f132431b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final VSGiftDialogViewPagerAdapter f132432c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public AbsPanel<?> f132433d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f132434e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public ImageView f132435f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f132436g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public Disposable f132437h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f132438i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final VSGiftListWidgetNew$pageChangeListener$1 f132439j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final GiftViewModelManager f132440k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final VSGiftDialogViewModel f132441l;

    public static final class a<T> implements Observer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ VSGiftListWidgetNew f132442a;

        public a(VSGiftListWidgetNew r100) {
            this.f132442a = r100;
        }

        @Override // androidx.lifecycle.Observer
        public final void onChanged(Object r100) {
            z3 r101 = (z3) r100;
            VSGiftListWidgetNew r102 = this.f132442a;
            AbsPanel<?> r103 = r102.f132433d;
            if (r103 == null) goto L24;
            VSGiftDialogAdapterNew r104 = r102.Aq();
            if (r104 == null) goto L25;
            AbsPanel<?> r105 = r104.z2(r103.c());
            if (r105 == null) goto L28;
            VSGiftDialogAdapterNew r106 = r102.Aq();
            if (r106 == null) goto L26;
            Intrinsics.checkNotNullParameter(r105, "panel");
            int r107 = ((ArrayList) r106.f132342a).indexOf(r105);
            RecyclerView r108 = r102.zq();
            String r109 = null;
            if (r108 == null) goto L14;
            RecyclerView.ViewHolder r110 = r108.findViewHolderForAdapterPosition(r107);
        L16:
            if ((r110 instanceof VSGiftDialogViewHolder) == true) goto L18;
            r110 = null;
        L18:
            VSGiftDialogViewHolder r111 = (VSGiftDialogViewHolder) r110;
            if (r111 == null) goto L27;
            if (r101 == null) goto L22;
            r109 = r101.a();
        L22:
            r111.e4().g(r109);
            return;
        L27:
            return;
        L14:
            r110 = null;
            goto L16
        L26:
            return;
        L28:
            return;
        L25:
            return;
        }
    }

    public static final class b<T> implements Observer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ VSGiftListWidgetNew f132443a;

        public b(VSGiftListWidgetNew r100) {
            this.f132443a = r100;
        }

        @Override // androidx.lifecycle.Observer
        public final void onChanged(Object r100) {
            VSGiftListWidgetNew r101 = this.f132443a;
            VSGiftListWidgetNew.xq(r101, (GiftStateMachineConfig.g) r100);
        }
    }

    public static final class c<T> implements Observer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ VSGiftListWidgetNew f132444a;

        public c(VSGiftListWidgetNew r100) {
            this.f132444a = r100;
        }

        @Override // androidx.lifecycle.Observer
        public final void onChanged(Object r100) {
            VSGiftListWidgetNew r101 = this.f132444a;
            VSGiftListWidgetNew.xq(r101, (GiftStateMachineConfig.g) r100);
        }
    }

    public static final class d<T> implements Observer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ VSGiftListWidgetNew f132445a;

        public d(VSGiftListWidgetNew r100) {
            this.f132445a = r100;
        }

        @Override // androidx.lifecycle.Observer
        public final void onChanged(Object r100) {
            VSGiftListWidgetNew r101 = this.f132445a;
            VSGiftListWidgetNew.xq(r101, (GiftStateMachineConfig.g) r100);
        }
    }

    public final VSGiftDialogAdapterNew Aq() {
        Map<Integer, VSGiftDialogAdapterNew> r100 = this.f132432c.f132351d;
        LinkedHashMap r101 = (LinkedHashMap) r100;
        return (VSGiftDialogAdapterNew) r101.get(Integer.valueOf(com.bytedance.android.livesdk.gift.vs.panel.statemachine.helper.b.f()));
    }

    @Override // com.bytedance.android.live.core.tetris.widgets.LiveWidget, com.bytedance.ies.sdk.widgets.Widget
    public final void onPause() {
        this.f132432c.g(zq());
        super.onPause();
    }

    public final RecyclerView zq() {
        ViewPager r100 = this.f132431b;
        if (r100 != null) goto L7;
        return null;
    L7:
        return (RecyclerView) r100.findViewWithTag(Integer.valueOf(com.bytedance.android.livesdk.gift.vs.panel.statemachine.helper.b.f()));
    }

    @Override // com.bytedance.ies.sdk.widgets.Widget
    public final int getLayoutId() {
        if (PadConfigUtils.c() == false) goto L5;
    L8:
        return R.layout.ttlive_vs_gift_list_widget_pad_vertical;
    L5:
        if (com.bytedance.android.livesdk.gift.util.a.a() == true) goto L8;
        return R.layout.ttlive_vs_gift_list_widget_new;
    }

    @Override // com.bytedance.android.live.core.tetris.widgets.LiveWidget, com.bytedance.ies.sdk.widgets.Widget
    public final void onResume() {
        super.onResume();
        this.f132432c.h(zq());
    }

    @Override // com.bytedance.android.live.core.tetris.widgets.LiveRecyclableWidget
    public final void onUnload() {
        com.bytedance.android.livesdk.gift.util.b.e(this);
        this.f132430a.clear();
        Disposable r100 = this.f132437h;
        if (r100 == null) goto L6;
        r100.dispose();
        return;
    }

    public final int yq() {
        if (PadConfigUtils.c() == true) goto L9;
        if (com.bytedance.android.livesdk.gift.util.a.a() == true) goto L9;
        return s1.getResources().getDimensionPixelSize(R.dimen.ttlive_vs_gift_list_widget_height);
    L9:
        return s1.getResources().getDimensionPixelSize(R.dimen.ttlive_vs_gift_list_widget_height_pad);
    }

    public final void Bq(int r100) {
        ViewPager r101 = this.f132431b;
        if (r101 == null) goto L19;
        Iterator r102 = ((ArrayList) this.f132432c.f132349b).iterator();
        int r103 = 0;
    L6:
        if (r102.hasNext() == false) goto L14;
        if (((w1) r102.next()).getPageType() != r100) goto L10;
        boolean r104 = true;
    L11:
        if (r104 == true) goto L15;
        r103 = r103 + 1;
    L15:
        r101.setCurrentItem(r103);
        return;
    L10:
        r104 = false;
        goto L11
    L14:
        r103 = -1;
        goto L15
    }

    public final void Fq(List<? extends w1> r100) {
        if (r100 == null) goto L30;
        VSGiftDialogViewPagerAdapter r101 = this.f132432c;
        Context r102 = this.context;
        r101.getClass();
        Intrinsics.checkNotNullParameter(r102, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r100, "pages");
        ArrayList r103 = new ArrayList();
        Iterator<T> r104 = r100.iterator();
    L5:
        if (r104.hasNext() == false) goto L9;
        Object r105 = r104.next();
        if (((w1) r105).getDisplay() == false) goto L5;
        r103.add(r105);
        goto L5
    L9:
        ((ArrayList) r101.f132349b).clear();
        ((ArrayList) r101.f132349b).addAll(r103);
        Iterator r106 = ((LinkedHashMap) r101.f132351d).entrySet().iterator();
    L11:
        if (r106.hasNext() == false) goto L19;
        Map.Entry r107 = (Map.Entry) r106.next();
        List<w1> r108 = r101.f132349b;
        ArrayList r109 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r108, 10));
        Iterator r110 = ((ArrayList) r108).iterator();
    L14:
        if (r110.hasNext() == false) goto L17;
        r109.add(Integer.valueOf(((w1) r110.next()).getPageType()));
        goto L14
    L17:
        if (r109.contains(r107.getKey()) == true) goto L11;
        r106.remove();
        goto L11
    L19:
        r101.notifyDataSetChanged();
        Iterator r111 = r103.iterator();
    L21:
        if (r111.hasNext() == false) goto L28;
        w1 r112 = (w1) r111.next();
        if (r101.f132351d.containsKey(Integer.valueOf(r112.getPageType())) == true) goto L25;
        r101.f132351d.put(Integer.valueOf(r112.getPageType()), new VSGiftDialogAdapterNew(r102, r101.f132361n, r101.f132362o));
    L25:
        VSGiftDialogAdapterNew r113 = (VSGiftDialogAdapterNew) ((LinkedHashMap) r101.f132351d).get(Integer.valueOf(r112.getPageType()));
        if (r113 == null) goto L21;
        r113.y2(com.bytedance.android.livesdk.gift.vs.panel.statemachine.helper.b.q(r112.getPageType()));
        goto L21
    L28:
        r101.notifyDataSetChanged();
        this.f132432c.f(this.context, com.bytedance.android.livesdk.gift.vs.panel.statemachine.helper.b.f());
    L30:
        if ((!com.bytedance.android.livesdk.gift.vs.panel.statemachine.helper.b.q(com.bytedance.android.livesdk.gift.vs.panel.statemachine.helper.b.f()).isEmpty()) == false) goto L51;
        ImageView r114 = this.f132435f;
        if (r114 == null) goto L52;
        r114.setVisibility(8);
        return;
    L52:
        return;
    }

    @Override // com.bytedance.android.live.core.tetris.widgets.LiveRecyclableWidget
    public final void onInit(Object[] r100) {
        this.f132431b = (ViewPager) findViewById(R.id.view_pager);
        this.f132435f = (ImageView) findViewById(R.id.no_data_view);
    }

    @Override // com.bytedance.android.live.core.tetris.widgets.LiveRecyclableWidget
    public final void onLoad(Object[] r100) {
        ViewPager r101 = this.f132431b;
        if (r101 == null) goto L5;
        r101.setAdapter(this.f132432c);
    L5:
        ViewPager r102 = this.f132431b;
        if (r102 == null) goto L8;
        r102.addOnPageChangeListener(this.f132439j);
    L8:
        int r103 = ((Number) com.bytedance.android.livesdk.gift.util.b.a().c(GiftConfigKey.KEY_GIFT_LIST_EMPTY_ICON, Integer.valueOf(R.drawable.ttlive_empty_content_dark))).intValue();
        ImageView r104 = this.f132435f;
        if (r104 == null) goto L11;
        r104.setImageResource(r103);
    L11:
        VSGiftDialogViewModel r105 = this.f132441l;
        if (r105 == null) goto L16;
        MutableLiveData<z3> r106 = r105.getInfo();
        if (r106 == null) goto L16;
        r106.observe(this, new a(this));
    L16:
        com.bytedance.android.livesdk.gift.util.b.d("GiftListViewModel", this, new b(this), true);
        com.bytedance.android.livesdk.gift.util.b.d("GiftTabViewModel", this, new c(this), true);
        com.bytedance.android.livesdk.gift.util.b.d("GiftDialogViewModel", this, new d(this), true);
        if (this.f132438i == false) goto L33;
        View r107 = findViewById(R.id.mask_view);
        if (r107 == null) goto L21;
        r107.setVisibility(8);
    L21:
        View r108 = findViewById(R.id.mask_view_bottom);
        if (r108 == null) goto L25;
        r108.setVisibility(8);
    L25:
        if (PadConfigUtils.c() == false) goto L27;
    L30:
        int r109 = s1.f(15.0f);
    L31:
        View r110 = this.contentView;
        r110.setPadding(r110.getPaddingLeft(), r109, this.contentView.getPaddingRight(), this.contentView.getPaddingBottom());
        return;
    L27:
        if (com.bytedance.android.livesdk.gift.util.a.a() == true) goto L30;
        r109 = s1.f(5.0f);
        goto L31
    }

    /* JADX WARN: Type inference failed for: r2v1, types: [com.bytedance.android.livesdk.gift.vs.panel.view.VSGiftListWidgetNew$pageChangeListener$1] */
    public VSGiftListWidgetNew(GiftViewModelManager r100, VSGiftDialogViewModel r101) {
        Intrinsics.checkNotNullParameter(r100, "mViewModel");
        this.f132440k = r100;
        this.f132441l = r101;
        this.f132430a = new CompositeDisposable();
        this.f132432c = new VSGiftDialogViewPagerAdapter(r100, r101);
        this.f132439j = new VSGiftListWidgetNew$pageChangeListener$1(this);
    }

    public static final HashMap wq(VSGiftListWidgetNew r100, int r101) {
        ViewPager r102 = r100.f132431b;
        if (r102 == null) goto L7;
        RecyclerView r103 = (RecyclerView) r102.findViewWithTag(Integer.valueOf(r101));
        if (r103 == null) goto L7;
        RecyclerView.LayoutManager r104 = r103.getLayoutManager();
    L8:
        List<AbsPanel<?>> r105 = com.bytedance.android.livesdk.gift.vs.panel.statemachine.helper.b.q(r101);
        HashMap r106 = new HashMap();
        if ((r104 instanceof LinearLayoutManager) == false) goto L57;
        LinearLayoutManager r107 = (LinearLayoutManager) r104;
        int r108 = r107.findFirstCompletelyVisibleItemPosition();
        int r109 = r107.findLastCompletelyVisibleItemPosition();
        if (r108 > r109) goto L37;
    L12:
        if (r108 >= 0) goto L14;
    L34:
        if (r108 == r109) goto L37;
        r108 = r108 + 1;
        goto L12
    L14:
        if (r108 >= r105.size()) goto L34;
        AbsPanel r110 = (AbsPanel) ListProtector.get(r105, r108);
        if ((r110 instanceof com.bytedance.android.livesdk.gift.platform.business.dialog.ui.panel.a) == false) goto L26;
        T r111 = ((com.bytedance.android.livesdk.gift.platform.business.dialog.ui.panel.a) r110).f126620h;
        if ((r111 instanceof h1) == false) goto L26;
        h1 r112 = (h1) r111;
        if (r112 == null) goto L24;
        r106.put(Long.valueOf(r112.getId()), Long.valueOf(r108));
        goto L34
    L24:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.livesdk.gift.model.IGift");
    L26:
        if ((r110 instanceof e) == false) goto L34;
        T r113 = ((e) r110).f126620h;
        if ((r113 instanceof l2) == false) goto L34;
        l2 r114 = (l2) r113;
        if (r114 == null) goto L33;
        r106.put(Long.valueOf(r114.getId()), Long.valueOf(r108));
        goto L34
    L33:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.livesdk.gift.model.IProp");
    L37:
        if (r106.isEmpty() == false) goto L57;
        IntRange r115 = (IntRange) ((LinkedHashMap) r100.f132432c.f132355h).get(Integer.valueOf(r101));
        if (r115 == null) goto L57;
        int r116 = r115.getFirst();
        int r117 = r115.getLast();
        if (r116 > r117) goto L57;
    L42:
        if (r116 >= 0) goto L44;
    L55:
        if (r116 == r117) goto L57;
        r116 = r116 + 1;
        goto L42
    L44:
        if (r116 >= r105.size()) goto L55;
        AbsPanel r118 = (AbsPanel) ListProtector.get(r105, r116);
        if ((r118 instanceof com.bytedance.android.livesdk.gift.platform.business.dialog.ui.panel.a) == false) goto L55;
        T r119 = ((com.bytedance.android.livesdk.gift.platform.business.dialog.ui.panel.a) r118).f126620h;
        if ((r119 instanceof h1) == false) goto L55;
        h1 r120 = (h1) r119;
        if (r120 == null) goto L54;
        r106.put(Long.valueOf(r120.getId()), Long.valueOf(r116));
        goto L55
    L54:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.livesdk.gift.model.IGift");
    L57:
        return r106;
    L7:
        r104 = null;
        goto L8
    }

    public static final void xq(VSGiftListWidgetNew r100, GiftStateMachineConfig.g r101) {
        r100.getClass();
        if (r101 == null) goto L101;
        boolean r102 = false;
        Long r103 = null;
        if ((r101 instanceof GiftStateMachineConfig.e.b) == false) goto L45;
        GiftStateMachineConfig.e.b r104 = (GiftStateMachineConfig.e.b) r101;
        GiftStateMachineConfig.c r105 = r104.f127046a;
        if (r105 == null) goto L12;
        if (r105.f127043f == true) goto L45;
    L12:
        if (r104.f127047b == false) goto L23;
        List<w1> r106 = r104.a();
        if (r106 == null) goto L21;
        ArrayList r107 = new ArrayList();
        Iterator<T> r108 = r106.iterator();
    L17:
        if (r108.hasNext() == false) goto L22;
        Object r109 = r108.next();
        if (((w1) r109).getDisplay() == false) goto L17;
        r107.add(r109);
    L22:
        r100.Fq(r107);
        goto L23
    L21:
        r107 = null;
    L23:
        ViewPager r110 = r100.f132431b;
        if (r110 == null) goto L35;
        Integer r111 = Integer.valueOf(r110.getCurrentItem());
        if (r111.intValue() != (-1)) goto L28;
        boolean r112 = true;
    L29:
        if (r112 == true) goto L32;
        r111 = null;
    L32:
        if (r111 == null) goto L35;
        r111.intValue();
        r100.Bq(com.bytedance.android.livesdk.gift.vs.panel.statemachine.helper.b.f());
        goto L35
    L28:
        r112 = false;
    L35:
        if (r100.zq() == null) goto L38;
        r100.Eq(com.bytedance.android.livesdk.gift.vs.panel.statemachine.helper.b.f(), false);
    L38:
        if (r100.zq() != null) goto L45;
        Disposable r113 = r100.f132437h;
        if (r113 != null) goto L42;
    L43:
        j.a r114 = j.f66356a;
        r100.f132437h = j.c(200, TimeUnit.MILLISECONDS).observeOn(AndroidSchedulers.mainThread()).subscribe(new b22.d(r100));
        goto L45
    L42:
        if (r113.isDisposed() == true) goto L43;
    L45:
        if ((r101 instanceof GiftStateMachineConfig.e.c) == false) goto L59;
        GiftStateMachineConfig.e.c r115 = (GiftStateMachineConfig.e.c) r101;
        if (r115.f127049b == true) goto L59;
        List<w1> r116 = r115.a();
        if (r116 == null) goto L56;
        ArrayList r117 = new ArrayList();
        Iterator<T> r118 = r116.iterator();
    L52:
        if (r118.hasNext() == false) goto L57;
        Object r119 = r118.next();
        if (((w1) r119).getDisplay() == false) goto L52;
        r117.add(r119);
    L57:
        r100.Fq(r117);
        com.bytedance.android.livesdk.gift.util.d.c();
        goto L59
    L56:
        r117 = null;
    L59:
        if ((r101 instanceof GiftStateMachineConfig.h.a) == false) goto L62;
        r100.Bq(((GiftStateMachineConfig.h.a) r101).f127056a);
    L62:
        if ((r101 instanceof GiftStateMachineConfig.a.h) == false) goto L65;
        r100.Cq(AbsPanel.GiftPanelSelectType.IDLE, false);
    L65:
        if ((r101 instanceof GiftStateMachineConfig.a.e) == false) goto L67;
    L68:
        GiftStateMachineConfig.a r120 = (GiftStateMachineConfig.a) r101;
        AbsPanel<?> r121 = r120.a();
        if ((r120 instanceof GiftStateMachineConfig.a.e) == false) goto L72;
        r102 = ((GiftStateMachineConfig.a.e) r120).f127031b;
    L72:
        if (r100.f132433d == null) goto L82;
        if (r121 == null) goto L75;
        Long r122 = Long.valueOf(r121.c());
    L76:
        AbsPanel<?> r123 = r100.f132433d;
        if (r123 == null) goto L80;
        r103 = Long.valueOf(r123.c());
    L80:
        if ((!Intrinsics.areEqual(r122, r103)) == false) goto L82;
        r100.Cq(AbsPanel.GiftPanelSelectType.IDLE, r102);
        goto L82
    L75:
        r122 = null;
    L82:
        r100.f132433d = r121;
        if (r121 == null) goto L99;
        AbsPanel.GiftPanelSelectType r124 = r121.f126616d;
        if (r124 == null) goto L100;
        r100.Cq(r124, r102);
        return;
    L100:
        return;
    L99:
        return;
    L67:
        if ((r101 instanceof GiftStateMachineConfig.a.g) == true) goto L68;
        return;
    }

    public final void Cq(AbsPanel.GiftPanelSelectType r100, boolean r101) {
        AbsPanel<?> r102 = this.f132433d;
        if (r102 == null) goto L113;
        VSGiftDialogAdapterNew r103 = Aq();
        if (r103 == null) goto L114;
        AbsPanel<?> r104 = r103.z2(r102.c());
        if (r104 == null) goto L117;
        r104.f126616d = r100;
        VSGiftDialogAdapterNew r105 = Aq();
        if (r105 == null) goto L115;
        Intrinsics.checkNotNullParameter(r104, "panel");
        int r106 = ((ArrayList) r105.f132342a).indexOf(r104);
        if (r101 == true) goto L109;
        RecyclerView.LayoutManager r107 = null;
        Integer r108 = null;
        r108 = null;
        if (r100 != AbsPanel.GiftPanelSelectType.NORMAL_SELECTED) goto L79;
        RecyclerView r109 = zq();
        if (r109 == null) goto L18;
        RecyclerView.LayoutManager r110 = r109.getLayoutManager();
    L20:
        if ((r110 instanceof LinearLayoutManager) == false) goto L75;
        View r111 = r110.findViewByPosition(r106);
        if (r111 == null) goto L109;
        if (r106 >= ((LinearLayoutManager) r110).findFirstCompletelyVisibleItemPosition()) goto L43;
        if (this.f132440k.getIsVertical() == false) goto L29;
    L34:
        boolean r112 = true;
    L35:
        if (r112 == false) goto L39;
        RecyclerView r113 = zq();
        if (r113 == null) goto L109;
        r113.smoothScrollBy(0, (r111.getBottom() - r111.getHeight()) - i.b(1));
        goto L109
    L39:
        RecyclerView r114 = zq();
        if (r114 == null) goto L109;
        r114.smoothScrollBy(0, (r111.getBottom() - r111.getHeight()) - i.b(2));
        goto L109
    L29:
        if (PadConfigUtils.c() == true) goto L34;
        if (com.bytedance.android.livesdk.gift.util.a.a() == true) goto L34;
        r112 = false;
        goto L35
    L43:
        if (this.f132440k.getIsVertical() == false) goto L45;
    L50:
        boolean r115 = true;
    L51:
        if (r115 == true) goto L58;
        if (r111.getBottom() <= yq()) goto L109;
        RecyclerView r116 = zq();
        if (r116 == null) goto L109;
        r116.smoothScrollBy(0, (r111.getBottom() - yq()) + i.b(38));
        goto L109
    L58:
        if (((Boolean) y12.b.f565622b.getValue(null, y12.b.f565621a[0])).booleanValue() == false) goto L71;
        ViewPager r117 = this.f132431b;
        if (r117 == null) goto L64;
        ViewGroup.LayoutParams r118 = r117.getLayoutParams();
        if (r118 == null) goto L64;
        r108 = Integer.valueOf(r118.height);
    L64:
        if (r108 == null) goto L109;
        if (r111.getBottom() <= r108.intValue()) goto L109;
        RecyclerView r119 = zq();
        if (r119 == null) goto L109;
        r119.smoothScrollBy(0, r111.getBottom() - r108.intValue());
        goto L109
    L71:
        if (r111.getBottom() <= yq()) goto L109;
        RecyclerView r120 = zq();
        if (r120 == null) goto L109;
        r120.smoothScrollBy(0, r111.getBottom() - yq());
        goto L109
    L45:
        if (PadConfigUtils.c() == true) goto L50;
        if (com.bytedance.android.livesdk.gift.util.a.a() == true) goto L50;
        r115 = false;
        goto L51
    L75:
        RecyclerView r121 = zq();
        if (r121 == null) goto L109;
        r121.scrollToPosition(r106);
        goto L109
    L18:
        r110 = null;
        goto L20
    L79:
        if (r100 != AbsPanel.GiftPanelSelectType.IDLE) goto L81;
        this.f132433d = null;
        goto L109
    L81:
        if (zq() != null) goto L83;
        this.f132432c.f132350c.put(Integer.valueOf(com.bytedance.android.livesdk.gift.vs.panel.statemachine.helper.b.f()), Integer.valueOf(r106));
        goto L109
    L83:
        RecyclerView r122 = zq();
        if (r122 == null) goto L87;
        r107 = r122.getLayoutManager();
    L87:
        if ((r107 instanceof LinearLayoutManager) == false) goto L105;
        LinearLayoutManager r123 = (LinearLayoutManager) r107;
        int r124 = r123.findFirstCompletelyVisibleItemPosition();
        int r125 = r123.findLastCompletelyVisibleItemPosition();
        if (r124 > r106) goto L92;
        if (r125 >= r106) goto L105;
    L92:
        if (((n) com.bytedance.android.livesdk.gift.util.b.a().d(n.class)).e() != 1) goto L94;
        boolean r126 = true;
    L95:
        if (r126 == true) goto L97;
    L103:
        r123.scrollToPositionWithOffset(r106, i.b(2));
    L104:
        Eq(com.bytedance.android.livesdk.gift.vs.panel.statemachine.helper.b.f(), false);
        goto L109
    L97:
        if (this.f132440k.getIsVertical() == false) goto L99;
    L102:
        r123.scrollToPositionWithOffset(r106, i.b(1));
        goto L104
    L99:
        if (PadConfigUtils.c() == true) goto L102;
        if (com.bytedance.android.livesdk.gift.util.a.a() == false) goto L103;
    L94:
        r126 = false;
    L105:
        RecyclerView r127 = zq();
        if (r127 == null) goto L109;
        r127.scrollToPosition(r106);
    L109:
        VSGiftDialogAdapterNew r128 = Aq();
        if (r128 == null) goto L116;
        r128.notifyItemRangeChanged(r106, 1);
        return;
    L116:
        return;
    L115:
        return;
    L117:
        return;
    L114:
        return;
    }

    public final void Eq(int r100, boolean r101) {
        ViewPager r102 = this.f132431b;
        if (r102 == null) goto L5;
        RecyclerView r103 = (RecyclerView) r102.findViewWithTag(Integer.valueOf(r100));
    L6:
        if (r103 == null) goto L9;
        this.f132432c.l(r103, r100, r101, false);
        return;
    L9:
        return;
    L5:
        r103 = null;
        goto L6
    }
}
