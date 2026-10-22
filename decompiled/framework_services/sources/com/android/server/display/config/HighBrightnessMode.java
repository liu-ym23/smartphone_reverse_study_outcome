package com.android.server.display.config;

import com.android.server.timezonedetector.ServiceConfigAccessor;
import java.io.IOException;
import java.math.BigDecimal;
import javax.xml.datatype.DatatypeConfigurationException;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: loaded from: classes2.dex */
public class HighBrightnessMode {
    private Boolean allowInLowPowerMode_all;
    private Boolean enabled;
    private BigDecimal minimumHdrPercentOfScreen_all;
    private BigDecimal minimumLux_all;
    private RefreshRateRange refreshRate_all;
    private SdrHdrRatioMap sdrHdrRatioMap_all;
    private HbmTiming timing_all;
    private BigDecimal transitionPoint_all;

    public HighBrightnessMode() {
    }

    public final BigDecimal getTransitionPoint_all() {
        return this.transitionPoint_all;
    }

    boolean hasTransitionPoint_all() {
        if (this.transitionPoint_all != null) goto L6;
        return false;
    L6:
        return true;
    }

    public final void setTransitionPoint_all(BigDecimal transitionPoint_all) {
        this.transitionPoint_all = transitionPoint_all;
    }

    public final BigDecimal getMinimumLux_all() {
        return this.minimumLux_all;
    }

    boolean hasMinimumLux_all() {
        if (this.minimumLux_all != null) goto L6;
        return false;
    L6:
        return true;
    }

    public final void setMinimumLux_all(BigDecimal minimumLux_all) {
        this.minimumLux_all = minimumLux_all;
    }

    public HbmTiming getTiming_all() {
        return this.timing_all;
    }

    boolean hasTiming_all() {
        if (this.timing_all != null) goto L6;
        return false;
    L6:
        return true;
    }

    public void setTiming_all(HbmTiming timing_all) {
        this.timing_all = timing_all;
    }

    public final RefreshRateRange getRefreshRate_all() {
        return this.refreshRate_all;
    }

    boolean hasRefreshRate_all() {
        if (this.refreshRate_all != null) goto L6;
        return false;
    L6:
        return true;
    }

    public final void setRefreshRate_all(RefreshRateRange refreshRate_all) {
        this.refreshRate_all = refreshRate_all;
    }

    public final boolean getAllowInLowPowerMode_all() {
        if (this.allowInLowPowerMode_all != null) goto L7;
        return false;
    L7:
        return this.allowInLowPowerMode_all.booleanValue();
    }

    boolean hasAllowInLowPowerMode_all() {
        if (this.allowInLowPowerMode_all != null) goto L6;
        return false;
    L6:
        return true;
    }

    public final void setAllowInLowPowerMode_all(boolean allowInLowPowerMode_all) {
        this.allowInLowPowerMode_all = Boolean.valueOf(allowInLowPowerMode_all);
    }

    public final BigDecimal getMinimumHdrPercentOfScreen_all() {
        return this.minimumHdrPercentOfScreen_all;
    }

    boolean hasMinimumHdrPercentOfScreen_all() {
        if (this.minimumHdrPercentOfScreen_all != null) goto L6;
        return false;
    L6:
        return true;
    }

    public final void setMinimumHdrPercentOfScreen_all(BigDecimal minimumHdrPercentOfScreen_all) {
        this.minimumHdrPercentOfScreen_all = minimumHdrPercentOfScreen_all;
    }

    public final SdrHdrRatioMap getSdrHdrRatioMap_all() {
        return this.sdrHdrRatioMap_all;
    }

    boolean hasSdrHdrRatioMap_all() {
        if (this.sdrHdrRatioMap_all != null) goto L6;
        return false;
    L6:
        return true;
    }

    public final void setSdrHdrRatioMap_all(SdrHdrRatioMap sdrHdrRatioMap_all) {
        this.sdrHdrRatioMap_all = sdrHdrRatioMap_all;
    }

    public boolean getEnabled() {
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

    static HighBrightnessMode read(XmlPullParser _parser) throws XmlPullParserException, IOException, DatatypeConfigurationException {
        HighBrightnessMode _instance = new HighBrightnessMode();
        String _raw = _parser.getAttributeValue(null, ServiceConfigAccessor.PROVIDER_MODE_ENABLED);
        if (_raw == null) goto L5;
        boolean _value = Boolean.parseBoolean(_raw);
        _instance.setEnabled(_value);
    L5:
        _parser.getDepth();
    L6:
        int type = _parser.next();
        if (type == 1) goto L35;
        if (type == 3) goto L35;
        if (_parser.getEventType() != 2) goto L6;
        String _tagName = _parser.getName();
        if (_tagName.equals("transitionPoint") == true) goto L14;
        if (_tagName.equals("minimumLux") == true) goto L17;
        if (_tagName.equals("timing") == true) goto L20;
        if (_tagName.equals("refreshRate") == true) goto L23;
        if (_tagName.equals("allowInLowPowerMode") == true) goto L26;
        if (_tagName.equals("minimumHdrPercentOfScreen") == true) goto L29;
        if (_tagName.equals("sdrHdrRatioMap") == true) goto L32;
        XmlParser.skip(_parser);
        goto L6
    L32:
        SdrHdrRatioMap _value2 = SdrHdrRatioMap.read(_parser);
        _instance.setSdrHdrRatioMap_all(_value2);
        goto L6
    L29:
        BigDecimal _value3 = new BigDecimal(XmlParser.readText(_parser));
        _instance.setMinimumHdrPercentOfScreen_all(_value3);
        goto L6
    L26:
        boolean _value4 = Boolean.parseBoolean(XmlParser.readText(_parser));
        _instance.setAllowInLowPowerMode_all(_value4);
        goto L6
    L23:
        RefreshRateRange _value5 = RefreshRateRange.read(_parser);
        _instance.setRefreshRate_all(_value5);
        goto L6
    L20:
        HbmTiming _value6 = HbmTiming.read(_parser);
        _instance.setTiming_all(_value6);
        goto L6
    L17:
        BigDecimal _value7 = new BigDecimal(XmlParser.readText(_parser));
        _instance.setMinimumLux_all(_value7);
        goto L6
    L14:
        BigDecimal _value8 = new BigDecimal(XmlParser.readText(_parser));
        _instance.setTransitionPoint_all(_value8);
    L35:
        if (type != 3) goto L38;
        return _instance;
    L38:
        throw new DatatypeConfigurationException("HighBrightnessMode is not closed");
    }
}
