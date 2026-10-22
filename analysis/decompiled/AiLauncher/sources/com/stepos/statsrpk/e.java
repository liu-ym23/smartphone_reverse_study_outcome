package com.stepos.statsrpk;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import com.stepos.statsapp.v3.utils.log.Logger;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.UUID;

/* loaded from: classes2.dex */
public class e {

    /* renamed from: h, reason: collision with root package name */
    public static String f31044h = "RpkPageController";

    /* renamed from: d, reason: collision with root package name */
    public Context f31048d;

    /* renamed from: e, reason: collision with root package name */
    public d f31049e;

    /* renamed from: f, reason: collision with root package name */
    public String f31050f;

    /* renamed from: a, reason: collision with root package name */
    public LinkedList<b> f31045a = new LinkedList<>();

    /* renamed from: b, reason: collision with root package name */
    public final long f31046b = 43200000;

    /* renamed from: c, reason: collision with root package name */
    public final int f31047c = 100;

    /* renamed from: g, reason: collision with root package name */
    public Runnable f31051g = new a();

    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            Logger.d(e.f31044h, "clean sessionId: " + e.this.f31050f);
            e.this.f31050f = null;
        }
    }

    public class b {

        /* renamed from: a, reason: collision with root package name */
        public String f31053a;

        /* renamed from: b, reason: collision with root package name */
        public long f31054b;

        /* renamed from: c, reason: collision with root package name */
        public long f31055c;

        public b(String str, long j10, long j11) {
            this.f31053a = str;
            this.f31054b = j10;
            this.f31055c = j11;
        }
    }

    public e(Context context) {
        this.f31048d = context;
    }

    public void d(d dVar) {
        this.f31049e = dVar;
    }

    public synchronized void e(String str) throws Throwable {
        try {
            try {
                Logger.d(f31044h, "startPage: " + str);
                new Handler(Looper.getMainLooper()).removeCallbacks(this.f31051g);
                this.f31045a.addFirst(new b(str, System.currentTimeMillis(), SystemClock.elapsedRealtime()));
                int size = this.f31045a.size() - 100;
                if (size > 0) {
                    Logger.d(f31044h, "ON_PAGE_STOP, too many pages in stack, delete pages " + size);
                    for (int i10 = 0; i10 < size; i10++) {
                        this.f31045a.removeLast();
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
        if (this.f31050f == null) {
            synchronized (this) {
                this.f31050f = UUID.randomUUID().toString();
                Logger.d(f31044h, "generate a sessionId: " + this.f31050f);
            }
        }
        return this.f31050f;
    }

    public synchronized void g(String str) {
        String str2;
        try {
            Logger.d(f31044h, "stopPage: " + str);
            Iterator<b> it = this.f31045a.iterator();
            while (it.hasNext()) {
                System.currentTimeMillis();
                long jElapsedRealtime = SystemClock.elapsedRealtime();
                b next = it.next();
                if (Math.abs(jElapsedRealtime - next.f31055c) > 43200000) {
                    it.remove();
                    Logger.d(f31044h, "remove invalid page who's duration > 12 hours:" + next);
                }
            }
            Iterator<b> it2 = this.f31045a.iterator();
            boolean z10 = false;
            while (it2.hasNext()) {
                long jCurrentTimeMillis = System.currentTimeMillis();
                long jElapsedRealtime2 = SystemClock.elapsedRealtime();
                b next2 = it2.next();
                if (str.equals(next2.f31053a)) {
                    if (z10) {
                        str2 = str;
                        Logger.d(f31044h, "found repeated page: " + next2);
                    } else {
                        str2 = str;
                        this.f31049e.f().c(str2, next2.f31054b, jCurrentTimeMillis, jElapsedRealtime2 - next2.f31055c);
                        Logger.d(f31044h, "create a page event: " + next2);
                        z10 = true;
                    }
                    it2.remove();
                    str = str2;
                }
            }
            if (this.f31045a.size() <= 0) {
                new Handler(Looper.getMainLooper()).postDelayed(this.f31051g, 30000L);
            }
        } catch (Throwable th) {
            throw th;
        }
    }
}
