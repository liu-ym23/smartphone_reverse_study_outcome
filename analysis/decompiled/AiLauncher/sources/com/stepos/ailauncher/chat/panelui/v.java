package com.stepos.ailauncher.chat.panelui;

import Z8.C1173v;
import android.view.View;
import android.view.Window;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.ailauncher.chat.activity.ChatActivity;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0019\u0010\u0006\u001a\u0004\u0018\u00010\u00012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u001d\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00010\b2\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lcom/stepos/ailauncher/chat/panelui/v;", "", "<init>", "()V", "Lcom/stepos/ailauncher/chat/activity/ChatActivity;", "activity", Const.INTENT_KEY_PKGNAME, "(Lcom/stepos/ailauncher/chat/activity/ChatActivity;)Ljava/lang/Object;", "", Const.INTENT_KEY_APIKEY, "(Lcom/stepos/ailauncher/chat/activity/ChatActivity;)Ljava/util/List;", "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class v {
    public static final v INSTANCE = new v();

    public final List<Object> a(ChatActivity activity) {
        View decorView;
        View rootView;
        if (activity == null || activity.isFinishing() || activity.isDestroyed()) {
            return C1173v.m();
        }
        ArrayList arrayList = new ArrayList(2);
        arrayList.add(activity);
        Window window = activity.getWindow();
        if (window != null && (decorView = window.getDecorView()) != null && (rootView = decorView.getRootView()) != null) {
            arrayList.add(rootView);
        }
        return arrayList;
    }

    public final Object b(ChatActivity activity) {
        View decorView;
        View rootView;
        if (activity == null || activity.isFinishing() || activity.isDestroyed()) {
            return null;
        }
        Window window = activity.getWindow();
        return (window == null || (decorView = window.getDecorView()) == null || (rootView = decorView.getRootView()) == null) ? activity : rootView;
    }
}
