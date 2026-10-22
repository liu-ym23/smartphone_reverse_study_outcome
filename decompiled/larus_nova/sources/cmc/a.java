package cmc;

import amc.g;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.bytedance.android.livesdk.ktvimpl.ktvroom.challenge.vm.KtvSingChallengeViewModel;
import com.bytedance.mt.protector.impl.UriProtector;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.ugc.effectmanager.EffectConfiguration;
import com.ss.ttvideoengine.DataLoaderHelper;
import com.ss.ugc.live.sdk.message.data.PayloadItemType;
import com.ss.ugc.live.sdk.msg.data.HeartbeatPacket;
import com.ss.ugc.live.sdk.msg.data.SdkMessage;
import com.ss.ugc.live.sdk.msg.data.SdkResponse;
import com.ss.ugc.live.sdk.msg.network.HttpException;
import com.ss.ugc.live.sdk.msg.network.WSState;
import com.ss.ugc.live.sdk.msg.network.i;
import com.ss.ugc.live.sdk.msg.network.m;
import com.ss.ugc.live.sdk.msg.utils.MainTaskScheduler;
import com.ss.ugc.live.sdk.msg.utils.h;
import com.ss.ugc.live.sdk.msg.utils.j;
import com.ss.ugc.live.sdk.msg.utils.k;
import fmc.l;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import kotlin.text.StringsKt;
import org.json.JSONObject;
import tlc.f;
import vlc.n;
import vlc.o;

/* JADX INFO: loaded from: classes36.dex */
public final class a implements com.ss.ugc.live.sdk.msg.utils.d, com.ss.ugc.live.sdk.msg.dispatch.d {
    public static String D;
    public static String E;
    public final WSState A;
    public final g B;
    public final List<bmc.a> C;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final i f24252a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f24253b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final bmc.b f24254c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final amc.d f24255d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f24256e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public n f24257f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final c f24258g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final d f24259h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public String f24260i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public volatile String f24261j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public long f24262k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public long f24263l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public long f24264m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public long f24265n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public long f24266o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public long f24267p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public long f24268q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public long f24269r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public volatile boolean f24270s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public int f24271t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public int f24272u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final j f24273v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final List<Long> f24274w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final AtomicLong f24275x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public long f24276y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final com.ss.ugc.live.sdk.msg.c f24277z;

    /* JADX INFO: renamed from: cmc.a$a, reason: collision with other inner class name */
    public static final class C0462a {
    }

    public final class b implements m {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ a f24278a;

        /* JADX INFO: renamed from: cmc.a$b$a, reason: collision with other inner class name */
        public static final class RunnableC0463a implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ b f24279a;

            public RunnableC0463a(b r100) {
                this.f24279a = r100;
            }

            @Override // java.lang.Runnable
            public final void run() {
                n r100 = this.f24279a.f24278a.f24257f;     // Catch: Throwable -> L6
                if (r100 == null) goto L9;
                r100.a();     // Catch: Throwable -> L6
                return;
            L9:
                return;
            L6:
                th = move-exception;
                if (RunnableProtector.intercept(th) == true) goto L13;
                throw th;
            }
        }

        /* JADX INFO: renamed from: cmc.a$b$b, reason: collision with other inner class name */
        public static final class RunnableC0464b implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ b f24280a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ String f24281b;

            public RunnableC0464b(b r100, String r101) {
                this.f24280a = r100;
                this.f24281b = r101;
            }

            @Override // java.lang.Runnable
            public final void run() {
                n r100 = this.f24280a.f24278a.f24257f;     // Catch: Throwable -> L6
                if (r100 == null) goto L9;
                r100.b(this.f24281b);     // Catch: Throwable -> L6
                return;
            L9:
                return;
            L6:
                th = move-exception;
                if (RunnableProtector.intercept(th) == true) goto L13;
                throw th;
            }
        }

        public static final class c implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ b f24282a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ f f24283b;

            public c(b r100, f r101) {
                this.f24282a = r100;
                this.f24283b = r101;
            }

            @Override // java.lang.Runnable
            public final void run() {
                n r100 = this.f24282a.f24278a.f24257f;     // Catch: Throwable -> L6
                if (r100 == null) goto L9;
                r100.d(this.f24283b);     // Catch: Throwable -> L6
                return;
            L9:
                return;
            L6:
                th = move-exception;
                if (RunnableProtector.intercept(th) == true) goto L13;
                throw th;
            }
        }

        @Override // com.ss.ugc.live.sdk.msg.network.m
        public final void i(f r100) {
            Intrinsics.checkNotNullParameter(r100, "payloadItem");
        }

        @Override // com.ss.ugc.live.sdk.msg.network.m
        public final void a() {
            com.ss.ugc.live.sdk.msg.utils.a.c(this.f24278a.f24277z, "on ws connected");
            ((ArrayList) this.f24278a.f24274w).clear();
            a r100 = this.f24278a;
            r100.f24258g.removeMessages(DataLoaderHelper.DATALOADER_KEY_INT_CUR_DISK_SIZE_MB);
            r100.f24258g.removeMessages(DataLoaderHelper.DATALOADER_KEY_INT_DEV_MEMORY_SIZE_MB);
            this.f24278a.c();
            this.f24278a.o();
            MainTaskScheduler.a(new RunnableC0463a(this));
        }

        public b(a r100) {
            this.f24278a = r100;
        }

        @Override // com.ss.ugc.live.sdk.msg.network.m
        public final void b(String r100) {
            Intrinsics.checkNotNullParameter(r100, "reason");
            com.ss.ugc.live.sdk.msg.utils.a.c(this.f24278a.f24277z, "on ws disconnected, reason: " + r100);
            a r101 = this.f24278a;
            if (r101.f24258g.hasMessages(2108) == false) goto L5;
            r101.f24258g.removeMessages(2108);
        L5:
            this.f24278a.c();
            this.f24278a.n(0);
            MainTaskScheduler.a(new RunnableC0464b(this, r100));
        }

        @Override // com.ss.ugc.live.sdk.msg.network.m
        public final void d(f r100) {
            Intrinsics.checkNotNullParameter(r100, "payloadItem");
            if (this.f24278a.k() == true) goto L5;
            return;
        L5:
            com.ss.ugc.live.sdk.msg.c r101 = this.f24278a.f24277z;
            StringBuilder r102 = new StringBuilder("on ws message received, payload type: ");
            r102.append(r100.f546762c);
            r102.append(", log id: ");
            int r103 = com.ss.ugc.live.sdk.msg.utils.c.f458473a;
            List<com.ss.ugc.live.sdk.msg.network.d> r104 = r100.f546765f;
            if (r104 == null) goto L19;
            Iterator<T> r105 = r104.iterator();
        L9:
            if (r105.hasNext() == false) goto L13;
            Object r106 = r105.next();
            if (StringsKt.equals("im-logid", ((com.ss.ugc.live.sdk.msg.network.d) r106).f458296a, true) == false) goto L9;
        L14:
            com.ss.ugc.live.sdk.msg.network.d r107 = (com.ss.ugc.live.sdk.msg.network.d) r106;
            if (r107 == null) goto L19;
            String r108 = r107.f458297b;
            if (r108 == null) goto L19;
        L20:
            r102.append(r108);
            com.ss.ugc.live.sdk.msg.utils.a.c(r101, r102.toString());
            String r109 = r100.f546762c;
            if (Intrinsics.areEqual(r109, PayloadItemType.PAYLOAD_TYPE_MSG.getType()) == false) goto L24;
        L25:
            a r110 = this.f24278a;
            r110.f24268q = System.currentTimeMillis();
            r100.f546768i = System.currentTimeMillis();
            this.f24278a.f24258g.obtainMessage(2107, r100).sendToTarget();
        L32:
            MainTaskScheduler.a(new c(this, r100));
            return;
        L24:
            if (Intrinsics.areEqual(r109, PayloadItemType.PAYLOAD_TYPE_RECONNECT.getType()) == true) goto L25;
            if (Intrinsics.areEqual(r109, PayloadItemType.PAYLOAD_TYPE_CLOSE.getType()) == false) goto L30;
            this.f24278a.f("server close");
            this.f24278a.n(0);
            goto L32
        L30:
            if (Intrinsics.areEqual(r109, PayloadItemType.PAYLOAD_TYPE_HEARTBEAT.getType()) == false) goto L32;
            this.f24278a.f24258g.obtainMessage(2109, r100).sendToTarget();
            goto L32
        L13:
            r106 = null;
        L19:
            r108 = "";
            goto L20
        }
    }

    public static final class c extends Handler {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ a f24284a;

        @Override // android.os.Handler
        public final void handleMessage(Message r110) {
            Intrinsics.checkNotNullParameter(r110, "msg");
            a r100 = this.f24284a;
            r100.getClass();
            long r101 = 0;
            switch(r110.what) {
                case 2103: goto L76;
                case 2104: goto L68;
                case 2105: goto L56;
                case 2106: goto L51;
                case 2107: goto L46;
                case 2108: goto L36;
                case 2109: goto L10;
                case 2110: goto L106;
                case 2111: goto L7;
                case 2112: goto L5;
                default: goto L106;
            };
        L5:
            r100.e();
            return;
        L10:
            Object r111 = r110.obj;
            if (r111 == null) goto L34;
            f r112 = (f) r111;
            long r102 = r100.f24276y;     // Catch: Throwable -> L31
            int r103 = h.f458480a;     // Catch: Throwable -> L31
            List<com.ss.ugc.live.sdk.msg.network.d> r113 = r112.f546765f;     // Catch: Throwable -> L31
            if (r113 == null) goto L29;
            Iterator<T> r114 = r113.iterator();     // Catch: Throwable -> L31
        L17:
            if (r114.hasNext() == false) goto L21;
            Object r104 = r114.next();     // Catch: Throwable -> L31
            if (Intrinsics.areEqual(((com.ss.ugc.live.sdk.msg.network.d) r104).f458296a, "server_time") == false) goto L17;
        L22:
            com.ss.ugc.live.sdk.msg.network.d r105 = (com.ss.ugc.live.sdk.msg.network.d) r104;     // Catch: Throwable -> L31
            if (r105 == null) goto L29;
            String r115 = r105.f458297b;     // Catch: Throwable -> L31
            if (r115 == null) goto L29;
            Long r116 = StringsKt.toLongOrNull(r115);     // Catch: Throwable -> L31
            if (r116 == null) goto L29;
            r101 = r116.longValue();     // Catch: Throwable -> L31
            goto L29
        L21:
            r104 = null;
        L29:
            long r106 = System.currentTimeMillis();     // Catch: Throwable -> L31
            com.ss.ugc.live.sdk.msg.utils.a.c(r100.f24277z, "sendPacketTime = " + r102 + ", serverTime = " + r101 + ", receivePacketTime = " + r106 + ", serverTimeGap = " + ((r101 + ((r106 - r102) / ((long) 2))) - r106));     // Catch: Throwable -> L31
            return;
        L31:
            th = move-exception;
            th.printStackTrace();
            return;
        L34:
            throw new NullPointerException("null cannot be cast to non-null type com.ss.ugc.live.sdk.message.data.PayloadItem");
        L46:
            Object r117 = r110.obj;
            if (r117 == null) goto L50;
            fmc.m r107 = new fmc.m(r100.f24254c, r100.f24255d);
            r100.f24277z.f458212i.b(r107, (f) r117, r100.f24273v);
            return;
        L50:
            throw new NullPointerException("null cannot be cast to non-null type com.ss.ugc.live.sdk.message.data.PayloadItem");
        L51:
            Object r118 = r110.obj;
            if (r118 == null) goto L55;
            r100.f((String) r118);
            return;
        L55:
            throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
        L56:
            Object r119 = r110.obj;
            if (r119 == null) goto L66;
            SdkResponse r120 = (SdkResponse) r119;
            String r108 = r120.push_server;
            Map<String, String> r109 = r120.route_params;
            String r121 = r120.push_server_v2;
            if (r100.k() == false) goto L110;
            com.ss.ugc.live.sdk.msg.utils.a.c(r100.f24277z, "connect ws, url: " + r108);
            HashMap r122 = new HashMap();
            if (r109 == null) goto L64;
            r122.putAll(r109);
        L64:
            r122.putAll(r100.f24255d.a());
            r122.putAll(r100.i());
            r122.putAll(r100.B.a());
            r100.A.j(r108, r122, new b(r100), r121);
            r100.B.j();
            r100.p(5000);
            r100.q("2");
            return;
        L110:
            return;
        L66:
            throw new NullPointerException("null cannot be cast to non-null type com.ss.ugc.live.sdk.msg.data.SdkResponse");
        L76:
            Object r123 = r110.obj;
            if (r123 == null) goto L88;
            String r124 = (String) r123;
            if (r100.k() == true) goto L81;
            return;
        L81:
            if (r100.f24270s == false) goto L84;
            return;
        L84:
            if (r100.A.c() == true) goto L114;
            com.ss.ugc.live.sdk.msg.utils.a.c(r100.f24277z, "fetch message with rule " + r124 + ", cursor: " + r100.f24261j);
            HashMap r125 = new HashMap();
            r125.putAll(r100.B.a());
            HashMap r126 = new HashMap();
            r126.put("fetch_rule", r124);
            r126.putAll(r100.i());
            com.ss.ugc.live.sdk.msg.network.f.a r127 = new com.ss.ugc.live.sdk.msg.network.f.a();
            r127.f458310a.f458299b = r100.j();
            com.ss.ugc.live.sdk.msg.network.f.a r128 = r127.query(r125);
            com.ss.ugc.live.sdk.msg.network.f r129 = r128.f458310a;
            r129.f458305h = r126;
            r129.f458304g = "application/x-www-form-urlencoded; charset=UTF-8";
            com.ss.ugc.live.sdk.msg.network.f r130 = r128.a();
            r100.f24268q = System.currentTimeMillis();
            r100.f24270s = true;
            r100.f24277z.f458212i.b(new fmc.i(fmc.h.f477904a, r100.f24252a, r100.f24254c, Intrinsics.areEqual(r100.f24261j, "0")), r130, r100.f24273v);
            return;
        L114:
            return;
        L88:
            throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
        L106:
            return;
        L7:
            if (Intrinsics.areEqual(r100.A.f458285d.b(), WSState.c.b.f458294a) == false) goto L9;
            r100.f("ws connect timeout");
        L9:
            r100.n(0);
            return;
        L36:
            if (r100.k() == true) goto L39;
            return;
        L39:
            if (r100.A.c() == false) goto L109;
            long r131 = r100.f24275x.incrementAndGet();
            r100.f24276y = System.currentTimeMillis();
            HeartbeatPacket.Builder r132 = new HeartbeatPacket.Builder();
            Iterator<T> r133 = r100.C.iterator();
        L43:
            if (r133.hasNext() == false) goto L45;
            ((bmc.a) r133.next()).O40(r132);
            goto L43
        L45:
            HeartbeatPacket r134 = r132.build();
            com.ss.ugc.live.sdk.msg.utils.a.c(r100.f24277z, "send heartbeat packet: seqId is " + r131);
            r100.A.k("hb", HeartbeatPacket.ADAPTER.encode(r134), new ArrayList(), r131, r131);
            r100.o();
            return;
        L109:
            return;
        L68:
            if (r100.k() == true) goto L70;
            return;
        L70:
            if (r100.f24270s == false) goto L73;
            return;
        L73:
            if (r100.A.c() == true) goto L112;
            com.ss.ugc.live.sdk.msg.utils.a.c(r100.f24277z, "determine message fetch strategy, cursor: " + r100.f24261j);
            HashMap r135 = new HashMap();
            r135.putAll(r100.B.a());
            HashMap r136 = new HashMap();
            r136.put("fetch_rule", "1");
            r136.putAll(r100.i());
            com.ss.ugc.live.sdk.msg.network.f.a r137 = new com.ss.ugc.live.sdk.msg.network.f.a();
            r137.f458310a.f458299b = r100.j();
            com.ss.ugc.live.sdk.msg.network.f.a r138 = r137.query(r135);
            com.ss.ugc.live.sdk.msg.network.f r139 = r138.f458310a;
            r139.f458305h = r136;
            r139.f458304g = "application/x-www-form-urlencoded; charset=UTF-8";
            com.ss.ugc.live.sdk.msg.network.f r140 = r138.a();
            r100.f24268q = System.currentTimeMillis();
            r100.f24270s = true;
            r100.f24277z.f458212i.b(new fmc.i(fmc.a.f477893a, r100.f24252a, r100.f24254c, Intrinsics.areEqual(r100.f24261j, "0")), r140, r100.f24273v);
            return;
        }

        public c(a r100, Looper r101) {
            this.f24284a = r100;
            super(r101);
        }
    }

    public static final class d extends Handler {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ a f24285a;

        @Override // android.os.Handler
        public final void handleMessage(Message r100) {
            Intrinsics.checkNotNullParameter(r100, "msg");
            a r101 = this.f24285a;
            r101.getClass();
            int r102 = r100.what;
            if (r102 != 2101) goto L5;
            r101.f24266o = System.currentTimeMillis();
            if (r101.f24253b == true) goto L18;
            r101.f24258g.obtainMessage(DataLoaderHelper.DATALOADER_KEY_INT_CUR_DISK_SIZE_MB, "0").sendToTarget();
            return;
        L18:
            if (r101.f24256e == false) goto L20;
            r101.f24258g.obtainMessage(2112).sendToTarget();
            return;
        L20:
            r101.f24258g.obtainMessage(DataLoaderHelper.DATALOADER_KEY_INT_DEV_MEMORY_SIZE_MB).sendToTarget();
            return;
        L5:
            if (r102 != 2102) goto L26;
            Object r103 = r100.obj;
            if (r103 == null) goto L14;
            if (((Boolean) r103).booleanValue() == false) goto L12;
            r101.f24261j = "0";
            r101.f24260i = "";
        L12:
            r101.f24258g.removeCallbacksAndMessages(null);
            Message r104 = r101.f24258g.obtainMessage(DataLoaderHelper.DATALOADER_KEY_STRING_VDP_EXT_DYNAMIC_INFO, "pause");
            r101.f24258g.sendMessage(r104);
            return;
        L14:
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Boolean");
        }

        public d(a r100, Looper r101) {
            this.f24285a = r100;
            super(r101);
        }
    }

    static {
        D = "0";
        E = "";
    }

    public final void c() {
        if (this.f24258g.hasMessages(2111) == false) goto L6;
        this.f24258g.removeMessages(2111);
        return;
    }

    public final String h() {
        String r100 = this.B.g();
        o r101 = amc.a.a(this.B);
        if (r101 == null) goto L18;
        boolean r102 = true;
        if (r101.f() != true) goto L19;
        o r103 = amc.a.a(this.B);
        if (r103 == null) goto L9;
        String r104 = r103.c();
    L10:
        if (r104 != null) goto L12;
    L15:
        if (r102 == false) goto L17;
        return r100;
    L17:
        return r104;
    L12:
        if (r104.length() == 0) goto L15;
        r102 = false;
        goto L15
    L9:
        r104 = null;
        goto L10
    L19:
        return r100;
    L18:
        return r100;
    }

    public final Map<String, String> i() {
        HashMap r100 = new HashMap();
        r100.put("support_cache", "1");
        r100.put("live_cursor", D);
        r100.put("wrds_preload_ext", E);
        r100.put(EffectConfiguration.KEY_CURSOR, this.f24261j);
        if (this.f24260i.length() <= 0) goto L5;
        boolean r101 = true;
    L6:
        if (r101 == true) goto L8;
    L12:
        r100.put("resp_content_type", "protobuf");
        long r102 = this.f24267p;
        if (r102 <= 0) goto L15;
        r100.put("fetch_time", String.valueOf(r102));
    L15:
        r100.put("parse_cnt", String.valueOf(this.f24265n));
        r100.put("recv_cnt", String.valueOf(this.f24264m));
        r100.put("last_rtt", String.valueOf(this.f24263l));
        r100.put("support_wrds", "1");
        if (((ArrayList) this.f24274w).size() <= 0) goto L18;
        r100.put("ack_ids", TextUtils.join(",", this.f24274w));
        ((ArrayList) this.f24274w).clear();
    L18:
        return r100;
    L8:
        if (TextUtils.equals(this.f24261j, "0") == true) goto L12;
        if ((!StringsKt.isBlank(this.f24261j)) == false) goto L12;
        r100.put("internal_ext", this.f24260i);
        goto L12
    L5:
        r101 = false;
        goto L6
    }

    public final String j() {
        String r100 = this.B.e();
        o r101 = amc.a.a(this.B);
        if (r101 == null) goto L18;
        boolean r102 = true;
        if (r101.f() != true) goto L18;
        o r103 = amc.a.a(this.B);
        if (r103 == null) goto L9;
        String r104 = r103.e();
    L10:
        if (r104 != null) goto L12;
    L15:
        if (r102 == true) goto L18;
        r100 = r104;
        goto L18
    L12:
        if (r104.length() == 0) goto L15;
        r102 = false;
        goto L15
    L9:
        r104 = null;
    L18:
        if (this.B.k() == true) goto L20;
        return r100;
    L20:
        if (Intrinsics.areEqual(this.f24261j, "0") == true) goto L22;
        return r100;
    L22:
        return UriProtector.parse(r100).buildUpon().appendEncodedPath("first/").build().toString();
    }

    public final boolean k() {
        return this.f24277z.isRunning();
    }

    public final void e() {
        if (k() == true) goto L5;
        return;
    L5:
        String r100 = h();
        com.ss.ugc.live.sdk.msg.utils.a.c(this.f24277z, "direct connect ws, url: " + r100);
        boolean r101 = false;
        if (r100 != null) goto L8;
    L11:
        boolean r102 = true;
    L12:
        if (r102 == false) goto L15;
        com.ss.ugc.live.sdk.msg.utils.a.c(this.f24277z, "direct ws url is empty");
        com.ss.ugc.live.sdk.msg.utils.a.c(this.f24277z, "fallback to determine message fetch strategy");
        n(0);
        return;
    L15:
        HashMap r103 = new HashMap();
        r103.putAll(this.f24255d.a());
        r103.putAll(i());
        r103.putAll(this.B.a());
        b r104 = new b(this);
        WSState r105 = this.A;
        g r106 = this.B;
        String r107 = null;
        if ((r106 instanceof amc.h) == true) goto L18;
        r106 = null;
    L18:
        amc.h r108 = (amc.h) r106;
        if (r108 == null) goto L21;
        String r109 = r108.m();
    L22:
        o r110 = amc.a.a(this.B);
        if (r110 != null) goto L25;
    L35:
        r105.j(r100, r103, r104, r109);
        p(3000);
        return;
    L25:
        if (r110.f() != true) goto L35;
        o r111 = amc.a.a(this.B);
        if (r111 == null) goto L29;
        r107 = r111.b();
    L29:
        if (r107 != null) goto L31;
    L32:
        r101 = true;
    L33:
        if (r101 == true) goto L35;
        r109 = r107;
        goto L35
    L31:
        if (r107.length() != 0) goto L33;
    L21:
        r109 = null;
        goto L22
    L8:
        if (r100.length() == 0) goto L11;
        r102 = false;
        goto L12
    }

    public final void o() {
        if (k() == true) goto L5;
        return;
    L5:
        com.ss.ugc.live.sdk.msg.utils.a.c(this.f24277z, "trigger heartbeat timer");
        if (this.f24258g.hasMessages(2108) == false) goto L8;
        this.f24258g.removeMessages(2108);
    L8:
        Message r100 = this.f24258g.obtainMessage(2108);
        this.f24258g.sendMessageDelayed(r100, this.f24269r * 1000);
    }

    @Override // com.ss.ugc.live.sdk.msg.dispatch.d
    public final long a() {
        return this.f24268q;
    }

    @Override // com.ss.ugc.live.sdk.msg.dispatch.d
    public final long d() {
        return this.f24262k;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.ss.ugc.live.sdk.msg.utils.d
    public final void b(k r210) {
        Intrinsics.checkNotNullParameter(r210, "whatResult");
        mmc.c r100 = r210.f458483a;
        long r101 = 1000;
        boolean r102 = true;
        if ((r100 instanceof fmc.a) == false) goto L27;
        com.ss.ugc.live.sdk.msg.utils.g<?, Throwable> r103 = r210.f458484b;
        ((fmc.a) r100).getClass();
        Intrinsics.checkNotNullParameter(r103, "result");
        if ((r103 instanceof com.ss.ugc.live.sdk.msg.utils.g.c) == false) goto L22;
        com.ss.ugc.live.sdk.msg.data.a r104 = (com.ss.ugc.live.sdk.msg.data.a) ((com.ss.ugc.live.sdk.msg.utils.g.c) r103).f458479b;
        com.ss.ugc.live.sdk.msg.utils.a.a(this.f24277z, "onDetermineMessageFetchStrategy, logId: ".concat(com.ss.ugc.live.sdk.msg.utils.c.c(r104.f458229a)));
        this.f24270s = false;
        this.f24271t = 0;
        this.f24272u = 0;
        m(r104, false);
        SdkResponse r105 = r104.f458232d;
        Integer r106 = r105.fetch_type;
        if (r106 != null) goto L10;
    L16:
        com.ss.ugc.live.sdk.msg.utils.a.a(this.f24277z, "onDetermineMessageFetchStrategy, use http, redetermine");
        g(r104);
        long r107 = this.f24262k;
        if (r107 <= 0) goto L19;
        r101 = r107;
    L19:
        n(r101);
    L20:
        com.ss.ugc.live.sdk.msg.utils.a.c(this.f24277z, "on messages fetch from http, determine strategy: " + r105.fetch_type + ", messages: " + com.ss.ugc.live.sdk.msg.utils.c.d(r105));
        return;
    L10:
        if (r106.intValue() != 1) goto L16;
        if (TextUtils.isEmpty(r105.push_server) == true) goto L16;
        if (this.A.c() == true) goto L16;
        com.ss.ugc.live.sdk.msg.utils.a.a(this.f24277z, "onDetermineMessageFetchStrategy, use ws");
        g(r104);
        this.f24258g.obtainMessage(DataLoaderHelper.DATALOADER_KEY_INT_CUR_MEMORY_SIZE_MB, r105).sendToTarget();
        goto L20
    L22:
        if ((r103 instanceof com.ss.ugc.live.sdk.msg.utils.g.b) == false) goto L25;
        l(((com.ss.ugc.live.sdk.msg.utils.g.b) r103).f458478b);
        return;
    L25:
        throw new NoWhenBranchMatchedException();
    L27:
        if ((r100 instanceof fmc.h) == false) goto L47;
        com.ss.ugc.live.sdk.msg.utils.g<?, Throwable> r108 = r210.f458484b;
        ((fmc.h) r100).getClass();
        Intrinsics.checkNotNullParameter(r108, "result");
        if ((r108 instanceof com.ss.ugc.live.sdk.msg.utils.g.c) == false) goto L42;
        com.ss.ugc.live.sdk.msg.data.a r109 = (com.ss.ugc.live.sdk.msg.data.a) ((com.ss.ugc.live.sdk.msg.utils.g.c) r108).f458479b;
        com.ss.ugc.live.sdk.msg.utils.a.a(this.f24277z, "onApiSuccess, logId: ".concat(com.ss.ugc.live.sdk.msg.utils.c.c(r109.f458229a)));
        this.f24270s = false;
        this.f24271t = 0;
        this.f24272u = 0;
        m(r109, false);
        g(r109);
        if (Intrinsics.areEqual(this.A.f458285d.b(), WSState.c.b.f458294a) == false) goto L34;
        q("2");
    L40:
        com.ss.ugc.live.sdk.msg.utils.a.c(this.f24277z, "on messages fetch from http, messages: " + com.ss.ugc.live.sdk.msg.utils.c.d(r109.f458232d));
        return;
    L34:
        if (this.f24253b == false) goto L39;
        long r110 = this.f24262k;
        if (r110 <= 0) goto L38;
        r101 = r110;
    L38:
        n(r101);
        goto L40
    L39:
        q("0");
        goto L40
    L42:
        if ((r108 instanceof com.ss.ugc.live.sdk.msg.utils.g.b) == false) goto L45;
        l(((com.ss.ugc.live.sdk.msg.utils.g.b) r108).f458478b);
        return;
    L45:
        throw new NoWhenBranchMatchedException();
    L47:
        if ((r100 instanceof l) == false) goto L126;
        com.ss.ugc.live.sdk.msg.utils.g<?, Throwable> r111 = r210.f458484b;
        ((l) r100).getClass();
        Intrinsics.checkNotNullParameter(r111, "result");
        if ((r111 instanceof com.ss.ugc.live.sdk.msg.utils.g.c) == false) goto L118;
        com.ss.ugc.live.sdk.msg.data.a r112 = (com.ss.ugc.live.sdk.msg.data.a) ((com.ss.ugc.live.sdk.msg.utils.g.c) r111).f458479b;
        com.ss.ugc.live.sdk.msg.utils.a.a(this.f24277z, "onWSPayloadDecoded");
        f r113 = r112.f458230b;
        if (r113 == null) goto L53;
        String r114 = r113.f546762c;
    L55:
        if (Intrinsics.areEqual(r114, PayloadItemType.PAYLOAD_TYPE_MSG.getType()) == false) goto L77;
        m(r112, true);
        g(r112);
        SdkResponse r115 = r112.f458232d;
        if (r115.need_ack.booleanValue() == false) goto L75;
        com.ss.ugc.live.sdk.msg.utils.a.a(this.f24277z, "need send ack: " + r112.b());
        if (k() == false) goto L75;
        if (this.A.c() == false) goto L75;
        f r116 = r112.f458230b;
        if (r116 == null) goto L75;
        String r117 = r112.b();
        if (r117 != null) goto L70;
        r117 = "";
    L70:
        r112.f458234f.f458239d = System.currentTimeMillis();
        com.ss.ugc.live.sdk.msg.data.c r118 = r112.f458234f;
        g r119 = this.B;
        r118.getClass();
        ArrayList r120 = new ArrayList();
        r120.add(new com.ss.ugc.live.sdk.msg.network.d("client_recv_time", String.valueOf(r118.f458236a)));
        r120.add(new com.ss.ugc.live.sdk.msg.network.d("client_start_pack_time", String.valueOf(r118.f458237b)));
        r120.add(new com.ss.ugc.live.sdk.msg.network.d("client_finish_pack_time", String.valueOf(r118.f458238c)));
        r120.add(new com.ss.ugc.live.sdk.msg.network.d("client_send_ack_time", String.valueOf(r118.f458239d)));
        r120.add(new com.ss.ugc.live.sdk.msg.network.d("im-trace-receive_count", String.valueOf(r118.f458240e)));
        r120.add(new com.ss.ugc.live.sdk.msg.network.d("im-trace-error_count", String.valueOf(r118.f458241f.size())));
        LinkedHashSet<Long> r121 = r118.f458241f;
        if (r119 == null) goto L73;
        int r122 = r119.c();
    L74:
        r120.add(new com.ss.ugc.live.sdk.msg.network.d("im-trace-error_msg_ids", TextUtils.join(",", CollectionsKt.take(r121, Math.max(0, r122)))));
        com.ss.ugc.live.sdk.msg.utils.a.c(this.f24277z, "send ack, payload type: ack, internal_ext: ".concat(r117));
        this.A.k("ack", r117.getBytes(Charsets.UTF_8), r120, r116.f546766g, r116.f546767h);
        goto L75
    L73:
        r122 = 15;
    L75:
        com.ss.ugc.live.sdk.msg.utils.a.c(this.f24277z, "on messages fetch from ws, messages: " + com.ss.ugc.live.sdk.msg.utils.c.d(r115));
        return;
    L77:
        if (Intrinsics.areEqual(r114, PayloadItemType.PAYLOAD_TYPE_RECONNECT.getType()) == false) goto L116;
        o r123 = amc.a.a(this.B);
        SdkResponse r124 = r112.f458232d;
        String r125 = r124.proxy_server;
        String r126 = r124.push_server;
        String r127 = r124.push_server_v2;
        if (r123 != null) goto L81;
    L107:
        f("server reconnect");
        String r128 = h();
        if (r128 != null) goto L110;
    L113:
        if (r102 == true) goto L115;
        com.ss.ugc.live.sdk.msg.utils.a.c(this.f24277z, "receive reconnect command, disconnect ws then connect ws url: " + r128);
        this.f24258g.removeMessages(DataLoaderHelper.DATALOADER_KEY_INT_CUR_DISK_SIZE_MB);
        this.f24258g.removeMessages(DataLoaderHelper.DATALOADER_KEY_INT_DEV_MEMORY_SIZE_MB);
        e();
        return;
    L115:
        com.ss.ugc.live.sdk.msg.utils.a.c(this.f24277z, "receive reconnect command, disconnect ws then redetermine");
        n(0);
        return;
    L110:
        if (r128.length() == 0) goto L113;
        r102 = false;
        goto L113
    L81:
        if (r123.f() == false) goto L107;
        com.ss.ugc.live.sdk.msg.utils.a.c(this.f24277z, "receive reconnect command, process switcher url, http url: " + r125 + ", ws url: " + r126);
        if (r125 != null) goto L85;
    L88:
        boolean r129 = true;
    L89:
        if (r129 == true) goto L91;
        r123.g(r125);
    L91:
        if (r126 != null) goto L93;
    L96:
        boolean r130 = true;
    L97:
        if (r130 == true) goto L99;
        r123.d(r126);
    L99:
        if (r127 != null) goto L101;
    L104:
        boolean r131 = true;
    L105:
        if (r131 == true) goto L107;
        r123.a(r127);
        goto L107
    L101:
        if (r127.length() == 0) goto L104;
        r131 = false;
        goto L105
    L93:
        if (r126.length() == 0) goto L96;
        r130 = false;
        goto L97
    L85:
        if (r125.length() == 0) goto L88;
        r129 = false;
        goto L89
    L116:
        com.ss.ugc.live.sdk.msg.utils.a.c(this.f24277z, "can not process payload type: " + r114);
        return;
    L53:
        r114 = null;
        goto L55
    L118:
        if ((r111 instanceof com.ss.ugc.live.sdk.msg.utils.g.b) == false) goto L121;
        E r132 = ((com.ss.ugc.live.sdk.msg.utils.g.b) r111).f458478b;
        com.ss.ugc.live.sdk.msg.utils.a.c(this.f24277z, "ws payload decode failed due to " + r132.getMessage());
        return;
    L121:
        throw new NoWhenBranchMatchedException();
    }

    public final void f(String r100) {
        com.ss.ugc.live.sdk.msg.utils.a.c(this.f24277z, "disconnect ws due to ".concat(r100));
        WSState r101 = this.A;
        r101.getClass();
        Intrinsics.checkNotNullParameter(r100, "reason");
        r101.f458283b = null;
        com.ss.ugc.live.sdk.msg.network.k r102 = r101.f458282a;
        if (r102 == null) goto L5;
        r102.disconnect();
    L5:
        r101.f458282a = null;
        r101.f458285d.d(new WSState.a.c(r100));
    }

    public final void g(com.ss.ugc.live.sdk.msg.data.a r100) {
        List<tlc.d> r101 = r100.f458233e;
        List<tlc.d> r102 = r101;
        if (r102 != null) goto L5;
    L8:
        boolean r103 = true;
    L9:
        if (r103 == false) goto L11;
        return;
    L11:
        ArrayList r104 = new ArrayList();
        Iterator<T> r105 = r101.iterator();
    L13:
        if (r105.hasNext() == false) goto L17;
        Object r106 = r105.next();
        if (((tlc.d) r106).needMonitor() == false) goto L13;
        r104.add(r106);
        goto L13
    L17:
        ArrayList r107 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r104, 10));
        Iterator r108 = r104.iterator();
    L19:
        if (r108.hasNext() == false) goto L21;
        r107.add(Long.valueOf(((tlc.d) r108.next()).getMessageId()));
        goto L19
    L21:
        ((ArrayList) this.f24274w).addAll(r107);
        com.ss.ugc.live.sdk.msg.dispatch.e r109 = this.f24277z.f458205b;
        if (r109 != null) goto L24;
        Intrinsics.throwUninitializedPropertyAccessException("messageConsumer");
    L24:
        r109.c(r101);
        return;
    L5:
        if (r102.isEmpty() == true) goto L8;
        r103 = false;
        goto L9
    }

    public final void l(Throwable r100) {
        com.ss.ugc.live.sdk.msg.utils.a.c(this.f24277z, "onApiError: " + r100.getMessage());
        this.f24270s = false;
        this.f24271t = this.f24271t + 1;
        if ((r100 instanceof HttpException) == true) goto L5;
    L11:
        this.f24263l = -1;
        this.f24264m = 0;
        this.f24265n = 0;
        if (this.f24253b == false) goto L32;
        long r101 = this.f24262k;
        if (r101 > 0) goto L17;
        r101 = 1000;
    L17:
        int r102 = this.f24272u;
        if (r102 <= 0) goto L27;
        long r103 = r101 * ((long) Math.pow(2.0d, r102));
        g r104 = this.B;
        if ((r104 instanceof amc.h) == true) goto L22;
        r104 = null;
    L22:
        amc.h r105 = (amc.h) r104;
        if (r105 == null) goto L25;
        long r106 = r105.n();
    L26:
        long r107 = Math.min(r103, r106);
    L31:
        n(r107);
        return;
    L25:
        r106 = KtvSingChallengeViewModel.CHALLENGE_ON_GOING_INTERVAL;
        goto L26
    L27:
        int r108 = this.f24271t;
        if (r108 <= 3) goto L30;
        r107 = 5000;
        goto L31
    L30:
        r107 = ((long) r108) * ((long) 1000);
        goto L31
    L32:
        q("0");
        return;
    L5:
        if (((HttpException) r100).getCode() != 503) goto L7;
        boolean r109 = true;
    L8:
        if (r109 == false) goto L10;
        this.f24272u++;
        JSONObject r110 = new JSONObject();
        JSONObject r111 = new JSONObject();
        r111.put("server_limit_count", this.f24272u);
        this.f24277z.e("message_server_limit_trigger", r110, r111, new JSONObject());
        goto L11
    L10:
        this.f24272u = 0;
        goto L11
    L7:
        r109 = false;
        goto L8
    }

    public final void n(long r100) {
        if (k() == true) goto L6;
        return;
    L6:
        if (this.A.c() == false) goto L9;
        return;
    L9:
        if (this.f24258g.hasMessages(DataLoaderHelper.DATALOADER_KEY_INT_CUR_DISK_SIZE_MB) == false) goto L11;
        return;
    L11:
        if (this.f24258g.hasMessages(DataLoaderHelper.DATALOADER_KEY_INT_DEV_MEMORY_SIZE_MB) == true) goto L16;
        c();
        com.ss.ugc.live.sdk.msg.utils.a.c(this.f24277z, "redetermineMessageFetchStrategy, delay: " + r100);
        this.f24258g.sendEmptyMessageDelayed(DataLoaderHelper.DATALOADER_KEY_INT_DEV_MEMORY_SIZE_MB, r100);
        return;
    }

    public final void p(long r100) {
        if (k() == true) goto L5;
        return;
    L5:
        com.ss.ugc.live.sdk.msg.utils.a.c(this.f24277z, "trigger ws fallback timer");
        c();
        Message r101 = this.f24258g.obtainMessage(2111);
        this.f24258g.sendMessageDelayed(r101, Math.max(1000, r100));
    }

    public final void q(String r100) {
        if (k() == true) goto L6;
        return;
    L6:
        if (this.A.c() == false) goto L9;
        return;
    L9:
        if (this.f24258g.hasMessages(DataLoaderHelper.DATALOADER_KEY_INT_CUR_DISK_SIZE_MB) == false) goto L11;
        return;
    L11:
        if (this.f24258g.hasMessages(DataLoaderHelper.DATALOADER_KEY_INT_DEV_MEMORY_SIZE_MB) == true) goto L30;
        com.ss.ugc.live.sdk.msg.utils.a.c(this.f24277z, "start next fetch with rule ".concat(r100));
        long r101 = this.f24262k;
        if (r101 > 0) goto L17;
        r101 = 1000;
    L17:
        int r102 = this.f24272u;
        if (r102 <= 0) goto L27;
        long r103 = r101 * ((long) Math.pow(2.0d, r102));
        g r104 = this.B;
        if ((r104 instanceof amc.h) == true) goto L22;
        r104 = null;
    L22:
        amc.h r105 = (amc.h) r104;
        if (r105 == null) goto L25;
        long r106 = r105.n();
    L26:
        r101 = Math.min(r103, r106);
        goto L27
    L25:
        r106 = KtvSingChallengeViewModel.CHALLENGE_ON_GOING_INTERVAL;
    L27:
        this.f24258g.sendMessageDelayed(this.f24258g.obtainMessage(DataLoaderHelper.DATALOADER_KEY_INT_CUR_DISK_SIZE_MB, r100), r101);
        return;
    }

    public final void m(com.ss.ugc.live.sdk.msg.data.a r110, boolean r111) {
        SdkResponse r100 = r110.f458232d;
        com.ss.ugc.live.sdk.msg.network.g r101 = r110.f458229a;
        List<com.ss.ugc.live.sdk.msg.network.d> r102 = null;
        if (r101 == null) goto L5;
        List<com.ss.ugc.live.sdk.msg.network.d> r103 = r101.f458313c;
    L9:
        int r104 = com.ss.ugc.live.sdk.msg.utils.c.f458473a;
        if (r103 == null) goto L21;
        Iterator<T> r105 = r103.iterator();
    L13:
        if (r105.hasNext() == false) goto L17;
        Object r106 = r105.next();
        if (StringsKt.equals("im-live_cursor", ((com.ss.ugc.live.sdk.msg.network.d) r106).f458296a, true) == false) goto L13;
    L18:
        com.ss.ugc.live.sdk.msg.network.d r107 = (com.ss.ugc.live.sdk.msg.network.d) r106;
        if (r107 == null) goto L21;
        String r108 = r107.f458297b;
    L22:
        if (r108 != null) goto L25;
        r108 = r110.f458232d.live_cursor;
    L25:
        String r109 = "";
        if (r108 != null) goto L30;
        r108 = "";
    L30:
        if (TextUtils.isEmpty(r108) == true) goto L32;
        D = r108;
    L32:
        com.ss.ugc.live.sdk.msg.network.g r112 = r110.f458229a;
        if (r112 == null) goto L35;
        List<com.ss.ugc.live.sdk.msg.network.d> r113 = r112.f458313c;
    L39:
        int r114 = com.ss.ugc.live.sdk.msg.utils.c.f458473a;
        if (r113 == null) goto L51;
        Iterator<T> r115 = r113.iterator();
    L43:
        if (r115.hasNext() == false) goto L47;
        Object r116 = r115.next();
        if (StringsKt.equals("im-wrds_preload_ext", ((com.ss.ugc.live.sdk.msg.network.d) r116).f458296a, true) == false) goto L43;
    L48:
        com.ss.ugc.live.sdk.msg.network.d r117 = (com.ss.ugc.live.sdk.msg.network.d) r116;
        if (r117 == null) goto L51;
        String r118 = r117.f458297b;
    L52:
        if (r118 != null) goto L56;
        r118 = "";
    L56:
        if (TextUtils.isEmpty(r118) == true) goto L58;
        E = r118;
    L58:
        String r119 = r110.a();
        if (r119 != null) goto L62;
        r119 = "";
    L62:
        this.f24261j = r119;
        Long r120 = r100.fetch_interval;
        if (r120 == null) goto L65;
        long r121 = r120.longValue();
    L66:
        this.f24262k = r121;
        com.ss.ugc.live.sdk.msg.network.g r122 = r110.f458229a;
        if (r122 == null) goto L69;
        r102 = r122.f458313c;
    L72:
        Long r123 = r110.f458232d.now;
        if (r123 == null) goto L75;
        long r124 = r123.longValue();
    L76:
        Long r125 = com.ss.ugc.live.sdk.msg.utils.c.e(r102);
        if (r125 == null) goto L79;
        r124 = r125.longValue();
    L79:
        this.f24267p = r124;
        String r126 = r110.b();
        if (r126 == null) goto L82;
        r109 = r126;
    L82:
        this.f24260i = r109;
        o r127 = amc.a.a(this.B);
        if (r127 != null) goto L85;
    L95:
        long r128 = 0;
        if (r110.f458231c == true) goto L98;
    L108:
        List<SdkMessage> r129 = r100.messages;
        if (r129 == null) goto L111;
        long r130 = r129.size();
    L112:
        this.f24264m = r130;
        this.f24265n = r110.f458233e.size();
        Long r131 = r100.heartbeat_duration;
        if (r131 == null) goto L115;
        r128 = r131.longValue();
    L115:
        this.f24269r = Math.max(10, r128);
        com.ss.ugc.live.sdk.msg.utils.a.a(this.f24277z, "process common response, cursor: " + this.f24261j + ", live_cursor: " + r108 + ", next use live_cursor:" + D);
        return;
    L111:
        r130 = 0;
        goto L112
    L98:
        if (this.f24277z.f458213j.f() == true) goto L102;
        String r132 = r110.a();
        if (r132 == null) goto L102;
        com.ss.ugc.live.sdk.msg.c r133 = this.f24277z;
        r133.getClass();
        Intrinsics.checkNotNullParameter(r132, "<set-?>");
        r133.f458206c = r132;
    L102:
        Boolean r134 = r110.f458232d.history_no_more;
        if (r134 == null) goto L106;
        this.f24277z.f458207d = !r134.booleanValue();
    L106:
        if (this.f24266o <= 0) goto L108;
        long r135 = System.currentTimeMillis() - this.f24266o;
        JSONObject r136 = new JSONObject();
        r136.put("direct_connect_ws", this.f24256e);
        r136.put("ws_received", r111);
        JSONObject r137 = new JSONObject();
        r137.put("use_time", r135);
        this.f24277z.e("receive_first_im_message_cost", r136, r137, new JSONObject());
        goto L108
    L85:
        if (r127.f() != true) goto L95;
        String r138 = r110.f458232d.proxy_server;
        if (r138 != null) goto L89;
    L92:
        boolean r139 = true;
    L93:
        if (r139 == true) goto L95;
        r127.g(r138);
        goto L95
    L89:
        if (r138.length() == 0) goto L92;
        r139 = false;
        goto L93
    L75:
        r124 = System.currentTimeMillis();
        goto L76
    L69:
        f r140 = r110.f458230b;
        if (r140 == null) goto L72;
        r102 = r140.f546765f;
        goto L72
    L65:
        r121 = 1000;
        goto L66
    L47:
        r116 = null;
    L51:
        r118 = null;
        goto L52
    L35:
        f r141 = r110.f458230b;
        if (r141 == null) goto L38;
        r113 = r141.f546765f;
        goto L39
    L38:
        r113 = null;
        goto L39
    L17:
        r106 = null;
    L21:
        r108 = null;
        goto L22
    L5:
        f r142 = r110.f458230b;
        if (r142 == null) goto L8;
        r103 = r142.f546765f;
        goto L9
    L8:
        r103 = null;
        goto L9
    }

    /* JADX WARN: Multi-variable type inference failed */
    public a(com.ss.ugc.live.sdk.msg.c r100, WSState r101, g r102, List<? extends bmc.a> r103) {
        Intrinsics.checkNotNullParameter(r100, "messageContext");
        Intrinsics.checkNotNullParameter(r101, "wsState");
        Intrinsics.checkNotNullParameter(r102, "config");
        Intrinsics.checkNotNullParameter(r103, com.bytedance.android.livesdk.gift.model.n.KEY_PLUGINS);
        this.f24277z = r100;
        this.A = r101;
        this.B = r102;
        this.C = r103;
        this.f24252a = r102.d();
        this.f24253b = r102.b();
        this.f24254c = new bmc.b(r102.h(), r103);
        amc.d r104 = r102.l();
        if (r104 != null) goto L6;
        r104 = new com.ss.ugc.live.sdk.msg.network.c();
    L6:
        this.f24255d = r104;
        if (r102.i() == true) goto L9;
    L11:
        boolean r105 = false;
    L12:
        this.f24256e = r105;
        this.f24258g = new c(this, Looper.getMainLooper());
        this.f24259h = new d(this, Looper.getMainLooper());
        this.f24260i = "";
        this.f24261j = "0";
        this.f24262k = 1000;
        this.f24269r = 10;
        this.f24273v = new j(this);
        this.f24274w = new ArrayList();
        this.f24275x = new AtomicLong(0);
        return;
    L9:
        if (TextUtils.isEmpty(r102.g()) == true) goto L11;
        r105 = true;
        goto L12
    }
}
