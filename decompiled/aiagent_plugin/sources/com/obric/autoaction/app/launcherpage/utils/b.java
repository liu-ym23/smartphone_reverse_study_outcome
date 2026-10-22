package com.obric.autoaction.app.launcherpage.utils;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: GsonUtils.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class b extends TypeAdapter<CharSequence> {
    public b() {
    }

    @Override // com.google.gson.TypeAdapter
    public /* synthetic */ CharSequence read(JsonReader r1) {
        return a(r1);
    }

    @Override // com.google.gson.TypeAdapter
    public /* synthetic */ void write(JsonWriter r3, CharSequence r4) {
        a(r3, (CharSequence) ZeusTransformUtils.preCheckCast(r4, CharSequence.class, "com.obric.aiagent.plugin"));
    }

    public void a(JsonWriter r2, CharSequence r3) {
        CharSequence r1 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r3, CharSequence.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r2, "out");
        if (r1 != null) goto L5;
        r2.nullValue();
        return;
    L5:
        r2.value(r1.toString());
    }

    public CharSequence a(JsonReader r2) {
        d.h.b.o.e(r2, "in");
        return (CharSequence) ZeusTransformUtils.preCheckCast(r2.nextString(), CharSequence.class, "com.obric.aiagent.plugin");
    }
}
