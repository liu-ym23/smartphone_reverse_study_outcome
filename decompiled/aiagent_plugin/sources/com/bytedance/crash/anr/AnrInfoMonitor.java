package com.bytedance.crash.anr;

import android.app.ActivityManager;
import android.content.Context;
import android.os.FileObserver;
import android.os.Process;
import android.os.SystemClock;
import android.text.TextUtils;
import com.bytedance.crash.j;
import com.bytedance.crash.jni.NativeBridge;
import com.bytedance.crash.o.r;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.File;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.LinkedBlockingQueue;

/* JADX INFO: loaded from: classes.dex */
public class AnrInfoMonitor {
    private static final String TAG = "AnrInfoMonitor";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private boolean f7162a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final InnerObserver f7163b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Context f7164c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final File f7165d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private b f7166e;

    static class InnerObserver extends FileObserver {
        private final File mDirectory;

        public InnerObserver(String r2) {
            super(r2, 264);
            this.mDirectory = new File(r2);
        }

        @Override // android.os.FileObserver
        public void onEvent(int r3, String r4) {
            if ((r3 & 8) != 0) goto L5;
            return;
        L5:
            if (r4.startsWith("ai_") == true) goto L7;
            return;
        L7:
            if (AnrInfoMonitor.b(r4) == Process.myPid()) goto L9;
            return;
        L9:
            if (r4.endsWith("_other") == false) goto L15;
            e.a(AnrInfoMonitor.a(r4), new File(this.mDirectory, r4));
            return;
        }
    }

    class a extends Thread {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ AnrInfoMonitor f7169a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final File f7170b;

        a(AnrInfoMonitor r1, File r2) {
            this.f7169a = r1;
            super("NPTH-AnrInfoPolling");
            this.f7170b = com.bytedance.crash.o.i.b(r2, "monitor.lock");
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            r.b(AnrInfoMonitor.TAG, "AnrInfoMonitor:prepare lock：" + com.bytedance.crash.o.b.a());
            int r0 = NativeBridge.b(this.f7170b.getAbsolutePath());
            r.b(AnrInfoMonitor.TAG, "AnrInfoMonitor:run：" + com.bytedance.crash.o.b.a());
            a();
            if (r0 == (-1)) goto L11;
            NativeBridge.a(r0);     // Catch: Throwable -> L6
            return;
        L6:
            th = move-exception;
            r.b(th);
            return;
        }

        private void a() {
            ActivityManager r0 = (ActivityManager) ZeusTransformUtils.preCheckCast(((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AnrInfoMonitor.b(this.f7169a), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")).getSystemService("activity"), ActivityManager.class, "com.obric.aiagent.plugin");
            long r3 = com.bytedance.crash.config.h.a();
            ActivityManager.ProcessErrorStateInfo r5 = null;
        L4:
            if (AnrInfoMonitor.c(this.f7169a) == false) goto L35;
            SystemClock.sleep(r3);
            if (r0 != null) goto L8;
            r0 = (ActivityManager) ZeusTransformUtils.preCheckCast(((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AnrInfoMonitor.b(this.f7169a), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")).getSystemService("activity"), ActivityManager.class, "com.obric.aiagent.plugin");
        L8:
            if (r0 == null) goto L4;
            List<ActivityManager.ProcessErrorStateInfo> r6 = r0.getProcessesInErrorState();     // Catch: Throwable -> L36
            if (r6 == null) goto L4;
            Iterator<ActivityManager.ProcessErrorStateInfo> r7 = r6.iterator();     // Catch: Throwable -> L36
        L15:
            if (r7.hasNext() == false) goto L4;
            ActivityManager.ProcessErrorStateInfo r8 = (ActivityManager.ProcessErrorStateInfo) ZeusTransformUtils.preCheckCast(r7.next(), ActivityManager.ProcessErrorStateInfo.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L36
            if (r8.condition != 2) goto L15;
            if (r5 == null) goto L23;
            if (d.a(r5, r8) == true) goto L15;
        L23:
            long r9 = System.currentTimeMillis();     // Catch: Throwable -> L36
            int r10 = r8.pid;     // Catch: Throwable -> L36
            if (Process.myPid() != r8.pid) goto L26;
            boolean r11 = true;
        L27:
            String r12 = AnrInfoMonitor.a(r9, r10, r11);     // Catch: Throwable -> L36
            File r13 = new File(AnrInfoMonitor.a(this.f7169a), r12);     // Catch: Throwable -> L36
            com.bytedance.crash.o.i.c(r13, d.a(r8));     // Catch: Throwable -> L36
            if (r13.exists() == false) goto L15;
            if (Process.myPid() != r8.pid) goto L32;
            e.a(r9, r13);     // Catch: Throwable -> L34
        L32:
            SystemClock.sleep(20 * r3);     // Catch: Throwable -> L34
            r5 = r8;
        L34:
            r5 = r8;
            goto L4
        L26:
            r11 = false;
            goto L27
        }
    }

    class b extends Thread {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ AnrInfoMonitor f7171a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final LinkedBlockingQueue<Long> f7172b;

        b(AnrInfoMonitor r1) {
            this.f7171a = r1;
            super("FetchingAnrInfo");
            this.f7172b = new LinkedBlockingQueue();
        }

        public void a(long r5) {
            if (j.a() == false) goto L5;
            com.bytedance.crash.o.i.c(new File(AnrInfoMonitor.a(this.f7171a), AnrInfoMonitor.a(r5, Process.myPid(), true)), "silent anr no anr info");
        L5:
            this.f7172b.add(Long.valueOf(r5));
        }

        private void b(long r6) {
            System.out.println("get_anr_info_start_" + r6);     // Catch: Throwable -> L8
            String r0 = com.bytedance.crash.anr.a.a((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AnrInfoMonitor.b(this.f7171a), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), 150);     // Catch: Throwable -> L8
            if (TextUtils.isEmpty(r0) == false) goto L6;
            System.out.println("get_anr_info_is_empty");     // Catch: Throwable -> L8
            r0 = "silent anr no anr info";
        L6:
            a(r6, r0);     // Catch: Throwable -> L8
            return;
        L8:
            a(r6, "silent anr no anr info");
        }

        private void a(long r3, String r5) {
            String r0 = AnrInfoMonitor.a(r3, Process.myPid(), true);
            File r1 = new File(AnrInfoMonitor.a(this.f7171a), r0);
            com.bytedance.crash.o.i.c(r1, r5);
            e.a(r3, r1);
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
        L8:
            Long r0 = (Long) ZeusTransformUtils.preCheckCast(this.f7172b.take(), Long.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L7
            if (r0 != null) goto L4;
            System.out.println("get_anr_info_start_time_null");     // Catch: Throwable -> L7
            goto L8
        L4:
            b(r0.longValue());     // Catch: Throwable -> L7
            goto L8
        }
    }

    static /* synthetic */ File a(AnrInfoMonitor r0) {
        return r0.f7165d;
    }

    static /* synthetic */ Context b(AnrInfoMonitor r0) {
        return r0.f7164c;
    }

    static /* synthetic */ boolean c(AnrInfoMonitor r0) {
        return r0.f7162a;
    }

    void a() {
        if (this.f7162a == true) goto L9;
        this.f7162a = true;
        this.f7163b.startWatching();
        if (j.b() == true) goto L7;
        new a(this, this.f7165d).start();
        return;
    L7:
        b r0 = new b(this);
        this.f7166e = r0;
        r0.start();
        return;
    }

    void b() {
        if (this.f7162a == false) goto L6;
        this.f7162a = false;
        this.f7163b.stopWatching();
        return;
    }

    AnrInfoMonitor(Context r3, File r4) {
        this.f7164c = ZeusTransformUtils.wrapperContext((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin"), "com.obric.aiagent.plugin");
        File r5 = com.bytedance.crash.o.i.a(r4, "anr_info");
        this.f7165d = r5;
        this.f7163b = new InnerObserver(r5.getAbsolutePath());
    }

    void a(final String r7, com.bytedance.crash.r r8) {
        final com.bytedance.crash.r r4 = (com.bytedance.crash.r) ZeusTransformUtils.wrapperContextForParams(r8, com.bytedance.crash.r.class, "com.obric.aiagent.plugin");
        final int r3 = 136;
        new AnonymousClass2(this, r7, r3, r4, r7).startWatching();
    }

    public void a(long r1) {
        this.f7166e.a(r1);
    }

    static String a(long r2, int r4, boolean r5) {
        if (r5 == false) goto L4;
        String r6 = "_current";
    L6:
        return "ai_" + r2 + "_" + r4 + r6;
    L4:
        r6 = "_other";
        goto L6
    }

    static long a(String r2) {
        String[] r3 = r2.split("_");
        if (r3.length != 4) goto L8;
        return Long.decode(r3[1]).longValue();
    L8:
        return System.currentTimeMillis();
    }

    static int b(String r2) {
        String[] r3 = r2.split("_");
        if (r3.length == 4) goto L10;
        return 0;
    L10:
        return Integer.decode(r3[2]).intValue();
    L12:
        return 0;
    }

    private File[] c() {
        if (this.f7165d.exists() == true) goto L7;
        return null;
    L7:
        return this.f7165d.listFiles(new AnonymousClass1(this));
    }

    File a(int r6, long r7) {
        File[] r5 = c();
        if (r5 == null) goto L12;
        int r0 = r5.length;
        int r1 = 0;
    L5:
        if (r1 >= r0) goto L18;
        File r2 = r5[r1];
        if (b(r2.getName()) != r6) goto L11;
        if (c.a(r7, a(r2.getName())) == false) goto L11;
        return r2;
    L11:
        r1 = r1 + 1;
        goto L5
    L18:
        return null;
    L12:
        return null;
    }

    private static File a(File r17, long r18, final long r20, StringBuffer r22) {
        File[] r3 = r17.listFiles(new AnonymousClass3(r20));
        if (r3 != null) goto L5;
    L53:
        r22.append("processDirs==null");
        return null;
    L5:
        if (r3.length == 0) goto L53;
        int r5 = r3.length;
        int r6 = 0;
        int r7 = 0;
    L8:
        if (r7 >= r5) goto L51;
        File r8 = r3[r7];
        if (r8.isDirectory() == true) goto L12;
    L11:
        int r9 = r5;
    L50:
        r7 = r7 + 1;
        r5 = r9;
        r6 = 0;
        goto L8
    L12:
        String[] r10 = r8.getName().split("-");
        if (r10.length != 2) goto L11;
        long r12 = Long.parseLong(r10[r6]);     // Catch: Throwable -> L18
    L20:
        if (r12 != 0) goto L22;
    L49:
        r9 = r5;
        r22.append("startTime:" + r12 + "_" + r18);
        goto L50
    L22:
        if (r12 > r18) goto L49;
        File[] r11 = r8.listFiles();
        if (r11 != null) goto L27;
        r22.append("crashDirs is null ");
        goto L11
    L27:
        int r13 = r11.length;
        int r14 = r6;
    L28:
        if (r14 >= r13) goto L11;
        File r15 = r11[r14];
        if (r15.isDirectory() == true) goto L34;
        r22.append("crashDirs is not directory ");
    L32:
        r5 = r5;
    L48:
        r14 = r14 + 1;
        r5 = r5;
        goto L28
    L34:
        if (h.b(r15) == true) goto L37;
        r22.append("hasSummaryFile is false ");
        goto L32
    L37:
        if (new File(r15, d.a()).exists() == false) goto L57;
        r22.append("anrinfo exist:");
        goto L32
    L57:
        long r4 = Long.parseLong(r15.getName());     // Catch: Throwable -> L41
    L43:
        if (r4 != 0) goto L45;
    L47:
        r22.append("last error:" + r4 + "_" + r18);
        goto L48
    L45:
        if (c.a(r4, r18) == false) goto L47;
        return r15;
    L41:
        r4 = 0;
    L18:
        r12 = 0;
        goto L20
    L51:
        return null;
    }

    void a(File r12) {
        File[] r11 = c();
        if (r11 != null) goto L5;
        return;
    L5:
        int r0 = r11.length;
        int r1 = 0;
    L6:
        if (r1 >= r0) goto L22;
        File r2 = r11[r1];
        int r3 = b(r2.getName());     // Catch: Throwable -> L19
        long r6 = a(r2.getName());     // Catch: Throwable -> L19
        if (r3 != 0) goto L11;
    L17:
        r2.delete();     // Catch: Throwable -> L19
        com.bytedance.crash.anr.a.a(new Exception("Invalid ANR Info File Name :{" + r2.getName() + "}"));     // Catch: Throwable -> L19
    L21:
        r1 = r1 + 1;
        goto L6
    L11:
        if (r6 == 0) goto L17;
        StringBuffer r4 = new StringBuffer();     // Catch: Throwable -> L19
        File r5 = a(r12, r6, r3, r4);     // Catch: Throwable -> L19
        if (r5 != null) goto L16;
        r2.delete();     // Catch: Throwable -> L19
        com.bytedance.crash.anr.a.a(new Exception("Not found matched directory pid:" + r3 + "_" + r2.getName() + "_:reason:" + r4));     // Catch: Throwable -> L19
        goto L21
    L16:
        r2.renameTo(new File(r5, d.a()));     // Catch: Throwable -> L19
    L19:
        th = move-exception;
        com.bytedance.crash.c.b.a("NPTH_ANR_ERROR", th);
        goto L21
    }
}
