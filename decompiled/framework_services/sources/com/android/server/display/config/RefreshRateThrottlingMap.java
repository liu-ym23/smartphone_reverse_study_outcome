package com.android.server.display.config;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.xml.datatype.DatatypeConfigurationException;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: loaded from: classes2.dex */
public class RefreshRateThrottlingMap {
    private String id;
    private List<RefreshRateThrottlingPoint> refreshRateThrottlingPoint;

    public RefreshRateThrottlingMap() {
    }

    public final List<RefreshRateThrottlingPoint> getRefreshRateThrottlingPoint() {
        if (this.refreshRateThrottlingPoint != null) goto L6;
        this.refreshRateThrottlingPoint = new ArrayList();
    L6:
        return this.refreshRateThrottlingPoint;
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

    static RefreshRateThrottlingMap read(XmlPullParser _parser) throws XmlPullParserException, IOException, DatatypeConfigurationException {
        RefreshRateThrottlingMap _instance = new RefreshRateThrottlingMap();
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
        if (_tagName.equals("refreshRateThrottlingPoint") == true) goto L14;
        XmlParser.skip(_parser);
        goto L6
    L14:
        RefreshRateThrottlingPoint _value = RefreshRateThrottlingPoint.read(_parser);
        _instance.getRefreshRateThrottlingPoint().add(_value);
    L17:
        if (type != 3) goto L20;
        return _instance;
    L20:
        throw new DatatypeConfigurationException("RefreshRateThrottlingMap is not closed");
    }
}
