package com.stepos.statsapp.v3.lib.plugin.events;

import android.content.Context;
import com.stepos.statsapp.v3.lib.plugin.payload.TrackerPayload;
import java.util.Map;

/* loaded from: classes2.dex */
public class d extends b {

    /* renamed from: i, reason: collision with root package name */
    public static final String f30794i = "com.stepos.uxip.log";

    /* renamed from: h, reason: collision with root package name */
    private final long f30795h;

    public d(Context context, String str, Map<String, String> map) {
        super(context, str, map);
        this.f30795h = System.currentTimeMillis();
    }

    @Override // com.stepos.statsapp.v3.lib.plugin.events.b
    public TrackerPayload a() {
        TrackerPayload trackerPayload = new TrackerPayload();
        trackerPayload.addHeader("name", this.f30788a);
        trackerPayload.addHeader("network", this.f30789b);
        trackerPayload.addHeader("type", b.f30786f);
        trackerPayload.addHeader("time", Long.valueOf(this.f30795h));
        trackerPayload.addValueMap(this.f30790c);
        return trackerPayload;
    }
}
