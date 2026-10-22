package B5;

import C5.f;

/* loaded from: classes3.dex */
public abstract class b {

    /* renamed from: a, reason: collision with root package name */
    public static volatile String f194a = "";
    public static volatile boolean b;
    public static final Object c = new Object();

    public static final void a() {
        synchronized (c) {
            if (b) {
                try {
                    f fVarC = f.c();
                    synchronized (fVarC) {
                        fVarC.h = null;
                    }
                } catch (Throwable th) {
                    kotlin.b.a(th);
                }
                b = false;
            }
        }
    }
}
