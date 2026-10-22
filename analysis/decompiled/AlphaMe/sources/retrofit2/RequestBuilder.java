package retrofit2;

import B0.g;
import h3.C;
import h3.C0611u;
import h3.D;
import h3.G;
import h3.H;
import h3.I;
import h3.J;
import h3.M;
import h3.N;
import h3.O;
import h3.P;
import h3.U;
import h3.Z;
import java.io.IOException;
import java.util.ArrayList;
import java.util.regex.Pattern;
import javax.annotation.Nullable;
import k3.C0694i;
import k3.InterfaceC0695j;
import kotlin.UByte;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.internal.Util;

/* loaded from: classes2.dex */
final class RequestBuilder {
    private static final String PATH_SEGMENT_ALWAYS_ENCODE_SET = " \"<>^`{}|\\?#";
    private final J baseUrl;

    @Nullable
    private Z body;

    @Nullable
    private M contentType;

    @Nullable
    private C formBuilder;
    private final boolean hasBody;
    private final G headersBuilder;
    private final String method;

    @Nullable
    private N multipartBuilder;

    @Nullable
    private String relativeUrl;
    private final U requestBuilder = new U();

    @Nullable
    private I urlBuilder;
    private static final char[] HEX_DIGITS = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
    private static final Pattern PATH_TRAVERSAL = Pattern.compile("(.*/)?(\\.|%2e|%2E){1,2}(/.*)?");

    public static class ContentTypeOverridingRequestBody extends Z {
        private final M contentType;
        private final Z delegate;

        public ContentTypeOverridingRequestBody(Z z4, M m4) {
            this.delegate = z4;
            this.contentType = m4;
        }

        @Override // h3.Z
        public long contentLength() throws IOException {
            return this.delegate.contentLength();
        }

        @Override // h3.Z
        public M contentType() {
            return this.contentType;
        }

        @Override // h3.Z
        public void writeTo(InterfaceC0695j interfaceC0695j) throws IOException {
            this.delegate.writeTo(interfaceC0695j);
        }
    }

    public RequestBuilder(String str, J j4, @Nullable String str2, @Nullable H h4, @Nullable M m4, boolean z4, boolean z5, boolean z6) {
        this.method = str;
        this.baseUrl = j4;
        this.relativeUrl = str2;
        this.contentType = m4;
        this.hasBody = z4;
        if (h4 != null) {
            this.headersBuilder = h4.d();
        } else {
            this.headersBuilder = new G();
        }
        if (z5) {
            this.formBuilder = new C();
            return;
        }
        if (z6) {
            N n4 = new N();
            this.multipartBuilder = n4;
            M type = P.f12743f;
            Intrinsics.checkNotNullParameter(type, "type");
            if (!Intrinsics.areEqual(type.f12735b, "multipart")) {
                throw new IllegalArgumentException(Intrinsics.stringPlus("multipart != ", type).toString());
            }
            n4.f12738b = type;
        }
    }

    private static void canonicalizeForPath(C0694i c0694i, String str, int i4, int i5, boolean z4) {
        C0694i c0694i2 = null;
        while (i4 < i5) {
            int iCodePointAt = str.codePointAt(i4);
            if (!z4 || (iCodePointAt != 9 && iCodePointAt != 10 && iCodePointAt != 12 && iCodePointAt != 13)) {
                if (iCodePointAt < 32 || iCodePointAt >= 127 || PATH_SEGMENT_ALWAYS_ENCODE_SET.indexOf(iCodePointAt) != -1 || (!z4 && (iCodePointAt == 47 || iCodePointAt == 37))) {
                    if (c0694i2 == null) {
                        c0694i2 = new C0694i();
                    }
                    c0694i2.e0(iCodePointAt);
                    while (!c0694i2.s()) {
                        byte b4 = c0694i2.readByte();
                        int i6 = b4 & UByte.MAX_VALUE;
                        c0694i.V(37);
                        char[] cArr = HEX_DIGITS;
                        c0694i.V(cArr[(i6 >> 4) & 15]);
                        c0694i.V(cArr[b4 & 15]);
                    }
                } else {
                    c0694i.e0(iCodePointAt);
                }
            }
            i4 += Character.charCount(iCodePointAt);
        }
    }

    public void addFormField(String name, String value, boolean z4) {
        if (z4) {
            C c4 = this.formBuilder;
            c4.getClass();
            Intrinsics.checkNotNullParameter(name, "name");
            Intrinsics.checkNotNullParameter(value, "value");
            ArrayList arrayList = c4.f12701a;
            char[] cArr = J.f12721k;
            arrayList.add(C0611u.c(name, 0, 0, " \"':;<=>@[]^`{}|/\\?#&!$(),~", true, false, true, false, null, 83));
            c4.f12702b.add(C0611u.c(value, 0, 0, " \"':;<=>@[]^`{}|/\\?#&!$(),~", true, false, true, false, null, 83));
            return;
        }
        C c5 = this.formBuilder;
        c5.getClass();
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(value, "value");
        ArrayList arrayList2 = c5.f12701a;
        char[] cArr2 = J.f12721k;
        arrayList2.add(C0611u.c(name, 0, 0, " \"':;<=>@[]^`{}|/\\?#&!$(),~", false, false, true, false, null, 91));
        c5.f12702b.add(C0611u.c(value, 0, 0, " \"':;<=>@[]^`{}|/\\?#&!$(),~", false, false, true, false, null, 91));
    }

    public void addHeader(String str, String str2) {
        if (!"Content-Type".equalsIgnoreCase(str)) {
            this.headersBuilder.a(str, str2);
            return;
        }
        try {
            Pattern pattern = M.f12732d;
            this.contentType = C0611u.o(str2);
        } catch (IllegalArgumentException e4) {
            throw new IllegalArgumentException(g.m("Malformed content type: ", str2), e4);
        }
    }

    public void addHeaders(H headers) {
        G g4 = this.headersBuilder;
        g4.getClass();
        Intrinsics.checkNotNullParameter(headers, "headers");
        int size = headers.size();
        for (int i4 = 0; i4 < size; i4++) {
            g4.c(headers.c(i4), headers.f(i4));
        }
    }

    public void addPart(H h4, Z body) {
        N n4 = this.multipartBuilder;
        n4.getClass();
        Intrinsics.checkNotNullParameter(body, "body");
        Intrinsics.checkNotNullParameter(body, "body");
        if ((h4 == null ? null : h4.a("Content-Type")) != null) {
            throw new IllegalArgumentException("Unexpected header: Content-Type".toString());
        }
        if ((h4 != null ? h4.a("Content-Length") : null) != null) {
            throw new IllegalArgumentException("Unexpected header: Content-Length".toString());
        }
        O part = new O(h4, body);
        Intrinsics.checkNotNullParameter(part, "part");
        n4.f12739c.add(part);
    }

    public void addPathParam(String str, String str2, boolean z4) {
        if (this.relativeUrl == null) {
            throw new AssertionError();
        }
        String strCanonicalizeForPath = canonicalizeForPath(str2, z4);
        String strReplace = this.relativeUrl.replace("{" + str + "}", strCanonicalizeForPath);
        if (PATH_TRAVERSAL.matcher(strReplace).matches()) {
            throw new IllegalArgumentException(g.m("@Path parameters shouldn't perform path traversal ('.' or '..'): ", str2));
        }
        this.relativeUrl = strReplace;
    }

    public void addQueryParam(String str, @Nullable String str2, boolean z4) {
        String str3 = this.relativeUrl;
        if (str3 != null) {
            I iG = this.baseUrl.g(str3);
            this.urlBuilder = iG;
            if (iG == null) {
                throw new IllegalArgumentException("Malformed URL. Base: " + this.baseUrl + ", Relative: " + this.relativeUrl);
            }
            this.relativeUrl = null;
        }
        if (z4) {
            this.urlBuilder.a(str, str2);
        } else {
            this.urlBuilder.b(str, str2);
        }
    }

    public <T> void addTag(Class<T> cls, @Nullable T t4) {
        this.requestBuilder.f(cls, t4);
    }

    public U get() {
        J url;
        I i4 = this.urlBuilder;
        if (i4 != null) {
            url = i4.c();
        } else {
            J j4 = this.baseUrl;
            String link = this.relativeUrl;
            j4.getClass();
            Intrinsics.checkNotNullParameter(link, "link");
            I iG = j4.g(link);
            url = iG == null ? null : iG.c();
            if (url == null) {
                throw new IllegalArgumentException("Malformed URL. Base: " + this.baseUrl + ", Relative: " + this.relativeUrl);
            }
        }
        Z contentTypeOverridingRequestBody = this.body;
        if (contentTypeOverridingRequestBody == null) {
            C c4 = this.formBuilder;
            if (c4 != null) {
                contentTypeOverridingRequestBody = new D(c4.f12701a, c4.f12702b);
            } else {
                N n4 = this.multipartBuilder;
                if (n4 != null) {
                    ArrayList arrayList = n4.f12739c;
                    if (!(!arrayList.isEmpty())) {
                        throw new IllegalStateException("Multipart body must have at least one part.".toString());
                    }
                    contentTypeOverridingRequestBody = new P(n4.f12737a, n4.f12738b, Util.toImmutableList(arrayList));
                } else if (this.hasBody) {
                    contentTypeOverridingRequestBody = Z.create((M) null, new byte[0]);
                }
            }
        }
        M m4 = this.contentType;
        if (m4 != null) {
            if (contentTypeOverridingRequestBody != null) {
                contentTypeOverridingRequestBody = new ContentTypeOverridingRequestBody(contentTypeOverridingRequestBody, m4);
            } else {
                this.headersBuilder.a("Content-Type", m4.f12734a);
            }
        }
        U u4 = this.requestBuilder;
        u4.getClass();
        Intrinsics.checkNotNullParameter(url, "url");
        u4.f12821a = url;
        H headers = this.headersBuilder.d();
        Intrinsics.checkNotNullParameter(headers, "headers");
        G gD = headers.d();
        Intrinsics.checkNotNullParameter(gD, "<set-?>");
        u4.f12823c = gD;
        u4.d(this.method, contentTypeOverridingRequestBody);
        return u4;
    }

    public void setBody(Z z4) {
        this.body = z4;
    }

    public void setRelativeUrl(Object obj) {
        this.relativeUrl = obj.toString();
    }

    public void addPart(O part) {
        N n4 = this.multipartBuilder;
        n4.getClass();
        Intrinsics.checkNotNullParameter(part, "part");
        n4.f12739c.add(part);
    }

    private static String canonicalizeForPath(String str, boolean z4) {
        int length = str.length();
        int iCharCount = 0;
        while (iCharCount < length) {
            int iCodePointAt = str.codePointAt(iCharCount);
            if (iCodePointAt >= 32 && iCodePointAt < 127 && PATH_SEGMENT_ALWAYS_ENCODE_SET.indexOf(iCodePointAt) == -1 && (z4 || (iCodePointAt != 47 && iCodePointAt != 37))) {
                iCharCount += Character.charCount(iCodePointAt);
            } else {
                C0694i c0694i = new C0694i();
                c0694i.c0(0, iCharCount, str);
                canonicalizeForPath(c0694i, str, iCharCount, length, z4);
                return c0694i.O();
            }
        }
        return str;
    }
}
