package androidx.appcompat.widget;

import android.graphics.Rect;

/* JADX INFO: loaded from: classes2.dex */
public interface FitWindowsViewGroup {

    public interface OnFitSystemWindowsListener {
        void onFitSystemWindows(Rect r100);
    }

    void setOnFitSystemWindowsListener(OnFitSystemWindowsListener r100);
}
