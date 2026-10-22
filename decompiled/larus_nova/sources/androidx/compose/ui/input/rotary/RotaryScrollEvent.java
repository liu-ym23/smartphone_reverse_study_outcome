package androidx.compose.ui.input.rotary;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0007\u0018\u00002\u00020\u0001B)\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nJ\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\u0015\u001a\u00020\bH\u0016J\b\u0010\u0016\u001a\u00020\u0017H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u0018"}, d2 = {"Landroidx/compose/ui/input/rotary/RotaryScrollEvent;", "", "verticalScrollPixels", "", "horizontalScrollPixels", "uptimeMillis", "", "inputDeviceId", "", "<init>", "(FFJI)V", "getVerticalScrollPixels", "()F", "getHorizontalScrollPixels", "getUptimeMillis", "()J", "getInputDeviceId", "()I", "equals", "", "other", "hashCode", "toString", "", "ui_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class RotaryScrollEvent {
    public static final int $stable = 0;
    private final float horizontalScrollPixels;
    private final int inputDeviceId;
    private final long uptimeMillis;
    private final float verticalScrollPixels;

    public int hashCode() {
        int r100 = ((Float.floatToIntBits(this.verticalScrollPixels) * 31) + Float.floatToIntBits(this.horizontalScrollPixels)) * 31;
        long r101 = this.uptimeMillis;
        return ((r100 + ((int) (r101 ^ (r101 >>> 32)))) * 31) + this.inputDeviceId;
    }

    public String toString() {
        return "RotaryScrollEvent(verticalScrollPixels=" + this.verticalScrollPixels + ",horizontalScrollPixels=" + this.horizontalScrollPixels + ",uptimeMillis=" + this.uptimeMillis + ",deviceId=" + this.inputDeviceId + ')';
    }

    public final float getHorizontalScrollPixels() {
        return this.horizontalScrollPixels;
    }

    public final int getInputDeviceId() {
        return this.inputDeviceId;
    }

    public final long getUptimeMillis() {
        return this.uptimeMillis;
    }

    public final float getVerticalScrollPixels() {
        return this.verticalScrollPixels;
    }

    public boolean equals(Object r100) {
        if ((r100 instanceof RotaryScrollEvent) == false) goto L20;
        RotaryScrollEvent r101 = (RotaryScrollEvent) r100;
        if (r101.verticalScrollPixels != this.verticalScrollPixels) goto L7;
        boolean r102 = true;
    L8:
        if (r102 == true) goto L10;
        return false;
    L10:
        if (r101.horizontalScrollPixels != this.horizontalScrollPixels) goto L12;
        boolean r103 = true;
    L13:
        if (r103 == true) goto L15;
        return false;
    L15:
        if (r101.uptimeMillis == this.uptimeMillis) goto L17;
        return false;
    L17:
        if (r101.inputDeviceId != this.inputDeviceId) goto L24;
        return true;
    L24:
        return false;
    L12:
        r103 = false;
        goto L13
    L7:
        r102 = false;
        goto L8
    L20:
        return false;
    }

    public RotaryScrollEvent(float r100, float r101, long r102, int r103) {
        this.verticalScrollPixels = r100;
        this.horizontalScrollPixels = r101;
        this.uptimeMillis = r102;
        this.inputDeviceId = r103;
    }
}
