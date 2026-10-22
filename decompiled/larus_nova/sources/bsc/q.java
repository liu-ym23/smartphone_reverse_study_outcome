package bsc;

import com.byted.cast.linkcommon.cybergarage.http.HTTP;
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
public final class q {
    public static final b Companion = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final byte f20421b = 0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final byte f20422c = 0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final byte f20423d = 0;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final byte f20424e = 0;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final byte f20425f = 0;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final byte f20426g = 0;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final byte f20427h = 0;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final byte f20428i = 0;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final byte f20429j = 0;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final byte f20430k = 0;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final byte f20431l = 0;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final byte f20432m = 0;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final byte f20433n = 0;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final byte f20434o = 0;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final byte f20435p = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final byte f20436a;

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly")
    public /* synthetic */ class a implements m0<q> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f20437a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final r0 f20438b = null;

        public a() {
        }

        @Override // nuc.m0
        public final juc.d<?>[] childSerializers() {
            return new juc.d[]{nuc.l.f520729a};
        }

        @Override // juc.d, juc.n, juc.c
        public final luc.f getDescriptor() {
            return f20438b;
        }

        static {
            a r100 = new a();
            f20437a = r100;
            r0 r101 = new r0("io.github.alexzhirkevich.compottie.internal.helpers.LottieBlendMode", r100);
            r101.j("type", false);
            f20438b = r101;
        }

        @Override // nuc.m0
        public final juc.d<?>[] typeParametersSerializers() {
            return i2.f520710a;
        }

        @Override // juc.c
        public final Object deserialize(muc.e r100) {
            Intrinsics.checkNotNullParameter(r100, "decoder");
            return new q(r100.decodeInline(f20438b).decodeByte());
        }

        @Override // juc.n
        public final void serialize(muc.f r100, Object r101) {
            byte r102 = ((q) r101).f20436a;
            Intrinsics.checkNotNullParameter(r100, "encoder");
            muc.f r103 = r100.encodeInline(f20438b);
            if (r103 == null) goto L7;
            r103.encodeByte(r102);
            return;
        }
    }

    public static final class b {
        public b() {
        }

        public final juc.d<q> serializer() {
            return a.f20437a;
        }
    }

    public final int hashCode() {
        return this.f20436a;
    }

    static {
        Companion = new b();
        f20421b = 1;
        f20422c = 2;
        f20423d = 3;
        f20424e = 4;
        f20425f = 5;
        f20426g = 6;
        f20427h = 7;
        f20428i = 8;
        f20429j = 9;
        f20430k = 10;
        f20431l = 11;
        f20432m = 12;
        f20433n = HTTP.CR;
        f20434o = 14;
        f20435p = 15;
    }

    public final String toString() {
        return "LottieBlendMode(type=" + this.f20436a + ')';
    }

    public final byte getType() {
        return this.f20436a;
    }

    public /* synthetic */ q(byte r100) {
        this.f20436a = r100;
    }

    public final boolean equals(Object r100) {
        byte r101 = this.f20436a;
        if ((r100 instanceof q) == true) goto L6;
        return false;
    L6:
        if (r101 != ((q) r100).f20436a) goto L11;
        return true;
    L11:
        return false;
    }
}
