package androidx.camera.camera2.impl;

import D.C;
import android.hardware.camera2.CameraCaptureSession;
import android.hardware.camera2.CameraDevice;
import android.hardware.camera2.CaptureRequest;
import androidx.camera.core.impl.Config;
import androidx.camera.core.impl.t;
import androidx.camera.core.impl.u;
import androidx.camera.core.impl.v;
import androidx.exifinterface.media.ExifInterface;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.statsapp.v3.lib.plugin.constants.UxipConstants;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.p;
import t.C5471a;
import v.C5649f;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\t\b\u0007\u0018\u0000 \u001c2\u00020\u0001:\u0002\u001d\u001eB\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0015\u0010\b\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\u001b\u0010\u000b\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\n¢\u0006\u0004\b\u000b\u0010\fJ\u001b\u0010\u000e\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\r¢\u0006\u0004\b\u000e\u0010\u000fJ\u001b\u0010\u0011\u001a\u0004\u0018\u00010\u00102\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0010¢\u0006\u0004\b\u0011\u0010\u0012J\u001b\u0010\u0014\u001a\u0004\u0018\u00010\u00132\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0013¢\u0006\u0004\b\u0014\u0010\u0015J\u001b\u0010\u0017\u001a\u0004\u0018\u00010\u00162\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0016¢\u0006\u0004\b\u0017\u0010\u0018R\u0011\u0010\u001b\u001a\u00020\u00018G¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u001a¨\u0006\u001f"}, d2 = {"Landroidx/camera/camera2/impl/a;", "Lv/f;", "Landroidx/camera/core/impl/Config;", "config", "<init>", "(Landroidx/camera/core/impl/Config;)V", "", "valueIfMissing", "i0", "(I)I", "", "r0", "(Ljava/lang/Long;)Ljava/lang/Long;", "Landroid/hardware/camera2/CameraDevice$StateCallback;", "j0", "(Landroid/hardware/camera2/CameraDevice$StateCallback;)Landroid/hardware/camera2/CameraDevice$StateCallback;", "Landroid/hardware/camera2/CameraCaptureSession$StateCallback;", "p0", "(Landroid/hardware/camera2/CameraCaptureSession$StateCallback;)Landroid/hardware/camera2/CameraCaptureSession$StateCallback;", "Landroid/hardware/camera2/CameraCaptureSession$CaptureCallback;", "n0", "(Landroid/hardware/camera2/CameraCaptureSession$CaptureCallback;)Landroid/hardware/camera2/CameraCaptureSession$CaptureCallback;", "", "l0", "(Ljava/lang/String;)Ljava/lang/String;", "h0", "()Lv/f;", "captureRequestOptions", ExifInterface.LATITUDE_SOUTH, Const.INTENT_KEY_APIKEY, Const.INTENT_KEY_PKGNAME, "camera-camera2"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes.dex */
public final class a extends C5649f {

    /* renamed from: T, reason: collision with root package name */
    public static final Config.a<Integer> f10030T;

    /* renamed from: U, reason: collision with root package name */
    public static final Config.a<CameraDevice.StateCallback> f10031U;

    /* renamed from: V, reason: collision with root package name */
    public static final Config.a<CameraCaptureSession.StateCallback> f10032V;

    /* renamed from: W, reason: collision with root package name */
    public static final Config.a<CameraCaptureSession.CaptureCallback> f10033W;

    /* renamed from: X, reason: collision with root package name */
    public static final Config.a<Long> f10034X;

    /* renamed from: Y, reason: collision with root package name */
    public static final Config.a<Long> f10035Y;

    /* renamed from: Z, reason: collision with root package name */
    public static final Config.a<Object> f10036Z;

    /* renamed from: a0, reason: collision with root package name */
    public static final Config.a<String> f10037a0;

    @Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J)\u0010\f\u001a\u00020\u0000\"\u0004\b\u0000\u0010\b2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00000\t2\u0006\u0010\u000b\u001a\u00028\u0000¢\u0006\u0004\b\f\u0010\rJ-\u0010\u0013\u001a\u00020\u00002\u0016\u0010\u0010\u001a\u0012\u0012\b\u0012\u0006\u0012\u0002\b\u00030\t\u0012\u0004\u0012\u00020\u000f0\u000e2\u0006\u0010\u0012\u001a\u00020\u0011¢\u0006\u0004\b\u0013\u0010\u0014J\u001f\u0010\u0017\u001a\u00020\u00002\u0010\u0010\u0016\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\t0\u0015¢\u0006\u0004\b\u0017\u0010\u0018J\u0015\u0010\u001b\u001a\u00020\u00002\u0006\u0010\u001a\u001a\u00020\u0019¢\u0006\u0004\b\u001b\u0010\u001cJ\u000f\u0010\u001d\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u001d\u0010\u001eR\u0014\u0010!\u001a\u00020\u001f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010 ¨\u0006\""}, d2 = {"Landroidx/camera/camera2/impl/a$a;", "LD/C;", "Landroidx/camera/camera2/impl/a;", "<init>", "()V", "Landroidx/camera/core/impl/t;", Const.INTENT_KEY_APIKEY, "()Landroidx/camera/core/impl/t;", "ValueT", "Landroid/hardware/camera2/CaptureRequest$Key;", "key", UxipConstants.f30680s, Const.INTENT_KEY_BACKGROUND_COMMAND, "(Landroid/hardware/camera2/CaptureRequest$Key;Ljava/lang/Object;)Landroidx/camera/camera2/impl/a$a;", "", "", "values", "Landroidx/camera/core/impl/Config$OptionPriority;", "priority", Const.INTENT_KEY_PKGNAME, "(Ljava/util/Map;Landroidx/camera/core/impl/Config$OptionPriority;)Landroidx/camera/camera2/impl/a$a;", "", "keys", "f", "(Ljava/util/List;)Landroidx/camera/camera2/impl/a$a;", "Landroidx/camera/core/impl/Config;", "config", "e", "(Landroidx/camera/core/impl/Config;)Landroidx/camera/camera2/impl/a$a;", "c", "()Landroidx/camera/camera2/impl/a;", "Landroidx/camera/core/impl/u;", "Landroidx/camera/core/impl/u;", "mutableOptionsBundle", "camera-camera2"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* renamed from: androidx.camera.camera2.impl.a$a, reason: collision with other inner class name */
    public static final class C0131a implements C<a> {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        public final u mutableOptionsBundle;

        public C0131a() {
            u uVarK0 = u.k0();
            p.h(uVarK0, "create(...)");
            this.mutableOptionsBundle = uVarK0;
        }

        @Override // D.C
        public t a() {
            return this.mutableOptionsBundle;
        }

        public final C0131a b(Map<CaptureRequest.Key<?>, ? extends Object> values, Config.OptionPriority priority) {
            p.i(values, "values");
            p.i(priority, "priority");
            for (Map.Entry<CaptureRequest.Key<?>, ? extends Object> entry : values.entrySet()) {
                CaptureRequest.Key<?> key = entry.getKey();
                Object value = entry.getValue();
                this.mutableOptionsBundle.q(C5471a.a(key), priority, value);
            }
            return this;
        }

        public a c() {
            v vVarJ0 = v.j0(this.mutableOptionsBundle);
            p.h(vVarJ0, "from(...)");
            return new a(vVarJ0);
        }

        public final C0131a e(Config config) {
            p.i(config, "config");
            for (Config.a<?> aVar : config.e()) {
                p.g(aVar, "null cannot be cast to non-null type androidx.camera.core.impl.Config.Option<kotlin.Any>");
                this.mutableOptionsBundle.q(aVar, config.h(aVar), config.a(aVar));
            }
            return this;
        }

        public final C0131a f(List<? extends CaptureRequest.Key<?>> keys) {
            p.i(keys, "keys");
            Iterator<T> it = keys.iterator();
            while (it.hasNext()) {
                this.mutableOptionsBundle.m0(C5471a.a((CaptureRequest.Key) it.next()));
            }
            return this;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public final <ValueT> C0131a g(CaptureRequest.Key<ValueT> key, ValueT value) {
            p.i(key, "key");
            this.mutableOptionsBundle.t(C5471a.a(key), value);
            return this;
        }
    }

    static {
        Class cls = Integer.TYPE;
        p.f(cls);
        Config.a<Integer> aVarA = Config.a.a("camera2.captureRequest.templateType", cls);
        p.h(aVarA, "create(...)");
        f10030T = aVarA;
        Config.a<CameraDevice.StateCallback> aVarA2 = Config.a.a("camera2.cameraDevice.stateCallback", CameraDevice.StateCallback.class);
        p.h(aVarA2, "create(...)");
        f10031U = aVarA2;
        Config.a<CameraCaptureSession.StateCallback> aVarA3 = Config.a.a("camera2.cameraCaptureSession.stateCallback", CameraCaptureSession.StateCallback.class);
        p.h(aVarA3, "create(...)");
        f10032V = aVarA3;
        Config.a<CameraCaptureSession.CaptureCallback> aVarA4 = Config.a.a("camera2.cameraCaptureSession.captureCallback", CameraCaptureSession.CaptureCallback.class);
        p.h(aVarA4, "create(...)");
        f10033W = aVarA4;
        Class cls2 = Long.TYPE;
        p.f(cls2);
        Config.a<Long> aVarA5 = Config.a.a("camera2.cameraCaptureSession.streamUseCase", cls2);
        p.h(aVarA5, "create(...)");
        f10034X = aVarA5;
        p.f(cls2);
        Config.a<Long> aVarA6 = Config.a.a("camera2.cameraCaptureSession.streamUseHint", cls2);
        p.h(aVarA6, "create(...)");
        f10035Y = aVarA6;
        Config.a<Object> aVarA7 = Config.a.a("camera2.captureRequest.tag", Object.class);
        p.h(aVarA7, "create(...)");
        f10036Z = aVarA7;
        Config.a<String> aVarA8 = Config.a.a("camera2.cameraCaptureSession.physicalCameraId", String.class);
        p.h(aVarA8, "create(...)");
        f10037a0 = aVarA8;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(Config config) {
        super(config);
        p.i(config, "config");
    }

    public static /* synthetic */ CameraDevice.StateCallback k0(a aVar, CameraDevice.StateCallback stateCallback, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            stateCallback = null;
        }
        return aVar.j0(stateCallback);
    }

    public static /* synthetic */ String m0(a aVar, String str, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = null;
        }
        return aVar.l0(str);
    }

    public static /* synthetic */ CameraCaptureSession.CaptureCallback o0(a aVar, CameraCaptureSession.CaptureCallback captureCallback, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            captureCallback = null;
        }
        return aVar.n0(captureCallback);
    }

    public static /* synthetic */ CameraCaptureSession.StateCallback q0(a aVar, CameraCaptureSession.StateCallback stateCallback, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            stateCallback = null;
        }
        return aVar.p0(stateCallback);
    }

    public static /* synthetic */ Long s0(a aVar, Long l10, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            l10 = null;
        }
        return aVar.r0(l10);
    }

    public final C5649f h0() {
        return C5649f.a.INSTANCE.b(getConfig()).b();
    }

    public final int i0(int valueIfMissing) {
        Object objG = getConfig().g(f10030T, Integer.valueOf(valueIfMissing));
        p.f(objG);
        return ((Number) objG).intValue();
    }

    public final CameraDevice.StateCallback j0(CameraDevice.StateCallback valueIfMissing) {
        return (CameraDevice.StateCallback) getConfig().g(f10031U, valueIfMissing);
    }

    public final String l0(String valueIfMissing) {
        return (String) getConfig().g(f10037a0, valueIfMissing);
    }

    public final CameraCaptureSession.CaptureCallback n0(CameraCaptureSession.CaptureCallback valueIfMissing) {
        return (CameraCaptureSession.CaptureCallback) getConfig().g(f10033W, valueIfMissing);
    }

    public final CameraCaptureSession.StateCallback p0(CameraCaptureSession.StateCallback valueIfMissing) {
        return (CameraCaptureSession.StateCallback) getConfig().g(f10032V, valueIfMissing);
    }

    public final Long r0(Long valueIfMissing) {
        return (Long) getConfig().g(f10034X, valueIfMissing);
    }
}
