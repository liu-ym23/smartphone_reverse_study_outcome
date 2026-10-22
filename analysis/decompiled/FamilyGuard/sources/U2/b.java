package U2;

import android.content.Context;
import com.stepos.statsapp.v3.lib.plugin.payload.TrackerPayload;
import d3.C0667c;
import g3.C0742e;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes.dex */
public abstract class b {

    /* renamed from: a, reason: collision with root package name */
    protected final String f5451a;

    /* renamed from: b, reason: collision with root package name */
    protected final String f5452b;

    /* renamed from: c, reason: collision with root package name */
    protected final Map<String, String> f5453c;

    protected b(Context context, String str, Map<String, String> map) {
        this.f5451a = str;
        this.f5452b = C0667c.a(context);
        this.f5453c = b(map);
    }

    private Map<String, String> b(Map<String, String> map) {
        if (map == null) {
            return null;
        }
        try {
            HashMap map2 = new HashMap(map);
            for (Map.Entry entry : map2.entrySet()) {
                String str = (String) entry.getValue();
                if (str != null && str.indexOf(10) >= 0) {
                    entry.setValue(str.replace('\n', (char) 0));
                }
            }
            return map2;
        } catch (Exception e6) {
            C0742e.d("Event", "convertProperties error, " + e6.getMessage());
            return null;
        }
    }

    public abstract TrackerPayload a();
}
