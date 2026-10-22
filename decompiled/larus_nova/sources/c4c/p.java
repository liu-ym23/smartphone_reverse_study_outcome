package c4c;

import com.bytedance.lark.pb.search.v2.SlashCommandMeta;
import com.ss.android.lark.search.dto.info.SearchOpenSearchInfo;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: loaded from: classes38.dex */
public final class p {
    public p() {
    }

    public static SearchOpenSearchInfo a(SlashCommandMeta r100) {
        if (r100 == null) goto L8;
        SearchOpenSearchInfo r101 = new SearchOpenSearchInfo();
        r101.setCreateTime(r100.render_time_stamp.longValue());
        r101.setImageUrl(r100.image_url);
        r101.setApp_link(r100.app_link);
        r101.setExtraTitle(r100.description);
        r101.setExtra(r100.extra);
        r101.setBizType(r100.biz_type);
        r101.setSlash_command_type(com.bytedance.lark.pb.search.slash.v1.SlashCommandMeta.SlashCommandType.fromValue(r100.slash_command_type.getValue()));
        ArrayList r102 = new ArrayList();
        Iterator<T> r103 = r100.tag.iterator();
    L5:
        if (r103.hasNext() == false) goto L7;
        SlashCommandMeta.SlashCommandTag r104 = (SlashCommandMeta.SlashCommandTag) r103.next();
        new com.bytedance.lark.pb.search.slash.v1.SlashCommandMeta.SlashCommandTag.Builder().type(r104.type).text(r104.text).build();
        goto L5
    L7:
        r101.setTag(r102);
        r101.setSlashId(r100.data_source_id);
        return r101;
    L8:
        return null;
    }
}
