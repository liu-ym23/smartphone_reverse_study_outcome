package com.android.server.display.config;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.xml.datatype.DatatypeConfigurationException;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: loaded from: classes2.dex */
public class ComprehensiveBrightnessMap {
    private List<BrightnessPoint> brightnessPoint;

    public ComprehensiveBrightnessMap() {
    }

    public final List<BrightnessPoint> getBrightnessPoint() {
        if (this.brightnessPoint != null) goto L6;
        this.brightnessPoint = new ArrayList();
    L6:
        return this.brightnessPoint;
    }

    static ComprehensiveBrightnessMap read(XmlPullParser _parser) throws XmlPullParserException, IOException, DatatypeConfigurationException {
        ComprehensiveBrightnessMap _instance = new ComprehensiveBrightnessMap();
        _parser.getDepth();
    L3:
        int type = _parser.next();
        if (type == 1) goto L14;
        if (type == 3) goto L14;
        if (_parser.getEventType() != 2) goto L3;
        String _tagName = _parser.getName();
        if (_tagName.equals("brightnessPoint") == true) goto L11;
        XmlParser.skip(_parser);
        goto L3
    L11:
        BrightnessPoint _value = BrightnessPoint.read(_parser);
        _instance.getBrightnessPoint().add(_value);
    L14:
        if (type != 3) goto L17;
        return _instance;
    L17:
        throw new DatatypeConfigurationException("ComprehensiveBrightnessMap is not closed");
    }
}
