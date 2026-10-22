package cf9;

import com.larus.im.internal.rtcsdk.MessageSendType;
import java.util.Arrays;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes30.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final byte[] f23548a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final MessageSendType f23549b;

    public final String toString() {
        return "MessageSendInfo(message=" + Arrays.toString(this.f23548a) + ", type=" + this.f23549b + ')';
    }

    public final int hashCode() {
        return (Arrays.hashCode(this.f23548a) * 31) + this.f23549b.hashCode();
    }

    public final MessageSendType getType() {
        return this.f23549b;
    }

    public c(byte[] r100) {
        MessageSendType r101 = MessageSendType.P2P;
        Intrinsics.checkNotNullParameter(r100, "message");
        Intrinsics.checkNotNullParameter(r101, "type");
        this.f23548a = r100;
        this.f23549b = r101;
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof c) == true) goto L8;
        return false;
    L8:
        c r101 = (c) r100;
        if (Arrays.equals(this.f23548a, r101.f23548a) == true) goto L12;
        return false;
    L12:
        if (this.f23549b == r101.f23549b) goto L14;
        return false;
    L14:
        return true;
    }
}
