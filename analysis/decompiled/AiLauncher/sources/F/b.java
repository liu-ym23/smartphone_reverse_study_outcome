package F;

import D.B;
import D.o0;
import H.DynamicRangeFeature;
import H.FpsRangeFeature;
import H.ImageFormatFeature;
import H.VideoStabilizationFeature;
import K.InterfaceC0898v;
import Y8.h;
import androidx.camera.core.featuregroup.impl.feature.FeatureTypeInternal;
import androidx.camera.core.impl.stabilization.VideoStabilization;
import com.autonavi.aps.amapapi.config.Const;
import kotlin.C4848b;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.p;
import p9.InterfaceC5063a;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\f\b&\u0018\u0000 \u00172\u00020\u0001:\u0001\u000fB\t\b\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001f\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0017¢\u0006\u0004\b\t\u0010\nJ\u0013\u0010\r\u001a\u00020\f*\u00020\u000bH\u0002¢\u0006\u0004\b\r\u0010\u000eR\u001b\u0010\u0013\u001a\u00020\f8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0016\u001a\u00020\u000b8'X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015¨\u0006\u0018"}, d2 = {"LF/b;", "", "<init>", "()V", "LK/v;", "cameraInfoInternal", "LD/o0;", "sessionConfig", "", Const.INTENT_KEY_UMID, "(LK/v;LD/o0;)Z", "Landroidx/camera/core/featuregroup/impl/feature/FeatureTypeInternal;", "", "e", "(Landroidx/camera/core/featuregroup/impl/feature/FeatureTypeInternal;)I", Const.INTENT_KEY_APIKEY, "LY8/h;", "getFeatureType", "()I", "featureType", "c", "()Landroidx/camera/core/featuregroup/impl/feature/FeatureTypeInternal;", "featureTypeInternal", Const.INTENT_KEY_PKGNAME, "camera-core"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes.dex */
public abstract class b {

    /* renamed from: c, reason: collision with root package name */
    public static final b f2525c;

    /* renamed from: d, reason: collision with root package name */
    public static final b f2526d;

    /* renamed from: e, reason: collision with root package name */
    public static final b f2527e;

    /* renamed from: f, reason: collision with root package name */
    public static final b f2528f;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final h featureType = C4848b.b(new InterfaceC5063a() { // from class: F.a
        @Override // p9.InterfaceC5063a
        public final Object invoke() {
            return Integer.valueOf(b.b(this.f2523a));
        }
    });

    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    /* renamed from: F.b$b, reason: collision with other inner class name */
    public static final /* synthetic */ class C0028b {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f2530a;

        static {
            int[] iArr = new int[FeatureTypeInternal.values().length];
            try {
                iArr[FeatureTypeInternal.DYNAMIC_RANGE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[FeatureTypeInternal.FPS_RANGE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[FeatureTypeInternal.VIDEO_STABILIZATION.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[FeatureTypeInternal.IMAGE_FORMAT.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[FeatureTypeInternal.RECORDING_QUALITY.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            f2530a = iArr;
        }
    }

    static {
        B HLG_10_BIT = B.f2000f;
        p.h(HLG_10_BIT, "HLG_10_BIT");
        f2525c = new DynamicRangeFeature(HLG_10_BIT);
        f2526d = new FpsRangeFeature(60, 60);
        f2527e = new VideoStabilizationFeature(VideoStabilization.PREVIEW);
        f2528f = new ImageFormatFeature(1);
    }

    public static final int b(b bVar) {
        return bVar.e(bVar.getFeatureTypeInternal());
    }

    /* renamed from: c */
    public abstract FeatureTypeInternal getFeatureTypeInternal();

    public boolean d(InterfaceC0898v cameraInfoInternal, o0 sessionConfig) {
        p.i(cameraInfoInternal, "cameraInfoInternal");
        p.i(sessionConfig, "sessionConfig");
        return true;
    }

    public final int e(FeatureTypeInternal featureTypeInternal) {
        int i10 = C0028b.f2530a[featureTypeInternal.ordinal()];
        if (i10 == 1) {
            return 0;
        }
        if (i10 == 2) {
            return 1;
        }
        if (i10 == 3) {
            return 2;
        }
        if (i10 == 4) {
            return 3;
        }
        if (i10 == 5) {
            return 4;
        }
        throw new NoWhenBranchMatchedException();
    }
}
