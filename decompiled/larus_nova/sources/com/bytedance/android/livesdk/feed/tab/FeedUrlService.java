package com.bytedance.android.livesdk.feed.tab;

import am2.x;
import android.text.TextUtils;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModelProviders;
import com.bytedance.android.live.core.cache.i;
import com.bytedance.android.live.core.feed.FeedApi;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.log.g;
import com.bytedance.android.live.network.c;
import com.bytedance.android.livehostapi.TTLiveSDK;
import com.bytedance.android.livehostapi.business.IHostFeed;
import com.bytedance.android.livehostapi.business.depend.feed.IDrawerFeedAction;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.feed.FeedViewModelFactory;
import com.bytedance.android.livesdk.feed.IFeedRepository;
import com.bytedance.android.livesdk.feed.ItemRepository;
import com.bytedance.android.livesdk.feed.LiveDrawerFeedPageFragment;
import com.bytedance.android.livesdk.feed.LiveDrawerTabViewModel;
import com.bytedance.android.livesdk.feed.context.LiveFeedContext;
import com.bytedance.android.livesdk.feed.drawer.preload.PreloadHelper;
import com.bytedance.android.livesdk.feed.drawerfeed.DrawerFeedLiveFragment;
import com.bytedance.android.livesdk.feed.drawerfeed.VSDrawerFeedLiveFragment;
import com.bytedance.android.livesdk.feed.drawerfeed.repository.LiveDrawerFeedRepository;
import com.bytedance.android.livesdk.feed.drawerfeed.singledraw.SingleListDrawFragment;
import com.bytedance.android.livesdk.feed.e;
import com.bytedance.android.livesdk.feed.f;
import com.bytedance.android.livesdk.feed.feed.FeedDataKey;
import com.bytedance.android.livesdk.feed.services.d;
import com.bytedance.android.livesdk.feed.tab.monitor.FeedTabMonitor;
import com.bytedance.android.livesdk.feed.tab.repository.newtab.NewTabRepository;
import com.bytedance.android.livesdk.feed.tab.repository.p;
import com.bytedance.android.livesdk.feed.viewmodel.FragmentFeedViewModel;
import com.bytedance.android.livesdk.feed.viewmodel.TabFeedViewModel;
import com.bytedance.android.livesdk.feed.x0;
import com.bytedance.android.livesdk.log.b0;
import com.bytedance.android.livesdk.log.u;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.common.utility.Lists;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import jc1.k;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
public class FeedUrlService implements IHostFeed {
    nv1.a fragmentProvider;

    public static /* synthetic */ void b(Throwable r100) {
        lambda$requestTabApi$1(r100);
    }

    public static /* synthetic */ void c(List r100) {
        lambda$requestTabApi$0(r100);
    }

    private static /* synthetic */ void lambda$requestTabApi$0(List r100) throws Exception {
    }

    @Override // com.bytedance.android.livehostapi.business.IHostFeed
    public Fragment createSingleDrawerFeedFragment() {
        ((e) this.fragmentProvider).getClass();
        return new SingleListDrawFragment();
    }

    public FeedUrlService() {
        this.fragmentProvider = new e();
        k.l(IHostFeed.class, this);
    }

    @Override // com.bytedance.android.livehostapi.business.IHostFeed
    public List<com.bytedance.android.livesdk.feed.feed.e> getNewDrawerTabList() {
        return p.f().c();
    }

    @Override // com.bytedance.android.livehostapi.business.IHostFeed
    public List<com.bytedance.android.livesdk.feed.feed.e> getTabList() {
        LiveFeedContext.init(TTLiveSDK.hostService());
        return ((NewTabRepository) NewTabRepository.f124512e.getValue()).c();
    }

    @Override // com.bytedance.android.livehostapi.business.IHostFeed
    public void requestTabApi() {
        if (LiveFeedContext.hostService() != null) goto L5;
    L11:
        b0.o().getClass();
        g.c("FeedUrlService", "LiveFeedContext not init");
        return;
    L5:
        if (LiveFeedContext.hostService().appContext() == null) goto L11;
        if (LiveFeedContext.appContext() == null) goto L11;
        ((NewTabRepository) NewTabRepository.f124511d.getValue()).a(FeedTabMonitor.Action.TRIGGER_ACTION_ENTER_ROOM).subscribe(new a(), new b());
    }

    @Override // com.bytedance.android.livehostapi.business.IHostFeed
    public boolean shouldDrawerMultiTab() {
        LiveFeedContext.init(TTLiveSDK.hostService());
        boolean r100 = x0.f124600d;
        if (x0.a.a().c().size() > 1) goto L7;
        return false;
    L7:
        return true;
    }

    private static /* synthetic */ void lambda$requestTabApi$1(Throwable r100) throws Exception {
        ALogger.e("Drawer Tab Request", r100);
    }

    @Override // com.bytedance.android.livehostapi.business.IHostFeed
    public Fragment createVsDrawerFeedFragment(IDrawerFeedAction r100) {
        ((e) this.fragmentProvider).getClass();
        VSDrawerFeedLiveFragment r101 = new VSDrawerFeedLiveFragment();
        r101.H = r100;
        return r101;
    }

    @Override // com.bytedance.android.livehostapi.business.IHostFeed
    public Map<String, Object> getFeedTab(long r100) {
        List<com.bytedance.android.livesdk.feed.feed.e> r101 = p.f().c();
        HashMap r102 = new HashMap();
        if (Lists.isEmpty(r101) == false) goto L5;
        return r102;
    L5:
        Iterator<com.bytedance.android.livesdk.feed.feed.e> r103 = r101.iterator();
    L7:
        if (r103.hasNext() == false) goto L13;
        com.bytedance.android.livesdk.feed.feed.e r104 = r103.next();
        if (r104 == null) goto L7;
        if (r104.f() != r100) goto L7;
    L14:
        if (r104 != null) goto L16;
        r104 = (com.bytedance.android.livesdk.feed.feed.e) ListProtector.get(r101, 0);
    L16:
        if (r104 == null) goto L18;
        r102.put(IHostFeed.KEY_FEED_URL, r104.h());
        r102.put(IHostFeed.KEY_FEED_STYLE, Integer.valueOf(r104.m()));
    L18:
        return r102;
    L13:
        r104 = null;
        goto L14
    }

    @Override // com.bytedance.android.livehostapi.business.IHostFeed
    public Fragment createDrawerFeedFragment(IDrawerFeedAction r100, boolean r101) {
        ((e) this.fragmentProvider).getClass();
        RoomContext r102 = RoomContext.getShared();
        if (r102 != null) goto L5;
    L9:
        if (r101 == false) goto L11;
        LiveDrawerFeedPageFragment r103 = new LiveDrawerFeedPageFragment();
        r103.f123499x = r100;
        return r103;
    L11:
        DrawerFeedLiveFragment r104 = new DrawerFeedLiveFragment();
        r104.G = r100;
        return r104;
    L5:
        if (r102.isVSRoom() == false) goto L9;
        if (r102.isVSSpecialDrawer() == false) goto L9;
        DrawerFeedLiveFragment r105 = new DrawerFeedLiveFragment();
        r105.G = r100;
        return r105;
    }

    @Override // com.bytedance.android.livehostapi.business.IHostFeed
    public void preloadDrawerFeed(FragmentActivity r210, boolean r211) {
        TabFeedViewModel r100 = PreloadHelper.f123673a;
        Intrinsics.checkNotNullParameter(r210, "activity");
        IFeedRepository r101 = null;
        if (r210.hashCode() == PreloadHelper.f123677e) goto L11;
        r210.getLifecycle().addObserver(PreloadHelper.f123678f);
        PreloadHelper.f123677e = r210.hashCode();
        if (PreloadHelper.f123673a == null) goto L8;
        PreloadHelper.f123673a = null;
    L8:
        if (PreloadHelper.f123674b == null) goto L11;
        PreloadHelper.f123674b = null;
    L11:
        if (r211 == false) goto L13;
        PreloadHelper.f123678f.getClass();
        com.bytedance.android.livesdk.feed.feed.e r102 = PreloadHelper.f123675c;
        if (r102.getType() == 1) goto L48;
        boolean r103 = false;
    L97:
        HashMap r104 = new HashMap();
        r104.put("predict_action", "preload_suc");
        if (r103 == false) goto L100;
        String r105 = "1";
    L101:
        r104.put("predict_value", r105);
        u.l().sendLog("livesdk_liveai_drawer_predict", r104, new Object[]{x.class, Room.class});
        return;
    L100:
        r105 = "0";
        goto L101
    L48:
        if (r210.hashCode() != PreloadHelper.f123677e) goto L50;
        LiveDrawerTabViewModel r106 = PreloadHelper.f123674b;
    L51:
        if (r106 != null) goto L57;
        Intrinsics.checkNotNullParameter(r210, "activity");
        LiveDrawerTabViewModel r107 = (LiveDrawerTabViewModel) ViewModelProviders.of(r210).get(LiveDrawerTabViewModel.class);
        PreloadHelper.f123674b = r107;
        if (r107 != null) goto L57;
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.livesdk.feed.LiveDrawerTabViewModel");
    L57:
        Intrinsics.checkNotNullParameter(r210, "activity");
        LiveDrawerTabViewModel r108 = PreloadHelper.f123674b;
        if (r108 == null) goto L60;
        FragmentFeedViewModel r109 = r108.getTabViewModel(r102.f());
    L61:
        if (r109 != null) goto L87;
        LiveDrawerTabViewModel r110 = PreloadHelper.f123674b;
        if (r110 == null) goto L67;
        FragmentFeedViewModel r111 = r110.getTabViewModel(r102.f());
        if (r111 == null) goto L67;
        IFeedRepository r112 = r111.feedRepository();
        d.a().g(r111.feedDataKey(), r112);
    L68:
        if (r112 == null) goto L70;
    L75:
        if (r112 != null) goto L78;
        f r113 = d.a();
        FeedApi r114 = (FeedApi) c.b().e(FeedApi.class);
        com.bytedance.android.live.core.cache.f r115 = new com.bytedance.android.live.core.cache.f();
        i r116 = new i(vv1.e.f557380a, new com.bytedance.android.livesdk.feed.a(), vv1.f.f557381a);
        com.bytedance.android.live.core.cache.f r117 = new com.bytedance.android.live.core.cache.f();
        hw1.a r118 = d.b();
        boolean r119 = x0.f124600d;
        r112 = new LiveDrawerFeedRepository(r113, r114, r115, r116, r117, r118, new com.bytedance.android.livesdk.feed.c(x0.a.a()));
    L78:
        if ((r112 instanceof LiveDrawerFeedRepository) == false) goto L81;
        r101 = r112;
    L81:
        LiveDrawerFeedRepository r120 = (LiveDrawerFeedRepository) r101;
        if (r120 == null) goto L84;
        r120.f123738w = PreloadHelper.f123676d;
    L84:
        boolean r121 = x0.f124600d;
        FeedViewModelFactory r122 = new FeedViewModelFactory(r112, x0.a.a(), LiveFeedContext.appContext().getApplicationContext(), vv1.g.f557382a, new ax1.b());
        r122.f123432c = r102.f();
        r122.f123433d = uv1.c.a(uv1.c.c(r102), r102.j(), r102.f(), 4);
        r109 = (FragmentFeedViewModel) ViewModelProviders.of(r210, r122).get(FragmentFeedViewModel.class);
        LiveDrawerTabViewModel r123 = PreloadHelper.f123674b;
        if (r123 == null) goto L94;
        r123.putTabViewModel(r102.f(), r109);
    L94:
        r109.setPreload(true);
        r109.setStarted(false);
        r109.clearDataCache();
        r109.start();
    L95:
        r103 = true;
        goto L97
    L70:
        if (TextUtils.isEmpty(r102.j()) == true) goto L75;
        ItemRepository r124 = d.a().d(FeedDataKey.a(r102.j(), r102.n(), r102.f()));
        if ((r124 instanceof IFeedRepository) == true) goto L74;
        r124 = null;
    L74:
        r112 = (IFeedRepository) r124;
    L67:
        r112 = null;
        goto L68
    L87:
        IFeedRepository r125 = r109.feedRepository();
        if ((r125 instanceof LiveDrawerFeedRepository) == false) goto L91;
        r101 = r125;
    L91:
        LiveDrawerFeedRepository r126 = (LiveDrawerFeedRepository) r101;
        if (r126 == null) goto L94;
        r126.f123738w = PreloadHelper.f123676d;
        goto L94
    L60:
        r109 = null;
        goto L61
    L50:
        r106 = null;
        goto L51
    L13:
        if (r210.hashCode() != PreloadHelper.f123677e) goto L15;
        TabFeedViewModel r127 = PreloadHelper.f123673a;
    L16:
        if (r127 != null) goto L44;
        Intrinsics.checkNotNullParameter(r210, "activity");
        com.bytedance.android.livesdk.feed.feed.e r128 = uv1.c.b();
        String r129 = uv1.c.d(r128);
        if (r128 != null) goto L20;
    L25:
        IFeedRepository r130 = null;
    L26:
        if (r130 != null) goto L28;
        f r131 = d.a();
        FeedApi r132 = (FeedApi) c.b().e(FeedApi.class);
        com.bytedance.android.live.core.cache.f r133 = new com.bytedance.android.live.core.cache.f();
        i r134 = new i(vv1.a.f557377a, new com.bytedance.android.livesdk.feed.a(), vv1.b.f557378a);
        com.bytedance.android.live.core.cache.f r135 = new com.bytedance.android.live.core.cache.f();
        hw1.a r136 = d.b();
        boolean r137 = x0.f124600d;
        r130 = new LiveDrawerFeedRepository(r131, r132, r133, r134, r135, r136, new com.bytedance.android.livesdk.feed.c(x0.a.b()));
    L28:
        vv1.d r138 = new vv1.d();
        if ((r130 instanceof LiveDrawerFeedRepository) == false) goto L32;
        r101 = r130;
    L32:
        LiveDrawerFeedRepository r139 = (LiveDrawerFeedRepository) r101;
        if (r139 == null) goto L35;
        r139.f123738w = r138;
    L35:
        boolean r140 = x0.f124600d;
        FeedViewModelFactory r141 = new FeedViewModelFactory(r130, x0.a.b(), LiveFeedContext.appContext().getApplicationContext(), vv1.c.f557379a, new ax1.b());
        if (r128 == null) goto L38;
        long r142 = r128.f();
    L39:
        r141.f123432c = r142;
        r141.f123433d = uv1.c.a(r129, "", 0, 4);
        r127 = (TabFeedViewModel) ViewModelProviders.of(r210, r141).get(TabFeedViewModel.class);
        PreloadHelper.f123673a = r127;
        if (r127 != null) goto L44;
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.livesdk.feed.viewmodel.TabFeedViewModel");
    L38:
        r142 = 1;
        goto L39
    L20:
        if (TextUtils.isEmpty(r128.j()) == true) goto L25;
        ItemRepository r143 = d.a().d(FeedDataKey.a(r128.j(), r128.n(), r128.f()));
        if ((r143 instanceof IFeedRepository) == true) goto L24;
        r143 = null;
    L24:
        r130 = (IFeedRepository) r143;
    L44:
        r127.setPreload(true);
        r127.setStarted(false);
        r127.clearDataCache();
        r127.start();
        goto L95
    L15:
        r127 = null;
        goto L16
    }
}
