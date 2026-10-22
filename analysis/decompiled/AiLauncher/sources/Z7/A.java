package Z7;

import android.os.Handler;
import android.os.SystemClock;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/* loaded from: classes4.dex */
public final class A implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final Handler f7299a;

    /* renamed from: b, reason: collision with root package name */
    public final String f7300b;

    /* renamed from: c, reason: collision with root package name */
    public final List<C1151x> f7301c = new LinkedList();

    /* renamed from: d, reason: collision with root package name */
    public long f7302d = 5000;

    /* renamed from: e, reason: collision with root package name */
    public final long f7303e = 5000;

    /* renamed from: f, reason: collision with root package name */
    public boolean f7304f = true;

    /* renamed from: g, reason: collision with root package name */
    public long f7305g;

    public A(Handler handler, String str) {
        this.f7299a = handler;
        this.f7300b = str;
    }

    public final boolean a() {
        return !this.f7304f && SystemClock.uptimeMillis() >= this.f7305g + this.f7302d;
    }

    public final long b() {
        return SystemClock.uptimeMillis() - this.f7305g;
    }

    public final List<C1151x> c() {
        ArrayList arrayList;
        long jCurrentTimeMillis = System.currentTimeMillis();
        synchronized (this.f7301c) {
            try {
                arrayList = new ArrayList(this.f7301c.size());
                for (int i10 = 0; i10 < this.f7301c.size(); i10++) {
                    C1151x c1151x = this.f7301c.get(i10);
                    if (!c1151x.f7652e && jCurrentTimeMillis - c1151x.f7649b < 200000) {
                        arrayList.add(c1151x);
                        c1151x.f7652e = true;
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return arrayList;
    }

    public final void d() {
        StringBuilder sb2 = new StringBuilder(1024);
        long jNanoTime = System.nanoTime();
        try {
            StackTraceElement[] stackTrace = e().getStackTrace();
            if (stackTrace.length == 0) {
                sb2.append("Thread does not have stack trace.\n");
            } else {
                for (StackTraceElement stackTraceElement : stackTrace) {
                    sb2.append(stackTraceElement);
                    sb2.append("\n");
                }
            }
        } catch (SecurityException e10) {
            sb2.append("getStackTrace() encountered:\n");
            sb2.append(e10.getMessage());
            sb2.append("\n");
            C1139k.e(e10);
        }
        long jNanoTime2 = System.nanoTime();
        C1151x c1151x = new C1151x(sb2.toString(), System.currentTimeMillis());
        c1151x.f7651d = jNanoTime2 - jNanoTime;
        String name = e().getName();
        if (name == null) {
            name = "";
        }
        c1151x.f7648a = name;
        synchronized (this.f7301c) {
            while (this.f7301c.size() >= 32) {
                try {
                    this.f7301c.remove(0);
                } catch (Throwable th) {
                    throw th;
                }
            }
            this.f7301c.add(c1151x);
        }
    }

    public final Thread e() {
        return this.f7299a.getLooper().getThread();
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f7304f = true;
        this.f7302d = this.f7303e;
    }
}
