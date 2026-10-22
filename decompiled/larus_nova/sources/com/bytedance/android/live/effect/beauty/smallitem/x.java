package com.bytedance.android.live.effect.beauty.smallitem;

import android.graphics.Rect;
import android.view.TouchDelegate;
import com.bytedance.android.livesdk.chatroom.ui.LiveSwitchButton;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes45.dex */
public final class x implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ LiveSmallItemBeautyAdapter.b f67736a;

    public x(LiveSmallItemBeautyAdapter.b r100) {
        this.f67736a = r100;
    }

    @Override // java.lang.Runnable
    public final void run() {
        LiveSwitchButton r100 = (LiveSwitchButton) this.f67736a.itemView.findViewById(R.id.switch_button);     // Catch: Throwable -> L6
        if (r100 == null) goto L9;
        Rect r101 = new Rect();     // Catch: Throwable -> L6
        this.f67736a.itemView.getHitRect(r101);     // Catch: Throwable -> L6
        TouchDelegate r102 = new TouchDelegate(r101, r100);     // Catch: Throwable -> L6
        this.f67736a.itemView.setTouchDelegate(r102);     // Catch: Throwable -> L6
        return;
    L9:
        return;
    L6:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L13;
        throw th;
    }
}
