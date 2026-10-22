package com.bytedance.android.live.liveinteract.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextSwitcher;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\r\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u001b\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\u0012\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0016J\u0012\u0010\u000b\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0016¨\u0006\f"}, d2 = {"Lcom/bytedance/android/live/liveinteract/view/MarqueeTextSwitcher;", "Landroid/widget/TextSwitcher;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attributeSet", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "setCurrentText", "", "text", "", "setText", "liveinteract-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class MarqueeTextSwitcher extends TextSwitcher {
    public MarqueeTextSwitcher(Context r100) {
        this(r100, null);
    }

    @Override // android.widget.TextSwitcher
    public void setCurrentText(CharSequence r100) {
        super.setCurrentText(r100);
        View r101 = getCurrentView();
        if ((r101 instanceof MarqueeTextView) == true) goto L5;
        r101 = null;
    L5:
        MarqueeTextView r102 = (MarqueeTextView) r101;
        if (r102 == null) goto L9;
        r102.setOriginText(r100);
        return;
    }

    @Override // android.widget.TextSwitcher
    public void setText(CharSequence r100) {
        super.setText(r100);
        View r101 = getCurrentView();
        if ((r101 instanceof MarqueeTextView) == true) goto L5;
        r101 = null;
    L5:
        MarqueeTextView r102 = (MarqueeTextView) r101;
        if (r102 == null) goto L9;
        r102.setOriginText(r100);
        return;
    }

    public MarqueeTextSwitcher(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101);
    }
}
