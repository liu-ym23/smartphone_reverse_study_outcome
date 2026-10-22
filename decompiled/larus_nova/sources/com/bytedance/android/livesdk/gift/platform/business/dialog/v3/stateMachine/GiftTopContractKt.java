package com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine;

import com.bytedance.android.anya.h;
import com.bytedance.android.anya.l0;
import com.bytedance.android.anya.r0;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\u001a\u0018\u0010\u0004\u001a\u00020\u0003*\b\u0012\u0004\u0012\u00020\u00010\u00002\u0006\u0010\u0002\u001a\u00020\u0001\u001a\u000e\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005¨\u0006\t"}, d2 = {"Lcom/bytedance/android/anya/l0;", "Lcom/bytedance/android/livesdk/gift/platform/business/dialog/v3/stateMachine/GiftTopViewState;", "state", "", "simpleStateString", "Lcom/bytedance/android/livesdk/gift/platform/business/dialog/v3/stateMachine/GiftTopViewState$Mode;", "mode", "", "isGroupMode", "livegift-impl_saasRelease"}, k = 2, mv = {1, 4, 3})
public final class GiftTopContractKt {
    public static final boolean isGroupMode(GiftTopViewState.Mode r100) {
        Intrinsics.checkNotNullParameter(r100, "mode");
        if (r100 != GiftTopViewState.Mode.Group) goto L5;
    L8:
        return true;
    L5:
        if (r100 == GiftTopViewState.Mode.GroupContainer) goto L8;
        return false;
    }

    public static final String simpleStateString(l0<GiftTopViewState> r100, GiftTopViewState r101) {
        Intrinsics.checkNotNullParameter(r100, "$this$simpleStateString");
        Intrinsics.checkNotNullParameter(r101, "state");
        StringBuilder r102 = new StringBuilder("GiftTopViewState{mode=");
        r0<GiftTopViewState, GiftTopViewState.Mode> r103 = r101.getMode();
        r100.getClass();
        r102.append((GiftTopViewState.Mode) h.b(r103));
        r102.append(",showDetail=");
        r102.append(((Boolean) h.b(r101.getShowDetail())).booleanValue());
        r102.append(",visible=");
        r102.append(((Boolean) h.b(r101.getVisibility())).booleanValue());
        r102.append('}');
        return r102.toString();
    }
}
