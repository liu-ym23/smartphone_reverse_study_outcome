package com.bytedance.android.live.liveinteract.plantform.datamergev2;

import android.view.SurfaceView;
import android.view.View;
import androidx.lifecycle.LifecycleOwner;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.liveinteract.plantform.datamergev2.handler.o;
import com.bytedance.android.live.liveinteract.plantform.datamergev2.handler.p;
import com.bytedance.android.live.user.IMiddlewareUserService;
import com.bytedance.android.livesdk.chatroom.widget.j1;
import com.bytedance.android.livesdk.link.model.l6;
import com.bytedance.android.livesdkapi.depend.message.IRoomLinkMicSyncData;
import com.bytedance.ies.sdk.widgets.DataCenter;
import io.reactivex.subjects.BehaviorSubject;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
public final class h extends b {
    public final j1 A;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final BehaviorSubject<Map<String, Boolean>> f76655r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final BehaviorSubject<Map<String, Boolean>> f76656s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final BehaviorSubject<Map<String, Long>> f76657t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final BehaviorSubject<Map<String, Boolean>> f76658u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final BehaviorSubject<IRoomLinkMicSyncData> f76659v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public o f76660w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final com.bytedance.android.live.liveinteract.plantform.datamerge.c f76661x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public eg6.b f76662y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final DataCenter f76663z;

    public static final class a {
    }

    static {
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.datamerge.d
    public final void K0(String r100) {
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.datamerge.b
    public final void O1() {
        if (this.f76620a == false) goto L6;
        ALogger.i("LinkUserDataMergeCenterV2", "LinkUserDataMergeCenterV2=" + hashCode() + ", isInitDefaultHandler=" + this.f76620a);
        return;
    L6:
        this.f76620a = true;
        p r100 = new p(this.f76662y, this.f76635p, this.f76663z);
        this.f76633n = r100;
        CopyOnWriteArrayList<com.bytedance.android.live.liveinteract.plantform.datamerge.handler.h> r101 = this.f76632m;
        Intrinsics.checkNotNullParameter(this, "proxy");
        r100.f76414a = this;
        r101.add(r100);
        d r102 = this.f76635p;
        if (r102 != null) goto L9;
    L121:
        this.f76631l.addAllAbsent(this.f76632m);
        CopyOnWriteArrayList<com.bytedance.android.live.liveinteract.plantform.datamerge.handler.h> r103 = this.f76631l;
        com.bytedance.android.live.liveinteract.plantform.datamergev2.handler.a r104 = new com.bytedance.android.live.liveinteract.plantform.datamergev2.handler.a(this.f76632m, this.f76635p, this.f76663z);
        Intrinsics.checkNotNullParameter(this, "proxy");
        r104.f76414a = this;
        r103.add(r104);
        Iterator<com.bytedance.android.live.liveinteract.plantform.datamerge.handler.h> r105 = this.f76631l.iterator();
    L123:
        if (r105.hasNext() == false) goto L127;
        com.bytedance.android.live.liveinteract.plantform.datamerge.handler.h r106 = r105.next();
        r106.attach();
        d r107 = this.f76635p;
        if (r107 == null) goto L123;
        d.a.a(r107, "hjl-test", hashCode(), "initDefaultHandler, handler=" + r106, true, 16);
        goto L123
    L127:
        return;
    L9:
        if (r102.getShowFrom() != 0) goto L121;
        o r108 = this.f76660w;
        if (r108 == null) goto L19;
        eg6.b r109 = this.f76662y;
        eg6.b r110 = r108.f76731l;
        if (r110 == null) goto L15;
        r110.s(r108.f76730k);
    L15:
        r108.f76731l = r109;
        if (r108.f76729j == false) goto L20;
        if (r109 == null) goto L20;
        r109.h0(r108.f76730k);
    L20:
        com.bytedance.android.live.liveinteract.plantform.datamerge.c r111 = this.f76661x;
        String r112 = null;
        if (r111 != null) goto L23;
    L47:
        DataCenter r113 = this.f76663z;
        if (r113 == null) goto L50;
        String r114 = (String) r113.get("data_room_unique_id", "");
    L51:
        l6 r115 = tc0.c.i(r114).O;
        if (r115 == null) goto L114;
        List<com.bytedance.android.livesdk.link.model.bridge.k> r116 = r115.getMLinkUsers();
        if (r116 == null) goto L114;
        IMiddlewareUserService r117 = (IMiddlewareUserService) jc1.k.f(IMiddlewareUserService.class);
        if (r117 == null) goto L60;
        com.bytedance.android.livesdk.user.e r118 = r117.user();
        if (r118 == null) goto L60;
        String r119 = r118.n();
    L61:
        o r120 = this.f76660w;
        if (r120 == null) goto L66;
        List<ch0.h> r121 = r120.f76721b;
        if (r121 == null) goto L66;
        ((CopyOnWriteArrayList) r121).clear();
    L66:
        Iterator<T> r122 = r116.iterator();
    L68:
        if (r122.hasNext() == false) goto L114;
        com.bytedance.android.livesdk.link.model.bridge.k r123 = (com.bytedance.android.livesdk.link.model.bridge.k) r122.next();
        if (r123.getLinkType() != 1) goto L72;
    L74:
        boolean r124 = false;
    L76:
        if (r123.getSilenceStatus() == 0) goto L78;
        boolean r125 = true;
    L79:
        IBaseUser r126 = r123.getUser();
        if (r126 == null) goto L82;
        String r127 = r126.getIdString();
    L84:
        if (Intrinsics.areEqual(r127, r119) == true) goto L86;
    L105:
        String r128 = r123.getLinkMicIdStr();
        if (r128 != null) goto L108;
        String r129 = "";
    L109:
        ch0.h r130 = new ch0.h(r129, r124, r125, 0, 96);
        o r131 = this.f76660w;
        if (r131 == null) goto L68;
        List<ch0.h> r132 = r131.f76721b;
        if (r132 == null) goto L68;
        ((CopyOnWriteArrayList) r132).add(r130);
        goto L68
    L108:
        r129 = r128;
        goto L109
    L86:
        if (r124 == false) goto L88;
        int r133 = 4;
    L89:
        if (r125 == false) goto L91;
        int r134 = 3;
    L92:
        if (r124 == false) goto L94;
        int r210 = 2;
    L95:
        if (r125 == false) goto L97;
        int r211 = 2;
    L98:
        String r135 = r123.getLinkMicIdStr();
        if (r135 != null) goto L101;
        String r136 = "";
    L102:
        ch0.g r137 = new ch0.g(r136, r133, r134, r210, r211);
        o r138 = this.f76660w;
        if (r138 == null) goto L105;
        r138.f76722c = r137;
        goto L105
    L101:
        r136 = r135;
        goto L102
    L97:
        r211 = 1;
        goto L98
    L94:
        r210 = 1;
        goto L95
    L91:
        r134 = 2;
        goto L92
    L88:
        r133 = 2;
        goto L89
    L82:
        r127 = null;
        goto L84
    L78:
        r125 = false;
        goto L79
    L72:
        if (r123.getLinkType() == 3) goto L74;
        r124 = true;
    L60:
        r119 = null;
    L114:
        DataCenter r139 = this.f76663z;
        if (r139 == null) goto L117;
        r112 = (String) r139.get("data_room_unique_id", "");
    L117:
        l6 r140 = tc0.c.i(r112).O;
        if (r140 == null) goto L120;
        i1(r140);
    L120:
        CopyOnWriteArrayList<com.bytedance.android.live.liveinteract.plantform.datamerge.handler.h> r141 = this.f76632m;
        o r142 = this.f76660w;
        Intrinsics.checkNotNull(r142);
        r142.getClass();
        Intrinsics.checkNotNullParameter(this, "proxy");
        r142.f76414a = this;
        r141.add(r142);
        goto L121
    L50:
        r114 = null;
        goto L51
    L23:
        if (r111.c() != true) goto L47;
        List<ch0.h> r143 = this.f76661x.a();
        o r144 = this.f76660w;
        if (r144 == null) goto L29;
        List<ch0.h> r145 = r144.f76721b;
        if (r145 == null) goto L29;
        ((CopyOnWriteArrayList) r145).clear();
    L29:
        o r146 = this.f76660w;
        if (r146 == null) goto L36;
        ch0.g r147 = this.f76661x.d();
        if (r147 == null) goto L34;
        ch0.g r148 = ch0.g.a(r147);
    L35:
        r146.f76722c = r148;
        goto L36
    L34:
        r148 = null;
    L36:
        Iterator<T> r149 = r143.iterator();
    L38:
        if (r149.hasNext() == false) goto L46;
        ch0.h r150 = (ch0.h) r149.next();
        if (r150 == null) goto L38;
        o r151 = this.f76660w;
        if (r151 == null) goto L38;
        List<ch0.h> r152 = r151.f76721b;
        if (r152 == null) goto L38;
        ((CopyOnWriteArrayList) r152).add(ch0.h.a(r150, null, false, false, false, 0, 127));
        goto L38
    L46:
        this.f76661x.b();
        goto L47
    L19:
        this.f76660w = new o(this.f76662y, this.f76635p);
        goto L20
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.datamerge.d
    public final SurfaceView R0() {
        o r100 = this.f76660w;
        String r101 = "";
        Object r102 = null;
        if (r100 == null) goto L19;
        List<ch0.h> r103 = r100.f76721b;
        if (r103 == null) goto L19;
        Iterator<T> r104 = r103.iterator();
    L8:
        if (r104.hasNext() == false) goto L15;
        Object r105 = r104.next();
        String r106 = ((ch0.h) r105).f23733a;
        String r107 = tc0.c.h().f();
        if (r107 != null) goto L13;
        r107 = "";
    L13:
        if (Intrinsics.areEqual(r106, r107) == false) goto L8;
    L16:
        ch0.h r108 = (ch0.h) r105;
        if (r108 == null) goto L19;
        View r109 = r108.f23734b;
    L21:
        if ((r109 instanceof SurfaceView) == true) goto L23;
        r109 = null;
    L23:
        SurfaceView r110 = (SurfaceView) r109;
        if (r110 != null) goto L50;
        j1 r111 = this.A;
        if (r111 == null) goto L40;
        cg6.a r112 = (cg6.a) r111.getScopeServiceOrNullInMultiLinkRoom(cg6.a.class);
        if (r112 == null) goto L40;
        vb6.g r113 = r112.O5();
        if (r113 == null) goto L40;
        yb6.e r114 = r113.j();
        if (r114 == null) goto L40;
        String r115 = tc0.c.h().f();
        if (r115 == null) goto L37;
        r101 = r115;
    L37:
        yb6.j r116 = r114.U(r101);
        if (r116 == null) goto L40;
        Object r117 = r116.f567098a;
    L42:
        if ((r117 instanceof SurfaceView) == false) goto L46;
        r102 = r117;
    L46:
        return (SurfaceView) r102;
    L40:
        r117 = null;
        goto L42
    L50:
        return r110;
    L15:
        r105 = null;
    L19:
        r109 = null;
        goto L21
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.datamergev2.b
    public final void r() {
        super.r();
        this.f76655r.onNext(MapsKt.emptyMap());
        this.f76656s.onNext(MapsKt.emptyMap());
        this.f76657t.onNext(MapsKt.emptyMap());
        this.f76658u.onNext(MapsKt.emptyMap());
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.datamergev2.b, com.bytedance.android.live.liveinteract.plantform.datamerge.d
    public final BehaviorSubject<Map<String, Boolean>> Q0() {
        return this.f76656s;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.datamergev2.b, com.bytedance.android.live.liveinteract.plantform.datamerge.d
    public final BehaviorSubject<Map<String, Boolean>> S0() {
        return this.f76655r;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.datamergev2.b, com.bytedance.android.live.liveinteract.plantform.datamerge.d
    public final BehaviorSubject<Map<String, Boolean>> j1() {
        return this.f76658u;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.datamergev2.b, com.bytedance.android.live.liveinteract.plantform.datamerge.d
    public final BehaviorSubject<Map<String, Long>> m1() {
        return this.f76657t;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.datamergev2.b, com.bytedance.android.live.liveinteract.plantform.datamerge.d
    public final void J0(Map<String, Boolean> r100) {
        Intrinsics.checkNotNullParameter(r100, "rtcTalkingData");
        this.f76656s.onNext(r100);
        this.f76658u.onNext(r100);
        Objects.toString(r100);
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.datamerge.b
    public final void N1(hg6.g r100) {
        this.f76662y = r100;
        o r101 = this.f76660w;
        if (r101 == null) goto L11;
        eg6.b r102 = r101.f76731l;
        if (r102 == null) goto L7;
        r102.s(r101.f76730k);
    L7:
        r101.f76731l = r100;
        if (r101.f76729j == false) goto L11;
        if (r100 == null) goto L11;
        r100.h0(r101.f76730k);
    L11:
        com.bytedance.android.live.liveinteract.plantform.datamerge.handler.b r103 = this.f76633n;
        if (r103 == null) goto L15;
        r103.e(r100);
        return;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.datamergev2.b, com.bytedance.android.live.liveinteract.plantform.datamerge.d
    public final void U0(Map<String, Long> r100) {
        Intrinsics.checkNotNullParameter(r100, "rtcLastTalkingTimeData");
        this.f76657t.onNext(r100);
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.datamergev2.b, com.bytedance.android.live.liveinteract.plantform.datamerge.d
    public final void h1(Map<String, Boolean> r100) {
        Intrinsics.checkNotNullParameter(r100, "seiTalkingData");
        this.f76655r.onNext(r100);
        this.f76658u.onNext(r100);
        Objects.toString(r100);
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.datamerge.d
    public final void i1(l6 r210) {
        Intrinsics.checkNotNullParameter(r210, "resumeAudienceContent");
        List<com.bytedance.android.livesdk.link.model.bridge.k> r100 = r210.getMLinkUsers();
        if (r100 == null) goto L63;
        IMiddlewareUserService r101 = (IMiddlewareUserService) jc1.k.f(IMiddlewareUserService.class);
        if (r101 == null) goto L9;
        com.bytedance.android.livesdk.user.e r102 = r101.user();
        if (r102 == null) goto L9;
        String r103 = r102.n();
    L10:
        o r104 = this.f76660w;
        if (r104 == null) goto L15;
        List<ch0.h> r105 = r104.f76721b;
        if (r105 == null) goto L15;
        ((CopyOnWriteArrayList) r105).clear();
    L15:
        Iterator<T> r106 = r100.iterator();
    L17:
        if (r106.hasNext() == false) goto L71;
        com.bytedance.android.livesdk.link.model.bridge.k r107 = (com.bytedance.android.livesdk.link.model.bridge.k) r106.next();
        if (r107.getLinkType() != 1) goto L21;
    L23:
        boolean r110 = false;
    L25:
        if (r107.getSilenceStatus() == 0) goto L27;
        boolean r111 = true;
    L28:
        IBaseUser r108 = r107.getUser();
        if (r108 == null) goto L31;
        String r109 = r108.getIdString();
    L33:
        if (Intrinsics.areEqual(r109, r103) == true) goto L35;
    L54:
        String r112 = r107.getLinkMicIdStr();
        if (r112 != null) goto L57;
        String r113 = "";
    L58:
        ch0.h r114 = new ch0.h(r113, r110, r111, 0, 96);
        o r115 = this.f76660w;
        if (r115 == null) goto L17;
        List<ch0.h> r116 = r115.f76721b;
        if (r116 == null) goto L17;
        ((CopyOnWriteArrayList) r116).add(r114);
        goto L17
    L57:
        r113 = r112;
        goto L58
    L35:
        if (r110 == false) goto L37;
        int r117 = 4;
    L38:
        if (r111 == false) goto L40;
        int r118 = 3;
    L41:
        if (r110 == false) goto L43;
        int r119 = 2;
    L44:
        if (r111 == false) goto L46;
        int r120 = 2;
    L47:
        String r121 = r107.getLinkMicIdStr();
        if (r121 != null) goto L50;
        String r122 = "";
    L51:
        ch0.g r123 = new ch0.g(r122, r117, r118, r119, r120);
        o r124 = this.f76660w;
        if (r124 == null) goto L54;
        r124.f76722c = r123;
        goto L54
    L50:
        r122 = r121;
        goto L51
    L46:
        r120 = 1;
        goto L47
    L43:
        r119 = 1;
        goto L44
    L40:
        r118 = 2;
        goto L41
    L37:
        r117 = 2;
        goto L38
    L31:
        r109 = null;
        goto L33
    L27:
        r111 = false;
        goto L28
    L21:
        if (r107.getLinkType() == 3) goto L23;
        r110 = true;
        goto L25
    L71:
        return;
    L9:
        r103 = null;
        goto L10
    }

    public h(LifecycleOwner r100, d r101, we0.a r102, eg6.b r103, int r104, DataCenter r105, j1 r106) {
        super(r100, r101, r104);
        this.f76661x = r102;
        this.f76662y = r103;
        this.f76663z = r105;
        this.A = r106;
        this.f76655r = BehaviorSubject.createDefault(MapsKt.emptyMap());
        this.f76656s = BehaviorSubject.createDefault(MapsKt.emptyMap());
        this.f76657t = BehaviorSubject.createDefault(MapsKt.emptyMap());
        this.f76658u = BehaviorSubject.createDefault(MapsKt.emptyMap());
        this.f76659v = BehaviorSubject.create();
    }
}
