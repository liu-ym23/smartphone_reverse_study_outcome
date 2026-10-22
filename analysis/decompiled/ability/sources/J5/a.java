package J5;

import android.content.Context;
import androidx.autofill.HintConstants;
import com.stepos.statsapp.v3.lib.plugin.payload.TrackerPayload;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes3.dex */
public final class a extends b {
    public final long e;
    public final String f;

    public a(Context context, String str, String str2, Map map) {
        super(context, str, map);
        this.e = System.currentTimeMillis();
        this.f = str2;
    }

    public final TrackerPayload b() {
        TrackerPayload trackerPayload = new TrackerPayload();
        trackerPayload.addHeader(HintConstants.AUTOFILL_HINT_NAME, (String) this.b);
        trackerPayload.addHeader("network", (String) this.c);
        trackerPayload.addHeader("type", "action_x");
        trackerPayload.addHeader("time", Long.valueOf(this.e));
        trackerPayload.addHeader("page", this.f);
        trackerPayload.addHeader("event_attrib", null);
        trackerPayload.addValueMap((HashMap) this.d);
        return trackerPayload;
    }
}
