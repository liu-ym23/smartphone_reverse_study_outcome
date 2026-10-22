package com.android.server.display.config;

import java.io.IOException;
import javax.xml.datatype.DatatypeConfigurationException;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: loaded from: classes2.dex */
public class LuxToBrightnessMapping {
    private NonNegativeFloatToFloatMap map;
    private AutoBrightnessModeName mode;
    private AutoBrightnessSettingName setting;

    public LuxToBrightnessMapping() {
    }

    public final NonNegativeFloatToFloatMap getMap() {
        return this.map;
    }

    boolean hasMap() {
        if (this.map != null) goto L6;
        return false;
    L6:
        return true;
    }

    public final void setMap(NonNegativeFloatToFloatMap map) {
        this.map = map;
    }

    public AutoBrightnessModeName getMode() {
        return this.mode;
    }

    boolean hasMode() {
        if (this.mode != null) goto L6;
        return false;
    L6:
        return true;
    }

    public void setMode(AutoBrightnessModeName mode) {
        this.mode = mode;
    }

    public AutoBrightnessSettingName getSetting() {
        return this.setting;
    }

    boolean hasSetting() {
        if (this.setting != null) goto L6;
        return false;
    L6:
        return true;
    }

    public void setSetting(AutoBrightnessSettingName setting) {
        this.setting = setting;
    }

    static LuxToBrightnessMapping read(XmlPullParser _parser) throws XmlPullParserException, IOException, DatatypeConfigurationException {
        LuxToBrightnessMapping _instance = new LuxToBrightnessMapping();
        _parser.getDepth();
    L3:
        int type = _parser.next();
        if (type == 1) goto L20;
        if (type == 3) goto L20;
        if (_parser.getEventType() != 2) goto L3;
        String _tagName = _parser.getName();
        if (_tagName.equals("map") == true) goto L11;
        if (_tagName.equals("mode") == true) goto L14;
        if (_tagName.equals("setting") == true) goto L17;
        XmlParser.skip(_parser);
        goto L3
    L17:
        String _raw = XmlParser.readText(_parser);
        AutoBrightnessSettingName _value = AutoBrightnessSettingName.fromString(_raw);
        _instance.setSetting(_value);
        goto L3
    L14:
        String _raw2 = XmlParser.readText(_parser);
        AutoBrightnessModeName _value2 = AutoBrightnessModeName.fromString(_raw2);
        _instance.setMode(_value2);
        goto L3
    L11:
        NonNegativeFloatToFloatMap _value3 = NonNegativeFloatToFloatMap.read(_parser);
        _instance.setMap(_value3);
    L20:
        if (type != 3) goto L23;
        return _instance;
    L23:
        throw new DatatypeConfigurationException("LuxToBrightnessMapping is not closed");
    }
}
