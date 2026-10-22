package com.bytedance.android.ecom.arch.slice.render.elements.xelements.ectag;

import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: loaded from: classes44.dex */
public final class a implements com.bytedance.android.ecom.arch.slice.render.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f50579a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f50580b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Handler f50581c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ArrayList<b> f50582d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final c f50583e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final long f50584f;

    /* JADX INFO: renamed from: com.bytedance.android.ecom.arch.slice.render.elements.xelements.ectag.a$a, reason: collision with other inner class name */
    public static final class C0860a {
    }

    public interface b {
        void onTick();
    }

    public static final class c implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ a f50585a;

        public c(a r100) {
            this.f50585a = r100;
        }

        public final void a() {
            long r100 = SystemClock.elapsedRealtime();
            Iterator r101 = new ArrayList(this.f50585a.f50582d).iterator();
        L4:
            if (r101.hasNext() == false) goto L6;
            ((b) r101.next()).onTick();
            goto L4
        L6:
            long r102 = SystemClock.elapsedRealtime() - r100;
            a r103 = this.f50585a;
            long r104 = r103.f50584f;
            if (r102 > r104) goto L11;
            r104 = r104 - r102;
        L11:
            if (r103.f50580b == true) goto L14;
            return;
        L14:
            if (r103.f50582d.isEmpty() == true) goto L20;
            r103.f50581c.removeCallbacks(r103.f50583e);
            r103.f50581c.postDelayed(r103.f50583e, r104);
            return;
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    static {
    }

    @Override // com.bytedance.android.ecom.arch.slice.render.c
    public final void close() {
        this.f50579a = true;
        this.f50580b = false;
        this.f50581c.removeCallbacks(this.f50583e);
    }

    public a() {
        this(100);
    }

    public a(long r100) {
        this.f50584f = r100;
        this.f50581c = new Handler(Looper.getMainLooper());
        this.f50582d = new ArrayList();
        this.f50583e = new c(this);
    }

    public final void a(b r100) {
        if (this.f50579a == false) goto L5;
        return;
    L5:
        nq.a.a();
        if (this.f50582d.contains(r100) == true) goto L8;
        this.f50582d.add(r100);
    L8:
        boolean r101 = this.f50580b;
        if (r101 == true) goto L17;
        if (r101 == true) goto L18;
        this.f50580b = true;
        long r102 = this.f50584f;
        if (this.f50582d.isEmpty() == true) goto L19;
        this.f50581c.removeCallbacks(this.f50583e);
        this.f50581c.postDelayed(this.f50583e, r102);
        return;
    L19:
        return;
    L18:
        return;
    }
}
