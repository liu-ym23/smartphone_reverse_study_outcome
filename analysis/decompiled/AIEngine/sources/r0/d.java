package r0;

import android.os.LocaleList;
import java.util.Locale;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class d {

    /* renamed from: b, reason: collision with root package name */
    public static final d f11676b = new d(new f(new LocaleList(new Locale[0])));

    /* renamed from: a, reason: collision with root package name */
    public final f f11677a;

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int f11678a = 0;

        static {
            new Locale("en", "XA");
            new Locale("ar", "XB");
        }
    }

    public d(f fVar) {
        this.f11677a = fVar;
    }

    public static d a(String str) {
        if (str == null || str.isEmpty()) {
            return f11676b;
        }
        String[] strArrSplit = str.split(",", -1);
        int length = strArrSplit.length;
        Locale[] localeArr = new Locale[length];
        for (int i10 = 0; i10 < length; i10++) {
            String str2 = strArrSplit[i10];
            int i11 = a.f11678a;
            localeArr[i10] = Locale.forLanguageTag(str2);
        }
        return new d(new f(new LocaleList(localeArr)));
    }

    public final boolean equals(Object obj) {
        if (obj instanceof d) {
            return this.f11677a.equals(((d) obj).f11677a);
        }
        return false;
    }

    public final int hashCode() {
        return this.f11677a.f11679a.hashCode();
    }

    public final String toString() {
        return this.f11677a.f11679a.toString();
    }
}
