package bsc;

import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.Serializable;
import nuc.i2;
import nuc.m0;
import nuc.r0;

/* JADX INFO: loaded from: classes41.dex */
@JvmInline
@Serializable
public final class p {
    public static final b Companion = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final byte f20417b = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final byte f20418a;

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly")
    public /* synthetic */ class a implements m0<p> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f20419a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final r0 f20420b = null;

        public a() {
        }

        @Override // nuc.m0
        public final juc.d<?>[] childSerializers() {
            return new juc.d[]{nuc.l.f520729a};
        }

        @Override // juc.d, juc.n, juc.c
        public final luc.f getDescriptor() {
            return f20420b;
        }

        static {
            a r100 = new a();
            f20419a = r100;
            r0 r101 = new r0("io.github.alexzhirkevich.compottie.internal.helpers.GradientType", r100);
            r101.j("type", false);
            f20420b = r101;
        }

        @Override // nuc.m0
        public final juc.d<?>[] typeParametersSerializers() {
            return i2.f520710a;
        }

        @Override // juc.c
        public final Object deserialize(muc.e r100) {
            Intrinsics.checkNotNullParameter(r100, "decoder");
            return new p(r100.decodeInline(f20420b).decodeByte());
        }

        @Override // juc.n
        public final void serialize(muc.f r100, Object r101) {
            byte r102 = ((p) r101).f20418a;
            Intrinsics.checkNotNullParameter(r100, "encoder");
            muc.f r103 = r100.encodeInline(f20420b);
            if (r103 == null) goto L7;
            r103.encodeByte(r102);
            return;
        }
    }

    public static final class b {
        public b() {
        }

        public final juc.d<p> serializer() {
            return a.f20419a;
        }
    }

    public final int hashCode() {
        return this.f20418a;
    }

    static {
        Companion = new b();
        f20417b = 1;
    }

    public final String toString() {
        return "GradientType(type=" + this.f20418a + ')';
    }

    public final byte getType() {
        return this.f20418a;
    }

    public /* synthetic */ p(byte r100) {
        this.f20418a = r100;
    }

    public final boolean equals(Object r100) {
        byte r101 = this.f20418a;
        if ((r100 instanceof p) == true) goto L6;
        return false;
    L6:
        if (r101 != ((p) r100).f20418a) goto L11;
        return true;
    L11:
        return false;
    }
}
