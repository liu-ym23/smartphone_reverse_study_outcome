package com.autonavi.base.ae.gmap.glanimation;

import com.amap.api.maps.AMap;
import com.autonavi.base.ae.gmap.GLMapState;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes39.dex */
public class AdglMapAnimationMgr {
    private List<AbstractAdglAnimation> list;
    private AMap.CancelableCallback mCancelCallback;
    private MapAnimationListener mMapAnimationListener;

    public interface MapAnimationListener {
        void onMapAnimationFinish(AMap.CancelableCallback r100);
    }

    public synchronized void clearAnimations() {
        monitor-enter(this);
        this.list.clear();     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    public synchronized int getAnimationsCount() {
        monitor-enter(this);
        int r100 = this.list.size();     // Catch: Throwable -> L6
        monitor-exit(this);
        return r100;
    L6:
        th = move-exception;
        throw th;
    }

    public synchronized AbstractAdglAnimation getCurrentAnimation() {
        monitor-enter(this);
    L11:
        th = move-exception;
        throw th;
    L4:
        if (this.list.size() > 0) goto L8;
        monitor-exit(this);
        return null;
    L8:
        AbstractAdglAnimation r100 = (AbstractAdglAnimation) ListProtector.get(this.list, 0);     // Catch: Throwable -> L11
        monitor-exit(this);
        return r100;
    }

    public void setMapCoreListener() {
    }

    public AdglMapAnimationMgr() {
        this.list = Collections.synchronizedList(new ArrayList());
    }

    public AMap.CancelableCallback getCancelCallback() {
        return this.mCancelCallback;
    }

    public synchronized void doAnimations(GLMapState r100) {
        monitor-enter(this);
        if (r100 != null) goto L26;
        monitor-exit(this);
        return;
    L26:
    L23:
        th = move-exception;
        throw th;
    L7:
        if (this.list.size() > 0) goto L10;
        monitor-exit(this);
        return;
    L10:
        AbstractAdglAnimation r101 = (AbstractAdglAnimation) ListProtector.get(this.list, 0);     // Catch: Throwable -> L23
        if (r101 != null) goto L15;
        monitor-exit(this);
        return;
    L15:
        if (r101.isOver() == false) goto L20;
        MapAnimationListener r102 = this.mMapAnimationListener;     // Catch: Throwable -> L23
        if (r102 == null) goto L19;
        r102.onMapAnimationFinish(this.mCancelCallback);     // Catch: Throwable -> L23
    L19:
        this.list.remove(r101);     // Catch: Throwable -> L23
    L21:
        monitor-exit(this);
        return;
    L20:
        r101.doAnimation(r100);     // Catch: Throwable -> L23
        goto L21
    }

    public void setMapAnimationListener(MapAnimationListener r100) {
        monitor-enter(this);
        this.mMapAnimationListener = r100;     // Catch: Throwable -> L6
        monitor-exit(this);     // Catch: Throwable -> L6
        return;
    L6:
        th = move-exception;
        throw th;
    }

    public void addAnimation(AbstractAdglAnimation r100, AMap.CancelableCallback r101) {
        if (r100 != null) goto L4;
        return;
    L4:
        List<AbstractAdglAnimation> r102 = this.list;
        monitor-enter(r102);
    L24:
        th = move-exception;
        throw th;
    L7:
        if (r100.isOver() == false) goto L9;
    L21:
        this.list.add(r100);     // Catch: Throwable -> L24
        this.mCancelCallback = r101;     // Catch: Throwable -> L24
        monitor-exit(r102);     // Catch: Throwable -> L24
        return;
    L9:
        if (this.list.size() <= 0) goto L21;
        List<AbstractAdglAnimation> r103 = this.list;     // Catch: Throwable -> L24
        AbstractAdglAnimation r104 = r103.get(r103.size() - 1);     // Catch: Throwable -> L24
        if (r104 == null) goto L21;
        if ((r100 instanceof AdglMapAnimGroup) == false) goto L21;
        if ((r104 instanceof AdglMapAnimGroup) == false) goto L21;
        if (((AdglMapAnimGroup) r100).typeEqueal((AdglMapAnimGroup) r104) == false) goto L21;
        if (((AdglMapAnimGroup) r100).needMove == true) goto L21;
        this.list.remove(r104);     // Catch: Throwable -> L24
        goto L21
    }
}
