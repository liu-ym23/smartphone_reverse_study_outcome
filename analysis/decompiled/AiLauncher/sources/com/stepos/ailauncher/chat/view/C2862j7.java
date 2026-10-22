package com.stepos.ailauncher.chat.view;

import com.autonavi.aps.amapapi.config.Const;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0006\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J5\u0010\f\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\u0006¢\u0006\u0004\b\f\u0010\r¨\u0006\u000e"}, d2 = {"Lcom/stepos/ailauncher/chat/view/j7;", "", "<init>", "()V", "", "longClickHandled", "", "pointerCount", "", "dx", "dy", "touchSlop", Const.INTENT_KEY_APIKEY, "(ZIFFI)Z", "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* renamed from: com.stepos.ailauncher.chat.view.j7, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C2862j7 {
    public static final C2862j7 INSTANCE = new C2862j7();

    public final boolean a(boolean longClickHandled, int pointerCount, float dx, float dy, int touchSlop) {
        if (longClickHandled && pointerCount == 1) {
            float f10 = touchSlop;
            if ((dx * dx) + (dy * dy) <= f10 * f10) {
                return true;
            }
        }
        return false;
    }
}
