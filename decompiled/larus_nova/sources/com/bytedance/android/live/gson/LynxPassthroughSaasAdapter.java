package com.bytedance.android.live.gson;

import com.bytedance.android.live.GsonHelper;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.lang.reflect.Type;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0005B\u0007¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/live/gson/LynxPassthroughSaasAdapter;", "Lcom/google/gson/JsonSerializer;", "Lja0/a;", "<init>", "()V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "live-utils_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LynxPassthroughSaasAdapter implements JsonSerializer<ja0.a> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f69011a = 0;

    public static final class a {
    }

    static {
    }

    public LynxPassthroughSaasAdapter() {
    }

    public static void a(JsonElement r100, JsonElement r101) {
        if (r100.isJsonObject() == true) goto L5;
        return;
    L5:
        if (r101.isJsonObject() == false) goto L22;
        JsonObject r102 = r100.getAsJsonObject();
        JsonObject r103 = r101.getAsJsonObject();
        Iterator<T> r104 = r102.keySet().iterator();
    L9:
        if (r104.hasNext() == false) goto L23;
        String r105 = (String) r104.next();
        JsonElement r106 = r102.get(r105);
        String r107 = GsonHelper.mappingFieldName(Object.class, r105);
        r103.add(r107, r106.deepCopy());
        if ((!Intrinsics.areEqual(r107, r105)) == true) goto L14;
    L14:
        if (r106.isJsonObject() == false) goto L9;
        a(r106, r103.get(r107));
        goto L9
    L23:
        return;
    }

    @Override // com.google.gson.JsonSerializer
    public final JsonElement serialize(ja0.a r100, Type r101, JsonSerializationContext r102) {
        ja0.a r103 = r100;
        Intrinsics.checkNotNullParameter(r103, "src");
        Intrinsics.checkNotNullParameter(r101, "typeOfSrc");
        Intrinsics.checkNotNullParameter(r102, PerfLog.PARAM_KEY_CONTEXT_ID);
        JsonElement r104 = GsonProtectorUtils.toJsonTree(GsonHelper.get(), r103);
        JsonObject r105 = new JsonObject();
        r101.getClass();
        a(r104, r105);
        return r105;
    }
}
