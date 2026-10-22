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
public final class y {
    public static final b Companion = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final byte f20487b = 0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final byte f20488c = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final byte f20489a;

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly")
    public /* synthetic */ class a implements m0<y> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f20490a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final r0 f20491b = null;

        public a() {
        }

        @Override // nuc.m0
        public final juc.d<?>[] childSerializers() {
            return new juc.d[]{nuc.l.f520729a};
        }

        @Override // juc.d, juc.n, juc.c
        public final luc.f getDescriptor() {
            return f20491b;
        }

        static {
            a r100 = new a();
            f20490a = r100;
            r0 r101 = new r0("io.github.alexzhirkevich.compottie.internal.helpers.TrimPathType", r100);
            r101.j("type", false);
            f20491b = r101;
        }

        @Override // nuc.m0
        public final juc.d<?>[] typeParametersSerializers() {
            return i2.f520710a;
        }

        @Override // juc.c
        public final Object deserialize(muc.e r100) {
            Intrinsics.checkNotNullParameter(r100, "decoder");
            return new y(r100.decodeInline(f20491b).decodeByte());
        }

        @Override // juc.n
        public final void serialize(muc.f r100, Object r101) {
            byte r102 = ((y) r101).f20489a;
            Intrinsics.checkNotNullParameter(r100, "encoder");
            muc.f r103 = r100.encodeInline(f20491b);
            if (r103 == null) goto L7;
            r103.encodeByte(r102);
            return;
        }
    }

    public static final class b {
        public b() {
        }

        public final juc.d<y> serializer() {
            return a.f20490a;
        }
    }

    public final int hashCode() {
        return this.f20489a;
    }

    static {
        Companion = new b();
        f20487b = 1;
        f20488c = 2;
    }

    public final String toString() {
        return "TrimPathType(type=" + this.f20489a + ')';
    }

    public final byte getType() {
        return this.f20489a;
    }

    public /* synthetic */ y(byte r100) {
        this.f20489a = r100;
    }

    public final boolean equals(Object r100) {
        byte r101 = this.f20489a;
        if ((r100 instanceof y) == true) goto L6;
        return false;
    L6:
        if (r101 != ((y) r100).f20489a) goto L11;
        return true;
    L11:
        return false;
    }
}
