package bm7;

import com.bytedance.ug.sdk.luckyhost.api.api.countTimer.LuckyCounterTimerStatus;
import java.util.Iterator;
import java.util.concurrent.ConcurrentLinkedQueue;
import org.json.JSONObject;
import xm7.f;
import xm7.h;
import xm7.i;
import xm7.j;
import xm7.k;

/* JADX INFO: loaded from: classes22.dex */
public final class a implements f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ConcurrentLinkedQueue<h> f19593a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ConcurrentLinkedQueue<xm7.c> f19594b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ConcurrentLinkedQueue<i> f19595c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ConcurrentLinkedQueue<j> f19596d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final ConcurrentLinkedQueue<xm7.d> f19597e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final k f19598f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final JSONObject f19599g;

    /* JADX INFO: renamed from: bm7.a$a, reason: collision with other inner class name */
    public static final class C0315a {
    }

    static {
    }

    public final synchronized boolean a(h r100) {
        monitor-enter(this);
    L12:
        th = move-exception;
        throw th;
    L4:
        if (this.f19593a.contains(r100) == true) goto L9;
        this.f19593a.add(r100);     // Catch: Throwable -> L12
        monitor-exit(this);
        return true;
    L9:
        monitor-exit(this);
        return false;
    }

    public final synchronized void b(j r100) {
        monitor-enter(this);
    L10:
        th = move-exception;
        throw th;
    L4:
        if (this.f19596d.contains(r100) == true) goto L8;
        this.f19596d.add(r100);     // Catch: Throwable -> L10
        monitor-exit(this);
        return;
    L8:
        monitor-exit(this);
    }

    public final void c(LuckyCounterTimerStatus r100) {
        Iterator<T> r101 = this.f19596d.iterator();
    L4:
        if (r101.hasNext() == false) goto L6;
        ((j) r101.next()).e(r100);
        goto L4
    }

    public a(k r100, JSONObject r101) {
        this.f19598f = r100;
        this.f19599g = r101;
        this.f19593a = new ConcurrentLinkedQueue();
        this.f19594b = new ConcurrentLinkedQueue();
        this.f19595c = new ConcurrentLinkedQueue();
        this.f19596d = new ConcurrentLinkedQueue();
        this.f19597e = new ConcurrentLinkedQueue();
    }
}
