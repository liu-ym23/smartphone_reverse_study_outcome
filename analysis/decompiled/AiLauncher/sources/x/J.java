package x;

import Z8.C1173v;
import Z8.C1174w;
import android.hardware.camera2.CameraCharacteristics;
import android.hardware.camera2.CaptureRequest;
import android.hardware.camera2.CaptureResult;
import android.os.Build;
import android.os.Trace;
import android.util.ArrayMap;
import android.util.Log;
import androidx.camera.camera2.pipe.q;
import androidx.exifinterface.media.ExifInterface;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.ailauncher.chat.voice.support.C3081a;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.C4848b;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import p9.InterfaceC5063a;
import w.C5708n;
import w.InterfaceC5707m;
import w9.InterfaceC5745d;

@Metadata(d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0012\b\u0000\u0018\u00002\u00020\u0001BS\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\t\u001a\u00020\b\u0012\u0018\u0010\r\u001a\u0014\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u000b\u0012\u0006\u0012\u0004\u0018\u00010\f0\n\u0012\u0010\u0010\u0010\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u000f0\u000e¢\u0006\u0004\b\u0011\u0010\u0012J)\u0010\u0015\u001a\u0004\u0018\u00018\u0000\"\u0004\b\u0000\u0010\u0013*\u00020\u00062\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00028\u00000\u000fH\u0002¢\u0006\u0004\b\u0015\u0010\u0016J&\u0010\u0017\u001a\u0004\u0018\u00018\u0000\"\u0004\b\u0000\u0010\u00132\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00028\u00000\u000fH\u0096\u0002¢\u0006\u0004\b\u0017\u0010\u0018J+\u0010\u001a\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u00132\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00028\u00000\u000f2\u0006\u0010\u0019\u001a\u00028\u0000H\u0016¢\u0006\u0004\b\u001a\u0010\u001bJ)\u0010\u001e\u001a\u0004\u0018\u00018\u0000\"\b\b\u0000\u0010\u0013*\u00020\f2\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00028\u00000\u001cH\u0016¢\u0006\u0004\b\u001e\u0010\u001fJ\u0017\u0010!\u001a\u00020\u00012\u0006\u0010 \u001a\u00020\u0002H\u0016¢\u0006\u0004\b!\u0010\"J\u0017\u0010&\u001a\u00020%2\u0006\u0010$\u001a\u00020#H\u0016¢\u0006\u0004\b&\u0010'R\u001a\u0010\u0003\u001a\u00020\u00028\u0016X\u0096\u0004¢\u0006\f\n\u0004\b(\u0010)\u001a\u0004\b*\u0010+R\u001a\u0010\u0005\u001a\u00020\u00048\u0016X\u0096\u0004¢\u0006\f\n\u0004\b*\u0010,\u001a\u0004\b\u0005\u0010-R\u0014\u0010\u0007\u001a\u00020\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b.\u0010/R\u0014\u0010\t\u001a\u00020\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b0\u00101R&\u0010\r\u001a\u0014\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u000b\u0012\u0006\u0012\u0004\u0018\u00010\f0\n8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b2\u00103R\u001e\u0010\u0010\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u000f0\u000e8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b4\u00105R&\u00109\u001a\u0014\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u000f\u0012\u0006\u0012\u0004\u0018\u00010\f068\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\b7\u00108R \u0010;\u001a\u000e\u0012\u0004\u0012\u00020#\u0012\u0004\u0012\u00020%068\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\b:\u00108R \u0010?\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020#0\u000e0<8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b=\u0010>R$\u0010A\u001a\u0012\u0012\u000e\u0012\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u000f0\u000e0<8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b@\u0010>R$\u0010D\u001a\u0012\u0012\u000e\u0012\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030B0\u000e0<8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bC\u0010>R$\u0010G\u001a\u0012\u0012\u000e\u0012\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030E0\u000e0<8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bF\u0010>R \u0010I\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\u000e0<8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bH\u0010>R$\u0010K\u001a\u0012\u0012\u000e\u0012\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030B0\u000e0<8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bJ\u0010>R$\u0010M\u001a\u0012\u0012\u000e\u0012\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u000f0\u000e0<8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bL\u0010>R$\u0010O\u001a\u0012\u0012\u000e\u0012\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030B0\u000e0<8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bN\u0010>R\u001e\u0010R\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030B0\u000e8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bP\u0010QR\u001a\u0010T\u001a\b\u0012\u0004\u0012\u00020\u00020\u000e8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bS\u0010QR\u001a\u0010V\u001a\b\u0012\u0004\u0012\u00020#0\u000e8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bU\u0010Q¨\u0006W"}, d2 = {"Lx/J;", "Landroidx/camera/camera2/pipe/g;", "Lw/n;", C3081a.CAMERA_FOCUS, "", "isRedacted", "Landroid/hardware/camera2/CameraCharacteristics;", "characteristics", "Lx/c0;", "metadataProvider", "", "Landroidx/camera/camera2/pipe/q$a;", "", "metadata", "", "Landroid/hardware/camera2/CameraCharacteristics$Key;", "cacheBlocklist", "<init>", "(Ljava/lang/String;ZLandroid/hardware/camera2/CameraCharacteristics;Lx/c0;Ljava/util/Map;Ljava/util/Set;Lkotlin/jvm/internal/i;)V", ExifInterface.GPS_DIRECTION_TRUE, "key", "F", "(Landroid/hardware/camera2/CameraCharacteristics;Landroid/hardware/camera2/CameraCharacteristics$Key;)Ljava/lang/Object;", "e0", "(Landroid/hardware/camera2/CameraCharacteristics$Key;)Ljava/lang/Object;", "default", "h1", "(Landroid/hardware/camera2/CameraCharacteristics$Key;Ljava/lang/Object;)Ljava/lang/Object;", "Lw9/d;", "type", "R0", "(Lw9/d;)Ljava/lang/Object;", "cameraId", "v0", "(Ljava/lang/String;)Landroidx/camera/camera2/pipe/g;", "", "extension", "Lw/m;", "b1", "(I)Lw/m;", Const.INTENT_KEY_APIKEY, "Ljava/lang/String;", Const.INTENT_KEY_PKGNAME, "()Ljava/lang/String;", "Z", "()Z", "c", "Landroid/hardware/camera2/CameraCharacteristics;", Const.INTENT_KEY_UMID, "Lx/c0;", "e", "Ljava/util/Map;", "f", "Ljava/util/Set;", "Landroid/util/ArrayMap;", Const.INTENT_KEY_BACKGROUND_COMMAND, "Landroid/util/ArrayMap;", "values", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "extensionCache", "LY8/h;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "LY8/h;", "_supportedExtensions", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_REMOVE, "_keys", "Landroid/hardware/camera2/CaptureRequest$Key;", "k", "_requestKeys", "Landroid/hardware/camera2/CaptureResult$Key;", "l", "_resultKeys", "m", "_physicalCameraIds", "n", "_physicalRequestKeys", "o", "_sessionCharacteristicsKeys", "p", "_sessionKeys", "l1", "()Ljava/util/Set;", "sessionKeys", "I0", "physicalCameraIds", "g0", "supportedExtensions", "camera-camera2-pipe"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes.dex */
public final class J implements androidx.camera.camera2.pipe.g {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final String camera;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public final boolean isRedacted;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    public final CameraCharacteristics characteristics;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    public final InterfaceC5808c0 metadataProvider;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    public final Map<q.a<?>, Object> metadata;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    public final Set<CameraCharacteristics.Key<?>> cacheBlocklist;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    public final ArrayMap<CameraCharacteristics.Key<?>, Object> values;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    public final ArrayMap<Integer, InterfaceC5707m> extensionCache;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    public final Y8.h<Set<Integer>> _supportedExtensions;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    public final Y8.h<Set<CameraCharacteristics.Key<?>>> _keys;

    /* renamed from: k, reason: collision with root package name and from kotlin metadata */
    public final Y8.h<Set<CaptureRequest.Key<?>>> _requestKeys;

    /* renamed from: l, reason: collision with root package name and from kotlin metadata */
    public final Y8.h<Set<CaptureResult.Key<?>>> _resultKeys;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    public final Y8.h<Set<C5708n>> _physicalCameraIds;

    /* renamed from: n, reason: collision with root package name and from kotlin metadata */
    public final Y8.h<Set<CaptureRequest.Key<?>>> _physicalRequestKeys;

    /* renamed from: o, reason: collision with root package name and from kotlin metadata */
    public final Y8.h<Set<CameraCharacteristics.Key<?>>> _sessionCharacteristicsKeys;

    /* renamed from: p, reason: collision with root package name and from kotlin metadata */
    public final Y8.h<Set<CaptureRequest.Key<?>>> _sessionKeys;

    public /* synthetic */ J(String str, boolean z10, CameraCharacteristics cameraCharacteristics, InterfaceC5808c0 interfaceC5808c0, Map map, Set set, kotlin.jvm.internal.i iVar) {
        this(str, z10, cameraCharacteristics, interfaceC5808c0, map, set);
    }

    public static final Set B(J j10) {
        try {
            z.h hVar = z.h.f44503a;
            try {
                Trace.beginSection("Camera-" + j10.getCamera() + "#availableSessionKeys");
                List<CaptureRequest.Key<?>> listC = C5823k.c(j10.characteristics);
                if (listC == null) {
                    listC = C1173v.m();
                }
                Set setR1 = Z8.F.r1(listC);
                Trace.endSection();
                return setR1;
            } catch (Throwable th) {
                Trace.endSection();
                throw th;
            }
        } catch (AssertionError e10) {
            if (z.k.f44508a.d()) {
                Log.w("CXCP", "Failed to getAvailableSessionKeys from Camera-" + j10.getCamera(), e10);
            }
            return Z8.Y.e();
        }
    }

    public static final Set C(J j10) {
        try {
            z.h hVar = z.h.f44503a;
            try {
                Trace.beginSection("Camera-" + ((Object) C5708n.f(j10.getCamera())) + "#supportedExtensions");
                return j10.metadataProvider.b(j10.getCamera());
            } finally {
                Trace.endSection();
            }
        } catch (AssertionError e10) {
            if (z.k.f44508a.d()) {
                Log.w("CXCP", "Failed to getSupportedExtensions from Camera-" + ((Object) C5708n.f(j10.getCamera())), e10);
            }
            return Z8.Y.e();
        }
    }

    public static final Set t(J j10) {
        try {
            z.h hVar = z.h.f44503a;
            try {
                Trace.beginSection(((Object) C5708n.f(j10.getCamera())) + "#keys");
                List<CameraCharacteristics.Key<?>> keys = j10.characteristics.getKeys();
                if (keys == null) {
                    keys = C1173v.m();
                }
                Set setR1 = Z8.F.r1(keys);
                Trace.endSection();
                return setR1;
            } catch (Throwable th) {
                Trace.endSection();
                throw th;
            }
        } catch (AssertionError e10) {
            if (z.k.f44508a.d()) {
                Log.w("CXCP", "Failed to getKeys from " + ((Object) C5708n.f(j10.getCamera())) + '}', e10);
            }
            return Z8.Y.e();
        }
    }

    public static final Set u(J j10) {
        try {
            z.h hVar = z.h.f44503a;
            try {
                Trace.beginSection(((Object) C5708n.f(j10.getCamera())) + "#physicalCameraIds");
                Set<String> setE = C5823k.e(j10.characteristics);
                if (z.k.f44508a.c()) {
                    Log.i("CXCP", "Loaded physicalCameraIds from " + ((Object) C5708n.f(j10.getCamera())) + ": " + setE);
                }
                if (setE == null) {
                    setE = Z8.Y.e();
                }
                Set<String> set = setE;
                ArrayList arrayList = new ArrayList(C1174w.x(set, 10));
                Iterator<T> it = set.iterator();
                while (it.hasNext()) {
                    arrayList.add(C5708n.a(C5708n.b((String) it.next())));
                }
                Set setR1 = Z8.F.r1(arrayList);
                Trace.endSection();
                return setR1;
            } catch (Throwable th) {
                Trace.endSection();
                throw th;
            }
        } catch (AssertionError e10) {
            if (z.k.f44508a.d()) {
                Log.w("CXCP", "Failed to getPhysicalCameraIds from " + ((Object) C5708n.f(j10.getCamera())), e10);
            }
            return Z8.Y.e();
        } catch (NullPointerException e11) {
            if (z.k.f44508a.d()) {
                Log.w("CXCP", "Failed to getPhysicalCameraIds from " + ((Object) C5708n.f(j10.getCamera())), e11);
            }
            return Z8.Y.e();
        }
    }

    public static final Set v(J j10) {
        try {
            z.h hVar = z.h.f44503a;
            try {
                Trace.beginSection("Camera-" + j10.getCamera() + "#availablePhysicalCameraRequestKeys");
                List<CaptureRequest.Key<?>> listB = C5823k.b(j10.characteristics);
                if (listB == null) {
                    listB = C1173v.m();
                }
                Set setR1 = Z8.F.r1(listB);
                Trace.endSection();
                return setR1;
            } catch (Throwable th) {
                Trace.endSection();
                throw th;
            }
        } catch (AssertionError e10) {
            if (z.k.f44508a.d()) {
                Log.w("CXCP", "Failed to getAvailablePhysicalCameraRequestKeys from Camera-" + j10.getCamera(), e10);
            }
            return Z8.Y.e();
        }
    }

    public static final Set x(J j10) {
        try {
            z.h hVar = z.h.f44503a;
            try {
                Trace.beginSection(((Object) C5708n.f(j10.getCamera())) + "#availableCaptureRequestKeys");
                List<CaptureRequest.Key<?>> availableCaptureRequestKeys = j10.characteristics.getAvailableCaptureRequestKeys();
                if (availableCaptureRequestKeys == null) {
                    availableCaptureRequestKeys = C1173v.m();
                }
                Set setR1 = Z8.F.r1(availableCaptureRequestKeys);
                Trace.endSection();
                return setR1;
            } catch (Throwable th) {
                Trace.endSection();
                throw th;
            }
        } catch (AssertionError e10) {
            if (z.k.f44508a.d()) {
                Log.w("CXCP", "Failed to getAvailableCaptureRequestKeys from " + ((Object) C5708n.f(j10.getCamera())), e10);
            }
            return Z8.Y.e();
        }
    }

    public static final Set y(J j10) {
        try {
            z.h hVar = z.h.f44503a;
            try {
                Trace.beginSection(((Object) C5708n.f(j10.getCamera())) + "#availableCaptureResultKeys");
                List<CaptureResult.Key<?>> availableCaptureResultKeys = j10.characteristics.getAvailableCaptureResultKeys();
                if (availableCaptureResultKeys == null) {
                    availableCaptureResultKeys = C1173v.m();
                }
                Set setR1 = Z8.F.r1(availableCaptureResultKeys);
                Trace.endSection();
                return setR1;
            } catch (Throwable th) {
                Trace.endSection();
                throw th;
            }
        } catch (AssertionError e10) {
            if (z.k.f44508a.d()) {
                Log.w("CXCP", "Failed to getAvailableCaptureResultKeys from " + ((Object) C5708n.f(j10.getCamera())), e10);
            }
            return Z8.Y.e();
        }
    }

    public static final Set z(J j10) {
        if (Build.VERSION.SDK_INT < 35) {
            return Z8.Y.e();
        }
        try {
            z.h hVar = z.h.f44503a;
            try {
                Trace.beginSection("Camera-" + j10.getCamera() + "#getAvailableSessionCharacteristicsKeys");
                List<CameraCharacteristics.Key<?>> listA = C5835v.a(j10.characteristics);
                if (listA == null) {
                    listA = C1173v.m();
                }
                Set setR1 = Z8.F.r1(listA);
                Trace.endSection();
                return setR1;
            } catch (Throwable th) {
                Trace.endSection();
                throw th;
            }
        } catch (AssertionError e10) {
            if (z.k.f44508a.d()) {
                Log.w("CXCP", "Failed to getAvailableSessionCharacteristicsKeys from Camera-" + j10.getCamera(), e10);
            }
            return Z8.Y.e();
        }
    }

    public final <T> T F(CameraCharacteristics cameraCharacteristics, CameraCharacteristics.Key<T> key) {
        try {
            return (T) cameraCharacteristics.get(key);
        } catch (AssertionError unused) {
            throw new IllegalStateException("Failed to get characteristic for " + key + ": Framework throw an AssertionError");
        }
    }

    @Override // androidx.camera.camera2.pipe.g
    public Set<C5708n> I0() {
        return this._physicalCameraIds.getValue();
    }

    @Override // w.U
    public <T> T R0(InterfaceC5745d<T> type) {
        kotlin.jvm.internal.p.i(type, "type");
        if (!kotlin.jvm.internal.p.d(type, kotlin.jvm.internal.t.b(CameraCharacteristics.class))) {
            return null;
        }
        T t10 = (T) this.characteristics;
        kotlin.jvm.internal.p.g(t10, "null cannot be cast to non-null type T of androidx.camera.camera2.pipe.compat.Camera2CameraMetadata.unwrapAs");
        return t10;
    }

    @Override // androidx.camera.camera2.pipe.g
    /* renamed from: b, reason: from getter */
    public String getCamera() {
        return this.camera;
    }

    @Override // androidx.camera.camera2.pipe.g
    public InterfaceC5707m b1(int extension) {
        InterfaceC5707m interfaceC5707m;
        synchronized (this.extensionCache) {
            interfaceC5707m = this.extensionCache.get(Integer.valueOf(extension));
        }
        if (interfaceC5707m != null) {
            return interfaceC5707m;
        }
        InterfaceC5707m interfaceC5707mD = this.metadataProvider.d(getCamera(), extension);
        synchronized (this.extensionCache) {
            this.extensionCache.put(Integer.valueOf(extension), interfaceC5707mD);
            Y8.t tVar = Y8.t.f7040a;
        }
        return interfaceC5707mD;
    }

    @Override // androidx.camera.camera2.pipe.g
    public <T> T e0(CameraCharacteristics.Key<T> key) {
        T t10;
        kotlin.jvm.internal.p.i(key, "key");
        if (this.cacheBlocklist.contains(key)) {
            return (T) F(this.characteristics, key);
        }
        synchronized (this.values) {
            t10 = (T) this.values.get(key);
        }
        if (t10 != null) {
            return t10;
        }
        T t11 = (T) F(this.characteristics, key);
        if (t11 == null) {
            return t11;
        }
        synchronized (this.values) {
            this.values.put(key, t11);
            Y8.t tVar = Y8.t.f7040a;
        }
        return t11;
    }

    @Override // androidx.camera.camera2.pipe.g
    public Set<Integer> g0() {
        return this._supportedExtensions.getValue();
    }

    @Override // androidx.camera.camera2.pipe.g
    public <T> T h1(CameraCharacteristics.Key<T> key, T t10) {
        kotlin.jvm.internal.p.i(key, "key");
        T t11 = (T) e0(key);
        return t11 == null ? t10 : t11;
    }

    @Override // androidx.camera.camera2.pipe.g
    public Set<CaptureRequest.Key<?>> l1() {
        return this._sessionKeys.getValue();
    }

    @Override // androidx.camera.camera2.pipe.g
    public androidx.camera.camera2.pipe.g v0(String cameraId) {
        kotlin.jvm.internal.p.i(cameraId, "cameraId");
        if (I0().contains(C5708n.a(cameraId))) {
            return this.metadataProvider.a(cameraId);
        }
        throw new IllegalStateException((((Object) C5708n.f(cameraId)) + " is not a valid physical camera on " + this).toString());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public J(String camera, boolean z10, CameraCharacteristics characteristics, InterfaceC5808c0 metadataProvider, Map<q.a<?>, ? extends Object> metadata, Set<? extends CameraCharacteristics.Key<?>> cacheBlocklist) {
        kotlin.jvm.internal.p.i(camera, "camera");
        kotlin.jvm.internal.p.i(characteristics, "characteristics");
        kotlin.jvm.internal.p.i(metadataProvider, "metadataProvider");
        kotlin.jvm.internal.p.i(metadata, "metadata");
        kotlin.jvm.internal.p.i(cacheBlocklist, "cacheBlocklist");
        this.camera = camera;
        this.isRedacted = z10;
        this.characteristics = characteristics;
        this.metadataProvider = metadataProvider;
        this.metadata = metadata;
        this.cacheBlocklist = cacheBlocklist;
        this.values = new ArrayMap<>();
        this.extensionCache = new ArrayMap<>();
        LazyThreadSafetyMode lazyThreadSafetyMode = LazyThreadSafetyMode.PUBLICATION;
        this._supportedExtensions = C4848b.a(lazyThreadSafetyMode, new InterfaceC5063a() { // from class: x.B
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return J.C(this.f43293a);
            }
        });
        this._keys = C4848b.a(lazyThreadSafetyMode, new InterfaceC5063a() { // from class: x.C
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return J.t(this.f43295a);
            }
        });
        this._requestKeys = C4848b.a(lazyThreadSafetyMode, new InterfaceC5063a() { // from class: x.D
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return J.x(this.f43297a);
            }
        });
        this._resultKeys = C4848b.a(lazyThreadSafetyMode, new InterfaceC5063a() { // from class: x.E
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return J.y(this.f43300a);
            }
        });
        this._physicalCameraIds = C4848b.a(lazyThreadSafetyMode, new InterfaceC5063a() { // from class: x.F
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return J.u(this.f43306a);
            }
        });
        this._physicalRequestKeys = C4848b.a(lazyThreadSafetyMode, new InterfaceC5063a() { // from class: x.G
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return J.v(this.f43307a);
            }
        });
        this._sessionCharacteristicsKeys = C4848b.a(lazyThreadSafetyMode, new InterfaceC5063a() { // from class: x.H
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return J.z(this.f43308a);
            }
        });
        this._sessionKeys = C4848b.a(lazyThreadSafetyMode, new InterfaceC5063a() { // from class: x.I
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return J.B(this.f43312a);
            }
        });
    }
}
