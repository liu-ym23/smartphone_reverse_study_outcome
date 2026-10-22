package o;

import D.C0761b0;
import D.InterfaceC0778o;
import K.InterfaceC0898v;
import K.w0;
import Z8.C1173v;
import android.graphics.Rect;
import android.hardware.camera2.CameraCharacteristics;
import android.os.Build;
import android.util.Log;
import android.util.Size;
import android.view.AbstractC1404w;
import androidx.camera.core.CameraState;
import androidx.exifinterface.media.ExifInterface;
import com.autonavi.aps.amapapi.config.Const;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.C4848b;
import kotlin.Metadata;
import p.C5027i;
import p9.InterfaceC5063a;
import t.C5473b;
import t.C5493u;
import t.InterfaceC5494v;
import u.InterfaceC5562j;
import v.C5645b;
import w.C5708n;
import w9.InterfaceC5745d;

@Metadata(d1 = {"\u0000È\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0014\n\u0002\u0010#\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u0000 62\u00020\u00012\u00020\u0002:\u0001/Ba\b\u0007\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\n\u001a\u00020\t\u0012\u0006\u0010\f\u001a\u00020\u000b\u0012\u0006\u0010\u000e\u001a\u00020\r\u0012\u0006\u0010\u0010\u001a\u00020\u000f\u0012\u0006\u0010\u0012\u001a\u00020\u0011\u0012\u0006\u0010\u0014\u001a\u00020\u0013\u0012\u0006\u0010\u0016\u001a\u00020\u0015\u0012\u0006\u0010\u0018\u001a\u00020\u0017¢\u0006\u0004\b\u0019\u0010\u001aJ\u0017\u0010\u001d\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001bH\u0003¢\u0006\u0004\b\u001d\u0010\u001eJ\u000f\u0010 \u001a\u00020\u001fH\u0016¢\u0006\u0004\b \u0010!J\u000f\u0010\"\u001a\u00020\u001bH\u0016¢\u0006\u0004\b\"\u0010#J\u000f\u0010%\u001a\u00020$H\u0016¢\u0006\u0004\b%\u0010&J\u000f\u0010'\u001a\u00020\u001bH\u0016¢\u0006\u0004\b'\u0010#J\u0017\u0010)\u001a\u00020\u001b2\u0006\u0010(\u001a\u00020\u001bH\u0016¢\u0006\u0004\b)\u0010\u001eJ\u0015\u0010,\u001a\b\u0012\u0004\u0012\u00020+0*H\u0016¢\u0006\u0004\b,\u0010-J\u0015\u0010/\u001a\b\u0012\u0004\u0012\u00020\u001b0.H\u0016¢\u0006\u0004\b/\u00100J\u001d\u00104\u001a\b\u0012\u0004\u0012\u000203022\u0006\u00101\u001a\u00020\u001bH\u0016¢\u0006\u0004\b4\u00105J\u001d\u00106\u001a\b\u0012\u0004\u0012\u000203022\u0006\u00101\u001a\u00020\u001bH\u0016¢\u0006\u0004\b6\u00105J)\u0010;\u001a\u0004\u0018\u00018\u0000\"\b\b\u0000\u00108*\u0002072\f\u0010:\u001a\b\u0012\u0004\u0012\u00028\u000009H\u0017¢\u0006\u0004\b;\u0010<J\u000f\u0010=\u001a\u00020\u001fH\u0016¢\u0006\u0004\b=\u0010!J\u000f\u0010?\u001a\u00020>H\u0016¢\u0006\u0004\b?\u0010@J\u0015\u0010B\u001a\b\u0012\u0004\u0012\u00020A0.H\u0016¢\u0006\u0004\bB\u00100J\u000f\u0010D\u001a\u00020CH\u0016¢\u0006\u0004\bD\u0010EJ\u000f\u0010G\u001a\u00020FH\u0016¢\u0006\u0004\bG\u0010HJ\u000f\u0010I\u001a\u00020FH\u0016¢\u0006\u0004\bI\u0010HJ\u0015\u0010J\u001a\b\u0012\u0004\u0012\u00020\u001b0.H\u0016¢\u0006\u0004\bJ\u00100R\u0014\u0010\u0004\u001a\u00020\u00038\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b/\u0010KR\u0014\u0010\u0006\u001a\u00020\u00058\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bL\u0010MR\u0014\u0010\b\u001a\u00020\u00078\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bB\u0010NR\u0014\u0010\n\u001a\u00020\t8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bO\u0010PR\u0014\u0010\f\u001a\u00020\u000b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b'\u0010QR\u0014\u0010\u000e\u001a\u00020\r8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bR\u0010SR\u0014\u0010\u0010\u001a\u00020\u000f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bT\u0010UR\u0014\u0010\u0012\u001a\u00020\u00118\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b \u0010VR\u0014\u0010\u0014\u001a\u00020\u00138\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bW\u0010XR\u0014\u0010\u0016\u001a\u00020\u00158\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bD\u0010YR\u0014\u0010\u0018\u001a\u00020\u00178\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\"\u0010ZR!\u0010`\u001a\b\u0012\u0004\u0012\u00020\\0[8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b]\u0010^\u001a\u0004\b_\u00100R\u001b\u0010b\u001a\u00020F8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\ba\u0010^\u001a\u0004\bb\u0010HR!\u0010i\u001a\u00020c8@X\u0081\u0084\u0002¢\u0006\u0012\n\u0004\bd\u0010^\u0012\u0004\bg\u0010h\u001a\u0004\be\u0010f¨\u0006j"}, d2 = {"Lo/j;", "LK/v;", "Lw/U;", "Lt/v;", "cameraProperties", "Ls/m;", "cameraConfig", "Lo/m;", "cameraStateAdapter", "Lo/a;", "cameraControlStateAdapter", "Landroidx/camera/camera2/impl/b;", "cameraCallbackMap", "Landroidx/camera/camera2/impl/d;", "focusMeteringControl", "Landroidx/camera/camera2/compat/quirk/a;", "cameraQuirks", "LK/V;", "encoderProfilesProvider", "Lp/q;", "streamConfigurationMapCompat", "Lu/j;", "intrinsicZoomCalculator", "LP/i;", "streamSpecsCalculator", "<init>", "(Lt/v;Ls/m;Lo/m;Lo/a;Landroidx/camera/camera2/impl/b;Landroidx/camera/camera2/impl/d;Landroidx/camera/camera2/compat/quirk/a;LK/V;Lp/q;Lu/j;LP/i;)V", "", "lensFacingInt", "L", "(I)I", "", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "()Ljava/lang/String;", "k", "()I", "Landroid/hardware/camera2/CameraCharacteristics;", "K", "()Landroid/hardware/camera2/CameraCharacteristics;", "e", "relativeRotation", "z", "Landroidx/lifecycle/w;", "Landroidx/camera/core/CameraState;", "y", "()Landroidx/lifecycle/w;", "", Const.INTENT_KEY_APIKEY, "()Ljava/util/Set;", "format", "", "Landroid/util/Size;", "t", "(I)Ljava/util/List;", "o", "", ExifInterface.GPS_DIRECTION_TRUE, "Lw9/d;", "type", "R0", "(Lw9/d;)Ljava/lang/Object;", "toString", "LK/w0;", "s", "()LK/w0;", "LD/B;", "c", "Landroid/graphics/Rect;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_REMOVE, "()Landroid/graphics/Rect;", "", "B", "()Z", "v", "u", "Lt/v;", Const.INTENT_KEY_PKGNAME, "Ls/m;", "Lo/m;", Const.INTENT_KEY_UMID, "Lo/a;", "Landroidx/camera/camera2/impl/b;", "f", "Landroidx/camera/camera2/impl/d;", Const.INTENT_KEY_BACKGROUND_COMMAND, "Landroidx/camera/camera2/compat/quirk/a;", "LK/V;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "Lp/q;", "Lu/j;", "LP/i;", "", "LD/o;", "l", "LY8/h;", "get_physicalCameraInfos", "_physicalCameraInfos", "m", "isLegacyDevice", "Lv/b;", "n", "I", "()Lv/b;", "getCamera2CameraInfo$camera_camera2$annotations", "()V", "camera2CameraInfo", "camera-camera2"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* renamed from: o.j, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C4978j implements InterfaceC0898v, w.U {

    /* renamed from: o, reason: collision with root package name and from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final InterfaceC5494v cameraProperties;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public final s.m cameraConfig;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    public final C4981m cameraStateAdapter;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    public final C4969a cameraControlStateAdapter;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    public final androidx.camera.camera2.impl.b cameraCallbackMap;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    public final androidx.camera.camera2.impl.d focusMeteringControl;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    public final androidx.camera.camera2.compat.quirk.a cameraQuirks;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    public final K.V encoderProfilesProvider;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    public final p.q streamConfigurationMapCompat;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    public final InterfaceC5562j intrinsicZoomCalculator;

    /* renamed from: k, reason: collision with root package name and from kotlin metadata */
    public final P.i streamSpecsCalculator;

    /* renamed from: l, reason: collision with root package name and from kotlin metadata */
    public final Y8.h _physicalCameraInfos;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    public final Y8.h isLegacyDevice;

    /* renamed from: n, reason: collision with root package name and from kotlin metadata */
    public final Y8.h camera2CameraInfo;

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J+\u0010\b\u001a\u0004\u0018\u00018\u0000\"\b\b\u0000\u0010\u0004*\u00020\u0001*\u00020\u00052\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006¢\u0006\u0004\b\b\u0010\tR\u0017\u0010\r\u001a\u0004\u0018\u00010\n*\u00020\u00058F¢\u0006\u0006\u001a\u0004\b\u000b\u0010\f¨\u0006\u000e"}, d2 = {"Lo/j$a;", "", "<init>", "()V", ExifInterface.GPS_DIRECTION_TRUE, "LD/o;", "Lw9/d;", "type", Const.INTENT_KEY_PKGNAME, "(LD/o;Lw9/d;)Ljava/lang/Object;", "Lw/n;", Const.INTENT_KEY_APIKEY, "(LD/o;)Ljava/lang/String;", "cameraId", "camera-camera2"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* renamed from: o.j$a, reason: from kotlin metadata */
    public static final class Companion {
        public /* synthetic */ Companion(kotlin.jvm.internal.i iVar) {
            this();
        }

        public final String a(InterfaceC0778o cameraId) {
            kotlin.jvm.internal.p.i(cameraId, "$this$cameraId");
            androidx.camera.camera2.pipe.g gVar = (androidx.camera.camera2.pipe.g) b(cameraId, kotlin.jvm.internal.t.b(androidx.camera.camera2.pipe.g.class));
            if (gVar != null) {
                return gVar.getCamera();
            }
            return null;
        }

        public final <T> T b(InterfaceC0778o interfaceC0778o, InterfaceC5745d<T> type) {
            kotlin.jvm.internal.p.i(interfaceC0778o, "<this>");
            kotlin.jvm.internal.p.i(type, "type");
            if (interfaceC0778o instanceof w.U) {
                return (T) ((w.U) interfaceC0778o).R0(type);
            }
            if (interfaceC0778o instanceof InterfaceC0898v) {
                InterfaceC0898v interfaceC0898v = (InterfaceC0898v) interfaceC0778o;
                if (interfaceC0898v.getImplementation() != interfaceC0778o) {
                    InterfaceC0898v implementation = interfaceC0898v.getImplementation();
                    kotlin.jvm.internal.p.h(implementation, "getImplementation(...)");
                    return (T) b(implementation, type);
                }
            }
            return null;
        }

        public Companion() {
        }
    }

    public C4978j(InterfaceC5494v cameraProperties, s.m cameraConfig, C4981m cameraStateAdapter, C4969a cameraControlStateAdapter, androidx.camera.camera2.impl.b cameraCallbackMap, androidx.camera.camera2.impl.d focusMeteringControl, androidx.camera.camera2.compat.quirk.a cameraQuirks, K.V encoderProfilesProvider, p.q streamConfigurationMapCompat, InterfaceC5562j intrinsicZoomCalculator, P.i streamSpecsCalculator) {
        kotlin.jvm.internal.p.i(cameraProperties, "cameraProperties");
        kotlin.jvm.internal.p.i(cameraConfig, "cameraConfig");
        kotlin.jvm.internal.p.i(cameraStateAdapter, "cameraStateAdapter");
        kotlin.jvm.internal.p.i(cameraControlStateAdapter, "cameraControlStateAdapter");
        kotlin.jvm.internal.p.i(cameraCallbackMap, "cameraCallbackMap");
        kotlin.jvm.internal.p.i(focusMeteringControl, "focusMeteringControl");
        kotlin.jvm.internal.p.i(cameraQuirks, "cameraQuirks");
        kotlin.jvm.internal.p.i(encoderProfilesProvider, "encoderProfilesProvider");
        kotlin.jvm.internal.p.i(streamConfigurationMapCompat, "streamConfigurationMapCompat");
        kotlin.jvm.internal.p.i(intrinsicZoomCalculator, "intrinsicZoomCalculator");
        kotlin.jvm.internal.p.i(streamSpecsCalculator, "streamSpecsCalculator");
        this.cameraProperties = cameraProperties;
        this.cameraConfig = cameraConfig;
        this.cameraStateAdapter = cameraStateAdapter;
        this.cameraControlStateAdapter = cameraControlStateAdapter;
        this.cameraCallbackMap = cameraCallbackMap;
        this.focusMeteringControl = focusMeteringControl;
        this.cameraQuirks = cameraQuirks;
        this.encoderProfilesProvider = encoderProfilesProvider;
        this.streamConfigurationMapCompat = streamConfigurationMapCompat;
        this.intrinsicZoomCalculator = intrinsicZoomCalculator;
        this.streamSpecsCalculator = streamSpecsCalculator;
        t.P.f41841a.a(cameraProperties);
        this._physicalCameraInfos = C4848b.b(new InterfaceC5063a() { // from class: o.g
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return C4978j.F(this.f37380a);
            }
        });
        this.isLegacyDevice = C4848b.b(new InterfaceC5063a() { // from class: o.h
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return Boolean.valueOf(C4978j.O(this.f37381a));
            }
        });
        this.camera2CameraInfo = C4848b.b(new InterfaceC5063a() { // from class: o.i
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return C4978j.H(this.f37382a);
            }
        });
    }

    public static final Set F(C4978j c4978j) {
        Set<C5708n> setI0 = c4978j.cameraProperties.getMetadata().I0();
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        Iterator<T> it = setI0.iterator();
        while (it.hasNext()) {
            String value = ((C5708n) it.next()).getValue();
            linkedHashSet.add(new C4967G(new C5493u(new s.m(value, null), c4978j.cameraProperties.getMetadata().v0(value))));
        }
        return linkedHashSet;
    }

    public static final C5645b H(C4978j c4978j) {
        return C5645b.INSTANCE.a(c4978j.cameraProperties);
    }

    public static final boolean O(C4978j c4978j) {
        return androidx.camera.camera2.pipe.g.INSTANCE.l(c4978j.cameraProperties.getMetadata());
    }

    @Override // K.InterfaceC0898v
    public boolean B() {
        return androidx.camera.camera2.pipe.g.INSTANCE.g(this.cameraProperties.getMetadata());
    }

    public final C5645b I() {
        return (C5645b) this.camera2CameraInfo.getValue();
    }

    @Override // K.InterfaceC0898v
    /* renamed from: K, reason: merged with bridge method [inline-methods] */
    public CameraCharacteristics q() {
        Object objR0 = this.cameraProperties.getMetadata().R0(kotlin.jvm.internal.t.b(CameraCharacteristics.class));
        kotlin.jvm.internal.p.f(objR0);
        return (CameraCharacteristics) objR0;
    }

    public final int L(int lensFacingInt) {
        if (lensFacingInt == 0) {
            return 0;
        }
        if (lensFacingInt == 1) {
            return 1;
        }
        if (lensFacingInt == 2) {
            return 2;
        }
        C5473b c5473b = C5473b.f41865a;
        if (C0761b0.k("CXCP")) {
            Log.w(C5473b.TRUNCATED_TAG, "Unrecognized lens facing: " + lensFacingInt + '!');
        }
        return -1;
    }

    @Override // w.U
    public <T> T R0(InterfaceC5745d<T> type) {
        kotlin.jvm.internal.p.i(type, "type");
        if (kotlin.jvm.internal.p.d(type, kotlin.jvm.internal.t.b(C5645b.class))) {
            T t10 = (T) I();
            kotlin.jvm.internal.p.g(t10, "null cannot be cast to non-null type T of androidx.camera.camera2.adapter.CameraInfoAdapter.unwrapAs");
            return t10;
        }
        if (kotlin.jvm.internal.p.d(type, kotlin.jvm.internal.t.b(InterfaceC5494v.class))) {
            T t11 = (T) this.cameraProperties;
            kotlin.jvm.internal.p.g(t11, "null cannot be cast to non-null type T of androidx.camera.camera2.adapter.CameraInfoAdapter.unwrapAs");
            return t11;
        }
        if (!kotlin.jvm.internal.p.d(type, kotlin.jvm.internal.t.b(androidx.camera.camera2.pipe.g.class))) {
            return (T) this.cameraProperties.getMetadata().R0(type);
        }
        T t12 = (T) this.cameraProperties.getMetadata();
        kotlin.jvm.internal.p.g(t12, "null cannot be cast to non-null type T of androidx.camera.camera2.adapter.CameraInfoAdapter.unwrapAs");
        return t12;
    }

    @Override // K.InterfaceC0898v
    public Set<Integer> a() {
        Set<Integer> setI1;
        Integer[] numArrD = this.streamConfigurationMapCompat.d();
        return (numArrD == null || (setI1 = Z8.r.i1(numArrD)) == null) ? Z8.Y.e() : setI1;
    }

    @Override // K.InterfaceC0898v
    public Set<D.B> c() {
        return C5027i.INSTANCE.a(this.cameraProperties.getMetadata()).b();
    }

    @Override // D.InterfaceC0778o
    public int e() {
        return z(0);
    }

    @Override // K.InterfaceC0898v
    public String h() {
        return this.cameraConfig.getCameraId();
    }

    @Override // K.InterfaceC0898v
    public Rect j() {
        androidx.camera.camera2.pipe.g metadata = this.cameraProperties.getMetadata();
        CameraCharacteristics.Key SENSOR_INFO_ACTIVE_ARRAY_SIZE = CameraCharacteristics.SENSOR_INFO_ACTIVE_ARRAY_SIZE;
        kotlin.jvm.internal.p.h(SENSOR_INFO_ACTIVE_ARRAY_SIZE, "SENSOR_INFO_ACTIVE_ARRAY_SIZE");
        Rect rect = (Rect) metadata.e0(SENSOR_INFO_ACTIVE_ARRAY_SIZE);
        if (kotlin.jvm.internal.p.d("robolectric", Build.FINGERPRINT) && rect == null) {
            return new Rect(0, 0, 4000, 3000);
        }
        kotlin.jvm.internal.p.f(rect);
        return rect;
    }

    @Override // D.InterfaceC0778o
    public int k() {
        androidx.camera.camera2.pipe.g metadata = this.cameraProperties.getMetadata();
        CameraCharacteristics.Key LENS_FACING = CameraCharacteristics.LENS_FACING;
        kotlin.jvm.internal.p.h(LENS_FACING, "LENS_FACING");
        Object objE0 = metadata.e0(LENS_FACING);
        kotlin.jvm.internal.p.f(objE0);
        return L(((Number) objE0).intValue());
    }

    @Override // K.InterfaceC0898v
    public List<Size> o(int format) {
        List<Size> listT0;
        Size[] sizeArrA = this.streamConfigurationMapCompat.a(format);
        return (sizeArrA == null || (listT0 = Z8.r.T0(sizeArrA)) == null) ? C1173v.m() : listT0;
    }

    @Override // K.InterfaceC0898v
    public w0 s() {
        return this.cameraQuirks.b();
    }

    @Override // K.InterfaceC0898v
    public List<Size> t(int format) {
        List<Size> listT0;
        Size[] sizeArrF = this.streamConfigurationMapCompat.f(format);
        return (sizeArrF == null || (listT0 = Z8.r.T0(sizeArrF)) == null) ? C1173v.m() : listT0;
    }

    public String toString() {
        return "CameraInfoAdapter<" + this.cameraConfig + ".cameraId>";
    }

    @Override // K.InterfaceC0898v
    public Set<Integer> u() {
        Set<Integer> setH1;
        androidx.camera.camera2.pipe.g metadata = this.cameraProperties.getMetadata();
        CameraCharacteristics.Key REQUEST_AVAILABLE_CAPABILITIES = CameraCharacteristics.REQUEST_AVAILABLE_CAPABILITIES;
        kotlin.jvm.internal.p.h(REQUEST_AVAILABLE_CAPABILITIES, "REQUEST_AVAILABLE_CAPABILITIES");
        int[] iArr = (int[]) metadata.e0(REQUEST_AVAILABLE_CAPABILITIES);
        return (iArr == null || (setH1 = Z8.r.h1(iArr)) == null) ? Z8.Y.e() : setH1;
    }

    @Override // K.InterfaceC0898v
    public boolean v() {
        androidx.camera.camera2.pipe.g metadata = this.cameraProperties.getMetadata();
        CameraCharacteristics.Key CONTROL_AVAILABLE_VIDEO_STABILIZATION_MODES = CameraCharacteristics.CONTROL_AVAILABLE_VIDEO_STABILIZATION_MODES;
        kotlin.jvm.internal.p.h(CONTROL_AVAILABLE_VIDEO_STABILIZATION_MODES, "CONTROL_AVAILABLE_VIDEO_STABILIZATION_MODES");
        int[] iArr = (int[]) metadata.e0(CONTROL_AVAILABLE_VIDEO_STABILIZATION_MODES);
        return iArr != null && Z8.r.P(iArr, 1);
    }

    @Override // D.InterfaceC0778o
    public AbstractC1404w<CameraState> y() {
        return this.cameraStateAdapter.e();
    }

    @Override // D.InterfaceC0778o
    public int z(int relativeRotation) {
        androidx.camera.camera2.pipe.g metadata = this.cameraProperties.getMetadata();
        CameraCharacteristics.Key SENSOR_ORIENTATION = CameraCharacteristics.SENSOR_ORIENTATION;
        kotlin.jvm.internal.p.h(SENSOR_ORIENTATION, "SENSOR_ORIENTATION");
        Object objE0 = metadata.e0(SENSOR_ORIENTATION);
        kotlin.jvm.internal.p.f(objE0);
        return M.c.a(M.c.b(relativeRotation), ((Number) objE0).intValue(), 1 == k());
    }
}
