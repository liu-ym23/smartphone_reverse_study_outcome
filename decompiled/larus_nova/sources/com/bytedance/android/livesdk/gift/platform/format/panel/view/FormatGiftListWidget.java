package com.bytedance.android.livesdk.gift.platform.format.panel.view;

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
import com.bytedance.android.livesdk.gift.platform.format.panel.adapter.FormatGiftDialogAdapter;
import com.bytedance.android.livesdk.gift.platform.format.panel.adapter.FormatGiftDialogViewPagerAdapter;
import com.bytedance.android.livesdk.gift.platform.format.panel.statemachine.FormatGiftListViewModel;
import com.bytedance.android.livesdk.gift.platform.format.panel.statemachine.FormatGiftPanelDialogViewModel;
import com.bytedance.android.livesdk.gift.platform.format.panel.statemachine.FormatGiftTabViewModel;
import com.bytedance.android.livesdk.gift.platform.format.panel.viewholder.FormatGiftDialogViewHolder;
import com.bytedance.android.livesdk.gift.platform.format.panel.viewmodel.FormatGiftDialogViewModel;
import com.bytedance.android.livesdk.padutils.PadConfigUtils;
import com.bytedance.android.scope.m;
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
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/livesdk/gift/platform/format/panel/view/FormatGiftListWidget;", "Lcom/bytedance/android/live/core/tetris/widgets/LiveRecyclableWidget;", "livegift-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class FormatGiftListWidget extends LiveRecyclableWidget {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final CompositeDisposable f132176a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ViewPager f132177b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final FormatGiftDialogViewPagerAdapter f132178c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public AbsPanel<?> f132179d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f132180e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public ImageView f132181f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f132182g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public Disposable f132183h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final FormatGiftListWidget$pageChangeListener$1 f132184i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final GiftViewModelManager f132185j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final FormatGiftDialogViewModel f132186k;

    public static final class a<T> implements Observer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ FormatGiftListWidget f132187a;

        public a(FormatGiftListWidget r100) {
            this.f132187a = r100;
        }

        @Override // androidx.lifecycle.Observer
        public final void onChanged(Object r100) {
            z3 r101 = (z3) r100;
            FormatGiftListWidget r102 = this.f132187a;
            AbsPanel<?> r103 = r102.f132179d;
            if (r103 == null) goto L24;
            FormatGiftDialogAdapter r104 = r102.Aq();
            if (r104 == null) goto L25;
            AbsPanel<?> r105 = r104.z2(r103.c());
            if (r105 == null) goto L28;
            FormatGiftDialogAdapter r106 = r102.Aq();
            if (r106 == null) goto L26;
            Intrinsics.checkNotNullParameter(r105, "panel");
            int r107 = ((ArrayList) r106.f132096a).indexOf(r105);
            RecyclerView r108 = r102.zq();
            String r109 = null;
            if (r108 == null) goto L14;
            RecyclerView.ViewHolder r110 = r108.findViewHolderForAdapterPosition(r107);
        L16:
            if ((r110 instanceof FormatGiftDialogViewHolder) == true) goto L18;
            r110 = null;
        L18:
            FormatGiftDialogViewHolder r111 = (FormatGiftDialogViewHolder) r110;
            if (r111 == null) goto L27;
            if (r101 == null) goto L22;
            r109 = r101.a();
        L22:
            r111.d4().g(r109);
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
        public final /* synthetic */ FormatGiftListWidget f132188a;

        public b(FormatGiftListWidget r100) {
            this.f132188a = r100;
        }

        @Override // androidx.lifecycle.Observer
        public final void onChanged(Object r100) {
            FormatGiftListWidget r101 = this.f132188a;
            FormatGiftListWidget.xq(r101, (GiftStateMachineConfig.g) r100);
        }
    }

    public static final class c<T> implements Observer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ FormatGiftListWidget f132189a;

        public c(FormatGiftListWidget r100) {
            this.f132189a = r100;
        }

        @Override // androidx.lifecycle.Observer
        public final void onChanged(Object r100) {
            FormatGiftListWidget r101 = this.f132189a;
            FormatGiftListWidget.xq(r101, (GiftStateMachineConfig.g) r100);
        }
    }

    public static final class d<T> implements Observer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ FormatGiftListWidget f132190a;

        public d(FormatGiftListWidget r100) {
            this.f132190a = r100;
        }

        @Override // androidx.lifecycle.Observer
        public final void onChanged(Object r100) {
            FormatGiftListWidget r101 = this.f132190a;
            FormatGiftListWidget.xq(r101, (GiftStateMachineConfig.g) r100);
        }
    }

    public final FormatGiftDialogAdapter Aq() {
        Map<Integer, FormatGiftDialogAdapter> r100 = this.f132178c.f132105d;
        LinkedHashMap r101 = (LinkedHashMap) r100;
        return (FormatGiftDialogAdapter) r101.get(Integer.valueOf(com.bytedance.android.livesdk.gift.platform.format.panel.statemachine.helper.b.c()));
    }

    @Override // com.bytedance.android.live.core.tetris.widgets.LiveWidget, com.bytedance.ies.sdk.widgets.Widget
    public final void onPause() {
        this.f132178c.g(zq());
        super.onPause();
    }

    public final RecyclerView zq() {
        ViewPager r100 = this.f132177b;
        if (r100 != null) goto L7;
        return null;
    L7:
        return (RecyclerView) r100.findViewWithTag(Integer.valueOf(com.bytedance.android.livesdk.gift.platform.format.panel.statemachine.helper.b.c()));
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
        this.f132178c.h(zq());
    }

    @Override // com.bytedance.android.live.core.tetris.widgets.LiveRecyclableWidget
    public final void onUnload() {
        com.bytedance.android.livesdk.gift.util.b.e(this);
        this.f132176a.clear();
        Disposable r100 = this.f132183h;
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
        ViewPager r101 = this.f132177b;
        if (r101 == null) goto L19;
        Iterator r102 = ((ArrayList) this.f132178c.f132103b).iterator();
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
        if (r100 == null) goto L36;
        FormatGiftDialogViewPagerAdapter r101 = this.f132178c;
        Context r102 = this.context;
        r101.getClass();
        Intrinsics.checkNotNullParameter(r102, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r100, "pages");
        ArrayList r103 = new ArrayList();
        Iterator<T> r104 = r100.iterator();
    L6:
        if (r104.hasNext() == false) goto L15;
        Object r105 = r104.next();
        w1 r106 = (w1) r105;
        if (r106.getDisplay() == true) goto L10;
    L12:
        boolean r107 = false;
    L13:
        if (r107 == false) goto L6;
        r103.add(r105);
        goto L6
    L10:
        if (r106.getPageType() != 1) goto L12;
        r107 = true;
        goto L13
    L15:
        ((ArrayList) r101.f132103b).clear();
        ((ArrayList) r101.f132103b).addAll(r103);
        Iterator r108 = ((LinkedHashMap) r101.f132105d).entrySet().iterator();
    L17:
        if (r108.hasNext() == false) goto L25;
        Map.Entry r109 = (Map.Entry) r108.next();
        List<w1> r110 = r101.f132103b;
        ArrayList r111 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r110, 10));
        Iterator r112 = ((ArrayList) r110).iterator();
    L20:
        if (r112.hasNext() == false) goto L23;
        r111.add(Integer.valueOf(((w1) r112.next()).getPageType()));
        goto L20
    L23:
        if (r111.contains(r109.getKey()) == true) goto L17;
        r108.remove();
        goto L17
    L25:
        r101.notifyDataSetChanged();
        Iterator r113 = r103.iterator();
    L27:
        if (r113.hasNext() == false) goto L34;
        w1 r114 = (w1) r113.next();
        if (r101.f132105d.containsKey(Integer.valueOf(r114.getPageType())) == true) goto L31;
        r101.f132105d.put(Integer.valueOf(r114.getPageType()), new FormatGiftDialogAdapter(r102, r101.f132115n));
    L31:
        FormatGiftDialogAdapter r115 = (FormatGiftDialogAdapter) ((LinkedHashMap) r101.f132105d).get(Integer.valueOf(r114.getPageType()));
        if (r115 == null) goto L27;
        r115.y2(com.bytedance.android.livesdk.gift.platform.format.panel.statemachine.helper.b.l(r114.getPageType()));
        goto L27
    L34:
        r101.notifyDataSetChanged();
        this.f132178c.f(this.context, com.bytedance.android.livesdk.gift.platform.format.panel.statemachine.helper.b.c());
    L36:
        if ((!com.bytedance.android.livesdk.gift.platform.format.panel.statemachine.helper.b.l(com.bytedance.android.livesdk.gift.platform.format.panel.statemachine.helper.b.c()).isEmpty()) == false) goto L57;
        ImageView r116 = this.f132181f;
        if (r116 == null) goto L58;
        r116.setVisibility(8);
        return;
    L58:
        return;
    }

    @Override // com.bytedance.android.live.core.tetris.widgets.LiveRecyclableWidget
    public final void onInit(Object[] r100) {
        this.f132177b = (ViewPager) findViewById(R.id.view_pager);
        this.f132181f = (ImageView) findViewById(R.id.no_data_view);
    }

    @Override // com.bytedance.android.live.core.tetris.widgets.LiveRecyclableWidget
    public final void onLoad(Object[] r100) {
        ViewPager r101 = this.f132177b;
        if (r101 == null) goto L5;
        r101.setAdapter(this.f132178c);
    L5:
        ViewPager r102 = this.f132177b;
        if (r102 == null) goto L8;
        r102.addOnPageChangeListener(this.f132184i);
    L8:
        int r103 = ((Number) com.bytedance.android.livesdk.gift.util.b.a().c(GiftConfigKey.KEY_GIFT_LIST_EMPTY_ICON, Integer.valueOf(R.drawable.ttlive_empty_content_dark))).intValue();
        ImageView r104 = this.f132181f;
        if (r104 == null) goto L11;
        r104.setImageResource(r103);
    L11:
        FormatGiftDialogViewModel r105 = this.f132186k;
        if (r105 == null) goto L16;
        MutableLiveData<z3> r106 = r105.getInfo();
        if (r106 == null) goto L16;
        r106.observe(this, new a(this));
    L16:
        b r107 = new b(this);
        q12.a r108 = q12.b.f531284a;
        GiftStateMachineConfig.g r109 = null;
        if (r108 == null) goto L19;
        Object r110 = m.f163449e.d(r108, FormatGiftListViewModel.class);
    L20:
        com.bytedance.android.livesdk.gift.platform.business.dialog.v2.viewmodel.a r111 = (com.bytedance.android.livesdk.gift.platform.business.dialog.v2.viewmodel.a) r110;
        if (r111 == null) goto L23;
        GiftStateMachineConfig.g r112 = r111.c(this, r107);
    L24:
        if (r112 == null) goto L26;
        r107.onChanged(r112);
    L26:
        c r113 = new c(this);
        q12.a r114 = q12.b.f531284a;
        if (r114 == null) goto L29;
        Object r115 = m.f163449e.d(r114, FormatGiftTabViewModel.class);
    L30:
        com.bytedance.android.livesdk.gift.platform.business.dialog.v2.viewmodel.a r116 = (com.bytedance.android.livesdk.gift.platform.business.dialog.v2.viewmodel.a) r115;
        if (r116 == null) goto L33;
        GiftStateMachineConfig.g r117 = r116.c(this, r113);
    L34:
        if (r117 == null) goto L36;
        r113.onChanged(r117);
    L36:
        d r118 = new d(this);
        q12.a r119 = q12.b.f531284a;
        if (r119 == null) goto L39;
        Object r120 = m.f163449e.d(r119, FormatGiftPanelDialogViewModel.class);
    L40:
        com.bytedance.android.livesdk.gift.platform.business.dialog.v2.viewmodel.a r121 = (com.bytedance.android.livesdk.gift.platform.business.dialog.v2.viewmodel.a) r120;
        if (r121 == null) goto L43;
        r109 = r121.c(this, r118);
    L43:
        if (r109 == null) goto L45;
        r118.onChanged(r109);
    L45:
        View r122 = findViewById(R.id.mask_view);
        if (r122 == null) goto L48;
        r122.setVisibility(8);
    L48:
        View r123 = findViewById(R.id.mask_view_bottom);
        if (r123 == null) goto L51;
        r123.setVisibility(8);
    L51:
        int r124 = s1.f(5.0f);
        View r125 = this.contentView;
        r125.setPadding(r125.getPaddingLeft(), r124, this.contentView.getPaddingRight(), this.contentView.getPaddingBottom());
        return;
    L39:
        r120 = null;
        goto L40
    L33:
        r117 = null;
        goto L34
    L29:
        r115 = null;
        goto L30
    L23:
        r112 = null;
        goto L24
    L19:
        r110 = null;
        goto L20
    }

    /* JADX WARN: Type inference failed for: r2v1, types: [com.bytedance.android.livesdk.gift.platform.format.panel.view.FormatGiftListWidget$pageChangeListener$1] */
    public FormatGiftListWidget(GiftViewModelManager r100, FormatGiftDialogViewModel r101) {
        Intrinsics.checkNotNullParameter(r100, "mViewModel");
        this.f132185j = r100;
        this.f132186k = r101;
        this.f132176a = new CompositeDisposable();
        this.f132178c = new FormatGiftDialogViewPagerAdapter(r100, r101);
        this.f132184i = new FormatGiftListWidget$pageChangeListener$1(this);
    }

    public static final HashMap wq(FormatGiftListWidget r100, int r101) {
        ViewPager r102 = r100.f132177b;
        if (r102 == null) goto L7;
        RecyclerView r103 = (RecyclerView) r102.findViewWithTag(Integer.valueOf(r101));
        if (r103 == null) goto L7;
        RecyclerView.LayoutManager r104 = r103.getLayoutManager();
    L8:
        List<AbsPanel<?>> r105 = com.bytedance.android.livesdk.gift.platform.format.panel.statemachine.helper.b.l(r101);
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
        IntRange r115 = (IntRange) ((LinkedHashMap) r100.f132178c.f132109h).get(Integer.valueOf(r101));
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

    public static final void xq(FormatGiftListWidget r100, GiftStateMachineConfig.g r101) {
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
        ViewPager r110 = r100.f132177b;
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
        r100.Bq(com.bytedance.android.livesdk.gift.platform.format.panel.statemachine.helper.b.c());
        goto L35
    L28:
        r112 = false;
    L35:
        if (r100.zq() == null) goto L38;
        r100.Eq(com.bytedance.android.livesdk.gift.platform.format.panel.statemachine.helper.b.c(), false);
    L38:
        if (r100.zq() != null) goto L45;
        Disposable r113 = r100.f132183h;
        if (r113 != null) goto L42;
    L43:
        j.a r114 = j.f66356a;
        r100.f132183h = j.c(200, TimeUnit.MILLISECONDS).observeOn(AndroidSchedulers.mainThread()).subscribe(new s12.d(r100));
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
        if (r100.f132179d == null) goto L82;
        if (r121 == null) goto L75;
        Long r122 = Long.valueOf(r121.c());
    L76:
        AbsPanel<?> r123 = r100.f132179d;
        if (r123 == null) goto L80;
        r103 = Long.valueOf(r123.c());
    L80:
        if ((!Intrinsics.areEqual(r122, r103)) == false) goto L82;
        r100.Cq(AbsPanel.GiftPanelSelectType.IDLE, r102);
        goto L82
    L75:
        r122 = null;
    L82:
        r100.f132179d = r121;
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
        AbsPanel<?> r102 = this.f132179d;
        if (r102 == null) goto L113;
        FormatGiftDialogAdapter r103 = Aq();
        if (r103 == null) goto L114;
        AbsPanel<?> r104 = r103.z2(r102.c());
        if (r104 == null) goto L117;
        r104.f126616d = r100;
        FormatGiftDialogAdapter r105 = Aq();
        if (r105 == null) goto L115;
        Intrinsics.checkNotNullParameter(r104, "panel");
        int r106 = ((ArrayList) r105.f132096a).indexOf(r104);
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
        if (this.f132185j.getIsVertical() == false) goto L29;
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
        if (this.f132185j.getIsVertical() == false) goto L45;
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
        ViewPager r117 = this.f132177b;
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
        this.f132179d = null;
        goto L109
    L81:
        if (zq() != null) goto L83;
        this.f132178c.f132104c.put(Integer.valueOf(com.bytedance.android.livesdk.gift.platform.format.panel.statemachine.helper.b.c()), Integer.valueOf(r106));
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
        Eq(com.bytedance.android.livesdk.gift.platform.format.panel.statemachine.helper.b.c(), false);
        goto L109
    L97:
        if (this.f132185j.getIsVertical() == false) goto L99;
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
        FormatGiftDialogAdapter r128 = Aq();
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
        ViewPager r102 = this.f132177b;
        if (r102 == null) goto L5;
        RecyclerView r103 = (RecyclerView) r102.findViewWithTag(Integer.valueOf(r100));
    L6:
        if (r103 == null) goto L9;
        this.f132178c.l(r103, r100, r101, false);
        return;
    L9:
        return;
    L5:
        r103 = null;
        goto L6
    }
}
