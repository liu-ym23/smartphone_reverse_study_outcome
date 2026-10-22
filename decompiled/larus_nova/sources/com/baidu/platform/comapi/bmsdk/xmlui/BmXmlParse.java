package com.baidu.platform.comapi.bmsdk.xmlui;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/* JADX INFO: loaded from: classes39.dex */
public class BmXmlParse {
    private static native String nativeConvertRichText2Xml(String r100);

    public BmXmlParse() {
    }

    public static Document a(byte[] r100) {
        Document r101 = null;
        if (r100 != null) goto L5;
    L35:
        return null;
    L5:
        if (r100.length < 10) goto L35;
        ByteArrayInputStream r102 = new ByteArrayInputStream(r100);
        r101 = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(r102);     // Catch: Throwable -> L11 ParserConfigurationException -> L13 SAXException -> L17 IOException -> L21
        r102.close();     // Catch: IOException -> L25
    L38:
    L27:
        if (r101 == null) goto L29;
        a(r101.getDocumentElement());
    L29:
        return r101;
    L25:
        e = move-exception;
        e.printStackTrace();
    L17:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L11
        r102.close();     // Catch: IOException -> L25
    L21:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L11
        r102.close();     // Catch: IOException -> L25
    L13:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L11
        r102.close();     // Catch: IOException -> L25
    L11:
        th = move-exception;
        r102.close();     // Catch: IOException -> L32
    L34:
        throw th;
    L32:
        e = move-exception;
        e.printStackTrace();
        goto L34
    }

    private static void a(Node r100) {
    L2:
        if (r100 == null) goto L12;
        Node r101 = r100.getPreviousSibling();
        if ("#text".equalsIgnoreCase(r100.getNodeName()) == false) goto L6;
        r100.getParentNode().removeChild(r100);
    L11:
        r100 = r101;
        goto L2
    L6:
        NodeList r102 = r100.getChildNodes();
        if (r102 == null) goto L11;
        if (r102.getLength() <= 0) goto L11;
        a(r100.getLastChild());
        goto L11
    }
}
