package com.bytedance.android.ecom.bcm.track.impl.monitor;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonNull;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.text.Regex;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes44.dex */
public final class p implements g {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f51134b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f51135c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f51136d;

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bytedance.android.ecom.bcm.track.impl.monitor.g
    public final void a(JsonElement r110, n r111) {
        if ((r110 instanceof JsonObject) == true) goto L6;
        r111.f51128b.add(new n.a(2));
        return;
    L6:
        JsonElement r112 = j.a((JsonObject) r110, this.f51134b);
        boolean r100 = r112 instanceof JsonObject;
        boolean r101 = false;
        if (r100 == false) goto L12;
        if (((JsonObject) r112).size() > 0) goto L18;
    L19:
        boolean r102 = false;
    L20:
        if (r102 == true) goto L23;
        r111.f51128b.add(new n.a(2));
        return;
    L23:
        String r103 = this.f51135c;
        if (r103 != null) goto L26;
    L27:
        r101 = true;
    L28:
        if (r101 == false) goto L34;
        List<n.a> r113 = r111.f51128b;
        if (this.f51136d == false) goto L32;
        String r114 = r112.toString();
    L33:
        r113.add(new n.a(true, r114));
        return;
    L32:
        r114 = "has_value";
        goto L33
    L34:
        if (r100 == false) goto L37;
        String r115 = r112.toString();
    L43:
        boolean r104 = new Regex(this.f51135c).matches(r115);
        r111.f51128b.add(new n.a(r104, r115));
        return;
    L37:
        if ((r112 instanceof JsonPrimitive) == false) goto L40;
        r115 = ((JsonPrimitive) r112).getAsString();
        goto L43
    L40:
        if ((r112 instanceof JsonArray) == false) goto L42;
        r115 = CollectionsKt.joinToString$default((Iterable) r112, null, "[", "]", 0, null, PointCheckerKt$snapshot$1.INSTANCE, 25, null);
        goto L43
    L42:
        r115 = "no_value";
        goto L43
    L26:
        if (StringsKt.isBlank(r103) == false) goto L28;
    L18:
        r102 = true;
        goto L20
    L12:
        if ((r112 instanceof JsonArray) == false) goto L17;
        if (((JsonArray) r112).size() <= 0) goto L19;
    L17:
        if ((r112 instanceof JsonNull) == true) goto L19;
        goto L18
    }

    public p(String r100, String r101, boolean r102) {
        this.f51134b = r100;
        this.f51135c = r101;
        this.f51136d = r102;
    }
}
