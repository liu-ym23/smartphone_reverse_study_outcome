package com.stepos.core.model.inference;

import android.util.Log;
import com.stepos.base.awareness.data.SceneType;
import com.stepos.base.inference.data.BackendType;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.g;
import mb.l;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class InferenceBackendSelector {
    public static final Companion Companion = new Companion(null);
    private static final String TAG = "BackendSelector";
    private final Set<BackendType> availableBackends = new LinkedHashSet();
    private final Map<BackendType, x6.a> performanceCache = new LinkedHashMap();

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class Companion {
        public /* synthetic */ Companion(kotlin.jvm.internal.e eVar) {
            this();
        }

        private Companion() {
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;

        static {
            int[] iArr = new int[SceneType.values().length];
            try {
                SceneType sceneType = SceneType.f6193a;
                iArr[1] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                SceneType sceneType2 = SceneType.f6193a;
                iArr[0] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                SceneType sceneType3 = SceneType.f6193a;
                iArr[2] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                SceneType sceneType4 = SceneType.f6193a;
                iArr[3] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                SceneType sceneType5 = SceneType.f6193a;
                iArr[4] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                SceneType sceneType6 = SceneType.f6193a;
                iArr[5] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                SceneType sceneType7 = SceneType.f6193a;
                iArr[6] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            $EnumSwitchMapping$0 = iArr;
            int[] iArr2 = new int[BackendType.values().length];
            try {
                BackendType.a aVar = BackendType.f6253c;
                iArr2[0] = 1;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                BackendType.a aVar2 = BackendType.f6253c;
                iArr2[1] = 2;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                BackendType.a aVar3 = BackendType.f6253c;
                iArr2[2] = 3;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                BackendType.a aVar4 = BackendType.f6253c;
                iArr2[3] = 4;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                BackendType.a aVar5 = BackendType.f6253c;
                iArr2[4] = 5;
            } catch (NoSuchFieldError unused12) {
            }
            $EnumSwitchMapping$1 = iArr2;
        }
    }

    public InferenceBackendSelector() {
        detectAvailableBackends();
    }

    private final void detectAvailableBackends() {
        if (isNpuAvailable()) {
            Set<BackendType> set = this.availableBackends;
            BackendType backendType = BackendType.f6254d;
            set.add(backendType);
            this.performanceCache.put(backendType, new x6.a(backendType, 200L, 30.0f));
            Log.i(TAG, "NPU backend available");
        }
        if (isGpuAvailable()) {
            Set<BackendType> set2 = this.availableBackends;
            BackendType backendType2 = BackendType.f6255e;
            set2.add(backendType2);
            this.performanceCache.put(backendType2, new x6.a(backendType2, 300L, 20.0f));
            Log.i(TAG, "GPU backend available");
        }
        Set<BackendType> set3 = this.availableBackends;
        BackendType backendType3 = BackendType.f6256j;
        set3.add(backendType3);
        this.performanceCache.put(backendType3, new x6.a(backendType3, 500L, 10.0f));
        Log.i(TAG, "CPU backend available");
        if (this.availableBackends.contains(BackendType.f6254d)) {
            Set<BackendType> set4 = this.availableBackends;
            BackendType backendType4 = BackendType.h;
            set4.add(backendType4);
            this.performanceCache.put(backendType4, new x6.a(backendType4, 250L, 25.0f));
            Log.i(TAG, "HYBRID backend available");
        }
        Log.i(TAG, "Available backends: " + this.availableBackends);
    }

    private final boolean isGpuAvailable() {
        return true;
    }

    private final boolean isNpuAvailable() {
        try {
            System.loadLibrary("QnnHtp");
            return true;
        } catch (Exception e10) {
            a0.a.A("Failed to detect NPU: ", e10.getMessage(), TAG);
            return false;
        } catch (UnsatisfiedLinkError unused) {
            Log.w(TAG, "QNN HTP library not found");
            return false;
        }
    }

    private final BackendType selectFallback(BackendType backendType, SceneType sceneType) {
        int iOrdinal = backendType.ordinal();
        if (iOrdinal == 0) {
            Set<BackendType> set = this.availableBackends;
            BackendType backendType2 = BackendType.h;
            if (set.contains(backendType2)) {
                return backendType2;
            }
            Set<BackendType> set2 = this.availableBackends;
            BackendType backendType3 = BackendType.f6255e;
            return set2.contains(backendType3) ? backendType3 : BackendType.f6256j;
        }
        if (iOrdinal == 1) {
            return BackendType.f6256j;
        }
        if (iOrdinal != 2) {
            if (iOrdinal == 3) {
                return BackendType.f6256j;
            }
            if (iOrdinal == 4) {
                return selectBestAvailable();
            }
            throw new NoWhenBranchMatchedException();
        }
        Set<BackendType> set3 = this.availableBackends;
        BackendType backendType4 = BackendType.f6254d;
        if (set3.contains(backendType4)) {
            return backendType4;
        }
        Set<BackendType> set4 = this.availableBackends;
        BackendType backendType5 = BackendType.f6255e;
        return set4.contains(backendType5) ? backendType5 : BackendType.f6256j;
    }

    public final Set<BackendType> getAvailableBackends() {
        return kotlin.collections.a.R0(this.availableBackends);
    }

    public final x6.a getPerformanceInfo(BackendType type) {
        g.f(type, "type");
        return this.performanceCache.get(type);
    }

    public final boolean isAvailable(BackendType type) {
        g.f(type, "type");
        return this.availableBackends.contains(type);
    }

    public final void refresh() {
        this.availableBackends.clear();
        this.performanceCache.clear();
        detectAvailableBackends();
    }

    public final BackendType select(r6.a decision) {
        g.f(decision, "decision");
        BackendType backendType = decision.f11738b;
        if (this.availableBackends.contains(backendType)) {
            Log.d(TAG, "Using recommended backend: " + backendType);
            return backendType;
        }
        BackendType backendTypeSelectFallback = selectFallback(backendType, decision.f11737a);
        Log.d(TAG, "Fallback from " + backendType + " to " + backendTypeSelectFallback);
        return backendTypeSelectFallback;
    }

    public final BackendType selectBestAvailable() {
        Object next;
        BackendType.f6253c.getClass();
        Iterator it = l.k0(BackendType.values(), new y6.a()).iterator();
        while (true) {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
            if (this.availableBackends.contains((BackendType) next)) {
                break;
            }
        }
        BackendType backendType = (BackendType) next;
        return backendType == null ? BackendType.f6256j : backendType;
    }

    public final BackendType selectByScene(SceneType scene) {
        g.f(scene, "scene");
        switch (scene.ordinal()) {
            case 0:
                return BackendType.f6256j;
            case 1:
                return selectBestAvailable();
            case 2:
                return BackendType.f6256j;
            case 3:
                return BackendType.f6256j;
            case 4:
                return selectMostEfficient();
            case 5:
                return BackendType.f6256j;
            case 6:
                return BackendType.f6256j;
            default:
                throw new NoWhenBranchMatchedException();
        }
    }

    public final BackendType selectMostEfficient() {
        Object obj;
        Iterator<T> it = this.availableBackends.iterator();
        if (it.hasNext()) {
            Object next = it.next();
            if (it.hasNext()) {
                int i10 = ((BackendType) next).f6260b;
                do {
                    Object next2 = it.next();
                    int i11 = ((BackendType) next2).f6260b;
                    if (i10 > i11) {
                        next = next2;
                        i10 = i11;
                    }
                } while (it.hasNext());
            }
            obj = next;
        } else {
            obj = null;
        }
        BackendType backendType = (BackendType) obj;
        return backendType == null ? BackendType.f6256j : backendType;
    }
}
