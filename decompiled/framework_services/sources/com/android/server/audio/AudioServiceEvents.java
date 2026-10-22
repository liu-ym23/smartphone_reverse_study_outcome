package com.android.server.audio;

import android.media.AudioDeviceAttributes;
import android.media.AudioManager;
import android.media.AudioSystem;
import android.media.MediaMetrics;
import android.net.INetd;
import com.android.server.location.StarLocation;
import com.android.server.pm.verify.domain.DomainVerificationPersistence;
import com.android.server.utils.EventLogger;
import java.util.Locale;

/* JADX INFO: loaded from: classes.dex */
public class AudioServiceEvents {

    static final class DeviceVolumeEvent extends EventLogger.Event {
        final String mCaller;
        final String mDeviceAddress;
        final int mDeviceForStream;
        final String mDeviceNativeType;
        final boolean mSkipped;
        final int mStream;
        final int mVolIndex;

        DeviceVolumeEvent(int streamType, int index, AudioDeviceAttributes device, int deviceForStream, String callingPackage, boolean skipped) {
            this.mStream = streamType;
            this.mVolIndex = index;
            this.mDeviceNativeType = "0x" + Integer.toHexString(device.getInternalType());
            this.mDeviceAddress = device.getAddress();
            this.mDeviceForStream = deviceForStream;
            this.mCaller = callingPackage;
            this.mSkipped = skipped;
            new MediaMetrics.Item("audio.volume.event").set(MediaMetrics.Property.EVENT, "setDeviceVolume").set(MediaMetrics.Property.STREAM_TYPE, AudioSystem.streamToString(this.mStream)).set(MediaMetrics.Property.INDEX, Integer.valueOf(this.mVolIndex)).set(MediaMetrics.Property.DEVICE, this.mDeviceNativeType).set(MediaMetrics.Property.ADDRESS, this.mDeviceAddress).set(MediaMetrics.Property.CALLING_PACKAGE, this.mCaller).record();
        }

        @Override // com.android.server.utils.EventLogger.Event
        public String eventToString() {
            StringBuilder r0 = new StringBuilder("setDeviceVolume(stream:");
            r0.append(AudioSystem.streamToString(this.mStream));
            r0.append(" index:");
            r0.append(this.mVolIndex);
            r0.append(" device:");
            r0.append(this.mDeviceNativeType);
            r0.append(" addr:");
            r0.append(this.mDeviceAddress);
            r0.append(") from ");
            StringBuilder sb = r0.append(this.mCaller);
            if (this.mSkipped == false) goto L5;
            sb.append(" skipped [device in use]");
        L7:
            return sb.toString();
        L5:
            sb.append(" currDevForStream:Ox");
            sb.append(Integer.toHexString(this.mDeviceForStream));
            goto L7
        }
    }

    static final class ForceUseEvent extends EventLogger.Event {
        final int mConfig;
        final String mReason;
        final int mUsage;

        ForceUseEvent(int usage, int config, String reason) {
            this.mUsage = usage;
            this.mConfig = config;
            this.mReason = reason;
        }

        @Override // com.android.server.utils.EventLogger.Event
        public String eventToString() {
            return "setForceUse(" + AudioSystem.forceUseUsageToString(this.mUsage) + ", " + AudioSystem.forceUseConfigToString(this.mConfig) + ") due to " + this.mReason;
        }
    }

    static final class LoudnessEvent extends EventLogger.Event {
        static final int CLIENT_DIED = 2;
        static final int START_PIID = 0;
        static final int STOP_PIID = 1;
        final int mEventType;
        final int mIntValue1;
        final int mIntValue2;

        private LoudnessEvent(int event, int i1, int i2) {
            this.mEventType = event;
            this.mIntValue1 = i1;
            this.mIntValue2 = i2;
        }

        static LoudnessEvent getStartPiid(int piid, int pid) {
            return new LoudnessEvent(0, piid, pid);
        }

        static LoudnessEvent getStopPiid(int piid, int pid) {
            return new LoudnessEvent(1, piid, pid);
        }

        static LoudnessEvent getClientDied(int pid) {
            return new LoudnessEvent(2, 0, pid);
        }

        @Override // com.android.server.utils.EventLogger.Event
        public String eventToString() {
            switch(this.mEventType) {
                case 0: goto L11;
                case 1: goto L9;
                case 2: goto L7;
                default: goto L5;
            };
        L5:
            return "FIXME invalid event type:" + this.mEventType;
        L7:
            return String.format("Loudness client with pid %d died", new Object[]{Integer.valueOf(this.mIntValue2)});
        L9:
            return String.format("Stop loudness updates for piid %d for client pid %d", new Object[]{Integer.valueOf(this.mIntValue1), Integer.valueOf(this.mIntValue2)});
        L11:
            return String.format("Start loudness updates for piid %d for client pid %d", new Object[]{Integer.valueOf(this.mIntValue1), Integer.valueOf(this.mIntValue2)});
        }
    }

    static final class PhoneStateEvent extends EventLogger.Event {
        static final int MODE_IN_COMMUNICATION_TIMEOUT = 1;
        static final int MODE_SET = 0;
        private static final String mMetricsId = "audio.mode";
        final int mActualMode;
        final int mOp;
        final int mOwnerPid;
        final String mPackage;
        final int mRequestedMode;
        final int mRequesterPid;

        PhoneStateEvent(String callingPackage, int requesterPid, int requestedMode, int ownerPid, int actualMode) {
            this.mOp = 0;
            this.mPackage = callingPackage;
            this.mRequesterPid = requesterPid;
            this.mRequestedMode = requestedMode;
            this.mOwnerPid = ownerPid;
            this.mActualMode = actualMode;
            logMetricEvent();
        }

        PhoneStateEvent(String callingPackage, int ownerPid) {
            this.mOp = 1;
            this.mPackage = callingPackage;
            this.mOwnerPid = ownerPid;
            this.mRequesterPid = 0;
            this.mRequestedMode = 0;
            this.mActualMode = 0;
            logMetricEvent();
        }

        @Override // com.android.server.utils.EventLogger.Event
        public String eventToString() {
            switch(this.mOp) {
                case 0: goto L9;
                case 1: goto L7;
                default: goto L5;
            };
        L5:
            return "FIXME invalid op:" + this.mOp;
        L7:
            return "mode IN COMMUNICATION timeout for package=" + this.mPackage + " pid=" + this.mOwnerPid;
        L9:
            return "setMode(" + AudioSystem.modeToString(this.mRequestedMode) + ") from package=" + this.mPackage + " pid=" + this.mRequesterPid + " selected mode=" + AudioSystem.modeToString(this.mActualMode) + " by pid=" + this.mOwnerPid;
        }

        private void logMetricEvent() {
            switch(this.mOp) {
                case 0: goto L7;
                case 1: goto L5;
                default: goto L4;
            };
        L4:
            return;
        L5:
            new MediaMetrics.Item(mMetricsId).set(MediaMetrics.Property.EVENT, "inCommunicationTimeout").set(MediaMetrics.Property.CALLING_PACKAGE, this.mPackage).record();
            return;
        L7:
            new MediaMetrics.Item(mMetricsId).set(MediaMetrics.Property.EVENT, "set").set(MediaMetrics.Property.REQUESTED_MODE, AudioSystem.modeToString(this.mRequestedMode)).set(MediaMetrics.Property.MODE, AudioSystem.modeToString(this.mActualMode)).set(MediaMetrics.Property.CALLING_PACKAGE, this.mPackage).record();
        }
    }

    static final class RingerZenMutedStreamsEvent extends EventLogger.Event {
        final int mRingerZenMutedStreams;
        final String mSource;

        RingerZenMutedStreamsEvent(int ringerZenMutedStreams, String source) {
            this.mRingerZenMutedStreams = ringerZenMutedStreams;
            this.mSource = source;
        }

        @Override // com.android.server.utils.EventLogger.Event
        public String eventToString() {
            return "RingerZenMutedStreams 0x" + Integer.toHexString(this.mRingerZenMutedStreams) + " from " + this.mSource;
        }
    }

    static final class SoundDoseEvent extends EventLogger.Event {
        static final int DOSE_ACCUMULATION_START = 3;
        static final int DOSE_REPEAT_5X = 2;
        static final int DOSE_UPDATE = 1;
        static final int LOWER_VOLUME_TO_RS1 = 4;
        static final int MOMENTARY_EXPOSURE = 0;
        static final int UPDATE_ABS_VOLUME_ATTENUATION = 5;
        final int mEventType;
        final float mFloatValue;
        final long mLongValue;

        private SoundDoseEvent(int event, float f, long l) {
            this.mEventType = event;
            this.mFloatValue = f;
            this.mLongValue = l;
        }

        static SoundDoseEvent getMomentaryExposureEvent(float mel) {
            return new SoundDoseEvent(0, mel, 0);
        }

        static SoundDoseEvent getDoseUpdateEvent(float csd, long totalDuration) {
            return new SoundDoseEvent(1, csd, totalDuration);
        }

        static SoundDoseEvent getDoseRepeat5xEvent() {
            return new SoundDoseEvent(2, 0.0f, 0);
        }

        static SoundDoseEvent getDoseAccumulationStartEvent() {
            return new SoundDoseEvent(3, 0.0f, 0);
        }

        static SoundDoseEvent getLowerVolumeToRs1Event() {
            return new SoundDoseEvent(4, 0.0f, 0);
        }

        static SoundDoseEvent getAbsVolumeAttenuationEvent(float attenuation, int device) {
            return new SoundDoseEvent(5, attenuation, device);
        }

        @Override // com.android.server.utils.EventLogger.Event
        public String eventToString() {
            switch(this.mEventType) {
                case 0: goto L17;
                case 1: goto L15;
                case 2: goto L12;
                case 3: goto L10;
                case 4: goto L8;
                case 5: goto L7;
                default: goto L5;
            };
        L8:
            return "CSD lowering volume to RS1";
        L10:
            return "CSD accumulating: RS2 entered";
        L12:
            return "CSD reached 500%";
        L5:
            return "FIXME invalid event type:" + this.mEventType;
        L7:
            return String.format(Locale.US, "Updating CSD absolute volume attenuation on device 0x%s with %.2f dB ", new Object[]{Long.toHexString(this.mLongValue), Float.valueOf(this.mFloatValue)});
        L15:
            return String.format(Locale.US, "dose update CSD=%.1f%% total duration=%d", new Object[]{Float.valueOf(this.mFloatValue * 100.0f), Long.valueOf(this.mLongValue)});
        L17:
            return String.format("momentary exposure MEL=%.2f", new Object[]{Float.valueOf(this.mFloatValue)});
        }
    }

    static final class StreamMuteEvent extends EventLogger.Event {
        final boolean mMuted;
        final String mSource;
        final int mStreamType;

        StreamMuteEvent(int streamType, boolean muted, String source) {
            this.mStreamType = streamType;
            this.mMuted = muted;
            this.mSource = source;
        }

        @Override // com.android.server.utils.EventLogger.Event
        public String eventToString() {
            if (this.mStreamType <= AudioSystem.getNumStreamTypes()) goto L5;
        L7:
            String streamName = "stream " + this.mStreamType;
        L8:
            StringBuilder r1 = new StringBuilder(streamName);
            if (this.mMuted == false) goto L11;
            String r2 = " muting by ";
        L12:
            r1.append(r2);
            r1.append(this.mSource);
            return r1.toString();
        L11:
            r2 = " unmuting by ";
            goto L12
        L5:
            if (this.mStreamType < 0) goto L7;
            streamName = AudioSystem.STREAM_NAMES[this.mStreamType];
            goto L8
        }
    }

    static final class StreamUnmuteErrorEvent extends EventLogger.Event {
        final int mRingerZenMutedStreams;
        final int mStreamType;

        StreamUnmuteErrorEvent(int streamType, int ringerZenMutedStreams) {
            this.mStreamType = streamType;
            this.mRingerZenMutedStreams = ringerZenMutedStreams;
        }

        @Override // com.android.server.utils.EventLogger.Event
        public String eventToString() {
            if (this.mStreamType <= AudioSystem.getNumStreamTypes()) goto L5;
        L7:
            String streamName = "stream " + this.mStreamType;
        L9:
            return "Invalid call to unmute " + streamName + " despite muted streams 0x" + Integer.toHexString(this.mRingerZenMutedStreams);
        L5:
            if (this.mStreamType < 0) goto L7;
            streamName = AudioSystem.STREAM_NAMES[this.mStreamType];
            goto L9
        }
    }

    static final class VolChangedBroadcastEvent extends EventLogger.Event {
        final String mAliasStreamIndexes;
        final int mIndex;
        final int mOldIndex;
        final int mStreamType;

        VolChangedBroadcastEvent(int stream, String aliasIndexes, int index, int oldIndex) {
            this.mStreamType = stream;
            this.mAliasStreamIndexes = aliasIndexes;
            this.mIndex = index;
            this.mOldIndex = oldIndex;
        }

        @Override // com.android.server.utils.EventLogger.Event
        public String eventToString() {
            return "sending VOLUME_CHANGED stream:" + AudioSystem.streamToString(this.mStreamType) + " index:" + this.mIndex + " (was:" + this.mOldIndex + ")" + this.mAliasStreamIndexes;
        }
    }

    static final class VolumeEvent extends EventLogger.Event {
        static final int VOL_ABS_DEVICE_ENABLED_ERROR = 13;
        static final int VOL_ADJUST_GROUP_VOL = 11;
        static final int VOL_ADJUST_STREAM_VOL = 1;
        static final int VOL_ADJUST_SUGG_VOL = 0;
        static final int VOL_ADJUST_VOL_UID = 5;
        static final int VOL_MASTER_MUTE = 12;
        static final int VOL_MODE_CHANGE_HEARING_AID = 7;
        static final int VOL_MUTE_STREAM_INT = 9;
        static final int VOL_SET_AVRCP_VOL = 4;
        static final int VOL_SET_GROUP_VOL = 8;
        static final int VOL_SET_HEARING_AID_VOL = 3;
        static final int VOL_SET_LE_AUDIO_VOL = 10;
        static final int VOL_SET_STREAM_VOL = 2;
        static final int VOL_VOICE_ACTIVITY_CONTEXTUAL_VOLUME = 6;
        private static final String mMetricsId = "audio.volume.event";
        final String mCaller;
        final String mGroupName;
        final int mOp;
        final int mStream;
        final int mVal1;
        final int mVal2;
        final int mVal3;

        VolumeEvent(int op, int stream, int val1, int val2, int val3, String caller) {
            this.mOp = op;
            this.mStream = stream;
            this.mVal1 = val1;
            this.mVal2 = val2;
            this.mVal3 = val3;
            this.mCaller = caller;
            this.mGroupName = null;
            logMetricEvent();
        }

        VolumeEvent(int op, int stream, int val1, int val2, String caller) {
            this.mOp = op;
            this.mStream = stream;
            this.mVal1 = val1;
            this.mVal2 = val2;
            this.mCaller = caller;
            this.mVal3 = -1;
            this.mGroupName = null;
            logMetricEvent();
        }

        VolumeEvent(int op, int index, int gainDb) {
            this.mOp = op;
            this.mVal1 = index;
            this.mVal2 = gainDb;
            this.mVal3 = -1;
            this.mStream = -1;
            this.mCaller = null;
            this.mGroupName = null;
            logMetricEvent();
        }

        VolumeEvent(int op, int index) {
            this.mOp = op;
            this.mVal1 = index;
            this.mVal2 = 0;
            this.mVal3 = -1;
            this.mStream = -1;
            this.mCaller = null;
            this.mGroupName = null;
            logMetricEvent();
        }

        VolumeEvent(int r2, boolean r3, int r4, int r5, int r6) {
            this.mOp = r2;
            this.mStream = r4;
            this.mVal1 = r5;
            this.mVal2 = r3 ? 1 : 0;
            this.mVal3 = r6;
            this.mCaller = null;
            this.mGroupName = null;
            logMetricEvent();
        }

        VolumeEvent(int op, int mode, int stream, int index) {
            this.mOp = op;
            this.mStream = stream;
            this.mVal1 = index;
            this.mVal2 = mode;
            this.mVal3 = -1;
            this.mCaller = null;
            this.mGroupName = null;
            logMetricEvent();
        }

        VolumeEvent(int op, String group, int index, int flags, String caller) {
            this.mOp = op;
            this.mStream = -1;
            this.mVal1 = index;
            this.mVal2 = flags;
            this.mCaller = caller;
            this.mGroupName = group;
            this.mVal3 = -1;
            logMetricEvent();
        }

        VolumeEvent(int r2, int r3, boolean r4) {
            this.mOp = r2;
            this.mStream = r3;
            this.mVal1 = r4 ? 1 : 0;
            this.mVal2 = 0;
            this.mCaller = null;
            this.mGroupName = null;
            this.mVal3 = -1;
            logMetricEvent();
        }

        VolumeEvent(int r3, boolean r4) {
            this.mOp = r3;
            this.mStream = -1;
            this.mVal1 = r4 ? 1 : 0;
            this.mVal2 = 0;
            this.mVal3 = -1;
            this.mCaller = null;
            this.mGroupName = null;
            logMetricEvent();
        }

        VolumeEvent(int r2, int r3, int r4, boolean r5, int r6) {
            this.mOp = r2;
            this.mStream = r6;
            this.mVal1 = r4;
            this.mVal2 = r5 ? 1 : 0;
            this.mVal3 = r3;
            this.mCaller = null;
            this.mGroupName = null;
            logMetricEvent();
        }

        private void logMetricEvent() {
            int r0 = this.mOp;
            String r1 = INetd.IF_STATE_DOWN;
            switch(r0) {
                case 0: goto L32;
                case 1: goto L32;
                case 2: goto L29;
                case 3: goto L27;
                case 4: goto L25;
                case 5: goto L32;
                case 6: goto L19;
                case 7: goto L17;
                case 8: goto L15;
                case 9: goto L14;
                case 10: goto L12;
                case 11: goto L7;
                case 12: goto L6;
                case 13: goto L5;
                default: goto L4;
            };
        L4:
            return;
        L5:
            return;
        L6:
            return;
        L7:
            MediaMetrics.Item r2 = new MediaMetrics.Item(mMetricsId).set(MediaMetrics.Property.CALLING_PACKAGE, this.mCaller);
            MediaMetrics.Key r3 = MediaMetrics.Property.DIRECTION;
            if (this.mVal1 <= 0) goto L10;
            r1 = INetd.IF_STATE_UP;
        L10:
            r2.set(r3, r1).set(MediaMetrics.Property.EVENT, "adjustVolumeGroupVolume").set(MediaMetrics.Property.FLAGS, Integer.valueOf(this.mVal2)).set(MediaMetrics.Property.GROUP, this.mGroupName).record();
            return;
        L12:
            new MediaMetrics.Item(mMetricsId).set(MediaMetrics.Property.EVENT, "setLeAudioVolume").set(MediaMetrics.Property.INDEX, Integer.valueOf(this.mVal1)).set(MediaMetrics.Property.MAX_INDEX, Integer.valueOf(this.mVal2)).set(MediaMetrics.Property.STREAM_TYPE, AudioSystem.streamToString(this.mStream)).record();
            return;
        L14:
            return;
        L15:
            new MediaMetrics.Item(mMetricsId).set(MediaMetrics.Property.CALLING_PACKAGE, this.mCaller).set(MediaMetrics.Property.EVENT, "setVolumeIndexForAttributes").set(MediaMetrics.Property.FLAGS, Integer.valueOf(this.mVal2)).set(MediaMetrics.Property.GROUP, this.mGroupName).set(MediaMetrics.Property.INDEX, Integer.valueOf(this.mVal1)).record();
            return;
        L17:
            new MediaMetrics.Item(mMetricsId).set(MediaMetrics.Property.EVENT, "modeChangeHearingAid").set(MediaMetrics.Property.INDEX, Integer.valueOf(this.mVal1)).set(MediaMetrics.Property.MODE, AudioSystem.modeToString(this.mVal2)).set(MediaMetrics.Property.STREAM_TYPE, AudioSystem.streamToString(this.mStream)).record();
            return;
        L19:
            MediaMetrics.Item r4 = new MediaMetrics.Item(mMetricsId).set(MediaMetrics.Property.EVENT, "voiceActivityContextualVolume").set(MediaMetrics.Property.INDEX, Integer.valueOf(this.mVal1));
            MediaMetrics.Key r5 = MediaMetrics.Property.STATE;
            if (this.mVal2 != 1) goto L22;
            String r6 = DomainVerificationPersistence.TAG_ACTIVE;
        L23:
            r4.set(r5, r6).set(MediaMetrics.Property.STREAM_TYPE, AudioSystem.streamToString(this.mStream)).set(MediaMetrics.Property.DEVICE, AudioSystem.getOutputDeviceName(this.mVal3)).record();
            return;
        L22:
            r6 = "inactive";
            goto L23
        L25:
            new MediaMetrics.Item(mMetricsId).set(MediaMetrics.Property.EVENT, "setAvrcpVolume").set(MediaMetrics.Property.INDEX, Integer.valueOf(this.mVal1)).record();
            return;
        L27:
            new MediaMetrics.Item(mMetricsId).set(MediaMetrics.Property.EVENT, "setHearingAidVolume").set(MediaMetrics.Property.GAIN_DB, Double.valueOf(this.mVal2)).set(MediaMetrics.Property.INDEX, Integer.valueOf(this.mVal1)).record();
            return;
        L29:
            new MediaMetrics.Item(mMetricsId).set(MediaMetrics.Property.CALLING_PACKAGE, this.mCaller).set(MediaMetrics.Property.EVENT, "setStreamVolume").set(MediaMetrics.Property.FLAGS, Integer.valueOf(this.mVal2)).set(MediaMetrics.Property.INDEX, Integer.valueOf(this.mVal1)).set(MediaMetrics.Property.OLD_INDEX, Integer.valueOf(this.mVal3)).set(MediaMetrics.Property.STREAM_TYPE, AudioSystem.streamToString(this.mStream)).record();
            return;
        L32:
            switch(this.mOp) {
                case 0: goto L36;
                case 1: goto L35;
                case 5: goto L34;
                default: goto L33;
            };
        L33:
            return;
        L34:
            String eventName = "adjustStreamVolumeForUid";
        L37:
            MediaMetrics.Item r7 = new MediaMetrics.Item(mMetricsId).set(MediaMetrics.Property.CALLING_PACKAGE, this.mCaller);
            MediaMetrics.Key r8 = MediaMetrics.Property.DIRECTION;
            if (this.mVal1 <= 0) goto L40;
            r1 = INetd.IF_STATE_UP;
        L40:
            r7.set(r8, r1).set(MediaMetrics.Property.EVENT, eventName).set(MediaMetrics.Property.FLAGS, Integer.valueOf(this.mVal2)).set(MediaMetrics.Property.STREAM_TYPE, AudioSystem.streamToString(this.mStream)).record();
            return;
        L35:
            eventName = "adjustStreamVolume";
            goto L37
        L36:
            eventName = "adjustSuggestedStreamVolume";
            goto L37
        }

        @Override // com.android.server.utils.EventLogger.Event
        public String eventToString() {
            switch(this.mOp) {
                case 0: goto L45;
                case 1: goto L43;
                case 2: goto L41;
                case 3: goto L39;
                case 4: goto L37;
                case 5: goto L35;
                case 6: goto L28;
                case 7: goto L27;
                case 8: goto L25;
                case 9: goto L18;
                case 10: goto L17;
                case 11: goto L15;
                case 12: goto L8;
                case 13: goto L7;
                default: goto L5;
            };
        L8:
            StringBuilder r0 = new StringBuilder("Master mute:");
            if (this.mVal1 != 1) goto L11;
            String r1 = " muted)";
        L12:
            r0.append(r1);
            return r0.toString();
        L11:
            r1 = " unmuted)";
            goto L12
        L18:
            StringBuilder r2 = new StringBuilder("VolumeStreamState.muteInternally(stream:");
            r2.append(AudioSystem.streamToString(this.mStream));
            if (this.mVal1 != 1) goto L21;
            String r3 = ", muted)";
        L22:
            r2.append(r3);
            return r2.toString();
        L21:
            r3 = ", unmuted)";
            goto L22
        L28:
            StringBuilder r4 = new StringBuilder("Voice activity change (");
            if (this.mVal2 != 1) goto L31;
            String r5 = DomainVerificationPersistence.TAG_ACTIVE;
        L32:
            r4.append(r5);
            r4.append(") causes setting volume to idx:");
            r4.append(this.mVal1);
            r4.append(" stream:");
            r4.append(AudioSystem.streamToString(this.mStream));
            r4.append(" device:");
            r4.append(AudioSystem.getOutputDeviceName(this.mVal3));
            return r4.toString();
        L31:
            r5 = "inactive";
            goto L32
        L5:
            return "FIXME invalid op:" + this.mOp;
        L7:
            return "setDeviceAbsoluteVolumeEnabled failed with " + this.mVal3 + " for dev: 0x" + Integer.toHexString(this.mVal1) + " enabled: " + this.mVal2 + " streamType: " + this.mStream;
        L15:
            return "adjustVolumeGroupVolume(group:" + this.mGroupName + " dir:" + AudioManager.adjustToString(this.mVal1) + " flags:0x" + Integer.toHexString(this.mVal2) + ") from " + this.mCaller;
        L17:
            return "setLeAudioVolume(stream:" + AudioSystem.streamToString(this.mStream) + " index:" + this.mVal1 + " maxIndex:" + this.mVal2;
        L25:
            return "setVolumeIndexForAttributes(group: group: " + this.mGroupName + " index:" + this.mVal1 + " flags:0x" + Integer.toHexString(this.mVal2) + ") from " + this.mCaller;
        L27:
            return "setMode(" + AudioSystem.modeToString(this.mVal2) + ") causes setting HEARING_AID volume to idx:" + this.mVal1 + " stream:" + AudioSystem.streamToString(this.mStream);
        L35:
            return "adjustStreamVolumeForUid(stream:" + AudioSystem.streamToString(this.mStream) + " dir:" + AudioManager.adjustToString(this.mVal1) + " flags:0x" + Integer.toHexString(this.mVal2) + ") from " + this.mCaller;
        L37:
            return "setAvrcpVolume: index:" + this.mVal1;
        L39:
            return "setHearingAidVolume: index:" + this.mVal1 + " gain dB:" + this.mVal2;
        L41:
            return "setStreamVolume(stream:" + AudioSystem.streamToString(this.mStream) + " index:" + this.mVal1 + " flags:0x" + Integer.toHexString(this.mVal2) + " oldIndex:" + this.mVal3 + ") from " + this.mCaller;
        L43:
            return "adjustStreamVolume(stream:" + AudioSystem.streamToString(this.mStream) + " dir:" + AudioManager.adjustToString(this.mVal1) + " flags:0x" + Integer.toHexString(this.mVal2) + ") from " + this.mCaller;
        L45:
            return "adjustSuggestedStreamVolume(sugg:" + AudioSystem.streamToString(this.mStream) + " dir:" + AudioManager.adjustToString(this.mVal1) + " flags:0x" + Integer.toHexString(this.mVal2) + ") from " + this.mCaller;
        }
    }

    static final class WiredDevConnectEvent extends EventLogger.Event {
        final AudioDeviceInventory.WiredDeviceConnectionState mState;

        WiredDevConnectEvent(AudioDeviceInventory.WiredDeviceConnectionState state) {
            this.mState = state;
        }

        @Override // com.android.server.utils.EventLogger.Event
        public String eventToString() {
            StringBuilder r0 = new StringBuilder("setWiredDeviceConnectionState(");
            r0.append(" type:");
            r0.append(Integer.toHexString(this.mState.mAttributes.getInternalType()));
            r0.append(" (");
            if (AudioSystem.isInputDevice(this.mState.mAttributes.getInternalType()) == false) goto L5;
            String r1 = StarLocation.KEY_LOCATION_SOURCE;
        L6:
            r0.append(r1);
            r0.append(") ");
            r0.append(" state:");
            r0.append(AudioSystem.deviceStateToString(this.mState.mState));
            r0.append(" addr:");
            r0.append(this.mState.mAttributes.getAddress());
            r0.append(" name:");
            r0.append(this.mState.mAttributes.getName());
            r0.append(") from ");
            r0.append(this.mState.mCaller);
            return r0.toString();
        L5:
            r1 = "sink";
            goto L6
        }
    }

    public AudioServiceEvents() {
    }
}
