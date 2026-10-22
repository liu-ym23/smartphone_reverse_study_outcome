package d2;

import com.google.android.datatransport.cct.internal.ClientInfo;
import com.google.android.datatransport.cct.internal.QosTier;
import d2.C3947e;
import java.util.List;

/* renamed from: d2.i, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public abstract class AbstractC3951i {

    /* renamed from: d2.i$a */
    public static abstract class a {
        public abstract AbstractC3951i a();

        public abstract a b(ClientInfo clientInfo);

        public abstract a c(List<AbstractC3950h> list);

        public abstract a d(Integer num);

        public abstract a e(String str);

        public abstract a f(QosTier qosTier);

        public abstract a g(long j10);

        public abstract a h(long j10);

        public a i(int i10) {
            return d(Integer.valueOf(i10));
        }

        public a j(String str) {
            return e(str);
        }
    }

    public static a a() {
        return new C3947e.b();
    }

    public abstract ClientInfo b();

    public abstract List<AbstractC3950h> c();

    public abstract Integer d();

    public abstract String e();

    public abstract QosTier f();

    public abstract long g();

    public abstract long h();
}
