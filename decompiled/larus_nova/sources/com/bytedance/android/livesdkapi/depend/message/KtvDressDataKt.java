package com.bytedance.android.livesdkapi.depend.message;

import android.text.TextUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\u001a\n\u0010\u0000\u001a\u00020\u0001*\u00020\u0002¨\u0006\u0003"}, d2 = {"isAvailableMidiSkin", "", "Lcom/bytedance/android/livesdkapi/depend/message/MidiSkinDressInfo;", "live-model-api_saasRelease"}, k = 2, mv = {1, 5, 1})
public final class KtvDressDataKt {
    public static final boolean isAvailableMidiSkin(MidiSkinDressInfo r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$isAvailableMidiSkin");
        if (TextUtils.isEmpty(r100.getDressId()) == false) goto L5;
    L7:
        return false;
    L5:
        if ((!Intrinsics.areEqual(r100.getDressId(), "0")) == false) goto L7;
        return true;
    }
}
