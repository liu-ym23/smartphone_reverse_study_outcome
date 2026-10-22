package c4c;

import com.bytedance.lark.pb.basic.v1.Doc;
import com.bytedance.lark.pb.search.v2.BitableBizType;
import com.bytedance.lark.pb.search.v2.DocMeta;
import com.ss.android.lark.search.dto.info.SearchSpaceInfo;

/* JADX INFO: loaded from: classes38.dex */
public final class h {
    public h() {
    }

    public static SearchSpaceInfo a(DocMeta r100) {
        Integer r101 = null;
        if (r100 == null) goto L78;
        SearchSpaceInfo r102 = new SearchSpaceInfo();
        Doc.Type r103 = r100.type;
        if (r103 != null) goto L7;
        r103 = Doc.Type.UNKNOWN;
    L7:
        r102.setDocType(r103);
        Doc.Type r104 = r100.ori_type;
        if (r104 != null) goto L10;
        r104 = Doc.Type.UNKNOWN;
    L10:
        r102.setOriType(r104);
        Boolean r105 = r100.is_share_folder;
        if (r105 != null) goto L13;
        r105 = Boolean.FALSE;
    L13:
        r102.setIsShareFolder(r105);
        Long r106 = r100.create_time;
        long r107 = 0;
        if (r106 == null) goto L16;
        long r108 = r106.longValue();
    L17:
        r102.setCreateTime(r108);
        Long r109 = r100.update_time;
        if (r109 == null) goto L20;
        long r110 = r109.longValue();
    L21:
        r102.setUpdateTime(r110);
        Long r111 = r100.edit_time;
        if (r111 == null) goto L24;
        long r112 = r111.longValue();
    L25:
        r102.setEditTime(r112);
        String r113 = r100.url;
        String r114 = "";
        if (r113 != null) goto L28;
        r113 = "";
    L28:
        r102.setDocUrl(r113);
        String r115 = r100.f253711id;
        if (r115 != null) goto L31;
        r115 = "";
    L31:
        r102.setToken(r115);
        String r116 = r100.owner_id;
        if (r116 != null) goto L34;
        r116 = "";
    L34:
        r102.setOwnerId(r116);
        String r117 = r100.owner_name;
        if (r117 != null) goto L37;
        r117 = "";
    L37:
        r102.setOwnerName(r117);
        String r118 = r100.message_id;
        if (r118 != null) goto L40;
        r118 = "";
    L40:
        r102.setMessageId(r118);
        String r119 = r100.chat_id;
        if (r119 != null) goto L43;
        r119 = "";
    L43:
        r102.setChatId(r119);
        Integer r120 = r100.position;
        int r121 = -1;
        if (r120 == null) goto L46;
        int r122 = r120.intValue();
    L47:
        r102.setPosition(r122);
        Boolean r123 = r100.is_cross_tenant;
        if (r123 == null) goto L50;
        boolean r124 = r123.booleanValue();
    L51:
        r102.setCrossTenant(r124);
        String r125 = r100.thread_id;
        if (r125 != null) goto L54;
        r125 = "";
    L54:
        r102.setThreadId(r125);
        Integer r126 = r100.thread_position;
        if (r126 == null) goto L57;
        r121 = r126.intValue();
    L57:
        r102.setThreadPosition(r121);
        Long r127 = r100.last_open_time;
        if (r127 == null) goto L60;
        r107 = r127.longValue();
    L60:
        r102.setLastOpenTime(r107);
        String r128 = r100.edit_user_name;
        if (r128 != null) goto L63;
        r128 = "";
    L63:
        r102.setEditUserName(r128);
        String r129 = r100.edit_user_id;
        if (r129 != null) goto L66;
        r129 = "";
    L66:
        r102.setEditUserId(r129);
        String r130 = r100.icon_info;
        if (r130 != null) goto L69;
        r130 = "";
    L69:
        r102.setIconInfo(r130);
        String r131 = r100.file_type;
        if (r131 == null) goto L73;
        r114 = r131;
    L73:
        r102.setFileType(r114);
        BitableBizType r132 = r100.bitable_biz_type;
        if (r132 == null) goto L76;
        r101 = Integer.valueOf(r132.getValue());
    L76:
        r102.setBitableBizType(r101);
        r102.setTagData(n.a(r100.relation_tag));
        return r102;
    L50:
        r124 = false;
        goto L51
    L46:
        r122 = -1;
        goto L47
    L24:
        r112 = 0;
        goto L25
    L20:
        r110 = 0;
        goto L21
    L16:
        r108 = 0;
        goto L17
    L78:
        return null;
    }
}
