package org.tensorflow.lite.support.b;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: ImageOperator.java */
/* JADX INFO: loaded from: classes5.dex */
public interface e extends org.tensorflow.lite.support.a.a<g> {
    /* JADX INFO: renamed from: a, reason: avoid collision after fix types in other method */
    g a2(g r1);

    @Override // org.tensorflow.lite.support.a.a
    /* synthetic */ default g a(g r3) {
        return a2((g) ZeusTransformUtils.preCheckCast(r3, g.class, "com.obric.aiagent.plugin"));
    }
}
