package com.android.ttcjpaysdk.base.framework;

import android.content.Context;
import android.view.View;
import android.view.Window;
import com.bytedance.android.livesdk.end.LiveEndPageData;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J \u0010\t\u001a\u00020\u00002\u0006\u0010\u0007\u001a\u00020\b2\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\f\u001a\u00020\rJ\u000e\u0010\u000e\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0004R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/android/ttcjpaysdk/base/framework/CJKeyboardStateHelper;", "", "()V", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "keyboardStatePopupWindow", "Lcom/android/ttcjpaysdk/base/framework/KeyboardStatePopupWindow;", "rootView", "Landroid/view/View;", "bindRootLayout", LiveEndPageData.TAG_WINDOW, "Landroid/view/Window;", "listener", "Lcom/android/ttcjpaysdk/base/framework/KeyboardStatePopupWindow$OnKeyboardStateListener;", "init", "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class CJKeyboardStateHelper {
    private Context context;
    private KeyboardStatePopupWindow keyboardStatePopupWindow;
    private View rootView;

    public CJKeyboardStateHelper() {
    }

    public final CJKeyboardStateHelper init(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this.context = r100;
        return this;
    }

    public final CJKeyboardStateHelper bindRootLayout(View r100, Window r110, KeyboardStatePopupWindow.OnKeyboardStateListener r111) {
        Intrinsics.checkNotNullParameter(r100, "rootView");
        Intrinsics.checkNotNullParameter(r111, "listener");
        this.rootView = r100;
        Context r101 = this.context;
        if (r101 != null) goto L5;
        r101 = r100.getContext();
    L5:
        KeyboardStatePopupWindow r102 = new KeyboardStatePopupWindow(r101, r100, r110, null, 8, null);
        this.keyboardStatePopupWindow = r102;
        r102.setOnKeyboardStateListener(r111);
        return this;
    }
}
