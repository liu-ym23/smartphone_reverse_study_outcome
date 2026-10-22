package com.bytedance.applog.log;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadThreadV2;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes6.dex */
public final class g extends PthreadThreadV2 implements Handler.Callback {

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public static final a f192461z = null;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final Map<String, List<d>> f192462v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final int f192463w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final LinkedList<c> f192464x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public Handler f192465y;

    public static class a extends com.bytedance.applog.log.b<g> {
        public a() {
        }

        @Override // com.bytedance.applog.log.b
        public final g a(Object[] r100) {
            return new g();
        }
    }

    /* JADX INFO: loaded from: classes14.dex */
    public interface b {
        Object fetch();
    }

    /* JADX INFO: loaded from: classes14.dex */
    public static class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f192466a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Object f192467b;

        public c(String r100, Object r101) {
            this.f192466a = r100;
            this.f192467b = r101;
        }
    }

    /* JADX INFO: loaded from: classes14.dex */
    public interface d {
        void a();
    }

    static {
        f192461z = new a();
    }

    public g() {
        super("/log/EventBus");
        this.f192462v = new ConcurrentHashMap();
        this.f192463w = 1000;
        this.f192464x = new LinkedList();
        ThreadMethodProxy.start(this);
    }

    @Override // com.ss.android.ugc.bytex.pthread.base.proxy.PthreadThreadV2, java.lang.Thread, java.lang.Runnable
    public final void run() {
        super.run();     // Catch: Throwable -> L4
        Looper.prepare();     // Catch: Throwable -> L4
        this.f192465y = new Handler(this);     // Catch: Throwable -> L4
        Looper.loop();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }

    public final void f(c r100) {
        Map<String, List<d>> r101 = this.f192462v;
        ConcurrentHashMap r102 = (ConcurrentHashMap) r101;
        List r103 = (List) r102.get(r100.f192466a);
        if (r103 != null) goto L5;
        return;
    L5:
        HashSet r104 = new HashSet();
    L41:
        th = move-exception;
        th.printStackTrace();
        return;
    L8:
        if ("applog_event_upload_eid".equals(r100.f192466a) == false) goto L17;
        Object r105 = r100.f192467b;     // Catch: Throwable -> L41
        if ((r105 instanceof JSONObject) == false) goto L17;
        if (((JSONObject) r105).has("$$EVENT_LOCAL_IDS") == false) goto L17;
        Object r106 = ((JSONObject) r100.f192467b).opt("$$EVENT_LOCAL_IDS");     // Catch: Throwable -> L41
        if ((r106 instanceof Collection) == false) goto L25;
        r104.addAll((Collection) r106);     // Catch: Throwable -> L41
    L25:
        byte[] r107 = null;
    L26:
        Iterator r108 = r103.iterator();     // Catch: Throwable -> L41
    L27:
        if (r108.hasNext() == false) goto L55;
        d r109 = (d) r108.next();     // Catch: Throwable -> L41
        if ((r100.f192467b instanceof JSONObject) == false) goto L39;
        JSONObject r110 = new JSONObject(r100.f192467b.toString());     // Catch: JSONException -> L38 Throwable -> L41
    L32:
        if (r104.isEmpty() == true) goto L34;
        r110.put("$$EVENT_LOCAL_IDS", r104);     // Catch: JSONException -> L38 Throwable -> L41
    L34:
        if (r107 == null) goto L36;
        r110.put("responseByte", r107);     // Catch: JSONException -> L38 Throwable -> L41
    L36:
        r109.a();     // Catch: JSONException -> L38 Throwable -> L41
    L38:
        r109.a();     // Catch: Throwable -> L41
        goto L27
    L39:
        r109.a();     // Catch: Throwable -> L41
        goto L27
    L55:
        return;
    L17:
        if ("applog_do_request_end".equals(r100.f192466a) == false) goto L25;
        Object r111 = r100.f192467b;     // Catch: Throwable -> L41
        if ((r111 instanceof JSONObject) == false) goto L25;
        if (((JSONObject) r111).has("responseByte") == false) goto L25;
        Object r112 = ((JSONObject) r100.f192467b).opt("responseByte");     // Catch: Throwable -> L41
        if ((r112 instanceof byte[]) == false) goto L25;
        r107 = (byte[]) ((byte[]) r112).clone();     // Catch: Throwable -> L41
        goto L26
    }

    @Override // android.os.Handler.Callback
    public final boolean handleMessage(Message r100) {
        if (r100.what != 1) goto L5;
        f((c) r100.obj);
    L5:
        return true;
    }

    public final void a(String r100, b r101) {
        if (TextUtils.isEmpty(r100) == true) goto L24;
        c r102 = new c(r100, r101.fetch());
        if (((ConcurrentHashMap) this.f192462v).containsKey(r100) == true) goto L17;
        LinkedList<c> r103 = this.f192464x;
        monitor-enter(r103);
    L14:
        th = move-exception;
        throw th;
    L9:
        if (this.f192464x.size() < this.f192463w) goto L11;
        this.f192464x.poll();     // Catch: Throwable -> L14
    L11:
        this.f192464x.add(r102);     // Catch: Throwable -> L14
        monitor-exit(r103);     // Catch: Throwable -> L14
        return;
    L17:
        Handler r104 = this.f192465y;
        if (r104 == null) goto L20;
        r104.sendMessage(r104.obtainMessage(1, r102));
        return;
    L20:
        f(r102);
        return;
    }

    public final void e(String r100, Object r101) {
        if (TextUtils.isEmpty(r100) == false) goto L5;
        return;
    L5:
        c r102 = new c(r100, r101);
        if (((ConcurrentHashMap) this.f192462v).containsKey(r100) == true) goto L18;
        LinkedList<c> r103 = this.f192464x;
        monitor-enter(r103);
    L15:
        th = move-exception;
        throw th;
    L10:
        if (this.f192464x.size() < this.f192463w) goto L12;
        this.f192464x.poll();     // Catch: Throwable -> L15
    L12:
        this.f192464x.add(r102);     // Catch: Throwable -> L15
        monitor-exit(r103);     // Catch: Throwable -> L15
        return;
    L18:
        Handler r104 = this.f192465y;
        if (r104 == null) goto L21;
        r104.sendMessage(r104.obtainMessage(1, r102));
        return;
    L21:
        f(r102);
    }
}
