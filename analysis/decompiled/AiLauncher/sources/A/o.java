package A;

import Z8.F;
import android.hardware.camera2.CaptureResult;
import com.autonavi.aps.amapapi.config.Const;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import p9.InterfaceC5074l;
import w.x;

@Metadata(d1 = {"\u0000 \n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\u001a5\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004*\u0018\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0000H\u0000¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"", "Landroid/hardware/camera2/CaptureResult$Key;", "", "", "Lkotlin/Function1;", "Lw/x;", "", Const.INTENT_KEY_PKGNAME, "(Ljava/util/Map;)Lp9/l;", "camera-camera2-pipe"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes.dex */
public final class o {
    public static final InterfaceC5074l<x, Boolean> b(final Map<CaptureResult.Key<?>, ? extends List<? extends Object>> map) {
        kotlin.jvm.internal.p.i(map, "<this>");
        return new InterfaceC5074l() { // from class: A.n
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return Boolean.valueOf(o.c(map, (x) obj));
            }
        };
    }

    public static final boolean c(Map map, x frameMetadata) {
        kotlin.jvm.internal.p.i(frameMetadata, "frameMetadata");
        for (Map.Entry entry : map.entrySet()) {
            CaptureResult.Key key = (CaptureResult.Key) entry.getKey();
            if (!F.f0((List) entry.getValue(), frameMetadata.U(key))) {
                return false;
            }
        }
        return true;
    }
}
