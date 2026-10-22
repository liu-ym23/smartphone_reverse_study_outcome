package com.stepos.ailauncher.chat.voice.longpress;

import android.view.View;
import com.autonavi.aps.amapapi.config.Const;
import kotlin.Metadata;
import p9.InterfaceC5074l;

@Metadata(d1 = {"\u0000=\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\b\u0004*\u0001\u001b\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004¢\u0006\u0004\b\b\u0010\tJ\r\u0010\n\u001a\u00020\u0006¢\u0006\u0004\b\n\u0010\u000bJ\u0015\u0010\r\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u0005¢\u0006\u0004\b\r\u0010\u000eJ\r\u0010\u000f\u001a\u00020\u0006¢\u0006\u0004\b\u000f\u0010\u000bR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0010R \u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\u0011R\u0014\u0010\u0013\u001a\u00020\u00128\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0016\u0010\u0016\u001a\u00020\u00158\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0016\u0010\u0019\u001a\u00020\u00188\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0014\u0010\u001c\u001a\u00020\u001b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001c\u0010\u001d¨\u0006\u001e"}, d2 = {"Lcom/stepos/ailauncher/chat/voice/longpress/V;", "", "Landroid/view/View;", "host", "Lkotlin/Function1;", "", "LY8/t;", "output", "<init>", "(Landroid/view/View;Lp9/l;)V", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "()V", "volume", Const.INTENT_KEY_BACKGROUND_COMMAND, "(F)V", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "Landroid/view/View;", "Lp9/l;", "Lcom/stepos/ailauncher/chat/voice/longpress/W;", "smoother", "Lcom/stepos/ailauncher/chat/voice/longpress/W;", "", "running", "Z", "", "lastNanos", "J", "com/stepos/ailauncher/chat/voice/longpress/V$a", "frame", "Lcom/stepos/ailauncher/chat/voice/longpress/V$a;", "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class V {
    private final a frame;
    private final View host;
    private long lastNanos;
    private final InterfaceC5074l<Float, Y8.t> output;
    private boolean running;
    private final W smoother;

    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"com/stepos/ailauncher/chat/voice/longpress/V$a", "Ljava/lang/Runnable;", "LY8/t;", "run", "()V", "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (V.this.running) {
                long jNanoTime = System.nanoTime();
                V.this.output.invoke(Float.valueOf(V.this.smoother.a((jNanoTime - V.this.lastNanos) / 1.0E9d)));
                V.this.lastNanos = jNanoTime;
                V.this.host.postOnAnimation(this);
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public V(View host, InterfaceC5074l<? super Float, Y8.t> output) {
        kotlin.jvm.internal.p.i(host, "host");
        kotlin.jvm.internal.p.i(output, "output");
        this.host = host;
        this.output = output;
        this.smoother = new W();
        this.frame = new a();
    }

    public final void g(float volume) {
        this.smoother.c(volume);
    }

    public final void h() {
        i();
        this.running = true;
        this.lastNanos = System.nanoTime();
        this.output.invoke(Float.valueOf(0.0f));
        this.host.postOnAnimation(this.frame);
    }

    public final void i() {
        this.running = false;
        this.host.removeCallbacks(this.frame);
        this.smoother.b();
    }
}
