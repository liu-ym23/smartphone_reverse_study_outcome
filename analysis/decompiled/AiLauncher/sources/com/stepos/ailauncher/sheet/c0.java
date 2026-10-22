package com.stepos.ailauncher.sheet;

import com.autonavi.aps.amapapi.config.Const;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\u001a'\u0010\u0005\u001a\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u0000¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/stepos/ailauncher/sheet/SheetSettleState;", "currentState", "", "scaleEnterRunning", "enterTarget", Const.INTENT_KEY_APIKEY, "(Lcom/stepos/ailauncher/sheet/SheetSettleState;ZLcom/stepos/ailauncher/sheet/SheetSettleState;)Lcom/stepos/ailauncher/sheet/SheetSettleState;", "sheet_release"}, k = 2, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class c0 {
    public static final SheetSettleState a(SheetSettleState currentState, boolean z10, SheetSettleState sheetSettleState) {
        kotlin.jvm.internal.p.i(currentState, "currentState");
        return (currentState == SheetSettleState.HIDDEN && z10 && sheetSettleState != null) ? sheetSettleState : currentState;
    }
}
