package c4c;

import com.bytedance.lark.pb.search.v2.FacilityMeta;
import com.ss.android.lark.search.dto.info.NavigationAppInfo;

/* JADX INFO: loaded from: classes38.dex */
public final class j {
    public j() {
    }

    public static NavigationAppInfo a(FacilityMeta r100) {
        if (r100 == null) goto L4;
        NavigationAppInfo r101 = new NavigationAppInfo();
        r101.setId(r100.f253713id);
        r101.setSourceKey(r100.source_key);
        return r101;
    L4:
        return null;
    }
}
