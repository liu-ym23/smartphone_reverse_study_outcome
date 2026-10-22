package com.byted.cast.linkcommon.cybergarage.xml.parser;

import com.byted.cast.common.ContextManager;
import com.byted.cast.linkcommon.cybergarage.xml.Node;
import com.byted.cast.linkcommon.cybergarage.xml.Parser;
import com.byted.cast.linkcommon.cybergarage.xml.ParserException;
import java.io.InputStream;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.xml.sax.InputSource;

/* JADX INFO: loaded from: classes28.dex */
public class JaxpParser extends Parser {
    public JaxpParser(ContextManager.CastContext r100) {
        super(r100);
    }

    @Override // com.byted.cast.linkcommon.cybergarage.xml.Parser
    public Node parse(InputStream r100) throws ParserException {
        DocumentBuilderFactory r101 = DocumentBuilderFactory.newInstance();     // Catch: Exception -> L6
        r101.setFeature("http://javax.xml.XMLConstants/feature/secure-processing", true);     // Catch: Exception -> L6
        Element r102 = r101.newDocumentBuilder().parse(new InputSource(r100)).getDocumentElement();     // Catch: Exception -> L6
        if (r102 == null) goto L11;
        return parse(null, r102);
    L11:
        return null;
    L6:
        e = move-exception;
        throw new ParserException(e);
    }

    public Node parse(Node r100, org.w3c.dom.Node r101) {
        return parse(r100, r101, 0);
    }

    public Node parse(Node r100, org.w3c.dom.Node r101, int r102) {
        short r103 = r101.getNodeType();
        String r104 = r101.getNodeName();
        String r105 = r101.getNodeValue();
        NamedNodeMap r106 = r101.getAttributes();
        if (r106 == null) goto L6;
        r106.getLength();
    L6:
        if (r103 != 3) goto L10;
        r100.addValue(r105);
        return r100;
    L10:
        if (r103 == 1) goto L12;
        return r100;
    L12:
        Node r107 = new Node();
        r107.setName(r104);
        r107.setValue(r105);
        if (r100 == null) goto L15;
        r100.addNode(r107);
    L15:
        NamedNodeMap r108 = r101.getAttributes();
        if (r108 == null) goto L20;
        int r109 = r108.getLength();
        int r110 = 0;
    L18:
        if (r110 >= r109) goto L20;
        org.w3c.dom.Node r111 = r108.item(r110);
        r107.setAttribute(r111.getNodeName(), r111.getNodeValue());
        r110 = r110 + 1;
    L20:
        org.w3c.dom.Node r112 = r101.getFirstChild();
        if (r112 != null) goto L24;
        r107.setValue("");
        return r107;
    L24:
        parse(r107, r112, r102 + 1);
        r112 = r112.getNextSibling();
        if (r112 != null) goto L24;
        return r107;
    }
}
