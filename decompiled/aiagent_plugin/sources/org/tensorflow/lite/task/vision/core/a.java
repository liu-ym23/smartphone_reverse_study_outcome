package org.tensorflow.lite.task.vision.core;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Arrays;
import java.util.Objects;

/* JADX INFO: compiled from: AutoValue_BaseVisionTaskApi_FrameBufferData.java */
/* JADX INFO: loaded from: classes5.dex */
final class a extends BaseVisionTaskApi.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final long f40662a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final long f40663b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final byte[] f40664c;

    a(long r1, long r3, byte[] r5) {
        this.f40662a = r1;
        this.f40663b = r3;
        Objects.requireNonNull(r5, "Null byteArray");
        this.f40664c = r5;
    }

    @Override // org.tensorflow.lite.task.vision.core.BaseVisionTaskApi.a
    long a() {
        return this.f40662a;
    }

    @Override // org.tensorflow.lite.task.vision.core.BaseVisionTaskApi.a
    long b() {
        return this.f40663b;
    }

    @Override // org.tensorflow.lite.task.vision.core.BaseVisionTaskApi.a
    byte[] c() {
        return this.f40664c;
    }

    public String toString() {
        return "FrameBufferData{frameBufferHandle=" + this.f40662a + ", byteArrayHandle=" + this.f40663b + ", byteArray=" + Arrays.toString(this.f40664c) + "}";
    }

    public boolean equals(Object r10) {
        if (r10 != this) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r10, BaseVisionTaskApi.a.class) == false) goto L20;
        BaseVisionTaskApi.a r11 = (BaseVisionTaskApi.a) ZeusTransformUtils.preCheckCast(r10, BaseVisionTaskApi.a.class, "com.obric.aiagent.plugin");
        if (this.f40662a != r11.a()) goto L19;
        if (this.f40663b != r11.b()) goto L19;
        byte[] r9 = this.f40664c;
        if (ZeusTransformUtils.instanceOf(r11, a.class) == false) goto L14;
        byte[] r12 = ((a) ZeusTransformUtils.preCheckCast(r11, a.class, "com.obric.aiagent.plugin")).f40664c;
    L16:
        if (Arrays.equals(r9, r12) == false) goto L19;
        return true;
    L14:
        r12 = r11.c();
    L19:
        return false;
    L20:
        return false;
    }

    public int hashCode() {
        long r0 = this.f40662a;
        int r1 = (((int) (r0 ^ (r0 >>> 32))) ^ 1000003) * 1000003;
        long r3 = this.f40663b;
        int r7 = Arrays.hashCode(this.f40664c);
        return r7 ^ ((r1 ^ ((int) ((r3 >>> 32) ^ r3))) * 1000003);
    }
}
