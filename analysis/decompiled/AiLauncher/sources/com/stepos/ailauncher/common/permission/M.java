package com.stepos.ailauncher.common.permission;

import Z8.C1165m;
import com.autonavi.aps.amapapi.config.Const;
import kotlin.Metadata;
import p9.InterfaceC5063a;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u001b\u0010\t\u001a\u00020\u00072\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0002¢\u0006\u0004\b\t\u0010\u0006J\r\u0010\n\u001a\u00020\u0007¢\u0006\u0004\b\n\u0010\u000bJ\r\u0010\f\u001a\u00020\u0007¢\u0006\u0004\b\f\u0010\u000bR\u001a\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\rR \u0010\u000f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00020\u000e8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010¨\u0006\u0011"}, d2 = {"Lcom/stepos/ailauncher/common/permission/M;", "", "Lkotlin/Function0;", "", "isIdle", "<init>", "(Lp9/a;)V", "LY8/t;", "action", "c", Const.INTENT_KEY_PKGNAME, "()V", Const.INTENT_KEY_APIKEY, "Lp9/a;", "LZ8/m;", "callbacks", "LZ8/m;", "permission_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class M {
    private final C1165m<InterfaceC5063a<Y8.t>> callbacks;
    private final InterfaceC5063a<Boolean> isIdle;

    public M(InterfaceC5063a<Boolean> isIdle) {
        kotlin.jvm.internal.p.i(isIdle, "isIdle");
        this.isIdle = isIdle;
        this.callbacks = new C1165m<>();
    }

    public final void a() {
        this.callbacks.clear();
    }

    public final void b() {
        while (!this.callbacks.isEmpty() && this.isIdle.invoke().booleanValue()) {
            this.callbacks.removeFirst().invoke();
        }
    }

    public final void c(InterfaceC5063a<Y8.t> action) {
        kotlin.jvm.internal.p.i(action, "action");
        this.callbacks.addLast(action);
        b();
    }
}
