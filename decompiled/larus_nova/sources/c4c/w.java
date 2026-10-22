package c4c;

import com.bytedance.lark.pb.search.v2.UserGroupMeta;
import com.ss.android.lark.search.dto.info.SearchUserGroupInfo;

/* JADX INFO: loaded from: classes38.dex */
public final class w {
    public w() {
    }

    public static SearchUserGroupInfo a(UserGroupMeta r100) {
        if (r100 == null) goto L4;
        SearchUserGroupInfo r101 = new SearchUserGroupInfo(r100.name, r100.description, r100.type.intValue());
        r101.setId(r100.f253747id);
        return r101;
    L4:
        return null;
    }
}
