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
public class a extends b {

    /* renamed from: a, reason: collision with root package name */
    public static String f8368a = "";

    /* renamed from: com.baidu.mshield.x0.c.a$a, reason: collision with other inner class name */
    public static class C0038a extends TimerTask {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ JSONObject f8369a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Context f8370b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ com.baidu.mshield.x0.l.a f8371c;

        public C0038a(JSONObject jSONObject, Context context, com.baidu.mshield.x0.l.a aVar) {
            this.f8369a = jSONObject;
            this.f8370b = context;
            this.f8371c = aVar;
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            String str;
            String str2;
            int i4;
            String str3;
            String str4;
            String[] strArr;
            String str5;
            JSONObject jSONObject;
            String str6 = "4";
            String str7 = "7";
            String str8 = "1";
            try {
                int iOptInt = this.f8369a.optInt("1", 0);
                String strOptString = this.f8369a.optString("4", "");
                String strOptString2 = this.f8369a.optString("5", "");
                String strOptString3 = this.f8369a.optString("6", "");
                int iOptInt2 = this.f8369a.has("7") ? this.f8369a.optJSONObject("7").optInt("1", 1) : 0;
                String strValueOf = String.valueOf(System.currentTimeMillis());
                com.baidu.mshield.b.c.a.b("detect app encryptStr====" + a.f8368a);
                String strB = com.baidu.xclient.gdid.a.b(a.f8368a);
                com.baidu.mshield.b.c.a.b("detect app decryptStr====" + strB);
                JSONObject jSONObject2 = !TextUtils.isEmpty(strB) ? new JSONObject(strB) : new JSONObject();
                JSONObject jSONObject3 = new JSONObject();
                String str9 = "8";
                String str10 = "0";
                if (jSONObject2.length() > 0) {
                    Iterator<String> itKeys = jSONObject2.keys();
                    while (itKeys.hasNext()) {
                        Iterator<String> it = itKeys;
                        String next = itKeys.next();
                        String str11 = strOptString;
                        JSONObject jSONObjectOptJSONObject = jSONObject2.optJSONObject(next);
                        JSONObject jSONObject4 = jSONObject2;
                        String strOptString4 = jSONObjectOptJSONObject.optString("p");
                        String str12 = strValueOf;
                        JSONObject jSONObjectOptJSONObject2 = jSONObjectOptJSONObject.optJSONObject("f");
                        JSONObject jSONObject5 = new JSONObject();
                        JSONObject jSONObject6 = jSONObject3;
                        PackageInfo packageInfoB = b.b(this.f8370b, strOptString4);
                        if (packageInfoB != null) {
                            str2 = next;
                            if (iOptInt == 1) {
                                i4 = iOptInt;
                                jSONObject5.put(str10, e.a(new File(packageInfoB.applicationInfo.sourceDir)));
                            } else {
                                i4 = iOptInt;
                            }
                            jSONObject5.put(str8, str8);
                            if (b.c(this.f8370b, strOptString4)) {
                                jSONObject5.put(str6, str8);
                            } else {
                                jSONObject5.put(str6, str10);
                            }
                            ArrayList arrayList = new ArrayList();
                            JSONObject jSONObject7 = new JSONObject();
                            str = str6;
                            if (jSONObjectOptJSONObject2 != null) {
                                Iterator<String> itKeys2 = jSONObjectOptJSONObject2.keys();
                                while (itKeys2.hasNext()) {
                                    int i5 = iOptInt2;
                                    StringBuffer stringBuffer = new StringBuffer();
                                    String str13 = str10;
                                    String next2 = itKeys2.next();
                                    String str14 = str8;
                                    String strOptString5 = jSONObjectOptJSONObject2.optString(next2);
                                    if (TextUtils.isEmpty(strOptString5)) {
                                        iOptInt2 = i5;
                                        str8 = str14;
                                        str10 = str13;
                                    } else {
                                        String str15 = str9;
                                        if (new File(strOptString5).exists()) {
                                            String[] strArrA = com.baidu.mshield.b.a.b.a(strOptString5);
                                            jSONObject = jSONObjectOptJSONObject2;
                                            stringBuffer.append(strArrA[0]);
                                            stringBuffer.append("#");
                                            str5 = str7;
                                            stringBuffer.append(strArrA[1]);
                                            stringBuffer.append("#");
                                            stringBuffer.append(strArrA[2]);
                                            stringBuffer.append("#");
                                            stringBuffer.append(strArrA[3]);
                                        } else {
                                            str5 = str7;
                                            jSONObject = jSONObjectOptJSONObject2;
                                        }
                                        arrayList.add(strOptString5);
                                        jSONObject7.put(next2, stringBuffer.toString());
                                        iOptInt2 = i5;
                                        str8 = str14;
                                        str10 = str13;
                                        str9 = str15;
                                        jSONObjectOptJSONObject2 = jSONObject;
                                        str7 = str5;
                                    }
                                }
                            }
                            String str16 = str8;
                            JSONObject jSONObject8 = jSONObjectOptJSONObject2;
                            String str17 = str10;
                            String str18 = str9;
                            int i6 = iOptInt2;
                            jSONObject5.put("3", String.valueOf(b.a(this.f8370b, strOptString4, arrayList)));
                            jSONObject5.put("5", jSONObject7.toString());
                            jSONObject5.put("6", packageInfoB.firstInstallTime);
                            str7 = str7;
                            jSONObject5.put(str7, packageInfoB.lastUpdateTime);
                            if (jSONObject8 == null || jSONObject8.length() <= 0) {
                                str8 = str16;
                                str4 = str18;
                                str3 = str17;
                                jSONObject5.put(str4, str3);
                            } else {
                                str8 = str16;
                                str4 = str18;
                                jSONObject5.put(str4, str8);
                                str3 = str17;
                            }
                            jSONObject5.put("9", packageInfoB.versionName);
                            iOptInt2 = i6;
                            if (iOptInt2 == 1) {
                                String[] strArrA2 = b.a(this.f8370b, strOptString4);
                                int i7 = 0;
                                while (i7 < strArrA2.length) {
                                    String str19 = strArrA2[i7];
                                    StringBuffer stringBuffer2 = new StringBuffer();
                                    if (TextUtils.isEmpty(str19)) {
                                        strArr = strArrA2;
                                    } else {
                                        String[] strArrA3 = com.baidu.mshield.b.a.b.a(str19);
                                        strArr = strArrA2;
                                        stringBuffer2.append(strArrA3[0]);
                                        stringBuffer2.append("#");
                                        stringBuffer2.append(strArrA3[1]);
                                        stringBuffer2.append("#");
                                        stringBuffer2.append(strArrA3[2]);
                                        stringBuffer2.append("#");
                                        stringBuffer2.append(strArrA3[3]);
                                    }
                                    jSONObject5.put(String.valueOf(i7 + 10), stringBuffer2.toString());
                                    i7++;
                                    strArrA2 = strArr;
                                }
                            }
                        } else {
                            str = str6;
                            str2 = next;
                            i4 = iOptInt;
                            str3 = str10;
                            str4 = str9;
                            jSONObject5.put(str8, str3);
                        }
                        jSONObject6.put(str2, jSONObject5);
                        jSONObject3 = jSONObject6;
                        str9 = str4;
                        str10 = str3;
                        strOptString = str11;
                        itKeys = it;
                        jSONObject2 = jSONObject4;
                        strValueOf = str12;
                        iOptInt = i4;
                        str6 = str;
                    }
                }
                JSONObject jSONObject9 = jSONObject3;
                String str20 = strOptString;
                JSONArray jSONArray = new JSONArray();
                JSONObject jSONObject10 = new JSONObject();
                jSONObject10.put("3", jSONObject9);
                jSONObject10.put(str10, strValueOf);
                jSONObject10.put("5", str20);
                jSONObject10.put("6", strOptString2);
                jSONObject10.put(str7, strOptString3);
                jSONObject10.put(str9, EngineImpl.getInstance(this.f8370b).getPropertyByType("mod"));
                jSONArray.put(jSONObject10);
                com.baidu.mshield.b.c.a.b("handleNativeCollect: upArray=" + jSONArray);
                d.b(this.f8370b, jSONArray, "1001159");
                StringBuffer stringBuffer3 = new StringBuffer();
                stringBuffer3.append(str20);
                stringBuffer3.append("_");
                stringBuffer3.append(strOptString2);
                stringBuffer3.append("_");
                stringBuffer3.append(strOptString3);
                this.f8371c.f(stringBuffer3.toString());
                a.f8368a = "";
            } catch (Throwable th) {
                d.a(th);
            }
        }
    }

    public static void a(Context context) {
        JSONObject jSONObjectOptJSONObject;
        try {
            com.baidu.mshield.x0.l.a aVar = new com.baidu.mshield.x0.l.a(context);
            String strC = aVar.c("plc114");
            com.baidu.mshield.b.c.a.b("handleNativeCollect: policy=" + strC);
            if (TextUtils.isEmpty(strC)) {
                return;
            }
            JSONObject jSONObject = new JSONObject(strC);
            boolean z4 = jSONObject.optInt("1", 0) == 1;
            com.baidu.mshield.b.c.a.b("handleNativeCollect: sw=" + z4);
            if (z4 && (jSONObjectOptJSONObject = jSONObject.optJSONObject("5").optJSONObject("uv6")) != null) {
                com.baidu.mshield.b.c.a.b("detect app encrypt===" + f8368a);
                int iOptInt = jSONObjectOptJSONObject.optInt("3", 10);
                if (TextUtils.isEmpty(f8368a)) {
                    return;
                }
                new Timer().schedule(new C0038a(jSONObjectOptJSONObject, context, aVar), iOptInt * 1000);
            }
        } catch (Throwable th) {
            d.a(th);
        }
    }
}
