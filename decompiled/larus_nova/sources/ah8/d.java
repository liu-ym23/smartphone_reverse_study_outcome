package ah8;

import com.larus.bmhome.chat.api.WidgetRenderDelegate;
import com.larus.im.bean.message.Message;
import ei9.f;
import kotlin.jvm.internal.Intrinsics;
import xc8.g;

/* JADX INFO: loaded from: classes4.dex */
public final class d implements g {
    @Override // xc8.g
    public final int c() {
        return 33;
    }

    public d() {
    }

    @Override // ei9.g
    public final boolean a(Message r100) {
        Message r101 = r100;
        Intrinsics.checkNotNullParameter(r101, "sourceData");
        if (com.larus.im.bean.message.a.b0(r101) == false) goto L6;
    L8:
        return false;
    L6:
        if (r101.getContentType() != 100) goto L8;
        return true;
    }

    @Override // ei9.g
    public final f b(Message r100) {
        Message r101 = r100;
        Intrinsics.checkNotNullParameter(r101, "sourceData");
        c r102 = new c(r101);
        WidgetRenderDelegate r103 = WidgetRenderDelegate.f297181a;
        String r104 = r101.getMessageId();
        if (r104 != null) goto L5;
        r104 = "";
    L5:
        r103.b(r104, r101.getContent());
        return r102;
    }
}
