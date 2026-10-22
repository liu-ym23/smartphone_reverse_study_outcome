package com.bytedance.android.livesdk.chatroom.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout;
import com.bytedance.android.livesdk.log.b0;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;

/* JADX INFO: loaded from: classes8.dex */
public class MonitorRelativeLayout extends RelativeLayout {

    public interface a {
    }

    public void setOnSizeChangeListener(a r100) {
    }

    public MonitorRelativeLayout(Context r100) {
        super(r100);
    }

    @Override // android.view.View
    public void setVisibility(int r100) {
        super.setVisibility(r100);
        if (r100 == 0) goto L6;
        b0 r101 = b0.o();
        String r102 = "on Text message Widget Container visibility set to  : " + r100 + " by" + ThreadMethodProxy.currentThread().getStackTrace()[0].getMethodName();
        r101.getClass();
        com.bytedance.android.live.core.log.g.i("ttlive_comment", r102);
        return;
    }

    public MonitorRelativeLayout(Context r100, AttributeSet r101) {
        super(r100, r101);
    }

    @Override // android.view.View
    public final void onVisibilityChanged(View r100, int r101) {
        super.onVisibilityChanged(r100, r101);
        if (r101 == 0) goto L6;
        b0.o().getClass();
        com.bytedance.android.live.core.log.g.i("ttlive_comment", "on Text message Widget Container visibility changed : " + r101);
        return;
    }

    public MonitorRelativeLayout(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
    }

    @Override // android.view.View
    public final void onSizeChanged(int r100, int r101, int r102, int r103) {
        super.onSizeChanged(r100, r101, r102, r103);
    }
}
