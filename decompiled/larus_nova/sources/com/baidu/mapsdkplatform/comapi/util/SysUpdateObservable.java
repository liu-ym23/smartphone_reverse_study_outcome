package com.baidu.mapsdkplatform.comapi.util;

import android.content.Context;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes39.dex */
public class SysUpdateObservable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile SysUpdateObservable f32292a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private List<SysUpdateObserver> f32293b;

    public synchronized void clearObserver() {
        monitor-enter(this);
        this.f32293b.clear();     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    public static SysUpdateObservable getInstance() {
        if (f32292a != null) goto L15;
        monitor-enter(SysUpdateObservable.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f32292a != null) goto L9;
        f32292a = new SysUpdateObservable();     // Catch: Throwable -> L11
    L9:
        monitor-exit(SysUpdateObservable.class);     // Catch: Throwable -> L11
    L15:
        return f32292a;
    }

    private SysUpdateObservable() {
        this.f32293b = null;
        this.f32293b = new ArrayList();
    }

    public synchronized void addObserver(SysUpdateObserver r100) {
        monitor-enter(this);
        this.f32293b.add(r100);     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    public synchronized void init(String r100) {
        monitor-enter(this);
        Iterator<SysUpdateObserver> r101 = this.f32293b.iterator();     // Catch: Throwable -> L13
    L5:
        if (r101.hasNext() == false) goto L11;
        SysUpdateObserver r102 = r101.next();     // Catch: Throwable -> L13
        if (r102 == null) goto L5;
        r102.init(r100);     // Catch: Throwable -> L13
        goto L5
    L11:
        monitor-exit(this);
        return;
    L13:
        th = move-exception;
        throw th;
    }

    public synchronized void updateCuid(String r100) {
        monitor-enter(this);
        Iterator<SysUpdateObserver> r101 = this.f32293b.iterator();     // Catch: Throwable -> L13
    L5:
        if (r101.hasNext() == false) goto L11;
        SysUpdateObserver r102 = r101.next();     // Catch: Throwable -> L13
        if (r102 == null) goto L5;
        r102.updateCuid(r100);     // Catch: Throwable -> L13
        goto L5
    L11:
        monitor-exit(this);
        return;
    L13:
        th = move-exception;
        throw th;
    }

    public synchronized void updateNetworkInfo(Context r100) {
        monitor-enter(this);
        Iterator<SysUpdateObserver> r101 = this.f32293b.iterator();     // Catch: Throwable -> L13
    L5:
        if (r101.hasNext() == false) goto L11;
        SysUpdateObserver r102 = r101.next();     // Catch: Throwable -> L13
        if (r102 == null) goto L5;
        r102.updateNetworkInfo(r100);     // Catch: Throwable -> L13
        goto L5
    L11:
        monitor-exit(this);
        return;
    L13:
        th = move-exception;
        throw th;
    }

    public synchronized void updateNetworkProxy(Context r100) {
        monitor-enter(this);
        Iterator<SysUpdateObserver> r101 = this.f32293b.iterator();     // Catch: Throwable -> L13
    L5:
        if (r101.hasNext() == false) goto L11;
        SysUpdateObserver r102 = r101.next();     // Catch: Throwable -> L13
        if (r102 == null) goto L5;
        r102.updateNetworkProxy(r100);     // Catch: Throwable -> L13
        goto L5
    L11:
        monitor-exit(this);
        return;
    L13:
        th = move-exception;
        throw th;
    }

    public synchronized void updatePhoneInfo(String r100) {
        monitor-enter(this);
        Iterator<SysUpdateObserver> r101 = this.f32293b.iterator();     // Catch: Throwable -> L13
    L5:
        if (r101.hasNext() == false) goto L11;
        SysUpdateObserver r102 = r101.next();     // Catch: Throwable -> L13
        if (r102 == null) goto L5;
        r102.updatePhoneInfo(r100);     // Catch: Throwable -> L13
        goto L5
    L11:
        monitor-exit(this);
        return;
    L13:
        th = move-exception;
        throw th;
    }

    public synchronized void updateZid(String r100) {
        monitor-enter(this);
        Iterator<SysUpdateObserver> r101 = this.f32293b.iterator();     // Catch: Throwable -> L13
    L5:
        if (r101.hasNext() == false) goto L11;
        SysUpdateObserver r102 = r101.next();     // Catch: Throwable -> L13
        if (r102 == null) goto L5;
        r102.updateZid(r100);     // Catch: Throwable -> L13
        goto L5
    L11:
        monitor-exit(this);
        return;
    L13:
        th = move-exception;
        throw th;
    }
}
