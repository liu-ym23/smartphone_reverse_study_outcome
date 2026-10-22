package com.bytedance.als;

import android.os.SystemClock;
import androidx.exifinterface.media.ExifInterface;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleRegistry;
import com.bytedance.als.b;
import com.bytedance.als.monitor.ComponentLifecycle;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b&\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u00012\u00020\u0003B\u0007¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/als/LogicComponent;", "Lcom/bytedance/als/b;", ExifInterface.GPS_DIRECTION_TRUE, "Landroidx/lifecycle/LifecycleOwner;", "<init>", "()V", "als_release"}, k = 1, mv = {1, 4, 1})
public abstract class LogicComponent<T extends b> implements LifecycleOwner {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LifecycleRegistry f38083a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final d6.b f38084b;

    public abstract T i();

    public final void b() {
        d6.b r100 = this.f38084b;
        r100.getClass();
        int r101 = e6.b.f471103a;
        r100.f467100b = SystemClock.uptimeMillis();
        onCreate();
        d6.b r102 = this.f38084b;
        r102.a(r102.f467101c, ComponentLifecycle.ON_CREATE, SystemClock.uptimeMillis() - r102.f467100b);
    }

    public final void c() {
        d6.b r100 = this.f38084b;
        r100.getClass();
        int r101 = e6.b.f471103a;
        r100.f467100b = SystemClock.uptimeMillis();
        onDestroy();
        d6.b r102 = this.f38084b;
        r102.a(r102.f467101c, ComponentLifecycle.ON_DESTROY, SystemClock.uptimeMillis() - r102.f467100b);
    }

    public final void e() {
        d6.b r100 = this.f38084b;
        r100.getClass();
        int r101 = e6.b.f471103a;
        r100.f467100b = SystemClock.uptimeMillis();
        this.f38083a.handleLifecycleEvent(Lifecycle.Event.ON_PAUSE);
        d6.b r102 = this.f38084b;
        r102.a(r102.f467101c, ComponentLifecycle.ON_PAUSE, SystemClock.uptimeMillis() - r102.f467100b);
    }

    public final void f() {
        d6.b r100 = this.f38084b;
        r100.getClass();
        int r101 = e6.b.f471103a;
        r100.f467100b = SystemClock.uptimeMillis();
        this.f38083a.handleLifecycleEvent(Lifecycle.Event.ON_RESUME);
        d6.b r102 = this.f38084b;
        r102.a(r102.f467101c, ComponentLifecycle.ON_RESUME, SystemClock.uptimeMillis() - r102.f467100b);
    }

    public final void g() {
        d6.b r100 = this.f38084b;
        r100.getClass();
        int r101 = e6.b.f471103a;
        r100.f467100b = SystemClock.uptimeMillis();
        this.f38083a.handleLifecycleEvent(Lifecycle.Event.ON_START);
        d6.b r102 = this.f38084b;
        r102.a(r102.f467101c, ComponentLifecycle.ON_START, SystemClock.uptimeMillis() - r102.f467100b);
    }

    public final void h() {
        d6.b r100 = this.f38084b;
        r100.getClass();
        int r101 = e6.b.f471103a;
        r100.f467100b = SystemClock.uptimeMillis();
        this.f38083a.handleLifecycleEvent(Lifecycle.Event.ON_STOP);
        d6.b r102 = this.f38084b;
        r102.a(r102.f467101c, ComponentLifecycle.ON_STOP, SystemClock.uptimeMillis() - r102.f467100b);
    }

    public void onCreate() {
        this.f38083a.handleLifecycleEvent(Lifecycle.Event.ON_CREATE);
    }

    public void onDestroy() {
        this.f38083a.handleLifecycleEvent(Lifecycle.Event.ON_DESTROY);
    }

    public LogicComponent() {
        this.f38083a = new LifecycleRegistry(this);
        this.f38084b = new d6.b(this);
    }

    @Override // androidx.lifecycle.LifecycleOwner
    public final Lifecycle getLifecycle() {
        return this.f38083a;
    }
}
