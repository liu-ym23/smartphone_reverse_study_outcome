package com.stepos.ailauncher.chat.panelui;

import android.view.WindowManager;
import android.widget.PopupWindow;
import com.autonavi.aps.amapapi.config.Const;
import h8.C4148a;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.Result;
import p9.InterfaceC5074l;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\bR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\nR\u0016\u0010\u000b\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0016\u0010\r\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\r\u0010\fR\u0016\u0010\u000e\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000e\u0010\fR\u0016\u0010\u0010\u001a\u00020\u000f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0013\u001a\u00020\u00128\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0016\u0010\u0015\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0015\u0010\f¨\u0006\u0016"}, d2 = {"Lcom/stepos/ailauncher/chat/panelui/y;", "Lcom/stepos/ailauncher/chat/panelui/t;", "Landroid/widget/PopupWindow;", "popup", "<init>", "(Landroid/widget/PopupWindow;)V", "", Const.INTENT_KEY_APIKEY, "()Z", "resume", "Landroid/widget/PopupWindow;", "savedFocusable", "Z", "savedTouchable", "savedOutsideTouchable", "", "savedFlags", "I", "", "savedAlpha", "F", "suspended", "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class y implements t {
    private final PopupWindow popup;
    private float savedAlpha;
    private int savedFlags;
    private boolean savedFocusable;
    private boolean savedOutsideTouchable;
    private boolean savedTouchable;
    private boolean suspended;

    public y(PopupWindow popup) {
        kotlin.jvm.internal.p.i(popup, "popup");
        this.popup = popup;
        this.savedAlpha = 1.0f;
    }

    public static final Y8.t d(y yVar, WindowManager.LayoutParams lp) {
        kotlin.jvm.internal.p.i(lp, "lp");
        lp.flags = yVar.savedFlags;
        lp.alpha = yVar.savedAlpha;
        return Y8.t.f7040a;
    }

    public static final Y8.t e(y yVar, WindowManager.LayoutParams lp) {
        kotlin.jvm.internal.p.i(lp, "lp");
        int i10 = lp.flags;
        yVar.savedFlags = i10;
        yVar.savedAlpha = lp.alpha;
        lp.flags = ((-262145) & i10) | 24;
        lp.alpha = 0.0f;
        return Y8.t.f7040a;
    }

    @Override // com.stepos.ailauncher.chat.panelui.t
    public boolean a() {
        Object objB;
        if (!this.popup.isShowing()) {
            return false;
        }
        if (this.suspended) {
            return true;
        }
        try {
            Result.Companion companion = Result.INSTANCE;
            this.savedFocusable = this.popup.isFocusable();
            this.savedTouchable = this.popup.isTouchable();
            this.savedOutsideTouchable = this.popup.isOutsideTouchable();
            this.popup.setFocusable(false);
            this.popup.setTouchable(false);
            this.popup.setOutsideTouchable(false);
            if (!u.b(this.popup, new InterfaceC5074l() { // from class: com.stepos.ailauncher.chat.panelui.x
                @Override // p9.InterfaceC5074l
                public final Object invoke(Object obj) {
                    return y.e(this.f25626a, (WindowManager.LayoutParams) obj);
                }
            })) {
                this.popup.update();
            }
            this.suspended = true;
            objB = Result.b(Boolean.TRUE);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objB = Result.b(C4849c.a(th));
        }
        Throwable thE = Result.e(objB);
        if (thE != null) {
            C4148a.t("PanelLayerVisibility", "popup suspend failed", thE, false, 8, null);
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
        if (!this.popup.isShowing()) {
            return false;
        }
        if (!this.suspended) {
            return true;
        }
        try {
            Result.Companion companion = Result.INSTANCE;
            this.popup.setFocusable(this.savedFocusable);
            this.popup.setTouchable(this.savedTouchable);
            this.popup.setOutsideTouchable(this.savedOutsideTouchable);
            if (!u.b(this.popup, new InterfaceC5074l() { // from class: com.stepos.ailauncher.chat.panelui.w
                @Override // p9.InterfaceC5074l
                public final Object invoke(Object obj) {
                    return y.d(this.f25625a, (WindowManager.LayoutParams) obj);
                }
            })) {
                this.popup.update();
            }
            this.suspended = false;
            objB = Result.b(Boolean.TRUE);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objB = Result.b(C4849c.a(th));
        }
        Throwable thE = Result.e(objB);
        if (thE != null) {
            C4148a.t("PanelLayerVisibility", "popup resume failed", thE, false, 8, null);
        }
        Boolean bool = Boolean.FALSE;
        if (Result.g(objB)) {
            objB = bool;
        }
        return ((Boolean) objB).booleanValue();
    }
}
