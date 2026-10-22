package com.bytedance.crash.g;

import android.os.Build;
import android.os.Looper;
import android.os.Message;
import android.os.MessageQueue;
import android.os.SystemClock;
import com.bytedance.bdturing.localstorage.DbHelper;
import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.crash.o.l;
import com.bytedance.crash.runtime.DefaultWorkThread;
import com.bytedance.security.zenmobile.io.SensitiveType;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.File;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: LooperMessageManager.java */
/* JADX INFO: loaded from: classes.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private volatile c f7461a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private volatile a f7462b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private long f7463c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private long f7464d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private long f7465e;
    private boolean f;
    private JSONArray g;
    private final Runnable h;

    /* JADX INFO: compiled from: LooperMessageManager.java */
    private interface a {
        a a(Message r1, long r2, long r4, long r6);
    }

    /* JADX INFO: renamed from: com.bytedance.crash.g.b$b, reason: collision with other inner class name */
    /* JADX INFO: compiled from: LooperMessageManager.java */
    private static class C0164b implements a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private File f7467a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private e f7468b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final JSONObject f7469c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private boolean f7470d;

        private C0164b() {
            this.f7469c = new JSONObject();
        }

        /* synthetic */ C0164b(AnonymousClass1 r1) {
            this();
        }

        static /* synthetic */ void a(C0164b r0) {
            r0.c();
        }

        static /* synthetic */ void a(C0164b r0, File r1, long r2, boolean r4) {
            r0.a(r1, r2, r4);
        }

        @Override // com.bytedance.crash.g.b.a
        public a a(Message r3, long r4, long r6, long r8) {
            AnonymousClass1 r1 = null;
            e r0 = new e(r1);
            this.f7468b = r0;
            r0.b(r4, r6);
            this.f7468b.b(r3, r8);
            a();
            if (this.f7470d == false) goto L5;
            return null;
        L5:
            return new d(r1);
        }

        private void a(File r5, long r6, boolean r8) {
            JSONObject r0 = this.f7469c;
            monitor-enter(r0);
            JSONObject r1 = this.f7469c.optJSONObject("current_message");     // Catch: Throwable -> L13 JSONException -> L19
            if (r1 != null) goto L11;
            r1 = new JSONObject();     // Catch: Throwable -> L13 JSONException -> L19
            this.f7469c.put("current_message", r1);     // Catch: Throwable -> L13 JSONException -> L19
            if (r8 == false) goto L9;
            String r9 = "message is running";
        L10:
            r1.put("message", r9);     // Catch: Throwable -> L13 JSONException -> L19
            goto L11
        L9:
            r9 = "no message running";
        L11:
            r1.put("currentMessageCost", r6);     // Catch: Throwable -> L13 JSONException -> L19
            r1.put("currentMessageCpu", -1);     // Catch: Throwable -> L13 JSONException -> L19
            this.f7467a = r5;     // Catch: Throwable -> L13 JSONException -> L19
            b();     // Catch: Throwable -> L13 JSONException -> L19
        L13:
            th = move-exception;
            throw th;
        L15:
            monitor-exit(r0);     // Catch: Throwable -> L13
        }

        private void a() {
            JSONObject r0 = this.f7469c;
            monitor-enter(r0);
            JSONObject r1 = (JSONObject) ZeusTransformUtils.preCheckCast(this.f7469c.opt("current_message"), JSONObject.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L9 JSONException -> L15
            if (r1 != null) goto L7;
            r1 = new JSONObject();     // Catch: Throwable -> L9 JSONException -> L15
            this.f7469c.put("current_message", r1);     // Catch: Throwable -> L9 JSONException -> L15
        L7:
            r1.put("message", this.f7468b.b());     // Catch: Throwable -> L9 JSONException -> L15
            r1.put("currentMessageLastCost", this.f7468b.f7479a);     // Catch: Throwable -> L9 JSONException -> L15
            r1.put("currentMessageLastCpu", this.f7468b.f7480b);     // Catch: Throwable -> L9 JSONException -> L15
            b();     // Catch: Throwable -> L9 JSONException -> L15
        L9:
            th = move-exception;
            throw th;
        L11:
            monitor-exit(r0);     // Catch: Throwable -> L9
        }

        private void b() {
            File r0 = this.f7467a;
            if (r0 == null) goto L6;
            com.bytedance.crash.o.j.a(com.bytedance.crash.g.a.a(r0), this.f7469c, false);
            return;
        }

        private void c() {
            this.f7470d = true;
        }
    }

    /* JADX INFO: compiled from: LooperMessageManager.java */
    private static class c implements a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final a f7471a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final C0165b f7472b;

        /* JADX INFO: compiled from: LooperMessageManager.java */
        private static class a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private final i[] f7473a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            private final int f7474b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            private int f7475c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            private int f7476d;

            static /* synthetic */ i a(a r0) {
                return r0.b();
            }

            static /* synthetic */ i b(a r0) {
                return r0.c();
            }

            static /* synthetic */ i c(a r0) {
                return r0.a();
            }

            a(int r5) {
                this.f7473a = new i[r5];
                int r0 = 0;
            L3:
                if (r0 >= r5) goto L5;
                this.f7473a[r0] = new i(null);
                r0 = r0 + 1;
                goto L3
            L5:
                this.f7474b = r5;
                this.f7475c = -1;
            }

            private i a() {
                int r0 = this.f7475c + 1;
                this.f7475c = r0;
                if (r0 != this.f7474b) goto L6;
                this.f7475c = 0;
            L6:
                return this.f7473a[this.f7475c];
            }

            private i b() {
                int r0 = this.f7475c;
                if (r0 != (-1)) goto L6;
                return null;
            L6:
                int r1 = r0 + 1;
                this.f7476d = r1;
                if (r1 != this.f7474b) goto L9;
            L10:
                this.f7476d = 0;
            L12:
                return this.f7473a[this.f7476d];
            L9:
                if (this.f7473a[r1].f7479a != 0) goto L12;
                goto L10
            }

            private i c() {
                int r0 = this.f7476d + 1;
                this.f7476d = r0;
                if (r0 != (this.f7475c + 1)) goto L7;
                return null;
            L7:
                if (r0 != this.f7474b) goto L10;
                this.f7476d = 0;
            L10:
                return this.f7473a[this.f7476d];
            }
        }

        /* JADX INFO: renamed from: com.bytedance.crash.g.b$c$b, reason: collision with other inner class name */
        /* JADX INFO: compiled from: LooperMessageManager.java */
        private static class C0165b extends k {
            private final HashMap<String, g> h;
            private final h i;
            private final a j;
            private f k;

            static /* synthetic */ void a(C0165b r0, Message r1, long r2, long r4, long r6) {
                r0.b(r1, r2, r4, r6);
            }

            static /* synthetic */ void a(C0165b r0, boolean r1) {
                r0.a(r1);
            }

            C0165b(a r3, int r4) {
                AnonymousClass1 r0 = null;
                super(r0);
                this.h = new HashMap(r4);
                this.i = new h(r4, r0);
                this.j = r3;
            }

            @Override // com.bytedance.crash.g.b.k, com.bytedance.crash.g.b.f, com.bytedance.crash.g.b.e, com.bytedance.crash.g.b.j
            public void a() {
                super.a();
                this.k = null;
                Iterator<g> r0 = this.h.values().iterator();
            L4:
                if (r0.hasNext() == false) goto L8;
                g r1 = (g) ZeusTransformUtils.preCheckCast(r0.next(), g.class, "com.obric.aiagent.plugin");
                if (r1 == null) goto L4;
                h.a(this.i, r1);
                goto L4
            L8:
                this.h.clear();
            }

            private void a(boolean r5) {
                if (this.f7479a == 0) goto L5;
            L6:
                if (r5 == false) goto L8;
            L10:
                i r6 = a.c(this.j);
                r6.a();
                r6.f7481c = this.f7481c;
                r6.f7479a = this.f7479a;
                r6.f7480b = this.f7480b;
                r6.f = this.f;
                r6.a(this);
                r6.a(this.k);
                r6.a(this.k);
                a();
                return;
            L8:
                if (this.f7479a > 200) goto L10;
                return;
            L5:
                if (this.f7481c != 0) goto L6;
            }

            @Override // com.bytedance.crash.g.b.k
            public void a(long r3, long r5) {
                if (r3 <= 200) goto L5;
                a(true);
            L5:
                super.a(r3, r5);
                this.f7479a += r3;
                this.f7480b += r5;
                a(false);
            }

            private void a(Message r5, long r6, long r8, long r10) {
                this.f7481c++;
                if (this.f != Long.MAX_VALUE) goto L10;
                long r11 = a(r5, r10);
                if (r11 > 0) goto L10;
                if ((this.f7479a + r11) <= 0) goto L9;
                this.f = 0;
                goto L10
            L9:
                this.f = r11 + this.f7479a;
            L10:
                this.f7479a += r6;
                this.f7480b += r8;
            }

            private void b(Message r14, long r15, long r17, long r19) {
                if (r15 <= 200) goto L5;
                a(true);
            L5:
                String r1 = b(r14);
                g r3 = (g) ZeusTransformUtils.preCheckCast(this.h.get(r1), g.class, "com.obric.aiagent.plugin");
                if (r3 != null) goto L15;
                r3 = h.a(this.i);
                if (r3 != null) goto L13;
                a(true);
                g r2 = h.a(this.i);
                if (r2 != null) goto L12;
                return;
            L12:
                r3 = r2;
            L13:
                this.h.put(r1, r3);
                r3.b(r14, r19);
            L15:
                g r4 = r3;
                g.a(r4, r14, r15, r17, r19);
                a(r14, r15, r17, r19);
                if (this.k != null) goto L18;
            L19:
                this.k = r4;
            L20:
                a(false);
                return;
            L18:
                if (r4.f7479a <= this.k.f7479a) goto L20;
                goto L19
            }

            private String b(Message r1) {
                if (r1.getCallback() == null) goto L6;
                return r1.getCallback().getClass().getName();
            L6:
                if (r1.getTarget() != null) goto L11;
                return SensitiveType.UNKNOWN;
            L11:
                return r1.getTarget().getClass().getName();
            }
        }

        /* synthetic */ c(AnonymousClass1 r1) {
            this();
        }

        static /* synthetic */ void a(c r0, File r1, long r2, long r4, long r6, long r8) {
            r0.a(r1, r2, r4, r6, r8);
        }

        private c() {
            a r0 = new a(50);
            this.f7471a = r0;
            this.f7472b = new C0165b(r0, 30);
        }

        @Override // com.bytedance.crash.g.b.a
        public a a(Message r9, long r10, long r12, long r14) {
            if (r9 == null) goto L4;
            C0165b.a(this.f7472b, r9, r10, r12, r14);
        L5:
            return this;
        L4:
            this.f7472b.a(r10, r12);
            goto L5
        }

        private void a(File r4, long r5, long r7, long r9, long r11) {
            C0165b.a(this.f7472b, true);
            JSONArray r0 = new JSONArray();
            i r1 = a.a(this.f7471a);
        L3:
            if (r1 == null) goto L7;
            JSONObject r2 = new JSONObject();
            r1.a(r2);     // Catch: JSONException -> L11
            r0.put(r2);     // Catch: JSONException -> L11
        L6:
            r1 = a.b(this.f7471a);
            goto L3
        L7:
            JSONObject r3 = new JSONObject();
            r3.put("history_message", r0);     // Catch: JSONException -> L12
            JSONObject r6 = new JSONObject();     // Catch: JSONException -> L12
            r6.put("dump_wall_time", r5);     // Catch: JSONException -> L12
            r6.put("dump_up_time", r7);     // Catch: JSONException -> L12
            r6.put("last_wall_time", r9);     // Catch: JSONException -> L12
            r6.put("last_cpu_time", r11);     // Catch: JSONException -> L12
            r3.put("history_details", r6);     // Catch: JSONException -> L12
        L9:
            com.bytedance.crash.o.j.a(com.bytedance.crash.g.a.b(r4), r3, false);
        }
    }

    /* JADX INFO: compiled from: LooperMessageManager.java */
    private static class d implements a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final LinkedList<j> f7477a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private LinkedList<e> f7478b;

        private d() {
            this.f7477a = new LinkedList();
            this.f7478b = new LinkedList();
        }

        /* synthetic */ d(AnonymousClass1 r1) {
            this();
        }

        static /* synthetic */ void a(d r0, long r1) {
            r0.a(r1);
        }

        static /* synthetic */ void a(d r0, d r1) {
            r0.a(r1);
        }

        static /* synthetic */ void a(d r0, File r1) {
            r0.a(r1);
        }

        @Override // com.bytedance.crash.g.b.a
        public a a(Message r3, long r4, long r6, long r8) {
            if (r3 == null) goto L4;
            e r0 = new e(null);
            r0.b(r3, r8);
            r0.b(r4, r6);
            this.f7478b.add(r0);
        L4:
            return this;
        }

        private static MessageQueue a() {
            if (Looper.getMainLooper() == null) goto L12;
            Looper r0 = Looper.getMainLooper();
            if (r0 != Looper.myLooper()) goto L8;
            return Looper.myQueue();
        L8:
            if (Build.VERSION.SDK_INT >= 23) goto L18;
            Field r1 = r0.getClass().getDeclaredField("mQueue");     // Catch: Throwable -> L14
            r1.setAccessible(true);     // Catch: Throwable -> L14
            return (MessageQueue) ZeusTransformUtils.preCheckCast(r1.get(r0), MessageQueue.class, "com.obric.aiagent.plugin");
        L18:
            return r0.getQueue();
        L12:
            return null;
        }

        private static Field a(String r1, String r2) {
            Field r3 = ZeusTransformUtils.forName(r1, "com.obric.aiagent.plugin").getDeclaredField(r2);     // Catch: Exception -> L4
            r3.setAccessible(true);     // Catch: Exception -> L4
            return r3;
        L4:
            return null;
        }

        private static Object a(Field r0, Object r1) {
            return r0.get(r1);
        L4:
            return null;
        }

        private void a(long r7) {
            MessageQueue r0 = a();
            Field r1 = a("android.os.MessageQueue", "mMessages");
            Field r2 = a("android.os.Message", "next");
            if (r0 == null) goto L18;
            if (r1 == null) goto L26;
            if (r2 == null) goto L28;
            monitor-enter(r0);     // Catch: Throwable -> L19
            Message r3 = (Message) ZeusTransformUtils.preCheckCast(a(r1, r0), Message.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L15
            int r4 = 0;
        L9:
            if (r3 == null) goto L13;
            int r5 = r4 + 1;     // Catch: Throwable -> L15
            if (r4 >= 200) goto L13;
            j r6 = new j(null);     // Catch: Throwable -> L15
            r6.b(r3, r7);     // Catch: Throwable -> L15
            this.f7477a.add(r6);     // Catch: Throwable -> L15
            r3 = (Message) ZeusTransformUtils.preCheckCast(a(r2, r3), Message.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L15
            r4 = r5;
        L13:
            monitor-exit(r0);     // Catch: Throwable -> L15
            goto L29
        L27:
            return;
        L15:
            th = move-exception;
            throw th;     // Catch: Throwable -> L19
        L29:
            return;
        L28:
            return;
        L26:
            return;
        }

        private void a(d r1) {
            this.f7478b = r1.f7478b;
        }

        private void a(File r11) {
            JSONArray r0 = new JSONArray();
            int r2 = 0;
            int r3 = 0;
            int r4 = 0;
        L4:
            if (r2 >= 200) goto L26;
            if (r3 < this.f7478b.size()) goto L7;
            if (r4 >= this.f7477a.size()) goto L26;
            int r8 = r4 + 1;
            j r5 = (j) ZeusTransformUtils.preCheckCast(this.f7477a.get(r4), j.class, "com.obric.aiagent.plugin");
            JSONObject r6 = new JSONObject();
            r5.a(r6);     // Catch: JSONException -> L33
            int r7 = r2 + 1;
            r6.put(DbHelper.COL_ID, r2);     // Catch: JSONException -> L32
            r0.put(r6);     // Catch: JSONException -> L32
        L24:
            r2 = r7;
        L25:
            r4 = r8;
            goto L4
        L7:
            int r9 = r3 + 1;
            e r10 = (e) ZeusTransformUtils.preCheckCast(this.f7478b.get(r3), e.class, "com.obric.aiagent.plugin");
            JSONObject r12 = new JSONObject();
            r10.a(r12);     // Catch: JSONException -> L31
            int r13 = r2 + 1;
            r12.put(DbHelper.COL_ID, r2);     // Catch: JSONException -> L30
            r0.put(r12);     // Catch: JSONException -> L30
        L11:
            r2 = r13;
        L13:
            if (r4 < this.f7477a.size()) goto L15;
        L17:
            r3 = r9;
            goto L4
        L15:
            if (r10.b((j) ZeusTransformUtils.preCheckCast(this.f7477a.get(r4), j.class, "com.obric.aiagent.plugin")) == false) goto L17;
            r4 = r4 + 1;
        L26:
            JSONObject r14 = new JSONObject();
            r14.put("pending_messages", r0);     // Catch: JSONException -> L34
        L28:
            com.bytedance.crash.o.j.a(com.bytedance.crash.g.a.c(r11), r14, false);
        }
    }

    /* JADX INFO: compiled from: LooperMessageManager.java */
    private static class e extends j {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        protected long f7479a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        protected long f7480b;

        private e() {
            super(null);
        }

        /* synthetic */ e(AnonymousClass1 r1) {
            this();
        }

        @Override // com.bytedance.crash.g.b.j
        public void a() {
            super.a();
            b(0, 0);
        }

        public void b(long r1, long r3) {
            this.f7479a = r1;
            this.f7480b = r3;
        }

        @Override // com.bytedance.crash.g.b.j
        public void a(JSONObject r4) {
            super.a(r4);
            r4.put("duration", this.f7479a);
            r4.put("cpuDuration", this.f7480b);
        }

        public String b() {
            if (this.f7484e == null) goto L7;
            return this.f7484e;
        L7:
            if (this.f7483d != null) goto L9;
            return "no message running";
        L9:
            return this.f7483d;
        }
    }

    /* JADX INFO: compiled from: LooperMessageManager.java */
    private static class f extends e {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        protected int f7481c;

        private f() {
            super(null);
        }

        /* synthetic */ f(AnonymousClass1 r1) {
            this();
        }

        @Override // com.bytedance.crash.g.b.e, com.bytedance.crash.g.b.j
        public void a() {
            super.a();
            this.f7481c = 0;
        }
    }

    /* JADX INFO: compiled from: LooperMessageManager.java */
    private static class g extends f {
        private g h;

        private g() {
            super(null);
        }

        /* synthetic */ g(AnonymousClass1 r1) {
            this();
        }

        static /* synthetic */ g a(g r0) {
            return r0.h;
        }

        static /* synthetic */ g a(g r0, g r1) {
            r0.h = r1;
            return r1;
        }

        static /* synthetic */ void a(g r0, Message r1, long r2, long r4, long r6) {
            r0.a(r1, r2, r4, r6);
        }

        private void a(Message r3, long r4, long r6, long r8) {
            this.f7479a += r4;
            this.f7480b += r6;
            this.f7481c++;
            long r5 = a(r3, r8);
            if (this.f <= r5) goto L6;
            this.f = r5;
            return;
        }
    }

    /* JADX INFO: compiled from: LooperMessageManager.java */
    private static class h {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private g f7482a;

        /* synthetic */ h(int r1, AnonymousClass1 r2) {
            this(r1);
        }

        static /* synthetic */ g a(h r0) {
            return r0.a();
        }

        static /* synthetic */ void a(h r0, g r1) {
            r0.a(r1);
        }

        private h(int r3) {
        L3:
            if (r3 <= 0) goto L5;
            a(new g(null));
            r3 = r3 - 1;
            goto L3
        }

        private void a(g r2) {
            g.a(r2, this.f7482a);
            this.f7482a = r2;
        }

        private g a() {
            g r0 = this.f7482a;
            if (r0 == null) goto L6;
            this.f7482a = g.a(r0);
            g.a(r0, null);
            r0.a();
            return r0;
        L6:
            return null;
        }
    }

    /* JADX INFO: compiled from: LooperMessageManager.java */
    private static class i extends k {
        private int h;
        private long i;
        private long j;
        private long k;

        private i() {
            super(null);
        }

        /* synthetic */ i(AnonymousClass1 r1) {
            this();
        }

        @Override // com.bytedance.crash.g.b.k, com.bytedance.crash.g.b.f, com.bytedance.crash.g.b.e, com.bytedance.crash.g.b.j
        public void a() {
            super.a();
            this.h = 0;
            this.i = 0;
            this.j = 0;
        }

        public void a(f r3) {
            if (r3 != null) goto L4;
            return;
        L4:
            this.h = r3.f7481c;
            this.i = r3.f7479a;
            this.j = r3.f7480b;
            this.k = r3.f;
        }

        @Override // com.bytedance.crash.g.b.k, com.bytedance.crash.g.b.e, com.bytedance.crash.g.b.j
        public void a(JSONObject r5) {
            super.a(r5);
            int r0 = getType();
            if (r0 != 9) goto L5;
            r5.put("LongestGroupMessageCount", this.h);
            r5.put("LongestGroupDuration", this.i);
            r5.put("LongestGroupCpuDuration", this.j);
            r5.put("LongestGroupDelay", this.k);
            r5.put("messageCount", this.f7481c);
        L5:
            r5.put("msg", b());
            r5.put("type", r0);
        }

        private int getType() {
            if (this.f7481c != 0) goto L6;
            return 1;
        L6:
            if (c() == false) goto L8;
            return 8;
        L8:
            return 9;
        }
    }

    /* JADX INFO: compiled from: LooperMessageManager.java */
    private static class j {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        protected String f7483d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        protected String f7484e;
        protected long f;
        protected int g;

        private j() {
            this.f = Long.MAX_VALUE;
        }

        /* synthetic */ j(AnonymousClass1 r1) {
            this();
        }

        public static long a(Message r2, long r3) {
            if (a(r2) == true) goto L7;
            return Long.MAX_VALUE;
        L7:
            return r2.getWhen() - r3;
        }

        public static boolean a(Message r4) {
            if (r4.getWhen() <= 100) goto L5;
            return true;
        L5:
            return false;
        }

        public void b(Message r6, long r7) {
            if (r6 != null) goto L5;
            return;
        L5:
            if (r6.getTarget() == null) goto L8;
            this.f7483d = r6.getTarget().getClass().getName();
        L8:
            if (r6.getCallback() == null) goto L23;
            String r0 = r6.getCallback().getClass().getName();
            this.f7484e = r0;
            if (r0.startsWith("Y.ARunnable") == false) goto L23;
            String r1 = r6.getCallback().toString();
            int r2 = 0;
            if (r1.charAt(0) < '0') goto L23;
            if (r1.charAt(0) > '9') goto L23;
            StringBuilder r3 = new StringBuilder();
            r3.append(this.f7484e);
            r3.append(".run$");
        L17:
            if (r2 >= r1.length()) goto L22;
            if (r1.charAt(r2) == '_') goto L22;
            r3.append(r1.charAt(r2));
            r2 = r2 + 1;
        L22:
            this.f7484e = r3.toString();
        L23:
            this.f = a(r6, r7);
            this.g = r6.what;
        }

        public void a(j r2) {
            if (r2 != null) goto L4;
            return;
        L4:
            this.f7483d = r2.f7483d;
            this.f7484e = r2.f7484e;
            this.g = r2.g;
        }

        public void a() {
            this.f7483d = null;
            this.f7484e = null;
            this.f = Long.MAX_VALUE;
            this.g = -1;
        }

        public void a(JSONObject r5) {
            String r0 = this.f7484e;
            if (r0 == null) goto L5;
            r5.put("callback", r0);
        L5:
            String r1 = this.f7483d;
            if (r1 == null) goto L8;
            r5.put("target", r1);
        L8:
            int r2 = this.g;
            if (r2 == (-1)) goto L11;
            r5.put("what", r2);
        L11:
            long r3 = this.f;
            if (r3 == Long.MAX_VALUE) goto L15;
            r5.put("when", r3);
            return;
        }

        public boolean b(j r5) {
            if (this.f == r5.f) goto L5;
        L11:
            return false;
        L5:
            if (this.g != r5.g) goto L11;
            if (this.f7483d != r5.f7483d) goto L11;
            if (this.f7484e != r5.f7484e) goto L11;
            return true;
        }
    }

    /* JADX INFO: compiled from: LooperMessageManager.java */
    private static class k extends f {
        private long h;
        private long i;
        private int j;

        private k() {
            super(null);
        }

        /* synthetic */ k(AnonymousClass1 r1) {
            this();
        }

        @Override // com.bytedance.crash.g.b.f, com.bytedance.crash.g.b.e, com.bytedance.crash.g.b.j
        public void a() {
            super.a();
            this.h = 0;
            this.i = 0;
            this.j = 0;
        }

        public boolean c() {
            if (this.f7481c == 1) goto L5;
        L7:
            return false;
        L5:
            if ((this.f7479a - this.h) <= 200) goto L7;
            return true;
        }

        public void a(long r3, long r5) {
            this.h += r3;
            this.i += r5;
            if (r3 <= 1) goto L6;
            this.j++;
            return;
        }

        public void a(k r3) {
            this.j = r3.j;
            this.h = r3.h;
            this.i = r3.i;
        }

        @Override // com.bytedance.crash.g.b.e, com.bytedance.crash.g.b.j
        public void a(JSONObject r4) {
            super.a(r4);
            if (this.j == 0) goto L6;
            r4.put("idleDuration", this.h);
            r4.put("idleCpuDuration", this.i);
            r4.put("idleCount", this.j);
            return;
        }
    }

    static /* synthetic */ JSONArray a(b r0) {
        return r0.g;
    }

    public b() {
        this.h = new AnonymousClass1(this);
    }

    void a() {
        c r0 = new c(null);
        this.f7461a = r0;
        this.f7462b = r0;
        this.g = new JSONArray();
    }

    void b() {
        this.f7462b = null;
    }

    public synchronized void a(Message r17) {
        monitor-enter(this);
    L24:
        th = move-exception;
        throw th;
    L5:
        if (this.f7462b != null) goto L8;
        monitor-exit(this);
        return;
    L8:
        long r10 = SystemClock.currentThreadTimeMillis();     // Catch: Throwable -> L24
        long r12 = System.currentTimeMillis();     // Catch: Throwable -> L24
        long r14 = SystemClock.uptimeMillis();     // Catch: Throwable -> L24
        long r2 = this.f7463c;     // Catch: Throwable -> L24
        if (r2 == 0) goto L18;
        long r4 = r12 - r2;     // Catch: Throwable -> L24
        long r6 = r10 - this.f7464d;     // Catch: Throwable -> L24
        a r0 = this.f7462b.a(r17, r4, r6, this.f7465e);     // Catch: Throwable -> L24
        if (com.bytedance.crash.j.d() == false) goto L15;
        if (r17 != null) goto L14;
        DefaultWorkThread.postDelayed(this.h, WsConstants.EXIT_DELAY_TIME);     // Catch: Throwable -> L24
        goto L15
    L14:
        DefaultWorkThread.removeCallbacks(this.h);     // Catch: Throwable -> L24
    L15:
        if (r0 != null) goto L17;
        r0 = this.f7461a;     // Catch: Throwable -> L24
    L17:
        this.f7462b = r0;     // Catch: Throwable -> L24
    L18:
        if (r17 == null) goto L20;
        boolean r1 = true;
    L21:
        this.f = r1;     // Catch: Throwable -> L24
        this.f7463c = r12;     // Catch: Throwable -> L24
        this.f7464d = r10;     // Catch: Throwable -> L24
        this.f7465e = r14;     // Catch: Throwable -> L24
        monitor-exit(this);
        return;
    L20:
        r1 = false;
        goto L21
    }

    void a(File r19) {
        long r4 = System.currentTimeMillis();
        long r12 = SystemClock.uptimeMillis();
        monitor-enter(this);
        AnonymousClass1 r14 = null;
        if (this.f7462b != null) goto L7;
        boolean r10 = false;
        long r8 = 0;
        long r16 = 0;
        c r2 = null;
        C0164b r15 = null;
    L15:
        monitor-exit(this);     // Catch: Throwable -> L35
        if (r15 == null) goto L18;
        C0164b.a(r15, r19, r4 - r8, r10);
    L18:
        if (r2 == null) goto L20;
        c.a(r2, r19, r4, r12, r8, r16);
    L20:
        b(r19);
        d r3 = new d(r14);
        d.a(r3, r12);
        monitor-enter(this);
    L32:
        th = move-exception;
        throw th;
    L23:
        if (ZeusTransformUtils.instanceOf(this.f7462b, d.class) == false) goto L26;
        d.a(r3, (d) ZeusTransformUtils.preCheckCast(this.f7462b, d.class, "com.obric.aiagent.plugin"));     // Catch: Throwable -> L32
        this.f7462b = this.f7461a;     // Catch: Throwable -> L32
    L29:
        monitor-exit(this);     // Catch: Throwable -> L32
        d.a(r3, r19);
        return;
    L26:
        if (ZeusTransformUtils.instanceOf(this.f7462b, C0164b.class) == false) goto L29;
        if (r15 == null) goto L29;
        C0164b.a(r15);     // Catch: Throwable -> L32
        goto L29
    L7:
        if (this.f7463c != 0) goto L9;
    L12:
        monitor-exit(this);     // Catch: Throwable -> L35
        return;
    L9:
        if (ZeusTransformUtils.instanceOf(this.f7462b, c.class) == false) goto L12;
        r2 = (c) ZeusTransformUtils.preCheckCast(this.f7462b, c.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L35
        C0164b r5 = new C0164b(r14);     // Catch: Throwable -> L35
        long r6 = this.f7463c;     // Catch: Throwable -> L35
        long r9 = this.f7464d;     // Catch: Throwable -> L35
        r10 = this.f;     // Catch: Throwable -> L35
        this.f7462b = r5;     // Catch: Throwable -> L35
        r15 = r5;
        r16 = r9;
        r8 = r6;
    L35:
        th = move-exception;
        throw th;
    }

    private void b(File r3) {
        if (this.g.length() == 0) goto L6;
        JSONObject r0 = new JSONObject();
        l.a(r0, "block_stack", this.g);
        com.bytedance.crash.o.j.a(com.bytedance.crash.g.a.d(r3), r0, false);
        return;
    }
}
