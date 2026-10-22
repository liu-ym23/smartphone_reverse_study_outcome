package d8;

import java.util.concurrent.Executor;
import java.util.function.BiFunction;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final /* synthetic */ class i0 implements BiFunction {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f2019a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ k0 f2020b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Executor f2021c;

    public /* synthetic */ i0(k0 k0Var, Executor executor, int i8) {
        this.f2019a = i8;
        this.f2020b = k0Var;
        this.f2021c = executor;
    }

    @Override // java.util.function.BiFunction
    public final Object apply(Object obj, Object obj2) {
        j1 j1Var = (j1) obj;
        Throwable th = (Throwable) obj2;
        switch (this.f2019a) {
        }
        return this.f2020b.a(j1Var, th, this.f2021c);
    }
}
