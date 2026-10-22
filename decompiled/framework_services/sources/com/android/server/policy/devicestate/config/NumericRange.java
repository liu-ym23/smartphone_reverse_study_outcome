package com.android.server.policy.devicestate.config;

import java.io.IOException;
import java.math.BigDecimal;
import javax.xml.datatype.DatatypeConfigurationException;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: loaded from: classes2.dex */
public class NumericRange {
    private BigDecimal maxInclusive_optional;
    private BigDecimal max_optional;
    private BigDecimal minInclusive_optional;
    private BigDecimal min_optional;

    public NumericRange() {
    }

    public BigDecimal getMin_optional() {
        return this.min_optional;
    }

    boolean hasMin_optional() {
        if (this.min_optional != null) goto L6;
        return false;
    L6:
        return true;
    }

    public void setMin_optional(BigDecimal min_optional) {
        this.min_optional = min_optional;
    }

    public BigDecimal getMinInclusive_optional() {
        return this.minInclusive_optional;
    }

    boolean hasMinInclusive_optional() {
        if (this.minInclusive_optional != null) goto L6;
        return false;
    L6:
        return true;
    }

    public void setMinInclusive_optional(BigDecimal minInclusive_optional) {
        this.minInclusive_optional = minInclusive_optional;
    }

    public BigDecimal getMax_optional() {
        return this.max_optional;
    }

    boolean hasMax_optional() {
        if (this.max_optional != null) goto L6;
        return false;
    L6:
        return true;
    }

    public void setMax_optional(BigDecimal max_optional) {
        this.max_optional = max_optional;
    }

    public BigDecimal getMaxInclusive_optional() {
        return this.maxInclusive_optional;
    }

    boolean hasMaxInclusive_optional() {
        if (this.maxInclusive_optional != null) goto L6;
        return false;
    L6:
        return true;
    }

    public void setMaxInclusive_optional(BigDecimal maxInclusive_optional) {
        this.maxInclusive_optional = maxInclusive_optional;
    }

    static NumericRange read(XmlPullParser _parser) throws XmlPullParserException, IOException, DatatypeConfigurationException {
        NumericRange _instance = new NumericRange();
        _parser.getDepth();
    L3:
        int type = _parser.next();
        if (type == 1) goto L23;
        if (type == 3) goto L23;
        if (_parser.getEventType() != 2) goto L3;
        String _tagName = _parser.getName();
        if (_tagName.equals("min") == true) goto L11;
        if (_tagName.equals("min-inclusive") == true) goto L14;
        if (_tagName.equals("max") == true) goto L17;
        if (_tagName.equals("max-inclusive") == true) goto L20;
        XmlParser.skip(_parser);
        goto L3
    L20:
        String _raw = XmlParser.readText(_parser);
        BigDecimal _value = new BigDecimal(_raw);
        _instance.setMaxInclusive_optional(_value);
        goto L3
    L17:
        String _raw2 = XmlParser.readText(_parser);
        BigDecimal _value2 = new BigDecimal(_raw2);
        _instance.setMax_optional(_value2);
        goto L3
    L14:
        String _raw3 = XmlParser.readText(_parser);
        BigDecimal _value3 = new BigDecimal(_raw3);
        _instance.setMinInclusive_optional(_value3);
        goto L3
    L11:
        String _raw4 = XmlParser.readText(_parser);
        BigDecimal _value4 = new BigDecimal(_raw4);
        _instance.setMin_optional(_value4);
    L23:
        if (type != 3) goto L26;
        return _instance;
    L26:
        throw new DatatypeConfigurationException("NumericRange is not closed");
    }
}
