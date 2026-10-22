package org.tensorflow.lite.support.b;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: ImageProcessor.java */
/* JADX INFO: loaded from: classes5.dex */
public class f extends org.tensorflow.lite.support.a.b<g> {

    /* JADX INFO: renamed from: org.tensorflow.lite.support.b.f$1, reason: invalid class name */
    /* JADX INFO: compiled from: ImageProcessor.java */
    static /* synthetic */ class AnonymousClass1 {
    }

    /* JADX INFO: compiled from: ImageProcessor.java */
    public static class a extends org.tensorflow.lite.support.a.b.a<g> {
        public a() {
        }

        public f a() {
            return new f(this, null);
        }
    }

    /* synthetic */ f(a r1, AnonymousClass1 r2) {
        this(r1);
    }

    @Override // org.tensorflow.lite.support.a.b
    public /* synthetic */ g a(g r3) {
        return a2((g) ZeusTransformUtils.preCheckCast(r3, g.class, "com.obric.aiagent.plugin"));
    }

    private f(a r1) {
        super(r1);
    }

    /* JADX INFO: renamed from: a, reason: avoid collision after fix types in other method */
    public g a2(g r2) {
        return (g) ZeusTransformUtils.preCheckCast(super.a(r2), g.class, "com.obric.aiagent.plugin");
    }
}
