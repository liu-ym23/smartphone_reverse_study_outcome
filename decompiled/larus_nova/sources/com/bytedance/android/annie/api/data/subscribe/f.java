package com.bytedance.android.annie.api.data.subscribe;

import com.google.gson.JsonElement;
import com.google.gson.JsonNull;
import com.google.gson.JsonObject;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes43.dex */
public final /* synthetic */ class f<T> {
    public static c e(g r100) {
        Object r101 = r100.g();
        if ((r101 instanceof JsonElement) == false) goto L5;
        JsonElement r102 = (JsonElement) r101;
    L7:
        return new c(r100, r101, r102);
    L5:
        r102 = d.b(r101);
        goto L7
    }

    public static JsonElement a(g r100, String r101) {
        Intrinsics.checkNotNullParameter(r101, "key");
        Object r102 = r100.g();
        if (r102 == null) goto L16;
        if ((r102 instanceof JsonElement) == false) goto L7;
        JsonElement r103 = (JsonElement) r102;
    L8:
        if (r103 == null) goto L16;
        if (r103.isJsonObject() == true) goto L14;
        return r103;
    L14:
        return r100.f(r101, r103);
    L7:
        r103 = d.b(r102);
    L16:
        return new JsonObject();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v2, types: [T, com.google.gson.JsonObject] */
    /* JADX WARN: Type inference failed for: r3v2, types: [T, com.google.gson.JsonElement, com.google.gson.JsonObject] */
    public static JsonObject d(List r100, JsonElement r101) {
        Intrinsics.checkNotNullParameter(r100, "paths");
        Intrinsics.checkNotNullParameter(r101, "element");
        ?? r102 = (T) new JsonObject();
        Ref.ObjectRef r103 = new Ref.ObjectRef();
        r103.element = r102;
        Iterator<T> r104 = r100.iterator();
        int r105 = 0;
    L4:
        if (r104.hasNext() == false) goto L17;
        T r106 = r104.next();
        int r107 = r105 + 1;
        if (r105 >= 0) goto L8;
        CollectionsKt.throwIndexOverflow();
    L8:
        String r108 = (String) r106;
        if ((r101 instanceof JsonObject) == false) goto L11;
        r101 = r101.getAsJsonObject().get(r108);
    L13:
        if (r105 != (r100.size() - 1)) goto L15;
        ((JsonObject) r103.element).getAsJsonObject().add(r108, r101);
    L16:
        r105 = r107;
        goto L4
    L15:
        ?? r109 = (T) new JsonObject();
        ((JsonObject) r103.element).getAsJsonObject().add(r108, r109);
        r103.element = r109;
        goto L16
    L11:
        r101 = JsonNull.INSTANCE;
        goto L13
    L17:
        return r102;
    }

    public static JsonElement b(g r100, String r101, String r102) {
        Intrinsics.checkNotNullParameter(r101, "key");
        Intrinsics.checkNotNullParameter(r102, "url");
        return r100.a(r101);
    }

    public static JsonElement c(g r100, String r110, JsonElement r111) {
        Intrinsics.checkNotNullParameter(r110, "keyParam");
        Intrinsics.checkNotNullParameter(r111, "element");
        if (r110.length() != 0) goto L5;
        boolean r101 = true;
    L6:
        if (r101 == false) goto L9;
        return r111;
    L9:
        return r100.h(StringsKt.split$default(r110, new char[]{r100.d()}, false, 0, 6, null), r111);
    L5:
        r101 = false;
        goto L6
    }
}
