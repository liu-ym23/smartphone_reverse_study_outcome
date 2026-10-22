package com.android.ttcjpaysdk.base.eventbus;

import android.os.Handler;
import android.os.Looper;
import com.xiaomi.mipush.sdk.MiPushClient;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\b\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\rJ\u000e\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0011\u001a\u00020\rJ\u000e\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0011\u001a\u00020\rJ\u000e\u0010\u0015\u001a\u00020\u00132\u0006\u0010\u0011\u001a\u00020\rJ\u000e\u0010\u0016\u001a\u00020\u00132\u0006\u0010\u0011\u001a\u00020\rJ\u000e\u0010\u0017\u001a\u00020\u00132\u0006\u0010\u0011\u001a\u00020\rJ\u0010\u0010\u0018\u001a\u00020\u00132\b\u0010\u0019\u001a\u0004\u0018\u00010\tJ\u0010\u0010\u001a\u001a\u00020\u00132\b\u0010\u0019\u001a\u0004\u0018\u00010\tR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R6\u0010\u0005\u001a*\u0012\u0004\u0012\u00020\u0007\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b0\u0006j\u0014\u0012\u0004\u0012\u00020\u0007\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b`\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\u000b\u001a\u0012\u0012\u0004\u0012\u00020\r0\fj\b\u0012\u0004\u0012\u00020\r`\u000eX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001b"}, d2 = {"Lcom/android/ttcjpaysdk/base/eventbus/EventManager;", "", "()V", "handler", "Landroid/os/Handler;", "observers", "Ljava/util/HashMap;", "", "Ljava/util/LinkedList;", "Lcom/android/ttcjpaysdk/base/eventbus/Observer;", "Lkotlin/collections/HashMap;", "stickyEventList", "Ljava/util/ArrayList;", "Lcom/android/ttcjpaysdk/base/eventbus/BaseEvent;", "Lkotlin/collections/ArrayList;", "hasObserver", "", "event", "notify", "", "notifyLast", "notifyLastNow", "notifyNow", "notifyStickyEvent", MiPushClient.COMMAND_REGISTER, "observer", MiPushClient.COMMAND_UNREGISTER, "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class EventManager {
    public static final EventManager INSTANCE = null;
    private static final Handler handler = null;
    private static final HashMap<String, LinkedList<Observer>> observers = null;
    private static final ArrayList<BaseEvent> stickyEventList = null;

    private EventManager() {
    }

    static {
        INSTANCE = new EventManager();
        handler = new Handler(Looper.getMainLooper());
        observers = new HashMap();
        stickyEventList = new ArrayList();
    }

    public static final /* synthetic */ HashMap access$getObservers$p() {
        return observers;
    }

    public final synchronized boolean hasObserver(BaseEvent r100) {
        monitor-enter(this);
        Intrinsics.checkNotNullParameter(r100, "event");     // Catch: Throwable -> L10
        LinkedList<Observer> r101 = observers.get(r100.getClass().getName());     // Catch: Throwable -> L10
        if (r101 == null) goto L7;
        boolean r102 = !r101.isEmpty();
    L8:
        monitor-exit(this);
        return r102;
    L7:
        r102 = false;
    L10:
        th = move-exception;
        throw th;
    }

    public final synchronized void notify(final BaseEvent r100) {
        monitor-enter(this);
        Intrinsics.checkNotNullParameter(r100, "event");     // Catch: Throwable -> L12
        LinkedList<Observer> r101 = observers.get(r100.getClass().getName());     // Catch: Throwable -> L12
        if (r101 == null) goto L10;
        Iterator<T> r102 = r101.iterator();     // Catch: Throwable -> L12
    L7:
        if (r102.hasNext() == false) goto L10;
        final Observer r103 = (Observer) r102.next();     // Catch: Throwable -> L12
        handler.post(new EventManager$notify$1$1(r103, r100));     // Catch: Throwable -> L12
    L10:
        monitor-exit(this);
        return;
    L12:
        th = move-exception;
        throw th;
    }

    public final synchronized void notifyLast(final BaseEvent r100) {
        monitor-enter(this);
        Intrinsics.checkNotNullParameter(r100, "event");     // Catch: Throwable -> L6
        handler.post(new AnonymousClass1(r100));     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    public final synchronized void notifyLastNow(BaseEvent r100) {
        monitor-enter(this);
        Intrinsics.checkNotNullParameter(r100, "event");     // Catch: Throwable -> L15
        LinkedList<Observer> r101 = observers.get(r100.getClass().getName());     // Catch: Throwable -> L15
        if (r101 != null) goto L6;
    L13:
        monitor-exit(this);
        return;
    L6:
        if ((!r101.isEmpty()) == true) goto L9;
        r101 = null;
    L9:
        if (r101 == null) goto L13;
        Observer r102 = r101.getLast();     // Catch: Throwable -> L15
        if (r102 == null) goto L13;
        r102.onEvent(r100);     // Catch: Throwable -> L15
    L15:
        th = move-exception;
        throw th;
    }

    public final synchronized void notifyNow(BaseEvent r100) {
        monitor-enter(this);
        Intrinsics.checkNotNullParameter(r100, "event");     // Catch: Throwable -> L12
        LinkedList<Observer> r101 = observers.get(r100.getClass().getName());     // Catch: Throwable -> L12
        if (r101 == null) goto L10;
        Iterator<T> r102 = r101.iterator();     // Catch: Throwable -> L12
    L7:
        if (r102.hasNext() == false) goto L10;
        ((Observer) r102.next()).onEvent(r100);     // Catch: Throwable -> L12
    L10:
        monitor-exit(this);
        return;
    L12:
        th = move-exception;
        throw th;
    }

    public final synchronized void notifyStickyEvent(BaseEvent r100) {
        monitor-enter(this);
        Intrinsics.checkNotNullParameter(r100, "event");     // Catch: Throwable -> L6
        stickyEventList.add(r100);     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    public final synchronized void register(Observer r100) {
        monitor-enter(this);
        if (r100 != null) goto L27;
    L25:
        monitor-exit(this);
        return;
    L27:
        Class<? extends BaseEvent>[] r101 = r100.listEvents();     // Catch: Throwable -> L22
        if (r101 == null) goto L25;
        int r102 = r101.length;     // Catch: Throwable -> L22
        int r103 = 0;
    L7:
        if (r103 >= r102) goto L25;
        Class<? extends BaseEvent> r104 = r101[r103];     // Catch: Throwable -> L22
        HashMap<String, LinkedList<Observer>> r105 = observers;     // Catch: Throwable -> L22
        LinkedList<Observer> r106 = r105.get(r104.getName());     // Catch: Throwable -> L22
        if (r106 != null) goto L12;
        r106 = new LinkedList();     // Catch: Throwable -> L22
        r105.put(r104.getName(), r106);     // Catch: Throwable -> L22
    L12:
        if (r106.contains(r100) == true) goto L14;
        r106.add(r100);     // Catch: Throwable -> L22
    L14:
        Iterator<BaseEvent> r107 = stickyEventList.iterator();     // Catch: Throwable -> L22
    L16:
        if (r107.hasNext() == false) goto L21;
        BaseEvent r108 = r107.next();     // Catch: Throwable -> L22
        if (Intrinsics.areEqual(r108.getClass().getName(), r104.getName()) == false) goto L16;
        r107.remove();     // Catch: Throwable -> L22
        r100.onEvent(r108);     // Catch: Throwable -> L22
        goto L16
    L21:
        r103 = r103 + 1;
    L22:
        th = move-exception;
        throw th;
    }

    public final synchronized void unregister(Observer r100) {
        monitor-enter(this);
        if (r100 != null) goto L17;
    L15:
        monitor-exit(this);
        return;
    L17:
        Class<? extends BaseEvent>[] r101 = r100.listEvents();     // Catch: Throwable -> L12
        if (r101 == null) goto L15;
        int r102 = r101.length;     // Catch: Throwable -> L12
        int r103 = 0;
    L7:
        if (r103 >= r102) goto L15;
        Class<? extends BaseEvent> r104 = r101[r103];     // Catch: Throwable -> L12
        LinkedList<Observer> r105 = observers.get(r104.getName());     // Catch: Throwable -> L12
        if (r105 == null) goto L11;
        r105.removeLastOccurrence(r100);     // Catch: Throwable -> L12
    L11:
        r103 = r103 + 1;
    L12:
        th = move-exception;
        throw th;
    }
}
