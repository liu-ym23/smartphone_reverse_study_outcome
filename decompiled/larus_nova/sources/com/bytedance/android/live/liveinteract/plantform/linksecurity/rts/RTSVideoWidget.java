package com.bytedance.android.live.liveinteract.plantform.linksecurity.rts;

import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.liveinteract.linkbase.api.BaseMultiLinkWidget;
import com.bytedance.android.live.liveinteract.plantform.base.i;
import com.bytedance.android.live.liveinteract.plantform.core.y;
import com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge;
import com.bytedance.android.live.liveinteract.plantform.model.n;
import com.bytedance.android.livesdk.utils.r2;
import com.bytedance.android.livesdkapi.LiveCommonConstants;
import com.bytedance.live.datacontext.DataContext;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import hg6.g;
import io.reactivex.Observable;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kg6.e;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import tf0.o;

/* JADX INFO: loaded from: classes46.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/live/liveinteract/plantform/linksecurity/rts/RTSVideoWidget;", "Lcom/bytedance/android/live/liveinteract/linkbase/api/BaseMultiLinkWidget;", "multilink-business-platform_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class RTSVideoWidget extends BaseMultiLinkWidget {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Lazy f77185a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final CompositeDisposable f77186b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public o f77187c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Set<String> f77188d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final g f77189e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final dn0.c f77190f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final i<ILinkPlayerInfoBridge> f77191g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final com.bytedance.android.live.liveinteract.plantform.linksecurity.rts.a.b f77192h;

    public static final class a<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ RTSVideoWidget f77193a;

        public a(RTSVideoWidget r100) {
            this.f77193a = r100;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r110) {
            sh6.b r100 = (sh6.b) r110;
            ph0.b r101 = (ph0.b) sh6.c.b(r100);
            String r102 = null;
            if (r101 == null) goto L5;
            String r103 = r101.f529232b;
        L7:
            if (r103 != null) goto L9;
        L12:
            boolean r104 = true;
        L13:
            if (r104 == true) goto L140;
            g r105 = this.f77193a.f77189e;
            if (r105 != null) goto L17;
            return;
        L17:
            if (r105.A() != true) goto L142;
            ph0.b r106 = (ph0.b) sh6.c.b(r100);
            int r107 = 2;
            if (r106 != null) goto L21;
        L23:
            boolean r108 = false;
        L24:
            o r109 = this.f77193a.f77187c;
            if (r109 == null) goto L31;
            ph0.b r111 = (ph0.b) sh6.c.b(r100);
            if (r111 == null) goto L29;
            String r112 = r111.f529232b;
        L30:
            Intrinsics.checkNotNull(r112);
            r109.c(r112, r108);
            goto L31
        L29:
            r112 = null;
        L31:
            int r113 = d.f77208a;
            i<ILinkPlayerInfoBridge> r114 = this.f77193a.f77191g;
            ph0.b r115 = (ph0.b) sh6.c.b(r100);
            if (r115 == null) goto L34;
            String r116 = r115.f529231a;
        L35:
            String r117 = String.valueOf(r116);
            ph0.b r118 = (ph0.b) sh6.c.b(r100);
            if (r118 == null) goto L38;
            String r119 = r118.f529232b;
        L39:
            Intrinsics.checkNotNull(r119);
            ph0.b r120 = (ph0.b) sh6.c.b(r100);
            if (r120 == null) goto L42;
            r107 = r120.f529233c;
        L42:
            Intrinsics.checkNotNullParameter(r117, "targetUserId");
            int r121 = -1;
            if (r114 == null) goto L56;
            Iterable r122 = r114.getOnlineUserList();
            if (r122 == null) goto L56;
            Iterator<T> r123 = r122.iterator();
            ILinkPlayerInfoBridge r124 = null;
            int r125 = 0;
        L48:
            if (r123.hasNext() == false) goto L57;
            T r126 = r123.next();
            int r127 = r125 + 1;
            if (r125 >= 0) goto L52;
            CollectionsKt.throwIndexOverflow();
        L52:
            ILinkPlayerInfoBridge r128 = (ILinkPlayerInfoBridge) r126;
            int r129 = d.f77208a;
            if (d.a.a(r117, r119, r128) == false) goto L55;
            r124 = n.a(r128);
            r124.setLinkType(r107);
            r121 = r125;
        L55:
            r125 = r127;
        L57:
            if (r121 < 0) goto L63;
            if (r124 == null) goto L63;
            if (r114 == null) goto L63;
            List<T> r130 = r114.getOnlineUserList();
            if (r130 == 0) goto L63;
            ILinkPlayerInfoBridge r131 = (ILinkPlayerInfoBridge) ListProtector.set(r130, r121, r124);
        L63:
            if (r114 == null) goto L65;
            r114.W4();
        L65:
            ph0.b r132 = (ph0.b) sh6.c.b(r100);
            if (r132 == null) goto L143;
            String r133 = r132.f529232b;
            if (r133 != null) goto L70;
            return;
        L70:
            if ((!StringsKt.isBlank(r133)) != true) goto L145;
            ph0.b r134 = (ph0.b) sh6.c.b(r100);
            if (r134 == null) goto L74;
            String r135 = r134.f529232b;
        L76:
            if (Intrinsics.areEqual(r135, tc0.c.h().f545349f) == false) goto L96;
            if (r108 == false) goto L146;
            ph0.b r136 = (ph0.b) sh6.c.b(r100);
            if (r136 != null) goto L81;
        L89:
            cg6.a r137 = this.f77193a.wq();
            if (r137 == null) goto L151;
            jg6.a r138 = r137.e5();
            if (r138 == null) goto L152;
            lh6.b r139 = r138.a();
            if (r139 == null) goto L153;
            ng6.c.a.a(r139, true);
            return;
        L153:
            return;
        L152:
            return;
        L151:
            return;
        L81:
            if (r136.f529234d != true) goto L89;
            cg6.a r140 = this.f77193a.wq();
            if (r140 == null) goto L147;
            jg6.a r141 = r140.e5();
            if (r141 == null) goto L148;
            lh6.b r142 = r141.a();
            if (r142 == null) goto L149;
            ng6.c.a.a(r142, false);
            return;
        L149:
            return;
        L148:
            return;
        L147:
            return;
        L146:
            return;
        L96:
            ph0.b r143 = (ph0.b) sh6.c.b(r100);
            if (r143 != null) goto L99;
        L100:
            ph0.b r144 = (ph0.b) sh6.c.b(r100);
            if (r144 != null) goto L103;
        L104:
            ph0.b r145 = (ph0.b) sh6.c.b(r100);
            if (r145 != null) goto L107;
        L122:
            Set<String> r146 = this.f77193a.f77188d;
            ph0.b r147 = (ph0.b) sh6.c.b(r100);
            if (r147 == null) goto L125;
            String r148 = r147.f529232b;
        L126:
            Intrinsics.checkNotNull(r148);
            r146.add(r148);
            cg6.a r149 = this.f77193a.wq();
            if (r149 == null) goto L159;
            jg6.a r150 = r149.e5();
            if (r150 == null) goto L160;
            lh6.b r151 = r150.a();
            if (r151 == null) goto L161;
            ph0.b r152 = (ph0.b) sh6.c.b(r100);
            if (r152 == null) goto L135;
            r102 = r152.f529232b;
        L135:
            Intrinsics.checkNotNull(r102);
            r151.f(r102, true, "rts video widget oncreate");
            return;
        L161:
            return;
        L160:
            return;
        L159:
            return;
        L125:
            r148 = null;
            goto L126
        L107:
            if (r145.f529234d != true) goto L122;
        L108:
            Set<String> r153 = this.f77193a.f77188d;
            ph0.b r154 = (ph0.b) sh6.c.b(r100);
            if (r154 == null) goto L111;
            String r155 = r154.f529232b;
        L112:
            Intrinsics.checkNotNull(r155);
            r153.remove(r155);
            cg6.a r156 = this.f77193a.wq();
            if (r156 == null) goto L155;
            jg6.a r157 = r156.e5();
            if (r157 == null) goto L156;
            lh6.b r158 = r157.a();
            if (r158 == null) goto L157;
            ph0.b r159 = (ph0.b) sh6.c.b(r100);
            if (r159 == null) goto L121;
            r102 = r159.f529232b;
        L121:
            Intrinsics.checkNotNull(r102);
            r158.f(r102, false, "rts video widget oncreate by video");
            return;
        L157:
            return;
        L156:
            return;
        L155:
            return;
        L111:
            r155 = null;
            goto L112
        L103:
            if (r144.f529233c == 3) goto L108;
        L99:
            if (r143.f529233c == 1) goto L108;
        L74:
            r135 = null;
            goto L76
        L145:
            return;
        L143:
            return;
        L56:
            r124 = null;
            goto L57
        L38:
            r119 = null;
            goto L39
        L34:
            r116 = null;
            goto L35
        L21:
            if (r106.f529233c != 2) goto L23;
            r108 = true;
            goto L24
        L142:
            return;
        L140:
            return;
        L9:
            if (StringsKt.isBlank(r103) == true) goto L12;
            r104 = false;
            goto L13
        L5:
            r103 = null;
            goto L7
        }
    }

    public static final class b<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ RTSVideoWidget f77194a;

        public b(RTSVideoWidget r100) {
            this.f77194a = r100;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            sh6.b r101 = (sh6.b) r100;
            ph0.c r102 = (ph0.c) sh6.c.b(r101);
            String r103 = null;
            if (r102 == null) goto L5;
            String r104 = r102.f529236b;
        L7:
            if (r104 != null) goto L9;
        L12:
            boolean r105 = true;
        L13:
            if (r105 == true) goto L83;
            g r106 = this.f77194a.f77189e;
            if (r106 != null) goto L17;
            return;
        L17:
            if (r106.A() != true) goto L85;
            ph0.c r107 = (ph0.c) sh6.c.b(r101);
            if (r107 == null) goto L69;
            String r108 = r107.f529236b;
            if (r108 == null) goto L69;
            if ((!StringsKt.isBlank(r108)) != true) goto L69;
            ph0.c r109 = (ph0.c) sh6.c.b(r101);
            if (r109 == null) goto L27;
            String r110 = r109.f529236b;
        L29:
            if (Intrinsics.areEqual(r110, tc0.c.h().f545349f) == false) goto L37;
            ph0.c r111 = (ph0.c) sh6.c.b(r101);
            if (r111 != null) goto L33;
        L34:
            pf6.a r112 = this.f77194a.f77189e.f0();
            if (r112 == null) goto L69;
            r112.c(true, LiveCommonConstants.REASON_RTS_VIDEO_MUTE);
            goto L69
        L33:
            if (r111.f529237c == 0) goto L69;
        L37:
            ph0.c r113 = (ph0.c) sh6.c.b(r101);
            if (r113 == null) goto L40;
            Integer r114 = Integer.valueOf(r113.f529237c);
        L41:
            Intrinsics.checkNotNull(r114);
            if (r114.intValue() <= 0) goto L58;
            ph0.c r115 = (ph0.c) sh6.c.b(r101);
            if (r115 == null) goto L58;
            if (r115.f529238d == true) goto L58;
            cg6.a r116 = this.f77194a.wq();
            if (r116 == null) goto L69;
            jg6.a r117 = r116.e5();
            if (r117 == null) goto L69;
            e r118 = r117.b();
            if (r118 == null) goto L69;
            ph0.c r119 = (ph0.c) sh6.c.b(r101);
            if (r119 == null) goto L56;
            String r120 = r119.f529236b;
        L57:
            Intrinsics.checkNotNull(r120);
            r118.h(r120, true, LiveCommonConstants.REASON_RTS_OTHER_USER_SILENCE_SELF);
            goto L69
        L56:
            r120 = null;
        L58:
            cg6.a r121 = this.f77194a.wq();
            if (r121 == null) goto L69;
            jg6.a r122 = r121.e5();
            if (r122 == null) goto L69;
            e r123 = r122.b();
            if (r123 == null) goto L69;
            ph0.c r124 = (ph0.c) sh6.c.b(r101);
            if (r124 == null) goto L67;
            String r125 = r124.f529236b;
        L68:
            Intrinsics.checkNotNull(r125);
            r123.h(r125, false, LiveCommonConstants.REASON_RTS_OTHER_USER_SILENCE_SELF);
            goto L69
        L67:
            r125 = null;
            goto L68
        L40:
            r114 = null;
            goto L41
        L27:
            r110 = null;
        L69:
            int r126 = d.f77208a;
            i<ILinkPlayerInfoBridge> r127 = this.f77194a.f77191g;
            ph0.c r128 = (ph0.c) sh6.c.b(r101);
            if (r128 == null) goto L73;
            String r129 = r128.f529235a;
            if (r129 == null) goto L73;
        L74:
            ph0.c r130 = (ph0.c) sh6.c.b(r101);
            if (r130 == null) goto L77;
            r103 = r130.f529236b;
        L77:
            Intrinsics.checkNotNull(r103);
            ph0.c r131 = (ph0.c) sh6.c.b(r101);
            if (r131 == null) goto L80;
            int r132 = r131.f529237c;
        L81:
            d.a.b(r127, r129, r103, r132);
            return;
        L80:
            r132 = -1;
        L73:
            r129 = "";
            goto L74
        L85:
            return;
        L83:
            return;
        L9:
            if (StringsKt.isBlank(r104) == true) goto L12;
            r105 = false;
            goto L13
        L5:
            r104 = null;
            goto L7
        }
    }

    public static final class c<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ RTSVideoWidget f77195a;

        public c(RTSVideoWidget r100) {
            this.f77195a = r100;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            sh6.b r101 = (sh6.b) r100;
            ph0.a r102 = (ph0.a) sh6.c.b(r101);
            if (r102 == null) goto L5;
            String r103 = r102.f529230a;
        L7:
            if (Intrinsics.areEqual(r103, tc0.c.h().f545349f) == false) goto L16;
            com.bytedance.android.live.liveinteract.plantform.linksecurity.rts.a.b r104 = this.f77195a.f77192h;
            if (r104 == null) goto L11;
            r104.c();
        L11:
            g r105 = this.f77195a.f77189e;
            if (r105 != null) goto L14;
            return;
        L14:
            if (r105.isEngineOn() != true) goto L43;
            this.f77195a.f77189e.n();
            return;
        L43:
            return;
        L16:
            cg6.a r106 = this.f77195a.wq();
            String r107 = "";
            if (r106 == null) goto L28;
            jg6.a r108 = r106.e5();
            if (r108 == null) goto L28;
            e r109 = r108.b();
            if (r109 == null) goto L28;
            ph0.a r110 = (ph0.a) sh6.c.b(r101);
            if (r110 == null) goto L26;
            String r111 = r110.f529230a;
            if (r111 == null) goto L26;
        L27:
            r109.h(r111, true, LiveCommonConstants.REASON_RTS_KICK_OUT);
        L26:
            r111 = "";
        L28:
            cg6.a r112 = this.f77195a.wq();
            if (r112 == null) goto L45;
            jg6.a r113 = r112.e5();
            if (r113 == null) goto L46;
            lh6.b r114 = r113.a();
            if (r114 == null) goto L47;
            ph0.a r115 = (ph0.a) sh6.c.b(r101);
            if (r115 == null) goto L40;
            String r116 = r115.f529230a;
            if (r116 == null) goto L40;
            r107 = r116;
        L40:
            r114.f(r107, true, "rtsvideo widget kickout event");
            return;
        L47:
            return;
        L46:
            return;
        L45:
            return;
        L5:
            r103 = null;
            goto L7
        }
    }

    public final cg6.a wq() {
        return (cg6.a) getScopeServiceOrNullInMultiLinkRoom(cg6.a.class);
    }

    @Override // com.bytedance.android.live.liveinteract.linkbase.api.BaseMultiLinkWidget
    public final int getScene() {
        return com.bytedance.android.live.liveinteract.linkpanel.util.o.c();
    }

    @Override // com.bytedance.android.live.liveinteract.linkbase.api.BaseMultiLinkWidget, com.bytedance.android.livesdk.chatroom.widget.MiddlewareRoomWidget, com.bytedance.android.live.core.tetris.widgets.LiveWidget, com.bytedance.ies.sdk.widgets.Widget
    public final void onCreate() {
        super.onCreate();
        g r100 = this.f77189e;
        if (r100 == null) goto L5;
        r100.z((com.bytedance.android.live.liveinteract.plantform.linksecurity.rts.a) this.f77185a.getValue());
    L5:
        Pair r101 = com.bytedance.live.datacontext.d.a(RTSVideoWidget$onCreate$pair$1.INSTANCE);
        com.bytedance.live.datacontext.b.a((DataContext) r101.getFirst(), RTSDataContext.class);
        this.f77186b.add((Disposable) r101.getSecond());
        i<ILinkPlayerInfoBridge> r102 = this.f77191g;
        if (r102 == null) goto L8;
        r102.Q4(new com.bytedance.android.live.liveinteract.plantform.linksecurity.rts.b(this));
    L8:
        com.bytedance.android.live.liveinteract.plantform.linksecurity.rts.a r103 = (com.bytedance.android.live.liveinteract.plantform.linksecurity.rts.a) this.f77185a.getValue();
        com.bytedance.android.live.liveinteract.plantform.linksecurity.rts.a.c r104 = (com.bytedance.android.live.liveinteract.plantform.linksecurity.rts.a.c) r101.getFirst();
        r103.getClass();
        Intrinsics.checkNotNullParameter(r104, "listener");
        if (r103.f77204a.contains(r104) == true) goto L11;
        r103.f77204a.add(r104);
    L11:
        RTSDataContext.a r105 = RTSDataContext.Companion;
        RTSDataContext r106 = r105.getContext();
        if (r106 == null) goto L20;
        com.bytedance.live.datacontext.n<ph0.b> r107 = r106.getLinkTypeEvent();
        if (r107 == null) goto L20;
        Observable<sh6.b<ph0.b>> r108 = r107.a();
        if (r108 == null) goto L20;
        Disposable r109 = r108.subscribe(new a(this));
        if (r109 == null) goto L20;
        RxUtilKt.c(r109, this.f77186b);
    L20:
        RTSDataContext r110 = r105.getContext();
        if (r110 == null) goto L29;
        com.bytedance.live.datacontext.n<ph0.c> r111 = r110.getSilenceEvent();
        if (r111 == null) goto L29;
        Observable<sh6.b<ph0.c>> r112 = r111.a();
        if (r112 == null) goto L29;
        Disposable r113 = r112.subscribe(new b(this));
        if (r113 == null) goto L29;
        RxUtilKt.c(r113, this.f77186b);
    L29:
        RTSDataContext r114 = r105.getContext();
        if (r114 == null) goto L39;
        com.bytedance.live.datacontext.n<ph0.a> r115 = r114.getKickOutEvent();
        if (r115 == null) goto L40;
        Observable<sh6.b<ph0.a>> r116 = r115.a();
        if (r116 == null) goto L41;
        Disposable r117 = r116.subscribe(new c(this));
        if (r117 == null) goto L42;
        RxUtilKt.c(r117, this.f77186b);
        return;
    L42:
        return;
    L41:
        return;
    L40:
        return;
    }

    @Override // com.bytedance.android.live.liveinteract.linkbase.api.BaseMultiLinkWidget, com.bytedance.android.live.core.tetris.widgets.LiveWidget, com.bytedance.livesdk.preview.merge.AbsMergeWidget, com.bytedance.ies.sdk.widgets.Widget
    public final void onDestroy() {
        super.onDestroy();
        Iterator<T> r100 = this.f77188d.iterator();
    L4:
        if (r100.hasNext() == false) goto L22;
        String r101 = (String) r100.next();
        String r102 = tc0.c.h().f545349f;
        if (r102 != null) goto L8;
    L11:
        boolean r103 = true;
    L12:
        if (r103 == true) goto L15;
        if ((!Intrinsics.areEqual(r101, tc0.c.h().f545349f)) == false) goto L4;
    L15:
        cg6.a r104 = wq();
        if (r104 == null) goto L4;
        jg6.a r105 = r104.e5();
        if (r105 == null) goto L4;
        lh6.b r106 = r105.a();
        if (r106 == null) goto L4;
        r106.f(r101, false, "rts video widget ondestroy");
        goto L4
    L8:
        if (StringsKt.isBlank(r102) == true) goto L11;
        r103 = false;
        goto L12
    L22:
        this.f77186b.clear();
        ((com.bytedance.android.live.liveinteract.plantform.linksecurity.rts.a) this.f77185a.getValue()).f77204a.clear();
    }

    @Override // com.bytedance.android.live.core.tetris.widgets.LiveWidget, com.bytedance.ies.sdk.widgets.Widget
    public final void onPause() {
        super.onPause();
    }

    @Override // com.bytedance.android.live.core.tetris.widgets.LiveWidget, com.bytedance.ies.sdk.widgets.Widget
    public final void onResume() {
        super.onResume();
    }

    public final void xq(List<? extends ILinkPlayerInfoBridge> r100) {
        if (r100 == null) goto L37;
        Iterator<T> r101 = r100.iterator();
    L5:
        if (r101.hasNext() == false) goto L53;
        ILinkPlayerInfoBridge r102 = (ILinkPlayerInfoBridge) r101.next();
        if (r2.a(r102.getMInteractIdStr()) == false) goto L5;
        if ((!Intrinsics.areEqual(r102.getMInteractIdStr(), tc0.c.h().f545349f)) == false) goto L5;
        String r103 = "";
        if (r102.getLinkType() != 1) goto L13;
    L14:
        cg6.a r104 = wq();
        if (r104 == null) goto L25;
        jg6.a r105 = r104.e5();
        if (r105 == null) goto L25;
        lh6.b r106 = r105.a();
        if (r106 == null) goto L25;
        String r107 = r102.getMInteractIdStr();
        if (r107 != null) goto L23;
        r107 = "";
    L23:
        r106.f(r107, false, "rts video widget onUserListChanged");
    L25:
        if (r102.getSilenceStatus() != 0) goto L5;
        cg6.a r108 = wq();
        if (r108 == null) goto L5;
        jg6.a r109 = r108.e5();
        if (r109 == null) goto L5;
        e r110 = r109.b();
        if (r110 == null) goto L5;
        String r111 = r102.getMInteractIdStr();
        if (r111 == null) goto L36;
        r103 = r111;
    L36:
        r110.h(r103, false, LiveCommonConstants.REASON_USE_ONLINE_LIST_CHANGED_VIDEO);
        goto L5
    L13:
        if (r102.getLinkType() != 3) goto L25;
    L53:
        return;
    }

    public RTSVideoWidget(g r100, dn0.c r101, y r102, com.bytedance.android.live.liveinteract.plantform.linksecurity.rts.a.b r103) {
        this.f77189e = r100;
        this.f77190f = r101;
        this.f77191g = r102;
        this.f77192h = r103;
        this.f77185a = LazyKt.lazy(new RTSVideoWidget$mRTSHandler$2(this));
        this.f77186b = new CompositeDisposable();
        this.f77188d = new LinkedHashSet();
    }
}
