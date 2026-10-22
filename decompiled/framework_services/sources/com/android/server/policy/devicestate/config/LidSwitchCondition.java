package com.android.server.policy.devicestate.config;

import java.io.IOException;
import javax.xml.datatype.DatatypeConfigurationException;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: loaded from: classes2.dex */
public class LidSwitchCondition {
    private Boolean open;

    public LidSwitchCondition() {
    }

    public boolean getOpen() {
        if (this.open != null) goto L7;
        return false;
    L7:
        return this.open.booleanValue();
    }

    boolean hasOpen() {
        if (this.open != null) goto L6;
        return false;
    L6:
        return true;
    }

    public void setOpen(boolean open) {
        this.open = Boolean.valueOf(open);
    }

    static LidSwitchCondition read(XmlPullParser _parser) throws XmlPullParserException, IOException, DatatypeConfigurationException {
        LidSwitchCondition _instance = new LidSwitchCondition();
        _parser.getDepth();
    L3:
        int type = _parser.next();
        if (type == 1) goto L14;
        if (type == 3) goto L14;
        if (_parser.getEventType() != 2) goto L3;
        String _tagName = _parser.getName();
        if (_tagName.equals("open") == true) goto L11;
        XmlParser.skip(_parser);
        goto L3
    L11:
        String _raw = XmlParser.readText(_parser);
        boolean _value = Boolean.parseBoolean(_raw);
        _instance.setOpen(_value);
    L14:
        if (type != 3) goto L17;
        return _instance;
    L17:
        throw new DatatypeConfigurationException("LidSwitchCondition is not closed");
    }
}
