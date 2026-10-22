package com.android.ttcjpaysdk.base.utils;

import android.text.style.ClickableSpan;
import android.view.View;
import com.bytedance.ee.bear.lynx.impl.xbridge.method.view.SendEventContainerMethodParamModel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b&\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH&J\u0010\u0010\u000b\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/android/ttcjpaysdk/base/utils/CJPayDebouncingClickableSpan;", "Landroid/text/style/ClickableSpan;", "()V", "MIN_CLICK_DELAY_TIME", "", "lastClickTime", "", "doClick", "", "widget", "Landroid/view/View;", SendEventContainerMethodParamModel.EventKinds.onClick, "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public abstract class CJPayDebouncingClickableSpan extends ClickableSpan {
    private final int MIN_CLICK_DELAY_TIME;
    private long lastClickTime;

    public abstract void doClick(View r100);

    public CJPayDebouncingClickableSpan() {
        this.MIN_CLICK_DELAY_TIME = 500;
    }

    @Override // android.text.style.ClickableSpan
    public void onClick(View r110) {
        Intrinsics.checkNotNullParameter(r110, "widget");
        long r100 = System.currentTimeMillis();
        if (r100 <= 0) goto L11;
        long r101 = this.lastClickTime;
        if (r101 < 0) goto L11;
        if ((r100 - r101) < 0) goto L11;
        if ((r100 - r101) >= this.MIN_CLICK_DELAY_TIME) goto L11;
        boolean r102 = false;
    L12:
        if (r102 == false) goto L15;
        this.lastClickTime = r100;
        doClick(r110);
        return;
    L15:
        return;
    L11:
        r102 = true;
        goto L12
    }
}
