package kotlin;

import com.google.common.primitives.UnsignedBytes;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;

/* JADX INFO: loaded from: classes4.dex */
public final class e implements Comparable {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final a f21121b = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final byte f21122a;

    public static final class a {
        public /* synthetic */ a(DefaultConstructorMarker r10) {
            this();
        }

        public a() {
        }
    }

    static {
        f21121b = new a(null);
    }

    public /* synthetic */ e(byte r10) {
        this.f21122a = r10;
    }

    public static final /* synthetic */ e a(byte r10) {
        return new e(r10);
    }

    public static byte b(byte r10) {
        return r10;
    }

    public static boolean c(byte r10, Object r11) {
        if ((r11 instanceof e) == true) goto L6;
        return false;
    L6:
        if (r10 == ((e) r11).f()) goto L8;
        return false;
    L8:
        return true;
    }

    public static int d(byte r10) {
        return Byte.hashCode(r10);
    }

    public static String e(byte r10) {
        return String.valueOf(r10 & UnsignedBytes.MAX_VALUE);
    }

    @Override // java.lang.Comparable
    public /* bridge */ /* synthetic */ int compareTo(Object r10) {
        byte r11 = ((e) r10).f();
        return q.i(f() & UnsignedBytes.MAX_VALUE, r11 & UnsignedBytes.MAX_VALUE);
    }

    public boolean equals(Object r10) {
        return c(this.f21122a, r10);
    }

    public final /* synthetic */ byte f() {
        return this.f21122a;
    }

    public int hashCode() {
        return d(this.f21122a);
    }

    public String toString() {
        return e(this.f21122a);
    }
}
