package com.bytedance.ai.utils;

import androidx.collection.LruCache;
import java.util.List;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public final class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final LruCache<Long, a> f37639a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final LruCache<String, a> f37640b = null;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Long f37641a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Long f37642b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final String f37643c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final String f37644d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public String f37645e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final long f37646f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public Map<String, Object> f37647g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public int f37648h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public b f37649i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public final c f37650j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public final c f37651k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public final c f37652l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public final c f37653m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public final c f37654n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public final c f37655o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        public final c f37656p;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        public final c f37657q;

        /* JADX INFO: renamed from: r, reason: collision with root package name */
        public final c f37658r;

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        public final c f37659s;

        /* JADX INFO: renamed from: t, reason: collision with root package name */
        public final c f37660t;

        /* JADX INFO: renamed from: u, reason: collision with root package name */
        public final c f37661u;

        /* JADX INFO: renamed from: v, reason: collision with root package name */
        public final c f37662v;

        /* JADX INFO: renamed from: w, reason: collision with root package name */
        public final List<c> f37663w;

        public a() {
            this(null, null, null, null, 63);
        }

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof a) == true) goto L8;
            return false;
        L8:
            a r101 = (a) r100;
            if (Intrinsics.areEqual(this.f37641a, r101.f37641a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f37642b, r101.f37642b) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.f37643c, r101.f37643c) == true) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.f37644d, r101.f37644d) == true) goto L21;
            return false;
        L21:
            if (Intrinsics.areEqual(this.f37645e, r101.f37645e) == true) goto L24;
            return false;
        L24:
            if (this.f37646f == r101.f37646f) goto L26;
            return false;
        L26:
            return true;
        }

        public final int hashCode() {
            Long r100 = this.f37641a;
            int r101 = 0;
            if (r100 != null) goto L5;
            int r102 = 0;
        L6:
            int r103 = r102 * 31;
            Long r104 = this.f37642b;
            if (r104 != null) goto L9;
            int r105 = 0;
        L10:
            int r106 = (r103 + r105) * 31;
            String r107 = this.f37643c;
            if (r107 != null) goto L13;
            int r108 = 0;
        L14:
            int r109 = (r106 + r108) * 31;
            String r110 = this.f37644d;
            if (r110 != null) goto L17;
            int r111 = 0;
        L18:
            int r112 = (r109 + r111) * 31;
            String r113 = this.f37645e;
            if (r113 == null) goto L22;
            r101 = r113.hashCode();
        L22:
            int r114 = (r112 + r101) * 31;
            long r115 = this.f37646f;
            return r114 + ((int) (r115 ^ (r115 >>> 32)));
        L17:
            r111 = r110.hashCode();
            goto L18
        L13:
            r108 = r107.hashCode();
            goto L14
        L9:
            r105 = r104.hashCode();
            goto L10
        L5:
            r102 = r100.hashCode();
            goto L6
        }

        public final String toString() {
            return "Context(messageId=" + this.f37641a + ", questionId=" + this.f37642b + ", apiName=" + this.f37643c + ", appletId=" + this.f37644d + ", callbackId=" + this.f37645e + ", received=" + this.f37646f + ')';
        }

        public final void a(String r100) {
            Intrinsics.checkNotNullParameter(r100, "msg");
            this.f37649i = new b.c(r100);
        }

        public final synchronized void b(Pair<String, ? extends Object>... r100) {
            monitor-enter(this);
            Intrinsics.checkNotNullParameter(r100, "params");     // Catch: Throwable -> L12
            Map<String, Object> r101 = this.f37647g;     // Catch: Throwable -> L12
            int r102 = 0;
            if (r101 != null) goto L6;
            r101 = MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("runtime_type", "client_tool")});     // Catch: Throwable -> L12
            this.f37647g = r101;     // Catch: Throwable -> L12
        L6:
            int r103 = r100.length;     // Catch: Throwable -> L12
        L7:
            if (r102 >= r103) goto L10;
            Pair<String, ? extends Object> r104 = r100[r102];     // Catch: Throwable -> L12
            r101.put(r104.getFirst(), r104.getSecond());     // Catch: Throwable -> L12
            r102 = r102 + 1;
            goto L7
        L10:
            monitor-exit(this);
            return;
        L12:
            th = move-exception;
            throw th;
        }

        public a(Long r110, Long r111, String r112, String r210, int r211) {
            if ((r211 & 1) == 0) goto L5;
            Long r100 = null;
        L7:
            if ((r211 & 2) == 0) goto L9;
            Long r101 = null;
        L11:
            if ((r211 & 4) == 0) goto L13;
            String r102 = null;
        L15:
            if ((r211 & 8) == 0) goto L17;
            String r103 = null;
        L19:
            if ((r211 & 32) == 0) goto L21;
            long r104 = System.currentTimeMillis();
        L22:
            this.f37641a = r100;
            this.f37642b = r101;
            this.f37643c = r102;
            this.f37644d = r103;
            this.f37645e = null;
            this.f37646f = r104;
            this.f37648h = 1;
            this.f37649i = b.d.f37668c;
            c r105 = new c("appActionListenerBegin", "listener_begin", "app action listener begin");
            this.f37650j = r105;
            c r106 = new c("appletRuntimeManagerBegin", "manager_begin", "applet runtime manager begin");
            this.f37651k = r106;
            c r107 = new c("appletRuntimeManagerBeforeRunApplet", "run_applet_begin", "applet runtime manager before run applet");
            this.f37652l = r107;
            c r108 = new c("appletRuntimeBegin", "runtime_begin", "applet runtime begin");
            this.f37653m = r108;
            c r109 = new c("appletRuntimeSendMessage", "send_message", "applet runtime send message");
            this.f37654n = r109;
            c r113 = new c("appletRuntimeProcessMessage", "process_message", "applet runtime process message");
            this.f37655o = r113;
            c r114 = new c("appletRuntimeProcessMessageEnd", "process_message_end", "applet runtime process message end");
            this.f37656p = r114;
            c r115 = new c("createWidget", "create_widget", "create widget");
            c r116 = new c("createText", "create_text", "create text");
            c r117 = new c("replyLocalPlugin", "reply_local_plugin", "reply local plugin");
            this.f37657q = r117;
            c r118 = new c("replyLocalPluginProcessInMain", "reply_local_plugin_in_main", "reply local plugin in main");
            this.f37658r = r118;
            c r119 = new c("reportAck", "report_ack", "report ack");
            this.f37659s = r119;
            c r120 = new c("sendAckBegin", "send_ack_begin", "send ack begin");
            this.f37660t = r120;
            c r121 = new c("sendAckEnd", "send_ack_end", "send ack end");
            this.f37661u = r121;
            c r122 = new c("sendAckRealFinished", "send_ack_real_finished", "send ack real finished");
            this.f37662v = r122;
            this.f37663w = CollectionsKt.listOf(new c[]{r105, r106, r107, r108, r109, r113, r114, r115, r116, r117, r118, r119, r120, r122, r121});
            return;
        L21:
            r104 = 0;
            goto L22
        L17:
            r103 = r210;
            goto L19
        L13:
            r102 = r112;
            goto L15
        L9:
            r101 = r111;
            goto L11
        L5:
            r100 = r110;
            goto L7
        }
    }

    public static abstract class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f37664a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f37665b;

        public static final class a {
        }

        /* JADX INFO: renamed from: com.bytedance.ai.utils.j$b$b, reason: collision with other inner class name */
        public static final class C0715b extends b {

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public final String f37666c;

            @Override // com.bytedance.ai.utils.j.b
            public final String a() {
                return this.f37666c;
            }

            public C0715b(String r100) {
                Intrinsics.checkNotNullParameter(r100, "errorMsg");
                super(103, r100);
                this.f37666c = r100;
            }
        }

        public static final class c extends b {

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public final String f37667c;

            @Override // com.bytedance.ai.utils.j.b
            public final String a() {
                return this.f37667c;
            }

            public c(String r100) {
                Intrinsics.checkNotNullParameter(r100, "errorMsg");
                super(102, r100);
                this.f37667c = r100;
            }
        }

        public static final class d extends b {

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public static final d f37668c = null;

            static {
                f37668c = new d();
            }

            public d() {
                super(0, "Succeed");
            }
        }

        public static final class e extends b {

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public final String f37669c;

            public e() {
                Intrinsics.checkNotNullParameter("Local Plugin Timeout", "errorMsg");
                super(101, "Local Plugin Timeout");
                this.f37669c = "Local Plugin Timeout";
            }

            @Override // com.bytedance.ai.utils.j.b
            public final String a() {
                return this.f37669c;
            }
        }

        static {
        }

        public String a() {
            return this.f37665b;
        }

        public b(int r100, String r101) {
            this.f37664a = r100;
            this.f37665b = r101;
        }
    }

    public static final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f37670a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f37671b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final String f37672c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public Long f37673d;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof c) == true) goto L8;
            return false;
        L8:
            c r101 = (c) r100;
            if (Intrinsics.areEqual(this.f37670a, r101.f37670a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f37671b, r101.f37671b) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.f37672c, r101.f37672c) == true) goto L17;
            return false;
        L17:
            return true;
        }

        public final int hashCode() {
            return (((this.f37670a.hashCode() * 31) + this.f37671b.hashCode()) * 31) + this.f37672c.hashCode();
        }

        public final String toString() {
            return "LocalPluginMonitorInfo(tag=" + this.f37670a + ", monitorKey=" + this.f37671b + ", des=" + this.f37672c + ')';
        }

        public final void a() {
            this.f37673d = Long.valueOf(System.currentTimeMillis());
            g.f37637a.d("LocalPluginPerformanceManager", "timeline " + this.f37670a + " start");
        }

        public c(String r100, String r101, String r102) {
            Intrinsics.checkNotNullParameter(r100, "tag");
            Intrinsics.checkNotNullParameter(r101, "monitorKey");
            Intrinsics.checkNotNullParameter(r102, "des");
            this.f37670a = r100;
            this.f37671b = r101;
            this.f37672c = r102;
        }
    }

    static {
        f37639a = new LruCache(10);
        f37640b = new LruCache(10);
    }

    public static a b(Long r100) {
        if (r100 == null) goto L5;
        r100.longValue();
        return f37639a.get(r100);
    L5:
        return null;
    }

    public static long a(Long r100, Long r101) {
        if (r100 == null) goto L8;
        long r102 = r100.longValue();
        if (r101 == null) goto L6;
        long r103 = r101.longValue();
    L10:
        return r102 - r103;
    L6:
        r103 = r102;
        goto L10
    L8:
        return 0;
    }

    public static String c(String r100, long r101, long r102) {
        return r100 + " cost: " + r101 + " ms " + ((r101 * 100.0d) / r102) + '%';
    }
}
