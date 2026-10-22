package com.bytedance.android.livesdkapi.model.com.bytedance.android.livesdk.rxbus;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.livesdkapi.model.com.bytedance.android.livesdk.config.MultiRoomConfig;
import com.bytedance.ies.sdk.widgets.DataCenter;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import xs2.a;
import xs2.b;
import xs2.c;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u000b\u0010\fJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0006\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004J\u0010\u0010\b\u001a\u00020\u00072\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004J\u0010\u0010\u0006\u001a\u00020\u00022\b\u0010\n\u001a\u0004\u0018\u00010\t¨\u0006\r"}, d2 = {"Lcom/bytedance/android/livesdkapi/model/com/bytedance/android/livesdk/rxbus/RxBusAbility;", "", "Lxs2/a;", "getDefaultRxBus", "", "uniqueId", "getRxBus", "", "clearRxBus", "Lcom/bytedance/ies/sdk/widgets/DataCenter;", "dataCenter", "<init>", "()V", "infrastructure_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class RxBusAbility {
    public static final RxBusAbility INSTANCE = null;

    private RxBusAbility() {
    }

    static {
        INSTANCE = new RxBusAbility();
    }

    private final a getDefaultRxBus() {
        if (MultiRoomConfig.INSTANCE.isUseScopeRxBus() == false) goto L7;
        return c.a("scopedRxBus_default_unique_id_1234567890");
    L7:
        return b.a();
    }

    public final void clearRxBus(String r100) {
        if (MultiRoomConfig.INSTANCE.isUseScopeRxBus() == true) goto L5;
        return;
    L5:
        if (r100 != null) goto L7;
    L10:
        boolean r101 = true;
    L11:
        if (r101 == false) goto L13;
        return;
    L13:
        ((ConcurrentHashMap) c.f564944b).remove(r100);
        ALogger.i("ScopedRxBus", "clear RxBus: " + r100);
        return;
    L7:
        if (r100.length() == 0) goto L10;
        r101 = false;
        goto L11
    }

    public final a getRxBus(String r100) {
        if (MultiRoomConfig.INSTANCE.isUseScopeRxBus() == false) goto L5;
        if (r100 != null) goto L8;
    L11:
        boolean r101 = true;
    L12:
        if (r101 == false) goto L16;
        return getDefaultRxBus();
    L16:
        return c.a(r100);
    L8:
        if (r100.length() == 0) goto L11;
        r101 = false;
        goto L12
    L5:
        return b.a();
    }

    public final a getRxBus(DataCenter r100) {
        if (r100 == null) goto L4;
        String r101 = (String) r100.get("data_room_unique_id", "scopedRxBus_default_unique_id_1234567890");
    L6:
        return getRxBus(r101);
    L4:
        r101 = null;
        goto L6
    }
}
