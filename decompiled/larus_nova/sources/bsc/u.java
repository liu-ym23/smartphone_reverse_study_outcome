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
public final class u {
    public static final b Companion = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final byte f20462b = 0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final byte f20463c = 0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final byte f20464d = 0;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final byte f20465e = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final byte f20466a;

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly")
    public /* synthetic */ class a implements m0<u> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f20467a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final r0 f20468b = null;

        public a() {
        }

        @Override // nuc.m0
        public final juc.d<?>[] childSerializers() {
            return new juc.d[]{nuc.l.f520729a};
        }

        @Override // juc.d, juc.n, juc.c
        public final luc.f getDescriptor() {
            return f20468b;
        }

        static {
            a r100 = new a();
            f20467a = r100;
            r0 r101 = new r0("io.github.alexzhirkevich.compottie.internal.helpers.MatteMode", r100);
            r101.j("mode", false);
            f20468b = r101;
        }

        @Override // nuc.m0
        public final juc.d<?>[] typeParametersSerializers() {
            return i2.f520710a;
        }

        @Override // juc.c
        public final Object deserialize(muc.e r100) {
            Intrinsics.checkNotNullParameter(r100, "decoder");
            return new u(r100.decodeInline(f20468b).decodeByte());
        }

        @Override // juc.n
        public final void serialize(muc.f r100, Object r101) {
            byte r102 = ((u) r101).f20466a;
            Intrinsics.checkNotNullParameter(r100, "encoder");
            muc.f r103 = r100.encodeInline(f20468b);
            if (r103 == null) goto L7;
            r103.encodeByte(r102);
            return;
        }
    }

    public static final class b {
        public b() {
        }

        public final juc.d<u> serializer() {
            return a.f20467a;
        }
    }

    public final int hashCode() {
        return this.f20466a;
    }

    static {
        Companion = new b();
        f20462b = 1;
        f20463c = 2;
        f20464d = 3;
        f20465e = 4;
    }

    public final String toString() {
        return "MatteMode(mode=" + this.f20466a + ')';
    }

    public /* synthetic */ u(byte r100) {
        this.f20466a = r100;
    }

    public final boolean equals(Object r100) {
        byte r101 = this.f20466a;
        if ((r100 instanceof u) == true) goto L6;
        return false;
    L6:
        if (r101 != ((u) r100).f20466a) goto L11;
        return true;
    L11:
        return false;
    }
}
