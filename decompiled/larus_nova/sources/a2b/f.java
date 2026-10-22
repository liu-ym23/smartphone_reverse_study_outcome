package a2b;

import com.bytedance.lark.pb.basic.v1.SyncDataStrategy;
import com.larksuite.framework.callback.IGetDataCallback;
import com.larksuite.framework.callback.UIGetDataCallback;
import com.ss.android.lark.chat.api.service.request.PullUrlPreviewRequest;
import com.ss.android.lark.chat.entity.preview.UrlPreViewEntries;
import com.ss.android.lark.chat.preview.entity.UrlPreviewResponse;
import com.ss.android.lark.export.entity.UrlCardPreviewEntity;
import com.ss.android.lark.export.entity.preview.UrlInlinePreviewEntity;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes35.dex */
public interface f {
    void Fa(PullUrlPreviewRequest r100);

    void ba(b r100, IGetDataCallback<b> r101);

    void getUrlInlineFromContent(String r100, IGetDataCallback<UrlInlinePreviewEntity> r101);

    void lc(List<String> r100, Map<String, ? extends Map<String, UrlCardPreviewEntity>> r101);

    void r4(List<String> r100, List<String> r101, SyncDataStrategy r102, UrlPreViewEntries.UrlPreViewSourceType r103, List<Long> r104, UIGetDataCallback<UrlPreviewResponse> r105);
}
