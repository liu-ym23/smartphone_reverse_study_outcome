package aya;

import kotlin.jvm.internal.Intrinsics;
import okio.ByteString;

/* JADX INFO: loaded from: classes34.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ByteString f16772a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f16773b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f16774c;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof b) == true) goto L8;
        return false;
    L8:
        b r101 = (b) r100;
        if (Intrinsics.areEqual(this.f16772a, r101.f16772a) == true) goto L12;
        return false;
    L12:
        if (this.f16773b == r101.f16773b) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f16774c, r101.f16774c) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        int r100 = this.f16772a.hashCode() * 31;
        long r101 = this.f16773b;
        return ((r100 + ((int) (r101 ^ (r101 >>> 32)))) * 31) + this.f16774c.hashCode();
    }

    public final String toString() {
        return "FloatExpandContext(floatExpandContent=" + this.f16772a + ", replyMsgId=" + this.f16773b + ", chatId=" + this.f16774c + ')';
    }

    public b(ByteString r100, long r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, "floatExpandContent");
        Intrinsics.checkNotNullParameter(r102, "chatId");
        this.f16772a = r100;
        this.f16773b = r101;
        this.f16774c = r102;
    }
}
