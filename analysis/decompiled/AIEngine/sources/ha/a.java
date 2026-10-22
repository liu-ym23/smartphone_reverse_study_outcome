package ha;

import android.content.Context;
import com.stepos.statsapp.v3.lib.plugin.payload.TrackerPayload;
import com.tonyodev.fetch2core.server.FileResponse;
import java.util.Map;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class a extends b {

    /* renamed from: d, reason: collision with root package name */
    public final long f9375d;

    /* renamed from: e, reason: collision with root package name */
    public final String f9376e;

    public a(Context context, String str, String str2, Map<String, String> map) {
        super(context, str, map);
        this.f9375d = System.currentTimeMillis();
        this.f9376e = str2;
    }

    public final TrackerPayload a() {
        TrackerPayload trackerPayload = new TrackerPayload();
        trackerPayload.addHeader("name", this.f9377a);
        trackerPayload.addHeader("network", this.f9378b);
        trackerPayload.addHeader(FileResponse.FIELD_TYPE, "action_x");
        trackerPayload.addHeader("time", Long.valueOf(this.f9375d));
        trackerPayload.addHeader("page", this.f9376e);
        trackerPayload.addHeader("event_attrib", null);
        trackerPayload.addValueMap(this.f9379c);
        return trackerPayload;
    }
}
