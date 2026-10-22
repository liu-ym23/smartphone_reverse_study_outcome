package com.stepos.ailauncher.chat.voice.motionkit;

import com.autonavi.aps.amapapi.config.Const;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0007\n\u0002\b\t\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\t\b\u0086\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0002\u0012\u0006\u0010\u0006\u001a\u00020\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0015\u0010\n\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\r\u001a\u00020\fHÖ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u0010\u001a\u00020\u000fHÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u001a\u0010\u0014\u001a\u00020\u00132\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0014\u0010\u0015R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R\u0017\u0010\u0004\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0016\u001a\u0004\b\u0019\u0010\u0018R\u0017\u0010\u0005\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0016\u001a\u0004\b\u001a\u0010\u0018R\u0017\u0010\u0006\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0016\u001a\u0004\b\u001b\u0010\u0018¨\u0006\u001c"}, d2 = {"Lcom/stepos/ailauncher/chat/voice/motionkit/g;", "", "", "x1", "y1", "x2", "y2", "<init>", "(FFFF)V", "t", Const.INTENT_KEY_APIKEY, "(F)F", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "F", "getX1", "()F", "getY1", "getX2", "getY2", "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* renamed from: com.stepos.ailauncher.chat.voice.motionkit.g, reason: case insensitive filesystem and from toString */
/* loaded from: classes3.dex */
public final /* data */ class CubicBezier {
    private final float x1;
    private final float x2;
    private final float y1;
    private final float y2;

    public CubicBezier(float f10, float f11, float f12, float f13) {
        this.x1 = f10;
        this.y1 = f11;
        this.x2 = f12;
        this.y2 = f13;
    }

    public final float a(float t10) {
        return C3068h.d(this.x1, this.y1, this.x2, this.y2, t10);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof CubicBezier)) {
            return false;
        }
        CubicBezier cubicBezier = (CubicBezier) other;
        return Float.compare(this.x1, cubicBezier.x1) == 0 && Float.compare(this.y1, cubicBezier.y1) == 0 && Float.compare(this.x2, cubicBezier.x2) == 0 && Float.compare(this.y2, cubicBezier.y2) == 0;
    }

    public int hashCode() {
        return (((((Float.hashCode(this.x1) * 31) + Float.hashCode(this.y1)) * 31) + Float.hashCode(this.x2)) * 31) + Float.hashCode(this.y2);
    }

    public String toString() {
        return "CubicBezier(x1=" + this.x1 + ", y1=" + this.y1 + ", x2=" + this.x2 + ", y2=" + this.y2 + ")";
    }
}
