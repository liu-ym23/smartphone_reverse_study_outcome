package com.bytedance.android.livesdk.gift.platform.core.utils.recorder;

import com.bytedance.android.live.base.model.message.m0;
import com.bytedance.android.livesdk.gift.model.h1;
import com.bytedance.android.livesdk.message.model.o7;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class f {
    public static final String a(o7 r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$toRecordString");
        StringBuilder r101 = new StringBuilder("mId:");
        r101.append(r100.getMessageId());
        r101.append(",gId:");
        r101.append(r100.getGiftId());
        r101.append(",rEd:");
        r101.append(r100.getRepeatEnd());
        r101.append(",ban");
        r101.append(r100.getBannedDisplayEffects());
        r101.append(",gNm:");
        h1 r102 = r100.getGift();
        if (r102 == null) goto L6;
        String r103 = r102.getName();
        if (r103 == null) goto L6;
    L10:
        r101.append(r103);
        return r101.toString();
    L6:
        m0 r104 = r100.getCommonData();
        if (r104 == null) goto L9;
        r103 = r104.getDescribe();
        goto L10
    L9:
        r103 = null;
        goto L10
    }
}
