package fc;

import gc.b.a;
import java.util.Iterator;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class n implements Iterable, ac.a {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f8825a;

    /* renamed from: b, reason: collision with root package name */
    public final Object f8826b;

    public /* synthetic */ n(Object obj, int i10) {
        this.f8825a = i10;
        this.f8826b = obj;
    }

    @Override // java.lang.Iterable
    public final Iterator iterator() {
        switch (this.f8825a) {
            case 0:
                return ((gc.b) this.f8826b).new a();
            default:
                return new kotlin.jvm.internal.a((Iterator) ((zb.a) this.f8826b).invoke());
        }
    }
}
