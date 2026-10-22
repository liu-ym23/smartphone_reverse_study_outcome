package com.stepos.ailauncher.chat.wake.blur;

import com.autonavi.aps.amapapi.config.Const;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\t\b\u0086\b\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\n\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\f\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u0010\u001a\u00020\u000f2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0010\u0010\u0011R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0012\u001a\u0004\b\u0013\u0010\rR\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R\u0017\u0010\u0006\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0012\u001a\u0004\b\u0017\u0010\r¨\u0006\u0018"}, d2 = {"Lcom/stepos/ailauncher/chat/wake/blur/a;", "", "", "radius", "", "cornerRadius", "tintColor", "<init>", "(IFI)V", "", "toString", "()Ljava/lang/String;", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "I", Const.INTENT_KEY_PKGNAME, "F", Const.INTENT_KEY_APIKEY, "()F", "c", "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* renamed from: com.stepos.ailauncher.chat.wake.blur.a, reason: from toString */
/* loaded from: classes3.dex */
public final /* data */ class BlurConfig {
    private final float cornerRadius;
    private final int radius;
    private final int tintColor;

    public BlurConfig(int i10, float f10, int i11) {
        this.radius = i10;
        this.cornerRadius = f10;
        this.tintColor = i11;
    }

    /* renamed from: a, reason: from getter */
    public final float getCornerRadius() {
        return this.cornerRadius;
    }

    /* renamed from: b, reason: from getter */
    public final int getRadius() {
        return this.radius;
    }

    /* renamed from: c, reason: from getter */
    public final int getTintColor() {
        return this.tintColor;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof BlurConfig)) {
            return false;
        }
        BlurConfig blurConfig = (BlurConfig) other;
        return this.radius == blurConfig.radius && Float.compare(this.cornerRadius, blurConfig.cornerRadius) == 0 && this.tintColor == blurConfig.tintColor;
    }

    public int hashCode() {
        return (((Integer.hashCode(this.radius) * 31) + Float.hashCode(this.cornerRadius)) * 31) + Integer.hashCode(this.tintColor);
    }

    public String toString() {
        return "BlurConfig(radius=" + this.radius + ", cornerRadius=" + this.cornerRadius + ", tintColor=" + this.tintColor + ")";
    }
}
