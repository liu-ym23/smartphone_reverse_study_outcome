package com.bytedance.android.sdk.bdticketguard.init;

import com.ss.android.ugc.aweme.shortvideo.ShortVideoSegments;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static volatile a f163785a;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final long f163786a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final long f163787b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final long f163788c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final long f163789d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final long f163790e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final long f163791f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final Map<String, Long> f163792g;

        public a() {
            this(0);
        }

        public final boolean equals(Object r100) {
            if (this != r100) goto L5;
        L40:
            return true;
        L5:
            if ((r100 instanceof a) == false) goto L39;
            a r101 = (a) r100;
            if (this.f163786a != r101.f163786a) goto L9;
            boolean r102 = true;
        L10:
            if (r102 == false) goto L39;
            if (this.f163787b != r101.f163787b) goto L14;
            boolean r103 = true;
        L15:
            if (r103 == false) goto L39;
            if (this.f163788c != r101.f163788c) goto L19;
            boolean r104 = true;
        L20:
            if (r104 == false) goto L39;
            if (this.f163789d != r101.f163789d) goto L24;
            boolean r105 = true;
        L25:
            if (r105 == false) goto L39;
            if (this.f163790e != r101.f163790e) goto L29;
            boolean r106 = true;
        L30:
            if (r106 == false) goto L39;
            if (this.f163791f != r101.f163791f) goto L34;
            boolean r107 = true;
        L35:
            if (r107 == false) goto L39;
            if (Intrinsics.areEqual(this.f163792g, r101.f163792g) == false) goto L39;
        L34:
            r107 = false;
            goto L35
        L29:
            r106 = false;
            goto L30
        L24:
            r105 = false;
            goto L25
        L19:
            r104 = false;
            goto L20
        L14:
            r103 = false;
            goto L15
        L9:
            r102 = false;
        L39:
            return false;
        }

        public final int hashCode() {
            long r100 = this.f163786a;
            int r101 = ((int) (r100 ^ (r100 >>> 32))) * 31;
            long r102 = this.f163787b;
            int r103 = (r101 + ((int) (r102 ^ (r102 >>> 32)))) * 31;
            long r104 = this.f163788c;
            int r105 = (r103 + ((int) (r104 ^ (r104 >>> 32)))) * 31;
            long r106 = this.f163789d;
            int r107 = (r105 + ((int) (r106 ^ (r106 >>> 32)))) * 31;
            long r108 = this.f163790e;
            int r109 = (r107 + ((int) (r108 ^ (r108 >>> 32)))) * 31;
            long r110 = this.f163791f;
            int r111 = (r109 + ((int) (r110 ^ (r110 >>> 32)))) * 31;
            Map<String, Long> r112 = this.f163792g;
            if (r112 == null) goto L5;
            int r113 = r112.hashCode();
        L7:
            return r111 + r113;
        L5:
            r113 = 0;
            goto L7
        }

        public final String toString() {
            return "TimePoints(providedAppStartTime=" + j.c(this.f163786a) + ", providerOnCreateTime=" + j.c(this.f163787b) + ", tokenManagerInitTime=" + j.c(this.f163788c) + ", initFinishTime=" + j.c(this.f163789d) + ", preInitTime=" + j.c(this.f163790e) + ", ticketSdkInitTime=" + j.c(this.f163791f) + ", taskDurations=" + this.f163792g + ")";
        }

        public a(int r110) {
            int r111 = j.f163793b;
            this(0, 0, 0, 0, 0, 0, new ConcurrentHashMap());
        }

        public a(long r100, long r101, long r102, long r103, long r104, long r110, Map<String, Long> r111) {
            this.f163786a = r100;
            this.f163787b = r101;
            this.f163788c = r102;
            this.f163789d = r103;
            this.f163790e = r104;
            this.f163791f = r110;
            this.f163792g = r111;
        }

        public static a a(a r110, long r111, long r210, long r211, long r212, long r213, int r214) {
            if ((r214 & 1) == 0) goto L5;
            long r100 = r110.f163786a;
        L6:
            long r101 = r100;
            if ((r214 & 2) == 0) goto L9;
            long r102 = r110.f163787b;
        L11:
            if ((r214 & 4) == 0) goto L13;
            long r103 = r110.f163788c;
        L15:
            if ((r214 & 8) == 0) goto L17;
            long r112 = r110.f163789d;
        L19:
            if ((r214 & 16) == 0) goto L21;
            long r113 = r110.f163790e;
        L23:
            if ((r214 & 32) == 0) goto L25;
            long r114 = r110.f163791f;
        L27:
            if ((r214 & 64) == 0) goto L29;
            Map<String, Long> r104 = r110.f163792g;
        L30:
            r110.getClass();
            return new a(r101, r102, r103, r112, r113, r114, r104);
        L29:
            r104 = null;
            goto L30
        L25:
            r114 = r213;
            goto L27
        L21:
            r113 = r212;
            goto L23
        L17:
            r112 = r211;
            goto L19
        L13:
            r103 = r210;
            goto L15
        L9:
            r102 = r111;
            goto L11
        L5:
            r100 = 0;
            goto L6
        }
    }

    static {
        f163785a = new a(0);
    }

    @JvmStatic
    public static final Map<String, Object> a() {
        if (j.a(f163785a.f163786a) == false) goto L5;
        Pair r100 = TuplesKt.to(new j(f163785a.f163786a), "provided");
    L6:
        long r101 = ((j) r100.component1()).f163794a;
        Map<String, Object> r102 = MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("sdk_init_time", Long.valueOf(j.b(f163785a.f163788c, f163785a.f163789d))), TuplesKt.to("app_start_init_time", Long.valueOf(j.b(r101, f163785a.f163789d))), TuplesKt.to("ticket_init_time", Long.valueOf(j.b(f163785a.f163791f, f163785a.f163789d))), TuplesKt.to("app_create_time_source", (String) r100.component2()), TuplesKt.to("app_create_to_ticket_init_time", Long.valueOf(j.b(r101, f163785a.f163791f))), TuplesKt.to("app_create_to_token_init_time", Long.valueOf(j.b(r101, f163785a.f163788c))), TuplesKt.to("app_create_to_token_preinit_time", Long.valueOf(j.b(r101, f163785a.f163790e))), TuplesKt.to("token_init_to_ticket_sdk_init_time", Long.valueOf(j.b(f163785a.f163788c, f163785a.f163791f)))});
        Iterator<Map.Entry<String, Long>> r103 = f163785a.f163792g.entrySet().iterator();
    L8:
        if (r103.hasNext() == false) goto L10;
        Map.Entry<String, Long> r104 = r103.next();
        r102.put(r104.getKey() + "_init_duration", Long.valueOf(r104.getValue().longValue()));
        goto L8
    L10:
        TicketInitTaskManager.f163767h.getClass();
        Iterator r105 = MapsKt.toMap(TicketInitTaskManager.f163761b).entrySet().iterator();
    L12:
        if (r105.hasNext() == false) goto L14;
        Map.Entry r106 = (Map.Entry) r105.next();
        r102.put(((InitTask) r106.getKey()) + "_init_state", ((c) r106.getValue()).toString());
        goto L12
    L14:
        return r102;
    L5:
        r100 = TuplesKt.to(new j(f163785a.f163787b), ShortVideoSegments.KEY_PROP_PROVIDER);
        goto L6
    }

    @JvmStatic
    public static final void b() {
        if (j.a(f163785a.f163788c) == true) goto L6;
        f163785a = a.a(f163785a, 0, System.currentTimeMillis(), 0, 0, 0, 123);
        return;
    }
}
