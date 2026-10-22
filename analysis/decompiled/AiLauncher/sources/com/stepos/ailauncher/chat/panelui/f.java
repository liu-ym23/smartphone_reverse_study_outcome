package com.stepos.ailauncher.chat.panelui;

import android.view.View;
import android.view.WindowManager;
import com.autonavi.aps.amapapi.config.Const;
import h8.C4148a;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.Result;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\r\u001a\u00020\nH\u0016¢\u0006\u0004\b\r\u0010\fR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u000eR\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u000fR\u0014\u0010\u0007\u001a\u00020\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\u0010R\u0016\u0010\u0012\u001a\u00020\u00118\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0015\u001a\u00020\u00148\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0016\u0010\u0017\u001a\u00020\u00118\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0017\u0010\u0013R\u0016\u0010\u0018\u001a\u00020\n8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019¨\u0006\u001a"}, d2 = {"Lcom/stepos/ailauncher/chat/panelui/f;", "Lcom/stepos/ailauncher/chat/panelui/t;", "Landroid/view/WindowManager;", "windowManager", "Landroid/view/View;", "view", "Landroid/view/WindowManager$LayoutParams;", "layoutParams", "<init>", "(Landroid/view/WindowManager;Landroid/view/View;Landroid/view/WindowManager$LayoutParams;)V", "", Const.INTENT_KEY_APIKEY, "()Z", "resume", "Landroid/view/WindowManager;", "Landroid/view/View;", "Landroid/view/WindowManager$LayoutParams;", "", "savedFlags", "I", "", "savedAlpha", "F", "savedVisibility", "suspended", "Z", "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class f implements t {
    private final WindowManager.LayoutParams layoutParams;
    private float savedAlpha;
    private int savedFlags;
    private int savedVisibility;
    private boolean suspended;
    private final View view;
    private final WindowManager windowManager;

    public f(WindowManager windowManager, View view, WindowManager.LayoutParams layoutParams) {
        kotlin.jvm.internal.p.i(windowManager, "windowManager");
        kotlin.jvm.internal.p.i(view, "view");
        kotlin.jvm.internal.p.i(layoutParams, "layoutParams");
        this.windowManager = windowManager;
        this.view = view;
        this.layoutParams = layoutParams;
        this.savedAlpha = 1.0f;
    }

    @Override // com.stepos.ailauncher.chat.panelui.t
    public boolean a() {
        Object objB;
        if (!this.view.isAttachedToWindow()) {
            return false;
        }
        if (this.suspended) {
            return true;
        }
        try {
            Result.Companion companion = Result.INSTANCE;
            WindowManager.LayoutParams layoutParams = this.layoutParams;
            this.savedFlags = layoutParams.flags;
            this.savedAlpha = layoutParams.alpha;
            this.savedVisibility = this.view.getVisibility();
            WindowManager.LayoutParams layoutParams2 = this.layoutParams;
            layoutParams2.flags |= 24;
            layoutParams2.alpha = 0.0f;
            this.view.setVisibility(4);
            this.windowManager.updateViewLayout(this.view, this.layoutParams);
            this.suspended = true;
            objB = Result.b(Boolean.TRUE);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objB = Result.b(C4849c.a(th));
        }
        Throwable thE = Result.e(objB);
        if (thE != null) {
            C4148a.t("PanelLayerVisibility", "overlay suspend failed", thE, false, 8, null);
        }
        Boolean bool = Boolean.FALSE;
        if (Result.g(objB)) {
            objB = bool;
        }
        return ((Boolean) objB).booleanValue();
    }

    @Override // com.stepos.ailauncher.chat.panelui.t
    public boolean resume() {
        Object objB;
        if (!this.view.isAttachedToWindow()) {
            return false;
        }
        if (!this.suspended) {
            return true;
        }
        try {
            Result.Companion companion = Result.INSTANCE;
            WindowManager.LayoutParams layoutParams = this.layoutParams;
            layoutParams.flags = this.savedFlags;
            layoutParams.alpha = this.savedAlpha;
            this.view.setVisibility(this.savedVisibility);
            this.windowManager.updateViewLayout(this.view, this.layoutParams);
            this.suspended = false;
            objB = Result.b(Boolean.TRUE);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objB = Result.b(C4849c.a(th));
        }
        Throwable thE = Result.e(objB);
        if (thE != null) {
            C4148a.t("PanelLayerVisibility", "overlay resume failed", thE, false, 8, null);
        }
        Boolean bool = Boolean.FALSE;
        if (Result.g(objB)) {
            objB = bool;
        }
        return ((Boolean) objB).booleanValue();
    }
}
