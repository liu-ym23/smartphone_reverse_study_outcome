package bl1;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.Widget;
import java.util.HashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
public final class a extends j70.i<uq1.b> {
    @Override // j70.o
    public final Class<? extends Widget> c() {
        return com.bytedance.android.livesdk.chatroom.vs_base.base.util.r.B().getWidgetClass(5);
    }

    public a() {
    }

    @Override // j70.d
    public final boolean B(h70.b r100) {
        uq1.b r101 = (uq1.b) r100;
        Intrinsics.checkNotNullParameter(r101, "layerContext");
        DataCenter r102 = r101.f551201e;
        int r103 = com.bytedance.android.livesdk.chatroom.vs_base.util.p.f118205a;
        if (r102 == null) goto L13;
        HashMap r104 = null;
        r104 = (HashMap) r102.get("data_room_business_extra", null);     // Catch: Exception -> L7
    L9:
        if (r104 == null) goto L13;
        if (r104.containsKey("countdown_task") != true) goto L13;
        return true;
    L7:
        e = move-exception;
        ALogger.e("ReplayParamsUtils", e);
    L13:
        return false;
    }

    @Override // j70.d
    public final j70.f C(h70.b r100) {
        uq1.b r101 = (uq1.b) r100;
        Intrinsics.checkNotNullParameter(r101, "layerContext");
        r101.f551200d.getClass();
        return uq1.a.M;
    }
}
