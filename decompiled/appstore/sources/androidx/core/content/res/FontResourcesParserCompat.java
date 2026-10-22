package androidx.core.content.res;

import android.content.res.Resources;
import android.content.res.TypedArray;
import android.util.Base64;
import android.util.Xml;
import androidx.annotation.DoNotInline;
import androidx.core.R$styleable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: loaded from: classes.dex */
public abstract class FontResourcesParserCompat {

    public interface FamilyResourceEntry {
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface FetchStrategy {
    }

    public static class a {
        @DoNotInline
        public static int a(TypedArray r10, int r11) {
            return r10.getType(r11);
        }
    }

    public static final class b implements FamilyResourceEntry {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final c[] f2522a;

        public b(c[] r10) {
            this.f2522a = r10;
        }

        public c[] a() {
            return this.f2522a;
        }
    }

    public static final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f2523a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f2524b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final boolean f2525c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final String f2526d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final int f2527e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final int f2528f;

        public c(String r10, int r11, boolean r12, String r13, int r14, int r15) {
            this.f2523a = r10;
            this.f2524b = r11;
            this.f2525c = r12;
            this.f2526d = r13;
            this.f2527e = r14;
            this.f2528f = r15;
        }

        public int a() {
            return this.f2528f;
        }

        public int b() {
            return this.f2527e;
        }

        public String c() {
            return this.f2526d;
        }

        public int d() {
            return this.f2524b;
        }

        public boolean e() {
            return this.f2525c;
        }
    }

    public static final class d implements FamilyResourceEntry {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final q.c f2529a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f2530b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f2531c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final String f2532d;

        public d(q.c r10, int r11, int r12, String r13) {
            this.f2529a = r10;
            this.f2531c = r11;
            this.f2530b = r12;
            this.f2532d = r13;
        }

        public int a() {
            return this.f2531c;
        }

        public q.c b() {
            return this.f2529a;
        }

        public String c() {
            return this.f2532d;
        }

        public int d() {
            return this.f2530b;
        }
    }

    public static int a(TypedArray r10, int r11) {
        return a.a(r10, r11);
    }

    public static FamilyResourceEntry b(XmlPullParser r10, Resources r11) {
    L2:
        int r12 = r10.next();
        if (r12 == 2) goto L7;
        if (r12 != 1) goto L2;
    L7:
        if (r12 != 2) goto L11;
        return d(r10, r11);
    L11:
        throw new XmlPullParserException("No start tag found");
    }

    public static List c(Resources r10, int r11) {
        if (r11 == 0) goto L4;
        TypedArray r12 = r10.obtainTypedArray(r11);
    L11:
        th = move-exception;
        r12.recycle();
        throw th;
    L7:
        if (r12.length() != 0) goto L13;
        List r13 = Collections.emptyList();     // Catch: Throwable -> L11
        r12.recycle();
        return r13;
    L13:
        ArrayList r14 = new ArrayList();     // Catch: Throwable -> L11
        if (a(r12, 0) != 1) goto L22;
        int r15 = 0;
    L17:
        if (r15 >= r12.length()) goto L23;
        int r16 = r12.getResourceId(r15, 0);     // Catch: Throwable -> L11
        if (r16 == 0) goto L21;
        r14.add(h(r10.getStringArray(r16)));     // Catch: Throwable -> L11
    L21:
        r15 = r15 + 1;     // Catch: Throwable -> L11
    L23:
        r12.recycle();
        return r14;
    L22:
        r14.add(h(r10.getStringArray(r11)));     // Catch: Throwable -> L11
        goto L23
    L4:
        return Collections.emptyList();
    }

    public static FamilyResourceEntry d(XmlPullParser r10, Resources r11) {
        r10.require(2, null, "font-family");
        if (r10.getName().equals("font-family") == true) goto L5;
        g(r10);
        return null;
    L5:
        return e(r10, r11);
    }

    public static FamilyResourceEntry e(XmlPullParser r10, Resources r11) {
        TypedArray r12 = r11.obtainAttributes(Xml.asAttributeSet(r10), R$styleable.FontFamily);
        String r13 = r12.getString(R$styleable.FontFamily_fontProviderAuthority);
        String r14 = r12.getString(R$styleable.FontFamily_fontProviderPackage);
        String r15 = r12.getString(R$styleable.FontFamily_fontProviderQuery);
        int r16 = r12.getResourceId(R$styleable.FontFamily_fontProviderCerts, 0);
        int r17 = r12.getInteger(R$styleable.FontFamily_fontProviderFetchStrategy, 1);
        int r18 = r12.getInteger(R$styleable.FontFamily_fontProviderFetchTimeout, 500);
        String r19 = r12.getString(R$styleable.FontFamily_fontProviderSystemFontFamily);
        r12.recycle();
        if (r13 == null) goto L11;
        if (r14 == null) goto L11;
        if (r15 == null) goto L11;
    L7:
        if (r10.next() == 3) goto L10;
        g(r10);
        goto L7
    L10:
        return new d(new q.c(r13, r14, r15, c(r11, r16)), r17, r18, r19);
    L11:
        ArrayList r20 = new ArrayList();
    L13:
        if (r10.next() == 3) goto L22;
        if (r10.getEventType() != 2) goto L13;
        if (r10.getName().equals("font") == true) goto L19;
        g(r10);
        goto L13
    L19:
        r20.add(f(r10, r11));
        goto L13
    L22:
        if (r20.isEmpty() == false) goto L26;
        return null;
    L26:
        return new b((c[]) r20.toArray(new c[0]));
    }

    public static c f(XmlPullParser r10, Resources r11) {
        TypedArray r12 = r11.obtainAttributes(Xml.asAttributeSet(r10), R$styleable.FontFamilyFont);
        int r13 = R$styleable.FontFamilyFont_fontWeight;
        if (r12.hasValue(r13) == true) goto L6;
        r13 = R$styleable.FontFamilyFont_android_fontWeight;
    L6:
        int r14 = r12.getInt(r13, 400);
        int r15 = R$styleable.FontFamilyFont_fontStyle;
        if (r12.hasValue(r15) == true) goto L11;
        r15 = R$styleable.FontFamilyFont_android_fontStyle;
    L11:
        if (1 != r12.getInt(r15, 0)) goto L13;
        boolean r16 = true;
    L14:
        int r17 = R$styleable.FontFamilyFont_ttcIndex;
        if (r12.hasValue(r17) == true) goto L18;
        r17 = R$styleable.FontFamilyFont_android_ttcIndex;
    L18:
        int r18 = R$styleable.FontFamilyFont_fontVariationSettings;
        if (r12.hasValue(r18) == true) goto L22;
        r18 = R$styleable.FontFamilyFont_android_fontVariationSettings;
    L22:
        String r19 = r12.getString(r18);
        int r20 = r12.getInt(r17, 0);
        int r21 = R$styleable.FontFamilyFont_font;
        if (r12.hasValue(r21) == true) goto L26;
        r21 = R$styleable.FontFamilyFont_android_font;
    L26:
        int r22 = r12.getResourceId(r21, 0);
        String r23 = r12.getString(r21);
        r12.recycle();
    L28:
        if (r10.next() == 3) goto L31;
        g(r10);
        goto L28
    L31:
        return new c(r23, r14, r16, r19, r20, r22);
    L13:
        r16 = false;
        goto L14
    }

    public static void g(XmlPullParser r10) {
        int r11 = 1;
    L3:
        if (r11 <= 0) goto L11;
        int r12 = r10.next();
        if (r12 != 2) goto L7;
        r11 = r11 + 1;
        goto L3
    L7:
        if (r12 != 3) goto L3;
        r11 = r11 - 1;
        goto L3
    }

    public static List h(String[] r10) {
        ArrayList r11 = new ArrayList();
        int r12 = r10.length;
        int r13 = 0;
    L3:
        if (r13 >= r12) goto L5;
        r11.add(Base64.decode(r10[r13], 0));
        r13 = r13 + 1;
        goto L3
    L5:
        return r11;
    }
}
