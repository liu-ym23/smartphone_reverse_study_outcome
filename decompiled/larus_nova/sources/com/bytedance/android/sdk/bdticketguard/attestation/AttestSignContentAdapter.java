package com.bytedance.android.sdk.bdticketguard.attestation;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/sdk/bdticketguard/attestation/AttestSignContentAdapter;", "Lcom/google/gson/TypeAdapter;", "Lcom/bytedance/android/sdk/bdticketguard/attestation/AttestSignContent;", "<init>", "()V", "bd_ticket_guard_api_release"}, k = 1, mv = {1, 4, 0})
public final class AttestSignContentAdapter extends TypeAdapter<AttestSignContent> {
    public AttestSignContentAdapter() {
    }

    @Override // com.google.gson.TypeAdapter
    public final AttestSignContent read(JsonReader r100) {
        AttestSignContent.a r101 = AttestSignContent.f163541c;
        String r102 = r100.nextString();
        r101.getClass();
        return AttestSignContent.a.a(r102);
    }

    @Override // com.google.gson.TypeAdapter
    public final void write(JsonWriter r100, AttestSignContent r101) {
        AttestSignContent r102 = r101;
        if (r102 == null) goto L5;
        String r103 = r102.b();
    L6:
        r100.value(r103);
        return;
    L5:
        r103 = null;
        goto L6
    }
}
