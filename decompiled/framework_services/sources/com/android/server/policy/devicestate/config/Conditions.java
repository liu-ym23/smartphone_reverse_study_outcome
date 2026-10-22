package com.android.server.policy.devicestate.config;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.xml.datatype.DatatypeConfigurationException;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: loaded from: classes2.dex */
public class Conditions {
    private LidSwitchCondition lidSwitch;
    private List<SensorCondition> sensor;

    public Conditions() {
    }

    public LidSwitchCondition getLidSwitch() {
        return this.lidSwitch;
    }

    boolean hasLidSwitch() {
        if (this.lidSwitch != null) goto L6;
        return false;
    L6:
        return true;
    }

    public void setLidSwitch(LidSwitchCondition lidSwitch) {
        this.lidSwitch = lidSwitch;
    }

    public List<SensorCondition> getSensor() {
        if (this.sensor != null) goto L6;
        this.sensor = new ArrayList();
    L6:
        return this.sensor;
    }

    static Conditions read(XmlPullParser _parser) throws XmlPullParserException, IOException, DatatypeConfigurationException {
        Conditions _instance = new Conditions();
        _parser.getDepth();
    L3:
        int type = _parser.next();
        if (type == 1) goto L17;
        if (type == 3) goto L17;
        if (_parser.getEventType() != 2) goto L3;
        String _tagName = _parser.getName();
        if (_tagName.equals("lid-switch") == true) goto L11;
        if (_tagName.equals("sensor") == true) goto L14;
        XmlParser.skip(_parser);
        goto L3
    L14:
        SensorCondition _value = SensorCondition.read(_parser);
        _instance.getSensor().add(_value);
        goto L3
    L11:
        LidSwitchCondition _value2 = LidSwitchCondition.read(_parser);
        _instance.setLidSwitch(_value2);
    L17:
        if (type != 3) goto L20;
        return _instance;
    L20:
        throw new DatatypeConfigurationException("Conditions is not closed");
    }
}
