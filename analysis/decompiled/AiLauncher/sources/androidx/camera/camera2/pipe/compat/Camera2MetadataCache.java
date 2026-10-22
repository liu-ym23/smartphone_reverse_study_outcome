package androidx.camera.camera2.pipe.compat;

import Ua.C1056g;
import Z8.F;
import Z8.Y;
import Z8.Z;
import android.content.Context;
import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraCharacteristics;
import android.hardware.camera2.CameraExtensionCharacteristics;
import android.hardware.camera2.CameraManager;
import android.os.Trace;
import android.util.ArrayMap;
import android.util.Log;
import androidx.camera.camera2.pipe.DoNotDisturbException;
import androidx.camera.camera2.pipe.core.Threads;
import androidx.camera.camera2.pipe.h;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.ailauncher.chat.voice.support.C3081a;
import e9.InterfaceC4014c;
import java.util.Arrays;
import java.util.Set;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import w.C5706l;
import w.C5708n;
import w.InterfaceC5707m;
import x.C5799A;
import x.C5828n;
import x.InterfaceC5808c0;
import x.J;
import z.y;

@Metadata(d1 = {"\u0000~\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\b\b\u0001\u0018\u00002\u00020\u0001B3\b\u0007\u0012\b\b\u0001\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\t\u001a\u00020\b\u0012\u0006\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\f\u0010\rJ\u0018\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u000f\u001a\u00020\u000eH\u0096@¢\u0006\u0004\b\u0011\u0010\u0012J\u0017\u0010\u0013\u001a\u00020\u00102\u0006\u0010\u000f\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u0013\u0010\u0014J\u001f\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0016\u001a\u00020\u0015H\u0016¢\u0006\u0004\b\u0018\u0010\u0019J\u001d\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00150\u001a2\u0006\u0010\u000f\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u001b\u0010\u001cJ\u001f\u0010 \u001a\u00020\u001f2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u001e\u001a\u00020\u001dH\u0002¢\u0006\u0004\b \u0010!J'\u0010#\u001a\u00020\"2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u001e\u001a\u00020\u001d2\u0006\u0010\u0016\u001a\u00020\u0015H\u0003¢\u0006\u0004\b#\u0010$J\u0017\u0010&\u001a\u00020%2\u0006\u0010\u000f\u001a\u00020\u000eH\u0003¢\u0006\u0004\b&\u0010'J\u000f\u0010(\u001a\u00020\u001dH\u0002¢\u0006\u0004\b(\u0010)J\u0017\u0010,\u001a\u00020\u001d2\u0006\u0010+\u001a\u00020*H\u0002¢\u0006\u0004\b,\u0010-R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010.R\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001b\u0010/R\u0014\u0010\u0007\u001a\u00020\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0011\u00100R\u0014\u0010\t\u001a\u00020\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0018\u00101R\u0014\u0010\u000b\u001a\u00020\n8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b2\u00103R \u00108\u001a\u000e\u0012\u0004\u0012\u000205\u0012\u0004\u0012\u00020\u0010048\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\b6\u00107R \u0010:\u001a\u000e\u0012\u0004\u0012\u000205\u0012\u0004\u0012\u00020\u0017048\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\b9\u00107R \u0010<\u001a\u000e\u0012\u0004\u0012\u000205\u0012\u0004\u0012\u00020%048\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\b;\u00107¨\u0006="}, d2 = {"Landroidx/camera/camera2/pipe/compat/Camera2MetadataCache;", "Lx/c0;", "Landroid/content/Context;", "cameraPipeContext", "Landroidx/camera/camera2/pipe/core/Threads;", "threads", "Lz/m;", "permissions", "Landroidx/camera/camera2/pipe/h$c;", "cameraMetadataConfig", "Lz/w;", "timeSource", "<init>", "(Landroid/content/Context;Landroidx/camera/camera2/pipe/core/Threads;Lz/m;Landroidx/camera/camera2/pipe/h$c;Lz/w;)V", "Lw/n;", "cameraId", "Landroidx/camera/camera2/pipe/g;", "c", "(Ljava/lang/String;Le9/c;)Ljava/lang/Object;", Const.INTENT_KEY_APIKEY, "(Ljava/lang/String;)Landroidx/camera/camera2/pipe/g;", "", "extension", "Lw/m;", Const.INTENT_KEY_UMID, "(Ljava/lang/String;I)Lw/m;", "", Const.INTENT_KEY_PKGNAME, "(Ljava/lang/String;)Ljava/util/Set;", "", "redacted", "Lx/J;", "p", "(Ljava/lang/String;Z)Lx/J;", "Lx/A;", "o", "(Ljava/lang/String;ZI)Lx/A;", "Landroid/hardware/camera2/CameraExtensionCharacteristics;", "q", "(Ljava/lang/String;)Landroid/hardware/camera2/CameraExtensionCharacteristics;", "r", "()Z", "Landroid/hardware/camera2/CameraCharacteristics;", "characteristics", "s", "(Landroid/hardware/camera2/CameraCharacteristics;)Z", "Landroid/content/Context;", "Landroidx/camera/camera2/pipe/core/Threads;", "Lz/m;", "Landroidx/camera/camera2/pipe/h$c;", "e", "Lz/w;", "Landroid/util/ArrayMap;", "", "f", "Landroid/util/ArrayMap;", "cache", Const.INTENT_KEY_BACKGROUND_COMMAND, "extensionCache", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "extensionCharacteristicsCache", "camera-camera2-pipe"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes.dex */
public final class Camera2MetadataCache implements InterfaceC5808c0 {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final Context cameraPipeContext;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public final Threads threads;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    public final z.m permissions;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    public final h.c cameraMetadataConfig;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    public final z.w timeSource;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    public final ArrayMap<String, androidx.camera.camera2.pipe.g> cache;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    public final ArrayMap<String, InterfaceC5707m> extensionCache;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    public final ArrayMap<String, CameraExtensionCharacteristics> extensionCharacteristicsCache;

    public Camera2MetadataCache(Context cameraPipeContext, Threads threads, z.m permissions, h.c cameraMetadataConfig, z.w timeSource) {
        kotlin.jvm.internal.p.i(cameraPipeContext, "cameraPipeContext");
        kotlin.jvm.internal.p.i(threads, "threads");
        kotlin.jvm.internal.p.i(permissions, "permissions");
        kotlin.jvm.internal.p.i(cameraMetadataConfig, "cameraMetadataConfig");
        kotlin.jvm.internal.p.i(timeSource, "timeSource");
        this.cameraPipeContext = cameraPipeContext;
        this.threads = threads;
        this.permissions = permissions;
        this.cameraMetadataConfig = cameraMetadataConfig;
        this.timeSource = timeSource;
        this.cache = new ArrayMap<>();
        this.extensionCache = new ArrayMap<>();
        this.extensionCharacteristicsCache = new ArrayMap<>();
    }

    @Override // x.InterfaceC5808c0
    public androidx.camera.camera2.pipe.g a(String cameraId) {
        androidx.camera.camera2.pipe.g gVarP;
        kotlin.jvm.internal.p.i(cameraId, "cameraId");
        z.h hVar = z.h.f44503a;
        try {
            Trace.beginSection(((Object) C5708n.f(cameraId)) + "#awaitMetadata");
            synchronized (this.cache) {
                try {
                    gVarP = (androidx.camera.camera2.pipe.g) this.cache.get(cameraId);
                    if (gVarP == null) {
                        if (r()) {
                            Y8.t tVar = Y8.t.f7040a;
                            gVarP = p(cameraId, true);
                        } else {
                            gVarP = p(cameraId, false);
                            this.cache.put(cameraId, gVarP);
                        }
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            return gVarP;
        } finally {
            Trace.endSection();
        }
    }

    @Override // x.InterfaceC5808c0
    public Set<Integer> b(String cameraId) {
        kotlin.jvm.internal.p.i(cameraId, "cameraId");
        return F.r1(C5828n.e(q(cameraId)));
    }

    @Override // x.InterfaceC5808c0
    public Object c(String str, InterfaceC4014c<? super androidx.camera.camera2.pipe.g> interfaceC4014c) {
        synchronized (this.cache) {
            androidx.camera.camera2.pipe.g gVar = this.cache.get(str);
            if (gVar != null) {
                return gVar;
            }
            Y8.t tVar = Y8.t.f7040a;
            return C1056g.j(this.threads.getBackgroundDispatcher(), new Camera2MetadataCache$getCameraMetadata$3(this, str, null), interfaceC4014c);
        }
    }

    @Override // x.InterfaceC5808c0
    public InterfaceC5707m d(String cameraId, int extension) {
        InterfaceC5707m interfaceC5707mO;
        kotlin.jvm.internal.p.i(cameraId, "cameraId");
        z.h hVar = z.h.f44503a;
        try {
            Trace.beginSection(((Object) C5708n.f(cameraId)) + "#awaitExtensionMetadata");
            synchronized (this.extensionCache) {
                try {
                    interfaceC5707mO = (InterfaceC5707m) this.extensionCache.get(cameraId);
                    if (interfaceC5707mO == null) {
                        if (r()) {
                            Y8.t tVar = Y8.t.f7040a;
                            interfaceC5707mO = o(cameraId, true, extension);
                        } else {
                            interfaceC5707mO = o(cameraId, false, extension);
                            this.extensionCache.put(cameraId, interfaceC5707mO);
                        }
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            return interfaceC5707mO;
        } finally {
            Trace.endSection();
        }
    }

    public final C5799A o(String cameraId, boolean redacted, int extension) {
        String str;
        Throwable th;
        String str2;
        y yVar = y.f44525a;
        long jA = this.timeSource.a();
        z.h hVar = z.h.f44503a;
        try {
            Trace.beginSection(((Object) C5708n.f(cameraId)) + "#readCameraExtensionMetadata");
            try {
                z.k kVar = z.k.f44508a;
                if (kVar.a()) {
                    try {
                        Log.d("CXCP", "Loading extension metadata for " + ((Object) C5708n.f(cameraId)));
                    } catch (Throwable th2) {
                        th = th2;
                        str = cameraId;
                        throw new IllegalStateException("Failed to load extension metadata for " + ((Object) C5708n.f(str)) + '!', th);
                    }
                }
                str = cameraId;
                try {
                    C5799A c5799a = new C5799A(str, redacted, extension, q(cameraId), kotlin.collections.a.i(), null);
                    if (kVar.c()) {
                        long jC = z.i.c(this.timeSource.a() - jA);
                        if (!redacted) {
                            str2 = "";
                        } else {
                            if (!redacted) {
                                throw new NoWhenBranchMatchedException();
                            }
                            str2 = " (redacted)";
                        }
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append("Loaded extension metadata for ");
                        sb2.append((Object) C5708n.f(str));
                        sb2.append(" in ");
                        String str3 = String.format(null, "%.3f ms", Arrays.copyOf(new Object[]{Double.valueOf(jC / 1000000.0d)}, 1));
                        kotlin.jvm.internal.p.h(str3, "format(...)");
                        sb2.append(str3);
                        sb2.append(str2);
                        Log.i("CXCP", sb2.toString());
                    }
                    return c5799a;
                } catch (Throwable th3) {
                    th = th3;
                    th = th;
                    throw new IllegalStateException("Failed to load extension metadata for " + ((Object) C5708n.f(str)) + '!', th);
                }
            } catch (Throwable th4) {
                th = th4;
                str = cameraId;
            }
        } finally {
            Trace.endSection();
        }
    }

    public final J p(String cameraId, boolean redacted) {
        Set<CameraCharacteristics.Key<?>> setP;
        String str;
        y yVar = y.f44525a;
        long jA = this.timeSource.a();
        z.h hVar = z.h.f44503a;
        try {
            Trace.beginSection(((Object) C5708n.f(cameraId)) + "#readCameraMetadata");
            try {
                z.k kVar = z.k.f44508a;
                if (kVar.a()) {
                    Log.d("CXCP", "Loading metadata for " + ((Object) C5708n.f(cameraId)));
                }
                Object systemService = this.cameraPipeContext.getSystemService(C3081a.CAMERA_FOCUS);
                kotlin.jvm.internal.p.g(systemService, "null cannot be cast to non-null type android.hardware.camera2.CameraManager");
                CameraCharacteristics cameraCharacteristics = ((CameraManager) systemService).getCameraCharacteristics(cameraId);
                kotlin.jvm.internal.p.h(cameraCharacteristics, "getCameraCharacteristics(...)");
                if (cameraCharacteristics == null) {
                    throw new IllegalStateException(("Failed to get CameraCharacteristics for " + ((Object) C5708n.f(cameraId)) + '!').toString());
                }
                if (s(cameraCharacteristics)) {
                    Set<CameraCharacteristics.Key<?>> setE = this.cameraMetadataConfig.b().get(C5708n.a(cameraId));
                    if (setE == null) {
                        setE = Y.e();
                    }
                    setP = Z.p(setE, CameraCharacteristics.SENSOR_ORIENTATION);
                } else {
                    setP = this.cameraMetadataConfig.b().get(C5708n.a(cameraId));
                }
                J j10 = new J(cameraId, redacted, cameraCharacteristics, this, kotlin.collections.a.i(), setP == null ? this.cameraMetadataConfig.a() : Z.o(this.cameraMetadataConfig.a(), setP), null);
                if (kVar.c()) {
                    long jC = z.i.c(this.timeSource.a() - jA);
                    if (!redacted) {
                        str = "";
                    } else {
                        if (!redacted) {
                            throw new NoWhenBranchMatchedException();
                        }
                        str = " (redacted)";
                    }
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("Loaded metadata for ");
                    sb2.append((Object) C5708n.f(cameraId));
                    sb2.append(" in ");
                    String str2 = String.format(null, "%.3f ms", Arrays.copyOf(new Object[]{Double.valueOf(jC / 1000000.0d)}, 1));
                    kotlin.jvm.internal.p.h(str2, "format(...)");
                    sb2.append(str2);
                    sb2.append(str);
                    Log.i("CXCP", sb2.toString());
                }
                return j10;
            } catch (Throwable th) {
                if (C5706l.INSTANCE.r(th)) {
                    throw new DoNotDisturbException("Failed to load metadata: Do Not Disturb mode is on!");
                }
                throw new IllegalStateException("Failed to load metadata for " + ((Object) C5708n.f(cameraId)) + '!', th);
            }
        } finally {
            Trace.endSection();
        }
    }

    public final CameraExtensionCharacteristics q(String cameraId) throws CameraAccessException {
        synchronized (this.extensionCharacteristicsCache) {
            CameraExtensionCharacteristics cameraExtensionCharacteristics = this.extensionCharacteristicsCache.get(cameraId);
            if (cameraExtensionCharacteristics != null) {
                return cameraExtensionCharacteristics;
            }
            Y8.t tVar = Y8.t.f7040a;
            if (z.k.f44508a.a()) {
                Log.d("CXCP", "Retrieving CameraExtensionCharacteristics for " + ((Object) C5708n.f(cameraId)));
            }
            Object systemService = this.cameraPipeContext.getSystemService(C3081a.CAMERA_FOCUS);
            kotlin.jvm.internal.p.g(systemService, "null cannot be cast to non-null type android.hardware.camera2.CameraManager");
            CameraExtensionCharacteristics cameraExtensionCharacteristicsC = C5828n.c((CameraManager) systemService, cameraId);
            if (cameraExtensionCharacteristicsC != null) {
                return cameraExtensionCharacteristicsC;
            }
            throw new IllegalStateException(("Failed to get CameraExtensionCharacteristics for " + ((Object) C5708n.f(cameraId)) + '!').toString());
        }
    }

    public final boolean r() {
        return !this.permissions.b();
    }

    public final boolean s(CameraCharacteristics characteristics) {
        return characteristics.get(CameraCharacteristics.INFO_DEVICE_STATE_SENSOR_ORIENTATION_MAP) != null;
    }
}
