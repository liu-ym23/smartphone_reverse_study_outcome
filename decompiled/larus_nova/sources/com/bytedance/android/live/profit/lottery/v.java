package com.bytedance.android.live.profit.lottery;

import com.bytedance.android.live.GsonHelper;
import com.bytedance.android.live.base.exception.ApiException;
import com.bytedance.android.live.base.model.Extra;
import com.bytedance.android.live.core.utils.rxutils.RxCompatKt;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.revenue.platform.network.api.INetworkService;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.google.gson.JsonObject;
import com.ss.ttvideoengine.selector.strategy.GearStrategyConsts;
import io.reactivex.Single;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.TypesJVMKt;

/* JADX INFO: loaded from: classes47.dex */
public final class v {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final c f88217a = null;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final JsonObject f88218a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final e f88219b;

        public final boolean equals(Object r100) {
            if (this != r100) goto L4;
            return true;
        L4:
            if ((r100 instanceof a) == false) goto L10;
            a r101 = (a) r100;
            if (Intrinsics.areEqual(this.f88218a, r101.f88218a) == true) goto L8;
            return false;
        L8:
            if (Intrinsics.areEqual(this.f88219b, r101.f88219b) == true) goto L16;
            return false;
        L16:
            return true;
        L10:
            return false;
        }

        public final int hashCode() {
            JsonObject r100 = this.f88218a;
            int r101 = 0;
            if (r100 == null) goto L5;
            int r102 = r100.hashCode();
        L6:
            int r103 = r102 * 31;
            e r104 = this.f88219b;
            if (r104 == null) goto L10;
            r101 = r104.hashCode();
        L10:
            return r103 + r101;
        L5:
            r102 = 0;
            goto L6
        }

        public final String toString() {
            return "LotteryResult(rawResponse=" + this.f88218a + ", response=" + this.f88219b + ")";
        }

        public a(JsonObject r100, e r101) {
            Intrinsics.checkNotNullParameter(r100, "rawResponse");
            Intrinsics.checkNotNullParameter(r101, "response");
            this.f88218a = r100;
            this.f88219b = r101;
        }
    }

    public static abstract class b {

        public static final class a extends b {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final t f88220a;

            public final boolean equals(Object r100) {
                if (this != r100) goto L4;
                return true;
            L4:
                if ((r100 instanceof a) == true) goto L6;
                return false;
            L6:
                if (Intrinsics.areEqual(this.f88220a, ((a) r100).f88220a) == true) goto L13;
                return false;
            L13:
                return true;
            }

            public final int hashCode() {
                t r100 = this.f88220a;
                if (r100 != null) goto L7;
                return 0;
            L7:
                return r100.hashCode();
            }

            public final String toString() {
                return "Approve(info=" + this.f88220a + ")";
            }

            public a(t r100) {
                Intrinsics.checkNotNullParameter(r100, "info");
                this.f88220a = r100;
            }
        }

        /* JADX INFO: renamed from: com.bytedance.android.live.profit.lottery.v$b$b, reason: collision with other inner class name */
        public static final class C1348b extends b {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final C1348b f88221a = null;

            static {
                f88221a = new C1348b();
            }

            public C1348b() {
            }
        }

        public static final class c extends b {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final i1 f88222a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final t f88223b;

            public final boolean equals(Object r100) {
                if (this != r100) goto L4;
                return true;
            L4:
                if ((r100 instanceof c) == false) goto L10;
                c r101 = (c) r100;
                if (Intrinsics.areEqual(this.f88222a, r101.f88222a) == true) goto L8;
                return false;
            L8:
                if (Intrinsics.areEqual(this.f88223b, r101.f88223b) == true) goto L16;
                return false;
            L16:
                return true;
            L10:
                return false;
            }

            public final int hashCode() {
                i1 r100 = this.f88222a;
                int r101 = 0;
                if (r100 == null) goto L5;
                int r102 = r100.hashCode();
            L6:
                int r103 = r102 * 31;
                t r104 = this.f88223b;
                if (r104 == null) goto L10;
                r101 = r104.hashCode();
            L10:
                return r103 + r101;
            L5:
                r102 = 0;
                goto L6
            }

            public final String toString() {
                return "Reject(rejectInfo=" + this.f88222a + ", info=" + this.f88223b + ")";
            }

            public c(i1 r100, t r101) {
                Intrinsics.checkNotNullParameter(r100, "rejectInfo");
                this.f88222a = r100;
                this.f88223b = r101;
            }
        }

        public b() {
        }
    }

    public static final class c extends com.bytedance.android.live.core.utils.rxutils.l.a {
        public c() {
        }

        @Override // com.bytedance.android.live.core.utils.rxutils.l.a
        public final boolean a(Throwable r100, int r101) {
            c r102 = v.f88217a;
            if ((r100 instanceof ApiException) == true) goto L5;
        L7:
            boolean r103 = false;
        L8:
            if (r103 == false) goto L11;
            return true;
        L11:
            return super.a(r100, r101);
        L5:
            if (((ApiException) r100).getErrorCode() != 43913) goto L7;
            r103 = true;
            goto L8
        }
    }

    public v() {
    }

    static {
        f88217a = new c();
    }

    public static t b(k r110, long r111) {
        Intrinsics.checkNotNullParameter(r110, "$this$toLotteryInfo");
        long r100 = r110.getLotteryId();
        int r101 = r110.getStatus();
        long r102 = 1000;
        long r103 = e3.c(r110.getCurrentTime() * r102, r110.getDrawTime() * r102, 0, false) - r111;
        p r104 = r110.getPrizeInfo();
        if (r104 == null) goto L5;
        int r105 = r104.getType();
    L6:
        long r106 = r110.getPrizeCount();
        List<h> r107 = r110.getConditions();
        ArrayList r112 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r107, 10));
        Iterator<T> r108 = r107.iterator();
    L8:
        if (r108.hasNext() == false) goto L11;
        r112.add(Integer.valueOf(((h) r108.next()).getType()));
        goto L8
    L11:
        return new t(r100, r101, r103, r105, r106, 0, r112, r110.getUseNewDrawInteraction(), r110.getServerBizData(), r110.getUiConfig(), (com.bytedance.android.live.profit.lottery.c) GsonProtectorUtils.fromJson(GsonHelper.getDefault(), r110.getExtra(), com.bytedance.android.live.profit.lottery.c.class));
    L5:
        r105 = -1;
        goto L6
    }

    public static Single a(long r110, boolean r111, LotteryApi.QueryFrom r210, int r211) {
        int r100 = 0;
        if ((r211 & 2) == 0) goto L5;
        boolean r101 = false;
    L7:
        if ((r211 & 4) == 0) goto L10;
        r100 = 5;
    L10:
        if ((r211 & 8) == 0) goto L12;
        long r102 = 3000;
    L14:
        if ((r211 & 16) == 0) goto L16;
        LotteryApi.QueryFrom r103 = LotteryApi.QueryFrom.Undefined;
    L17:
        Intrinsics.checkNotNullParameter(r103, "queryFrom");
        LinkedHashMap<String, String> r104 = LotteryTraceMonitor.f88034a;
        LotteryTraceMonitor.a(LotteryTraceMonitor.EventName.lottery_init_api, GearStrategyConsts.EV_SELECT_BEGIN);
        com.bytedance.android.live.revenue.common.g r105 = new com.bytedance.android.live.revenue.common.g("ttlive_lottery", "fetchRoomLottery roomId=" + r110);
        r105.a(GearStrategyConsts.EV_SELECT_BEGIN);
        int r106 = LotteryApi.f87936a;
        long r107 = r103.getValue();
        tz0.b r108 = tz0.b.f548039a;
        uz0.c r112 = new uz0.c();
        r108.getClass();
        Intrinsics.checkNotNullParameter(r112, "$this$beforeConfigureRequest");
        r112.a(qx0.a.f535099a);
        Map<String, String> r109 = r112.f552161b;
        Intrinsics.checkNotNullParameter(r109, "queriesMap");
        String r113 = Long.valueOf(r110).toString();
        Intrinsics.checkNotNullParameter("room_id", "$this$setTo");
        if (r113 == null) goto L20;
        r109.put("room_id", r113);
    L20:
        String r114 = Long.valueOf(r107).toString();
        Intrinsics.checkNotNullParameter("query_from", "$this$setTo");
        if (r114 == null) goto L23;
        r109.put("query_from", r114);
    L23:
        Intrinsics.checkNotNullParameter(r112, "$this$afterConfigureRequest");
        return RxUtilKt.h(RxCompatKt.b(((INetworkService) com.bytedance.android.live.revenue.core.util.f.a(INetworkService.class)).x0(INetworkService.Biz.Revenue, "/webcast/lottery/melon/lottery_info/", TypesJVMKt.getJavaType(Reflection.typeOf(f.class)), Extra.class, r112.f552163d, r112.f552160a, r112.f552161b, r112.f552162c).map(new e0(r101)).onErrorResumeNext(f0.f88067a), new com.bytedance.android.live.core.utils.rxutils.l(r100, r102))).singleOrError().doOnEvent(new g0(r105));
    L16:
        r103 = r210;
        goto L17
    L12:
        r102 = 0;
        goto L14
    L5:
        r101 = r111;
        goto L7
    }
}
