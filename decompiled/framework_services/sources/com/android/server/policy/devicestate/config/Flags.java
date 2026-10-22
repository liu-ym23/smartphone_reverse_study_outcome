package com.android.server.policy.devicestate.config;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.xml.datatype.DatatypeConfigurationException;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: loaded from: classes2.dex */
public class Flags {
    private List<String> flag;

    public Flags() {
    }

    public List<String> getFlag() {
        if (this.flag != null) goto L6;
        this.flag = new ArrayList();
    L6:
        return this.flag;
    }

    static Flags read(XmlPullParser _parser) throws XmlPullParserException, IOException, DatatypeConfigurationException {
        Flags _instance = new Flags();
        _parser.getDepth();
    L3:
        int type = _parser.next();
        if (type == 1) goto L14;
        if (type == 3) goto L14;
        if (_parser.getEventType() != 2) goto L3;
        String _tagName = _parser.getName();
        if (_tagName.equals("flag") == true) goto L11;
        XmlParser.skip(_parser);
        goto L3
    L11:
        String _raw = XmlParser.readText(_parser);
        _instance.getFlag().add(_raw);
    L14:
        if (type != 3) goto L17;
        return _instance;
    L17:
        throw new DatatypeConfigurationException("Flags is not closed");
    }
}
