package t3;

import com.google.android.gms.common.internal.C1668i;
import java.util.concurrent.Executor;

/* renamed from: t3.b, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public class C5506b {

    /* renamed from: a, reason: collision with root package name */
    public final int f41997a;

    /* renamed from: b, reason: collision with root package name */
    public final boolean f41998b;

    /* renamed from: c, reason: collision with root package name */
    public final Executor f41999c;

    /* renamed from: t3.b$a */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public int f42000a = 0;

        /* renamed from: b, reason: collision with root package name */
        public boolean f42001b;

        /* renamed from: c, reason: collision with root package name */
        public Executor f42002c;

        public C5506b a() {
            return new C5506b(this.f42000a, this.f42001b, this.f42002c, null, null);
        }

        public a b(int i10, int... iArr) {
            this.f42000a = i10;
            if (iArr != null) {
                for (int i11 : iArr) {
                    this.f42000a = i11 | this.f42000a;
                }
            }
            return this;
        }
    }

    public /* synthetic */ C5506b(int i10, boolean z10, Executor executor, d dVar, e eVar) {
        this.f41997a = i10;
        this.f41998b = z10;
        this.f41999c = executor;
    }

    public final int a() {
        return this.f41997a;
    }

    public final d b() {
        return null;
    }

    public final Executor c() {
        return this.f41999c;
    }

    public final boolean d() {
        return this.f41998b;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof C5506b)) {
            return false;
        }
        C5506b c5506b = (C5506b) obj;
        return this.f41997a == c5506b.f41997a && this.f41998b == c5506b.f41998b && C1668i.a(this.f41999c, c5506b.f41999c) && C1668i.a(null, null);
    }

    public int hashCode() {
        return C1668i.b(Integer.valueOf(this.f41997a), Boolean.valueOf(this.f41998b), this.f41999c, null);
    }
}
