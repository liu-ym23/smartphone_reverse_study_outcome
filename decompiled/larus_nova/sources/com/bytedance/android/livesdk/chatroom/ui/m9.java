package com.bytedance.android.livesdk.chatroom.ui;

import android.view.View;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes8.dex */
public final class m9 implements View.OnFocusChangeListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ TicketPriceInputDialogFragment f113725a;

    public static final class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ m9 f113726a;

        public a(m9 r100) {
            this.f113726a = r100;
        }

        @Override // java.lang.Runnable
        public final void run() {
            TicketPriceInputDialogFragment r100 = this.f113726a.f113725a;     // Catch: Throwable -> L7
            if (r100.f112555f != null) goto L5;
            i40.h.a("show key board return, edit text view null");     // Catch: Throwable -> L7
        L12:
            return;
        L5:
            com.bytedance.android.livesdk.utils.t2.b(r100.getContext(), r100.f112555f);     // Catch: Throwable -> L7
        L7:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L15;
            throw th;
        }
    }

    public m9(TicketPriceInputDialogFragment r100) {
        this.f113725a = r100;
    }

    @Override // android.view.View.OnFocusChangeListener
    public final void onFocusChange(View r100, boolean r101) {
        r100.postDelayed(new a(this), 100);
        r100.setOnFocusChangeListener(null);
    }
}
