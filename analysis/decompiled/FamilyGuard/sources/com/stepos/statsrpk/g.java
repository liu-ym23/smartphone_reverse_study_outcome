package com.stepos.statsrpk;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import g3.C0742e;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.UUID;

/* loaded from: classes.dex */
public class g {

    /* renamed from: h, reason: collision with root package name */
    private static String f15961h = "RpkPageController";

    /* renamed from: d, reason: collision with root package name */
    private Context f15965d;

    /* renamed from: e, reason: collision with root package name */
    private f f15966e;

    /* renamed from: f, reason: collision with root package name */
    private String f15967f;

    /* renamed from: a, reason: collision with root package name */
    LinkedList<b> f15962a = new LinkedList<>();

    /* renamed from: b, reason: collision with root package name */
    private final long f15963b = 43200000;

    /* renamed from: c, reason: collision with root package name */
    private final int f15964c = 100;

    /* renamed from: g, reason: collision with root package name */
    private Runnable f15968g = new a();

    class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            C0742e.c(g.f15961h, "clean sessionId: " + g.this.f15967f);
            g.this.f15967f = null;
        }
    }

    private class b {

        /* renamed from: a, reason: collision with root package name */
        private String f15970a;

        /* renamed from: b, reason: collision with root package name */
        private long f15971b;

        /* renamed from: c, reason: collision with root package name */
        private long f15972c;

        b(String str, long j5, long j6) {
            this.f15970a = str;
            this.f15971b = j5;
            this.f15972c = j6;
        }
    }

    public g(Context context) {
        this.f15965d = context;
    }

    public void d(f fVar) {
        this.f15966e = fVar;
    }

    public synchronized void e(String str) throws Throwable {
        try {
            try {
                C0742e.c(f15961h, "startPage: " + str);
                new Handler(Looper.getMainLooper()).removeCallbacks(this.f15968g);
                this.f15962a.addFirst(new b(str, System.currentTimeMillis(), SystemClock.elapsedRealtime()));
                int size = this.f15962a.size() - 100;
                if (size > 0) {
                    C0742e.c(f15961h, "ON_PAGE_STOP, too many pages in stack, delete pages " + size);
                    for (int i5 = 0; i5 < size; i5++) {
                        this.f15962a.removeLast();
                    }
                }
            } catch (Throwable th) {
                th = th;
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            throw th;
        }
    }

    public String f() {
        if (this.f15967f == null) {
            synchronized (this) {
                this.f15967f = UUID.randomUUID().toString();
                C0742e.c(f15961h, "generate a sessionId: " + this.f15967f);
            }
        }
        return this.f15967f;
    }

    public synchronized void g(String str) {
        String str2;
        try {
            C0742e.c(f15961h, "stopPage: " + str);
            Iterator<b> it = this.f15962a.iterator();
            while (it.hasNext()) {
                System.currentTimeMillis();
                long jElapsedRealtime = SystemClock.elapsedRealtime();
                b next = it.next();
                if (Math.abs(jElapsedRealtime - next.f15972c) > 43200000) {
                    it.remove();
                    C0742e.c(f15961h, "remove invalid page who's duration > 12 hours:" + next);
                }
            }
            Iterator<b> it2 = this.f15962a.iterator();
            boolean z5 = false;
            while (it2.hasNext()) {
                long jCurrentTimeMillis = System.currentTimeMillis();
                long jElapsedRealtime2 = SystemClock.elapsedRealtime();
                b next2 = it2.next();
                if (str.equals(next2.f15970a)) {
                    if (z5) {
                        str2 = str;
                        C0742e.c(f15961h, "found repeated page: " + next2);
                    } else {
                        str2 = str;
                        this.f15966e.f().c(str2, next2.f15971b, jCurrentTimeMillis, jElapsedRealtime2 - next2.f15972c);
                        C0742e.c(f15961h, "create a page event: " + next2);
                        z5 = true;
                    }
                    it2.remove();
                    str = str2;
                }
            }
            if (this.f15962a.size() <= 0) {
                new Handler(Looper.getMainLooper()).postDelayed(this.f15968g, 30000L);
            }
        } catch (Throwable th) {
            throw th;
        }
    }
}
