package h0;

import android.os.SystemClock;
import g0.AbstractC1450a;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: classes2.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    public boolean f4536a = false;
    public final /* synthetic */ f b;

    public d(f fVar) {
        this.b = fVar;
    }

    public final void a() {
        this.f4536a = false;
        f fVar = this.b;
        boolean z10 = fVar.e;
        long[] jArr = fVar.b;
        if (fVar.d && z10) {
            fVar.b(fVar.m);
            fVar.e = false;
            L0.d.f925a.b(new e(fVar, SystemClock.uptimeMillis()));
        }
        jArr[1] = SystemClock.uptimeMillis();
        jArr[3] = SystemClock.currentThreadTimeMillis();
        CopyOnWriteArrayList copyOnWriteArrayList = fVar.c;
        for (int i = 0; i < copyOnWriteArrayList.size(); i++) {
            AbstractC1450a abstractC1450a = (AbstractC1450a) copyOnWriteArrayList.get(i);
            if (abstractC1450a.f4456a) {
                long j5 = jArr[0];
                long j6 = jArr[2];
                long j10 = jArr[1];
                long j11 = jArr[3];
                abstractC1450a.d(z10);
            }
        }
    }

    public final void b(String str) {
        this.f4536a = true;
        f fVar = this.b;
        fVar.b[0] = SystemClock.uptimeMillis();
        fVar.b[2] = SystemClock.currentThreadTimeMillis();
        CopyOnWriteArrayList copyOnWriteArrayList = fVar.c;
        for (int i = 0; i < copyOnWriteArrayList.size(); i++) {
            AbstractC1450a abstractC1450a = (AbstractC1450a) copyOnWriteArrayList.get(i);
            if (!abstractC1450a.f4456a) {
                abstractC1450a.b(str);
            }
        }
    }
}
