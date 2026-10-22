package m0;

import android.content.res.Resources;
import android.content.res.TypedArray;
import android.util.Base64;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class e {

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public interface a {
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class b implements a {

        /* renamed from: a, reason: collision with root package name */
        public final c[] f10452a;

        public b(c[] cVarArr) {
            this.f10452a = cVarArr;
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class c {

        /* renamed from: a, reason: collision with root package name */
        public final int f10453a;

        /* renamed from: b, reason: collision with root package name */
        public final boolean f10454b;

        /* renamed from: c, reason: collision with root package name */
        public final String f10455c;

        /* renamed from: d, reason: collision with root package name */
        public final int f10456d;

        /* renamed from: e, reason: collision with root package name */
        public final int f10457e;

        public c(int i10, int i11, int i12, String str, String str2, boolean z) {
            this.f10453a = i10;
            this.f10454b = z;
            this.f10455c = str2;
            this.f10456d = i11;
            this.f10457e = i12;
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class d implements a {

        /* renamed from: a, reason: collision with root package name */
        public final ArrayList f10458a;

        /* renamed from: b, reason: collision with root package name */
        public final int f10459b;

        /* renamed from: c, reason: collision with root package name */
        public final int f10460c;

        /* renamed from: d, reason: collision with root package name */
        public final String f10461d;

        public d(ArrayList arrayList, int i10, int i11, String str) {
            this.f10458a = arrayList;
            this.f10460c = i10;
            this.f10459b = i11;
            this.f10461d = str;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:156:0x0117 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:194:? A[SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r3v10 */
    /* JADX WARN: Type inference failed for: r3v11 */
    /* JADX WARN: Type inference failed for: r3v13 */
    /* JADX WARN: Type inference failed for: r3v14, types: [android.content.res.TypedArray] */
    /* JADX WARN: Type inference failed for: r3v6 */
    /* JADX WARN: Type inference failed for: r3v7 */
    /* JADX WARN: Type inference failed for: r3v8 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static m0.e.a a(android.content.res.XmlResourceParser r25, android.content.res.Resources r26) throws java.lang.Exception {
        /*
            Method dump skipped, instructions count: 622
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: m0.e.a(android.content.res.XmlResourceParser, android.content.res.Resources):m0.e$a");
    }

    public static List<List<byte[]>> b(Resources resources, int i10) throws Resources.NotFoundException {
        if (i10 == 0) {
            return Collections.EMPTY_LIST;
        }
        TypedArray typedArrayObtainTypedArray = resources.obtainTypedArray(i10);
        try {
            if (typedArrayObtainTypedArray.length() == 0) {
                return Collections.EMPTY_LIST;
            }
            ArrayList arrayList = new ArrayList();
            if (typedArrayObtainTypedArray.getType(0) == 1) {
                for (int i11 = 0; i11 < typedArrayObtainTypedArray.length(); i11++) {
                    int resourceId = typedArrayObtainTypedArray.getResourceId(i11, 0);
                    if (resourceId != 0) {
                        String[] stringArray = resources.getStringArray(resourceId);
                        ArrayList arrayList2 = new ArrayList();
                        for (String str : stringArray) {
                            arrayList2.add(Base64.decode(str, 0));
                        }
                        arrayList.add(arrayList2);
                    }
                }
            } else {
                String[] stringArray2 = resources.getStringArray(i10);
                ArrayList arrayList3 = new ArrayList();
                for (String str2 : stringArray2) {
                    arrayList3.add(Base64.decode(str2, 0));
                }
                arrayList.add(arrayList3);
            }
            return arrayList;
        } finally {
            typedArrayObtainTypedArray.recycle();
        }
    }

    public static void c(XmlPullParser xmlPullParser) throws XmlPullParserException, IOException {
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
}
