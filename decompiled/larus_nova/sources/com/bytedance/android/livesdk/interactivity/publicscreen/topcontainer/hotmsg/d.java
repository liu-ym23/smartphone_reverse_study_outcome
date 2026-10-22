package com.bytedance.android.livesdk.interactivity.publicscreen.topcontainer.hotmsg;

import android.util.AttributeSet;
import com.bytedance.android.live.base.model.message.i;
import com.bytedance.android.live.base.model.message.k6;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.MainThreadPostUtils;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.ktv.common.util.KtvSubElement;
import com.bytedance.android.livesdk.chatroom.IRoomContextService;
import com.bytedance.android.livesdk.chatroom.o;
import com.bytedance.android.livesdk.chatroom.progress.context.PlayerProgressServiceContext;
import com.bytedance.android.livesdk.chatroom.progress.service.IPlayerProgressService;
import com.bytedance.android.livesdk.chatroom.vsplayer.api.IVSPlayerService;
import com.bytedance.android.livesdk.interactivity.api.h;
import com.bytedance.android.livesdk.interactivity.api.settings.config.z;
import com.bytedance.android.livesdkapi.depend.message.MessageType;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.perf.WidgetCostModule;
import com.bytedance.live.datacontext.j;
import com.bytedance.live.datacontext.m;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.apm.impl.protector.RunnableProtector;
import f32.f;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import jc1.k;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import vlc.l;

/* JADX INFO: loaded from: classes9.dex */
public final class d implements f52.d, l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public f52.b f139873a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public PlayerProgressServiceContext f139874b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f139875c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final CompositeDisposable f139876d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public NewHotMsgView f139877e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final List<Runnable> f139878f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public f32.e f139879g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final b f139880h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final String f139881i;

    public static final class a {
    }

    public static final class b implements h32.d<f32.e> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ d f139882a;

        public b(d r100) {
            this.f139882a = r100;
        }

        @Override // h32.d
        public final void a(f r100) {
            f32.e r101 = (f32.e) r100;
            Intrinsics.checkNotNullParameter(r101, "newConfig");
            this.f139882a.f139879g = r101;
        }
    }

    public static final class c implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ d f139883a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ List f139884b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ int f139885c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ Ref.ObjectRef f139886d;

        public c(d r100, List r101, int r102, Ref.ObjectRef r103) {
            this.f139883a = r100;
            this.f139884b = r101;
            this.f139885c = r102;
            this.f139886d = r103;
        }

        public final void a() {
            f52.b r100 = this.f139883a.f139873a;
            if (r100 != null) goto L5;
            Intrinsics.throwUninitializedPropertyAccessException(KtvSubElement.CONTAINER);
        L5:
            NewHotMsgPSTopView r101 = new NewHotMsgPSTopView((i) ListProtector.get(this.f139884b, this.f139885c), this.f139883a.d());
            r101.f139829n = ((k6) ((tlc.d) this.f139886d.element)).getHighlightAreaPriorityConfig();
            Unit r102 = Unit.INSTANCE;
            r100.a(r101);
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    static {
    }

    public final NewHotMsgView d() {
        NewHotMsgView r100 = this.f139877e;
        if (r100 != null) goto L10;
        f52.b r101 = this.f139873a;
        if (r101 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException(KtvSubElement.CONTAINER);
    L7:
        AttributeSet r102 = null;
        r100 = new NewHotMsgView(r101.getContext(), r102, 6, 0);
        r100.setVisibility(8);
        this.f139877e = r100;
        f52.b r103 = this.f139873a;
        if (r103 == null) goto L10;
        z.a r104 = z.f133764a;
        DataCenter r105 = r103.getDataCenter();
        r104.getClass();
        r100.setShowInPSHighlightArea(z.a.a(r105));
    L10:
        return r100;
    }

    @Override // f52.d
    public final void onUnload() {
        ALogger.i("NewHotMsgViewManager", "onUnload");
        this.f139876d.clear();
        Iterator r100 = ((ArrayList) this.f139878f).iterator();
    L4:
        if (r100.hasNext() == false) goto L6;
        MainThreadPostUtils.d((Runnable) r100.next());
        goto L4
    L6:
        ((ArrayList) this.f139878f).clear();
    }

    public d() {
        this.f139876d = new CompositeDisposable();
        this.f139878f = new ArrayList();
        this.f139879g = new f32.e(false, 3);
        this.f139880h = new b(this);
        this.f139881i = "NewHotMsgViewManager";
    }

    @Override // f52.d
    public final String getId() {
        return this.f139881i;
    }

    @Override // f52.d
    public final void j(f52.b r100) {
        Intrinsics.checkNotNullParameter(r100, KtvSubElement.CONTAINER);
        this.f139873a = r100;
        ALogger.i("NewHotMsgViewManager", WidgetCostModule.TYPE_ON_LOAD);
        o r101 = r100.getRoomContext();
        if (r101 == null) goto L5;
        boolean r102 = r101.isVSFirstShow();
    L6:
        this.f139875c = r102;
        DataCenter r103 = r100.getDataCenter();
        IVSPlayerService r104 = (IVSPlayerService) k.f(IVSPlayerService.class);
        if (r104 == null) goto L11;
        IPlayerProgressService r105 = r104.provideVSProgressService(r103);
        if (r105 == null) goto L11;
        PlayerProgressServiceContext r106 = r105.provideContext(r103);
    L12:
        this.f139874b = r106;
        IRoomContextService r107 = (IRoomContextService) k.f(IRoomContextService.class);
        if (r107 == null) goto L23;
        o r108 = IRoomContextService.a.a(r107, r103, 0, 2);
        if (r108 == null) goto L23;
        j<vlc.d> r109 = r108.getMessageManager();
        if (r109 == null) goto L23;
        vlc.d r110 = r109.getValue();
        if (r110 == null) goto L23;
        int r111 = com.bytedance.android.livesdk.interactivity.textmessage.utils.j.f141234a;
        Disposable r112 = com.bytedance.android.livesdk.interactivity.textmessage.utils.j.c(r110, MessageType.NEW_HOT_MSG_MESSAGE.getWsMethod(), this);
        if (r112 == null) goto L23;
        RxUtilKt.c(r112, this.f139876d);
    L23:
        h r113 = com.bytedance.android.livesdk.interactivity.api.i.b(r103, 1);
        if (r113 == null) goto L35;
        j<h32.a> r114 = r113.getDegradeManager();
        if (r114 == null) goto L36;
        h32.a r115 = r114.getValue();
        if (r115 == null) goto L37;
        h32.c<f32.e> r116 = r115.g();
        if (r116 == null) goto L38;
        Disposable r117 = g32.b.a(r116, this.f139880h);
        if (r117 == null) goto L39;
        RxUtilKt.c(r117, this.f139876d);
        return;
    L39:
        return;
    L38:
        return;
    L37:
        return;
    L36:
        return;
    L35:
        return;
    L11:
        r106 = null;
        goto L12
    L5:
        r102 = false;
        goto L6
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // vlc.l
    public final void onMessage(tlc.d r110) {
        ALogger.i("NewHotMsgViewManager", "receive new message");
        Ref.ObjectRef r100 = new Ref.ObjectRef();
        if (r110 != 0) goto L5;
        return;
    L5:
        r100.element = r110;
        tlc.d r111 = r110;
        if ((r111 instanceof k6) == false) goto L63;
        k6 r112 = (k6) r111;
        boolean r101 = true;
        int r102 = 0;
        if (this.f139875c == false) goto L19;
        PlayerProgressServiceContext r103 = this.f139874b;
        if (r103 == null) goto L16;
        m<Boolean> r104 = r103.getAtLatest();
        if (r104 == null) goto L16;
        if (r104.getValue().booleanValue() == true) goto L16;
        boolean r105 = true;
    L17:
        if (r105 == false) goto L19;
    L35:
        if (r101 == true) goto L72;
        List<i> r113 = ((k6) ((tlc.d) r100.element)).E();
        if (r113 != null) goto L39;
        return;
    L39:
        List<i> r106 = r113;
        Iterator<T> r107 = r106.iterator();
    L41:
        if (r107.hasNext() == false) goto L43;
        i r108 = (i) r107.next();
        r108.f58888a = Long.valueOf(((k6) ((tlc.d) r100.element)).getMessageId());
        r108.f58889b = Long.valueOf(((k6) ((tlc.d) r100.element)).G());
        goto L41
    L43:
        Iterator r109 = ((ArrayList) this.f139878f).iterator();
    L45:
        if (r109.hasNext() == false) goto L47;
        MainThreadPostUtils.d((Runnable) r109.next());
        goto L45
    L47:
        ((ArrayList) this.f139878f).clear();
        if (((k6) ((tlc.d) r100.element)).G() != 0) goto L56;
        Iterator<T> r114 = r106.iterator();
    L51:
        if (r114.hasNext() == false) goto L73;
        i r115 = (i) r114.next();
        ALogger.i("NewHotMsgViewManager", "requestShow，assemble");
        f52.b r116 = this.f139873a;
        if (r116 != null) goto L55;
        Intrinsics.throwUninitializedPropertyAccessException(KtvSubElement.CONTAINER);
    L55:
        NewHotMsgPSTopView r117 = new NewHotMsgPSTopView(r115, d());
        r117.f139829n = ((k6) ((tlc.d) r100.element)).getHighlightAreaPriorityConfig();
        Unit r118 = Unit.INSTANCE;
        r116.a(r117);
        goto L51
    L73:
        return;
    L56:
        int r119 = r113.size();
        long r120 = 0;
    L57:
        if (r102 >= r119) goto L74;
        c r121 = new c(this, r113, r102, r100);
        ((ArrayList) this.f139878f).add(r121);
        MainThreadPostUtils.c(r121, r120);
        Long r122 = ((i) ListProtector.get(r113, r102)).f();
        if (r122 == null) goto L61;
        long r123 = r122.longValue() + ((k6) ((tlc.d) r100.element)).G();
    L62:
        r120 = r120 + (r123 * ((long) 1000));
        r102 = r102 + 1;
        goto L57
    L61:
        r123 = 0;
        goto L62
    L74:
        return;
    L72:
        return;
    L16:
        r105 = false;
    L19:
        if (com.bytedance.android.livesdk.interactivity.service.settings.b.f140990a.getValue().booleanValue() == true) goto L21;
    L23:
        boolean r124 = false;
    L24:
        if (r124 == true) goto L35;
        List<i> r125 = r112.E();
        if (r125 != null) goto L28;
    L31:
        boolean r126 = true;
    L32:
        if (r126 == true) goto L35;
        r101 = false;
        goto L35
    L28:
        if (r125.isEmpty() == true) goto L31;
        r126 = false;
        goto L32
    L21:
        if (this.f139879g.f475369a == true) goto L23;
        r124 = true;
        goto L24
    }
}
