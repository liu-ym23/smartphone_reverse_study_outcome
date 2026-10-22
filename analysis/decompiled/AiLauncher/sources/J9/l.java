package J9;

import E9.X;
import K9.t;
import kotlin.jvm.internal.p;

/* loaded from: classes5.dex */
public final class l implements Y9.b {

    /* renamed from: a, reason: collision with root package name */
    public static final l f3803a = new l();

    public static final class a implements Y9.a {

        /* renamed from: b, reason: collision with root package name */
        public final t f3804b;

        public a(t javaElement) {
            p.i(javaElement, "javaElement");
            this.f3804b = javaElement;
        }

        @Override // E9.W
        public X b() {
            X NO_SOURCE_FILE = X.f2445a;
            p.h(NO_SOURCE_FILE, "NO_SOURCE_FILE");
            return NO_SOURCE_FILE;
        }

        @Override // Y9.a
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public t c() {
            return this.f3804b;
        }

        public String toString() {
            return a.class.getName() + ": " + c();
        }
    }

    @Override // Y9.b
    public Y9.a a(Z9.l javaElement) {
        p.i(javaElement, "javaElement");
        return new a((t) javaElement);
    }
}
