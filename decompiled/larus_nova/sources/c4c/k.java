package c4c;

import com.bytedance.lark.pb.search.v2.MailContactMeta;
import com.ss.android.lark.search.dto.info.SearchMailContactInfo;

/* JADX INFO: loaded from: classes38.dex */
public final class k {
    public k() {
    }

    public static SearchMailContactInfo a(MailContactMeta r100) {
        if (r100 != null) goto L6;
        return null;
    L6:
        return new SearchMailContactInfo(r100.f253715id, r100.email, r100.type);
    }
}
