package com.android.server.display.config;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.xml.datatype.DatatypeConfigurationException;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: loaded from: classes2.dex */
public class ThresholdPoints {
    private List<ThresholdPoint> brightnessThresholdPoint;

    public ThresholdPoints() {
    }

    public final List<ThresholdPoint> getBrightnessThresholdPoint() {
        if (this.brightnessThresholdPoint != null) goto L6;
        this.brightnessThresholdPoint = new ArrayList();
    L6:
        return this.brightnessThresholdPoint;
    }

    static ThresholdPoints read(XmlPullParser _parser) throws XmlPullParserException, IOException, DatatypeConfigurationException {
        ThresholdPoints _instance = new ThresholdPoints();
        _parser.getDepth();
    L3:
        int type = _parser.next();
        if (type == 1) goto L14;
        if (type == 3) goto L14;
        if (_parser.getEventType() != 2) goto L3;
        String _tagName = _parser.getName();
        if (_tagName.equals("brightnessThresholdPoint") == true) goto L11;
        XmlParser.skip(_parser);
        goto L3
    L11:
        ThresholdPoint _value = ThresholdPoint.read(_parser);
        _instance.getBrightnessThresholdPoint().add(_value);
    L14:
        if (type != 3) goto L17;
        return _instance;
    L17:
        throw new DatatypeConfigurationException("ThresholdPoints is not closed");
    }
}
