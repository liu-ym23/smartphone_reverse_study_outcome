package androidx.camera.camera2.pipe;

import Ua.M;
import Z8.Y;
import android.content.Context;
import android.hardware.camera2.CameraCharacteristics;
import android.hardware.camera2.CameraDevice;
import android.os.Handler;
import android.os.Trace;
import androidx.camera.camera2.pipe.CameraGraph;
import androidx.camera.camera2.pipe.f;
import com.autonavi.aps.amapapi.config.Const;
import e9.InterfaceC4014c;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Executor;
import kotlin.Metadata;
import p9.InterfaceC5063a;
import w.C5699e;
import w.C5708n;
import w.C5711q;
import w.I;
import w.InterfaceC5698d;
import w.InterfaceC5705k;
import y.C5882I;
import y.C5906q;
import y.InterfaceC5905p;
import y.a0;

@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\bg\u0018\u0000 \f2\u00020\u0001:\u0007\t\u0018\u0013\u0019\u000f\f\u0005J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J\u001d\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00040\b2\u0006\u0010\u0003\u001a\u00020\u0007H&¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\f\u001a\u00020\u000bH&¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000f\u001a\u00020\u000eH&¢\u0006\u0004\b\u000f\u0010\u0010J\u0018\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0011\u001a\u00020\u0002H¦@¢\u0006\u0004\b\u0013\u0010\u0014J\u000f\u0010\u0016\u001a\u00020\u0015H&¢\u0006\u0004\b\u0016\u0010\u0017ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u001aÀ\u0006\u0001"}, d2 = {"Landroidx/camera/camera2/pipe/h;", "", "Landroidx/camera/camera2/pipe/CameraGraph$b;", "config", "Landroidx/camera/camera2/pipe/CameraGraph;", Const.INTENT_KEY_UMID, "(Landroidx/camera/camera2/pipe/CameraGraph$b;)Landroidx/camera/camera2/pipe/CameraGraph;", "Landroidx/camera/camera2/pipe/CameraGraph$a;", "", "e", "(Landroidx/camera/camera2/pipe/CameraGraph$a;)Ljava/util/List;", "Lw/k;", Const.INTENT_KEY_APIKEY, "()Lw/k;", "Lw/q;", "c", "()Lw/q;", "graphConfig", "Landroidx/camera/camera2/pipe/o;", Const.INTENT_KEY_PKGNAME, "(Landroidx/camera/camera2/pipe/CameraGraph$b;Le9/c;)Ljava/lang/Object;", "LY8/t;", "shutdown", "()V", "f", Const.INTENT_KEY_BACKGROUND_COMMAND, "camera-camera2-pipe"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes.dex */
public interface h {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public static final Companion INSTANCE = Companion.f10920a;

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\r\u0018\u00002\u00020\u0001B5\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\u0014\b\u0002\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\u0004\b\t\u0010\nR\u0019\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR\u0019\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0006¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u000f\u0010\u0011R#\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00070\u00068\u0006¢\u0006\f\n\u0004\b\r\u0010\u0012\u001a\u0004\b\u000b\u0010\u0013¨\u0006\u0014"}, d2 = {"Landroidx/camera/camera2/pipe/h$a;", "", "Landroidx/camera/camera2/pipe/b;", "internalBackend", "Lw/e;", "defaultBackend", "", "Lw/d;", "cameraBackends", "<init>", "(Landroidx/camera/camera2/pipe/b;Ljava/lang/String;Ljava/util/Map;Lkotlin/jvm/internal/i;)V", Const.INTENT_KEY_APIKEY, "Landroidx/camera/camera2/pipe/b;", "c", "()Landroidx/camera/camera2/pipe/b;", Const.INTENT_KEY_PKGNAME, "Ljava/lang/String;", "()Ljava/lang/String;", "Ljava/util/Map;", "()Ljava/util/Map;", "camera-camera2-pipe"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class a {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        public final b internalBackend;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        public final String defaultBackend;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata */
        public final Map<C5699e, InterfaceC5698d> cameraBackends;

        public /* synthetic */ a(b bVar, String str, Map map, kotlin.jvm.internal.i iVar) {
            this(bVar, str, map);
        }

        public final Map<C5699e, InterfaceC5698d> a() {
            return this.cameraBackends;
        }

        /* renamed from: b, reason: from getter */
        public final String getDefaultBackend() {
            return this.defaultBackend;
        }

        /* renamed from: c, reason: from getter */
        public final b getInternalBackend() {
            return this.internalBackend;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public a(b bVar, String str, Map<C5699e, ? extends InterfaceC5698d> cameraBackends) {
            kotlin.jvm.internal.p.i(cameraBackends, "cameraBackends");
            this.internalBackend = bVar;
            this.defaultBackend = str;
            this.cameraBackends = cameraBackends;
            if (str != null) {
                if (cameraBackends.containsKey(str != null ? C5699e.a(str) : null)) {
                    return;
                }
                StringBuilder sb2 = new StringBuilder();
                sb2.append((Object) (str == null ? "null" : C5699e.f(str)));
                sb2.append(" does not exist in cameraBackends! Available backends are: ");
                sb2.append(cameraBackends.keySet());
                throw new IllegalStateException(sb2.toString().toString());
            }
        }

        public /* synthetic */ a(b bVar, String str, Map map, int i10, kotlin.jvm.internal.i iVar) {
            this((i10 & 1) != 0 ? null : bVar, (i10 & 2) != 0 ? null : str, (i10 & 4) != 0 ? kotlin.collections.a.i() : map, null);
        }
    }

    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\f\b\u0086\b\u0018\u00002\u00020\u0001B+\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u000b\u001a\u00020\nHÖ\u0001¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u000e\u001a\u00020\rHÖ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u001a\u0010\u0012\u001a\u00020\u00112\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0012\u0010\u0013R\u0019\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\u0019\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0006¢\u0006\f\n\u0004\b\u0016\u0010\u0018\u001a\u0004\b\u0014\u0010\u0019R\u0019\u0010\u0007\u001a\u0004\u0018\u00010\u00068\u0006¢\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001a\u0010\u001c¨\u0006\u001d"}, d2 = {"Landroidx/camera/camera2/pipe/h$b;", "", "Landroid/hardware/camera2/CameraDevice$StateCallback;", "cameraDeviceStateCallback", "Landroidx/camera/camera2/pipe/f$b;", "cameraCaptureSessionListener", "Lz/i;", "cameraOpenRetryMaxTimeoutNs", "<init>", "(Landroid/hardware/camera2/CameraDevice$StateCallback;Landroidx/camera/camera2/pipe/f$b;Lz/i;Lkotlin/jvm/internal/i;)V", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", Const.INTENT_KEY_APIKEY, "Landroid/hardware/camera2/CameraDevice$StateCallback;", Const.INTENT_KEY_PKGNAME, "()Landroid/hardware/camera2/CameraDevice$StateCallback;", "Landroidx/camera/camera2/pipe/f$b;", "()Landroidx/camera/camera2/pipe/f$b;", "c", "Lz/i;", "()Lz/i;", "camera-camera2-pipe"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* renamed from: androidx.camera.camera2.pipe.h$b, reason: from toString */
    public static final /* data */ class CameraInteropConfig {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
        public final CameraDevice.StateCallback cameraDeviceStateCallback;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
        public final f.b cameraCaptureSessionListener;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
        public final z.i cameraOpenRetryMaxTimeoutNs;

        public /* synthetic */ CameraInteropConfig(CameraDevice.StateCallback stateCallback, f.b bVar, z.i iVar, kotlin.jvm.internal.i iVar2) {
            this(stateCallback, bVar, iVar);
        }

        /* renamed from: a, reason: from getter */
        public final f.b getCameraCaptureSessionListener() {
            return this.cameraCaptureSessionListener;
        }

        /* renamed from: b, reason: from getter */
        public final CameraDevice.StateCallback getCameraDeviceStateCallback() {
            return this.cameraDeviceStateCallback;
        }

        /* renamed from: c, reason: from getter */
        public final z.i getCameraOpenRetryMaxTimeoutNs() {
            return this.cameraOpenRetryMaxTimeoutNs;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof CameraInteropConfig)) {
                return false;
            }
            CameraInteropConfig cameraInteropConfig = (CameraInteropConfig) other;
            return kotlin.jvm.internal.p.d(this.cameraDeviceStateCallback, cameraInteropConfig.cameraDeviceStateCallback) && kotlin.jvm.internal.p.d(this.cameraCaptureSessionListener, cameraInteropConfig.cameraCaptureSessionListener) && kotlin.jvm.internal.p.d(this.cameraOpenRetryMaxTimeoutNs, cameraInteropConfig.cameraOpenRetryMaxTimeoutNs);
        }

        public int hashCode() {
            CameraDevice.StateCallback stateCallback = this.cameraDeviceStateCallback;
            int iHashCode = (stateCallback == null ? 0 : stateCallback.hashCode()) * 31;
            f.b bVar = this.cameraCaptureSessionListener;
            int iHashCode2 = (iHashCode + (bVar == null ? 0 : bVar.hashCode())) * 31;
            z.i iVar = this.cameraOpenRetryMaxTimeoutNs;
            return iHashCode2 + (iVar != null ? z.i.e(iVar.getValue()) : 0);
        }

        public String toString() {
            return "CameraInteropConfig(cameraDeviceStateCallback=" + this.cameraDeviceStateCallback + ", cameraCaptureSessionListener=" + this.cameraCaptureSessionListener + ", cameraOpenRetryMaxTimeoutNs=" + this.cameraOpenRetryMaxTimeoutNs + ')';
        }

        public CameraInteropConfig(CameraDevice.StateCallback stateCallback, f.b bVar, z.i iVar) {
            this.cameraDeviceStateCallback = stateCallback;
            this.cameraCaptureSessionListener = bVar;
            this.cameraOpenRetryMaxTimeoutNs = iVar;
        }

        public /* synthetic */ CameraInteropConfig(CameraDevice.StateCallback stateCallback, f.b bVar, z.i iVar, int i10, kotlin.jvm.internal.i iVar2) {
            this((i10 & 1) != 0 ? null : stateCallback, (i10 & 2) != 0 ? null : bVar, (i10 & 4) != 0 ? null : iVar, null);
        }
    }

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u00002\u00020\u0001B;\u0012\u0012\b\u0002\u0010\u0004\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00030\u0002\u0012\u001e\b\u0002\u0010\u0007\u001a\u0018\u0012\u0004\u0012\u00020\u0006\u0012\u000e\u0012\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00030\u00020\u0005¢\u0006\u0004\b\b\u0010\tR!\u0010\u0004\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00030\u00028\u0006¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\n\u0010\fR-\u0010\u0007\u001a\u0018\u0012\u0004\u0012\u00020\u0006\u0012\u000e\u0012\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00030\u00020\u00058\u0006¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\r\u0010\u000f¨\u0006\u0010"}, d2 = {"Landroidx/camera/camera2/pipe/h$c;", "", "", "Landroid/hardware/camera2/CameraCharacteristics$Key;", "cacheBlocklist", "", "Lw/n;", "cameraCacheBlocklist", "<init>", "(Ljava/util/Set;Ljava/util/Map;)V", Const.INTENT_KEY_APIKEY, "Ljava/util/Set;", "()Ljava/util/Set;", Const.INTENT_KEY_PKGNAME, "Ljava/util/Map;", "()Ljava/util/Map;", "camera-camera2-pipe"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class c {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        public final Set<CameraCharacteristics.Key<?>> cacheBlocklist;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        public final Map<C5708n, Set<CameraCharacteristics.Key<?>>> cameraCacheBlocklist;

        /* JADX WARN: Multi-variable type inference failed */
        public c() {
            this(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
        }

        public final Set<CameraCharacteristics.Key<?>> a() {
            return this.cacheBlocklist;
        }

        public final Map<C5708n, Set<CameraCharacteristics.Key<?>>> b() {
            return this.cameraCacheBlocklist;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public c(Set<? extends CameraCharacteristics.Key<?>> cacheBlocklist, Map<C5708n, ? extends Set<? extends CameraCharacteristics.Key<?>>> cameraCacheBlocklist) {
            kotlin.jvm.internal.p.i(cacheBlocklist, "cacheBlocklist");
            kotlin.jvm.internal.p.i(cameraCacheBlocklist, "cameraCacheBlocklist");
            this.cacheBlocklist = cacheBlocklist;
            this.cameraCacheBlocklist = cameraCacheBlocklist;
        }

        public /* synthetic */ c(Set set, Map map, int i10, kotlin.jvm.internal.i iVar) {
            this((i10 & 1) != 0 ? Y.e() : set, (i10 & 2) != 0 ? kotlin.collections.a.i() : map);
        }
    }

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Landroidx/camera/camera2/pipe/h$d;", "", "<init>", "()V", "Landroidx/camera/camera2/pipe/h$e;", "config", "Landroidx/camera/camera2/pipe/h;", Const.INTENT_KEY_APIKEY, "(Landroidx/camera/camera2/pipe/h$e;)Landroidx/camera/camera2/pipe/h;", "camera-camera2-pipe"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* renamed from: androidx.camera.camera2.pipe.h$d, reason: from kotlin metadata */
    public static final class Companion {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ Companion f10920a = new Companion();

        public final h a(Config config) {
            kotlin.jvm.internal.p.i(config, "config");
            z.h hVar = z.h.f44503a;
            try {
                Trace.beginSection("CameraPipe");
                InterfaceC5905p interfaceC5905pA = C5882I.a().b(new C5906q(config)).c(new a0(config.getThreadConfig())).a();
                Trace.endSection();
                kotlin.jvm.internal.p.f(interfaceC5905pA);
                return new i(interfaceC5905pA);
            } catch (Throwable th) {
                Trace.endSection();
                throw th;
            }
        }
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\t\b\u0087\b\u0018\u00002\u00020\u0001B\u0011\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0007\u001a\u00020\u0006HÖ\u0001¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\n\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u001a\u0010\r\u001a\u00020\u00022\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\r\u0010\u000eR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u000f\u0010\u0011¨\u0006\u0012"}, d2 = {"Landroidx/camera/camera2/pipe/h$f;", "", "", "strictModeEnabled", "<init>", "(Z)V", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "equals", "(Ljava/lang/Object;)Z", Const.INTENT_KEY_APIKEY, "Z", "()Z", "camera-camera2-pipe"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* renamed from: androidx.camera.camera2.pipe.h$f, reason: from toString */
    public static final /* data */ class Flags {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
        public final boolean strictModeEnabled;

        public Flags() {
            this(false, 1, null);
        }

        /* renamed from: a, reason: from getter */
        public final boolean getStrictModeEnabled() {
            return this.strictModeEnabled;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof Flags) && this.strictModeEnabled == ((Flags) other).strictModeEnabled;
        }

        public int hashCode() {
            return Boolean.hashCode(this.strictModeEnabled);
        }

        public String toString() {
            return "Flags(strictModeEnabled=" + this.strictModeEnabled + ')';
        }

        public Flags(boolean z10) {
            this.strictModeEnabled = z10;
        }

        public /* synthetic */ Flags(boolean z10, int i10, kotlin.jvm.internal.i iVar) {
            this((i10 & 1) != 0 ? false : z10);
        }
    }

    @Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0012\b\u0086\b\u0018\u00002\u00020\u0001Ba\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007\u0012\u0010\b\u0002\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\t\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u0010\u001a\u00020\u000fHÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0013\u001a\u00020\u0012HÖ\u0001¢\u0006\u0004\b\u0013\u0010\u0014J\u001a\u0010\u0017\u001a\u00020\u00162\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0017\u0010\u0018R\u0019\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001cR\u0019\u0010\u0004\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u001d\u0010\u001a\u001a\u0004\b\u0019\u0010\u001cR\u0019\u0010\u0005\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u001e\u0010\u001a\u001a\u0004\b\u001d\u0010\u001cR\u0019\u0010\u0006\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u001f\u0010\u001a\u001a\u0004\b\u001e\u0010\u001cR\u0019\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006¢\u0006\f\n\u0004\b \u0010!\u001a\u0004\b\u001f\u0010\"R\u001f\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\t8\u0006¢\u0006\f\n\u0004\b\u001b\u0010#\u001a\u0004\b \u0010$R\u0019\u0010\f\u001a\u0004\u0018\u00010\u000b8\u0006¢\u0006\f\n\u0004\b%\u0010&\u001a\u0004\b%\u0010'¨\u0006("}, d2 = {"Landroidx/camera/camera2/pipe/h$g;", "", "Ljava/util/concurrent/Executor;", "defaultLightweightExecutor", "defaultBackgroundExecutor", "defaultBlockingExecutor", "defaultCameraExecutor", "Landroid/os/Handler;", "defaultCameraHandler", "Lkotlin/Function0;", "defaultCameraHandlerFn", "LUa/M;", "testOnlyScope", "<init>", "(Ljava/util/concurrent/Executor;Ljava/util/concurrent/Executor;Ljava/util/concurrent/Executor;Ljava/util/concurrent/Executor;Landroid/os/Handler;Lp9/a;LUa/M;)V", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", Const.INTENT_KEY_APIKEY, "Ljava/util/concurrent/Executor;", "f", "()Ljava/util/concurrent/Executor;", Const.INTENT_KEY_PKGNAME, "c", Const.INTENT_KEY_UMID, "e", "Landroid/os/Handler;", "()Landroid/os/Handler;", "Lp9/a;", "()Lp9/a;", Const.INTENT_KEY_BACKGROUND_COMMAND, "LUa/M;", "()LUa/M;", "camera-camera2-pipe"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* renamed from: androidx.camera.camera2.pipe.h$g, reason: from toString */
    public static final /* data */ class ThreadConfig {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
        public final Executor defaultLightweightExecutor;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
        public final Executor defaultBackgroundExecutor;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
        public final Executor defaultBlockingExecutor;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
        public final Executor defaultCameraExecutor;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
        public final Handler defaultCameraHandler;

        /* renamed from: f, reason: collision with root package name and from kotlin metadata and from toString */
        public final InterfaceC5063a<Handler> defaultCameraHandlerFn;

        /* renamed from: g, reason: collision with root package name and from kotlin metadata and from toString */
        public final M testOnlyScope;

        public ThreadConfig() {
            this(null, null, null, null, null, null, null, 127, null);
        }

        /* renamed from: a, reason: from getter */
        public final Executor getDefaultBackgroundExecutor() {
            return this.defaultBackgroundExecutor;
        }

        /* renamed from: b, reason: from getter */
        public final Executor getDefaultBlockingExecutor() {
            return this.defaultBlockingExecutor;
        }

        /* renamed from: c, reason: from getter */
        public final Executor getDefaultCameraExecutor() {
            return this.defaultCameraExecutor;
        }

        /* renamed from: d, reason: from getter */
        public final Handler getDefaultCameraHandler() {
            return this.defaultCameraHandler;
        }

        public final InterfaceC5063a<Handler> e() {
            return this.defaultCameraHandlerFn;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ThreadConfig)) {
                return false;
            }
            ThreadConfig threadConfig = (ThreadConfig) other;
            return kotlin.jvm.internal.p.d(this.defaultLightweightExecutor, threadConfig.defaultLightweightExecutor) && kotlin.jvm.internal.p.d(this.defaultBackgroundExecutor, threadConfig.defaultBackgroundExecutor) && kotlin.jvm.internal.p.d(this.defaultBlockingExecutor, threadConfig.defaultBlockingExecutor) && kotlin.jvm.internal.p.d(this.defaultCameraExecutor, threadConfig.defaultCameraExecutor) && kotlin.jvm.internal.p.d(this.defaultCameraHandler, threadConfig.defaultCameraHandler) && kotlin.jvm.internal.p.d(this.defaultCameraHandlerFn, threadConfig.defaultCameraHandlerFn) && kotlin.jvm.internal.p.d(this.testOnlyScope, threadConfig.testOnlyScope);
        }

        /* renamed from: f, reason: from getter */
        public final Executor getDefaultLightweightExecutor() {
            return this.defaultLightweightExecutor;
        }

        /* renamed from: g, reason: from getter */
        public final M getTestOnlyScope() {
            return this.testOnlyScope;
        }

        public int hashCode() {
            Executor executor = this.defaultLightweightExecutor;
            int iHashCode = (executor == null ? 0 : executor.hashCode()) * 31;
            Executor executor2 = this.defaultBackgroundExecutor;
            int iHashCode2 = (iHashCode + (executor2 == null ? 0 : executor2.hashCode())) * 31;
            Executor executor3 = this.defaultBlockingExecutor;
            int iHashCode3 = (iHashCode2 + (executor3 == null ? 0 : executor3.hashCode())) * 31;
            Executor executor4 = this.defaultCameraExecutor;
            int iHashCode4 = (iHashCode3 + (executor4 == null ? 0 : executor4.hashCode())) * 31;
            Handler handler = this.defaultCameraHandler;
            int iHashCode5 = (iHashCode4 + (handler == null ? 0 : handler.hashCode())) * 31;
            InterfaceC5063a<Handler> interfaceC5063a = this.defaultCameraHandlerFn;
            int iHashCode6 = (iHashCode5 + (interfaceC5063a == null ? 0 : interfaceC5063a.hashCode())) * 31;
            M m10 = this.testOnlyScope;
            return iHashCode6 + (m10 != null ? m10.hashCode() : 0);
        }

        public String toString() {
            return "ThreadConfig(defaultLightweightExecutor=" + this.defaultLightweightExecutor + ", defaultBackgroundExecutor=" + this.defaultBackgroundExecutor + ", defaultBlockingExecutor=" + this.defaultBlockingExecutor + ", defaultCameraExecutor=" + this.defaultCameraExecutor + ", defaultCameraHandler=" + this.defaultCameraHandler + ", defaultCameraHandlerFn=" + this.defaultCameraHandlerFn + ", testOnlyScope=" + this.testOnlyScope + ')';
        }

        /* JADX WARN: Multi-variable type inference failed */
        public ThreadConfig(Executor executor, Executor executor2, Executor executor3, Executor executor4, Handler handler, InterfaceC5063a<? extends Handler> interfaceC5063a, M m10) {
            this.defaultLightweightExecutor = executor;
            this.defaultBackgroundExecutor = executor2;
            this.defaultBlockingExecutor = executor3;
            this.defaultCameraExecutor = executor4;
            this.defaultCameraHandler = handler;
            this.defaultCameraHandlerFn = interfaceC5063a;
            this.testOnlyScope = m10;
        }

        public /* synthetic */ ThreadConfig(Executor executor, Executor executor2, Executor executor3, Executor executor4, Handler handler, InterfaceC5063a interfaceC5063a, M m10, int i10, kotlin.jvm.internal.i iVar) {
            this((i10 & 1) != 0 ? null : executor, (i10 & 2) != 0 ? null : executor2, (i10 & 4) != 0 ? null : executor3, (i10 & 8) != 0 ? null : executor4, (i10 & 16) != 0 ? null : handler, (i10 & 32) != 0 ? null : interfaceC5063a, (i10 & 64) != 0 ? null : m10);
        }
    }

    InterfaceC5705k a();

    Object b(CameraGraph.b bVar, InterfaceC4014c<? super o> interfaceC4014c);

    C5711q c();

    CameraGraph d(CameraGraph.b config);

    List<CameraGraph> e(CameraGraph.a config);

    void shutdown();

    @Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u001b\b\u0087\b\u0018\u00002\u00020\u0001BY\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006\u0012\b\b\u0002\u0010\t\u001a\u00020\b\u0012\b\b\u0002\u0010\u000b\u001a\u00020\n\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\f\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u000e\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0010¢\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0015\u001a\u00020\u0014HÖ\u0001¢\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0018\u001a\u00020\u0017HÖ\u0001¢\u0006\u0004\b\u0018\u0010\u0019J\u001a\u0010\u001c\u001a\u00020\u001b2\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u001c\u0010\u001dR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b\u001e\u0010 R\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010$R\u0017\u0010\u0007\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b%\u0010&\u001a\u0004\b'\u0010(R\u0017\u0010\t\u001a\u00020\b8\u0006¢\u0006\f\n\u0004\b'\u0010)\u001a\u0004\b!\u0010*R\u0017\u0010\u000b\u001a\u00020\n8\u0006¢\u0006\f\n\u0004\b+\u0010,\u001a\u0004\b%\u0010-R\u0019\u0010\r\u001a\u0004\u0018\u00010\f8\u0006¢\u0006\f\n\u0004\b.\u0010/\u001a\u0004\b.\u00100R\u0017\u0010\u000f\u001a\u00020\u000e8\u0006¢\u0006\f\n\u0004\b1\u00102\u001a\u0004\b+\u00103R\u0019\u0010\u0011\u001a\u0004\u0018\u00010\u00108\u0006¢\u0006\f\n\u0004\b\u0011\u00104\u001a\u0004\b1\u00105¨\u00066"}, d2 = {"Landroidx/camera/camera2/pipe/h$e;", "", "Landroid/content/Context;", "appContext", "Landroidx/camera/camera2/pipe/h$g;", "threadConfig", "Landroidx/camera/camera2/pipe/h$c;", "cameraMetadataConfig", "Landroidx/camera/camera2/pipe/h$a;", "cameraBackendConfig", "Landroidx/camera/camera2/pipe/h$b;", "cameraInteropConfig", "LC/m;", "imageSources", "Landroidx/camera/camera2/pipe/h$f;", "flags", "Lw/I;", "platformApiCompat", "<init>", "(Landroid/content/Context;Landroidx/camera/camera2/pipe/h$g;Landroidx/camera/camera2/pipe/h$c;Landroidx/camera/camera2/pipe/h$a;Landroidx/camera/camera2/pipe/h$b;LC/m;Landroidx/camera/camera2/pipe/h$f;Lw/I;)V", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", Const.INTENT_KEY_APIKEY, "Landroid/content/Context;", "()Landroid/content/Context;", Const.INTENT_KEY_PKGNAME, "Landroidx/camera/camera2/pipe/h$g;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "()Landroidx/camera/camera2/pipe/h$g;", "c", "Landroidx/camera/camera2/pipe/h$c;", Const.INTENT_KEY_UMID, "()Landroidx/camera/camera2/pipe/h$c;", "Landroidx/camera/camera2/pipe/h$a;", "()Landroidx/camera/camera2/pipe/h$a;", "e", "Landroidx/camera/camera2/pipe/h$b;", "()Landroidx/camera/camera2/pipe/h$b;", "f", "LC/m;", "()LC/m;", Const.INTENT_KEY_BACKGROUND_COMMAND, "Landroidx/camera/camera2/pipe/h$f;", "()Landroidx/camera/camera2/pipe/h$f;", "Lw/I;", "()Lw/I;", "camera-camera2-pipe"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* renamed from: androidx.camera.camera2.pipe.h$e, reason: from toString */
    public static final /* data */ class Config {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
        public final Context appContext;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
        public final ThreadConfig threadConfig;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
        public final c cameraMetadataConfig;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
        public final a cameraBackendConfig;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
        public final CameraInteropConfig cameraInteropConfig;

        /* renamed from: f, reason: collision with root package name and from kotlin metadata and from toString */
        public final C.m imageSources;

        /* renamed from: g, reason: collision with root package name and from kotlin metadata and from toString */
        public final Flags flags;

        public Config(Context appContext, ThreadConfig threadConfig, c cameraMetadataConfig, a cameraBackendConfig, CameraInteropConfig cameraInteropConfig, C.m mVar, Flags flags, I i10) {
            kotlin.jvm.internal.p.i(appContext, "appContext");
            kotlin.jvm.internal.p.i(threadConfig, "threadConfig");
            kotlin.jvm.internal.p.i(cameraMetadataConfig, "cameraMetadataConfig");
            kotlin.jvm.internal.p.i(cameraBackendConfig, "cameraBackendConfig");
            kotlin.jvm.internal.p.i(cameraInteropConfig, "cameraInteropConfig");
            kotlin.jvm.internal.p.i(flags, "flags");
            this.appContext = appContext;
            this.threadConfig = threadConfig;
            this.cameraMetadataConfig = cameraMetadataConfig;
            this.cameraBackendConfig = cameraBackendConfig;
            this.cameraInteropConfig = cameraInteropConfig;
            this.imageSources = mVar;
            this.flags = flags;
        }

        /* renamed from: a, reason: from getter */
        public final Context getAppContext() {
            return this.appContext;
        }

        /* renamed from: b, reason: from getter */
        public final a getCameraBackendConfig() {
            return this.cameraBackendConfig;
        }

        /* renamed from: c, reason: from getter */
        public final CameraInteropConfig getCameraInteropConfig() {
            return this.cameraInteropConfig;
        }

        /* renamed from: d, reason: from getter */
        public final c getCameraMetadataConfig() {
            return this.cameraMetadataConfig;
        }

        /* renamed from: e, reason: from getter */
        public final Flags getFlags() {
            return this.flags;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Config)) {
                return false;
            }
            Config config = (Config) other;
            return kotlin.jvm.internal.p.d(this.appContext, config.appContext) && kotlin.jvm.internal.p.d(this.threadConfig, config.threadConfig) && kotlin.jvm.internal.p.d(this.cameraMetadataConfig, config.cameraMetadataConfig) && kotlin.jvm.internal.p.d(this.cameraBackendConfig, config.cameraBackendConfig) && kotlin.jvm.internal.p.d(this.cameraInteropConfig, config.cameraInteropConfig) && kotlin.jvm.internal.p.d(this.imageSources, config.imageSources) && kotlin.jvm.internal.p.d(this.flags, config.flags) && kotlin.jvm.internal.p.d(null, null);
        }

        /* renamed from: f, reason: from getter */
        public final C.m getImageSources() {
            return this.imageSources;
        }

        public final I g() {
            return null;
        }

        /* renamed from: h, reason: from getter */
        public final ThreadConfig getThreadConfig() {
            return this.threadConfig;
        }

        public int hashCode() {
            int iHashCode = ((((((((this.appContext.hashCode() * 31) + this.threadConfig.hashCode()) * 31) + this.cameraMetadataConfig.hashCode()) * 31) + this.cameraBackendConfig.hashCode()) * 31) + this.cameraInteropConfig.hashCode()) * 31;
            C.m mVar = this.imageSources;
            return (((iHashCode + (mVar == null ? 0 : mVar.hashCode())) * 31) + this.flags.hashCode()) * 31;
        }

        public String toString() {
            return "Config(appContext=" + this.appContext + ", threadConfig=" + this.threadConfig + ", cameraMetadataConfig=" + this.cameraMetadataConfig + ", cameraBackendConfig=" + this.cameraBackendConfig + ", cameraInteropConfig=" + this.cameraInteropConfig + ", imageSources=" + this.imageSources + ", flags=" + this.flags + ", platformApiCompat=" + ((Object) null) + ')';
        }

        /* JADX WARN: Multi-variable type inference failed */
        public /* synthetic */ Config(Context context, ThreadConfig threadConfig, c cVar, a aVar, CameraInteropConfig cameraInteropConfig, C.m mVar, Flags flags, I i10, int i11, kotlin.jvm.internal.i iVar) {
            Flags flags2;
            threadConfig = (i11 & 2) != 0 ? new ThreadConfig(null, null, null, null, null, null, null, 127, null) : threadConfig;
            Object[] objArr = 0;
            cVar = (i11 & 4) != 0 ? new c(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0) : cVar;
            a aVar2 = (i11 & 8) != 0 ? new a(null, null, null, 7, null) : aVar;
            CameraInteropConfig cameraInteropConfig2 = (i11 & 16) != 0 ? new CameraInteropConfig(null, null, null, 7, null) : cameraInteropConfig;
            C.m mVar2 = (i11 & 32) != 0 ? null : mVar;
            if ((i11 & 64) != 0) {
                flags2 = new Flags(false, 1, objArr == true ? 1 : 0);
            } else {
                flags2 = flags;
            }
            this(context, threadConfig, cVar, aVar2, cameraInteropConfig2, mVar2, flags2, (i11 & 128) != 0 ? null : i10);
        }
    }
}
