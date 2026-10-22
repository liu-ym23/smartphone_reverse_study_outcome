package com.ss.android.agilelogger.a.b.c;

import com.ss.android.agilelogger.b.d;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: DefaultThrowableFormatter.java */
/* JADX INFO: loaded from: classes4.dex */
public class a implements b {
    public a() {
    }

    @Override // com.ss.android.agilelogger.a.b
    public /* synthetic */ String a(Object r3) {
        return a((Throwable) ZeusTransformUtils.preCheckCast(r3, Throwable.class, "com.obric.aiagent.plugin"));
    }

    public String a(Throwable r1) {
        return d.a(r1);
    }
}
