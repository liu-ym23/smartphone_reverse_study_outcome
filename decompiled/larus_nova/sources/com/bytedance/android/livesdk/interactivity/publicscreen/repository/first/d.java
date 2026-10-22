package com.bytedance.android.livesdk.interactivity.publicscreen.repository.first;

import com.bytedance.android.live.base.model.message.k0;
import com.bytedance.android.live.base.model.message.u3;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.livehostapi.foundation.IMiddlewareHostNetwork;
import com.bytedance.android.livesdk.chatroom.IRoomContextService;
import com.bytedance.android.livesdk.chatroom.o;
import com.bytedance.android.livesdk.g7;
import com.bytedance.android.livesdk.interactivity.api.i;
import com.bytedance.android.livesdk.interactivity.api.monitor.PublicScreenTraceMonitor;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.utils.PublicScreenABHelper;
import com.bytedance.android.livesdk.interactivity.api.settings.config.s0;
import com.bytedance.android.livesdk.interactivity.api.utils.PSTopMessagePayload;
import com.bytedance.android.livesdk.interactivity.publicscreen.repository.NormalMessageRepoManagerV2;
import com.bytedance.android.livesdk.interactivity.publicscreen.utils.TextMessagePresenterUtil;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.live.datacontext.j;
import com.bytedance.live.datacontext.m;
import io.reactivex.Observable;
import io.reactivex.Single;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;
import jc1.k;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import r42.p;
import r52.g3;
import vlc.l;

/* JADX INFO: loaded from: classes9.dex */
public final class d implements vlc.h, l {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static final /* synthetic */ int f139386u = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f139387a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final o f139388b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final HashSet<Long> f139389c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final List<tlc.d> f139390d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final List<tlc.d> f139391e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final CompositeDisposable f139392f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final long f139393g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public Disposable f139394h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f139395i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f139396j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f139397k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f139398l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final DataCenter f139399m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final IRoom f139400n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final List<String> f139401o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final vlc.d f139402p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final vlc.h f139403q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final l f139404r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final Function1<p, Unit> f139405s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final Function1<List<? extends tlc.d>, Boolean> f139406t;

    public static final class a {
    }

    static {
    }

    public static final void b(d r100) {
        if (r100.f139395i == false) goto L6;
        r100.c("已处理置顶消息,不再请求backup接口");
        return;
    L6:
        if (r100.f139397k == false) goto L8;
        r100.c("已请求过backup接口,不再重复请求");
        return;
    L8:
        r100.f139397k = true;
        vlc.d r101 = r100.f139402p;
        String r102 = null;
        if ((r101 instanceof vlc.e) == true) goto L11;
        r101 = null;
    L11:
        vlc.e r103 = (vlc.e) r101;
        if (r103 == null) goto L20;
        int r104 = r42.a.f536022a;
        g r105 = new g(r100);
        Intrinsics.checkNotNullParameter(r103, "messageManager");
        Intrinsics.checkNotNullParameter(r105, "listener");
        StringBuilder r106 = new StringBuilder("https://");
        IMiddlewareHostNetwork r107 = (IMiddlewareHostNetwork) k.f(IMiddlewareHostNetwork.class);
        if (r107 == null) goto L16;
        r102 = r107.getHostDomain();
    L16:
        r106.append(r102);
        r106.append(hm2.c.f485751a);
        Single r108 = Single.create(new r42.c(r103, r106.toString()));
        int r109 = r42.g.f536040a;
        RxUtilKt.c(r108.timeout(Math.max(500, g3.f536185a.getValue().longValue()), TimeUnit.MILLISECONDS).observeOn(AndroidSchedulers.mainThread()).subscribe(new r42.d(r105), new r42.f(r105)), r100.f139392f);
        return;
    }

    public final void c(String r100) {
        if (this.f139387a == true) goto L5;
        return;
    L5:
        StringBuilder r101 = new StringBuilder();
        r101.append(r100);
        r101.append(" ,roomid:");
        IRoom r102 = this.f139400n;
        String r103 = null;
        if (r102 == null) goto L8;
        Long r104 = Long.valueOf(r102.getRoomId());
    L9:
        r101.append(r104);
        r101.append("，owner:");
        IRoom r105 = this.f139400n;
        if (r105 == null) goto L14;
        IBaseUser r106 = r105.getOwner();
        if (r106 == null) goto L14;
        r103 = r106.getNickName();
    L14:
        r101.append(r103);
        ALogger.d("PublicScreenFirstMessageProcessorV2", r101.toString());
        return;
    L8:
        r104 = null;
        goto L9
    }

    @Override // vlc.l
    public final void onMessage(tlc.d r100) {
        if (r100 != null) goto L5;
        return;
    L5:
        if (r100.isFromFirstRequest() == false) goto L7;
        return;
    L7:
        if (this.f139396j == false) goto L11;
        ((ArrayList) this.f139390d).add(r100);
        return;
    }

    /* JADX WARN: Type inference failed for: r2v0, types: [T, java.util.ArrayList] */
    public static final void a(final d r100, List r101) {
        if (r100.f139395i == true) goto L84;
        r100.c("置顶消息ready，消息数量：" + r101.size());
        r100.f139395i = true;
        Disposable r102 = r100.f139394h;
        if (r102 == null) goto L8;
        r102.dispose();
    L8:
        final Ref.ObjectRef r103 = new Ref.ObjectRef();
        ?? r104 = new ArrayList();
        r103.element = r104;
        r104.addAll(r101);
        Iterator r105 = ((List) r103.element).iterator();
    L9:
        tlc.d r106 = null;
        if (r105.hasNext() == false) goto L14;
        Object r107 = r105.next();
        if (Intrinsics.areEqual("WebcastRoomIntroMessage", ((tlc.d) r107).getMessageMethod()) == false) goto L9;
    L15:
        tlc.d r108 = (tlc.d) r107;
        if (r108 != null) goto L18;
    L22:
        List r109 = (List) r103.element;
        ArrayList r110 = new ArrayList();
        Iterator r111 = r109.iterator();
    L24:
        if (r111.hasNext() == false) goto L28;
        Object r112 = r111.next();
        if ((r112 instanceof k0) == false) goto L24;
        r110.add(r112);
        goto L24
    L28:
        Iterator r113 = r110.iterator();
    L30:
        if (r113.hasNext() == false) goto L32;
        ((k0) r113.next()).getOrInitPublicAreaCommon().setFirstAggregateHistoryMessage(true);
        goto L30
    L32:
        Iterator r114 = ((List) r103.element).iterator();
    L34:
        if (r114.hasNext() == false) goto L37;
        r100.f139389c.add(Long.valueOf(((tlc.d) r114.next()).getMessageId()));
        goto L34
    L37:
        if (r42.g.a(r100.f139400n, Boolean.FALSE) == true) goto L45;
        List r115 = (List) r103.element;
        ArrayList r116 = new ArrayList();
        Iterator r117 = r115.iterator();
    L40:
        if (r117.hasNext() == false) goto L44;
        Object r118 = r117.next();
        if ((!(((tlc.d) r118) instanceof k0)) == false) goto L40;
        r116.add(r118);
        goto L40
    L44:
        ((List) r103.element).clear();
        ((List) r103.element).addAll(r116);
    L45:
        Iterator r119 = ((List) r103.element).iterator();
        int r120 = 0;
    L47:
        if (r119.hasNext() == false) goto L55;
        Object r121 = r119.next();
        int r122 = r120 + 1;
        if (r120 >= 0) goto L51;
        CollectionsKt.throwIndexOverflow();
    L51:
        tlc.d r123 = (tlc.d) r121;
        if ((r123 instanceof u3) == false) goto L54;
        ((u3) r123).getOrInitPublicAreaCommon().setFirstFetchBatchMsg(true);
    L54:
        r120 = r122;
        goto L47
    L55:
        com.bytedance.android.livesdk.interactivity.api.h r124 = i.b(r100.f139399m, 1);
        if (r124 == null) goto L81;
        m<Boolean> r125 = r124.getHasLoadModel();
        if (r125 == null) goto L82;
        Disposable r126 = i80.a.a(r125, new PublicScreenFirstMessageProcessorV2$onTopMessageReady$7(r100, r103));
        if (r126 == null) goto L83;
        RxUtilKt.c(r126, r100.f139392f);
        return;
    L83:
        return;
    L82:
        return;
    L81:
        return;
    L18:
        if (TextMessagePresenterUtil.a(r108, r100.f139399m) == false) goto L20;
        r106 = r108;
    L20:
        if (r106 == null) goto L22;
        r100.c("置顶消息中发现了RoomIntro，需要异步处理，拎去RoomIntroPlugin");
        TextMessagePresenterUtil.b(r100.f139399m, r100.f139392f, r106);
        ((List) r103.element).remove(r106);
        goto L22
    L14:
        r107 = null;
        goto L15
    }

    @Override // vlc.h
    public final void onFirstMessage(List<? extends tlc.d> r100, boolean r101) {
        if (this.f139396j == false) goto L9;
        if (r100 == null) goto L11;
        Iterator r102 = CollectionsKt.filterNotNull(r100).iterator();
    L7:
        if (r102.hasNext() == false) goto L12;
        tlc.d r103 = (tlc.d) r102.next();
        ((ArrayList) this.f139391e).add(r103);
        goto L7
    L12:
        return;
    L11:
        return;
    }

    public d(DataCenter r100, IRoom r101, List r102, vlc.d r103, vlc.h r104, NormalMessageRepoManagerV2.a r105, Function1 r106, Function1 r107) {
        Intrinsics.checkNotNullParameter(r102, "msgTypes");
        Intrinsics.checkNotNullParameter(r104, "actualOnFirstMessageListener");
        Intrinsics.checkNotNullParameter(r105, "actualOnRealtimeMessageList");
        Intrinsics.checkNotNullParameter(r106, "historyStatusUpdater");
        Intrinsics.checkNotNullParameter(r107, "onTopMessageReady");
        this.f139399m = r100;
        this.f139400n = r101;
        this.f139401o = r102;
        this.f139402p = r103;
        this.f139403q = r104;
        this.f139404r = r105;
        this.f139405s = r106;
        this.f139406t = r107;
        this.f139387a = g7.f125384a.getValue().getLogEnable();
        IRoomContextService r108 = (IRoomContextService) k.f(IRoomContextService.class);
        if (r108 == null) goto L5;
        o r109 = IRoomContextService.a.a(r108, r100, 0, 2);
    L6:
        this.f139388b = r109;
        this.f139389c = new HashSet(128);
        this.f139390d = new ArrayList();
        this.f139391e = new ArrayList();
        this.f139392f = new CompositeDisposable();
        this.f139393g = PublicScreenABHelper.Q;
        this.f139396j = true;
        r42.a.c("public screen first message processor init");
        if (r103 == null) goto L9;
        r103.n(this);
    L9:
        Iterator r110 = r102.iterator();
    L11:
        if (r110.hasNext() == false) goto L15;
        String r111 = (String) r110.next();
        vlc.d r112 = this.f139402p;
        if (r112 == null) goto L11;
        r112.addMessageListener(r111, this);
        goto L11
    L15:
        o r113 = this.f139388b;
        if (r113 != null) goto L19;
        s0 r114 = PublicScreenTraceMonitor.f133304a;
        PublicScreenTraceMonitor.k(-10012, "v2 roomcontext为空", null);
        return;
    L19:
        if (Intrinsics.areEqual(r113.isVSRoom(), Boolean.TRUE) == false) goto L21;
    L31:
        c("media or vs room, don't  consume top message");
        return;
    L21:
        if (this.f139388b.isMediaRoom() == true) goto L31;
        Disposable r115 = this.f139394h;
        if (r115 == null) goto L26;
        r115.dispose();
    L26:
        Disposable r116 = Observable.timer(this.f139393g, TimeUnit.MILLISECONDS).observeOn(AndroidSchedulers.mainThread()).subscribe(new e(this), new f(this));
        RxUtilKt.c(r116, this.f139392f);
        this.f139394h = r116;
        com.bytedance.android.livesdk.interactivity.api.h r117 = i.b(this.f139399m, 1);
        if (r117 == null) goto L39;
        j<PSTopMessagePayload> r118 = r117.getPsTopMessage();
        if (r118 == null) goto L40;
        r118.c(new PublicScreenFirstMessageProcessorV2$observeTopMessage$3(this));
        return;
    L40:
        return;
    L39:
        return;
    L5:
        r109 = null;
        goto L6
    }
}
