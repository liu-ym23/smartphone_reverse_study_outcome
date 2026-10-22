package r6;

import ab.x;
import ib.c;
import java.util.HashMap;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public String f8987a;

    /* renamed from: b, reason: collision with root package name */
    public String f8988b;

    /* renamed from: c, reason: collision with root package name */
    public String f8989c;

    /* renamed from: d, reason: collision with root package name */
    public String f8990d;

    /* renamed from: e, reason: collision with root package name */
    public String f8991e;

    /* renamed from: f, reason: collision with root package name */
    public int f8992f;

    /* renamed from: g, reason: collision with root package name */
    public String f8993g;

    /* renamed from: h, reason: collision with root package name */
    public String f8994h;

    /* renamed from: i, reason: collision with root package name */
    public String f8995i;

    /* renamed from: j, reason: collision with root package name */
    public String f8996j;

    /* renamed from: k, reason: collision with root package name */
    public HashMap f8997k = new HashMap();

    /* renamed from: l, reason: collision with root package name */
    public String f8998l;

    /* renamed from: m, reason: collision with root package name */
    public x f8999m;

    /* renamed from: n, reason: collision with root package name */
    public long f9000n;

    /* renamed from: o, reason: collision with root package name */
    public String f9001o;

    public static a a(String str) throws JSONException {
        j6.a.a("MessageData", "stringToMessageData start");
        j6.a.a("MessageData", "stringToMessageData start, messageText=" + str);
        try {
            a aVar = new a();
            JSONObject jSONObject = new JSONObject(str);
            if (!jSONObject.isNull("task_id")) {
                aVar.f8987a = jSONObject.getString("task_id");
            }
            if (!jSONObject.isNull("seq_id")) {
                aVar.f8988b = jSONObject.getString("seq_id");
            }
            if (!jSONObject.isNull("title")) {
                aVar.f8989c = jSONObject.getString("title");
            }
            if (!jSONObject.isNull("content")) {
                aVar.f8990d = jSONObject.getString("content");
            }
            if (!jSONObject.isNull("upload_data_package_name")) {
                aVar.f8991e = jSONObject.getString("upload_data_package_name");
            }
            if (!jSONObject.isNull("clickType")) {
                aVar.f8992f = jSONObject.getInt("clickType");
            }
            if (!jSONObject.isNull("activity")) {
                aVar.f8993g = jSONObject.getString("activity");
            }
            if (!jSONObject.isNull("url")) {
                aVar.f8994h = jSONObject.getString("url");
            }
            if (!jSONObject.isNull("pk")) {
                aVar.f8995i = jSONObject.getString("pk");
            }
            if (!jSONObject.isNull("push_timestamp")) {
                aVar.f8996j = jSONObject.getString("push_timestamp");
            }
            if (!jSONObject.isNull("parameters")) {
                JSONObject jSONObject2 = jSONObject.getJSONObject("parameters");
                HashMap map = new HashMap(jSONObject2.length());
                Iterator<String> itKeys = jSONObject2.keys();
                while (itKeys.hasNext()) {
                    String next = itKeys.next();
                    map.put(next, jSONObject2.getString(next));
                }
                aVar.f8997k = map;
            }
            if (!jSONObject.isNull("through_message")) {
                aVar.f8998l = jSONObject.getString("through_message");
            }
            if (!jSONObject.isNull("notification_message")) {
                aVar.f8999m = x.b(jSONObject.getString("notification_message"));
            }
            if (!jSONObject.isNull("delayed_report_millis")) {
                aVar.f9000n = jSONObject.getInt("delayed_report_millis");
            }
            j6.a.a("MessageData", "stringToMessageData success, messageData=" + aVar);
            return aVar;
        } catch (JSONException e10) {
            j6.a.c("MessageData", "stringToMessageData error， " + e10.getMessage());
            return null;
        }
    }

    public final String toString() {
        StringBuilder sb2 = new StringBuilder("MessageData {taskId=");
        sb2.append(this.f8987a);
        sb2.append(", seqId=");
        sb2.append(this.f8988b);
        sb2.append(", title=");
        sb2.append(c.b(this.f8989c));
        sb2.append(", content=");
        sb2.append(c.b(this.f8990d));
        sb2.append(", packageName=");
        sb2.append(this.f8991e);
        sb2.append(", clickType=");
        sb2.append(this.f8992f);
        sb2.append(", activity=");
        sb2.append(this.f8993g);
        sb2.append(", webUrl=");
        sb2.append(this.f8994h);
        sb2.append(", clickPackageName=");
        sb2.append(this.f8995i);
        sb2.append(", pushTimestamp=");
        sb2.append(this.f8996j);
        sb2.append(", paramsMap=");
        sb2.append(this.f8997k);
        sb2.append(", throughMessage=");
        sb2.append(this.f8998l);
        sb2.append(", notificationMessage=***, notificationCoreData=");
        sb2.append(this.f8999m);
        sb2.append(", delayedReportMillis=");
        sb2.append(this.f9000n);
        sb2.append(", es=");
        return a1.a.m(sb2, this.f9001o, " }");
    }
}
