package H;

import D.B;
import D.C0761b0;
import D.o0;
import K.InterfaceC0898v;
import androidx.camera.core.UseCase;
import androidx.camera.core.featuregroup.impl.feature.FeatureTypeInternal;
import com.autonavi.aps.amapapi.config.Const;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\b\u0000\u0018\u0000 \u001a2\u00020\u0001:\u0001\u001bB\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u001f\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\u000e\u001a\u00020\rH\u0016¢\u0006\u0004\b\u000e\u0010\u000fR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\u001a\u0010\u0019\u001a\u00020\u00148\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018¨\u0006\u001c"}, d2 = {"LH/a;", "LF/b;", "LD/B;", "dynamicRange", "<init>", "(LD/B;)V", "LK/v;", "cameraInfoInternal", "LD/o0;", "sessionConfig", "", Const.INTENT_KEY_UMID, "(LK/v;LD/o0;)Z", "", "toString", "()Ljava/lang/String;", Const.INTENT_KEY_BACKGROUND_COMMAND, "LD/B;", "f", "()LD/B;", "Landroidx/camera/core/featuregroup/impl/feature/FeatureTypeInternal;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "Landroidx/camera/core/featuregroup/impl/feature/FeatureTypeInternal;", "c", "()Landroidx/camera/core/featuregroup/impl/feature/FeatureTypeInternal;", "featureTypeInternal", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, Const.INTENT_KEY_APIKEY, "camera-core"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* renamed from: H.a, reason: from toString */
/* loaded from: classes.dex */
public final class DynamicRangeFeature extends F.b {

    /* renamed from: j, reason: collision with root package name */
    public static final B f2904j;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata and from toString */
    public final B dynamicRange;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    public final FeatureTypeInternal featureTypeInternal;

    static {
        B SDR = B.f1998d;
        p.h(SDR, "SDR");
        f2904j = SDR;
    }

    public DynamicRangeFeature(B dynamicRange) {
        p.i(dynamicRange, "dynamicRange");
        this.dynamicRange = dynamicRange;
        this.featureTypeInternal = FeatureTypeInternal.DYNAMIC_RANGE;
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
        Set<B> setC = cameraInfoInternal.c();
        p.h(setC, "getSupportedDynamicRanges(...)");
        C0761b0.a("DynamicRangeFeature", "isSupportedIndividually: cameraInfoSupportedDynamicRanges = " + setC + ", this = " + this);
        if (!setC.contains(this.dynamicRange)) {
            return false;
        }
        for (UseCase useCase : sessionConfig.m()) {
            Set<B> setA = useCase.A(cameraInfoInternal);
            C0761b0.a("DynamicRangeFeature", "isSupportedIndividually: useCaseSupportedDynamicRanges = " + setA + ", this = " + this + ", useCases = " + useCase);
            if (setA != null && !setA.contains(this.dynamicRange)) {
                return false;
            }
        }
        return true;
    }

    /* renamed from: f, reason: from getter */
    public final B getDynamicRange() {
        return this.dynamicRange;
    }

    public String toString() {
        return "DynamicRangeFeature(dynamicRange=" + this.dynamicRange + ')';
    }
}
