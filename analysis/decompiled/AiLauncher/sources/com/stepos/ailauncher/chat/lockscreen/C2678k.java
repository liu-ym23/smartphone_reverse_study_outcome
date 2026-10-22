package com.stepos.ailauncher.chat.lockscreen;

import android.os.PowerManager;
import android.os.SystemClock;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.ailauncher.chat.activity.ChatActivity;
import com.stepos.ailauncher.contract.model.SessionArtifact;
import h8.C4148a;
import kotlin.Metadata;
import p9.InterfaceC5074l;

@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0000\u0018\u0000 )2\u00020\u0001:\u0001*B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u001d\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\u000b\u0010\fJ\r\u0010\r\u001a\u00020\n¢\u0006\u0004\b\r\u0010\u000eJ\r\u0010\u000f\u001a\u00020\n¢\u0006\u0004\b\u000f\u0010\u000eJ\u001f\u0010\u0014\u001a\u00020\n2\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u0012H\u0002¢\u0006\u0004\b\u0014\u0010\u0015J\u000f\u0010\u0016\u001a\u00020\nH\u0002¢\u0006\u0004\b\u0016\u0010\u000eJ\u000f\u0010\u0017\u001a\u00020\u0012H\u0002¢\u0006\u0004\b\u0017\u0010\u0018J\u000f\u0010\u0019\u001a\u00020\nH\u0002¢\u0006\u0004\b\u0019\u0010\u000eJ\u0017\u0010\u001c\u001a\u00020\n2\u0006\u0010\u001b\u001a\u00020\u001aH\u0002¢\u0006\u0004\b\u001c\u0010\u001dJ\u0017\u0010\u001e\u001a\u00020\n2\u0006\u0010\u001b\u001a\u00020\u001aH\u0002¢\u0006\u0004\b\u001e\u0010\u001dR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u001fR\u0014\u0010!\u001a\u00020 8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b!\u0010\"R\u0016\u0010#\u001a\u00020\u00108\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b#\u0010$R\u0016\u0010%\u001a\u00020\u00108\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b%\u0010$R\u0014\u0010'\u001a\u00020&8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b'\u0010(¨\u0006+"}, d2 = {"Lcom/stepos/ailauncher/chat/lockscreen/k;", "", "Lcom/stepos/ailauncher/chat/activity/ChatActivity;", "host", "<init>", "(Lcom/stepos/ailauncher/chat/activity/ChatActivity;)V", "Lcom/stepos/ailauncher/contract/model/SessionArtifact;", "artifact", "", "source", "LY8/t;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_REMOVE, "(Lcom/stepos/ailauncher/contract/model/SessionArtifact;Ljava/lang/String;)V", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "()V", "e", "", M5.b.CREDENTIAL_TOKEN, "", "succeeded", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "(JZ)V", Const.INTENT_KEY_UMID, "c", "()Z", "m", "Lcom/stepos/ailauncher/chat/lockscreen/h;", "request", "f", "(Lcom/stepos/ailauncher/chat/lockscreen/h;)V", Const.INTENT_KEY_BACKGROUND_COMMAND, "Lcom/stepos/ailauncher/chat/activity/ChatActivity;", "Lcom/stepos/ailauncher/chat/lockscreen/P;", "pendingOpen", "Lcom/stepos/ailauncher/chat/lockscreen/P;", "unlockDeadlineMs", "J", "requestToken", "Ljava/lang/Runnable;", "unlockCheck", "Ljava/lang/Runnable;", "Companion", Const.INTENT_KEY_APIKEY, "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* renamed from: com.stepos.ailauncher.chat.lockscreen.k, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C2678k {
    private static final a Companion = new a(null);

    @Deprecated
    public static final String TAG = "ArtifactDetailUnlock";

    @Deprecated
    public static final long UNLOCK_CHECK_INTERVAL_MS = 50;

    @Deprecated
    public static final long UNLOCK_WAIT_TIMEOUT_MS = 10000;
    private final ChatActivity host;
    private final P pendingOpen;
    private long requestToken;
    private final Runnable unlockCheck;
    private long unlockDeadlineMs;

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0004\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0014\u0010\u0005\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0005\u0010\u0006R\u0014\u0010\b\u001a\u00020\u00078\u0006X\u0086T¢\u0006\u0006\n\u0004\b\b\u0010\tR\u0014\u0010\n\u001a\u00020\u00078\u0006X\u0086T¢\u0006\u0006\n\u0004\b\n\u0010\t¨\u0006\u000b"}, d2 = {"Lcom/stepos/ailauncher/chat/lockscreen/k$a;", "", "<init>", "()V", "", "TAG", "Ljava/lang/String;", "", "UNLOCK_WAIT_TIMEOUT_MS", "J", "UNLOCK_CHECK_INTERVAL_MS", "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.ailauncher.chat.lockscreen.k$a */
    public static final class a {
        public /* synthetic */ a(kotlin.jvm.internal.i iVar) {
            this();
        }

        public a() {
        }
    }

    public C2678k(ChatActivity host) {
        kotlin.jvm.internal.p.i(host, "host");
        this.host = host;
        this.pendingOpen = new P();
        this.unlockCheck = new Runnable() { // from class: com.stepos.ailauncher.chat.lockscreen.i
            @Override // java.lang.Runnable
            public final void run() {
                C2678k.l(this.f25503a);
            }
        };
    }

    public static final Y8.t k(C2678k c2678k, long j10, boolean z10) {
        c2678k.h(j10, z10);
        return Y8.t.f7040a;
    }

    public static final void l(C2678k c2678k) {
        c2678k.d();
    }

    public final boolean c() {
        if (this.host.isFinishing() || this.host.isDestroyed()) {
            return false;
        }
        Object systemService = this.host.getSystemService("power");
        PowerManager powerManager = systemService instanceof PowerManager ? (PowerManager) systemService : null;
        return powerManager == null || powerManager.isInteractive();
    }

    public final void d() {
        this.host.getWindow().getDecorView().removeCallbacks(this.unlockCheck);
        if (this.pendingOpen.c()) {
            if (!c()) {
                e();
                return;
            }
            ArtifactDetailOpenRequest artifactDetailOpenRequestE = this.pendingOpen.e(I.INSTANCE.g(this.host));
            if (artifactDetailOpenRequestE != null) {
                f(artifactDetailOpenRequestE);
            } else {
                m();
            }
        }
    }

    public final void e() {
        this.host.getWindow().getDecorView().removeCallbacks(this.unlockCheck);
        this.requestToken++;
        this.unlockDeadlineMs = 0L;
        this.pendingOpen.b();
    }

    public final void f(ArtifactDetailOpenRequest request) {
        this.requestToken++;
        this.unlockDeadlineMs = 0L;
        this.host.c7();
        g(request);
    }

    public final void g(ArtifactDetailOpenRequest request) {
        com.stepos.ailauncher.foundation.task.a.a(this.host, request.getArtifact(), request.getSource(), request.getLiveSessionId());
    }

    public final void h(long token, boolean succeeded) {
        if (token != this.requestToken) {
            return;
        }
        if (this.host.isFinishing() || this.host.isDestroyed()) {
            e();
            return;
        }
        this.pendingOpen.d(succeeded);
        if (!succeeded) {
            e();
        } else {
            this.unlockDeadlineMs = SystemClock.uptimeMillis() + 10000;
            d();
        }
    }

    public final void i() {
        d();
    }

    public final void j(SessionArtifact artifact, String source) {
        kotlin.jvm.internal.p.i(artifact, "artifact");
        kotlin.jvm.internal.p.i(source, "source");
        if (this.pendingOpen.c()) {
            return;
        }
        ArtifactDetailOpenRequest artifactDetailOpenRequest = new ArtifactDetailOpenRequest(artifact, source, this.host.H6());
        I i10 = I.INSTANCE;
        if (!i10.g(this.host)) {
            this.host.c7();
            g(artifactDetailOpenRequest);
            return;
        }
        this.pendingOpen.a(artifactDetailOpenRequest);
        final long j10 = this.requestToken + 1;
        this.requestToken = j10;
        C4148a.k(TAG, "wait for keyguard dismissal", false, 4, null);
        i10.i(this.host, new InterfaceC5074l() { // from class: com.stepos.ailauncher.chat.lockscreen.j
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return C2678k.k(this.f25504a, j10, ((Boolean) obj).booleanValue());
            }
        });
    }

    public final void m() {
        if (this.unlockDeadlineMs == 0) {
            return;
        }
        if (SystemClock.uptimeMillis() < this.unlockDeadlineMs) {
            this.host.getWindow().getDecorView().postDelayed(this.unlockCheck, 50L);
        } else {
            C4148a.u(TAG, "keyguard still showing after dismiss callback", false, 4, null);
            e();
        }
    }
}
