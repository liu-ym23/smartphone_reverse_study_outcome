package com.amap.api.services.district;

import android.content.Context;
import com.amap.api.col.s.ay;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.interfaces.IDistrictSearch;

/* JADX INFO: loaded from: classes28.dex */
public class DistrictSearch {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private IDistrictSearch f28886a;

    public interface OnDistrictSearchListener {
        void onDistrictSearched(DistrictResult r100);
    }

    public DistrictSearchQuery getQuery() {
        IDistrictSearch r100 = this.f28886a;
        if (r100 != null) goto L5;
        return null;
    L5:
        return r100.getQuery();
    }

    public DistrictResult searchDistrict() throws AMapException {
        IDistrictSearch r100 = this.f28886a;
        if (r100 != null) goto L5;
        return null;
    L5:
        return r100.searchDistrict();
    }

    public void searchDistrictAnsy() {
        IDistrictSearch r100 = this.f28886a;
        if (r100 == null) goto L6;
        r100.searchDistrictAnsy();
        return;
    }

    public void searchDistrictAsyn() {
        IDistrictSearch r100 = this.f28886a;
        if (r100 == null) goto L6;
        r100.searchDistrictAsyn();
        return;
    }

    public DistrictSearch(Context r100) {
        if (this.f28886a != null) goto L11;
        this.f28886a = new ay(r100);     // Catch: Exception -> L6
        return;
    L6:
        e = move-exception;
        e.printStackTrace();
        return;
    }

    public void setOnDistrictSearchListener(OnDistrictSearchListener r100) {
        IDistrictSearch r101 = this.f28886a;
        if (r101 == null) goto L6;
        r101.setOnDistrictSearchListener(r100);
        return;
    }

    public void setQuery(DistrictSearchQuery r100) {
        IDistrictSearch r101 = this.f28886a;
        if (r101 == null) goto L6;
        r101.setQuery(r100);
        return;
    }
}
