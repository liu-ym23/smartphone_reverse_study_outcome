package com.obric.capabilitykit.entity;

import android.net.Uri;
import androidx.annotation.Keep;
import com.bytedance.apm.constant.CommonKey;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes3.dex */
@Keep
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J\u0012\u0010\u0004\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u001a\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0002H\u0016¨\u0006\f"}, d2 = {"Lcom/obric/capabilitykit/entity/UriTypeAdapter;", "Lcom/google/gson/TypeAdapter;", "Landroid/net/Uri;", "()V", "read", "input", "Lcom/google/gson/stream/JsonReader;", "write", "", "out", "Lcom/google/gson/stream/JsonWriter;", CommonKey.KEY_VALUE, "capabilitykitcommon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class UriTypeAdapter extends TypeAdapter<Uri> {
    public UriTypeAdapter() {
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.google.gson.TypeAdapter
    @Nullable
    public Uri read(@NotNull JsonReader r10) {
        q.g(r10, "input");
        return Uri.parse(r10.nextString());
    }

    /* JADX INFO: renamed from: write, reason: avoid collision after fix types in other method */
    public void write2(@NotNull JsonWriter r10, @Nullable Uri r11) {
        q.g(r10, "out");
        if (r11 == null) goto L5;
        String r12 = r11.toString();
    L6:
        r10.value(r12);
        return;
    L5:
        r12 = null;
        goto L6
    }

    @Override // com.google.gson.TypeAdapter
    public /* bridge */ /* synthetic */ Uri read(JsonReader r10) {
        return read(r10);
    }

    @Override // com.google.gson.TypeAdapter
    public /* bridge */ /* synthetic */ void write(JsonWriter r10, Uri r11) {
        write2(r10, r11);
    }
}
