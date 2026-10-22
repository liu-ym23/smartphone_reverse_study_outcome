package com.bytedance.android.gamecp.base.gamedetail;

import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "location", "Lcom/bytedance/android/gamecp/base/gamedetail/AudienceReverseUnsupportBtnConfig$Location;", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 4, 3})
final class AudienceReverseUnsupportBtnConfig$BtnUIStyleV4$2 extends Lambda implements Function1<AudienceReverseUnsupportBtnConfig.Location, Float> {
    public static final AudienceReverseUnsupportBtnConfig$BtnUIStyleV4$2 INSTANCE = null;

    static {
        INSTANCE = new AudienceReverseUnsupportBtnConfig$BtnUIStyleV4$2();
    }

    public AudienceReverseUnsupportBtnConfig$BtnUIStyleV4$2() {
        super(1);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final float invoke2(AudienceReverseUnsupportBtnConfig.Location r100) {
        Intrinsics.checkNotNullParameter(r100, "location");
        if (q.f51653b[r100.ordinal()] == 1) goto L5;
        return 0.0f;
    L5:
        return 0.5f;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Float invoke(AudienceReverseUnsupportBtnConfig.Location r100) {
        return Float.valueOf(invoke2(r100));
    }
}
