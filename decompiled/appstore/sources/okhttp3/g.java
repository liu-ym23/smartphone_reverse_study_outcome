package okhttp3;

import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import okhttp3.internal.Util;
import okio.Buffer;
import okio.BufferedSink;

/* JADX INFO: loaded from: classes4.dex */
public final class g extends RequestBody {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final MediaType f22943c = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List f22944a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List f22945b;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final List f22946a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final List f22947b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final Charset f22948c;

        public a() {
            this(null);
        }

        public a a(String r10, String r11) {
            if (r10 == null) goto L9;
            if (r11 == null) goto L7;
            this.f22946a.add(HttpUrl.c(r10, " \"':;<=>@[]^`{}|/\\?#&!$(),~", false, false, true, true, this.f22948c));
            this.f22947b.add(HttpUrl.c(r11, " \"':;<=>@[]^`{}|/\\?#&!$(),~", false, false, true, true, this.f22948c));
            return this;
        L7:
            throw new NullPointerException("value == null");
        L9:
            throw new NullPointerException("name == null");
        }

        public a b(String r10, String r11) {
            if (r10 == null) goto L9;
            if (r11 == null) goto L7;
            this.f22946a.add(HttpUrl.c(r10, " \"':;<=>@[]^`{}|/\\?#&!$(),~", true, false, true, true, this.f22948c));
            this.f22947b.add(HttpUrl.c(r11, " \"':;<=>@[]^`{}|/\\?#&!$(),~", true, false, true, true, this.f22948c));
            return this;
        L7:
            throw new NullPointerException("value == null");
        L9:
            throw new NullPointerException("name == null");
        }

        public g c() {
            return new g(this.f22946a, this.f22947b);
        }

        public a(Charset r10) {
            this.f22946a = new ArrayList();
            this.f22947b = new ArrayList();
            this.f22948c = r10;
        }
    }

    static {
        f22943c = MediaType.c("application/x-www-form-urlencoded");
    }

    public g(List r10, List r11) {
        this.f22944a = Util.immutableList(r10);
        this.f22945b = Util.immutableList(r11);
    }

    @Override // okhttp3.RequestBody
    public long a() {
        return h(null, true);
    }

    @Override // okhttp3.RequestBody
    public MediaType b() {
        return f22943c;
    }

    @Override // okhttp3.RequestBody
    public void g(BufferedSink r10) {
        h(r10, false);
    }

    public final long h(BufferedSink r10, boolean r11) {
        if (r11 == false) goto L4;
        Buffer r12 = new Buffer();
    L5:
        int r13 = this.f22944a.size();
        int r14 = 0;
    L6:
        if (r14 >= r13) goto L10;
        if (r14 <= 0) goto L9;
        r12.t(38);
    L9:
        r12.E((String) this.f22944a.get(r14));
        r12.t(61);
        r12.E((String) this.f22945b.get(r14));
        r14 = r14 + 1;
        goto L6
    L10:
        if (r11 == false) goto L12;
        long r15 = r12.size();
        r12.a();
        return r15;
    L12:
        return 0;
    L4:
        r12 = r10.buffer();
        goto L5
    }
}
