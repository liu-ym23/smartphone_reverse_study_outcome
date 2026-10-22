package h3;

import androidx.room.AbstractC0351g;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* renamed from: h3.o, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C0606o {

    /* renamed from: a, reason: collision with root package name */
    public final String f12940a;

    /* renamed from: b, reason: collision with root package name */
    public final Map f12941b;

    public C0606o(String scheme, Map authParams) {
        String lowerCase;
        Intrinsics.checkNotNullParameter(scheme, "scheme");
        Intrinsics.checkNotNullParameter(authParams, "authParams");
        this.f12940a = scheme;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Map.Entry entry : authParams.entrySet()) {
            String str = (String) entry.getKey();
            String str2 = (String) entry.getValue();
            if (str == null) {
                lowerCase = null;
            } else {
                Locale US = Locale.US;
                Intrinsics.checkNotNullExpressionValue(US, "US");
                lowerCase = str.toLowerCase(US);
                Intrinsics.checkNotNullExpressionValue(lowerCase, "this as java.lang.String).toLowerCase(locale)");
            }
            linkedHashMap.put(lowerCase, str2);
        }
        Map mapUnmodifiableMap = Collections.unmodifiableMap(linkedHashMap);
        Intrinsics.checkNotNullExpressionValue(mapUnmodifiableMap, "unmodifiableMap<String?, String>(newAuthParams)");
        this.f12941b = mapUnmodifiableMap;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof C0606o) {
            C0606o c0606o = (C0606o) obj;
            if (Intrinsics.areEqual(c0606o.f12940a, this.f12940a) && Intrinsics.areEqual(c0606o.f12941b, this.f12941b)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return this.f12941b.hashCode() + AbstractC0351g.d(this.f12940a, 899, 31);
    }

    public final String toString() {
        return this.f12940a + " authParams=" + this.f12941b;
    }
}
