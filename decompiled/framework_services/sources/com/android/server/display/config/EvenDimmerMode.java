package com.android.server.display.config;

import com.android.server.timezonedetector.ServiceConfigAccessor;
import java.io.IOException;
import java.math.BigDecimal;
import javax.xml.datatype.DatatypeConfigurationException;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: loaded from: classes2.dex */
public class EvenDimmerMode {
    private ComprehensiveBrightnessMap brightnessMapping;
    private Boolean enabled;
    private NitsMap luxToMinimumNitsMap;
    private BigDecimal transitionPoint;

    public EvenDimmerMode() {
    }

    public BigDecimal getTransitionPoint() {
        return this.transitionPoint;
    }

    boolean hasTransitionPoint() {
        if (this.transitionPoint != null) goto L6;
        return false;
    L6:
        return true;
    }

    public void setTransitionPoint(BigDecimal transitionPoint) {
        this.transitionPoint = transitionPoint;
    }

    public ComprehensiveBrightnessMap getBrightnessMapping() {
        return this.brightnessMapping;
    }

    boolean hasBrightnessMapping() {
        if (this.brightnessMapping != null) goto L6;
        return false;
    L6:
        return true;
    }

    public void setBrightnessMapping(ComprehensiveBrightnessMap brightnessMapping) {
        this.brightnessMapping = brightnessMapping;
    }

    public NitsMap getLuxToMinimumNitsMap() {
        return this.luxToMinimumNitsMap;
    }

    boolean hasLuxToMinimumNitsMap() {
        if (this.luxToMinimumNitsMap != null) goto L6;
        return false;
    L6:
        return true;
    }

    public void setLuxToMinimumNitsMap(NitsMap luxToMinimumNitsMap) {
        this.luxToMinimumNitsMap = luxToMinimumNitsMap;
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

    static EvenDimmerMode read(XmlPullParser _parser) throws XmlPullParserException, IOException, DatatypeConfigurationException {
        EvenDimmerMode _instance = new EvenDimmerMode();
        String _raw = _parser.getAttributeValue(null, ServiceConfigAccessor.PROVIDER_MODE_ENABLED);
        if (_raw == null) goto L5;
        boolean _value = Boolean.parseBoolean(_raw);
        _instance.setEnabled(_value);
    L5:
        _parser.getDepth();
    L6:
        int type = _parser.next();
        if (type == 1) goto L23;
        if (type == 3) goto L23;
        if (_parser.getEventType() != 2) goto L6;
        String _tagName = _parser.getName();
        if (_tagName.equals("transitionPoint") == true) goto L14;
        if (_tagName.equals("brightnessMapping") == true) goto L17;
        if (_tagName.equals("luxToMinimumNitsMap") == true) goto L20;
        XmlParser.skip(_parser);
        goto L6
    L20:
        NitsMap _value2 = NitsMap.read(_parser);
        _instance.setLuxToMinimumNitsMap(_value2);
        goto L6
    L17:
        ComprehensiveBrightnessMap _value3 = ComprehensiveBrightnessMap.read(_parser);
        _instance.setBrightnessMapping(_value3);
        goto L6
    L14:
        BigDecimal _value4 = new BigDecimal(XmlParser.readText(_parser));
        _instance.setTransitionPoint(_value4);
    L23:
        if (type != 3) goto L26;
        return _instance;
    L26:
        throw new DatatypeConfigurationException("EvenDimmerMode is not closed");
    }
}
