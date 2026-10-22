package com.baidu.location.c;

import android.content.Context;
import android.location.Location;
import android.os.Looper;
import com.baidu.location.b.q;
import java.util.Locale;
import java.util.Timer;
import java.util.TimerTask;

/* loaded from: classes.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    public b f5618a = null;

    /* renamed from: b, reason: collision with root package name */
    public Location f5619b = null;

    /* renamed from: c, reason: collision with root package name */
    public Location f5620c = null;

    /* renamed from: d, reason: collision with root package name */
    public long f5621d = 0;

    /* renamed from: e, reason: collision with root package name */
    public long f5622e = 0;

    /* renamed from: f, reason: collision with root package name */
    private Timer f5623f = null;

    /* renamed from: g, reason: collision with root package name */
    private TimerTask f5624g = null;

    public static class a {

        /* renamed from: a, reason: collision with root package name */
        private static c f5626a = new c();
    }

    public class b implements q.c {
        private b() {
        }

        @Override // com.baidu.location.b.q.c
        public void a(Location location) {
            if (location == null) {
                return;
            }
            c cVar = c.this;
            cVar.f5619b = location;
            cVar.f5622e = System.currentTimeMillis();
        }
    }

    public static c a() {
        return a.f5626a;
    }

    private synchronized void d() {
        try {
            TimerTask timerTask = this.f5624g;
            if (timerTask != null) {
                timerTask.cancel();
                this.f5624g = null;
            }
            Timer timer = this.f5623f;
            if (timer != null) {
                timer.cancel();
                this.f5623f.purge();
                this.f5623f = null;
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public String b(Location location) {
        if (location != null) {
            return String.format(Locale.CHINA, "&ll=%.5f|%.5f&s=%.1f&d=%.1f&ll_n=%d&ll_t=%d&ll_r=%d", Double.valueOf(location.getLongitude()), Double.valueOf(location.getLatitude()), Float.valueOf((float) (location.getSpeed() * 3.6d)), Float.valueOf(location.getBearing()), 0, Long.valueOf(location.getTime() / 1000), Integer.valueOf((int) (location.hasAccuracy() ? location.getAccuracy() : -1.0f)));
        }
        return null;
    }

    public Location c() {
        return System.currentTimeMillis() - this.f5621d < 30000 ? this.f5620c : System.currentTimeMillis() - this.f5622e < 30000 ? this.f5619b : null;
    }

    public void a(Context context) {
        if (com.baidu.location.e.h.aF == 0) {
            return;
        }
        if (!com.baidu.location.e.h.h(context)) {
            b();
            return;
        }
        d();
        if (this.f5623f == null && this.f5624g == null) {
            this.f5623f = new Timer();
            TimerTask timerTask = new TimerTask() { // from class: com.baidu.location.c.c.1
                @Override // java.util.TimerTask, java.lang.Runnable
                public void run() {
                    c.this.b();
                }
            };
            this.f5624g = timerTask;
            this.f5623f.schedule(timerTask, 60000L);
        }
        if (this.f5618a == null) {
            this.f5618a = new b();
            q.a().a(this.f5618a, context, Looper.myLooper());
        }
    }

    public synchronized void b() {
        try {
            if (this.f5618a != null) {
                q.a().a(this.f5618a);
                this.f5618a = null;
            }
            d();
        } catch (Throwable th) {
            throw th;
        }
    }

    public void a(Location location) {
        this.f5620c = location;
        this.f5621d = System.currentTimeMillis();
    }

    public void b(Context context) {
        if (com.baidu.location.b.a.a().f5103q != 0 && com.baidu.location.e.h.h(context)) {
            if (this.f5618a == null) {
                this.f5618a = new b();
            }
            q.a().a(this.f5618a, context, Looper.getMainLooper());
        }
    }

    public boolean a(Location location, Location location2) {
        float[] fArr;
        if (location2 == null) {
            return false;
        }
        if (location == null) {
            return true;
        }
        try {
            fArr = new float[2];
            Location.distanceBetween(location.getLatitude(), location.getLongitude(), location2.getLatitude(), location2.getLongitude(), fArr);
        } catch (Exception unused) {
        }
        return fArr[0] >= 100.0f;
    }
}
