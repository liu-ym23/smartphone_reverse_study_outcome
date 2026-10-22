package com.bytedance.android.live.core.tetris.layer.core.event;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.OnLifecycleEvent;
import com.bytedance.android.livesdkapi.LiveCommonConstants;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import o70.b;
import o70.c;

/* JADX INFO: loaded from: classes45.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0001\u0006B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\u0003\u001a\u00020\u0002H\u0007¨\u0006\u0007"}, d2 = {"Lcom/bytedance/android/live/core/tetris/layer/core/event/LayerEventDispatcher;", "Landroidx/lifecycle/LifecycleObserver;", "", LiveCommonConstants.REASON_ON_DEDTROY, "<init>", "()V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "tetris_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LayerEventDispatcher implements LifecycleObserver {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final HashMap<Class<? extends b>, HashSet<o70.a>> f65767a;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final List<Class<? extends b>> f65768a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final o70.a f65769b;

        public final boolean equals(Object r100) {
            if (this != r100) goto L4;
            return true;
        L4:
            if ((r100 instanceof a) == false) goto L10;
            a r101 = (a) r100;
            if (Intrinsics.areEqual(this.f65768a, r101.f65768a) == true) goto L8;
            return false;
        L8:
            if (Intrinsics.areEqual(this.f65769b, r101.f65769b) == true) goto L16;
            return false;
        L16:
            return true;
        L10:
            return false;
        }

        public final int hashCode() {
            List<Class<? extends b>> r100 = this.f65768a;
            int r101 = 0;
            if (r100 == null) goto L5;
            int r102 = r100.hashCode();
        L6:
            int r103 = r102 * 31;
            o70.a r104 = this.f65769b;
            if (r104 == null) goto L10;
            r101 = r104.hashCode();
        L10:
            return r103 + r101;
        L5:
            r102 = 0;
            goto L6
        }

        public final String toString() {
            return "EventPair(list=" + this.f65768a + ", resolver=" + this.f65769b + ")";
        }

        /* JADX WARN: Multi-variable type inference failed */
        public a(List<? extends Class<? extends b>> r100, o70.a r101) {
            Intrinsics.checkNotNullParameter(r100, "list");
            Intrinsics.checkNotNullParameter(r101, "resolver");
            this.f65768a = r100;
            this.f65769b = r101;
        }
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    public final void onDestroy() {
        HashMap<Integer, LayerEventDispatcher> r100 = c.f522253a;
        Intrinsics.checkNotNullParameter(this, "layerEventDispatcher");
        HashMap<LayerEventDispatcher, Integer> r101 = c.f522254b;
        if (r101.containsKey(this) == false) goto L5;
        Integer r102 = r101.get(this);
        r101.remove(this);
        HashMap<Integer, LayerEventDispatcher> r103 = c.f522253a;
        Intrinsics.checkNotNull(r102);
        r103.remove(r102);
    L5:
        this.f65767a.clear();
    }

    public LayerEventDispatcher() {
        this.f65767a = new HashMap();
    }

    public final void a(o70.a r100) {
        ArrayList r101 = new ArrayList();
        if (r100 == null) goto L5;
        r101.add(new a(r100.Mg(), r100));
    L5:
        Iterator r102 = r101.iterator();
    L7:
        if (r102.hasNext() == false) goto L16;
        a r103 = (a) r102.next();
        Iterator<T> r104 = r103.f65768a.iterator();
    L10:
        if (r104.hasNext() == false) goto L7;
        Class<? extends b> r105 = (Class) r104.next();
        if (this.f65767a.containsKey(r105) == false) goto L14;
        HashSet<o70.a> r106 = this.f65767a.get(r105);
        Intrinsics.checkNotNull(r106);
        HashSet<o70.a> r107 = r106;
    L15:
        r107.add(r103.f65769b);
        goto L10
    L14:
        HashSet<o70.a> r108 = new HashSet();
        this.f65767a.put(r105, r108);
        r107 = r108;
        goto L15
    }

    public final void b(b r100) {
        Intrinsics.checkNotNullParameter(r100, "event");
        HashSet<o70.a> r101 = this.f65767a.get(r100.getClass());
        if (r101 == null) goto L8;
        Iterator<T> r102 = r101.iterator();
    L6:
        if (r102.hasNext() == false) goto L10;
        ((o70.a) r102.next()).onEvent(r100);
        goto L6
    L10:
        return;
    }
}
