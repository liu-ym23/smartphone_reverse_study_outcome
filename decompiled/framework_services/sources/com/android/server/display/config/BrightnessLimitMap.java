package com.android.server.display.config;

import com.android.server.voiceinteraction.DatabaseHelper;
import java.io.IOException;
import javax.xml.datatype.DatatypeConfigurationException;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: loaded from: classes2.dex */
public class BrightnessLimitMap {
    private NonNegativeFloatToFloatMap map;
    private PredefinedBrightnessLimitNames type;

    public BrightnessLimitMap() {
    }

    public final PredefinedBrightnessLimitNames getType() {
        return this.type;
    }

    boolean hasType() {
        if (this.type != null) goto L6;
        return false;
    L6:
        return true;
    }

    public final void setType(PredefinedBrightnessLimitNames type) {
        this.type = type;
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

    static BrightnessLimitMap read(XmlPullParser _parser) throws XmlPullParserException, IOException, DatatypeConfigurationException {
        BrightnessLimitMap _instance = new BrightnessLimitMap();
        _parser.getDepth();
    L3:
        int type = _parser.next();
        if (type == 1) goto L17;
        if (type == 3) goto L17;
        if (_parser.getEventType() != 2) goto L3;
        String _tagName = _parser.getName();
        if (_tagName.equals(DatabaseHelper.SoundModelContract.KEY_TYPE) == true) goto L11;
        if (_tagName.equals("map") == true) goto L14;
        XmlParser.skip(_parser);
        goto L3
    L14:
        NonNegativeFloatToFloatMap _value = NonNegativeFloatToFloatMap.read(_parser);
        _instance.setMap(_value);
        goto L3
    L11:
        String _raw = XmlParser.readText(_parser);
        PredefinedBrightnessLimitNames _value2 = PredefinedBrightnessLimitNames.fromString(_raw);
        _instance.setType(_value2);
    L17:
        if (type != 3) goto L20;
        return _instance;
    L20:
        throw new DatatypeConfigurationException("BrightnessLimitMap is not closed");
    }
}
