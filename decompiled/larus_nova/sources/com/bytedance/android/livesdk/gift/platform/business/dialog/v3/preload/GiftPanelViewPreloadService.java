package com.bytedance.android.livesdk.gift.platform.business.dialog.v3.preload;

import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModelProviders;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.core.utils.ContextUtil;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.helper.v;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.preload.p006new.GiftPreloadManager;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.preload.p006new.GiftPreloadResType;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.preload.p006new.f;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.ItemListData;
import com.bytedance.android.livesdk.gift.platform.core.scope.service.GiftPanelMonitorService;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.scope.m;
import com.bytedance.android.scope.o;
import com.bytedance.ies.sdk.widgets.inflater.AsyncLayoutInflater;
import com.ss.android.lark.utils.statistics.PerfLog;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import yz0.k;

/* JADX INFO: loaded from: classes9.dex */
public final class GiftPanelViewPreloadService implements o {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final com.bytedance.android.livesdk.gift.platform.business.dialog.v3.preload.a f128160j = null;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final boolean f128161k = false;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final a f128162l = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final IRoom f128163a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final CompositeDisposable f128164b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f128165c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f128166d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public AsyncLayoutInflater f128167e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public GiftPanelPreloadViewModel f128168f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final LinkedList<ItemListData> f128169g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Context f128170h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final k f128171i;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/livesdk/gift/platform/business/dialog/v3/preload/GiftPanelViewPreloadService$PreloadSource;", "", "CLICK_ACTION_DOWN", "OPEN_RECHARGE_PANEL", "ENTER_ROOM_DELAY", "CLOSE_PANEL", "livegift-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final enum PreloadSource extends Enum<PreloadSource> {
        public static final PreloadSource CLICK_ACTION_DOWN = null;
        public static final PreloadSource CLOSE_PANEL = null;
        public static final PreloadSource ENTER_ROOM_DELAY = null;
        public static final PreloadSource OPEN_RECHARGE_PANEL = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ PreloadSource[] f128172a = null;

        static {
            PreloadSource r100 = new PreloadSource("CLICK_ACTION_DOWN", 0);
            CLICK_ACTION_DOWN = r100;
            PreloadSource r101 = new PreloadSource("OPEN_RECHARGE_PANEL", 1);
            OPEN_RECHARGE_PANEL = r101;
            PreloadSource r102 = new PreloadSource("ENTER_ROOM_DELAY", 2);
            ENTER_ROOM_DELAY = r102;
            PreloadSource r103 = new PreloadSource("CLOSE_PANEL", 3);
            CLOSE_PANEL = r103;
            f128172a = new PreloadSource[]{r100, r101, r102, r103};
        }

        public static PreloadSource valueOf(String r100) {
            return (PreloadSource) r27.a.a(PreloadSource.class, r100);
        }

        public static PreloadSource[] values() {
            return (PreloadSource[]) f128172a.clone();
        }

        public PreloadSource(String r100, int r101) {
            super(r100, r101);
        }
    }

    public static final class a {
        public a() {
        }

        public static View a(int r100) {
            if (GiftPanelViewPreloadService.f128161k == false) goto L6;
            HashMap<GiftPreloadResType, com.bytedance.android.livesdk.gift.platform.business.dialog.v3.preload.p006new.k<?>> r101 = GiftPreloadManager.f128195a;
            return (View) GiftPreloadManager.a(new f.b(r100));
        L6:
            i12.e r102 = i12.o.b();
            Object r103 = null;
            if (r102 == null) goto L9;
            Object r104 = m.f163449e.d(r102, GiftPanelViewPreloadService.class);
        L10:
            GiftPanelViewPreloadService r105 = (GiftPanelViewPreloadService) r104;
            if (r105 == null) goto L37;
            GiftPanelPreloadViewModel r106 = r105.f128168f;
            if (r106 == null) goto L15;
            View r107 = r106.getViewByLayoutId(r100);
        L16:
            GiftPanelPreloadViewModel r108 = r105.f128168f;
            if (r108 == null) goto L19;
            GiftPanelPreloadView r109 = r108.getViewTypeByLayoutId(r100);
        L20:
            if (r107 != null) goto L22;
            return null;
        L22:
            if (r109 != GiftPanelPreloadView.GiftSearchView) goto L26;
            if (r105.f128166d == false) goto L26;
        L29:
            i12.d r110 = i12.m.f487958e2.a();
            if (r110 == null) goto L32;
            r103 = m.f163449e.d(r110, GiftPanelMonitorService.class);
        L32:
            GiftPanelMonitorService r111 = (GiftPanelMonitorService) r103;
            if (r111 == null) goto L36;
            r111.f131372n = true;
        L36:
            return r107;
        L26:
            if (r109 != GiftPanelPreloadView.VerticalPageItem) goto L36;
            if (r105.f128166d == true) goto L36;
        L19:
            r109 = null;
            goto L20
        L15:
            r107 = null;
            goto L16
        L37:
            return null;
        L9:
            r104 = null;
            goto L10
        }
    }

    public static final class b<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ GiftPanelViewPreloadService f128173a;

        public b(GiftPanelViewPreloadService r100) {
            this.f128173a = r100;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            Long r101 = (Long) r100;
            this.f128173a.a(PreloadSource.ENTER_ROOM_DELAY);
        }
    }

    public static final class c<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ GiftPanelViewPreloadService f128174a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ PreloadSource f128175b;

        public c(GiftPanelViewPreloadService r100, PreloadSource r101) {
            this.f128174a = r100;
            this.f128175b = r101;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r110) {
            PreloadSource r111 = (PreloadSource) r110;
            GiftPanelPreloadViewModel r112 = this.f128174a.f128168f;
            if (r112 != null) goto L5;
        L7:
            StringBuilder r113 = new StringBuilder("start preload views, viewTypeCnt=");
            GiftPanelPreloadView.Companion.getClass();
            r113.append(((List) GiftPanelPreloadView.access$getAllViews$cp().getValue()).size());
            r113.append(" source=");
            r113.append(this.f128175b);
            jy0.b.d("ttlive_gift_preload", r113.toString());
            Iterator<T> r114 = ((List) GiftPanelPreloadView.access$getAllViews$cp().getValue()).iterator();
        L9:
            if (r114.hasNext() == false) goto L91;
            GiftPanelPreloadView r100 = (GiftPanelPreloadView) r114.next();
            GiftPanelViewPreloadService r101 = this.f128174a;
            PreloadSource r102 = this.f128175b;
            GiftPanelPreloadViewModel r103 = r101.f128168f;
            if (r103 == null) goto L13;
            int r104 = r103.getCachedViewCount(r100);
        L15:
            if (r104 >= r100.getCount()) goto L17;
            if (r100.isPanelView() == false) goto L26;
            if (GiftPanelViewPreloadService.f128160j.g() == false) goto L9;
        L26:
            if (r100.isGiftItemView() == false) goto L30;
            if (GiftPanelViewPreloadService.f128160j.f() == false) goto L9;
        L30:
            PreloadSource r105 = PreloadSource.CLICK_ACTION_DOWN;
            if (r102 != r105) goto L35;
            if (r100.getSupportTouchDown() == false) goto L9;
        L35:
            if (r102 == r105) goto L40;
            if (r100.getOnlyTouchDown() == true) goto L9;
        L40:
            if (r102 != PreloadSource.ENTER_ROOM_DELAY) goto L45;
            if (r100.isPanelView() == false) goto L9;
        L45:
            if (r102 != PreloadSource.CLOSE_PANEL) goto L49;
            if (r100.isPanelView() == false) goto L9;
        L49:
            int r106 = r100.getCount() - r104;
            if (1 > r106) goto L9;
            int r107 = 1;
        L53:
            if (r100.getHasParent() == false) goto L55;
            FrameLayout r108 = new FrameLayout(r101.f128170h);
        L56:
            AsyncLayoutInflater r109 = r101.f128167e;
            if (r109 == null) goto L59;
            r109.inflate(r100.getLayoutId(), r108, new com.bytedance.android.livesdk.gift.platform.business.dialog.v3.preload.b(r101, r100));
        L59:
            if (r107 == r106) goto L9;
            r107 = r107 + 1;
            goto L53
        L55:
            r108 = null;
            goto L56
        L17:
            if (r100.isPanelView() == false) goto L20;
            if (r100.getOnlyTouchDown() == false) goto L9;
        L20:
            r100.toString();
            goto L9
        L13:
            r104 = 0;
            goto L15
        L91:
            return;
        L5:
            if (r112.isCacheFull() != true) goto L7;
            jy0.b.d("ttlive_gift_preload", "intercept preInflate, view cache is already full");
        }
    }

    public static final class d<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ GiftPanelViewPreloadService f128176a;

        public d(GiftPanelViewPreloadService r100) {
            this.f128176a = r100;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            PreloadSource r101 = (PreloadSource) r100;
            long r102 = System.currentTimeMillis();
            ArrayList r103 = new ArrayList(500);
            int r104 = this.f128176a.f128169g.size();
        L3:
            if (r104 >= 500) goto L5;
            r103.add(new ItemListData());
            r104 = r104 + 1;
            goto L3
        L5:
            this.f128176a.f128169g.addAll(r103);
            jy0.b.d("ttlive_gift_preload", "itemListDataCache size=" + this.f128176a.f128169g.size() + " cost=" + (System.currentTimeMillis() - r102));
        }
    }

    @Override // com.bytedance.android.scope.o
    public final void onStart() {
        this.f128165c = true;
        this.f128167e = new AsyncLayoutInflater(this.f128170h);
        FragmentActivity r100 = ContextUtil.contextToFragmentActivity(this.f128170h);
        if (r100 == null) goto L5;
        this.f128168f = (GiftPanelPreloadViewModel) ViewModelProviders.of(r100).get(GiftPanelPreloadViewModel.class);
    L5:
        IBaseUser r101 = this.f128163a.getOwner();
        if (r101 != null) goto L8;
        return;
    L8:
        if (r101.isFollowing() != true) goto L12;
        Disposable r102 = Observable.timer(10, TimeUnit.SECONDS).observeOn(AndroidSchedulers.mainThread()).subscribe(new b(this));
        this.f128164b.add(r102);
        return;
    }

    static {
        f128162l = new a();
        f128160j = (com.bytedance.android.livesdk.gift.platform.business.dialog.v3.preload.a) GiftPreloadSettingsKt.f128178b.getValue(null, GiftPreloadSettingsKt.f128177a[0]);
        f128161k = ((Boolean) GiftPreloadSettingsKt.f128182f.getValue()).booleanValue();
    }

    @Override // com.bytedance.android.scope.o
    public final void onStop() {
        this.f128164b.dispose();
        this.f128165c = false;
    }

    public final void a(PreloadSource r100) {
        Intrinsics.checkNotNullParameter(r100, "source");
        if (f128161k == false) goto L6;
    L23:
        boolean r101 = false;
    L24:
        if (r101 == true) goto L26;
        return;
    L26:
        GiftPanelPreloadViewModel r102 = this.f128168f;
        if (r102 != null) goto L29;
    L31:
        RxUtilKt.c(Observable.just(r100).observeOn(Schedulers.computation()).subscribe(new c(this, r100)), this.f128164b);
        return;
    L29:
        if (r102.isCacheFull() != true) goto L31;
        return;
    L6:
        if (this.f128171i.isAnchor() == true) goto L23;
        if (i12.m.f487958e2.a() != null) goto L23;
        if (r100 != PreloadSource.CLICK_ACTION_DOWN) goto L15;
        r101 = f128160j.a();
        goto L24
    L15:
        if (r100 != PreloadSource.OPEN_RECHARGE_PANEL) goto L18;
        r101 = f128160j.c();
        goto L24
    L18:
        if (r100 != PreloadSource.ENTER_ROOM_DELAY) goto L21;
        r101 = f128160j.b();
        goto L24
    L21:
        if (r100 != PreloadSource.CLOSE_PANEL) goto L23;
        r101 = f128160j.d();
        goto L24
    }

    public final void c(PreloadSource r100) {
        Intrinsics.checkNotNullParameter(r100, "source");
        if (f128161k == false) goto L5;
        return;
    L5:
        RxUtilKt.c(Observable.just(r100).observeOn(Schedulers.computation()).subscribe(new d(this)), this.f128164b);
    }

    public GiftPanelViewPreloadService(Context r100, k r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "roomDataService");
        this.f128170h = r100;
        this.f128171i = r101;
        this.f128163a = r101.getRoom();
        this.f128164b = new CompositeDisposable();
        this.f128166d = v.c();
        this.f128169g = new LinkedList();
    }
}
