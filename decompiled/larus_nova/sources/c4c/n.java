package c4c;

import com.ss.android.lark.chat.entity.tag.TagData;
import com.ss.android.lark.chat.entity.tag.TagDataItem;
import com.ss.android.lark.chat.entity.tag.TagRelationTypeEnum;
import com.ss.android.lark.chat.entity.tag.TagTypeEnum;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.JvmStatic;

/* JADX INFO: loaded from: classes38.dex */
public final class n {
    static {
    }

    @JvmStatic
    public static final TagData a(com.bytedance.lark.pb.search.v2.TagData r100) {
        if (r100 != null) goto L5;
        return null;
    L5:
        List<com.bytedance.lark.pb.search.v2.TagData.TagDataItem> r101 = r100.tag_data_items;
        ArrayList r102 = new ArrayList();
        Iterator<T> r103 = r101.iterator();
    L7:
        if (r103.hasNext() == false) goto L10;
        com.bytedance.lark.pb.search.v2.TagData.TagDataItem r104 = (com.bytedance.lark.pb.search.v2.TagData.TagDataItem) r103.next();
        String r105 = r104.text_val;
        TagTypeEnum r106 = TagTypeEnum.RELATION_TAG;
        TagRelationTypeEnum.a r107 = TagRelationTypeEnum.Companion;
        int r108 = r104.resp_tag_type.getValue();
        r107.getClass();
        r102.add(new TagDataItem(r105, r106, TagRelationTypeEnum.a.a(r108), 0));
        goto L7
    L10:
        return new TagData(r102);
    }
}
