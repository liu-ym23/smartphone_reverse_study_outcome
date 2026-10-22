package c4c;

import com.bytedance.lark.pb.search.v2.CustomizationMeta;
import com.ss.android.lark.search.dto.info.SearchCustomizationInfo;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
public final class f {
    public f() {
    }

    public static SearchCustomizationInfo a(CustomizationMeta r100) {
        if (r100 == null) goto L8;
        String r101 = r100.render_content;
        if (r101 == null) goto L8;
        if (Intrinsics.areEqual(r101, "null") == true) goto L8;
        return new SearchCustomizationInfo(r100.card_type, r100.f253707id, r100.render_content, r100.data_source_id, r100.template_name, "mobile_search");
    L8:
        return null;
    }
}
