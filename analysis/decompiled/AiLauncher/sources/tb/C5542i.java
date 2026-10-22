package tb;

import La.C0953c;
import com.autonavi.aps.amapapi.config.Const;
import io.ktor.http.auth.HttpAuthHeader;
import java.nio.charset.Charset;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0014\u0010\u0005\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0012\u0004\u0012\u00020\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u001a\u0010\n\u001a\u00020\t2\b\u0010\b\u001a\u0004\u0018\u00010\u0001H\u0096\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\r\u001a\u00020\fH\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u000f\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u000f\u0010\u0010R\u0017\u0010\u0003\u001a\u00020\u00028\u0007¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0010R%\u0010\u0005\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0012\u0004\u0012\u00020\u00020\u00048\u0007¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0005\u0010\u0016R\u0013\u0010\u0017\u001a\u0004\u0018\u00010\u00028G¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0010R\u0011\u0010\u001a\u001a\u00020\u00188G¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0019¨\u0006\u001b"}, d2 = {"Ltb/i;", "", "", "scheme", "", "authParams", "<init>", "(Ljava/lang/String;Ljava/util/Map;)V", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "toString", "()Ljava/lang/String;", Const.INTENT_KEY_APIKEY, "Ljava/lang/String;", "c", Const.INTENT_KEY_PKGNAME, "Ljava/util/Map;", "()Ljava/util/Map;", HttpAuthHeader.Parameters.Realm, "Ljava/nio/charset/Charset;", "()Ljava/nio/charset/Charset;", HttpAuthHeader.Parameters.Charset, "okhttp"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* renamed from: tb.i, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C5542i {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final String scheme;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public final Map<String, String> authParams;

    public C5542i(String scheme, Map<String, String> authParams) {
        String lowerCase;
        kotlin.jvm.internal.p.i(scheme, "scheme");
        kotlin.jvm.internal.p.i(authParams, "authParams");
        this.scheme = scheme;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Map.Entry<String, String> entry : authParams.entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue();
            if (key != null) {
                Locale US = Locale.US;
                kotlin.jvm.internal.p.h(US, "US");
                lowerCase = key.toLowerCase(US);
                kotlin.jvm.internal.p.h(lowerCase, "toLowerCase(...)");
            } else {
                lowerCase = null;
            }
            linkedHashMap.put(lowerCase, value);
        }
        Map<String, String> mapUnmodifiableMap = Collections.unmodifiableMap(linkedHashMap);
        kotlin.jvm.internal.p.h(mapUnmodifiableMap, "unmodifiableMap(...)");
        this.authParams = mapUnmodifiableMap;
    }

    public final Charset a() {
        String str = this.authParams.get(HttpAuthHeader.Parameters.Charset);
        if (str != null) {
            try {
                Charset charsetForName = Charset.forName(str);
                kotlin.jvm.internal.p.h(charsetForName, "forName(...)");
                return charsetForName;
            } catch (Exception unused) {
            }
        }
        return C0953c.ISO_8859_1;
    }

    public final String b() {
        return this.authParams.get(HttpAuthHeader.Parameters.Realm);
    }

    /* renamed from: c, reason: from getter */
    public final String getScheme() {
        return this.scheme;
    }

    public boolean equals(Object other) {
        if (!(other instanceof C5542i)) {
            return false;
        }
        C5542i c5542i = (C5542i) other;
        return kotlin.jvm.internal.p.d(c5542i.scheme, this.scheme) && kotlin.jvm.internal.p.d(c5542i.authParams, this.authParams);
    }

    public int hashCode() {
        return ((899 + this.scheme.hashCode()) * 31) + this.authParams.hashCode();
    }

    public String toString() {
        return this.scheme + " authParams=" + this.authParams;
    }
}
