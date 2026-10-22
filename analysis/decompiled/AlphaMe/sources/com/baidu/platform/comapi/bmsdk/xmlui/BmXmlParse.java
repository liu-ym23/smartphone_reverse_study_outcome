package com.baidu.platform.comapi.bmsdk.xmlui;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.DOMException;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/* loaded from: classes.dex */
public class BmXmlParse {
    public static Document a(byte[] bArr) throws DOMException, IOException {
        Document document = null;
        if (bArr == null || bArr.length < 10) {
            return null;
        }
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
        try {
            try {
                try {
                    try {
                        try {
                            document = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(byteArrayInputStream);
                            byteArrayInputStream.close();
                        } catch (IOException e4) {
                            e4.printStackTrace();
                            byteArrayInputStream.close();
                        }
                    } catch (SAXException e5) {
                        e5.printStackTrace();
                        byteArrayInputStream.close();
                    }
                } catch (ParserConfigurationException e6) {
                    e6.printStackTrace();
                    byteArrayInputStream.close();
                }
            } catch (Throwable th) {
                try {
                    byteArrayInputStream.close();
                } catch (IOException e7) {
                    e7.printStackTrace();
                }
                throw th;
            }
        } catch (IOException e8) {
            e8.printStackTrace();
        }
        if (document != null) {
            a(document.getDocumentElement());
        }
        return document;
    }

    private static native String nativeConvertRichText2Xml(String str);

    private static void a(Node node) throws DOMException {
        while (node != null) {
            Node previousSibling = node.getPreviousSibling();
            if ("#text".equalsIgnoreCase(node.getNodeName())) {
                node.getParentNode().removeChild(node);
            } else {
                NodeList childNodes = node.getChildNodes();
                if (childNodes != null && childNodes.getLength() > 0) {
                    a(node.getLastChild());
                }
            }
            node = previousSibling;
        }
    }
}
