package com.byted.mgl.merge.service.api.imageupload;

import com.bytedance.bdp.bdpbase.service.IBdpService;
import java.io.File;
import java.util.Map;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J.\u0010\u0002\u001a\u00020\u00032\u0014\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u00052\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH&¨\u0006\f"}, d2 = {"Lcom/byted/mgl/merge/service/api/imageupload/BdpAppImageUploadService;", "Lcom/bytedance/bdp/bdpbase/service/IBdpService;", "uploadImageByImageX", "", "params", "", "", "", "picFile", "Ljava/io/File;", "callback", "Lcom/byted/mgl/merge/service/api/imageupload/BdpHostImageXUploadListener;", "bdp-service-api_release"}, k = 1, mv = {1, 1, 18})
public interface BdpAppImageUploadService extends IBdpService {
    void uploadImageByImageX(Map<String, ? extends Object> r100, File r101, BdpHostImageXUploadListener r102);
}
