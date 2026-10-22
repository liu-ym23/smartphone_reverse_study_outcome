package com.stepos.ailauncher.chat.view;

import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.PopupWindow;
import com.autonavi.aps.amapapi.config.Const;
import io.ktor.http.LinkHeader;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.Result;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0015\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0000\u0018\u00002\u00020\u0001B/\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0004\u0012\u0006\u0010\b\u001a\u00020\u0004¢\u0006\u0004\b\t\u0010\nJ\u0015\u0010\u000e\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\u000e\u0010\u000fJ\r\u0010\u0010\u001a\u00020\r¢\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0013\u001a\u00020\u0012H\u0016¢\u0006\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0015R\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u0016R\u0014\u0010\u0006\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010\u0016R\u0014\u0010\u0007\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\u0016R\u0014\u0010\b\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\b\u0010\u0016R\u0014\u0010\u0018\u001a\u00020\u00178\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0018\u0010\f\u001a\u0004\u0018\u00010\u000b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\f\u0010\u001aR\u0018\u0010\u001c\u001a\u0004\u0018\u00010\u001b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0016\u0010\u001e\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001e\u0010\u0016R\u0016\u0010\u001f\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001f\u0010\u0016¨\u0006 "}, d2 = {"Lcom/stepos/ailauncher/chat/view/E5;", "Landroid/view/ViewTreeObserver$OnPreDrawListener;", "Landroid/view/View;", LinkHeader.Parameters.Anchor, "", "basePopupX", "basePopupY", "baseAnchorRight", "baseAnchorBottom", "<init>", "(Landroid/view/View;IIII)V", "Landroid/widget/PopupWindow;", "popup", "LY8/t;", Const.INTENT_KEY_APIKEY, "(Landroid/widget/PopupWindow;)V", Const.INTENT_KEY_PKGNAME, "()V", "", "onPreDraw", "()Z", "Landroid/view/View;", "I", "", "anchorLoc", "[I", "Landroid/widget/PopupWindow;", "Landroid/view/ViewTreeObserver;", "observer", "Landroid/view/ViewTreeObserver;", "lastX", "lastY", "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class E5 implements ViewTreeObserver.OnPreDrawListener {
    private final View anchor;
    private final int[] anchorLoc;
    private final int baseAnchorBottom;
    private final int baseAnchorRight;
    private final int basePopupX;
    private final int basePopupY;
    private int lastX;
    private int lastY;
    private ViewTreeObserver observer;
    private PopupWindow popup;

    public E5(View anchor, int i10, int i11, int i12, int i13) {
        kotlin.jvm.internal.p.i(anchor, "anchor");
        this.anchor = anchor;
        this.basePopupX = i10;
        this.basePopupY = i11;
        this.baseAnchorRight = i12;
        this.baseAnchorBottom = i13;
        this.anchorLoc = new int[2];
        this.lastX = i10;
        this.lastY = i11;
    }

    public final void a(PopupWindow popup) {
        kotlin.jvm.internal.p.i(popup, "popup");
        if (this.observer != null) {
            return;
        }
        this.popup = popup;
        ViewTreeObserver viewTreeObserver = this.anchor.getViewTreeObserver();
        if (!viewTreeObserver.isAlive()) {
            viewTreeObserver = null;
        }
        if (viewTreeObserver == null) {
            return;
        }
        this.observer = viewTreeObserver;
        viewTreeObserver.addOnPreDrawListener(this);
    }

    public final void b() {
        this.popup = null;
        ViewTreeObserver viewTreeObserver = this.observer;
        if (viewTreeObserver == null) {
            return;
        }
        this.observer = null;
        if (viewTreeObserver.isAlive()) {
            viewTreeObserver.removeOnPreDrawListener(this);
        } else {
            this.anchor.getViewTreeObserver().removeOnPreDrawListener(this);
        }
    }

    @Override // android.view.ViewTreeObserver.OnPreDrawListener
    public boolean onPreDraw() {
        PopupWindow popupWindow = this.popup;
        if (popupWindow == null || !popupWindow.isShowing()) {
            return true;
        }
        this.anchor.getLocationInWindow(this.anchorLoc);
        GlassDropdownPosition glassDropdownPositionG = R5.g(this.basePopupX, this.basePopupY, this.baseAnchorRight, this.baseAnchorBottom, this.anchorLoc[0] + this.anchor.getWidth(), this.anchorLoc[1] + this.anchor.getHeight());
        if (glassDropdownPositionG.getX() != this.lastX || glassDropdownPositionG.getY() != this.lastY) {
            this.lastX = glassDropdownPositionG.getX();
            this.lastY = glassDropdownPositionG.getY();
            try {
                Result.Companion companion = Result.INSTANCE;
                popupWindow.update(glassDropdownPositionG.getX(), glassDropdownPositionG.getY(), -1, -1);
                Result.b(Y8.t.f7040a);
            } catch (Throwable th) {
                Result.Companion companion2 = Result.INSTANCE;
                Result.b(C4849c.a(th));
            }
        }
        return true;
    }
}
