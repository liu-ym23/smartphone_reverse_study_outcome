package b49;

import java.net.InetAddress;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes27.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f17649a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f17650b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f17651c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final InetAddress f17652d;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof c) == true) goto L8;
        return false;
    L8:
        c r101 = (c) r100;
        if (this.f17649a == r101.f17649a) goto L12;
        return false;
    L12:
        if (this.f17650b == r101.f17650b) goto L15;
        return false;
    L15:
        if (this.f17651c == r101.f17651c) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f17652d, r101.f17652d) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        return (((((this.f17649a * 31) + this.f17650b) * 31) + this.f17651c) * 31) + this.f17652d.hashCode();
    }

    public final String toString() {
        return "DoraRTCChannelConfig(channelID=" + this.f17649a + ", localPort=" + this.f17650b + ", targetPort=" + this.f17651c + ", host=" + this.f17652d + ')';
    }

    public c(int r100, int r101, InetAddress r102) {
        Intrinsics.checkNotNullParameter(r102, "host");
        this.f17649a = r100;
        this.f17650b = 0;
        this.f17651c = r101;
        this.f17652d = r102;
    }
}
