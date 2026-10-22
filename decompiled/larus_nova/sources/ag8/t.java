package ag8;

import com.larus.im.bean.message.Message;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class t implements xc8.g {
    @Override // xc8.g
    public final int c() {
        return 17;
    }

    public t() {
    }

    @Override // ei9.g
    public final boolean a(Message r100) {
        Message r101 = r100;
        Intrinsics.checkNotNullParameter(r101, "sourceData");
        if (r101.getContentType() == 6) goto L5;
    L7:
        return false;
    L5:
        if (r101.getUserType() != 1) goto L7;
        return true;
    }

    @Override // ei9.g
    public final ei9.f b(Message r100) {
        Message r101 = r100;
        Intrinsics.checkNotNullParameter(r101, "sourceData");
        return new s(r101);
    }
}
