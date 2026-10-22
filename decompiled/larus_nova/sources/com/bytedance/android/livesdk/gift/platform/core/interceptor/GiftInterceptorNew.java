package com.bytedance.android.livesdk.gift.platform.core.interceptor;

import android.util.LongSparseArray;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.network.annotation.PbRequest;
import com.bytedance.android.live.profit.privilege.c;
import com.bytedance.android.live.profit.privilege.model.ProfitCheckType;
import com.bytedance.android.live.revenue.core.util.f;
import com.bytedance.android.live.revenue.core.util.j;
import com.bytedance.android.livesdk.gift.model.h1;
import com.bytedance.android.livesdk.gift.model.h2;
import com.bytedance.android.livesdk.gift.model.w1;
import com.bytedance.android.livesdk.gift.platform.core.GiftContext;
import com.bytedance.android.livesdk.gift.platform.core.c0;
import com.bytedance.android.livesdk.gift.platform.core.manager.g;
import com.bytedance.android.livesdk.gift.platform.core.manager.h;
import com.bytedance.android.livesdk.gift.platform.core.scope.service.q0;
import com.bytedance.android.livesdk.gift.platform.core.utils.s;
import com.bytedance.android.livesdk.gift.platform.core.utils.u;
import com.bytedance.android.livesdk.gift.platform.core.utils.z;
import com.bytedance.android.livesdk.message.model.o6;
import com.bytedance.android.livesdk.message.model.o7;
import com.bytedance.android.livesdk.revenue.message.i;
import com.bytedance.android.livesdk.revenue.monitor.EventModule;
import com.bytedance.android.livesdkapi.depend.live.ILiveRoomPlayFragmentConstant;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.service.IPerformanceManager;
import com.bytedance.android.scope.m;
import com.bytedance.android.scope.o;
import com.bytedance.common.utility.Lists;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import defpackage.l0;
import i12.e;
import io.reactivex.disposables.CompositeDisposable;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KProperty;
import org.json.JSONObject;
import tlc.d;
import yz0.k;
import yz0.l;

/* JADX INFO: loaded from: classes9.dex */
public final class GiftInterceptorNew implements o, vlc.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f130709a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Lazy f130710b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f130711c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final LongSparseArray<ArrayList<o7>> f130712d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final a f130713e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final l f130714f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final k f130715g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final l f130716h;

    public static final class a implements h.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ GiftInterceptorNew f130717a;

        public a(GiftInterceptorNew r100) {
            this.f130717a = r100;
        }

        @Override // com.bytedance.android.livesdk.gift.platform.core.manager.h.b
        public final void a(long r100) {
            GiftInterceptorNew r101 = this.f130717a;
            if (r101.f130711c == true) goto L5;
            return;
        L5:
            ArrayList<o7> r102 = r101.f130712d.get(r100);
            if (r102 == null) goto L8;
            r102.clear();
        L8:
            jy0.b.b(this.f130717a.f130709a, "can't find giftId = " + r100, null);
        }

        @Override // com.bytedance.android.livesdk.gift.platform.core.manager.h.b
        public final void b(h1 r100) {
            if (r100 != null) goto L4;
            return;
        L4:
            GiftInterceptorNew r101 = this.f130717a;
            if (r101.f130711c == true) goto L7;
            return;
        L7:
            long r102 = r100.getId();
            ArrayList<o7> r103 = r101.f130712d.get(r102);
            if (r103 != null) goto L11;
            r103 = CollectionsKt.emptyList();
        L11:
            if (Lists.isEmpty(r103) == false) goto L13;
            return;
        L13:
            Iterator r104 = CollectionsKt.filterNotNull(r103).iterator();
        L15:
            if (r104.hasNext() == false) goto L20;
            o7 r105 = (o7) r104.next();
            if (com.bytedance.android.livesdk.gift.platform.core.h.i() == true) goto L18;
            this.f130717a.f130714f.insert(r105, true);
            goto L15
        L18:
            this.f130717a.f130714f.insert(r105, false);
            goto L15
        L20:
            GiftInterceptorNew r106 = this.f130717a;
            long r107 = r100.getId();
            ArrayList<o7> r108 = r106.f130712d.get(r107);
            if (r108 == null) goto L30;
            r108.clear();
            return;
        }
    }

    @Override // com.bytedance.android.scope.o
    public final void onStart() {
        this.f130711c = true;
        if (com.bytedance.android.livesdk.gift.platform.core.h.i() == true) goto L6;
        this.f130714f.h(this);
        return;
    }

    @Override // com.bytedance.android.scope.o
    public final void onStop() {
        this.f130712d.clear();
        this.f130711c = false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // vlc.b
    public final boolean onMessage(d r310) {
        d r100 = r310;
        Intrinsics.checkNotNullParameter(r100, "msg");
        String r101 = ((l01.d) f.a(l01.d.class)).b().getIdString();
        if ((r100 instanceof o6) == false) goto L17;
        o6 r102 = (o6) r100;
        if (r102.getGiftMessage() == null) goto L10;
        o7 r103 = r102.getGiftMessage();
        Intrinsics.checkNotNull(r103);
        r103.setDisplayForSelf(false);
        o7 r104 = r102.getGiftMessage();
        if (r104 == null) goto L10;
        r104.setGroupCount(1);
    L10:
        if ((r102.getGiftMessage() instanceof d) == false) goto L17;
        r100 = r102.getGiftMessage();
        if (r100 != null) goto L17;
        throw new NullPointerException("null cannot be cast to non-null type com.ss.ugc.live.sdk.message.data.IMessage");
    L17:
        if (r101 != null) goto L19;
    L22:
        boolean r105 = true;
    L24:
        if (r105 == true) goto L74;
        if ((r100 instanceof o7) == false) goto L74;
        o7 r106 = (o7) r100;
        if (r106.getDisplayForSelf() != true) goto L37;
        IBaseUser r110 = r106.getFromUser();
        if (r110 == null) goto L32;
        String r111 = r110.getIdString();
    L34:
        if (Intrinsics.areEqual(r101, r111) == false) goto L37;
        r106.setLocal(true);
        goto L37
    L32:
        r111 = null;
    L37:
        if (r106.isLocal() == true) goto L56;
        IBaseUser r112 = r106.getFromUser();
        if (r112 == null) goto L41;
        String r113 = r112.getIdString();
    L43:
        if (Intrinsics.areEqual(r101, r113) == false) goto L56;
        if (r106.getDisplayForSelf() == true) goto L56;
        if (r106.getRepeatEnd() == 1) goto L56;
        LinkedHashMap r107 = new LinkedHashMap();
        h2 r108 = u.f(r106);
        if (r108 == null) goto L51;
        r107.put(ILiveRoomPlayFragmentConstant.ENTER_LIVE_GITF_ID, Long.valueOf(r108.getId()));
    L51:
        if (r108 == null) goto L53;
        r107.put("asset_id", Long.valueOf(r108.getPrimaryEffectId()));
    L53:
        boolean r109 = com.bytedance.android.live.revenue.core.util.h.f91037a;
        ((c) com.bytedance.android.live.revenue.core.util.h.d(c.class)).B1(ProfitCheckType.GIFT_EFFECT_SELF_IM, r107, null);
        return true;
    L41:
        r113 = null;
    L56:
        if (r106.isLocal() == false) goto L74;
        IBaseUser r114 = r106.getFromUser();
        if (r114 == null) goto L60;
        String r115 = r114.getIdString();
    L62:
        if (Intrinsics.areEqual(r101, r115) == false) goto L74;
        KProperty[] r116 = s.f132083a;
        e r117 = i12.o.b();
        if (r117 == null) goto L66;
        Object r118 = m.f163449e.d(r117, q0.class);
    L67:
        q0 r119 = (q0) r118;
        if (r119 == null) goto L74;
        String r120 = r106.getLogId();
        if (r120 != null) goto L72;
        r120 = "";
    L72:
        r119.a(r120, 2, System.currentTimeMillis());
        goto L74
    L66:
        r118 = null;
        goto L67
    L60:
        r115 = null;
    L74:
        if ((r100 instanceof o7) == false) goto L208;
        o7 r121 = (o7) r100;
        if (r121.isLocal() == false) goto L78;
    L93:
        h1 r122 = r121.getGift();
        if (r122 != null) goto L96;
    L158:
        String r123 = "";
    L159:
        r121.setTimeStampMap(0, com.bytedance.live.kmp.util.e.b());
        if (r121.getFromUser() != null) goto L163;
        jy0.b.b(this.f130709a, "giftMessage#fromUser is null! messageId = " + r121.getMessageId(), null);
        return true;
    L163:
        h2 r124 = u.f(r121);
        if (r121.getClientGiftSource() == 0) goto L166;
    L173:
        if (r124 != null) goto L175;
        jy0.b.d(this.f130709a, "收到 未找到礼物的GiftMessage: giftId = " + r121.getGiftId());
        long r125 = r121.getGiftId();
        c0 r126 = c0.f130474a;
        String r127 = z.b("ttlive_gift_id_not_found");
        JSONObject r210 = new JSONObject();
        JSONObject r128 = new JSONObject();
        JSONObject r129 = new JSONObject();
        Intrinsics.checkNotNullParameter(r129, "extra");
        Intrinsics.checkNotNullParameter(r128, "metric");
        EventModule r130 = EventModule.LIVE_GIFT;
        Intrinsics.checkNotNullParameter(r130, "eventModule");
        String r211 = r130.getValue();
        r128.put("status", String.valueOf(1));
        Intrinsics.checkNotNullParameter(r129, "map");
        Long r131 = Long.valueOf(r125);
        Intrinsics.checkNotNullParameter(ILiveRoomPlayFragmentConstant.ENTER_LIVE_GITF_ID, "key");
        Intrinsics.checkNotNullParameter(r131, "value");
        r129.put(ILiveRoomPlayFragmentConstant.ENTER_LIVE_GITF_ID, r131);
        k r132 = (k) f.d(j.C0.a(), k.class);
        if (r132 == null) goto L181;
        IRoom r133 = r132.getRoom();
    L183:
        if ((r133 instanceof Room) == true) goto L185;
        r133 = null;
    L185:
        Room r134 = (Room) r133;
        if (r134 == null) goto L191;
        Integer r135 = Integer.valueOf(r134.orientation);
        Intrinsics.checkNotNullParameter(IPerformanceManager.Params.room_type, "key");
        Intrinsics.checkNotNullParameter(r135, "value");
        r129.put(IPerformanceManager.Params.room_type, r135);
        Long r136 = Long.valueOf(r134.f162599id);
        Intrinsics.checkNotNullParameter("room_id", "key");
        Intrinsics.checkNotNullParameter(r136, "value");
        r129.put("room_id", r136);
        String r137 = r134.getAnchorId();
        if (r137 != null) goto L190;
        r137 = r123;
    L190:
        Intrinsics.checkNotNullParameter("anchor_id", "key");
        Intrinsics.checkNotNullParameter(r137, "value");
        r129.put("anchor_id", r137);
    L191:
        GiftContext r138 = com.bytedance.android.livesdk.gift.util.b.b();
        if (r138 == null) goto L194;
        String r139 = r138.getGiftListResultLogId().getValue();
        Intrinsics.checkNotNullParameter("log_id", "key");
        Intrinsics.checkNotNullParameter(r139, "value");
        r129.put("log_id", r139);
    L194:
        cy0.e.f465759a.getClass();
        cy0.j r140 = cy0.e.a.f465760a;
        m.f163449e.getClass();
        Object r141 = m.b(r140).b(n97.a.class);
        Intrinsics.checkNotNull(r141);
        ((n97.a) ((com.bytedance.live.kmp.core.c) r141)).g(r127, r211, "bussiness_api_call", r210, r128, r129);
        if (((Boolean) com.bytedance.android.livesdk.gift.platform.core.h.f130659k.getValue(null, com.bytedance.android.livesdk.gift.platform.core.h.f130639a[9])).booleanValue() == false) goto L206;
        ArrayList<o7> r142 = this.f130712d.get(r121.getGiftId());
        if (r142 != null) goto L199;
        r142 = new ArrayList();
    L199:
        r142.add(r121);
        this.f130712d.put(r121.getGiftId(), r142);
        h r143 = (h) this.f130710b.getValue();
        long r144 = r121.getGiftId();
        long r145 = this.f130715g.getRoom().getRoomId();
        g r146 = new g(r144, r145, this.f130713e);
        List<g> r147 = r143.f130801b.get(Long.valueOf(r145));
        if (r147 != null) goto L203;
        r147 = new ArrayList();
        r143.f130801b.put(Long.valueOf(r145), r147);
        r143.f130800a.put(Long.valueOf(r145), 0);
    L203:
        if (r147.contains(r146) == true) goto L205;
        r147.add(r146);
    L205:
        r143.a();
    L206:
        return true;
    L181:
        r133 = null;
        goto L183
    L175:
        if (l0.d(r124) == false) goto L177;
        jy0.b.d(this.f130709a, "收到 IGiftMessage: giftId = " + r121.getGiftId());
    L177:
        return false;
    L166:
        if (((Boolean) com.bytedance.android.livesdk.gift.platform.core.g.f130530j.getValue(null, com.bytedance.android.livesdk.gift.platform.core.g.f130521a[7])).booleanValue() == false) goto L173;
        if (r124 == null) goto L173;
        if (l0.d(r124) == false) goto L218;
        jy0.b.d(this.f130709a, "收到 IGiftMessage: giftId = " + r121.getGiftId());
        return false;
    L218:
        return false;
    L96:
        if (r121.getRepeatEnd() != 1) goto L98;
    L100:
        boolean r148 = false;
    L101:
        if (r148 == true) goto L104;
        r122 = null;
    L104:
        if (r122 == null) goto L158;
        e r149 = i12.o.b();
        if (r149 == null) goto L108;
        Object r150 = m.f163449e.d(r149, com.bytedance.android.livesdk.gift.platform.core.preview.c.class);
    L109:
        com.bytedance.android.livesdk.gift.platform.core.preview.c r151 = (com.bytedance.android.livesdk.gift.platform.core.preview.c) r150;
        if (r151 == null) goto L158;
        IRoom r152 = this.f130715g.getRoom();
        long r153 = r121.getMessageId();
        Intrinsics.checkNotNullParameter(r122, PbRequest.SwitchType.GIFT);
        Intrinsics.checkNotNullParameter(r152, "room");
        if (r151.f130985d == false) goto L158;
        if (r151.f130982a == false) goto L158;
        if (r151.f130984c == 0) goto L158;
        Iterator<T> r154 = r151.f130988g.N3().f130900c.iterator();
    L119:
        if (r154.hasNext() == false) goto L127;
        Object r155 = r154.next();
        if (((w1) r155).getPageType() != 15) goto L123;
        boolean r156 = true;
    L124:
        if (r156 == false) goto L119;
    L128:
        w1 r157 = (w1) r155;
        if (r157 == null) goto L131;
        List<h1> r158 = r157.getGifts();
    L132:
        if (r158 == null) goto L144;
        Iterator<T> r159 = r158.iterator();
    L135:
        if (r159.hasNext() == false) goto L142;
        Object r160 = r159.next();
        if (((h1) r160).getId() != r122.getId()) goto L139;
        boolean r161 = true;
    L140:
        if (r161 == false) goto L135;
    L143:
        h1 r162 = (h1) r160;
    L145:
        if (r162 == null) goto L147;
        boolean r163 = true;
    L148:
        if (r163 == false) goto L158;
        com.bytedance.tools.kcp.spongepreference.runtime.a r164 = ay1.b.f16710r0;
        KProperty<?>[] r165 = ay1.b.f16675a;
        r123 = "";
        if (((Number) r164.getValue(null, r165[83])).intValue() < r151.f130983b) goto L152;
        r151.f130985d = false;
        goto L159
    L152:
        r151.f130984c--;
        r164.setValue(null, r165[83], Integer.valueOf(((Number) r164.getValue(null, r165[83])).intValue() + 1));
        i r166 = r151.f130987f.getMessageManager();
        if (r166 == null) goto L159;
        com.bytedance.android.livesdk.gift.platform.core.preview.a.f130971a.getClass();
        Intrinsics.checkNotNullParameter(r152, "room");
        Intrinsics.checkNotNullParameter(r122, PbRequest.SwitchType.GIFT);
        LinkedHashMap r167 = new LinkedHashMap();
        String r168 = r152.getAnchorId();
        if (r168 != null) goto L157;
        r168 = r123;
    L157:
        r167.put("anchor_id", r168);
        r167.put("room_id", String.valueOf(r152.getRoomId()));
        r167.put(MonitorConstants.EXTRA_DOWNLOAD_PAGE, "live");
        r167.put(ILiveRoomPlayFragmentConstant.ENTER_LIVE_GITF_ID, String.valueOf(r122.getId()));
        com.bytedance.android.livesdk.gift.platform.core.preview.a.c("livesdk_interactive_gift_message_show", r167);
        r151.f130986e.a(r166, r152.getRoomId(), (r153 + System.currentTimeMillis()) + ((long) new SecureRandom().nextInt()), r122.getName(), r122.getId(), com.bytedance.android.livesdk.gift.platform.business.a.d().d(), com.bytedance.android.livesdk.gift.platform.business.a.d().e());
        goto L159
    L147:
        r163 = false;
        goto L148
    L139:
        r161 = false;
        goto L140
    L142:
        r160 = null;
        goto L143
    L144:
        r162 = null;
        goto L145
    L131:
        r158 = null;
        goto L132
    L123:
        r156 = false;
        goto L124
    L127:
        r155 = null;
        goto L128
    L108:
        r150 = null;
        goto L109
    L98:
        if (this.f130715g.isAnchor() == false) goto L100;
        r148 = true;
        goto L101
    L78:
        if (this.f130715g.isAnchor() == false) goto L93;
        if (r121.getRepeatEnd() == 1) goto L93;
        LinkedHashMap r169 = new LinkedHashMap();
        h2 r170 = u.f(r121);
        if (r170 == null) goto L85;
        r169.put(ILiveRoomPlayFragmentConstant.ENTER_LIVE_GITF_ID, Long.valueOf(r170.getId()));
    L85:
        if (r170 == null) goto L87;
        r169.put("asset_id", Long.valueOf(r170.getPrimaryEffectId()));
    L87:
        IBaseUser r171 = r121.getFromUser();
        if (r171 == null) goto L92;
        String r172 = r171.getIdString();
        if (r172 == null) goto L92;
        r169.put("from_user_id", r172);
    L92:
        boolean r173 = com.bytedance.android.live.revenue.core.util.h.f91037a;
        ((c) com.bytedance.android.live.revenue.core.util.h.d(c.class)).B1(ProfitCheckType.ANCHOR_GIFT_IM, r169, null);
        goto L93
    L208:
        return false;
    L19:
        if (r101.length() == 0) goto L22;
        r105 = false;
        goto L24
    }

    public GiftInterceptorNew(l r100, k r101, l r102) {
        Intrinsics.checkNotNullParameter(r100, "messageService");
        Intrinsics.checkNotNullParameter(r101, "roomDataService");
        Intrinsics.checkNotNullParameter(r102, "roomMessageService");
        this.f130714f = r100;
        this.f130715g = r101;
        this.f130716h = r102;
        this.f130709a = "GiftInterceptorNew";
        this.f130710b = LazyKt.lazy(new GiftInterceptorNew$giftFinder$2(this));
        new CompositeDisposable();
        this.f130712d = new LongSparseArray();
        this.f130713e = new a(this);
    }
}
