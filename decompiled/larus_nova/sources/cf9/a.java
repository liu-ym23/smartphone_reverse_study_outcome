package cf9;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes30.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f23542a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f23543b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f23544c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f23545d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f23546e;

    /* JADX INFO: renamed from: cf9.a$a, reason: collision with other inner class name */
    public static final class C0443a {
    }

    static {
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof a) == true) goto L8;
        return false;
    L8:
        a r101 = (a) r100;
        if (Intrinsics.areEqual(this.f23542a, r101.f23542a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f23543b, r101.f23543b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f23544c, r101.f23544c) == true) goto L18;
        return false;
    L18:
        if (this.f23545d == r101.f23545d) goto L21;
        return false;
    L21:
        if (this.f23546e == r101.f23546e) goto L23;
        return false;
    L23:
        return true;
    }

    public final int hashCode() {
        int r100 = ((((this.f23542a.hashCode() * 31) + this.f23543b.hashCode()) * 31) + this.f23544c.hashCode()) * 31;
        if (this.f23545d == false) goto L5;
        int r101 = 1231;
    L7:
        return ((r100 + r101) * 31) + this.f23546e;
    L5:
        r101 = 1237;
        goto L7
    }

    public final String toString() {
        return "FlowRTCServiceEngineConfig(appId=" + this.f23542a + ", businessId=" + this.f23543b + ", userId=" + this.f23544c + ", skipBtConnPermission=" + this.f23545d + ", connectionType=" + this.f23546e + ')';
    }

    public a(String r100, String r101, String r102, boolean r103, int r104) {
        Intrinsics.checkNotNullParameter(r100, "appId");
        Intrinsics.checkNotNullParameter(r101, "businessId");
        Intrinsics.checkNotNullParameter(r102, "userId");
        this.f23542a = r100;
        this.f23543b = r101;
        this.f23544c = r102;
        this.f23545d = r103;
        this.f23546e = r104;
    }

    public static a a(a r100, String r101, String r102, String r103, boolean r110, int r111, int r112) {
        if ((r112 & 1) == 0) goto L5;
        r101 = r100.f23542a;
    L5:
        String r104 = r101;
        if ((r112 & 2) == 0) goto L8;
        r102 = r100.f23543b;
    L8:
        String r105 = r102;
        if ((r112 & 4) == 0) goto L11;
        r103 = r100.f23544c;
    L11:
        String r106 = r103;
        if ((r112 & 8) == 0) goto L14;
        r110 = r100.f23545d;
    L14:
        boolean r107 = r110;
        if ((r112 & 16) == 0) goto L17;
        r111 = r100.f23546e;
    L17:
        r100.getClass();
        Intrinsics.checkNotNullParameter(r104, "appId");
        Intrinsics.checkNotNullParameter(r105, "businessId");
        Intrinsics.checkNotNullParameter(r106, "userId");
        return new a(r104, r105, r106, r107, r111);
    }
}
