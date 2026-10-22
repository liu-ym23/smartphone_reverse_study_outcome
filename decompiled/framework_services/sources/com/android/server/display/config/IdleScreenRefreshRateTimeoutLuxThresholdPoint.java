package com.android.server.display.config;

import java.io.IOException;
import java.math.BigInteger;
import javax.xml.datatype.DatatypeConfigurationException;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: loaded from: classes2.dex */
public class IdleScreenRefreshRateTimeoutLuxThresholdPoint {
    private BigInteger lux;
    private BigInteger timeout;

    public IdleScreenRefreshRateTimeoutLuxThresholdPoint() {
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

    public final BigInteger getTimeout() {
        return this.timeout;
    }

    boolean hasTimeout() {
        if (this.timeout != null) goto L6;
        return false;
    L6:
        return true;
    }

    public final void setTimeout(BigInteger timeout) {
        this.timeout = timeout;
    }

    static IdleScreenRefreshRateTimeoutLuxThresholdPoint read(XmlPullParser _parser) throws XmlPullParserException, IOException, DatatypeConfigurationException {
        IdleScreenRefreshRateTimeoutLuxThresholdPoint _instance = new IdleScreenRefreshRateTimeoutLuxThresholdPoint();
        _parser.getDepth();
    L3:
        int type = _parser.next();
        if (type == 1) goto L17;
        if (type == 3) goto L17;
        if (_parser.getEventType() != 2) goto L3;
        String _tagName = _parser.getName();
        if (_tagName.equals("lux") == true) goto L11;
        if (_tagName.equals("timeout") == true) goto L14;
        XmlParser.skip(_parser);
        goto L3
    L14:
        String _raw = XmlParser.readText(_parser);
        BigInteger _value = new BigInteger(_raw);
        _instance.setTimeout(_value);
        goto L3
    L11:
        String _raw2 = XmlParser.readText(_parser);
        BigInteger _value2 = new BigInteger(_raw2);
        _instance.setLux(_value2);
    L17:
        if (type != 3) goto L20;
        return _instance;
    L20:
        throw new DatatypeConfigurationException("IdleScreenRefreshRateTimeoutLuxThresholdPoint is not closed");
    }
}
