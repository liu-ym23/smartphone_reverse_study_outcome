package com.stepos.agentframework.chatui;

import com.autonavi.aps.amapapi.config.Const;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001:\u0001\u0012J!\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u0004H&¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0006H&¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u000b\u001a\u00020\u0006H&¢\u0006\u0004\b\u000b\u0010\nJ\u000f\u0010\f\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\f\u0010\nJ\u000f\u0010\r\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\r\u0010\nJ\u000f\u0010\u000e\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u0019\u0010\u0012\u001a\u00020\u00062\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010H&¢\u0006\u0004\b\u0012\u0010\u0013¨\u0006\u0014À\u0006\u0003"}, d2 = {"Lcom/stepos/agentframework/chatui/T1;", "", "", "text", "", "isStream", "LY8/t;", Const.INTENT_KEY_PKGNAME, "(Ljava/lang/String;Z)V", "e", "()V", com.stepos.ailauncher.chat.trace.g.ACTION_STOP, Const.INTENT_KEY_BACKGROUND_COMMAND, Const.INTENT_KEY_UMID, "c", "()Z", "Lcom/stepos/agentframework/chatui/T1$a;", "listener", Const.INTENT_KEY_APIKEY, "(Lcom/stepos/agentframework/chatui/T1$a;)V", "agentcore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes2.dex */
public interface T1 {

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\b\bf\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0005\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0004J\u0017\u0010\b\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\b\u0010\tJ\u001f\u0010\f\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\f\u0010\r¨\u0006\u000eÀ\u0006\u0003"}, d2 = {"Lcom/stepos/agentframework/chatui/T1$a;", "", "LY8/t;", "onPlayStarted", "()V", "onPlayStopped", "", "reason", Const.INTENT_KEY_PKGNAME, "(Ljava/lang/String;)V", "code", "message", Const.INTENT_KEY_APIKEY, "(Ljava/lang/String;Ljava/lang/String;)V", "agentcore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public interface a {
        default void a(String code, String message) {
            kotlin.jvm.internal.p.i(code, "code");
            kotlin.jvm.internal.p.i(message, "message");
        }

        default void b(String reason) {
            kotlin.jvm.internal.p.i(reason, "reason");
        }

        default void onPlayStarted() {
        }

        default void onPlayStopped() {
        }
    }

    static /* synthetic */ void f(T1 t12, String str, boolean z10, int i10, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: play");
        }
        if ((i10 & 2) != 0) {
            z10 = false;
        }
        t12.b(str, z10);
    }

    void a(a listener);

    void b(String text, boolean isStream);

    default boolean c() {
        return false;
    }

    default void d() {
    }

    void e();

    default void g() {
    }

    void stop();
}
