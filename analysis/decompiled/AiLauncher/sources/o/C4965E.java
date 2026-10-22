package o;

import K.B0;
import K.C0;
import Z8.C1173v;
import android.hardware.camera2.CameraCharacteristics;
import android.os.Build;
import android.util.Size;
import androidx.camera.core.impl.StreamUseCase;
import androidx.camera.core.impl.SurfaceConfig;
import androidx.camera.core.impl.stabilization.VideoStabilization;
import com.autonavi.aps.amapapi.config.Const;
import java.util.ArrayList;
import java.util.List;
import kotlin.C4848b;
import kotlin.Metadata;
import p9.InterfaceC5063a;

@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\f\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0007¢\u0006\u0004\b\u0006\u0010\u0007J\u0015\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0007¢\u0006\u0004\b\b\u0010\u0007J\u0015\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0007¢\u0006\u0004\b\t\u0010\u0007J\u0015\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0007¢\u0006\u0004\b\n\u0010\u0007J\u0015\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0007¢\u0006\u0004\b\u000b\u0010\u0007J\u0015\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0007¢\u0006\u0004\b\f\u0010\u0007J\u0015\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0007¢\u0006\u0004\b\r\u0010\u0007J\u0015\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0007¢\u0006\u0004\b\u000e\u0010\u0007J\u0015\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0007¢\u0006\u0004\b\u000f\u0010\u0007J-\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u0012H\u0007¢\u0006\u0004\b\u0015\u0010\u0016J\u0015\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0007¢\u0006\u0004\b\u0017\u0010\u0007J\u0015\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0007¢\u0006\u0004\b\u0018\u0010\u0007J%\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u001c\u001a\u00020\u001bH\u0007¢\u0006\u0004\b\u001d\u0010\u001eJ\u0015\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0007¢\u0006\u0004\b\u001f\u0010\u0007J%\u0010$\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010!\u001a\u00020 2\u0006\u0010#\u001a\u00020\"H\u0000¢\u0006\u0004\b$\u0010%J\u0015\u0010&\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0002¢\u0006\u0004\b&\u0010\u0007J\u0015\u0010'\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0002¢\u0006\u0004\b'\u0010\u0007J%\u0010+\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010)\u001a\u00020(2\u0006\u0010*\u001a\u00020(H\u0002¢\u0006\u0004\b+\u0010,R!\u00100\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b-\u0010.\u001a\u0004\b/\u0010\u0007R!\u00103\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b1\u0010.\u001a\u0004\b2\u0010\u0007¨\u00064"}, d2 = {"Lo/E;", "", "<init>", "()V", "", "LK/B0;", "n", "()Ljava/util/List;", "p", "m", "u", "k", "o", "x", "w", "l", "", "hardwareLevel", "", "isRawSupported", "isBurstCaptureSupported", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "(IZZ)Ljava/util/List;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_REMOVE, "q", "Landroid/util/Size;", "maxSupportedSize", "LK/C0;", "surfaceSizeDefinition", Const.INTENT_KEY_BACKGROUND_COMMAND, "(Landroid/util/Size;LK/C0;)Ljava/util/List;", "v", "Landroidx/camera/camera2/pipe/g;", "cameraMetadata", "Landroidx/camera/core/impl/stabilization/VideoStabilization;", "videoStabilization", "t", "(Landroidx/camera/camera2/pipe/g;Landroidx/camera/core/impl/stabilization/VideoStabilization;)Ljava/util/List;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "f", "Landroidx/camera/core/impl/SurfaceConfig$ConfigSize;", "privSize", "jpegXSize", "e", "(Landroidx/camera/core/impl/SurfaceConfig$ConfigSize;Landroidx/camera/core/impl/SurfaceConfig$ConfigSize;)Ljava/util/List;", Const.INTENT_KEY_PKGNAME, "LY8/h;", "s", "QUERYABLE_VIC_FCQ_COMBINATIONS", "c", "r", "QUERYABLE_BAKLAVA_FCQ_COMBINATIONS", "camera-camera2"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* renamed from: o.E, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C4965E {

    /* renamed from: a, reason: collision with root package name */
    public static final C4965E f37306a = new C4965E();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public static final Y8.h QUERYABLE_VIC_FCQ_COMBINATIONS = C4848b.b(new InterfaceC5063a() { // from class: o.C
        @Override // p9.InterfaceC5063a
        public final Object invoke() {
            return C4965E.d();
        }
    });

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    public static final Y8.h QUERYABLE_BAKLAVA_FCQ_COMBINATIONS = C4848b.b(new InterfaceC5063a() { // from class: o.D
        @Override // p9.InterfaceC5063a
        public final Object invoke() {
            return C4965E.c();
        }
    });

    public static final List c() {
        return f37306a.f();
    }

    public static final List d() {
        return f37306a.i();
    }

    public static final List<B0> g(Size maxSupportedSize, C0 surfaceSizeDefinition) {
        kotlin.jvm.internal.p.i(maxSupportedSize, "maxSupportedSize");
        kotlin.jvm.internal.p.i(surfaceSizeDefinition, "surfaceSizeDefinition");
        ArrayList arrayList = new ArrayList();
        SurfaceConfig surfaceConfigE = SurfaceConfig.Companion.e(SurfaceConfig.INSTANCE, 34, maxSupportedSize, surfaceSizeDefinition, 0, null, null, 56, null);
        B0 b02 = new B0();
        b02.a(surfaceConfigE);
        arrayList.add(b02);
        B0 b03 = new B0();
        b03.a(surfaceConfigE);
        b03.a(surfaceConfigE);
        arrayList.add(b03);
        return arrayList;
    }

    public static final List<B0> h(int hardwareLevel, boolean isRawSupported, boolean isBurstCaptureSupported) {
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(n());
        if (hardwareLevel == 0 || hardwareLevel == 1 || hardwareLevel == 3 || hardwareLevel == 4) {
            arrayList.addAll(p());
        }
        if (hardwareLevel == 1 || hardwareLevel == 3) {
            arrayList.addAll(m());
        }
        if (isRawSupported) {
            arrayList.addAll(u());
        }
        if (isBurstCaptureSupported && hardwareLevel == 0) {
            arrayList.addAll(k());
        }
        if (hardwareLevel == 3) {
            arrayList.addAll(o());
        }
        return arrayList;
    }

    public static final List<B0> j() {
        B0 b02 = new B0();
        SurfaceConfig.Companion companion = SurfaceConfig.INSTANCE;
        SurfaceConfig.ConfigType configType = SurfaceConfig.ConfigType.PRIV;
        SurfaceConfig.ConfigSize configSize = SurfaceConfig.ConfigSize.MAXIMUM;
        b02.a(SurfaceConfig.Companion.b(companion, configType, configSize, null, 4, null));
        Y8.t tVar = Y8.t.f7040a;
        B0 b03 = new B0();
        SurfaceConfig.ConfigType configType2 = SurfaceConfig.ConfigType.YUV;
        b03.a(SurfaceConfig.Companion.b(companion, configType2, configSize, null, 4, null));
        B0 b04 = new B0();
        SurfaceConfig.ConfigSize configSize2 = SurfaceConfig.ConfigSize.PREVIEW;
        b04.a(SurfaceConfig.Companion.b(companion, configType, configSize2, null, 4, null));
        SurfaceConfig.ConfigType configType3 = SurfaceConfig.ConfigType.JPEG;
        b04.a(SurfaceConfig.Companion.b(companion, configType3, configSize, null, 4, null));
        B0 b05 = new B0();
        b05.a(SurfaceConfig.Companion.b(companion, configType, configSize2, null, 4, null));
        b05.a(SurfaceConfig.Companion.b(companion, configType2, configSize, null, 4, null));
        B0 b06 = new B0();
        b06.a(SurfaceConfig.Companion.b(companion, configType2, configSize2, null, 4, null));
        b06.a(SurfaceConfig.Companion.b(companion, configType2, configSize, null, 4, null));
        B0 b07 = new B0();
        b07.a(SurfaceConfig.Companion.b(companion, configType, configSize2, null, 4, null));
        SurfaceConfig.ConfigSize configSize3 = SurfaceConfig.ConfigSize.RECORD;
        b07.a(SurfaceConfig.Companion.b(companion, configType, configSize3, null, 4, null));
        B0 b08 = new B0();
        b08.a(SurfaceConfig.Companion.b(companion, configType, configSize2, null, 4, null));
        b08.a(SurfaceConfig.Companion.b(companion, configType, configSize3, null, 4, null));
        b08.a(SurfaceConfig.Companion.b(companion, configType2, configSize3, null, 4, null));
        B0 b09 = new B0();
        b09.a(SurfaceConfig.Companion.b(companion, configType, configSize2, null, 4, null));
        b09.a(SurfaceConfig.Companion.b(companion, configType, configSize3, null, 4, null));
        b09.a(SurfaceConfig.Companion.b(companion, configType3, configSize3, null, 4, null));
        return C1173v.p(b02, b03, b04, b05, b06, b07, b08, b09);
    }

    public static final List<B0> k() {
        ArrayList arrayList = new ArrayList();
        B0 b02 = new B0();
        SurfaceConfig.Companion companion = SurfaceConfig.INSTANCE;
        SurfaceConfig.ConfigType configType = SurfaceConfig.ConfigType.PRIV;
        SurfaceConfig.ConfigSize configSize = SurfaceConfig.ConfigSize.PREVIEW;
        b02.a(SurfaceConfig.Companion.b(companion, configType, configSize, null, 4, null));
        SurfaceConfig.ConfigSize configSize2 = SurfaceConfig.ConfigSize.MAXIMUM;
        b02.a(SurfaceConfig.Companion.b(companion, configType, configSize2, null, 4, null));
        arrayList.add(b02);
        B0 b03 = new B0();
        b03.a(SurfaceConfig.Companion.b(companion, configType, configSize, null, 4, null));
        SurfaceConfig.ConfigType configType2 = SurfaceConfig.ConfigType.YUV;
        b03.a(SurfaceConfig.Companion.b(companion, configType2, configSize2, null, 4, null));
        arrayList.add(b03);
        B0 b04 = new B0();
        b04.a(SurfaceConfig.Companion.b(companion, configType2, configSize, null, 4, null));
        b04.a(SurfaceConfig.Companion.b(companion, configType2, configSize2, null, 4, null));
        arrayList.add(b04);
        return arrayList;
    }

    public static final List<B0> l() {
        ArrayList arrayList = new ArrayList();
        B0 b02 = new B0();
        SurfaceConfig.Companion companion = SurfaceConfig.INSTANCE;
        SurfaceConfig.ConfigType configType = SurfaceConfig.ConfigType.YUV;
        SurfaceConfig.ConfigSize configSize = SurfaceConfig.ConfigSize.S1440P_4_3;
        b02.a(SurfaceConfig.Companion.b(companion, configType, configSize, null, 4, null));
        arrayList.add(b02);
        B0 b03 = new B0();
        SurfaceConfig.ConfigType configType2 = SurfaceConfig.ConfigType.PRIV;
        b03.a(SurfaceConfig.Companion.b(companion, configType2, configSize, null, 4, null));
        arrayList.add(b03);
        B0 b04 = new B0();
        SurfaceConfig.ConfigType configType3 = SurfaceConfig.ConfigType.JPEG;
        b04.a(SurfaceConfig.Companion.b(companion, configType3, configSize, null, 4, null));
        arrayList.add(b04);
        B0 b05 = new B0();
        SurfaceConfig.ConfigSize configSize2 = SurfaceConfig.ConfigSize.S720P_16_9;
        b05.a(SurfaceConfig.Companion.b(companion, configType, configSize2, null, 4, null));
        b05.a(SurfaceConfig.Companion.b(companion, configType3, configSize, null, 4, null));
        arrayList.add(b05);
        B0 b06 = new B0();
        b06.a(SurfaceConfig.Companion.b(companion, configType2, configSize2, null, 4, null));
        b06.a(SurfaceConfig.Companion.b(companion, configType3, configSize, null, 4, null));
        arrayList.add(b06);
        B0 b07 = new B0();
        b07.a(SurfaceConfig.Companion.b(companion, configType, configSize2, null, 4, null));
        b07.a(SurfaceConfig.Companion.b(companion, configType, configSize, null, 4, null));
        arrayList.add(b07);
        B0 b08 = new B0();
        b08.a(SurfaceConfig.Companion.b(companion, configType, configSize2, null, 4, null));
        b08.a(SurfaceConfig.Companion.b(companion, configType2, configSize, null, 4, null));
        arrayList.add(b08);
        B0 b09 = new B0();
        b09.a(SurfaceConfig.Companion.b(companion, configType2, configSize2, null, 4, null));
        b09.a(SurfaceConfig.Companion.b(companion, configType, configSize, null, 4, null));
        arrayList.add(b09);
        B0 b010 = new B0();
        b010.a(SurfaceConfig.Companion.b(companion, configType2, configSize2, null, 4, null));
        b010.a(SurfaceConfig.Companion.b(companion, configType2, configSize, null, 4, null));
        arrayList.add(b010);
        return arrayList;
    }

    public static final List<B0> m() {
        ArrayList arrayList = new ArrayList();
        B0 b02 = new B0();
        SurfaceConfig.Companion companion = SurfaceConfig.INSTANCE;
        SurfaceConfig.ConfigType configType = SurfaceConfig.ConfigType.PRIV;
        SurfaceConfig.ConfigSize configSize = SurfaceConfig.ConfigSize.PREVIEW;
        b02.a(SurfaceConfig.Companion.b(companion, configType, configSize, null, 4, null));
        SurfaceConfig.ConfigSize configSize2 = SurfaceConfig.ConfigSize.MAXIMUM;
        b02.a(SurfaceConfig.Companion.b(companion, configType, configSize2, null, 4, null));
        arrayList.add(b02);
        B0 b03 = new B0();
        b03.a(SurfaceConfig.Companion.b(companion, configType, configSize, null, 4, null));
        SurfaceConfig.ConfigType configType2 = SurfaceConfig.ConfigType.YUV;
        b03.a(SurfaceConfig.Companion.b(companion, configType2, configSize2, null, 4, null));
        arrayList.add(b03);
        B0 b04 = new B0();
        b04.a(SurfaceConfig.Companion.b(companion, configType2, configSize, null, 4, null));
        b04.a(SurfaceConfig.Companion.b(companion, configType2, configSize2, null, 4, null));
        arrayList.add(b04);
        B0 b05 = new B0();
        b05.a(SurfaceConfig.Companion.b(companion, configType, configSize, null, 4, null));
        b05.a(SurfaceConfig.Companion.b(companion, configType, configSize, null, 4, null));
        b05.a(SurfaceConfig.Companion.b(companion, SurfaceConfig.ConfigType.JPEG, configSize2, null, 4, null));
        arrayList.add(b05);
        B0 b06 = new B0();
        SurfaceConfig.ConfigSize configSize3 = SurfaceConfig.ConfigSize.VGA;
        b06.a(SurfaceConfig.Companion.b(companion, configType2, configSize3, null, 4, null));
        b06.a(SurfaceConfig.Companion.b(companion, configType, configSize, null, 4, null));
        b06.a(SurfaceConfig.Companion.b(companion, configType2, configSize2, null, 4, null));
        arrayList.add(b06);
        B0 b07 = new B0();
        b07.a(SurfaceConfig.Companion.b(companion, configType2, configSize3, null, 4, null));
        b07.a(SurfaceConfig.Companion.b(companion, configType2, configSize, null, 4, null));
        b07.a(SurfaceConfig.Companion.b(companion, configType2, configSize2, null, 4, null));
        arrayList.add(b07);
        return arrayList;
    }

    public static final List<B0> n() {
        ArrayList arrayList = new ArrayList();
        B0 b02 = new B0();
        SurfaceConfig.Companion companion = SurfaceConfig.INSTANCE;
        SurfaceConfig.ConfigType configType = SurfaceConfig.ConfigType.PRIV;
        SurfaceConfig.ConfigSize configSize = SurfaceConfig.ConfigSize.MAXIMUM;
        b02.a(SurfaceConfig.Companion.b(companion, configType, configSize, null, 4, null));
        arrayList.add(b02);
        B0 b03 = new B0();
        SurfaceConfig.ConfigType configType2 = SurfaceConfig.ConfigType.JPEG;
        b03.a(SurfaceConfig.Companion.b(companion, configType2, configSize, null, 4, null));
        arrayList.add(b03);
        B0 b04 = new B0();
        SurfaceConfig.ConfigType configType3 = SurfaceConfig.ConfigType.YUV;
        b04.a(SurfaceConfig.Companion.b(companion, configType3, configSize, null, 4, null));
        arrayList.add(b04);
        B0 b05 = new B0();
        SurfaceConfig.ConfigSize configSize2 = SurfaceConfig.ConfigSize.PREVIEW;
        b05.a(SurfaceConfig.Companion.b(companion, configType, configSize2, null, 4, null));
        b05.a(SurfaceConfig.Companion.b(companion, configType2, configSize, null, 4, null));
        arrayList.add(b05);
        B0 b06 = new B0();
        b06.a(SurfaceConfig.Companion.b(companion, configType3, configSize2, null, 4, null));
        b06.a(SurfaceConfig.Companion.b(companion, configType2, configSize, null, 4, null));
        arrayList.add(b06);
        B0 b07 = new B0();
        b07.a(SurfaceConfig.Companion.b(companion, configType, configSize2, null, 4, null));
        b07.a(SurfaceConfig.Companion.b(companion, configType, configSize2, null, 4, null));
        arrayList.add(b07);
        B0 b08 = new B0();
        b08.a(SurfaceConfig.Companion.b(companion, configType, configSize2, null, 4, null));
        b08.a(SurfaceConfig.Companion.b(companion, configType3, configSize2, null, 4, null));
        arrayList.add(b08);
        B0 b09 = new B0();
        b09.a(SurfaceConfig.Companion.b(companion, configType, configSize2, null, 4, null));
        b09.a(SurfaceConfig.Companion.b(companion, configType3, configSize2, null, 4, null));
        b09.a(SurfaceConfig.Companion.b(companion, configType2, configSize, null, 4, null));
        arrayList.add(b09);
        return arrayList;
    }

    public static final List<B0> o() {
        ArrayList arrayList = new ArrayList();
        B0 b02 = new B0();
        SurfaceConfig.Companion companion = SurfaceConfig.INSTANCE;
        SurfaceConfig.ConfigType configType = SurfaceConfig.ConfigType.PRIV;
        SurfaceConfig.ConfigSize configSize = SurfaceConfig.ConfigSize.PREVIEW;
        b02.a(SurfaceConfig.Companion.b(companion, configType, configSize, null, 4, null));
        SurfaceConfig.ConfigSize configSize2 = SurfaceConfig.ConfigSize.VGA;
        b02.a(SurfaceConfig.Companion.b(companion, configType, configSize2, null, 4, null));
        SurfaceConfig.ConfigType configType2 = SurfaceConfig.ConfigType.YUV;
        SurfaceConfig.ConfigSize configSize3 = SurfaceConfig.ConfigSize.MAXIMUM;
        b02.a(SurfaceConfig.Companion.b(companion, configType2, configSize3, null, 4, null));
        SurfaceConfig.ConfigType configType3 = SurfaceConfig.ConfigType.RAW;
        b02.a(SurfaceConfig.Companion.b(companion, configType3, configSize3, null, 4, null));
        arrayList.add(b02);
        B0 b03 = new B0();
        b03.a(SurfaceConfig.Companion.b(companion, configType, configSize, null, 4, null));
        b03.a(SurfaceConfig.Companion.b(companion, configType, configSize2, null, 4, null));
        b03.a(SurfaceConfig.Companion.b(companion, SurfaceConfig.ConfigType.JPEG, configSize3, null, 4, null));
        b03.a(SurfaceConfig.Companion.b(companion, configType3, configSize3, null, 4, null));
        arrayList.add(b03);
        return arrayList;
    }

    public static final List<B0> p() {
        ArrayList arrayList = new ArrayList();
        B0 b02 = new B0();
        SurfaceConfig.Companion companion = SurfaceConfig.INSTANCE;
        SurfaceConfig.ConfigType configType = SurfaceConfig.ConfigType.PRIV;
        SurfaceConfig.ConfigSize configSize = SurfaceConfig.ConfigSize.PREVIEW;
        b02.a(SurfaceConfig.Companion.b(companion, configType, configSize, null, 4, null));
        SurfaceConfig.ConfigSize configSize2 = SurfaceConfig.ConfigSize.RECORD;
        b02.a(SurfaceConfig.Companion.b(companion, configType, configSize2, null, 4, null));
        arrayList.add(b02);
        B0 b03 = new B0();
        b03.a(SurfaceConfig.Companion.b(companion, configType, configSize, null, 4, null));
        SurfaceConfig.ConfigType configType2 = SurfaceConfig.ConfigType.YUV;
        b03.a(SurfaceConfig.Companion.b(companion, configType2, configSize2, null, 4, null));
        arrayList.add(b03);
        B0 b04 = new B0();
        b04.a(SurfaceConfig.Companion.b(companion, configType2, configSize, null, 4, null));
        b04.a(SurfaceConfig.Companion.b(companion, configType2, configSize2, null, 4, null));
        arrayList.add(b04);
        B0 b05 = new B0();
        b05.a(SurfaceConfig.Companion.b(companion, configType, configSize, null, 4, null));
        b05.a(SurfaceConfig.Companion.b(companion, configType, configSize2, null, 4, null));
        SurfaceConfig.ConfigType configType3 = SurfaceConfig.ConfigType.JPEG;
        b05.a(SurfaceConfig.Companion.b(companion, configType3, configSize2, null, 4, null));
        arrayList.add(b05);
        B0 b06 = new B0();
        b06.a(SurfaceConfig.Companion.b(companion, configType, configSize, null, 4, null));
        b06.a(SurfaceConfig.Companion.b(companion, configType2, configSize2, null, 4, null));
        b06.a(SurfaceConfig.Companion.b(companion, configType3, configSize2, null, 4, null));
        arrayList.add(b06);
        B0 b07 = new B0();
        b07.a(SurfaceConfig.Companion.b(companion, configType2, configSize, null, 4, null));
        b07.a(SurfaceConfig.Companion.b(companion, configType2, configSize, null, 4, null));
        b07.a(SurfaceConfig.Companion.b(companion, configType3, SurfaceConfig.ConfigSize.MAXIMUM, null, 4, null));
        arrayList.add(b07);
        return arrayList;
    }

    public static final List<B0> q() {
        ArrayList arrayList = new ArrayList();
        B0 b02 = new B0();
        SurfaceConfig.Companion companion = SurfaceConfig.INSTANCE;
        SurfaceConfig.ConfigType configType = SurfaceConfig.ConfigType.PRIV;
        SurfaceConfig.ConfigSize configSize = SurfaceConfig.ConfigSize.S1440P_4_3;
        b02.a(SurfaceConfig.Companion.b(companion, configType, configSize, null, 4, null));
        arrayList.add(b02);
        B0 b03 = new B0();
        SurfaceConfig.ConfigType configType2 = SurfaceConfig.ConfigType.YUV;
        b03.a(SurfaceConfig.Companion.b(companion, configType2, configSize, null, 4, null));
        arrayList.add(b03);
        B0 b04 = new B0();
        b04.a(SurfaceConfig.Companion.b(companion, configType, configSize, null, 4, null));
        SurfaceConfig.ConfigType configType3 = SurfaceConfig.ConfigType.JPEG;
        SurfaceConfig.ConfigSize configSize2 = SurfaceConfig.ConfigSize.MAXIMUM;
        b04.a(SurfaceConfig.Companion.b(companion, configType3, configSize2, null, 4, null));
        arrayList.add(b04);
        B0 b05 = new B0();
        b05.a(SurfaceConfig.Companion.b(companion, configType2, configSize, null, 4, null));
        b05.a(SurfaceConfig.Companion.b(companion, configType3, configSize2, null, 4, null));
        arrayList.add(b05);
        B0 b06 = new B0();
        b06.a(SurfaceConfig.Companion.b(companion, configType, configSize, null, 4, null));
        b06.a(SurfaceConfig.Companion.b(companion, configType2, configSize2, null, 4, null));
        arrayList.add(b06);
        B0 b07 = new B0();
        b07.a(SurfaceConfig.Companion.b(companion, configType2, configSize, null, 4, null));
        b07.a(SurfaceConfig.Companion.b(companion, configType2, configSize2, null, 4, null));
        arrayList.add(b07);
        B0 b08 = new B0();
        SurfaceConfig.ConfigSize configSize3 = SurfaceConfig.ConfigSize.PREVIEW;
        b08.a(SurfaceConfig.Companion.b(companion, configType, configSize3, null, 4, null));
        b08.a(SurfaceConfig.Companion.b(companion, configType, configSize, null, 4, null));
        arrayList.add(b08);
        B0 b09 = new B0();
        b09.a(SurfaceConfig.Companion.b(companion, configType2, configSize3, null, 4, null));
        b09.a(SurfaceConfig.Companion.b(companion, configType, configSize, null, 4, null));
        arrayList.add(b09);
        B0 b010 = new B0();
        b010.a(SurfaceConfig.Companion.b(companion, configType, configSize3, null, 4, null));
        b010.a(SurfaceConfig.Companion.b(companion, configType2, configSize, null, 4, null));
        arrayList.add(b010);
        B0 b011 = new B0();
        b011.a(SurfaceConfig.Companion.b(companion, configType2, configSize3, null, 4, null));
        b011.a(SurfaceConfig.Companion.b(companion, configType2, configSize, null, 4, null));
        arrayList.add(b011);
        return arrayList;
    }

    public static final List<B0> u() {
        ArrayList arrayList = new ArrayList();
        B0 b02 = new B0();
        SurfaceConfig.Companion companion = SurfaceConfig.INSTANCE;
        SurfaceConfig.ConfigType configType = SurfaceConfig.ConfigType.RAW;
        SurfaceConfig.ConfigSize configSize = SurfaceConfig.ConfigSize.MAXIMUM;
        b02.a(SurfaceConfig.Companion.b(companion, configType, configSize, null, 4, null));
        arrayList.add(b02);
        B0 b03 = new B0();
        SurfaceConfig.ConfigType configType2 = SurfaceConfig.ConfigType.PRIV;
        SurfaceConfig.ConfigSize configSize2 = SurfaceConfig.ConfigSize.PREVIEW;
        b03.a(SurfaceConfig.Companion.b(companion, configType2, configSize2, null, 4, null));
        b03.a(SurfaceConfig.Companion.b(companion, configType, configSize, null, 4, null));
        arrayList.add(b03);
        B0 b04 = new B0();
        SurfaceConfig.ConfigType configType3 = SurfaceConfig.ConfigType.YUV;
        b04.a(SurfaceConfig.Companion.b(companion, configType3, configSize2, null, 4, null));
        b04.a(SurfaceConfig.Companion.b(companion, configType, configSize, null, 4, null));
        arrayList.add(b04);
        B0 b05 = new B0();
        b05.a(SurfaceConfig.Companion.b(companion, configType2, configSize2, null, 4, null));
        b05.a(SurfaceConfig.Companion.b(companion, configType2, configSize2, null, 4, null));
        b05.a(SurfaceConfig.Companion.b(companion, configType, configSize, null, 4, null));
        arrayList.add(b05);
        B0 b06 = new B0();
        b06.a(SurfaceConfig.Companion.b(companion, configType2, configSize2, null, 4, null));
        b06.a(SurfaceConfig.Companion.b(companion, configType3, configSize2, null, 4, null));
        b06.a(SurfaceConfig.Companion.b(companion, configType, configSize, null, 4, null));
        arrayList.add(b06);
        B0 b07 = new B0();
        b07.a(SurfaceConfig.Companion.b(companion, configType3, configSize2, null, 4, null));
        b07.a(SurfaceConfig.Companion.b(companion, configType3, configSize2, null, 4, null));
        b07.a(SurfaceConfig.Companion.b(companion, configType, configSize, null, 4, null));
        arrayList.add(b07);
        B0 b08 = new B0();
        b08.a(SurfaceConfig.Companion.b(companion, configType2, configSize2, null, 4, null));
        SurfaceConfig.ConfigType configType4 = SurfaceConfig.ConfigType.JPEG;
        b08.a(SurfaceConfig.Companion.b(companion, configType4, configSize, null, 4, null));
        b08.a(SurfaceConfig.Companion.b(companion, configType, configSize, null, 4, null));
        arrayList.add(b08);
        B0 b09 = new B0();
        b09.a(SurfaceConfig.Companion.b(companion, configType3, configSize2, null, 4, null));
        b09.a(SurfaceConfig.Companion.b(companion, configType4, configSize, null, 4, null));
        b09.a(SurfaceConfig.Companion.b(companion, configType, configSize, null, 4, null));
        arrayList.add(b09);
        return arrayList;
    }

    public static final List<B0> w() {
        ArrayList arrayList = new ArrayList();
        B0 b02 = new B0();
        SurfaceConfig.Companion companion = SurfaceConfig.INSTANCE;
        SurfaceConfig.ConfigType configType = SurfaceConfig.ConfigType.JPEG_R;
        SurfaceConfig.ConfigSize configSize = SurfaceConfig.ConfigSize.MAXIMUM;
        b02.a(SurfaceConfig.Companion.b(companion, configType, configSize, null, 4, null));
        arrayList.add(b02);
        B0 b03 = new B0();
        b03.a(SurfaceConfig.Companion.b(companion, SurfaceConfig.ConfigType.PRIV, SurfaceConfig.ConfigSize.PREVIEW, null, 4, null));
        b03.a(SurfaceConfig.Companion.b(companion, configType, configSize, null, 4, null));
        arrayList.add(b03);
        return arrayList;
    }

    public static final List<B0> x() {
        ArrayList arrayList = new ArrayList();
        B0 b02 = new B0();
        SurfaceConfig.Companion companion = SurfaceConfig.INSTANCE;
        SurfaceConfig.ConfigType configType = SurfaceConfig.ConfigType.YUV;
        SurfaceConfig.ConfigSize configSize = SurfaceConfig.ConfigSize.ULTRA_MAXIMUM;
        b02.a(SurfaceConfig.Companion.b(companion, configType, configSize, null, 4, null));
        SurfaceConfig.ConfigType configType2 = SurfaceConfig.ConfigType.PRIV;
        SurfaceConfig.ConfigSize configSize2 = SurfaceConfig.ConfigSize.PREVIEW;
        b02.a(SurfaceConfig.Companion.b(companion, configType2, configSize2, null, 4, null));
        SurfaceConfig.ConfigSize configSize3 = SurfaceConfig.ConfigSize.RECORD;
        b02.a(SurfaceConfig.Companion.b(companion, configType2, configSize3, null, 4, null));
        arrayList.add(b02);
        B0 b03 = new B0();
        SurfaceConfig.ConfigType configType3 = SurfaceConfig.ConfigType.JPEG;
        b03.a(SurfaceConfig.Companion.b(companion, configType3, configSize, null, 4, null));
        b03.a(SurfaceConfig.Companion.b(companion, configType2, configSize2, null, 4, null));
        b03.a(SurfaceConfig.Companion.b(companion, configType2, configSize3, null, 4, null));
        arrayList.add(b03);
        B0 b04 = new B0();
        SurfaceConfig.ConfigType configType4 = SurfaceConfig.ConfigType.RAW;
        b04.a(SurfaceConfig.Companion.b(companion, configType4, configSize, null, 4, null));
        b04.a(SurfaceConfig.Companion.b(companion, configType2, configSize2, null, 4, null));
        b04.a(SurfaceConfig.Companion.b(companion, configType2, configSize3, null, 4, null));
        arrayList.add(b04);
        B0 b05 = new B0();
        b05.a(SurfaceConfig.Companion.b(companion, configType, configSize, null, 4, null));
        b05.a(SurfaceConfig.Companion.b(companion, configType2, configSize2, null, 4, null));
        SurfaceConfig.ConfigSize configSize4 = SurfaceConfig.ConfigSize.MAXIMUM;
        b05.a(SurfaceConfig.Companion.b(companion, configType3, configSize4, null, 4, null));
        arrayList.add(b05);
        B0 b06 = new B0();
        b06.a(SurfaceConfig.Companion.b(companion, configType3, configSize, null, 4, null));
        b06.a(SurfaceConfig.Companion.b(companion, configType2, configSize2, null, 4, null));
        b06.a(SurfaceConfig.Companion.b(companion, configType3, configSize4, null, 4, null));
        arrayList.add(b06);
        B0 b07 = new B0();
        b07.a(SurfaceConfig.Companion.b(companion, configType4, configSize, null, 4, null));
        b07.a(SurfaceConfig.Companion.b(companion, configType2, configSize2, null, 4, null));
        b07.a(SurfaceConfig.Companion.b(companion, configType3, configSize4, null, 4, null));
        arrayList.add(b07);
        B0 b08 = new B0();
        b08.a(SurfaceConfig.Companion.b(companion, configType, configSize, null, 4, null));
        b08.a(SurfaceConfig.Companion.b(companion, configType2, configSize2, null, 4, null));
        b08.a(SurfaceConfig.Companion.b(companion, configType, configSize4, null, 4, null));
        arrayList.add(b08);
        B0 b09 = new B0();
        b09.a(SurfaceConfig.Companion.b(companion, configType3, configSize, null, 4, null));
        b09.a(SurfaceConfig.Companion.b(companion, configType2, configSize2, null, 4, null));
        b09.a(SurfaceConfig.Companion.b(companion, configType, configSize4, null, 4, null));
        arrayList.add(b09);
        B0 b010 = new B0();
        b010.a(SurfaceConfig.Companion.b(companion, configType4, configSize, null, 4, null));
        b010.a(SurfaceConfig.Companion.b(companion, configType2, configSize2, null, 4, null));
        b010.a(SurfaceConfig.Companion.b(companion, configType, configSize4, null, 4, null));
        arrayList.add(b010);
        B0 b011 = new B0();
        b011.a(SurfaceConfig.Companion.b(companion, configType, configSize, null, 4, null));
        b011.a(SurfaceConfig.Companion.b(companion, configType2, configSize2, null, 4, null));
        b011.a(SurfaceConfig.Companion.b(companion, configType4, configSize4, null, 4, null));
        arrayList.add(b011);
        B0 b012 = new B0();
        b012.a(SurfaceConfig.Companion.b(companion, configType3, configSize, null, 4, null));
        b012.a(SurfaceConfig.Companion.b(companion, configType2, configSize2, null, 4, null));
        b012.a(SurfaceConfig.Companion.b(companion, configType4, configSize4, null, 4, null));
        arrayList.add(b012);
        B0 b013 = new B0();
        b013.a(SurfaceConfig.Companion.b(companion, configType4, configSize, null, 4, null));
        b013.a(SurfaceConfig.Companion.b(companion, configType2, configSize2, null, 4, null));
        b013.a(SurfaceConfig.Companion.b(companion, configType4, configSize4, null, 4, null));
        arrayList.add(b013);
        return arrayList;
    }

    public final List<B0> e(SurfaceConfig.ConfigSize privSize, SurfaceConfig.ConfigSize jpegXSize) {
        ArrayList arrayList = new ArrayList();
        B0 b02 = new B0();
        SurfaceConfig.Companion companion = SurfaceConfig.INSTANCE;
        SurfaceConfig.ConfigType configType = SurfaceConfig.ConfigType.PRIV;
        b02.a(SurfaceConfig.Companion.b(companion, configType, privSize, null, 4, null));
        b02.a(SurfaceConfig.Companion.b(companion, SurfaceConfig.ConfigType.JPEG, jpegXSize, null, 4, null));
        arrayList.add(b02);
        B0 b03 = new B0();
        b03.a(SurfaceConfig.Companion.b(companion, configType, privSize, null, 4, null));
        b03.a(SurfaceConfig.Companion.b(companion, SurfaceConfig.ConfigType.JPEG_R, jpegXSize, null, 4, null));
        arrayList.add(b03);
        return arrayList;
    }

    public final List<B0> f() {
        ArrayList arrayList = new ArrayList();
        B0 b02 = new B0();
        SurfaceConfig.Companion companion = SurfaceConfig.INSTANCE;
        SurfaceConfig.ConfigType configType = SurfaceConfig.ConfigType.PRIV;
        SurfaceConfig.ConfigSize configSize = SurfaceConfig.ConfigSize.S1080P_16_9;
        b02.a(SurfaceConfig.Companion.b(companion, configType, configSize, null, 4, null));
        b02.a(SurfaceConfig.Companion.b(companion, configType, configSize, null, 4, null));
        arrayList.add(b02);
        B0 b03 = new B0();
        b03.a(SurfaceConfig.Companion.b(companion, configType, configSize, null, 4, null));
        b03.a(SurfaceConfig.Companion.b(companion, configType, SurfaceConfig.ConfigSize.S1440P_16_9, null, 4, null));
        arrayList.add(b03);
        B0 b04 = new B0();
        b04.a(SurfaceConfig.Companion.b(companion, configType, configSize, null, 4, null));
        b04.a(SurfaceConfig.Companion.b(companion, configType, SurfaceConfig.ConfigSize.UHD, null, 4, null));
        arrayList.add(b04);
        B0 b05 = new B0();
        b05.a(SurfaceConfig.Companion.b(companion, configType, configSize, null, 4, null));
        b05.a(SurfaceConfig.Companion.b(companion, SurfaceConfig.ConfigType.YUV, configSize, null, 4, null));
        b05.a(SurfaceConfig.Companion.b(companion, configType, configSize, null, 4, null));
        arrayList.add(b05);
        return arrayList;
    }

    public final List<B0> i() {
        ArrayList arrayList = new ArrayList();
        B0 b02 = new B0();
        SurfaceConfig.Companion companion = SurfaceConfig.INSTANCE;
        SurfaceConfig.ConfigType configType = SurfaceConfig.ConfigType.PRIV;
        SurfaceConfig.ConfigSize configSize = SurfaceConfig.ConfigSize.S1080P_16_9;
        b02.a(SurfaceConfig.Companion.b(companion, configType, configSize, null, 4, null));
        arrayList.add(b02);
        B0 b03 = new B0();
        SurfaceConfig.ConfigSize configSize2 = SurfaceConfig.ConfigSize.S720P_16_9;
        b03.a(SurfaceConfig.Companion.b(companion, configType, configSize2, null, 4, null));
        arrayList.add(b03);
        SurfaceConfig.ConfigSize configSize3 = SurfaceConfig.ConfigSize.MAXIMUM_16_9;
        arrayList.addAll(e(configSize, configSize3));
        SurfaceConfig.ConfigSize configSize4 = SurfaceConfig.ConfigSize.UHD;
        arrayList.addAll(e(configSize, configSize4));
        arrayList.addAll(e(configSize, SurfaceConfig.ConfigSize.S1440P_16_9));
        arrayList.addAll(e(configSize, configSize));
        arrayList.addAll(e(configSize2, configSize3));
        arrayList.addAll(e(configSize2, configSize4));
        arrayList.addAll(e(configSize2, configSize));
        SurfaceConfig.ConfigSize configSize5 = SurfaceConfig.ConfigSize.X_VGA;
        SurfaceConfig.ConfigSize configSize6 = SurfaceConfig.ConfigSize.MAXIMUM_4_3;
        arrayList.addAll(e(configSize5, configSize6));
        arrayList.addAll(e(SurfaceConfig.ConfigSize.S1080P_4_3, configSize6));
        return arrayList;
    }

    public final List<B0> r() {
        return (List) QUERYABLE_BAKLAVA_FCQ_COMBINATIONS.getValue();
    }

    public final List<B0> s() {
        return (List) QUERYABLE_VIC_FCQ_COMBINATIONS.getValue();
    }

    public final List<B0> t(androidx.camera.camera2.pipe.g cameraMetadata, VideoStabilization videoStabilization) {
        kotlin.jvm.internal.p.i(cameraMetadata, "cameraMetadata");
        kotlin.jvm.internal.p.i(videoStabilization, "videoStabilization");
        ArrayList arrayList = new ArrayList();
        if (Build.VERSION.SDK_INT >= 35) {
            CameraCharacteristics.Key INFO_SESSION_CONFIGURATION_QUERY_VERSION = CameraCharacteristics.INFO_SESSION_CONFIGURATION_QUERY_VERSION;
            kotlin.jvm.internal.p.h(INFO_SESSION_CONFIGURATION_QUERY_VERSION, "INFO_SESSION_CONFIGURATION_QUERY_VERSION");
            Object objE0 = cameraMetadata.e0(INFO_SESSION_CONFIGURATION_QUERY_VERSION);
            if (objE0 == null) {
                throw new IllegalArgumentException("Required value was null.");
            }
            int iIntValue = ((Number) objE0).intValue();
            if (iIntValue >= 35 && videoStabilization != VideoStabilization.ON) {
                arrayList.addAll(s());
            }
            if (iIntValue >= 36 && videoStabilization != VideoStabilization.PREVIEW) {
                arrayList.addAll(r());
                return arrayList;
            }
        }
        return arrayList;
    }

    public final List<B0> v() {
        B0 b02 = new B0();
        SurfaceConfig.Companion companion = SurfaceConfig.INSTANCE;
        SurfaceConfig.ConfigType configType = SurfaceConfig.ConfigType.PRIV;
        SurfaceConfig.ConfigSize configSize = SurfaceConfig.ConfigSize.S1440P_4_3;
        StreamUseCase streamUseCase = StreamUseCase.PREVIEW_VIDEO_STILL;
        b02.a(companion.a(configType, configSize, streamUseCase));
        Y8.t tVar = Y8.t.f7040a;
        B0 b03 = new B0();
        SurfaceConfig.ConfigType configType2 = SurfaceConfig.ConfigType.YUV;
        b03.a(companion.a(configType2, configSize, streamUseCase));
        B0 b04 = new B0();
        SurfaceConfig.ConfigSize configSize2 = SurfaceConfig.ConfigSize.RECORD;
        StreamUseCase streamUseCase2 = StreamUseCase.VIDEO_RECORD;
        b04.a(companion.a(configType, configSize2, streamUseCase2));
        B0 b05 = new B0();
        b05.a(companion.a(configType2, configSize2, streamUseCase2));
        B0 b06 = new B0();
        SurfaceConfig.ConfigType configType3 = SurfaceConfig.ConfigType.JPEG;
        SurfaceConfig.ConfigSize configSize3 = SurfaceConfig.ConfigSize.MAXIMUM;
        StreamUseCase streamUseCase3 = StreamUseCase.STILL_CAPTURE;
        b06.a(companion.a(configType3, configSize3, streamUseCase3));
        B0 b07 = new B0();
        b07.a(companion.a(configType2, configSize3, streamUseCase3));
        B0 b08 = new B0();
        SurfaceConfig.ConfigSize configSize4 = SurfaceConfig.ConfigSize.PREVIEW;
        StreamUseCase streamUseCase4 = StreamUseCase.PREVIEW;
        b08.a(companion.a(configType, configSize4, streamUseCase4));
        b08.a(companion.a(configType3, configSize3, streamUseCase3));
        B0 b09 = new B0();
        b09.a(companion.a(configType, configSize4, streamUseCase4));
        b09.a(companion.a(configType2, configSize3, streamUseCase3));
        B0 b010 = new B0();
        b010.a(companion.a(configType, configSize4, streamUseCase4));
        b010.a(companion.a(configType, configSize2, streamUseCase2));
        B0 b011 = new B0();
        b011.a(companion.a(configType, configSize4, streamUseCase4));
        b011.a(companion.a(configType2, configSize2, streamUseCase2));
        B0 b012 = new B0();
        b012.a(companion.a(configType, configSize4, streamUseCase4));
        b012.a(companion.a(configType2, configSize4, streamUseCase4));
        B0 b013 = new B0();
        b013.a(companion.a(configType, configSize4, streamUseCase4));
        b013.a(companion.a(configType, configSize2, streamUseCase2));
        b013.a(companion.a(configType3, configSize2, streamUseCase3));
        B0 b014 = new B0();
        b014.a(companion.a(configType, configSize4, streamUseCase4));
        b014.a(companion.a(configType2, configSize2, streamUseCase2));
        b014.a(companion.a(configType3, configSize2, streamUseCase3));
        B0 b015 = new B0();
        b015.a(companion.a(configType, configSize4, streamUseCase4));
        b015.a(companion.a(configType2, configSize4, streamUseCase4));
        b015.a(companion.a(configType3, configSize3, streamUseCase3));
        return C1173v.p(b02, b03, b04, b05, b06, b07, b08, b09, b010, b011, b012, b013, b014, b015);
    }
}
