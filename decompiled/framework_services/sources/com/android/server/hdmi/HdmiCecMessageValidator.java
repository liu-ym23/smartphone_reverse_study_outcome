package com.android.server.hdmi;

import android.hardware.audio.common.V2_0.AudioChannelMask;
import android.hardware.tv.hdmi.cec.CecDeviceType;
import android.util.SparseArray;
import com.android.internal.util.FrameworkStatsLog;

/* JADX INFO: loaded from: classes2.dex */
public class HdmiCecMessageValidator {
    static final int ADDR_ALL = 65535;
    static final int ADDR_AUDIO_SYSTEM = 32;
    static final int ADDR_BACKUP_1 = 4096;
    static final int ADDR_BACKUP_2 = 8192;
    static final int ADDR_BROADCAST = 32768;
    static final int ADDR_DIRECT = 32767;
    static final int ADDR_NOT_UNREGISTERED = 32767;
    static final int ADDR_PLAYBACK_1 = 16;
    static final int ADDR_PLAYBACK_2 = 256;
    static final int ADDR_PLAYBACK_3 = 2048;
    static final int ADDR_RECORDER_1 = 2;
    static final int ADDR_RECORDER_2 = 4;
    static final int ADDR_RECORDER_3 = 512;
    static final int ADDR_SPECIFIC_USE = 16384;
    static final int ADDR_TUNER_1 = 8;
    static final int ADDR_TUNER_2 = 64;
    static final int ADDR_TUNER_3 = 128;
    static final int ADDR_TUNER_4 = 1024;
    static final int ADDR_TV = 1;
    static final int ADDR_UNREGISTERED = 32768;
    static final int ERROR_DESTINATION = 2;
    static final int ERROR_PARAMETER = 3;
    static final int ERROR_PARAMETER_LONG = 5;
    static final int ERROR_PARAMETER_SHORT = 4;
    static final int ERROR_SOURCE = 1;
    static final int OK = 0;
    private static final String TAG = "HdmiCecMessageValidator";
    private static final SparseArray<ValidationInfo> sValidationInfo = null;

    private static class AnalogueTimerValidator implements ParameterValidator {
        /* synthetic */ AnalogueTimerValidator(HdmiCecMessageValidatorIA r1) {
            this();
        }

        private AnalogueTimerValidator() {
        }

        @Override // com.android.server.hdmi.HdmiCecMessageValidator.ParameterValidator
        public int isValid(byte[] params) {
            if (params.length >= 11) goto L5;
            return 4;
        L5:
            boolean r0 = false;
            if (HdmiCecMessageValidator.m4311$$Nest$smisValidDayOfMonth(params[0]) == false) goto L28;
            if (HdmiCecMessageValidator.m4318$$Nest$smisValidMonthOfYear(params[1]) == false) goto L28;
            if (HdmiCecMessageValidator.m4316$$Nest$smisValidHour(params[2]) == false) goto L28;
            if (HdmiCecMessageValidator.m4317$$Nest$smisValidMinute(params[3]) == false) goto L28;
            if (HdmiCecMessageValidator.m4314$$Nest$smisValidDurationHours(params[4]) == false) goto L28;
            if (HdmiCecMessageValidator.m4317$$Nest$smisValidMinute(params[5]) == false) goto L28;
            if (HdmiCecMessageValidator.m4321$$Nest$smisValidRecordingSequence(params[6]) == false) goto L28;
            if (HdmiCecMessageValidator.m4306$$Nest$smisValidAnalogueBroadcastType(params[7]) == false) goto L28;
            if (HdmiCecMessageValidator.m4307$$Nest$smisValidAnalogueFrequency(HdmiUtils.twoBytesToInt(params, 8)) == false) goto L28;
            if (HdmiCecMessageValidator.m4309$$Nest$smisValidBroadcastSystem(params[10]) == false) goto L28;
            r0 = true;
        L28:
            return HdmiCecMessageValidator.m4327$$Nest$smtoErrorCode(r0);
        }
    }

    private static class AsciiValidator implements ParameterValidator {
        private final int mMaxLength;
        private final int mMinLength;

        AsciiValidator(int length) {
            this.mMinLength = length;
            this.mMaxLength = length;
        }

        AsciiValidator(int minLength, int maxLength) {
            this.mMinLength = minLength;
            this.mMaxLength = maxLength;
        }

        @Override // com.android.server.hdmi.HdmiCecMessageValidator.ParameterValidator
        public int isValid(byte[] params) {
            if (params.length >= this.mMinLength) goto L7;
            return 4;
        L7:
            return HdmiCecMessageValidator.m4327$$Nest$smtoErrorCode(HdmiCecMessageValidator.m4308$$Nest$smisValidAsciiString(params, 0, this.mMaxLength));
        }
    }

    private static class DigitalTimerValidator implements ParameterValidator {
        /* synthetic */ DigitalTimerValidator(HdmiCecMessageValidatorIA r1) {
            this();
        }

        private DigitalTimerValidator() {
        }

        @Override // com.android.server.hdmi.HdmiCecMessageValidator.ParameterValidator
        public int isValid(byte[] params) {
            if (params.length >= 11) goto L5;
            return 4;
        L5:
            boolean r0 = false;
            if (HdmiCecMessageValidator.m4311$$Nest$smisValidDayOfMonth(params[0]) == false) goto L24;
            if (HdmiCecMessageValidator.m4318$$Nest$smisValidMonthOfYear(params[1]) == false) goto L24;
            if (HdmiCecMessageValidator.m4316$$Nest$smisValidHour(params[2]) == false) goto L24;
            if (HdmiCecMessageValidator.m4317$$Nest$smisValidMinute(params[3]) == false) goto L24;
            if (HdmiCecMessageValidator.m4314$$Nest$smisValidDurationHours(params[4]) == false) goto L24;
            if (HdmiCecMessageValidator.m4317$$Nest$smisValidMinute(params[5]) == false) goto L24;
            if (HdmiCecMessageValidator.m4321$$Nest$smisValidRecordingSequence(params[6]) == false) goto L24;
            if (HdmiCecMessageValidator.m4312$$Nest$smisValidDigitalServiceIdentification(params, 7) == false) goto L24;
            r0 = true;
        L24:
            return HdmiCecMessageValidator.m4327$$Nest$smtoErrorCode(r0);
        }
    }

    private static class ExternalTimerValidator implements ParameterValidator {
        /* synthetic */ ExternalTimerValidator(HdmiCecMessageValidatorIA r1) {
            this();
        }

        private ExternalTimerValidator() {
        }

        @Override // com.android.server.hdmi.HdmiCecMessageValidator.ParameterValidator
        public int isValid(byte[] params) {
            if (params.length >= 9) goto L5;
            return 4;
        L5:
            boolean r0 = false;
            if (HdmiCecMessageValidator.m4311$$Nest$smisValidDayOfMonth(params[0]) == false) goto L24;
            if (HdmiCecMessageValidator.m4318$$Nest$smisValidMonthOfYear(params[1]) == false) goto L24;
            if (HdmiCecMessageValidator.m4316$$Nest$smisValidHour(params[2]) == false) goto L24;
            if (HdmiCecMessageValidator.m4317$$Nest$smisValidMinute(params[3]) == false) goto L24;
            if (HdmiCecMessageValidator.m4314$$Nest$smisValidDurationHours(params[4]) == false) goto L24;
            if (HdmiCecMessageValidator.m4317$$Nest$smisValidMinute(params[5]) == false) goto L24;
            if (HdmiCecMessageValidator.m4321$$Nest$smisValidRecordingSequence(params[6]) == false) goto L24;
            if (HdmiCecMessageValidator.m4315$$Nest$smisValidExternalSource(params, 7) == false) goto L24;
            r0 = true;
        L24:
            return HdmiCecMessageValidator.m4327$$Nest$smtoErrorCode(r0);
        }
    }

    private static class FixedLengthValidator implements ParameterValidator {
        private final int mLength;

        public FixedLengthValidator(int length) {
            this.mLength = length;
        }

        @Override // com.android.server.hdmi.HdmiCecMessageValidator.ParameterValidator
        public int isValid(byte[] params) {
            if (params.length >= this.mLength) goto L5;
            return 4;
        L5:
            return 0;
        }
    }

    private static class MinimumOneByteRangeValidator implements ParameterValidator {
        private final int mMaxValue;
        private final int mMinValue;

        MinimumOneByteRangeValidator(int minValue, int maxValue) {
            this.mMinValue = minValue;
            this.mMaxValue = maxValue;
        }

        @Override // com.android.server.hdmi.HdmiCecMessageValidator.ParameterValidator
        public int isValid(byte[] params) {
            if (params.length >= 1) goto L7;
            return 4;
        L7:
            return HdmiCecMessageValidator.m4327$$Nest$smtoErrorCode(HdmiCecMessageValidator.m4326$$Nest$smisWithinRange(params[0], this.mMinValue, this.mMaxValue));
        }
    }

    private static class OsdStringValidator implements ParameterValidator {
        /* synthetic */ OsdStringValidator(HdmiCecMessageValidatorIA r1) {
            this();
        }

        private OsdStringValidator() {
        }

        @Override // com.android.server.hdmi.HdmiCecMessageValidator.ParameterValidator
        public int isValid(byte[] params) {
            if (params.length >= 2) goto L6;
            return 4;
        L6:
            boolean r0 = false;
            if (HdmiCecMessageValidator.m4313$$Nest$smisValidDisplayControl(params[0]) == false) goto L13;
            if (HdmiCecMessageValidator.m4308$$Nest$smisValidAsciiString(params, 1, 14) == false) goto L13;
            r0 = true;
        L13:
            return HdmiCecMessageValidator.m4327$$Nest$smtoErrorCode(r0);
        }
    }

    interface ParameterValidator {
        int isValid(byte[] r1);
    }

    private static class PhysicalAddressValidator implements ParameterValidator {
        /* synthetic */ PhysicalAddressValidator(HdmiCecMessageValidatorIA r1) {
            this();
        }

        private PhysicalAddressValidator() {
        }

        @Override // com.android.server.hdmi.HdmiCecMessageValidator.ParameterValidator
        public int isValid(byte[] params) {
            if (params.length >= 2) goto L7;
            return 4;
        L7:
            return HdmiCecMessageValidator.m4327$$Nest$smtoErrorCode(HdmiCecMessageValidator.m4319$$Nest$smisValidPhysicalAddress(params, 0));
        }
    }

    private static class PlayModeValidator implements ParameterValidator {
        /* synthetic */ PlayModeValidator(HdmiCecMessageValidatorIA r1) {
            this();
        }

        private PlayModeValidator() {
        }

        @Override // com.android.server.hdmi.HdmiCecMessageValidator.ParameterValidator
        public int isValid(byte[] params) {
            if (params.length >= 1) goto L7;
            return 4;
        L7:
            return HdmiCecMessageValidator.m4327$$Nest$smtoErrorCode(HdmiCecMessageValidator.m4320$$Nest$smisValidPlayMode(params[0]));
        }
    }

    private static class RecordStatusInfoValidator implements ParameterValidator {
        /* synthetic */ RecordStatusInfoValidator(HdmiCecMessageValidatorIA r1) {
            this();
        }

        private RecordStatusInfoValidator() {
        }

        @Override // com.android.server.hdmi.HdmiCecMessageValidator.ParameterValidator
        public int isValid(byte[] params) {
            boolean r1 = true;
            if (params.length >= 1) goto L7;
            return 4;
        L7:
            if (HdmiCecMessageValidator.m4326$$Nest$smisWithinRange(params[0], 1, 7) == true) goto L20;
            if (HdmiCecMessageValidator.m4326$$Nest$smisWithinRange(params[0], 9, 14) == true) goto L20;
            if (HdmiCecMessageValidator.m4326$$Nest$smisWithinRange(params[0], 16, 23) == true) goto L20;
            if (HdmiCecMessageValidator.m4326$$Nest$smisWithinRange(params[0], 26, 27) == true) goto L20;
            if (params[0] == 31) goto L20;
            r1 = false;
        L20:
            return HdmiCecMessageValidator.m4327$$Nest$smtoErrorCode(r1);
        }
    }

    private static class ReportPhysicalAddressValidator implements ParameterValidator {
        /* synthetic */ ReportPhysicalAddressValidator(HdmiCecMessageValidatorIA r1) {
            this();
        }

        private ReportPhysicalAddressValidator() {
        }

        @Override // com.android.server.hdmi.HdmiCecMessageValidator.ParameterValidator
        public int isValid(byte[] params) {
            if (params.length >= 3) goto L6;
            return 4;
        L6:
            boolean r0 = false;
            if (HdmiCecMessageValidator.m4319$$Nest$smisValidPhysicalAddress(params, 0) == false) goto L12;
            if (HdmiCecMessageValidator.isValidType(params[2]) == false) goto L12;
            r0 = true;
        L12:
            return HdmiCecMessageValidator.m4327$$Nest$smtoErrorCode(r0);
        }
    }

    private static class RoutingChangeValidator implements ParameterValidator {
        /* synthetic */ RoutingChangeValidator(HdmiCecMessageValidatorIA r1) {
            this();
        }

        private RoutingChangeValidator() {
        }

        @Override // com.android.server.hdmi.HdmiCecMessageValidator.ParameterValidator
        public int isValid(byte[] params) {
            if (params.length >= 4) goto L5;
            return 4;
        L5:
            boolean r0 = false;
            if (HdmiCecMessageValidator.m4319$$Nest$smisValidPhysicalAddress(params, 0) == false) goto L11;
            if (HdmiCecMessageValidator.m4319$$Nest$smisValidPhysicalAddress(params, 2) == false) goto L11;
            r0 = true;
        L11:
            return HdmiCecMessageValidator.m4327$$Nest$smtoErrorCode(r0);
        }
    }

    private static class SelectAnalogueServiceValidator implements ParameterValidator {
        /* synthetic */ SelectAnalogueServiceValidator(HdmiCecMessageValidatorIA r1) {
            this();
        }

        private SelectAnalogueServiceValidator() {
        }

        @Override // com.android.server.hdmi.HdmiCecMessageValidator.ParameterValidator
        public int isValid(byte[] params) {
            if (params.length >= 4) goto L5;
            return 4;
        L5:
            boolean r0 = false;
            if (HdmiCecMessageValidator.m4306$$Nest$smisValidAnalogueBroadcastType(params[0]) == false) goto L14;
            if (HdmiCecMessageValidator.m4307$$Nest$smisValidAnalogueFrequency(HdmiUtils.twoBytesToInt(params, 1)) == false) goto L14;
            if (HdmiCecMessageValidator.m4309$$Nest$smisValidBroadcastSystem(params[3]) == false) goto L14;
            r0 = true;
        L14:
            return HdmiCecMessageValidator.m4327$$Nest$smtoErrorCode(r0);
        }
    }

    private static class SelectDigitalServiceValidator implements ParameterValidator {
        /* synthetic */ SelectDigitalServiceValidator(HdmiCecMessageValidatorIA r1) {
            this();
        }

        private SelectDigitalServiceValidator() {
        }

        @Override // com.android.server.hdmi.HdmiCecMessageValidator.ParameterValidator
        public int isValid(byte[] params) {
            if (params.length >= 4) goto L6;
            return 4;
        L6:
            return HdmiCecMessageValidator.m4327$$Nest$smtoErrorCode(HdmiCecMessageValidator.m4312$$Nest$smisValidDigitalServiceIdentification(params, 0));
        }
    }

    private static class SingleByteRangeValidator implements ParameterValidator {
        private final int mMaxValue;
        private final int mMinValue;

        SingleByteRangeValidator(int minValue, int maxValue) {
            this.mMinValue = minValue;
            this.mMaxValue = maxValue;
        }

        @Override // com.android.server.hdmi.HdmiCecMessageValidator.ParameterValidator
        public int isValid(byte[] params) {
            if (params.length >= 1) goto L7;
            return 4;
        L7:
            if (params.length <= 1) goto L11;
            return 5;
        L11:
            return HdmiCecMessageValidator.m4327$$Nest$smtoErrorCode(HdmiCecMessageValidator.m4326$$Nest$smisWithinRange(params[0], this.mMinValue, this.mMaxValue));
        }
    }

    private static class SystemAudioModeRequestValidator extends PhysicalAddressValidator {
        /* synthetic */ SystemAudioModeRequestValidator(HdmiCecMessageValidatorIA r1) {
            this();
        }

        private SystemAudioModeRequestValidator() {
            super(null);
        }

        @Override // com.android.server.hdmi.HdmiCecMessageValidator.PhysicalAddressValidator, com.android.server.hdmi.HdmiCecMessageValidator.ParameterValidator
        public int isValid(byte[] params) {
            if (params.length != 0) goto L7;
            return 0;
        L7:
            return super.isValid(params);
        }
    }

    private static class TimerClearedStatusValidator implements ParameterValidator {
        /* synthetic */ TimerClearedStatusValidator(HdmiCecMessageValidatorIA r1) {
            this();
        }

        private TimerClearedStatusValidator() {
        }

        @Override // com.android.server.hdmi.HdmiCecMessageValidator.ParameterValidator
        public int isValid(byte[] params) {
            boolean r1 = true;
            if (params.length >= 1) goto L7;
            return 4;
        L7:
            if (HdmiCecMessageValidator.m4326$$Nest$smisWithinRange(params[0], 0, 2) == true) goto L13;
            if ((params[0] & CecDeviceType.INACTIVE) == 128) goto L13;
            r1 = false;
        L13:
            return HdmiCecMessageValidator.m4327$$Nest$smtoErrorCode(r1);
        }
    }

    private static class TimerStatusValidator implements ParameterValidator {
        /* synthetic */ TimerStatusValidator(HdmiCecMessageValidatorIA r1) {
            this();
        }

        private TimerStatusValidator() {
        }

        @Override // com.android.server.hdmi.HdmiCecMessageValidator.ParameterValidator
        public int isValid(byte[] params) {
            if (params.length >= 1) goto L7;
            return 4;
        L7:
            return HdmiCecMessageValidator.m4327$$Nest$smtoErrorCode(HdmiCecMessageValidator.m4322$$Nest$smisValidTimerStatusData(params, 0));
        }
    }

    private static class TunerDeviceStatusValidator implements ParameterValidator {
        /* synthetic */ TunerDeviceStatusValidator(HdmiCecMessageValidatorIA r1) {
            this();
        }

        private TunerDeviceStatusValidator() {
        }

        @Override // com.android.server.hdmi.HdmiCecMessageValidator.ParameterValidator
        public int isValid(byte[] params) {
            if (params.length >= 1) goto L7;
            return 4;
        L7:
            return HdmiCecMessageValidator.m4327$$Nest$smtoErrorCode(HdmiCecMessageValidator.m4323$$Nest$smisValidTunerDeviceInfo(params));
        }
    }

    private static class UserControlPressedValidator implements ParameterValidator {
        /* synthetic */ UserControlPressedValidator(HdmiCecMessageValidatorIA r1) {
            this();
        }

        private UserControlPressedValidator() {
        }

        @Override // com.android.server.hdmi.HdmiCecMessageValidator.ParameterValidator
        public int isValid(byte[] params) {
            if (params.length >= 1) goto L6;
            return 4;
        L6:
            if (params.length != 1) goto L8;
            return 0;
        L8:
            int uiCommand = params[0];
            switch(uiCommand) {
                case 86: goto L21;
                case 87: goto L19;
                case 96: goto L17;
                case 103: goto L12;
                default: goto L10;
            };
        L10:
            return 0;
        L12:
            if (params.length >= 4) goto L15;
            return 4;
        L15:
            return HdmiCecMessageValidator.m4327$$Nest$smtoErrorCode(HdmiCecMessageValidator.m4310$$Nest$smisValidChannelIdentifier(params, 1));
        L17:
            return HdmiCecMessageValidator.m4327$$Nest$smtoErrorCode(HdmiCecMessageValidator.m4320$$Nest$smisValidPlayMode(params[1]));
        L19:
            return HdmiCecMessageValidator.m4327$$Nest$smtoErrorCode(HdmiCecMessageValidator.m4325$$Nest$smisValidUiSoundPresenationControl(params[1]));
        L21:
            return HdmiCecMessageValidator.m4327$$Nest$smtoErrorCode(HdmiCecMessageValidator.m4324$$Nest$smisValidUiBroadcastType(params[1]));
        }
    }

    private static class ValidationInfo {
        public final ParameterValidator parameterValidator;
        public final int validDestinations;
        public final int validSources;

        ValidationInfo(ParameterValidator parameterValidator, int validSources, int validDestinations) {
            this.parameterValidator = parameterValidator;
            this.validSources = validSources;
            this.validDestinations = validDestinations;
        }
    }

    public @interface ValidationResult {
    }

    private static class VariableLengthValidator implements ParameterValidator {
        private final int mMaxLength;
        private final int mMinLength;

        public VariableLengthValidator(int minLength, int maxLength) {
            this.mMinLength = minLength;
            this.mMaxLength = maxLength;
        }

        @Override // com.android.server.hdmi.HdmiCecMessageValidator.ParameterValidator
        public int isValid(byte[] params) {
            if (params.length >= this.mMinLength) goto L5;
            return 4;
        L5:
            return 0;
        }
    }

    /* JADX INFO: renamed from: -$$Nest$smisValidAnalogueBroadcastType, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m4306$$Nest$smisValidAnalogueBroadcastType(int r0) {
        return isValidAnalogueBroadcastType(r0);
    }

    /* JADX INFO: renamed from: -$$Nest$smisValidAnalogueFrequency, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m4307$$Nest$smisValidAnalogueFrequency(int r0) {
        return isValidAnalogueFrequency(r0);
    }

    /* JADX INFO: renamed from: -$$Nest$smisValidAsciiString, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m4308$$Nest$smisValidAsciiString(byte[] r0, int r1, int r2) {
        return isValidAsciiString(r0, r1, r2);
    }

    /* JADX INFO: renamed from: -$$Nest$smisValidBroadcastSystem, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m4309$$Nest$smisValidBroadcastSystem(int r0) {
        return isValidBroadcastSystem(r0);
    }

    /* JADX INFO: renamed from: -$$Nest$smisValidChannelIdentifier, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m4310$$Nest$smisValidChannelIdentifier(byte[] r0, int r1) {
        return isValidChannelIdentifier(r0, r1);
    }

    /* JADX INFO: renamed from: -$$Nest$smisValidDayOfMonth, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m4311$$Nest$smisValidDayOfMonth(int r0) {
        return isValidDayOfMonth(r0);
    }

    /* JADX INFO: renamed from: -$$Nest$smisValidDigitalServiceIdentification, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m4312$$Nest$smisValidDigitalServiceIdentification(byte[] r0, int r1) {
        return isValidDigitalServiceIdentification(r0, r1);
    }

    /* JADX INFO: renamed from: -$$Nest$smisValidDisplayControl, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m4313$$Nest$smisValidDisplayControl(int r0) {
        return isValidDisplayControl(r0);
    }

    /* JADX INFO: renamed from: -$$Nest$smisValidDurationHours, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m4314$$Nest$smisValidDurationHours(int r0) {
        return isValidDurationHours(r0);
    }

    /* JADX INFO: renamed from: -$$Nest$smisValidExternalSource, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m4315$$Nest$smisValidExternalSource(byte[] r0, int r1) {
        return isValidExternalSource(r0, r1);
    }

    /* JADX INFO: renamed from: -$$Nest$smisValidHour, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m4316$$Nest$smisValidHour(int r0) {
        return isValidHour(r0);
    }

    /* JADX INFO: renamed from: -$$Nest$smisValidMinute, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m4317$$Nest$smisValidMinute(int r0) {
        return isValidMinute(r0);
    }

    /* JADX INFO: renamed from: -$$Nest$smisValidMonthOfYear, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m4318$$Nest$smisValidMonthOfYear(int r0) {
        return isValidMonthOfYear(r0);
    }

    /* JADX INFO: renamed from: -$$Nest$smisValidPhysicalAddress, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m4319$$Nest$smisValidPhysicalAddress(byte[] r0, int r1) {
        return isValidPhysicalAddress(r0, r1);
    }

    /* JADX INFO: renamed from: -$$Nest$smisValidPlayMode, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m4320$$Nest$smisValidPlayMode(int r0) {
        return isValidPlayMode(r0);
    }

    /* JADX INFO: renamed from: -$$Nest$smisValidRecordingSequence, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m4321$$Nest$smisValidRecordingSequence(int r0) {
        return isValidRecordingSequence(r0);
    }

    /* JADX INFO: renamed from: -$$Nest$smisValidTimerStatusData, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m4322$$Nest$smisValidTimerStatusData(byte[] r0, int r1) {
        return isValidTimerStatusData(r0, r1);
    }

    /* JADX INFO: renamed from: -$$Nest$smisValidTunerDeviceInfo, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m4323$$Nest$smisValidTunerDeviceInfo(byte[] r0) {
        return isValidTunerDeviceInfo(r0);
    }

    /* JADX INFO: renamed from: -$$Nest$smisValidUiBroadcastType, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m4324$$Nest$smisValidUiBroadcastType(int r0) {
        return isValidUiBroadcastType(r0);
    }

    /* JADX INFO: renamed from: -$$Nest$smisValidUiSoundPresenationControl, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m4325$$Nest$smisValidUiSoundPresenationControl(int r0) {
        return isValidUiSoundPresenationControl(r0);
    }

    /* JADX INFO: renamed from: -$$Nest$smisWithinRange, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m4326$$Nest$smisWithinRange(int r0, int r1, int r2) {
        return isWithinRange(r0, r1, r2);
    }

    /* JADX INFO: renamed from: -$$Nest$smtoErrorCode, reason: not valid java name */
    static /* bridge */ /* synthetic */ int m4327$$Nest$smtoErrorCode(boolean r0) {
        return toErrorCode(r0);
    }

    private HdmiCecMessageValidator() {
    }

    static {
        sValidationInfo = new SparseArray();
        HdmiCecMessageValidatorIA r1 = null;
        PhysicalAddressValidator physicalAddressValidator = new PhysicalAddressValidator(r1);
        addValidationInfo(130, physicalAddressValidator, 65503, 32768);
        addValidationInfo(157, physicalAddressValidator, 32767, 32767);
        addValidationInfo(132, new ReportPhysicalAddressValidator(r1), 65535, 32768);
        addValidationInfo(128, new RoutingChangeValidator(r1), 65535, 32768);
        addValidationInfo(129, physicalAddressValidator, 65535, 32768);
        addValidationInfo(134, physicalAddressValidator, 32767, 32768);
        addValidationInfo(112, new SystemAudioModeRequestValidator(r1), 32767, 32767);
        FixedLengthValidator noneValidator = new FixedLengthValidator(0);
        addValidationInfo(255, noneValidator, 32767, 32767);
        addValidationInfo(159, noneValidator, 32767, 32767);
        addValidationInfo(145, noneValidator, 65535, 32767);
        addValidationInfo(113, noneValidator, 32767, 32767);
        addValidationInfo(143, noneValidator, 32767, 32767);
        addValidationInfo(140, noneValidator, 65535, 32767);
        addValidationInfo(70, noneValidator, 32767, 32767);
        addValidationInfo(131, noneValidator, 65535, 32767);
        addValidationInfo(125, noneValidator, 32767, 32767);
        addValidationInfo(4, noneValidator, 32767, 32767);
        addValidationInfo(192, noneValidator, 32767, 32767);
        addValidationInfo(11, noneValidator, 32767, 32767);
        addValidationInfo(15, noneValidator, 32767, 32767);
        addValidationInfo(193, noneValidator, 32767, 32767);
        addValidationInfo(194, noneValidator, 32767, 32767);
        addValidationInfo(195, noneValidator, 32767, 32767);
        addValidationInfo(196, noneValidator, 32767, 32767);
        addValidationInfo(133, noneValidator, 65535, 32768);
        addValidationInfo(54, noneValidator, 65535, 65535);
        addValidationInfo(197, noneValidator, 32767, 32767);
        addValidationInfo(13, noneValidator, 32767, 32767);
        addValidationInfo(6, noneValidator, 32767, 32767);
        addValidationInfo(5, noneValidator, 32767, 32767);
        addValidationInfo(69, noneValidator, 32767, 32767);
        addValidationInfo(139, noneValidator, 32767, 65535);
        addValidationInfo(9, new VariableLengthValidator(1, 8), 32767, 32767);
        addValidationInfo(10, new RecordStatusInfoValidator(r1), 32767, 32767);
        addValidationInfo(51, new AnalogueTimerValidator(r1), 32767, 32767);
        addValidationInfo(153, new DigitalTimerValidator(r1), 32767, 32767);
        addValidationInfo(161, new ExternalTimerValidator(r1), 32767, 32767);
        addValidationInfo(52, new AnalogueTimerValidator(r1), 32767, 32767);
        addValidationInfo(151, new DigitalTimerValidator(r1), 32767, 32767);
        addValidationInfo(162, new ExternalTimerValidator(r1), 32767, 32767);
        addValidationInfo(103, new AsciiValidator(1, 14), 32767, 32767);
        addValidationInfo(67, new TimerClearedStatusValidator(r1), 32767, 32767);
        addValidationInfo(53, new TimerStatusValidator(r1), 32767, 32767);
        FixedLengthValidator oneByteValidator = new FixedLengthValidator(1);
        addValidationInfo(158, oneByteValidator, 32767, 32767);
        addValidationInfo(50, new AsciiValidator(3), 1, 32768);
        ParameterValidator statusRequestValidator = new MinimumOneByteRangeValidator(1, 3);
        addValidationInfo(66, new MinimumOneByteRangeValidator(1, 4), 32767, 32767);
        addValidationInfo(27, new MinimumOneByteRangeValidator(17, 31), 32767, 32767);
        addValidationInfo(26, statusRequestValidator, 32767, 32767);
        addValidationInfo(65, new PlayModeValidator(r1), 32767, 32767);
        addValidationInfo(8, statusRequestValidator, 32767, 32767);
        addValidationInfo(146, new SelectAnalogueServiceValidator(r1), 32767, 32767);
        addValidationInfo(147, new SelectDigitalServiceValidator(r1), 32767, 32767);
        addValidationInfo(7, new TunerDeviceStatusValidator(r1), 32767, 32767);
        VariableLengthValidator maxLengthValidator = new VariableLengthValidator(0, 14);
        addValidationInfo(135, new FixedLengthValidator(3), 32767, 32768);
        addValidationInfo(137, new VariableLengthValidator(1, 14), 65535, 32767);
        addValidationInfo(160, new VariableLengthValidator(4, 14), 65535, 65535);
        addValidationInfo(138, maxLengthValidator, 65535, 65535);
        addValidationInfo(100, new OsdStringValidator(r1), 32767, 32767);
        addValidationInfo(71, new AsciiValidator(1, 14), 32767, 32767);
        addValidationInfo(141, new MinimumOneByteRangeValidator(0, 2), 32767, 32767);
        addValidationInfo(142, new MinimumOneByteRangeValidator(0, 1), 32767, 32767);
        addValidationInfo(68, new UserControlPressedValidator(r1), 32767, 32767);
        addValidationInfo(144, new MinimumOneByteRangeValidator(0, 3), 32767, 65535);
        addValidationInfo(0, new FixedLengthValidator(2), 32767, 32767);
        addValidationInfo(122, oneByteValidator, 32767, 32767);
        addValidationInfo(163, new FixedLengthValidator(3), 32767, 32767);
        addValidationInfo(164, oneByteValidator, 32767, 32767);
        addValidationInfo(114, new SingleByteRangeValidator(0, 1), 32, 65535);
        addValidationInfo(126, new SingleByteRangeValidator(0, 1), 32767, 32767);
        addValidationInfo(154, new MinimumOneByteRangeValidator(0, 6), 32767, 32767);
        addValidationInfo(165, noneValidator, 65535, 32767);
        addValidationInfo(167, physicalAddressValidator, 32767, 32768);
        addValidationInfo(168, new VariableLengthValidator(4, 14), 32767, 32768);
        addValidationInfo(FrameworkStatsLog.INTEGRITY_RULES_PUSHED, maxLengthValidator, 65535, 32768);
    }

    private static void addValidationInfo(int opcode, ParameterValidator validator, int validSources, int validDestinations) {
        sValidationInfo.append(opcode, new ValidationInfo(validator, validSources, validDestinations));
    }

    static int validate(int source, int destination, int opcode, byte[] params) {
        ValidationInfo info = sValidationInfo.get(opcode);
        if (info != null) goto L6;
        HdmiLogger.warning("No validation information for the opcode: " + opcode, new Object[0]);
        return 0;
    L6:
        int addressValidationResult = validateAddress(source, destination, info.validSources, info.validDestinations);
        if (addressValidationResult == 0) goto L9;
        return addressValidationResult;
    L9:
        int errorCode = info.parameterValidator.isValid(params);
        if (errorCode == 0) goto L12;
        return errorCode;
    L12:
        return 0;
    }

    static int validateAddress(int source, int destination, int validSources, int validDestinations) {
        if (((1 << source) & validSources) != 0) goto L6;
        return 1;
    L6:
        if (((1 << destination) & validDestinations) != 0) goto L9;
        return 2;
    L9:
        return 0;
    }

    private static boolean isValidPhysicalAddress(byte[] params, int offset) {
        int physicalAddress = HdmiUtils.twoBytesToInt(params, offset);
        if (physicalAddress != 65535) goto L5;
        return false;
    L5:
        if (physicalAddress == 0) goto L11;
        int maskedAddress = 61440 & physicalAddress;
        physicalAddress = (physicalAddress << 4) & 65535;
        if (maskedAddress != 0) goto L5;
        if (physicalAddress == 0) goto L5;
        return false;
    L11:
        return true;
    }

    static boolean isValidType(int type) {
        if (type >= 0) goto L4;
    L8:
        return false;
    L4:
        if (type > 7) goto L8;
        if (type == 2) goto L8;
        return true;
    }

    private static int toErrorCode(boolean success) {
        if (success == false) goto L4;
        return 0;
    L4:
        return 3;
    }

    private static boolean isWithinRange(int value, int min, int max) {
        int value2 = value & 255;
        if (value2 < min) goto L6;
        if (value2 > max) goto L6;
        return true;
    L6:
        return false;
    }

    private static boolean isValidDisplayControl(int value) {
        int value2 = value & 255;
        if (value2 != 0) goto L5;
    L12:
        return true;
    L5:
        if (value2 == 64) goto L12;
        if (value2 == 128) goto L12;
        if (value2 == 192) goto L12;
        return false;
    }

    private static boolean isValidAsciiString(byte[] params, int offset, int maxLength) {
        int i = offset;
    L4:
        if (i >= params.length) goto L11;
        if (i >= maxLength) goto L16;
        if (isWithinRange(params[i], 32, 126) == false) goto L8;
        i = i + 1;
        goto L4
    L8:
        return false;
    L16:
        return true;
    L11:
        return true;
    }

    private static boolean isValidDayOfMonth(int value) {
        return isWithinRange(value, 1, 31);
    }

    private static boolean isValidMonthOfYear(int value) {
        return isWithinRange(value, 1, 12);
    }

    private static boolean isValidHour(int value) {
        return isWithinRange(bcdToDecimal(value), 0, 23);
    }

    private static boolean isValidMinute(int value) {
        return isWithinRange(bcdToDecimal(value), 0, 59);
    }

    private static boolean isValidDurationHours(int value) {
        return isWithinRange(bcdToDecimal(value), 0, 99);
    }

    private static int bcdToDecimal(int value) {
        int tens = (value & FrameworkStatsLog.BOOT_TIME_EVENT_ELAPSED_TIME_REPORTED) >> 4;
        int ones = value & 15;
        return (tens * 10) + ones;
    }

    private static boolean isValidRecordingSequence(int value) {
        if (((value & 255) & 128) == 0) goto L6;
        return false;
    L6:
        return true;
    }

    private static boolean isValidAnalogueBroadcastType(int value) {
        return isWithinRange(value, 0, 2);
    }

    private static boolean isValidAnalogueFrequency(int value) {
        int value2 = value & 65535;
        if (value2 == 0) goto L6;
        if (value2 == 65535) goto L6;
        return true;
    L6:
        return false;
    }

    private static boolean isValidBroadcastSystem(int value) {
        return isWithinRange(value, 0, 31);
    }

    private static boolean isAribDbs(int value) {
        if (value != 0) goto L4;
    L7:
        return true;
    L4:
        if (isWithinRange(value, 8, 10) == true) goto L7;
        return false;
    }

    private static boolean isAtscDbs(int value) {
        if (value != 1) goto L5;
        return true;
    L5:
        if (isWithinRange(value, 16, 18) == true) goto L10;
        return false;
    L10:
        return true;
    }

    private static boolean isDvbDbs(int value) {
        if (value != 2) goto L5;
    L8:
        return true;
    L5:
        if (isWithinRange(value, 24, 27) == true) goto L8;
        return false;
    }

    private static boolean isValidDigitalBroadcastSystem(int value) {
        if (isAribDbs(value) == false) goto L5;
    L10:
        return true;
    L5:
        if (isAtscDbs(value) == true) goto L10;
        if (isDvbDbs(value) == true) goto L10;
        return false;
    }

    private static boolean isValidChannelIdentifier(byte[] params, int offset) {
        int channelNumberFormat = params[offset] & AudioChannelMask.IN_6;
        if (channelNumberFormat != 4) goto L10;
        if ((params.length - offset) < 3) goto L8;
        return true;
    L8:
        return false;
    L10:
        if (channelNumberFormat == 8) goto L12;
        return false;
    L12:
        if ((params.length - offset) < 4) goto L15;
        return true;
    L15:
        return false;
    }

    private static boolean isValidDigitalServiceIdentification(byte[] params, int offset) {
        int serviceIdentificationMethod = params[offset] & 128;
        int digitalBroadcastSystem = params[offset] & 127;
        int offset2 = offset + 1;
        if (serviceIdentificationMethod == 0) goto L5;
        if (serviceIdentificationMethod == 128) goto L27;
    L30:
        return false;
    L27:
        if (isValidDigitalBroadcastSystem(digitalBroadcastSystem) == false) goto L30;
        return isValidChannelIdentifier(params, offset2);
    L5:
        if (isAribDbs(digitalBroadcastSystem) == false) goto L12;
        if ((params.length - offset2) < 6) goto L10;
        return true;
    L10:
        return false;
    L12:
        if (isAtscDbs(digitalBroadcastSystem) == false) goto L19;
        if ((params.length - offset2) < 4) goto L17;
        return true;
    L17:
        return false;
    L19:
        if (isDvbDbs(digitalBroadcastSystem) == false) goto L30;
        if ((params.length - offset2) < 6) goto L24;
        return true;
    L24:
        return false;
    }

    private static boolean isValidExternalPlug(int value) {
        return isWithinRange(value, 1, 255);
    }

    private static boolean isValidExternalSource(byte[] params, int offset) {
        int externalSourceSpecifier = params[offset];
        int offset2 = offset + 1;
        if (externalSourceSpecifier != 4) goto L7;
        return isValidExternalPlug(params[offset2]);
    L7:
        if (externalSourceSpecifier == 5) goto L9;
        return false;
    L9:
        if ((params.length - offset2) >= 2) goto L11;
        return false;
    L11:
        return isValidPhysicalAddress(params, offset2);
    }

    private static boolean isValidProgrammedInfo(int programedInfo) {
        return isWithinRange(programedInfo, 0, 11);
    }

    private static boolean isValidNotProgrammedErrorInfo(int nonProgramedErrorInfo) {
        return isWithinRange(nonProgramedErrorInfo, 0, 14);
    }

    private static boolean isValidTimerStatusData(byte[] params, int offset) {
        int programedIndicator = params[offset] & 16;
        boolean durationAvailable = false;
        if (programedIndicator != 16) goto L15;
        int programedInfo = params[offset] & 15;
        if (isValidProgrammedInfo(programedInfo) == false) goto L24;
        offset = offset + 1;
        if (programedInfo == 9) goto L11;
        if (programedInfo == 11) goto L11;
    L13:
        return true;
    L11:
        if ((params.length - offset) < 2) goto L13;
        durationAvailable = true;
    L24:
        if (durationAvailable == true) goto L26;
        return false;
    L26:
        if (isValidDurationHours(params[offset]) == false) goto L31;
        if (isValidMinute(params[offset + 1]) == false) goto L31;
        return true;
    L31:
        return false;
    L15:
        int nonProgramedErrorInfo = params[offset] & 15;
        if (isValidNotProgrammedErrorInfo(nonProgramedErrorInfo) == false) goto L24;
        offset = offset + 1;
        if (nonProgramedErrorInfo == 14) goto L20;
    L22:
        return true;
    L20:
        if ((params.length - offset) < 2) goto L22;
        durationAvailable = true;
        goto L24
    }

    private static boolean isValidPlayMode(int value) {
        if (isWithinRange(value, 5, 7) == false) goto L5;
    L16:
        return true;
    L5:
        if (isWithinRange(value, 9, 11) == true) goto L16;
        if (isWithinRange(value, 21, 23) == true) goto L16;
        if (isWithinRange(value, 25, 27) == true) goto L16;
        if (isWithinRange(value, 36, 37) == true) goto L16;
        if (value == 32) goto L16;
        return false;
    }

    private static boolean isValidUiBroadcastType(int value) {
        int value2 = value & 255;
        if (value2 == 0) goto L30;
        if (value2 != 1) goto L6;
        return true;
    L6:
        if (value2 != 16) goto L8;
        return true;
    L8:
        if (value2 != 32) goto L10;
        return true;
    L10:
        if (value2 != 48) goto L12;
        return true;
    L12:
        if (value2 != 64) goto L14;
        return true;
    L14:
        if (value2 != 80) goto L16;
        return true;
    L16:
        if (value2 != 96) goto L18;
        return true;
    L18:
        if (value2 != 112) goto L20;
        return true;
    L20:
        if (value2 != 128) goto L22;
        return true;
    L22:
        if (value2 != 144) goto L24;
        return true;
    L24:
        if (value2 != 145) goto L26;
        return true;
    L26:
        if (value2 == 160) goto L42;
        return false;
    L42:
        return true;
    L30:
        return true;
    }

    private static boolean isValidUiSoundPresenationControl(int value) {
        int value2 = value & 255;
        if (value2 != 32) goto L5;
    L18:
        return true;
    L5:
        if (value2 == 48) goto L18;
        if (value2 == 128) goto L18;
        if (value2 == 144) goto L18;
        if (value2 == 160) goto L18;
        if (isWithinRange(value2, 177, 179) == true) goto L18;
        if (isWithinRange(value2, 193, 195) == true) goto L18;
        return false;
    }

    private static boolean isValidTunerDeviceInfo(byte[] params) {
        int tunerDisplayInfo = params[0] & 127;
        if (tunerDisplayInfo == 0) goto L5;
        if (tunerDisplayInfo != 1) goto L11;
        return true;
    L11:
        if (tunerDisplayInfo == 2) goto L13;
    L23:
        return false;
    L13:
        if (params.length < 5) goto L23;
        if (isValidAnalogueBroadcastType(params[1]) == true) goto L17;
        return false;
    L17:
        if (isValidAnalogueFrequency(HdmiUtils.twoBytesToInt(params, 2)) == true) goto L19;
        return false;
    L19:
        if (isValidBroadcastSystem(params[4]) == true) goto L22;
        return false;
    L22:
        return true;
    L5:
        if (params.length < 5) goto L23;
        return isValidDigitalServiceIdentification(params, 1);
    }
}
