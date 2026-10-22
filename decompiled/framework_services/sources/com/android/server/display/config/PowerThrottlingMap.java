package com.android.server.display.config;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.xml.datatype.DatatypeConfigurationException;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: loaded from: classes2.dex */
public class PowerThrottlingMap {
    private String id;
    private List<PowerThrottlingPoint> powerThrottlingPoint;

    public PowerThrottlingMap() {
    }

    public final List<PowerThrottlingPoint> getPowerThrottlingPoint() {
        if (this.powerThrottlingPoint != null) goto L6;
        this.powerThrottlingPoint = new ArrayList();
    L6:
        return this.powerThrottlingPoint;
    }

    public String getId() {
        return this.id;
    }

    boolean hasId() {
        if (this.id != null) goto L6;
        return false;
    L6:
        return true;
    }

    public void setId(String id) {
        this.id = id;
    }

    static PowerThrottlingMap read(XmlPullParser _parser) throws XmlPullParserException, IOException, DatatypeConfigurationException {
        PowerThrottlingMap _instance = new PowerThrottlingMap();
        String _raw = _parser.getAttributeValue(null, "id");
        if (_raw == null) goto L5;
        _instance.setId(_raw);
    L5:
        _parser.getDepth();
    L6:
        int type = _parser.next();
        if (type == 1) goto L17;
        if (type == 3) goto L17;
        if (_parser.getEventType() != 2) goto L6;
        String _tagName = _parser.getName();
        if (_tagName.equals("powerThrottlingPoint") == true) goto L14;
        XmlParser.skip(_parser);
        goto L6
    L14:
        PowerThrottlingPoint _value = PowerThrottlingPoint.read(_parser);
        _instance.getPowerThrottlingPoint().add(_value);
    L17:
        if (type != 3) goto L20;
        return _instance;
    L20:
        throw new DatatypeConfigurationException("PowerThrottlingMap is not closed");
    }
}
