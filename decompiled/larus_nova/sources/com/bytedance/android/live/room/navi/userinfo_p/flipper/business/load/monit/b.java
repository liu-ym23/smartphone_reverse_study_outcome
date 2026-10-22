package com.bytedance.android.live.room.navi.userinfo_p.flipper.business.load.monit;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.JsonUtil;
import com.bytedance.android.live.core.utils.a0;
import com.bytedance.android.livesdk.log.j0;
import com.bytedance.android.livesdk.message.model.t;
import com.larus.apm.impl.protector.RunnableProtector;
import io.reactivex.disposables.Disposable;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes47.dex */
public final class b implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ AnchorTextInfoChangeMonitor f100010a;

    public b(AnchorTextInfoChangeMonitor r100) {
        this.f100010a = r100;
    }

    public final void a() {
        ALogger.i("AnchorTextInfoChangeMonitor", "run task");
        AnchorTextInfoChangeMonitor r100 = this.f100010a;
        r100.e(r100.f99992m);
        o91.a.C7022a r101 = o91.a.f522435a;
        r101.getClass();
        o91.a.C7022a.f522436a = false;
        if (this.f100010a.f99988i.isEmpty() == false) goto L9;
        Disposable r102 = this.f100010a.f99989j;
        if (r102 == null) goto L7;
        r102.dispose();
    L7:
        ALogger.i("AnchorTextInfoChangeMonitor", "end interval task");
        return;
    L9:
        tlc.d r103 = this.f100010a.f99988i.pollFirst();
        if ((r103 instanceof t) == true) goto L12;
        r103 = null;
    L12:
        t r104 = (t) r103;
        AnchorTextInfoChangeMonitor r105 = this.f100010a;
        r105.f99990k.f549202e = r104;
        r105.e(r105.f99991l);
        if (r104 != null) goto L15;
    L17:
        AnchorTextInfoChangeMonitor r106 = this.f100010a;
        r106.getClass();
        if ((r104 instanceof t) == false) goto L24;
        Map<String, String> r107 = MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("anchor_id", a0.n(r106.f99998f).getOwnerUserIdString().toString()), TuplesKt.to("room_id", a0.n(r106.f99998f).getIdStr()), TuplesKt.to("biz_type", String.valueOf(r104.bizType))});
        String r108 = r104.extra;
        if (r108 != null) goto L23;
        r108 = "";
    L23:
        r107.putAll(JsonUtil.jsonObjectToMap(new JSONObject(r108)));
        j0.l().sendLog("livesdk_anchor_profile_module_abnormal_info_entrance_show", r107, new Object[0]);
    L24:
        ALogger.i("AnchorTextInfoChangeMonitor", "begin show view, list remain size: " + this.f100010a.f99988i.size());
        return;
    L15:
        if (r104.bizType != BizType.ANCHOR_BIZ_PANEL.getValue()) goto L17;
        r101.getClass();
        o91.a.C7022a.f522436a = true;
        goto L17
    }

    @Override // java.lang.Runnable
    public final void run() {
        a();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
