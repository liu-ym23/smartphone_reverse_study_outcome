package com.stepos.ailauncher.chat.view;

import com.autonavi.aps.amapapi.config.Const;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0011\b\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\"\u0010\u0005\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\"\u0010\f\u001a\u00020\u000b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\"\u0010\u0012\u001a\u00020\u000b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0012\u0010\r\u001a\u0004\b\u0013\u0010\u000f\"\u0004\b\u0014\u0010\u0011R\"\u0010\u0015\u001a\u00020\u000b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0015\u0010\r\u001a\u0004\b\u0016\u0010\u000f\"\u0004\b\u0017\u0010\u0011R\u0011\u0010\u0019\u001a\u00020\u000b8F¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u000fR\u0011\u0010\u001b\u001a\u00020\u00048F¢\u0006\u0006\u001a\u0004\b\u001a\u0010\b¨\u0006\u001c"}, d2 = {"Lcom/stepos/ailauncher/chat/view/x6;", "", "<init>", "()V", "Ly7/o;", "baseEffect", "Ly7/o;", "getBaseEffect", "()Ly7/o;", "e", "(Ly7/o;)V", "", "desktopKeyboardRaised", "Z", "getDesktopKeyboardRaised", "()Z", "f", "(Z)V", "floatingWakeShown", "c", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "floatingCardShown", Const.INTENT_KEY_PKGNAME, Const.INTENT_KEY_BACKGROUND_COMMAND, Const.INTENT_KEY_UMID, "usesDesktopKeyboardMaterial", Const.INTENT_KEY_APIKEY, "effect", "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* renamed from: com.stepos.ailauncher.chat.view.x6, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C3013x6 {
    private y7.o baseEffect = y7.o.INSTANCE.i();
    private boolean desktopKeyboardRaised;
    private boolean floatingCardShown;
    private boolean floatingWakeShown;

    public final y7.o a() {
        return (this.floatingCardShown || this.floatingWakeShown) ? y7.o.INSTANCE.h() : this.baseEffect;
    }

    /* renamed from: b, reason: from getter */
    public final boolean getFloatingCardShown() {
        return this.floatingCardShown;
    }

    /* renamed from: c, reason: from getter */
    public final boolean getFloatingWakeShown() {
        return this.floatingWakeShown;
    }

    public final boolean d() {
        return (!this.desktopKeyboardRaised || this.floatingCardShown || this.floatingWakeShown) ? false : true;
    }

    public final void e(y7.o oVar) {
        kotlin.jvm.internal.p.i(oVar, "<set-?>");
        this.baseEffect = oVar;
    }

    public final void f(boolean z10) {
        this.desktopKeyboardRaised = z10;
    }

    public final void g(boolean z10) {
        this.floatingCardShown = z10;
    }

    public final void h(boolean z10) {
        this.floatingWakeShown = z10;
    }
}
