package ha;

import android.content.Context;
import androidx.room.y;
import com.stepos.statsapp.v3.lib.plugin.payload.TrackerPayload;
import java.util.HashMap;
import java.util.Map;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class a extends y {

    /* renamed from: d, reason: collision with root package name */
    public final long f5422d;

    /* renamed from: e, reason: collision with root package name */
    public final String f5423e;

    public a(Context context, String str, String str2, Map map) {
        super(context, str, map);
        this.f5422d = System.currentTimeMillis();
        this.f5423e = str2;
    }

    public final TrackerPayload d() {
        TrackerPayload trackerPayload = new TrackerPayload();
        trackerPayload.a((String) this.f1652a, "name");
        trackerPayload.a((String) this.f1653b, "network");
        trackerPayload.a("action_x", "type");
        trackerPayload.a(Long.valueOf(this.f5422d), "time");
        trackerPayload.a(this.f5423e, "page");
        ua.c.e("TrackerPayload", "The keys value is empty, returning without add");
        HashMap map = (HashMap) this.f1654c;
        if (map == null) {
            ua.c.e("TrackerPayload", "Map passed in is null, returning without adding map.");
            return trackerPayload;
        }
        trackerPayload.f2843f.putAll(map);
        return trackerPayload;
    }
}
