package com.bytedance.android.livesdkapi.message;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u001a\n\u0010\b\u001a\u00020\u0001*\u00020\u0003\"*\u0010\u0002\u001a\u00020\u0001*\u0004\u0018\u00010\u00032\u0006\u0010\u0000\u001a\u00020\u00018F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\u0004\u0010\u0005\"\u0004\b\u0006\u0010\u0007¨\u0006\t"}, d2 = {"value", "", "needFilterDisplay", "Lcom/bytedance/android/livesdkapi/message/IPublicAreaCommon;", "getNeedFilterDisplay", "(Lcom/bytedance/android/livesdkapi/message/IPublicAreaCommon;)Z", "setNeedFilterDisplay", "(Lcom/bytedance/android/livesdkapi/message/IPublicAreaCommon;Z)V", "isFloatMessage", "live-model-api_saasRelease"}, k = 2, mv = {1, 5, 1})
public final class IPublicAreaCommonKt {
    public static final boolean getNeedFilterDisplay(IPublicAreaCommon r100) {
        if (r100 == null) goto L6;
        IPublicAreaCommonExtension r101 = (IPublicAreaCommonExtension) r100.castToOrNull(IPublicAreaCommonExtension.class);
        if (r101 == null) goto L6;
        return r101.getNeedFilterDisplay();
    L6:
        return false;
    }

    public static final boolean isFloatMessage(IPublicAreaCommon r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$isFloatMessage");
        BottomPinInfo r101 = r100.getBottomPinInfo();
        if (r101 == null) goto L5;
        long r102 = r101.getDuration();
    L7:
        if (r102 <= 0) goto L9;
        return true;
    L9:
        return false;
    L5:
        r102 = 0;
        goto L7
    }

    public static final void setNeedFilterDisplay(IPublicAreaCommon r100, boolean r101) {
        if (r100 == null) goto L7;
        IPublicAreaCommonExtension r102 = (IPublicAreaCommonExtension) r100.castToOrNull(IPublicAreaCommonExtension.class);
        if (r102 == null) goto L8;
        r102.setNeedFilterDisplay(r101);
        return;
    L8:
        return;
    }
}
