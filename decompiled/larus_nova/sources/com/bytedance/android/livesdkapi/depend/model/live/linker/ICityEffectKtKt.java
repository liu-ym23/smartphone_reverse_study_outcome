package com.bytedance.android.livesdkapi.depend.model.live.linker;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\"P\u0010\u0004\u001a\u0016\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0001j\n\u0012\u0004\u0012\u00020\u0002\u0018\u0001`\u0003*\u00020\u00052\u001a\u0010\u0000\u001a\u0016\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0001j\n\u0012\u0004\u0012\u00020\u0002\u0018\u0001`\u00038F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"value", "", "", "Lcom/bytedance/revenue/platform/api/core/KmpList;", "showEffectUserIdListExt", "Lcom/bytedance/android/livesdkapi/depend/model/live/linker/ICityEffect;", "getShowEffectUserIdListExt", "(Lcom/bytedance/android/livesdkapi/depend/model/live/linker/ICityEffect;)Ljava/util/List;", "setShowEffectUserIdListExt", "(Lcom/bytedance/android/livesdkapi/depend/model/live/linker/ICityEffect;Ljava/util/List;)V", "live-model-api_saasRelease"}, k = 2, mv = {1, 5, 1})
public final class ICityEffectKtKt {
    public static final List<String> getShowEffectUserIdListExt(ICityEffect r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$showEffectUserIdListExt");
        return r100.getShowEffectUserIdList();
    }

    public static final void setShowEffectUserIdListExt(ICityEffect r100, List<String> r101) {
        Intrinsics.checkNotNullParameter(r100, "$this$showEffectUserIdListExt");
        r100.setShowEffectUserIdList(r101);
    }
}
