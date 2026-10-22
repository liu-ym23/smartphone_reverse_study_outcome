package com.android.server.display.config;

import java.io.IOException;
import java.math.BigDecimal;
import javax.xml.datatype.DatatypeConfigurationException;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: loaded from: classes2.dex */
public class NonNegativeFloatToFloatPoint {
    private BigDecimal first;
    private BigDecimal second;

    public NonNegativeFloatToFloatPoint() {
    }

    public final BigDecimal getFirst() {
        return this.first;
    }

    boolean hasFirst() {
        if (this.first != null) goto L6;
        return false;
    L6:
        return true;
    }

    public final void setFirst(BigDecimal first) {
        this.first = first;
    }

    public final BigDecimal getSecond() {
        return this.second;
    }

    boolean hasSecond() {
        if (this.second != null) goto L6;
        return false;
    L6:
        return true;
    }

    public final void setSecond(BigDecimal second) {
        this.second = second;
    }

    static NonNegativeFloatToFloatPoint read(XmlPullParser _parser) throws XmlPullParserException, IOException, DatatypeConfigurationException {
        NonNegativeFloatToFloatPoint _instance = new NonNegativeFloatToFloatPoint();
        _parser.getDepth();
    L3:
        int type = _parser.next();
        if (type == 1) goto L17;
        if (type == 3) goto L17;
        if (_parser.getEventType() != 2) goto L3;
        String _tagName = _parser.getName();
        if (_tagName.equals("first") == true) goto L11;
        if (_tagName.equals("second") == true) goto L14;
        XmlParser.skip(_parser);
        goto L3
    L14:
        String _raw = XmlParser.readText(_parser);
        BigDecimal _value = new BigDecimal(_raw);
        _instance.setSecond(_value);
        goto L3
    L11:
        String _raw2 = XmlParser.readText(_parser);
        BigDecimal _value2 = new BigDecimal(_raw2);
        _instance.setFirst(_value2);
    L17:
        if (type != 3) goto L20;
        return _instance;
    L20:
        throw new DatatypeConfigurationException("NonNegativeFloatToFloatPoint is not closed");
    }
}
