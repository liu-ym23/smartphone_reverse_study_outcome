package com.bytedance.android.live.core.utils;

import android.content.Context;
import android.content.SharedPreferences;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
public final class u1 implements com.bytedance.android.tools.superkv.e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final SharedPreferences f66409a;

    @Override // com.bytedance.android.tools.superkv.e
    public final List b() {
        Intrinsics.checkNotNullParameter("__prefetch_cache_key_array", "key");
        if (this.f66409a.contains("__prefetch_cache_key_array") == false) goto L7;
        Set<String> r100 = this.f66409a.getStringSet("__prefetch_cache_key_array", SetsKt.emptySet());
        if (r100 == null) goto L7;
        return CollectionsKt.toMutableList(r100);
    L7:
        return null;
    }

    @Override // com.bytedance.android.tools.superkv.e
    public final void a(Collection r100) {
        Intrinsics.checkNotNullParameter("__prefetch_cache_key_array", "key");
        Intrinsics.checkNotNullParameter(r100, "value");
        this.f66409a.edit().putStringSet("__prefetch_cache_key_array", CollectionsKt.toSet(r100)).apply();
    }

    @Override // com.bytedance.android.tools.superkv.e
    public final String getString(String r100) {
        Intrinsics.checkNotNullParameter(r100, "key");
        if (this.f66409a.contains(r100) == true) goto L5;
        return null;
    L5:
        return this.f66409a.getString(r100, "");
    }

    @Override // com.bytedance.android.tools.superkv.e
    public final void remove(String r100) {
        Intrinsics.checkNotNullParameter(r100, "key");
        this.f66409a.edit().remove(r100).apply();
    }

    public u1(Context r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "key");
        this.f66409a = r100.getSharedPreferences(r101, 0);
    }

    @Override // com.bytedance.android.tools.superkv.e
    public final void putString(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "key");
        Intrinsics.checkNotNullParameter(r101, "value");
        this.f66409a.edit().putString(r100, r101).apply();
    }
}
