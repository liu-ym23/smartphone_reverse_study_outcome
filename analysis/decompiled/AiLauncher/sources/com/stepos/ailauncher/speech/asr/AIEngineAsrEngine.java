package com.stepos.ailauncher.speech.asr;

import La.z;
import Ua.C1060i;
import Ua.L0;
import Ua.M;
import Ua.Y;
import Y8.t;
import Z8.F;
import android.content.Context;
import android.media.AudioDeviceInfo;
import android.media.AudioManager;
import android.media.AudioRecord;
import androidx.exifinterface.media.ExifInterface;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.aiengine.algorithm.asr.IAsrSseStreamRecognizer;
import com.stepos.aiengine.args.SingleFileBundle;
import com.stepos.aiengine.clients.AlgorithmClients;
import com.stepos.ailauncher.common.utils.I;
import com.stepos.ailauncher.common.utils.MicOccupancyMonitor;
import com.stepos.ailauncher.contract.api.speech.AsrCallback;
import com.stepos.ailauncher.sla.SlaVoiceBridge;
import e9.InterfaceC4014c;
import h8.C4148a;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.jvm.internal.p;
import v9.C5685n;

@Metadata(d1 = {"\u0000º\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0005\n\u0002\u0010\u0017\n\u0002\b\u0003\n\u0002\u0010\u0006\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\n\b\u0000\u0018\u0000 \u008b\u00012\u00020\u0001:\u0005\u001e\u008c\u0001\u0007\u001bB\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0007\u0010\bJ-\u0010\u000e\u001a\u00020\r2\b\u0010\n\u001a\u0004\u0018\u00010\t2\b\u0010\u000b\u001a\u0004\u0018\u00010\t2\b\u0010\f\u001a\u0004\u0018\u00010\tH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u0019\u0010\u0011\u001a\u00020\r2\b\u0010\u0010\u001a\u0004\u0018\u00010\tH\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0013\u001a\u00020\tH\u0016¢\u0006\u0004\b\u0013\u0010\u0014J\u000f\u0010\u0015\u001a\u00020\tH\u0016¢\u0006\u0004\b\u0015\u0010\u0014J\u000f\u0010\u0016\u001a\u00020\tH\u0016¢\u0006\u0004\b\u0016\u0010\u0014J\u0017\u0010\u0019\u001a\u00020\r2\u0006\u0010\u0018\u001a\u00020\u0017H\u0016¢\u0006\u0004\b\u0019\u0010\u001aJ\u0017\u0010\u001b\u001a\u00020\r2\u0006\u0010\u0018\u001a\u00020\u0017H\u0016¢\u0006\u0004\b\u001b\u0010\u001aJ\u000f\u0010\u001c\u001a\u00020\rH\u0016¢\u0006\u0004\b\u001c\u0010\u001dJ\u000f\u0010\u001e\u001a\u00020\rH\u0016¢\u0006\u0004\b\u001e\u0010\u001dJ\u000f\u0010\u001f\u001a\u00020\rH\u0016¢\u0006\u0004\b\u001f\u0010\u001dJ\u0017\u0010 \u001a\u00020\r2\u0006\u0010\u0018\u001a\u00020\u0017H\u0016¢\u0006\u0004\b \u0010\u001aJ\u0017\u0010!\u001a\u00020\r2\u0006\u0010\u0018\u001a\u00020\u0017H\u0016¢\u0006\u0004\b!\u0010\u001aJ\u0017\u0010#\u001a\u00020\r2\u0006\u0010\"\u001a\u00020\u0006H\u0016¢\u0006\u0004\b#\u0010$J\u000f\u0010%\u001a\u00020\rH\u0016¢\u0006\u0004\b%\u0010\u001dJ\u000f\u0010&\u001a\u00020\rH\u0016¢\u0006\u0004\b&\u0010\u001dJ\u000f\u0010'\u001a\u00020\rH\u0016¢\u0006\u0004\b'\u0010\u001dJ\u0017\u0010*\u001a\u00020(2\u0006\u0010)\u001a\u00020(H\u0002¢\u0006\u0004\b*\u0010+J\u000f\u0010,\u001a\u00020\tH\u0002¢\u0006\u0004\b,\u0010\u0014J\u0017\u0010/\u001a\u00020\r2\u0006\u0010.\u001a\u00020-H\u0002¢\u0006\u0004\b/\u00100J\u001f\u00102\u001a\u00020\r2\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u00101\u001a\u00020\u0006H\u0002¢\u0006\u0004\b2\u00103J(\u00107\u001a\u00020\r2\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u00104\u001a\u00020\t2\u0006\u00106\u001a\u000205H\u0082@¢\u0006\u0004\b7\u00108J\u001f\u0010:\u001a\u00020\r2\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u00109\u001a\u00020\u0006H\u0002¢\u0006\u0004\b:\u00103J\u0017\u0010=\u001a\u00020\t2\u0006\u0010<\u001a\u00020;H\u0002¢\u0006\u0004\b=\u0010>J2\u0010@\u001a\u00020\r2\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u00109\u001a\u00020\u00062\u0006\u00104\u001a\u00020\t2\b\b\u0002\u0010?\u001a\u00020;H\u0082@¢\u0006\u0004\b@\u0010AJ\u0019\u0010D\u001a\u0004\u0018\u00010C2\u0006\u0010B\u001a\u00020;H\u0002¢\u0006\u0004\bD\u0010EJ\u0019\u0010G\u001a\u0004\u0018\u00010-2\u0006\u0010F\u001a\u00020\u0006H\u0002¢\u0006\u0004\bG\u0010HJ\u0011\u0010J\u001a\u0004\u0018\u00010IH\u0002¢\u0006\u0004\bJ\u0010KJ\u0012\u0010L\u001a\u0004\u0018\u00010-H\u0082@¢\u0006\u0004\bL\u0010MJ3\u0010S\u001a\u00020\r2\"\u0010R\u001a\u001e\b\u0001\u0012\u0004\u0012\u00020O\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0P\u0012\u0006\u0012\u0004\u0018\u00010Q0NH\u0002¢\u0006\u0004\bS\u0010TJ\u000f\u0010U\u001a\u00020\rH\u0002¢\u0006\u0004\bU\u0010\u001dJ\u0011\u0010V\u001a\u0004\u0018\u00010-H\u0002¢\u0006\u0004\bV\u0010WJ\u0017\u0010Y\u001a\u00020\r2\u0006\u0010X\u001a\u00020-H\u0002¢\u0006\u0004\bY\u00100J!\u0010^\u001a\u0004\u0018\u00010;2\u0006\u0010[\u001a\u00020Z2\u0006\u0010]\u001a\u00020\\H\u0002¢\u0006\u0004\b^\u0010_J\u001f\u0010c\u001a\u00020b2\u0006\u0010`\u001a\u00020\\2\u0006\u0010a\u001a\u00020;H\u0002¢\u0006\u0004\bc\u0010dJ\u0017\u0010g\u001a\u00020f2\u0006\u0010e\u001a\u00020bH\u0002¢\u0006\u0004\bg\u0010hR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010iR\u0014\u0010j\u001a\u00020O8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bj\u0010kR\u0018\u0010m\u001a\u0004\u0018\u00010l8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bm\u0010nR\u0014\u0010p\u001a\u00020o8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bp\u0010qR\u0014\u0010s\u001a\u00020r8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bs\u0010tR\u0016\u0010u\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bu\u0010UR\u0018\u0010v\u001a\u0004\u0018\u0001058\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bv\u0010wR\u0016\u0010x\u001a\u00020\t8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bx\u0010yR\u0018\u0010{\u001a\u0004\u0018\u00010z8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b{\u0010|R\u0016\u0010\n\u001a\u00020\t8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\n\u0010yR\u0016\u0010\u000b\u001a\u00020\t8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000b\u0010yR\u0016\u0010\f\u001a\u00020\t8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\f\u0010yR\u0016\u0010}\u001a\u00020\t8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b}\u0010yR\u0016\u0010~\u001a\u00020\t8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b~\u0010yR\u0015\u0010\u007f\u001a\u00020Q8\u0002X\u0082\u0004¢\u0006\u0007\n\u0005\b\u007f\u0010\u0080\u0001R\u001b\u0010\u0081\u0001\u001a\u0004\u0018\u00010-8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0081\u0001\u0010\u0082\u0001R\u0018\u0010\u0084\u0001\u001a\u00030\u0083\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\b\u0084\u0001\u0010\u0085\u0001R\u0016\u0010\u0086\u0001\u001a\u00020r8\u0002X\u0082\u0004¢\u0006\u0007\n\u0005\b\u0086\u0001\u0010tR\u0018\u0010\u0087\u0001\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b\u0087\u0001\u0010UR\u001b\u0010\u0088\u0001\u001a\u0004\u0018\u00010Z8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0088\u0001\u0010\u0089\u0001R\u0018\u0010\u008a\u0001\u001a\u00030\u0083\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\b\u008a\u0001\u0010\u0085\u0001¨\u0006\u008d\u0001"}, d2 = {"Lcom/stepos/ailauncher/speech/asr/AIEngineAsrEngine;", "Lcom/stepos/ailauncher/speech/asr/c;", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "", Const.INTENT_KEY_APIKEY, "(Landroid/content/Context;)Z", "", "silenceTimeoutMs", "listenTimeoutMs", "muteTimeoutMs", "LY8/t;", "setListeningConfig", "(Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;)V", "timeoutMs", "setLongPressTimeoutMs", "(Ljava/lang/Long;)V", "getLongPressTimeoutMs", "()J", "getLongPressRemainingMs", "getRecordingRemainingMs", "Lcom/stepos/ailauncher/contract/api/speech/AsrCallback;", "callback", "startListening", "(Lcom/stepos/ailauncher/contract/api/speech/AsrCallback;)V", Const.INTENT_KEY_PKGNAME, "armStartHapticPcmSkip", "()V", "c", "cancelCapturePrewarm", Const.INTENT_KEY_UMID, "startSlaOnlyListening", x5.d.EXTRA_ENABLED, "setVadEnabled", "(Z)V", "stopAndFinalize", "cancel", "destroy", "", "text", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "(Ljava/lang/String;)Ljava/lang/String;", "F", "Lcom/stepos/ailauncher/speech/asr/MicCapturePrewarm;", "cap", "Y", "(Lcom/stepos/ailauncher/speech/asr/MicCapturePrewarm;)V", "listenVad", "c0", "(Lcom/stepos/ailauncher/contract/api/speech/AsrCallback;Z)V", "sessionId", "Lcom/stepos/ailauncher/speech/asr/h;", "mode", ExifInterface.LATITUDE_SOUTH, "(Lcom/stepos/ailauncher/contract/api/speech/AsrCallback;JLcom/stepos/ailauncher/speech/asr/h;Le9/c;)Ljava/lang/Object;", "manual", "b0", "", "attempt", "B", "(I)J", "engineOpenAttempt", "H", "(Lcom/stepos/ailauncher/contract/api/speech/AsrCallback;ZJILe9/c;)Ljava/lang/Object;", "bufferSize", "Lcom/stepos/ailauncher/speech/asr/AIEngineAsrEngine$b;", "G", "(I)Lcom/stepos/ailauncher/speech/asr/AIEngineAsrEngine$b;", "forceFgs", "a0", "(Z)Lcom/stepos/ailauncher/speech/asr/MicCapturePrewarm;", "Landroid/media/AudioDeviceInfo;", "C", "()Landroid/media/AudioDeviceInfo;", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "(Le9/c;)Ljava/lang/Object;", "Lkotlin/Function2;", "LUa/M;", "Le9/c;", "", "block", "U", "(Lp9/p;)V", "Z", "d0", "()Lcom/stepos/ailauncher/speech/asr/MicCapturePrewarm;", "capture", "X", "Landroid/media/AudioRecord;", com.stepos.ailauncher.chat.trace.h.OCCUPIED_RECORDER, "", "buffer", ExifInterface.LONGITUDE_WEST, "(Landroid/media/AudioRecord;[B)Ljava/lang/Integer;", SingleFileBundle.KEY_BYTES, "length", "", "D", "([BI)[S", "data", "", ExifInterface.LONGITUDE_EAST, "([S)D", "Landroid/content/Context;", "scope", "LUa/M;", "Lkotlinx/coroutines/g;", "recordJob", "Lkotlinx/coroutines/g;", "Ljava/util/concurrent/atomic/AtomicLong;", "sessionGeneration", "Ljava/util/concurrent/atomic/AtomicLong;", "Ljava/util/concurrent/atomic/AtomicBoolean;", "isRecording", "Ljava/util/concurrent/atomic/AtomicBoolean;", "isManualMode", "slaOnlyRecordingMode", "Lcom/stepos/ailauncher/speech/asr/h;", "startHapticSkipUntilMs", "J", "Lcom/stepos/ailauncher/speech/asr/AIEngineAsrEngine$a;", "activeSession", "Lcom/stepos/ailauncher/speech/asr/AIEngineAsrEngine$a;", "longPressTimeoutMs", "activeRecordStartMs", "captureLock", "Ljava/lang/Object;", "liveCapture", "Lcom/stepos/ailauncher/speech/asr/MicCapturePrewarm;", "Ljava/util/concurrent/atomic/AtomicInteger;", "captureEpoch", "Ljava/util/concurrent/atomic/AtomicInteger;", "prewarmInFlight", "skipLiveCaptureAdopt", "retiredRecorder", "Landroid/media/AudioRecord;", "recordLaunchId", "Companion", "AiEngineNotReadyRetryException", "speech_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class AIEngineAsrEngine implements c {
    private static final long AI_ENGINE_NOT_READY_BASE_DELAY_MS = 300;
    private static final int AI_ENGINE_NOT_READY_MAX_ATTEMPTS = 10;
    private static final long AI_ENGINE_NOT_READY_MAX_DELAY_MS = 1500;
    private static final int CAPTURE_PROFILE_FRAMES_PER_BUCKET = 8;
    private static final int CAPTURE_PROFILE_MAX_BUCKETS = 60;
    private static final int CHANNEL = 16;
    private static final int CHANNEL_MAX_DURATION_MS = 180000;
    private static final int CHUNK_SIZE = 4096;
    private static final long DEFAULT_HEARING_MUTE_TIMEOUT_MS = 10000;
    private static final long DEFAULT_HEARING_VAD_SILENCE_MS = 2000;
    private static final long DEFAULT_LISTEN_TIMEOUT_MS = 60000;
    private static final int ENCODING = 2;
    private static final int ERR_AI_ENGINE_PERMISSION_DENIED = 100005;
    private static final int ERR_ASR_NO_SPEECH = 20004;
    private static final int HEARING_VAD_LEADING_SILENCE_TIMEOUT_MS = 10000;
    private static final float HEARING_VAD_MIN_SPEECH_RMS = 0.01f;
    private static final int HEARING_VAD_SILENCE_DURATION_MS = 2000;
    private static final int HEARING_VAD_SPEECH_START_MS = 32;
    private static final float HEARING_VAD_THRESHOLD = 0.7f;
    private static final int MANUAL_FEED_SPEECH_FRAMES = 2;
    private static final float MANUAL_FEED_SPEECH_RMS = 320.0f;
    private static final int MIC_PREWARM_RING_FRAMES = 24;
    private static final String PARAM_STREAM_MAX_DURATION_MS = "asr.sse.stream.max_duration_ms";
    private static final String PARAM_VAD_ENABLED = "vad.enabled";
    private static final String PARAM_VAD_LEADING_SILENCE_TIMEOUT_MS = "vad.leading_silence_timeout_ms";
    private static final String PARAM_VAD_MIN_SPEECH_RMS = "vad.min_speech_rms";
    private static final String PARAM_VAD_SILENCE_DURATION_MS = "vad.silence_duration_ms";
    private static final String PARAM_VAD_SPEECH_START_MS = "vad.speech_start_ms";
    private static final String PARAM_VAD_THRESHOLD = "vad.threshold";
    private static final long RECORD_HANDOFF_JOIN_MS = 400;
    private static final int SAMPLE_RATE = 16000;
    private static final int SDK_VAD_SILENCE_MS_MAX = 5000;
    private static final int SDK_VAD_SILENCE_MS_MIN = 16;
    private static final int SHORT_FINAL_ASR_MAX_LEN = 6;
    private static final long SLA_LISTEN_MAX_UTTERANCE_MS = 5000;
    private static final float SLA_LISTEN_SILENCE_PEAK_RATIO = 0.18f;
    private static final float SLA_LISTEN_SILENCE_RMS = 250.0f;
    private static final long SLA_LISTEN_TRAILING_SILENCE_MS = 700;
    private static final int SPEECH_LOG_RMS = 80;
    private static final String TAG = "AIEngineAsr";
    private static final int WARN_LISTEN_TIMEOUT = 1002;
    private static final int WARN_LONG_PRESS_TIMEOUT = 1003;
    private volatile long activeRecordStartMs;
    private volatile ActiveSession activeSession;
    private final AtomicInteger captureEpoch;
    private final Object captureLock;
    private final Context context;
    private volatile boolean isManualMode;
    private final AtomicBoolean isRecording;
    private volatile long listenTimeoutMs;
    private volatile MicCapturePrewarm liveCapture;
    private volatile long longPressTimeoutMs;
    private volatile long muteTimeoutMs;
    private final AtomicBoolean prewarmInFlight;
    private kotlinx.coroutines.g recordJob;
    private final AtomicInteger recordLaunchId;
    private volatile AudioRecord retiredRecorder;
    private final M scope;
    private final AtomicLong sessionGeneration;
    private volatile long silenceTimeoutMs;
    private volatile boolean skipLiveCaptureAdopt;
    private volatile h slaOnlyRecordingMode;
    private volatile long startHapticSkipUntilMs;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0007\b\u0002\u0018\u00002\u00060\u0001j\u0002`\u0002B\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006R\u0017\u0010\u0004\u001a\u00020\u00038\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0007\u001a\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lcom/stepos/ailauncher/speech/asr/AIEngineAsrEngine$AiEngineNotReadyRetryException;", "Ljava/lang/Exception;", "Lkotlin/Exception;", "", "attempt", "<init>", "(I)V", "I", Const.INTENT_KEY_APIKEY, "()I", "speech_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class AiEngineNotReadyRetryException extends Exception {
        private final int attempt;

        public AiEngineNotReadyRetryException(int i10) {
            this.attempt = i10;
        }

        /* renamed from: a, reason: from getter */
        public final int getAttempt() {
            return this.attempt;
        }
    }

    @Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0011\b\u0082\b\u0018\u00002\u00020\u0001B1\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\t\u001a\u00020\b\u0012\u0006\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000e\u001a\u00020\nHÖ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0011\u001a\u00020\u0010HÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0012J\u001a\u0010\u0015\u001a\u00020\u00142\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0015\u0010\u0016R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u001a\u001a\u0004\b\u001b\u0010\u001cR\u0019\u0010\u0007\u001a\u0004\u0018\u00010\u00068\u0006¢\u0006\f\n\u0004\b\u0007\u0010\u001d\u001a\u0004\b\u001e\u0010\u001fR\u0017\u0010\t\u001a\u00020\b8\u0006¢\u0006\f\n\u0004\b\t\u0010 \u001a\u0004\b!\u0010\"R\u0017\u0010\u000b\u001a\u00020\n8\u0006¢\u0006\f\n\u0004\b\u000b\u0010#\u001a\u0004\b$\u0010\u000f¨\u0006%"}, d2 = {"Lcom/stepos/ailauncher/speech/asr/AIEngineAsrEngine$a;", "", "", "id", "Landroid/media/AudioRecord;", com.stepos.ailauncher.chat.trace.h.OCCUPIED_RECORDER, "Lcom/stepos/aiengine/algorithm/asr/IAsrSseStreamRecognizer;", "recognizer", "Lcom/stepos/ailauncher/contract/api/speech/AsrCallback;", "callback", "", "voiceTraceId", "<init>", "(JLandroid/media/AudioRecord;Lcom/stepos/aiengine/algorithm/asr/IAsrSseStreamRecognizer;Lcom/stepos/ailauncher/contract/api/speech/AsrCallback;Ljava/lang/String;)V", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "J", Const.INTENT_KEY_PKGNAME, "()J", "Landroid/media/AudioRecord;", Const.INTENT_KEY_UMID, "()Landroid/media/AudioRecord;", "Lcom/stepos/aiengine/algorithm/asr/IAsrSseStreamRecognizer;", "c", "()Lcom/stepos/aiengine/algorithm/asr/IAsrSseStreamRecognizer;", "Lcom/stepos/ailauncher/contract/api/speech/AsrCallback;", Const.INTENT_KEY_APIKEY, "()Lcom/stepos/ailauncher/contract/api/speech/AsrCallback;", "Ljava/lang/String;", "e", "speech_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.ailauncher.speech.asr.AIEngineAsrEngine$a, reason: from toString */
    public static final /* data */ class ActiveSession {
        private final AsrCallback callback;
        private final long id;
        private final IAsrSseStreamRecognizer recognizer;
        private final AudioRecord recorder;
        private final String voiceTraceId;

        public ActiveSession(long j10, AudioRecord recorder, IAsrSseStreamRecognizer iAsrSseStreamRecognizer, AsrCallback callback, String voiceTraceId) {
            p.i(recorder, "recorder");
            p.i(callback, "callback");
            p.i(voiceTraceId, "voiceTraceId");
            this.id = j10;
            this.recorder = recorder;
            this.recognizer = iAsrSseStreamRecognizer;
            this.callback = callback;
            this.voiceTraceId = voiceTraceId;
        }

        /* renamed from: a, reason: from getter */
        public final AsrCallback getCallback() {
            return this.callback;
        }

        /* renamed from: b, reason: from getter */
        public final long getId() {
            return this.id;
        }

        /* renamed from: c, reason: from getter */
        public final IAsrSseStreamRecognizer getRecognizer() {
            return this.recognizer;
        }

        /* renamed from: d, reason: from getter */
        public final AudioRecord getRecorder() {
            return this.recorder;
        }

        /* renamed from: e, reason: from getter */
        public final String getVoiceTraceId() {
            return this.voiceTraceId;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ActiveSession)) {
                return false;
            }
            ActiveSession activeSession = (ActiveSession) other;
            return this.id == activeSession.id && p.d(this.recorder, activeSession.recorder) && p.d(this.recognizer, activeSession.recognizer) && p.d(this.callback, activeSession.callback) && p.d(this.voiceTraceId, activeSession.voiceTraceId);
        }

        public int hashCode() {
            int iHashCode = ((Long.hashCode(this.id) * 31) + this.recorder.hashCode()) * 31;
            IAsrSseStreamRecognizer iAsrSseStreamRecognizer = this.recognizer;
            return ((((iHashCode + (iAsrSseStreamRecognizer == null ? 0 : iAsrSseStreamRecognizer.hashCode())) * 31) + this.callback.hashCode()) * 31) + this.voiceTraceId.hashCode();
        }

        public String toString() {
            return "ActiveSession(id=" + this.id + ", recorder=" + this.recorder + ", recognizer=" + this.recognizer + ", callback=" + this.callback + ", voiceTraceId=" + this.voiceTraceId + ")";
        }
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\b\b\u0082\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u000b\u001a\u00020\u0004HÖ\u0001¢\u0006\u0004\b\u000b\u0010\fJ\u001a\u0010\u000f\u001a\u00020\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u000f\u0010\u0010R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0014\u001a\u0004\b\u0015\u0010\f¨\u0006\u0016"}, d2 = {"Lcom/stepos/ailauncher/speech/asr/AIEngineAsrEngine$b;", "", "Landroid/media/AudioRecord;", com.stepos.ailauncher.chat.trace.h.OCCUPIED_RECORDER, "", "audioSource", "<init>", "(Landroid/media/AudioRecord;I)V", "", "toString", "()Ljava/lang/String;", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Landroid/media/AudioRecord;", Const.INTENT_KEY_PKGNAME, "()Landroid/media/AudioRecord;", "I", Const.INTENT_KEY_APIKEY, "speech_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.ailauncher.speech.asr.AIEngineAsrEngine$b, reason: from toString */
    public static final /* data */ class AsrRecorderHandle {
        private final int audioSource;
        private final AudioRecord recorder;

        public AsrRecorderHandle(AudioRecord recorder, int i10) {
            p.i(recorder, "recorder");
            this.recorder = recorder;
            this.audioSource = i10;
        }

        /* renamed from: a, reason: from getter */
        public final int getAudioSource() {
            return this.audioSource;
        }

        /* renamed from: b, reason: from getter */
        public final AudioRecord getRecorder() {
            return this.recorder;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof AsrRecorderHandle)) {
                return false;
            }
            AsrRecorderHandle asrRecorderHandle = (AsrRecorderHandle) other;
            return p.d(this.recorder, asrRecorderHandle.recorder) && this.audioSource == asrRecorderHandle.audioSource;
        }

        public int hashCode() {
            return (this.recorder.hashCode() * 31) + Integer.hashCode(this.audioSource);
        }

        public String toString() {
            return "AsrRecorderHandle(recorder=" + this.recorder + ", audioSource=" + this.audioSource + ")";
        }
    }

    public AIEngineAsrEngine(Context context) {
        p.i(context, "context");
        this.context = context;
        this.scope = kotlinx.coroutines.d.a(L0.b(null, 1, null).plus(Y.b()));
        this.sessionGeneration = new AtomicLong(0L);
        this.isRecording = new AtomicBoolean(false);
        this.silenceTimeoutMs = 2000L;
        this.listenTimeoutMs = 60000L;
        this.muteTimeoutMs = 10000L;
        this.longPressTimeoutMs = 180000L;
        this.captureLock = new Object();
        this.captureEpoch = new AtomicInteger(0);
        this.prewarmInFlight = new AtomicBoolean(false);
        this.recordLaunchId = new AtomicInteger(0);
    }

    /* JADX WARN: Removed duplicated region for block: B:44:0x01f1  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final double I(java.util.concurrent.atomic.AtomicLong r20, java.util.concurrent.atomic.AtomicLong r21, java.util.concurrent.atomic.AtomicLong r22, long r23, com.stepos.ailauncher.speech.asr.MicCapturePrewarm.Drain r25, com.stepos.ailauncher.speech.asr.AIEngineAsrEngine r26, kotlin.jvm.internal.Ref$DoubleRef r27, kotlin.jvm.internal.Ref$DoubleRef r28, kotlin.jvm.internal.Ref$IntRef r29, java.util.ArrayList<java.lang.Integer> r30, com.stepos.ailauncher.speech.asr.g r31, java.util.concurrent.atomic.AtomicBoolean r32, com.stepos.aiengine.algorithm.asr.IAsrSseStreamRecognizer r33, kotlin.jvm.internal.Ref$DoubleRef r34, com.stepos.ailauncher.speech.asr.d r35, java.io.ByteArrayOutputStream r36, kotlin.jvm.internal.Ref$IntRef r37, java.util.concurrent.atomic.AtomicLong r38, java.util.concurrent.atomic.AtomicLong r39, com.stepos.ailauncher.contract.api.speech.AsrCallback r40, byte[] r41) {
        /*
            Method dump skipped, instructions count: 533
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.ailauncher.speech.asr.AIEngineAsrEngine.I(java.util.concurrent.atomic.AtomicLong, java.util.concurrent.atomic.AtomicLong, java.util.concurrent.atomic.AtomicLong, long, com.stepos.ailauncher.speech.asr.MicCapturePrewarm$b, com.stepos.ailauncher.speech.asr.AIEngineAsrEngine, kotlin.jvm.internal.Ref$DoubleRef, kotlin.jvm.internal.Ref$DoubleRef, kotlin.jvm.internal.Ref$IntRef, java.util.ArrayList, com.stepos.ailauncher.speech.asr.g, java.util.concurrent.atomic.AtomicBoolean, com.stepos.aiengine.algorithm.asr.IAsrSseStreamRecognizer, kotlin.jvm.internal.Ref$DoubleRef, com.stepos.ailauncher.speech.asr.d, java.io.ByteArrayOutputStream, kotlin.jvm.internal.Ref$IntRef, java.util.concurrent.atomic.AtomicLong, java.util.concurrent.atomic.AtomicLong, com.stepos.ailauncher.contract.api.speech.AsrCallback, byte[]):double");
    }

    public static final long J(long j10, long j11) {
        return C5685n.g(j11 - j10, 0L);
    }

    public static final void K(StringBuilder sb2, StringBuilder sb3) {
        if (sb2.length() > 0) {
            String string = sb2.toString();
            p.h(string, "toString(...)");
            a.a(sb3, string);
            z.q(sb2);
        }
    }

    public static final boolean L(long j10, AIEngineAsrEngine aIEngineAsrEngine) {
        return j10 == aIEngineAsrEngine.sessionGeneration.get();
    }

    public static final void M(AtomicLong atomicLong, AtomicLong atomicLong2, AtomicLong atomicLong3, AtomicLong atomicLong4, AtomicLong atomicLong5, AtomicLong atomicLong6, long j10, long j11, boolean z10, AIEngineAsrEngine aIEngineAsrEngine, String str, AtomicLong atomicLong7, String str2, int i10, long j12) {
        if (atomicLong7.compareAndSet(0L, j12)) {
            long j13 = atomicLong.get();
            long j14 = atomicLong2.get();
            long j15 = atomicLong3.get();
            long j16 = atomicLong4.get();
            long j17 = atomicLong5.get();
            long j18 = atomicLong6.get();
            C4148a.k(TAG, "ASR latency " + str + "(" + str2 + "): deltaLen=" + i10 + " sinceLoadStart=" + Q(j10, j12) + "ms sinceOpen=" + Q(j13, j12) + "ms sinceRouting=" + Q(j14, j12) + "ms sinceFirstPcm=" + Q(j15, j12) + "ms sinceFirstSpeech=" + Q(j16, j12) + "ms sinceLastAudio=" + Q(j17, j12) + "ms sinceFirstEmpty=" + Q(j18, j12) + "ms routingSinceOpenReq=" + Q(j11, j14) + "ms firstPcmSinceOpen=" + Q(j13, j15) + "ms manual=" + z10 + " manualMode=" + aIEngineAsrEngine.isManualMode, false, 4, null);
        }
    }

    public static final boolean O(AIEngineAsrEngine aIEngineAsrEngine, AtomicLong atomicLong, AtomicLong atomicLong2, AtomicBoolean atomicBoolean, String str, long j10) {
        if (aIEngineAsrEngine.isManualMode) {
            return false;
        }
        long j11 = atomicLong.get();
        if (j11 <= 0 || J(j11, j10) >= aIEngineAsrEngine.muteTimeoutMs || atomicLong2.get() > 0) {
            return false;
        }
        C4148a.k(TAG, str + " deferred: initialSilence elapsed=" + J(j11, j10) + "ms mute=" + aIEngineAsrEngine.muteTimeoutMs + "ms hasAsrText=" + atomicBoolean.get(), false, 4, null);
        return true;
    }

    public static /* synthetic */ boolean P(AIEngineAsrEngine aIEngineAsrEngine, AtomicLong atomicLong, AtomicLong atomicLong2, AtomicBoolean atomicBoolean, String str, long j10, int i10, Object obj) {
        if ((i10 & 32) != 0) {
            j10 = System.currentTimeMillis();
        }
        return O(aIEngineAsrEngine, atomicLong, atomicLong2, atomicBoolean, str, j10);
    }

    public static final long Q(long j10, long j11) {
        if (j10 <= 0 || j11 <= 0) {
            return -1L;
        }
        return j11 - j10;
    }

    public static final boolean R(long j10, AIEngineAsrEngine aIEngineAsrEngine, String str) {
        if (L(j10, aIEngineAsrEngine)) {
            return false;
        }
        C4148a.u(TAG, "skip stale " + str + ": id=" + j10 + " current=" + aIEngineAsrEngine.sessionGeneration.get(), false, 4, null);
        return true;
    }

    public static final boolean T(long j10, AIEngineAsrEngine aIEngineAsrEngine) {
        return j10 == aIEngineAsrEngine.sessionGeneration.get();
    }

    /* JADX WARN: Removed duplicated region for block: B:56:0x0097 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:58:0x0099  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object A(e9.InterfaceC4014c<? super com.stepos.ailauncher.speech.asr.MicCapturePrewarm> r9) throws java.lang.Throwable {
        /*
            r8 = this;
            boolean r0 = r9 instanceof com.stepos.ailauncher.speech.asr.AIEngineAsrEngine$adoptOrStartCapture$1
            if (r0 == 0) goto L13
            r0 = r9
            com.stepos.ailauncher.speech.asr.AIEngineAsrEngine$adoptOrStartCapture$1 r0 = (com.stepos.ailauncher.speech.asr.AIEngineAsrEngine$adoptOrStartCapture$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.stepos.ailauncher.speech.asr.AIEngineAsrEngine$adoptOrStartCapture$1 r0 = new com.stepos.ailauncher.speech.asr.AIEngineAsrEngine$adoptOrStartCapture$1
            r0.<init>(r8, r9)
        L18:
            java.lang.Object r9 = r0.result
            java.lang.Object r1 = f9.C4063a.g()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L33
            if (r2 != r3) goto L2b
            long r4 = r0.J$0
            kotlin.C4849c.b(r9)
            goto L55
        L2b:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r9)
            throw r8
        L33:
            kotlin.C4849c.b(r9)
            boolean r9 = r8.skipLiveCaptureAdopt
            if (r9 != 0) goto L91
            java.lang.Object r9 = r8.captureLock
            monitor-enter(r9)
            com.stepos.ailauncher.speech.asr.MicCapturePrewarm r2 = r8.d0()     // Catch: java.lang.Throwable -> L8e
            if (r2 == 0) goto L45
            monitor-exit(r9)
            return r2
        L45:
            monitor-exit(r9)
            java.util.concurrent.atomic.AtomicBoolean r9 = r8.prewarmInFlight
            boolean r9 = r9.get()
            if (r9 == 0) goto L91
            long r4 = java.lang.System.currentTimeMillis()
            r6 = 400(0x190, double:1.976E-321)
            long r4 = r4 + r6
        L55:
            long r6 = java.lang.System.currentTimeMillis()
            int r9 = (r6 > r4 ? 1 : (r6 == r4 ? 0 : -1))
            if (r9 >= 0) goto L80
            java.lang.Object r9 = r8.captureLock
            monitor-enter(r9)
            com.stepos.ailauncher.speech.asr.MicCapturePrewarm r2 = r8.d0()     // Catch: java.lang.Throwable -> L7d
            monitor-exit(r9)
            if (r2 == 0) goto L68
            return r2
        L68:
            java.util.concurrent.atomic.AtomicBoolean r9 = r8.prewarmInFlight
            boolean r9 = r9.get()
            if (r9 == 0) goto L80
            r0.J$0 = r4
            r0.label = r3
            r6 = 20
            java.lang.Object r9 = Ua.U.a(r6, r0)
            if (r9 != r1) goto L55
            return r1
        L7d:
            r8 = move-exception
            monitor-exit(r9)
            throw r8
        L80:
            java.lang.Object r9 = r8.captureLock
            monitor-enter(r9)
            com.stepos.ailauncher.speech.asr.MicCapturePrewarm r0 = r8.d0()     // Catch: java.lang.Throwable -> L8b
            monitor-exit(r9)
            if (r0 == 0) goto L91
            return r0
        L8b:
            r8 = move-exception
            monitor-exit(r9)
            throw r8
        L8e:
            r8 = move-exception
            monitor-exit(r9)
            throw r8
        L91:
            com.stepos.ailauncher.speech.asr.MicCapturePrewarm r9 = r8.a0(r3)
            if (r9 != 0) goto L99
            r8 = 0
            return r8
        L99:
            java.lang.Object r0 = r8.captureLock
            monitor-enter(r0)
            boolean r1 = r8.skipLiveCaptureAdopt     // Catch: java.lang.Throwable -> Lab
            if (r1 != 0) goto Lad
            com.stepos.ailauncher.speech.asr.MicCapturePrewarm r1 = r8.d0()     // Catch: java.lang.Throwable -> Lab
            if (r1 == 0) goto Lad
            r9.m()     // Catch: java.lang.Throwable -> Lab
            monitor-exit(r0)
            return r1
        Lab:
            r8 = move-exception
            goto Lb1
        Lad:
            r8.liveCapture = r9     // Catch: java.lang.Throwable -> Lab
            monitor-exit(r0)
            return r9
        Lb1:
            monitor-exit(r0)
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.ailauncher.speech.asr.AIEngineAsrEngine.A(e9.c):java.lang.Object");
    }

    public final long B(int attempt) {
        return C5685n.k(attempt * 300, 1500L);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final AudioDeviceInfo C() {
        AudioManager audioManager = (AudioManager) this.context.getSystemService(AudioManager.class);
        AudioDeviceInfo audioDeviceInfo = null;
        if (audioManager == null) {
            return null;
        }
        AudioDeviceInfo[] devices = audioManager.getDevices(1);
        p.h(devices, "getDevices(...)");
        ArrayList<AudioDeviceInfo> arrayList = new ArrayList();
        for (AudioDeviceInfo audioDeviceInfo2 : devices) {
            if (audioDeviceInfo2.isSource()) {
                arrayList.add(audioDeviceInfo2);
            }
        }
        if (!arrayList.isEmpty()) {
            for (AudioDeviceInfo audioDeviceInfo3 : arrayList) {
                if (audioDeviceInfo3.getType() == 22 || audioDeviceInfo3.getType() == 11 || audioDeviceInfo3.getType() == 3) {
                    ArrayList arrayList2 = new ArrayList();
                    for (Object obj : arrayList) {
                        if (((AudioDeviceInfo) obj).getType() == 15) {
                            arrayList2.add(obj);
                        }
                    }
                    Iterator it = arrayList2.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        Object next = it.next();
                        if (p.d(((AudioDeviceInfo) next).getAddress(), "bottom")) {
                            audioDeviceInfo = next;
                            break;
                        }
                    }
                    audioDeviceInfo = audioDeviceInfo;
                    if (audioDeviceInfo == null) {
                        return (AudioDeviceInfo) F.s0(arrayList2);
                    }
                }
            }
        }
        return audioDeviceInfo;
    }

    public final short[] D(byte[] bytes, int length) {
        short[] sArr = new short[length / 2];
        ByteBuffer.wrap(bytes, 0, length).order(ByteOrder.LITTLE_ENDIAN).asShortBuffer().get(sArr);
        return sArr;
    }

    public final double E(short[] data) {
        double d10 = 0.0d;
        if (data.length == 0) {
            return 0.0d;
        }
        for (double d11 : data) {
            d10 += d11 * d11;
        }
        return Math.sqrt(d10 / data.length);
    }

    public final long F() {
        long j10 = this.startHapticSkipUntilMs;
        this.startHapticSkipUntilMs = 0L;
        return j10;
    }

    public final AsrRecorderHandle G(int bufferSize) {
        int[] iArrF = MicOccupancyMonitor.INSTANCE.F();
        int length = iArrF.length;
        int i10 = 0;
        while (i10 < length) {
            int i11 = iArrF[i10];
            int i12 = bufferSize;
            AudioRecord audioRecord = new AudioRecord(i11, 16000, 16, 2, i12);
            if (audioRecord.getState() == 1) {
                C4148a.k(TAG, "createAsrAudioRecord: source=" + i11 + " bufferSize=" + i12 + " session=" + audioRecord.getAudioSessionId(), false, 4, null);
                MicOccupancyMonitor.INSTANCE.E(audioRecord.getAudioSessionId());
                return new AsrRecorderHandle(audioRecord, i11);
            }
            C4148a.u(TAG, "createAsrAudioRecord: source=" + i11 + " init failed, try next", false, 4, null);
            audioRecord.release();
            i10++;
            bufferSize = i12;
        }
        return null;
    }

    /* JADX WARN: Code restructure failed: missing block: B:182:0x09f9, code lost:
    
        r12 = r14.f34816a;
        r14 = new java.lang.StringBuilder();
     */
    /* JADX WARN: Code restructure failed: missing block: B:183:0x0a02, code lost:
    
        r24 = r24;
     */
    /* JADX WARN: Code restructure failed: missing block: B:184:0x0a04, code lost:
    
        r14.append("AIOSBUG-19024: trailing silence 700ms (rms=");
        r14.append(r1);
        r14.append(" thr=");
        r14.append(r10);
        r14.append(" peak=");
        r14.append(r12);
        r14.append("), stop");
     */
    /* JADX WARN: Code restructure failed: missing block: B:185:0x0a25, code lost:
    
        r10 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:186:0x0a28, code lost:
    
        h8.C4148a.k(com.stepos.ailauncher.speech.asr.AIEngineAsrEngine.TAG, r14.toString(), false, 4, null);
     */
    /* JADX WARN: Code restructure failed: missing block: B:190:0x0a4a, code lost:
    
        r0 = th;
     */
    /* JADX WARN: Code restructure failed: missing block: B:216:0x0a9c, code lost:
    
        h8.C4148a.k(com.stepos.ailauncher.speech.asr.AIEngineAsrEngine.TAG, "muteTimeout " + r9.muteTimeoutMs + "ms reached (no ASR text, vad no speech), stop", r10, 4, null);
     */
    /* JADX WARN: Code restructure failed: missing block: B:217:0x0abb, code lost:
    
        r1 = r10;
        r2 = r1;
        r5 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:239:0x0b5c, code lost:
    
        r24 = r5;
        r30 = r6;
        r3 = r8;
        r6 = r10;
        r86 = r16;
        r8 = r17;
        r4 = r20;
        r10 = false;
        r17 = r13;
     */
    /* JADX WARN: Code restructure failed: missing block: B:240:0x0b6c, code lost:
    
        r61 = r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:243:0x0b73, code lost:
    
        r1 = r10;
        r2 = r1;
        r5 = r2;
     */
    /* JADX WARN: Removed duplicated region for block: B:115:0x070b  */
    /* JADX WARN: Removed duplicated region for block: B:117:0x0715  */
    /* JADX WARN: Removed duplicated region for block: B:134:0x089e  */
    /* JADX WARN: Removed duplicated region for block: B:206:0x0a7d A[Catch: all -> 0x0a2d, TryCatch #5 {all -> 0x0a2d, blocks: (B:204:0x0a79, B:206:0x0a7d, B:209:0x0a8a, B:211:0x0a90, B:213:0x0a96, B:221:0x0adf, B:186:0x0a28), top: B:527:0x0a79 }] */
    /* JADX WARN: Removed duplicated region for block: B:220:0x0add  */
    /* JADX WARN: Removed duplicated region for block: B:525:0x04da A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:533:0x10e9 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:535:0x077e A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:555:0x0b79 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:576:0x0b5c A[EDGE_INSN: B:576:0x0b5c->B:239:0x0b5c BREAK  A[LOOP:1: B:569:0x0894->B:586:0x0894], SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:67:0x04cd  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x04d1  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x051c  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0018  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object H(com.stepos.ailauncher.contract.api.speech.AsrCallback r82, boolean r83, long r84, int r86, e9.InterfaceC4014c<? super Y8.t> r87) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 5411
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.ailauncher.speech.asr.AIEngineAsrEngine.H(com.stepos.ailauncher.contract.api.speech.AsrCallback, boolean, long, int, e9.c):java.lang.Object");
    }

    /* JADX WARN: Can't wrap try/catch for region: R(23:61|62|(6:381|64|(4:66|(1:68)|69|(2:385|85)(11:387|73|74|376|75|76|364|77|78|390|388))(1:383)|86|389|388)(1:386)|268|6be|277|(1:281)|(1:283)(1:284)|(12:286|(1:288)|(1:292)(1:293)|294|(1:300)|(2:336|302)(1:(1:310))|370|311|334|315|(1:320)|(3:(1:326)(1:327)|328|329)(2:324|406))(1:290)|289|(0)(0)|294|(2:296|300)|(0)(0)|370|311|334|315|(0)|(0)|(0)(0)|328|329) */
    /* JADX WARN: Code restructure failed: missing block: B:313:0x0752, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:314:0x0753, code lost:
    
        r4 = kotlin.Result.INSTANCE;
        kotlin.Result.b(kotlin.C4849c.a(r0));
     */
    /* JADX WARN: Code restructure failed: missing block: B:317:0x0765, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:318:0x0766, code lost:
    
        r4 = kotlin.Result.INSTANCE;
        kotlin.Result.b(kotlin.C4849c.a(r0));
     */
    /* JADX WARN: Removed duplicated region for block: B:292:0x06ff  */
    /* JADX WARN: Removed duplicated region for block: B:293:0x0701  */
    /* JADX WARN: Removed duplicated region for block: B:306:0x0738  */
    /* JADX WARN: Removed duplicated region for block: B:320:0x0771  */
    /* JADX WARN: Removed duplicated region for block: B:326:0x0795  */
    /* JADX WARN: Removed duplicated region for block: B:327:0x07ab  */
    /* JADX WARN: Removed duplicated region for block: B:336:0x0714 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:344:0x056a A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:362:0x06bf A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:366:0x02c5 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:381:0x0219 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:386:0x02b0 A[EDGE_INSN: B:386:0x02b0->B:87:0x02b0 BREAK  A[LOOP:0: B:61:0x0211->B:388:0x0211], SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0017  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object S(com.stepos.ailauncher.contract.api.speech.AsrCallback r43, long r44, com.stepos.ailauncher.speech.asr.h r46, e9.InterfaceC4014c<? super Y8.t> r47) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 1999
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.ailauncher.speech.asr.AIEngineAsrEngine.S(com.stepos.ailauncher.contract.api.speech.AsrCallback, long, com.stepos.ailauncher.speech.asr.h, e9.c):java.lang.Object");
    }

    public final void U(p9.p<? super M, ? super InterfaceC4014c<? super t>, ? extends Object> block) {
        kotlinx.coroutines.g gVar = this.recordJob;
        boolean z10 = (gVar == null || gVar.g()) ? false : true;
        int iIncrementAndGet = this.recordLaunchId.incrementAndGet();
        if (z10) {
            this.skipLiveCaptureAdopt = true;
            Z();
        }
        this.recordJob = C1060i.d(this.scope, null, null, new AIEngineAsrEngine$launchRecordSession$1(z10, gVar, block, this, iIncrementAndGet, null), 3, null);
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x004a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.String V(java.lang.String r6) {
        /*
            r5 = this;
            java.lang.CharSequence r5 = La.H.D1(r6)
            java.lang.String r5 = r5.toString()
            int r0 = r5.length()
            r1 = 6
            if (r0 <= r1) goto L10
            goto L49
        L10:
            int r0 = r5.length()
            int r0 = r0 + (-1)
            r1 = 1
            if (r0 < 0) goto L3d
        L19:
            int r2 = r0 + (-1)
            char r3 = r5.charAt(r0)
            r4 = 12290(0x3002, float:1.7222E-41)
            if (r3 == r4) goto L38
            r4 = 46
            if (r3 == r4) goto L38
            r4 = 44
            if (r3 == r4) goto L38
            r4 = 65292(0xff0c, float:9.1494E-41)
            if (r3 != r4) goto L31
            goto L38
        L31:
            r2 = 0
            int r0 = r0 + r1
            java.lang.CharSequence r0 = r5.subSequence(r2, r0)
            goto L3f
        L38:
            if (r2 >= 0) goto L3b
            goto L3d
        L3b:
            r0 = r2
            goto L19
        L3d:
            java.lang.String r0 = ""
        L3f:
            java.lang.String r0 = r0.toString()
            boolean r5 = kotlin.jvm.internal.p.d(r0, r5)
            if (r5 == 0) goto L4a
        L49:
            return r6
        L4a:
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            java.lang.String r2 = "normalize short final ASR: \""
            r5.append(r2)
            r5.append(r6)
            java.lang.String r6 = "\" -> \""
            r5.append(r6)
            r5.append(r0)
            java.lang.String r6 = "\""
            r5.append(r6)
            java.lang.String r5 = r5.toString()
            java.lang.String r6 = "AIEngineAsr"
            h8.C4148a.j(r6, r5, r1)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.ailauncher.speech.asr.AIEngineAsrEngine.V(java.lang.String):java.lang.String");
    }

    public final Integer W(AudioRecord recorder, byte[] buffer) {
        Object objB;
        if (recorder.getRecordingState() != 3) {
            return null;
        }
        try {
            Result.Companion companion = Result.INSTANCE;
            objB = Result.b(Integer.valueOf(recorder.read(buffer, 0, buffer.length)));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objB = Result.b(C4849c.a(th));
        }
        if (Result.g(objB)) {
            objB = -1;
        }
        int iIntValue = ((Number) objB).intValue();
        if (iIntValue < 0) {
            return null;
        }
        return Integer.valueOf(iIntValue);
    }

    public final void X(MicCapturePrewarm capture) throws InterruptedException {
        synchronized (this.captureLock) {
            try {
                if (this.liveCapture == capture) {
                    this.liveCapture = null;
                }
                t tVar = t.f7040a;
            } catch (Throwable th) {
                throw th;
            }
        }
        capture.m();
    }

    public final void Y(MicCapturePrewarm cap) {
        boolean z10;
        try {
            cap.m();
            if (z10) {
                return;
            }
        } finally {
            if (!this.isRecording.get() && this.liveCapture == null && this.activeSession == null) {
                MicForegroundService.INSTANCE.j(this.context, cap.getMicToken());
            }
        }
    }

    public final void Z() {
        AudioRecord recorder;
        t tVar;
        ActiveSession activeSession = this.activeSession;
        if (activeSession == null || (recorder = activeSession.getRecorder()) == null) {
            MicCapturePrewarm micCapturePrewarm = this.liveCapture;
            recorder = micCapturePrewarm != null ? micCapturePrewarm.getRecorder() : null;
        }
        this.retiredRecorder = recorder;
        try {
            Result.Companion companion = Result.INSTANCE;
            if (recorder != null) {
                recorder.stop();
                tVar = t.f7040a;
            } else {
                tVar = null;
            }
            Result.b(tVar);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            Result.b(C4849c.a(th));
        }
        synchronized (this.captureLock) {
            MicCapturePrewarm micCapturePrewarm2 = this.liveCapture;
            if (micCapturePrewarm2 == null) {
                return;
            }
            this.liveCapture = null;
            micCapturePrewarm2.p();
            t tVar2 = t.f7040a;
        }
    }

    @Override // com.stepos.ailauncher.speech.asr.c
    public boolean a(Context context) {
        p.i(context, "context");
        try {
            boolean z10 = true;
            if (I.INSTANCE.b(context)) {
                C4148a.k(TAG, "isAvailable: networkOk=true -> true (skip local AIEngine check)", false, 4, null);
                return true;
            }
            AlgorithmClients algorithmClients = AlgorithmClients.INSTANCE;
            boolean zIsSupported = algorithmClients.getAsrSse().isSupported(context);
            int iCheckResources = algorithmClients.getAsrSse().checkResources(context);
            if (iCheckResources != 1 || !zIsSupported) {
                z10 = false;
            }
            C4148a.k(TAG, "isAvailable: offline supported=" + zIsSupported + " checkResources=" + iCheckResources + " (OK=1) -> " + z10, false, 4, null);
            return z10;
        } catch (Exception e10) {
            C4148a.t(TAG, "isAvailable check failed", e10, false, 8, null);
            return false;
        }
    }

    public final MicCapturePrewarm a0(boolean forceFgs) {
        Object objB;
        int iF = C5685n.f(AudioRecord.getMinBufferSize(16000, 16, 2), com.stepos.agentframework.chatui.longtext.b.THRESHOLD);
        MicOccupancyMonitor micOccupancyMonitor = MicOccupancyMonitor.INSTANCE;
        AudioDeviceInfo audioDeviceInfoG = (!micOccupancyMonitor.I() || micOccupancyMonitor.n()) ? null : micOccupancyMonitor.g();
        AudioDeviceInfo audioDeviceInfoC = audioDeviceInfoG == null ? C() : audioDeviceInfoG;
        AsrRecorderHandle asrRecorderHandleG = G(iF);
        if (asrRecorderHandleG == null) {
            return null;
        }
        if (audioDeviceInfoC != null) {
            boolean preferredDevice = asrRecorderHandleG.getRecorder().setPreferredDevice(audioDeviceInfoC);
            C4148a.k(TAG, "AIOSBUG-19024: pin input type=" + audioDeviceInfoC.getType() + " id=" + audioDeviceInfoC.getId() + " shared=" + (audioDeviceInfoG != null) + " ok=" + preferredDevice, false, 4, null);
        }
        int iH = forceFgs ? MicForegroundService.INSTANCE.h(this.context) : MicForegroundService.INSTANCE.i(this.context);
        if (iH != 0) {
            MicForegroundService.INSTANCE.c(800L);
        }
        try {
            Result.Companion companion = Result.INSTANCE;
            asrRecorderHandleG.getRecorder().startRecording();
            objB = Result.b(t.f7040a);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objB = Result.b(C4849c.a(th));
        }
        if (!Result.g(objB)) {
            MicCapturePrewarm micCapturePrewarm = new MicCapturePrewarm(asrRecorderHandleG.getRecorder(), asrRecorderHandleG.getAudioSource(), 4096, 24, this.scope, iH);
            micCapturePrewarm.n();
            return micCapturePrewarm;
        }
        Throwable thE = Result.e(objB);
        if (thE != null) {
            C4148a.t(TAG, "startMicCapture: startRecording failed", thE, false, 8, null);
        } else {
            C4148a.u(TAG, "startMicCapture: startRecording failed", false, 4, null);
        }
        asrRecorderHandleG.getRecorder().release();
        if (iH != 0) {
            MicForegroundService.INSTANCE.j(this.context, iH);
        }
        return null;
    }

    @Override // com.stepos.ailauncher.speech.asr.c
    public void armStartHapticPcmSkip() {
        this.startHapticSkipUntilMs = b.INSTANCE.b(System.currentTimeMillis());
        C4148a.k(TAG, "armStartHapticPcmSkip until=" + this.startHapticSkipUntilMs, false, 4, null);
    }

    @Override // com.stepos.ailauncher.speech.asr.c
    public void b(AsrCallback callback) {
        p.i(callback, "callback");
        b0(callback, true);
    }

    public final void b0(AsrCallback callback, boolean manual) {
        long jIncrementAndGet = this.sessionGeneration.incrementAndGet();
        this.isManualMode = manual;
        this.isRecording.set(true);
        U(new AIEngineAsrEngine$startRecording$1(this, callback, manual, jIncrementAndGet, null));
    }

    @Override // com.stepos.ailauncher.speech.asr.c
    public void c() {
        if (this.isRecording.get()) {
            return;
        }
        int iIncrementAndGet = this.captureEpoch.incrementAndGet();
        this.prewarmInFlight.set(true);
        C1060i.d(this.scope, Y.b(), null, new AIEngineAsrEngine$prewarmCapture$1(iIncrementAndGet, this, null), 2, null);
    }

    public final void c0(AsrCallback callback, boolean listenVad) {
        long jIncrementAndGet = this.sessionGeneration.incrementAndGet();
        h hVar = new h(jIncrementAndGet, listenVad);
        this.slaOnlyRecordingMode = hVar;
        this.isManualMode = !listenVad;
        this.isRecording.set(true);
        U(new AIEngineAsrEngine$startSlaOnlyInternal$1(this, callback, jIncrementAndGet, hVar, null));
    }

    @Override // com.stepos.ailauncher.speech.asr.c
    public void cancel() {
        AudioRecord recorder;
        Object objB;
        AsrCallback callback;
        IAsrSseStreamRecognizer recognizer;
        Object objB2;
        t tVar;
        AudioRecord recorder2;
        String voiceTraceId;
        String voiceTraceId2;
        this.sessionGeneration.incrementAndGet();
        this.isRecording.set(false);
        this.activeRecordStartMs = 0L;
        this.startHapticSkipUntilMs = 0L;
        kotlinx.coroutines.g gVar = this.recordJob;
        this.recordJob = null;
        ActiveSession activeSession = this.activeSession;
        this.activeSession = null;
        if (activeSession != null && (voiceTraceId2 = activeSession.getVoiceTraceId()) != null) {
            E5.a.a("[ASR][traceId=" + voiceTraceId2 + "] cancelled session=" + activeSession.getId());
        }
        if (activeSession != null && (voiceTraceId = activeSession.getVoiceTraceId()) != null) {
            if (voiceTraceId.length() <= 0) {
                voiceTraceId = null;
            }
            if (voiceTraceId != null) {
                SlaVoiceBridge.INSTANCE.o(voiceTraceId);
            }
        }
        this.captureEpoch.incrementAndGet();
        this.prewarmInFlight.set(false);
        this.skipLiveCaptureAdopt = false;
        this.retiredRecorder = null;
        try {
            Result.Companion companion = Result.INSTANCE;
            if (activeSession == null || (recorder2 = activeSession.getRecorder()) == null) {
                tVar = null;
            } else {
                recorder2.stop();
                tVar = t.f7040a;
            }
            Result.b(tVar);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            Result.b(C4849c.a(th));
        }
        synchronized (this.captureLock) {
            try {
                MicCapturePrewarm micCapturePrewarm = this.liveCapture;
                this.liveCapture = null;
                if (micCapturePrewarm != null) {
                    if (gVar == null || gVar.g()) {
                        micCapturePrewarm.m();
                    } else {
                        micCapturePrewarm.p();
                    }
                }
                t tVar2 = t.f7040a;
            } catch (Throwable th2) {
                throw th2;
            }
        }
        if (gVar != null) {
            kotlinx.coroutines.g.Y0(gVar, null, 1, null);
        }
        if ((gVar == null || gVar.g()) && activeSession != null && (recorder = activeSession.getRecorder()) != null) {
            try {
                recorder.stop();
                Result.b(t.f7040a);
            } catch (Throwable th3) {
                Result.Companion companion3 = Result.INSTANCE;
                Result.b(C4849c.a(th3));
            }
            try {
                recorder.release();
                objB = Result.b(t.f7040a);
            } catch (Throwable th4) {
                Result.Companion companion4 = Result.INSTANCE;
                objB = Result.b(C4849c.a(th4));
            }
            Result.a(objB);
        }
        if (activeSession != null && (recognizer = activeSession.getRecognizer()) != null) {
            try {
                recognizer.closeChannel();
                objB2 = Result.b(t.f7040a);
            } catch (Throwable th5) {
                Result.Companion companion5 = Result.INSTANCE;
                objB2 = Result.b(C4849c.a(th5));
            }
            Result.a(objB2);
        }
        try {
            AlgorithmClients.INSTANCE.getAsrSse().releaseAlgorithm(this.context, false);
            Result.b(t.f7040a);
        } catch (Throwable th6) {
            Result.Companion companion6 = Result.INSTANCE;
            Result.b(C4849c.a(th6));
        }
        MicForegroundService.INSTANCE.f(this.context);
        if (activeSession == null || (callback = activeSession.getCallback()) == null) {
            return;
        }
        C1060i.d(kotlinx.coroutines.d.a(Y.c()), null, null, new AIEngineAsrEngine$cancel$9$1(callback, null), 3, null);
    }

    @Override // com.stepos.ailauncher.speech.asr.c
    public void cancelCapturePrewarm() {
        this.captureEpoch.incrementAndGet();
        this.prewarmInFlight.set(false);
        synchronized (this.captureLock) {
            try {
                if (this.isRecording.get()) {
                    return;
                }
                MicCapturePrewarm micCapturePrewarm = this.liveCapture;
                if (micCapturePrewarm == null) {
                    return;
                }
                ActiveSession activeSession = this.activeSession;
                if ((activeSession != null ? activeSession.getRecorder() : null) == micCapturePrewarm.getRecorder()) {
                    return;
                }
                this.liveCapture = null;
                Y(micCapturePrewarm);
                t tVar = t.f7040a;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.stepos.ailauncher.speech.asr.c
    public void d(AsrCallback callback) {
        p.i(callback, "callback");
        c0(callback, false);
    }

    public final MicCapturePrewarm d0() throws InterruptedException {
        MicCapturePrewarm micCapturePrewarm = this.liveCapture;
        if (micCapturePrewarm == null) {
            return null;
        }
        if (this.skipLiveCaptureAdopt || micCapturePrewarm.getRecorder() == this.retiredRecorder) {
            this.liveCapture = null;
            return null;
        }
        if (micCapturePrewarm.l()) {
            return micCapturePrewarm;
        }
        C4148a.u(TAG, "adoptOrStartCapture: drop unusable liveCapture source=" + micCapturePrewarm.getAudioSource(), false, 4, null);
        this.liveCapture = null;
        ActiveSession activeSession = this.activeSession;
        if ((activeSession != null ? activeSession.getRecorder() : null) == micCapturePrewarm.getRecorder()) {
            return null;
        }
        micCapturePrewarm.m();
        return null;
    }

    @Override // com.stepos.ailauncher.speech.asr.c
    public void destroy() {
        cancel();
        kotlinx.coroutines.d.e(this.scope, null, 1, null);
        try {
            Result.Companion companion = Result.INSTANCE;
            AlgorithmClients.INSTANCE.getAsrSse().releaseAlgorithm(this.context, true);
            Result.b(t.f7040a);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            Result.b(C4849c.a(th));
        }
    }

    @Override // com.stepos.ailauncher.speech.asr.c
    public long getLongPressRemainingMs() {
        long j10 = this.activeRecordStartMs;
        if (j10 <= 0) {
            return -1L;
        }
        return C5685n.g(this.longPressTimeoutMs - (System.currentTimeMillis() - j10), 0L);
    }

    @Override // com.stepos.ailauncher.speech.asr.c
    public long getLongPressTimeoutMs() {
        return this.longPressTimeoutMs;
    }

    @Override // com.stepos.ailauncher.speech.asr.c
    public long getRecordingRemainingMs() {
        long j10 = this.activeRecordStartMs;
        if (j10 <= 0) {
            return -1L;
        }
        return C5685n.g((this.isManualMode ? this.longPressTimeoutMs : this.listenTimeoutMs) - (System.currentTimeMillis() - j10), 0L);
    }

    @Override // com.stepos.ailauncher.speech.asr.c
    public void setListeningConfig(Long silenceTimeoutMs, Long listenTimeoutMs, Long muteTimeoutMs) {
        if (silenceTimeoutMs != null) {
            if (silenceTimeoutMs.longValue() <= 0) {
                silenceTimeoutMs = null;
            }
            if (silenceTimeoutMs != null) {
                this.silenceTimeoutMs = silenceTimeoutMs.longValue();
            }
        }
        if (listenTimeoutMs != null) {
            if (listenTimeoutMs.longValue() <= 0) {
                listenTimeoutMs = null;
            }
            if (listenTimeoutMs != null) {
                this.listenTimeoutMs = listenTimeoutMs.longValue();
            }
        }
        if (muteTimeoutMs != null) {
            if (muteTimeoutMs.longValue() <= 0) {
                muteTimeoutMs = null;
            }
            if (muteTimeoutMs != null) {
                this.muteTimeoutMs = muteTimeoutMs.longValue();
            }
        }
        C4148a.d(TAG, "setListeningConfig: cloudVadSilence=" + this.silenceTimeoutMs + "ms listen=" + this.listenTimeoutMs + "ms mute=" + this.muteTimeoutMs + Const.SP_KEY_GSM_UPLOAD_MXSIZE, false, 4, null);
    }

    @Override // com.stepos.ailauncher.speech.asr.c
    public void setLongPressTimeoutMs(Long timeoutMs) {
        if (timeoutMs != null) {
            if (timeoutMs.longValue() <= 0) {
                timeoutMs = null;
            }
            if (timeoutMs != null) {
                this.longPressTimeoutMs = timeoutMs.longValue();
            }
        }
        C4148a.d(TAG, "setLongPressTimeoutMs: " + this.longPressTimeoutMs + Const.SP_KEY_GSM_UPLOAD_MXSIZE, false, 4, null);
    }

    @Override // com.stepos.ailauncher.speech.asr.c
    public void setVadEnabled(boolean enabled) {
        Object objB;
        h hVar;
        if (!enabled && (hVar = this.slaOnlyRecordingMode) != null && hVar.b(this.sessionGeneration.get(), this.isRecording.get())) {
            this.isManualMode = true;
            C4148a.k(TAG, "setVadEnabled(" + enabled + "): SLA-only manualMode=" + this.isManualMode, false, 4, null);
            return;
        }
        ActiveSession activeSession = this.activeSession;
        IAsrSseStreamRecognizer recognizer = activeSession != null ? activeSession.getRecognizer() : null;
        if (recognizer == null) {
            C4148a.u(TAG, "setVadEnabled(" + enabled + "): no active recognizer (session closed?), skip", false, 4, null);
            return;
        }
        try {
            Result.Companion companion = Result.INSTANCE;
            IAsrSseStreamRecognizer.DefaultImpls.setVadEnabled$default(recognizer, enabled, null, 2, null);
            objB = Result.b(t.f7040a);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objB = Result.b(C4849c.a(th));
        }
        Throwable thE = Result.e(objB);
        if (thE != null) {
            C4148a.t(TAG, "setVadEnabled(" + enabled + ") failed", thE, false, 8, null);
        }
        if (!enabled) {
            this.isManualMode = true;
        }
        C4148a.k(TAG, "setVadEnabled(" + enabled + ") applied manualMode=" + this.isManualMode, false, 4, null);
    }

    @Override // com.stepos.ailauncher.speech.asr.c
    public void startListening(AsrCallback callback) {
        p.i(callback, "callback");
        b0(callback, false);
    }

    @Override // com.stepos.ailauncher.speech.asr.c
    public void startSlaOnlyListening(AsrCallback callback) {
        p.i(callback, "callback");
        c0(callback, true);
    }

    @Override // com.stepos.ailauncher.speech.asr.c
    public void stopAndFinalize() {
        this.isRecording.set(false);
    }
}
