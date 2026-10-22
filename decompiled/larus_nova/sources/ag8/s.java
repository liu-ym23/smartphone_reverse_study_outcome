package ag8;

import com.larus.im.bean.message.Message;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes25.dex */
public final class s extends xc8.b {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Message f3361e;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof s) == true) goto L9;
        return false;
    L9:
        if (Intrinsics.areEqual(this.f3361e, ((s) r100).f3361e) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public final int hashCode() {
        return this.f3361e.hashCode();
    }

    public final String toString() {
        return "SendImageCellState(sendImageMessage=" + this.f3361e + ')';
    }

    @Override // xc8.b
    public final int d() {
        return com.larus.bmhome.chat.bean.d.G0(this.f3361e) ? 1 : 0;
    }

    public s(Message r100) {
        Intrinsics.checkNotNullParameter(r100, "sendImageMessage");
        super(r100);
        this.f3361e = r100;
    }
}
