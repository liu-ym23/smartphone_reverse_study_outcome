package com.fasterxml.jackson.databind;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: MappingJsonFactory.java */
/* JADX INFO: loaded from: classes2.dex */
public class s extends com.fasterxml.jackson.a.f {
    @Override // com.fasterxml.jackson.a.f
    public String d() {
        return "JSON";
    }

    @Override // com.fasterxml.jackson.a.f
    public /* synthetic */ com.fasterxml.jackson.a.o e() {
        return g();
    }

    public s() {
        this(null);
    }

    public s(t r1) {
        super(r1);
        if (r1 != null) goto L6;
        a(new t(this));
        return;
    }

    public final t g() {
        return (t) ZeusTransformUtils.preCheckCast(this.j, t.class, "com.obric.aiagent.plugin");
    }
}
