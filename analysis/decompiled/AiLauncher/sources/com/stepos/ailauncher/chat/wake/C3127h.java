package com.stepos.ailauncher.chat.wake;

import com.autonavi.aps.amapapi.config.Const;
import kotlin.Metadata;
import o6.C5009a;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\r\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0003J\r\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\r\u0010\n\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bR\u0014\u0010\r\u001a\u00020\f8\u0006X\u0086T¢\u0006\u0006\n\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"Lcom/stepos/ailauncher/chat/wake/h;", "", "<init>", "()V", "LY8/t;", "c", "", Const.INTENT_KEY_APIKEY, "()I", "", Const.INTENT_KEY_PKGNAME, "()Z", "", "KEY_ALL_TASK_ENTER_COUNT", "Ljava/lang/String;", "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* renamed from: com.stepos.ailauncher.chat.wake.h, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C3127h {
    public static final C3127h INSTANCE = new C3127h();
    public static final String KEY_ALL_TASK_ENTER_COUNT = "all_task_enter_count";

    public final int a() {
        return C5009a.k(C5009a.INSTANCE, KEY_ALL_TASK_ENTER_COUNT, 0, false, 4, null);
    }

    public final boolean b() {
        return a() > 0;
    }

    public final void c() {
        C5009a.B(C5009a.INSTANCE, KEY_ALL_TASK_ENTER_COUNT, a() + 1, false, 4, null);
        com.stepos.ailauncher.chat.trace.d.INSTANCE.b();
    }
}
