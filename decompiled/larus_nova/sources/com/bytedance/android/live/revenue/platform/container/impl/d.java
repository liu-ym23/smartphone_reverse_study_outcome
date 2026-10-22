package com.bytedance.android.live.revenue.platform.container.impl;

import android.view.View;
import com.bytedance.android.live.revenue.platform.container.impl.core.NativeHostServiceImpl;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.lynx.tasm.LynxError;
import com.miui.easygo.constant.EasyGoDbTable;
import io.reactivex.Single;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.ExceptionsKt;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes47.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f91211a = 0;

    public static final class a<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ View f91212a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f91213b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ String f91214c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ String f91215d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ String f91216e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final /* synthetic */ Throwable f91217f;

        public a(View r100, String r101, String r102, String r103, String r104, Throwable r105) {
            this.f91212a = r100;
            this.f91213b = r101;
            this.f91214c = r102;
            this.f91215d = r103;
            this.f91216e = r104;
            this.f91217f = r105;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r110) {
            Integer r111 = (Integer) r110;
            cq2.c r100 = (cq2.c) vh6.c.b(cq2.c.class);
            View r101 = this.f91212a;
            String r102 = this.f91213b;
            JSONObject r103 = com.bytedance.android.live.revenue.common.q.b(new Pair[]{TuplesKt.to("platform_type", "android")});
            r103.put("caller", "android");
            r103.put("callee", "lynx");
            NativeHostServiceImpl r104 = (NativeHostServiceImpl) com.bytedance.android.live.revenue.core.util.f.a(NativeHostServiceImpl.class);
            com.bytedance.android.live.revenue.core.b r105 = com.bytedance.android.live.revenue.core.util.j.C0.a();
            if ((r105 instanceof com.bytedance.android.live.revenue.core.a) == true) goto L5;
            r105 = null;
        L5:
            com.bytedance.android.live.revenue.core.a r106 = (com.bytedance.android.live.revenue.core.a) r105;
            if (r106 == null) goto L8;
            cy0.k r107 = r106.getScope();
        L9:
            String r108 = r104.E(r107);
            if (r108 == null) goto L12;
            r103.put(EasyGoDbTable.Server.SERVICE_VERSION, r108);
        L12:
            Unit r109 = Unit.INSTANCE;
            LinkedHashMap r112 = new LinkedHashMap();
            r112.put("channel_id", this.f91214c);
            r112.put("interface_id", this.f91215d);
            r112.put("method_id", this.f91216e);
            Iterator r113 = r112.entrySet().iterator();
        L14:
            if (r113.hasNext() == false) goto L16;
            Map.Entry r114 = (Map.Entry) r113.next();
            r103.put((String) r114.getKey(), r114.getValue());
            goto L14
        L16:
            Unit r115 = Unit.INSTANCE;
            JSONObject r116 = new JSONObject();
            Iterator r117 = new LinkedHashMap().entrySet().iterator();
        L18:
            if (r117.hasNext() == false) goto L20;
            Map.Entry r118 = (Map.Entry) r117.next();
            r116.put((String) r118.getKey(), r118.getValue());
            goto L18
        L20:
            Unit r119 = Unit.INSTANCE;
            if (r116.length() <= 0) goto L23;
            boolean r120 = true;
        L24:
            if (r120 == true) goto L27;
            r116 = null;
        L27:
            JSONObject r121 = com.bytedance.android.live.revenue.common.q.b(new Pair[]{TuplesKt.to("url", this.f91213b)});
            LinkedHashMap r122 = new LinkedHashMap();
            r122.put("message", String.valueOf(this.f91217f.getMessage()));
            r122.put("stacktrace", ExceptionsKt.stackTraceToString(this.f91217f));
            Iterator r123 = r122.entrySet().iterator();
        L29:
            if (r123.hasNext() == false) goto L31;
            Map.Entry r124 = (Map.Entry) r123.next();
            r121.put((String) r124.getKey(), r124.getValue());
            goto L29
        L31:
            Unit r125 = Unit.INSTANCE;
            r100.Y2(r101, "ttlive_aio_foundation_biz_error", r102, r103, r116, r121, false);
            return;
        L23:
            r120 = false;
            goto L24
        L8:
            r107 = null;
            goto L9
        }
    }

    public static final class b<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ View f91218a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f91219b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ String f91220c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ String f91221d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ String f91222e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final /* synthetic */ int f91223f;

        public b(View r100, String r101, String r102, String r103, String r104, int r105) {
            this.f91218a = r100;
            this.f91219b = r101;
            this.f91220c = r102;
            this.f91221d = r103;
            this.f91222e = r104;
            this.f91223f = r105;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r110) {
            Integer r111 = (Integer) r110;
            cq2.c r100 = (cq2.c) vh6.c.b(cq2.c.class);
            View r101 = this.f91218a;
            String r102 = this.f91219b;
            JSONObject r103 = com.bytedance.android.live.revenue.common.q.b(new Pair[]{TuplesKt.to("platform_type", "android")});
            String r104 = this.f91220c;
            if (r104 == null) goto L5;
            r103.put("interface_id", r104);
        L5:
            String r105 = this.f91221d;
            if (r105 == null) goto L8;
            r103.put("method_id", r105);
        L8:
            r103.put("caller", "android");
            r103.put("callee", "lynx");
            NativeHostServiceImpl r106 = (NativeHostServiceImpl) com.bytedance.android.live.revenue.core.util.f.a(NativeHostServiceImpl.class);
            com.bytedance.android.live.revenue.core.b r107 = com.bytedance.android.live.revenue.core.util.j.C0.a();
            if ((r107 instanceof com.bytedance.android.live.revenue.core.a) == true) goto L11;
            r107 = null;
        L11:
            com.bytedance.android.live.revenue.core.a r108 = (com.bytedance.android.live.revenue.core.a) r107;
            if (r108 == null) goto L14;
            cy0.k r109 = r108.getScope();
        L15:
            String r112 = r106.E(r109);
            if (r112 == null) goto L18;
            r103.put(EasyGoDbTable.Server.SERVICE_VERSION, r112);
        L18:
            Unit r113 = Unit.INSTANCE;
            LinkedHashMap r114 = new LinkedHashMap();
            r114.put("status", Integer.valueOf(this.f91223f));
            Iterator r115 = r114.entrySet().iterator();
        L20:
            if (r115.hasNext() == false) goto L22;
            Map.Entry r116 = (Map.Entry) r115.next();
            r103.put((String) r116.getKey(), r116.getValue());
            goto L20
        L22:
            Unit r117 = Unit.INSTANCE;
            JSONObject r118 = new JSONObject();
            Iterator r119 = new LinkedHashMap().entrySet().iterator();
        L24:
            if (r119.hasNext() == false) goto L26;
            Map.Entry r120 = (Map.Entry) r119.next();
            r118.put((String) r120.getKey(), r120.getValue());
            goto L24
        L26:
            Unit r121 = Unit.INSTANCE;
            if (r118.length() <= 0) goto L29;
            boolean r122 = true;
        L30:
            if (r122 == true) goto L33;
            r118 = null;
        L33:
            JSONObject r123 = com.bytedance.android.live.revenue.common.q.b(new Pair[]{TuplesKt.to("url", this.f91219b)});
            String r124 = this.f91222e;
            if (r124 == null) goto L36;
            r123.put("channel_id", r124);
        L36:
            Iterator r125 = new LinkedHashMap().entrySet().iterator();
        L38:
            if (r125.hasNext() == false) goto L40;
            Map.Entry r126 = (Map.Entry) r125.next();
            r123.put((String) r126.getKey(), r126.getValue());
            goto L38
        L40:
            Unit r127 = Unit.INSTANCE;
            r100.Y2(r101, "ttlive_aio_foundation_call_all", r102, r103, r118, r123, true);
            return;
        L29:
            r122 = false;
            goto L30
        L14:
            r109 = null;
            goto L15
        }
    }

    public static final class c<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ View f91224a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f91225b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ String f91226c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ String f91227d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ String f91228e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final /* synthetic */ String f91229f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final /* synthetic */ String f91230g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final /* synthetic */ Throwable f91231h;

        public c(View r100, String r101, String r102, String r103, String r104, String r105, String r106, Throwable r107) {
            this.f91224a = r100;
            this.f91225b = r101;
            this.f91226c = r102;
            this.f91227d = r103;
            this.f91228e = r104;
            this.f91229f = r105;
            this.f91230g = r106;
            this.f91231h = r107;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r110) {
            Integer r111 = (Integer) r110;
            cq2.c r100 = (cq2.c) vh6.c.b(cq2.c.class);
            View r101 = this.f91224a;
            String r102 = this.f91225b;
            JSONObject r103 = com.bytedance.android.live.revenue.common.q.b(new Pair[]{TuplesKt.to("platform_type", "android")});
            String r104 = this.f91226c;
            if (r104 == null) goto L5;
            r103.put("interface_id", r104);
        L5:
            r103.put("caller", "android");
            r103.put("callee", "lynx");
            NativeHostServiceImpl r105 = (NativeHostServiceImpl) com.bytedance.android.live.revenue.core.util.f.a(NativeHostServiceImpl.class);
            com.bytedance.android.live.revenue.core.b r106 = com.bytedance.android.live.revenue.core.util.j.C0.a();
            if ((r106 instanceof com.bytedance.android.live.revenue.core.a) == true) goto L8;
            r106 = null;
        L8:
            com.bytedance.android.live.revenue.core.a r107 = (com.bytedance.android.live.revenue.core.a) r106;
            if (r107 == null) goto L11;
            cy0.k r108 = r107.getScope();
        L12:
            String r109 = r105.E(r108);
            if (r109 == null) goto L15;
            r103.put(EasyGoDbTable.Server.SERVICE_VERSION, r109);
        L15:
            Unit r112 = Unit.INSTANCE;
            LinkedHashMap r113 = new LinkedHashMap();
            r113.put("channel_id", this.f91228e);
            r113.put("interface_id", this.f91229f);
            r113.put("method_id", this.f91230g);
            Iterator r114 = r113.entrySet().iterator();
        L17:
            if (r114.hasNext() == false) goto L19;
            Map.Entry r115 = (Map.Entry) r114.next();
            r103.put((String) r115.getKey(), r115.getValue());
            goto L17
        L19:
            Unit r116 = Unit.INSTANCE;
            JSONObject r117 = new JSONObject();
            Iterator r118 = new LinkedHashMap().entrySet().iterator();
        L21:
            if (r118.hasNext() == false) goto L23;
            Map.Entry r119 = (Map.Entry) r118.next();
            r117.put((String) r119.getKey(), r119.getValue());
            goto L21
        L23:
            Unit r120 = Unit.INSTANCE;
            if (r117.length() <= 0) goto L26;
            boolean r121 = true;
        L27:
            if (r121 == true) goto L30;
            r117 = null;
        L30:
            JSONObject r122 = com.bytedance.android.live.revenue.common.q.b(new Pair[]{TuplesKt.to("url", this.f91225b)});
            String r123 = this.f91227d;
            if (r123 == null) goto L33;
            r122.put("channel_id", r123);
        L33:
            LinkedHashMap r124 = new LinkedHashMap();
            r124.put("message", String.valueOf(this.f91231h.getMessage()));
            r124.put("stacktrace", ExceptionsKt.stackTraceToString(this.f91231h));
            Iterator r125 = r124.entrySet().iterator();
        L35:
            if (r125.hasNext() == false) goto L37;
            Map.Entry r126 = (Map.Entry) r125.next();
            r122.put((String) r126.getKey(), r126.getValue());
            goto L35
        L37:
            Unit r127 = Unit.INSTANCE;
            r100.Y2(r101, "ttlive_aio_foundation_internal_error", r102, r103, r117, r122, false);
            return;
        L26:
            r121 = false;
            goto L27
        L11:
            r108 = null;
            goto L12
        }
    }

    public d() {
    }

    static {
    }

    public static void a(View r100, String r110, String r111, String r112, String r113, Throwable r114) {
        Intrinsics.checkNotNullParameter(r111, RemoteMessageConst.Notification.CHANNEL_ID);
        Intrinsics.checkNotNullParameter(r112, "interfaceId");
        Intrinsics.checkNotNullParameter(r113, "methodId");
        Intrinsics.checkNotNullParameter(r114, LynxError.LYNX_THROWABLE);
        Single.just(1).subscribeOn(Schedulers.computation()).subscribe(new a(r100, r110, r111, r112, r113, r114), k.f91302a);
    }

    public static void b(View r100, String r110, String r111, String r112, String r113, int r114) {
        Intrinsics.checkNotNullParameter(r111, RemoteMessageConst.Notification.CHANNEL_ID);
        Intrinsics.checkNotNullParameter(r112, "interfaceId");
        Intrinsics.checkNotNullParameter(r113, "methodId");
        Single.just(1).subscribeOn(Schedulers.computation()).subscribe(new b(r100, r110, r112, r113, r111, r114), k.f91302a);
    }

    public static /* synthetic */ void d(View r100, String r101, String r110, String r111, String r112, Throwable r113) {
        c(r100, r101, r110, r111, r112, r113, "android", "lynx");
    }

    public static void c(View r110, String r111, String r112, String r113, String r114, Throwable r115, String r116, String r117) {
        Intrinsics.checkNotNullParameter(r112, RemoteMessageConst.Notification.CHANNEL_ID);
        Intrinsics.checkNotNullParameter(r113, "interfaceId");
        Intrinsics.checkNotNullParameter(r114, "methodId");
        Intrinsics.checkNotNullParameter(r115, LynxError.LYNX_THROWABLE);
        Intrinsics.checkNotNullParameter(r116, "caller");
        Intrinsics.checkNotNullParameter(r117, "callee");
        Single.just(1).subscribeOn(Schedulers.computation()).subscribe(new c(r110, r111, r117, r116, r112, r113, r114, r115), k.f91302a);
    }
}
