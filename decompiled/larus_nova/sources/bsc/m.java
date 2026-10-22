package bsc;

import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.Serializable;
import nuc.i2;
import nuc.m0;
import nuc.r0;
import nuc.w0;

/* JADX INFO: loaded from: classes41.dex */
@JvmInline
@Serializable
public final class m {
    public static final b Companion = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final int f20409b = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f20410a;

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly")
    public /* synthetic */ class a implements m0<m> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f20411a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final r0 f20412b = null;

        public a() {
        }

        @Override // nuc.m0
        public final juc.d<?>[] childSerializers() {
            return new juc.d[]{w0.f520792a};
        }

        @Override // juc.d, juc.n, juc.c
        public final luc.f getDescriptor() {
            return f20412b;
        }

        static {
            a r100 = new a();
            f20411a = r100;
            r0 r101 = new r0("io.github.alexzhirkevich.compottie.internal.helpers.FillRule", r100);
            r101.j("type", false);
            f20412b = r101;
        }

        @Override // nuc.m0
        public final juc.d<?>[] typeParametersSerializers() {
            return i2.f520710a;
        }

        @Override // juc.c
        public final Object deserialize(muc.e r100) {
            Intrinsics.checkNotNullParameter(r100, "decoder");
            return new m(r100.decodeInline(f20412b).decodeInt());
        }

        @Override // juc.n
        public final void serialize(muc.f r100, Object r101) {
            int r102 = ((m) r101).f20410a;
            Intrinsics.checkNotNullParameter(r100, "encoder");
            muc.f r103 = r100.encodeInline(f20412b);
            if (r103 == null) goto L7;
            r103.encodeInt(r102);
            return;
        }
    }

    public static final class b {
        public b() {
        }

        public final juc.d<m> serializer() {
            return a.f20411a;
        }
    }

    public final int hashCode() {
        return this.f20410a;
    }

    static {
        Companion = new b();
        f20409b = 1;
    }

    public final String toString() {
        return "FillRule(type=" + this.f20410a + ')';
    }

    public final int getType() {
        return this.f20410a;
    }

    public /* synthetic */ m(int r100) {
        this.f20410a = r100;
    }

    public final boolean equals(Object r100) {
        int r101 = this.f20410a;
        if ((r100 instanceof m) == true) goto L6;
        return false;
    L6:
        if (r101 != ((m) r100).f20410a) goto L11;
        return true;
    L11:
        return false;
    }
}
