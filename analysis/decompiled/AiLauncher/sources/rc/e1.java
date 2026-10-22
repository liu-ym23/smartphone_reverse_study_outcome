package rc;

import com.autonavi.aps.amapapi.config.Const;
import io.ktor.http.LinkHeader;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import javax.xml.parsers.DocumentBuilderFactory;
import org.scilab.forge.jlatexmath.ResourceParseException;
import org.scilab.forge.jlatexmath.XMLResourceParseException;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

/* loaded from: classes5.dex */
public class e1 {

    /* renamed from: b, reason: collision with root package name */
    public static Map<String, Integer> f39283b = new HashMap();

    /* renamed from: a, reason: collision with root package name */
    public Element f39284a;

    public e1() throws ResourceParseException {
        this(Bc.a.b("TeXSymbols.xml"), "TeXSymbols.xml");
    }

    public static String a(String str, Element element) throws ResourceParseException {
        String attribute = element.getAttribute(str);
        if (attribute.equals("")) {
            throw new XMLResourceParseException("TeXSymbols.xml", element.getTagName(), str, null);
        }
        return attribute;
    }

    public Map<String, W0> b() throws ResourceParseException {
        HashMap map = new HashMap();
        NodeList elementsByTagName = this.f39284a.getElementsByTagName("Symbol");
        for (int i10 = 0; i10 < elementsByTagName.getLength(); i10++) {
            Element element = (Element) elementsByTagName.item(i10);
            String strA = a("name", element);
            String strA2 = a("type", element);
            String attribute = element.getAttribute("del");
            boolean z10 = attribute != null && attribute.equals("true");
            Integer num = f39283b.get(strA2);
            if (num == null) {
                throw new XMLResourceParseException("TeXSymbols.xml", "Symbol", "type", "has an unknown value '" + strA2 + "'!");
            }
            map.put(strA, new W0(strA, num.intValue(), z10));
        }
        return map;
    }

    public final void c() {
        f39283b.put("ord", 0);
        f39283b.put("op", 1);
        f39283b.put("bin", 2);
        f39283b.put(LinkHeader.Parameters.Rel, 3);
        f39283b.put("open", 4);
        f39283b.put("close", 5);
        f39283b.put("punct", 6);
        f39283b.put(Const.JSON_KEY_ACC, 10);
    }

    public e1(InputStream inputStream, String str) throws ResourceParseException {
        try {
            DocumentBuilderFactory documentBuilderFactoryNewInstance = DocumentBuilderFactory.newInstance();
            documentBuilderFactoryNewInstance.setIgnoringElementContentWhitespace(true);
            documentBuilderFactoryNewInstance.setIgnoringComments(true);
            this.f39284a = documentBuilderFactoryNewInstance.newDocumentBuilder().parse(inputStream).getDocumentElement();
            c();
        } catch (Exception e10) {
            throw new XMLResourceParseException(str, e10);
        }
    }
}
