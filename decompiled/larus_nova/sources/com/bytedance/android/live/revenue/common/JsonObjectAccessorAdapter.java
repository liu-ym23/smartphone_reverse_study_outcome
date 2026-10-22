package com.bytedance.android.live.revenue.common;

import androidx.exifinterface.media.ExifInterface;
import com.bytedance.android.live.revenue.common.p;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.lang.reflect.Constructor;
import java.lang.reflect.Type;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u00012\b\u0012\u0004\u0012\u00028\u00000\u00032\b\u0012\u0004\u0012\u00028\u00000\u0004B\u0007¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/bytedance/android/live/revenue/common/JsonObjectAccessorAdapter;", "Lcom/bytedance/android/live/revenue/common/p;", ExifInterface.GPS_DIRECTION_TRUE, "Lcom/google/gson/JsonSerializer;", "Lcom/google/gson/JsonDeserializer;", "<init>", "()V", "revenue-common_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class JsonObjectAccessorAdapter<T extends p> implements JsonSerializer<T>, JsonDeserializer<T> {
    public JsonObjectAccessorAdapter() {
    }

    @Override // com.google.gson.JsonDeserializer
    public final Object deserialize(JsonElement r100, Type r101, JsonDeserializationContext r102) {
        Intrinsics.checkNotNullParameter(r100, "json");
        Intrinsics.checkNotNullParameter(r101, "typeOfT");
        Intrinsics.checkNotNullParameter(r102, PerfLog.PARAM_KEY_CONTEXT_ID);
        Type r103 = null;
        if (r100.isJsonNull() == false) goto L6;
        return null;
    L6:
        if (r100.isJsonObject() == false) goto L22;
        JsonObject r104 = r100.getAsJsonObject();
        if ((r101 instanceof Class) == false) goto L11;
        r103 = r101;
    L11:
        Class r105 = (Class) r103;
        if (r105 == null) goto L20;
        Constructor r106 = r105.getDeclaredConstructor(new Class[]{JsonObject.class});
        r106.setAccessible(true);
        Object r107 = r106.newInstance(new Object[]{r104});
        if (r107 == null) goto L18;
        return (p) r107;
    L18:
        throw new NullPointerException("null cannot be cast to non-null type T");
    L20:
        throw new IllegalArgumentException("Cannot determine class from type: " + r101);
    L22:
        throw new IllegalArgumentException("Expected JsonObject but got ".concat(r100.getClass().getSimpleName()));
    }

    @Override // com.google.gson.JsonSerializer
    public final JsonElement serialize(Object r100, Type r101, JsonSerializationContext r102) {
        p r103 = (p) r100;
        Intrinsics.checkNotNullParameter(r101, "typeOfSrc");
        Intrinsics.checkNotNullParameter(r102, PerfLog.PARAM_KEY_CONTEXT_ID);
        if (r103 != null) goto L6;
        return null;
    L6:
        return r103.f90911a.deepCopy();
    }
}
