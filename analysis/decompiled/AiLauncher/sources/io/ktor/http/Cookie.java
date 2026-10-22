package io.ktor.http;

import com.stepos.ailauncher.chat.trace.ChatTracker;
import com.stepos.statsapp.v3.lib.plugin.constants.UxipConstants;
import io.ktor.util.date.GMTDate;
import io.ktor.util.date.GMTDate$$serializer;
import io.ktor.utils.io.JvmSerializable_jvmKt;
import java.io.Serializable;
import java.util.Map;
import kotlin.C4848b;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.descriptors.SerialDescriptor;
import mb.C4931a;
import p9.InterfaceC5063a;
import pb.C5089c0;
import pb.E0;
import pb.T0;
import pb.X;
import pb.Y0;

@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b.\b\u0087\b\u0018\u0000 M2\u00060\u0001j\u0002`\u0002:\u0002NMB}\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u000e\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u000e\u0012\u0016\b\u0002\u0010\u0012\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0011¢\u0006\u0004\b\u0013\u0010\u0014B\u0089\u0001\b\u0010\u0012\u0006\u0010\u0015\u001a\u00020\b\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\t\u001a\u0004\u0018\u00010\b\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\n\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u000f\u001a\u00020\u000e\u0012\u0006\u0010\u0010\u001a\u00020\u000e\u0012\u0016\u0010\u0012\u001a\u0012\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u0011\u0012\b\u0010\u0017\u001a\u0004\u0018\u00010\u0016¢\u0006\u0004\b\u0013\u0010\u0018J\u000f\u0010\u001a\u001a\u00020\u0019H\u0002¢\u0006\u0004\b\u001a\u0010\u001bJ'\u0010$\u001a\u00020!2\u0006\u0010\u001c\u001a\u00020\u00002\u0006\u0010\u001e\u001a\u00020\u001d2\u0006\u0010 \u001a\u00020\u001fH\u0001¢\u0006\u0004\b\"\u0010#J\u0010\u0010%\u001a\u00020\u0003HÆ\u0003¢\u0006\u0004\b%\u0010&J\u0010\u0010'\u001a\u00020\u0003HÆ\u0003¢\u0006\u0004\b'\u0010&J\u0010\u0010(\u001a\u00020\u0006HÆ\u0003¢\u0006\u0004\b(\u0010)J\u0012\u0010*\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0004\b*\u0010+J\u0012\u0010,\u001a\u0004\u0018\u00010\nHÆ\u0003¢\u0006\u0004\b,\u0010-J\u0012\u0010.\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0004\b.\u0010&J\u0012\u0010/\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0004\b/\u0010&J\u0010\u00100\u001a\u00020\u000eHÆ\u0003¢\u0006\u0004\b0\u00101J\u0010\u00102\u001a\u00020\u000eHÆ\u0003¢\u0006\u0004\b2\u00101J\u001e\u00103\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0011HÆ\u0003¢\u0006\u0004\b3\u00104J\u008a\u0001\u00105\u001a\u00020\u00002\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00062\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u000f\u001a\u00020\u000e2\b\b\u0002\u0010\u0010\u001a\u00020\u000e2\u0016\b\u0002\u0010\u0012\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0011HÆ\u0001¢\u0006\u0004\b5\u00106J\u0010\u00107\u001a\u00020\u0003HÖ\u0001¢\u0006\u0004\b7\u0010&J\u0010\u00108\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b8\u00109J\u001a\u0010;\u001a\u00020\u000e2\b\u0010:\u001a\u0004\u0018\u00010\u0019HÖ\u0003¢\u0006\u0004\b;\u0010<R\u0017\u0010\u0004\u001a\u00020\u00038\u0006¢\u0006\f\n\u0004\b\u0004\u0010=\u001a\u0004\b>\u0010&R\u0017\u0010\u0005\u001a\u00020\u00038\u0006¢\u0006\f\n\u0004\b\u0005\u0010=\u001a\u0004\b?\u0010&R\u0017\u0010\u0007\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b\u0007\u0010@\u001a\u0004\bA\u0010)R\u0019\u0010\t\u001a\u0004\u0018\u00010\b8G¢\u0006\f\n\u0004\b\t\u0010B\u001a\u0004\bC\u0010+R\u0019\u0010\u000b\u001a\u0004\u0018\u00010\n8\u0006¢\u0006\f\n\u0004\b\u000b\u0010D\u001a\u0004\bE\u0010-R\u0019\u0010\f\u001a\u0004\u0018\u00010\u00038\u0006¢\u0006\f\n\u0004\b\f\u0010=\u001a\u0004\bF\u0010&R\u0019\u0010\r\u001a\u0004\u0018\u00010\u00038\u0006¢\u0006\f\n\u0004\b\r\u0010=\u001a\u0004\bG\u0010&R\u0017\u0010\u000f\u001a\u00020\u000e8\u0006¢\u0006\f\n\u0004\b\u000f\u0010H\u001a\u0004\bI\u00101R\u0017\u0010\u0010\u001a\u00020\u000e8\u0006¢\u0006\f\n\u0004\b\u0010\u0010H\u001a\u0004\bJ\u00101R%\u0010\u0012\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u00118\u0006¢\u0006\f\n\u0004\b\u0012\u0010K\u001a\u0004\bL\u00104¨\u0006O"}, d2 = {"Lio/ktor/http/Cookie;", "Ljava/io/Serializable;", "Lio/ktor/utils/io/JvmSerializable;", "", "name", UxipConstants.f30680s, "Lio/ktor/http/CookieEncoding;", "encoding", "", "maxAge", "Lio/ktor/util/date/GMTDate;", "expires", "domain", "path", "", "secure", "httpOnly", "", "extensions", "<init>", "(Ljava/lang/String;Ljava/lang/String;Lio/ktor/http/CookieEncoding;Ljava/lang/Integer;Lio/ktor/util/date/GMTDate;Ljava/lang/String;Ljava/lang/String;ZZLjava/util/Map;)V", "seen0", "Lpb/T0;", "serializationConstructorMarker", "(ILjava/lang/String;Ljava/lang/String;Lio/ktor/http/CookieEncoding;Ljava/lang/Integer;Lio/ktor/util/date/GMTDate;Ljava/lang/String;Ljava/lang/String;ZZLjava/util/Map;Lpb/T0;)V", "", "writeReplace", "()Ljava/lang/Object;", "self", "Lob/d;", "output", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "serialDesc", "LY8/t;", "write$Self$ktor_http", "(Lio/ktor/http/Cookie;Lob/d;Lkotlinx/serialization/descriptors/SerialDescriptor;)V", "write$Self", "component1", "()Ljava/lang/String;", "component2", "component3", "()Lio/ktor/http/CookieEncoding;", "component4", "()Ljava/lang/Integer;", "component5", "()Lio/ktor/util/date/GMTDate;", "component6", "component7", "component8", "()Z", "component9", "component10", "()Ljava/util/Map;", ChatTracker.CLICK_COPY, "(Ljava/lang/String;Ljava/lang/String;Lio/ktor/http/CookieEncoding;Ljava/lang/Integer;Lio/ktor/util/date/GMTDate;Ljava/lang/String;Ljava/lang/String;ZZLjava/util/Map;)Lio/ktor/http/Cookie;", "toString", "hashCode", "()I", "other", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getName", "getValue", "Lio/ktor/http/CookieEncoding;", "getEncoding", "Ljava/lang/Integer;", "getMaxAgeInt", "Lio/ktor/util/date/GMTDate;", "getExpires", "getDomain", "getPath", "Z", "getSecure", "getHttpOnly", "Ljava/util/Map;", "getExtensions", "Companion", "$serializer", "ktor-http"}, k = 1, mv = {2, 2, 0}, xi = 48)
@lb.l
/* loaded from: classes4.dex */
public final /* data */ class Cookie implements Serializable {
    private static final Y8.h<KSerializer<Object>>[] $childSerializers;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final String domain;
    private final CookieEncoding encoding;
    private final GMTDate expires;
    private final Map<String, String> extensions;
    private final boolean httpOnly;
    private final Integer maxAge;
    private final String name;
    private final String path;
    private final boolean secure;
    private final String value;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lio/ktor/http/Cookie$Companion;", "", "<init>", "()V", "Lkotlinx/serialization/KSerializer;", "Lio/ktor/http/Cookie;", "serializer", "()Lkotlinx/serialization/KSerializer;", "ktor-http"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public final KSerializer<Cookie> serializer() {
            return Cookie$$serializer.INSTANCE;
        }

        public /* synthetic */ Companion(kotlin.jvm.internal.i iVar) {
            this();
        }
    }

    static {
        LazyThreadSafetyMode lazyThreadSafetyMode = LazyThreadSafetyMode.PUBLICATION;
        $childSerializers = new Y8.h[]{null, null, C4848b.a(lazyThreadSafetyMode, new InterfaceC5063a() { // from class: io.ktor.http.e
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return Cookie._childSerializers$_anonymous_();
            }
        }), null, null, null, null, null, null, C4848b.a(lazyThreadSafetyMode, new InterfaceC5063a() { // from class: io.ktor.http.f
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return Cookie._childSerializers$_anonymous_$0();
            }
        })};
    }

    public /* synthetic */ Cookie(int i10, String str, String str2, CookieEncoding cookieEncoding, Integer num, GMTDate gMTDate, String str3, String str4, boolean z10, boolean z11, Map map, T0 t02) {
        if (3 != (i10 & 3)) {
            E0.a(i10, 3, Cookie$$serializer.INSTANCE.getDescriptor());
        }
        this.name = str;
        this.value = str2;
        if ((i10 & 4) == 0) {
            this.encoding = CookieEncoding.URI_ENCODING;
        } else {
            this.encoding = cookieEncoding;
        }
        if ((i10 & 8) == 0) {
            this.maxAge = null;
        } else {
            this.maxAge = num;
        }
        if ((i10 & 16) == 0) {
            this.expires = null;
        } else {
            this.expires = gMTDate;
        }
        if ((i10 & 32) == 0) {
            this.domain = null;
        } else {
            this.domain = str3;
        }
        if ((i10 & 64) == 0) {
            this.path = null;
        } else {
            this.path = str4;
        }
        if ((i10 & 128) == 0) {
            this.secure = false;
        } else {
            this.secure = z10;
        }
        if ((i10 & 256) == 0) {
            this.httpOnly = false;
        } else {
            this.httpOnly = z11;
        }
        if ((i10 & 512) == 0) {
            this.extensions = kotlin.collections.a.i();
        } else {
            this.extensions = map;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final /* synthetic */ KSerializer _childSerializers$_anonymous_() {
        return pb.I.a("io.ktor.http.CookieEncoding", CookieEncoding.values());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final /* synthetic */ KSerializer _childSerializers$_anonymous_$0() {
        Y0 y02 = Y0.f38329a;
        return new C5089c0(y02, C4931a.t(y02));
    }

    public static /* synthetic */ Cookie copy$default(Cookie cookie, String str, String str2, CookieEncoding cookieEncoding, Integer num, GMTDate gMTDate, String str3, String str4, boolean z10, boolean z11, Map map, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = cookie.name;
        }
        if ((i10 & 2) != 0) {
            str2 = cookie.value;
        }
        if ((i10 & 4) != 0) {
            cookieEncoding = cookie.encoding;
        }
        if ((i10 & 8) != 0) {
            num = cookie.maxAge;
        }
        if ((i10 & 16) != 0) {
            gMTDate = cookie.expires;
        }
        if ((i10 & 32) != 0) {
            str3 = cookie.domain;
        }
        if ((i10 & 64) != 0) {
            str4 = cookie.path;
        }
        if ((i10 & 128) != 0) {
            z10 = cookie.secure;
        }
        if ((i10 & 256) != 0) {
            z11 = cookie.httpOnly;
        }
        if ((i10 & 512) != 0) {
            map = cookie.extensions;
        }
        boolean z12 = z11;
        Map map2 = map;
        String str5 = str4;
        boolean z13 = z10;
        GMTDate gMTDate2 = gMTDate;
        String str6 = str3;
        return cookie.copy(str, str2, cookieEncoding, num, gMTDate2, str6, str5, z13, z12, map2);
    }

    public static final /* synthetic */ void write$Self$ktor_http(Cookie self, ob.d output, SerialDescriptor serialDesc) {
        Y8.h<KSerializer<Object>>[] hVarArr = $childSerializers;
        output.w(serialDesc, 0, self.name);
        output.w(serialDesc, 1, self.value);
        if (output.y(serialDesc, 2) || self.encoding != CookieEncoding.URI_ENCODING) {
            output.x(serialDesc, 2, hVarArr[2].getValue(), self.encoding);
        }
        if (output.y(serialDesc, 3) || self.maxAge != null) {
            output.k(serialDesc, 3, X.f38325a, self.maxAge);
        }
        if (output.y(serialDesc, 4) || self.expires != null) {
            output.k(serialDesc, 4, GMTDate$$serializer.INSTANCE, self.expires);
        }
        if (output.y(serialDesc, 5) || self.domain != null) {
            output.k(serialDesc, 5, Y0.f38329a, self.domain);
        }
        if (output.y(serialDesc, 6) || self.path != null) {
            output.k(serialDesc, 6, Y0.f38329a, self.path);
        }
        if (output.y(serialDesc, 7) || self.secure) {
            output.v(serialDesc, 7, self.secure);
        }
        if (output.y(serialDesc, 8) || self.httpOnly) {
            output.v(serialDesc, 8, self.httpOnly);
        }
        if (!output.y(serialDesc, 9) && kotlin.jvm.internal.p.d(self.extensions, kotlin.collections.a.i())) {
            return;
        }
        output.x(serialDesc, 9, hVarArr[9].getValue(), self.extensions);
    }

    private final Object writeReplace() {
        return JvmSerializable_jvmKt.JvmSerializerReplacement(CookieJvmSerializer.INSTANCE, this);
    }

    /* renamed from: component1, reason: from getter */
    public final String getName() {
        return this.name;
    }

    public final Map<String, String> component10() {
        return this.extensions;
    }

    /* renamed from: component2, reason: from getter */
    public final String getValue() {
        return this.value;
    }

    /* renamed from: component3, reason: from getter */
    public final CookieEncoding getEncoding() {
        return this.encoding;
    }

    /* renamed from: component4, reason: from getter */
    public final Integer getMaxAge() {
        return this.maxAge;
    }

    /* renamed from: component5, reason: from getter */
    public final GMTDate getExpires() {
        return this.expires;
    }

    /* renamed from: component6, reason: from getter */
    public final String getDomain() {
        return this.domain;
    }

    /* renamed from: component7, reason: from getter */
    public final String getPath() {
        return this.path;
    }

    /* renamed from: component8, reason: from getter */
    public final boolean getSecure() {
        return this.secure;
    }

    /* renamed from: component9, reason: from getter */
    public final boolean getHttpOnly() {
        return this.httpOnly;
    }

    public final Cookie copy(String name, String value, CookieEncoding encoding, Integer maxAge, GMTDate expires, String domain, String path, boolean secure, boolean httpOnly, Map<String, String> extensions) {
        kotlin.jvm.internal.p.i(name, "name");
        kotlin.jvm.internal.p.i(value, "value");
        kotlin.jvm.internal.p.i(encoding, "encoding");
        kotlin.jvm.internal.p.i(extensions, "extensions");
        return new Cookie(name, value, encoding, maxAge, expires, domain, path, secure, httpOnly, extensions);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Cookie)) {
            return false;
        }
        Cookie cookie = (Cookie) other;
        return kotlin.jvm.internal.p.d(this.name, cookie.name) && kotlin.jvm.internal.p.d(this.value, cookie.value) && this.encoding == cookie.encoding && kotlin.jvm.internal.p.d(this.maxAge, cookie.maxAge) && kotlin.jvm.internal.p.d(this.expires, cookie.expires) && kotlin.jvm.internal.p.d(this.domain, cookie.domain) && kotlin.jvm.internal.p.d(this.path, cookie.path) && this.secure == cookie.secure && this.httpOnly == cookie.httpOnly && kotlin.jvm.internal.p.d(this.extensions, cookie.extensions);
    }

    public final String getDomain() {
        return this.domain;
    }

    public final CookieEncoding getEncoding() {
        return this.encoding;
    }

    public final GMTDate getExpires() {
        return this.expires;
    }

    public final Map<String, String> getExtensions() {
        return this.extensions;
    }

    public final boolean getHttpOnly() {
        return this.httpOnly;
    }

    public final Integer getMaxAgeInt() {
        return this.maxAge;
    }

    public final String getName() {
        return this.name;
    }

    public final String getPath() {
        return this.path;
    }

    public final boolean getSecure() {
        return this.secure;
    }

    public final String getValue() {
        return this.value;
    }

    public int hashCode() {
        int iHashCode = ((((this.name.hashCode() * 31) + this.value.hashCode()) * 31) + this.encoding.hashCode()) * 31;
        Integer num = this.maxAge;
        int iHashCode2 = (iHashCode + (num == null ? 0 : num.hashCode())) * 31;
        GMTDate gMTDate = this.expires;
        int iHashCode3 = (iHashCode2 + (gMTDate == null ? 0 : gMTDate.hashCode())) * 31;
        String str = this.domain;
        int iHashCode4 = (iHashCode3 + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.path;
        return ((((((iHashCode4 + (str2 != null ? str2.hashCode() : 0)) * 31) + Boolean.hashCode(this.secure)) * 31) + Boolean.hashCode(this.httpOnly)) * 31) + this.extensions.hashCode();
    }

    public String toString() {
        return "Cookie(name=" + this.name + ", value=" + this.value + ", encoding=" + this.encoding + ", maxAge=" + this.maxAge + ", expires=" + this.expires + ", domain=" + this.domain + ", path=" + this.path + ", secure=" + this.secure + ", httpOnly=" + this.httpOnly + ", extensions=" + this.extensions + ')';
    }

    public Cookie(String name, String value, CookieEncoding encoding, Integer num, GMTDate gMTDate, String str, String str2, boolean z10, boolean z11, Map<String, String> extensions) {
        kotlin.jvm.internal.p.i(name, "name");
        kotlin.jvm.internal.p.i(value, "value");
        kotlin.jvm.internal.p.i(encoding, "encoding");
        kotlin.jvm.internal.p.i(extensions, "extensions");
        this.name = name;
        this.value = value;
        this.encoding = encoding;
        this.maxAge = num;
        this.expires = gMTDate;
        this.domain = str;
        this.path = str2;
        this.secure = z10;
        this.httpOnly = z11;
        this.extensions = extensions;
    }

    public /* synthetic */ Cookie(String str, String str2, CookieEncoding cookieEncoding, Integer num, GMTDate gMTDate, String str3, String str4, boolean z10, boolean z11, Map map, int i10, kotlin.jvm.internal.i iVar) {
        this(str, str2, (i10 & 4) != 0 ? CookieEncoding.URI_ENCODING : cookieEncoding, (i10 & 8) != 0 ? null : num, (i10 & 16) != 0 ? null : gMTDate, (i10 & 32) != 0 ? null : str3, (i10 & 64) != 0 ? null : str4, (i10 & 128) != 0 ? false : z10, (i10 & 256) != 0 ? false : z11, (i10 & 512) != 0 ? kotlin.collections.a.i() : map);
    }
}
