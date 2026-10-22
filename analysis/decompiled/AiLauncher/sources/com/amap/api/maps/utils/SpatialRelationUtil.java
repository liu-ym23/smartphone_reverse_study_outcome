package com.amap.api.maps.utils;

import android.util.Pair;
import com.amap.api.col.jmsl.C1570k;
import com.amap.api.maps.AMapUtils;
import com.amap.api.maps.model.LatLng;
import com.autonavi.amap.mapcore.DPoint;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* loaded from: classes.dex */
public class SpatialRelationUtil {
    public static final int A_CIRCLE_DEGREE = 360;
    public static final int A_HALF_CIRCLE_DEGREE = 180;
    public static final int MIN_OFFSET_DEGREE = 50;
    public static final int MIN_POLYLINE_POINT_SIZE = 2;

    public static Pair<Integer, LatLng> calShortestDistancePoint(List<LatLng> list, LatLng latLng, float f10, double d10) {
        if (list != null && latLng != null) {
            try {
                if (list.size() != 0) {
                    ArrayList arrayList = new ArrayList();
                    int i10 = 0;
                    for (LatLng latLng2 : list) {
                        arrayList.add(DPoint.obtain(latLng2.latitude, latLng2.longitude));
                        if (latLng2.equals(latLng)) {
                            return new Pair<>(Integer.valueOf(i10), latLng);
                        }
                        i10++;
                    }
                    Pair<Integer, DPoint> pairCalShortestDistancePoint = calShortestDistancePoint(arrayList, DPoint.obtain(latLng.latitude, latLng.longitude), f10);
                    if (pairCalShortestDistancePoint != null) {
                        DPoint dPoint = (DPoint) pairCalShortestDistancePoint.second;
                        if (AMapUtils.calculateLineDistance(new LatLng(dPoint.f18178x, dPoint.f18179y), latLng) < d10) {
                            Object obj = pairCalShortestDistancePoint.first;
                            Object obj2 = pairCalShortestDistancePoint.second;
                            return new Pair<>(obj, new LatLng(((DPoint) obj2).f18178x, ((DPoint) obj2).f18179y));
                        }
                    }
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
        return null;
    }

    private static boolean checkRotateIsMatch(DPoint dPoint, DPoint dPoint2, float f10) {
        if (f10 == -1.0f) {
            return true;
        }
        if (dPoint != null && dPoint2 != null) {
            HashMap<String, Long> map = C1570k.f16700b;
            double d10 = dPoint.f18178x;
            double d11 = dPoint2.f18178x;
            float fAbs = Math.abs((((float) ((Math.atan2(dPoint2.f18179y - dPoint.f18179y, d11 - d10) / 3.141592653589793d) * 180.0d)) + 360.0f) - f10) % 360.0f;
            if (fAbs > 180.0f) {
                fAbs = 360.0f - fAbs;
            }
            if (fAbs < 50.0f) {
                return true;
            }
        }
        return false;
    }

    private static Pair<Double, DPoint> pointToSegDist(double d10, double d11, double d12, double d13, double d14, double d15) {
        double d16 = d14 - d12;
        double d17 = d10 - d12;
        double d18 = d15 - d13;
        double d19 = d11 - d13;
        double d20 = (d16 * d17) + (d18 * d19);
        if (d20 <= 0.0d) {
            return new Pair<>(Double.valueOf(Math.sqrt((d17 * d17) + (d19 * d19))), new DPoint(d12, d13));
        }
        double d21 = (d16 * d16) + (d18 * d18);
        if (d20 >= d21) {
            double d22 = d10 - d14;
            double d23 = d11 - d15;
            return new Pair<>(Double.valueOf(Math.sqrt((d22 * d22) + (d23 * d23))), new DPoint(d14, d15));
        }
        double d24 = d20 / d21;
        double d25 = d12 + (d16 * d24);
        double d26 = d13 + (d18 * d24);
        double d27 = d10 - d25;
        double d28 = d26 - d11;
        return new Pair<>(Double.valueOf(Math.sqrt((d27 * d27) + (d28 * d28))), new DPoint(d25, d26));
    }

    public static Pair<Integer, LatLng> calShortestDistancePoint(List<LatLng> list, LatLng latLng) {
        if (list != null && latLng != null) {
            try {
                if (list.size() != 0) {
                    ArrayList arrayList = new ArrayList();
                    int i10 = 0;
                    for (LatLng latLng2 : list) {
                        arrayList.add(DPoint.obtain(latLng2.latitude, latLng2.longitude));
                        if (latLng2.equals(latLng)) {
                            return new Pair<>(Integer.valueOf(i10), latLng);
                        }
                        i10++;
                    }
                    Pair<Integer, DPoint> pairCalShortestDistancePoint = calShortestDistancePoint(arrayList, DPoint.obtain(latLng.latitude, latLng.longitude));
                    if (pairCalShortestDistancePoint != null) {
                        Object obj = pairCalShortestDistancePoint.first;
                        Object obj2 = pairCalShortestDistancePoint.second;
                        return new Pair<>(obj, new LatLng(((DPoint) obj2).f18178x, ((DPoint) obj2).f18179y));
                    }
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
        return null;
    }

    public static Pair<Integer, DPoint> calShortestDistancePoint(List<DPoint> list, DPoint dPoint) {
        return calShortestDistancePoint(list, dPoint, -1.0f);
    }

    public static Pair<Integer, DPoint> calShortestDistancePoint(List<DPoint> list, DPoint dPoint, float f10) {
        double d10;
        int i10;
        List<DPoint> list2 = list;
        DPoint dPoint2 = dPoint;
        Pair<Integer, DPoint> pair = null;
        if (list2 != null && dPoint2 != null && list2.size() != 0) {
            if (list2.size() >= 2) {
                DPoint dPoint3 = list2.get(0);
                int size = list2.size();
                int i11 = 1;
                double d11 = 0.0d;
                int i12 = 1;
                while (true) {
                    int i13 = size - 1;
                    if (i12 > i13) {
                        break;
                    }
                    DPoint dPoint4 = list2.get(i12);
                    if (i12 == i13 && dPoint4.equals(dPoint2)) {
                        return new Pair<>(Integer.valueOf(i12), dPoint2);
                    }
                    if (!checkRotateIsMatch(dPoint3, dPoint4, f10)) {
                        d10 = d11;
                        i10 = i12;
                    } else {
                        if (dPoint3.equals(dPoint2)) {
                            return new Pair<>(Integer.valueOf(i12 - i11), dPoint2);
                        }
                        d10 = d11;
                        i10 = i12;
                        Pair<Double, DPoint> pairPointToSegDist = pointToSegDist(dPoint2.f18178x, dPoint2.f18179y, dPoint3.f18178x, dPoint3.f18179y, dPoint4.f18178x, dPoint4.f18179y);
                        if (pair == null || d10 > ((Double) pairPointToSegDist.first).doubleValue()) {
                            double dDoubleValue = ((Double) pairPointToSegDist.first).doubleValue();
                            Pair<Integer, DPoint> pair2 = new Pair<>(Integer.valueOf(i10 - 1), pairPointToSegDist.second);
                            d11 = dDoubleValue;
                            pair = pair2;
                            i12 = i10 + 1;
                            list2 = list;
                            dPoint2 = dPoint;
                            dPoint3 = dPoint4;
                            i11 = 1;
                        }
                    }
                    d11 = d10;
                    i12 = i10 + 1;
                    list2 = list;
                    dPoint2 = dPoint;
                    dPoint3 = dPoint4;
                    i11 = 1;
                }
            } else {
                return null;
            }
        }
        return pair;
    }
}
