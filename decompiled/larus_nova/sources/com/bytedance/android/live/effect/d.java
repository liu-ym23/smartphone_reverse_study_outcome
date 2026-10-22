package com.bytedance.android.live.effect;

import android.view.View;
import android.widget.FrameLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;

/* JADX INFO: loaded from: classes45.dex */
public final class d implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ View f67995a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ LiveBeautifyDialogFragment f67996b;

    public static final class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ d f67997a;

        public a(d r100) {
            this.f67997a = r100;
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
            this.f67997a.f67996b.dismiss();     // Catch: Exception -> L5 Throwable -> L10
        L20:
            return;
        L5:
            e = move-exception;
            com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_EXCEPTION");     // Catch: Throwable -> L10
            Throwable r100 = DialogFragmentLancet.sLastShowStack;     // Catch: Throwable -> L10
            if (r100 == null) goto L13;
            com.bytedance.crash.d.d(r100, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");     // Catch: Throwable -> L10
            return;
        }
    }

    public d(View r100, LiveBeautifyDialogFragment r101) {
        this.f67995a = r100;
        this.f67996b = r101;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        FrameLayout r101 = (FrameLayout) this.f67995a.findViewById(R.id.feedback_container);
        if (r101 == null) goto L5;
        r101.setVisibility(4);
    L5:
        ConstraintLayout r102 = (ConstraintLayout) this.f67996b.S90(R.id.ll_beauty_mode);
        if (r102 == null) goto L8;
        r102.setVisibility(4);
    L8:
        ConstraintLayout r103 = (ConstraintLayout) this.f67996b.S90(R.id.ll_beauty_mode);
        if (r103 == null) goto L12;
        r103.post(new a(this));
        return;
    }
}
