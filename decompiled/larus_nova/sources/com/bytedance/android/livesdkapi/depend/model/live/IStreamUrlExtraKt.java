package com.bytedance.android.livesdkapi.depend.model.live;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\u001a\n\u0010\u0007\u001a\u00020\b*\u00020\u0002\"\u0015\u0010\u0000\u001a\u00020\u0001*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004\"\u0015\u0010\u0005\u001a\u00020\u0001*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0004¨\u0006\t"}, d2 = {"heightFlex", "", "Lcom/bytedance/android/livesdkapi/depend/model/live/IStreamUrlExtra;", "getHeightFlex", "(Lcom/bytedance/android/livesdkapi/depend/model/live/IStreamUrlExtra;)J", "widthFlex", "getWidthFlex", "anchorInteractProfile", "", "live-model-api_saasRelease"}, k = 2, mv = {1, 5, 1})
public final class IStreamUrlExtraKt {
    public static final int anchorInteractProfile(IStreamUrlExtra r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$anchorInteractProfile");
        return r100.getAnchorInteractProfile();
    }

    public static final long getHeightFlex(IStreamUrlExtra r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$heightFlex");
        return r100.getHeightFlex();
    }

    public static final long getWidthFlex(IStreamUrlExtra r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$widthFlex");
        return r100.getWidthFlex();
    }
}
