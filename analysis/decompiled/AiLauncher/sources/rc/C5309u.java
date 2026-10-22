package rc;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import javax.xml.parsers.DocumentBuilderFactory;
import org.scilab.forge.jlatexmath.FontAlreadyLoadedException;
import org.scilab.forge.jlatexmath.ResourceParseException;
import org.scilab.forge.jlatexmath.XMLResourceParseException;
import org.w3c.dom.Attr;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/* renamed from: rc.u, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public class C5309u {

    /* renamed from: d, reason: collision with root package name */
    public static DocumentBuilderFactory f39421d = DocumentBuilderFactory.newInstance();

    /* renamed from: e, reason: collision with root package name */
    public static ArrayList<String> f39422e = new ArrayList<>();

    /* renamed from: f, reason: collision with root package name */
    public static Map<String, Integer> f39423f = new HashMap();

    /* renamed from: g, reason: collision with root package name */
    public static Map<String, a> f39424g = new HashMap();

    /* renamed from: a, reason: collision with root package name */
    public Map<String, C5298o[]> f39425a;

    /* renamed from: b, reason: collision with root package name */
    public Element f39426b;

    /* renamed from: c, reason: collision with root package name */
    public Object f39427c;

    /* renamed from: rc.u$a */
    public interface a {
        void a(Element element, char c10, F f10) throws XMLResourceParseException;
    }

    /* renamed from: rc.u$b */
    public static class b implements a {
        @Override // rc.C5309u.a
        public void a(Element element, char c10, F f10) throws ResourceParseException {
            f10.u(c10, new int[]{C5309u.g("top", element, -1), C5309u.g("mid", element, -1), C5309u.e("rep", element), C5309u.g("bot", element, -1)});
        }
    }

    /* renamed from: rc.u$c */
    public static class c implements a {
        @Override // rc.C5309u.a
        public void a(Element element, char c10, F f10) throws ResourceParseException {
            f10.a(c10, (char) C5309u.e("code", element), C5309u.d("val", element));
        }
    }

    /* renamed from: rc.u$d */
    public static class d implements a {
        @Override // rc.C5309u.a
        public void a(Element element, char c10, F f10) throws ResourceParseException {
            f10.b(c10, (char) C5309u.e("code", element), (char) C5309u.e("ligCode", element));
        }
    }

    /* renamed from: rc.u$e */
    public static class e implements a {
        @Override // rc.C5309u.a
        public void a(Element element, char c10, F f10) throws ResourceParseException {
            f10.x(c10, (char) C5309u.e("code", element), C5309u.f39422e.indexOf(C5309u.c("fontId", element)));
        }
    }

    static {
        s();
        r();
    }

    public C5309u() throws ResourceParseException {
        this(Bc.a.b("DefaultTeXFont.xml"), "DefaultTeXFont.xml");
    }

    public static Cc.e b(String str) {
        return Cc.e.b(Bc.a.d(str), a1.f39201g * a1.f39202h);
    }

    public static String c(String str, Element element) throws ResourceParseException {
        String attribute = element.getAttribute(str);
        if (attribute.equals("")) {
            throw new XMLResourceParseException("DefaultTeXFont.xml", element.getTagName(), str, null);
        }
        return attribute;
    }

    public static float d(String str, Element element) throws ResourceParseException {
        try {
            return (float) Double.parseDouble(c(str, element));
        } catch (NumberFormatException unused) {
            throw new XMLResourceParseException("DefaultTeXFont.xml", element.getTagName(), str, "has an invalid real value!");
        }
    }

    public static int e(String str, Element element) throws ResourceParseException {
        try {
            return Integer.parseInt(c(str, element));
        } catch (NumberFormatException unused) {
            throw new XMLResourceParseException("DefaultTeXFont.xml", element.getTagName(), str, "has an invalid integer value!");
        }
    }

    public static float f(String str, Element element, float f10) throws ResourceParseException {
        String attribute = element.getAttribute(str);
        if (attribute.equals("")) {
            return f10;
        }
        try {
            return (float) Double.parseDouble(attribute);
        } catch (NumberFormatException unused) {
            throw new XMLResourceParseException("DefaultTeXFont.xml", element.getTagName(), str, "has an invalid float value!");
        }
    }

    public static int g(String str, Element element, int i10) throws ResourceParseException {
        String attribute = element.getAttribute(str);
        if (attribute.equals("")) {
            return i10;
        }
        try {
            return Integer.parseInt(attribute);
        } catch (NumberFormatException unused) {
            throw new XMLResourceParseException("DefaultTeXFont.xml", element.getTagName(), str, "has an invalid integer value!");
        }
    }

    public static void q(Element element, F f10) throws ResourceParseException {
        char cE = (char) e("code", element);
        f10.w(cE, new float[]{f("width", element, 0.0f), f("height", element, 0.0f), f("depth", element, 0.0f), f("italic", element, 0.0f)});
        NodeList childNodes = element.getChildNodes();
        for (int i10 = 0; i10 < childNodes.getLength(); i10++) {
            Node nodeItem = childNodes.item(i10);
            if (nodeItem.getNodeType() != 3) {
                Element element2 = (Element) nodeItem;
                a aVar = f39424g.get(element2.getTagName());
                if (aVar == null) {
                    throw new XMLResourceParseException("DefaultTeXFont.xml: a <Char>-element has an unknown child element '" + element2.getTagName() + "'!");
                }
                aVar.a(element2, cE, f10);
            }
        }
    }

    public static void r() {
        f39424g.put("Kern", new c());
        f39424g.put("Lig", new d());
        f39424g.put("NextLarger", new e());
        f39424g.put("Extension", new b());
    }

    public static void s() {
        f39423f.put("numbers", 0);
        f39423f.put("capitals", 1);
        f39423f.put("small", 2);
        f39423f.put("unicode", 3);
    }

    public String[] h() throws ResourceParseException {
        String[] strArr = new String[4];
        Element element = (Element) this.f39426b.getElementsByTagName("DefaultTextStyleMapping").item(0);
        if (element != null) {
            NodeList elementsByTagName = element.getElementsByTagName("MapStyle");
            for (int i10 = 0; i10 < elementsByTagName.getLength(); i10++) {
                Element element2 = (Element) elementsByTagName.item(i10);
                String strC = c("code", element2);
                Integer num = f39423f.get(strC);
                if (num == null) {
                    throw new XMLResourceParseException("DefaultTeXFont.xml", "MapStyle", "code", "contains an unknown \"range name\" '" + strC + "'!");
                }
                String strC2 = c("textStyle", element2);
                if (this.f39425a.get(strC2) == null) {
                    throw new XMLResourceParseException("DefaultTeXFont.xml", "MapStyle", "textStyle", "contains an unknown text style '" + strC2 + "'!");
                }
                C5298o[] c5298oArr = this.f39425a.get(strC2);
                int iIntValue = num.intValue();
                if (c5298oArr[iIntValue] == null) {
                    throw new XMLResourceParseException("DefaultTeXFont.xml: the default text style mapping '" + strC2 + "' for the range '" + strC + "' contains no mapping for that range!");
                }
                strArr[iIntValue] = strC2;
            }
        }
        return strArr;
    }

    public void i() throws ResourceParseException {
        Element element = (Element) this.f39426b.getElementsByTagName("TeXSymbols").item(0);
        if (element != null) {
            String strC = c("include", element);
            W0.o(Bc.a.b(strC), strC);
        }
        Element element2 = (Element) this.f39426b.getElementsByTagName("FormulaSettings").item(0);
        if (element2 != null) {
            String strC2 = c("include", element2);
            a1.g(Bc.a.b(strC2), strC2);
        }
    }

    public F[] j(F[] fArr) throws ResourceParseException {
        Element element = (Element) this.f39426b.getElementsByTagName("FontDescriptions").item(0);
        if (element != null) {
            NodeList elementsByTagName = element.getElementsByTagName("Metrics");
            for (int i10 = 0; i10 < elementsByTagName.getLength(); i10++) {
                String strC = c("include", (Element) elementsByTagName.item(i10));
                fArr = this.f39427c == null ? k(fArr, Bc.a.b(strC), strC) : k(fArr, Bc.a.b(strC), strC);
            }
        }
        return fArr;
    }

    public F[] k(F[] fArr, InputStream inputStream, String str) throws ResourceParseException {
        String strC;
        String strC2;
        String strC3;
        String strC4;
        if (inputStream == null) {
            return fArr;
        }
        ArrayList arrayList = new ArrayList(Arrays.asList(fArr));
        try {
            Element documentElement = f39421d.newDocumentBuilder().parse(inputStream).getDocumentElement();
            String strC5 = c("name", documentElement);
            String strC6 = c("id", documentElement);
            if (f39422e.indexOf(strC6) >= 0) {
                throw new FontAlreadyLoadedException("Font " + strC6 + " is already loaded !");
            }
            f39422e.add(strC6);
            float fD = d("space", documentElement);
            float fD2 = d("xHeight", documentElement);
            float fD3 = d("quad", documentElement);
            int iG = g("skewChar", documentElement, -1);
            int iG2 = g("unicode", documentElement, 0);
            String strC7 = null;
            try {
                strC = c("boldVersion", documentElement);
            } catch (ResourceParseException unused) {
                strC = null;
            }
            try {
                strC2 = c("romanVersion", documentElement);
            } catch (ResourceParseException unused2) {
                strC2 = null;
            }
            try {
                strC3 = c("ssVersion", documentElement);
            } catch (ResourceParseException unused3) {
                strC3 = null;
            }
            try {
                strC4 = c("ttVersion", documentElement);
            } catch (ResourceParseException unused4) {
                strC4 = null;
            }
            try {
                strC7 = c("itVersion", documentElement);
            } catch (ResourceParseException unused5) {
            }
            F f10 = new F(f39422e.indexOf(strC6), this.f39427c, str.substring(0, str.lastIndexOf("/") + 1) + strC5, strC5, iG2, fD2, fD, fD3, strC, strC2, strC3, strC4, strC7);
            if (iG != -1) {
                f10.z((char) iG);
            }
            NodeList elementsByTagName = documentElement.getElementsByTagName("Char");
            for (int i10 = 0; i10 < elementsByTagName.getLength(); i10++) {
                q((Element) elementsByTagName.item(i10), f10);
            }
            arrayList.add(f10);
            for (int i11 = 0; i11 < arrayList.size(); i11++) {
                F f11 = (F) arrayList.get(i11);
                f11.t(f39422e.indexOf(f11.f39062u));
                f11.y(f39422e.indexOf(f11.f39063v));
                f11.A(f39422e.indexOf(f11.f39064w));
                f11.B(f39422e.indexOf(f11.f39065x));
                f11.v(f39422e.indexOf(f11.f39066y));
            }
            this.f39425a = n();
            return (F[]) arrayList.toArray(fArr);
        } catch (Exception e10) {
            throw new XMLResourceParseException("Cannot find the file " + str + "!" + e10.toString());
        }
    }

    public Map<String, Number> l() throws ResourceParseException {
        HashMap map = new HashMap();
        Element element = (Element) this.f39426b.getElementsByTagName("GeneralSettings").item(0);
        if (element == null) {
            throw new XMLResourceParseException("DefaultTeXFont.xml", "GeneralSettings");
        }
        map.put("mufontid", Integer.valueOf(f39422e.indexOf(c("mufontid", element))));
        map.put("spacefontid", Integer.valueOf(f39422e.indexOf(c("spacefontid", element))));
        map.put("scriptfactor", Float.valueOf(d("scriptfactor", element)));
        map.put("scriptscriptfactor", Float.valueOf(d("scriptscriptfactor", element)));
        return map;
    }

    public Map<String, Float> m() throws ResourceParseException {
        HashMap map = new HashMap();
        Element element = (Element) this.f39426b.getElementsByTagName("Parameters").item(0);
        if (element == null) {
            throw new XMLResourceParseException("DefaultTeXFont.xml", "Parameters");
        }
        NamedNodeMap attributes = element.getAttributes();
        for (int i10 = 0; i10 < attributes.getLength(); i10++) {
            String name = ((Attr) attributes.item(i10)).getName();
            map.put(name, new Float(d(name, element)));
        }
        return map;
    }

    public final Map<String, C5298o[]> n() throws ResourceParseException {
        String strC;
        HashMap map = new HashMap();
        Element element = (Element) this.f39426b.getElementsByTagName("TextStyleMappings").item(0);
        if (element != null) {
            NodeList elementsByTagName = element.getElementsByTagName("TextStyleMapping");
            for (int i10 = 0; i10 < elementsByTagName.getLength(); i10++) {
                Element element2 = (Element) elementsByTagName.item(i10);
                String strC2 = c("name", element2);
                try {
                    strC = c("bold", element2);
                } catch (ResourceParseException unused) {
                    strC = null;
                }
                NodeList elementsByTagName2 = element2.getElementsByTagName("MapRange");
                C5298o[] c5298oArr = new C5298o[4];
                for (int i11 = 0; i11 < elementsByTagName2.getLength(); i11++) {
                    Element element3 = (Element) elementsByTagName2.item(i11);
                    String strC3 = c("fontId", element3);
                    int iE = e("start", element3);
                    String strC4 = c("code", element3);
                    Integer num = f39423f.get(strC4);
                    if (num == null) {
                        throw new XMLResourceParseException("DefaultTeXFont.xml", "MapRange", "code", "contains an unknown \"range name\" '" + strC4 + "'!");
                    }
                    if (strC == null) {
                        c5298oArr[num.intValue()] = new C5298o((char) iE, f39422e.indexOf(strC3));
                    } else {
                        c5298oArr[num.intValue()] = new C5298o((char) iE, f39422e.indexOf(strC3), f39422e.indexOf(strC));
                    }
                }
                map.put(strC2, c5298oArr);
            }
        }
        return map;
    }

    public Map<String, C5298o> o() throws ResourceParseException {
        String strC;
        HashMap map = new HashMap();
        Element element = (Element) this.f39426b.getElementsByTagName("SymbolMappings").item(0);
        if (element == null) {
            throw new XMLResourceParseException("DefaultTeXFont.xml", "SymbolMappings");
        }
        NodeList elementsByTagName = element.getElementsByTagName("Mapping");
        for (int i10 = 0; i10 < elementsByTagName.getLength(); i10++) {
            String strC2 = c("include", (Element) elementsByTagName.item(i10));
            try {
                NodeList elementsByTagName2 = (this.f39427c == null ? f39421d.newDocumentBuilder().parse(Bc.a.b(strC2)).getDocumentElement() : f39421d.newDocumentBuilder().parse(Bc.a.b(strC2)).getDocumentElement()).getElementsByTagName("SymbolMapping");
                for (int i11 = 0; i11 < elementsByTagName2.getLength(); i11++) {
                    Element element2 = (Element) elementsByTagName2.item(i11);
                    String strC3 = c("name", element2);
                    int iE = e("ch", element2);
                    String strC4 = c("fontId", element2);
                    try {
                        strC = c("boldId", element2);
                    } catch (ResourceParseException unused) {
                        strC = null;
                    }
                    if (strC == null) {
                        map.put(strC3, new C5298o((char) iE, f39422e.indexOf(strC4)));
                    } else {
                        map.put(strC3, new C5298o((char) iE, f39422e.indexOf(strC4), f39422e.indexOf(strC)));
                    }
                }
            } catch (Exception unused2) {
                throw new XMLResourceParseException("Cannot find the file " + strC2 + "!");
            }
        }
        return map;
    }

    public Map<String, C5298o[]> p() {
        return this.f39425a;
    }

    public C5309u(InputStream inputStream, String str) throws ResourceParseException {
        this.f39427c = null;
        f39421d.setIgnoringElementContentWhitespace(true);
        f39421d.setIgnoringComments(true);
        try {
            this.f39426b = f39421d.newDocumentBuilder().parse(inputStream).getDocumentElement();
        } catch (Exception e10) {
            throw new XMLResourceParseException(str, e10);
        }
    }

    public C5309u(Object obj, InputStream inputStream, String str) throws ResourceParseException {
        this.f39427c = obj;
        f39421d.setIgnoringElementContentWhitespace(true);
        f39421d.setIgnoringComments(true);
        try {
            this.f39426b = f39421d.newDocumentBuilder().parse(inputStream).getDocumentElement();
        } catch (Exception e10) {
            throw new XMLResourceParseException(str, e10);
        }
    }
}
