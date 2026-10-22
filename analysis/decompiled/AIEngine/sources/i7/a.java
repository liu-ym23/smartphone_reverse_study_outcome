package i7;

import java.util.Arrays;
import kotlin.jvm.internal.g;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public final byte[] f9550a;

    /* renamed from: b, reason: collision with root package name */
    public final int f9551b;

    public a(byte[] pcm, int i10) {
        g.f(pcm, "pcm");
        this.f9550a = pcm;
        this.f9551b = i10;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof a) && Arrays.equals(this.f9550a, ((a) obj).f9550a);
    }

    public final int hashCode() {
        return (((Arrays.hashCode(this.f9550a) * 31) + 16000) * 31) + 1;
    }

    public final String toString() {
        return ai.onnxruntime.a.i("StreamPcmChunk(pcm=", this.f9551b, Arrays.toString(this.f9550a), ", sampleRate=16000, channel=1, clientSeq=", ")");
    }
}
