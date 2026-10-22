package com.amap.api.services.nearby;

import android.content.Context;
import com.amap.api.col.s.bb;
import com.amap.api.col.s.i;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.core.LatLonPoint;
import com.amap.api.services.interfaces.INearbySearch;

/* JADX INFO: loaded from: classes28.dex */
public class NearbySearch {
    public static final int AMAP = 1;
    public static final int GPS = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static NearbySearch f28975a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private INearbySearch f28976b;

    /* JADX INFO: renamed from: com.amap.api.services.nearby.NearbySearch$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f28977a = null;

        static {
            int[] r100 = new int[NearbySearchFunctionType.values().length];
            f28977a = r100;
            r100[NearbySearchFunctionType.DISTANCE_SEARCH.ordinal()] = 1;     // Catch: NoSuchFieldError -> L6
        L8:
            f28977a[NearbySearchFunctionType.DRIVING_DISTANCE_SEARCH.ordinal()] = 2;     // Catch: NoSuchFieldError -> L7
            return;
        }
    }

    public interface NearbyListener {
        void onNearbyInfoSearched(NearbySearchResult r100, int r101);

        void onNearbyInfoUploaded(int r100);

        void onUserInfoCleared(int r100);
    }

    public static class NearbyQuery {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private LatLonPoint f28978a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private NearbySearchFunctionType f28979b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private int f28980c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private int f28981d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private int f28982e;

        public int getType() {
            int r100 = AnonymousClass1.f28977a[this.f28979b.ordinal()];
            if (r100 != 1) goto L5;
        L6:
            return 0;
        L5:
            if (r100 != 2) goto L6;
            return 1;
        }

        public NearbyQuery() {
            this.f28979b = NearbySearchFunctionType.DISTANCE_SEARCH;
            this.f28980c = 1000;
            this.f28981d = 1800;
            this.f28982e = 1;
        }

        public LatLonPoint getCenterPoint() {
            return this.f28978a;
        }

        public int getCoordType() {
            return this.f28982e;
        }

        public int getRadius() {
            return this.f28980c;
        }

        public int getTimeRange() {
            return this.f28981d;
        }

        public void setCenterPoint(LatLonPoint r100) {
            this.f28978a = r100;
        }

        public void setCoordType(int r100) {
            if (r100 != 0) goto L4;
        L7:
            this.f28982e = r100;
            return;
        L4:
            if (r100 == 1) goto L7;
            this.f28982e = 1;
        }

        public void setRadius(int r100) {
            if (r100 <= 10000) goto L5;
            r100 = 10000;
        L5:
            this.f28980c = r100;
        }

        public void setTimeRange(int r100) {
            if (r100 >= 5) goto L6;
            r100 = 5;
        L8:
            this.f28981d = r100;
            return;
        L6:
            if (r100 <= 86400) goto L8;
            r100 = 86400;
            goto L8
        }

        public void setType(NearbySearchFunctionType r100) {
            this.f28979b = r100;
        }
    }

    public synchronized void stopUploadNearbyInfoAuto() {
        monitor-enter(this);
        INearbySearch r100 = this.f28976b;     // Catch: Throwable -> L8
        if (r100 == null) goto L6;
        r100.stopUploadNearbyInfoAuto();     // Catch: Throwable -> L8
    L6:
        monitor-exit(this);
        return;
    L8:
        th = move-exception;
        throw th;
    }

    public static synchronized void destroy() {
        monitor-enter(NearbySearch.class);
        NearbySearch r100 = f28975a;     // Catch: Throwable -> L17
        if (r100 != null) goto L20;
    L14:
        f28975a = null;     // Catch: Throwable -> L17
        monitor-exit(NearbySearch.class);
        return;
    L20:
        INearbySearch r101 = r100.f28976b;     // Catch: Throwable -> L12
        if (r101 == null) goto L10;
        r101.destroy();     // Catch: Throwable -> L12
    L10:
        r100.f28976b = null;     // Catch: Throwable -> L12
    L12:
        th = move-exception;
        i.a(th, "NearbySearch", "destryoy");     // Catch: Throwable -> L17
    L17:
        th = move-exception;
        throw th;
    }

    public void clearUserInfoAsyn() {
        INearbySearch r100 = this.f28976b;
        if (r100 == null) goto L6;
        r100.clearUserInfoAsyn();
        return;
    }

    private NearbySearch(Context r100) {
        if (this.f28976b != null) goto L11;
        this.f28976b = new bb(r100);     // Catch: Exception -> L6
        return;
    L6:
        e = move-exception;
        e.printStackTrace();
        return;
    }

    public static synchronized NearbySearch getInstance(Context r100) {
        monitor-enter(NearbySearch.class);
    L10:
        th = move-exception;
        throw th;
    L5:
        if (f28975a != null) goto L7;
        f28975a = new NearbySearch(r100);     // Catch: Throwable -> L10
    L7:
        NearbySearch r101 = f28975a;     // Catch: Throwable -> L10
        monitor-exit(NearbySearch.class);
        return r101;
    }

    public synchronized void addNearbyListener(NearbyListener r100) {
        monitor-enter(this);
        INearbySearch r101 = this.f28976b;     // Catch: Throwable -> L8
        if (r101 == null) goto L6;
        r101.addNearbyListener(r100);     // Catch: Throwable -> L8
    L6:
        monitor-exit(this);
        return;
    L8:
        th = move-exception;
        throw th;
    }

    public synchronized void removeNearbyListener(NearbyListener r100) {
        monitor-enter(this);
        INearbySearch r101 = this.f28976b;     // Catch: Throwable -> L8
        if (r101 == null) goto L6;
        r101.removeNearbyListener(r100);     // Catch: Throwable -> L8
    L6:
        monitor-exit(this);
        return;
    L8:
        th = move-exception;
        throw th;
    }

    public NearbySearchResult searchNearbyInfo(NearbyQuery r100) throws AMapException {
        INearbySearch r101 = this.f28976b;
        if (r101 != null) goto L5;
        return null;
    L5:
        return r101.searchNearbyInfo(r100);
    }

    public void searchNearbyInfoAsyn(NearbyQuery r100) {
        INearbySearch r101 = this.f28976b;
        if (r101 == null) goto L6;
        r101.searchNearbyInfoAsyn(r100);
        return;
    }

    public void setUserID(String r100) {
        INearbySearch r101 = this.f28976b;
        if (r101 == null) goto L6;
        r101.setUserID(r100);
        return;
    }

    public void uploadNearbyInfoAsyn(UploadInfo r100) {
        INearbySearch r101 = this.f28976b;
        if (r101 == null) goto L6;
        r101.uploadNearbyInfoAsyn(r100);
        return;
    }

    public synchronized void startUploadNearbyInfoAuto(UploadInfoCallback r100, int r101) {
        monitor-enter(this);
        INearbySearch r102 = this.f28976b;     // Catch: Throwable -> L8
        if (r102 == null) goto L6;
        r102.startUploadNearbyInfoAuto(r100, r101);     // Catch: Throwable -> L8
    L6:
        monitor-exit(this);
        return;
    L8:
        th = move-exception;
        throw th;
    }
}
