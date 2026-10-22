package com.android.server.display.config;

import java.io.IOException;
import java.math.BigDecimal;
import javax.xml.datatype.DatatypeConfigurationException;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: loaded from: classes2.dex */
public class BrightnessThrottlingPoint {
    private BigDecimal brightness;
    private ThermalStatus thermalStatus;

    public BrightnessThrottlingPoint() {
    }

    public final ThermalStatus getThermalStatus() {
        return this.thermalStatus;
    }

    boolean hasThermalStatus() {
        if (this.thermalStatus != null) goto L6;
        return false;
    L6:
        return true;
    }

    public final void setThermalStatus(ThermalStatus thermalStatus) {
        this.thermalStatus = thermalStatus;
    }

    public final BigDecimal getBrightness() {
        return this.brightness;
    }

    boolean hasBrightness() {
        if (this.brightness != null) goto L6;
        return false;
    L6:
        return true;
    }

    public final void setBrightness(BigDecimal brightness) {
        this.brightness = brightness;
    }

    static BrightnessThrottlingPoint read(XmlPullParser _parser) throws XmlPullParserException, IOException, DatatypeConfigurationException {
        BrightnessThrottlingPoint _instance = new BrightnessThrottlingPoint();
        _parser.getDepth();
    L3:
        int type = _parser.next();
        if (type == 1) goto L17;
        if (type == 3) goto L17;
        if (_parser.getEventType() != 2) goto L3;
        String _tagName = _parser.getName();
        if (_tagName.equals("thermalStatus") == true) goto L11;
        if (_tagName.equals("brightness") == true) goto L14;
        XmlParser.skip(_parser);
        goto L3
    L14:
        String _raw = XmlParser.readText(_parser);
        BigDecimal _value = new BigDecimal(_raw);
        _instance.setBrightness(_value);
        goto L3
    L11:
        String _raw2 = XmlParser.readText(_parser);
        ThermalStatus _value2 = ThermalStatus.fromString(_raw2);
        _instance.setThermalStatus(_value2);
    L17:
        if (type != 3) goto L20;
        return _instance;
    L20:
        throw new DatatypeConfigurationException("BrightnessThrottlingPoint is not closed");
    }
}
