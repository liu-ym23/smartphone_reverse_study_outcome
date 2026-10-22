package com.bytedance.android.livesdk.gift.platform.business.effect.assets;

import java.io.File;
import java.util.Comparator;
import java.util.PriorityQueue;

/* JADX INFO: loaded from: classes9.dex */
public final class b implements dy0.c, com.bytedance.android.scope.o {

    public static final class a<T> implements Comparator {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f129080a = null;

        static {
            f129080a = new a();
        }

        public a() {
        }

        @Override // java.util.Comparator
        public final int compare(Object r100, Object r101) {
            long r102 = ((com.bytedance.android.livesdk.gift.platform.core.scope.service.l) r101).f131626f - ((com.bytedance.android.livesdk.gift.platform.core.scope.service.l) r100).f131626f;
            if (r102 <= 0) goto L5;
            return 1;
        L5:
            if (r102 != 0) goto L7;
            return 0;
        L7:
            return -1;
        }
    }

    public b() {
    }

    @Override // com.bytedance.android.scope.o
    public final void onStart() {
    }

    @Override // com.bytedance.android.scope.o
    public final void onStop() {
    }

    public static PriorityQueue a(File[] r110, long r111) {
        long r100 = System.currentTimeMillis() / ((long) 1000);
        PriorityQueue r101 = new PriorityQueue(20, a.f129080a);
        int r102 = r110.length;
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L14;
        File r104 = r110[r103];
        if (r104.exists() == false) goto L13;
        String r112 = r104.getName();
        if (r112.equals("zip") == true) goto L13;
        long r113 = r100 - com.bytedance.android.livesdk.gift.platform.core.keva_store.a.c(r112);
        if (r113 <= r111) goto L13;
        r101.add(new com.bytedance.android.livesdk.gift.platform.core.scope.service.l(0, r112, null, r104.getPath(), r113, 11));
    L13:
        r103 = r103 + 1;
        goto L3
    L14:
        return r101;
    }
}
