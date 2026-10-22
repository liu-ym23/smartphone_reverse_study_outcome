package bsc;

import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.officesdk.api.init.OfficeSDKRequestTag;
import com.ss.bytertc.base.media.screen.RXScreenCaptureService;
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
public final class t {
    public static final b Companion = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String f20452b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final String f20453c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final String f20454d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final String f20455e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final String f20456f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final String f20457g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final String f20458h = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f20459a;

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly")
    public /* synthetic */ class a implements m0<t> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f20460a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final r0 f20461b = null;

        public a() {
        }

        @Override // nuc.m0
        public final juc.d<?>[] childSerializers() {
            return new juc.d[]{v2.f520790a};
        }

        @Override // juc.d, juc.n, juc.c
        public final luc.f getDescriptor() {
            return f20461b;
        }

        static {
            a r100 = new a();
            f20460a = r100;
            r0 r101 = new r0("io.github.alexzhirkevich.compottie.internal.helpers.MaskMode", r100);
            r101.j("type", false);
            f20461b = r101;
        }

        @Override // nuc.m0
        public final juc.d<?>[] typeParametersSerializers() {
            return i2.f520710a;
        }

        @Override // juc.c
        public final Object deserialize(muc.e r100) {
            Intrinsics.checkNotNullParameter(r100, "decoder");
            String r101 = r100.decodeInline(f20461b).decodeString();
            b r102 = t.Companion;
            Intrinsics.checkNotNullParameter(r101, "type");
            return new t(r101);
        }

        @Override // juc.n
        public final void serialize(muc.f r100, Object r101) {
            String r102 = ((t) r101).f20459a;
            Intrinsics.checkNotNullParameter(r100, "encoder");
            Intrinsics.checkNotNullParameter(r102, "value");
            muc.f r103 = r100.encodeInline(f20461b);
            if (r103 == null) goto L7;
            r103.encodeString(r102);
            return;
        }
    }

    public static final class b {
        public b() {
        }

        public final juc.d<t> serializer() {
            return a.f20460a;
        }
    }

    static {
        Companion = new b();
        Intrinsics.checkNotNullParameter(OfficeSDKRequestTag.KEY_NEW_USER, "type");
        f20452b = OfficeSDKRequestTag.KEY_NEW_USER;
        Intrinsics.checkNotNullParameter(BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "type");
        f20453c = BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY;
        Intrinsics.checkNotNullParameter("s", "type");
        f20454d = "s";
        Intrinsics.checkNotNullParameter(RXScreenCaptureService.KEY_INDEX, "type");
        f20455e = RXScreenCaptureService.KEY_INDEX;
        Intrinsics.checkNotNullParameter("l", "type");
        f20456f = "l";
        Intrinsics.checkNotNullParameter("d", "type");
        f20457g = "d";
        Intrinsics.checkNotNullParameter("f", "type");
        f20458h = "f";
    }

    public final int hashCode() {
        return this.f20459a.hashCode();
    }

    public final String toString() {
        String r100 = this.f20459a;
        if (Intrinsics.areEqual(r100, f20452b) == false) goto L6;
        return "None";
    L6:
        if (Intrinsics.areEqual(r100, f20453c) == false) goto L9;
        return "Add";
    L9:
        if (Intrinsics.areEqual(r100, f20454d) == false) goto L12;
        return "Subtract";
    L12:
        if (Intrinsics.areEqual(r100, f20455e) == false) goto L15;
        return "Intersect";
    L15:
        if (Intrinsics.areEqual(r100, f20456f) == false) goto L18;
        return "Lighten";
    L18:
        if (Intrinsics.areEqual(r100, f20457g) == false) goto L21;
        return "Darken";
    L21:
        if (Intrinsics.areEqual(r100, f20458h) == false) goto L24;
        return "Difference";
    L24:
        return "Unknown (" + r100 + ')';
    }

    public final String getType() {
        return this.f20459a;
    }

    public /* synthetic */ t(String r100) {
        this.f20459a = r100;
    }

    public final boolean equals(Object r100) {
        String r101 = this.f20459a;
        if ((r100 instanceof t) == true) goto L6;
        return false;
    L6:
        if (Intrinsics.areEqual(r101, ((t) r100).f20459a) == false) goto L11;
        return true;
    L11:
        return false;
    }
}
