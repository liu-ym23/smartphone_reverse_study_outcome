package com.android.server.display.topology;

import java.io.IOException;
import java.io.InputStream;
import javax.xml.datatype.DatatypeConfigurationException;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

/* JADX INFO: loaded from: classes2.dex */
public class XmlParser {
    public XmlParser() {
    }

    public static DisplayTopologyState read(InputStream in) throws XmlPullParserException, IOException, DatatypeConfigurationException {
        XmlPullParser _parser = XmlPullParserFactory.newInstance().newPullParser();
        _parser.setFeature("http://xmlpull.org/v1/doc/features.html#process-namespaces", true);
        _parser.setInput(in, null);
        _parser.nextTag();
        String _tagName = _parser.getName();
        if (_tagName.equals("displayTopologyState") == false) goto L6;
        DisplayTopologyState _value = DisplayTopologyState.read(_parser);
        return _value;
    L6:
        return null;
    }

    public static String readText(XmlPullParser _parser) throws XmlPullParserException, IOException {
        if (_parser.next() != 4) goto L6;
        String result = _parser.getText();
        _parser.nextTag();
        return result;
    L6:
        return "";
    }

    public static void skip(XmlPullParser _parser) throws XmlPullParserException, IOException {
        if (_parser.getEventType() != 2) goto L14;
        int depth = 1;
    L5:
        if (depth == 0) goto L12;
        switch(_parser.next()) {
            case 2: goto L10;
            case 3: goto L9;
            default: goto L5;
        };
    L9:
        depth = depth - 1;
        goto L5
    L10:
        depth = depth + 1;
        goto L5
    L12:
        return;
    L14:
        throw new IllegalStateException();
    }
}
