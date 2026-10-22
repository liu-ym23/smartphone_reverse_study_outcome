package com.bytedance.android.livesdk.ktvimpl.mv;

import android.text.TextUtils;
import com.baidu.mapapi.http.HttpClient;
import com.bytedance.android.live.core.utils.StateMachine;
import com.bytedance.android.live.core.utils.rxutils.RxUtil;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.user.IMiddlewareUserService;
import com.bytedance.android.livesdk.ktvimpl.base.api.KtvRoomApi;
import com.bytedance.android.livesdk.ktvimpl.ktvroom.viewmodel.KtvRoomLyricsStateMachineConfig;
import com.bytedance.android.livesdk.message.model.KtvMusic;
import com.bytedance.android.livesdk.message.model.MusicPanel;
import com.bytedance.android.livesdk.message.model.dd;
import com.bytedance.android.livesdk.message.model.fd;
import com.bytedance.android.livesdk.message.model.gd;
import com.bytedance.android.livesdk.utils.d5;
import com.bytedance.android.livesdk.utils.r2;
import com.bytedance.android.livesdkapi.depend.message.KtvStreamSingSyncData;
import com.bytedance.android.livesdkapi.depend.message.MessageType;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
public final class KtvMvModel implements vlc.l, com.bytedance.android.livesdk.ktvimpl.base.viewmodel.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f145936a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final CompositeDisposable f145937b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ArrayList<l> f145938c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ArrayList<s> f145939d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f145940e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Function3<? super String, ? super Long, ? super String, Unit> f145941f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Function3<? super String, ? super Long, ? super String, Boolean> f145942g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final ArrayList<y> f145943h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public l f145944i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Lazy f145945j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public Long f145946k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public DataCenter f145947l;

    public static final class a {
    }

    public static final class b<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ KtvMvModel f145948a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ y f145949b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ String f145950c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ Function3 f145951d;

        public b(KtvMvModel r100, y r101, String r102, Function3 r103) {
            this.f145948a = r100;
            this.f145949b = r101;
            this.f145950c = r102;
            this.f145951d = r103;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r110) {
            com.bytedance.android.live.network.response.e r111 = (com.bytedance.android.live.network.response.e) r110;
            com.bytedance.android.live.ktv.common.model.api.b r100 = (com.bytedance.android.live.ktv.common.model.api.b) r111.data;
            fd r101 = r100.a();
            fd r102 = r100.a();
            if (r102 == null) goto L5;
            String r103 = r102.d();
        L6:
            if (r103 == null) goto L30;
            if (r101 == null) goto L30;
            l r112 = new l(this.f145949b, r103, r101.a(), r101.b(), this.f145949b.f146212f, r101.e(), this.f145950c);
            Long r104 = this.f145949b.f146211e;
            if (r104 == null) goto L12;
            long r105 = r104.longValue();
        L14:
            if (r105 <= 0) goto L16;
            r112.f146076m = Long.valueOf(r105);
        L16:
            List<String> r106 = r101.c();
            if (r106 == null) goto L26;
            Iterator<T> r107 = r106.iterator();
        L20:
            if (r107.hasNext() == false) goto L24;
            T r108 = r107.next();
            if ((!TextUtils.isEmpty((String) r108)) == false) goto L20;
        L25:
            String r109 = r108;
        L27:
            r112.f146066c = r109;
            String r113 = this.f145949b.f146209c;
            this.f145948a.g(r112, false);
            Function3 r114 = this.f145951d;
            if (r114 == null) goto L37;
            Unit r115 = (Unit) r114.invoke(r112, 0, null);
            return;
        L37:
            return;
        L24:
            r108 = (T) null;
            goto L25
        L26:
            r109 = null;
            goto L27
        L12:
            r105 = 0;
        L30:
            com.bytedance.android.live.ktv.common.util.g.e("vId/videoInfo is null, " + r111.logId);
            Function3<? super String, ? super Long, ? super String, Unit> r116 = this.f145948a.f145941f;
            if (r116 == null) goto L39;
            Unit r117 = r116.invoke(r103, Long.valueOf(this.f145949b.f146208b), this.f145949b.f146210d);
            return;
        L39:
            return;
        L5:
            r103 = null;
            goto L6
        }
    }

    public static final class c<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ KtvMvModel f145952a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Function3 f145953b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ y f145954c;

        public c(KtvMvModel r100, Function3 r101, y r102) {
            this.f145952a = r100;
            this.f145953b = r101;
            this.f145954c = r102;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            Throwable r101 = (Throwable) r100;
            int r102 = mb0.b.f512758a;
            int r103 = mb0.b.a.a(r101);
            String r104 = mb0.b.a.b(r101);
            Function3 r105 = this.f145953b;
            if (r105 == null) goto L5;
            Unit r106 = (Unit) r105.invoke(null, Integer.valueOf(r103), r104);
        L5:
            Function3<? super String, ? super Long, ? super String, Unit> r107 = this.f145952a.f145941f;
            if (r107 == null) goto L8;
            Unit r108 = r107.invoke(null, Long.valueOf(this.f145954c.f146208b), this.f145954c.f146210d);
        L8:
            com.bytedance.android.live.ktv.common.util.g.e("requestMvInfo error " + r101.getMessage());
            com.bytedance.android.live.ktv.common.util.g.c("requestMvInfo error " + r101.getMessage());
        }
    }

    static {
    }

    public final void e() {
        this.f145938c.clear();
        DataCenter r100 = this.f145947l;
        if (r100 == null) goto L8;
        vlc.d r101 = (vlc.d) r100.get("data_message_manager", null);
        if (r101 == null) goto L9;
        r101.removeMessageListener(this);
        return;
    L9:
        return;
    }

    public final l a(l r100) {
        Iterator<l> r101 = this.f145938c.iterator();
    L4:
        if (r101.hasNext() == false) goto L13;
        l r102 = r101.next();
        l r103 = r102;
        r103.getClass();
        Intrinsics.checkNotNullParameter(r100, "other");
        if (r103.f146069f == r100.f146069f) goto L8;
    L10:
        boolean r104 = false;
    L11:
        if (r104 == false) goto L4;
    L15:
        return r102;
    L8:
        if (Intrinsics.areEqual(r103.f146070g, r100.f146070g) == false) goto L10;
        r104 = true;
        goto L11
    L13:
        r102 = null;
        goto L15
    }

    public final l b(y r100) {
        Iterator<l> r101 = this.f145938c.iterator();
    L4:
        if (r101.hasNext() == false) goto L10;
        l r102 = r101.next();
        if (Intrinsics.areEqual(r100.f146210d, r102.f146070g) == false) goto L4;
        if (r100.f146208b != r102.f146069f) goto L4;
        return r102;
    L10:
        return null;
    }

    public final void d(l r110) {
        HashSet r100 = new HashSet();
        Iterator<s> r101 = this.f145939d.iterator();
    L4:
        if (r101.hasNext() == false) goto L20;
        s r102 = r101.next();
        Function1<l, Boolean> r103 = r102.f146198b;
        y r104 = r102.f146197a;
        if (r104 == null) goto L8;
        if (r110.f146069f == r104.f146208b) goto L13;
    L15:
        boolean r105 = false;
    L16:
        if (r105 == false) goto L4;
        if (r103.invoke(r110).booleanValue() == false) goto L4;
        r100.add(r102);
        goto L4
    L13:
        if (Intrinsics.areEqual(r110.f146070g, r104.f146210d) == false) goto L15;
        r105 = true;
        goto L16
    L8:
        if (r103.invoke(r110).booleanValue() == false) goto L4;
        r100.add(r102);
        goto L4
    L20:
        this.f145939d.removeAll(r100);
    }

    public final void h(DataCenter r100) {
        DataCenter r101 = this.f145947l;
        if (r101 == null) goto L8;
        if (r101 == null) goto L8;
        vlc.d r102 = (vlc.d) r101.get("data_message_manager", null);
        if (r102 == null) goto L8;
        r102.removeMessageListener(this);
    L8:
        this.f145947l = r100;
        if (r100 == null) goto L14;
        vlc.d r103 = (vlc.d) r100.get("data_message_manager", null);
        if (r103 == null) goto L15;
        r103.addMessageListener(MessageType.KTV_MV_VIDEO_MESSAGE.getIntType(), this);
        return;
    L15:
        return;
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.base.viewmodel.b
    public final void handleStateChange(StateMachine.c.b<? extends KtvRoomLyricsStateMachineConfig.d, ? extends KtvRoomLyricsStateMachineConfig.a, ? extends KtvRoomLyricsStateMachineConfig.b> r100) {
        Intrinsics.checkNotNullParameter(r100, "transition");
        Intrinsics.checkNotNullParameter(r100, "transition");
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.base.viewmodel.b
    public final void notifyClear(Function0<Unit> r100) {
        Intrinsics.checkNotNullParameter(r100, "clearListener");
        Intrinsics.checkNotNullParameter(r100, "clearListener");
    }

    @Override // vlc.l
    public final void onMessage(tlc.d r110) {
        String r100 = null;
        Object r101 = null;
        if ((r110 instanceof gd) == true) goto L5;
        r110 = null;
    L5:
        gd r111 = (gd) r110;
        if (r111 == null) goto L30;
        dd r112 = r111.videoContent;
        if (r112 == null) goto L31;
        com.bytedance.android.live.ktv.common.util.g.d(r112.toString());
        Long r102 = r112.c();
        if (r102 == null) goto L32;
        long r103 = r102.longValue();
        String r104 = r112.a();
        fd r113 = r112.d();
        if (r113 == null) goto L33;
        String r105 = r113.d();
        if (r105 != null) goto L16;
        return;
    L16:
        l r106 = new l(r105, r113.a(), r103, r104, r113.b(), null, r113.e(), "message");
        List<String> r114 = r113.c();
        if (r114 == null) goto L25;
        Iterator<T> r115 = r114.iterator();
    L20:
        if (r115.hasNext() == false) goto L24;
        Object r107 = r115.next();
        if ((!TextUtils.isEmpty((String) r107)) == false) goto L20;
        r101 = r107;
    L24:
        r100 = (String) r101;
    L25:
        r106.f146066c = r100;
        Unit r116 = Unit.INSTANCE;
        g(r106, false);
        return;
    L33:
        return;
    L32:
        return;
    L31:
        return;
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.base.viewmodel.b
    public final void onMusicListChange(List<MusicPanel> r110) {
        if (r110 == null) goto L5;
        int r100 = r110.size();
    L7:
        if (r100 <= 1) goto L16;
        if (r110 == null) goto L16;
        MusicPanel r101 = (MusicPanel) ListProtector.get(r110, 1);
        if (r101 == null) goto L16;
        KtvMusic r102 = r101.f153577a;
        if (r102 == null) goto L16;
        if (Intrinsics.areEqual(r102.getOrderUserIdString(), ((IMiddlewareUserService) jc1.k.n(IMiddlewareUserService.class)).user().n()) == false) goto L16;
        c(new y(r102, null), KtvMvModel$onMusicListChange$1$1.INSTANCE);
    L16:
        if (r110 != null) goto L18;
    L65:
        this.f145938c.clear();
        if (((Boolean) this.f145945j.getValue()).booleanValue() == false) goto L79;
        ArrayList<s> r103 = this.f145939d;
        ArrayList r104 = new ArrayList();
        Iterator<s> r105 = r103.iterator();
    L69:
        if (r105.hasNext() == false) goto L77;
        s r106 = r105.next();
        if (r106.f146197a == null) goto L73;
        boolean r107 = true;
    L74:
        if (r107 == false) goto L69;
        r104.add(r106);
        goto L69
    L73:
        r107 = false;
        goto L74
    L77:
        if ((!r104.isEmpty()) == false) goto L107;
        this.f145939d.removeAll(r104);
        return;
    L107:
        return;
    L79:
        this.f145939d.clear();
        return;
    L18:
        if (r110.isEmpty() == true) goto L65;
        ArrayList r108 = new ArrayList();
        Iterator<l> r109 = this.f145938c.iterator();
    L22:
        if (r109.hasNext() == false) goto L37;
        l r111 = r109.next();
        long r112 = r111.f146069f;
        String r113 = r111.f146070g;
        Iterator<T> r114 = r110.iterator();
    L25:
        if (r114.hasNext() == false) goto L34;
        Object r115 = r114.next();
        MusicPanel r116 = (MusicPanel) r115;
        if (r116.f153577a.getMId() == r112) goto L29;
    L31:
        boolean r117 = false;
    L32:
        if (r117 == false) goto L25;
    L35:
        if (r115 != null) goto L22;
        r108.add(r111);
        goto L22
    L29:
        if (Intrinsics.areEqual(r116.f153577a.getOrderUserIdString(), r113) == false) goto L31;
        r117 = true;
        goto L32
    L34:
        r115 = null;
        goto L35
    L37:
        Iterator r118 = r108.iterator();
    L39:
        if (r118.hasNext() == false) goto L41;
        this.f145938c.remove((l) r118.next());
        goto L39
    L41:
        ArrayList<s> r119 = this.f145939d;
        ArrayList r120 = new ArrayList();
        Iterator<s> r121 = r119.iterator();
    L43:
        if (r121.hasNext() == false) goto L63;
        s r122 = r121.next();
        y r123 = r122.f146197a;
        if (r123 == null) goto L60;
        long r124 = r123.f146208b;
        String r125 = r123.f146210d;
        Iterator<T> r126 = r110.iterator();
    L48:
        if (r126.hasNext() == false) goto L57;
        Object r127 = r126.next();
        MusicPanel r128 = (MusicPanel) r127;
        if (r128.f153577a.getMId() == r124) goto L52;
    L54:
        boolean r129 = false;
    L55:
        if (r129 == false) goto L48;
    L58:
        if (r127 != null) goto L60;
        boolean r130 = true;
    L61:
        if (r130 == false) goto L43;
        r120.add(r122);
        goto L43
    L52:
        if (Intrinsics.areEqual(r128.f153577a.getOrderUserIdString(), r125) == false) goto L54;
        r129 = true;
        goto L55
    L57:
        r127 = null;
    L60:
        r130 = false;
        goto L61
    L63:
        this.f145939d.removeAll(r120);
        return;
    L5:
        r100 = 0;
        goto L7
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.base.viewmodel.b
    public final void onSeiResult(com.bytedance.android.livesdk.ktvimpl.base.sei.w r110) {
        Intrinsics.checkNotNullParameter(r110, "result");
        com.bytedance.android.livesdk.ktvimpl.base.sei.a r111 = r110.f143344b;
        l r100 = null;
        if ((r111 instanceof com.bytedance.android.livesdk.ktvimpl.base.sei.k) == true) goto L5;
        r111 = null;
    L5:
        com.bytedance.android.livesdk.ktvimpl.base.sei.k r112 = (com.bytedance.android.livesdk.ktvimpl.base.sei.k) r111;
        if (r112 != null) goto L8;
        return;
    L8:
        if ((!Intrinsics.areEqual(this.f145936a, r112.D())) == false) goto L31;
        if (r112.D() != null) goto L31;
        if (r112.v() == 2) goto L14;
    L20:
        boolean r101 = false;
    L21:
        if (r101 == false) goto L31;
        Function3<? super String, ? super Long, ? super String, Boolean> r102 = this.f145942g;
        if (r102 == null) goto L25;
        Boolean r103 = r102.invoke(null, Long.valueOf(r112.j()), r112.A());
    L27:
        if (Intrinsics.areEqual(r103, Boolean.TRUE) == false) goto L29;
        this.f145936a = null;
    L29:
        com.bytedance.android.live.ktv.common.util.g.c("onSeiResult , vid is null：" + r112.j());
        return;
    L25:
        r103 = null;
        goto L27
    L14:
        if (r112.d() == 3) goto L18;
        if (r112.d() != 0) goto L20;
    L18:
        if (r112.j() <= 0) goto L20;
        r101 = true;
    L31:
        if (r112.D() != null) goto L33;
        return;
    L33:
        if ((!Intrinsics.areEqual(this.f145936a, r112.D())) == false) goto L67;
        com.bytedance.android.live.ktv.common.util.g.d(r112.toString());
        long r104 = r112.j();
        String r105 = r112.A();
        if (r2.a(r105) == false) goto L37;
        String r106 = r105;
    L38:
        if (r106 != null) goto L40;
        return;
    L40:
        String r107 = r112.D();
        this.f145936a = r107;
        Iterator<l> r108 = this.f145938c.iterator();
    L42:
        if (r108.hasNext() == false) goto L51;
        l r109 = r108.next();
        l r113 = r109;
        if (r113.f146069f == r104) goto L46;
    L48:
        boolean r114 = false;
    L49:
        if (r114 == false) goto L42;
        r100 = r109;
        goto L51
    L46:
        if (Intrinsics.areEqual(r106, r113.f146070g) == false) goto L48;
        r114 = true;
    L51:
        l r115 = r100;
        long r116 = (long) ((r112.y() + r112.m()) * 1000.0f);
        if (r115 != null) goto L54;
    L57:
        f(new y(r104, null, r106, Long.valueOf(r116), null, 18), r107, "sei_result", KtvMvModel$onSeiResult$1$1.INSTANCE);
        return;
    L54:
        if ((!Intrinsics.areEqual(r115.f146067d, r107)) == true) goto L57;
        Intrinsics.checkNotNullParameter("sei_result", "<set-?>");
        r115.f146075l = "sei_result";
        g(r115, true);
        return;
    L37:
        r106 = null;
        goto L38
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.base.viewmodel.b
    public final void playPreviewMv(KtvStreamSingSyncData r100) {
        Intrinsics.checkNotNullParameter(r100, "syncData");
        Intrinsics.checkNotNullParameter(r100, "syncData");
    }

    public KtvMvModel(Long r100, DataCenter r101) {
        this.f145946k = r100;
        this.f145947l = r101;
        this.f145937b = new CompositeDisposable();
        this.f145938c = new ArrayList();
        this.f145939d = new ArrayList();
        this.f145940e = (String) vm2.h.f556151i4.getValue(null, vm2.h.f556082a[267(0x10b, float:3.74E-43)]);
        h(this.f145947l);
        this.f145943h = new ArrayList();
        this.f145945j = LazyKt.lazy(KtvMvModel$enableGrayFixSwitch$2.INSTANCE);
    }

    public final void c(y r100, Function3 r101) {
        Intrinsics.checkNotNullParameter(r100, "songParam");
        Intrinsics.checkNotNullParameter(r101, "cb");
        com.bytedance.android.live.ktv.common.util.g.d("getMvInfo songParam: " + r100);
        l r102 = b(r100);
        y r103 = null;
        if (r102 == null) goto L6;
        r101.invoke(r102, 0, null);
        return;
    L6:
        com.bytedance.android.live.ktv.common.util.g.d("requestMvInfoBySong" + r100);
        if (this.f145943h.contains(r100) == false) goto L24;
        com.bytedance.android.live.ktv.common.util.g.d("requestMvInfoBySong:in requesting " + r100);
        if (r101 == null) goto L29;
        Iterator<y> r104 = this.f145943h.iterator();
    L12:
        if (r104.hasNext() == false) goto L16;
        y r105 = r104.next();
        if (Intrinsics.areEqual(r105, r100) == false) goto L12;
        r103 = r105;
    L16:
        y r106 = r103;
        if (r106 != null) goto L19;
        return;
    L19:
        if (r106.f146207a != null) goto L21;
        r106.f146207a = new ArrayList();
    L21:
        ArrayList<Function3<l, Integer, String, Unit>> r107 = r106.f146207a;
        if (r107 == null) goto L31;
        r107.add(r101);
        return;
    L31:
        return;
    L29:
        return;
    L24:
        com.bytedance.android.live.ktv.common.util.g.g("requestAndNotifyAllMvInfoBySong:" + r100.f146208b + HttpClient.ENDFLAG + r100.f146209c);
        this.f145943h.add(r100);
        RxUtilKt.c(((KtvRoomApi) com.bytedance.android.live.network.c.b().e(KtvRoomApi.class)).fetchAtmosphereVideoInfo(this.f145946k, Long.valueOf(r100.f146208b), r100.f146209c, r100.f146212f).compose(RxUtil.rxSchedulerHelper()).subscribe(new d(this, r100, r101), new e(this, r100)), this.f145937b);
    }

    public final void g(l r110, boolean r111) {
        l r100 = a(r110);
        if (r100 != null) goto L5;
    L10:
        Iterator<l> r112 = this.f145938c.iterator();
    L11:
        boolean r101 = true;
        if (r112.hasNext() == false) goto L21;
        l r102 = r112.next();
        l r103 = r102;
        r103.getClass();
        Intrinsics.checkNotNullParameter(r110, "other");
        if (r103.f146069f == r110.f146069f) goto L16;
    L18:
        boolean r104 = false;
    L19:
        if (r104 == false) goto L11;
    L22:
        if (r102 != null) goto L25;
        r101 = false;
    L25:
        if (r101 == false) goto L27;
        com.bytedance.android.live.ktv.common.util.g.c("相同歌曲和演唱者id:" + r110.f146067d + "。old:" + a(r110) + "=====new:" + r110);
    L27:
        com.bytedance.android.live.ktv.common.util.g.c("saveMvInfo:" + r110);
        this.f145938c.add(r110);
        d(r110);
        return;
    L16:
        if (Intrinsics.areEqual(r103.f146070g, r110.f146070g) == false) goto L18;
        r104 = true;
        goto L19
    L21:
        r102 = null;
        goto L22
    L5:
        if (Intrinsics.areEqual(r100.f146067d, r110.f146067d) == false) goto L9;
        if (r111 == false) goto L34;
        d(r110);
        return;
    L34:
        return;
    L9:
        this.f145938c.remove(r100);
        goto L10
    }

    public final void f(y r100, String r101, String r110, Function3<? super l, ? super Integer, ? super String, Unit> r111) {
        com.bytedance.android.live.ktv.common.util.g.d("requestMvInfo" + r100);
        com.bytedance.android.live.ktv.common.util.g.g("requestMvInfo:" + r100 + HttpClient.ENDFLAG + r101 + "----" + r110);
        RxUtilKt.c(((KtvRoomApi) com.bytedance.android.live.network.c.b().e(KtvRoomApi.class)).getAtmosphereVideoInfoByVid(this.f145946k, r101, Long.valueOf(r100.f146208b), Long.valueOf(d5.c(r100.f146210d)), r100.f146210d).compose(RxUtil.rxSchedulerHelper()).subscribe(new b(this, r100, r110, r111), new c(this, r111, r100)), this.f145937b);
    }
}
