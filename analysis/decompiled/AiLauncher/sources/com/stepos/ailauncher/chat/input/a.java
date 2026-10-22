package com.stepos.ailauncher.chat.input;

import com.autonavi.aps.amapapi.config.Const;
import com.stepos.statsapp.v3.lib.plugin.constants.UxipConstants;
import kotlin.Metadata;
import v9.C5685n;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0011\b\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bJ\u0015\u0010\u000b\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\u000b\u0010\fJ\u0015\u0010\u000e\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\u0004¢\u0006\u0004\b\u000e\u0010\bR$\u0010\u0010\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\t8\u0006@BX\u0086\u000e¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R$\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u00048\u0006@BX\u0086\u000e¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\u0016\u0010\u0018\u001a\u00020\t8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0018\u0010\u0011R\u0016\u0010\u0019\u001a\u00020\t8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0019\u0010\u0011¨\u0006\u001a"}, d2 = {"Lcom/stepos/ailauncher/chat/input/a;", "", "<init>", "()V", "", "showing", "LY8/t;", "e", "(Z)V", "", "easedFraction", "c", "(F)V", "shown", Const.INTENT_KEY_UMID, UxipConstants.f30680s, "shortAlpha", "F", Const.INTENT_KEY_PKGNAME, "()F", "running", "Z", Const.INTENT_KEY_APIKEY, "()Z", "startAlpha", "targetAlpha", "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class a {
    private boolean running;
    private float shortAlpha;
    private float startAlpha;
    private float targetAlpha;

    /* renamed from: a, reason: from getter */
    public final boolean getRunning() {
        return this.running;
    }

    /* renamed from: b, reason: from getter */
    public final float getShortAlpha() {
        return this.shortAlpha;
    }

    public final void c(float easedFraction) {
        if (this.running) {
            float f10 = this.startAlpha;
            this.shortAlpha = f10 + ((this.targetAlpha - f10) * C5685n.m(easedFraction, 0.0f, 1.0f));
        }
    }

    public final void d(boolean shown) {
        this.running = false;
        this.shortAlpha = shown ? 1.0f : 0.0f;
    }

    public final void e(boolean showing) {
        this.startAlpha = this.shortAlpha;
        this.targetAlpha = showing ? 1.0f : 0.0f;
        this.running = true;
    }
}
