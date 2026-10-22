package com.bytedance.android.sdk.bdticketguard;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004ø\u0001\u0000\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/sdk/bdticketguard/SensitiveStringTypeAdapter;", "Lcom/google/gson/TypeAdapter;", "Lcom/bytedance/android/sdk/bdticketguard/k0;", "<init>", "()V", "bd_ticket_guard_api_release"}, k = 1, mv = {1, 4, 0})
public final class SensitiveStringTypeAdapter extends TypeAdapter<k0> {
    public SensitiveStringTypeAdapter() {
    }

    @Override // com.google.gson.TypeAdapter
    public final k0 read(JsonReader r100) {
        return new k0(r100.nextString());
    }

    @Override // com.google.gson.TypeAdapter
    public final void write(JsonWriter r100, k0 r101) {
        k0 r102 = r101;
        String r103 = null;
        if (r102 == null) goto L5;
        String r104 = r102.f163803a;
    L6:
        if (r104 == null) goto L8;
        r103 = r104;
    L8:
        r100.value(r103);
        return;
    L5:
        r104 = null;
        goto L6
    }
}
