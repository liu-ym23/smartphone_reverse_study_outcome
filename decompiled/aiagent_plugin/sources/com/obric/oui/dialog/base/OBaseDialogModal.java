package com.obric.oui.dialog.base;

import android.content.Context;
import android.view.ViewGroup;
import com.obric.oui.button.OButton;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.a.b;
import d.h.b.o;
import d.x;

/* JADX INFO: compiled from: OBaseDialogModal.kt */
/* JADX INFO: loaded from: classes4.dex */
public abstract class OBaseDialogModal extends AbstractDialogModal {
    private boolean isDismissing;

    /* JADX INFO: compiled from: OBaseDialogModal.kt */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f35098a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final d.h.a.a<x> f35099b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final b<OButton, x> f35100c;

        public final String a() {
            return this.f35098a;
        }

        public final d.h.a.a<x> b() {
            return this.f35099b;
        }

        public final b<OButton, x> c() {
            return this.f35100c;
        }
    }

    public OBaseDialogModal(Context r3) {
        Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
        o.e(r4, "context");
        super(r4, false, false);
    }

    public final boolean isDismissing() {
        return this.isDismissing;
    }

    public final void setDismissing(boolean r1) {
        this.isDismissing = r1;
    }

    @Override // com.obric.oui.dialog.base.AbstractDialogModal
    public void show(ViewGroup r2) {
        this.isDismissing = false;
        super.show(r2);
    }

    @Override // com.obric.oui.dialog.base.AbstractDialogModal, android.content.DialogInterface
    public void dismiss() {
        if (this.isDismissing == false) goto L5;
        return;
    L5:
        this.isDismissing = true;
        super.dismiss();
    }

    @Override // com.obric.oui.dialog.base.AbstractDialogModal
    public void originDismiss() {
        this.isDismissing = false;
        super.originDismiss();
    }
}
