package com.bytedance.android.anya;

import com.bytedance.android.anya.MVIState;
import com.bytedance.android.anya.h;

/* JADX INFO: loaded from: classes43.dex */
@AnyaDSL
public abstract class h<STATE extends MVIState<?>, CONTEXT extends h<STATE, CONTEXT>> {
    public h() {
    }

    public static int a(t0 r100) {
        return ((com.bytedance.android.anya.internal.u) r100).c().size();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static Object b(u r100) {
        return ((com.bytedance.android.anya.internal.c) r100).c();
    }
}
