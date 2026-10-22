package com.stepos.ailauncher.container;

import com.autonavi.aps.amapapi.config.Const;
import com.stepos.ailauncher.contract.api.homegesture.HomeGestureEligibilityContract;
import kotlin.Metadata;
import p9.InterfaceC5063a;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\n\b\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001b\u0010\b\u001a\u00020\u00072\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0004\b\b\u0010\tJ\u0015\u0010\u000b\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u0007¢\u0006\u0004\b\u000b\u0010\fR\u0016\u0010\r\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\r\u0010\u000eR\u001e\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010¨\u0006\u0011"}, d2 = {"Lcom/stepos/ailauncher/container/p0;", "", "<init>", "()V", "Lkotlin/Function0;", "LY8/t;", "onRelease", "", Const.INTENT_KEY_APIKEY, "(Lp9/a;)J", M5.b.CREDENTIAL_TOKEN, Const.INTENT_KEY_PKGNAME, "(J)V", HomeGestureEligibilityContract.EXTRA_GENERATION, "J", "release", "Lp9/a;", "container_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class p0 {
    private long generation;
    private InterfaceC5063a<Y8.t> release;

    public final long a(InterfaceC5063a<Y8.t> onRelease) {
        kotlin.jvm.internal.p.i(onRelease, "onRelease");
        InterfaceC5063a<Y8.t> interfaceC5063a = this.release;
        if (interfaceC5063a != onRelease && interfaceC5063a != null) {
            interfaceC5063a.invoke();
        }
        long j10 = this.generation + 1;
        this.generation = j10;
        this.release = onRelease;
        return j10;
    }

    public final void b(long token) {
        InterfaceC5063a<Y8.t> interfaceC5063a;
        if (token == 0 || token != this.generation || (interfaceC5063a = this.release) == null) {
            return;
        }
        this.release = null;
        interfaceC5063a.invoke();
    }
}
