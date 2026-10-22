package com.bytedance.android.livesdk.ceremony.view;

import am2.x;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Bitmap;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.lifecycle.ViewModel;
import com.bytedance.android.live.core.utils.rxutils.RxUtil;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.liveinteract.api.IInteractService;
import com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge;
import com.bytedance.android.live.pkaudience.api.IPkAudienceLinkOutService;
import com.bytedance.android.live.user.IUserService;
import com.bytedance.android.livesdk.TTLiveSDKContext;
import com.bytedance.android.livesdk.ceremony.viewmodel.CeremonyViewModel;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.chatroom.VSDataContext;
import com.bytedance.android.livesdk.chatroom.utils.a1;
import com.bytedance.android.livesdk.chatroom.widget.RoomRecyclableWidget;
import com.bytedance.android.livesdk.gift.model.f1;
import com.bytedance.android.livesdk.gift.model.g1;
import com.bytedance.android.livesdk.log.u;
import com.bytedance.android.livesdk.message.model.bc;
import com.bytedance.android.livesdk.message.model.cc;
import com.bytedance.android.livesdk.message.model.gb;
import com.bytedance.android.livesdk.message.model.hi;
import com.bytedance.android.livesdk.user.f0;
import com.bytedance.android.livesdk.utils.p6;
import com.bytedance.android.livesdk.utils.r2;
import com.bytedance.android.livesdkapi.depend.live.player.ITextureViewPlayerController;
import com.bytedance.android.livesdkapi.depend.live.player.MaskSrc;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.service.IPerformanceManager;
import com.bytedance.ies.sdk.widgets.NextLiveData;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.nova.R;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import com.ss.android.ugc.effectmanager.MobConstants;
import com.ss.ttm.player.MediaPlayer;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.disposables.Disposables;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/livesdk/ceremony/view/CeremonyPrizeNoticeWidget;", "Lcom/bytedance/android/livesdk/chatroom/widget/RoomRecyclableWidget;", "<init>", "()V", "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class CeremonyPrizeNoticeWidget extends RoomRecyclableWidget {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public CeremonyViewModel f104909a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Lazy f104910b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Lazy f104911c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Lazy f104912d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public com.bytedance.android.livesdk.ceremony.viewmodel.a f104913e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public com.bytedance.android.livesdk.ceremony.viewmodel.a f104914f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Disposable f104915g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public ObjectAnimator f104916h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f104917i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final ArrayList<tf1.c> f104918j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final ArrayList<tf1.c> f104919k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public ObjectAnimator f104920l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public ObjectAnimator f104921m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final CompositeDisposable f104922n;

    public static final class a<T> implements Observer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ CeremonyPrizeNoticeWidget f104923a;

        public a(CeremonyPrizeNoticeWidget r100) {
            this.f104923a = r100;
        }

        @Override // androidx.lifecycle.Observer
        public final void onChanged(Object r100) {
            CeremonyPrizeNoticeWidget r101 = this.f104923a;
            r101.zq((tf1.c) r100);
        }
    }

    public static final class b<T> implements Observer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ CeremonyPrizeNoticeWidget f104924a;

        public b(CeremonyPrizeNoticeWidget r100) {
            this.f104924a = r100;
        }

        @Override // androidx.lifecycle.Observer
        public final void onChanged(Object r100) {
            tf1.c r101 = (tf1.c) r100;
            CeremonyPrizeNoticeWidget r102 = this.f104924a;
            com.bytedance.android.livesdk.ceremony.viewmodel.a r103 = r102.f104913e;
            if (r103 == null) goto L7;
            if (r101 == null) goto L8;
            r102.Aq(r103, (FrameLayout) r102.f104910b.getValue(), r101, true, r101.f545713e);
            return;
        L8:
            return;
        }
    }

    public static final class c<T> implements Observer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ CeremonyPrizeNoticeWidget f104925a;

        public c(CeremonyPrizeNoticeWidget r100) {
            this.f104925a = r100;
        }

        @Override // androidx.lifecycle.Observer
        public final void onChanged(Object r100) {
            tf1.c r101 = (tf1.c) r100;
            CeremonyViewModel r102 = this.f104925a.f104909a;
            if (r102 == null) goto L5;
            tf1.c r103 = r102.getCurrentPlayAsset();
        L7:
            if (CeremonyPrizeNoticeWidget.xq(this.f104925a, r103, r101) == false) goto L25;
            long r104 = 0;
            if (r103 == null) goto L11;
            long r105 = r103.f545713e;
        L12:
            if (r101 == null) goto L14;
            long r106 = r101.f545713e;
        L16:
            if (r105 >= r106) goto L26;
            if (r103 == null) goto L21;
            if (r101 == null) goto L20;
            r104 = r101.f545713e;
        L20:
            r103.f545713e = r104;
        L21:
            CeremonyViewModel r107 = this.f104925a.f104909a;
            if (r107 == null) goto L27;
            r107.finishConsumeNextPlayData();
            return;
        L27:
            return;
        L26:
            return;
        L14:
            r106 = 0;
            goto L16
        L11:
            r105 = 0;
            goto L12
        L25:
            return;
        L5:
            r103 = null;
            goto L7
        }
    }

    public static final class d implements Action {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ com.bytedance.android.livesdk.ceremony.viewmodel.a f104926a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ FrameLayout f104927b;

        public d(com.bytedance.android.livesdk.ceremony.viewmodel.a r100, FrameLayout r101) {
            this.f104926a = r100;
            this.f104927b = r101;
        }

        @Override // io.reactivex.functions.Action
        public final void run() {
            ITextureViewPlayerController r100 = this.f104926a.f104997b;
            if (r100 == null) goto L6;
            r100.stop();
            return;
        }
    }

    public static final class e<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ f1 f104928a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ List f104929b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ String f104930c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ List f104931d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ boolean f104932e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final /* synthetic */ boolean f104933f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final /* synthetic */ CeremonyPrizeNoticeWidget f104934g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final /* synthetic */ tf1.c f104935h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public final /* synthetic */ com.bytedance.android.livesdk.ceremony.viewmodel.a f104936i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public final /* synthetic */ FrameLayout f104937j;

        public e(f1 r100, List r101, String r102, List r103, boolean r104, boolean r105, CeremonyPrizeNoticeWidget r106, tf1.c r107, com.bytedance.android.livesdk.ceremony.viewmodel.a r108, FrameLayout r110) {
            this.f104928a = r100;
            this.f104929b = r101;
            this.f104930c = r102;
            this.f104931d = r103;
            this.f104932e = r104;
            this.f104933f = r105;
            this.f104934g = r106;
            this.f104935h = r107;
            this.f104936i = r108;
            this.f104937j = r110;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r110) {
            this.f104931d.add(new MaskSrc(this.f104928a.getPlaceholderKey(), 1, 0, 0, null, null, 0, false, ((Bitmap) r110).copy(Bitmap.Config.ARGB_8888, true), false, 752, null));
            int r100 = this.f104931d.size();
            int r101 = this.f104929b.size();
            List<g1> r102 = this.f104935h.f545718j;
            if (r102 == null) goto L5;
            int r103 = r102.size();
        L7:
            if (r100 != (r101 + r103)) goto L15;
            hi r104 = this.f104935h.f545716h;
            if (r104 == null) goto L13;
            List<MaskSrc> r105 = r104.getMaskSrcList();
            if (r105 == null) goto L13;
            this.f104931d.addAll(r105);
        L13:
            com.bytedance.android.livesdk.ceremony.viewmodel.a r106 = this.f104936i;
            Context r107 = this.f104934g.context;
            FrameLayout r108 = this.f104937j;
            String r109 = this.f104930c;
            boolean r111 = this.f104932e;
            List<MaskSrc> r112 = this.f104931d;
            boolean r113 = this.f104933f;
            tf1.c r114 = this.f104935h;
            r106.c(r107, r108, r109, r111, r112, r113, r114.f545709a, r114.a());
            xs2.b.a().post(new sf1.a(this.f104935h.f545709a));
            return;
        L15:
            return;
        L5:
            r103 = 0;
            goto L7
        }
    }

    public static final class f<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ f1 f104938a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ List f104939b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ String f104940c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ List f104941d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ boolean f104942e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final /* synthetic */ boolean f104943f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final /* synthetic */ CeremonyPrizeNoticeWidget f104944g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final /* synthetic */ tf1.c f104945h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public final /* synthetic */ com.bytedance.android.livesdk.ceremony.viewmodel.a f104946i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public final /* synthetic */ FrameLayout f104947j;

        public f(f1 r100, List r101, String r102, List r103, boolean r104, boolean r105, CeremonyPrizeNoticeWidget r106, tf1.c r107, com.bytedance.android.livesdk.ceremony.viewmodel.a r108, FrameLayout r110) {
            this.f104938a = r100;
            this.f104939b = r101;
            this.f104940c = r102;
            this.f104941d = r103;
            this.f104942e = r104;
            this.f104943f = r105;
            this.f104944g = r106;
            this.f104945h = r107;
            this.f104946i = r108;
            this.f104947j = r110;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r110) {
            Throwable r111 = (Throwable) r110;
            this.f104941d.add(new MaskSrc(this.f104938a.getPlaceholderKey() + "fail", 0, 0, 0, "default", null, 0, false, null, false, 992, null));
            int r112 = this.f104941d.size();
            int r100 = this.f104939b.size();
            List<g1> r101 = this.f104945h.f545718j;
            if (r101 == null) goto L5;
            int r102 = r101.size();
        L7:
            if (r112 != (r100 + r102)) goto L15;
            hi r113 = this.f104945h.f545716h;
            if (r113 == null) goto L13;
            List<MaskSrc> r114 = r113.getMaskSrcList();
            if (r114 == null) goto L13;
            this.f104941d.addAll(r114);
        L13:
            com.bytedance.android.livesdk.ceremony.viewmodel.a r103 = this.f104946i;
            Context r104 = this.f104944g.context;
            FrameLayout r105 = this.f104947j;
            String r106 = this.f104940c;
            boolean r107 = this.f104942e;
            List<MaskSrc> r108 = this.f104941d;
            boolean r109 = this.f104943f;
            tf1.c r115 = this.f104945h;
            r103.c(r104, r105, r106, r107, r108, r109, r115.f545709a, r115.a());
            xs2.b.a().post(new sf1.a(this.f104945h.f545709a));
            return;
        L15:
            return;
        L5:
            r102 = 0;
            goto L7
        }
    }

    @Override // com.bytedance.ies.sdk.widgets.Widget
    public final int getLayoutId() {
        return R.layout.ttlive_ceremony_prize_notice_widget;
    }

    @Override // com.bytedance.android.live.core.tetris.widgets.LiveRecyclableWidget
    public final void onInit(Object[] r100) {
    }

    public final ImageView yq() {
        return (ImageView) this.f104912d.getValue();
    }

    public final void Bq() {
        ObjectAnimator r100 = this.f104916h;
        if (r100 == null) goto L5;
        r100.cancel();
    L5:
        ObjectAnimator r101 = this.f104916h;
        if (r101 == null) goto L8;
        r101.removeAllListeners();
    L8:
        this.f104916h = null;
        ObjectAnimator r102 = this.f104920l;
        if (r102 == null) goto L11;
        r102.cancel();
    L11:
        ObjectAnimator r103 = this.f104920l;
        if (r103 == null) goto L14;
        r103.removeAllListeners();
    L14:
        this.f104920l = null;
        ObjectAnimator r104 = this.f104921m;
        if (r104 == null) goto L17;
        r104.cancel();
    L17:
        ObjectAnimator r105 = this.f104921m;
        if (r105 == null) goto L20;
        r105.removeAllListeners();
    L20:
        this.f104921m = null;
    }

    @Override // com.bytedance.android.live.core.tetris.widgets.LiveRecyclableWidget
    public final void onUnload() {
        CeremonyViewModel r100 = this.f104909a;
        if (r100 == null) goto L5;
        r100.clearQueue();
    L5:
        this.f104917i = false;
        Bq();
        com.bytedance.android.livesdk.ceremony.viewmodel.a r101 = this.f104913e;
        if (r101 == null) goto L8;
        r101.a();
    L8:
        this.f104913e = null;
        Disposable r102 = this.f104915g;
        if (r102 == null) goto L11;
        r102.dispose();
    L11:
        this.f104915g = null;
        this.f104918j.clear();
        com.bytedance.android.livesdk.ceremony.viewmodel.a r103 = this.f104914f;
        if (r103 == null) goto L14;
        r103.a();
    L14:
        this.f104914f = null;
        this.f104919k.clear();
        this.f104922n.clear();
    }

    public CeremonyPrizeNoticeWidget() {
        this.f104910b = LazyKt.lazy(new CeremonyPrizeNoticeWidget$prizeNoticeVideoView$2(this));
        this.f104911c = LazyKt.lazy(new CeremonyPrizeNoticeWidget$bottomVideoView$2(this));
        this.f104912d = LazyKt.lazy(new CeremonyPrizeNoticeWidget$prizeNoticeImageView$2(this));
        this.f104918j = new ArrayList();
        this.f104919k = new ArrayList();
        this.f104922n = new CompositeDisposable();
    }

    @Override // com.bytedance.android.live.core.tetris.widgets.LiveRecyclableWidget
    public final void onLoad(Object[] r100) {
        VSDataContext r101 = VSDataContext.a.c(VSDataContext.Companion, this.dataCenter);
        ViewModel r102 = null;
        if (r101 == null) goto L8;
        com.bytedance.live.datacontext.m<Boolean> r103 = r101.isVSVideo();
        if (r103 == null) goto L8;
        if (r103.getValue().booleanValue() != true) goto L8;
    L18:
        ViewModel r104 = r101.getCeremonyViewModel().getValue();
        if ((r104 instanceof CeremonyViewModel) == false) goto L22;
        r102 = r104;
    L22:
        CeremonyViewModel r105 = (CeremonyViewModel) r102;
    L34:
        this.f104909a = r105;
        if (r105 == null) goto L37;
        r105.initMessageManager();
    L37:
        this.f104913e = new com.bytedance.android.livesdk.ceremony.viewmodel.a();
        this.f104914f = new com.bytedance.android.livesdk.ceremony.viewmodel.a();
        CeremonyViewModel r106 = this.f104909a;
        if (r106 == null) goto L42;
        NextLiveData<tf1.c> r107 = r106.getVerticalPrizeNoticeModel();
        if (r107 == null) goto L42;
        r107.observe(this, new a(this));
    L42:
        CeremonyViewModel r108 = this.f104909a;
        if (r108 == null) goto L47;
        NextLiveData<tf1.c> r109 = r108.getCurrentPlayTopAsset();
        if (r109 == null) goto L47;
        r109.observe(this, new b(this), true);
    L47:
        CeremonyViewModel r110 = this.f104909a;
        if (r110 == null) goto L53;
        NextLiveData<tf1.c> r111 = r110.getNextPlayTopAsset();
        if (r111 == null) goto L54;
        r111.observe(this, new c(this), true);
        return;
    L54:
        return;
    L53:
        return;
    L8:
        if (r101 == null) goto L13;
        com.bytedance.live.datacontext.m<Boolean> r112 = r101.isVSFirstShow();
        if (r112 == null) goto L13;
        if (r112.getValue().booleanValue() == true) goto L18;
    L13:
        if (r101 == null) goto L23;
        com.bytedance.live.datacontext.m<Boolean> r113 = r101.isVSLive();
        if (r113 == null) goto L23;
        if (r113.getValue().booleanValue() == true) goto L18;
    L23:
        RoomContext r114 = getRoomContext();
        if (r114 == null) goto L28;
        com.bytedance.live.datacontext.j<ViewModel> r115 = r114.getCeremonyViewModel();
        if (r115 == null) goto L28;
        ViewModel r116 = r115.getValue();
    L30:
        if ((r116 instanceof CeremonyViewModel) == false) goto L33;
        r102 = r116;
    L33:
        r105 = (CeremonyViewModel) r102;
    L28:
        r116 = null;
        goto L30
    }

    public final void zq(tf1.c r100) {
        if (r100 != null) goto L5;
        return;
    L5:
        if (this.f104917i == false) goto L8;
        this.f104919k.add(r100);
        CollectionsKt.sort(this.f104919k);
        return;
    L8:
        com.bytedance.android.livesdk.ceremony.viewmodel.a r101 = this.f104914f;
        if (r101 == null) goto L12;
        Aq(r101, (FrameLayout) this.f104911c.getValue(), r100, false, r100.f545713e);
        return;
    }

    public static final void wq(CeremonyPrizeNoticeWidget r100, boolean r101) {
        if (r101 == false) goto L14;
        CeremonyViewModel r102 = r100.f104909a;
        if (r102 == null) goto L6;
        r102.finishPlay();
    L6:
        CeremonyViewModel r103 = r100.f104909a;
        if (r103 == null) goto L9;
        tf1.c r104 = r103.getCurrentPlayAsset();
    L10:
        if (r104 != null) goto L21;
        com.bytedance.android.livesdk.ceremony.viewmodel.a r105 = r100.f104913e;
        if (r105 == null) goto L22;
        r105.a();
        return;
    L22:
        return;
    L21:
        return;
    L9:
        r104 = null;
        goto L10
    L14:
        r100.f104917i = false;
        if (r100.f104919k.isEmpty() == false) goto L19;
        com.bytedance.android.livesdk.ceremony.viewmodel.a r106 = r100.f104914f;
        if (r106 == null) goto L24;
        r106.a();
        return;
    L24:
        return;
    L19:
        r100.zq((tf1.c) ListProtector.remove(r100.f104919k, 0));
    }

    public static final boolean xq(CeremonyPrizeNoticeWidget r110, tf1.c r111, tf1.c r112) {
        r110.getClass();
        if (r112 == null) goto L101;
        if (r111 != null) goto L8;
        return false;
    L8:
        if (r111.f545709a != r112.f545709a) goto L98;
        List<f1> r100 = r111.f545717i;
        List<f1> r101 = r112.f545717i;
        Boolean r102 = null;
        if (r100 != null) goto L13;
        if (r101 != null) goto L13;
        boolean r103 = true;
    L42:
        if (r103 == false) goto L99;
        List<g1> r113 = r111.f545718j;
        List<g1> r114 = r112.f545718j;
        if (r113 != null) goto L47;
        if (r114 != null) goto L47;
        boolean r115 = true;
    L73:
        if (r115 == false) goto L100;
        return true;
    L100:
        return false;
    L47:
        if (r113 == null) goto L49;
        Integer r104 = Integer.valueOf(r113.size());
    L50:
        if (r114 == null) goto L52;
        Integer r105 = Integer.valueOf(r114.size());
    L54:
        if ((!Intrinsics.areEqual(r104, r105)) == true) goto L70;
        if (r113 == null) goto L72;
        if (r114 == null) goto L72;
        Iterator<g1> r116 = r113.iterator();
    L60:
        if (r116.hasNext() == false) goto L71;
        g1 r106 = r116.next();
        Iterator<g1> r107 = r114.iterator();
        boolean r108 = false;
    L63:
        if (r107.hasNext() == false) goto L69;
        g1 r109 = r107.next();
        if (Intrinsics.areEqual(r106.getPlaceholderKey(), r109.getPlaceholderKey()) == false) goto L63;
        if (Intrinsics.areEqual(r106.getContent(), r109.getContent()) == false) goto L63;
        r108 = true;
        goto L63
    L69:
        if (r108 == true) goto L60;
    L71:
        r102 = Boolean.TRUE;
    L72:
        r115 = Intrinsics.areEqual(r102, Boolean.TRUE);
    L70:
        r115 = false;
        goto L73
    L52:
        r105 = null;
        goto L54
    L49:
        r104 = null;
        goto L50
    L99:
        return false;
    L13:
        if (r100 == null) goto L15;
        Integer r117 = Integer.valueOf(r100.size());
    L16:
        if (r101 == null) goto L18;
        Integer r118 = Integer.valueOf(r101.size());
    L20:
        if ((!Intrinsics.areEqual(r117, r118)) == true) goto L38;
        if (r100 == null) goto L40;
        if (r101 == null) goto L40;
        Iterator<f1> r119 = r100.iterator();
    L26:
        if (r119.hasNext() == false) goto L39;
        f1 r120 = r119.next();
        Iterator<f1> r121 = r101.iterator();
        boolean r122 = false;
    L29:
        if (r121.hasNext() == false) goto L37;
        f1 r123 = r121.next();
        if (Intrinsics.areEqual(r123.getPlaceholderKey(), r120.getPlaceholderKey()) == false) goto L29;
        py.k r124 = r123.getMixImage();
        if (r124 == null) goto L29;
        if (r124.equalsOnlyUri(r120.getMixImage()) != true) goto L29;
        r122 = true;
        goto L29
    L37:
        if (r122 == true) goto L26;
    L39:
        Boolean r125 = Boolean.TRUE;
    L41:
        r103 = Intrinsics.areEqual(r125, Boolean.TRUE);
    L40:
        r125 = null;
    L38:
        r103 = false;
        goto L42
    L18:
        r118 = null;
        goto L20
    L15:
        r117 = null;
        goto L16
    L98:
        return false;
    L101:
        return false;
    }

    public final void Aq(com.bytedance.android.livesdk.ceremony.viewmodel.a r310, FrameLayout r311, tf1.c r312, boolean r313, long r410) {
        String r110 = r312.f545710b;
        hi r100 = r312.f545716h;
        if (r100 == null) goto L7;
        final gb.a r101 = r100.getElementClickListener();
        if (r101 == null) goto L7;
        Function1<List<? extends String>, Unit> r102 = new CeremonyPrizeNoticeWidget$startPlay$1$1$1(r101);
        Intrinsics.checkNotNullParameter(r102, "onclick");
        r310.f104998c = r102;
    L7:
        r310.f105001f = new CeremonyPrizeNoticeWidget$startPlay$$inlined$apply$lambda$1(this, r312, r310, r311, r313);
        if (r313 == true) goto L11;
        this.f104917i = true;
    L11:
        hi r103 = r312.f545716h;
        Room r104 = null;
        String r105 = "0";
        if (r103 != null) goto L14;
        r110 = r110;
        boolean r106 = true;
    L102:
        cc r107 = r312.f545719k;
        if (r107 == null) goto L111;
        bc r108 = r107.getTopEffectExtra();
        if (r108 == null) goto L111;
        Map<String, String> r109 = r108.getParamsMap();
        if (r109 == null) goto L111;
        if ((r109.isEmpty() ^ r106) == false) goto L111;
    L113:
        if (r109 == null) goto L147;
        bc r111 = r107.getTopEffectExtra();
        if (r111 == null) goto L147;
        Map<String, String> r112 = r111.getParamsMap();
        if (r112 == null) goto L147;
        String r113 = r112.get("gift_role_is_character");
        if (r113 == null) goto L147;
        if (r113.equals("1") != true) goto L147;
        RoomContext r114 = (RoomContext) com.bytedance.live.datacontext.d.e(RoomContext.class, RoomContext.class);
        if (r114 == null) goto L129;
        com.bytedance.live.datacontext.m<Room> r115 = r114.getRoom();
        if (r115 == null) goto L129;
        Room r116 = r115.getValue();
    L130:
        Boolean r117 = (Boolean) this.dataCenter.get("data_is_anchor", Boolean.FALSE);
        String r118 = r109.get("trigger_room_id");
        String r119 = r109.get("trigger_user_id");
        String r120 = ((f0) ((com.bytedance.android.livesdk.service.f) TTLiveSDKContext.getHostService()).h()).n();
        if (r117.booleanValue() == false) goto L142;
        if (r2.a(r118) == false) goto L142;
        if (r118 == null) goto L142;
        if (r116 == null) goto L137;
        String r121 = String.valueOf(r116.getRoomId());
    L139:
        if (r118.equals(r121) != true) goto L142;
        LinkedHashMap r122 = new LinkedHashMap();
        r122.put(IPerformanceManager.Params.is_anchor, "1");
        r122.putAll(r109);
        u.l().sendLog("livesdk_gift_role_skill_effect_show", r122, new Object[]{x.class, Room.class});
        goto L147
    L137:
        r121 = null;
    L142:
        if (r2.a(r119) == false) goto L147;
        if (r119 == null) goto L147;
        if (r119.equals(r120) != true) goto L147;
        LinkedHashMap r123 = new LinkedHashMap();
        r123.put(IPerformanceManager.Params.is_anchor, "0");
        r123.putAll(r109);
        u.l().sendLog("livesdk_gift_role_skill_effect_result", r123, new Object[]{x.class, Room.class});
    L129:
        r116 = null;
    L147:
        cc r124 = r312.f545719k;
        if (r124 == null) goto L167;
        RoomContext r125 = (RoomContext) com.bytedance.live.datacontext.d.e(RoomContext.class, RoomContext.class);
        if (r125 == null) goto L155;
        com.bytedance.live.datacontext.m<Room> r126 = r125.getRoom();
        if (r126 == null) goto L155;
        r104 = r126.getValue();
    L155:
        LinkedHashMap r127 = new LinkedHashMap();
        if (r104 == null) goto L158;
        long r128 = r104.f162599id;
    L159:
        if (r104 == null) goto L162;
        String r129 = r104.getOwnerUserIdString();
        if (r129 == null) goto L162;
    L163:
        String r130 = ((f0) ((com.bytedance.android.livesdk.service.f) TTLiveSDKContext.getHostService()).h()).n();
        r127.put("room_id", String.valueOf(r128));
        r127.put("anchor_id", r129);
        r127.put("user_id", r130.toString());
        if (Intrinsics.areEqual(r129, r130) == false) goto L166;
        r105 = "1";
    L166:
        r127.put(IPerformanceManager.Params.is_anchor, r105);
        r127.put("activity_name", r124.getScene());
        r127.put(MobConstants.EFFECT_ID, String.valueOf(r124.getAssetId()));
        u.l().sendLog("livesdk_gift_top_baping_effect_show", r127, new Object[]{x.class, Room.class});
    L162:
        r129 = "0";
        goto L163
    L158:
        r128 = 0;
    L167:
        hi r131 = r312.f545716h;
        if (r131 == null) goto L173;
        CompositeDisposable r132 = r131.getPlayDisposable();
        if (r132 == null) goto L173;
        r132.add(Disposables.fromAction(new d(r310, r311)));
    L173:
        ArrayList r133 = new ArrayList();
        List<g1> r134 = r312.f545718j;
        if (r134 == null) goto L180;
        Iterator<g1> r135 = r134.iterator();
    L177:
        if (r135.hasNext() == false) goto L180;
        g1 r136 = r135.next();
        r133.add(new MaskSrc(r136.getPlaceholderKey(), 0, 0, 0, r136.getContent(), r136.getFontColor(), s1.f(r136.getFontSize()), false, null, false, MediaPlayer.MEDIA_PLAYER_OPTION_VIDEO_RENDER_FRAME_COUNT, null));
    L180:
        if (r410 <= (p6.b() / ((long) 1000))) goto L182;
        boolean r137 = true;
    L184:
        if (r312.f545715g <= 0) goto L186;
        boolean r138 = true;
    L187:
        List<f1> r139 = r312.f545717i;
        if (r139 != null) goto L190;
    L193:
        boolean r140 = true;
    L194:
        if (r140 == false) goto L202;
        hi r141 = r312.f545716h;
        if (r141 == null) goto L200;
        List<MaskSrc> r142 = r141.getMaskSrcList();
        if (r142 == null) goto L200;
        r133.addAll(r142);
    L200:
        r310.c(this.context, r311, r110, r137, r133, r138, r312.f545709a, r312.a());
        xs2.b.a().post(new sf1.a(r312.f545709a));
        return;
    L202:
        List<f1> r143 = r312.f545717i;
        Iterator<f1> r144 = r143.iterator();
    L204:
        if (r144.hasNext() == false) goto L206;
        f1 r210 = r144.next();
        String r145 = r110;
        boolean r146 = r137;
        boolean r147 = r138;
        List<f1> r211 = r143;
        this.f104922n.add(a1.k(r210.getMixImage()).compose(RxUtil.rxSchedulerHelper()).subscribe(new e(r210, r143, r145, r133, r146, r147, this, r312, r310, r311), new f(r210, r211, r145, r133, r146, r147, this, r312, r310, r311)));
        r143 = r211;
        goto L204
    L206:
        return;
    L190:
        if (r139.isEmpty() == true) goto L193;
        r140 = false;
        goto L194
    L186:
        r138 = false;
        goto L187
    L182:
        r137 = false;
    L111:
        r109 = null;
        goto L113
    L14:
        LinkedHashMap r148 = new LinkedHashMap();
        String r149 = "guest";
        if (r103.getExtra() == null) goto L46;
        r148.putAll(r103.getExtra());
        String r150 = ((f0) ((com.bytedance.android.livesdk.service.f) TTLiveSDKContext.getHostService()).h()).n();
        if (Intrinsics.areEqual("task_finish", r103.getExtra().get("animation_type")) == false) goto L46;
        com.bytedance.android.live.pkaudience.api.a r151 = ((IPkAudienceLinkOutService) jc1.k.n(IPkAudienceLinkOutService.class)).getPkLinkUserInfoCenter();
        IInteractService r152 = (IInteractService) jc1.k.f(IInteractService.class);
        if (r152 == null) goto L21;
        com.bytedance.android.live.liveinteract.plantform.base.i<ILinkPlayerInfoBridge> r153 = r152.getLinkUserInfoCenter();
    L22:
        if (r151 == null) goto L24;
        Integer r154 = Integer.valueOf(r151.O4(r150));
    L27:
        if (r154 == null) goto L29;
        int r155 = r154.intValue();
    L30:
        RoomContext r156 = RoomContext.a.c(RoomContext.Companion, null, 0, 3);
        if (r156 == null) goto L37;
        com.bytedance.live.datacontext.m<Room> r157 = r156.getRoom();
        if (r157 == null) goto L37;
        Room r158 = r157.getValue();
        if (r158 == null) goto L37;
        String r159 = r158.getOwnerUserIdString();
    L39:
        if (Intrinsics.areEqual(r159, r150) == false) goto L42;
        Object r160 = "anchor";
    L45:
        r148.put("trigger_type", r160);
        goto L46
    L42:
        if (r155 == (-1)) goto L44;
        r160 = "guest";
        goto L45
    L44:
        r160 = "";
    L37:
        r159 = null;
        goto L39
    L29:
        r155 = -1;
        goto L30
    L24:
        if (r153 == null) goto L26;
        r154 = Integer.valueOf(r153.O4(r150.toString()));
        goto L27
    L26:
        r154 = null;
        goto L27
    L21:
        r153 = null;
    L46:
        RoomContext r161 = (RoomContext) com.bytedance.live.datacontext.d.e(RoomContext.class, RoomContext.class);
        if (r161 == null) goto L51;
        com.bytedance.live.datacontext.m<Room> r162 = r161.getRoom();
        if (r162 == null) goto L51;
        Room r163 = r162.getValue();
    L52:
        if (r163 == null) goto L54;
        long r164 = r163.f162599id;
    L55:
        if (r163 == null) goto L58;
        String r165 = r163.getOwnerUserIdString();
        if (r165 == null) goto L58;
    L59:
        if (r163 != null) goto L61;
        String r166 = "";
    L62:
        r148.put("room_id", String.valueOf(r164));
        r148.put("anchor_id", r165);
        if (r166 != null) goto L65;
        r166 = "";
    L65:
        r148.put("request_id", r166);
        r148.put("scene_id", String.valueOf(r103.getSceneContextId()));
        IInteractService r167 = (IInteractService) jc1.k.f(IInteractService.class);
        if (r167 == null) goto L68;
        com.bytedance.android.live.liveinteract.plantform.base.i<ILinkPlayerInfoBridge> r168 = r167.getLinkUserInfoCenter();
    L69:
        com.bytedance.android.live.pkaudience.api.a r169 = ((IPkAudienceLinkOutService) jc1.k.n(IPkAudienceLinkOutService.class)).getPkLinkUserInfoCenter();
        IUserService r170 = (IUserService) jc1.k.f(IUserService.class);
        if (r170 == null) goto L101;
        com.bytedance.android.livesdk.user.f r171 = r170.user();
        if (r171 == null) goto L101;
        String r172 = r171.n();
        if (r172 == null) goto L101;
        RoomContext r173 = RoomContext.a.c(RoomContext.Companion, null, 0, 3);
        if (r173 == null) goto L82;
        com.bytedance.live.datacontext.m<Room> r174 = r173.getRoom();
        if (r174 == null) goto L82;
        Room r175 = r174.getValue();
        if (r175 == null) goto L82;
        String r176 = r175.getOwnerUserIdString();
    L84:
        if (Intrinsics.areEqual(r176, r172) == false) goto L86;
        String r177 = "anchor";
    L99:
        r148.put("user_type", r177);
        goto L101
    L86:
        if (r169 == null) goto L88;
        int r178 = r169.O4(r172);
    L90:
        Integer r179 = Integer.valueOf(r178);
    L92:
        if (r179 == null) goto L94;
        int r180 = r179.intValue();
        int r181 = -1;
    L95:
        if (r180 != r181) goto L98;
        r149 = "user";
    L98:
        r177 = r149;
        goto L99
    L94:
        r181 = -1;
        r180 = -1;
        goto L95
    L88:
        if (r168 == null) goto L91;
        r178 = r168.O4(r172);
        goto L90
    L91:
        r179 = null;
    L82:
        r176 = null;
    L101:
        r106 = true;
        u.l().sendLog("livesdk_prizenotice_animation_show", r148, new Object[]{x.class, Room.class});
        goto L102
    L68:
        r168 = null;
        goto L69
    L61:
        r166 = r163.getRequestId();
    L58:
        r165 = "0";
        goto L59
    L54:
        r164 = 0;
    L51:
        r163 = null;
        goto L52
    }
}
