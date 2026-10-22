package com.android.server.display.config;

import java.io.IOException;
import java.math.BigInteger;
import javax.xml.datatype.DatatypeConfigurationException;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: loaded from: classes2.dex */
public class HbmTiming {
    private BigInteger timeMaxSecs_all;
    private BigInteger timeMinSecs_all;
    private BigInteger timeWindowSecs_all;

    public HbmTiming() {
    }

    public final BigInteger getTimeWindowSecs_all() {
        return this.timeWindowSecs_all;
    }

    boolean hasTimeWindowSecs_all() {
        if (this.timeWindowSecs_all != null) goto L6;
        return false;
    L6:
        return true;
    }

    public final void setTimeWindowSecs_all(BigInteger timeWindowSecs_all) {
        this.timeWindowSecs_all = timeWindowSecs_all;
    }

    public final BigInteger getTimeMaxSecs_all() {
        return this.timeMaxSecs_all;
    }

    boolean hasTimeMaxSecs_all() {
        if (this.timeMaxSecs_all != null) goto L6;
        return false;
    L6:
        return true;
    }

    public final void setTimeMaxSecs_all(BigInteger timeMaxSecs_all) {
        this.timeMaxSecs_all = timeMaxSecs_all;
    }

    public final BigInteger getTimeMinSecs_all() {
        return this.timeMinSecs_all;
    }

    boolean hasTimeMinSecs_all() {
        if (this.timeMinSecs_all != null) goto L6;
        return false;
    L6:
        return true;
    }

    public final void setTimeMinSecs_all(BigInteger timeMinSecs_all) {
        this.timeMinSecs_all = timeMinSecs_all;
    }

    static HbmTiming read(XmlPullParser _parser) throws XmlPullParserException, IOException, DatatypeConfigurationException {
        HbmTiming _instance = new HbmTiming();
        _parser.getDepth();
    L3:
        int type = _parser.next();
        if (type == 1) goto L20;
        if (type == 3) goto L20;
        if (_parser.getEventType() != 2) goto L3;
        String _tagName = _parser.getName();
        if (_tagName.equals("timeWindowSecs") == true) goto L11;
        if (_tagName.equals("timeMaxSecs") == true) goto L14;
        if (_tagName.equals("timeMinSecs") == true) goto L17;
        XmlParser.skip(_parser);
        goto L3
    L17:
        String _raw = XmlParser.readText(_parser);
        BigInteger _value = new BigInteger(_raw);
        _instance.setTimeMinSecs_all(_value);
        goto L3
    L14:
        String _raw2 = XmlParser.readText(_parser);
        BigInteger _value2 = new BigInteger(_raw2);
        _instance.setTimeMaxSecs_all(_value2);
        goto L3
    L11:
        String _raw3 = XmlParser.readText(_parser);
        BigInteger _value3 = new BigInteger(_raw3);
        _instance.setTimeWindowSecs_all(_value3);
    L20:
        if (type != 3) goto L23;
        return _instance;
    L23:
        throw new DatatypeConfigurationException("HbmTiming is not closed");
    }
}
