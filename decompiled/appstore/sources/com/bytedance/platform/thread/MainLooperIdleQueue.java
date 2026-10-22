package com.bytedance.platform.thread;

import android.os.Looper;
import android.os.Message;
import android.os.MessageQueue;
import android.os.SystemClock;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

/* JADX INFO: loaded from: classes.dex */
public class MainLooperIdleQueue implements MessageQueue.IdleHandler {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static int f7870c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static Callback f7871d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static ArrayList f7872e;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Queue f7873a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Field f7874b;

    public interface Callback {
        void onCostTime(MessageQueue.IdleHandler r10, long r11);

        void onDelay(MessageQueue.IdleHandler r10, long r11);

        void onInit(boolean r10, Throwable r11);
    }

    public static class ProxyArrayList extends ArrayList<MessageQueue.IdleHandler> {
        public ProxyArrayList() {
        }

        @Override // java.util.ArrayList, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
        public /* bridge */ /* synthetic */ boolean add(Object r10) {
            return add((MessageQueue.IdleHandler) r10);
        }

        @Override // java.util.ArrayList, java.util.AbstractCollection, java.util.Collection, java.util.List
        public boolean remove(Object r10) {
            if ((r10 instanceof MainLooperIdleQueue) == false) goto L5;
            return true;
        L5:
            MainLooperIdleQueue.d().f((MessageQueue.IdleHandler) r10);
            return true;
        }

        public boolean add(MessageQueue.IdleHandler r10) {
            if ((r10 instanceof MainLooperIdleQueue) == false) goto L10;
            if (contains(r10) == false) goto L7;
            return true;
        L7:
            return super.add(r10);
        L10:
            if (MainLooperIdleQueue.a(r10.getClass().getName()) == true) goto L12;
            MainLooperIdleQueue.d().b(r10);
            return true;
        L12:
            return super.add(r10);
        }
    }

    public static /* synthetic */ class a {
    }

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static MainLooperIdleQueue f7875a;

        static {
            f7875a = new MainLooperIdleQueue(null);
        }

        public static /* synthetic */ MainLooperIdleQueue a() {
            return f7875a;
        }
    }

    static {
        f7872e = new ArrayList();
    }

    public /* synthetic */ MainLooperIdleQueue(a r10) {
        this();
    }

    public static /* synthetic */ boolean a(String r10) {
        return e(r10);
    }

    public static MainLooperIdleQueue d() {
        return b.a();
    }

    public static boolean e(String r10) {
        Iterator r11 = f7872e.iterator();
    L4:
        if (r11.hasNext() == false) goto L9;
        if (r10.startsWith((String) r11.next()) == false) goto L4;
        return true;
    L9:
        return false;
    }

    public void b(MessageQueue.IdleHandler r10) {
        if (r10 == null) goto L11;
        monitor-enter(this);
        this.f7873a.add(r10);     // Catch: Throwable -> L7
        monitor-exit(this);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    L11:
        throw new NullPointerException("Can't add a null IdleHandler");
    }

    public final long c() {
        monitor-enter(this);
        Object r10 = this.f7874b.get(Looper.myQueue());     // Catch: Throwable -> L7 IllegalAccessException -> L9
        if (r10 == null) goto L11;
        long r11 = ((Message) r10).getWhen();     // Catch: Throwable -> L7 IllegalAccessException -> L9
    L15:
        monitor-exit(this);     // Catch: Throwable -> L7
        return r11;
    L11:
        monitor-exit(this);     // Catch: Throwable -> L7
        return Long.MIN_VALUE;
    L9:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L7
        r11 = 0;
    L7:
        th = move-exception;
        throw th;
    }

    public void f(MessageQueue.IdleHandler r10) {
        monitor-enter(this);
        this.f7873a.remove(r10);     // Catch: Throwable -> L6
        monitor-exit(this);     // Catch: Throwable -> L6
        return;
    L6:
        th = move-exception;
        throw th;
    }

    @Override // android.os.MessageQueue.IdleHandler
    public boolean queueIdle() {
        if (this.f7874b == null) goto L46;
    L9:
        long r10 = c();
        long r11 = SystemClock.uptimeMillis();
        if ((r10 - r11) <= f7870c) goto L12;
    L13:
        monitor-enter(this);
    L18:
        th = move-exception;
        throw th;
    L15:
        if (this.f7873a.isEmpty() == false) goto L20;
        monitor-exit(this);     // Catch: Throwable -> L18
        return true;
    L20:
        MessageQueue.IdleHandler r12 = (MessageQueue.IdleHandler) this.f7873a.poll();     // Catch: Throwable -> L18
        monitor-exit(this);     // Catch: Throwable -> L18
        boolean r13 = r12.queueIdle();
        long r14 = SystemClock.uptimeMillis();
        Callback r15 = f7871d;
        if (r15 == null) goto L25;
        r15.onCostTime(r12, r14 - r11);
    L25:
        long r16 = c();
        if (r16 <= 0) goto L29;
        r10 = r16;
    L29:
        if (r10 > 0) goto L31;
    L35:
        if (r13 == false) goto L40;
        monitor-enter(this);
        this.f7873a.offer(r12);     // Catch: Throwable -> L41
        monitor-exit(this);     // Catch: Throwable -> L41
    L41:
        th = move-exception;
        throw th;
    L40:
        return true;
    L31:
        if (r14 <= r10) goto L35;
        Callback r17 = f7871d;
        if (r17 == null) goto L35;
        r17.onDelay(r12, r14 - r10);
        goto L35
    L12:
        if (r10 != Long.MIN_VALUE) goto L40;
    L46:
        this.f7874b = MessageQueue.class.getDeclaredField("mMessages");     // Catch: NoSuchFieldException -> L6
    L8:
        this.f7874b.setAccessible(true);
    L6:
        e = move-exception;
        e.printStackTrace();
        goto L8
    }

    public MainLooperIdleQueue() {
        this.f7873a = new LinkedList();
        f7872e.add("android");
    }
}
