package org.libpag;

import android.content.res.AssetManager;
import android.util.Xml;
import com.amap.api.services.core.ServiceSettings;
import com.autonavi.aps.amapapi.config.Const;
import gc.AbstractC4115a;
import io.ktor.http.ContentType;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.regex.Pattern;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* loaded from: classes5.dex */
public class PAGFont {

    /* renamed from: a, reason: collision with root package name */
    private static final Pattern f37854a = Pattern.compile("^[ \\n\\r\\t]+|[ \\n\\r\\t]+$");

    /* renamed from: b, reason: collision with root package name */
    private static boolean f37855b = false;
    public String fontFamily;
    public String fontStyle;

    public static class b {

        /* renamed from: a, reason: collision with root package name */
        String f37856a;

        /* renamed from: b, reason: collision with root package name */
        String f37857b;

        /* renamed from: c, reason: collision with root package name */
        int f37858c;

        /* renamed from: d, reason: collision with root package name */
        int f37859d;

        private b() {
            this.f37856a = "";
            this.f37857b = "";
            this.f37858c = 0;
            this.f37859d = Const.I_TILE_TINY;
        }
    }

    static {
        AbstractC4115a.e("pag");
    }

    public PAGFont() {
        this.fontFamily = "";
        this.fontStyle = "";
    }

    private static void RegisterFallbackFonts() {
        if (f37855b) {
            return;
        }
        f37855b = true;
        int i10 = 0;
        b[] bVarArrA = new b[0];
        if (new File("/system/etc/fonts.xml").exists()) {
            try {
                bVarArrA = b();
            } catch (Exception e10) {
                e10.printStackTrace();
            }
        } else {
            try {
                bVarArrA = a();
            } catch (Exception e11) {
                e11.printStackTrace();
            }
        }
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        b bVarA = a(bVarArrA, ServiceSettings.CHINESE);
        if (bVarA != null) {
            a(bVarA, arrayList, arrayList2);
        }
        for (b bVar : bVarArrA) {
            a(bVar, arrayList, arrayList2);
        }
        if (arrayList.isEmpty()) {
            return;
        }
        String[] strArr = new String[arrayList.size()];
        arrayList.toArray(strArr);
        int[] iArr = new int[arrayList2.size()];
        Iterator it = arrayList2.iterator();
        while (it.hasNext()) {
            iArr[i10] = ((Integer) it.next()).intValue();
            i10++;
        }
        SetFallbackFontPaths(strArr, iArr);
    }

    public static native PAGFont RegisterFont(AssetManager assetManager, String str, int i10, String str2, String str3);

    public static PAGFont RegisterFont(String str) {
        return RegisterFont(str, 0);
    }

    public static native PAGFont RegisterFont(String str, int i10, String str2, String str3);

    private static native PAGFont RegisterFontBytes(byte[] bArr, int i10, int i11, String str, String str2);

    private static native void SetFallbackFontPaths(String[] strArr, int[] iArr);

    private static native void UnregisterFont(String str, String str2);

    public static void UnregisterFont(PAGFont pAGFont) {
        UnregisterFont(pAGFont.fontFamily, pAGFont.fontStyle);
    }

    private static b[] a(XmlPullParser xmlPullParser) throws XmlPullParserException, IOException {
        ArrayList arrayList = new ArrayList();
        xmlPullParser.require(2, null, "familyset");
        while (xmlPullParser.next() != 3) {
            if (xmlPullParser.getEventType() == 2) {
                if (xmlPullParser.getName().equals("family")) {
                    a(xmlPullParser, arrayList);
                } else {
                    d(xmlPullParser);
                }
            }
        }
        b[] bVarArr = new b[arrayList.size()];
        arrayList.toArray(bVarArr);
        return bVarArr;
    }

    private static b[] b() throws IOException {
        b[] bVarArr = new b[0];
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
            return bVarArr;
        }
    }

    private static b c(XmlPullParser xmlPullParser) throws XmlPullParserException, IOException {
        b bVar = new b();
        String attributeValue = xmlPullParser.getAttributeValue(null, "index");
        bVar.f37858c = attributeValue == null ? 0 : Integer.parseInt(attributeValue);
        String attributeValue2 = xmlPullParser.getAttributeValue(null, "weight");
        bVar.f37859d = attributeValue2 == null ? Const.I_TILE_TINY : Integer.parseInt(attributeValue2);
        StringBuilder sb2 = new StringBuilder();
        while (xmlPullParser.next() != 3) {
            if (xmlPullParser.getEventType() == 4) {
                sb2.append(xmlPullParser.getText());
            }
            if (xmlPullParser.getEventType() == 2) {
                d(xmlPullParser);
            }
        }
        bVar.f37857b = "/system/fonts/" + f37854a.matcher(sb2).replaceAll("");
        return bVar;
    }

    private static void d(XmlPullParser xmlPullParser) throws XmlPullParserException, IOException {
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

    public static PAGFont RegisterFont(AssetManager assetManager, String str) {
        return RegisterFont(assetManager, str, 0);
    }

    public static PAGFont RegisterFont(AssetManager assetManager, String str, int i10) {
        return RegisterFont(assetManager, str, i10, "", "");
    }

    public PAGFont(String str, String str2) {
        this.fontFamily = str;
        this.fontStyle = str2;
    }

    public static PAGFont RegisterFont(String str, int i10) {
        return RegisterFont(str, i10, "", "");
    }

    private static b[] b(XmlPullParser xmlPullParser) throws XmlPullParserException, IOException {
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
        b[] bVarArr = new b[arrayList.size()];
        arrayList.toArray(bVarArr);
        return bVarArr;
    }

    private static void a(XmlPullParser xmlPullParser, ArrayList arrayList) throws XmlPullParserException, IOException {
        b bVar = null;
        xmlPullParser.getAttributeValue(null, "name");
        String attributeValue = xmlPullParser.getAttributeValue(null, "lang");
        ArrayList arrayList2 = new ArrayList();
        while (xmlPullParser.next() != 3) {
            if (xmlPullParser.getEventType() == 2) {
                if (xmlPullParser.getName().equals(ContentType.Font.TYPE)) {
                    arrayList2.add(c(xmlPullParser));
                } else {
                    d(xmlPullParser);
                }
            }
        }
        if (arrayList2.isEmpty()) {
            return;
        }
        Iterator it = arrayList2.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            b bVar2 = (b) it.next();
            if (bVar2.f37859d == 400) {
                bVar = bVar2;
                break;
            }
        }
        if (bVar == null) {
            bVar = (b) arrayList2.get(0);
        }
        if (bVar.f37857b.isEmpty()) {
            return;
        }
        if (attributeValue == null) {
            attributeValue = "";
        }
        bVar.f37856a = attributeValue;
        arrayList.add(bVar);
    }

    private static void b(XmlPullParser xmlPullParser, ArrayList arrayList) throws XmlPullParserException, IOException {
        b bVar;
        ArrayList arrayList2 = new ArrayList();
        while (xmlPullParser.next() != 3) {
            if (xmlPullParser.getEventType() == 2) {
                if (xmlPullParser.getName().equals(Const.STR_FILE)) {
                    arrayList2.add(c(xmlPullParser));
                } else {
                    d(xmlPullParser);
                }
            }
        }
        if (arrayList2.isEmpty()) {
            return;
        }
        Iterator it = arrayList2.iterator();
        while (true) {
            if (!it.hasNext()) {
                bVar = null;
                break;
            } else {
                bVar = (b) it.next();
                if (bVar.f37859d == 400) {
                    break;
                }
            }
        }
        if (bVar == null) {
            bVar = (b) arrayList2.get(0);
        }
        if (bVar.f37857b.isEmpty()) {
            return;
        }
        arrayList.add(bVar);
    }

    private static b[] a() throws IOException {
        b[] bVarArr = new b[0];
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
            return bVarArr;
        }
    }

    private static b a(b[] bVarArr, String str) {
        String lowerCase = str.toLowerCase();
        for (b bVar : bVarArr) {
            if (bVar.f37856a.toLowerCase().equals(lowerCase)) {
                return bVar;
            }
        }
        return null;
    }

    private static void a(b bVar, ArrayList arrayList, ArrayList arrayList2) {
        if (!arrayList.contains(bVar.f37857b) && new File(bVar.f37857b).exists()) {
            arrayList.add(bVar.f37857b);
            arrayList2.add(Integer.valueOf(bVar.f37858c));
        }
    }
}
