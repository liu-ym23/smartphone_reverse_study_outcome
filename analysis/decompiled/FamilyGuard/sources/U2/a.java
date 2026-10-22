package U2;

import android.content.Context;
import com.stepos.minor.Minor;
import com.stepos.statsapp.v3.lib.plugin.payload.TrackerPayload;
import java.util.Map;

/* loaded from: classes.dex */
public class a extends b {

    /* renamed from: d, reason: collision with root package name */
    private final long f5449d;

    /* renamed from: e, reason: collision with root package name */
    private final String f5450e;

    public a(Context context, String str, String str2, Map<String, String> map) {
        super(context, str, map);
        this.f5449d = System.currentTimeMillis();
        this.f5450e = str2;
    }

    @Override // U2.b
    public TrackerPayload a() {
        TrackerPayload trackerPayload = new TrackerPayload();
        trackerPayload.a(Minor.COLUMN_NAME, this.f5451a);
        trackerPayload.a("network", this.f5452b);
        trackerPayload.a("type", "action_x");
        trackerPayload.a("time", Long.valueOf(this.f5449d));
        trackerPayload.a("page", this.f5450e);
        trackerPayload.a("event_attrib", null);
        trackerPayload.f(this.f5453c);
        return trackerPayload;
    }
}
