package com.bytedance.android.ecom.arch.slice.render.elements.scrollbar;

import android.content.Context;
import android.util.AttributeSet;
import com.bytedance.android.ecom.arch.slice.render.elements.flexbox.SlcFlexElementView;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u0018\u00002\u00020\u0001B%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\b¨\u0006\t"}, d2 = {"Lcom/bytedance/android/ecom/arch/slice/render/elements/scrollbar/SlcScrollBarElementView;", "Lcom/bytedance/android/ecom/arch/slice/render/elements/flexbox/SlcFlexElementView;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "slice-render_release"}, k = 1, mv = {1, 1, 16})
public final class SlcScrollBarElementView extends SlcFlexElementView {
    public SlcScrollBarElementView(Context r100) {
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public SlcScrollBarElementView(Context r100, AttributeSet r101) {
        this(r100, r101, 4, 0);
    }

    public SlcScrollBarElementView(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
    }

    public /* synthetic */ SlcScrollBarElementView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
