package com.android.server.media.quality;

import android.content.ContentValues;
import android.database.Cursor;
import android.hardware.tv.mediaquality.DolbyAudioProcessing;
import android.hardware.tv.mediaquality.DtsVirtualX;
import android.hardware.tv.mediaquality.ParameterName;
import android.hardware.tv.mediaquality.ParameterRange;
import android.hardware.tv.mediaquality.PictureParameter;
import android.hardware.tv.mediaquality.SoundParameter;
import android.media.quality.PictureProfile;
import android.media.quality.PictureProfileHandle;
import android.media.quality.SoundProfile;
import android.media.quality.SoundProfileHandle;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.util.Log;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class MediaQualityUtils {
    private static final int MAX_UUID_GENERATION_ATTEMPTS = 10;
    public static final String SETTINGS = "settings";
    public static final SoundProfileHandle SOUND_PROFILE_HANDLE_NONE = null;
    private static final String TAG = "MediaQualityUtils";

    static {
        SOUND_PROFILE_HANDLE_NONE = new SoundProfileHandle();
        SOUND_PROFILE_HANDLE_NONE.id = -10000;
    }

    public static PersistableBundle convertPictureParameterListToPersistableBundle(PictureParameter[] parameters) {
        PersistableBundle bundle = new PersistableBundle();
        int r1 = parameters.length;
        int r2 = 0;
    L3:
        if (r2 >= r1) goto L245;
        PictureParameter pp = parameters[r2];
        if (pp.getBrightness() <= (-1.0f)) goto L8;
        bundle.putLong("brightness", (long) pp.getBrightness());
    L8:
        if (pp.getContrast() <= (-1)) goto L11;
        bundle.putInt("contrast", pp.getContrast());
    L11:
        if (pp.getSharpness() <= (-1)) goto L14;
        bundle.putInt("sharpness", pp.getSharpness());
    L14:
        if (pp.getSaturation() <= (-1)) goto L17;
        bundle.putInt("saturation", pp.getSaturation());
    L17:
        if (pp.getHue() <= (-1)) goto L20;
        bundle.putInt("hue", pp.getHue());
    L20:
        if (pp.getColorTunerBrightness() <= (-1)) goto L23;
        bundle.putInt("color_tuner_brightness", pp.getColorTunerBrightness());
    L23:
        if (pp.getColorTunerSaturation() <= (-1)) goto L26;
        bundle.putInt("color_tuner_saturation", pp.getColorTunerSaturation());
    L26:
        if (pp.getColorTunerHue() <= (-1)) goto L29;
        bundle.putInt("color_tuner_hue", pp.getColorTunerHue());
    L29:
        if (pp.getColorTunerRedOffset() <= (-1)) goto L32;
        bundle.putInt("color_tuner_red_offset", pp.getColorTunerRedOffset());
    L32:
        if (pp.getColorTunerGreenOffset() <= (-1)) goto L35;
        bundle.putInt("color_tuner_green_offset", pp.getColorTunerGreenOffset());
    L35:
        if (pp.getColorTunerBlueOffset() <= (-1)) goto L38;
        bundle.putInt("color_tuner_blue_offset", pp.getColorTunerBlueOffset());
    L38:
        if (pp.getColorTunerRedGain() <= (-1)) goto L41;
        bundle.putInt("color_tuner_red_gain", pp.getColorTunerRedGain());
    L41:
        if (pp.getColorTunerGreenGain() <= (-1)) goto L44;
        bundle.putInt("color_tuner_green_gain", pp.getColorTunerGreenGain());
    L44:
        if (pp.getColorTunerBlueGain() <= (-1)) goto L47;
        bundle.putInt("color_tuner_blue_gain", pp.getColorTunerBlueGain());
    L47:
        if (pp.getNoiseReduction() <= (-1)) goto L50;
        bundle.putInt("noise_reduction", pp.getNoiseReduction());
    L50:
        if (pp.getMpegNoiseReduction() <= (-1)) goto L53;
        bundle.putInt("mpeg_noise_reduction", pp.getMpegNoiseReduction());
    L53:
        if (pp.getFleshTone() <= (-1)) goto L56;
        bundle.putInt("flesh_tone", pp.getFleshTone());
    L56:
        if (pp.getDeContour() <= (-1)) goto L59;
        bundle.putInt("decontour", pp.getDeContour());
    L59:
        if (pp.getDynamicLumaControl() <= (-1)) goto L62;
        bundle.putInt("dynamic_luma_control", pp.getDynamicLumaControl());
    L62:
        if (pp.getColorTemperature() <= (-1)) goto L65;
        bundle.putInt("color_temperature", pp.getColorTemperature());
    L65:
        if (pp.getColorTemperatureRedGain() <= (-1)) goto L68;
        bundle.putInt("color_tuner_red_gain", pp.getColorTemperatureRedGain());
    L68:
        if (pp.getColorTemperatureGreenGain() <= (-1)) goto L71;
        bundle.putInt("color_tuner_green_gain", pp.getColorTemperatureGreenGain());
    L71:
        if (pp.getColorTemperatureBlueGain() <= (-1)) goto L74;
        bundle.putInt("color_tuner_blue_gain", pp.getColorTemperatureBlueGain());
    L74:
        if (pp.getLevelRange() <= (-1)) goto L77;
        bundle.putInt("level_range", pp.getLevelRange());
    L77:
        if (pp.getHdmiRgbRange() <= (-1)) goto L80;
        bundle.putInt("hdmi_rgb_range", pp.getHdmiRgbRange());
    L80:
        if (pp.getColorSpace() <= (-1)) goto L83;
        bundle.putInt("color_space", pp.getColorSpace());
    L83:
        if (pp.getPanelInitMaxLuminceNits() <= (-1)) goto L86;
        bundle.putInt("panel_init_max_lumince_nits", pp.getPanelInitMaxLuminceNits());
    L86:
        if (pp.getGamma() <= (-1)) goto L89;
        bundle.putInt("gamma", pp.getGamma());
    L89:
        if (pp.getColorTemperatureRedOffset() <= (-1)) goto L92;
        bundle.putInt("color_temperature_red_offset", pp.getColorTemperatureRedOffset());
    L92:
        if (pp.getColorTemperatureGreenOffset() <= (-1)) goto L95;
        bundle.putInt("color_temperature_green_offset", pp.getColorTemperatureGreenOffset());
    L95:
        if (pp.getColorTemperatureBlueOffset() <= (-1)) goto L98;
        bundle.putInt("color_temperature_blue_offset", pp.getColorTemperatureBlueOffset());
    L98:
        if (pp.getLowBlueLight() <= (-1)) goto L101;
        bundle.putInt("low_blue_light", pp.getLowBlueLight());
    L101:
        if (pp.getLdMode() <= (-1)) goto L104;
        bundle.putInt("ld_mode", pp.getLdMode());
    L104:
        if (pp.getOsdRedGain() <= (-1)) goto L107;
        bundle.putInt("osd_red_gain", pp.getOsdRedGain());
    L107:
        if (pp.getOsdGreenGain() <= (-1)) goto L110;
        bundle.putInt("osd_green_gain", pp.getOsdGreenGain());
    L110:
        if (pp.getOsdBlueGain() <= (-1)) goto L113;
        bundle.putInt("osd_blue_gain", pp.getOsdBlueGain());
    L113:
        if (pp.getOsdRedOffset() <= (-1)) goto L116;
        bundle.putInt("osd_red_offset", pp.getOsdRedOffset());
    L116:
        if (pp.getOsdGreenOffset() <= (-1)) goto L119;
        bundle.putInt("osd_green_offset", pp.getOsdGreenOffset());
    L119:
        if (pp.getOsdBlueOffset() <= (-1)) goto L122;
        bundle.putInt("osd_blue_offset", pp.getOsdBlueOffset());
    L122:
        if (pp.getOsdHue() <= (-1)) goto L125;
        bundle.putInt("osd_hue", pp.getOsdHue());
    L125:
        if (pp.getOsdSaturation() <= (-1)) goto L128;
        bundle.putInt("osd_saturation", pp.getOsdSaturation());
    L128:
        if (pp.getOsdContrast() <= (-1)) goto L131;
        bundle.putInt("osd_contrast", pp.getOsdContrast());
    L131:
        if (pp.getColorTunerHueRed() <= (-1)) goto L134;
        bundle.putInt("color_tuner_hue_red", pp.getColorTunerHueRed());
    L134:
        if (pp.getColorTunerHueGreen() <= (-1)) goto L137;
        bundle.putInt("color_tuner_hue_green", pp.getColorTunerHueGreen());
    L137:
        if (pp.getColorTunerHueBlue() <= (-1)) goto L140;
        bundle.putInt("color_tuner_hue_blue", pp.getColorTunerHueBlue());
    L140:
        if (pp.getColorTunerHueCyan() <= (-1)) goto L143;
        bundle.putInt("color_tuner_hue_cyan", pp.getColorTunerHueCyan());
    L143:
        if (pp.getColorTunerHueMagenta() <= (-1)) goto L146;
        bundle.putInt("color_tuner_hue_magenta", pp.getColorTunerHueMagenta());
    L146:
        if (pp.getColorTunerHueYellow() <= (-1)) goto L149;
        bundle.putInt("color_tuner_hue_yellow", pp.getColorTunerHueYellow());
    L149:
        if (pp.getColorTunerHueFlesh() <= (-1)) goto L152;
        bundle.putInt("color_tuner_hue_flesh", pp.getColorTunerHueFlesh());
    L152:
        if (pp.getColorTunerSaturationRed() <= (-1)) goto L155;
        bundle.putInt("color_tuner_saturation_red", pp.getColorTunerSaturationRed());
    L155:
        if (pp.getColorTunerSaturationGreen() <= (-1)) goto L158;
        bundle.putInt("color_tuner_saturation_green", pp.getColorTunerSaturationGreen());
    L158:
        if (pp.getColorTunerSaturationBlue() <= (-1)) goto L161;
        bundle.putInt("color_tuner_saturation_blue", pp.getColorTunerSaturationBlue());
    L161:
        if (pp.getColorTunerSaturationCyan() <= (-1)) goto L164;
        bundle.putInt("color_tuner_saturation_cyan", pp.getColorTunerSaturationCyan());
    L164:
        if (pp.getColorTunerSaturationMagenta() <= (-1)) goto L167;
        bundle.putInt("color_tuner_saturation_magenta", pp.getColorTunerSaturationMagenta());
    L167:
        if (pp.getColorTunerSaturationYellow() <= (-1)) goto L170;
        bundle.putInt("color_tuner_saturation_yellow", pp.getColorTunerSaturationYellow());
    L170:
        if (pp.getColorTunerSaturationFlesh() <= (-1)) goto L173;
        bundle.putInt("color_tuner_saturation_flesh", pp.getColorTunerSaturationFlesh());
    L173:
        if (pp.getColorTunerLuminanceRed() <= (-1)) goto L176;
        bundle.putInt("color_tuner_luminance_red", pp.getColorTunerLuminanceRed());
    L176:
        if (pp.getColorTunerLuminanceGreen() <= (-1)) goto L179;
        bundle.putInt("color_tuner_luminance_green", pp.getColorTunerLuminanceGreen());
    L179:
        if (pp.getColorTunerLuminanceBlue() <= (-1)) goto L182;
        bundle.putInt("color_tuner_luminance_blue", pp.getColorTunerLuminanceBlue());
    L182:
        if (pp.getColorTunerLuminanceCyan() <= (-1)) goto L185;
        bundle.putInt("color_tuner_luminance_cyan", pp.getColorTunerLuminanceCyan());
    L185:
        if (pp.getColorTunerLuminanceMagenta() <= (-1)) goto L188;
        bundle.putInt("color_tuner_luminance_magenta", pp.getColorTunerLuminanceMagenta());
    L188:
        if (pp.getColorTunerLuminanceYellow() <= (-1)) goto L191;
        bundle.putInt("color_tuner_luminance_yellow", pp.getColorTunerLuminanceYellow());
    L191:
        if (pp.getColorTunerLuminanceFlesh() <= (-1)) goto L194;
        bundle.putInt("color_tuner_luminance_flesh", pp.getColorTunerLuminanceFlesh());
    L194:
        if (pp.getPictureQualityEventType() <= (-1)) goto L197;
        bundle.putInt("picture_quality_event_type", pp.getPictureQualityEventType());
    L197:
        if (pp.getFilmMode() == false) goto L200;
        bundle.putBoolean("film_mode", true);
    L200:
        if (pp.getBlueStretch() == false) goto L203;
        bundle.putBoolean("blue_stretch", true);
    L203:
        if (pp.getColorTune() == false) goto L206;
        bundle.putBoolean("color_tune", true);
    L206:
        if (pp.getGlobeDimming() == false) goto L209;
        bundle.putBoolean("global_dimming", true);
    L209:
        if (pp.getAutoPictureQualityEnabled() == false) goto L212;
        bundle.putBoolean("auto_picture_quality_enabled", true);
    L212:
        if (pp.getAutoSuperResolutionEnabled() == false) goto L215;
        bundle.putBoolean("auto_super_resolution_enabled", true);
    L215:
        if (pp.getGamutMapping() == false) goto L218;
        bundle.putBoolean("gamut_mapping", true);
    L218:
        if (pp.getPcMode() == false) goto L221;
        bundle.putBoolean("pc_mode", true);
    L221:
        if (pp.getLowLatency() == false) goto L224;
        bundle.putBoolean("low_latency", true);
    L224:
        if (pp.getVrr() == false) goto L227;
        bundle.putBoolean("vrr", true);
    L227:
        if (pp.getCvrr() == false) goto L230;
        bundle.putBoolean("cvrr", true);
    L230:
        if (pp.getPanelInitMaxLuminceValid() == false) goto L233;
        bundle.putBoolean("panel_init_max_lumince_valid", true);
    L233:
        if (pp.getColorTunerSwitch() == false) goto L236;
        bundle.putBoolean("color_tuner_switch", true);
    L236:
        if (pp.getElevenPointRed() == null) goto L239;
        bundle.putIntArray("eleven_point_red", pp.getElevenPointRed());
    L239:
        if (pp.getElevenPointBlue() == null) goto L242;
        bundle.putIntArray("eleven_point_red", pp.getElevenPointBlue());
    L242:
        if (pp.getElevenPointGreen() == null) goto L244;
        bundle.putIntArray("eleven_point_red", pp.getElevenPointGreen());
    L244:
        r2 = r2 + 1;
        goto L3
    L245:
        return bundle;
    }

    public static PictureParameter[] convertPersistableBundleToPictureParameterList(PersistableBundle params) {
        if (params != null) goto L5;
        return null;
    L5:
        List<PictureParameter> pictureParams = new ArrayList();
        if (params.containsKey("brightness") == false) goto L9;
        pictureParams.add(PictureParameter.brightness((float) params.getDouble("brightness")));
        params.remove("brightness");
    L9:
        if (params.containsKey("contrast") == false) goto L12;
        pictureParams.add(PictureParameter.contrast(params.getInt("contrast")));
        params.remove("contrast");
    L12:
        if (params.containsKey("sharpness") == false) goto L15;
        pictureParams.add(PictureParameter.sharpness(params.getInt("sharpness")));
        params.remove("sharpness");
    L15:
        if (params.containsKey("saturation") == false) goto L18;
        pictureParams.add(PictureParameter.saturation(params.getInt("saturation")));
        params.remove("saturation");
    L18:
        if (params.containsKey("hue") == false) goto L21;
        pictureParams.add(PictureParameter.hue(params.getInt("hue")));
        params.remove("hue");
    L21:
        if (params.containsKey("color_tuner_brightness") == false) goto L24;
        pictureParams.add(PictureParameter.colorTunerBrightness(params.getInt("color_tuner_brightness")));
        params.remove("color_tuner_brightness");
    L24:
        if (params.containsKey("color_tuner_saturation") == false) goto L27;
        pictureParams.add(PictureParameter.colorTunerSaturation(params.getInt("color_tuner_saturation")));
        params.remove("color_tuner_saturation");
    L27:
        if (params.containsKey("color_tuner_hue") == false) goto L30;
        pictureParams.add(PictureParameter.colorTunerHue(params.getInt("color_tuner_hue")));
        params.remove("color_tuner_hue");
    L30:
        if (params.containsKey("color_tuner_red_offset") == false) goto L33;
        pictureParams.add(PictureParameter.colorTunerRedOffset(params.getInt("color_tuner_red_offset")));
        params.remove("color_tuner_red_offset");
    L33:
        if (params.containsKey("color_tuner_green_offset") == false) goto L36;
        pictureParams.add(PictureParameter.colorTunerGreenOffset(params.getInt("color_tuner_green_offset")));
        params.remove("color_tuner_green_offset");
    L36:
        if (params.containsKey("color_tuner_blue_offset") == false) goto L39;
        pictureParams.add(PictureParameter.colorTunerBlueOffset(params.getInt("color_tuner_blue_offset")));
        params.remove("color_tuner_blue_offset");
    L39:
        if (params.containsKey("color_tuner_red_gain") == false) goto L42;
        pictureParams.add(PictureParameter.colorTunerRedGain(params.getInt("color_tuner_red_gain")));
        params.remove("color_tuner_red_gain");
    L42:
        if (params.containsKey("color_tuner_green_gain") == false) goto L45;
        pictureParams.add(PictureParameter.colorTunerGreenGain(params.getInt("color_tuner_green_gain")));
        params.remove("color_tuner_green_gain");
    L45:
        if (params.containsKey("color_tuner_blue_gain") == false) goto L48;
        pictureParams.add(PictureParameter.colorTunerBlueGain(params.getInt("color_tuner_blue_gain")));
        params.remove("color_tuner_blue_gain");
    L48:
        if (params.containsKey("noise_reduction") == false) goto L54;
        String noiseReductionString = params.getString("noise_reduction");
        if (noiseReductionString == null) goto L52;
        byte noiseReductionByte = mapQualityLevel(noiseReductionString);
        pictureParams.add(PictureParameter.noiseReduction(noiseReductionByte));
    L52:
        params.remove("noise_reduction");
    L54:
        if (params.containsKey("mpeg_noise_reduction") == false) goto L60;
        String mpegNoiseReductionString = params.getString("mpeg_noise_reduction");
        if (mpegNoiseReductionString == null) goto L58;
        byte mpegNoiseReductionByte = mapQualityLevel(mpegNoiseReductionString);
        pictureParams.add(PictureParameter.mpegNoiseReduction(mpegNoiseReductionByte));
    L58:
        params.remove("mpeg_noise_reduction");
    L60:
        if (params.containsKey("flesh_tone") == false) goto L66;
        String fleshToneString = params.getString("flesh_tone");
        if (fleshToneString == null) goto L64;
        byte fleshToneByte = mapQualityLevel(fleshToneString);
        pictureParams.add(PictureParameter.fleshTone(fleshToneByte));
    L64:
        params.remove("flesh_tone");
    L66:
        if (params.containsKey("decontour") == false) goto L72;
        String decontourString = params.getString("decontour");
        if (decontourString == null) goto L70;
        byte decontourByte = mapQualityLevel(decontourString);
        pictureParams.add(PictureParameter.deContour(decontourByte));
    L70:
        params.remove("decontour");
    L72:
        if (params.containsKey("dynamic_luma_control") == false) goto L78;
        String dynamicLunaControlString = params.getString("dynamic_luma_control");
        if (dynamicLunaControlString == null) goto L76;
        byte dynamicLunaControlByte = mapQualityLevel(dynamicLunaControlString);
        pictureParams.add(PictureParameter.dynamicLumaControl(dynamicLunaControlByte));
    L76:
        params.remove("dynamic_luma_control");
    L78:
        if (params.containsKey("film_mode") == false) goto L81;
        pictureParams.add(PictureParameter.filmMode(params.getBoolean("film_mode")));
        params.remove("film_mode");
    L81:
        if (params.containsKey("blue_stretch") == false) goto L84;
        pictureParams.add(PictureParameter.blueStretch(params.getBoolean("blue_stretch")));
        params.remove("blue_stretch");
    L84:
        if (params.containsKey("color_tune") == false) goto L86;
        pictureParams.add(PictureParameter.colorTune(params.getBoolean("color_tune")));
        params.remove("color_tune");
    L86:
        byte r6 = 1;
        if (params.containsKey("color_temperature") == false) goto L139;
        String colorTemperatureString = params.getString("color_temperature");
        if (colorTemperatureString != null) goto L91;
    L137:
        params.remove("color_temperature");
        goto L139
    L91:
        switch(colorTemperatureString.hashCode()) {
            case -1427929953: goto L121;
            case -1427919382: goto L118;
            case -957741014: goto L115;
            case -180837092: goto L112;
            case -86374872: goto L109;
            case 248705784: goto L106;
            case 249245562: goto L103;
            case 249288244: goto L100;
            case 615117548: goto L97;
            case 1090326116: goto L94;
            default: goto L123;
        };
    L123:
        byte r10 = -1;
    L124:
        switch(r10) {
            case 0: goto L135;
            case 1: goto L134;
            case 2: goto L133;
            case 3: goto L132;
            case 4: goto L131;
            case 5: goto L130;
            case 6: goto L129;
            case 7: goto L128;
            case 8: goto L127;
            case 9: goto L126;
            default: goto L125;
        };
    L125:
        byte colorTemperatureByte = 2;
        Log.e("PictureParams", "Invalid color_temp string: " + colorTemperatureString);
    L136:
        pictureParams.add(PictureParameter.colorTemperature(colorTemperatureByte));
        goto L137
    L126:
        colorTemperatureByte = 9;
        goto L136
    L127:
        colorTemperatureByte = 8;
        goto L136
    L128:
        colorTemperatureByte = 7;
        goto L136
    L129:
        colorTemperatureByte = 6;
        goto L136
    L130:
        colorTemperatureByte = 5;
        goto L136
    L131:
        colorTemperatureByte = 4;
        goto L136
    L132:
        colorTemperatureByte = 3;
        goto L136
    L133:
        colorTemperatureByte = 2;
        goto L136
    L134:
        colorTemperatureByte = 1;
        goto L136
    L135:
        colorTemperatureByte = 0;
        goto L136
    L94:
        if (colorTemperatureString.equals("color_temp_warm_hdr10plus") == false) goto L458;
        r10 = 7;
        goto L124
    L458:
        r10 = -1;
        goto L124
    L97:
        if (colorTemperatureString.equals("color_temp_standard") == false) goto L459;
        r10 = 2;
        goto L124
    L459:
        r10 = -1;
        goto L124
    L100:
        if (colorTemperatureString.equals("color_temp_warm") == false) goto L460;
        r10 = 3;
        goto L124
    L460:
        r10 = -1;
        goto L124
    L103:
        if (colorTemperatureString.equals("color_temp_user") == false) goto L461;
        r10 = 0;
        goto L124
    L461:
        r10 = -1;
        goto L124
    L106:
        if (colorTemperatureString.equals("color_temp_cool") == false) goto L462;
        r10 = 1;
        goto L124
    L462:
        r10 = -1;
        goto L124
    L109:
        if (colorTemperatureString.equals("color_temp_cool_hdr10plus") == false) goto L463;
        r10 = 5;
        goto L124
    L463:
        r10 = -1;
        goto L124
    L112:
        if (colorTemperatureString.equals("color_temp_standard_hdr10plus") == false) goto L464;
        r10 = 6;
        goto L124
    L464:
        r10 = -1;
        goto L124
    L115:
        if (colorTemperatureString.equals("color_temp_user_hdr10plus") == false) goto L465;
        r10 = 4;
        goto L124
    L465:
        r10 = -1;
        goto L124
    L118:
        if (colorTemperatureString.equals("color_temp_fmmsdr") == false) goto L466;
        r10 = 8;
        goto L124
    L466:
        r10 = -1;
        goto L124
    L121:
        if (colorTemperatureString.equals("color_temp_fmmhdr") == false) goto L467;
        r10 = 9;
        goto L124
    L467:
        r10 = -1;
    L139:
        if (params.containsKey("global_dimming") == false) goto L142;
        pictureParams.add(PictureParameter.globeDimming(params.getBoolean("global_dimming")));
        params.remove("global_dimming");
    L142:
        if (params.containsKey("auto_picture_quality_enabled") == false) goto L145;
        pictureParams.add(PictureParameter.autoPictureQualityEnabled(params.getBoolean("auto_picture_quality_enabled")));
        params.remove("auto_picture_quality_enabled");
    L145:
        if (params.containsKey("auto_super_resolution_enabled") == false) goto L148;
        pictureParams.add(PictureParameter.autoSuperResolutionEnabled(params.getBoolean("auto_super_resolution_enabled")));
        params.remove("auto_super_resolution_enabled");
    L148:
        if (params.containsKey("color_tuner_red_gain") == false) goto L151;
        pictureParams.add(PictureParameter.colorTemperatureRedGain(params.getInt("color_tuner_red_gain")));
        params.remove("color_tuner_red_gain");
    L151:
        if (params.containsKey("color_tuner_green_gain") == false) goto L154;
        pictureParams.add(PictureParameter.colorTemperatureGreenGain(params.getInt("color_tuner_green_gain")));
        params.remove("color_tuner_green_gain");
    L154:
        if (params.containsKey("color_tuner_blue_gain") == false) goto L157;
        pictureParams.add(PictureParameter.colorTemperatureBlueGain(params.getInt("color_tuner_blue_gain")));
        params.remove("color_tuner_blue_gain");
    L157:
        if (params.containsKey("level_range") == false) goto L181;
        String levelRangeString = params.getString("level_range");
        if (levelRangeString != null) goto L161;
    L179:
        params.remove("level_range");
        goto L181
    L161:
        switch(levelRangeString.hashCode()) {
            case 2020783: goto L170;
            case 2169487: goto L167;
            case 894099834: goto L164;
            default: goto L172;
        };
    L172:
        byte r2 = -1;
    L173:
        switch(r2) {
            case 0: goto L177;
            case 1: goto L176;
            case 2: goto L175;
            default: goto L174;
        };
    L174:
        byte levelRangeByte = 0;
        Log.e("PictureParams", "Invalid color_range string: " + levelRangeString);
    L178:
        pictureParams.add(PictureParameter.levelRange(levelRangeByte));
        goto L179
    L175:
        levelRangeByte = 2;
        goto L178
    L176:
        levelRangeByte = 1;
        goto L178
    L177:
        levelRangeByte = 0;
        goto L178
    L164:
        if (levelRangeString.equals("LIMITED") == false) goto L468;
        r2 = 1;
        goto L173
    L468:
        r2 = -1;
        goto L173
    L167:
        if (levelRangeString.equals("FULL") == false) goto L469;
        r2 = 2;
        goto L173
    L469:
        r2 = -1;
        goto L173
    L170:
        if (levelRangeString.equals("AUTO") == false) goto L470;
        r2 = 0;
        goto L173
    L470:
        r2 = -1;
    L181:
        if (params.containsKey("gamut_mapping") == false) goto L184;
        pictureParams.add(PictureParameter.gamutMapping(params.getBoolean("gamut_mapping")));
        params.remove("gamut_mapping");
    L184:
        if (params.containsKey("pc_mode") == false) goto L187;
        pictureParams.add(PictureParameter.pcMode(params.getBoolean("pc_mode")));
        params.remove("pc_mode");
    L187:
        if (params.containsKey("low_latency") == false) goto L190;
        pictureParams.add(PictureParameter.lowLatency(params.getBoolean("low_latency")));
        params.remove("low_latency");
    L190:
        if (params.containsKey("vrr") == false) goto L193;
        pictureParams.add(PictureParameter.vrr(params.getBoolean("vrr")));
        params.remove("vrr");
    L193:
        if (params.containsKey("cvrr") == false) goto L196;
        pictureParams.add(PictureParameter.cvrr(params.getBoolean("cvrr")));
        params.remove("cvrr");
    L196:
        if (params.containsKey("hdmi_rgb_range") == false) goto L220;
        String hdmiRgbRangeString = params.getString("hdmi_rgb_range");
        if (hdmiRgbRangeString != null) goto L200;
    L218:
        params.remove("hdmi_rgb_range");
        goto L220
    L200:
        switch(hdmiRgbRangeString.hashCode()) {
            case 2020783: goto L209;
            case 2169487: goto L206;
            case 894099834: goto L203;
            default: goto L211;
        };
    L211:
        byte r3 = -1;
    L212:
        switch(r3) {
            case 0: goto L216;
            case 1: goto L215;
            case 2: goto L214;
            default: goto L213;
        };
    L213:
        byte hdmiRgbRangeByte = 0;
        Log.e("PictureParams", "Invalid hdmi_rgb_range string: 0");
    L217:
        pictureParams.add(PictureParameter.hdmiRgbRange(hdmiRgbRangeByte));
        goto L218
    L214:
        hdmiRgbRangeByte = 2;
        goto L217
    L215:
        hdmiRgbRangeByte = 1;
        goto L217
    L216:
        hdmiRgbRangeByte = 0;
        goto L217
    L203:
        if (hdmiRgbRangeString.equals("LIMITED") == false) goto L471;
        r3 = 1;
        goto L212
    L471:
        r3 = -1;
        goto L212
    L206:
        if (hdmiRgbRangeString.equals("FULL") == false) goto L472;
        r3 = 2;
        goto L212
    L472:
        r3 = -1;
        goto L212
    L209:
        if (hdmiRgbRangeString.equals("AUTO") == false) goto L473;
        r3 = 0;
        goto L212
    L473:
        r3 = -1;
    L220:
        if (params.containsKey("color_space") == false) goto L260;
        String colorSpaceString = params.getString("color_space");
        if (colorSpaceString != null) goto L224;
    L258:
        params.remove("color_space");
        goto L260
    L224:
        switch(colorSpaceString.hashCode()) {
            case -52356527: goto L245;
            case 2527: goto L242;
            case 67498: goto L239;
            case 78159: goto L236;
            case 2020783: goto L233;
            case 81067581: goto L230;
            case 1968637006: goto L227;
            default: goto L247;
        };
    L247:
        byte r4 = -1;
    L248:
        switch(r4) {
            case 0: goto L256;
            case 1: goto L255;
            case 2: goto L254;
            case 3: goto L253;
            case 4: goto L252;
            case 5: goto L251;
            case 6: goto L250;
            default: goto L249;
        };
    L249:
        byte colorSpaceByte = 6;
        Log.e("PictureParams", "Invalid color_space string: " + colorSpaceString);
    L257:
        pictureParams.add(PictureParameter.colorSpace(colorSpaceByte));
        goto L258
    L250:
        colorSpaceByte = 6;
        goto L257
    L251:
        colorSpaceByte = 5;
        goto L257
    L252:
        colorSpaceByte = 4;
        goto L257
    L253:
        colorSpaceByte = 3;
        goto L257
    L254:
        colorSpaceByte = 2;
        goto L257
    L255:
        colorSpaceByte = 1;
        goto L257
    L256:
        colorSpaceByte = 0;
        goto L257
    L227:
        if (colorSpaceString.equals("BT2020") == false) goto L474;
        r4 = 4;
        goto L248
    L474:
        r4 = -1;
        goto L248
    L230:
        if (colorSpaceString.equals("ADOBE_RGB") == false) goto L475;
        r4 = 3;
        goto L248
    L475:
        r4 = -1;
        goto L248
    L233:
        if (colorSpaceString.equals("AUTO") == false) goto L476;
        r4 = 0;
        goto L248
    L476:
        r4 = -1;
        goto L248
    L236:
        if (colorSpaceString.equals("OFF") == false) goto L477;
        r4 = 6;
        goto L248
    L477:
        r4 = -1;
        goto L248
    L239:
        if (colorSpaceString.equals("DCI") == false) goto L478;
        r4 = 2;
        goto L248
    L478:
        r4 = -1;
        goto L248
    L242:
        if (colorSpaceString.equals("ON") == false) goto L479;
        r4 = 5;
        goto L248
    L479:
        r4 = -1;
        goto L248
    L245:
        if (colorSpaceString.equals("S_RGB_BT_709") == false) goto L480;
        r4 = 1;
        goto L248
    L480:
        r4 = -1;
    L260:
        if (params.containsKey("panel_init_max_lumince_nits") == false) goto L263;
        pictureParams.add(PictureParameter.panelInitMaxLuminceNits(params.getInt("panel_init_max_lumince_nits")));
        params.remove("panel_init_max_lumince_nits");
    L263:
        if (params.containsKey("panel_init_max_lumince_valid") == false) goto L266;
        pictureParams.add(PictureParameter.panelInitMaxLuminceValid(params.getBoolean("panel_init_max_lumince_valid")));
        params.remove("panel_init_max_lumince_valid");
    L266:
        if (params.containsKey("gamma") == false) goto L290;
        String gammaString = params.getString("gamma");
        if (gammaString != null) goto L270;
    L288:
        params.remove("gamma");
        goto L290
    L270:
        switch(gammaString.hashCode()) {
            case -2021012075: goto L279;
            case 2090870: goto L276;
            case 1967497978: goto L273;
            default: goto L281;
        };
    L281:
        byte r5 = -1;
    L282:
        switch(r5) {
            case 0: goto L286;
            case 1: goto L285;
            case 2: goto L284;
            default: goto L283;
        };
    L283:
        byte gammaByte = 0;
        Log.e("PictureParams", "Invalid gamma string: " + gammaString);
    L287:
        pictureParams.add(PictureParameter.gamma(gammaByte));
        goto L288
    L284:
        gammaByte = 2;
        goto L287
    L285:
        gammaByte = 1;
        goto L287
    L286:
        gammaByte = 0;
        goto L287
    L273:
        if (gammaString.equals("BRIGHT") == false) goto L481;
        r5 = 2;
        goto L282
    L481:
        r5 = -1;
        goto L282
    L276:
        if (gammaString.equals("DARK") == false) goto L482;
        r5 = 0;
        goto L282
    L482:
        r5 = -1;
        goto L282
    L279:
        if (gammaString.equals("MIDDLE") == false) goto L483;
        r5 = 1;
        goto L282
    L483:
        r5 = -1;
    L290:
        if (params.containsKey("color_temperature_red_offset") == false) goto L293;
        pictureParams.add(PictureParameter.colorTemperatureRedOffset(params.getInt("color_temperature_red_offset")));
        params.remove("color_temperature_red_offset");
    L293:
        if (params.containsKey("color_temperature_green_offset") == false) goto L296;
        pictureParams.add(PictureParameter.colorTemperatureGreenOffset(params.getInt("color_temperature_green_offset")));
        params.remove("color_temperature_green_offset");
    L296:
        if (params.containsKey("color_temperature_blue_offset") == false) goto L299;
        pictureParams.add(PictureParameter.colorTemperatureBlueOffset(params.getInt("color_temperature_blue_offset")));
        params.remove("color_temperature_blue_offset");
    L299:
        if (params.containsKey("eleven_point_red") == false) goto L302;
        pictureParams.add(PictureParameter.elevenPointRed(params.getIntArray("eleven_point_red")));
        params.remove("eleven_point_red");
    L302:
        if (params.containsKey("eleven_point_green") == false) goto L305;
        pictureParams.add(PictureParameter.elevenPointGreen(params.getIntArray("eleven_point_green")));
        params.remove("eleven_point_green");
    L305:
        if (params.containsKey("eleven_point_blue") == false) goto L308;
        pictureParams.add(PictureParameter.elevenPointBlue(params.getIntArray("eleven_point_blue")));
        params.remove("eleven_point_blue");
    L308:
        if (params.containsKey("low_blue_light") == false) goto L314;
        String lowBlueLightString = params.getString("low_blue_light");
        if (lowBlueLightString == null) goto L312;
        byte lowBlueLightByte = mapQualityLevel(lowBlueLightString);
        pictureParams.add(PictureParameter.lowBlueLight(lowBlueLightByte));
    L312:
        params.remove("low_blue_light");
    L314:
        if (params.containsKey("ld_mode") == false) goto L320;
        String ldModeString = params.getString("ld_mode");
        if (ldModeString == null) goto L318;
        byte ldModeByte = mapQualityLevel(ldModeString);
        pictureParams.add(PictureParameter.LdMode(ldModeByte));
    L318:
        params.remove("ld_mode");
    L320:
        if (params.containsKey("osd_red_gain") == false) goto L323;
        pictureParams.add(PictureParameter.osdRedGain(params.getInt("osd_red_gain")));
        params.remove("osd_red_gain");
    L323:
        if (params.containsKey("osd_green_gain") == false) goto L326;
        pictureParams.add(PictureParameter.osdGreenGain(params.getInt("osd_green_gain")));
        params.remove("osd_green_gain");
    L326:
        if (params.containsKey("osd_blue_gain") == false) goto L329;
        pictureParams.add(PictureParameter.osdBlueGain(params.getInt("osd_blue_gain")));
        params.remove("osd_blue_gain");
    L329:
        if (params.containsKey("osd_red_offset") == false) goto L332;
        pictureParams.add(PictureParameter.osdRedOffset(params.getInt("osd_red_offset")));
        params.remove("osd_red_offset");
    L332:
        if (params.containsKey("osd_green_offset") == false) goto L335;
        pictureParams.add(PictureParameter.osdGreenOffset(params.getInt("osd_green_offset")));
        params.remove("osd_green_offset");
    L335:
        if (params.containsKey("osd_blue_offset") == false) goto L338;
        pictureParams.add(PictureParameter.osdBlueOffset(params.getInt("osd_blue_offset")));
        params.remove("osd_blue_offset");
    L338:
        if (params.containsKey("osd_hue") == false) goto L341;
        pictureParams.add(PictureParameter.osdHue(params.getInt("osd_hue")));
        params.remove("osd_hue");
    L341:
        if (params.containsKey("osd_saturation") == false) goto L344;
        pictureParams.add(PictureParameter.osdSaturation(params.getInt("osd_saturation")));
        params.remove("osd_saturation");
    L344:
        if (params.containsKey("osd_contrast") == false) goto L347;
        pictureParams.add(PictureParameter.osdContrast(params.getInt("osd_contrast")));
        params.remove("osd_contrast");
    L347:
        if (params.containsKey("color_tuner_switch") == false) goto L350;
        pictureParams.add(PictureParameter.colorTunerSwitch(params.getBoolean("color_tuner_switch")));
        params.remove("color_tuner_switch");
    L350:
        if (params.containsKey("color_tuner_hue_red") == false) goto L353;
        pictureParams.add(PictureParameter.colorTunerHueRed(params.getInt("color_tuner_hue_red")));
        params.remove("color_tuner_hue_red");
    L353:
        if (params.containsKey("color_tuner_hue_green") == false) goto L356;
        pictureParams.add(PictureParameter.colorTunerHueGreen(params.getInt("color_tuner_hue_green")));
        params.remove("color_tuner_hue_green");
    L356:
        if (params.containsKey("color_tuner_hue_blue") == false) goto L359;
        pictureParams.add(PictureParameter.colorTunerHueBlue(params.getInt("color_tuner_hue_blue")));
        params.remove("color_tuner_hue_blue");
    L359:
        if (params.containsKey("color_tuner_hue_cyan") == false) goto L362;
        pictureParams.add(PictureParameter.colorTunerHueCyan(params.getInt("color_tuner_hue_cyan")));
        params.remove("color_tuner_hue_cyan");
    L362:
        if (params.containsKey("color_tuner_hue_magenta") == false) goto L365;
        pictureParams.add(PictureParameter.colorTunerHueMagenta(params.getInt("color_tuner_hue_magenta")));
        params.remove("color_tuner_hue_magenta");
    L365:
        if (params.containsKey("color_tuner_hue_yellow") == false) goto L368;
        pictureParams.add(PictureParameter.colorTunerHueYellow(params.getInt("color_tuner_hue_yellow")));
        params.remove("color_tuner_hue_yellow");
    L368:
        if (params.containsKey("color_tuner_hue_flesh") == false) goto L371;
        pictureParams.add(PictureParameter.colorTunerHueFlesh(params.getInt("color_tuner_hue_flesh")));
        params.remove("color_tuner_hue_flesh");
    L371:
        if (params.containsKey("color_tuner_saturation_red") == false) goto L374;
        pictureParams.add(PictureParameter.colorTunerSaturationRed(params.getInt("color_tuner_saturation_red")));
        params.remove("color_tuner_saturation_red");
    L374:
        if (params.containsKey("color_tuner_saturation_green") == false) goto L377;
        pictureParams.add(PictureParameter.colorTunerSaturationGreen(params.getInt("color_tuner_saturation_green")));
        params.remove("color_tuner_saturation_green");
    L377:
        if (params.containsKey("color_tuner_saturation_blue") == false) goto L380;
        pictureParams.add(PictureParameter.colorTunerSaturationBlue(params.getInt("color_tuner_saturation_blue")));
        params.remove("color_tuner_saturation_blue");
    L380:
        if (params.containsKey("color_tuner_saturation_cyan") == false) goto L383;
        pictureParams.add(PictureParameter.colorTunerSaturationCyan(params.getInt("color_tuner_saturation_cyan")));
        params.remove("color_tuner_saturation_cyan");
    L383:
        if (params.containsKey("color_tuner_saturation_magenta") == false) goto L386;
        pictureParams.add(PictureParameter.colorTunerSaturationMagenta(params.getInt("color_tuner_saturation_magenta")));
        params.remove("color_tuner_saturation_magenta");
    L386:
        if (params.containsKey("color_tuner_saturation_yellow") == false) goto L389;
        pictureParams.add(PictureParameter.colorTunerSaturationYellow(params.getInt("color_tuner_saturation_yellow")));
        params.remove("color_tuner_saturation_yellow");
    L389:
        if (params.containsKey("color_tuner_saturation_flesh") == false) goto L392;
        pictureParams.add(PictureParameter.colorTunerSaturationFlesh(params.getInt("color_tuner_saturation_flesh")));
        params.remove("color_tuner_saturation_flesh");
    L392:
        if (params.containsKey("color_tuner_luminance_red") == false) goto L395;
        pictureParams.add(PictureParameter.colorTunerLuminanceRed(params.getInt("color_tuner_luminance_red")));
        params.remove("color_tuner_luminance_red");
    L395:
        if (params.containsKey("color_tuner_luminance_green") == false) goto L398;
        pictureParams.add(PictureParameter.colorTunerLuminanceGreen(params.getInt("color_tuner_luminance_green")));
        params.remove("color_tuner_luminance_green");
    L398:
        if (params.containsKey("color_tuner_luminance_blue") == false) goto L401;
        pictureParams.add(PictureParameter.colorTunerLuminanceBlue(params.getInt("color_tuner_luminance_blue")));
        params.remove("color_tuner_luminance_blue");
    L401:
        if (params.containsKey("color_tuner_luminance_cyan") == false) goto L404;
        pictureParams.add(PictureParameter.colorTunerLuminanceCyan(params.getInt("color_tuner_luminance_cyan")));
        params.remove("color_tuner_luminance_cyan");
    L404:
        if (params.containsKey("color_tuner_luminance_magenta") == false) goto L407;
        pictureParams.add(PictureParameter.colorTunerLuminanceMagenta(params.getInt("color_tuner_luminance_magenta")));
        params.remove("color_tuner_luminance_magenta");
    L407:
        if (params.containsKey("color_tuner_luminance_yellow") == false) goto L410;
        pictureParams.add(PictureParameter.colorTunerLuminanceYellow(params.getInt("color_tuner_luminance_yellow")));
        params.remove("color_tuner_luminance_yellow");
    L410:
        if (params.containsKey("color_tuner_luminance_flesh") == false) goto L413;
        pictureParams.add(PictureParameter.colorTunerLuminanceFlesh(params.getInt("color_tuner_luminance_flesh")));
        params.remove("color_tuner_luminance_flesh");
    L413:
        if (params.containsKey("picture_quality_event_type") == false) goto L457;
        String pictureQualityEventTypeString = params.getString("picture_quality_event_type");
        if (pictureQualityEventTypeString != null) goto L417;
    L455:
        params.remove("picture_quality_event_type");
        goto L457
    L417:
        switch(pictureQualityEventTypeString.hashCode()) {
            case -1839279665: goto L441;
            case -1592501194: goto L438;
            case -1335273044: goto L435;
            case -530225455: goto L432;
            case -276170896: goto L429;
            case -38507336: goto L426;
            case 2402104: goto L423;
            case 80478304: goto L420;
            default: goto L443;
        };
    L443:
        r6 = -1;
    L444:
        switch(r6) {
            case 0: goto L453;
            case 1: goto L452;
            case 2: goto L451;
            case 3: goto L450;
            case 4: goto L449;
            case 5: goto L448;
            case 6: goto L447;
            case 7: goto L446;
            default: goto L445;
        };
    L445:
        byte pictureQualityEventTypeByte = 0;
        Log.e("PictureParams", "Invalid event type string: " + pictureQualityEventTypeString);
    L454:
        pictureParams.add(PictureParameter.pictureQualityEventType(pictureQualityEventTypeByte));
        goto L455
    L446:
        pictureQualityEventTypeByte = 7;
        goto L454
    L447:
        pictureQualityEventTypeByte = 6;
        goto L454
    L448:
        pictureQualityEventTypeByte = 5;
        goto L454
    L449:
        pictureQualityEventTypeByte = 4;
        goto L454
    L450:
        pictureQualityEventTypeByte = 3;
        goto L454
    L451:
        pictureQualityEventTypeByte = 2;
        goto L454
    L452:
        pictureQualityEventTypeByte = 1;
        goto L454
    L453:
        pictureQualityEventTypeByte = 0;
        goto L454
    L420:
        if (pictureQualityEventTypeString.equals("DOLBY_IQ_CHANGE") == false) goto L484;
        r6 = 6;
        goto L444
    L484:
        r6 = -1;
        goto L444
    L423:
        if (pictureQualityEventTypeString.equals("NONE") == false) goto L485;
        r6 = 0;
        goto L444
    L485:
        r6 = -1;
        goto L444
    L426:
        if (pictureQualityEventTypeString.equals("BBD_RESULT") == true) goto L444;
        r6 = -1;
        goto L444
    L429:
        if (pictureQualityEventTypeString.equals("VIDEO_DELAY_CHANGE") == false) goto L487;
        r6 = 2;
        goto L444
    L487:
        r6 = -1;
        goto L444
    L432:
        if (pictureQualityEventTypeString.equals("EXTRA_FRAME_CHANGE") == false) goto L488;
        r6 = 5;
        goto L444
    L488:
        r6 = -1;
        goto L444
    L435:
        if (pictureQualityEventTypeString.equals("CAPTUREPOINT_INFO_CHANGE") == false) goto L489;
        r6 = 3;
        goto L444
    L489:
        r6 = -1;
        goto L444
    L438:
        if (pictureQualityEventTypeString.equals("DOLBY_APO_CHANGE") == false) goto L490;
        r6 = 7;
        goto L444
    L490:
        r6 = -1;
        goto L444
    L441:
        if (pictureQualityEventTypeString.equals("VIDEOPATH_CHANGE") == false) goto L491;
        r6 = 4;
        goto L444
    L491:
        r6 = -1;
    L457:
        return (PictureParameter[]) pictureParams.toArray(new PictureParameter[0]);
    }

    public static PersistableBundle convertSoundParameterListToPersistableBundle(SoundParameter[] parameters) {
        if (parameters != null) goto L5;
        return null;
    L5:
        PersistableBundle bundle = new PersistableBundle();
        int r1 = parameters.length;
        int r2 = 0;
    L6:
        if (r2 >= r1) goto L83;
        SoundParameter sp = parameters[r2];
        if (sp.getSurroundSoundEnabled() == false) goto L11;
        bundle.putBoolean("surround_sound", true);
    L11:
        if (sp.getSpeakersEnabled() == false) goto L14;
        bundle.putBoolean("speakers", true);
    L14:
        if (sp.getAutoVolumeControl() == false) goto L17;
        bundle.putBoolean("auto_volume_control", true);
    L17:
        if (sp.getDtsDrc() == false) goto L20;
        bundle.putBoolean("dts_drc", true);
    L20:
        if (sp.getSurroundSoundEnabled() == false) goto L23;
        bundle.putBoolean("digital_output_delay_millis", true);
    L23:
        if (sp.getEnhancedAudioReturnChannelEnabled() == false) goto L26;
        bundle.putBoolean("earc", true);
    L26:
        if (sp.getBalance() <= (-1)) goto L29;
        bundle.putInt("balance", sp.getBalance());
    L29:
        if (sp.getBass() <= (-1)) goto L32;
        bundle.putInt("bass", sp.getBass());
    L32:
        if (sp.getTreble() <= (-1)) goto L35;
        bundle.putInt("treble", sp.getTreble());
    L35:
        if (sp.getSpeakersDelayMs() <= (-1)) goto L38;
        bundle.putInt("speakers_delay_millis", sp.getSpeakersDelayMs());
    L38:
        if (sp.getDownmixMode() <= (-1)) goto L41;
        bundle.putInt("down_mix_mode", sp.getDownmixMode());
    L41:
        if (sp.getSoundStyle() <= (-1)) goto L44;
        bundle.putInt("sound_style", sp.getSoundStyle());
    L44:
        if (sp.getDigitalOutput() <= (-1)) goto L47;
        bundle.putInt("digital_output_mode", sp.getDigitalOutput());
    L47:
        if (sp.getDolbyDialogueEnhancer() <= (-1)) goto L50;
        bundle.putInt("dialogue_enhancer", sp.getDolbyDialogueEnhancer());
    L50:
        if (sp.getDtsVirtualX().tbHdx == false) goto L53;
        bundle.putBoolean("dts_virtual_x_tbhdx", true);
    L53:
        if (sp.getDtsVirtualX().limiter == false) goto L56;
        bundle.putBoolean("dts_virtual_x_limiter", true);
    L56:
        if (sp.getDtsVirtualX().truSurroundX == false) goto L59;
        bundle.putBoolean("dts_virtual_x_tru_surround_x", true);
    L59:
        if (sp.getDtsVirtualX().truVolumeHd == false) goto L62;
        bundle.putBoolean("dts_virtual_x_tru_volume_hd", true);
    L62:
        if (sp.getDtsVirtualX().dialogClarity == false) goto L65;
        bundle.putBoolean("dts_virtual_x_dialog_clarity", true);
    L65:
        if (sp.getDtsVirtualX().definition == false) goto L68;
        bundle.putBoolean("dts_virtual_x_definition", true);
    L68:
        if (sp.getDtsVirtualX().height == false) goto L71;
        bundle.putBoolean("dts_virtual_x_height", true);
    L71:
        if (sp.getDolbyAudioProcessing().soundMode <= (-1)) goto L74;
        bundle.putInt("dolby_audio_processing_sound_mode", sp.getDolbyAudioProcessing().soundMode);
    L74:
        if (sp.getDolbyAudioProcessing().volumeLeveler == false) goto L77;
        bundle.putBoolean("dolby_audio_processing_volume_leveler", true);
    L77:
        if (sp.getDolbyAudioProcessing().surroundVirtualizer == false) goto L80;
        bundle.putBoolean("dolby_audio_processing_surround_virtualizer", true);
    L80:
        if (sp.getDolbyAudioProcessing().dolbyAtmos == false) goto L82;
        bundle.putBoolean("dolby_audio_processing_dolby_atmos", true);
    L82:
        r2 = r2 + 1;
        goto L6
    L83:
        return bundle;
    }

    public static SoundParameter[] convertPersistableBundleToSoundParameterList(PersistableBundle params) {
        if (params != null) goto L5;
        return null;
    L5:
        List<SoundParameter> soundParams = new ArrayList();
        if (params.containsKey("balance") == false) goto L9;
        soundParams.add(SoundParameter.balance(params.getInt("balance")));
        params.remove("balance");
    L9:
        if (params.containsKey("bass") == false) goto L12;
        soundParams.add(SoundParameter.bass(params.getInt("bass")));
        params.remove("bass");
    L12:
        if (params.containsKey("treble") == false) goto L15;
        soundParams.add(SoundParameter.treble(params.getInt("treble")));
        params.remove("treble");
    L15:
        if (params.containsKey("surround_sound") == false) goto L18;
        soundParams.add(SoundParameter.surroundSoundEnabled(params.getBoolean("surround_sound")));
        params.remove("surround_sound");
    L18:
        if (params.containsKey("speakers") == false) goto L21;
        soundParams.add(SoundParameter.speakersEnabled(params.getBoolean("speakers")));
        params.remove("speakers");
    L21:
        if (params.containsKey("speakers_delay_millis") == false) goto L24;
        soundParams.add(SoundParameter.speakersDelayMs(params.getInt("speakers_delay_millis")));
        params.remove("speakers_delay_millis");
    L24:
        if (params.containsKey("auto_volume_control") == false) goto L27;
        soundParams.add(SoundParameter.autoVolumeControl(params.getBoolean("auto_volume_control")));
        params.remove("auto_volume_control");
    L27:
        if (params.containsKey("dts_drc") == false) goto L30;
        soundParams.add(SoundParameter.dtsDrc(params.getBoolean("dts_drc")));
        params.remove("dts_drc");
    L30:
        if (params.containsKey("digital_output_delay_millis") == false) goto L33;
        soundParams.add(SoundParameter.surroundSoundEnabled(params.getBoolean("digital_output_delay_millis")));
        params.remove("digital_output_delay_millis");
    L33:
        if (params.containsKey("earc") == false) goto L36;
        soundParams.add(SoundParameter.enhancedAudioReturnChannelEnabled(params.getBoolean("earc")));
        params.remove("earc");
    L36:
        if (params.containsKey("down_mix_mode") == false) goto L39;
        soundParams.add(SoundParameter.downmixMode((byte) params.getInt("down_mix_mode")));
        params.remove("down_mix_mode");
    L39:
        if (params.containsKey("sound_style") == false) goto L42;
        soundParams.add(SoundParameter.soundStyle((byte) params.getInt("sound_style")));
        params.remove("sound_style");
    L42:
        if (params.containsKey("digital_output_mode") == false) goto L45;
        soundParams.add(SoundParameter.digitalOutput((byte) params.getInt("digital_output_mode")));
        params.remove("digital_output_mode");
    L45:
        if (params.containsKey("dialogue_enhancer") == false) goto L47;
        soundParams.add(SoundParameter.dolbyDialogueEnhancer((byte) params.getInt("dialogue_enhancer")));
        params.remove("dialogue_enhancer");
    L47:
        DolbyAudioProcessing dab = new DolbyAudioProcessing();
        if (params.containsKey("dolby_audio_processing_sound_mode") == false) goto L51;
        dab.soundMode = (byte) params.getInt("dolby_audio_processing_sound_mode");
        params.remove("dolby_audio_processing_sound_mode");
    L51:
        if (params.containsKey("dolby_audio_processing_volume_leveler") == false) goto L54;
        dab.volumeLeveler = params.getBoolean("dolby_audio_processing_volume_leveler");
        params.remove("dolby_audio_processing_volume_leveler");
    L54:
        if (params.containsKey("dolby_audio_processing_surround_virtualizer") == false) goto L57;
        dab.surroundVirtualizer = params.getBoolean("dolby_audio_processing_surround_virtualizer");
        params.remove("dolby_audio_processing_surround_virtualizer");
    L57:
        if (params.containsKey("dolby_audio_processing_dolby_atmos") == false) goto L59;
        dab.dolbyAtmos = params.getBoolean("dolby_audio_processing_dolby_atmos");
        params.remove("dolby_audio_processing_dolby_atmos");
    L59:
        soundParams.add(SoundParameter.dolbyAudioProcessing(dab));
        DtsVirtualX dts = new DtsVirtualX();
        if (params.containsKey("dts_virtual_x_tbhdx") == false) goto L63;
        dts.tbHdx = params.getBoolean("dts_virtual_x_tbhdx");
        params.remove("dts_virtual_x_tbhdx");
    L63:
        if (params.containsKey("dts_virtual_x_limiter") == false) goto L66;
        dts.tbHdx = params.getBoolean("dts_virtual_x_limiter");
        params.remove("dts_virtual_x_limiter");
    L66:
        if (params.containsKey("dts_virtual_x_tru_surround_x") == false) goto L69;
        dts.tbHdx = params.getBoolean("dts_virtual_x_tru_surround_x");
        params.remove("dts_virtual_x_tru_surround_x");
    L69:
        if (params.containsKey("dts_virtual_x_tru_volume_hd") == false) goto L72;
        dts.tbHdx = params.getBoolean("dts_virtual_x_tru_volume_hd");
        params.remove("dts_virtual_x_tru_volume_hd");
    L72:
        if (params.containsKey("dts_virtual_x_dialog_clarity") == false) goto L75;
        dts.tbHdx = params.getBoolean("dts_virtual_x_dialog_clarity");
        params.remove("dts_virtual_x_dialog_clarity");
    L75:
        if (params.containsKey("dts_virtual_x_definition") == false) goto L78;
        dts.tbHdx = params.getBoolean("dts_virtual_x_definition");
        params.remove("dts_virtual_x_definition");
    L78:
        if (params.containsKey("dts_virtual_x_height") == false) goto L80;
        dts.tbHdx = params.getBoolean("dts_virtual_x_height");
        params.remove("dts_virtual_x_height");
    L80:
        soundParams.add(SoundParameter.dtsVirtualX(dts));
        return (SoundParameter[]) soundParams.toArray(new SoundParameter[0]);
    }

    private static String persistableBundleToJson(PersistableBundle bundle) {
        JSONObject json = new JSONObject();
        Iterator<String> r1 = bundle.keySet().iterator();
    L4:
        if (r1.hasNext() == false) goto L27;
        String key = r1.next();
        Object value = bundle.get(key);
        if ((value instanceof String) == true) goto L8;
        if ((value instanceof Integer) == true) goto L13;
        if ((value instanceof Long) == true) goto L16;
        if ((value instanceof Boolean) == true) goto L19;
        if ((value instanceof Double) == false) goto L4;
        json.put(key, bundle.getDouble(key));     // Catch: JSONException -> L9
        goto L4
    L19:
        json.put(key, bundle.getBoolean(key));     // Catch: JSONException -> L9
        goto L4
    L16:
        json.put(key, bundle.getLong(key));     // Catch: JSONException -> L9
        goto L4
    L13:
        json.put(key, bundle.getInt(key));     // Catch: JSONException -> L9
        goto L4
    L8:
        json.put(key, bundle.getString(key));     // Catch: JSONException -> L9
    L9:
        e = move-exception;
        Log.e(TAG, "Unable to serialize ", e);
        goto L4
    L27:
        return json.toString();
    }

    private static PersistableBundle jsonToPersistableBundle(String jsonString) {
        PersistableBundle bundle = new PersistableBundle();
        if (jsonString != null) goto L30;
    L29:
        return bundle;
    L30:
        JSONObject jsonObject = new JSONObject(jsonString);     // Catch: JSONException -> L11
        Iterator<String> keys = jsonObject.keys();     // Catch: JSONException -> L11
    L6:
        if (keys.hasNext() == false) goto L29;
        String key = keys.next();     // Catch: JSONException -> L11
        Object value = jsonObject.get(key);     // Catch: JSONException -> L11
        if ((value instanceof String) == true) goto L10;
        if ((value instanceof Integer) == true) goto L15;
        if ((value instanceof Boolean) == true) goto L18;
        if ((value instanceof Double) == true) goto L21;
        if ((value instanceof Long) == false) goto L6;
        bundle.putLong(key, ((Long) value).longValue());     // Catch: JSONException -> L11
        goto L6
    L21:
        bundle.putDouble(key, ((Double) value).doubleValue());     // Catch: JSONException -> L11
        goto L6
    L18:
        bundle.putBoolean(key, ((Boolean) value).booleanValue());     // Catch: JSONException -> L11
        goto L6
    L15:
        bundle.putInt(key, ((Integer) value).intValue());     // Catch: JSONException -> L11
        goto L6
    L10:
        bundle.putString(key, (String) value);     // Catch: JSONException -> L11
    L11:
        e = move-exception;
        throw new RuntimeException(e);
    }

    public static void populateTempIdMap(BiMap<Long, String> map, Long id) {
        if (id != null) goto L4;
        return;
    L4:
        if (map.getValue(id) != null) goto L16;
        int attempts = 0;
    L7:
        if (attempts >= 10) goto L17;
        String uuid = UUID.randomUUID().toString();
        if (map.getKey(uuid) == null) goto L10;
        attempts = attempts + 1;
        goto L7
    L10:
        map.put(id, uuid);
        return;
    L17:
        return;
    }

    public static ContentValues getContentValues(Long dbId, Integer profileType, String name, String packageName, String inputId, PersistableBundle params) {
        ContentValues values = new ContentValues();
        if (dbId == null) goto L5;
        values.put("_id", dbId);
    L5:
        if (profileType == null) goto L7;
        values.put("_type", profileType);
    L7:
        if (name == null) goto L9;
        values.put("_name", name);
    L9:
        if (packageName == null) goto L11;
        values.put("_package", packageName);
    L11:
        if (inputId == null) goto L13;
        values.put("_input_id", inputId);
    L13:
        if (params == null) goto L15;
        values.put("settings", persistableBundleToJson(params));
    L15:
        return values;
    }

    public static String[] getMediaProfileColumns(boolean includeParams) {
        ArrayList<String> columns = new ArrayList(Arrays.asList(new String[]{"_id", "_type", "_name", "_input_id", "_package"}));
        if (includeParams == false) goto L6;
        columns.add("settings");
    L6:
        return (String[]) columns.toArray(new String[0]);
    }

    public static PictureProfile convertCursorToPictureProfileWithTempId(Cursor cursor, BiMap<Long, String> map) {
        String tmpId = getTempId(map, cursor);
        Long dbId = map.getKey(tmpId);
        if (dbId != null) goto L6;
        PictureProfileHandle r0 = PictureProfileHandle.NONE;
    L5:
        PictureProfileHandle handle = r0;
        return new PictureProfile(tmpId, getType(cursor), getName(cursor), getInputId(cursor), getPackageName(cursor), jsonToPersistableBundle(getSettingsString(cursor)), handle);
    L6:
        r0 = new PictureProfileHandle(dbId.longValue());
        goto L5
    }

    public static SoundProfile convertCursorToSoundProfileWithTempId(Cursor cursor, BiMap<Long, String> map) {
        return new SoundProfile(getTempId(map, cursor), getType(cursor), getName(cursor), getInputId(cursor), getPackageName(cursor), jsonToPersistableBundle(getSettingsString(cursor)), SOUND_PROFILE_HANDLE_NONE);
    }

    public static byte[] convertParameterToByteArray(List<String> names) {
        if (names != null) goto L5;
        return null;
    L5:
        HashSet<String> nameMap = new HashSet(names);
        List<Byte> bytes = new ArrayList();
        if (nameMap.contains("brightness") == false) goto L9;
        bytes.add((byte) 0);
    L9:
        if (nameMap.contains("brightness") == false) goto L12;
        bytes.add((byte) 0);
    L12:
        if (nameMap.contains("contrast") == false) goto L15;
        bytes.add((byte) 1);
    L15:
        if (nameMap.contains("sharpness") == false) goto L18;
        bytes.add((byte) 2);
    L18:
        if (nameMap.contains("saturation") == false) goto L21;
        bytes.add((byte) 3);
    L21:
        if (nameMap.contains("hue") == false) goto L24;
        bytes.add((byte) 4);
    L24:
        if (nameMap.contains("brightness") == false) goto L27;
        bytes.add((byte) 0);
    L27:
        if (nameMap.contains("color_tuner_brightness") == false) goto L30;
        bytes.add((byte) 5);
    L30:
        if (nameMap.contains("saturation") == false) goto L33;
        bytes.add((byte) 3);
    L33:
        if (nameMap.contains("color_tuner_saturation") == false) goto L36;
        bytes.add((byte) 6);
    L36:
        if (nameMap.contains("hue") == false) goto L39;
        bytes.add((byte) 4);
    L39:
        if (nameMap.contains("color_tuner_hue") == false) goto L42;
        bytes.add((byte) 7);
    L42:
        if (nameMap.contains("color_tuner_red_offset") == false) goto L45;
        bytes.add((byte) 8);
    L45:
        if (nameMap.contains("color_tuner_green_offset") == false) goto L48;
        bytes.add((byte) 9);
    L48:
        if (nameMap.contains("color_tuner_blue_offset") == false) goto L51;
        bytes.add((byte) 10);
    L51:
        if (nameMap.contains("color_tuner_red_gain") == false) goto L54;
        bytes.add((byte) 11);
    L54:
        if (nameMap.contains("color_tuner_green_gain") == false) goto L57;
        bytes.add((byte) 12);
    L57:
        if (nameMap.contains("color_tuner_blue_gain") == false) goto L60;
        bytes.add((byte) 13);
    L60:
        if (nameMap.contains("noise_reduction") == false) goto L63;
        bytes.add((byte) 14);
    L63:
        if (nameMap.contains("mpeg_noise_reduction") == false) goto L66;
        bytes.add((byte) 15);
    L66:
        if (nameMap.contains("flesh_tone") == false) goto L69;
        bytes.add((byte) 16);
    L69:
        if (nameMap.contains("decontour") == false) goto L72;
        bytes.add(Byte.valueOf(ParameterName.DE_CONTOUR));
    L72:
        if (nameMap.contains("dynamic_luma_control") == false) goto L75;
        bytes.add(Byte.valueOf(ParameterName.DYNAMIC_LUMA_CONTROL));
    L75:
        if (nameMap.contains("film_mode") == false) goto L78;
        bytes.add(Byte.valueOf(ParameterName.FILM_MODE));
    L78:
        if (nameMap.contains("blue_stretch") == false) goto L81;
        bytes.add(Byte.valueOf(ParameterName.BLUE_STRETCH));
    L81:
        if (nameMap.contains("color_tune") == false) goto L84;
        bytes.add(Byte.valueOf(ParameterName.COLOR_TUNE));
    L84:
        if (nameMap.contains("color_temperature") == false) goto L87;
        bytes.add(Byte.valueOf(ParameterName.COLOR_TEMPERATURE));
    L87:
        if (nameMap.contains("global_dimming") == false) goto L90;
        bytes.add(Byte.valueOf(ParameterName.GLOBE_DIMMING));
    L90:
        if (nameMap.contains("auto_picture_quality_enabled") == false) goto L93;
        bytes.add(Byte.valueOf(ParameterName.AUTO_PICTUREQUALITY_ENABLED));
    L93:
        if (nameMap.contains("auto_super_resolution_enabled") == false) goto L96;
        bytes.add(Byte.valueOf(ParameterName.AUTO_SUPER_RESOLUTION_ENABLED));
    L96:
        if (nameMap.contains("level_range") == false) goto L99;
        bytes.add(Byte.valueOf(ParameterName.LEVEL_RANGE));
    L99:
        if (nameMap.contains("gamut_mapping") == false) goto L102;
        bytes.add(Byte.valueOf(ParameterName.GAMUT_MAPPING));
    L102:
        if (nameMap.contains("pc_mode") == false) goto L105;
        bytes.add(Byte.valueOf(ParameterName.PC_MODE));
    L105:
        if (nameMap.contains("low_latency") == false) goto L108;
        bytes.add(Byte.valueOf(ParameterName.LOW_LATENCY));
    L108:
        if (nameMap.contains("vrr") == false) goto L111;
        bytes.add(Byte.valueOf(ParameterName.VRR));
    L111:
        if (nameMap.contains("cvrr") == false) goto L114;
        bytes.add(Byte.valueOf(ParameterName.CVRR));
    L114:
        if (nameMap.contains("hdmi_rgb_range") == false) goto L117;
        bytes.add((byte) 33);
    L117:
        if (nameMap.contains("color_space") == false) goto L120;
        bytes.add((byte) 34);
    L120:
        if (nameMap.contains("panel_init_max_lumince_valid") == false) goto L123;
        bytes.add((byte) 35);
    L123:
        if (nameMap.contains("gamma") == false) goto L126;
        bytes.add((byte) 36);
    L126:
        if (nameMap.contains("color_temperature_red_offset") == false) goto L129;
        bytes.add(Byte.valueOf(ParameterName.COLOR_TEMPERATURE_RED_OFFSET));
    L129:
        if (nameMap.contains("color_temperature_green_offset") == false) goto L132;
        bytes.add((byte) 41);
    L132:
        if (nameMap.contains("color_temperature_blue_offset") == false) goto L135;
        bytes.add((byte) 42);
    L135:
        if (nameMap.contains("eleven_point_red") == false) goto L138;
        bytes.add(Byte.valueOf(ParameterName.ELEVEN_POINT_RED));
    L138:
        if (nameMap.contains("eleven_point_green") == false) goto L141;
        bytes.add(Byte.valueOf(ParameterName.ELEVEN_POINT_GREEN));
    L141:
        if (nameMap.contains("eleven_point_blue") == false) goto L144;
        bytes.add(Byte.valueOf(ParameterName.ELEVEN_POINT_BLUE));
    L144:
        if (nameMap.contains("low_blue_light") == false) goto L147;
        bytes.add(Byte.valueOf(ParameterName.LOW_BLUE_LIGHT));
    L147:
        if (nameMap.contains("ld_mode") == false) goto L150;
        bytes.add(Byte.valueOf(ParameterName.LD_MODE));
    L150:
        if (nameMap.contains("osd_red_gain") == false) goto L153;
        bytes.add((byte) 48);
    L153:
        if (nameMap.contains("osd_green_gain") == false) goto L156;
        bytes.add((byte) 49);
    L156:
        if (nameMap.contains("osd_blue_gain") == false) goto L159;
        bytes.add((byte) 50);
    L159:
        if (nameMap.contains("osd_red_offset") == false) goto L162;
        bytes.add((byte) 51);
    L162:
        if (nameMap.contains("osd_green_offset") == false) goto L165;
        bytes.add((byte) 52);
    L165:
        if (nameMap.contains("osd_blue_offset") == false) goto L168;
        bytes.add((byte) 53);
    L168:
        if (nameMap.contains("osd_hue") == false) goto L171;
        bytes.add((byte) 54);
    L171:
        if (nameMap.contains("osd_saturation") == false) goto L174;
        bytes.add((byte) 55);
    L174:
        if (nameMap.contains("osd_contrast") == false) goto L177;
        bytes.add(Byte.valueOf(ParameterName.OSD_CONTRAST));
    L177:
        if (nameMap.contains("color_tuner_switch") == false) goto L180;
        bytes.add(Byte.valueOf(ParameterName.COLOR_TUNER_SWITCH));
    L180:
        if (nameMap.contains("color_tuner_hue_red") == false) goto L183;
        bytes.add(Byte.valueOf(ParameterName.COLOR_TUNER_HUE_RED));
    L183:
        if (nameMap.contains("color_tuner_hue_green") == false) goto L186;
        bytes.add(Byte.valueOf(ParameterName.COLOR_TUNER_HUE_GREEN));
    L186:
        if (nameMap.contains("color_tuner_hue_blue") == false) goto L189;
        bytes.add(Byte.valueOf(ParameterName.COLOR_TUNER_HUE_BLUE));
    L189:
        if (nameMap.contains("color_tuner_hue_cyan") == false) goto L192;
        bytes.add(Byte.valueOf(ParameterName.COLOR_TUNER_HUE_CYAN));
    L192:
        if (nameMap.contains("color_tuner_hue_magenta") == false) goto L195;
        bytes.add(Byte.valueOf(ParameterName.COLOR_TUNER_HUE_MAGENTA));
    L195:
        if (nameMap.contains("color_tuner_hue_yellow") == false) goto L198;
        bytes.add(Byte.valueOf(ParameterName.COLOR_TUNER_HUE_YELLOW));
    L198:
        if (nameMap.contains("color_tuner_hue_flesh") == false) goto L201;
        bytes.add(Byte.valueOf(ParameterName.COLOR_TUNER_HUE_FLESH));
    L201:
        if (nameMap.contains("color_tuner_saturation_red") == false) goto L204;
        bytes.add(Byte.valueOf(ParameterName.COLOR_TUNER_SATURATION_RED));
    L204:
        if (nameMap.contains("color_tuner_saturation_green") == false) goto L207;
        bytes.add(Byte.valueOf(ParameterName.COLOR_TUNER_SATURATION_GREEN));
    L207:
        if (nameMap.contains("color_tuner_saturation_blue") == false) goto L210;
        bytes.add(Byte.valueOf(ParameterName.COLOR_TUNER_SATURATION_BLUE));
    L210:
        if (nameMap.contains("color_tuner_saturation_cyan") == false) goto L213;
        bytes.add(Byte.valueOf(ParameterName.COLOR_TUNER_SATURATION_CYAN));
    L213:
        if (nameMap.contains("color_tuner_saturation_magenta") == false) goto L216;
        bytes.add(Byte.valueOf(ParameterName.COLOR_TUNER_SATURATION_MAGENTA));
    L216:
        if (nameMap.contains("color_tuner_saturation_yellow") == false) goto L219;
        bytes.add(Byte.valueOf(ParameterName.COLOR_TUNER_SATURATION_YELLOW));
    L219:
        if (nameMap.contains("color_tuner_saturation_flesh") == false) goto L222;
        bytes.add(Byte.valueOf(ParameterName.COLOR_TUNER_SATURATION_FLESH));
    L222:
        if (nameMap.contains("color_tuner_luminance_red") == false) goto L225;
        bytes.add(Byte.valueOf(ParameterName.COLOR_TUNER_LUMINANCE_RED));
    L225:
        if (nameMap.contains("color_tuner_luminance_green") == false) goto L228;
        bytes.add(Byte.valueOf(ParameterName.COLOR_TUNER_LUMINANCE_GREEN));
    L228:
        if (nameMap.contains("color_tuner_luminance_blue") == false) goto L231;
        bytes.add(Byte.valueOf(ParameterName.COLOR_TUNER_LUMINANCE_BLUE));
    L231:
        if (nameMap.contains("color_tuner_luminance_cyan") == false) goto L234;
        bytes.add((byte) 75);
    L234:
        if (nameMap.contains("color_tuner_luminance_magenta") == false) goto L237;
        bytes.add((byte) 76);
    L237:
        if (nameMap.contains("color_tuner_luminance_yellow") == false) goto L240;
        bytes.add(Byte.valueOf(ParameterName.COLOR_TUNER_LUMINANCE_YELLOW));
    L240:
        if (nameMap.contains("color_tuner_luminance_flesh") == false) goto L243;
        bytes.add(Byte.valueOf(ParameterName.COLOR_TUNER_LUMINANCE_FLESH));
    L243:
        if (nameMap.contains("balance") == false) goto L246;
        bytes.add(Byte.valueOf(ParameterName.BALANCE));
    L246:
        if (nameMap.contains("bass") == false) goto L249;
        bytes.add(Byte.valueOf(ParameterName.BASS));
    L249:
        if (nameMap.contains("treble") == false) goto L252;
        bytes.add(Byte.valueOf(ParameterName.TREBLE));
    L252:
        if (nameMap.contains("surround_sound") == false) goto L255;
        bytes.add(Byte.valueOf(ParameterName.SURROUND_SOUND_ENABLED));
    L255:
        if (nameMap.contains("equalizer_detail") == false) goto L258;
        bytes.add((byte) 83);
    L258:
        if (nameMap.contains("speakers") == false) goto L261;
        bytes.add(Byte.valueOf(ParameterName.SPEAKERS_ENABLED));
    L261:
        if (nameMap.contains("speakers_delay_millis") == false) goto L264;
        bytes.add(Byte.valueOf(ParameterName.SPEAKERS_DELAY_MS));
    L264:
        if (nameMap.contains("earc") == false) goto L267;
        bytes.add(Byte.valueOf(ParameterName.ENHANCED_AUDIO_RETURN_CHANNEL_ENABLED));
    L267:
        if (nameMap.contains("auto_volume_control") == false) goto L270;
        bytes.add(Byte.valueOf(ParameterName.AUTO_VOLUME_CONTROL));
    L270:
        if (nameMap.contains("down_mix_mode") == false) goto L273;
        bytes.add((byte) 88);
    L273:
        if (nameMap.contains("dts_drc") == false) goto L276;
        bytes.add(Byte.valueOf(ParameterName.DTS_DRC));
    L276:
        if (nameMap.contains("dolby_audio_processing") == false) goto L279;
        bytes.add(Byte.valueOf(ParameterName.DOLBY_AUDIO_PROCESSING));
    L279:
        if (nameMap.contains("dialogue_enhancer") == false) goto L282;
        bytes.add(Byte.valueOf(ParameterName.DOLBY_DIALOGUE_ENHANCER));
    L282:
        if (nameMap.contains("dts_virtual_x") == false) goto L285;
        bytes.add(Byte.valueOf(ParameterName.DTS_VIRTUAL_X));
    L285:
        if (nameMap.contains("digital_output_delay_millis") == false) goto L288;
        bytes.add(Byte.valueOf(ParameterName.DIGITAL_OUTPUT_DELAY_MS));
    L288:
        if (nameMap.contains("digital_output_mode") == false) goto L291;
        bytes.add(Byte.valueOf(ParameterName.DIGITAL_OUTPUT));
    L291:
        if (nameMap.contains("sound_style") == false) goto L293;
        bytes.add(Byte.valueOf(ParameterName.SOUND_STYLE));
    L293:
        byte[] byteArray = new byte[bytes.size()];
        int i = 0;
    L295:
        if (i >= bytes.size()) goto L298;
        byteArray[i] = bytes.get(i).byteValue();
        i = i + 1;
        goto L295
    L298:
        return byteArray;
    }

    public static String getParameterName(byte pn) {
        Map<Byte, String> parameterNameMap = new HashMap();
        parameterNameMap.put((byte) 0, "brightness");
        parameterNameMap.put((byte) 1, "contrast");
        parameterNameMap.put((byte) 2, "sharpness");
        parameterNameMap.put((byte) 3, "saturation");
        parameterNameMap.put((byte) 4, "hue");
        parameterNameMap.put((byte) 5, "color_tuner_brightness");
        parameterNameMap.put((byte) 6, "color_tuner_saturation");
        parameterNameMap.put((byte) 7, "color_tuner_hue");
        parameterNameMap.put((byte) 8, "color_tuner_red_offset");
        parameterNameMap.put((byte) 9, "color_tuner_green_offset");
        parameterNameMap.put((byte) 10, "color_tuner_blue_offset");
        parameterNameMap.put((byte) 11, "color_tuner_red_gain");
        parameterNameMap.put((byte) 12, "color_tuner_green_gain");
        parameterNameMap.put((byte) 13, "color_tuner_blue_gain");
        parameterNameMap.put((byte) 14, "noise_reduction");
        parameterNameMap.put((byte) 15, "mpeg_noise_reduction");
        parameterNameMap.put((byte) 16, "flesh_tone");
        parameterNameMap.put(Byte.valueOf(ParameterName.DE_CONTOUR), "decontour");
        parameterNameMap.put(Byte.valueOf(ParameterName.DYNAMIC_LUMA_CONTROL), "dynamic_luma_control");
        parameterNameMap.put(Byte.valueOf(ParameterName.FILM_MODE), "film_mode");
        parameterNameMap.put(Byte.valueOf(ParameterName.BLACK_STRETCH), "black_stretch");
        parameterNameMap.put(Byte.valueOf(ParameterName.BLUE_STRETCH), "blue_stretch");
        parameterNameMap.put(Byte.valueOf(ParameterName.COLOR_TUNE), "color_tune");
        parameterNameMap.put(Byte.valueOf(ParameterName.COLOR_TEMPERATURE), "color_temperature");
        parameterNameMap.put(Byte.valueOf(ParameterName.GLOBE_DIMMING), "global_dimming");
        parameterNameMap.put(Byte.valueOf(ParameterName.AUTO_PICTUREQUALITY_ENABLED), "auto_picture_quality_enabled");
        parameterNameMap.put(Byte.valueOf(ParameterName.AUTO_SUPER_RESOLUTION_ENABLED), "auto_super_resolution_enabled");
        parameterNameMap.put(Byte.valueOf(ParameterName.LEVEL_RANGE), "level_range");
        parameterNameMap.put(Byte.valueOf(ParameterName.GAMUT_MAPPING), "gamut_mapping");
        parameterNameMap.put(Byte.valueOf(ParameterName.PC_MODE), "pc_mode");
        parameterNameMap.put(Byte.valueOf(ParameterName.LOW_LATENCY), "low_latency");
        parameterNameMap.put(Byte.valueOf(ParameterName.VRR), "vrr");
        parameterNameMap.put(Byte.valueOf(ParameterName.CVRR), "cvrr");
        parameterNameMap.put((byte) 33, "hdmi_rgb_range");
        parameterNameMap.put((byte) 34, "color_space");
        parameterNameMap.put((byte) 35, "panel_init_max_lumince_valid");
        parameterNameMap.put((byte) 36, "gamma");
        parameterNameMap.put((byte) 37, "color_temperature_red_gain");
        parameterNameMap.put(Byte.valueOf(ParameterName.COLOR_TEMPERATURE_GREEN_GAIN), "color_temperature_green_gain");
        parameterNameMap.put(Byte.valueOf(ParameterName.COLOR_TEMPERATURE_BLUE_GAIN), "color_temperature_blue_gain");
        parameterNameMap.put(Byte.valueOf(ParameterName.COLOR_TEMPERATURE_RED_OFFSET), "color_temperature_red_offset");
        parameterNameMap.put((byte) 41, "color_temperature_green_offset");
        parameterNameMap.put((byte) 42, "color_temperature_blue_offset");
        parameterNameMap.put(Byte.valueOf(ParameterName.ELEVEN_POINT_RED), "eleven_point_red");
        parameterNameMap.put(Byte.valueOf(ParameterName.ELEVEN_POINT_GREEN), "eleven_point_green");
        parameterNameMap.put(Byte.valueOf(ParameterName.ELEVEN_POINT_BLUE), "eleven_point_blue");
        parameterNameMap.put(Byte.valueOf(ParameterName.LOW_BLUE_LIGHT), "low_blue_light");
        parameterNameMap.put(Byte.valueOf(ParameterName.LD_MODE), "ld_mode");
        parameterNameMap.put((byte) 48, "osd_red_gain");
        parameterNameMap.put((byte) 49, "osd_green_gain");
        parameterNameMap.put((byte) 50, "osd_blue_gain");
        parameterNameMap.put((byte) 51, "osd_red_offset");
        parameterNameMap.put((byte) 52, "osd_green_offset");
        parameterNameMap.put((byte) 53, "osd_blue_offset");
        parameterNameMap.put((byte) 54, "osd_hue");
        parameterNameMap.put((byte) 55, "osd_saturation");
        parameterNameMap.put(Byte.valueOf(ParameterName.OSD_CONTRAST), "osd_contrast");
        parameterNameMap.put(Byte.valueOf(ParameterName.COLOR_TUNER_SWITCH), "color_tuner_switch");
        parameterNameMap.put(Byte.valueOf(ParameterName.COLOR_TUNER_HUE_RED), "color_tuner_hue_red");
        parameterNameMap.put(Byte.valueOf(ParameterName.COLOR_TUNER_HUE_GREEN), "color_tuner_hue_green");
        parameterNameMap.put(Byte.valueOf(ParameterName.COLOR_TUNER_HUE_BLUE), "color_tuner_hue_blue");
        parameterNameMap.put(Byte.valueOf(ParameterName.COLOR_TUNER_HUE_CYAN), "color_tuner_hue_cyan");
        parameterNameMap.put(Byte.valueOf(ParameterName.COLOR_TUNER_HUE_MAGENTA), "color_tuner_hue_magenta");
        parameterNameMap.put(Byte.valueOf(ParameterName.COLOR_TUNER_HUE_YELLOW), "color_tuner_hue_yellow");
        parameterNameMap.put(Byte.valueOf(ParameterName.COLOR_TUNER_HUE_FLESH), "color_tuner_hue_flesh");
        parameterNameMap.put(Byte.valueOf(ParameterName.COLOR_TUNER_SATURATION_RED), "color_tuner_saturation_red");
        parameterNameMap.put(Byte.valueOf(ParameterName.COLOR_TUNER_SATURATION_GREEN), "color_tuner_saturation_green");
        parameterNameMap.put(Byte.valueOf(ParameterName.COLOR_TUNER_SATURATION_BLUE), "color_tuner_saturation_blue");
        parameterNameMap.put(Byte.valueOf(ParameterName.COLOR_TUNER_SATURATION_CYAN), "color_tuner_saturation_cyan");
        parameterNameMap.put(Byte.valueOf(ParameterName.COLOR_TUNER_SATURATION_MAGENTA), "color_tuner_saturation_magenta");
        parameterNameMap.put(Byte.valueOf(ParameterName.COLOR_TUNER_SATURATION_YELLOW), "color_tuner_saturation_yellow");
        parameterNameMap.put(Byte.valueOf(ParameterName.COLOR_TUNER_SATURATION_FLESH), "color_tuner_saturation_flesh");
        parameterNameMap.put(Byte.valueOf(ParameterName.COLOR_TUNER_LUMINANCE_RED), "color_tuner_luminance_red");
        parameterNameMap.put(Byte.valueOf(ParameterName.COLOR_TUNER_LUMINANCE_GREEN), "color_tuner_luminance_green");
        parameterNameMap.put(Byte.valueOf(ParameterName.COLOR_TUNER_LUMINANCE_BLUE), "color_tuner_luminance_blue");
        parameterNameMap.put((byte) 75, "color_tuner_luminance_cyan");
        parameterNameMap.put((byte) 76, "color_tuner_luminance_magenta");
        parameterNameMap.put(Byte.valueOf(ParameterName.COLOR_TUNER_LUMINANCE_YELLOW), "color_tuner_luminance_yellow");
        parameterNameMap.put(Byte.valueOf(ParameterName.COLOR_TUNER_LUMINANCE_FLESH), "color_tuner_luminance_flesh");
        parameterNameMap.put(Byte.valueOf(ParameterName.BALANCE), "balance");
        parameterNameMap.put(Byte.valueOf(ParameterName.BASS), "bass");
        parameterNameMap.put(Byte.valueOf(ParameterName.TREBLE), "treble");
        parameterNameMap.put(Byte.valueOf(ParameterName.SURROUND_SOUND_ENABLED), "surround_sound");
        parameterNameMap.put((byte) 83, "equalizer_detail");
        parameterNameMap.put(Byte.valueOf(ParameterName.SPEAKERS_ENABLED), "speakers");
        parameterNameMap.put(Byte.valueOf(ParameterName.SPEAKERS_DELAY_MS), "speakers_delay_millis");
        parameterNameMap.put(Byte.valueOf(ParameterName.ENHANCED_AUDIO_RETURN_CHANNEL_ENABLED), "earc");
        parameterNameMap.put(Byte.valueOf(ParameterName.AUTO_VOLUME_CONTROL), "auto_volume_control");
        parameterNameMap.put((byte) 88, "down_mix_mode");
        parameterNameMap.put(Byte.valueOf(ParameterName.DTS_DRC), "dts_drc");
        parameterNameMap.put(Byte.valueOf(ParameterName.DOLBY_AUDIO_PROCESSING), "dolby_audio_processing");
        parameterNameMap.put(Byte.valueOf(ParameterName.DOLBY_DIALOGUE_ENHANCER), "dialogue_enhancer");
        parameterNameMap.put(Byte.valueOf(ParameterName.DTS_VIRTUAL_X), "dts_virtual_x");
        parameterNameMap.put(Byte.valueOf(ParameterName.DIGITAL_OUTPUT), "digital_output_mode");
        parameterNameMap.put(Byte.valueOf(ParameterName.DIGITAL_OUTPUT_DELAY_MS), "digital_output_delay_millis");
        parameterNameMap.put(Byte.valueOf(ParameterName.SOUND_STYLE), "sound_style");
        return parameterNameMap.get(Byte.valueOf(pn));
    }

    public static Bundle convertToCaps(int type, ParameterRange range) {
        Bundle bundle = new Bundle();
        if (range != null) goto L5;
    L16:
        return bundle;
    L5:
        if (range.numRange == null) goto L16;
        int type2 = type - 1;
        if (type2 != 0) goto L11;
        bundle.putObject("min", Integer.valueOf(range.numRange.getIntMinMax()[0]));
        bundle.putObject("max", Integer.valueOf(range.numRange.getIntMinMax()[1]));
    L15:
        return bundle;
    L11:
        if (type2 != 2) goto L13;
        bundle.putObject("min", Double.valueOf(range.numRange.getDoubleMinMax()[0]));
        bundle.putObject("max", Double.valueOf(range.numRange.getDoubleMinMax()[1]));
        goto L15
    L13:
        if (type2 != 1) goto L15;
        bundle.putObject("min", Long.valueOf(range.numRange.getLongMinMax()[0]));
        bundle.putObject("max", Long.valueOf(range.numRange.getLongMinMax()[1]));
        goto L15
    }

    private static String getTempId(BiMap<Long, String> map, Cursor cursor) {
        int colIndex = cursor.getColumnIndex("_id");
        if (colIndex == (-1)) goto L5;
        Long dbId = Long.valueOf(cursor.getLong(colIndex));
    L6:
        populateTempIdMap(map, dbId);
        return map.getValue(dbId);
    L5:
        dbId = null;
        goto L6
    }

    private static int getType(Cursor cursor) {
        int colIndex = cursor.getColumnIndex("_type");
        if (colIndex != (-1)) goto L7;
        return 0;
    L7:
        return cursor.getInt(colIndex);
    }

    private static String getName(Cursor cursor) {
        int colIndex = cursor.getColumnIndex("_name");
        if (colIndex != (-1)) goto L7;
        return null;
    L7:
        return cursor.getString(colIndex);
    }

    private static String getInputId(Cursor cursor) {
        int colIndex = cursor.getColumnIndex("_input_id");
        if (colIndex != (-1)) goto L7;
        return null;
    L7:
        return cursor.getString(colIndex);
    }

    private static String getPackageName(Cursor cursor) {
        int colIndex = cursor.getColumnIndex("_package");
        if (colIndex != (-1)) goto L7;
        return null;
    L7:
        return cursor.getString(colIndex);
    }

    private static String getSettingsString(Cursor cursor) {
        int colIndex = cursor.getColumnIndex("settings");
        if (colIndex != (-1)) goto L7;
        return null;
    L7:
        return cursor.getString(colIndex);
    }

    private static byte mapQualityLevel(String qualityLevel) {
        switch(qualityLevel.hashCode()) {
            case -1655895015: goto L15;
            case -1655892428: goto L12;
            case 206736765: goto L9;
            case 1244902544: goto L6;
            default: goto L17;
        };
    L17:
        byte r0 = -1;
    L18:
        switch(r0) {
            case 0: goto L24;
            case 1: goto L28;
            case 2: goto L27;
            case 3: goto L26;
            default: goto L19;
        };
    L19:
        Log.e("PictureParams", "Invalid noise_reduction string: " + qualityLevel);
        return 0;
    L28:
        return 1;
    L26:
        return 3;
    L27:
        return 2;
    L24:
        return 0;
    L6:
        if (qualityLevel.equals("level_medium") == false) goto L17;
        r0 = 2;
        goto L18
    L9:
        if (qualityLevel.equals("level_high") == false) goto L17;
        r0 = 3;
        goto L18
    L12:
        if (qualityLevel.equals("level_off") == false) goto L17;
        r0 = 0;
        goto L18
    L15:
        if (qualityLevel.equals("level_low") == false) goto L17;
        r0 = 1;
        goto L18
    }

    private MediaQualityUtils() {
    }
}
