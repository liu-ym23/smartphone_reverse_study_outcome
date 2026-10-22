package com.android.server.display.config;

import java.io.IOException;
import java.math.BigDecimal;
import javax.xml.datatype.DatatypeConfigurationException;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: loaded from: classes2.dex */
public class ThresholdPoint {
    private BigDecimal percentage;
    private BigDecimal threshold;

    public ThresholdPoint() {
    }

    public final BigDecimal getThreshold() {
        return this.threshold;
    }

    boolean hasThreshold() {
        if (this.threshold != null) goto L6;
        return false;
    L6:
        return true;
    }

    public final void setThreshold(BigDecimal threshold) {
        this.threshold = threshold;
    }

    public final BigDecimal getPercentage() {
        return this.percentage;
    }

    boolean hasPercentage() {
        if (this.percentage != null) goto L6;
        return false;
    L6:
        return true;
    }

    public final void setPercentage(BigDecimal percentage) {
        this.percentage = percentage;
    }

    static ThresholdPoint read(XmlPullParser _parser) throws XmlPullParserException, IOException, DatatypeConfigurationException {
        ThresholdPoint _instance = new ThresholdPoint();
        _parser.getDepth();
    L3:
        int type = _parser.next();
        if (type == 1) goto L17;
        if (type == 3) goto L17;
        if (_parser.getEventType() != 2) goto L3;
        String _tagName = _parser.getName();
        if (_tagName.equals("threshold") == true) goto L11;
        if (_tagName.equals("percentage") == true) goto L14;
        XmlParser.skip(_parser);
        goto L3
    L14:
        String _raw = XmlParser.readText(_parser);
        BigDecimal _value = new BigDecimal(_raw);
        _instance.setPercentage(_value);
        goto L3
    L11:
        String _raw2 = XmlParser.readText(_parser);
        BigDecimal _value2 = new BigDecimal(_raw2);
        _instance.setThreshold(_value2);
    L17:
        if (type != 3) goto L20;
        return _instance;
    L20:
        throw new DatatypeConfigurationException("ThresholdPoint is not closed");
    }
}
