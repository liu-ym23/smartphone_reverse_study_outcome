package com.bytedance.android.livesdk.utils;

import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
public final class b7<K, V> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<K, V> f158897a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Function1<Map<K, ? extends V>, Unit> f158898b;

    public b7(com.bytedance.android.livesdk.chatroom.viewmodule.k r100) {
        Intrinsics.checkNotNullParameter(r100, "applyVisibility");
        this.f158898b = r100;
        LinkedHashMap r101 = new LinkedHashMap();
        this.f158897a = r101;
        r100.invoke(r101);
    }

    /* JADX WARN: Type inference incomplete: some casts might be missing */
    public final void b(K r100) {
        this.f158897a.remove(r100);
        this.f158898b.invoke((Map<K, ? extends V>) this.f158897a);
    }

    /* JADX WARN: Type inference incomplete: some casts might be missing */
    public final void a(K r100, V r101) {
        this.f158897a.put(r100, r101);
        this.f158898b.invoke((Map<K, ? extends V>) this.f158897a);
    }
}
