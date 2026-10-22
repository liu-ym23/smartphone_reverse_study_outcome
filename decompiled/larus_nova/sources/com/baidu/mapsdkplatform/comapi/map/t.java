package com.baidu.mapsdkplatform.comapi.map;

import android.text.TextUtils;
import com.baidu.mapapi.model.CoordUtil;
import com.baidu.mapapi.model.LatLng;
import com.baidu.mapsdkplatform.comapi.util.AlgorithmUtil;
import com.baidu.mapsdkplatform.comapi.util.SyncSysInfo;
import com.baidu.mapsdkplatform.comjni.tools.JNITools;
import com.baidu.platform.comapi.basestruct.GeoPoint;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.mt.protector.impl.string2number.CastDoubleProtector;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes39.dex */
public class t {
    public t() {
    }

    private ArrayList<LatLng> a(String r110) {
        if (TextUtils.isEmpty(r110) == false) goto L5;
        return null;
    L5:
        ArrayList<LatLng> r100 = new ArrayList();
        String[] r111 = r110.split("\\|");
        int r101 = r111.length;
        int r102 = 0;
    L6:
        if (r102 >= r101) goto L13;
        String[] r103 = r111[r102].split(",");
        String r104 = r103[0];
        String r105 = r103[1];
        r100.add(new LatLng(CastIntegerProtector.parseInt(r104) / 1000000.0f, CastIntegerProtector.parseInt(r105) / 1000000.0f));
        r102 = r102 + 1;
    L10:
        e = move-exception;
        e.printStackTrace();
        return null;
    L13:
        return r100;
    }

    private String c(String r100) {
        String r101 = SyncSysInfo.getAuthToken();
        if (TextUtils.isEmpty(r101) == false) goto L5;
        return null;
    L5:
        String r102 = JNITools.getAESSaltKey(r101);
        String r103 = JNITools.getAESViKey(r101);
        if (TextUtils.isEmpty(r102) == false) goto L8;
    L14:
        return null;
    L8:
        if (TextUtils.isEmpty(r103) == true) goto L14;
        if (TextUtils.isEmpty(r100) == true) goto L14;
        return new String(AlgorithmUtil.getDecryptInfo(r103, r102, g(r100))).trim();
    }

    private byte[] f(String r100) {
        int r101 = 0;
        if (r100 == null) goto L12;
        if (r100.length() < 2) goto L12;
        int r102 = r100.length() / 2;
        byte[] r103 = new byte[r102];
    L8:
        if (r101 >= r102) goto L10;
        int r104 = r101 * 2;
        r103[r101] = (byte) (CastIntegerProtector.parseInt(r100.substring(r104, r104 + 2), 16) & 255);
        r101 = r101 + 1;
        goto L8
    L10:
        return r103;
    L12:
        return new byte[0];
    }

    private byte[] g(String r100) {
        int r101 = r100.length() / 2;
        byte[] r102 = new byte[r101];
        int r103 = 0;
    L3:
        if (r103 >= r101) goto L5;
        int r104 = r103 * 2;
        int r105 = r104 + 1;
        int r106 = CastIntegerProtector.parseInt(r100.substring(r104, r105), 16);
        int r107 = r106 * 16;
        r102[r103] = (byte) (r107 + CastIntegerProtector.parseInt(r100.substring(r105, r104 + 2), 16));
        r103 = r103 + 1;
        goto L3
    L5:
        return r102;
    }

    public ArrayList<LatLng> b(String r100) {
        String r101 = c(r100);
        ArrayList<LatLng> r102 = new ArrayList();
        if (TextUtils.isEmpty(r101) == true) goto L15;
        String[] r103 = r101.split("\\|");
        int r104 = 0;
    L6:
        if (r104 >= r103.length) goto L15;
        String[] r105 = r103[r104].split(",");
        if (r105.length != 2) goto L14;
        String r106 = r105[0];
        String r107 = r105[1];
        double r108 = CastDoubleProtector.parseDouble(r106);     // Catch: NumberFormatException -> L12
        r102.add(CoordUtil.mc2llDirect(new GeoPoint(CastDoubleProtector.parseDouble(r107), r108)));     // Catch: NumberFormatException -> L12
    L12:
        e = move-exception;
        e.printStackTrace();
    L14:
        r104 = r104 + 1;
    L15:
        return r102;
    }

    public ArrayList<LatLng> d(String r100) {
        String r101 = c(r100);
        ArrayList<LatLng> r102 = new ArrayList();
        if (TextUtils.isEmpty(r101) == true) goto L15;
        String[] r103 = r101.split(com.alipay.sdk.m.u.i.f25853b);
        int r104 = 0;
    L6:
        if (r104 >= r103.length) goto L15;
        String[] r105 = r103[r104].split(",");
        if (r105.length != 2) goto L14;
        String r106 = r105[0];
        String r107 = r105[1];
        double r108 = CastDoubleProtector.parseDouble(r106);     // Catch: NumberFormatException -> L12
        r102.add(new LatLng(CastDoubleProtector.parseDouble(r107), r108));     // Catch: NumberFormatException -> L12
    L12:
        e = move-exception;
        e.printStackTrace();
    L14:
        r104 = r104 + 1;
    L15:
        return r102;
    }

    public ArrayList<LatLng> e(String r100) {
        ArrayList<LatLng> r101 = a(new String(JNITools.decryptPNKD(f(r100)), StandardCharsets.UTF_8));
        if (r101 != null) goto L7;
        return null;
    L7:
        return a(r101);
    }

    private ArrayList<LatLng> a(List<LatLng> r110) {
        ArrayList<LatLng> r100 = new ArrayList();
        ListProtector.add(r100, 0, ListProtector.get(r110, 0));
        int r101 = r110.size();
        int r102 = 1;
    L3:
        if (r102 >= r101) goto L5;
        int r103 = r102 - 1;
        r100.add(new LatLng(((LatLng) ListProtector.get(r100, r103)).latitude + ((LatLng) ListProtector.get(r110, r102)).latitude, ((LatLng) ListProtector.get(r100, r103)).longitude + ((LatLng) ListProtector.get(r110, r102)).longitude));
        r102 = r102 + 1;
        goto L3
    L5:
        return r100;
    }
}
