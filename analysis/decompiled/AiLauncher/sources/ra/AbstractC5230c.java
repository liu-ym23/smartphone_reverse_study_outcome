package ra;

import ra.C5231d;

/* renamed from: ra.c, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public abstract class AbstractC5230c {

    /* renamed from: ra.c$a */
    public static final class a extends AbstractC5230c {

        /* renamed from: a, reason: collision with root package name */
        public static final a f38854a = new a();

        /* renamed from: b, reason: collision with root package name */
        public static final int f38855b;

        static {
            C5231d.a aVar = C5231d.f38857c;
            f38855b = (~(aVar.i() | aVar.d())) & aVar.b();
        }

        @Override // ra.AbstractC5230c
        public int a() {
            return f38855b;
        }
    }

    /* renamed from: ra.c$b */
    public static final class b extends AbstractC5230c {

        /* renamed from: a, reason: collision with root package name */
        public static final b f38856a = new b();

        @Override // ra.AbstractC5230c
        public int a() {
            return 0;
        }
    }

    public abstract int a();

    public String toString() {
        return getClass().getSimpleName();
    }
}
