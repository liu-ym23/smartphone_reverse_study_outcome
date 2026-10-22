package com.bytedance.retrofit2;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;

/* JADX INFO: compiled from: DefaultCallAdapterFactory.java */
/* JADX INFO: loaded from: classes.dex */
final class j extends f.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static final f.a f9555a = null;

    j() {
    }

    static {
        f9555a = new j();
    }

    @Override // com.bytedance.retrofit2.f.a
    public f<?, ?> a(Type r1, Annotation[] r2, ab r3) {
        Type r4 = (Type) ZeusTransformUtils.wrapperContextForParams(r1, Type.class, "com.obric.aiagent.plugin");
        if (a(r4) == e.class) goto L6;
        return null;
    L6:
        final Type r5 = an.e(r4);
        return new AnonymousClass1(this, r5);
    }
}
