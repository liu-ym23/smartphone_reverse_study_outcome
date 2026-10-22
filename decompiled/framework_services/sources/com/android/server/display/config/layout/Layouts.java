package com.android.server.display.config.layout;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.xml.datatype.DatatypeConfigurationException;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: loaded from: classes2.dex */
public class Layouts {
    private List<Layout> layout;

    public Layouts() {
    }

    public List<Layout> getLayout() {
        if (this.layout != null) goto L6;
        this.layout = new ArrayList();
    L6:
        return this.layout;
    }

    static Layouts read(XmlPullParser _parser) throws XmlPullParserException, IOException, DatatypeConfigurationException {
        Layouts _instance = new Layouts();
        _parser.getDepth();
    L3:
        int type = _parser.next();
        if (type == 1) goto L14;
        if (type == 3) goto L14;
        if (_parser.getEventType() != 2) goto L3;
        String _tagName = _parser.getName();
        if (_tagName.equals("layout") == true) goto L11;
        XmlParser.skip(_parser);
        goto L3
    L11:
        Layout _value = Layout.read(_parser);
        _instance.getLayout().add(_value);
    L14:
        if (type != 3) goto L17;
        return _instance;
    L17:
        throw new DatatypeConfigurationException("Layouts is not closed");
    }
}
