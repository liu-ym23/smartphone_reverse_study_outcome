package androidx.core.app;

import android.app.Person;
import androidx.core.graphics.drawable.IconCompat;
import java.util.Objects;

/* loaded from: classes.dex */
public class p {

    /* renamed from: a, reason: collision with root package name */
    public CharSequence f13063a;

    /* renamed from: b, reason: collision with root package name */
    public IconCompat f13064b;

    /* renamed from: c, reason: collision with root package name */
    public String f13065c;

    /* renamed from: d, reason: collision with root package name */
    public String f13066d;

    /* renamed from: e, reason: collision with root package name */
    public boolean f13067e;

    /* renamed from: f, reason: collision with root package name */
    public boolean f13068f;

    public static class a {
        public static Person a(p pVar) {
            return new Person.Builder().setName(pVar.c()).setIcon(pVar.a() != null ? pVar.a().j() : null).setUri(pVar.d()).setKey(pVar.b()).setBot(pVar.e()).setImportant(pVar.f()).build();
        }
    }

    public IconCompat a() {
        return this.f13064b;
    }

    public String b() {
        return this.f13066d;
    }

    public CharSequence c() {
        return this.f13063a;
    }

    public String d() {
        return this.f13065c;
    }

    public boolean e() {
        return this.f13067e;
    }

    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof p)) {
            return false;
        }
        p pVar = (p) obj;
        String strB = b();
        String strB2 = pVar.b();
        return (strB == null && strB2 == null) ? Objects.equals(Objects.toString(c()), Objects.toString(pVar.c())) && Objects.equals(d(), pVar.d()) && Boolean.valueOf(e()).equals(Boolean.valueOf(pVar.e())) && Boolean.valueOf(f()).equals(Boolean.valueOf(pVar.f())) : Objects.equals(strB, strB2);
    }

    public boolean f() {
        return this.f13068f;
    }

    public Person g() {
        return a.a(this);
    }

    public int hashCode() {
        String strB = b();
        return strB != null ? strB.hashCode() : Objects.hash(c(), d(), Boolean.valueOf(e()), Boolean.valueOf(f()));
    }
}
