package com.bytedance.applog.log;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import stepos.com.android.internal.os.StatsdConfigProto;

/* loaded from: classes.dex */
public final class EventBus extends Thread implements Handler.Callback {
    private static final int EMIT_EVENT_MSG = 1;
    public static AbsSingleton<EventBus> global = new AbsSingleton<EventBus>() { // from class: com.bytedance.applog.log.EventBus.1
        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.bytedance.applog.log.AbsSingleton
        public EventBus create(Object... objArr) {
            return new EventBus();
        }
    };
    private Handler eventHandler;
    private final Map<String, List<Subscription>> subscriptionMap = new ConcurrentHashMap();
    private int maxCacheEventSize = StatsdConfigProto.TimeUnit.CTS_VALUE;
    private final LinkedList<MessageEvent> cache = new LinkedList<>();

    public interface DataFetcher {
        Object fetch();
    }

    public interface Subscription {
        void sub(Object obj);
    }

    public EventBus() {
        start();
    }

    public void setMaxCacheEventSize(int i) {
        this.maxCacheEventSize = i;
    }

    private static class MessageEvent {
        Object data;
        String event;

        MessageEvent(String str, Object obj) {
            this.event = str;
            this.data = obj;
        }
    }

    public void emit(String str, Object obj) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        MessageEvent messageEvent = new MessageEvent(str, obj);
        if (!this.subscriptionMap.containsKey(str)) {
            cache(messageEvent);
        } else {
            emit(messageEvent);
        }
    }

    public void emit(String str, DataFetcher dataFetcher) {
        if (TextUtils.isEmpty(str) || dataFetcher == null) {
            return;
        }
        MessageEvent messageEvent = new MessageEvent(str, dataFetcher.fetch());
        if (!this.subscriptionMap.containsKey(str)) {
            cache(messageEvent);
        } else {
            emit(messageEvent);
        }
    }

    public synchronized void listen(String str, Subscription subscription) {
        List<Subscription> arrayList = this.subscriptionMap.get(str);
        if (arrayList == null) {
            arrayList = new ArrayList<>();
        }
        arrayList.add(subscription);
        this.subscriptionMap.put(str, arrayList);
        handleCache();
    }

    public synchronized void remove(String str, Subscription subscription) {
        List<Subscription> list = this.subscriptionMap.get(str);
        if (list != null && list.contains(subscription)) {
            list.remove(subscription);
            if (list.size() == 0) {
                this.subscriptionMap.remove(str);
            } else {
                this.subscriptionMap.put(str, list);
            }
        }
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        super.run();
        Looper.prepare();
        this.eventHandler = new Handler(this);
        Looper.loop();
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        if (message.what == 1) {
            emitEvent((MessageEvent) message.obj);
        }
        return true;
    }

    private void emit(MessageEvent messageEvent) {
        Handler handler = this.eventHandler;
        if (handler != null) {
            handler.sendMessage(handler.obtainMessage(1, messageEvent));
        } else {
            emitEvent(messageEvent);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x007f A[Catch: all -> 0x00b4, TRY_LEAVE, TryCatch #0 {all -> 0x00b4, blocks: (B:6:0x0013, B:9:0x0021, B:11:0x0027, B:13:0x0031, B:15:0x003d, B:26:0x0075, B:27:0x0079, B:29:0x007f, B:31:0x008b, B:33:0x009c, B:35:0x00a1, B:36:0x00a4, B:39:0x00ae, B:38:0x00a8, B:16:0x0043, B:18:0x004d, B:20:0x0053, B:22:0x005d, B:24:0x0069), top: B:44:0x0013, inners: #1 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void emitEvent(com.bytedance.applog.log.EventBus.MessageEvent r8) {
        /*
            r7 = this;
            java.util.Map<java.lang.String, java.util.List<com.bytedance.applog.log.EventBus$Subscription>> r7 = r7.subscriptionMap
            java.lang.String r0 = r8.event
            java.lang.Object r7 = r7.get(r0)
            java.util.List r7 = (java.util.List) r7
            if (r7 != 0) goto Le
            goto Lb8
        Le:
            java.util.HashSet r0 = new java.util.HashSet
            r0.<init>()
            java.lang.String r1 = "applog_event_upload_eid"
            java.lang.String r2 = r8.event     // Catch: java.lang.Throwable -> Lb4
            boolean r1 = r1.equals(r2)     // Catch: java.lang.Throwable -> Lb4
            java.lang.String r2 = "responseByte"
            java.lang.String r3 = "$$EVENT_LOCAL_IDS"
            if (r1 == 0) goto L43
            java.lang.Object r1 = r8.data     // Catch: java.lang.Throwable -> Lb4
            boolean r1 = r1 instanceof org.json.JSONObject     // Catch: java.lang.Throwable -> Lb4
            if (r1 == 0) goto L43
            java.lang.Object r1 = r8.data     // Catch: java.lang.Throwable -> Lb4
            org.json.JSONObject r1 = (org.json.JSONObject) r1     // Catch: java.lang.Throwable -> Lb4
            boolean r1 = r1.has(r3)     // Catch: java.lang.Throwable -> Lb4
            if (r1 == 0) goto L43
            java.lang.Object r1 = r8.data     // Catch: java.lang.Throwable -> Lb4
            org.json.JSONObject r1 = (org.json.JSONObject) r1     // Catch: java.lang.Throwable -> Lb4
            java.lang.Object r1 = r1.opt(r3)     // Catch: java.lang.Throwable -> Lb4
            boolean r4 = r1 instanceof java.util.Collection     // Catch: java.lang.Throwable -> Lb4
            if (r4 == 0) goto L74
            java.util.Collection r1 = (java.util.Collection) r1     // Catch: java.lang.Throwable -> Lb4
            r0.addAll(r1)     // Catch: java.lang.Throwable -> Lb4
            goto L74
        L43:
            java.lang.String r1 = "applog_do_request_end"
            java.lang.String r4 = r8.event     // Catch: java.lang.Throwable -> Lb4
            boolean r1 = r1.equals(r4)     // Catch: java.lang.Throwable -> Lb4
            if (r1 == 0) goto L74
            java.lang.Object r1 = r8.data     // Catch: java.lang.Throwable -> Lb4
            boolean r1 = r1 instanceof org.json.JSONObject     // Catch: java.lang.Throwable -> Lb4
            if (r1 == 0) goto L74
            java.lang.Object r1 = r8.data     // Catch: java.lang.Throwable -> Lb4
            org.json.JSONObject r1 = (org.json.JSONObject) r1     // Catch: java.lang.Throwable -> Lb4
            boolean r1 = r1.has(r2)     // Catch: java.lang.Throwable -> Lb4
            if (r1 == 0) goto L74
            java.lang.Object r1 = r8.data     // Catch: java.lang.Throwable -> Lb4
            org.json.JSONObject r1 = (org.json.JSONObject) r1     // Catch: java.lang.Throwable -> Lb4
            java.lang.Object r1 = r1.opt(r2)     // Catch: java.lang.Throwable -> Lb4
            boolean r4 = r1 instanceof byte[]     // Catch: java.lang.Throwable -> Lb4
            if (r4 == 0) goto L74
            byte[] r1 = (byte[]) r1     // Catch: java.lang.Throwable -> Lb4
            byte[] r1 = (byte[]) r1     // Catch: java.lang.Throwable -> Lb4
            java.lang.Object r1 = r1.clone()     // Catch: java.lang.Throwable -> Lb4
            byte[] r1 = (byte[]) r1     // Catch: java.lang.Throwable -> Lb4
            goto L75
        L74:
            r1 = 0
        L75:
            java.util.Iterator r7 = r7.iterator()     // Catch: java.lang.Throwable -> Lb4
        L79:
            boolean r4 = r7.hasNext()     // Catch: java.lang.Throwable -> Lb4
            if (r4 == 0) goto Lb8
            java.lang.Object r4 = r7.next()     // Catch: java.lang.Throwable -> Lb4
            com.bytedance.applog.log.EventBus$Subscription r4 = (com.bytedance.applog.log.EventBus.Subscription) r4     // Catch: java.lang.Throwable -> Lb4
            java.lang.Object r5 = r8.data     // Catch: java.lang.Throwable -> Lb4
            boolean r5 = r5 instanceof org.json.JSONObject     // Catch: java.lang.Throwable -> Lb4
            if (r5 == 0) goto Lae
            org.json.JSONObject r5 = new org.json.JSONObject     // Catch: org.json.JSONException -> La8 java.lang.Throwable -> Lb4
            java.lang.Object r6 = r8.data     // Catch: org.json.JSONException -> La8 java.lang.Throwable -> Lb4
            java.lang.String r6 = r6.toString()     // Catch: org.json.JSONException -> La8 java.lang.Throwable -> Lb4
            r5.<init>(r6)     // Catch: org.json.JSONException -> La8 java.lang.Throwable -> Lb4
            boolean r6 = r0.isEmpty()     // Catch: org.json.JSONException -> La8 java.lang.Throwable -> Lb4
            if (r6 != 0) goto L9f
            r5.put(r3, r0)     // Catch: org.json.JSONException -> La8 java.lang.Throwable -> Lb4
        L9f:
            if (r1 == 0) goto La4
            r5.put(r2, r1)     // Catch: org.json.JSONException -> La8 java.lang.Throwable -> Lb4
        La4:
            r4.sub(r5)     // Catch: org.json.JSONException -> La8 java.lang.Throwable -> Lb4
            goto L79
        La8:
            java.lang.Object r5 = r8.data     // Catch: java.lang.Throwable -> Lb4
            r4.sub(r5)     // Catch: java.lang.Throwable -> Lb4
            goto L79
        Lae:
            java.lang.Object r5 = r8.data     // Catch: java.lang.Throwable -> Lb4
            r4.sub(r5)     // Catch: java.lang.Throwable -> Lb4
            goto L79
        Lb4:
            r7 = move-exception
            r7.printStackTrace()
        Lb8:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.applog.log.EventBus.emitEvent(com.bytedance.applog.log.EventBus$MessageEvent):void");
    }

    private void cache(MessageEvent messageEvent) {
        synchronized (this.cache) {
            if (this.cache.size() >= this.maxCacheEventSize) {
                this.cache.poll();
            }
            this.cache.add(messageEvent);
        }
    }

    private void handleCache() {
        synchronized (this.cache) {
            ArrayList arrayList = new ArrayList(this.cache);
            this.cache.clear();
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                emit((MessageEvent) it.next());
            }
        }
    }
}
