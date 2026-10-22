package ch0;

import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.user.IMiddlewareUserService;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
public final class d {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final /* synthetic */ int f23719e = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final IBaseUser f23720a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f23721b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f23722c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final g f23723d;

    public static final class a {
        public static d a() {
            IBaseUser r100 = ((IMiddlewareUserService) jc1.k.n(IMiddlewareUserService.class)).user().b().cloneFrom();
            Intrinsics.checkNotNull(r100);
            return new d(r100, 0, 0, new g("", 0, 0, 0, 0));
        }
    }

    static {
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof d) == false) goto L14;
        d r101 = (d) r100;
        if (Intrinsics.areEqual(this.f23720a, r101.f23720a) == true) goto L8;
        return false;
    L8:
        if (this.f23721b == r101.f23721b) goto L10;
        return false;
    L10:
        if (this.f23722c == r101.f23722c) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f23723d, r101.f23723d) == true) goto L22;
        return false;
    L22:
        return true;
    L14:
        return false;
    }

    public final int hashCode() {
        IBaseUser r100 = this.f23720a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = ((((r102 * 31) + this.f23721b) * 31) + this.f23722c) * 31;
        g r104 = this.f23723d;
        if (r104 == null) goto L10;
        r101 = r104.hashCode();
    L10:
        return r103 + r101;
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "LinkCurrentUserMergeData(user=" + this.f23720a + ", linkStatus=" + this.f23721b + ", silenceStatus=" + this.f23722c + ", rtcLocalUserInfo=" + this.f23723d + ")";
    }

    public d(IBaseUser r100, int r101, int r102, g r103) {
        Intrinsics.checkNotNullParameter(r100, "user");
        Intrinsics.checkNotNullParameter(r103, "rtcLocalUserInfo");
        this.f23720a = r100;
        this.f23721b = r101;
        this.f23722c = r102;
        this.f23723d = r103;
    }

    public static d a(d r100, int r101, int r102, g r103, int r104) {
        if ((r104 & 1) == 0) goto L5;
        IBaseUser r105 = r100.f23720a;
    L7:
        if ((r104 & 2) == 0) goto L10;
        r101 = r100.f23721b;
    L10:
        if ((r104 & 4) == 0) goto L13;
        r102 = r100.f23722c;
    L13:
        if ((r104 & 8) == 0) goto L15;
        r103 = r100.f23723d;
    L15:
        Intrinsics.checkNotNullParameter(r105, "user");
        Intrinsics.checkNotNullParameter(r103, "rtcLocalUserInfo");
        return new d(r105, r101, r102, r103);
    L5:
        r105 = null;
        goto L7
    }
}
