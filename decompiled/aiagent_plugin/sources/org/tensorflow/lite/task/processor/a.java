package org.tensorflow.lite.task.processor;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.nio.ByteBuffer;
import java.util.Objects;

/* JADX INFO: compiled from: AutoValue_NearestNeighbor.java */
/* JADX INFO: loaded from: classes5.dex */
final class a extends NearestNeighbor {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ByteBuffer f40646a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final float f40647b;

    a(ByteBuffer r2, float r3) {
        Objects.requireNonNull(r2, "Null metadata");
        this.f40646a = r2;
        this.f40647b = r3;
    }

    @Override // org.tensorflow.lite.task.processor.NearestNeighbor
    public ByteBuffer a() {
        return this.f40646a;
    }

    @Override // org.tensorflow.lite.task.processor.NearestNeighbor
    public float b() {
        return this.f40647b;
    }

    public String toString() {
        return "NearestNeighbor{metadata=" + this.f40646a + ", distance=" + this.f40647b + "}";
    }

    public boolean equals(Object r5) {
        if (r5 != this) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, NearestNeighbor.class) == false) goto L14;
        NearestNeighbor r6 = (NearestNeighbor) ZeusTransformUtils.preCheckCast(r5, NearestNeighbor.class, "com.obric.aiagent.plugin");
        if (this.f40646a.equals(r6.a()) == false) goto L13;
        if (Float.floatToIntBits(this.f40647b) != Float.floatToIntBits(r6.b())) goto L13;
        return true;
    L13:
        return false;
    L14:
        return false;
    }

    public int hashCode() {
        int r0 = (this.f40646a.hashCode() ^ 1000003) * 1000003;
        return Float.floatToIntBits(this.f40647b) ^ r0;
    }
}
