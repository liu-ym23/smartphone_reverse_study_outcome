package com.bytedance.android.live.liveinteract.multianchor.model;

import android.text.TextUtils;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
public final class h {
    public static final LinkmicPositionItem a(LinkmicPositionItem r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$copy");
        LinkmicPositionItem.Companion.getClass();
        LinkmicPositionItem r101 = (LinkmicPositionItem) vh7.f.c(LinkmicPositionItem.class);
        r101.setPosition(r100.getPosition());
        r101.setStatus(r100.getStatus());
        r101.setActiveName(r100.getActiveName());
        r101.setVerifyStatus(r100.getVerifyStatus());
        r101.setPositionType(r100.getPositionType());
        return r101;
    }

    public static final boolean b(LinkmicPositionItem r100, Object r101) {
        Intrinsics.checkNotNullParameter(r100, "$this$isEquals");
        if (r100 != r101) goto L6;
        return true;
    L6:
        if (r101 != null) goto L8;
    L23:
        return false;
    L8:
        if ((!Intrinsics.areEqual(r100.getClass(), r101.getClass())) == true) goto L23;
        LinkmicPositionItem r102 = (LinkmicPositionItem) r101;
        if (r100.getPosition() == r102.getPosition()) goto L13;
    L21:
        return false;
    L13:
        if (r100.getStatus() != r102.getStatus()) goto L21;
        if (r100.getVerifyStatus() != r102.getVerifyStatus()) goto L21;
        if (r100.getPositionType() != r102.getPositionType()) goto L21;
        if (TextUtils.equals(r100.getActiveName(), r102.getActiveName()) == false) goto L21;
        return true;
    }
}
