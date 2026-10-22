package com.bytedance.android.live.uikit.layout;

import android.content.Context;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.widget.FrameLayout;

/* JADX INFO: loaded from: classes7.dex */
public class FullscreenVideoFrame extends FrameLayout {
    private Listener mListener;

    public interface Listener {
        void onHideFullscreenVideoFrame();
    }

    private void init() {
        setFocusable(true);
        setFocusableInTouchMode(true);
    }

    public FullscreenVideoFrame(Context r100) {
        super(r100);
        init();
    }

    public void setListener(Listener r100) {
        this.mListener = r100;
    }

    public FullscreenVideoFrame(Context r100, AttributeSet r101) {
        super(r100, r101);
        init();
    }

    @Override // android.view.View, android.view.KeyEvent.Callback
    public boolean onKeyDown(int r100, KeyEvent r101) {
        if (r100 != 4) goto L10;
        Listener r102 = this.mListener;
        if (r102 == null) goto L11;
        r102.onHideFullscreenVideoFrame();
        return true;
    L11:
        return true;
    L10:
        return super.onKeyDown(r100, r101);
    }

    @Override // android.view.View, android.view.KeyEvent.Callback
    public boolean onKeyUp(int r100, KeyEvent r101) {
        if (r100 != 4) goto L7;
        return true;
    L7:
        return super.onKeyUp(r100, r101);
    }

    public FullscreenVideoFrame(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
        init();
    }
}
