package com.bytedance.android.livesdk.feed.drawerfeed.viewholder;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.widget.TextView;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.OnLifecycleEvent;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.base.model.feed.FeedItem;
import com.bytedance.android.live.base.model.follow.ScheduledLiveItem;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.core.monitor.NewBroadcastMonitor;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.core.viewholder.BaseViewHolder;
import com.bytedance.android.live.user.IUserService;
import com.bytedance.android.livehostapi.business.IHostBusiness;
import com.bytedance.android.livehostapi.business.depend.feed.IDrawerFeedAction;
import com.bytedance.android.livehostapi.platform.IHostAction;
import com.bytedance.android.livesdk.config.gp;
import com.bytedance.android.livesdk.feed.c1;
import com.bytedance.android.livesdk.feed.drawerfeed.utils.WrapperLinearLayoutManager;
import com.bytedance.android.livesdk.livecommerce.utils.LogRule;
import com.bytedance.android.livesdkapi.LiveCommonConstants;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.nova.R;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import me.drakeet.multitype.Items;
import me.drakeet.multitype.MultiTypeAdapter;

/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003J\b\u0010\u0005\u001a\u00020\u0004H\u0007J\b\u0010\u0006\u001a\u00020\u0004H\u0007¨\u0006\u0007"}, d2 = {"Lcom/bytedance/android/livesdk/feed/drawerfeed/viewholder/DrawerHistoryItemViewHolder;", "Lcom/bytedance/android/live/core/viewholder/BaseViewHolder;", "Lcom/bytedance/android/live/base/model/feed/FeedItem;", "Landroidx/lifecycle/LifecycleObserver;", "", "onResume", LiveCommonConstants.REASON_ON_DEDTROY, "livefeed_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class DrawerHistoryItemViewHolder extends BaseViewHolder<FeedItem> implements LifecycleObserver {

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final /* synthetic */ int f123872n = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final CompositeDisposable f123873a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final RecyclerView f123874b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final MultiTypeAdapter f123875c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public FeedItem f123876d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Items f123877e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final View f123878f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final TextView f123879g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final TextView f123880h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f123881i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final b f123882j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final View f123883k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final Lifecycle f123884l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final IDrawerFeedAction f123885m;

    /* JADX INFO: renamed from: com.bytedance.android.livesdk.feed.drawerfeed.viewholder.DrawerHistoryItemViewHolder$1, reason: invalid class name */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "p1", "Lcom/bytedance/android/live/base/model/feed/FeedItem;", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 4, 3})
    public static final /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function1<FeedItem, Unit> {
        public AnonymousClass1(DrawerHistoryItemViewHolder r100) {
            super(1, r100, DrawerHistoryItemViewHolder.class, "onItemDelete", "onItemDelete(Lcom/bytedance/android/live/base/model/feed/FeedItem;)V", 0);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(FeedItem r110) {
            DrawerHistoryItemViewHolder r100 = (DrawerHistoryItemViewHolder) this.receiver;
            int r101 = DrawerHistoryItemViewHolder.f123872n;
            r100.getClass();
            if (r110 == null) goto L53;
            Ref.IntRef r102 = new Ref.IntRef();
            r102.element = -1;
            FeedItem r103 = r100.f123876d;
            int r104 = 0;
            if (r103 == null) goto L21;
            List<FeedItem> r105 = r103.getLiveHistoryItems();
            if (r105 == null) goto L21;
            Iterator<T> r106 = r105.iterator();
            int r107 = 0;
        L11:
            if (r106.hasNext() == false) goto L21;
            Object r108 = r106.next();
            int r109 = r107 + 1;
            if (r107 >= 0) goto L15;
            CollectionsKt.throwIndexOverflow();
        L15:
            ScheduledLiveItem r111 = ((FeedItem) r108).scheduledLive;
            if (r111 == null) goto L20;
            if (r111.equals(r110.scheduledLive) != true) goto L20;
            r102.element = r107;
        L20:
            r107 = r109;
        L21:
            int r112 = r102.element;
            if (r112 < 0) goto L34;
            FeedItem r113 = r100.f123876d;
            if (r113 == null) goto L28;
            List<FeedItem> r114 = r113.getLiveHistoryItems();
            if (r114 == null) goto L28;
            r104 = r114.size();
        L28:
            if (r112 >= r104) goto L34;
            FeedItem r115 = r100.f123876d;
            if (r115 == null) goto L34;
            List<FeedItem> r116 = r115.getLiveHistoryItems();
            if (r116 == null) goto L34;
            FeedItem r117 = (FeedItem) ListProtector.remove(r116, r102.element);
        L34:
            r100.T3(r100.f123876d);
            r100.W3(r100.f123876d);
            if (r110.getHistoryStatus() != FeedItem.HistoryStatus.NORMAL) goto L51;
            RecyclerView r118 = r100.f123874b;
            if (r118 != null) goto L39;
        L45:
            new Handler(Looper.getMainLooper()).post(new s(r100, r102));
            return;
        L39:
            if (r118.isComputingLayout() == true) goto L45;
            RecyclerView r119 = r100.f123874b;
            if (r119 == null) goto L45;
            if (r119.getScrollState() != 0) goto L45;
            r100.f123875c.notifyItemRangeRemoved(r102.element, 1);
            return;
        L51:
            return;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(FeedItem r100) {
            invoke2(r100);
            return Unit.INSTANCE;
        }
    }

    public static final class a implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ DrawerHistoryItemViewHolder f123886a;

        public a(DrawerHistoryItemViewHolder r100) {
            this.f123886a = r100;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            FeedItem r101 = this.f123886a.f123876d;
            FeedItem.HistoryStatus r102 = null;
            if (r101 == null) goto L5;
            FeedItem.HistoryStatus r103 = r101.getHistoryStatus();
        L7:
            if (r103 != FeedItem.HistoryStatus.NO_LOGIN) goto L9;
            DrawerHistoryItemViewHolder r104 = this.f123886a;
            r104.getClass();
            com.bytedance.android.livesdk.user.f r105 = ((IUserService) jc1.k.n(IUserService.class)).user();
            Context r106 = r104.itemView.getContext();
            com.bytedance.android.livesdk.user.l.a r107 = new com.bytedance.android.livesdk.user.l.a();
            r107.f158687c = -1;
            r105.login(r106, new com.bytedance.android.livesdk.user.l(r107)).subscribe(r104.f123882j);
            r104.f123873a.add(((IUserService) jc1.k.n(IUserService.class)).user().m().filter(p.f123980a).subscribe(new q(r104), r.f123982a));
            return;
        L9:
            FeedItem r108 = this.f123886a.f123876d;
            if (r108 == null) goto L13;
            r102 = r108.getHistoryStatus();
        L13:
            if (r102 != FeedItem.HistoryStatus.NO_PERiMISSION) goto L17;
            DrawerHistoryItemViewHolder r109 = this.f123886a;
            r109.getClass();
            ((IHostAction) jc1.k.n(IHostAction.class)).handleSchema(r109.itemView.getContext(), "aweme://setting/browsing_history", new Bundle());
            return;
        L17:
            return;
        L5:
            r103 = null;
            goto L7
        }
    }

    public static final class b extends com.bytedance.android.livesdk.user.h<IBaseUser> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ DrawerHistoryItemViewHolder f123887a;

        public b(DrawerHistoryItemViewHolder r100) {
            this.f123887a = r100;
        }

        @Override // com.bytedance.android.livesdk.user.h, io.reactivex.Observer
        public final void onSubscribe(Disposable r100) {
            Intrinsics.checkNotNullParameter(r100, "d");
            this.f123887a.f123873a.add(r100);
        }
    }

    public static final class c<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ DrawerHistoryItemViewHolder f123888a;

        public c(DrawerHistoryItemViewHolder r100) {
            this.f123888a = r100;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            FeedItem r101 = (FeedItem) r100;
            DrawerHistoryItemViewHolder r102 = this.f123888a;
            if (r101 != null) goto L5;
            int r103 = DrawerHistoryItemViewHolder.f123872n;
            r102.getClass();
            return;
        L5:
            FeedItem r104 = r102.f123876d;
            if (r104 == null) goto L8;
            r104.setLiveHistoryItems(r101.getLiveHistoryItems());
            r104.setHistoryStatus(r101.getHistoryStatus());
            r104.setHasMoreHistoryItems(r101.getHasMoreHistoryItems());
        L8:
            r102.T3(r102.f123876d);
            r102.W3(r102.f123876d);
            if (r101.getHistoryStatus() != FeedItem.HistoryStatus.NORMAL) goto L22;
            RecyclerView r105 = r102.f123874b;
            if (r105 != null) goto L13;
        L19:
            new Handler(Looper.getMainLooper()).post(new t(r102));
            return;
        L13:
            if (r105.isComputingLayout() == true) goto L19;
            RecyclerView r106 = r102.f123874b;
            if (r106 == null) goto L19;
            if (r106.getScrollState() != 0) goto L19;
            r102.f123875c.notifyDataSetChanged();
            return;
        }
    }

    public static final class d<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final d f123889a = null;

        static {
            f123889a = new d();
        }

        public d() {
        }

        @Override // io.reactivex.functions.Consumer
        public final /* bridge */ /* synthetic */ void accept(Object r100) {
            Throwable r101 = (Throwable) r100;
        }
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    public final void onDestroy() {
        this.f123884l.removeObserver(this);
        this.f123873a.dispose();
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    public final void onResume() {
        FeedItem r100 = this.f123876d;
        if (r100 != null) goto L5;
        return;
    L5:
        if (r100.getHistoryStatus() != FeedItem.HistoryStatus.NO_PERiMISSION) goto L11;
        IHostBusiness r101 = (IHostBusiness) jc1.k.f(IHostBusiness.class);
        if (r101 == null) goto L11;
        boolean r102 = true;
        if (r101.hasLiveHistoryPermission() != true) goto L11;
    L12:
        if (r102 == true) goto L15;
        r100 = null;
    L15:
        if (r100 == null) goto L19;
        V3();
        return;
    L19:
        return;
    L11:
        r102 = false;
        goto L12
    }

    public final void V3() {
        Disposable r100 = c1.a().observeOn(AndroidSchedulers.mainThread()).subscribeOn(Schedulers.io()).subscribe(new c(this), d.f123889a);
        this.f123873a.add(r100);
    }

    public static void U3(String r100) {
        LinkedHashMap r101 = new LinkedHashMap();
        r101.put("enter_from_merge", "drawer_hot");
        r101.put("enter_method", "live_history_card");
        IUserService r102 = (IUserService) jc1.k.f(IUserService.class);
        if (r102 == null) goto L8;
        com.bytedance.android.livesdk.user.f r103 = r102.user();
        if (r103 == null) goto L8;
        String r104 = r103.n();
        if (r104 == null) goto L8;
    L9:
        r101.put("user_id", r104);
        r101.put("empty_reason", r100);
        com.bytedance.android.livesdk.log.u.l().sendLog("livesdk_history_empty", r101, new Object[0]);
        return;
    L8:
        r104 = "";
        goto L9
    }

    public final void T3(FeedItem r100) {
        if (r100 != null) goto L5;
        return;
    L5:
        if (r100.getHistoryStatus() == FeedItem.HistoryStatus.NORMAL) goto L7;
        return;
    L7:
        this.f123877e.clear();
        List<FeedItem> r101 = r100.getLiveHistoryItems();
        if (r101 == null) goto L15;
        long r102 = r101.size();
        gp r103 = gp.f120304a;
        if (r102 <= r103.getValue().a()) goto L12;
        int r104 = (int) r103.getValue().a();
    L13:
        this.f123877e.addAll(r101.subList(0, r104));
        goto L15
    L12:
        r104 = r101.size();
    L15:
        if (this.f123877e.size() == 0) goto L17;
    L19:
        int r105 = this.f123877e.size();
        List<FeedItem> r106 = r100.getLiveHistoryItems();
        if (r106 == null) goto L22;
        int r107 = r106.size();
    L23:
        if (r105 >= r107) goto L25;
        this.f123881i = true;
    L31:
        if (r100.getHasMoreHistoryItems() == false) goto L33;
    L34:
        this.f123877e.add(k0.f123968a);
        return;
    L33:
        if (this.f123881i == true) goto L34;
        return;
    L25:
        int r108 = this.f123877e.size();
        List<FeedItem> r109 = r100.getLiveHistoryItems();
        if (r109 == null) goto L31;
        if (r108 != r109.size()) goto L31;
        this.f123881i = false;
        goto L31
    L22:
        r107 = 0;
        goto L23
    L17:
        if (r100.getHasMoreHistoryItems() == true) goto L19;
        r100.setHistoryStatus(FeedItem.HistoryStatus.EMPTY);
        this.f123881i = false;
        goto L31
    }

    public final void W3(FeedItem r100) {
        if (r100 != null) goto L5;
        return;
    L5:
        if (r100.getHistoryStatus() != FeedItem.HistoryStatus.NO_LOGIN) goto L23;
        View r101 = this.f123878f;
        if (r101 == null) goto L9;
        r101.setVisibility(0);
    L9:
        TextView r102 = this.f123880h;
        if (r102 == null) goto L12;
        r102.setVisibility(0);
    L12:
        RecyclerView r103 = this.f123874b;
        if (r103 == null) goto L15;
        r103.setVisibility(8);
    L15:
        TextView r104 = this.f123879g;
        if (r104 == null) goto L18;
        r104.setText(s1.C(R.string.ttlive_feed_drawer_live_history_tips, new Object[]{s1.B(R.string.ttlive_feed_drawer_live_history_tips_login)}));
    L18:
        TextView r105 = this.f123880h;
        if (r105 == null) goto L21;
        r105.setText(s1.B(R.string.ttlive_feed_drawer_live_history_action_login));
    L21:
        U3("no_register");
        return;
    L23:
        if (r100.getHistoryStatus() != FeedItem.HistoryStatus.EMPTY) goto L38;
        View r106 = this.f123878f;
        if (r106 == null) goto L27;
        r106.setVisibility(0);
    L27:
        TextView r107 = this.f123880h;
        if (r107 == null) goto L30;
        r107.setVisibility(8);
    L30:
        RecyclerView r108 = this.f123874b;
        if (r108 == null) goto L33;
        r108.setVisibility(8);
    L33:
        TextView r109 = this.f123879g;
        if (r109 == null) goto L36;
        r109.setText(s1.C(R.string.ttlive_feed_drawer_live_history_tips, new Object[]{s1.B(R.string.ttlive_feed_drawer_live_history_tips_empty)}));
    L36:
        U3("no_record");
        return;
    L38:
        if (r100.getHistoryStatus() != FeedItem.HistoryStatus.NO_PERiMISSION) goto L56;
        View r110 = this.f123878f;
        if (r110 == null) goto L42;
        r110.setVisibility(0);
    L42:
        TextView r111 = this.f123880h;
        if (r111 == null) goto L45;
        r111.setVisibility(0);
    L45:
        RecyclerView r112 = this.f123874b;
        if (r112 == null) goto L48;
        r112.setVisibility(8);
    L48:
        TextView r113 = this.f123879g;
        if (r113 == null) goto L51;
        r113.setText(s1.C(R.string.ttlive_feed_drawer_live_history_tips, new Object[]{s1.B(R.string.ttlive_feed_drawer_live_history_tips_permission)}));
    L51:
        TextView r114 = this.f123880h;
        if (r114 == null) goto L54;
        r114.setText(s1.B(R.string.ttlive_feed_drawer_live_history_action_permission));
    L54:
        U3(LogRule.REQUIRE_NO_AUTHORITY);
        return;
    L56:
        if (r100.getHistoryStatus() != FeedItem.HistoryStatus.NORMAL) goto L70;
        View r115 = this.f123878f;
        if (r115 == null) goto L60;
        r115.setVisibility(8);
    L60:
        TextView r116 = this.f123880h;
        if (r116 == null) goto L63;
        r116.setVisibility(8);
    L63:
        RecyclerView r117 = this.f123874b;
        if (r117 == null) goto L71;
        r117.setVisibility(0);
        return;
    L71:
        return;
    }

    @Override // com.bytedance.android.live.core.viewholder.BaseViewHolder
    public final void bind(FeedItem r100, int r101) {
        FeedItem r102 = r100;
        if (r102 == null) goto L20;
        this.f123876d = r102;
        T3(r102);
        W3(r102);
        if (r102.getHistoryStatus() != FeedItem.HistoryStatus.NORMAL) goto L18;
        RecyclerView r103 = this.f123874b;
        if (r103 != null) goto L10;
    L16:
        new Handler(Looper.getMainLooper()).post(new o(this));
        return;
    L10:
        if (r103.isComputingLayout() == true) goto L16;
        RecyclerView r104 = this.f123874b;
        if (r104 == null) goto L16;
        if (r104.getScrollState() != 0) goto L16;
        this.f123875c.notifyDataSetChanged();
        return;
    L18:
        return;
    }

    public DrawerHistoryItemViewHolder(View r100, Lifecycle r101, IDrawerFeedAction r102) {
        Intrinsics.checkNotNullParameter(r101, NewBroadcastMonitor.STAGE.LIFECYCLE);
        super(r100);
        this.f123883k = r100;
        this.f123884l = r101;
        this.f123885m = r102;
        this.f123873a = new CompositeDisposable();
        MultiTypeAdapter r103 = new MultiTypeAdapter();
        this.f123875c = r103;
        Items r104 = new Items();
        this.f123877e = r104;
        TextView r105 = null;
        if (r100 == null) goto L5;
        RecyclerView r106 = (RecyclerView) r100.findViewById(R.id.history_container);
    L6:
        this.f123874b = r106;
        if (r100 == null) goto L9;
        View r107 = r100.findViewById(R.id.tips_container);
    L10:
        this.f123878f = r107;
        if (r100 == null) goto L13;
        TextView r108 = (TextView) r100.findViewById(R.id.tv_empty_tips);
    L14:
        this.f123879g = r108;
        if (r100 == null) goto L17;
        r105 = (TextView) r100.findViewById(R.id.action_btn);
    L17:
        this.f123880h = r105;
        r103.z2(FeedItem.class, new l0(new AnonymousClass1(this), r102));
        r103.z2(k0.class, new m0(r102));
        if (r106 == null) goto L20;
        r106.addItemDecoration(new DrawerHistoryItemViewHolder$2$1());
        r106.setLayoutManager(new WrapperLinearLayoutManager(r106.getContext()));
        r103.f513437a = r104;
        r106.setAdapter(r103);
    L20:
        if (r105 == null) goto L22;
        r105.setOnClickListener(new a(this));
    L22:
        r101.addObserver(this);
        this.f123882j = new b(this);
        return;
    L13:
        r108 = null;
        goto L14
    L9:
        r107 = null;
        goto L10
    L5:
        r106 = null;
        goto L6
    }
}
