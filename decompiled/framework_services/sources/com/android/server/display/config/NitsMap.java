package com.android.server.display.config;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.xml.datatype.DatatypeConfigurationException;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: loaded from: classes2.dex */
public class NitsMap {
    private String interpolation;
    private List<Point> point;

    public NitsMap() {
    }

    public final List<Point> getPoint() {
        if (this.point != null) goto L6;
        this.point = new ArrayList();
    L6:
        return this.point;
    }

    public String getInterpolation() {
        return this.interpolation;
    }

    boolean hasInterpolation() {
        if (this.interpolation != null) goto L6;
        return false;
    L6:
        return true;
    }

    public void setInterpolation(String interpolation) {
        this.interpolation = interpolation;
    }

    static NitsMap read(XmlPullParser _parser) throws XmlPullParserException, IOException, DatatypeConfigurationException {
        NitsMap _instance = new NitsMap();
        String _raw = _parser.getAttributeValue(null, "interpolation");
        if (_raw == null) goto L5;
        _instance.setInterpolation(_raw);
    L5:
        _parser.getDepth();
    L6:
        int type = _parser.next();
        if (type == 1) goto L17;
        if (type == 3) goto L17;
        if (_parser.getEventType() != 2) goto L6;
        String _tagName = _parser.getName();
        if (_tagName.equals("point") == true) goto L14;
        XmlParser.skip(_parser);
        goto L6
    L14:
        Point _value = Point.read(_parser);
        _instance.getPoint().add(_value);
    L17:
        if (type != 3) goto L20;
        return _instance;
    L20:
        throw new DatatypeConfigurationException("NitsMap is not closed");
    }
}
