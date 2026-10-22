package rc;

import java.io.InputStream;
import javax.xml.parsers.DocumentBuilderFactory;
import org.scilab.forge.jlatexmath.ResourceParseException;
import org.scilab.forge.jlatexmath.XMLResourceParseException;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

/* loaded from: classes5.dex */
public class b1 {

    /* renamed from: a, reason: collision with root package name */
    public Element f39229a;

    public b1() throws ResourceParseException {
        this(Bc.a.b("TeXFormulaSettings.xml"), "TeXFormulaSettings.xml");
    }

    public static void a(NodeList nodeList, String[] strArr, String[] strArr2) throws ResourceParseException {
        for (int i10 = 0; i10 < nodeList.getLength(); i10++) {
            Element element = (Element) nodeList.item(i10);
            String attribute = element.getAttribute("char");
            String attribute2 = element.getAttribute("formula");
            String attribute3 = element.getAttribute("text");
            if (attribute.equals("")) {
                throw new XMLResourceParseException("TeXFormulaSettings.xml", element.getTagName(), "char", null);
            }
            if (attribute2.equals("")) {
                throw new XMLResourceParseException("TeXFormulaSettings.xml", element.getTagName(), "formula", null);
            }
            if (attribute.length() != 1) {
                throw new XMLResourceParseException("TeXFormulaSettings.xml", element.getTagName(), "char", "must have a value that contains exactly 1 character!");
            }
            strArr[attribute.charAt(0)] = attribute2;
            if (strArr2 != null && !attribute3.equals("")) {
                strArr2[attribute.charAt(0)] = attribute3;
            }
        }
    }

    public static void b(NodeList nodeList, String[] strArr, String[] strArr2) throws ResourceParseException {
        for (int i10 = 0; i10 < nodeList.getLength(); i10++) {
            Element element = (Element) nodeList.item(i10);
            String attribute = element.getAttribute("char");
            String attribute2 = element.getAttribute("symbol");
            String attribute3 = element.getAttribute("text");
            if (attribute.equals("")) {
                throw new XMLResourceParseException("TeXFormulaSettings.xml", element.getTagName(), "char", null);
            }
            if (attribute2.equals("")) {
                throw new XMLResourceParseException("TeXFormulaSettings.xml", element.getTagName(), "symbol", null);
            }
            if (attribute.length() != 1) {
                throw new XMLResourceParseException("TeXFormulaSettings.xml", element.getTagName(), "char", "must have a value that contains exactly 1 character!");
            }
            strArr[attribute.charAt(0)] = attribute2;
            if (strArr2 != null && !attribute3.equals("")) {
                strArr2[attribute.charAt(0)] = attribute3;
            }
        }
    }

    public void c(String[] strArr, String[] strArr2) throws ResourceParseException {
        Element element = (Element) this.f39229a.getElementsByTagName("CharacterToSymbolMappings").item(0);
        if (element != null) {
            b(element.getElementsByTagName("Map"), strArr, strArr2);
        }
    }

    public void d(String[] strArr, String[] strArr2) throws ResourceParseException {
        Element element = (Element) this.f39229a.getElementsByTagName("CharacterToFormulaMappings").item(0);
        if (element != null) {
            a(element.getElementsByTagName("Map"), strArr, strArr2);
        }
    }

    public b1(InputStream inputStream, String str) throws ResourceParseException {
        try {
            DocumentBuilderFactory documentBuilderFactoryNewInstance = DocumentBuilderFactory.newInstance();
            documentBuilderFactoryNewInstance.setIgnoringElementContentWhitespace(true);
            documentBuilderFactoryNewInstance.setIgnoringComments(true);
            this.f39229a = documentBuilderFactoryNewInstance.newDocumentBuilder().parse(inputStream).getDocumentElement();
        } catch (Exception e10) {
            throw new XMLResourceParseException(str, e10);
        }
    }
}
