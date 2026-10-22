package c4c;

import com.bytedance.lark.pb.search.v2.QaCardMeta;
import com.ss.android.lark.search.dto.info.SearchQACardInfo;

/* JADX INFO: loaded from: classes38.dex */
public final class q {
    public q() {
    }

    public static SearchQACardInfo a(QaCardMeta r100) {
        if (r100 == null) goto L11;
        String r101 = r100.qa_render_meta;
        if (r101 == null) goto L11;
        if (r101.length() <= 0) goto L8;
        boolean r102 = true;
    L9:
        if (r102 == false) goto L11;
        return new SearchQACardInfo(r100.qa_render_meta, r100.jump_type);
    L8:
        r102 = false;
    L11:
        return null;
    }
}
