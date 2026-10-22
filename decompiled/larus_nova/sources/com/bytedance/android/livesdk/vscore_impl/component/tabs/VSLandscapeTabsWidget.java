package com.bytedance.android.livesdk.vscore_impl.component.tabs;

import android.net.Uri;
import android.util.LongSparseArray;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.matchroom.MatchRoomLandScapeAnimUtil;
import com.bytedance.android.livesdk.padutils.PadConfigUtils;
import com.bytedance.android.livesdk.vscore_impl.component.tabs.utils.TabSlardarMonitor;
import com.bytedance.android.livesdk.vscore_impl.component.tabs.utils.TabTeaMonitor;
import com.bytedance.android.livesdk.vscore_impl.component.tabs.utils.TabTraceMonitor;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.RoomKt;
import com.bytedance.android.livesdkapi.depend.model.live.episode.EpisodeExtraInfo;
import com.bytedance.android.livesdkapi.depend.model.live.matchroom.IMatchRoomInfo;
import com.bytedance.android.livesdkapi.depend.model.live.vs.MultiTab;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.mt.protector.impl.UriProtector;
import com.larus.nova.R;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/livesdk/vscore_impl/component/tabs/VSLandscapeTabsWidget;", "Lcom/bytedance/android/livesdk/vscore_impl/component/tabs/LiveTabsWidget;", "vs-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class VSLandscapeTabsWidget extends LiveTabsWidget {

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final int f159922t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public Disposable f159923u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public CompositeDisposable f159924v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public boolean f159925w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final Fragment f159926x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final Long f159927y;

    @Override // com.bytedance.android.livesdk.vscore_impl.component.tabs.LiveTabsWidget, com.bytedance.ies.sdk.widgets.Widget
    public final int getLayoutId() {
        return R.layout.ttlive_multitab_landscape_dialog;
    }

    @Override // com.bytedance.android.livesdk.vscore_impl.component.tabs.LiveTabsWidget
    public final w Iq() {
        return new g(this.dataCenter);
    }

    @Override // com.bytedance.android.livesdk.vscore_impl.component.tabs.LiveTabsWidget
    public final List<MultiTab.TabItem> yq() {
        LongSparseArray<ArrayList<xu2.a.C8274a>> r100 = xu2.a.f565079a;
        DataCenter r101 = this.dataCenter;
        if (r101 == null) goto L7;
        IRoom r102 = lu2.c.f(r101);
        if (r102 == null) goto L7;
        long r103 = r102.getRoomId();
    L8:
        xu2.a.a(r103, TabTraceMonitor.MultitabLinkEvent.MultitabLoadDataInit, null);
        ArrayList r104 = new ArrayList();
        DataCenter r105 = this.dataCenter;
        if (r105 == null) goto L30;
        IRoom r106 = lu2.c.f(r105);
        if (r106 == null) goto L30;
        EpisodeExtraInfo r107 = lu2.c.a(r106);
        if (r107 == null) goto L30;
        MultiTab r108 = r107.getMultiTab();
        if (r108 == null) goto L30;
        List<MultiTab.TabItem> r109 = r108.getValidTabs();
        if (r109 == null) goto L30;
        Iterator<T> r110 = r109.iterator();
    L20:
        if (r110.hasNext() == false) goto L30;
        MultiTab.TabItem r111 = (MultiTab.TabItem) r110.next();
        if (r111.getTabType() != 3) goto L20;
        nm1.m r112 = com.bytedance.android.livesdk.chatroom.vs_base.base.util.s.g();
        DataCenter r113 = this.dataCenter;
        if (r113 == null) goto L26;
        IRoom r114 = lu2.c.f(r113);
    L28:
        if (r112.s(r114, this.dataCenter).contains(Long.valueOf(r111.getTabId())) == true) goto L20;
        r104.add(r111);
        goto L20
    L26:
        r114 = null;
    L30:
        return r104;
    L7:
        r103 = 0;
        goto L8
    }

    @Override // com.bytedance.android.livesdk.vscore_impl.component.tabs.LiveTabsWidget, com.bytedance.android.live.core.tetris.widgets.LiveRecyclableWidget
    public final void onUnload() {
        super.onUnload();
        Disposable r100 = this.f159923u;
        if (r100 != null) goto L5;
    L10:
        CompositeDisposable r101 = this.f159924v;
        if (r101 != null) goto L13;
        return;
    L13:
        if (r101.isDisposed() == true) goto L20;
        CompositeDisposable r102 = this.f159924v;
        if (r102 == null) goto L17;
        r102.dispose();
    L17:
        this.f159924v = null;
        return;
    L20:
        return;
    L5:
        if (r100.isDisposed() == true) goto L10;
        Disposable r103 = this.f159923u;
        if (r103 == null) goto L9;
        r103.dispose();
    L9:
        this.f159923u = null;
        goto L10
    }

    @Override // com.bytedance.android.livesdk.vscore_impl.component.tabs.LiveTabsWidget
    public final Long Aq() {
        return this.f159927y;
    }

    @Override // com.bytedance.android.livesdk.vscore_impl.component.tabs.LiveTabsWidget
    public final Fragment Gq() {
        return this.f159926x;
    }

    public static final void Yq(VSLandscapeTabsWidget r100) {
        r100.Bq(0);
        DataCenter r101 = r100.dataCenter;
        if (r101 == null) goto L7;
        Long r102 = (Long) r101.get("multi_horizontab_open_time", Long.valueOf(System.currentTimeMillis()));
        if (r102 == null) goto L7;
        long r103 = r102.longValue();
    L8:
        long r104 = System.currentTimeMillis() - r103;
        DataCenter r105 = r100.dataCenter;
        if (r105 == null) goto L12;
        int r106 = xu2.b.f565082a;
        Intrinsics.checkNotNullParameter(r105, "dataCenter");
        LinkedHashMap r107 = new LinkedHashMap();
        r107.put("duration", String.valueOf(r104));
        Unit r108 = Unit.INSTANCE;
        xu2.c r109 = new xu2.c(r107);
        r109.c(TabTeaMonitor.Event.HorizonTabDialogDuration);
        r109.b(TabSlardarMonitor.Event.HorizonTabDialogDuration);
        r105.put("multi_horizontab_open_time", 0L);
        return;
    L12:
        return;
    L7:
        r103 = System.currentTimeMillis();
        goto L8
    }

    @Override // com.bytedance.android.livesdk.vscore_impl.component.tabs.LiveTabsWidget
    public final void Rq(int r100) {
        DataCenter r101 = this.dataCenter;
        if (r101 == null) goto L5;
        IRoom r102 = lu2.c.f(r101);
    L7:
        if (RoomKt.hasMultiCamera(r102) == false) goto L9;
        int r103 = (int) s1.e(88.0f);
    L10:
        Sq(r100, r103, s1.j(R.dimen.ttlive_tabs_padding));
        return;
    L9:
        r103 = 0;
        goto L10
    L5:
        r102 = null;
        goto L7
    }

    @Override // com.bytedance.android.livesdk.vscore_impl.component.tabs.LiveTabsWidget
    public final Uri.Builder Wq(String r100) {
        Intrinsics.checkNotNullParameter(r100, "url");
        Uri.Builder r101 = UriProtector.parse(fq1.f.a().appendCommonParams(r100)).buildUpon();
        DataCenter r102 = this.dataCenter;
        if (r102 == null) goto L13;
        IRoom r103 = lu2.c.f(r102);
        if (r103 == null) goto L13;
        EpisodeExtraInfo r104 = lu2.c.a(r103);
        if (r104 == null) goto L13;
        IMatchRoomInfo r105 = r104.getMatchRoomInfo();
        if (r105 == null) goto L13;
        String r106 = r105.getThemeId();
        if (r106 == null) goto L13;
        r101.appendQueryParameter("theme_id", r106);
    L13:
        return r101;
    }

    @Override // com.bytedance.android.livesdk.vscore_impl.component.tabs.LiveTabsWidget, com.bytedance.android.live.core.tetris.widgets.LiveRecyclableWidget
    public final void onLoad(Object[] r110) {
        this.f159869i = true;
        super.onLoad(r110);
        Sq(this.f159922t, 0, s1.j(R.dimen.ttlive_tabs_padding));
        if (PadConfigUtils.c() == false) goto L10;
        MultiTabRoomViewPager r111 = this.f159861a;
        if (r111 == null) goto L7;
        r111.setBackgroundResource(R.drawable.ttlive_multitab_tabspager_bg);
    L7:
        LivePagerTabsStrip r112 = this.f159863c;
        if (r112 == null) goto L13;
        r112.setBackgroundResource(R.drawable.ttlive_multitab_tabsstrip_bg);
    L13:
        ((RelativeLayout) this.containerView.findViewById(R.id.top)).setBackgroundColor(0);
        this.f159869i = false;
        this.f159923u = MatchRoomLandScapeAnimUtil.f82835d.observeOn(AndroidSchedulers.mainThread()).subscribe(new y(this), z.f160017a);
        Disposable r113 = Observable.interval(0, 500, TimeUnit.MILLISECONDS).observeOn(AndroidSchedulers.mainThread()).subscribe(new a0(this));
        CompositeDisposable r100 = this.f159924v;
        if (r100 == null) goto L16;
        r100.add(r113);
    L16:
        TextView r114 = (TextView) this.contentView.findViewById(R.id.multitab_title_when_only_one_annie);
        View r101 = this.containerView.findViewById(R.id.tab_container);
        Map<Integer, ou2.b> r102 = MultiTabManagerImpl.f159898a;
        DataCenter r103 = this.dataCenter;
        Object r104 = null;
        if (r103 == null) goto L19;
        IRoom r105 = lu2.c.f(r103);
    L21:
        if (MultiTabManagerImpl.c(r105) <= 1) goto L23;
        r114.setVisibility(8);
        r101.setVisibility(0);
        return;
    L23:
        r114.setVisibility(0);
        DataCenter r106 = this.dataCenter;
        if (r106 == null) goto L48;
        IRoom r107 = lu2.c.f(r106);
        if (r107 == null) goto L48;
        EpisodeExtraInfo r108 = lu2.c.a(r107);
        if (r108 == null) goto L48;
        MultiTab r109 = r108.getMultiTab();
        if (r109 == null) goto L48;
        List<MultiTab.TabItem> r115 = r109.getValidTabs();
        if (r115 == null) goto L48;
        Iterator<T> r116 = r115.iterator();
    L35:
        if (r116.hasNext() == false) goto L44;
        Object r117 = r116.next();
        MultiTab.TabItem r118 = (MultiTab.TabItem) r117;
        if (r118.getTabType() == 3) goto L39;
    L41:
        boolean r119 = false;
    L42:
        if (r119 == false) goto L35;
        r104 = r117;
        goto L44
    L39:
        if (com.bytedance.android.livesdk.chatroom.vs_base.base.util.s.g().s(lu2.c.f(this.dataCenter), this.dataCenter).contains(Long.valueOf(r118.getTabId())) == true) goto L41;
        r119 = true;
    L44:
        MultiTab.TabItem r120 = (MultiTab.TabItem) r104;
        if (r120 == null) goto L48;
        String r121 = r120.getTabName();
        if (r121 == null) goto L48;
    L49:
        r114.setText(r121);
        r101.setVisibility(8);
        return;
    L48:
        r121 = "Tabs";
        goto L49
    L19:
        r105 = null;
        goto L21
    L10:
        View r122 = this.contentView;
        if (r122 == null) goto L13;
        r122.setBackgroundResource(R.drawable.ttlive_multitab_container_bg);
        goto L13
    }

    public VSLandscapeTabsWidget(Fragment r100, Long r101) {
        Intrinsics.checkNotNullParameter(r100, "parentFragment");
        this.f159926x = r100;
        this.f159927y = r101;
        this.f159922t = s1.j(R.dimen.ttlive_tab_landscape_width);
        this.f159924v = new CompositeDisposable();
    }
}
