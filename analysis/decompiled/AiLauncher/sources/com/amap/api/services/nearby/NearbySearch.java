package com.amap.api.services.nearby;

import android.content.Context;
import com.amap.api.col.jmsl.C1631z1;
import com.amap.api.col.jmsl.P2;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.core.LatLonPoint;
import com.amap.api.services.interfaces.INearbySearch;

/* loaded from: classes.dex */
public class NearbySearch {
    public static final int AMAP = 1;
    public static final int GPS = 0;

    /* renamed from: b, reason: collision with root package name */
    private static NearbySearch f17499b;

    /* renamed from: a, reason: collision with root package name */
    private INearbySearch f17500a;

    public interface NearbyListener {
        void onNearbyInfoSearched(NearbySearchResult nearbySearchResult, int i10);

        void onNearbyInfoUploaded(int i10);

        void onUserInfoCleared(int i10);
    }

    public static class NearbyQuery {

        /* renamed from: a, reason: collision with root package name */
        private LatLonPoint f17501a;

        /* renamed from: b, reason: collision with root package name */
        private NearbySearchFunctionType f17502b = NearbySearchFunctionType.DISTANCE_SEARCH;

        /* renamed from: c, reason: collision with root package name */
        private int f17503c = 1000;

        /* renamed from: d, reason: collision with root package name */
        private int f17504d = AMapException.CODE_AMAP_CLIENT_ERRORCODE_MISSSING;

        /* renamed from: e, reason: collision with root package name */
        private int f17505e = 1;

        public LatLonPoint getCenterPoint() {
            return this.f17501a;
        }

        public int getCoordType() {
            return this.f17505e;
        }

        public int getRadius() {
            return this.f17503c;
        }

        public int getTimeRange() {
            return this.f17504d;
        }

        public int getType() {
            int iOrdinal = this.f17502b.ordinal();
            return (iOrdinal == 0 || iOrdinal != 1) ? 0 : 1;
        }

        public void setCenterPoint(LatLonPoint latLonPoint) {
            this.f17501a = latLonPoint;
        }

        public void setCoordType(int i10) {
            if (i10 == 0 || i10 == 1) {
                this.f17505e = i10;
            } else {
                this.f17505e = 1;
            }
        }

        public void setRadius(int i10) {
            if (i10 > 10000) {
                i10 = 10000;
            }
            this.f17503c = i10;
        }

        /* JADX WARN: Removed duplicated region for block: B:4:0x0003 A[PHI: r0
          0x0003: PHI (r0v2 int) = (r0v0 int), (r0v1 int) binds: [B:3:0x0001, B:6:0x0008] A[DONT_GENERATE, DONT_INLINE]] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public void setTimeRange(int r2) {
            /*
                r1 = this;
                r0 = 5
                if (r2 >= r0) goto L5
            L3:
                r2 = r0
                goto Lb
            L5:
                r0 = 86400(0x15180, float:1.21072E-40)
                if (r2 <= r0) goto Lb
                goto L3
            Lb:
                r1.f17504d = r2
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.amap.api.services.nearby.NearbySearch.NearbyQuery.setTimeRange(int):void");
        }

        public void setType(NearbySearchFunctionType nearbySearchFunctionType) {
            this.f17502b = nearbySearchFunctionType;
        }
    }

    private NearbySearch(Context context) throws AMapException {
        if (this.f17500a == null) {
            try {
                this.f17500a = new P2(context);
            } catch (Exception e10) {
                e10.printStackTrace();
                if (e10 instanceof AMapException) {
                    throw ((AMapException) e10);
                }
            }
        }
    }

    public static synchronized void destroy() {
        try {
            NearbySearch nearbySearch = f17499b;
            if (nearbySearch != null) {
                try {
                    INearbySearch iNearbySearch = nearbySearch.f17500a;
                    if (iNearbySearch != null) {
                        iNearbySearch.destroy();
                    }
                    nearbySearch.f17500a = null;
                } catch (Throwable th) {
                    C1631z1.o(th, "NearbySearch", "destryoy");
                }
            }
            f17499b = null;
        } catch (Throwable th2) {
            throw th2;
        }
    }

    public static synchronized NearbySearch getInstance(Context context) throws AMapException {
        if (f17499b == null) {
            try {
                f17499b = new NearbySearch(context);
            } catch (AMapException e10) {
                throw e10;
            }
        }
        return f17499b;
    }

    public synchronized void addNearbyListener(NearbyListener nearbyListener) {
        INearbySearch iNearbySearch = this.f17500a;
        if (iNearbySearch != null) {
            iNearbySearch.addNearbyListener(nearbyListener);
        }
    }

    public void clearUserInfoAsyn() {
        INearbySearch iNearbySearch = this.f17500a;
        if (iNearbySearch != null) {
            iNearbySearch.clearUserInfoAsyn();
        }
    }

    public synchronized void removeNearbyListener(NearbyListener nearbyListener) {
        INearbySearch iNearbySearch = this.f17500a;
        if (iNearbySearch != null) {
            iNearbySearch.removeNearbyListener(nearbyListener);
        }
    }

    public NearbySearchResult searchNearbyInfo(NearbyQuery nearbyQuery) throws AMapException {
        INearbySearch iNearbySearch = this.f17500a;
        if (iNearbySearch != null) {
            return iNearbySearch.searchNearbyInfo(nearbyQuery);
        }
        return null;
    }

    public void searchNearbyInfoAsyn(NearbyQuery nearbyQuery) {
        INearbySearch iNearbySearch = this.f17500a;
        if (iNearbySearch != null) {
            iNearbySearch.searchNearbyInfoAsyn(nearbyQuery);
        }
    }

    public void setUserID(String str) {
        INearbySearch iNearbySearch = this.f17500a;
        if (iNearbySearch != null) {
            iNearbySearch.setUserID(str);
        }
    }

    public synchronized void startUploadNearbyInfoAuto(UploadInfoCallback uploadInfoCallback, int i10) {
        INearbySearch iNearbySearch = this.f17500a;
        if (iNearbySearch != null) {
            iNearbySearch.startUploadNearbyInfoAuto(uploadInfoCallback, i10);
        }
    }

    public synchronized void stopUploadNearbyInfoAuto() {
        INearbySearch iNearbySearch = this.f17500a;
        if (iNearbySearch != null) {
            iNearbySearch.stopUploadNearbyInfoAuto();
        }
    }

    public void uploadNearbyInfoAsyn(UploadInfo uploadInfo) {
        INearbySearch iNearbySearch = this.f17500a;
        if (iNearbySearch != null) {
            iNearbySearch.uploadNearbyInfoAsyn(uploadInfo);
        }
    }
}
