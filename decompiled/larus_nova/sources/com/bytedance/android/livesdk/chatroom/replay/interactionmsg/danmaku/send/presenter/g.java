package com.bytedance.android.livesdk.chatroom.replay.interactionmsg.danmaku.send.presenter;

import android.view.View;
import com.bytedance.android.livesdk.chatroom.replay.interactionmsg.danmaku.send.PanelType;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes7.dex */
public final class g implements View.OnFocusChangeListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ InputDanmuTextPresenter f109135a;

    public static final class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ g f109136a;

        public a(g r100) {
            this.f109136a = r100;
        }

        @Override // java.lang.Runnable
        public final void run() {
        L7:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L14;
            throw th;
        L14:
            return;
        L3:
            if (this.f109136a.f109135a.l().L6() == false) goto L10;
            this.f109136a.f109135a.h().b(PanelType.KEYBOARD, InputDanmuTextPresenter.n(this.f109136a.f109135a));     // Catch: Throwable -> L7
            return;
        }
    }

    public g(InputDanmuTextPresenter r100) {
        this.f109135a = r100;
    }

    @Override // android.view.View.OnFocusChangeListener
    public final void onFocusChange(View r100, boolean r101) {
        r100.postDelayed(new a(this), 100);
        InputDanmuTextPresenter.n(this.f109135a).setOnFocusChangeListener(null);
    }
}
