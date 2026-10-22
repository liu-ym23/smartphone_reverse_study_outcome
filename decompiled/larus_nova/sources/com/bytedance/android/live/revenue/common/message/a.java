package com.bytedance.android.live.revenue.common.message;

import com.bytedance.android.livesdk.link.model.bridge.b0;
import com.bytedance.android.livesdk.link.model.bridge.c0;
import java.util.Map;
import yh6.e;
import yh6.f;
import yh6.g;

/* JADX INFO: loaded from: classes47.dex */
public final class a extends DynamicMessageType {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final f f90882f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final a f90883g = null;

    static {
        a r100 = new a();
        f90883g = r100;
        f r101 = new f("WebcastBattleStateSyncMessage", new g(b0.class));
        r100.f567602a.put("WebcastBattleStateSyncMessage", r101);
        Map<String, yh6.b<?>> r102 = e.f567603a;
        r102.put("WebcastBattleStateSyncMessage", r101);
        f90882f = r101;
        f r103 = new f("WebcastBattleStealDragonMessage", new g(c0.class));
        r100.f567602a.put("WebcastBattleStealDragonMessage", r103);
        r102.put("WebcastBattleStealDragonMessage", r103);
    }

    public a() {
    }
}
