package com.obric.oui.dialog.base;

import android.content.Context;
import androidx.annotation.RequiresApi;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes4.dex */
@RequiresApi(30)
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0007\b'\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0006H\u0014¢\u0006\u0004\b\t\u0010\bR\"\u0010\r\u001a\u00020\n8\u0004@\u0004X\u0084\u000e¢\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010¨\u0006\u0011"}, d2 = {"Lcom/obric/oui/dialog/base/OBaseDialogModal;", "Lcom/obric/oui/dialog/base/AbstractDialogModal;", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "", "dismiss", "()V", "l", "", "E", "Z", "isDismissing", "()Z", "setDismissing", "(Z)V", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public abstract class OBaseDialogModal extends AbstractDialogModal {
    public boolean E;

    public OBaseDialogModal(@NotNull Context r10) {
        q.g(r10, "context");
        super(r10, false, false);
    }

    @Override // com.obric.oui.dialog.base.AbstractDialogModal, android.content.DialogInterface
    public void dismiss() {
        if (this.E == false) goto L5;
        return;
    L5:
        this.E = true;
        super.dismiss();
    }

    @Override // com.obric.oui.dialog.base.AbstractDialogModal
    public void l() {
        this.E = false;
        super.l();
    }

    public final void setDismissing(boolean r10) {
        this.E = r10;
    }
}
