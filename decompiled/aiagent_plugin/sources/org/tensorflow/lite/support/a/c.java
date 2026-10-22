package org.tensorflow.lite.support.a;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: TensorOperator.java */
/* JADX INFO: loaded from: classes5.dex */
public interface c extends a<org.tensorflow.lite.support.c.a> {
    /* JADX INFO: renamed from: a, reason: avoid collision after fix types in other method */
    org.tensorflow.lite.support.c.a a2(org.tensorflow.lite.support.c.a r1);

    @Override // org.tensorflow.lite.support.a.a
    /* synthetic */ default org.tensorflow.lite.support.c.a a(org.tensorflow.lite.support.c.a r3) {
        return a2((org.tensorflow.lite.support.c.a) ZeusTransformUtils.preCheckCast(r3, org.tensorflow.lite.support.c.a.class, "com.obric.aiagent.plugin"));
    }
}
