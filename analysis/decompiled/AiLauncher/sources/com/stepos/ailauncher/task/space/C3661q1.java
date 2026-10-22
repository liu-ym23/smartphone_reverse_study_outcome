package com.stepos.ailauncher.task.space;

import com.autonavi.aps.amapapi.config.Const;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lcom/stepos/ailauncher/task/space/q1;", "", "<init>", "()V", "", "keyboardHeightPx", "Lcom/stepos/ailauncher/task/space/ScreenOffInputAction;", Const.INTENT_KEY_APIKEY, "(I)Lcom/stepos/ailauncher/task/space/ScreenOffInputAction;", "task_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* renamed from: com.stepos.ailauncher.task.space.q1, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C3661q1 {
    public static final C3661q1 INSTANCE = new C3661q1();

    public final ScreenOffInputAction a(int keyboardHeightPx) {
        return keyboardHeightPx > 0 ? ScreenOffInputAction.DISMISS_IME_PRESERVING_DRAFT_LAYOUT : ScreenOffInputAction.NONE;
    }
}
