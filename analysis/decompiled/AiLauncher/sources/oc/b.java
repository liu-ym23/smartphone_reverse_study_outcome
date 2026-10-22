package oc;

import com.autonavi.aps.amapapi.config.Const;
import java.util.regex.Pattern;

/* loaded from: classes5.dex */
public class b implements a {

    /* renamed from: b, reason: collision with root package name */
    public static final Pattern f37500b = Pattern.compile(" ");

    /* renamed from: c, reason: collision with root package name */
    public static final Pattern f37501c = Pattern.compile(Const.STR_MART_COMMA);

    /* renamed from: a, reason: collision with root package name */
    public final String f37502a;

    public b(String str) {
        if (str == null) {
            throw new IllegalArgumentException();
        }
        this.f37502a = str;
    }

    @Override // oc.a
    public a a() {
        return new b(c());
    }

    @Override // oc.a
    public boolean b(String str) {
        if ("".equals(this.f37502a)) {
            return true;
        }
        for (String str2 : f37501c.split(f37500b.matcher(str).replaceAll(""))) {
            if (this.f37502a.equals(str2)) {
                return true;
            }
        }
        return false;
    }

    @Override // oc.a
    public String c() {
        return this.f37502a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        return this.f37502a.equals(((b) obj).f37502a);
    }

    public int hashCode() {
        return this.f37502a.hashCode();
    }

    @Override // oc.a
    public String toString() {
        return c();
    }
}
