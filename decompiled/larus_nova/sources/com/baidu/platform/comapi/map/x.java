package com.baidu.platform.comapi.map;

import android.view.GestureDetector;
import android.view.MotionEvent;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

/* JADX INFO: loaded from: classes39.dex */
public class x extends GestureDetector.SimpleOnGestureListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private MapController f33362a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private OnLongPressListener f33363b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private volatile Set<GestureDetector.SimpleOnGestureListener> f33364c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private Object f33365d;

    public x() {
        this.f33364c = new CopyOnWriteArraySet();
        this.f33365d = new Object();
    }

    public OnLongPressListener a() {
        return this.f33363b;
    }

    public void a(GestureDetector.SimpleOnGestureListener r100) {
        Object r101 = this.f33365d;
        monitor-enter(r101);
        this.f33364c.add(r100);     // Catch: Throwable -> L7
        monitor-exit(r101);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public void b(GestureDetector.SimpleOnGestureListener r100) {
        Object r101 = this.f33365d;
        monitor-enter(r101);
        this.f33364c.remove(r100);     // Catch: Throwable -> L7
        monitor-exit(r101);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
    public boolean onDoubleTap(MotionEvent r100) {
        Object r101 = this.f33365d;
        monitor-enter(r101);
        Set<GestureDetector.SimpleOnGestureListener> r102 = this.f33364c;     // Catch: Throwable -> L16
        if (r102 == null) goto L10;
        Iterator<GestureDetector.SimpleOnGestureListener> r103 = r102.iterator();     // Catch: Throwable -> L16
    L8:
        if (r103.hasNext() == false) goto L10;
        r103.next().onDoubleTap(r100);     // Catch: Throwable -> L16
    L10:
        monitor-exit(r101);     // Catch: Throwable -> L16
        MapController r104 = this.f33362a;
        if (r104 == null) goto L22;
        r104.handleDoubleDownClick(r100);
        return true;
    L22:
        return true;
    L16:
        th = move-exception;
        throw th;
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
    public boolean onDoubleTapEvent(MotionEvent r100) {
        Object r101 = this.f33365d;
        monitor-enter(r101);
        Set<GestureDetector.SimpleOnGestureListener> r102 = this.f33364c;     // Catch: Throwable -> L18
        if (r102 == null) goto L10;
        Iterator<GestureDetector.SimpleOnGestureListener> r103 = r102.iterator();     // Catch: Throwable -> L18
    L8:
        if (r103.hasNext() == false) goto L10;
        r103.next().onDoubleTapEvent(r100);     // Catch: Throwable -> L18
    L10:
        monitor-exit(r101);     // Catch: Throwable -> L18
        if (r100.getAction() != 1) goto L17;
        MapController r104 = this.f33362a;
        if (r104 == null) goto L17;
        r104.handleDoubleTouch(r100);
    L17:
        return super.onDoubleTapEvent(r100);
    L18:
        th = move-exception;
        throw th;
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
    public boolean onDown(MotionEvent r100) {
        Object r101 = this.f33365d;
        monitor-enter(r101);
        Set<GestureDetector.SimpleOnGestureListener> r102 = this.f33364c;     // Catch: Throwable -> L13
        if (r102 == null) goto L10;
        Iterator<GestureDetector.SimpleOnGestureListener> r103 = r102.iterator();     // Catch: Throwable -> L13
    L8:
        if (r103.hasNext() == false) goto L10;
        r103.next().onDown(r100);     // Catch: Throwable -> L13
    L10:
        monitor-exit(r101);     // Catch: Throwable -> L13
        return super.onDown(r100);
    L13:
        th = move-exception;
        throw th;
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
    public void onLongPress(MotionEvent r100) {
        Object r101 = this.f33365d;
        monitor-enter(r101);
        Set<GestureDetector.SimpleOnGestureListener> r102 = this.f33364c;     // Catch: Throwable -> L23
        if (r102 == null) goto L12;
        Iterator<GestureDetector.SimpleOnGestureListener> r103 = r102.iterator();     // Catch: Throwable -> L23
    L8:
        if (r103.hasNext() == false) goto L12;
        GestureDetector.SimpleOnGestureListener r104 = r103.next();     // Catch: Throwable -> L23
        if (r104 == null) goto L8;
        r104.onLongPress(r100);     // Catch: Throwable -> L23
    L12:
        monitor-exit(r101);     // Catch: Throwable -> L23
        MapController r105 = this.f33362a;
        if (r105 != null) goto L16;
        return;
    L16:
        if (r105.isEnableDMoveZoom() == false) goto L18;
        return;
    L18:
        if (this.f33362a.isNaviMode() == true) goto L35;
        OnLongPressListener r106 = this.f33363b;
        if (r106 == null) goto L36;
        r106.onLongPress(r100);
        return;
    L36:
        return;
    L35:
        return;
    L23:
        th = move-exception;
        throw th;
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
    public void onShowPress(MotionEvent r100) {
        Object r101 = this.f33365d;
        monitor-enter(r101);
        Set<GestureDetector.SimpleOnGestureListener> r102 = this.f33364c;     // Catch: Throwable -> L15
        if (r102 == null) goto L12;
        Iterator<GestureDetector.SimpleOnGestureListener> r103 = r102.iterator();     // Catch: Throwable -> L15
    L8:
        if (r103.hasNext() == false) goto L12;
        GestureDetector.SimpleOnGestureListener r104 = r103.next();     // Catch: Throwable -> L15
        if (r104 == null) goto L8;
        r104.onShowPress(r100);     // Catch: Throwable -> L15
    L12:
        monitor-exit(r101);     // Catch: Throwable -> L15
        super.onShowPress(r100);
        return;
    L15:
        th = move-exception;
        throw th;
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
    public boolean onSingleTapConfirmed(MotionEvent r100) {
        Object r101 = this.f33365d;
        monitor-enter(r101);
        Set<GestureDetector.SimpleOnGestureListener> r102 = this.f33364c;     // Catch: Throwable -> L20
        if (r102 == null) goto L12;
        Iterator<GestureDetector.SimpleOnGestureListener> r103 = r102.iterator();     // Catch: Throwable -> L20
    L8:
        if (r103.hasNext() == false) goto L12;
        GestureDetector.SimpleOnGestureListener r104 = r103.next();     // Catch: Throwable -> L20
        if (r104 == null) goto L8;
        r104.onSingleTapConfirmed(r100);     // Catch: Throwable -> L20
    L12:
        monitor-exit(r101);     // Catch: Throwable -> L20
        MapController r105 = this.f33362a;
        if (r105 != null) goto L16;
    L18:
        return false;
    L16:
        if (r105.handleTouchSingleClick(r100) == false) goto L18;
        return true;
    L20:
        th = move-exception;
        throw th;
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
    public boolean onSingleTapUp(MotionEvent r100) {
        Object r101 = this.f33365d;
        monitor-enter(r101);
        Set<GestureDetector.SimpleOnGestureListener> r102 = this.f33364c;     // Catch: Throwable -> L13
        if (r102 == null) goto L10;
        Iterator<GestureDetector.SimpleOnGestureListener> r103 = r102.iterator();     // Catch: Throwable -> L13
    L8:
        if (r103.hasNext() == false) goto L10;
        r103.next().onSingleTapUp(r100);     // Catch: Throwable -> L13
    L10:
        monitor-exit(r101);     // Catch: Throwable -> L13
        return super.onSingleTapUp(r100);
    L13:
        th = move-exception;
        throw th;
    }

    public void a(MapController r100) {
        this.f33362a = r100;
    }

    public void a(OnLongPressListener r100) {
        this.f33363b = r100;
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
    public boolean onFling(MotionEvent r100, MotionEvent r101, float r102, float r103) {
        Object r104 = this.f33365d;
        monitor-enter(r104);
        Set<GestureDetector.SimpleOnGestureListener> r105 = this.f33364c;     // Catch: Throwable -> L20
        if (r105 == null) goto L10;
        Iterator<GestureDetector.SimpleOnGestureListener> r106 = r105.iterator();     // Catch: Throwable -> L20
    L8:
        if (r106.hasNext() == false) goto L10;
        r106.next().onFling(r100, r101, r102, r103);     // Catch: Throwable -> L20
    L10:
        monitor-exit(r104);     // Catch: Throwable -> L20
        MapController r107 = this.f33362a;
        if (r107 != null) goto L16;
        return false;
    L16:
        if (r107.getMapControlMode() != MapController.MapControlMode.STREET) goto L19;
        this.f33362a.handleTouchUp(r101);
    L19:
        return this.f33362a.handleFling(r100, r101, r102, r103);
    L20:
        th = move-exception;
        throw th;
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
    public boolean onScroll(MotionEvent r100, MotionEvent r101, float r102, float r103) {
        Object r104 = this.f33365d;
        monitor-enter(r104);
        Set<GestureDetector.SimpleOnGestureListener> r105 = this.f33364c;     // Catch: Throwable -> L13
        if (r105 == null) goto L10;
        Iterator<GestureDetector.SimpleOnGestureListener> r106 = r105.iterator();     // Catch: Throwable -> L13
    L8:
        if (r106.hasNext() == false) goto L10;
        r106.next().onScroll(r100, r101, r102, r103);     // Catch: Throwable -> L13
    L10:
        monitor-exit(r104);     // Catch: Throwable -> L13
        return super.onScroll(r100, r101, r102, r103);
    L13:
        th = move-exception;
        throw th;
    }
}
