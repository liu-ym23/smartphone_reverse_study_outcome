package com.bytedance.apm6.cpu.d;

import android.util.Pair;
import java.util.LinkedList;

/* JADX INFO: compiled from: CurrentCpuDataHolder.java */
/* JADX INFO: loaded from: classes.dex */
public class a implements com.bytedance.apm6.service.e.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private double f5281a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private double f5282b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Pair<Long, LinkedList<com.bytedance.apm6.service.e.a.C0132a>> f5283c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private Pair<Long, LinkedList<com.bytedance.apm6.service.e.a.C0132a>> f5284d;

    /* JADX INFO: renamed from: com.bytedance.apm6.cpu.d.a$1, reason: invalid class name */
    /* JADX INFO: compiled from: CurrentCpuDataHolder.java */
    static /* synthetic */ class AnonymousClass1 {
    }

    /* JADX INFO: renamed from: com.bytedance.apm6.cpu.d.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: CurrentCpuDataHolder.java */
    private static final class C0129a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static final a f5285a = null;

        static /* synthetic */ a a() {
            return f5285a;
        }

        static {
            f5285a = new a(null);
        }
    }

    /* synthetic */ a(AnonymousClass1 r1) {
        this();
    }

    private a() {
        this.f5281a = -1.0d;
        this.f5282b = -1.0d;
        this.f5283c = new Pair(0L, new LinkedList());
        this.f5284d = new Pair(0L, new LinkedList());
    }

    public static a a() {
        return C0129a.a();
    }

    public void a(double r1, double r3) {
        this.f5281a = r1;
        this.f5282b = r3;
    }

    public synchronized void a(LinkedList<com.bytedance.apm6.service.e.a.C0132a> r4) {
        monitor-enter(this);
        this.f5283c = new Pair(Long.valueOf(System.currentTimeMillis()), r4);     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    public synchronized void b(LinkedList<com.bytedance.apm6.service.e.a.C0132a> r4) {
        monitor-enter(this);
        this.f5284d = new Pair(Long.valueOf(System.currentTimeMillis()), r4);     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    @Override // com.bytedance.apm6.service.e.a
    public double b() {
        return this.f5281a;
    }

    @Override // com.bytedance.apm6.service.e.a
    public double c() {
        return this.f5282b;
    }
}
