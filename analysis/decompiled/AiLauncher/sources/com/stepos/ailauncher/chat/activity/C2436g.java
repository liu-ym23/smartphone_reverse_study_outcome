package com.stepos.ailauncher.chat.activity;

import com.autonavi.aps.amapapi.config.Const;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u001f\u0010\u000b\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\n\u001a\u00020\b¢\u0006\u0004\b\u000b\u0010\f¨\u0006\r"}, d2 = {"Lcom/stepos/ailauncher/chat/activity/g;", "", "<init>", "()V", "", "currentMode", Const.INTENT_KEY_PKGNAME, "(I)I", "", "authCheckPassed", "pendingAgentConfigOnly", Const.INTENT_KEY_APIKEY, "(ZZ)Z", "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* renamed from: com.stepos.ailauncher.chat.activity.g, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C2436g {
    public static final C2436g INSTANCE = new C2436g();

    public final boolean a(boolean authCheckPassed, boolean pendingAgentConfigOnly) {
        return (authCheckPassed || pendingAgentConfigOnly) ? false : true;
    }

    public final int b(int currentMode) {
        return (currentMode & (-16)) | 3;
    }
}
