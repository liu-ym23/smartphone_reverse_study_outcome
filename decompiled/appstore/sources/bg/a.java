package bg;

import java.util.Iterator;
import kotlin.collections.g0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.markers.KMappedMarker;

/* JADX INFO: loaded from: classes4.dex */
public class a implements Iterable, KMappedMarker {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final C0067a f5997d = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f5998a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f5999b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f6000c;

    /* JADX INFO: renamed from: bg.a$a, reason: collision with other inner class name */
    public static final class C0067a {
        public /* synthetic */ C0067a(DefaultConstructorMarker r10) {
            this();
        }

        public final a a(int r10, int r11, int r12) {
            return new a(r10, r11, r12);
        }

        public C0067a() {
        }
    }

    static {
        f5997d = new C0067a(null);
    }

    public a(int r10, int r11, int r12) {
        if (r12 == 0) goto L11;
        if (r12 == Integer.MIN_VALUE) goto L9;
        this.f5998a = r10;
        this.f5999b = uf.c.c(r10, r11, r12);
        this.f6000c = r12;
        return;
    L9:
        throw new IllegalArgumentException("Step must be greater than Int.MIN_VALUE to avoid overflow on negation.");
    L11:
        throw new IllegalArgumentException("Step must be non-zero.");
    }

    public final int a() {
        return this.f5998a;
    }

    public final int b() {
        return this.f5999b;
    }

    public final int c() {
        return this.f6000c;
    }

    public g0 d() {
        return new b(this.f5998a, this.f5999b, this.f6000c);
    }

    public boolean equals(Object r10) {
        if ((r10 instanceof a) == true) goto L5;
    L15:
        return false;
    L5:
        if (isEmpty() == true) goto L7;
    L8:
        a r11 = (a) r10;
        if (this.f5998a != r11.f5998a) goto L15;
        if (this.f5999b != r11.f5999b) goto L15;
        if (this.f6000c != r11.f6000c) goto L15;
    L14:
        return true;
    L7:
        if (((a) r10).isEmpty() == true) goto L14;
        goto L8
    }

    public int hashCode() {
        if (isEmpty() == false) goto L5;
        return -1;
    L5:
        int r10 = ((this.f5998a * 31) + this.f5999b) * 31;
        return this.f6000c + r10;
    }

    public boolean isEmpty() {
        if (this.f6000c <= 0) goto L8;
        if (this.f5998a > this.f5999b) goto L11;
        return false;
    L11:
        return true;
    L8:
        if (this.f5998a < this.f5999b) goto L11;
        return false;
    }

    @Override // java.lang.Iterable
    public /* bridge */ /* synthetic */ Iterator iterator() {
        return d();
    }

    public String toString() {
        if (this.f6000c <= 0) goto L6;
        StringBuilder r10 = new StringBuilder();
        r10.append(this.f5998a);
        r10.append("..");
        r10.append(this.f5999b);
        r10.append(" step ");
        int r11 = this.f6000c;
    L5:
        r10.append(r11);
        return r10.toString();
    L6:
        r10 = new StringBuilder();
        r10.append(this.f5998a);
        r10.append(" downTo ");
        r10.append(this.f5999b);
        r10.append(" step ");
        r11 = -this.f6000c;
        goto L5
    }
}
