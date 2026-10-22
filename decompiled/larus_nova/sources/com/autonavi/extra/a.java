package com.autonavi.extra;

import android.content.Context;
import com.autonavi.amap.api.mapcore.IGLMapState;
import com.autonavi.amap.mapcore.interfaces.IMapConfig;
import com.autonavi.base.amap.api.mapcore.IAMapDelegate;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes39.dex */
public interface a {
    Object a(String r100);

    String a();

    void a(Context r100, IAMapDelegate r101, boolean r102);

    void a(IGLMapState r100, IMapConfig r101);

    void a(String r100, Object r101);

    void a(JSONObject r100);

    void onDestroy();

    void onSurfaceChanged(GL10 r100, int r101, int r102);

    void onSurfaceCreated(GL10 r100, EGLConfig r101);
}
