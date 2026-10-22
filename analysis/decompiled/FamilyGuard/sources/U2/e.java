package U2;

import android.content.Context;
import com.stepos.minor.Minor;
import com.stepos.statsapp.v3.lib.plugin.payload.TrackerPayload;
import java.util.Map;

/* loaded from: classes.dex */
public class e extends b {

    /* renamed from: d, reason: collision with root package name */
    private final String f5462d;

    /* renamed from: e, reason: collision with root package name */
    private final String f5463e;

    public e(Context context, String str, String str2, String str3, Map<String, String> map) {
        super(context, str, map);
        this.f5462d = str2;
        this.f5463e = str3;
    }

    @Override // U2.b
    public TrackerPayload a() {
        TrackerPayload trackerPayload = new TrackerPayload();
        trackerPayload.a(Minor.COLUMN_NAME, this.f5451a);
        trackerPayload.a("network", this.f5452b);
        trackerPayload.a("type", "page");
        trackerPayload.a("launch", this.f5462d);
        trackerPayload.a("terminate", this.f5463e);
        trackerPayload.f(this.f5453c);
        return trackerPayload;
    }
}
