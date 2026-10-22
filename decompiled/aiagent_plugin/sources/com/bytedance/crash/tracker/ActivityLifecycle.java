package com.bytedance.crash.tracker;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.Application;
import android.content.ComponentName;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import com.bytedance.crash.dumper.a.f;
import com.bytedance.crash.h;
import com.bytedance.crash.i;
import com.bytedance.crash.o.d;
import com.bytedance.crash.o.l;
import com.bytedance.crash.runtime.DefaultWorkThread;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class ActivityLifecycle {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static boolean f7751a = true;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static int f7752b = 1;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static long f7753c = -1;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static boolean f7754d;
    private static boolean f;
    private static boolean i;
    private static final String[] j = null;
    private static final String[] k = null;
    private static volatile ActivityLifecycle l;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private String f7755e;
    private boolean g;
    private int h;
    private final Map<Integer, a> m;
    private final List<a> n;
    private final b[] o;
    private final LinkedList<c> p;
    private final ArrayList<WeakReference<Activity>> q;
    private com.bytedance.crash.h.a r;

    class ActivityLifecycleCallbacks implements Application.ActivityLifecycleCallbacks {
        final /* synthetic */ ActivityLifecycle this$0;

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivitySaveInstanceState(Activity r1, Bundle r2) {
            Activity r0 = (Activity) ZeusTransformUtils.wrapperContextForParams(r1, Activity.class, "com.obric.aiagent.plugin");
        }

        ActivityLifecycleCallbacks(ActivityLifecycle r1) {
            this.this$0 = r1;
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityCreated(Activity r3, Bundle r4) {
            Activity r5 = (Activity) ZeusTransformUtils.wrapperContextForParams(r3, Activity.class, "com.obric.aiagent.plugin");
            if (r4 == null) goto L5;
            boolean r6 = true;
        L6:
            ActivityLifecycle.a(r6);
            ActivityLifecycle.a(this.this$0, 0, r5);
            ActivityLifecycle.b(true);
            ActivityLifecycle.a(this.this$0).add(new WeakReference(r5));
            com.bytedance.crash.tracker.fragment.a.a(r5);
            return;
        L5:
            r6 = false;
            goto L6
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStarted(Activity r3) {
            Activity r4 = (Activity) ZeusTransformUtils.wrapperContextForParams(r3, Activity.class, "com.obric.aiagent.plugin");
            ActivityLifecycle.a(this.this$0, 1, r4);
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityResumed(Activity r5) {
            Activity r6 = (Activity) ZeusTransformUtils.wrapperContextForParams(r5, Activity.class, "com.obric.aiagent.plugin");
            ActivityLifecycle.a(this.this$0, 2, r6);
            if (ActivityLifecycle.b(this.this$0) != null) goto L5;
            String r7 = r6.getClass().getName();
        L6:
            long r0 = System.currentTimeMillis();
            ActivityLifecycle.c(this.this$0);
            if (ActivityLifecycle.d(this.this$0) == true) goto L23;
            ActivityLifecycle.a(this.this$0, true);
            if (ActivityLifecycle.j() == false) goto L12;
            ActivityLifecycle.c(false);
            ActivityLifecycle.a(1);
            ActivityLifecycle.a(r0);
        L12:
            if (r7.equals(ActivityLifecycle.e(this.this$0)) == true) goto L15;
            return;
        L15:
            if (ActivityLifecycle.k() == false) goto L20;
            if (ActivityLifecycle.l() == true) goto L20;
            ActivityLifecycle.a(4);
            ActivityLifecycle.a(r0);
            return;
        L20:
            if (ActivityLifecycle.k() == true) goto L25;
            ActivityLifecycle.a(3);
            ActivityLifecycle.a(r0);
            return;
        L25:
            return;
        L23:
            return;
        L5:
            r7 = ActivityLifecycle.b(this.this$0).a(r6);
            goto L6
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPaused(Activity r3) {
            Activity r4 = (Activity) ZeusTransformUtils.wrapperContextForParams(r3, Activity.class, "com.obric.aiagent.plugin");
            ActivityLifecycle r0 = this.this$0;
            if (ActivityLifecycle.b(r0) != null) goto L5;
            String r1 = r4.getClass().getName();
        L6:
            ActivityLifecycle.a(r0, r1);
            ActivityLifecycle.f(this.this$0);
            if (ActivityLifecycle.g(this.this$0) != 0) goto L10;
            ActivityLifecycle.a(this.this$0, false);
            ActivityLifecycle.b(false);
        L12:
            ActivityLifecycle.a(this.this$0, 3, r4);
            return;
        L10:
            if (ActivityLifecycle.g(this.this$0) >= 0) goto L12;
            ActivityLifecycle.a(this.this$0, 0);
            ActivityLifecycle.a(this.this$0, false);
            ActivityLifecycle.b(false);
            goto L12
        L5:
            r1 = ActivityLifecycle.b(this.this$0).a(r4);
            goto L6
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStopped(Activity r3) {
            Activity r4 = (Activity) ZeusTransformUtils.wrapperContextForParams(r3, Activity.class, "com.obric.aiagent.plugin");
            ActivityLifecycle.a(this.this$0, 4, r4);
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityDestroyed(Activity r3) {
            Activity r4 = (Activity) ZeusTransformUtils.wrapperContextForParams(r3, Activity.class, "com.obric.aiagent.plugin");
            ActivityLifecycle.a(this.this$0, 5, r4);
            com.bytedance.crash.tracker.fragment.a.b(r4);
        }
    }

    private static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        String f7762a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        int f7763b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        int f7764c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        long f7765d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        long f7766e;

        public a(String r1, long r2, int r4) {
            this.f7762a = r1;
            this.f7763b = r4;
            this.f7766e = r2;
        }

        public void a(int r1, long r2) {
            this.f7764c = r1;
            this.f7765d = r2;
        }
    }

    static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        a f7767a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        long f7768b;

        b() {
        }
    }

    public static class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        a f7769a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        long f7770b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        int f7771c;

        public c() {
        }

        static /* synthetic */ String a(c r0) {
            return r0.a();
        }

        static /* synthetic */ String a(String r0) {
            return b(r0);
        }

        static /* synthetic */ void a(c r0, StringBuilder r1) {
            r0.a(r1);
        }

        void a(a r3) {
            this.f7769a = r3;
            this.f7770b = r3.f7765d;
            this.f7771c = r3.f7764c;
        }

        private void a(StringBuilder r3) {
            r3.append(this.f7770b).append(' ').append(this.f7769a.f7762a).append(' ').append(this.f7769a.f7763b).append(' ').append(this.f7771c).append('\n');
        }

        private static String b(String r6) {
            String[] r7 = r6.split(" ");
            if (r7.length == 4) goto L14;
            return null;
        L14:
            long r2 = Long.parseLong(r7[0]);     // Catch: Exception -> L13
            String r0 = r7[1];     // Catch: Exception -> L13
            int r4 = Integer.parseInt(r7[2]);     // Catch: Exception -> L13
            int r8 = Integer.parseInt(r7[3]);     // Catch: Exception -> L13
            if (r8 < 0) goto L12;
            if (r8 >= ActivityLifecycle.m().length) goto L12;
            return a(r2, r0, r4, r8);
        L12:
            return null;
        }

        private static String a(long r1, String r3, int r4, int r5) {
            return d.b(r1) + " : " + r3 + '.' + ActivityLifecycle.m()[r5] + '@' + Long.toHexString(r4);
        }

        private String a() {
            return a(this.f7770b, this.f7769a.f7762a, this.f7769a.f7763b, this.f7771c);
        }
    }

    private static String b(int r1) {
        if (r1 != 0) goto L4;
        return "onCreate";
    L4:
        if (r1 != 1) goto L6;
        return "onStart";
    L6:
        if (r1 != 2) goto L8;
        return "onResume";
    L8:
        if (r1 != 3) goto L10;
        return "onPause";
    L10:
        if (r1 != 4) goto L12;
        return "onStop";
    L12:
        if (r1 == 5) goto L15;
        return "";
    L15:
        return "onDestroy";
    }

    static /* synthetic */ int a(int r0) {
        f7752b = r0;
        return r0;
    }

    static /* synthetic */ int a(ActivityLifecycle r0, int r1) {
        r0.h = r1;
        return r1;
    }

    static /* synthetic */ long a(long r0) {
        f7753c = r0;
        return r0;
    }

    static /* synthetic */ String a(ActivityLifecycle r0, String r1) {
        r0.f7755e = r1;
        return r1;
    }

    static /* synthetic */ ArrayList a(ActivityLifecycle r0) {
        return r0.q;
    }

    static /* synthetic */ void a(ActivityLifecycle r2, int r3, Activity r4) {
        r2.a(r3, (Activity) ZeusTransformUtils.wrapperContextForParams(r4, Activity.class, "com.obric.aiagent.plugin"));
    }

    static /* synthetic */ boolean a(ActivityLifecycle r0, boolean r1) {
        r0.g = r1;
        return r1;
    }

    static /* synthetic */ boolean a(boolean r0) {
        f = r0;
        return r0;
    }

    static /* synthetic */ com.bytedance.crash.h.a b(ActivityLifecycle r0) {
        return r0.r;
    }

    static /* synthetic */ boolean b(boolean r0) {
        f7754d = r0;
        return r0;
    }

    static /* synthetic */ int c(ActivityLifecycle r2) {
        int r0 = r2.h;
        r2.h = r0 + 1;
        return r0;
    }

    static /* synthetic */ boolean c(boolean r0) {
        f7751a = r0;
        return r0;
    }

    static /* synthetic */ boolean d(ActivityLifecycle r0) {
        return r0.g;
    }

    static /* synthetic */ String e(ActivityLifecycle r0) {
        return r0.f7755e;
    }

    static /* synthetic */ int f(ActivityLifecycle r2) {
        int r0 = r2.h;
        r2.h = r0 - 1;
        return r0;
    }

    static /* synthetic */ int g(ActivityLifecycle r0) {
        return r0.h;
    }

    static /* synthetic */ boolean j() {
        return f7751a;
    }

    static /* synthetic */ boolean k() {
        return f7754d;
    }

    static /* synthetic */ boolean l() {
        return f;
    }

    static /* synthetic */ String[] m() {
        return k;
    }

    static {
        j = new String[]{"last_create_activity", "last_start_activity", "last_resume_activity", "last_pause_activity", "last_stop_activity", "last_destroy_activity"};
        k = new String[]{"onCreate", "onStart", "onResume", "onPause", "onStop", "onDestroy"};
    }

    public static void a(com.bytedance.crash.h.a r2) {
        n().r = (com.bytedance.crash.h.a) ZeusTransformUtils.wrapperContextForParams(r2, com.bytedance.crash.h.a.class, "com.obric.aiagent.plugin");
    }

    public static ArrayList<WeakReference<Activity>> a() {
        return n().q;
    }

    public static void b() {
        n();
    }

    private static ActivityLifecycle n() {
        if (l != null) goto L15;
        monitor-enter(ActivityLifecycle.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (l != null) goto L9;
        l = new ActivityLifecycle();     // Catch: Throwable -> L11
    L9:
        monitor-exit(ActivityLifecycle.class);     // Catch: Throwable -> L11
    L15:
        return l;
    }

    private ActivityLifecycle() {
        this.m = new HashMap();
        this.n = new ArrayList();
        this.o = new b[6];
        this.p = new LinkedList();
        this.q = new ArrayList();
        Application r0 = (Application) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(i.c(), "com.obric.aiagent.plugin"), Application.class, "com.obric.aiagent.plugin");
        if (Build.VERSION.SDK_INT < 24) goto L6;
        if (r0 == null) goto L6;
        r0.registerActivityLifecycleCallbacks(new ActivityLifecycleCallbacks(this));
    L6:
        h.a();
    }

    private String a(Activity r3) {
        Activity r4 = (Activity) ZeusTransformUtils.wrapperContextForParams(r3, Activity.class, "com.obric.aiagent.plugin");
        com.bytedance.crash.h.a r2 = this.r;
        if (r2 == null) goto L5;
        String r5 = r2.a(r4);
    L7:
        if (TextUtils.isEmpty(r5) == true) goto L9;
        return r5;
    L9:
        return r4.getClass().getName();
    L5:
        r5 = null;
        goto L7
    }

    public static void c() {
        i = true;
    }

    public static int d() {
        int r0 = f7752b;
        if (r0 == 1) goto L5;
        return r0;
    L5:
        if (i == false) goto L9;
        return 2;
    L9:
        return 1;
    }

    public static long e() {
        return f7753c;
    }

    private void a(int r9, Activity r10) {
        Activity r11 = (Activity) ZeusTransformUtils.wrapperContextForParams(r10, Activity.class, "com.obric.aiagent.plugin");
        long r2 = System.currentTimeMillis();
        int r0 = r11.hashCode();
        a r1 = (a) ZeusTransformUtils.preCheckCast(this.m.get(Integer.valueOf(r0)), a.class, "com.obric.aiagent.plugin");
        if (r1 != null) goto L8;
        long r4 = 0;
        if (r9 != 0) goto L7;
        r4 = r2;
    L7:
        r1 = new a(a(r11), r4, r0);
        this.m.put(Integer.valueOf(r0), r1);
    L8:
        r1.a(r9, r2);
        if (com.bytedance.crash.tracker.b.a().b() == false) goto L11;
        a(r1.f7762a, r1.f7766e, b(r9), r11.hashCode());
    L11:
        a(r1);
        b[] r12 = this.o;
        if (r12[r9] != null) goto L14;
        r12[r9] = new b();
    L14:
        this.o[r9].f7767a = r1;
        b r13 = this.o[r9];
        r13.f7768b = r1.f7765d;
        if (r9 != 5) goto L21;
        this.m.remove(Integer.valueOf(r1.f7763b));
        if (this.n.size() != 20) goto L19;
        this.n.remove(19);
    L19:
        this.n.add(r1);
        return;
    }

    public static long f() {
        return n().p();
    }

    public static boolean g() {
        if (n().m.isEmpty() == true) goto L10;
        if (n().q() == true) goto L7;
        return true;
    L7:
        return false;
    L10:
        return !o();
    }

    public static boolean h() {
        if (n().m.isEmpty() == true) goto L13;
        if (n().q() == false) goto L7;
        return false;
    L7:
        if ((System.currentTimeMillis() - f()) <= 2000) goto L10;
        return true;
    L10:
        return false;
    L13:
        return !o();
    }

    private static boolean o() {
        Context r0 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(i.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
        if (r0 != null) goto L5;
        return false;
    L5:
        String r3 = r0.getPackageName();
        ActivityManager r1 = (ActivityManager) ZeusTransformUtils.preCheckCast(r0.getSystemService("activity"), ActivityManager.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L21
        if (r1 != null) goto L10;
        return false;
    L10:
        if (Build.VERSION.SDK_INT >= 21) goto L20;
        List<ActivityManager.RunningTaskInfo> r2 = r1.getRunningTasks(1);     // Catch: Throwable -> L21
        if (r2 == null) goto L20;
        if (r2.isEmpty() == true) goto L20;
        ComponentName r4 = ((ActivityManager.RunningTaskInfo) ZeusTransformUtils.preCheckCast(r2.get(0), ActivityManager.RunningTaskInfo.class, "com.obric.aiagent.plugin")).topActivity;     // Catch: Throwable -> L21
        if (r4 == null) goto L20;
        if (r3.equals(r4.getPackageName()) == false) goto L20;
        return true;
    L20:
        return false;
    }

    private long p() {
        ArrayList r0 = new ArrayList(this.m.entrySet());
        int r8 = 0;
        long r3 = 0;
    L4:
        if (r8 >= r0.size()) goto L12;
        a r5 = (a) ZeusTransformUtils.preCheckCast(((Map.Entry) ZeusTransformUtils.preCheckCast(r0.get(r8), Map.Entry.class, "com.obric.aiagent.plugin")).getValue(), a.class, "com.obric.aiagent.plugin");
        if (r5.f7764c < 3) goto L7;
        if (r3 >= r5.f7765d) goto L11;
        r3 = r5.f7765d;
    L11:
        r8 = r8 + 1;
        goto L4
    L7:
        return 0;
    L12:
        return r3;
    }

    private boolean q() {
        ArrayList r0 = new ArrayList(this.m.entrySet());
        int r1 = 0;
    L4:
        if (r1 >= r0.size()) goto L10;
        if (((a) ZeusTransformUtils.preCheckCast(((Map.Entry) ZeusTransformUtils.preCheckCast(r0.get(r1), Map.Entry.class, "com.obric.aiagent.plugin")).getValue(), a.class, "com.obric.aiagent.plugin")).f7764c < 3) goto L7;
        r1 = r1 + 1;
        goto L4
    L7:
        return true;
    L10:
        return false;
    }

    public static void a(File r1) {
        if (h() == false) goto L6;
        com.bytedance.crash.o.i.b(r1, "background");
    L6:
        if (g() == false) goto L8;
        com.bytedance.crash.o.i.b(r1, "background_v2");
    L8:
        n().b(r1);
        n().c(r1);
        com.bytedance.crash.tracker.fragment.a.a(r1);
    }

    public static void a(JSONObject r10) {
        JSONObject r0 = new JSONObject();     // Catch: Throwable -> L22
        int r1 = 0;
    L5:
        if (r1 >= 6) goto L12;
        if (n().o[r1] == null) goto L11;
        if (n().o[r1].f7767a == null) goto L11;
        JSONObject r2 = new JSONObject();     // Catch: Throwable -> L22
        r2.put("name", n().o[r1].f7767a.f7762a);     // Catch: Throwable -> L22
        r2.put("time", n().o[r1].f7768b);     // Catch: Throwable -> L22
        r0.put(j[r1], r2);     // Catch: Throwable -> L22
    L11:
        r1 = r1 + 1;     // Catch: Throwable -> L22
        goto L5
    L12:
        ArrayList r3 = new ArrayList(n().m.entrySet());     // Catch: Throwable -> L22
        Collections.sort(r3, new AnonymousClass1());     // Catch: Throwable -> L22
        JSONArray r4 = new JSONArray();     // Catch: Throwable -> L22
        Iterator r5 = r3.iterator();     // Catch: Throwable -> L22
    L15:
        if (r5.hasNext() == false) goto L17;
        Map.Entry r6 = (Map.Entry) ZeusTransformUtils.preCheckCast(r5.next(), Map.Entry.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L22
        JSONObject r7 = new JSONObject();     // Catch: Throwable -> L22
        r7.put("name", ((a) ZeusTransformUtils.preCheckCast(r6.getValue(), a.class, "com.obric.aiagent.plugin")).f7762a);     // Catch: Throwable -> L22
        r7.put("time", ((a) ZeusTransformUtils.preCheckCast(r6.getValue(), a.class, "com.obric.aiagent.plugin")).f7766e);     // Catch: Throwable -> L22
        r4.put(r7);     // Catch: Throwable -> L22
        goto L15
    L17:
        r0.put("alive_activities", r4);     // Catch: Throwable -> L22
        Object r8 = new JSONArray();     // Catch: Throwable -> L22
        int r9 = n().n.size() - 1;     // Catch: Throwable -> L22
    L18:
        if (r9 < 0) goto L20;
        JSONObject r11 = new JSONObject();     // Catch: Throwable -> L22
        r11.put("name", ((a) ZeusTransformUtils.preCheckCast(n().n.get(r9), a.class, "com.obric.aiagent.plugin")).f7762a);     // Catch: Throwable -> L22
        r11.put("time", ((a) ZeusTransformUtils.preCheckCast(n().n.get(r9), a.class, "com.obric.aiagent.plugin")).f7765d);     // Catch: Throwable -> L22
        r9 = r9 - 1;     // Catch: Throwable -> L22
        goto L18
    L20:
        r0.put("finish_activities", r8);     // Catch: Throwable -> L22
        r10.put("activity_trace", r0);     // Catch: Throwable -> L22
        return;
    }

    public static void b(JSONObject r5) {
        JSONArray r0 = new JSONArray();
        Iterator r1 = new ArrayList(n().p).iterator();     // Catch: Exception -> L9
    L5:
        if (r1.hasNext() == false) goto L7;
        r0.put(c.a((c) ZeusTransformUtils.preCheckCast(r1.next(), c.class, "com.obric.aiagent.plugin")));     // Catch: Exception -> L9
        goto L5
    L7:
        com.bytedance.crash.entity.c.a(r5, "activity_track", r0);     // Catch: Exception -> L9
        return;
    }

    public static void a(JSONObject r4, File r5) {
        r4.put("is_background", new File(r5, "background").exists());     // Catch: Throwable -> L15
    L3:
        String r0 = com.bytedance.crash.o.i.d(new File(r5, "activity_trace.json"));
        if (r0 == null) goto L25;
        l.b(r4, new JSONObject(r0));     // Catch: Throwable -> L16
    L25:
        JSONArray r1 = new JSONArray();     // Catch: IOException -> L17
        BufferedReader r2 = new BufferedReader(new FileReader(new File(r5, "activity_track.inf")));     // Catch: IOException -> L17
    L7:
        String r3 = r2.readLine();     // Catch: IOException -> L17
        if (r3 == null) goto L12;
        String r6 = c.a(r3);     // Catch: IOException -> L17
        if (r6 == null) goto L7;
        r1.put(r6);     // Catch: IOException -> L17
        goto L7
    L12:
        com.bytedance.crash.entity.c.a(r4, "activity_track", r1);     // Catch: IOException -> L17
    L21:
        com.bytedance.crash.tracker.fragment.a.a(r4, r5);     // Catch: Throwable -> L18
        return;
    }

    public static String c(JSONObject r2) {
        JSONObject r3 = r2.optJSONObject("activity_trace");
        if (r3 == null) goto L8;
        JSONObject r4 = r3.optJSONObject(j[2]);
        if (r4 != null) goto L7;
        return null;
    L7:
        return r4.optString("name");
    L8:
        return null;
    }

    private void b(File r12) {
        f r0 = new f(r12.getAbsolutePath() + "/activity_trace.json");
        r0.a();
        r0.a("activity_trace");
        r0.a();
        int r1 = 0;
    L4:
        if (r1 >= 6) goto L11;
        b[] r2 = this.o;
        if (r2[r1] == null) goto L10;
        if (r2[r1].f7767a == null) goto L10;
        r0.a(j[r1]);
        r0.a();
        r0.a("name").b(this.o[r1].f7767a.f7762a).e();
        r0.a("time").a(this.o[r1].f7768b);
        r0.b();
        r0.e();
    L10:
        r1 = r1 + 1;
        goto L4
    L11:
        r0.a("alive_activities");
        r0.c();
        ArrayList r3 = new ArrayList(this.m.entrySet());
        Collections.sort(r3, new AnonymousClass2(this));
        Iterator r4 = r3.iterator();
        boolean r5 = true;
    L13:
        if (r4.hasNext() == false) goto L19;
        Map.Entry r6 = (Map.Entry) ZeusTransformUtils.preCheckCast(r4.next(), Map.Entry.class, "com.obric.aiagent.plugin");
        if (r5 == false) goto L17;
        r5 = false;
    L18:
        r0.a();
        r0.a("name").b(((a) ZeusTransformUtils.preCheckCast(r6.getValue(), a.class, "com.obric.aiagent.plugin")).f7762a).e();
        r0.a("time").a(((a) ZeusTransformUtils.preCheckCast(r6.getValue(), a.class, "com.obric.aiagent.plugin")).f7766e);
        r0.b();
        goto L13
    L17:
        r0.e();
        goto L18
    L19:
        r0.d().e();
        r0.a("finish_activities");
        r0.c();
        int r13 = this.n.size() - 1;
    L20:
        if (r13 < 0) goto L25;
        r0.a();
        r0.a("name").b(((a) ZeusTransformUtils.preCheckCast(this.n.get(r13), a.class, "com.obric.aiagent.plugin")).f7762a).e();
        r0.a("time").a(((a) ZeusTransformUtils.preCheckCast(this.n.get(r13), a.class, "com.obric.aiagent.plugin")).f7765d);
        r0.b();
        if (r13 == 0) goto L24;
        r0.e();
    L24:
        r13 = r13 - 1;
        goto L20
    L25:
        r0.d();
        r0.b();
        r0.b();
        r0.f();
    }

    private void c(File r5) {
        StringBuilder r4 = new StringBuilder();
        Iterator<c> r0 = n().p.iterator();
    L4:
        if (r0.hasNext() == false) goto L7;
        c.a((c) ZeusTransformUtils.preCheckCast(r0.next(), c.class, "com.obric.aiagent.plugin"), r4);
        goto L4
    L7:
        if (r4.length() != 0) goto L9;
        return;
    L9:
        com.bytedance.crash.o.i.c(new File(r5, "activity_track.inf"), r4.toString());
    }

    public static JSONArray i() {
        JSONArray r0 = new JSONArray();
        Iterator r1 = new ArrayList(n().p).iterator();
    L4:
        if (r1.hasNext() == false) goto L6;
        r0.put(c.a((c) ZeusTransformUtils.preCheckCast(r1.next(), c.class, "com.obric.aiagent.plugin")));
        goto L4
    L6:
        return r0;
    }

    void a(a r4) {
        if (this.p.size() < 50) goto L5;
        c r0 = (c) ZeusTransformUtils.preCheckCast(this.p.poll(), c.class, "com.obric.aiagent.plugin");
    L6:
        if (r0 != null) goto L8;
        r0 = new c();
    L8:
        this.p.add(r0);
        r0.a(r4);
        return;
    L5:
        r0 = null;
        goto L6
    }

    private void a(final String r9, final long r10, final String r12, final int r13) {
        DefaultWorkThread.post(new AnonymousClass3(this, r9, r12, r13, r10));
    }
}
