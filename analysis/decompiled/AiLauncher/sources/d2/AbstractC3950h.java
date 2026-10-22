package d2;

import com.google.android.datatransport.cct.internal.NetworkConnectionInfo;
import d2.C3946d;

/* renamed from: d2.h, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public abstract class AbstractC3950h {

    /* renamed from: d2.h$a */
    public static abstract class a {
        public abstract AbstractC3950h a();

        public abstract a b(Integer num);

        public abstract a c(long j10);

        public abstract a d(long j10);

        public abstract a e(NetworkConnectionInfo networkConnectionInfo);

        public abstract a f(byte[] bArr);

        public abstract a g(String str);

        public abstract a h(long j10);
    }

    public static a a() {
        return new C3946d.b();
    }

    public static a i(String str) {
        return a().g(str);
    }

    public static a j(byte[] bArr) {
        return a().f(bArr);
    }

    public abstract Integer b();

    public abstract long c();

    public abstract long d();

    public abstract NetworkConnectionInfo e();

    public abstract byte[] f();

    public abstract String g();

    public abstract long h();
}
