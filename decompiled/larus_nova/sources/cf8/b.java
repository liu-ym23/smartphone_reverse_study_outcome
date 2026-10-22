package cf8;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes25.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f23538a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f23539b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Integer f23540c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Integer f23541d;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof b) == true) goto L8;
        return false;
    L8:
        b r101 = (b) r100;
        if (Intrinsics.areEqual(this.f23538a, r101.f23538a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f23539b, r101.f23539b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f23540c, r101.f23540c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f23541d, r101.f23541d) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        String r100 = this.f23538a;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String r104 = this.f23539b;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        Integer r107 = this.f23540c;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        Integer r110 = this.f23541d;
        if (r110 == null) goto L19;
        r101 = r110.hashCode();
    L19:
        return r109 + r101;
    L13:
        r108 = r107.hashCode();
        goto L14
    L9:
        r105 = r104.hashCode();
        goto L10
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public final String toString() {
        return "ServiceBotCardLongPressData(messageId=" + this.f23538a + ", content=" + this.f23539b + ", longPressPositionX=" + this.f23540c + ", longPressPositionY=" + this.f23541d + ')';
    }

    public b(String r100, String r101, Integer r102, Integer r103) {
        this.f23538a = r100;
        this.f23539b = r101;
        this.f23540c = r102;
        this.f23541d = r103;
    }
}
