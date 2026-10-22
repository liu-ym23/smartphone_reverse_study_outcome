package com.android.server.display.config;

import java.io.IOException;
import javax.xml.datatype.DatatypeConfigurationException;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: loaded from: classes2.dex */
public class RefreshRateZone {
    private String id;
    private RefreshRateRange refreshRateRange;

    public RefreshRateZone() {
    }

    public final RefreshRateRange getRefreshRateRange() {
        return this.refreshRateRange;
    }

    boolean hasRefreshRateRange() {
        if (this.refreshRateRange != null) goto L6;
        return false;
    L6:
        return true;
    }

    public final void setRefreshRateRange(RefreshRateRange refreshRateRange) {
        this.refreshRateRange = refreshRateRange;
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

    static RefreshRateZone read(XmlPullParser _parser) throws XmlPullParserException, IOException, DatatypeConfigurationException {
        RefreshRateZone _instance = new RefreshRateZone();
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
        if (_tagName.equals("refreshRateRange") == true) goto L14;
        XmlParser.skip(_parser);
        goto L6
    L14:
        RefreshRateRange _value = RefreshRateRange.read(_parser);
        _instance.setRefreshRateRange(_value);
    L17:
        if (type != 3) goto L20;
        return _instance;
    L20:
        throw new DatatypeConfigurationException("RefreshRateZone is not closed");
    }
}
