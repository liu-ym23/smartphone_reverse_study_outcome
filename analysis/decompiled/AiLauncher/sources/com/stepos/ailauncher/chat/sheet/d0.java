package com.stepos.ailauncher.chat.sheet;

import com.autonavi.aps.amapapi.config.Const;
import com.stepos.ailauncher.chat.activity.ChatActivity;
import com.stepos.ailauncher.chat.activity.ChatScene;
import h8.C4148a;
import java.lang.ref.WeakReference;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.Result;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\u0007\u0010\bJ\u0015\u0010\u000b\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\u000b\u0010\fJ\u0015\u0010\r\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\r\u0010\fJ\u0011\u0010\u000e\u001a\u0004\u0018\u00010\tH\u0002¢\u0006\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0010\u001a\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u001e\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\u00128\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014¨\u0006\u0015"}, d2 = {"Lcom/stepos/ailauncher/chat/sheet/d0;", "", "<init>", "()V", "", "reason", "LY8/t;", "c", "(Ljava/lang/String;)V", "Lcom/stepos/ailauncher/chat/activity/ChatActivity;", "activity", Const.INTENT_KEY_APIKEY, "(Lcom/stepos/ailauncher/chat/activity/ChatActivity;)V", Const.INTENT_KEY_PKGNAME, Const.INTENT_KEY_UMID, "()Lcom/stepos/ailauncher/chat/activity/ChatActivity;", "TAG", "Ljava/lang/String;", "Ljava/lang/ref/WeakReference;", "overlayRef", "Ljava/lang/ref/WeakReference;", "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class d0 {
    public static final d0 INSTANCE = new d0();
    private static final String TAG = "HomeOverlayChat";
    private static volatile WeakReference<ChatActivity> overlayRef;

    public static final void c(String reason) {
        kotlin.jvm.internal.p.i(reason, "reason");
        ChatActivity chatActivityD = INSTANCE.d();
        if (chatActivityD == null) {
            return;
        }
        ChatScene chatSceneA = ChatScene.INSTANCE.a(chatActivityD.getIntent());
        C4148a.k(TAG, "finishLeftoverForBoard reason=" + reason + " scene=" + chatSceneA + " taskId=" + chatActivityD.getTaskId(), false, 4, null);
        if (chatSceneA == ChatScene.HOME_RESIDENT) {
            try {
                Result.Companion companion = Result.INSTANCE;
                chatActivityD.finishAndRemoveTask();
                Result.b(Y8.t.f7040a);
                return;
            } catch (Throwable th) {
                Result.Companion companion2 = Result.INSTANCE;
                Result.b(C4849c.a(th));
                return;
            }
        }
        try {
            Result.Companion companion3 = Result.INSTANCE;
            chatActivityD.finish();
            Result.b(Y8.t.f7040a);
        } catch (Throwable th2) {
            Result.Companion companion4 = Result.INSTANCE;
            Result.b(C4849c.a(th2));
        }
    }

    public final void a(ChatActivity activity) {
        kotlin.jvm.internal.p.i(activity, "activity");
        overlayRef = new WeakReference<>(activity);
        C4148a.d(TAG, "attach home-overlay chat", false, 4, null);
    }

    public final void b(ChatActivity activity) {
        kotlin.jvm.internal.p.i(activity, "activity");
        WeakReference<ChatActivity> weakReference = overlayRef;
        if ((weakReference != null ? weakReference.get() : null) == activity) {
            overlayRef = null;
            C4148a.d(TAG, "detach home-overlay chat", false, 4, null);
        }
    }

    public final ChatActivity d() {
        ChatActivity chatActivity;
        WeakReference<ChatActivity> weakReference = overlayRef;
        if (weakReference == null || (chatActivity = weakReference.get()) == null) {
            return null;
        }
        if (chatActivity.isDestroyed()) {
            overlayRef = null;
            return null;
        }
        if (chatActivity.isFinishing()) {
            return null;
        }
        return chatActivity;
    }
}
