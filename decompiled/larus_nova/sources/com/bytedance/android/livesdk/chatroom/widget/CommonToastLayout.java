package com.bytedance.android.livesdk.chatroom.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import com.bytedance.android.livesdk.chatroom.bl.PlatformMessageHelper;

/* JADX INFO: loaded from: classes8.dex */
public class CommonToastLayout extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public a f118471a;

    public interface a {
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        a r100 = this.f118471a;
        if (r100 == null) goto L6;
        ((com.bytedance.android.livesdk.chatroom.viewmodule.d0) r100).getClass();
        PlatformMessageHelper.INSTANCE.onMessageFinish();
        return;
    }

    public void setOnDetachListener(a r100) {
        this.f118471a = r100;
    }

    public CommonToastLayout(Context r100, AttributeSet r101) {
        super(r100, r101);
    }
}
