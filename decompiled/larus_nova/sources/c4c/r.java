package c4c;

import com.bytedance.lark.pb.search.resource.MessageRelatedInfo;
import com.bytedance.lark.pb.search.resource.ResourceMeta;
import com.ss.android.lark.search.dto.info.SearchResourceInfo;

/* JADX INFO: loaded from: classes38.dex */
public final class r {
    public r() {
    }

    public static SearchResourceInfo a(ResourceMeta r100) {
        String r101 = null;
        if (r100 == null) goto L13;
        SearchResourceInfo r102 = new SearchResourceInfo();
        r102.setMessageRelatedInfo(r100.message_related_info);
        r102.setResourceContent(r100.resource_content);
        r102.setResourceType(r100.resource_type);
        r102.setDestroyed(r100.is_destroyed.booleanValue());
        MessageRelatedInfo r103 = r100.message_related_info;
        if (r103 == null) goto L7;
        String r104 = r103.from_id;
    L8:
        r102.setFromId(r104);
        MessageRelatedInfo r105 = r100.message_related_info;
        if (r105 == null) goto L11;
        r101 = r105.from_tenant_id;
    L11:
        r102.setFromTenantId(r101);
        r102.setSceneId((int) r100.scene_id.longValue());
        return r102;
    L7:
        r104 = null;
        goto L8
    L13:
        return null;
    }
}
