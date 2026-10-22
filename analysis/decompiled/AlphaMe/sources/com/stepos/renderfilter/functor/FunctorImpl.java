package com.stepos.renderfilter.functor;

import android.util.Log;
import androidx.activity.d;
import com.stepos.alphame.bluetooth.VehicleBluetoothManager;
import com.stepos.renderfilter.RenderFilter;
import com.stepos.renderfilter.annotation.Keep;
import java.lang.ref.WeakReference;

/* loaded from: classes.dex */
public abstract class FunctorImpl extends Functor {

    /* renamed from: f, reason: collision with root package name */
    public static final /* synthetic */ int f12308f = 0;

    @Keep
    private native long native_create_functor(WeakReference<Functor> weakReference);

    @Keep
    private native void native_destroy_functor(long j4);

    @Override // com.stepos.renderfilter.functor.Functor
    public final Long a() {
        return Long.valueOf(native_create_functor(new WeakReference<>(this)));
    }

    @Override // com.stepos.renderfilter.functor.Functor
    public final void b() {
        native_destroy_functor(this.f12305a.longValue());
    }

    public final void e() {
        if (d()) {
            Log.e("RenderFilter", "sInvokeFunctorMethod is null");
        }
    }

    public final void finalize() throws Throwable {
        try {
            if (d()) {
                RenderFilter.b().f12299b.remove(this.f12305a);
                synchronized (Functor.class) {
                    Functor.f12302c.put(this.f12305a, this);
                }
                e();
                Functor.f12303d.postDelayed(new d(23, this), VehicleBluetoothManager.MIN_CONNECT_DISTANCE);
            }
        } finally {
            super.finalize();
        }
    }
}
