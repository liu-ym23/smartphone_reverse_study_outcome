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
public class DisplayConfiguration {
    private Thresholds ambientBrightnessChangeThresholds;
    private Thresholds ambientBrightnessChangeThresholdsIdle;
    private BigInteger ambientLightHorizonLong;
    private BigInteger ambientLightHorizonShort;
    private AutoBrightness autoBrightness;
    private BigDecimal defaultDozeBrightness;
    private DensityMapping densityMapping;
    private Thresholds displayBrightnessChangeThresholds;
    private Thresholds displayBrightnessChangeThresholdsIdle;
    private FloatArray dozeBrightnessSensorValueToBrightness;
    private EvenDimmerMode evenDimmer;
    private FullScreenAodMode fullScreenAod;
    private HdrBrightnessConfig hdrBrightnessConfig;
    private HighBrightnessMode highBrightnessMode;
    private IdleScreenRefreshRateTimeout idleScreenRefreshRateTimeout;
    private SensorDetails lightSensor;
    private LuxThrottling luxThrottling;
    private String name;
    private PowerThrottlingConfig powerThrottlingConfig;
    private List<SensorDetails> proxSensor;
    private DisplayQuirks quirks;
    private RefreshRateConfigs refreshRate;
    private BigDecimal screenBrightnessCapForWearBedtimeMode;
    private BigDecimal screenBrightnessDefault;
    private NitsMap screenBrightnessMap;
    private BigInteger screenBrightnessRampDecreaseMaxIdleMillis;
    private BigInteger screenBrightnessRampDecreaseMaxMillis;
    private BigDecimal screenBrightnessRampFastDecrease;
    private BigDecimal screenBrightnessRampFastIncrease;
    private BigInteger screenBrightnessRampIncreaseMaxIdleMillis;
    private BigInteger screenBrightnessRampIncreaseMaxMillis;
    private BigDecimal screenBrightnessRampSlowDecrease;
    private BigDecimal screenBrightnessRampSlowDecreaseIdle;
    private BigDecimal screenBrightnessRampSlowIncrease;
    private BigDecimal screenBrightnessRampSlowIncreaseIdle;
    private SensorDetails screenOffBrightnessSensor;
    private IntegerArray screenOffBrightnessSensorValueToLux;
    private Boolean supportsVrr;
    private SensorDetails tempSensor;
    private ThermalThrottling thermalThrottling;
    private UsiVersion usiVersion;

    public DisplayConfiguration() {
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

    public final DensityMapping getDensityMapping() {
        return this.densityMapping;
    }

    boolean hasDensityMapping() {
        if (this.densityMapping != null) goto L6;
        return false;
    L6:
        return true;
    }

    public final void setDensityMapping(DensityMapping densityMapping) {
        this.densityMapping = densityMapping;
    }

    public final NitsMap getScreenBrightnessMap() {
        return this.screenBrightnessMap;
    }

    boolean hasScreenBrightnessMap() {
        if (this.screenBrightnessMap != null) goto L6;
        return false;
    L6:
        return true;
    }

    public final void setScreenBrightnessMap(NitsMap screenBrightnessMap) {
        this.screenBrightnessMap = screenBrightnessMap;
    }

    public final BigDecimal getScreenBrightnessDefault() {
        return this.screenBrightnessDefault;
    }

    boolean hasScreenBrightnessDefault() {
        if (this.screenBrightnessDefault != null) goto L6;
        return false;
    L6:
        return true;
    }

    public final void setScreenBrightnessDefault(BigDecimal screenBrightnessDefault) {
        this.screenBrightnessDefault = screenBrightnessDefault;
    }

    public final ThermalThrottling getThermalThrottling() {
        return this.thermalThrottling;
    }

    boolean hasThermalThrottling() {
        if (this.thermalThrottling != null) goto L6;
        return false;
    L6:
        return true;
    }

    public final void setThermalThrottling(ThermalThrottling thermalThrottling) {
        this.thermalThrottling = thermalThrottling;
    }

    public PowerThrottlingConfig getPowerThrottlingConfig() {
        return this.powerThrottlingConfig;
    }

    boolean hasPowerThrottlingConfig() {
        if (this.powerThrottlingConfig != null) goto L6;
        return false;
    L6:
        return true;
    }

    public void setPowerThrottlingConfig(PowerThrottlingConfig powerThrottlingConfig) {
        this.powerThrottlingConfig = powerThrottlingConfig;
    }

    public LuxThrottling getLuxThrottling() {
        return this.luxThrottling;
    }

    boolean hasLuxThrottling() {
        if (this.luxThrottling != null) goto L6;
        return false;
    L6:
        return true;
    }

    public void setLuxThrottling(LuxThrottling luxThrottling) {
        this.luxThrottling = luxThrottling;
    }

    public HighBrightnessMode getHighBrightnessMode() {
        return this.highBrightnessMode;
    }

    boolean hasHighBrightnessMode() {
        if (this.highBrightnessMode != null) goto L6;
        return false;
    L6:
        return true;
    }

    public void setHighBrightnessMode(HighBrightnessMode highBrightnessMode) {
        this.highBrightnessMode = highBrightnessMode;
    }

    public final HdrBrightnessConfig getHdrBrightnessConfig() {
        return this.hdrBrightnessConfig;
    }

    boolean hasHdrBrightnessConfig() {
        if (this.hdrBrightnessConfig != null) goto L6;
        return false;
    L6:
        return true;
    }

    public final void setHdrBrightnessConfig(HdrBrightnessConfig hdrBrightnessConfig) {
        this.hdrBrightnessConfig = hdrBrightnessConfig;
    }

    public DisplayQuirks getQuirks() {
        return this.quirks;
    }

    boolean hasQuirks() {
        if (this.quirks != null) goto L6;
        return false;
    L6:
        return true;
    }

    public void setQuirks(DisplayQuirks quirks) {
        this.quirks = quirks;
    }

    public AutoBrightness getAutoBrightness() {
        return this.autoBrightness;
    }

    boolean hasAutoBrightness() {
        if (this.autoBrightness != null) goto L6;
        return false;
    L6:
        return true;
    }

    public void setAutoBrightness(AutoBrightness autoBrightness) {
        this.autoBrightness = autoBrightness;
    }

    public RefreshRateConfigs getRefreshRate() {
        return this.refreshRate;
    }

    boolean hasRefreshRate() {
        if (this.refreshRate != null) goto L6;
        return false;
    L6:
        return true;
    }

    public void setRefreshRate(RefreshRateConfigs refreshRate) {
        this.refreshRate = refreshRate;
    }

    public final BigDecimal getScreenBrightnessRampFastDecrease() {
        return this.screenBrightnessRampFastDecrease;
    }

    boolean hasScreenBrightnessRampFastDecrease() {
        if (this.screenBrightnessRampFastDecrease != null) goto L6;
        return false;
    L6:
        return true;
    }

    public final void setScreenBrightnessRampFastDecrease(BigDecimal screenBrightnessRampFastDecrease) {
        this.screenBrightnessRampFastDecrease = screenBrightnessRampFastDecrease;
    }

    public final BigDecimal getScreenBrightnessRampFastIncrease() {
        return this.screenBrightnessRampFastIncrease;
    }

    boolean hasScreenBrightnessRampFastIncrease() {
        if (this.screenBrightnessRampFastIncrease != null) goto L6;
        return false;
    L6:
        return true;
    }

    public final void setScreenBrightnessRampFastIncrease(BigDecimal screenBrightnessRampFastIncrease) {
        this.screenBrightnessRampFastIncrease = screenBrightnessRampFastIncrease;
    }

    public final BigDecimal getScreenBrightnessRampSlowDecrease() {
        return this.screenBrightnessRampSlowDecrease;
    }

    boolean hasScreenBrightnessRampSlowDecrease() {
        if (this.screenBrightnessRampSlowDecrease != null) goto L6;
        return false;
    L6:
        return true;
    }

    public final void setScreenBrightnessRampSlowDecrease(BigDecimal screenBrightnessRampSlowDecrease) {
        this.screenBrightnessRampSlowDecrease = screenBrightnessRampSlowDecrease;
    }

    public final BigDecimal getScreenBrightnessRampSlowIncrease() {
        return this.screenBrightnessRampSlowIncrease;
    }

    boolean hasScreenBrightnessRampSlowIncrease() {
        if (this.screenBrightnessRampSlowIncrease != null) goto L6;
        return false;
    L6:
        return true;
    }

    public final void setScreenBrightnessRampSlowIncrease(BigDecimal screenBrightnessRampSlowIncrease) {
        this.screenBrightnessRampSlowIncrease = screenBrightnessRampSlowIncrease;
    }

    public final BigDecimal getScreenBrightnessRampSlowDecreaseIdle() {
        return this.screenBrightnessRampSlowDecreaseIdle;
    }

    boolean hasScreenBrightnessRampSlowDecreaseIdle() {
        if (this.screenBrightnessRampSlowDecreaseIdle != null) goto L6;
        return false;
    L6:
        return true;
    }

    public final void setScreenBrightnessRampSlowDecreaseIdle(BigDecimal screenBrightnessRampSlowDecreaseIdle) {
        this.screenBrightnessRampSlowDecreaseIdle = screenBrightnessRampSlowDecreaseIdle;
    }

    public final BigDecimal getScreenBrightnessRampSlowIncreaseIdle() {
        return this.screenBrightnessRampSlowIncreaseIdle;
    }

    boolean hasScreenBrightnessRampSlowIncreaseIdle() {
        if (this.screenBrightnessRampSlowIncreaseIdle != null) goto L6;
        return false;
    L6:
        return true;
    }

    public final void setScreenBrightnessRampSlowIncreaseIdle(BigDecimal screenBrightnessRampSlowIncreaseIdle) {
        this.screenBrightnessRampSlowIncreaseIdle = screenBrightnessRampSlowIncreaseIdle;
    }

    public final BigInteger getScreenBrightnessRampIncreaseMaxMillis() {
        return this.screenBrightnessRampIncreaseMaxMillis;
    }

    boolean hasScreenBrightnessRampIncreaseMaxMillis() {
        if (this.screenBrightnessRampIncreaseMaxMillis != null) goto L6;
        return false;
    L6:
        return true;
    }

    public final void setScreenBrightnessRampIncreaseMaxMillis(BigInteger screenBrightnessRampIncreaseMaxMillis) {
        this.screenBrightnessRampIncreaseMaxMillis = screenBrightnessRampIncreaseMaxMillis;
    }

    public final BigInteger getScreenBrightnessRampDecreaseMaxMillis() {
        return this.screenBrightnessRampDecreaseMaxMillis;
    }

    boolean hasScreenBrightnessRampDecreaseMaxMillis() {
        if (this.screenBrightnessRampDecreaseMaxMillis != null) goto L6;
        return false;
    L6:
        return true;
    }

    public final void setScreenBrightnessRampDecreaseMaxMillis(BigInteger screenBrightnessRampDecreaseMaxMillis) {
        this.screenBrightnessRampDecreaseMaxMillis = screenBrightnessRampDecreaseMaxMillis;
    }

    public final BigInteger getScreenBrightnessRampIncreaseMaxIdleMillis() {
        return this.screenBrightnessRampIncreaseMaxIdleMillis;
    }

    boolean hasScreenBrightnessRampIncreaseMaxIdleMillis() {
        if (this.screenBrightnessRampIncreaseMaxIdleMillis != null) goto L6;
        return false;
    L6:
        return true;
    }

    public final void setScreenBrightnessRampIncreaseMaxIdleMillis(BigInteger screenBrightnessRampIncreaseMaxIdleMillis) {
        this.screenBrightnessRampIncreaseMaxIdleMillis = screenBrightnessRampIncreaseMaxIdleMillis;
    }

    public final BigInteger getScreenBrightnessRampDecreaseMaxIdleMillis() {
        return this.screenBrightnessRampDecreaseMaxIdleMillis;
    }

    boolean hasScreenBrightnessRampDecreaseMaxIdleMillis() {
        if (this.screenBrightnessRampDecreaseMaxIdleMillis != null) goto L6;
        return false;
    L6:
        return true;
    }

    public final void setScreenBrightnessRampDecreaseMaxIdleMillis(BigInteger screenBrightnessRampDecreaseMaxIdleMillis) {
        this.screenBrightnessRampDecreaseMaxIdleMillis = screenBrightnessRampDecreaseMaxIdleMillis;
    }

    public final SensorDetails getLightSensor() {
        return this.lightSensor;
    }

    boolean hasLightSensor() {
        if (this.lightSensor != null) goto L6;
        return false;
    L6:
        return true;
    }

    public final void setLightSensor(SensorDetails lightSensor) {
        this.lightSensor = lightSensor;
    }

    public final SensorDetails getScreenOffBrightnessSensor() {
        return this.screenOffBrightnessSensor;
    }

    boolean hasScreenOffBrightnessSensor() {
        if (this.screenOffBrightnessSensor != null) goto L6;
        return false;
    L6:
        return true;
    }

    public final void setScreenOffBrightnessSensor(SensorDetails screenOffBrightnessSensor) {
        this.screenOffBrightnessSensor = screenOffBrightnessSensor;
    }

    public final List<SensorDetails> getProxSensor() {
        if (this.proxSensor != null) goto L6;
        this.proxSensor = new ArrayList();
    L6:
        return this.proxSensor;
    }

    public final SensorDetails getTempSensor() {
        return this.tempSensor;
    }

    boolean hasTempSensor() {
        if (this.tempSensor != null) goto L6;
        return false;
    L6:
        return true;
    }

    public final void setTempSensor(SensorDetails tempSensor) {
        this.tempSensor = tempSensor;
    }

    public final BigInteger getAmbientLightHorizonLong() {
        return this.ambientLightHorizonLong;
    }

    boolean hasAmbientLightHorizonLong() {
        if (this.ambientLightHorizonLong != null) goto L6;
        return false;
    L6:
        return true;
    }

    public final void setAmbientLightHorizonLong(BigInteger ambientLightHorizonLong) {
        this.ambientLightHorizonLong = ambientLightHorizonLong;
    }

    public final BigInteger getAmbientLightHorizonShort() {
        return this.ambientLightHorizonShort;
    }

    boolean hasAmbientLightHorizonShort() {
        if (this.ambientLightHorizonShort != null) goto L6;
        return false;
    L6:
        return true;
    }

    public final void setAmbientLightHorizonShort(BigInteger ambientLightHorizonShort) {
        this.ambientLightHorizonShort = ambientLightHorizonShort;
    }

    public final Thresholds getDisplayBrightnessChangeThresholds() {
        return this.displayBrightnessChangeThresholds;
    }

    boolean hasDisplayBrightnessChangeThresholds() {
        if (this.displayBrightnessChangeThresholds != null) goto L6;
        return false;
    L6:
        return true;
    }

    public final void setDisplayBrightnessChangeThresholds(Thresholds displayBrightnessChangeThresholds) {
        this.displayBrightnessChangeThresholds = displayBrightnessChangeThresholds;
    }

    public final Thresholds getAmbientBrightnessChangeThresholds() {
        return this.ambientBrightnessChangeThresholds;
    }

    boolean hasAmbientBrightnessChangeThresholds() {
        if (this.ambientBrightnessChangeThresholds != null) goto L6;
        return false;
    L6:
        return true;
    }

    public final void setAmbientBrightnessChangeThresholds(Thresholds ambientBrightnessChangeThresholds) {
        this.ambientBrightnessChangeThresholds = ambientBrightnessChangeThresholds;
    }

    public final Thresholds getDisplayBrightnessChangeThresholdsIdle() {
        return this.displayBrightnessChangeThresholdsIdle;
    }

    boolean hasDisplayBrightnessChangeThresholdsIdle() {
        if (this.displayBrightnessChangeThresholdsIdle != null) goto L6;
        return false;
    L6:
        return true;
    }

    public final void setDisplayBrightnessChangeThresholdsIdle(Thresholds displayBrightnessChangeThresholdsIdle) {
        this.displayBrightnessChangeThresholdsIdle = displayBrightnessChangeThresholdsIdle;
    }

    public final Thresholds getAmbientBrightnessChangeThresholdsIdle() {
        return this.ambientBrightnessChangeThresholdsIdle;
    }

    boolean hasAmbientBrightnessChangeThresholdsIdle() {
        if (this.ambientBrightnessChangeThresholdsIdle != null) goto L6;
        return false;
    L6:
        return true;
    }

    public final void setAmbientBrightnessChangeThresholdsIdle(Thresholds ambientBrightnessChangeThresholdsIdle) {
        this.ambientBrightnessChangeThresholdsIdle = ambientBrightnessChangeThresholdsIdle;
    }

    public final IntegerArray getScreenOffBrightnessSensorValueToLux() {
        return this.screenOffBrightnessSensorValueToLux;
    }

    boolean hasScreenOffBrightnessSensorValueToLux() {
        if (this.screenOffBrightnessSensorValueToLux != null) goto L6;
        return false;
    L6:
        return true;
    }

    public final void setScreenOffBrightnessSensorValueToLux(IntegerArray screenOffBrightnessSensorValueToLux) {
        this.screenOffBrightnessSensorValueToLux = screenOffBrightnessSensorValueToLux;
    }

    public final UsiVersion getUsiVersion() {
        return this.usiVersion;
    }

    boolean hasUsiVersion() {
        if (this.usiVersion != null) goto L6;
        return false;
    L6:
        return true;
    }

    public final void setUsiVersion(UsiVersion usiVersion) {
        this.usiVersion = usiVersion;
    }

    public final EvenDimmerMode getEvenDimmer() {
        return this.evenDimmer;
    }

    boolean hasEvenDimmer() {
        if (this.evenDimmer != null) goto L6;
        return false;
    L6:
        return true;
    }

    public final void setEvenDimmer(EvenDimmerMode evenDimmer) {
        this.evenDimmer = evenDimmer;
    }

    public final FullScreenAodMode getFullScreenAod() {
        return this.fullScreenAod;
    }

    boolean hasFullScreenAod() {
        if (this.fullScreenAod != null) goto L6;
        return false;
    L6:
        return true;
    }

    public final void setFullScreenAod(FullScreenAodMode fullScreenAod) {
        this.fullScreenAod = fullScreenAod;
    }

    public final BigDecimal getScreenBrightnessCapForWearBedtimeMode() {
        return this.screenBrightnessCapForWearBedtimeMode;
    }

    boolean hasScreenBrightnessCapForWearBedtimeMode() {
        if (this.screenBrightnessCapForWearBedtimeMode != null) goto L6;
        return false;
    L6:
        return true;
    }

    public final void setScreenBrightnessCapForWearBedtimeMode(BigDecimal screenBrightnessCapForWearBedtimeMode) {
        this.screenBrightnessCapForWearBedtimeMode = screenBrightnessCapForWearBedtimeMode;
    }

    public final IdleScreenRefreshRateTimeout getIdleScreenRefreshRateTimeout() {
        return this.idleScreenRefreshRateTimeout;
    }

    boolean hasIdleScreenRefreshRateTimeout() {
        if (this.idleScreenRefreshRateTimeout != null) goto L6;
        return false;
    L6:
        return true;
    }

    public final void setIdleScreenRefreshRateTimeout(IdleScreenRefreshRateTimeout idleScreenRefreshRateTimeout) {
        this.idleScreenRefreshRateTimeout = idleScreenRefreshRateTimeout;
    }

    public final boolean getSupportsVrr() {
        if (this.supportsVrr != null) goto L7;
        return false;
    L7:
        return this.supportsVrr.booleanValue();
    }

    boolean hasSupportsVrr() {
        if (this.supportsVrr != null) goto L6;
        return false;
    L6:
        return true;
    }

    public final void setSupportsVrr(boolean supportsVrr) {
        this.supportsVrr = Boolean.valueOf(supportsVrr);
    }

    public final FloatArray getDozeBrightnessSensorValueToBrightness() {
        return this.dozeBrightnessSensorValueToBrightness;
    }

    boolean hasDozeBrightnessSensorValueToBrightness() {
        if (this.dozeBrightnessSensorValueToBrightness != null) goto L6;
        return false;
    L6:
        return true;
    }

    public final void setDozeBrightnessSensorValueToBrightness(FloatArray dozeBrightnessSensorValueToBrightness) {
        this.dozeBrightnessSensorValueToBrightness = dozeBrightnessSensorValueToBrightness;
    }

    public final BigDecimal getDefaultDozeBrightness() {
        return this.defaultDozeBrightness;
    }

    boolean hasDefaultDozeBrightness() {
        if (this.defaultDozeBrightness != null) goto L6;
        return false;
    L6:
        return true;
    }

    public final void setDefaultDozeBrightness(BigDecimal defaultDozeBrightness) {
        this.defaultDozeBrightness = defaultDozeBrightness;
    }

    static DisplayConfiguration read(XmlPullParser _parser) throws XmlPullParserException, IOException, DatatypeConfigurationException {
        DisplayConfiguration _instance = new DisplayConfiguration();
        _parser.getDepth();
    L3:
        int type = _parser.next();
        if (type == 1) goto L134;
        if (type == 3) goto L134;
        if (_parser.getEventType() != 2) goto L3;
        String _tagName = _parser.getName();
        if (_tagName.equals("name") == true) goto L11;
        if (_tagName.equals("densityMapping") == true) goto L14;
        if (_tagName.equals("screenBrightnessMap") == true) goto L17;
        if (_tagName.equals("screenBrightnessDefault") == true) goto L20;
        if (_tagName.equals("thermalThrottling") == true) goto L23;
        if (_tagName.equals("powerThrottlingConfig") == true) goto L26;
        if (_tagName.equals("luxThrottling") == true) goto L29;
        if (_tagName.equals("highBrightnessMode") == true) goto L32;
        if (_tagName.equals("hdrBrightnessConfig") == true) goto L35;
        if (_tagName.equals("quirks") == true) goto L38;
        if (_tagName.equals("autoBrightness") == true) goto L41;
        if (_tagName.equals("refreshRate") == true) goto L44;
        if (_tagName.equals("screenBrightnessRampFastDecrease") == true) goto L47;
        if (_tagName.equals("screenBrightnessRampFastIncrease") == true) goto L50;
        if (_tagName.equals("screenBrightnessRampSlowDecrease") == true) goto L53;
        if (_tagName.equals("screenBrightnessRampSlowIncrease") == true) goto L56;
        if (_tagName.equals("screenBrightnessRampSlowDecreaseIdle") == true) goto L59;
        if (_tagName.equals("screenBrightnessRampSlowIncreaseIdle") == true) goto L62;
        if (_tagName.equals("screenBrightnessRampIncreaseMaxMillis") == true) goto L65;
        if (_tagName.equals("screenBrightnessRampDecreaseMaxMillis") == true) goto L68;
        if (_tagName.equals("screenBrightnessRampIncreaseMaxIdleMillis") == true) goto L71;
        if (_tagName.equals("screenBrightnessRampDecreaseMaxIdleMillis") == true) goto L74;
        if (_tagName.equals("lightSensor") == true) goto L77;
        if (_tagName.equals("screenOffBrightnessSensor") == true) goto L80;
        if (_tagName.equals("proxSensor") == true) goto L83;
        if (_tagName.equals("tempSensor") == true) goto L86;
        if (_tagName.equals("ambientLightHorizonLong") == true) goto L89;
        if (_tagName.equals("ambientLightHorizonShort") == true) goto L92;
        if (_tagName.equals("displayBrightnessChangeThresholds") == true) goto L95;
        if (_tagName.equals("ambientBrightnessChangeThresholds") == true) goto L98;
        if (_tagName.equals("displayBrightnessChangeThresholdsIdle") == true) goto L101;
        if (_tagName.equals("ambientBrightnessChangeThresholdsIdle") == true) goto L104;
        if (_tagName.equals("screenOffBrightnessSensorValueToLux") == true) goto L107;
        if (_tagName.equals("usiVersion") == true) goto L110;
        if (_tagName.equals("evenDimmer") == true) goto L113;
        if (_tagName.equals("fullScreenAod") == true) goto L116;
        if (_tagName.equals("screenBrightnessCapForWearBedtimeMode") == true) goto L119;
        if (_tagName.equals("idleScreenRefreshRateTimeout") == true) goto L122;
        if (_tagName.equals("supportsVrr") == true) goto L125;
        if (_tagName.equals("dozeBrightnessSensorValueToBrightness") == true) goto L128;
        if (_tagName.equals("defaultDozeBrightness") == true) goto L131;
        XmlParser.skip(_parser);
        goto L3
    L131:
        String _raw = XmlParser.readText(_parser);
        BigDecimal _value = new BigDecimal(_raw);
        _instance.setDefaultDozeBrightness(_value);
        goto L3
    L128:
        FloatArray _value2 = FloatArray.read(_parser);
        _instance.setDozeBrightnessSensorValueToBrightness(_value2);
        goto L3
    L125:
        String _raw2 = XmlParser.readText(_parser);
        boolean _value3 = Boolean.parseBoolean(_raw2);
        _instance.setSupportsVrr(_value3);
        goto L3
    L122:
        IdleScreenRefreshRateTimeout _value4 = IdleScreenRefreshRateTimeout.read(_parser);
        _instance.setIdleScreenRefreshRateTimeout(_value4);
        goto L3
    L119:
        String _raw3 = XmlParser.readText(_parser);
        BigDecimal _value5 = new BigDecimal(_raw3);
        _instance.setScreenBrightnessCapForWearBedtimeMode(_value5);
        goto L3
    L116:
        FullScreenAodMode _value6 = FullScreenAodMode.read(_parser);
        _instance.setFullScreenAod(_value6);
        goto L3
    L113:
        EvenDimmerMode _value7 = EvenDimmerMode.read(_parser);
        _instance.setEvenDimmer(_value7);
        goto L3
    L110:
        UsiVersion _value8 = UsiVersion.read(_parser);
        _instance.setUsiVersion(_value8);
        goto L3
    L107:
        IntegerArray _value9 = IntegerArray.read(_parser);
        _instance.setScreenOffBrightnessSensorValueToLux(_value9);
        goto L3
    L104:
        Thresholds _value10 = Thresholds.read(_parser);
        _instance.setAmbientBrightnessChangeThresholdsIdle(_value10);
        goto L3
    L101:
        Thresholds _value11 = Thresholds.read(_parser);
        _instance.setDisplayBrightnessChangeThresholdsIdle(_value11);
        goto L3
    L98:
        Thresholds _value12 = Thresholds.read(_parser);
        _instance.setAmbientBrightnessChangeThresholds(_value12);
        goto L3
    L95:
        Thresholds _value13 = Thresholds.read(_parser);
        _instance.setDisplayBrightnessChangeThresholds(_value13);
        goto L3
    L92:
        String _raw4 = XmlParser.readText(_parser);
        BigInteger _value14 = new BigInteger(_raw4);
        _instance.setAmbientLightHorizonShort(_value14);
        goto L3
    L89:
        String _raw5 = XmlParser.readText(_parser);
        BigInteger _value15 = new BigInteger(_raw5);
        _instance.setAmbientLightHorizonLong(_value15);
        goto L3
    L86:
        SensorDetails _value16 = SensorDetails.read(_parser);
        _instance.setTempSensor(_value16);
        goto L3
    L83:
        SensorDetails _value17 = SensorDetails.read(_parser);
        _instance.getProxSensor().add(_value17);
        goto L3
    L80:
        SensorDetails _value18 = SensorDetails.read(_parser);
        _instance.setScreenOffBrightnessSensor(_value18);
        goto L3
    L77:
        SensorDetails _value19 = SensorDetails.read(_parser);
        _instance.setLightSensor(_value19);
        goto L3
    L74:
        String _raw6 = XmlParser.readText(_parser);
        BigInteger _value20 = new BigInteger(_raw6);
        _instance.setScreenBrightnessRampDecreaseMaxIdleMillis(_value20);
        goto L3
    L71:
        String _raw7 = XmlParser.readText(_parser);
        BigInteger _value21 = new BigInteger(_raw7);
        _instance.setScreenBrightnessRampIncreaseMaxIdleMillis(_value21);
        goto L3
    L68:
        String _raw8 = XmlParser.readText(_parser);
        BigInteger _value22 = new BigInteger(_raw8);
        _instance.setScreenBrightnessRampDecreaseMaxMillis(_value22);
        goto L3
    L65:
        String _raw9 = XmlParser.readText(_parser);
        BigInteger _value23 = new BigInteger(_raw9);
        _instance.setScreenBrightnessRampIncreaseMaxMillis(_value23);
        goto L3
    L62:
        String _raw10 = XmlParser.readText(_parser);
        BigDecimal _value24 = new BigDecimal(_raw10);
        _instance.setScreenBrightnessRampSlowIncreaseIdle(_value24);
        goto L3
    L59:
        String _raw11 = XmlParser.readText(_parser);
        BigDecimal _value25 = new BigDecimal(_raw11);
        _instance.setScreenBrightnessRampSlowDecreaseIdle(_value25);
        goto L3
    L56:
        String _raw12 = XmlParser.readText(_parser);
        BigDecimal _value26 = new BigDecimal(_raw12);
        _instance.setScreenBrightnessRampSlowIncrease(_value26);
        goto L3
    L53:
        String _raw13 = XmlParser.readText(_parser);
        BigDecimal _value27 = new BigDecimal(_raw13);
        _instance.setScreenBrightnessRampSlowDecrease(_value27);
        goto L3
    L50:
        String _raw14 = XmlParser.readText(_parser);
        BigDecimal _value28 = new BigDecimal(_raw14);
        _instance.setScreenBrightnessRampFastIncrease(_value28);
        goto L3
    L47:
        String _raw15 = XmlParser.readText(_parser);
        BigDecimal _value29 = new BigDecimal(_raw15);
        _instance.setScreenBrightnessRampFastDecrease(_value29);
        goto L3
    L44:
        RefreshRateConfigs _value30 = RefreshRateConfigs.read(_parser);
        _instance.setRefreshRate(_value30);
        goto L3
    L41:
        AutoBrightness _value31 = AutoBrightness.read(_parser);
        _instance.setAutoBrightness(_value31);
        goto L3
    L38:
        DisplayQuirks _value32 = DisplayQuirks.read(_parser);
        _instance.setQuirks(_value32);
        goto L3
    L35:
        HdrBrightnessConfig _value33 = HdrBrightnessConfig.read(_parser);
        _instance.setHdrBrightnessConfig(_value33);
        goto L3
    L32:
        HighBrightnessMode _value34 = HighBrightnessMode.read(_parser);
        _instance.setHighBrightnessMode(_value34);
        goto L3
    L29:
        LuxThrottling _value35 = LuxThrottling.read(_parser);
        _instance.setLuxThrottling(_value35);
        goto L3
    L26:
        PowerThrottlingConfig _value36 = PowerThrottlingConfig.read(_parser);
        _instance.setPowerThrottlingConfig(_value36);
        goto L3
    L23:
        ThermalThrottling _value37 = ThermalThrottling.read(_parser);
        _instance.setThermalThrottling(_value37);
        goto L3
    L20:
        String _raw16 = XmlParser.readText(_parser);
        BigDecimal _value38 = new BigDecimal(_raw16);
        _instance.setScreenBrightnessDefault(_value38);
        goto L3
    L17:
        NitsMap _value39 = NitsMap.read(_parser);
        _instance.setScreenBrightnessMap(_value39);
        goto L3
    L14:
        DensityMapping _value40 = DensityMapping.read(_parser);
        _instance.setDensityMapping(_value40);
        goto L3
    L11:
        String _raw17 = XmlParser.readText(_parser);
        _instance.setName(_raw17);
    L134:
        if (type != 3) goto L137;
        return _instance;
    L137:
        throw new DatatypeConfigurationException("DisplayConfiguration is not closed");
    }
}
