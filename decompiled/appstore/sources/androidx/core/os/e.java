package androidx.core.os;

import android.os.LocaleList;
import androidx.annotation.DoNotInline;
import androidx.annotation.NonNull;
import java.util.Locale;

/* JADX INFO: loaded from: classes.dex */
public final class e {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final e f2574b = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LocaleListInterface f2575a;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final Locale[] f2576a = null;

        static {
            f2576a = new Locale[]{new Locale("en", "XA"), new Locale("ar", "XB")};
        }

        @DoNotInline
        public static Locale a(String r10) {
            return Locale.forLanguageTag(r10);
        }

        public static boolean b(Locale r10) {
            Locale[] r11 = f2576a;
            int r12 = r11.length;
            int r13 = 0;
        L3:
            if (r13 >= r12) goto L9;
            if (r11[r13].equals(r10) == true) goto L6;
            r13 = r13 + 1;
            goto L3
        L6:
            return true;
        L9:
            return false;
        }

        @DoNotInline
        public static boolean c(@NonNull Locale r10, @NonNull Locale r11) {
            if (r10.equals(r11) == false) goto L6;
            return true;
        L6:
            if (r10.getLanguage().equals(r11.getLanguage()) == true) goto L9;
            return false;
        L9:
            if (b(r10) == false) goto L11;
        L24:
            return false;
        L11:
            if (b(r11) == true) goto L24;
            String r12 = androidx.core.text.b.a(r10);
            if (r12.isEmpty() == false) goto L23;
            String r13 = r10.getCountry();
            if (r13.isEmpty() == false) goto L18;
            return true;
        L18:
            if (r13.equals(r11.getCountry()) == false) goto L21;
            return true;
        L21:
            return false;
        L23:
            return r12.equals(androidx.core.text.b.a(r11));
        }
    }

    public static class b {
        @DoNotInline
        public static LocaleList a(Locale... r10) {
            return new LocaleList(r10);
        }

        @DoNotInline
        public static LocaleList b() {
            return LocaleList.getAdjustedDefault();
        }

        @DoNotInline
        public static LocaleList c() {
            return LocaleList.getDefault();
        }
    }

    static {
        f2574b = a(new Locale[0]);
    }

    public e(LocaleListInterface r10) {
        this.f2575a = r10;
    }

    public static e a(Locale... r10) {
        return h(b.a(r10));
    }

    public static e b(String r10) {
        if (r10 == null) goto L12;
        if (r10.isEmpty() == true) goto L12;
        String[] r11 = r10.split(",", -1);
        int r12 = r11.length;
        Locale[] r13 = new Locale[r12];
        int r14 = 0;
    L7:
        if (r14 >= r12) goto L10;
        r13[r14] = a.a(r11[r14]);
        r14 = r14 + 1;
        goto L7
    L10:
        return a(r13);
    L12:
        return d();
    }

    public static e d() {
        return f2574b;
    }

    public static e h(LocaleList r10) {
        return new e(new f(r10));
    }

    public Locale c(int r10) {
        return this.f2575a.get(r10);
    }

    public boolean e() {
        return this.f2575a.isEmpty();
    }

    public boolean equals(Object r10) {
        if ((r10 instanceof e) == true) goto L5;
    L7:
        return false;
    L5:
        if (this.f2575a.equals(((e) r10).f2575a) == false) goto L7;
        return true;
    }

    public int f() {
        return this.f2575a.size();
    }

    public String g() {
        return this.f2575a.toLanguageTags();
    }

    public int hashCode() {
        return this.f2575a.hashCode();
    }

    public String toString() {
        return this.f2575a.toString();
    }
}
