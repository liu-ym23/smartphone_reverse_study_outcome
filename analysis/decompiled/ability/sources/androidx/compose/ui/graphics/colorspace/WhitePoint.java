package androidx.compose.ui.graphics.colorspace;

import androidx.annotation.Size;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u000b\n\u0002\u0010\u0014\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006B!\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\bB)\b\u0012\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\nJ\r\u0010\u000e\u001a\u00020\u000fH\u0001¢\u0006\u0002\b\u0010J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\f¨\u0006\u001b"}, d2 = {"Landroidx/compose/ui/graphics/colorspace/WhitePoint;", "", "x", "", "y", AppAgent.CONSTRUCT, "(FF)V", "z", "(FFF)V", "sum", "(FFFF)V", "getX", "()F", "getY", "toXyz", "", "toXyz$ui_graphics_release", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "ui-graphics_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
public final /* data */ class WhitePoint {
    private final float x;
    private final float y;

    public WhitePoint(float f, float f7) {
        this.x = f;
        this.y = f7;
    }

    public static /* synthetic */ WhitePoint copy$default(WhitePoint whitePoint, float f, float f7, int i, Object obj) {
        if ((i & 1) != 0) {
            f = whitePoint.x;
        }
        if ((i & 2) != 0) {
            f7 = whitePoint.y;
        }
        return whitePoint.copy(f, f7);
    }

    /* renamed from: component1, reason: from getter */
    public final float getX() {
        return this.x;
    }

    /* renamed from: component2, reason: from getter */
    public final float getY() {
        return this.y;
    }

    public final WhitePoint copy(float x10, float y) {
        return new WhitePoint(x10, y);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof WhitePoint)) {
            return false;
        }
        WhitePoint whitePoint = (WhitePoint) other;
        return Float.compare(this.x, whitePoint.x) == 0 && Float.compare(this.y, whitePoint.y) == 0;
    }

    public final float getX() {
        return this.x;
    }

    public final float getY() {
        return this.y;
    }

    public int hashCode() {
        return Float.hashCode(this.y) + (Float.hashCode(this.x) * 31);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("WhitePoint(x=");
        sb.append(this.x);
        sb.append(", y=");
        return androidx.appfunctions.metadata.a.n(sb, this.y, ')');
    }

    @Size(3)
    public final float[] toXyz$ui_graphics_release() {
        float f = this.x;
        float f7 = this.y;
        return new float[]{f / f7, 1.0f, ((1.0f - f) - f7) / f7};
    }

    public WhitePoint(float f, float f7, float f9) {
        this(f, f7, f9, f + f7 + f9);
    }

    private WhitePoint(float f, float f7, float f9, float f10) {
        this(f / f10, f7 / f10);
    }
}
