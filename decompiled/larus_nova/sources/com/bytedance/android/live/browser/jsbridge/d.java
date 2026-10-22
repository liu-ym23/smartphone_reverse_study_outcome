package com.bytedance.android.live.browser.jsbridge;

import com.bytedance.android.live.GsonHelper;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.livesdkapi.depend.message.MessageType;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import java.util.Iterator;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes45.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f63189a = 0;

    static {
    }

    public static String a(String r100) {
        Intrinsics.checkNotNullParameter(r100, "syncKey");
        if (StringsKt.startsWith$default(r100, "Open", false, 2, null) == false) goto L5;
        return r100;
    L5:
        return "Open" + r100;
    }

    public static String b(String r100) {
        if (r100 != null) goto L6;
        return "";
    L6:
        if (StringsKt.startsWith$default(r100, MessageType.WEBCAST_OPEN, false, 2, null) == false) goto L8;
        return r100;
    L8:
        if (StringsKt.startsWith$default(r100, "WebcastContentOpen", false, 2, null) == true) goto L12;
        ALogger.d("aggressive_fuse_message", "insert Open after Webcast prefix for " + r100 + " before callback");
        return StringsKt.replace$default(r100, MessageType.WEBCAST, MessageType.WEBCAST_OPEN, false, 4, null);
    L12:
        return r100;
    }

    public static void d(JsonObject r100) {
        Iterator<T> r101 = r100.keySet().iterator();
    L4:
        if (r101.hasNext() == false) goto L11;
        String r102 = (String) r101.next();
        JsonElement r103 = r100.get(r102);
        String r104 = GsonHelper.mappingFieldName(Object.class, r102);
        if ((!Intrinsics.areEqual(r104, r102)) == false) goto L9;
        r100.remove(r102);
        r100.add(r104, r103);
    L9:
        if ((r103 instanceof JsonObject) == false) goto L4;
        d((JsonObject) r103);
        goto L4
    }

    public static void c(JsonObject r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "it");
        Intrinsics.checkNotNullParameter(r101, com.alipay.sdk.m.p.e.f25671s);
        Result.Companion r102 = Result.Companion;     // Catch: Throwable -> L5
        r100.get("common").getAsJsonObject().addProperty(com.alipay.sdk.m.p.e.f25671s, r101);     // Catch: Throwable -> L5
        d(r100);     // Catch: Throwable -> L5
        Object r103 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L5
    L7:
        StringBuilder r104 = new StringBuilder("modify json, success: ");
        r104.append(Result.m9456isSuccessimpl(r103));
        r104.append(", error: ");
        Throwable r105 = Result.m9452exceptionOrNullimpl(r103);
        if (r105 == null) goto L10;
        String r106 = r105.getMessage();
    L11:
        r104.append(r106);
        ALogger.d("aggressive_fuse_message", r104.toString());
        return;
    L10:
        r106 = null;
    L5:
        th = move-exception;
        Result.Companion r107 = Result.Companion;
        r103 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L7
    }
}
