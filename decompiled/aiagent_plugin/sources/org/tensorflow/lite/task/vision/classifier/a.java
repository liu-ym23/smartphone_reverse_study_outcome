package org.tensorflow.lite.task.vision.classifier;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;
import java.util.Objects;
import org.tensorflow.lite.support.label.Category;

/* JADX INFO: compiled from: AutoValue_Classifications.java */
/* JADX INFO: loaded from: classes5.dex */
final class a extends Classifications {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final List<Category> f40659a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f40660b;

    a(List<Category> r3, int r4) {
        List<Category> r5 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.aiagent.plugin");
        Objects.requireNonNull(r5, "Null categories");
        this.f40659a = r5;
        this.f40660b = r4;
    }

    @Override // org.tensorflow.lite.task.vision.classifier.Classifications
    public List<Category> a() {
        return this.f40659a;
    }

    @Override // org.tensorflow.lite.task.vision.classifier.Classifications
    public int b() {
        return this.f40660b;
    }

    public String toString() {
        return "Classifications{categories=" + this.f40659a + ", headIndex=" + this.f40660b + "}";
    }

    public boolean equals(Object r5) {
        if (r5 != this) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, Classifications.class) == false) goto L14;
        Classifications r6 = (Classifications) ZeusTransformUtils.preCheckCast(r5, Classifications.class, "com.obric.aiagent.plugin");
        if (this.f40659a.equals(r6.a()) == false) goto L13;
        if (this.f40660b != r6.b()) goto L13;
        return true;
    L13:
        return false;
    L14:
        return false;
    }

    public int hashCode() {
        int r0 = (this.f40659a.hashCode() ^ 1000003) * 1000003;
        return this.f40660b ^ r0;
    }
}
