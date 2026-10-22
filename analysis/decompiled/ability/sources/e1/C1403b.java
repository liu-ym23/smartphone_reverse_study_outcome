package e1;

import D7.v;
import D9.n;
import android.content.ContentProviderClient;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.os.RemoteException;
import android.text.TextUtils;
import android.util.Log;
import com.stepos.ability.env.config.IEnvConfig;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import kotlin.NotImplementedError;
import kotlin.jvm.internal.k;
import kotlin.text.Regex;
import org.json.JSONException;
import org.json.JSONObject;
import x.j;

/* renamed from: e1.b, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C1403b implements P4.a, IEnvConfig, e5.b, j {
    public static HashMap b;

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f4332a;

    public /* synthetic */ C1403b(int i) {
        this.f4332a = i;
    }

    public static Class a(String str) {
        X5.a aVar = (X5.a) b.get(str);
        if (aVar != null) {
            return aVar.f1503a;
        }
        Class<?> cls = Class.forName(str);
        b.put(str, new X5.a(cls));
        return cls;
    }

    public static Method b(Class cls, Class... clsArr) throws NoSuchMethodException, SecurityException {
        if (((X5.a) b.get(cls.getName())) == null) {
            try {
                a(cls.getName());
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
        X5.a aVar = (X5.a) b.get(cls.getName());
        if (aVar == null) {
            return null;
        }
        HashMap map = aVar.b;
        String string = "get";
        for (Class cls2 : clsArr) {
            StringBuilder sbV = androidx.compose.foundation.b.v(string);
            sbV.append(cls2.toString());
            string = sbV.toString();
        }
        Method method = (Method) map.get(string);
        if (method != null) {
            return method;
        }
        Method method2 = cls.getMethod("get", clsArr);
        map.put(string, method2);
        return method2;
    }

    public static String d(String str, String str2, Map headers) {
        k.f(headers, "headers");
        String strI0 = v.I0(headers.entrySet(), " ", null, null, new com.uxsense.parse.b(23), 30);
        return B7.a.q(B7.a.w("curl -X POST '", str, "' -H 'Content-Type: application/json; charset=utf-8' ", strI0, " -d '"), new Regex("(\"api_key\"\\s*:\\s*\")([^\"]+)").e(new com.uxsense.parse.b(24), str2), "'");
    }

    @Override // x.j
    public n c(Context context) throws RemoteException {
        try {
            ContentProviderClient contentProviderClientAcquireContentProviderClient = context.getContentResolver().acquireContentProviderClient(Uri.parse("content://cn.nubia.identity/identity"));
            if (contentProviderClientAcquireContentProviderClient != null) {
                Bundle bundleCall = contentProviderClientAcquireContentProviderClient.call("getOAID", null, null);
                contentProviderClientAcquireContentProviderClient.close();
                if (bundleCall != null) {
                    if (bundleCall.getInt("code", -1) == 0) {
                        n nVar = new n();
                        nVar.f443a = bundleCall.getString("id");
                        return nVar;
                    }
                    String string = bundleCall.getString("message");
                    if (!TextUtils.isEmpty(string) && string != null) {
                        Log.e("Logger", string);
                    }
                }
            }
            return null;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override // P4.a
    public String e() {
        return "https://biz-gw.zyql.com/dictionary/";
    }

    @Override // x.j
    public boolean g(Context context) {
        return true;
    }

    @Override // com.stepos.ability.env.config.IEnvConfig
    public String getBaseUrl() {
        return "https://biz-gw.stepaos.com/ability-service/";
    }

    @Override // P4.a
    public String i() {
        throw new NotImplementedError("An operation is not implemented: Not yet implemented");
    }

    @Override // P4.a
    public String j() {
        throw new NotImplementedError("An operation is not implemented: Not yet implemented");
    }

    public String toString() {
        switch (this.f4332a) {
            case 2:
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("noBootUp", false);
                    jSONObject.put("replacePackage", "");
                    jSONObject.put("printLog", false);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                return jSONObject.toString();
            default:
                return super.toString();
        }
    }
}
