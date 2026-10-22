package com.android.server.display.config;

import java.io.IOException;
import java.math.BigDecimal;
import java.math.BigInteger;
import javax.xml.datatype.DatatypeConfigurationException;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: loaded from: classes2.dex */
public class HdrBrightnessConfig {
    private Boolean allowInLowPowerMode;
    private BigInteger brightnessDecreaseDebounceMillis;
    private BigInteger brightnessIncreaseDebounceMillis;
    private NonNegativeFloatToFloatMap brightnessMap;
    private BigDecimal minimumHdrPercentOfScreenForHbm;
    private BigDecimal minimumHdrPercentOfScreenForNbm;
    private BigDecimal screenBrightnessRampDecrease;
    private BigDecimal screenBrightnessRampIncrease;
    private NonNegativeFloatToFloatMap sdrHdrRatioMap;

    public HdrBrightnessConfig() {
    }

    public final NonNegativeFloatToFloatMap getBrightnessMap() {
        return this.brightnessMap;
    }

    boolean hasBrightnessMap() {
        if (this.brightnessMap != null) goto L6;
        return false;
    L6:
        return true;
    }

    public final void setBrightnessMap(NonNegativeFloatToFloatMap brightnessMap) {
        this.brightnessMap = brightnessMap;
    }

    public final BigInteger getBrightnessIncreaseDebounceMillis() {
        return this.brightnessIncreaseDebounceMillis;
    }

    boolean hasBrightnessIncreaseDebounceMillis() {
        if (this.brightnessIncreaseDebounceMillis != null) goto L6;
        return false;
    L6:
        return true;
    }

    public final void setBrightnessIncreaseDebounceMillis(BigInteger brightnessIncreaseDebounceMillis) {
        this.brightnessIncreaseDebounceMillis = brightnessIncreaseDebounceMillis;
    }

    public final BigInteger getBrightnessDecreaseDebounceMillis() {
        return this.brightnessDecreaseDebounceMillis;
    }

    boolean hasBrightnessDecreaseDebounceMillis() {
        if (this.brightnessDecreaseDebounceMillis != null) goto L6;
        return false;
    L6:
        return true;
    }

    public final void setBrightnessDecreaseDebounceMillis(BigInteger brightnessDecreaseDebounceMillis) {
        this.brightnessDecreaseDebounceMillis = brightnessDecreaseDebounceMillis;
    }

    public final BigDecimal getScreenBrightnessRampIncrease() {
        return this.screenBrightnessRampIncrease;
    }

    boolean hasScreenBrightnessRampIncrease() {
        if (this.screenBrightnessRampIncrease != null) goto L6;
        return false;
    L6:
        return true;
    }

    public final void setScreenBrightnessRampIncrease(BigDecimal screenBrightnessRampIncrease) {
        this.screenBrightnessRampIncrease = screenBrightnessRampIncrease;
    }

    public final BigDecimal getScreenBrightnessRampDecrease() {
        return this.screenBrightnessRampDecrease;
    }

    boolean hasScreenBrightnessRampDecrease() {
        if (this.screenBrightnessRampDecrease != null) goto L6;
        return false;
    L6:
        return true;
    }

    public final void setScreenBrightnessRampDecrease(BigDecimal screenBrightnessRampDecrease) {
        this.screenBrightnessRampDecrease = screenBrightnessRampDecrease;
    }

    public final BigDecimal getMinimumHdrPercentOfScreenForNbm() {
        return this.minimumHdrPercentOfScreenForNbm;
    }

    boolean hasMinimumHdrPercentOfScreenForNbm() {
        if (this.minimumHdrPercentOfScreenForNbm != null) goto L6;
        return false;
    L6:
        return true;
    }

    public final void setMinimumHdrPercentOfScreenForNbm(BigDecimal minimumHdrPercentOfScreenForNbm) {
        this.minimumHdrPercentOfScreenForNbm = minimumHdrPercentOfScreenForNbm;
    }

    public final BigDecimal getMinimumHdrPercentOfScreenForHbm() {
        return this.minimumHdrPercentOfScreenForHbm;
    }

    boolean hasMinimumHdrPercentOfScreenForHbm() {
        if (this.minimumHdrPercentOfScreenForHbm != null) goto L6;
        return false;
    L6:
        return true;
    }

    public final void setMinimumHdrPercentOfScreenForHbm(BigDecimal minimumHdrPercentOfScreenForHbm) {
        this.minimumHdrPercentOfScreenForHbm = minimumHdrPercentOfScreenForHbm;
    }

    public final boolean getAllowInLowPowerMode() {
        if (this.allowInLowPowerMode != null) goto L7;
        return false;
    L7:
        return this.allowInLowPowerMode.booleanValue();
    }

    boolean hasAllowInLowPowerMode() {
        if (this.allowInLowPowerMode != null) goto L6;
        return false;
    L6:
        return true;
    }

    public final void setAllowInLowPowerMode(boolean allowInLowPowerMode) {
        this.allowInLowPowerMode = Boolean.valueOf(allowInLowPowerMode);
    }

    public final NonNegativeFloatToFloatMap getSdrHdrRatioMap() {
        return this.sdrHdrRatioMap;
    }

    boolean hasSdrHdrRatioMap() {
        if (this.sdrHdrRatioMap != null) goto L6;
        return false;
    L6:
        return true;
    }

    public final void setSdrHdrRatioMap(NonNegativeFloatToFloatMap sdrHdrRatioMap) {
        this.sdrHdrRatioMap = sdrHdrRatioMap;
    }

    static HdrBrightnessConfig read(XmlPullParser _parser) throws XmlPullParserException, IOException, DatatypeConfigurationException {
        HdrBrightnessConfig _instance = new HdrBrightnessConfig();
        _parser.getDepth();
    L3:
        int type = _parser.next();
        if (type == 1) goto L38;
        if (type == 3) goto L38;
        if (_parser.getEventType() != 2) goto L3;
        String _tagName = _parser.getName();
        if (_tagName.equals("brightnessMap") == true) goto L11;
        if (_tagName.equals("brightnessIncreaseDebounceMillis") == true) goto L14;
        if (_tagName.equals("brightnessDecreaseDebounceMillis") == true) goto L17;
        if (_tagName.equals("screenBrightnessRampIncrease") == true) goto L20;
        if (_tagName.equals("screenBrightnessRampDecrease") == true) goto L23;
        if (_tagName.equals("minimumHdrPercentOfScreenForNbm") == true) goto L26;
        if (_tagName.equals("minimumHdrPercentOfScreenForHbm") == true) goto L29;
        if (_tagName.equals("allowInLowPowerMode") == true) goto L32;
        if (_tagName.equals("sdrHdrRatioMap") == true) goto L35;
        XmlParser.skip(_parser);
        goto L3
    L35:
        NonNegativeFloatToFloatMap _value = NonNegativeFloatToFloatMap.read(_parser);
        _instance.setSdrHdrRatioMap(_value);
        goto L3
    L32:
        String _raw = XmlParser.readText(_parser);
        boolean _value2 = Boolean.parseBoolean(_raw);
        _instance.setAllowInLowPowerMode(_value2);
        goto L3
    L29:
        String _raw2 = XmlParser.readText(_parser);
        BigDecimal _value3 = new BigDecimal(_raw2);
        _instance.setMinimumHdrPercentOfScreenForHbm(_value3);
        goto L3
    L26:
        String _raw3 = XmlParser.readText(_parser);
        BigDecimal _value4 = new BigDecimal(_raw3);
        _instance.setMinimumHdrPercentOfScreenForNbm(_value4);
        goto L3
    L23:
        String _raw4 = XmlParser.readText(_parser);
        BigDecimal _value5 = new BigDecimal(_raw4);
        _instance.setScreenBrightnessRampDecrease(_value5);
        goto L3
    L20:
        String _raw5 = XmlParser.readText(_parser);
        BigDecimal _value6 = new BigDecimal(_raw5);
        _instance.setScreenBrightnessRampIncrease(_value6);
        goto L3
    L17:
        String _raw6 = XmlParser.readText(_parser);
        BigInteger _value7 = new BigInteger(_raw6);
        _instance.setBrightnessDecreaseDebounceMillis(_value7);
        goto L3
    L14:
        String _raw7 = XmlParser.readText(_parser);
        BigInteger _value8 = new BigInteger(_raw7);
        _instance.setBrightnessIncreaseDebounceMillis(_value8);
        goto L3
    L11:
        NonNegativeFloatToFloatMap _value9 = NonNegativeFloatToFloatMap.read(_parser);
        _instance.setBrightnessMap(_value9);
    L38:
        if (type != 3) goto L41;
        return _instance;
    L41:
        throw new DatatypeConfigurationException("HdrBrightnessConfig is not closed");
    }
}
