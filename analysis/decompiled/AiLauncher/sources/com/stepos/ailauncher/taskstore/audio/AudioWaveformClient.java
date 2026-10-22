package com.stepos.ailauncher.taskstore.audio;

import La.H;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.RemoteException;
import android.os.SystemClock;
import android.util.Log;
import androidx.exifinterface.media.ExifInterface;
import com.android.soundrecorder.IAudioWaveformCallback;
import com.android.soundrecorder.IAudioWaveformService;
import com.autonavi.aps.amapapi.AMapLocationStaticsEntity;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.ailauncher.chat.voicewakeup.VoiceWakeupReceiver;
import com.stepos.ailauncher.common.utils.MicOccupancyMonitor;
import com.stepos.ailauncher.taskstore.audio.AudioWaveformClient;
import com.stepos.ailauncher.taskstore.audio.b;
import java.util.Arrays;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.jvm.internal.p;
import v9.C5685n;

@Metadata(d1 = {"\u0000\u009c\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\b\u0003\n\u0002\b\u0005*\u0002[^\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001aB\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\u000e\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\u0017\u0010\u0010\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\u0010\u0010\u000fJ\u000f\u0010\u0011\u001a\u00020\rH\u0002¢\u0006\u0004\b\u0011\u0010\u0003J\u0017\u0010\u0014\u001a\u00020\u000b2\u0006\u0010\u0013\u001a\u00020\u0012H\u0002¢\u0006\u0004\b\u0014\u0010\u0015J\u0017\u0010\u0016\u001a\u00020\u000b2\u0006\u0010\u0013\u001a\u00020\u0012H\u0002¢\u0006\u0004\b\u0016\u0010\u0015J\u0017\u0010\u0019\u001a\u00020\r2\u0006\u0010\u0018\u001a\u00020\u0017H\u0002¢\u0006\u0004\b\u0019\u0010\u001aJ\u0015\u0010\u001c\u001a\u00020\r2\u0006\u0010\u001b\u001a\u00020\u0004¢\u0006\u0004\b\u001c\u0010\u001dJ\u0015\u0010 \u001a\u00020\r2\u0006\u0010\u001f\u001a\u00020\u001e¢\u0006\u0004\b \u0010!J\r\u0010\"\u001a\u00020\r¢\u0006\u0004\b\"\u0010\u0003J\r\u0010#\u001a\u00020\r¢\u0006\u0004\b#\u0010\u0003R\u0014\u0010$\u001a\u00020\u000b8\u0002X\u0082T¢\u0006\u0006\n\u0004\b$\u0010%R\u0014\u0010&\u001a\u00020\u000b8\u0002X\u0082T¢\u0006\u0006\n\u0004\b&\u0010%R\u0014\u0010'\u001a\u00020\u000b8\u0002X\u0082T¢\u0006\u0006\n\u0004\b'\u0010%R\u0014\u0010(\u001a\u00020\u000b8\u0002X\u0082T¢\u0006\u0006\n\u0004\b(\u0010%R\u0014\u0010)\u001a\u00020\u00128\u0006X\u0086T¢\u0006\u0006\n\u0004\b)\u0010*R\u0014\u0010+\u001a\u00020\u00128\u0006X\u0086T¢\u0006\u0006\n\u0004\b+\u0010*R\u0014\u0010,\u001a\u00020\u00128\u0006X\u0086T¢\u0006\u0006\n\u0004\b,\u0010*R\u0014\u0010-\u001a\u00020\u00128\u0006X\u0086T¢\u0006\u0006\n\u0004\b-\u0010*R\u0014\u0010.\u001a\u00020\u00128\u0006X\u0086T¢\u0006\u0006\n\u0004\b.\u0010*R\u0014\u0010/\u001a\u00020\u00128\u0006X\u0086T¢\u0006\u0006\n\u0004\b/\u0010*R\u0014\u00100\u001a\u00020\u00128\u0006X\u0086T¢\u0006\u0006\n\u0004\b0\u0010*R\u0014\u00101\u001a\u00020\u00128\u0006X\u0086T¢\u0006\u0006\n\u0004\b1\u0010*R\u0014\u00102\u001a\u00020\u00128\u0006X\u0086T¢\u0006\u0006\n\u0004\b2\u0010*R\u0014\u00103\u001a\u00020\u00128\u0006X\u0086T¢\u0006\u0006\n\u0004\b3\u0010*R\u0014\u00105\u001a\u0002048\u0002X\u0082T¢\u0006\u0006\n\u0004\b5\u0010\u0014R\u0014\u00106\u001a\u00020\u00128\u0002X\u0082T¢\u0006\u0006\n\u0004\b6\u0010*R\u0014\u00108\u001a\u0002078\u0002X\u0082T¢\u0006\u0006\n\u0004\b8\u00109R\u0014\u0010:\u001a\u0002078\u0002X\u0082T¢\u0006\u0006\n\u0004\b:\u00109R\u0014\u0010<\u001a\u00020;8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b<\u0010=R\u001a\u0010?\u001a\b\u0012\u0004\u0012\u00020\u001e0>8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b?\u0010@R\u0018\u0010A\u001a\u0004\u0018\u00010\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bA\u0010BR\u0018\u0010D\u001a\u0004\u0018\u00010C8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bD\u0010ER\u0016\u0010F\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bF\u0010GR\u0014\u0010I\u001a\u00020H8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bI\u0010JR\u0014\u0010K\u001a\u00020H8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bK\u0010JR\u0014\u0010M\u001a\u00020L8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bM\u0010NR\u0014\u0010P\u001a\u00020O8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bP\u0010QR\u0014\u0010S\u001a\u00020R8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bS\u0010TR\u0014\u0010U\u001a\u00020R8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bU\u0010TR\u0014\u0010W\u001a\u00020V8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bW\u0010XR\u0014\u0010Y\u001a\u00020V8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bY\u0010XR\u0014\u0010Z\u001a\u00020R8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bZ\u0010TR\u0014\u0010\\\u001a\u00020[8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\\\u0010]R\u0014\u0010_\u001a\u00020^8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b_\u0010`¨\u0006b"}, d2 = {"Lcom/stepos/ailauncher/taskstore/audio/AudioWaveformClient;", "", "<init>", "()V", "Landroid/content/Context;", "ctx", "", "C", "(Landroid/content/Context;)Z", "D", "()Z", "", "reason", "LY8/t;", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "(Ljava/lang/String;)V", "u", ExifInterface.LONGITUDE_EAST, "", VoiceWakeupReceiver.EXTRA_STATE, "F", "(I)Ljava/lang/String;", "G", "Lcom/stepos/ailauncher/taskstore/audio/b;", "event", "z", "(Lcom/stepos/ailauncher/taskstore/audio/b;)V", "context", "B", "(Landroid/content/Context;)V", "Lcom/stepos/ailauncher/taskstore/audio/AudioWaveformClient$a;", "listener", "t", "(Lcom/stepos/ailauncher/taskstore/audio/AudioWaveformClient$a;)V", "v", "y", "TAG", "Ljava/lang/String;", "SERVICE_PACKAGE", "SERVICE_CLASS", "CLIENT_TAG", "STATE_PENDING", "I", "STATE_RECORDING", "STATE_COMPLETED", "SUMMARY_EMPTY", "SUMMARY_GENERATING", "SUMMARY_SUCCESS", "SUMMARY_FAILED", "SUMMARY_ACCOUNT_ERROR", "SUMMARY_VIOLATION", "SUMMARY_SUCCESS_WITH_TODO", "", "AMPLITUDE_MAX", "WAVEFORM_LOG_SAMPLE_EVERY", "", "WAVEFORM_STATS_WINDOW_MS", "J", "CONNECT_TIMEOUT_MS", "Landroid/os/IBinder$DeathRecipient;", "deathRecipient", "Landroid/os/IBinder$DeathRecipient;", "Ljava/util/concurrent/CopyOnWriteArrayList;", "listeners", "Ljava/util/concurrent/CopyOnWriteArrayList;", "appContext", "Landroid/content/Context;", "Lcom/android/soundrecorder/IAudioWaveformService;", "service", "Lcom/android/soundrecorder/IAudioWaveformService;", "bound", "Z", "Ljava/util/concurrent/atomic/AtomicBoolean;", "connecting", "Ljava/util/concurrent/atomic/AtomicBoolean;", "callbackRegistered", "Landroid/os/Handler;", "mainHandler", "Landroid/os/Handler;", "Ljava/lang/Runnable;", "connectTimeoutRunnable", "Ljava/lang/Runnable;", "Ljava/util/concurrent/atomic/AtomicLong;", "frameCounter", "Ljava/util/concurrent/atomic/AtomicLong;", "statsWindowStartMs", "Ljava/util/concurrent/atomic/AtomicInteger;", "statsWindowFrames", "Ljava/util/concurrent/atomic/AtomicInteger;", "statsWindowPeak", "statsWindowAmpSum", "com/stepos/ailauncher/taskstore/audio/AudioWaveformClient$callback$1", "callback", "Lcom/stepos/ailauncher/taskstore/audio/AudioWaveformClient$callback$1;", "com/stepos/ailauncher/taskstore/audio/AudioWaveformClient$b", "connection", "Lcom/stepos/ailauncher/taskstore/audio/AudioWaveformClient$b;", Const.INTENT_KEY_APIKEY, "taskstore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class AudioWaveformClient {
    private static final float AMPLITUDE_MAX = 32767.0f;
    private static final String CLIENT_TAG = "com.stepos.ailauncher";
    private static final long CONNECT_TIMEOUT_MS = 5000;
    private static final String SERVICE_CLASS = "com.android.soundrecorder.service.AudioWaveformService";
    private static final String SERVICE_PACKAGE = "com.android.soundrecorder";
    public static final int STATE_COMPLETED = 2;
    public static final int STATE_PENDING = 0;
    public static final int STATE_RECORDING = 1;
    public static final int SUMMARY_ACCOUNT_ERROR = 4;
    public static final int SUMMARY_EMPTY = 0;
    public static final int SUMMARY_FAILED = 3;
    public static final int SUMMARY_GENERATING = 1;
    public static final int SUMMARY_SUCCESS = 2;
    public static final int SUMMARY_SUCCESS_WITH_TODO = 6;
    public static final int SUMMARY_VIOLATION = 5;
    private static final String TAG = "AudioWaveformClient";
    private static final int WAVEFORM_LOG_SAMPLE_EVERY = 40;
    private static final long WAVEFORM_STATS_WINDOW_MS = 1000;
    private static volatile Context appContext;
    private static volatile boolean bound;
    private static volatile IAudioWaveformService service;
    public static final AudioWaveformClient INSTANCE = new AudioWaveformClient();
    private static final IBinder.DeathRecipient deathRecipient = new IBinder.DeathRecipient() { // from class: t6.b
        @Override // android.os.IBinder.DeathRecipient
        public final void binderDied() {
            AudioWaveformClient.x();
        }
    };
    private static final CopyOnWriteArrayList<a> listeners = new CopyOnWriteArrayList<>();
    private static final AtomicBoolean connecting = new AtomicBoolean(false);
    private static final AtomicBoolean callbackRegistered = new AtomicBoolean(false);
    private static final Handler mainHandler = new Handler(Looper.getMainLooper());
    private static final Runnable connectTimeoutRunnable = new Runnable() { // from class: t6.c
        @Override // java.lang.Runnable
        public final void run() {
            AudioWaveformClient.w();
        }
    };
    private static final AtomicLong frameCounter = new AtomicLong(0);
    private static final AtomicLong statsWindowStartMs = new AtomicLong(0);
    private static final AtomicInteger statsWindowFrames = new AtomicInteger(0);
    private static final AtomicInteger statsWindowPeak = new AtomicInteger(0);
    private static final AtomicLong statsWindowAmpSum = new AtomicLong(0);
    private static final AudioWaveformClient$callback$1 callback = new IAudioWaveformCallback.Stub() { // from class: com.stepos.ailauncher.taskstore.audio.AudioWaveformClient$callback$1
        @Override // com.android.soundrecorder.IAudioWaveformCallback
        public void onRecordingStateChanged(String taskId, int status) {
            AudioWaveformClient audioWaveformClient = AudioWaveformClient.INSTANCE;
            Log.i("AudioWaveformClient", "onRecordingStateChanged: taskId=" + taskId + ", status=" + status + " (" + audioWaveformClient.F(status) + "), thread=" + Thread.currentThread().getName());
            MicOccupancyMonitor.INSTANCE.G(status == 1);
            audioWaveformClient.z(new b.StateChanged(taskId, status));
        }

        @Override // com.android.soundrecorder.IAudioWaveformCallback
        public void onSummaryStateChanged(int recorderId, int state, String content) {
            if (content == null) {
                content = "";
            }
            AudioWaveformClient audioWaveformClient = AudioWaveformClient.INSTANCE;
            Log.i("AudioWaveformClient", "onSummaryStateChanged: recorderId=" + recorderId + ", state=" + state + " (" + audioWaveformClient.G(state) + "), contentLen=" + content.length() + ", thread=" + Thread.currentThread().getName());
            audioWaveformClient.z(new b.SummaryStateChanged(recorderId, state, content));
        }

        @Override // com.android.soundrecorder.IAudioWaveformCallback
        public void onWaveformData(int amplitude, long timestamp, long recordedTime) {
            long j10;
            Log.i("AudioWaveformClient", "onWaveformData: FIRST FRAME amplitude=" + amplitude + " , remoteTs=" + timestamp + ", recordedTime=" + recordedTime + ", thread=" + Thread.currentThread().getName());
            long jIncrementAndGet = AudioWaveformClient.frameCounter.incrementAndGet();
            long jElapsedRealtime = SystemClock.elapsedRealtime();
            int iN = C5685n.n(amplitude, 0, 32767);
            float fM = C5685n.m(((float) iN) / 32767.0f, 0.0f, 1.0f);
            if (jIncrementAndGet == 1) {
                Log.i("AudioWaveformClient", "onWaveformData: FIRST FRAME amplitude=" + amplitude + " (clamped=" + iN + ", normalized=" + fM + "), remoteTs=" + timestamp + ", recordedTime=" + recordedTime + ", thread=" + Thread.currentThread().getName());
                AudioWaveformClient.statsWindowStartMs.set(jElapsedRealtime);
            }
            if (jIncrementAndGet % 40 == 0) {
                String str = String.format("%.3f", Arrays.copyOf(new Object[]{Float.valueOf(fM)}, 1));
                p.h(str, "format(...)");
                StringBuilder sb2 = new StringBuilder();
                j10 = 0;
                sb2.append("onWaveformData[");
                sb2.append(jIncrementAndGet);
                sb2.append("]: amplitude=");
                sb2.append(amplitude);
                sb2.append(", normalized=");
                sb2.append(str);
                sb2.append(", remoteTs=");
                sb2.append(timestamp);
                sb2.append(", recordedTime=");
                sb2.append(recordedTime);
                Log.d("AudioWaveformClient", sb2.toString());
            } else {
                j10 = 0;
            }
            AudioWaveformClient.statsWindowFrames.incrementAndGet();
            AudioWaveformClient.statsWindowAmpSum.addAndGet(iN);
            int i10 = AudioWaveformClient.statsWindowPeak.get();
            if (iN > i10) {
                AudioWaveformClient.statsWindowPeak.compareAndSet(i10, iN);
            }
            long j11 = AudioWaveformClient.statsWindowStartMs.get();
            if (j11 > j10 && jElapsedRealtime - j11 >= 1000 && AudioWaveformClient.statsWindowStartMs.compareAndSet(j11, jElapsedRealtime)) {
                int andSet = AudioWaveformClient.statsWindowFrames.getAndSet(0);
                int andSet2 = AudioWaveformClient.statsWindowPeak.getAndSet(0);
                long j12 = j10;
                long andSet3 = AudioWaveformClient.statsWindowAmpSum.getAndSet(j12);
                if (andSet > 0) {
                    j12 = andSet3 / andSet;
                }
                Log.i("AudioWaveformClient", "onWaveformData stats: fps=" + andSet + "/s, peak=" + andSet2 + ", avg=" + j12 + " over last ~1000ms");
            }
            AudioWaveformClient.INSTANCE.z(new b.Amplitude(amplitude, fM, timestamp, recordedTime));
        }
    };
    private static final b connection = new b();

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bæ\u0080\u0001\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007À\u0006\u0003"}, d2 = {"Lcom/stepos/ailauncher/taskstore/audio/AudioWaveformClient$a;", "", "Lcom/stepos/ailauncher/taskstore/audio/b;", "event", "LY8/t;", Const.INTENT_KEY_APIKEY, "(Lcom/stepos/ailauncher/taskstore/audio/b;)V", "taskstore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public interface a {
        void a(com.stepos.ailauncher.taskstore.audio.b event);
    }

    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J#\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u0019\u0010\t\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\t\u0010\nJ\u0019\u0010\u000b\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u000b\u0010\nJ\u0019\u0010\f\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\f\u0010\n¨\u0006\r"}, d2 = {"com/stepos/ailauncher/taskstore/audio/AudioWaveformClient$b", "Landroid/content/ServiceConnection;", "Landroid/content/ComponentName;", "name", "Landroid/os/IBinder;", "binder", "LY8/t;", "onServiceConnected", "(Landroid/content/ComponentName;Landroid/os/IBinder;)V", "onServiceDisconnected", "(Landroid/content/ComponentName;)V", "onNullBinding", "onBindingDied", "taskstore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class b implements ServiceConnection {
        @Override // android.content.ServiceConnection
        public void onBindingDied(ComponentName name) {
            Log.w(AudioWaveformClient.TAG, "onBindingDied: binding to recorder died, name=" + name);
            AudioWaveformClient.mainHandler.removeCallbacks(AudioWaveformClient.connectTimeoutRunnable);
            AudioWaveformClient.INSTANCE.u("onBindingDied");
        }

        @Override // android.content.ServiceConnection
        public void onNullBinding(ComponentName name) {
            Log.w(AudioWaveformClient.TAG, "onNullBinding: recorder onBind returned null, name=" + name);
            AudioWaveformClient.mainHandler.removeCallbacks(AudioWaveformClient.connectTimeoutRunnable);
            AudioWaveformClient.INSTANCE.u("onNullBinding");
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName name, IBinder binder) throws RemoteException {
            Log.i(AudioWaveformClient.TAG, "onServiceConnected: name=" + name + ", binder=" + binder + ", thread=" + Thread.currentThread().getName());
            AudioWaveformClient.mainHandler.removeCallbacks(AudioWaveformClient.connectTimeoutRunnable);
            AudioWaveformClient.connecting.set(false);
            IAudioWaveformService iAudioWaveformServiceAsInterface = IAudioWaveformService.Stub.asInterface(binder);
            AudioWaveformClient.service = iAudioWaveformServiceAsInterface;
            AudioWaveformClient.bound = true;
            if (binder != null) {
                try {
                    binder.linkToDeath(AudioWaveformClient.deathRecipient, 0);
                } catch (RemoteException e10) {
                    Log.w(AudioWaveformClient.TAG, "linkToDeath failed", e10);
                }
            }
            Log.d(AudioWaveformClient.TAG, "linkToDeath ok");
            try {
                boolean zIsRecording = iAudioWaveformServiceAsInterface.isRecording();
                Log.i(AudioWaveformClient.TAG, "remote state on connect: isRecording=" + zIsRecording + ", currentTaskId=" + iAudioWaveformServiceAsInterface.getCurrentTaskId());
                MicOccupancyMonitor.INSTANCE.G(zIsRecording);
            } catch (RemoteException e11) {
                Log.w(AudioWaveformClient.TAG, "read remote state on connect failed", e11);
            }
            AudioWaveformClient audioWaveformClient = AudioWaveformClient.INSTANCE;
            if (audioWaveformClient.D()) {
                audioWaveformClient.z(new b.ConnectionChanged(true));
            } else {
                Log.w(AudioWaveformClient.TAG, "onServiceConnected but registerCallback failed, disconnecting to allow clean reconnect");
                audioWaveformClient.y();
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName name) {
            Log.w(AudioWaveformClient.TAG, "onServiceDisconnected: name=" + name + " (binder unexpectedly gone)");
            AudioWaveformClient.INSTANCE.A("onServiceDisconnected");
        }
    }

    public static final void w() {
        if (!connecting.get() || bound) {
            return;
        }
        Log.w(TAG, "connect timeout after 5000ms: no onServiceConnected/onNullBinding, treat as failed");
        INSTANCE.u("connectTimeout");
    }

    public static final void x() {
        Log.w(TAG, "binderDied: remote process died, cleaning up");
        INSTANCE.A("binderDied");
    }

    public final void A(String reason) {
        Log.w(TAG, "handleServiceDisconnected: reason=" + reason + ", totalFramesSinceLastConnect=" + frameCounter.get());
        callbackRegistered.set(false);
        service = null;
        bound = false;
        connecting.set(false);
        E();
        z(new b.ConnectionChanged(false));
    }

    public final void B(Context context) {
        p.i(context, "context");
        if (appContext != null) {
            Log.d(TAG, "init: already initialized, skip");
            return;
        }
        synchronized (this) {
            if (appContext != null) {
                return;
            }
            appContext = context.getApplicationContext();
            Log.i(TAG, "init: appContext set, package=" + context.getApplicationContext().getPackageName());
        }
    }

    public final boolean C(Context ctx) {
        Object objB;
        Object objB2;
        PackageManager packageManager = ctx.getPackageManager();
        try {
            Result.Companion companion = Result.INSTANCE;
            objB = Result.b(packageManager.getPackageInfo(SERVICE_PACKAGE, 0));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objB = Result.b(C4849c.a(th));
        }
        if (Result.g(objB)) {
            objB = null;
        }
        PackageInfo packageInfo = (PackageInfo) objB;
        if (packageInfo == null) {
            Log.e(TAG, "preflight: package not installed or invisible: com.android.soundrecorder. If installed, check <queries><package android:name=\"com.android.soundrecorder\"/></queries> in AndroidManifest.");
            return false;
        }
        Log.i(TAG, "preflight: package found pkg=com.android.soundrecorder, versionName=" + packageInfo.versionName + ", versionCode=" + packageInfo.versionCode);
        Intent intent = new Intent();
        intent.setComponent(new ComponentName(SERVICE_PACKAGE, SERVICE_CLASS));
        try {
            objB2 = Result.b(packageManager.resolveService(intent, 0));
        } catch (Throwable th2) {
            Result.Companion companion3 = Result.INSTANCE;
            objB2 = Result.b(C4849c.a(th2));
        }
        ResolveInfo resolveInfo = (ResolveInfo) (Result.g(objB2) ? null : objB2);
        if (resolveInfo == null) {
            Log.e(TAG, "preflight: resolveService(explicit) returned null for com.android.soundrecorder/com.android.soundrecorder.service.AudioWaveformService. Possible causes: (1) recorder app moved/renamed the Service class — verify the new class FQCN; (2) Service exists but not exported. Try `adb shell dumpsys package com.android.soundrecorder | grep -i service` to list its exported services.");
            return false;
        }
        ServiceInfo serviceInfo = resolveInfo.serviceInfo;
        Log.i(TAG, "preflight: serviceInfo name=" + serviceInfo.name + ", exported=" + serviceInfo.exported + ", permission=" + serviceInfo.permission + ", process=" + serviceInfo.processName);
        if (!serviceInfo.exported) {
            Log.w(TAG, "preflight: target service is NOT exported, bindService will fail with SecurityException. Ask the recorder side to set android:exported=\"true\".");
        }
        String str = serviceInfo.permission;
        if (str == null || H.x0(str)) {
            return true;
        }
        String str2 = serviceInfo.permission;
        Log.w(TAG, "preflight: target service requires permission=" + str2 + "; this app must declare <uses-permission android:name=\"" + str2 + "\"/> in its manifest.");
        return true;
    }

    public final boolean D() {
        Object objB;
        Object objB2;
        IAudioWaveformService iAudioWaveformService = service;
        if (iAudioWaveformService == null) {
            Log.w(TAG, "registerCallback: service==null, skip");
            return false;
        }
        if (!callbackRegistered.compareAndSet(false, true)) {
            Log.d(TAG, "registerCallback: skipped, already registered");
            return true;
        }
        Log.i(TAG, "registerCallback: enter, clientTag=com.stepos.ailauncher");
        E();
        try {
            iAudioWaveformService.registerCallback(callback, CLIENT_TAG);
            try {
                Result.Companion companion = Result.INSTANCE;
                objB = Result.b(iAudioWaveformService.getCurrentTaskId());
            } catch (Throwable th) {
                Result.Companion companion2 = Result.INSTANCE;
                objB = Result.b(C4849c.a(th));
            }
            Object obj = null;
            if (Result.g(objB)) {
                objB = null;
            }
            String str = (String) objB;
            try {
                objB2 = Result.b(Boolean.valueOf(iAudioWaveformService.isRecording()));
            } catch (Throwable th2) {
                Result.Companion companion3 = Result.INSTANCE;
                objB2 = Result.b(C4849c.a(th2));
            }
            if (!Result.g(objB2)) {
                obj = objB2;
            }
            Log.i(TAG, "registerCallback: ok, remoteRecording=" + ((Boolean) obj) + ", currentTaskId=" + str);
            return true;
        } catch (Throwable th3) {
            Log.e(TAG, "registerCallback: failed", th3);
            callbackRegistered.set(false);
            return false;
        }
    }

    public final void E() {
        frameCounter.set(0L);
        statsWindowStartMs.set(0L);
        statsWindowFrames.set(0);
        statsWindowPeak.set(0);
        statsWindowAmpSum.set(0L);
    }

    public final String F(int state) {
        return state != 0 ? state != 1 ? state != 2 ? "UNKNOWN" : "COMPLETED" : "RECORDING" : "PENDING";
    }

    public final String G(int state) {
        switch (state) {
            case 0:
                return "EMPTY";
            case 1:
                return "GENERATING";
            case 2:
                return AMapLocationStaticsEntity.SUCCESS_STATUS;
            case 3:
                return "FAILED";
            case 4:
                return "ACCOUNT_ERROR";
            case 5:
                return "VIOLATION";
            case 6:
                return "SUCCESS_WITH_TODO";
            default:
                return "UNKNOWN";
        }
    }

    public final void t(a listener) {
        p.i(listener, "listener");
        CopyOnWriteArrayList<a> copyOnWriteArrayList = listeners;
        boolean zContains = copyOnWriteArrayList.contains(listener);
        boolean z10 = !zContains;
        if (!zContains) {
            copyOnWriteArrayList.add(listener);
        }
        Log.d(TAG, "addListener: added=" + z10 + ", totalListeners=" + copyOnWriteArrayList.size());
    }

    public final void u(String reason) {
        AtomicBoolean atomicBoolean = connecting;
        Log.w(TAG, "cleanupAfterFailedBind: reason=" + reason + ", wasConnecting=" + atomicBoolean.get() + ", bound=" + bound);
        Context context = appContext;
        callbackRegistered.set(false);
        service = null;
        bound = false;
        atomicBoolean.set(false);
        E();
        if (context != null) {
            try {
                context.unbindService(connection);
                Log.d(TAG, "cleanupAfterFailedBind: unbindService ok");
            } catch (Throwable th) {
                Log.d(TAG, "cleanupAfterFailedBind: unbindService ignored: " + th.getMessage());
            }
        }
        z(new b.ConnectionChanged(false));
    }

    public final void v() {
        boolean zBindService;
        String name = Thread.currentThread().getName();
        boolean z10 = bound;
        AtomicBoolean atomicBoolean = connecting;
        Log.i(TAG, "connect: enter, caller=" + name + ", bound=" + z10 + ", connecting=" + atomicBoolean.get() + ", listeners=" + listeners.size());
        Context context = appContext;
        if (context == null) {
            Log.w(TAG, "connect: AudioWaveformClient.init(context) not called yet");
            return;
        }
        if (bound || !atomicBoolean.compareAndSet(false, true)) {
            Log.d(TAG, "connect: skip, bound=" + bound + ", connecting=" + atomicBoolean.get());
            return;
        }
        if (!C(context)) {
            atomicBoolean.set(false);
            z(new b.ConnectionChanged(false));
            return;
        }
        Intent intent = new Intent();
        intent.setComponent(new ComponentName(SERVICE_PACKAGE, SERVICE_CLASS));
        Log.i(TAG, "connect: bindService component=com.android.soundrecorder/com.android.soundrecorder.service.AudioWaveformService");
        try {
            zBindService = context.bindService(intent, connection, 1);
        } catch (Throwable th) {
            Log.e(TAG, "connect: bindService threw", th);
            zBindService = false;
        }
        Log.i(TAG, "connect: bindService returned " + zBindService);
        if (zBindService) {
            Handler handler = mainHandler;
            Runnable runnable = connectTimeoutRunnable;
            handler.removeCallbacks(runnable);
            handler.postDelayed(runnable, 5000L);
            return;
        }
        Log.w(TAG, "connect: recorder service unreachable, notifying listeners with connected=false");
        connecting.set(false);
        z(new b.ConnectionChanged(false));
        try {
            context.unbindService(connection);
            Log.d(TAG, "connect: unbindService after failed bind ok");
        } catch (Throwable th2) {
            Log.d(TAG, "connect: unbindService after failed bind ignored: " + th2.getMessage());
        }
    }

    public final void y() {
        String name = Thread.currentThread().getName();
        boolean z10 = bound;
        AtomicBoolean atomicBoolean = callbackRegistered;
        Log.i(TAG, "disconnect: enter, caller=" + name + ", bound=" + z10 + ", callbackRegistered=" + atomicBoolean.get() + ", totalFramesSinceLastConnect=" + frameCounter.get());
        mainHandler.removeCallbacks(connectTimeoutRunnable);
        Context context = appContext;
        IAudioWaveformService iAudioWaveformService = service;
        boolean z11 = bound;
        if (atomicBoolean.compareAndSet(true, false)) {
            Log.i(TAG, "disconnect: unregisterCallback start, clientTag=com.stepos.ailauncher");
            if (iAudioWaveformService != null) {
                try {
                    iAudioWaveformService.unregisterCallback(callback, CLIENT_TAG);
                } catch (RemoteException e10) {
                    Log.w(TAG, "disconnect: unregisterCallback failed", e10);
                }
            }
            Log.i(TAG, "disconnect: unregisterCallback ok");
        } else {
            Log.d(TAG, "disconnect: callback was not registered, skip unregister");
        }
        if (iAudioWaveformService != null) {
            try {
                IBinder iBinderAsBinder = iAudioWaveformService.asBinder();
                if (iBinderAsBinder != null) {
                    iBinderAsBinder.unlinkToDeath(deathRecipient, 0);
                }
            } catch (Throwable th) {
                Log.d(TAG, "disconnect: unlinkToDeath ignored: " + th.getMessage());
            }
        }
        Log.d(TAG, "disconnect: unlinkToDeath ok");
        service = null;
        bound = false;
        connecting.set(false);
        E();
        if (!z11 || context == null) {
            Log.d(TAG, "disconnect: skip unbindService, wasBound=" + z11 + ", hasCtx=" + (context != null));
            return;
        }
        try {
            context.unbindService(connection);
            Log.i(TAG, "disconnect: unbindService ok");
        } catch (Throwable th2) {
            Log.d(TAG, "disconnect: unbindService ignored: " + th2.getMessage());
        }
        z(new b.ConnectionChanged(false));
    }

    public final void z(com.stepos.ailauncher.taskstore.audio.b event) {
        CopyOnWriteArrayList<a> copyOnWriteArrayList = listeners;
        if (copyOnWriteArrayList.isEmpty()) {
            if (event instanceof b.Amplitude) {
                return;
            }
            Log.d(TAG, "dispatch: no listeners for " + event);
            return;
        }
        Iterator<a> it = copyOnWriteArrayList.iterator();
        p.h(it, "iterator(...)");
        while (it.hasNext()) {
            try {
                it.next().a(event);
            } catch (Throwable th) {
                Log.w(TAG, "dispatch: listener threw for " + event, th);
            }
        }
    }
}
