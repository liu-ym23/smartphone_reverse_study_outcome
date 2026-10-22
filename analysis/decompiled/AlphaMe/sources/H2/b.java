package H2;

import android.content.Context;
import com.stepos.alphame.persona.PersonalContract;
import com.stepos.statsapp.v3.lib.plugin.payload.TrackerPayload;
import java.util.HashMap;
import java.util.Map;
import k.AbstractC0650d;

/* loaded from: classes.dex */
public final class b extends AbstractC0650d {

    /* renamed from: d, reason: collision with root package name */
    public final String f804d;

    /* renamed from: e, reason: collision with root package name */
    public final String f805e;

    public b(Context context, String str, String str2, String str3, HashMap map) {
        super(context, str, map);
        this.f804d = str2;
        this.f805e = str3;
    }

    @Override // k.AbstractC0650d
    public final TrackerPayload c() {
        TrackerPayload trackerPayload = new TrackerPayload();
        trackerPayload.c((String) this.f13181a, "name");
        trackerPayload.c((String) this.f13182b, "network");
        trackerPayload.c(PersonalContract.KEY_PAGE, "type");
        trackerPayload.c(this.f804d, "launch");
        trackerPayload.c(this.f805e, "terminate");
        trackerPayload.c((Map) this.f13183c, "value");
        return trackerPayload;
    }
}
