package com.bytedance.android.livesdk.gift.platform.core.manager;

import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.livesdk.gift.model.h1;
import com.bytedance.android.livesdk.gift.model.w1;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.repo.GiftListRepo;
import com.bytedance.android.livesdk.gift.platform.core.d0;
import com.bytedance.android.livesdk.gift.platform.core.utils.z;
import com.bytedance.android.livesdk.revenue.monitor.EventModule;
import com.bytedance.android.livesdkapi.depend.live.ILiveRoomPlayFragmentConstant;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.service.IPerformanceManager;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes9.dex */
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ConcurrentHashMap<Long, Integer> f130800a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ConcurrentHashMap<Long, List<g>> f130801b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f130802c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f130803d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final a f130804e;

    public class a extends ca0.w {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ h f130805a;

        @Override // ca0.w
        public final void a() {
            this.f130805a.f130802c = false;
        }

        public a(h r100) {
            this.f130805a = r100;
        }

        @Override // ca0.w
        public final void b(List<? extends w1> r100) {
            h r101 = this.f130805a;
            r101.f130802c = false;
            r101.a();
        }
    }

    public interface b {
        void a(long r100);

        void b(h1 r100);
    }

    public final void a() {
        if (this.f130802c == false) goto L5;
        return;
    L5:
        Iterator<Map.Entry<Long, Integer>> r100 = this.f130800a.entrySet().iterator();
    L6:
        Integer r101 = null;
        if (r100.hasNext() == false) goto L21;
        Map.Entry<Long, Integer> r102 = r100.next();
        if (r102.getValue().intValue() < ((Number) com.bytedance.android.livesdk.gift.platform.core.h.f130645d.getValue(null, com.bytedance.android.livesdk.gift.platform.core.h.f130639a[2])).intValue()) goto L19;
        Iterator<g> r103 = b(r102.getKey().longValue()).iterator();
    L12:
        if (r103.hasNext() == false) goto L18;
        g r104 = r103.next();
        h1 r105 = GiftManagerKt.j(r104.f130797a, r101);
        if (r105 != null) goto L16;
        r104.f130799c.a(r104.f130797a);
        boolean r106 = d0.f130477a;
        boolean r107 = this.f130803d;
        long r108 = r104.f130797a;
        long r109 = r104.f130798b;
        String r110 = z.a("ttlive_gift_find_more_error");
        JSONObject r111 = new JSONObject();
        JSONObject r112 = new JSONObject();
        JSONObject r113 = new JSONObject();
        Intrinsics.checkNotNullParameter(r113, "extra");
        Intrinsics.checkNotNullParameter(r112, "metric");
        EventModule r114 = EventModule.LIVE_GIFT;
        Intrinsics.checkNotNullParameter(r114, "eventModule");
        String r115 = r114.getValue();
        Intrinsics.checkNotNullParameter(r111, "map");
        Boolean r116 = Boolean.valueOf(r107);
        Intrinsics.checkNotNullParameter(IPerformanceManager.Params.is_anchor, "key");
        Intrinsics.checkNotNullParameter(r116, "value");
        r111.put(IPerformanceManager.Params.is_anchor, r116);
        Intrinsics.checkNotNullParameter(r112, "map");
        Long r117 = Long.valueOf(r108);
        Intrinsics.checkNotNullParameter(ILiveRoomPlayFragmentConstant.ENTER_LIVE_GITF_ID, "key");
        Intrinsics.checkNotNullParameter(r117, "value");
        r112.put(ILiveRoomPlayFragmentConstant.ENTER_LIVE_GITF_ID, r117);
        Long r118 = Long.valueOf(r109);
        Intrinsics.checkNotNullParameter("room_id", "key");
        Intrinsics.checkNotNullParameter(r118, "value");
        r112.put("room_id", r118);
        cy0.e.f465759a.getClass();
        cy0.j r119 = cy0.e.a.f465760a;
        com.bytedance.android.scope.m.f163449e.getClass();
        Object r120 = com.bytedance.android.scope.m.b(r119).b(n97.a.class);
        Intrinsics.checkNotNull(r120);
        ((n97.a) ((com.bytedance.live.kmp.core.c) r120)).g(r110, r115, "bussiness_api_call", r111, r112, r113);
    L17:
        r100 = r100;
        r103 = r103;
        r101 = null;
        goto L12
    L16:
        r104.f130799c.b(r105);
        goto L17
    L18:
        Iterator<Map.Entry<Long, Integer>> r121 = r100;
        this.f130801b.remove(r102.getKey());
        this.f130800a.remove(r102.getKey());
    L20:
        r100 = r121;
        goto L6
    L19:
        r121 = r100;
        goto L20
    L21:
        Iterator<Map.Entry<Long, List<g>>> r122 = this.f130801b.entrySet().iterator();
    L23:
        if (r122.hasNext() == false) goto L30;
        Iterator<g> r123 = r122.next().getValue().iterator();
    L26:
        if (r123.hasNext() == false) goto L23;
        g r124 = r123.next();
        h1 r125 = GiftManagerKt.j(r124.f130797a, null);
        if (r125 == null) goto L26;
        r124.f130799c.b(r125);
        r123.remove();
        goto L26
    L30:
        Iterator<Map.Entry<Long, Integer>> r126 = this.f130800a.entrySet().iterator();
    L32:
        if (r126.hasNext() == false) goto L89;
        Map.Entry<Long, Integer> r127 = r126.next();
        int r128 = r127.getValue().intValue();
        if (r128 >= ((Number) com.bytedance.android.livesdk.gift.platform.core.h.f130645d.getValue(null, com.bytedance.android.livesdk.gift.platform.core.h.f130639a[2])).intValue()) goto L32;
        long r129 = r127.getKey().longValue();
        r127.setValue(Integer.valueOf(r128 + 1));
        com.bytedance.android.live.revenue.core.util.j.a r130 = com.bytedance.android.live.revenue.core.util.j.C0;
        yz0.k r131 = (yz0.k) com.bytedance.android.live.revenue.core.util.f.d(r130.a(), yz0.k.class);
        if (r131 == null) goto L32;
        IRoom r132 = r131.getRoom();
        String r133 = "";
        if (r132 != null) goto L40;
    L42:
        String r134 = "";
    L43:
        long r135 = 0;
        if (b(r129) != null) goto L46;
    L48:
        long r136 = 0;
    L49:
        a r137 = this.f130804e;
        boolean r138 = this.f130803d;
        h1 r139 = GiftManagerKt.f130737a;
        if (com.bytedance.android.livesdk.gift.platform.core.utils.u.r() == true) goto L68;
        GiftManagerKt.f130762z.getClass();
        yz0.k r140 = (yz0.k) com.bytedance.android.live.revenue.core.util.f.d(r130.a(), yz0.k.class);
        if (r140 == null) goto L54;
        IRoom r141 = r140.getRoom();
    L55:
        if (r141 != null) goto L57;
    L59:
        String r142 = r133;
        if (r141 == null) goto L63;
        r135 = r141.getId();
    L63:
        if (r135 != r129) goto L66;
        if (r141 == null) goto L66;
        int r143 = (int) r141.getRoomLayout();
    L67:
        GiftListRepo.h(r137, r129, 4, r138, r142, r136, r143, null);
    L69:
        this.f130802c = true;
        return;
    L66:
        r143 = 0;
        goto L67
    L57:
        if (r141.getOwner() == null) goto L59;
        IBaseUser r144 = r141.getOwner();
        Intrinsics.checkNotNull(r144);
        r133 = com.bytedance.android.live.base.model.user.o.a(r144);
        goto L59
    L54:
        r141 = null;
        goto L55
    L68:
        GiftManagerKt.f130762z.getClass();
        GiftManagerKt.K(r137, r129, r129, 1, 4, r138, r134, r134, null, r136);
        goto L69
    L46:
        if (b(r129).isEmpty() == true) goto L48;
        r136 = ((g) ListProtector.get(b(r129), 0)).f130797a;
        goto L49
    L40:
        if (r132.getOwner() == null) goto L42;
        r134 = r132.getOwner().getCastSecUid();
        goto L43
    }

    public h(boolean r100) {
        this.f130800a = new ConcurrentHashMap();
        this.f130801b = new ConcurrentHashMap();
        this.f130804e = new a(this);
        this.f130803d = r100;
    }

    public final List<g> b(long r100) {
        return this.f130801b.get(Long.valueOf(r100));
    }
}
