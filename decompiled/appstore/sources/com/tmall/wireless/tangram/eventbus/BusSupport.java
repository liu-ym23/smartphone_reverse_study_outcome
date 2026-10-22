package com.tmall.wireless.tangram.eventbus;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.collection.ArrayMap;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public class BusSupport implements IDispatcherDelegate {
    public static final String EVENT_ON_CLICK = "onClick";
    public static final String EVENT_ON_EXPOSURE = "onExposure";
    public static final String EVENT_ON_SCROLL = "onScroll";
    private boolean isStopEvent;
    private IDispatcher mDispatcher;
    private ConcurrentHashMap<String, List<EventHandlerWrapper>> subscribers;

    public BusSupport() {
        this.subscribers = new ConcurrentHashMap();
        this.mDispatcher = new Dispatcher(this);
    }

    public static Event obtainEvent() {
        return EventPool.sharedInstance().acquire();
    }

    public static EventHandlerWrapper wrapEventHandler(@NonNull String r10, String r11, @NonNull Object r12, String r13) {
        return new EventHandlerWrapper(r10, r11, r12, r13);
    }

    @Override // com.tmall.wireless.tangram.eventbus.IDispatcherDelegate
    public synchronized void dispatch(@NonNull Event r10) {
        monitor-enter(this);
        String r11 = r10.type;     // Catch: Throwable -> L15
        List<EventHandlerWrapper> r12 = this.subscribers.get(r11);     // Catch: Throwable -> L15
        if (r12 == null) goto L21;
        int r13 = r12.size();     // Catch: Throwable -> L15
        int r14 = 0;
    L6:
        if (r14 >= r13) goto L21;
        if (this.isStopEvent == true) goto L21;
        EventHandlerWrapper r15 = r12.get(r14);     // Catch: Throwable -> L15
        if (TextUtils.isEmpty(r15.producer) == true) goto L18;
        if (r15.producer.equals(r10.sourceId) == false) goto L18;
        r15.handleEvent(r10);     // Catch: Throwable -> L15
    L20:
        r14 = r14 + 1;
    L18:
        if (TextUtils.isEmpty(r15.producer) == false) goto L20;
        r15.handleEvent(r10);     // Catch: Throwable -> L15
    L21:
        monitor-exit(this);
        return;
    L15:
        th = move-exception;
        throw th;
    }

    public boolean post(@NonNull Event r10) {
        return this.mDispatcher.enqueue(r10);
    }

    public synchronized void register(@NonNull EventHandlerWrapper r10) {
        monitor-enter(this);
        String r11 = r10.type;     // Catch: Throwable -> L6
        List<EventHandlerWrapper> r12 = this.subscribers.get(r11);     // Catch: Throwable -> L6
        if (r12 != null) goto L8;
        r12 = new ArrayList();     // Catch: Throwable -> L6
        this.subscribers.put(r11, r12);     // Catch: Throwable -> L6
    L8:
        r12.add(r10);     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    public void shutdown() {
        this.subscribers.clear();
        this.mDispatcher.stopSelf();
        ReflectedActionFinder.clear();
    }

    public void stopEvent(boolean r10) {
        if (r10 == false) goto L4;
        this.mDispatcher.stopSelf();
    L4:
        this.isStopEvent = r10;
    }

    public synchronized void unregister(@NonNull EventHandlerWrapper r10) {
        monitor-enter(this);
        String r11 = r10.type;     // Catch: Throwable -> L7
        List<EventHandlerWrapper> r12 = this.subscribers.get(r11);     // Catch: Throwable -> L7
        if (r12 == null) goto L9;
        r12.remove(r10);     // Catch: Throwable -> L7
    L9:
        monitor-exit(this);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public static Event obtainEvent(String r10, String r11, ArrayMap r12, EventContext r13) {
        Event r14 = EventPool.sharedInstance().acquire();
        r14.type = r10;
        r14.sourceId = r11;
        r14.args = r12;
        r14.eventContext = r13;
        return r14;
    }

    public static EventHandlerWrapper wrapEventHandler(@NonNull Object r10, @NonNull JSONObject r11) {
        String r12 = r11.optString("type");
        if (TextUtils.isEmpty(r12) == false) goto L7;
        return null;
    L7:
        return new EventHandlerWrapper(r12, r11.optString("producer"), r10, r11.optString("action"));
    }

    public boolean post(@NonNull List<Event> r10) {
        return this.mDispatcher.enqueue(r10);
    }
}
