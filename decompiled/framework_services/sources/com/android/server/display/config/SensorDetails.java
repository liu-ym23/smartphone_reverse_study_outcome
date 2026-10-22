package com.android.server.display.config;

import com.android.server.voiceinteraction.DatabaseHelper;
import java.io.IOException;
import javax.xml.datatype.DatatypeConfigurationException;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: loaded from: classes2.dex */
public class SensorDetails {
    private String featureFlag;
    private String name;
    private RefreshRateRange refreshRate;
    private NonNegativeFloatToFloatMap supportedModes;
    private String type;

    public SensorDetails() {
    }

    public final String getType() {
        return this.type;
    }

    boolean hasType() {
        if (this.type != null) goto L6;
        return false;
    L6:
        return true;
    }

    public final void setType(String type) {
        this.type = type;
    }

    public final String getName() {
        return this.name;
    }

    boolean hasName() {
        if (this.name != null) goto L6;
        return false;
    L6:
        return true;
    }

    public final void setName(String name) {
        this.name = name;
    }

    public final RefreshRateRange getRefreshRate() {
        return this.refreshRate;
    }

    boolean hasRefreshRate() {
        if (this.refreshRate != null) goto L6;
        return false;
    L6:
        return true;
    }

    public final void setRefreshRate(RefreshRateRange refreshRate) {
        this.refreshRate = refreshRate;
    }

    public final NonNegativeFloatToFloatMap getSupportedModes() {
        return this.supportedModes;
    }

    boolean hasSupportedModes() {
        if (this.supportedModes != null) goto L6;
        return false;
    L6:
        return true;
    }

    public final void setSupportedModes(NonNegativeFloatToFloatMap supportedModes) {
        this.supportedModes = supportedModes;
    }

    public String getFeatureFlag() {
        return this.featureFlag;
    }

    boolean hasFeatureFlag() {
        if (this.featureFlag != null) goto L6;
        return false;
    L6:
        return true;
    }

    public void setFeatureFlag(String featureFlag) {
        this.featureFlag = featureFlag;
    }

    static SensorDetails read(XmlPullParser _parser) throws XmlPullParserException, IOException, DatatypeConfigurationException {
        SensorDetails _instance = new SensorDetails();
        String _raw = _parser.getAttributeValue(null, "featureFlag");
        if (_raw == null) goto L5;
        _instance.setFeatureFlag(_raw);
    L5:
        _parser.getDepth();
    L6:
        int type = _parser.next();
        if (type == 1) goto L26;
        if (type == 3) goto L26;
        if (_parser.getEventType() != 2) goto L6;
        String _tagName = _parser.getName();
        if (_tagName.equals(DatabaseHelper.SoundModelContract.KEY_TYPE) == true) goto L14;
        if (_tagName.equals("name") == true) goto L17;
        if (_tagName.equals("refreshRate") == true) goto L20;
        if (_tagName.equals("supportedModes") == true) goto L23;
        XmlParser.skip(_parser);
        goto L6
    L23:
        NonNegativeFloatToFloatMap _value = NonNegativeFloatToFloatMap.read(_parser);
        _instance.setSupportedModes(_value);
        goto L6
    L20:
        RefreshRateRange _value2 = RefreshRateRange.read(_parser);
        _instance.setRefreshRate(_value2);
        goto L6
    L17:
        _instance.setName(XmlParser.readText(_parser));
        goto L6
    L14:
        _instance.setType(XmlParser.readText(_parser));
    L26:
        if (type != 3) goto L29;
        return _instance;
    L29:
        throw new DatatypeConfigurationException("SensorDetails is not closed");
    }
}
