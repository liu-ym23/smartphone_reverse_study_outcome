package u;

import D.C0761b0;
import D.InterfaceC0778o;
import K.InterfaceC0898v;
import android.hardware.camera2.CameraCharacteristics;
import android.util.Log;
import androidx.camera.camera2.pipe.DoNotDisturbException;
import androidx.camera.core.CameraSelector;
import androidx.camera.core.InitializationException;
import com.autonavi.aps.amapapi.config.Const;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.p;
import s.InterfaceC5426a;
import t.C5473b;
import w.C5708n;
import w.InterfaceC5705k;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\b\u0000\u0018\u0000 \u00022\u00020\u0001:\u0001\u0002¨\u0006\u0003"}, d2 = {"Lu/b;", "", Const.INTENT_KEY_APIKEY, "camera-camera2"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* renamed from: u.b, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C5554b {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    @Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J;\u0010\r\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u0006\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\r\u0010\u000eJ#\u0010\u0013\u001a\u0004\u0018\u00010\t2\u0006\u0010\u0010\u001a\u00020\u000f2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011H\u0002¢\u0006\u0004\b\u0013\u0010\u0014¨\u0006\u0015"}, d2 = {"Lu/b$a;", "", "<init>", "()V", "Ls/a;", "cameraAppComponent", "Landroidx/camera/core/CameraSelector;", "availableCamerasSelector", "", "", "cameraIdList", "LP/i;", "streamSpecsCalculator", Const.INTENT_KEY_PKGNAME, "(Ls/a;Landroidx/camera/core/CameraSelector;Ljava/util/List;LP/i;)Ljava/util/List;", "Lw/k;", "cameraDevices", "", "lensFacingInteger", Const.INTENT_KEY_APIKEY, "(Lw/k;Ljava/lang/Integer;)Ljava/lang/String;", "camera-camera2"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* renamed from: u.b$a, reason: from kotlin metadata */
    public static final class Companion {
        public /* synthetic */ Companion(kotlin.jvm.internal.i iVar) {
            this();
        }

        public final String a(InterfaceC5705k cameraDevices, Integer lensFacingInteger) {
            if (lensFacingInteger == null) {
                return null;
            }
            try {
                if (lensFacingInteger.intValue() == 1) {
                    androidx.camera.camera2.pipe.g gVarA = InterfaceC5705k.a(cameraDevices, C5708n.b("0"), null, 2, null);
                    if (gVarA == null) {
                        throw new IllegalStateException("Required value was null.");
                    }
                    CameraCharacteristics.Key LENS_FACING = CameraCharacteristics.LENS_FACING;
                    p.h(LENS_FACING, "LENS_FACING");
                    Integer num = (Integer) gVarA.e0(LENS_FACING);
                    if (num != null && num.intValue() == 1) {
                        return "1";
                    }
                } else if (lensFacingInteger.intValue() == 0) {
                    androidx.camera.camera2.pipe.g gVarA2 = InterfaceC5705k.a(cameraDevices, C5708n.b("1"), null, 2, null);
                    if (gVarA2 == null) {
                        throw new IllegalStateException("Required value was null.");
                    }
                    CameraCharacteristics.Key LENS_FACING2 = CameraCharacteristics.LENS_FACING;
                    p.h(LENS_FACING2, "LENS_FACING");
                    Integer num2 = (Integer) gVarA2.e0(LENS_FACING2);
                    if (num2 != null && num2.intValue() == 0) {
                        return "0";
                    }
                }
            } catch (DoNotDisturbException unused) {
                C5473b c5473b = C5473b.f41865a;
                if (C0761b0.g("CXCP")) {
                    Log.e(C5473b.TRUNCATED_TAG, "Received Do Not Disturb exception while deciding camera id to skip. Please turn off Do Not Disturb mode");
                }
            }
            return null;
        }

        public final List<String> b(InterfaceC5426a cameraAppComponent, CameraSelector availableCamerasSelector, List<String> cameraIdList, P.i streamSpecsCalculator) throws InitializationException {
            String strA;
            p.i(cameraAppComponent, "cameraAppComponent");
            p.i(cameraIdList, "cameraIdList");
            p.i(streamSpecsCalculator, "streamSpecsCalculator");
            try {
                ArrayList arrayList = new ArrayList();
                InterfaceC5705k interfaceC5705kB = cameraAppComponent.b();
                if (availableCamerasSelector == null) {
                    return cameraIdList;
                }
                try {
                    strA = a(interfaceC5705kB, availableCamerasSelector.d());
                } catch (IllegalStateException e10) {
                    C5473b c5473b = C5473b.f41865a;
                    if (C0761b0.f("CXCP")) {
                        Log.d(C5473b.TRUNCATED_TAG, "Unable to get Metadata for cameraID 0 and/or 1", e10);
                    }
                    strA = null;
                }
                ArrayList arrayList2 = new ArrayList();
                for (String str : cameraIdList) {
                    if (!p.d(str, strA)) {
                        InterfaceC0898v interfaceC0898vI = cameraAppComponent.c().b(new s.m(C5708n.b(str), null)).a(streamSpecsCalculator).build().a().i();
                        p.h(interfaceC0898vI, "getCameraInfoInternal(...)");
                        arrayList2.add(interfaceC0898vI);
                    }
                }
                List<InterfaceC0778o> listB = availableCamerasSelector.b(arrayList2);
                p.h(listB, "filter(...)");
                for (InterfaceC0778o interfaceC0778o : listB) {
                    p.g(interfaceC0778o, "null cannot be cast to non-null type androidx.camera.core.impl.CameraInfoInternal");
                    String strH = ((InterfaceC0898v) interfaceC0778o).h();
                    p.h(strH, "getCameraId(...)");
                    arrayList.add(strH);
                }
                return arrayList;
            } catch (IllegalStateException e11) {
                C5473b c5473b2 = C5473b.f41865a;
                if (C0761b0.g("CXCP")) {
                    Log.e(C5473b.TRUNCATED_TAG, "Error while accessing info about cameras.", e11);
                }
                throw new InitializationException(e11);
            }
        }

        public Companion() {
        }
    }
}
