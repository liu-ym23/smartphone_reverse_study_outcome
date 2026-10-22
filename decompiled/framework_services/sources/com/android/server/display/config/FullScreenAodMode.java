package com.android.server.display.config;

import java.io.IOException;
import java.math.BigDecimal;
import javax.xml.datatype.DatatypeConfigurationException;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: loaded from: classes2.dex */
public class FullScreenAodMode {
    private BigDecimal alphaBrightLuxThreshold;
    private NonNegativeFloatToFloatMap grayToAlphaMap;
    private NitsMap luxToBrightnessNitsMap;

    public FullScreenAodMode() {
    }

    public NitsMap getLuxToBrightnessNitsMap() {
        return this.luxToBrightnessNitsMap;
    }

    boolean hasLuxToBrightnessNitsMap() {
        if (this.luxToBrightnessNitsMap != null) goto L6;
        return false;
    L6:
        return true;
    }

    public void setLuxToBrightnessNitsMap(NitsMap luxToBrightnessNitsMap) {
        this.luxToBrightnessNitsMap = luxToBrightnessNitsMap;
    }

    public NonNegativeFloatToFloatMap getGrayToAlphaMap() {
        return this.grayToAlphaMap;
    }

    boolean hasGrayToAlphaMap() {
        if (this.grayToAlphaMap != null) goto L6;
        return false;
    L6:
        return true;
    }

    public void setGrayToAlphaMap(NonNegativeFloatToFloatMap grayToAlphaMap) {
        this.grayToAlphaMap = grayToAlphaMap;
    }

    public BigDecimal getAlphaBrightLuxThreshold() {
        return this.alphaBrightLuxThreshold;
    }

    boolean hasAlphaBrightLuxThreshold() {
        if (this.alphaBrightLuxThreshold != null) goto L6;
        return false;
    L6:
        return true;
    }

    public void setAlphaBrightLuxThreshold(BigDecimal alphaBrightLuxThreshold) {
        this.alphaBrightLuxThreshold = alphaBrightLuxThreshold;
    }

    static FullScreenAodMode read(XmlPullParser _parser) throws XmlPullParserException, IOException, DatatypeConfigurationException {
        FullScreenAodMode _instance = new FullScreenAodMode();
        _parser.getDepth();
    L3:
        int type = _parser.next();
        if (type == 1) goto L20;
        if (type == 3) goto L20;
        if (_parser.getEventType() != 2) goto L3;
        String _tagName = _parser.getName();
        if (_tagName.equals("luxToBrightnessNitsMap") == true) goto L11;
        if (_tagName.equals("grayToAlphaMap") == true) goto L14;
        if (_tagName.equals("alphaBrightLuxThreshold") == true) goto L17;
        XmlParser.skip(_parser);
        goto L3
    L17:
        String _raw = XmlParser.readText(_parser);
        BigDecimal _value = new BigDecimal(_raw);
        _instance.setAlphaBrightLuxThreshold(_value);
        goto L3
    L14:
        NonNegativeFloatToFloatMap _value2 = NonNegativeFloatToFloatMap.read(_parser);
        _instance.setGrayToAlphaMap(_value2);
        goto L3
    L11:
        NitsMap _value3 = NitsMap.read(_parser);
        _instance.setLuxToBrightnessNitsMap(_value3);
    L20:
        if (type != 3) goto L23;
        return _instance;
    L23:
        throw new DatatypeConfigurationException("FullScreenAodMode is not closed");
    }
}
