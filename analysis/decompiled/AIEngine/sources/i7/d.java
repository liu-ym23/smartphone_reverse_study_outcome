package i7;

import java.util.Arrays;
import kotlin.jvm.internal.g;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public interface d {

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class a implements d {

        /* renamed from: a, reason: collision with root package name */
        public final boolean f9569a;

        public a(boolean z) {
            this.f9569a = z;
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof a) && this.f9569a == ((a) obj).f9569a;
        }

        public final int hashCode() {
            return Boolean.hashCode(this.f9569a);
        }

        public final String toString() {
            return "AudioComplete(truncated=" + this.f9569a + ")";
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class b implements d {

        /* renamed from: a, reason: collision with root package name */
        public final byte[] f9570a;

        /* renamed from: b, reason: collision with root package name */
        public final int f9571b;

        public b(byte[] pcm, int i10) {
            g.f(pcm, "pcm");
            this.f9570a = pcm;
            this.f9571b = i10;
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof b)) {
                return false;
            }
            b bVar = (b) obj;
            return this.f9571b == bVar.f9571b && Arrays.equals(this.f9570a, bVar.f9570a);
        }

        public final int hashCode() {
            return (((Arrays.hashCode(this.f9570a) * 31) + this.f9571b) * 31) + 1;
        }

        public final String toString() {
            return ai.onnxruntime.a.i("AudioDelta(pcm=", this.f9571b, Arrays.toString(this.f9570a), ", sampleRate=", ", channels=1)");
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class c implements d {

        /* renamed from: a, reason: collision with root package name */
        public final int f9572a;

        /* renamed from: b, reason: collision with root package name */
        public final String f9573b;

        public c(int i10, String message) {
            g.f(message, "message");
            this.f9572a = i10;
            this.f9573b = message;
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof c)) {
                return false;
            }
            c cVar = (c) obj;
            return this.f9572a == cVar.f9572a && g.b(this.f9573b, cVar.f9573b);
        }

        public final int hashCode() {
            return this.f9573b.hashCode() + (Integer.hashCode(this.f9572a) * 31);
        }

        public final String toString() {
            return "Failed(code=" + this.f9572a + ", message=" + this.f9573b + ")";
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    /* renamed from: i7.d$d, reason: collision with other inner class name */
    public static final class C0092d implements d {

        /* renamed from: a, reason: collision with root package name */
        public static final C0092d f9574a = new C0092d();

        public final boolean equals(Object obj) {
            return this == obj || (obj instanceof C0092d);
        }

        public final int hashCode() {
            return -574006649;
        }

        public final String toString() {
            return "InputClosed";
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class e implements d {

        /* renamed from: a, reason: collision with root package name */
        public static final e f9575a = new e();

        public final boolean equals(Object obj) {
            return this == obj || (obj instanceof e);
        }

        public final int hashCode() {
            return 1129018908;
        }

        public final String toString() {
            return "SessionReady";
        }
    }
}
