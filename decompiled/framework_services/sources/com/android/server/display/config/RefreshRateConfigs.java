package com.android.server.display.config;

import java.io.IOException;
import java.math.BigInteger;
import javax.xml.datatype.DatatypeConfigurationException;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: loaded from: classes2.dex */
public class RefreshRateConfigs {
    private BigInteger defaultPeakRefreshRate;
    private BigInteger defaultRefreshRate;
    private BigInteger defaultRefreshRateInHbmHdr;
    private BigInteger defaultRefreshRateInHbmSunlight;
    private BlockingZoneConfig higherBlockingZoneConfigs;
    private NonNegativeFloatToFloatMap lowPowerSupportedModes;
    private BlockingZoneConfig lowerBlockingZoneConfigs;
    private RefreshRateZoneProfiles refreshRateZoneProfiles;

    public RefreshRateConfigs() {
    }

    public final BigInteger getDefaultRefreshRate() {
        return this.defaultRefreshRate;
    }

    boolean hasDefaultRefreshRate() {
        if (this.defaultRefreshRate != null) goto L6;
        return false;
    L6:
        return true;
    }

    public final void setDefaultRefreshRate(BigInteger defaultRefreshRate) {
        this.defaultRefreshRate = defaultRefreshRate;
    }

    public final BigInteger getDefaultPeakRefreshRate() {
        return this.defaultPeakRefreshRate;
    }

    boolean hasDefaultPeakRefreshRate() {
        if (this.defaultPeakRefreshRate != null) goto L6;
        return false;
    L6:
        return true;
    }

    public final void setDefaultPeakRefreshRate(BigInteger defaultPeakRefreshRate) {
        this.defaultPeakRefreshRate = defaultPeakRefreshRate;
    }

    public final RefreshRateZoneProfiles getRefreshRateZoneProfiles() {
        return this.refreshRateZoneProfiles;
    }

    boolean hasRefreshRateZoneProfiles() {
        if (this.refreshRateZoneProfiles != null) goto L6;
        return false;
    L6:
        return true;
    }

    public final void setRefreshRateZoneProfiles(RefreshRateZoneProfiles refreshRateZoneProfiles) {
        this.refreshRateZoneProfiles = refreshRateZoneProfiles;
    }

    public final BigInteger getDefaultRefreshRateInHbmHdr() {
        return this.defaultRefreshRateInHbmHdr;
    }

    boolean hasDefaultRefreshRateInHbmHdr() {
        if (this.defaultRefreshRateInHbmHdr != null) goto L6;
        return false;
    L6:
        return true;
    }

    public final void setDefaultRefreshRateInHbmHdr(BigInteger defaultRefreshRateInHbmHdr) {
        this.defaultRefreshRateInHbmHdr = defaultRefreshRateInHbmHdr;
    }

    public final BigInteger getDefaultRefreshRateInHbmSunlight() {
        return this.defaultRefreshRateInHbmSunlight;
    }

    boolean hasDefaultRefreshRateInHbmSunlight() {
        if (this.defaultRefreshRateInHbmSunlight != null) goto L6;
        return false;
    L6:
        return true;
    }

    public final void setDefaultRefreshRateInHbmSunlight(BigInteger defaultRefreshRateInHbmSunlight) {
        this.defaultRefreshRateInHbmSunlight = defaultRefreshRateInHbmSunlight;
    }

    public final BlockingZoneConfig getLowerBlockingZoneConfigs() {
        return this.lowerBlockingZoneConfigs;
    }

    boolean hasLowerBlockingZoneConfigs() {
        if (this.lowerBlockingZoneConfigs != null) goto L6;
        return false;
    L6:
        return true;
    }

    public final void setLowerBlockingZoneConfigs(BlockingZoneConfig lowerBlockingZoneConfigs) {
        this.lowerBlockingZoneConfigs = lowerBlockingZoneConfigs;
    }

    public final BlockingZoneConfig getHigherBlockingZoneConfigs() {
        return this.higherBlockingZoneConfigs;
    }

    boolean hasHigherBlockingZoneConfigs() {
        if (this.higherBlockingZoneConfigs != null) goto L6;
        return false;
    L6:
        return true;
    }

    public final void setHigherBlockingZoneConfigs(BlockingZoneConfig higherBlockingZoneConfigs) {
        this.higherBlockingZoneConfigs = higherBlockingZoneConfigs;
    }

    public final NonNegativeFloatToFloatMap getLowPowerSupportedModes() {
        return this.lowPowerSupportedModes;
    }

    boolean hasLowPowerSupportedModes() {
        if (this.lowPowerSupportedModes != null) goto L6;
        return false;
    L6:
        return true;
    }

    public final void setLowPowerSupportedModes(NonNegativeFloatToFloatMap lowPowerSupportedModes) {
        this.lowPowerSupportedModes = lowPowerSupportedModes;
    }

    static RefreshRateConfigs read(XmlPullParser _parser) throws XmlPullParserException, IOException, DatatypeConfigurationException {
        RefreshRateConfigs _instance = new RefreshRateConfigs();
        _parser.getDepth();
    L3:
        int type = _parser.next();
        if (type == 1) goto L35;
        if (type == 3) goto L35;
        if (_parser.getEventType() != 2) goto L3;
        String _tagName = _parser.getName();
        if (_tagName.equals("defaultRefreshRate") == true) goto L11;
        if (_tagName.equals("defaultPeakRefreshRate") == true) goto L14;
        if (_tagName.equals("refreshRateZoneProfiles") == true) goto L17;
        if (_tagName.equals("defaultRefreshRateInHbmHdr") == true) goto L20;
        if (_tagName.equals("defaultRefreshRateInHbmSunlight") == true) goto L23;
        if (_tagName.equals("lowerBlockingZoneConfigs") == true) goto L26;
        if (_tagName.equals("higherBlockingZoneConfigs") == true) goto L29;
        if (_tagName.equals("lowPowerSupportedModes") == true) goto L32;
        XmlParser.skip(_parser);
        goto L3
    L32:
        NonNegativeFloatToFloatMap _value = NonNegativeFloatToFloatMap.read(_parser);
        _instance.setLowPowerSupportedModes(_value);
        goto L3
    L29:
        BlockingZoneConfig _value2 = BlockingZoneConfig.read(_parser);
        _instance.setHigherBlockingZoneConfigs(_value2);
        goto L3
    L26:
        BlockingZoneConfig _value3 = BlockingZoneConfig.read(_parser);
        _instance.setLowerBlockingZoneConfigs(_value3);
        goto L3
    L23:
        String _raw = XmlParser.readText(_parser);
        BigInteger _value4 = new BigInteger(_raw);
        _instance.setDefaultRefreshRateInHbmSunlight(_value4);
        goto L3
    L20:
        String _raw2 = XmlParser.readText(_parser);
        BigInteger _value5 = new BigInteger(_raw2);
        _instance.setDefaultRefreshRateInHbmHdr(_value5);
        goto L3
    L17:
        RefreshRateZoneProfiles _value6 = RefreshRateZoneProfiles.read(_parser);
        _instance.setRefreshRateZoneProfiles(_value6);
        goto L3
    L14:
        String _raw3 = XmlParser.readText(_parser);
        BigInteger _value7 = new BigInteger(_raw3);
        _instance.setDefaultPeakRefreshRate(_value7);
        goto L3
    L11:
        String _raw4 = XmlParser.readText(_parser);
        BigInteger _value8 = new BigInteger(_raw4);
        _instance.setDefaultRefreshRate(_value8);
    L35:
        if (type != 3) goto L38;
        return _instance;
    L38:
        throw new DatatypeConfigurationException("RefreshRateConfigs is not closed");
    }
}
