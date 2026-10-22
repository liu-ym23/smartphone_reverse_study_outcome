package com.stepos.ailauncher.common.utils;

import Z8.C1173v;
import android.content.Context;
import android.media.AudioDeviceInfo;
import android.media.AudioManager;
import android.media.AudioPlaybackConfiguration;
import android.media.AudioRecordingConfiguration;
import android.os.Handler;
import android.os.Looper;
import android.os.Process;
import android.os.SystemClock;
import android.telecom.TelecomManager;
import android.telephony.TelephonyManager;
import androidx.exifinterface.media.ExifInterface;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.ailauncher.chat.voicewakeup.VoiceWakeupReceiver;
import com.stepos.core.download.ModelFlowMeta;
import com.stepos.policy.sdk.util.PolicySdkPermissionManifestUtils;
import h8.C4148a;
import h9.InterfaceC4149a;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.Result;
import p9.InterfaceC5074l;

@Metadata(d1 = {"\u0000z\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u0015\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001nB\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\u0007\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0007\u0010\u0006J\u000f\u0010\t\u001a\u00020\bH\u0002¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\r\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u0011\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\u000fH\u0002¢\u0006\u0004\b\u0011\u0010\u0012J\u0017\u0010\u0014\u001a\u00020\b2\u0006\u0010\u0013\u001a\u00020\u000fH\u0002¢\u0006\u0004\b\u0014\u0010\u0012J\u001d\u0010\u0018\u001a\u00020\u00172\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0015H\u0002¢\u0006\u0004\b\u0018\u0010\u0019J%\u0010\u001d\u001a\u00020\u001c2\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u000b0\u00152\u0006\u0010\u001b\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u001d\u0010\u001eJ#\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u000b0\u00152\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0015H\u0002¢\u0006\u0004\b\u001f\u0010 J\u0017\u0010\"\u001a\u00020\u00042\u0006\u0010!\u001a\u00020\u000fH\u0002¢\u0006\u0004\b\"\u0010#J\u000f\u0010$\u001a\u00020\u0004H\u0002¢\u0006\u0004\b$\u0010\u0006J\u000f\u0010%\u001a\u00020\u000fH\u0002¢\u0006\u0004\b%\u0010&J\u000f\u0010'\u001a\u00020\u0004H\u0002¢\u0006\u0004\b'\u0010\u0006J\u001f\u0010+\u001a\u00020\u00172\u0006\u0010)\u001a\u00020(2\u0006\u0010*\u001a\u00020\bH\u0002¢\u0006\u0004\b+\u0010,J\u000f\u0010-\u001a\u00020\u0004H\u0002¢\u0006\u0004\b-\u0010\u0006J\u000f\u0010.\u001a\u00020\u0004H\u0002¢\u0006\u0004\b.\u0010\u0006J\u0017\u00100\u001a\u00020\u00042\u0006\u0010/\u001a\u00020\u000fH\u0002¢\u0006\u0004\b0\u0010#J\u0019\u00101\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\f\u001a\u00020\u000bH\u0002¢\u0006\u0004\b1\u00102J\u0015\u00105\u001a\u00020\u00172\u0006\u00104\u001a\u000203¢\u0006\u0004\b5\u00106J\u0015\u00108\u001a\u00020\u00172\u0006\u00107\u001a\u00020\u0004¢\u0006\u0004\b8\u00109J\u0015\u0010;\u001a\u00020\u00172\u0006\u0010:\u001a\u00020\u000f¢\u0006\u0004\b;\u0010<J\r\u0010=\u001a\u00020\u001c¢\u0006\u0004\b=\u0010>J\r\u0010?\u001a\u00020\u0004¢\u0006\u0004\b?\u0010\u0006J\u000f\u0010A\u001a\u0004\u0018\u00010@¢\u0006\u0004\bA\u0010BJ\r\u0010C\u001a\u00020\u001c¢\u0006\u0004\bC\u0010>J\r\u0010D\u001a\u00020\u0017¢\u0006\u0004\bD\u0010\u0003J\r\u0010E\u001a\u00020\u0004¢\u0006\u0004\bE\u0010\u0006J\r\u0010F\u001a\u00020\u0004¢\u0006\u0004\bF\u0010\u0006J\r\u0010G\u001a\u00020\u0004¢\u0006\u0004\bG\u0010\u0006J\r\u0010H\u001a\u00020\u0004¢\u0006\u0004\bH\u0010\u0006J\r\u0010I\u001a\u00020\u0004¢\u0006\u0004\bI\u0010\u0006J\u0015\u0010K\u001a\u00020\u00172\u0006\u0010J\u001a\u00020\b¢\u0006\u0004\bK\u0010LJ\r\u0010N\u001a\u00020M¢\u0006\u0004\bN\u0010OJ\u0015\u0010P\u001a\u00020\u00172\u0006\u00107\u001a\u00020\u0004¢\u0006\u0004\bP\u00109R\u0014\u0010Q\u001a\u00020\b8\u0002X\u0082T¢\u0006\u0006\n\u0004\bQ\u0010RR\u0014\u0010S\u001a\u00020\b8\u0006X\u0086T¢\u0006\u0006\n\u0004\bS\u0010RR\u0014\u0010U\u001a\u00020T8\u0002X\u0082T¢\u0006\u0006\n\u0004\bU\u0010\u0018R\u0014\u0010V\u001a\u00020\b8\u0002X\u0082T¢\u0006\u0006\n\u0004\bV\u0010RR\u0014\u0010W\u001a\u00020T8\u0002X\u0082T¢\u0006\u0006\n\u0004\bW\u0010\u0018R\u0014\u0010X\u001a\u00020(8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bX\u0010YR\u0014\u0010Z\u001a\u00020(8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bZ\u0010YR\u0014\u0010[\u001a\u00020(8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b[\u0010YR\u0014\u0010\\\u001a\u00020(8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\\\u0010YR\u0016\u0010]\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b]\u0010^R\u0016\u0010_\u001a\u00020T8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b_\u0010\u0018R\u0014\u0010a\u001a\u00020`8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\ba\u0010bR\u0016\u0010c\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bc\u0010^R\u0016\u0010d\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bd\u0010^R\u0016\u0010e\u001a\u00020T8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\be\u0010\u0018R\u0016\u0010f\u001a\u00020\u001c8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bf\u0010gR\u0016\u0010h\u001a\u00020\u001c8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bh\u0010gR\u0016\u0010i\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bi\u0010^R\u0016\u0010j\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bj\u0010^R\u0014\u0010l\u001a\u00020k8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bl\u0010m¨\u0006o"}, d2 = {"Lcom/stepos/ailauncher/common/utils/MicOccupancyMonitor;", "", "<init>", "()V", "", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_REMOVE, "()Z", "l", "", "z", "()Ljava/lang/String;", "Landroid/media/AudioRecordingConfiguration;", "config", "f", "(Landroid/media/AudioRecordingConfiguration;)Ljava/lang/String;", "", "mode", "c", "(I)Ljava/lang/String;", VoiceWakeupReceiver.EXTRA_STATE, Const.INTENT_KEY_UMID, "", "configs", "LY8/t;", "J", "(Ljava/util/List;)V", "activeConfigs", "includeSelfMarker", "Lcom/stepos/ailauncher/common/utils/MicOccupancyMonitor$OccupancyKind;", "e", "(Ljava/util/List;Z)Lcom/stepos/ailauncher/common/utils/MicOccupancyMonitor$OccupancyKind;", "y", "(Ljava/util/List;)Ljava/util/List;", "source", "v", "(I)Z", "C", "B", "()I", "k", "Ljava/util/concurrent/atomic/AtomicBoolean;", "flag", "message", "K", "(Ljava/util/concurrent/atomic/AtomicBoolean;Ljava/lang/String;)V", "s", "t", "uid", "q", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "(Landroid/media/AudioRecordingConfiguration;)Ljava/lang/Integer;", "Landroid/content/Context;", "context", "m", "(Landroid/content/Context;)V", "active", "H", "(Z)V", "audioSessionId", ExifInterface.LONGITUDE_EAST, "(I)V", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "()Lcom/stepos/ailauncher/common/utils/MicOccupancyMonitor$OccupancyKind;", "I", "Landroid/media/AudioDeviceInfo;", Const.INTENT_KEY_BACKGROUND_COMMAND, "()Landroid/media/AudioDeviceInfo;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "D", "r", "n", "u", "p", "o", "reason", "w", "(Ljava/lang/String;)V", "", "F", "()[I", "G", "TAG", "Ljava/lang/String;", "CALL_LISTEN", "", "SELF_RELEASE_GRACE_MS", "SOUND_RECORDER_PACKAGE", "PERMISSION_RECHECK_MS", "initialized", "Ljava/util/concurrent/atomic/AtomicBoolean;", "clientUidReadWarned", "telecomInCallWarned", "phoneCallStateWarned", "readPhoneStateGranted", "Z", "readPhoneStateCheckedAtMs", "Landroid/os/Handler;", "mainHandler", "Landroid/os/Handler;", "occupiedByOthers", "selfRecordingActive", "selfRecordingStoppedAtMs", "latestOccupancyKind", "Lcom/stepos/ailauncher/common/utils/MicOccupancyMonitor$OccupancyKind;", "occupancyBeforeSelfRecording", "externalRecordingHint", "externalVoipHint", "Lcom/stepos/ailauncher/common/utils/K;", "selfCaptureSessions", "Lcom/stepos/ailauncher/common/utils/K;", "OccupancyKind", "utils_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class MicOccupancyMonitor {
    public static final String CALL_LISTEN = "CallListen";
    private static final long PERMISSION_RECHECK_MS = 60000;
    private static final long SELF_RELEASE_GRACE_MS = 400;
    private static final String SOUND_RECORDER_PACKAGE = "com.android.soundrecorder";
    private static final String TAG = "MicOccupancyMonitor";
    private static volatile boolean externalRecordingHint;
    private static volatile boolean externalVoipHint;
    private static volatile OccupancyKind latestOccupancyKind;
    private static volatile OccupancyKind occupancyBeforeSelfRecording;
    private static volatile boolean occupiedByOthers;
    private static volatile boolean readPhoneStateGranted;
    private static final K selfCaptureSessions;
    private static volatile boolean selfRecordingActive;
    private static volatile long selfRecordingStoppedAtMs;
    public static final MicOccupancyMonitor INSTANCE = new MicOccupancyMonitor();
    private static final AtomicBoolean initialized = new AtomicBoolean(false);
    private static final AtomicBoolean clientUidReadWarned = new AtomicBoolean(false);
    private static final AtomicBoolean telecomInCallWarned = new AtomicBoolean(false);
    private static final AtomicBoolean phoneCallStateWarned = new AtomicBoolean(false);
    private static volatile long readPhoneStateCheckedAtMs = -60000;
    private static final Handler mainHandler = new Handler(Looper.getMainLooper());

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/stepos/ailauncher/common/utils/MicOccupancyMonitor$OccupancyKind;", "", "<init>", "(Ljava/lang/String;I)V", ModelFlowMeta.PLAN_NONE, "SELF_ONLY", "EXTERNAL_RECORDING", "EXTERNAL_VOIP", "SYSTEM_CALL", "utils_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class OccupancyKind {
        private static final /* synthetic */ InterfaceC4149a $ENTRIES;
        private static final /* synthetic */ OccupancyKind[] $VALUES;
        public static final OccupancyKind NONE = new OccupancyKind(ModelFlowMeta.PLAN_NONE, 0);
        public static final OccupancyKind SELF_ONLY = new OccupancyKind("SELF_ONLY", 1);
        public static final OccupancyKind EXTERNAL_RECORDING = new OccupancyKind("EXTERNAL_RECORDING", 2);
        public static final OccupancyKind EXTERNAL_VOIP = new OccupancyKind("EXTERNAL_VOIP", 3);
        public static final OccupancyKind SYSTEM_CALL = new OccupancyKind("SYSTEM_CALL", 4);

        private static final /* synthetic */ OccupancyKind[] $values() {
            return new OccupancyKind[]{NONE, SELF_ONLY, EXTERNAL_RECORDING, EXTERNAL_VOIP, SYSTEM_CALL};
        }

        static {
            OccupancyKind[] occupancyKindArr$values = $values();
            $VALUES = occupancyKindArr$values;
            $ENTRIES = kotlin.enums.a.a(occupancyKindArr$values);
        }

        private OccupancyKind(String str, int i10) {
        }

        public static InterfaceC4149a<OccupancyKind> getEntries() {
            return $ENTRIES;
        }

        public static OccupancyKind valueOf(String str) {
            return (OccupancyKind) Enum.valueOf(OccupancyKind.class, str);
        }

        public static OccupancyKind[] values() {
            return (OccupancyKind[]) $VALUES.clone();
        }
    }

    @Metadata(d1 = {"\u0000\u001b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001d\u0010\u0006\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"com/stepos/ailauncher/common/utils/MicOccupancyMonitor$a", "Landroid/media/AudioManager$AudioRecordingCallback;", "", "Landroid/media/AudioRecordingConfiguration;", "configs", "LY8/t;", "onRecordingConfigChanged", "(Ljava/util/List;)V", "utils_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class a extends AudioManager.AudioRecordingCallback {
        @Override // android.media.AudioManager.AudioRecordingCallback
        public void onRecordingConfigChanged(List<AudioRecordingConfiguration> configs) {
            kotlin.jvm.internal.p.i(configs, "configs");
            MicOccupancyMonitor.INSTANCE.J(configs);
        }
    }

    static {
        OccupancyKind occupancyKind = OccupancyKind.NONE;
        latestOccupancyKind = occupancyKind;
        occupancyBeforeSelfRecording = occupancyKind;
        selfCaptureSessions = new K(0, 1, null);
    }

    public static final CharSequence x(AudioRecordingConfiguration audioRecordingConfiguration) {
        MicOccupancyMonitor micOccupancyMonitor = INSTANCE;
        kotlin.jvm.internal.p.f(audioRecordingConfiguration);
        return micOccupancyMonitor.f(audioRecordingConfiguration);
    }

    public final Integer A(AudioRecordingConfiguration config) {
        Throwable targetException;
        try {
            Object objInvoke = config.getClass().getMethod("getClientUid", null).invoke(config, null);
            if (objInvoke instanceof Integer) {
                return (Integer) objInvoke;
            }
            return null;
        } catch (Throwable th) {
            th = th;
            if (clientUidReadWarned.compareAndSet(false, true)) {
                InvocationTargetException invocationTargetException = th instanceof InvocationTargetException ? (InvocationTargetException) th : null;
                if (invocationTargetException != null && (targetException = invocationTargetException.getTargetException()) != null) {
                    th = targetException;
                }
                C4148a.u(TAG, "readClientUid unavailable, fallback to audioSource: " + th.getMessage(), false, 4, null);
            }
            return null;
        }
    }

    public final int B() {
        if (!k()) {
            return 0;
        }
        Object systemService = C3197a.INSTANCE.a().getSystemService("phone");
        TelephonyManager telephonyManager = systemService instanceof TelephonyManager ? (TelephonyManager) systemService : null;
        if (telephonyManager == null) {
            return 0;
        }
        try {
            return telephonyManager.getCallState();
        } catch (Throwable th) {
            this.K(phoneCallStateWarned, "callState failed: " + th.getMessage());
            return 0;
        }
    }

    public final boolean C() {
        if (!k()) {
            return false;
        }
        Object systemService = C3197a.INSTANCE.a().getSystemService("telecom");
        TelecomManager telecomManager = systemService instanceof TelecomManager ? (TelecomManager) systemService : null;
        if (telecomManager == null) {
            return false;
        }
        try {
            return telecomManager.isInCall();
        } catch (Throwable th) {
            this.K(telecomInCallWarned, "isInCall failed: " + th.getMessage());
            return false;
        }
    }

    public final void D() {
        Object systemService = C3197a.INSTANCE.a().getSystemService("audio");
        AudioManager audioManager = systemService instanceof AudioManager ? (AudioManager) systemService : null;
        List<AudioRecordingConfiguration> activeRecordingConfigurations = audioManager != null ? audioManager.getActiveRecordingConfigurations() : null;
        if (activeRecordingConfigurations == null) {
            activeRecordingConfigurations = C1173v.m();
        }
        J(activeRecordingConfigurations);
    }

    public final void E(int audioSessionId) {
        if (selfCaptureSessions.b(audioSessionId)) {
            D();
            C4148a.d(TAG, "registerSelfCaptureSession: session=" + audioSessionId + " kind=" + latestOccupancyKind, false, 4, null);
        }
    }

    public final int[] F() {
        D();
        boolean zR = r();
        OccupancyKind occupancyKind = (selfRecordingActive && latestOccupancyKind == OccupancyKind.SELF_ONLY && occupancyBeforeSelfRecording != OccupancyKind.NONE) ? occupancyBeforeSelfRecording : latestOccupancyKind;
        boolean z10 = true;
        boolean z11 = occupancyKind == OccupancyKind.EXTERNAL_RECORDING;
        if (occupancyKind != OccupancyKind.EXTERNAL_VOIP && !t()) {
            z10 = false;
        }
        int[] iArrB = G.b(zR, z11, z10);
        OccupancyKind occupancyKind2 = latestOccupancyKind;
        OccupancyKind occupancyKind3 = occupancyBeforeSelfRecording;
        int iB = B();
        String string = Arrays.toString(iArrB);
        kotlin.jvm.internal.p.h(string, "toString(...)");
        C4148a.d(TAG, "resolveAsrAudioSourceCandidates: offHook=" + zR + " externalRecording=" + z11 + " externalVoip=" + z10 + " kind=" + occupancyKind2 + " effectiveKind=" + occupancyKind + " preSelf=" + occupancyKind3 + " callState=" + iB + " candidates=" + string, false, 4, null);
        return iArrB;
    }

    public final void G(boolean active) {
        externalRecordingHint = active;
        D();
        C4148a.d(TAG, "setExternalRecordingHint: active=" + active + " kind=" + latestOccupancyKind, false, 4, null);
    }

    public final void H(boolean active) {
        Object systemService = C3197a.INSTANCE.a().getSystemService("audio");
        AudioManager audioManager = systemService instanceof AudioManager ? (AudioManager) systemService : null;
        List<AudioRecordingConfiguration> activeRecordingConfigurations = audioManager != null ? audioManager.getActiveRecordingConfigurations() : null;
        if (activeRecordingConfigurations == null) {
            activeRecordingConfigurations = C1173v.m();
        }
        if (active) {
            occupancyBeforeSelfRecording = e(y(activeRecordingConfigurations), false);
            selfRecordingStoppedAtMs = 0L;
        } else {
            occupancyBeforeSelfRecording = OccupancyKind.NONE;
            selfRecordingStoppedAtMs = SystemClock.elapsedRealtime();
        }
        selfRecordingActive = active;
        J(activeRecordingConfigurations);
        C4148a.d(TAG, "setSelfRecordingActive: active=" + active + " kind=" + latestOccupancyKind + " preSelf=" + occupancyBeforeSelfRecording + " occupiedByOthers=" + occupiedByOthers, false, 4, null);
    }

    public final boolean I() {
        return G.c(i(), occupancyBeforeSelfRecording);
    }

    public final void J(List<AudioRecordingConfiguration> configs) {
        List<AudioRecordingConfiguration> listY = y(configs);
        boolean z10 = true;
        latestOccupancyKind = e(listY, true);
        if (latestOccupancyKind != OccupancyKind.EXTERNAL_RECORDING && latestOccupancyKind != OccupancyKind.EXTERNAL_VOIP) {
            z10 = false;
        }
        occupiedByOthers = z10;
        C4148a.d(TAG, "updateOccupiedState: kind=" + latestOccupancyKind + " configs=" + configs.size() + " active=" + listY.size(), false, 4, null);
    }

    public final void K(AtomicBoolean flag, String message) {
        if (flag.compareAndSet(false, true)) {
            C4148a.u(TAG, message, false, 4, null);
        }
    }

    public final String c(int mode) {
        if (mode == 0) {
            return "NORMAL";
        }
        if (mode == 1) {
            return "RINGTONE";
        }
        if (mode == 2) {
            return "IN_CALL";
        }
        if (mode == 3) {
            return "IN_COMMUNICATION";
        }
        return "mode" + mode;
    }

    public final String d(int state) {
        if (state == 0) {
            return "IDLE";
        }
        if (state == 1) {
            return "RINGING";
        }
        if (state == 2) {
            return "OFFHOOK";
        }
        return VoiceWakeupReceiver.EXTRA_STATE + state;
    }

    public final OccupancyKind e(List<AudioRecordingConfiguration> activeConfigs, boolean includeSelfMarker) {
        Integer numA;
        if (r()) {
            return OccupancyKind.SYSTEM_CALL;
        }
        int iMyUid = Process.myUid();
        boolean z10 = externalRecordingHint;
        boolean z11 = externalVoipHint;
        boolean z12 = false;
        boolean z13 = false;
        boolean z14 = false;
        for (AudioRecordingConfiguration audioRecordingConfiguration : activeConfigs) {
            if (selfCaptureSessions.a(audioRecordingConfiguration.getClientAudioSessionId()) || ((numA = A(audioRecordingConfiguration)) != null && numA.intValue() == iMyUid)) {
                z14 = true;
            } else if (numA == null) {
                if (!includeSelfMarker || !selfRecordingActive || activeConfigs.size() > 1) {
                    if (v(audioRecordingConfiguration.getClientAudioSource())) {
                        z13 = true;
                    } else {
                        z12 = true;
                    }
                }
            } else if (q(numA.intValue()) || !v(audioRecordingConfiguration.getClientAudioSource())) {
                z10 = true;
            } else {
                z11 = true;
            }
        }
        if (z10 || z12) {
            return OccupancyKind.EXTERNAL_RECORDING;
        }
        if (z11 || z13) {
            return OccupancyKind.EXTERNAL_VOIP;
        }
        if (z14 || (includeSelfMarker && selfRecordingActive)) {
            return OccupancyKind.SELF_ONLY;
        }
        if (activeConfigs.isEmpty() && !t()) {
            return OccupancyKind.NONE;
        }
        return OccupancyKind.EXTERNAL_VOIP;
    }

    /* JADX WARN: Removed duplicated region for block: B:9:0x002c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.String f(android.media.AudioRecordingConfiguration r12) {
        /*
            r11 = this;
            java.lang.Integer r11 = r11.A(r12)
            if (r11 == 0) goto L2c
            int r0 = r11.intValue()
            com.stepos.ailauncher.common.utils.a r1 = com.stepos.ailauncher.common.utils.C3197a.INSTANCE
            android.app.Application r1 = r1.a()
            android.content.pm.PackageManager r1 = r1.getPackageManager()
            java.lang.String[] r2 = r1.getPackagesForUid(r0)
            if (r2 == 0) goto L29
            r9 = 62
            r10 = 0
            java.lang.String r3 = ","
            r4 = 0
            r5 = 0
            r6 = 0
            r7 = 0
            r8 = 0
            java.lang.String r0 = Z8.r.w0(r2, r3, r4, r5, r6, r7, r8, r9, r10)
            goto L2a
        L29:
            r0 = 0
        L2a:
            if (r0 != 0) goto L2e
        L2c:
            java.lang.String r0 = "?"
        L2e:
            com.stepos.ailauncher.common.utils.K r1 = com.stepos.ailauncher.common.utils.MicOccupancyMonitor.selfCaptureSessions
            int r2 = r12.getClientAudioSessionId()
            boolean r1 = r1.a(r2)
            int r2 = r12.getClientAudioSessionId()
            int r3 = r12.getClientAudioSource()
            boolean r12 = r12.isClientSilenced()
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r5 = "sid="
            r4.append(r5)
            r4.append(r2)
            java.lang.String r2 = " src="
            r4.append(r2)
            r4.append(r3)
            java.lang.String r2 = " uid="
            r4.append(r2)
            r4.append(r11)
            java.lang.String r11 = " pkg="
            r4.append(r11)
            r4.append(r0)
            java.lang.String r11 = " selfSession="
            r4.append(r11)
            r4.append(r1)
            java.lang.String r11 = " silenced="
            r4.append(r11)
            r4.append(r12)
            java.lang.String r11 = r4.toString()
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.ailauncher.common.utils.MicOccupancyMonitor.f(android.media.AudioRecordingConfiguration):java.lang.String");
    }

    public final AudioDeviceInfo g() {
        Object systemService = C3197a.INSTANCE.a().getSystemService("audio");
        AudioManager audioManager = systemService instanceof AudioManager ? (AudioManager) systemService : null;
        if (audioManager == null) {
            return null;
        }
        int iMyUid = Process.myUid();
        for (AudioRecordingConfiguration audioRecordingConfiguration : audioManager.getActiveRecordingConfigurations()) {
            if (!audioRecordingConfiguration.isClientSilenced() && !selfCaptureSessions.a(audioRecordingConfiguration.getClientAudioSessionId())) {
                kotlin.jvm.internal.p.f(audioRecordingConfiguration);
                Integer numA = A(audioRecordingConfiguration);
                if (numA == null || numA.intValue() != iMyUid) {
                    AudioDeviceInfo audioDevice = audioRecordingConfiguration.getAudioDevice();
                    if (audioDevice == null) {
                        continue;
                    } else {
                        if (!audioDevice.isSource()) {
                            audioDevice = null;
                        }
                        if (audioDevice != null) {
                            return audioDevice;
                        }
                    }
                }
            }
        }
        return null;
    }

    public final OccupancyKind h() {
        return latestOccupancyKind;
    }

    public final OccupancyKind i() {
        if (externalRecordingHint || latestOccupancyKind == OccupancyKind.EXTERNAL_RECORDING) {
            return OccupancyKind.EXTERNAL_RECORDING;
        }
        Object systemService = C3197a.INSTANCE.a().getSystemService("audio");
        AudioManager audioManager = systemService instanceof AudioManager ? (AudioManager) systemService : null;
        List<AudioRecordingConfiguration> activeRecordingConfigurations = audioManager != null ? audioManager.getActiveRecordingConfigurations() : null;
        if (activeRecordingConfigurations == null) {
            activeRecordingConfigurations = C1173v.m();
        }
        int iMyUid = Process.myUid();
        List<AudioRecordingConfiguration> list = activeRecordingConfigurations;
        if (!(list instanceof Collection) || !list.isEmpty()) {
            for (AudioRecordingConfiguration audioRecordingConfiguration : list) {
                if (audioRecordingConfiguration.isClientSilenced() && !selfCaptureSessions.a(audioRecordingConfiguration.getClientAudioSessionId())) {
                    MicOccupancyMonitor micOccupancyMonitor = INSTANCE;
                    kotlin.jvm.internal.p.f(audioRecordingConfiguration);
                    Integer numA = micOccupancyMonitor.A(audioRecordingConfiguration);
                    if (numA == null || numA.intValue() != iMyUid) {
                        if (numA == null) {
                            if (!micOccupancyMonitor.v(audioRecordingConfiguration.getClientAudioSource())) {
                                return OccupancyKind.EXTERNAL_RECORDING;
                            }
                        } else if (micOccupancyMonitor.q(numA.intValue()) || !micOccupancyMonitor.v(audioRecordingConfiguration.getClientAudioSource())) {
                            return OccupancyKind.EXTERNAL_RECORDING;
                        }
                    }
                }
            }
        }
        return latestOccupancyKind;
    }

    public final boolean j() {
        String strZ = z();
        return La.D.X(strZ, "voipSrc", false, 2, null) || La.D.X(strZ, "otherUid", false, 2, null) || La.D.X(strZ, "extraMic", false, 2, null);
    }

    public final boolean k() {
        if (readPhoneStateGranted) {
            return true;
        }
        long jUptimeMillis = SystemClock.uptimeMillis();
        if (jUptimeMillis - readPhoneStateCheckedAtMs < 60000) {
            return false;
        }
        readPhoneStateCheckedAtMs = jUptimeMillis;
        boolean z10 = C3197a.INSTANCE.a().checkPermission(PolicySdkPermissionManifestUtils.READ_PHONE_STATE, Process.myPid(), Process.myUid()) == 0;
        if (z10) {
            readPhoneStateGranted = true;
        }
        return z10;
    }

    public final boolean l() {
        Object systemService = C3197a.INSTANCE.a().getSystemService("audio");
        AudioManager audioManager = systemService instanceof AudioManager ? (AudioManager) systemService : null;
        if (audioManager == null) {
            return false;
        }
        int iMyUid = Process.myUid();
        List<AudioRecordingConfiguration> activeRecordingConfigurations = audioManager.getActiveRecordingConfigurations();
        kotlin.jvm.internal.p.h(activeRecordingConfigurations, "getActiveRecordingConfigurations(...)");
        List<AudioRecordingConfiguration> list = activeRecordingConfigurations;
        if ((list instanceof Collection) && list.isEmpty()) {
            return false;
        }
        for (AudioRecordingConfiguration audioRecordingConfiguration : list) {
            if (audioRecordingConfiguration.isClientSilenced() && !selfCaptureSessions.a(audioRecordingConfiguration.getClientAudioSessionId())) {
                MicOccupancyMonitor micOccupancyMonitor = INSTANCE;
                if (micOccupancyMonitor.v(audioRecordingConfiguration.getClientAudioSource())) {
                    kotlin.jvm.internal.p.f(audioRecordingConfiguration);
                    Integer numA = micOccupancyMonitor.A(audioRecordingConfiguration);
                    if (numA == null || numA.intValue() != iMyUid) {
                        return true;
                    }
                } else {
                    continue;
                }
            }
        }
        return false;
    }

    public final void m(Context context) {
        kotlin.jvm.internal.p.i(context, "context");
        if (initialized.compareAndSet(false, true)) {
            Object systemService = context.getApplicationContext().getSystemService("audio");
            AudioManager audioManager = systemService instanceof AudioManager ? (AudioManager) systemService : null;
            if (audioManager == null) {
                C4148a.u(TAG, "init: AudioManager unavailable", false, 4, null);
                return;
            }
            audioManager.registerAudioRecordingCallback(new a(), mainHandler);
            List<AudioRecordingConfiguration> activeRecordingConfigurations = audioManager.getActiveRecordingConfigurations();
            kotlin.jvm.internal.p.h(activeRecordingConfigurations, "getActiveRecordingConfigurations(...)");
            J(activeRecordingConfigurations);
            C4148a.k(TAG, "init: registered AudioRecordingCallback kind=" + latestOccupancyKind + " occupiedByOthers=" + occupiedByOthers, false, 4, null);
        }
    }

    public final boolean n() {
        return r() || u();
    }

    public final boolean o() {
        Object objB;
        Object systemService = C3197a.INSTANCE.a().getSystemService("audio");
        AudioManager audioManager = systemService instanceof AudioManager ? (AudioManager) systemService : null;
        if (audioManager == null) {
            return false;
        }
        int iMyUid = Process.myUid();
        List<AudioPlaybackConfiguration> activePlaybackConfigurations = audioManager.getActivePlaybackConfigurations();
        kotlin.jvm.internal.p.h(activePlaybackConfigurations, "getActivePlaybackConfigurations(...)");
        List<AudioPlaybackConfiguration> list = activePlaybackConfigurations;
        if ((list instanceof Collection) && list.isEmpty()) {
            return false;
        }
        for (AudioPlaybackConfiguration audioPlaybackConfiguration : list) {
            int usage = audioPlaybackConfiguration.getAudioAttributes().getUsage();
            if (usage == 6 || usage == 3) {
                try {
                    Result.Companion companion = Result.INSTANCE;
                    Object objInvoke = audioPlaybackConfiguration.getClass().getMethod("getClientUid", null).invoke(audioPlaybackConfiguration, null);
                    objB = Result.b(objInvoke instanceof Integer ? (Integer) objInvoke : null);
                } catch (Throwable th) {
                    Result.Companion companion2 = Result.INSTANCE;
                    objB = Result.b(C4849c.a(th));
                }
                if (Result.g(objB)) {
                    objB = null;
                }
                Integer num = (Integer) objB;
                if (num == null || num.intValue() < 0 || num.intValue() != iMyUid) {
                    return true;
                }
            }
        }
        return false;
    }

    public final boolean p() {
        if (n()) {
            return false;
        }
        if (t()) {
            return true;
        }
        Object systemService = C3197a.INSTANCE.a().getSystemService("audio");
        AudioManager audioManager = systemService instanceof AudioManager ? (AudioManager) systemService : null;
        if ((audioManager == null || audioManager.getMode() != 1) && B() != 1) {
            return o();
        }
        return true;
    }

    public final boolean q(int uid) {
        String[] packagesForUid = C3197a.INSTANCE.a().getPackageManager().getPackagesForUid(uid);
        if (packagesForUid == null) {
            packagesForUid = new String[0];
        }
        for (String str : packagesForUid) {
            if (kotlin.jvm.internal.p.d(str, SOUND_RECORDER_PACKAGE)) {
                return true;
            }
        }
        return false;
    }

    public final boolean r() {
        return G.a(C(), B(), s());
    }

    public final boolean s() {
        Object systemService = C3197a.INSTANCE.a().getSystemService("audio");
        AudioManager audioManager = systemService instanceof AudioManager ? (AudioManager) systemService : null;
        return audioManager != null && audioManager.getMode() == 2;
    }

    public final boolean t() {
        Object systemService = C3197a.INSTANCE.a().getSystemService("audio");
        AudioManager audioManager = systemService instanceof AudioManager ? (AudioManager) systemService : null;
        return audioManager != null && audioManager.getMode() == 3;
    }

    public final boolean u() {
        return G.d(t(), j(), l());
    }

    public final boolean v(int source) {
        return source == 7 || source == 4 || source == 2;
    }

    public final void w(String reason) {
        kotlin.jvm.internal.p.i(reason, "reason");
        Object systemService = C3197a.INSTANCE.a().getSystemService("audio");
        AudioManager audioManager = systemService instanceof AudioManager ? (AudioManager) systemService : null;
        int mode = audioManager != null ? audioManager.getMode() : -1;
        int iB = B();
        List<AudioRecordingConfiguration> activeRecordingConfigurations = audioManager != null ? audioManager.getActiveRecordingConfigurations() : null;
        if (activeRecordingConfigurations == null) {
            activeRecordingConfigurations = C1173v.m();
        }
        String strA0 = activeRecordingConfigurations.isEmpty() ? "none" : Z8.F.A0(activeRecordingConfigurations, " || ", null, null, 0, null, new InterfaceC5074l() { // from class: com.stepos.ailauncher.common.utils.F
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return MicOccupancyMonitor.x((AudioRecordingConfiguration) obj);
            }
        }, 30, null);
        C4148a.k(CALL_LISTEN, "reason=" + reason + " mode=" + mode + "/" + c(mode) + " callState=" + iB + "/" + d(iB) + " offHook=" + r() + " voipMode=" + t() + " otherCapture=" + z() + " voipAnswered=" + u() + " answered=" + n() + " incomingNotAnswered=" + p() + " foreignRing=" + o() + " selfRecording=" + selfRecordingActive + " n=" + activeRecordingConfigurations.size() + " [" + strA0 + "]", false, 4, null);
    }

    public final List<AudioRecordingConfiguration> y(List<AudioRecordingConfiguration> configs) {
        ArrayList arrayList = new ArrayList();
        for (Object obj : configs) {
            if (!((AudioRecordingConfiguration) obj).isClientSilenced()) {
                arrayList.add(obj);
            }
        }
        return arrayList;
    }

    public final String z() {
        Integer numA;
        Object systemService = C3197a.INSTANCE.a().getSystemService("audio");
        AudioManager audioManager = systemService instanceof AudioManager ? (AudioManager) systemService : null;
        if (audioManager == null) {
            return "noAudioManager";
        }
        List<AudioRecordingConfiguration> activeRecordingConfigurations = audioManager.getActiveRecordingConfigurations();
        kotlin.jvm.internal.p.h(activeRecordingConfigurations, "getActiveRecordingConfigurations(...)");
        List<AudioRecordingConfiguration> listY = y(activeRecordingConfigurations);
        if (listY.isEmpty()) {
            return "none";
        }
        int iMyUid = Process.myUid();
        int i10 = 0;
        for (AudioRecordingConfiguration audioRecordingConfiguration : listY) {
            if (selfCaptureSessions.a(audioRecordingConfiguration.getClientAudioSessionId()) || ((numA = A(audioRecordingConfiguration)) != null && numA.intValue() == iMyUid)) {
                i10++;
            } else {
                if (numA != null) {
                    return "otherUid uid=" + numA + " sid=" + audioRecordingConfiguration.getClientAudioSessionId() + " src=" + audioRecordingConfiguration.getClientAudioSource();
                }
                if (v(audioRecordingConfiguration.getClientAudioSource())) {
                    return "voipSrc sid=" + audioRecordingConfiguration.getClientAudioSessionId() + " src=" + audioRecordingConfiguration.getClientAudioSource();
                }
            }
        }
        if (listY.size() <= i10 || (selfRecordingActive && listY.size() <= 1)) {
            return "none";
        }
        return "extraMic n=" + listY.size() + " self=" + i10;
    }
}
