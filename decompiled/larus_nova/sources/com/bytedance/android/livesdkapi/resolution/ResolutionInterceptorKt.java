package com.bytedance.android.livesdkapi.resolution;

import com.bytedance.android.livesdkapi.depend.model.live.IBaseStreamUrl;
import com.bytedance.android.livesdkapi.depend.model.live.IQuality;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a\u0010\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0003¨\u0006\u0004"}, d2 = {"safeGetQualityList", "", "Lcom/bytedance/android/livesdkapi/depend/model/live/IQuality;", "Lcom/bytedance/android/livesdkapi/depend/model/live/IBaseStreamUrl;", "livesdkapi-middleware_saasRelease"}, k = 2, mv = {1, 4, 3})
public final class ResolutionInterceptorKt {
    public static final List<IQuality> safeGetQualityList(IBaseStreamUrl r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$safeGetQualityList");
        ArrayList r101 = new ArrayList();
        List<IQuality> r102 = r100.getQualityList();
        if (r102 != null) goto L6;
        r102 = CollectionsKt.emptyList();
    L6:
        r101.addAll(r102);
        return r101;
    }
}
