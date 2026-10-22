package g9;

import android.content.Context;
import android.os.LocaleList;
import java.util.Locale;
import java.util.Set;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public abstract class x0 {

    /* renamed from: a, reason: collision with root package name */
    public static final Set f4648a = kb.k.v0(new String[]{"zh-CN", "zh-HK", "zh-TW", "en"});

    /* JADX WARN: Removed duplicated region for block: B:41:0x00a6  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static java.lang.String a(org.json.JSONObject r6, java.lang.String r7, java.lang.String r8) {
        /*
            r8.getClass()
            boolean r0 = r6.has(r7)
            java.lang.String r1 = ""
            if (r0 == 0) goto Lfc
            boolean r0 = r6.isNull(r7)
            if (r0 == 0) goto L13
            goto Lfc
        L13:
            java.lang.Object r0 = r6.opt(r7)
            boolean r2 = r0 instanceof java.lang.String
            if (r2 == 0) goto L26
            java.lang.String r0 = (java.lang.String) r0
            java.lang.CharSequence r6 = hc.h.w0(r0)
            java.lang.String r6 = r6.toString()
            return r6
        L26:
            boolean r2 = r0 instanceof org.json.JSONObject
            if (r2 == 0) goto Lf7
            org.json.JSONObject r0 = (org.json.JSONObject) r0
            java.lang.CharSequence r6 = hc.h.w0(r8)
            java.lang.String r6 = r6.toString()
            java.util.Set r7 = g9.x0.f4648a
            boolean r7 = r7.contains(r6)
            if (r7 == 0) goto L3d
            goto L65
        L3d:
            r6.getClass()     // Catch: java.lang.Throwable -> L50
            r7 = 95
            r8 = 45
            java.lang.String r6 = r6.replace(r7, r8)     // Catch: java.lang.Throwable -> L50
            r6.getClass()     // Catch: java.lang.Throwable -> L50
            java.util.Locale r6 = java.util.Locale.forLanguageTag(r6)     // Catch: java.lang.Throwable -> L50
            goto L55
        L50:
            r6 = move-exception
            jb.h r6 = id.c.l(r6)
        L55:
            java.util.Locale r7 = java.util.Locale.SIMPLIFIED_CHINESE
            boolean r8 = r6 instanceof jb.h
            if (r8 == 0) goto L5c
            r6 = r7
        L5c:
            r6.getClass()
            java.util.Locale r6 = (java.util.Locale) r6
            java.lang.String r6 = c(r6)
        L65:
            int r7 = r6.hashCode()
            r8 = 3241(0xca9, float:4.542E-42)
            java.lang.String r2 = "zh-CN"
            java.lang.String r3 = "zh-HK"
            java.lang.String r4 = "zh-TW"
            java.lang.String r5 = "en"
            if (r7 == r8) goto La0
            r8 = 115813378(0x6e72c02, float:8.6957206E-35)
            if (r7 == r8) goto L90
            r8 = 115813762(0x6e72d82, float:8.695941E-35)
            if (r7 == r8) goto L80
            goto La6
        L80:
            boolean r6 = r6.equals(r4)
            if (r6 != 0) goto L87
            goto La6
        L87:
            java.lang.String[] r6 = new java.lang.String[]{r4, r3, r2, r5}
            java.util.List r6 = ac.a.F(r6)
            goto Lb7
        L90:
            boolean r6 = r6.equals(r3)
            if (r6 != 0) goto L97
            goto La6
        L97:
            java.lang.String[] r6 = new java.lang.String[]{r3, r4, r2, r5}
            java.util.List r6 = ac.a.F(r6)
            goto Lb7
        La0:
            boolean r6 = r6.equals(r5)
            if (r6 != 0) goto Laf
        La6:
            java.lang.String[] r6 = new java.lang.String[]{r2, r5, r4, r3}
            java.util.List r6 = ac.a.F(r6)
            goto Lb7
        Laf:
            java.lang.String[] r6 = new java.lang.String[]{r5, r2}
            java.util.List r6 = ac.a.F(r6)
        Lb7:
            java.util.Set r6 = kb.l.N0(r6)
            java.util.List r6 = kb.l.L0(r6)
            java.util.Iterator r6 = r6.iterator()
        Lc3:
            boolean r7 = r6.hasNext()
            if (r7 == 0) goto Ldb
            java.lang.Object r7 = r6.next()
            java.lang.String r7 = (java.lang.String) r7
            java.lang.String r7 = k0.a.p(r7, r0)
            int r8 = r7.length()
            if (r8 <= 0) goto Lc3
        Ld9:
            r1 = r7
            goto Lf6
        Ldb:
            java.util.Iterator r6 = r0.keys()
        Ldf:
            boolean r7 = r6.hasNext()
            if (r7 == 0) goto Lf6
            java.lang.Object r7 = r6.next()
            java.lang.String r7 = (java.lang.String) r7
            java.lang.String r7 = k0.a.p(r7, r0)
            int r8 = r7.length()
            if (r8 <= 0) goto Ldf
            goto Ld9
        Lf6:
            return r1
        Lf7:
            java.lang.String r6 = k0.a.p(r7, r6)
            return r6
        Lfc:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: g9.x0.a(org.json.JSONObject, java.lang.String, java.lang.String):java.lang.String");
    }

    public static String b(Context context) {
        context.getClass();
        LocaleList locales = context.getResources().getConfiguration().getLocales();
        locales.getClass();
        Locale locale = locales.size() > 0 ? locales.get(0) : Locale.getDefault();
        locale.getClass();
        return c(locale);
    }

    public static String c(Locale locale) {
        String language = locale.getLanguage();
        language.getClass();
        Locale locale2 = Locale.ROOT;
        locale2.getClass();
        String lowerCase = language.toLowerCase(locale2);
        lowerCase.getClass();
        if (lowerCase.equals("en")) {
            return "en";
        }
        if (lowerCase.equals("zh")) {
            String languageTag = locale.toLanguageTag();
            String country = locale.getCountry();
            country.getClass();
            String upperCase = country.toUpperCase(locale2);
            upperCase.getClass();
            String script = locale.getScript();
            languageTag.getClass();
            if (hc.h.X(languageTag, "HK", true) || upperCase.equals("HK") || upperCase.equals("MO")) {
                return "zh-HK";
            }
            if (hc.h.X(languageTag, "TW", true) || upperCase.equals("TW") || hc.o.Q(script, "Hant")) {
                return "zh-TW";
            }
            if (!hc.h.X(languageTag, "CN", true) && !upperCase.equals("CN") && !upperCase.equals("SG")) {
                hc.o.Q(script, "Hans");
            }
        }
        return "zh-CN";
    }
}
