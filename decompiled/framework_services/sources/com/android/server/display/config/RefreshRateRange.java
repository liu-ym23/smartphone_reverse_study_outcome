package com.android.server.display.config;

import java.io.IOException;
import java.math.BigInteger;
import javax.xml.datatype.DatatypeConfigurationException;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: loaded from: classes2.dex */
public class RefreshRateRange {
    private BigInteger maximum;
    private BigInteger minimum;

    public RefreshRateRange() {
    }

    public final BigInteger getMinimum() {
        return this.minimum;
    }

    boolean hasMinimum() {
        if (this.minimum != null) goto L6;
        return false;
    L6:
        return true;
    }

    public final void setMinimum(BigInteger minimum) {
        this.minimum = minimum;
    }

    public final BigInteger getMaximum() {
        return this.maximum;
    }

    boolean hasMaximum() {
        if (this.maximum != null) goto L6;
        return false;
    L6:
        return true;
    }

    public final void setMaximum(BigInteger maximum) {
        this.maximum = maximum;
    }

    static RefreshRateRange read(XmlPullParser _parser) throws XmlPullParserException, IOException, DatatypeConfigurationException {
        RefreshRateRange _instance = new RefreshRateRange();
        _parser.getDepth();
    L3:
        int type = _parser.next();
        if (type == 1) goto L17;
        if (type == 3) goto L17;
        if (_parser.getEventType() != 2) goto L3;
        String _tagName = _parser.getName();
        if (_tagName.equals("minimum") == true) goto L11;
        if (_tagName.equals("maximum") == true) goto L14;
        XmlParser.skip(_parser);
        goto L3
    L14:
        String _raw = XmlParser.readText(_parser);
        BigInteger _value = new BigInteger(_raw);
        _instance.setMaximum(_value);
        goto L3
    L11:
        String _raw2 = XmlParser.readText(_parser);
        BigInteger _value2 = new BigInteger(_raw2);
        _instance.setMinimum(_value2);
    L17:
        if (type != 3) goto L20;
        return _instance;
    L20:
        throw new DatatypeConfigurationException("RefreshRateRange is not closed");
    }
}
