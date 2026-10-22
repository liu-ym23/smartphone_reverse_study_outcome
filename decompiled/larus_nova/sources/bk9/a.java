package bk9;

import com.bytedance.android.gamecp.business.instantplay.InstantPlayContext;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes30.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f19383a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f19384b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f19385c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f19386d;

    public a() {
        String r100 = null;
        this(r100, r100, 15);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof a) == true) goto L8;
        return false;
    L8:
        a r101 = (a) r100;
        if (Intrinsics.areEqual(this.f19383a, r101.f19383a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f19384b, r101.f19384b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f19385c, r101.f19385c) == true) goto L18;
        return false;
    L18:
        if (this.f19386d == r101.f19386d) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        int r100 = ((((this.f19383a.hashCode() * 31) + this.f19384b.hashCode()) * 31) + this.f19385c.hashCode()) * 31;
        if (this.f19386d == false) goto L5;
        int r101 = 1231;
    L7:
        return r100 + r101;
    L5:
        r101 = 1237;
        goto L7
    }

    public final String toString() {
        return "AccountInfo(avatarUrl=" + this.f19383a + ", nickname=" + this.f19384b + ", platformNickname=" + this.f19385c + ", switchBindDisabled=" + this.f19386d + ')';
    }

    public /* synthetic */ a(String r100, String r101, int r102) {
        String r103 = "";
        if ((r102 & 1) == 0) goto L6;
        r100 = "";
    L6:
        if ((r102 & 2) == 0) goto L9;
        r101 = "";
    L9:
        if ((r102 & 4) != 0) goto L12;
        r103 = null;
    L12:
        this(r100, r101, r103, false);
    }

    public a(String r100, String r101, String r102, boolean r103) {
        Intrinsics.checkNotNullParameter(r100, "avatarUrl");
        Intrinsics.checkNotNullParameter(r101, InstantPlayContext.NICKNAME);
        Intrinsics.checkNotNullParameter(r102, "platformNickname");
        this.f19383a = r100;
        this.f19384b = r101;
        this.f19385c = r102;
        this.f19386d = r103;
    }
}
