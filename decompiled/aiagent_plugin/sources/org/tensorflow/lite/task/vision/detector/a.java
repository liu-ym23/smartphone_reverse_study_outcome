package org.tensorflow.lite.task.vision.detector;

import android.graphics.RectF;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;
import java.util.Objects;
import org.tensorflow.lite.support.label.Category;

/* JADX INFO: compiled from: AutoValue_Detection.java */
/* JADX INFO: loaded from: classes5.dex */
final class a extends Detection {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final RectF f40670a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final List<Category> f40671b;

    a(RectF r3, List<Category> r4) {
        List<Category> r5 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.aiagent.plugin");
        Objects.requireNonNull(r3, "Null boundingBox");
        this.f40670a = r3;
        Objects.requireNonNull(r5, "Null categories");
        this.f40671b = r5;
    }

    @Override // org.tensorflow.lite.task.vision.detector.Detection
    public RectF a() {
        return this.f40670a;
    }

    @Override // org.tensorflow.lite.task.vision.detector.Detection
    public List<Category> b() {
        return this.f40671b;
    }

    public String toString() {
        return "Detection{boundingBox=" + this.f40670a + ", categories=" + this.f40671b + "}";
    }

    public boolean equals(Object r5) {
        if (r5 != this) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, Detection.class) == false) goto L14;
        Detection r6 = (Detection) ZeusTransformUtils.preCheckCast(r5, Detection.class, "com.obric.aiagent.plugin");
        if (this.f40670a.equals(r6.a()) == false) goto L13;
        if (this.f40671b.equals(r6.b()) == false) goto L13;
        return true;
    L13:
        return false;
    L14:
        return false;
    }

    public int hashCode() {
        int r0 = (this.f40670a.hashCode() ^ 1000003) * 1000003;
        return this.f40671b.hashCode() ^ r0;
    }
}
