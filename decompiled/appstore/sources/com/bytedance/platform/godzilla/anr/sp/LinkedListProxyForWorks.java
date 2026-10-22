package com.bytedance.platform.godzilla.anr.sp;

import android.os.Looper;
import java.util.LinkedList;
import s5.a;

/* JADX INFO: loaded from: classes.dex */
public class LinkedListProxyForWorks<E> extends LinkedList<E> {
    private static final Object LOCK = null;
    private LinkedList<Runnable> mRealList;

    static {
        LOCK = new Object();
    }

    public LinkedListProxyForWorks(LinkedList<Runnable> r10) {
        this.mRealList = r10;
    }

    @Override // java.util.LinkedList, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List, java.util.Deque, java.util.Queue
    public boolean add(E r10) {
        Object r11 = LOCK;
        monitor-enter(r11);
        boolean r12 = this.mRealList.add((Runnable) r10);     // Catch: Throwable -> L7
        monitor-exit(r11);     // Catch: Throwable -> L7
        return r12;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // java.util.LinkedList, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public void clear() {
        if (Looper.getMainLooper() != Looper.myLooper()) goto L6;
        a.a();
        return;
    L6:
        Object r10 = LOCK;
        monitor-enter(r10);
        this.mRealList.clear();     // Catch: Throwable -> L11
        monitor-exit(r10);     // Catch: Throwable -> L11
        return;
    L11:
        th = move-exception;
        throw th;
    }

    @Override // java.util.LinkedList
    public Object clone() {
        super.clone();
        if (Looper.getMainLooper() == Looper.myLooper()) goto L5;
        Object r10 = LOCK;
        monitor-enter(r10);
        LinkedList r11 = new LinkedList(this.mRealList);     // Catch: Throwable -> L11
        monitor-exit(r10);     // Catch: Throwable -> L11
        return r11;
    L11:
        th = move-exception;
        throw th;
    L5:
        return new LinkedList();
    }
}
