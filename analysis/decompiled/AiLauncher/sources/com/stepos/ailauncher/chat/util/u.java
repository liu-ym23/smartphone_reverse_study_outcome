package com.stepos.ailauncher.chat.util;

import com.autonavi.aps.amapapi.config.Const;
import com.stepos.ailauncher.sheet.SheetSettleState;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\"\u0018\u0010\u0004\u001a\u00020\u0001*\u00020\u00008@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Lcom/stepos/ailauncher/sheet/SheetSettleState;", "", Const.INTENT_KEY_APIKEY, "(Lcom/stepos/ailauncher/sheet/SheetSettleState;)Z", "isSheetCollapsed", "chat_release"}, k = 2, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class u {
    public static final boolean a(SheetSettleState sheetSettleState) {
        kotlin.jvm.internal.p.i(sheetSettleState, "<this>");
        return sheetSettleState == SheetSettleState.HALF || sheetSettleState == SheetSettleState.MINIFY;
    }
}
