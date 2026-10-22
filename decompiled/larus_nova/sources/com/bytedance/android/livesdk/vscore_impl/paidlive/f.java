package com.bytedance.android.livesdk.vscore_impl.paidlive;

import android.net.Uri;
import com.bytedance.android.livesdk.chatroom.paidlive.PaidRoomContext;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.live.datacontext.m;
import com.bytedance.mt.protector.impl.UriProtector;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
public final class f {
    public static final m<Room> b(com.bytedance.android.livesdk.vscore_api.paidlive.d r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$room");
        return ((PaidRoomContext) r100).getRoom();
    }

    public static final Integer c(JsonObject r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$optInt");
        return (Integer) d(r100, "status_code", PaidExtKt$optInt$1.INSTANCE, PaidExtKt$optInt$2.INSTANCE);
    }

    public static final String e(JsonObject r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$optString");
        return (String) d(r100, "status_msg", PaidExtKt$optString$1.INSTANCE, PaidExtKt$optString$2.INSTANCE);
    }

    public static final com.bytedance.android.livesdk.vscore_api.paidlive.ability.i g(com.bytedance.android.livesdk.vscore_api.paidlive.e r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$teaLog");
        return (com.bytedance.android.livesdk.vscore_api.paidlive.ability.i) r100.getAbility(com.bytedance.android.livesdk.vscore_api.paidlive.ability.i.class);
    }

    public static final com.bytedance.android.livesdk.vscore_api.paidlive.ability.i h(com.bytedance.android.livesdk.vscore_api.paidlive.scope.a r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$teaLog");
        com.bytedance.android.livesdk.vscore_api.paidlive.e r101 = com.bytedance.android.livesdk.vscore_api.paidlive.scope.g.b(r100).E1(r100.i0());
        if (r101 != null) goto L7;
        return null;
    L7:
        return g(r101);
    }

    public static final String a(String r100, Map<String, String> r101) {
        Intrinsics.checkNotNullParameter(r101, "params");
        if (r100 != null) goto L5;
    L8:
        boolean r102 = true;
    L9:
        if (r102 == false) goto L11;
        return r100;
    L11:
        Uri r103 = UriProtector.parse(r100);
        Uri.Builder r104 = r103.buildUpon();
        Set<String> r105 = UriProtector.getQueryParameterNames(r103);
        Iterator<String> r106 = r101.keySet().iterator();
    L13:
        if (r106.hasNext() == false) goto L18;
        String r107 = r106.next();
        if (r105.contains(r107) == true) goto L13;
        r104.appendQueryParameter(r107, r101.get(r107));
        goto L13
    L18:
        return r104.build().toString();
    L5:
        if (r100.length() == 0) goto L8;
        r102 = false;
        goto L9
    }

    public static final Uri f(Uri r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "$this$replaceQuery");
        Intrinsics.checkNotNullParameter("url", "query");
        Intrinsics.checkNotNullParameter(r101, "value");
        Uri.Builder r102 = r100.buildUpon().clearQuery();
        Iterator<T> r103 = UriProtector.getQueryParameterNames(r100).iterator();
    L4:
        if (r103.hasNext() == false) goto L8;
        String r104 = (String) r103.next();
        if ((!Intrinsics.areEqual(r104, "url")) == false) goto L4;
        r102.appendQueryParameter(r104, UriProtector.getQueryParameter(r100, r104));
        goto L4
    L8:
        r102.appendQueryParameter("url", r101);
        return r102.build();
    }

    public static final <T> T d(JsonObject r100, String r101, Function1<? super JsonPrimitive, Boolean> r102, Function1<? super JsonPrimitive, ? extends T> r103) {
        Intrinsics.checkNotNullParameter(r100, "$this$optPrimitive");
        Intrinsics.checkNotNullParameter(r102, "typeValidator");
        Intrinsics.checkNotNullParameter(r103, "valueGetter");
        Intrinsics.checkNotNullParameter(r100, "$this$optPrimitive");
        PaidExtKt$optPrimitive$2 r104 = PaidExtKt$optPrimitive$2.INSTANCE;
        PaidExtKt$optPrimitive$3 r105 = PaidExtKt$optPrimitive$3.INSTANCE;
        Intrinsics.checkNotNullParameter(r100, "$this$optElement");
        Intrinsics.checkNotNullParameter(r104, "typeValidator");
        Intrinsics.checkNotNullParameter(r105, "valueGetter");
        if (r100.has(r101) == false) goto L11;
        JsonElement r106 = r100.get(r101);
        if (r106 == null) goto L11;
        if (r104.invoke(r106).booleanValue() == false) goto L11;
        JsonPrimitive r107 = r105.invoke(r106);
    L12:
        JsonPrimitive r108 = r107;
        if (r108 != null) goto L15;
        return null;
    L15:
        if (r102.invoke(r108).booleanValue() == true) goto L17;
        return null;
    L17:
        return r103.invoke(r108);
    L11:
        r107 = null;
        goto L12
    }
}
