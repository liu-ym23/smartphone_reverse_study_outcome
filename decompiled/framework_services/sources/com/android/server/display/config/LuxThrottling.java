package com.android.server.display.config;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.xml.datatype.DatatypeConfigurationException;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: loaded from: classes2.dex */
public class LuxThrottling {
    private List<BrightnessLimitMap> brightnessLimitMap;

    public LuxThrottling() {
    }

    public final List<BrightnessLimitMap> getBrightnessLimitMap() {
        if (this.brightnessLimitMap != null) goto L6;
        this.brightnessLimitMap = new ArrayList();
    L6:
        return this.brightnessLimitMap;
    }

    static LuxThrottling read(XmlPullParser _parser) throws XmlPullParserException, IOException, DatatypeConfigurationException {
        LuxThrottling _instance = new LuxThrottling();
        _parser.getDepth();
    L3:
        int type = _parser.next();
        if (type == 1) goto L14;
        if (type == 3) goto L14;
        if (_parser.getEventType() != 2) goto L3;
        String _tagName = _parser.getName();
        if (_tagName.equals("brightnessLimitMap") == true) goto L11;
        XmlParser.skip(_parser);
        goto L3
    L11:
        BrightnessLimitMap _value = BrightnessLimitMap.read(_parser);
        _instance.getBrightnessLimitMap().add(_value);
    L14:
        if (type != 3) goto L17;
        return _instance;
    L17:
        throw new DatatypeConfigurationException("LuxThrottling is not closed");
    }
}
