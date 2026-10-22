package androidx.camera.camera2.pipe.compat;

import Z8.C1173v;
import android.graphics.SurfaceTexture;
import android.hardware.camera2.params.OutputConfiguration;
import android.media.MediaCodec;
import android.media.MediaRecorder;
import android.os.Build;
import android.util.Log;
import android.util.Size;
import android.view.Surface;
import android.view.SurfaceHolder;
import androidx.camera.camera2.pipe.s;
import androidx.exifinterface.media.ExifInterface;
import com.autonavi.aps.amapapi.config.Const;
import io.ktor.http.ContentDisposition;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import kotlin.Metadata;
import w9.InterfaceC5745d;
import x.C5821j;
import x.C5823k;
import x.C5828n;
import x.C5829o;
import x.C5835v;
import x.w0;

@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0015\b\u0001\u0018\u0000 +2\u00020\u0001:\u0001\u001aB)\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\b\u0010\t\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\fH\u0016¢\u0006\u0004\b\u000f\u0010\u0010J)\u0010\u0015\u001a\u0004\u0018\u00018\u0000\"\b\b\u0000\u0010\u0012*\u00020\u00112\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00028\u00000\u0013H\u0016¢\u0006\u0004\b\u0015\u0010\u0016J\u000f\u0010\u0018\u001a\u00020\u0017H\u0016¢\u0006\u0004\b\u0018\u0010\u0019R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u001a\u0010\u0005\u001a\u00020\u00048\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001fR\u001a\u0010\u0007\u001a\u00020\u00068\u0016X\u0096\u0004¢\u0006\f\n\u0004\b \u0010!\u001a\u0004\b\"\u0010#R\u001c\u0010\t\u001a\u0004\u0018\u00010\b8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b$\u0010%\u001a\u0004\b&\u0010\u0019R\u001c\u0010\r\u001a\u0004\u0018\u00010\f8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b'\u0010(\u001a\u0004\b)\u0010*¨\u0006,"}, d2 = {"Landroidx/camera/camera2/pipe/compat/h;", "Lx/w0;", "Landroid/hardware/camera2/params/OutputConfiguration;", "output", "", "surfaceSharing", "", "maxSharedSurfaceCount", "Lw/n;", "physicalCameraId", "<init>", "(Landroid/hardware/camera2/params/OutputConfiguration;ZILjava/lang/String;Lkotlin/jvm/internal/i;)V", "Landroid/view/Surface;", "surface", "LY8/t;", "n", "(Landroid/view/Surface;)V", "", ExifInterface.GPS_DIRECTION_TRUE, "Lw9/d;", "type", "R0", "(Lw9/d;)Ljava/lang/Object;", "", "toString", "()Ljava/lang/String;", Const.INTENT_KEY_APIKEY, "Landroid/hardware/camera2/params/OutputConfiguration;", Const.INTENT_KEY_PKGNAME, "Z", "getSurfaceSharing", "()Z", "c", "I", "getMaxSharedSurfaceCount", "()I", Const.INTENT_KEY_UMID, "Ljava/lang/String;", "getPhysicalCameraId-1LO98Z0", "e", "Landroid/view/Surface;", "getSurface", "()Landroid/view/Surface;", "f", "camera-camera2-pipe"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes.dex */
public final class h implements w0 {

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final OutputConfiguration output;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public final boolean surfaceSharing;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    public final int maxSharedSurfaceCount;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    public final String physicalCameraId;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    public final Surface surface;

    @Metadata(d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0087\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u009b\u0001\u0010\u001d\u001a\u0004\u0018\u00010\u001c2\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\b\u0002\u0010\t\u001a\u00020\b2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00102\u000e\b\u0002\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00130\u00122\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00152\b\b\u0002\u0010\u0018\u001a\u00020\u00172\b\b\u0002\u0010\u0019\u001a\u00020\u00062\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u001a¢\u0006\u0004\b\u001d\u0010\u001eJ\u001b\u0010 \u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00010\u001f*\u00020\bH\u0002¢\u0006\u0004\b \u0010!J\u0013\u0010$\u001a\u00020#*\u00020\"H\u0002¢\u0006\u0004\b$\u0010%J\u001b\u0010&\u001a\u00020#*\u00020\"2\u0006\u0010\u001b\u001a\u00020\u001aH\u0002¢\u0006\u0004\b&\u0010'¨\u0006("}, d2 = {"Landroidx/camera/camera2/pipe/compat/h$a;", "", "<init>", "()V", "Landroid/view/Surface;", "surface", "", "format", "Landroidx/camera/camera2/pipe/s$d;", "outputType", "Landroidx/camera/camera2/pipe/s$c;", "mirrorMode", "Landroidx/camera/camera2/pipe/s$h;", "timestampBase", "Landroidx/camera/camera2/pipe/s$b;", "dynamicRangeProfile", "Landroidx/camera/camera2/pipe/s$f;", "streamUseCase", "", "Landroidx/camera/camera2/pipe/s$e;", "sensorPixelModes", "Landroid/util/Size;", ContentDisposition.Parameters.Size, "", "surfaceSharing", "surfaceGroupId", "Lw/n;", "physicalCameraId", "Lx/w0;", Const.INTENT_KEY_APIKEY, "(Landroid/view/Surface;Ljava/lang/Integer;Landroidx/camera/camera2/pipe/s$d;Landroidx/camera/camera2/pipe/s$c;Landroidx/camera/camera2/pipe/s$h;Landroidx/camera/camera2/pipe/s$b;Landroidx/camera/camera2/pipe/s$f;Ljava/util/List;Landroid/util/Size;ZILjava/lang/String;)Lx/w0;", "Ljava/lang/Class;", "e", "(Landroidx/camera/camera2/pipe/s$d;)Ljava/lang/Class;", "Landroid/hardware/camera2/params/OutputConfiguration;", "LY8/t;", "c", "(Landroid/hardware/camera2/params/OutputConfiguration;)V", Const.INTENT_KEY_UMID, "(Landroid/hardware/camera2/params/OutputConfiguration;Ljava/lang/String;)V", "camera-camera2-pipe"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* renamed from: androidx.camera.camera2.pipe.compat.h$a, reason: from kotlin metadata */
    public static final class Companion {
        public /* synthetic */ Companion(kotlin.jvm.internal.i iVar) {
            this();
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ w0 b(Companion companion, Surface surface, Integer num, s.d dVar, s.c cVar, s.h hVar, s.b bVar, s.f fVar, List list, Size size, boolean z10, int i10, String str, int i11, Object obj) {
            if ((i11 & 2) != 0) {
                num = null;
            }
            if ((i11 & 4) != 0) {
                dVar = s.d.INSTANCE.c();
            }
            if ((i11 & 8) != 0) {
                cVar = null;
            }
            if ((i11 & 16) != 0) {
                hVar = null;
            }
            if ((i11 & 32) != 0) {
                bVar = null;
            }
            if ((i11 & 64) != 0) {
                fVar = null;
            }
            if ((i11 & 128) != 0) {
                list = C1173v.m();
            }
            if ((i11 & 256) != 0) {
                size = null;
            }
            if ((i11 & 512) != 0) {
                z10 = false;
            }
            if ((i11 & 1024) != 0) {
                i10 = -1;
            }
            if ((i11 & 2048) != 0) {
                str = null;
            }
            return companion.a(surface, num, dVar, cVar, hVar, bVar, fVar, list, size, z10, i10, str);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public final w0 a(Surface surface, Integer format, s.d outputType, s.c mirrorMode, s.h timestampBase, s.b dynamicRangeProfile, s.f streamUseCase, List<s.e> sensorPixelModes, Size size, boolean surfaceSharing, int surfaceGroupId, String physicalCameraId) {
            OutputConfiguration outputConfigurationD;
            kotlin.jvm.internal.p.i(outputType, "outputType");
            kotlin.jvm.internal.p.i(sensorPixelModes, "sensorPixelModes");
            s.d.Companion companion = s.d.INSTANCE;
            if (!kotlin.jvm.internal.p.d(outputType, companion.d()) || Build.VERSION.SDK_INT < 35) {
                if (kotlin.jvm.internal.p.d(outputType, companion.c())) {
                    if (surface == 0) {
                        Objects.toString(companion.c());
                        throw new IllegalStateException("non-null surface!");
                    }
                    try {
                        surface = surfaceGroupId != -1 ? new OutputConfiguration(surfaceGroupId, surface) : new OutputConfiguration(surface);
                        outputConfigurationD = surface;
                    } catch (Throwable th) {
                        if (!z.k.f44508a.d()) {
                            return null;
                        }
                        Log.w("CXCP", "Failed to create an OutputConfiguration for " + surface + '!', th);
                        return null;
                    }
                } else {
                    if (size == null) {
                        throw new IllegalStateException("Size must defined when creating a deferred OutputConfiguration.");
                    }
                    outputConfigurationD = C5821j.d(size, e(outputType));
                }
            } else {
                if (format == null) {
                    throw new IllegalStateException("Required value was null.");
                }
                if (size == null) {
                    throw new IllegalStateException("Required value was null.");
                }
                outputConfigurationD = C5835v.e(format.intValue(), size);
            }
            OutputConfiguration outputConfiguration = outputConfigurationD;
            if (surfaceSharing) {
                c(outputConfiguration);
            }
            if (physicalCameraId != null) {
                d(outputConfiguration, physicalCameraId);
            }
            if (mirrorMode != null) {
                C5829o.d(outputConfiguration, mirrorMode.getValue());
            }
            if (dynamicRangeProfile != null) {
                C5829o.c(outputConfiguration, dynamicRangeProfile.getValue());
            }
            if (streamUseCase != null) {
                C5829o.e(outputConfiguration, streamUseCase.getValue());
            }
            if (!sensorPixelModes.isEmpty()) {
                Iterator<s.e> it = sensorPixelModes.iterator();
                while (it.hasNext()) {
                    C5828n.a(outputConfiguration, it.next().getValue());
                }
            }
            return new h(outputConfiguration, surfaceSharing, C5823k.d(outputConfiguration), physicalCameraId, null);
        }

        public final void c(OutputConfiguration outputConfiguration) {
            C5821j.b(outputConfiguration);
        }

        public final void d(OutputConfiguration outputConfiguration, String str) {
            C5823k.j(outputConfiguration, str);
        }

        public final Class<? extends Object> e(s.d dVar) {
            s.d.Companion companion = s.d.INSTANCE;
            if (kotlin.jvm.internal.p.d(dVar, companion.e())) {
                return SurfaceTexture.class;
            }
            if (kotlin.jvm.internal.p.d(dVar, companion.f())) {
                return SurfaceHolder.class;
            }
            if (kotlin.jvm.internal.p.d(dVar, companion.a())) {
                if (Build.VERSION.SDK_INT >= 35) {
                    return MediaCodec.class;
                }
                throw new IllegalStateException("OutputType.MEDIA_CODEC requires API 35 or higher.");
            }
            if (kotlin.jvm.internal.p.d(dVar, companion.b())) {
                if (Build.VERSION.SDK_INT >= 35) {
                    return MediaRecorder.class;
                }
                throw new IllegalStateException("OutputType.MEDIA_RECORDER requires API 35 or higher.");
            }
            throw new IllegalStateException("Unsupported OutputType: " + dVar);
        }

        public Companion() {
        }
    }

    public /* synthetic */ h(OutputConfiguration outputConfiguration, boolean z10, int i10, String str, kotlin.jvm.internal.i iVar) {
        this(outputConfiguration, z10, i10, str);
    }

    @Override // w.U
    public <T> T R0(InterfaceC5745d<T> type) {
        kotlin.jvm.internal.p.i(type, "type");
        if (!kotlin.jvm.internal.p.d(type, kotlin.jvm.internal.t.b(OutputConfiguration.class))) {
            return null;
        }
        T t10 = (T) this.output;
        kotlin.jvm.internal.p.g(t10, "null cannot be cast to non-null type T of androidx.camera.camera2.pipe.compat.AndroidOutputConfiguration.unwrapAs");
        return t10;
    }

    @Override // x.w0
    public void n(Surface surface) {
        kotlin.jvm.internal.p.i(surface, "surface");
        C5821j.a(this.output, surface);
    }

    public String toString() {
        return this.output.toString();
    }

    public h(OutputConfiguration output, boolean z10, int i10, String str) {
        kotlin.jvm.internal.p.i(output, "output");
        this.output = output;
        this.surfaceSharing = z10;
        this.maxSharedSurfaceCount = i10;
        this.physicalCameraId = str;
        this.surface = output.getSurface();
    }
}
