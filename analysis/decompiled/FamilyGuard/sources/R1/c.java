package R1;

import android.content.Context;
import java.util.HashSet;
import java.util.Set;

/* loaded from: classes.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    private final Context f4972a;

    /* renamed from: b, reason: collision with root package name */
    private final int f4973b;

    /* renamed from: c, reason: collision with root package name */
    private final Set<b> f4974c;

    public static class a {

        /* renamed from: a, reason: collision with root package name */
        private final Context f4975a;

        /* renamed from: b, reason: collision with root package name */
        private int f4976b = 2;

        /* renamed from: c, reason: collision with root package name */
        private final Set<b> f4977c = new HashSet();

        a(Context context) {
            this.f4975a = context;
        }

        public a a() {
            return b(new d());
        }

        public a b(b bVar) {
            this.f4977c.add(bVar);
            return this;
        }

        public c c() {
            return new c(this.f4975a, this.f4976b, this.f4977c);
        }
    }

    c(Context context, int i5, Set<b> set) {
        this.f4972a = context;
        this.f4973b = i5;
        this.f4974c = set;
    }

    public static a c(Context context) {
        return new a(context);
    }

    Set<b> a() {
        return this.f4974c;
    }

    int b() {
        return this.f4973b;
    }
}
