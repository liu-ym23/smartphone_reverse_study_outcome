package com.android.server.display.config;

import java.io.IOException;
import javax.xml.datatype.DatatypeConfigurationException;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: loaded from: classes2.dex */
public class Thresholds {
    private BrightnessThresholds brighteningThresholds;
    private BrightnessThresholds darkeningThresholds;

    public Thresholds() {
    }

    public final BrightnessThresholds getBrighteningThresholds() {
        return this.brighteningThresholds;
    }

    boolean hasBrighteningThresholds() {
        if (this.brighteningThresholds != null) goto L6;
        return false;
    L6:
        return true;
    }

    public final void setBrighteningThresholds(BrightnessThresholds brighteningThresholds) {
        this.brighteningThresholds = brighteningThresholds;
    }

    public final BrightnessThresholds getDarkeningThresholds() {
        return this.darkeningThresholds;
    }

    boolean hasDarkeningThresholds() {
        if (this.darkeningThresholds != null) goto L6;
        return false;
    L6:
        return true;
    }

    public final void setDarkeningThresholds(BrightnessThresholds darkeningThresholds) {
        this.darkeningThresholds = darkeningThresholds;
    }

    static Thresholds read(XmlPullParser _parser) throws XmlPullParserException, IOException, DatatypeConfigurationException {
        Thresholds _instance = new Thresholds();
        _parser.getDepth();
    L3:
        int type = _parser.next();
        if (type == 1) goto L17;
        if (type == 3) goto L17;
        if (_parser.getEventType() != 2) goto L3;
        String _tagName = _parser.getName();
        if (_tagName.equals("brighteningThresholds") == true) goto L11;
        if (_tagName.equals("darkeningThresholds") == true) goto L14;
        XmlParser.skip(_parser);
        goto L3
    L14:
        BrightnessThresholds _value = BrightnessThresholds.read(_parser);
        _instance.setDarkeningThresholds(_value);
        goto L3
    L11:
        BrightnessThresholds _value2 = BrightnessThresholds.read(_parser);
        _instance.setBrighteningThresholds(_value2);
    L17:
        if (type != 3) goto L20;
        return _instance;
    L20:
        throw new DatatypeConfigurationException("Thresholds is not closed");
    }
}
