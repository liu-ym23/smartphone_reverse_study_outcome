package H2;

import android.content.Context;
import com.stepos.alphame.persona.PersonalContract;
import com.stepos.alphame.suggest.AppSuggestStorable;
import com.stepos.statsapp.v3.lib.plugin.payload.TrackerPayload;
import java.util.Map;
import k.AbstractC0650d;

/* loaded from: classes.dex */
public final class a extends AbstractC0650d {

    /* renamed from: d, reason: collision with root package name */
    public final long f802d;

    /* renamed from: e, reason: collision with root package name */
    public final String f803e;

    public a(Context context, String str, String str2, Map map) {
        super(context, str, map);
        this.f802d = System.currentTimeMillis();
        this.f803e = str2;
    }

    @Override // k.AbstractC0650d
    public final TrackerPayload c() {
        TrackerPayload trackerPayload = new TrackerPayload();
        trackerPayload.c((String) this.f13181a, "name");
        trackerPayload.c((String) this.f13182b, "network");
        trackerPayload.c("action_x", "type");
        trackerPayload.c(Long.valueOf(this.f802d), AppSuggestStorable.COLUMN_TIME);
        trackerPayload.c(this.f803e, PersonalContract.KEY_PAGE);
        trackerPayload.c((Map) this.f13183c, "value");
        trackerPayload.c(null, "event_attrib");
        return trackerPayload;
    }
}
