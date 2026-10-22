package r;

import D.C0761b0;
import android.hardware.camera2.params.StreamConfigurationMap;
import android.util.Size;
import androidx.camera.camera2.compat.quirk.ExcludedSupportedSizesQuirk;
import androidx.camera.camera2.compat.quirk.ExtraSupportedOutputSizeQuirk;
import com.autonavi.aps.amapapi.config.Const;
import java.util.List;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010!\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B\u001d\b\u0007\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0006\u0010\u0007J)\u0010\r\u001a\b\u0012\u0004\u0012\u00020\t0\b2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u0006\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\r\u0010\u000eJ%\u0010\u0012\u001a\u00020\u00112\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\t0\u000f2\u0006\u0010\f\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\u0012\u0010\u0013J%\u0010\u0014\u001a\u00020\u00112\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\t0\u000f2\u0006\u0010\f\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\u0014\u0010\u0013R\u0016\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0015R\u0016\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u0016R\u0014\u0010\u0019\u001a\u00020\u00178\u0002X\u0082D¢\u0006\u0006\n\u0004\b\u0014\u0010\u0018R\u0016\u0010\u001d\u001a\u0004\u0018\u00010\u001a8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0016\u0010!\u001a\u0004\u0018\u00010\u001e8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001f\u0010 ¨\u0006\""}, d2 = {"Lr/y;", "", "Landroidx/camera/camera2/pipe/g;", "cameraMetadata", "Landroid/hardware/camera2/params/StreamConfigurationMap;", "streamConfigurationMap", "<init>", "(Landroidx/camera/camera2/pipe/g;Landroid/hardware/camera2/params/StreamConfigurationMap;)V", "", "Landroid/util/Size;", "sizes", "", "format", Const.INTENT_KEY_PKGNAME, "([Landroid/util/Size;I)[Landroid/util/Size;", "", "sizeList", "LY8/t;", Const.INTENT_KEY_APIKEY, "(Ljava/util/List;I)V", "c", "Landroidx/camera/camera2/pipe/g;", "Landroid/hardware/camera2/params/StreamConfigurationMap;", "", "Ljava/lang/String;", "tag", "Landroidx/camera/camera2/compat/quirk/ExcludedSupportedSizesQuirk;", Const.INTENT_KEY_UMID, "Landroidx/camera/camera2/compat/quirk/ExcludedSupportedSizesQuirk;", "excludedSupportedSizesQuirk", "Landroidx/camera/camera2/compat/quirk/ExtraSupportedOutputSizeQuirk;", "e", "Landroidx/camera/camera2/compat/quirk/ExtraSupportedOutputSizeQuirk;", "extraSupportedOutputSizeQuirk", "camera-camera2"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes.dex */
public final class y {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final androidx.camera.camera2.pipe.g cameraMetadata;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public final StreamConfigurationMap streamConfigurationMap;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    public final String tag = "OutputSizesCorrector";

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    public final ExcludedSupportedSizesQuirk excludedSupportedSizesQuirk;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    public final ExtraSupportedOutputSizeQuirk extraSupportedOutputSizeQuirk;

    public y(androidx.camera.camera2.pipe.g gVar, StreamConfigurationMap streamConfigurationMap) {
        this.cameraMetadata = gVar;
        this.streamConfigurationMap = streamConfigurationMap;
        q.f fVar = q.f.f38470a;
        this.excludedSupportedSizesQuirk = (ExcludedSupportedSizesQuirk) fVar.c(ExcludedSupportedSizesQuirk.class);
        this.extraSupportedOutputSizeQuirk = (ExtraSupportedOutputSizeQuirk) fVar.c(ExtraSupportedOutputSizeQuirk.class);
    }

    public final void a(List<Size> sizeList, int format) {
        ExtraSupportedOutputSizeQuirk extraSupportedOutputSizeQuirk = this.extraSupportedOutputSizeQuirk;
        if (extraSupportedOutputSizeQuirk == null) {
            return;
        }
        Size[] sizeArrC = extraSupportedOutputSizeQuirk.c(format);
        if (sizeArrC.length == 0) {
            return;
        }
        Z8.A.F(sizeList, sizeArrC);
    }

    public final Size[] b(Size[] sizes, int format) {
        kotlin.jvm.internal.p.i(sizes, "sizes");
        List<Size> listD1 = Z8.r.d1(sizes);
        a(listD1, format);
        c(listD1, format);
        if (listD1.isEmpty()) {
            C0761b0.o(this.tag, "Sizes array becomes empty after excluding problematic output sizes.");
        }
        return (Size[]) listD1.toArray(new Size[0]);
    }

    public final void c(List<Size> sizeList, int format) {
        ExcludedSupportedSizesQuirk excludedSupportedSizesQuirk;
        androidx.camera.camera2.pipe.g gVar = this.cameraMetadata;
        if (gVar == null || (excludedSupportedSizesQuirk = this.excludedSupportedSizesQuirk) == null) {
            return;
        }
        List<Size> listC = excludedSupportedSizesQuirk.c(gVar.getCamera(), format);
        if (listC.isEmpty()) {
            return;
        }
        sizeList.removeAll(listC);
    }
}
