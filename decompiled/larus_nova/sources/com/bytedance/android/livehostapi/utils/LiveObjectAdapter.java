package com.bytedance.android.livehostapi.utils;

import com.byted.cast.linkcommon.cybergarage.upnp.Argument;
import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.internal.LinkedTreeMap;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u001c\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0002H\u0016R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/bytedance/android/livehostapi/utils/LiveObjectAdapter;", "Lcom/google/gson/TypeAdapter;", "", "()V", "delegate", "read", "in", "Lcom/google/gson/stream/JsonReader;", "write", "", Argument.OUT, "Lcom/google/gson/stream/JsonWriter;", "value", "hostapp-middleware_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LiveObjectAdapter extends TypeAdapter<Object> {
    private final TypeAdapter<Object> delegate;

    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 3})
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0 = null;

        static {
            int[] r100 = new int[JsonToken.values().length];
            $EnumSwitchMapping$0 = r100;
            r100[JsonToken.BEGIN_ARRAY.ordinal()] = 1;
            r100[JsonToken.BEGIN_OBJECT.ordinal()] = 2;
            r100[JsonToken.STRING.ordinal()] = 3;
            r100[JsonToken.NUMBER.ordinal()] = 4;
            r100[JsonToken.BOOLEAN.ordinal()] = 5;
            r100[JsonToken.NULL.ordinal()] = 6;
        }
    }

    public LiveObjectAdapter() {
        this.delegate = new Gson().getAdapter(Object.class);
    }

    @Override // com.google.gson.TypeAdapter
    public Object read(JsonReader r100) throws IOException {
        Intrinsics.checkNotNullParameter(r100, "in");
        JsonToken r101 = r100.peek();
        if (r101 != null) goto L6;
        return null;
    L6:
        switch(WhenMappings.$EnumSwitchMapping$0[r101.ordinal()]) {
            case 1: goto L27;
            case 2: goto L22;
            case 3: goto L41;
            case 4: goto L10;
            case 5: goto L38;
            case 6: goto L8;
            default: goto L44;
        };
    L8:
        r100.nextNull();
        return null;
    L10:
        double r102 = r100.nextDouble();
        if (r102 > Long.MAX_VALUE) goto L13;
        long r103 = (long) r102;
        if (r102 != r103) goto L40;
        Object r104 = Integer.valueOf((int) r103);     // Catch: Exception -> L19
    L39:
        return r104;
    L19:
        r104 = Long.valueOf(r103);
        goto L39
    L40:
        return Double.valueOf(r102);
    L13:
        return Double.valueOf(r102);
    L22:
        LinkedTreeMap r105 = new LinkedTreeMap();
        r100.beginObject();
    L24:
        if (r100.hasNext() == false) goto L26;
        r105.put(r100.nextName(), read(r100));
        goto L24
    L26:
        r100.endObject();
        return r105;
    L27:
        ArrayList r106 = new ArrayList();
        r100.beginArray();
    L29:
        if (r100.hasNext() == false) goto L31;
        r106.add(read(r100));
        goto L29
    L31:
        r100.endArray();
        return r106;
    L44:
        return null;
    L38:
        return Boolean.valueOf(r100.nextBoolean());
    L41:
        return r100.nextString();
    }

    @Override // com.google.gson.TypeAdapter
    public void write(JsonWriter r100, Object r101) throws IOException {
        this.delegate.write(r100, r101);
    }
}
