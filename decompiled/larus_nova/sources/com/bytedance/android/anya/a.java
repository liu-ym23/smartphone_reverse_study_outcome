package com.bytedance.android.anya;

import java.util.Map;

/* JADX INFO: loaded from: classes43.dex */
public abstract class a {

    /* JADX INFO: renamed from: com.bytedance.android.anya.a$a, reason: collision with other inner class name */
    public static final class C0764a extends a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final p f41577a;

        public C0764a(p r100) {
            this.f41577a = r100;
        }
    }

    public static final class b extends a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Object f41578a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Map<Object, j<?>> f41579b;

        /* JADX WARN: Multi-variable type inference failed */
        public b(Object r100, Map<Object, ? extends j<?>> r101) {
            this.f41578a = r100;
            this.f41579b = r101;
        }
    }

    public a() {
    }
}
