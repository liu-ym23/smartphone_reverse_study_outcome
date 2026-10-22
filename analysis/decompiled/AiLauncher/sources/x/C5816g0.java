package x;

import android.hardware.camera2.CameraDevice;
import android.os.Trace;
import android.util.Log;
import com.autonavi.aps.amapapi.config.Const;
import java.util.Arrays;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u0015\u0010\u0002\u001a\u00020\u0001*\u0004\u0018\u00010\u0000H\u0000¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Landroid/hardware/camera2/CameraDevice;", "LY8/t;", Const.INTENT_KEY_APIKEY, "(Landroid/hardware/camera2/CameraDevice;)V", "camera-camera2-pipe"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* renamed from: x.g0, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C5816g0 {
    public static final void a(CameraDevice cameraDevice) {
        if (cameraDevice != null) {
            if (z.k.f44508a.c()) {
                Log.i("CXCP", "Closing Camera " + cameraDevice.getId());
            }
            z.h hVar = z.h.f44503a;
            String str = "CXCP#CameraDevice-" + cameraDevice.getId() + "#close";
            long jA = hVar.g().a();
            try {
                Trace.beginSection(str);
                try {
                    cameraDevice.close();
                } catch (NullPointerException e10) {
                    if (z.k.f44508a.d()) {
                        Log.w("CXCP", "NPE encountered during CameraDevice.close()", e10);
                    }
                }
                Y8.t tVar = Y8.t.f7040a;
            } finally {
                Trace.endSection();
                long jC = z.i.c(hVar.g().a() - jA);
                if (z.k.f44508a.a()) {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append(str);
                    sb2.append(" - ");
                    z.y yVar = z.y.f44525a;
                    String str2 = String.format(null, "%.3f ms", Arrays.copyOf(new Object[]{Double.valueOf(jC / 1000000.0d)}, 1));
                    kotlin.jvm.internal.p.h(str2, "format(...)");
                    sb2.append(str2);
                    Log.d("CXCP", sb2.toString());
                }
            }
        }
    }
}
