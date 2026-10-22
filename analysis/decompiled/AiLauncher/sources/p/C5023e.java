package p;

import android.hardware.camera2.CaptureRequest;
import com.autonavi.aps.amapapi.config.Const;
import java.util.Map;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bÁ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J/\u0010\n\u001a\u00020\t2\u0016\u0010\u0006\u001a\u0012\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0005\u0012\u0004\u0012\u00020\u00010\u00042\u0006\u0010\b\u001a\u00020\u0007H\u0007¢\u0006\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lp/e;", "", "<init>", "()V", "", "Landroid/hardware/camera2/CaptureRequest$Key;", "parameters", "", "level", "LY8/t;", Const.INTENT_KEY_APIKEY, "(Ljava/util/Map;I)V", "camera-camera2"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* renamed from: p.e, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C5023e {

    /* renamed from: a, reason: collision with root package name */
    public static final C5023e f37966a = new C5023e();

    public static final void a(Map<CaptureRequest.Key<?>, Object> parameters, int level) {
        kotlin.jvm.internal.p.i(parameters, "parameters");
        parameters.put(CaptureRequest.FLASH_STRENGTH_LEVEL, Integer.valueOf(level));
    }
}
