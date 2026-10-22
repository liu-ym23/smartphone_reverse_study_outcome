package com.android.server.display.config;

import java.io.IOException;
import java.math.BigDecimal;
import javax.xml.datatype.DatatypeConfigurationException;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: loaded from: classes2.dex */
public class BrightnessThresholds {
    private ThresholdPoints brightnessThresholdPoints;
    private BigDecimal minimum;

    public BrightnessThresholds() {
    }

    public final BigDecimal getMinimum() {
        return this.minimum;
    }

    boolean hasMinimum() {
        if (this.minimum != null) goto L6;
        return false;
    L6:
        return true;
    }

    public final void setMinimum(BigDecimal minimum) {
        this.minimum = minimum;
    }

    public final ThresholdPoints getBrightnessThresholdPoints() {
        return this.brightnessThresholdPoints;
    }

    boolean hasBrightnessThresholdPoints() {
        if (this.brightnessThresholdPoints != null) goto L6;
        return false;
    L6:
        return true;
    }

    public final void setBrightnessThresholdPoints(ThresholdPoints brightnessThresholdPoints) {
        this.brightnessThresholdPoints = brightnessThresholdPoints;
    }

    static BrightnessThresholds read(XmlPullParser _parser) throws XmlPullParserException, IOException, DatatypeConfigurationException {
        BrightnessThresholds _instance = new BrightnessThresholds();
        _parser.getDepth();
    L3:
        int type = _parser.next();
        if (type == 1) goto L17;
        if (type == 3) goto L17;
        if (_parser.getEventType() != 2) goto L3;
        String _tagName = _parser.getName();
        if (_tagName.equals("minimum") == true) goto L11;
        if (_tagName.equals("brightnessThresholdPoints") == true) goto L14;
        XmlParser.skip(_parser);
        goto L3
    L14:
        ThresholdPoints _value = ThresholdPoints.read(_parser);
        _instance.setBrightnessThresholdPoints(_value);
        goto L3
    L11:
        String _raw = XmlParser.readText(_parser);
        BigDecimal _value2 = new BigDecimal(_raw);
        _instance.setMinimum(_value2);
    L17:
        if (type != 3) goto L20;
        return _instance;
    L20:
        throw new DatatypeConfigurationException("BrightnessThresholds is not closed");
    }
}
