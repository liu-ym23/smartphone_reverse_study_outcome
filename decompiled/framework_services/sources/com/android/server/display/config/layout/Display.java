package com.android.server.display.config.layout;

import com.android.server.timezonedetector.ServiceConfigAccessor;
import java.io.IOException;
import java.math.BigInteger;
import javax.xml.datatype.DatatypeConfigurationException;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: loaded from: classes2.dex */
public class Display {
    private BigInteger address_optional;
    private String brightnessThrottlingMapId;
    private Boolean defaultDisplay;
    private String displayGroup;
    private Boolean enabled;
    private BigInteger leadDisplayAddress;
    private BigInteger port_optional;
    private String position;
    private String powerThrottlingMapId;
    private String refreshRateThermalThrottlingMapId;
    private String refreshRateZoneId;

    public Display() {
    }

    public BigInteger getAddress_optional() {
        return this.address_optional;
    }

    boolean hasAddress_optional() {
        if (this.address_optional != null) goto L6;
        return false;
    L6:
        return true;
    }

    public void setAddress_optional(BigInteger address_optional) {
        this.address_optional = address_optional;
    }

    public BigInteger getPort_optional() {
        return this.port_optional;
    }

    boolean hasPort_optional() {
        if (this.port_optional != null) goto L6;
        return false;
    L6:
        return true;
    }

    public void setPort_optional(BigInteger port_optional) {
        this.port_optional = port_optional;
    }

    public String getPosition() {
        return this.position;
    }

    boolean hasPosition() {
        if (this.position != null) goto L6;
        return false;
    L6:
        return true;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getBrightnessThrottlingMapId() {
        return this.brightnessThrottlingMapId;
    }

    boolean hasBrightnessThrottlingMapId() {
        if (this.brightnessThrottlingMapId != null) goto L6;
        return false;
    L6:
        return true;
    }

    public void setBrightnessThrottlingMapId(String brightnessThrottlingMapId) {
        this.brightnessThrottlingMapId = brightnessThrottlingMapId;
    }

    public String getPowerThrottlingMapId() {
        return this.powerThrottlingMapId;
    }

    boolean hasPowerThrottlingMapId() {
        if (this.powerThrottlingMapId != null) goto L6;
        return false;
    L6:
        return true;
    }

    public void setPowerThrottlingMapId(String powerThrottlingMapId) {
        this.powerThrottlingMapId = powerThrottlingMapId;
    }

    public String getRefreshRateThermalThrottlingMapId() {
        return this.refreshRateThermalThrottlingMapId;
    }

    boolean hasRefreshRateThermalThrottlingMapId() {
        if (this.refreshRateThermalThrottlingMapId != null) goto L6;
        return false;
    L6:
        return true;
    }

    public void setRefreshRateThermalThrottlingMapId(String refreshRateThermalThrottlingMapId) {
        this.refreshRateThermalThrottlingMapId = refreshRateThermalThrottlingMapId;
    }

    public BigInteger getLeadDisplayAddress() {
        return this.leadDisplayAddress;
    }

    boolean hasLeadDisplayAddress() {
        if (this.leadDisplayAddress != null) goto L6;
        return false;
    L6:
        return true;
    }

    public void setLeadDisplayAddress(BigInteger leadDisplayAddress) {
        this.leadDisplayAddress = leadDisplayAddress;
    }

    public boolean isEnabled() {
        if (this.enabled != null) goto L7;
        return false;
    L7:
        return this.enabled.booleanValue();
    }

    boolean hasEnabled() {
        if (this.enabled != null) goto L6;
        return false;
    L6:
        return true;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = Boolean.valueOf(enabled);
    }

    public boolean isDefaultDisplay() {
        if (this.defaultDisplay != null) goto L7;
        return false;
    L7:
        return this.defaultDisplay.booleanValue();
    }

    boolean hasDefaultDisplay() {
        if (this.defaultDisplay != null) goto L6;
        return false;
    L6:
        return true;
    }

    public void setDefaultDisplay(boolean defaultDisplay) {
        this.defaultDisplay = Boolean.valueOf(defaultDisplay);
    }

    public String getRefreshRateZoneId() {
        return this.refreshRateZoneId;
    }

    boolean hasRefreshRateZoneId() {
        if (this.refreshRateZoneId != null) goto L6;
        return false;
    L6:
        return true;
    }

    public void setRefreshRateZoneId(String refreshRateZoneId) {
        this.refreshRateZoneId = refreshRateZoneId;
    }

    public String getDisplayGroup() {
        return this.displayGroup;
    }

    boolean hasDisplayGroup() {
        if (this.displayGroup != null) goto L6;
        return false;
    L6:
        return true;
    }

    public void setDisplayGroup(String displayGroup) {
        this.displayGroup = displayGroup;
    }

    static Display read(XmlPullParser _parser) throws XmlPullParserException, IOException, DatatypeConfigurationException {
        Display _instance = new Display();
        String _raw = _parser.getAttributeValue(null, ServiceConfigAccessor.PROVIDER_MODE_ENABLED);
        if (_raw == null) goto L5;
        boolean _value = Boolean.parseBoolean(_raw);
        _instance.setEnabled(_value);
    L5:
        String _raw2 = _parser.getAttributeValue(null, "defaultDisplay");
        if (_raw2 == null) goto L8;
        boolean _value2 = Boolean.parseBoolean(_raw2);
        _instance.setDefaultDisplay(_value2);
    L8:
        String _raw3 = _parser.getAttributeValue(null, "refreshRateZoneId");
        if (_raw3 == null) goto L11;
        _instance.setRefreshRateZoneId(_raw3);
    L11:
        String _raw4 = _parser.getAttributeValue(null, "displayGroup");
        if (_raw4 == null) goto L14;
        _instance.setDisplayGroup(_raw4);
    L14:
        _parser.getDepth();
    L15:
        int type = _parser.next();
        if (type == 1) goto L44;
        if (type == 3) goto L44;
        if (_parser.getEventType() != 2) goto L15;
        String _tagName = _parser.getName();
        if (_tagName.equals("address") == true) goto L23;
        if (_tagName.equals("port") == true) goto L26;
        if (_tagName.equals("position") == true) goto L29;
        if (_tagName.equals("brightnessThrottlingMapId") == true) goto L32;
        if (_tagName.equals("powerThrottlingMapId") == true) goto L35;
        if (_tagName.equals("refreshRateThermalThrottlingMapId") == true) goto L38;
        if (_tagName.equals("leadDisplayAddress") == true) goto L41;
        XmlParser.skip(_parser);
        goto L15
    L41:
        BigInteger _value3 = new BigInteger(XmlParser.readText(_parser));
        _instance.setLeadDisplayAddress(_value3);
        goto L15
    L38:
        _instance.setRefreshRateThermalThrottlingMapId(XmlParser.readText(_parser));
        goto L15
    L35:
        _instance.setPowerThrottlingMapId(XmlParser.readText(_parser));
        goto L15
    L32:
        _instance.setBrightnessThrottlingMapId(XmlParser.readText(_parser));
        goto L15
    L29:
        _instance.setPosition(XmlParser.readText(_parser));
        goto L15
    L26:
        BigInteger _value4 = new BigInteger(XmlParser.readText(_parser));
        _instance.setPort_optional(_value4);
        goto L15
    L23:
        BigInteger _value5 = new BigInteger(XmlParser.readText(_parser));
        _instance.setAddress_optional(_value5);
    L44:
        if (type != 3) goto L47;
        return _instance;
    L47:
        throw new DatatypeConfigurationException("Display is not closed");
    }
}
