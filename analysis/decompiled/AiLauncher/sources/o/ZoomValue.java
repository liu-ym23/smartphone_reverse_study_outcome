package o;

import D.F0;
import com.autonavi.aps.amapapi.config.Const;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\b\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u000b\u001a\u00020\nHÖ\u0001¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u000e\u001a\u00020\rHÖ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u001a\u0010\u0013\u001a\u00020\u00122\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010HÖ\u0003¢\u0006\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\b\u0010\u0015R\u0014\u0010\u0004\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0015R\u0014\u0010\u0005\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010\u0015¨\u0006\u0018"}, d2 = {"Lo/P;", "LD/F0;", "", "zoomRatio", "minZoomRatio", "maxZoomRatio", "<init>", "(FFF)V", Const.INTENT_KEY_APIKEY, "()F", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "F", Const.INTENT_KEY_PKGNAME, "c", "camera-camera2"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* renamed from: o.P, reason: from toString */
/* loaded from: classes.dex */
public final /* data */ class ZoomValue implements F0 {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    public final float zoomRatio;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    public final float minZoomRatio;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    public final float maxZoomRatio;

    public ZoomValue(float f10, float f11, float f12) {
        this.zoomRatio = f10;
        this.minZoomRatio = f11;
        this.maxZoomRatio = f12;
    }

    @Override // D.F0
    /* renamed from: a, reason: from getter */
    public float getZoomRatio() {
        return this.zoomRatio;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ZoomValue)) {
            return false;
        }
        ZoomValue zoomValue = (ZoomValue) other;
        return Float.compare(this.zoomRatio, zoomValue.zoomRatio) == 0 && Float.compare(this.minZoomRatio, zoomValue.minZoomRatio) == 0 && Float.compare(this.maxZoomRatio, zoomValue.maxZoomRatio) == 0;
    }

    public int hashCode() {
        return (((Float.hashCode(this.zoomRatio) * 31) + Float.hashCode(this.minZoomRatio)) * 31) + Float.hashCode(this.maxZoomRatio);
    }

    public String toString() {
        return "ZoomValue(zoomRatio=" + this.zoomRatio + ", minZoomRatio=" + this.minZoomRatio + ", maxZoomRatio=" + this.maxZoomRatio + ')';
    }
}
