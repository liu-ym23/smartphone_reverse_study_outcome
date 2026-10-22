package c4c;

import com.bytedance.lark.pb.search.v2.BitableBizType;
import com.bytedance.lark.pb.search.v2.WikiMeta;
import com.ss.android.lark.search.dto.info.SearchSpaceInfo;
import com.ss.android.lark.search.dto.info.SearchWikiInfo;

/* JADX INFO: loaded from: classes38.dex */
public final class y {
    public y() {
    }

    public static SearchWikiInfo a(WikiMeta r100) {
        Integer r101 = null;
        if (r100 == null) goto L16;
        SearchWikiInfo r102 = new SearchWikiInfo();
        r102.setUrl(r100.url);
        r102.setToken(r100.token);
        SearchSpaceInfo r103 = new SearchSpaceInfo();
        r103.setId(r100.f253751id);
        r103.setDocType(r100.type);
        r103.setOriType(r100.ori_type);
        r103.setUpdateTime(r100.update_time.longValue());
        r103.setEditTime(r100.edit_time.longValue());
        String r104 = r100.url;
        String r105 = "";
        if (r104 != null) goto L7;
        r104 = "";
    L7:
        r103.setDocUrl(r104);
        String r106 = r100.token;
        if (r106 == null) goto L11;
        r105 = r106;
    L11:
        r103.setToken(r105);
        r103.setOwnerId(r100.owner_id);
        r103.setOwnerName(r100.owner_name);
        r103.setSpaceId(r100.space_id);
        r103.setSpaceName(r100.space_name);
        r103.setMessageId(r100.message_id);
        r103.setChatId(r100.chat_id);
        r103.setPosition(r100.position.intValue());
        r103.setCrossTenant(r100.is_cross_tenant.booleanValue());
        r103.setThreadId(r100.thread_id);
        r103.setThreadPosition(r100.thread_position.intValue());
        r103.setLastOpenTime(r100.last_open_time.longValue());
        r103.setEditUserName(r100.edit_user_name);
        r103.setIconInfo(r100.icon_info);
        BitableBizType r107 = r100.bitable_biz_type;
        if (r107 == null) goto L14;
        r101 = Integer.valueOf(r107.getValue());
    L14:
        r103.setBitableBizType(r101);
        r103.setTagData(n.a(r100.relation_tag));
        r102.setSpaceInfo(r103);
        return r102;
    L16:
        return null;
    }
}
