package com.android.server.display.config;

import com.android.server.timezonedetector.ServiceConfigAccessor;
import java.io.IOException;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import javax.xml.datatype.DatatypeConfigurationException;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: loaded from: classes2.dex */
public class AutoBrightness {
    private BigInteger brighteningLightDebounceIdleMillis;
    private BigInteger brighteningLightDebounceMillis;
    private BigInteger darkeningLightDebounceIdleMillis;
    private BigInteger darkeningLightDebounceMillis;
    private Boolean enabled;
    private BigInteger idleStylusTimeoutMillis;
    private List<LuxToBrightnessMapping> luxToBrightnessMapping;

    public AutoBrightness() {
    }

    public final BigInteger getBrighteningLightDebounceMillis() {
        return this.brighteningLightDebounceMillis;
    }

    boolean hasBrighteningLightDebounceMillis() {
        if (this.brighteningLightDebounceMillis != null) goto L6;
        return false;
    L6:
        return true;
    }

    public final void setBrighteningLightDebounceMillis(BigInteger brighteningLightDebounceMillis) {
        this.brighteningLightDebounceMillis = brighteningLightDebounceMillis;
    }

    public final BigInteger getDarkeningLightDebounceMillis() {
        return this.darkeningLightDebounceMillis;
    }

    boolean hasDarkeningLightDebounceMillis() {
        if (this.darkeningLightDebounceMillis != null) goto L6;
        return false;
    L6:
        return true;
    }

    public final void setDarkeningLightDebounceMillis(BigInteger darkeningLightDebounceMillis) {
        this.darkeningLightDebounceMillis = darkeningLightDebounceMillis;
    }

    public final BigInteger getBrighteningLightDebounceIdleMillis() {
        return this.brighteningLightDebounceIdleMillis;
    }

    boolean hasBrighteningLightDebounceIdleMillis() {
        if (this.brighteningLightDebounceIdleMillis != null) goto L6;
        return false;
    L6:
        return true;
    }

    public final void setBrighteningLightDebounceIdleMillis(BigInteger brighteningLightDebounceIdleMillis) {
        this.brighteningLightDebounceIdleMillis = brighteningLightDebounceIdleMillis;
    }

    public final BigInteger getDarkeningLightDebounceIdleMillis() {
        return this.darkeningLightDebounceIdleMillis;
    }

    boolean hasDarkeningLightDebounceIdleMillis() {
        if (this.darkeningLightDebounceIdleMillis != null) goto L6;
        return false;
    L6:
        return true;
    }

    public final void setDarkeningLightDebounceIdleMillis(BigInteger darkeningLightDebounceIdleMillis) {
        this.darkeningLightDebounceIdleMillis = darkeningLightDebounceIdleMillis;
    }

    public final List<LuxToBrightnessMapping> getLuxToBrightnessMapping() {
        if (this.luxToBrightnessMapping != null) goto L6;
        this.luxToBrightnessMapping = new ArrayList();
    L6:
        return this.luxToBrightnessMapping;
    }

    public final BigInteger getIdleStylusTimeoutMillis() {
        return this.idleStylusTimeoutMillis;
    }

    boolean hasIdleStylusTimeoutMillis() {
        if (this.idleStylusTimeoutMillis != null) goto L6;
        return false;
    L6:
        return true;
    }

    public final void setIdleStylusTimeoutMillis(BigInteger idleStylusTimeoutMillis) {
        this.idleStylusTimeoutMillis = idleStylusTimeoutMillis;
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

    static AutoBrightness read(XmlPullParser _parser) throws XmlPullParserException, IOException, DatatypeConfigurationException {
        AutoBrightness _instance = new AutoBrightness();
        String _raw = _parser.getAttributeValue(null, ServiceConfigAccessor.PROVIDER_MODE_ENABLED);
        if (_raw == null) goto L5;
        boolean _value = Boolean.parseBoolean(_raw);
        _instance.setEnabled(_value);
    L5:
        _parser.getDepth();
    L6:
        int type = _parser.next();
        if (type == 1) goto L32;
        if (type == 3) goto L32;
        if (_parser.getEventType() != 2) goto L6;
        String _tagName = _parser.getName();
        if (_tagName.equals("brighteningLightDebounceMillis") == true) goto L14;
        if (_tagName.equals("darkeningLightDebounceMillis") == true) goto L17;
        if (_tagName.equals("brighteningLightDebounceIdleMillis") == true) goto L20;
        if (_tagName.equals("darkeningLightDebounceIdleMillis") == true) goto L23;
        if (_tagName.equals("luxToBrightnessMapping") == true) goto L26;
        if (_tagName.equals("idleStylusTimeoutMillis") == true) goto L29;
        XmlParser.skip(_parser);
        goto L6
    L29:
        BigInteger _value2 = new BigInteger(XmlParser.readText(_parser));
        _instance.setIdleStylusTimeoutMillis(_value2);
        goto L6
    L26:
        LuxToBrightnessMapping _value3 = LuxToBrightnessMapping.read(_parser);
        _instance.getLuxToBrightnessMapping().add(_value3);
        goto L6
    L23:
        BigInteger _value4 = new BigInteger(XmlParser.readText(_parser));
        _instance.setDarkeningLightDebounceIdleMillis(_value4);
        goto L6
    L20:
        BigInteger _value5 = new BigInteger(XmlParser.readText(_parser));
        _instance.setBrighteningLightDebounceIdleMillis(_value5);
        goto L6
    L17:
        BigInteger _value6 = new BigInteger(XmlParser.readText(_parser));
        _instance.setDarkeningLightDebounceMillis(_value6);
        goto L6
    L14:
        BigInteger _value7 = new BigInteger(XmlParser.readText(_parser));
        _instance.setBrighteningLightDebounceMillis(_value7);
    L32:
        if (type != 3) goto L35;
        return _instance;
    L35:
        throw new DatatypeConfigurationException("AutoBrightness is not closed");
    }
}
