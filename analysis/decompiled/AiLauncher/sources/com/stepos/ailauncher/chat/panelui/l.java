package com.stepos.ailauncher.chat.panelui;

import android.os.Handler;
import android.os.Looper;
import com.autonavi.aps.amapapi.config.Const;
import h8.C4148a;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\r\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0003J\u0017\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\f\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\f\u0010\rR\u0016\u0010\u000f\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010¨\u0006\u0011"}, d2 = {"Lcom/stepos/ailauncher/chat/panelui/l;", "Lcom/stepos/agentframework/chatui/panelui/d;", "<init>", "()V", "LY8/t;", "e", "Lcom/stepos/agentframework/chatui/panelui/b;", "handle", Const.INTENT_KEY_APIKEY, "(Lcom/stepos/agentframework/chatui/panelui/b;)V", "", "layerId", Const.INTENT_KEY_PKGNAME, "(Ljava/lang/String;)V", "", "installed", "Z", "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class l implements com.stepos.agentframework.chatui.panelui.d {
    public static final l INSTANCE = new l();
    private static volatile boolean installed;

    public static final void f(String str) {
        INSTANCE.b(str);
    }

    public static final void g(com.stepos.agentframework.chatui.panelui.b bVar) {
        INSTANCE.a(bVar);
    }

    @Override // com.stepos.agentframework.chatui.panelui.d
    public void a(final com.stepos.agentframework.chatui.panelui.b handle) {
        kotlin.jvm.internal.p.i(handle, "handle");
        if (kotlin.jvm.internal.p.d(Looper.myLooper(), Looper.getMainLooper())) {
            s.INSTANCE.m(new a(handle));
        } else {
            new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.stepos.ailauncher.chat.panelui.k
                @Override // java.lang.Runnable
                public final void run() {
                    l.g(handle);
                }
            });
        }
    }

    @Override // com.stepos.agentframework.chatui.panelui.d
    public void b(final String layerId) {
        kotlin.jvm.internal.p.i(layerId, "layerId");
        if (kotlin.jvm.internal.p.d(Looper.myLooper(), Looper.getMainLooper())) {
            s.INSTANCE.s(layerId);
        } else {
            new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.stepos.ailauncher.chat.panelui.j
                @Override // java.lang.Runnable
                public final void run() {
                    l.f(layerId);
                }
            });
        }
    }

    public final void e() {
        if (installed) {
            return;
        }
        installed = true;
        com.stepos.agentframework.chatui.panelui.c.INSTANCE.c(this);
        C4148a.k("PanelLayerHome", "PanelDialogHomeBridge host installed", false, 4, null);
    }
}
