package androidx.core.content.b;

import android.content.res.Resources;
import android.content.res.TypedArray;
import android.os.Build;
import android.util.Base64;
import android.util.TypedValue;
import android.util.Xml;
import com.obric.aiagent.plugin.R;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: compiled from: FontResourcesParserCompat.java */
/* JADX INFO: loaded from: classes.dex */
public class e {

    /* JADX INFO: compiled from: FontResourcesParserCompat.java */
    static class a {
        static int getType(TypedArray r0, int r1) {
            return r0.getType(r1);
        }
    }

    /* JADX INFO: compiled from: FontResourcesParserCompat.java */
    public interface b {
    }

    /* JADX INFO: compiled from: FontResourcesParserCompat.java */
    public static final class c implements b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final d[] f1164a;

        public c(d[] r1) {
            this.f1164a = r1;
        }

        public d[] a() {
            return this.f1164a;
        }
    }

    /* JADX INFO: compiled from: FontResourcesParserCompat.java */
    public static final class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f1165a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final int f1166b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final boolean f1167c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final String f1168d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private final int f1169e;
        private final int f;

        public d(String r1, int r2, boolean r3, String r4, int r5, int r6) {
            this.f1165a = r1;
            this.f1166b = r2;
            this.f1167c = r3;
            this.f1168d = r4;
            this.f1169e = r5;
            this.f = r6;
        }

        public String a() {
            return this.f1165a;
        }

        public int b() {
            return this.f1166b;
        }

        public boolean c() {
            return this.f1167c;
        }

        public String d() {
            return this.f1168d;
        }

        public int e() {
            return this.f1169e;
        }

        public int f() {
            return this.f;
        }
    }

    /* JADX INFO: renamed from: androidx.core.content.b.e$e, reason: collision with other inner class name */
    /* JADX INFO: compiled from: FontResourcesParserCompat.java */
    public static final class C0026e implements b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final androidx.core.provider.c f1170a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final int f1171b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final int f1172c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final String f1173d;

        public C0026e(androidx.core.provider.c r1, int r2, int r3, String r4) {
            this.f1170a = r1;
            this.f1172c = r2;
            this.f1171b = r3;
            this.f1173d = r4;
        }

        public androidx.core.provider.c a() {
            return this.f1170a;
        }

        public int b() {
            return this.f1172c;
        }

        public int c() {
            return this.f1171b;
        }

        public String d() {
            return this.f1173d;
        }
    }

    public static b a(XmlPullParser r3, Resources r4) {
        XmlPullParser r5 = (XmlPullParser) ZeusTransformUtils.wrapperContextForParams(r3, XmlPullParser.class, "com.obric.aiagent.plugin");
    L3:
        int r0 = r5.next();
        if (r0 == 2) goto L8;
        if (r0 != 1) goto L3;
    L8:
        if (r0 != 2) goto L12;
        return b(r5, r4);
    L12:
        throw new XmlPullParserException("No start tag found");
    }

    private static b b(XmlPullParser r3, Resources r4) {
        XmlPullParser r5 = (XmlPullParser) ZeusTransformUtils.wrapperContextForParams(r3, XmlPullParser.class, "com.obric.aiagent.plugin");
        r5.require(2, null, "font-family");
        if (r5.getName().equals("font-family") == true) goto L5;
        a(r5);
        return null;
    L5:
        return c(r5, r4);
    }

    private static b c(XmlPullParser r12, Resources r13) {
        XmlPullParser r14 = (XmlPullParser) ZeusTransformUtils.wrapperContextForParams(r12, XmlPullParser.class, "com.obric.aiagent.plugin");
        TypedArray r0 = r13.obtainAttributes(Xml.asAttributeSet(r14), R.styleable.FontFamily);
        String r2 = r0.getString(ZeusTransformUtils.mapRes(R.styleable.FontFamily_fontProviderAuthority, "styleable", "FontFamily_fontProviderAuthority"));
        String r4 = r0.getString(ZeusTransformUtils.mapRes(R.styleable.FontFamily_fontProviderPackage, "styleable", "FontFamily_fontProviderPackage"));
        String r5 = r0.getString(ZeusTransformUtils.mapRes(R.styleable.FontFamily_fontProviderQuery, "styleable", "FontFamily_fontProviderQuery"));
        int r6 = r0.getResourceId(ZeusTransformUtils.mapRes(R.styleable.FontFamily_fontProviderCerts, "styleable", "FontFamily_fontProviderCerts"), 0);
        int r8 = r0.getInteger(ZeusTransformUtils.mapRes(R.styleable.FontFamily_fontProviderFetchStrategy, "styleable", "FontFamily_fontProviderFetchStrategy"), 1);
        int r9 = r0.getInteger(ZeusTransformUtils.mapRes(R.styleable.FontFamily_fontProviderFetchTimeout, "styleable", "FontFamily_fontProviderFetchTimeout"), 500);
        String r3 = r0.getString(ZeusTransformUtils.mapRes(R.styleable.FontFamily_fontProviderSystemFontFamily, "styleable", "FontFamily_fontProviderSystemFontFamily"));
        r0.recycle();
        if (r2 == null) goto L11;
        if (r4 == null) goto L11;
        if (r5 == null) goto L11;
    L7:
        if (r14.next() == 3) goto L10;
        a(r14);
        goto L7
    L10:
        return new C0026e(new androidx.core.provider.c(r2, r4, r5, a(r13, r6)), r8, r9, r3);
    L11:
        ArrayList r7 = new ArrayList();
    L13:
        if (r14.next() == 3) goto L22;
        if (r14.getEventType() != 2) goto L13;
        if (r14.getName().equals("font") == true) goto L19;
        a(r14);
        goto L13
    L19:
        r7.add(d(r14, r13));
        goto L13
    L22:
        if (r7.isEmpty() == false) goto L26;
        return null;
    L26:
        return new c((d[]) ZeusTransformUtils.preCheckCast(r7.toArray(new d[0]), d[].class, "com.obric.aiagent.plugin"));
    }

    private static int getType(TypedArray r2, int r3) {
        if (Build.VERSION.SDK_INT >= 21) goto L5;
        TypedValue r0 = new TypedValue();
        r2.getValue(r3, r0);
        return r0.type;
    L5:
        return a.getType(r2, r3);
    }

    public static List<List<byte[]>> a(Resources r5, int r6) {
        if (r6 == 0) goto L4;
        TypedArray r0 = r5.obtainTypedArray(r6);
    L23:
        th = move-exception;
        r0.recycle();
        throw th;
    L7:
        if (r0.length() != 0) goto L11;
        List<List<byte[]>> r7 = Collections.emptyList();     // Catch: Throwable -> L23
        r0.recycle();
        return r7;
    L11:
        ArrayList r1 = new ArrayList();     // Catch: Throwable -> L23
        if (getType(r0, 0) != 1) goto L20;
        int r8 = 0;
    L15:
        if (r8 >= r0.length()) goto L21;
        int r3 = r0.getResourceId(r8, 0);     // Catch: Throwable -> L23
        if (r3 == 0) goto L19;
        r1.add(a(r5.getStringArray(r3)));     // Catch: Throwable -> L23
    L19:
        r8 = r8 + 1;     // Catch: Throwable -> L23
    L21:
        r0.recycle();
        return r1;
    L20:
        r1.add(a(r5.getStringArray(r6)));     // Catch: Throwable -> L23
        goto L21
    L4:
        return Collections.emptyList();
    }

    private static List<byte[]> a(String[] r5) {
        ArrayList r0 = new ArrayList();
        int r1 = r5.length;
        int r3 = 0;
    L3:
        if (r3 >= r1) goto L5;
        r0.add(Base64.decode(r5[r3], 0));
        r3 = r3 + 1;
        goto L3
    L5:
        return r0;
    }

    private static d d(XmlPullParser r10, Resources r11) {
        XmlPullParser r12 = (XmlPullParser) ZeusTransformUtils.wrapperContextForParams(r10, XmlPullParser.class, "com.obric.aiagent.plugin");
        TypedArray r13 = r11.obtainAttributes(Xml.asAttributeSet(r12), R.styleable.FontFamilyFont);
        if (r13.hasValue(ZeusTransformUtils.mapRes(R.styleable.FontFamilyFont_fontWeight, "styleable", "FontFamilyFont_fontWeight")) == false) goto L5;
        int r0 = ZeusTransformUtils.mapRes(R.styleable.FontFamilyFont_fontWeight, "styleable", "FontFamilyFont_fontWeight");
    L6:
        int r5 = r13.getInt(r0, 400);
        if (r13.hasValue(ZeusTransformUtils.mapRes(R.styleable.FontFamilyFont_fontStyle, "styleable", "FontFamilyFont_fontStyle")) == false) goto L9;
        int r1 = ZeusTransformUtils.mapRes(R.styleable.FontFamilyFont_fontStyle, "styleable", "FontFamilyFont_fontStyle");
    L11:
        if (1 != r13.getInt(r1, 0)) goto L13;
        boolean r6 = true;
    L15:
        if (r13.hasValue(ZeusTransformUtils.mapRes(R.styleable.FontFamilyFont_ttcIndex, "styleable", "FontFamilyFont_ttcIndex")) == false) goto L17;
        int r2 = ZeusTransformUtils.mapRes(R.styleable.FontFamilyFont_ttcIndex, "styleable", "FontFamilyFont_ttcIndex");
    L19:
        if (r13.hasValue(ZeusTransformUtils.mapRes(R.styleable.FontFamilyFont_fontVariationSettings, "styleable", "FontFamilyFont_fontVariationSettings")) == false) goto L21;
        int r3 = ZeusTransformUtils.mapRes(R.styleable.FontFamilyFont_fontVariationSettings, "styleable", "FontFamilyFont_fontVariationSettings");
    L22:
        String r7 = r13.getString(r3);
        int r8 = r13.getInt(r2, 0);
        if (r13.hasValue(ZeusTransformUtils.mapRes(R.styleable.FontFamilyFont_font, "styleable", "FontFamilyFont_font")) == false) goto L25;
        int r4 = ZeusTransformUtils.mapRes(R.styleable.FontFamilyFont_font, "styleable", "FontFamilyFont_font");
    L26:
        int r9 = r13.getResourceId(r4, 0);
        String r14 = r13.getString(r4);
        r13.recycle();
    L28:
        if (r12.next() == 3) goto L31;
        a(r12);
        goto L28
    L31:
        return new d(r14, r5, r6, r7, r8, r9);
    L25:
        r4 = ZeusTransformUtils.mapRes(R.styleable.FontFamilyFont_android_font, "styleable", "FontFamilyFont_android_font");
        goto L26
    L21:
        r3 = ZeusTransformUtils.mapRes(R.styleable.FontFamilyFont_android_fontVariationSettings, "styleable", "FontFamilyFont_android_fontVariationSettings");
        goto L22
    L17:
        r2 = ZeusTransformUtils.mapRes(R.styleable.FontFamilyFont_android_ttcIndex, "styleable", "FontFamilyFont_android_ttcIndex");
        goto L19
    L13:
        r6 = false;
        goto L15
    L9:
        r1 = ZeusTransformUtils.mapRes(R.styleable.FontFamilyFont_android_fontStyle, "styleable", "FontFamilyFont_android_fontStyle");
        goto L11
    L5:
        r0 = ZeusTransformUtils.mapRes(R.styleable.FontFamilyFont_android_fontWeight, "styleable", "FontFamilyFont_android_fontWeight");
        goto L6
    }

    private static void a(XmlPullParser r3) {
        XmlPullParser r4 = (XmlPullParser) ZeusTransformUtils.wrapperContextForParams(r3, XmlPullParser.class, "com.obric.aiagent.plugin");
        int r0 = 1;
    L3:
        if (r0 <= 0) goto L11;
        int r1 = r4.next();
        if (r1 != 2) goto L7;
        r0 = r0 + 1;
        goto L3
    L7:
        if (r1 != 3) goto L3;
        r0 = r0 - 1;
        goto L3
    }
}
