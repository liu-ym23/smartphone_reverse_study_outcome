package com.stepos.statsrpk;

import android.content.Context;
import android.text.TextUtils;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.statsapp.v3.utils.SharedPreferencesHelper;
import com.stepos.statsapp.v3.utils.log.Logger;
import io.ktor.sse.ServerSentEventKt;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes2.dex */
public class f {

    /* renamed from: a, reason: collision with root package name */
    public b f31057a;

    /* renamed from: b, reason: collision with root package name */
    public RpkInfo f31058b;

    /* renamed from: c, reason: collision with root package name */
    public SharedPreferencesHelper f31059c;

    /* renamed from: d, reason: collision with root package name */
    public d f31060d;

    public f(Context context, b bVar, RpkInfo rpkInfo) {
        this.f31057a = bVar;
        this.f31058b = rpkInfo;
        this.f31059c = new SharedPreferencesHelper(context, "statsrpk_config_" + rpkInfo.f31011a);
        Logger.v("RpkTracker", "RpkTracker created successfully.");
    }

    public final int a(String str) throws NumberFormatException {
        String config = this.f31059c.getConfig("event_filters", "");
        if (!TextUtils.isEmpty(config)) {
            for (String str2 : config.split(Const.STR_MART_COMMA)) {
                String str3 = str2.split(ServerSentEventKt.COLON)[0];
                int i10 = Integer.parseInt(str2.split(ServerSentEventKt.COLON)[1]);
                if (str3.equals(str)) {
                    return i10;
                }
            }
        }
        return 1;
    }

    public void b(d dVar) {
        this.f31060d = dVar;
    }

    public void c(String str, long j10, long j11, long j12) {
        if (this.f31059c.getConfig("active", true) && a(str) != -1) {
            RpkEvent rpkEvent = new RpkEvent();
            rpkEvent.f31006a = "page";
            rpkEvent.f31007b = str;
            rpkEvent.f31008c = str;
            HashMap map = new HashMap();
            map.put("start", String.valueOf(j10));
            map.put(com.stepos.ailauncher.container.wallpaper.a.PHASE_END, String.valueOf(j11));
            map.put(com.stepos.statsapp.v3.lib.plugin.events.e.f30796j, String.valueOf(j12));
            rpkEvent.f31009d = map;
            rpkEvent.f31010e = this.f31060d.b().f();
            this.f31057a.d(rpkEvent, this.f31058b);
        }
    }

    public void d(String str, String str2, Map map) {
        if (this.f31059c.getConfig("active", true) && a(str) != 0) {
            RpkEvent rpkEvent = new RpkEvent();
            rpkEvent.f31006a = com.stepos.statsapp.v3.lib.plugin.events.b.f30787g;
            rpkEvent.f31007b = str;
            rpkEvent.f31008c = str2;
            rpkEvent.f31009d = map;
            rpkEvent.f31010e = this.f31060d.b().f();
            this.f31057a.d(rpkEvent, this.f31058b);
        }
    }
}
