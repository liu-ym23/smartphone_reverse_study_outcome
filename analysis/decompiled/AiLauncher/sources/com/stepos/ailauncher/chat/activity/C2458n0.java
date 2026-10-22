package com.stepos.ailauncher.chat.activity;

import android.content.Context;
import android.content.ContextWrapper;
import com.autonavi.aps.amapapi.config.Const;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0001*\u00020\u0000H\u0000¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Landroid/content/Context;", "Lcom/stepos/ailauncher/chat/activity/ChatActivity;", Const.INTENT_KEY_APIKEY, "(Landroid/content/Context;)Lcom/stepos/ailauncher/chat/activity/ChatActivity;", "chat_release"}, k = 2, mv = {2, 2, 0}, xi = 48)
/* renamed from: com.stepos.ailauncher.chat.activity.n0, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C2458n0 {
    public static final ChatActivity a(Context context) {
        kotlin.jvm.internal.p.i(context, "<this>");
        while (context instanceof ContextWrapper) {
            if (context instanceof ChatActivity) {
                return (ChatActivity) context;
            }
            context = ((ContextWrapper) context).getBaseContext();
        }
        return null;
    }
}
