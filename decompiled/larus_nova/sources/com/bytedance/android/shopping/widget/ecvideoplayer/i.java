package com.bytedance.android.shopping.widget.ecvideoplayer;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.collections.ArraysKt;

/* JADX INFO: loaded from: classes14.dex */
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ReentrantLock f187403a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Condition f187404b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f187405c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public volatile int f187406d;

    public i() {
        ReentrantLock r100 = new ReentrantLock();
        this.f187403a = r100;
        this.f187404b = r100.newCondition();
    }

    public static String b(int[] r100) {
        StringBuilder r101 = new StringBuilder();
        int r102 = r100.length;
        int r103 = 0;
        int r104 = 0;
    L3:
        if (r103 >= r102) goto L9;
        int r105 = r100[r103];
        int r106 = r104 + 1;
        int r107 = ECVideoPlayer.f187336r;
        r101.append(ECVideoPlayer.a.a(r105));
        if (r104 == (r100.length - 1)) goto L7;
        r101.append(",");
    L7:
        r103 = r103 + 1;
        r104 = r106;
        goto L3
    L9:
        return r101.toString();
    }

    public final void a(int r100) {
        this.f187403a.lock();
        int r101 = a.f187394a;
        StringBuilder r102 = new StringBuilder("PlayerTaskExecutor");
        r102.append(this.f187405c);
        r102.append(" ChangeState ");
        int r103 = ECVideoPlayer.f187336r;
        r102.append(ECVideoPlayer.a.a(r100));
        a.a(r102.toString());
        this.f187406d = r100;
        this.f187404b.signalAll();
        this.f187403a.unlock();
    }

    public final boolean c(int... r100) {
        int r101 = a.f187394a;
        StringBuilder r102 = new StringBuilder("PlayerTaskExecutor");
        r102.append(this.f187405c);
        r102.append(" Syncing TargetStates ");
        r102.append(b(r100));
        r102.append(" currentState=");
        int r103 = ECVideoPlayer.f187336r;
        r102.append(ECVideoPlayer.a.a(this.f187406d));
        a.a(r102.toString());
        this.f187403a.lock();
    L4:
        if (ArraysKt.contains(r100, this.f187406d) == true) goto L15;
        if (this.f187406d != (-1)) goto L8;
    L11:
        boolean r104 = true;
    L12:
        if (r104 == true) goto L13;
        this.f187404b.await();
        goto L4
    L13:
        boolean r105 = false;
    L16:
        int r106 = a.f187394a;
        a.a("PlayerTaskExecutor" + this.f187405c + " SyncToTargetStates " + b(new int[]{this.f187406d}) + " success=" + r105);
        this.f187403a.unlock();
        return r105;
    L8:
        if (this.f187406d == 6) goto L11;
        r104 = false;
        goto L12
    L15:
        r105 = true;
        goto L16
    }
}
