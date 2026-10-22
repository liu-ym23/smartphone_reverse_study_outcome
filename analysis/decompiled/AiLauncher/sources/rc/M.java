package rc;

import io.ktor.http.LinkHeader;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import javax.xml.parsers.DocumentBuilderFactory;
import org.scilab.forge.jlatexmath.ResourceParseException;
import org.scilab.forge.jlatexmath.XMLResourceParseException;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

/* loaded from: classes5.dex */
public class M {

    /* renamed from: c, reason: collision with root package name */
    public K[] f39129c;

    /* renamed from: e, reason: collision with root package name */
    public Element f39131e;

    /* renamed from: a, reason: collision with root package name */
    public final Map<String, Integer> f39127a = new HashMap();

    /* renamed from: b, reason: collision with root package name */
    public final Map<String, Integer> f39128b = new HashMap();

    /* renamed from: d, reason: collision with root package name */
    public final Map<String, Integer> f39130d = new HashMap();

    public M() throws ResourceParseException {
        try {
            h();
            g();
            DocumentBuilderFactory documentBuilderFactoryNewInstance = DocumentBuilderFactory.newInstance();
            documentBuilderFactoryNewInstance.setIgnoringElementContentWhitespace(true);
            documentBuilderFactoryNewInstance.setIgnoringComments(true);
            this.f39131e = documentBuilderFactoryNewInstance.newDocumentBuilder().parse(Bc.a.b("GlueSettings.xml")).getDocumentElement();
            f();
        } catch (Exception e10) {
            throw new XMLResourceParseException("GlueSettings.xml", e10);
        }
    }

    public static void a(Object obj, String str, String str2, String str3) throws ResourceParseException {
        if (obj != null) {
            return;
        }
        throw new XMLResourceParseException("GlueSettings.xml", str, str2, "has an unknown value '" + str3 + "'!");
    }

    public static String d(String str, Element element) throws ResourceParseException {
        String attribute = element.getAttribute(str);
        if (attribute.equals("")) {
            throw new XMLResourceParseException("GlueSettings.xml", element.getTagName(), str, null);
        }
        return attribute;
    }

    public final K b(Element element, String str) throws ResourceParseException {
        String[] strArr = {"space", "stretch", "shrink"};
        float[] fArr = new float[3];
        for (int i10 = 0; i10 < 3; i10++) {
            String attribute = null;
            try {
                attribute = element.getAttribute(strArr[i10]);
                fArr[i10] = (float) (!attribute.equals("") ? Double.parseDouble(attribute) : 0.0d);
            } catch (NumberFormatException unused) {
                throw new XMLResourceParseException("GlueSettings.xml", "GlueType", strArr[i10], "has an invalid real value '" + attribute + "'!");
            }
        }
        return new K(fArr[0], fArr[1], fArr[2], str);
    }

    public int[][][] c() throws ResourceParseException {
        int size = this.f39127a.size();
        int i10 = 0;
        int[][][] iArr = (int[][][]) Array.newInstance((Class<?>) Integer.TYPE, size, size, this.f39130d.size());
        Element element = (Element) this.f39131e.getElementsByTagName("GlueTable").item(0);
        if (element != null) {
            NodeList elementsByTagName = element.getElementsByTagName("Glue");
            int i11 = 0;
            while (i11 < elementsByTagName.getLength()) {
                Element element2 = (Element) elementsByTagName.item(i11);
                String strD = d("lefttype", element2);
                String strD2 = d("righttype", element2);
                String strD3 = d("gluetype", element2);
                NodeList elementsByTagName2 = element2.getElementsByTagName("Style");
                int i12 = i10;
                while (i12 < elementsByTagName2.getLength()) {
                    String strD4 = d("name", (Element) elementsByTagName2.item(i12));
                    int[][][] iArr2 = iArr;
                    Integer num = this.f39127a.get(strD);
                    NodeList nodeList = elementsByTagName;
                    Integer num2 = this.f39127a.get(strD2);
                    int i13 = i11;
                    Integer num3 = this.f39130d.get(strD4);
                    NodeList nodeList2 = elementsByTagName2;
                    Integer num4 = this.f39128b.get(strD3);
                    a(num, "Glue", "lefttype", strD);
                    a(num2, "Glue", "righttype", strD2);
                    a(num4, "Glue", "gluetype", strD3);
                    a(num3, "Style", "name", strD4);
                    iArr2[num.intValue()][num2.intValue()][num3.intValue()] = num4.intValue();
                    i12++;
                    iArr = iArr2;
                    elementsByTagName = nodeList;
                    i11 = i13;
                    elementsByTagName2 = nodeList2;
                }
                i11++;
                i10 = 0;
            }
        }
        return iArr;
    }

    public K[] e() {
        return this.f39129c;
    }

    public final void f() throws ResourceParseException {
        int i10;
        ArrayList arrayList = new ArrayList();
        int i11 = 0;
        Element element = (Element) this.f39131e.getElementsByTagName("GlueTypes").item(0);
        int i12 = -1;
        if (element != null) {
            NodeList elementsByTagName = element.getElementsByTagName("GlueType");
            i10 = 0;
            for (int i13 = 0; i13 < elementsByTagName.getLength(); i13++) {
                Element element2 = (Element) elementsByTagName.item(i13);
                String strD = d("name", element2);
                K kB = b(element2, strD);
                if (strD.equalsIgnoreCase("default")) {
                    i12 = i10;
                }
                arrayList.add(kB);
                i10++;
            }
        } else {
            i10 = 0;
        }
        if (i12 < 0) {
            arrayList.add(new K(0.0f, 0.0f, 0.0f, "default"));
            i12 = i10;
        }
        K[] kArr = (K[]) arrayList.toArray(new K[arrayList.size()]);
        this.f39129c = kArr;
        if (i12 > 0) {
            K k10 = kArr[i12];
            kArr[i12] = kArr[0];
            kArr[0] = k10;
        }
        while (true) {
            K[] kArr2 = this.f39129c;
            if (i11 >= kArr2.length) {
                return;
            }
            this.f39128b.put(kArr2[i11].c(), Integer.valueOf(i11));
            i11++;
        }
    }

    public final void g() {
        this.f39130d.put("display", 0);
        this.f39130d.put("text", 1);
        this.f39130d.put("script", 2);
        this.f39130d.put("script_script", 3);
    }

    public final void h() {
        this.f39127a.put("ord", 0);
        this.f39127a.put("op", 1);
        this.f39127a.put("bin", 2);
        this.f39127a.put(LinkHeader.Parameters.Rel, 3);
        this.f39127a.put("open", 4);
        this.f39127a.put("close", 5);
        this.f39127a.put("punct", 6);
        this.f39127a.put("inner", 7);
    }
}
