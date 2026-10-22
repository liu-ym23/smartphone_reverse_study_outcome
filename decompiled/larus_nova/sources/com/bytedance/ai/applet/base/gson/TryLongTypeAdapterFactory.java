package com.bytedance.ai.applet.base.gson;

import androidx.camera.video.AudioStats;
import androidx.exifinterface.media.ExifInterface;
import com.bytedance.mt.protector.impl.string2number.CastDoubleProtector;
import com.google.gson.Gson;
import com.google.gson.JsonParseException;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import com.google.gson.stream.MalformedJsonException;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.lang.reflect.WildcardType;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\bÀ\u0002\u0018\u00002\u00020\u0001:\u0002\u001d\u001eB\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J,\u0010\u0004\u001a\n\u0012\u0004\u0012\u0002H\u0006\u0018\u00010\u0005\"\u0004\b\u0000\u0010\u00062\u0006\u0010\u0007\u001a\u00020\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u0002H\u00060\nH\u0016J\u0012\u0010\u000b\u001a\u00020\f2\b\u0010\t\u001a\u0004\u0018\u00010\fH\u0002J\u0012\u0010\r\u001a\u00020\f2\b\u0010\t\u001a\u0004\u0018\u00010\fH\u0002J\u0010\u0010\u000e\u001a\u00020\f2\u0006\u0010\t\u001a\u00020\fH\u0002J\"\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0007\u001a\u00020\b2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0002J\u0012\u0010\u0015\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u0016\u001a\u00020\u0017H\u0002J\u0018\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u0013\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001cH\u0002¨\u0006\u001f"}, d2 = {"Lcom/bytedance/ai/applet/base/gson/TryLongTypeAdapterFactory;", "Lcom/google/gson/TypeAdapterFactory;", "<init>", "()V", "create", "Lcom/google/gson/TypeAdapter;", ExifInterface.GPS_DIRECTION_TRUE, "gson", "Lcom/google/gson/Gson;", "type", "Lcom/google/gson/reflect/TypeToken;", "valueType", "Ljava/lang/reflect/Type;", "elementType", "unwrapType", "writeValue", "", "writer", "Lcom/google/gson/stream/JsonWriter;", "value", "", "readValue", "reader", "Lcom/google/gson/stream/JsonReader;", "readNumber", "", "", "lenient", "", "MapAdapter", "ListAdapter", "applet-base_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class TryLongTypeAdapterFactory implements TypeAdapterFactory {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final TryLongTypeAdapterFactory f34509a = null;

    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0002\u0018\u00002\u0010\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u00020\u0001B\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\"\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0010\u0010\f\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u0002H\u0016J\u001a\u0010\r\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u00022\u0006\u0010\u000e\u001a\u00020\u000fH\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/bytedance/ai/applet/base/gson/TryLongTypeAdapterFactory$ListAdapter;", "Lcom/google/gson/TypeAdapter;", "", "", "gson", "Lcom/google/gson/Gson;", "<init>", "(Lcom/google/gson/Gson;)V", "write", "", "writer", "Lcom/google/gson/stream/JsonWriter;", "value", "read", "reader", "Lcom/google/gson/stream/JsonReader;", "applet-base_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class ListAdapter extends TypeAdapter<List<? extends Object>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Gson f34510a;

        public ListAdapter(Gson r100) {
            Intrinsics.checkNotNullParameter(r100, "gson");
            this.f34510a = r100;
        }

        @Override // com.google.gson.TypeAdapter
        public final List<? extends Object> read(JsonReader r100) {
            Intrinsics.checkNotNullParameter(r100, "reader");
            if (r100.peek() != JsonToken.NULL) goto L5;
            r100.nextNull();
            return null;
        L5:
            ArrayList r101 = new ArrayList();
            r100.beginArray();
        L7:
            if (r100.hasNext() == false) goto L9;
            TryLongTypeAdapterFactory.f34509a.getClass();
            r101.add(TryLongTypeAdapterFactory.a(r100));
            goto L7
        L9:
            r100.endArray();
            return r101;
        }

        @Override // com.google.gson.TypeAdapter
        public final void write(JsonWriter r100, List<? extends Object> r101) {
            List<? extends Object> r102 = r101;
            Intrinsics.checkNotNullParameter(r100, "writer");
            if (r102 != null) goto L5;
            r100.nullValue();
            return;
        L5:
            r100.beginArray();
            Iterator<? extends Object> r103 = r102.iterator();
        L7:
            if (r103.hasNext() == false) goto L12;
            Object r104 = r103.next();
            TryLongTypeAdapterFactory r105 = TryLongTypeAdapterFactory.f34509a;
            Gson r106 = this.f34510a;
            r105.getClass();
            if (r104 == null) goto L10;
            Class<?> r107 = r104.getClass();
            Intrinsics.checkNotNull(r107, "null cannot be cast to non-null type java.lang.Class<kotlin.Any>");
            r106.getAdapter(r107).write(r100, r104);
            goto L7
        L10:
            r100.nullValue();
            goto L7
        L12:
            r100.endArray();
        }
    }

    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0002\u0018\u00002\u0016\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u00020\u0001B\u000f\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ(\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0016\u0010\r\u001a\u0012\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0002H\u0016J \u0010\u000e\u001a\u0012\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u00022\u0006\u0010\u000f\u001a\u00020\u0010H\u0016R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/bytedance/ai/applet/base/gson/TryLongTypeAdapterFactory$MapAdapter;", "Lcom/google/gson/TypeAdapter;", "", "", "", "gson", "Lcom/google/gson/Gson;", "<init>", "(Lcom/google/gson/Gson;)V", "write", "", "writer", "Lcom/google/gson/stream/JsonWriter;", "value", "read", "reader", "Lcom/google/gson/stream/JsonReader;", "applet-base_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class MapAdapter extends TypeAdapter<Map<String, ? extends Object>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Gson f34511a;

        public MapAdapter(Gson r100) {
            Intrinsics.checkNotNullParameter(r100, "gson");
            this.f34511a = r100;
        }

        @Override // com.google.gson.TypeAdapter
        public final Map<String, ? extends Object> read(JsonReader r100) {
            Intrinsics.checkNotNullParameter(r100, "reader");
            if (r100.peek() != JsonToken.NULL) goto L5;
            r100.nextNull();
            return null;
        L5:
            LinkedHashMap r101 = new LinkedHashMap();
            r100.beginObject();
        L7:
            if (r100.hasNext() == false) goto L9;
            String r102 = r100.nextName();
            TryLongTypeAdapterFactory.f34509a.getClass();
            r101.put(r102, TryLongTypeAdapterFactory.a(r100));
            goto L7
        L9:
            r100.endObject();
            return r101;
        }

        @Override // com.google.gson.TypeAdapter
        public final void write(JsonWriter r100, Map<String, ? extends Object> r101) {
            Map<String, ? extends Object> r102 = r101;
            Intrinsics.checkNotNullParameter(r100, "writer");
            if (r102 != null) goto L5;
            r100.nullValue();
            return;
        L5:
            r100.beginObject();
            Iterator<Map.Entry<String, ? extends Object>> r103 = r102.entrySet().iterator();
        L7:
            if (r103.hasNext() == false) goto L12;
            Map.Entry<String, ? extends Object> r104 = r103.next();
            String r105 = r104.getKey();
            Object r106 = r104.getValue();
            r100.name(r105.toString());
            TryLongTypeAdapterFactory r107 = TryLongTypeAdapterFactory.f34509a;
            Gson r108 = this.f34511a;
            r107.getClass();
            if (r106 == null) goto L10;
            Class<?> r109 = r106.getClass();
            Intrinsics.checkNotNull(r109, "null cannot be cast to non-null type java.lang.Class<kotlin.Any>");
            r108.getAdapter(r109).write(r100, r106);
            goto L7
        L10:
            r100.nullValue();
            goto L7
        L12:
            r100.endObject();
        }
    }

    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f34512a = null;

        static {
            int[] r100 = new int[JsonToken.values().length];
            r100[JsonToken.BEGIN_OBJECT.ordinal()] = 1;     // Catch: NoSuchFieldError -> L11
        L19:
            r100[JsonToken.BEGIN_ARRAY.ordinal()] = 2;     // Catch: NoSuchFieldError -> L12
        L27:
            r100[JsonToken.STRING.ordinal()] = 3;     // Catch: NoSuchFieldError -> L13
        L21:
            r100[JsonToken.BOOLEAN.ordinal()] = 4;     // Catch: NoSuchFieldError -> L14
        L23:
            r100[JsonToken.NULL.ordinal()] = 5;     // Catch: NoSuchFieldError -> L15
        L17:
            r100[JsonToken.NUMBER.ordinal()] = 6;     // Catch: NoSuchFieldError -> L16
        L9:
            f34512a = r100;
        }
    }

    static {
        f34509a = new TryLongTypeAdapterFactory();
    }

    private TryLongTypeAdapterFactory() {
    }

    public static Object a(JsonReader r100) {
        JsonToken r101 = r100.peek();
        if (r101 != null) goto L5;
        int r102 = -1;
    L6:
        switch(r102) {
            case 1: goto L37;
            case 2: goto L32;
            case 3: goto L52;
            case 4: goto L51;
            case 5: goto L29;
            case 6: goto L9;
            default: goto L8;
        };
    L9:
        boolean r103 = r100.isLenient();
        String r104 = r100.nextString();
        Long r105 = StringsKt.toLongOrNull(r104);
        if (r105 != null) goto L47;
        double r106 = CastDoubleProtector.parseDouble(r104);     // Catch: NumberFormatException -> L26
        if (Double.isInfinite(r106) == false) goto L15;
    L16:
        if (r103 == false) goto L25;
    L18:
        if ((r106 % 1.0d) != AudioStats.AUDIO_AMPLITUDE_NONE) goto L20;
        boolean r107 = true;
    L21:
        if (r107 == false) goto L49;
        return Long.valueOf((long) r106);
    L49:
        return Double.valueOf(r106);
    L20:
        r107 = false;
        goto L21
    L25:
        throw new MalformedJsonException("JSON forbids NaN and infinities: " + r106);     // Catch: NumberFormatException -> L26
    L15:
        if (Double.isNaN(r106) == false) goto L18;
    L26:
        e = move-exception;
        throw new JsonParseException("Cannot parse " + r104, e);
    L47:
        return Long.valueOf(r105.longValue());
    L29:
        r100.nextNull();
        return null;
    L32:
        ArrayList r108 = new ArrayList();
        r100.beginArray();
    L34:
        if (r100.hasNext() == false) goto L36;
        r108.add(a(r100));
        goto L34
    L36:
        r100.endArray();
        Object r109 = r108;
    L43:
        return r109;
    L37:
        LinkedHashMap r110 = new LinkedHashMap();
        r100.beginObject();
    L39:
        if (r100.hasNext() == false) goto L41;
        r110.put(r100.nextName(), a(r100));
        goto L39
    L41:
        r100.endObject();
        r109 = r110;
        goto L43
    L8:
        throw new IllegalStateException("Unexpected token: " + r100.peek());
    L51:
        return Boolean.valueOf(r100.nextBoolean());
    L52:
        return r100.nextString();
    L5:
        r102 = a.f34512a[r101.ordinal()];
        goto L6
    }

    public static Type b(Type r100) {
        if ((r100 instanceof WildcardType) == false) goto L14;
        Type[] r101 = ((WildcardType) r100).getUpperBounds();
        Intrinsics.checkNotNull(r101);
        if (r101.length != 0) goto L7;
        boolean r102 = true;
    L9:
        if ((!r102) == true) goto L24;
        return Object.class;
    L24:
        return b(r101[0]);
    L7:
        r102 = false;
        goto L9
    L14:
        if ((r100 instanceof TypeVariable) == false) goto L25;
        Type[] r103 = ((TypeVariable) r100).getBounds();
        Intrinsics.checkNotNull(r103);
        if (r103.length != 0) goto L18;
        boolean r104 = true;
    L20:
        if ((!r104) == true) goto L26;
        return Object.class;
    L26:
        return b(r103[0]);
    L18:
        r104 = false;
        goto L20
    L25:
        return r100;
    }

    @Override // com.google.gson.TypeAdapterFactory
    public final <T> TypeAdapter<T> create(Gson r100, TypeToken<T> r101) {
        Intrinsics.checkNotNullParameter(r100, "gson");
        Intrinsics.checkNotNullParameter(r101, "type");
        Class<? super T> r102 = r101.getRawType();
        if (Map.class.isAssignableFrom(r102) == false) goto L14;
        Type r103 = r101.getType();
        if ((r103 instanceof ParameterizedType) == false) goto L9;
        Type[] r104 = ((ParameterizedType) r103).getActualTypeArguments();
        if (r104.length != 2) goto L9;
        Object r105 = b(r104[1]);
    L11:
        if (Intrinsics.areEqual(r105, Object.class) == false) goto L14;
        return new MapAdapter(r100);
    L9:
        r105 = Object.class;
    L14:
        if (List.class.isAssignableFrom(r102) == false) goto L24;
        Type r106 = r101.getType();
        if ((r106 instanceof ParameterizedType) == false) goto L20;
        Type[] r107 = ((ParameterizedType) r106).getActualTypeArguments();
        if (r107.length != 1) goto L20;
        Object r108 = b(r107[0]);
    L22:
        if (Intrinsics.areEqual(r108, Object.class) == false) goto L24;
        return new ListAdapter(r100);
    L20:
        r108 = Object.class;
    L24:
        return null;
    }
}
