package X1;

import java.util.HashMap;
import org.json.JSONObject;

/* loaded from: classes.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public String f2107a;

    /* renamed from: b, reason: collision with root package name */
    public String f2108b;

    /* renamed from: c, reason: collision with root package name */
    public String f2109c;

    public final String a() {
        HashMap map = new HashMap();
        map.put("task_id", this.f2107a);
        map.put("seq_id", this.f2108b);
        map.put("push_timestamp", this.f2109c);
        return new JSONObject(map).toString();
    }
}
