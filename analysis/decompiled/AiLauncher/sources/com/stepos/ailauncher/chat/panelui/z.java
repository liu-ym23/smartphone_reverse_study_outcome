package com.stepos.ailauncher.chat.panelui;

import android.view.View;
import com.autonavi.aps.amapapi.config.Const;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\bR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\nR\u0016\u0010\f\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\f\u0010\rR\u0016\u0010\u000e\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, d2 = {"Lcom/stepos/ailauncher/chat/panelui/z;", "Lcom/stepos/ailauncher/chat/panelui/t;", "Landroid/view/View;", "view", "<init>", "(Landroid/view/View;)V", "", Const.INTENT_KEY_APIKEY, "()Z", "resume", "Landroid/view/View;", "", "savedVisibility", "I", "suspended", "Z", "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class z implements t {
    private int savedVisibility;
    private boolean suspended;
    private final View view;

    public z(View view) {
        kotlin.jvm.internal.p.i(view, "view");
        this.view = view;
    }

    @Override // com.stepos.ailauncher.chat.panelui.t
    public boolean a() {
        if (!this.view.isAttachedToWindow()) {
            return false;
        }
        if (this.suspended) {
            return true;
        }
        this.savedVisibility = this.view.getVisibility();
        this.view.setVisibility(4);
        this.suspended = true;
        return true;
    }

    @Override // com.stepos.ailauncher.chat.panelui.t
    public boolean resume() {
        if (!this.view.isAttachedToWindow()) {
            return false;
        }
        if (!this.suspended) {
            return true;
        }
        this.view.setVisibility(this.savedVisibility);
        this.suspended = false;
        return true;
    }
}
