package com.bytedance.android.window.shop.repository.dto;

import androidx.exifinterface.media.ExifInterface;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.google.gson.Gson;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import java.lang.reflect.Field;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes14.dex */
public final class GsonDeserializer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Gson f189417a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Map<Class<?>, List<Field>> f189418b = null;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u00012\b\u0012\u0004\u0012\u00028\u00000\u0003B\u0007¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/window/shop/repository/dto/GsonDeserializer$WrapperJsonDeserializer;", "", ExifInterface.GPS_DIRECTION_TRUE, "Lcom/google/gson/JsonDeserializer;", "<init>", "()V", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class WrapperJsonDeserializer<T> implements JsonDeserializer<T> {
        public WrapperJsonDeserializer() {
        }

        @Override // com.google.gson.JsonDeserializer
        public final T deserialize(JsonElement r100, Type r101, JsonDeserializationContext r110) {
            if (r100 != null) goto L5;
            return null;
        L5:
            if (r101 != null) goto L7;
            return null;
        L7:
            Gson r102 = GsonDeserializer.f189417a;
            T r103 = (T) GsonProtectorUtils.fromJson(GsonDeserializer.f189417a, r100, r101);
        L11:
            if (r103 != null) goto L13;
            return null;
        L13:
            Gson r104 = GsonDeserializer.f189417a;
            Class<?> r105 = r103.getClass();
            List r106 = (List) ((LinkedHashMap) GsonDeserializer.f189418b).get(r105);
            if (r106 != null) goto L22;
            Field[] r107 = r105.getDeclaredFields();
            ArrayList r108 = new ArrayList();
            int r109 = r107.length;
            int r111 = 0;
        L16:
            if (r111 >= r109) goto L21;
            Field r112 = r107[r111];
            if (r112.isAnnotationPresent(SubDTO.class) == false) goto L20;
            r108.add(r112);
        L20:
            r111 = r111 + 1;
            goto L16
        L21:
            GsonDeserializer.f189418b.put(r105, r108);
            r106 = r108;
        L22:
            Iterator<T> r113 = r106.iterator();
        L24:
            if (r113.hasNext() == false) goto L32;
            Field r114 = (Field) r113.next();
            Gson r115 = GsonDeserializer.f189417a;     // Catch: Exception -> L28
            Object r116 = GsonDeserializer.f189417a.fromJson(r100, r114.getType());     // Catch: Exception -> L28
        L29:
            if (r116 == null) goto L24;
            r114.setAccessible(true);
            r114.set(r103, r116);
        L28:
            r116 = null;
            goto L29
        L32:
            return r103;
        L10:
            r103 = null;
            goto L11
        }
    }

    static {
        f189417a = new Gson();
        f189418b = new LinkedHashMap();
    }
}
