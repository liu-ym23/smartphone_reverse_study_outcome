package com.stepos.agentframework.chatui.panelui;

import Y8.t;
import android.view.WindowManager;
import android.widget.PopupWindow;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.jvm.internal.p;
import p9.InterfaceC5074l;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\r\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\r\u0010\t\u001a\u00020\u0006¢\u0006\u0004\b\t\u0010\bR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\nR\u0016\u0010\u000b\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0016\u0010\r\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\r\u0010\fR\u0016\u0010\u000e\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000e\u0010\fR\u0016\u0010\u0010\u001a\u00020\u000f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0013\u001a\u00020\u00128\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0016\u0010\u0015\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0015\u0010\f¨\u0006\u0016"}, d2 = {"Lcom/stepos/agentframework/chatui/panelui/i;", "", "Landroid/widget/PopupWindow;", "popup", "<init>", "(Landroid/widget/PopupWindow;)V", "", "e", "()Z", "c", "Landroid/widget/PopupWindow;", "focusable", "Z", "touchable", "outsideTouchable", "", "savedFlags", "I", "", "savedAlpha", "F", "suspended", "agentcore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class i {
    private boolean focusable;
    private boolean outsideTouchable;
    private final PopupWindow popup;
    private float savedAlpha;
    private int savedFlags;
    private boolean suspended;
    private boolean touchable;

    public i(PopupWindow popup) {
        p.i(popup, "popup");
        this.popup = popup;
        this.savedAlpha = 1.0f;
    }

    public static final t d(i iVar, WindowManager.LayoutParams lp) {
        p.i(lp, "lp");
        lp.flags = iVar.savedFlags;
        lp.alpha = iVar.savedAlpha;
        return t.f7040a;
    }

    public static final t f(i iVar, WindowManager.LayoutParams lp) {
        p.i(lp, "lp");
        int i10 = lp.flags;
        iVar.savedFlags = i10;
        iVar.savedAlpha = lp.alpha;
        lp.flags = ((-262145) & i10) | 24;
        lp.alpha = 0.0f;
        return t.f7040a;
    }

    public final boolean c() {
        Object objB;
        if (!this.popup.isShowing()) {
            return false;
        }
        if (!this.suspended) {
            return true;
        }
        try {
            Result.Companion companion = Result.INSTANCE;
            this.popup.setFocusable(this.focusable);
            this.popup.setTouchable(this.touchable);
            this.popup.setOutsideTouchable(this.outsideTouchable);
            if (!e.b(this.popup, new InterfaceC5074l() { // from class: com.stepos.agentframework.chatui.panelui.h
                @Override // p9.InterfaceC5074l
                public final Object invoke(Object obj) {
                    return i.d(this.f22995a, (WindowManager.LayoutParams) obj);
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
        Boolean bool = Boolean.FALSE;
        if (Result.g(objB)) {
            objB = bool;
        }
        return ((Boolean) objB).booleanValue();
    }

    public final boolean e() {
        Object objB;
        if (!this.popup.isShowing()) {
            return false;
        }
        if (this.suspended) {
            return true;
        }
        try {
            Result.Companion companion = Result.INSTANCE;
            this.focusable = this.popup.isFocusable();
            this.touchable = this.popup.isTouchable();
            this.outsideTouchable = this.popup.isOutsideTouchable();
            this.popup.setFocusable(false);
            this.popup.setTouchable(false);
            this.popup.setOutsideTouchable(false);
            if (!e.b(this.popup, new InterfaceC5074l() { // from class: com.stepos.agentframework.chatui.panelui.g
                @Override // p9.InterfaceC5074l
                public final Object invoke(Object obj) {
                    return i.f(this.f22994a, (WindowManager.LayoutParams) obj);
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
        Boolean bool = Boolean.FALSE;
        if (Result.g(objB)) {
            objB = bool;
        }
        return ((Boolean) objB).booleanValue();
    }
}
