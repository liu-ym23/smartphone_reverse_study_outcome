package com.amap.api.fence;

import android.app.PendingIntent;
import android.content.Context;
import android.os.Bundle;
import com.amap.api.location.AMapLocationClientOption;
import com.amap.api.location.DPoint;
import java.util.ArrayList;
import java.util.List;
import n4a.a;
import n4a.c4;

/* JADX INFO: loaded from: classes28.dex */
public class GeoFenceClient {
    public static final int GEOFENCE_IN = 1;
    public static final int GEOFENCE_OUT = 2;
    public static final int GEOFENCE_STAYED = 4;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    Context f26677a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    a f26678b;

    public GeoFenceClient(Context r100) {
        this.f26677a = null;
        this.f26678b = null;
        if (r100 == null) goto L9;
        Context r101 = r100.getApplicationContext();     // Catch: Throwable -> L6
        this.f26677a = r101;     // Catch: Throwable -> L6
        this.f26678b = a(r101);     // Catch: Throwable -> L6
        return;
    L9:
        throw new IllegalArgumentException("Context参数不能为null");     // Catch: Throwable -> L6
    L6:
        th = move-exception;
        c4.g(th, "GeoFenceClient", "<init>");
    }

    private static a a(Context r100) {
        return new a(r100);
    }

    public void addGeoFence(String r100, String r101, DPoint r110, float r111, int r112, String r113) {
        this.f26678b.l(r100, r101, r110, r111, r112, r113);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        c4.g(th, "GeoFenceClient", "addGeoFence searche");
    }

    public void addGeoFence(String r100, String r101, String r102, int r110, String r111) {
        this.f26678b.m(r100, r101, r102, r110, r111);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        c4.g(th, "GeoFenceClient", "addGeoFence searche");
    }

    public PendingIntent createPendingIntent(String r100) {
        return this.f26678b.d(r100);
    L4:
        th = move-exception;
        c4.g(th, "GeoFenceClient", "creatPendingIntent");
        return null;
    }

    public boolean removeGeoFence(GeoFence r100) {
        return this.f26678b.o(r100);
    L4:
        th = move-exception;
        c4.g(th, "GeoFenceClient", "removeGeoFence1");
        return false;
    }

    public List<GeoFence> getAllGeoFence() {
        ArrayList r100 = new ArrayList();
        a r101 = this.f26678b;     // Catch: Throwable -> L11
        r101.getClass();     // Catch: Throwable -> L11
    L9:
        ArrayList r102 = new ArrayList();     // Catch: Throwable -> L11
    L17:
        return r102;
    L5:
        if (r101.f517111h != null) goto L7;
        r101.f517111h = new ArrayList();     // Catch: Throwable -> L9
    L7:
        r102 = (ArrayList) r101.f517111h.clone();     // Catch: Throwable -> L9
    L11:
        th = move-exception;
        c4.g(th, "GeoFenceClient", "getGeoFenceList");
        return r100;
    }

    public boolean isPause() {
        return this.f26678b.f517128y;
    L4:
        th = move-exception;
        c4.g(th, "GeoFenceClient", "isPause");
        return true;
    }

    public void pauseGeoFence() {
        a r100 = this.f26678b;     // Catch: Throwable -> L9
        r100.getClass();     // Catch: Throwable -> L9
        r100.F();     // Catch: Throwable -> L6
        r100.f517128y = true;     // Catch: Throwable -> L6
        r100.h(13, null, 0);     // Catch: Throwable -> L6
    L16:
        return;
    L6:
        th = move-exception;
        c4.g(th, "GeoFenceManager", "pauseGeoFence");     // Catch: Throwable -> L9
        return;
    L9:
        th = move-exception;
        c4.g(th, "GeoFenceClient", "pauseGeoFence");
    }

    public void removeGeoFence() {
        a r100 = this.f26678b;     // Catch: Throwable -> L10
        r100.getClass();     // Catch: Throwable -> L10
        r100.f517119p = false;     // Catch: Throwable -> L7
        r100.h(10, null, 0);     // Catch: Throwable -> L7
    L17:
        return;
    L7:
        th = move-exception;
        c4.g(th, "GeoFenceManager", "removeGeoFence");     // Catch: Throwable -> L10
        return;
    L10:
        th = move-exception;
        c4.g(th, "GeoFenceClient", "removeGeoFence");
    }

    public void resumeGeoFence() {
        a r100 = this.f26678b;     // Catch: Throwable -> L11
        r100.getClass();     // Catch: Throwable -> L11
        r100.F();     // Catch: Throwable -> L8
        if (r100.f517128y == false) goto L18;
        r100.f517128y = false;     // Catch: Throwable -> L8
        r100.J();     // Catch: Throwable -> L8
    L19:
        return;
    L18:
        return;
    L8:
        th = move-exception;
        c4.g(th, "GeoFenceManager", "resumeGeoFence");     // Catch: Throwable -> L11
        return;
    L11:
        th = move-exception;
        c4.g(th, "GeoFenceClient", "resumeGeoFence");
    }

    public void setActivateAction(int r100) {
        a r101 = this.f26678b;     // Catch: Throwable -> L12
        r101.getClass();     // Catch: Throwable -> L12
        r101.F();     // Catch: Throwable -> L9
        if (r100 > 7) goto L6;
        if (r100 <= 0) goto L6;
    L7:
        Bundle r102 = new Bundle();     // Catch: Throwable -> L9
        r102.putInt("activatesAction", r100);     // Catch: Throwable -> L9
        r101.h(9, r102, 0);     // Catch: Throwable -> L9
    L19:
        return;
    L6:
        r100 = 1;
    L9:
        th = move-exception;
        c4.g(th, "GeoFenceManager", "setActivateAction");     // Catch: Throwable -> L12
        return;
    L12:
        th = move-exception;
        c4.g(th, "GeoFenceClient", "setActivatesAction");
    }

    public void setGeoFenceListener(GeoFenceListener r100) {
        a r101 = this.f26678b;     // Catch: Throwable -> L5
        r101.getClass();     // Catch: Throwable -> L5
        r101.f517108e = r100;     // Catch: Throwable -> L8
        return;
    L13:
        return;
    L5:
        th = move-exception;
        c4.g(th, "GeoFenceClient", "setGeoFenceListener");
    }

    public void setLocationClientOption(AMapLocationClientOption r100) {
        a r101 = this.f26678b;     // Catch: Throwable -> L5
        r101.getClass();     // Catch: Throwable -> L5
        r101.f517125v = r100.clone();     // Catch: Throwable -> L8
        return;
    L13:
        return;
    L5:
        th = move-exception;
        c4.g(th, "GeoFenceClient", "setGeoFenceListener");
    }

    public void addGeoFence(List<DPoint> r100, String r101) {
        a r102 = this.f26678b;     // Catch: Throwable -> L8
        r102.getClass();     // Catch: Throwable -> L8
        r102.F();     // Catch: Throwable -> L5
        Bundle r103 = new Bundle();     // Catch: Throwable -> L5
        r103.putParcelableArrayList("pointList", new ArrayList(r100));     // Catch: Throwable -> L5
        r103.putString(GeoFence.BUNDLE_KEY_CUSTOMID, r101);     // Catch: Throwable -> L5
        r102.h(1, r103, 0);     // Catch: Throwable -> L5
    L15:
        return;
    L5:
        th = move-exception;
        c4.g(th, "GeoFenceManager", "addPolygonGeoFence");     // Catch: Throwable -> L8
        return;
    L8:
        th = move-exception;
        c4.g(th, "GeoFenceClient", "addGeoFence polygon");
    }

    public void setGeoFenceAble(String r100, boolean r101) {
        a r102 = this.f26678b;     // Catch: Throwable -> L9
        r102.getClass();     // Catch: Throwable -> L9
        r102.F();     // Catch: Throwable -> L6
        Bundle r103 = new Bundle();     // Catch: Throwable -> L6
        r103.putString("fid", r100);     // Catch: Throwable -> L6
        r103.putBoolean("ab", r101);     // Catch: Throwable -> L6
        r102.h(12, r103, 0);     // Catch: Throwable -> L6
    L16:
        return;
    L6:
        th = move-exception;
        c4.g(th, "GeoFenceManager", "setGeoFenceAble");     // Catch: Throwable -> L9
        return;
    L9:
        th = move-exception;
        c4.g(th, "GeoFenceClient", "setGeoFenceAble");
    }

    public void addGeoFence(String r100, String r101) {
        a r102 = this.f26678b;     // Catch: Throwable -> L8
        r102.getClass();     // Catch: Throwable -> L8
        r102.F();     // Catch: Throwable -> L5
        Bundle r103 = new Bundle();     // Catch: Throwable -> L5
        r103.putString("keyWords", r100);     // Catch: Throwable -> L5
        r103.putString(GeoFence.BUNDLE_KEY_CUSTOMID, r101);     // Catch: Throwable -> L5
        r102.h(4, r103, 0);     // Catch: Throwable -> L5
    L14:
        return;
    L5:
        th = move-exception;
        c4.g(th, "GeoFenceManager", "addDistricetGeoFence");     // Catch: Throwable -> L8
        return;
    L8:
        th = move-exception;
        c4.g(th, "GeoFenceClient", "addGeoFence district");
    }

    public void addGeoFence(DPoint r100, float r101, String r102) {
        a r103 = this.f26678b;     // Catch: Throwable -> L8
        r103.getClass();     // Catch: Throwable -> L8
        r103.F();     // Catch: Throwable -> L5
        Bundle r104 = new Bundle();     // Catch: Throwable -> L5
        r104.putParcelable("centerPoint", r100);     // Catch: Throwable -> L5
        r104.putFloat("fenceRadius", r101);     // Catch: Throwable -> L5
        r104.putString(GeoFence.BUNDLE_KEY_CUSTOMID, r102);     // Catch: Throwable -> L5
        r103.h(0, r104, 0);     // Catch: Throwable -> L5
    L15:
        return;
    L5:
        th = move-exception;
        c4.g(th, "GeoFenceManager", "addRoundGeoFence");     // Catch: Throwable -> L8
        return;
    L8:
        th = move-exception;
        c4.g(th, "GeoFenceClient", "addGeoFence round");
    }
}
