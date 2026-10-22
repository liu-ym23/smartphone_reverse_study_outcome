package com.byted.mgl.merge.service.api.imageupload;

import java.util.Map;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010$\n\u0000\bf\u0018\u00002\u00020\u0001J>\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u00072\u0018\b\u0002\u0010\t\u001a\u0012\u0012\u0004\u0012\u00020\u0007\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\nH&¨\u0006\u000b"}, d2 = {"Lcom/byted/mgl/merge/service/api/imageupload/BdpHostImageXUploadListener;", "", "onResult", "", "isSuccess", "", "imageTosKey", "", "extraMsg", "params", "", "bdp-service-api_release"}, k = 1, mv = {1, 1, 18})
public interface BdpHostImageXUploadListener {

    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 1, 18})
    public static final class DefaultImpls {
        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ void onResult$default(BdpHostImageXUploadListener r100, boolean r101, String r102, String r103, Map r104, int r105, Object r106) {
            if (r106 != null) goto L9;
            if ((r105 & 8) == 0) goto L6;
            r104 = null;
        L6:
            r100.onResult(r101, r102, r103, r104);
            return;
        L9:
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: onResult");
        }
    }

    void onResult(boolean r100, String r101, String r102, Map<String, ? extends Object> r103);
}
