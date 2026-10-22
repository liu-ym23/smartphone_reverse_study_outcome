package com.android.server.display.config;

import java.io.IOException;
import java.math.BigInteger;
import javax.xml.datatype.DatatypeConfigurationException;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: loaded from: classes2.dex */
public class BlockingZoneConfig {
    private BlockingZoneThreshold blockingZoneThreshold;
    private BigInteger defaultRefreshRate;
    private String refreshRateThermalThrottlingId;
    private NonNegativeFloatToFloatMap supportedModes;

    public BlockingZoneConfig() {
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

    public final String getRefreshRateThermalThrottlingId() {
        return this.refreshRateThermalThrottlingId;
    }

    boolean hasRefreshRateThermalThrottlingId() {
        if (this.refreshRateThermalThrottlingId != null) goto L6;
        return false;
    L6:
        return true;
    }

    public final void setRefreshRateThermalThrottlingId(String refreshRateThermalThrottlingId) {
        this.refreshRateThermalThrottlingId = refreshRateThermalThrottlingId;
    }

    public final BlockingZoneThreshold getBlockingZoneThreshold() {
        return this.blockingZoneThreshold;
    }

    boolean hasBlockingZoneThreshold() {
        if (this.blockingZoneThreshold != null) goto L6;
        return false;
    L6:
        return true;
    }

    public final void setBlockingZoneThreshold(BlockingZoneThreshold blockingZoneThreshold) {
        this.blockingZoneThreshold = blockingZoneThreshold;
    }

    static BlockingZoneConfig read(XmlPullParser _parser) throws XmlPullParserException, IOException, DatatypeConfigurationException {
        BlockingZoneConfig _instance = new BlockingZoneConfig();
        _parser.getDepth();
    L3:
        int type = _parser.next();
        if (type == 1) goto L23;
        if (type == 3) goto L23;
        if (_parser.getEventType() != 2) goto L3;
        String _tagName = _parser.getName();
        if (_tagName.equals("supportedModes") == true) goto L11;
        if (_tagName.equals("defaultRefreshRate") == true) goto L14;
        if (_tagName.equals("refreshRateThermalThrottlingId") == true) goto L17;
        if (_tagName.equals("blockingZoneThreshold") == true) goto L20;
        XmlParser.skip(_parser);
        goto L3
    L20:
        BlockingZoneThreshold _value = BlockingZoneThreshold.read(_parser);
        _instance.setBlockingZoneThreshold(_value);
        goto L3
    L17:
        String _raw = XmlParser.readText(_parser);
        _instance.setRefreshRateThermalThrottlingId(_raw);
        goto L3
    L14:
        String _raw2 = XmlParser.readText(_parser);
        BigInteger _value2 = new BigInteger(_raw2);
        _instance.setDefaultRefreshRate(_value2);
        goto L3
    L11:
        NonNegativeFloatToFloatMap _value3 = NonNegativeFloatToFloatMap.read(_parser);
        _instance.setSupportedModes(_value3);
    L23:
        if (type != 3) goto L26;
        return _instance;
    L26:
        throw new DatatypeConfigurationException("BlockingZoneConfig is not closed");
    }
}
