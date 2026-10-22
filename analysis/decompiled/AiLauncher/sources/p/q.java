package p;

import D.C0761b0;
import android.hardware.camera2.params.StreamConfigurationMap;
import android.util.Log;
import android.util.Range;
import android.util.Size;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.ailauncher.chat.voice.support.C3081a;
import io.ktor.http.ContentDisposition;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import r.y;
import t.C5473b;

@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001:\u0001\u0010B\u001b\b\u0007\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0015\u0010\n\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\b¢\u0006\u0004\b\n\u0010\u000bJ\u001d\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\b2\u0006\u0010\f\u001a\u00020\t¢\u0006\u0004\b\u000e\u0010\u000fJ\u001d\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\b2\u0006\u0010\f\u001a\u00020\t¢\u0006\u0004\b\u0010\u0010\u000fJ#\u0010\u0013\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\u0012\u0018\u00010\b2\u0006\u0010\u0011\u001a\u00020\r¢\u0006\u0004\b\u0013\u0010\u0014J\u0015\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\b¢\u0006\u0004\b\u0015\u0010\u0016J\u001d\u0010\u0018\u001a\u00020\u00172\u0006\u0010\f\u001a\u00020\t2\u0006\u0010\u0011\u001a\u00020\r¢\u0006\u0004\b\u0018\u0010\u0019J\u000f\u0010\u001a\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u001a\u0010\u001bR\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u001cR\u0014\u0010\u001f\u001a\u00020\u001d8\u0002X\u0082D¢\u0006\u0006\n\u0004\b\u0013\u0010\u001eR&\u0010\"\u001a\u0014\u0012\u0004\u0012\u00020\t\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\b0 8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010!R(\u0010#\u001a\u0016\u0012\u0004\u0012\u00020\t\u0012\f\u0012\n\u0012\u0004\u0012\u00020\r\u0018\u00010\b0 8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\n\u0010!R*\u0010%\u001a\u0018\u0012\b\u0012\u0006\u0012\u0002\b\u00030$\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\b0 8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010!R\u0016\u0010(\u001a\u00020&8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000e\u0010'¨\u0006)"}, d2 = {"Lp/q;", "", "Landroid/hardware/camera2/params/StreamConfigurationMap;", C3081a.FOCUS_MAP_NAME, "Lr/y;", "outputSizesCorrector", "<init>", "(Landroid/hardware/camera2/params/StreamConfigurationMap;Lr/y;)V", "", "", Const.INTENT_KEY_UMID, "()[Ljava/lang/Integer;", "format", "Landroid/util/Size;", "f", "(I)[Landroid/util/Size;", Const.INTENT_KEY_APIKEY, ContentDisposition.Parameters.Size, "Landroid/util/Range;", Const.INTENT_KEY_PKGNAME, "(Landroid/util/Size;)[Landroid/util/Range;", "c", "()[Landroid/util/Size;", "", "e", "(ILandroid/util/Size;)J", Const.INTENT_KEY_BACKGROUND_COMMAND, "()Landroid/hardware/camera2/params/StreamConfigurationMap;", "Lr/y;", "", "Ljava/lang/String;", "tag", "", "Ljava/util/Map;", "cachedFormatOutputSizes", "cachedFormatHighResolutionOutputSizes", "Ljava/lang/Class;", "cachedClassOutputSizes", "Lp/q$a;", "Lp/q$a;", "impl", "camera-camera2"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes.dex */
public final class q {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final y outputSizesCorrector;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public final String tag;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    public final Map<Integer, Size[]> cachedFormatOutputSizes;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    public final Map<Integer, Size[]> cachedFormatHighResolutionOutputSizes;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    public final Map<Class<?>, Size[]> cachedClassOutputSizes;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    public a impl;

    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0011\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b`\u0018\u00002\u00020\u0001J\u0017\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002H&¢\u0006\u0004\b\u0004\u0010\u0005J\u001f\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00022\u0006\u0010\u0006\u001a\u00020\u0003H&¢\u0006\u0004\b\b\u0010\tJ\u001f\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00022\u0006\u0010\u0006\u001a\u00020\u0003H&¢\u0006\u0004\b\n\u0010\tJ%\u0010\r\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\f\u0018\u00010\u00022\u0006\u0010\u000b\u001a\u00020\u0007H&¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0002H&¢\u0006\u0004\b\u000f\u0010\u0010J\u001f\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\u0007H&¢\u0006\u0004\b\u0012\u0010\u0013J\u0011\u0010\u0015\u001a\u0004\u0018\u00010\u0014H&¢\u0006\u0004\b\u0015\u0010\u0016ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0017À\u0006\u0001"}, d2 = {"Lp/q$a;", "", "", "", Const.INTENT_KEY_UMID, "()[Ljava/lang/Integer;", "format", "Landroid/util/Size;", "c", "(I)[Landroid/util/Size;", Const.INTENT_KEY_BACKGROUND_COMMAND, ContentDisposition.Parameters.Size, "Landroid/util/Range;", "f", "(Landroid/util/Size;)[Landroid/util/Range;", "e", "()[Landroid/util/Size;", "", Const.INTENT_KEY_PKGNAME, "(ILandroid/util/Size;)J", "Landroid/hardware/camera2/params/StreamConfigurationMap;", Const.INTENT_KEY_APIKEY, "()Landroid/hardware/camera2/params/StreamConfigurationMap;", "camera-camera2"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public interface a {
        StreamConfigurationMap a();

        long b(int format, Size size);

        Size[] c(int format);

        Integer[] d();

        Size[] e();

        Range<Integer>[] f(Size size) throws IllegalArgumentException;

        Size[] g(int format);
    }

    public q(StreamConfigurationMap streamConfigurationMap, y outputSizesCorrector) {
        kotlin.jvm.internal.p.i(outputSizesCorrector, "outputSizesCorrector");
        this.outputSizesCorrector = outputSizesCorrector;
        this.tag = "StreamConfigurationMapCompat";
        this.cachedFormatOutputSizes = new LinkedHashMap();
        this.cachedFormatHighResolutionOutputSizes = new LinkedHashMap();
        this.cachedClassOutputSizes = new LinkedHashMap();
        this.impl = new r(streamConfigurationMap);
    }

    public final Size[] a(int format) {
        if (this.cachedFormatHighResolutionOutputSizes.containsKey(Integer.valueOf(format))) {
            Size[] sizeArr = this.cachedFormatHighResolutionOutputSizes.get(Integer.valueOf(format));
            if (sizeArr != null) {
                return (Size[]) sizeArr.clone();
            }
            return null;
        }
        Size[] sizeArrG = this.impl.g(format);
        if (sizeArrG != null && sizeArrG.length != 0) {
            sizeArrG = this.outputSizesCorrector.b(sizeArrG, format);
        }
        this.cachedFormatHighResolutionOutputSizes.put(Integer.valueOf(format), sizeArrG);
        if (sizeArrG != null) {
            return (Size[]) sizeArrG.clone();
        }
        return null;
    }

    public final Range<Integer>[] b(Size size) throws IllegalArgumentException {
        kotlin.jvm.internal.p.i(size, "size");
        return this.impl.f(size);
    }

    public final Size[] c() {
        return this.impl.e();
    }

    public final Integer[] d() {
        return this.impl.d();
    }

    public final long e(int format, Size size) {
        kotlin.jvm.internal.p.i(size, "size");
        try {
            return this.impl.b(format, size);
        } catch (RuntimeException e10) {
            C5473b c5473b = C5473b.f41865a;
            if (!C0761b0.k("CXCP")) {
                return 0L;
            }
            Log.w(C5473b.TRUNCATED_TAG, "Unable to get min frame duration for format = " + format + " and size = " + size, e10);
            return 0L;
        }
    }

    public final Size[] f(int format) {
        Size[] sizeArrC = null;
        if (this.cachedFormatOutputSizes.containsKey(Integer.valueOf(format))) {
            Size[] sizeArr = this.cachedFormatOutputSizes.get(Integer.valueOf(format));
            if (sizeArr != null) {
                return (Size[]) sizeArr.clone();
            }
            return null;
        }
        try {
            sizeArrC = this.impl.c(format);
        } catch (Throwable th) {
            C0761b0.p(this.tag, "Failed to get output sizes for " + format, th);
        }
        if (sizeArrC != null && sizeArrC.length != 0) {
            Size[] sizeArrB = this.outputSizesCorrector.b(sizeArrC, format);
            this.cachedFormatOutputSizes.put(Integer.valueOf(format), sizeArrB);
            return (Size[]) sizeArrB.clone();
        }
        C0761b0.o(this.tag, "Retrieved output sizes array is null or empty for format " + format);
        return sizeArrC;
    }

    public final StreamConfigurationMap g() {
        return this.impl.a();
    }
}
