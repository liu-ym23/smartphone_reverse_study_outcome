package H;

import android.util.Range;
import androidx.camera.core.featuregroup.impl.feature.FeatureTypeInternal;
import com.autonavi.aps.amapapi.config.Const;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \u00152\u00020\u0001:\u0001\u0016B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\b\u0010\tR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\n\u0010\fR\u0017\u0010\u0004\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\r\u0010\u000b\u001a\u0004\b\u000e\u0010\fR\u001a\u0010\u0014\u001a\u00020\u000f8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u0017"}, d2 = {"LH/b;", "LF/b;", "", "minFps", "maxFps", "<init>", "(II)V", "", "toString", "()Ljava/lang/String;", Const.INTENT_KEY_BACKGROUND_COMMAND, "I", "()I", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "f", "Landroidx/camera/core/featuregroup/impl/feature/FeatureTypeInternal;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "Landroidx/camera/core/featuregroup/impl/feature/FeatureTypeInternal;", "c", "()Landroidx/camera/core/featuregroup/impl/feature/FeatureTypeInternal;", "featureTypeInternal", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_REMOVE, Const.INTENT_KEY_APIKEY, "camera-core"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* renamed from: H.b, reason: from toString */
/* loaded from: classes.dex */
public final class FpsRangeFeature extends F.b {

    /* renamed from: k, reason: collision with root package name */
    public static final Range<Integer> f2908k = new Range<>(30, 30);

    /* renamed from: g, reason: collision with root package name and from kotlin metadata and from toString */
    public final int minFps;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata and from toString */
    public final int maxFps;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    public final FeatureTypeInternal featureTypeInternal = FeatureTypeInternal.FPS_RANGE;

    public FpsRangeFeature(int i10, int i11) {
        this.minFps = i10;
        this.maxFps = i11;
    }

    @Override // F.b
    /* renamed from: c, reason: from getter */
    public FeatureTypeInternal getFeatureTypeInternal() {
        return this.featureTypeInternal;
    }

    /* renamed from: f, reason: from getter */
    public final int getMaxFps() {
        return this.maxFps;
    }

    /* renamed from: g, reason: from getter */
    public final int getMinFps() {
        return this.minFps;
    }

    public String toString() {
        return "FpsRangeFeature(minFps=" + this.minFps + ", maxFps=" + this.maxFps + ')';
    }
}
