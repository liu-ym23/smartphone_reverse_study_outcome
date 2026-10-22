package com.stepos.ailauncher.chat.wake;

import android.content.Context;
import android.media.AudioManager;
import android.media.AudioRecordingConfiguration;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.ailauncher.common.utils.MicOccupancyMonitor;
import h8.C4148a;
import java.util.List;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.Result;
import p9.InterfaceC5074l;

@Metadata(d1 = {"\u00005\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\t*\u0001\u0018\b\u0000\u0018\u0000 \u001e2\u00020\u0001:\u0001\u001fB#\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004¢\u0006\u0004\b\b\u0010\tJ\r\u0010\n\u001a\u00020\u0006¢\u0006\u0004\b\n\u0010\u000bJ\r\u0010\f\u001a\u00020\u0006¢\u0006\u0004\b\f\u0010\u000bJ\u0017\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\rH\u0002¢\u0006\u0004\b\u000f\u0010\u0010R \u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\u0011R\u001c\u0010\u0013\u001a\n \u0012*\u0004\u0018\u00010\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0016\u001a\u00020\u00158\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0014\u0010\u0019\u001a\u00020\u00188\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0016\u0010\u001b\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0016\u0010\u001d\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001d\u0010\u001c¨\u0006 "}, d2 = {"Lcom/stepos/ailauncher/chat/wake/l;", "", "Landroid/content/Context;", "context", "Lkotlin/Function1;", "", "LY8/t;", "onAnswered", "<init>", "(Landroid/content/Context;Lp9/l;)V", "e", "()V", "f", "", "from", "c", "(Ljava/lang/String;)V", "Lp9/l;", "kotlin.jvm.PlatformType", "appContext", "Landroid/content/Context;", "Landroid/media/AudioManager$OnModeChangedListener;", "modeListener", "Landroid/media/AudioManager$OnModeChangedListener;", "com/stepos/ailauncher/chat/wake/l$b", "captureListener", "Lcom/stepos/ailauncher/chat/wake/l$b;", "seenNotAnswered", "Z", "registered", "Companion", Const.INTENT_KEY_APIKEY, "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* renamed from: com.stepos.ailauncher.chat.wake.l, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C3140l {
    private static final a Companion = new a(null);

    @Deprecated
    public static final String TAG = "AnsweredCallWatcher";
    private final Context appContext;
    private final b captureListener;
    private final AudioManager.OnModeChangedListener modeListener;
    private final InterfaceC5074l<Boolean, Y8.t> onAnswered;
    private boolean registered;
    private boolean seenNotAnswered;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0014\u0010\u0005\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/stepos/ailauncher/chat/wake/l$a;", "", "<init>", "()V", "", "TAG", "Ljava/lang/String;", "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.ailauncher.chat.wake.l$a */
    public static final class a {
        public /* synthetic */ a(kotlin.jvm.internal.i iVar) {
            this();
        }

        public a() {
        }
    }

    @Metadata(d1 = {"\u0000\u001b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001d\u0010\u0006\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"com/stepos/ailauncher/chat/wake/l$b", "Landroid/media/AudioManager$AudioRecordingCallback;", "", "Landroid/media/AudioRecordingConfiguration;", "configs", "LY8/t;", "onRecordingConfigChanged", "(Ljava/util/List;)V", "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.ailauncher.chat.wake.l$b */
    public static final class b extends AudioManager.AudioRecordingCallback {
        public b() {
        }

        @Override // android.media.AudioManager.AudioRecordingCallback
        public void onRecordingConfigChanged(List<AudioRecordingConfiguration> configs) {
            kotlin.jvm.internal.p.i(configs, "configs");
            C3140l.this.c("capture");
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public C3140l(Context context, InterfaceC5074l<? super Boolean, Y8.t> onAnswered) {
        kotlin.jvm.internal.p.i(context, "context");
        kotlin.jvm.internal.p.i(onAnswered, "onAnswered");
        this.onAnswered = onAnswered;
        this.appContext = context.getApplicationContext();
        this.modeListener = new AudioManager.OnModeChangedListener() { // from class: com.stepos.ailauncher.chat.wake.k
            @Override // android.media.AudioManager.OnModeChangedListener
            public final void onModeChanged(int i10) {
                C3140l.d(this.f26824a, i10);
            }
        };
        this.captureListener = new b();
    }

    public static final void d(C3140l c3140l, int i10) {
        c3140l.c("mode=" + i10);
    }

    public final void c(String from) {
        MicOccupancyMonitor micOccupancyMonitor = MicOccupancyMonitor.INSTANCE;
        boolean zN = micOccupancyMonitor.n();
        C4148a.k(MicOccupancyMonitor.CALL_LISTEN, "watcher from=" + from + " answered=" + zN + " seenNotAnswered=" + this.seenNotAnswered, false, 4, null);
        StringBuilder sb2 = new StringBuilder();
        sb2.append("watcher ");
        sb2.append(from);
        micOccupancyMonitor.w(sb2.toString());
        if (!zN) {
            this.seenNotAnswered = true;
            return;
        }
        if (this.seenNotAnswered) {
            this.seenNotAnswered = false;
            boolean z10 = !micOccupancyMonitor.u();
            C4148a.k(TAG, "answered: from=" + from + " system=" + z10, false, 4, null);
            this.onAnswered.invoke(Boolean.valueOf(z10));
        }
    }

    public final void e() {
        Object objB;
        if (this.registered) {
            return;
        }
        Object systemService = this.appContext.getSystemService("audio");
        AudioManager audioManager = systemService instanceof AudioManager ? (AudioManager) systemService : null;
        if (audioManager == null) {
            return;
        }
        this.seenNotAnswered = !MicOccupancyMonitor.INSTANCE.n();
        try {
            Result.Companion companion = Result.INSTANCE;
            audioManager.addOnModeChangedListener(this.appContext.getMainExecutor(), this.modeListener);
            audioManager.registerAudioRecordingCallback(this.captureListener, null);
            this.registered = true;
            objB = Result.b(Y8.t.f7040a);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objB = Result.b(C4849c.a(th));
        }
        Throwable thE = Result.e(objB);
        if (thE != null) {
            C4148a.h(TAG, "start failed: " + thE.getMessage(), false, 4, null);
        }
    }

    public final void f() {
        Object objB;
        Object objB2;
        if (this.registered) {
            this.registered = false;
            this.seenNotAnswered = false;
            Object systemService = this.appContext.getSystemService("audio");
            AudioManager audioManager = systemService instanceof AudioManager ? (AudioManager) systemService : null;
            if (audioManager == null) {
                return;
            }
            try {
                Result.Companion companion = Result.INSTANCE;
                audioManager.removeOnModeChangedListener(this.modeListener);
                objB = Result.b(Y8.t.f7040a);
            } catch (Throwable th) {
                Result.Companion companion2 = Result.INSTANCE;
                objB = Result.b(C4849c.a(th));
            }
            Throwable thE = Result.e(objB);
            if (thE != null) {
                C4148a.u(TAG, "stop mode failed: " + thE.getMessage(), false, 4, null);
            }
            try {
                audioManager.unregisterAudioRecordingCallback(this.captureListener);
                objB2 = Result.b(Y8.t.f7040a);
            } catch (Throwable th2) {
                Result.Companion companion3 = Result.INSTANCE;
                objB2 = Result.b(C4849c.a(th2));
            }
            Throwable thE2 = Result.e(objB2);
            if (thE2 != null) {
                C4148a.u(TAG, "stop capture failed: " + thE2.getMessage(), false, 4, null);
            }
        }
    }
}
