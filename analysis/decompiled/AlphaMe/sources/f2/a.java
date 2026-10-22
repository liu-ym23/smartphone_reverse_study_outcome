package f2;

import B0.f;
import B0.g;
import a2.AbstractC0155a;
import com.baidu.platform.comapi.map.MapBundleKey;
import com.stepos.alphame.perfbinder.PerfBinderHelper;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public String f12527a;

    /* renamed from: b, reason: collision with root package name */
    public String f12528b;

    /* renamed from: c, reason: collision with root package name */
    public String f12529c;

    /* renamed from: d, reason: collision with root package name */
    public String f12530d;

    /* renamed from: e, reason: collision with root package name */
    public String f12531e;

    /* renamed from: f, reason: collision with root package name */
    public int f12532f;

    /* renamed from: g, reason: collision with root package name */
    public String f12533g;

    /* renamed from: h, reason: collision with root package name */
    public String f12534h;

    /* renamed from: i, reason: collision with root package name */
    public String f12535i;

    /* renamed from: j, reason: collision with root package name */
    public String f12536j;

    /* renamed from: k, reason: collision with root package name */
    public Map f12537k = new HashMap();

    /* renamed from: l, reason: collision with root package name */
    public String f12538l;

    /* renamed from: m, reason: collision with root package name */
    public b f12539m;

    /* renamed from: n, reason: collision with root package name */
    public long f12540n;

    /* renamed from: o, reason: collision with root package name */
    public String f12541o;

    public static a a(String str) throws JSONException {
        AbstractC0155a.a("MessageData", "stringToMessageData start");
        AbstractC0155a.a("MessageData", "stringToMessageData start, messageText=" + str);
        try {
            a aVar = new a();
            JSONObject jSONObject = new JSONObject(str);
            if (!jSONObject.isNull("task_id")) {
                aVar.f12527a = jSONObject.getString("task_id");
            }
            if (!jSONObject.isNull("seq_id")) {
                aVar.f12528b = jSONObject.getString("seq_id");
            }
            if (!jSONObject.isNull("title")) {
                aVar.f12529c = jSONObject.getString("title");
            }
            if (!jSONObject.isNull("content")) {
                aVar.f12530d = jSONObject.getString("content");
            }
            if (!jSONObject.isNull("upload_data_package_name")) {
                aVar.f12531e = jSONObject.getString("upload_data_package_name");
            }
            if (!jSONObject.isNull("clickType")) {
                aVar.f12532f = jSONObject.getInt("clickType");
            }
            if (!jSONObject.isNull(PerfBinderHelper.EVENT_KIND_ACTIVITY)) {
                aVar.f12533g = jSONObject.getString(PerfBinderHelper.EVENT_KIND_ACTIVITY);
            }
            if (!jSONObject.isNull(MapBundleKey.MapObjKey.OBJ_URL)) {
                aVar.f12534h = jSONObject.getString(MapBundleKey.MapObjKey.OBJ_URL);
            }
            if (!jSONObject.isNull("pk")) {
                aVar.f12535i = jSONObject.getString("pk");
            }
            if (!jSONObject.isNull("push_timestamp")) {
                aVar.f12536j = jSONObject.getString("push_timestamp");
            }
            if (!jSONObject.isNull("parameters")) {
                JSONObject jSONObject2 = jSONObject.getJSONObject("parameters");
                HashMap map = new HashMap(jSONObject2.length());
                Iterator<String> itKeys = jSONObject2.keys();
                while (itKeys.hasNext()) {
                    String next = itKeys.next();
                    map.put(next, jSONObject2.getString(next));
                }
                aVar.f12537k = map;
            }
            if (!jSONObject.isNull("through_message")) {
                aVar.f12538l = jSONObject.getString("through_message");
            }
            if (!jSONObject.isNull("notification_message")) {
                aVar.f12539m = b.a(jSONObject.getString("notification_message"));
            }
            if (!jSONObject.isNull("delayed_report_millis")) {
                aVar.f12540n = jSONObject.getInt("delayed_report_millis");
            }
            AbstractC0155a.a("MessageData", "stringToMessageData success, messageData=" + aVar);
            return aVar;
        } catch (JSONException e4) {
            AbstractC0155a.c("MessageData", "stringToMessageData error， " + e4.getMessage());
            return null;
        }
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("MessageData {taskId=");
        sb.append(this.f12527a);
        sb.append(", seqId=");
        sb.append(this.f12528b);
        sb.append(", title=");
        sb.append(f.a(this.f12529c));
        sb.append(", content=");
        sb.append(f.a(this.f12530d));
        sb.append(", packageName=");
        sb.append(this.f12531e);
        sb.append(", clickType=");
        sb.append(this.f12532f);
        sb.append(", activity=");
        sb.append(this.f12533g);
        sb.append(", webUrl=");
        sb.append(this.f12534h);
        sb.append(", clickPackageName=");
        sb.append(this.f12535i);
        sb.append(", pushTimestamp=");
        sb.append(this.f12536j);
        sb.append(", paramsMap=");
        sb.append(this.f12537k);
        sb.append(", throughMessage=");
        sb.append(this.f12538l);
        sb.append(", notificationMessage=***, notificationCoreData=");
        sb.append(this.f12539m);
        sb.append(", delayedReportMillis=");
        sb.append(this.f12540n);
        sb.append(", es=");
        return g.r(sb, this.f12541o, " }");
    }
}
