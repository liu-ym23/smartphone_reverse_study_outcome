package com.stepos.ailauncher.chat.view;

import com.autonavi.aps.amapapi.config.Const;
import kotlin.Metadata;
import kotlin.text.Regex;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/stepos/ailauncher/chat/view/F;", "", "<init>", "()V", "", "description", Const.INTENT_KEY_APIKEY, "(Ljava/lang/String;)Ljava/lang/String;", "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class F {
    public static final F INSTANCE = new F();

    public final String a(String description) {
        kotlin.jvm.internal.p.i(description, "description");
        return La.H.D1(new Regex("[\\s\\u00A0\\u3000]+").l(description, " ")).toString();
    }
}
