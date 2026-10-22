package com.autonavi.aps.amapapi.filters;

import android.text.TextUtils;
import com.amap.api.location.AMapLocation;
import com.autonavi.aps.amapapi.model.AMapLocationServer;
import com.autonavi.aps.amapapi.utils.AuthUtil;
import com.autonavi.aps.amapapi.utils.Utils;

/* loaded from: classes.dex */
public class LocFilter {

    /* renamed from: a, reason: collision with root package name */
    AMapLocationServer f18242a = null;

    /* renamed from: b, reason: collision with root package name */
    long f18243b = 0;

    /* renamed from: c, reason: collision with root package name */
    long f18244c = 0;

    /* renamed from: d, reason: collision with root package name */
    private boolean f18245d = true;

    /* renamed from: e, reason: collision with root package name */
    int f18246e = 0;

    /* renamed from: f, reason: collision with root package name */
    long f18247f = 0;

    /* renamed from: g, reason: collision with root package name */
    AMapLocation f18248g = null;

    /* renamed from: h, reason: collision with root package name */
    long f18249h = 0;

    public AMapLocationServer a(AMapLocationServer aMapLocationServer) {
        if (Utils.locCorrect(aMapLocationServer)) {
            if (!this.f18245d || !AuthUtil.isCacheAble(aMapLocationServer.getTime())) {
                aMapLocationServer.setLocationType(this.f18246e);
            } else if (aMapLocationServer.getLocationType() == 5 || aMapLocationServer.getLocationType() == 6) {
                aMapLocationServer.setLocationType(4);
                return aMapLocationServer;
            }
        }
        return aMapLocationServer;
    }

    public AMapLocationServer filterFusion(AMapLocationServer aMapLocationServer) {
        return aMapLocationServer;
    }

    public AMapLocation filterGPSShake(AMapLocation aMapLocation) {
        if (Utils.locCorrect(aMapLocation)) {
            long timeBoot = Utils.getTimeBoot() - this.f18249h;
            this.f18249h = Utils.getTimeBoot();
            if (timeBoot <= 5000) {
                AMapLocation aMapLocation2 = this.f18248g;
                if (aMapLocation2 == null) {
                    this.f18248g = aMapLocation;
                    return aMapLocation;
                }
                if (1 != aMapLocation2.getLocationType() && !"gps".equalsIgnoreCase(this.f18248g.getProvider())) {
                    this.f18248g = aMapLocation;
                    return aMapLocation;
                }
                if (this.f18248g.getAltitude() == aMapLocation.getAltitude() && this.f18248g.getLongitude() == aMapLocation.getLongitude()) {
                    this.f18248g = aMapLocation;
                    return aMapLocation;
                }
                long jAbs = Math.abs(aMapLocation.getTime() - this.f18248g.getTime());
                if (30000 < jAbs) {
                    this.f18248g = aMapLocation;
                    return aMapLocation;
                }
                if (Utils.dist(aMapLocation, this.f18248g) > (((this.f18248g.getSpeed() + aMapLocation.getSpeed()) * jAbs) / 2000.0f) + ((this.f18248g.getAccuracy() + aMapLocation.getAccuracy()) * 2.0f) + 3000.0f) {
                    return this.f18248g;
                }
                this.f18248g = aMapLocation;
                return aMapLocation;
            }
        }
        return aMapLocation;
    }

    public AMapLocationServer filterShake(AMapLocationServer aMapLocationServer) {
        if (Utils.getTimeBoot() - this.f18247f > 30000) {
            this.f18242a = aMapLocationServer;
            this.f18247f = Utils.getTimeBoot();
            return this.f18242a;
        }
        this.f18247f = Utils.getTimeBoot();
        if (!Utils.locCorrect(this.f18242a) || !Utils.locCorrect(aMapLocationServer)) {
            this.f18243b = Utils.getTimeBoot();
            this.f18242a = aMapLocationServer;
            return aMapLocationServer;
        }
        if (aMapLocationServer.getTime() == this.f18242a.getTime() && aMapLocationServer.getAccuracy() < 300.0f) {
            return aMapLocationServer;
        }
        if ("gps".equals(aMapLocationServer.getProvider())) {
            this.f18243b = Utils.getTimeBoot();
            this.f18242a = aMapLocationServer;
            return aMapLocationServer;
        }
        if (aMapLocationServer.getCoord() != this.f18242a.getCoord()) {
            this.f18243b = Utils.getTimeBoot();
            this.f18242a = aMapLocationServer;
            return aMapLocationServer;
        }
        if (aMapLocationServer.getBuildingId() != null && !aMapLocationServer.getBuildingId().equals(this.f18242a.getBuildingId()) && !TextUtils.isEmpty(aMapLocationServer.getBuildingId())) {
            this.f18243b = Utils.getTimeBoot();
            this.f18242a = aMapLocationServer;
            return aMapLocationServer;
        }
        this.f18246e = aMapLocationServer.getLocationType();
        float fDist = Utils.dist(aMapLocationServer, this.f18242a);
        float accuracy = this.f18242a.getAccuracy();
        float accuracy2 = aMapLocationServer.getAccuracy();
        float f10 = accuracy2 - accuracy;
        long timeBoot = Utils.getTimeBoot();
        long j10 = timeBoot - this.f18243b;
        boolean z10 = false;
        boolean z11 = accuracy <= 100.0f && accuracy2 > 299.0f;
        if (accuracy > 299.0f && accuracy2 > 299.0f) {
            z10 = true;
        }
        if (z11 || z10) {
            long j11 = this.f18244c;
            if (j11 == 0) {
                this.f18244c = timeBoot;
            } else if (timeBoot - j11 > 30000) {
                this.f18243b = timeBoot;
                this.f18242a = aMapLocationServer;
                this.f18244c = 0L;
                return aMapLocationServer;
            }
            AMapLocationServer aMapLocationServerA = a(this.f18242a);
            this.f18242a = aMapLocationServerA;
            return aMapLocationServerA;
        }
        if (accuracy2 < 100.0f && accuracy > 299.0f) {
            this.f18243b = timeBoot;
            this.f18242a = aMapLocationServer;
            this.f18244c = 0L;
            return aMapLocationServer;
        }
        if (accuracy2 <= 299.0f) {
            this.f18244c = 0L;
        }
        if (fDist >= 10.0f || fDist <= 0.1d || accuracy2 <= 5.0f) {
            if (f10 < 300.0f) {
                this.f18243b = Utils.getTimeBoot();
                this.f18242a = aMapLocationServer;
                return aMapLocationServer;
            }
            if (j10 >= 30000) {
                this.f18243b = Utils.getTimeBoot();
                this.f18242a = aMapLocationServer;
                return aMapLocationServer;
            }
            AMapLocationServer aMapLocationServerA2 = a(this.f18242a);
            this.f18242a = aMapLocationServerA2;
            return aMapLocationServerA2;
        }
        if (f10 >= -300.0f) {
            AMapLocationServer aMapLocationServerA3 = a(this.f18242a);
            this.f18242a = aMapLocationServerA3;
            return aMapLocationServerA3;
        }
        if (accuracy / accuracy2 >= 2.0f) {
            this.f18243b = timeBoot;
            this.f18242a = aMapLocationServer;
            return aMapLocationServer;
        }
        AMapLocationServer aMapLocationServerA4 = a(this.f18242a);
        this.f18242a = aMapLocationServerA4;
        return aMapLocationServerA4;
    }

    public void reset() {
        this.f18242a = null;
        this.f18243b = 0L;
        this.f18244c = 0L;
        this.f18248g = null;
        this.f18249h = 0L;
    }

    public void setLocationCahceEnable(boolean z10) {
        this.f18245d = z10;
    }
}
