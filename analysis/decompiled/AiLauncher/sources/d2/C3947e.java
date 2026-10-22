package d2;

import com.google.android.datatransport.cct.internal.ClientInfo;
import com.google.android.datatransport.cct.internal.QosTier;
import d2.AbstractC3951i;
import java.util.List;

/* renamed from: d2.e, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C3947e extends AbstractC3951i {

    /* renamed from: a, reason: collision with root package name */
    public final long f32091a;

    /* renamed from: b, reason: collision with root package name */
    public final long f32092b;

    /* renamed from: c, reason: collision with root package name */
    public final ClientInfo f32093c;

    /* renamed from: d, reason: collision with root package name */
    public final Integer f32094d;

    /* renamed from: e, reason: collision with root package name */
    public final String f32095e;

    /* renamed from: f, reason: collision with root package name */
    public final List<AbstractC3950h> f32096f;

    /* renamed from: g, reason: collision with root package name */
    public final QosTier f32097g;

    /* renamed from: d2.e$b */
    public static final class b extends AbstractC3951i.a {

        /* renamed from: a, reason: collision with root package name */
        public Long f32098a;

        /* renamed from: b, reason: collision with root package name */
        public Long f32099b;

        /* renamed from: c, reason: collision with root package name */
        public ClientInfo f32100c;

        /* renamed from: d, reason: collision with root package name */
        public Integer f32101d;

        /* renamed from: e, reason: collision with root package name */
        public String f32102e;

        /* renamed from: f, reason: collision with root package name */
        public List<AbstractC3950h> f32103f;

        /* renamed from: g, reason: collision with root package name */
        public QosTier f32104g;

        @Override // d2.AbstractC3951i.a
        public AbstractC3951i a() {
            String str = "";
            if (this.f32098a == null) {
                str = " requestTimeMs";
            }
            if (this.f32099b == null) {
                str = str + " requestUptimeMs";
            }
            if (str.isEmpty()) {
                return new C3947e(this.f32098a.longValue(), this.f32099b.longValue(), this.f32100c, this.f32101d, this.f32102e, this.f32103f, this.f32104g);
            }
            throw new IllegalStateException("Missing required properties:" + str);
        }

        @Override // d2.AbstractC3951i.a
        public AbstractC3951i.a b(ClientInfo clientInfo) {
            this.f32100c = clientInfo;
            return this;
        }

        @Override // d2.AbstractC3951i.a
        public AbstractC3951i.a c(List<AbstractC3950h> list) {
            this.f32103f = list;
            return this;
        }

        @Override // d2.AbstractC3951i.a
        public AbstractC3951i.a d(Integer num) {
            this.f32101d = num;
            return this;
        }

        @Override // d2.AbstractC3951i.a
        public AbstractC3951i.a e(String str) {
            this.f32102e = str;
            return this;
        }

        @Override // d2.AbstractC3951i.a
        public AbstractC3951i.a f(QosTier qosTier) {
            this.f32104g = qosTier;
            return this;
        }

        @Override // d2.AbstractC3951i.a
        public AbstractC3951i.a g(long j10) {
            this.f32098a = Long.valueOf(j10);
            return this;
        }

        @Override // d2.AbstractC3951i.a
        public AbstractC3951i.a h(long j10) {
            this.f32099b = Long.valueOf(j10);
            return this;
        }
    }

    @Override // d2.AbstractC3951i
    public ClientInfo b() {
        return this.f32093c;
    }

    @Override // d2.AbstractC3951i
    public List<AbstractC3950h> c() {
        return this.f32096f;
    }

    @Override // d2.AbstractC3951i
    public Integer d() {
        return this.f32094d;
    }

    @Override // d2.AbstractC3951i
    public String e() {
        return this.f32095e;
    }

    public boolean equals(Object obj) {
        ClientInfo clientInfo;
        Integer num;
        String str;
        List<AbstractC3950h> list;
        QosTier qosTier;
        if (obj == this) {
            return true;
        }
        if (obj instanceof AbstractC3951i) {
            AbstractC3951i abstractC3951i = (AbstractC3951i) obj;
            if (this.f32091a == abstractC3951i.g() && this.f32092b == abstractC3951i.h() && ((clientInfo = this.f32093c) != null ? clientInfo.equals(abstractC3951i.b()) : abstractC3951i.b() == null) && ((num = this.f32094d) != null ? num.equals(abstractC3951i.d()) : abstractC3951i.d() == null) && ((str = this.f32095e) != null ? str.equals(abstractC3951i.e()) : abstractC3951i.e() == null) && ((list = this.f32096f) != null ? list.equals(abstractC3951i.c()) : abstractC3951i.c() == null) && ((qosTier = this.f32097g) != null ? qosTier.equals(abstractC3951i.f()) : abstractC3951i.f() == null)) {
                return true;
            }
        }
        return false;
    }

    @Override // d2.AbstractC3951i
    public QosTier f() {
        return this.f32097g;
    }

    @Override // d2.AbstractC3951i
    public long g() {
        return this.f32091a;
    }

    @Override // d2.AbstractC3951i
    public long h() {
        return this.f32092b;
    }

    public int hashCode() {
        long j10 = this.f32091a;
        long j11 = this.f32092b;
        int i10 = (((((int) (j10 ^ (j10 >>> 32))) ^ 1000003) * 1000003) ^ ((int) ((j11 >>> 32) ^ j11))) * 1000003;
        ClientInfo clientInfo = this.f32093c;
        int iHashCode = (i10 ^ (clientInfo == null ? 0 : clientInfo.hashCode())) * 1000003;
        Integer num = this.f32094d;
        int iHashCode2 = (iHashCode ^ (num == null ? 0 : num.hashCode())) * 1000003;
        String str = this.f32095e;
        int iHashCode3 = (iHashCode2 ^ (str == null ? 0 : str.hashCode())) * 1000003;
        List<AbstractC3950h> list = this.f32096f;
        int iHashCode4 = (iHashCode3 ^ (list == null ? 0 : list.hashCode())) * 1000003;
        QosTier qosTier = this.f32097g;
        return iHashCode4 ^ (qosTier != null ? qosTier.hashCode() : 0);
    }

    public String toString() {
        return "LogRequest{requestTimeMs=" + this.f32091a + ", requestUptimeMs=" + this.f32092b + ", clientInfo=" + this.f32093c + ", logSource=" + this.f32094d + ", logSourceName=" + this.f32095e + ", logEvents=" + this.f32096f + ", qosTier=" + this.f32097g + "}";
    }

    public C3947e(long j10, long j11, ClientInfo clientInfo, Integer num, String str, List<AbstractC3950h> list, QosTier qosTier) {
        this.f32091a = j10;
        this.f32092b = j11;
        this.f32093c = clientInfo;
        this.f32094d = num;
        this.f32095e = str;
        this.f32096f = list;
        this.f32097g = qosTier;
    }
}
