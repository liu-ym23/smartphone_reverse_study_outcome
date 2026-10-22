package com.bytedance.monitor.collector;

import android.annotation.SuppressLint;
import android.os.Looper;
import android.os.Process;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.Keep;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;
import com.bytedance.apm.constant.CommonKey;
import com.bytedance.apm.thread.AsyncEventManager;
import com.bytedance.apm6.service.lifecycle.ActivityLifecycleService;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@Keep
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
    private static i[] lockInfoQueue = null;
    private static volatile boolean openFetchStack = false;
    private static int position;

    @SuppressLint({"CI_NotAllowInvokeExecutorsMethods"})
    private static ExecutorService sLockHandler;
    private static final BlockingQueue<String> sOwnerStackBlockingQueue = null;
    private static final BlockingQueue<String> sStackBlockingQueue = null;

    @SuppressLint({"CI_NotAllowInvokeExecutorsMethods"})
    private static ExecutorService sStackFetcher;

    public interface LockInfoFetchListener {
        @WorkerThread
        void onData(@Nullable List<i> r10);
    }

    public static class a implements ThreadFactory {
        public a() {
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable r10) {
            Thread r11 = new Thread(r10);
            r11.setName(LockMonitorManager.LOCK_THREAD_NAME);
            return r11;
        }
    }

    public static class b implements ThreadFactory {
        public b() {
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable r10) {
            Thread r11 = new Thread(r10);
            Process.setThreadPriority(-20);
            r11.setName(LockMonitorManager.STACK_THREAD_NAME);
            return r11;
        }
    }

    public static class c implements LockInfoFetchListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ JSONObject f7719a;

        public c(JSONObject r10) {
            this.f7719a = r10;
        }

        @Override // com.bytedance.monitor.collector.LockMonitorManager.LockInfoFetchListener
        public void onData(List r10) {
            if (r10 != null) goto L5;
            return;
        L5:
            if (w0.c.B() == false) goto L7;
            Log.d(LockMonitorManager.TAG, "dumpLockInfo size -> " + r10.size());
        L7:
            Iterator r11 = r10.iterator();
        L9:
            if (r11.hasNext() == false) goto L22;
            i r12 = (i) r11.next();
            JSONObject r13 = LockMonitorManager.access$000(r12, this.f7719a);     // Catch: Throwable -> L17
            if (r13 == null) goto L9;
            if (w0.c.B() == false) goto L19;
            Log.d(LockMonitorManager.TAG, "lock report LockInfo: " + r12);     // Catch: Throwable -> L17
        L19:
            m1.d r14 = new m1.d("block_monitor", r13, r12.f7727a);     // Catch: Throwable -> L17
            r14.b();     // Catch: Throwable -> L17
            l1.a.p().e(r14);     // Catch: Throwable -> L17
        L17:
            th = move-exception;
            Log.e(LockMonitorManager.TAG, "onData: parse lock info failed: " + th.getLocalizedMessage());
            goto L9
        }
    }

    public static class d implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ LockInfoFetchListener f7720a;

        public d(LockInfoFetchListener r10) {
            this.f7720a = r10;
        }

        @Override // java.lang.Runnable
        public void run() {
            LockInfoFetchListener r10 = this.f7720a;     // Catch: Throwable -> L8
            if (r10 == null) goto L6;
            r10.onData(LockMonitorManager.dumpLockInfo());     // Catch: Throwable -> L8
        L10:
            return;
        L6:
            r10.onData(null);     // Catch: Throwable -> L8
        L8:
            this.f7720a.onData(null);
        }
    }

    public static class e implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f7721a;

        public class a implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ i f7722a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ e f7723b;

            public a(e r10, i r11) {
                this.f7723b = r10;
                this.f7722a = r11;
            }

            @Override // java.lang.Runnable
            public void run() {
                LockMonitorManager.access$800(this.f7722a);
            }
        }

        public e(String r10) {
            this.f7721a = r10;
        }

        @Override // java.lang.Runnable
        public void run() {
            i r10 = i.c(this.f7721a);     // Catch: Throwable -> L6
            if (r10 == null) goto L9;
            AsyncEventManager.e().h(new a(this, r10));     // Catch: Throwable -> L6
            return;
        L9:
            return;
        }
    }

    public static class f implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Thread f7724a;

        public f(Thread r10) {
            this.f7724a = r10;
        }

        @Override // java.lang.Runnable
        public void run() {
            String r10 = g5.h.c(this.f7724a.getStackTrace());     // Catch: Throwable -> L15
            BlockingQueue r11 = LockMonitorManager.access$600();     // Catch: Throwable -> L15
            monitor-enter(r11);     // Catch: Throwable -> L15
        L7:
            th = move-exception;
            throw th;     // Catch: Throwable -> L15
            goto L20
        L5:
            if (LockMonitorManager.access$600().size() == 0) goto L9;
            LockMonitorManager.access$600().clear();     // Catch: Throwable -> L7
        L9:
            LockMonitorManager.access$600().put(r10);     // Catch: Throwable -> L7
            monitor-exit(r11);     // Catch: Throwable -> L7
            goto L20
        L14:
            return;
        }
    }

    public static class g implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Thread f7725a;

        public g(Thread r10) {
            this.f7725a = r10;
        }

        @Override // java.lang.Runnable
        public void run() {
            String r10 = g5.h.c(this.f7725a.getStackTrace());     // Catch: Throwable -> L15
            BlockingQueue r11 = LockMonitorManager.access$400();     // Catch: Throwable -> L15
            monitor-enter(r11);     // Catch: Throwable -> L15
        L7:
            th = move-exception;
            throw th;     // Catch: Throwable -> L15
            goto L20
        L5:
            if (LockMonitorManager.access$400().size() == 0) goto L9;
            LockMonitorManager.access$400().clear();     // Catch: Throwable -> L7
        L9:
            LockMonitorManager.access$400().put(r10);     // Catch: Throwable -> L7
            monitor-exit(r11);     // Catch: Throwable -> L7
            goto L20
        L14:
            return;
        }
    }

    public static class h implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f7726a;

        public h(String r10) {
            this.f7726a = r10;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (LockMonitorManager.access$900() == false) goto L5;
            LockMonitorManager.access$1000(this.f7726a);     // Catch: Throwable -> L18
            return;
        L5:
            String r10 = g5.h.c(Looper.getMainLooper().getThread().getStackTrace());     // Catch: Throwable -> L18
            BlockingQueue r11 = LockMonitorManager.access$400();     // Catch: Throwable -> L18
            monitor-enter(r11);     // Catch: Throwable -> L18
        L10:
            th = move-exception;
            throw th;     // Catch: Throwable -> L18
        L8:
            if (LockMonitorManager.access$400().size() == 0) goto L12;
            LockMonitorManager.access$400().clear();     // Catch: Throwable -> L10
        L12:
            LockMonitorManager.access$400().put(r10);     // Catch: Throwable -> L10
            monitor-exit(r11);     // Catch: Throwable -> L10
            goto L23
        L22:
            return;
        }
    }

    public static class i {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final long f7727a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final long f7728b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final String f7729c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public String f7730d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public String f7731e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public String f7732f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public String f7733g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public String f7734h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public String f7735i;

        public i(long r10, long r11, String r12, String r13) {
            this.f7730d = "unknown";
            this.f7727a = r10;
            this.f7728b = r11;
            this.f7729c = r12;
            this.f7735i = r13;
            h(r12);
            ActivityLifecycleService r14 = (ActivityLifecycleService) o3.a.a(ActivityLifecycleService.class);
            if (r14 == null) goto L8;
            String r15 = r14.getTopActivityClassName();
            if (TextUtils.isEmpty(r15) == true) goto L9;
            this.f7730d = r15;
            return;
        L9:
            return;
        }

        public static /* synthetic */ String a(i r10) {
            return r10.f7732f;
        }

        public static /* synthetic */ String b(i r10) {
            return r10.f7730d;
        }

        public static i c(String r10) {
            String r11 = null;
            if (r10 != null) goto L5;
        L61:
            return null;
        L5:
            if (r10.isEmpty() == true) goto L61;
            Log.d("lockDetect", "" + r10);
            String[] r12 = r10.split(LockMonitorManager.DELIMITER);
            if (r12.length == 4) goto L11;
            Log.d("lockDetect", "spiltData != 4" + r10);
            return null;
        L11:
            long r13 = Long.parseLong(r12[0]);
            long r14 = Long.parseLong(r12[1]);
            String r15 = r12[2];
            i r16 = new i(r13, r14, r15, r12[3]);
            if (LockMonitorManager.access$300() == false) goto L53;
            BlockingQueue r17 = LockMonitorManager.access$400();
            monitor-enter(r17);
            String r18 = (String) LockMonitorManager.access$400().poll(200, TimeUnit.MILLISECONDS);     // Catch: Throwable -> L18 InterruptedException -> L20
        L22:
            if (r18 == null) goto L24;
        L26:
            LockMonitorManager.access$502(r18);     // Catch: Throwable -> L18
        L28:
            if (LockMonitorManager.access$400().isEmpty() == true) goto L30;
            LockMonitorManager.access$400().clear();     // Catch: Throwable -> L18
        L30:
            monitor-exit(r17);     // Catch: Throwable -> L18
            BlockingQueue r19 = LockMonitorManager.access$600();
            monitor-enter(r19);
            r11 = (String) LockMonitorManager.access$600().poll(200, TimeUnit.MILLISECONDS);     // Catch: Throwable -> L35 InterruptedException -> L37
        L39:
            if (r11 == null) goto L41;
        L43:
            LockMonitorManager.access$702(r18);     // Catch: Throwable -> L35
        L45:
            if (LockMonitorManager.access$600().isEmpty() == true) goto L47;
            LockMonitorManager.access$600().clear();     // Catch: Throwable -> L35
        L47:
            monitor-exit(r19);     // Catch: Throwable -> L35
            String r20 = r11;
            r11 = r18;
        L54:
            if (r11 != null) goto L56;
        L58:
            if (r20 == null) goto L60;
            r16.j(r20);
        L60:
            return r16;
        L56:
            if (r15.contains(g5.h.a(r11)) == false) goto L58;
            r16.i(r11);
            goto L58
        L41:
            if (LockMonitorManager.access$700() == null) goto L43;
            r11 = LockMonitorManager.access$700();     // Catch: Throwable -> L35
            goto L45
        L37:
            e = move-exception;
            e.printStackTrace();     // Catch: Throwable -> L35
        L35:
            th = move-exception;
            throw th;
        L24:
            if (LockMonitorManager.access$500() == null) goto L26;
            r18 = LockMonitorManager.access$500();     // Catch: Throwable -> L18
            goto L28
        L18:
            th = move-exception;
            throw th;
        L20:
            e = move-exception;
            e.printStackTrace();     // Catch: Throwable -> L18
            r18 = null;
            goto L22
        L53:
            r20 = null;
            goto L54
        }

        public String d() {
            return this.f7731e;
        }

        public String e() {
            return this.f7735i;
        }

        public String f() {
            return this.f7733g;
        }

        public String g() {
            return this.f7734h;
        }

        public final void h(String r10) {
            String r11 = r10.substring(r10.indexOf("monitor contention with owner"));
            this.f7734h = r11.substring(30, r11.indexOf("(") - 1);
            int r12 = r11.indexOf(" at ");
            if (r12 == (-1)) goto L5;
            String r13 = r11.substring(r12 + 5, r11.indexOf("waiters=", r12));
            String r14 = r13.substring(r13.indexOf(" "));
            this.f7733g = r14.substring(1, r14.indexOf("(")) + r14.substring(r14.indexOf(")") + 1, r14.lastIndexOf(")") + 1);
        L5:
            String r15 = r11.substring(r11.indexOf("blocking from") + 14);
            String r16 = r15.substring(r15.indexOf(" ") + 1);
            this.f7731e = r16.substring(0, r16.indexOf("(")) + r16.substring(r16.indexOf(")") + 1, r16.lastIndexOf(")") + 1);
        }

        public void i(String r10) {
            this.f7732f = r10;
        }

        public void j(String r10) {
            if (r10 != null) goto L4;
            return;
        L4:
            if (r10.isEmpty() == true) goto L8;
            this.f7733g = r10;
            return;
        }

        public String toString() {
            return "LockInfo{timestamp=" + this.f7727a + ", duration=" + this.f7728b + ", rawAtrace='" + this.f7729c + "', topActivityName='" + this.f7730d + "', blockStackInfo='" + this.f7731e + "', completeBlockStackInfo='" + this.f7732f + "', ownerStackInfo='" + this.f7733g + "', lockThreadName='" + this.f7735i + "', ownerThreadName='" + this.f7734h + "'}";
        }
    }

    static {
        lockInfoQueue = new i[100];
        sStackBlockingQueue = new LinkedBlockingQueue();
        sOwnerStackBlockingQueue = new LinkedBlockingQueue();
        sLockHandler = Executors.newSingleThreadExecutor(new a());
        sStackFetcher = Executors.newSingleThreadExecutor(new b());
        isLockMonitoring = false;
    }

    public LockMonitorManager() {
    }

    public static /* synthetic */ JSONObject access$000(i r10, JSONObject r11) {
        return packJsonData(r10, r11);
    }

    public static /* synthetic */ void access$1000(String r10) {
        getThreadStack(r10);
    }

    public static /* synthetic */ boolean access$300() {
        return openFetchStack;
    }

    public static /* synthetic */ BlockingQueue access$400() {
        return sStackBlockingQueue;
    }

    public static /* synthetic */ String access$500() {
        return lastJavaStack;
    }

    public static /* synthetic */ String access$502(String r10) {
        lastJavaStack = r10;
        return r10;
    }

    public static /* synthetic */ BlockingQueue access$600() {
        return sOwnerStackBlockingQueue;
    }

    public static /* synthetic */ String access$700() {
        return lastOwnerJavaStack;
    }

    public static /* synthetic */ String access$702(String r10) {
        lastOwnerJavaStack = r10;
        return r10;
    }

    public static /* synthetic */ void access$800(i r10) {
        enqueue(r10);
    }

    public static /* synthetic */ boolean access$900() {
        return isAllThread;
    }

    public static void dumpLockInfo(LockInfoFetchListener r10) {
        AsyncEventManager.e().h(new d(r10));
    }

    public static void endLockDetect(@NonNull JSONObject r10) {
        if (isLockMonitoring == true) goto L5;
        return;
    L5:
        isLockMonitoring = false;
        r10.put(KEY_IS_LOCK, true);     // Catch: JSONException -> L8
        r10.put(KEY_IS_ALL_THREAD, isAllThread);     // Catch: JSONException -> L8
    L11:
        if (w0.c.G() == false) goto L16;
        reportLockInfo(r10);
        PerfMonitorManager.o().m();
        return;
    L16:
        return;
    L8:
        e = move-exception;
        e.printStackTrace();
        goto L11
    }

    @WorkerThread
    private static void enqueue(i r10) {
        if (r10 != null) goto L4;
        return;
    L4:
        i[] r11 = lockInfoQueue;
        int r12 = position;
        r11[r12] = r10;
        position = (r12 + 1) % 100;
    }

    private static void getOwnerStack(String r10) {
        if (r10 != null) goto L4;
        return;
    L4:
        if (r10.isEmpty() == true) goto L27;
        ThreadGroup r11 = Looper.getMainLooper().getThread().getThreadGroup();
        int r12 = r11.activeCount();
        int r13 = r12 + (r12 / 2);
        Thread[] r14 = new Thread[r13];
        r11.enumerate(r14);
        int r15 = 0;
    L7:
        if (r15 >= r13) goto L28;
        Thread r16 = r14[r15];
        if (r16 == null) goto L29;
        if (r16 == Thread.currentThread()) goto L19;
        if (r16.getName().contains(r10) == false) goto L19;
        if (openFetchStack == false) goto L19;
        sStackFetcher.execute(new f(r16));
    L19:
        r15 = r15 + 1;
        goto L7
    L29:
        return;
    L28:
        return;
    }

    private static void getThreadStack(String r10) {
        if (r10 != null) goto L4;
        return;
    L4:
        if (r10.isEmpty() == true) goto L23;
        ThreadGroup r11 = Looper.getMainLooper().getThread().getThreadGroup();
        int r12 = r11.activeCount();
        int r13 = r12 + (r12 / 2);
        Thread[] r14 = new Thread[r13];
        r11.enumerate(r14);
        int r15 = 0;
    L7:
        if (r15 >= r13) goto L24;
        Thread r16 = r14[r15];
        if (r16 == null) goto L25;
        if (r16.getName().contains(r10) == false) goto L16;
        if (openFetchStack == false) goto L16;
        sStackFetcher.execute(new g(r16));
    L16:
        r15 = r15 + 1;
        goto L7
    L25:
        return;
    L24:
        return;
    }

    @Keep
    @WorkerThread
    private static void nativeGetJavaStack(String r10, String r11) {
        if (openFetchStack == false) goto L22;
        sStackFetcher.execute(new h(r11));
        if (r10 != null) goto L7;
        return;
    L7:
        if (r10.isEmpty() == true) goto L30;
        int r12 = r10.indexOf("monitor contention with owner");
        if (r12 > 0) goto L12;
        return;
    L12:
        if (r12 >= r10.length()) goto L25;
        String r13 = r10.substring(r12);
        int r14 = r13.indexOf("(") - 1;
        if (r14 > 0) goto L16;
        return;
    L16:
        if (30 < r13.length()) goto L18;
        return;
    L18:
        if (r14 >= r13.length()) goto L28;
        if (30 >= r14) goto L29;
        getOwnerStack(r13.substring(30, r14));
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

    @Keep
    @WorkerThread
    private static void nativePut(String r10) {
        sLockHandler.execute(new e(r10));
    }

    private static JSONObject packJsonData(i r10, JSONObject r11) {
        JSONObject r12 = new JSONObject();
        r12.put("timestamp", r10.f7727a);     // Catch: JSONException -> L7
        r12.put(CommonKey.KEY_CRASH_TIME, r10.f7727a);     // Catch: JSONException -> L7
        r12.put("is_main_process", w0.c.F());     // Catch: JSONException -> L7
        r12.put("process_name", w0.c.h());     // Catch: JSONException -> L7
        r12.put("block_duration", r10.f7728b);     // Catch: JSONException -> L7
        r12.put(KEY_RAW_DUMP_INFO, r10.f7729c);     // Catch: JSONException -> L7
        StringBuilder r13 = new StringBuilder();     // Catch: JSONException -> L7
        if (TextUtils.isEmpty(i.a(r10)) == true) goto L9;
        r13.append(i.a(r10).replace("\t", ""));     // Catch: JSONException -> L7
        r13.append("\n");     // Catch: JSONException -> L7
    L9:
        r13.append("-OwnerThread: ");     // Catch: JSONException -> L7
        r13.append(r10.g());     // Catch: JSONException -> L7
        r13.append("\n");     // Catch: JSONException -> L7
        r13.append("-OwnerStack: ");     // Catch: JSONException -> L7
        r13.append(r10.f());     // Catch: JSONException -> L7
        r13.append("\n");     // Catch: JSONException -> L7
        r13.append("-WaiterStack: ");     // Catch: JSONException -> L7
        r13.append(r10.d());     // Catch: JSONException -> L7
        r13.append("\n");     // Catch: JSONException -> L7
        r13.append("-RawAtrace: ");     // Catch: JSONException -> L7
        r13.append(r10.f7729c);     // Catch: JSONException -> L7
        r13.append("\n");     // Catch: JSONException -> L7
        r13.append("-LockThread: ");     // Catch: JSONException -> L7
        r13.append(r10.e());     // Catch: JSONException -> L7
        r13.append("\n");     // Catch: JSONException -> L7
        if (i.b(r10) == null) goto L12;
        r13.append("-Activity: ");     // Catch: JSONException -> L7
        r13.append(i.b(r10));     // Catch: JSONException -> L7
        r13.append("\n");     // Catch: JSONException -> L7
    L12:
        JSONObject r14 = m3.c.a().getPerfFiltersJson();     // Catch: JSONException -> L7
        r14.put("block_stack_type", "stack");     // Catch: JSONException -> L7
        Iterator<String> r15 = r11.keys();     // Catch: JSONException -> L7
    L14:
        if (r15.hasNext() == false) goto L16;
        String r16 = r15.next();     // Catch: JSONException -> L7
        r14.put(r16, r11.get(r16));     // Catch: JSONException -> L7
        goto L14
    L16:
        r12.put("filters", r14);     // Catch: JSONException -> L7
        r12.put("stack", r13.toString());     // Catch: JSONException -> L7
        r12.put("event_type", "lag");     // Catch: JSONException -> L7
        return r12;
    L7:
        e = move-exception;
        e.printStackTrace();
        return null;
    }

    public static void reportLockInfo(JSONObject r10) {
        dumpLockInfo(new c(r10));
    }

    public static void setOpenFetchStack(boolean r10) {
        openFetchStack = r10;
        if (r10 == true) goto L6;
        lastJavaStack = null;
        lastOwnerJavaStack = null;
        return;
    }

    public static void startLockDetect() {
        startLockDetect(30);
    }

    @WorkerThread
    public static List<i> dumpLockInfo() {
        LinkedList r10 = new LinkedList();
        int r11 = 0;
    L4:
        if (r11 >= 100) goto L9;
        int r12 = (((position + 100) - r11) - 1) % 100;
        i[] r13 = lockInfoQueue;
        i r14 = r13[r12];
        r13[r12] = null;
        if (r14 == null) goto L8;
        r10.add(r14);
    L8:
        r11 = r11 + 1;
        goto L4
    L9:
        return r10;
    }

    public static void startLockDetect(long r10) {
        if (isLockMonitoring == false) goto L5;
        return;
    L5:
        isLockMonitoring = true;
        if (w0.c.G() == false) goto L9;
        PerfMonitorManager.o().B(r10, false);
        return;
    }

    public static void startLockDetect(long r10, boolean r11) {
        if (isLockMonitoring == false) goto L5;
        return;
    L5:
        isLockMonitoring = true;
        isAllThread = r11;
        if (w0.c.G() == false) goto L9;
        PerfMonitorManager.o().B(r10, r11);
        return;
    }

    public static String dumpLockInfo(long r10, long r11) {
        i[] r12 = new i[100];
        int r13 = 0;
        System.arraycopy(lockInfoQueue, 0, r12, 0, 100);
        ArrayList r14 = new ArrayList();
    L3:
        if (r13 >= 100) goto L17;
        i r15 = r12[((position + r13) + 1) % 100];
        if (r15 == null) goto L15;
        long r16 = r15.f7727a;
        if (r16 >= r11) goto L10;
    L11:
        r14.add(r15);
    L13:
        if ((r15.f7727a + r15.f7728b) >= r10) goto L15;
    L10:
        if ((r16 + r15.f7728b) <= r10) goto L13;
    L15:
        r13 = r13 + 1;
    L17:
        return r14.toString();
    }
}
