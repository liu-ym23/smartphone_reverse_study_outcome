package com.stepos.statsapp.v3.lib.plugin.events;

import android.content.Context;
import com.stepos.statsapp.v3.lib.plugin.payload.TrackerPayload;
import com.stepos.statsapp.v3.lib.plugin.utils.NetInfoUtils;
import com.stepos.statsapp.v3.utils.log.Logger;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes2.dex */
public abstract class b {

    /* renamed from: d, reason: collision with root package name */
    private static final String f30784d = "Event";

    /* renamed from: e, reason: collision with root package name */
    public static final String f30785e = "page";

    /* renamed from: f, reason: collision with root package name */
    public static final String f30786f = "log";

    /* renamed from: g, reason: collision with root package name */
    public static final String f30787g = "action_x";

    /* renamed from: a, reason: collision with root package name */
    protected final String f30788a;

    /* renamed from: b, reason: collision with root package name */
    protected final String f30789b;

    /* renamed from: c, reason: collision with root package name */
    protected final Map<String, String> f30790c;

    public b(Context context, String str, Map<String, String> map) {
        this.f30788a = str;
        this.f30789b = NetInfoUtils.getNetworkType(context);
        this.f30790c = a(map);
    }

    private Map<String, String> a(Map<String, String> map) {
        if (map == null) {
            return null;
        }
        try {
            HashMap map2 = new HashMap(map);
            for (Map.Entry entry : map2.entrySet()) {
                String str = (String) entry.getValue();
                if (str != null && str.indexOf(10) >= 0) {
                    entry.setValue(str.replace('\n', (char) 0));
                }
            }
            return map2;
        } catch (Exception e10) {
            Logger.e(f30784d, "convertProperties error, " + e10.getMessage());
            return null;
        }
    }

    public abstract TrackerPayload a();
}
