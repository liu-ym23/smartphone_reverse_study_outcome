package com.stepos.ailauncher.speech.asr;

import Ua.C1060i;
import Ua.M;
import Ua.Y;
import Y8.t;
import Z8.C1165m;
import android.media.AudioRecord;
import android.os.Looper;
import com.autonavi.aps.amapapi.config.Const;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.jvm.internal.p;
import v9.C5685n;

@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0000\u0018\u0000 12\u00020\u0001:\u000223B7\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0004\u0012\u0006\u0010\t\u001a\u00020\b\u0012\u0006\u0010\n\u001a\u00020\u0004¢\u0006\u0004\b\u000b\u0010\fJ\r\u0010\u000e\u001a\u00020\r¢\u0006\u0004\b\u000e\u0010\u000fJ\r\u0010\u0011\u001a\u00020\u0010¢\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0014\u001a\u00020\u0013H\u0086@¢\u0006\u0004\b\u0014\u0010\u0015J\r\u0010\u0016\u001a\u00020\r¢\u0006\u0004\b\u0016\u0010\u000fJ\r\u0010\u0017\u001a\u00020\r¢\u0006\u0004\b\u0017\u0010\u000fR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0018\u001a\u0004\b\u0019\u0010\u001aR\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u001b\u001a\u0004\b\u001c\u0010\u001dR\u0014\u0010\u0006\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010\u001bR\u0014\u0010\u0007\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\u001bR\u0014\u0010\t\u001a\u00020\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010\u001eR\u0017\u0010\n\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\n\u0010\u001b\u001a\u0004\b\u001f\u0010\u001dR\u0014\u0010 \u001a\u00020\u00018\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b \u0010!R\u001a\u0010$\u001a\b\u0012\u0004\u0012\u00020#0\"8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b$\u0010%R\u0014\u0010'\u001a\u00020&8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b'\u0010(R\u0016\u0010)\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b)\u0010\u001bR\u0018\u0010+\u001a\u0004\u0018\u00010*8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b+\u0010,R\u0014\u0010-\u001a\u00020&8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b-\u0010(R\u0018\u0010/\u001a\u0004\u0018\u00010.8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b/\u00100¨\u00064"}, d2 = {"Lcom/stepos/ailauncher/speech/asr/MicCapturePrewarm;", "", "Landroid/media/AudioRecord;", com.stepos.ailauncher.chat.trace.h.OCCUPIED_RECORDER, "", "audioSource", "chunkSize", "ringFrames", "LUa/M;", "scope", "micToken", "<init>", "(Landroid/media/AudioRecord;IIILUa/M;I)V", "LY8/t;", "n", "()V", "", "l", "()Z", "Lcom/stepos/ailauncher/speech/asr/MicCapturePrewarm$b;", "o", "(Le9/c;)Ljava/lang/Object;", "p", "m", "Landroid/media/AudioRecord;", "k", "()Landroid/media/AudioRecord;", "I", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "()I", "LUa/M;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_REMOVE, "lock", "Ljava/lang/Object;", "LZ8/m;", "", "ring", "LZ8/m;", "Ljava/util/concurrent/atomic/AtomicBoolean;", "running", "Ljava/util/concurrent/atomic/AtomicBoolean;", "droppedFrames", "Lkotlinx/coroutines/g;", "job", "Lkotlinx/coroutines/g;", "released", "Ljava/util/concurrent/CountDownLatch;", "readerExitLatch", "Ljava/util/concurrent/CountDownLatch;", "Companion", Const.INTENT_KEY_APIKEY, Const.INTENT_KEY_PKGNAME, "speech_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class MicCapturePrewarm {
    private static final long RELEASE_JOIN_TIMEOUT_MAIN_MS = 50;
    private static final long RELEASE_JOIN_TIMEOUT_MS = 400;
    private static final String TAG = "AIEngineAsr";
    private final int audioSource;
    private final int chunkSize;
    private int droppedFrames;
    private kotlinx.coroutines.g job;
    private final Object lock;
    private final int micToken;
    private volatile CountDownLatch readerExitLatch;
    private final AudioRecord recorder;
    private final AtomicBoolean released;
    private final C1165m<byte[]> ring;
    private final int ringFrames;
    private final AtomicBoolean running;
    private final M scope;

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\b\b\u0086\b\u0018\u00002\u00020\u0001B\u001d\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\n\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\f\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u0010\u001a\u00020\u000f2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0010\u0010\u0011R\u001d\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u0017\u0010\u0006\u001a\u00020\u00058\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0015\u001a\u0004\b\u0016\u0010\r¨\u0006\u0017"}, d2 = {"Lcom/stepos/ailauncher/speech/asr/MicCapturePrewarm$b;", "", "", "", "frames", "", "droppedFrames", "<init>", "(Ljava/util/List;I)V", "", "toString", "()Ljava/lang/String;", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/util/List;", Const.INTENT_KEY_PKGNAME, "()Ljava/util/List;", "I", Const.INTENT_KEY_APIKEY, "speech_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.ailauncher.speech.asr.MicCapturePrewarm$b, reason: from toString */
    public static final /* data */ class Drain {
        private final int droppedFrames;
        private final List<byte[]> frames;

        public Drain(List<byte[]> frames, int i10) {
            p.i(frames, "frames");
            this.frames = frames;
            this.droppedFrames = i10;
        }

        /* renamed from: a, reason: from getter */
        public final int getDroppedFrames() {
            return this.droppedFrames;
        }

        public final List<byte[]> b() {
            return this.frames;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Drain)) {
                return false;
            }
            Drain drain = (Drain) other;
            return p.d(this.frames, drain.frames) && this.droppedFrames == drain.droppedFrames;
        }

        public int hashCode() {
            return (this.frames.hashCode() * 31) + Integer.hashCode(this.droppedFrames);
        }

        public String toString() {
            return "Drain(frames=" + this.frames + ", droppedFrames=" + this.droppedFrames + ")";
        }
    }

    public MicCapturePrewarm(AudioRecord recorder, int i10, int i11, int i12, M scope, int i13) {
        p.i(recorder, "recorder");
        p.i(scope, "scope");
        this.recorder = recorder;
        this.audioSource = i10;
        this.chunkSize = i11;
        this.ringFrames = i12;
        this.scope = scope;
        this.micToken = i13;
        this.lock = new Object();
        this.ring = new C1165m<>(C5685n.f(i12, 1));
        this.running = new AtomicBoolean(false);
        this.released = new AtomicBoolean(false);
    }

    /* renamed from: i, reason: from getter */
    public final int getAudioSource() {
        return this.audioSource;
    }

    /* renamed from: j, reason: from getter */
    public final int getMicToken() {
        return this.micToken;
    }

    /* renamed from: k, reason: from getter */
    public final AudioRecord getRecorder() {
        return this.recorder;
    }

    public final boolean l() {
        Object objB;
        boolean z10 = false;
        if (this.released.get()) {
            return false;
        }
        try {
            Result.Companion companion = Result.INSTANCE;
            if (this.recorder.getState() == 1 && this.recorder.getRecordingState() == 3) {
                z10 = true;
            }
            objB = Result.b(Boolean.valueOf(z10));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objB = Result.b(C4849c.a(th));
        }
        Boolean bool = Boolean.FALSE;
        if (Result.g(objB)) {
            objB = bool;
        }
        return ((Boolean) objB).booleanValue();
    }

    public final void m() throws InterruptedException {
        if (this.released.compareAndSet(false, true)) {
            this.running.set(false);
            CountDownLatch countDownLatch = this.readerExitLatch;
            try {
                Result.Companion companion = Result.INSTANCE;
                this.recorder.stop();
                Result.b(t.f7040a);
            } catch (Throwable th) {
                Result.Companion companion2 = Result.INSTANCE;
                Result.b(C4849c.a(th));
            }
            long j10 = p.d(Looper.myLooper(), Looper.getMainLooper()) ? 50L : 400L;
            if (countDownLatch != null) {
                countDownLatch.await(j10, TimeUnit.MILLISECONDS);
            }
            kotlinx.coroutines.g gVar = this.job;
            if (gVar != null) {
                kotlinx.coroutines.g.Y0(gVar, null, 1, null);
            }
            this.job = null;
            synchronized (this.lock) {
                this.ring.clear();
                t tVar = t.f7040a;
            }
            try {
                this.recorder.release();
                Result.b(t.f7040a);
            } catch (Throwable th2) {
                Result.Companion companion3 = Result.INSTANCE;
                Result.b(C4849c.a(th2));
            }
        }
    }

    public final void n() {
        if (this.running.compareAndSet(false, true)) {
            CountDownLatch countDownLatch = new CountDownLatch(1);
            this.readerExitLatch = countDownLatch;
            this.job = C1060i.d(this.scope, Y.b(), null, new MicCapturePrewarm$startReading$1(this, countDownLatch, null), 2, null);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object o(e9.InterfaceC4014c<? super com.stepos.ailauncher.speech.asr.MicCapturePrewarm.Drain> r8) throws java.lang.Throwable {
        /*
            r7 = this;
            boolean r0 = r8 instanceof com.stepos.ailauncher.speech.asr.MicCapturePrewarm$stopAndDrain$1
            if (r0 == 0) goto L13
            r0 = r8
            com.stepos.ailauncher.speech.asr.MicCapturePrewarm$stopAndDrain$1 r0 = (com.stepos.ailauncher.speech.asr.MicCapturePrewarm$stopAndDrain$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.stepos.ailauncher.speech.asr.MicCapturePrewarm$stopAndDrain$1 r0 = new com.stepos.ailauncher.speech.asr.MicCapturePrewarm$stopAndDrain$1
            r0.<init>(r7, r8)
        L18:
            java.lang.Object r8 = r0.result
            java.lang.Object r1 = f9.C4063a.g()
            int r2 = r0.label
            r3 = 0
            r4 = 1
            if (r2 == 0) goto L32
            if (r2 != r4) goto L2a
            kotlin.C4849c.b(r8)
            goto L47
        L2a:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L32:
            kotlin.C4849c.b(r8)
            java.util.concurrent.atomic.AtomicBoolean r8 = r7.running
            r8.set(r3)
            kotlinx.coroutines.g r8 = r7.job
            if (r8 == 0) goto L47
            r0.label = r4
            java.lang.Object r8 = r8.T0(r0)
            if (r8 != r1) goto L47
            return r1
        L47:
            r8 = 0
            r7.job = r8
            java.lang.Object r0 = r7.lock
            monitor-enter(r0)
            Z8.m<byte[]> r1 = r7.ring     // Catch: java.lang.Throwable -> L90
            java.util.List r1 = Z8.F.m1(r1)     // Catch: java.lang.Throwable -> L90
            Z8.m<byte[]> r2 = r7.ring     // Catch: java.lang.Throwable -> L90
            r2.clear()     // Catch: java.lang.Throwable -> L90
            int r2 = r7.droppedFrames     // Catch: java.lang.Throwable -> L90
            Y8.t r4 = Y8.t.f7040a     // Catch: java.lang.Throwable -> L90
            monitor-exit(r0)
            java.lang.String r0 = "AIEngineAsr"
            int r4 = r1.size()
            int r7 = r7.audioSource
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            java.lang.String r6 = "micPrewarm drain: frames="
            r5.append(r6)
            r5.append(r4)
            java.lang.String r4 = " dropped="
            r5.append(r4)
            r5.append(r2)
            java.lang.String r4 = " source="
            r5.append(r4)
            r5.append(r7)
            java.lang.String r7 = r5.toString()
            r4 = 4
            h8.C4148a.k(r0, r7, r3, r4, r8)
            com.stepos.ailauncher.speech.asr.MicCapturePrewarm$b r7 = new com.stepos.ailauncher.speech.asr.MicCapturePrewarm$b
            r7.<init>(r1, r2)
            return r7
        L90:
            r7 = move-exception
            monitor-exit(r0)
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.ailauncher.speech.asr.MicCapturePrewarm.o(e9.c):java.lang.Object");
    }

    public final void p() {
        this.running.set(false);
        try {
            Result.Companion companion = Result.INSTANCE;
            this.recorder.stop();
            Result.b(t.f7040a);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            Result.b(C4849c.a(th));
        }
        kotlinx.coroutines.g gVar = this.job;
        if (gVar != null) {
            kotlinx.coroutines.g.Y0(gVar, null, 1, null);
        }
        this.job = null;
    }
}
