package x0;

import android.os.LocaleList;
import com.autonavi.aps.amapapi.config.Const;
import java.util.Locale;

/* loaded from: classes.dex */
public final class g {

    /* renamed from: b, reason: collision with root package name */
    public static final g f43465b = a(new Locale[0]);

    /* renamed from: a, reason: collision with root package name */
    public final h f43466a;

    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public static final Locale[] f43467a = {new Locale("en", "XA"), new Locale("ar", "XB")};

        public static Locale a(String str) {
            return Locale.forLanguageTag(str);
        }
    }

    public static class b {
        public static LocaleList a(Locale... localeArr) {
            return new LocaleList(localeArr);
        }
    }

    public g(h hVar) {
        this.f43466a = hVar;
    }

    public static g a(Locale... localeArr) {
        return h(b.a(localeArr));
    }

    public static g b(String str) {
        if (str == null || str.isEmpty()) {
            return d();
        }
        String[] strArrSplit = str.split(Const.STR_MART_COMMA, -1);
        int length = strArrSplit.length;
        Locale[] localeArr = new Locale[length];
        for (int i10 = 0; i10 < length; i10++) {
            localeArr[i10] = a.a(strArrSplit[i10]);
        }
        return a(localeArr);
    }

    public static g d() {
        return f43465b;
    }

    public static g h(LocaleList localeList) {
        return new g(new i(localeList));
    }

    public Locale c(int i10) {
        return this.f43466a.get(i10);
    }

    public boolean e() {
        return this.f43466a.isEmpty();
    }

    public boolean equals(Object obj) {
        return (obj instanceof g) && this.f43466a.equals(((g) obj).f43466a);
    }

    public int f() {
        return this.f43466a.size();
    }

    public String g() {
        return this.f43466a.a();
    }

    public int hashCode() {
        return this.f43466a.hashCode();
    }

    public String toString() {
        return this.f43466a.toString();
    }
}
