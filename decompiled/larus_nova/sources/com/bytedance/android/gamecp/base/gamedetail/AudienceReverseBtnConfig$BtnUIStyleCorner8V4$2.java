package com.bytedance.android.gamecp.base.gamedetail;

import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00012\u0006\u0010\u0003\u001a\u00020\u0004H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "Lkotlin/Pair;", "", "state", "Lcom/bytedance/android/gamecp/base/gamedetail/AudienceReverseBtnConfig$State;", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 4, 3})
final class AudienceReverseBtnConfig$BtnUIStyleCorner8V4$2 extends Lambda implements Function1<AudienceReverseBtnConfig.State, Pair<? extends Integer, ? extends Integer>> {
    public static final AudienceReverseBtnConfig$BtnUIStyleCorner8V4$2 INSTANCE = null;

    static {
        INSTANCE = new AudienceReverseBtnConfig$BtnUIStyleCorner8V4$2();
    }

    public AudienceReverseBtnConfig$BtnUIStyleCorner8V4$2() {
        super(1);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Pair<Integer, Integer> invoke2(AudienceReverseBtnConfig.State r100) {
        Intrinsics.checkNotNullParameter(r100, "state");
        if (j.f51604b[r100.ordinal()] == 1) goto L6;
        return null;
    L6:
        return new Pair(Integer.valueOf(ColorProtector.parseColor("#FF161823")), Integer.valueOf(ColorProtector.parseColor("#57FFFFFF")));
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Pair<? extends Integer, ? extends Integer> invoke(AudienceReverseBtnConfig.State r100) {
        return invoke2(r100);
    }
}
