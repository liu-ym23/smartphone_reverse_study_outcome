package com.stepos.statsapp.v3.lib.plugin.events;

import android.content.Context;
import com.stepos.statsapp.v3.lib.plugin.constants.Parameters;
import com.stepos.statsapp.v3.lib.plugin.payload.TrackerPayload;
import java.util.Map;

/* loaded from: classes2.dex */
public class a extends b {

    /* renamed from: h, reason: collision with root package name */
    private final long f30782h;

    /* renamed from: i, reason: collision with root package name */
    private final String f30783i;

    public a(Context context, String str, String str2, Map<String, String> map) {
        super(context, str, map);
        this.f30782h = System.currentTimeMillis();
        this.f30783i = str2;
    }

    @Override // com.stepos.statsapp.v3.lib.plugin.events.b
    public TrackerPayload a() {
        TrackerPayload trackerPayload = new TrackerPayload();
        trackerPayload.addHeader("name", this.f30788a);
        trackerPayload.addHeader("network", this.f30789b);
        trackerPayload.addHeader("type", b.f30787g);
        trackerPayload.addHeader("time", Long.valueOf(this.f30782h));
        trackerPayload.addHeader("page", this.f30783i);
        trackerPayload.addHeader(Parameters.EVENT_ATTRIB, null);
        trackerPayload.addValueMap(this.f30790c);
        return trackerPayload;
    }
}
