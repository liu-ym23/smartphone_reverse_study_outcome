package H;

import D.o0;
import K.InterfaceC0898v;
import androidx.camera.core.featuregroup.impl.feature.FeatureTypeInternal;
import androidx.camera.core.impl.stabilization.VideoStabilization;
import com.autonavi.aps.amapapi.config.Const;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \u001a2\u00020\u0001:\u0001\u001bB\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u001f\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\u000e\u001a\u00020\rH\u0016¢\u0006\u0004\b\u000e\u0010\u000fR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\u001a\u0010\u0019\u001a\u00020\u00148\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018¨\u0006\u001c"}, d2 = {"LH/d;", "LF/b;", "Landroidx/camera/core/impl/stabilization/VideoStabilization;", "videoStabilization", "<init>", "(Landroidx/camera/core/impl/stabilization/VideoStabilization;)V", "LK/v;", "cameraInfoInternal", "LD/o0;", "sessionConfig", "", Const.INTENT_KEY_UMID, "(LK/v;LD/o0;)Z", "", "toString", "()Ljava/lang/String;", Const.INTENT_KEY_BACKGROUND_COMMAND, "Landroidx/camera/core/impl/stabilization/VideoStabilization;", "f", "()Landroidx/camera/core/impl/stabilization/VideoStabilization;", "Landroidx/camera/core/featuregroup/impl/feature/FeatureTypeInternal;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "Landroidx/camera/core/featuregroup/impl/feature/FeatureTypeInternal;", "c", "()Landroidx/camera/core/featuregroup/impl/feature/FeatureTypeInternal;", "featureTypeInternal", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, Const.INTENT_KEY_APIKEY, "camera-core"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* renamed from: H.d, reason: from toString */
/* loaded from: classes.dex */
public final class VideoStabilizationFeature extends F.b {

    /* renamed from: j, reason: collision with root package name */
    public static final VideoStabilization f2916j = VideoStabilization.OFF;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    public final VideoStabilization videoStabilization;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    public final FeatureTypeInternal featureTypeInternal;

    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    /* renamed from: H.d$b */
    public static final /* synthetic */ class b {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f2919a;

        static {
            int[] iArr = new int[VideoStabilization.values().length];
            try {
                iArr[VideoStabilization.ON.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[VideoStabilization.PREVIEW.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[VideoStabilization.OFF.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[VideoStabilization.UNSPECIFIED.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            f2919a = iArr;
        }
    }

    public VideoStabilizationFeature(VideoStabilization videoStabilization) {
        p.i(videoStabilization, "videoStabilization");
        this.videoStabilization = videoStabilization;
        this.featureTypeInternal = FeatureTypeInternal.VIDEO_STABILIZATION;
    }

    @Override // F.b
    /* renamed from: c, reason: from getter */
    public FeatureTypeInternal getFeatureTypeInternal() {
        return this.featureTypeInternal;
    }

    @Override // F.b
    public boolean d(InterfaceC0898v cameraInfoInternal, o0 sessionConfig) {
        p.i(cameraInfoInternal, "cameraInfoInternal");
        p.i(sessionConfig, "sessionConfig");
        int i10 = b.f2919a[this.videoStabilization.ordinal()];
        if (i10 == 1) {
            return cameraInfoInternal.v();
        }
        if (i10 == 2) {
            return cameraInfoInternal.B();
        }
        if (i10 == 3 || i10 == 4) {
            return true;
        }
        throw new NoWhenBranchMatchedException();
    }

    /* renamed from: f, reason: from getter */
    public final VideoStabilization getVideoStabilization() {
        return this.videoStabilization;
    }

    public String toString() {
        return "VideoStabilizationFeature(mode=" + this.videoStabilization.name() + ')';
    }
}
