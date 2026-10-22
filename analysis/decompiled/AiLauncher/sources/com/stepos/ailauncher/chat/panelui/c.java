package com.stepos.ailauncher.chat.panelui;

import android.app.Dialog;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.ailauncher.chat.voice.support.C3081a;
import h8.C4148a;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.Result;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\bR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\nR\u0016\u0010\f\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\f\u0010\rR\u0016\u0010\u000f\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0011\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0011\u0010\u0010R\u0016\u0010\u0012\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013¨\u0006\u0014"}, d2 = {"Lcom/stepos/ailauncher/chat/panelui/c;", "Lcom/stepos/ailauncher/chat/panelui/t;", "Landroid/app/Dialog;", C3081a.FOCUS_DIALOG_NAME, "<init>", "(Landroid/app/Dialog;)V", "", Const.INTENT_KEY_APIKEY, "()Z", "resume", "Landroid/app/Dialog;", "", "savedFlags", "I", "", "savedAlpha", "F", "savedDimAmount", "suspended", "Z", "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class c implements t {
    private final Dialog dialog;
    private float savedAlpha;
    private float savedDimAmount;
    private int savedFlags;
    private boolean suspended;

    public c(Dialog dialog) {
        kotlin.jvm.internal.p.i(dialog, "dialog");
        this.dialog = dialog;
        this.savedAlpha = 1.0f;
    }

    @Override // com.stepos.ailauncher.chat.panelui.t
    public boolean a() {
        Object objB;
        if (!this.dialog.isShowing()) {
            return false;
        }
        if (this.suspended) {
            return true;
        }
        Window window = this.dialog.getWindow();
        if (window == null) {
            return false;
        }
        try {
            Result.Companion companion = Result.INSTANCE;
            View currentFocus = this.dialog.getCurrentFocus();
            if (currentFocus != null) {
                Object systemService = currentFocus.getContext().getSystemService("input_method");
                InputMethodManager inputMethodManager = systemService instanceof InputMethodManager ? (InputMethodManager) systemService : null;
                if (inputMethodManager != null) {
                    inputMethodManager.hideSoftInputFromWindow(currentFocus.getWindowToken(), 0);
                }
                currentFocus.clearFocus();
            }
            WindowManager.LayoutParams attributes = window.getAttributes();
            int i10 = attributes.flags;
            this.savedFlags = i10;
            this.savedAlpha = attributes.alpha;
            this.savedDimAmount = attributes.dimAmount;
            attributes.flags = (i10 & (-262147)) | 24;
            attributes.alpha = 0.0f;
            attributes.dimAmount = 0.0f;
            window.setAttributes(attributes);
            window.clearFlags(262146);
            window.addFlags(24);
            this.suspended = true;
            objB = Result.b(Boolean.TRUE);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objB = Result.b(C4849c.a(th));
        }
        Throwable thE = Result.e(objB);
        if (thE != null) {
            C4148a.t("PanelLayerVisibility", "dialog suspend failed", thE, false, 8, null);
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
        if (!this.suspended) {
            return true;
        }
        Window window = this.dialog.getWindow();
        if (window == null) {
            return false;
        }
        try {
            Result.Companion companion = Result.INSTANCE;
            WindowManager.LayoutParams attributes = window.getAttributes();
            attributes.flags = this.savedFlags;
            attributes.alpha = this.savedAlpha;
            attributes.dimAmount = this.savedDimAmount;
            window.setAttributes(attributes);
            window.setDimAmount(this.savedDimAmount);
            if ((this.savedFlags & 2) != 0) {
                window.addFlags(2);
            }
            this.suspended = false;
            objB = Result.b(Boolean.TRUE);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objB = Result.b(C4849c.a(th));
        }
        Throwable thE = Result.e(objB);
        if (thE != null) {
            C4148a.t("PanelLayerVisibility", "dialog resume failed", thE, false, 8, null);
        }
        Boolean bool = Boolean.FALSE;
        if (Result.g(objB)) {
            objB = bool;
        }
        return ((Boolean) objB).booleanValue();
    }
}
