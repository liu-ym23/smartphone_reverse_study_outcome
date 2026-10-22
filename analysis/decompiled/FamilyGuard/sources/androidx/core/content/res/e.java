package androidx.core.content.res;

import android.content.res.Resources;
import android.content.res.TypedArray;
import android.util.Base64;
import android.util.Xml;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import z.C1334f;

/* loaded from: classes.dex */
public class e {

    static class a {
        static int a(TypedArray typedArray, int i5) {
            return typedArray.getType(i5);
        }
    }

    public interface b {
    }

    public static final class c implements b {

        /* renamed from: a, reason: collision with root package name */
        private final d[] f9604a;

        public c(d[] dVarArr) {
            this.f9604a = dVarArr;
        }

        public d[] a() {
            return this.f9604a;
        }
    }

    public static final class d {

        /* renamed from: a, reason: collision with root package name */
        private final String f9605a;

        /* renamed from: b, reason: collision with root package name */
        private final int f9606b;

        /* renamed from: c, reason: collision with root package name */
        private final boolean f9607c;

        /* renamed from: d, reason: collision with root package name */
        private final String f9608d;

        /* renamed from: e, reason: collision with root package name */
        private final int f9609e;

        /* renamed from: f, reason: collision with root package name */
        private final int f9610f;

        public d(String str, int i5, boolean z5, String str2, int i6, int i7) {
            this.f9605a = str;
            this.f9606b = i5;
            this.f9607c = z5;
            this.f9608d = str2;
            this.f9609e = i6;
            this.f9610f = i7;
        }

        public int a() {
            return this.f9610f;
        }

        public int b() {
            return this.f9609e;
        }

        public String c() {
            return this.f9608d;
        }

        public int d() {
            return this.f9606b;
        }

        public boolean e() {
            return this.f9607c;
        }
    }

    /* renamed from: androidx.core.content.res.e$e, reason: collision with other inner class name */
    public static final class C0117e implements b {

        /* renamed from: a, reason: collision with root package name */
        private final C.e f9611a;

        /* renamed from: b, reason: collision with root package name */
        private final int f9612b;

        /* renamed from: c, reason: collision with root package name */
        private final int f9613c;

        /* renamed from: d, reason: collision with root package name */
        private final String f9614d;

        public C0117e(C.e eVar, int i5, int i6, String str) {
            this.f9611a = eVar;
            this.f9613c = i5;
            this.f9612b = i6;
            this.f9614d = str;
        }

        public int a() {
            return this.f9613c;
        }

        public C.e b() {
            return this.f9611a;
        }

        public String c() {
            return this.f9614d;
        }

        public int d() {
            return this.f9612b;
        }
    }

    private static int a(TypedArray typedArray, int i5) {
        return a.a(typedArray, i5);
    }

    public static b b(XmlPullParser xmlPullParser, Resources resources) {
        int next;
        do {
            next = xmlPullParser.next();
            if (next == 2) {
                break;
            }
        } while (next != 1);
        if (next == 2) {
            return d(xmlPullParser, resources);
        }
        throw new XmlPullParserException("No start tag found");
    }

    public static List<List<byte[]>> c(Resources resources, int i5) throws Resources.NotFoundException {
        if (i5 == 0) {
            return Collections.EMPTY_LIST;
        }
        TypedArray typedArrayObtainTypedArray = resources.obtainTypedArray(i5);
        try {
            if (typedArrayObtainTypedArray.length() == 0) {
                return Collections.EMPTY_LIST;
            }
            ArrayList arrayList = new ArrayList();
            if (a(typedArrayObtainTypedArray, 0) == 1) {
                for (int i6 = 0; i6 < typedArrayObtainTypedArray.length(); i6++) {
                    int resourceId = typedArrayObtainTypedArray.getResourceId(i6, 0);
                    if (resourceId != 0) {
                        arrayList.add(h(resources.getStringArray(resourceId)));
                    }
                }
            } else {
                arrayList.add(h(resources.getStringArray(i5)));
            }
            return arrayList;
        } finally {
            typedArrayObtainTypedArray.recycle();
        }
    }

    private static b d(XmlPullParser xmlPullParser, Resources resources) throws XmlPullParserException, IOException {
        xmlPullParser.require(2, null, "font-family");
        if (xmlPullParser.getName().equals("font-family")) {
            return e(xmlPullParser, resources);
        }
        g(xmlPullParser);
        return null;
    }

    private static b e(XmlPullParser xmlPullParser, Resources resources) throws XmlPullParserException, IOException {
        TypedArray typedArrayObtainAttributes = resources.obtainAttributes(Xml.asAttributeSet(xmlPullParser), C1334f.f24011h);
        String string = typedArrayObtainAttributes.getString(C1334f.f24012i);
        String string2 = typedArrayObtainAttributes.getString(C1334f.f24016m);
        String string3 = typedArrayObtainAttributes.getString(C1334f.f24017n);
        int resourceId = typedArrayObtainAttributes.getResourceId(C1334f.f24013j, 0);
        int integer = typedArrayObtainAttributes.getInteger(C1334f.f24014k, 1);
        int integer2 = typedArrayObtainAttributes.getInteger(C1334f.f24015l, 500);
        String string4 = typedArrayObtainAttributes.getString(C1334f.f24018o);
        typedArrayObtainAttributes.recycle();
        if (string != null && string2 != null && string3 != null) {
            while (xmlPullParser.next() != 3) {
                g(xmlPullParser);
            }
            return new C0117e(new C.e(string, string2, string3, c(resources, resourceId)), integer, integer2, string4);
        }
        ArrayList arrayList = new ArrayList();
        while (xmlPullParser.next() != 3) {
            if (xmlPullParser.getEventType() == 2) {
                if (xmlPullParser.getName().equals("font")) {
                    arrayList.add(f(xmlPullParser, resources));
                } else {
                    g(xmlPullParser);
                }
            }
        }
        if (arrayList.isEmpty()) {
            return null;
        }
        return new c((d[]) arrayList.toArray(new d[0]));
    }

    private static d f(XmlPullParser xmlPullParser, Resources resources) throws XmlPullParserException, IOException {
        TypedArray typedArrayObtainAttributes = resources.obtainAttributes(Xml.asAttributeSet(xmlPullParser), C1334f.f24019p);
        int i5 = C1334f.f24028y;
        if (!typedArrayObtainAttributes.hasValue(i5)) {
            i5 = C1334f.f24021r;
        }
        int i6 = typedArrayObtainAttributes.getInt(i5, 400);
        int i7 = C1334f.f24026w;
        if (!typedArrayObtainAttributes.hasValue(i7)) {
            i7 = C1334f.f24022s;
        }
        boolean z5 = 1 == typedArrayObtainAttributes.getInt(i7, 0);
        int i8 = C1334f.f24029z;
        if (!typedArrayObtainAttributes.hasValue(i8)) {
            i8 = C1334f.f24023t;
        }
        int i9 = C1334f.f24027x;
        if (!typedArrayObtainAttributes.hasValue(i9)) {
            i9 = C1334f.f24024u;
        }
        String string = typedArrayObtainAttributes.getString(i9);
        int i10 = typedArrayObtainAttributes.getInt(i8, 0);
        int i11 = C1334f.f24025v;
        if (!typedArrayObtainAttributes.hasValue(i11)) {
            i11 = C1334f.f24020q;
        }
        int resourceId = typedArrayObtainAttributes.getResourceId(i11, 0);
        String string2 = typedArrayObtainAttributes.getString(i11);
        typedArrayObtainAttributes.recycle();
        while (xmlPullParser.next() != 3) {
            g(xmlPullParser);
        }
        return new d(string2, i6, z5, string, i10, resourceId);
    }

    private static void g(XmlPullParser xmlPullParser) throws XmlPullParserException, IOException {
        int i5 = 1;
        while (i5 > 0) {
            int next = xmlPullParser.next();
            if (next == 2) {
                i5++;
            } else if (next == 3) {
                i5--;
            }
        }
    }

    private static List<byte[]> h(String[] strArr) {
        ArrayList arrayList = new ArrayList();
        for (String str : strArr) {
            arrayList.add(Base64.decode(str, 0));
        }
        return arrayList;
    }
}
