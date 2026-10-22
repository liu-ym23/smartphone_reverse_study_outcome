package com.bytedance.android.shopping.store.home.api;

import android.net.Uri;
import com.bytedance.mt.protector.impl.UriProtector;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;
import java.util.HashSet;
import java.util.Iterator;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f183602a = 0;

    static {
    }

    public static void a(JsonObject r100, Uri r101) {
        Iterator r102 = new HashSet(r100.keySet()).iterator();
    L4:
        if (r102.hasNext() == false) goto L19;
        String r103 = (String) r102.next();
        JsonElement r104 = r100.get(r103);
        if ((r104 instanceof JsonPrimitive) == false) goto L17;
        JsonPrimitive r105 = (JsonPrimitive) r104;
        if (r105.isString() == false) goto L17;
        if (Intrinsics.areEqual(r105.getAsString(), "$from_schema$") == false) goto L17;
        if (r101 == null) goto L14;
        String r106 = UriProtector.getQueryParameter(r101, r103);
        if (r106 == null) goto L14;
    L15:
        r100.addProperty(r103, r106);
    L14:
        r106 = "";
    L17:
        if ((r104 instanceof JsonObject) == false) goto L4;
        a((JsonObject) r104, r101);
        goto L4
    }
}
