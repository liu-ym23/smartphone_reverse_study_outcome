package com.baidu.platform.comapi.map;

import android.view.GestureDetector;
import android.view.MotionEvent;
import com.baidu.platform.comapi.map.MapController;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

/* loaded from: classes.dex */
public class x extends GestureDetector.SimpleOnGestureListener {

    /* renamed from: a, reason: collision with root package name */
    private MapController f9254a;

    /* renamed from: b, reason: collision with root package name */
    private OnLongPressListener f9255b;

    /* renamed from: c, reason: collision with root package name */
    private volatile Set<GestureDetector.SimpleOnGestureListener> f9256c = new CopyOnWriteArraySet();

    /* renamed from: d, reason: collision with root package name */
    private Object f9257d = new Object();

    public void a(MapController mapController) {
        this.f9254a = mapController;
    }

    public void b(GestureDetector.SimpleOnGestureListener simpleOnGestureListener) {
        synchronized (this.f9257d) {
            this.f9256c.remove(simpleOnGestureListener);
        }
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
    public boolean onDoubleTap(MotionEvent motionEvent) {
        synchronized (this.f9257d) {
            try {
                Set<GestureDetector.SimpleOnGestureListener> set = this.f9256c;
                if (set != null) {
                    Iterator<GestureDetector.SimpleOnGestureListener> it = set.iterator();
                    while (it.hasNext()) {
                        it.next().onDoubleTap(motionEvent);
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        MapController mapController = this.f9254a;
        if (mapController == null) {
            return true;
        }
        mapController.handleDoubleDownClick(motionEvent);
        return true;
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
    public boolean onDoubleTapEvent(MotionEvent motionEvent) {
        MapController mapController;
        synchronized (this.f9257d) {
            try {
                Set<GestureDetector.SimpleOnGestureListener> set = this.f9256c;
                if (set != null) {
                    Iterator<GestureDetector.SimpleOnGestureListener> it = set.iterator();
                    while (it.hasNext()) {
                        it.next().onDoubleTapEvent(motionEvent);
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        if (motionEvent.getAction() == 1 && (mapController = this.f9254a) != null) {
            mapController.handleDoubleTouch(motionEvent);
        }
        return super.onDoubleTapEvent(motionEvent);
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
    public boolean onDown(MotionEvent motionEvent) {
        synchronized (this.f9257d) {
            try {
                Set<GestureDetector.SimpleOnGestureListener> set = this.f9256c;
                if (set != null) {
                    Iterator<GestureDetector.SimpleOnGestureListener> it = set.iterator();
                    while (it.hasNext()) {
                        it.next().onDown(motionEvent);
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return super.onDown(motionEvent);
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
    public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f4, float f5) {
        synchronized (this.f9257d) {
            try {
                Set<GestureDetector.SimpleOnGestureListener> set = this.f9256c;
                if (set != null) {
                    Iterator<GestureDetector.SimpleOnGestureListener> it = set.iterator();
                    while (it.hasNext()) {
                        it.next().onFling(motionEvent, motionEvent2, f4, f5);
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        MapController mapController = this.f9254a;
        if (mapController == null) {
            return false;
        }
        if (mapController.getMapControlMode() == MapController.MapControlMode.STREET) {
            this.f9254a.handleTouchUp(motionEvent2);
        }
        return this.f9254a.handleFling(motionEvent, motionEvent2, f4, f5);
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
    public void onLongPress(MotionEvent motionEvent) {
        OnLongPressListener onLongPressListener;
        synchronized (this.f9257d) {
            try {
                Set<GestureDetector.SimpleOnGestureListener> set = this.f9256c;
                if (set != null) {
                    for (GestureDetector.SimpleOnGestureListener simpleOnGestureListener : set) {
                        if (simpleOnGestureListener != null) {
                            simpleOnGestureListener.onLongPress(motionEvent);
                        }
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        MapController mapController = this.f9254a;
        if (mapController == null || mapController.isEnableDMoveZoom() || this.f9254a.isNaviMode() || (onLongPressListener = this.f9255b) == null) {
            return;
        }
        onLongPressListener.onLongPress(motionEvent);
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
    public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f4, float f5) {
        synchronized (this.f9257d) {
            try {
                Set<GestureDetector.SimpleOnGestureListener> set = this.f9256c;
                if (set != null) {
                    Iterator<GestureDetector.SimpleOnGestureListener> it = set.iterator();
                    while (it.hasNext()) {
                        it.next().onScroll(motionEvent, motionEvent2, f4, f5);
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return super.onScroll(motionEvent, motionEvent2, f4, f5);
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
    public void onShowPress(MotionEvent motionEvent) {
        synchronized (this.f9257d) {
            try {
                Set<GestureDetector.SimpleOnGestureListener> set = this.f9256c;
                if (set != null) {
                    for (GestureDetector.SimpleOnGestureListener simpleOnGestureListener : set) {
                        if (simpleOnGestureListener != null) {
                            simpleOnGestureListener.onShowPress(motionEvent);
                        }
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        super.onShowPress(motionEvent);
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
    public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
        synchronized (this.f9257d) {
            try {
                Set<GestureDetector.SimpleOnGestureListener> set = this.f9256c;
                if (set != null) {
                    for (GestureDetector.SimpleOnGestureListener simpleOnGestureListener : set) {
                        if (simpleOnGestureListener != null) {
                            simpleOnGestureListener.onSingleTapConfirmed(motionEvent);
                        }
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        MapController mapController = this.f9254a;
        return mapController != null && mapController.handleTouchSingleClick(motionEvent);
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
    public boolean onSingleTapUp(MotionEvent motionEvent) {
        synchronized (this.f9257d) {
            try {
                Set<GestureDetector.SimpleOnGestureListener> set = this.f9256c;
                if (set != null) {
                    Iterator<GestureDetector.SimpleOnGestureListener> it = set.iterator();
                    while (it.hasNext()) {
                        it.next().onSingleTapUp(motionEvent);
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return super.onSingleTapUp(motionEvent);
    }

    public OnLongPressListener a() {
        return this.f9255b;
    }

    public void a(OnLongPressListener onLongPressListener) {
        this.f9255b = onLongPressListener;
    }

    public void a(GestureDetector.SimpleOnGestureListener simpleOnGestureListener) {
        synchronized (this.f9257d) {
            this.f9256c.add(simpleOnGestureListener);
        }
    }
}
