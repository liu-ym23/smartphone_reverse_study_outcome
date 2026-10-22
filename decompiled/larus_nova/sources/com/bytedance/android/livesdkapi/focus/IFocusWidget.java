package com.bytedance.android.livesdkapi.focus;

import android.view.MotionEvent;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\u0010\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0006H&J(\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\fH&J\u0010\u0010\u000e\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u0006H&¨\u0006\u000f"}, d2 = {"Lcom/bytedance/android/livesdkapi/focus/IFocusWidget;", "", "canAdjustExposure", "", "isTapValid", "event", "Landroid/view/MotionEvent;", "onScroll", "", "e1", "e2", "distanceX", "", "distanceY", "onSingleTap", "livesdkapi_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface IFocusWidget {
    boolean canAdjustExposure();

    boolean isTapValid(MotionEvent r100);

    void onScroll(MotionEvent r100, MotionEvent r101, float r102, float r103);

    void onSingleTap(MotionEvent r100);
}
