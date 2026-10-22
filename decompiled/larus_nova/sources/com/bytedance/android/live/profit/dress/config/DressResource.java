package com.bytedance.android.live.profit.dress.config;

import io.reactivex.subjects.BehaviorSubject;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: classes47.dex */
public abstract class DressResource {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<String, a<?>> f87083a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final BehaviorSubject<w<DressResource>> f87084b;

    public static abstract class a<T> {

        /* JADX INFO: renamed from: com.bytedance.android.live.profit.dress.config.DressResource$a$a, reason: collision with other inner class name */
        public static final class C1332a<T> extends a<T> {
            public C1332a() {
            }
        }

        public static final class b extends a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final b f87085a = null;

            static {
                f87085a = new b();
            }

            public b() {
            }
        }

        public static final class c extends a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final c f87086a = null;

            static {
                f87086a = new c();
            }

            public c() {
            }
        }

        public static final class d<T> extends a<T> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final T f87087a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final boolean f87088b;

            public d(T r100, boolean r101) {
                this.f87087a = r100;
                this.f87088b = r101;
            }
        }

        public a() {
        }
    }

    public final boolean a() {
        Map<String, a<?>> r100 = this.f87083a;
        if (r100.isEmpty() == true) goto L19;
        Iterator<Map.Entry<String, a<?>>> r101 = r100.entrySet().iterator();
    L7:
        if (r101.hasNext() == false) goto L20;
        a<?> r102 = r101.next().getValue();
        Intrinsics.checkNotNullParameter(r102, "$this$isFromLocal");
        if ((r102 instanceof a.d) == false) goto L11;
        Boolean r103 = Boolean.valueOf(((a.d) r102).f87088b);
    L13:
        if (Intrinsics.areEqual(r103, Boolean.TRUE) == true) goto L7;
        return false;
    L11:
        r103 = null;
        goto L13
    L20:
        return true;
    L19:
        return true;
    }

    public final boolean b() {
        Map<String, a<?>> r100 = this.f87083a;
        if (r100.isEmpty() == true) goto L23;
        Iterator<Map.Entry<String, a<?>>> r101 = r100.entrySet().iterator();
    L7:
        if (r101.hasNext() == false) goto L24;
        a<?> r102 = r101.next().getValue();
        Intrinsics.checkNotNullParameter(r102, "$this$isFinished");
        if ((r102 instanceof a.d) == false) goto L12;
    L13:
        boolean r103 = true;
    L15:
        if (r103 == true) goto L7;
        return false;
    L12:
        if ((r102 instanceof a.C1332a) == true) goto L13;
        r103 = false;
        goto L15
    L24:
        return true;
    L23:
        return true;
    }

    public final String c() {
        StringBuilder r100 = new StringBuilder();
        Iterator<Map.Entry<String, a<?>>> r101 = this.f87083a.entrySet().iterator();
    L4:
        if (r101.hasNext() == false) goto L11;
        Map.Entry<String, a<?>> r102 = r101.next();
        String r103 = r102.getKey();
        a<?> r104 = r102.getValue();
        r100.append(r103 + '#');
        if ((r104 instanceof a.C1332a) == false) goto L8;
        String r105 = String.valueOf(r104);
    L9:
        r100.append(r105 + ',');
        goto L4
    L8:
        r105 = Reflection.getOrCreateKotlinClass(r104.getClass()).getSimpleName();
        goto L9
    L11:
        return r100.toString();
    }

    public DressResource() {
        this.f87083a = MapsKt.withDefaultMutable(new LinkedHashMap(), DressResource$contents$1.INSTANCE);
        int r100 = com.bytedance.revenue.platform.api.core.rx.c.f267509a;
        this.f87084b = BehaviorSubject.create();
    }
}
