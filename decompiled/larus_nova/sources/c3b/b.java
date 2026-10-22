package c3b;

import android.content.Context;
import android.text.Layout;
import com.ss.android.lark.chat.chatwindow.chat.data.convert.textrender.TextLayoutRender;
import com.ss.android.lark.chat.chatwindow.chat.data.convert.textrender.TextLayoutRenderExtKt;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.lark.widget.richtext.RichText;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
public final class b {
    public static final Layout a(RichText r100, Context r101, boolean r102, List<String> r103, List<String> r104) {
        Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
        com.ss.android.lark.chat.chatwindow.chat.data.convert.textprocess.b r105 = new com.ss.android.lark.chat.chatwindow.chat.data.convert.textprocess.b();
        r105.f412415h = false;
        r105.f412420m = false;
        r105.f412406c = false;
        Layout.Alignment r106 = Layout.Alignment.ALIGN_NORMAL;
        Intrinsics.checkNotNullParameter(r106, "alignment");
        r105.f412429v = r106;
        r105.f412408d = r102;
        if (r103 == null) goto L5;
        Intrinsics.checkNotNullParameter(r103, "<set-?>");
        r105.f412402a = r103;
    L5:
        if (r104 == null) goto L7;
        Intrinsics.checkNotNullParameter(r104, "<set-?>");
        r105.f412404b = r104;
    L7:
        int r107 = TextLayoutRender.f412443j;
        return TextLayoutRenderExtKt.e(w2b.b.f558082d, r100, r105, r101);
    }
}
