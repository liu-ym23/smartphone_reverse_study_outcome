package com.android.server.display.config;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.xml.datatype.DatatypeConfigurationException;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: loaded from: classes2.dex */
public class ThermalThrottling {
    private List<BrightnessThrottlingMap> brightnessThrottlingMap;
    private List<RefreshRateThrottlingMap> refreshRateThrottlingMap;

    public ThermalThrottling() {
    }

    public final List<BrightnessThrottlingMap> getBrightnessThrottlingMap() {
        if (this.brightnessThrottlingMap != null) goto L6;
        this.brightnessThrottlingMap = new ArrayList();
    L6:
        return this.brightnessThrottlingMap;
    }

    public final List<RefreshRateThrottlingMap> getRefreshRateThrottlingMap() {
        if (this.refreshRateThrottlingMap != null) goto L6;
        this.refreshRateThrottlingMap = new ArrayList();
    L6:
        return this.refreshRateThrottlingMap;
    }

    static ThermalThrottling read(XmlPullParser _parser) throws XmlPullParserException, IOException, DatatypeConfigurationException {
        ThermalThrottling _instance = new ThermalThrottling();
        _parser.getDepth();
    L3:
        int type = _parser.next();
        if (type == 1) goto L17;
        if (type == 3) goto L17;
        if (_parser.getEventType() != 2) goto L3;
        String _tagName = _parser.getName();
        if (_tagName.equals("brightnessThrottlingMap") == true) goto L11;
        if (_tagName.equals("refreshRateThrottlingMap") == true) goto L14;
        XmlParser.skip(_parser);
        goto L3
    L14:
        RefreshRateThrottlingMap _value = RefreshRateThrottlingMap.read(_parser);
        _instance.getRefreshRateThrottlingMap().add(_value);
        goto L3
    L11:
        BrightnessThrottlingMap _value2 = BrightnessThrottlingMap.read(_parser);
        _instance.getBrightnessThrottlingMap().add(_value2);
    L17:
        if (type != 3) goto L20;
        return _instance;
    L20:
        throw new DatatypeConfigurationException("ThermalThrottling is not closed");
    }
}
