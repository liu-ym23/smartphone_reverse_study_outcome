package android.hardware.tv.mediaquality;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes.dex */
public final class PictureParameter implements Parcelable {
    public static final Parcelable.Creator<PictureParameter> CREATOR = null;
    public static final int LdMode = 47;
    public static final int activeProfile = 79;
    public static final int autoPictureQualityEnabled = 24;
    public static final int autoSuperResolutionEnabled = 25;
    public static final int blueStretch = 20;
    public static final int brightness = 0;
    public static final int colorSpace = 33;
    public static final int colorTemperature = 22;
    public static final int colorTemperatureBlueGain = 39;
    public static final int colorTemperatureBlueOffset = 42;
    public static final int colorTemperatureGreenGain = 38;
    public static final int colorTemperatureGreenOffset = 41;
    public static final int colorTemperatureRedGain = 37;
    public static final int colorTemperatureRedOffset = 40;
    public static final int colorTune = 21;
    public static final int colorTunerBlueGain = 13;
    public static final int colorTunerBlueOffset = 10;
    public static final int colorTunerBrightness = 5;
    public static final int colorTunerGreenGain = 12;
    public static final int colorTunerGreenOffset = 9;
    public static final int colorTunerHue = 7;
    public static final int colorTunerHueBlue = 60;
    public static final int colorTunerHueCyan = 61;
    public static final int colorTunerHueFlesh = 64;
    public static final int colorTunerHueGreen = 59;
    public static final int colorTunerHueMagenta = 62;
    public static final int colorTunerHueRed = 58;
    public static final int colorTunerHueYellow = 63;
    public static final int colorTunerLuminanceBlue = 74;
    public static final int colorTunerLuminanceCyan = 75;
    public static final int colorTunerLuminanceFlesh = 78;
    public static final int colorTunerLuminanceGreen = 73;
    public static final int colorTunerLuminanceMagenta = 76;
    public static final int colorTunerLuminanceRed = 72;
    public static final int colorTunerLuminanceYellow = 77;
    public static final int colorTunerRedGain = 11;
    public static final int colorTunerRedOffset = 8;
    public static final int colorTunerSaturation = 6;
    public static final int colorTunerSaturationBlue = 67;
    public static final int colorTunerSaturationCyan = 68;
    public static final int colorTunerSaturationFlesh = 71;
    public static final int colorTunerSaturationGreen = 66;
    public static final int colorTunerSaturationMagenta = 69;
    public static final int colorTunerSaturationRed = 65;
    public static final int colorTunerSaturationYellow = 70;
    public static final int colorTunerSwitch = 57;
    public static final int contrast = 1;
    public static final int cvrr = 31;
    public static final int deContour = 17;
    public static final int dynamicLumaControl = 18;
    public static final int elevenPointBlue = 45;
    public static final int elevenPointGreen = 44;
    public static final int elevenPointRed = 43;
    public static final int filmMode = 19;
    public static final int fleshTone = 16;
    public static final int gamma = 36;
    public static final int gamutMapping = 27;
    public static final int globeDimming = 23;
    public static final int hdmiRgbRange = 32;
    public static final int hue = 4;
    public static final int levelRange = 26;
    public static final int lowBlueLight = 46;
    public static final int lowLatency = 29;
    public static final int mpegNoiseReduction = 15;
    public static final int noiseReduction = 14;
    public static final int osdBlueGain = 50;
    public static final int osdBlueOffset = 53;
    public static final int osdContrast = 56;
    public static final int osdGreenGain = 49;
    public static final int osdGreenOffset = 52;
    public static final int osdHue = 54;
    public static final int osdRedGain = 48;
    public static final int osdRedOffset = 51;
    public static final int osdSaturation = 55;
    public static final int panelInitMaxLuminceNits = 34;
    public static final int panelInitMaxLuminceValid = 35;
    public static final int pcMode = 28;
    public static final int pictureQualityEventType = 80;
    public static final int saturation = 3;
    public static final int sharpness = 2;
    public static final int vrr = 30;
    private int _tag;
    private Object _value;

    public @interface Tag {
        public static final int LdMode = 47;
        public static final int activeProfile = 79;
        public static final int autoPictureQualityEnabled = 24;
        public static final int autoSuperResolutionEnabled = 25;
        public static final int blueStretch = 20;
        public static final int brightness = 0;
        public static final int colorSpace = 33;
        public static final int colorTemperature = 22;
        public static final int colorTemperatureBlueGain = 39;
        public static final int colorTemperatureBlueOffset = 42;
        public static final int colorTemperatureGreenGain = 38;
        public static final int colorTemperatureGreenOffset = 41;
        public static final int colorTemperatureRedGain = 37;
        public static final int colorTemperatureRedOffset = 40;
        public static final int colorTune = 21;
        public static final int colorTunerBlueGain = 13;
        public static final int colorTunerBlueOffset = 10;
        public static final int colorTunerBrightness = 5;
        public static final int colorTunerGreenGain = 12;
        public static final int colorTunerGreenOffset = 9;
        public static final int colorTunerHue = 7;
        public static final int colorTunerHueBlue = 60;
        public static final int colorTunerHueCyan = 61;
        public static final int colorTunerHueFlesh = 64;
        public static final int colorTunerHueGreen = 59;
        public static final int colorTunerHueMagenta = 62;
        public static final int colorTunerHueRed = 58;
        public static final int colorTunerHueYellow = 63;
        public static final int colorTunerLuminanceBlue = 74;
        public static final int colorTunerLuminanceCyan = 75;
        public static final int colorTunerLuminanceFlesh = 78;
        public static final int colorTunerLuminanceGreen = 73;
        public static final int colorTunerLuminanceMagenta = 76;
        public static final int colorTunerLuminanceRed = 72;
        public static final int colorTunerLuminanceYellow = 77;
        public static final int colorTunerRedGain = 11;
        public static final int colorTunerRedOffset = 8;
        public static final int colorTunerSaturation = 6;
        public static final int colorTunerSaturationBlue = 67;
        public static final int colorTunerSaturationCyan = 68;
        public static final int colorTunerSaturationFlesh = 71;
        public static final int colorTunerSaturationGreen = 66;
        public static final int colorTunerSaturationMagenta = 69;
        public static final int colorTunerSaturationRed = 65;
        public static final int colorTunerSaturationYellow = 70;
        public static final int colorTunerSwitch = 57;
        public static final int contrast = 1;
        public static final int cvrr = 31;
        public static final int deContour = 17;
        public static final int dynamicLumaControl = 18;
        public static final int elevenPointBlue = 45;
        public static final int elevenPointGreen = 44;
        public static final int elevenPointRed = 43;
        public static final int filmMode = 19;
        public static final int fleshTone = 16;
        public static final int gamma = 36;
        public static final int gamutMapping = 27;
        public static final int globeDimming = 23;
        public static final int hdmiRgbRange = 32;
        public static final int hue = 4;
        public static final int levelRange = 26;
        public static final int lowBlueLight = 46;
        public static final int lowLatency = 29;
        public static final int mpegNoiseReduction = 15;
        public static final int noiseReduction = 14;
        public static final int osdBlueGain = 50;
        public static final int osdBlueOffset = 53;
        public static final int osdContrast = 56;
        public static final int osdGreenGain = 49;
        public static final int osdGreenOffset = 52;
        public static final int osdHue = 54;
        public static final int osdRedGain = 48;
        public static final int osdRedOffset = 51;
        public static final int osdSaturation = 55;
        public static final int panelInitMaxLuminceNits = 34;
        public static final int panelInitMaxLuminceValid = 35;
        public static final int pcMode = 28;
        public static final int pictureQualityEventType = 80;
        public static final int saturation = 3;
        public static final int sharpness = 2;
        public static final int vrr = 30;
    }

    /* synthetic */ PictureParameter(Parcel r1, PictureParameterIA r2) {
        this(r1);
    }

    public PictureParameter() {
        this._tag = 0;
        this._value = Float.valueOf(0.0f);
    }

    private PictureParameter(Parcel _aidl_parcel) {
        readFromParcel(_aidl_parcel);
    }

    private PictureParameter(int _tag, Object _value) {
        this._tag = _tag;
        this._value = _value;
    }

    public int getTag() {
        return this._tag;
    }

    public static PictureParameter brightness(float _value) {
        return new PictureParameter(0, Float.valueOf(_value));
    }

    public float getBrightness() {
        _assertTag(0);
        return ((Float) this._value).floatValue();
    }

    public void setBrightness(float _value) {
        _set(0, Float.valueOf(_value));
    }

    public static PictureParameter contrast(int _value) {
        return new PictureParameter(1, Integer.valueOf(_value));
    }

    public int getContrast() {
        _assertTag(1);
        return ((Integer) this._value).intValue();
    }

    public void setContrast(int _value) {
        _set(1, Integer.valueOf(_value));
    }

    public static PictureParameter sharpness(int _value) {
        return new PictureParameter(2, Integer.valueOf(_value));
    }

    public int getSharpness() {
        _assertTag(2);
        return ((Integer) this._value).intValue();
    }

    public void setSharpness(int _value) {
        _set(2, Integer.valueOf(_value));
    }

    public static PictureParameter saturation(int _value) {
        return new PictureParameter(3, Integer.valueOf(_value));
    }

    public int getSaturation() {
        _assertTag(3);
        return ((Integer) this._value).intValue();
    }

    public void setSaturation(int _value) {
        _set(3, Integer.valueOf(_value));
    }

    public static PictureParameter hue(int _value) {
        return new PictureParameter(4, Integer.valueOf(_value));
    }

    public int getHue() {
        _assertTag(4);
        return ((Integer) this._value).intValue();
    }

    public void setHue(int _value) {
        _set(4, Integer.valueOf(_value));
    }

    public static PictureParameter colorTunerBrightness(int _value) {
        return new PictureParameter(5, Integer.valueOf(_value));
    }

    public int getColorTunerBrightness() {
        _assertTag(5);
        return ((Integer) this._value).intValue();
    }

    public void setColorTunerBrightness(int _value) {
        _set(5, Integer.valueOf(_value));
    }

    public static PictureParameter colorTunerSaturation(int _value) {
        return new PictureParameter(6, Integer.valueOf(_value));
    }

    public int getColorTunerSaturation() {
        _assertTag(6);
        return ((Integer) this._value).intValue();
    }

    public void setColorTunerSaturation(int _value) {
        _set(6, Integer.valueOf(_value));
    }

    public static PictureParameter colorTunerHue(int _value) {
        return new PictureParameter(7, Integer.valueOf(_value));
    }

    public int getColorTunerHue() {
        _assertTag(7);
        return ((Integer) this._value).intValue();
    }

    public void setColorTunerHue(int _value) {
        _set(7, Integer.valueOf(_value));
    }

    public static PictureParameter colorTunerRedOffset(int _value) {
        return new PictureParameter(8, Integer.valueOf(_value));
    }

    public int getColorTunerRedOffset() {
        _assertTag(8);
        return ((Integer) this._value).intValue();
    }

    public void setColorTunerRedOffset(int _value) {
        _set(8, Integer.valueOf(_value));
    }

    public static PictureParameter colorTunerGreenOffset(int _value) {
        return new PictureParameter(9, Integer.valueOf(_value));
    }

    public int getColorTunerGreenOffset() {
        _assertTag(9);
        return ((Integer) this._value).intValue();
    }

    public void setColorTunerGreenOffset(int _value) {
        _set(9, Integer.valueOf(_value));
    }

    public static PictureParameter colorTunerBlueOffset(int _value) {
        return new PictureParameter(10, Integer.valueOf(_value));
    }

    public int getColorTunerBlueOffset() {
        _assertTag(10);
        return ((Integer) this._value).intValue();
    }

    public void setColorTunerBlueOffset(int _value) {
        _set(10, Integer.valueOf(_value));
    }

    public static PictureParameter colorTunerRedGain(int _value) {
        return new PictureParameter(11, Integer.valueOf(_value));
    }

    public int getColorTunerRedGain() {
        _assertTag(11);
        return ((Integer) this._value).intValue();
    }

    public void setColorTunerRedGain(int _value) {
        _set(11, Integer.valueOf(_value));
    }

    public static PictureParameter colorTunerGreenGain(int _value) {
        return new PictureParameter(12, Integer.valueOf(_value));
    }

    public int getColorTunerGreenGain() {
        _assertTag(12);
        return ((Integer) this._value).intValue();
    }

    public void setColorTunerGreenGain(int _value) {
        _set(12, Integer.valueOf(_value));
    }

    public static PictureParameter colorTunerBlueGain(int _value) {
        return new PictureParameter(13, Integer.valueOf(_value));
    }

    public int getColorTunerBlueGain() {
        _assertTag(13);
        return ((Integer) this._value).intValue();
    }

    public void setColorTunerBlueGain(int _value) {
        _set(13, Integer.valueOf(_value));
    }

    public static PictureParameter noiseReduction(byte _value) {
        return new PictureParameter(14, Byte.valueOf(_value));
    }

    public byte getNoiseReduction() {
        _assertTag(14);
        return ((Byte) this._value).byteValue();
    }

    public void setNoiseReduction(byte _value) {
        _set(14, Byte.valueOf(_value));
    }

    public static PictureParameter mpegNoiseReduction(byte _value) {
        return new PictureParameter(15, Byte.valueOf(_value));
    }

    public byte getMpegNoiseReduction() {
        _assertTag(15);
        return ((Byte) this._value).byteValue();
    }

    public void setMpegNoiseReduction(byte _value) {
        _set(15, Byte.valueOf(_value));
    }

    public static PictureParameter fleshTone(byte _value) {
        return new PictureParameter(16, Byte.valueOf(_value));
    }

    public byte getFleshTone() {
        _assertTag(16);
        return ((Byte) this._value).byteValue();
    }

    public void setFleshTone(byte _value) {
        _set(16, Byte.valueOf(_value));
    }

    public static PictureParameter deContour(byte _value) {
        return new PictureParameter(17, Byte.valueOf(_value));
    }

    public byte getDeContour() {
        _assertTag(17);
        return ((Byte) this._value).byteValue();
    }

    public void setDeContour(byte _value) {
        _set(17, Byte.valueOf(_value));
    }

    public static PictureParameter dynamicLumaControl(byte _value) {
        return new PictureParameter(18, Byte.valueOf(_value));
    }

    public byte getDynamicLumaControl() {
        _assertTag(18);
        return ((Byte) this._value).byteValue();
    }

    public void setDynamicLumaControl(byte _value) {
        _set(18, Byte.valueOf(_value));
    }

    public static PictureParameter filmMode(boolean _value) {
        return new PictureParameter(19, Boolean.valueOf(_value));
    }

    public boolean getFilmMode() {
        _assertTag(19);
        return ((Boolean) this._value).booleanValue();
    }

    public void setFilmMode(boolean _value) {
        _set(19, Boolean.valueOf(_value));
    }

    public static PictureParameter blueStretch(boolean _value) {
        return new PictureParameter(20, Boolean.valueOf(_value));
    }

    public boolean getBlueStretch() {
        _assertTag(20);
        return ((Boolean) this._value).booleanValue();
    }

    public void setBlueStretch(boolean _value) {
        _set(20, Boolean.valueOf(_value));
    }

    public static PictureParameter colorTune(boolean _value) {
        return new PictureParameter(21, Boolean.valueOf(_value));
    }

    public boolean getColorTune() {
        _assertTag(21);
        return ((Boolean) this._value).booleanValue();
    }

    public void setColorTune(boolean _value) {
        _set(21, Boolean.valueOf(_value));
    }

    public static PictureParameter colorTemperature(byte _value) {
        return new PictureParameter(22, Byte.valueOf(_value));
    }

    public byte getColorTemperature() {
        _assertTag(22);
        return ((Byte) this._value).byteValue();
    }

    public void setColorTemperature(byte _value) {
        _set(22, Byte.valueOf(_value));
    }

    public static PictureParameter globeDimming(boolean _value) {
        return new PictureParameter(23, Boolean.valueOf(_value));
    }

    public boolean getGlobeDimming() {
        _assertTag(23);
        return ((Boolean) this._value).booleanValue();
    }

    public void setGlobeDimming(boolean _value) {
        _set(23, Boolean.valueOf(_value));
    }

    public static PictureParameter autoPictureQualityEnabled(boolean _value) {
        return new PictureParameter(24, Boolean.valueOf(_value));
    }

    public boolean getAutoPictureQualityEnabled() {
        _assertTag(24);
        return ((Boolean) this._value).booleanValue();
    }

    public void setAutoPictureQualityEnabled(boolean _value) {
        _set(24, Boolean.valueOf(_value));
    }

    public static PictureParameter autoSuperResolutionEnabled(boolean _value) {
        return new PictureParameter(25, Boolean.valueOf(_value));
    }

    public boolean getAutoSuperResolutionEnabled() {
        _assertTag(25);
        return ((Boolean) this._value).booleanValue();
    }

    public void setAutoSuperResolutionEnabled(boolean _value) {
        _set(25, Boolean.valueOf(_value));
    }

    public static PictureParameter levelRange(byte _value) {
        return new PictureParameter(26, Byte.valueOf(_value));
    }

    public byte getLevelRange() {
        _assertTag(26);
        return ((Byte) this._value).byteValue();
    }

    public void setLevelRange(byte _value) {
        _set(26, Byte.valueOf(_value));
    }

    public static PictureParameter gamutMapping(boolean _value) {
        return new PictureParameter(27, Boolean.valueOf(_value));
    }

    public boolean getGamutMapping() {
        _assertTag(27);
        return ((Boolean) this._value).booleanValue();
    }

    public void setGamutMapping(boolean _value) {
        _set(27, Boolean.valueOf(_value));
    }

    public static PictureParameter pcMode(boolean _value) {
        return new PictureParameter(28, Boolean.valueOf(_value));
    }

    public boolean getPcMode() {
        _assertTag(28);
        return ((Boolean) this._value).booleanValue();
    }

    public void setPcMode(boolean _value) {
        _set(28, Boolean.valueOf(_value));
    }

    public static PictureParameter lowLatency(boolean _value) {
        return new PictureParameter(29, Boolean.valueOf(_value));
    }

    public boolean getLowLatency() {
        _assertTag(29);
        return ((Boolean) this._value).booleanValue();
    }

    public void setLowLatency(boolean _value) {
        _set(29, Boolean.valueOf(_value));
    }

    public static PictureParameter vrr(boolean _value) {
        return new PictureParameter(30, Boolean.valueOf(_value));
    }

    public boolean getVrr() {
        _assertTag(30);
        return ((Boolean) this._value).booleanValue();
    }

    public void setVrr(boolean _value) {
        _set(30, Boolean.valueOf(_value));
    }

    public static PictureParameter cvrr(boolean _value) {
        return new PictureParameter(31, Boolean.valueOf(_value));
    }

    public boolean getCvrr() {
        _assertTag(31);
        return ((Boolean) this._value).booleanValue();
    }

    public void setCvrr(boolean _value) {
        _set(31, Boolean.valueOf(_value));
    }

    public static PictureParameter hdmiRgbRange(byte _value) {
        return new PictureParameter(32, Byte.valueOf(_value));
    }

    public byte getHdmiRgbRange() {
        _assertTag(32);
        return ((Byte) this._value).byteValue();
    }

    public void setHdmiRgbRange(byte _value) {
        _set(32, Byte.valueOf(_value));
    }

    public static PictureParameter colorSpace(byte _value) {
        return new PictureParameter(33, Byte.valueOf(_value));
    }

    public byte getColorSpace() {
        _assertTag(33);
        return ((Byte) this._value).byteValue();
    }

    public void setColorSpace(byte _value) {
        _set(33, Byte.valueOf(_value));
    }

    public static PictureParameter panelInitMaxLuminceNits(int _value) {
        return new PictureParameter(34, Integer.valueOf(_value));
    }

    public int getPanelInitMaxLuminceNits() {
        _assertTag(34);
        return ((Integer) this._value).intValue();
    }

    public void setPanelInitMaxLuminceNits(int _value) {
        _set(34, Integer.valueOf(_value));
    }

    public static PictureParameter panelInitMaxLuminceValid(boolean _value) {
        return new PictureParameter(35, Boolean.valueOf(_value));
    }

    public boolean getPanelInitMaxLuminceValid() {
        _assertTag(35);
        return ((Boolean) this._value).booleanValue();
    }

    public void setPanelInitMaxLuminceValid(boolean _value) {
        _set(35, Boolean.valueOf(_value));
    }

    public static PictureParameter gamma(byte _value) {
        return new PictureParameter(36, Byte.valueOf(_value));
    }

    public byte getGamma() {
        _assertTag(36);
        return ((Byte) this._value).byteValue();
    }

    public void setGamma(byte _value) {
        _set(36, Byte.valueOf(_value));
    }

    public static PictureParameter colorTemperatureRedGain(int _value) {
        return new PictureParameter(37, Integer.valueOf(_value));
    }

    public int getColorTemperatureRedGain() {
        _assertTag(37);
        return ((Integer) this._value).intValue();
    }

    public void setColorTemperatureRedGain(int _value) {
        _set(37, Integer.valueOf(_value));
    }

    public static PictureParameter colorTemperatureGreenGain(int _value) {
        return new PictureParameter(38, Integer.valueOf(_value));
    }

    public int getColorTemperatureGreenGain() {
        _assertTag(38);
        return ((Integer) this._value).intValue();
    }

    public void setColorTemperatureGreenGain(int _value) {
        _set(38, Integer.valueOf(_value));
    }

    public static PictureParameter colorTemperatureBlueGain(int _value) {
        return new PictureParameter(39, Integer.valueOf(_value));
    }

    public int getColorTemperatureBlueGain() {
        _assertTag(39);
        return ((Integer) this._value).intValue();
    }

    public void setColorTemperatureBlueGain(int _value) {
        _set(39, Integer.valueOf(_value));
    }

    public static PictureParameter colorTemperatureRedOffset(int _value) {
        return new PictureParameter(40, Integer.valueOf(_value));
    }

    public int getColorTemperatureRedOffset() {
        _assertTag(40);
        return ((Integer) this._value).intValue();
    }

    public void setColorTemperatureRedOffset(int _value) {
        _set(40, Integer.valueOf(_value));
    }

    public static PictureParameter colorTemperatureGreenOffset(int _value) {
        return new PictureParameter(41, Integer.valueOf(_value));
    }

    public int getColorTemperatureGreenOffset() {
        _assertTag(41);
        return ((Integer) this._value).intValue();
    }

    public void setColorTemperatureGreenOffset(int _value) {
        _set(41, Integer.valueOf(_value));
    }

    public static PictureParameter colorTemperatureBlueOffset(int _value) {
        return new PictureParameter(42, Integer.valueOf(_value));
    }

    public int getColorTemperatureBlueOffset() {
        _assertTag(42);
        return ((Integer) this._value).intValue();
    }

    public void setColorTemperatureBlueOffset(int _value) {
        _set(42, Integer.valueOf(_value));
    }

    public static PictureParameter elevenPointRed(int[] _value) {
        return new PictureParameter(43, _value);
    }

    public int[] getElevenPointRed() {
        _assertTag(43);
        return (int[]) this._value;
    }

    public void setElevenPointRed(int[] _value) {
        _set(43, _value);
    }

    public static PictureParameter elevenPointGreen(int[] _value) {
        return new PictureParameter(44, _value);
    }

    public int[] getElevenPointGreen() {
        _assertTag(44);
        return (int[]) this._value;
    }

    public void setElevenPointGreen(int[] _value) {
        _set(44, _value);
    }

    public static PictureParameter elevenPointBlue(int[] _value) {
        return new PictureParameter(45, _value);
    }

    public int[] getElevenPointBlue() {
        _assertTag(45);
        return (int[]) this._value;
    }

    public void setElevenPointBlue(int[] _value) {
        _set(45, _value);
    }

    public static PictureParameter lowBlueLight(byte _value) {
        return new PictureParameter(46, Byte.valueOf(_value));
    }

    public byte getLowBlueLight() {
        _assertTag(46);
        return ((Byte) this._value).byteValue();
    }

    public void setLowBlueLight(byte _value) {
        _set(46, Byte.valueOf(_value));
    }

    public static PictureParameter LdMode(byte _value) {
        return new PictureParameter(47, Byte.valueOf(_value));
    }

    public byte getLdMode() {
        _assertTag(47);
        return ((Byte) this._value).byteValue();
    }

    public void setLdMode(byte _value) {
        _set(47, Byte.valueOf(_value));
    }

    public static PictureParameter osdRedGain(int _value) {
        return new PictureParameter(48, Integer.valueOf(_value));
    }

    public int getOsdRedGain() {
        _assertTag(48);
        return ((Integer) this._value).intValue();
    }

    public void setOsdRedGain(int _value) {
        _set(48, Integer.valueOf(_value));
    }

    public static PictureParameter osdGreenGain(int _value) {
        return new PictureParameter(49, Integer.valueOf(_value));
    }

    public int getOsdGreenGain() {
        _assertTag(49);
        return ((Integer) this._value).intValue();
    }

    public void setOsdGreenGain(int _value) {
        _set(49, Integer.valueOf(_value));
    }

    public static PictureParameter osdBlueGain(int _value) {
        return new PictureParameter(50, Integer.valueOf(_value));
    }

    public int getOsdBlueGain() {
        _assertTag(50);
        return ((Integer) this._value).intValue();
    }

    public void setOsdBlueGain(int _value) {
        _set(50, Integer.valueOf(_value));
    }

    public static PictureParameter osdRedOffset(int _value) {
        return new PictureParameter(51, Integer.valueOf(_value));
    }

    public int getOsdRedOffset() {
        _assertTag(51);
        return ((Integer) this._value).intValue();
    }

    public void setOsdRedOffset(int _value) {
        _set(51, Integer.valueOf(_value));
    }

    public static PictureParameter osdGreenOffset(int _value) {
        return new PictureParameter(52, Integer.valueOf(_value));
    }

    public int getOsdGreenOffset() {
        _assertTag(52);
        return ((Integer) this._value).intValue();
    }

    public void setOsdGreenOffset(int _value) {
        _set(52, Integer.valueOf(_value));
    }

    public static PictureParameter osdBlueOffset(int _value) {
        return new PictureParameter(53, Integer.valueOf(_value));
    }

    public int getOsdBlueOffset() {
        _assertTag(53);
        return ((Integer) this._value).intValue();
    }

    public void setOsdBlueOffset(int _value) {
        _set(53, Integer.valueOf(_value));
    }

    public static PictureParameter osdHue(int _value) {
        return new PictureParameter(54, Integer.valueOf(_value));
    }

    public int getOsdHue() {
        _assertTag(54);
        return ((Integer) this._value).intValue();
    }

    public void setOsdHue(int _value) {
        _set(54, Integer.valueOf(_value));
    }

    public static PictureParameter osdSaturation(int _value) {
        return new PictureParameter(55, Integer.valueOf(_value));
    }

    public int getOsdSaturation() {
        _assertTag(55);
        return ((Integer) this._value).intValue();
    }

    public void setOsdSaturation(int _value) {
        _set(55, Integer.valueOf(_value));
    }

    public static PictureParameter osdContrast(int _value) {
        return new PictureParameter(56, Integer.valueOf(_value));
    }

    public int getOsdContrast() {
        _assertTag(56);
        return ((Integer) this._value).intValue();
    }

    public void setOsdContrast(int _value) {
        _set(56, Integer.valueOf(_value));
    }

    public static PictureParameter colorTunerSwitch(boolean _value) {
        return new PictureParameter(57, Boolean.valueOf(_value));
    }

    public boolean getColorTunerSwitch() {
        _assertTag(57);
        return ((Boolean) this._value).booleanValue();
    }

    public void setColorTunerSwitch(boolean _value) {
        _set(57, Boolean.valueOf(_value));
    }

    public static PictureParameter colorTunerHueRed(int _value) {
        return new PictureParameter(58, Integer.valueOf(_value));
    }

    public int getColorTunerHueRed() {
        _assertTag(58);
        return ((Integer) this._value).intValue();
    }

    public void setColorTunerHueRed(int _value) {
        _set(58, Integer.valueOf(_value));
    }

    public static PictureParameter colorTunerHueGreen(int _value) {
        return new PictureParameter(59, Integer.valueOf(_value));
    }

    public int getColorTunerHueGreen() {
        _assertTag(59);
        return ((Integer) this._value).intValue();
    }

    public void setColorTunerHueGreen(int _value) {
        _set(59, Integer.valueOf(_value));
    }

    public static PictureParameter colorTunerHueBlue(int _value) {
        return new PictureParameter(60, Integer.valueOf(_value));
    }

    public int getColorTunerHueBlue() {
        _assertTag(60);
        return ((Integer) this._value).intValue();
    }

    public void setColorTunerHueBlue(int _value) {
        _set(60, Integer.valueOf(_value));
    }

    public static PictureParameter colorTunerHueCyan(int _value) {
        return new PictureParameter(61, Integer.valueOf(_value));
    }

    public int getColorTunerHueCyan() {
        _assertTag(61);
        return ((Integer) this._value).intValue();
    }

    public void setColorTunerHueCyan(int _value) {
        _set(61, Integer.valueOf(_value));
    }

    public static PictureParameter colorTunerHueMagenta(int _value) {
        return new PictureParameter(62, Integer.valueOf(_value));
    }

    public int getColorTunerHueMagenta() {
        _assertTag(62);
        return ((Integer) this._value).intValue();
    }

    public void setColorTunerHueMagenta(int _value) {
        _set(62, Integer.valueOf(_value));
    }

    public static PictureParameter colorTunerHueYellow(int _value) {
        return new PictureParameter(63, Integer.valueOf(_value));
    }

    public int getColorTunerHueYellow() {
        _assertTag(63);
        return ((Integer) this._value).intValue();
    }

    public void setColorTunerHueYellow(int _value) {
        _set(63, Integer.valueOf(_value));
    }

    public static PictureParameter colorTunerHueFlesh(int _value) {
        return new PictureParameter(64, Integer.valueOf(_value));
    }

    public int getColorTunerHueFlesh() {
        _assertTag(64);
        return ((Integer) this._value).intValue();
    }

    public void setColorTunerHueFlesh(int _value) {
        _set(64, Integer.valueOf(_value));
    }

    public static PictureParameter colorTunerSaturationRed(int _value) {
        return new PictureParameter(65, Integer.valueOf(_value));
    }

    public int getColorTunerSaturationRed() {
        _assertTag(65);
        return ((Integer) this._value).intValue();
    }

    public void setColorTunerSaturationRed(int _value) {
        _set(65, Integer.valueOf(_value));
    }

    public static PictureParameter colorTunerSaturationGreen(int _value) {
        return new PictureParameter(66, Integer.valueOf(_value));
    }

    public int getColorTunerSaturationGreen() {
        _assertTag(66);
        return ((Integer) this._value).intValue();
    }

    public void setColorTunerSaturationGreen(int _value) {
        _set(66, Integer.valueOf(_value));
    }

    public static PictureParameter colorTunerSaturationBlue(int _value) {
        return new PictureParameter(67, Integer.valueOf(_value));
    }

    public int getColorTunerSaturationBlue() {
        _assertTag(67);
        return ((Integer) this._value).intValue();
    }

    public void setColorTunerSaturationBlue(int _value) {
        _set(67, Integer.valueOf(_value));
    }

    public static PictureParameter colorTunerSaturationCyan(int _value) {
        return new PictureParameter(68, Integer.valueOf(_value));
    }

    public int getColorTunerSaturationCyan() {
        _assertTag(68);
        return ((Integer) this._value).intValue();
    }

    public void setColorTunerSaturationCyan(int _value) {
        _set(68, Integer.valueOf(_value));
    }

    public static PictureParameter colorTunerSaturationMagenta(int _value) {
        return new PictureParameter(69, Integer.valueOf(_value));
    }

    public int getColorTunerSaturationMagenta() {
        _assertTag(69);
        return ((Integer) this._value).intValue();
    }

    public void setColorTunerSaturationMagenta(int _value) {
        _set(69, Integer.valueOf(_value));
    }

    public static PictureParameter colorTunerSaturationYellow(int _value) {
        return new PictureParameter(70, Integer.valueOf(_value));
    }

    public int getColorTunerSaturationYellow() {
        _assertTag(70);
        return ((Integer) this._value).intValue();
    }

    public void setColorTunerSaturationYellow(int _value) {
        _set(70, Integer.valueOf(_value));
    }

    public static PictureParameter colorTunerSaturationFlesh(int _value) {
        return new PictureParameter(71, Integer.valueOf(_value));
    }

    public int getColorTunerSaturationFlesh() {
        _assertTag(71);
        return ((Integer) this._value).intValue();
    }

    public void setColorTunerSaturationFlesh(int _value) {
        _set(71, Integer.valueOf(_value));
    }

    public static PictureParameter colorTunerLuminanceRed(int _value) {
        return new PictureParameter(72, Integer.valueOf(_value));
    }

    public int getColorTunerLuminanceRed() {
        _assertTag(72);
        return ((Integer) this._value).intValue();
    }

    public void setColorTunerLuminanceRed(int _value) {
        _set(72, Integer.valueOf(_value));
    }

    public static PictureParameter colorTunerLuminanceGreen(int _value) {
        return new PictureParameter(73, Integer.valueOf(_value));
    }

    public int getColorTunerLuminanceGreen() {
        _assertTag(73);
        return ((Integer) this._value).intValue();
    }

    public void setColorTunerLuminanceGreen(int _value) {
        _set(73, Integer.valueOf(_value));
    }

    public static PictureParameter colorTunerLuminanceBlue(int _value) {
        return new PictureParameter(74, Integer.valueOf(_value));
    }

    public int getColorTunerLuminanceBlue() {
        _assertTag(74);
        return ((Integer) this._value).intValue();
    }

    public void setColorTunerLuminanceBlue(int _value) {
        _set(74, Integer.valueOf(_value));
    }

    public static PictureParameter colorTunerLuminanceCyan(int _value) {
        return new PictureParameter(75, Integer.valueOf(_value));
    }

    public int getColorTunerLuminanceCyan() {
        _assertTag(75);
        return ((Integer) this._value).intValue();
    }

    public void setColorTunerLuminanceCyan(int _value) {
        _set(75, Integer.valueOf(_value));
    }

    public static PictureParameter colorTunerLuminanceMagenta(int _value) {
        return new PictureParameter(76, Integer.valueOf(_value));
    }

    public int getColorTunerLuminanceMagenta() {
        _assertTag(76);
        return ((Integer) this._value).intValue();
    }

    public void setColorTunerLuminanceMagenta(int _value) {
        _set(76, Integer.valueOf(_value));
    }

    public static PictureParameter colorTunerLuminanceYellow(int _value) {
        return new PictureParameter(77, Integer.valueOf(_value));
    }

    public int getColorTunerLuminanceYellow() {
        _assertTag(77);
        return ((Integer) this._value).intValue();
    }

    public void setColorTunerLuminanceYellow(int _value) {
        _set(77, Integer.valueOf(_value));
    }

    public static PictureParameter colorTunerLuminanceFlesh(int _value) {
        return new PictureParameter(78, Integer.valueOf(_value));
    }

    public int getColorTunerLuminanceFlesh() {
        _assertTag(78);
        return ((Integer) this._value).intValue();
    }

    public void setColorTunerLuminanceFlesh(int _value) {
        _set(78, Integer.valueOf(_value));
    }

    public static PictureParameter activeProfile(boolean _value) {
        return new PictureParameter(79, Boolean.valueOf(_value));
    }

    public boolean getActiveProfile() {
        _assertTag(79);
        return ((Boolean) this._value).booleanValue();
    }

    public void setActiveProfile(boolean _value) {
        _set(79, Boolean.valueOf(_value));
    }

    public static PictureParameter pictureQualityEventType(byte _value) {
        return new PictureParameter(80, Byte.valueOf(_value));
    }

    public byte getPictureQualityEventType() {
        _assertTag(80);
        return ((Byte) this._value).byteValue();
    }

    public void setPictureQualityEventType(byte _value) {
        _set(80, Byte.valueOf(_value));
    }

    public final int getStability() {
        return 1;
    }

    static {
        CREATOR = new AnonymousClass1();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel _aidl_parcel, int _aidl_flag) {
        _aidl_parcel.writeInt(this._tag);
        switch(this._tag) {
            case 0: goto L85;
            case 1: goto L84;
            case 2: goto L83;
            case 3: goto L82;
            case 4: goto L81;
            case 5: goto L80;
            case 6: goto L79;
            case 7: goto L78;
            case 8: goto L77;
            case 9: goto L76;
            case 10: goto L75;
            case 11: goto L74;
            case 12: goto L73;
            case 13: goto L72;
            case 14: goto L71;
            case 15: goto L70;
            case 16: goto L69;
            case 17: goto L68;
            case 18: goto L67;
            case 19: goto L66;
            case 20: goto L65;
            case 21: goto L64;
            case 22: goto L63;
            case 23: goto L62;
            case 24: goto L61;
            case 25: goto L60;
            case 26: goto L59;
            case 27: goto L58;
            case 28: goto L57;
            case 29: goto L56;
            case 30: goto L55;
            case 31: goto L54;
            case 32: goto L53;
            case 33: goto L52;
            case 34: goto L51;
            case 35: goto L50;
            case 36: goto L49;
            case 37: goto L48;
            case 38: goto L47;
            case 39: goto L46;
            case 40: goto L45;
            case 41: goto L44;
            case 42: goto L43;
            case 43: goto L42;
            case 44: goto L41;
            case 45: goto L40;
            case 46: goto L39;
            case 47: goto L38;
            case 48: goto L37;
            case 49: goto L36;
            case 50: goto L35;
            case 51: goto L34;
            case 52: goto L33;
            case 53: goto L32;
            case 54: goto L31;
            case 55: goto L30;
            case 56: goto L29;
            case 57: goto L28;
            case 58: goto L27;
            case 59: goto L26;
            case 60: goto L25;
            case 61: goto L24;
            case 62: goto L23;
            case 63: goto L22;
            case 64: goto L21;
            case 65: goto L20;
            case 66: goto L19;
            case 67: goto L18;
            case 68: goto L17;
            case 69: goto L16;
            case 70: goto L15;
            case 71: goto L14;
            case 72: goto L13;
            case 73: goto L12;
            case 74: goto L11;
            case 75: goto L10;
            case 76: goto L9;
            case 77: goto L8;
            case 78: goto L7;
            case 79: goto L6;
            case 80: goto L5;
            default: goto L167;
        };
    L5:
        _aidl_parcel.writeByte(getPictureQualityEventType());
        return;
    L6:
        _aidl_parcel.writeBoolean(getActiveProfile());
        return;
    L7:
        _aidl_parcel.writeInt(getColorTunerLuminanceFlesh());
        return;
    L8:
        _aidl_parcel.writeInt(getColorTunerLuminanceYellow());
        return;
    L9:
        _aidl_parcel.writeInt(getColorTunerLuminanceMagenta());
        return;
    L10:
        _aidl_parcel.writeInt(getColorTunerLuminanceCyan());
        return;
    L11:
        _aidl_parcel.writeInt(getColorTunerLuminanceBlue());
        return;
    L12:
        _aidl_parcel.writeInt(getColorTunerLuminanceGreen());
        return;
    L13:
        _aidl_parcel.writeInt(getColorTunerLuminanceRed());
        return;
    L14:
        _aidl_parcel.writeInt(getColorTunerSaturationFlesh());
        return;
    L15:
        _aidl_parcel.writeInt(getColorTunerSaturationYellow());
        return;
    L16:
        _aidl_parcel.writeInt(getColorTunerSaturationMagenta());
        return;
    L17:
        _aidl_parcel.writeInt(getColorTunerSaturationCyan());
        return;
    L18:
        _aidl_parcel.writeInt(getColorTunerSaturationBlue());
        return;
    L19:
        _aidl_parcel.writeInt(getColorTunerSaturationGreen());
        return;
    L20:
        _aidl_parcel.writeInt(getColorTunerSaturationRed());
        return;
    L21:
        _aidl_parcel.writeInt(getColorTunerHueFlesh());
        return;
    L22:
        _aidl_parcel.writeInt(getColorTunerHueYellow());
        return;
    L23:
        _aidl_parcel.writeInt(getColorTunerHueMagenta());
        return;
    L24:
        _aidl_parcel.writeInt(getColorTunerHueCyan());
        return;
    L25:
        _aidl_parcel.writeInt(getColorTunerHueBlue());
        return;
    L26:
        _aidl_parcel.writeInt(getColorTunerHueGreen());
        return;
    L27:
        _aidl_parcel.writeInt(getColorTunerHueRed());
        return;
    L28:
        _aidl_parcel.writeBoolean(getColorTunerSwitch());
        return;
    L29:
        _aidl_parcel.writeInt(getOsdContrast());
        return;
    L30:
        _aidl_parcel.writeInt(getOsdSaturation());
        return;
    L31:
        _aidl_parcel.writeInt(getOsdHue());
        return;
    L32:
        _aidl_parcel.writeInt(getOsdBlueOffset());
        return;
    L33:
        _aidl_parcel.writeInt(getOsdGreenOffset());
        return;
    L34:
        _aidl_parcel.writeInt(getOsdRedOffset());
        return;
    L35:
        _aidl_parcel.writeInt(getOsdBlueGain());
        return;
    L36:
        _aidl_parcel.writeInt(getOsdGreenGain());
        return;
    L37:
        _aidl_parcel.writeInt(getOsdRedGain());
        return;
    L38:
        _aidl_parcel.writeByte(getLdMode());
        return;
    L39:
        _aidl_parcel.writeByte(getLowBlueLight());
        return;
    L40:
        _aidl_parcel.writeFixedArray(getElevenPointBlue(), _aidl_flag, new int[]{11});
        return;
    L41:
        _aidl_parcel.writeFixedArray(getElevenPointGreen(), _aidl_flag, new int[]{11});
        return;
    L42:
        _aidl_parcel.writeFixedArray(getElevenPointRed(), _aidl_flag, new int[]{11});
        return;
    L43:
        _aidl_parcel.writeInt(getColorTemperatureBlueOffset());
        return;
    L44:
        _aidl_parcel.writeInt(getColorTemperatureGreenOffset());
        return;
    L45:
        _aidl_parcel.writeInt(getColorTemperatureRedOffset());
        return;
    L46:
        _aidl_parcel.writeInt(getColorTemperatureBlueGain());
        return;
    L47:
        _aidl_parcel.writeInt(getColorTemperatureGreenGain());
        return;
    L48:
        _aidl_parcel.writeInt(getColorTemperatureRedGain());
        return;
    L49:
        _aidl_parcel.writeByte(getGamma());
        return;
    L50:
        _aidl_parcel.writeBoolean(getPanelInitMaxLuminceValid());
        return;
    L51:
        _aidl_parcel.writeInt(getPanelInitMaxLuminceNits());
        return;
    L52:
        _aidl_parcel.writeByte(getColorSpace());
        return;
    L53:
        _aidl_parcel.writeByte(getHdmiRgbRange());
        return;
    L54:
        _aidl_parcel.writeBoolean(getCvrr());
        return;
    L55:
        _aidl_parcel.writeBoolean(getVrr());
        return;
    L56:
        _aidl_parcel.writeBoolean(getLowLatency());
        return;
    L57:
        _aidl_parcel.writeBoolean(getPcMode());
        return;
    L58:
        _aidl_parcel.writeBoolean(getGamutMapping());
        return;
    L59:
        _aidl_parcel.writeByte(getLevelRange());
        return;
    L60:
        _aidl_parcel.writeBoolean(getAutoSuperResolutionEnabled());
        return;
    L61:
        _aidl_parcel.writeBoolean(getAutoPictureQualityEnabled());
        return;
    L62:
        _aidl_parcel.writeBoolean(getGlobeDimming());
        return;
    L63:
        _aidl_parcel.writeByte(getColorTemperature());
        return;
    L64:
        _aidl_parcel.writeBoolean(getColorTune());
        return;
    L65:
        _aidl_parcel.writeBoolean(getBlueStretch());
        return;
    L66:
        _aidl_parcel.writeBoolean(getFilmMode());
        return;
    L67:
        _aidl_parcel.writeByte(getDynamicLumaControl());
        return;
    L68:
        _aidl_parcel.writeByte(getDeContour());
        return;
    L69:
        _aidl_parcel.writeByte(getFleshTone());
        return;
    L70:
        _aidl_parcel.writeByte(getMpegNoiseReduction());
        return;
    L71:
        _aidl_parcel.writeByte(getNoiseReduction());
        return;
    L72:
        _aidl_parcel.writeInt(getColorTunerBlueGain());
        return;
    L73:
        _aidl_parcel.writeInt(getColorTunerGreenGain());
        return;
    L74:
        _aidl_parcel.writeInt(getColorTunerRedGain());
        return;
    L75:
        _aidl_parcel.writeInt(getColorTunerBlueOffset());
        return;
    L76:
        _aidl_parcel.writeInt(getColorTunerGreenOffset());
        return;
    L77:
        _aidl_parcel.writeInt(getColorTunerRedOffset());
        return;
    L78:
        _aidl_parcel.writeInt(getColorTunerHue());
        return;
    L79:
        _aidl_parcel.writeInt(getColorTunerSaturation());
        return;
    L80:
        _aidl_parcel.writeInt(getColorTunerBrightness());
        return;
    L81:
        _aidl_parcel.writeInt(getHue());
        return;
    L82:
        _aidl_parcel.writeInt(getSaturation());
        return;
    L83:
        _aidl_parcel.writeInt(getSharpness());
        return;
    L84:
        _aidl_parcel.writeInt(getContrast());
        return;
    L85:
        _aidl_parcel.writeFloat(getBrightness());
        return;
    }

    public void readFromParcel(Parcel _aidl_parcel) {
        int _aidl_tag = _aidl_parcel.readInt();
        switch(_aidl_tag) {
            case 0: goto L166;
            case 1: goto L164;
            case 2: goto L162;
            case 3: goto L160;
            case 4: goto L158;
            case 5: goto L156;
            case 6: goto L154;
            case 7: goto L152;
            case 8: goto L150;
            case 9: goto L148;
            case 10: goto L146;
            case 11: goto L144;
            case 12: goto L142;
            case 13: goto L140;
            case 14: goto L138;
            case 15: goto L136;
            case 16: goto L134;
            case 17: goto L132;
            case 18: goto L130;
            case 19: goto L128;
            case 20: goto L126;
            case 21: goto L124;
            case 22: goto L122;
            case 23: goto L120;
            case 24: goto L118;
            case 25: goto L116;
            case 26: goto L114;
            case 27: goto L112;
            case 28: goto L110;
            case 29: goto L108;
            case 30: goto L106;
            case 31: goto L104;
            case 32: goto L102;
            case 33: goto L100;
            case 34: goto L98;
            case 35: goto L96;
            case 36: goto L94;
            case 37: goto L92;
            case 38: goto L90;
            case 39: goto L88;
            case 40: goto L86;
            case 41: goto L84;
            case 42: goto L82;
            case 43: goto L80;
            case 44: goto L78;
            case 45: goto L76;
            case 46: goto L74;
            case 47: goto L72;
            case 48: goto L70;
            case 49: goto L68;
            case 50: goto L66;
            case 51: goto L64;
            case 52: goto L62;
            case 53: goto L60;
            case 54: goto L58;
            case 55: goto L56;
            case 56: goto L54;
            case 57: goto L52;
            case 58: goto L50;
            case 59: goto L48;
            case 60: goto L46;
            case 61: goto L44;
            case 62: goto L42;
            case 63: goto L40;
            case 64: goto L38;
            case 65: goto L36;
            case 66: goto L34;
            case 67: goto L32;
            case 68: goto L30;
            case 69: goto L28;
            case 70: goto L26;
            case 71: goto L24;
            case 72: goto L22;
            case 73: goto L20;
            case 74: goto L18;
            case 75: goto L16;
            case 76: goto L14;
            case 77: goto L12;
            case 78: goto L10;
            case 79: goto L8;
            case 80: goto L6;
            default: goto L5;
        };
    L6:
        byte _aidl_value = _aidl_parcel.readByte();
        _set(_aidl_tag, Byte.valueOf(_aidl_value));
        return;
    L8:
        boolean _aidl_value2 = _aidl_parcel.readBoolean();
        _set(_aidl_tag, Boolean.valueOf(_aidl_value2));
        return;
    L10:
        int _aidl_value3 = _aidl_parcel.readInt();
        _set(_aidl_tag, Integer.valueOf(_aidl_value3));
        return;
    L12:
        int _aidl_value4 = _aidl_parcel.readInt();
        _set(_aidl_tag, Integer.valueOf(_aidl_value4));
        return;
    L14:
        int _aidl_value5 = _aidl_parcel.readInt();
        _set(_aidl_tag, Integer.valueOf(_aidl_value5));
        return;
    L16:
        int _aidl_value6 = _aidl_parcel.readInt();
        _set(_aidl_tag, Integer.valueOf(_aidl_value6));
        return;
    L18:
        int _aidl_value7 = _aidl_parcel.readInt();
        _set(_aidl_tag, Integer.valueOf(_aidl_value7));
        return;
    L20:
        int _aidl_value8 = _aidl_parcel.readInt();
        _set(_aidl_tag, Integer.valueOf(_aidl_value8));
        return;
    L22:
        int _aidl_value9 = _aidl_parcel.readInt();
        _set(_aidl_tag, Integer.valueOf(_aidl_value9));
        return;
    L24:
        int _aidl_value10 = _aidl_parcel.readInt();
        _set(_aidl_tag, Integer.valueOf(_aidl_value10));
        return;
    L26:
        int _aidl_value11 = _aidl_parcel.readInt();
        _set(_aidl_tag, Integer.valueOf(_aidl_value11));
        return;
    L28:
        int _aidl_value12 = _aidl_parcel.readInt();
        _set(_aidl_tag, Integer.valueOf(_aidl_value12));
        return;
    L30:
        int _aidl_value13 = _aidl_parcel.readInt();
        _set(_aidl_tag, Integer.valueOf(_aidl_value13));
        return;
    L32:
        int _aidl_value14 = _aidl_parcel.readInt();
        _set(_aidl_tag, Integer.valueOf(_aidl_value14));
        return;
    L34:
        int _aidl_value15 = _aidl_parcel.readInt();
        _set(_aidl_tag, Integer.valueOf(_aidl_value15));
        return;
    L36:
        int _aidl_value16 = _aidl_parcel.readInt();
        _set(_aidl_tag, Integer.valueOf(_aidl_value16));
        return;
    L38:
        int _aidl_value17 = _aidl_parcel.readInt();
        _set(_aidl_tag, Integer.valueOf(_aidl_value17));
        return;
    L40:
        int _aidl_value18 = _aidl_parcel.readInt();
        _set(_aidl_tag, Integer.valueOf(_aidl_value18));
        return;
    L42:
        int _aidl_value19 = _aidl_parcel.readInt();
        _set(_aidl_tag, Integer.valueOf(_aidl_value19));
        return;
    L44:
        int _aidl_value20 = _aidl_parcel.readInt();
        _set(_aidl_tag, Integer.valueOf(_aidl_value20));
        return;
    L46:
        int _aidl_value21 = _aidl_parcel.readInt();
        _set(_aidl_tag, Integer.valueOf(_aidl_value21));
        return;
    L48:
        int _aidl_value22 = _aidl_parcel.readInt();
        _set(_aidl_tag, Integer.valueOf(_aidl_value22));
        return;
    L50:
        int _aidl_value23 = _aidl_parcel.readInt();
        _set(_aidl_tag, Integer.valueOf(_aidl_value23));
        return;
    L52:
        boolean _aidl_value24 = _aidl_parcel.readBoolean();
        _set(_aidl_tag, Boolean.valueOf(_aidl_value24));
        return;
    L54:
        int _aidl_value25 = _aidl_parcel.readInt();
        _set(_aidl_tag, Integer.valueOf(_aidl_value25));
        return;
    L56:
        int _aidl_value26 = _aidl_parcel.readInt();
        _set(_aidl_tag, Integer.valueOf(_aidl_value26));
        return;
    L58:
        int _aidl_value27 = _aidl_parcel.readInt();
        _set(_aidl_tag, Integer.valueOf(_aidl_value27));
        return;
    L60:
        int _aidl_value28 = _aidl_parcel.readInt();
        _set(_aidl_tag, Integer.valueOf(_aidl_value28));
        return;
    L62:
        int _aidl_value29 = _aidl_parcel.readInt();
        _set(_aidl_tag, Integer.valueOf(_aidl_value29));
        return;
    L64:
        int _aidl_value30 = _aidl_parcel.readInt();
        _set(_aidl_tag, Integer.valueOf(_aidl_value30));
        return;
    L66:
        int _aidl_value31 = _aidl_parcel.readInt();
        _set(_aidl_tag, Integer.valueOf(_aidl_value31));
        return;
    L68:
        int _aidl_value32 = _aidl_parcel.readInt();
        _set(_aidl_tag, Integer.valueOf(_aidl_value32));
        return;
    L70:
        int _aidl_value33 = _aidl_parcel.readInt();
        _set(_aidl_tag, Integer.valueOf(_aidl_value33));
        return;
    L72:
        byte _aidl_value34 = _aidl_parcel.readByte();
        _set(_aidl_tag, Byte.valueOf(_aidl_value34));
        return;
    L74:
        byte _aidl_value35 = _aidl_parcel.readByte();
        _set(_aidl_tag, Byte.valueOf(_aidl_value35));
        return;
    L76:
        int[] _aidl_value36 = (int[]) _aidl_parcel.createFixedArray(int[].class, new int[]{11});
        _set(_aidl_tag, _aidl_value36);
        return;
    L78:
        int[] _aidl_value37 = {11};
        _set(_aidl_tag, (int[]) _aidl_parcel.createFixedArray(int[].class, _aidl_value37));
        return;
    L80:
        int[] _aidl_value38 = {11};
        _set(_aidl_tag, (int[]) _aidl_parcel.createFixedArray(int[].class, _aidl_value38));
        return;
    L82:
        int _aidl_value39 = _aidl_parcel.readInt();
        _set(_aidl_tag, Integer.valueOf(_aidl_value39));
        return;
    L84:
        int _aidl_value40 = _aidl_parcel.readInt();
        _set(_aidl_tag, Integer.valueOf(_aidl_value40));
        return;
    L86:
        int _aidl_value41 = _aidl_parcel.readInt();
        _set(_aidl_tag, Integer.valueOf(_aidl_value41));
        return;
    L88:
        int _aidl_value42 = _aidl_parcel.readInt();
        _set(_aidl_tag, Integer.valueOf(_aidl_value42));
        return;
    L90:
        int _aidl_value43 = _aidl_parcel.readInt();
        _set(_aidl_tag, Integer.valueOf(_aidl_value43));
        return;
    L92:
        int _aidl_value44 = _aidl_parcel.readInt();
        _set(_aidl_tag, Integer.valueOf(_aidl_value44));
        return;
    L94:
        byte _aidl_value45 = _aidl_parcel.readByte();
        _set(_aidl_tag, Byte.valueOf(_aidl_value45));
        return;
    L96:
        boolean _aidl_value46 = _aidl_parcel.readBoolean();
        _set(_aidl_tag, Boolean.valueOf(_aidl_value46));
        return;
    L98:
        int _aidl_value47 = _aidl_parcel.readInt();
        _set(_aidl_tag, Integer.valueOf(_aidl_value47));
        return;
    L100:
        byte _aidl_value48 = _aidl_parcel.readByte();
        _set(_aidl_tag, Byte.valueOf(_aidl_value48));
        return;
    L102:
        byte _aidl_value49 = _aidl_parcel.readByte();
        _set(_aidl_tag, Byte.valueOf(_aidl_value49));
        return;
    L104:
        boolean _aidl_value50 = _aidl_parcel.readBoolean();
        _set(_aidl_tag, Boolean.valueOf(_aidl_value50));
        return;
    L106:
        boolean _aidl_value51 = _aidl_parcel.readBoolean();
        _set(_aidl_tag, Boolean.valueOf(_aidl_value51));
        return;
    L108:
        boolean _aidl_value52 = _aidl_parcel.readBoolean();
        _set(_aidl_tag, Boolean.valueOf(_aidl_value52));
        return;
    L110:
        boolean _aidl_value53 = _aidl_parcel.readBoolean();
        _set(_aidl_tag, Boolean.valueOf(_aidl_value53));
        return;
    L112:
        boolean _aidl_value54 = _aidl_parcel.readBoolean();
        _set(_aidl_tag, Boolean.valueOf(_aidl_value54));
        return;
    L114:
        byte _aidl_value55 = _aidl_parcel.readByte();
        _set(_aidl_tag, Byte.valueOf(_aidl_value55));
        return;
    L116:
        boolean _aidl_value56 = _aidl_parcel.readBoolean();
        _set(_aidl_tag, Boolean.valueOf(_aidl_value56));
        return;
    L118:
        boolean _aidl_value57 = _aidl_parcel.readBoolean();
        _set(_aidl_tag, Boolean.valueOf(_aidl_value57));
        return;
    L120:
        boolean _aidl_value58 = _aidl_parcel.readBoolean();
        _set(_aidl_tag, Boolean.valueOf(_aidl_value58));
        return;
    L122:
        byte _aidl_value59 = _aidl_parcel.readByte();
        _set(_aidl_tag, Byte.valueOf(_aidl_value59));
        return;
    L124:
        boolean _aidl_value60 = _aidl_parcel.readBoolean();
        _set(_aidl_tag, Boolean.valueOf(_aidl_value60));
        return;
    L126:
        boolean _aidl_value61 = _aidl_parcel.readBoolean();
        _set(_aidl_tag, Boolean.valueOf(_aidl_value61));
        return;
    L128:
        boolean _aidl_value62 = _aidl_parcel.readBoolean();
        _set(_aidl_tag, Boolean.valueOf(_aidl_value62));
        return;
    L130:
        byte _aidl_value63 = _aidl_parcel.readByte();
        _set(_aidl_tag, Byte.valueOf(_aidl_value63));
        return;
    L132:
        byte _aidl_value64 = _aidl_parcel.readByte();
        _set(_aidl_tag, Byte.valueOf(_aidl_value64));
        return;
    L134:
        byte _aidl_value65 = _aidl_parcel.readByte();
        _set(_aidl_tag, Byte.valueOf(_aidl_value65));
        return;
    L136:
        byte _aidl_value66 = _aidl_parcel.readByte();
        _set(_aidl_tag, Byte.valueOf(_aidl_value66));
        return;
    L138:
        byte _aidl_value67 = _aidl_parcel.readByte();
        _set(_aidl_tag, Byte.valueOf(_aidl_value67));
        return;
    L140:
        int _aidl_value68 = _aidl_parcel.readInt();
        _set(_aidl_tag, Integer.valueOf(_aidl_value68));
        return;
    L142:
        int _aidl_value69 = _aidl_parcel.readInt();
        _set(_aidl_tag, Integer.valueOf(_aidl_value69));
        return;
    L144:
        int _aidl_value70 = _aidl_parcel.readInt();
        _set(_aidl_tag, Integer.valueOf(_aidl_value70));
        return;
    L146:
        int _aidl_value71 = _aidl_parcel.readInt();
        _set(_aidl_tag, Integer.valueOf(_aidl_value71));
        return;
    L148:
        int _aidl_value72 = _aidl_parcel.readInt();
        _set(_aidl_tag, Integer.valueOf(_aidl_value72));
        return;
    L150:
        int _aidl_value73 = _aidl_parcel.readInt();
        _set(_aidl_tag, Integer.valueOf(_aidl_value73));
        return;
    L152:
        int _aidl_value74 = _aidl_parcel.readInt();
        _set(_aidl_tag, Integer.valueOf(_aidl_value74));
        return;
    L154:
        int _aidl_value75 = _aidl_parcel.readInt();
        _set(_aidl_tag, Integer.valueOf(_aidl_value75));
        return;
    L156:
        int _aidl_value76 = _aidl_parcel.readInt();
        _set(_aidl_tag, Integer.valueOf(_aidl_value76));
        return;
    L158:
        int _aidl_value77 = _aidl_parcel.readInt();
        _set(_aidl_tag, Integer.valueOf(_aidl_value77));
        return;
    L160:
        int _aidl_value78 = _aidl_parcel.readInt();
        _set(_aidl_tag, Integer.valueOf(_aidl_value78));
        return;
    L162:
        int _aidl_value79 = _aidl_parcel.readInt();
        _set(_aidl_tag, Integer.valueOf(_aidl_value79));
        return;
    L164:
        int _aidl_value80 = _aidl_parcel.readInt();
        _set(_aidl_tag, Integer.valueOf(_aidl_value80));
        return;
    L166:
        float _aidl_value81 = _aidl_parcel.readFloat();
        _set(_aidl_tag, Float.valueOf(_aidl_value81));
        return;
    L5:
        throw new IllegalArgumentException("union: unknown tag: " + _aidl_tag);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        getTag();
        return 0;
    }

    private void _assertTag(int tag) {
        if (getTag() != tag) goto L6;
        return;
    L6:
        throw new IllegalStateException("bad access: " + _tagString(tag) + ", " + _tagString(getTag()) + " is available.");
    }

    private String _tagString(int _tag) {
        switch(_tag) {
            case 0: goto L165;
            case 1: goto L163;
            case 2: goto L161;
            case 3: goto L159;
            case 4: goto L157;
            case 5: goto L155;
            case 6: goto L153;
            case 7: goto L151;
            case 8: goto L149;
            case 9: goto L147;
            case 10: goto L145;
            case 11: goto L143;
            case 12: goto L141;
            case 13: goto L139;
            case 14: goto L137;
            case 15: goto L135;
            case 16: goto L133;
            case 17: goto L131;
            case 18: goto L129;
            case 19: goto L127;
            case 20: goto L125;
            case 21: goto L123;
            case 22: goto L121;
            case 23: goto L119;
            case 24: goto L117;
            case 25: goto L115;
            case 26: goto L113;
            case 27: goto L111;
            case 28: goto L109;
            case 29: goto L107;
            case 30: goto L105;
            case 31: goto L103;
            case 32: goto L101;
            case 33: goto L99;
            case 34: goto L97;
            case 35: goto L95;
            case 36: goto L93;
            case 37: goto L91;
            case 38: goto L89;
            case 39: goto L87;
            case 40: goto L85;
            case 41: goto L83;
            case 42: goto L81;
            case 43: goto L79;
            case 44: goto L77;
            case 45: goto L75;
            case 46: goto L73;
            case 47: goto L71;
            case 48: goto L69;
            case 49: goto L67;
            case 50: goto L65;
            case 51: goto L63;
            case 52: goto L61;
            case 53: goto L59;
            case 54: goto L57;
            case 55: goto L55;
            case 56: goto L53;
            case 57: goto L51;
            case 58: goto L49;
            case 59: goto L47;
            case 60: goto L45;
            case 61: goto L43;
            case 62: goto L41;
            case 63: goto L39;
            case 64: goto L37;
            case 65: goto L35;
            case 66: goto L33;
            case 67: goto L31;
            case 68: goto L29;
            case 69: goto L27;
            case 70: goto L25;
            case 71: goto L23;
            case 72: goto L21;
            case 73: goto L19;
            case 74: goto L17;
            case 75: goto L15;
            case 76: goto L13;
            case 77: goto L11;
            case 78: goto L9;
            case 79: goto L7;
            case 80: goto L5;
            default: goto L4;
        };
    L5:
        return "pictureQualityEventType";
    L7:
        return "activeProfile";
    L9:
        return "colorTunerLuminanceFlesh";
    L11:
        return "colorTunerLuminanceYellow";
    L13:
        return "colorTunerLuminanceMagenta";
    L15:
        return "colorTunerLuminanceCyan";
    L17:
        return "colorTunerLuminanceBlue";
    L19:
        return "colorTunerLuminanceGreen";
    L21:
        return "colorTunerLuminanceRed";
    L23:
        return "colorTunerSaturationFlesh";
    L25:
        return "colorTunerSaturationYellow";
    L27:
        return "colorTunerSaturationMagenta";
    L29:
        return "colorTunerSaturationCyan";
    L31:
        return "colorTunerSaturationBlue";
    L33:
        return "colorTunerSaturationGreen";
    L35:
        return "colorTunerSaturationRed";
    L37:
        return "colorTunerHueFlesh";
    L39:
        return "colorTunerHueYellow";
    L41:
        return "colorTunerHueMagenta";
    L43:
        return "colorTunerHueCyan";
    L45:
        return "colorTunerHueBlue";
    L47:
        return "colorTunerHueGreen";
    L49:
        return "colorTunerHueRed";
    L51:
        return "colorTunerSwitch";
    L53:
        return "osdContrast";
    L55:
        return "osdSaturation";
    L57:
        return "osdHue";
    L59:
        return "osdBlueOffset";
    L61:
        return "osdGreenOffset";
    L63:
        return "osdRedOffset";
    L65:
        return "osdBlueGain";
    L67:
        return "osdGreenGain";
    L69:
        return "osdRedGain";
    L71:
        return "LdMode";
    L73:
        return "lowBlueLight";
    L75:
        return "elevenPointBlue";
    L77:
        return "elevenPointGreen";
    L79:
        return "elevenPointRed";
    L81:
        return "colorTemperatureBlueOffset";
    L83:
        return "colorTemperatureGreenOffset";
    L85:
        return "colorTemperatureRedOffset";
    L87:
        return "colorTemperatureBlueGain";
    L89:
        return "colorTemperatureGreenGain";
    L91:
        return "colorTemperatureRedGain";
    L93:
        return "gamma";
    L95:
        return "panelInitMaxLuminceValid";
    L97:
        return "panelInitMaxLuminceNits";
    L99:
        return "colorSpace";
    L101:
        return "hdmiRgbRange";
    L103:
        return "cvrr";
    L105:
        return "vrr";
    L107:
        return "lowLatency";
    L109:
        return "pcMode";
    L111:
        return "gamutMapping";
    L113:
        return "levelRange";
    L115:
        return "autoSuperResolutionEnabled";
    L117:
        return "autoPictureQualityEnabled";
    L119:
        return "globeDimming";
    L121:
        return "colorTemperature";
    L123:
        return "colorTune";
    L125:
        return "blueStretch";
    L127:
        return "filmMode";
    L129:
        return "dynamicLumaControl";
    L131:
        return "deContour";
    L133:
        return "fleshTone";
    L135:
        return "mpegNoiseReduction";
    L137:
        return "noiseReduction";
    L139:
        return "colorTunerBlueGain";
    L141:
        return "colorTunerGreenGain";
    L143:
        return "colorTunerRedGain";
    L145:
        return "colorTunerBlueOffset";
    L147:
        return "colorTunerGreenOffset";
    L149:
        return "colorTunerRedOffset";
    L151:
        return "colorTunerHue";
    L153:
        return "colorTunerSaturation";
    L155:
        return "colorTunerBrightness";
    L157:
        return "hue";
    L159:
        return "saturation";
    L161:
        return "sharpness";
    L163:
        return "contrast";
    L165:
        return "brightness";
    L4:
        throw new IllegalStateException("unknown field: " + _tag);
    }

    private void _set(int _tag, Object _value) {
        this._tag = _tag;
        this._value = _value;
    }
}
