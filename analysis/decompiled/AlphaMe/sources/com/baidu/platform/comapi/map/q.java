package com.baidu.platform.comapi.map;

import com.baidu.platform.comapi.basestruct.GeoPoint;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public class q extends f {

    /* renamed from: x, reason: collision with root package name */
    private List<GeoPoint> f9248x;

    public q(z zVar) {
        super(zVar);
        this.f9248x = new ArrayList();
        this.f9204v = 0;
        this.f9205w = 2;
    }

    private boolean b() {
        synchronized (this.f9248x) {
            try {
                if (this.f9248x.size() < 2) {
                    return false;
                }
                int size = this.f9248x.size();
                this.f9198p = new double[this.f9248x.size() * 3];
                this.f9197o = new double[(this.f9248x.size() * 2) + 5];
                if (c()) {
                    this.f9197o[0] = this.f9200r.getLongitude();
                    this.f9197o[1] = this.f9200r.getLatitude();
                    this.f9197o[2] = this.f9201s.getLongitude();
                    this.f9197o[3] = this.f9201s.getLatitude();
                }
                this.f9197o[4] = 2.0d;
                for (int i4 = 0; i4 < size; i4++) {
                    if (i4 == 0) {
                        this.f9197o[5] = this.f9248x.get(0).getLongitude();
                        this.f9197o[6] = this.f9248x.get(0).getLatitude();
                    } else {
                        int i5 = i4 * 2;
                        int i6 = i4 - 1;
                        this.f9197o[i5 + 5] = this.f9248x.get(i4).getLongitude() - this.f9248x.get(i6).getLongitude();
                        this.f9197o[i5 + 6] = this.f9248x.get(i4).getLatitude() - this.f9248x.get(i6).getLatitude();
                    }
                    int i7 = i4 * 3;
                    this.f9198p[i7] = this.f9248x.get(i4).getLongitude();
                    this.f9198p[i7 + 1] = this.f9248x.get(i4).getLatitude();
                    this.f9198p[i7 + 2] = 0.0d;
                }
                return true;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    private boolean c() {
        synchronized (this.f9248x) {
            try {
                if (this.f9248x.size() < 2) {
                    return false;
                }
                this.f9200r.setLatitude(this.f9248x.get(0).getLatitude());
                this.f9200r.setLongitude(this.f9248x.get(0).getLongitude());
                this.f9201s.setLatitude(this.f9248x.get(0).getLatitude());
                this.f9201s.setLongitude(this.f9248x.get(0).getLongitude());
                for (GeoPoint geoPoint : this.f9248x) {
                    if (this.f9200r.getLatitude() >= geoPoint.getLatitude()) {
                        this.f9200r.setLatitude(geoPoint.getLatitude());
                    }
                    if (this.f9200r.getLongitude() >= geoPoint.getLongitude()) {
                        this.f9200r.setLongitude(geoPoint.getLongitude());
                    }
                    if (this.f9201s.getLatitude() <= geoPoint.getLatitude()) {
                        this.f9201s.setLatitude(geoPoint.getLatitude());
                    }
                    if (this.f9201s.getLongitude() <= geoPoint.getLongitude()) {
                        this.f9201s.setLongitude(geoPoint.getLongitude());
                    }
                }
                return true;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void a(List<GeoPoint> list) {
        if (list == null) {
            throw new IllegalArgumentException("points list can not be null!");
        }
        if (list.size() < 2) {
            throw new IllegalArgumentException("points count can not be less than two!");
        }
        synchronized (this.f9248x) {
            this.f9248x.clear();
            this.f9248x.addAll(list);
            this.f9202t = true;
        }
    }

    public void a(int[] iArr) {
        if (iArr == null || iArr.length == 0) {
            return;
        }
        this.f9199q = iArr;
    }

    public void a(boolean z4) {
        this.f9189g = z4;
    }

    public void a(z zVar) {
        this.f9183a = zVar;
    }

    @Override // com.baidu.platform.comapi.map.f
    public String a() {
        String strA;
        synchronized (this.f9248x) {
            try {
                if (this.f9202t) {
                    this.f9202t = !b();
                }
                strA = a(this.f9204v);
            } catch (Throwable th) {
                throw th;
            }
        }
        return strA;
    }
}
