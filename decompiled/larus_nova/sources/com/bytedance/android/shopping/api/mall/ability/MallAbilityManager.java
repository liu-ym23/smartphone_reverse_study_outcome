package com.bytedance.android.shopping.api.mall.ability;

import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.OnLifecycleEvent;
import com.bytedance.android.livesdkapi.LiveCommonConstants;
import e93.d;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class MallAbilityManager {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ConcurrentHashMap<Class<? extends d>, Map<String, a<? extends d>>> f170215a = null;

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u00012\u00020\u0003J\b\u0010\u0005\u001a\u00020\u0004H\u0007¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/shopping/api/mall/ability/MallAbilityManager$LifecycleObserverWrapper;", "Le93/d;", ExifInterface.GPS_DIRECTION_TRUE, "Landroidx/lifecycle/LifecycleObserver;", "", LiveCommonConstants.REASON_ON_DEDTROY, "mall-api_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class LifecycleObserverWrapper<T extends d> implements LifecycleObserver {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Class<T> f170216a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final T f170217b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final String f170218c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final LifecycleOwner f170219d;

        @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
        public final void onDestroy() {
            ConcurrentHashMap<Class<? extends d>, Map<String, a<? extends d>>> r100 = MallAbilityManager.f170215a;
            Class<T> r101 = this.f170216a;
            String r102 = this.f170218c;
            Intrinsics.checkNotNullParameter(r101, "clazz");
            Intrinsics.checkNotNullParameter(r102, "key");
            ConcurrentHashMap<Class<? extends d>, Map<String, a<? extends d>>> r103 = MallAbilityManager.f170215a;
            Map<String, a<? extends d>> r104 = r103.get(r101);
            if (r104 == null) goto L13;
            a<? extends d> r105 = r104.get(r102);
            if (r105 == null) goto L14;
            LifecycleObserverWrapper<T> r106 = r105.f170221b;
            if (r106 == null) goto L9;
            r106.f170219d.getLifecycle().removeObserver(r106);
        L9:
            Map<String, a<? extends d>> r107 = r103.get(r101);
            if (r107 == null) goto L15;
            a<? extends d> r108 = r107.remove(r102);
            return;
        L15:
            return;
        L14:
            return;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public LifecycleObserverWrapper(Class r100, d r101, String r102, Fragment r103) {
            Intrinsics.checkNotNullParameter(r100, "clazz");
            Intrinsics.checkNotNullParameter(r101, "ability");
            Intrinsics.checkNotNullParameter(r102, "key");
            Intrinsics.checkNotNullParameter(r103, "owner");
            this.f170216a = r100;
            this.f170217b = r101;
            this.f170218c = r102;
            this.f170219d = r103;
        }
    }

    public static final class a<T extends d> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final T f170220a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final LifecycleObserverWrapper<T> f170221b;

        public a(T r100, LifecycleObserverWrapper<T> r101) {
            Intrinsics.checkNotNullParameter(r100, "ability");
            this.f170220a = r100;
            this.f170221b = r101;
        }
    }

    static {
        f170215a = new ConcurrentHashMap();
    }

    public static d b(Class r100, Fragment r101) {
        Intrinsics.checkNotNullParameter(r100, "clazz");
        Intrinsics.checkNotNullParameter(r101, "lifecycleOwner");
        String r102 = String.valueOf(r101.hashCode());
        Map<String, a<? extends d>> r103 = f170215a.get(r100);
        if (r103 == null) goto L7;
        a<? extends d> r104 = r103.get(r102);
        if (r104 == null) goto L7;
        d r105 = r104.f170220a;
    L9:
        if ((r105 instanceof d) == true) goto L12;
        return null;
    L12:
        return r105;
    L7:
        r105 = null;
        goto L9
    }

    public static void a(Class r100, d r101, Fragment r102) {
        Intrinsics.checkNotNullParameter(r100, "clazz");
        Intrinsics.checkNotNullParameter(r101, "ability");
        Intrinsics.checkNotNullParameter(r102, "lifecycleOwner");
        String r103 = String.valueOf(r102.hashCode());
        if (r102.getLifecycle().getCurrentState() == Lifecycle.State.DESTROYED) goto L22;
        ConcurrentHashMap<Class<? extends d>, Map<String, a<? extends d>>> r104 = f170215a;
        if (r104.get(r100) != null) goto L8;
        r104.put(r100, new LinkedHashMap());
    L8:
        Map<String, a<? extends d>> r105 = r104.get(r100);
        if (r105 == null) goto L11;
        a<? extends d> r106 = r105.get(r103);
    L12:
        LifecycleObserverWrapper r107 = new LifecycleObserverWrapper(r100, r101, r103, r102);
        r102.getLifecycle().addObserver(r107);
        Map<String, a<? extends d>> r108 = r104.get(r100);
        if (r108 == null) goto L15;
        a<? extends d> r109 = r108.put(r103, new a(r101, r107));
    L15:
        if (r106 == null) goto L20;
        LifecycleObserverWrapper<T> r110 = r106.f170221b;
        if (r110 == 0) goto L21;
        r110.f170219d.getLifecycle().removeObserver(r110);
        return;
    L21:
        return;
    L20:
        return;
    L11:
        r106 = null;
        goto L12
    }
}
