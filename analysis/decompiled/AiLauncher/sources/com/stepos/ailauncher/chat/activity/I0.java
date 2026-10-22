package com.stepos.ailauncher.chat.activity;

import com.autonavi.aps.amapapi.config.Const;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\b\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bJ\r\u0010\t\u001a\u00020\u0006¢\u0006\u0004\b\t\u0010\nJ\r\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\f\u0010\u0003J\u0017\u0010\u000e\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0010\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0012\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0012\u0010\u0011¨\u0006\u0013"}, d2 = {"Lcom/stepos/ailauncher/chat/activity/I0;", "", "<init>", "()V", "", "status", "", Const.INTENT_KEY_UMID, "(I)Z", "c", "()Z", "LY8/t;", Const.INTENT_KEY_APIKEY, "allowed", Const.INTENT_KEY_PKGNAME, "(Z)Z", "cancelled", "Z", "activationClaimed", "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class I0 {
    private boolean activationClaimed;
    private boolean cancelled;

    public final void a() {
        this.cancelled = true;
    }

    public final boolean b(boolean allowed) {
        if (!allowed || this.cancelled || this.activationClaimed) {
            return false;
        }
        this.activationClaimed = true;
        return true;
    }

    public final boolean c() {
        return b(true);
    }

    public final boolean d(int status) {
        if (status == 2) {
            a();
        }
        return b(status == 1);
    }
}
