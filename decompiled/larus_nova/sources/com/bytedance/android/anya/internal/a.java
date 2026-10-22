package com.bytedance.android.anya.internal;

import com.bytedance.android.anya.BaseMVIViewModel;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Map<C0765a, Boolean> f41638a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Map<Class<?>, Class<?>> f41639b = null;

    /* JADX INFO: renamed from: com.bytedance.android.anya.internal.a$a, reason: collision with other inner class name */
    public static final class C0765a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Class<? extends BaseMVIViewModel<?, ?>> f41640a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Class<? extends com.bytedance.android.anya.p> f41641b;

        public final boolean equals(Object r100) {
            if (this != r100) goto L4;
            return true;
        L4:
            if ((r100 instanceof C0765a) == false) goto L10;
            C0765a r101 = (C0765a) r100;
            if (Intrinsics.areEqual(this.f41640a, r101.f41640a) == true) goto L8;
            return false;
        L8:
            if (Intrinsics.areEqual(this.f41641b, r101.f41641b) == true) goto L16;
            return false;
        L16:
            return true;
        L10:
            return false;
        }

        public final int hashCode() {
            Class<? extends BaseMVIViewModel<?, ?>> r100 = this.f41640a;
            int r101 = 0;
            if (r100 == null) goto L5;
            int r102 = r100.hashCode();
        L6:
            int r103 = r102 * 31;
            Class<? extends com.bytedance.android.anya.p> r104 = this.f41641b;
            if (r104 == null) goto L10;
            r101 = r104.hashCode();
        L10:
            return r103 + r101;
        L5:
            r102 = 0;
            goto L6
        }

        public final String toString() {
            return "CacheEntry(viewModelType=" + this.f41640a + ", actionType=" + this.f41641b + ")";
        }

        public C0765a(Class<? extends BaseMVIViewModel<?, ?>> r100, Class<? extends com.bytedance.android.anya.p> r101) {
            this.f41640a = r100;
            this.f41641b = r101;
        }
    }

    static {
        f41638a = new LinkedHashMap();
        f41639b = new LinkedHashMap();
    }
}
