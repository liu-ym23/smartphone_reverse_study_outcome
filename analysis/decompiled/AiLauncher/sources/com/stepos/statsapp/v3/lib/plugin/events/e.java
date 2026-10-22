package com.stepos.statsapp.v3.lib.plugin.events;

import android.content.Context;
import com.stepos.statsapp.v3.lib.plugin.constants.Parameters;
import com.stepos.statsapp.v3.lib.plugin.payload.TrackerPayload;
import java.util.Map;

/* loaded from: classes2.dex */
public class e extends b {

    /* renamed from: j, reason: collision with root package name */
    public static final String f30796j = "duration2";

    /* renamed from: h, reason: collision with root package name */
    private final String f30797h;

    /* renamed from: i, reason: collision with root package name */
    private final String f30798i;

    public e(Context context, String str, String str2, String str3, Map<String, String> map) {
        super(context, str, map);
        this.f30797h = str2;
        this.f30798i = str3;
    }

    @Override // com.stepos.statsapp.v3.lib.plugin.events.b
    public TrackerPayload a() {
        TrackerPayload trackerPayload = new TrackerPayload();
        trackerPayload.addHeader("name", this.f30788a);
        trackerPayload.addHeader("network", this.f30789b);
        trackerPayload.addHeader("type", "page");
        trackerPayload.addHeader(Parameters.LAUNCH, this.f30797h);
        trackerPayload.addHeader("terminate", this.f30798i);
        trackerPayload.addValueMap(this.f30790c);
        return trackerPayload;
    }
}
