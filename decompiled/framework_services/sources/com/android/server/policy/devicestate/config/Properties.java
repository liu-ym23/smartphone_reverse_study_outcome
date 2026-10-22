package com.android.server.policy.devicestate.config;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.xml.datatype.DatatypeConfigurationException;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: loaded from: classes2.dex */
public class Properties {
    private List<String> property;

    public Properties() {
    }

    public List<String> getProperty() {
        if (this.property != null) goto L6;
        this.property = new ArrayList();
    L6:
        return this.property;
    }

    static Properties read(XmlPullParser _parser) throws XmlPullParserException, IOException, DatatypeConfigurationException {
        Properties _instance = new Properties();
        _parser.getDepth();
    L3:
        int type = _parser.next();
        if (type == 1) goto L14;
        if (type == 3) goto L14;
        if (_parser.getEventType() != 2) goto L3;
        String _tagName = _parser.getName();
        if (_tagName.equals("property") == true) goto L11;
        XmlParser.skip(_parser);
        goto L3
    L11:
        String _raw = XmlParser.readText(_parser);
        _instance.getProperty().add(_raw);
    L14:
        if (type != 3) goto L17;
        return _instance;
    L17:
        throw new DatatypeConfigurationException("Properties is not closed");
    }
}
