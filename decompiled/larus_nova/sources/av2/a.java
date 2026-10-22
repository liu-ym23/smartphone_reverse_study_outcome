package av2;

import com.bytedance.android.livesdkapi.paid.PaidReplayConstants;
import com.bytedance.ies.sdk.widgets.DataCenter;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import nm1.h;
import pm1.f;

/* JADX INFO: loaded from: classes11.dex */
public final class a extends c {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final com.bytedance.android.livesdk.vscore_api.paidlive.scope.a f16360e;

    @Override // com.bytedance.android.livesdk.vscore_impl.paidlive.ablity.log.a, com.bytedance.android.livesdk.vscore_api.paidlive.ability.i
    public final void ca() {
        h r100 = f.f();
        if (r100 == null) goto L6;
        DataCenter r101 = getDataCenter();
        Map<String, String> r102 = Ra();
        r102.put(PaidReplayConstants.KEY_BUY_TICKET_MODULE_FROM, PaidReplayConstants.VALUE_BUY_TICKET_CAMERA_PLAYER_TIP);
        r102.put(PaidReplayConstants.KEY_TICKET_ENTRANCE, PaidReplayConstants.VALUE_BUY_TICKET_CAMERA_PLAYER_TIP);
        Unit r103 = Unit.INSTANCE;
        r100.g(r101, "livesdk_paid_machine_buyticket_module_show", r102, new Object[0]);
        return;
    }

    public a(com.bytedance.android.livesdk.vscore_api.paidlive.scope.a r100) {
        Intrinsics.checkNotNullParameter(r100, "scene");
        super(r100);
        this.f16360e = r100;
    }
}
