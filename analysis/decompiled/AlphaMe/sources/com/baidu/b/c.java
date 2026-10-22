package com.baidu.b;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.pm.Signature;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import androidx.room.AbstractC0351g;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import kotlin.UByte;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    private com.baidu.b.c.d.d f4792a;

    /* renamed from: b, reason: collision with root package name */
    private List f4793b;

    public c() {
        a();
    }

    private static String a(byte[] bArr) {
        if (bArr == null) {
            throw new IllegalArgumentException("Argument b ( byte array ) is null! ");
        }
        String strQ = "";
        for (byte b4 : bArr) {
            String hexString = Integer.toHexString(b4 & UByte.MAX_VALUE);
            strQ = hexString.length() == 1 ? AbstractC0351g.q(strQ, "0", hexString) : AbstractC0351g.p(strQ, hexString);
        }
        return strQ.toLowerCase();
    }

    public List b(Context context) {
        List list = this.f4793b;
        if (list != null) {
            return list;
        }
        a(context);
        List listA = a(context, new Intent("com.baidu.intent.action.GALAXY"), true);
        this.f4793b = listA;
        return listA;
    }

    public List a(Context context, Intent intent, boolean z4) throws JSONException, PackageManager.NameNotFoundException {
        ArrayList arrayList = new ArrayList();
        PackageManager packageManager = context.getPackageManager();
        List<ResolveInfo> listQueryBroadcastReceivers = packageManager.queryBroadcastReceivers(intent, 0);
        if (listQueryBroadcastReceivers != null) {
            for (ResolveInfo resolveInfo : listQueryBroadcastReceivers) {
                ActivityInfo activityInfo = resolveInfo.activityInfo;
                if (activityInfo != null && activityInfo.applicationInfo != null) {
                    try {
                        ActivityInfo activityInfo2 = resolveInfo.activityInfo;
                        Bundle bundle = packageManager.getReceiverInfo(new ComponentName(activityInfo2.packageName, activityInfo2.name), 128).metaData;
                        if (bundle != null) {
                            String string = bundle.getString("galaxy_data");
                            if (!TextUtils.isEmpty(string)) {
                                byte[] bArrA = com.baidu.b.d.a.a(string.getBytes("utf-8"));
                                JSONObject jSONObject = new JSONObject(new String(bArrA));
                                b bVar = new b();
                                bVar.f4733b = jSONObject.getInt("priority");
                                bVar.f4732a = resolveInfo.activityInfo.applicationInfo;
                                if (context.getPackageName().equals(resolveInfo.activityInfo.applicationInfo.packageName)) {
                                    bVar.f4735d = true;
                                }
                                if (z4) {
                                    String string2 = bundle.getString("galaxy_sf");
                                    if (!TextUtils.isEmpty(string2)) {
                                        PackageInfo packageInfo = packageManager.getPackageInfo(resolveInfo.activityInfo.applicationInfo.packageName, 64);
                                        JSONArray jSONArray = jSONObject.getJSONArray("sigs");
                                        int length = jSONArray.length();
                                        String[] strArr = new String[length];
                                        for (int i4 = 0; i4 < length; i4++) {
                                            strArr[i4] = jSONArray.getString(i4);
                                        }
                                        if (a(strArr, a(packageInfo.signatures))) {
                                            byte[] bArrA2 = a(com.baidu.b.d.a.a(string2.getBytes()), this.f4792a);
                                            byte[] bArrA3 = com.baidu.b.d.c.a(bArrA);
                                            if (bArrA2 != null && Arrays.equals(bArrA2, bArrA3)) {
                                                bVar.f4734c = true;
                                            }
                                        }
                                    }
                                }
                                arrayList.add(bVar);
                            }
                        }
                    } catch (Exception unused) {
                    }
                }
            }
        }
        Collections.sort(arrayList, new d(this));
        return arrayList;
    }

    private void a() {
        this.f4792a = new com.baidu.b.c.d.e(e.a(), e.b());
    }

    public boolean a(Context context) throws JSONException, PackageManager.NameNotFoundException {
        List listA = a(context, new Intent("com.baidu.intent.action.GALAXY").setPackage(context.getPackageName()), true);
        if (listA == null || listA.size() == 0) {
            for (int i4 = 0; i4 < 3; i4++) {
                Log.w("CuidBuddyInfoManager", "galaxy lib host missing meta-data,make sure you know the right way to integrate galaxy");
            }
            return false;
        }
        boolean z4 = ((b) listA.get(0)).f4734c;
        if (!z4) {
            for (int i5 = 0; i5 < 3; i5++) {
                Log.w("CuidBuddyInfoManager", "galaxy config err, In the release version of the signature should be matched");
            }
        }
        return z4;
    }

    private boolean a(String[] strArr, String[] strArr2) {
        if (strArr == null || strArr2 == null || strArr.length != strArr2.length) {
            return false;
        }
        HashSet hashSet = new HashSet();
        for (String str : strArr) {
            hashSet.add(str);
        }
        HashSet hashSet2 = new HashSet();
        for (String str2 : strArr2) {
            hashSet2.add(str2);
        }
        return hashSet.equals(hashSet2);
    }

    private static byte[] a(byte[] bArr, com.baidu.b.c.d.d dVar) throws Exception {
        com.baidu.b.c.d.a aVarA = com.baidu.b.c.d.a.a();
        aVarA.a(2, dVar);
        return aVarA.a(bArr);
    }

    private String[] a(Signature[] signatureArr) {
        int length = signatureArr.length;
        String[] strArr = new String[length];
        for (int i4 = 0; i4 < length; i4++) {
            strArr[i4] = a(com.baidu.b.d.c.a(signatureArr[i4].toByteArray()));
        }
        return strArr;
    }
}
