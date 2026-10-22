package aa7;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes11.dex */
public interface l {

    public static class a extends e {
        public a() {
        }

        @Override // aa7.l.e
        public final ca7.c b(Collection<String> r100) {
            return new ca7.e(r100);
        }
    }

    public static class b extends e {
        public b() {
        }

        @Override // aa7.l.e
        public final ca7.c b(Collection<String> r100) {
            return new ca7.f(r100);
        }
    }

    public static class c extends e {
        public c() {
        }

        @Override // aa7.l.e
        public final ca7.c b(Collection<String> r100) {
            return new ca7.i(r100);
        }
    }

    public static class d extends e {
        public d() {
        }

        @Override // aa7.l.e
        public final ca7.c b(Collection<String> r100) {
            return new ca7.k(r100);
        }
    }

    public static abstract class e extends aa7.a {
        public abstract ca7.c b(Collection<String> r100);

        static {
        }

        public e() {
        }

        @Override // aa7.a
        public final List<ca7.c> a(ba7.a r100, ea7.b r101, int r102) {
            List<ca7.c> r103 = ba7.b.b(r100, (ea7.b) ListProtector.get(r101.f471627b, 0), r102);
            List<ca7.c> r104 = ba7.b.b(r100, (ea7.b) ListProtector.get(r101.f471627b, 1), r102);
            ca7.g r105 = (ca7.g) ListProtector.get(r103, 0);
            ca7.d r106 = (ca7.d) ListProtector.get(r104, 0);
            Object r107 = r106.f22958c;
            if ((r107 instanceof String) == false) goto L6;
            ArrayList r108 = new ArrayList();
            r108.add((String) r106.f22958c);
            Collection<String> r109 = r108;
        L11:
            ca7.c r110 = b(r109);
            r105.a(r110);
            return Collections.singletonList(r110);
        L6:
            if ((r107 instanceof String[]) == false) goto L9;
            r109 = Arrays.asList((String[]) r107);
            goto L11
        L9:
            if ((r107 instanceof Collection) == false) goto L14;
            r109 = (Collection) r107;
            goto L11
        L14:
            throw new IllegalArgumentException();
        }
    }
}
