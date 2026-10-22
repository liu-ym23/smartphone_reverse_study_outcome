package c4c;

import com.bytedance.lark.pb.search.v2.WikiSpaceMeta;
import com.ss.android.lark.search.dto.info.SearchWikiSpaceInfo;

/* JADX INFO: loaded from: classes38.dex */
public final class z {
    public z() {
    }

    public static SearchWikiSpaceInfo a(WikiSpaceMeta r100) {
        if (r100 == null) goto L4;
        SearchWikiSpaceInfo r101 = new SearchWikiSpaceInfo();
        r101.setSpaceId(r100.space_id);
        r101.setSpaceName(r100.space_name);
        r101.setDescription(r100.description);
        r101.setStar(r100.is_star.booleanValue());
        r101.setWikiSpaceType(r100.wiki_space_type);
        r101.setWikiScope(r100.wiki_scope);
        r101.setRootToken(r100.root_token);
        r101.setCoverColorValue(r100.cover_color_value);
        r101.setCoverIsGraphDark(r100.cover_is_graph_dark.booleanValue());
        r101.setCoverKey(r100.cover_key);
        r101.setCoverOrigin(r100.cover_origin);
        r101.setCoverThumbnail(r100.cover_thumbnail);
        return r101;
    L4:
        return null;
    }
}
