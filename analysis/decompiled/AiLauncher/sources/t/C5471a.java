package t;

import android.hardware.camera2.CaptureRequest;
import androidx.camera.core.impl.Config;
import com.autonavi.aps.amapapi.config.Const;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\b\u0003\u001a\u001d\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u0006\u0012\u0002\b\u00030\u0000H\u0000¢\u0006\u0004\b\u0003\u0010\u0004\u001a!\u0010\u0007\u001a\u0012\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0000\u0012\u0004\u0012\u00020\u00020\u0006*\u00020\u0005¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Landroid/hardware/camera2/CaptureRequest$Key;", "Landroidx/camera/core/impl/Config$a;", "", Const.INTENT_KEY_APIKEY, "(Landroid/hardware/camera2/CaptureRequest$Key;)Landroidx/camera/core/impl/Config$a;", "Landroidx/camera/core/impl/Config;", "", Const.INTENT_KEY_PKGNAME, "(Landroidx/camera/core/impl/Config;)Ljava/util/Map;", "camera-camera2"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* renamed from: t.a, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C5471a {
    public static final Config.a<Object> a(CaptureRequest.Key<?> key) {
        kotlin.jvm.internal.p.i(key, "<this>");
        Config.a<Object> aVarB = Config.a.b("camera2.captureRequest.option." + key.getName(), Object.class, key);
        kotlin.jvm.internal.p.h(aVarB, "create(...)");
        return aVarB;
    }

    public static final Map<CaptureRequest.Key<?>, Object> b(Config config) {
        Object objA;
        kotlin.jvm.internal.p.i(config, "<this>");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Config.a<?> aVar : config.e()) {
            Object objD = aVar.d();
            CaptureRequest.Key key = objD instanceof CaptureRequest.Key ? (CaptureRequest.Key) objD : null;
            if (key != null && (objA = config.a(aVar)) != null) {
                linkedHashMap.put(key, objA);
            }
        }
        return linkedHashMap;
    }
}
