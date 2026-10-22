package io.ktor.http;

import Z8.C1173v;
import com.fasterxml.jackson.core.JsonPointer;
import io.ktor.utils.io.JvmSerializable_jvmKt;
import java.io.Serializable;
import java.util.List;
import kotlin.C4848b;
import kotlin.Metadata;
import kotlinx.serialization.KSerializer;
import p9.InterfaceC5063a;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0002\b<\b\u0007\u0018\u0000 P2\u00060\u0001j\u0002`\u0002:\u0001PBe\b\u0000\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00050\t\u0012\u0006\u0010\f\u001a\u00020\u000b\u0012\u0006\u0010\r\u001a\u00020\u0005\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0011\u001a\u00020\u0010\u0012\u0006\u0010\u0012\u001a\u00020\u0005¢\u0006\u0004\b\u0013\u0010\u0014J\u000f\u0010\u0016\u001a\u00020\u0015H\u0002¢\u0006\u0004\b\u0016\u0010\u0017J\u000f\u0010\u0018\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0018\u0010\u0019J\u001a\u0010\u001b\u001a\u00020\u00102\b\u0010\u001a\u001a\u0004\u0018\u00010\u0015H\u0096\u0002¢\u0006\u0004\b\u001b\u0010\u001cJ\u000f\u0010\u001d\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u001d\u0010\u001eR\u0017\u0010\u0006\u001a\u00020\u00058\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u001f\u001a\u0004\b \u0010\u0019R\u0017\u0010\b\u001a\u00020\u00078\u0006¢\u0006\f\n\u0004\b\b\u0010!\u001a\u0004\b\"\u0010\u001eR\u0017\u0010\f\u001a\u00020\u000b8\u0006¢\u0006\f\n\u0004\b\f\u0010#\u001a\u0004\b$\u0010%R\u0017\u0010\r\u001a\u00020\u00058\u0006¢\u0006\f\n\u0004\b\r\u0010\u001f\u001a\u0004\b&\u0010\u0019R\u0019\u0010\u000e\u001a\u0004\u0018\u00010\u00058\u0006¢\u0006\f\n\u0004\b\u000e\u0010\u001f\u001a\u0004\b'\u0010\u0019R\u0019\u0010\u000f\u001a\u0004\u0018\u00010\u00058\u0006¢\u0006\f\n\u0004\b\u000f\u0010\u001f\u001a\u0004\b(\u0010\u0019R\u0017\u0010\u0011\u001a\u00020\u00108\u0006¢\u0006\f\n\u0004\b\u0011\u0010)\u001a\u0004\b*\u0010+R\u0014\u0010\u0012\u001a\u00020\u00058\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u001fR&\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00050\t8\u0006X\u0087\u0004¢\u0006\u0012\n\u0004\b\n\u0010,\u0012\u0004\b/\u00100\u001a\u0004\b-\u0010.R\u001d\u00101\u001a\b\u0012\u0004\u0012\u00020\u00050\t8\u0006¢\u0006\f\n\u0004\b1\u0010,\u001a\u0004\b2\u0010.R!\u00106\u001a\b\u0012\u0004\u0012\u00020\u00050\t8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b3\u00104\u001a\u0004\b5\u0010.R\u0019\u00107\u001a\u0004\u0018\u00010\u00038\u0006¢\u0006\f\n\u0004\b7\u00108\u001a\u0004\b9\u0010:R\u0017\u0010\u0004\u001a\u00020\u00038\u0006¢\u0006\f\n\u0004\b\u0004\u00108\u001a\u0004\b;\u0010:R\u001b\u0010>\u001a\u00020\u00058FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b<\u00104\u001a\u0004\b=\u0010\u0019R\u001b\u0010A\u001a\u00020\u00058FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b?\u00104\u001a\u0004\b@\u0010\u0019R\u001b\u0010D\u001a\u00020\u00058FX\u0086\u0084\u0002¢\u0006\f\n\u0004\bB\u00104\u001a\u0004\bC\u0010\u0019R\u001d\u0010G\u001a\u0004\u0018\u00010\u00058FX\u0086\u0084\u0002¢\u0006\f\n\u0004\bE\u00104\u001a\u0004\bF\u0010\u0019R\u001d\u0010J\u001a\u0004\u0018\u00010\u00058FX\u0086\u0084\u0002¢\u0006\f\n\u0004\bH\u00104\u001a\u0004\bI\u0010\u0019R\u001b\u0010M\u001a\u00020\u00058FX\u0086\u0084\u0002¢\u0006\f\n\u0004\bK\u00104\u001a\u0004\bL\u0010\u0019R\u0011\u0010O\u001a\u00020\u00078F¢\u0006\u0006\u001a\u0004\bN\u0010\u001e¨\u0006Q"}, d2 = {"Lio/ktor/http/Url;", "Ljava/io/Serializable;", "Lio/ktor/utils/io/JvmSerializable;", "Lio/ktor/http/URLProtocol;", "protocol", "", "host", "", "specifiedPort", "", "pathSegments", "Lio/ktor/http/Parameters;", "parameters", "fragment", "user", "password", "", "trailingQuery", "urlString", "<init>", "(Lio/ktor/http/URLProtocol;Ljava/lang/String;ILjava/util/List;Lio/ktor/http/Parameters;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;)V", "", "writeReplace", "()Ljava/lang/Object;", "toString", "()Ljava/lang/String;", "other", "equals", "(Ljava/lang/Object;)Z", "hashCode", "()I", "Ljava/lang/String;", "getHost", "I", "getSpecifiedPort", "Lio/ktor/http/Parameters;", "getParameters", "()Lio/ktor/http/Parameters;", "getFragment", "getUser", "getPassword", "Z", "getTrailingQuery", "()Z", "Ljava/util/List;", "getPathSegments", "()Ljava/util/List;", "getPathSegments$annotations", "()V", "rawSegments", "getRawSegments", "segments$delegate", "LY8/h;", "getSegments", "segments", "protocolOrNull", "Lio/ktor/http/URLProtocol;", "getProtocolOrNull", "()Lio/ktor/http/URLProtocol;", "getProtocol", "encodedPath$delegate", "getEncodedPath", "encodedPath", "encodedQuery$delegate", "getEncodedQuery", "encodedQuery", "encodedPathAndQuery$delegate", "getEncodedPathAndQuery", "encodedPathAndQuery", "encodedUser$delegate", "getEncodedUser", "encodedUser", "encodedPassword$delegate", "getEncodedPassword", "encodedPassword", "encodedFragment$delegate", "getEncodedFragment", "encodedFragment", "getPort", "port", "Companion", "ktor-http"}, k = 1, mv = {2, 2, 0}, xi = 48)
@lb.l(with = UrlSerializer.class)
/* loaded from: classes4.dex */
public final class Url implements Serializable {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: encodedFragment$delegate, reason: from kotlin metadata */
    private final Y8.h encodedFragment;

    /* renamed from: encodedPassword$delegate, reason: from kotlin metadata */
    private final Y8.h encodedPassword;

    /* renamed from: encodedPath$delegate, reason: from kotlin metadata */
    private final Y8.h encodedPath;

    /* renamed from: encodedPathAndQuery$delegate, reason: from kotlin metadata */
    private final Y8.h encodedPathAndQuery;

    /* renamed from: encodedQuery$delegate, reason: from kotlin metadata */
    private final Y8.h encodedQuery;

    /* renamed from: encodedUser$delegate, reason: from kotlin metadata */
    private final Y8.h encodedUser;
    private final String fragment;
    private final String host;
    private final Parameters parameters;
    private final String password;
    private final List<String> pathSegments;
    private final URLProtocol protocol;
    private final URLProtocol protocolOrNull;
    private final List<String> rawSegments;

    /* renamed from: segments$delegate, reason: from kotlin metadata */
    private final Y8.h segments;
    private final int specifiedPort;
    private final boolean trailingQuery;
    private final String urlString;
    private final String user;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lio/ktor/http/Url$Companion;", "", "<init>", "()V", "Lkotlinx/serialization/KSerializer;", "Lio/ktor/http/Url;", "serializer", "()Lkotlinx/serialization/KSerializer;", "ktor-http"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(kotlin.jvm.internal.i iVar) {
            this();
        }

        public final KSerializer<Url> serializer() {
            return UrlSerializer.INSTANCE;
        }

        private Companion() {
        }
    }

    public Url(URLProtocol uRLProtocol, String host, int i10, final List<String> pathSegments, Parameters parameters, String fragment, String str, String str2, boolean z10, String urlString) {
        kotlin.jvm.internal.p.i(host, "host");
        kotlin.jvm.internal.p.i(pathSegments, "pathSegments");
        kotlin.jvm.internal.p.i(parameters, "parameters");
        kotlin.jvm.internal.p.i(fragment, "fragment");
        kotlin.jvm.internal.p.i(urlString, "urlString");
        this.host = host;
        this.specifiedPort = i10;
        this.parameters = parameters;
        this.fragment = fragment;
        this.user = str;
        this.password = str2;
        this.trailingQuery = z10;
        this.urlString = urlString;
        if (i10 < 0 || i10 >= 65536) {
            throw new IllegalArgumentException(("Port must be between 0 and 65535, or 0 if not set. Provided: " + i10).toString());
        }
        this.pathSegments = pathSegments;
        this.rawSegments = pathSegments;
        this.segments = C4848b.b(new InterfaceC5063a() { // from class: io.ktor.http.E
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return Url.segments_delegate$lambda$1(pathSegments);
            }
        });
        this.protocolOrNull = uRLProtocol;
        this.protocol = uRLProtocol == null ? URLProtocol.INSTANCE.getHTTP() : uRLProtocol;
        this.encodedPath = C4848b.b(new InterfaceC5063a() { // from class: io.ktor.http.F
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return Url.encodedPath_delegate$lambda$3(pathSegments, this);
            }
        });
        this.encodedQuery = C4848b.b(new InterfaceC5063a() { // from class: io.ktor.http.G
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return Url.encodedQuery_delegate$lambda$4(this.f33284a);
            }
        });
        this.encodedPathAndQuery = C4848b.b(new InterfaceC5063a() { // from class: io.ktor.http.H
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return Url.encodedPathAndQuery_delegate$lambda$5(this.f33285a);
            }
        });
        this.encodedUser = C4848b.b(new InterfaceC5063a() { // from class: io.ktor.http.I
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return Url.encodedUser_delegate$lambda$6(this.f33286a);
            }
        });
        this.encodedPassword = C4848b.b(new InterfaceC5063a() { // from class: io.ktor.http.J
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return Url.encodedPassword_delegate$lambda$7(this.f33287a);
            }
        });
        this.encodedFragment = C4848b.b(new InterfaceC5063a() { // from class: io.ktor.http.K
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return Url.encodedFragment_delegate$lambda$8(this.f33288a);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String encodedFragment_delegate$lambda$8(Url url) {
        int iT0 = La.H.t0(url.urlString, '#', 0, false, 6, null) + 1;
        if (iT0 == 0) {
            return "";
        }
        String strSubstring = url.urlString.substring(iT0);
        kotlin.jvm.internal.p.h(strSubstring, "substring(...)");
        return strSubstring;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String encodedPassword_delegate$lambda$7(Url url) {
        String str = url.password;
        if (str == null) {
            return null;
        }
        if (str.length() == 0) {
            return "";
        }
        String strSubstring = url.urlString.substring(La.H.t0(url.urlString, ':', url.protocol.getName().length() + 3, false, 4, null) + 1, La.H.t0(url.urlString, '@', 0, false, 6, null));
        kotlin.jvm.internal.p.h(strSubstring, "substring(...)");
        return strSubstring;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String encodedPathAndQuery_delegate$lambda$5(Url url) {
        int iT0 = La.H.t0(url.urlString, JsonPointer.SEPARATOR, url.protocol.getName().length() + 3, false, 4, null);
        if (iT0 == -1) {
            return "";
        }
        int iT02 = La.H.t0(url.urlString, '#', iT0, false, 4, null);
        if (iT02 == -1) {
            String strSubstring = url.urlString.substring(iT0);
            kotlin.jvm.internal.p.h(strSubstring, "substring(...)");
            return strSubstring;
        }
        String strSubstring2 = url.urlString.substring(iT0, iT02);
        kotlin.jvm.internal.p.h(strSubstring2, "substring(...)");
        return strSubstring2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String encodedPath_delegate$lambda$3(List list, Url url) {
        int iT0;
        if (list.isEmpty() || (iT0 = La.H.t0(url.urlString, JsonPointer.SEPARATOR, url.protocol.getName().length() + 3, false, 4, null)) == -1) {
            return "";
        }
        int iW0 = La.H.w0(url.urlString, new char[]{'?', '#'}, iT0, false, 4, null);
        if (iW0 == -1) {
            String strSubstring = url.urlString.substring(iT0);
            kotlin.jvm.internal.p.h(strSubstring, "substring(...)");
            return strSubstring;
        }
        String strSubstring2 = url.urlString.substring(iT0, iW0);
        kotlin.jvm.internal.p.h(strSubstring2, "substring(...)");
        return strSubstring2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String encodedQuery_delegate$lambda$4(Url url) {
        int iT0 = La.H.t0(url.urlString, '?', 0, false, 6, null) + 1;
        if (iT0 == 0) {
            return "";
        }
        int iT02 = La.H.t0(url.urlString, '#', iT0, false, 4, null);
        if (iT02 == -1) {
            String strSubstring = url.urlString.substring(iT0);
            kotlin.jvm.internal.p.h(strSubstring, "substring(...)");
            return strSubstring;
        }
        String strSubstring2 = url.urlString.substring(iT0, iT02);
        kotlin.jvm.internal.p.h(strSubstring2, "substring(...)");
        return strSubstring2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String encodedUser_delegate$lambda$6(Url url) {
        String str = url.user;
        if (str == null) {
            return null;
        }
        if (str.length() == 0) {
            return "";
        }
        int length = url.protocol.getName().length() + 3;
        String strSubstring = url.urlString.substring(length, La.H.w0(url.urlString, new char[]{':', '@'}, length, false, 4, null));
        kotlin.jvm.internal.p.h(strSubstring, "substring(...)");
        return strSubstring;
    }

    public static /* synthetic */ void getPathSegments$annotations() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List segments_delegate$lambda$1(List list) {
        if (list.isEmpty()) {
            return C1173v.m();
        }
        return list.subList((((CharSequence) Z8.F.q0(list)).length() != 0 || list.size() <= 1) ? 0 : 1, ((CharSequence) Z8.F.C0(list)).length() == 0 ? C1173v.o(list) : 1 + C1173v.o(list));
    }

    private final Object writeReplace() {
        return JvmSerializable_jvmKt.JvmSerializerReplacement(UrlJvmSerializer.INSTANCE, this);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other == null || Url.class != other.getClass()) {
            return false;
        }
        return kotlin.jvm.internal.p.d(this.urlString, ((Url) other).urlString);
    }

    public final String getEncodedFragment() {
        return (String) this.encodedFragment.getValue();
    }

    public final String getEncodedPassword() {
        return (String) this.encodedPassword.getValue();
    }

    public final String getEncodedPath() {
        return (String) this.encodedPath.getValue();
    }

    public final String getEncodedPathAndQuery() {
        return (String) this.encodedPathAndQuery.getValue();
    }

    public final String getEncodedQuery() {
        return (String) this.encodedQuery.getValue();
    }

    public final String getEncodedUser() {
        return (String) this.encodedUser.getValue();
    }

    public final String getFragment() {
        return this.fragment;
    }

    public final String getHost() {
        return this.host;
    }

    public final Parameters getParameters() {
        return this.parameters;
    }

    public final String getPassword() {
        return this.password;
    }

    public final List<String> getPathSegments() {
        return this.pathSegments;
    }

    public final int getPort() {
        Integer numValueOf = Integer.valueOf(this.specifiedPort);
        if (numValueOf.intValue() == 0) {
            numValueOf = null;
        }
        return numValueOf != null ? numValueOf.intValue() : this.protocol.getDefaultPort();
    }

    public final URLProtocol getProtocol() {
        return this.protocol;
    }

    public final URLProtocol getProtocolOrNull() {
        return this.protocolOrNull;
    }

    public final List<String> getRawSegments() {
        return this.rawSegments;
    }

    public final List<String> getSegments() {
        return (List) this.segments.getValue();
    }

    public final int getSpecifiedPort() {
        return this.specifiedPort;
    }

    public final boolean getTrailingQuery() {
        return this.trailingQuery;
    }

    public final String getUser() {
        return this.user;
    }

    public int hashCode() {
        return this.urlString.hashCode();
    }

    /* renamed from: toString, reason: from getter */
    public String getUrlString() {
        return this.urlString;
    }
}
