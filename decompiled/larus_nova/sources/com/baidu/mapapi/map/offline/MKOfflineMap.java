package com.baidu.mapapi.map.offline;

import com.baidu.mapsdkplatform.comapi.map.e;
import com.baidu.mapsdkplatform.comapi.map.j;
import com.baidu.mapsdkplatform.comapi.map.k;
import com.baidu.mapsdkplatform.comapi.map.l;
import com.baidu.mapsdkplatform.comapi.map.m;
import com.baidu.mapsdkplatform.comapi.map.n;
import com.baidu.platform.comapi.logstatistics.SDKLogFactory;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

/* JADX INFO: loaded from: classes39.dex */
public class MKOfflineMap {
    public static final int TYPE_DOWNLOAD_UPDATE = 0;
    public static final int TYPE_NETWORK_ERROR = 2;
    public static final int TYPE_NEW_OFFLINE = 6;
    public static final int TYPE_VER_UPDATE = 4;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private k f31621a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private MKOfflineMapListener f31622b;

    public class a implements n {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ MKOfflineMap f31623a;

        public a(MKOfflineMap r100) {
            this.f31623a = r100;
        }

        @Override // com.baidu.mapsdkplatform.comapi.map.n
        public void a(int r100, int r101) {
            if (r100 != 4) goto L5;
            ArrayList<MKOLUpdateElement> r102 = this.f31623a.getAllUpdateInfo();
            if (r102 == null) goto L34;
            Iterator<MKOLUpdateElement> r103 = r102.iterator();
        L21:
            if (r103.hasNext() == false) goto L36;
            MKOLUpdateElement r104 = r103.next();
            if (r104.update == false) goto L21;
            MKOfflineMap.b(this.f31623a).onGetOfflineMapState(4, r104.cityID);
            goto L21
        L36:
            return;
        L34:
            return;
        L5:
            if (r100 != 6) goto L7;
            MKOfflineMap.b(this.f31623a).onGetOfflineMapState(6, r101);
            return;
        L7:
            if (r100 != 8) goto L9;
            int r105 = r101 >> 8;
            MKOfflineMap.b(this.f31623a).onGetOfflineMapState(0, r105);
            return;
        L9:
            if (r100 != 10) goto L11;
            MKOfflineMap.b(this.f31623a).onGetOfflineMapState(2, r101);
            return;
        L11:
            if (r100 != 12) goto L35;
            MKOfflineMap.a(this.f31623a).a(true, false);
            return;
        }
    }

    public int importOfflineData() {
        return importOfflineData(false);
    }

    public ArrayList<MKOLUpdateElement> getAllUpdateInfo() {
        ArrayList<m> r100 = this.f31621a.d();
        if (r100 != null) goto L6;
        return null;
    L6:
        ArrayList<MKOLUpdateElement> r101 = new ArrayList();
        Iterator<m> r102 = r100.iterator();
    L8:
        if (r102.hasNext() == false) goto L10;
        r101.add(OfflineMapUtil.getUpdatElementFromLocalMapElement(r102.next().a()));
        goto L8
    L10:
        return r101;
    }

    public ArrayList<MKOLSearchRecord> getHotCityList() {
        ArrayList<j> r100 = this.f31621a.e();
        if (r100 != null) goto L6;
        return null;
    L6:
        ArrayList<MKOLSearchRecord> r101 = new ArrayList();
        Iterator<j> r102 = r100.iterator();
    L8:
        if (r102.hasNext() == false) goto L10;
        r101.add(OfflineMapUtil.getSearchRecordFromLocalCityInfo(r102.next()));
        goto L8
    L10:
        return r101;
    }

    public ArrayList<MKOLSearchRecord> getOfflineCityList() {
        ArrayList<j> r100 = this.f31621a.c();
        if (r100 != null) goto L6;
        return null;
    L6:
        ArrayList<MKOLSearchRecord> r101 = new ArrayList();
        Iterator<j> r102 = r100.iterator();
    L8:
        if (r102.hasNext() == false) goto L10;
        r101.add(OfflineMapUtil.getSearchRecordFromLocalCityInfo(r102.next()));
        goto L8
    L10:
        return r101;
    }

    public void destroy() {
        SDKLogFactory.getLogUsrActStatistics().addLogWithLowLevel("B", "OFF", "1", null);
        this.f31621a.f(0);
        this.f31621a.b(null);
        this.f31621a.b();
        e.a();
    }

    public MKOfflineMap() {
    }

    public static /* synthetic */ k a(MKOfflineMap r100) {
        return r100.f31621a;
    }

    public static /* synthetic */ MKOfflineMapListener b(MKOfflineMap r100) {
        return r100.f31622b;
    }

    public MKOLUpdateElement getUpdateInfo(int r100) {
        m r101 = this.f31621a.b(r100);
        if (r101 != null) goto L7;
        return null;
    L7:
        return OfflineMapUtil.getUpdatElementFromLocalMapElement(r101.a());
    }

    public int importOfflineData(boolean r100) {
        ArrayList<m> r101 = this.f31621a.d();
        if (r101 == null) goto L5;
        int r102 = r101.size();
        int r103 = r102;
    L6:
        this.f31621a.a(r100, true);
        ArrayList<m> r104 = this.f31621a.d();
        if (r104 == null) goto L10;
        r102 = r104.size();
    L10:
        return r102 - r103;
    L5:
        r102 = 0;
        r103 = 0;
        goto L6
    }

    public boolean init(MKOfflineMapListener r100) {
        e.c();
        k r101 = k.f();
        this.f31621a = r101;
        if (r101 != null) goto L6;
        return false;
    L6:
        r101.a(new a(this));
        this.f31622b = r100;
        SDKLogFactory.getLogUsrActStatistics().addLogWithLowLevel("B", "OFF", "0", null);
        return true;
    }

    public boolean pause(int r100) {
        HashMap r101 = new HashMap();
        r101.put("I", Integer.valueOf(r100));
        SDKLogFactory.getLogUsrActStatistics().addLogWithLowLevel("B", "OFF", "4", r101);
        return this.f31621a.e(r100);
    }

    public boolean remove(int r100) {
        HashMap r101 = new HashMap();
        r101.put("I", Integer.valueOf(r100));
        SDKLogFactory.getLogUsrActStatistics().addLogWithLowLevel("B", "OFF", "5", r101);
        return this.f31621a.c(r100);
    }

    public ArrayList<MKOLSearchRecord> searchCity(String r100) {
        ArrayList<j> r101 = this.f31621a.a(r100);
        if (r101 != null) goto L6;
        return null;
    L6:
        ArrayList<MKOLSearchRecord> r102 = new ArrayList();
        Iterator<j> r103 = r101.iterator();
    L8:
        if (r103.hasNext() == false) goto L10;
        r102.add(OfflineMapUtil.getSearchRecordFromLocalCityInfo(r103.next()));
        goto L8
    L10:
        return r102;
    }

    public boolean start(int r100) {
        HashMap r101 = new HashMap();
        if (this.f31621a != null) goto L6;
        r101.put("I", "null");
        SDKLogFactory.getLogUsrActStatistics().addLogWithLowLevel("B", "OFF", "2", r101);
        return false;
    L6:
        r101.put("I", Integer.valueOf(r100));
        SDKLogFactory.getLogUsrActStatistics().addLogWithLowLevel("B", "OFF", "2", r101);
        if (this.f31621a.d() == null) goto L26;
        Iterator<m> r102 = this.f31621a.d().iterator();
    L10:
        if (r102.hasNext() == false) goto L26;
        l r103 = r102.next().f32182a;
        if (r103.f32170a != r100) goto L10;
        if (r103.f32179j == true) goto L24;
        int r104 = r103.f32181l;
        if (r104 == 2) goto L24;
        if (r104 == 3) goto L24;
        if (r104 == 6) goto L24;
        return false;
    L24:
        return this.f31621a.d(r100);
    L26:
        return this.f31621a.a(r100);
    }

    public boolean update(int r100) {
        HashMap r101 = new HashMap();
        if (this.f31621a != null) goto L6;
        r101.put("I", "null");
        SDKLogFactory.getLogUsrActStatistics().addLogWithLowLevel("B", "OFF", "3", r101);
        return false;
    L6:
        r101.put("I", Integer.valueOf(r100));
        SDKLogFactory.getLogUsrActStatistics().addLogWithLowLevel("B", "OFF", "3", r101);
        if (this.f31621a.d() == null) goto L17;
        Iterator<m> r102 = this.f31621a.d().iterator();
    L10:
        if (r102.hasNext() == false) goto L17;
        l r103 = r102.next().f32182a;
        if (r103.f32170a != r100) goto L10;
        if (r103.f32179j == false) goto L17;
        return this.f31621a.g(r100);
    L17:
        return false;
    }
}
