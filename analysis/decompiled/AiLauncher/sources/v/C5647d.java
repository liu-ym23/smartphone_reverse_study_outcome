package v;

import android.hardware.camera2.CaptureRequest;
import androidx.camera.core.impl.Config;
import com.autonavi.aps.amapapi.config.Const;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0001*\u00020\u0000H\u0007¢\u0006\u0004\b\u0002\u0010\u0003\u001a'\u0010\b\u001a\u00020\u0007*\u00020\u00012\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u0004H\u0000¢\u0006\u0004\b\b\u0010\t\"\"\u0010\u000e\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\n8\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\b\u0010\u000b\u001a\u0004\b\f\u0010\r¨\u0006\u000f"}, d2 = {"Landroidx/camera/core/f;", "Lv/c;", Const.INTENT_KEY_PKGNAME, "(Landroidx/camera/core/f;)Lv/c;", "", "", "parameters", "LY8/t;", Const.INTENT_KEY_APIKEY, "(Lv/c;Ljava/util/Map;)V", "Landroidx/camera/core/impl/Config$a;", "Landroidx/camera/core/impl/Config$a;", "getOPTION_CAPTURE_REQUEST_CONFIGURATOR", "()Landroidx/camera/core/impl/Config$a;", "OPTION_CAPTURE_REQUEST_CONFIGURATOR", "camera-camera2"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* renamed from: v.d, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C5647d {

    /* renamed from: a, reason: collision with root package name */
    public static final Config.a<InterfaceC5646c> f42685a;

    static {
        Config.a<InterfaceC5646c> aVarA = Config.a.a("camerax.core.appConfig.captureRequestConfigurator", InterfaceC5646c.class);
        p.h(aVarA, "create(...)");
        f42685a = aVarA;
    }

    public static final void a(InterfaceC5646c interfaceC5646c, Map<Object, ? extends Object> parameters) {
        p.i(interfaceC5646c, "<this>");
        p.i(parameters, "parameters");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Map.Entry<Object, ? extends Object> entry : parameters.entrySet()) {
            if (entry.getKey() instanceof CaptureRequest.Key) {
                linkedHashMap.put(entry.getKey(), entry.getValue());
            }
        }
        interfaceC5646c.a(linkedHashMap);
    }

    public static final InterfaceC5646c b(androidx.camera.core.f fVar) {
        p.i(fVar, "<this>");
        return (InterfaceC5646c) fVar.getConfig().g(f42685a, null);
    }
}
