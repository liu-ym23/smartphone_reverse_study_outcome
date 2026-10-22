package com.baidu.mshield.x0.c;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.text.TextUtils;
import com.baidu.mshield.b.f.e;
import com.baidu.mshield.x0.EngineImpl;
import com.baidu.mshield.x0.d.d;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Timer;
import java.util.TimerTask;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class c extends b {

    /* renamed from: a, reason: collision with root package name */
    public static String f8372a;

    /* renamed from: b, reason: collision with root package name */
    public static String f8373b;

    public static class a extends TimerTask {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ JSONObject f8374a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Context f8375b;

        public a(JSONObject jSONObject, Context context) {
            this.f8374a = jSONObject;
            this.f8375b = context;
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            String str;
            JSONObject jSONObject;
            int i4;
            String str2;
            String str3;
            String str4;
            boolean z4;
            JSONObject jSONObject2;
            String str5;
            String str6 = "4";
            String str7 = "1";
            try {
                int iOptInt = this.f8374a.optInt("1", 0);
                String strOptString = this.f8374a.optString("4", "");
                int iOptInt2 = this.f8374a.has("7") ? this.f8374a.optJSONObject("7").optInt("1", 1) : 0;
                String strValueOf = String.valueOf(System.currentTimeMillis());
                com.baidu.mshield.b.c.a.b("detect app encryptStr====" + c.f8373b);
                String strB = com.baidu.xclient.gdid.a.b(c.f8373b);
                com.baidu.mshield.b.c.a.b("detect app decryptStr====" + strB);
                JSONObject jSONObject3 = !TextUtils.isEmpty(strB) ? new JSONObject(strB) : new JSONObject();
                JSONObject jSONObject4 = new JSONObject();
                String str8 = "8";
                String str9 = "0";
                if (jSONObject3.length() > 0) {
                    Iterator<String> itKeys = jSONObject3.keys();
                    while (itKeys.hasNext()) {
                        String next = itKeys.next();
                        Iterator<String> it = itKeys;
                        JSONObject jSONObjectOptJSONObject = jSONObject3.optJSONObject(next);
                        JSONObject jSONObject5 = jSONObject3;
                        String strOptString2 = jSONObjectOptJSONObject.optString("p");
                        String str10 = strOptString;
                        JSONObject jSONObjectOptJSONObject2 = jSONObjectOptJSONObject.optJSONObject("f");
                        JSONObject jSONObject6 = new JSONObject();
                        String str11 = strValueOf;
                        PackageInfo packageInfoB = b.b(this.f8375b, strOptString2);
                        if (packageInfoB != null) {
                            jSONObject = jSONObject4;
                            if (iOptInt == 1) {
                                i4 = iOptInt;
                                jSONObject6.put(str9, e.a(new File(packageInfoB.applicationInfo.sourceDir)));
                            } else {
                                i4 = iOptInt;
                            }
                            jSONObject6.put(str7, str7);
                            if (b.c(this.f8375b, strOptString2)) {
                                jSONObject6.put(str6, str7);
                            } else {
                                jSONObject6.put(str6, str9);
                            }
                            ArrayList arrayList = new ArrayList();
                            JSONObject jSONObject7 = new JSONObject();
                            str = str6;
                            if (jSONObjectOptJSONObject2 != null) {
                                Iterator<String> itKeys2 = jSONObjectOptJSONObject2.keys();
                                while (itKeys2.hasNext()) {
                                    String str12 = next;
                                    StringBuffer stringBuffer = new StringBuffer();
                                    int i5 = iOptInt2;
                                    String next2 = itKeys2.next();
                                    String str13 = str9;
                                    String strOptString3 = jSONObjectOptJSONObject2.optString(next2);
                                    if (TextUtils.isEmpty(strOptString3)) {
                                        next = str12;
                                        str9 = str13;
                                        iOptInt2 = i5;
                                    } else {
                                        String str14 = str7;
                                        if (new File(strOptString3).exists()) {
                                            String[] strArrA = com.baidu.mshield.b.a.b.a(strOptString3);
                                            str5 = str8;
                                            stringBuffer.append(strArrA[0]);
                                            stringBuffer.append("#");
                                            jSONObject2 = jSONObjectOptJSONObject2;
                                            stringBuffer.append(strArrA[1]);
                                            stringBuffer.append("#");
                                            stringBuffer.append(strArrA[2]);
                                            stringBuffer.append("#");
                                            stringBuffer.append(strArrA[3]);
                                        } else {
                                            jSONObject2 = jSONObjectOptJSONObject2;
                                            str5 = str8;
                                        }
                                        arrayList.add(strOptString3);
                                        jSONObject7.put(next2, stringBuffer.toString());
                                        next = str12;
                                        str9 = str13;
                                        iOptInt2 = i5;
                                        str7 = str14;
                                        str8 = str5;
                                        jSONObjectOptJSONObject2 = jSONObject2;
                                    }
                                }
                            }
                            String str15 = str7;
                            String str16 = str9;
                            JSONObject jSONObject8 = jSONObjectOptJSONObject2;
                            int i6 = iOptInt2;
                            str3 = next;
                            String str17 = str8;
                            jSONObject6.put("3", String.valueOf(b.a(this.f8375b, strOptString2, arrayList)));
                            jSONObject6.put("5", jSONObject7.toString());
                            jSONObject6.put("6", packageInfoB.firstInstallTime);
                            jSONObject6.put("7", packageInfoB.lastUpdateTime);
                            if (jSONObject8 == null || jSONObject8.length() <= 0) {
                                str7 = str15;
                                str4 = str17;
                                str2 = str16;
                                jSONObject6.put(str4, str2);
                            } else {
                                str7 = str15;
                                str4 = str17;
                                jSONObject6.put(str4, str7);
                                str2 = str16;
                            }
                            jSONObject6.put("9", packageInfoB.versionName);
                            iOptInt2 = i6;
                            if (iOptInt2 == 1) {
                                String[] strArrA2 = b.a(this.f8375b, strOptString2);
                                for (int i7 = 0; i7 < strArrA2.length; i7++) {
                                    String str18 = strArrA2[i7];
                                    StringBuffer stringBuffer2 = new StringBuffer();
                                    if (!TextUtils.isEmpty(str18)) {
                                        String[] strArrA3 = com.baidu.mshield.b.a.b.a(str18);
                                        stringBuffer2.append(strArrA3[0]);
                                        stringBuffer2.append("#");
                                        stringBuffer2.append(strArrA3[1]);
                                        stringBuffer2.append("#");
                                        stringBuffer2.append(strArrA3[2]);
                                        stringBuffer2.append("#");
                                        stringBuffer2.append(strArrA3[3]);
                                    }
                                    jSONObject6.put(String.valueOf(i7 + 10), stringBuffer2.toString());
                                }
                                z4 = true;
                            } else {
                                z4 = true;
                            }
                        } else {
                            str = str6;
                            jSONObject = jSONObject4;
                            i4 = iOptInt;
                            str2 = str9;
                            str3 = next;
                            str4 = str8;
                            z4 = true;
                            jSONObject6.put(str7, str2);
                        }
                        JSONObject jSONObject9 = jSONObject;
                        jSONObject9.put(str3, jSONObject6);
                        str9 = str2;
                        itKeys = it;
                        jSONObject3 = jSONObject5;
                        strOptString = str10;
                        strValueOf = str11;
                        iOptInt = i4;
                        str8 = str4;
                        jSONObject4 = jSONObject9;
                        str6 = str;
                    }
                }
                JSONArray jSONArray = new JSONArray();
                JSONObject jSONObject10 = new JSONObject();
                jSONObject10.put("3", jSONObject4);
                jSONObject10.put(str9, strValueOf);
                jSONObject10.put("5", strOptString);
                jSONObject10.put(str8, EngineImpl.getInstance(this.f8375b).getPropertyByType("mod"));
                jSONArray.put(jSONObject10);
                com.baidu.mshield.b.c.a.b("handleNativeCollect: upArray=" + jSONArray);
                d.b(this.f8375b, jSONArray, "1001159");
            } catch (Throwable th) {
                d.a(th);
            }
        }
    }

    public static void a(Context context) {
        try {
            com.baidu.mshield.x0.l.a aVar = new com.baidu.mshield.x0.l.a(context);
            String strC = aVar.c("plc115");
            com.baidu.mshield.b.c.a.b("handleCollectRoutine: policy=" + strC);
            if (TextUtils.isEmpty(strC)) {
                return;
            }
            JSONObject jSONObject = new JSONObject(strC);
            boolean z4 = true;
            if (jSONObject.optInt("1", 0) != 1) {
                z4 = false;
            }
            com.baidu.mshield.b.c.a.b("handleCollectRoutine: sw=" + z4);
            if (z4) {
                if (System.currentTimeMillis() - aVar.h() < jSONObject.optInt("3", 24) * 3600000) {
                    com.baidu.mshield.b.c.a.b("handleCollectRoutine not time");
                    return;
                }
                JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("5").optJSONObject("uv4");
                if (jSONObjectOptJSONObject != null) {
                    int iOptInt = jSONObjectOptJSONObject.optInt("3", 10);
                    if (!jSONObjectOptJSONObject.has("7") || jSONObjectOptJSONObject.optJSONObject("7").optInt("2", 0) == 0) {
                        f8373b = f8372a;
                    } else {
                        f8373b = jSONObjectOptJSONObject.optString("2");
                    }
                    if (TextUtils.isEmpty(f8373b)) {
                        return;
                    }
                    new Timer().schedule(new a(jSONObjectOptJSONObject, context), iOptInt * 1000);
                }
            }
        } catch (Throwable th) {
            d.a(th);
        }
    }
}
