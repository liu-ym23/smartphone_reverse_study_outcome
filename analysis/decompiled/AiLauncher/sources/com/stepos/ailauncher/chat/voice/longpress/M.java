package com.stepos.ailauncher.chat.voice.longpress;

import com.autonavi.aps.amapapi.config.Const;
import com.stepos.ailauncher.contract.api.homegesture.HomeGestureEligibilityContract;
import kotlin.Metadata;
import p9.InterfaceC5063a;
import p9.InterfaceC5074l;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\t\n\u0002\b\b\b\u0000\u0018\u00002\u00020\u0001B5\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\u001e\u0010\u0007\u001a\u001a\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00030\u0005\u0012\u0004\u0012\u00020\u00030\u0005¢\u0006\u0004\b\b\u0010\tJ+\u0010\u000f\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\n2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\u0002¢\u0006\u0004\b\u000f\u0010\u0010J\u001b\u0010\u0011\u001a\u00020\u00032\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\u0002¢\u0006\u0004\b\u0011\u0010\u0012J\r\u0010\u0013\u001a\u00020\u0003¢\u0006\u0004\b\u0013\u0010\u0014J\r\u0010\u0015\u001a\u00020\u0003¢\u0006\u0004\b\u0015\u0010\u0014J\u000f\u0010\u0016\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u0016\u0010\u0014R\u001a\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u0017R,\u0010\u0007\u001a\u001a\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00030\u0005\u0012\u0004\u0012\u00020\u00030\u00058\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\u0018R\u0016\u0010\u001a\u001a\u00020\u00198\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0016\u0010\u001c\u001a\u00020\n8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0016\u0010\u001e\u001a\u00020\n8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001e\u0010\u001dR\u0018\u0010\u001f\u001a\u0004\u0018\u00010\r8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001f\u0010 ¨\u0006!"}, d2 = {"Lcom/stepos/ailauncher/chat/voice/longpress/M;", "", "Lkotlin/Function0;", "LY8/t;", "cancelSession", "Lkotlin/Function1;", "Lcom/stepos/ailauncher/chat/voice/longpress/RecordingExitResult;", "exitPresentation", "<init>", "(Lp9/a;Lp9/l;)V", "", "fullScreenListening", "canCancel", "Lcom/stepos/ailauncher/chat/voice/longpress/N;", "startHost", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "(ZZLp9/a;)Z", "f", "(Lp9/a;)V", "e", "()V", Const.INTENT_KEY_UMID, "c", "Lp9/a;", "Lp9/l;", "", HomeGestureEligibilityContract.EXTRA_GENERATION, "J", "exiting", "Z", "effectCompleted", "hostTransition", "Lcom/stepos/ailauncher/chat/voice/longpress/N;", "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class M {
    private final InterfaceC5063a<Y8.t> cancelSession;
    private boolean effectCompleted;
    private final InterfaceC5074l<InterfaceC5074l<? super RecordingExitResult, Y8.t>, Y8.t> exitPresentation;
    private boolean exiting;
    private long generation;
    private N hostTransition;

    /* JADX WARN: Multi-variable type inference failed */
    public M(InterfaceC5063a<Y8.t> cancelSession, InterfaceC5074l<? super InterfaceC5074l<? super RecordingExitResult, Y8.t>, Y8.t> exitPresentation) {
        kotlin.jvm.internal.p.i(cancelSession, "cancelSession");
        kotlin.jvm.internal.p.i(exitPresentation, "exitPresentation");
        this.cancelSession = cancelSession;
        this.exitPresentation = exitPresentation;
    }

    public static final Y8.t g(long j10, M m10) {
        if (j10 == m10.generation) {
            m10.c();
        }
        return Y8.t.f7040a;
    }

    public static final Y8.t h(long j10, M m10, N n10, RecordingExitResult result) {
        kotlin.jvm.internal.p.i(result, "result");
        if (j10 == m10.generation && !m10.effectCompleted) {
            m10.effectCompleted = true;
            if (result == RecordingExitResult.COMPLETED) {
                n10.b();
            } else {
                m10.d();
            }
        }
        return Y8.t.f7040a;
    }

    public final void c() {
        this.generation++;
        this.exiting = false;
        this.effectCompleted = false;
        this.hostTransition = null;
    }

    public final void d() {
        N n10 = this.hostTransition;
        c();
        if (n10 != null) {
            n10.dispose();
        }
    }

    public final void e() {
        N n10 = this.hostTransition;
        c();
        if (n10 != null) {
            n10.cancel();
        }
    }

    public final void f(InterfaceC5063a<? extends N> startHost) {
        kotlin.jvm.internal.p.i(startHost, "startHost");
        if (this.exiting) {
            return;
        }
        this.exiting = true;
        final long j10 = this.generation + 1;
        this.generation = j10;
        this.cancelSession.invoke();
        if (j10 != this.generation) {
            return;
        }
        final N nInvoke = startHost.invoke();
        if (j10 != this.generation) {
            nInvoke.dispose();
            return;
        }
        this.hostTransition = nInvoke;
        nInvoke.a(new InterfaceC5063a() { // from class: com.stepos.ailauncher.chat.voice.longpress.K
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return M.g(j10, this);
            }
        });
        if (j10 != this.generation) {
            return;
        }
        this.exitPresentation.invoke(new InterfaceC5074l() { // from class: com.stepos.ailauncher.chat.voice.longpress.L
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return M.h(j10, this, nInvoke, (RecordingExitResult) obj);
            }
        });
    }

    public final boolean i(boolean fullScreenListening, boolean canCancel, InterfaceC5063a<? extends N> startHost) {
        kotlin.jvm.internal.p.i(startHost, "startHost");
        if (this.exiting) {
            return true;
        }
        if (!fullScreenListening || !canCancel) {
            return false;
        }
        f(startHost);
        return true;
    }
}
