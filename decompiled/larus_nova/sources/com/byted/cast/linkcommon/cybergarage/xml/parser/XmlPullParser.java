package com.byted.cast.linkcommon.cybergarage.xml.parser;

import com.byted.cast.common.ContextManager;
import com.byted.cast.linkcommon.cybergarage.xml.Node;
import com.byted.cast.linkcommon.cybergarage.xml.Parser;
import com.byted.cast.linkcommon.cybergarage.xml.ParserException;
import java.io.InputStream;
import org.xmlpull.v1.XmlPullParserFactory;

/* JADX INFO: loaded from: classes28.dex */
public class XmlPullParser extends Parser {
    private static final String TAG = "XmlPullParser";

    public XmlPullParser(ContextManager.CastContext r100) {
        super(r100);
    }

    @Override // com.byted.cast.linkcommon.cybergarage.xml.Parser
    public Node parse(InputStream r100) throws ParserException {
        XmlPullParserFactory r101 = XmlPullParserFactory.newInstance();     // Catch: Exception -> L4
        r101.setNamespaceAware(true);     // Catch: Exception -> L4
        return parse(r101.newPullParser(), r100);
    L4:
        e = move-exception;
        throw new ParserException(e);
    }

    public Node parse(org.xmlpull.v1.XmlPullParser r100, InputStream r101) throws ParserException {
        Node r102 = null;
        r100.setInput(r101, null);     // Catch: Exception -> L38
        int r103 = r100.getEventType();     // Catch: Exception -> L38
        Node r104 = null;
    L5:
        if (r103 == 1) goto L37;
        if (r103 != 2) goto L9;
        Node r105 = new Node();     // Catch: Exception -> L38
        String r106 = r100.getPrefix();     // Catch: Exception -> L38
        String r107 = r100.getName();     // Catch: Exception -> L38
        StringBuffer r108 = new StringBuffer();     // Catch: Exception -> L38
        if (r106 != null) goto L22;
    L24:
        if (r107 != null) goto L26;
    L28:
        r105.setName(r108.toString());     // Catch: Exception -> L38
        int r109 = r100.getAttributeCount();     // Catch: Exception -> L38
        int r110 = 0;
    L29:
        if (r110 >= r109) goto L31;
        r105.setAttribute(r100.getAttributeName(r110), r100.getAttributeValue(r110));     // Catch: Exception -> L38
        r110 = r110 + 1;     // Catch: Exception -> L38
        goto L29
    L31:
        if (r104 == null) goto L33;
        r104.addNode(r105);     // Catch: Exception -> L38
    L33:
        if (r102 == null) goto L34;
    L18:
        r104 = r105;
    L35:
        r103 = r100.next();     // Catch: Exception -> L38
        goto L5
    L34:
        r102 = r105;
        goto L18
    L26:
        if (r107.length() <= 0) goto L28;
        r108.append(r107);     // Catch: Exception -> L38
        goto L28
    L22:
        if (r106.length() <= 0) goto L24;
        r108.append(r106);     // Catch: Exception -> L38
        r108.append(":");     // Catch: Exception -> L38
        goto L24
    L9:
        if (r103 != 3) goto L11;
        r105 = r104.getParentNode();     // Catch: Exception -> L38
        goto L18
    L11:
        if (r103 != 4) goto L35;
        String r111 = r100.getText();     // Catch: Exception -> L38
        if (r111 == null) goto L35;
        if (r104 == null) goto L35;
        r104.setValue(r111);     // Catch: Exception -> L38
        goto L35
    L37:
        return r102;
    L38:
        e = move-exception;
        throw new ParserException(e);
    }
}
