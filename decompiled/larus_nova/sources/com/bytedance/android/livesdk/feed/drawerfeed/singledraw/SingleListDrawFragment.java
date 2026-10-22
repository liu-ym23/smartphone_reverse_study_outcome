package com.bytedance.android.livesdk.feed.drawerfeed.singledraw;

import am2.x;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.bytedance.android.live.base.model.feed.FeedItem;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.base.model.user.UserEvent;
import com.bytedance.android.live.core.ui.BaseFragment;
import com.bytedance.android.live.room.IRoomService;
import com.bytedance.android.live.ui.CenterScrollLayoutManager;
import com.bytedance.android.live.ui.FadingEdgeRecyclerview;
import com.bytedance.android.live.user.IUserService;
import com.bytedance.android.livesdk.chatroom.ui.pullrefresh.DoubleBallSwipeRefreshLayout;
import com.bytedance.android.livesdk.chatroom.ui.pullrefresh.SwipeRefreshLayout;
import com.bytedance.android.livesdk.log.filter.o;
import com.bytedance.android.livesdk.log.u;
import com.bytedance.android.livesdk.user.l;
import com.bytedance.android.livesdk.viewmodel.SingleDrawViewModel;
import com.bytedance.android.livesdkapi.depend.live.ILiveRoomPlayFragmentConstant;
import com.bytedance.android.livesdkapi.feed.LiveDrawerUrlHelper;
import com.bytedance.ies.sdk.widgets.NextLiveData;
import com.bytedance.keva.Keva;
import com.larus.nova.R;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Predicate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import me.drakeet.multitype.Items;
import me.drakeet.multitype.MultiTypeAdapter;

/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001\u0004B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/livesdk/feed/drawerfeed/singledraw/SingleListDrawFragment;", "Lcom/bytedance/android/live/core/ui/BaseFragment;", "<init>", "()V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "livefeed_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class SingleListDrawFragment extends BaseFragment {
    public static final /* synthetic */ int H = 0;
    public final MultiTypeAdapter A;
    public SingleDrawFeedAdapter B;
    public ViewGroup C;
    public TextView D;
    public final CompositeDisposable E;
    public Disposable F;
    public final e G;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f123765d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public View f123766e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public TabListModel f123767f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final cw1.b f123768g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public SingleDrawViewModel f123769h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public ViewGroup f123770i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public DoubleBallSwipeRefreshLayout f123771j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public View f123772k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public View f123773l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public TextView f123774m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public View f123775n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public View f123776o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public ViewGroup f123777p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public FadingEdgeRecyclerview f123778q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public FadingEdgeRecyclerview f123779r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public CenterScrollLayoutManager f123780s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public View f123781t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public View f123782u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public View f123783v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public View f123784w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public View f123785x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public View f123786y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final Keva f123787z;

    public static final class a {
    }

    public static final class b<T> implements Predicate {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final b f123788a = null;

        static {
            f123788a = new b();
        }

        public b() {
        }

        @Override // io.reactivex.functions.Predicate
        public final boolean test(Object r100) {
            UserEvent r101 = (UserEvent) r100;
            Intrinsics.checkNotNullParameter(r101, "res");
            if (r101.isLogOut() == false) goto L5;
        L8:
            return true;
        L5:
            if (r101.isLogin() == true) goto L8;
            return false;
        }
    }

    public static final class c<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ SingleListDrawFragment f123789a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ long f123790b;

        public c(SingleListDrawFragment r100, long r101) {
            this.f123789a = r100;
            this.f123790b = r101;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            UserEvent r101 = (UserEvent) r100;
            r101.isLogin();
            if (r101.isLogin() == false) goto L9;
            ViewGroup r102 = this.f123789a.C;
            if (r102 == null) goto L7;
            r102.setVisibility(8);
        L7:
            this.f123789a.U90(this.f123790b, false);
            return;
        }
    }

    public static final class d implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ SingleListDrawFragment f123791a;

        public d(SingleListDrawFragment r100) {
            this.f123791a = r100;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            com.bytedance.android.livesdk.user.f r101 = ((IUserService) jc1.k.n(IUserService.class)).user();
            FragmentActivity r102 = this.f123791a.getActivity();
            l.a r103 = new l.a();
            r103.f158687c = -1;
            r101.login(r102, new l(r103)).subscribe(this.f123791a.G);
        }
    }

    public static final class e extends com.bytedance.android.livesdk.user.h<IBaseUser> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ SingleListDrawFragment f123792a;

        public e(SingleListDrawFragment r100) {
            this.f123792a = r100;
        }

        @Override // com.bytedance.android.livesdk.user.h, io.reactivex.Observer
        public final void onSubscribe(Disposable r100) {
            Intrinsics.checkNotNullParameter(r100, "d");
            this.f123792a.E.add(r100);
        }
    }

    public static final class f implements SwipeRefreshLayout.f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ SingleListDrawFragment f123793a;

        public f(SingleListDrawFragment r100) {
            this.f123793a = r100;
        }

        @Override // com.bytedance.android.livesdk.chatroom.ui.pullrefresh.SwipeRefreshLayout.f
        public final void onRefresh() {
            SingleDrawViewModel r100 = this.f123793a.f123769h;
            if (r100 == null) goto L16;
            NextLiveData<Long> r101 = r100.getTabRefresh();
            if (r101 == null) goto L17;
            TabListModel r102 = this.f123793a.f123767f;
            if (r102 == null) goto L13;
            bw1.e r103 = r102.getCurrentTabModel();
            if (r103 == null) goto L13;
            com.bytedance.android.livesdk.feed.feed.e r104 = r103.f21008f;
            if (r104 == null) goto L13;
            long r105 = r104.f();
        L14:
            r101.setValue(Long.valueOf(r105));
            return;
        L13:
            r105 = -1;
            goto L14
        L17:
            return;
        }
    }

    public static final class g implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ SingleListDrawFragment f123794a;

        public g(SingleListDrawFragment r100) {
            this.f123794a = r100;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            SingleListDrawFragment.T90(this.f123794a);
        }
    }

    public static final class h implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ SingleListDrawFragment f123795a;

        public h(SingleListDrawFragment r100) {
            this.f123795a = r100;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            SingleListDrawFragment.S90(this.f123795a);
        }
    }

    public static final class i implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ SingleListDrawFragment f123796a;

        public i(SingleListDrawFragment r100) {
            this.f123796a = r100;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            SingleListDrawFragment.T90(this.f123796a);
        }
    }

    public static final class j implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ SingleListDrawFragment f123797a;

        public j(SingleListDrawFragment r100) {
            this.f123797a = r100;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            SingleListDrawFragment.S90(this.f123797a);
        }
    }

    public static final class k implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ SingleListDrawFragment f123798a;

        public k(SingleListDrawFragment r100) {
            this.f123798a = r100;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            ViewGroup r101 = this.f123798a.f123777p;
            if (r101 != null) goto L5;
        L16:
            SingleListDrawFragment r102 = this.f123798a;
            SingleListDrawFragment.W90(CollectionsKt.mutableListOf(new View[]{r102.f123777p, r102.f123770i, r102.f123775n, r102.f123776o}));
            return;
        L5:
            if (r101.getVisibility() != 8) goto L16;
            int r103 = aw1.a.f16407a;
            TabListModel r104 = this.f123798a.f123767f;
            if (r104 == null) goto L14;
            bw1.e r105 = r104.getCurrentTabModel();
            if (r105 == null) goto L14;
            com.bytedance.android.livesdk.feed.feed.e r106 = r105.f21008f;
            if (r106 == null) goto L14;
            String r107 = r106.i();
            if (r107 == null) goto L14;
        L15:
            Intrinsics.checkNotNullParameter(r107, "tabName");
            Map<String, String> r108 = aw1.a.a();
            r108.put(com.bytedance.android.ec.core.event.a.KEY_TAB_NAME, r107);
            u.l().sendLog("livesdk_drawer_tab_show", r108, new Object[0]);
        L14:
            r107 = "";
            goto L15
        }
    }

    static {
    }

    public SingleListDrawFragment() {
        this.f123765d = "yellow_keva";
        this.f123768g = new cw1.b();
        this.f123787z = Keva.getRepo("draw_history", 0);
        this.A = new MultiTypeAdapter();
        this.E = new CompositeDisposable();
        this.G = new e(this);
    }

    @Override // com.bytedance.android.live.core.ui.BaseFragment, androidx.fragment.app.Fragment
    public final void onDestroy() {
        super.onDestroy();
        TabListModel r100 = this.f123767f;
        if (r100 == null) goto L5;
        r100.onDialogClose();
    L5:
        SingleDrawViewModel r101 = this.f123769h;
        if (r101 == null) goto L8;
        r101.clear(this);
    L8:
        CompositeDisposable r102 = this.E;
        if (r102 == null) goto L11;
        r102.clear();
    L11:
        CompositeDisposable r103 = this.E;
        if (r103 == null) goto L15;
        r103.dispose();
        return;
    }

    @Override // androidx.fragment.app.Fragment
    public final void onStop() {
        super.onStop();
    }

    public static final void S90(SingleListDrawFragment r100) {
        r100.f123787z.storeBoolean(r100.f123765d, true);
        View r101 = r100.f123786y;
        if (r101 == null) goto L5;
        r101.setVisibility(8);
    L5:
        View r102 = r100.f123783v;
        if (r102 == null) goto L8;
        r102.setVisibility(8);
    L8:
        IRoomService r103 = (IRoomService) jc1.k.n(IRoomService.class);
        FragmentActivity r104 = r100.getActivity();
        Bundle r105 = new Bundle();
        r105.putBoolean(ILiveRoomPlayFragmentConstant.LIVE_DRAW_OPEN_HISTORY, true);
        Unit r106 = Unit.INSTANCE;
        r103.openDrawer(r104, true, r105, null);
    }

    public static final void T90(SingleListDrawFragment r100) {
        r100.getClass();
        IRoomService r101 = (IRoomService) jc1.k.n(IRoomService.class);
        FragmentActivity r102 = r100.getActivity();
        Bundle r103 = new Bundle();
        r103.putBoolean(ILiveRoomPlayFragmentConstant.LIVE_DRAW_OPEN_SEARCH, true);
        Unit r104 = Unit.INSTANCE;
        r101.openDrawer(r102, true, r103, null);
    }

    public static void W90(List r100) {
        Iterator r101 = r100.iterator();
    L4:
        if (r101.hasNext() == false) goto L11;
        View r102 = (View) r101.next();
        if (r102 == null) goto L4;
        int r103 = 8;
        if (r102.getVisibility() != 8) goto L10;
        r103 = 0;
    L10:
        r102.setVisibility(r103);
        goto L4
    }

    public final void V90(long r100) {
        MultiTypeAdapter r101 = this.A;
        Items r102 = new Items();
        TabListModel r103 = this.f123767f;
        if (r103 == null) goto L16;
        List<com.bytedance.android.livesdk.feed.feed.e> r104 = r103.getTabList();
        if (r104 == null) goto L16;
        ArrayList r105 = new ArrayList();
        Iterator<T> r106 = r104.iterator();
    L8:
        if (r106.hasNext() == false) goto L15;
        Object r107 = r106.next();
        if (((com.bytedance.android.livesdk.feed.feed.e) r107).f() == r100) goto L12;
        boolean r108 = true;
    L13:
        if (r108 == false) goto L8;
        r105.add(r107);
        goto L8
    L12:
        r108 = false;
        goto L13
    L15:
        r102.addAll(r105);
    L16:
        Unit r109 = Unit.INSTANCE;
        r101.f513437a = r102;
        this.A.notifyDataSetChanged();
    }

    @Override // com.bytedance.android.live.core.ui.BaseFragment, androidx.fragment.app.Fragment
    public final void onCreate(Bundle r100) {
        super.onCreate(r100);
        FragmentActivity r101 = getActivity();
        if (r101 == null) goto L5;
        this.f123769h = (SingleDrawViewModel) ViewModelProviders.of(r101).get(SingleDrawViewModel.class);
        this.f123767f = (TabListModel) ViewModelProviders.of(r101).get(TabListModel.class);
    L5:
        SingleDrawViewModel r102 = this.f123769h;
        if (r102 == null) goto L10;
        NextLiveData<com.bytedance.android.livesdk.viewmodel.j> r103 = r102.getItemsUpdate();
        if (r103 == null) goto L10;
        r103.observe(this, new aw1.b(this));
    L10:
        SingleDrawViewModel r104 = this.f123769h;
        if (r104 == null) goto L16;
        NextLiveData<com.bytedance.android.livesdk.viewmodel.i> r105 = r104.getShowLoading();
        if (r105 == null) goto L17;
        r105.observe(this, new aw1.c(this));
        return;
    L17:
        return;
    }

    public final void U90(long r110, boolean r111) {
        TabListModel r100 = this.f123767f;
        String r101 = null;
        if (r100 == null) goto L19;
        ArrayList<bw1.e> r102 = r100.getTabItemModelList();
        if (r102 == null) goto L17;
        Iterator<T> r103 = r102.iterator();
    L8:
        if (r103.hasNext() == false) goto L15;
        Object r104 = r103.next();
        if (((bw1.e) r104).g() != r110) goto L12;
        boolean r105 = true;
    L13:
        if (r105 == false) goto L8;
    L16:
        bw1.e r106 = (bw1.e) r104;
    L18:
        r100.setCurrentTabModel(r106);
        goto L19
    L12:
        r105 = false;
        goto L13
    L15:
        r104 = null;
        goto L16
    L17:
        r106 = null;
    L19:
        SingleDrawFeedAdapter r107 = this.B;
        if (r107 == null) goto L25;
        LinkedList<FeedItem> r108 = r107.f123760a;
        if (r108 == null) goto L25;
        r108.clear();
    L25:
        if (r111 == false) goto L79;
        int r112 = aw1.a.f16407a;
        TabListModel r113 = this.f123767f;
        String r109 = "";
        if (r113 == null) goto L34;
        bw1.e r114 = r113.getCurrentTabModel();
        if (r114 == null) goto L34;
        com.bytedance.android.livesdk.feed.feed.e r115 = r114.f21008f;
        if (r115 == null) goto L34;
        String r116 = r115.i();
        if (r116 == null) goto L34;
    L35:
        TabListModel r117 = this.f123767f;
        if (r117 == null) goto L55;
        List<com.bytedance.android.livesdk.feed.feed.e> r118 = r117.getTabList();
        if (r118 == null) goto L55;
        Iterator<T> r119 = r118.iterator();
    L41:
        if (r119.hasNext() == false) goto L48;
        Object r120 = r119.next();
        if (((com.bytedance.android.livesdk.feed.feed.e) r120).f() != r110) goto L45;
        boolean r121 = true;
    L46:
        if (r121 == false) goto L41;
    L49:
        com.bytedance.android.livesdk.feed.feed.e r122 = (com.bytedance.android.livesdk.feed.feed.e) r120;
        if (r122 == null) goto L55;
        String r123 = r122.i();
        if (r123 == null) goto L55;
        r109 = r123;
        goto L55
    L45:
        r121 = false;
        goto L46
    L48:
        r120 = null;
    L55:
        aw1.a.b(r116, r109);
        W90(CollectionsKt.mutableListOf(new View[]{this.f123777p, this.f123770i, this.f123775n, this.f123776o}));
        TextView r124 = this.f123774m;
        if (r124 == null) goto L75;
        TabListModel r125 = this.f123767f;
        if (r125 == null) goto L74;
        List<com.bytedance.android.livesdk.feed.feed.e> r126 = r125.getTabList();
        if (r126 == null) goto L74;
        Iterator<T> r127 = r126.iterator();
    L63:
        if (r127.hasNext() == false) goto L70;
        Object r128 = r127.next();
        if (((com.bytedance.android.livesdk.feed.feed.e) r128).f() != r110) goto L67;
        boolean r129 = true;
    L68:
        if (r129 == false) goto L63;
    L71:
        com.bytedance.android.livesdk.feed.feed.e r130 = (com.bytedance.android.livesdk.feed.feed.e) r128;
        if (r130 == null) goto L74;
        r101 = r130.i();
        goto L74
    L67:
        r129 = false;
        goto L68
    L70:
        r128 = null;
    L74:
        r124.setText(r101);
    L75:
        V90(r110);
        ViewGroup r131 = this.C;
        if (r131 == null) goto L79;
        r131.setVisibility(8);
    L34:
        r116 = "";
    L79:
        if (((IUserService) jc1.k.n(IUserService.class)).user().isLogin() == true) goto L100;
        TabListModel r132 = this.f123767f;
        if (r132 == null) goto L100;
        bw1.e r133 = r132.getCurrentTabModel();
        if (r133 == null) goto L100;
        com.bytedance.android.livesdk.feed.feed.e r134 = r133.f21008f;
        if (r134 == null) goto L100;
        if (r134.getType() != 2) goto L100;
        ViewGroup r135 = this.C;
        if (r135 == null) goto L91;
        r135.setVisibility(0);
    L91:
        Disposable r136 = this.F;
        if (r136 == null) goto L94;
        r136.dispose();
    L94:
        Disposable r137 = ((IUserService) jc1.k.n(IUserService.class)).user().m().filter(b.f123788a).subscribe(new c(this, r110));
        this.F = r137;
        if (r137 == null) goto L97;
        this.E.add(r137);
    L97:
        TextView r138 = this.D;
        if (r138 == null) goto L110;
        r138.setOnClickListener(new d(this));
    L110:
        SingleDrawFeedAdapter r139 = this.B;
        if (r139 == null) goto L129;
        r139.notifyDataSetChanged();
        return;
    L129:
        return;
    L100:
        SingleDrawFeedAdapter r140 = this.B;
        if (r140 == null) goto L105;
        LinkedList<FeedItem> r141 = r140.f123760a;
        if (r141 == null) goto L105;
        FeedItem r142 = new FeedItem();
        SingleDrawFeedAdapter.f123759h.getClass();
        r142.type = SingleDrawFeedAdapter.f123758g;
        Unit r143 = Unit.INSTANCE;
        r141.add(r142);
    L105:
        SingleDrawViewModel r144 = this.f123769h;
        if (r144 == null) goto L110;
        NextLiveData<Long> r145 = r144.getChangeTab();
        if (r145 == null) goto L110;
        r145.setValue(Long.valueOf(r110));
        goto L110
    }

    @Override // com.bytedance.android.live.core.ui.BaseFragment, androidx.fragment.app.Fragment
    public final void onViewCreated(View r110, Bundle r111) {
        Intrinsics.checkNotNullParameter(r110, "view");
        super.onViewCreated(r110, r111);
        Context r112 = getContext();
        if (r112 == null) goto L13;
        FadingEdgeRecyclerview r100 = this.f123779r;
        if (r100 == null) goto L13;
        final CenterScrollLayoutManager r101 = new CenterScrollLayoutManager(r112);
        r101.setOrientation(1);
        this.B = new SingleDrawFeedAdapter(r100, r101, this.f123769h, this, this.f123767f);
        TabListModel r113 = this.f123767f;
        if (r113 == null) goto L11;
        com.bytedance.android.livesdk.feed.feed.e r114 = r113.getDefaultTab();
        if (r114 == null) goto L11;
        long r102 = r114.f();
    L12:
        U90(r102, false);
        this.f123780s = r101;
        r100.setLayoutManager(r101);
        r100.setAdapter(this.B);
        r100.addOnScrollListener(new SingleListDrawFragment$onViewCreated$$inlined$let$lambda$1(r101, this));
    L11:
        r102 = 0;
    L13:
        DoubleBallSwipeRefreshLayout r115 = this.f123771j;
        if (r115 == null) goto L17;
        r115.setOnRefreshListener(new f(this));
    L17:
        if (this.f123787z.getBoolean(this.f123765d, false) == false) goto L24;
        View r116 = this.f123783v;
        if (r116 == null) goto L21;
        r116.setVisibility(8);
    L21:
        View r117 = this.f123786y;
        if (r117 == null) goto L24;
        r117.setVisibility(8);
    L24:
        TabListModel r118 = this.f123767f;
        if (r118 != null) goto L27;
    L61:
        View r119 = this.f123772k;
        if (r119 == null) goto L64;
        r119.setVisibility(8);
    L64:
        View r120 = this.f123773l;
        if (r120 == null) goto L67;
        r120.setVisibility(0);
    L67:
        ViewGroup r121 = this.f123777p;
        if (r121 == null) goto L70;
        r121.setVisibility(8);
    L70:
        View r122 = this.f123781t;
        if (r122 == null) goto L73;
        r122.setOnClickListener(new g(this));
    L73:
        View r123 = this.f123782u;
        if (r123 == null) goto L76;
        r123.setOnClickListener(new h(this));
    L76:
        View r124 = this.f123784w;
        if (r124 == null) goto L79;
        r124.setOnClickListener(new i(this));
    L79:
        View r125 = this.f123785x;
        if (r125 == null) goto L82;
        r125.setOnClickListener(new j(this));
    L82:
        View r126 = this.f123772k;
        if (r126 == null) goto L86;
        r126.setOnClickListener(new k(this));
        return;
    L86:
        return;
    L27:
        if (r118.isMultiTab() != true) goto L61;
        View r127 = this.f123766e;
        String r103 = null;
        if (r127 == null) goto L31;
        FadingEdgeRecyclerview r128 = (FadingEdgeRecyclerview) r127.findViewById(R.id.single_drawer_recyclerview_tab);
    L32:
        this.f123778q = r128;
        View r129 = this.f123772k;
        if (r129 == null) goto L35;
        r129.setVisibility(0);
    L35:
        View r130 = this.f123773l;
        if (r130 == null) goto L38;
        r130.setVisibility(8);
    L38:
        TextView r131 = this.f123774m;
        if (r131 == null) goto L46;
        TabListModel r104 = this.f123767f;
        if (r104 == null) goto L45;
        com.bytedance.android.livesdk.feed.feed.e r105 = r104.getDefaultTab();
        if (r105 == null) goto L45;
        r103 = r105.i();
    L45:
        r131.setText(r103);
    L46:
        View r132 = this.f123775n;
        if (r132 == null) goto L49;
        r132.setVisibility(8);
    L49:
        View r133 = this.f123776o;
        if (r133 == null) goto L52;
        r133.setVisibility(0);
    L52:
        FadingEdgeRecyclerview r134 = this.f123778q;
        if (r134 == null) goto L67;
        r134.setLayoutManager(new LinearLayoutManager(r134.getContext(), 1, false));
        this.A.z2(com.bytedance.android.livesdk.feed.feed.e.class, new dw1.c(this.f123769h));
        TabListModel r106 = this.f123767f;
        if (r106 == null) goto L59;
        com.bytedance.android.livesdk.feed.feed.e r107 = r106.getDefaultTab();
        if (r107 == null) goto L59;
        long r108 = r107.f();
    L60:
        V90(r108);
        r134.setAdapter(this.A);
        r134.f101949c = true;
        r134.f101948b = true;
    L59:
        r108 = -1;
        goto L60
    L31:
        r128 = null;
        goto L32
    }

    @Override // androidx.fragment.app.Fragment
    public final View onCreateView(LayoutInflater r110, ViewGroup r111, Bundle r112) {
        Intrinsics.checkNotNullParameter(r110, "inflater");
        View r113 = r110.inflate(R.layout.ttlive_feed_single_draw_feed, r111, false);
        this.f123766e = r113;
        Object r114 = null;
        if (r113 == null) goto L5;
        FadingEdgeRecyclerview r115 = (FadingEdgeRecyclerview) r113.findViewById(R.id.single_drawer_recyclerview_room);
    L6:
        this.f123779r = r115;
        View r116 = this.f123766e;
        if (r116 == null) goto L9;
        ViewGroup r117 = (ViewGroup) r116.findViewById(R.id.single_drawer_recyclerview_tab_container);
    L10:
        this.f123777p = r117;
        View r118 = this.f123766e;
        if (r118 == null) goto L13;
        ViewGroup r119 = (ViewGroup) r118.findViewById(R.id.single_draw_login_layout);
    L14:
        this.C = r119;
        View r120 = this.f123766e;
        if (r120 == null) goto L17;
        TextView r121 = (TextView) r120.findViewById(R.id.single_draw_login_button);
    L18:
        this.D = r121;
        View r122 = this.f123766e;
        if (r122 == null) goto L21;
        ViewGroup r123 = (ViewGroup) r122.findViewById(R.id.single_drawer_recyclerview_container_refresh);
    L22:
        this.f123770i = r123;
        View r124 = this.f123766e;
        if (r124 == null) goto L25;
        DoubleBallSwipeRefreshLayout r125 = (DoubleBallSwipeRefreshLayout) r124.findViewById(R.id.single_drawer_recyclerview_layout_refresh);
    L26:
        this.f123771j = r125;
        View r126 = this.f123766e;
        if (r126 == null) goto L29;
        View r127 = r126.findViewById(R.id.single_drawer_tab_recom_container);
    L30:
        this.f123772k = r127;
        View r128 = this.f123766e;
        if (r128 == null) goto L33;
        TextView r129 = (TextView) r128.findViewById(R.id.single_drawer_selected_tab_text);
    L34:
        this.f123774m = r129;
        View r130 = this.f123766e;
        if (r130 == null) goto L37;
        View r131 = r130.findViewById(R.id.single_drawer_top_action_container);
    L38:
        this.f123773l = r131;
        View r132 = this.f123766e;
        if (r132 == null) goto L41;
        View r133 = r132.findViewById(R.id.single_drawer_selected_top_up_ic);
    L42:
        this.f123775n = r133;
        View r134 = this.f123766e;
        if (r134 == null) goto L45;
        View r135 = r134.findViewById(R.id.single_drawer_selected_top_down_ic);
    L46:
        this.f123776o = r135;
        View r136 = this.f123766e;
        if (r136 == null) goto L49;
        View r137 = r136.findViewById(R.id.single_drawer_search_icon);
    L50:
        this.f123781t = r137;
        View r138 = this.f123766e;
        if (r138 == null) goto L53;
        View r139 = r138.findViewById(R.id.single_drawer_history_icon);
    L54:
        this.f123782u = r139;
        View r140 = this.f123766e;
        if (r140 == null) goto L57;
        View r141 = r140.findViewById(R.id.single_drawer_yellow_point);
    L58:
        this.f123783v = r141;
        View r142 = this.f123766e;
        if (r142 == null) goto L61;
        View r143 = r142.findViewById(R.id.single_drawer_search_icon_bottom);
    L62:
        this.f123784w = r143;
        View r144 = this.f123766e;
        if (r144 == null) goto L65;
        View r145 = r144.findViewById(R.id.single_drawer_history_icon_bottom);
    L66:
        this.f123785x = r145;
        View r146 = this.f123766e;
        if (r146 == null) goto L69;
        View r147 = r146.findViewById(R.id.single_drawer_yellow_point_bottom);
    L70:
        this.f123786y = r147;
        TabListModel r148 = this.f123767f;
        if (r148 == null) goto L89;
        r148.init(this.f123769h);
        cw1.b r149 = this.f123768g;
        if (r149 == null) goto L89;
        SingleDrawViewModel r100 = this.f123769h;
        Intrinsics.checkNotNullParameter(r148, "listModel");
        Intrinsics.checkNotNullParameter(this, "owner");
        r149.f21000a = r100;
        r149.f21001b = r148;
        r149.f21002c = this;
        if (r100 == null) goto L79;
        NextLiveData<Long> r150 = r100.getTabRefresh();
        if (r150 == null) goto L79;
        r150.observe(this, new bw1.a(r149));
    L79:
        SingleDrawViewModel r151 = r149.f21000a;
        if (r151 == null) goto L84;
        NextLiveData<Long> r152 = r151.getChangeTab();
        if (r152 == null) goto L84;
        r152.observe(this, new bw1.b(r149));
    L84:
        SingleDrawViewModel r153 = r149.f21000a;
        if (r153 == null) goto L89;
        NextLiveData<Long> r154 = r153.getLoadMore();
        if (r154 == null) goto L89;
        r154.observe(this, new bw1.c(r149));
    L89:
        o r155 = u.l().c(x.class);
        String r101 = "";
        if (r155.getMap().containsKey("enter_from_merge") == false) goto L92;
        String r156 = r155.getMap().get("enter_from_merge");
    L93:
        if (r156 != null) goto L96;
        r156 = "";
    L96:
        if (r155.getMap().containsKey("enter_method") == false) goto L98;
        String r157 = r155.getMap().get("enter_method");
    L99:
        if (r157 == null) goto L102;
        r101 = r157;
    L102:
        TabListModel r158 = this.f123767f;
        int r102 = 1;
        if (r158 == null) goto L134;
        List<com.bytedance.android.livesdk.feed.feed.e> r159 = r158.getTabList();
        if (r159 == null) goto L134;
        ArrayList r103 = new ArrayList();
        Iterator<T> r160 = r159.iterator();
    L108:
        if (r160.hasNext() == false) goto L135;
        Object r104 = r160.next();
        com.bytedance.android.livesdk.feed.feed.e r105 = (com.bytedance.android.livesdk.feed.feed.e) r104;
        List<String> r106 = r105.b();
        if (r106 != null) goto L112;
    L115:
        boolean r107 = true;
    L116:
        if (r107 == false) goto L118;
    L119:
        List<String> r108 = r105.d();
        if (r108 != null) goto L122;
    L125:
        boolean r109 = true;
    L126:
        if (r109 == false) goto L128;
    L131:
        boolean r161 = true;
    L132:
        if (r161 == false) goto L108;
        r103.add(r104);
        goto L108
    L128:
        if (LiveDrawerUrlHelper.isParamInList(r156, r101, r105.d()) == true) goto L131;
    L130:
        r161 = false;
        goto L132
    L122:
        if (r108.isEmpty() == true) goto L125;
        r109 = false;
        goto L126
    L118:
        if (LiveDrawerUrlHelper.isParamInList(r156, r101, r105.b()) == true) goto L130;
    L112:
        if (r106.isEmpty() == true) goto L115;
        r107 = false;
    L135:
        Bundle r162 = getArguments();
        if (r162 == null) goto L147;
        boolean r163 = r162.getBoolean("switch_follow", false);
        long r164 = r162.getLong("default_tab_type", -1);
        TabListModel r165 = this.f123767f;
        if (r165 == null) goto L140;
        r165.setTagId(r162.getLong("tag_id", -1));
    L140:
        TabListModel r166 = this.f123767f;
        if (r166 == null) goto L149;
        Bundle r167 = getArguments();
        if (r167 == null) goto L145;
        long r168 = r167.getLong("tab_type");
    L146:
        r166.setTabType(r168);
        goto L149
    L145:
        r168 = -1;
    L149:
        if (bx1.a.b(r156) == true) goto L191;
        if (r163 == true) goto L191;
        if (bx1.a.a(r156) == true) goto L155;
    L170:
        List<String> r169 = bx1.a.f21277a;
        if (TextUtils.isEmpty(r156) == false) goto L173;
    L175:
        boolean r170 = false;
    L176:
        if (r170 == true) goto L178;
    L192:
        if (r103 == null) goto L201;
        Iterator r171 = r103.iterator();
    L195:
        if (r171.hasNext() == false) goto L201;
        com.bytedance.android.livesdk.feed.feed.e r172 = (com.bytedance.android.livesdk.feed.feed.e) r171.next();
        if (r172.getType() != r102) goto L195;
        TabListModel r173 = this.f123767f;
        if (r173 == null) goto L195;
        r173.setDefaultTab(r172);
    L201:
        if (r103 == null) goto L215;
        Iterator r174 = r103.iterator();
    L204:
        if (r174.hasNext() == false) goto L215;
        com.bytedance.android.livesdk.feed.feed.e r175 = (com.bytedance.android.livesdk.feed.feed.e) r174.next();
        long r176 = r175.f();
        TabListModel r177 = this.f123767f;
        if (r177 == null) goto L204;
        bw1.e r178 = r177.getCurrentTabModel();
        if (r178 == null) goto L204;
        if (r176 != r178.g()) goto L204;
        TabListModel r179 = this.f123767f;
        if (r179 == null) goto L204;
        r179.setDefaultTab(r175);
    L215:
        if (r164 == (-1)) goto L226;
        if (r103 == null) goto L226;
        Iterator r180 = r103.iterator();
    L219:
        if (r180.hasNext() == false) goto L226;
        com.bytedance.android.livesdk.feed.feed.e r181 = (com.bytedance.android.livesdk.feed.feed.e) r180.next();
        if (r181.getType() != ((int) r164)) goto L219;
        TabListModel r182 = this.f123767f;
        if (r182 == null) goto L219;
        r182.setDefaultTab(r181);
    L226:
        return this.f123766e;
    L178:
        if (r103 == null) goto L189;
        Iterator r183 = r103.iterator();
    L181:
        if (r183.hasNext() == false) goto L188;
        Object r184 = r183.next();
        if (((com.bytedance.android.livesdk.feed.feed.e) r184).getType() != 4) goto L185;
        boolean r185 = true;
    L186:
        if (r185 == false) goto L181;
        r114 = r184;
        goto L188
    L185:
        r185 = false;
    L188:
        r114 = (com.bytedance.android.livesdk.feed.feed.e) r114;
    L189:
        if (r114 == null) goto L192;
        r102 = 4;
        goto L192
    L173:
        if (CollectionsKt.contains(bx1.a.f21279c, r156) == false) goto L175;
        r170 = true;
        goto L176
    L155:
        if (r103 == null) goto L167;
        Iterator r186 = r103.iterator();
    L158:
        if (r186.hasNext() == false) goto L165;
        Object r187 = r186.next();
        if (((com.bytedance.android.livesdk.feed.feed.e) r187).getType() != 3) goto L162;
        boolean r188 = true;
    L163:
        if (r188 == false) goto L158;
    L166:
        com.bytedance.android.livesdk.feed.feed.e r189 = (com.bytedance.android.livesdk.feed.feed.e) r187;
    L168:
        if (r189 == null) goto L170;
        r102 = 3;
        goto L192
    L162:
        r188 = false;
        goto L163
    L165:
        r187 = null;
        goto L166
    L167:
        r189 = null;
    L191:
        r102 = 2;
        goto L192
    L147:
        r164 = -1;
        r163 = false;
    L134:
        r103 = null;
        goto L135
    L98:
        r157 = "";
        goto L99
    L92:
        r156 = "";
        goto L93
    L69:
        r147 = null;
        goto L70
    L65:
        r145 = null;
        goto L66
    L61:
        r143 = null;
        goto L62
    L57:
        r141 = null;
        goto L58
    L53:
        r139 = null;
        goto L54
    L49:
        r137 = null;
        goto L50
    L45:
        r135 = null;
        goto L46
    L41:
        r133 = null;
        goto L42
    L37:
        r131 = null;
        goto L38
    L33:
        r129 = null;
        goto L34
    L29:
        r127 = null;
        goto L30
    L25:
        r125 = null;
        goto L26
    L21:
        r123 = null;
        goto L22
    L17:
        r121 = null;
        goto L18
    L13:
        r119 = null;
        goto L14
    L9:
        r117 = null;
        goto L10
    L5:
        r115 = null;
        goto L6
    }
}
