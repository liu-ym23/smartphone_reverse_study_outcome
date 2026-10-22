package cf9;

import com.larus.im.internal.rtcsdk.MessageSendType;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes30.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f23550a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final MessageSendType f23551b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof d) == true) goto L8;
        return false;
    L8:
        d r101 = (d) r100;
        if (this.f23550a == r101.f23550a) goto L12;
        return false;
    L12:
        if (this.f23551b == r101.f23551b) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        long r100 = this.f23550a;
        return (((int) (r100 ^ (r100 >>> 32))) * 31) + this.f23551b.hashCode();
    }

    public final String toString() {
        return "MessageSendTicket(messageId=" + this.f23550a + ", type=" + this.f23551b + ')';
    }

    public final MessageSendType getType() {
        return this.f23551b;
    }

    public d(long r100, MessageSendType r101) {
        Intrinsics.checkNotNullParameter(r101, "type");
        this.f23550a = r100;
        this.f23551b = r101;
    }
}
