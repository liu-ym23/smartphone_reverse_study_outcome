package com.stepos.ailauncher.container;

import android.os.Handler;
import android.os.Looper;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.aiengine.algorithm.highlight.HighlightArgsBundle;
import kotlin.C4848b;
import kotlin.Metadata;
import p9.InterfaceC5063a;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000e\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001*B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0007\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0007\u0010\bJ\u001f\u0010\r\u001a\u00020\u000b2\b\u0010\n\u001a\u0004\u0018\u00010\t2\u0006\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\r\u0010\u000eJ)\u0010\u0012\u001a\u00020\u000b2\b\u0010\u000f\u001a\u0004\u0018\u00010\t2\u0006\u0010\u0010\u001a\u00020\t2\b\u0010\u0011\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\u0012\u0010\u0013J\u0015\u0010\u0015\u001a\u00020\u000b2\u0006\u0010\u0014\u001a\u00020\t¢\u0006\u0004\b\u0015\u0010\u0016J\r\u0010\u0017\u001a\u00020\u000b¢\u0006\u0004\b\u0017\u0010\u0018J\r\u0010\u0019\u001a\u00020\u0006¢\u0006\u0004\b\u0019\u0010\u0003J\r\u0010\u001b\u001a\u00020\u001a¢\u0006\u0004\b\u001b\u0010\u001cJ\u0015\u0010\u001e\u001a\u00020\u00062\u0006\u0010\u001d\u001a\u00020\u001a¢\u0006\u0004\b\u001e\u0010\u001fR\u0018\u0010 \u001a\u0004\u0018\u00010\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b \u0010!R\u0014\u0010#\u001a\u00020\"8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b#\u0010$R\u001b\u0010)\u001a\u00020%8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b&\u0010'\u001a\u0004\b\u0005\u0010(¨\u0006+"}, d2 = {"Lcom/stepos/ailauncher/container/l0;", "", "<init>", "()V", "Lcom/stepos/ailauncher/container/l0$a;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "LY8/t;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_REMOVE, "(Lcom/stepos/ailauncher/container/l0$a;)V", "", "sessionId", "", "restoreLast", "k", "(Ljava/lang/String;Z)Z", "agentId", "deviceId", "agentDisplayName", "l", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Z", HighlightArgsBundle.KEY_PROMPT, "m", "(Ljava/lang/String;)Z", "e", "()Z", "f", "", "c", "()J", M5.b.CREDENTIAL_TOKEN, Const.INTENT_KEY_BACKGROUND_COMMAND, "(J)V", "handler", "Lcom/stepos/ailauncher/container/l0$a;", "Lcom/stepos/ailauncher/container/p0;", "scrimHandoff", "Lcom/stepos/ailauncher/container/p0;", "Landroid/os/Handler;", "mainHandler$delegate", "LY8/h;", "()Landroid/os/Handler;", "mainHandler", Const.INTENT_KEY_APIKEY, "container_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class l0 {
    private static volatile a handler;
    public static final l0 INSTANCE = new l0();
    private static final p0 scrimHandoff = new p0();

    /* renamed from: mainHandler$delegate, reason: from kotlin metadata */
    private static final Y8.h mainHandler = C4848b.b(new InterfaceC5063a() { // from class: com.stepos.ailauncher.container.j0
        @Override // p9.InterfaceC5063a
        public final Object invoke() {
            return l0.i();
        }
    });

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J!\u0010\u0006\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u0004H&¢\u0006\u0004\b\u0006\u0010\u0007J+\u0010\u000b\u001a\u00020\u00042\b\u0010\b\u001a\u0004\u0018\u00010\u00022\u0006\u0010\t\u001a\u00020\u00022\b\u0010\n\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\u000e\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0010\u001a\u00020\u0004H&¢\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0013\u001a\u00020\u0012H&¢\u0006\u0004\b\u0013\u0010\u0014J\u0017\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u0015H\u0016¢\u0006\u0004\b\u0016\u0010\u0017¨\u0006\u0018À\u0006\u0003"}, d2 = {"Lcom/stepos/ailauncher/container/l0$a;", "", "", "sessionId", "", "restoreLast", "f", "(Ljava/lang/String;Z)Z", "agentId", "deviceId", "agentDisplayName", Const.INTENT_KEY_UMID, "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Z", HighlightArgsBundle.KEY_PROMPT, "e", "(Ljava/lang/String;)Z", "c", "()Z", "LY8/t;", Const.INTENT_KEY_PKGNAME, "()V", "Lkotlin/Function0;", Const.INTENT_KEY_APIKEY, "()Lp9/a;", "container_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public interface a {
        default InterfaceC5063a<Y8.t> a() {
            b();
            return null;
        }

        void b();

        boolean c();

        default boolean d(String agentId, String deviceId, String agentDisplayName) {
            kotlin.jvm.internal.p.i(deviceId, "deviceId");
            return false;
        }

        default boolean e(String prompt) {
            kotlin.jvm.internal.p.i(prompt, "prompt");
            return false;
        }

        boolean f(String sessionId, boolean restoreLast);
    }

    public static final void d(long j10) {
        INSTANCE.g(j10);
    }

    public static final Handler i() {
        return new Handler(Looper.getMainLooper());
    }

    public final long c() {
        InterfaceC5063a<Y8.t> interfaceC5063aA;
        a aVar = handler;
        if (aVar == null || (interfaceC5063aA = aVar.a()) == null) {
            return 0L;
        }
        final long jA = scrimHandoff.a(interfaceC5063aA);
        h().postDelayed(new Runnable() { // from class: com.stepos.ailauncher.container.k0
            @Override // java.lang.Runnable
            public final void run() {
                l0.d(jA);
            }
        }, 1500L);
        return jA;
    }

    public final boolean e() {
        a aVar = handler;
        return aVar != null && aVar.c();
    }

    public final void f() {
        a aVar = handler;
        if (aVar != null) {
            aVar.b();
        }
    }

    public final void g(long token) {
        scrimHandoff.b(token);
    }

    public final Handler h() {
        return (Handler) mainHandler.getValue();
    }

    public final void j(a h10) {
        handler = h10;
    }

    public final boolean k(String sessionId, boolean restoreLast) {
        a aVar = handler;
        if (aVar != null) {
            return aVar.f(sessionId, restoreLast);
        }
        return false;
    }

    public final boolean l(String agentId, String deviceId, String agentDisplayName) {
        kotlin.jvm.internal.p.i(deviceId, "deviceId");
        a aVar = handler;
        if (aVar != null) {
            return aVar.d(agentId, deviceId, agentDisplayName);
        }
        return false;
    }

    public final boolean m(String prompt) {
        kotlin.jvm.internal.p.i(prompt, "prompt");
        a aVar = handler;
        if (aVar != null) {
            return aVar.e(prompt);
        }
        return false;
    }
}
