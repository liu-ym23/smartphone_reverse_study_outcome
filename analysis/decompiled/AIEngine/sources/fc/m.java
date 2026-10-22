package fc;

import java.util.Iterator;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public class m extends a4.a {

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class a<T> implements i<T> {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Iterator f8824a;

        public a(Iterator it) {
            this.f8824a = it;
        }

        @Override // fc.i
        public final Iterator<T> iterator() {
            return this.f8824a;
        }
    }

    public static <T> i<T> x(Iterator<? extends T> it) {
        kotlin.jvm.internal.g.f(it, "<this>");
        return new fc.a(new a(it));
    }
}
