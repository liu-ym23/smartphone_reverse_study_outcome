package com.stepos.ailauncher.chat.activity;

import com.autonavi.aps.amapapi.config.Const;
import com.stepos.ailauncher.sheet.SheetHeightMode;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u000e\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a'\u0010\u0005\u001a\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0000H\u0000¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"", "isLockScreen", "Lcom/stepos/ailauncher/sheet/SheetHeightMode;", "heightMode", "opaqueScrimEnabled", Const.INTENT_KEY_APIKEY, "(ZLcom/stepos/ailauncher/sheet/SheetHeightMode;Z)Z", "chat_release"}, k = 2, mv = {2, 2, 0}, xi = 48)
/* renamed from: com.stepos.ailauncher.chat.activity.e1, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C2432e1 {
    public static final boolean a(boolean z10, SheetHeightMode heightMode, boolean z11) {
        kotlin.jvm.internal.p.i(heightMode, "heightMode");
        return z10 && heightMode == SheetHeightMode.FULL_9 && !z11;
    }
}
