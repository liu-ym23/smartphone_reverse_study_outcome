package com.bytedance.android.anya;

import com.bytedance.android.anya.MVIState;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public final class j0<STATE extends MVIState<?>> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Set<j0<?>> f41730a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f41731b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Map<Object, Integer> f41732c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Map<Object, Integer> f41733d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public com.bytedance.android.anya.internal.p f41734e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public j0<?> f41735f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final l0<STATE> f41736g;

    public static final class a extends k0<MVIState<?>, a> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f41737a = null;

        static {
            f41737a = new a();
        }

        public a() {
        }
    }

    public final void a() {
        this.f41731b = true;
        j0<?> r100 = this.f41735f;
        if (r100 == null) goto L6;
        r100.a();
        return;
    }

    public final void b() {
        ((LinkedHashMap) this.f41733d).clear();
        ((LinkedHashMap) this.f41732c).clear();
        this.f41731b = false;
        Iterator<T> r100 = this.f41730a.iterator();
    L4:
        if (r100.hasNext() == false) goto L6;
        ((j0) r100.next()).b();
        goto L4
    }

    public final com.bytedance.android.anya.internal.p getContext() {
        com.bytedance.android.anya.internal.p r100 = this.f41734e;
        if (r100 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException(PerfLog.PARAM_KEY_CONTEXT_ID);
    L5:
        return r100;
    }

    public j0(l0<STATE> r100) {
        this.f41736g = r100;
        this.f41730a = new LinkedHashSet();
        this.f41732c = new LinkedHashMap();
        this.f41733d = new LinkedHashMap();
    }
}
