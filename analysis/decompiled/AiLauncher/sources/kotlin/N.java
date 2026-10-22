package kotlin;

import Y8.t;
import com.autonavi.aps.amapapi.config.Const;
import com.networknt.schema.keyword.PropertiesValidator;
import com.stepos.statsapp.v3.UsageStatsProxy3;
import h8.C4148a;
import java.util.Map;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J;\u0010\n\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u00042\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00042\u0016\b\u0002\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0007H\u0007¢\u0006\u0004\b\n\u0010\u000bJ;\u0010\f\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u00042\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00042\u0016\b\u0002\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0007H\u0007¢\u0006\u0004\b\f\u0010\u000bR\u0014\u0010\r\u001a\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"LK6/N;", "", "<init>", "()V", "", "eventName", "pageName", "", PropertiesValidator.PROPERTY, "LY8/t;", Const.INTENT_KEY_APIKEY, "(Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;)V", Const.INTENT_KEY_PKGNAME, "TAG", "Ljava/lang/String;", "common_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class N {
    public static final N INSTANCE = new N();
    private static final String TAG = "UsageStatsReporter";

    public static final void a(String eventName, String pageName, Map<String, String> properties) {
        Object objB;
        p.i(eventName, "eventName");
        String str = "onEvent(" + eventName + ")";
        try {
            Result.Companion companion = Result.INSTANCE;
            UsageStatsProxy3 usageStatsProxy3 = UsageStatsProxy3.getInstance();
            p.h(usageStatsProxy3, "getInstance(...)");
            usageStatsProxy3.onEvent(eventName, pageName, properties);
            objB = Result.b(t.f7040a);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objB = Result.b(C4849c.a(th));
        }
        Throwable thE = Result.e(objB);
        if (thE != null) {
            C4148a.u(TAG, str + " skipped: " + thE.getMessage(), false, 4, null);
        }
    }

    public static final void b(String eventName, String pageName, Map<String, String> properties) {
        Object objB;
        p.i(eventName, "eventName");
        String str = "onEventRealtime(" + eventName + ")";
        try {
            Result.Companion companion = Result.INSTANCE;
            UsageStatsProxy3 usageStatsProxy3 = UsageStatsProxy3.getInstance();
            p.h(usageStatsProxy3, "getInstance(...)");
            usageStatsProxy3.onEventRealtime(eventName, pageName, properties);
            objB = Result.b(t.f7040a);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objB = Result.b(C4849c.a(th));
        }
        Throwable thE = Result.e(objB);
        if (thE != null) {
            C4148a.u(TAG, str + " skipped: " + thE.getMessage(), false, 4, null);
        }
    }
}
