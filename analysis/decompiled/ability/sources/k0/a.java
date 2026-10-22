package k0;

import S0.b;
import android.os.Process;
import android.text.TextUtils;
import com.stepos.taskrobot.settingsprovider.SettingsConfig;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public abstract class a {

    /* renamed from: a, reason: collision with root package name */
    public static final AtomicInteger f4791a = new AtomicInteger(0);
    public static String b = null;

    public static String a() {
        BufferedReader bufferedReader;
        String str = b;
        if (!TextUtils.isEmpty(str)) {
            return str;
        }
        String string = null;
        try {
            bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream("/proc/" + Process.myPid() + "/cmdline"), "iso-8859-1"));
            try {
                StringBuilder sb = new StringBuilder(32);
                while (true) {
                    int i = bufferedReader.read();
                    if (i <= 0) {
                        break;
                    }
                    sb.append((char) i);
                }
                string = sb.toString();
            } catch (Throwable unused) {
            }
        } catch (Throwable unused2) {
            bufferedReader = null;
        }
        b.L0(bufferedReader);
        b = string;
        return string == null ? "" : string;
    }

    public static ArrayList b(byte[] bArr) {
        JSONArray jSONArrayOptJSONArray;
        if (bArr == null) {
            return null;
        }
        String str = new String(bArr);
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.has("list")) {
                JSONArray jSONArrayOptJSONArray2 = jSONObject.optJSONArray("list");
                if (jSONArrayOptJSONArray2 == null) {
                    return null;
                }
                for (int i = 0; i < jSONArrayOptJSONArray2.length(); i++) {
                    JSONObject jSONObject2 = jSONArrayOptJSONArray2.getJSONObject(i);
                    if (jSONObject2 != null && (jSONArrayOptJSONArray = jSONObject2.optJSONArray(SettingsConfig.KEY_DATA)) != null) {
                        for (int i6 = 0; i6 < jSONArrayOptJSONArray.length(); i6++) {
                            arrayList.add(jSONArrayOptJSONArray.getJSONObject(i6));
                        }
                    }
                }
            } else {
                JSONArray jSONArrayOptJSONArray3 = jSONObject.optJSONArray(SettingsConfig.KEY_DATA);
                for (int i10 = 0; i10 < jSONArrayOptJSONArray3.length(); i10++) {
                    arrayList.add(jSONArrayOptJSONArray3.getJSONObject(i10));
                }
            }
        } catch (Exception unused) {
        }
        return arrayList;
    }

    public static void c(String str, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        try {
            H2.b.f731a.f(str, jSONObject);
        } catch (Exception unused) {
        }
    }
}
