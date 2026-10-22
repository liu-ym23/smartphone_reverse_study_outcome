package com.bytedance.apm6.consumer.slardar.send;

import com.bytedance.apm.constant.CommonKey;
import com.bytedance.apm.constant.PerfTraceConsts;
import com.bytedance.apm6.consumer.slardar.weedout.WeedOutStrategy;
import com.bytedance.apm6.util.timetask.AsyncTaskManagerType;
import com.bytedance.common.utility.NetworkUtils;
import java.io.File;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentLinkedQueue;

/* JADX INFO: loaded from: classes.dex */
public class c implements WeedOutStrategy {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public LinkedHashMap f6712a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public u3.a f6713b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public long f6714c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public long f6715d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public long f6716e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public volatile boolean f6717f;

    public class a extends u3.a {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ c f6718d;

        public a(c r10, long r11, long r12) {
            this.f6718d = r10;
            super(r11, r12);
        }

        @Override // java.lang.Runnable
        public void run() {
            if ((System.currentTimeMillis() - c.a(this.f6718d)) < c.c(this.f6718d)) goto L14;
        L8:
            th = move-exception;
            s3.a.c(n2.a.f22354a, CommonKey.KEY_SEND, th);
        L10:
            c.b(this.f6718d, System.currentTimeMillis());
            return;
        L5:
            if (c.d(this.f6718d) == true) goto L10;
            c.e(this.f6718d);     // Catch: Throwable -> L8
            goto L10
        }
    }

    public class b implements Comparator {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ c f6719a;

        public b(c r10) {
            this.f6719a = r10;
        }

        public int a(File r10, File r11) {
            return r10.compareTo(r11);
        }

        @Override // java.util.Comparator
        public /* bridge */ /* synthetic */ int compare(Object r10, Object r11) {
            return a((File) r10, (File) r11);
        }
    }

    /* JADX INFO: renamed from: com.bytedance.apm6.consumer.slardar.send.c$c, reason: collision with other inner class name */
    public static class C0080c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final c f6720a = null;

        static {
            f6720a = new c(null);
        }

        public static /* synthetic */ c a() {
            return f6720a;
        }
    }

    public static final class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public byte[] f6721a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f6722b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public long f6723c;

        public d(byte[] r10, int r11, long r12) {
            this.f6721a = r10;
            this.f6722b = r11;
            this.f6723c = r12;
        }
    }

    public /* synthetic */ c(a r10) {
        this();
    }

    public static /* synthetic */ long a(c r10) {
        return r10.f6715d;
    }

    public static /* synthetic */ long b(c r10, long r11) {
        r10.f6715d = r11;
        return r11;
    }

    public static /* synthetic */ long c(c r10) {
        return r10.f6714c;
    }

    public static /* synthetic */ boolean d(c r10) {
        return r10.f6717f;
    }

    public static /* synthetic */ void e(c r10) {
        r10.l();
    }

    public static c g() {
        return C0080c.a();
    }

    @Override // com.bytedance.apm6.consumer.slardar.weedout.WeedOutStrategy
    public void doWeedOut(long r10) {
        File[] r11 = com.bytedance.apm6.consumer.slardar.send.a.f().j();
        if (r11 != null) goto L5;
        return;
    L5:
        int r12 = r11.length;
        int r13 = 0;
    L6:
        if (r13 >= r12) goto L11;
        File r14 = r11[r13];
        if (com.bytedance.apm6.consumer.slardar.send.a.d(r14) > r10) goto L10;
        r3.c.a(r14);
    L10:
        r13 = r13 + 1;
        goto L6
    }

    @Override // com.bytedance.apm6.consumer.slardar.weedout.WeedOutStrategy
    public void doWeedOutSize(long r10) {
        File[] r11 = com.bytedance.apm6.consumer.slardar.send.a.f().j();
        if (r11 != null) goto L5;
        return;
    L5:
        Arrays.sort(r11, new b(this));
        int r12 = r11.length;
        int r13 = 0;
        long r14 = 0;
        int r15 = 0;
        long r16 = 0;
    L6:
        if (r15 >= r12) goto L13;
        File r17 = r11[r15];
        if (r17.exists() == false) goto L12;
        if (r17.isFile() == false) goto L12;
        r16 = r16 + r17.length();
    L12:
        r15 = r15 + 1;
        goto L6
    L13:
        int r18 = r11.length;
    L14:
        if (r13 >= r18) goto L36;
        File r19 = r11[r13];
        if ((r16 - r14) <= r10) goto L25;
        if (r19.exists() == false) goto L24;
        if (r19.isFile() == false) goto L24;
        long r20 = r19.length();
        if (r3.c.b(r19) == false) goto L24;
        r14 = r14 + r20;
    L24:
        r13 = r13 + 1;
        goto L14
    L25:
        return;
    }

    public final void f(List r10) {
        Iterator r11 = r10.iterator();
    L4:
        if (r11.hasNext() == false) goto L11;
        q2.a r12 = (q2.a) r11.next();
    L10:
        s3.a.f(n2.a.f22354a, "delete LogFile's source File failed. logFile=" + r12.d());
        goto L4
    L7:
        if (r12.d() == null) goto L4;
        r3.c.a(r12.d());     // Catch: Exception -> L10
        goto L4
    }

    @Override // com.bytedance.apm6.consumer.slardar.weedout.WeedOutStrategy
    public String getName() {
        return "second_log_dir";
    }

    @Override // com.bytedance.apm6.consumer.slardar.weedout.WeedOutStrategy
    public long getSize() {
        File[] r10 = com.bytedance.apm6.consumer.slardar.send.a.f().j();
        long r11 = 0;
        if (r10 != null) goto L5;
        return 0;
    L5:
        int r12 = r10.length;
        int r13 = 0;
    L6:
        if (r13 >= r12) goto L8;
        r11 = r11 + r10[r13].length();
        r13 = r13 + 1;
        goto L6
    L8:
        return r11;
    }

    public void h() {
        this.f6713b = new a(this, 0, PerfTraceConsts.LAUNCH_TRACE_COLLECT_INFO_TIME_MS);
        u3.b.a(AsyncTaskManagerType.IO).c(this.f6713b);
    }

    public void i() {
        this.f6717f = true;
    }

    public final void j() {
        this.f6716e = 1;
        this.f6714c = PerfTraceConsts.LAUNCH_TRACE_COLLECT_INFO_TIME_MS;
    }

    public void k() {
        this.f6717f = false;
    }

    public final void l() {
        if (NetworkUtils.l(r3.a.b()) == true) goto L5;
        return;
    L5:
        if (com.bytedance.apm6.consumer.slardar.send.b.e().j() == false) goto L21;
        if (r3.a.c() == false) goto L9;
        s3.a.a(n2.a.f22354a, "trigger send.");
    L9:
        boolean r10 = o();
        if (d3.a.A() == false) goto L12;
        r10 = m();
    L12:
        if (r10 == false) goto L15;
        j();
        goto L21
    L15:
        if (this.f6714c >= 120000) goto L18;
        long r11 = this.f6716e;
        this.f6714c = (r11 + 1) * PerfTraceConsts.LAUNCH_TRACE_COLLECT_INFO_TIME_MS;
        this.f6716e = r11 + 1;
    L18:
        if (this.f6714c <= 120000) goto L21;
        this.f6714c = 120000;
    L21:
        if (r3.a.c() == true) goto L23;
        return;
    L23:
        if (com.bytedance.apm6.consumer.slardar.send.b.e().j() == true) goto L28;
        s3.a.a(n2.a.f22354a, "report log disable");
        return;
    }

    public final boolean m() {
        Iterator r10 = e.c().iterator();
        boolean r11 = true;
    L4:
        if (r10.hasNext() == false) goto L24;
        UploadLogInfo r12 = (UploadLogInfo) r10.next();
        File r13 = com.bytedance.apm6.consumer.slardar.send.a.f().h(r12.getName());
        if (r13 == null) goto L4;
        if (r13.exists() == false) goto L4;
        if (com.bytedance.apm6.consumer.slardar.send.d.g(r12).j(r3.c.e(r13)) == true) goto L13;
        com.bytedance.apm6.consumer.slardar.send.a.c r14 = com.bytedance.apm6.consumer.slardar.send.a.f().g(r13);
        if (r14 == null) goto L19;
        int r15 = r14.c() + 1;
    L20:
        long r16 = com.bytedance.apm6.consumer.slardar.send.b.e().g(r15) + System.currentTimeMillis();
        com.bytedance.apm6.consumer.slardar.send.a.f().l(r13, r15, r16);
        if (r3.a.c() == false) goto L23;
        s3.a.a(n2.a.f22354a, "sendfile error retry count:" + r13.getName() + "  " + r15 + " nextRetryTime:" + r16);
    L23:
        r11 = false;
        goto L4
    L19:
        r15 = 0;
        goto L20
    L13:
        if (r3.a.c() == false) goto L15;
        s3.a.a(n2.a.f22354a, "sendFile: success");
    L15:
        com.bytedance.apm6.consumer.slardar.send.a.f().b(r13);
        goto L4
    L24:
        return r11;
    }

    public void n(List r19, int r20) {
    L8:
        th = move-exception;
        s3.a.c(n2.a.f22354a, "sendLog", th);
        return;
    L4:
        if (com.bytedance.apm6.consumer.slardar.send.b.e().k() == true) goto L6;
        Map r10 = e.d(r19, r20);     // Catch: Throwable -> L8
        if (r10 != null) goto L20;
        f(r19);     // Catch: Throwable -> L8
        return;
    L20:
        boolean r11 = NetworkUtils.l(r3.a.b());     // Catch: Throwable -> L8
        Iterator r12 = r10.keySet().iterator();     // Catch: Throwable -> L8
        boolean r13 = false;
    L22:
        if (r12.hasNext() == false) goto L60;
        UploadLogInfo r14 = (UploadLogInfo) r12.next();     // Catch: Throwable -> L8
        byte[] r15 = (byte[]) r10.get(r14);     // Catch: Throwable -> L8
        if (r15 == null) goto L22;
        if (com.bytedance.apm6.consumer.slardar.send.b.e().j() == false) goto L38;
        if (r11 == false) goto L38;
        if (r3.a.c() == false) goto L32;
        o1.a.d(r15);     // Catch: Throwable -> L8
    L32:
        boolean r16 = com.bytedance.apm6.consumer.slardar.send.d.g(r14).j(r15);     // Catch: Throwable -> L8
        if (r3.a.c() == false) goto L37;
        if (r16 == false) goto L36;
        o1.a.h(r15);     // Catch: Throwable -> L8
        goto L37
    L36:
        o1.a.f(r15);     // Catch: Throwable -> L8
    L37:
        this.f6715d = System.currentTimeMillis();     // Catch: Throwable -> L8
        r13 = r13 | r16;     // Catch: Throwable -> L8
        int r17 = 1;
    L40:
        if (r3.a.c() == false) goto L42;
        s3.a.a(n2.a.f22354a, "sendDirect:isReportLogEnable " + com.bytedance.apm6.consumer.slardar.send.b.e().j() + " :sendResult " + r16);     // Catch: Throwable -> L8
    L42:
        if (r16 == true) goto L58;
        long r18 = com.bytedance.apm6.consumer.slardar.send.b.e().g(r17);     // Catch: Throwable -> L8
        long r110 = System.currentTimeMillis() + r18;     // Catch: Throwable -> L8
        if (d3.a.A() == false) goto L46;
        long r111 = r110;
        r16 = com.bytedance.apm6.consumer.slardar.send.a.f().k(r15, r14.getName(), r17, r111);     // Catch: Throwable -> L8
    L48:
        if (r3.a.c() == false) goto L50;
        s3.a.a(n2.a.f22354a, "saveFile:Result:" + r16 + ":isMaiProcess:" + d3.a.A() + " :" + r17 + " " + r18);     // Catch: Throwable -> L8
    L50:
        if (r16 == false) goto L52;
    L59:
        r13 = r13;
        goto L22
    L52:
        if (this.f6712a.containsKey(r14) == false) goto L54;
        ConcurrentLinkedQueue r21 = (ConcurrentLinkedQueue) this.f6712a.get(r14);     // Catch: Throwable -> L8
    L56:
        if (r21.size() <= 10) goto L59;
        r21.poll();     // Catch: Throwable -> L8
        goto L59
    L54:
        r21 = new ConcurrentLinkedQueue();     // Catch: Throwable -> L8
        r21.add(new d(r15, r17, r111));     // Catch: Throwable -> L8
        goto L56
    L46:
        r111 = r110;
        goto L48
    L58:
        r13 = r13;
    L38:
        r16 = false;
        r17 = 0;
        goto L40
    L60:
        if (r13 == false) goto L62;
        j();     // Catch: Throwable -> L8
    L62:
        f(r19);     // Catch: Throwable -> L8
        return;
    L6:
        if (r3.a.c() == false) goto L10;
        s3.a.a(n2.a.f22354a, "stop collect log");     // Catch: Throwable -> L8
    L10:
        Iterator r22 = r19.iterator();     // Catch: Throwable -> L8
        long r23 = 0;
        long r24 = 0;
    L12:
        if (r22.hasNext() == false) goto L14;
        q2.a r25 = (q2.a) r22.next();     // Catch: Throwable -> L8
        r23 = r23 + ((long) r25.g());     // Catch: Throwable -> L8
        r24 = r24 + ((long) r25.f());     // Catch: Throwable -> L8
        goto L12
    L14:
        DropDataMonitor.b().d(r23, r24, System.currentTimeMillis(), DropDataMonitor.Reason.SERVER_DROP);     // Catch: Throwable -> L8
        f(r19);     // Catch: Throwable -> L8
    }

    public final boolean o() {
        if (this.f6712a.isEmpty() == false) goto L5;
        return true;
    L5:
        Iterator r10 = this.f6712a.keySet().iterator();
        boolean r11 = true;
    L7:
        if (r10.hasNext() == false) goto L35;
        UploadLogInfo r12 = (UploadLogInfo) r10.next();
        ConcurrentLinkedQueue r13 = (ConcurrentLinkedQueue) this.f6712a.get(r12);
        if (r13 == null) goto L7;
        d[] r14 = (d[]) r13.toArray(new d[0]);
        int r15 = r14.length;
        int r16 = 0;
    L12:
        if (r16 >= r15) goto L19;
        d r17 = r14[r16];
        if (r17.f6722b <= 0) goto L20;
        if ((System.currentTimeMillis() - r17.f6723c) > 0) goto L20;
        r16 = r16 + 1;
    L20:
        if (r17 == null) goto L22;
    L24:
        if (r17 == null) goto L7;
        if (r3.a.c() == false) goto L29;
        s3.a.a(n2.a.f22354a, "sendMemory");
    L29:
        boolean r18 = com.bytedance.apm6.consumer.slardar.send.d.g(r12).j(r17.f6721a);
        if (r18 == false) goto L32;
        r13.remove(r17);
    L33:
        if (r18 == true) goto L7;
        r11 = false;
        goto L7
    L32:
        r17.f6722b++;
        r17.f6723c = com.bytedance.apm6.consumer.slardar.send.b.e().g(r17.f6722b) + System.currentTimeMillis();
        goto L33
    L22:
        if (r13.size() <= 0) goto L24;
        r17 = (d) r13.peek();
        goto L24
    L19:
        r17 = null;
        goto L20
    L35:
        return r11;
    }

    public c() {
        this.f6712a = new LinkedHashMap();
        this.f6714c = PerfTraceConsts.LAUNCH_TRACE_COLLECT_INFO_TIME_MS;
        this.f6715d = 0;
        this.f6716e = 1;
        this.f6717f = false;
    }
}
