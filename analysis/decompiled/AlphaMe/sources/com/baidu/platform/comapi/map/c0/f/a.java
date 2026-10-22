package com.baidu.platform.comapi.map.c0.f;

import android.util.Pair;
import android.view.MotionEvent;
import com.baidu.platform.comapi.map.MapController;
import com.baidu.platform.comapi.map.c0.a;

/* loaded from: classes.dex */
public abstract class a {

    /* renamed from: a, reason: collision with root package name */
    protected MapController f9100a;

    public a(MapController mapController) {
        this.f9100a = mapController;
    }

    public void a(com.baidu.platform.comapi.map.c0.e.b bVar) {
    }

    public abstract void a(com.baidu.platform.comapi.map.c0.e.b bVar, Pair<a.d, a.d> pair);

    public abstract void a(com.baidu.platform.comapi.map.c0.e.b bVar, MotionEvent motionEvent);
}
