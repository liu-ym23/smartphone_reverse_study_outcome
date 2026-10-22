package com.fasterxml.jackson.a.b;

import com.fasterxml.jackson.a.h;
import com.fasterxml.jackson.a.i;
import com.fasterxml.jackson.a.l;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: StreamWriteException.java */
/* JADX INFO: loaded from: classes2.dex */
public abstract class c extends l {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected transient h f11985b;

    @Override // com.fasterxml.jackson.a.l, com.fasterxml.jackson.a.e
    public /* synthetic */ Object c() {
        return d();
    }

    public c(String r4, h r5) {
        super(r4, (i) ZeusTransformUtils.preCheckCast(null, i.class, "com.obric.aiagent.plugin"));
        this.f11985b = r5;
    }

    public h d() {
        return this.f11985b;
    }
}
