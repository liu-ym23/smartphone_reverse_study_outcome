package androidx.camera.camera2.pipe.compat;

import android.view.Surface;
import com.autonavi.aps.amapapi.config.Const;
import java.util.Map;
import kotlin.Metadata;
import w.G;
import w.Q;
import x.w0;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b`\u0018\u00002\u00020\u0001:\u0001\u000bJ3\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u00042\u0006\u0010\t\u001a\u00020\bH&¢\u0006\u0004\b\u000b\u0010\fø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\rÀ\u0006\u0001"}, d2 = {"Landroidx/camera/camera2/pipe/compat/r;", "", "Landroidx/camera/camera2/pipe/compat/p;", "cameraDevice", "", "Lw/Q;", "Landroid/view/Surface;", "surfaces", "Landroidx/camera/camera2/pipe/compat/CaptureSessionState;", "captureSessionState", "Landroidx/camera/camera2/pipe/compat/r$a;", Const.INTENT_KEY_APIKEY, "(Landroidx/camera/camera2/pipe/compat/p;Ljava/util/Map;Landroidx/camera/camera2/pipe/compat/CaptureSessionState;)Landroidx/camera/camera2/pipe/compat/r$a;", "camera-camera2-pipe"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes.dex */
public interface r {

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bv\u0018\u00002\u00020\u0001:\u0002\u0002\u0003\u0082\u0001\u0002\u0004\u0005ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0006À\u0006\u0001"}, d2 = {"Landroidx/camera/camera2/pipe/compat/r$a;", "", Const.INTENT_KEY_PKGNAME, Const.INTENT_KEY_APIKEY, "Landroidx/camera/camera2/pipe/compat/r$a$a;", "Landroidx/camera/camera2/pipe/compat/r$a$b;", "camera-camera2-pipe"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public interface a {

        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Landroidx/camera/camera2/pipe/compat/r$a$a;", "Landroidx/camera/camera2/pipe/compat/r$a;", "<init>", "()V", "camera-camera2-pipe"}, k = 1, mv = {2, 1, 0}, xi = 48)
        /* renamed from: androidx.camera.camera2.pipe.compat.r$a$a, reason: collision with other inner class name */
        public static final class C0137a implements a {

            /* renamed from: a, reason: collision with root package name */
            public static final C0137a f10670a = new C0137a();
        }

        @Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001B/\u0012\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0002\u0012\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0002¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\f\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000f\u001a\u00020\u000eHÖ\u0001¢\u0006\u0004\b\u000f\u0010\u0010J\u001a\u0010\u0014\u001a\u00020\u00132\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011HÖ\u0003¢\u0006\u0004\b\u0014\u0010\u0015R#\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u00028\u0006¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0016\u0010\u0018R#\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u00028\u0006¢\u0006\f\n\u0004\b\u0019\u0010\u0017\u001a\u0004\b\u0019\u0010\u0018¨\u0006\u001a"}, d2 = {"Landroidx/camera/camera2/pipe/compat/r$a$b;", "Landroidx/camera/camera2/pipe/compat/r$a;", "", "Lw/Q;", "Lx/w0;", "deferred", "Lw/G;", "Landroid/view/Surface;", "outputSurfaceMap", "<init>", "(Ljava/util/Map;Ljava/util/Map;)V", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", Const.INTENT_KEY_APIKEY, "Ljava/util/Map;", "()Ljava/util/Map;", Const.INTENT_KEY_PKGNAME, "camera-camera2-pipe"}, k = 1, mv = {2, 1, 0}, xi = 48)
        /* renamed from: androidx.camera.camera2.pipe.compat.r$a$b, reason: from toString */
        public static final /* data */ class Success implements a {

            /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
            public final Map<Q, w0> deferred;

            /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
            public final Map<G, Surface> outputSurfaceMap;

            /* JADX WARN: Multi-variable type inference failed */
            public Success(Map<Q, ? extends w0> deferred, Map<G, ? extends Surface> outputSurfaceMap) {
                kotlin.jvm.internal.p.i(deferred, "deferred");
                kotlin.jvm.internal.p.i(outputSurfaceMap, "outputSurfaceMap");
                this.deferred = deferred;
                this.outputSurfaceMap = outputSurfaceMap;
            }

            public final Map<Q, w0> a() {
                return this.deferred;
            }

            public final Map<G, Surface> b() {
                return this.outputSurfaceMap;
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof Success)) {
                    return false;
                }
                Success success = (Success) other;
                return kotlin.jvm.internal.p.d(this.deferred, success.deferred) && kotlin.jvm.internal.p.d(this.outputSurfaceMap, success.outputSurfaceMap);
            }

            public int hashCode() {
                return (this.deferred.hashCode() * 31) + this.outputSurfaceMap.hashCode();
            }

            public String toString() {
                return "Success(deferred=" + this.deferred + ", outputSurfaceMap=" + this.outputSurfaceMap + ')';
            }
        }
    }

    a a(p cameraDevice, Map<Q, ? extends Surface> surfaces, CaptureSessionState captureSessionState);
}
