package com.bytedance.bdtracker;

import android.content.Context;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import android.webkit.WebView;
import com.bytedance.applog.IAppLogInstance;
import com.bytedance.applog.log.LoggerImpl;
import com.bytedance.bdtracker.s3;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class t3 {
    public static int f;
    public static Map<String, Double> g = new HashMap();
    public double a;
    public WebView b;
    public int[] c = new int[2];
    public final boolean d;
    public final IAppLogInstance e;

    public t3(IAppLogInstance iAppLogInstance, WebView webView, boolean z) {
        this.e = iAppLogInstance;
        this.b = webView;
        this.d = z;
    }

    public final int a() {
        Context context = this.e.getContext();
        if (context != null) {
            try {
                Display defaultDisplay = ((WindowManager) context.getSystemService("window")).getDefaultDisplay();
                if (defaultDisplay == null) {
                    return 0;
                }
                DisplayMetrics displayMetrics = new DisplayMetrics();
                defaultDisplay.getRealMetrics(displayMetrics);
                return displayMetrics.widthPixels;
            } catch (Throwable th) {
                LoggerImpl.global().error(Collections.singletonList("WebInfoParser"), "getScreenWidth failed", th, new Object[0]);
            }
        }
        return 0;
    }

    public final s3.b a(JSONObject jSONObject) {
        String strOptString = jSONObject.optString("nodeName");
        JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("frame");
        s3.a aVar = new s3.a((int) ((jSONObjectOptJSONObject.optInt("x") * this.a) + (this.d ? 0 : this.c[0])), (int) ((jSONObjectOptJSONObject.optInt("y") * this.a) + (this.d ? 0 : this.c[1])), (int) (jSONObjectOptJSONObject.optInt("width") * this.a), (int) (jSONObjectOptJSONObject.optInt("height") * this.a));
        String strOptString2 = jSONObject.optString("_element_path");
        String strOptString3 = jSONObject.optString("element_path");
        JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("positions");
        ArrayList arrayList = new ArrayList();
        if (jSONArrayOptJSONArray != null) {
            for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
                arrayList.add(jSONArrayOptJSONArray.optString(i));
            }
        }
        int iOptInt = jSONObject.optInt("zIndex");
        JSONArray jSONArrayOptJSONArray2 = jSONObject.optJSONArray("texts");
        ArrayList arrayList2 = new ArrayList();
        if (jSONArrayOptJSONArray2 != null) {
            for (int i2 = 0; i2 < jSONArrayOptJSONArray2.length(); i2++) {
                arrayList2.add(jSONArrayOptJSONArray2.optString(i2));
            }
        }
        String strOptString4 = jSONObject.optString("href");
        boolean zOptBoolean = jSONObject.optBoolean("_checkList");
        JSONArray jSONArrayOptJSONArray3 = jSONObject.optJSONArray("fuzzy_positions");
        ArrayList arrayList3 = new ArrayList();
        if (jSONArrayOptJSONArray3 != null) {
            for (int i3 = 0; i3 < jSONArrayOptJSONArray3.length(); i3++) {
                arrayList3.add(jSONArrayOptJSONArray3.optString(i3));
            }
        }
        JSONArray jSONArrayOptJSONArray4 = jSONObject.optJSONArray("children");
        ArrayList arrayList4 = new ArrayList();
        if (jSONArrayOptJSONArray4 != null && jSONArrayOptJSONArray4.length() > 0) {
            for (int i4 = 0; i4 < jSONArrayOptJSONArray4.length(); i4++) {
                arrayList4.add(a(jSONArrayOptJSONArray4.optJSONObject(i4)));
            }
        }
        return new s3.b(strOptString, aVar, strOptString2, strOptString3, arrayList, iOptInt, arrayList2, arrayList4, strOptString4, zOptBoolean, arrayList3);
    }
}
