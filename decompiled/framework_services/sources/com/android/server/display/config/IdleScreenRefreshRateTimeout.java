package com.android.server.display.config;

import java.io.IOException;
import javax.xml.datatype.DatatypeConfigurationException;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: loaded from: classes2.dex */
public class IdleScreenRefreshRateTimeout {
    private IdleScreenRefreshRateTimeoutLuxThresholds luxThresholds;

    public IdleScreenRefreshRateTimeout() {
    }

    public final IdleScreenRefreshRateTimeoutLuxThresholds getLuxThresholds() {
        return this.luxThresholds;
    }

    boolean hasLuxThresholds() {
        if (this.luxThresholds != null) goto L6;
        return false;
    L6:
        return true;
    }

    public final void setLuxThresholds(IdleScreenRefreshRateTimeoutLuxThresholds luxThresholds) {
        this.luxThresholds = luxThresholds;
    }

    static IdleScreenRefreshRateTimeout read(XmlPullParser _parser) throws XmlPullParserException, IOException, DatatypeConfigurationException {
        IdleScreenRefreshRateTimeout _instance = new IdleScreenRefreshRateTimeout();
        _parser.getDepth();
    L3:
        int type = _parser.next();
        if (type == 1) goto L14;
        if (type == 3) goto L14;
        if (_parser.getEventType() != 2) goto L3;
        String _tagName = _parser.getName();
        if (_tagName.equals("luxThresholds") == true) goto L11;
        XmlParser.skip(_parser);
        goto L3
    L11:
        IdleScreenRefreshRateTimeoutLuxThresholds _value = IdleScreenRefreshRateTimeoutLuxThresholds.read(_parser);
        _instance.setLuxThresholds(_value);
    L14:
        if (type != 3) goto L17;
        return _instance;
    L17:
        throw new DatatypeConfigurationException("IdleScreenRefreshRateTimeout is not closed");
    }
}
