package com.stepos.ailauncher.speech.tts;

import Ua.C1060i;
import Ua.M;
import Y8.t;
import android.media.AudioAttributes;
import android.media.AudioFormat;
import android.media.AudioTrack;
import android.os.SystemClock;
import android.util.Log;
import androidx.exifinterface.media.ExifInterface;
import com.autonavi.aps.amapapi.config.Const;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.IntUnaryOperator;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.jvm.internal.Ref$ObjectRef;
import kotlinx.coroutines.CoroutineStart;
import v9.C5685n;

@Metadata(d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0010\u0012\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0000\u0018\u0000 Z2\u00020\u0001:\u0003[B\\B\u0019\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0017\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\bH\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\u000f\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\rH\u0002¢\u0006\u0004\b\u000f\u0010\u0010J\u0018\u0010\u0011\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\rH\u0082@¢\u0006\u0004\b\u0011\u0010\u0012J\u0017\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u000e\u001a\u00020\rH\u0002¢\u0006\u0004\b\u0014\u0010\u0015J\u001f\u0010\u0018\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0017\u001a\u00020\u0016H\u0002¢\u0006\u0004\b\u0018\u0010\u0019J\u0017\u0010\u001a\u001a\u00020\u00162\u0006\u0010\u000e\u001a\u00020\rH\u0002¢\u0006\u0004\b\u001a\u0010\u001bJ\u0017\u0010\u001c\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\rH\u0002¢\u0006\u0004\b\u001c\u0010\u0010J\u0017\u0010\u001e\u001a\u00020\u001d2\u0006\u0010\u000e\u001a\u00020\rH\u0002¢\u0006\u0004\b\u001e\u0010\u001fJ\u0017\u0010 \u001a\u00020\u00162\u0006\u0010\u000e\u001a\u00020\rH\u0002¢\u0006\u0004\b \u0010\u001bJ\u0017\u0010!\u001a\u00020\u00162\u0006\u0010\u000e\u001a\u00020\rH\u0002¢\u0006\u0004\b!\u0010\u001bJ\u0017\u0010\"\u001a\u00020\u00162\u0006\u0010\u000e\u001a\u00020\rH\u0002¢\u0006\u0004\b\"\u0010\u001bJ\u0017\u0010#\u001a\u00020\u00162\u0006\u0010\u000e\u001a\u00020\rH\u0002¢\u0006\u0004\b#\u0010\u001bJ\u001f\u0010%\u001a\u00020\u00162\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010$\u001a\u00020\u001dH\u0002¢\u0006\u0004\b%\u0010&J\u0017\u0010'\u001a\u00020\u001d2\u0006\u0010\u000e\u001a\u00020\rH\u0002¢\u0006\u0004\b'\u0010\u001fJ\u0017\u0010(\u001a\u00020\u00162\u0006\u0010\u000e\u001a\u00020\rH\u0002¢\u0006\u0004\b(\u0010\u001bJ\u0017\u0010*\u001a\u00020\u00162\u0006\u0010)\u001a\u00020\u0016H\u0002¢\u0006\u0004\b*\u0010+J'\u0010/\u001a\u00020.2\u0006\u0010,\u001a\u00020\u00162\u0006\u0010-\u001a\u00020\u00162\u0006\u0010)\u001a\u00020\u0016H\u0002¢\u0006\u0004\b/\u00100J\u0015\u00103\u001a\u00020\n2\u0006\u00102\u001a\u000201¢\u0006\u0004\b3\u00104J%\u00105\u001a\u00020\n2\u0006\u0010,\u001a\u00020\u00162\u0006\u0010-\u001a\u00020\u00162\u0006\u0010)\u001a\u00020\u0016¢\u0006\u0004\b5\u00106J\u0015\u00109\u001a\u00020\u00132\u0006\u00108\u001a\u000207¢\u0006\u0004\b9\u0010:J\r\u0010;\u001a\u00020\u001d¢\u0006\u0004\b;\u0010<J\r\u0010=\u001a\u00020\n¢\u0006\u0004\b=\u0010>J\r\u0010?\u001a\u00020\n¢\u0006\u0004\b?\u0010>J\r\u0010@\u001a\u00020\n¢\u0006\u0004\b@\u0010>J\r\u0010A\u001a\u00020\n¢\u0006\u0004\bA\u0010>J\u0010\u0010B\u001a\u00020\nH\u0086@¢\u0006\u0004\bB\u0010CJ\r\u0010D\u001a\u00020\u0013¢\u0006\u0004\bD\u0010EJ\r\u0010F\u001a\u00020\u0016¢\u0006\u0004\bF\u0010GJ\r\u0010H\u001a\u00020\u001d¢\u0006\u0004\bH\u0010<R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010IR\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010JR\u0014\u0010K\u001a\u00020\u00018\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bK\u0010LR\u0014\u0010N\u001a\u00020M8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bN\u0010OR\u0018\u0010P\u001a\u0004\u0018\u00010\r8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bP\u0010QR\u0016\u0010R\u001a\u00020\u00168\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bR\u0010SR\u0016\u0010T\u001a\u00020\u001d8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bT\u0010UR\u0014\u0010W\u001a\u00020V8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bW\u0010XR\u0016\u0010Y\u001a\u0002018\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bY\u0010\u0011¨\u0006]"}, d2 = {"Lcom/stepos/ailauncher/speech/tts/StreamingPcmPlayer;", "", "LUa/M;", "scope", "", "tag", "<init>", "(LUa/M;Ljava/lang/String;)V", "Landroid/media/AudioTrack;", "track", "LY8/t;", "y", "(Landroid/media/AudioTrack;)V", "Lcom/stepos/ailauncher/speech/tts/StreamingPcmPlayer$c;", "session", "u", "(Lcom/stepos/ailauncher/speech/tts/StreamingPcmPlayer$c;)V", "F", "(Lcom/stepos/ailauncher/speech/tts/StreamingPcmPlayer$c;Le9/c;)Ljava/lang/Object;", "", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "(Lcom/stepos/ailauncher/speech/tts/StreamingPcmPlayer$c;)Z", "", "count", "B", "(Lcom/stepos/ailauncher/speech/tts/StreamingPcmPlayer$c;I)V", "w", "(Lcom/stepos/ailauncher/speech/tts/StreamingPcmPlayer$c;)I", "r", "", "o", "(Lcom/stepos/ailauncher/speech/tts/StreamingPcmPlayer$c;)J", "s", "l", "n", "v", "durationMs", ExifInterface.LONGITUDE_EAST, "(Lcom/stepos/ailauncher/speech/tts/StreamingPcmPlayer$c;J)I", "e", Const.INTENT_KEY_UMID, "encoding", "m", "(I)I", "sampleRate", "channelCount", "Lcom/stepos/ailauncher/speech/tts/StreamingPcmPlayer$b;", "f", "(III)Lcom/stepos/ailauncher/speech/tts/StreamingPcmPlayer$b;", "", "gain", "x", "(F)V", "z", "(III)V", "", "pcm", Const.INTENT_KEY_BACKGROUND_COMMAND, "([B)Z", "p", "()J", "k", "()V", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "t", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "c", "(Le9/c;)Ljava/lang/Object;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_REMOVE, "()Z", "D", "()I", "q", "LUa/M;", "Ljava/lang/String;", "stateLock", "Ljava/lang/Object;", "Ljava/util/concurrent/atomic/AtomicInteger;", "nextSessionId", "Ljava/util/concurrent/atomic/AtomicInteger;", "activeSession", "Lcom/stepos/ailauncher/speech/tts/StreamingPcmPlayer$c;", "lastUnderrunTotal", "I", "lastPlaybackStartDelayMs", "J", "Ljava/util/concurrent/atomic/AtomicBoolean;", "holdPaused", "Ljava/util/concurrent/atomic/AtomicBoolean;", "duckGain", "Companion", Const.INTENT_KEY_APIKEY, Const.INTENT_KEY_PKGNAME, "speech_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class StreamingPcmPlayer {
    private static final long DRAIN_REMAIN_MS = 40;
    private static final long DRAIN_TAIL_MS = 100;
    private static final long PAUSE_WATER_MS = 150;
    private static final long PRE_BUFFER_MAX_WAIT_MS = 400;
    private static final long PRE_BUFFER_MIN_OPEN_MS = 80;
    private static final long PRE_BUFFER_MS = 800;
    private static final long QUEUE_POLL_MS = 10;
    private static final long RESUME_WATER_MS = 80;
    private static final String TAG = "StreamingPcmPlayer";
    private static final long TRACK_BUFFER_TARGET_MS = 800;
    private volatile c activeSession;
    private volatile float duckGain;
    private final AtomicBoolean holdPaused;
    private volatile long lastPlaybackStartDelayMs;
    private volatile int lastUnderrunTotal;
    private final AtomicInteger nextSessionId;
    private final M scope;
    private final Object stateLock;
    private final String tag;

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\b\b\u0082\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u000b\u001a\u00020\u0004HÖ\u0001¢\u0006\u0004\b\u000b\u0010\fJ\u001a\u0010\u000f\u001a\u00020\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u000f\u0010\u0010R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0014\u001a\u0004\b\u0015\u0010\f¨\u0006\u0016"}, d2 = {"Lcom/stepos/ailauncher/speech/tts/StreamingPcmPlayer$b;", "", "Landroid/media/AudioTrack;", "track", "", "bufferBytes", "<init>", "(Landroid/media/AudioTrack;I)V", "", "toString", "()Ljava/lang/String;", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Landroid/media/AudioTrack;", Const.INTENT_KEY_PKGNAME, "()Landroid/media/AudioTrack;", "I", Const.INTENT_KEY_APIKEY, "speech_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.ailauncher.speech.tts.StreamingPcmPlayer$b, reason: from toString */
    public static final /* data */ class CreatedTrack {
        private final int bufferBytes;
        private final AudioTrack track;

        public CreatedTrack(AudioTrack track, int i10) {
            kotlin.jvm.internal.p.i(track, "track");
            this.track = track;
            this.bufferBytes = i10;
        }

        /* renamed from: a, reason: from getter */
        public final int getBufferBytes() {
            return this.bufferBytes;
        }

        /* renamed from: b, reason: from getter */
        public final AudioTrack getTrack() {
            return this.track;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof CreatedTrack)) {
                return false;
            }
            CreatedTrack createdTrack = (CreatedTrack) other;
            return kotlin.jvm.internal.p.d(this.track, createdTrack.track) && this.bufferBytes == createdTrack.bufferBytes;
        }

        public int hashCode() {
            return (this.track.hashCode() * 31) + Integer.hashCode(this.bufferBytes);
        }

        public String toString() {
            return "CreatedTrack(track=" + this.track + ", bufferBytes=" + this.bufferBytes + ")";
        }
    }

    @Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0011\b\u0002\u0018\u00002\u00020\u0001B7\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0002\u0012\u0006\u0010\u0006\u001a\u00020\u0002\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\n\u0010\u000bR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\f\u001a\u0004\b\r\u0010\u000eR\u0017\u0010\u0004\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010\f\u001a\u0004\b\u000f\u0010\u000eR\u0017\u0010\u0005\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0005\u0010\f\u001a\u0004\b\u0010\u0010\u000eR\u0017\u0010\u0006\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0006\u0010\f\u001a\u0004\b\u0011\u0010\u000eR\u0017\u0010\u0007\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0007\u0010\f\u001a\u0004\b\u0012\u0010\u000eR\u0017\u0010\t\u001a\u00020\b8\u0006¢\u0006\f\n\u0004\b\t\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u001d\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00170\u00168\u0006¢\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001bR\u0017\u0010\u001d\u001a\u00020\u001c8\u0006¢\u0006\f\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 R\u0017\u0010\"\u001a\u00020!8\u0006¢\u0006\f\n\u0004\b\"\u0010#\u001a\u0004\b$\u0010%R\u0017\u0010&\u001a\u00020!8\u0006¢\u0006\f\n\u0004\b&\u0010#\u001a\u0004\b'\u0010%R\u0017\u0010(\u001a\u00020!8\u0006¢\u0006\f\n\u0004\b(\u0010#\u001a\u0004\b)\u0010%R\u0017\u0010*\u001a\u00020!8\u0006¢\u0006\f\n\u0004\b*\u0010#\u001a\u0004\b+\u0010%R\u0017\u0010-\u001a\u00020,8\u0006¢\u0006\f\n\u0004\b-\u0010.\u001a\u0004\b/\u00100R\"\u00101\u001a\u00020,8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b1\u0010.\u001a\u0004\b2\u00100\"\u0004\b3\u00104R$\u00106\u001a\u0004\u0018\u0001058\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b6\u00107\u001a\u0004\b8\u00109\"\u0004\b:\u0010;R\"\u0010<\u001a\u00020,8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b<\u0010.\u001a\u0004\b=\u00100\"\u0004\b>\u00104R\"\u0010?\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b?\u0010\f\u001a\u0004\b@\u0010\u000e\"\u0004\bA\u0010BR\"\u0010C\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bC\u0010\f\u001a\u0004\bD\u0010\u000e\"\u0004\bE\u0010B¨\u0006F"}, d2 = {"Lcom/stepos/ailauncher/speech/tts/StreamingPcmPlayer$c;", "", "", "id", "sampleRate", "channelCount", "encoding", "trackBufferBytes", "Landroid/media/AudioTrack;", "track", "<init>", "(IIIIILandroid/media/AudioTrack;)V", "I", Const.INTENT_KEY_UMID, "()I", "l", Const.INTENT_KEY_PKGNAME, "c", "p", "Landroid/media/AudioTrack;", "o", "()Landroid/media/AudioTrack;", "Ljava/util/concurrent/ConcurrentLinkedQueue;", "", "queue", "Ljava/util/concurrent/ConcurrentLinkedQueue;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_REMOVE, "()Ljava/util/concurrent/ConcurrentLinkedQueue;", "Ljava/util/concurrent/atomic/AtomicInteger;", "queuedBytes", "Ljava/util/concurrent/atomic/AtomicInteger;", "k", "()Ljava/util/concurrent/atomic/AtomicInteger;", "Ljava/util/concurrent/atomic/AtomicBoolean;", "stopRequested", "Ljava/util/concurrent/atomic/AtomicBoolean;", "m", "()Ljava/util/concurrent/atomic/AtomicBoolean;", "inputClosed", "e", "playbackStarted", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "playbackPaused", Const.INTENT_KEY_BACKGROUND_COMMAND, "", "armedAtMs", "J", Const.INTENT_KEY_APIKEY, "()J", "playbackStartedAtMs", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "t", "(J)V", "Lkotlinx/coroutines/g;", "writerJob", "Lkotlinx/coroutines/g;", "r", "()Lkotlinx/coroutines/g;", "w", "(Lkotlinx/coroutines/g;)V", "totalBytesWrittenToTrack", "n", "u", "lastUnderrunCount", "f", "s", "(I)V", "underrunTotal", "q", "v", "speech_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class c {
        private final long armedAtMs;
        private final int channelCount;
        private final int encoding;
        private final int id;
        private final AtomicBoolean inputClosed;
        private int lastUnderrunCount;
        private final AtomicBoolean playbackPaused;
        private final AtomicBoolean playbackStarted;
        private volatile long playbackStartedAtMs;
        private final ConcurrentLinkedQueue<byte[]> queue;
        private final AtomicInteger queuedBytes;
        private final int sampleRate;
        private final AtomicBoolean stopRequested;
        private long totalBytesWrittenToTrack;
        private final AudioTrack track;
        private final int trackBufferBytes;
        private int underrunTotal;
        private volatile kotlinx.coroutines.g writerJob;

        public c(int i10, int i11, int i12, int i13, int i14, AudioTrack track) {
            kotlin.jvm.internal.p.i(track, "track");
            this.id = i10;
            this.sampleRate = i11;
            this.channelCount = i12;
            this.encoding = i13;
            this.trackBufferBytes = i14;
            this.track = track;
            this.queue = new ConcurrentLinkedQueue<>();
            this.queuedBytes = new AtomicInteger(0);
            this.stopRequested = new AtomicBoolean(false);
            this.inputClosed = new AtomicBoolean(false);
            this.playbackStarted = new AtomicBoolean(false);
            this.playbackPaused = new AtomicBoolean(false);
            this.armedAtMs = SystemClock.elapsedRealtime();
        }

        /* renamed from: a, reason: from getter */
        public final long getArmedAtMs() {
            return this.armedAtMs;
        }

        /* renamed from: b, reason: from getter */
        public final int getChannelCount() {
            return this.channelCount;
        }

        /* renamed from: c, reason: from getter */
        public final int getEncoding() {
            return this.encoding;
        }

        /* renamed from: d, reason: from getter */
        public final int getId() {
            return this.id;
        }

        /* renamed from: e, reason: from getter */
        public final AtomicBoolean getInputClosed() {
            return this.inputClosed;
        }

        /* renamed from: f, reason: from getter */
        public final int getLastUnderrunCount() {
            return this.lastUnderrunCount;
        }

        /* renamed from: g, reason: from getter */
        public final AtomicBoolean getPlaybackPaused() {
            return this.playbackPaused;
        }

        /* renamed from: h, reason: from getter */
        public final AtomicBoolean getPlaybackStarted() {
            return this.playbackStarted;
        }

        /* renamed from: i, reason: from getter */
        public final long getPlaybackStartedAtMs() {
            return this.playbackStartedAtMs;
        }

        public final ConcurrentLinkedQueue<byte[]> j() {
            return this.queue;
        }

        /* renamed from: k, reason: from getter */
        public final AtomicInteger getQueuedBytes() {
            return this.queuedBytes;
        }

        /* renamed from: l, reason: from getter */
        public final int getSampleRate() {
            return this.sampleRate;
        }

        /* renamed from: m, reason: from getter */
        public final AtomicBoolean getStopRequested() {
            return this.stopRequested;
        }

        /* renamed from: n, reason: from getter */
        public final long getTotalBytesWrittenToTrack() {
            return this.totalBytesWrittenToTrack;
        }

        /* renamed from: o, reason: from getter */
        public final AudioTrack getTrack() {
            return this.track;
        }

        /* renamed from: p, reason: from getter */
        public final int getTrackBufferBytes() {
            return this.trackBufferBytes;
        }

        /* renamed from: q, reason: from getter */
        public final int getUnderrunTotal() {
            return this.underrunTotal;
        }

        /* renamed from: r, reason: from getter */
        public final kotlinx.coroutines.g getWriterJob() {
            return this.writerJob;
        }

        public final void s(int i10) {
            this.lastUnderrunCount = i10;
        }

        public final void t(long j10) {
            this.playbackStartedAtMs = j10;
        }

        public final void u(long j10) {
            this.totalBytesWrittenToTrack = j10;
        }

        public final void v(int i10) {
            this.underrunTotal = i10;
        }

        public final void w(kotlinx.coroutines.g gVar) {
            this.writerJob = gVar;
        }
    }

    public StreamingPcmPlayer(M scope, String tag) {
        kotlin.jvm.internal.p.i(scope, "scope");
        kotlin.jvm.internal.p.i(tag, "tag");
        this.scope = scope;
        this.tag = tag;
        this.stateLock = new Object();
        this.nextSessionId = new AtomicInteger(0);
        this.lastPlaybackStartDelayMs = -1L;
        this.holdPaused = new AtomicBoolean(false);
        this.duckGain = 1.0f;
    }

    public static final int C(int i10, int i11) {
        return C5685n.f(i11 - i10, 0);
    }

    public final void A() {
        synchronized (this.stateLock) {
            c cVar = this.activeSession;
            if (cVar == null) {
                return;
            }
            u(cVar);
            this.activeSession = null;
            y(cVar.getTrack());
            kotlinx.coroutines.g writerJob = cVar.getWriterJob();
            if (writerJob != null) {
                kotlinx.coroutines.g.Y0(writerJob, null, 1, null);
            }
        }
    }

    public final void B(c session, final int count) {
        session.getQueuedBytes().updateAndGet(new IntUnaryOperator() { // from class: com.stepos.ailauncher.speech.tts.k
            @Override // java.util.function.IntUnaryOperator
            public final int applyAsInt(int i10) {
                return StreamingPcmPlayer.C(count, i10);
            }
        });
    }

    public final int D() {
        c cVar = this.activeSession;
        return cVar != null ? cVar.getUnderrunTotal() : this.lastUnderrunTotal;
    }

    public final int E(c session, long durationMs) {
        return C5685n.f((int) (e(session) * durationMs), 1);
    }

    /*  JADX ERROR: JadxRuntimeException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Not found exit edge by exit block: B:34:0x00bc
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.checkLoopExits(LoopRegionMaker.java:225)
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.makeLoopRegion(LoopRegionMaker.java:195)
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.process(LoopRegionMaker.java:62)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:89)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:66)
        	at jadx.core.dex.visitors.regions.maker.SwitchRegionMaker.processFallThroughCases(SwitchRegionMaker.java:105)
        	at jadx.core.dex.visitors.regions.maker.SwitchRegionMaker.process(SwitchRegionMaker.java:64)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:112)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:66)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeMthRegion(RegionMaker.java:48)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:25)
        */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Path cross not found for [B:154:0x0432, B:140:0x039c], limit reached: 273 */
    /* JADX WARN: Path cross not found for [B:80:0x0203, B:101:0x02dc], limit reached: 273 */
    /* JADX WARN: Removed duplicated region for block: B:173:0x04b4  */
    /* JADX WARN: Removed duplicated region for block: B:176:0x04ba  */
    /* JADX WARN: Removed duplicated region for block: B:177:0x04bd  */
    /* JADX WARN: Removed duplicated region for block: B:185:0x0551  */
    /* JADX WARN: Removed duplicated region for block: B:192:0x0587  */
    /* JADX WARN: Removed duplicated region for block: B:278:0x05a5 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0017  */
    /* JADX WARN: Type inference failed for: r7v0 */
    /* JADX WARN: Type inference failed for: r7v27 */
    /* JADX WARN: Type inference failed for: r7v28 */
    /* JADX WARN: Type inference failed for: r7v9, types: [boolean, int] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:133:0x0379 -> B:76:0x01f3). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:151:0x0410 -> B:76:0x01f3). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:152:0x0412 -> B:76:0x01f3). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:162:0x0485 -> B:76:0x01f3). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:165:0x049f -> B:76:0x01f3). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:74:0x01ef -> B:76:0x01f3). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:89:0x0237 -> B:76:0x01f3). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:99:0x02d8 -> B:76:0x01f3). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object F(com.stepos.ailauncher.speech.tts.StreamingPcmPlayer.c r27, e9.InterfaceC4014c<? super Y8.t> r28) {
        /*
            Method dump skipped, instructions count: 1820
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.ailauncher.speech.tts.StreamingPcmPlayer.F(com.stepos.ailauncher.speech.tts.StreamingPcmPlayer$c, e9.c):java.lang.Object");
    }

    /* JADX WARN: Code restructure failed: missing block: B:35:0x00ab, code lost:
    
        if (Ua.U.a(100, r0) == r1) goto L36;
     */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object c(e9.InterfaceC4014c<? super Y8.t> r9) throws java.lang.Throwable {
        /*
            r8 = this;
            boolean r0 = r9 instanceof com.stepos.ailauncher.speech.tts.StreamingPcmPlayer$awaitPlaybackEnded$1
            if (r0 == 0) goto L13
            r0 = r9
            com.stepos.ailauncher.speech.tts.StreamingPcmPlayer$awaitPlaybackEnded$1 r0 = (com.stepos.ailauncher.speech.tts.StreamingPcmPlayer$awaitPlaybackEnded$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.stepos.ailauncher.speech.tts.StreamingPcmPlayer$awaitPlaybackEnded$1 r0 = new com.stepos.ailauncher.speech.tts.StreamingPcmPlayer$awaitPlaybackEnded$1
            r0.<init>(r8, r9)
        L18:
            java.lang.Object r9 = r0.result
            java.lang.Object r1 = f9.C4063a.g()
            int r2 = r0.label
            r3 = 0
            r4 = 2
            r5 = 1
            if (r2 == 0) goto L50
            if (r2 == r5) goto L3e
            if (r2 != r4) goto L36
            java.lang.Object r8 = r0.L$1
            kotlinx.coroutines.g r8 = (kotlinx.coroutines.g) r8
            java.lang.Object r8 = r0.L$0
            com.stepos.ailauncher.speech.tts.StreamingPcmPlayer$c r8 = (com.stepos.ailauncher.speech.tts.StreamingPcmPlayer.c) r8
            kotlin.C4849c.b(r9)
            goto Lae
        L36:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r9)
            throw r8
        L3e:
            java.lang.Object r8 = r0.L$2
            com.stepos.ailauncher.speech.tts.StreamingPcmPlayer r8 = (com.stepos.ailauncher.speech.tts.StreamingPcmPlayer) r8
            java.lang.Object r8 = r0.L$1
            kotlinx.coroutines.g r8 = (kotlinx.coroutines.g) r8
            java.lang.Object r2 = r0.L$0
            com.stepos.ailauncher.speech.tts.StreamingPcmPlayer$c r2 = (com.stepos.ailauncher.speech.tts.StreamingPcmPlayer.c) r2
            kotlin.C4849c.b(r9)     // Catch: java.lang.Throwable -> L4e
            goto L80
        L4e:
            r9 = move-exception
            goto L8b
        L50:
            kotlin.C4849c.b(r9)
            com.stepos.ailauncher.speech.tts.StreamingPcmPlayer$c r2 = r8.activeSession
            if (r2 == 0) goto L5c
            kotlinx.coroutines.g r9 = r2.getWriterJob()
            goto L5d
        L5c:
            r9 = r3
        L5d:
            if (r9 == 0) goto L95
            kotlin.Result$a r6 = kotlin.Result.INSTANCE     // Catch: java.lang.Throwable -> L87
            java.lang.Object r6 = g9.h.a(r2)     // Catch: java.lang.Throwable -> L87
            r0.L$0 = r6     // Catch: java.lang.Throwable -> L87
            java.lang.Object r6 = g9.h.a(r9)     // Catch: java.lang.Throwable -> L87
            r0.L$1 = r6     // Catch: java.lang.Throwable -> L87
            java.lang.Object r8 = g9.h.a(r8)     // Catch: java.lang.Throwable -> L87
            r0.L$2 = r8     // Catch: java.lang.Throwable -> L87
            r8 = 0
            r0.I$0 = r8     // Catch: java.lang.Throwable -> L87
            r0.label = r5     // Catch: java.lang.Throwable -> L87
            java.lang.Object r8 = r9.T0(r0)     // Catch: java.lang.Throwable -> L87
            if (r8 != r1) goto L7f
            goto Lad
        L7f:
            r8 = r9
        L80:
            Y8.t r9 = Y8.t.f7040a     // Catch: java.lang.Throwable -> L4e
            kotlin.Result.b(r9)     // Catch: java.lang.Throwable -> L4e
        L85:
            r9 = r8
            goto L95
        L87:
            r8 = move-exception
            r7 = r9
            r9 = r8
            r8 = r7
        L8b:
            kotlin.Result$a r5 = kotlin.Result.INSTANCE
            java.lang.Object r9 = kotlin.C4849c.a(r9)
            kotlin.Result.b(r9)
            goto L85
        L95:
            java.lang.Object r8 = g9.h.a(r2)
            r0.L$0 = r8
            java.lang.Object r8 = g9.h.a(r9)
            r0.L$1 = r8
            r0.L$2 = r3
            r0.label = r4
            r8 = 100
            java.lang.Object r8 = Ua.U.a(r8, r0)
            if (r8 != r1) goto Lae
        Lad:
            return r1
        Lae:
            Y8.t r8 = Y8.t.f7040a
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.ailauncher.speech.tts.StreamingPcmPlayer.c(e9.c):java.lang.Object");
    }

    public final int d(c session) {
        return session.getChannelCount() * (session.getEncoding() != 4 ? 2 : 4);
    }

    public final long e(c session) {
        return C5685n.g((session.getSampleRate() * d(session)) / 1000, 1L);
    }

    public final CreatedTrack f(int sampleRate, int channelCount, int encoding) throws UnsupportedOperationException {
        Object objB;
        int i10 = channelCount == 2 ? 12 : 4;
        int i11 = channelCount * (encoding != 4 ? 2 : 4);
        int iF = C5685n.f(AudioTrack.getMinBufferSize(sampleRate, i10, encoding), (sampleRate / 10) * i11);
        long j10 = sampleRate * i11;
        int iF2 = C5685n.f((int) ((800 * j10) / 1000), iF);
        AudioTrack audioTrackBuild = new AudioTrack.Builder().setAudioAttributes(new AudioAttributes.Builder().setUsage(16).setContentType(1).setFlags(1).build()).setAudioFormat(new AudioFormat.Builder().setSampleRate(sampleRate).setEncoding(encoding).setChannelMask(i10).build()).setTransferMode(1).setBufferSizeInBytes(iF2).build();
        kotlin.jvm.internal.p.h(audioTrackBuild, "build(...)");
        try {
            Result.Companion companion = Result.INSTANCE;
            objB = Result.b(Integer.valueOf(audioTrackBuild.setVolume(this.duckGain)));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objB = Result.b(C4849c.a(th));
        }
        Throwable thE = Result.e(objB);
        if (thE != null) {
            Log.w(this.tag, "pcm apply duckGain failed", thE);
        }
        Log.i(this.tag, "pcm AudioTrack buffer minBuffer=" + iF + " bufferSize=" + iF2 + " (~" + ((iF2 * 1000) / j10) + "ms)");
        return new CreatedTrack(audioTrackBuild, iF2);
    }

    public final boolean g(byte[] pcm) {
        kotlin.jvm.internal.p.i(pcm, "pcm");
        c cVar = this.activeSession;
        if (cVar == null || cVar.getStopRequested().get()) {
            return false;
        }
        cVar.j().offer(pcm);
        cVar.getQueuedBytes().addAndGet(pcm.length);
        if (this.activeSession == cVar && !cVar.getStopRequested().get()) {
            return true;
        }
        if (cVar.j().remove(pcm)) {
            B(cVar, pcm.length);
        }
        return false;
    }

    public final void h() {
        Object objB;
        this.holdPaused.set(true);
        c cVar = this.activeSession;
        if (cVar == null) {
            return;
        }
        try {
            Result.Companion companion = Result.INSTANCE;
            if (cVar.getTrack().getPlayState() == 3) {
                cVar.getTrack().pause();
            }
            objB = Result.b(t.f7040a);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objB = Result.b(C4849c.a(th));
        }
        Throwable thE = Result.e(objB);
        if (thE != null) {
            Log.w(this.tag, "pcm holdPause failed", thE);
        }
        Log.i(this.tag, "pcm holdPause session=" + cVar.getId());
    }

    public final boolean i(c session) {
        return this.activeSession == session && !session.getStopRequested().get();
    }

    public final boolean j() {
        AtomicBoolean stopRequested;
        c cVar = this.activeSession;
        return (cVar == null || (stopRequested = cVar.getStopRequested()) == null || stopRequested.get()) ? false : true;
    }

    public final void k() {
        AtomicBoolean inputClosed;
        c cVar = this.activeSession;
        if (cVar == null || (inputClosed = cVar.getInputClosed()) == null) {
            return;
        }
        inputClosed.set(true);
    }

    public final int l(c session) {
        return E(session, 80L);
    }

    public final int m(int encoding) {
        if (encoding == 2 || encoding == 4) {
            return encoding;
        }
        return 2;
    }

    public final int n(c session) {
        return E(session, 150L);
    }

    public final long o(c session) {
        Object objB;
        try {
            Result.Companion companion = Result.INSTANCE;
            objB = Result.b(Long.valueOf(session.getTrack().getPlaybackHeadPosition()));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objB = Result.b(C4849c.a(th));
        }
        Throwable thE = Result.e(objB);
        if (thE != null) {
            Log.w(this.tag, "get playbackHeadPosition failed session=" + session.getId() + " stopRequested=" + session.getStopRequested().get(), thE);
        }
        if (Result.e(objB) != null) {
            return session.getQueuedBytes().get();
        }
        return C5685n.g(session.getTotalBytesWrittenToTrack() - (((Number) objB).longValue() * d(session)), 0L) + session.getQueuedBytes().get();
    }

    public final long p() {
        c cVar = this.activeSession;
        if (cVar == null) {
            return 0L;
        }
        if (cVar.getPlaybackStarted().get()) {
            return o(cVar) / e(cVar);
        }
        return Long.MAX_VALUE;
    }

    public final long q() {
        c cVar = this.activeSession;
        if (cVar == null) {
            return this.lastPlaybackStartDelayMs;
        }
        long playbackStartedAtMs = cVar.getPlaybackStartedAtMs();
        if (playbackStartedAtMs >= cVar.getArmedAtMs()) {
            return playbackStartedAtMs - cVar.getArmedAtMs();
        }
        return -1L;
    }

    public final void r(c session) {
        int iW = w(session);
        if (iW > session.getLastUnderrunCount()) {
            int lastUnderrunCount = iW - session.getLastUnderrunCount();
            session.v(session.getUnderrunTotal() + lastUnderrunCount);
            Log.w(this.tag, "audioTrack underrun session=" + session.getId() + " +" + lastUnderrunCount + " sessionTotal=" + session.getUnderrunTotal() + " trackCount=" + iW);
            session.s(iW);
        }
    }

    public final int s(c session) {
        return E(session, 800L);
    }

    public final void t() {
        c cVar;
        Object objB;
        if (!this.holdPaused.compareAndSet(true, false) || (cVar = this.activeSession) == null || cVar.getStopRequested().get()) {
            return;
        }
        if (cVar.getPlaybackStarted().get()) {
            try {
                Result.Companion companion = Result.INSTANCE;
                cVar.getTrack().play();
                objB = Result.b(t.f7040a);
            } catch (Throwable th) {
                Result.Companion companion2 = Result.INSTANCE;
                objB = Result.b(C4849c.a(th));
            }
            Throwable thE = Result.e(objB);
            if (thE != null) {
                Log.w(this.tag, "pcm releaseHoldPause play failed", thE);
            }
        }
        Log.i(this.tag, "pcm releaseHoldPause session=" + cVar.getId());
    }

    public final void u(c session) {
        this.holdPaused.set(false);
        this.duckGain = 1.0f;
        session.getStopRequested().set(true);
        session.getInputClosed().set(true);
        session.j().clear();
        session.getQueuedBytes().set(0);
    }

    public final int v(c session) {
        return E(session, 80L);
    }

    public final int w(c session) {
        Object objB;
        try {
            Result.Companion companion = Result.INSTANCE;
            objB = Result.b(Integer.valueOf(session.getTrack().getUnderrunCount()));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objB = Result.b(C4849c.a(th));
        }
        if (Result.e(objB) != null) {
            objB = Integer.valueOf(session.getLastUnderrunCount());
        }
        return ((Number) objB).intValue();
    }

    public final void x(float gain) {
        Object objB;
        float fM = C5685n.m(gain, 0.2f, 1.0f);
        if (fM == this.duckGain) {
            return;
        }
        this.duckGain = fM;
        c cVar = this.activeSession;
        if (cVar == null) {
            return;
        }
        try {
            Result.Companion companion = Result.INSTANCE;
            objB = Result.b(Integer.valueOf(cVar.getTrack().setVolume(this.duckGain)));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objB = Result.b(C4849c.a(th));
        }
        Throwable thE = Result.e(objB);
        if (thE != null) {
            Log.w(this.tag, "pcm setDuckGain failed", thE);
        }
    }

    public final void y(AudioTrack track) {
        Object objB;
        Object objB2;
        Object objB3;
        try {
            Result.Companion companion = Result.INSTANCE;
            if (track.getPlayState() == 3) {
                track.pause();
            }
            objB = Result.b(t.f7040a);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objB = Result.b(C4849c.a(th));
        }
        Throwable thE = Result.e(objB);
        if (thE != null) {
            Log.w(this.tag, "pcm track pause failed", thE);
        }
        try {
            track.flush();
            objB2 = Result.b(t.f7040a);
        } catch (Throwable th2) {
            Result.Companion companion3 = Result.INSTANCE;
            objB2 = Result.b(C4849c.a(th2));
        }
        Throwable thE2 = Result.e(objB2);
        if (thE2 != null) {
            Log.w(this.tag, "pcm track flush failed", thE2);
        }
        try {
            track.stop();
            objB3 = Result.b(t.f7040a);
        } catch (Throwable th3) {
            Result.Companion companion4 = Result.INSTANCE;
            objB3 = Result.b(C4849c.a(th3));
        }
        Throwable thE3 = Result.e(objB3);
        if (thE3 != null) {
            Log.w(this.tag, "pcm track stop failed", thE3);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v0, types: [T, com.stepos.ailauncher.speech.tts.StreamingPcmPlayer$c] */
    public final void z(int sampleRate, int channelCount, int encoding) {
        kotlinx.coroutines.g writerJob;
        c cVar;
        c cVar2;
        c cVar3;
        c cVar4;
        Integer numValueOf = Integer.valueOf(sampleRate);
        int iIntValue = numValueOf.intValue();
        c cVar5 = null;
        if (8000 > iIntValue || iIntValue >= 96001) {
            numValueOf = null;
        }
        int iIntValue2 = numValueOf != null ? numValueOf.intValue() : 24000;
        int iF = C5685n.f(channelCount, 1);
        int iM = m(encoding);
        Ref$ObjectRef ref$ObjectRef = new Ref$ObjectRef();
        synchronized (this.stateLock) {
            c cVar6 = this.activeSession;
            if (cVar6 == null || cVar6.getStopRequested().get()) {
                writerJob = null;
            } else {
                if (cVar6.getSampleRate() == iIntValue2 && cVar6.getChannelCount() == iF && cVar6.getEncoding() == iM) {
                    return;
                }
                u(cVar6);
                writerJob = cVar6.getWriterJob();
                this.activeSession = null;
            }
            CreatedTrack createdTrackF = f(iIntValue2, iF, iM);
            ?? cVar7 = new c(this.nextSessionId.incrementAndGet(), iIntValue2, iF, iM, createdTrackF.getBufferBytes(), createdTrackF.getTrack());
            ref$ObjectRef.f34820a = cVar7;
            this.activeSession = cVar7;
            T t10 = ref$ObjectRef.f34820a;
            if (t10 == 0) {
                kotlin.jvm.internal.p.A("session");
                cVar = null;
            } else {
                cVar = (c) t10;
            }
            cVar.w(C1060i.d(this.scope, null, CoroutineStart.UNDISPATCHED, new StreamingPcmPlayer$startIfNeeded$1$1(this, ref$ObjectRef, null), 1, null));
            t tVar = t.f7040a;
            if (writerJob != null) {
                kotlinx.coroutines.g.Y0(writerJob, null, 1, null);
            }
            String str = this.tag;
            T t11 = ref$ObjectRef.f34820a;
            if (t11 == 0) {
                kotlin.jvm.internal.p.A("session");
                cVar2 = null;
            } else {
                cVar2 = (c) t11;
            }
            int id = cVar2.getId();
            T t12 = ref$ObjectRef.f34820a;
            if (t12 == 0) {
                kotlin.jvm.internal.p.A("session");
                cVar3 = null;
            } else {
                cVar3 = (c) t12;
            }
            int sampleRate2 = cVar3.getSampleRate();
            T t13 = ref$ObjectRef.f34820a;
            if (t13 == 0) {
                kotlin.jvm.internal.p.A("session");
                cVar4 = null;
            } else {
                cVar4 = (c) t13;
            }
            int channelCount2 = cVar4.getChannelCount();
            T t14 = ref$ObjectRef.f34820a;
            if (t14 == 0) {
                kotlin.jvm.internal.p.A("session");
            } else {
                cVar5 = (c) t14;
            }
            Log.i(str, "pcm player armed session=" + id + " sampleRate=" + sampleRate2 + " channel=" + channelCount2 + " preBufferMs=800 trackBufferTargetMs=800 trackBufferBytes=" + cVar5.getTrackBufferBytes());
        }
    }
}
