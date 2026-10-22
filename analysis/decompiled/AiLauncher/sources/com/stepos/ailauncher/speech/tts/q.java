package com.stepos.ailauncher.speech.tts;

import La.H;
import Y8.t;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.os.SystemClock;
import android.util.Log;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.statsapp.v3.lib.plugin.constants.UxipConstants;
import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import p9.InterfaceC5063a;
import p9.InterfaceC5074l;
import v9.C5685n;

@Metadata(d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010 \n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000e\b\u0000\u0018\u0000 Q2\u00020\u00012\u00020\u0002:\u0003R$SBo\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\n0\t\u0012\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\f\u0012\u000e\b\u0002\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00050\f\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0007\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0007¢\u0006\u0004\b\u0013\u0010\u0014J\u000f\u0010\u0015\u001a\u00020\rH\u0014¢\u0006\u0004\b\u0015\u0010\u0016J\r\u0010\u0017\u001a\u00020\r¢\u0006\u0004\b\u0017\u0010\u0016J\u0015\u0010\u0019\u001a\u00020\r2\u0006\u0010\u0018\u001a\u00020\u0003¢\u0006\u0004\b\u0019\u0010\u001aJ\r\u0010\u001b\u001a\u00020\r¢\u0006\u0004\b\u001b\u0010\u0016J\u001b\u0010\u001e\u001a\u00020\r2\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00030\u001c¢\u0006\u0004\b\u001e\u0010\u001fJ\r\u0010 \u001a\u00020\r¢\u0006\u0004\b \u0010\u0016J\u0017\u0010\"\u001a\u00020\r2\b\b\u0002\u0010!\u001a\u00020\n¢\u0006\u0004\b\"\u0010#J\r\u0010$\u001a\u00020\r¢\u0006\u0004\b$\u0010\u0016J\r\u0010%\u001a\u00020\u0005¢\u0006\u0004\b%\u0010&J\r\u0010'\u001a\u00020\n¢\u0006\u0004\b'\u0010(J\u0017\u0010+\u001a\u00020\n2\u0006\u0010*\u001a\u00020)H\u0016¢\u0006\u0004\b+\u0010,J\u000f\u0010-\u001a\u00020\rH\u0002¢\u0006\u0004\b-\u0010\u0016J\u0019\u00100\u001a\u0004\u0018\u00010/2\u0006\u0010.\u001a\u00020\u0005H\u0002¢\u0006\u0004\b0\u00101J\u0019\u00103\u001a\u00020\r2\b\b\u0002\u00102\u001a\u00020\u0007H\u0002¢\u0006\u0004\b3\u00104R\u0014\u0010\u0004\u001a\u00020\u00038\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0004\u00105R\u0014\u0010\u0006\u001a\u00020\u00058\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0006\u00106R\u0014\u0010\b\u001a\u00020\u00078\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\b\u00107R \u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\n0\t8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000b\u00108R\u001a\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000e\u00109R\u001a\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00050\f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000f\u00109R\u0014\u0010\u0010\u001a\u00020\u00078\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0010\u00107R\u0014\u0010\u0011\u001a\u00020\u00058\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0011\u00106R\u0014\u0010\u0012\u001a\u00020\u00078\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0012\u00107R\u001a\u0010<\u001a\b\u0012\u0004\u0012\u00020;0:8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b<\u0010=R\u0014\u0010?\u001a\u00020>8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b?\u0010@R\u0014\u0010B\u001a\u00020A8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bB\u0010CR\u0016\u0010D\u001a\u00020\n8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bD\u0010ER\u0018\u0010G\u001a\u0004\u0018\u00010F8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bG\u0010HR\u0016\u0010I\u001a\u00020\n8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bI\u0010ER\u0016\u0010J\u001a\u00020\n8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bJ\u0010ER\u0016\u0010K\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bK\u00107R$\u0010M\u001a\u00020\n2\u0006\u0010L\u001a\u00020\n8\u0006@BX\u0086\u000e¢\u0006\f\n\u0004\bM\u0010E\u001a\u0004\bN\u0010(R$\u0010O\u001a\u00020\n2\u0006\u0010L\u001a\u00020\n8\u0006@BX\u0086\u000e¢\u0006\f\n\u0004\bO\u0010E\u001a\u0004\bP\u0010(¨\u0006T"}, d2 = {"Lcom/stepos/ailauncher/speech/tts/q;", "Landroid/os/HandlerThread;", "Landroid/os/Handler$Callback;", "", "tag", "", "maxFeedChars", "", "feedIntervalMs", "Lkotlin/Function1;", "", "onText", "Lkotlin/Function0;", "LY8/t;", "onEnd", "nextFeedCharBudget", "feedRetryMs", "minFeedChars", "continuationForceMs", "<init>", "(Ljava/lang/String;IJLp9/l;Lp9/a;Lp9/a;JIJ)V", "onLooperPrepared", "()V", "q", "text", "l", "(Ljava/lang/String;)V", "k", "", "batches", "n", "(Ljava/util/List;)V", "m", "force", Const.INTENT_KEY_BACKGROUND_COMMAND, "(Z)V", "c", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "()I", "f", "()Z", "Landroid/os/Message;", "msg", "handleMessage", "(Landroid/os/Message;)Z", Const.INTENT_KEY_UMID, "limitChars", "Lcom/stepos/ailauncher/speech/tts/q$b;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_REMOVE, "(I)Lcom/stepos/ailauncher/speech/tts/q$b;", "delayMs", "o", "(J)V", "Ljava/lang/String;", "I", "J", "Lp9/l;", "Lp9/a;", "Ljava/util/ArrayDeque;", "Lcom/stepos/ailauncher/speech/tts/q$c;", "msgQueue", "Ljava/util/ArrayDeque;", "Ljava/util/concurrent/atomic/AtomicBoolean;", "cancelled", "Ljava/util/concurrent/atomic/AtomicBoolean;", "", "pauseLock", "Ljava/lang/Object;", "consumePaused", "Z", "Landroid/os/Handler;", "threadHandler", "Landroid/os/Handler;", "lastBatchOpenSentence", "awaitingMoreText", "lastFeedAtMs", UxipConstants.f30680s, "endPosted", "getEndPosted", "endConsumed", "e", "Companion", Const.INTENT_KEY_APIKEY, Const.INTENT_KEY_PKGNAME, "speech_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class q extends HandlerThread implements Handler.Callback {
    private static final int MSG_CONSUME = 1;
    private boolean awaitingMoreText;
    private final AtomicBoolean cancelled;
    private boolean consumePaused;
    private final long continuationForceMs;
    private volatile boolean endConsumed;
    private volatile boolean endPosted;
    private final long feedIntervalMs;
    private final long feedRetryMs;
    private volatile boolean lastBatchOpenSentence;
    private volatile long lastFeedAtMs;
    private final int maxFeedChars;
    private final int minFeedChars;
    private final ArrayDeque<c> msgQueue;
    private final InterfaceC5063a<Integer> nextFeedCharBudget;
    private final InterfaceC5063a<t> onEnd;
    private final InterfaceC5074l<String, Boolean> onText;
    private final Object pauseLock;
    private final String tag;
    private Handler threadHandler;

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0082\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0006\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\t\u0010\nJ\u001a\u0010\r\u001a\u00020\f2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\r\u0010\u000eR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u000f\u001a\u0004\b\u0010\u0010\u0007¨\u0006\u0011"}, d2 = {"Lcom/stepos/ailauncher/speech/tts/q$b;", "", "", "text", "<init>", "(Ljava/lang/String;)V", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", Const.INTENT_KEY_APIKEY, "speech_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.ailauncher.speech.tts.q$b, reason: from toString */
    public static final /* data */ class TextBatch {
        private final String text;

        public TextBatch(String text) {
            kotlin.jvm.internal.p.i(text, "text");
            this.text = text;
        }

        /* renamed from: a, reason: from getter */
        public final String getText() {
            return this.text;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof TextBatch) && kotlin.jvm.internal.p.d(this.text, ((TextBatch) other).text);
        }

        public int hashCode() {
            return this.text.hashCode();
        }

        public String toString() {
            return "TextBatch(text=" + this.text + ")";
        }
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\br\u0018\u00002\u00020\u0001:\u0002\u0002\u0003\u0082\u0001\u0002\u0004\u0005¨\u0006\u0006À\u0006\u0003"}, d2 = {"Lcom/stepos/ailauncher/speech/tts/q$c;", "", Const.INTENT_KEY_PKGNAME, Const.INTENT_KEY_APIKEY, "Lcom/stepos/ailauncher/speech/tts/q$c$a;", "Lcom/stepos/ailauncher/speech/tts/q$c$b;", "speech_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public interface c {

        @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\bÆ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0005\u001a\u00020\u0004HÖ\u0001¢\u0006\u0004\b\u0005\u0010\u0006J\u0010\u0010\b\u001a\u00020\u0007HÖ\u0001¢\u0006\u0004\b\b\u0010\tJ\u001a\u0010\r\u001a\u00020\f2\b\u0010\u000b\u001a\u0004\u0018\u00010\nHÖ\u0003¢\u0006\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"Lcom/stepos/ailauncher/speech/tts/q$c$a;", "Lcom/stepos/ailauncher/speech/tts/q$c;", "<init>", "()V", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "speech_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class a implements c {
            public static final a INSTANCE = new a();

            public boolean equals(Object other) {
                return this == other || (other instanceof a);
            }

            public int hashCode() {
                return 455042757;
            }

            public String toString() {
                return "End";
            }
        }

        @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0006\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\t\u0010\nJ\u001a\u0010\u000e\u001a\u00020\r2\b\u0010\f\u001a\u0004\u0018\u00010\u000bHÖ\u0003¢\u0006\u0004\b\u000e\u0010\u000fR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0010\u001a\u0004\b\u0011\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/stepos/ailauncher/speech/tts/q$c$b;", "Lcom/stepos/ailauncher/speech/tts/q$c;", "", "text", "<init>", "(Ljava/lang/String;)V", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", Const.INTENT_KEY_APIKEY, "speech_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
        /* renamed from: com.stepos.ailauncher.speech.tts.q$c$b, reason: from toString */
        public static final /* data */ class Text implements c {
            private final String text;

            public Text(String text) {
                kotlin.jvm.internal.p.i(text, "text");
                this.text = text;
            }

            /* renamed from: a, reason: from getter */
            public final String getText() {
                return this.text;
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof Text) && kotlin.jvm.internal.p.d(this.text, ((Text) other).text);
            }

            public int hashCode() {
                return this.text.hashCode();
            }

            public String toString() {
                return "Text(text=" + this.text + ")";
            }
        }
    }

    public /* synthetic */ q(String str, int i10, long j10, InterfaceC5074l interfaceC5074l, InterfaceC5063a interfaceC5063a, InterfaceC5063a interfaceC5063a2, long j11, int i11, long j12, int i12, kotlin.jvm.internal.i iVar) {
        final int i13;
        InterfaceC5063a interfaceC5063a3;
        if ((i12 & 32) != 0) {
            i13 = i10;
            interfaceC5063a3 = new InterfaceC5063a() { // from class: com.stepos.ailauncher.speech.tts.p
                @Override // p9.InterfaceC5063a
                public final Object invoke() {
                    return Integer.valueOf(q.b(i13));
                }
            };
        } else {
            i13 = i10;
            interfaceC5063a3 = interfaceC5063a2;
        }
        this(str, i13, j10, interfaceC5074l, interfaceC5063a, interfaceC5063a3, (i12 & 64) != 0 ? 80L : j11, (i12 & 128) != 0 ? 24 : i11, (i12 & 256) != 0 ? 1200L : j12);
    }

    public static final int b(int i10) {
        return i10;
    }

    public static /* synthetic */ void h(q qVar, boolean z10, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            z10 = false;
        }
        qVar.g(z10);
    }

    public static /* synthetic */ void p(q qVar, long j10, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            j10 = 0;
        }
        qVar.o(j10);
    }

    public final void c() {
        this.cancelled.set(true);
        synchronized (this.pauseLock) {
            this.msgQueue.clear();
            this.consumePaused = false;
            t tVar = t.f7040a;
        }
        Handler handler = this.threadHandler;
        if (handler != null) {
            handler.removeMessages(1);
        }
        quitSafely();
    }

    public final void d() {
        boolean z10;
        c cVarPollFirst;
        if (this.cancelled.get()) {
            return;
        }
        synchronized (this.pauseLock) {
            z10 = this.msgQueue.peekFirst() instanceof c.Text;
        }
        boolean z11 = z10 && this.lastBatchOpenSentence && this.lastFeedAtMs > 0 && SystemClock.elapsedRealtime() - this.lastFeedAtMs >= this.continuationForceMs;
        int iF = C5685n.f(this.nextFeedCharBudget.invoke().intValue(), 0);
        int iMax = Math.max(this.minFeedChars, 30);
        int iJ = C5685n.j(iF, this.maxFeedChars);
        if (z10 && iJ < iMax) {
            Log.d(this.tag, "feed backpressure: budget=" + iF + " < gate=" + iMax + " continuation=" + z11 + ", wait " + this.feedRetryMs + Const.SP_KEY_GSM_UPLOAD_MXSIZE);
            o(this.feedRetryMs);
            return;
        }
        TextBatch textBatchJ = j(iJ);
        if (textBatchJ == null) {
            synchronized (this.pauseLock) {
                cVarPollFirst = this.msgQueue.pollFirst();
            }
            if (cVarPollFirst == null) {
                this.consumePaused = true;
                return;
            }
            if (cVarPollFirst instanceof c.a) {
                this.endConsumed = true;
                this.onEnd.invoke();
                return;
            }
            if (!(cVarPollFirst instanceof c.Text)) {
                throw new NoWhenBranchMatchedException();
            }
            long jG = (!this.lastBatchOpenSentence || this.lastFeedAtMs <= 0) ? 0L : C5685n.g(this.continuationForceMs - (SystemClock.elapsedRealtime() - this.lastFeedAtMs), this.feedRetryMs);
            synchronized (this.pauseLock) {
                this.msgQueue.addFirst(cVarPollFirst);
                this.awaitingMoreText = true;
                this.consumePaused = jG <= 0;
                t tVar = t.f7040a;
            }
            if (jG > 0) {
                o(jG);
                return;
            }
            return;
        }
        if (!this.onText.invoke(textBatchJ.getText()).booleanValue()) {
            synchronized (this.pauseLock) {
                this.msgQueue.addFirst(new c.Text(textBatchJ.getText()));
                this.consumePaused = true;
                t tVar2 = t.f7040a;
            }
            Log.w(this.tag, "onText rejected, retry " + this.feedRetryMs + "ms queue=" + i());
            o(this.feedRetryMs);
            return;
        }
        this.lastFeedAtMs = SystemClock.elapsedRealtime();
        this.lastBatchOpenSentence = !o.INSTANCE.i(textBatchJ.getText());
        if (z11) {
            Log.i(this.tag, "sentence continuation forced len=" + textBatchJ.getText().length() + " budget=" + iF + " openSentence=" + this.lastBatchOpenSentence);
        }
        synchronized (this.pauseLock) {
            this.consumePaused = false;
            this.awaitingMoreText = false;
            t tVar3 = t.f7040a;
        }
        o(this.feedIntervalMs);
    }

    /* renamed from: e, reason: from getter */
    public final boolean getEndConsumed() {
        return this.endConsumed;
    }

    public final boolean f() {
        boolean zIsEmpty;
        if (!this.endConsumed) {
            return false;
        }
        synchronized (this.pauseLock) {
            zIsEmpty = this.msgQueue.isEmpty();
        }
        return zIsEmpty;
    }

    public final void g(boolean force) {
        synchronized (this.pauseLock) {
            boolean z10 = this.consumePaused;
            this.consumePaused = false;
            if (z10 || force) {
                p(this, 0L, 1, null);
            }
            t tVar = t.f7040a;
        }
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message msg) {
        kotlin.jvm.internal.p.i(msg, "msg");
        if (msg.what != 1) {
            return false;
        }
        d();
        return true;
    }

    public final int i() {
        int size;
        synchronized (this.pauseLock) {
            size = this.msgQueue.size();
        }
        return size;
    }

    public final TextBatch j(int limitChars) {
        int iF = C5685n.f(limitChars, 1);
        synchronized (this.pauseLock) {
            try {
                if (!(this.msgQueue.peekFirst() instanceof c.Text)) {
                    return null;
                }
                StringBuilder sb2 = new StringBuilder();
                while (this.msgQueue.peekFirst() instanceof c.Text) {
                    c cVarPollFirst = this.msgQueue.pollFirst();
                    kotlin.jvm.internal.p.g(cVarPollFirst, "null cannot be cast to non-null type com.stepos.ailauncher.speech.tts.TtsMessageHandler.TtsMsg.Text");
                    sb2.append(((c.Text) cVarPollFirst).getText());
                }
                if (sb2.length() == 0) {
                    return null;
                }
                String string = sb2.toString();
                kotlin.jvm.internal.p.h(string, "toString(...)");
                FeedSlice feedSliceR = o.INSTANCE.r(string, iF, this.endPosted);
                if (feedSliceR != null && feedSliceR.getConsumed() > 0) {
                    int iJ = C5685n.j(feedSliceR.getConsumed(), string.length());
                    if (iJ < string.length()) {
                        ArrayDeque<c> arrayDeque = this.msgQueue;
                        String strSubstring = string.substring(iJ);
                        kotlin.jvm.internal.p.h(strSubstring, "substring(...)");
                        arrayDeque.addFirst(new c.Text(strSubstring));
                    }
                    return new TextBatch(feedSliceR.getText());
                }
                if (!this.endPosted) {
                    this.msgQueue.addFirst(new c.Text(string));
                    return null;
                }
                int iF2 = C5685n.f(C5685n.j(string.length(), iF), 1);
                if (iF2 < string.length()) {
                    ArrayDeque<c> arrayDeque2 = this.msgQueue;
                    String strSubstring2 = string.substring(iF2);
                    kotlin.jvm.internal.p.h(strSubstring2, "substring(...)");
                    arrayDeque2.addFirst(new c.Text(strSubstring2));
                }
                String strSubstring3 = string.substring(0, iF2);
                kotlin.jvm.internal.p.h(strSubstring3, "substring(...)");
                return new TextBatch(strSubstring3);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void k() {
        if (this.cancelled.get()) {
            return;
        }
        this.endPosted = true;
        synchronized (this.pauseLock) {
            try {
                this.msgQueue.addLast(c.a.INSTANCE);
                if (this.consumePaused || this.awaitingMoreText) {
                    this.consumePaused = false;
                    this.awaitingMoreText = false;
                    p(this, 0L, 1, null);
                }
                t tVar = t.f7040a;
            } catch (Throwable th) {
                throw th;
            }
        }
        Log.d(this.tag, "postEndMsg queue=" + this.msgQueue.size());
    }

    public final void l(String text) {
        kotlin.jvm.internal.p.i(text, "text");
        if (H.x0(text) || this.cancelled.get()) {
            return;
        }
        synchronized (this.pauseLock) {
            try {
                this.msgQueue.addLast(new c.Text(text));
                if (this.consumePaused || this.awaitingMoreText) {
                    this.consumePaused = false;
                    this.awaitingMoreText = false;
                    p(this, 0L, 1, null);
                }
                t tVar = t.f7040a;
            } catch (Throwable th) {
                throw th;
            }
        }
        Log.d(this.tag, "postMsg length=" + text.length() + " queue=" + this.msgQueue.size());
    }

    public final void m() {
        if (this.cancelled.get() || !this.endConsumed) {
            return;
        }
        this.endConsumed = false;
        synchronized (this.pauseLock) {
            this.msgQueue.addLast(c.a.INSTANCE);
            this.consumePaused = false;
            this.awaitingMoreText = false;
            p(this, 0L, 1, null);
            t tVar = t.f7040a;
        }
        Log.i(this.tag, "reopenEndForResume queue=" + this.msgQueue.size());
    }

    public final void n(List<String> batches) {
        int length;
        kotlin.jvm.internal.p.i(batches, "batches");
        if (batches.isEmpty() || this.cancelled.get()) {
            return;
        }
        synchronized (this.pauseLock) {
            try {
                int size = batches.size() - 1;
                if (size >= 0) {
                    while (true) {
                        int i10 = size - 1;
                        String str = batches.get(size);
                        if (str.length() > 0) {
                            this.msgQueue.addFirst(new c.Text(str));
                        }
                        if (i10 < 0) {
                            break;
                        } else {
                            size = i10;
                        }
                    }
                }
                length = 0;
                this.lastBatchOpenSentence = false;
                this.consumePaused = false;
                this.awaitingMoreText = false;
                p(this, 0L, 1, null);
                t tVar = t.f7040a;
            } catch (Throwable th) {
                throw th;
            }
        }
        String str2 = this.tag;
        int size2 = batches.size();
        Iterator<T> it = batches.iterator();
        while (it.hasNext()) {
            length += ((String) it.next()).length();
        }
        Log.i(str2, "requeueFront batches=" + size2 + " chars=" + length + " queue=" + this.msgQueue.size());
    }

    public final void o(long delayMs) {
        Handler handler;
        if (this.cancelled.get() || (handler = this.threadHandler) == null) {
            return;
        }
        handler.removeMessages(1);
        if (delayMs > 0) {
            handler.sendEmptyMessageDelayed(1, delayMs);
        } else {
            handler.sendEmptyMessage(1);
        }
    }

    @Override // android.os.HandlerThread
    public void onLooperPrepared() {
        this.threadHandler = new Handler(getLooper(), this);
        p(this, 0L, 1, null);
    }

    public final void q() {
        if (isAlive()) {
            return;
        }
        start();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public q(String tag, int i10, long j10, InterfaceC5074l<? super String, Boolean> onText, InterfaceC5063a<t> onEnd, InterfaceC5063a<Integer> nextFeedCharBudget, long j11, int i11, long j12) {
        super("AiEngineTtsMsgHandler");
        kotlin.jvm.internal.p.i(tag, "tag");
        kotlin.jvm.internal.p.i(onText, "onText");
        kotlin.jvm.internal.p.i(onEnd, "onEnd");
        kotlin.jvm.internal.p.i(nextFeedCharBudget, "nextFeedCharBudget");
        this.tag = tag;
        this.maxFeedChars = i10;
        this.feedIntervalMs = j10;
        this.onText = onText;
        this.onEnd = onEnd;
        this.nextFeedCharBudget = nextFeedCharBudget;
        this.feedRetryMs = j11;
        this.minFeedChars = i11;
        this.continuationForceMs = j12;
        this.msgQueue = new ArrayDeque<>();
        this.cancelled = new AtomicBoolean(false);
        this.pauseLock = new Object();
    }
}
