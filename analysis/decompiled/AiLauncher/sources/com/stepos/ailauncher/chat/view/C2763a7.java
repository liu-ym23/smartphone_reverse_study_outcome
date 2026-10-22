package com.stepos.ailauncher.chat.view;

import com.autonavi.aps.amapapi.config.Const;
import com.stepos.ailauncher.foundation.credential.api.AuthSessionDto;
import kotlin.Metadata;
import p9.InterfaceC5063a;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\f\b\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J5\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00042\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\b¢\u0006\u0004\b\u000b\u0010\fJ\u001f\u0010\r\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\r\u0010\u000eJ\r\u0010\u000f\u001a\u00020\t¢\u0006\u0004\b\u000f\u0010\u0003R\u001e\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0014\u001a\u00020\u00048F¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u0015"}, d2 = {"Lcom/stepos/ailauncher/chat/view/a7;", "", "<init>", "()V", "", "networkUsable", "slaAvailable", "hostReady", "Lkotlin/Function0;", "LY8/t;", "start", Const.INTENT_KEY_PKGNAME, "(ZZLjava/lang/Boolean;Lp9/a;)Z", Const.INTENT_KEY_UMID, "(Ljava/lang/Boolean;)Lp9/a;", Const.INTENT_KEY_APIKEY, AuthSessionDto.STATUS_PENDING, "Lp9/a;", "c", "()Z", "isPending", "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* renamed from: com.stepos.ailauncher.chat.view.a7, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C2763a7 {
    private InterfaceC5063a<Y8.t> pending;

    public final void a() {
        this.pending = null;
    }

    public final boolean b(boolean networkUsable, boolean slaAvailable, Boolean hostReady, InterfaceC5063a<Y8.t> start) {
        kotlin.jvm.internal.p.i(start, "start");
        if (networkUsable || !slaAvailable || !kotlin.jvm.internal.p.d(hostReady, Boolean.FALSE)) {
            return false;
        }
        this.pending = start;
        return true;
    }

    public final boolean c() {
        return this.pending != null;
    }

    public final InterfaceC5063a<Y8.t> d(Boolean hostReady) {
        if (kotlin.jvm.internal.p.d(hostReady, Boolean.FALSE)) {
            return null;
        }
        InterfaceC5063a<Y8.t> interfaceC5063a = this.pending;
        this.pending = null;
        return interfaceC5063a;
    }
}
