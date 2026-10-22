package androidx.camera.camera2.compat.quirk;

import Y8.h;
import android.annotation.SuppressLint;
import android.hardware.camera2.CameraCharacteristics;
import android.util.Range;
import androidx.camera.camera2.compat.quirk.AeFpsRangeLegacyQuirk;
import androidx.camera.camera2.pipe.g;
import androidx.camera.core.impl.y;
import androidx.camera.core.internal.compat.quirk.AeFpsRangeQuirk;
import com.autonavi.aps.amapapi.config.Const;
import kotlin.C4848b;
import kotlin.Metadata;
import kotlin.jvm.internal.i;
import kotlin.jvm.internal.p;
import p9.InterfaceC5063a;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\f\b\u0007\u0018\u0000 \u00152\u00020\u0001:\u0001\bB\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0015\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\u0016¢\u0006\u0004\b\b\u0010\tJ/\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00062\u0016\u0010\u000b\u001a\u0012\u0012\f\b\u0001\u0012\b\u0012\u0004\u0012\u00020\u00070\u0006\u0018\u00010\nH\u0002¢\u0006\u0004\b\f\u0010\rJ#\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\u0002¢\u0006\u0004\b\u000f\u0010\u0010R#\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00068BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\t¨\u0006\u0016"}, d2 = {"Landroidx/camera/camera2/compat/quirk/AeFpsRangeLegacyQuirk;", "Landroidx/camera/core/internal/compat/quirk/AeFpsRangeQuirk;", "Landroidx/camera/camera2/pipe/g;", "cameraMetadata", "<init>", "(Landroidx/camera/camera2/pipe/g;)V", "Landroid/util/Range;", "", Const.INTENT_KEY_APIKEY, "()Landroid/util/Range;", "", "availableFpsRanges", "f", "([Landroid/util/Range;)Landroid/util/Range;", "fpsRange", Const.INTENT_KEY_UMID, "(Landroid/util/Range;)Landroid/util/Range;", Const.INTENT_KEY_PKGNAME, "LY8/h;", "e", "range", "c", "camera-camera2"}, k = 1, mv = {2, 1, 0}, xi = 48)
@SuppressLint({"CameraXQuirksClassDetector"})
/* loaded from: classes.dex */
public final class AeFpsRangeLegacyQuirk implements AeFpsRangeQuirk {

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public final h range;

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Landroidx/camera/camera2/compat/quirk/AeFpsRangeLegacyQuirk$a;", "", "<init>", "()V", "Landroidx/camera/camera2/pipe/g;", "cameraMetadata", "", Const.INTENT_KEY_APIKEY, "(Landroidx/camera/camera2/pipe/g;)Z", "camera-camera2"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* renamed from: androidx.camera.camera2.compat.quirk.AeFpsRangeLegacyQuirk$a, reason: from kotlin metadata */
    public static final class Companion {
        public /* synthetic */ Companion(i iVar) {
            this();
        }

        public final boolean a(g cameraMetadata) {
            p.i(cameraMetadata, "cameraMetadata");
            return g.INSTANCE.l(cameraMetadata);
        }

        public Companion() {
        }
    }

    public AeFpsRangeLegacyQuirk(final g cameraMetadata) {
        p.i(cameraMetadata, "cameraMetadata");
        this.range = C4848b.b(new InterfaceC5063a() { // from class: q.a
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return AeFpsRangeLegacyQuirk.g(cameraMetadata, this);
            }
        });
    }

    public static final Range g(g gVar, AeFpsRangeLegacyQuirk aeFpsRangeLegacyQuirk) {
        CameraCharacteristics.Key CONTROL_AE_AVAILABLE_TARGET_FPS_RANGES = CameraCharacteristics.CONTROL_AE_AVAILABLE_TARGET_FPS_RANGES;
        p.h(CONTROL_AE_AVAILABLE_TARGET_FPS_RANGES, "CONTROL_AE_AVAILABLE_TARGET_FPS_RANGES");
        return aeFpsRangeLegacyQuirk.f((Range[]) gVar.e0(CONTROL_AE_AVAILABLE_TARGET_FPS_RANGES));
    }

    @Override // androidx.camera.core.internal.compat.quirk.AeFpsRangeQuirk
    public Range<Integer> a() {
        Range<Integer> rangeE = e();
        if (rangeE != null) {
            return rangeE;
        }
        Range<Integer> FRAME_RATE_RANGE_UNSPECIFIED = y.f11539a;
        p.h(FRAME_RATE_RANGE_UNSPECIFIED, "FRAME_RATE_RANGE_UNSPECIFIED");
        return FRAME_RATE_RANGE_UNSPECIFIED;
    }

    public final Range<Integer> d(Range<Integer> fpsRange) {
        Integer numValueOf = (Integer) fpsRange.getUpper();
        Integer numValueOf2 = (Integer) fpsRange.getLower();
        if (((Number) fpsRange.getUpper()).intValue() >= 1000) {
            numValueOf = Integer.valueOf(((Number) fpsRange.getUpper()).intValue() / 1000);
        }
        if (((Number) fpsRange.getLower()).intValue() >= 1000) {
            numValueOf2 = Integer.valueOf(((Number) fpsRange.getLower()).intValue() / 1000);
        }
        return new Range<>(numValueOf2, numValueOf);
    }

    public final Range<Integer> e() {
        return (Range) this.range.getValue();
    }

    public final Range<Integer> f(Range<Integer>[] availableFpsRanges) {
        Range<Integer> range = null;
        if (availableFpsRanges != null && availableFpsRanges.length != 0) {
            for (Range<Integer> range2 : availableFpsRanges) {
                Range<Integer> rangeD = d(range2);
                Integer num = (Integer) rangeD.getUpper();
                if (num != null && num.intValue() == 30 && (range == null || ((Number) rangeD.getLower()).intValue() < ((Number) range.getLower()).intValue())) {
                    range = rangeD;
                }
            }
        }
        return range;
    }
}
