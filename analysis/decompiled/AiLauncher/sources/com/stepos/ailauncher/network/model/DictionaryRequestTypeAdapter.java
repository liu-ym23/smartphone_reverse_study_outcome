package com.stepos.ailauncher.network.model;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import com.stepos.statsapp.v3.lib.plugin.constants.UxipConstants;
import java.io.IOException;
import kotlin.Metadata;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u001f\u0010\t\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\r\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"Lcom/stepos/ailauncher/network/model/DictionaryRequestTypeAdapter;", "Lcom/google/gson/TypeAdapter;", "Lcom/stepos/ailauncher/network/model/DictionaryRequest;", "<init>", "()V", "Lcom/google/gson/stream/JsonWriter;", "out", UxipConstants.f30680s, "LY8/t;", "write", "(Lcom/google/gson/stream/JsonWriter;Lcom/stepos/ailauncher/network/model/DictionaryRequest;)V", "Lcom/google/gson/stream/JsonReader;", "reader", "read", "(Lcom/google/gson/stream/JsonReader;)Lcom/stepos/ailauncher/network/model/DictionaryRequest;", "network_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class DictionaryRequestTypeAdapter extends TypeAdapter<DictionaryRequest> {
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.google.gson.TypeAdapter
    public DictionaryRequest read(JsonReader reader) {
        p.i(reader, "reader");
        throw new UnsupportedOperationException("DictionaryRequest is request-only");
    }

    @Override // com.google.gson.TypeAdapter
    public void write(JsonWriter out, DictionaryRequest value) throws IOException {
        p.i(out, "out");
        p.i(value, "value");
        out.beginObject();
        out.name("pkgName").value(value.getPkgName());
        String appVersion = value.getAppVersion();
        if (appVersion != null) {
            out.name("appVersion").value(appVersion);
        }
        out.name("key").value(value.getKey());
        out.endObject();
    }
}
