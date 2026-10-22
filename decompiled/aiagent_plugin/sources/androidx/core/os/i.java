package androidx.core.os;

import android.os.Build;
import android.os.LocaleList;
import com.ss.android.socialbase.downloader.segment.Segment;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Locale;

/* JADX INFO: compiled from: LocaleListCompat.java */
/* JADX INFO: loaded from: classes.dex */
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final i f1269a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final k f1270b;

    /* JADX INFO: compiled from: LocaleListCompat.java */
    static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static final Locale[] f1271a = null;

        static boolean a(Locale r4, Locale r5) {
            if (r4.equals(r5) == false) goto L6;
            return true;
        L6:
            if (r4.getLanguage().equals(r5.getLanguage()) == true) goto L9;
            return false;
        L9:
            if (a(r4) == false) goto L11;
        L24:
            return false;
        L11:
            if (a(r5) == true) goto L24;
            String r0 = androidx.core.text.c.a(r4);
            if (r0.isEmpty() == false) goto L23;
            String r6 = r4.getCountry();
            if (r6.isEmpty() == false) goto L18;
            return true;
        L18:
            if (r6.equals(r5.getCountry()) == false) goto L21;
            return true;
        L21:
            return false;
        L23:
            return r0.equals(androidx.core.text.c.a(r5));
        }

        static {
            f1271a = new Locale[]{new Locale(Segment.JsonKey.END, "XA"), new Locale("ar", "XB")};
        }

        private static boolean a(Locale r5) {
            Locale[] r0 = f1271a;
            int r1 = r0.length;
            int r3 = 0;
        L3:
            if (r3 >= r1) goto L9;
            if (r0[r3].equals(r5) == true) goto L6;
            r3 = r3 + 1;
            goto L3
        L6:
            return true;
        L9:
            return false;
        }

        static Locale a(String r0) {
            return Locale.forLanguageTag(r0);
        }
    }

    /* JADX INFO: compiled from: LocaleListCompat.java */
    static class b {
        static LocaleList a(Locale... r1) {
            return new LocaleList(r1);
        }

        static LocaleList a() {
            return LocaleList.getAdjustedDefault();
        }

        static LocaleList b() {
            return LocaleList.getDefault();
        }
    }

    static {
        f1269a = a(new Locale[0]);
    }

    private i(k r3) {
        this.f1270b = (k) ZeusTransformUtils.wrapperContextForParams(r3, k.class, "com.obric.aiagent.plugin");
    }

    public static i a(LocaleList r2) {
        return new i(new l(r2));
    }

    public Object a() {
        return this.f1270b.a();
    }

    public static i a(Locale... r2) {
        if (Build.VERSION.SDK_INT < 24) goto L7;
        return a(b.a(r2));
    L7:
        return new i(new j(r2));
    }

    public Locale a(int r1) {
        return this.f1270b.a(r1);
    }

    public boolean b() {
        return this.f1270b.b();
    }

    public int c() {
        return this.f1270b.c();
    }

    public String d() {
        return this.f1270b.d();
    }

    public static i e() {
        return f1269a;
    }

    public static i a(String r5) {
        if (r5 == null) goto L16;
        if (r5.isEmpty() == true) goto L16;
        String[] r6 = r5.split(",", -1);
        int r0 = r6.length;
        Locale[] r1 = new Locale[r0];
        int r2 = 0;
    L7:
        if (r2 >= r0) goto L14;
        if (Build.VERSION.SDK_INT < 21) goto L11;
        Locale r3 = a.a(r6[r2]);
    L12:
        r1[r2] = r3;
        r2 = r2 + 1;
        goto L7
    L11:
        r3 = b(r6[r2]);
        goto L12
    L14:
        return a(r1);
    L16:
        return e();
    }

    static Locale b(String r6) {
        if (r6.contains("-") == false) goto L17;
        String[] r0 = r6.split("-", -1);
        if (r0.length <= 2) goto L9;
        return new Locale(r0[0], r0[1], r0[2]);
    L9:
        if (r0.length <= 1) goto L13;
        return new Locale(r0[0], r0[1]);
    L13:
        if (r0.length != 1) goto L31;
        return new Locale(r0[0]);
    L31:
        throw new IllegalArgumentException("Can not parse language tag: [" + r6 + "]");
    L17:
        if (r6.contains("_") == false) goto L33;
        String[] r1 = r6.split("_", -1);
        if (r1.length <= 2) goto L23;
        return new Locale(r1[0], r1[1], r1[2]);
    L23:
        if (r1.length <= 1) goto L27;
        return new Locale(r1[0], r1[1]);
    L27:
        if (r1.length != 1) goto L31;
        return new Locale(r1[0]);
    L33:
        return new Locale(r6);
    }

    public boolean equals(Object r3) {
        if (ZeusTransformUtils.instanceOf(r3, i.class) == true) goto L5;
    L7:
        return false;
    L5:
        if (this.f1270b.equals(((i) ZeusTransformUtils.preCheckCast(r3, i.class, "com.obric.aiagent.plugin")).f1270b) == false) goto L7;
        return true;
    }

    public int hashCode() {
        return this.f1270b.hashCode();
    }

    public String toString() {
        return this.f1270b.toString();
    }
}
