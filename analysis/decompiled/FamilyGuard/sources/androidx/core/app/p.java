package androidx.core.app;

import android.app.Person;
import androidx.core.graphics.drawable.IconCompat;
import java.util.Objects;

/* loaded from: classes.dex */
public class p {

    /* renamed from: a, reason: collision with root package name */
    CharSequence f9560a;

    /* renamed from: b, reason: collision with root package name */
    IconCompat f9561b;

    /* renamed from: c, reason: collision with root package name */
    String f9562c;

    /* renamed from: d, reason: collision with root package name */
    String f9563d;

    /* renamed from: e, reason: collision with root package name */
    boolean f9564e;

    /* renamed from: f, reason: collision with root package name */
    boolean f9565f;

    static class a {
        static p a(Person person) {
            return new b().f(person.getName()).c(person.getIcon() != null ? IconCompat.a(person.getIcon()) : null).g(person.getUri()).e(person.getKey()).b(person.isBot()).d(person.isImportant()).a();
        }

        static Person b(p pVar) {
            return new Person.Builder().setName(pVar.c()).setIcon(pVar.a() != null ? pVar.a().n() : null).setUri(pVar.d()).setKey(pVar.b()).setBot(pVar.e()).setImportant(pVar.f()).build();
        }
    }

    public static class b {

        /* renamed from: a, reason: collision with root package name */
        CharSequence f9566a;

        /* renamed from: b, reason: collision with root package name */
        IconCompat f9567b;

        /* renamed from: c, reason: collision with root package name */
        String f9568c;

        /* renamed from: d, reason: collision with root package name */
        String f9569d;

        /* renamed from: e, reason: collision with root package name */
        boolean f9570e;

        /* renamed from: f, reason: collision with root package name */
        boolean f9571f;

        public p a() {
            return new p(this);
        }

        public b b(boolean z5) {
            this.f9570e = z5;
            return this;
        }

        public b c(IconCompat iconCompat) {
            this.f9567b = iconCompat;
            return this;
        }

        public b d(boolean z5) {
            this.f9571f = z5;
            return this;
        }

        public b e(String str) {
            this.f9569d = str;
            return this;
        }

        public b f(CharSequence charSequence) {
            this.f9566a = charSequence;
            return this;
        }

        public b g(String str) {
            this.f9568c = str;
            return this;
        }
    }

    p(b bVar) {
        this.f9560a = bVar.f9566a;
        this.f9561b = bVar.f9567b;
        this.f9562c = bVar.f9568c;
        this.f9563d = bVar.f9569d;
        this.f9564e = bVar.f9570e;
        this.f9565f = bVar.f9571f;
    }

    public IconCompat a() {
        return this.f9561b;
    }

    public String b() {
        return this.f9563d;
    }

    public CharSequence c() {
        return this.f9560a;
    }

    public String d() {
        return this.f9562c;
    }

    public boolean e() {
        return this.f9564e;
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
        return this.f9565f;
    }

    public Person g() {
        return a.b(this);
    }

    public int hashCode() {
        String strB = b();
        return strB != null ? strB.hashCode() : Objects.hash(c(), d(), Boolean.valueOf(e()), Boolean.valueOf(f()));
    }
}
