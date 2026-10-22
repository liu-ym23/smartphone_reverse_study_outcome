package com.android.server.soundtrigger_middleware;

import android.hardware.audio.common.V2_0.Uuid;
import android.hardware.soundtrigger.V2_0.ISoundTriggerHw;
import android.hardware.soundtrigger.V2_0.ISoundTriggerHwCallback;
import android.hardware.soundtrigger.V2_3.RecognitionConfig;
import android.media.audio.common.AidlConversion;
import android.media.audio.common.AudioConfig;
import android.media.audio.common.AudioConfigBase;
import android.media.audio.common.AudioOffloadInfo;
import android.media.soundtrigger.ConfidenceLevel;
import android.media.soundtrigger.ModelParameterRange;
import android.media.soundtrigger.Phrase;
import android.media.soundtrigger.PhraseRecognitionEvent;
import android.media.soundtrigger.PhraseRecognitionExtra;
import android.media.soundtrigger.PhraseSoundModel;
import android.media.soundtrigger.Properties;
import android.media.soundtrigger.RecognitionEvent;
import android.media.soundtrigger.SoundModel;
import android.os.HidlMemory;
import android.os.HidlMemoryUtil;
import android.os.ParcelFileDescriptor;
import java.util.regex.Matcher;

/* JADX INFO: loaded from: classes3.dex */
class ConversionUtil {
    ConversionUtil() {
    }

    static Properties hidl2aidlProperties(ISoundTriggerHw.Properties hidlProperties) {
        Properties aidlProperties = new Properties();
        aidlProperties.implementor = hidlProperties.implementor;
        aidlProperties.description = hidlProperties.description;
        aidlProperties.version = hidlProperties.version;
        aidlProperties.uuid = hidl2aidlUuid(hidlProperties.uuid);
        aidlProperties.maxSoundModels = hidlProperties.maxSoundModels;
        aidlProperties.maxKeyPhrases = hidlProperties.maxKeyPhrases;
        aidlProperties.maxUsers = hidlProperties.maxUsers;
        aidlProperties.recognitionModes = hidl2aidlRecognitionModes(hidlProperties.recognitionModes);
        aidlProperties.captureTransition = hidlProperties.captureTransition;
        aidlProperties.maxBufferMs = hidlProperties.maxBufferMs;
        aidlProperties.concurrentCapture = hidlProperties.concurrentCapture;
        aidlProperties.triggerInEvent = hidlProperties.triggerInEvent;
        aidlProperties.powerConsumptionMw = hidlProperties.powerConsumptionMw;
        return aidlProperties;
    }

    static Properties hidl2aidlProperties(android.hardware.soundtrigger.V2_3.Properties hidlProperties) {
        Properties aidlProperties = hidl2aidlProperties(hidlProperties.base);
        aidlProperties.supportedModelArch = hidlProperties.supportedModelArch;
        aidlProperties.audioCapabilities = hidl2aidlAudioCapabilities(hidlProperties.audioCapabilities);
        return aidlProperties;
    }

    static String hidl2aidlUuid(Uuid hidlUuid) {
        if (hidlUuid.node == null) goto L9;
        if (hidlUuid.node.length != 6) goto L9;
        return String.format("%08x-%04x-%04x-%04x-%02x%02x%02x%02x%02x%02x", new Object[]{Integer.valueOf(hidlUuid.timeLow), Short.valueOf(hidlUuid.timeMid), Short.valueOf(hidlUuid.versionAndTimeHigh), Short.valueOf(hidlUuid.variantAndClockSeqHigh), Byte.valueOf(hidlUuid.node[0]), Byte.valueOf(hidlUuid.node[1]), Byte.valueOf(hidlUuid.node[2]), Byte.valueOf(hidlUuid.node[3]), Byte.valueOf(hidlUuid.node[4]), Byte.valueOf(hidlUuid.node[5])});
    L9:
        throw new IllegalArgumentException("UUID.node must be of length 6.");
    }

    static Uuid aidl2hidlUuid(String aidlUuid) {
        Matcher matcher = UuidUtil.PATTERN.matcher(aidlUuid);
        if (matcher.matches() == false) goto L7;
        Uuid hidlUuid = new Uuid();
        hidlUuid.timeLow = Integer.parseUnsignedInt(matcher.group(1), 16);
        hidlUuid.timeMid = (short) Integer.parseUnsignedInt(matcher.group(2), 16);
        hidlUuid.versionAndTimeHigh = (short) Integer.parseUnsignedInt(matcher.group(3), 16);
        hidlUuid.variantAndClockSeqHigh = (short) Integer.parseUnsignedInt(matcher.group(4), 16);
        hidlUuid.node = new byte[]{(byte) Integer.parseUnsignedInt(matcher.group(5), 16), (byte) Integer.parseUnsignedInt(matcher.group(6), 16), (byte) Integer.parseUnsignedInt(matcher.group(7), 16), (byte) Integer.parseUnsignedInt(matcher.group(8), 16), (byte) Integer.parseUnsignedInt(matcher.group(9), 16), (byte) Integer.parseUnsignedInt(matcher.group(10), 16)};
        return hidlUuid;
    L7:
        throw new IllegalArgumentException("Illegal format for UUID: " + aidlUuid);
    }

    static int aidl2hidlSoundModelType(int aidlType) {
        switch(aidlType) {
            case 0: goto L7;
            case 1: goto L5;
            default: goto L4;
        };
    L5:
        return 1;
    L7:
        return 0;
    L4:
        throw new IllegalArgumentException("Unknown sound model type: " + aidlType);
    }

    static int hidl2aidlSoundModelType(int hidlType) {
        switch(hidlType) {
            case 0: goto L7;
            case 1: goto L5;
            default: goto L4;
        };
    L5:
        return 1;
    L7:
        return 0;
    L4:
        throw new IllegalArgumentException("Unknown sound model type: " + hidlType);
    }

    static ISoundTriggerHw.Phrase aidl2hidlPhrase(Phrase aidlPhrase) {
        ISoundTriggerHw.Phrase hidlPhrase = new ISoundTriggerHw.Phrase();
        hidlPhrase.id = aidlPhrase.id;
        hidlPhrase.recognitionModes = aidl2hidlRecognitionModes(aidlPhrase.recognitionModes);
        int[] r1 = aidlPhrase.users;
        int r2 = r1.length;
        int r3 = 0;
    L3:
        if (r3 >= r2) goto L5;
        int aidlUser = r1[r3];
        hidlPhrase.users.add(Integer.valueOf(aidlUser));
        r3 = r3 + 1;
        goto L3
    L5:
        hidlPhrase.locale = aidlPhrase.locale;
        hidlPhrase.text = aidlPhrase.text;
        return hidlPhrase;
    }

    static int aidl2hidlRecognitionModes(int aidlModes) {
        int hidlModes = 0;
        if ((aidlModes & 1) == 0) goto L6;
        hidlModes = 0 | 1;
    L6:
        if ((aidlModes & 2) == 0) goto L9;
        hidlModes = hidlModes | 2;
    L9:
        if ((aidlModes & 4) == 0) goto L12;
        hidlModes = hidlModes | 4;
    L12:
        if ((aidlModes & 8) != 0) goto L14;
        return hidlModes;
    L14:
        return hidlModes | 8;
    }

    static int hidl2aidlRecognitionModes(int hidlModes) {
        int aidlModes = 0;
        if ((hidlModes & 1) == 0) goto L6;
        aidlModes = 0 | 1;
    L6:
        if ((hidlModes & 2) == 0) goto L9;
        aidlModes = aidlModes | 2;
    L9:
        if ((hidlModes & 4) == 0) goto L12;
        aidlModes = aidlModes | 4;
    L12:
        if ((hidlModes & 8) != 0) goto L14;
        return aidlModes;
    L14:
        return aidlModes | 8;
    }

    static android.hardware.soundtrigger.V2_1.ISoundTriggerHw.SoundModel aidl2hidlSoundModel(SoundModel aidlModel) {
        android.hardware.soundtrigger.V2_1.ISoundTriggerHw.SoundModel hidlModel = new android.hardware.soundtrigger.V2_1.ISoundTriggerHw.SoundModel();
        ISoundTriggerHw.SoundModel r1 = hidlModel.header;
        r1.type = aidl2hidlSoundModelType(aidlModel.type);
        ISoundTriggerHw.SoundModel r2 = hidlModel.header;
        r2.uuid = aidl2hidlUuid(aidlModel.uuid);
        ISoundTriggerHw.SoundModel r3 = hidlModel.header;
        r3.vendorUuid = aidl2hidlUuid(aidlModel.vendorUuid);
        hidlModel.data = parcelFileDescriptorToHidlMemory(aidlModel.data, aidlModel.dataSize);
        return hidlModel;
    }

    static android.hardware.soundtrigger.V2_1.ISoundTriggerHw.PhraseSoundModel aidl2hidlPhraseSoundModel(PhraseSoundModel aidlModel) {
        android.hardware.soundtrigger.V2_1.ISoundTriggerHw.PhraseSoundModel hidlModel = new android.hardware.soundtrigger.V2_1.ISoundTriggerHw.PhraseSoundModel();
        hidlModel.common = aidl2hidlSoundModel(aidlModel.common);
        Phrase[] r1 = aidlModel.phrases;
        int r2 = r1.length;
        int r3 = 0;
    L3:
        if (r3 >= r2) goto L5;
        Phrase aidlPhrase = r1[r3];
        hidlModel.phrases.add(aidl2hidlPhrase(aidlPhrase));
        r3 = r3 + 1;
        goto L3
    L5:
        return hidlModel;
    }

    static RecognitionConfig aidl2hidlRecognitionConfig(android.media.soundtrigger.RecognitionConfig aidlConfig, int deviceHandle, int ioHandle) {
        RecognitionConfig hidlConfig = new RecognitionConfig();
        hidlConfig.base.header.captureDevice = deviceHandle;
        hidlConfig.base.header.captureHandle = ioHandle;
        ISoundTriggerHw.RecognitionConfig r1 = hidlConfig.base.header;
        r1.captureRequested = aidlConfig.captureRequested;
        PhraseRecognitionExtra[] r2 = aidlConfig.phraseRecognitionExtras;
        int r3 = r2.length;
        int r4 = 0;
    L3:
        if (r4 >= r3) goto L5;
        PhraseRecognitionExtra aidlPhraseExtra = r2[r4];
        hidlConfig.base.header.phrases.add(aidl2hidlPhraseRecognitionExtra(aidlPhraseExtra));
        r4 = r4 + 1;
        goto L3
    L5:
        android.hardware.soundtrigger.V2_1.ISoundTriggerHw.RecognitionConfig r5 = hidlConfig.base;
        r5.data = HidlMemoryUtil.byteArrayToHidlMemory(aidlConfig.data, "SoundTrigger RecognitionConfig");
        hidlConfig.audioCapabilities = aidlConfig.audioCapabilities;
        return hidlConfig;
    }

    static android.hardware.soundtrigger.V2_0.PhraseRecognitionExtra aidl2hidlPhraseRecognitionExtra(PhraseRecognitionExtra aidlExtra) {
        android.hardware.soundtrigger.V2_0.PhraseRecognitionExtra hidlExtra = new android.hardware.soundtrigger.V2_0.PhraseRecognitionExtra();
        hidlExtra.id = aidlExtra.id;
        hidlExtra.recognitionModes = aidl2hidlRecognitionModes(aidlExtra.recognitionModes);
        hidlExtra.confidenceLevel = aidlExtra.confidenceLevel;
        hidlExtra.levels.ensureCapacity(aidlExtra.levels.length);
        ConfidenceLevel[] r1 = aidlExtra.levels;
        int r2 = r1.length;
        int r3 = 0;
    L3:
        if (r3 >= r2) goto L5;
        ConfidenceLevel aidlLevel = r1[r3];
        hidlExtra.levels.add(aidl2hidlConfidenceLevel(aidlLevel));
        r3 = r3 + 1;
        goto L3
    L5:
        return hidlExtra;
    }

    static PhraseRecognitionExtra hidl2aidlPhraseRecognitionExtra(android.hardware.soundtrigger.V2_0.PhraseRecognitionExtra hidlExtra) {
        PhraseRecognitionExtra aidlExtra = new PhraseRecognitionExtra();
        aidlExtra.id = hidlExtra.id;
        aidlExtra.recognitionModes = hidl2aidlRecognitionModes(hidlExtra.recognitionModes);
        aidlExtra.confidenceLevel = hidlExtra.confidenceLevel;
        aidlExtra.levels = new ConfidenceLevel[hidlExtra.levels.size()];
        int i = 0;
    L4:
        if (i >= hidlExtra.levels.size()) goto L7;
        aidlExtra.levels[i] = hidl2aidlConfidenceLevel(hidlExtra.levels.get(i));
        i = i + 1;
        goto L4
    L7:
        return aidlExtra;
    }

    static android.hardware.soundtrigger.V2_0.ConfidenceLevel aidl2hidlConfidenceLevel(ConfidenceLevel aidlLevel) {
        android.hardware.soundtrigger.V2_0.ConfidenceLevel hidlLevel = new android.hardware.soundtrigger.V2_0.ConfidenceLevel();
        hidlLevel.userId = aidlLevel.userId;
        hidlLevel.levelPercent = aidlLevel.levelPercent;
        return hidlLevel;
    }

    static ConfidenceLevel hidl2aidlConfidenceLevel(android.hardware.soundtrigger.V2_0.ConfidenceLevel hidlLevel) {
        ConfidenceLevel aidlLevel = new ConfidenceLevel();
        aidlLevel.userId = hidlLevel.userId;
        aidlLevel.levelPercent = hidlLevel.levelPercent;
        return aidlLevel;
    }

    static int hidl2aidlRecognitionStatus(int hidlStatus) {
        switch(hidlStatus) {
            case 0: goto L11;
            case 1: goto L9;
            case 2: goto L7;
            case 3: goto L5;
            default: goto L4;
        };
    L5:
        return 3;
    L7:
        return 2;
    L9:
        return 1;
    L11:
        return 0;
    L4:
        throw new IllegalArgumentException("Unknown recognition status: " + hidlStatus);
    }

    static RecognitionEvent hidl2aidlRecognitionEvent(ISoundTriggerHwCallback.RecognitionEvent hidlEvent) {
        RecognitionEvent aidlEvent = new RecognitionEvent();
        aidlEvent.status = hidl2aidlRecognitionStatus(hidlEvent.status);
        aidlEvent.type = hidl2aidlSoundModelType(hidlEvent.type);
        aidlEvent.captureAvailable = hidlEvent.captureAvailable;
        aidlEvent.captureDelayMs = hidlEvent.captureDelayMs;
        aidlEvent.capturePreambleMs = hidlEvent.capturePreambleMs;
        aidlEvent.triggerInData = hidlEvent.triggerInData;
        boolean r2 = true;
        aidlEvent.audioConfig = hidl2aidlAudioConfig(hidlEvent.audioConfig, true);
        aidlEvent.data = new byte[hidlEvent.data.size()];
        int i = 0;
    L4:
        if (i >= aidlEvent.data.length) goto L6;
        aidlEvent.data[i] = hidlEvent.data.get(i).byteValue();
        i = i + 1;
        goto L4
    L6:
        int i2 = aidlEvent.status;
        if (i2 == 3) goto L10;
        r2 = false;
    L10:
        aidlEvent.recognitionStillActive = r2;
        return aidlEvent;
    }

    static RecognitionEvent hidl2aidlRecognitionEvent(android.hardware.soundtrigger.V2_1.ISoundTriggerHwCallback.RecognitionEvent hidlEvent) {
        RecognitionEvent aidlEvent = hidl2aidlRecognitionEvent(hidlEvent.header);
        aidlEvent.data = HidlMemoryUtil.hidlMemoryToByteArray(hidlEvent.data);
        return aidlEvent;
    }

    static PhraseRecognitionEvent hidl2aidlPhraseRecognitionEvent(ISoundTriggerHwCallback.PhraseRecognitionEvent hidlEvent) {
        PhraseRecognitionEvent aidlEvent = new PhraseRecognitionEvent();
        aidlEvent.common = hidl2aidlRecognitionEvent(hidlEvent.common);
        aidlEvent.phraseExtras = new PhraseRecognitionExtra[hidlEvent.phraseExtras.size()];
        int i = 0;
    L4:
        if (i >= hidlEvent.phraseExtras.size()) goto L7;
        aidlEvent.phraseExtras[i] = hidl2aidlPhraseRecognitionExtra(hidlEvent.phraseExtras.get(i));
        i = i + 1;
        goto L4
    L7:
        return aidlEvent;
    }

    static PhraseRecognitionEvent hidl2aidlPhraseRecognitionEvent(android.hardware.soundtrigger.V2_1.ISoundTriggerHwCallback.PhraseRecognitionEvent hidlEvent) {
        PhraseRecognitionEvent aidlEvent = new PhraseRecognitionEvent();
        aidlEvent.common = hidl2aidlRecognitionEvent(hidlEvent.common);
        aidlEvent.phraseExtras = new PhraseRecognitionExtra[hidlEvent.phraseExtras.size()];
        int i = 0;
    L4:
        if (i >= hidlEvent.phraseExtras.size()) goto L7;
        aidlEvent.phraseExtras[i] = hidl2aidlPhraseRecognitionExtra(hidlEvent.phraseExtras.get(i));
        i = i + 1;
        goto L4
    L7:
        return aidlEvent;
    }

    static AudioConfig hidl2aidlAudioConfig(android.hardware.audio.common.V2_0.AudioConfig hidlConfig, boolean isInput) {
        AudioConfig aidlConfig = new AudioConfig();
        aidlConfig.base = hidl2aidlAudioConfigBase(hidlConfig.sampleRateHz, hidlConfig.channelMask, hidlConfig.format, isInput);
        aidlConfig.offloadInfo = hidl2aidlOffloadInfo(hidlConfig.offloadInfo);
        aidlConfig.frameCount = hidlConfig.frameCount;
        return aidlConfig;
    }

    static AudioOffloadInfo hidl2aidlOffloadInfo(android.hardware.audio.common.V2_0.AudioOffloadInfo hidlInfo) {
        AudioOffloadInfo aidlInfo = new AudioOffloadInfo();
        aidlInfo.base = hidl2aidlAudioConfigBase(hidlInfo.sampleRateHz, hidlInfo.channelMask, hidlInfo.format, false);
        aidlInfo.streamType = AidlConversion.legacy2aidl_audio_stream_type_t_AudioStreamType(hidlInfo.streamType);
        aidlInfo.bitRatePerSecond = hidlInfo.bitRatePerSecond;
        aidlInfo.durationUs = hidlInfo.durationMicroseconds;
        aidlInfo.hasVideo = hidlInfo.hasVideo;
        aidlInfo.isStreaming = hidlInfo.isStreaming;
        aidlInfo.bitWidth = hidlInfo.bitWidth;
        aidlInfo.offloadBufferSize = hidlInfo.bufferSize;
        aidlInfo.usage = AidlConversion.legacy2aidl_audio_usage_t_AudioUsage(hidlInfo.usage);
        return aidlInfo;
    }

    static AudioConfigBase hidl2aidlAudioConfigBase(int sampleRateHz, int channelMask, int format, boolean isInput) {
        AudioConfigBase aidlBase = new AudioConfigBase();
        aidlBase.sampleRate = sampleRateHz;
        aidlBase.channelMask = AidlConversion.legacy2aidl_audio_channel_mask_t_AudioChannelLayout(channelMask, isInput);
        aidlBase.format = AidlConversion.legacy2aidl_audio_format_t_AudioFormatDescription(format);
        return aidlBase;
    }

    static ModelParameterRange hidl2aidlModelParameterRange(android.hardware.soundtrigger.V2_3.ModelParameterRange hidlRange) {
        if (hidlRange != null) goto L5;
        return null;
    L5:
        ModelParameterRange aidlRange = new ModelParameterRange();
        aidlRange.minInclusive = hidlRange.start;
        aidlRange.maxInclusive = hidlRange.end;
        return aidlRange;
    }

    static int aidl2hidlModelParameter(int aidlParam) {
        switch(aidlParam) {
            case 0: goto L5;
            default: goto L3;
        };
    L3:
        return -1;
    L5:
        return 0;
    }

    static int hidl2aidlAudioCapabilities(int hidlCapabilities) {
        int aidlCapabilities = 0;
        if ((hidlCapabilities & 1) == 0) goto L6;
        aidlCapabilities = 0 | 1;
    L6:
        if ((hidlCapabilities & 2) != 0) goto L8;
        return aidlCapabilities;
    L8:
        return aidlCapabilities | 2;
    }

    private static HidlMemory parcelFileDescriptorToHidlMemory(ParcelFileDescriptor data, int dataSize) {
        if (dataSize <= 0) goto L6;
        return HidlMemoryUtil.fileDescriptorToHidlMemory(data.getFileDescriptor(), dataSize);
    L6:
        return HidlMemoryUtil.fileDescriptorToHidlMemory(null, 0);
    }
}
