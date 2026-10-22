package x;

import android.hardware.camera2.CameraExtensionCharacteristics;
import android.hardware.camera2.CaptureRequest;
import android.hardware.camera2.CaptureResult;
import android.os.Trace;
import android.util.Log;
import android.util.Size;
import androidx.camera.camera2.pipe.q;
import androidx.exifinterface.media.ExifInterface;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.ailauncher.chat.voice.support.C3081a;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import kotlin.C4848b;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import p9.InterfaceC5063a;
import w.C5708n;
import w.InterfaceC5707m;
import w9.InterfaceC5745d;

@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\b\u0001\u0018\u00002\u00020\u0001BA\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\t\u001a\u00020\b\u0012\u0018\u0010\r\u001a\u0014\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u000b\u0012\u0006\u0012\u0004\u0018\u00010\f0\n¢\u0006\u0004\b\u000e\u0010\u000fJ)\u0010\u0013\u001a\u0004\u0018\u00018\u0000\"\b\b\u0000\u0010\u0010*\u00020\f2\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00028\u00000\u0011H\u0016¢\u0006\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0003\u001a\u00020\u00028\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R\u001a\u0010\u0005\u001a\u00020\u00048\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0017\u0010\u0019\u001a\u0004\b\u0005\u0010\u001aR\u001a\u0010\u0007\u001a\u00020\u00068\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001eR\u0014\u0010\t\u001a\u00020\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001f\u0010 R&\u0010\r\u001a\u0014\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u000b\u0012\u0006\u0012\u0004\u0018\u00010\f0\n8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b!\u0010\"R,\u0010(\u001a\u001a\u0012\u0004\u0012\u00020\u0006\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020&0%0$0#8\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\b'\u0010\"R0\u0010+\u001a\u001e\u0012\b\u0012\u0006\u0012\u0002\b\u00030)\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020&0%0$0#8\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\b*\u0010\"R,\u0010,\u001a\u001a\u0012\u0004\u0012\u00020&\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020&0%0$0#8\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\b\u001d\u0010\"R$\u00100\u001a\u0012\u0012\u000e\u0012\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030-0%0$8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b.\u0010/R$\u00103\u001a\u0012\u0012\u000e\u0012\f\u0012\b\u0012\u0006\u0012\u0002\b\u0003010%0$8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b2\u0010/R\u001a\u00105\u001a\b\u0012\u0004\u0012\u00020\u00040$8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b4\u0010/R\u001a\u00107\u001a\b\u0012\u0004\u0012\u00020\u00040$8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b6\u0010/R\u0014\u00108\u001a\u00020\u00048VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b.\u0010\u001a¨\u00069"}, d2 = {"Lx/A;", "Lw/m;", "Lw/n;", C3081a.CAMERA_FOCUS, "", "isRedacted", "", "cameraExtension", "Landroid/hardware/camera2/CameraExtensionCharacteristics;", "extensionCharacteristics", "", "Landroidx/camera/camera2/pipe/q$a;", "", "metadata", "<init>", "(Ljava/lang/String;ZILandroid/hardware/camera2/CameraExtensionCharacteristics;Ljava/util/Map;Lkotlin/jvm/internal/i;)V", ExifInterface.GPS_DIRECTION_TRUE, "Lw9/d;", "type", "R0", "(Lw9/d;)Ljava/lang/Object;", Const.INTENT_KEY_APIKEY, "Ljava/lang/String;", Const.INTENT_KEY_PKGNAME, "()Ljava/lang/String;", "Z", "()Z", "c", "I", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "()I", Const.INTENT_KEY_UMID, "Landroid/hardware/camera2/CameraExtensionCharacteristics;", "e", "Ljava/util/Map;", "", "LY8/h;", "", "Landroid/util/Size;", "f", "supportedExtensionSizesByFormat", "Ljava/lang/Class;", Const.INTENT_KEY_BACKGROUND_COMMAND, "supportedExtensionSizesByClass", "supportedPostviewSizes", "Landroid/hardware/camera2/CaptureRequest$Key;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "LY8/h;", "_requestKeys", "Landroid/hardware/camera2/CaptureResult$Key;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_REMOVE, "_resultKeys", "k", "_isPostviewSupported", "l", "_isCaptureProgressSupported", "isPostviewSupported", "camera-camera2-pipe"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* renamed from: x.A, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C5799A implements InterfaceC5707m {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final String camera;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public final boolean isRedacted;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    public final int cameraExtension;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    public final CameraExtensionCharacteristics extensionCharacteristics;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    public final Map<q.a<?>, Object> metadata;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    public final Map<Integer, Y8.h<Set<Size>>> supportedExtensionSizesByFormat;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    public final Map<Class<?>, Y8.h<Set<Size>>> supportedExtensionSizesByClass;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    public final Map<Size, Y8.h<Set<Size>>> supportedPostviewSizes;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    public final Y8.h<Set<CaptureRequest.Key<?>>> _requestKeys;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    public final Y8.h<Set<CaptureResult.Key<?>>> _resultKeys;

    /* renamed from: k, reason: collision with root package name and from kotlin metadata */
    public final Y8.h<Boolean> _isPostviewSupported;

    /* renamed from: l, reason: collision with root package name and from kotlin metadata */
    public final Y8.h<Boolean> _isCaptureProgressSupported;

    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    /* renamed from: x.A$a */
    public static final class a implements InterfaceC5063a<Set<? extends CaptureRequest.Key<Object>>> {
        public a(C5799A c5799a) {
        }

        @Override // p9.InterfaceC5063a
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Set<CaptureRequest.Key<Object>> invoke() {
            String str = ((Object) C5708n.f(C5799A.this.getCamera())) + "#availableCaptureRequestKeys";
            try {
                z.h hVar = z.h.f44503a;
                try {
                    Trace.beginSection(str);
                    Set<CaptureRequest.Key<Object>> setR1 = Z8.F.r1(C5829o.a(C5799A.this.extensionCharacteristics, C5799A.this.getCameraExtension()));
                    if (setR1 == null) {
                        setR1 = Z8.Y.e();
                    }
                    return setR1;
                } finally {
                    Trace.endSection();
                }
            } catch (Throwable th) {
                if (z.k.f44508a.d()) {
                    Log.w("CXCP", "Failed to get " + str + "! Caching {} and ignoring exception.", th);
                }
                return Z8.Y.e();
            }
        }
    }

    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    /* renamed from: x.A$b */
    public static final class b implements InterfaceC5063a<Set<? extends CaptureResult.Key<Object>>> {
        public b(C5799A c5799a) {
        }

        @Override // p9.InterfaceC5063a
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Set<CaptureResult.Key<Object>> invoke() {
            String str = ((Object) C5708n.f(C5799A.this.getCamera())) + "#availableCaptureResultKeys";
            try {
                z.h hVar = z.h.f44503a;
                try {
                    Trace.beginSection(str);
                    Set<CaptureResult.Key<Object>> setR1 = Z8.F.r1(C5829o.b(C5799A.this.extensionCharacteristics, C5799A.this.getCameraExtension()));
                    if (setR1 == null) {
                        setR1 = Z8.Y.e();
                    }
                    return setR1;
                } finally {
                    Trace.endSection();
                }
            } catch (Throwable th) {
                if (z.k.f44508a.d()) {
                    Log.w("CXCP", "Failed to get " + str + "! Caching {} and ignoring exception.", th);
                }
                return Z8.Y.e();
            }
        }
    }

    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    /* renamed from: x.A$c */
    public static final class c implements InterfaceC5063a<Boolean> {
        public c(C5799A c5799a) {
        }

        @Override // p9.InterfaceC5063a
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Boolean invoke() {
            boolean zB;
            String str = ((Object) C5708n.f(C5799A.this.getCamera())) + "#isPostviewSupported";
            try {
                z.h hVar = z.h.f44503a;
                try {
                    Trace.beginSection(str);
                    zB = C5830p.b(C5799A.this.extensionCharacteristics, C5799A.this.getCameraExtension());
                    Trace.endSection();
                } catch (Throwable th) {
                    Trace.endSection();
                    throw th;
                }
            } catch (Throwable th2) {
                if (z.k.f44508a.d()) {
                    Log.w("CXCP", "Failed to get " + str + "! Caching false and ignoring exception.", th2);
                }
                zB = false;
            }
            return Boolean.valueOf(zB);
        }
    }

    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    /* renamed from: x.A$d */
    public static final class d implements InterfaceC5063a<Boolean> {
        public d(C5799A c5799a) {
        }

        @Override // p9.InterfaceC5063a
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Boolean invoke() {
            boolean zA;
            String str = ((Object) C5708n.f(C5799A.this.getCamera())) + "#isCaptureProgressSupported";
            try {
                z.h hVar = z.h.f44503a;
                try {
                    Trace.beginSection(str);
                    zA = C5830p.a(C5799A.this.extensionCharacteristics, C5799A.this.getCameraExtension());
                    Trace.endSection();
                } catch (Throwable th) {
                    Trace.endSection();
                    throw th;
                }
            } catch (Throwable th2) {
                if (z.k.f44508a.d()) {
                    Log.w("CXCP", "Failed to get " + str + "! Caching false and ignoring exception.", th2);
                }
                zA = false;
            }
            return Boolean.valueOf(zA);
        }
    }

    public /* synthetic */ C5799A(String str, boolean z10, int i10, CameraExtensionCharacteristics cameraExtensionCharacteristics, Map map, kotlin.jvm.internal.i iVar) {
        this(str, z10, i10, cameraExtensionCharacteristics, map);
    }

    @Override // w.U
    public <T> T R0(InterfaceC5745d<T> type) {
        kotlin.jvm.internal.p.i(type, "type");
        if (!kotlin.jvm.internal.p.d(type, kotlin.jvm.internal.t.b(CameraExtensionCharacteristics.class))) {
            return null;
        }
        T t10 = (T) this.extensionCharacteristics;
        kotlin.jvm.internal.p.g(t10, "null cannot be cast to non-null type T of androidx.camera.camera2.pipe.compat.Camera2CameraExtensionMetadata.unwrapAs");
        return t10;
    }

    /* renamed from: b, reason: from getter */
    public String getCamera() {
        return this.camera;
    }

    /* renamed from: h, reason: from getter */
    public int getCameraExtension() {
        return this.cameraExtension;
    }

    @Override // w.InterfaceC5707m
    public boolean i() {
        return this._isPostviewSupported.getValue().booleanValue();
    }

    public C5799A(String camera, boolean z10, int i10, CameraExtensionCharacteristics extensionCharacteristics, Map<q.a<?>, ? extends Object> metadata) {
        kotlin.jvm.internal.p.i(camera, "camera");
        kotlin.jvm.internal.p.i(extensionCharacteristics, "extensionCharacteristics");
        kotlin.jvm.internal.p.i(metadata, "metadata");
        this.camera = camera;
        this.isRedacted = z10;
        this.cameraExtension = i10;
        this.extensionCharacteristics = extensionCharacteristics;
        this.metadata = metadata;
        this.supportedExtensionSizesByFormat = new LinkedHashMap();
        this.supportedExtensionSizesByClass = new LinkedHashMap();
        this.supportedPostviewSizes = new LinkedHashMap();
        LazyThreadSafetyMode lazyThreadSafetyMode = LazyThreadSafetyMode.PUBLICATION;
        this._requestKeys = C4848b.a(lazyThreadSafetyMode, new a(this));
        this._resultKeys = C4848b.a(lazyThreadSafetyMode, new b(this));
        this._isPostviewSupported = C4848b.a(lazyThreadSafetyMode, new c(this));
        this._isCaptureProgressSupported = C4848b.a(lazyThreadSafetyMode, new d(this));
    }
}
