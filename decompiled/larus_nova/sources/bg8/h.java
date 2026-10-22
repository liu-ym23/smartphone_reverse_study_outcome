package bg8;

import com.larus.bmhome.chat.layout.holder.image.bean.ImageContentData;
import com.larus.bmhome.chat.layout.holder.image.i0;
import com.larus.im.bean.message.Message;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes25.dex */
public final class h implements i0 {
    public h() {
    }

    @Override // com.larus.bmhome.chat.layout.holder.image.i0
    public final void a(Message r100, ImageContentData r101, Message r102) {
        Intrinsics.checkNotNullParameter(r100, "message");
    }

    @Override // com.larus.bmhome.chat.layout.holder.image.i0
    public final boolean b(Message r100) {
        return false;
    }

    @Override // com.larus.bmhome.chat.layout.holder.image.i0
    public final boolean c(Message r100) {
        Intrinsics.checkNotNullParameter(r100, "msg");
        return false;
    }

    @Override // com.larus.bmhome.chat.layout.holder.image.i0
    public final void d(Message r100) {
        Intrinsics.checkNotNullParameter(r100, "msg");
    }
}
