package com.bytedance.android.annie.param;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public final class JsGsonMap extends GsonMap {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final JsonObject f39685c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Lazy f39686d;

    @Override // com.bytedance.android.annie.param.GsonMap
    public final Set<Map.Entry<String, Object>> b() {
        return (Set) this.f39686d.getValue();
    }

    @Override // com.bytedance.android.annie.param.GsonMap
    public final Collection<Object> c() {
        Set<Map.Entry<String, JsonElement>> r100 = this.f39685c.entrySet();
        LinkedHashSet r101 = new LinkedHashSet();
        Iterator<T> r102 = r100.iterator();
    L4:
        if (r102.hasNext() == false) goto L6;
        r101.add(UtilsKt.a((JsonElement) ((Map.Entry) r102.next()).getValue()));
        goto L4
    L6:
        return r101;
    }

    public JsGsonMap(JsonObject r100) {
        Intrinsics.checkNotNullParameter(r100, "delegate");
        super(r100);
        this.f39685c = r100;
        this.f39686d = LazyKt.lazy(new JsGsonMap$entries$2(this));
    }

    @Override // com.bytedance.android.annie.param.GsonMap
    public final Object a(String r100) {
        Intrinsics.checkNotNullParameter(r100, "key");
        JsonElement r101 = this.f39685c.get(r100);
        if (r101 != null) goto L7;
        return null;
    L7:
        return UtilsKt.a(r101);
    }
}
