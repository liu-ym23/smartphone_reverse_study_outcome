package com.bytedance.monitor.collector;

import android.os.Looper;
import android.text.TextUtils;
import android.util.Log;
import com.bytedance.apm.battery.dao.DBHelper;
import com.bytedance.security.zenmobile.io.SensitiveType;
import com.obric.aiagent.apm.impl.BuildConfig;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;
import me.ele.lancet.base.annotations.Skip;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class LockMonitorManager {
    private static final int DEFAULT_SIZE = 100;
    private static final String DELIMITER = "&#&";
    private static final String KEY_IS_ALL_THREAD = "is_all_thread";
    private static final String KEY_IS_LOCK = "is_lock";
    private static final String KEY_RAW_DUMP_INFO = "raw_dump_info";
    private static final String LOCK_THREAD_NAME = "lock_handler_time";
    private static final String STACK_THREAD_NAME = "lock_stack_fetch";
    private static final String TAG = "LockMonitorManager";
    private static final int bufferSize = 100;
    private static boolean isAllThread = false;
    private static volatile boolean isLockMonitoring = false;
    private static volatile String lastJavaStack = null;
    private static volatile String lastOwnerJavaStack = null;
    private static a[] lockInfoQueue = null;
    private static volatile boolean openFetchStack = false;
    private static int position;
    private static ExecutorService sLockHandler;
    private static final BlockingQueue<String> sOwnerStackBlockingQueue = null;
    private static final BlockingQueue<String> sStackBlockingQueue = null;
    private static ExecutorService sStackFetcher;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final long f8937a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final long f8938b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final String f8939c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private String f8940d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private String f8941e;
        private String f;
        private String g;
        private String h;
        private String i;

        static /* synthetic */ String a(a r0) {
            return r0.f;
        }

        static /* synthetic */ String b(a r0) {
            return r0.f8940d;
        }

        private a(long r2, long r4, String r6, String r7) {
            this.f8940d = SensitiveType.UNKNOWN;
            this.f8937a = r2;
            this.f8938b = r4;
            this.f8939c = r6;
            this.i = r7;
            d(r6);
            com.bytedance.apm6.service.d.a r3 = (com.bytedance.apm6.service.d.a) ZeusTransformUtils.preCheckCast(com.bytedance.apm6.service.c.a(com.bytedance.apm6.service.d.a.class), com.bytedance.apm6.service.d.a.class, "com.obric.aiagent.plugin");
            if (r3 == null) goto L8;
            String r5 = r3.getTopActivityClassName();
            if (TextUtils.isEmpty(r5) == true) goto L9;
            this.f8940d = r5;
            return;
        L9:
            return;
        }

        private void d(String r9) {
            String r10 = r9.substring(r9.indexOf("monitor contention with owner"));
            this.h = r10.substring(30, r10.indexOf("(") - 1);
            int r1 = r10.indexOf(" at ");
            if (r1 == (-1)) goto L5;
            String r2 = r10.substring(r1 + 5, r10.indexOf("waiters=", r1));
            String r3 = r2.substring(r2.indexOf(" "));
            this.g = r3.substring(1, r3.indexOf("(")) + r3.substring(r3.indexOf(")") + 1, r3.lastIndexOf(")") + 1);
        L5:
            String r11 = r10.substring(r10.indexOf("blocking from") + 14);
            String r12 = r11.substring(r11.indexOf(" ") + 1);
            this.f8941e = r12.substring(0, r12.indexOf("(")) + r12.substring(r12.indexOf(")") + 1, r12.lastIndexOf(")") + 1);
        }

        public String a() {
            return this.f8941e;
        }

        public String b() {
            return this.g;
        }

        public String c() {
            return this.h;
        }

        public String d() {
            return this.i;
        }

        static a a(String r9) {
            String r0 = null;
            if (r9 != null) goto L5;
        L61:
            return null;
        L5:
            if (r9.isEmpty() == true) goto L61;
            a("lockDetect", "" + r9);
            String[] r1 = r9.split(LockMonitorManager.DELIMITER);
            if (r1.length == 4) goto L11;
            a("lockDetect", "spiltData != 4" + r9);
            return null;
        L11:
            long r3 = Long.parseLong(r1[0]);
            long r5 = Long.parseLong(r1[1]);
            String r10 = r1[2];
            a r2 = new a(r3, r5, r10, r1[3]);
            if (LockMonitorManager.access$300() == false) goto L53;
            BlockingQueue r4 = LockMonitorManager.access$400();
            monitor-enter(r4);
            String r6 = (String) ZeusTransformUtils.preCheckCast(LockMonitorManager.access$400().poll(200, TimeUnit.MILLISECONDS), String.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L18 InterruptedException -> L20
        L22:
            if (r6 == null) goto L24;
        L26:
            LockMonitorManager.access$502(r6);     // Catch: Throwable -> L18
        L28:
            if (LockMonitorManager.access$400().isEmpty() == true) goto L30;
            LockMonitorManager.access$400().clear();     // Catch: Throwable -> L18
        L30:
            monitor-exit(r4);     // Catch: Throwable -> L18
            BlockingQueue r7 = LockMonitorManager.access$600();
            monitor-enter(r7);
            r0 = (String) ZeusTransformUtils.preCheckCast(LockMonitorManager.access$600().poll(200, TimeUnit.MILLISECONDS), String.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L35 InterruptedException -> L37
        L39:
            if (r0 == null) goto L41;
        L43:
            LockMonitorManager.access$702(r6);     // Catch: Throwable -> L35
        L45:
            if (LockMonitorManager.access$600().isEmpty() == true) goto L47;
            LockMonitorManager.access$600().clear();     // Catch: Throwable -> L35
        L47:
            monitor-exit(r7);     // Catch: Throwable -> L35
            String r8 = r0;
            r0 = r6;
        L54:
            if (r0 != null) goto L56;
        L58:
            if (r8 == null) goto L60;
            r2.c(r8);
        L60:
            return r2;
        L56:
            if (r10.contains(o.b(r0)) == false) goto L58;
            r2.b(r0);
            goto L58
        L41:
            if (LockMonitorManager.access$700() == null) goto L43;
            r0 = LockMonitorManager.access$700();     // Catch: Throwable -> L35
            goto L45
        L35:
            th = move-exception;
            throw th;
        L37:
            e = move-exception;
            e.printStackTrace();     // Catch: Throwable -> L35
            goto L39
        L24:
            if (LockMonitorManager.access$500() == null) goto L26;
            r6 = LockMonitorManager.access$500();     // Catch: Throwable -> L18
            goto L28
        L20:
            e = move-exception;
            e.printStackTrace();     // Catch: Throwable -> L18
            r6 = null;
        L18:
            th = move-exception;
            throw th;
        L53:
            r8 = null;
            goto L54
        }

        public String toString() {
            return "LockInfo{timestamp=" + this.f8937a + ", duration=" + this.f8938b + ", rawAtrace='" + this.f8939c + "', topActivityName='" + this.f8940d + "', blockStackInfo='" + this.f8941e + "', completeBlockStackInfo='" + this.f + "', ownerStackInfo='" + this.g + "', lockThreadName='" + this.i + "', ownerThreadName='" + this.h + "'}";
        }

        public void b(String r1) {
            this.f = r1;
        }

        public void c(String r2) {
            if (r2 != null) goto L4;
            return;
        L4:
            if (r2.isEmpty() == true) goto L8;
            this.g = r2;
            return;
        }

        @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
        public static int a(String r1, String r2) {
            if (com.obric.aiagent.apm.impl.a.a() == false) goto L5;
            return 0;
        L5:
            return Log.d(r1, r2);
        }
    }

    public interface b {
        void a(List<a> r1);
    }

    public LockMonitorManager() {
    }

    static /* synthetic */ JSONObject access$000(a r0, JSONObject r1) {
        return packJsonData(r0, r1);
    }

    static /* synthetic */ void access$1000(String r0) {
        getThreadStack(r0);
    }

    static /* synthetic */ boolean access$300() {
        return openFetchStack;
    }

    static /* synthetic */ BlockingQueue access$400() {
        return sStackBlockingQueue;
    }

    static /* synthetic */ String access$500() {
        return lastJavaStack;
    }

    static /* synthetic */ String access$502(String r0) {
        lastJavaStack = r0;
        return r0;
    }

    static /* synthetic */ BlockingQueue access$600() {
        return sOwnerStackBlockingQueue;
    }

    static /* synthetic */ String access$700() {
        return lastOwnerJavaStack;
    }

    static /* synthetic */ String access$702(String r0) {
        lastOwnerJavaStack = r0;
        return r0;
    }

    static /* synthetic */ void access$800(a r0) {
        enqueue(r0);
    }

    static /* synthetic */ boolean access$900() {
        return isAllThread;
    }

    static {
        lockInfoQueue = new a[100];
        sStackBlockingQueue = new LinkedBlockingQueue();
        sOwnerStackBlockingQueue = new LinkedBlockingQueue();
        sLockHandler = Executors.newSingleThreadExecutor(new AnonymousClass1());
        sStackFetcher = Executors.newSingleThreadExecutor(new AnonymousClass2());
        isLockMonitoring = false;
    }

    public static void startLockDetect() {
        startLockDetect(30);
    }

    public static void startLockDetect(long r2) {
        if (isLockMonitoring == false) goto L5;
        return;
    L5:
        isLockMonitoring = true;
        if (com.bytedance.apm.c.e() == false) goto L9;
        k.a().a(r2, false);
        return;
    }

    public static void startLockDetect(long r1, boolean r3) {
        if (isLockMonitoring == false) goto L5;
        return;
    L5:
        isLockMonitoring = true;
        isAllThread = r3;
        if (com.bytedance.apm.c.e() == false) goto L9;
        k.a().a(r1, r3);
        return;
    }

    public static void endLockDetect(JSONObject r2) {
        if (isLockMonitoring == true) goto L5;
        return;
    L5:
        isLockMonitoring = false;
        r2.put(KEY_IS_LOCK, true);     // Catch: JSONException -> L8
        r2.put(KEY_IS_ALL_THREAD, isAllThread);     // Catch: JSONException -> L8
    L11:
        if (com.bytedance.apm.c.e() == false) goto L16;
        reportLockInfo(r2);
        k.a().j();
        return;
    L16:
        return;
    L8:
        e = move-exception;
        e.printStackTrace();
        goto L11
    }

    public static void reportLockInfo(final JSONObject r1) {
        dumpLockInfo(new AnonymousClass3(r1));
    }

    public static void dumpLockInfo(b r2) {
        final b r3 = (b) ZeusTransformUtils.wrapperContextForParams(r2, b.class, "com.obric.aiagent.plugin");
        com.bytedance.apm.thread.b.a().a(new AnonymousClass4(r3));
    }

    private static JSONObject packJsonData(a r7, JSONObject r8) {
        JSONObject r1 = new JSONObject();
        r1.put(DBHelper.COL_TIME, r7.f8937a);     // Catch: JSONException -> L16
        r1.put("crash_time", r7.f8937a);     // Catch: JSONException -> L16
        r1.put("is_main_process", com.bytedance.apm.c.d());     // Catch: JSONException -> L16
        r1.put("process_name", com.bytedance.apm.c.c());     // Catch: JSONException -> L16
        r1.put("block_duration", r7.f8938b);     // Catch: JSONException -> L16
        r1.put(KEY_RAW_DUMP_INFO, r7.f8939c);     // Catch: JSONException -> L16
        StringBuilder r2 = new StringBuilder();     // Catch: JSONException -> L16
        if (TextUtils.isEmpty(a.a(r7)) == true) goto L7;
        r2.append(a.a(r7).replace("\t", "")).append("\n");     // Catch: JSONException -> L16
    L7:
        r2.append("-OwnerThread: ").append(r7.c()).append("\n");     // Catch: JSONException -> L16
        r2.append("-OwnerStack: ").append(r7.b()).append("\n");     // Catch: JSONException -> L16
        r2.append("-WaiterStack: ").append(r7.a()).append("\n");     // Catch: JSONException -> L16
        r2.append("-RawAtrace: ").append(r7.f8939c).append("\n");     // Catch: JSONException -> L16
        r2.append("-LockThread: ").append(r7.d()).append("\n");     // Catch: JSONException -> L16
        if (a.b(r7) == null) goto L10;
        r2.append("-Activity: ").append(a.b(r7)).append("\n");     // Catch: JSONException -> L16
    L10:
        JSONObject r9 = com.bytedance.apm6.perf.base.c.a().c();     // Catch: JSONException -> L16
        r9.put("block_stack_type", "stack");     // Catch: JSONException -> L16
        Iterator<String> r3 = r8.keys();     // Catch: JSONException -> L16
    L12:
        if (r3.hasNext() == false) goto L14;
        String r4 = (String) ZeusTransformUtils.preCheckCast(r3.next(), String.class, "com.obric.aiagent.plugin");     // Catch: JSONException -> L16
        r9.put(r4, r8.get(r4));     // Catch: JSONException -> L16
        goto L12
    L14:
        r1.put("filters", r9);     // Catch: JSONException -> L16
        r1.put("stack", r2.toString());     // Catch: JSONException -> L16
        r1.put("event_type", "lag");     // Catch: JSONException -> L16
        return r1;
    L16:
        e = move-exception;
        e.printStackTrace();
        return null;
    }

    public static void setOpenFetchStack(boolean r0) {
        openFetchStack = r0;
        if (r0 == true) goto L6;
        lastJavaStack = null;
        lastOwnerJavaStack = null;
        return;
    }

    private static void enqueue(a r2) {
        if (r2 != null) goto L4;
        return;
    L4:
        a[] r0 = lockInfoQueue;
        int r1 = position;
        r0[r1] = r2;
        position = (r1 + 1) % 100;
    }

    private static void nativePut(final String r2) {
        sLockHandler.execute(new AnonymousClass5(r2));
    }

    private static void getOwnerStack(String r6) {
        if (r6 != null) goto L4;
        return;
    L4:
        if (r6.isEmpty() == true) goto L27;
        ThreadGroup r0 = Looper.getMainLooper().getThread().getThreadGroup();
        int r1 = r0.activeCount();
        int r2 = r1 + (r1 / 2);
        Thread[] r3 = new Thread[r2];
        r0.enumerate(r3);
        int r4 = 0;
    L7:
        if (r4 >= r2) goto L28;
        final Thread r5 = r3[r4];
        if (r5 == null) goto L29;
        if (r5 == Thread.currentThread()) goto L19;
        if (r5.getName().contains(r6) == false) goto L19;
        if (openFetchStack == false) goto L19;
        sStackFetcher.execute(new AnonymousClass6(r5));
    L19:
        r4 = r4 + 1;
        goto L7
    L29:
        return;
    L28:
        return;
    }

    private static void getThreadStack(String r6) {
        if (r6 != null) goto L4;
        return;
    L4:
        if (r6.isEmpty() == true) goto L23;
        ThreadGroup r0 = Looper.getMainLooper().getThread().getThreadGroup();
        int r1 = r0.activeCount();
        int r2 = r1 + (r1 / 2);
        Thread[] r3 = new Thread[r2];
        r0.enumerate(r3);
        int r4 = 0;
    L7:
        if (r4 >= r2) goto L24;
        final Thread r5 = r3[r4];
        if (r5 == null) goto L25;
        if (r5.getName().contains(r6) == false) goto L16;
        if (openFetchStack == false) goto L16;
        sStackFetcher.execute(new AnonymousClass7(r5));
    L16:
        r4 = r4 + 1;
        goto L7
    L25:
        return;
    L24:
        return;
    }

    private static void nativeGetJavaStack(String r2, final String r3) {
        if (openFetchStack == false) goto L22;
        sStackFetcher.execute(new AnonymousClass8(r3));
        if (r2 != null) goto L7;
        return;
    L7:
        if (r2.isEmpty() == true) goto L30;
        int r4 = r2.indexOf("monitor contention with owner");
        if (r4 > 0) goto L12;
        return;
    L12:
        if (r4 >= r2.length()) goto L25;
        String r5 = r2.substring(r4);
        int r0 = r5.indexOf("(") - 1;
        if (r0 > 0) goto L16;
        return;
    L16:
        if (30 < r5.length()) goto L18;
        return;
    L18:
        if (r0 >= r5.length()) goto L28;
        if (30 >= r0) goto L29;
        getOwnerStack(r5.substring(30, r0));
        return;
    L29:
        return;
    L28:
        return;
    L25:
        return;
    L30:
        return;
    }

    public static List<a> dumpLockInfo() {
        LinkedList r0 = new LinkedList();
        int r1 = 0;
    L4:
        if (r1 >= 100) goto L9;
        int r3 = (((position + 100) - r1) - 1) % 100;
        a[] r2 = lockInfoQueue;
        a r4 = r2[r3];
        r2[r3] = null;
        if (r4 == null) goto L8;
        r0.add(r4);
    L8:
        r1 = r1 + 1;
        goto L4
    L9:
        return r0;
    }

    public static String dumpLockInfo(long r9, long r11) {
        a[] r1 = new a[100];
        int r3 = 0;
        System.arraycopy(lockInfoQueue, 0, r1, 0, 100);
        ArrayList r2 = new ArrayList();
    L3:
        if (r3 >= 100) goto L17;
        a r4 = r1[((position + r3) + 1) % 100];
        if (r4 == null) goto L15;
        if (r4.f8937a >= r11) goto L10;
    L11:
        r2.add(r4);
    L13:
        if ((r4.f8937a + r4.f8938b) >= r9) goto L15;
    L10:
        if ((r4.f8937a + r4.f8938b) <= r9) goto L13;
    L15:
        r3 = r3 + 1;
    L17:
        return r2.toString();
    }
}
