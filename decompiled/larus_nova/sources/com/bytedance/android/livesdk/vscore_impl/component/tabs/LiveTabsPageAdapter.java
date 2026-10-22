package com.bytedance.android.livesdk.vscore_impl.component.tabs;

import android.content.Context;
import android.util.LongSparseArray;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.baidu.platform.comapi.map.MapController;
import com.bytedance.android.annie.api.container.FragmentCustomMonitorKey;
import com.bytedance.android.annie.api.container.HybridFragment;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.tetris.widgets.RecyclableWidgetManager;
import com.bytedance.android.live.ktv.common.util.KtvSubElement;
import com.bytedance.android.livesdk.config.MultiTabConfig;
import com.bytedance.android.livesdk.vscore_impl.component.tabs.utils.TabTraceMonitor;
import com.bytedance.android.livesdk.widget.LiveFragmentStatePagerAdapter;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.Widget;
import com.bytedance.ies.sdk.widgets.api.WidgetService;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.ss.android.lark.utils.statistics.PerfLog;
import io.reactivex.disposables.CompositeDisposable;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\u0018\u00002\u00020\u00012\u00020\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/livesdk/vscore_impl/component/tabs/LiveTabsPageAdapter;", "Lcom/bytedance/android/livesdk/widget/LiveFragmentStatePagerAdapter;", "", "vs-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LiveTabsPageAdapter extends LiveFragmentStatePagerAdapter {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f159847d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Map<Fragment, Pair<Integer, e>> f159848e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final LinkedHashMap<Long, Fragment> f159849f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final LinkedHashMap<Long, Fragment> f159850g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public CompositeDisposable f159851h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Map<Long, e> f159852i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final ArrayDeque<a> f159853j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final Map<Long, Boolean> f159854k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f159855l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public Function0<Unit> f159856m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final Context f159857n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final List<? extends e> f159858o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final DataCenter f159859p;

    @Override // androidx.viewpager.widget.PagerAdapter
    public final int getCount() {
        return this.f159858o.size();
    }

    public final void i() {
        if (this.f159853j.isEmpty() == false) goto L5;
        return;
    L5:
        a r100 = this.f159853j.pop();
        if (r100.f159940e == false) goto L9;
        ALogger.d(this.f159847d, "pre loadNextAnnie " + r100.f159952c + " skip");
        i();
        return;
    L9:
        h(r100.f159951b);
    }

    @Override // com.bytedance.android.livesdk.widget.LiveFragmentStatePagerAdapter
    public final String f(int r100) {
        if (r100 >= this.f159858o.size()) goto L8;
        if (r100 < 0) goto L8;
        return String.valueOf(((e) ListProtector.get(this.f159858o, r100)).f159951b);
    L8:
        return String.valueOf(r100);
    }

    @Override // com.bytedance.android.livesdk.widget.LiveFragmentStatePagerAdapter, androidx.viewpager.widget.PagerAdapter
    public final void finishUpdate(ViewGroup r100) {
        Intrinsics.checkNotNullParameter(r100, KtvSubElement.CONTAINER);
        super.finishUpdate(r100);
        Function0<Unit> r101 = this.f159856m;
        if (r101 == null) goto L6;
        Unit r102 = r101.invoke();
        return;
    }

    public final e g(long r100) {
        Map<Long, e> r101 = this.f159852i;
        LinkedHashMap r102 = (LinkedHashMap) r101;
        if (r102.get(Long.valueOf(r100)) == null) goto L5;
        Map<Long, e> r103 = this.f159852i;
        LinkedHashMap r104 = (LinkedHashMap) r103;
        return (e) r104.get(Long.valueOf(r100));
    L5:
        Iterator<T> r105 = this.f159858o.iterator();
    L7:
        if (r105.hasNext() == false) goto L14;
        Object r106 = r105.next();
        if (((e) r106).f159951b != r100) goto L11;
        boolean r107 = true;
    L12:
        if (r107 == false) goto L7;
    L15:
        e r108 = (e) r106;
        this.f159852i.put(Long.valueOf(r100), r108);
        return r108;
    L11:
        r107 = false;
        goto L12
    L14:
        r106 = null;
        goto L15
    }

    @Override // com.bytedance.android.livesdk.widget.LiveFragmentStatePagerAdapter
    public final Fragment getItem(int r100) {
        if (r100 < 0) goto L35;
        if (r100 >= this.f159858o.size()) goto L35;
        e r101 = (e) ListProtector.get(this.f159858o, r100);
        if ((r101 instanceof h0) == false) goto L29;
        ALogger.i(this.f159847d, "getItem WidgetPageTab[" + r101.f159952c + "] for position: " + r100);
        RecyclableWidgetManager r102 = null;
        vr1.u r103 = com.bytedance.android.livesdk.chatroom.vs_base.base.util.r.u(this.f159859p, null, 2);
        if (r103 == null) goto L14;
        com.bytedance.live.datacontext.n<RecyclableWidgetManager> r104 = r103.w0();
        if (r104 == null) goto L14;
        RecyclableWidgetManager r105 = r104.getValue();
        if (r105 == null) goto L14;
    L23:
        if (r105 == null) goto L25;
        int r106 = LiveTabWidgetFragment.f159842h;
        Class<? extends Widget> r107 = ((h0) r101).f159961d;
        Intrinsics.checkNotNullParameter(r105, "widgetManager");
        Intrinsics.checkNotNullParameter(r107, "widgetClass");
        return new LiveTabWidgetFragment(r105, r107);
    L25:
        return new LiveTabFragment();
    L14:
        nm1.x r108 = (nm1.x) pm1.h.f529822d.c(nm1.x.class);
        if (r108 == null) goto L17;
        RecyclableWidgetManager r109 = r108.a(this.f159859p);
    L19:
        if ((r109 instanceof RecyclableWidgetManager) == false) goto L22;
        r102 = r109;
    L22:
        r105 = r102;
        goto L23
    L17:
        r109 = null;
        goto L19
    L29:
        if ((r101 instanceof a) == false) goto L33;
        ALogger.i(this.f159847d, "getItem AnniePageTab[" + r101.f159952c + "] for position: " + r100);
        LiveTabFragment r110 = new LiveTabFragment();
        this.f159850g.put(Long.valueOf(r101.f159951b), r110);
        LongSparseArray<ArrayList<xu2.a.C8274a>> r111 = xu2.a.f565079a;
        xu2.a.a(com.bytedance.android.livesdk.chatroom.vs_base.util.h.e(this.f159859p).getRoomId(), TabTraceMonitor.MultitabLinkEvent.MultitabContainerInit, "tabId=" + r101.f159951b);
        this.f159853j.add((a) r101);
        return r110;
    L33:
        return new LiveTabFragment();
    L35:
        return new LiveTabFragment();
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public final int getItemPosition(Object r110) {
        Intrinsics.checkNotNullParameter(r110, MapController.ITEM_LAYER_TAG);
        Map<Fragment, Pair<Integer, e>> r100 = this.f159848e;
        if (r100 == null) goto L26;
        if (r100.containsKey(r110) == false) goto L7;
        Pair r101 = (Pair) ((LinkedHashMap) this.f159848e).get(r110);
    L9:
        if (r101 != null) goto L11;
        return -1;
    L11:
        e r102 = (e) r101.getSecond();
        int r103 = ((Number) r101.getFirst()).intValue();
        Iterator<T> r104 = this.f159858o.iterator();
        int r105 = -2;
        int r106 = 0;
    L13:
        if (r104.hasNext() == false) goto L21;
        Object r107 = r104.next();
        int r108 = r106 + 1;
        if (r106 >= 0) goto L18;
        CollectionsKt.throwIndexOverflow();
    L18:
        if (r102.f159951b != ((e) r107).f159951b) goto L20;
        r105 = r106;
    L20:
        r106 = r108;
        goto L13
    L21:
        Objects.toString(r110);
        if (r103 != r105) goto L24;
        return -1;
    L24:
        return r105;
    L7:
        r101 = null;
        goto L9
    L26:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.collections.Map<K, *>");
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public final CharSequence getPageTitle(int r100) {
        if (this.f159858o.size() > r100) goto L7;
        return "";
    L7:
        return ((e) ListProtector.get(this.f159858o, r100)).f159952c;
    }

    public final void h(long r110) {
        e r100 = g(r110);
        String r101 = this.f159847d;
        StringBuilder r102 = new StringBuilder("loadAnnieFragment for tabId#");
        r102.append(r110);
        r102.append(", title is [");
        if (r100 == null) goto L6;
        String r103 = r100.f159952c;
        if (r103 == null) goto L6;
    L7:
        r102.append(r103);
        r102.append(']');
        ALogger.i(r101, r102.toString());
        if (this.f159849f.get(Long.valueOf(r110)) == null) goto L10;
    L49:
        Fragment r104 = this.f159849f.get(Long.valueOf(r110));
        if (r104 != null) goto L52;
        return;
    L52:
        if ((r104 instanceof HybridFragment) == false) goto L62;
        List<? extends e> r105 = this.f159858o;
        if ((((e) ListProtector.get(r105, o.a(r110, r105))) instanceof a) == false) goto L59;
        Lazy r106 = MultiTabConfig.f119743a;
        if (MultiTabConfig.a.c() == false) goto L58;
        ((HybridFragment) r104).setCustomMonitorKey(FragmentCustomMonitorKey.IsPrerender, "1");
        ALogger.i(this.f159847d, "load annie = FragmentCustomMonitorKey.IsPrerender");
        goto L59
    L58:
        ((HybridFragment) r104).setCustomMonitorKey(FragmentCustomMonitorKey.IsContainerPreload, "1");
        ALogger.i(this.f159847d, "load annie = FragmentCustomMonitorKey.IsContainerPreload");
    L59:
        ALogger.i(this.f159847d, "load annie = FragmentCustomMonitorKey.IsUserOpen + FragmentCustomMonitorKey.RealOpenTime : " + System.currentTimeMillis());
        HybridFragment r107 = (HybridFragment) r104;
        r107.setCustomMonitorKey(FragmentCustomMonitorKey.IsUserOpen, "1");
        r107.setCustomMonitorKey(FragmentCustomMonitorKey.RealOpenTime, Long.valueOf(System.currentTimeMillis()));
        return;
    L62:
        return;
    L10:
        if (this.f159850g.get(Long.valueOf(r110)) == null) goto L49;
        e r108 = g(r110);
        String r109 = null;
        if (r108 == null) goto L40;
        if ((r108 instanceof a) == false) goto L40;
        Fragment r111 = this.f159850g.get(Long.valueOf(r108.f159951b));
        if (this.f159849f.get(Long.valueOf(r108.f159951b)) == null) goto L31;
        if (r111 == null) goto L31;
        if ((r111 instanceof LiveTabFragment) == false) goto L31;
        Fragment r112 = this.f159849f.get(Long.valueOf(r108.f159951b));
        if (r112 == null) goto L31;
        if (r112.isAdded() != true) goto L31;
        Fragment r113 = this.f159849f.get(Long.valueOf(r108.f159951b));
        if (r113 == null) goto L28;
        String r114 = r113.getTag();
    L29:
        if (r114 == null) goto L31;
        LongSparseArray<ArrayList<xu2.a.C8274a>> r115 = xu2.a.f565079a;
        xu2.a.a(com.bytedance.android.livesdk.chatroom.vs_base.util.h.e(this.f159859p).getRoomId(), TabTraceMonitor.MultitabLinkEvent.MultitabContainerAddHybridAlreadyExist, "tabId=" + r108.f159951b);
        goto L40
    L28:
        r114 = null;
    L31:
        a r116 = (a) r108;
        HybridFragment r117 = fq1.f.a().getHybridFragment(this.f159857n, r116.f159939d, new i(this, r116, System.currentTimeMillis()));
        if (r117 == null) goto L34;
        this.f159849f.put(Long.valueOf(r116.f159951b), r117);
    L34:
        LongSparseArray<ArrayList<xu2.a.C8274a>> r118 = xu2.a.f565079a;
        xu2.a.a(com.bytedance.android.livesdk.chatroom.vs_base.util.h.e(this.f159859p).getRoomId(), TabTraceMonitor.MultitabLinkEvent.MultitabHybridfragmentInit, null);
        if (r117 == null) goto L40;
        if ((r111 instanceof LiveTabFragment) == false) goto L40;
        this.f159849f.put(Long.valueOf(r108.f159951b), r117);
        ((LiveTabFragment) r111).S90(r117);
        ALogger.i(this.f159847d, "add AnnieFragment to container for tabId#" + r110 + ", title is [" + r108.f159952c + ']');
        long r119 = com.bytedance.android.livesdk.chatroom.vs_base.util.h.e(this.f159859p).getRoomId();
        TabTraceMonitor.MultitabLinkEvent r120 = TabTraceMonitor.MultitabLinkEvent.MultitabContainerAddHybrid;
        StringBuilder r121 = new StringBuilder("tabId=");
        r121.append(r108.f159951b);
        xu2.a.a(r119, r120, r121.toString());
        ALogger.d("livesdk_live_tab_load_status start id", String.valueOf(r108.f159951b));
        int r122 = TabLogHelper.f159919a;
        TabLogHelper.LoadStatus r123 = TabLogHelper.LoadStatus.START;
        DataCenter r124 = this.f159859p;
        Intrinsics.checkNotNullParameter(r123, "loadStatus");
        TabLogHelper.a(r123, r124, null);
        this.f159854k.put(Long.valueOf(r108.f159951b), Boolean.FALSE);
    L40:
        if (CollectionsKt.contains(this.f159853j, r100) == false) goto L49;
        ArrayDeque<a> r125 = this.f159853j;
        if (r125 == null) goto L48;
        TypeIntrinsics.asMutableCollection(r125).remove(r100);
        String r126 = this.f159847d;
        StringBuilder r127 = new StringBuilder("remove pageTab#[");
        if (r100 == null) goto L46;
        r109 = r100.f159952c;
    L46:
        r127.append(r109);
        r127.append("] from queue");
        ALogger.i(r126, r127.toString());
        goto L49
    L48:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.collections.MutableCollection<T>");
    L6:
        r103 = "";
        goto L7
    }

    public final void j(Long r100) {
        ALogger.i(this.f159847d, "removeFragment tagid = " + r100);
        if (r100 == null) goto L12;
        Iterator<Map.Entry<Long, Fragment>> r101 = this.f159850g.entrySet().iterator();
    L6:
        if (r101.hasNext() == false) goto L20;
        Map.Entry<Long, Fragment> r102 = r101.next();
        if (r102.getKey().longValue() == r100.longValue()) goto L6;
        Fragment r103 = r102.getValue();
        if ((r103 instanceof LiveTabFragment) == false) goto L6;
        ALogger.i(this.f159847d, "removeFragment withid tagid = " + r102.getKey().longValue());
        ((LiveTabFragment) r103).T90();
        this.f159849f.remove(r102.getKey());
        goto L6
    L20:
        return;
    }

    @Override // com.bytedance.android.livesdk.widget.LiveFragmentStatePagerAdapter, androidx.viewpager.widget.PagerAdapter
    public final Object instantiateItem(ViewGroup r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, KtvSubElement.CONTAINER);
        Object r102 = super.instantiateItem(r100, r101);
        if ((r102 instanceof Fragment) == true) goto L5;
    L8:
        return r102;
    L5:
        if (r101 >= this.f159858o.size()) goto L8;
        if (r101 < 0) goto L8;
        e r103 = (e) ListProtector.get(this.f159858o, r101);
        this.f159848e.put((Fragment) r102, new Pair(Integer.valueOf(r101), r103));
        Objects.toString(r102);
        Objects.toString(r103);
        goto L8
    }

    @Override // com.bytedance.android.livesdk.widget.LiveFragmentStatePagerAdapter, androidx.viewpager.widget.PagerAdapter
    public final void destroyItem(ViewGroup r100, int r101, Object r102) {
        Intrinsics.checkNotNullParameter(r100, KtvSubElement.CONTAINER);
        Intrinsics.checkNotNullParameter(r102, WidgetService.PARAM_FRAGMENT);
        if ((r102 instanceof Fragment) == false) goto L5;
        this.f159848e.remove(r102);
        Objects.toString(r102);
    L5:
        super.destroyItem(r100, r101, r102);
    }

    public final void k(Long r100, String r101, JSONObject r102) {
        Intrinsics.checkNotNullParameter(r101, "eventName");
        Intrinsics.checkNotNullParameter(r102, "jsonData");
        if (r100 == null) goto L8;
        r100.longValue();
        Fragment r103 = this.f159849f.get(r100);
        if ((r103 instanceof HybridFragment) == false) goto L9;
        ((HybridFragment) r103).sendJsEvent(r101, r102);
        return;
    L9:
        return;
    }

    public LiveTabsPageAdapter(FragmentManager r100, Context r101, List<? extends e> r102, DataCenter r103) {
        Intrinsics.checkNotNullParameter(r100, "fm");
        Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r102, "data");
        Intrinsics.checkNotNullParameter(r103, "dataCenter");
        super(r100);
        this.f159857n = r101;
        this.f159858o = r102;
        this.f159859p = r103;
        this.f159847d = "LiveMultiTab";
        this.f159848e = new LinkedHashMap();
        this.f159849f = new LinkedHashMap();
        this.f159850g = new LinkedHashMap();
        this.f159851h = new CompositeDisposable();
        this.f159852i = new LinkedHashMap();
        this.f159853j = new ArrayDeque();
        this.f159854k = new LinkedHashMap();
    }
}
