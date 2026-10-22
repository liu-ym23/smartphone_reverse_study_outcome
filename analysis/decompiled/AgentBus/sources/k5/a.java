package k5;

import ia.n0;
import ia.x;
import ia.z0;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* loaded from: classes.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public final x f5616a;

    /* renamed from: b, reason: collision with root package name */
    public final x f5617b;

    /* renamed from: c, reason: collision with root package name */
    public final x f5618c;

    /* renamed from: d, reason: collision with root package name */
    public final x f5619d;

    public a() {
        pa.e eVar = n0.f4982a;
        pa.d dVar = pa.d.f8556h;
        dVar.getClass();
        pa.l lVar = pa.l.f8570h;
        x xVarT = lVar.T(8);
        ExecutorService executorServiceNewSingleThreadExecutor = Executors.newSingleThreadExecutor(new com.stepos.probe.b(1));
        q7.k.d(executorServiceNewSingleThreadExecutor, "newSingleThreadExecutor(...)");
        new z0(executorServiceNewSingleThreadExecutor);
        dVar.getClass();
        x xVarT2 = lVar.T(4);
        ExecutorService executorServiceNewSingleThreadExecutor2 = Executors.newSingleThreadExecutor(new com.stepos.probe.b(2));
        q7.k.d(executorServiceNewSingleThreadExecutor2, "newSingleThreadExecutor(...)");
        z0 z0Var = new z0(executorServiceNewSingleThreadExecutor2);
        dVar.getClass();
        x xVarT3 = lVar.T(2);
        this.f5616a = xVarT;
        this.f5617b = xVarT2;
        this.f5618c = z0Var;
        this.f5619d = xVarT3;
    }
}
