package s0;

import android.content.res.Resources;
import android.content.res.TypedArray;
import android.util.Base64;
import android.util.Xml;
import androidx.core.R$styleable;
import com.autonavi.aps.amapapi.config.Const;
import io.ktor.http.ContentType;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* loaded from: classes.dex */
public class e {

    public static class a {
        public static int a(TypedArray typedArray, int i10) {
            return typedArray.getType(i10);
        }
    }

    public interface b {
    }

    public static final class c implements b {

        /* renamed from: a, reason: collision with root package name */
        public final d[] f40017a;

        public c(d[] dVarArr) {
            this.f40017a = dVarArr;
        }

        public d[] a() {
            return this.f40017a;
        }
    }

    public static final class d {

        /* renamed from: a, reason: collision with root package name */
        public final String f40018a;

        /* renamed from: b, reason: collision with root package name */
        public final int f40019b;

        /* renamed from: c, reason: collision with root package name */
        public final boolean f40020c;

        /* renamed from: d, reason: collision with root package name */
        public final String f40021d;

        /* renamed from: e, reason: collision with root package name */
        public final int f40022e;

        /* renamed from: f, reason: collision with root package name */
        public final int f40023f;

        public d(String str, int i10, boolean z10, String str2, int i11, int i12) {
            this.f40018a = str;
            this.f40019b = i10;
            this.f40020c = z10;
            this.f40021d = str2;
            this.f40022e = i11;
            this.f40023f = i12;
        }

        public int a() {
            return this.f40023f;
        }

        public int b() {
            return this.f40022e;
        }

        public String c() {
            return this.f40021d;
        }

        public int d() {
            return this.f40019b;
        }

        public boolean e() {
            return this.f40020c;
        }
    }

    /* renamed from: s0.e$e, reason: collision with other inner class name */
    public static final class C0519e implements b {

        /* renamed from: a, reason: collision with root package name */
        public final List<y0.e> f40024a;

        /* renamed from: b, reason: collision with root package name */
        public final int f40025b;

        /* renamed from: c, reason: collision with root package name */
        public final int f40026c;

        /* renamed from: d, reason: collision with root package name */
        public final String f40027d;

        public C0519e(List<y0.e> list, int i10, int i11, String str) {
            this.f40024a = list;
            this.f40026c = i10;
            this.f40025b = i11;
            this.f40027d = str;
        }

        public int a() {
            return this.f40026c;
        }

        public List<y0.e> b() {
            return this.f40024a;
        }

        public String c() {
            return this.f40027d;
        }

        public int d() {
            return this.f40025b;
        }
    }

    public static int a(TypedArray typedArray, int i10) {
        return a.a(typedArray, i10);
    }

    public static b b(XmlPullParser xmlPullParser, Resources resources) throws XmlPullParserException, IOException {
        int next;
        do {
            next = xmlPullParser.next();
            if (next == 2) {
                break;
            }
        } while (next != 1);
        if (next == 2) {
            return e(xmlPullParser, resources);
        }
        throw new XmlPullParserException("No start tag found");
    }

    public static List<List<byte[]>> c(Resources resources, int i10) throws Resources.NotFoundException {
        if (i10 == 0) {
            return Collections.EMPTY_LIST;
        }
        TypedArray typedArrayObtainTypedArray = resources.obtainTypedArray(i10);
        try {
            if (typedArrayObtainTypedArray.length() == 0) {
                return Collections.EMPTY_LIST;
            }
            ArrayList arrayList = new ArrayList();
            if (a(typedArrayObtainTypedArray, 0) == 1) {
                for (int i11 = 0; i11 < typedArrayObtainTypedArray.length(); i11++) {
                    int resourceId = typedArrayObtainTypedArray.getResourceId(i11, 0);
                    if (resourceId != 0) {
                        arrayList.add(i(resources.getStringArray(resourceId)));
                    }
                }
            } else {
                arrayList.add(i(resources.getStringArray(i10)));
            }
            return arrayList;
        } finally {
            typedArrayObtainTypedArray.recycle();
        }
    }

    public static y0.e d(XmlPullParser xmlPullParser, Resources resources, String str, String str2, List<List<byte[]>> list) throws XmlPullParserException, IOException {
        TypedArray typedArrayObtainAttributes = resources.obtainAttributes(Xml.asAttributeSet(xmlPullParser), R$styleable.FontFamilyProviderFallback);
        try {
            String string = typedArrayObtainAttributes.getString(R$styleable.FontFamilyProviderFallback_fontProviderQuery);
            String string2 = typedArrayObtainAttributes.getString(R$styleable.FontFamilyProviderFallback_fontProviderSystemFontFamily);
            String string3 = typedArrayObtainAttributes.getString(R$styleable.FontFamilyProviderFallback_fontVariationSettings);
            if (string == null) {
                throw new XmlPullParserException("query attribute must be set in fallback element");
            }
            while (xmlPullParser.next() != 3) {
                h(xmlPullParser);
            }
            y0.e eVar = new y0.e(str, str2, string, list, string2, string3);
            typedArrayObtainAttributes.close();
            return eVar;
        } catch (Throwable th) {
            if (typedArrayObtainAttributes == null) {
                throw th;
            }
            try {
                typedArrayObtainAttributes.close();
                throw th;
            } catch (Throwable th2) {
                th.addSuppressed(th2);
                throw th;
            }
        }
    }

    public static b e(XmlPullParser xmlPullParser, Resources resources) throws XmlPullParserException, IOException {
        xmlPullParser.require(2, null, "font-family");
        if (xmlPullParser.getName().equals("font-family")) {
            return f(xmlPullParser, resources);
        }
        h(xmlPullParser);
        return null;
    }

    public static b f(XmlPullParser xmlPullParser, Resources resources) throws XmlPullParserException, Resources.NotFoundException, IOException {
        TypedArray typedArrayObtainAttributes = resources.obtainAttributes(Xml.asAttributeSet(xmlPullParser), R$styleable.FontFamily);
        String string = typedArrayObtainAttributes.getString(R$styleable.FontFamily_fontProviderAuthority);
        String string2 = typedArrayObtainAttributes.getString(R$styleable.FontFamily_fontProviderPackage);
        String string3 = typedArrayObtainAttributes.getString(R$styleable.FontFamily_fontProviderQuery);
        String string4 = typedArrayObtainAttributes.getString(R$styleable.FontFamily_fontProviderFallbackQuery);
        int resourceId = typedArrayObtainAttributes.getResourceId(R$styleable.FontFamily_fontProviderCerts, 0);
        int integer = typedArrayObtainAttributes.getInteger(R$styleable.FontFamily_fontProviderFetchStrategy, 1);
        int integer2 = typedArrayObtainAttributes.getInteger(R$styleable.FontFamily_fontProviderFetchTimeout, 500);
        String string5 = typedArrayObtainAttributes.getString(R$styleable.FontFamily_fontProviderSystemFontFamily);
        typedArrayObtainAttributes.recycle();
        if (string == null || string2 == null) {
            ArrayList arrayList = new ArrayList();
            while (xmlPullParser.next() != 3) {
                if (xmlPullParser.getEventType() == 2) {
                    if (xmlPullParser.getName().equals(ContentType.Font.TYPE)) {
                        arrayList.add(g(xmlPullParser, resources));
                    } else {
                        h(xmlPullParser);
                    }
                }
            }
            if (arrayList.isEmpty()) {
                return null;
            }
            return new c((d[]) arrayList.toArray(new d[0]));
        }
        List<List<byte[]>> listC = c(resources, resourceId);
        ArrayList arrayList2 = new ArrayList();
        while (xmlPullParser.next() != 3) {
            if (xmlPullParser.getEventType() == 2) {
                if (xmlPullParser.getName().equals("fallback")) {
                    arrayList2.add(d(xmlPullParser, resources, string, string2, listC));
                } else {
                    h(xmlPullParser);
                }
            }
        }
        if (!arrayList2.isEmpty()) {
            return new C0519e(arrayList2, integer, integer2, string5);
        }
        if (string3 == null) {
            throw new IllegalArgumentException("The provider font XML requires query attribute or fallback children.");
        }
        arrayList2.add(new y0.e(string, string2, string3, listC, null, null));
        if (string4 != null) {
            arrayList2.add(new y0.e(string, string2, string4, listC, null, null));
        }
        return new C0519e(arrayList2, integer, integer2, string5);
    }

    public static d g(XmlPullParser xmlPullParser, Resources resources) throws XmlPullParserException, IOException {
        TypedArray typedArrayObtainAttributes = resources.obtainAttributes(Xml.asAttributeSet(xmlPullParser), R$styleable.FontFamilyFont);
        int i10 = R$styleable.FontFamilyFont_fontWeight;
        if (!typedArrayObtainAttributes.hasValue(i10)) {
            i10 = R$styleable.FontFamilyFont_android_fontWeight;
        }
        int i11 = typedArrayObtainAttributes.getInt(i10, Const.I_TILE_TINY);
        int i12 = R$styleable.FontFamilyFont_fontStyle;
        if (!typedArrayObtainAttributes.hasValue(i12)) {
            i12 = R$styleable.FontFamilyFont_android_fontStyle;
        }
        boolean z10 = 1 == typedArrayObtainAttributes.getInt(i12, 0);
        int i13 = R$styleable.FontFamilyFont_ttcIndex;
        if (!typedArrayObtainAttributes.hasValue(i13)) {
            i13 = R$styleable.FontFamilyFont_android_ttcIndex;
        }
        int i14 = R$styleable.FontFamilyFont_fontVariationSettings;
        if (!typedArrayObtainAttributes.hasValue(i14)) {
            i14 = R$styleable.FontFamilyFont_android_fontVariationSettings;
        }
        String string = typedArrayObtainAttributes.getString(i14);
        int i15 = typedArrayObtainAttributes.getInt(i13, 0);
        int i16 = R$styleable.FontFamilyFont_font;
        if (!typedArrayObtainAttributes.hasValue(i16)) {
            i16 = R$styleable.FontFamilyFont_android_font;
        }
        int resourceId = typedArrayObtainAttributes.getResourceId(i16, 0);
        String string2 = typedArrayObtainAttributes.getString(i16);
        typedArrayObtainAttributes.recycle();
        while (xmlPullParser.next() != 3) {
            h(xmlPullParser);
        }
        return new d(string2, i11, z10, string, i15, resourceId);
    }

    public static void h(XmlPullParser xmlPullParser) throws XmlPullParserException, IOException {
        int i10 = 1;
        while (i10 > 0) {
            int next = xmlPullParser.next();
            if (next == 2) {
                i10++;
            } else if (next == 3) {
                i10--;
            }
        }
    }

    public static List<byte[]> i(String[] strArr) {
        ArrayList arrayList = new ArrayList();
        for (String str : strArr) {
            arrayList.add(Base64.decode(str, 0));
        }
        return arrayList;
    }
}
