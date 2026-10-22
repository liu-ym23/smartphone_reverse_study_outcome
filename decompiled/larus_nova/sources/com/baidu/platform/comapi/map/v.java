package com.baidu.platform.comapi.map;

import android.graphics.Point;
import android.view.MotionEvent;
import com.baidu.platform.comapi.basestruct.GeoPoint;
import com.baidu.platform.comapi.bmsdk.BmDrawItem;
import javax.microedition.khronos.opengles.GL10;

/* JADX INFO: loaded from: classes39.dex */
public interface v {
    void a();

    void a(MotionEvent r100);

    void a(com.baidu.mapsdkplatform.comapi.map.s r100);

    void a(GeoPoint r100);

    void a(GL10 r100, com.baidu.mapsdkplatform.comapi.map.s r101);

    void a(boolean r100);

    void a(boolean r100, int r101);

    boolean a(Point r100, Point r101, com.baidu.mapsdkplatform.comapi.map.s r102);

    boolean a(Point r100, com.baidu.mapsdkplatform.comapi.map.s r101);

    boolean a(MotionEvent r100, float r101, float r102, com.baidu.mapsdkplatform.comapi.map.s r103);

    boolean a(BmDrawItem r100);

    boolean a(String r100);

    void b();

    void b(com.baidu.mapsdkplatform.comapi.map.s r100);

    void b(GeoPoint r100);

    void b(String r100);

    boolean b(Point r100, Point r101, com.baidu.mapsdkplatform.comapi.map.s r102);

    void c();

    void c(com.baidu.mapsdkplatform.comapi.map.s r100);

    void c(GeoPoint r100);

    boolean c(Point r100, Point r101, com.baidu.mapsdkplatform.comapi.map.s r102);

    void d();

    void d(GeoPoint r100);

    boolean d(Point r100, Point r101, com.baidu.mapsdkplatform.comapi.map.s r102);

    void e(GeoPoint r100);

    void f(GeoPoint r100);

    void g(GeoPoint r100);

    void onFirstMapTileLoaded();
}
