package com.bytedance.applog.log;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class EventBus extends Thread implements Handler.Callback {
    private static final int EMIT_EVENT_MSG = 1;
    public static com.bytedance.applog.log.a<EventBus> global;
    private final LinkedList<b> cache;
    private Handler eventHandler;
    private int maxCacheEventSize;
    private final Map<String, List<c>> subscriptionMap;

    public interface a {
        Object a();
    }

    private static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        String f5696a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        Object f5697b;

        b(String r1, Object r2) {
            this.f5696a = r1;
            this.f5697b = r2;
        }
    }

    public interface c {
        void a(Object r1);
    }

    static {
        global = new AnonymousClass1();
    }

    public EventBus() {
        this.subscriptionMap = new ConcurrentHashMap();
        this.maxCacheEventSize = 1000;
        this.cache = new LinkedList();
        start();
    }

    public void setMaxCacheEventSize(int r1) {
        this.maxCacheEventSize = r1;
    }

    public void emit(String r2, Object r3) {
        if (TextUtils.isEmpty(r2) == false) goto L5;
        return;
    L5:
        b r0 = new b(r2, r3);
        if (this.subscriptionMap.containsKey(r2) == true) goto L8;
        cache(r0);
        return;
    L8:
        emit(r0);
    }

    public void emit(String r3, a r4) {
        a r5 = (a) ZeusTransformUtils.wrapperContextForParams(r4, a.class, "com.obric.aiagent.plugin");
        if (TextUtils.isEmpty(r3) == true) goto L11;
        if (r5 == null) goto L13;
        b r0 = new b(r3, r5.a());
        if (this.subscriptionMap.containsKey(r3) == true) goto L9;
        cache(r0);
        return;
    L9:
        emit(r0);
        return;
    L13:
        return;
    }

    public synchronized void listen(String r4, c r5) {
        monitor-enter(this);
        c r6 = (c) ZeusTransformUtils.wrapperContextForParams(r5, c.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L9
        List<c> r0 = (List) ZeusTransformUtils.preCheckCast(this.subscriptionMap.get(r4), List.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L9
        if (r0 != null) goto L6;
        r0 = new ArrayList();     // Catch: Throwable -> L9
    L6:
        r0.add(r6);     // Catch: Throwable -> L9
        this.subscriptionMap.put(r4, r0);     // Catch: Throwable -> L9
        handleCache();     // Catch: Throwable -> L9
        monitor-exit(this);
        return;
    L9:
        th = move-exception;
        throw th;
    }

    public synchronized void remove(String r4, c r5) {
        monitor-enter(this);
        c r6 = (c) ZeusTransformUtils.wrapperContextForParams(r5, c.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L16
        List<c> r0 = (List) ZeusTransformUtils.preCheckCast(this.subscriptionMap.get(r4), List.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L16
        if (r0 != null) goto L6;
    L14:
        monitor-exit(this);
        return;
    L6:
        if (r0.contains(r6) == false) goto L14;
        r0.remove(r6);     // Catch: Throwable -> L16
        if (r0.size() != 0) goto L11;
        this.subscriptionMap.remove(r4);     // Catch: Throwable -> L16
    L12:
        monitor-exit(this);
        return;
    L11:
        this.subscriptionMap.put(r4, r0);     // Catch: Throwable -> L16
    L16:
        th = move-exception;
        throw th;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        super.run();
        Looper.prepare();
        this.eventHandler = new Handler(this);
        Looper.loop();
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message r4) {
        if (r4.what != 1) goto L5;
        emitEvent((b) ZeusTransformUtils.preCheckCast(r4.obj, b.class, "com.obric.aiagent.plugin"));
    L5:
        return true;
    }

    private void emit(b r2) {
        Handler r0 = this.eventHandler;
        if (r0 == null) goto L5;
        r0.sendMessage(r0.obtainMessage(1, r2));
        return;
    L5:
        emitEvent(r2);
    }

    private void emitEvent(b r9) {
        List r8 = (List) ZeusTransformUtils.preCheckCast(this.subscriptionMap.get(r9.f5696a), List.class, "com.obric.aiagent.plugin");
        if (r8 != null) goto L5;
        return;
    L5:
        HashSet r1 = new HashSet();
        byte[] r3 = null;
    L40:
        th = move-exception;
        th.printStackTrace();
        return;
    L8:
        if ("applog_event_upload_eid".equals(r9.f5696a) == false) goto L17;
        if (ZeusTransformUtils.instanceOf(r9.f5697b, JSONObject.class) == false) goto L17;
        if (((JSONObject) ZeusTransformUtils.preCheckCast(r9.f5697b, JSONObject.class, "com.obric.aiagent.plugin")).has("$$EVENT_LOCAL_IDS") == false) goto L17;
        Object r0 = ((JSONObject) ZeusTransformUtils.preCheckCast(r9.f5697b, JSONObject.class, "com.obric.aiagent.plugin")).opt("$$EVENT_LOCAL_IDS");     // Catch: Throwable -> L40
        if (ZeusTransformUtils.instanceOf(r0, Collection.class) == false) goto L25;
        r1.addAll((Collection) ZeusTransformUtils.preCheckCast(r0, Collection.class, "com.obric.aiagent.plugin"));     // Catch: Throwable -> L40
    L25:
        Iterator r10 = r8.iterator();     // Catch: Throwable -> L40
    L26:
        if (r10.hasNext() == false) goto L54;
        c r2 = (c) ZeusTransformUtils.preCheckCast(r10.next(), c.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L40
        if (ZeusTransformUtils.instanceOf(r9.f5697b, JSONObject.class) == false) goto L38;
        JSONObject r4 = new JSONObject(r9.f5697b.toString());     // Catch: JSONException -> L37 Throwable -> L40
    L31:
        if (r1.isEmpty() == true) goto L33;
        r4.put("$$EVENT_LOCAL_IDS", r1);     // Catch: JSONException -> L37 Throwable -> L40
    L33:
        if (r3 == null) goto L35;
        r4.put("responseByte", r3);     // Catch: JSONException -> L37 Throwable -> L40
    L35:
        r2.a(r4);     // Catch: JSONException -> L37 Throwable -> L40
    L37:
        r2.a(r9.f5697b);     // Catch: Throwable -> L40
        goto L26
    L38:
        r2.a(r9.f5697b);     // Catch: Throwable -> L40
        goto L26
    L54:
        return;
    L17:
        if ("applog_do_request_end".equals(r9.f5696a) == false) goto L25;
        if (ZeusTransformUtils.instanceOf(r9.f5697b, JSONObject.class) == false) goto L25;
        if (((JSONObject) ZeusTransformUtils.preCheckCast(r9.f5697b, JSONObject.class, "com.obric.aiagent.plugin")).has("responseByte") == false) goto L25;
        Object r5 = ((JSONObject) ZeusTransformUtils.preCheckCast(r9.f5697b, JSONObject.class, "com.obric.aiagent.plugin")).opt("responseByte");     // Catch: Throwable -> L40
        if ((r5 instanceof byte[]) == false) goto L25;
        r3 = (byte[]) ZeusTransformUtils.preCheckCast(((byte[]) ZeusTransformUtils.preCheckCast((byte[]) ZeusTransformUtils.preCheckCast(r5, byte[].class, "com.obric.aiagent.plugin"), byte[].class, "com.obric.aiagent.plugin")).clone(), byte[].class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L40
        goto L25
    }

    private void cache(b r4) {
        LinkedList<b> r0 = this.cache;
        monitor-enter(r0);
    L10:
        th = move-exception;
        throw th;
    L5:
        if (this.cache.size() < this.maxCacheEventSize) goto L7;
        this.cache.poll();     // Catch: Throwable -> L10
    L7:
        this.cache.add(r4);     // Catch: Throwable -> L10
        monitor-exit(r0);     // Catch: Throwable -> L10
    }

    private void handleCache() {
        LinkedList<b> r0 = this.cache;
        monitor-enter(r0);
        ArrayList r1 = new ArrayList(this.cache);     // Catch: Throwable -> L10
        this.cache.clear();     // Catch: Throwable -> L10
        Iterator r2 = r1.iterator();     // Catch: Throwable -> L10
    L6:
        if (r2.hasNext() == false) goto L8;
        emit((b) ZeusTransformUtils.preCheckCast(r2.next(), b.class, "com.obric.aiagent.plugin"));     // Catch: Throwable -> L10
        goto L6
    L8:
        monitor-exit(r0);     // Catch: Throwable -> L10
        return;
    L10:
        th = move-exception;
        throw th;
    }
}
