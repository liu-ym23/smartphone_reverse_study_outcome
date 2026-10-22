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
import org.json.JSONException;

/* loaded from: classes.dex */
public class MKOfflineMap {
    public static final int TYPE_DOWNLOAD_UPDATE = 0;
    public static final int TYPE_NETWORK_ERROR = 2;
    public static final int TYPE_NEW_OFFLINE = 6;
    public static final int TYPE_VER_UPDATE = 4;

    /* renamed from: a, reason: collision with root package name */
    private k f7186a;

    /* renamed from: b, reason: collision with root package name */
    private MKOfflineMapListener f7187b;

    public class a implements n {
        public a() {
        }

        @Override // com.baidu.mapsdkplatform.comapi.map.n
        public void a(int i4, int i5) {
            if (i4 == 4) {
                ArrayList<MKOLUpdateElement> allUpdateInfo = MKOfflineMap.this.getAllUpdateInfo();
                if (allUpdateInfo != null) {
                    for (MKOLUpdateElement mKOLUpdateElement : allUpdateInfo) {
                        if (mKOLUpdateElement.update) {
                            MKOfflineMap.this.f7187b.onGetOfflineMapState(4, mKOLUpdateElement.cityID);
                        }
                    }
                    return;
                }
                return;
            }
            if (i4 == 6) {
                MKOfflineMap.this.f7187b.onGetOfflineMapState(6, i5);
                return;
            }
            if (i4 == 8) {
                MKOfflineMap.this.f7187b.onGetOfflineMapState(0, i5 >> 8);
            } else if (i4 == 10) {
                MKOfflineMap.this.f7187b.onGetOfflineMapState(2, i5);
            } else {
                if (i4 != 12) {
                    return;
                }
                MKOfflineMap.this.f7186a.a(true, false);
            }
        }
    }

    public void destroy() {
        SDKLogFactory.getLogUsrActStatistics().addLogWithLowLevel("B", "OFF", "1", null);
        this.f7186a.f(0);
        this.f7186a.b((n) null);
        this.f7186a.b();
        e.a();
    }

    public ArrayList<MKOLUpdateElement> getAllUpdateInfo() {
        ArrayList<m> arrayListD = this.f7186a.d();
        if (arrayListD == null) {
            return null;
        }
        ArrayList<MKOLUpdateElement> arrayList = new ArrayList<>();
        Iterator<m> it = arrayListD.iterator();
        while (it.hasNext()) {
            arrayList.add(OfflineMapUtil.getUpdatElementFromLocalMapElement(it.next().a()));
        }
        return arrayList;
    }

    public ArrayList<MKOLSearchRecord> getHotCityList() {
        ArrayList<j> arrayListE = this.f7186a.e();
        if (arrayListE == null) {
            return null;
        }
        ArrayList<MKOLSearchRecord> arrayList = new ArrayList<>();
        Iterator<j> it = arrayListE.iterator();
        while (it.hasNext()) {
            arrayList.add(OfflineMapUtil.getSearchRecordFromLocalCityInfo(it.next()));
        }
        return arrayList;
    }

    public ArrayList<MKOLSearchRecord> getOfflineCityList() {
        ArrayList<j> arrayListC = this.f7186a.c();
        if (arrayListC == null) {
            return null;
        }
        ArrayList<MKOLSearchRecord> arrayList = new ArrayList<>();
        Iterator<j> it = arrayListC.iterator();
        while (it.hasNext()) {
            arrayList.add(OfflineMapUtil.getSearchRecordFromLocalCityInfo(it.next()));
        }
        return arrayList;
    }

    public MKOLUpdateElement getUpdateInfo(int i4) {
        m mVarB = this.f7186a.b(i4);
        if (mVarB == null) {
            return null;
        }
        return OfflineMapUtil.getUpdatElementFromLocalMapElement(mVarB.a());
    }

    @Deprecated
    public int importOfflineData() {
        return importOfflineData(false);
    }

    public boolean init(MKOfflineMapListener mKOfflineMapListener) {
        e.c();
        k kVarF = k.f();
        this.f7186a = kVarF;
        if (kVarF == null) {
            return false;
        }
        kVarF.a(new a());
        this.f7187b = mKOfflineMapListener;
        SDKLogFactory.getLogUsrActStatistics().addLogWithLowLevel("B", "OFF", "0", null);
        return true;
    }

    public boolean pause(int i4) {
        HashMap map = new HashMap();
        map.put("I", Integer.valueOf(i4));
        SDKLogFactory.getLogUsrActStatistics().addLogWithLowLevel("B", "OFF", "4", map);
        return this.f7186a.e(i4);
    }

    public boolean remove(int i4) {
        HashMap map = new HashMap();
        map.put("I", Integer.valueOf(i4));
        SDKLogFactory.getLogUsrActStatistics().addLogWithLowLevel("B", "OFF", "5", map);
        return this.f7186a.c(i4);
    }

    public ArrayList<MKOLSearchRecord> searchCity(String str) throws JSONException {
        ArrayList<j> arrayListA = this.f7186a.a(str);
        if (arrayListA == null) {
            return null;
        }
        ArrayList<MKOLSearchRecord> arrayList = new ArrayList<>();
        Iterator<j> it = arrayListA.iterator();
        while (it.hasNext()) {
            arrayList.add(OfflineMapUtil.getSearchRecordFromLocalCityInfo(it.next()));
        }
        return arrayList;
    }

    public boolean start(int i4) {
        int i5;
        HashMap map = new HashMap();
        if (this.f7186a == null) {
            map.put("I", "null");
            SDKLogFactory.getLogUsrActStatistics().addLogWithLowLevel("B", "OFF", "2", map);
            return false;
        }
        map.put("I", Integer.valueOf(i4));
        SDKLogFactory.getLogUsrActStatistics().addLogWithLowLevel("B", "OFF", "2", map);
        if (this.f7186a.d() != null) {
            Iterator<m> it = this.f7186a.d().iterator();
            while (it.hasNext()) {
                l lVar = it.next().f8081a;
                if (lVar.f8069a == i4) {
                    if (lVar.f8078j || (i5 = lVar.f8080l) == 2 || i5 == 3 || i5 == 6) {
                        return this.f7186a.d(i4);
                    }
                    return false;
                }
            }
        }
        return this.f7186a.a(i4);
    }

    public boolean update(int i4) {
        HashMap map = new HashMap();
        if (this.f7186a == null) {
            map.put("I", "null");
            SDKLogFactory.getLogUsrActStatistics().addLogWithLowLevel("B", "OFF", "3", map);
            return false;
        }
        map.put("I", Integer.valueOf(i4));
        SDKLogFactory.getLogUsrActStatistics().addLogWithLowLevel("B", "OFF", "3", map);
        if (this.f7186a.d() != null) {
            Iterator<m> it = this.f7186a.d().iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                l lVar = it.next().f8081a;
                if (lVar.f8069a == i4) {
                    if (lVar.f8078j) {
                        return this.f7186a.g(i4);
                    }
                }
            }
        }
        return false;
    }

    @Deprecated
    public int importOfflineData(boolean z4) {
        ArrayList<m> arrayListD = this.f7186a.d();
        int size = arrayListD != null ? arrayListD.size() : 0;
        int i4 = size;
        this.f7186a.a(z4, true);
        ArrayList<m> arrayListD2 = this.f7186a.d();
        if (arrayListD2 != null) {
            size = arrayListD2.size();
        }
        return size - i4;
    }
}
