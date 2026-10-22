package com.baidu.bbalbscesium;

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
import com.byted.cast.linkcommon.cybergarage.xml.XML;
import com.bytedance.mt.protector.impl.JSONArrayProtectorUtils;
import com.bytedance.mt.protector.impl.JSONObjectProtectorUtils;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import kotlin.UByte;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes39.dex */
public class d {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final String f30064c = "CuidBuddyInfoManager";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final boolean f30065d = false;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final String f30066e = "com.baidu.intent.action.GALAXY";

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final String f30067f = "galaxy_data";

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final String f30068g = "galaxy_sf";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private com.baidu.bbalbscesium.k.d.d f30069a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private List f30070b;

    class a implements Comparator {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ d f30071a;

        public a(d r100) {
            this.f30071a = r100;
        }

        public int a(c r100, c r101) {
            int r102 = r101.f30061b - r100.f30061b;
            if (r102 != 0) goto L17;
            boolean r103 = r100.f30063d;
            if (r103 == true) goto L7;
        L10:
            if (r103 == false) goto L14;
            return -1;
        L14:
            if (r101.f30063d == false) goto L17;
            return 1;
        L7:
            if (r101.f30063d == false) goto L10;
            return 0;
        L17:
            return r102;
        }

        @Override // java.util.Comparator
        public /* synthetic */ int compare(Object r100, Object r101) {
            return a((c) r100, (c) r101);
        }
    }

    public d() {
        a();
    }

    private static String a(byte[] r100) {
        if (r100 == null) goto L14;
        String r101 = "";
        int r102 = 0;
    L5:
        if (r102 >= r100.length) goto L12;
        String r103 = Integer.toHexString(r100[r102] & UByte.MAX_VALUE);
        if (r103.length() != 1) goto L9;
        StringBuilder r104 = new StringBuilder();
        r104.append(r101);
        r101 = "0";
    L10:
        r104.append(r101);
        r104.append(r103);
        r101 = r104.toString();
        r102 = r102 + 1;
        goto L5
    L9:
        r104 = new StringBuilder();
        goto L10
    L12:
        return r101.toLowerCase();
    L14:
        throw new IllegalArgumentException("Argument b ( byte array ) is null! ");
    }

    private void a() {
        this.f30069a = new com.baidu.bbalbscesium.k.d.e(e.a(), e.b());
    }

    private boolean a(String[] r100, String[] r101) {
        int r102 = 0;
        if (r100 == null) goto L16;
        if (r101 == null) goto L16;
        if (r100.length != r101.length) goto L16;
        HashSet r103 = new HashSet();
        int r104 = r100.length;
        int r105 = 0;
    L9:
        if (r105 >= r104) goto L11;
        r103.add(r100[r105]);
        r105 = r105 + 1;
        goto L9
    L11:
        HashSet r106 = new HashSet();
        int r107 = r101.length;
    L12:
        if (r102 >= r107) goto L15;
        r106.add(r101[r102]);
        r102 = r102 + 1;
        goto L12
    L15:
        return r103.equals(r106);
    L16:
        return false;
    }

    private static byte[] a(byte[] r100, com.baidu.bbalbscesium.k.d.d r101) throws Exception {
        com.baidu.bbalbscesium.k.d.a r102 = com.baidu.bbalbscesium.k.d.a.a();
        r102.a(2, r101);
        return r102.a(r100);
    }

    private String[] a(Signature[] r100) {
        int r101 = r100.length;
        String[] r102 = new String[r101];
        int r103 = 0;
    L3:
        if (r103 >= r101) goto L5;
        r102[r103] = a(com.baidu.bbalbscesium.m.d.a(r100[r103].toByteArray()));
        r103 = r103 + 1;
        goto L3
    L5:
        return r102;
    }

    public List a(Context r110, Intent r111, boolean r112) {
        ArrayList r100 = new ArrayList();
        PackageManager r101 = r110.getPackageManager();
        List<ResolveInfo> r102 = r101.queryBroadcastReceivers(r111, 0);
        if (r102 == null) goto L39;
        Iterator<ResolveInfo> r103 = r102.iterator();
    L6:
        if (r103.hasNext() == false) goto L39;
        ResolveInfo r104 = r103.next();
        ActivityInfo r105 = r104.activityInfo;
        if (r105 == null) goto L6;
        if (r105.applicationInfo == null) goto L6;
        ActivityInfo r106 = r104.activityInfo;     // Catch: Exception -> L38
        Bundle r107 = r101.getReceiverInfo(new ComponentName(r106.packageName, r106.name), 128).metaData;     // Catch: Exception -> L38
        if (r107 == null) goto L6;
        String r108 = r107.getString(f30067f);     // Catch: Exception -> L38
        if (TextUtils.isEmpty(r108) == true) goto L6;
        byte[] r109 = com.baidu.bbalbscesium.m.b.a(r108.getBytes(XML.CHARSET_UTF8));     // Catch: Exception -> L38
        JSONObject r113 = new JSONObject(new String(r109));     // Catch: Exception -> L38
        c r114 = new c();     // Catch: Exception -> L38
        r114.f30061b = JSONObjectProtectorUtils.getInt(r113, "priority");     // Catch: Exception -> L38
        r114.f30060a = r104.activityInfo.applicationInfo;     // Catch: Exception -> L38
        if (r110.getPackageName().equals(r104.activityInfo.applicationInfo.packageName) == false) goto L20;
        r114.f30063d = true;     // Catch: Exception -> L38
    L20:
        if (r112 == false) goto L36;
        String r115 = r107.getString(f30068g);     // Catch: Exception -> L38
        if (TextUtils.isEmpty(r115) == true) goto L36;
        PackageInfo r116 = r101.getPackageInfo(r104.activityInfo.applicationInfo.packageName, 64);     // Catch: Exception -> L38
        JSONArray r117 = JSONObjectProtectorUtils.getJSONArray(r113, "sigs");     // Catch: Exception -> L38
        int r118 = r117.length();     // Catch: Exception -> L38
        String[] r119 = new String[r118];     // Catch: Exception -> L38
        int r120 = 0;
    L24:
        if (r120 >= r118) goto L27;
        r119[r120] = JSONArrayProtectorUtils.getString(r117, r120);     // Catch: Exception -> L38
        r120 = r120 + 1;     // Catch: Exception -> L38
        goto L24
    L27:
        if (a(r119, a(r116.signatures)) == false) goto L36;
        byte[] r121 = a(com.baidu.bbalbscesium.m.b.a(r115.getBytes()), this.f30069a);     // Catch: Exception -> L38
        byte[] r122 = com.baidu.bbalbscesium.m.d.a(r109);     // Catch: Exception -> L38
        if (r121 != null) goto L31;
    L33:
        boolean r123 = false;
    L34:
        if (r123 == false) goto L36;
        r114.f30062c = true;     // Catch: Exception -> L38
        goto L36
    L31:
        if (Arrays.equals(r121, r122) == false) goto L33;
        r123 = true;
    L36:
        r100.add(r114);     // Catch: Exception -> L38
    L39:
        Collections.sort(r100, new a(this));
        return r100;
    }

    public boolean a(Context r100) {
        List r101 = a(r100, new Intent(f30066e).setPackage(r100.getPackageName()), true);
        int r102 = 0;
        if (r101 != null) goto L5;
    L12:
        int r103 = 0;
    L13:
        if (r103 >= 3) goto L18;
        r103 = r103 + 1;
        goto L13
    L18:
        return false;
    L5:
        if (r101.size() == 0) goto L12;
        boolean r104 = ((c) ListProtector.get(r101, 0)).f30062c;
        if (r104 == true) goto L15;
    L9:
        if (r102 >= 3) goto L15;
        r102 = r102 + 1;
    L15:
        return r104;
    }

    public List b(Context r100) {
        List r101 = this.f30070b;
        if (r101 == null) goto L5;
        return r101;
    L5:
        a(r100);
        List r102 = a(r100, new Intent(f30066e), true);
        this.f30070b = r102;
        return r102;
    }
}
