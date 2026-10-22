package com.android.server.display.config;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.xml.datatype.DatatypeConfigurationException;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: loaded from: classes2.dex */
public class NonNegativeFloatToFloatMap {
    private List<NonNegativeFloatToFloatPoint> point;

    public NonNegativeFloatToFloatMap() {
    }

    public final List<NonNegativeFloatToFloatPoint> getPoint() {
        if (this.point != null) goto L6;
        this.point = new ArrayList();
    L6:
        return this.point;
    }

    static NonNegativeFloatToFloatMap read(XmlPullParser _parser) throws XmlPullParserException, IOException, DatatypeConfigurationException {
        NonNegativeFloatToFloatMap _instance = new NonNegativeFloatToFloatMap();
        _parser.getDepth();
    L3:
        int type = _parser.next();
        if (type == 1) goto L14;
        if (type == 3) goto L14;
        if (_parser.getEventType() != 2) goto L3;
        String _tagName = _parser.getName();
        if (_tagName.equals("point") == true) goto L11;
        XmlParser.skip(_parser);
        goto L3
    L11:
        NonNegativeFloatToFloatPoint _value = NonNegativeFloatToFloatPoint.read(_parser);
        _instance.getPoint().add(_value);
    L14:
        if (type != 3) goto L17;
        return _instance;
    L17:
        throw new DatatypeConfigurationException("NonNegativeFloatToFloatMap is not closed");
    }
}
