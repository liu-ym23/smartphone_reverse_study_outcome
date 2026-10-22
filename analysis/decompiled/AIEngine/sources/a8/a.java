package a8;

import androidx.datastore.preferences.protobuf.f;
import java.util.HashMap;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public String f51a;

    /* renamed from: b, reason: collision with root package name */
    public String f52b;

    /* renamed from: c, reason: collision with root package name */
    public String f53c;

    /* renamed from: d, reason: collision with root package name */
    public String f54d;

    /* renamed from: e, reason: collision with root package name */
    public String f55e;

    /* renamed from: f, reason: collision with root package name */
    public int f56f;

    /* renamed from: g, reason: collision with root package name */
    public String f57g;
    public String h;

    /* renamed from: i, reason: collision with root package name */
    public String f58i;

    /* renamed from: j, reason: collision with root package name */
    public String f59j;

    /* renamed from: k, reason: collision with root package name */
    public HashMap f60k = new HashMap();

    /* renamed from: l, reason: collision with root package name */
    public String f61l;

    /* renamed from: m, reason: collision with root package name */
    public b f62m;

    /* renamed from: n, reason: collision with root package name */
    public long f63n;

    /* renamed from: o, reason: collision with root package name */
    public String f64o;

    public static a a(String str) throws JSONException {
        s7.a.a("MessageData", "stringToMessageData start");
        s7.a.a("MessageData", "stringToMessageData start, messageText=" + str);
        try {
            a aVar = new a();
            JSONObject jSONObject = new JSONObject(str);
            if (!jSONObject.isNull("task_id")) {
                aVar.f51a = jSONObject.getString("task_id");
            }
            if (!jSONObject.isNull("seq_id")) {
                aVar.f52b = jSONObject.getString("seq_id");
            }
            if (!jSONObject.isNull("title")) {
                aVar.f53c = jSONObject.getString("title");
            }
            if (!jSONObject.isNull("content")) {
                aVar.f54d = jSONObject.getString("content");
            }
            if (!jSONObject.isNull("upload_data_package_name")) {
                aVar.f55e = jSONObject.getString("upload_data_package_name");
            }
            if (!jSONObject.isNull("clickType")) {
                aVar.f56f = jSONObject.getInt("clickType");
            }
            if (!jSONObject.isNull("activity")) {
                aVar.f57g = jSONObject.getString("activity");
            }
            if (!jSONObject.isNull("url")) {
                aVar.h = jSONObject.getString("url");
            }
            if (!jSONObject.isNull("pk")) {
                aVar.f58i = jSONObject.getString("pk");
            }
            if (!jSONObject.isNull("push_timestamp")) {
                aVar.f59j = jSONObject.getString("push_timestamp");
            }
            if (!jSONObject.isNull("parameters")) {
                JSONObject jSONObject2 = jSONObject.getJSONObject("parameters");
                HashMap map = new HashMap(jSONObject2.length());
                Iterator<String> itKeys = jSONObject2.keys();
                while (itKeys.hasNext()) {
                    String next = itKeys.next();
                    map.put(next, jSONObject2.getString(next));
                }
                aVar.f60k = map;
            }
            if (!jSONObject.isNull("through_message")) {
                aVar.f61l = jSONObject.getString("through_message");
            }
            if (!jSONObject.isNull("notification_message")) {
                aVar.f62m = b.a(jSONObject.getString("notification_message"));
            }
            if (!jSONObject.isNull("delayed_report_millis")) {
                aVar.f63n = jSONObject.getInt("delayed_report_millis");
            }
            s7.a.a("MessageData", "stringToMessageData success, messageData=" + aVar);
            return aVar;
        } catch (JSONException e10) {
            s7.a.c("MessageData", "stringToMessageData error， " + e10.getMessage());
            return null;
        }
    }

    public final String toString() {
        StringBuilder sb2 = new StringBuilder("MessageData {taskId=");
        sb2.append(this.f51a);
        sb2.append(", seqId=");
        sb2.append(this.f52b);
        sb2.append(", title=");
        sb2.append(f.a(this.f53c));
        sb2.append(", content=");
        sb2.append(f.a(this.f54d));
        sb2.append(", packageName=");
        sb2.append(this.f55e);
        sb2.append(", clickType=");
        sb2.append(this.f56f);
        sb2.append(", activity=");
        sb2.append(this.f57g);
        sb2.append(", webUrl=");
        sb2.append(this.h);
        sb2.append(", clickPackageName=");
        sb2.append(this.f58i);
        sb2.append(", pushTimestamp=");
        sb2.append(this.f59j);
        sb2.append(", paramsMap=");
        sb2.append(this.f60k);
        sb2.append(", throughMessage=");
        sb2.append(this.f61l);
        sb2.append(", notificationMessage=***, notificationCoreData=");
        sb2.append(this.f62m);
        sb2.append(", delayedReportMillis=");
        sb2.append(this.f63n);
        sb2.append(", es=");
        return ai.onnxruntime.a.o(sb2, this.f64o, " }");
    }
}
