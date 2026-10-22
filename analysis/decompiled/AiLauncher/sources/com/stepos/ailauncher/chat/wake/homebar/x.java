package com.stepos.ailauncher.chat.wake.homebar;

import com.autonavi.aps.amapapi.config.Const;
import com.stepos.ailauncher.contract.api.homegesture.HomeGestureEligibilityContract;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\b\b\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\r\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0003J\r\u0010\u0006\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0003J\u000f\u0010\b\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\b\u0010\tJ\u0015\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\u0007¢\u0006\u0004\b\f\u0010\rR\u0016\u0010\u000e\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0010\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0012\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0012\u0010\u0011¨\u0006\u0013"}, d2 = {"Lcom/stepos/ailauncher/chat/wake/homebar/x;", "", "<init>", "()V", "LY8/t;", Const.INTENT_KEY_UMID, "c", "", Const.INTENT_KEY_APIKEY, "()Ljava/lang/Long;", "request", "", Const.INTENT_KEY_PKGNAME, "(J)Z", HomeGestureEligibilityContract.EXTRA_GENERATION, "J", "cancelled", "Z", "showClaimed", "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class x {
    private boolean cancelled;
    private long generation;
    private boolean showClaimed;

    public final Long a() {
        if (this.cancelled || this.showClaimed) {
            return null;
        }
        this.showClaimed = true;
        return Long.valueOf(this.generation);
    }

    public final boolean b(long request) {
        return !this.cancelled && request == this.generation;
    }

    public final void c() {
        this.generation++;
        this.cancelled = true;
    }

    public final void d() {
        this.generation++;
        this.cancelled = false;
        this.showClaimed = false;
    }
}
