package androidx.camera.camera2.pipe;

import android.hardware.camera2.CaptureRequest;
import android.util.Log;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.statsapp.v3.lib.plugin.constants.UxipConstants;
import java.util.Map;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010%\n\u0002\b\u0004\u001a'\u0010\u0005\u001a\u00020\u0004*\u00020\u00002\u0012\u0010\u0003\u001a\u000e\u0012\u0002\b\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001H\u0007¢\u0006\u0004\b\u0005\u0010\u0006\u001a'\u0010\t\u001a\u00020\u0004*\u00020\u00002\b\u0010\u0007\u001a\u0004\u0018\u00010\u00022\b\u0010\b\u001a\u0004\u0018\u00010\u0002H\u0007¢\u0006\u0004\b\t\u0010\n\u001a5\u0010\r\u001a\u00020\u0004*\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u000b2\u0012\u0010\f\u001a\u000e\u0012\u0002\b\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001H\u0007¢\u0006\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"Landroid/hardware/camera2/CaptureRequest$Builder;", "", "", "parameters", "LY8/t;", "c", "(Landroid/hardware/camera2/CaptureRequest$Builder;Ljava/util/Map;)V", "key", UxipConstants.f30680s, Const.INTENT_KEY_PKGNAME, "(Landroid/hardware/camera2/CaptureRequest$Builder;Ljava/lang/Object;Ljava/lang/Object;)V", "", "metadata", Const.INTENT_KEY_APIKEY, "(Ljava/util/Map;Ljava/util/Map;)V", "camera-camera2-pipe"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes.dex */
public final class u {
    /* JADX WARN: Multi-variable type inference failed */
    public static final void a(Map<Object, Object> map, Map<?, ? extends Object> metadata) {
        kotlin.jvm.internal.p.i(map, "<this>");
        kotlin.jvm.internal.p.i(metadata, "metadata");
        map.putAll(metadata);
    }

    public static final void b(CaptureRequest.Builder builder, Object obj, Object obj2) {
        kotlin.jvm.internal.p.i(builder, "<this>");
        if (obj == null || !(obj instanceof CaptureRequest.Key)) {
            return;
        }
        try {
            builder.set((CaptureRequest.Key) obj, obj2);
        } catch (IllegalArgumentException e10) {
            if (z.k.f44508a.d()) {
                Log.w("CXCP", "Failed to set [" + ((CaptureRequest.Key) obj).getName() + ": " + obj2 + "] on CaptureRequest.Builder", e10);
            }
        }
    }

    public static final void c(CaptureRequest.Builder builder, Map<?, ? extends Object> parameters) {
        kotlin.jvm.internal.p.i(builder, "<this>");
        kotlin.jvm.internal.p.i(parameters, "parameters");
        for (Map.Entry<?, ? extends Object> entry : parameters.entrySet()) {
            b(builder, entry.getKey(), entry.getValue());
        }
    }
}
