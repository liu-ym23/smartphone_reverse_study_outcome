package a8;

import android.text.TextUtils;
import java.io.Serializable;
import java.lang.reflect.Array;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f65a = 0;

    /* renamed from: b, reason: collision with root package name */
    public int f66b;

    /* renamed from: c, reason: collision with root package name */
    public Serializable f67c;

    /* renamed from: d, reason: collision with root package name */
    public Object f68d;

    public /* synthetic */ b() {
    }

    public static b a(String str) throws JSONException {
        b bVar = new b();
        bVar.f66b = 0;
        try {
        } catch (Exception e10) {
            s7.a.c("NotificationCoreData", "create error " + e10.getMessage());
        }
        if (TextUtils.isEmpty(str)) {
            return bVar;
        }
        JSONObject jSONObject = new JSONObject(str).getJSONObject("data").getJSONObject("extra");
        bVar.f68d = jSONObject.getString("se");
        if (jSONObject.has("no")) {
            JSONObject jSONObject2 = jSONObject.getJSONObject("no");
            bVar.f66b = jSONObject2.optInt("ni");
            bVar.f67c = jSONObject2.optString("nk");
        }
        s7.a.b("NotificationCoreData", "current notify option is " + bVar);
        return bVar;
    }

    public boolean equals(Object obj) throws ArrayIndexOutOfBoundsException, IllegalArgumentException {
        switch (this.f65a) {
            case 1:
                int i10 = this.f66b;
                if (obj == this) {
                    return true;
                }
                if (com.fasterxml.jackson.databind.util.a.s((Class) this.f67c, obj) && Array.getLength(obj) == i10) {
                    for (int i11 = 0; i11 < i10; i11++) {
                        Object obj2 = Array.get(this.f68d, i11);
                        Object obj3 = Array.get(obj, i11);
                        if (obj2 == obj3 || obj2 == null || obj2.equals(obj3)) {
                        }
                    }
                    return true;
                }
                return false;
            default:
                return super.equals(obj);
        }
    }

    public String toString() {
        switch (this.f65a) {
            case 0:
                StringBuilder sb2 = new StringBuilder("NotificationCoreData(notifyId=");
                sb2.append(this.f66b);
                sb2.append(", notifyKey=");
                sb2.append((String) this.f67c);
                sb2.append(", securityEncryption=");
                return ai.onnxruntime.a.o(sb2, (String) this.f68d, ")");
            default:
                return super.toString();
        }
    }

    public b(Class cls, int i10, Object obj) {
        this.f67c = cls;
        this.f66b = i10;
        this.f68d = obj;
    }
}
