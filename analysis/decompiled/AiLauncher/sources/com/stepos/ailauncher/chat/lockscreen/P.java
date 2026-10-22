package com.stepos.ailauncher.chat.lockscreen;

import com.autonavi.aps.amapapi.config.Const;
import com.stepos.statsapp.v3.lib.plugin.constants.UxipConstants;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\r\b\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bJ\u0015\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\u0006¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\u000e\u001a\u0004\u0018\u00010\u00042\u0006\u0010\r\u001a\u00020\u0006¢\u0006\u0004\b\u000e\u0010\u000fJ\r\u0010\u0010\u001a\u00020\u0006¢\u0006\u0004\b\u0010\u0010\u0011J\r\u0010\u0012\u001a\u00020\n¢\u0006\u0004\b\u0012\u0010\u0003R\u0018\u0010\u0013\u001a\u0004\u0018\u00010\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0016\u0010\u0015\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016¨\u0006\u0017"}, d2 = {"Lcom/stepos/ailauncher/chat/lockscreen/P;", "", "<init>", "()V", "Lcom/stepos/ailauncher/chat/lockscreen/h;", UxipConstants.f30680s, "", Const.INTENT_KEY_APIKEY, "(Lcom/stepos/ailauncher/chat/lockscreen/h;)Z", "success", "LY8/t;", Const.INTENT_KEY_UMID, "(Z)V", "keyguardLocked", "e", "(Z)Lcom/stepos/ailauncher/chat/lockscreen/h;", "c", "()Z", Const.INTENT_KEY_PKGNAME, "request", "Lcom/stepos/ailauncher/chat/lockscreen/h;", "dismissSucceeded", "Z", "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class P {
    private boolean dismissSucceeded;
    private ArtifactDetailOpenRequest request;

    public final boolean a(ArtifactDetailOpenRequest value) {
        kotlin.jvm.internal.p.i(value, "value");
        if (this.request != null) {
            return false;
        }
        this.request = value;
        this.dismissSucceeded = false;
        return true;
    }

    public final void b() {
        this.request = null;
        this.dismissSucceeded = false;
    }

    public final boolean c() {
        return this.request != null;
    }

    public final void d(boolean success) {
        if (!success) {
            b();
        } else if (this.request != null) {
            this.dismissSucceeded = true;
        }
    }

    public final ArtifactDetailOpenRequest e(boolean keyguardLocked) {
        if (keyguardLocked || !this.dismissSucceeded) {
            return null;
        }
        ArtifactDetailOpenRequest artifactDetailOpenRequest = this.request;
        b();
        return artifactDetailOpenRequest;
    }
}
