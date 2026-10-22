package b;

import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public abstract class p {

    /* renamed from: a, reason: collision with root package name */
    public boolean f3026a;

    /* renamed from: b, reason: collision with root package name */
    public final CopyOnWriteArrayList<b> f3027b = new CopyOnWriteArrayList<>();

    /* renamed from: c, reason: collision with root package name */
    public FunctionReferenceImpl f3028c;

    public p(boolean z) {
        this.f3026a = z;
    }

    public abstract void d();

    /* JADX WARN: Type inference failed for: r0v1, types: [kotlin.jvm.internal.FunctionReferenceImpl, zb.a] */
    public final void e(boolean z) {
        this.f3026a = z;
        ?? r02 = this.f3028c;
        if (r02 != 0) {
            r02.invoke();
        }
    }
}
