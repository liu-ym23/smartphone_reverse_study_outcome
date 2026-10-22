package com.baidu.platform.comapi.map.c0.f;

import android.util.Pair;
import android.view.MotionEvent;
import com.baidu.platform.comapi.map.MapController;

/* JADX INFO: loaded from: classes39.dex */
public abstract class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected MapController f33205a;

    public void a(com.baidu.platform.comapi.map.c0.e.b r100) {
    }

    public abstract void a(com.baidu.platform.comapi.map.c0.e.b r100, Pair<com.baidu.platform.comapi.map.c0.a.d, com.baidu.platform.comapi.map.c0.a.d> r101);

    public abstract void a(com.baidu.platform.comapi.map.c0.e.b r100, MotionEvent r101);

    public a(MapController r100) {
        this.f33205a = r100;
    }
}
