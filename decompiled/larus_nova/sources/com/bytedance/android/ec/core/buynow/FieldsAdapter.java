package com.bytedance.android.ec.core.buynow;

import com.bytedance.android.ec.core.utils.t0;
import com.google.gson.TypeAdapter;
import com.google.gson.internal.LinkedTreeMap;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/ec/core/buynow/FieldsAdapter;", "Lcom/google/gson/TypeAdapter;", "", "<init>", "()V", "ec-core_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class FieldsAdapter extends TypeAdapter<Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final TypeAdapter<Object> f43909a;

    public FieldsAdapter() {
        int r100 = t0.f45720a;
        this.f43909a = t0.a.f45721a.getAdapter(Object.class);
    }

    @Override // com.google.gson.TypeAdapter
    public final Object read(JsonReader r100) throws IOException {
        Intrinsics.checkNotNullParameter(r100, "in");
        JsonToken r101 = r100.peek();
        if (r101 != null) goto L6;
    L39:
        return null;
    L6:
        switch(c.f43912a[r101.ordinal()]) {
            case 1: goto L33;
            case 2: goto L28;
            case 3: goto L47;
            case 4: goto L10;
            case 5: goto L43;
            case 6: goto L8;
            default: goto L39;
        };
    L8:
        r100.nextNull();
        goto L39
    L10:
        double r102 = r100.nextDouble();
        if (r102 > Long.MAX_VALUE) goto L26;
        if (r102 < Long.MIN_VALUE) goto L26;
        long r103 = (long) r102;
        if (r102 != r103) goto L46;
        if (r103 > Integer.MAX_VALUE) goto L45;
        if (r103 < Integer.MIN_VALUE) goto L45;
        return Integer.valueOf((int) r103);
    L45:
        return Long.valueOf(r103);
    L46:
        return Double.valueOf(r102);
    L26:
        return Double.valueOf(r102);
    L28:
        LinkedTreeMap r104 = new LinkedTreeMap();
        r100.beginObject();
    L30:
        if (r100.hasNext() == false) goto L32;
        r104.put(r100.nextName(), read(r100));
        goto L30
    L32:
        r100.endObject();
        Object r105 = r104;
    L48:
        return r105;
    L33:
        ArrayList r106 = new ArrayList();
        r100.beginArray();
    L35:
        if (r100.hasNext() == false) goto L37;
        r106.add(read(r100));
        goto L35
    L37:
        r100.endArray();
        r105 = r106;
        goto L48
    L43:
        return Boolean.valueOf(r100.nextBoolean());
    L47:
        return r100.nextString();
    }

    @Override // com.google.gson.TypeAdapter
    public final void write(JsonWriter r100, Object r101) throws IOException {
        this.f43909a.write(r100, r101);
    }
}
