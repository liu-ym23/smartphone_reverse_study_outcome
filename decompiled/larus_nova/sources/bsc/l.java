package bsc;

import com.amap.api.col.s.ce;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.Serializable;
import nuc.i2;
import nuc.m0;
import nuc.r0;
import nuc.v2;

/* JADX INFO: loaded from: classes41.dex */
@JvmInline
@Serializable
public final class l {
    public static final b Companion = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String f20405b = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f20406a;

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly")
    public /* synthetic */ class a implements m0<l> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f20407a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final r0 f20408b = null;

        public a() {
        }

        @Override // nuc.m0
        public final juc.d<?>[] childSerializers() {
            return new juc.d[]{v2.f520790a};
        }

        @Override // juc.d, juc.n, juc.c
        public final luc.f getDescriptor() {
            return f20408b;
        }

        static {
            a r100 = new a();
            f20407a = r100;
            r0 r101 = new r0("io.github.alexzhirkevich.compottie.internal.helpers.DashType", r100);
            r101.j("type", false);
            f20408b = r101;
        }

        @Override // nuc.m0
        public final juc.d<?>[] typeParametersSerializers() {
            return i2.f520710a;
        }

        @Override // juc.c
        public final Object deserialize(muc.e r100) {
            Intrinsics.checkNotNullParameter(r100, "decoder");
            String r101 = r100.decodeInline(f20408b).decodeString();
            b r102 = l.Companion;
            Intrinsics.checkNotNullParameter(r101, "type");
            return new l(r101);
        }

        @Override // juc.n
        public final void serialize(muc.f r100, Object r101) {
            String r102 = ((l) r101).f20406a;
            Intrinsics.checkNotNullParameter(r100, "encoder");
            Intrinsics.checkNotNullParameter(r102, "value");
            muc.f r103 = r100.encodeInline(f20408b);
            if (r103 == null) goto L7;
            r103.encodeString(r102);
            return;
        }
    }

    public static final class b {
        public b() {
        }

        public final juc.d<l> serializer() {
            return a.f20407a;
        }
    }

    static {
        Companion = new b();
        Intrinsics.checkNotNullParameter("d", "type");
        Intrinsics.checkNotNullParameter(ce.f26391f, "type");
        Intrinsics.checkNotNullParameter("o", "type");
        f20405b = "o";
    }

    public final int hashCode() {
        return this.f20406a.hashCode();
    }

    public final String toString() {
        return "DashType(type=" + this.f20406a + ')';
    }

    public final String getType() {
        return this.f20406a;
    }

    public /* synthetic */ l(String r100) {
        this.f20406a = r100;
    }

    public final boolean equals(Object r100) {
        String r101 = this.f20406a;
        if ((r100 instanceof l) == true) goto L6;
        return false;
    L6:
        if (Intrinsics.areEqual(r101, ((l) r100).f20406a) == false) goto L11;
        return true;
    L11:
        return false;
    }
}
