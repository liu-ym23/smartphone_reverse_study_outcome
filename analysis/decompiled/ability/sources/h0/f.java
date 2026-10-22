package h0;

import A6.l;
import H.h;
import android.app.Activity;
import android.os.Bundle;
import android.view.Choreographer;
import g0.AbstractC1450a;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashSet;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: classes2.dex */
public final class f implements B.c {
    public static final f p = new f();

    /* renamed from: a, reason: collision with root package name */
    public volatile boolean f4538a;
    public Object f;
    public Object[] g;
    public long[] h;
    public Method i;

    /* renamed from: j, reason: collision with root package name */
    public Choreographer f4539j;
    public l m;
    public boolean o;
    public final long[] b = new long[4];
    public final CopyOnWriteArrayList c = new CopyOnWriteArrayList();
    public boolean d = false;
    public boolean e = false;
    public final long k = 16666666;
    public boolean l = false;
    public long n = -1;

    public static Object a(f fVar, Object obj, String str) {
        try {
            Field declaredField = obj.getClass().getDeclaredField(str);
            declaredField.setAccessible(true);
            return declaredField.get(obj);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static Object e(f fVar, Object obj, String str) throws SecurityException {
        try {
            Field field = (Field) Class.class.getDeclaredMethod("getDeclaredField", String.class).invoke(obj.getClass(), str);
            field.setAccessible(true);
            return field.get(obj);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public final synchronized void b(l lVar) {
        if (this.f4538a) {
            if (this.l) {
                return;
            }
            try {
                synchronized (this.f) {
                    try {
                        Method method = this.i;
                        if (method != null) {
                            method.invoke(this.g[0], -1L, lVar, null);
                            this.l = true;
                        }
                    } finally {
                    }
                }
            } catch (Exception unused) {
            }
        }
    }

    @Override // B.c
    public final void c(Activity activity) {
    }

    public final void d(AbstractC1450a abstractC1450a) {
        if (!this.f4538a) {
            synchronized (this) {
                try {
                    if (h.g()) {
                        if (!this.o) {
                            throw new RuntimeException("never init!");
                        }
                        if (!this.f4538a) {
                            this.f4538a = true;
                        }
                        if (this.d) {
                            b(this.m);
                        }
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        if (this.c.contains(abstractC1450a)) {
            return;
        }
        this.c.add(abstractC1450a);
    }

    @Override // B.c
    public final void f(Activity activity) {
    }

    @Override // B.c
    public final void g(Bundle bundle) {
    }

    @Override // B.c
    public final void onActivityStarted(Activity activity) {
    }

    @Override // B.c
    /* renamed from: c */
    public final void mo0c() {
        if (this.f4539j == null && this.d) {
            HashSet hashSet = J.e.f861a;
            this.f4539j = Choreographer.getInstance();
            L0.d.f925a.b(new l(this, 28));
        }
    }
}
