package com.bytedance.apm.block;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Looper;
import android.text.TextUtils;
import com.byted.cast.linkcommon.cybergarage.upnp.device.ST;
import com.bytedance.apm.PerfConfig;
import com.bytedance.apm.constant.UploadTypeInf;
import com.bytedance.apm.core.ActivityLifeObserver;
import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.bytedance.common.util.JellyBeanV16Compat;
import com.bytedance.common.utility.Logger;
import com.bytedance.monitor.collector.MonitorType;
import com.bytedance.sliver.Sliver;
import com.larus.apm.impl.protector.RunnableProtector;
import com.miui.easygo.constant.EasyGoConstant;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.util.LinkedList;
import java.util.concurrent.TimeoutException;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes14.dex */
public final class k {

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static volatile k f190357t;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public bt3.f f190358a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public volatile boolean f190359b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public volatile boolean f190360c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public long f190361d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public long f190362e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f190363f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f190364g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final StringBuilder f190365h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final StringBuilder f190366i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final StringBuilder f190367j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public c f190368k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public c f190369l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public volatile boolean f190370m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public boolean f190371n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public boolean f190372o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final LinkedList<js3.c> f190373p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public boolean f190374q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final a f190375r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final b f190376s;

    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ k f190377a;

        public final void a() {
            c r100 = this.f190377a.f190368k;
            if (r100 != null) goto L44;
            return;
        L44:
            r100.a();     // Catch: Throwable -> L24
            int r101 = 0;
            if (this.f190377a.f190374q == false) goto L31;
            String r102 = Sliver.getStackTrace(ThreadMethodProxy.getLooperThread(Looper.getMainLooper()));     // Catch: Throwable -> L24
            if (r102.contains(this.f190377a.f190364g) == false) goto L11;
            return;
        L11:
            String[] r103 = r102.split("\\)\\n");     // Catch: Throwable -> L24
            this.f190377a.f190365h.setLength(0);     // Catch: Throwable -> L24
            int r104 = r103.length;     // Catch: Throwable -> L24
        L12:
            if (r101 >= r104) goto L27;
            String r105 = r103[r101];     // Catch: Throwable -> L24
            String r106 = "";
            char[] r107 = r105.toCharArray();     // Catch: Throwable -> L24
            if (r107 == null) goto L26;
            if (r107.length == 0) goto L26;
            if (r107[r107.length - 1] != '(') goto L23;
            String[] r108 = r105.split(EasyGoConstant.VERSION_SEPARATIVE_SIGN);     // Catch: Throwable -> L24
            int r109 = r108.length;     // Catch: Throwable -> L24
            if (r109 <= 2) goto L23;
            r106 = r108[r109 - 2];     // Catch: Throwable -> L24
        L23:
            StringBuilder r110 = this.f190377a.f190365h;     // Catch: Throwable -> L24
            r110.append("\tat " + r105);     // Catch: Throwable -> L24
            r110.append(r106);     // Catch: Throwable -> L24
            r110.append(".java:1");     // Catch: Throwable -> L24
            r110.append(")\n");     // Catch: Throwable -> L24
        L26:
            r101 = r101 + 1;     // Catch: Throwable -> L24
            goto L12
        L27:
            k r111 = this.f190377a;     // Catch: Throwable -> L24
            r111.f190368k.f190336q = r111.f190365h.toString();     // Catch: Throwable -> L24
            if (com.bytedance.apm.d.j() == false) goto L50;
            Logger.e("StackThread", "block detected: " + this.f190377a.f190365h.toString());     // Catch: Throwable -> L24
            return;
        L50:
            return;
        L31:
            StackTraceElement[] r112 = ThreadMethodProxy.getLooperThread(Looper.getMainLooper()).getStackTrace();     // Catch: Throwable -> L24
            if (r112[0].getClassName().startsWith(this.f190377a.f190364g) == false) goto L34;
            return;
        L34:
            this.f190377a.f190368k.f190332m = System.currentTimeMillis();     // Catch: Throwable -> L24
            this.f190377a.f190368k.f190334o = r112;     // Catch: Throwable -> L24
            if (com.bytedance.apm.d.j() == false) goto L37;
            b(r112);     // Catch: Throwable -> L24
        L37:
            this.f190377a.f190365h.setLength(0);     // Catch: Throwable -> L24
            int r113 = r112.length;     // Catch: Throwable -> L24
        L38:
            if (r101 >= r113) goto L40;
            StackTraceElement r114 = r112[r101];     // Catch: Throwable -> L24
            StringBuilder r115 = this.f190377a.f190365h;     // Catch: Throwable -> L24
            r115.append("\tat " + r114.getClassName());     // Catch: Throwable -> L24
            r115.append(".");     // Catch: Throwable -> L24
            r115.append(r114.getMethodName());     // Catch: Throwable -> L24
            r115.append("(");     // Catch: Throwable -> L24
            r115.append(r114.getFileName());     // Catch: Throwable -> L24
            r115.append(":");     // Catch: Throwable -> L24
            r115.append(r114.getLineNumber());     // Catch: Throwable -> L24
            r115.append(")\n");     // Catch: Throwable -> L24
            r101 = r101 + 1;     // Catch: Throwable -> L24
            goto L38
        L40:
            k r116 = this.f190377a;     // Catch: Throwable -> L24
            r116.f190368k.f190336q = r116.f190365h.toString();     // Catch: Throwable -> L24
            return;
        L24:
            th = move-exception;
            com.bytedance.apm.k.b.f190610a.c(th, "block_deal_exception");
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public a(k r100) {
            this.f190377a = r100;
        }

        public final void b(StackTraceElement[] r100) {
            TimeoutException r101 = new TimeoutException("main thread task execute more than " + this.f190377a.f190361d + "ms");
            r101.setStackTrace(r100);
            Logger.e("StackThread", "block detected", r101);
        }
    }

    public class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ k f190378a;

        public final void a() {
            k r100 = this.f190378a;     // Catch: Throwable -> L26
            if (r100.f190368k != null) goto L5;
            return;
        L5:
            int r101 = 0;
            if (r100.f190374q == false) goto L28;
            String r102 = Sliver.getStackTrace(ThreadMethodProxy.getLooperThread(Looper.getMainLooper()));     // Catch: Throwable -> L26
            if (r102.contains(this.f190378a.f190364g) == false) goto L10;
            return;
        L10:
            String[] r103 = r102.split("\\)\\n");     // Catch: Throwable -> L26
            this.f190378a.f190366i.setLength(0);     // Catch: Throwable -> L26
            int r104 = r103.length;     // Catch: Throwable -> L26
        L11:
            if (r101 >= r104) goto L24;
            String r105 = r103[r101];     // Catch: Throwable -> L26
            String r106 = "";
            char[] r107 = r105.toCharArray();     // Catch: Throwable -> L26
            if (r107 == null) goto L23;
            if (r107.length == 0) goto L23;
            if (r107[r107.length - 1] != '(') goto L22;
            String[] r108 = r105.split(EasyGoConstant.VERSION_SEPARATIVE_SIGN);     // Catch: Throwable -> L26
            int r109 = r108.length;     // Catch: Throwable -> L26
            if (r109 <= 2) goto L22;
            r106 = r108[r109 - 2];     // Catch: Throwable -> L26
        L22:
            StringBuilder r110 = this.f190378a.f190366i;     // Catch: Throwable -> L26
            r110.append("\tat " + r105);     // Catch: Throwable -> L26
            r110.append(r106);     // Catch: Throwable -> L26
            r110.append(".java:1");     // Catch: Throwable -> L26
            r110.append(")\n");     // Catch: Throwable -> L26
        L23:
            r101 = r101 + 1;     // Catch: Throwable -> L26
            goto L11
        L24:
            k r111 = this.f190378a;     // Catch: Throwable -> L26
            r111.f190368k.f190336q = r111.f190366i.toString();     // Catch: Throwable -> L26
            this.f190378a.f190368k.f190333n = System.currentTimeMillis();     // Catch: Throwable -> L26
            c r112 = this.f190378a.f190368k;     // Catch: Throwable -> L26
            ss3.e.b().getClass();     // Catch: Throwable -> L26
            r112.f190340u = ss3.e.a();     // Catch: Throwable -> L26
            k r113 = this.f190378a;     // Catch: Throwable -> L26
            r113.f190368k.f190341v = k.d(r113);     // Catch: Throwable -> L26
            this.f190378a.f190368k.f190329j = true;     // Catch: Throwable -> L26
            return;
        L28:
            StackTraceElement[] r114 = ThreadMethodProxy.getLooperThread(Looper.getMainLooper()).getStackTrace();     // Catch: Throwable -> L26
            if (r114[0].getClassName().startsWith(this.f190378a.f190364g) == false) goto L31;
            return;
        L31:
            this.f190378a.f190368k.f190333n = System.currentTimeMillis();     // Catch: Throwable -> L26
            c r115 = this.f190378a.f190368k;     // Catch: Throwable -> L26
            r115.f190335p = r114;     // Catch: Throwable -> L26
            ss3.e.b().getClass();     // Catch: Throwable -> L26
            r115.f190340u = ss3.e.a();     // Catch: Throwable -> L26
            k r116 = this.f190378a;     // Catch: Throwable -> L26
            r116.f190368k.f190341v = k.d(r116);     // Catch: Throwable -> L26
            this.f190378a.f190368k.f190329j = true;     // Catch: Throwable -> L26
            return;
        L26:
            th = move-exception;
            com.bytedance.apm.k.b.f190610a.c(th, "serious_block_deal_exception");
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public b(k r100) {
            this.f190378a = r100;
        }
    }

    public k() {
        this.f190359b = false;
        this.f190360c = false;
        this.f190361d = 2500;
        this.f190362e = 5000;
        this.f190363f = true;
        this.f190365h = new StringBuilder(1200);
        this.f190366i = new StringBuilder(1200);
        this.f190367j = new StringBuilder(1200);
        this.f190369l = null;
        this.f190370m = false;
        this.f190371n = true;
        this.f190372o = true;
        this.f190373p = new LinkedList();
        this.f190374q = false;
        this.f190375r = new a(this);
        this.f190376s = new b(this);
        this.f190364g = k.class.getName();
    }

    public static JSONObject d(k r100) {
        r100.getClass();
        JSONObject r101 = new JSONObject();     // Catch: Exception -> L8
        Context r102 = com.bytedance.apm.d.getContext();     // Catch: Exception -> L8
        if (r102 == null) goto L6;
        ActivityManager r103 = (ActivityManager) r102.getSystemService("activity");     // Catch: Exception -> L8
        ActivityManager.MemoryInfo r104 = new ActivityManager.MemoryInfo();     // Catch: Exception -> L8
        r103.getMemoryInfo(r104);     // Catch: Exception -> L8
        r101.put("availMem", r104.availMem);     // Catch: Exception -> L8
        r101.put("lowMemory", r104.lowMemory);     // Catch: Exception -> L8
        r101.put("threshold", r104.threshold);     // Catch: Exception -> L8
        r101.put("totalMem", JellyBeanV16Compat.getTotalMem(r104));     // Catch: Exception -> L8
    L6:
        Runtime r105 = Runtime.getRuntime();     // Catch: Exception -> L8
        r101.put("max_memory", r105.maxMemory());     // Catch: Exception -> L8
        r101.put("free_memory", r105.freeMemory());     // Catch: Exception -> L8
        r101.put("total_memory", r105.totalMemory());     // Catch: Exception -> L8
        return r101;
    L8:
        return null;
    }

    public static JSONObject g(c r100) {
        long r101 = r100.f190327h - r100.f190326g;
        JSONObject r102 = new JSONObject();
        r102.put("timestamp", r100.f190328i);     // Catch: JSONException -> L5
        r102.put("crash_time", r100.f190328i);     // Catch: JSONException -> L5
        r102.put(LocationMonitorConst.IS_MAIN_PROCESS, com.bytedance.apm.d.k());     // Catch: JSONException -> L5
        r102.put("process_name", com.bytedance.apm.d.c());     // Catch: JSONException -> L5
        r102.put("block_duration", r101);     // Catch: JSONException -> L5
        r102.put("last_scene", r100.f190338s);     // Catch: JSONException -> L5
    L7:
        return r102;
    L5:
        e = move-exception;
        e.printStackTrace();
        goto L7
    }

    public final void e(js3.c r100) {
    L3:
        if (this.f190373p.size() == 0) goto L13;
        if ((r100.f500213d - this.f190373p.getFirst().f500213d) < 0) goto L12;
        if ((r100.f500213d - this.f190373p.getFirst().f500213d) > 60000) goto L12;
        if (this.f190373p.size() <= 60) goto L13;
        this.f190373p.removeFirst();
    L12:
        this.f190373p.removeFirst();
    L13:
        this.f190373p.addLast(r100);
    }

    public final void h(boolean r110) {
        if (this.f190358a.f20550d == null) goto L5;
        boolean r100 = true;
    L6:
        if (r100 == false) goto L74;
        c r101 = this.f190369l;     // Catch: Exception -> L71
        if (r101 == null) goto L12;
        if (r110 == false) goto L11;
        r101.f190325f = true;     // Catch: Exception -> L71
    L11:
        bt3.b.d.f20539a.e(new l(this, r101));     // Catch: Exception -> L71
        this.f190369l = null;     // Catch: Exception -> L71
    L12:
        c r102 = this.f190368k;     // Catch: Exception -> L71
        if (r102 != null) goto L15;
        return;
    L15:
        if (r102.f190326g >= 0) goto L17;
        return;
    L17:
        if (r102.f190327h != (-1)) goto L77;
        r102.f190327h = b27.a.f17028b;     // Catch: Exception -> L71
        if (this.f190363f == false) goto L22;
        this.f190358a.a(this.f190375r);     // Catch: Exception -> L71
        this.f190358a.a(this.f190376s);     // Catch: Exception -> L71
    L22:
        c r103 = this.f190368k;     // Catch: Exception -> L71
        if ((r103.f190327h - r103.f190326g) <= this.f190361d) goto L78;
        String r104 = g.a();     // Catch: Exception -> L71
        if (TextUtils.isEmpty(r104) == false) goto L27;
        r103.f190338s = ActivityLifeObserver.getInstance().getTopActivityClassName();     // Catch: Exception -> L71
    L28:
        this.f190368k.f190328i = System.currentTimeMillis();     // Catch: Exception -> L71
        if (this.f190363f == true) goto L31;
        this.f190368k.f190331l = true;     // Catch: Exception -> L71
    L31:
        c r105 = this.f190368k;     // Catch: Exception -> L71
        r105.f190323d = r110;     // Catch: Exception -> L71
        r105.f190322c = false;     // Catch: Exception -> L71
        c r106 = new c(r105.f190326g, r105.f190321b);     // Catch: Exception -> L71
        r106.f190327h = r105.f190327h;     // Catch: Exception -> L71
        boolean r107 = r105.f190320a;     // Catch: Exception -> L71
        r106.f190320a = r107;     // Catch: Exception -> L71
        r106.f190322c = false;     // Catch: Exception -> L71
        r106.f190323d = r110;     // Catch: Exception -> L71
        r106.f190324e = r105.f190324e;     // Catch: Exception -> L71
        r106.f190325f = r105.f190325f;     // Catch: Exception -> L71
        r106.f190328i = r105.f190328i;     // Catch: Exception -> L71
        r106.f190329j = r105.f190329j;     // Catch: Exception -> L71
        r106.f190330k = r105.f190330k;     // Catch: Exception -> L71
        r106.f190332m = r105.f190332m;     // Catch: Exception -> L71
        r106.f190333n = r105.f190333n;     // Catch: Exception -> L71
        r106.f190334o = r105.f190334o;     // Catch: Exception -> L71
        r106.f190335p = r105.f190335p;     // Catch: Exception -> L71
        r106.f190336q = r105.f190336q;     // Catch: Exception -> L71
        r106.f190337r = r105.f190337r;     // Catch: Exception -> L71
        r106.f190338s = r105.f190338s;     // Catch: Exception -> L71
        r106.f190339t = r105.f190339t;     // Catch: Exception -> L71
        r106.f190340u = r105.f190340u;     // Catch: Exception -> L71
        r106.f190341v = r105.f190341v;     // Catch: Exception -> L71
        r106.f190342w = r105.f190342w;     // Catch: Exception -> L71
        r106.f190331l = r105.f190331l;     // Catch: Exception -> L71
        if (r107 == true) goto L35;
        r106.a();     // Catch: Exception -> L71
    L35:
        if ((r106.f190327h - r106.f190326g) < this.f190362e) goto L37;
        boolean r108 = true;
    L38:
        r106.f190329j = r108;     // Catch: Exception -> L71
        com.bytedance.monitor.collector.b.e r109 = com.bytedance.monitor.collector.c.e().f();     // Catch: Exception -> L71
        if (r109 == null) goto L61;
        StackTraceElement[] r111 = r106.f190334o;     // Catch: Exception -> L71
        if (r111 != null) goto L45;
        r111 = new StackTraceElement[]{new StackTraceElement("Invalid Stack\n", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "a.java", 1)};     // Catch: Exception -> L71
    L45:
        if (r106.f190329j == false) goto L50;
        StackTraceElement[] r112 = r106.f190335p;     // Catch: Exception -> L71
        if (r112 != null) goto L52;
        r112 = new StackTraceElement[]{new StackTraceElement("Invalid Stack\n", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "a.java", 1)};     // Catch: Exception -> L71
    L52:
        if (TextUtils.isEmpty(ST.UUID_DEVICE) == true) goto L54;
        r109.f265635m = ST.UUID_DEVICE;     // Catch: Exception -> L71
    L54:
        r109.f265632j = r111;     // Catch: Exception -> L71
        if (r112 == null) goto L58;
        r109.f265633k = r112;     // Catch: Exception -> L71
    L58:
        if (TextUtils.isEmpty(null) == true) goto L61;
        r109.f265634l = null;     // Catch: Exception -> L71
        goto L61
    L50:
        r112 = null;
    L61:
        if (r106.f190330k == false) goto L63;
        bt3.b.d.f20539a.e(new l(this, r106));     // Catch: Exception -> L71
    L64:
        c r113 = this.f190368k;     // Catch: Exception -> L71
        if ((r113.f190327h - r113.f190326g) <= this.f190362e) goto L79;
        if (r110 == true) goto L68;
        return;
    L68:
        if (this.f190370m == false) goto L81;
        h.b();     // Catch: Exception -> L71
        return;
    L81:
        return;
    L79:
        return;
    L63:
        this.f190369l = r106;     // Catch: Exception -> L71
        goto L64
    L37:
        r108 = false;
        goto L38
    L27:
        r103.f190338s = r104 + "," + ActivityLifeObserver.getInstance().getTopActivityClassName();     // Catch: Exception -> L71
        goto L28
    L78:
        return;
    L77:
        return;
    L74:
        return;
    L5:
        r100 = false;
    }

    public static void c(k r100, c r101, String r102) throws JSONException {
        if (PerfConfig.f190311a == false) goto L5;
        r100.getClass();
        JSONObject r103 = g(r101);
        JSONObject r104 = ou3.a.a().c(true);
        r104.put("crash_section", com.bytedance.apm.d.i(r101.f190328i));
        r104.put("belong_frame", String.valueOf(r101.f190323d));
        r104.put("belong_dump", String.valueOf(r101.f190322c));
        r104.put("block_stack_type", "messageKey");
        r103.put("filters", r104);
        r103.put("event_type", "lag");
        r103.put("stack", "at " + r102 + ".*(a.java:-1)");
        js3.c r105 = new js3.c("block_monitor", r103);
        r105.f500212c = true;
        is3.a.h().b(r105);
        return;
    L5:
        r100.getClass();
    }

    public static JSONObject f(boolean r100, c r101, String r102) throws JSONException {
        JSONObject r103 = ou3.a.a().c(true);
        r103.put("crash_section", com.bytedance.apm.d.i(r101.f190328i));
        r103.put("belong_frame", String.valueOf(r100));
        r103.put("belong_dump", String.valueOf(r101.f190322c));
        r103.put("block_input", String.valueOf(r101.f190324e));
        r103.put("block_frame", String.valueOf(r101.f190325f));
        r103.put("block_message", r102);
        r103.put("block_stack_type", "stack");
        r103.put("buuid", r101.f190337r);
        r103.put("belong_poll_once", String.valueOf(r101.f190330k));
        return r103;
    }

    public static void a(k r100, boolean r101, c r102, String r103) throws JSONException {
        if (r100.f190371n == false) goto L7;
        JSONObject r104 = g(r102);
        r104.put("stack", r102.f190336q);
        r104.put("message", r103);
        r104.put("ignore_stack", r100.f190368k.f190331l);
        r104.put("event_type", "lag");
        r104.put("filters", f(r101, r102, r103));
        r104.put("custom", new JSONObject());
        js3.c r105 = new js3.c("block_monitor", r104, r102.f190326g);
        r100.e(r105);
        is3.a.h().b(r105);
        return;
    }

    public static void b(k r110, c r111, String r112, boolean r210) throws JSONException {
        if (r110.f190372o == false) goto L79;
        Logger.e("StackThread", "reportSeriousBlock :" + r111.f190336q);
        JSONObject r100 = f(r111.f190323d, r111, r112);
        r100.put("sbuuid", "empty");
        JSONObject r101 = g(r111);
        r101.put("message", r112);
        StackTraceElement[] r102 = r111.f190334o;
        if (r102 == null) goto L70;
        StackTraceElement[] r103 = r111.f190335p;
        if (r103 == null) goto L70;
        int r104 = r102.length;
        int r105 = r103.length;
        int r106 = 0;
        int r113 = 0;
    L11:
        if (r106 >= Math.min(r104, r105)) goto L46;
        boolean r114 = true;
        int r115 = (r104 - r106) - 1;
        int r116 = (r105 - r106) - 1;
        if (r111.f190334o[r115].equals(r111.f190335p[r116]) == false) goto L14;
        r113 = r113 + 1;
        r106 = r106 + 1;
        goto L11
    L14:
        StackTraceElement r107 = r111.f190334o[r115];
        StackTraceElement r117 = r111.f190335p[r116];
        if (r107 == r117) goto L42;
        if (r107 == null) goto L41;
        if (r117 == null) goto L41;
        if (r107.getClassName().equals(r117.getClassName()) == false) goto L41;
        String r118 = r107.getMethodName();
        String r119 = r117.getMethodName();
        if (r118 == r119) goto L29;
        if (r118 != null) goto L26;
    L28:
        boolean r120 = false;
    L30:
        if (r120 == false) goto L41;
        String r108 = r107.getFileName();
        String r121 = r117.getFileName();
        if (r108 == r121) goto L38;
        if (r108 != null) goto L35;
    L37:
        boolean r109 = false;
    L39:
        if (r109 == false) goto L41;
    L35:
        if (r108.equals(r121) == false) goto L37;
    L38:
        r109 = true;
        goto L39
    L26:
        if (r118.equals(r119) == false) goto L28;
    L29:
        r120 = true;
    L41:
        r114 = false;
    L42:
        if (r114 == false) goto L46;
        r113 = r113 + 1;
    L46:
        if (r113 != 0) goto L48;
        r100.put("serious_stack_coincide", "none");
    L51:
        JSONObject r122 = r100;
    L61:
        r110.f190367j.setLength(0);
    L62:
        if (r113 <= 0) goto L65;
        StringBuilder r123 = r110.f190367j;
        r123.append("\tat ");
        int r124 = r104 - r113;
        r123.append(r111.f190334o[r124].getClassName());
        r123.append(".");
        r123.append(r111.f190334o[r124].getMethodName());
        r123.append("(");
        r123.append(r111.f190334o[r124].getFileName());
        r123.append(":");
        r123.append(r111.f190334o[r124].getLineNumber());
        r123.append(")\n");
        r113 = r113 - 1;
        goto L62
    L65:
        if (r110.f190367j.length() != 0) goto L67;
        String r125 = r111.f190336q;
    L68:
        r101.put("stack", r125);
        r100 = r122;
        r100.put("sbuuid", r111.f190337r);
        goto L70
    L67:
        r125 = r110.f190367j.toString();
        goto L68
    L48:
        if (r113 != r104) goto L52;
        if (r113 != r105) goto L52;
        r100.put("serious_stack_coincide", "full");
    L52:
        r100.put("serious_stack_coincide", "part");
        r110.f190367j.setLength(0);
        int r126 = 0;
    L54:
        if (r126 > (r104 - r113)) goto L56;
        StringBuilder r127 = r110.f190367j;
        r127.append("\tat ");
        r127.append(r111.f190334o[r126].getClassName());
        r127.append(".");
        r127.append(r111.f190334o[r126].getMethodName());
        r127.append("(");
        r127.append(r111.f190334o[r126].getFileName());
        r127.append(":");
        r127.append(r111.f190334o[r126].getLineNumber());
        r127.append(")\n");
        r126 = r126 + 1;
        r100 = r100;
        goto L54
    L56:
        r122 = r100;
        r101.put("stack1", r110.f190367j.toString());
        r110.f190367j.setLength(0);
        int r128 = 0;
    L58:
        if (r128 > (r105 - r113)) goto L60;
        StringBuilder r129 = r110.f190367j;
        r129.append("\tat ");
        r129.append(r111.f190335p[r128].getClassName());
        r129.append(".");
        r129.append(r111.f190335p[r128].getMethodName());
        r129.append("(");
        r129.append(r111.f190335p[r128].getFileName());
        r129.append(":");
        r129.append(r111.f190335p[r128].getLineNumber());
        r129.append(")\n");
        r128 = r128 + 1;
        goto L58
    L60:
        r101.put("stack2", r110.f190367j.toString());
    L70:
        if (r110.f190374q == false) goto L72;
        r101.put("stack", r111.f190336q);
        r100.put("sbuuid", r111.f190337r);
    L72:
        r101.put("stack_cost", r111.f190333n - r111.f190332m);
        r101.put("filters", r100);
        r101.put("event_type", "serious_lag");
        r101.put(MonitorType.LOOPER_MONITOR, r111.f190339t);
        r101.put("block_cpu_info", r111.f190340u);
        r101.put("block_memory_info", r111.f190341v);
        r101.put("custom", r111.f190342w);
        r101.put("block_error_info", r210);
        js3.c r130 = new js3.c(UploadTypeInf.SERIOUS_BLOCK_MONITOR, r101, r111.f190326g);
        r110.e(r130);
        is3.a.h().b(r130);
        return;
    }
}
