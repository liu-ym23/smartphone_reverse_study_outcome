package com.stepos.core.model;

import android.util.Log;
import androidx.lifecycle.j0;
import b7.q;
import com.stepos.base.model.ModelState;
import com.stepos.cpuset.b;
import com.stepos.cpuset.c;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.jvm.internal.e;
import kotlin.jvm.internal.g;
import lb.n;
import zb.a;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class ModelLifecycleImpl {
    public static final Companion Companion = new Companion(null);
    private static final String TAG = "ModelLifecycle";
    private volatile ModelState _state;
    private final CopyOnWriteArrayList<q> listeners;
    private final String modelId;
    private a<n> onCleanup;
    private a<n> onClose;
    private a<Boolean> onInitialize;
    private a<Boolean> onWarmup;

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class Companion {
        public /* synthetic */ Companion(e eVar) {
            this();
        }

        private Companion() {
        }
    }

    public ModelLifecycleImpl(String modelId) {
        g.f(modelId, "modelId");
        this.modelId = modelId;
        this._state = ModelState.f6326a;
        this.listeners = new CopyOnWriteArrayList<>();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean cleanup$lambda$6(ModelLifecycleImpl modelLifecycleImpl) {
        try {
            a<n> aVar = modelLifecycleImpl.onCleanup;
            if (aVar == null) {
                return true;
            }
            aVar.invoke();
            return true;
        } catch (Exception e10) {
            Log.e(TAG, "[" + modelLifecycleImpl.modelId + "] Cleanup failed", e10);
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean close$lambda$5(ModelLifecycleImpl modelLifecycleImpl) {
        try {
            a<n> aVar = modelLifecycleImpl.onClose;
            if (aVar != null) {
                aVar.invoke();
            }
        } catch (Exception e10) {
            Log.e(TAG, "[" + modelLifecycleImpl.modelId + "] Close failed", e10);
        }
        return ((Boolean) modelLifecycleImpl.transition(ModelState.h, ModelState.f6331j, new c(21))).booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean close$lambda$5$lambda$4() {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean init$lambda$2(ModelLifecycleImpl modelLifecycleImpl) {
        boolean zBooleanValue;
        try {
            a<Boolean> aVar = modelLifecycleImpl.onInitialize;
            zBooleanValue = aVar != null ? aVar.invoke().booleanValue() : true;
        } catch (Exception e10) {
            Log.e(TAG, "[" + modelLifecycleImpl.modelId + "] Init failed", e10);
            zBooleanValue = false;
        }
        if (zBooleanValue) {
            return ((Boolean) modelLifecycleImpl.transition(ModelState.f6328c, ModelState.f6329d, new c(22))).booleanValue();
        }
        modelLifecycleImpl.transition(ModelState.f6328c, ModelState.f6333l, new b(21));
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean init$lambda$2$lambda$0() {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean init$lambda$2$lambda$1() {
        return true;
    }

    private final <T> T transition(ModelState modelState, ModelState modelState2, a<? extends T> aVar) {
        if (this._state != modelState) {
            Log.w(TAG, "[" + this.modelId + "] Invalid transition: " + this._state + " -> " + modelState2 + " (expected from: " + modelState + ")");
            return (T) Boolean.FALSE;
        }
        ModelState modelState3 = this._state;
        this._state = modelState2;
        Log.d(TAG, "[" + this.modelId + "] State: " + modelState3 + " -> " + modelState2);
        Iterator<T> it = this.listeners.iterator();
        while (it.hasNext()) {
            try {
                ((q) it.next()).a();
            } catch (Exception e10) {
                Log.e(TAG, "[" + this.modelId + "] Listener error", e10);
            }
        }
        return aVar.invoke();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean warmup$lambda$3() {
        return true;
    }

    public void addStateListener(q listener) {
        g.f(listener, "listener");
        this.listeners.add(listener);
    }

    public boolean canInfer() {
        return this._state == ModelState.f6329d || this._state == ModelState.f6330e;
    }

    public synchronized void cleanup() {
        try {
            ModelState modelState = this._state;
            ModelState modelState2 = ModelState.f6332k;
            if (modelState == modelState2) {
                return;
            }
            ModelState modelState3 = this._state;
            ModelState modelState4 = ModelState.f6331j;
            if (modelState3 != modelState4) {
                close();
            }
            transition(modelState4, modelState2, new z8.a(this, 0));
        } catch (Throwable th) {
            throw th;
        }
    }

    public synchronized void close() {
        if (this._state != ModelState.f6331j && this._state != ModelState.f6332k) {
            transition(this._state, ModelState.h, new z8.a(this, 1));
        }
    }

    public final a<n> getOnCleanup() {
        return this.onCleanup;
    }

    public final a<n> getOnClose() {
        return this.onClose;
    }

    public final a<Boolean> getOnInitialize() {
        return this.onInitialize;
    }

    public final a<Boolean> getOnWarmup() {
        return this.onWarmup;
    }

    public ModelState getState() {
        return this._state;
    }

    public synchronized boolean init() {
        return ((Boolean) transition(ModelState.f6326a, ModelState.f6328c, new j0(this, 12))).booleanValue();
    }

    public void removeStateListener(q listener) {
        g.f(listener, "listener");
        this.listeners.remove(listener);
    }

    public final synchronized void setError(Exception error) {
        g.f(error, "error");
        ModelState modelState = this._state;
        this._state = ModelState.f6333l;
        Log.e(TAG, "[" + this.modelId + "] Error in state " + modelState + ": " + error.getMessage());
        for (q qVar : this.listeners) {
            try {
                ModelState modelState2 = ModelState.f6326a;
                qVar.a();
            } catch (Exception e10) {
                Log.e(TAG, "[" + this.modelId + "] Listener error", e10);
            }
        }
    }

    public final void setOnCleanup(a<n> aVar) {
        this.onCleanup = aVar;
    }

    public final void setOnClose(a<n> aVar) {
        this.onClose = aVar;
    }

    public final void setOnInitialize(a<Boolean> aVar) {
        this.onInitialize = aVar;
    }

    public final void setOnWarmup(a<Boolean> aVar) {
        this.onWarmup = aVar;
    }

    public String toString() {
        return "ModelLifecycle[" + this.modelId + ", state=" + this._state + "]";
    }

    public synchronized boolean warmup() {
        boolean zBooleanValue = false;
        if (this._state != ModelState.f6329d) {
            Log.w(TAG, "[" + this.modelId + "] Cannot warmup in state: " + this._state);
            return false;
        }
        try {
            a<Boolean> aVar = this.onWarmup;
            zBooleanValue = aVar != null ? aVar.invoke().booleanValue() : true;
        } catch (Exception e10) {
            Log.e(TAG, "[" + this.modelId + "] Warmup failed", e10);
        }
        if (zBooleanValue) {
            transition(this._state, ModelState.f6330e, new b(20));
        }
        return zBooleanValue;
    }
}
