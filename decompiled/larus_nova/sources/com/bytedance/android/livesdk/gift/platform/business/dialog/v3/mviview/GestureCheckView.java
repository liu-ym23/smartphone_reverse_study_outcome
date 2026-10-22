package com.bytedance.android.livesdk.gift.platform.business.dialog.v3.mviview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lcom/bytedance/android/livesdk/gift/platform/business/dialog/v3/mviview/GestureCheckView;", "Landroid/view/View;", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "livegift-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class GestureCheckView extends View {
    public GestureCheckView(Context r100) {
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public GestureCheckView(Context r100, AttributeSet r101) {
        this(r100, r101, 4, 0);
    }

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent r100) {
        Context r101 = getContext();
        Object r102 = null;
        if (r101 == null) goto L5;
        Object r103 = r101.getSystemService("input_method");
    L7:
        if ((r103 instanceof InputMethodManager) == false) goto L10;
        r102 = r103;
    L10:
        InputMethodManager r104 = (InputMethodManager) r102;
        if (r104 == null) goto L13;
        r104.hideSoftInputFromWindow(getWindowToken(), 0);
    L13:
        return false;
    L5:
        r103 = null;
        goto L7
    }

    public GestureCheckView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
    }

    public /* synthetic */ GestureCheckView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
