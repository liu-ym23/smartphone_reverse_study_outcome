package com.android.server.display.config;

import java.io.IOException;
import java.math.BigDecimal;
import javax.xml.datatype.DatatypeConfigurationException;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: loaded from: classes2.dex */
public class BrightnessPoint {
    private BigDecimal backlight;
    private BigDecimal brightness;
    private BigDecimal nits;

    public BrightnessPoint() {
    }

    public final BigDecimal getNits() {
        return this.nits;
    }

    boolean hasNits() {
        if (this.nits != null) goto L6;
        return false;
    L6:
        return true;
    }

    public final void setNits(BigDecimal nits) {
        this.nits = nits;
    }

    public final BigDecimal getBacklight() {
        return this.backlight;
    }

    boolean hasBacklight() {
        if (this.backlight != null) goto L6;
        return false;
    L6:
        return true;
    }

    public final void setBacklight(BigDecimal backlight) {
        this.backlight = backlight;
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

    static BrightnessPoint read(XmlPullParser _parser) throws XmlPullParserException, IOException, DatatypeConfigurationException {
        BrightnessPoint _instance = new BrightnessPoint();
        _parser.getDepth();
    L3:
        int type = _parser.next();
        if (type == 1) goto L20;
        if (type == 3) goto L20;
        if (_parser.getEventType() != 2) goto L3;
        String _tagName = _parser.getName();
        if (_tagName.equals("nits") == true) goto L11;
        if (_tagName.equals("backlight") == true) goto L14;
        if (_tagName.equals("brightness") == true) goto L17;
        XmlParser.skip(_parser);
        goto L3
    L17:
        String _raw = XmlParser.readText(_parser);
        BigDecimal _value = new BigDecimal(_raw);
        _instance.setBrightness(_value);
        goto L3
    L14:
        String _raw2 = XmlParser.readText(_parser);
        BigDecimal _value2 = new BigDecimal(_raw2);
        _instance.setBacklight(_value2);
        goto L3
    L11:
        String _raw3 = XmlParser.readText(_parser);
        BigDecimal _value3 = new BigDecimal(_raw3);
        _instance.setNits(_value3);
    L20:
        if (type != 3) goto L23;
        return _instance;
    L23:
        throw new DatatypeConfigurationException("BrightnessPoint is not closed");
    }
}
