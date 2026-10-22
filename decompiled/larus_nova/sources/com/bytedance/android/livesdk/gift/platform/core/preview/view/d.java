package com.bytedance.android.livesdk.gift.platform.core.preview.view;

import android.view.View;
import com.bytedance.android.live.core.utils.MainThreadPostUtils;
import com.larus.apm.impl.protector.RunnableProtector;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;

/* JADX INFO: loaded from: classes9.dex */
public final class d implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ UgcGiftPoolDialog f131087a;

    public static final class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ d f131088a;

        public a(d r100) {
            this.f131088a = r100;
        }

        @Override // java.lang.Runnable
        public final void run() {
        L10:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L19;
            throw th;
        L19:
            return;
        L15:
            this.f131088a.f131087a.dismissAllowingStateLoss();     // Catch: Exception -> L5 Throwable -> L10
        L20:
            return;
        L5:
            e = move-exception;
            com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_ALLOWING_STATE_LOSS_EXCEPTION");     // Catch: Throwable -> L10
            Throwable r100 = DialogFragmentLancet.sLastShowStack;     // Catch: Throwable -> L10
            if (r100 == null) goto L13;
            com.bytedance.crash.d.d(r100, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");     // Catch: Throwable -> L10
            return;
        }
    }

    public d(UgcGiftPoolDialog r100) {
        this.f131087a = r100;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        View r101 = this.f131087a.f131011k;
        if (r101 == null) goto L5;
        r101.setVisibility(8);
    L5:
        UgcGiftPoolDialog r102 = this.f131087a;
        int r103 = UgcGiftPoolDialog.f131034r;
        r102.T90();
        MainThreadPostUtils.c(new a(this), 50);
    }
}
