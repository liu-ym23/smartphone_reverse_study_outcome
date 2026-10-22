package com.bytedance.android.gamecp.common.utils;

import java.util.Map;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.collections.AbstractMap;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes44.dex */
public final class ReadonlyJSONObjectMap extends AbstractMap<String, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Lazy f57185a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final JSONObject f57186b;

    @Override // kotlin.collections.AbstractMap, androidx.compose.runtime.external.kotlinx.collections.immutable.ImmutableMap
    public final Set<Map.Entry<String, Object>> getEntries() {
        return (Set) this.f57185a.getValue();
    }

    @Override // kotlin.collections.AbstractMap
    public final int getSize() {
        return this.f57186b.length();
    }

    public ReadonlyJSONObjectMap(JSONObject r100) {
        Intrinsics.checkNotNullParameter(r100, "delegate");
        this.f57186b = r100;
        this.f57185a = LazyKt.lazy(new ReadonlyJSONObjectMap$entries$2(this));
    }

    @Override // kotlin.collections.AbstractMap, java.util.Map
    public final /* bridge */ boolean containsKey(Object r100) {
        if ((r100 instanceof String) == true) goto L7;
        return false;
    L7:
        return super.containsKey((String) r100);
    }

    @Override // kotlin.collections.AbstractMap, java.util.Map
    public final Object get(Object r100) {
        if ((r100 instanceof String) == true) goto L5;
        return null;
    L5:
        String r101 = (String) r100;
        Intrinsics.checkNotNullParameter(r101, "key");
        Object r102 = this.f57186b.get(r101);
        if (r102 != null) goto L8;
        return null;
    L8:
        return UtilsKt.a(r102);
    }

    @Override // java.util.Map
    public final /* bridge */ Object getOrDefault(Object r100, Object r101) {
        if ((r100 instanceof String) == true) goto L6;
        return r101;
    L6:
        return super.getOrDefault((String) r100, r101);
    }
}
