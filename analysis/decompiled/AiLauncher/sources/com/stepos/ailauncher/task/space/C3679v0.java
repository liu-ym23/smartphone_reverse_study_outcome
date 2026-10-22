package com.stepos.ailauncher.task.space;

import com.autonavi.aps.amapapi.config.Const;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J-\u0010\n\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u0006¢\u0006\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/stepos/ailauncher/task/space/v0;", "", "<init>", "()V", "", "keyboardHeightPx", "", "panelShown", "onChatPage", "searchActive", Const.INTENT_KEY_APIKEY, "(IZZZ)Z", "task_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* renamed from: com.stepos.ailauncher.task.space.v0, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C3679v0 {
    public static final C3679v0 INSTANCE = new C3679v0();

    public final boolean a(int keyboardHeightPx, boolean panelShown, boolean onChatPage, boolean searchActive) {
        if (keyboardHeightPx <= 0 || !panelShown) {
            return false;
        }
        return onChatPage || searchActive;
    }
}
