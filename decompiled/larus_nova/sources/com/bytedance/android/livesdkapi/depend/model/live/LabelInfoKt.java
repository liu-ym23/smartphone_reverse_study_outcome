package com.bytedance.android.livesdkapi.depend.model.live;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\n\u0010\u0000\u001a\u00020\u0001*\u00020\u0002\u001a\n\u0010\u0003\u001a\u00020\u0001*\u00020\u0002¨\u0006\u0004"}, d2 = {"isBoldText", "", "Lcom/bytedance/android/livesdkapi/depend/model/live/SpliceLabel;", "isItalicText", "livebase-model_saasRelease"}, k = 2, mv = {1, 4, 3})
public final class LabelInfoKt {
    public static final boolean isBoldText(SpliceLabel r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$isBoldText");
        if (r100.getBold() != 2) goto L5;
        return true;
    L5:
        return false;
    }

    public static final boolean isItalicText(SpliceLabel r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$isItalicText");
        if (r100.getItalic() != 2) goto L5;
        return true;
    L5:
        return false;
    }
}
