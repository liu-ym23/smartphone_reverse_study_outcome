package com.android.server.compat.config;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.xml.datatype.DatatypeConfigurationException;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: loaded from: classes.dex */
public class Config {
    private List<Change> compatChange;

    public Config() {
    }

    public List<Change> getCompatChange() {
        if (this.compatChange != null) goto L6;
        this.compatChange = new ArrayList();
    L6:
        return this.compatChange;
    }

    static Config read(XmlPullParser _parser) throws XmlPullParserException, IOException, DatatypeConfigurationException {
        Config _instance = new Config();
        _parser.getDepth();
    L3:
        int type = _parser.next();
        if (type == 1) goto L14;
        if (type == 3) goto L14;
        if (_parser.getEventType() != 2) goto L3;
        String _tagName = _parser.getName();
        if (_tagName.equals("compat-change") == true) goto L11;
        XmlParser.skip(_parser);
        goto L3
    L11:
        Change _value = Change.read(_parser);
        _instance.getCompatChange().add(_value);
    L14:
        if (type != 3) goto L17;
        return _instance;
    L17:
        throw new DatatypeConfigurationException("Config is not closed");
    }
}
