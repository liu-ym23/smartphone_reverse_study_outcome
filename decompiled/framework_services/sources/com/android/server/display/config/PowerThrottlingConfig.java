package com.android.server.display.config;

import java.io.IOException;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import javax.xml.datatype.DatatypeConfigurationException;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: loaded from: classes2.dex */
public class PowerThrottlingConfig {
    private BigDecimal brightnessLowestCapAllowed;
    private BigDecimal customAnimationRate;
    private BigInteger pollingWindowMaxMillis;
    private BigInteger pollingWindowMinMillis;
    private List<PowerThrottlingMap> powerThrottlingMap;

    public PowerThrottlingConfig() {
    }

    public final BigDecimal getBrightnessLowestCapAllowed() {
        return this.brightnessLowestCapAllowed;
    }

    boolean hasBrightnessLowestCapAllowed() {
        if (this.brightnessLowestCapAllowed != null) goto L6;
        return false;
    L6:
        return true;
    }

    public final void setBrightnessLowestCapAllowed(BigDecimal brightnessLowestCapAllowed) {
        this.brightnessLowestCapAllowed = brightnessLowestCapAllowed;
    }

    public final BigDecimal getCustomAnimationRate() {
        return this.customAnimationRate;
    }

    boolean hasCustomAnimationRate() {
        if (this.customAnimationRate != null) goto L6;
        return false;
    L6:
        return true;
    }

    public final void setCustomAnimationRate(BigDecimal customAnimationRate) {
        this.customAnimationRate = customAnimationRate;
    }

    public final BigInteger getPollingWindowMaxMillis() {
        return this.pollingWindowMaxMillis;
    }

    boolean hasPollingWindowMaxMillis() {
        if (this.pollingWindowMaxMillis != null) goto L6;
        return false;
    L6:
        return true;
    }

    public final void setPollingWindowMaxMillis(BigInteger pollingWindowMaxMillis) {
        this.pollingWindowMaxMillis = pollingWindowMaxMillis;
    }

    public final BigInteger getPollingWindowMinMillis() {
        return this.pollingWindowMinMillis;
    }

    boolean hasPollingWindowMinMillis() {
        if (this.pollingWindowMinMillis != null) goto L6;
        return false;
    L6:
        return true;
    }

    public final void setPollingWindowMinMillis(BigInteger pollingWindowMinMillis) {
        this.pollingWindowMinMillis = pollingWindowMinMillis;
    }

    public final List<PowerThrottlingMap> getPowerThrottlingMap() {
        if (this.powerThrottlingMap != null) goto L6;
        this.powerThrottlingMap = new ArrayList();
    L6:
        return this.powerThrottlingMap;
    }

    static PowerThrottlingConfig read(XmlPullParser _parser) throws XmlPullParserException, IOException, DatatypeConfigurationException {
        PowerThrottlingConfig _instance = new PowerThrottlingConfig();
        _parser.getDepth();
    L3:
        int type = _parser.next();
        if (type == 1) goto L26;
        if (type == 3) goto L26;
        if (_parser.getEventType() != 2) goto L3;
        String _tagName = _parser.getName();
        if (_tagName.equals("brightnessLowestCapAllowed") == true) goto L11;
        if (_tagName.equals("customAnimationRate") == true) goto L14;
        if (_tagName.equals("pollingWindowMaxMillis") == true) goto L17;
        if (_tagName.equals("pollingWindowMinMillis") == true) goto L20;
        if (_tagName.equals("powerThrottlingMap") == true) goto L23;
        XmlParser.skip(_parser);
        goto L3
    L23:
        PowerThrottlingMap _value = PowerThrottlingMap.read(_parser);
        _instance.getPowerThrottlingMap().add(_value);
        goto L3
    L20:
        String _raw = XmlParser.readText(_parser);
        BigInteger _value2 = new BigInteger(_raw);
        _instance.setPollingWindowMinMillis(_value2);
        goto L3
    L17:
        String _raw2 = XmlParser.readText(_parser);
        BigInteger _value3 = new BigInteger(_raw2);
        _instance.setPollingWindowMaxMillis(_value3);
        goto L3
    L14:
        String _raw3 = XmlParser.readText(_parser);
        BigDecimal _value4 = new BigDecimal(_raw3);
        _instance.setCustomAnimationRate(_value4);
        goto L3
    L11:
        String _raw4 = XmlParser.readText(_parser);
        BigDecimal _value5 = new BigDecimal(_raw4);
        _instance.setBrightnessLowestCapAllowed(_value5);
    L26:
        if (type != 3) goto L29;
        return _instance;
    L29:
        throw new DatatypeConfigurationException("PowerThrottlingConfig is not closed");
    }
}
