package org.libpag;

import android.content.res.AssetManager;
import android.util.Xml;
import com.stepos.minor.Minor;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.regex.Pattern;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* loaded from: classes.dex */
public class PAGFont {

    /* renamed from: a, reason: collision with root package name */
    private static final String[] f19137a = {"/system/fonts/NotoSansCJK-Regular.ttc", "/system/fonts/NotoSansSC-Regular.otf", "/system/fonts/DroidSansFallback.ttf"};

    /* renamed from: b, reason: collision with root package name */
    private static final Pattern f19138b = Pattern.compile("^[ \\n\\r\\t]+|[ \\n\\r\\t]+$");

    /* renamed from: c, reason: collision with root package name */
    private static boolean f19139c = false;
    public String fontFamily;
    public String fontStyle;

    private static class a {

        /* renamed from: a, reason: collision with root package name */
        String f19140a;

        /* renamed from: b, reason: collision with root package name */
        String f19141b;

        /* renamed from: c, reason: collision with root package name */
        int f19142c;

        /* renamed from: d, reason: collision with root package name */
        int f19143d;

        private a() {
            this.f19140a = BuildConfig.FLAVOR;
            this.f19141b = BuildConfig.FLAVOR;
            this.f19142c = 0;
            this.f19143d = 400;
        }
    }

    static {
        P4.a.a("pag");
    }

    public PAGFont() {
        this.fontFamily = BuildConfig.FLAVOR;
        this.fontStyle = BuildConfig.FLAVOR;
    }

    private static void RegisterFallbackFonts() {
        if (f19139c) {
            return;
        }
        f19139c = true;
        int i5 = 0;
        a[] aVarArrA = new a[0];
        if (new File("/system/etc/fonts.xml").exists()) {
            try {
                aVarArrA = b();
            } catch (Exception e6) {
                e6.printStackTrace();
            }
        } else {
            try {
                aVarArrA = a();
            } catch (Exception e7) {
                e7.printStackTrace();
            }
        }
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        a aVarA = a(aVarArrA, "zh-Hans");
        if (aVarA != null) {
            a(aVarA, arrayList, arrayList2);
        }
        for (String str : f19137a) {
            a aVar = new a();
            aVar.f19141b = str;
            a(aVar, arrayList, arrayList2);
        }
        for (a aVar2 : aVarArrA) {
            a(aVar2, arrayList, arrayList2);
        }
        if (arrayList.isEmpty()) {
            return;
        }
        String[] strArr = new String[arrayList.size()];
        arrayList.toArray(strArr);
        int[] iArr = new int[arrayList2.size()];
        int size = arrayList2.size();
        int i6 = 0;
        while (i6 < size) {
            Object obj = arrayList2.get(i6);
            i6++;
            iArr[i5] = ((Integer) obj).intValue();
            i5++;
        }
        SetFallbackFontPaths(strArr, iArr);
    }

    public static native PAGFont RegisterFont(AssetManager assetManager, String str, int i5, String str2, String str3);

    public static PAGFont RegisterFont(String str) {
        return RegisterFont(str, 0);
    }

    public static native PAGFont RegisterFont(String str, int i5, String str2, String str3);

    private static native PAGFont RegisterFontBytes(byte[] bArr, int i5, int i6, String str, String str2);

    private static native void SetFallbackFontPaths(String[] strArr, int[] iArr);

    private static native void UnregisterFont(String str, String str2);

    public static void UnregisterFont(PAGFont pAGFont) {
        UnregisterFont(pAGFont.fontFamily, pAGFont.fontStyle);
    }

    private static a[] a(XmlPullParser xmlPullParser) throws XmlPullParserException, IOException {
        ArrayList arrayList = new ArrayList();
        xmlPullParser.require(2, null, "familyset");
        while (xmlPullParser.next() != 3) {
            if (xmlPullParser.getEventType() == 2) {
                if (xmlPullParser.getName().equals("family")) {
                    a(xmlPullParser, (ArrayList<a>) arrayList);
                } else {
                    d(xmlPullParser);
                }
            }
        }
        a[] aVarArr = new a[arrayList.size()];
        arrayList.toArray(aVarArr);
        return aVarArr;
    }

    private static a[] b() throws IOException {
        a[] aVarArr = new a[0];
        try {
            FileInputStream fileInputStream = new FileInputStream("/system/etc/fonts.xml");
            try {
                XmlPullParser xmlPullParserNewPullParser = Xml.newPullParser();
                xmlPullParserNewPullParser.setInput(fileInputStream, null);
                xmlPullParserNewPullParser.nextTag();
                return a(xmlPullParserNewPullParser);
            } finally {
                fileInputStream.close();
            }
        } catch (IOException unused) {
            return aVarArr;
        }
    }

    private static a c(XmlPullParser xmlPullParser) throws XmlPullParserException, IOException {
        a aVar = new a();
        String attributeValue = xmlPullParser.getAttributeValue(null, "index");
        aVar.f19142c = attributeValue == null ? 0 : Integer.parseInt(attributeValue);
        String attributeValue2 = xmlPullParser.getAttributeValue(null, "weight");
        aVar.f19143d = attributeValue2 == null ? 400 : Integer.parseInt(attributeValue2);
        StringBuilder sb = new StringBuilder();
        while (xmlPullParser.next() != 3) {
            if (xmlPullParser.getEventType() == 4) {
                sb.append(xmlPullParser.getText());
            }
            if (xmlPullParser.getEventType() == 2) {
                d(xmlPullParser);
            }
        }
        aVar.f19141b = "/system/fonts/" + f19138b.matcher(sb).replaceAll(BuildConfig.FLAVOR);
        return aVar;
    }

    private static void d(XmlPullParser xmlPullParser) throws XmlPullParserException, IOException {
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

    public static PAGFont RegisterFont(AssetManager assetManager, String str) {
        return RegisterFont(assetManager, str, 0);
    }

    public static PAGFont RegisterFont(AssetManager assetManager, String str, int i5) {
        return RegisterFont(assetManager, str, i5, BuildConfig.FLAVOR, BuildConfig.FLAVOR);
    }

    public PAGFont(String str, String str2) {
        this.fontFamily = str;
        this.fontStyle = str2;
    }

    public static PAGFont RegisterFont(String str, int i5) {
        return RegisterFont(str, i5, BuildConfig.FLAVOR, BuildConfig.FLAVOR);
    }

    private static a[] b(XmlPullParser xmlPullParser) throws XmlPullParserException, IOException {
        ArrayList arrayList = new ArrayList();
        xmlPullParser.require(2, null, "familyset");
        while (xmlPullParser.next() != 3) {
            if (xmlPullParser.getEventType() == 2) {
                if (xmlPullParser.getName().equals("family")) {
                    while (xmlPullParser.next() != 3) {
                        if (xmlPullParser.getEventType() == 2) {
                            if (xmlPullParser.getName().equals("fileset")) {
                                b(xmlPullParser, arrayList);
                            } else {
                                d(xmlPullParser);
                            }
                        }
                    }
                } else {
                    d(xmlPullParser);
                }
            }
        }
        a[] aVarArr = new a[arrayList.size()];
        arrayList.toArray(aVarArr);
        return aVarArr;
    }

    private static void a(XmlPullParser xmlPullParser, ArrayList<a> arrayList) throws XmlPullParserException, IOException {
        a aVar = null;
        xmlPullParser.getAttributeValue(null, Minor.COLUMN_NAME);
        String attributeValue = xmlPullParser.getAttributeValue(null, "lang");
        ArrayList arrayList2 = new ArrayList();
        while (xmlPullParser.next() != 3) {
            if (xmlPullParser.getEventType() == 2) {
                if (xmlPullParser.getName().equals("font")) {
                    arrayList2.add(c(xmlPullParser));
                } else {
                    d(xmlPullParser);
                }
            }
        }
        if (arrayList2.isEmpty()) {
            return;
        }
        int size = arrayList2.size();
        int i5 = 0;
        while (true) {
            if (i5 >= size) {
                break;
            }
            Object obj = arrayList2.get(i5);
            i5++;
            a aVar2 = (a) obj;
            if (aVar2.f19143d == 400) {
                aVar = aVar2;
                break;
            }
        }
        if (aVar == null) {
            aVar = (a) arrayList2.get(0);
        }
        if (aVar.f19141b.isEmpty()) {
            return;
        }
        if (attributeValue == null) {
            attributeValue = BuildConfig.FLAVOR;
        }
        aVar.f19140a = attributeValue;
        arrayList.add(aVar);
    }

    private static void b(XmlPullParser xmlPullParser, ArrayList<a> arrayList) throws XmlPullParserException, IOException {
        a aVar;
        ArrayList arrayList2 = new ArrayList();
        while (xmlPullParser.next() != 3) {
            if (xmlPullParser.getEventType() == 2) {
                if (xmlPullParser.getName().equals("file")) {
                    arrayList2.add(c(xmlPullParser));
                } else {
                    d(xmlPullParser);
                }
            }
        }
        if (arrayList2.isEmpty()) {
            return;
        }
        int size = arrayList2.size();
        int i5 = 0;
        while (true) {
            if (i5 >= size) {
                aVar = null;
                break;
            }
            Object obj = arrayList2.get(i5);
            i5++;
            aVar = (a) obj;
            if (aVar.f19143d == 400) {
                break;
            }
        }
        if (aVar == null) {
            aVar = (a) arrayList2.get(0);
        }
        if (aVar.f19141b.isEmpty()) {
            return;
        }
        arrayList.add(aVar);
    }

    private static a[] a() throws IOException {
        a[] aVarArr = new a[0];
        try {
            FileInputStream fileInputStream = new FileInputStream("/system/etc/fallback_fonts.xml");
            try {
                XmlPullParser xmlPullParserNewPullParser = Xml.newPullParser();
                xmlPullParserNewPullParser.setInput(fileInputStream, null);
                xmlPullParserNewPullParser.nextTag();
                return b(xmlPullParserNewPullParser);
            } finally {
                fileInputStream.close();
            }
        } catch (IOException unused) {
            return aVarArr;
        }
    }

    private static a a(a[] aVarArr, String str) {
        String lowerCase = str.toLowerCase();
        for (a aVar : aVarArr) {
            if (aVar.f19140a.toLowerCase().equals(lowerCase)) {
                return aVar;
            }
        }
        return null;
    }

    private static void a(a aVar, ArrayList<String> arrayList, ArrayList<Integer> arrayList2) {
        if (!arrayList.contains(aVar.f19141b) && new File(aVar.f19141b).exists()) {
            arrayList.add(aVar.f19141b);
            arrayList2.add(Integer.valueOf(aVar.f19142c));
        }
    }
}
