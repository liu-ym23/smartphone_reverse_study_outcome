package b37;

import androidx.camera.video.AudioStats;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.UnknownFieldException;
import nuc.b0;
import nuc.b2;
import nuc.g2;
import nuc.i2;
import nuc.m0;

/* JADX INFO: loaded from: classes21.dex */
@Serializable
public final class c {
    public static final b Companion = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final double f17208a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final double f17209b;

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly")
    public /* synthetic */ class a implements m0<c> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f17210a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final g2 f17211b = null;

        public a() {
        }

        @Override // nuc.m0
        public final juc.d<?>[] childSerializers() {
            b0 r100 = b0.f520644a;
            return new juc.d[]{r100, r100};
        }

        @Override // juc.d, juc.n, juc.c
        public final luc.f getDescriptor() {
            return f17211b;
        }

        static {
            a r100 = new a();
            f17210a = r100;
            g2 r101 = new g2("com.bytedance.navigation.kmp.data.LatLng", r100, 2);
            r101.j("latitude", true);
            r101.j("longitude", true);
            f17211b = r101;
        }

        @Override // nuc.m0
        public final juc.d<?>[] typeParametersSerializers() {
            return i2.f520710a;
        }

        @Override // juc.c
        public final Object deserialize(muc.e r110) {
            Intrinsics.checkNotNullParameter(r110, "decoder");
            g2 r100 = f17211b;
            muc.c r101 = r110.beginStructure(r100);
            if (r101.decodeSequentially() == false) goto L5;
            double r111 = r101.decodeDoubleElement(r100, 0);
            double r112 = r101.decodeDoubleElement(r100, 1);
            int r113 = 3;
        L17:
            r101.endStructure(r100);
            return new c(r113, r111, r112);
        L5:
            double r102 = AudioStats.AUDIO_AMPLITUDE_NONE;
            double r103 = 0.0d;
            int r104 = 0;
            boolean r105 = true;
        L6:
            if (r105 == false) goto L16;
            int r114 = r101.decodeElementIndex(r100);
            if (r114 != (-1)) goto L9;
            r105 = false;
            goto L6
        L9:
            if (r114 != 0) goto L10;
            r102 = r101.decodeDoubleElement(r100, 0);
            r104 = r104 | 1;
            goto L6
        L10:
            if (r114 != 1) goto L13;
            r103 = r101.decodeDoubleElement(r100, 1);
            r104 = r104 | 2;
            goto L6
        L13:
            throw new UnknownFieldException(r114);
        L16:
            r113 = r104;
            r111 = r102;
            r112 = r103;
            goto L17
        }

        @Override // juc.n
        public final void serialize(muc.f r100, Object r110) {
            c r111 = (c) r110;
            Intrinsics.checkNotNullParameter(r100, "encoder");
            Intrinsics.checkNotNullParameter(r111, "value");
            g2 r101 = f17211b;
            muc.d r102 = r100.beginStructure(r101);
            b r103 = c.Companion;
            boolean r104 = false;
            if (r102.shouldEncodeElementDefault(r101, 0) == false) goto L6;
        L7:
            boolean r105 = true;
        L9:
            if (r105 == false) goto L12;
            r102.encodeDoubleElement(r101, 0, r111.f17208a);
        L12:
            if (r102.shouldEncodeElementDefault(r101, 1) == false) goto L15;
        L16:
            r104 = true;
        L17:
            if (r104 == false) goto L19;
            r102.encodeDoubleElement(r101, 1, r111.f17209b);
        L19:
            r102.endStructure(r101);
            return;
        L15:
            if (Double.compare(r111.f17209b, AudioStats.AUDIO_AMPLITUDE_NONE) == 0) goto L17;
        L6:
            if (Double.compare(r111.f17208a, AudioStats.AUDIO_AMPLITUDE_NONE) != 0) goto L7;
            r105 = false;
            goto L9
        }
    }

    public static final class b {
        public b() {
        }

        public final juc.d<c> serializer() {
            return a.f17210a;
        }
    }

    public c() {
        this(0);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof c) == true) goto L8;
        return false;
    L8:
        c r101 = (c) r100;
        if (Double.compare(this.f17208a, r101.f17208a) == 0) goto L12;
        return false;
    L12:
        if (Double.compare(this.f17209b, r101.f17209b) == 0) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        long r100 = Double.doubleToLongBits(this.f17208a);
        int r101 = ((int) (r100 ^ (r100 >>> 32))) * 31;
        long r102 = Double.doubleToLongBits(this.f17209b);
        return r101 + ((int) (r102 ^ (r102 >>> 32)));
    }

    public final String toString() {
        return "LatLng(latitude=" + this.f17208a + ", longitude=" + this.f17209b + ")";
    }

    static {
        Companion = new b();
    }

    public /* synthetic */ c(int r100) {
        this(AudioStats.AUDIO_AMPLITUDE_NONE, AudioStats.AUDIO_AMPLITUDE_NONE);
    }

    public c(double r100, double r101) {
        this.f17208a = r100;
        this.f17209b = r101;
    }

    public c(int r100, double r101, double r102) {
        if ((r100 & 0) == 0) goto L5;
        b2.b(r100, 0, a.f17211b);
        throw null;
    L5:
        if ((r100 & 1) != 0) goto L7;
        this.f17208a = AudioStats.AUDIO_AMPLITUDE_NONE;
    L9:
        if ((r100 & 2) != 0) goto L11;
        this.f17209b = AudioStats.AUDIO_AMPLITUDE_NONE;
        return;
    L11:
        this.f17209b = r102;
        return;
    L7:
        this.f17208a = r101;
        goto L9
    }
}
