package com.baidu.mshield.x6.e;

import android.content.Context;

/* loaded from: classes.dex */
public class f {

    /* renamed from: a, reason: collision with root package name */
    public static volatile f f8492a;

    /* renamed from: b, reason: collision with root package name */
    public final Context f8493b;

    /* renamed from: c, reason: collision with root package name */
    public final Runnable f8494c = new a();

    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                f fVar = f.this;
                fVar.a(fVar.f8493b);
            } catch (Throwable th) {
                com.baidu.mshield.x6.f.f.b(th);
            }
        }
    }

    public f(Context context) {
        this.f8493b = context;
    }

    public static f b(Context context) {
        if (f8492a == null) {
            synchronized (f.class) {
                try {
                    if (f8492a == null) {
                        f8492a = new f(context);
                    }
                } finally {
                }
            }
        }
        return f8492a;
    }

    public synchronized void a(long j4) {
        try {
            com.baidu.mshield.b.c.a.a("startCheckDelayTime=" + j4);
            com.baidu.mshield.x6.f.c.b().postDelayed(this.f8494c, j4);
        } catch (Throwable th) {
            com.baidu.mshield.x6.f.f.b(th);
        }
    }

    public final void a(Context context) {
        try {
            if (com.baidu.mshield.b.a.d.b(context)) {
                com.baidu.mshield.b.c.a.a(" doDelayWork ");
                com.baidu.mshield.x6.b.b bVar = new com.baidu.mshield.x6.b.b(context);
                if (!com.baidu.mshield.x6.f.f.c().equals(bVar.c())) {
                    h.a(context).a(1, true);
                }
                if (bVar.n() || h.f8498b) {
                    return;
                }
                h.a(context).a(4);
            }
        } catch (Throwable th) {
            com.baidu.mshield.x6.f.f.b(th);
        }
    }
}
