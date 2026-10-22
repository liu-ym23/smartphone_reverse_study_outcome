package al9;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
public final class a<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f4197a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Class<T> f4198b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f4199c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f4200d;

    public /* synthetic */ a() {
        throw null;
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof a) == true) goto L8;
        return false;
    L8:
        a r101 = (a) r100;
        if (Intrinsics.areEqual(this.f4197a, r101.f4197a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f4198b, r101.f4198b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f4199c, r101.f4199c) == true) goto L18;
        return false;
    L18:
        if (this.f4200d == r101.f4200d) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        int r100 = ((((this.f4197a.hashCode() * 31) + this.f4198b.hashCode()) * 31) + this.f4199c.hashCode()) * 31;
        if (this.f4200d == false) goto L5;
        int r101 = 1231;
    L7:
        return r100 + r101;
    L5:
        r101 = 1237;
        goto L7
    }

    public final String toString() {
        return "PluginInfo(packageName=" + this.f4197a + ", iService=" + this.f4198b + ", serviceImpl=" + this.f4199c + ", bindState=" + this.f4200d + ')';
    }

    public a(String r100, Class<T> r101, String r102, boolean r103) {
        Intrinsics.checkNotNullParameter(r100, "packageName");
        Intrinsics.checkNotNullParameter(r101, "iService");
        Intrinsics.checkNotNullParameter(r102, "serviceImpl");
        this.f4197a = r100;
        this.f4198b = r101;
        this.f4199c = r102;
        this.f4200d = r103;
    }
}
