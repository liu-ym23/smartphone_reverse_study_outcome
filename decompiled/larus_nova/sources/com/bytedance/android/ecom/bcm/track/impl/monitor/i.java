package com.bytedance.android.ecom.bcm.track.impl.monitor;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: classes44.dex */
public final class i implements g {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f51116b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final g f51117c;

    public i(String r100, g r101) {
        this.f51116b = r100;
        this.f51117c = r101;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bytedance.android.ecom.bcm.track.impl.monitor.g
    public final void a(JsonElement r100, n r101) {
        if ((r100 instanceof JsonObject) == true) goto L5;
        r101.f51128b.add(new n.a(2));
    L8:
        List r102 = null;
    L13:
        if (r102 == null) goto L18;
        Iterator r103 = r102.iterator();
    L16:
        if (r103.hasNext() == false) goto L20;
        JsonElement r104 = (JsonElement) r103.next();
        this.f51117c.a(r104, r101);
        goto L16
    L20:
        return;
    L18:
        return;
    L5:
        JsonElement r105 = j.a((JsonObject) r100, this.f51116b);
        if (r105.isJsonNull() == false) goto L10;
        r101.f51128b.add(new n.a(2));
        goto L8
    L10:
        if ((r105 instanceof JsonArray) == false) goto L12;
        r102 = CollectionsKt.toList((Iterable) r105);
        goto L13
    L12:
        r102 = CollectionsKt.listOf(r105);
        goto L13
    }
}
