package com.android.server.display.config;

import java.io.IOException;
import java.math.BigDecimal;
import java.math.BigInteger;
import javax.xml.datatype.DatatypeConfigurationException;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: loaded from: classes2.dex */
public class DisplayBrightnessPoint {
    private BigInteger lux;
    private BigDecimal nits;

    public DisplayBrightnessPoint() {
    }

    public final BigInteger getLux() {
        return this.lux;
    }

    boolean hasLux() {
        if (this.lux != null) goto L6;
        return false;
    L6:
        return true;
    }

    public final void setLux(BigInteger lux) {
        this.lux = lux;
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

    static DisplayBrightnessPoint read(XmlPullParser _parser) throws XmlPullParserException, IOException, DatatypeConfigurationException {
        DisplayBrightnessPoint _instance = new DisplayBrightnessPoint();
        _parser.getDepth();
    L3:
        int type = _parser.next();
        if (type == 1) goto L17;
        if (type == 3) goto L17;
        if (_parser.getEventType() != 2) goto L3;
        String _tagName = _parser.getName();
        if (_tagName.equals("lux") == true) goto L11;
        if (_tagName.equals("nits") == true) goto L14;
        XmlParser.skip(_parser);
        goto L3
    L14:
        String _raw = XmlParser.readText(_parser);
        BigDecimal _value = new BigDecimal(_raw);
        _instance.setNits(_value);
        goto L3
    L11:
        String _raw2 = XmlParser.readText(_parser);
        BigInteger _value2 = new BigInteger(_raw2);
        _instance.setLux(_value2);
    L17:
        if (type != 3) goto L20;
        return _instance;
    L20:
        throw new DatatypeConfigurationException("DisplayBrightnessPoint is not closed");
    }
}
