package com.obric.eventkit.eventstaskmanager;

import android.net.Uri;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;

/* JADX INFO: loaded from: classes4.dex */
public final class UriTypeAdapter extends TypeAdapter<Uri> {
    public UriTypeAdapter() {
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.google.gson.TypeAdapter
    public Uri read(JsonReader r1) {
        o.e(r1, "input");
        return Uri.parse(r1.nextString());
    }

    @Override // com.google.gson.TypeAdapter
    public /* bridge */ /* synthetic */ Uri read(JsonReader r1) {
        return read(r1);
    }

    /* JADX INFO: renamed from: write, reason: avoid collision after fix types in other method */
    public void write2(JsonWriter r1, Uri r2) {
        o.e(r1, "out");
        if (r2 == null) goto L5;
        String r0 = r2.toString();
    L6:
        r1.value(r0);
        return;
    L5:
        r0 = null;
        goto L6
    }

    @Override // com.google.gson.TypeAdapter
    public /* synthetic */ void write(JsonWriter r3, Uri r4) {
        write2(r3, (Uri) ZeusTransformUtils.preCheckCast(r4, Uri.class, "com.obric.aiagent.plugin"));
    }
}
