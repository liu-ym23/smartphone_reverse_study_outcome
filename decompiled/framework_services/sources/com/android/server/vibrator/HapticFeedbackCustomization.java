package com.android.server.vibrator;

import android.R;
import android.content.res.Resources;
import android.content.res.XmlResourceParser;
import android.os.VibrationEffect;
import android.os.VibratorInfo;
import android.os.vibrator.persistence.ParsedVibration;
import android.os.vibrator.persistence.VibrationXmlParser;
import android.text.TextUtils;
import android.util.Slog;
import android.util.SparseArray;
import android.util.Xml;
import com.android.internal.util.XmlUtils;
import com.android.internal.vibrator.persistence.XmlParserException;
import com.android.internal.vibrator.persistence.XmlReader;
import com.android.internal.vibrator.persistence.XmlValidator;
import com.android.modules.utils.TypedXmlPullParser;
import com.android.server.usb.descriptors.UsbACInterface;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.Locale;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: loaded from: classes3.dex */
final class HapticFeedbackCustomization {
    private static final String ATTRIBUTE_ID = "id";
    private static final String TAG = "HapticFeedbackCustomization";
    private static final String TAG_CONSTANT = "constant";
    private static final String TAG_CONSTANTS = "haptic-feedback-constants";
    private final SparseArray<VibrationEffect> mHapticCustomizations;
    private final SparseArray<VibrationEffect> mHapticCustomizationsForSourceRotary;
    private final SparseArray<VibrationEffect> mHapticCustomizationsForSourceTouchScreen;

    HapticFeedbackCustomization(Resources res, VibratorInfo vibratorInfo) {
        SparseArray<VibrationEffect> hapticCustomizations = loadCustomizedFeedbackVibrationFromFile(res, vibratorInfo);
        if (hapticCustomizations.size() != 0) goto L5;
        hapticCustomizations = loadCustomizedFeedbackVibrationFromRes(res, vibratorInfo, R.xml.haptic_feedback_customization);
    L5:
        this.mHapticCustomizations = hapticCustomizations;
        this.mHapticCustomizationsForSourceRotary = loadCustomizedFeedbackVibrationFromRes(res, vibratorInfo, R.xml.haptic_feedback_customization_source_rotary_encoder);
        this.mHapticCustomizationsForSourceTouchScreen = loadCustomizedFeedbackVibrationFromRes(res, vibratorInfo, R.xml.haptic_feedback_customization_source_touchscreen);
    }

    HapticFeedbackCustomization(SparseArray<VibrationEffect> hapticCustomizations, SparseArray<VibrationEffect> hapticCustomizationsForSourceRotary, SparseArray<VibrationEffect> hapticCustomizationsForSourceTouchScreen) {
        this.mHapticCustomizations = hapticCustomizations;
        this.mHapticCustomizationsForSourceRotary = hapticCustomizationsForSourceRotary;
        this.mHapticCustomizationsForSourceTouchScreen = hapticCustomizationsForSourceTouchScreen;
    }

    VibrationEffect getEffect(int effectId) {
        return this.mHapticCustomizations.get(effectId);
    }

    VibrationEffect getEffect(int effectId, int inputSource) {
        VibrationEffect resultVibration = null;
        if ((4194304 & inputSource) == 0) goto L6;
        VibrationEffect resultVibration2 = this.mHapticCustomizationsForSourceRotary.get(effectId);
        resultVibration = resultVibration2;
    L8:
        if (resultVibration != null) goto L11;
        VibrationEffect resultVibration3 = this.mHapticCustomizations.get(effectId);
        return resultVibration3;
    L11:
        return resultVibration;
    L6:
        if ((inputSource & UsbACInterface.FORMAT_II_AC3) == 0) goto L8;
        VibrationEffect resultVibration4 = this.mHapticCustomizationsForSourceTouchScreen.get(effectId);
        resultVibration = resultVibration4;
        goto L8
    }

    private static SparseArray<VibrationEffect> loadCustomizedFeedbackVibrationFromFile(Resources res, VibratorInfo vibratorInfo) {
        TypedXmlPullParser parser = readCustomizationFile(res);     // Catch: Throwable -> L7
        if (parser != null) goto L10;
        Slog.d(TAG, "No loadable haptic feedback customization from file.");     // Catch: Throwable -> L7
        return new SparseArray();
    L10:
        return parseVibrations(parser, vibratorInfo);
    L7:
        e = move-exception;
        Slog.e(TAG, "Error parsing haptic feedback customizations from file", e);
        return new SparseArray();
    }

    private static SparseArray<VibrationEffect> loadCustomizedFeedbackVibrationFromRes(Resources res, VibratorInfo vibratorInfo, int xmlResId) {
        TypedXmlPullParser parser = readCustomizationResources(res, xmlResId);     // Catch: Throwable -> L7
        if (parser != null) goto L10;
        Slog.d(TAG, "No loadable haptic feedback customization from res.");     // Catch: Throwable -> L7
        return new SparseArray();
    L10:
        return parseVibrations(parser, vibratorInfo);
    L7:
        e = move-exception;
        Slog.e(TAG, "Error parsing haptic feedback customizations from res", e);
        return new SparseArray();
    }

    private static TypedXmlPullParser readCustomizationFile(Resources res) throws XmlPullParserException {
        String customizationFile = res.getString(R.string.config_primaryShortPressTargetActivity);     // Catch: Resources.NotFoundException -> L13
        if (TextUtils.isEmpty(customizationFile) == false) goto L18;
        return null;
    L18:
        Reader customizationReader = new FileReader(customizationFile);     // Catch: FileNotFoundException -> L10
        TypedXmlPullParser parser = Xml.newFastPullParser();
        parser.setFeature("http://xmlpull.org/v1/doc/features.html#process-namespaces", true);
        parser.setInput(customizationReader);
        Slog.d(TAG, "Successfully opened customization file.");
        return parser;
    L10:
        e = move-exception;
        Slog.e(TAG, "Specified customization file not found.", e);
        return null;
    L13:
        e = move-exception;
        Slog.e(TAG, "Customization file directory config not found.", e);
        return null;
    }

    private static TypedXmlPullParser readCustomizationResources(Resources res, int xmlResId) {
        XmlResourceParser resParser = res.getXml(xmlResId);     // Catch: Resources.NotFoundException -> L6
        Slog.d(TAG, "Successfully opened customization resource.");
        return XmlUtils.makeTyped(resParser);
    L6:
        e = move-exception;
        Slog.e(TAG, "Haptic customization resource not found.", e);
        return null;
    }

    private static SparseArray<VibrationEffect> parseVibrations(TypedXmlPullParser parser, VibratorInfo vibratorInfo) throws XmlPullParserException, IOException, XmlParserException {
        XmlUtils.beginDocument(parser, TAG_CONSTANTS);
        XmlValidator.checkTagHasNoUnexpectedAttributes(parser, new String[0]);
        int rootDepth = parser.getDepth();
        SparseArray<VibrationEffect> mapping = new SparseArray();
    L4:
        if (XmlReader.readNextTagWithin(parser, rootDepth) == false) goto L17;
        XmlValidator.checkStartTag(parser, TAG_CONSTANT);
        int customizationDepth = parser.getDepth();
        XmlValidator.checkTagHasNoUnexpectedAttributes(parser, new String[]{ATTRIBUTE_ID});
        int effectId = XmlReader.readAttributeIntNonNegative(parser, ATTRIBUTE_ID);
        if (mapping.contains(effectId) == true) goto L7;
        XmlValidator.checkParserCondition(XmlReader.readNextTagWithin(parser, customizationDepth), "Unsupported empty customization tag for effect " + effectId, new Object[0]);
        ParsedVibration parsedVibration = VibrationXmlParser.parseElement(parser, 1);
        VibrationEffect effect = parsedVibration.resolve(vibratorInfo);
        if (effect == null) goto L16;
        if (effect.getDuration() == Long.MAX_VALUE) goto L13;
        mapping.put(effectId, effect);
        goto L16
    L13:
        Slog.e(TAG, String.format(Locale.getDefault(), "Vibration for effect ID %d is repeating, which is not allowed as a haptic feedback: %s", new Object[]{Integer.valueOf(effectId), effect}));
        return new SparseArray();
    L16:
        XmlReader.readEndTag(parser, TAG_CONSTANT, customizationDepth);
        goto L4
    L7:
        Slog.e(TAG, "Multiple customizations found for effect " + effectId);
        return new SparseArray();
    L17:
        XmlReader.readEndTag(parser, TAG_CONSTANTS, rootDepth);
        XmlReader.readDocumentEndTag(parser);
        return mapping;
    }
}
