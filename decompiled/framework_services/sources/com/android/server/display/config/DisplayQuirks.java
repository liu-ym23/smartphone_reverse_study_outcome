package com.android.server.display.config;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.xml.datatype.DatatypeConfigurationException;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: loaded from: classes2.dex */
public class DisplayQuirks {
    private List<String> quirk;

    public DisplayQuirks() {
    }

    public List<String> getQuirk() {
        if (this.quirk != null) goto L6;
        this.quirk = new ArrayList();
    L6:
        return this.quirk;
    }

    static DisplayQuirks read(XmlPullParser _parser) throws XmlPullParserException, IOException, DatatypeConfigurationException {
        DisplayQuirks _instance = new DisplayQuirks();
        _parser.getDepth();
    L3:
        int type = _parser.next();
        if (type == 1) goto L14;
        if (type == 3) goto L14;
        if (_parser.getEventType() != 2) goto L3;
        String _tagName = _parser.getName();
        if (_tagName.equals("quirk") == true) goto L11;
        XmlParser.skip(_parser);
        goto L3
    L11:
        String _raw = XmlParser.readText(_parser);
        _instance.getQuirk().add(_raw);
    L14:
        if (type != 3) goto L17;
        return _instance;
    L17:
        throw new DatatypeConfigurationException("DisplayQuirks is not closed");
    }
}
